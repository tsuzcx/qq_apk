package com.tencent.mm.plugin.finder.live.viewmodel.data.business;

import android.content.Context;
import android.content.res.Resources;
import androidx.lifecycle.af;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.live.core.core.trtc.sdkadapter.b.b.a;
import com.tencent.mm.live.model.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.model.am;
import com.tencent.mm.plugin.finder.live.model.i;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.protocal.protobuf.bdr;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.bdt;
import com.tencent.mm.protocal.protobuf.bdu;
import com.tencent.mm.protocal.protobuf.bdv;
import com.tencent.mm.protocal.protobuf.bdy;
import com.tencent.mm.protocal.protobuf.bdz;
import com.tencent.mm.protocal.protobuf.bea;
import com.tencent.mm.protocal.protobuf.beo;
import com.tencent.mm.protocal.protobuf.bfs;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bjl;
import com.tencent.mm.protocal.protobuf.bke;
import com.tencent.mm.protocal.protobuf.dom;
import com.tencent.mm.protocal.protobuf.edv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.w.a.a.a.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.bdm;>;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveLinkMicSlice;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/IBusiness;", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "liveContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "acceptMicMsg", "", "acceptMicPkMsg", "acceptSeq", "", "getAcceptSeq", "()J", "setAcceptSeq", "(J)V", "applyMicMsg", "applyMicPkMsg", "applySessionId", "", "getApplySessionId", "()Ljava/lang/String;", "setApplySessionId", "(Ljava/lang/String;)V", "audienceLinkMicUserList", "", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType", "", "getAudienceLinkMicUserList", "()Ljava/util/List;", "setAudienceLinkMicUserList", "(Ljava/util/List;)V", "audienceMicOverFlow", "", "getAudienceMicOverFlow", "()Z", "setAudienceMicOverFlow", "(Z)V", "battleApplyMsg", "battleCloseMsg", "battleStatusMsg", "closeMicMsg", "closeMicPkMsg", "curApplyPkAnchor", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/ApplyPkAnchorInfo;", "getCurApplyPkAnchor", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/ApplyPkAnchorInfo;", "setCurApplyPkAnchor", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/ApplyPkAnchorInfo;)V", "curBattle", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBattleData;", "getCurBattle", "()Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBattleData;", "setCurBattle", "(Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBattleData;)V", "curLinkMicUser", "getCurLinkMicUser", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "setCurLinkMicUser", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;)V", "enableBattleSwitch", "getEnableBattleSwitch", "setEnableBattleSwitch", "enableLinkMic", "getEnableLinkMic", "setEnableLinkMic", "enableLinkMicAntispam", "getEnableLinkMicAntispam", "setEnableLinkMicAntispam", "enableLinkMicFlag", "", "getEnableLinkMicFlag", "()I", "setEnableLinkMicFlag", "(I)V", "enableLinkMicSwitch", "getEnableLinkMicSwitch", "setEnableLinkMicSwitch", "linkMicState", "getLinkMicState", "setLinkMicState", "linkMicStatusMap", "Ljava/util/HashMap;", "getLinkMicStatusMap", "()Ljava/util/HashMap;", "linkMicUserInfoList", "getLinkMicUserInfoList", "setLinkMicUserInfoList", "linkMicUserList", "getLinkMicUserList", "setLinkMicUserList", "linkingAndWaitingAudienceSize", "getLinkingAndWaitingAudienceSize", "micSetting", "Lcom/tencent/mm/protocal/protobuf/MicSetting;", "getMicSetting", "()Lcom/tencent/mm/protocal/protobuf/MicSetting;", "setMicSetting", "(Lcom/tencent/mm/protocal/protobuf/MicSetting;)V", "newApplyCount", "getNewApplyCount", "setNewApplyCount", "newLinkMicUserList", "getNewLinkMicUserList", "setNewLinkMicUserList", "newPkApplyCount", "getNewPkApplyCount", "setNewPkApplyCount", "pendingNotifyMicUserList", "getPendingNotifyMicUserList", "pkStatusMsg", "randomMicApplyMsg", "randomMicMatchTimeout", "getRandomMicMatchTimeout", "setRandomMicMatchTimeout", "roomPk", "getRoomPk", "setRoomPk", "streamDelay", "getStreamDelay", "setStreamDelay", "appendLinkMicTip", "", "roomData", "appendMicSettingTip", "audienceMicLinking", "micId", "audienceMicWaiting", "checkBattleApplyMsg", "remoteLiveAppMsg", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "checkBattleCloseMsg", "checkBattleStatusForAnchor", "battleInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBattleInfo;", "appMsg", "checkBattleStatusForVisitor", "checkBattleStatusMsg", "checkLinkAcceptMsg", "liveData", "checkLinkAcceptPkMsg", "checkLinkCloseMsg", "checkLinkClosePkMsg", "checkLinkState", "checkOtherRoomAudienceMicList", "audienceMicList", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgAudienceMicInfo;", "sessionId", "checkPkStatusMsg", "checkRandomMicApplyMsg", "clearOtherRoomAudienceMicUser", "filterAcceptLinkMicMsg", "appMsgList", "filterAcceptLinkMicPkMsg", "filterApplyLinkMicMsg", "filterApplyLinkMicPkMsg", "filterBattleApplyMsg", "filterBattleCloseMsg", "filterBattleStatusMsg", "filterCloseLinkMicMsg", "filterCloseLinkMicPkMsg", "filterPkStatusMsg", "filterRandomMicApplyMsg", "getAudienceLinkMicUserByMicId", "getAudienceLinkMicUserByUserId", "userId", "handleLinkMicMsg", "handleLinkMicPkMsg", "linkMicWait", "linking", "onCleared", "removeAudienceLinkMicUser", "removeLinkMicUserInfo", "safeAddLinkMicUserInfo", "micUser", "transferAudienceInfoToAppMsgInfo", "list", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMicAudienceInfo;", "updateAnchorStatus", "anchorStatusFlag", "anchorStatus", "Lcom/tencent/mm/protocal/protobuf/LiveAnchorStatus;", "updateAnchorStatus2", "Lkotlin/Pair;", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends c<com.tencent.mm.plugin.finder.live.model.context.a>
{
  public static final a Efq;
  public dom Cvf;
  private int EfA;
  public int EfB;
  private boolean EfC;
  public boolean EfD;
  public boolean EfE;
  public com.tencent.mm.plugin.finder.live.viewmodel.data.b EfF;
  public final HashMap<String, Integer> EfG;
  public final List<com.tencent.mm.plugin.finder.live.viewmodel.data.h> EfH;
  public long EfI;
  public boolean EfJ;
  public i EfK;
  public int EfL;
  public boolean EfM;
  public final int[] EfN;
  public final int[] EfO;
  private final int[] EfP;
  private final int[] EfQ;
  public final int[] EfR;
  private final int[] EfS;
  private final int[] EfT;
  private final int[] EfU;
  private final int[] EfV;
  private final int[] EfW;
  private final int[] EfX;
  public long Efr;
  public String Efs;
  public List<com.tencent.mm.plugin.finder.live.viewmodel.data.h> Eft;
  public List<com.tencent.mm.plugin.finder.live.viewmodel.data.h> Efu;
  public com.tencent.mm.plugin.finder.live.viewmodel.data.h Efv;
  public List<com.tencent.mm.plugin.finder.live.viewmodel.data.h> Efw;
  public List<com.tencent.mm.plugin.finder.live.viewmodel.data.h> Efx;
  public int Efy;
  private int Efz;
  
  static
  {
    AppMethodBeat.i(356952);
    Efq = new a((byte)0);
    AppMethodBeat.o(356952);
  }
  
  public j(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(356812);
    this.Efs = "";
    this.Eft = Collections.synchronizedList((List)new ArrayList());
    this.Efu = Collections.synchronizedList((List)new ArrayList());
    this.Efw = Collections.synchronizedList((List)new ArrayList());
    this.Efx = Collections.synchronizedList((List)new ArrayList());
    this.EfB = -1;
    this.EfE = true;
    this.EfG = new HashMap();
    this.EfH = Collections.synchronizedList((List)new ArrayList());
    this.Cvf = new dom();
    this.EfN = new int[] { 20004 };
    this.EfO = new int[] { 20003 };
    this.EfP = new int[] { 20005 };
    this.EfQ = new int[] { 20016 };
    this.EfR = new int[] { 20015 };
    this.EfS = new int[] { 20017 };
    this.EfT = new int[] { 20018 };
    this.EfU = new int[] { 20029 };
    this.EfV = new int[] { 20026 };
    this.EfW = new int[] { 20028 };
    this.EfX = new int[] { 20039 };
    AppMethodBeat.o(356812);
  }
  
  private final void a(bfs parambfs)
  {
    long l = 0L;
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    AppMethodBeat.i(356840);
    Object localObject5 = (e)business(e.class);
    if (localObject5 != null) {}
    int i;
    switch (parambfs.status)
    {
    default: 
      Log.w("MMFinder.LiveLinkMicSlice", s.X("[Battle] receive unknown status msg:", Integer.valueOf(parambfs.status)));
      AppMethodBeat.o(356840);
      return;
    case 10: 
      localObject1 = parambfs.ZPC;
      s.s(localObject1, "battleInfo.player_info");
      localObject3 = ((Iterable)localObject1).iterator();
      for (;;)
      {
        if (((Iterator)localObject3).hasNext())
        {
          localObject1 = ((Iterator)localObject3).next();
          localObject4 = ((edv)localObject1).YIZ;
          localObject5 = business(e.class);
          s.checkNotNull(localObject5);
          if (!Util.isEqual((String)localObject4, ((e)localObject5).mIC))
          {
            i = 1;
            if (i == 0) {
              continue;
            }
            label181:
            localObject3 = (edv)localObject1;
            localObject4 = new StringBuilder("[Battle] receive start battle status msg:[battle_id:").append(parambfs.ZPA).append(", battle_seq").append(parambfs.ZOv).append("] curBattle:").append(this.EfK).append(" battleUser:");
            if (localObject3 != null) {
              break label295;
            }
          }
        }
      }
      label295:
      for (localObject1 = null;; localObject1 = ((edv)localObject3).YIZ)
      {
        Log.i("MMFinder.LiveLinkMicSlice", localObject1);
        if (localObject3 != null) {
          break label305;
        }
        Log.w("MMFinder.LiveLinkMicSlice", "[Battle] receive battleStatusMsg skip. battleUser is null");
        AppMethodBeat.o(356840);
        return;
        i = 0;
        break;
        localObject1 = null;
        break label181;
      }
      label305:
      localObject3 = parambfs.ZPA;
      localObject1 = this.EfK;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (Util.isEqual((String)localObject3, (String)localObject1)) {
          break label412;
        }
        localObject1 = new StringBuilder("[Battle] receive battleStatusMsg skip. invalid battleId. recBattleId:").append(parambfs.ZPA).append(", localBattleId:");
        parambfs = this.EfK;
        if (parambfs != null) {
          break label404;
        }
      }
      label404:
      for (parambfs = (bfs)localObject2;; parambfs = parambfs.CES)
      {
        Log.w("MMFinder.LiveLinkMicSlice", parambfs);
        AppMethodBeat.o(356840);
        return;
        localObject1 = ((i)localObject1).CES;
        break;
      }
      label412:
      localObject1 = this.EfK;
      if (localObject1 == null) {}
      for (l = 0L; l > parambfs.ZOv; l = ((i)localObject1).CET)
      {
        Log.w("MMFinder.LiveLinkMicSlice", "[Battle] receive battleStatusMsg skip. invalid seq");
        AppMethodBeat.o(356840);
        return;
      }
      localObject1 = this.EfK;
      if (localObject1 != null) {
        ((i)localObject1).CEW = 2;
      }
      localObject1 = this.EfK;
      if (localObject1 != null) {
        ((i)localObject1).CEU = parambfs.ZPB;
      }
      parambfs = com.tencent.mm.live.model.p.mZf;
      parambfs = com.tencent.mm.live.model.p.bhS();
      if (parambfs != null) {
        parambfs.onBattleStart();
      }
      ((com.tencent.mm.plugin.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.k.class)).bUO();
      AppMethodBeat.o(356840);
      return;
    }
    Object localObject1 = parambfs.ZPC;
    s.s(localObject1, "battleInfo.player_info");
    localObject2 = ((Iterable)localObject1).iterator();
    Object localObject6;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      localObject6 = ((edv)localObject1).YIZ;
      af localaf = business(e.class);
      s.checkNotNull(localaf);
      if (!Util.isEqual((String)localObject6, ((e)localaf).mIC))
      {
        i = 1;
        label622:
        if (i == 0) {
          break label757;
        }
        label626:
        localObject6 = (edv)localObject1;
        localObject1 = this.EfK;
        if (localObject1 != null) {
          break label765;
        }
        localObject1 = null;
        label647:
        localObject5 = new StringBuilder("[Battle] receive finish battle status msg:[battle_id:").append(parambfs.ZPA).append(", battle_seq").append(parambfs.ZOv).append("] localBattleUser:").append(localObject1).append(" curBattle:").append(this.EfK).append(" battleUser:");
        if (localObject6 != null) {
          break label780;
        }
      }
    }
    label780:
    for (localObject2 = null;; localObject2 = ((edv)localObject6).YIZ)
    {
      Log.i("MMFinder.LiveLinkMicSlice", localObject2);
      if (localObject6 != null) {
        break label790;
      }
      Log.w("MMFinder.LiveLinkMicSlice", "[Battle] receive battleStatusMsg skip. battleUser is null");
      AppMethodBeat.o(356840);
      return;
      i = 0;
      break label622;
      label757:
      break;
      localObject1 = null;
      break label626;
      label765:
      localObject1 = ((i)localObject1).awt(((e)localObject5).mIC);
      break label647;
    }
    label790:
    if (localObject1 == null)
    {
      Log.w("MMFinder.LiveLinkMicSlice", "[Battle] receive battleStatusMsg skip. waitBattleUser is null");
      AppMethodBeat.o(356840);
      return;
    }
    localObject2 = parambfs.ZPA;
    localObject1 = this.EfK;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (Util.isEqual((String)localObject2, (String)localObject1)) {
        break label918;
      }
      localObject1 = new StringBuilder("[Battle] receive battleStatusMsg skip. invalid battleId. recBattleId:").append(parambfs.ZPA).append(", localBattleId:");
      parambfs = this.EfK;
      if (parambfs != null) {
        break label910;
      }
    }
    label910:
    for (parambfs = (bfs)localObject4;; parambfs = parambfs.CES)
    {
      Log.w("MMFinder.LiveLinkMicSlice", parambfs);
      AppMethodBeat.o(356840);
      return;
      localObject1 = ((i)localObject1).CES;
      break;
    }
    label918:
    localObject1 = this.EfK;
    if (localObject1 == null) {}
    while (l > parambfs.ZOv)
    {
      Log.w("MMFinder.LiveLinkMicSlice", "[Battle] receive battleStatusMsg skip. invalid seq");
      AppMethodBeat.o(356840);
      return;
      l = ((i)localObject1).CET;
    }
    localObject1 = this.EfK;
    if (localObject1 != null) {
      ((i)localObject1).OO(parambfs.result);
    }
    localObject1 = this.EfK;
    if (localObject1 != null) {
      ((i)localObject1).CEU = parambfs.ZPB;
    }
    localObject1 = this.EfK;
    if (localObject1 != null)
    {
      localObject2 = parambfs.ZPC;
      s.s(localObject2, "battleInfo.player_info");
      ((i)localObject1).gr((List)localObject2);
    }
    localObject1 = com.tencent.mm.live.model.p.mZf;
    localObject1 = com.tencent.mm.live.model.p.bhS();
    if (localObject1 != null) {
      ((g)localObject1).onBattleEnd();
    }
    localObject1 = (com.tencent.mm.plugin.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.k.class);
    l = parambfs.ZPB;
    parambfs = this.EfK;
    if (parambfs == null) {}
    for (parambfs = (bfs)localObject3;; parambfs = parambfs.CES)
    {
      ((com.tencent.mm.plugin.k)localObject1).j(l * 1000L, parambfs);
      AppMethodBeat.o(356840);
      return;
    }
  }
  
  private final void b(bfs parambfs)
  {
    long l = 0L;
    Object localObject2 = null;
    Object localObject3 = null;
    AppMethodBeat.i(356893);
    Object localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
    localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.emY();
    if (localObject1 != null)
    {
      localObject4 = (e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(e.class);
      if (localObject4 == null) {}
    }
    switch (parambfs.status)
    {
    default: 
      Log.w("MMFinder.LiveLinkMicSlice", s.X("[Battle] receive unknown status msg:", Integer.valueOf(parambfs.status)));
      AppMethodBeat.o(356893);
      return;
    case 10: 
      localObject1 = parambfs.ZPC;
      s.s(localObject1, "battleInfo.player_info");
      localObject2 = ((Iterable)localObject1).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = ((Iterator)localObject2).next();
          if (!Util.isEqual(((edv)localObject1).YIZ, ((e)localObject4).mIC))
          {
            i = 1;
            if (i == 0) {
              continue;
            }
            label172:
            localObject2 = (edv)localObject1;
            localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
            localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.emY();
            if (localObject1 != null) {
              break label341;
            }
            localObject1 = null;
            label197:
            localObject3 = new StringBuilder("[Battle] receive start battle status msg:[battle_id:").append(parambfs.ZPA).append(", battle_seq").append(parambfs.ZOv).append("] curPkUser:").append(localObject1).append(" curBattle:").append(this.EfK).append(" battleUser:");
            if (localObject2 != null) {
              break label374;
            }
          }
        }
      }
      label341:
      label374:
      for (localObject1 = null;; localObject1 = ((edv)localObject2).YIZ)
      {
        Log.i("MMFinder.LiveLinkMicSlice", localObject1 + " delayMs:" + parambfs.ZPD + " streamDelay:" + this.EfI);
        if (localObject2 != null) {
          break label384;
        }
        Log.w("MMFinder.LiveLinkMicSlice", "[Battle] receive battleStatusMsg skip. battleUser is null");
        AppMethodBeat.o(356893);
        return;
        i = 0;
        break;
        localObject1 = null;
        break label172;
        localObject1 = (j)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(j.class);
        if (localObject1 == null)
        {
          localObject1 = null;
          break label197;
        }
        localObject1 = ((j)localObject1).Efv;
        break label197;
      }
      label384:
      localObject1 = this.EfK;
      if (localObject1 == null) {}
      for (l = 0L; l > parambfs.ZOv; l = ((i)localObject1).CET)
      {
        Log.w("MMFinder.LiveLinkMicSlice", "[Battle] receive battleStatusMsg skip. invalid seq");
        AppMethodBeat.o(356893);
        return;
      }
      localObject1 = new i(parambfs.ZPA, parambfs.ZOv, parambfs.ZPB, -1, 4, null, 32);
      localObject2 = parambfs.ZPC;
      s.s(localObject2, "battleInfo.player_info");
      ((i)localObject1).gr((List)localObject2);
      localObject2 = ah.aiuX;
      this.EfK = ((i)localObject1);
      ((com.tencent.mm.plugin.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.k.class)).bUP();
      ((com.tencent.mm.plugin.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.k.class)).k(kotlin.k.k.bR(this.EfI, 0L), parambfs.ZPA);
      ((com.tencent.mm.plugin.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.k.class)).bUO();
      AppMethodBeat.o(356893);
      return;
    }
    localObject1 = parambfs.ZPC;
    s.s(localObject1, "battleInfo.player_info");
    Object localObject5 = ((Iterable)localObject1).iterator();
    if (((Iterator)localObject5).hasNext())
    {
      localObject1 = ((Iterator)localObject5).next();
      if (!Util.isEqual(((edv)localObject1).YIZ, ((e)localObject4).mIC))
      {
        i = 1;
        label619:
        if (i == 0) {
          break label768;
        }
        label623:
        localObject5 = (edv)localObject1;
        localObject1 = ((j)((e)localObject4).business(j.class)).Efv;
        localObject4 = new StringBuilder("[Battle] receive finish battle status msg:[battle_id:").append(parambfs.ZPA).append(", battle_seq").append(parambfs.ZOv).append("] curPkUser:").append(localObject1).append(" curBattle:").append(this.EfK).append(" battleUser:");
        if (localObject5 != null) {
          break label776;
        }
      }
    }
    label768:
    label776:
    for (localObject1 = null;; localObject1 = ((edv)localObject5).YIZ)
    {
      Log.i("MMFinder.LiveLinkMicSlice", localObject1 + " battleInfo.time_left:" + parambfs.ZPB);
      if (localObject5 != null) {
        break label786;
      }
      Log.w("MMFinder.LiveLinkMicSlice", "[Battle] receive battleStatusMsg skip. battleUser is null");
      AppMethodBeat.o(356893);
      return;
      i = 0;
      break label619;
      break;
      localObject1 = null;
      break label623;
    }
    label786:
    Object localObject4 = parambfs.ZPA;
    localObject1 = this.EfK;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (Util.isEqual((String)localObject4, (String)localObject1)) {
        break label893;
      }
      localObject1 = new StringBuilder("[Battle] receive battleStatusMsg skip. invalid battleId. recBattleId:").append(parambfs.ZPA).append(", localBattleId:");
      parambfs = this.EfK;
      if (parambfs != null) {
        break label885;
      }
    }
    label885:
    for (parambfs = (bfs)localObject3;; parambfs = parambfs.CES)
    {
      Log.w("MMFinder.LiveLinkMicSlice", parambfs);
      AppMethodBeat.o(356893);
      return;
      localObject1 = ((i)localObject1).CES;
      break;
    }
    label893:
    localObject1 = this.EfK;
    if (localObject1 == null) {}
    while (l > parambfs.ZOv)
    {
      Log.w("MMFinder.LiveLinkMicSlice", "[Battle] receive battleStatusMsg skip. invalid seq");
      AppMethodBeat.o(356893);
      return;
      l = ((i)localObject1).CET;
    }
    localObject1 = this.EfK;
    if ((localObject1 != null) && (((i)localObject1).ekB() == true)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.i("MMFinder.LiveLinkMicSlice", "[Battle] receive battleStatusMsg skip. battle in start wait.");
      ((com.tencent.mm.plugin.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.k.class)).bUP();
      AppMethodBeat.o(356893);
      return;
    }
    localObject1 = this.EfK;
    if (localObject1 != null) {
      ((i)localObject1).OO(parambfs.result);
    }
    localObject1 = this.EfK;
    if (localObject1 != null) {
      ((i)localObject1).CEU = parambfs.ZPB;
    }
    localObject1 = this.EfK;
    if (localObject1 != null)
    {
      localObject3 = parambfs.ZPC;
      s.s(localObject3, "battleInfo.player_info");
      ((i)localObject1).gr((List)localObject3);
    }
    localObject1 = com.tencent.mm.live.model.p.mZf;
    localObject1 = com.tencent.mm.live.model.p.bhS();
    if (localObject1 != null) {
      ((g)localObject1).onBattleEnd();
    }
    localObject1 = (com.tencent.mm.plugin.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.k.class);
    l = parambfs.ZPB;
    parambfs = this.EfK;
    if (parambfs == null) {}
    for (parambfs = (bfs)localObject2;; parambfs = parambfs.CES)
    {
      ((com.tencent.mm.plugin.k)localObject1).j(l * 1000L, parambfs);
      AppMethodBeat.o(356893);
      return;
    }
  }
  
  public static void f(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    long l2 = 0L;
    AppMethodBeat.i(356910);
    Object localObject1;
    long l1;
    if (parama != null)
    {
      localObject1 = com.tencent.mm.plugin.finder.live.util.u.DJC;
      localObject1 = ((j)parama.business(j.class)).Cvf;
      if (localObject1 != null) {
        break label169;
      }
      l1 = 0L;
      if (!com.tencent.mm.plugin.finder.live.util.u.oG(l1)) {
        break label178;
      }
      localObject1 = MMApplicationContext.getContext().getResources().getString(a.i.finder_live_mic_setting_follow_msg_tip);
      label60:
      s.s(localObject1, "when {\n                L…          }\n            }");
      if (((CharSequence)localObject1).length() != 0) {
        break label314;
      }
    }
    label169:
    label178:
    label314:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        Object localObject2 = new bke();
        ((bke)localObject2).type = 10001;
        ((bke)localObject2).content = ((String)localObject1);
        ah localah = ah.aiuX;
        localObject2 = new am((bke)localObject2);
        ((l)parama.business(l.class)).EgE.add(localObject2);
      }
      Log.i("MMFinder.LiveLinkMicSlice", s.X("appendMicSettingTip:", localObject1));
      AppMethodBeat.o(356910);
      return;
      l1 = ((dom)localObject1).CJK;
      break;
      localObject1 = com.tencent.mm.plugin.finder.live.util.u.DJC;
      localObject1 = ((j)parama.business(j.class)).Cvf;
      if (localObject1 == null) {}
      for (l1 = 0L;; l1 = ((dom)localObject1).CJK)
      {
        if (!com.tencent.mm.plugin.finder.live.util.u.oH(l1)) {
          break label237;
        }
        localObject1 = MMApplicationContext.getContext().getResources().getString(a.i.finder_live_mic_setting_reward_msg_tip);
        break;
      }
      label237:
      localObject1 = com.tencent.mm.plugin.finder.live.util.u.DJC;
      localObject1 = ((j)parama.business(j.class)).Cvf;
      if (localObject1 == null) {}
      for (l1 = l2;; l1 = ((dom)localObject1).CJK)
      {
        if (!com.tencent.mm.plugin.finder.live.util.u.oI(l1)) {
          break label297;
        }
        localObject1 = MMApplicationContext.getContext().getResources().getString(a.i.finder_live_mic_setting_buy_product_msg_tip);
        break;
      }
      localObject1 = MMApplicationContext.getContext().getResources().getString(a.i.finder_live_mic_setting_all_msg_tip);
      break label60;
    }
  }
  
  public static List<bdu> gX(List<? extends bjl> paramList)
  {
    AppMethodBeat.i(356940);
    if (paramList == null)
    {
      AppMethodBeat.o(356940);
      return null;
    }
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      bjl localbjl = (bjl)((Iterator)localObject).next();
      bdu localbdu = new bdu();
      localbdu.ZOh = localbjl.ZOh;
      localbdu.ZOf = localbjl.ZOf;
      localbdu.ZlX = localbjl.ZlX;
      localbdu.YBM = localbjl.YBM;
      localbdu.ZOy = localbjl.ZOy;
      paramList.add(localbdu);
    }
    paramList = (List)paramList;
    AppMethodBeat.o(356940);
    return paramList;
  }
  
  public static void v(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(356924);
    bke localbke;
    if (parama != null)
    {
      localbke = new bke();
      localbke.type = 10001;
      if (((j)parama.business(j.class)).eyW()) {
        break label117;
      }
    }
    label117:
    for (Object localObject = MMApplicationContext.getContext().getResources().getString(a.i.finder_live_link_mic_enable_msg_tip);; localObject = MMApplicationContext.getContext().getResources().getString(a.i.finder_live_link_mic_disable_msg_tip))
    {
      localbke.content = ((String)localObject);
      localObject = ah.aiuX;
      localObject = new am(localbke);
      ((l)parama.business(l.class)).EgE.add(localObject);
      Log.i("MMFinder.LiveLinkMicSlice", s.X("appendLinkMicTip:", ((am)localObject).CIc.content));
      AppMethodBeat.o(356924);
      return;
    }
  }
  
  public final void aE(LinkedList<bdm> paramLinkedList)
  {
    AppMethodBeat.i(357117);
    Object localObject1 = new LinkedList();
    Object localObject2 = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      localObject4 = (bdm)localObject3;
      if (kotlin.a.k.contains(this.EfP, ((bdm)localObject4).msg_type)) {
        paramLinkedList.add(localObject3);
      }
    }
    ((LinkedList)localObject1).addAll((Collection)paramLinkedList);
    paramLinkedList = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = paramLinkedList.iterator();
    label167:
    int i;
    label218:
    label221:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      paramLinkedList = ((bdm)localObject3).ZOb;
      if (paramLinkedList == null)
      {
        paramLinkedList = null;
        if (Util.isEqual(paramLinkedList, z.bAM())) {
          break label218;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label221;
        }
        ((Collection)localObject1).add(localObject3);
        break;
        paramLinkedList = paramLinkedList.contact;
        if (paramLinkedList == null)
        {
          paramLinkedList = null;
          break label167;
        }
        paramLinkedList = paramLinkedList.username;
        break label167;
      }
    }
    localObject1 = (List)localObject1;
    localObject2 = ((Iterable)localObject1).iterator();
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (bdm)((Iterator)localObject2).next();
      localObject4 = new bdz();
      ??? = (com.tencent.mm.bx.a)localObject4;
      paramLinkedList = ((bdm)localObject3).ZNY;
      if (paramLinkedList == null) {
        paramLinkedList = null;
      }
      Object localObject6;
      boolean bool;
      for (;;)
      {
        try
        {
          ((com.tencent.mm.bx.a)???).parseFrom(paramLinkedList);
          Log.i("MMFinder.LiveLinkMicSlice", "receive close mic msg, [sdkUserId:" + ((bdz)localObject4).ZlX + ", sessionId:" + ((bdm)localObject3).session_id + "], curLiveUser:" + this.Efv + ", audienceLinkMicUserList:" + this.Efw + ", applySessionId:" + this.Efs);
          localObject6 = ((bdm)localObject3).session_id;
          if (localObject6 == null) {
            break;
          }
          ((Map)this.EfG).put(localObject6, Integer.valueOf(3));
          if (!((com.tencent.mm.plugin.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.k.class)).bUB()) {
            break label815;
          }
          paramLinkedList = this.Efw;
          s.s(paramLinkedList, "audienceLinkMicUserList");
        }
        catch (Exception paramLinkedList)
        {
          synchronized ((Iterable)paramLinkedList)
          {
            localObject6 = ((Iterable)???).iterator();
            if (((Iterator)localObject6).hasNext())
            {
              paramLinkedList = ((Iterator)localObject6).next();
              bool = Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)paramLinkedList).sessionId, ((bdm)localObject3).session_id);
              if (!bool) {
                continue;
              }
              ??? = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)paramLinkedList;
              if (??? != null)
              {
                paramLinkedList = com.tencent.mm.live.model.p.mZf;
                localObject6 = com.tencent.mm.live.model.p.bhS();
                if (localObject6 != null)
                {
                  l = ((f)business(f.class)).liveInfo.liveId;
                  paramLinkedList = ((bdm)localObject3).ZOb;
                  if (paramLinkedList != null) {
                    break label793;
                  }
                  paramLinkedList = null;
                  ((g)localObject6).onCloseLiveMic(new com.tencent.mm.live.model.f(l, paramLinkedList, ((bdm)localObject3).session_id, ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???).mXL, ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???).mXM));
                }
                this.Efy = 0;
                paramLinkedList = this.Efw;
                s.s(paramLinkedList, "audienceLinkMicUserList");
                d.a(paramLinkedList, (kotlin.g.a.b)new d((bdm)localObject3));
                Log.i("MMFinder.LiveLinkMicSlice", "anchor receive close msg, [sdkUserId:" + ((bdz)localObject4).ZlX + "] closeUser:" + ???);
              }
              paramLinkedList = this.Eft;
              s.s(paramLinkedList, "linkMicUserList");
              kotlin.a.p.e(paramLinkedList, (kotlin.g.a.b)new e((bdm)localObject3));
              paramLinkedList = this.Efu;
              s.s(paramLinkedList, "newLinkMicUserList");
              kotlin.a.p.e(paramLinkedList, (kotlin.g.a.b)new f((bdm)localObject3));
              paramLinkedList = this.Efx;
              s.s(paramLinkedList, "linkMicUserInfoList");
              d.a(paramLinkedList, (kotlin.g.a.b)new g((bdm)localObject3));
              break;
              paramLinkedList = paramLinkedList.toByteArray();
              continue;
              paramLinkedList = paramLinkedList;
              Log.printDebugStack("safeParser", "", new Object[] { paramLinkedList });
              continue;
            }
            paramLinkedList = null;
          }
        }
        label793:
        paramLinkedList = paramLinkedList.contact;
        if (paramLinkedList == null) {
          paramLinkedList = null;
        } else {
          paramLinkedList = paramLinkedList.username;
        }
      }
      label815:
      paramLinkedList = this.Efw;
      s.s(paramLinkedList, "audienceLinkMicUserList");
      label1193:
      label1215:
      do
      {
        do
        {
          for (;;)
          {
            synchronized ((Iterable)paramLinkedList)
            {
              Iterator localIterator = ((Iterable)???).iterator();
              if (localIterator.hasNext())
              {
                paramLinkedList = localIterator.next();
                bool = Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)paramLinkedList).sessionId, ((bdm)localObject3).session_id);
                if (!bool) {
                  continue;
                }
                ??? = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)paramLinkedList;
                if (??? == null) {
                  break label1215;
                }
                paramLinkedList = com.tencent.mm.live.model.p.mZf;
                localObject6 = com.tencent.mm.live.model.p.bhS();
                if (localObject6 != null)
                {
                  l = ((f)business(f.class)).liveInfo.liveId;
                  paramLinkedList = ((bdm)localObject3).ZOb;
                  if (paramLinkedList != null) {
                    break label1193;
                  }
                  paramLinkedList = null;
                  ((g)localObject6).onCloseLiveMic(new com.tencent.mm.live.model.f(l, paramLinkedList, ((bdm)localObject3).session_id, ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???).mXL, ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???).mXM));
                }
                paramLinkedList = this.Efx;
                s.s(paramLinkedList, "linkMicUserInfoList");
                d.a(paramLinkedList, (kotlin.g.a.b)new h((bdm)localObject3));
                if (Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???).mXL, ((e)business(e.class)).eyF())) {
                  this.Efy = 0;
                }
                paramLinkedList = business(e.class);
                s.checkNotNull(paramLinkedList);
                if (Util.isEqual(((e)paramLinkedList).eyF(), ((bdz)localObject4).ZlX))
                {
                  ((com.tencent.mm.plugin.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.k.class)).bUK();
                  ((com.tencent.mm.plugin.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.k.class)).bUL();
                }
                paramLinkedList = new StringBuilder("visitor receive close msg, [sdkUserId:").append(((bdz)localObject4).ZlX).append("], selfSdkUserId:");
                localObject3 = business(e.class);
                s.checkNotNull(localObject3);
                Log.i("MMFinder.LiveLinkMicSlice", ((e)localObject3).eyF() + ", closeUser:" + ??? + ", linkMicState:" + this.Efy);
                break;
              }
              paramLinkedList = null;
            }
            paramLinkedList = paramLinkedList.contact;
            if (paramLinkedList == null) {
              paramLinkedList = null;
            } else {
              paramLinkedList = paramLinkedList.username;
            }
          }
        } while (((!((j)business(j.class)).eza()) && (!((j)business(j.class)).ezb())) || (!Util.isEqual(((e)business(e.class)).eyF(), ((bdz)localObject4).ZlX)) || (!Util.isEqual(((j)business(j.class)).Efs, (String)localObject6)));
        if ((this.Efy != 1) && (this.Efy != 3)) {
          break label1382;
        }
        i = 1;
        paramLinkedList = com.tencent.mm.live.model.p.mZf;
        localObject6 = com.tencent.mm.live.model.p.bhS();
      } while (localObject6 == null);
      label1307:
      long l = ((f)business(f.class)).liveInfo.liveId;
      paramLinkedList = ((bdm)localObject3).ZOb;
      if (paramLinkedList == null) {
        paramLinkedList = null;
      }
      for (;;)
      {
        ((g)localObject6).onCloseLiveMic(new com.tencent.mm.live.model.f(l, paramLinkedList, ((bdm)localObject3).session_id, ((bdz)localObject4).ZlX, i));
        break;
        label1382:
        i = 2;
        break label1307;
        paramLinkedList = paramLinkedList.contact;
        if (paramLinkedList == null) {
          paramLinkedList = null;
        } else {
          paramLinkedList = paramLinkedList.username;
        }
      }
    }
    Log.i("MMFinder.LiveLinkMicSlice", "closeMicMsgList:" + ((List)localObject1).size() + " isAnchor:" + ((com.tencent.mm.plugin.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.k.class)).bUB());
    AppMethodBeat.o(357117);
  }
  
  public final void aF(LinkedList<bdm> paramLinkedList)
  {
    AppMethodBeat.i(357141);
    Object localObject1 = new LinkedList();
    Object localObject2 = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      localObject4 = (bdm)localObject3;
      if (kotlin.a.k.contains(this.EfS, ((bdm)localObject4).msg_type)) {
        paramLinkedList.add(localObject3);
      }
    }
    ((LinkedList)localObject1).addAll((Collection)paramLinkedList);
    paramLinkedList = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = paramLinkedList.iterator();
    label167:
    label218:
    label221:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      paramLinkedList = ((bdm)localObject3).ZOb;
      if (paramLinkedList == null)
      {
        paramLinkedList = null;
        if (Util.isEqual(paramLinkedList, z.bAW())) {
          break label218;
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label221;
        }
        ((Collection)localObject1).add(localObject3);
        break;
        paramLinkedList = paramLinkedList.contact;
        if (paramLinkedList == null)
        {
          paramLinkedList = null;
          break label167;
        }
        paramLinkedList = paramLinkedList.username;
        break label167;
      }
    }
    localObject1 = (List)localObject1;
    if (((com.tencent.mm.plugin.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.k.class)).bUB())
    {
      localObject2 = ((Iterable)localObject1).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (bdm)((Iterator)localObject2).next();
          localObject4 = new bea();
          Object localObject5 = (com.tencent.mm.bx.a)localObject4;
          paramLinkedList = ((bdm)localObject3).ZNY;
          if (paramLinkedList == null) {
            paramLinkedList = null;
          }
          try
          {
            for (;;)
            {
              ((com.tencent.mm.bx.a)localObject5).parseFrom(paramLinkedList);
              localObject5 = ((bdm)localObject3).session_id;
              if (localObject5 != null)
              {
                ((Map)this.EfG).put(localObject5, Integer.valueOf(3));
                paramLinkedList = this.Efv;
                if (paramLinkedList != null) {
                  break label669;
                }
                paramLinkedList = null;
                if (Util.isEqual((String)localObject5, paramLinkedList))
                {
                  ((com.tencent.mm.plugin.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.k.class)).bUN();
                  paramLinkedList = com.tencent.mm.live.model.p.mZf;
                  localObject5 = com.tencent.mm.live.model.p.bhS();
                  if (localObject5 != null)
                  {
                    long l = ((f)business(f.class)).liveInfo.liveId;
                    paramLinkedList = ((bdm)localObject3).ZOb;
                    if (paramLinkedList != null) {
                      break label677;
                    }
                    paramLinkedList = null;
                    ((g)localObject5).onCloseLiveMic(new com.tencent.mm.live.model.f(l, paramLinkedList, ((bdm)localObject3).session_id));
                  }
                  ((com.tencent.mm.plugin.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.k.class)).bUQ();
                  this.Efy = 0;
                  this.Efv = null;
                  b.a.bfv().FT(null);
                  ezc();
                  Log.i("MMFinder.LiveLinkMicSlice", "[LinkMicPk]  anchor receive close pk msg, [sdkUserId:" + ((bea)localObject4).ZlX + ']');
                }
                paramLinkedList = this.Eft;
                s.s(paramLinkedList, "linkMicUserList");
                kotlin.a.p.e(paramLinkedList, (kotlin.g.a.b)new i((bdm)localObject3));
                paramLinkedList = this.Efu;
                s.s(paramLinkedList, "newLinkMicUserList");
                kotlin.a.p.e(paramLinkedList, (kotlin.g.a.b)new j((bdm)localObject3));
              }
              Log.i("MMFinder.LiveLinkMicSlice", "[LinkMicPk]  receive close pk msg, [sdkUserId:" + ((bea)localObject4).ZlX + ", sessionId:" + ((bdm)localObject3).session_id + "], curLiveUser:" + this.Efv + ", applySessionId:" + this.Efs);
              break;
              paramLinkedList = paramLinkedList.toByteArray();
            }
          }
          catch (Exception paramLinkedList)
          {
            for (;;)
            {
              Log.printDebugStack("safeParser", "", new Object[] { paramLinkedList });
              continue;
              label669:
              paramLinkedList = paramLinkedList.sessionId;
              continue;
              label677:
              paramLinkedList = paramLinkedList.contact;
              if (paramLinkedList == null) {
                paramLinkedList = null;
              } else {
                paramLinkedList = paramLinkedList.username;
              }
            }
          }
        }
      }
    }
    Log.i("MMFinder.LiveLinkMicSlice", "[LinkMicPk]  checkLinkClosePkMsg:" + ((List)localObject1).size() + " isAnchor:" + ((com.tencent.mm.plugin.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.k.class)).bUB());
    AppMethodBeat.o(357141);
  }
  
  public final void aG(LinkedList<bdm> paramLinkedList)
  {
    AppMethodBeat.i(357194);
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      localObject3 = (bdm)localObject2;
      if (kotlin.a.k.contains(this.EfT, ((bdm)localObject3).msg_type)) {
        paramLinkedList.add(localObject2);
      }
    }
    localLinkedList.addAll((Collection)paramLinkedList);
    Iterator localIterator = ((Iterable)localLinkedList).iterator();
    label119:
    if (localIterator.hasNext())
    {
      bdm localbdm = (bdm)localIterator.next();
      beo localbeo = new beo();
      localObject1 = (com.tencent.mm.bx.a)localbeo;
      paramLinkedList = localbdm.ZNY;
      if (paramLinkedList == null) {
        paramLinkedList = null;
      }
      label634:
      label890:
      label1148:
      long l;
      label1402:
      label1533:
      do
      {
        try
        {
          for (;;)
          {
            ((com.tencent.mm.bx.a)localObject1).parseFrom(paramLinkedList);
            localObject1 = new StringBuilder("[LinkMicPk] visitor receive pkStatusMsg: [pkStatusScene:").append(localbeo.scene).append(" pkStatusSeq:").append(localbeo.seq).append(" pkStatusPkUser:");
            paramLinkedList = localbeo.ZOh;
            if (paramLinkedList != null) {
              break label324;
            }
            paramLinkedList = null;
            Log.i("MMFinder.LiveLinkMicSlice", paramLinkedList + ']');
            switch (localbeo.scene)
            {
            default: 
              paramLinkedList = ah.aiuX;
              paramLinkedList = ah.aiuX;
              break label119;
              paramLinkedList = paramLinkedList.toByteArray();
            }
          }
        }
        catch (Exception paramLinkedList)
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  for (;;)
                  {
                    Log.printDebugStack("safeParser", "", new Object[] { paramLinkedList });
                    continue;
                    paramLinkedList = paramLinkedList.contact;
                    if (paramLinkedList == null) {
                      paramLinkedList = null;
                    } else {
                      paramLinkedList = paramLinkedList.nickname;
                    }
                  }
                  localObject1 = new StringBuilder("[LinkMicPk] receive apply pk status msg:[session_id:").append(localbdm.session_id).append(", pkAnchorNickname:");
                  paramLinkedList = localbeo.ZOh;
                  if (paramLinkedList != null) {
                    break;
                  }
                  paramLinkedList = null;
                  Log.i("MMFinder.LiveLinkMicSlice", paramLinkedList + ", userSdkId:" + localbeo.ZlX + ", isAnchor:" + ((com.tencent.mm.plugin.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.k.class)).bUB() + ']');
                } while (((com.tencent.mm.plugin.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.k.class)).bUB());
                localObject3 = localbdm.session_id;
              } while (localObject3 == null);
              if (this.EfG.get(localObject3) != null) {
                Log.i("MMFinder.LiveLinkMicSlice", s.X("[LinkMicPk] skip apply pk status msg, invalid apply msg. curMicStatus:", this.EfG.get(localObject3)));
              }
              for (;;)
              {
                paramLinkedList = ah.aiuX;
                paramLinkedList = ah.aiuX;
                break;
                paramLinkedList = paramLinkedList.contact;
                if (paramLinkedList == null)
                {
                  paramLinkedList = null;
                  break label384;
                }
                paramLinkedList = paramLinkedList.nickname;
                break label384;
                if (localbeo.seq >= this.Efr) {
                  break label603;
                }
                Log.i("MMFinder.LiveLinkMicSlice", "[LinkMicPk] skip apply pk status msg, mic too old. sessionId:" + (String)localObject3 + " curMsgSeq:" + localbeo.seq + " acceptedSeq:" + this.Efr);
              }
              ((Map)this.EfG).put(localObject3, Integer.valueOf(0));
              paramLinkedList = localbeo.ZOh;
              if (paramLinkedList == null)
              {
                paramLinkedList = null;
                localObject1 = localbeo.ZOh;
                if (localObject1 != null) {
                  break label707;
                }
                localObject1 = null;
                localObject2 = localbeo.ZOh;
                if (localObject2 != null) {
                  break label735;
                }
                localObject2 = null;
              }
              for (;;)
              {
                this.EfF = new com.tencent.mm.plugin.finder.live.viewmodel.data.b((String)localObject3, paramLinkedList, (String)localObject1, (String)localObject2);
                break;
                paramLinkedList = paramLinkedList.contact;
                if (paramLinkedList == null)
                {
                  paramLinkedList = null;
                  break label634;
                }
                paramLinkedList = paramLinkedList.username;
                break label634;
                localObject1 = ((bgh)localObject1).contact;
                if (localObject1 == null)
                {
                  localObject1 = null;
                  break label649;
                }
                localObject1 = ((FinderContact)localObject1).nickname;
                break label649;
                localObject2 = ((bgh)localObject2).contact;
                if (localObject2 == null) {
                  localObject2 = null;
                } else {
                  localObject2 = ((FinderContact)localObject2).headUrl;
                }
              }
              localObject1 = new StringBuilder("[LinkMicPk] receive accept pk status msg:[session_id:").append(localbdm.session_id).append(", pkAnchorNickname:");
              paramLinkedList = localbeo.ZOh;
              if (paramLinkedList != null) {
                break;
              }
              paramLinkedList = null;
              localObject1 = ((StringBuilder)localObject1).append(paramLinkedList).append(", userSdkId:").append(localbeo.ZlX).append(", isAnchor:").append(((com.tencent.mm.plugin.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.k.class)).bUB()).append(", bgUrl:");
              paramLinkedList = localbeo.ZOh;
              if (paramLinkedList != null) {
                break label1358;
              }
              paramLinkedList = null;
              localObject1 = ((StringBuilder)localObject1).append(paramLinkedList).append(", audience_mic_list size:");
              paramLinkedList = localbeo.ZOW;
              if (paramLinkedList != null) {
                break label1366;
              }
              paramLinkedList = null;
              Log.i("MMFinder.LiveLinkMicSlice", paramLinkedList + ']');
              paramLinkedList = localbdm.session_id;
            } while (paramLinkedList == null);
            localObject1 = (Integer)this.EfG.get(paramLinkedList);
            Object localObject4;
            if (localObject1 == null)
            {
              if (localbeo.seq < this.Efr)
              {
                if (!this.EfM) {
                  break label1402;
                }
                Log.i("MMFinder.LiveLinkMicSlice", "[LinkMicPk] RoomPk is true, accept pk status msg, ignore mic too old. sessionId:" + paramLinkedList + " curMsgSeq:" + localbeo.seq + " acceptedSeq:" + this.Efr);
              }
              if (!((com.tencent.mm.plugin.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.k.class)).bUB())
              {
                this.EfF = null;
                ((Map)this.EfG).put(paramLinkedList, Integer.valueOf(2));
                this.Efr = localbeo.seq;
                this.Efy = 4;
                String str1 = localbeo.ZlX;
                paramLinkedList = localbeo.ZOh;
                if (paramLinkedList != null) {
                  break label1455;
                }
                paramLinkedList = null;
                localObject1 = localbeo.ZOh;
                if (localObject1 != null) {
                  break label1477;
                }
                localObject1 = null;
                localObject2 = localbeo.ZOh;
                if (localObject2 != null) {
                  break label1505;
                }
                localObject2 = null;
                String str2 = localbdm.session_id;
                localObject3 = localbeo.ZOh;
                if (localObject3 != null) {
                  break label1533;
                }
                localObject3 = null;
                localObject4 = localbeo.ZOh;
                if (localObject4 != null) {
                  break label1561;
                }
                localObject4 = null;
                h(new com.tencent.mm.plugin.finder.live.viewmodel.data.h(str1, paramLinkedList, (String)localObject1, (String)localObject2, 2, str2, null, true, 0, (FinderAuthInfo)localObject3, null, 0, 0, false, (String)localObject4, 0L, localbeo.ZOh, false, 900096));
              }
              localObject1 = (List)localbeo.ZOW;
              paramLinkedList = this.Efv;
              if (paramLinkedList != null) {
                break label1571;
              }
            }
            for (paramLinkedList = null;; paramLinkedList = paramLinkedList.sessionId)
            {
              o((List)localObject1, paramLinkedList);
              paramLinkedList = com.tencent.mm.live.model.p.mZf;
              paramLinkedList = com.tencent.mm.live.model.p.bhS();
              if (paramLinkedList != null)
              {
                l = ((f)business(f.class)).liveInfo.liveId;
                localObject1 = localbdm.session_id;
                localObject2 = business(e.class);
                s.checkNotNull(localObject2);
                paramLinkedList.onAcceptLiveMic(new com.tencent.mm.live.model.a(l, (String)localObject1, "", ((e)localObject2).eyH(), 0, 0, "", "", 0L, null, Integer.valueOf(2), localbeo.seq, "", true, 16384));
                paramLinkedList = ah.aiuX;
              }
              for (;;)
              {
                paramLinkedList = ah.aiuX;
                paramLinkedList = ah.aiuX;
                break;
                paramLinkedList = paramLinkedList.contact;
                if (paramLinkedList == null)
                {
                  paramLinkedList = null;
                  break label801;
                }
                paramLinkedList = paramLinkedList.nickname;
                break label801;
                paramLinkedList = paramLinkedList.ZOx;
                break label864;
                paramLinkedList = Integer.valueOf(paramLinkedList.size());
                break label890;
                if (((Integer)localObject1).intValue() != 3) {
                  break label938;
                }
                Log.i("MMFinder.LiveLinkMicSlice", s.X("[LinkMicPk] skip accept pk status msg, mic closed. sessionId:", paramLinkedList));
                continue;
                Log.i("MMFinder.LiveLinkMicSlice", "[LinkMicPk] skip accept pk status msg, mic too old. sessionId:" + paramLinkedList + " curMsgSeq:" + localbeo.seq + " acceptedSeq:" + this.Efr);
              }
              paramLinkedList = paramLinkedList.contact;
              if (paramLinkedList == null)
              {
                paramLinkedList = null;
                break label1081;
              }
              paramLinkedList = paramLinkedList.headUrl;
              break label1081;
              localObject1 = ((bgh)localObject1).contact;
              if (localObject1 == null)
              {
                localObject1 = null;
                break label1096;
              }
              localObject1 = ((FinderContact)localObject1).username;
              break label1096;
              localObject2 = ((bgh)localObject2).contact;
              if (localObject2 == null)
              {
                localObject2 = null;
                break label1111;
              }
              localObject2 = ((FinderContact)localObject2).nickname;
              break label1111;
              localObject3 = ((bgh)localObject3).contact;
              if (localObject3 == null)
              {
                localObject3 = null;
                break label1133;
              }
              localObject3 = ((FinderContact)localObject3).authInfo;
              break label1133;
              localObject4 = ((bgh)localObject4).ZOx;
              break label1148;
            }
            localObject1 = new StringBuilder("[LinkMicPk] receive close pk status msg:[session_id:").append(localbdm.session_id).append(", pkAnchorNickname:");
            paramLinkedList = localbeo.ZOh;
            if (paramLinkedList != null) {
              break;
            }
            paramLinkedList = null;
            Log.i("MMFinder.LiveLinkMicSlice", paramLinkedList + ", userSdkId:" + localbeo.ZlX + ", isAnchor:" + ((com.tencent.mm.plugin.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.k.class)).bUB() + ']');
          } while (((com.tencent.mm.plugin.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.k.class)).bUB());
          localObject1 = localbdm.session_id;
          int i;
          if (localObject1 != null)
          {
            ((Map)this.EfG).put(localObject1, Integer.valueOf(3));
            this.EfF = null;
            paramLinkedList = business(j.class);
            s.checkNotNull(paramLinkedList);
            if (!((j)paramLinkedList).ezb()) {
              break label1960;
            }
            paramLinkedList = this.Efv;
            if ((paramLinkedList == null) || (paramLinkedList.EbD != true)) {
              break label1925;
            }
            i = 1;
            if (i == 0) {
              break label1960;
            }
            paramLinkedList = this.Efv;
            if (paramLinkedList != null) {
              break label1930;
            }
            paramLinkedList = null;
            if (!Util.isEqual(paramLinkedList, localbdm.session_id)) {
              break label1960;
            }
            paramLinkedList = com.tencent.mm.live.model.p.mZf;
            localObject2 = com.tencent.mm.live.model.p.bhS();
            if (localObject2 != null)
            {
              l = ((f)business(f.class)).liveInfo.liveId;
              paramLinkedList = localbeo.ZOh;
              if (paramLinkedList != null) {
                break label1938;
              }
              paramLinkedList = null;
            }
          }
          for (;;)
          {
            ((g)localObject2).onCloseLiveMic(new com.tencent.mm.live.model.f(l, paramLinkedList, localbdm.session_id));
            paramLinkedList = ah.aiuX;
            this.Efy = 0;
            paramLinkedList = this.Efx;
            s.s(paramLinkedList, "linkMicUserInfoList");
            d.a(paramLinkedList, (kotlin.g.a.b)new k((String)localObject1));
            paramLinkedList = ah.aiuX;
            break;
            paramLinkedList = paramLinkedList.contact;
            if (paramLinkedList == null)
            {
              paramLinkedList = null;
              break label1617;
            }
            paramLinkedList = paramLinkedList.nickname;
            break label1617;
            i = 0;
            break label1767;
            paramLinkedList = paramLinkedList.sessionId;
            break label1782;
            paramLinkedList = paramLinkedList.contact;
            if (paramLinkedList == null) {
              paramLinkedList = null;
            } else {
              paramLinkedList = paramLinkedList.username;
            }
          }
          paramLinkedList = new StringBuilder("[LinkMicPk] invalid params: [isLinking:");
          localObject1 = business(j.class);
          s.checkNotNull(localObject1);
          localObject1 = paramLinkedList.append(((j)localObject1).ezb()).append(" isPkWithAnchor:");
          paramLinkedList = this.Efv;
          if (paramLinkedList == null)
          {
            paramLinkedList = null;
            localObject1 = ((StringBuilder)localObject1).append(paramLinkedList).append(" curSessionId:");
            paramLinkedList = this.Efv;
            if (paramLinkedList != null) {
              break label2092;
            }
          }
          for (paramLinkedList = null;; paramLinkedList = paramLinkedList.sessionId)
          {
            Log.i("MMFinder.LiveLinkMicSlice", paramLinkedList + " msgSessionId:" + localbdm.session_id + ']');
            paramLinkedList = ah.aiuX;
            break;
            paramLinkedList = Boolean.valueOf(paramLinkedList.EbD);
            break label2015;
          }
          localObject1 = new StringBuilder("[LinkMicPk] receive CrossRoomAudienceAccept pk status msg:[session_id:").append(localbdm.session_id).append(", pkAnchorNickname:");
          paramLinkedList = localbeo.ZOh;
          if (paramLinkedList != null) {
            break label2421;
          }
        }
        paramLinkedList = null;
        localObject1 = ((StringBuilder)localObject1).append(paramLinkedList).append(", userSdkId:").append(localbeo.ZlX).append(", isAnchor:").append(((com.tencent.mm.plugin.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.k.class)).bUB()).append(", bgUrl:");
        paramLinkedList = localbeo.ZOh;
        if (paramLinkedList != null) {
          break label2443;
        }
        paramLinkedList = null;
        localObject1 = ((StringBuilder)localObject1).append(paramLinkedList).append(", audience_mic_list size:");
        paramLinkedList = localbeo.ZOW;
        if (paramLinkedList != null) {
          break label2451;
        }
        paramLinkedList = null;
        Log.i("MMFinder.LiveLinkMicSlice", paramLinkedList + ']');
        paramLinkedList = localbdm.session_id;
      } while (paramLinkedList == null);
      localObject1 = (Integer)this.EfG.get(paramLinkedList);
      if (localObject1 == null)
      {
        localObject1 = (List)localbeo.ZOW;
        paramLinkedList = this.Efv;
        if (paramLinkedList != null) {
          break label2487;
        }
      }
      for (paramLinkedList = null;; paramLinkedList = paramLinkedList.sessionId)
      {
        o((List)localObject1, paramLinkedList);
        paramLinkedList = com.tencent.mm.live.model.p.mZf;
        paramLinkedList = com.tencent.mm.live.model.p.bhS();
        if (paramLinkedList != null)
        {
          l = ((f)business(f.class)).liveInfo.liveId;
          localObject1 = localbdm.session_id;
          localObject2 = business(e.class);
          s.checkNotNull(localObject2);
          paramLinkedList.onAcceptLiveMic(new com.tencent.mm.live.model.a(l, (String)localObject1, "", ((e)localObject2).eyH(), 0, 0, "", "", 0L, null, Integer.valueOf(2), localbeo.seq, "", true, 16384));
          paramLinkedList = ah.aiuX;
        }
        for (;;)
        {
          paramLinkedList = ah.aiuX;
          paramLinkedList = ah.aiuX;
          break;
          paramLinkedList = paramLinkedList.contact;
          if (paramLinkedList == null)
          {
            paramLinkedList = null;
            break label2138;
          }
          paramLinkedList = paramLinkedList.nickname;
          break label2138;
          paramLinkedList = paramLinkedList.ZOx;
          break label2201;
          paramLinkedList = Integer.valueOf(paramLinkedList.size());
          break label2227;
          if (((Integer)localObject1).intValue() != 3) {
            break label2275;
          }
          Log.i("MMFinder.LiveLinkMicSlice", s.X("[LinkMicPk] skip accept pk status msg, mic closed. sessionId:", paramLinkedList));
        }
      }
    }
    label324:
    label603:
    label735:
    label864:
    label1133:
    label1782:
    Log.i("MMFinder.LiveLinkMicSlice", "[LinkMicPk] checkPkStatusMsg:" + localLinkedList.size() + " isAnchor:" + ((com.tencent.mm.plugin.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.k.class)).bUB());
    label384:
    label649:
    label707:
    label1096:
    label1111:
    label1505:
    label1767:
    label2421:
    AppMethodBeat.o(357194);
    label801:
    label938:
    label1081:
    label1358:
    label1366:
    label2015:
    label2275:
    return;
  }
  
  public final void aH(LinkedList<bdm> paramLinkedList)
  {
    Object localObject1 = null;
    AppMethodBeat.i(357214);
    label452:
    if (((com.tencent.mm.plugin.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.k.class)).bUB())
    {
      Object localObject2 = new LinkedList();
      Object localObject3 = (Iterable)paramLinkedList;
      paramLinkedList = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      Object localObject4;
      Object localObject5;
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = ((Iterator)localObject3).next();
        localObject5 = (bdm)localObject4;
        if (kotlin.a.k.contains(this.EfV, ((bdm)localObject5).msg_type)) {
          paramLinkedList.add(localObject4);
        }
      }
      ((LinkedList)localObject2).addAll((Collection)paramLinkedList);
      localObject3 = ((Iterable)localObject2).iterator();
      label346:
      label474:
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (bdm)((Iterator)localObject3).next();
        localObject2 = (com.tencent.mm.bx.a)new bdr();
        paramLinkedList = ((bdm)localObject4).ZNY;
        if (paramLinkedList == null) {}
        for (paramLinkedList = null;; paramLinkedList = paramLinkedList.toByteArray())
        {
          try
          {
            ((com.tencent.mm.bx.a)localObject2).parseFrom(paramLinkedList);
            paramLinkedList = (LinkedList<bdm>)localObject2;
          }
          catch (Exception paramLinkedList)
          {
            for (;;)
            {
              Log.printDebugStack("safeParser", "", new Object[] { paramLinkedList });
              paramLinkedList = null;
              continue;
              paramLinkedList = ((bdr)localObject2).ZOt;
              continue;
              paramLinkedList = Long.valueOf(((bdr)localObject2).ZOv);
            }
            paramLinkedList = ((bdm)localObject4).ZOb;
            if (paramLinkedList != null) {
              break label452;
            }
            paramLinkedList = null;
            if (Util.isEqual(paramLinkedList, ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject5).username)) {
              break label497;
            }
            localObject2 = new StringBuilder("[Battle] receive battleApplyMsg skip. invalid username from:");
            paramLinkedList = ((bdm)localObject4).ZOb;
            if (paramLinkedList != null) {
              break label474;
            }
            paramLinkedList = localObject1;
            for (;;)
            {
              Log.w("MMFinder.LiveLinkMicSlice", paramLinkedList + " pkUser:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject5).username);
              AppMethodBeat.o(357214);
              return;
              paramLinkedList = paramLinkedList.contact;
              if (paramLinkedList == null)
              {
                paramLinkedList = null;
                break;
              }
              paramLinkedList = paramLinkedList.username;
              break;
              localObject3 = paramLinkedList.contact;
              paramLinkedList = localObject1;
              if (localObject3 != null) {
                paramLinkedList = ((FinderContact)localObject3).username;
              }
            }
            paramLinkedList = this.EfK;
            if (paramLinkedList != null) {
              break label534;
            }
            for (long l = 0L; l > ((bdr)localObject2).ZOv; l = paramLinkedList.CET)
            {
              Log.w("MMFinder.LiveLinkMicSlice", "[Battle] receive battleApplyMsg skip. invalid seq");
              AppMethodBeat.o(357214);
              return;
            }
            this.EfK = new i(((bdm)localObject4).session_id, ((bdr)localObject2).ZOv, 0, -1, 1, null, 32);
            paramLinkedList = com.tencent.mm.live.model.p.mZf;
            paramLinkedList = com.tencent.mm.live.model.p.bhS();
          }
          localObject2 = (bdr)paramLinkedList;
          localObject5 = new StringBuilder("[Battle] receive battleApplyMsg. sessionId:").append(((bdm)localObject4).session_id).append(" micId:");
          if (localObject2 != null) {
            break label346;
          }
          paramLinkedList = null;
          localObject5 = ((StringBuilder)localObject5).append(paramLinkedList).append(" battleSeq:");
          if (localObject2 != null) {
            break label355;
          }
          paramLinkedList = null;
          Log.i("MMFinder.LiveLinkMicSlice", paramLinkedList + " curPkUser:" + this.Efv);
          if (localObject2 == null) {
            break;
          }
          localObject5 = this.Efv;
          if (localObject5 != null) {
            break label367;
          }
          Log.w("MMFinder.LiveLinkMicSlice", "[Battle] receive battleApplyMsg skip. curPkUser is null");
          AppMethodBeat.o(357214);
          return;
        }
        label355:
        label367:
        label497:
        if (paramLinkedList != null) {
          paramLinkedList.onBattleApply();
        }
      }
    }
    label534:
    AppMethodBeat.o(357214);
  }
  
  public final void aI(LinkedList<bdm> paramLinkedList)
  {
    Object localObject1 = null;
    AppMethodBeat.i(357234);
    if (((com.tencent.mm.plugin.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.k.class)).bUB())
    {
      Object localObject2 = new LinkedList();
      Object localObject3 = (Iterable)paramLinkedList;
      paramLinkedList = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      Object localObject5;
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = ((Iterator)localObject3).next();
        localObject5 = (bdm)localObject4;
        if (kotlin.a.k.contains(this.EfW, ((bdm)localObject5).msg_type)) {
          paramLinkedList.add(localObject4);
        }
      }
      ((LinkedList)localObject2).addAll((Collection)paramLinkedList);
      Object localObject4 = ((Iterable)localObject2).iterator();
      label405:
      label424:
      label432:
      while (((Iterator)localObject4).hasNext())
      {
        localObject3 = (bdm)((Iterator)localObject4).next();
        localObject2 = (com.tencent.mm.bx.a)new bdy();
        paramLinkedList = ((bdm)localObject3).ZNY;
        if (paramLinkedList == null) {}
        for (paramLinkedList = null;; paramLinkedList = paramLinkedList.toByteArray())
        {
          try
          {
            ((com.tencent.mm.bx.a)localObject2).parseFrom(paramLinkedList);
            paramLinkedList = (LinkedList<bdm>)localObject2;
          }
          catch (Exception paramLinkedList)
          {
            for (;;)
            {
              Log.printDebugStack("safeParser", "", new Object[] { paramLinkedList });
              paramLinkedList = null;
              continue;
              paramLinkedList = Integer.valueOf(((bdy)localObject2).scene);
            }
            paramLinkedList = this.EfK;
            if (paramLinkedList != null) {
              break label405;
            }
            paramLinkedList = Integer.valueOf(0);
            if (s.p(paramLinkedList, ((bdm)localObject3).session_id)) {
              break label432;
            }
            localObject2 = new StringBuilder("[Battle] receive battleCloseMsg skip. invalid session_id curBattleId:");
            paramLinkedList = this.EfK;
            if (paramLinkedList != null) {
              break label424;
            }
            for (paramLinkedList = localObject1;; paramLinkedList = paramLinkedList.CES)
            {
              Log.w("MMFinder.LiveLinkMicSlice", paramLinkedList + " appMsg.sessionId:" + ((bdm)localObject3).session_id);
              AppMethodBeat.o(357234);
              return;
              localObject2 = paramLinkedList.CES;
              paramLinkedList = (LinkedList<bdm>)localObject2;
              if (localObject2 != null) {
                break;
              }
              paramLinkedList = Integer.valueOf(0);
              break;
            }
            this.EfK = null;
            paramLinkedList = com.tencent.mm.live.model.p.mZf;
            paramLinkedList = com.tencent.mm.live.model.p.bhS();
          }
          localObject2 = (bdy)paramLinkedList;
          localObject5 = new StringBuilder("[Battle] receive battleCloseMsg. sessionId:").append(((bdm)localObject3).session_id).append(" scene:");
          if (localObject2 != null) {
            break label311;
          }
          paramLinkedList = null;
          Log.i("MMFinder.LiveLinkMicSlice", paramLinkedList + " curPkUser:" + this.Efv);
          if (localObject2 == null) {
            break;
          }
          if (this.Efv != null) {
            break label322;
          }
          Log.w("MMFinder.LiveLinkMicSlice", "[Battle] receive battleCloseMsg skip. curPkUser is null");
          AppMethodBeat.o(357234);
          return;
        }
        label311:
        label322:
        if (paramLinkedList != null) {
          paramLinkedList.onBattleClose();
        }
      }
    }
    AppMethodBeat.o(357234);
  }
  
  public final void aJ(LinkedList<bdm> paramLinkedList)
  {
    AppMethodBeat.i(357252);
    Object localObject1 = new LinkedList();
    Object localObject2 = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      bdm localbdm = (bdm)localObject3;
      if (kotlin.a.k.contains(this.EfU, localbdm.msg_type)) {
        paramLinkedList.add(localObject3);
      }
    }
    ((LinkedList)localObject1).addAll((Collection)paramLinkedList);
    localObject2 = ((Iterable)localObject1).iterator();
    label527:
    label535:
    label543:
    label554:
    label565:
    label576:
    label587:
    label612:
    label620:
    label628:
    while (((Iterator)localObject2).hasNext())
    {
      paramLinkedList = (bdm)((Iterator)localObject2).next();
      localObject1 = (com.tencent.mm.bx.a)new bdv();
      paramLinkedList = paramLinkedList.ZNY;
      if (paramLinkedList == null) {}
      for (paramLinkedList = null;; paramLinkedList = paramLinkedList.toByteArray())
      {
        try
        {
          ((com.tencent.mm.bx.a)localObject1).parseFrom(paramLinkedList);
          paramLinkedList = (LinkedList<bdm>)localObject1;
        }
        catch (Exception paramLinkedList)
        {
          for (;;)
          {
            Log.printDebugStack("safeParser", "", new Object[] { paramLinkedList });
            paramLinkedList = null;
            continue;
            localObject1 = paramLinkedList.ZOA;
            continue;
            paramLinkedList = ((bfs)localObject1).ZPA;
            continue;
            paramLinkedList = Integer.valueOf(((bfs)localObject1).status);
            continue;
            paramLinkedList = Long.valueOf(((bfs)localObject1).ZOv);
            continue;
            paramLinkedList = Integer.valueOf(((bfs)localObject1).ZPB);
            continue;
            paramLinkedList = Integer.valueOf(((bfs)localObject1).result);
            continue;
            paramLinkedList = ((bfs)localObject1).ZPC;
            if (paramLinkedList == null)
            {
              paramLinkedList = null;
            }
            else
            {
              paramLinkedList = Integer.valueOf(paramLinkedList.size());
              continue;
              paramLinkedList = paramLinkedList.EfK;
              continue;
              paramLinkedList = ((bfs)localObject1).ZPC;
            }
          }
          b((bfs)localObject1);
        }
        paramLinkedList = (bdv)paramLinkedList;
        if (paramLinkedList != null) {
          break label527;
        }
        localObject1 = null;
        localObject3 = new StringBuilder("[Battle] receive battleStatusMsg. isAnchor:").append(((com.tencent.mm.plugin.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.k.class)).bUB()).append(" battleId:");
        if (localObject1 != null) {
          break label535;
        }
        paramLinkedList = null;
        localObject3 = ((StringBuilder)localObject3).append(paramLinkedList).append(" battleStatusScene:");
        if (localObject1 != null) {
          break label543;
        }
        paramLinkedList = null;
        localObject3 = ((StringBuilder)localObject3).append(paramLinkedList).append(" battleStatusSeq:");
        if (localObject1 != null) {
          break label554;
        }
        paramLinkedList = null;
        localObject3 = ((StringBuilder)localObject3).append(paramLinkedList).append(" battleLeftTime:");
        if (localObject1 != null) {
          break label565;
        }
        paramLinkedList = null;
        localObject3 = ((StringBuilder)localObject3).append(paramLinkedList).append(" battleResult:");
        if (localObject1 != null) {
          break label576;
        }
        paramLinkedList = null;
        localObject3 = ((StringBuilder)localObject3).append(paramLinkedList).append(" players.size:");
        if (localObject1 != null) {
          break label587;
        }
        paramLinkedList = null;
        localObject3 = ((StringBuilder)localObject3).append(paramLinkedList).append(" curLiveRoomData?.curLinkMicUser:").append(this.Efv).append(" curLiveRoomData?.curBattle:");
        paramLinkedList = (j)business(j.class);
        if (paramLinkedList != null) {
          break label612;
        }
        paramLinkedList = null;
        Log.i("MMFinder.LiveLinkMicSlice", paramLinkedList);
        localObject3 = (com.tencent.mm.plugin.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.k.class);
        if (localObject1 != null) {
          break label620;
        }
        paramLinkedList = null;
        ((com.tencent.mm.plugin.k)localObject3).v(paramLinkedList);
        if (localObject1 == null) {
          break;
        }
        Log.i("MMFinder.LiveLinkMicSlice", "[Battle] receive battle status msg:[battle_id:" + ((bfs)localObject1).ZPA + ", battle_seq" + ((bfs)localObject1).ZOv + ", battle_leftTime:" + ((bfs)localObject1).ZPB + " player_info.size:" + ((bfs)localObject1).ZPC.size() + ']');
        if (!((com.tencent.mm.plugin.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.k.class)).bUB()) {
          break label628;
        }
        a((bfs)localObject1);
        break;
      }
    }
    AppMethodBeat.o(357252);
  }
  
  public final LinkedList<bdm> aK(LinkedList<bdm> paramLinkedList)
  {
    AppMethodBeat.i(357307);
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      bdm localbdm = (bdm)localObject2;
      if (kotlin.a.k.contains(this.EfQ, localbdm.msg_type)) {
        paramLinkedList.add(localObject2);
      }
    }
    localLinkedList.addAll((Collection)paramLinkedList);
    AppMethodBeat.o(357307);
    return localLinkedList;
  }
  
  public final LinkedList<bdm> aL(LinkedList<bdm> paramLinkedList)
  {
    AppMethodBeat.i(357318);
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      bdm localbdm = (bdm)localObject2;
      if (kotlin.a.k.contains(this.EfX, localbdm.msg_type)) {
        paramLinkedList.add(localObject2);
      }
    }
    localLinkedList.addAll((Collection)paramLinkedList);
    AppMethodBeat.o(357318);
    return localLinkedList;
  }
  
  public final void ayq(String paramString)
  {
    AppMethodBeat.i(356965);
    s.u(paramString, "<set-?>");
    this.Efs = paramString;
    AppMethodBeat.o(356965);
  }
  
  public final boolean ayr(String paramString)
  {
    AppMethodBeat.i(357262);
    ??? = this.Efw;
    s.s(???, "audienceLinkMicUserList");
    Collection localCollection;
    synchronized ((Iterable)???)
    {
      localCollection = (Collection)new ArrayList();
      Iterator localIterator = ((Iterable)???).iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        if (Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject2).sessionId, paramString)) {
          localCollection.add(localObject2);
        }
      }
    }
    paramString = (List)localCollection;
    paramString = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)kotlin.a.p.oL(paramString);
    if ((paramString != null) && (paramString.EbE == 1))
    {
      i = 1;
      if (i == 0) {
        if ((paramString == null) || (paramString.EbE != 2)) {
          break label168;
        }
      }
    }
    label168:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label173;
      }
      AppMethodBeat.o(357262);
      return true;
      i = 0;
      break;
    }
    label173:
    AppMethodBeat.o(357262);
    return false;
  }
  
  public final com.tencent.mm.plugin.finder.live.viewmodel.data.h ays(String paramString)
  {
    AppMethodBeat.i(357271);
    ??? = this.Efw;
    s.s(???, "audienceLinkMicUserList");
    Collection localCollection;
    synchronized ((Iterable)???)
    {
      localCollection = (Collection)new ArrayList();
      Iterator localIterator = ((Iterable)???).iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        if (Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject2).sessionId, paramString)) {
          localCollection.add(localObject2);
        }
      }
    }
    paramString = (List)localCollection;
    paramString = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)kotlin.a.p.oL(paramString);
    AppMethodBeat.o(357271);
    return paramString;
  }
  
  public final com.tencent.mm.plugin.finder.live.viewmodel.data.h ayt(String paramString)
  {
    AppMethodBeat.i(357282);
    ??? = this.Efw;
    s.s(???, "audienceLinkMicUserList");
    Collection localCollection;
    synchronized ((Iterable)???)
    {
      localCollection = (Collection)new ArrayList();
      Iterator localIterator = ((Iterable)???).iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        if (Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject2).mXL, paramString)) {
          localCollection.add(localObject2);
        }
      }
    }
    paramString = (List)localCollection;
    paramString = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)kotlin.a.p.oL(paramString);
    AppMethodBeat.o(357282);
    return paramString;
  }
  
  public final com.tencent.mm.plugin.finder.live.viewmodel.data.h eyS()
  {
    return this.Efv;
  }
  
  public final List<com.tencent.mm.plugin.finder.live.viewmodel.data.h> eyT()
  {
    return this.Efw;
  }
  
  public final int eyU()
  {
    AppMethodBeat.i(357001);
    ??? = this.Efu;
    s.s(???, "newLinkMicUserList");
    for (;;)
    {
      synchronized ((Iterable)???)
      {
        Collection localCollection = (Collection)new ArrayList();
        Iterator localIterator = ((Iterable)???).iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        Object localObject3 = localIterator.next();
        if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject3).EbD)
        {
          i = 1;
          if (i == 0) {
            continue;
          }
          localCollection.add(localObject3);
        }
      }
      i = 0;
    }
    List localList = (List)localObject2;
    int i = localList.size();
    AppMethodBeat.o(357001);
    return i;
  }
  
  public final int eyV()
  {
    AppMethodBeat.i(357012);
    ??? = this.Efu;
    s.s(???, "newLinkMicUserList");
    synchronized ((Iterable)???)
    {
      Collection localCollection = (Collection)new ArrayList();
      Iterator localIterator = ((Iterable)???).iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = localIterator.next();
        if (((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject3).EbD) {
          localCollection.add(localObject3);
        }
      }
    }
    List localList = (List)localObject2;
    int i = localList.size();
    AppMethodBeat.o(357012);
    return i;
  }
  
  public final boolean eyW()
  {
    return this.EfB == 1;
  }
  
  public final boolean eyX()
  {
    AppMethodBeat.i(357034);
    ??? = this.Efw;
    s.s(???, "audienceLinkMicUserList");
    for (;;)
    {
      synchronized ((Iterable)???)
      {
        Collection localCollection = (Collection)new ArrayList();
        Iterator localIterator = ((Iterable)???).iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        Object localObject3 = localIterator.next();
        if (!s.p(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject3).EbK, Boolean.TRUE))
        {
          i = 1;
          if (i == 0) {
            continue;
          }
          localCollection.add(localObject3);
        }
      }
      int i = 0;
    }
    List localList = (List)localObject2;
    if (localList.size() >= 3)
    {
      AppMethodBeat.o(357034);
      return true;
    }
    AppMethodBeat.o(357034);
    return false;
  }
  
  public final int eyY()
  {
    AppMethodBeat.i(357049);
    Object localObject1 = this.Efw;
    s.s(localObject1, "audienceLinkMicUserList");
    Object localObject5;
    Object localObject6;
    int i;
    for (;;)
    {
      synchronized ((Iterable)localObject1)
      {
        localObject1 = (Collection)new ArrayList();
        localObject5 = ((Iterable)???).iterator();
        if (!((Iterator)localObject5).hasNext()) {
          break;
        }
        localObject6 = ((Iterator)localObject5).next();
        if (!s.p(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject6).EbK, Boolean.TRUE))
        {
          i = 1;
          if (i == 0) {
            continue;
          }
          ((Collection)localObject1).add(localObject6);
        }
      }
      i = 0;
    }
    List localList = (List)localObject2;
    ??? = this.Efx;
    s.s(???, "linkMicUserInfoList");
    for (;;)
    {
      synchronized ((Iterable)???)
      {
        localObject5 = (Collection)new ArrayList();
        localObject6 = ((Iterable)???).iterator();
        if (!((Iterator)localObject6).hasNext()) {
          break label274;
        }
        Object localObject7 = ((Iterator)localObject6).next();
        com.tencent.mm.plugin.finder.live.viewmodel.data.h localh = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject7;
        if (localh.EbE == 1) {
          break label353;
        }
        if (localh.EbE == 2)
        {
          break label353;
          if ((i == 0) || (localList.contains(localh))) {
            break label269;
          }
          i = 1;
          if (i == 0) {
            continue;
          }
          ((Collection)localObject5).add(localObject7);
        }
      }
      i = 0;
      continue;
      label269:
      i = 0;
      continue;
      label274:
      localObject5 = (List)localObject5;
      Log.i("MMFinder.LiveLinkMicSlice", "linkingAndWaitingAudienceSize: linkSize:" + localObject3.size() + ", waitSize:" + ((List)localObject5).size());
      i = localObject3.size();
      int j = ((List)localObject5).size();
      AppMethodBeat.o(357049);
      return i + j;
      label353:
      i = 1;
    }
  }
  
  public final i eyZ()
  {
    return this.EfK;
  }
  
  public final boolean eza()
  {
    AppMethodBeat.i(357293);
    if ((((j)business(j.class)).Efy == 1) || (((j)business(j.class)).Efy == 2) || (((j)business(j.class)).Efy == 5))
    {
      AppMethodBeat.o(357293);
      return true;
    }
    AppMethodBeat.o(357293);
    return false;
  }
  
  public final boolean ezb()
  {
    AppMethodBeat.i(357300);
    if ((((j)business(j.class)).Efy == 3) || (((j)business(j.class)).Efy == 4))
    {
      AppMethodBeat.o(357300);
      return true;
    }
    AppMethodBeat.o(357300);
    return false;
  }
  
  public final void ezc()
  {
    AppMethodBeat.i(357345);
    Log.i("MMFinder.LiveLinkMicSlice", "clearOtherRoomAudienceMicUser: before remove, size:" + this.Efw.size() + ", audienceLinkMicUserList:" + this.Efw);
    List localList = this.Efw;
    s.s(localList, "audienceLinkMicUserList");
    d.a(localList, (kotlin.g.a.b)l.Egd);
    Log.i("MMFinder.LiveLinkMicSlice", "clearOtherRoomAudienceMicUser: after remove, size:" + this.Efw.size() + ", audienceLinkMicUserList:" + this.Efw);
    AppMethodBeat.o(357345);
  }
  
  public final void h(com.tencent.mm.plugin.finder.live.viewmodel.data.h paramh)
  {
    AppMethodBeat.i(357323);
    List localList = this.Efx;
    s.s(localList, "linkMicUserInfoList");
    d.a(localList, (kotlin.g.a.b)new y(paramh));
    this.Efx.add(paramh);
    AppMethodBeat.o(357323);
  }
  
  public final void o(List<? extends bdu> paramList, String paramString)
  {
    AppMethodBeat.i(357335);
    int i;
    int j;
    Object localObject1;
    label70:
    Object localObject2;
    label85:
    Object localObject3;
    label100:
    Object localObject4;
    label128:
    label143:
    Object localObject5;
    if (paramList != null)
    {
      Iterator localIterator = ((Iterable)paramList).iterator();
      i = 0;
      j = i;
      if (!localIterator.hasNext()) {
        break label465;
      }
      bdu localbdu = (bdu)localIterator.next();
      String str1 = localbdu.ZlX;
      localObject1 = localbdu.ZOh;
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject2 = localbdu.ZOh;
        if (localObject2 != null) {
          break label348;
        }
        localObject2 = null;
        localObject3 = localbdu.ZOh;
        if (localObject3 != null) {
          break label376;
        }
        localObject3 = null;
        int k = localbdu.ZOf;
        String str2 = localbdu.YBM;
        localObject4 = this.Efv;
        if (localObject4 != null) {
          break label404;
        }
        j = 0;
        localObject4 = localbdu.ZOh;
        if (localObject4 != null) {
          break label414;
        }
        localObject4 = null;
        localObject5 = localbdu.ZOh;
        if (localObject5 != null) {
          break label442;
        }
        localObject5 = null;
        label158:
        localObject1 = new com.tencent.mm.plugin.finder.live.viewmodel.data.h(str1, (String)localObject1, (String)localObject2, (String)localObject3, k, str2, null, false, j, (FinderAuthInfo)localObject4, null, 0, 0, false, (String)localObject5, 0L, localbdu.ZOh, false, 900096);
        h((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject1);
        ((e)business(e.class)).g((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject1);
        Log.i("MMFinder.LiveLinkMicSlice", s.X("checkOtherRoomAudienceMicList: add micUser:", localObject1));
        if (!((com.tencent.mm.plugin.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.k.class)).bUB()) {
          break label561;
        }
        localObject3 = (com.tencent.mm.plugin.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.k.class);
        localObject2 = localbdu.ZlX;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = this.Efv;
        if (localObject2 != null) {
          break label452;
        }
        j = 0;
        label299:
        if (!((com.tencent.mm.plugin.k)localObject3).a((String)localObject1, j, false, paramString)) {
          break label561;
        }
        i = 1;
      }
    }
    label404:
    label414:
    label556:
    label561:
    for (;;)
    {
      break;
      localObject1 = ((bgh)localObject1).contact;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label70;
      }
      localObject1 = ((FinderContact)localObject1).headUrl;
      break label70;
      label348:
      localObject2 = ((bgh)localObject2).contact;
      if (localObject2 == null)
      {
        localObject2 = null;
        break label85;
      }
      localObject2 = ((FinderContact)localObject2).username;
      break label85;
      label376:
      localObject3 = ((bgh)localObject3).contact;
      if (localObject3 == null)
      {
        localObject3 = null;
        break label100;
      }
      localObject3 = ((FinderContact)localObject3).nickname;
      break label100;
      j = ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject4).mXz;
      break label128;
      localObject4 = ((bgh)localObject4).contact;
      if (localObject4 == null)
      {
        localObject4 = null;
        break label143;
      }
      localObject4 = ((FinderContact)localObject4).authInfo;
      break label143;
      label442:
      localObject5 = ((bgh)localObject5).ZOx;
      break label158;
      label452:
      j = ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject2).mXz;
      break label299;
      j = 0;
      label465:
      if (paramList != null) {
        if (!((Collection)paramList).isEmpty())
        {
          i = 1;
          if (i != 1) {
            break label556;
          }
        }
      }
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          this.EfM = true;
        }
        if ((((com.tencent.mm.plugin.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.k.class)).bUB()) && (j != 0))
        {
          paramList = ((com.tencent.mm.plugin.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.k.class)).bUF();
          if (paramList != null) {
            paramList.bfh();
          }
        }
        AppMethodBeat.o(357335);
        return;
        i = 0;
        break;
      }
    }
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(357073);
    this.Eft.clear();
    this.Efu.clear();
    this.Efv = null;
    b.a.bfv().FT(null);
    this.Efy = 0;
    this.Efz = 0;
    this.EfB = -1;
    this.EfC = false;
    this.EfD = false;
    this.EfE = true;
    this.Efs = "";
    this.Efr = 0L;
    this.EfA = 0;
    this.EfG.clear();
    this.EfF = null;
    this.EfH.clear();
    this.Cvf = new dom();
    this.EfJ = false;
    this.EfK = null;
    this.EfI = 0L;
    this.EfL = 0;
    this.Efx.clear();
    this.Efw.clear();
    this.EfM = false;
    AppMethodBeat.o(357073);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveLinkMicSlice$Companion;", "", "()V", "ROOM_PK_MAX_AUDIENCE_NUM", "", "TAG", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "pendingUser", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    public b(com.tencent.mm.plugin.finder.live.viewmodel.data.h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "errCode", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Integer, ah>
  {
    public c(com.tencent.mm.plugin.finder.live.model.context.a parama, String paramString, j paramj, bdo parambdo, com.tencent.mm.live.model.a parama1)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    d(bdm parambdm)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    e(bdm parambdm)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    f(bdm parambdm)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    g(bdm parambdm)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.g.b.u
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    h(bdm parambdm)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.g.b.u
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    i(bdm parambdm)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.g.b.u
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    j(bdm parambdm)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "info", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends kotlin.g.b.u
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    k(String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends kotlin.g.b.u
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    public static final l Egd;
    
    static
    {
      AppMethodBeat.i(356741);
      Egd = new l();
      AppMethodBeat.o(356741);
    }
    
    l()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "user", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class m
    extends kotlin.g.b.u
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    public m(bds parambds)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "user", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class n
    extends kotlin.g.b.u
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    public n(bds parambds)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "user", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class o
    extends kotlin.g.b.u
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    public static final o Egf;
    
    static
    {
      AppMethodBeat.i(356744);
      Egf = new o();
      AppMethodBeat.o(356744);
    }
    
    o()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "user", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class p
    extends kotlin.g.b.u
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    public static final p Egg;
    
    static
    {
      AppMethodBeat.i(356762);
      Egg = new p();
      AppMethodBeat.o(356762);
    }
    
    p()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "user", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class q
    extends kotlin.g.b.u
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    public static final q Egh;
    
    static
    {
      AppMethodBeat.i(356751);
      Egh = new q();
      AppMethodBeat.o(356751);
    }
    
    q()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "user", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class r
    extends kotlin.g.b.u
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    public static final r Egi;
    
    static
    {
      AppMethodBeat.i(356767);
      Egi = new r();
      AppMethodBeat.o(356767);
    }
    
    r()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "user", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class s
    extends kotlin.g.b.u
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    public static final s Egj;
    
    static
    {
      AppMethodBeat.i(356765);
      Egj = new s();
      AppMethodBeat.o(356765);
    }
    
    s()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "user", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class t
    extends kotlin.g.b.u
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    public static final t Egk;
    
    static
    {
      AppMethodBeat.i(356770);
      Egk = new t();
      AppMethodBeat.o(356770);
    }
    
    t()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "user", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class u
    extends kotlin.g.b.u
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    public u(bdt parambdt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "user", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class v
    extends kotlin.g.b.u
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    public v(bdt parambdt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class w
    extends kotlin.g.b.u
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    public w(String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class x
    extends kotlin.g.b.u
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    public x(String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class y
    extends kotlin.g.b.u
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    y(com.tencent.mm.plugin.finder.live.viewmodel.data.h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.business.j
 * JD-Core Version:    0.7.0.1
 */