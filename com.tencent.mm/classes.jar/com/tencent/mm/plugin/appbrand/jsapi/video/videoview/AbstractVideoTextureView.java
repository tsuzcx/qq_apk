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
import com.tencent.mm.plugin.appbrand.jsapi.video.d.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e.i;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e.j;
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
  private float aNo = -1.0F;
  private int alM;
  private boolean cJM;
  protected e cJz = null;
  private boolean iYs = false;
  private Surface mSurface = null;
  private int mVideoHeight = 0;
  private int mVideoWidth = 0;
  private boolean mfK = false;
  private boolean pDA = false;
  private TextureView.SurfaceTextureListener pDB = new TextureView.SurfaceTextureListener()
  {
    public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(229300);
      AbstractVideoTextureView.this.j(AbstractVideoTextureView.a(AbstractVideoTextureView.this));
      AbstractVideoTextureView.a(AbstractVideoTextureView.this, new Surface(paramAnonymousSurfaceTexture));
      Log.i("MicroMsg.Video.AbstractVideoTextureView", "%d on texture available %d*%d mIsPrepared[%b] mSurface[%d] ", new Object[] { Integer.valueOf(AbstractVideoTextureView.this.hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Boolean.valueOf(AbstractVideoTextureView.t(AbstractVideoTextureView.this)), Integer.valueOf(AbstractVideoTextureView.a(AbstractVideoTextureView.this).hashCode()) });
      if ((AbstractVideoTextureView.this.cJz == null) || (!AbstractVideoTextureView.t(AbstractVideoTextureView.this)))
      {
        AbstractVideoTextureView.v(AbstractVideoTextureView.this);
        if (AbstractVideoTextureView.x(AbstractVideoTextureView.this) != null) {
          AbstractVideoTextureView.x(AbstractVideoTextureView.this).bqp();
        }
        AppMethodBeat.o(229300);
        return;
      }
      AbstractVideoTextureView.this.cJz.setSurface(AbstractVideoTextureView.a(AbstractVideoTextureView.this));
      if (AbstractVideoTextureView.w(AbstractVideoTextureView.this)) {
        AbstractVideoTextureView.this.cJz.start();
      }
      for (;;)
      {
        AbstractVideoTextureView.b(AbstractVideoTextureView.this, false);
        break;
        AbstractVideoTextureView.a(AbstractVideoTextureView.this, true);
        AbstractVideoTextureView.this.cJz.setVolume(0.0F, 0.0F);
        AbstractVideoTextureView.this.cJz.start();
      }
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
    {
      AppMethodBeat.i(229291);
      Log.i("MicroMsg.Video.AbstractVideoTextureView", "%d on texture destroyed mIsPrepared[%b]", new Object[] { Integer.valueOf(AbstractVideoTextureView.this.hashCode()), Boolean.valueOf(AbstractVideoTextureView.t(AbstractVideoTextureView.this)) });
      AbstractVideoTextureView.this.j(AbstractVideoTextureView.a(AbstractVideoTextureView.this));
      AbstractVideoTextureView.a(AbstractVideoTextureView.this, null);
      if ((AbstractVideoTextureView.this.cJz != null) && (AbstractVideoTextureView.t(AbstractVideoTextureView.this))) {
        if (AbstractVideoTextureView.this.isPlaying())
        {
          AbstractVideoTextureView.b(AbstractVideoTextureView.this, true);
          AbstractVideoTextureView.this.cJz.pause();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(229291);
        return false;
        AbstractVideoTextureView.u(AbstractVideoTextureView.this);
        AbstractVideoTextureView.b(AbstractVideoTextureView.this, false);
      }
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(229285);
      Log.i("MicroMsg.Video.AbstractVideoTextureView", "on texture size changed width : " + paramAnonymousInt1 + " height : " + paramAnonymousInt2);
      if ((AbstractVideoTextureView.this.cJz != null) && (AbstractVideoTextureView.t(AbstractVideoTextureView.this)) && (AbstractVideoTextureView.e(AbstractVideoTextureView.this) == paramAnonymousInt1) && (AbstractVideoTextureView.f(AbstractVideoTextureView.this) == paramAnonymousInt2)) {
        AbstractVideoTextureView.this.cJz.start();
      }
      AppMethodBeat.o(229285);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture)
    {
      AppMethodBeat.i(229279);
      Log.d("MicroMsg.Video.AbstractVideoTextureView", "on surface texture updated");
      if (AbstractVideoTextureView.l(AbstractVideoTextureView.this)) {
        if (AbstractVideoTextureView.this.cJz != null)
        {
          AbstractVideoTextureView.this.cJz.pause();
          if (!AbstractVideoTextureView.b(AbstractVideoTextureView.this)) {
            break label227;
          }
          AbstractVideoTextureView.this.cJz.setVolume(0.0F, 0.0F);
        }
      }
      for (;;)
      {
        AbstractVideoTextureView.a(AbstractVideoTextureView.this, false);
        if ((AbstractVideoTextureView.o(AbstractVideoTextureView.this) > 0L) && (AbstractVideoTextureView.p(AbstractVideoTextureView.this) != null))
        {
          AbstractVideoTextureView.p(AbstractVideoTextureView.this).bXh();
          AbstractVideoTextureView.q(AbstractVideoTextureView.this);
        }
        AbstractVideoTextureView.a(AbstractVideoTextureView.this, System.currentTimeMillis());
        if (AbstractVideoTextureView.r(AbstractVideoTextureView.this))
        {
          Log.i("MicroMsg.Video.AbstractVideoTextureView", "%d flush surface pause now time[%d]", new Object[] { Integer.valueOf(AbstractVideoTextureView.this.hashCode()), Integer.valueOf(AbstractVideoTextureView.this.getCurrentPosition()) });
          if (AbstractVideoTextureView.this.cJz != null)
          {
            AbstractVideoTextureView.this.cJz.pause();
            AbstractVideoTextureView.this.setMute(AbstractVideoTextureView.b(AbstractVideoTextureView.this));
          }
          AbstractVideoTextureView.s(AbstractVideoTextureView.this);
        }
        AppMethodBeat.o(229279);
        return;
        label227:
        AbstractVideoTextureView.this.cJz.setVolume(1.0F, 1.0F);
      }
    }
  };
  private b pDC = new b();
  private String pDg;
  private boolean pDh;
  private a.a pDi;
  private a.e pDj;
  private a.c pDk;
  private a.b pDl;
  private a.d pDm;
  private long pDn = 0L;
  private int pDo = 0;
  private boolean pDp = false;
  private e.j pDq = new e.j()
  {
    public final void a(e paramAnonymouse, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(230560);
      try
      {
        if (paramAnonymouse != AbstractVideoTextureView.this.cJz)
        {
          Log.w("MicroMsg.Video.AbstractVideoTextureView", "another player on video size changed, return now.[%s, %s]", new Object[] { paramAnonymouse, AbstractVideoTextureView.this.cJz });
          AppMethodBeat.o(230560);
          return;
        }
        AbstractVideoTextureView.b(AbstractVideoTextureView.this, paramAnonymouse.getVideoWidth());
        AbstractVideoTextureView.a(AbstractVideoTextureView.this, paramAnonymouse.getVideoHeight());
        Log.i("MicroMsg.Video.AbstractVideoTextureView", "on size change size:( " + AbstractVideoTextureView.e(AbstractVideoTextureView.this) + " , " + AbstractVideoTextureView.f(AbstractVideoTextureView.this) + " )");
        if (AbstractVideoTextureView.d(AbstractVideoTextureView.this) != null) {
          AbstractVideoTextureView.d(AbstractVideoTextureView.this).eM(AbstractVideoTextureView.e(AbstractVideoTextureView.this), AbstractVideoTextureView.f(AbstractVideoTextureView.this));
        }
      }
      catch (Exception paramAnonymouse)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.Video.AbstractVideoTextureView", paramAnonymouse, "on video size changed error[%d, %d]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        }
      }
      AbstractVideoTextureView.g(AbstractVideoTextureView.this);
      AppMethodBeat.o(230560);
    }
  };
  private e.h pDr = new e.h()
  {
    public final void a(e paramAnonymouse)
    {
      AppMethodBeat.i(230488);
      if (paramAnonymouse != AbstractVideoTextureView.this.cJz)
      {
        Log.w("MicroMsg.Video.AbstractVideoTextureView", "another player callback, release now.[%s, %s]", new Object[] { paramAnonymouse, AbstractVideoTextureView.this.cJz });
        AbstractVideoTextureView.a(AbstractVideoTextureView.this, paramAnonymouse);
        AppMethodBeat.o(230488);
        return;
      }
      AbstractVideoTextureView.h(AbstractVideoTextureView.this);
      AbstractVideoTextureView.b(AbstractVideoTextureView.this, paramAnonymouse.getVideoWidth());
      AbstractVideoTextureView.a(AbstractVideoTextureView.this, paramAnonymouse.getVideoHeight());
      Log.i("MicroMsg.Video.AbstractVideoTextureView", "on prepared. size [%d, %d] mStartWhenPrepared %b ", new Object[] { Integer.valueOf(AbstractVideoTextureView.e(AbstractVideoTextureView.this)), Integer.valueOf(AbstractVideoTextureView.f(AbstractVideoTextureView.this)), Boolean.valueOf(AbstractVideoTextureView.i(AbstractVideoTextureView.this)) });
      AbstractVideoTextureView.g(AbstractVideoTextureView.this);
      if ((AbstractVideoTextureView.e(AbstractVideoTextureView.this) != 0) && (AbstractVideoTextureView.f(AbstractVideoTextureView.this) != 0)) {
        if (AbstractVideoTextureView.i(AbstractVideoTextureView.this))
        {
          AbstractVideoTextureView.this.cJz.start();
          AbstractVideoTextureView.this.cJz.setLooping(AbstractVideoTextureView.j(AbstractVideoTextureView.this));
          AbstractVideoTextureView.k(AbstractVideoTextureView.this);
        }
      }
      for (;;)
      {
        if (AbstractVideoTextureView.d(AbstractVideoTextureView.this) != null) {
          AbstractVideoTextureView.d(AbstractVideoTextureView.this).qX();
        }
        AppMethodBeat.o(230488);
        return;
        if (AbstractVideoTextureView.i(AbstractVideoTextureView.this))
        {
          AbstractVideoTextureView.this.cJz.start();
          AbstractVideoTextureView.k(AbstractVideoTextureView.this);
          AbstractVideoTextureView.this.cJz.setLooping(AbstractVideoTextureView.j(AbstractVideoTextureView.this));
        }
      }
    }
  };
  private e.i pDs = new e.i()
  {
    public final void b(e paramAnonymouse)
    {
      AppMethodBeat.i(229009);
      Log.i("MicroMsg.Video.AbstractVideoTextureView", "video seek complete curPos[%d] mStartWhenPrepared[%b] pauseWhenUpdated[%b]", new Object[] { Integer.valueOf(paramAnonymouse.getCurrentPosition()), Boolean.valueOf(AbstractVideoTextureView.i(AbstractVideoTextureView.this)), Boolean.valueOf(AbstractVideoTextureView.l(AbstractVideoTextureView.this)) });
      if (AbstractVideoTextureView.i(AbstractVideoTextureView.this))
      {
        if (AbstractVideoTextureView.l(AbstractVideoTextureView.this))
        {
          AppMethodBeat.o(229009);
          return;
        }
        AbstractVideoTextureView.this.start();
      }
      for (;;)
      {
        if (AbstractVideoTextureView.m(AbstractVideoTextureView.this) != null) {
          AbstractVideoTextureView.m(AbstractVideoTextureView.this).gz(AbstractVideoTextureView.i(AbstractVideoTextureView.this));
        }
        AbstractVideoTextureView.a(AbstractVideoTextureView.this, 0L);
        AppMethodBeat.o(229009);
        return;
        AbstractVideoTextureView.this.pause();
      }
    }
  };
  private e.a pDt = new e.a()
  {
    public final void jg(int paramAnonymousInt)
    {
      AppMethodBeat.i(230094);
      Log.d("MicroMsg.Video.AbstractVideoTextureView", "onBufferingUpdate percent[%d]", new Object[] { Integer.valueOf(paramAnonymousInt) });
      AbstractVideoTextureView.c(AbstractVideoTextureView.this, paramAnonymousInt);
      AppMethodBeat.o(230094);
    }
  };
  private e.g pDu = new e.g()
  {
    public final boolean ct(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(227891);
      Log.d("MicroMsg.Video.AbstractVideoTextureView", "onInfo [%d %d]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
      if (AbstractVideoTextureView.n(AbstractVideoTextureView.this) != null) {
        AbstractVideoTextureView.n(AbstractVideoTextureView.this).eN(paramAnonymousInt1, paramAnonymousInt2);
      }
      AppMethodBeat.o(227891);
      return false;
    }
  };
  private e.b pDv = new e.b()
  {
    public final void Uh()
    {
      AppMethodBeat.i(230621);
      Log.i("MicroMsg.Video.AbstractVideoTextureView", "video on completion");
      AbstractVideoTextureView.b(AbstractVideoTextureView.this, Util.nowSecond());
      if (AbstractVideoTextureView.d(AbstractVideoTextureView.this) != null) {
        AbstractVideoTextureView.d(AbstractVideoTextureView.this).onCompletion();
      }
      AppMethodBeat.o(230621);
    }
  };
  private e.e pDw = new e.e()
  {
    public final boolean cu(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(229003);
      Log.w("MicroMsg.Video.AbstractVideoTextureView", "Error: " + paramAnonymousInt1 + "," + paramAnonymousInt2);
      if (AbstractVideoTextureView.d(AbstractVideoTextureView.this) != null) {
        AbstractVideoTextureView.d(AbstractVideoTextureView.this).onError(paramAnonymousInt1, paramAnonymousInt2);
      }
      AppMethodBeat.o(229003);
      return true;
    }
  };
  private long pDx = 0L;
  private boolean pDy = false;
  private boolean pDz = false;
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
    setSurfaceTextureListener(this.pDB);
    setFocusable(true);
    setFocusableInTouchMode(true);
  }
  
  private void bXc()
  {
    boolean bool1 = true;
    int i = hashCode();
    boolean bool2 = this.pDh;
    if (this.cJz == null) {}
    for (;;)
    {
      Log.i("MicroMsg.Video.AbstractVideoTextureView", "%d release media player isPrepared[%b] player is null[%b] ", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if (this.cJz != null)
      {
        this.cJz.a(null);
        this.cJz.a(null);
      }
      try
      {
        this.cJz.stop();
        final e locale = this.cJz;
        h.ZvG.be(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(228893);
            try
            {
              locale.reset();
              locale.release();
              AppMethodBeat.o(228893);
              return;
            }
            catch (Exception localException)
            {
              Log.printErrStackTrace("MicroMsg.Video.AbstractVideoTextureView", localException, "reset media player error", new Object[0]);
              AppMethodBeat.o(228893);
            }
          }
        });
        this.cJz = null;
        return;
        bool1 = false;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.Video.AbstractVideoTextureView", localException, "stop media player error", new Object[0]);
        }
      }
    }
  }
  
  private void bXd()
  {
    if ((Util.isNullOrNil(this.pDg)) || (this.mSurface == null))
    {
      Log.i("MicroMsg.Video.AbstractVideoTextureView", "openVideo, try later, url:%s, surface:%s", new Object[] { this.pDg, this.mSurface });
      return;
    }
    bXc();
    Log.i("MicroMsg.Video.AbstractVideoTextureView", "%d open video %s", new Object[] { Integer.valueOf(hashCode()), this.pDg });
    for (;;)
    {
      try
      {
        this.cJz = bXb();
        this.cJz.a(this.pDr);
        this.cJz.a(this.pDq);
        this.pDh = false;
        this.alM = -1;
        this.pDo = 0;
        this.cJz.a(this.pDv);
        this.cJz.a(this.pDw);
        this.cJz.a(this.pDs);
        this.cJz.a(this.pDt);
        this.cJz.a(this.pDu);
        final Runnable local7 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(227419);
            try
            {
              AbstractVideoTextureView.this.cJz.setSurface(AbstractVideoTextureView.a(AbstractVideoTextureView.this));
              AbstractVideoTextureView.this.cJz.prepareAsync();
              AbstractVideoTextureView.a(AbstractVideoTextureView.this, AbstractVideoTextureView.this.cJz.getVideoHeight());
              AbstractVideoTextureView.b(AbstractVideoTextureView.this, AbstractVideoTextureView.this.cJz.getVideoWidth());
              AbstractVideoTextureView.this.setMute(AbstractVideoTextureView.b(AbstractVideoTextureView.this));
              AbstractVideoTextureView.this.aO(AbstractVideoTextureView.c(AbstractVideoTextureView.this));
              AppMethodBeat.o(227419);
              return;
            }
            catch (Exception localException)
            {
              Log.printErrStackTrace("MicroMsg.Video.AbstractVideoTextureView", localException, "prepare async error path", new Object[0]);
              if (AbstractVideoTextureView.d(AbstractVideoTextureView.this) != null) {
                AbstractVideoTextureView.d(AbstractVideoTextureView.this).onError(-1, -1);
              }
              AppMethodBeat.o(227419);
            }
          }
        };
        if (Util.isNullOrNil(this.pDg)) {
          break label302;
        }
        this.cJz.a(this.pDg, null, new e.c()
        {
          public final void bWl()
          {
            AppMethodBeat.i(227167);
            Log.i("MicroMsg.Video.AbstractVideoTextureView", "onDataSourceSet#openVideo");
            local7.run();
            AppMethodBeat.o(227167);
          }
        });
        Log.i("MicroMsg.Video.AbstractVideoTextureView", "%d open video success player[%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.cJz.hashCode()) });
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.Video.AbstractVideoTextureView", localException, "prepare async error path", new Object[0]);
      }
      if (this.pDi == null) {
        break;
      }
      this.pDi.onError(-1, -1);
      return;
      label302:
      localException.run();
    }
  }
  
  public final boolean aO(float paramFloat)
  {
    if (paramFloat <= 0.0F) {}
    do
    {
      return false;
      this.aNo = paramFloat;
    } while (this.cJz == null);
    this.cJz.aP(this.aNo);
    return false;
  }
  
  public final void b(double paramDouble, boolean paramBoolean)
  {
    q(paramDouble);
    this.cJM = paramBoolean;
  }
  
  protected abstract e bXb();
  
  public final void bXe()
  {
    if ((this.cJz != null) && (this.pDh) && (this.mSurface != null) && (this.mSurface.isValid()))
    {
      Log.i("MicroMsg.Video.AbstractVideoTextureView", "%d flush surface start time[%d] ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(getCurrentPosition()) });
      this.pDA = true;
      this.cJz.setVolume(0.0F, 0.0F);
      this.cJz.start();
    }
  }
  
  public int getCurrentPosition()
  {
    if ((this.cJz != null) && (this.pDh)) {
      return this.cJz.getCurrentPosition();
    }
    if (this.cJz == null) {
      return -1;
    }
    return 0;
  }
  
  public int getDownloadPercent()
  {
    return this.pDo;
  }
  
  public int getDuration()
  {
    if ((this.cJz != null) && (this.pDh))
    {
      if (this.alM > 0) {
        return this.alM;
      }
      this.alM = this.cJz.getDuration();
      return this.alM;
    }
    this.alM = -1;
    return this.alM;
  }
  
  public double getLastProgresstime()
  {
    return 0.0D;
  }
  
  public long getLastSurfaceUpdateTime()
  {
    return this.pDx;
  }
  
  public String getVideoPath()
  {
    return this.pDg;
  }
  
  public final boolean isPlaying()
  {
    if ((this.cJz != null) && (this.pDh) && (!this.pDz) && (!this.pDA)) {}
    for (boolean bool = this.cJz.isPlaying();; bool = false)
    {
      Log.d("MicroMsg.Video.AbstractVideoTextureView", "%d is playing result [%b] pauseWhenUpdated[%b] mIsPrepared[%b]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(bool), Boolean.valueOf(this.pDz), Boolean.valueOf(this.pDh) });
      return bool;
    }
  }
  
  protected final void j(Surface paramSurface)
  {
    h.ZvG.be(new AbstractVideoTextureView.5(this, paramSurface));
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
    this.pDC.A(paramInt1, paramInt2, i, j);
    setMeasuredDimension(this.pDC.pEl, this.pDC.pEm);
  }
  
  public final void pause()
  {
    if ((this.cJz != null) && (this.pDh) && (this.cJz.isPlaying()))
    {
      Log.d("MicroMsg.Video.AbstractVideoTextureView", "pause video.");
      this.cJz.pause();
    }
    this.cJM = false;
  }
  
  public final void q(double paramDouble)
  {
    if (this.cJz != null)
    {
      this.cJz.seekTo((int)paramDouble);
      this.cJM = true;
      Log.d("MicroMsg.Video.AbstractVideoTextureView", "seek to time: " + paramDouble + " curr pos : " + this.cJz.getCurrentPosition());
    }
  }
  
  public void setForceScaleFullScreen(boolean paramBoolean)
  {
    this.pDp = paramBoolean;
    this.pDC.pDp = this.pDp;
  }
  
  public void setLoop(boolean paramBoolean)
  {
    if (this.cJz != null) {
      this.cJz.setLooping(paramBoolean);
    }
    this.mfK = true;
  }
  
  public void setMute(boolean paramBoolean)
  {
    Log.i("MicroMsg.Video.AbstractVideoTextureView", "%d set mute %b", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean) });
    this.iYs = paramBoolean;
    if (this.cJz != null)
    {
      if (this.iYs) {
        this.cJz.setVolume(0.0F, 0.0F);
      }
    }
    else {
      return;
    }
    this.cJz.setVolume(1.0F, 1.0F);
  }
  
  public void setOnInfoCallback(a.b paramb)
  {
    this.pDl = paramb;
  }
  
  public void setOnSeekCompleteCallback(a.c paramc)
  {
    this.pDk = paramc;
  }
  
  public void setOnSurfaceCallback(a.d paramd)
  {
    this.pDm = paramd;
  }
  
  public void setOneTimeVideoTextureUpdateCallback(a.e parame)
  {
    this.pDj = parame;
  }
  
  public void setPlayProgressCallback(boolean paramBoolean) {}
  
  public void setScaleType(d.h paramh)
  {
    b localb = this.pDC;
    Log.i("MicroMsg.ViewSizeCache", "set scale type old[%s] new[%s]", new Object[] { localb.pvg, paramh });
    localb.pvg = paramh;
    localb.reset();
    requestLayout();
  }
  
  public void setThumb(Bitmap paramBitmap) {}
  
  public void setVideoCallback(a.a parama)
  {
    this.pDi = parama;
  }
  
  public void setVideoPath(String paramString)
  {
    this.pDg = paramString;
    this.cJM = false;
    bXd();
    requestLayout();
  }
  
  public final boolean start()
  {
    if (this.mSurface == null)
    {
      Log.w("MicroMsg.Video.AbstractVideoTextureView", "%d it surface not ready, do not start", new Object[] { Integer.valueOf(hashCode()) });
      this.pDy = true;
      this.cJM = true;
      return false;
    }
    if (this.startTime == 0L) {}
    for (long l = Util.nowSecond();; l = this.startTime)
    {
      this.startTime = l;
      Log.i("MicroMsg.Video.AbstractVideoTextureView", "start %d mIsPrepared %b pauseWhenUpdated %b mediaPlayer %s", new Object[] { Long.valueOf(this.startTime), Boolean.valueOf(this.pDh), Boolean.valueOf(this.pDz), this.cJz });
      if ((this.cJz == null) || (!this.pDh)) {
        break;
      }
      if (this.pDz)
      {
        this.pDz = false;
        setMute(this.iYs);
      }
      this.cJz.start();
      this.cJM = true;
      return true;
    }
    if ((this.cJz == null) && (this.pDh))
    {
      this.cJM = true;
      bXd();
      requestLayout();
      return true;
    }
    this.cJM = true;
    return false;
  }
  
  public final void stop()
  {
    long l1;
    long l3;
    if (this.pDn > 0L)
    {
      l1 = this.pDn - this.startTime;
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
      if (this.pDi != null) {
        getDuration();
      }
      bXc();
      this.pDC.reset();
      try
      {
        if ((this.mSurface != null) && (this.pDh))
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
      this.pDg = "";
      this.pDo = 0;
      this.pDh = false;
      this.cJM = false;
      this.pDx = 0L;
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