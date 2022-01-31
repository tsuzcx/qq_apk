package com.tencent.mm.plugin.emojicapture.ui;

import a.f.a.a;
import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.n.c;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.pluginsdk.ui.tools.e.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMTextureView;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiVideoPlayTextureView;", "Lcom/tencent/mm/ui/base/MMTextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "TAG", "", "afterSeekPlay", "", "callback", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "isMute", "isOnlineVideo", "isPrepared", "isRemoveBg", "lastSurfaceUpdatedTime", "", "needReset", "onSurfaceCallback", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$OnSurfaceCallback;", "oneTimeTextureUpdateCallback", "Lkotlin/Function0;", "", "openWithNoneSurface", "path", "pauseByDestroyed", "pauseWhenUpdated", "player", "Lcom/tencent/mm/plugin/mmplayer/VideoPlayer;", "playerCallback", "Lcom/tencent/mm/plugin/mmplayer/IPlayerCallback;", "removeBgEnable", "renderSurface", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiVideoPlayTextureRenderSurface;", "renderer", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiVideoPlayTextureRenderer;", "seekCompleteCallback", "Lkotlin/Function1;", "surface", "Landroid/view/Surface;", "useMp4Extrator", "videoHeight", "videoWidth", "getDuration", "getPlayRate", "", "getVideoPath", "isPlaying", "onSurfaceTextureAvailable", "Landroid/graphics/SurfaceTexture;", "width", "height", "onSurfaceTextureDestroyed", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "openVideo", "pause", "seekTo", "time", "", "setOneTimeVideoTextureUpdateCallback", "_callback", "setPlayRate", "rate", "setRemoveBackground", "remove", "afterDraw", "setRemoveBgEnable", "setVideoCallback", "setVideoPath", "start", "stop", "plugin-emojicapture_release"})
public final class EmojiVideoPlayTextureView
  extends MMTextureView
  implements TextureView.SurfaceTextureListener
{
  private boolean Pz;
  private final String TAG;
  private Surface axw;
  private boolean efg;
  private boolean lux;
  private e.a lxA;
  private a<y> lxB;
  private a.f.a.b<? super Boolean, y> lxC;
  private e.d lxD;
  private boolean lxE;
  private boolean lxF;
  private boolean lxG;
  private boolean lxH;
  private boolean lxI;
  private boolean lxJ;
  private c lxK;
  private com.tencent.mm.plugin.emojicapture.ui.b.i lxp;
  private b lxv;
  public com.tencent.mm.plugin.n.i lxw;
  public boolean lxx;
  private long lxy;
  private boolean lxz;
  private String path;
  private int videoHeight;
  private int videoWidth;
  
  public EmojiVideoPlayTextureView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(2931);
    this.TAG = "MicroMsg.EmojiVideoPlayTextureView";
    this.path = "";
    this.lxx = true;
    this.lxJ = true;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    setOpaque(false);
    this.lxK = ((c)new EmojiVideoPlayTextureView.c(this));
    AppMethodBeat.o(2931);
  }
  
  public EmojiVideoPlayTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(2929);
    this.TAG = "MicroMsg.EmojiVideoPlayTextureView";
    this.path = "";
    this.lxx = true;
    this.lxJ = true;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    setOpaque(false);
    this.lxK = ((c)new EmojiVideoPlayTextureView.c(this));
    AppMethodBeat.o(2929);
  }
  
  public EmojiVideoPlayTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(2930);
    this.TAG = "MicroMsg.EmojiVideoPlayTextureView";
    this.path = "";
    this.lxx = true;
    this.lxJ = true;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    setOpaque(false);
    this.lxK = ((c)new EmojiVideoPlayTextureView.c(this));
    AppMethodBeat.o(2930);
  }
  
  private final void boV()
  {
    AppMethodBeat.i(2920);
    ab.i(this.TAG, "%d open video [%s]", new Object[] { Integer.valueOf(hashCode()), this.path });
    com.tencent.mm.plugin.n.i locali;
    if (this.lxw != null)
    {
      locali = this.lxw;
      if (locali != null) {
        locali.a(null);
      }
      locali = this.lxw;
      if (locali != null) {
        locali.stop();
      }
      locali = this.lxw;
      if (locali != null) {
        locali.release();
      }
      this.lxw = null;
    }
    if ((bo.isNullOrNil(this.path)) || (this.axw == null))
    {
      ab.w(this.TAG, "%d open video but path is null or mSurface is null", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(2920);
      return;
    }
    try
    {
      this.Pz = false;
      this.lxw = new com.tencent.mm.plugin.n.i(Looper.getMainLooper());
      locali = this.lxw;
      if (locali != null) {
        locali.setPath(this.path);
      }
      locali = this.lxw;
      if (locali != null) {
        locali.setNeedResetExtractor(this.lxE);
      }
      locali = this.lxw;
      if (locali != null) {
        locali.setIsOnlineVideoType(this.lxF);
      }
      locali = this.lxw;
      if (locali != null) {
        locali.a(this.lxK);
      }
      locali = this.lxw;
      if (locali != null) {
        locali.setSurface(this.axw);
      }
      locali = this.lxw;
      if (locali != null) {
        locali.jl(this.lxG);
      }
      locali = this.lxw;
      if (locali != null) {
        locali.setMute(true);
      }
      if (this.axw != null)
      {
        locali = this.lxw;
        if (locali != null)
        {
          locali.prepare();
          AppMethodBeat.o(2920);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace(this.TAG, (Throwable)localException, "prepare async error %s", new Object[] { localException.getMessage() });
      Object localObject = this.lxA;
      if (localObject != null)
      {
        ((e.a)localObject).onError(-1, -1);
        AppMethodBeat.o(2920);
        return;
        AppMethodBeat.o(2920);
        return;
        if (this.lxz)
        {
          localObject = this.lxw;
          if (localObject != null)
          {
            ((com.tencent.mm.plugin.n.i)localObject).prepare();
            AppMethodBeat.o(2920);
            return;
          }
        }
        AppMethodBeat.o(2920);
        return;
      }
      AppMethodBeat.o(2920);
    }
  }
  
  public final void b(boolean paramBoolean, a<y> parama)
  {
    AppMethodBeat.i(2917);
    this.lux = paramBoolean;
    com.tencent.mm.plugin.emojicapture.ui.b.i locali = this.lxp;
    if (locali != null) {
      locali.lva = paramBoolean;
    }
    locali = this.lxp;
    if (locali != null)
    {
      locali.lCg = ((a)new EmojiVideoPlayTextureView.d(this, parama));
      AppMethodBeat.o(2917);
      return;
    }
    AppMethodBeat.o(2917);
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(2924);
    if (this.lxw != null)
    {
      com.tencent.mm.plugin.n.i locali = this.lxw;
      if (locali == null) {
        j.ebi();
      }
      int i = (int)locali.bQy();
      AppMethodBeat.o(2924);
      return i;
    }
    AppMethodBeat.o(2924);
    return 0;
  }
  
  public final float getPlayRate()
  {
    AppMethodBeat.i(2919);
    if (this.lxw != null)
    {
      com.tencent.mm.plugin.n.i locali = this.lxw;
      if (locali == null) {
        j.ebi();
      }
      float f = locali.getPlayRate();
      AppMethodBeat.o(2919);
      return f;
    }
    AppMethodBeat.o(2919);
    return 1.0F;
  }
  
  public final String getVideoPath()
  {
    return this.path;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(2913);
    if (((this.lxw instanceof com.tencent.mm.plugin.n.i)) && (this.lxw != null))
    {
      com.tencent.mm.plugin.n.i locali = this.lxw;
      if (locali == null) {
        j.ebi();
      }
      boolean bool = locali.isPlaying();
      AppMethodBeat.o(2913);
      return bool;
    }
    AppMethodBeat.o(2913);
    return false;
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(2928);
    dEs();
    ab.i(this.TAG, "onSurfaceTextureAvailable, " + paramInt1 + ", " + paramInt2 + ", " + paramSurfaceTexture);
    if (paramSurfaceTexture != null) {
      try
      {
        final com.tencent.mm.plugin.emojicapture.ui.b.i locali1 = new com.tencent.mm.plugin.emojicapture.ui.b.i(this.lxJ);
        com.tencent.mm.plugin.emojicapture.ui.b.i locali2 = this.lxp;
        if (locali2 != null) {
          locali2.release();
        }
        this.lxp = locali1;
        if (this.lxH)
        {
          setVisibility(4);
          locali2 = this.lxp;
          if (locali2 != null) {
            locali2.lva = this.lux;
          }
          locali2 = this.lxp;
          if (locali2 != null) {
            locali2.lCg = ((a)new EmojiVideoPlayTextureView.a(this));
          }
        }
        this.lxv = new b(paramSurfaceTexture, locali1, (a.f.a.b)new b(this, paramInt1, paramInt2, locali1));
        AppMethodBeat.o(2928);
        return;
      }
      catch (Exception paramSurfaceTexture)
      {
        ab.i(this.TAG, "onSurfaceTextureAvailable error: ".concat(String.valueOf(paramSurfaceTexture)));
      }
    }
    AppMethodBeat.o(2928);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(2927);
    ab.i(this.TAG, "onSurfaceTextureDestroyed");
    paramSurfaceTexture = this.lxv;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.gW(false);
    }
    paramSurfaceTexture = this.lxv;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.d((a)new b.a(paramSurfaceTexture));
    }
    this.axw = null;
    this.lxH = false;
    this.lxI = false;
    if (this.lxw != null) {
      if (isPlaying())
      {
        this.lxH = true;
        paramSurfaceTexture = this.lxw;
        if (paramSurfaceTexture != null) {
          paramSurfaceTexture.pause();
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(2927);
      return false;
      this.lxH = false;
    }
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2925);
    ab.i(this.TAG, "onSurfaceTextureSizeChanged " + paramInt1 + ", " + paramInt2);
    paramSurfaceTexture = this.lxp;
    if (paramSurfaceTexture != null)
    {
      paramSurfaceTexture.eh(paramInt1, paramInt2);
      AppMethodBeat.o(2925);
      return;
    }
    AppMethodBeat.o(2925);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(2926);
    if ((this.lxI) && (this.lxy > 0L))
    {
      paramSurfaceTexture = this.lxw;
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.pause();
      }
      paramSurfaceTexture = this.lxw;
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.setMute(this.efg);
      }
      this.lxI = false;
    }
    if ((this.lxy > 0L) && (this.lxB != null))
    {
      ab.i(this.TAG, "%d notify surface update", new Object[] { Integer.valueOf(hashCode()) });
      paramSurfaceTexture = this.lxB;
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.invoke();
      }
      this.lxB = null;
    }
    this.lxy = System.currentTimeMillis();
    AppMethodBeat.o(2926);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(2923);
    if (this.lxw != null)
    {
      Object localObject = this.lxw;
      if (localObject == null) {
        j.ebi();
      }
      if (((com.tencent.mm.plugin.n.i)localObject).isPlaying())
      {
        localObject = this.lxw;
        if (localObject != null) {
          ((com.tencent.mm.plugin.n.i)localObject).pause();
        }
        localObject = this.lxv;
        if (localObject != null) {
          ((b)localObject).gX(true);
        }
      }
    }
    this.lxH = false;
    AppMethodBeat.o(2923);
  }
  
  public final void setOneTimeVideoTextureUpdateCallback(a<y> parama)
  {
    this.lxB = parama;
  }
  
  public final void setPlayRate(float paramFloat)
  {
    AppMethodBeat.i(2916);
    com.tencent.mm.plugin.n.i locali = this.lxw;
    if (locali != null)
    {
      locali.setPlayRate(paramFloat);
      AppMethodBeat.o(2916);
      return;
    }
    AppMethodBeat.o(2916);
  }
  
  public final void setRemoveBgEnable(boolean paramBoolean)
  {
    this.lxJ = paramBoolean;
  }
  
  public final void setVideoCallback(e.a parama)
  {
    AppMethodBeat.i(2915);
    j.q(parama, "callback");
    this.lxA = parama;
    AppMethodBeat.o(2915);
  }
  
  public final void setVideoPath(String paramString)
  {
    AppMethodBeat.i(2914);
    j.q(paramString, "path");
    ab.i(this.TAG, "%d set video path [%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
    this.path = paramString;
    boV();
    requestLayout();
    AppMethodBeat.o(2914);
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(2921);
    if ((this.lxw != null) && (this.Pz))
    {
      localObject = this.TAG;
      i = hashCode();
      boolean bool2 = this.lxI;
      boolean bool3 = this.lxH;
      if (this.axw != null) {}
      for (bool1 = true;; bool1 = false)
      {
        ab.i((String)localObject, "%d player start pauseWhenUpdated[%b] pauseByDestroyed[%b] surface[%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
        if (this.axw != null) {
          break;
        }
        this.lxH = true;
        AppMethodBeat.o(2921);
        return true;
      }
      if (this.lxI)
      {
        this.lxH = true;
        this.lxI = false;
        AppMethodBeat.o(2921);
        return true;
      }
      localObject = this.lxw;
      if (localObject != null) {
        ((com.tencent.mm.plugin.n.i)localObject).start();
      }
      localObject = this.lxv;
      if (localObject != null) {
        ((b)localObject).gX(false);
      }
      AppMethodBeat.o(2921);
      return true;
    }
    Object localObject = this.TAG;
    int i = hashCode();
    if (this.lxw == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ab.w((String)localObject, "%d player is null[%b] or it prepared [%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(this.Pz) });
      AppMethodBeat.o(2921);
      return false;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(2922);
    ab.i(this.TAG, "%d player stop [%s]", new Object[] { Integer.valueOf(hashCode()), bo.dtY() });
    com.tencent.mm.plugin.n.i locali = this.lxw;
    if (locali != null) {
      locali.a(null);
    }
    locali = this.lxw;
    if (locali != null) {
      locali.stop();
    }
    locali = this.lxw;
    if (locali != null) {
      locali.release();
    }
    this.lxw = null;
    this.videoWidth = 0;
    this.videoHeight = 0;
    this.Pz = false;
    this.path = "";
    this.lxy = 0L;
    AppMethodBeat.o(2922);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiVideoPlayTextureRenderSurface;", "invoke"})
  static final class b
    extends k
    implements a.f.a.b<b, y>
  {
    b(EmojiVideoPlayTextureView paramEmojiVideoPlayTextureView, int paramInt1, int paramInt2, com.tencent.mm.plugin.emojicapture.ui.b.i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.EmojiVideoPlayTextureView
 * JD-Core Version:    0.7.0.1
 */