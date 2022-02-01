package com.tencent.mm.live.core.core.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.liteav.audio.TXAudioEffectManager.AudioMusicParam;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.a.f;
import com.tencent.mm.live.core.b.d.k;
import com.tencent.mm.live.core.core.c.a;
import com.tencent.mm.live.core.core.e.a;
import com.tencent.mm.live.core.core.e.g;
import com.tencent.mm.live.core.core.e.m;
import com.tencent.mm.live.core.core.e.q;
import com.tencent.mm.live.core.core.e.r;
import com.tencent.mm.live.core.core.model.UserVolumeInfo;
import com.tencent.mm.live.core.core.model.i.f;
import com.tencent.mm.live.core.core.trtc.sdkadapter.a.a;
import com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.model.cn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef.TRTCVolumeInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore;", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "Lcom/tencent/mm/live/core/core/anchor/IMMLiveAnchorCore;", "()V", "anchorSeiTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "anchorVolume", "", "debugRunnable", "com/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore$debugRunnable$1", "Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore$debugRunnable$1;", "userStatus", "checkLiveMode", "", "checkNotTalking", "checkScreenShare", "endScaleAnimation", "time", "enterRoom", "callback", "Lcom/tencent/mm/live/core/core/LiveCallback;", "floatMode", "context", "Landroid/content/Context;", "forceMoveTask", "", "dontFinish", "generateType", "opType", "staticFloatImage", "Landroid/graphics/Bitmap;", "isFluentFloatShow", "normalMode", "notifyCloudMixtureForFinder", "micData", "Lorg/json/JSONObject;", "onEnterRoom", "result", "", "onError", "errCode", "errMsg", "", "extraInfo", "Landroid/os/Bundle;", "onExitRoom", "reason", "onUserVoiceVolume", "userVolumes", "Ljava/util/ArrayList;", "Lcom/tencent/trtc/TRTCCloudDef$TRTCVolumeInfo;", "totalVolume", "prepareAnchorSeiInfo", "Lcom/tencent/mm/json/JSONObject;", "refreshMicUserView", "userId", "release", "resetPkConfig", "resetRoomPkConfig", "restartAudioDevice", "setupPkConfig", "roomId", "username", "pkSign", "setupRoomPkConfig", "connectRoomId", "connectedRoomId", "roomPkSign", "startCrossLinkMic", "startPreview", "beautyConfig", "Lcom/tencent/mm/live/core/render/BeautyConfig;", "filterConfig", "Lcom/tencent/mm/live/core/render/FilterConfig;", "startPush", "startRoomPkLinkMic", "startScaleAnimation", "scale", "", "stopCrossLinkMic", "stopPush", "stopRoomPkLinkMic", "updateRenderMirror", "isMirror", "Companion", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.live.core.core.trtc.a
  implements a
{
  public static final a mMo;
  private static b mMs;
  private int mBT;
  private final b mMp;
  private int mMq;
  private final MTimerHandler mMr;
  
  static
  {
    AppMethodBeat.i(248239);
    mMo = new a((byte)0);
    AppMethodBeat.o(248239);
  }
  
  public b()
  {
    super(true);
    AppMethodBeat.i(248180);
    this.mMp = new b(this);
    this.mMr = new MTimerHandler("anchor_sei_sender", new b..ExternalSyntheticLambda0(this), true);
    AppMethodBeat.o(248180);
  }
  
  private static final boolean a(b paramb)
  {
    AppMethodBeat.i(248207);
    s.u(paramb, "this$0");
    TRTCCloud localTRTCCloud = paramb.beO();
    paramb = paramb.beg().toString();
    s.s(paramb, "prepareAnchorSeiInfo().toString()");
    paramb = paramb.getBytes(kotlin.n.d.UTF_8);
    s.s(paramb, "(this as java.lang.String).getBytes(charset)");
    localTRTCCloud.sendSEIMsg(paramb, 1);
    AppMethodBeat.o(248207);
    return true;
  }
  
  private final com.tencent.mm.ad.i beg()
  {
    AppMethodBeat.i(248195);
    Object localObject1 = com.tencent.mm.ad.h.aZn();
    Object localObject3;
    label72:
    label101:
    Object localObject4;
    if (this.mMq <= this.mRM.mMI)
    {
      i = this.mBT;
      localObject3 = e.a.mKb;
      this.mBT = (i | e.a.bcq());
      if (!this.mRB.bex()) {
        break label494;
      }
      i = this.mBT;
      localObject3 = e.a.mKb;
      this.mBT = (i | e.a.bcr());
      if (!this.mRB.mNQ) {
        break label518;
      }
      i = this.mBT;
      localObject3 = e.a.mKb;
      this.mBT = (i | e.a.bcs());
      localObject3 = e.r.mLO;
      ((com.tencent.mm.ad.c)localObject1).l(e.r.getUserId(), this.mRB.mNM);
      localObject3 = e.r.mLO;
      ((com.tencent.mm.ad.c)localObject1).l(e.r.bdI(), Integer.valueOf(this.mBT));
      localObject3 = e.r.mLO;
      localObject3 = e.r.bdJ();
      localObject4 = this.mRH;
      if (localObject4 != null) {
        break label542;
      }
      i = 0;
      label170:
      ((com.tencent.mm.ad.c)localObject1).l((String)localObject3, Integer.valueOf(i));
      localObject3 = e.r.mLO;
      localObject3 = e.r.bdK();
      if (!this.mRI) {
        break label551;
      }
      i = 1;
      label203:
      ((com.tencent.mm.ad.c)localObject1).l((String)localObject3, Integer.valueOf(i));
      localObject3 = e.r.mLO;
      ((com.tencent.mm.ad.c)localObject1).l(e.r.bdL(), Long.valueOf(cn.bDv()));
      localObject3 = new com.tencent.mm.ad.i();
    }
    try
    {
      ((com.tencent.mm.ad.i)localObject3).n("wxT", Integer.valueOf(e.q.mLM.value));
      ((com.tencent.mm.ad.i)localObject3).n("d", localObject1.toString());
      localObject4 = beP().mTO;
      if (localObject4 == null) {
        break label437;
      }
      localJSONArray = ((JSONObject)localObject4).optJSONArray("list");
      if (localJSONArray != null) {
        break label556;
      }
      k = 0;
    }
    catch (com.tencent.mm.ad.g localg)
    {
      Object localObject5;
      break label448;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        JSONArray localJSONArray;
        int k;
        label314:
        int j;
        continue;
        int m;
        do
        {
          i = m;
          break label645;
          if (k <= 0) {
            break label423;
          }
          i = 0;
          m = i + 1;
          if (localJSONArray != null) {
            break label565;
          }
          Object localObject2 = null;
          if (localObject2 != null) {
            break label576;
          }
          j = 0;
          break;
        } while (m < k);
      }
    }
    i = j;
    if (localObject1 != null)
    {
      localObject5 = ((JSONObject)localObject1).optString("uId");
      i = j;
      if (localObject5 != null)
      {
        localObject5 = com.tencent.mm.live.core.core.trtc.sdkadapter.b.b.a.bfv().FU((String)localObject5);
        i = j;
        if (localObject5 != null)
        {
          if (((com.tencent.mm.live.core.core.trtc.sdkadapter.b.a)localObject5).mTx > this.mRM.mMI) {
            break label589;
          }
          localObject5 = e.m.mLr;
          i = j | e.m.bdw();
        }
      }
    }
    label381:
    if (this.mRB.bex())
    {
      localObject5 = e.m.mLr;
      i |= e.m.bdx();
    }
    for (;;)
    {
      if (localObject1 == null) {
        break label668;
      }
      ((JSONObject)localObject1).putOpt("us", Integer.valueOf(i));
      break label668;
      label423:
      ((com.tencent.mm.ad.i)localObject3).n("m", ((JSONObject)localObject4).toString());
      label437:
      C(beP().mTO);
      label448:
      Log.d("MicroMsg.LiveCoreAnchor", s.X("prepareAnchorSeiInfo json:", localObject3));
      AppMethodBeat.o(248195);
      return localObject3;
      i = this.mBT;
      localObject3 = e.a.mKb;
      this.mBT = (i & (e.a.bcq() ^ 0xFFFFFFFF));
      break;
      label494:
      i = this.mBT;
      localObject3 = e.a.mKb;
      this.mBT = (i & (e.a.bcr() ^ 0xFFFFFFFF));
      break label72;
      label518:
      i = this.mBT;
      localObject3 = e.a.mKb;
      this.mBT = (i & (e.a.bcs() ^ 0xFFFFFFFF));
      break label101;
      label542:
      i = ((TXAudioEffectManager.AudioMusicParam)localObject4).id;
      break label170;
      label551:
      i = 0;
      break label203;
      label556:
      k = localJSONArray.length();
      break label639;
      label565:
      localObject1 = localJSONArray.optJSONObject(i);
      break label658;
      label576:
      j = ((JSONObject)localObject1).optInt("us", 0);
      break label314;
      label589:
      localObject5 = e.m.mLr;
      i = j & (e.m.bdw() ^ 0xFFFFFFFF);
      break label381;
      localObject5 = e.m.mLr;
      j = e.m.bdx();
      i &= (j ^ 0xFFFFFFFF);
    }
  }
  
  public static void d(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(248202);
    s.u(paramString1, "connectRoomId");
    s.u(paramString2, "connectedRoomId");
    s.u(paramString3, "roomPkSign");
    com.tencent.mm.live.core.core.trtc.sdkadapter.feature.d locald = a.a.bfr().bfp();
    if (locald != null)
    {
      locald.mSY = paramString3;
      locald.mSV = true;
      locald.mSW = paramString1;
      locald.mSX = paramString2;
      locald.mSS = paramString4;
    }
    AppMethodBeat.o(248202);
  }
  
  public static void r(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(248198);
    com.tencent.mm.live.core.core.trtc.sdkadapter.feature.d locald = a.a.bfr().bfp();
    if (locald != null)
    {
      locald.mSU = paramString3;
      locald.mSS = paramString2;
      locald.mST = true;
      locald.mSR = paramString1;
    }
    AppMethodBeat.o(248198);
  }
  
  public final void C(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(248382);
    super.C(paramJSONObject);
    Bundle localBundle = new Bundle();
    if (paramJSONObject != null) {
      localBundle.putString("live_link_mic_info_in_anchor_sei_msg", paramJSONObject.toString());
    }
    paramJSONObject = this.mRy;
    if (paramJSONObject != null)
    {
      e.g localg = e.g.mKv;
      paramJSONObject.callback(e.g.bde(), localBundle);
    }
    AppMethodBeat.o(248382);
  }
  
  public final void FM(String paramString)
  {
    AppMethodBeat.i(248365);
    Log.i("MicroMsg.LiveCoreAnchor", s.X("refreshMicUserView, userId:", paramString));
    if (paramString != null)
    {
      paramString = beP().FY(paramString);
      if (paramString != null)
      {
        Log.i("MicroMsg.LiveCoreAnchor", s.X("refreshMicUserView, find renderSurface for userId:", this.mRB.mNM));
        TXCloudVideoView localTXCloudVideoView = ax(paramString.userId, paramString.streamType);
        if (localTXCloudVideoView != null)
        {
          TextureView localTextureView = new TextureView(MMApplicationContext.getContext());
          localTXCloudVideoView.addVideoView(localTextureView);
          localTextureView.setSurfaceTextureListener((TextureView.SurfaceTextureListener)new b.f(paramString));
        }
      }
    }
    AppMethodBeat.o(248365);
  }
  
  public final int a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, Bitmap paramBitmap, boolean paramBoolean3)
  {
    Object localObject1 = null;
    AppMethodBeat.i(248261);
    s.u(paramContext, "context");
    com.tencent.mm.live.core.core.model.i locali = this.mRB;
    Object localObject2 = this.mRA;
    if (localObject2 == null) {}
    while (!locali.a((Long)localObject1))
    {
      AppMethodBeat.o(248261);
      return -4;
      localObject2 = ((com.tencent.mm.live.core.core.model.h)localObject2).mJH;
      if (localObject2 != null) {
        localObject1 = Long.valueOf(((com.tencent.mm.live.core.core.model.g)localObject2).liveId);
      }
    }
    long l = Util.currentTicks();
    Log.i("MicroMsg.LiveCoreAnchor", "floatMode liveMode:" + this.mRB.bex() + ", forceMoveTask:" + paramBoolean1 + ", dontFinish:" + paramBoolean2 + ", generateType:" + paramInt1 + ", opType:" + paramInt2 + ", staticFloatImage:" + paramBitmap + ", isScreenShareMode:" + this.mRB.mNQ);
    if ((this.mRB.mNQ) || (this.mRB.bex()))
    {
      localObject1 = new ImageView(MMApplicationContext.getContext());
      ((ImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_CROP);
      ((ImageView)localObject1).setImageBitmap(paramBitmap);
      this.mRq.dc((View)localObject1);
    }
    for (;;)
    {
      paramInt1 = super.a(paramContext, paramBoolean1, paramBoolean2, paramInt1, paramInt2, paramBitmap, paramBoolean3);
      AppMethodBeat.o(248261);
      return paramInt1;
      localObject1 = new TextureView(MMApplicationContext.getContext());
      ((TextureView)localObject1).setSurfaceTextureListener((TextureView.SurfaceTextureListener)new b.c(this, l, paramContext, (TextureView)localObject1));
      this.mRs.reset();
      this.mRq.dc((View)localObject1);
    }
  }
  
  public final void a(com.tencent.mm.live.core.b.a parama, com.tencent.mm.live.core.b.b paramb)
  {
    AppMethodBeat.i(248351);
    a(this.mRt, parama, paramb);
    AppMethodBeat.o(248351);
  }
  
  public final void a(com.tencent.mm.live.core.core.c paramc)
  {
    AppMethodBeat.i(248269);
    s.u(paramc, "callback");
    super.a(paramc);
    paramc = beO();
    Object localObject = MMApplicationContext.getContext().getResources().getDrawable(a.f.mic_user_leave);
    s.s(localObject, "getContext().resources.g…ble(R.raw.mic_user_leave)");
    paramc.setVideoMuteImage(com.tencent.mm.ae.d.drawable2Bitmap((Drawable)localObject), 5);
    localObject = a.a.bfr().bfn();
    paramc = a.a.bfr().bfo();
    ((e)localObject).mTi = true;
    paramc.mSJ = true;
    localObject = beQ();
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.sdkadapter.c)localObject).startLocalAudio();
    }
    localObject = beQ();
    if (localObject != null)
    {
      boolean bool = paramc.mSK;
      ((com.tencent.mm.live.core.core.trtc.sdkadapter.c)localObject).mSx.enableAudioEarMonitoring(bool);
    }
    AppMethodBeat.o(248269);
  }
  
  public final void aG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(248344);
    s.u(paramString1, "connectRoomId");
    s.u(paramString2, "connectedRoomId");
    boolean bool = this.mRB.ber();
    Log.i("MicroMsg.LiveCoreAnchor", "stopRoomPkLinkMic: connectRoomId:" + paramString1 + " connectedRoomId:" + paramString2 + ", isPkRoleApply:" + bool);
    if (bool)
    {
      Object localObject = a.a.bfr().bfp();
      if (localObject != null)
      {
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.d)localObject).mSY = "";
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.d)localObject).mSV = false;
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.d)localObject).mSW = "";
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.d)localObject).mSX = "";
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.d)localObject).mSS = "";
      }
      localObject = beQ();
      if (localObject != null)
      {
        JSONObject localJSONObject1 = new JSONObject();
        try
        {
          localJSONObject1.put("api", "disconnectOtherRoom");
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("connectRoomId", Long.parseLong(paramString1));
          localJSONObject2.put("connectedRoomId", Long.parseLong(paramString2));
          localJSONObject1.put("params", localJSONObject2);
          ((com.tencent.mm.live.core.core.trtc.sdkadapter.c)localObject).mSx.callExperimentalAPI(localJSONObject1.toString());
          AppMethodBeat.o(248344);
          return;
        }
        catch (Exception paramString1) {}
      }
    }
    AppMethodBeat.o(248344);
  }
  
  public final void bcg()
  {
    AppMethodBeat.i(248298);
    long l = Util.currentTicks();
    super.bcg();
    LivePreviewView localLivePreviewView = this.mRt;
    if (localLivePreviewView != null) {
      localLivePreviewView.a((kotlin.g.a.b)new b.d(this, l), (m)new b.e(this));
    }
    AppMethodBeat.o(248298);
  }
  
  public final int bcj()
  {
    AppMethodBeat.i(248290);
    beO().enableCustomVideoCapture(true);
    com.tencent.mm.live.core.core.trtc.sdkadapter.c localc = beQ();
    if (localc != null) {
      localc.startLocalAudio();
    }
    this.mRC = true;
    this.mRs.u((kotlin.g.a.b)b.g.mMx);
    this.mRs.v((kotlin.g.a.b)b.h.mMy);
    AppMethodBeat.o(248290);
    return 0;
  }
  
  public final void beh()
  {
    AppMethodBeat.i(248325);
    Log.i("MicroMsg.LiveCoreAnchor", s.X("stopCrossLinkMic is applyPkRole:", Boolean.valueOf(this.mRB.ber())));
    if (this.mRB.ber())
    {
      Object localObject = a.a.bfr().bfp();
      if (localObject != null)
      {
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.d)localObject).mSU = "";
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.d)localObject).mSS = "";
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.d)localObject).mST = false;
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.d)localObject).mSR = "";
      }
      localObject = beQ();
      if (localObject != null) {
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.c)localObject).mSx.DisconnectOtherRoom();
      }
      this.mRB.mNJ = i.f.mOj;
    }
    AppMethodBeat.o(248325);
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(248335);
    s.u(paramString1, "connectRoomId");
    s.u(paramString2, "connectedRoomId");
    s.u(paramString3, "roomPkSign");
    Log.i("MicroMsg.LiveCoreAnchor", "startRoomPkLinkMic: connectRoomId:" + paramString1 + " connectedRoomId:" + paramString2 + " roomPkSign:" + paramString3 + " username:" + paramString4);
    this.mRB.mNJ = i.f.mOk;
    d(paramString1, paramString2, paramString3, paramString4);
    paramString4 = beQ();
    if (paramString4 != null)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("connectRoomId", Long.parseLong(paramString1));
        localJSONObject.put("connectedRoomId", Long.parseLong(paramString2));
        localJSONObject.put("sign", paramString3);
        paramString4.mSx.ConnectOtherRoom(localJSONObject.toString());
        AppMethodBeat.o(248335);
        return;
      }
      catch (Exception paramString1) {}
    }
    AppMethodBeat.o(248335);
  }
  
  public final void fE(boolean paramBoolean)
  {
    AppMethodBeat.i(248360);
    com.tencent.mm.live.core.b.d locald = this.mRs;
    locald.H((kotlin.g.a.a)new d.k(locald, paramBoolean));
    AppMethodBeat.o(248360);
  }
  
  public final void onEnterRoom(long paramLong)
  {
    AppMethodBeat.i(248275);
    super.onEnterRoom(paramLong);
    if (paramLong > 0L) {
      this.mMr.startTimer(1000L, 1000L);
    }
    this.mRi.post((Runnable)this.mMp);
    AppMethodBeat.o(248275);
  }
  
  public final void onError(int paramInt, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(248308);
    if (paramInt == -3301)
    {
      paramBundle = com.tencent.mm.live.core.debug.a.mUy;
      com.tencent.mm.live.core.debug.a.Gb(s.X("[-3301]create room fail,", paramString));
      paramString = beR();
      if (paramString != null) {
        c.a.a(paramString, paramInt);
      }
      beS();
      AppMethodBeat.o(248308);
      return;
    }
    super.onError(paramInt, paramString, paramBundle);
    AppMethodBeat.o(248308);
  }
  
  public final void onExitRoom(int paramInt)
  {
    AppMethodBeat.i(248279);
    super.onExitRoom(paramInt);
    this.mMr.stopTimer();
    AppMethodBeat.o(248279);
  }
  
  public final void onUserVoiceVolume(ArrayList<TRTCCloudDef.TRTCVolumeInfo> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(248379);
    super.onUserVoiceVolume(paramArrayList, paramInt);
    ??? = com.tencent.mm.live.core.core.trtc.sdkadapter.b.b.a.bfv().mTz;
    s.s(???, "getInstance().remoteUserConfigList");
    synchronized ((Iterable)???)
    {
      localObject2 = ((Iterable)???).iterator();
      if (((Iterator)localObject2).hasNext()) {
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.b.a)((Iterator)localObject2).next()).mTx = 0;
      }
    }
    Object localObject2 = ah.aiuX;
    this.mMq = 0;
    Object localObject3;
    if (paramArrayList != null)
    {
      ??? = ((Iterable)paramArrayList).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (TRTCCloudDef.TRTCVolumeInfo)((Iterator)???).next();
        if (Util.isEqual(this.mRB.mNM, ((TRTCCloudDef.TRTCVolumeInfo)localObject2).userId))
        {
          this.mMq = ((TRTCCloudDef.TRTCVolumeInfo)localObject2).volume;
        }
        else
        {
          localObject3 = com.tencent.mm.live.core.core.trtc.sdkadapter.b.b.a.bfv().FU(((TRTCCloudDef.TRTCVolumeInfo)localObject2).userId);
          if (localObject3 != null) {
            ((com.tencent.mm.live.core.core.trtc.sdkadapter.b.a)localObject3).mTx = ((TRTCCloudDef.TRTCVolumeInfo)localObject2).volume;
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
        s.s(localObject3, "it.userId");
        ((ArrayList)???).add(new UserVolumeInfo((String)localObject3, ((TRTCCloudDef.TRTCVolumeInfo)localObject2).volume));
      }
    }
    paramArrayList = new Bundle();
    paramArrayList.putParcelableArrayList("live_user_volume_info", (ArrayList)???);
    ??? = this.mRy;
    if (??? != null)
    {
      localObject2 = e.g.mKv;
      ((com.tencent.mm.live.core.core.c)???).callback(e.g.bcZ(), paramArrayList);
    }
    AppMethodBeat.o(248379);
  }
  
  public final void q(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(248317);
    s.u(paramString1, "roomId");
    s.u(paramString2, "username");
    s.u(paramString3, "pkSign");
    Log.i("MicroMsg.LiveCoreAnchor", "startCrossLinkMic roomId:" + paramString1 + " username:" + paramString2 + " pkSign:" + paramString3);
    this.mRB.mNJ = i.f.mOk;
    r(paramString1, paramString2, paramString3);
    com.tencent.mm.live.core.core.trtc.sdkadapter.c localc = beQ();
    if (localc != null)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("roomId", Long.parseLong(paramString1));
        localJSONObject.put("userId", paramString2);
        localJSONObject.put("sign", paramString3);
        localc.mSx.ConnectOtherRoom(localJSONObject.toString());
        AppMethodBeat.o(248317);
        return;
      }
      catch (Exception paramString1) {}
    }
    AppMethodBeat.o(248317);
  }
  
  public final void release()
  {
    AppMethodBeat.i(248371);
    super.release();
    this.mRi.removeCallbacks((Runnable)this.mMp);
    beS();
    beT();
    AppMethodBeat.o(248371);
  }
  
  public final int stopPush()
  {
    AppMethodBeat.i(248284);
    this.mRs.u(null);
    beO().enableCustomVideoCapture(false);
    com.tencent.mm.live.core.core.trtc.sdkadapter.c localc = beQ();
    if (localc != null) {
      localc.mSx.stopLocalAudio();
    }
    this.mRC = false;
    AppMethodBeat.o(248284);
    return 0;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore;", "TAG", "", "getInstance", "hasInstance", "", "releaseInstance", "", "onlyResetReference", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static b bej()
    {
      AppMethodBeat.i(248133);
      if (b.bei() == null) {
        b.b(new b());
      }
      b localb = b.bei();
      s.checkNotNull(localb);
      AppMethodBeat.o(248133);
      return localb;
    }
    
    public static boolean bek()
    {
      AppMethodBeat.i(248143);
      if (b.bei() != null)
      {
        AppMethodBeat.o(248143);
        return true;
      }
      AppMethodBeat.o(248143);
      return false;
    }
    
    public static void fF(boolean paramBoolean)
    {
      AppMethodBeat.i(248151);
      Log.i("MicroMsg.LiveCoreAnchor", s.X("releaseInstance: onlyResetReference:", Boolean.valueOf(paramBoolean)));
      if (!paramBoolean)
      {
        b localb = b.bei();
        if (localb != null) {
          localb.release();
        }
      }
      b.b(null);
      AppMethodBeat.o(248151);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore$debugRunnable$1", "Ljava/lang/Runnable;", "run", "", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Runnable
  {
    b(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(248131);
      com.tencent.mm.live.core.debug.a locala = com.tencent.mm.live.core.debug.a.mUy;
      com.tencent.mm.live.core.debug.a.Gc(((com.tencent.mm.live.core.core.trtc.c)b.d(this.mMt)).bfk().toString());
      b.e(this.mMt).removeCallbacks((Runnable)this);
      b.e(this.mMt).postDelayed((Runnable)this, 10000L);
      AppMethodBeat.o(248131);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.core.core.a.b
 * JD-Core Version:    0.7.0.1
 */