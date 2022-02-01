package com.tencent.mm.plugin.appbrand.jsapi.video.videoview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g.i;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public abstract class AbstractVideoTextureView
  extends TextureView
  implements a
{
  private float cHk = -1.0F;
  private int cam;
  protected g eDi = null;
  private boolean eDv;
  private boolean lAj = false;
  private Surface mSurface = null;
  private int mVideoHeight = 0;
  private int mVideoWidth = 0;
  private boolean oYG = false;
  private int sIA = 0;
  private boolean sIB = false;
  private g.j sIC = new g.j()
  {
    public final void onVideoSizeChanged(g paramAnonymousg, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(328845);
      try
      {
        if (paramAnonymousg != AbstractVideoTextureView.this.eDi)
        {
          Log.w("MicroMsg.Video.AbstractVideoTextureView", "another player on video size changed, return now.[%s, %s]", new Object[] { paramAnonymousg, AbstractVideoTextureView.this.eDi });
          AppMethodBeat.o(328845);
          return;
        }
        AbstractVideoTextureView.b(AbstractVideoTextureView.this, paramAnonymousg.getVideoWidth());
        AbstractVideoTextureView.a(AbstractVideoTextureView.this, paramAnonymousg.getVideoHeight());
        Log.i("MicroMsg.Video.AbstractVideoTextureView", "on size change size:( " + AbstractVideoTextureView.e(AbstractVideoTextureView.this) + " , " + AbstractVideoTextureView.f(AbstractVideoTextureView.this) + " )");
        if (AbstractVideoTextureView.d(AbstractVideoTextureView.this) != null) {
          AbstractVideoTextureView.d(AbstractVideoTextureView.this).fG(AbstractVideoTextureView.e(AbstractVideoTextureView.this), AbstractVideoTextureView.f(AbstractVideoTextureView.this));
        }
      }
      catch (Exception paramAnonymousg)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.Video.AbstractVideoTextureView", paramAnonymousg, "on video size changed error[%d, %d]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        }
      }
      AbstractVideoTextureView.g(AbstractVideoTextureView.this);
      AppMethodBeat.o(328845);
    }
  };
  private g.h sID = new g.h()
  {
    public final void onPrepared(g paramAnonymousg)
    {
      AppMethodBeat.i(328871);
      if ((paramAnonymousg != AbstractVideoTextureView.this.eDi) && (paramAnonymousg != null))
      {
        Log.w("MicroMsg.Video.AbstractVideoTextureView", "another player callback, release now.[%s, %s]", new Object[] { paramAnonymousg, AbstractVideoTextureView.this.eDi });
        AbstractVideoTextureView.a(AbstractVideoTextureView.this, paramAnonymousg);
        AppMethodBeat.o(328871);
        return;
      }
      AbstractVideoTextureView.h(AbstractVideoTextureView.this);
      AbstractVideoTextureView localAbstractVideoTextureView = AbstractVideoTextureView.this;
      int i;
      if (paramAnonymousg != null)
      {
        i = paramAnonymousg.getVideoWidth();
        AbstractVideoTextureView.b(localAbstractVideoTextureView, i);
        localAbstractVideoTextureView = AbstractVideoTextureView.this;
        if (paramAnonymousg == null) {
          break label270;
        }
        i = paramAnonymousg.getVideoHeight();
        label105:
        AbstractVideoTextureView.a(localAbstractVideoTextureView, i);
        Log.i("MicroMsg.Video.AbstractVideoTextureView", "on prepared. size [%d, %d] mStartWhenPrepared %b ", new Object[] { Integer.valueOf(AbstractVideoTextureView.e(AbstractVideoTextureView.this)), Integer.valueOf(AbstractVideoTextureView.f(AbstractVideoTextureView.this)), Boolean.valueOf(AbstractVideoTextureView.i(AbstractVideoTextureView.this)) });
        AbstractVideoTextureView.g(AbstractVideoTextureView.this);
        if ((AbstractVideoTextureView.e(AbstractVideoTextureView.this) == 0) || (AbstractVideoTextureView.f(AbstractVideoTextureView.this) == 0)) {
          break label275;
        }
        if (AbstractVideoTextureView.i(AbstractVideoTextureView.this))
        {
          AbstractVideoTextureView.this.eDi.start();
          AbstractVideoTextureView.this.eDi.setLooping(AbstractVideoTextureView.j(AbstractVideoTextureView.this));
          AbstractVideoTextureView.k(AbstractVideoTextureView.this);
        }
      }
      for (;;)
      {
        if (AbstractVideoTextureView.d(AbstractVideoTextureView.this) != null) {
          AbstractVideoTextureView.d(AbstractVideoTextureView.this).Qz();
        }
        AppMethodBeat.o(328871);
        return;
        i = 0;
        break;
        label270:
        i = 0;
        break label105;
        label275:
        if (AbstractVideoTextureView.i(AbstractVideoTextureView.this))
        {
          AbstractVideoTextureView.this.eDi.start();
          AbstractVideoTextureView.k(AbstractVideoTextureView.this);
          AbstractVideoTextureView.this.eDi.setLooping(AbstractVideoTextureView.j(AbstractVideoTextureView.this));
        }
      }
    }
  };
  private g.i sIE = new g.i()
  {
    public final void onSeekComplete(g paramAnonymousg)
    {
      AppMethodBeat.i(328872);
      if (paramAnonymousg != null) {}
      for (int i = paramAnonymousg.getCurrentPosition();; i = -1)
      {
        Log.i("MicroMsg.Video.AbstractVideoTextureView", "video seek complete curPos[%d] mStartWhenPrepared[%b] pauseWhenUpdated[%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(AbstractVideoTextureView.i(AbstractVideoTextureView.this)), Boolean.valueOf(AbstractVideoTextureView.l(AbstractVideoTextureView.this)) });
        if (!AbstractVideoTextureView.i(AbstractVideoTextureView.this)) {
          break label143;
        }
        if (!AbstractVideoTextureView.l(AbstractVideoTextureView.this)) {
          break;
        }
        AppMethodBeat.o(328872);
        return;
      }
      AbstractVideoTextureView.this.start();
      for (;;)
      {
        if (AbstractVideoTextureView.m(AbstractVideoTextureView.this) != null) {
          AbstractVideoTextureView.m(AbstractVideoTextureView.this).onSeekComplete(AbstractVideoTextureView.i(AbstractVideoTextureView.this));
        }
        AbstractVideoTextureView.a(AbstractVideoTextureView.this, 0L);
        AppMethodBeat.o(328872);
        return;
        label143:
        AbstractVideoTextureView.this.pause();
      }
    }
  };
  private g.a sIF = new AbstractVideoTextureView.12(this);
  private g.g sIG = new g.g()
  {
    public final boolean onInfo(g paramAnonymousg, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(328868);
      Log.d("MicroMsg.Video.AbstractVideoTextureView", "onInfo [%d %d]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
      if (AbstractVideoTextureView.n(AbstractVideoTextureView.this) != null) {
        AbstractVideoTextureView.n(AbstractVideoTextureView.this).onInfo(paramAnonymousInt1, paramAnonymousInt2);
      }
      AppMethodBeat.o(328868);
      return false;
    }
  };
  private g.b sIH = new g.b()
  {
    public final void onCompletion(g paramAnonymousg)
    {
      AppMethodBeat.i(328857);
      Log.i("MicroMsg.Video.AbstractVideoTextureView", "video on completion");
      AbstractVideoTextureView.b(AbstractVideoTextureView.this, Util.nowSecond());
      if (AbstractVideoTextureView.d(AbstractVideoTextureView.this) != null) {
        AbstractVideoTextureView.d(AbstractVideoTextureView.this).onCompletion();
      }
      AppMethodBeat.o(328857);
    }
  };
  private g.e sII = new g.e()
  {
    public final boolean onError(g paramAnonymousg, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(328863);
      Log.w("MicroMsg.Video.AbstractVideoTextureView", "Error: " + paramAnonymousInt1 + "," + paramAnonymousInt2);
      if (AbstractVideoTextureView.d(AbstractVideoTextureView.this) != null) {
        AbstractVideoTextureView.d(AbstractVideoTextureView.this).onError(paramAnonymousInt1, paramAnonymousInt2);
      }
      AppMethodBeat.o(328863);
      return true;
    }
  };
  private long sIJ = 0L;
  private boolean sIK = false;
  private boolean sIL = false;
  private boolean sIM = false;
  private TextureView.SurfaceTextureListener sIN = new TextureView.SurfaceTextureListener()
  {
    public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(328873);
      AbstractVideoTextureView.this.n(AbstractVideoTextureView.a(AbstractVideoTextureView.this));
      AbstractVideoTextureView.a(AbstractVideoTextureView.this, new Surface(paramAnonymousSurfaceTexture));
      Log.i("MicroMsg.Video.AbstractVideoTextureView", "%d on texture available %d*%d mIsPrepared[%b] mSurface[%d] ", new Object[] { Integer.valueOf(AbstractVideoTextureView.this.hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Boolean.valueOf(AbstractVideoTextureView.t(AbstractVideoTextureView.this)), Integer.valueOf(AbstractVideoTextureView.a(AbstractVideoTextureView.this).hashCode()) });
      if ((AbstractVideoTextureView.this.eDi == null) || (!AbstractVideoTextureView.t(AbstractVideoTextureView.this)))
      {
        AbstractVideoTextureView.v(AbstractVideoTextureView.this);
        if (AbstractVideoTextureView.x(AbstractVideoTextureView.this) != null) {
          AbstractVideoTextureView.x(AbstractVideoTextureView.this).bNV();
        }
        AppMethodBeat.o(328873);
        return;
      }
      AbstractVideoTextureView.this.eDi.setSurface(AbstractVideoTextureView.a(AbstractVideoTextureView.this));
      if (AbstractVideoTextureView.w(AbstractVideoTextureView.this)) {
        AbstractVideoTextureView.this.eDi.start();
      }
      for (;;)
      {
        AbstractVideoTextureView.b(AbstractVideoTextureView.this, false);
        break;
        AbstractVideoTextureView.a(AbstractVideoTextureView.this, true);
        AbstractVideoTextureView.this.eDi.setVolume(0.0F, 0.0F);
        AbstractVideoTextureView.this.eDi.start();
      }
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
    {
      AppMethodBeat.i(328865);
      Log.i("MicroMsg.Video.AbstractVideoTextureView", "%d on texture destroyed mIsPrepared[%b]", new Object[] { Integer.valueOf(AbstractVideoTextureView.this.hashCode()), Boolean.valueOf(AbstractVideoTextureView.t(AbstractVideoTextureView.this)) });
      AbstractVideoTextureView.this.n(AbstractVideoTextureView.a(AbstractVideoTextureView.this));
      AbstractVideoTextureView.a(AbstractVideoTextureView.this, null);
      if ((AbstractVideoTextureView.this.eDi != null) && (AbstractVideoTextureView.t(AbstractVideoTextureView.this))) {
        if (AbstractVideoTextureView.this.isPlaying())
        {
          AbstractVideoTextureView.b(AbstractVideoTextureView.this, true);
          AbstractVideoTextureView.this.eDi.pause();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(328865);
        return false;
        AbstractVideoTextureView.u(AbstractVideoTextureView.this);
        AbstractVideoTextureView.b(AbstractVideoTextureView.this, false);
      }
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(328856);
      Log.i("MicroMsg.Video.AbstractVideoTextureView", "on texture size changed width : " + paramAnonymousInt1 + " height : " + paramAnonymousInt2);
      if ((AbstractVideoTextureView.this.eDi != null) && (AbstractVideoTextureView.t(AbstractVideoTextureView.this)) && (AbstractVideoTextureView.e(AbstractVideoTextureView.this) == paramAnonymousInt1) && (AbstractVideoTextureView.f(AbstractVideoTextureView.this) == paramAnonymousInt2)) {
        AbstractVideoTextureView.this.eDi.start();
      }
      AppMethodBeat.o(328856);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture)
    {
      AppMethodBeat.i(328850);
      Log.d("MicroMsg.Video.AbstractVideoTextureView", "on surface texture updated");
      if (AbstractVideoTextureView.l(AbstractVideoTextureView.this)) {
        if (AbstractVideoTextureView.this.eDi != null)
        {
          AbstractVideoTextureView.this.eDi.pause();
          if (!AbstractVideoTextureView.b(AbstractVideoTextureView.this)) {
            break label227;
          }
          AbstractVideoTextureView.this.eDi.setVolume(0.0F, 0.0F);
        }
      }
      for (;;)
      {
        AbstractVideoTextureView.a(AbstractVideoTextureView.this, false);
        if ((AbstractVideoTextureView.o(AbstractVideoTextureView.this) > 0L) && (AbstractVideoTextureView.p(AbstractVideoTextureView.this) != null))
        {
          AbstractVideoTextureView.p(AbstractVideoTextureView.this).onTextureUpdate();
          AbstractVideoTextureView.q(AbstractVideoTextureView.this);
        }
        AbstractVideoTextureView.a(AbstractVideoTextureView.this, System.currentTimeMillis());
        if (AbstractVideoTextureView.r(AbstractVideoTextureView.this))
        {
          Log.i("MicroMsg.Video.AbstractVideoTextureView", "%d flush surface pause now time[%d]", new Object[] { Integer.valueOf(AbstractVideoTextureView.this.hashCode()), Integer.valueOf(AbstractVideoTextureView.this.getCurrentPosition()) });
          if (AbstractVideoTextureView.this.eDi != null)
          {
            AbstractVideoTextureView.this.eDi.pause();
            AbstractVideoTextureView.this.setMute(AbstractVideoTextureView.b(AbstractVideoTextureView.this));
          }
          AbstractVideoTextureView.s(AbstractVideoTextureView.this);
        }
        AppMethodBeat.o(328850);
        return;
        label227:
        AbstractVideoTextureView.this.eDi.setVolume(1.0F, 1.0F);
      }
    }
  };
  private b sIO = new b();
  private String sIs;
  private boolean sIt;
  private a.a sIu;
  private a.e sIv;
  private a.c sIw;
  private a.b sIx;
  private a.d sIy;
  private long sIz = 0L;
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
    setSurfaceTextureListener(this.sIN);
    setFocusable(true);
    setFocusableInTouchMode(true);
  }
  
  private void cxn()
  {
    boolean bool1 = true;
    int i = hashCode();
    boolean bool2 = this.sIt;
    if (this.eDi == null) {}
    for (;;)
    {
      Log.i("MicroMsg.Video.AbstractVideoTextureView", "%d release media player isPrepared[%b] player is null[%b] ", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if (this.eDi != null)
      {
        this.eDi.a(null);
        this.eDi.a(null);
      }
      try
      {
        this.eDi.stop();
        g localg = this.eDi;
        h.ahAA.bm(new AbstractVideoTextureView.1(this, localg));
        this.eDi = null;
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
  
  private void cxo()
  {
    if ((Util.isNullOrNil(this.sIs)) || (this.mSurface == null))
    {
      Log.i("MicroMsg.Video.AbstractVideoTextureView", "openVideo, try later, url:%s, surface:%s", new Object[] { this.sIs, this.mSurface });
      return;
    }
    cxn();
    Log.i("MicroMsg.Video.AbstractVideoTextureView", "%d open video %s", new Object[] { Integer.valueOf(hashCode()), this.sIs });
    for (;;)
    {
      try
      {
        this.eDi = cxm();
        this.eDi.a(this.sID);
        this.eDi.a(this.sIC);
        this.sIt = false;
        this.cam = -1;
        this.sIA = 0;
        this.eDi.a(this.sIH);
        this.eDi.a(this.sII);
        this.eDi.a(this.sIE);
        this.eDi.a(this.sIF);
        this.eDi.a(this.sIG);
        Runnable local7 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(328858);
            try
            {
              AbstractVideoTextureView.this.eDi.setSurface(AbstractVideoTextureView.a(AbstractVideoTextureView.this));
              AbstractVideoTextureView.this.eDi.prepareAsync();
              AbstractVideoTextureView.a(AbstractVideoTextureView.this, AbstractVideoTextureView.this.eDi.getVideoHeight());
              AbstractVideoTextureView.b(AbstractVideoTextureView.this, AbstractVideoTextureView.this.eDi.getVideoWidth());
              AbstractVideoTextureView.this.setMute(AbstractVideoTextureView.b(AbstractVideoTextureView.this));
              AbstractVideoTextureView.this.bM(AbstractVideoTextureView.c(AbstractVideoTextureView.this));
              AppMethodBeat.o(328858);
              return;
            }
            catch (Exception localException)
            {
              Log.printErrStackTrace("MicroMsg.Video.AbstractVideoTextureView", localException, "prepare async error path", new Object[0]);
              if (AbstractVideoTextureView.d(AbstractVideoTextureView.this) != null) {
                AbstractVideoTextureView.d(AbstractVideoTextureView.this).onError(-1, -1);
              }
              AppMethodBeat.o(328858);
            }
          }
        };
        if (Util.isNullOrNil(this.sIs)) {
          break label302;
        }
        this.eDi.a(this.sIs, null, new AbstractVideoTextureView.8(this, local7));
        Log.i("MicroMsg.Video.AbstractVideoTextureView", "%d open video success player[%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.eDi.hashCode()) });
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.Video.AbstractVideoTextureView", localException, "prepare async error path", new Object[0]);
      }
      if (this.sIu == null) {
        break;
      }
      this.sIu.onError(-1, -1);
      return;
      label302:
      localException.run();
    }
  }
  
  public final void H(double paramDouble)
  {
    if (this.eDi != null)
    {
      this.eDi.seekTo((int)paramDouble);
      this.eDv = true;
      Log.d("MicroMsg.Video.AbstractVideoTextureView", "seek to time: " + paramDouble + " curr pos : " + this.eDi.getCurrentPosition());
    }
  }
  
  public final boolean bM(float paramFloat)
  {
    if (paramFloat <= 0.0F) {}
    do
    {
      return false;
      this.cHk = paramFloat;
    } while (this.eDi == null);
    this.eDi.bN(this.cHk);
    return false;
  }
  
  public final void c(double paramDouble, boolean paramBoolean)
  {
    H(paramDouble);
    this.eDv = paramBoolean;
  }
  
  protected abstract g cxm();
  
  public final void cxp()
  {
    if ((this.eDi != null) && (this.sIt) && (this.mSurface != null) && (this.mSurface.isValid()))
    {
      Log.i("MicroMsg.Video.AbstractVideoTextureView", "%d flush surface start time[%d] ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(getCurrentPosition()) });
      this.sIM = true;
      this.eDi.setVolume(0.0F, 0.0F);
      this.eDi.start();
    }
  }
  
  public int getCurrentPosition()
  {
    if ((this.eDi != null) && (this.sIt)) {
      return this.eDi.getCurrentPosition();
    }
    if (this.eDi == null) {
      return -1;
    }
    return 0;
  }
  
  public int getDownloadPercent()
  {
    return this.sIA;
  }
  
  public int getDuration()
  {
    if ((this.eDi != null) && (this.sIt))
    {
      if (this.cam > 0) {
        return this.cam;
      }
      this.cam = this.eDi.getDuration();
      return this.cam;
    }
    this.cam = -1;
    return this.cam;
  }
  
  public double getLastProgresstime()
  {
    return 0.0D;
  }
  
  public long getLastSurfaceUpdateTime()
  {
    return this.sIJ;
  }
  
  public String getVideoPath()
  {
    return this.sIs;
  }
  
  public final boolean isPlaying()
  {
    if ((this.eDi != null) && (this.sIt) && (!this.sIL) && (!this.sIM)) {}
    for (boolean bool = this.eDi.isPlaying();; bool = false)
    {
      Log.d("MicroMsg.Video.AbstractVideoTextureView", "%d is playing result [%b] pauseWhenUpdated[%b] mIsPrepared[%b]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(bool), Boolean.valueOf(this.sIL), Boolean.valueOf(this.sIt) });
      return bool;
    }
  }
  
  protected final void n(Surface paramSurface)
  {
    h.ahAA.bm(new AbstractVideoTextureView.5(this, paramSurface));
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
    this.sIO.G(paramInt1, paramInt2, i, j);
    setMeasuredDimension(this.sIO.sJw, this.sIO.sJx);
  }
  
  public final void pause()
  {
    if ((this.eDi != null) && (this.sIt) && (this.eDi.isPlaying()))
    {
      Log.d("MicroMsg.Video.AbstractVideoTextureView", "pause video.");
      this.eDi.pause();
    }
    this.eDv = false;
  }
  
  public void setForceScaleFullScreen(boolean paramBoolean)
  {
    this.sIB = paramBoolean;
    this.sIO.sIB = this.sIB;
  }
  
  public void setLoop(boolean paramBoolean)
  {
    if (this.eDi != null) {
      this.eDi.setLooping(paramBoolean);
    }
    this.oYG = true;
  }
  
  public void setMute(boolean paramBoolean)
  {
    Log.i("MicroMsg.Video.AbstractVideoTextureView", "%d set mute %b", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean) });
    this.lAj = paramBoolean;
    if (this.eDi != null)
    {
      if (this.lAj) {
        this.eDi.setVolume(0.0F, 0.0F);
      }
    }
    else {
      return;
    }
    this.eDi.setVolume(1.0F, 1.0F);
  }
  
  public void setOnInfoCallback(a.b paramb)
  {
    this.sIx = paramb;
  }
  
  public void setOnSeekCompleteCallback(a.c paramc)
  {
    this.sIw = paramc;
  }
  
  public void setOnSurfaceCallback(a.d paramd)
  {
    this.sIy = paramd;
  }
  
  public void setOneTimeVideoTextureUpdateCallback(a.e parame)
  {
    this.sIv = parame;
  }
  
  public void setPlayProgressCallback(boolean paramBoolean) {}
  
  public void setScaleType(d.h paramh)
  {
    b localb = this.sIO;
    Log.i("MicroMsg.ViewSizeCache", "set scale type old[%s] new[%s]", new Object[] { localb.sAm, paramh });
    localb.sAm = paramh;
    localb.reset();
    requestLayout();
  }
  
  public void setThumb(Bitmap paramBitmap) {}
  
  public void setVideoCallback(a.a parama)
  {
    this.sIu = parama;
  }
  
  public void setVideoPath(String paramString)
  {
    this.sIs = paramString;
    this.eDv = false;
    cxo();
    requestLayout();
  }
  
  public final boolean start()
  {
    if (this.mSurface == null)
    {
      Log.w("MicroMsg.Video.AbstractVideoTextureView", "%d it surface not ready, do not start", new Object[] { Integer.valueOf(hashCode()) });
      this.sIK = true;
      this.eDv = true;
      return false;
    }
    if (this.startTime == 0L) {}
    for (long l = Util.nowSecond();; l = this.startTime)
    {
      this.startTime = l;
      Log.i("MicroMsg.Video.AbstractVideoTextureView", "start %d mIsPrepared %b pauseWhenUpdated %b mediaPlayer %s", new Object[] { Long.valueOf(this.startTime), Boolean.valueOf(this.sIt), Boolean.valueOf(this.sIL), this.eDi });
      if ((this.eDi == null) || (!this.sIt)) {
        break;
      }
      if (this.sIL)
      {
        this.sIL = false;
        setMute(this.lAj);
      }
      this.eDi.start();
      this.eDv = true;
      return true;
    }
    if ((this.eDi == null) && (this.sIt))
    {
      this.eDv = true;
      cxo();
      requestLayout();
      return true;
    }
    this.eDv = true;
    return false;
  }
  
  public final void stop()
  {
    long l1;
    long l3;
    if (this.sIz > 0L)
    {
      l1 = this.sIz - this.startTime;
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
      if (this.sIu != null) {
        getDuration();
      }
      cxn();
      this.sIO.reset();
      try
      {
        if ((this.mSurface != null) && (this.sIt))
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
      this.sIs = "";
      this.sIA = 0;
      this.sIt = false;
      this.eDv = false;
      this.sIJ = 0L;
      return;
      l1 = 2147483647L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoTextureView
 * JD-Core Version:    0.7.0.1
 */