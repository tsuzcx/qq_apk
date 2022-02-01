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
  private float aSD = -1.0F;
  private int ark;
  protected com.tencent.mm.plugin.appbrand.jsapi.video.e.b cmS = null;
  private boolean cnf;
  private boolean fqj = false;
  private boolean hyg = false;
  private b.b kuA = new b.b()
  {
    public final void Fz()
    {
      AppMethodBeat.i(194304);
      ad.i("MicroMsg.Video.AbstractVideoTextureView", "video on completion");
      AbstractVideoTextureView.b(AbstractVideoTextureView.this, bt.aGK());
      if (AbstractVideoTextureView.c(AbstractVideoTextureView.this) != null) {
        AbstractVideoTextureView.c(AbstractVideoTextureView.this).onCompletion();
      }
      AppMethodBeat.o(194304);
    }
  };
  private b.c kuB = new b.c()
  {
    public final boolean cc(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(194305);
      ad.w("MicroMsg.Video.AbstractVideoTextureView", "Error: " + paramAnonymousInt1 + "," + paramAnonymousInt2);
      if (AbstractVideoTextureView.c(AbstractVideoTextureView.this) != null) {
        AbstractVideoTextureView.c(AbstractVideoTextureView.this).onError(paramAnonymousInt1, paramAnonymousInt2);
      }
      AppMethodBeat.o(194305);
      return true;
    }
  };
  private long kuC = 0L;
  private boolean kuD = false;
  private boolean kuE = false;
  private boolean kuF = false;
  private TextureView.SurfaceTextureListener kuG = new TextureView.SurfaceTextureListener()
  {
    public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(194309);
      AbstractVideoTextureView.this.i(AbstractVideoTextureView.s(AbstractVideoTextureView.this));
      AbstractVideoTextureView.a(AbstractVideoTextureView.this, new Surface(paramAnonymousSurfaceTexture));
      ad.i("MicroMsg.Video.AbstractVideoTextureView", "%d on texture available %d*%d mIsPrepared[%b] mSurface[%d] ", new Object[] { Integer.valueOf(AbstractVideoTextureView.this.hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Boolean.valueOf(AbstractVideoTextureView.r(AbstractVideoTextureView.this)), Integer.valueOf(AbstractVideoTextureView.s(AbstractVideoTextureView.this).hashCode()) });
      if ((AbstractVideoTextureView.this.cmS == null) || (!AbstractVideoTextureView.r(AbstractVideoTextureView.this)))
      {
        AbstractVideoTextureView.u(AbstractVideoTextureView.this);
        if (AbstractVideoTextureView.w(AbstractVideoTextureView.this) != null) {
          AbstractVideoTextureView.w(AbstractVideoTextureView.this).aCw();
        }
        AppMethodBeat.o(194309);
        return;
      }
      AbstractVideoTextureView.this.cmS.setSurface(AbstractVideoTextureView.s(AbstractVideoTextureView.this));
      if (AbstractVideoTextureView.v(AbstractVideoTextureView.this)) {
        AbstractVideoTextureView.this.cmS.start();
      }
      for (;;)
      {
        AbstractVideoTextureView.b(AbstractVideoTextureView.this, false);
        break;
        AbstractVideoTextureView.a(AbstractVideoTextureView.this, true);
        AbstractVideoTextureView.this.cmS.setVolume(0.0F, 0.0F);
        AbstractVideoTextureView.this.cmS.start();
      }
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
    {
      AppMethodBeat.i(194308);
      ad.i("MicroMsg.Video.AbstractVideoTextureView", "%d on texture destroyed mIsPrepared[%b]", new Object[] { Integer.valueOf(AbstractVideoTextureView.this.hashCode()), Boolean.valueOf(AbstractVideoTextureView.r(AbstractVideoTextureView.this)) });
      AbstractVideoTextureView.this.i(AbstractVideoTextureView.s(AbstractVideoTextureView.this));
      AbstractVideoTextureView.a(AbstractVideoTextureView.this, null);
      if ((AbstractVideoTextureView.this.cmS != null) && (AbstractVideoTextureView.r(AbstractVideoTextureView.this))) {
        if (AbstractVideoTextureView.this.isPlaying())
        {
          AbstractVideoTextureView.b(AbstractVideoTextureView.this, true);
          AbstractVideoTextureView.this.cmS.pause();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(194308);
        return false;
        AbstractVideoTextureView.t(AbstractVideoTextureView.this);
        AbstractVideoTextureView.b(AbstractVideoTextureView.this, false);
      }
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(194307);
      ad.i("MicroMsg.Video.AbstractVideoTextureView", "on texture size changed width : " + paramAnonymousInt1 + " height : " + paramAnonymousInt2);
      if ((AbstractVideoTextureView.this.cmS != null) && (AbstractVideoTextureView.r(AbstractVideoTextureView.this)) && (AbstractVideoTextureView.a(AbstractVideoTextureView.this) == paramAnonymousInt1) && (AbstractVideoTextureView.b(AbstractVideoTextureView.this) == paramAnonymousInt2)) {
        AbstractVideoTextureView.this.cmS.start();
      }
      AppMethodBeat.o(194307);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture)
    {
      AppMethodBeat.i(194306);
      ad.d("MicroMsg.Video.AbstractVideoTextureView", "on surface texture updated");
      if (AbstractVideoTextureView.i(AbstractVideoTextureView.this)) {
        if (AbstractVideoTextureView.this.cmS != null)
        {
          AbstractVideoTextureView.this.cmS.pause();
          if (!AbstractVideoTextureView.l(AbstractVideoTextureView.this)) {
            break label227;
          }
          AbstractVideoTextureView.this.cmS.setVolume(0.0F, 0.0F);
        }
      }
      for (;;)
      {
        AbstractVideoTextureView.a(AbstractVideoTextureView.this, false);
        if ((AbstractVideoTextureView.m(AbstractVideoTextureView.this) > 0L) && (AbstractVideoTextureView.n(AbstractVideoTextureView.this) != null))
        {
          AbstractVideoTextureView.n(AbstractVideoTextureView.this).beo();
          AbstractVideoTextureView.o(AbstractVideoTextureView.this);
        }
        AbstractVideoTextureView.a(AbstractVideoTextureView.this, System.currentTimeMillis());
        if (AbstractVideoTextureView.p(AbstractVideoTextureView.this))
        {
          ad.i("MicroMsg.Video.AbstractVideoTextureView", "%d flush surface pause now time[%d]", new Object[] { Integer.valueOf(AbstractVideoTextureView.this.hashCode()), Integer.valueOf(AbstractVideoTextureView.this.getCurrentPosition()) });
          if (AbstractVideoTextureView.this.cmS != null)
          {
            AbstractVideoTextureView.this.cmS.pause();
            AbstractVideoTextureView.this.setMute(AbstractVideoTextureView.l(AbstractVideoTextureView.this));
          }
          AbstractVideoTextureView.q(AbstractVideoTextureView.this);
        }
        AppMethodBeat.o(194306);
        return;
        label227:
        AbstractVideoTextureView.this.cmS.setVolume(1.0F, 1.0F);
      }
    }
  };
  private b kuH = new b();
  private String kul;
  private boolean kum;
  private a.a kun;
  private a.e kuo;
  private a.c kup;
  private a.b kuq;
  private a.d kur;
  private long kus = 0L;
  private int kut = 0;
  private boolean kuu = false;
  private b.g kuv = new b.g()
  {
    public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramAnonymousb, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(194299);
      try
      {
        if (paramAnonymousb != AbstractVideoTextureView.this.cmS)
        {
          ad.w("MicroMsg.Video.AbstractVideoTextureView", "another player on video size changed, return now.[%s, %s]", new Object[] { paramAnonymousb, AbstractVideoTextureView.this.cmS });
          AppMethodBeat.o(194299);
          return;
        }
        AbstractVideoTextureView.a(AbstractVideoTextureView.this, paramAnonymousb.getVideoWidth());
        AbstractVideoTextureView.b(AbstractVideoTextureView.this, paramAnonymousb.getVideoHeight());
        ad.i("MicroMsg.Video.AbstractVideoTextureView", "on size change size:( " + AbstractVideoTextureView.a(AbstractVideoTextureView.this) + " , " + AbstractVideoTextureView.b(AbstractVideoTextureView.this) + " )");
        if (AbstractVideoTextureView.c(AbstractVideoTextureView.this) != null) {
          AbstractVideoTextureView.c(AbstractVideoTextureView.this).dY(AbstractVideoTextureView.a(AbstractVideoTextureView.this), AbstractVideoTextureView.b(AbstractVideoTextureView.this));
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
      AppMethodBeat.o(194299);
    }
  };
  private b.e kuw = new b.e()
  {
    public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramAnonymousb)
    {
      AppMethodBeat.i(194300);
      if (paramAnonymousb != AbstractVideoTextureView.this.cmS)
      {
        ad.w("MicroMsg.Video.AbstractVideoTextureView", "another player callback, release now.[%s, %s]", new Object[] { paramAnonymousb, AbstractVideoTextureView.this.cmS });
        AbstractVideoTextureView.a(AbstractVideoTextureView.this, paramAnonymousb);
        AppMethodBeat.o(194300);
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
          AbstractVideoTextureView.this.cmS.start();
          AbstractVideoTextureView.this.cmS.setLooping(AbstractVideoTextureView.g(AbstractVideoTextureView.this));
          AbstractVideoTextureView.h(AbstractVideoTextureView.this);
        }
      }
      for (;;)
      {
        if (AbstractVideoTextureView.c(AbstractVideoTextureView.this) != null) {
          AbstractVideoTextureView.c(AbstractVideoTextureView.this).rq();
        }
        AppMethodBeat.o(194300);
        return;
        if (AbstractVideoTextureView.f(AbstractVideoTextureView.this))
        {
          AbstractVideoTextureView.this.cmS.start();
          AbstractVideoTextureView.h(AbstractVideoTextureView.this);
          AbstractVideoTextureView.this.cmS.setLooping(AbstractVideoTextureView.g(AbstractVideoTextureView.this));
        }
      }
    }
  };
  private b.f kux = new b.f()
  {
    public final void b(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramAnonymousb)
    {
      AppMethodBeat.i(194301);
      ad.i("MicroMsg.Video.AbstractVideoTextureView", "video seek complete curPos[%d] mStartWhenPrepared[%b] pauseWhenUpdated[%b]", new Object[] { Integer.valueOf(paramAnonymousb.getCurrentPosition()), Boolean.valueOf(AbstractVideoTextureView.f(AbstractVideoTextureView.this)), Boolean.valueOf(AbstractVideoTextureView.i(AbstractVideoTextureView.this)) });
      if (AbstractVideoTextureView.f(AbstractVideoTextureView.this))
      {
        if (AbstractVideoTextureView.i(AbstractVideoTextureView.this))
        {
          AppMethodBeat.o(194301);
          return;
        }
        AbstractVideoTextureView.this.start();
      }
      for (;;)
      {
        if (AbstractVideoTextureView.j(AbstractVideoTextureView.this) != null) {
          AbstractVideoTextureView.j(AbstractVideoTextureView.this).ey(AbstractVideoTextureView.f(AbstractVideoTextureView.this));
        }
        AbstractVideoTextureView.a(AbstractVideoTextureView.this, 0L);
        AppMethodBeat.o(194301);
        return;
        AbstractVideoTextureView.this.pause();
      }
    }
  };
  private b.a kuy = new b.a()
  {
    public final void gX(int paramAnonymousInt)
    {
      AppMethodBeat.i(194302);
      ad.d("MicroMsg.Video.AbstractVideoTextureView", "onBufferingUpdate percent[%d]", new Object[] { Integer.valueOf(paramAnonymousInt) });
      AbstractVideoTextureView.c(AbstractVideoTextureView.this, paramAnonymousInt);
      AppMethodBeat.o(194302);
    }
  };
  private b.d kuz = new b.d()
  {
    public final boolean cb(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(194303);
      ad.d("MicroMsg.Video.AbstractVideoTextureView", "onInfo [%d %d]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
      if (AbstractVideoTextureView.k(AbstractVideoTextureView.this) != null) {
        AbstractVideoTextureView.k(AbstractVideoTextureView.this).dZ(paramAnonymousInt1, paramAnonymousInt2);
      }
      AppMethodBeat.o(194303);
      return false;
    }
  };
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
    setSurfaceTextureListener(this.kuG);
    setFocusable(true);
    setFocusableInTouchMode(true);
  }
  
  private void beh()
  {
    boolean bool1 = true;
    int i = hashCode();
    boolean bool2 = this.kum;
    if (this.cmS == null) {}
    for (;;)
    {
      ad.i("MicroMsg.Video.AbstractVideoTextureView", "%d release media player isPrepared[%b] player is null[%b] ", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if (this.cmS != null)
      {
        this.cmS.a(null);
        this.cmS.a(null);
      }
      try
      {
        this.cmS.stop();
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            this.cmS.reset();
            this.cmS.release();
            this.cmS = null;
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
  
  private void bei()
  {
    if ((bt.isNullOrNil(this.kul)) || (this.mSurface == null)) {
      ad.i("MicroMsg.Video.AbstractVideoTextureView", "openVideo, try later, url:%s, surface:%s", new Object[] { this.kul, this.mSurface });
    }
    do
    {
      return;
      beh();
      ad.i("MicroMsg.Video.AbstractVideoTextureView", "%d open video %s", new Object[] { Integer.valueOf(hashCode()), this.kul });
      try
      {
        this.cmS = beg();
        this.cmS.a(this.kuw);
        this.cmS.a(this.kuv);
        this.kum = false;
        this.ark = -1;
        this.kut = 0;
        this.cmS.a(this.kuA);
        this.cmS.a(this.kuB);
        this.cmS.a(this.kux);
        this.cmS.a(this.kuy);
        this.cmS.a(this.kuz);
        if (!bt.isNullOrNil(this.kul)) {
          this.cmS.setDataSource(this.kul);
        }
        this.cmS.setSurface(this.mSurface);
        this.cmS.prepareAsync();
        this.mVideoHeight = this.cmS.getVideoHeight();
        this.mVideoWidth = this.cmS.getVideoWidth();
        setMute(this.fqj);
        ax(this.aSD);
        ad.i("MicroMsg.Video.AbstractVideoTextureView", "%d open video success player[%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.cmS.hashCode()) });
        return;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.Video.AbstractVideoTextureView", localException, "prepare async error path", new Object[0]);
      }
    } while (this.kun == null);
    this.kun.onError(-1, -1);
  }
  
  public final boolean ax(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return false;
    }
    this.aSD = paramFloat;
    this.cmS.ay(this.aSD);
    return false;
  }
  
  protected abstract com.tencent.mm.plugin.appbrand.jsapi.video.e.b beg();
  
  public final void bej()
  {
    if ((this.cmS != null) && (this.kum) && (this.mSurface != null) && (this.mSurface.isValid()))
    {
      ad.i("MicroMsg.Video.AbstractVideoTextureView", "%d flush surface start time[%d] ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(getCurrentPosition()) });
      this.kuF = true;
      this.cmS.setVolume(0.0F, 0.0F);
      this.cmS.start();
    }
  }
  
  public final void d(double paramDouble, boolean paramBoolean)
  {
    q(paramDouble);
    this.cnf = paramBoolean;
  }
  
  public int getCurrentPosition()
  {
    if ((this.cmS != null) && (this.kum)) {
      return this.cmS.getCurrentPosition();
    }
    if (this.cmS == null) {
      return -1;
    }
    return 0;
  }
  
  public int getDownloadPercent()
  {
    return this.kut;
  }
  
  public int getDuration()
  {
    if ((this.cmS != null) && (this.kum))
    {
      if (this.ark > 0) {
        return this.ark;
      }
      this.ark = this.cmS.getDuration();
      return this.ark;
    }
    this.ark = -1;
    return this.ark;
  }
  
  public double getLastProgresstime()
  {
    return 0.0D;
  }
  
  public long getLastSurfaceUpdateTime()
  {
    return this.kuC;
  }
  
  public String getVideoPath()
  {
    return this.kul;
  }
  
  protected final void i(final Surface paramSurface)
  {
    h.Iye.aP(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194298);
        try
        {
          if ((paramSurface != null) && (paramSurface.isValid()))
          {
            ad.i("MicroMsg.Video.AbstractVideoTextureView", "%d release surface [%d]", new Object[] { Integer.valueOf(AbstractVideoTextureView.this.hashCode()), Integer.valueOf(paramSurface.hashCode()) });
            paramSurface.release();
          }
          AppMethodBeat.o(194298);
          return;
        }
        catch (Exception localException)
        {
          ad.printErrStackTrace("MicroMsg.Video.AbstractVideoTextureView", localException, "release Surface error", new Object[0]);
          AppMethodBeat.o(194298);
        }
      }
    });
  }
  
  public final boolean isPlaying()
  {
    if ((this.cmS != null) && (this.kum) && (!this.kuE) && (!this.kuF)) {}
    for (boolean bool = this.cmS.isPlaying();; bool = false)
    {
      ad.d("MicroMsg.Video.AbstractVideoTextureView", "%d is playing result [%b] pauseWhenUpdated[%b] mIsPrepared[%b]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(bool), Boolean.valueOf(this.kuE), Boolean.valueOf(this.kum) });
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
    this.kuH.x(paramInt1, paramInt2, i, j);
    setMeasuredDimension(this.kuH.kvp, this.kuH.kvq);
  }
  
  public final void pause()
  {
    if ((this.cmS != null) && (this.kum) && (this.cmS.isPlaying()))
    {
      ad.d("MicroMsg.Video.AbstractVideoTextureView", "pause video.");
      this.cmS.pause();
    }
    this.cnf = false;
  }
  
  public final void q(double paramDouble)
  {
    if (this.cmS != null)
    {
      this.cmS.seekTo((int)paramDouble);
      this.cnf = true;
      ad.d("MicroMsg.Video.AbstractVideoTextureView", "seek to time: " + paramDouble + " curr pos : " + this.cmS.getCurrentPosition());
    }
  }
  
  public void setForceScaleFullScreen(boolean paramBoolean)
  {
    this.kuu = paramBoolean;
    this.kuH.kuu = this.kuu;
  }
  
  public void setLoop(boolean paramBoolean)
  {
    if (this.cmS != null) {
      this.cmS.setLooping(paramBoolean);
    }
    this.hyg = true;
  }
  
  public void setMute(boolean paramBoolean)
  {
    ad.i("MicroMsg.Video.AbstractVideoTextureView", "%d set mute %b", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean) });
    this.fqj = paramBoolean;
    if (this.cmS != null)
    {
      if (this.fqj) {
        this.cmS.setVolume(0.0F, 0.0F);
      }
    }
    else {
      return;
    }
    this.cmS.setVolume(1.0F, 1.0F);
  }
  
  public void setOnInfoCallback(a.b paramb)
  {
    this.kuq = paramb;
  }
  
  public void setOnSeekCompleteCallback(a.c paramc)
  {
    this.kup = paramc;
  }
  
  public void setOnSurfaceCallback(a.d paramd)
  {
    this.kur = paramd;
  }
  
  public void setOneTimeVideoTextureUpdateCallback(a.e parame)
  {
    this.kuo = parame;
  }
  
  public void setPlayProgressCallback(boolean paramBoolean) {}
  
  public void setScaleType(e.h paramh)
  {
    b localb = this.kuH;
    ad.i("MicroMsg.ViewSizeCache", "set scale type old[%s] new[%s]", new Object[] { localb.knE, paramh });
    localb.knE = paramh;
    localb.reset();
    requestLayout();
  }
  
  public void setThumb(Bitmap paramBitmap) {}
  
  public void setVideoCallback(a.a parama)
  {
    this.kun = parama;
  }
  
  public void setVideoPath(String paramString)
  {
    this.kul = paramString;
    this.cnf = false;
    bei();
    requestLayout();
  }
  
  public final boolean start()
  {
    if (this.mSurface == null)
    {
      ad.w("MicroMsg.Video.AbstractVideoTextureView", "%d it surface not ready, do not start", new Object[] { Integer.valueOf(hashCode()) });
      this.kuD = true;
      this.cnf = true;
      return false;
    }
    if (this.startTime == 0L) {}
    for (long l = bt.aGK();; l = this.startTime)
    {
      this.startTime = l;
      ad.i("MicroMsg.Video.AbstractVideoTextureView", "start %d mIsPrepared %b pauseWhenUpdated %b mediaPlayer %s", new Object[] { Long.valueOf(this.startTime), Boolean.valueOf(this.kum), Boolean.valueOf(this.kuE), this.cmS });
      if ((this.cmS == null) || (!this.kum)) {
        break;
      }
      if (this.kuE)
      {
        this.kuE = false;
        setMute(this.fqj);
      }
      this.cmS.start();
      this.cnf = true;
      return true;
    }
    if ((this.cmS == null) && (this.kum))
    {
      this.cnf = true;
      bei();
      requestLayout();
      return true;
    }
    this.cnf = true;
    return false;
  }
  
  public final void stop()
  {
    long l1;
    long l3;
    if (this.kus > 0L)
    {
      l1 = this.kus - this.startTime;
      l3 = bt.aGK() - this.startTime;
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
      if (this.kun != null) {
        getDuration();
      }
      beh();
      this.kuH.reset();
      try
      {
        if ((this.mSurface != null) && (this.kum))
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
      this.kul = "";
      this.kut = 0;
      this.kum = false;
      this.cnf = false;
      this.kuC = 0L;
      return;
      l1 = 2147483647L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoTextureView
 * JD-Core Version:    0.7.0.1
 */