package com.tencent.mm.plugin.finder.cgi.fetcher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.am.c.a;
import com.tencent.mm.cp.f;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.d;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.cgi.ay;
import com.tencent.mm.plugin.finder.cgi.ay.a;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.finder.storage.aa;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.plugin.findersdk.a.ch;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.avj;
import com.tencent.mm.protocal.protobuf.avk;
import com.tencent.mm.protocal.protobuf.avm;
import com.tencent.mm.protocal.protobuf.avo;
import com.tencent.mm.protocal.protobuf.avr;
import com.tencent.mm.protocal.protobuf.aym;
import com.tencent.mm.protocal.protobuf.ayn;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderContactFetcher;", "", "()V", "aliasContactStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderMsgAliasContactStorage;", "getAliasContactStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderMsgAliasContactStorage;", "aliasContactStorage$delegate", "Lkotlin/Lazy;", "fetchingSet", "Ljava/util/concurrent/ConcurrentHashMap;", "", "strangerContactStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;", "getStrangerContactStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;", "strangerContactStorage$delegate", "fetchContact", "", "req", "call", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "Lkotlin/ParameterName;", "name", "result", "type", "", "fetchContact2", "Lcom/tencent/mm/protocal/protobuf/FinderContactMsgInfo;", "fetchContact3", "Lcom/tencent/mm/protocal/protobuf/FinderContactCommentInfo;", "fetchContact6", "Lcom/tencent/mm/protocal/protobuf/FinderContactFansInfo;", "fetchContact7", "Lcom/tencent/mm/protocal/protobuf/FinderContactCommentLikeInfo;", "fetchContact8", "Lcom/tencent/mm/protocal/protobuf/FinderContactStrangerInfo;", "fetchContactList", "reqList", "", "resultList", "fetchContactList2", "fetchContactList3", "fetchContactList6", "fetchContactList7", "fetchContactList8", "fetchSelfAliasContact", "fetchSelfAliasList", "onFetchContactResp", "back", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetContactListResp;", "Ljava/util/LinkedList;", "from", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a ADO;
  private final ConcurrentHashMap<String, Object> ADP;
  private final j ADQ;
  private final j ADR;
  
  static
  {
    AppMethodBeat.i(337048);
    ADO = new a((byte)0);
    AppMethodBeat.o(337048);
  }
  
  public a()
  {
    AppMethodBeat.i(336838);
    this.ADP = new ConcurrentHashMap();
    this.ADQ = k.cm((kotlin.g.a.a)j.ADW);
    this.ADR = k.cm((kotlin.g.a.a)b.ADS);
    AppMethodBeat.o(336838);
  }
  
  private static final ah a(a parama, LinkedList paramLinkedList, List paramList, b paramb, b.a parama1)
  {
    AppMethodBeat.i(336895);
    s.u(parama, "this$0");
    s.u(paramLinkedList, "$resultList");
    s.u(paramList, "$reqList");
    s.u(paramb, "$call");
    s.s(parama1, "back");
    parama.a(parama1, paramLinkedList, paramList, 0, paramb);
    parama = ah.aiuX;
    AppMethodBeat.o(336895);
    return parama;
  }
  
  private static final ah a(LinkedList paramLinkedList, b paramb, a parama, b.a parama1)
  {
    AppMethodBeat.i(336951);
    s.u(paramLinkedList, "$resultList");
    s.u(paramb, "$call");
    s.u(parama, "this$0");
    Object localObject2;
    if ((parama1.errType == 0) && (parama1.errCode == 0))
    {
      localObject1 = ((ayn)parama1.ott).ZIt;
      s.s(localObject1, "back.resp.contactList");
      int i;
      label105:
      m localm;
      if (!((Collection)localObject1).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label409;
        }
        parama1 = ((ayn)parama1.ott).ZIt;
        s.s(parama1, "back.resp.contactList");
        localObject2 = ((Iterable)parama1).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label456;
        }
        parama1 = (FinderContact)((Iterator)localObject2).next();
        s.s(parama1, "it");
        localm = c.a(parama1, null, false);
        if (((CharSequence)localm.getUsername()).length() != 0) {
          break label361;
        }
        i = 1;
        label159:
        if (i != 0)
        {
          parama1 = parama1.msgInfo;
          if (parama1 != null) {
            break label367;
          }
          parama1 = "";
          label177:
          localm.setUsername(parama1);
          Log.w("Finder.ContactFetcher", "[fetchAliasList] server error.");
        }
        localm.Axm = true;
        if (((CharSequence)localm.amx()).length() != 0) {
          break label388;
        }
        i = 1;
        label217:
        if (i != 0) {
          Log.w("Finder.ContactFetcher", "[fetchAliasList] avatarUrl is null, nickname=" + localm.getNickname() + " username=" + localm.getUsername() + ' ');
        }
        if (((CharSequence)localm.getNickname()).length() != 0) {
          break label394;
        }
        i = 1;
        label287:
        if (i == 0) {
          break label400;
        }
        localm.field_retryCount += 1;
        Log.w("Finder.ContactFetcher", "[fetchAliasList] nickname is null. username=" + localm.getUsername() + " retryCount=" + localm.field_retryCount);
      }
      for (;;)
      {
        paramLinkedList.add(localm);
        break label105;
        i = 0;
        break;
        label361:
        i = 0;
        break label159;
        label367:
        localObject1 = parama1.ZFM;
        parama1 = (b.a)localObject1;
        if (localObject1 != null) {
          break label177;
        }
        parama1 = "";
        break label177;
        label388:
        i = 0;
        break label217;
        label394:
        i = 0;
        break label287;
        label400:
        localm.field_retryCount = 0;
      }
    }
    label409:
    Object localObject1 = z.bAX();
    parama1 = (b.a)localObject1;
    if (localObject1 == null) {
      parama1 = "";
    }
    parama1 = new m(parama1);
    parama1.Axm = false;
    parama1.field_retryCount += 1;
    paramLinkedList.add(parama1);
    label456:
    parama1 = ((Iterable)paramLinkedList).iterator();
    while (parama1.hasNext())
    {
      localObject1 = (ch)parama1.next();
      if ((localObject1 instanceof m)) {
        if (au.bwT(((m)localObject1).getUsername()))
        {
          ab.b(parama.dWJ(), (m)localObject1);
        }
        else if (au.bwV(((m)localObject1).getUsername()))
        {
          localObject2 = d.AwY;
          d.a.e((m)localObject1);
        }
        else if (au.bwU(((m)localObject1).getUsername()))
        {
          aa.a(parama.dWK(), (m)localObject1);
        }
      }
    }
    paramb.invoke(paramLinkedList);
    paramLinkedList = ah.aiuX;
    AppMethodBeat.o(336951);
    return paramLinkedList;
  }
  
  private static final ah a(List paramList, LinkedList paramLinkedList, b paramb, a parama, b.a parama1)
  {
    AppMethodBeat.i(336935);
    s.u(paramList, "$reqList");
    s.u(paramLinkedList, "$resultList");
    s.u(paramb, "$call");
    s.u(parama, "this$0");
    label116:
    Object localObject2;
    if ((parama1.errType == 0) && (parama1.errCode == 0))
    {
      localObject1 = ((ayn)parama1.ott).ZIt;
      s.s(localObject1, "back.resp.contactList");
      int i;
      if (!((Collection)localObject1).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label420;
        }
        paramList = ((ayn)parama1.ott).ZIt;
        s.s(paramList, "back.resp.contactList");
        localObject1 = ((Iterable)paramList).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label659;
        }
        paramList = (FinderContact)((Iterator)localObject1).next();
        s.s(paramList, "it");
        localObject2 = c.a(paramList, null, false);
        if (((CharSequence)((m)localObject2).getUsername()).length() != 0) {
          break label372;
        }
        i = 1;
        label170:
        if (i != 0)
        {
          paramList = paramList.msgInfo;
          if (paramList != null) {
            break label378;
          }
          paramList = "";
          label188:
          ((m)localObject2).setUsername(paramList);
          Log.w("Finder.ContactFetcher", "[fetchContactList2] server error.");
        }
        ((m)localObject2).Axm = true;
        if (((CharSequence)((m)localObject2).amx()).length() != 0) {
          break label399;
        }
        i = 1;
        label228:
        if (i != 0) {
          Log.w("Finder.ContactFetcher", "avatarUrl is null, nickname=" + ((m)localObject2).getNickname() + " username=" + ((m)localObject2).getUsername() + ' ');
        }
        if (((CharSequence)((m)localObject2).getNickname()).length() != 0) {
          break label405;
        }
        i = 1;
        label298:
        if (i == 0) {
          break label411;
        }
        ((m)localObject2).field_retryCount += 1;
        Log.w("Finder.ContactFetcher", "[fetchContactList2] nickname is null. username=" + ((m)localObject2).getUsername() + " retryCount=" + ((m)localObject2).field_retryCount);
      }
      for (;;)
      {
        paramLinkedList.add(localObject2);
        break label116;
        i = 0;
        break;
        label372:
        i = 0;
        break label170;
        label378:
        parama1 = paramList.ZFM;
        paramList = parama1;
        if (parama1 != null) {
          break label188;
        }
        paramList = "";
        break label188;
        label399:
        i = 0;
        break label228;
        label405:
        i = 0;
        break label298;
        label411:
        ((m)localObject2).field_retryCount = 0;
      }
    }
    label420:
    Object localObject1 = ((Iterable)paramList).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (avo)((Iterator)localObject1).next();
      Object localObject3;
      if (au.bwT(((avo)localObject2).ZFM))
      {
        localObject3 = parama.dWJ();
        parama1 = ((avo)localObject2).ZFM;
        paramList = parama1;
        if (parama1 == null) {
          paramList = "";
        }
        paramList = ((ab)localObject3).auT(paramList);
        label496:
        if (paramList != null) {
          break label656;
        }
        parama1 = ((avo)localObject2).ZFM;
        paramList = parama1;
        if (parama1 == null) {
          paramList = "";
        }
        paramList = new m(paramList);
      }
      label656:
      for (;;)
      {
        paramList.Axm = false;
        paramList.field_retryCount += 1;
        paramLinkedList.add(paramList);
        break;
        if (au.bwV(((avo)localObject2).ZFM))
        {
          paramList = d.AwY;
          paramList = d.a.auT(((avo)localObject2).ZFM);
          break label496;
        }
        if (au.bwU(((avo)localObject2).ZFM))
        {
          localObject3 = parama.dWK();
          parama1 = ((avo)localObject2).ZFM;
          paramList = parama1;
          if (parama1 == null) {
            paramList = "";
          }
          paramList = ((aa)localObject3).auT(paramList);
          break label496;
        }
        parama1 = ((avo)localObject2).ZFM;
        paramList = parama1;
        if (parama1 == null) {
          paramList = "";
        }
        paramList = new m(paramList);
        break label496;
      }
    }
    label659:
    paramList = ((Iterable)paramLinkedList).iterator();
    while (paramList.hasNext())
    {
      parama1 = (ch)paramList.next();
      if ((parama1 instanceof m)) {
        if (au.bwT(((m)parama1).getUsername()))
        {
          ab.b(parama.dWJ(), (m)parama1);
        }
        else if (au.bwV(((m)parama1).getUsername()))
        {
          localObject1 = d.AwY;
          d.a.e((m)parama1);
        }
        else if (au.bwU(((m)parama1).getUsername()))
        {
          aa.a(parama.dWK(), (m)parama1);
        }
      }
    }
    paramb.invoke(paramLinkedList);
    paramList = ah.aiuX;
    AppMethodBeat.o(336935);
    return paramList;
  }
  
  private final void a(b.a<ayn> parama, LinkedList<ch> paramLinkedList, List<String> paramList, int paramInt, b<? super List<? extends ch>, ah> paramb)
  {
    AppMethodBeat.i(336877);
    if ((parama.errType != 0) || (parama.errCode != 0))
    {
      h.OAn.b(20492, new Object[] { Long.valueOf(5L), parama.errType + ',' + parama.errCode });
      h.OAn.p(1473L, 5L, 1L);
    }
    Object localObject1;
    Object localObject2;
    label169:
    Object localObject3;
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      localObject1 = ((ayn)parama.ott).ZIt;
      s.s(localObject1, "back.resp.contactList");
      if (!((Collection)localObject1).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label555;
        }
        paramList = ((ayn)parama.ott).ZIt;
        s.s(paramList, "back.resp.contactList");
        localObject2 = ((Iterable)paramList).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label450;
        }
        localObject3 = (FinderContact)((Iterator)localObject2).next();
        if (Util.isNullOrNil(((FinderContact)localObject3).username))
        {
          paramList = ((FinderContact)localObject3).msgInfo;
          if (paramList != null) {
            break label409;
          }
          paramList = "";
          label216:
          ((FinderContact)localObject3).username = paramList;
          Log.w("Finder.ContactFetcher", "[fetchContactList] server error.");
        }
        s.s(localObject3, "it");
        paramList = c.a((FinderContact)localObject3);
        paramList.Axm = true;
        paramList.field_source = paramInt;
        if (((CharSequence)paramList.amx()).length() != 0) {
          break label430;
        }
        i = 1;
        label273:
        if (i != 0) {
          Log.w("Finder.ContactFetcher", "avatarUrl is null, nickname=" + paramList.getNickname() + " username=" + paramList.getUsername() + ' ');
        }
        if (((CharSequence)paramList.getNickname()).length() != 0) {
          break label436;
        }
        i = 1;
        label340:
        if (i == 0) {
          break label442;
        }
        paramList.field_retryCount += 1;
        Log.w("Finder.ContactFetcher", "[fetchContactList] nickname is null. username=" + paramList.getUsername() + " retryCount=" + paramList.field_retryCount);
      }
      for (;;)
      {
        paramLinkedList.add(paramList);
        break label169;
        i = 0;
        break;
        label409:
        localObject1 = paramList.ZFM;
        paramList = (List<String>)localObject1;
        if (localObject1 != null) {
          break label216;
        }
        paramList = "";
        break label216;
        label430:
        i = 0;
        break label273;
        label436:
        i = 0;
        break label340;
        label442:
        paramList.field_retryCount = 0;
      }
      label450:
      int i = ((ayn)parama.ott).AwU;
      if ((i > 0) && (paramInt == 4))
      {
        parama = com.tencent.mm.plugin.finder.api.a.AwT;
        Log.i("Finder.FinderAdContactLogic", "not setNextRetryInterval");
        com.tencent.mm.plugin.finder.api.a.MV(i);
      }
      parama = ((Iterable)paramLinkedList).iterator();
    }
    for (;;)
    {
      if (!parama.hasNext()) {
        break label826;
      }
      paramList = (ch)parama.next();
      if ((paramList instanceof m))
      {
        if (au.bwT(((m)paramList).getUsername()))
        {
          ab.b(dWJ(), (m)paramList);
          continue;
          label555:
          parama = ((Iterable)paramList).iterator();
          while (parama.hasNext())
          {
            paramList = new m((String)parama.next());
            paramList.field_source = paramInt;
            paramList.Axm = false;
            paramList.field_retryCount += 1;
            paramLinkedList.add(paramList);
          }
          break;
        }
        if (au.bwV(((m)paramList).getUsername()))
        {
          localObject1 = com.tencent.mm.plugin.finder.api.a.AwT;
          localObject1 = (m)paramList;
          s.u(localObject1, "contact");
          localObject2 = ((m)localObject1).getUsername();
          localObject3 = com.tencent.mm.plugin.finder.api.a.dTW();
          s.u(localObject2, "key");
          s.u(localObject1, "contact");
          Log.i("Finder.AdContactCache", "set key: " + (String)localObject2 + " contact:" + ((m)localObject1).getUsername() + " feedCount: " + ((m)localObject1).field_feedCount + " getFollowersCount:" + ((m)localObject1).field_friendFollowCount);
          ((m)localObject1).field_updateTime = cn.bDw();
          localObject3 = ((com.tencent.mm.plugin.finder.api.a.b)localObject3).AwX;
          s.s(localObject3, "cacheItems");
          ((Map)localObject3).put(localObject2, localObject1);
          localObject1 = d.AwY;
          d.a.e((m)paramList);
        }
        else if (au.bwU(((m)paramList).getUsername()))
        {
          aa.a(dWK(), (m)paramList);
        }
      }
    }
    label826:
    paramb.invoke(paramLinkedList);
    AppMethodBeat.o(336877);
  }
  
  private static final ah b(a parama, LinkedList paramLinkedList, List paramList, b paramb, b.a parama1)
  {
    AppMethodBeat.i(336912);
    s.u(parama, "this$0");
    s.u(paramLinkedList, "$resultList");
    s.u(paramList, "$reqList");
    s.u(paramb, "$call");
    s.s(parama1, "back");
    parama.a(parama1, paramLinkedList, paramList, 4, paramb);
    parama = ah.aiuX;
    AppMethodBeat.o(336912);
    return parama;
  }
  
  private static final ah b(List paramList, LinkedList paramLinkedList, b paramb, a parama, b.a parama1)
  {
    AppMethodBeat.i(336965);
    s.u(paramList, "$reqList");
    s.u(paramLinkedList, "$resultList");
    s.u(paramb, "$call");
    s.u(parama, "this$0");
    label116:
    Object localObject2;
    if ((parama1.errType == 0) && (parama1.errCode == 0))
    {
      localObject1 = ((ayn)parama1.ott).ZIt;
      s.s(localObject1, "back.resp.contactList");
      int i;
      if (!((Collection)localObject1).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label420;
        }
        paramList = ((ayn)parama1.ott).ZIt;
        s.s(paramList, "back.resp.contactList");
        localObject1 = ((Iterable)paramList).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label613;
        }
        paramList = (FinderContact)((Iterator)localObject1).next();
        s.s(paramList, "it");
        localObject2 = c.a(paramList, null, false);
        if (((CharSequence)((m)localObject2).getUsername()).length() != 0) {
          break label372;
        }
        i = 1;
        label170:
        if (i != 0)
        {
          paramList = paramList.msgInfo;
          if (paramList != null) {
            break label378;
          }
          paramList = "";
          label188:
          ((m)localObject2).setUsername(paramList);
          Log.w("Finder.ContactFetcher", "[fetchContactList3] server error.");
        }
        ((m)localObject2).Axm = true;
        if (((CharSequence)((m)localObject2).amx()).length() != 0) {
          break label399;
        }
        i = 1;
        label228:
        if (i != 0) {
          Log.w("Finder.ContactFetcher", "[fetchContactList3] avatarUrl is null, nickname=" + ((m)localObject2).getNickname() + " username=" + ((m)localObject2).getUsername() + ' ');
        }
        if (((CharSequence)((m)localObject2).getNickname()).length() != 0) {
          break label405;
        }
        i = 1;
        label298:
        if (i == 0) {
          break label411;
        }
        ((m)localObject2).field_retryCount += 1;
        Log.w("Finder.ContactFetcher", "[fetchContactList3] nickname is null. username=" + ((m)localObject2).getUsername() + " retryCount=" + ((m)localObject2).field_retryCount);
      }
      for (;;)
      {
        paramLinkedList.add(localObject2);
        break label116;
        i = 0;
        break;
        label372:
        i = 0;
        break label170;
        label378:
        parama1 = paramList.ZFM;
        paramList = parama1;
        if (parama1 != null) {
          break label188;
        }
        paramList = "";
        break label188;
        label399:
        i = 0;
        break label228;
        label405:
        i = 0;
        break label298;
        label411:
        ((m)localObject2).field_retryCount = 0;
      }
    }
    label420:
    Object localObject1 = ((Iterable)paramList).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (avj)((Iterator)localObject1).next();
      if (au.bwT(((avj)localObject2).ZFB))
      {
        ab localab = parama.dWJ();
        parama1 = ((avj)localObject2).ZFB;
        paramList = parama1;
        if (parama1 == null) {
          paramList = "";
        }
        paramList = localab.auT(paramList);
        label496:
        if (paramList != null) {
          break label610;
        }
        parama1 = ((avj)localObject2).ZFB;
        paramList = parama1;
        if (parama1 == null) {
          paramList = "";
        }
        paramList = new m(paramList);
      }
      label610:
      for (;;)
      {
        paramList.Axm = false;
        paramList.field_retryCount += 1;
        paramLinkedList.add(paramList);
        break;
        if (au.bwV(((avj)localObject2).ZFB))
        {
          paramList = d.AwY;
          paramList = d.a.auT(((avj)localObject2).ZFB);
          break label496;
        }
        parama1 = ((avj)localObject2).ZFB;
        paramList = parama1;
        if (parama1 == null) {
          paramList = "";
        }
        paramList = new m(paramList);
        break label496;
      }
    }
    label613:
    paramList = ((Iterable)paramLinkedList).iterator();
    while (paramList.hasNext())
    {
      parama1 = (ch)paramList.next();
      if ((parama1 instanceof m)) {
        if (au.bwT(((m)parama1).getUsername()))
        {
          ab.b(parama.dWJ(), (m)parama1);
        }
        else if (au.bwV(((m)parama1).getUsername()))
        {
          localObject1 = d.AwY;
          d.a.e((m)parama1);
        }
        else if (au.bwU(((m)parama1).getUsername()))
        {
          aa.a(parama.dWK(), (m)parama1);
        }
      }
    }
    paramb.invoke(paramLinkedList);
    paramList = ah.aiuX;
    AppMethodBeat.o(336965);
    return paramList;
  }
  
  private static final ah c(List paramList, LinkedList paramLinkedList, b paramb, a parama, b.a parama1)
  {
    AppMethodBeat.i(336988);
    s.u(paramList, "$reqList");
    s.u(paramLinkedList, "$resultList");
    s.u(paramb, "$call");
    s.u(parama, "this$0");
    label116:
    Object localObject2;
    if ((parama1.errType == 0) && (parama1.errCode == 0))
    {
      localObject1 = ((ayn)parama1.ott).ZIt;
      s.s(localObject1, "back.resp.contactList");
      int i;
      if (!((Collection)localObject1).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label420;
        }
        paramList = ((ayn)parama1.ott).ZIt;
        s.s(paramList, "back.resp.contactList");
        localObject1 = ((Iterable)paramList).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label613;
        }
        paramList = (FinderContact)((Iterator)localObject1).next();
        s.s(paramList, "it");
        localObject2 = c.a(paramList, null, false);
        if (((CharSequence)((m)localObject2).getUsername()).length() != 0) {
          break label372;
        }
        i = 1;
        label170:
        if (i != 0)
        {
          paramList = paramList.msgInfo;
          if (paramList != null) {
            break label378;
          }
          paramList = "";
          label188:
          ((m)localObject2).setUsername(paramList);
          Log.w("Finder.ContactFetcher", "[fetchContactList6] server error.");
        }
        ((m)localObject2).Axm = true;
        if (((CharSequence)((m)localObject2).amx()).length() != 0) {
          break label399;
        }
        i = 1;
        label228:
        if (i != 0) {
          Log.w("Finder.ContactFetcher", "[fetchContactList6] avatarUrl is null, nickname=" + ((m)localObject2).getNickname() + " username=" + ((m)localObject2).getUsername() + ' ');
        }
        if (((CharSequence)((m)localObject2).getNickname()).length() != 0) {
          break label405;
        }
        i = 1;
        label298:
        if (i == 0) {
          break label411;
        }
        ((m)localObject2).field_retryCount += 1;
        Log.w("Finder.ContactFetcher", "[fetchContactList6] nickname is null. username=" + ((m)localObject2).getUsername() + " retryCount=" + ((m)localObject2).field_retryCount);
      }
      for (;;)
      {
        paramLinkedList.add(localObject2);
        break label116;
        i = 0;
        break;
        label372:
        i = 0;
        break label170;
        label378:
        parama1 = paramList.ZFM;
        paramList = parama1;
        if (parama1 != null) {
          break label188;
        }
        paramList = "";
        break label188;
        label399:
        i = 0;
        break label228;
        label405:
        i = 0;
        break label298;
        label411:
        ((m)localObject2).field_retryCount = 0;
      }
    }
    label420:
    Object localObject1 = ((Iterable)paramList).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (avm)((Iterator)localObject1).next();
      if (au.bwT(((avm)localObject2).ZFG))
      {
        ab localab = parama.dWJ();
        parama1 = ((avm)localObject2).ZFG;
        paramList = parama1;
        if (parama1 == null) {
          paramList = "";
        }
        paramList = localab.auT(paramList);
        label496:
        if (paramList != null) {
          break label610;
        }
        parama1 = ((avm)localObject2).ZFG;
        paramList = parama1;
        if (parama1 == null) {
          paramList = "";
        }
        paramList = new m(paramList);
      }
      label610:
      for (;;)
      {
        paramList.Axm = false;
        paramList.field_retryCount += 1;
        paramLinkedList.add(paramList);
        break;
        if (au.bwV(((avm)localObject2).ZFG))
        {
          paramList = d.AwY;
          paramList = d.a.auT(((avm)localObject2).ZFG);
          break label496;
        }
        parama1 = ((avm)localObject2).ZFG;
        paramList = parama1;
        if (parama1 == null) {
          paramList = "";
        }
        paramList = new m(paramList);
        break label496;
      }
    }
    label613:
    paramList = ((Iterable)paramLinkedList).iterator();
    while (paramList.hasNext())
    {
      parama1 = (ch)paramList.next();
      if ((parama1 instanceof m)) {
        if (au.bwT(((m)parama1).getUsername()))
        {
          ab.b(parama.dWJ(), (m)parama1);
        }
        else if (au.bwV(((m)parama1).getUsername()))
        {
          localObject1 = d.AwY;
          d.a.e((m)parama1);
        }
        else if (au.bwU(((m)parama1).getUsername()))
        {
          aa.a(parama.dWK(), (m)parama1);
        }
      }
    }
    paramb.invoke(paramLinkedList);
    paramList = ah.aiuX;
    AppMethodBeat.o(336988);
    return paramList;
  }
  
  private static final ah d(List paramList, LinkedList paramLinkedList, b paramb, a parama, b.a parama1)
  {
    AppMethodBeat.i(337012);
    s.u(paramList, "$reqList");
    s.u(paramLinkedList, "$resultList");
    s.u(paramb, "$call");
    s.u(parama, "this$0");
    label116:
    Object localObject2;
    if ((parama1.errType == 0) && (parama1.errCode == 0))
    {
      localObject1 = ((ayn)parama1.ott).ZIt;
      s.s(localObject1, "back.resp.contactList");
      int i;
      if (!((Collection)localObject1).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label420;
        }
        paramList = ((ayn)parama1.ott).ZIt;
        s.s(paramList, "back.resp.contactList");
        localObject1 = ((Iterable)paramList).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label613;
        }
        paramList = (FinderContact)((Iterator)localObject1).next();
        s.s(paramList, "it");
        localObject2 = c.a(paramList, null, false);
        if (((CharSequence)((m)localObject2).getUsername()).length() != 0) {
          break label372;
        }
        i = 1;
        label170:
        if (i != 0)
        {
          paramList = paramList.msgInfo;
          if (paramList != null) {
            break label378;
          }
          paramList = "";
          label188:
          ((m)localObject2).setUsername(paramList);
          Log.w("Finder.ContactFetcher", "[fetchContactList7] server error.");
        }
        ((m)localObject2).Axm = true;
        if (((CharSequence)((m)localObject2).amx()).length() != 0) {
          break label399;
        }
        i = 1;
        label228:
        if (i != 0) {
          Log.w("Finder.ContactFetcher", "[fetchContactList7] avatarUrl is null, nickname=" + ((m)localObject2).getNickname() + " username=" + ((m)localObject2).getUsername() + ' ');
        }
        if (((CharSequence)((m)localObject2).getNickname()).length() != 0) {
          break label405;
        }
        i = 1;
        label298:
        if (i == 0) {
          break label411;
        }
        ((m)localObject2).field_retryCount += 1;
        Log.w("Finder.ContactFetcher", "[fetchContactList7] nickname is null. username=" + ((m)localObject2).getUsername() + " retryCount=" + ((m)localObject2).field_retryCount);
      }
      for (;;)
      {
        paramLinkedList.add(localObject2);
        break label116;
        i = 0;
        break;
        label372:
        i = 0;
        break label170;
        label378:
        parama1 = paramList.ZFM;
        paramList = parama1;
        if (parama1 != null) {
          break label188;
        }
        paramList = "";
        break label188;
        label399:
        i = 0;
        break label228;
        label405:
        i = 0;
        break label298;
        label411:
        ((m)localObject2).field_retryCount = 0;
      }
    }
    label420:
    Object localObject1 = ((Iterable)paramList).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (avk)((Iterator)localObject1).next();
      if (au.bwT(((avk)localObject2).ZFC))
      {
        ab localab = parama.dWJ();
        parama1 = ((avk)localObject2).ZFC;
        paramList = parama1;
        if (parama1 == null) {
          paramList = "";
        }
        paramList = localab.auT(paramList);
        label496:
        if (paramList != null) {
          break label610;
        }
        parama1 = ((avk)localObject2).ZFC;
        paramList = parama1;
        if (parama1 == null) {
          paramList = "";
        }
        paramList = new m(paramList);
      }
      label610:
      for (;;)
      {
        paramList.Axm = false;
        paramList.field_retryCount += 1;
        paramLinkedList.add(paramList);
        break;
        if (au.bwV(((avk)localObject2).ZFC))
        {
          paramList = d.AwY;
          paramList = d.a.auT(((avk)localObject2).ZFC);
          break label496;
        }
        parama1 = ((avk)localObject2).ZFC;
        paramList = parama1;
        if (parama1 == null) {
          paramList = "";
        }
        paramList = new m(paramList);
        break label496;
      }
    }
    label613:
    paramList = ((Iterable)paramLinkedList).iterator();
    while (paramList.hasNext())
    {
      parama1 = (ch)paramList.next();
      if ((parama1 instanceof m)) {
        if (au.bwT(((m)parama1).getUsername()))
        {
          ab.b(parama.dWJ(), (m)parama1);
        }
        else if (au.bwV(((m)parama1).getUsername()))
        {
          localObject1 = d.AwY;
          d.a.e((m)parama1);
        }
        else if (au.bwU(((m)parama1).getUsername()))
        {
          aa.a(parama.dWK(), (m)parama1);
        }
      }
    }
    paramb.invoke(paramLinkedList);
    paramList = ah.aiuX;
    AppMethodBeat.o(337012);
    return paramList;
  }
  
  private final ab dWJ()
  {
    AppMethodBeat.i(336851);
    ab localab = (ab)this.ADQ.getValue();
    AppMethodBeat.o(336851);
    return localab;
  }
  
  private final aa dWK()
  {
    AppMethodBeat.i(336856);
    aa localaa = (aa)this.ADR.getValue();
    AppMethodBeat.o(336856);
    return localaa;
  }
  
  private static final ah e(List paramList, LinkedList paramLinkedList, b paramb, a parama, b.a parama1)
  {
    AppMethodBeat.i(337023);
    s.u(paramList, "$reqList");
    s.u(paramLinkedList, "$resultList");
    s.u(paramb, "$call");
    s.u(parama, "this$0");
    label116:
    Object localObject2;
    if ((parama1.errType == 0) && (parama1.errCode == 0))
    {
      localObject1 = ((ayn)parama1.ott).ZIt;
      s.s(localObject1, "back.resp.contactList");
      int i;
      if (!((Collection)localObject1).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label420;
        }
        paramList = ((ayn)parama1.ott).ZIt;
        s.s(paramList, "back.resp.contactList");
        localObject1 = ((Iterable)paramList).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label613;
        }
        paramList = (FinderContact)((Iterator)localObject1).next();
        s.s(paramList, "it");
        localObject2 = c.a(paramList, null, false);
        if (((CharSequence)((m)localObject2).getUsername()).length() != 0) {
          break label372;
        }
        i = 1;
        label170:
        if (i != 0)
        {
          paramList = paramList.msgInfo;
          if (paramList != null) {
            break label378;
          }
          paramList = "";
          label188:
          ((m)localObject2).setUsername(paramList);
          Log.w("Finder.ContactFetcher", "[fetchContactList8] server error.");
        }
        ((m)localObject2).Axm = true;
        if (((CharSequence)((m)localObject2).amx()).length() != 0) {
          break label399;
        }
        i = 1;
        label228:
        if (i != 0) {
          Log.w("Finder.ContactFetcher", "[fetchContactList8] avatarUrl is null, nickname=" + ((m)localObject2).getNickname() + " username=" + ((m)localObject2).getUsername() + ' ');
        }
        if (((CharSequence)((m)localObject2).getNickname()).length() != 0) {
          break label405;
        }
        i = 1;
        label298:
        if (i == 0) {
          break label411;
        }
        ((m)localObject2).field_retryCount += 1;
        Log.w("Finder.ContactFetcher", "[fetchContactList8] nickname is null. username=" + ((m)localObject2).getUsername() + " retryCount=" + ((m)localObject2).field_retryCount);
      }
      for (;;)
      {
        paramLinkedList.add(localObject2);
        break label116;
        i = 0;
        break;
        label372:
        i = 0;
        break label170;
        label378:
        parama1 = paramList.ZFM;
        paramList = parama1;
        if (parama1 != null) {
          break label188;
        }
        paramList = "";
        break label188;
        label399:
        i = 0;
        break label228;
        label405:
        i = 0;
        break label298;
        label411:
        ((m)localObject2).field_retryCount = 0;
      }
    }
    label420:
    Object localObject1 = ((Iterable)paramList).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (avr)((Iterator)localObject1).next();
      if (au.bwT(((avr)localObject2).ZFO))
      {
        ab localab = parama.dWJ();
        parama1 = ((avr)localObject2).ZFO;
        paramList = parama1;
        if (parama1 == null) {
          paramList = "";
        }
        paramList = localab.auT(paramList);
        label496:
        if (paramList != null) {
          break label610;
        }
        parama1 = ((avr)localObject2).ZFO;
        paramList = parama1;
        if (parama1 == null) {
          paramList = "";
        }
        paramList = new m(paramList);
      }
      label610:
      for (;;)
      {
        paramList.Axm = false;
        paramList.field_retryCount += 1;
        paramLinkedList.add(paramList);
        break;
        if (au.bwV(((avr)localObject2).ZFO))
        {
          paramList = d.AwY;
          paramList = d.a.auT(((avr)localObject2).ZFO);
          break label496;
        }
        parama1 = ((avr)localObject2).ZFO;
        paramList = parama1;
        if (parama1 == null) {
          paramList = "";
        }
        paramList = new m(paramList);
        break label496;
      }
    }
    label613:
    paramList = ((Iterable)paramLinkedList).iterator();
    while (paramList.hasNext())
    {
      parama1 = (ch)paramList.next();
      if ((parama1 instanceof m)) {
        if (au.bwT(((m)parama1).getUsername()))
        {
          ab.a(parama.dWJ(), (m)parama1);
        }
        else if (au.bwV(((m)parama1).getUsername()))
        {
          localObject1 = d.AwY;
          d.a.e((m)parama1);
        }
        else if (au.bwU(((m)parama1).getUsername()))
        {
          aa.a(parama.dWK(), (m)parama1);
        }
      }
    }
    paramb.invoke(paramLinkedList);
    paramList = ah.aiuX;
    AppMethodBeat.o(337023);
    return paramList;
  }
  
  public final void a(avj paramavj, b<? super ch, ah> paramb)
  {
    AppMethodBeat.i(337236);
    s.u(paramavj, "req");
    s.u(paramb, "call");
    Object localObject2 = paramavj.ZFB;
    Object localObject1 = (Map)this.ADP;
    if (localObject1 == null)
    {
      paramavj = new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
      AppMethodBeat.o(337236);
      throw paramavj;
    }
    if (!((Map)localObject1).containsKey(localObject2))
    {
      Object localObject3 = (Map)this.ADP;
      if (localObject2 == null) {}
      for (localObject1 = "";; localObject1 = localObject2)
      {
        ((Map)localObject3).put(localObject1, this);
        paramavj = p.listOf(paramavj);
        paramb = (b)new a.e(this, (String)localObject2, paramb);
        s.u(paramavj, "reqList");
        s.u(paramb, "call");
        localObject1 = new LinkedList();
        localObject2 = ay.AAR;
        s.u(paramavj, "usernameList");
        localObject2 = new ay();
        localObject3 = new c.a();
        Object localObject4 = new aym();
        bi localbi = bi.ABn;
        ((aym)localObject4).ZEc = bi.dVu();
        ((aym)localObject4).ZJt = 3;
        ((aym)localObject4).YIZ = z.bAW();
        ((aym)localObject4).ZJw.addAll((Collection)paramavj);
        ((c.a)localObject3).otE = ((com.tencent.mm.bx.a)localObject4);
        localObject4 = new ayn();
        ((ayn)localObject4).setBaseResponse(new kd());
        ((ayn)localObject4).getBaseResponse().akjO = new etl();
        ((c.a)localObject3).otF = ((com.tencent.mm.bx.a)localObject4);
        ((c.a)localObject3).uri = "/cgi-bin/micromsg-bin/findergetcontactlist";
        ((c.a)localObject3).funcId = 3953;
        ((ay)localObject2).c(((c.a)localObject3).bEF());
        ((ay)localObject2).bFJ().j(new a..ExternalSyntheticLambda4(paramavj, (LinkedList)localObject1, paramb, this));
        AppMethodBeat.o(337236);
        return;
      }
    }
    Log.w("Finder.ContactFetcher", "[fetchContact3] req is loading. just return");
    AppMethodBeat.o(337236);
  }
  
  public final void a(avk paramavk, b<? super ch, ah> paramb)
  {
    AppMethodBeat.i(337275);
    s.u(paramavk, "req");
    s.u(paramb, "call");
    Object localObject2 = paramavk.ZFC;
    Object localObject1 = (Map)this.ADP;
    if (localObject1 == null)
    {
      paramavk = new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
      AppMethodBeat.o(337275);
      throw paramavk;
    }
    if (!((Map)localObject1).containsKey(localObject2))
    {
      Object localObject3 = (Map)this.ADP;
      if (localObject2 == null) {}
      for (localObject1 = "";; localObject1 = localObject2)
      {
        ((Map)localObject3).put(localObject1, this);
        paramavk = p.listOf(paramavk);
        paramb = (b)new a.g(this, (String)localObject2, paramb);
        s.u(paramavk, "reqList");
        s.u(paramb, "call");
        localObject1 = new LinkedList();
        localObject2 = ay.AAR;
        s.u(paramavk, "commentLikeInfoList");
        localObject2 = new ay();
        localObject3 = new c.a();
        Object localObject4 = new aym();
        bi localbi = bi.ABn;
        ((aym)localObject4).ZEc = bi.dVu();
        ((aym)localObject4).ZJt = 6;
        ((aym)localObject4).YIZ = z.bAW();
        ((aym)localObject4).ZJx.addAll((Collection)paramavk);
        ((c.a)localObject3).otE = ((com.tencent.mm.bx.a)localObject4);
        localObject4 = new ayn();
        ((ayn)localObject4).setBaseResponse(new kd());
        ((ayn)localObject4).getBaseResponse().akjO = new etl();
        ((c.a)localObject3).otF = ((com.tencent.mm.bx.a)localObject4);
        ((c.a)localObject3).uri = "/cgi-bin/micromsg-bin/findergetcontactlist";
        ((c.a)localObject3).funcId = 3953;
        ((ay)localObject2).c(((c.a)localObject3).bEF());
        ((ay)localObject2).bFJ().j(new a..ExternalSyntheticLambda7(paramavk, (LinkedList)localObject1, paramb, this));
        AppMethodBeat.o(337275);
        return;
      }
    }
    Log.w("Finder.ContactFetcher", "[fetchContact7] req is loading. just return");
    AppMethodBeat.o(337275);
  }
  
  public final void a(avm paramavm, final b<? super ch, ah> paramb)
  {
    AppMethodBeat.i(337261);
    s.u(paramavm, "req");
    s.u(paramb, "call");
    Object localObject2 = paramavm.ZFG;
    Object localObject1 = (Map)this.ADP;
    if (localObject1 == null)
    {
      paramavm = new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
      AppMethodBeat.o(337261);
      throw paramavm;
    }
    if (!((Map)localObject1).containsKey(localObject2))
    {
      Object localObject3 = (Map)this.ADP;
      if (localObject2 == null) {}
      for (localObject1 = "";; localObject1 = localObject2)
      {
        ((Map)localObject3).put(localObject1, this);
        paramavm = p.listOf(paramavm);
        paramb = (b)new f(this, (String)localObject2, paramb);
        s.u(paramavm, "reqList");
        s.u(paramb, "call");
        localObject1 = new LinkedList();
        localObject2 = ay.AAR;
        s.u(paramavm, "fansContactList");
        localObject2 = new ay();
        localObject3 = new c.a();
        Object localObject4 = new aym();
        bi localbi = bi.ABn;
        ((aym)localObject4).ZEc = bi.dVu();
        ((aym)localObject4).ZJt = 2;
        ((aym)localObject4).YIZ = z.bAW();
        ((aym)localObject4).ZJv.addAll((Collection)paramavm);
        ((c.a)localObject3).otE = ((com.tencent.mm.bx.a)localObject4);
        localObject4 = new ayn();
        ((ayn)localObject4).setBaseResponse(new kd());
        ((ayn)localObject4).getBaseResponse().akjO = new etl();
        ((c.a)localObject3).otF = ((com.tencent.mm.bx.a)localObject4);
        ((c.a)localObject3).uri = "/cgi-bin/micromsg-bin/findergetcontactlist";
        ((c.a)localObject3).funcId = 3953;
        ((ay)localObject2).c(((c.a)localObject3).bEF());
        ((ay)localObject2).bFJ().j(new a..ExternalSyntheticLambda6(paramavm, (LinkedList)localObject1, paramb, this));
        AppMethodBeat.o(337261);
        return;
      }
    }
    Log.w("Finder.ContactFetcher", "[fetchContact6] req is loading. just return");
    AppMethodBeat.o(337261);
  }
  
  public final void a(avo paramavo, final b<? super ch, ah> paramb)
  {
    AppMethodBeat.i(337189);
    s.u(paramavo, "req");
    s.u(paramb, "call");
    Object localObject2 = paramavo.ZFM;
    Object localObject1 = (Map)this.ADP;
    if (localObject1 == null)
    {
      paramavo = new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
      AppMethodBeat.o(337189);
      throw paramavo;
    }
    if (!((Map)localObject1).containsKey(localObject2))
    {
      Map localMap = (Map)this.ADP;
      if (localObject2 == null) {}
      for (localObject1 = "";; localObject1 = localObject2)
      {
        localMap.put(localObject1, this);
        paramavo = p.listOf(paramavo);
        paramb = (b)new d(this, (String)localObject2, paramb);
        localObject1 = new LinkedList();
        localObject2 = ay.AAR;
        ay.a.fT(paramavo).bFJ().j(new a..ExternalSyntheticLambda5(paramavo, (LinkedList)localObject1, paramb, this));
        AppMethodBeat.o(337189);
        return;
      }
    }
    Log.w("Finder.ContactFetcher", "fetchContact2[req] is loading. just return");
    AppMethodBeat.o(337189);
  }
  
  public final void a(avr paramavr, final b<? super ch, ah> paramb)
  {
    AppMethodBeat.i(337296);
    s.u(paramavr, "req");
    s.u(paramb, "call");
    Object localObject2 = paramavr.ZFO;
    Object localObject1 = (Map)this.ADP;
    if (localObject1 == null)
    {
      paramavr = new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
      AppMethodBeat.o(337296);
      throw paramavr;
    }
    if (!((Map)localObject1).containsKey(localObject2))
    {
      Object localObject3 = (Map)this.ADP;
      if (localObject2 == null) {}
      for (localObject1 = "";; localObject1 = localObject2)
      {
        ((Map)localObject3).put(localObject1, this);
        paramavr = p.listOf(paramavr);
        paramb = (b)new h(this, (String)localObject2, paramb);
        s.u(paramavr, "reqList");
        s.u(paramb, "call");
        localObject1 = new LinkedList();
        localObject2 = ay.AAR;
        s.u(paramavr, "strangerInfoList");
        localObject2 = new ay();
        localObject3 = new c.a();
        Object localObject4 = new aym();
        bi localbi = bi.ABn;
        ((aym)localObject4).ZEc = bi.dVu();
        ((aym)localObject4).ZJt = 7;
        ((aym)localObject4).YIZ = z.bAW();
        ((aym)localObject4).ZJz.addAll((Collection)paramavr);
        ((c.a)localObject3).otE = ((com.tencent.mm.bx.a)localObject4);
        localObject4 = new ayn();
        ((ayn)localObject4).setBaseResponse(new kd());
        ((ayn)localObject4).getBaseResponse().akjO = new etl();
        ((c.a)localObject3).otF = ((com.tencent.mm.bx.a)localObject4);
        ((c.a)localObject3).uri = "/cgi-bin/micromsg-bin/findergetcontactlist";
        ((c.a)localObject3).funcId = 3953;
        ((ay)localObject2).c(((c.a)localObject3).bEF());
        ((ay)localObject2).bFJ().j(new a..ExternalSyntheticLambda3(paramavr, (LinkedList)localObject1, paramb, this));
        AppMethodBeat.o(337296);
        return;
      }
    }
    Log.w("Finder.ContactFetcher", "[fetchContact8] req is loading. just return");
    AppMethodBeat.o(337296);
  }
  
  public final void a(List<String> paramList, b<? super List<? extends ch>, ah> paramb, int paramInt)
  {
    AppMethodBeat.i(337158);
    s.u(paramList, "reqList");
    s.u(paramb, "call");
    LinkedList localLinkedList = new LinkedList();
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(337158);
      return;
      Object localObject1 = ay.AAR;
      s.u(paramList, "usernameList");
      localObject1 = new ay();
      c.a locala = new c.a();
      Object localObject2 = new aym();
      bi localbi = bi.ABn;
      ((aym)localObject2).ZEc = bi.dVu();
      ((aym)localObject2).ZJs.addAll((Collection)paramList);
      ((aym)localObject2).ZJt = 0;
      ((aym)localObject2).YIZ = z.bAW();
      locala.otE = ((com.tencent.mm.bx.a)localObject2);
      localObject2 = new ayn();
      ((ayn)localObject2).setBaseResponse(new kd());
      ((ayn)localObject2).getBaseResponse().akjO = new etl();
      locala.otF = ((com.tencent.mm.bx.a)localObject2);
      locala.uri = "/cgi-bin/micromsg-bin/findergetcontactlist";
      locala.funcId = 3953;
      ((ay)localObject1).c(locala.bEF());
      Log.i("Finder.CgiGetFinderContact", s.X("[CgiGetFinderContact] username=", paramList));
      ((ay)localObject1).bFJ().j(new a..ExternalSyntheticLambda1(this, localLinkedList, paramList, paramb));
      AppMethodBeat.o(337158);
      return;
      localObject1 = ay.AAR;
      s.u(paramList, "usernameList");
      localObject1 = new ay();
      locala = new c.a();
      localObject2 = new aym();
      localbi = bi.ABn;
      ((aym)localObject2).ZEc = bi.dVu();
      ((aym)localObject2).ZJs.addAll((Collection)paramList);
      ((aym)localObject2).ZJt = 4;
      ((aym)localObject2).YIZ = z.bAW();
      locala.otE = ((com.tencent.mm.bx.a)localObject2);
      localObject2 = new ayn();
      ((ayn)localObject2).setBaseResponse(new kd());
      ((ayn)localObject2).getBaseResponse().akjO = new etl();
      locala.otF = ((com.tencent.mm.bx.a)localObject2);
      locala.uri = "/cgi-bin/micromsg-bin/findergetcontactlist";
      locala.funcId = 3953;
      ((ay)localObject1).c(locala.bEF());
      Log.i("Finder.CgiGetFinderContact", s.X("[CgiGetFinderContact] username=", paramList));
      ((ay)localObject1).bFJ().j(new a..ExternalSyntheticLambda0(this, localLinkedList, paramList, paramb));
    }
  }
  
  public final void ah(final b<? super ch, ah> paramb)
  {
    AppMethodBeat.i(337213);
    s.u(paramb, "call");
    Object localObject2 = z.bAX();
    if (!this.ADP.containsKey(localObject2))
    {
      Object localObject3 = (Map)this.ADP;
      if (localObject2 == null) {}
      for (Object localObject1 = "";; localObject1 = localObject2)
      {
        ((Map)localObject3).put(localObject1, this);
        paramb = (b)new i(this, (String)localObject2, paramb);
        localObject1 = new LinkedList();
        localObject2 = ay.AAR;
        localObject2 = new ay();
        localObject3 = new c.a();
        Object localObject4 = new aym();
        bi localbi = bi.ABn;
        ((aym)localObject4).ZEc = bi.dVu();
        ((aym)localObject4).ZJt = 5;
        ((aym)localObject4).YIZ = z.bAW();
        ((c.a)localObject3).otE = ((com.tencent.mm.bx.a)localObject4);
        localObject4 = new ayn();
        ((ayn)localObject4).setBaseResponse(new kd());
        ((ayn)localObject4).getBaseResponse().akjO = new etl();
        ((c.a)localObject3).otF = ((com.tencent.mm.bx.a)localObject4);
        ((c.a)localObject3).uri = "/cgi-bin/micromsg-bin/findergetcontactlist";
        ((c.a)localObject3).funcId = 3953;
        ((ay)localObject2).c(((c.a)localObject3).bEF());
        Log.i("Finder.CgiGetFinderContact", "[CgiGetFinderContact] ");
        ((ay)localObject2).bFJ().j(new a..ExternalSyntheticLambda2((LinkedList)localObject1, paramb, this));
        AppMethodBeat.o(337213);
        return;
      }
    }
    Log.w("Finder.ContactFetcher", "fetchAliasContact[req] is loading. just return");
    AppMethodBeat.o(337213);
  }
  
  public final void b(final String paramString, final b<? super ch, ah> paramb, int paramInt)
  {
    AppMethodBeat.i(337172);
    s.u(paramString, "req");
    s.u(paramb, "call");
    if (!this.ADP.containsKey(paramString))
    {
      ((Map)this.ADP).put(paramString, this);
      a(p.listOf(paramString), (b)new c(this, paramString, paramb), paramInt);
      AppMethodBeat.o(337172);
      return;
    }
    Log.w("Finder.ContactFetcher", "fetchContact[req] is loading. just return");
    AppMethodBeat.o(337172);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderContactFetcher$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderMsgAliasContactStorage;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<aa>
  {
    public static final b ADS;
    
    static
    {
      AppMethodBeat.i(336855);
      ADS = new b();
      AppMethodBeat.o(336855);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "resultList", "", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<List<? extends ch>, ah>
  {
    c(a parama, String paramString, b<? super ch, ah> paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "resultList", "", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements b<List<? extends ch>, ah>
  {
    d(a parama, String paramString, b<? super ch, ah> paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "resultList", "", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements b<List<? extends ch>, ah>
  {
    f(a parama, String paramString, b<? super ch, ah> paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "resultList", "", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements b<List<? extends ch>, ah>
  {
    h(a parama, String paramString, b<? super ch, ah> paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "resultList", "", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements b<List<? extends ch>, ah>
  {
    i(a parama, String paramString, b<? super ch, ah> paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<ab>
  {
    public static final j ADW;
    
    static
    {
      AppMethodBeat.i(336817);
      ADW = new j();
      AppMethodBeat.o(336817);
    }
    
    j()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.fetcher.a
 * JD-Core Version:    0.7.0.1
 */