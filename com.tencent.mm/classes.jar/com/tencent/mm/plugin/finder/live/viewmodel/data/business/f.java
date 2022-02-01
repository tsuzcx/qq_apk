package com.tencent.mm.plugin.finder.live.viewmodel.data.business;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.model.ak;
import com.tencent.mm.plugin.finder.live.util.r;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.protocal.protobuf.axh;
import com.tencent.mm.protocal.protobuf.axj;
import com.tencent.mm.protocal.protobuf.axk;
import com.tencent.mm.protocal.protobuf.axl;
import com.tencent.mm.protocal.protobuf.axm;
import com.tencent.mm.protocal.protobuf.axn;
import com.tencent.mm.protocal.protobuf.axo;
import com.tencent.mm.protocal.protobuf.axp;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.ayr;
import com.tencent.mm.protocal.protobuf.aza;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bbd;
import com.tencent.mm.protocal.protobuf.cxh;
import com.tencent.mm.protocal.protobuf.dlk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.x.a.a.a.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.axe;>;
import java.util.List;
import java.util.Map;
import kotlin.a.e;
import kotlin.a.j;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveLinkMicSlice;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/IBusiness;", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "liveContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "acceptMicMsg", "", "acceptMicPkMsg", "acceptSeq", "", "getAcceptSeq", "()J", "setAcceptSeq", "(J)V", "applyMicMsg", "applyMicPkMsg", "applySessionId", "", "getApplySessionId", "()Ljava/lang/String;", "setApplySessionId", "(Ljava/lang/String;)V", "audienceLinkMicUserList", "", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType", "", "getAudienceLinkMicUserList", "()Ljava/util/List;", "setAudienceLinkMicUserList", "(Ljava/util/List;)V", "audienceMicOverFlow", "", "getAudienceMicOverFlow", "()Z", "setAudienceMicOverFlow", "(Z)V", "battleApplyMsg", "battleCloseMsg", "battleStatusMsg", "closeMicMsg", "closeMicPkMsg", "curApplyPkAnchor", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/ApplyPkAnchorInfo;", "getCurApplyPkAnchor", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/ApplyPkAnchorInfo;", "setCurApplyPkAnchor", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/ApplyPkAnchorInfo;)V", "curBattle", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBattleData;", "getCurBattle", "()Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBattleData;", "setCurBattle", "(Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBattleData;)V", "curLinkMicUser", "getCurLinkMicUser", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "setCurLinkMicUser", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;)V", "enableBattleSwitch", "getEnableBattleSwitch", "setEnableBattleSwitch", "enableLinkMic", "getEnableLinkMic", "setEnableLinkMic", "enableLinkMicAntispam", "getEnableLinkMicAntispam", "setEnableLinkMicAntispam", "enableLinkMicFlag", "", "getEnableLinkMicFlag", "()I", "setEnableLinkMicFlag", "(I)V", "enableLinkMicSwitch", "getEnableLinkMicSwitch", "setEnableLinkMicSwitch", "linkMicState", "getLinkMicState", "setLinkMicState", "linkMicStatusMap", "Ljava/util/HashMap;", "getLinkMicStatusMap", "()Ljava/util/HashMap;", "linkMicUserList", "getLinkMicUserList", "setLinkMicUserList", "micSetting", "Lcom/tencent/mm/protocal/protobuf/MicSetting;", "getMicSetting", "()Lcom/tencent/mm/protocal/protobuf/MicSetting;", "setMicSetting", "(Lcom/tencent/mm/protocal/protobuf/MicSetting;)V", "newApplyCount", "getNewApplyCount", "setNewApplyCount", "newLinkMicUserList", "getNewLinkMicUserList", "setNewLinkMicUserList", "newPkApplyCount", "getNewPkApplyCount", "setNewPkApplyCount", "pendingNotifyMicUserList", "getPendingNotifyMicUserList", "pkStatusMsg", "appendLinkMicTip", "", "roomData", "appendMicSettingTip", "audienceMicLinking", "micId", "audienceMicWaiting", "checkBattleApplyMsg", "remoteLiveAppMsg", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "checkBattleCloseMsg", "checkBattleStatusForAnchor", "battleInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBattleInfo;", "appMsg", "checkBattleStatusForVisitor", "checkBattleStatusMsg", "checkLinkAcceptMsg", "liveData", "checkLinkAcceptPkMsg", "checkLinkCloseMsg", "checkLinkClosePkMsg", "checkLinkState", "checkPkStatusMsg", "filterAcceptLinkMicMsg", "appMsgList", "filterAcceptLinkMicPkMsg", "filterApplyLinkMicMsg", "filterApplyLinkMicPkMsg", "filterBattleApplyMsg", "filterBattleCloseMsg", "filterBattleStatusMsg", "filterCloseLinkMicMsg", "filterCloseLinkMicPkMsg", "filterPkStatusMsg", "getAudienceLinkMicUserByMicId", "getAudienceLinkMicUserByUserId", "userId", "handleLinkMicMsg", "handleLinkMicPkMsg", "linkMicWait", "linking", "onCleared", "removeAudienceLinkMicUser", "updateAnchorStatus", "anchorStatusFlag", "anchorStatus", "Lcom/tencent/mm/protocal/protobuf/LiveAnchorStatus;", "Companion", "plugin-finder-base_release"})
public final class f
  extends a<com.tencent.mm.plugin.finder.live.model.context.a>
{
  public static final a zhK;
  private final int[] zhA;
  public final int[] zhB;
  private final int[] zhC;
  private final int[] zhD;
  public final int[] zhE;
  private final int[] zhF;
  private final int[] zhG;
  private final int[] zhH;
  private final int[] zhI;
  private final int[] zhJ;
  public long zhh;
  public String zhi;
  public List<com.tencent.mm.plugin.finder.live.viewmodel.data.h> zhj;
  public List<com.tencent.mm.plugin.finder.live.viewmodel.data.h> zhk;
  public com.tencent.mm.plugin.finder.live.viewmodel.data.h zhl;
  public List<com.tencent.mm.plugin.finder.live.viewmodel.data.h> zhm;
  public int zhn;
  private int zho;
  private int zhp;
  public int zhq;
  private boolean zhr;
  public boolean zhs;
  public boolean zht;
  public com.tencent.mm.plugin.finder.live.viewmodel.data.b zhu;
  public final HashMap<String, Integer> zhv;
  public final List<com.tencent.mm.plugin.finder.live.viewmodel.data.h> zhw;
  public cxh zhx;
  public boolean zhy;
  public com.tencent.mm.plugin.finder.live.model.h zhz;
  
  static
  {
    AppMethodBeat.i(258370);
    zhK = new a((byte)0);
    AppMethodBeat.o(258370);
  }
  
  public f(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(258368);
    this.zhi = "";
    this.zhj = Collections.synchronizedList((List)new ArrayList());
    this.zhk = Collections.synchronizedList((List)new ArrayList());
    this.zhm = Collections.synchronizedList((List)new ArrayList());
    this.zhq = -1;
    this.zht = true;
    this.zhv = new HashMap();
    this.zhw = Collections.synchronizedList((List)new ArrayList());
    this.zhx = new cxh();
    this.zhA = new int[] { 20004 };
    this.zhB = new int[] { 20003 };
    this.zhC = new int[] { 20005 };
    this.zhD = new int[] { 20016 };
    this.zhE = new int[] { 20015 };
    this.zhF = new int[] { 20017 };
    this.zhG = new int[] { 20018 };
    this.zhH = new int[] { 20029 };
    this.zhI = new int[] { 20026 };
    this.zhJ = new int[] { 20028 };
    AppMethodBeat.o(258368);
  }
  
  private final void a(ayr paramayr)
  {
    long l = 0L;
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    AppMethodBeat.i(258345);
    Object localObject5 = (b)business(b.class);
    if (localObject5 != null)
    {
      int i;
      switch (paramayr.status)
      {
      default: 
        Log.w("MMFinder.LiveLinkMicSlice", "[Battle] receive unknown status msg:" + paramayr.status);
        AppMethodBeat.o(258345);
        return;
      case 10: 
        localObject1 = paramayr.SKJ;
        kotlin.g.b.p.j(localObject1, "battleInfo.player_info");
        localObject3 = ((Iterable)localObject1).iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            localObject1 = ((Iterator)localObject3).next();
            localObject4 = ((dlk)localObject1).RLN;
            localObject5 = business(b.class);
            if (localObject5 == null) {
              kotlin.g.b.p.iCn();
            }
            if (!Util.isEqual((String)localObject4, ((b)localObject5).kig))
            {
              i = 1;
              if (i == 0) {
                continue;
              }
              label191:
              localObject3 = (dlk)localObject1;
              localObject4 = new StringBuilder("[Battle] receive start battle status msg:[battle_id:").append(paramayr.SKH).append(", battle_seq").append(paramayr.SJY).append("] curBattle:").append(this.zhz).append(" battleUser:");
              if (localObject3 == null) {
                break label309;
              }
            }
          }
        }
        label309:
        for (localObject1 = ((dlk)localObject3).RLN;; localObject1 = null)
        {
          Log.i("MMFinder.LiveLinkMicSlice", (String)localObject1);
          if (localObject3 != null) {
            break label315;
          }
          Log.w("MMFinder.LiveLinkMicSlice", "[Battle] receive battleStatusMsg skip. battleUser is null");
          AppMethodBeat.o(258345);
          return;
          i = 0;
          break;
          localObject1 = null;
          break label191;
        }
        label315:
        localObject3 = paramayr.SKH;
        localObject1 = this.zhz;
        if (localObject1 != null) {}
        for (localObject1 = ((com.tencent.mm.plugin.finder.live.model.h)localObject1).yeu; !Util.isEqual((String)localObject3, (String)localObject1); localObject1 = null)
        {
          localObject1 = new StringBuilder("[Battle] receive battleStatusMsg skip. invalid battleId. recBattleId:").append(paramayr.SKH).append(", localBattleId:");
          localObject3 = this.zhz;
          paramayr = (ayr)localObject2;
          if (localObject3 != null) {
            paramayr = ((com.tencent.mm.plugin.finder.live.model.h)localObject3).yeu;
          }
          Log.w("MMFinder.LiveLinkMicSlice", paramayr);
          AppMethodBeat.o(258345);
          return;
        }
        localObject1 = this.zhz;
        if (localObject1 != null) {}
        for (l = ((com.tencent.mm.plugin.finder.live.model.h)localObject1).yev; l > paramayr.SJY; l = 0L)
        {
          Log.w("MMFinder.LiveLinkMicSlice", "[Battle] receive battleStatusMsg skip. invalid seq");
          AppMethodBeat.o(258345);
          return;
        }
        localObject1 = this.zhz;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.live.model.h)localObject1).yey = 2;
        }
        localObject1 = this.zhz;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.live.model.h)localObject1).yew = paramayr.SKI;
        }
        paramayr = com.tencent.mm.live.b.p.kvF;
        paramayr = com.tencent.mm.live.b.p.aOe();
        if (paramayr != null) {
          paramayr.onBattleStart();
        }
        ((com.tencent.mm.plugin.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.d.class)).bwc();
        AppMethodBeat.o(258345);
        return;
      }
      Object localObject1 = paramayr.SKJ;
      kotlin.g.b.p.j(localObject1, "battleInfo.player_info");
      localObject2 = ((Iterable)localObject1).iterator();
      Object localObject6;
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = ((Iterator)localObject2).next();
        localObject6 = ((dlk)localObject1).RLN;
        androidx.lifecycle.x localx = business(b.class);
        if (localx == null) {
          kotlin.g.b.p.iCn();
        }
        if (!Util.isEqual((String)localObject6, ((b)localx).kig))
        {
          i = 1;
          label635:
          if (i == 0) {
            break label783;
          }
          label639:
          localObject6 = (dlk)localObject1;
          localObject1 = this.zhz;
          if (localObject1 == null) {
            break label791;
          }
          localObject1 = ((com.tencent.mm.plugin.finder.live.model.h)localObject1).aBY(((b)localObject5).kig);
          label669:
          localObject5 = new StringBuilder("[Battle] receive finish battle status msg:[battle_id:").append(paramayr.SKH).append(", battle_seq").append(paramayr.SJY).append("] localBattleUser:").append(localObject1).append(" curBattle:").append(this.zhz).append(" battleUser:");
          if (localObject6 == null) {
            break label797;
          }
        }
      }
      label783:
      label791:
      label797:
      for (localObject2 = ((dlk)localObject6).RLN;; localObject2 = null)
      {
        Log.i("MMFinder.LiveLinkMicSlice", (String)localObject2);
        if (localObject6 != null) {
          break label803;
        }
        Log.w("MMFinder.LiveLinkMicSlice", "[Battle] receive battleStatusMsg skip. battleUser is null");
        AppMethodBeat.o(258345);
        return;
        i = 0;
        break label635;
        break;
        localObject1 = null;
        break label639;
        localObject1 = null;
        break label669;
      }
      label803:
      if (localObject1 == null)
      {
        Log.w("MMFinder.LiveLinkMicSlice", "[Battle] receive battleStatusMsg skip. waitBattleUser is null");
        AppMethodBeat.o(258345);
        return;
      }
      localObject2 = paramayr.SKH;
      localObject1 = this.zhz;
      if (localObject1 != null) {}
      for (localObject1 = ((com.tencent.mm.plugin.finder.live.model.h)localObject1).yeu; !Util.isEqual((String)localObject2, (String)localObject1); localObject1 = null)
      {
        localObject1 = new StringBuilder("[Battle] receive battleStatusMsg skip. invalid battleId. recBattleId:").append(paramayr.SKH).append(", localBattleId:");
        localObject2 = this.zhz;
        paramayr = (ayr)localObject4;
        if (localObject2 != null) {
          paramayr = ((com.tencent.mm.plugin.finder.live.model.h)localObject2).yeu;
        }
        Log.w("MMFinder.LiveLinkMicSlice", paramayr);
        AppMethodBeat.o(258345);
        return;
      }
      localObject1 = this.zhz;
      if (localObject1 != null) {
        l = ((com.tencent.mm.plugin.finder.live.model.h)localObject1).yev;
      }
      if (l > paramayr.SJY)
      {
        Log.w("MMFinder.LiveLinkMicSlice", "[Battle] receive battleStatusMsg skip. invalid seq");
        AppMethodBeat.o(258345);
        return;
      }
      localObject1 = this.zhz;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.finder.live.model.h)localObject1).No(paramayr.result);
      }
      localObject1 = this.zhz;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.finder.live.model.h)localObject1).yew = paramayr.SKI;
      }
      localObject1 = this.zhz;
      if (localObject1 != null)
      {
        localObject2 = paramayr.SKJ;
        kotlin.g.b.p.j(localObject2, "battleInfo.player_info");
        ((com.tencent.mm.plugin.finder.live.model.h)localObject1).en((List)localObject2);
      }
      localObject1 = com.tencent.mm.live.b.p.kvF;
      localObject1 = com.tencent.mm.live.b.p.aOe();
      if (localObject1 != null) {
        ((g)localObject1).onBattleEnd();
      }
      localObject1 = (com.tencent.mm.plugin.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.d.class);
      l = paramayr.SKI;
      localObject2 = this.zhz;
      paramayr = (ayr)localObject3;
      if (localObject2 != null) {
        paramayr = ((com.tencent.mm.plugin.finder.live.model.h)localObject2).yeu;
      }
      ((com.tencent.mm.plugin.d)localObject1).i(l * 1000L, paramayr);
      AppMethodBeat.o(258345);
      return;
    }
    AppMethodBeat.o(258345);
  }
  
  private final LinkedList<axe> aF(LinkedList<axe> paramLinkedList)
  {
    AppMethodBeat.i(258366);
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      axe localaxe = (axe)localObject2;
      if (e.contains(this.zhD, localaxe.msg_type)) {
        paramLinkedList.add(localObject2);
      }
    }
    localLinkedList.addAll((Collection)paramLinkedList);
    AppMethodBeat.o(258366);
    return localLinkedList;
  }
  
  private final void b(ayr paramayr)
  {
    long l = 0L;
    Object localObject2 = null;
    Object localObject3 = null;
    AppMethodBeat.i(258348);
    Object localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
    localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
    if (localObject1 != null)
    {
      Object localObject4 = (b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(b.class);
      if (localObject4 != null)
      {
        int i;
        switch (paramayr.status)
        {
        default: 
          Log.w("MMFinder.LiveLinkMicSlice", "[Battle] receive unknown status msg:" + paramayr.status);
          AppMethodBeat.o(258348);
          return;
        case 10: 
          localObject1 = paramayr.SKJ;
          kotlin.g.b.p.j(localObject1, "battleInfo.player_info");
          localObject2 = ((Iterable)localObject1).iterator();
          for (;;)
          {
            if (((Iterator)localObject2).hasNext())
            {
              localObject1 = ((Iterator)localObject2).next();
              if (!Util.isEqual(((dlk)localObject1).RLN, ((b)localObject4).kig))
              {
                i = 1;
                if (i == 0) {
                  continue;
                }
                label179:
                localObject2 = (dlk)localObject1;
                localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
                localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
                if (localObject1 == null) {
                  break label347;
                }
                localObject1 = (f)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(f.class);
                if (localObject1 == null) {
                  break label347;
                }
                localObject1 = ((f)localObject1).zhl;
                label225:
                localObject3 = new StringBuilder("[Battle] receive start battle status msg:[battle_id:").append(paramayr.SKH).append(", battle_seq").append(paramayr.SJY).append("] curPkUser:").append(localObject1).append(" curBattle:").append(this.zhz).append(" battleUser:");
                if (localObject2 == null) {
                  break label353;
                }
              }
            }
          }
          label347:
          label353:
          for (localObject1 = ((dlk)localObject2).RLN;; localObject1 = null)
          {
            Log.i("MMFinder.LiveLinkMicSlice", (String)localObject1);
            if (localObject2 != null) {
              break label359;
            }
            Log.w("MMFinder.LiveLinkMicSlice", "[Battle] receive battleStatusMsg skip. battleUser is null");
            AppMethodBeat.o(258348);
            return;
            i = 0;
            break;
            localObject1 = null;
            break label179;
            localObject1 = null;
            break label225;
          }
          label359:
          localObject1 = this.zhz;
          if (localObject1 != null) {}
          for (l = ((com.tencent.mm.plugin.finder.live.model.h)localObject1).yev; l > paramayr.SJY; l = 0L)
          {
            Log.w("MMFinder.LiveLinkMicSlice", "[Battle] receive battleStatusMsg skip. invalid seq");
            AppMethodBeat.o(258348);
            return;
          }
          localObject1 = new com.tencent.mm.plugin.finder.live.model.h(paramayr.SKH, paramayr.SJY, paramayr.SKI, -1, 2, null, 32);
          paramayr = paramayr.SKJ;
          kotlin.g.b.p.j(paramayr, "battleInfo.player_info");
          ((com.tencent.mm.plugin.finder.live.model.h)localObject1).en((List)paramayr);
          this.zhz = ((com.tencent.mm.plugin.finder.live.model.h)localObject1);
          paramayr = com.tencent.mm.live.b.p.kvF;
          paramayr = com.tencent.mm.live.b.p.aOe();
          if (paramayr != null) {
            paramayr.onBattleStart();
          }
          ((com.tencent.mm.plugin.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.d.class)).bwc();
          AppMethodBeat.o(258348);
          return;
        }
        localObject1 = paramayr.SKJ;
        kotlin.g.b.p.j(localObject1, "battleInfo.player_info");
        Object localObject5 = ((Iterable)localObject1).iterator();
        if (((Iterator)localObject5).hasNext())
        {
          localObject1 = ((Iterator)localObject5).next();
          if (!Util.isEqual(((dlk)localObject1).RLN, ((b)localObject4).kig))
          {
            i = 1;
            label564:
            if (i == 0) {
              break label717;
            }
            label568:
            localObject5 = (dlk)localObject1;
            localObject1 = ((f)((b)localObject4).business(f.class)).zhl;
            localObject4 = new StringBuilder("[Battle] receive finish battle status msg:[battle_id:").append(paramayr.SKH).append(", battle_seq").append(paramayr.SJY).append("] curPkUser:").append(localObject1).append(" curBattle:").append(this.zhz).append(" battleUser:");
            if (localObject5 == null) {
              break label725;
            }
          }
        }
        label717:
        label725:
        for (localObject1 = ((dlk)localObject5).RLN;; localObject1 = null)
        {
          Log.i("MMFinder.LiveLinkMicSlice", (String)localObject1 + " battleInfo.time_left:" + paramayr.SKI);
          if (localObject5 != null) {
            break label731;
          }
          Log.w("MMFinder.LiveLinkMicSlice", "[Battle] receive battleStatusMsg skip. battleUser is null");
          AppMethodBeat.o(258348);
          return;
          i = 0;
          break label564;
          break;
          localObject1 = null;
          break label568;
        }
        label731:
        localObject4 = paramayr.SKH;
        localObject1 = this.zhz;
        if (localObject1 != null) {}
        for (localObject1 = ((com.tencent.mm.plugin.finder.live.model.h)localObject1).yeu; !Util.isEqual((String)localObject4, (String)localObject1); localObject1 = null)
        {
          localObject1 = new StringBuilder("[Battle] receive battleStatusMsg skip. invalid battleId. recBattleId:").append(paramayr.SKH).append(", localBattleId:");
          localObject2 = this.zhz;
          paramayr = (ayr)localObject3;
          if (localObject2 != null) {
            paramayr = ((com.tencent.mm.plugin.finder.live.model.h)localObject2).yeu;
          }
          Log.w("MMFinder.LiveLinkMicSlice", paramayr);
          AppMethodBeat.o(258348);
          return;
        }
        localObject1 = this.zhz;
        if (localObject1 != null) {
          l = ((com.tencent.mm.plugin.finder.live.model.h)localObject1).yev;
        }
        if (l > paramayr.SJY)
        {
          Log.w("MMFinder.LiveLinkMicSlice", "[Battle] receive battleStatusMsg skip. invalid seq");
          AppMethodBeat.o(258348);
          return;
        }
        localObject1 = this.zhz;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.live.model.h)localObject1).No(paramayr.result);
        }
        localObject1 = this.zhz;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.live.model.h)localObject1).yew = paramayr.SKI;
        }
        localObject1 = this.zhz;
        if (localObject1 != null)
        {
          localObject3 = paramayr.SKJ;
          kotlin.g.b.p.j(localObject3, "battleInfo.player_info");
          ((com.tencent.mm.plugin.finder.live.model.h)localObject1).en((List)localObject3);
        }
        localObject1 = com.tencent.mm.live.b.p.kvF;
        localObject1 = com.tencent.mm.live.b.p.aOe();
        if (localObject1 != null) {
          ((g)localObject1).onBattleEnd();
        }
        localObject1 = (com.tencent.mm.plugin.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.d.class);
        l = paramayr.SKI;
        localObject3 = this.zhz;
        paramayr = (ayr)localObject2;
        if (localObject3 != null) {
          paramayr = ((com.tencent.mm.plugin.finder.live.model.h)localObject3).yeu;
        }
        ((com.tencent.mm.plugin.d)localObject1).i(l * 1000L, paramayr);
        AppMethodBeat.o(258348);
        return;
      }
    }
    AppMethodBeat.o(258348);
  }
  
  public static void g(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    Object localObject2 = null;
    AppMethodBeat.i(258351);
    if (parama != null)
    {
      Object localObject1 = r.yQS;
      localObject1 = ((f)parama.business(f.class)).zhx;
      if (localObject1 != null)
      {
        localObject1 = Long.valueOf(((cxh)localObject1).TFP);
        if (!r.Ly(((Long)localObject1).longValue())) {
          break label181;
        }
        localObject1 = MMApplicationContext.getContext();
        kotlin.g.b.p.j(localObject1, "MMApplicationContext.getContext()");
        localObject1 = ((Context)localObject1).getResources().getString(a.a.finder_live_mic_setting_follow_msg_tip);
        label73:
        kotlin.g.b.p.j(localObject1, "when {\n                L…          }\n            }");
        localObject2 = (CharSequence)localObject1;
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          break label344;
        }
      }
      label181:
      label344:
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          localObject2 = new bbd();
          ((bbd)localObject2).type = 10001;
          ((bbd)localObject2).content = ((String)localObject1);
          localObject2 = new ak((bbd)localObject2);
          ((h)parama.business(h.class)).ziq.add(localObject2);
        }
        Log.i("MMFinder.LiveLinkMicSlice", "appendMicSettingTip:".concat(String.valueOf(localObject1)));
        AppMethodBeat.o(258351);
        return;
        localObject1 = null;
        break;
        localObject1 = r.yQS;
        localObject1 = ((f)parama.business(f.class)).zhx;
        if (localObject1 != null) {}
        for (localObject1 = Long.valueOf(((cxh)localObject1).TFP);; localObject1 = null)
        {
          if (!r.Lz(((Long)localObject1).longValue())) {
            break label250;
          }
          localObject1 = MMApplicationContext.getContext();
          kotlin.g.b.p.j(localObject1, "MMApplicationContext.getContext()");
          localObject1 = ((Context)localObject1).getResources().getString(a.a.finder_live_mic_setting_reward_msg_tip);
          break;
        }
        label250:
        localObject1 = r.yQS;
        cxh localcxh = ((f)parama.business(f.class)).zhx;
        localObject1 = localObject2;
        if (localcxh != null) {
          localObject1 = Long.valueOf(localcxh.TFP);
        }
        if (r.LA(((Long)localObject1).longValue()))
        {
          localObject1 = MMApplicationContext.getContext();
          kotlin.g.b.p.j(localObject1, "MMApplicationContext.getContext()");
          localObject1 = ((Context)localObject1).getResources().getString(a.a.finder_live_mic_setting_buy_product_msg_tip);
          break label73;
        }
        localObject1 = MMApplicationContext.getContext();
        kotlin.g.b.p.j(localObject1, "MMApplicationContext.getContext()");
        localObject1 = ((Context)localObject1).getResources().getString(a.a.finder_live_mic_setting_all_msg_tip);
        break label73;
      }
    }
    AppMethodBeat.o(258351);
  }
  
  public static void p(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(258353);
    if (parama != null)
    {
      bbd localbbd = new bbd();
      localbbd.type = 10001;
      if (!((f)parama.business(f.class)).dHd())
      {
        localObject = MMApplicationContext.getContext();
        kotlin.g.b.p.j(localObject, "MMApplicationContext.getContext()");
      }
      for (Object localObject = ((Context)localObject).getResources().getString(a.a.finder_live_link_mic_enable_msg_tip);; localObject = ((Context)localObject).getResources().getString(a.a.finder_live_link_mic_disable_msg_tip))
      {
        localbbd.content = ((String)localObject);
        localObject = new ak(localbbd);
        ((h)parama.business(h.class)).ziq.add(localObject);
        Log.i("MMFinder.LiveLinkMicSlice", "appendLinkMicTip:" + ((ak)localObject).yig.content);
        AppMethodBeat.o(258353);
        return;
        localObject = MMApplicationContext.getContext();
        kotlin.g.b.p.j(localObject, "MMApplicationContext.getContext()");
      }
    }
    AppMethodBeat.o(258353);
  }
  
  public final void aA(LinkedList<axe> paramLinkedList)
  {
    AppMethodBeat.i(258339);
    Object localObject1 = new LinkedList();
    Object localObject2 = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      localObject4 = (axe)localObject3;
      if (e.contains(this.zhF, ((axe)localObject4).msg_type)) {
        paramLinkedList.add(localObject3);
      }
    }
    ((LinkedList)localObject1).addAll((Collection)paramLinkedList);
    paramLinkedList = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = paramLinkedList.iterator();
    label179:
    label213:
    label216:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      paramLinkedList = ((axe)localObject3).SJH;
      if (paramLinkedList != null)
      {
        paramLinkedList = paramLinkedList.contact;
        if (paramLinkedList != null)
        {
          paramLinkedList = paramLinkedList.username;
          if (Util.isEqual(paramLinkedList, z.bdh())) {
            break label213;
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label216;
        }
        ((Collection)localObject1).add(localObject3);
        break;
        paramLinkedList = null;
        break label179;
      }
    }
    localObject1 = (List)localObject1;
    if (((com.tencent.mm.plugin.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.d.class)).bvS())
    {
      localObject2 = ((Iterable)localObject1).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (axe)((Iterator)localObject2).next();
          localObject4 = new axp();
          Object localObject5 = (com.tencent.mm.cd.a)localObject4;
          paramLinkedList = ((axe)localObject3).SJE;
          if (paramLinkedList != null) {
            paramLinkedList = paramLinkedList.toByteArray();
          }
          try
          {
            for (;;)
            {
              ((com.tencent.mm.cd.a)localObject5).parseFrom(paramLinkedList);
              localObject5 = ((axe)localObject3).session_id;
              if (localObject5 != null)
              {
                ((Map)this.zhv).put(localObject5, Integer.valueOf(3));
                paramLinkedList = this.zhl;
                if (paramLinkedList == null) {
                  break label674;
                }
                paramLinkedList = paramLinkedList.sessionId;
                if (Util.isEqual((String)localObject5, paramLinkedList))
                {
                  ((com.tencent.mm.plugin.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.d.class)).bwb();
                  paramLinkedList = com.tencent.mm.live.b.p.kvF;
                  localObject5 = com.tencent.mm.live.b.p.aOe();
                  if (localObject5 != null)
                  {
                    long l = ((c)business(c.class)).liveInfo.liveId;
                    paramLinkedList = ((axe)localObject3).SJH;
                    if (paramLinkedList == null) {
                      break label679;
                    }
                    paramLinkedList = paramLinkedList.contact;
                    if (paramLinkedList == null) {
                      break label679;
                    }
                    paramLinkedList = paramLinkedList.username;
                    ((g)localObject5).onCloseLiveMic(new com.tencent.mm.live.b.f(l, paramLinkedList, ((axe)localObject3).session_id));
                  }
                  ((com.tencent.mm.plugin.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.d.class)).bwd();
                  this.zhn = 0;
                  this.zhl = null;
                  Log.i("MMFinder.LiveLinkMicSlice", "[LinkMicPk]  anchor receive close pk msg, [sdkUserId:" + ((axp)localObject4).SnB + ']');
                }
                paramLinkedList = this.zhj;
                kotlin.g.b.p.j(paramLinkedList, "linkMicUserList");
                j.c(paramLinkedList, (kotlin.g.a.b)new h((axe)localObject3, (axp)localObject4, this));
                paramLinkedList = this.zhk;
                kotlin.g.b.p.j(paramLinkedList, "newLinkMicUserList");
                j.c(paramLinkedList, (kotlin.g.a.b)new i((axe)localObject3, (axp)localObject4, this));
              }
              Log.i("MMFinder.LiveLinkMicSlice", "[LinkMicPk]  receive close pk msg, [sdkUserId:" + ((axp)localObject4).SnB + ", sessionId:" + ((axe)localObject3).session_id + "], curLiveUser:" + this.zhl + ", applySessionId:" + this.zhi);
              break;
              paramLinkedList = null;
            }
          }
          catch (Exception paramLinkedList)
          {
            for (;;)
            {
              Log.printDebugStack("safeParser", "", new Object[] { paramLinkedList });
              continue;
              label674:
              paramLinkedList = null;
              continue;
              label679:
              paramLinkedList = null;
            }
          }
        }
      }
    }
    Log.i("MMFinder.LiveLinkMicSlice", "[LinkMicPk]  checkLinkClosePkMsg:" + ((List)localObject1).size() + " isAnchor:" + ((com.tencent.mm.plugin.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.d.class)).bvS());
    AppMethodBeat.o(258339);
  }
  
  public final void aB(LinkedList<axe> paramLinkedList)
  {
    AppMethodBeat.i(258340);
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      localObject3 = (axe)localObject2;
      if (e.contains(this.zhG, ((axe)localObject3).msg_type)) {
        paramLinkedList.add(localObject2);
      }
    }
    localLinkedList.addAll((Collection)paramLinkedList);
    if (!((com.tencent.mm.plugin.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.d.class)).bvS())
    {
      Iterator localIterator = ((Iterable)localLinkedList).iterator();
      while (localIterator.hasNext())
      {
        axe localaxe = (axe)localIterator.next();
        axw localaxw = new axw();
        localObject1 = (com.tencent.mm.cd.a)localaxw;
        paramLinkedList = localaxe.SJE;
        if (paramLinkedList != null) {
          paramLinkedList = paramLinkedList.toByteArray();
        }
        try
        {
          for (;;)
          {
            ((com.tencent.mm.cd.a)localObject1).parseFrom(paramLinkedList);
            localObject1 = new StringBuilder("[LinkMicPk] visitor receive pkStatusMsg: [pkStatusScene:").append(localaxw.scene).append(" pkStatusSeq:").append(localaxw.seq).append(" pkStatusPkUser:");
            paramLinkedList = localaxw.SJM;
            if (paramLinkedList == null) {
              break label509;
            }
            paramLinkedList = paramLinkedList.contact;
            if (paramLinkedList == null) {
              break label509;
            }
            paramLinkedList = paramLinkedList.nickname;
            Log.i("MMFinder.LiveLinkMicSlice", paramLinkedList + ']');
            switch (localaxw.scene)
            {
            default: 
              break;
            case 1: 
              localObject1 = new StringBuilder("[LinkMicPk] receive apply pk status msg:[session_id:").append(localaxe.session_id).append(", pkAnchorNickname:");
              paramLinkedList = localaxw.SJM;
              if (paramLinkedList == null) {
                break label514;
              }
              paramLinkedList = paramLinkedList.contact;
              if (paramLinkedList == null) {
                break label514;
              }
              paramLinkedList = paramLinkedList.nickname;
              Log.i("MMFinder.LiveLinkMicSlice", paramLinkedList + ", userSdkId:" + localaxw.SnB + ", isAnchor:" + ((com.tencent.mm.plugin.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.d.class)).bvS() + ']');
              localObject3 = localaxe.session_id;
              if (localObject3 == null) {
                break;
              }
              if (this.zhv.get(localObject3) == null) {
                break label519;
              }
              Log.i("MMFinder.LiveLinkMicSlice", "[LinkMicPk] skip apply pk status msg, invalid apply msg. curMicStatus:" + (Integer)this.zhv.get(localObject3));
              break;
              paramLinkedList = null;
            }
          }
        }
        catch (Exception paramLinkedList)
        {
          for (;;)
          {
            Log.printDebugStack("safeParser", "", new Object[] { paramLinkedList });
            continue;
            label509:
            paramLinkedList = null;
            continue;
            label514:
            paramLinkedList = null;
          }
          label519:
          if (localaxw.seq < this.zhh)
          {
            Log.i("MMFinder.LiveLinkMicSlice", "[LinkMicPk] skip apply pk status msg, mic too old. sessionId:" + (String)localObject3 + " curMsgSeq:" + localaxw.seq + " acceptedSeq:" + this.zhh);
            continue;
          }
          ((Map)this.zhv).put(localObject3, Integer.valueOf(0));
          paramLinkedList = localaxw.SJM;
          if (paramLinkedList != null)
          {
            paramLinkedList = paramLinkedList.contact;
            if (paramLinkedList != null)
            {
              paramLinkedList = paramLinkedList.username;
              label629:
              localObject1 = localaxw.SJM;
              if (localObject1 == null) {
                break label717;
              }
              localObject1 = ((aza)localObject1).contact;
              if (localObject1 == null) {
                break label717;
              }
              localObject1 = ((FinderContact)localObject1).nickname;
              label660:
              localObject2 = localaxw.SJM;
              if (localObject2 == null) {
                break label723;
              }
              localObject2 = ((aza)localObject2).contact;
              if (localObject2 == null) {
                break label723;
              }
            }
          }
          label717:
          label723:
          for (localObject2 = ((FinderContact)localObject2).headUrl;; localObject2 = null)
          {
            this.zhu = new com.tencent.mm.plugin.finder.live.viewmodel.data.b((String)localObject3, paramLinkedList, (String)localObject1, (String)localObject2);
            break;
            paramLinkedList = null;
            break label629;
            localObject1 = null;
            break label660;
          }
          localObject1 = new StringBuilder("[LinkMicPk] receive accept pk status msg:[session_id:").append(localaxe.session_id).append(", pkAnchorNickname:");
          paramLinkedList = localaxw.SJM;
          if (paramLinkedList != null)
          {
            paramLinkedList = paramLinkedList.contact;
            if (paramLinkedList != null)
            {
              paramLinkedList = paramLinkedList.nickname;
              label779:
              localObject1 = ((StringBuilder)localObject1).append(paramLinkedList).append(", userSdkId:").append(localaxw.SnB).append(", isAnchor:").append(((com.tencent.mm.plugin.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.d.class)).bvS()).append(", bgUrl:");
              paramLinkedList = localaxw.SJM;
              if (paramLinkedList == null) {
                break label964;
              }
              paramLinkedList = paramLinkedList.SKa;
              label845:
              Log.i("MMFinder.LiveLinkMicSlice", paramLinkedList + ']');
              paramLinkedList = localaxe.session_id;
              if (paramLinkedList == null) {
                continue;
              }
              localObject1 = (Integer)this.zhv.get(paramLinkedList);
              if (localObject1 != null) {
                break label969;
              }
            }
          }
          label964:
          label969:
          while (((Integer)localObject1).intValue() != 3)
          {
            if (localaxw.seq >= this.zhh) {
              break label997;
            }
            Log.i("MMFinder.LiveLinkMicSlice", "[LinkMicPk] skip accept pk status msg, mic too old. sessionId:" + paramLinkedList + " curMsgSeq:" + localaxw.seq + " acceptedSeq:" + this.zhh);
            break;
            paramLinkedList = null;
            break label779;
            paramLinkedList = null;
            break label845;
          }
          Log.i("MMFinder.LiveLinkMicSlice", "[LinkMicPk] skip accept pk status msg, mic closed. sessionId:".concat(String.valueOf(paramLinkedList)));
        }
        continue;
        label997:
        this.zhu = null;
        ((Map)this.zhv).put(paramLinkedList, Integer.valueOf(2));
        this.zhh = localaxw.seq;
        this.zhn = 4;
        String str1 = localaxw.SnB;
        paramLinkedList = localaxw.SJM;
        label1065:
        label1096:
        label1127:
        String str2;
        if (paramLinkedList != null)
        {
          paramLinkedList = paramLinkedList.contact;
          if (paramLinkedList != null)
          {
            paramLinkedList = paramLinkedList.headUrl;
            localObject1 = localaxw.SJM;
            if (localObject1 == null) {
              break label1336;
            }
            localObject1 = ((aza)localObject1).contact;
            if (localObject1 == null) {
              break label1336;
            }
            localObject1 = ((FinderContact)localObject1).username;
            localObject2 = localaxw.SJM;
            if (localObject2 == null) {
              break label1342;
            }
            localObject2 = ((aza)localObject2).contact;
            if (localObject2 == null) {
              break label1342;
            }
            localObject2 = ((FinderContact)localObject2).nickname;
            str2 = localaxe.session_id;
            localObject3 = localaxw.SJM;
            if (localObject3 == null) {
              break label1348;
            }
            localObject3 = ((aza)localObject3).contact;
            if (localObject3 == null) {
              break label1348;
            }
            localObject3 = ((FinderContact)localObject3).authInfo;
            label1165:
            localObject4 = localaxw.SJM;
            if (localObject4 == null) {
              break label1354;
            }
          }
        }
        long l;
        label1336:
        label1342:
        label1348:
        label1354:
        for (Object localObject4 = ((aza)localObject4).SKa;; localObject4 = null)
        {
          this.zhl = new com.tencent.mm.plugin.finder.live.viewmodel.data.h(str1, paramLinkedList, (String)localObject1, (String)localObject2, 2, str2, null, true, 0, (FinderAuthInfo)localObject3, null, 0, 0, false, (String)localObject4, 0L, localaxw.SJM, 113664);
          paramLinkedList = com.tencent.mm.live.b.p.kvF;
          paramLinkedList = com.tencent.mm.live.b.p.aOe();
          if (paramLinkedList == null) {
            break;
          }
          l = ((c)business(c.class)).liveInfo.liveId;
          localObject1 = localaxe.session_id;
          localObject2 = business(b.class);
          if (localObject2 == null) {
            kotlin.g.b.p.iCn();
          }
          paramLinkedList.onAcceptLiveMic(new com.tencent.mm.live.b.a(l, (String)localObject1, "", ((b)localObject2).dGV(), 0, 0, "", "", 0L, null, Integer.valueOf(2), localaxw.seq, "", true));
          break;
          paramLinkedList = null;
          break label1065;
          localObject1 = null;
          break label1096;
          localObject2 = null;
          break label1127;
          localObject3 = null;
          break label1165;
        }
        localObject1 = new StringBuilder("[LinkMicPk] receive close pk status msg:[session_id:").append(localaxe.session_id).append(", pkAnchorNickname:");
        paramLinkedList = localaxw.SJM;
        if (paramLinkedList != null)
        {
          paramLinkedList = paramLinkedList.contact;
          if (paramLinkedList != null)
          {
            paramLinkedList = paramLinkedList.nickname;
            label1410:
            Log.i("MMFinder.LiveLinkMicSlice", paramLinkedList + ", userSdkId:" + localaxw.SnB + ", isAnchor:" + ((com.tencent.mm.plugin.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.d.class)).bvS() + ']');
            paramLinkedList = localaxe.session_id;
            if (paramLinkedList == null) {
              continue;
            }
            ((Map)this.zhv).put(paramLinkedList, Integer.valueOf(3));
            this.zhu = null;
            paramLinkedList = business(f.class);
            if (paramLinkedList == null) {
              kotlin.g.b.p.iCn();
            }
            if (!((f)paramLinkedList).dHg()) {
              break label1671;
            }
            paramLinkedList = this.zhl;
            if ((paramLinkedList == null) || (paramLinkedList.zeF != true)) {
              break label1671;
            }
            paramLinkedList = this.zhl;
            if (paramLinkedList == null) {
              break label1661;
            }
            paramLinkedList = paramLinkedList.sessionId;
            label1555:
            if (!Util.isEqual(paramLinkedList, localaxe.session_id)) {
              break label1671;
            }
            paramLinkedList = com.tencent.mm.live.b.p.kvF;
            localObject1 = com.tencent.mm.live.b.p.aOe();
            if (localObject1 != null)
            {
              l = ((c)business(c.class)).liveInfo.liveId;
              paramLinkedList = localaxw.SJM;
              if (paramLinkedList == null) {
                break label1666;
              }
              paramLinkedList = paramLinkedList.contact;
              if (paramLinkedList == null) {
                break label1666;
              }
            }
          }
        }
        label1666:
        for (paramLinkedList = paramLinkedList.username;; paramLinkedList = null)
        {
          ((g)localObject1).onCloseLiveMic(new com.tencent.mm.live.b.f(l, paramLinkedList, localaxe.session_id));
          this.zhn = 0;
          this.zhl = null;
          break;
          paramLinkedList = null;
          break label1410;
          label1661:
          paramLinkedList = null;
          break label1555;
        }
        label1671:
        paramLinkedList = new StringBuilder("[LinkMicPk] invalid params: [isLinking:");
        localObject1 = business(f.class);
        if (localObject1 == null) {
          kotlin.g.b.p.iCn();
        }
        localObject1 = paramLinkedList.append(((f)localObject1).dHg()).append(" isPkWithAnchor:");
        paramLinkedList = this.zhl;
        if (paramLinkedList != null)
        {
          paramLinkedList = Boolean.valueOf(paramLinkedList.zeF);
          label1735:
          localObject1 = ((StringBuilder)localObject1).append(paramLinkedList).append(" curSessionId:");
          paramLinkedList = this.zhl;
          if (paramLinkedList == null) {
            break label1805;
          }
        }
        label1805:
        for (paramLinkedList = paramLinkedList.sessionId;; paramLinkedList = null)
        {
          Log.i("MMFinder.LiveLinkMicSlice", paramLinkedList + " msgSessionId:" + localaxe.session_id + ']');
          break;
          paramLinkedList = null;
          break label1735;
        }
      }
    }
    Log.i("MMFinder.LiveLinkMicSlice", "[LinkMicPk] checkPkStatusMsg:" + localLinkedList.size() + " isAnchor:" + ((com.tencent.mm.plugin.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.d.class)).bvS());
    AppMethodBeat.o(258340);
  }
  
  public final void aC(LinkedList<axe> paramLinkedList)
  {
    Object localObject1 = null;
    AppMethodBeat.i(258341);
    label532:
    if (((com.tencent.mm.plugin.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.d.class)).bvS())
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
        localObject5 = (axe)localObject4;
        if (e.contains(this.zhI, ((axe)localObject5).msg_type)) {
          paramLinkedList.add(localObject4);
        }
      }
      ((LinkedList)localObject2).addAll((Collection)paramLinkedList);
      localObject3 = ((Iterable)localObject2).iterator();
      label357:
      label487:
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (axe)((Iterator)localObject3).next();
        localObject2 = (com.tencent.mm.cd.a)new axj();
        paramLinkedList = ((axe)localObject4).SJE;
        if (paramLinkedList != null) {}
        for (paramLinkedList = paramLinkedList.toByteArray();; paramLinkedList = null)
        {
          try
          {
            ((com.tencent.mm.cd.a)localObject2).parseFrom(paramLinkedList);
            paramLinkedList = (LinkedList<axe>)localObject2;
          }
          catch (Exception paramLinkedList)
          {
            for (;;)
            {
              Log.printDebugStack("safeParser", "", new Object[] { paramLinkedList });
              paramLinkedList = null;
              continue;
              paramLinkedList = null;
              continue;
              paramLinkedList = null;
            }
            paramLinkedList = ((axe)localObject4).SJH;
            if (paramLinkedList == null) {
              break label487;
            }
            paramLinkedList = paramLinkedList.contact;
            if (paramLinkedList == null) {
              break label487;
            }
            for (paramLinkedList = paramLinkedList.username; !Util.isEqual(paramLinkedList, ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject5).username); paramLinkedList = null)
            {
              localObject2 = new StringBuilder("[Battle] receive battleApplyMsg skip. invalid username from:");
              localObject3 = ((axe)localObject4).SJH;
              paramLinkedList = localObject1;
              if (localObject3 != null)
              {
                localObject3 = ((aza)localObject3).contact;
                paramLinkedList = localObject1;
                if (localObject3 != null) {
                  paramLinkedList = ((FinderContact)localObject3).username;
                }
              }
              Log.w("MMFinder.LiveLinkMicSlice", paramLinkedList + " pkUser:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject5).username);
              AppMethodBeat.o(258341);
              return;
            }
            paramLinkedList = this.zhz;
            if (paramLinkedList == null) {
              break label532;
            }
            for (long l = paramLinkedList.yev; l > ((axj)localObject2).SJY; l = 0L)
            {
              Log.w("MMFinder.LiveLinkMicSlice", "[Battle] receive battleApplyMsg skip. invalid seq");
              AppMethodBeat.o(258341);
              return;
            }
            this.zhz = new com.tencent.mm.plugin.finder.live.model.h(((axe)localObject4).session_id, ((axj)localObject2).SJY, 0, -1, 1, null, 32);
            paramLinkedList = com.tencent.mm.live.b.p.kvF;
            paramLinkedList = com.tencent.mm.live.b.p.aOe();
          }
          localObject2 = (axj)paramLinkedList;
          localObject5 = new StringBuilder("[Battle] receive battleApplyMsg. sessionId:").append(((axe)localObject4).session_id).append(" micId:");
          if (localObject2 == null) {
            break label357;
          }
          paramLinkedList = ((axj)localObject2).SJW;
          localObject5 = ((StringBuilder)localObject5).append(paramLinkedList).append(" battleSeq:");
          if (localObject2 == null) {
            break label362;
          }
          paramLinkedList = Long.valueOf(((axj)localObject2).SJY);
          Log.i("MMFinder.LiveLinkMicSlice", paramLinkedList + " curPkUser:" + this.zhl);
          if (localObject2 == null) {
            break;
          }
          localObject5 = this.zhl;
          if (localObject5 != null) {
            break label367;
          }
          Log.w("MMFinder.LiveLinkMicSlice", "[Battle] receive battleApplyMsg skip. curPkUser is null");
          AppMethodBeat.o(258341);
          return;
        }
        label362:
        label367:
        if (paramLinkedList != null) {
          paramLinkedList.onBattleApply();
        }
      }
    }
    AppMethodBeat.o(258341);
  }
  
  public final void aCY(String paramString)
  {
    AppMethodBeat.i(258331);
    kotlin.g.b.p.k(paramString, "<set-?>");
    this.zhi = paramString;
    AppMethodBeat.o(258331);
  }
  
  public final boolean aCZ(String paramString)
  {
    AppMethodBeat.i(258356);
    ??? = this.zhm;
    kotlin.g.b.p.j(???, "audienceLinkMicUserList");
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
    paramString = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)j.lp(paramString);
    if (((paramString != null) && (paramString.zeG == 1)) || ((paramString != null) && (paramString.zeG == 2)))
    {
      AppMethodBeat.o(258356);
      return true;
    }
    AppMethodBeat.o(258356);
    return false;
  }
  
  public final void aD(LinkedList<axe> paramLinkedList)
  {
    Object localObject1 = null;
    AppMethodBeat.i(258343);
    if (((com.tencent.mm.plugin.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.d.class)).bvS())
    {
      Object localObject2 = new LinkedList();
      Object localObject3 = (Iterable)paramLinkedList;
      paramLinkedList = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      Object localObject5;
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = ((Iterator)localObject3).next();
        localObject5 = (axe)localObject4;
        if (e.contains(this.zhJ, ((axe)localObject5).msg_type)) {
          paramLinkedList.add(localObject4);
        }
      }
      ((LinkedList)localObject2).addAll((Collection)paramLinkedList);
      Object localObject4 = ((Iterable)localObject2).iterator();
      label391:
      label426:
      while (((Iterator)localObject4).hasNext())
      {
        localObject3 = (axe)((Iterator)localObject4).next();
        localObject2 = (com.tencent.mm.cd.a)new axn();
        paramLinkedList = ((axe)localObject3).SJE;
        if (paramLinkedList != null) {}
        for (paramLinkedList = paramLinkedList.toByteArray();; paramLinkedList = null)
        {
          try
          {
            ((com.tencent.mm.cd.a)localObject2).parseFrom(paramLinkedList);
            paramLinkedList = (LinkedList<axe>)localObject2;
          }
          catch (Exception paramLinkedList)
          {
            for (;;)
            {
              Log.printDebugStack("safeParser", "", new Object[] { paramLinkedList });
              paramLinkedList = null;
              continue;
              paramLinkedList = null;
            }
            paramLinkedList = this.zhz;
            if (paramLinkedList == null) {
              break label342;
            }
            localObject2 = paramLinkedList.yeu;
            paramLinkedList = (LinkedList<axe>)localObject2;
            if (localObject2 != null) {
              break label347;
            }
            paramLinkedList = Integer.valueOf(0);
            if (!(kotlin.g.b.p.h(paramLinkedList, ((axe)localObject3).session_id) ^ true)) {
              break label426;
            }
            localObject2 = new StringBuilder("[Battle] receive battleCloseMsg skip. invalid session_id curBattleId:");
            localObject4 = this.zhz;
            paramLinkedList = localObject1;
            if (localObject4 == null) {
              break label391;
            }
            paramLinkedList = ((com.tencent.mm.plugin.finder.live.model.h)localObject4).yeu;
            Log.w("MMFinder.LiveLinkMicSlice", paramLinkedList + " appMsg.sessionId:" + ((axe)localObject3).session_id);
            AppMethodBeat.o(258343);
            return;
            this.zhz = null;
            paramLinkedList = com.tencent.mm.live.b.p.kvF;
            paramLinkedList = com.tencent.mm.live.b.p.aOe();
          }
          localObject2 = (axn)paramLinkedList;
          localObject5 = new StringBuilder("[Battle] receive battleCloseMsg. sessionId:").append(((axe)localObject3).session_id).append(" scene:");
          if (localObject2 == null) {
            break label317;
          }
          paramLinkedList = Integer.valueOf(((axn)localObject2).scene);
          Log.i("MMFinder.LiveLinkMicSlice", paramLinkedList + " curPkUser:" + this.zhl);
          if (localObject2 == null) {
            break;
          }
          if (this.zhl != null) {
            break label322;
          }
          Log.w("MMFinder.LiveLinkMicSlice", "[Battle] receive battleCloseMsg skip. curPkUser is null");
          AppMethodBeat.o(258343);
          return;
        }
        label317:
        label322:
        label342:
        label347:
        if (paramLinkedList != null) {
          paramLinkedList.onBattleClose();
        }
      }
    }
    AppMethodBeat.o(258343);
  }
  
  public final com.tencent.mm.plugin.finder.live.viewmodel.data.h aDa(String paramString)
  {
    AppMethodBeat.i(258357);
    ??? = this.zhm;
    kotlin.g.b.p.j(???, "audienceLinkMicUserList");
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
    paramString = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)j.lp(paramString);
    AppMethodBeat.o(258357);
    return paramString;
  }
  
  public final com.tencent.mm.plugin.finder.live.viewmodel.data.h aDb(String paramString)
  {
    AppMethodBeat.i(258359);
    ??? = this.zhm;
    kotlin.g.b.p.j(???, "audienceLinkMicUserList");
    Collection localCollection;
    synchronized ((Iterable)???)
    {
      localCollection = (Collection)new ArrayList();
      Iterator localIterator = ((Iterable)???).iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        if (Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject2).ktR, paramString)) {
          localCollection.add(localObject2);
        }
      }
    }
    paramString = (List)localCollection;
    paramString = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)j.lp(paramString);
    AppMethodBeat.o(258359);
    return paramString;
  }
  
  public final void aE(LinkedList<axe> paramLinkedList)
  {
    AppMethodBeat.i(258344);
    Object localObject1 = new LinkedList();
    Object localObject2 = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      axe localaxe = (axe)localObject3;
      if (e.contains(this.zhH, localaxe.msg_type)) {
        paramLinkedList.add(localObject3);
      }
    }
    ((LinkedList)localObject1).addAll((Collection)paramLinkedList);
    localObject2 = ((Iterable)localObject1).iterator();
    label593:
    label598:
    label603:
    label608:
    label613:
    label618:
    label623:
    label628:
    label633:
    label638:
    while (((Iterator)localObject2).hasNext())
    {
      paramLinkedList = (axe)((Iterator)localObject2).next();
      localObject1 = (com.tencent.mm.cd.a)new axm();
      paramLinkedList = paramLinkedList.SJE;
      if (paramLinkedList != null) {}
      for (paramLinkedList = paramLinkedList.toByteArray();; paramLinkedList = null)
      {
        try
        {
          ((com.tencent.mm.cd.a)localObject1).parseFrom(paramLinkedList);
          paramLinkedList = (LinkedList<axe>)localObject1;
        }
        catch (Exception paramLinkedList)
        {
          for (;;)
          {
            Log.printDebugStack("safeParser", "", new Object[] { paramLinkedList });
            paramLinkedList = null;
            continue;
            paramLinkedList = null;
            continue;
            localObject1 = null;
            continue;
            localObject1 = null;
            continue;
            localObject1 = null;
            continue;
            localObject1 = null;
            continue;
            localObject1 = null;
            continue;
            localObject1 = null;
            continue;
            localObject1 = null;
            continue;
            localObject1 = null;
          }
          b(paramLinkedList);
        }
        paramLinkedList = (axm)paramLinkedList;
        if (paramLinkedList == null) {
          break label593;
        }
        paramLinkedList = paramLinkedList.SKc;
        localObject3 = new StringBuilder("[Battle] receive battleStatusMsg. isAnchor:").append(((com.tencent.mm.plugin.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.d.class)).bvS()).append(" battleId:");
        if (paramLinkedList == null) {
          break label598;
        }
        localObject1 = paramLinkedList.SKH;
        localObject3 = ((StringBuilder)localObject3).append((String)localObject1).append(" battleStatusScene:");
        if (paramLinkedList == null) {
          break label603;
        }
        localObject1 = Integer.valueOf(paramLinkedList.status);
        localObject3 = ((StringBuilder)localObject3).append(localObject1).append(" battleStatusSeq:");
        if (paramLinkedList == null) {
          break label608;
        }
        localObject1 = Long.valueOf(paramLinkedList.SJY);
        localObject3 = ((StringBuilder)localObject3).append(localObject1).append(' ').append("battleLeftTime:");
        if (paramLinkedList == null) {
          break label613;
        }
        localObject1 = Integer.valueOf(paramLinkedList.SKI);
        localObject3 = ((StringBuilder)localObject3).append(localObject1).append(" battleResult:");
        if (paramLinkedList == null) {
          break label618;
        }
        localObject1 = Integer.valueOf(paramLinkedList.result);
        localObject3 = ((StringBuilder)localObject3).append(localObject1).append(" players.size:");
        if (paramLinkedList == null) {
          break label623;
        }
        localObject1 = paramLinkedList.SKJ;
        if (localObject1 == null) {
          break label623;
        }
        localObject1 = Integer.valueOf(((LinkedList)localObject1).size());
        localObject3 = ((StringBuilder)localObject3).append(localObject1).append(' ').append("curLiveRoomData?.curLinkMicUser:").append(this.zhl).append(' ').append("curLiveRoomData?.curBattle:");
        localObject1 = (f)business(f.class);
        if (localObject1 == null) {
          break label628;
        }
        localObject1 = ((f)localObject1).zhz;
        Log.i("MMFinder.LiveLinkMicSlice", localObject1);
        localObject3 = (com.tencent.mm.plugin.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.d.class);
        if (paramLinkedList == null) {
          break label633;
        }
        localObject1 = paramLinkedList.SKJ;
        ((com.tencent.mm.plugin.d)localObject3).s((LinkedList)localObject1);
        if (paramLinkedList == null) {
          break;
        }
        Log.i("MMFinder.LiveLinkMicSlice", "[Battle] receive battle status msg:[battle_id:" + paramLinkedList.SKH + ", battle_seq" + paramLinkedList.SJY + ", battle_leftTime:" + paramLinkedList.SKI + " player_info.size:" + paramLinkedList.SKJ.size() + ']');
        if (!((com.tencent.mm.plugin.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.d.class)).bvS()) {
          break label638;
        }
        a(paramLinkedList);
        break;
      }
    }
    AppMethodBeat.o(258344);
  }
  
  public final void ay(LinkedList<axe> paramLinkedList)
  {
    AppMethodBeat.i(258337);
    Object localObject1 = new LinkedList();
    Object localObject2 = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    axe localaxe;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      localaxe = (axe)localObject3;
      if (e.contains(this.zhC, localaxe.msg_type)) {
        paramLinkedList.add(localObject3);
      }
    }
    ((LinkedList)localObject1).addAll((Collection)paramLinkedList);
    paramLinkedList = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = paramLinkedList.iterator();
    label179:
    int i;
    label213:
    label216:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      paramLinkedList = ((axe)localObject3).SJH;
      if (paramLinkedList != null)
      {
        paramLinkedList = paramLinkedList.contact;
        if (paramLinkedList != null)
        {
          paramLinkedList = paramLinkedList.username;
          if (Util.isEqual(paramLinkedList, z.bcZ())) {
            break label213;
          }
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label216;
        }
        ((Collection)localObject1).add(localObject3);
        break;
        paramLinkedList = null;
        break label179;
      }
    }
    localObject1 = (List)localObject1;
    localObject2 = ((Iterable)localObject1).iterator();
    if (((Iterator)localObject2).hasNext())
    {
      localaxe = (axe)((Iterator)localObject2).next();
      localObject3 = new axo();
      ??? = (com.tencent.mm.cd.a)localObject3;
      paramLinkedList = localaxe.SJE;
      if (paramLinkedList != null) {}
      Object localObject5;
      boolean bool;
      label777:
      for (paramLinkedList = paramLinkedList.toByteArray();; paramLinkedList = null) {
        try
        {
          ((com.tencent.mm.cd.a)???).parseFrom(paramLinkedList);
          Log.i("MMFinder.LiveLinkMicSlice", "receive close mic msg, [sdkUserId:" + ((axo)localObject3).SnB + ", sessionId:" + localaxe.session_id + "], curLiveUser:" + this.zhl + ", audienceLinkMicUserList:" + this.zhm + ", applySessionId:" + this.zhi);
          paramLinkedList = localaxe.session_id;
          if (paramLinkedList == null) {
            break;
          }
          ((Map)this.zhv).put(paramLinkedList, Integer.valueOf(3));
          if (!((com.tencent.mm.plugin.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.d.class)).bvS()) {
            break label782;
          }
          paramLinkedList = this.zhm;
          kotlin.g.b.p.j(paramLinkedList, "audienceLinkMicUserList");
        }
        catch (Exception paramLinkedList)
        {
          synchronized ((Iterable)paramLinkedList)
          {
            for (;;)
            {
              localObject5 = ((Iterable)???).iterator();
              do
              {
                if (!((Iterator)localObject5).hasNext()) {
                  break;
                }
                paramLinkedList = ((Iterator)localObject5).next();
                bool = Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)paramLinkedList).sessionId, localaxe.session_id);
              } while (!bool);
              ??? = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)paramLinkedList;
              if (??? != null)
              {
                paramLinkedList = com.tencent.mm.live.b.p.kvF;
                localObject5 = com.tencent.mm.live.b.p.aOe();
                if (localObject5 != null)
                {
                  l = ((c)business(c.class)).liveInfo.liveId;
                  paramLinkedList = localaxe.SJH;
                  if (paramLinkedList == null) {
                    break label777;
                  }
                  paramLinkedList = paramLinkedList.contact;
                  if (paramLinkedList == null) {
                    break label777;
                  }
                  paramLinkedList = paramLinkedList.username;
                  ((g)localObject5).onCloseLiveMic(new com.tencent.mm.live.b.f(l, paramLinkedList, localaxe.session_id, ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???).ktR, ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???).ktS));
                }
                this.zhn = 0;
                paramLinkedList = this.zhm;
                kotlin.g.b.p.j(paramLinkedList, "audienceLinkMicUserList");
                com.tencent.mm.ae.d.a(paramLinkedList, (kotlin.g.a.b)new d(localaxe, (axo)localObject3, this));
                Log.i("MMFinder.LiveLinkMicSlice", "anchor receive close msg, [sdkUserId:" + ((axo)localObject3).SnB + "] closeUser:" + ???);
              }
              paramLinkedList = this.zhj;
              kotlin.g.b.p.j(paramLinkedList, "linkMicUserList");
              j.c(paramLinkedList, (kotlin.g.a.b)new e(localaxe, (axo)localObject3, this));
              paramLinkedList = this.zhk;
              kotlin.g.b.p.j(paramLinkedList, "newLinkMicUserList");
              j.c(paramLinkedList, (kotlin.g.a.b)new f(localaxe, (axo)localObject3, this));
              break;
              paramLinkedList = null;
              continue;
              paramLinkedList = paramLinkedList;
              Log.printDebugStack("safeParser", "", new Object[] { paramLinkedList });
            }
            paramLinkedList = null;
          }
        }
      }
      label782:
      paramLinkedList = this.zhm;
      kotlin.g.b.p.j(paramLinkedList, "audienceLinkMicUserList");
      label1144:
      label1149:
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              synchronized ((Iterable)paramLinkedList)
              {
                localObject5 = ((Iterable)???).iterator();
                if (((Iterator)localObject5).hasNext())
                {
                  paramLinkedList = ((Iterator)localObject5).next();
                  bool = Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)paramLinkedList).sessionId, localaxe.session_id);
                  if (!bool) {
                    continue;
                  }
                  ??? = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)paramLinkedList;
                  if (??? == null) {
                    break label1149;
                  }
                  paramLinkedList = com.tencent.mm.live.b.p.kvF;
                  localObject5 = com.tencent.mm.live.b.p.aOe();
                  if (localObject5 != null)
                  {
                    l = ((c)business(c.class)).liveInfo.liveId;
                    paramLinkedList = localaxe.SJH;
                    if (paramLinkedList == null) {
                      break label1144;
                    }
                    paramLinkedList = paramLinkedList.contact;
                    if (paramLinkedList == null) {
                      break label1144;
                    }
                    paramLinkedList = paramLinkedList.username;
                    ((g)localObject5).onCloseLiveMic(new com.tencent.mm.live.b.f(l, paramLinkedList, localaxe.session_id, ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???).ktR, ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???).ktS));
                  }
                  paramLinkedList = this.zhm;
                  kotlin.g.b.p.j(paramLinkedList, "audienceLinkMicUserList");
                  com.tencent.mm.ae.d.a(paramLinkedList, (kotlin.g.a.b)new g(localaxe, (axo)localObject3, this));
                  this.zhn = 0;
                  paramLinkedList = business(b.class);
                  if (paramLinkedList == null) {
                    kotlin.g.b.p.iCn();
                  }
                  if (Util.isEqual(((b)paramLinkedList).dGU(), ((axo)localObject3).SnB))
                  {
                    ((com.tencent.mm.plugin.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.d.class)).bvY();
                    ((com.tencent.mm.plugin.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.d.class)).bvZ();
                  }
                  paramLinkedList = new StringBuilder("visitor receive close msg, [sdkUserId:").append(((axo)localObject3).SnB).append("] selfSdkUserId:");
                  localObject3 = business(b.class);
                  if (localObject3 == null) {
                    kotlin.g.b.p.iCn();
                  }
                  Log.i("MMFinder.LiveLinkMicSlice", ((b)localObject3).dGU() + " closeUser:" + ???);
                  break;
                }
                paramLinkedList = null;
              }
              paramLinkedList = null;
            }
            paramLinkedList = business(f.class);
            if (paramLinkedList == null) {
              kotlin.g.b.p.iCn();
            }
          } while (!((f)paramLinkedList).dHf());
          paramLinkedList = business(b.class);
          if (paramLinkedList == null) {
            kotlin.g.b.p.iCn();
          }
        } while (!Util.isEqual(((b)paramLinkedList).dGU(), ((axo)localObject3).SnB));
        if (this.zhn != 1) {
          break label1303;
        }
        i = 1;
        paramLinkedList = com.tencent.mm.live.b.p.kvF;
        localObject5 = com.tencent.mm.live.b.p.aOe();
      } while (localObject5 == null);
      label1216:
      long l = ((c)business(c.class)).liveInfo.liveId;
      paramLinkedList = localaxe.SJH;
      if (paramLinkedList != null)
      {
        paramLinkedList = paramLinkedList.contact;
        if (paramLinkedList == null) {}
      }
      for (paramLinkedList = paramLinkedList.username;; paramLinkedList = null)
      {
        ((g)localObject5).onCloseLiveMic(new com.tencent.mm.live.b.f(l, paramLinkedList, localaxe.session_id, ((axo)localObject3).SnB, i));
        break;
        label1303:
        i = 2;
        break label1216;
      }
    }
    Log.i("MMFinder.LiveLinkMicSlice", "closeMicMsgList:" + ((List)localObject1).size() + " isAnchor:" + ((com.tencent.mm.plugin.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.d.class)).bvS());
    AppMethodBeat.o(258337);
  }
  
  public final void az(LinkedList<axe> paramLinkedList)
  {
    AppMethodBeat.i(258338);
    LinkedList localLinkedList = aF(paramLinkedList);
    axe localaxe;
    axh localaxh;
    Object localObject1;
    if (((com.tencent.mm.plugin.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.d.class)).bvS())
    {
      localaxe = (axe)j.lp((List)localLinkedList);
      if (localaxe != null)
      {
        localaxh = new axh();
        localObject1 = (com.tencent.mm.cd.a)localaxh;
        paramLinkedList = localaxe.SJE;
        if (paramLinkedList == null) {
          break label281;
        }
        paramLinkedList = paramLinkedList.toByteArray();
      }
    }
    label281:
    label328:
    String str1;
    try
    {
      for (;;)
      {
        ((com.tencent.mm.cd.a)localObject1).parseFrom(paramLinkedList);
        Log.i("MMFinder.LiveLinkMicSlice", "[LinkMicPk]  receive accept pk msg, [applySdkUserId:" + localaxh.SJO + ", sessionId:" + localaxe.session_id + "], curLiveUser:" + this.zhl + ", bgUrl:" + localaxh.SJR + "]}");
        paramLinkedList = localaxe.session_id;
        if (paramLinkedList != null)
        {
          localObject1 = (Integer)this.zhv.get(paramLinkedList);
          if (localObject1 != null) {
            break;
          }
          localObject1 = business(f.class);
          if (localObject1 == null) {
            kotlin.g.b.p.iCn();
          }
          if (!((f)localObject1).dHg()) {
            break label328;
          }
          Log.i("MMFinder.LiveLinkMicSlice", "[LinkMicPk] anchor is linking mic, skip accept!");
        }
        Log.i("MMFinder.LiveLinkMicSlice", "[LinkMicPk] acceptMicMsgPkList:" + localLinkedList.size() + " isAnchor:" + ((com.tencent.mm.plugin.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.d.class)).bvS());
        AppMethodBeat.o(258338);
        return;
        paramLinkedList = null;
      }
    }
    catch (Exception paramLinkedList)
    {
      for (;;)
      {
        Log.printDebugStack("safeParser", "", new Object[] { paramLinkedList });
        continue;
        if (((Integer)localObject1).intValue() == 3)
        {
          Log.i("MMFinder.LiveLinkMicSlice", "[LinkMicPk] mic has closed, skip accept!");
          continue;
          if (localaxh.seq >= this.zhh) {
            break;
          }
          Log.i("MMFinder.LiveLinkMicSlice", "[LinkMicPk] invalid seq acceptInfo.seq:" + localaxh.seq + " liveData.acceptSeq:" + this.zhh + ", skip accept!");
        }
      }
      ((Map)this.zhv).put(paramLinkedList, Integer.valueOf(2));
      str1 = localaxh.SJS;
      paramLinkedList = localaxe.SJH;
      if (paramLinkedList == null) {
        break label1044;
      }
    }
    paramLinkedList = paramLinkedList.contact;
    label439:
    label470:
    Object localObject2;
    label501:
    int i;
    Object localObject3;
    label552:
    label692:
    label730:
    long l1;
    int j;
    long l2;
    if (paramLinkedList != null)
    {
      paramLinkedList = paramLinkedList.headUrl;
      localObject1 = localaxe.SJH;
      if (localObject1 == null) {
        break label1049;
      }
      localObject1 = ((aza)localObject1).contact;
      if (localObject1 == null) {
        break label1049;
      }
      localObject1 = ((FinderContact)localObject1).username;
      localObject2 = localaxe.SJH;
      if (localObject2 == null) {
        break label1055;
      }
      localObject2 = ((aza)localObject2).contact;
      if (localObject2 == null) {
        break label1055;
      }
      localObject2 = ((FinderContact)localObject2).nickname;
      String str2 = localaxe.session_id;
      com.tencent.mm.cd.b localb = localaxh.SJU;
      i = localaxh.SJT;
      localObject3 = localaxe.SJH;
      if (localObject3 == null) {
        break label1061;
      }
      localObject3 = ((aza)localObject3).contact;
      if (localObject3 == null) {
        break label1061;
      }
      localObject3 = ((FinderContact)localObject3).authInfo;
      this.zhl = new com.tencent.mm.plugin.finder.live.viewmodel.data.h(str1, paramLinkedList, (String)localObject1, (String)localObject2, 2, str2, localb, true, i, (FinderAuthInfo)localObject3, null, 0, 0, false, localaxh.SJR, 0L, localaxe.SJH, 113664);
      Log.i("MMFinder.LiveLinkMicSlice", "[LinkMicPk] receive accept pk msg, curLinkMicUser is me");
      ((com.tencent.mm.plugin.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.d.class)).a(this.zeV);
      this.zhh = localaxh.seq;
      localObject1 = new StringBuilder("[LinkMicPk] receive accept msg:[isAnchor:").append(((com.tencent.mm.plugin.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.d.class)).bvS()).append(", username:");
      paramLinkedList = localaxe.SJH;
      if (paramLinkedList == null) {
        break label1067;
      }
      paramLinkedList = paramLinkedList.contact;
      if (paramLinkedList == null) {
        break label1067;
      }
      paramLinkedList = paramLinkedList.username;
      localObject1 = ((StringBuilder)localObject1).append(paramLinkedList).append(", nickname:");
      paramLinkedList = localaxe.SJH;
      if (paramLinkedList == null) {
        break label1072;
      }
      paramLinkedList = paramLinkedList.contact;
      if (paramLinkedList == null) {
        break label1072;
      }
      paramLinkedList = paramLinkedList.nickname;
      Log.i("MMFinder.LiveLinkMicSlice", paramLinkedList + ", sdkUerId:" + localaxh.SJS + ", sdkLiveId:" + localaxh.SJT + " sessionId:" + localaxe.session_id + ']');
      ((com.tencent.mm.plugin.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.d.class)).bwa();
      l1 = ((c)business(c.class)).liveInfo.liveId;
      localObject1 = localaxe.session_id;
      localObject2 = localaxh.SJS;
      paramLinkedList = business(b.class);
      if (paramLinkedList == null) {
        kotlin.g.b.p.iCn();
      }
      i = ((b)paramLinkedList).dGV();
      j = localaxh.SJT;
      l2 = localaxh.seq;
      paramLinkedList = localaxh.SJU;
      if (paramLinkedList == null) {
        break label1077;
      }
    }
    label1044:
    label1049:
    label1055:
    label1061:
    label1067:
    label1072:
    label1077:
    for (paramLinkedList = paramLinkedList.Ap();; paramLinkedList = null)
    {
      localObject2 = new com.tencent.mm.live.b.a(l1, (String)localObject1, (String)localObject2, i, 0, j, "", "", 0L, null, Integer.valueOf(2), l2, paramLinkedList, true);
      paramLinkedList = com.tencent.mm.live.b.p.kvF;
      paramLinkedList = com.tencent.mm.live.b.p.aOe();
      if (paramLinkedList != null) {
        paramLinkedList.onAcceptLiveMic((com.tencent.mm.live.b.a)localObject2);
      }
      localObject1 = ((com.tencent.mm.plugin.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.d.class)).bvT();
      paramLinkedList = (LinkedList<axe>)localObject1;
      if (!(localObject1 instanceof com.tencent.mm.live.core.core.a.b)) {
        paramLinkedList = null;
      }
      localObject3 = (com.tencent.mm.live.core.core.a.b)paramLinkedList;
      if (localObject3 == null) {
        break;
      }
      i = ((com.tencent.mm.live.b.a)localObject2).ktG;
      localObject1 = ((com.tencent.mm.live.b.a)localObject2).userId;
      paramLinkedList = (LinkedList<axe>)localObject1;
      if (localObject1 == null) {
        paramLinkedList = "";
      }
      localObject2 = ((com.tencent.mm.live.b.a)localObject2).ktK;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      ((com.tencent.mm.live.core.core.a.b)localObject3).l(String.valueOf(i), paramLinkedList, (String)localObject1);
      break;
      paramLinkedList = null;
      break label439;
      localObject1 = null;
      break label470;
      localObject2 = null;
      break label501;
      localObject3 = null;
      break label552;
      paramLinkedList = null;
      break label692;
      paramLinkedList = null;
      break label730;
    }
  }
  
  public final int dHb()
  {
    AppMethodBeat.i(258332);
    ??? = this.zhk;
    kotlin.g.b.p.j(???, "newLinkMicUserList");
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
        if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject3).zeF)
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
    AppMethodBeat.o(258332);
    return i;
  }
  
  public final int dHc()
  {
    AppMethodBeat.i(258333);
    ??? = this.zhk;
    kotlin.g.b.p.j(???, "newLinkMicUserList");
    synchronized ((Iterable)???)
    {
      Collection localCollection = (Collection)new ArrayList();
      Iterator localIterator = ((Iterable)???).iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = localIterator.next();
        if (((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject3).zeF) {
          localCollection.add(localObject3);
        }
      }
    }
    List localList = (List)localObject2;
    int i = localList.size();
    AppMethodBeat.o(258333);
    return i;
  }
  
  public final boolean dHd()
  {
    return this.zhq == 1;
  }
  
  public final boolean dHe()
  {
    AppMethodBeat.i(258334);
    if (this.zhm.size() >= 3)
    {
      AppMethodBeat.o(258334);
      return true;
    }
    AppMethodBeat.o(258334);
    return false;
  }
  
  public final boolean dHf()
  {
    AppMethodBeat.i(258361);
    if ((((f)business(f.class)).zhn == 1) || (((f)business(f.class)).zhn == 2))
    {
      AppMethodBeat.o(258361);
      return true;
    }
    AppMethodBeat.o(258361);
    return false;
  }
  
  public final boolean dHg()
  {
    AppMethodBeat.i(258363);
    if ((((f)business(f.class)).zhn == 3) || (((f)business(f.class)).zhn == 4))
    {
      AppMethodBeat.o(258363);
      return true;
    }
    AppMethodBeat.o(258363);
    return false;
  }
  
  /* Error */
  public final void j(final com.tencent.mm.plugin.finder.live.model.context.a parama, LinkedList<axe> arg2)
  {
    // Byte code:
    //   0: ldc_w 1203
    //   3: invokestatic 253	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 517	java/util/LinkedList
    //   9: dup
    //   10: invokespecial 518	java/util/LinkedList:<init>	()V
    //   13: astore 14
    //   15: aload_2
    //   16: checkcast 375	java/lang/Iterable
    //   19: astore 11
    //   21: new 279	java/util/ArrayList
    //   24: dup
    //   25: invokespecial 281	java/util/ArrayList:<init>	()V
    //   28: checkcast 520	java/util/Collection
    //   31: astore_2
    //   32: aload 11
    //   34: invokeinterface 379 1 0
    //   39: astore 11
    //   41: aload 11
    //   43: invokeinterface 384 1 0
    //   48: ifeq +46 -> 94
    //   51: aload 11
    //   53: invokeinterface 388 1 0
    //   58: astore 12
    //   60: aload 12
    //   62: checkcast 522	com/tencent/mm/protocal/protobuf/axe
    //   65: astore 13
    //   67: aload_0
    //   68: getfield 313	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:zhA	[I
    //   71: aload 13
    //   73: getfield 525	com/tencent/mm/protocal/protobuf/axe:msg_type	I
    //   76: invokestatic 531	kotlin/a/e:contains	([II)Z
    //   79: ifeq -38 -> 41
    //   82: aload_2
    //   83: aload 12
    //   85: invokeinterface 535 2 0
    //   90: pop
    //   91: goto -50 -> 41
    //   94: aload 14
    //   96: aload_2
    //   97: checkcast 283	java/util/List
    //   100: checkcast 520	java/util/Collection
    //   103: invokevirtual 539	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
    //   106: pop
    //   107: aload 14
    //   109: checkcast 375	java/lang/Iterable
    //   112: invokeinterface 379 1 0
    //   117: astore 15
    //   119: aload 15
    //   121: invokeinterface 384 1 0
    //   126: ifeq +1566 -> 1692
    //   129: aload 15
    //   131: invokeinterface 388 1 0
    //   136: checkcast 522	com/tencent/mm/protocal/protobuf/axe
    //   139: astore 16
    //   141: new 1205	com/tencent/mm/protocal/protobuf/axg
    //   144: dup
    //   145: invokespecial 1206	com/tencent/mm/protocal/protobuf/axg:<init>	()V
    //   148: astore 17
    //   150: aload 17
    //   152: checkcast 716	com/tencent/mm/cd/a
    //   155: astore 11
    //   157: aload 16
    //   159: getfield 720	com/tencent/mm/protocal/protobuf/axe:SJE	Lcom/tencent/mm/cd/b;
    //   162: astore_2
    //   163: aload_2
    //   164: ifnull +737 -> 901
    //   167: aload_2
    //   168: invokevirtual 726	com/tencent/mm/cd/b:toByteArray	()[B
    //   171: astore_2
    //   172: aload 11
    //   174: aload_2
    //   175: invokevirtual 730	com/tencent/mm/cd/a:parseFrom	([B)Lcom/tencent/mm/cd/a;
    //   178: pop
    //   179: new 348	java/lang/StringBuilder
    //   182: dup
    //   183: ldc_w 1208
    //   186: invokespecial 352	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   189: ldc_w 474
    //   192: invokestatic 480	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   195: checkcast 474	com/tencent/mm/plugin/d
    //   198: invokeinterface 711 1 0
    //   203: invokevirtual 825	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   206: ldc_w 1159
    //   209: invokevirtual 413	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: astore 11
    //   214: aload 16
    //   216: getfield 692	com/tencent/mm/protocal/protobuf/axe:SJH	Lcom/tencent/mm/protocal/protobuf/aza;
    //   219: astore_2
    //   220: aload_2
    //   221: ifnull +706 -> 927
    //   224: aload_2
    //   225: getfield 698	com/tencent/mm/protocal/protobuf/aza:contact	Lcom/tencent/mm/protocal/protobuf/FinderContact;
    //   228: astore_2
    //   229: aload_2
    //   230: ifnull +697 -> 927
    //   233: aload_2
    //   234: getfield 703	com/tencent/mm/protocal/protobuf/FinderContact:username	Ljava/lang/String;
    //   237: astore_2
    //   238: aload 11
    //   240: aload_2
    //   241: invokevirtual 413	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: ldc_w 1161
    //   247: invokevirtual 413	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: astore 11
    //   252: aload 16
    //   254: getfield 692	com/tencent/mm/protocal/protobuf/axe:SJH	Lcom/tencent/mm/protocal/protobuf/aza;
    //   257: astore_2
    //   258: aload_2
    //   259: ifnull +673 -> 932
    //   262: aload_2
    //   263: getfield 698	com/tencent/mm/protocal/protobuf/aza:contact	Lcom/tencent/mm/protocal/protobuf/FinderContact;
    //   266: astore_2
    //   267: aload_2
    //   268: ifnull +664 -> 932
    //   271: aload_2
    //   272: getfield 849	com/tencent/mm/protocal/protobuf/FinderContact:nickname	Ljava/lang/String;
    //   275: astore_2
    //   276: aload 11
    //   278: aload_2
    //   279: invokevirtual 413	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: ldc_w 1163
    //   285: invokevirtual 413	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: astore 11
    //   290: aload 17
    //   292: getfield 1212	com/tencent/mm/protocal/protobuf/axg:SJL	Lcom/tencent/mm/protocal/protobuf/crw;
    //   295: astore_2
    //   296: aload_2
    //   297: ifnull +640 -> 937
    //   300: aload_2
    //   301: getfield 1217	com/tencent/mm/protocal/protobuf/crw:TyF	Ljava/lang/String;
    //   304: astore_2
    //   305: ldc_w 346
    //   308: aload 11
    //   310: aload_2
    //   311: invokevirtual 413	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: ldc_w 1219
    //   317: invokevirtual 413	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: aload 17
    //   322: getfield 1222	com/tencent/mm/protocal/protobuf/axg:SJK	I
    //   325: invokevirtual 356	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   328: ldc_w 803
    //   331: invokevirtual 413	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: aload 16
    //   336: getfield 733	com/tencent/mm/protocal/protobuf/axe:session_id	Ljava/lang/String;
    //   339: invokevirtual 413	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: ldc_w 1224
    //   345: invokevirtual 413	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: aload 17
    //   350: getfield 1225	com/tencent/mm/protocal/protobuf/axg:seq	J
    //   353: invokevirtual 421	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   356: bipush 93
    //   358: invokevirtual 785	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   361: invokevirtual 359	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   364: invokestatic 432	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   367: aload 16
    //   369: getfield 733	com/tencent/mm/protocal/protobuf/axe:session_id	Ljava/lang/String;
    //   372: astore 18
    //   374: aload 18
    //   376: ifnull -257 -> 119
    //   379: ldc_w 474
    //   382: invokestatic 480	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   385: checkcast 474	com/tencent/mm/plugin/d
    //   388: invokeinterface 711 1 0
    //   393: ifne +566 -> 959
    //   396: aload_1
    //   397: ldc 2
    //   399: invokevirtual 554	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   402: checkcast 2	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   405: getfield 304	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:zhv	Ljava/util/HashMap;
    //   408: aload 18
    //   410: invokevirtual 862	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   413: checkcast 737	java/lang/Integer
    //   416: astore_2
    //   417: aload_2
    //   418: ifnonnull +524 -> 942
    //   421: aload_1
    //   422: ldc 2
    //   424: invokevirtual 554	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   427: checkcast 2	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   430: getfield 304	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:zhv	Ljava/util/HashMap;
    //   433: checkcast 735	java/util/Map
    //   436: aload 18
    //   438: iconst_2
    //   439: invokestatic 740	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   442: invokeinterface 744 3 0
    //   447: pop
    //   448: aload_1
    //   449: ldc 2
    //   451: invokevirtual 554	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   454: checkcast 2	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   457: getfield 306	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:zhw	Ljava/util/List;
    //   460: astore_2
    //   461: aload_2
    //   462: ldc_w 1227
    //   465: invokestatic 373	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   468: aload_2
    //   469: checkcast 375	java/lang/Iterable
    //   472: astore 13
    //   474: aload 13
    //   476: monitorenter
    //   477: aload 13
    //   479: invokeinterface 379 1 0
    //   484: astore 19
    //   486: aload 19
    //   488: invokeinterface 384 1 0
    //   493: ifeq +473 -> 966
    //   496: aload 19
    //   498: invokeinterface 388 1 0
    //   503: astore 11
    //   505: aload 11
    //   507: checkcast 746	com/tencent/mm/plugin/finder/live/viewmodel/data/h
    //   510: astore 20
    //   512: aload 17
    //   514: getfield 1212	com/tencent/mm/protocal/protobuf/axg:SJL	Lcom/tencent/mm/protocal/protobuf/crw;
    //   517: astore_2
    //   518: aload_2
    //   519: ifnull +17 -> 536
    //   522: aload_2
    //   523: getfield 1217	com/tencent/mm/protocal/protobuf/crw:TyF	Ljava/lang/String;
    //   526: astore 12
    //   528: aload 12
    //   530: astore_2
    //   531: aload 12
    //   533: ifnonnull +9 -> 542
    //   536: aload 17
    //   538: getfield 1228	com/tencent/mm/protocal/protobuf/axg:SnB	Ljava/lang/String;
    //   541: astore_2
    //   542: aload_2
    //   543: aload 20
    //   545: getfield 1015	com/tencent/mm/plugin/finder/live/viewmodel/data/h:ktR	Ljava/lang/String;
    //   548: invokestatic 405	com/tencent/mm/sdk/platformtools/Util:isEqual	(Ljava/lang/String;Ljava/lang/String;)Z
    //   551: istore 6
    //   553: iload 6
    //   555: ifeq -69 -> 486
    //   558: aload 11
    //   560: astore_2
    //   561: aload 13
    //   563: monitorexit
    //   564: aload_2
    //   565: checkcast 746	com/tencent/mm/plugin/finder/live/viewmodel/data/h
    //   568: astore 19
    //   570: aload_1
    //   571: ldc_w 335
    //   574: invokevirtual 554	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   577: checkcast 335	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   580: astore 20
    //   582: aload 17
    //   584: getfield 1212	com/tencent/mm/protocal/protobuf/axg:SJL	Lcom/tencent/mm/protocal/protobuf/crw;
    //   587: astore_2
    //   588: aload_2
    //   589: ifnull +17 -> 606
    //   592: aload_2
    //   593: getfield 1217	com/tencent/mm/protocal/protobuf/crw:TyF	Ljava/lang/String;
    //   596: astore 11
    //   598: aload 11
    //   600: astore_2
    //   601: aload 11
    //   603: ifnonnull +9 -> 612
    //   606: aload 17
    //   608: getfield 1228	com/tencent/mm/protocal/protobuf/axg:SnB	Ljava/lang/String;
    //   611: astore_2
    //   612: aload 17
    //   614: getfield 1229	com/tencent/mm/protocal/protobuf/axg:SJM	Lcom/tencent/mm/protocal/protobuf/aza;
    //   617: astore 11
    //   619: aload 11
    //   621: ifnull +362 -> 983
    //   624: aload 11
    //   626: getfield 698	com/tencent/mm/protocal/protobuf/aza:contact	Lcom/tencent/mm/protocal/protobuf/FinderContact;
    //   629: astore 11
    //   631: aload 11
    //   633: ifnull +350 -> 983
    //   636: aload 11
    //   638: getfield 875	com/tencent/mm/protocal/protobuf/FinderContact:headUrl	Ljava/lang/String;
    //   641: astore 11
    //   643: aload 17
    //   645: getfield 1229	com/tencent/mm/protocal/protobuf/axg:SJM	Lcom/tencent/mm/protocal/protobuf/aza;
    //   648: astore 12
    //   650: aload 12
    //   652: ifnull +337 -> 989
    //   655: aload 12
    //   657: getfield 698	com/tencent/mm/protocal/protobuf/aza:contact	Lcom/tencent/mm/protocal/protobuf/FinderContact;
    //   660: astore 12
    //   662: aload 12
    //   664: ifnull +325 -> 989
    //   667: aload 12
    //   669: getfield 703	com/tencent/mm/protocal/protobuf/FinderContact:username	Ljava/lang/String;
    //   672: astore 12
    //   674: aload 17
    //   676: getfield 1229	com/tencent/mm/protocal/protobuf/axg:SJM	Lcom/tencent/mm/protocal/protobuf/aza;
    //   679: astore 13
    //   681: aload 13
    //   683: ifnull +312 -> 995
    //   686: aload 13
    //   688: getfield 698	com/tencent/mm/protocal/protobuf/aza:contact	Lcom/tencent/mm/protocal/protobuf/FinderContact;
    //   691: astore 13
    //   693: aload 13
    //   695: ifnull +300 -> 995
    //   698: aload 13
    //   700: getfield 849	com/tencent/mm/protocal/protobuf/FinderContact:nickname	Ljava/lang/String;
    //   703: astore 13
    //   705: aload 17
    //   707: getfield 1222	com/tencent/mm/protocal/protobuf/axg:SJK	I
    //   710: istore 4
    //   712: aload 16
    //   714: getfield 733	com/tencent/mm/protocal/protobuf/axe:session_id	Ljava/lang/String;
    //   717: astore 21
    //   719: aload 17
    //   721: getfield 1229	com/tencent/mm/protocal/protobuf/axg:SJM	Lcom/tencent/mm/protocal/protobuf/aza;
    //   724: astore 22
    //   726: aload 22
    //   728: ifnull +273 -> 1001
    //   731: aload 22
    //   733: getfield 1232	com/tencent/mm/protocal/protobuf/aza:SKT	I
    //   736: istore_3
    //   737: aload 19
    //   739: ifnull +267 -> 1006
    //   742: aload 19
    //   744: getfield 1235	com/tencent/mm/plugin/finder/live/viewmodel/data/h:zeI	Z
    //   747: istore 6
    //   749: aload 20
    //   751: new 746	com/tencent/mm/plugin/finder/live/viewmodel/data/h
    //   754: dup
    //   755: aload_2
    //   756: aload 11
    //   758: aload 12
    //   760: aload 13
    //   762: iload 4
    //   764: aload 21
    //   766: aconst_null
    //   767: iconst_0
    //   768: iconst_0
    //   769: aconst_null
    //   770: aconst_null
    //   771: iconst_0
    //   772: iload_3
    //   773: iload 6
    //   775: aconst_null
    //   776: lconst_0
    //   777: aload 17
    //   779: getfield 1229	com/tencent/mm/protocal/protobuf/axg:SJM	Lcom/tencent/mm/protocal/protobuf/aza;
    //   782: ldc_w 1236
    //   785: invokespecial 904	com/tencent/mm/plugin/finder/live/viewmodel/data/h:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/tencent/mm/cd/b;ZILcom/tencent/mm/protocal/protobuf/FinderAuthInfo;Ljava/lang/String;IIZLjava/lang/String;JLcom/tencent/mm/protocal/protobuf/aza;I)V
    //   788: invokevirtual 1239	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:g	(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/h;)V
    //   791: aload_1
    //   792: ldc 2
    //   794: invokevirtual 554	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   797: checkcast 2	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   800: getfield 295	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:zhm	Ljava/util/List;
    //   803: astore_2
    //   804: aload_2
    //   805: ldc_w 1241
    //   808: invokestatic 373	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   811: aload_2
    //   812: checkcast 375	java/lang/Iterable
    //   815: astore_2
    //   816: aload_2
    //   817: monitorenter
    //   818: aload_2
    //   819: invokeinterface 379 1 0
    //   824: astore 11
    //   826: iconst_0
    //   827: istore_3
    //   828: aload 11
    //   830: invokeinterface 384 1 0
    //   835: ifeq +177 -> 1012
    //   838: aload 11
    //   840: invokeinterface 388 1 0
    //   845: checkcast 746	com/tencent/mm/plugin/finder/live/viewmodel/data/h
    //   848: astore 12
    //   850: aload_1
    //   851: ldc 2
    //   853: invokevirtual 554	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   856: checkcast 2	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   859: getfield 306	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:zhw	Ljava/util/List;
    //   862: astore 13
    //   864: aload 13
    //   866: ldc_w 1227
    //   869: invokestatic 373	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   872: aload 13
    //   874: new 12	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f$c
    //   877: dup
    //   878: aload 12
    //   880: invokespecial 1243	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f$c:<init>	(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/h;)V
    //   883: checkcast 791	kotlin/g/a/b
    //   886: invokestatic 1081	com/tencent/mm/ae/d:a	(Ljava/util/List;Lkotlin/g/a/b;)Z
    //   889: istore 6
    //   891: iload 6
    //   893: ifeq +856 -> 1749
    //   896: iconst_1
    //   897: istore_3
    //   898: goto -70 -> 828
    //   901: aconst_null
    //   902: astore_2
    //   903: goto -731 -> 172
    //   906: astore_2
    //   907: ldc_w 809
    //   910: ldc_w 275
    //   913: iconst_1
    //   914: anewarray 811	java/lang/Object
    //   917: dup
    //   918: iconst_0
    //   919: aload_2
    //   920: aastore
    //   921: invokestatic 815	com/tencent/mm/sdk/platformtools/Log:printDebugStack	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   924: goto -745 -> 179
    //   927: aconst_null
    //   928: astore_2
    //   929: goto -691 -> 238
    //   932: aconst_null
    //   933: astore_2
    //   934: goto -658 -> 276
    //   937: aconst_null
    //   938: astore_2
    //   939: goto -634 -> 305
    //   942: aload_2
    //   943: invokevirtual 894	java/lang/Integer:intValue	()I
    //   946: iconst_3
    //   947: if_icmpne -526 -> 421
    //   950: ldc_w 346
    //   953: ldc_w 1245
    //   956: invokestatic 432	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   959: getstatic 1251	kotlin/x:aazN	Lkotlin/x;
    //   962: astore_2
    //   963: goto -844 -> 119
    //   966: aconst_null
    //   967: astore_2
    //   968: goto -407 -> 561
    //   971: astore_1
    //   972: aload 13
    //   974: monitorexit
    //   975: ldc_w 1203
    //   978: invokestatic 262	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   981: aload_1
    //   982: athrow
    //   983: aconst_null
    //   984: astore 11
    //   986: goto -343 -> 643
    //   989: aconst_null
    //   990: astore 12
    //   992: goto -318 -> 674
    //   995: aconst_null
    //   996: astore 13
    //   998: goto -293 -> 705
    //   1001: iconst_0
    //   1002: istore_3
    //   1003: goto -266 -> 737
    //   1006: iconst_0
    //   1007: istore 6
    //   1009: goto -260 -> 749
    //   1012: getstatic 1251	kotlin/x:aazN	Lkotlin/x;
    //   1015: astore 11
    //   1017: aload_2
    //   1018: monitorexit
    //   1019: aload_1
    //   1020: ldc 2
    //   1022: invokevirtual 554	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   1025: checkcast 2	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   1028: getfield 306	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:zhw	Ljava/util/List;
    //   1031: invokeinterface 1254 1 0
    //   1036: iload_3
    //   1037: ifeq +17 -> 1054
    //   1040: ldc_w 474
    //   1043: invokestatic 480	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1046: checkcast 474	com/tencent/mm/plugin/d
    //   1049: invokeinterface 1257 1 0
    //   1054: aload_1
    //   1055: ldc_w 335
    //   1058: invokevirtual 554	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   1061: checkcast 335	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   1064: invokevirtual 1091	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:dGU	()Ljava/lang/String;
    //   1067: astore 11
    //   1069: aload 17
    //   1071: getfield 1212	com/tencent/mm/protocal/protobuf/axg:SJL	Lcom/tencent/mm/protocal/protobuf/crw;
    //   1074: astore_2
    //   1075: aload_2
    //   1076: ifnull +473 -> 1549
    //   1079: aload_2
    //   1080: getfield 1217	com/tencent/mm/protocal/protobuf/crw:TyF	Ljava/lang/String;
    //   1083: astore_2
    //   1084: aload 11
    //   1086: aload_2
    //   1087: invokestatic 405	com/tencent/mm/sdk/platformtools/Util:isEqual	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1090: ifeq -131 -> 959
    //   1093: aload_1
    //   1094: ldc 2
    //   1096: invokevirtual 554	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   1099: checkcast 2	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   1102: iconst_0
    //   1103: putfield 777	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:zhn	I
    //   1106: aload_1
    //   1107: ldc_w 754
    //   1110: invokevirtual 554	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   1113: checkcast 754	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c
    //   1116: getfield 758	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c:liveInfo	Lcom/tencent/mm/protocal/protobuf/bac;
    //   1119: getfield 763	com/tencent/mm/protocal/protobuf/bac:liveId	J
    //   1122: lstore 9
    //   1124: aload 16
    //   1126: getfield 733	com/tencent/mm/protocal/protobuf/axe:session_id	Ljava/lang/String;
    //   1129: astore 19
    //   1131: aload 17
    //   1133: getfield 1212	com/tencent/mm/protocal/protobuf/axg:SJL	Lcom/tencent/mm/protocal/protobuf/crw;
    //   1136: astore_2
    //   1137: aload_2
    //   1138: ifnull +416 -> 1554
    //   1141: aload_2
    //   1142: getfield 1217	com/tencent/mm/protocal/protobuf/crw:TyF	Ljava/lang/String;
    //   1145: astore_2
    //   1146: aload 17
    //   1148: getfield 1212	com/tencent/mm/protocal/protobuf/axg:SJL	Lcom/tencent/mm/protocal/protobuf/crw;
    //   1151: astore 11
    //   1153: aload 11
    //   1155: ifnull +404 -> 1559
    //   1158: aload 11
    //   1160: getfield 1260	com/tencent/mm/protocal/protobuf/crw:Tzj	I
    //   1163: istore_3
    //   1164: aload 17
    //   1166: getfield 1212	com/tencent/mm/protocal/protobuf/axg:SJL	Lcom/tencent/mm/protocal/protobuf/crw;
    //   1169: astore 11
    //   1171: aload 11
    //   1173: ifnull +391 -> 1564
    //   1176: aload 11
    //   1178: getfield 1263	com/tencent/mm/protocal/protobuf/crw:Tzl	I
    //   1181: istore 4
    //   1183: aload 17
    //   1185: getfield 1212	com/tencent/mm/protocal/protobuf/axg:SJL	Lcom/tencent/mm/protocal/protobuf/crw;
    //   1188: astore 11
    //   1190: aload 11
    //   1192: ifnull +378 -> 1570
    //   1195: aload 11
    //   1197: getfield 1266	com/tencent/mm/protocal/protobuf/crw:Tzk	I
    //   1200: istore 5
    //   1202: aload 17
    //   1204: getfield 1212	com/tencent/mm/protocal/protobuf/axg:SJL	Lcom/tencent/mm/protocal/protobuf/crw;
    //   1207: astore 11
    //   1209: aload 11
    //   1211: ifnull +365 -> 1576
    //   1214: aload 11
    //   1216: getfield 1269	com/tencent/mm/protocal/protobuf/crw:Tzm	Lcom/tencent/mm/cd/b;
    //   1219: astore 11
    //   1221: aload 11
    //   1223: ifnull +353 -> 1576
    //   1226: aload 11
    //   1228: invokevirtual 1173	com/tencent/mm/cd/b:Ap	()Ljava/lang/String;
    //   1231: astore 11
    //   1233: aload 17
    //   1235: getfield 1212	com/tencent/mm/protocal/protobuf/axg:SJL	Lcom/tencent/mm/protocal/protobuf/crw;
    //   1238: astore 12
    //   1240: aload 12
    //   1242: ifnull +340 -> 1582
    //   1245: aload 12
    //   1247: getfield 1272	com/tencent/mm/protocal/protobuf/crw:Tzn	Lcom/tencent/mm/cd/b;
    //   1250: astore 12
    //   1252: aload 12
    //   1254: ifnull +328 -> 1582
    //   1257: aload 12
    //   1259: invokevirtual 1173	com/tencent/mm/cd/b:Ap	()Ljava/lang/String;
    //   1262: astore 12
    //   1264: aload 17
    //   1266: getfield 1212	com/tencent/mm/protocal/protobuf/axg:SJL	Lcom/tencent/mm/protocal/protobuf/crw;
    //   1269: astore 13
    //   1271: aload 13
    //   1273: ifnull +315 -> 1588
    //   1276: aload 13
    //   1278: getfield 1275	com/tencent/mm/protocal/protobuf/crw:Tzr	J
    //   1281: lstore 7
    //   1283: aload 17
    //   1285: getfield 1212	com/tencent/mm/protocal/protobuf/axg:SJL	Lcom/tencent/mm/protocal/protobuf/crw;
    //   1288: astore 13
    //   1290: aload 13
    //   1292: ifnull +302 -> 1594
    //   1295: aload 13
    //   1297: getfield 1278	com/tencent/mm/protocal/protobuf/crw:Tzo	Lcom/tencent/mm/cd/b;
    //   1300: astore 13
    //   1302: aload 13
    //   1304: ifnull +290 -> 1594
    //   1307: aload 13
    //   1309: getfield 1282	com/tencent/mm/cd/b:UH	[B
    //   1312: astore 13
    //   1314: new 906	com/tencent/mm/live/b/a
    //   1317: dup
    //   1318: lload 9
    //   1320: aload 19
    //   1322: aload_2
    //   1323: iload_3
    //   1324: iload 4
    //   1326: iload 5
    //   1328: aload 11
    //   1330: aload 12
    //   1332: lload 7
    //   1334: aload 13
    //   1336: aload 17
    //   1338: getfield 1222	com/tencent/mm/protocal/protobuf/axg:SJK	I
    //   1341: invokestatic 740	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1344: aload 17
    //   1346: getfield 1225	com/tencent/mm/protocal/protobuf/axg:seq	J
    //   1349: sipush 12288
    //   1352: invokespecial 1285	com/tencent/mm/live/b/a:<init>	(JLjava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;J[BLjava/lang/Integer;JI)V
    //   1355: astore_2
    //   1356: aload_1
    //   1357: ldc_w 335
    //   1360: invokevirtual 554	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   1363: checkcast 335	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   1366: invokevirtual 1091	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:dGU	()Ljava/lang/String;
    //   1369: aload_2
    //   1370: getfield 1184	com/tencent/mm/live/b/a:userId	Ljava/lang/String;
    //   1373: invokestatic 405	com/tencent/mm/sdk/platformtools/Util:isEqual	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1376: ifeq +286 -> 1662
    //   1379: ldc_w 474
    //   1382: invokestatic 480	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1385: checkcast 474	com/tencent/mm/plugin/d
    //   1388: aload_2
    //   1389: invokeinterface 1287 2 0
    //   1394: aload_1
    //   1395: ldc_w 335
    //   1398: invokevirtual 554	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   1401: checkcast 335	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b
    //   1404: invokevirtual 1290	com/tencent/mm/plugin/finder/live/viewmodel/data/business/b:dGJ	()I
    //   1407: istore_3
    //   1408: getstatic 1296	com/tencent/mm/live/core/core/e$b:kjz	Lcom/tencent/mm/live/core/core/e$b;
    //   1411: astore 11
    //   1413: iload_3
    //   1414: invokestatic 1299	com/tencent/mm/live/core/core/e$b:aJJ	()I
    //   1417: if_icmpne +183 -> 1600
    //   1420: getstatic 463	com/tencent/mm/live/b/p:kvF	Lcom/tencent/mm/live/b/p;
    //   1423: astore 11
    //   1425: invokestatic 467	com/tencent/mm/live/b/p:aOe	()Lcom/tencent/mm/live/b/g;
    //   1428: astore 11
    //   1430: aload 11
    //   1432: ifnull +15 -> 1447
    //   1435: aload 11
    //   1437: aload_2
    //   1438: invokeinterface 916 2 0
    //   1443: getstatic 1251	kotlin/x:aazN	Lkotlin/x;
    //   1446: astore_2
    //   1447: ldc_w 474
    //   1450: invokestatic 480	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1453: checkcast 474	com/tencent/mm/plugin/d
    //   1456: invokeinterface 1177 1 0
    //   1461: astore_2
    //   1462: aload_2
    //   1463: ifnull +12 -> 1475
    //   1466: aload_2
    //   1467: iconst_0
    //   1468: invokevirtual 1304	com/tencent/mm/live/core/core/trtc/a:muteLocalVideo	(Z)V
    //   1471: getstatic 1251	kotlin/x:aazN	Lkotlin/x;
    //   1474: astore_2
    //   1475: ldc_w 474
    //   1478: invokestatic 480	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1481: checkcast 474	com/tencent/mm/plugin/d
    //   1484: invokeinterface 1177 1 0
    //   1489: astore_2
    //   1490: aload_2
    //   1491: ifnull +12 -> 1503
    //   1494: aload_2
    //   1495: iconst_0
    //   1496: invokevirtual 1307	com/tencent/mm/live/core/core/trtc/a:muteLocalAudio	(Z)V
    //   1499: getstatic 1251	kotlin/x:aazN	Lkotlin/x;
    //   1502: astore_2
    //   1503: ldc_w 474
    //   1506: invokestatic 480	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1509: checkcast 474	com/tencent/mm/plugin/d
    //   1512: invokeinterface 1310 1 0
    //   1517: ldc_w 474
    //   1520: invokestatic 480	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1523: checkcast 474	com/tencent/mm/plugin/d
    //   1526: invokeinterface 1313 1 0
    //   1531: getstatic 1251	kotlin/x:aazN	Lkotlin/x;
    //   1534: astore_2
    //   1535: goto -576 -> 959
    //   1538: astore_1
    //   1539: aload_2
    //   1540: monitorexit
    //   1541: ldc_w 1203
    //   1544: invokestatic 262	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1547: aload_1
    //   1548: athrow
    //   1549: aconst_null
    //   1550: astore_2
    //   1551: goto -467 -> 1084
    //   1554: aconst_null
    //   1555: astore_2
    //   1556: goto -410 -> 1146
    //   1559: iconst_0
    //   1560: istore_3
    //   1561: goto -397 -> 1164
    //   1564: iconst_0
    //   1565: istore 4
    //   1567: goto -384 -> 1183
    //   1570: iconst_0
    //   1571: istore 5
    //   1573: goto -371 -> 1202
    //   1576: aconst_null
    //   1577: astore 11
    //   1579: goto -346 -> 1233
    //   1582: aconst_null
    //   1583: astore 12
    //   1585: goto -321 -> 1264
    //   1588: lconst_0
    //   1589: lstore 7
    //   1591: goto -308 -> 1283
    //   1594: aconst_null
    //   1595: astore 13
    //   1597: goto -283 -> 1314
    //   1600: aload_1
    //   1601: ldc_w 754
    //   1604: invokevirtual 554	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/x;
    //   1607: checkcast 754	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c
    //   1610: getfield 1317	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c:kvS	Lcom/tencent/mm/live/core/core/model/g;
    //   1613: astore 11
    //   1615: aload 11
    //   1617: ifnull -100 -> 1517
    //   1620: ldc_w 474
    //   1623: invokestatic 480	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1626: checkcast 474	com/tencent/mm/plugin/d
    //   1629: aload 11
    //   1631: new 10	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f$b
    //   1634: dup
    //   1635: aload_2
    //   1636: aload 18
    //   1638: aload 17
    //   1640: aload 16
    //   1642: aload_0
    //   1643: aload_1
    //   1644: invokespecial 1320	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f$b:<init>	(Lcom/tencent/mm/live/b/a;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/axg;Lcom/tencent/mm/protocal/protobuf/axe;Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/f;Lcom/tencent/mm/plugin/finder/live/model/context/a;)V
    //   1647: checkcast 791	kotlin/g/a/b
    //   1650: invokeinterface 1323 3 0
    //   1655: getstatic 1251	kotlin/x:aazN	Lkotlin/x;
    //   1658: astore_2
    //   1659: goto -142 -> 1517
    //   1662: getstatic 463	com/tencent/mm/live/b/p:kvF	Lcom/tencent/mm/live/b/p;
    //   1665: astore 11
    //   1667: invokestatic 467	com/tencent/mm/live/b/p:aOe	()Lcom/tencent/mm/live/b/g;
    //   1670: astore 11
    //   1672: aload 11
    //   1674: ifnull -143 -> 1531
    //   1677: aload 11
    //   1679: aload_2
    //   1680: invokeinterface 916 2 0
    //   1685: getstatic 1251	kotlin/x:aazN	Lkotlin/x;
    //   1688: astore_2
    //   1689: goto -158 -> 1531
    //   1692: ldc_w 346
    //   1695: new 348	java/lang/StringBuilder
    //   1698: dup
    //   1699: ldc_w 1325
    //   1702: invokespecial 352	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1705: aload 14
    //   1707: invokevirtual 940	java/util/LinkedList:size	()I
    //   1710: invokevirtual 356	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1713: ldc_w 822
    //   1716: invokevirtual 413	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1719: ldc_w 474
    //   1722: invokestatic 480	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1725: checkcast 474	com/tencent/mm/plugin/d
    //   1728: invokeinterface 711 1 0
    //   1733: invokevirtual 825	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1736: invokevirtual 359	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1739: invokestatic 432	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1742: ldc_w 1203
    //   1745: invokestatic 262	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1748: return
    //   1749: goto -851 -> 898
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1752	0	this	f
    //   0	1752	1	parama	com.tencent.mm.plugin.finder.live.model.context.a
    //   736	825	3	i	int
    //   710	856	4	j	int
    //   1200	372	5	k	int
    //   551	457	6	bool	boolean
    //   1281	309	7	l1	long
    //   1122	197	9	l2	long
    //   19	1659	11	localObject1	Object
    //   58	1526	12	localObject2	Object
    //   13	1693	14	localLinkedList	LinkedList
    //   117	13	15	localIterator	Iterator
    //   139	1502	16	localaxe	axe
    //   148	1491	17	localaxg	axg
    //   372	1265	18	str1	String
    //   484	837	19	localObject4	Object
    //   510	240	20	localObject5	Object
    //   717	48	21	str2	String
    //   724	8	22	localaza	aza
    // Exception table:
    //   from	to	target	type
    //   172	179	906	java/lang/Exception
    //   477	486	971	finally
    //   486	518	971	finally
    //   522	528	971	finally
    //   536	542	971	finally
    //   542	553	971	finally
    //   818	826	1538	finally
    //   828	891	1538	finally
    //   1012	1017	1538	finally
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(258335);
    this.zhj.clear();
    this.zhk.clear();
    this.zhl = null;
    this.zhn = 0;
    this.zho = 0;
    this.zhq = -1;
    this.zhr = false;
    this.zhs = false;
    this.zht = true;
    this.zhi = "";
    this.zhh = 0L;
    this.zhp = 0;
    this.zhv.clear();
    this.zhu = null;
    this.zhw.clear();
    this.zhx = new cxh();
    this.zhy = false;
    this.zhz = null;
    AppMethodBeat.o(258335);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveLinkMicSlice$Companion;", "", "()V", "TAG", "", "plugin-finder-base_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errCode", "", "invoke", "com/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveLinkMicSlice$checkLinkAcceptMsg$1$1$2$1$1", "com/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveLinkMicSlice$$special$$inlined$let$lambda$1", "com/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveLinkMicSlice$$special$$inlined$apply$lambda$1", "com/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveLinkMicSlice$$special$$inlined$let$lambda$2"})
  static final class b
    extends q
    implements kotlin.g.a.b<Integer, kotlin.x>
  {
    b(com.tencent.mm.live.b.a parama, String paramString, axg paramaxg, axe paramaxe, f paramf, com.tencent.mm.plugin.finder.live.model.context.a parama1)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "pendingUser", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    c(com.tencent.mm.plugin.finder.live.viewmodel.data.h paramh)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveLinkMicSlice$checkLinkCloseMsg$1$1$1", "com/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveLinkMicSlice$$special$$inlined$let$lambda$3"})
  static final class d
    extends q
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    d(axe paramaxe, axo paramaxo, f paramf)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveLinkMicSlice$checkLinkCloseMsg$1$1$2", "com/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveLinkMicSlice$$special$$inlined$let$lambda$4"})
  static final class e
    extends q
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    e(axe paramaxe, axo paramaxo, f paramf)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveLinkMicSlice$checkLinkCloseMsg$1$1$3", "com/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveLinkMicSlice$$special$$inlined$let$lambda$5"})
  static final class f
    extends q
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    f(axe paramaxe, axo paramaxo, f paramf)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveLinkMicSlice$checkLinkCloseMsg$1$1$4", "com/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveLinkMicSlice$$special$$inlined$let$lambda$6"})
  static final class g
    extends q
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    g(axe paramaxe, axo paramaxo, f paramf)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveLinkMicSlice$checkLinkClosePkMsg$1$1$1", "com/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveLinkMicSlice$$special$$inlined$let$lambda$7"})
  static final class h
    extends q
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    h(axe paramaxe, axp paramaxp, f paramf)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveLinkMicSlice$checkLinkClosePkMsg$1$1$2", "com/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveLinkMicSlice$$special$$inlined$let$lambda$8"})
  static final class i
    extends q
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    i(axe paramaxe, axp paramaxp, f paramf)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "user", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveLinkMicSlice$handleLinkMicMsg$1$1$1", "com/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveLinkMicSlice$$special$$inlined$let$lambda$9"})
  public static final class j
    extends q
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    public j(axk paramaxk, axe paramaxe, f paramf)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "user", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveLinkMicSlice$handleLinkMicMsg$1$1$2", "com/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveLinkMicSlice$$special$$inlined$let$lambda$10"})
  public static final class k
    extends q
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    public k(axk paramaxk, axe paramaxe, f paramf)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "user", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType", "invoke"})
  public static final class l
    extends q
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    public static final l zhT;
    
    static
    {
      AppMethodBeat.i(258088);
      zhT = new l();
      AppMethodBeat.o(258088);
    }
    
    l()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "user", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType", "invoke"})
  public static final class m
    extends q
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    public static final m zhU;
    
    static
    {
      AppMethodBeat.i(263962);
      zhU = new m();
      AppMethodBeat.o(263962);
    }
    
    m()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "user", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType", "invoke"})
  public static final class n
    extends q
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    public static final n zhV;
    
    static
    {
      AppMethodBeat.i(263646);
      zhV = new n();
      AppMethodBeat.o(263646);
    }
    
    n()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "user", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType", "invoke"})
  public static final class o
    extends q
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    public static final o zhW;
    
    static
    {
      AppMethodBeat.i(263106);
      zhW = new o();
      AppMethodBeat.o(263106);
    }
    
    o()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "user", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType", "invoke"})
  public static final class p
    extends q
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    public static final p zhX;
    
    static
    {
      AppMethodBeat.i(263179);
      zhX = new p();
      AppMethodBeat.o(263179);
    }
    
    p()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "user", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType", "invoke"})
  public static final class q
    extends q
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    public static final q zhY;
    
    static
    {
      AppMethodBeat.i(258171);
      zhY = new q();
      AppMethodBeat.o(258171);
    }
    
    q()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "user", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveLinkMicSlice$handleLinkMicPkMsg$1$1$1", "com/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveLinkMicSlice$$special$$inlined$let$lambda$11"})
  public static final class r
    extends q
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    public r(axl paramaxl, axe paramaxe, f paramf)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "user", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveLinkMicSlice$handleLinkMicPkMsg$1$1$2", "com/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveLinkMicSlice$$special$$inlined$let$lambda$12"})
  public static final class s
    extends q
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    public s(axl paramaxl, axe paramaxe, f paramf)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType", "invoke"})
  public static final class t
    extends q
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.h, Boolean>
  {
    public t(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.business.f
 * JD-Core Version:    0.7.0.1
 */