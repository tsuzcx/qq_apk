package com.tencent.mm.live.core.core.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.liteav.audio.TXAudioEffectManager.AudioMusicParam;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.live.core.a.c;
import com.tencent.mm.live.core.b.d.i;
import com.tencent.mm.live.core.b.j;
import com.tencent.mm.live.core.b.n;
import com.tencent.mm.live.core.core.c.a;
import com.tencent.mm.live.core.core.e.a;
import com.tencent.mm.live.core.core.e.e;
import com.tencent.mm.live.core.core.e.o;
import com.tencent.mm.live.core.core.e.p;
import com.tencent.mm.live.core.core.model.UserVolumeInfo;
import com.tencent.mm.live.core.core.model.f;
import com.tencent.mm.live.core.core.model.h.f;
import com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ax;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef.TRTCVolumeInfo;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore;", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "Lcom/tencent/mm/live/core/core/anchor/IMMLiveAnchorCore;", "()V", "anchorSeiTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "anchorVolume", "", "debugRunnable", "com/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore$debugRunnable$1", "Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore$debugRunnable$1;", "userStatus", "checkLiveMode", "", "checkNotTalking", "checkScreenShare", "endScaleAnimation", "time", "enterRoom", "callback", "Lcom/tencent/mm/live/core/core/LiveCallback;", "floatMode", "context", "Landroid/content/Context;", "forceMoveTask", "", "dontFinish", "generateType", "opType", "staticFloatImage", "Landroid/graphics/Bitmap;", "normalMode", "onEnterRoom", "result", "", "onError", "errCode", "errMsg", "", "extraInfo", "Landroid/os/Bundle;", "onExitRoom", "reason", "onUserVoiceVolume", "userVolumes", "Ljava/util/ArrayList;", "Lcom/tencent/trtc/TRTCCloudDef$TRTCVolumeInfo;", "totalVolume", "prepareAnchorSeiInfo", "Lcom/tencent/mm/json/JSONObject;", "refreshMicUserView", "userId", "release", "resetPkConfig", "setupPkConfig", "roomId", "username", "pkSign", "startCrossLinkMic", "startPreview", "beautyConfig", "Lcom/tencent/mm/live/core/render/BeautyConfig;", "filterConfig", "Lcom/tencent/mm/live/core/render/FilterConfig;", "startPush", "startScaleAnimation", "scale", "", "stopCrossLinkMic", "stopPush", "updateRenderMirror", "isMirror", "Companion", "plugin-core_release"})
public final class b
  extends com.tencent.mm.live.core.core.trtc.a
  implements a
{
  private static b klp;
  public static final b klq;
  private int kbN;
  private final d klm;
  private int kln;
  private final MTimerHandler klo;
  
  static
  {
    AppMethodBeat.i(199772);
    klq = new b((byte)0);
    AppMethodBeat.o(199772);
  }
  
  public b()
  {
    super(true);
    AppMethodBeat.i(199769);
    this.klm = new d(this);
    this.klo = new MTimerHandler("anchor_sei_sender", (MTimerHandler.CallBack)new c(this), true);
    AppMethodBeat.o(199769);
  }
  
  private final i aLe()
  {
    AppMethodBeat.i(199718);
    com.tencent.mm.ad.c localc = com.tencent.mm.ad.h.aGm();
    int i;
    Object localObject;
    if (this.kln <= this.knK.klD)
    {
      i = this.kbN;
      localObject = e.a.kjw;
      this.kbN = (i | e.a.aJG());
    }
    for (;;)
    {
      if (this.knA.aLs())
      {
        i = this.kbN;
        localObject = e.a.kjw;
        this.kbN = (i | e.a.aJH());
        label69:
        if (!this.knA.kmG) {
          break label310;
        }
        i = this.kbN;
        localObject = e.a.kjw;
        this.kbN = (i | e.a.aJI());
        label97:
        localObject = e.p.kkW;
        localc.f(e.p.getUserId(), this.knA.kmC);
        localObject = e.p.kkW;
        localc.f(e.p.aKM(), Integer.valueOf(this.kbN));
        localObject = e.p.kkW;
        String str = e.p.aKN();
        localObject = this.knG;
        if (localObject == null) {
          break label333;
        }
        localObject = Integer.valueOf(((TXAudioEffectManager.AudioMusicParam)localObject).id);
        label165:
        localc.f(str, localObject);
        localObject = e.p.kkW;
        localObject = e.p.aKO();
        if (!this.knH) {
          break label341;
        }
        i = 1;
        localc.f((String)localObject, Integer.valueOf(i));
        localObject = new i();
      }
      try
      {
        ((i)localObject).h("wxT", Integer.valueOf(e.o.kkR.value));
        ((i)localObject).h("d", localc.toString());
        label241:
        Log.d("MicroMsg.LiveCoreAnchor", "prepareAnchorSeiInfo json:".concat(String.valueOf(localObject)));
        AppMethodBeat.o(199718);
        return localObject;
        i = this.kbN;
        localObject = e.a.kjw;
        this.kbN = (i & (e.a.aJG() ^ 0xFFFFFFFF));
        continue;
        i = this.kbN;
        localObject = e.a.kjw;
        this.kbN = (i & (e.a.aJH() ^ 0xFFFFFFFF));
        break label69;
        label310:
        i = this.kbN;
        localObject = e.a.kjw;
        this.kbN = (i & (e.a.aJI() ^ 0xFFFFFFFF));
        break label97;
        label333:
        localObject = Integer.valueOf(0);
        break label165;
        label341:
        i = 0;
      }
      catch (com.tencent.mm.ad.g localg)
      {
        break label241;
      }
      catch (IOException localIOException)
      {
        break label241;
      }
    }
  }
  
  public static void m(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(199753);
    Object localObject = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
    p.j(localObject, "ConfigHelper.getInstance()");
    localObject = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject).aLL();
    if (localObject != null)
    {
      ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.d)localObject).NC(paramString3);
      ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.d)localObject).NB(paramString2);
      ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.d)localObject).fc(true);
      ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.d)localObject).NA(paramString1);
      AppMethodBeat.o(199753);
      return;
    }
    AppMethodBeat.o(199753);
  }
  
  public final void Nt(String paramString)
  {
    AppMethodBeat.i(199757);
    Log.i("MicroMsg.LiveCoreAnchor", "refreshMicUserView, userId:".concat(String.valueOf(paramString)));
    if (paramString != null)
    {
      paramString = this.knm.NL(paramString);
      if (paramString != null)
      {
        Log.i("MicroMsg.LiveCoreAnchor", "refreshMicUserView, find renderSurface for userId:" + this.knA.kmC);
        TXCloudVideoView localTXCloudVideoView = ao(paramString.userId, paramString.streamType);
        if (localTXCloudVideoView != null)
        {
          TextureView localTextureView = new TextureView(MMApplicationContext.getContext());
          localTXCloudVideoView.addVideoView(localTextureView);
          localTextureView.setSurfaceTextureListener((TextureView.SurfaceTextureListener)new a(paramString));
          AppMethodBeat.o(199757);
          return;
        }
      }
      AppMethodBeat.o(199757);
      return;
    }
    AppMethodBeat.o(199757);
  }
  
  public final int a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    AppMethodBeat.i(199724);
    p.k(paramContext, "context");
    com.tencent.mm.live.core.core.model.h localh = this.knA;
    Object localObject = this.knz;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.core.core.model.g)localObject).kjd;
      if (localObject == null) {}
    }
    for (localObject = Long.valueOf(((f)localObject).liveId); !localh.a((Long)localObject); localObject = null)
    {
      AppMethodBeat.o(199724);
      return -4;
    }
    final long l = Util.currentTicks();
    Log.i("MicroMsg.LiveCoreAnchor", "floatMode liveMode:" + this.knA.aLs() + ", forceMoveTask:" + paramBoolean1 + ", dontFinish:" + paramBoolean2 + ", generateType:" + paramInt1 + ", opType:" + paramInt2 + ", staticFloatImage:" + paramBitmap + ", isScreenShareMode:" + this.knA.kmG);
    if ((this.knA.kmG) || (this.knA.aLs()))
    {
      localObject = new ImageView(MMApplicationContext.getContext());
      ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_CROP);
      ((ImageView)localObject).setImageBitmap(paramBitmap);
      this.knr.cH((View)localObject);
    }
    for (;;)
    {
      paramInt1 = super.a(paramContext, paramBoolean1, paramBoolean2, paramInt1, paramInt2, paramBitmap);
      AppMethodBeat.o(199724);
      return paramInt1;
      localObject = new TextureView(MMApplicationContext.getContext());
      ((TextureView)localObject).setSurfaceTextureListener((TextureView.SurfaceTextureListener)new e(this, l, paramContext, (TextureView)localObject));
      this.kns.reset();
      this.knr.cH((View)localObject);
    }
  }
  
  public final void a(com.tencent.mm.live.core.core.c paramc)
  {
    AppMethodBeat.i(199726);
    p.k(paramc, "callback");
    super.a(paramc);
    paramc = this.knl;
    Object localObject = MMApplicationContext.getContext();
    p.j(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources().getDrawable(a.c.mic_user_leave);
    p.j(localObject, "MMApplicationContext.get….drawable.mic_user_leave)");
    paramc.setVideoMuteImage(com.tencent.mm.ae.d.drawable2Bitmap((Drawable)localObject), 5);
    paramc = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
    p.j(paramc, "ConfigHelper.getInstance()");
    localObject = paramc.aLJ();
    paramc = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
    p.j(paramc, "ConfigHelper.getInstance()");
    paramc = paramc.aLK();
    p.j(localObject, "videoConfig");
    ((e)localObject).ff(true);
    p.j(paramc, "audioConfig");
    paramc.fb(true);
    localObject = this.knn;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.sdkadapter.c)localObject).startLocalAudio();
    }
    localObject = this.knn;
    if (localObject != null)
    {
      ((com.tencent.mm.live.core.core.trtc.sdkadapter.c)localObject).fa(paramc.aLU());
      AppMethodBeat.o(199726);
      return;
    }
    AppMethodBeat.o(199726);
  }
  
  public final int aJC()
  {
    AppMethodBeat.i(199737);
    this.knl.enableCustomVideoCapture(true);
    com.tencent.mm.live.core.core.trtc.sdkadapter.c localc = this.knn;
    if (localc != null) {
      localc.startLocalAudio();
    }
    this.knB = true;
    this.kns.e((kotlin.g.a.b)g.klx);
    this.kns.f((kotlin.g.a.b)h.kly);
    AppMethodBeat.o(199737);
    return 0;
  }
  
  public final void aJz()
  {
    AppMethodBeat.i(199738);
    final long l = Util.currentTicks();
    super.aJz();
    LivePreviewView localLivePreviewView = this.knt;
    if (localLivePreviewView != null)
    {
      localLivePreviewView.a((kotlin.g.a.q)new f(this, l));
      AppMethodBeat.o(199738);
      return;
    }
    AppMethodBeat.o(199738);
  }
  
  public final void aLf()
  {
    AppMethodBeat.i(199748);
    Log.i("MicroMsg.LiveCoreAnchor", "stopCrossLinkMic is applyPkRole:" + this.knA.aLm());
    if (this.knA.aLm())
    {
      Object localObject = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
      p.j(localObject, "ConfigHelper.getInstance()");
      localObject = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject).aLL();
      if (localObject != null)
      {
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.d)localObject).NC("");
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.d)localObject).NB("");
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.d)localObject).fc(false);
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.d)localObject).NA("");
      }
      localObject = this.knn;
      if (localObject != null) {
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.c)localObject).aLT();
      }
      this.knA.kmz = h.f.kna;
    }
    AppMethodBeat.o(199748);
  }
  
  public final void eU(boolean paramBoolean)
  {
    AppMethodBeat.i(199749);
    com.tencent.mm.live.core.b.d locald = this.kns;
    locald.i((kotlin.g.a.a)new d.i(locald, paramBoolean));
    AppMethodBeat.o(199749);
  }
  
  public final void l(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(199744);
    p.k(paramString1, "roomId");
    p.k(paramString2, "username");
    p.k(paramString3, "pkSign");
    Log.i("MicroMsg.LiveCoreAnchor", "startCrossLinkMic roomId:" + paramString1 + " username:" + paramString2 + " pkSign:" + paramString3);
    this.knA.kmz = h.f.knb;
    m(paramString1, paramString2, paramString3);
    com.tencent.mm.live.core.core.trtc.sdkadapter.c localc = this.knn;
    if (localc != null)
    {
      localc.n(paramString1, paramString2, paramString3);
      AppMethodBeat.o(199744);
      return;
    }
    AppMethodBeat.o(199744);
  }
  
  public final void onEnterRoom(long paramLong)
  {
    AppMethodBeat.i(199730);
    super.onEnterRoom(paramLong);
    if (paramLong > 0L) {
      this.klo.startTimer(1000L, 1000L);
    }
    this.knk.post((Runnable)this.klm);
    AppMethodBeat.o(199730);
  }
  
  public final void onError(int paramInt, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(199739);
    if (paramInt == -3301)
    {
      paramBundle = com.tencent.mm.live.core.debug.a.kqB;
      com.tencent.mm.live.core.debug.a.NO("[-3301]create room fail,".concat(String.valueOf(paramString)));
      paramString = aLv();
      if (paramString != null) {
        c.a.a(paramString, paramInt);
      }
      aLw();
      AppMethodBeat.o(199739);
      return;
    }
    super.onError(paramInt, paramString, paramBundle);
    AppMethodBeat.o(199739);
  }
  
  public final void onExitRoom(int paramInt)
  {
    AppMethodBeat.i(199733);
    super.onExitRoom(paramInt);
    this.klo.stopTimer();
    AppMethodBeat.o(199733);
  }
  
  public final void onUserVoiceVolume(ArrayList<TRTCCloudDef.TRTCVolumeInfo> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(199766);
    super.onUserVoiceVolume(paramArrayList, paramInt);
    ??? = com.tencent.mm.live.core.core.trtc.sdkadapter.b.b.aLY();
    p.j(???, "RemoteUserConfigHelper.getInstance()");
    ??? = ((com.tencent.mm.live.core.core.trtc.sdkadapter.b.b)???).aLZ();
    p.j(???, "RemoteUserConfigHelper.g…ce().remoteUserConfigList");
    Object localObject3;
    synchronized ((Iterable)???)
    {
      localObject2 = ((Iterable)???).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (com.tencent.mm.live.core.core.trtc.sdkadapter.b.a)((Iterator)localObject2).next();
        p.j(localObject3, "it");
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.b.a)localObject3).setVolume(0);
      }
    }
    Object localObject2 = x.aazN;
    this.kln = 0;
    if (paramArrayList != null)
    {
      ??? = ((Iterable)paramArrayList).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (TRTCCloudDef.TRTCVolumeInfo)((Iterator)???).next();
        if (Util.isEqual(this.knA.kmC, ((TRTCCloudDef.TRTCVolumeInfo)localObject2).userId))
        {
          this.kln = ((TRTCCloudDef.TRTCVolumeInfo)localObject2).volume;
        }
        else
        {
          localObject3 = com.tencent.mm.live.core.core.trtc.sdkadapter.b.b.aLY().NE(((TRTCCloudDef.TRTCVolumeInfo)localObject2).userId);
          if (localObject3 != null) {
            ((com.tencent.mm.live.core.core.trtc.sdkadapter.b.a)localObject3).setVolume(((TRTCCloudDef.TRTCVolumeInfo)localObject2).volume);
          }
        }
      }
    }
    ??? = new ArrayList();
    if (paramArrayList != null)
    {
      paramArrayList = ((Iterable)paramArrayList).iterator();
      while (paramArrayList.hasNext())
      {
        localObject2 = (TRTCCloudDef.TRTCVolumeInfo)paramArrayList.next();
        localObject3 = ((TRTCCloudDef.TRTCVolumeInfo)localObject2).userId;
        p.j(localObject3, "it.userId");
        ((ArrayList)???).add(new UserVolumeInfo((String)localObject3, ((TRTCCloudDef.TRTCVolumeInfo)localObject2).volume));
      }
    }
    paramArrayList = new Bundle();
    paramArrayList.putParcelableArrayList("live_user_volume_info", (ArrayList)???);
    ??? = this.kny;
    if (??? != null)
    {
      localObject2 = e.e.kjZ;
      ((com.tencent.mm.live.core.core.c)???).callback(e.e.aKg(), paramArrayList);
      AppMethodBeat.o(199766);
      return;
    }
    AppMethodBeat.o(199766);
  }
  
  public final void release()
  {
    AppMethodBeat.i(199759);
    super.release();
    this.knk.removeCallbacks((Runnable)this.klm);
    aLw();
    aLx();
    AppMethodBeat.o(199759);
  }
  
  public final int stopPush()
  {
    AppMethodBeat.i(199736);
    this.kns.e(null);
    this.knl.enableCustomVideoCapture(false);
    com.tencent.mm.live.core.core.trtc.sdkadapter.c localc = this.knn;
    if (localc != null) {
      localc.stopLocalAudio();
    }
    this.knB = false;
    AppMethodBeat.o(199736);
    return 0;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore$refreshMicUserView$1$1$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "surface", "plugin-core_release"})
  public static final class a
    implements TextureView.SurfaceTextureListener
  {
    a(j paramj) {}
    
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(199224);
      p.k(paramSurfaceTexture, "surfaceTexture");
      Log.i("MicroMsg.LiveCoreAnchor", "customRender onSurfaceTextureAvailable, size:[%s, %s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.klr.bO(new Surface(paramSurfaceTexture));
      this.klr.dt(paramInt1, paramInt2);
      AppMethodBeat.o(199224);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(199227);
      p.k(paramSurfaceTexture, "surfaceTexture");
      Log.i("MicroMsg.LiveCoreAnchor", "customRender onSurfaceTextureDestroyed");
      this.klr.aMX();
      AppMethodBeat.o(199227);
      return false;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(199226);
      p.k(paramSurfaceTexture, "surfaceTexture");
      Log.i("MicroMsg.LiveCoreAnchor", "customRender onSurfaceTextureSizeChanged, size:[%s, %s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.klr.dt(paramInt1, paramInt2);
      AppMethodBeat.o(199226);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(199229);
      p.k(paramSurfaceTexture, "surface");
      AppMethodBeat.o(199229);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore;", "TAG", "", "getInstance", "hasInstance", "", "releaseInstance", "", "onlyResetReference", "plugin-core_release"})
  public static final class b
  {
    public static b aLh()
    {
      AppMethodBeat.i(197984);
      if (b.aLg() == null) {
        b.e(new b());
      }
      b localb = b.aLg();
      if (localb == null) {
        p.iCn();
      }
      AppMethodBeat.o(197984);
      return localb;
    }
    
    public static boolean aLi()
    {
      AppMethodBeat.i(197986);
      if (b.aLg() != null)
      {
        AppMethodBeat.o(197986);
        return true;
      }
      AppMethodBeat.o(197986);
      return false;
    }
    
    public static void eV(boolean paramBoolean)
    {
      AppMethodBeat.i(197988);
      if (!paramBoolean)
      {
        b localb = b.aLg();
        if (localb != null) {
          localb.release();
        }
      }
      b.e(null);
      AppMethodBeat.o(197988);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onTimerExpired"})
  static final class c
    implements MTimerHandler.CallBack
  {
    c(b paramb) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(198688);
      Object localObject1 = b.b(this.kls);
      Object localObject2 = b.d(this.kls).toString();
      p.j(localObject2, "prepareAnchorSeiInfo().toString()");
      Charset localCharset = kotlin.n.d.UTF_8;
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(198688);
        throw ((Throwable)localObject1);
      }
      localObject2 = ((String)localObject2).getBytes(localCharset);
      p.j(localObject2, "(this as java.lang.String).getBytes(charset)");
      ((TRTCCloud)localObject1).sendSEIMsg((byte[])localObject2, 1);
      AppMethodBeat.o(198688);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore$debugRunnable$1", "Ljava/lang/Runnable;", "run", "", "plugin-core_release"})
  public static final class d
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(198358);
      Object localObject = com.tencent.mm.live.core.debug.a.kqB;
      localObject = b.b(this.kls);
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.live.core.core.trtc.WXTRTCCloudImpl");
        AppMethodBeat.o(198358);
        throw ((Throwable)localObject);
      }
      com.tencent.mm.live.core.debug.a.NP(((com.tencent.mm.live.core.core.trtc.b)localObject).aLG().toString());
      b.c(this.kls).removeCallbacks((Runnable)this);
      b.c(this.kls).postDelayed((Runnable)this, 10000L);
      AppMethodBeat.o(198358);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore$floatMode$2", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-core_release"})
  public static final class e
    implements TextureView.SurfaceTextureListener
  {
    e(long paramLong, Context paramContext, TextureView paramTextureView) {}
    
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(199056);
      Log.i("MicroMsg.LiveCoreAnchor", "float onSurfaceTextureAvailable, surface:" + paramSurfaceTexture + ", size:[" + paramInt1 + ", " + paramInt2 + ']');
      com.tencent.mm.live.core.c.a.tp((int)Util.ticksToNow(l));
      int j = ax.au(this.$context).x;
      int i = ax.au(this.$context).y;
      if (j > i) {}
      for (;;)
      {
        float f;
        int m;
        if (paramInt1 < paramInt2)
        {
          f = paramInt1;
          m = (int)(j / i * f);
          k = paramInt1;
        }
        for (;;)
        {
          b.a(this.kls).bO(this.klu.getSurfaceTexture());
          b.a(this.kls).dt(k, m);
          AppMethodBeat.o(199056);
          return;
          if (i <= j) {
            break label209;
          }
          k = i;
          i = j;
          j = k;
          break;
          k = paramInt1;
          m = paramInt2;
          if (paramInt2 < paramInt1)
          {
            f = paramInt2;
            k = (int)(j / i * f);
            m = paramInt2;
          }
        }
        label209:
        int k = i;
        i = j;
        j = k;
      }
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(199052);
      Log.i("MicroMsg.LiveCoreAnchor", "float onSurfaceTextureDestroyed");
      AppMethodBeat.o(199052);
      return false;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(199049);
      Log.i("MicroMsg.LiveCoreAnchor", "float onSurfaceTextureSizeChanged, surface:" + paramSurfaceTexture + ", size:[" + paramInt1 + ", " + paramInt2 + ']');
      b.a(this.kls).dt(paramInt1, paramInt2);
      AppMethodBeat.o(199049);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "surface", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "i", "", "i1", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.q<n, Integer, Integer, x>
  {
    f(b paramb, long paramLong)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "mFps", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Integer, x>
  {
    public static final g klx;
    
    static
    {
      AppMethodBeat.i(199864);
      klx = new g();
      AppMethodBeat.o(199864);
    }
    
    g()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "cost", "", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Integer, x>
  {
    public static final h kly;
    
    static
    {
      AppMethodBeat.i(198975);
      kly = new h();
      AppMethodBeat.o(198975);
    }
    
    h()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.a.b
 * JD-Core Version:    0.7.0.1
 */