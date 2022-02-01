package com.tencent.mm.plugin.finder.live.model;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.j;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.l;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.utils.bj;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aui;
import com.tencent.mm.protocal.protobuf.bcc;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bek;
import com.tencent.mm.protocal.protobuf.bet;
import com.tencent.mm.protocal.protobuf.bfl;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.protocal.protobuf.bgy;
import com.tencent.mm.protocal.protobuf.bha;
import com.tencent.mm.protocal.protobuf.bim;
import com.tencent.mm.protocal.protobuf.biv;
import com.tencent.mm.protocal.protobuf.bke;
import com.tencent.mm.protocal.protobuf.bof;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.cbs;
import com.tencent.mm.protocal.protobuf.dle;
import com.tencent.mm.protocal.protobuf.dom;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.bke;>;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.k.g;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveMsgManager;", "", "()V", "TAG", "", "msgInCommentList", "", "saveMyselfComment", "", "getSaveMyselfComment", "()Z", "setSaveMyselfComment", "(Z)V", "appendAudioModeTip", "", "roomData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "appendGameTeamModeTip", "appendGiftTip", "appendJumpGameInfo", "gameLiveJumpInfo", "Lcom/tencent/mm/protocal/protobuf/GameLiveJumpInfo;", "appendLinkMicTip", "appendLocationTip", "appendMicSettingTip", "appendOfficialAccountTips", "userInfo", "Lcom/tencent/mm/protocal/protobuf/FinderBizUserInfo;", "appendSysLawTip", "appendWelcomeTip", "joinLiveRespLiveDesc", "checkCommentListSize", "liveRoomData", "remoteLiveMsg", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "maxCount", "", "checkCommentListSizeSaveMySelf", "liveroomData", "checkGameInfoValid", "filterCommentMsgForExternal", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/MMFinderLiveRoomMsg;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "remoteLiveAppMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ab
{
  private static boolean CBP;
  public static final ab CGy;
  private static final int[] CGz;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(359378);
    CGy = new ab();
    TAG = "Finder.FinderLiveMsgManager";
    CBP = true;
    com.tencent.d.a.a.a.a.a locala = com.tencent.d.a.a.a.a.a.ahiX;
    int i = ((Number)com.tencent.d.a.a.a.a.a.jSD().bmg()).intValue();
    if (i == 0) {}
    for (boolean bool = true;; bool = false)
    {
      CBP = bool;
      Log.i(TAG, s.X("saveMyselfCommentValue:", Integer.valueOf(i)));
      CGz = new int[] { 1, 10007, 10008, 100000, 10006, 20001, 20002, 20013, 20014, 20019, 20020, 20031, 20035, 20031, 20032, 20034, 1000066 };
      AppMethodBeat.o(359378);
      return;
    }
  }
  
  public static void a(com.tencent.mm.plugin.finder.live.model.context.a parama, aui paramaui)
  {
    kotlin.ah localah = null;
    AppMethodBeat.i(359332);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("#appendOfficialAccountTips nick=");
    if (paramaui == null)
    {
      localObject = null;
      localStringBuilder = localStringBuilder.append(localObject).append(" user=");
      if (paramaui != null) {
        break label84;
      }
    }
    label84:
    for (Object localObject = localah;; localObject = paramaui.ADE)
    {
      Log.i(str, localObject);
      if ((parama != null) && (paramaui != null)) {
        break label92;
      }
      AppMethodBeat.o(359332);
      return;
      localObject = paramaui.YTl;
      break;
    }
    label92:
    localObject = new bke();
    ((bke)localObject).type = 10019;
    ((bke)localObject).content = paramaui.YTl;
    localah = kotlin.ah.aiuX;
    localObject = new ac((bke)localObject, paramaui);
    ((l)parama.business(l.class)).EgE.add(localObject);
    com.tencent.mm.plugin.finder.live.report.k.Doi.d(false, paramaui.ADE, paramaui.YTl);
    AppMethodBeat.o(359332);
  }
  
  public static void a(com.tencent.mm.plugin.finder.live.model.context.a parama, cbs paramcbs)
  {
    AppMethodBeat.i(359346);
    Object localObject2 = TAG;
    ??? = new StringBuilder("#appendJumpGameInfo: game_name:");
    if (paramcbs == null)
    {
      localObject1 = null;
      ??? = ((StringBuilder)???).append(localObject1).append(", game_type:");
      if (paramcbs != null) {
        break label129;
      }
      localObject1 = null;
      label49:
      ??? = ((StringBuilder)???).append(localObject1).append(", is_show_entrance:");
      if (paramcbs != null) {
        break label141;
      }
      localObject1 = null;
      label70:
      ??? = ((StringBuilder)???).append(localObject1).append(", report_info:");
      if (paramcbs != null) {
        break label153;
      }
    }
    label129:
    label141:
    label153:
    for (Object localObject1 = null;; localObject1 = paramcbs.report_info)
    {
      Log.i((String)localObject2, localObject1);
      if ((parama != null) && (paramcbs != null)) {
        break label162;
      }
      AppMethodBeat.o(359346);
      return;
      localObject1 = paramcbs.Idi;
      break;
      localObject1 = Integer.valueOf(paramcbs.aakj);
      break label49;
      localObject1 = Boolean.valueOf(paramcbs.ZSq);
      break label70;
    }
    label162:
    int i;
    if (paramcbs == null)
    {
      localObject1 = null;
      if ((localObject1 != null) && (paramcbs.ZSq)) {
        break label213;
      }
      i = 0;
    }
    label329:
    for (;;)
    {
      if (i != 0) {
        break label405;
      }
      Log.e(TAG, "appendJumpGameInfo terminated, checkGameInfoValid failed");
      AppMethodBeat.o(359346);
      return;
      localObject1 = Boolean.valueOf(paramcbs.ZSq);
      break;
      label213:
      switch (paramcbs.aakj)
      {
      default: 
        Log.e(TAG, s.X("checkGameInfoValid failed, wrong gameType:", Integer.valueOf(paramcbs.aakj)));
        i = 0;
        break;
      case 1: 
        localObject1 = paramcbs.aala;
        if (localObject1 == null) {
          localObject1 = null;
        }
        for (;;)
        {
          if ((localObject1 == null) || (!s.p(localObject1, Boolean.TRUE))) {
            break label329;
          }
          i = 1;
          break;
          localObject1 = ((bgy)localObject1).ZQu;
          if (localObject1 == null) {
            localObject1 = null;
          } else {
            localObject1 = Boolean.valueOf(((biv)localObject1).ZSq);
          }
        }
        i = 0;
        break;
      case 2: 
        localObject1 = paramcbs.aalb;
        if (localObject1 == null) {
          localObject1 = null;
        }
        for (;;)
        {
          if ((localObject1 == null) || (!s.p(localObject1, Boolean.TRUE))) {
            break label400;
          }
          i = 1;
          break;
          localObject1 = ((bof)localObject1).ZQu;
          if (localObject1 == null) {
            localObject1 = null;
          } else {
            localObject1 = Boolean.valueOf(((biv)localObject1).ZSq);
          }
        }
        i = 0;
      }
    }
    label400:
    label405:
    localObject1 = new bke();
    ((bke)localObject1).type = 20040;
    ((bke)localObject1).content = paramcbs.Idi;
    localObject2 = kotlin.ah.aiuX;
    localObject2 = new w((bke)localObject1, paramcbs);
    localObject1 = ((l)parama.business(l.class)).EgE;
    s.s(localObject1, "roomData.business(LiveMs…lice::class.java).msgList");
    synchronized ((Iterable)localObject1)
    {
      Iterator localIterator = ((Iterable)???).iterator();
      while (localIterator.hasNext())
      {
        localObject1 = localIterator.next();
        aq localaq = (aq)localObject1;
        if (localaq.getType() == 20040)
        {
          boolean bool = Util.isEqual(localaq.getContent(), ((w)localObject2).getContent());
          if (!bool) {}
        }
        for (i = 1; i != 0; i = 0)
        {
          if (localObject1 == null) {
            ((l)parama.business(l.class)).EgE.add(localObject2);
          }
          com.tencent.mm.plugin.finder.live.report.k.Doi.axy(paramcbs.report_info);
          AppMethodBeat.o(359346);
          return;
        }
      }
      localObject1 = null;
    }
  }
  
  public static void b(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(359288);
    Object localObject1;
    String str;
    Object localObject2;
    if (parama != null)
    {
      localObject1 = bj.GlQ;
      if (!bj.y(parama))
      {
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Ecn;
        if (localObject1 != null)
        {
          str = ((bcc)localObject1).ZNk;
          if (str != null)
          {
            localObject1 = new bke();
            ((bke)localObject1).type = 10001;
            ((bke)localObject1).content = str;
            localObject2 = kotlin.ah.aiuX;
            localObject2 = new am((bke)localObject1);
            localObject1 = ((l)parama.business(l.class)).EgE;
            s.s(localObject1, "roomData.business(LiveMs…lice::class.java).msgList");
          }
        }
      }
    }
    synchronized ((Iterable)localObject1)
    {
      Iterator localIterator = ???.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = localIterator.next();
        aq localaq = (aq)localObject1;
        if (localaq.getType() == 10001)
        {
          boolean bool = s.p(str, localaq.getContent());
          if (!bool) {}
        }
        for (int i = 1; i != 0; i = 0)
        {
          if (localObject1 == null) {
            ((l)parama.business(l.class)).EgE.add(0, localObject2);
          }
          Log.i(TAG, s.X("appendSysLawTip:", ((am)localObject2).CIc.content));
          AppMethodBeat.o(359288);
          return;
        }
      }
      localObject1 = null;
    }
  }
  
  public static void b(com.tencent.mm.plugin.finder.live.model.context.a parama, String paramString)
  {
    int k = 0;
    AppMethodBeat.i(359303);
    Object localObject1;
    int i;
    if (parama != null)
    {
      localObject1 = (CharSequence)paramString;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label473;
      }
      i = 1;
      if (i != 0) {
        break label478;
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).desc = paramString;
      label54:
      localObject1 = ((l)parama.business(l.class)).EgE;
      s.s(localObject1, "roomData.business(LiveMs…lice::class.java).msgList");
    }
    for (;;)
    {
      try
      {
        localObject2 = ((List)localObject1).iterator();
        i = 0;
        if (((Iterator)localObject2).hasNext())
        {
          int j = ((aq)((Iterator)localObject2).next()).getType();
          if (j == 100000)
          {
            j = 1;
            if (j == 0) {
              continue;
            }
            localObject1 = TAG;
            localObject2 = new StringBuilder("[START_LIVE], desc is empty:");
            Object localObject3 = (CharSequence)paramString;
            if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
              break label650;
            }
            bool = true;
            localObject2 = ((StringBuilder)localObject2).append(bool).append(", containWelcomeMsg:");
            if (i == -1) {
              break label656;
            }
            bool = true;
            Log.i((String)localObject1, bool);
            localObject1 = (CharSequence)paramString;
            if (localObject1 != null)
            {
              j = k;
              if (((CharSequence)localObject1).length() != 0) {}
            }
            else
            {
              j = 1;
            }
            if ((j == 0) && (i == -1))
            {
              FinderObject localFinderObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eco;
              if (localFinderObject != null)
              {
                localObject3 = new bke();
                bgh localbgh = new bgh();
                FinderContact localFinderContact = new FinderContact();
                localObject1 = localFinderObject.contact;
                if (localObject1 != null) {
                  break label662;
                }
                localObject1 = "";
                localFinderContact.username = ((String)localObject1);
                localObject1 = localFinderObject.contact;
                if (localObject1 != null) {
                  break label686;
                }
                localObject1 = "";
                localFinderContact.nickname = ((String)localObject1);
                localObject1 = localFinderObject.contact;
                if (localObject1 != null) {
                  break label710;
                }
                localObject1 = "";
                localFinderContact.headUrl = ((String)localObject1);
                localObject1 = kotlin.ah.aiuX;
                localbgh.contact = localFinderContact;
                localObject1 = kotlin.ah.aiuX;
                ((bke)localObject3).EbJ = localbgh;
                localObject1 = paramString;
                if (paramString == null) {
                  localObject1 = "";
                }
                ((bke)localObject3).content = ((String)localObject1);
                ((bke)localObject3).type = 100000;
                paramString = kotlin.ah.aiuX;
                paramString = new am((bke)localObject3);
                ((l)parama.business(l.class)).EgE.add(paramString);
                Log.i(TAG, s.X("appendWelcomeTip:", paramString.CIc.content));
              }
            }
            AppMethodBeat.o(359303);
            return;
            label473:
            i = 0;
            break;
            label478:
            paramString = (CharSequence)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).desc;
            if ((paramString == null) || (paramString.length() == 0))
            {
              i = 1;
              if (i != 0) {
                continue;
              }
              paramString = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).desc;
              break label54;
            }
            i = 0;
            continue;
            if (((f)parama.business(f.class)).EeY == null)
            {
              paramString = com.tencent.mm.plugin.finder.storage.data.e.FMN;
              paramString = com.tencent.mm.plugin.finder.storage.data.e.a.jn(((f)parama.business(f.class)).hKN);
              if (paramString == null)
              {
                paramString = null;
                break label54;
              }
              paramString = paramString.getDescription();
              break label54;
            }
            paramString = ((f)parama.business(f.class)).EeY;
            if (paramString == null)
            {
              paramString = null;
              break label54;
            }
            paramString = paramString.description;
            break label54;
          }
          j = 0;
          continue;
          i += 1;
          continue;
        }
        i = -1;
        continue;
        bool = false;
      }
      finally
      {
        AppMethodBeat.o(359303);
      }
      label650:
      continue;
      label656:
      boolean bool = false;
      continue;
      label662:
      Object localObject2 = ((FinderContact)localObject1).username;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = "";
        continue;
        label686:
        localObject2 = ((FinderContact)localObject1).nickname;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = "";
          continue;
          label710:
          localObject2 = ((FinderContact)localObject1).headUrl;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
        }
      }
    }
  }
  
  public static void b(com.tencent.mm.plugin.finder.live.model.context.a parama, LinkedList<aq> paramLinkedList)
  {
    AppMethodBeat.i(359241);
    s.u(parama, "liveRoomData");
    s.u(paramLinkedList, "remoteLiveMsg");
    parama = (l)parama.business(l.class);
    if (parama != null)
    {
      List localList = ((l)parama.business(l.class)).EgE;
      int k = 1000 - (localList.size() + paramLinkedList.size());
      if (k < 0)
      {
        int i = ((l)parama.business(l.class)).EgI;
        int j = ((l)parama.business(l.class)).EgE.size() - 1 - i;
        if ((((l)parama.business(l.class)).EgI >= 0) && (j > 0))
        {
          k = -k;
          if (j > k)
          {
            s.s(localList, "commentList");
            localList.removeAll((Collection)p.a(localList, new g(i + 1, k + i)));
            AppMethodBeat.o(359241);
            return;
          }
          s.s(localList, "commentList");
          localList.removeAll((Collection)p.a(localList, kotlin.k.k.qt(i + 1, ((l)parama.business(l.class)).EgE.size())));
          AppMethodBeat.o(359241);
          return;
        }
        s.s(localList, "commentList");
        localList.removeAll((Collection)p.c((Iterable)localList, -k));
      }
    }
    AppMethodBeat.o(359241);
  }
  
  public static void c(com.tencent.mm.plugin.finder.live.model.context.a parama, LinkedList<aq> paramLinkedList)
  {
    AppMethodBeat.i(359253);
    s.u(parama, "liveroomData");
    s.u(paramLinkedList, "remoteLiveMsg");
    parama = (l)parama.business(l.class);
    if (parama != null) {}
    for (;;)
    {
      int i;
      Object localObject1;
      int j;
      label125:
      Object localObject2;
      try
      {
        parama = parama.EgE;
        i = paramLinkedList.size();
        i = parama.size() + i;
        if (i <= 1000) {
          break label477;
        }
        k = i - 800;
        Log.i(TAG, "checkCommentListSizeSaveMySelf maxCount:1000, totalMsgSize;" + i + ", removeSize:" + k);
        if (k > 0)
        {
          localObject1 = new LinkedList();
          Iterator localIterator = parama.iterator();
          j = 0;
          i = j;
          aw localaw;
          if (localIterator.hasNext())
          {
            localObject2 = localIterator.next();
            s.s(localObject2, "localMsgIterator.next()");
            localObject2 = (aq)localObject2;
            localaw = aw.Gjk;
            if (!aw.aBI(((aq)localObject2).djQ()))
            {
              localIterator.remove();
              i = j + 1;
              break label483;
            }
          }
          else
          {
            label193:
            if (i >= k) {
              break label472;
            }
            localIterator = paramLinkedList.iterator();
            s.s(localIterator, "remoteLiveMsg.iterator()");
            j = i;
            label215:
            if (!localIterator.hasNext()) {
              break label466;
            }
            localObject2 = localIterator.next();
            s.s(localObject2, "remoteMsgIterator.next()");
            localObject2 = (aq)localObject2;
            localaw = aw.Gjk;
            if (aw.aBI(((aq)localObject2).djQ())) {
              break label449;
            }
            localIterator.remove();
            j += 1;
            break label494;
            label281:
            k = ((LinkedList)localObject1).size();
            if (k <= 500) {
              break label460;
            }
            k -= 400;
            localObject1 = p.a((List)localObject1, new g(0, k));
            parama.removeAll((Collection)localObject1);
            paramLinkedList.removeAll((Collection)localObject1);
            Log.i(TAG, "checkCommentListSizeSaveMySelf localMsgRemoveSize:" + i + ",remoteMsgRemoveSize:" + (j - i) + ",myselfRemoveSize:" + k);
            AppMethodBeat.o(359253);
            return;
          }
          ((LinkedList)localObject1).add(localObject2);
          i = j;
        }
      }
      catch (Exception parama)
      {
        com.tencent.mm.ae.e.a.a((com.tencent.mm.ae.e)com.tencent.mm.plugin.findersdk.b.HbT, "liveCheckCommentMsgErr", false, null, false, null, 60);
        paramLinkedList = aw.Gjk;
        aw.a(parama, "checkCommentListSizeSaveMySelf");
      }
      AppMethodBeat.o(359253);
      return;
      label449:
      ((LinkedList)localObject1).add(localObject2);
      break label494;
      label460:
      int k = 0;
      continue;
      label466:
      label472:
      label477:
      label483:
      label494:
      while (j < k)
      {
        break label215;
        j = i;
        break label281;
        k = 0;
        break;
        j = i;
        if (i < k) {
          break label125;
        }
        break label193;
      }
    }
  }
  
  public static void d(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(359319);
    Object localObject1;
    Object localObject2;
    int i;
    if (parama != null)
    {
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).location;
      if (localObject1 != null)
      {
        localObject2 = (CharSequence)((boi)localObject1).poiName;
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          break label325;
        }
        i = 1;
      }
    }
    for (;;)
    {
      label60:
      label64:
      Object localObject3;
      if (i == 0)
      {
        i = 1;
        if (i == 0) {
          break label335;
        }
        if (localObject1 != null)
        {
          localObject2 = new bke();
          ((bke)localObject2).type = 10018;
          ((bke)localObject2).content = (((boi)localObject1).city + " • " + ((boi)localObject1).poiName);
          localObject3 = kotlin.ah.aiuX;
          localObject3 = new x((bke)localObject2, (boi)localObject1);
          localObject2 = ((l)parama.business(l.class)).EgE;
          s.s(localObject2, "roomData.business(LiveMs…lice::class.java).msgList");
        }
      }
      synchronized ((Iterable)localObject2)
      {
        Iterator localIterator = ???.iterator();
        label325:
        label335:
        label343:
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label345;
          }
          localObject2 = localIterator.next();
          aq localaq = (aq)localObject2;
          if (localaq.getType() == 10018)
          {
            boolean bool = s.p(((boi)localObject1).city + " • " + ((boi)localObject1).poiName, localaq.getContent());
            if (!bool) {}
          }
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label343;
            }
            localObject1 = localObject2;
            if (localObject1 == null) {
              ((l)parama.business(l.class)).EgE.add(localObject3);
            }
            Log.i(TAG, s.X("appendLocationTip:", ((am)localObject3).CIc.content));
            AppMethodBeat.o(359319);
            return;
            i = 0;
            break;
            i = 0;
            break label60;
            localObject1 = null;
            break label64;
          }
        }
        label345:
        localObject1 = null;
      }
    }
  }
  
  public static void e(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(359356);
    Object localObject2 = TAG;
    if (parama == null)
    {
      localObject1 = null;
      Log.i((String)localObject2, s.X("appendGameTeamModeTip:", localObject1));
      if (parama == null) {
        break label120;
      }
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if (localObject1 == null) {
        break label120;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).CFy;
      if ((localObject1 == null) || (((bha)localObject1).ZQz != 0)) {
        break label120;
      }
    }
    label120:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label125;
      }
      AppMethodBeat.o(359356);
      return;
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).CFy;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = Integer.valueOf(((bha)localObject1).ZQz);
      break;
    }
    label125:
    if (parama != null)
    {
      localObject2 = new bke();
      ((bke)localObject2).type = 10001;
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).CFy;
      if ((localObject1 == null) || (((bha)localObject1).ZQz != 1)) {
        break label233;
      }
      i = 1;
      if (i == 0) {
        break label238;
      }
    }
    label233:
    label238:
    for (Object localObject1 = MMApplicationContext.getContext().getResources().getString(p.h.finder_game_live_team_join_off);; localObject1 = MMApplicationContext.getContext().getResources().getString(p.h.finder_game_live_team_join_on))
    {
      ((bke)localObject2).content = ((String)localObject1);
      localObject1 = kotlin.ah.aiuX;
      localObject1 = new am((bke)localObject2);
      ((l)parama.business(l.class)).EgE.add(localObject1);
      AppMethodBeat.o(359356);
      return;
      i = 0;
      break;
    }
  }
  
  public static ArrayList<dle> f(LinkedList<bke> paramLinkedList, LinkedList<bdm> paramLinkedList1)
  {
    AppMethodBeat.i(359279);
    s.u(paramLinkedList, "remoteLiveMsg");
    s.u(paramLinkedList1, "remoteLiveAppMsg");
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = ((Iterable)paramLinkedList).iterator();
    Object localObject3;
    Object localObject4;
    label116:
    int i;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (bke)((Iterator)localObject2).next();
      if (kotlin.a.k.contains(CGz, ((bke)localObject3).type))
      {
        localObject4 = new dle();
        paramLinkedList = com.tencent.mm.plugin.finder.utils.t.GgN;
        ((dle)localObject4).msgType = com.tencent.mm.plugin.finder.utils.t.TV(((bke)localObject3).type);
        paramLinkedList = ((bke)localObject3).EbJ;
        if (paramLinkedList == null)
        {
          paramLinkedList = "";
          ((dle)localObject4).aaRb = paramLinkedList;
          paramLinkedList = ((bke)localObject3).EbJ;
          if (paramLinkedList != null) {
            break label249;
          }
          paramLinkedList = "";
          label136:
          ((dle)localObject4).aaRf = paramLinkedList;
          ((dle)localObject4).content = ((bke)localObject3).content;
          ((dle)localObject4).aaRd = ((bke)localObject3).seq;
          ((dle)localObject4).kLn = ((bke)localObject3).kLn;
          ((dle)localObject4).ZTp = ((bke)localObject3).ZTp;
          paramLinkedList = ((bke)localObject3).EbJ;
          if (paramLinkedList != null) {
            break label283;
          }
          i = 0;
        }
        for (;;)
        {
          ((dle)localObject4).aaRe = i;
          paramLinkedList = kotlin.ah.aiuX;
          localArrayList.add(localObject4);
          break;
          paramLinkedList = paramLinkedList.contact;
          if (paramLinkedList == null)
          {
            paramLinkedList = "";
            break label116;
          }
          localObject1 = paramLinkedList.nickname;
          paramLinkedList = (LinkedList<bke>)localObject1;
          if (localObject1 != null) {
            break label116;
          }
          paramLinkedList = "";
          break label116;
          label249:
          paramLinkedList = paramLinkedList.contact;
          if (paramLinkedList == null)
          {
            paramLinkedList = "";
            break label136;
          }
          localObject1 = paramLinkedList.headUrl;
          paramLinkedList = (LinkedList<bke>)localObject1;
          if (localObject1 != null) {
            break label136;
          }
          paramLinkedList = "";
          break label136;
          label283:
          paramLinkedList = paramLinkedList.ZJX;
          if (paramLinkedList == null) {
            i = 0;
          } else {
            i = paramLinkedList.ZPr;
          }
        }
      }
      if (((bke)localObject3).type == 10005)
      {
        localObject4 = new dle();
        paramLinkedList = com.tencent.mm.plugin.finder.utils.t.GgN;
        ((dle)localObject4).msgType = com.tencent.mm.plugin.finder.utils.t.TV(((bke)localObject3).type);
        paramLinkedList = ((bke)localObject3).EbJ;
        if (paramLinkedList == null)
        {
          paramLinkedList = "";
          label356:
          ((dle)localObject4).aaRb = paramLinkedList;
          paramLinkedList = ((bke)localObject3).EbJ;
          if (paramLinkedList != null) {
            break label475;
          }
          paramLinkedList = "";
        }
        for (;;)
        {
          ((dle)localObject4).aaRf = paramLinkedList;
          ((dle)localObject4).content = MMApplicationContext.getContext().getString(p.h.CoK);
          ((dle)localObject4).aaRd = ((bke)localObject3).seq;
          ((dle)localObject4).kLn = ((bke)localObject3).kLn;
          ((dle)localObject4).ZTp = ((bke)localObject3).ZTp;
          paramLinkedList = kotlin.ah.aiuX;
          localArrayList.add(localObject4);
          break;
          paramLinkedList = paramLinkedList.contact;
          if (paramLinkedList == null)
          {
            paramLinkedList = "";
            break label356;
          }
          localObject1 = paramLinkedList.nickname;
          paramLinkedList = (LinkedList<bke>)localObject1;
          if (localObject1 != null) {
            break label356;
          }
          paramLinkedList = "";
          break label356;
          label475:
          paramLinkedList = paramLinkedList.contact;
          if (paramLinkedList == null)
          {
            paramLinkedList = "";
          }
          else
          {
            localObject1 = paramLinkedList.headUrl;
            paramLinkedList = (LinkedList<bke>)localObject1;
            if (localObject1 == null) {
              paramLinkedList = "";
            }
          }
        }
      }
    }
    Object localObject1 = ((Iterable)paramLinkedList1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (bdm)((Iterator)localObject1).next();
      switch (((bdm)localObject2).msg_type)
      {
      default: 
        break;
      case 20002: 
        localObject3 = new dle();
        paramLinkedList = com.tencent.mm.plugin.finder.utils.t.GgN;
        ((dle)localObject3).msgType = com.tencent.mm.plugin.finder.utils.t.TV(((bdm)localObject2).msg_type);
        localObject4 = MMApplicationContext.getContext();
        i = p.h.Cta;
        paramLinkedList = com.tencent.mm.plugin.finder.utils.t.GgN;
        paramLinkedList = ((bdm)localObject2).ZOb;
        if (paramLinkedList == null)
        {
          paramLinkedList = "";
          String str = com.tencent.mm.plugin.finder.utils.t.aBy(paramLinkedList);
          paramLinkedList = com.tencent.mm.plugin.finder.utils.t.GgN;
          paramLinkedList = ((bdm)localObject2).ZNW;
          if (paramLinkedList != null) {
            break label829;
          }
          paramLinkedList = "";
          ((dle)localObject3).aaRb = ((Context)localObject4).getString(i, new Object[] { str, com.tencent.mm.plugin.finder.utils.t.aBy(paramLinkedList) });
          paramLinkedList = ((bdm)localObject2).ZOb;
          if (paramLinkedList != null) {
            break label863;
          }
          paramLinkedList = "";
          ((dle)localObject3).aaRf = paramLinkedList;
          ((dle)localObject3).content = new t((bdm)localObject2).getContent();
          ((dle)localObject3).aaRd = ((bdm)localObject2).seq;
          ((dle)localObject3).kLn = ((bdm)localObject2).Tro;
          ((dle)localObject3).ZTp = ((bdm)localObject2).ZOc;
          paramLinkedList = ((bdm)localObject2).ZOb;
          if (paramLinkedList != null) {
            break label897;
          }
          i = 0;
        }
        for (;;)
        {
          ((dle)localObject3).aaRe = i;
          paramLinkedList = kotlin.ah.aiuX;
          localArrayList.add(localObject3);
          break;
          paramLinkedList = paramLinkedList.contact;
          if (paramLinkedList == null)
          {
            paramLinkedList = "";
            break label644;
          }
          paramLinkedList1 = paramLinkedList.nickname;
          paramLinkedList = paramLinkedList1;
          if (paramLinkedList1 != null) {
            break label644;
          }
          paramLinkedList = "";
          break label644;
          paramLinkedList = paramLinkedList.contact;
          if (paramLinkedList == null)
          {
            paramLinkedList = "";
            break label668;
          }
          paramLinkedList1 = paramLinkedList.nickname;
          paramLinkedList = paramLinkedList1;
          if (paramLinkedList1 != null) {
            break label668;
          }
          paramLinkedList = "";
          break label668;
          paramLinkedList = paramLinkedList.contact;
          if (paramLinkedList == null)
          {
            paramLinkedList = "";
            break label709;
          }
          paramLinkedList1 = paramLinkedList.headUrl;
          paramLinkedList = paramLinkedList1;
          if (paramLinkedList1 != null) {
            break label709;
          }
          paramLinkedList = "";
          break label709;
          paramLinkedList = paramLinkedList.ZJX;
          if (paramLinkedList == null) {
            i = 0;
          } else {
            i = paramLinkedList.ZPr;
          }
        }
      case 20009: 
        localObject3 = new bek();
        paramLinkedList1 = (com.tencent.mm.bx.a)localObject3;
        paramLinkedList = ((bdm)localObject2).ZNY;
        if (paramLinkedList == null) {
          paramLinkedList = null;
        }
        try
        {
          for (;;)
          {
            paramLinkedList1.parseFrom(paramLinkedList);
            localObject4 = new dle();
            paramLinkedList = com.tencent.mm.plugin.finder.utils.t.GgN;
            ((dle)localObject4).msgType = com.tencent.mm.plugin.finder.utils.t.TV(((bdm)localObject2).msg_type);
            paramLinkedList = ((bdm)localObject2).ZOb;
            if (paramLinkedList != null) {
              break label1204;
            }
            paramLinkedList = "";
            ((dle)localObject4).aaRb = paramLinkedList;
            paramLinkedList = ((bdm)localObject2).ZOb;
            if (paramLinkedList != null) {
              break label1238;
            }
            paramLinkedList = "";
            ((dle)localObject4).aaRf = paramLinkedList;
            paramLinkedList = ((bek)localObject3).ZOD;
            if (paramLinkedList != null) {
              break label1272;
            }
            paramLinkedList = null;
            ((dle)localObject4).DKv = paramLinkedList;
            ((dle)localObject4).content = MMApplicationContext.getContext().getString(p.h.CoA, new Object[] { ((dle)localObject4).DKv });
            ((dle)localObject4).aaRd = ((bdm)localObject2).seq;
            ((dle)localObject4).kLn = ((bdm)localObject2).Tro;
            ((dle)localObject4).ZTp = ((bdm)localObject2).ZOc;
            ((dle)localObject4).JfJ = ((bek)localObject3).ZOE;
            ((dle)localObject4).JfH = ((bek)localObject3).ZOC;
            ((dle)localObject4).aaRg = ((bek)localObject3).ZOT;
            paramLinkedList = ((bek)localObject3).ZOD;
            if (paramLinkedList != null) {
              break label1280;
            }
            paramLinkedList = null;
            ((dle)localObject4).JfI = paramLinkedList;
            ((dle)localObject4).Dbx = ((bek)localObject3).ZOF;
            ((dle)localObject4).aaRh = ((bek)localObject3).ZOS;
            paramLinkedList = kotlin.ah.aiuX;
            localArrayList.add(localObject4);
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
            paramLinkedList = paramLinkedList.contact;
            if (paramLinkedList == null)
            {
              paramLinkedList = "";
            }
            else
            {
              paramLinkedList1 = paramLinkedList.nickname;
              paramLinkedList = paramLinkedList1;
              if (paramLinkedList1 == null)
              {
                paramLinkedList = "";
                continue;
                paramLinkedList = paramLinkedList.contact;
                if (paramLinkedList == null)
                {
                  paramLinkedList = "";
                }
                else
                {
                  paramLinkedList1 = paramLinkedList.headUrl;
                  paramLinkedList = paramLinkedList1;
                  if (paramLinkedList1 == null)
                  {
                    paramLinkedList = "";
                    continue;
                    paramLinkedList = paramLinkedList.name;
                    continue;
                    paramLinkedList = paramLinkedList.ZRC;
                  }
                }
              }
            }
          }
        }
      case 20014: 
        localObject4 = new ah((bdm)localObject2).ekF();
        if ((localObject4 instanceof bet))
        {
          localObject3 = new dle();
          paramLinkedList = com.tencent.mm.plugin.finder.utils.t.GgN;
          ((dle)localObject3).msgType = com.tencent.mm.plugin.finder.utils.t.TV(((bdm)localObject2).msg_type);
          ((dle)localObject3).aaRb = "";
          paramLinkedList = ((bdm)localObject2).ZOb;
          if (paramLinkedList == null)
          {
            paramLinkedList = "";
            ((dle)localObject3).aaRf = paramLinkedList;
            if (!(localObject4 instanceof bet)) {
              break label1538;
            }
            paramLinkedList = (bet)localObject4;
            if (paramLinkedList != null) {
              break label1543;
            }
            i = 0;
            ((dle)localObject3).aaRe = i;
            localObject4 = new StringBuilder();
            paramLinkedList = ((bdm)localObject2).ZOb;
            if (paramLinkedList != null) {
              break label1551;
            }
            paramLinkedList = "";
          }
          for (;;)
          {
            ((dle)localObject3).content = (paramLinkedList + ' ' + MMApplicationContext.getContext().getString(p.h.CoC, new Object[] { Integer.valueOf(((dle)localObject3).aaRe) }));
            ((dle)localObject3).aaRd = ((bdm)localObject2).seq;
            ((dle)localObject3).kLn = ((bdm)localObject2).Tro;
            ((dle)localObject3).ZTp = ((bdm)localObject2).ZOc;
            paramLinkedList = kotlin.ah.aiuX;
            localArrayList.add(localObject3);
            break;
            paramLinkedList = paramLinkedList.contact;
            if (paramLinkedList == null)
            {
              paramLinkedList = "";
              break label1358;
            }
            paramLinkedList1 = paramLinkedList.headUrl;
            paramLinkedList = paramLinkedList1;
            if (paramLinkedList1 != null) {
              break label1358;
            }
            paramLinkedList = "";
            break label1358;
            paramLinkedList = null;
            break label1378;
            i = paramLinkedList.ZPc;
            break label1384;
            paramLinkedList = paramLinkedList.contact;
            if (paramLinkedList == null)
            {
              paramLinkedList = "";
            }
            else
            {
              paramLinkedList1 = paramLinkedList.nickname;
              paramLinkedList = paramLinkedList1;
              if (paramLinkedList1 == null) {
                paramLinkedList = "";
              }
            }
          }
        }
        break;
      case 20036: 
        label644:
        label668:
        label709:
        label863:
        label1272:
        paramLinkedList = new dle();
        label829:
        label1238:
        label1378:
        label1384:
        paramLinkedList1 = com.tencent.mm.plugin.finder.utils.t.GgN;
        label897:
        label1204:
        label1358:
        paramLinkedList.msgType = com.tencent.mm.plugin.finder.utils.t.TV(((bdm)localObject2).msg_type);
        label1280:
        label1538:
        label1543:
        label1551:
        paramLinkedList.content = new t((bdm)localObject2).getContent();
        paramLinkedList.aaRd = ((bdm)localObject2).seq;
        paramLinkedList.kLn = ((bdm)localObject2).Tro;
        paramLinkedList.ZTp = ((bdm)localObject2).ZOc;
        paramLinkedList1 = kotlin.ah.aiuX;
        localArrayList.add(paramLinkedList);
      }
    }
    AppMethodBeat.o(359279);
    return localArrayList;
  }
  
  public static void f(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    long l2 = 0L;
    AppMethodBeat.i(359369);
    Object localObject1;
    long l1;
    if (parama != null)
    {
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      localObject1 = ((j)parama.business(j.class)).Cvf;
      if (localObject1 != null) {
        break label169;
      }
      l1 = 0L;
      if (!com.tencent.mm.plugin.finder.live.utils.a.oG(l1)) {
        break label178;
      }
      localObject1 = MMApplicationContext.getContext().getResources().getString(p.h.finder_live_mic_setting_follow_msg_tip);
      label61:
      s.s(localObject1, "when {\n                F…          }\n            }");
      if (((CharSequence)localObject1).length() != 0) {
        break label316;
      }
    }
    label169:
    label178:
    label316:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        Object localObject2 = new bke();
        ((bke)localObject2).type = 10001;
        ((bke)localObject2).content = ((String)localObject1);
        kotlin.ah localah = kotlin.ah.aiuX;
        localObject2 = new am((bke)localObject2);
        ((l)parama.business(l.class)).EgE.add(localObject2);
      }
      Log.i(TAG, s.X("appendMicSettingTip:", localObject1));
      AppMethodBeat.o(359369);
      return;
      l1 = ((dom)localObject1).CJK;
      break;
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      localObject1 = ((j)parama.business(j.class)).Cvf;
      if (localObject1 == null) {}
      for (l1 = 0L;; l1 = ((dom)localObject1).CJK)
      {
        if (!com.tencent.mm.plugin.finder.live.utils.a.oH(l1)) {
          break label238;
        }
        localObject1 = MMApplicationContext.getContext().getResources().getString(p.h.finder_live_mic_setting_reward_msg_tip);
        break;
      }
      label238:
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      localObject1 = ((j)parama.business(j.class)).Cvf;
      if (localObject1 == null) {}
      for (l1 = l2;; l1 = ((dom)localObject1).CJK)
      {
        if (!com.tencent.mm.plugin.finder.live.utils.a.oI(l1)) {
          break label299;
        }
        localObject1 = MMApplicationContext.getContext().getResources().getString(p.h.finder_live_mic_setting_buy_product_msg_tip);
        break;
      }
      localObject1 = MMApplicationContext.getContext().getResources().getString(p.h.finder_live_mic_setting_all_msg_tip);
      break label61;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.ab
 * JD-Core Version:    0.7.0.1
 */