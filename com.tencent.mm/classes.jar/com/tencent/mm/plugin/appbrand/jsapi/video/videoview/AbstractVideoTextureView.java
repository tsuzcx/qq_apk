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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  protected com.tencent.mm.plugin.appbrand.jsapi.video.e.b cuX = null;
  private boolean cvk;
  private boolean fOX = false;
  private boolean iuX = false;
  private String lwY;
  private boolean lwZ;
  private a.a lxa;
  private a.e lxb;
  private a.c lxc;
  private a.b lxd;
  private a.d lxe;
  private long lxf = 0L;
  private int lxg = 0;
  private boolean lxh = false;
  private b.h lxi = new b.h()
  {
    public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramAnonymousb, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(211488);
      try
      {
        if (paramAnonymousb != AbstractVideoTextureView.this.cuX)
        {
          ae.w("MicroMsg.Video.AbstractVideoTextureView", "another player on video size changed, return now.[%s, %s]", new Object[] { paramAnonymousb, AbstractVideoTextureView.this.cuX });
          AppMethodBeat.o(211488);
          return;
        }
        AbstractVideoTextureView.a(AbstractVideoTextureView.this, paramAnonymousb.getVideoWidth());
        AbstractVideoTextureView.b(AbstractVideoTextureView.this, paramAnonymousb.getVideoHeight());
        ae.i("MicroMsg.Video.AbstractVideoTextureView", "on size change size:( " + AbstractVideoTextureView.a(AbstractVideoTextureView.this) + " , " + AbstractVideoTextureView.b(AbstractVideoTextureView.this) + " )");
        if (AbstractVideoTextureView.c(AbstractVideoTextureView.this) != null) {
          AbstractVideoTextureView.c(AbstractVideoTextureView.this).eb(AbstractVideoTextureView.a(AbstractVideoTextureView.this), AbstractVideoTextureView.b(AbstractVideoTextureView.this));
        }
      }
      catch (Exception paramAnonymousb)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.Video.AbstractVideoTextureView", paramAnonymousb, "on video size changed error[%d, %d]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        }
      }
      AbstractVideoTextureView.d(AbstractVideoTextureView.this);
      AppMethodBeat.o(211488);
    }
  };
  private b.f lxj = new b.f()
  {
    public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramAnonymousb)
    {
      AppMethodBeat.i(211489);
      if (paramAnonymousb != AbstractVideoTextureView.this.cuX)
      {
        ae.w("MicroMsg.Video.AbstractVideoTextureView", "another player callback, release now.[%s, %s]", new Object[] { paramAnonymousb, AbstractVideoTextureView.this.cuX });
        AbstractVideoTextureView.a(AbstractVideoTextureView.this, paramAnonymousb);
        AppMethodBeat.o(211489);
        return;
      }
      AbstractVideoTextureView.e(AbstractVideoTextureView.this);
      AbstractVideoTextureView.a(AbstractVideoTextureView.this, paramAnonymousb.getVideoWidth());
      AbstractVideoTextureView.b(AbstractVideoTextureView.this, paramAnonymousb.getVideoHeight());
      ae.i("MicroMsg.Video.AbstractVideoTextureView", "on prepared. size [%d, %d] mStartWhenPrepared %b ", new Object[] { Integer.valueOf(AbstractVideoTextureView.a(AbstractVideoTextureView.this)), Integer.valueOf(AbstractVideoTextureView.b(AbstractVideoTextureView.this)), Boolean.valueOf(AbstractVideoTextureView.f(AbstractVideoTextureView.this)) });
      AbstractVideoTextureView.d(AbstractVideoTextureView.this);
      if ((AbstractVideoTextureView.a(AbstractVideoTextureView.this) != 0) && (AbstractVideoTextureView.b(AbstractVideoTextureView.this) != 0)) {
        if (AbstractVideoTextureView.f(AbstractVideoTextureView.this))
        {
          AbstractVideoTextureView.this.cuX.start();
          AbstractVideoTextureView.this.cuX.setLooping(AbstractVideoTextureView.g(AbstractVideoTextureView.this));
          AbstractVideoTextureView.h(AbstractVideoTextureView.this);
        }
      }
      for (;;)
      {
        if (AbstractVideoTextureView.c(AbstractVideoTextureView.this) != null) {
          AbstractVideoTextureView.c(AbstractVideoTextureView.this).ta();
        }
        AppMethodBeat.o(211489);
        return;
        if (AbstractVideoTextureView.f(AbstractVideoTextureView.this))
        {
          AbstractVideoTextureView.this.cuX.start();
          AbstractVideoTextureView.h(AbstractVideoTextureView.this);
          AbstractVideoTextureView.this.cuX.setLooping(AbstractVideoTextureView.g(AbstractVideoTextureView.this));
        }
      }
    }
  };
  private b.g lxk = new b.g()
  {
    public final void b(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramAnonymousb)
    {
      AppMethodBeat.i(211490);
      ae.i("MicroMsg.Video.AbstractVideoTextureView", "video seek complete curPos[%d] mStartWhenPrepared[%b] pauseWhenUpdated[%b]", new Object[] { Integer.valueOf(paramAnonymousb.getCurrentPosition()), Boolean.valueOf(AbstractVideoTextureView.f(AbstractVideoTextureView.this)), Boolean.valueOf(AbstractVideoTextureView.i(AbstractVideoTextureView.this)) });
      if (AbstractVideoTextureView.f(AbstractVideoTextureView.this))
      {
        if (AbstractVideoTextureView.i(AbstractVideoTextureView.this))
        {
          AppMethodBeat.o(211490);
          return;
        }
        AbstractVideoTextureView.this.start();
      }
      for (;;)
      {
        if (AbstractVideoTextureView.j(AbstractVideoTextureView.this) != null) {
          AbstractVideoTextureView.j(AbstractVideoTextureView.this).eX(AbstractVideoTextureView.f(AbstractVideoTextureView.this));
        }
        AbstractVideoTextureView.a(AbstractVideoTextureView.this, 0L);
        AppMethodBeat.o(211490);
        return;
        AbstractVideoTextureView.this.pause();
      }
    }
  };
  private b.a lxl = new b.a()
  {
    public final void gN(int paramAnonymousInt)
    {
      AppMethodBeat.i(211491);
      ae.d("MicroMsg.Video.AbstractVideoTextureView", "onBufferingUpdate percent[%d]", new Object[] { Integer.valueOf(paramAnonymousInt) });
      AbstractVideoTextureView.c(AbstractVideoTextureView.this, paramAnonymousInt);
      AppMethodBeat.o(211491);
    }
  };
  private b.e lxm = new b.e()
  {
    public final boolean cb(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(211492);
      ae.d("MicroMsg.Video.AbstractVideoTextureView", "onInfo [%d %d]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
      if (AbstractVideoTextureView.k(AbstractVideoTextureView.this) != null) {
        AbstractVideoTextureView.k(AbstractVideoTextureView.this).ec(paramAnonymousInt1, paramAnonymousInt2);
      }
      AppMethodBeat.o(211492);
      return false;
    }
  };
  private b.b lxn = new b.b()
  {
    public final void GH()
    {
      AppMethodBeat.i(211493);
      ae.i("MicroMsg.Video.AbstractVideoTextureView", "video on completion");
      AbstractVideoTextureView.b(AbstractVideoTextureView.this, bu.aRi());
      if (AbstractVideoTextureView.c(AbstractVideoTextureView.this) != null) {
        AbstractVideoTextureView.c(AbstractVideoTextureView.this).onCompletion();
      }
      AppMethodBeat.o(211493);
    }
  };
  private b.d lxo = new b.d()
  {
    public final boolean cc(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(211494);
      ae.w("MicroMsg.Video.AbstractVideoTextureView", "Error: " + paramAnonymousInt1 + "," + paramAnonymousInt2);
      if (AbstractVideoTextureView.c(AbstractVideoTextureView.this) != null) {
        AbstractVideoTextureView.c(AbstractVideoTextureView.this).onError(paramAnonymousInt1, paramAnonymousInt2);
      }
      AppMethodBeat.o(211494);
      return true;
    }
  };
  private long lxp = 0L;
  private boolean lxq = false;
  private boolean lxr = false;
  private boolean lxs = false;
  private TextureView.SurfaceTextureListener lxt = new TextureView.SurfaceTextureListener()
  {
    public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(211498);
      AbstractVideoTextureView.this.h(AbstractVideoTextureView.s(AbstractVideoTextureView.this));
      AbstractVideoTextureView.a(AbstractVideoTextureView.this, new Surface(paramAnonymousSurfaceTexture));
      ae.i("MicroMsg.Video.AbstractVideoTextureView", "%d on texture available %d*%d mIsPrepared[%b] mSurface[%d] ", new Object[] { Integer.valueOf(AbstractVideoTextureView.this.hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Boolean.valueOf(AbstractVideoTextureView.r(AbstractVideoTextureView.this)), Integer.valueOf(AbstractVideoTextureView.s(AbstractVideoTextureView.this).hashCode()) });
      if ((AbstractVideoTextureView.this.cuX == null) || (!AbstractVideoTextureView.r(AbstractVideoTextureView.this)))
      {
        AbstractVideoTextureView.u(AbstractVideoTextureView.this);
        if (AbstractVideoTextureView.w(AbstractVideoTextureView.this) != null) {
          AbstractVideoTextureView.w(AbstractVideoTextureView.this).aMV();
        }
        AppMethodBeat.o(211498);
        return;
      }
      AbstractVideoTextureView.this.cuX.setSurface(AbstractVideoTextureView.s(AbstractVideoTextureView.this));
      if (AbstractVideoTextureView.v(AbstractVideoTextureView.this)) {
        AbstractVideoTextureView.this.cuX.start();
      }
      for (;;)
      {
        AbstractVideoTextureView.b(AbstractVideoTextureView.this, false);
        break;
        AbstractVideoTextureView.a(AbstractVideoTextureView.this, true);
        AbstractVideoTextureView.this.cuX.setVolume(0.0F, 0.0F);
        AbstractVideoTextureView.this.cuX.start();
      }
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
    {
      AppMethodBeat.i(211497);
      ae.i("MicroMsg.Video.AbstractVideoTextureView", "%d on texture destroyed mIsPrepared[%b]", new Object[] { Integer.valueOf(AbstractVideoTextureView.this.hashCode()), Boolean.valueOf(AbstractVideoTextureView.r(AbstractVideoTextureView.this)) });
      AbstractVideoTextureView.this.h(AbstractVideoTextureView.s(AbstractVideoTextureView.this));
      AbstractVideoTextureView.a(AbstractVideoTextureView.this, null);
      if ((AbstractVideoTextureView.this.cuX != null) && (AbstractVideoTextureView.r(AbstractVideoTextureView.this))) {
        if (AbstractVideoTextureView.this.isPlaying())
        {
          AbstractVideoTextureView.b(AbstractVideoTextureView.this, true);
          AbstractVideoTextureView.this.cuX.pause();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(211497);
        return false;
        AbstractVideoTextureView.t(AbstractVideoTextureView.this);
        AbstractVideoTextureView.b(AbstractVideoTextureView.this, false);
      }
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(211496);
      ae.i("MicroMsg.Video.AbstractVideoTextureView", "on texture size changed width : " + paramAnonymousInt1 + " height : " + paramAnonymousInt2);
      if ((AbstractVideoTextureView.this.cuX != null) && (AbstractVideoTextureView.r(AbstractVideoTextureView.this)) && (AbstractVideoTextureView.a(AbstractVideoTextureView.this) == paramAnonymousInt1) && (AbstractVideoTextureView.b(AbstractVideoTextureView.this) == paramAnonymousInt2)) {
        AbstractVideoTextureView.this.cuX.start();
      }
      AppMethodBeat.o(211496);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture)
    {
      AppMethodBeat.i(211495);
      ae.d("MicroMsg.Video.AbstractVideoTextureView", "on surface texture updated");
      if (AbstractVideoTextureView.i(AbstractVideoTextureView.this)) {
        if (AbstractVideoTextureView.this.cuX != null)
        {
          AbstractVideoTextureView.this.cuX.pause();
          if (!AbstractVideoTextureView.l(AbstractVideoTextureView.this)) {
            break label227;
          }
          AbstractVideoTextureView.this.cuX.setVolume(0.0F, 0.0F);
        }
      }
      for (;;)
      {
        AbstractVideoTextureView.a(AbstractVideoTextureView.this, false);
        if ((AbstractVideoTextureView.m(AbstractVideoTextureView.this) > 0L) && (AbstractVideoTextureView.n(AbstractVideoTextureView.this) != null))
        {
          AbstractVideoTextureView.n(AbstractVideoTextureView.this).bpD();
          AbstractVideoTextureView.o(AbstractVideoTextureView.this);
        }
        AbstractVideoTextureView.a(AbstractVideoTextureView.this, System.currentTimeMillis());
        if (AbstractVideoTextureView.p(AbstractVideoTextureView.this))
        {
          ae.i("MicroMsg.Video.AbstractVideoTextureView", "%d flush surface pause now time[%d]", new Object[] { Integer.valueOf(AbstractVideoTextureView.this.hashCode()), Integer.valueOf(AbstractVideoTextureView.this.getCurrentPosition()) });
          if (AbstractVideoTextureView.this.cuX != null)
          {
            AbstractVideoTextureView.this.cuX.pause();
            AbstractVideoTextureView.this.setMute(AbstractVideoTextureView.l(AbstractVideoTextureView.this));
          }
          AbstractVideoTextureView.q(AbstractVideoTextureView.this);
        }
        AppMethodBeat.o(211495);
        return;
        label227:
        AbstractVideoTextureView.this.cuX.setVolume(1.0F, 1.0F);
      }
    }
  };
  private b lxu = new b();
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
    setSurfaceTextureListener(this.lxt);
    setFocusable(true);
    setFocusableInTouchMode(true);
  }
  
  private void bpw()
  {
    boolean bool1 = true;
    int i = hashCode();
    boolean bool2 = this.lwZ;
    if (this.cuX == null) {}
    for (;;)
    {
      ae.i("MicroMsg.Video.AbstractVideoTextureView", "%d release media player isPrepared[%b] player is null[%b] ", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if (this.cuX != null)
      {
        this.cuX.a(null);
        this.cuX.a(null);
      }
      try
      {
        this.cuX.stop();
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            this.cuX.reset();
            this.cuX.release();
            this.cuX = null;
            return;
            bool1 = false;
            break;
            localException1 = localException1;
            ae.printErrStackTrace("MicroMsg.Video.AbstractVideoTextureView", localException1, "stop media player error", new Object[0]);
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.Video.AbstractVideoTextureView", localException2, "reset media player error", new Object[0]);
          }
        }
      }
    }
  }
  
  private void bpx()
  {
    if ((bu.isNullOrNil(this.lwY)) || (this.mSurface == null)) {
      ae.i("MicroMsg.Video.AbstractVideoTextureView", "openVideo, try later, url:%s, surface:%s", new Object[] { this.lwY, this.mSurface });
    }
    do
    {
      return;
      bpw();
      ae.i("MicroMsg.Video.AbstractVideoTextureView", "%d open video %s", new Object[] { Integer.valueOf(hashCode()), this.lwY });
      try
      {
        this.cuX = bpv();
        this.cuX.a(this.lxj);
        this.cuX.a(this.lxi);
        this.lwZ = false;
        this.atW = -1;
        this.lxg = 0;
        this.cuX.a(this.lxn);
        this.cuX.a(this.lxo);
        this.cuX.a(this.lxk);
        this.cuX.a(this.lxl);
        this.cuX.a(this.lxm);
        if (!bu.isNullOrNil(this.lwY)) {
          this.cuX.setDataSource(this.lwY);
        }
        this.cuX.setSurface(this.mSurface);
        this.cuX.prepareAsync();
        this.mVideoHeight = this.cuX.getVideoHeight();
        this.mVideoWidth = this.cuX.getVideoWidth();
        setMute(this.fOX);
        aE(this.bdQ);
        ae.i("MicroMsg.Video.AbstractVideoTextureView", "%d open video success player[%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.cuX.hashCode()) });
        return;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.Video.AbstractVideoTextureView", localException, "prepare async error path", new Object[0]);
      }
    } while (this.lxa == null);
    this.lxa.onError(-1, -1);
  }
  
  public final boolean aE(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return false;
    }
    this.bdQ = paramFloat;
    this.cuX.aF(this.bdQ);
    return false;
  }
  
  protected abstract com.tencent.mm.plugin.appbrand.jsapi.video.e.b bpv();
  
  public final void bpy()
  {
    if ((this.cuX != null) && (this.lwZ) && (this.mSurface != null) && (this.mSurface.isValid()))
    {
      ae.i("MicroMsg.Video.AbstractVideoTextureView", "%d flush surface start time[%d] ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(getCurrentPosition()) });
      this.lxs = true;
      this.cuX.setVolume(0.0F, 0.0F);
      this.cuX.start();
    }
  }
  
  public final void d(double paramDouble, boolean paramBoolean)
  {
    p(paramDouble);
    this.cvk = paramBoolean;
  }
  
  public int getCurrentPosition()
  {
    if ((this.cuX != null) && (this.lwZ)) {
      return this.cuX.getCurrentPosition();
    }
    if (this.cuX == null) {
      return -1;
    }
    return 0;
  }
  
  public int getDownloadPercent()
  {
    return this.lxg;
  }
  
  public int getDuration()
  {
    if ((this.cuX != null) && (this.lwZ))
    {
      if (this.atW > 0) {
        return this.atW;
      }
      this.atW = this.cuX.getDuration();
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
    return this.lxp;
  }
  
  public String getVideoPath()
  {
    return this.lwY;
  }
  
  protected final void h(Surface paramSurface)
  {
    h.MqF.aO(new AbstractVideoTextureView.2(this, paramSurface));
  }
  
  public final boolean isPlaying()
  {
    if ((this.cuX != null) && (this.lwZ) && (!this.lxr) && (!this.lxs)) {}
    for (boolean bool = this.cuX.isPlaying();; bool = false)
    {
      ae.d("MicroMsg.Video.AbstractVideoTextureView", "%d is playing result [%b] pauseWhenUpdated[%b] mIsPrepared[%b]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(bool), Boolean.valueOf(this.lxr), Boolean.valueOf(this.lwZ) });
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
    this.lxu.y(paramInt1, paramInt2, i, j);
    setMeasuredDimension(this.lxu.lyb, this.lxu.lyc);
  }
  
  public final void p(double paramDouble)
  {
    if (this.cuX != null)
    {
      this.cuX.seekTo((int)paramDouble);
      this.cvk = true;
      ae.d("MicroMsg.Video.AbstractVideoTextureView", "seek to time: " + paramDouble + " curr pos : " + this.cuX.getCurrentPosition());
    }
  }
  
  public final void pause()
  {
    if ((this.cuX != null) && (this.lwZ) && (this.cuX.isPlaying()))
    {
      ae.d("MicroMsg.Video.AbstractVideoTextureView", "pause video.");
      this.cuX.pause();
    }
    this.cvk = false;
  }
  
  public void setForceScaleFullScreen(boolean paramBoolean)
  {
    this.lxh = paramBoolean;
    this.lxu.lxh = this.lxh;
  }
  
  public void setLoop(boolean paramBoolean)
  {
    if (this.cuX != null) {
      this.cuX.setLooping(paramBoolean);
    }
    this.iuX = true;
  }
  
  public void setMute(boolean paramBoolean)
  {
    ae.i("MicroMsg.Video.AbstractVideoTextureView", "%d set mute %b", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean) });
    this.fOX = paramBoolean;
    if (this.cuX != null)
    {
      if (this.fOX) {
        this.cuX.setVolume(0.0F, 0.0F);
      }
    }
    else {
      return;
    }
    this.cuX.setVolume(1.0F, 1.0F);
  }
  
  public void setOnInfoCallback(a.b paramb)
  {
    this.lxd = paramb;
  }
  
  public void setOnSeekCompleteCallback(a.c paramc)
  {
    this.lxc = paramc;
  }
  
  public void setOnSurfaceCallback(a.d paramd)
  {
    this.lxe = paramd;
  }
  
  public void setOneTimeVideoTextureUpdateCallback(a.e parame)
  {
    this.lxb = parame;
  }
  
  public void setPlayProgressCallback(boolean paramBoolean) {}
  
  public void setScaleType(e.h paramh)
  {
    b localb = this.lxu;
    ae.i("MicroMsg.ViewSizeCache", "set scale type old[%s] new[%s]", new Object[] { localb.lqa, paramh });
    localb.lqa = paramh;
    localb.reset();
    requestLayout();
  }
  
  public void setThumb(Bitmap paramBitmap) {}
  
  public void setVideoCallback(a.a parama)
  {
    this.lxa = parama;
  }
  
  public void setVideoPath(String paramString)
  {
    this.lwY = paramString;
    this.cvk = false;
    bpx();
    requestLayout();
  }
  
  public final boolean start()
  {
    if (this.mSurface == null)
    {
      ae.w("MicroMsg.Video.AbstractVideoTextureView", "%d it surface not ready, do not start", new Object[] { Integer.valueOf(hashCode()) });
      this.lxq = true;
      this.cvk = true;
      return false;
    }
    if (this.startTime == 0L) {}
    for (long l = bu.aRi();; l = this.startTime)
    {
      this.startTime = l;
      ae.i("MicroMsg.Video.AbstractVideoTextureView", "start %d mIsPrepared %b pauseWhenUpdated %b mediaPlayer %s", new Object[] { Long.valueOf(this.startTime), Boolean.valueOf(this.lwZ), Boolean.valueOf(this.lxr), this.cuX });
      if ((this.cuX == null) || (!this.lwZ)) {
        break;
      }
      if (this.lxr)
      {
        this.lxr = false;
        setMute(this.fOX);
      }
      this.cuX.start();
      this.cvk = true;
      return true;
    }
    if ((this.cuX == null) && (this.lwZ))
    {
      this.cvk = true;
      bpx();
      requestLayout();
      return true;
    }
    this.cvk = true;
    return false;
  }
  
  public final void stop()
  {
    long l1;
    long l3;
    if (this.lxf > 0L)
    {
      l1 = this.lxf - this.startTime;
      l3 = bu.aRi() - this.startTime;
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
      ae.i("MicroMsg.Video.AbstractVideoTextureView", "stop : dur:%d stop:%d comp:%d", new Object[] { Integer.valueOf(getDuration()), Long.valueOf(l3), Long.valueOf(l1) });
      if (this.lxa != null) {
        getDuration();
      }
      bpw();
      this.lxu.reset();
      try
      {
        if ((this.mSurface != null) && (this.lwZ))
        {
          Object localObject1 = getSurfaceTexture();
          if (localObject1 != null)
          {
            ae.i("MicroMsg.Video.AbstractVideoTextureView", "%d releaseSurface", new Object[] { Integer.valueOf(hashCode()) });
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
          ae.printErrStackTrace("MicroMsg.Video.AbstractVideoTextureView", localException, "release surface", new Object[0]);
        }
      }
      this.lwY = "";
      this.lxg = 0;
      this.lwZ = false;
      this.cvk = false;
      this.lxp = 0L;
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