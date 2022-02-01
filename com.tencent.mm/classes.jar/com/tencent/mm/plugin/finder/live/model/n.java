package com.tencent.mm.plugin.finder.live.model;

import android.os.Bundle;
import com.tencent.d.a.a.a.b.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.live.core.core.c;
import com.tencent.mm.live.core.core.model.g;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.live.cgi.e.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.finder.utils.ba;
import com.tencent.mm.plugin.finder.utils.bb;
import com.tencent.mm.plugin.finder.utils.bb.a;
import com.tencent.mm.plugin.finder.utils.bb.c;
import com.tencent.mm.plugin.finder.utils.bc;
import com.tencent.mm.plugin.findersdk.a.ca.a;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.protocal.protobuf.azv;
import com.tencent.mm.protocal.protobuf.bca;
import com.tencent.mm.protocal.protobuf.bgt;
import com.tencent.mm.protocal.protobuf.bha;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bjk;
import com.tencent.mm.protocal.protobuf.bvg;
import com.tencent.mm.protocal.protobuf.dle;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.a.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveExternalHelper;", "", "()V", "externalLiveCallbacks", "", "Lcom/tencent/plugin/finder/live/api/IExternalLiveCallback;", "kotlin.jvm.PlatformType", "", "finderLiveExternalInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveExternalInfo;", "gameInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGameInfo;", "getGameInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveGameInfo;", "insertMsgList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/MMFinderLiveRoomMsg;", "Lkotlin/collections/ArrayList;", "getInsertMsgList", "()Ljava/util/ArrayList;", "poorNetworkThreshold", "", "appendMiniGameTeamModeTipForExternal", "", "clear", "enterRoom", "liveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "finderLiveAssistant", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "callback", "Lkotlin/Function5;", "", "Lkotlin/ParameterName;", "name", "success", "errCode", "errType", "", "errMsg", "Landroid/os/Bundle;", "extInfo", "getFinderLiveExternalInfo", "getFinderLiveMemberListInfo", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi$Callback;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMemberListInfo;", "handleJoinLiveWxshopResponse", "response", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveResp;", "insertToMsgList", "msg", "notifyMiniWindowStatusToExternal", "isShown", "gameAppId", "gameVersionType", "(ZLjava/lang/String;Ljava/lang/Integer;)V", "onLiveEventCallback", "anchorId", "errorCode", "param", "onLiveFinished", "onPostResult", "result", "onShareToConversation", "toUsers", "parseLiveMsg", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMsgResp;", "postLive", "isFromWeApp", "registerMsgCallback", "setTopic", "topic", "Lcom/tencent/plugin/finder/live/api/IPluginFinderLive$IGameLiveSetTopicCallback;", "unregisterMsgCallback", "updateAnchorStatus", "bs", "Lcom/tencent/mm/protobuf/ByteString;", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
{
  private static final String CFA;
  private static final String CFB;
  private static final int[] CFC;
  public static final n.a CFu;
  public static final String TAG;
  public final List<com.tencent.d.a.a.a.a> CFv;
  public bgt CFw;
  final int CFx;
  public final bha CFy;
  public final ArrayList<dle> CFz;
  
  static
  {
    AppMethodBeat.i(359442);
    CFu = new n.a((byte)0);
    TAG = "FinderLiveExternalHelper";
    CFA = "EXT_INFO_KEY_REAL_NAME_URL";
    CFB = "EXT_INFO_KEY_ERROR_PAGE";
    CFC = new int[] { 8, 128, 512 };
    AppMethodBeat.o(359442);
  }
  
  public n()
  {
    AppMethodBeat.i(359376);
    this.CFv = Collections.synchronizedList((List)new ArrayList());
    this.CFw = new bgt();
    com.tencent.d.a.a.a.a.a locala = com.tencent.d.a.a.a.a.a.ahiX;
    this.CFx = ((Number)com.tencent.d.a.a.a.a.a.jTQ().bmg()).intValue();
    this.CFy = new bha();
    this.CFz = new ArrayList();
    AppMethodBeat.o(359376);
  }
  
  public static void a(ap paramap, final com.tencent.mm.plugin.finder.live.model.context.a parama, ca.a<List<bjk>> parama1)
  {
    AppMethodBeat.i(359384);
    kotlin.g.b.s.u(parama1, "callback");
    if ((paramap != null) && (parama != null)) {
      paramap.d((r)new c(parama1, parama));
    }
    for (paramap = ah.aiuX;; paramap = null)
    {
      if (paramap == null) {
        parama1.onCallback((List)ab.aivy);
      }
      AppMethodBeat.o(359384);
      return;
    }
  }
  
  public static void a(ap paramap, com.tencent.mm.plugin.finder.live.model.context.a parama, final String paramString, final b.f paramf)
  {
    AppMethodBeat.i(359392);
    kotlin.g.b.s.u(paramString, "topic");
    kotlin.g.b.s.u(paramf, "callback");
    if ((paramap != null) && (parama != null)) {
      paramap.e(paramString, (m)new f(parama, paramString, paramf));
    }
    for (paramap = ah.aiuX;; paramap = null)
    {
      if (paramap == null) {
        paramf.ao(false, "invalid status");
      }
      AppMethodBeat.o(359392);
      return;
    }
  }
  
  public final void ekG()
  {
    AppMethodBeat.i(359453);
    ??? = this.CFv;
    kotlin.g.b.s.s(???, "externalLiveCallbacks");
    synchronized ((Iterable)???)
    {
      Iterator localIterator = ((Iterable)???).iterator();
      if (localIterator.hasNext())
      {
        com.tencent.d.a.a.a.a locala = (com.tencent.d.a.a.a.a)localIterator.next();
        Log.i(TAG, "onLiveFinished");
        locala.ekG();
      }
    }
    ah localah = ah.aiuX;
    AppMethodBeat.o(359453);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/FinderLiveExternalHelper$enterRoom$1$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements c
  {
    b(com.tencent.mm.plugin.finder.live.model.context.a parama, ap paramap, kotlin.g.a.s<? super Boolean, ? super Integer, ? super Integer, ? super String, ? super Bundle, ah> params, n paramn) {}
    
    public final void callback(final int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(359567);
      Log.i(n.access$getTAG$cp(), "on enterRoom finish, liveData.business(LiveCommonSlice::class.java).enableAudioMode():" + ((e)this.BxA.business(e.class)).eyt() + " audioModeHolderBm:" + ((e)this.BxA.business(e.class)).DVR);
      Object localObject;
      if (paramInt > 0)
      {
        paramBundle = bc.GkH;
        bc.qS(cn.bDu());
        paramBundle = ba.Gjt;
        localObject = bb.GjM;
        ba.a(paramBundle, bb.fhA().name, null, false, false, 14);
        paramBundle = this.CFD;
        if (paramBundle != null)
        {
          paramBundle.a(((f)this.BxA.business(f.class)).liveInfo.liveId, ((f)this.BxA.business(f.class)).hKN, ((e)this.BxA.business(e.class)).Ecp, 1, (e.a)new a(this.BxA, this.CFD, this.CFE, this.CEo, paramInt));
          AppMethodBeat.o(359567);
        }
      }
      else
      {
        localObject = ba.Gjt;
        bb.a locala = bb.GjM;
        ba.a((ba)localObject, bb.fhz().name, null, false, true, 6);
        Log.w(n.access$getTAG$cp(), "enter room fail");
        localObject = this.CFD;
        if (localObject != null) {
          ap.a.a((ap)localObject, (kotlin.g.a.s)n.b.b.CFH);
        }
        localObject = bc.GkH;
        bc.it(bc.fhK(), String.valueOf(paramBundle));
        this.CEo.a(Boolean.FALSE, Integer.valueOf(paramInt), Integer.valueOf(-1), null, null);
      }
      AppMethodBeat.o(359567);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/FinderLiveExternalHelper$enterRoom$1$1$callback$1", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveAnchorStatus$CallBack;", "onFail", "", "errType", "", "errCode", "errMsg", "", "anchorStatus", "onSuccess", "micSettingFlag", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements e.a
    {
      a(com.tencent.mm.plugin.finder.live.model.context.a parama, ap paramap, n paramn, kotlin.g.a.s<? super Boolean, ? super Integer, ? super Integer, ? super String, ? super Bundle, ah> params, int paramInt) {}
      
      public final void a(bvg parambvg)
      {
        AppMethodBeat.i(359500);
        kotlin.g.b.s.u(this, "this");
        AppMethodBeat.o(359500);
      }
      
      public final void am(int paramInt, long paramLong)
      {
        AppMethodBeat.i(359486);
        Log.i(n.access$getTAG$cp(), "share live success!");
        d.uiThread((kotlin.g.a.a)new b(this.BxA, this.CFD, this.CFE, this.CEo, paramInt));
        AppMethodBeat.o(359486);
      }
      
      public final void b(final int paramInt1, final int paramInt2, final String paramString, int paramInt3)
      {
        AppMethodBeat.i(359493);
        Log.i(n.access$getTAG$cp(), "share live fail!");
        d.uiThread((kotlin.g.a.a)new a(this.CFD, paramInt2, paramInt1, paramString, this.BxA, this.CEo));
        AppMethodBeat.o(359493);
      }
      
      public final void eho()
      {
        AppMethodBeat.i(359507);
        kotlin.g.b.s.u(this, "this");
        AppMethodBeat.o(359507);
      }
      
      @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
      static final class a
        extends kotlin.g.b.u
        implements kotlin.g.a.a<ah>
      {
        a(ap paramap, int paramInt1, int paramInt2, String paramString, com.tencent.mm.plugin.finder.live.model.context.a parama, kotlin.g.a.s<? super Boolean, ? super Integer, ? super Integer, ? super String, ? super Bundle, ah> params)
        {
          super();
        }
      }
      
      @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
      static final class b
        extends kotlin.g.b.u
        implements kotlin.g.a.a<ah>
      {
        b(com.tencent.mm.plugin.finder.live.model.context.a parama, ap paramap, n paramn, kotlin.g.a.s<? super Boolean, ? super Integer, ? super Integer, ? super String, ? super Bundle, ah> params, int paramInt)
        {
          super();
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "errCode", "", "errType", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveOnlineMemberResp;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements r<Integer, Integer, String, azv, ah>
  {
    c(ca.a<List<bjk>> parama, com.tencent.mm.plugin.finder.live.model.context.a parama1)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "needFaceVerify", "verifyUrl", "", "errType", "", "errCode", "errMsg", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLiveResp;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.u<Boolean, Boolean, String, Integer, Integer, String, awc, ah>
  {
    d(com.tencent.mm.plugin.finder.live.model.context.a parama, ap paramap, n paramn, boolean paramBoolean, kotlin.g.a.s<? super Boolean, ? super Integer, ? super Integer, ? super String, ? super Bundle, ah> params)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    e(n paramn, com.tencent.d.a.a.a.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "ret", "", "errMsg", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements m<Boolean, String, ah>
  {
    f(com.tencent.mm.plugin.finder.live.model.context.a parama, String paramString, b.f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    g(n paramn, com.tencent.d.a.a.a.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.n
 * JD-Core Version:    0.7.0.1
 */