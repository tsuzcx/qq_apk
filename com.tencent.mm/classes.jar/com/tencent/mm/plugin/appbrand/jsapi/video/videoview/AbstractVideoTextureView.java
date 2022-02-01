package com.tencent.mm.plugin.appbrand.jsapi.video.videoview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public abstract class AbstractVideoTextureView
  extends TextureView
  implements a
{
  private int atW;
  private float bdQ = -1.0F;
  private boolean cuH;
  protected com.tencent.mm.plugin.appbrand.jsapi.video.e.b cuu = null;
  private boolean fMP = false;
  private boolean isd = false;
  private boolean lsA;
  private a.a lsB;
  private a.e lsC;
  private a.c lsD;
  private a.b lsE;
  private a.d lsF;
  private long lsG = 0L;
  private int lsH = 0;
  private boolean lsI = false;
  private b.h lsJ = new b.h()
  {
    public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramAnonymousb, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(206458);
      try
      {
        if (paramAnonymousb != AbstractVideoTextureView.this.cuu)
        {
          ad.w("MicroMsg.Video.AbstractVideoTextureView", "another player on video size changed, return now.[%s, %s]", new Object[] { paramAnonymousb, AbstractVideoTextureView.this.cuu });
          AppMethodBeat.o(206458);
          return;
        }
        AbstractVideoTextureView.a(AbstractVideoTextureView.this, paramAnonymousb.getVideoWidth());
        AbstractVideoTextureView.b(AbstractVideoTextureView.this, paramAnonymousb.getVideoHeight());
        ad.i("MicroMsg.Video.AbstractVideoTextureView", "on size change size:( " + AbstractVideoTextureView.a(AbstractVideoTextureView.this) + " , " + AbstractVideoTextureView.b(AbstractVideoTextureView.this) + " )");
        if (AbstractVideoTextureView.c(AbstractVideoTextureView.this) != null) {
          AbstractVideoTextureView.c(AbstractVideoTextureView.this).eb(AbstractVideoTextureView.a(AbstractVideoTextureView.this), AbstractVideoTextureView.b(AbstractVideoTextureView.this));
        }
      }
      catch (Exception paramAnonymousb)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.Video.AbstractVideoTextureView", paramAnonymousb, "on video size changed error[%d, %d]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        }
      }
      AbstractVideoTextureView.d(AbstractVideoTextureView.this);
      AppMethodBeat.o(206458);
    }
  };
  private b.f lsK = new b.f()
  {
    public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramAnonymousb)
    {
      AppMethodBeat.i(206459);
      if (paramAnonymousb != AbstractVideoTextureView.this.cuu)
      {
        ad.w("MicroMsg.Video.AbstractVideoTextureView", "another player callback, release now.[%s, %s]", new Object[] { paramAnonymousb, AbstractVideoTextureView.this.cuu });
        AbstractVideoTextureView.a(AbstractVideoTextureView.this, paramAnonymousb);
        AppMethodBeat.o(206459);
        return;
      }
      AbstractVideoTextureView.e(AbstractVideoTextureView.this);
      AbstractVideoTextureView.a(AbstractVideoTextureView.this, paramAnonymousb.getVideoWidth());
      AbstractVideoTextureView.b(AbstractVideoTextureView.this, paramAnonymousb.getVideoHeight());
      ad.i("MicroMsg.Video.AbstractVideoTextureView", "on prepared. size [%d, %d] mStartWhenPrepared %b ", new Object[] { Integer.valueOf(AbstractVideoTextureView.a(AbstractVideoTextureView.this)), Integer.valueOf(AbstractVideoTextureView.b(AbstractVideoTextureView.this)), Boolean.valueOf(AbstractVideoTextureView.f(AbstractVideoTextureView.this)) });
      AbstractVideoTextureView.d(AbstractVideoTextureView.this);
      if ((AbstractVideoTextureView.a(AbstractVideoTextureView.this) != 0) && (AbstractVideoTextureView.b(AbstractVideoTextureView.this) != 0)) {
        if (AbstractVideoTextureView.f(AbstractVideoTextureView.this))
        {
          AbstractVideoTextureView.this.cuu.start();
          AbstractVideoTextureView.this.cuu.setLooping(AbstractVideoTextureView.g(AbstractVideoTextureView.this));
          AbstractVideoTextureView.h(AbstractVideoTextureView.this);
        }
      }
      for (;;)
      {
        if (AbstractVideoTextureView.c(AbstractVideoTextureView.this) != null) {
          AbstractVideoTextureView.c(AbstractVideoTextureView.this).ta();
        }
        AppMethodBeat.o(206459);
        return;
        if (AbstractVideoTextureView.f(AbstractVideoTextureView.this))
        {
          AbstractVideoTextureView.this.cuu.start();
          AbstractVideoTextureView.h(AbstractVideoTextureView.this);
          AbstractVideoTextureView.this.cuu.setLooping(AbstractVideoTextureView.g(AbstractVideoTextureView.this));
        }
      }
    }
  };
  private b.g lsL = new b.g()
  {
    public final void b(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramAnonymousb)
    {
      AppMethodBeat.i(206460);
      ad.i("MicroMsg.Video.AbstractVideoTextureView", "video seek complete curPos[%d] mStartWhenPrepared[%b] pauseWhenUpdated[%b]", new Object[] { Integer.valueOf(paramAnonymousb.getCurrentPosition()), Boolean.valueOf(AbstractVideoTextureView.f(AbstractVideoTextureView.this)), Boolean.valueOf(AbstractVideoTextureView.i(AbstractVideoTextureView.this)) });
      if (AbstractVideoTextureView.f(AbstractVideoTextureView.this))
      {
        if (AbstractVideoTextureView.i(AbstractVideoTextureView.this))
        {
          AppMethodBeat.o(206460);
          return;
        }
        AbstractVideoTextureView.this.start();
      }
      for (;;)
      {
        if (AbstractVideoTextureView.j(AbstractVideoTextureView.this) != null) {
          AbstractVideoTextureView.j(AbstractVideoTextureView.this).eU(AbstractVideoTextureView.f(AbstractVideoTextureView.this));
        }
        AbstractVideoTextureView.a(AbstractVideoTextureView.this, 0L);
        AppMethodBeat.o(206460);
        return;
        AbstractVideoTextureView.this.pause();
      }
    }
  };
  private b.a lsM = new b.a()
  {
    public final void gM(int paramAnonymousInt)
    {
      AppMethodBeat.i(206461);
      ad.d("MicroMsg.Video.AbstractVideoTextureView", "onBufferingUpdate percent[%d]", new Object[] { Integer.valueOf(paramAnonymousInt) });
      AbstractVideoTextureView.c(AbstractVideoTextureView.this, paramAnonymousInt);
      AppMethodBeat.o(206461);
    }
  };
  private b.e lsN = new b.e()
  {
    public final boolean ca(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(206462);
      ad.d("MicroMsg.Video.AbstractVideoTextureView", "onInfo [%d %d]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
      if (AbstractVideoTextureView.k(AbstractVideoTextureView.this) != null) {
        AbstractVideoTextureView.k(AbstractVideoTextureView.this).ec(paramAnonymousInt1, paramAnonymousInt2);
      }
      AppMethodBeat.o(206462);
      return false;
    }
  };
  private b.b lsO = new b.b()
  {
    public final void GB()
    {
      AppMethodBeat.i(206463);
      ad.i("MicroMsg.Video.AbstractVideoTextureView", "video on completion");
      AbstractVideoTextureView.b(AbstractVideoTextureView.this, bt.aQJ());
      if (AbstractVideoTextureView.c(AbstractVideoTextureView.this) != null) {
        AbstractVideoTextureView.c(AbstractVideoTextureView.this).onCompletion();
      }
      AppMethodBeat.o(206463);
    }
  };
  private b.d lsP = new b.d()
  {
    public final boolean cb(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(206464);
      ad.w("MicroMsg.Video.AbstractVideoTextureView", "Error: " + paramAnonymousInt1 + "," + paramAnonymousInt2);
      if (AbstractVideoTextureView.c(AbstractVideoTextureView.this) != null) {
        AbstractVideoTextureView.c(AbstractVideoTextureView.this).onError(paramAnonymousInt1, paramAnonymousInt2);
      }
      AppMethodBeat.o(206464);
      return true;
    }
  };
  private long lsQ = 0L;
  private boolean lsR = false;
  private boolean lsS = false;
  private boolean lsT = false;
  private TextureView.SurfaceTextureListener lsU = new TextureView.SurfaceTextureListener()
  {
    public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(206468);
      AbstractVideoTextureView.this.h(AbstractVideoTextureView.s(AbstractVideoTextureView.this));
      AbstractVideoTextureView.a(AbstractVideoTextureView.this, new Surface(paramAnonymousSurfaceTexture));
      ad.i("MicroMsg.Video.AbstractVideoTextureView", "%d on texture available %d*%d mIsPrepared[%b] mSurface[%d] ", new Object[] { Integer.valueOf(AbstractVideoTextureView.this.hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Boolean.valueOf(AbstractVideoTextureView.r(AbstractVideoTextureView.this)), Integer.valueOf(AbstractVideoTextureView.s(AbstractVideoTextureView.this).hashCode()) });
      if ((AbstractVideoTextureView.this.cuu == null) || (!AbstractVideoTextureView.r(AbstractVideoTextureView.this)))
      {
        AbstractVideoTextureView.u(AbstractVideoTextureView.this);
        if (AbstractVideoTextureView.w(AbstractVideoTextureView.this) != null) {
          AbstractVideoTextureView.w(AbstractVideoTextureView.this).aMx();
        }
        AppMethodBeat.o(206468);
        return;
      }
      AbstractVideoTextureView.this.cuu.setSurface(AbstractVideoTextureView.s(AbstractVideoTextureView.this));
      if (AbstractVideoTextureView.v(AbstractVideoTextureView.this)) {
        AbstractVideoTextureView.this.cuu.start();
      }
      for (;;)
      {
        AbstractVideoTextureView.b(AbstractVideoTextureView.this, false);
        break;
        AbstractVideoTextureView.a(AbstractVideoTextureView.this, true);
        AbstractVideoTextureView.this.cuu.setVolume(0.0F, 0.0F);
        AbstractVideoTextureView.this.cuu.start();
      }
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
    {
      AppMethodBeat.i(206467);
      ad.i("MicroMsg.Video.AbstractVideoTextureView", "%d on texture destroyed mIsPrepared[%b]", new Object[] { Integer.valueOf(AbstractVideoTextureView.this.hashCode()), Boolean.valueOf(AbstractVideoTextureView.r(AbstractVideoTextureView.this)) });
      AbstractVideoTextureView.this.h(AbstractVideoTextureView.s(AbstractVideoTextureView.this));
      AbstractVideoTextureView.a(AbstractVideoTextureView.this, null);
      if ((AbstractVideoTextureView.this.cuu != null) && (AbstractVideoTextureView.r(AbstractVideoTextureView.this))) {
        if (AbstractVideoTextureView.this.isPlaying())
        {
          AbstractVideoTextureView.b(AbstractVideoTextureView.this, true);
          AbstractVideoTextureView.this.cuu.pause();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(206467);
        return false;
        AbstractVideoTextureView.t(AbstractVideoTextureView.this);
        AbstractVideoTextureView.b(AbstractVideoTextureView.this, false);
      }
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(206466);
      ad.i("MicroMsg.Video.AbstractVideoTextureView", "on texture size changed width : " + paramAnonymousInt1 + " height : " + paramAnonymousInt2);
      if ((AbstractVideoTextureView.this.cuu != null) && (AbstractVideoTextureView.r(AbstractVideoTextureView.this)) && (AbstractVideoTextureView.a(AbstractVideoTextureView.this) == paramAnonymousInt1) && (AbstractVideoTextureView.b(AbstractVideoTextureView.this) == paramAnonymousInt2)) {
        AbstractVideoTextureView.this.cuu.start();
      }
      AppMethodBeat.o(206466);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture)
    {
      AppMethodBeat.i(206465);
      ad.d("MicroMsg.Video.AbstractVideoTextureView", "on surface texture updated");
      if (AbstractVideoTextureView.i(AbstractVideoTextureView.this)) {
        if (AbstractVideoTextureView.this.cuu != null)
        {
          AbstractVideoTextureView.this.cuu.pause();
          if (!AbstractVideoTextureView.l(AbstractVideoTextureView.this)) {
            break label227;
          }
          AbstractVideoTextureView.this.cuu.setVolume(0.0F, 0.0F);
        }
      }
      for (;;)
      {
        AbstractVideoTextureView.a(AbstractVideoTextureView.this, false);
        if ((AbstractVideoTextureView.m(AbstractVideoTextureView.this) > 0L) && (AbstractVideoTextureView.n(AbstractVideoTextureView.this) != null))
        {
          AbstractVideoTextureView.n(AbstractVideoTextureView.this).boT();
          AbstractVideoTextureView.o(AbstractVideoTextureView.this);
        }
        AbstractVideoTextureView.a(AbstractVideoTextureView.this, System.currentTimeMillis());
        if (AbstractVideoTextureView.p(AbstractVideoTextureView.this))
        {
          ad.i("MicroMsg.Video.AbstractVideoTextureView", "%d flush surface pause now time[%d]", new Object[] { Integer.valueOf(AbstractVideoTextureView.this.hashCode()), Integer.valueOf(AbstractVideoTextureView.this.getCurrentPosition()) });
          if (AbstractVideoTextureView.this.cuu != null)
          {
            AbstractVideoTextureView.this.cuu.pause();
            AbstractVideoTextureView.this.setMute(AbstractVideoTextureView.l(AbstractVideoTextureView.this));
          }
          AbstractVideoTextureView.q(AbstractVideoTextureView.this);
        }
        AppMethodBeat.o(206465);
        return;
        label227:
        AbstractVideoTextureView.this.cuu.setVolume(1.0F, 1.0F);
      }
    }
  };
  private b lsV = new b();
  private String lsz;
  private Surface mSurface = null;
  private int mVideoHeight = 0;
  private int mVideoWidth = 0;
  private long startTime = 0L;
  
  public AbstractVideoTextureView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AbstractVideoTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AbstractVideoTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setSurfaceTextureListener(this.lsU);
    setFocusable(true);
    setFocusableInTouchMode(true);
  }
  
  private void boM()
  {
    boolean bool1 = true;
    int i = hashCode();
    boolean bool2 = this.lsA;
    if (this.cuu == null) {}
    for (;;)
    {
      ad.i("MicroMsg.Video.AbstractVideoTextureView", "%d release media player isPrepared[%b] player is null[%b] ", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if (this.cuu != null)
      {
        this.cuu.a(null);
        this.cuu.a(null);
      }
      try
      {
        this.cuu.stop();
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            this.cuu.reset();
            this.cuu.release();
            this.cuu = null;
            return;
            bool1 = false;
            break;
            localException1 = localException1;
            ad.printErrStackTrace("MicroMsg.Video.AbstractVideoTextureView", localException1, "stop media player error", new Object[0]);
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.Video.AbstractVideoTextureView", localException2, "reset media player error", new Object[0]);
          }
        }
      }
    }
  }
  
  private void boN()
  {
    if ((bt.isNullOrNil(this.lsz)) || (this.mSurface == null)) {
      ad.i("MicroMsg.Video.AbstractVideoTextureView", "openVideo, try later, url:%s, surface:%s", new Object[] { this.lsz, this.mSurface });
    }
    do
    {
      return;
      boM();
      ad.i("MicroMsg.Video.AbstractVideoTextureView", "%d open video %s", new Object[] { Integer.valueOf(hashCode()), this.lsz });
      try
      {
        this.cuu = boL();
        this.cuu.a(this.lsK);
        this.cuu.a(this.lsJ);
        this.lsA = false;
        this.atW = -1;
        this.lsH = 0;
        this.cuu.a(this.lsO);
        this.cuu.a(this.lsP);
        this.cuu.a(this.lsL);
        this.cuu.a(this.lsM);
        this.cuu.a(this.lsN);
        if (!bt.isNullOrNil(this.lsz)) {
          this.cuu.setDataSource(this.lsz);
        }
        this.cuu.setSurface(this.mSurface);
        this.cuu.prepareAsync();
        this.mVideoHeight = this.cuu.getVideoHeight();
        this.mVideoWidth = this.cuu.getVideoWidth();
        setMute(this.fMP);
        aE(this.bdQ);
        ad.i("MicroMsg.Video.AbstractVideoTextureView", "%d open video success player[%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.cuu.hashCode()) });
        return;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.Video.AbstractVideoTextureView", localException, "prepare async error path", new Object[0]);
      }
    } while (this.lsB == null);
    this.lsB.onError(-1, -1);
  }
  
  public final boolean aE(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return false;
    }
    this.bdQ = paramFloat;
    this.cuu.aF(this.bdQ);
    return false;
  }
  
  protected abstract com.tencent.mm.plugin.appbrand.jsapi.video.e.b boL();
  
  public final void boO()
  {
    if ((this.cuu != null) && (this.lsA) && (this.mSurface != null) && (this.mSurface.isValid()))
    {
      ad.i("MicroMsg.Video.AbstractVideoTextureView", "%d flush surface start time[%d] ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(getCurrentPosition()) });
      this.lsT = true;
      this.cuu.setVolume(0.0F, 0.0F);
      this.cuu.start();
    }
  }
  
  public final void d(double paramDouble, boolean paramBoolean)
  {
    p(paramDouble);
    this.cuH = paramBoolean;
  }
  
  public int getCurrentPosition()
  {
    if ((this.cuu != null) && (this.lsA)) {
      return this.cuu.getCurrentPosition();
    }
    if (this.cuu == null) {
      return -1;
    }
    return 0;
  }
  
  public int getDownloadPercent()
  {
    return this.lsH;
  }
  
  public int getDuration()
  {
    if ((this.cuu != null) && (this.lsA))
    {
      if (this.atW > 0) {
        return this.atW;
      }
      this.atW = this.cuu.getDuration();
      return this.atW;
    }
    this.atW = -1;
    return this.atW;
  }
  
  public double getLastProgresstime()
  {
    return 0.0D;
  }
  
  public long getLastSurfaceUpdateTime()
  {
    return this.lsQ;
  }
  
  public String getVideoPath()
  {
    return this.lsz;
  }
  
  protected final void h(Surface paramSurface)
  {
    h.LTJ.aR(new AbstractVideoTextureView.2(this, paramSurface));
  }
  
  public final boolean isPlaying()
  {
    if ((this.cuu != null) && (this.lsA) && (!this.lsS) && (!this.lsT)) {}
    for (boolean bool = this.cuu.isPlaying();; bool = false)
    {
      ad.d("MicroMsg.Video.AbstractVideoTextureView", "%d is playing result [%b] pauseWhenUpdated[%b] mIsPrepared[%b]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(bool), Boolean.valueOf(this.lsS), Boolean.valueOf(this.lsA) });
      return bool;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.mVideoWidth == 0) || (this.mVideoHeight == 0))
    {
      setMeasuredDimension(1, 1);
      return;
    }
    paramInt1 = getDefaultSize(1, paramInt1);
    paramInt2 = getDefaultSize(1, paramInt2);
    int i = this.mVideoWidth;
    int j = this.mVideoHeight;
    this.lsV.y(paramInt1, paramInt2, i, j);
    setMeasuredDimension(this.lsV.ltC, this.lsV.ltD);
  }
  
  public final void p(double paramDouble)
  {
    if (this.cuu != null)
    {
      this.cuu.seekTo((int)paramDouble);
      this.cuH = true;
      ad.d("MicroMsg.Video.AbstractVideoTextureView", "seek to time: " + paramDouble + " curr pos : " + this.cuu.getCurrentPosition());
    }
  }
  
  public final void pause()
  {
    if ((this.cuu != null) && (this.lsA) && (this.cuu.isPlaying()))
    {
      ad.d("MicroMsg.Video.AbstractVideoTextureView", "pause video.");
      this.cuu.pause();
    }
    this.cuH = false;
  }
  
  public void setForceScaleFullScreen(boolean paramBoolean)
  {
    this.lsI = paramBoolean;
    this.lsV.lsI = this.lsI;
  }
  
  public void setLoop(boolean paramBoolean)
  {
    if (this.cuu != null) {
      this.cuu.setLooping(paramBoolean);
    }
    this.isd = true;
  }
  
  public void setMute(boolean paramBoolean)
  {
    ad.i("MicroMsg.Video.AbstractVideoTextureView", "%d set mute %b", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean) });
    this.fMP = paramBoolean;
    if (this.cuu != null)
    {
      if (this.fMP) {
        this.cuu.setVolume(0.0F, 0.0F);
      }
    }
    else {
      return;
    }
    this.cuu.setVolume(1.0F, 1.0F);
  }
  
  public void setOnInfoCallback(a.b paramb)
  {
    this.lsE = paramb;
  }
  
  public void setOnSeekCompleteCallback(a.c paramc)
  {
    this.lsD = paramc;
  }
  
  public void setOnSurfaceCallback(a.d paramd)
  {
    this.lsF = paramd;
  }
  
  public void setOneTimeVideoTextureUpdateCallback(a.e parame)
  {
    this.lsC = parame;
  }
  
  public void setPlayProgressCallback(boolean paramBoolean) {}
  
  public void setScaleType(e.h paramh)
  {
    b localb = this.lsV;
    ad.i("MicroMsg.ViewSizeCache", "set scale type old[%s] new[%s]", new Object[] { localb.llB, paramh });
    localb.llB = paramh;
    localb.reset();
    requestLayout();
  }
  
  public void setThumb(Bitmap paramBitmap) {}
  
  public void setVideoCallback(a.a parama)
  {
    this.lsB = parama;
  }
  
  public void setVideoPath(String paramString)
  {
    this.lsz = paramString;
    this.cuH = false;
    boN();
    requestLayout();
  }
  
  public final boolean start()
  {
    if (this.mSurface == null)
    {
      ad.w("MicroMsg.Video.AbstractVideoTextureView", "%d it surface not ready, do not start", new Object[] { Integer.valueOf(hashCode()) });
      this.lsR = true;
      this.cuH = true;
      return false;
    }
    if (this.startTime == 0L) {}
    for (long l = bt.aQJ();; l = this.startTime)
    {
      this.startTime = l;
      ad.i("MicroMsg.Video.AbstractVideoTextureView", "start %d mIsPrepared %b pauseWhenUpdated %b mediaPlayer %s", new Object[] { Long.valueOf(this.startTime), Boolean.valueOf(this.lsA), Boolean.valueOf(this.lsS), this.cuu });
      if ((this.cuu == null) || (!this.lsA)) {
        break;
      }
      if (this.lsS)
      {
        this.lsS = false;
        setMute(this.fMP);
      }
      this.cuu.start();
      this.cuH = true;
      return true;
    }
    if ((this.cuu == null) && (this.lsA))
    {
      this.cuH = true;
      boN();
      requestLayout();
      return true;
    }
    this.cuH = true;
    return false;
  }
  
  public final void stop()
  {
    long l1;
    long l3;
    if (this.lsG > 0L)
    {
      l1 = this.lsG - this.startTime;
      l3 = bt.aQJ() - this.startTime;
      if (l1 <= l3) {
        break label499;
      }
    }
    label499:
    for (long l2 = l3;; l2 = l1)
    {
      if ((int)l2 * 1000 > getDuration()) {
        getDuration();
      }
      ad.i("MicroMsg.Video.AbstractVideoTextureView", "stop : dur:%d stop:%d comp:%d", new Object[] { Integer.valueOf(getDuration()), Long.valueOf(l3), Long.valueOf(l1) });
      if (this.lsB != null) {
        getDuration();
      }
      boM();
      this.lsV.reset();
      try
      {
        if ((this.mSurface != null) && (this.lsA))
        {
          Object localObject1 = getSurfaceTexture();
          if (localObject1 != null)
          {
            ad.i("MicroMsg.Video.AbstractVideoTextureView", "%d releaseSurface", new Object[] { Integer.valueOf(hashCode()) });
            EGL10 localEGL10 = (EGL10)EGLContext.getEGL();
            EGLDisplay localEGLDisplay = localEGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            localEGL10.eglInitialize(localEGLDisplay, null);
            Object localObject2 = new EGLConfig[1];
            int[] arrayOfInt = new int[1];
            localEGL10.eglChooseConfig(localEGLDisplay, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344, 0, 12344 }, (EGLConfig[])localObject2, 1, arrayOfInt);
            arrayOfInt = localObject2[0];
            localObject2 = localEGL10.eglCreateContext(localEGLDisplay, arrayOfInt, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
            localObject1 = localEGL10.eglCreateWindowSurface(localEGLDisplay, arrayOfInt, localObject1, new int[] { 12344 });
            localEGL10.eglMakeCurrent(localEGLDisplay, (EGLSurface)localObject1, (EGLSurface)localObject1, (EGLContext)localObject2);
            GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
            GLES20.glClear(16384);
            localEGL10.eglSwapBuffers(localEGLDisplay, (EGLSurface)localObject1);
            localEGL10.eglDestroySurface(localEGLDisplay, (EGLSurface)localObject1);
            localObject1 = EGL10.EGL_NO_SURFACE;
            localEGL10.eglMakeCurrent(localEGLDisplay, (EGLSurface)localObject1, (EGLSurface)localObject1, EGL10.EGL_NO_CONTEXT);
            localEGL10.eglDestroyContext(localEGLDisplay, (EGLContext)localObject2);
            localEGL10.eglTerminate(localEGLDisplay);
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.Video.AbstractVideoTextureView", localException, "release surface", new Object[0]);
        }
      }
      this.lsz = "";
      this.lsH = 0;
      this.lsA = false;
      this.cuH = false;
      this.lsQ = 0L;
      return;
      l1 = 2147483647L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoTextureView
 * JD-Core Version:    0.7.0.1
 */