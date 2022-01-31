package com.tencent.mm.plugin.emojicapture.ui;

import a.d.a.a;
import a.d.a.b;
import a.d.b.h;
import a.n;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mm.plugin.s.c;
import com.tencent.mm.plugin.s.i;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.pluginsdk.ui.tools.f.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.ttpic.PTSegment;

public final class EmojiVideoPlayTextureView
  extends MMTextureView
  implements TextureView.SurfaceTextureListener
{
  private boolean PT;
  private final String TAG = "MicroMsg.EmojiVideoPlayTextureView";
  private Surface avf;
  private boolean dnJ;
  private boolean jmD;
  private com.tencent.mm.plugin.emojicapture.ui.a.g joB = new com.tencent.mm.plugin.emojicapture.ui.a.g();
  public d joH;
  public i joI;
  public boolean joJ = true;
  private long joK;
  private boolean joL;
  private f.a joM;
  private a<n> joN;
  private b<? super Boolean, n> joO;
  private f.d joP;
  private boolean joQ;
  private boolean joR;
  private boolean joS;
  public boolean joT;
  private boolean joU;
  private c joV;
  private String path = "";
  private int videoHeight;
  private int videoWidth;
  
  public EmojiVideoPlayTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    setOpaque(false);
    this.joV = ((c)new EmojiVideoPlayTextureView.c(this));
  }
  
  public EmojiVideoPlayTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    setOpaque(false);
    this.joV = ((c)new EmojiVideoPlayTextureView.c(this));
  }
  
  private final void aKM()
  {
    y.i(this.TAG, "%d open video [%s]", new Object[] { Integer.valueOf(hashCode()), this.path });
    i locali;
    if (this.joI != null)
    {
      locali = this.joI;
      if (locali != null) {
        locali.a(null);
      }
      locali = this.joI;
      if (locali != null) {
        locali.stop();
      }
      locali = this.joI;
      if (locali != null) {
        locali.release();
      }
      this.joI = null;
    }
    if ((bk.bl(this.path)) || (this.avf == null)) {
      y.w(this.TAG, "%d open video but path is null or mSurface is null", new Object[] { Integer.valueOf(hashCode()) });
    }
    Object localObject;
    label323:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            try
            {
              this.PT = false;
              this.joI = new i(Looper.getMainLooper());
              locali = this.joI;
              if (locali != null) {
                locali.setPath(this.path);
              }
              locali = this.joI;
              if (locali != null) {
                locali.setNeedResetExtractor(this.joQ);
              }
              locali = this.joI;
              if (locali != null) {
                locali.setIsOnlineVideoType(this.joR);
              }
              locali = this.joI;
              if (locali != null) {
                locali.a(this.joV);
              }
              locali = this.joI;
              if (locali != null) {
                locali.setSurface(this.avf);
              }
              locali = this.joI;
              if (locali != null) {
                locali.hr(this.joS);
              }
              locali = this.joI;
              if (locali != null) {
                locali.setMute(true);
              }
              if (this.avf == null) {
                break label323;
              }
              locali = this.joI;
              if (locali != null)
              {
                locali.prepare();
                return;
              }
            }
            catch (Exception localException)
            {
              y.printErrStackTrace(this.TAG, (Throwable)localException, "prepare async error %s", new Object[] { localException.getMessage() });
              localObject = this.joM;
            }
          }
        } while (localObject == null);
        ((f.a)localObject).onError(-1, -1);
        return;
      } while (!this.joL);
      localObject = this.joI;
    } while (localObject == null);
    ((i)localObject).prepare();
  }
  
  public final void b(boolean paramBoolean, a<n> parama)
  {
    this.jmD = paramBoolean;
    this.joB.jll = paramBoolean;
    this.joB.jsK = ((a)new EmojiVideoPlayTextureView.d(this, parama));
  }
  
  public final int getDuration()
  {
    if (this.joI != null)
    {
      i locali = this.joI;
      if (locali == null) {
        a.d.b.g.cUk();
      }
      return (int)locali.biw();
    }
    return 0;
  }
  
  public final float getPlayRate()
  {
    if (this.joI != null)
    {
      i locali = this.joI;
      if (locali == null) {
        a.d.b.g.cUk();
      }
      return locali.getPlayRate();
    }
    return 1.0F;
  }
  
  public final String getVideoPath()
  {
    return this.path;
  }
  
  public final boolean isPlaying()
  {
    if (((this.joI instanceof i)) && (this.joI != null))
    {
      i locali = this.joI;
      if (locali == null) {
        a.d.b.g.cUk();
      }
      return locali.isPlaying();
    }
    return false;
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, final int paramInt1, final int paramInt2)
  {
    cBe();
    y.i(this.TAG, "onSurfaceTextureAvailable, " + paramInt1 + ", " + paramInt2 + ", " + paramSurfaceTexture);
    if (paramSurfaceTexture != null) {}
    try
    {
      this.joB = new com.tencent.mm.plugin.emojicapture.ui.a.g();
      if (this.joT)
      {
        setVisibility(4);
        this.joB.jll = this.jmD;
        this.joB.jsK = ((a)new EmojiVideoPlayTextureView.a(this));
      }
      this.joH = new d(paramSurfaceTexture, this.joB, (b)new b(this, paramInt1, paramInt2));
      return;
    }
    catch (Exception paramSurfaceTexture)
    {
      y.i(this.TAG, "onSurfaceTextureAvailable error: " + paramSurfaceTexture);
    }
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    y.i(this.TAG, "onSurfaceTextureDestroyed");
    paramSurfaceTexture = this.joH;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.needRender = false;
    }
    paramSurfaceTexture = this.joH;
    com.tencent.mm.plugin.emojicapture.ui.a.g localg;
    if (paramSurfaceTexture != null)
    {
      y.i(paramSurfaceTexture.TAG, "destroyGL");
      localg = paramSurfaceTexture.joB;
    }
    try
    {
      GLES20.glDeleteTextures(3, new int[] { localg.jsu, localg.jsF, localg.jsG }, 0);
      GLES20.glDeleteProgram(localg.jsv);
      GLES20.glDeleteProgram(localg.jrA);
      GLES20.glDeleteFramebuffers(1, new int[] { localg.jsE }, 0);
      localg.jrI.destroy();
      EGL14.eglDestroyContext(paramSurfaceTexture.jov, paramSurfaceTexture.jow);
      EGL14.eglDestroySurface(paramSurfaceTexture.jov, paramSurfaceTexture.jox);
      paramSurfaceTexture.jow = EGL14.EGL_NO_CONTEXT;
      paramSurfaceTexture.jox = EGL14.EGL_NO_SURFACE;
      paramSurfaceTexture.fwG.release();
      paramSurfaceTexture.joz.quit();
      this.avf = null;
      this.joT = false;
      this.joU = false;
      if (this.joI != null)
      {
        if (isPlaying())
        {
          this.joT = true;
          paramSurfaceTexture = this.joI;
          if (paramSurfaceTexture != null) {
            paramSurfaceTexture.pause();
          }
        }
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace(localg.TAG, (Throwable)localException, "release error " + localException.getMessage(), new Object[0]);
      }
      this.joT = false;
    }
    return false;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    y.i(this.TAG, "onSurfaceTextureSizeChanged " + paramInt1 + ", " + paramInt2);
    this.joB.cK(paramInt1, paramInt2);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    if ((this.joU) && (this.joK > 0L))
    {
      paramSurfaceTexture = this.joI;
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.pause();
      }
      paramSurfaceTexture = this.joI;
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.setMute(this.dnJ);
      }
      this.joU = false;
    }
    if ((this.joK > 0L) && (this.joN != null))
    {
      y.i(this.TAG, "%d notify surface update", new Object[] { Integer.valueOf(hashCode()) });
      paramSurfaceTexture = this.joN;
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.invoke();
      }
      this.joN = null;
    }
    this.joK = System.currentTimeMillis();
  }
  
  public final void setOneTimeVideoTextureUpdateCallback(a<n> parama)
  {
    this.joN = parama;
  }
  
  public final void setPlayRate(float paramFloat)
  {
    i locali = this.joI;
    if (locali != null) {
      locali.setPlayRate(paramFloat);
    }
  }
  
  public final void setVideoCallback(f.a parama)
  {
    a.d.b.g.k(parama, "callback");
    this.joM = parama;
  }
  
  public final void setVideoPath(String paramString)
  {
    a.d.b.g.k(paramString, "path");
    y.i(this.TAG, "%d set video path [%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
    this.path = paramString;
    aKM();
    requestLayout();
  }
  
  public final boolean start()
  {
    if ((this.joI != null) && (this.PT))
    {
      localObject = this.TAG;
      i = hashCode();
      boolean bool2 = this.joU;
      boolean bool3 = this.joT;
      if (this.avf != null)
      {
        bool1 = true;
        y.i((String)localObject, "%d player start pauseWhenUpdated[%b] pauseByDestroyed[%b] surface[%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
        if (this.avf != null) {
          break label105;
        }
        this.joT = true;
      }
      label105:
      do
      {
        return true;
        bool1 = false;
        break;
        if (this.joU)
        {
          this.joT = true;
          this.joU = false;
          return true;
        }
        localObject = this.joI;
        if (localObject != null) {
          ((i)localObject).start();
        }
        localObject = this.joH;
      } while (localObject == null);
      ((d)localObject).joy = false;
      return true;
    }
    Object localObject = this.TAG;
    int i = hashCode();
    if (this.joI == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      y.w((String)localObject, "%d player is null[%b] or it prepared [%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(this.PT) });
      return false;
    }
  }
  
  public final void stop()
  {
    y.i(this.TAG, "%d player stop [%s]", new Object[] { Integer.valueOf(hashCode()), bk.csb() });
    i locali = this.joI;
    if (locali != null) {
      locali.a(null);
    }
    locali = this.joI;
    if (locali != null) {
      locali.stop();
    }
    locali = this.joI;
    if (locali != null) {
      locali.release();
    }
    this.joI = null;
    this.videoWidth = 0;
    this.videoHeight = 0;
    this.PT = false;
    this.path = "";
    this.joK = 0L;
  }
  
  static final class b
    extends h
    implements b<d, n>
  {
    b(EmojiVideoPlayTextureView paramEmojiVideoPlayTextureView, int paramInt1, int paramInt2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.EmojiVideoPlayTextureView
 * JD-Core Version:    0.7.0.1
 */