package com.tencent.mm.plugin.finder.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.d;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.conv.o;
import com.tencent.mm.plugin.finder.storage.aa;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.plugin.finder.storage.ak;
import com.tencent.mm.plugin.finder.storage.f;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.findersdk.a.bp;
import com.tencent.mm.plugin.findersdk.a.ch;
import com.tencent.mm.plugin.findersdk.a.y;
import com.tencent.mm.plugin.findersdk.a.y.a;
import com.tencent.mm.plugin.findersdk.a.y.b;
import com.tencent.mm.protocal.protobuf.avk;
import com.tencent.mm.protocal.protobuf.avm;
import com.tencent.mm.protocal.protobuf.avo;
import com.tencent.mm.protocal.protobuf.avr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.bx.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/service/FinderContactService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderContactService;", "()V", "aliasContactStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderMsgAliasContactStorage;", "getAliasContactStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderMsgAliasContactStorage;", "aliasContactStorage$delegate", "Lkotlin/Lazy;", "cacheContactItems", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "", "contactExtension", "Lcom/tencent/mm/storage/IContactStorage$IContactExtension;", "getContactExtension", "()Lcom/tencent/mm/storage/IContactStorage$IContactExtension;", "finderContactFetcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderContactFetcher;", "getFinderContactFetcher", "()Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderContactFetcher;", "finderContactFetcher$delegate", "gettingContactSet", "Ljava/util/concurrent/ConcurrentHashMap;", "", "sessionInfoStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "getSessionInfoStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "sessionInfoStorage$delegate", "strangerContactStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;", "getStrangerContactStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;", "strangerContactStorage$delegate", "addOnStorageChange", "", "storageChange", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "checkContactExpired", "username", "isCheckAvatar", "", "clearFollowStateCache", "follow", "finderUser", "opType", "", "feedId", "", "isPrivate", "fromCommentScene", "getAllFollowedContact", "", "Lcom/tencent/mm/storage/Contact;", "getContactTableInfo", "getFinderContact", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderContactService$GetContactCallback;", "type", "usernameList", "", "Lcom/tencent/mm/plugin/findersdk/api/IFinderContactService$GetContactListCallback;", "limitTimeMs", "getFinderContactImpl", "expiredTimeMs", "getFinderMsgAliasContact", "sessionId", "getFinderMsgCommentLikeContact", "commentId", "commentLikeId", "getFinderMsgContactByName", "getFinderMsgFansContact", "fansId", "getFinderMsgStrangerContact", "objectId", "getFollowState", "Lcom/tencent/mm/plugin/findersdk/api/IFinderContactService$GetFollowStateCallback;", "getIContactExtension", "getLocalContact", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "getLocalFinderContact", "getLocalFinderMsgAliasContact", "getLocalFinderMsgStrangerContact", "insertOrUpdateContact", "contact", "isContactExpired", "isAd", "isContactFromMatch", "isContactRetryLimited", "isSessionMute", "talker", "removeOnStorageChange", "simpleTalker", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements y
{
  public static final a FyJ;
  private final j ADQ;
  private final j ADR;
  private final j AFU;
  private final j FyK;
  private final Map<String, m> FyL;
  private final ConcurrentHashMap<String, Object> FyM;
  private final bx.a pqO;
  
  static
  {
    AppMethodBeat.i(330205);
    FyJ = new a((byte)0);
    AppMethodBeat.o(330205);
  }
  
  public a()
  {
    AppMethodBeat.i(330085);
    this.AFU = k.cm((kotlin.g.a.a)a.q.FyT);
    this.ADQ = k.cm((kotlin.g.a.a)r.FyU);
    this.ADR = k.cm((kotlin.g.a.a)b.FyN);
    this.FyK = k.cm((kotlin.g.a.a)h.FyQ);
    this.FyL = Collections.synchronizedMap((Map)new HashMap());
    this.pqO = ((bx.a)new g(this));
    this.FyM = new ConcurrentHashMap();
    AppMethodBeat.o(330085);
  }
  
  private static final void a(y.a parama, List paramList)
  {
    AppMethodBeat.i(330166);
    s.u(parama, "$callback");
    s.s(paramList, "contact");
    parama.onDone((ch)p.oL(paramList));
    AppMethodBeat.o(330166);
  }
  
  private void a(List<String> paramList, y.b paramb, int paramInt)
  {
    AppMethodBeat.i(330114);
    s.u(paramList, "usernameList");
    s.u(paramb, "callback");
    a(paramList, paramb, paramInt, -1L);
    AppMethodBeat.o(330114);
  }
  
  private final void a(List<String> paramList, y.b paramb, int paramInt, long paramLong)
  {
    AppMethodBeat.i(330128);
    Log.i("Finder.ContactService", s.X("[getContact] begin... usernameList=", paramList));
    a..ExternalSyntheticLambda2 localExternalSyntheticLambda2 = new a..ExternalSyntheticLambda2(paramList, paramb);
    LinkedList localLinkedList2 = new LinkedList();
    LinkedList localLinkedList1 = new LinkedList();
    Iterator localIterator = ((Iterable)paramList).iterator();
    int i;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (((CharSequence)str).length() == 0) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label133;
        }
        Log.e("Finder.ContactService", "username is null.");
        localLinkedList2.add(new m());
        break;
      }
      label133:
      if (paramInt == 4)
      {
        paramb = com.tencent.mm.plugin.finder.api.a.AwT;
        paramb = com.tencent.mm.plugin.finder.api.a.a.auQ(str);
        label148:
        if (paramb != null)
        {
          if (((CharSequence)paramb.getNickname()).length() != 0) {
            break label261;
          }
          i = 1;
          label170:
          if ((i == 0) && (!a((ch)paramb, paramLong, 2))) {
            break label338;
          }
        }
        if ((!b((ch)paramb)) || (a((ch)paramb, paramLong, 2))) {
          break label275;
        }
        if (paramb != null) {
          break label267;
        }
      }
      label261:
      label267:
      for (paramb = null;; paramb = paramb.getUsername())
      {
        Log.e("Finder.ContactService", s.X("[getFinderContact] isContactRetryLimited contact=", paramb));
        localLinkedList2.add(new m(str));
        break;
        paramb = d.AwY;
        paramb = d.a.auT(str);
        break label148;
        i = 0;
        break label170;
      }
      label275:
      StringBuilder localStringBuilder = new StringBuilder("contact is null[");
      if (paramb == null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("Finder.ContactService", bool + "]. username=" + str);
        localLinkedList1.add(str);
        break;
      }
      label338:
      localLinkedList2.add(paramb);
    }
    if (!((Collection)localLinkedList1).isEmpty()) {
      i = 1;
    }
    while (i != 0)
    {
      if (paramInt == 4)
      {
        paramb = com.tencent.mm.plugin.finder.api.a.AwT;
        if (com.tencent.mm.plugin.finder.api.a.a.dTZ())
        {
          localExternalSyntheticLambda2.onDone(null);
          AppMethodBeat.o(330128);
          return;
          i = 0;
          continue;
        }
      }
      if (localLinkedList1.size() > 1)
      {
        ePq().a(paramList, (b)new i(localExternalSyntheticLambda2), paramInt);
        AppMethodBeat.o(330128);
        return;
      }
      paramList = ePq();
      paramb = localLinkedList1.getFirst();
      s.s(paramb, "reqList.first");
      paramList.b((String)paramb, (b)new j(localExternalSyntheticLambda2), paramInt);
      AppMethodBeat.o(330128);
      return;
    }
    localExternalSyntheticLambda2.onDone((List)localLinkedList2);
    AppMethodBeat.o(330128);
  }
  
  private static final void a(List paramList1, y.b paramb, List paramList2)
  {
    AppMethodBeat.i(330164);
    s.u(paramList1, "$usernameList");
    s.u(paramb, "$callback");
    paramList1 = new StringBuilder("[getContact] completed! usernameList=").append(paramList1).append(" result=");
    s.s(paramList2, "result");
    Object localObject = (Iterable)paramList2;
    Collection localCollection = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ch localch = (ch)((Iterator)localObject).next();
      localCollection.add(localch.getUsername() + '=' + localch.getNickname());
    }
    Log.i("Finder.ContactService", (List)localCollection);
    paramb.onDone(paramList2);
    AppMethodBeat.o(330164);
  }
  
  private static boolean a(ch paramch, long paramLong)
  {
    AppMethodBeat.i(330137);
    long l1;
    if (paramch == null)
    {
      l1 = 0L;
      long l3 = System.currentTimeMillis();
      long l2 = paramLong;
      if (paramLong == -1L) {
        l2 = 86400000L;
      }
      if (l3 - l1 < l2) {
        break label119;
      }
    }
    label119:
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        Log.i("Finder.ContactService", "[isContactExpired] current=" + Util.formatUnixTime(System.currentTimeMillis() / 1000L) + " time=" + Util.formatUnixTime(l1 / 1000L));
      }
      AppMethodBeat.o(330137);
      return bool;
      l1 = paramch.dUt();
      break;
    }
  }
  
  private static final void b(y.a parama, List paramList)
  {
    AppMethodBeat.i(330174);
    s.u(parama, "$callback");
    s.s(paramList, "contact");
    parama.onDone((ch)p.oL(paramList));
    AppMethodBeat.o(330174);
  }
  
  private static boolean b(ch paramch)
  {
    AppMethodBeat.i(330155);
    if (paramch == null) {}
    for (int i = 0; i >= 3; i = paramch.getRetryCount())
    {
      AppMethodBeat.o(330155);
      return true;
    }
    AppMethodBeat.o(330155);
    return false;
  }
  
  private final ab dWJ()
  {
    AppMethodBeat.i(330093);
    ab localab = (ab)this.ADQ.getValue();
    AppMethodBeat.o(330093);
    return localab;
  }
  
  private final aa dWK()
  {
    AppMethodBeat.i(330098);
    aa localaa = (aa)this.ADR.getValue();
    AppMethodBeat.o(330098);
    return localaa;
  }
  
  private final com.tencent.mm.plugin.finder.cgi.fetcher.a ePq()
  {
    AppMethodBeat.i(330107);
    com.tencent.mm.plugin.finder.cgi.fetcher.a locala = (com.tencent.mm.plugin.finder.cgi.fetcher.a)this.FyK.getValue();
    AppMethodBeat.o(330107);
    return locala;
  }
  
  private static final void hu(List paramList) {}
  
  public final void a(ch paramch)
  {
    AppMethodBeat.i(330304);
    s.u(paramch, "contact");
    Object localObject = paramch.getUsername();
    if (localObject != null)
    {
      int i;
      if (((CharSequence)localObject).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label90;
        }
        label42:
        if (localObject == null) {
          break label155;
        }
        if (!(paramch instanceof m)) {
          break label95;
        }
      }
      for (;;)
      {
        if (paramch != null)
        {
          paramch = (m)paramch;
          if (au.bwV((String)localObject))
          {
            localObject = d.AwY;
            d.a.e(paramch);
            AppMethodBeat.o(330304);
            return;
            i = 0;
            break;
            label90:
            localObject = null;
            break label42;
            label95:
            paramch = null;
            continue;
          }
          if (au.bwT((String)localObject))
          {
            ab.a(dWJ(), paramch);
            AppMethodBeat.o(330304);
            return;
          }
          if (au.bwU((String)localObject))
          {
            aa.a(dWK(), paramch);
            AppMethodBeat.o(330304);
            return;
          }
          Log.i("Finder.ContactService", "[insertOrUpdateContact] illegel contact");
        }
      }
    }
    label155:
    AppMethodBeat.o(330304);
  }
  
  public final void a(String paramString, long paramLong1, long paramLong2, long paramLong3, y.a parama)
  {
    AppMethodBeat.i(330278);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("Finder.ContactService", "username is null.");
      if (parama != null) {
        parama.onDone((ch)new m());
      }
      AppMethodBeat.o(330278);
      return;
    }
    if (paramLong1 == 0L)
    {
      Log.e("Finder.ContactService", "feedId is 0.");
      if (parama != null) {
        parama.onDone((ch)new m());
      }
      AppMethodBeat.o(330278);
      return;
    }
    if (paramLong2 == 0L)
    {
      Log.e("Finder.ContactService", "commentId is 0.");
      if (parama != null) {
        parama.onDone((ch)new m());
      }
      AppMethodBeat.o(330278);
      return;
    }
    m localm = dWJ().auT(paramString);
    if (localm != null)
    {
      if (((CharSequence)localm.getNickname()).length() == 0)
      {
        i = 1;
        if ((i == 0) && (!a((ch)localm, 0L, 6))) {
          break label390;
        }
      }
    }
    else
    {
      if ((!b((ch)localm)) || (a((ch)localm, 0L, 6))) {
        break label327;
      }
      if (localm != null) {
        break label311;
      }
      localObject = null;
      label254:
      Log.e("Finder.ContactService", s.X("[getFinderContact] isContactRetryLimited contact=", localObject));
      if (parama != null) {
        if (localm != null) {
          break label321;
        }
      }
    }
    label311:
    label321:
    for (paramString = new m(paramString);; paramString = localm)
    {
      parama.onDone((ch)paramString);
      AppMethodBeat.o(330278);
      return;
      i = 0;
      break;
      localObject = localm.getUsername();
      break label254;
    }
    label327:
    localObject = new avk();
    ((avk)localObject).object_id = paramLong1;
    ((avk)localObject).ZFw = paramLong2;
    ((avk)localObject).Tqf = paramLong3;
    ((avk)localObject).ZFC = paramString;
    ePq().a((avk)localObject, (b)new l(parama));
    AppMethodBeat.o(330278);
    return;
    label390:
    Log.i("Finder.ContactService", "[getFinderMsgFansContact] local completed! result=" + localm.getUsername() + '=' + localm.getNickname());
    if (parama != null) {
      parama.onDone((ch)localm);
    }
    AppMethodBeat.o(330278);
  }
  
  public final void a(String paramString, y.a parama)
  {
    AppMethodBeat.i(330252);
    s.u(paramString, "username");
    s.u(parama, "callback");
    paramString = p.J((Collection)p.listOf(paramString));
    parama = new a..ExternalSyntheticLambda0(parama);
    s.u(paramString, "usernameList");
    s.u(parama, "callback");
    a(paramString, parama, 0);
    AppMethodBeat.o(330252);
  }
  
  public final void a(String paramString1, String paramString2, y.a parama)
  {
    AppMethodBeat.i(330266);
    Object localObject = (CharSequence)paramString1;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("Finder.ContactService", "username is null.");
      if (parama != null) {
        parama.onDone((ch)new m());
      }
      AppMethodBeat.o(330266);
      return;
    }
    localObject = (CharSequence)paramString2;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (i = 1; i != 0; i = 0)
    {
      Log.e("Finder.ContactService", "sessionId is null.");
      if (parama != null) {
        parama.onDone((ch)new m());
      }
      AppMethodBeat.o(330266);
      return;
    }
    localObject = dWJ().auT(paramString1);
    if (localObject != null)
    {
      if (((CharSequence)((m)localObject).getNickname()).length() == 0)
      {
        i = 1;
        if ((i == 0) && (!a((ch)localObject, 0L, 6))) {
          break label358;
        }
      }
    }
    else
    {
      if ((!b((ch)localObject)) || (a((ch)localObject, 0L, 6))) {
        break label302;
      }
      if (localObject != null) {
        break label287;
      }
      paramString2 = null;
      label233:
      Log.e("Finder.ContactService", s.X("[getFinderContact] isContactRetryLimited contact=", paramString2));
      if (parama != null) {
        if (localObject != null) {
          break label296;
        }
      }
    }
    label287:
    label296:
    for (paramString1 = new m(paramString1);; paramString1 = (String)localObject)
    {
      parama.onDone((ch)paramString1);
      AppMethodBeat.o(330266);
      return;
      i = 0;
      break;
      paramString2 = ((m)localObject).getUsername();
      break label233;
    }
    label302:
    localObject = ePq();
    avo localavo = new avo();
    localavo.ZFM = paramString1;
    localavo.session_id = paramString2;
    paramString1 = ah.aiuX;
    ((com.tencent.mm.plugin.finder.cgi.fetcher.a)localObject).a(localavo, (b)new o(parama));
    AppMethodBeat.o(330266);
    return;
    label358:
    Log.i("Finder.ContactService", "[getFinderMsgStrangerContact] local completed! result=" + ((m)localObject).getUsername() + '=' + ((m)localObject).getNickname());
    if (parama != null) {
      parama.onDone((ch)localObject);
    }
    AppMethodBeat.o(330266);
  }
  
  public final ch aAl(String paramString)
  {
    AppMethodBeat.i(330287);
    if (paramString != null)
    {
      d.a locala = d.AwY;
      paramString = (ch)d.a.auT(paramString);
      AppMethodBeat.o(330287);
      return paramString;
    }
    AppMethodBeat.o(330287);
    return null;
  }
  
  public final ch aAm(String paramString)
  {
    ah localah = null;
    AppMethodBeat.i(330292);
    if (paramString != null)
    {
      m localm = dWJ().auT(paramString);
      if (localm == null) {}
      for (;;)
      {
        if (localah == null) {
          Log.i("Finder.ContactService", s.X("[getLocalFinderStrangerContact] get contact return null. ", paramString));
        }
        paramString = (ch)localm;
        AppMethodBeat.o(330292);
        return paramString;
        Log.i("Finder.ContactService", "[getLocalFinderStrangerContact] " + localm.getUsername() + '=' + localm.getNickname());
        localah = ah.aiuX;
      }
    }
    AppMethodBeat.o(330292);
    return null;
  }
  
  public final ch aAn(String paramString)
  {
    ah localah = null;
    AppMethodBeat.i(330294);
    if (paramString != null)
    {
      m localm = dWK().auT(paramString);
      if (localm == null) {}
      for (;;)
      {
        if (localah == null) {
          Log.i("Finder.ContactService", s.X("[getLocalFinderMsgAliasContact] get contact return null. ", paramString));
        }
        paramString = (ch)localm;
        AppMethodBeat.o(330294);
        return paramString;
        Log.i("Finder.ContactService", "[getLocalFinderMsgAliasContact] " + localm.getUsername() + '=' + localm.getNickname());
        localah = ah.aiuX;
      }
    }
    AppMethodBeat.o(330294);
    return null;
  }
  
  public final ch aAo(String paramString)
  {
    AppMethodBeat.i(330299);
    if (paramString != null)
    {
      int i;
      if (((CharSequence)paramString).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label58;
        }
      }
      for (;;)
      {
        if (paramString != null)
        {
          if (au.bwV(paramString))
          {
            paramString = aAl(paramString);
            AppMethodBeat.o(330299);
            return paramString;
            i = 0;
            break;
            label58:
            paramString = null;
            continue;
          }
          if (au.bwT(paramString))
          {
            paramString = aAm(paramString);
            AppMethodBeat.o(330299);
            return paramString;
          }
          if (au.bwU(paramString))
          {
            paramString = aAn(paramString);
            AppMethodBeat.o(330299);
            return paramString;
          }
          AppMethodBeat.o(330299);
          return null;
        }
      }
    }
    AppMethodBeat.o(330299);
    return null;
  }
  
  public final boolean aAp(String paramString)
  {
    AppMethodBeat.i(330314);
    if (((ak)this.AFU.getValue()).aAG(paramString).field_rejectMsg == 1)
    {
      AppMethodBeat.o(330314);
      return true;
    }
    AppMethodBeat.o(330314);
    return false;
  }
  
  public final void b(String paramString, y.a parama)
  {
    AppMethodBeat.i(330256);
    s.u(parama, "callback");
    if (paramString != null) {
      a(p.J((Collection)p.listOf(paramString)), new a..ExternalSyntheticLambda1(parama), 4);
    }
    AppMethodBeat.o(330256);
  }
  
  public final void b(String paramString1, String paramString2, y.a parama)
  {
    AppMethodBeat.i(330269);
    s.u(paramString2, "fansId");
    Object localObject = (CharSequence)paramString1;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("Finder.ContactService", "username is null.");
      if (parama != null) {
        parama.onDone((ch)new m());
      }
      AppMethodBeat.o(330269);
      return;
    }
    localObject = dWJ().auT(paramString1);
    if (localObject != null)
    {
      if (((CharSequence)((m)localObject).getNickname()).length() == 0)
      {
        i = 1;
        if ((i == 0) && (!a((ch)localObject, 0L, 6))) {
          break label286;
        }
      }
    }
    else
    {
      if ((!b((ch)localObject)) || (a((ch)localObject, 0L, 6))) {
        break label238;
      }
      if (localObject != null) {
        break label223;
      }
      paramString2 = null;
      label169:
      Log.e("Finder.ContactService", s.X("[getFinderContact] isContactRetryLimited contact=", paramString2));
      if (parama != null) {
        if (localObject != null) {
          break label232;
        }
      }
    }
    label223:
    label232:
    for (paramString1 = new m(paramString1);; paramString1 = (String)localObject)
    {
      parama.onDone((ch)paramString1);
      AppMethodBeat.o(330269);
      return;
      i = 0;
      break;
      paramString2 = ((m)localObject).getUsername();
      break label169;
    }
    label238:
    localObject = new avm();
    ((avm)localObject).hJS = paramString2;
    ((avm)localObject).ZFG = paramString1;
    ePq().a((avm)localObject, (b)new n(parama));
    AppMethodBeat.o(330269);
    return;
    label286:
    Log.i("Finder.ContactService", "[getFinderMsgFansContact] local completed! result=" + ((m)localObject).getUsername() + '=' + ((m)localObject).getNickname());
    if (parama != null) {
      parama.onDone((ch)localObject);
    }
    AppMethodBeat.o(330269);
  }
  
  public final void bO(String paramString, boolean paramBoolean)
  {
    avo localavo = null;
    int k = 0;
    int j = 0;
    AppMethodBeat.i(330346);
    final String str;
    if (au.aAy(paramString))
    {
      str = ((bp)h.ax(bp.class)).aAw(paramString);
      paramString = (CharSequence)str;
      if ((paramString != null) && (paramString.length() != 0)) {
        break label77;
      }
    }
    label77:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label82;
      }
      AppMethodBeat.o(330346);
      return;
      str = paramString;
      break;
    }
    label82:
    if (this.FyM.containsKey(str))
    {
      AppMethodBeat.o(330346);
      return;
    }
    paramString = av.GiL;
    if (!av.aBV(str))
    {
      AppMethodBeat.o(330346);
      return;
    }
    Object localObject;
    if (au.bwV(str))
    {
      paramString = aAl(str);
      if (paramString != null)
      {
        localObject = (CharSequence)paramString.getNickname();
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label423;
        }
        i = 1;
        label167:
        if (i == 0) {
          if (paramBoolean)
          {
            localObject = (CharSequence)paramString.amx();
            if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
              break label428;
            }
            i = 1;
            label203:
            if (i != 0) {}
          }
          else
          {
            if (!a(paramString, 0L, 6)) {
              break label761;
            }
          }
        }
      }
      if ((b(paramString)) && (!a(paramString, 0L, 6))) {
        break label433;
      }
      paramBoolean = true;
      label236:
      StringBuilder localStringBuilder = new StringBuilder("[checkContactExpired] isNeedGetContact=").append(paramBoolean).append(" talker=").append(str).append(" nickname=");
      if (paramString != null) {
        break label438;
      }
      localObject = null;
      label276:
      localObject = localStringBuilder.append(localObject).append(" avatar=");
      if (paramString != null) {
        break label449;
      }
      paramString = localavo;
      label298:
      Log.i("Finder.ContactService", paramString);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        ((Map)this.FyM).put(str, this);
        if (au.bwV(str))
        {
          com.tencent.mm.plugin.finder.cgi.fetcher.a.a(ePq(), str, (b)new c(this, str));
          AppMethodBeat.o(330346);
          return;
          if (au.bwT(str))
          {
            paramString = (ch)dWJ().auT(str);
            break;
          }
          if (au.bwU(str))
          {
            paramString = (ch)dWK().auT(str);
            break;
          }
          paramString = null;
          break;
          label423:
          i = 0;
          break label167;
          label428:
          i = 0;
          break label203;
          label433:
          paramBoolean = false;
          break label236;
          label438:
          localObject = paramString.getNickname();
          break label276;
          label449:
          paramString = paramString.amx();
          break label298;
        }
        if (au.bwT(str))
        {
          paramString = ((bp)h.ax(bp.class)).eI(str, 3);
          localObject = (CharSequence)paramString;
          if (localObject != null)
          {
            i = j;
            if (((CharSequence)localObject).length() != 0) {}
          }
          else
          {
            i = 1;
          }
          if (i != 0)
          {
            this.FyM.remove(str);
            AppMethodBeat.o(330346);
            return;
          }
          localObject = ePq();
          localavo = new avo();
          localavo.ZFM = str;
          localavo.session_id = paramString;
          paramString = ah.aiuX;
          ((com.tencent.mm.plugin.finder.cgi.fetcher.a)localObject).a(localavo, (b)new d(str, this));
          AppMethodBeat.o(330346);
          return;
        }
        if (au.bwU(str))
        {
          if (s.p(str, z.bAX()))
          {
            ePq().ah((b)new e(str, this));
            AppMethodBeat.o(330346);
            return;
          }
          paramString = ((bp)h.ax(bp.class)).eI(str, 3);
          localObject = (CharSequence)paramString;
          if (localObject != null)
          {
            i = k;
            if (((CharSequence)localObject).length() != 0) {}
          }
          else
          {
            i = 1;
          }
          if (i != 0)
          {
            this.FyM.remove(str);
            AppMethodBeat.o(330346);
            return;
          }
          localObject = ePq();
          localavo = new avo();
          localavo.ZFM = str;
          localavo.session_id = paramString;
          paramString = ah.aiuX;
          ((com.tencent.mm.plugin.finder.cgi.fetcher.a)localObject).a(localavo, (b)new f(str, this));
        }
      }
      AppMethodBeat.o(330346);
      return;
      label761:
      paramBoolean = false;
    }
  }
  
  public final void c(String paramString, y.a parama)
  {
    AppMethodBeat.i(330284);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("Finder.ContactService", "username is null.");
      if (parama != null) {
        parama.onDone((ch)new m());
      }
      AppMethodBeat.o(330284);
      return;
    }
    m localm = dWJ().auT(paramString);
    if (localm != null)
    {
      if (((CharSequence)localm.getNickname()).length() == 0)
      {
        i = 1;
        if ((i == 0) && (!a((ch)localm, 0L, 6))) {
          break label270;
        }
      }
    }
    else
    {
      if ((!b((ch)localm)) || (a((ch)localm, 0L, 6))) {
        break label228;
      }
      if (localm != null) {
        break label212;
      }
      localObject = null;
      label158:
      Log.e("Finder.ContactService", s.X("[getWxMsgContact] isContactRetryLimited contact=", localObject));
      if (parama != null) {
        if (localm != null) {
          break label222;
        }
      }
    }
    label212:
    label222:
    for (paramString = new m(paramString);; paramString = localm)
    {
      parama.onDone((ch)paramString);
      AppMethodBeat.o(330284);
      return;
      i = 0;
      break;
      localObject = localm.getUsername();
      break label158;
    }
    label228:
    localObject = new avr();
    ((avr)localObject).ZFO = paramString;
    ePq().a((avr)localObject, (b)new m(parama));
    AppMethodBeat.o(330284);
    return;
    label270:
    Log.i("Finder.ContactService", "[getWxMsgContact] local completed! result=" + localm.getUsername() + '=' + localm.getNickname());
    if (parama != null) {
      parama.onDone((ch)localm);
    }
    AppMethodBeat.o(330284);
  }
  
  public final void c(String paramString1, String paramString2, y.a parama)
  {
    AppMethodBeat.i(330354);
    Object localObject = (CharSequence)paramString1;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("Finder.ContactService", "username is null.");
      if (parama != null) {
        parama.onDone((ch)new m());
      }
      AppMethodBeat.o(330354);
      return;
    }
    paramString2 = (CharSequence)paramString2;
    if ((paramString2 == null) || (paramString2.length() == 0)) {}
    for (i = 1; i != 0; i = 0)
    {
      Log.e("Finder.ContactService", "sessionId is null.");
      if (parama != null) {
        parama.onDone((ch)new m());
      }
      AppMethodBeat.o(330354);
      return;
    }
    localObject = dWK().auT(paramString1);
    if (localObject != null)
    {
      if (((CharSequence)((m)localObject).getNickname()).length() == 0)
      {
        i = 1;
        if ((i == 0) && (!a((ch)localObject, 0L, 6))) {
          break label324;
        }
      }
    }
    else
    {
      if ((!b((ch)localObject)) || (a((ch)localObject, 0L, 6))) {
        break label299;
      }
      if (localObject != null) {
        break label284;
      }
      paramString2 = null;
      label230:
      Log.e("Finder.ContactService", s.X("[getFinderMsgAliasContact] isContactRetryLimited contact=", paramString2));
      if (parama != null) {
        if (localObject != null) {
          break label293;
        }
      }
    }
    label284:
    label293:
    for (paramString1 = new m(paramString1);; paramString1 = (String)localObject)
    {
      parama.onDone((ch)paramString1);
      AppMethodBeat.o(330354);
      return;
      i = 0;
      break;
      paramString2 = ((m)localObject).getUsername();
      break label230;
    }
    label299:
    ePq().ah((b)new k(parama));
    AppMethodBeat.o(330354);
    return;
    label324:
    Log.i("Finder.ContactService", "[getFinderMsgAliasContact] local completed! result=" + ((m)localObject).getUsername() + '=' + ((m)localObject).getNickname());
    if (parama != null) {
      parama.onDone((ch)localObject);
    }
    AppMethodBeat.o(330354);
  }
  
  public final void ePr()
  {
    AppMethodBeat.i(330318);
    Log.i("Finder.ContactService", "[clearFollowStateCache]");
    this.FyL.clear();
    AppMethodBeat.o(330318);
  }
  
  public final String ePs()
  {
    AppMethodBeat.i(330324);
    String str = ((PluginFinder)h.az(PluginFinder.class)).getContactStorage().eYI();
    AppMethodBeat.o(330324);
    return str;
  }
  
  public final bx.a ePt()
  {
    return this.pqO;
  }
  
  public final List<au> ePu()
  {
    AppMethodBeat.i(330361);
    Object localObject1 = d.AwY;
    Object localObject2 = (Iterable)d.a.dUg();
    localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(m.g((m)((Iterator)localObject2).next()));
    }
    localObject1 = (List)localObject1;
    AppMethodBeat.o(330361);
    return localObject1;
  }
  
  public final void f(List<String> paramList, long paramLong)
  {
    AppMethodBeat.i(330240);
    s.u(paramList, "usernameList");
    a(paramList, a..ExternalSyntheticLambda3.INSTANCE, 0, paramLong);
    AppMethodBeat.o(330240);
  }
  
  public final void l(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(330309);
    if (paramIOnStorageChange != null)
    {
      ((PluginFinder)h.az(PluginFinder.class)).getContactStorage().remove(paramIOnStorageChange);
      ((PluginFinder)h.az(PluginFinder.class)).getMsgStrangerContactStorage().remove(paramIOnStorageChange);
      ((PluginFinder)h.az(PluginFinder.class)).getMsgAliasContactStorage().remove(paramIOnStorageChange);
    }
    AppMethodBeat.o(330309);
  }
  
  public final void m(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(330328);
    if (paramIOnStorageChange != null)
    {
      ((PluginFinder)h.az(PluginFinder.class)).getContactStorage().add(paramIOnStorageChange);
      ((PluginFinder)h.az(PluginFinder.class)).getMsgStrangerContactStorage().add(paramIOnStorageChange);
      ((PluginFinder)h.az(PluginFinder.class)).getMsgAliasContactStorage().add(paramIOnStorageChange);
    }
    AppMethodBeat.o(330328);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/service/FinderContactService$Companion;", "", "()V", "FINDER_AD_CONTACT_EXPIRED_TIME", "", "FINDER_CONTACT_EXPIRED_TIME", "FINDER_CONTACT_LIMIT_TIME", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderMsgAliasContactStorage;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<aa>
  {
    public static final b FyN;
    
    static
    {
      AppMethodBeat.i(330167);
      FyN = new b();
      AppMethodBeat.o(330167);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<ch, ah>
  {
    c(a parama, String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements b<ch, ah>
  {
    d(String paramString, a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements b<ch, ah>
  {
    e(String paramString, a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements b<ch, ah>
  {
    f(String paramString, a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/service/FinderContactService$contactExtension$1", "Lcom/tencent/mm/storage/IContactStorage$IContactExtension;", "get", "Lcom/tencent/mm/storage/Contact;", "username", "", "onPreInsertContact", "", "stg", "Lcom/tencent/mm/storage/IContactStorage;", "contact", "replace", "", "isUpdate", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements bx.a
  {
    g(a parama) {}
    
    public final au JE(String paramString)
    {
      AppMethodBeat.i(330145);
      Object localObject1 = (CharSequence)paramString;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(330145);
        return null;
      }
      String str;
      if (au.aAy(paramString))
      {
        str = ((bp)h.ax(bp.class)).aAw(paramString);
        if ((!au.bwT(str)) && (!au.bwV(str)) && (!au.bwU(str))) {
          break label107;
        }
      }
      label107:
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label112;
        }
        AppMethodBeat.o(330145);
        return null;
        str = paramString;
        break;
      }
      label112:
      if (au.bwV(str))
      {
        localObject1 = d.AwY;
        localObject1 = d.a.auT(str);
        if (localObject1 == null) {
          break label341;
        }
        localObject1 = m.g((m)localObject1);
        if (localObject1 != null)
        {
          localObject2 = (CharSequence)((az)localObject1).field_nickname;
          if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
            break label346;
          }
          i = 1;
          if (i == 0) {
            break label359;
          }
        }
        Object localObject2 = new StringBuilder("[get] contact is null or nickname is empty. nickname=");
        if (localObject1 != null) {
          break label351;
        }
        localObject1 = null;
        localObject1 = ((StringBuilder)localObject2).append(localObject1).append(" talker=");
        s.s(str, "talker");
        Log.e("Finder.ContactService", a.aAq(str));
        this.FyO.bO(str, false);
        localObject1 = new au(paramString);
      }
      label169:
      label190:
      label341:
      label346:
      label351:
      label359:
      for (;;)
      {
        ((au)localObject1).setUsername(paramString);
        AppMethodBeat.o(330145);
        return localObject1;
        if (au.bwT(str))
        {
          localObject1 = a.b(this.FyO);
          s.s(str, "talker");
          localObject1 = ((ab)localObject1).auT(str);
          if (localObject1 == null) {
            break label341;
          }
          localObject1 = m.g((m)localObject1);
          break;
        }
        if (au.bwU(str))
        {
          localObject1 = a.c(this.FyO);
          s.s(str, "talker");
          localObject1 = ((aa)localObject1).auT(str);
          if (localObject1 != null)
          {
            localObject1 = m.g((m)localObject1);
            break;
          }
        }
        localObject1 = null;
        break;
        i = 0;
        break label169;
        localObject1 = ((az)localObject1).field_nickname;
        break label190;
      }
    }
    
    public final void a(bx parambx, au paramau) {}
    
    public final int b(au paramau, boolean paramBoolean)
    {
      AppMethodBeat.i(330127);
      if (paramau == null)
      {
        AppMethodBeat.o(330127);
        return -1;
      }
      String str = paramau.field_username;
      Object localObject = (CharSequence)str;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(330127);
        return -1;
      }
      localObject = str;
      if (au.aAy(str)) {
        localObject = ((bp)h.ax(bp.class)).aAw(str);
      }
      if ((paramau.fromType == 2) || (au.bwT((String)localObject)) || (au.bwV((String)localObject))) {}
      for (i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(330127);
        return -1;
      }
      AppMethodBeat.o(330127);
      return 1;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderContactFetcher;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.cgi.fetcher.a>
  {
    public static final h FyQ;
    
    static
    {
      AppMethodBeat.i(330151);
      FyQ = new h();
      AppMethodBeat.o(330151);
    }
    
    h()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements b<List<? extends ch>, ah>
  {
    i(y.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements b<ch, ah>
  {
    j(y.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements b<ch, ah>
  {
    k(y.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements b<ch, ah>
  {
    l(y.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements b<ch, ah>
  {
    m(y.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends u
    implements b<ch, ah>
  {
    n(y.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends u
    implements b<ch, ah>
  {
    o(y.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends u
    implements b<ch, ah>
  {
    p(y.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class r
    extends u
    implements kotlin.g.a.a<ab>
  {
    public static final r FyU;
    
    static
    {
      AppMethodBeat.i(330096);
      FyU = new r();
      AppMethodBeat.o(330096);
    }
    
    r()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.service.a
 * JD-Core Version:    0.7.0.1
 */