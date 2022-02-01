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
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public abstract class AbstractVideoTextureView
  extends TextureView
  implements a
{
  private float aTw = -1.0F;
  private int asf;
  protected com.tencent.mm.plugin.appbrand.jsapi.video.e.b cjU = null;
  private boolean ckh;
  private boolean ftN = false;
  private boolean hYH = false;
  private String kVA;
  private boolean kVB;
  private a.a kVC;
  private a.e kVD;
  private a.c kVE;
  private a.b kVF;
  private a.d kVG;
  private long kVH = 0L;
  private int kVI = 0;
  private boolean kVJ = false;
  private b.g kVK = new b.g()
  {
    public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramAnonymousb, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(194644);
      try
      {
        if (paramAnonymousb != AbstractVideoTextureView.this.cjU)
        {
          ac.w("MicroMsg.Video.AbstractVideoTextureView", "another player on video size changed, return now.[%s, %s]", new Object[] { paramAnonymousb, AbstractVideoTextureView.this.cjU });
          AppMethodBeat.o(194644);
          return;
        }
        AbstractVideoTextureView.a(AbstractVideoTextureView.this, paramAnonymousb.getVideoWidth());
        AbstractVideoTextureView.b(AbstractVideoTextureView.this, paramAnonymousb.getVideoHeight());
        ac.i("MicroMsg.Video.AbstractVideoTextureView", "on size change size:( " + AbstractVideoTextureView.a(AbstractVideoTextureView.this) + " , " + AbstractVideoTextureView.b(AbstractVideoTextureView.this) + " )");
        if (AbstractVideoTextureView.c(AbstractVideoTextureView.this) != null) {
          AbstractVideoTextureView.c(AbstractVideoTextureView.this).dZ(AbstractVideoTextureView.a(AbstractVideoTextureView.this), AbstractVideoTextureView.b(AbstractVideoTextureView.this));
        }
      }
      catch (Exception paramAnonymousb)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.Video.AbstractVideoTextureView", paramAnonymousb, "on video size changed error[%d, %d]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        }
      }
      AbstractVideoTextureView.d(AbstractVideoTextureView.this);
      AppMethodBeat.o(194644);
    }
  };
  private b.e kVL = new b.e()
  {
    public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramAnonymousb)
    {
      AppMethodBeat.i(194645);
      if (paramAnonymousb != AbstractVideoTextureView.this.cjU)
      {
        ac.w("MicroMsg.Video.AbstractVideoTextureView", "another player callback, release now.[%s, %s]", new Object[] { paramAnonymousb, AbstractVideoTextureView.this.cjU });
        AbstractVideoTextureView.a(AbstractVideoTextureView.this, paramAnonymousb);
        AppMethodBeat.o(194645);
        return;
      }
      AbstractVideoTextureView.e(AbstractVideoTextureView.this);
      AbstractVideoTextureView.a(AbstractVideoTextureView.this, paramAnonymousb.getVideoWidth());
      AbstractVideoTextureView.b(AbstractVideoTextureView.this, paramAnonymousb.getVideoHeight());
      ac.i("MicroMsg.Video.AbstractVideoTextureView", "on prepared. size [%d, %d] mStartWhenPrepared %b ", new Object[] { Integer.valueOf(AbstractVideoTextureView.a(AbstractVideoTextureView.this)), Integer.valueOf(AbstractVideoTextureView.b(AbstractVideoTextureView.this)), Boolean.valueOf(AbstractVideoTextureView.f(AbstractVideoTextureView.this)) });
      AbstractVideoTextureView.d(AbstractVideoTextureView.this);
      if ((AbstractVideoTextureView.a(AbstractVideoTextureView.this) != 0) && (AbstractVideoTextureView.b(AbstractVideoTextureView.this) != 0)) {
        if (AbstractVideoTextureView.f(AbstractVideoTextureView.this))
        {
          AbstractVideoTextureView.this.cjU.start();
          AbstractVideoTextureView.this.cjU.setLooping(AbstractVideoTextureView.g(AbstractVideoTextureView.this));
          AbstractVideoTextureView.h(AbstractVideoTextureView.this);
        }
      }
      for (;;)
      {
        if (AbstractVideoTextureView.c(AbstractVideoTextureView.this) != null) {
          AbstractVideoTextureView.c(AbstractVideoTextureView.this).rB();
        }
        AppMethodBeat.o(194645);
        return;
        if (AbstractVideoTextureView.f(AbstractVideoTextureView.this))
        {
          AbstractVideoTextureView.this.cjU.start();
          AbstractVideoTextureView.h(AbstractVideoTextureView.this);
          AbstractVideoTextureView.this.cjU.setLooping(AbstractVideoTextureView.g(AbstractVideoTextureView.this));
        }
      }
    }
  };
  private b.f kVM = new b.f()
  {
    public final void b(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramAnonymousb)
    {
      AppMethodBeat.i(194646);
      ac.i("MicroMsg.Video.AbstractVideoTextureView", "video seek complete curPos[%d] mStartWhenPrepared[%b] pauseWhenUpdated[%b]", new Object[] { Integer.valueOf(paramAnonymousb.getCurrentPosition()), Boolean.valueOf(AbstractVideoTextureView.f(AbstractVideoTextureView.this)), Boolean.valueOf(AbstractVideoTextureView.i(AbstractVideoTextureView.this)) });
      if (AbstractVideoTextureView.f(AbstractVideoTextureView.this))
      {
        if (AbstractVideoTextureView.i(AbstractVideoTextureView.this))
        {
          AppMethodBeat.o(194646);
          return;
        }
        AbstractVideoTextureView.this.start();
      }
      for (;;)
      {
        if (AbstractVideoTextureView.j(AbstractVideoTextureView.this) != null) {
          AbstractVideoTextureView.j(AbstractVideoTextureView.this).eS(AbstractVideoTextureView.f(AbstractVideoTextureView.this));
        }
        AbstractVideoTextureView.a(AbstractVideoTextureView.this, 0L);
        AppMethodBeat.o(194646);
        return;
        AbstractVideoTextureView.this.pause();
      }
    }
  };
  private b.a kVN = new b.a()
  {
    public final void gH(int paramAnonymousInt)
    {
      AppMethodBeat.i(194647);
      ac.d("MicroMsg.Video.AbstractVideoTextureView", "onBufferingUpdate percent[%d]", new Object[] { Integer.valueOf(paramAnonymousInt) });
      AbstractVideoTextureView.c(AbstractVideoTextureView.this, paramAnonymousInt);
      AppMethodBeat.o(194647);
    }
  };
  private b.d kVO = new b.d()
  {
    public final boolean bY(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(194648);
      ac.d("MicroMsg.Video.AbstractVideoTextureView", "onInfo [%d %d]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
      if (AbstractVideoTextureView.k(AbstractVideoTextureView.this) != null) {
        AbstractVideoTextureView.k(AbstractVideoTextureView.this).ea(paramAnonymousInt1, paramAnonymousInt2);
      }
      AppMethodBeat.o(194648);
      return false;
    }
  };
  private b.b kVP = new b.b()
  {
    public final void Fh()
    {
      AppMethodBeat.i(194649);
      ac.i("MicroMsg.Video.AbstractVideoTextureView", "video on completion");
      AbstractVideoTextureView.b(AbstractVideoTextureView.this, bs.aNx());
      if (AbstractVideoTextureView.c(AbstractVideoTextureView.this) != null) {
        AbstractVideoTextureView.c(AbstractVideoTextureView.this).onCompletion();
      }
      AppMethodBeat.o(194649);
    }
  };
  private b.c kVQ = new b.c()
  {
    public final boolean bZ(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(194650);
      ac.w("MicroMsg.Video.AbstractVideoTextureView", "Error: " + paramAnonymousInt1 + "," + paramAnonymousInt2);
      if (AbstractVideoTextureView.c(AbstractVideoTextureView.this) != null) {
        AbstractVideoTextureView.c(AbstractVideoTextureView.this).onError(paramAnonymousInt1, paramAnonymousInt2);
      }
      AppMethodBeat.o(194650);
      return true;
    }
  };
  private long kVR = 0L;
  private boolean kVS = false;
  private boolean kVT = false;
  private boolean kVU = false;
  private TextureView.SurfaceTextureListener kVV = new TextureView.SurfaceTextureListener()
  {
    public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(194654);
      AbstractVideoTextureView.this.h(AbstractVideoTextureView.s(AbstractVideoTextureView.this));
      AbstractVideoTextureView.a(AbstractVideoTextureView.this, new Surface(paramAnonymousSurfaceTexture));
      ac.i("MicroMsg.Video.AbstractVideoTextureView", "%d on texture available %d*%d mIsPrepared[%b] mSurface[%d] ", new Object[] { Integer.valueOf(AbstractVideoTextureView.this.hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Boolean.valueOf(AbstractVideoTextureView.r(AbstractVideoTextureView.this)), Integer.valueOf(AbstractVideoTextureView.s(AbstractVideoTextureView.this).hashCode()) });
      if ((AbstractVideoTextureView.this.cjU == null) || (!AbstractVideoTextureView.r(AbstractVideoTextureView.this)))
      {
        AbstractVideoTextureView.u(AbstractVideoTextureView.this);
        if (AbstractVideoTextureView.w(AbstractVideoTextureView.this) != null) {
          AbstractVideoTextureView.w(AbstractVideoTextureView.this).aJn();
        }
        AppMethodBeat.o(194654);
        return;
      }
      AbstractVideoTextureView.this.cjU.setSurface(AbstractVideoTextureView.s(AbstractVideoTextureView.this));
      if (AbstractVideoTextureView.v(AbstractVideoTextureView.this)) {
        AbstractVideoTextureView.this.cjU.start();
      }
      for (;;)
      {
        AbstractVideoTextureView.b(AbstractVideoTextureView.this, false);
        break;
        AbstractVideoTextureView.a(AbstractVideoTextureView.this, true);
        AbstractVideoTextureView.this.cjU.setVolume(0.0F, 0.0F);
        AbstractVideoTextureView.this.cjU.start();
      }
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
    {
      AppMethodBeat.i(194653);
      ac.i("MicroMsg.Video.AbstractVideoTextureView", "%d on texture destroyed mIsPrepared[%b]", new Object[] { Integer.valueOf(AbstractVideoTextureView.this.hashCode()), Boolean.valueOf(AbstractVideoTextureView.r(AbstractVideoTextureView.this)) });
      AbstractVideoTextureView.this.h(AbstractVideoTextureView.s(AbstractVideoTextureView.this));
      AbstractVideoTextureView.a(AbstractVideoTextureView.this, null);
      if ((AbstractVideoTextureView.this.cjU != null) && (AbstractVideoTextureView.r(AbstractVideoTextureView.this))) {
        if (AbstractVideoTextureView.this.isPlaying())
        {
          AbstractVideoTextureView.b(AbstractVideoTextureView.this, true);
          AbstractVideoTextureView.this.cjU.pause();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(194653);
        return false;
        AbstractVideoTextureView.t(AbstractVideoTextureView.this);
        AbstractVideoTextureView.b(AbstractVideoTextureView.this, false);
      }
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(194652);
      ac.i("MicroMsg.Video.AbstractVideoTextureView", "on texture size changed width : " + paramAnonymousInt1 + " height : " + paramAnonymousInt2);
      if ((AbstractVideoTextureView.this.cjU != null) && (AbstractVideoTextureView.r(AbstractVideoTextureView.this)) && (AbstractVideoTextureView.a(AbstractVideoTextureView.this) == paramAnonymousInt1) && (AbstractVideoTextureView.b(AbstractVideoTextureView.this) == paramAnonymousInt2)) {
        AbstractVideoTextureView.this.cjU.start();
      }
      AppMethodBeat.o(194652);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture)
    {
      AppMethodBeat.i(194651);
      ac.d("MicroMsg.Video.AbstractVideoTextureView", "on surface texture updated");
      if (AbstractVideoTextureView.i(AbstractVideoTextureView.this)) {
        if (AbstractVideoTextureView.this.cjU != null)
        {
          AbstractVideoTextureView.this.cjU.pause();
          if (!AbstractVideoTextureView.l(AbstractVideoTextureView.this)) {
            break label227;
          }
          AbstractVideoTextureView.this.cjU.setVolume(0.0F, 0.0F);
        }
      }
      for (;;)
      {
        AbstractVideoTextureView.a(AbstractVideoTextureView.this, false);
        if ((AbstractVideoTextureView.m(AbstractVideoTextureView.this) > 0L) && (AbstractVideoTextureView.n(AbstractVideoTextureView.this) != null))
        {
          AbstractVideoTextureView.n(AbstractVideoTextureView.this).bli();
          AbstractVideoTextureView.o(AbstractVideoTextureView.this);
        }
        AbstractVideoTextureView.a(AbstractVideoTextureView.this, System.currentTimeMillis());
        if (AbstractVideoTextureView.p(AbstractVideoTextureView.this))
        {
          ac.i("MicroMsg.Video.AbstractVideoTextureView", "%d flush surface pause now time[%d]", new Object[] { Integer.valueOf(AbstractVideoTextureView.this.hashCode()), Integer.valueOf(AbstractVideoTextureView.this.getCurrentPosition()) });
          if (AbstractVideoTextureView.this.cjU != null)
          {
            AbstractVideoTextureView.this.cjU.pause();
            AbstractVideoTextureView.this.setMute(AbstractVideoTextureView.l(AbstractVideoTextureView.this));
          }
          AbstractVideoTextureView.q(AbstractVideoTextureView.this);
        }
        AppMethodBeat.o(194651);
        return;
        label227:
        AbstractVideoTextureView.this.cjU.setVolume(1.0F, 1.0F);
      }
    }
  };
  private b kVW = new b();
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
    setSurfaceTextureListener(this.kVV);
    setFocusable(true);
    setFocusableInTouchMode(true);
  }
  
  private void blb()
  {
    boolean bool1 = true;
    int i = hashCode();
    boolean bool2 = this.kVB;
    if (this.cjU == null) {}
    for (;;)
    {
      ac.i("MicroMsg.Video.AbstractVideoTextureView", "%d release media player isPrepared[%b] player is null[%b] ", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if (this.cjU != null)
      {
        this.cjU.a(null);
        this.cjU.a(null);
      }
      try
      {
        this.cjU.stop();
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            this.cjU.reset();
            this.cjU.release();
            this.cjU = null;
            return;
            bool1 = false;
            break;
            localException1 = localException1;
            ac.printErrStackTrace("MicroMsg.Video.AbstractVideoTextureView", localException1, "stop media player error", new Object[0]);
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.Video.AbstractVideoTextureView", localException2, "reset media player error", new Object[0]);
          }
        }
      }
    }
  }
  
  private void blc()
  {
    if ((bs.isNullOrNil(this.kVA)) || (this.mSurface == null)) {
      ac.i("MicroMsg.Video.AbstractVideoTextureView", "openVideo, try later, url:%s, surface:%s", new Object[] { this.kVA, this.mSurface });
    }
    do
    {
      return;
      blb();
      ac.i("MicroMsg.Video.AbstractVideoTextureView", "%d open video %s", new Object[] { Integer.valueOf(hashCode()), this.kVA });
      try
      {
        this.cjU = bla();
        this.cjU.a(this.kVL);
        this.cjU.a(this.kVK);
        this.kVB = false;
        this.asf = -1;
        this.kVI = 0;
        this.cjU.a(this.kVP);
        this.cjU.a(this.kVQ);
        this.cjU.a(this.kVM);
        this.cjU.a(this.kVN);
        this.cjU.a(this.kVO);
        if (!bs.isNullOrNil(this.kVA)) {
          this.cjU.setDataSource(this.kVA);
        }
        this.cjU.setSurface(this.mSurface);
        this.cjU.prepareAsync();
        this.mVideoHeight = this.cjU.getVideoHeight();
        this.mVideoWidth = this.cjU.getVideoWidth();
        setMute(this.ftN);
        aB(this.aTw);
        ac.i("MicroMsg.Video.AbstractVideoTextureView", "%d open video success player[%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.cjU.hashCode()) });
        return;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.Video.AbstractVideoTextureView", localException, "prepare async error path", new Object[0]);
      }
    } while (this.kVC == null);
    this.kVC.onError(-1, -1);
  }
  
  public final boolean aB(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return false;
    }
    this.aTw = paramFloat;
    this.cjU.aC(this.aTw);
    return false;
  }
  
  protected abstract com.tencent.mm.plugin.appbrand.jsapi.video.e.b bla();
  
  public final void bld()
  {
    if ((this.cjU != null) && (this.kVB) && (this.mSurface != null) && (this.mSurface.isValid()))
    {
      ac.i("MicroMsg.Video.AbstractVideoTextureView", "%d flush surface start time[%d] ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(getCurrentPosition()) });
      this.kVU = true;
      this.cjU.setVolume(0.0F, 0.0F);
      this.cjU.start();
    }
  }
  
  public final void d(double paramDouble, boolean paramBoolean)
  {
    p(paramDouble);
    this.ckh = paramBoolean;
  }
  
  public int getCurrentPosition()
  {
    if ((this.cjU != null) && (this.kVB)) {
      return this.cjU.getCurrentPosition();
    }
    if (this.cjU == null) {
      return -1;
    }
    return 0;
  }
  
  public int getDownloadPercent()
  {
    return this.kVI;
  }
  
  public int getDuration()
  {
    if ((this.cjU != null) && (this.kVB))
    {
      if (this.asf > 0) {
        return this.asf;
      }
      this.asf = this.cjU.getDuration();
      return this.asf;
    }
    this.asf = -1;
    return this.asf;
  }
  
  public double getLastProgresstime()
  {
    return 0.0D;
  }
  
  public long getLastSurfaceUpdateTime()
  {
    return this.kVR;
  }
  
  public String getVideoPath()
  {
    return this.kVA;
  }
  
  protected final void h(Surface paramSurface)
  {
    h.JZN.aS(new AbstractVideoTextureView.2(this, paramSurface));
  }
  
  public final boolean isPlaying()
  {
    if ((this.cjU != null) && (this.kVB) && (!this.kVT) && (!this.kVU)) {}
    for (boolean bool = this.cjU.isPlaying();; bool = false)
    {
      ac.d("MicroMsg.Video.AbstractVideoTextureView", "%d is playing result [%b] pauseWhenUpdated[%b] mIsPrepared[%b]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(bool), Boolean.valueOf(this.kVT), Boolean.valueOf(this.kVB) });
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
    this.kVW.x(paramInt1, paramInt2, i, j);
    setMeasuredDimension(this.kVW.kWD, this.kVW.kWE);
  }
  
  public final void p(double paramDouble)
  {
    if (this.cjU != null)
    {
      this.cjU.seekTo((int)paramDouble);
      this.ckh = true;
      ac.d("MicroMsg.Video.AbstractVideoTextureView", "seek to time: " + paramDouble + " curr pos : " + this.cjU.getCurrentPosition());
    }
  }
  
  public final void pause()
  {
    if ((this.cjU != null) && (this.kVB) && (this.cjU.isPlaying()))
    {
      ac.d("MicroMsg.Video.AbstractVideoTextureView", "pause video.");
      this.cjU.pause();
    }
    this.ckh = false;
  }
  
  public void setForceScaleFullScreen(boolean paramBoolean)
  {
    this.kVJ = paramBoolean;
    this.kVW.kVJ = this.kVJ;
  }
  
  public void setLoop(boolean paramBoolean)
  {
    if (this.cjU != null) {
      this.cjU.setLooping(paramBoolean);
    }
    this.hYH = true;
  }
  
  public void setMute(boolean paramBoolean)
  {
    ac.i("MicroMsg.Video.AbstractVideoTextureView", "%d set mute %b", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean) });
    this.ftN = paramBoolean;
    if (this.cjU != null)
    {
      if (this.ftN) {
        this.cjU.setVolume(0.0F, 0.0F);
      }
    }
    else {
      return;
    }
    this.cjU.setVolume(1.0F, 1.0F);
  }
  
  public void setOnInfoCallback(a.b paramb)
  {
    this.kVF = paramb;
  }
  
  public void setOnSeekCompleteCallback(a.c paramc)
  {
    this.kVE = paramc;
  }
  
  public void setOnSurfaceCallback(a.d paramd)
  {
    this.kVG = paramd;
  }
  
  public void setOneTimeVideoTextureUpdateCallback(a.e parame)
  {
    this.kVD = parame;
  }
  
  public void setPlayProgressCallback(boolean paramBoolean) {}
  
  public void setScaleType(e.h paramh)
  {
    b localb = this.kVW;
    ac.i("MicroMsg.ViewSizeCache", "set scale type old[%s] new[%s]", new Object[] { localb.kOY, paramh });
    localb.kOY = paramh;
    localb.reset();
    requestLayout();
  }
  
  public void setThumb(Bitmap paramBitmap) {}
  
  public void setVideoCallback(a.a parama)
  {
    this.kVC = parama;
  }
  
  public void setVideoPath(String paramString)
  {
    this.kVA = paramString;
    this.ckh = false;
    blc();
    requestLayout();
  }
  
  public final boolean start()
  {
    if (this.mSurface == null)
    {
      ac.w("MicroMsg.Video.AbstractVideoTextureView", "%d it surface not ready, do not start", new Object[] { Integer.valueOf(hashCode()) });
      this.kVS = true;
      this.ckh = true;
      return false;
    }
    if (this.startTime == 0L) {}
    for (long l = bs.aNx();; l = this.startTime)
    {
      this.startTime = l;
      ac.i("MicroMsg.Video.AbstractVideoTextureView", "start %d mIsPrepared %b pauseWhenUpdated %b mediaPlayer %s", new Object[] { Long.valueOf(this.startTime), Boolean.valueOf(this.kVB), Boolean.valueOf(this.kVT), this.cjU });
      if ((this.cjU == null) || (!this.kVB)) {
        break;
      }
      if (this.kVT)
      {
        this.kVT = false;
        setMute(this.ftN);
      }
      this.cjU.start();
      this.ckh = true;
      return true;
    }
    if ((this.cjU == null) && (this.kVB))
    {
      this.ckh = true;
      blc();
      requestLayout();
      return true;
    }
    this.ckh = true;
    return false;
  }
  
  public final void stop()
  {
    long l1;
    long l3;
    if (this.kVH > 0L)
    {
      l1 = this.kVH - this.startTime;
      l3 = bs.aNx() - this.startTime;
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
      ac.i("MicroMsg.Video.AbstractVideoTextureView", "stop : dur:%d stop:%d comp:%d", new Object[] { Integer.valueOf(getDuration()), Long.valueOf(l3), Long.valueOf(l1) });
      if (this.kVC != null) {
        getDuration();
      }
      blb();
      this.kVW.reset();
      try
      {
        if ((this.mSurface != null) && (this.kVB))
        {
          Object localObject1 = getSurfaceTexture();
          if (localObject1 != null)
          {
            ac.i("MicroMsg.Video.AbstractVideoTextureView", "%d releaseSurface", new Object[] { Integer.valueOf(hashCode()) });
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
          ac.printErrStackTrace("MicroMsg.Video.AbstractVideoTextureView", localException, "release surface", new Object[0]);
        }
      }
      this.kVA = "";
      this.kVI = 0;
      this.kVB = false;
      this.ckh = false;
      this.kVR = 0L;
      return;
      l1 = 2147483647L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoTextureView
 * JD-Core Version:    0.7.0.1
 */