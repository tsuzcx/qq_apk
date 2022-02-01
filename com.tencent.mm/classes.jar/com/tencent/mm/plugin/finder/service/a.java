package com.tencent.mm.plugin.finder.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.d;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.i;
import com.tencent.mm.plugin.finder.storage.af;
import com.tencent.mm.plugin.finder.storage.e;
import com.tencent.mm.plugin.finder.storage.y;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.findersdk.a.ab;
import com.tencent.mm.plugin.findersdk.a.ai;
import com.tencent.mm.plugin.findersdk.a.m;
import com.tencent.mm.plugin.findersdk.a.m.a;
import com.tencent.mm.plugin.findersdk.a.m.b;
import com.tencent.mm.plugin.findersdk.a.m.c;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bv.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.aa.d;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/service/FinderContactService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderContactService;", "()V", "aliasContactStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderMsgAliasContactStorage;", "getAliasContactStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderMsgAliasContactStorage;", "aliasContactStorage$delegate", "Lkotlin/Lazy;", "cacheContactItems", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "", "contactExtension", "Lcom/tencent/mm/storage/IContactStorage$IContactExtension;", "getContactExtension", "()Lcom/tencent/mm/storage/IContactStorage$IContactExtension;", "finderContactFetcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderContactFetcher;", "getFinderContactFetcher", "()Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderContactFetcher;", "finderContactFetcher$delegate", "gettingContactSet", "Ljava/util/concurrent/ConcurrentHashMap;", "", "sessionInfoStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "getSessionInfoStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "sessionInfoStorage$delegate", "strangerContactStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;", "getStrangerContactStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;", "strangerContactStorage$delegate", "addOnStorageChange", "", "storageChange", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "checkContactExpired", "username", "isCheckAvatar", "", "clearFollowStateCache", "follow", "finderUser", "opType", "", "feedId", "", "isPrivate", "fromCommentScene", "getFinderContact", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderContactService$GetContactCallback;", "type", "usernameList", "", "Lcom/tencent/mm/plugin/findersdk/api/IFinderContactService$GetContactListCallback;", "getFinderMsgAliasContact", "sessionId", "getFinderMsgStrangerContact", "commentId", "objectId", "getFollowState", "Lcom/tencent/mm/plugin/findersdk/api/IFinderContactService$GetFollowStateCallback;", "getLocalContact", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "getLocalFinderContact", "getLocalFinderMsgAliasContact", "getLocalFinderMsgStrangerContact", "insertOrUpdateContact", "contact", "isContactExpired", "isAd", "isContactFromMatch", "isContactRetryLimited", "isSessionMute", "talker", "removeOnStorageChange", "simpleTalker", "Companion", "plugin-finder_release"})
public final class a
  implements m
{
  public static final a AcY;
  private final f AcU;
  private final Map<String, i> AcV;
  public final bv.a AcW;
  private final ConcurrentHashMap<String, Object> AcX;
  private final f xeE;
  private final f xeF;
  private final f xgB;
  
  static
  {
    AppMethodBeat.i(221911);
    AcY = new a((byte)0);
    AppMethodBeat.o(221911);
  }
  
  public a()
  {
    AppMethodBeat.i(221910);
    this.xgB = g.ar((kotlin.g.a.a)r.Adj);
    this.xeE = g.ar((kotlin.g.a.a)s.Adk);
    this.xeF = g.ar((kotlin.g.a.a)b.AcZ);
    this.AcU = g.ar((kotlin.g.a.a)h.Adb);
    this.AcV = Collections.synchronizedMap((Map)new HashMap());
    this.AcW = ((bv.a)new g(this));
    this.AcX = new ConcurrentHashMap();
    AppMethodBeat.o(221910);
  }
  
  private void a(List<String> paramList, final m.b paramb, int paramInt)
  {
    AppMethodBeat.i(221780);
    p.k(paramList, "usernameList");
    p.k(paramb, "callback");
    Log.i("Finder.ContactService", "[getContact] begin... usernameList=".concat(String.valueOf(paramList)));
    m.b localb = (m.b)new m(paramList, paramb);
    LinkedList localLinkedList2 = new LinkedList();
    LinkedList localLinkedList1 = new LinkedList();
    Iterator localIterator = ((Iterable)paramList).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (((CharSequence)str).length() == 0) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label147;
        }
        Log.e("Finder.ContactService", "username is null.");
        localLinkedList2.add(new i());
        break;
      }
      label147:
      if (paramInt == 4)
      {
        paramb = com.tencent.mm.plugin.finder.api.a.wZL;
        if (Util.isNullOrNil(str))
        {
          i = 0;
          label167:
          if (i == 0) {
            break label464;
          }
          paramb = d.wZQ;
          paramb = d.a.aAK(str);
          localObject = com.tencent.mm.plugin.finder.api.a.dnd();
          if (str == null) {
            p.iCn();
          }
          localObject = ((com.tencent.mm.plugin.finder.api.a.b)localObject).aAI(str);
          if (localObject == null) {
            break label459;
          }
          if (paramb != null)
          {
            i = paramb.field_follow_Flag;
            Log.i("Finder.FinderAdContactLogic", "update cache field_follow_Flag ".concat(String.valueOf(i)));
            ((i)localObject).field_follow_Flag = i;
          }
          i = ((com.tencent.mm.plugin.b)h.ae(com.tencent.mm.plugin.b.class)).aad(str);
          paramb = (m.b)localObject;
          if (i > 0)
          {
            ((i)localObject).field_friendFollowCount = i;
            paramb = (m.b)localObject;
          }
          label279:
          if (paramb != null)
          {
            if (((CharSequence)paramb.getNickname()).length() != 0) {
              break label482;
            }
            i = 1;
            label301:
            if ((i == 0) && (!b((ai)paramb))) {
              break label555;
            }
          }
          if ((!c((ai)paramb)) || (b((ai)paramb))) {
            break label493;
          }
          localObject = new StringBuilder("[getFinderContact] isContactRetryLimited contact=");
          if (paramb == null) {
            break label488;
          }
        }
      }
      label447:
      label453:
      label459:
      label464:
      label482:
      label488:
      for (paramb = paramb.getUsername();; paramb = null)
      {
        Log.e("Finder.ContactService", paramb);
        localLinkedList2.add(new i(str));
        break;
        paramb = com.tencent.mm.plugin.finder.api.a.dnd();
        if (str == null) {
          p.iCn();
        }
        paramb = paramb.aAI(str);
        if (paramb != null)
        {
          paramb = (CharSequence)paramb.field_username;
          if ((paramb != null) && (paramb.length() != 0)) {
            break label447;
          }
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label453;
          }
          i = 0;
          break;
        }
        i = 1;
        break label167;
        paramb = null;
        break label279;
        paramb = null;
        break label279;
        paramb = d.wZQ;
        paramb = d.a.aAK(str);
        break label279;
        i = 0;
        break label301;
      }
      label493:
      Object localObject = new StringBuilder("contact is null[");
      if (paramb == null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("Finder.ContactService", bool + "]. username=" + str);
        localLinkedList1.add(str);
        break;
      }
      label555:
      localLinkedList2.add(paramb);
    }
    if (!((Collection)localLinkedList1).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label763;
      }
      if (paramInt != 4) {
        break label682;
      }
      paramb = com.tencent.mm.plugin.finder.api.a.wZL;
      if ((com.tencent.mm.plugin.finder.api.a.dnf() == 0L) || (com.tencent.mm.plugin.finder.api.a.dne() <= 0) || (cm.bfE() - com.tencent.mm.plugin.finder.api.a.dnf() >= com.tencent.mm.plugin.finder.api.a.dne())) {
        break label661;
      }
      Log.i("Finder.FinderAdContactLogic", "interceptRequest");
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label682;
      }
      localb.eK(null);
      AppMethodBeat.o(221780);
      return;
      i = 0;
      break;
      label661:
      Log.i("Finder.FinderAdContactLogic", "not interceptRequest");
      com.tencent.mm.plugin.finder.api.a.Kt(cm.bfE());
    }
    label682:
    if (localLinkedList1.size() > 1)
    {
      dRp().a(paramList, (kotlin.g.a.b)new j(localb), paramInt);
      AppMethodBeat.o(221780);
      return;
    }
    paramList = dRp();
    paramb = localLinkedList1.getFirst();
    p.j(paramb, "reqList.first");
    paramList.a((String)paramb, (kotlin.g.a.b)new k(localb), paramInt);
    AppMethodBeat.o(221780);
    return;
    label763:
    localb.eK((List)localLinkedList2);
    AppMethodBeat.o(221780);
  }
  
  private static boolean b(ai paramai)
  {
    AppMethodBeat.i(221891);
    long l;
    if (paramai != null)
    {
      l = paramai.dnn();
      if (System.currentTimeMillis() - l < 86400000L) {
        break label96;
      }
    }
    label96:
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        Log.i("Finder.ContactService", "[isContactExpired] current=" + Util.formatUnixTime(System.currentTimeMillis() / 1000L) + " time=" + Util.formatUnixTime(l / 1000L));
      }
      AppMethodBeat.o(221891);
      return bool;
      l = 0L;
      break;
    }
  }
  
  private static boolean c(ai paramai)
  {
    AppMethodBeat.i(221893);
    if (paramai != null) {}
    for (int i = paramai.getRetryCount(); i >= 3; i = 0)
    {
      AppMethodBeat.o(221893);
      return true;
    }
    AppMethodBeat.o(221893);
    return false;
  }
  
  private final com.tencent.mm.plugin.finder.cgi.fetcher.a dRp()
  {
    AppMethodBeat.i(221763);
    com.tencent.mm.plugin.finder.cgi.fetcher.a locala = (com.tencent.mm.plugin.finder.cgi.fetcher.a)this.AcU.getValue();
    AppMethodBeat.o(221763);
    return locala;
  }
  
  private final com.tencent.mm.plugin.finder.storage.z dpi()
  {
    AppMethodBeat.i(221757);
    com.tencent.mm.plugin.finder.storage.z localz = (com.tencent.mm.plugin.finder.storage.z)this.xeE.getValue();
    AppMethodBeat.o(221757);
    return localz;
  }
  
  private final y dpj()
  {
    AppMethodBeat.i(221760);
    y localy = (y)this.xeF.getValue();
    AppMethodBeat.o(221760);
    return localy;
  }
  
  public final int a(final String paramString, final m.c paramc)
  {
    AppMethodBeat.i(221868);
    Log.i("Finder.ContactService", "[getFollowState] username:".concat(String.valueOf(paramString)));
    if (paramString == null)
    {
      AppMethodBeat.o(221868);
      return 3;
    }
    final aa.d locald = new aa.d();
    locald.aaBA = 1;
    i locali = (i)this.AcV.get(paramString);
    if (locali != null)
    {
      Log.i("Finder.ContactService", "[getFollowState] cache user:".concat(String.valueOf(locali)));
      i = locali.field_follow_Flag;
      paramString = i.xai;
      if (i == i.dny()) {}
      for (i = 2;; i = 3)
      {
        locald.aaBA = i;
        i = locald.aaBA;
        AppMethodBeat.o(221868);
        return i;
      }
    }
    com.tencent.mm.plugin.finder.cgi.fetcher.a.a(dRp(), paramString, (kotlin.g.a.b)new q(this, locald, paramString, paramc));
    int i = locald.aaBA;
    AppMethodBeat.o(221868);
    return i;
  }
  
  public final void a(ai paramai)
  {
    AppMethodBeat.i(221856);
    p.k(paramai, "contact");
    Object localObject = paramai.getUsername();
    if (localObject != null)
    {
      int i;
      if (((CharSequence)localObject).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label85;
        }
        label42:
        if (localObject == null) {
          break label191;
        }
        if (!(paramai instanceof i)) {
          break label90;
        }
      }
      for (;;)
      {
        if (paramai != null)
        {
          if (paramai == null)
          {
            paramai = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.api.LocalFinderContact");
            AppMethodBeat.o(221856);
            throw paramai;
            i = 0;
            break;
            label85:
            localObject = null;
            break label42;
            label90:
            paramai = null;
            continue;
          }
          paramai = (i)paramai;
          if (as.bvP((String)localObject))
          {
            localObject = d.wZQ;
            d.a.d(paramai);
            AppMethodBeat.o(221856);
            return;
          }
          if (as.bvN((String)localObject))
          {
            com.tencent.mm.plugin.finder.storage.z.a(dpi(), paramai);
            AppMethodBeat.o(221856);
            return;
          }
          if (as.bvO((String)localObject))
          {
            y.a(dpj(), paramai);
            AppMethodBeat.o(221856);
            return;
          }
          Log.i("Finder.ContactService", "[insertOrUpdateContact] illegel contact");
          AppMethodBeat.o(221856);
          return;
        }
      }
      AppMethodBeat.o(221856);
      return;
    }
    label191:
    AppMethodBeat.o(221856);
  }
  
  public final void a(String paramString, m.a parama)
  {
    AppMethodBeat.i(221787);
    p.k(paramString, "username");
    p.k(parama, "callback");
    paramString = j.t((Collection)j.listOf(paramString));
    parama = (m.b)new l(parama);
    p.k(paramString, "usernameList");
    p.k(parama, "callback");
    a(paramString, parama, 0);
    AppMethodBeat.o(221787);
  }
  
  public final void a(String paramString1, String paramString2, m.a parama)
  {
    AppMethodBeat.i(221795);
    Object localObject1 = (CharSequence)paramString1;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("Finder.ContactService", "username is null.");
      parama.d((ai)new i());
      AppMethodBeat.o(221795);
      return;
    }
    localObject1 = (CharSequence)paramString2;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (i = 1; i != 0; i = 0)
    {
      Log.e("Finder.ContactService", "sessionId is null.");
      parama.d((ai)new i());
      AppMethodBeat.o(221795);
      return;
    }
    localObject1 = dpi().aAK(paramString1);
    if (localObject1 != null)
    {
      if (((CharSequence)((i)localObject1).getNickname()).length() == 0)
      {
        i = 1;
        if ((i == 0) && (!b((ai)localObject1))) {
          break label350;
        }
      }
    }
    else
    {
      if ((!c((ai)localObject1)) || (b((ai)localObject1))) {
        break label298;
      }
      localObject2 = new StringBuilder("[getFinderContact] isContactRetryLimited contact=");
      if (localObject1 == null) {
        break label278;
      }
      paramString2 = ((i)localObject1).getUsername();
      label233:
      Log.e("Finder.ContactService", paramString2);
      if (localObject1 == null) {
        break label283;
      }
    }
    label278:
    label283:
    for (paramString1 = (ai)localObject1;; paramString1 = (ai)new i(paramString1))
    {
      parama.d(paramString1);
      AppMethodBeat.o(221795);
      return;
      i = 0;
      break;
      paramString2 = null;
      break label233;
    }
    label298:
    localObject1 = dRp();
    Object localObject2 = new arg();
    ((arg)localObject2).SEn = paramString1;
    ((arg)localObject2).session_id = paramString2;
    ((com.tencent.mm.plugin.finder.cgi.fetcher.a)localObject1).a((arg)localObject2, (kotlin.g.a.b)new o(parama));
    AppMethodBeat.o(221795);
    return;
    label350:
    Log.i("Finder.ContactService", "[getFinderMsgStrangerContact] local completed! result=" + ((i)localObject1).getUsername() + '=' + ((i)localObject1).getNickname());
    parama.d((ai)localObject1);
    AppMethodBeat.o(221795);
  }
  
  public final ai aEs(String paramString)
  {
    AppMethodBeat.i(221821);
    if (paramString != null)
    {
      d.a locala = d.wZQ;
      paramString = (ai)d.a.aAK(paramString);
      AppMethodBeat.o(221821);
      return paramString;
    }
    AppMethodBeat.o(221821);
    return null;
  }
  
  public final ai aEt(String paramString)
  {
    AppMethodBeat.i(221832);
    if (paramString != null)
    {
      i locali = dpi().aAK(paramString);
      if (locali != null) {
        Log.i("Finder.ContactService", "[getLocalFinderStrangerContact] " + locali.getUsername() + '=' + locali.getNickname());
      }
      for (;;)
      {
        paramString = (ai)locali;
        AppMethodBeat.o(221832);
        return paramString;
        Log.i("Finder.ContactService", "[getLocalFinderStrangerContact] get contact return null. ".concat(String.valueOf(paramString)));
      }
    }
    AppMethodBeat.o(221832);
    return null;
  }
  
  public final ai aEu(String paramString)
  {
    AppMethodBeat.i(221841);
    if (paramString != null)
    {
      i locali = dpj().aAK(paramString);
      if (locali != null) {
        Log.i("Finder.ContactService", "[getLocalFinderMsgAliasContact] " + locali.getUsername() + '=' + locali.getNickname());
      }
      for (;;)
      {
        paramString = (ai)locali;
        AppMethodBeat.o(221841);
        return paramString;
        Log.i("Finder.ContactService", "[getLocalFinderMsgAliasContact] get contact return null. ".concat(String.valueOf(paramString)));
      }
    }
    AppMethodBeat.o(221841);
    return null;
  }
  
  public final ai aEv(String paramString)
  {
    AppMethodBeat.i(221846);
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
          if (as.bvP(paramString))
          {
            paramString = aEs(paramString);
            AppMethodBeat.o(221846);
            return paramString;
            i = 0;
            break;
            label58:
            paramString = null;
            continue;
          }
          if (as.bvN(paramString))
          {
            paramString = aEt(paramString);
            AppMethodBeat.o(221846);
            return paramString;
          }
          if (as.bvO(paramString))
          {
            paramString = aEu(paramString);
            AppMethodBeat.o(221846);
            return paramString;
          }
          AppMethodBeat.o(221846);
          return null;
        }
      }
    }
    AppMethodBeat.o(221846);
    return null;
  }
  
  public final boolean aEw(String paramString)
  {
    AppMethodBeat.i(221862);
    if (((af)this.xgB.getValue()).aEN(paramString).field_rejectMsg == 1)
    {
      AppMethodBeat.o(221862);
      return true;
    }
    AppMethodBeat.o(221862);
    return false;
  }
  
  public final void b(String paramString, final m.a parama)
  {
    AppMethodBeat.i(221789);
    p.k(parama, "callback");
    if (paramString != null)
    {
      a(j.t((Collection)j.listOf(paramString)), (m.b)new i(this, parama), 4);
      AppMethodBeat.o(221789);
      return;
    }
    AppMethodBeat.o(221789);
  }
  
  public final void b(String paramString1, String paramString2, m.a parama)
  {
    AppMethodBeat.i(221907);
    Object localObject = (CharSequence)paramString1;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("Finder.ContactService", "username is null.");
      parama.d((ai)new i());
      AppMethodBeat.o(221907);
      return;
    }
    paramString2 = (CharSequence)paramString2;
    if ((paramString2 == null) || (paramString2.length() == 0)) {}
    for (i = 1; i != 0; i = 0)
    {
      Log.e("Finder.ContactService", "sessionId is null.");
      parama.d((ai)new i());
      AppMethodBeat.o(221907);
      return;
    }
    localObject = dpj().aAK(paramString1);
    if (localObject != null)
    {
      if (((CharSequence)((i)localObject).getNickname()).length() == 0)
      {
        i = 1;
        if ((i == 0) && (!b((ai)localObject))) {
          break label320;
        }
      }
    }
    else
    {
      if ((!c((ai)localObject)) || (b((ai)localObject))) {
        break label295;
      }
      StringBuilder localStringBuilder = new StringBuilder("[getFinderMsgAliasContact] isContactRetryLimited contact=");
      if (localObject == null) {
        break label275;
      }
      paramString2 = ((i)localObject).getUsername();
      label230:
      Log.e("Finder.ContactService", paramString2);
      if (localObject == null) {
        break label280;
      }
    }
    label275:
    label280:
    for (paramString1 = (ai)localObject;; paramString1 = (ai)new i(paramString1))
    {
      parama.d(paramString1);
      AppMethodBeat.o(221907);
      return;
      i = 0;
      break;
      paramString2 = null;
      break label230;
    }
    label295:
    dRp().E((kotlin.g.a.b)new n(parama));
    AppMethodBeat.o(221907);
    return;
    label320:
    Log.i("Finder.ContactService", "[getFinderMsgAliasContact] local completed! result=" + ((i)localObject).getUsername() + '=' + ((i)localObject).getNickname());
    parama.d((ai)localObject);
    AppMethodBeat.o(221907);
  }
  
  public final void bx(String paramString, boolean paramBoolean)
  {
    arg localarg = null;
    int k = 0;
    int j = 0;
    AppMethodBeat.i(221886);
    final String str;
    if (as.aEF(paramString))
    {
      str = ((ab)h.ae(ab.class)).aED(paramString);
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
      AppMethodBeat.o(221886);
      return;
      str = paramString;
      break;
    }
    label82:
    if (this.AcX.containsKey(str))
    {
      AppMethodBeat.o(221886);
      return;
    }
    paramString = aj.AGc;
    if (!aj.aFW(str))
    {
      AppMethodBeat.o(221886);
      return;
    }
    Object localObject;
    if (as.bvP(str))
    {
      paramString = aEs(str);
      if (paramString != null)
      {
        localObject = (CharSequence)paramString.getNickname();
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label430;
        }
        i = 1;
        label167:
        if (i == 0) {
          if (paramBoolean)
          {
            localObject = (CharSequence)paramString.Mm();
            if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
              break label435;
            }
            i = 1;
            label203:
            if (i != 0) {}
          }
          else
          {
            if (!b(paramString)) {
              break label745;
            }
          }
        }
      }
      if ((c(paramString)) && (!b(paramString))) {
        break label440;
      }
      paramBoolean = true;
      label230:
      StringBuilder localStringBuilder = new StringBuilder("[checkContactExpired] isNeedGetContact=").append(paramBoolean).append(" talker=").append(str).append(" nickname=");
      if (paramString == null) {
        break label445;
      }
      localObject = paramString.getNickname();
      label275:
      localStringBuilder = localStringBuilder.append((String)localObject).append(" avatar=");
      localObject = localarg;
      if (paramString != null) {
        localObject = paramString.Mm();
      }
      Log.i("Finder.ContactService", (String)localObject);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        ((Map)this.AcX).put(str, this);
        if (as.bvP(str))
        {
          com.tencent.mm.plugin.finder.cgi.fetcher.a.a(dRp(), str, (kotlin.g.a.b)new c(this, str));
          AppMethodBeat.o(221886);
          return;
          if (as.bvN(str)) {
            paramString = dpi().aAK(str);
          }
          for (;;)
          {
            paramString = (ai)paramString;
            break;
            if (as.bvO(str)) {
              paramString = dpj().aAK(str);
            } else {
              paramString = null;
            }
          }
          label430:
          i = 0;
          break label167;
          label435:
          i = 0;
          break label203;
          label440:
          paramBoolean = false;
          break label230;
          label445:
          localObject = null;
          break label275;
        }
        if (as.bvN(str))
        {
          paramString = ((ab)h.ae(ab.class)).dX(str, 3);
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
            this.AcX.remove(str);
            AppMethodBeat.o(221886);
            return;
          }
          localObject = dRp();
          localarg = new arg();
          localarg.SEn = str;
          localarg.session_id = paramString;
          ((com.tencent.mm.plugin.finder.cgi.fetcher.a)localObject).a(localarg, (kotlin.g.a.b)new d(this, str));
          AppMethodBeat.o(221886);
          return;
        }
        if (as.bvO(str))
        {
          if (p.h(str, com.tencent.mm.model.z.bdi()))
          {
            dRp().E((kotlin.g.a.b)new e(this, str));
            AppMethodBeat.o(221886);
            return;
          }
          paramString = ((ab)h.ae(ab.class)).dX(str, 3);
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
            this.AcX.remove(str);
            AppMethodBeat.o(221886);
            return;
          }
          localObject = dRp();
          localarg = new arg();
          localarg.SEn = str;
          localarg.session_id = paramString;
          ((com.tencent.mm.plugin.finder.cgi.fetcher.a)localObject).a(localarg, (kotlin.g.a.b)new f(this, str));
        }
      }
      AppMethodBeat.o(221886);
      return;
      label745:
      paramBoolean = false;
    }
  }
  
  public final void dRq()
  {
    AppMethodBeat.i(221863);
    Log.i("Finder.ContactService", "[clearFollowStateCache]");
    this.AcV.clear();
    AppMethodBeat.o(221863);
  }
  
  public final void l(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(221858);
    if (paramIOnStorageChange != null)
    {
      ((PluginFinder)h.ag(PluginFinder.class)).getContactStorage().remove(paramIOnStorageChange);
      ((PluginFinder)h.ag(PluginFinder.class)).getMsgStrangerContactStorage().remove(paramIOnStorageChange);
      ((PluginFinder)h.ag(PluginFinder.class)).getMsgAliasContactStorage().remove(paramIOnStorageChange);
      AppMethodBeat.o(221858);
      return;
    }
    AppMethodBeat.o(221858);
  }
  
  public final void m(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(221871);
    if (paramIOnStorageChange != null)
    {
      ((PluginFinder)h.ag(PluginFinder.class)).getContactStorage().add(paramIOnStorageChange);
      ((PluginFinder)h.ag(PluginFinder.class)).getMsgStrangerContactStorage().add(paramIOnStorageChange);
      ((PluginFinder)h.ag(PluginFinder.class)).getMsgAliasContactStorage().add(paramIOnStorageChange);
      AppMethodBeat.o(221871);
      return;
    }
    AppMethodBeat.o(221871);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/service/FinderContactService$Companion;", "", "()V", "FINDER_AD_CONTACT_EXPIRED_TIME", "", "FINDER_CONTACT_EXPIRED_TIME", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderMsgAliasContactStorage;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<y>
  {
    public static final b AcZ;
    
    static
    {
      AppMethodBeat.i(282418);
      AcZ = new b();
      AppMethodBeat.o(282418);
    }
    
    b()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b<ai, x>
  {
    c(a parama, String paramString)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<ai, x>
  {
    d(a parama, String paramString)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.b<ai, x>
  {
    e(a parama, String paramString)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.b<ai, x>
  {
    f(a parama, String paramString)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/service/FinderContactService$contactExtension$1", "Lcom/tencent/mm/storage/IContactStorage$IContactExtension;", "get", "Lcom/tencent/mm/storage/Contact;", "username", "", "onPreInsertContact", "", "stg", "Lcom/tencent/mm/storage/IContactStorage;", "contact", "replace", "", "isUpdate", "", "plugin-finder_release"})
  public static final class g
    implements bv.a
  {
    public final as RG(String paramString)
    {
      AppMethodBeat.i(284925);
      Object localObject1 = (CharSequence)paramString;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(284925);
        return null;
      }
      String str;
      if (as.aEF(paramString))
      {
        str = ((ab)h.ae(ab.class)).aED(paramString);
        if ((!as.bvN(str)) && (!as.bvP(str)) && (!as.bvO(str))) {
          break label107;
        }
      }
      label107:
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label112;
        }
        AppMethodBeat.o(284925);
        return null;
        str = paramString;
        break;
      }
      label112:
      if (as.bvP(str))
      {
        localObject1 = d.wZQ;
        localObject1 = d.a.aAK(str);
        if (localObject1 == null) {
          break label344;
        }
        localObject1 = i.f((i)localObject1);
        if (localObject1 != null)
        {
          localObject2 = (CharSequence)((as)localObject1).getNickname();
          if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
            break label349;
          }
          i = 1;
          if (i == 0) {
            break label359;
          }
        }
        Object localObject2 = new StringBuilder("[get] contact is null or nickname is empty. nickname=");
        if (localObject1 == null) {
          break label354;
        }
        localObject1 = ((as)localObject1).getNickname();
        localObject1 = ((StringBuilder)localObject2).append((String)localObject1).append(" talker=");
        p.j(str, "talker");
        Log.e("Finder.ContactService", a.aEx(str));
        this.Ada.bx(str, false);
        localObject1 = new as(paramString);
      }
      label169:
      label193:
      label344:
      label349:
      label354:
      label359:
      for (;;)
      {
        ((as)localObject1).setUsername(paramString);
        AppMethodBeat.o(284925);
        return localObject1;
        if (as.bvN(str))
        {
          localObject1 = a.c(this.Ada);
          p.j(str, "talker");
          localObject1 = ((com.tencent.mm.plugin.finder.storage.z)localObject1).aAK(str);
          if (localObject1 == null) {
            break label344;
          }
          localObject1 = i.f((i)localObject1);
          break;
        }
        if (as.bvO(str))
        {
          localObject1 = a.d(this.Ada);
          p.j(str, "talker");
          localObject1 = ((y)localObject1).aAK(str);
          if (localObject1 != null)
          {
            localObject1 = i.f((i)localObject1);
            break;
          }
        }
        localObject1 = null;
        break;
        i = 0;
        break label169;
        localObject1 = null;
        break label193;
      }
    }
    
    public final void a(bv parambv, as paramas) {}
    
    public final int b(as paramas, boolean paramBoolean)
    {
      AppMethodBeat.i(284924);
      if (paramas == null)
      {
        AppMethodBeat.o(284924);
        return -1;
      }
      String str = paramas.getUsername();
      Object localObject = (CharSequence)str;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(284924);
        return -1;
      }
      localObject = str;
      if (as.aEF(str)) {
        localObject = ((ab)h.ae(ab.class)).aED(str);
      }
      if ((paramas.getFromType() == 2) || (as.bvN((String)localObject)) || (as.bvP((String)localObject))) {}
      for (i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(284924);
        return -1;
      }
      AppMethodBeat.o(284924);
      return 1;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderContactFetcher;", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.cgi.fetcher.a>
  {
    public static final h Adb;
    
    static
    {
      AppMethodBeat.i(292072);
      Adb = new h();
      AppMethodBeat.o(292072);
    }
    
    h()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "contact", "", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "kotlin.jvm.PlatformType", "", "onDone", "com/tencent/mm/plugin/finder/service/FinderContactService$getFinderContact$5$1"})
  static final class i
    implements m.b
  {
    i(a parama, m.a parama1) {}
    
    public final void eK(List<ai> paramList)
    {
      AppMethodBeat.i(277400);
      m.a locala = parama;
      p.j(paramList, "contact");
      locala.d((ai)j.lp(paramList));
      AppMethodBeat.o(277400);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.b<List<? extends ai>, x>
  {
    j(m.b paramb)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.b<ai, x>
  {
    k(m.b paramb)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "contact", "", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "kotlin.jvm.PlatformType", "", "onDone"})
  static final class l
    implements m.b
  {
    l(m.a parama) {}
    
    public final void eK(List<ai> paramList)
    {
      AppMethodBeat.i(278928);
      m.a locala = this.Adf;
      p.j(paramList, "contact");
      locala.d((ai)j.lp(paramList));
      AppMethodBeat.o(278928);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "kotlin.jvm.PlatformType", "", "onDone"})
  static final class m
    implements m.b
  {
    m(List paramList, m.b paramb) {}
    
    public final void eK(List<ai> paramList)
    {
      AppMethodBeat.i(274904);
      StringBuilder localStringBuilder1 = new StringBuilder("[getContact] completed! usernameList=").append(this.nJx).append(" result=");
      p.j(paramList, "result");
      Object localObject = (Iterable)paramList;
      Collection localCollection = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ai localai = (ai)((Iterator)localObject).next();
        StringBuilder localStringBuilder2 = new StringBuilder();
        p.j(localai, "it");
        localCollection.add(localai.getUsername() + '=' + localai.getNickname());
      }
      Log.i("Finder.ContactService", (List)localCollection);
      paramb.eK(paramList);
      AppMethodBeat.o(274904);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
  static final class n
    extends q
    implements kotlin.g.a.b<ai, x>
  {
    n(m.a parama)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
  static final class o
    extends q
    implements kotlin.g.a.b<ai, x>
  {
    o(m.a parama)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
  static final class p
    extends q
    implements kotlin.g.a.b<ai, x>
  {
    p(m.a parama)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
  static final class q
    extends q
    implements kotlin.g.a.b<ai, x>
  {
    q(a parama, aa.d paramd, String paramString, m.c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "invoke"})
  static final class r
    extends q
    implements kotlin.g.a.a<af>
  {
    public static final r Adj;
    
    static
    {
      AppMethodBeat.i(290019);
      Adj = new r();
      AppMethodBeat.o(290019);
    }
    
    r()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;", "invoke"})
  static final class s
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.storage.z>
  {
    public static final s Adk;
    
    static
    {
      AppMethodBeat.i(283450);
      Adk = new s();
      AppMethodBeat.o(283450);
    }
    
    s()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.service.a
 * JD-Core Version:    0.7.0.1
 */