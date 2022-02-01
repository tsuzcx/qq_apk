package com.tencent.mm.plugin.appbrand.jsapi.video.videoview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public abstract class AbstractVideoTextureView
  extends TextureView
  implements a
{
  private int atU;
  private float bdN = -1.0F;
  protected c cIV = null;
  private boolean cJi;
  private boolean guh = false;
  private boolean jqj = false;
  private String mDV;
  private boolean mDW;
  private a.a mDX;
  private a.e mDY;
  private a.c mDZ;
  private a.b mEa;
  private a.d mEb;
  private long mEc = 0L;
  private int mEd = 0;
  private boolean mEe = false;
  private c.i mEf = new c.i()
  {
    public final void a(c paramAnonymousc, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(235172);
      try
      {
        if (paramAnonymousc != AbstractVideoTextureView.this.cIV)
        {
          Log.w("MicroMsg.Video.AbstractVideoTextureView", "another player on video size changed, return now.[%s, %s]", new Object[] { paramAnonymousc, AbstractVideoTextureView.this.cIV });
          AppMethodBeat.o(235172);
          return;
        }
        AbstractVideoTextureView.b(AbstractVideoTextureView.this, paramAnonymousc.getVideoWidth());
        AbstractVideoTextureView.a(AbstractVideoTextureView.this, paramAnonymousc.getVideoHeight());
        Log.i("MicroMsg.Video.AbstractVideoTextureView", "on size change size:( " + AbstractVideoTextureView.e(AbstractVideoTextureView.this) + " , " + AbstractVideoTextureView.f(AbstractVideoTextureView.this) + " )");
        if (AbstractVideoTextureView.d(AbstractVideoTextureView.this) != null) {
          AbstractVideoTextureView.d(AbstractVideoTextureView.this).eo(AbstractVideoTextureView.e(AbstractVideoTextureView.this), AbstractVideoTextureView.f(AbstractVideoTextureView.this));
        }
      }
      catch (Exception paramAnonymousc)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.Video.AbstractVideoTextureView", paramAnonymousc, "on video size changed error[%d, %d]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        }
      }
      AbstractVideoTextureView.g(AbstractVideoTextureView.this);
      AppMethodBeat.o(235172);
    }
  };
  private c.g mEg = new c.g()
  {
    public final void a(c paramAnonymousc)
    {
      AppMethodBeat.i(235173);
      if (paramAnonymousc != AbstractVideoTextureView.this.cIV)
      {
        Log.w("MicroMsg.Video.AbstractVideoTextureView", "another player callback, release now.[%s, %s]", new Object[] { paramAnonymousc, AbstractVideoTextureView.this.cIV });
        AbstractVideoTextureView.a(AbstractVideoTextureView.this, paramAnonymousc);
        AppMethodBeat.o(235173);
        return;
      }
      AbstractVideoTextureView.h(AbstractVideoTextureView.this);
      AbstractVideoTextureView.b(AbstractVideoTextureView.this, paramAnonymousc.getVideoWidth());
      AbstractVideoTextureView.a(AbstractVideoTextureView.this, paramAnonymousc.getVideoHeight());
      Log.i("MicroMsg.Video.AbstractVideoTextureView", "on prepared. size [%d, %d] mStartWhenPrepared %b ", new Object[] { Integer.valueOf(AbstractVideoTextureView.e(AbstractVideoTextureView.this)), Integer.valueOf(AbstractVideoTextureView.f(AbstractVideoTextureView.this)), Boolean.valueOf(AbstractVideoTextureView.i(AbstractVideoTextureView.this)) });
      AbstractVideoTextureView.g(AbstractVideoTextureView.this);
      if ((AbstractVideoTextureView.e(AbstractVideoTextureView.this) != 0) && (AbstractVideoTextureView.f(AbstractVideoTextureView.this) != 0)) {
        if (AbstractVideoTextureView.i(AbstractVideoTextureView.this))
        {
          AbstractVideoTextureView.this.cIV.start();
          AbstractVideoTextureView.this.cIV.setLooping(AbstractVideoTextureView.j(AbstractVideoTextureView.this));
          AbstractVideoTextureView.k(AbstractVideoTextureView.this);
        }
      }
      for (;;)
      {
        if (AbstractVideoTextureView.d(AbstractVideoTextureView.this) != null) {
          AbstractVideoTextureView.d(AbstractVideoTextureView.this).tf();
        }
        AppMethodBeat.o(235173);
        return;
        if (AbstractVideoTextureView.i(AbstractVideoTextureView.this))
        {
          AbstractVideoTextureView.this.cIV.start();
          AbstractVideoTextureView.k(AbstractVideoTextureView.this);
          AbstractVideoTextureView.this.cIV.setLooping(AbstractVideoTextureView.j(AbstractVideoTextureView.this));
        }
      }
    }
  };
  private c.h mEh = new c.h()
  {
    public final void b(c paramAnonymousc)
    {
      AppMethodBeat.i(235174);
      Log.i("MicroMsg.Video.AbstractVideoTextureView", "video seek complete curPos[%d] mStartWhenPrepared[%b] pauseWhenUpdated[%b]", new Object[] { Integer.valueOf(paramAnonymousc.getCurrentPosition()), Boolean.valueOf(AbstractVideoTextureView.i(AbstractVideoTextureView.this)), Boolean.valueOf(AbstractVideoTextureView.l(AbstractVideoTextureView.this)) });
      if (AbstractVideoTextureView.i(AbstractVideoTextureView.this))
      {
        if (AbstractVideoTextureView.l(AbstractVideoTextureView.this))
        {
          AppMethodBeat.o(235174);
          return;
        }
        AbstractVideoTextureView.this.start();
      }
      for (;;)
      {
        if (AbstractVideoTextureView.m(AbstractVideoTextureView.this) != null) {
          AbstractVideoTextureView.m(AbstractVideoTextureView.this).fN(AbstractVideoTextureView.i(AbstractVideoTextureView.this));
        }
        AbstractVideoTextureView.a(AbstractVideoTextureView.this, 0L);
        AppMethodBeat.o(235174);
        return;
        AbstractVideoTextureView.this.pause();
      }
    }
  };
  private c.a mEi = new c.a()
  {
    public final void id(int paramAnonymousInt)
    {
      AppMethodBeat.i(235175);
      Log.d("MicroMsg.Video.AbstractVideoTextureView", "onBufferingUpdate percent[%d]", new Object[] { Integer.valueOf(paramAnonymousInt) });
      AbstractVideoTextureView.c(AbstractVideoTextureView.this, paramAnonymousInt);
      AppMethodBeat.o(235175);
    }
  };
  private c.f mEj = new c.f()
  {
    public final boolean cb(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(235176);
      Log.d("MicroMsg.Video.AbstractVideoTextureView", "onInfo [%d %d]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
      if (AbstractVideoTextureView.n(AbstractVideoTextureView.this) != null) {
        AbstractVideoTextureView.n(AbstractVideoTextureView.this).ep(paramAnonymousInt1, paramAnonymousInt2);
      }
      AppMethodBeat.o(235176);
      return false;
    }
  };
  private c.b mEk = new c.b()
  {
    public final void QA()
    {
      AppMethodBeat.i(235177);
      Log.i("MicroMsg.Video.AbstractVideoTextureView", "video on completion");
      AbstractVideoTextureView.b(AbstractVideoTextureView.this, Util.nowSecond());
      if (AbstractVideoTextureView.d(AbstractVideoTextureView.this) != null) {
        AbstractVideoTextureView.d(AbstractVideoTextureView.this).onCompletion();
      }
      AppMethodBeat.o(235177);
    }
  };
  private c.e mEl = new c.e()
  {
    public final boolean cc(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(235164);
      Log.w("MicroMsg.Video.AbstractVideoTextureView", "Error: " + paramAnonymousInt1 + "," + paramAnonymousInt2);
      if (AbstractVideoTextureView.d(AbstractVideoTextureView.this) != null) {
        AbstractVideoTextureView.d(AbstractVideoTextureView.this).onError(paramAnonymousInt1, paramAnonymousInt2);
      }
      AppMethodBeat.o(235164);
      return true;
    }
  };
  private long mEm = 0L;
  private boolean mEn = false;
  private boolean mEo = false;
  private boolean mEp = false;
  private TextureView.SurfaceTextureListener mEq = new TextureView.SurfaceTextureListener()
  {
    public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(235168);
      AbstractVideoTextureView.this.h(AbstractVideoTextureView.a(AbstractVideoTextureView.this));
      AbstractVideoTextureView.a(AbstractVideoTextureView.this, new Surface(paramAnonymousSurfaceTexture));
      Log.i("MicroMsg.Video.AbstractVideoTextureView", "%d on texture available %d*%d mIsPrepared[%b] mSurface[%d] ", new Object[] { Integer.valueOf(AbstractVideoTextureView.this.hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Boolean.valueOf(AbstractVideoTextureView.t(AbstractVideoTextureView.this)), Integer.valueOf(AbstractVideoTextureView.a(AbstractVideoTextureView.this).hashCode()) });
      if ((AbstractVideoTextureView.this.cIV == null) || (!AbstractVideoTextureView.t(AbstractVideoTextureView.this)))
      {
        AbstractVideoTextureView.v(AbstractVideoTextureView.this);
        if (AbstractVideoTextureView.x(AbstractVideoTextureView.this) != null) {
          AbstractVideoTextureView.x(AbstractVideoTextureView.this).bgX();
        }
        AppMethodBeat.o(235168);
        return;
      }
      AbstractVideoTextureView.this.cIV.setSurface(AbstractVideoTextureView.a(AbstractVideoTextureView.this));
      if (AbstractVideoTextureView.w(AbstractVideoTextureView.this)) {
        AbstractVideoTextureView.this.cIV.start();
      }
      for (;;)
      {
        AbstractVideoTextureView.b(AbstractVideoTextureView.this, false);
        break;
        AbstractVideoTextureView.a(AbstractVideoTextureView.this, true);
        AbstractVideoTextureView.this.cIV.setVolume(0.0F, 0.0F);
        AbstractVideoTextureView.this.cIV.start();
      }
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
    {
      AppMethodBeat.i(235167);
      Log.i("MicroMsg.Video.AbstractVideoTextureView", "%d on texture destroyed mIsPrepared[%b]", new Object[] { Integer.valueOf(AbstractVideoTextureView.this.hashCode()), Boolean.valueOf(AbstractVideoTextureView.t(AbstractVideoTextureView.this)) });
      AbstractVideoTextureView.this.h(AbstractVideoTextureView.a(AbstractVideoTextureView.this));
      AbstractVideoTextureView.a(AbstractVideoTextureView.this, null);
      if ((AbstractVideoTextureView.this.cIV != null) && (AbstractVideoTextureView.t(AbstractVideoTextureView.this))) {
        if (AbstractVideoTextureView.this.isPlaying())
        {
          AbstractVideoTextureView.b(AbstractVideoTextureView.this, true);
          AbstractVideoTextureView.this.cIV.pause();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(235167);
        return false;
        AbstractVideoTextureView.u(AbstractVideoTextureView.this);
        AbstractVideoTextureView.b(AbstractVideoTextureView.this, false);
      }
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(235166);
      Log.i("MicroMsg.Video.AbstractVideoTextureView", "on texture size changed width : " + paramAnonymousInt1 + " height : " + paramAnonymousInt2);
      if ((AbstractVideoTextureView.this.cIV != null) && (AbstractVideoTextureView.t(AbstractVideoTextureView.this)) && (AbstractVideoTextureView.e(AbstractVideoTextureView.this) == paramAnonymousInt1) && (AbstractVideoTextureView.f(AbstractVideoTextureView.this) == paramAnonymousInt2)) {
        AbstractVideoTextureView.this.cIV.start();
      }
      AppMethodBeat.o(235166);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture)
    {
      AppMethodBeat.i(235165);
      Log.d("MicroMsg.Video.AbstractVideoTextureView", "on surface texture updated");
      if (AbstractVideoTextureView.l(AbstractVideoTextureView.this)) {
        if (AbstractVideoTextureView.this.cIV != null)
        {
          AbstractVideoTextureView.this.cIV.pause();
          if (!AbstractVideoTextureView.b(AbstractVideoTextureView.this)) {
            break label227;
          }
          AbstractVideoTextureView.this.cIV.setVolume(0.0F, 0.0F);
        }
      }
      for (;;)
      {
        AbstractVideoTextureView.a(AbstractVideoTextureView.this, false);
        if ((AbstractVideoTextureView.o(AbstractVideoTextureView.this) > 0L) && (AbstractVideoTextureView.p(AbstractVideoTextureView.this) != null))
        {
          AbstractVideoTextureView.p(AbstractVideoTextureView.this).bLh();
          AbstractVideoTextureView.q(AbstractVideoTextureView.this);
        }
        AbstractVideoTextureView.a(AbstractVideoTextureView.this, System.currentTimeMillis());
        if (AbstractVideoTextureView.r(AbstractVideoTextureView.this))
        {
          Log.i("MicroMsg.Video.AbstractVideoTextureView", "%d flush surface pause now time[%d]", new Object[] { Integer.valueOf(AbstractVideoTextureView.this.hashCode()), Integer.valueOf(AbstractVideoTextureView.this.getCurrentPosition()) });
          if (AbstractVideoTextureView.this.cIV != null)
          {
            AbstractVideoTextureView.this.cIV.pause();
            AbstractVideoTextureView.this.setMute(AbstractVideoTextureView.b(AbstractVideoTextureView.this));
          }
          AbstractVideoTextureView.s(AbstractVideoTextureView.this);
        }
        AppMethodBeat.o(235165);
        return;
        label227:
        AbstractVideoTextureView.this.cIV.setVolume(1.0F, 1.0F);
      }
    }
  };
  private b mEr = new b();
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
    setSurfaceTextureListener(this.mEq);
    setFocusable(true);
    setFocusableInTouchMode(true);
  }
  
  private void bLc()
  {
    boolean bool1 = true;
    int i = hashCode();
    boolean bool2 = this.mDW;
    if (this.cIV == null) {}
    for (;;)
    {
      Log.i("MicroMsg.Video.AbstractVideoTextureView", "%d release media player isPrepared[%b] player is null[%b] ", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if (this.cIV != null)
      {
        this.cIV.a(null);
        this.cIV.a(null);
      }
      try
      {
        this.cIV.stop();
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            this.cIV.reset();
            this.cIV.release();
            this.cIV = null;
            return;
            bool1 = false;
            break;
            localException1 = localException1;
            Log.printErrStackTrace("MicroMsg.Video.AbstractVideoTextureView", localException1, "stop media player error", new Object[0]);
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.Video.AbstractVideoTextureView", localException2, "reset media player error", new Object[0]);
          }
        }
      }
    }
  }
  
  private void bLd()
  {
    if ((Util.isNullOrNil(this.mDV)) || (this.mSurface == null)) {
      Log.i("MicroMsg.Video.AbstractVideoTextureView", "openVideo, try later, url:%s, surface:%s", new Object[] { this.mDV, this.mSurface });
    }
    for (;;)
    {
      return;
      bLc();
      Log.i("MicroMsg.Video.AbstractVideoTextureView", "%d open video %s", new Object[] { Integer.valueOf(hashCode()), this.mDV });
      try
      {
        this.cIV = bLb();
        this.cIV.a(this.mEg);
        this.cIV.a(this.mEf);
        this.mDW = false;
        this.atU = -1;
        this.mEd = 0;
        this.cIV.a(this.mEk);
        this.cIV.a(this.mEl);
        this.cIV.a(this.mEh);
        this.cIV.a(this.mEi);
        this.cIV.a(this.mEj);
        final Runnable local5 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(235170);
            try
            {
              AbstractVideoTextureView.this.cIV.setSurface(AbstractVideoTextureView.a(AbstractVideoTextureView.this));
              AbstractVideoTextureView.this.cIV.prepareAsync();
              AbstractVideoTextureView.a(AbstractVideoTextureView.this, AbstractVideoTextureView.this.cIV.getVideoHeight());
              AbstractVideoTextureView.b(AbstractVideoTextureView.this, AbstractVideoTextureView.this.cIV.getVideoWidth());
              AbstractVideoTextureView.this.setMute(AbstractVideoTextureView.b(AbstractVideoTextureView.this));
              AbstractVideoTextureView.this.aO(AbstractVideoTextureView.c(AbstractVideoTextureView.this));
              AppMethodBeat.o(235170);
              return;
            }
            catch (Exception localException)
            {
              Log.printErrStackTrace("MicroMsg.Video.AbstractVideoTextureView", localException, "prepare async error path", new Object[0]);
              if (AbstractVideoTextureView.d(AbstractVideoTextureView.this) != null) {
                AbstractVideoTextureView.d(AbstractVideoTextureView.this).onError(-1, -1);
              }
              AppMethodBeat.o(235170);
            }
          }
        };
        if (!Util.isNullOrNil(this.mDV)) {
          this.cIV.a(this.mDV, null, new c.c()
          {
            public final void bKA()
            {
              AppMethodBeat.i(235171);
              Log.i("MicroMsg.Video.AbstractVideoTextureView", "onDataSourceSet#openVideo");
              local5.run();
              AppMethodBeat.o(235171);
            }
          });
        }
        for (;;)
        {
          Log.i("MicroMsg.Video.AbstractVideoTextureView", "%d open video success player[%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.cIV.hashCode()) });
          return;
          local5.run();
        }
        if (this.mDX == null) {}
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.Video.AbstractVideoTextureView", localException, "prepare async error path", new Object[0]);
      }
    }
    this.mDX.onError(-1, -1);
  }
  
  public final boolean aO(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return false;
    }
    this.bdN = paramFloat;
    this.cIV.aP(this.bdN);
    return false;
  }
  
  protected abstract c bLb();
  
  public final void bLe()
  {
    if ((this.cIV != null) && (this.mDW) && (this.mSurface != null) && (this.mSurface.isValid()))
    {
      Log.i("MicroMsg.Video.AbstractVideoTextureView", "%d flush surface start time[%d] ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(getCurrentPosition()) });
      this.mEp = true;
      this.cIV.setVolume(0.0F, 0.0F);
      this.cIV.start();
    }
  }
  
  public final void d(double paramDouble, boolean paramBoolean)
  {
    q(paramDouble);
    this.cJi = paramBoolean;
  }
  
  public int getCurrentPosition()
  {
    if ((this.cIV != null) && (this.mDW)) {
      return this.cIV.getCurrentPosition();
    }
    if (this.cIV == null) {
      return -1;
    }
    return 0;
  }
  
  public int getDownloadPercent()
  {
    return this.mEd;
  }
  
  public int getDuration()
  {
    if ((this.cIV != null) && (this.mDW))
    {
      if (this.atU > 0) {
        return this.atU;
      }
      this.atU = this.cIV.getDuration();
      return this.atU;
    }
    this.atU = -1;
    return this.atU;
  }
  
  public double getLastProgresstime()
  {
    return 0.0D;
  }
  
  public long getLastSurfaceUpdateTime()
  {
    return this.mEm;
  }
  
  public String getVideoPath()
  {
    return this.mDV;
  }
  
  protected final void h(Surface paramSurface)
  {
    h.RTc.aX(new AbstractVideoTextureView.4(this, paramSurface));
  }
  
  public final boolean isPlaying()
  {
    if ((this.cIV != null) && (this.mDW) && (!this.mEo) && (!this.mEp)) {}
    for (boolean bool = this.cIV.isPlaying();; bool = false)
    {
      Log.d("MicroMsg.Video.AbstractVideoTextureView", "%d is playing result [%b] pauseWhenUpdated[%b] mIsPrepared[%b]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(bool), Boolean.valueOf(this.mEo), Boolean.valueOf(this.mDW) });
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
    this.mEr.y(paramInt1, paramInt2, i, j);
    setMeasuredDimension(this.mEr.mEZ, this.mEr.mFa);
  }
  
  public final void pause()
  {
    if ((this.cIV != null) && (this.mDW) && (this.cIV.isPlaying()))
    {
      Log.d("MicroMsg.Video.AbstractVideoTextureView", "pause video.");
      this.cIV.pause();
    }
    this.cJi = false;
  }
  
  public final void q(double paramDouble)
  {
    if (this.cIV != null)
    {
      this.cIV.seekTo((int)paramDouble);
      this.cJi = true;
      Log.d("MicroMsg.Video.AbstractVideoTextureView", "seek to time: " + paramDouble + " curr pos : " + this.cIV.getCurrentPosition());
    }
  }
  
  public void setForceScaleFullScreen(boolean paramBoolean)
  {
    this.mEe = paramBoolean;
    this.mEr.mEe = this.mEe;
  }
  
  public void setLoop(boolean paramBoolean)
  {
    if (this.cIV != null) {
      this.cIV.setLooping(paramBoolean);
    }
    this.jqj = true;
  }
  
  public void setMute(boolean paramBoolean)
  {
    Log.i("MicroMsg.Video.AbstractVideoTextureView", "%d set mute %b", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean) });
    this.guh = paramBoolean;
    if (this.cIV != null)
    {
      if (this.guh) {
        this.cIV.setVolume(0.0F, 0.0F);
      }
    }
    else {
      return;
    }
    this.cIV.setVolume(1.0F, 1.0F);
  }
  
  public void setOnInfoCallback(a.b paramb)
  {
    this.mEa = paramb;
  }
  
  public void setOnSeekCompleteCallback(a.c paramc)
  {
    this.mDZ = paramc;
  }
  
  public void setOnSurfaceCallback(a.d paramd)
  {
    this.mEb = paramd;
  }
  
  public void setOneTimeVideoTextureUpdateCallback(a.e parame)
  {
    this.mDY = parame;
  }
  
  public void setPlayProgressCallback(boolean paramBoolean) {}
  
  public void setScaleType(e.h paramh)
  {
    b localb = this.mEr;
    Log.i("MicroMsg.ViewSizeCache", "set scale type old[%s] new[%s]", new Object[] { localb.mwG, paramh });
    localb.mwG = paramh;
    localb.reset();
    requestLayout();
  }
  
  public void setThumb(Bitmap paramBitmap) {}
  
  public void setVideoCallback(a.a parama)
  {
    this.mDX = parama;
  }
  
  public void setVideoPath(String paramString)
  {
    this.mDV = paramString;
    this.cJi = false;
    bLd();
    requestLayout();
  }
  
  public final boolean start()
  {
    if (this.mSurface == null)
    {
      Log.w("MicroMsg.Video.AbstractVideoTextureView", "%d it surface not ready, do not start", new Object[] { Integer.valueOf(hashCode()) });
      this.mEn = true;
      this.cJi = true;
      return false;
    }
    if (this.startTime == 0L) {}
    for (long l = Util.nowSecond();; l = this.startTime)
    {
      this.startTime = l;
      Log.i("MicroMsg.Video.AbstractVideoTextureView", "start %d mIsPrepared %b pauseWhenUpdated %b mediaPlayer %s", new Object[] { Long.valueOf(this.startTime), Boolean.valueOf(this.mDW), Boolean.valueOf(this.mEo), this.cIV });
      if ((this.cIV == null) || (!this.mDW)) {
        break;
      }
      if (this.mEo)
      {
        this.mEo = false;
        setMute(this.guh);
      }
      this.cIV.start();
      this.cJi = true;
      return true;
    }
    if ((this.cIV == null) && (this.mDW))
    {
      this.cJi = true;
      bLd();
      requestLayout();
      return true;
    }
    this.cJi = true;
    return false;
  }
  
  public final void stop()
  {
    long l1;
    long l3;
    if (this.mEc > 0L)
    {
      l1 = this.mEc - this.startTime;
      l3 = Util.nowSecond() - this.startTime;
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
      Log.i("MicroMsg.Video.AbstractVideoTextureView", "stop : dur:%d stop:%d comp:%d", new Object[] { Integer.valueOf(getDuration()), Long.valueOf(l3), Long.valueOf(l1) });
      if (this.mDX != null) {
        getDuration();
      }
      bLc();
      this.mEr.reset();
      try
      {
        if ((this.mSurface != null) && (this.mDW))
        {
          Object localObject1 = getSurfaceTexture();
          if (localObject1 != null)
          {
            Log.i("MicroMsg.Video.AbstractVideoTextureView", "%d releaseSurface", new Object[] { Integer.valueOf(hashCode()) });
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
          Log.printErrStackTrace("MicroMsg.Video.AbstractVideoTextureView", localException, "release surface", new Object[0]);
        }
      }
      this.mDV = "";
      this.mEd = 0;
      this.mDW = false;
      this.cJi = false;
      this.mEm = 0L;
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