package com.tencent.mm.plugin.finder.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.conv.k;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.plugin.finder.storage.ag;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.i.a.aa;
import com.tencent.mm.plugin.i.a.ah;
import com.tencent.mm.plugin.i.a.m;
import com.tencent.mm.plugin.i.a.m.a;
import com.tencent.mm.plugin.i.a.m.b;
import com.tencent.mm.plugin.i.a.m.c;
import com.tencent.mm.protocal.protobuf.aps;
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
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.d;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/service/FinderContactService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderContactService;", "()V", "cacheContactItems", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "", "contactExtension", "Lcom/tencent/mm/storage/IContactStorage$IContactExtension;", "getContactExtension", "()Lcom/tencent/mm/storage/IContactStorage$IContactExtension;", "finderContactFetcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderContactFetcher;", "getFinderContactFetcher", "()Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderContactFetcher;", "finderContactFetcher$delegate", "Lkotlin/Lazy;", "gettingContactSet", "Ljava/util/concurrent/ConcurrentHashMap;", "", "sessionInfoStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "getSessionInfoStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "sessionInfoStorage$delegate", "strangerContactStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;", "getStrangerContactStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;", "strangerContactStorage$delegate", "addOnStorageChange", "", "storageChange", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "checkContactExpired", "username", "isCheckAvatar", "", "clearFollowStateCache", "getFinderContact", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderContactService$GetContactCallback;", "usernameList", "", "Lcom/tencent/mm/plugin/findersdk/api/IFinderContactService$GetContactListCallback;", "getFinderMsgStrangerContact", "commentId", "", "objectId", "sessionId", "getFollowState", "", "Lcom/tencent/mm/plugin/findersdk/api/IFinderContactService$GetFollowStateCallback;", "getLocalFinderContact", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "getLocalFinderMsgStrangerContact", "isContactExpired", "contact", "isContactRetryLimited", "isSessionMute", "talker", "removeOnStorageChange", "simpleTalker", "Companion", "plugin-finder_release"})
public final class a
  implements m
{
  public static final a vvD;
  private final f twR;
  private final f tyR;
  private final Map<String, com.tencent.mm.plugin.finder.api.g> vvA;
  public final bv.a vvB;
  private final ConcurrentHashMap<String, Object> vvC;
  private final f vvz;
  
  static
  {
    AppMethodBeat.i(251439);
    vvD = new a((byte)0);
    AppMethodBeat.o(251439);
  }
  
  public a()
  {
    AppMethodBeat.i(251438);
    this.tyR = kotlin.g.ah((kotlin.g.a.a)m.vvL);
    this.twR = kotlin.g.ah((kotlin.g.a.a)n.vvM);
    this.vvz = kotlin.g.ah((kotlin.g.a.a)e.vvF);
    this.vvA = Collections.synchronizedMap((Map)new HashMap());
    this.vvB = ((bv.a)new d(this));
    this.vvC = new ConcurrentHashMap();
    AppMethodBeat.o(251438);
  }
  
  private static boolean a(ah paramah)
  {
    AppMethodBeat.i(251436);
    long l;
    if (paramah != null)
    {
      l = paramah.cXI();
      if (System.currentTimeMillis() - l < 86400000L) {
        break label92;
      }
    }
    label92:
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        Log.i("Finder.ContactService", "[isContactExpired] current=" + Util.formatUnixTime(System.currentTimeMillis() / 1000L) + " time=" + Util.formatUnixTime(l / 1000L));
      }
      AppMethodBeat.o(251436);
      return bool;
      l = 0L;
      break;
    }
  }
  
  private static boolean b(ah paramah)
  {
    AppMethodBeat.i(251437);
    if (paramah != null) {}
    for (int i = paramah.getRetryCount(); i >= 3; i = 0)
    {
      AppMethodBeat.o(251437);
      return true;
    }
    AppMethodBeat.o(251437);
    return false;
  }
  
  private final ab dqd()
  {
    AppMethodBeat.i(251422);
    ab localab = (ab)this.twR.getValue();
    AppMethodBeat.o(251422);
    return localab;
  }
  
  private final com.tencent.mm.plugin.finder.cgi.fetcher.a dqe()
  {
    AppMethodBeat.i(251423);
    com.tencent.mm.plugin.finder.cgi.fetcher.a locala = (com.tencent.mm.plugin.finder.cgi.fetcher.a)this.vvz.getValue();
    AppMethodBeat.o(251423);
    return locala;
  }
  
  public final int a(final String paramString, final m.c paramc)
  {
    AppMethodBeat.i(251432);
    Log.i("Finder.ContactService", "[getFollowState] username:".concat(String.valueOf(paramString)));
    if (paramString == null)
    {
      AppMethodBeat.o(251432);
      return 3;
    }
    final z.d locald = new z.d();
    locald.SYE = 1;
    com.tencent.mm.plugin.finder.api.g localg = (com.tencent.mm.plugin.finder.api.g)this.vvA.get(paramString);
    if (localg != null)
    {
      Log.i("Finder.ContactService", "[getFollowState] cache user:".concat(String.valueOf(localg)));
      i = localg.field_follow_Flag;
      paramString = com.tencent.mm.plugin.finder.api.g.tsD;
      if (i == com.tencent.mm.plugin.finder.api.g.cXO()) {}
      for (i = 2;; i = 3)
      {
        locald.SYE = i;
        i = locald.SYE;
        AppMethodBeat.o(251432);
        return i;
      }
    }
    dqe().h(paramString, (b)new l(this, locald, paramString, paramc));
    int i = locald.SYE;
    AppMethodBeat.o(251432);
    return i;
  }
  
  public final void a(final String paramString, m.a parama)
  {
    int j = 0;
    AppMethodBeat.i(251424);
    p.h(paramString, "username");
    p.h(parama, "callback");
    Object localObject = j.v((Collection)j.listOf(paramString));
    paramString = (m.b)new h(parama);
    p.h(localObject, "usernameList");
    p.h(paramString, "callback");
    Log.i("Finder.ContactService", "[getContact] begin... usernameList=".concat(String.valueOf(localObject)));
    parama = (m.b)new i((List)localObject, paramString);
    LinkedList localLinkedList2 = new LinkedList();
    LinkedList localLinkedList1 = new LinkedList();
    Iterator localIterator = ((Iterable)localObject).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (((CharSequence)str).length() == 0) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label192;
        }
        Log.e("Finder.ContactService", "username is null.");
        localLinkedList2.add(new com.tencent.mm.plugin.finder.api.g());
        break;
      }
      label192:
      paramString = c.tsp;
      paramString = c.a.asG(str);
      if (paramString != null)
      {
        if (((CharSequence)paramString.getNickname()).length() == 0)
        {
          i = 1;
          label223:
          if ((i == 0) && (!a((ah)paramString))) {
            break label382;
          }
        }
      }
      else
      {
        if ((!b((ah)paramString)) || (a((ah)paramString))) {
          break label320;
        }
        localStringBuilder = new StringBuilder("[getFinderContact] isContactRetryLimited contact=");
        if (paramString == null) {
          break label315;
        }
      }
      label315:
      for (paramString = paramString.getUsername();; paramString = null)
      {
        Log.e("Finder.ContactService", paramString);
        localLinkedList2.add(new com.tencent.mm.plugin.finder.api.g(str));
        break;
        i = 0;
        break label223;
      }
      label320:
      StringBuilder localStringBuilder = new StringBuilder("contact is null[");
      if (paramString == null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("Finder.ContactService", bool + "]. username=" + str);
        localLinkedList1.add(str);
        break;
      }
      label382:
      localLinkedList2.add(paramString);
    }
    int i = j;
    if (!((Collection)localLinkedList1).isEmpty()) {
      i = 1;
    }
    if (i != 0)
    {
      if (localLinkedList1.size() > 1)
      {
        dqe().b((List)localObject, (b)new f(parama));
        AppMethodBeat.o(251424);
        return;
      }
      paramString = dqe();
      localObject = localLinkedList1.getFirst();
      p.g(localObject, "reqList.first");
      paramString.h((String)localObject, (b)new g(parama));
      AppMethodBeat.o(251424);
      return;
    }
    parama.er((List)localLinkedList2);
    AppMethodBeat.o(251424);
  }
  
  public final void a(String paramString1, String paramString2, m.a parama)
  {
    AppMethodBeat.i(251425);
    Object localObject1 = (CharSequence)paramString1;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("Finder.ContactService", "username is null.");
      parama.c((ah)new com.tencent.mm.plugin.finder.api.g());
      AppMethodBeat.o(251425);
      return;
    }
    localObject1 = (CharSequence)paramString2;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (i = 1; i != 0; i = 0)
    {
      Log.e("Finder.ContactService", "sessionId is null.");
      parama.c((ah)new com.tencent.mm.plugin.finder.api.g());
      AppMethodBeat.o(251425);
      return;
    }
    localObject1 = dqd().asG(paramString1);
    if (localObject1 != null)
    {
      if (((CharSequence)((com.tencent.mm.plugin.finder.api.g)localObject1).getNickname()).length() == 0)
      {
        i = 1;
        if ((i == 0) && (!a((ah)localObject1))) {
          break label350;
        }
      }
    }
    else
    {
      if ((!b((ah)localObject1)) || (a((ah)localObject1))) {
        break label298;
      }
      localObject2 = new StringBuilder("[getFinderContact] isContactRetryLimited contact=");
      if (localObject1 == null) {
        break label278;
      }
      paramString2 = ((com.tencent.mm.plugin.finder.api.g)localObject1).getUsername();
      label233:
      Log.e("Finder.ContactService", paramString2);
      if (localObject1 == null) {
        break label283;
      }
    }
    label278:
    label283:
    for (paramString1 = (ah)localObject1;; paramString1 = (ah)new com.tencent.mm.plugin.finder.api.g(paramString1))
    {
      parama.c(paramString1);
      AppMethodBeat.o(251425);
      return;
      i = 0;
      break;
      paramString2 = null;
      break label233;
    }
    label298:
    localObject1 = dqe();
    Object localObject2 = new aps();
    ((aps)localObject2).LBC = paramString1;
    ((aps)localObject2).session_id = paramString2;
    ((com.tencent.mm.plugin.finder.cgi.fetcher.a)localObject1).a((aps)localObject2, (b)new j(parama));
    AppMethodBeat.o(251425);
    return;
    label350:
    Log.i("Finder.ContactService", "[getFinderMsgStrangerContact] local completed! result=" + ((com.tencent.mm.plugin.finder.api.g)localObject1).getUsername() + '=' + ((com.tencent.mm.plugin.finder.api.g)localObject1).getNickname());
    parama.c((ah)localObject1);
    AppMethodBeat.o(251425);
  }
  
  public final ah ava(String paramString)
  {
    AppMethodBeat.i(251427);
    if (paramString != null)
    {
      c.a locala = c.tsp;
      paramString = (ah)c.a.asG(paramString);
      AppMethodBeat.o(251427);
      return paramString;
    }
    AppMethodBeat.o(251427);
    return null;
  }
  
  public final ah avb(String paramString)
  {
    AppMethodBeat.i(251428);
    if (paramString != null)
    {
      com.tencent.mm.plugin.finder.api.g localg = dqd().asG(paramString);
      if (localg != null) {
        Log.i("Finder.ContactService", "[getLocalFinderStrangerContact] " + localg.getUsername() + '=' + localg.getNickname());
      }
      for (;;)
      {
        paramString = (ah)localg;
        AppMethodBeat.o(251428);
        return paramString;
        Log.i("Finder.ContactService", "[getLocalFinderStrangerContact] get contact return null. ".concat(String.valueOf(paramString)));
      }
    }
    AppMethodBeat.o(251428);
    return null;
  }
  
  public final boolean avc(String paramString)
  {
    AppMethodBeat.i(251430);
    if (((ag)this.tyR.getValue()).avz(paramString).field_rejectMsg == 1)
    {
      AppMethodBeat.o(251430);
      return true;
    }
    AppMethodBeat.o(251430);
    return false;
  }
  
  public final void bs(final String paramString, boolean paramBoolean)
  {
    Object localObject3 = null;
    boolean bool = false;
    AppMethodBeat.i(251434);
    String str;
    if (as.avl(paramString))
    {
      paramString = ((aa)com.tencent.mm.kernel.g.af(aa.class)).avi(paramString);
      str = ((aa)com.tencent.mm.kernel.g.af(aa.class)).avj(paramString);
      localObject1 = (CharSequence)paramString;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label89;
      }
    }
    label89:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label94;
      }
      AppMethodBeat.o(251434);
      return;
      break;
    }
    label94:
    Object localObject1 = (CharSequence)str;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(251434);
      return;
    }
    if (this.vvC.containsKey(paramString))
    {
      AppMethodBeat.o(251434);
      return;
    }
    label200:
    label237:
    StringBuilder localStringBuilder;
    if (as.bjt(paramString))
    {
      localObject1 = ava(paramString);
      if (localObject1 != null)
      {
        localObject2 = (CharSequence)((ah)localObject1).getNickname();
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          break label450;
        }
        i = 1;
        if (i == 0) {
          if (paramBoolean)
          {
            localObject2 = (CharSequence)((ah)localObject1).cXH();
            if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
              break label455;
            }
            i = 1;
            if (i != 0) {}
          }
          else
          {
            paramBoolean = bool;
            if (!a((ah)localObject1)) {
              break label364;
            }
          }
        }
      }
      if ((b((ah)localObject1)) && (!a((ah)localObject1))) {
        break label460;
      }
      paramBoolean = true;
      label270:
      localStringBuilder = new StringBuilder("[checkContactExpired] isNeedGetContact=").append(paramBoolean).append(" talker=").append(paramString).append(" nickname=");
      if (localObject1 == null) {
        break label465;
      }
    }
    label450:
    label455:
    label460:
    label465:
    for (Object localObject2 = ((ah)localObject1).getNickname();; localObject2 = null)
    {
      localStringBuilder = localStringBuilder.append((String)localObject2).append(" avatar=");
      localObject2 = localObject3;
      if (localObject1 != null) {
        localObject2 = ((ah)localObject1).cXH();
      }
      Log.i("Finder.ContactService", (String)localObject2);
      label364:
      if (!paramBoolean) {
        break label518;
      }
      ((Map)this.vvC).put(paramString, this);
      if (!as.bjt(paramString)) {
        break label471;
      }
      dqe().h(paramString, (b)new b(this, paramString));
      AppMethodBeat.o(251434);
      return;
      if (as.bjs(paramString)) {}
      for (localObject1 = dqd().asG(paramString);; localObject1 = null)
      {
        localObject1 = (ah)localObject1;
        break;
      }
      i = 0;
      break label200;
      i = 0;
      break label237;
      paramBoolean = false;
      break label270;
    }
    label471:
    localObject1 = dqe();
    localObject2 = new aps();
    ((aps)localObject2).LBC = paramString;
    ((aps)localObject2).session_id = str;
    ((com.tencent.mm.plugin.finder.cgi.fetcher.a)localObject1).a((aps)localObject2, (b)new c(this, paramString));
    label518:
    AppMethodBeat.o(251434);
  }
  
  public final void dqf()
  {
    AppMethodBeat.i(251431);
    Log.i("Finder.ContactService", "[clearFollowStateCache]");
    this.vvA.clear();
    AppMethodBeat.o(251431);
  }
  
  public final void l(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(251429);
    if (paramIOnStorageChange != null)
    {
      ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getContactStorage().remove(paramIOnStorageChange);
      ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getMsgStrangerContactStorage().remove(paramIOnStorageChange);
      AppMethodBeat.o(251429);
      return;
    }
    AppMethodBeat.o(251429);
  }
  
  public final void m(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(251433);
    if (paramIOnStorageChange != null)
    {
      ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getContactStorage().add(paramIOnStorageChange);
      ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getMsgStrangerContactStorage().add(paramIOnStorageChange);
      AppMethodBeat.o(251433);
      return;
    }
    AppMethodBeat.o(251433);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/service/FinderContactService$Companion;", "", "()V", "FINDER_CONTACT_EXPIRED_TIME", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
  static final class b
    extends q
    implements b<ah, x>
  {
    b(a parama, String paramString)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
  static final class c
    extends q
    implements b<ah, x>
  {
    c(a parama, String paramString)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/service/FinderContactService$contactExtension$1", "Lcom/tencent/mm/storage/IContactStorage$IContactExtension;", "get", "Lcom/tencent/mm/storage/Contact;", "username", "", "onPreInsertContact", "", "stg", "Lcom/tencent/mm/storage/IContactStorage;", "contact", "replace", "", "isUpdate", "", "plugin-finder_release"})
  public static final class d
    implements bv.a
  {
    public final as Kn(String paramString)
    {
      AppMethodBeat.i(251408);
      Object localObject1 = (CharSequence)paramString;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(251408);
        return null;
      }
      String str;
      if (as.avl(paramString))
      {
        str = ((aa)com.tencent.mm.kernel.g.af(aa.class)).avi(paramString);
        if ((!as.bjs(str)) && (!as.bjt(str))) {
          break label99;
        }
      }
      label99:
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label104;
        }
        AppMethodBeat.o(251408);
        return null;
        str = paramString;
        break;
      }
      label104:
      if (as.bjt(str))
      {
        localObject1 = c.tsp;
        localObject1 = c.a.asG(str);
        if (localObject1 != null)
        {
          localObject1 = com.tencent.mm.plugin.finder.api.g.f((com.tencent.mm.plugin.finder.api.g)localObject1);
          if (localObject1 != null)
          {
            localObject2 = (CharSequence)((as)localObject1).getNickname();
            if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
              break label296;
            }
            i = 1;
            if (i == 0) {
              break label306;
            }
          }
          Object localObject2 = new StringBuilder("[get] contact is null or nickname is empty. nickname=");
          if (localObject1 == null) {
            break label301;
          }
          localObject1 = ((as)localObject1).getNickname();
          localObject1 = ((StringBuilder)localObject2).append((String)localObject1).append(" talker=");
          p.g(str, "talker");
          Log.e("Finder.ContactService", a.avd(str));
          this.vvE.bs(str, false);
          localObject1 = new as(paramString);
        }
      }
      label161:
      label296:
      label301:
      label306:
      for (;;)
      {
        label185:
        ((as)localObject1).setUsername(paramString);
        AppMethodBeat.o(251408);
        return localObject1;
        localObject1 = null;
        break;
        localObject1 = a.c(this.vvE);
        p.g(str, "talker");
        localObject1 = ((ab)localObject1).asG(str);
        if (localObject1 != null)
        {
          localObject1 = com.tencent.mm.plugin.finder.api.g.f((com.tencent.mm.plugin.finder.api.g)localObject1);
          break;
        }
        localObject1 = null;
        break;
        i = 0;
        break label161;
        localObject1 = null;
        break label185;
      }
    }
    
    public final void a(bv parambv, as paramas) {}
    
    public final int b(as paramas, boolean paramBoolean)
    {
      AppMethodBeat.i(251407);
      if (paramas == null)
      {
        AppMethodBeat.o(251407);
        return -1;
      }
      String str = paramas.getUsername();
      Object localObject = (CharSequence)str;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(251407);
        return -1;
      }
      localObject = str;
      if (as.avl(str)) {
        localObject = ((aa)com.tencent.mm.kernel.g.af(aa.class)).avi(str);
      }
      if ((paramas.getFromType() == 2) || (as.bjs((String)localObject)) || (as.bjt((String)localObject))) {}
      for (i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(251407);
        return -1;
      }
      AppMethodBeat.o(251407);
      return 1;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderContactFetcher;", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.cgi.fetcher.a>
  {
    public static final e vvF;
    
    static
    {
      AppMethodBeat.i(251410);
      vvF = new e();
      AppMethodBeat.o(251410);
    }
    
    e()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
  static final class f
    extends q
    implements b<List<? extends ah>, x>
  {
    f(m.b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
  static final class g
    extends q
    implements b<ah, x>
  {
    g(m.b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "contact", "", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "kotlin.jvm.PlatformType", "", "onDone"})
  static final class h
    implements m.b
  {
    h(m.a parama) {}
    
    public final void er(List<ah> paramList)
    {
      AppMethodBeat.i(251413);
      m.a locala = this.vvH;
      p.g(paramList, "contact");
      locala.c((ah)j.kt(paramList));
      AppMethodBeat.o(251413);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "kotlin.jvm.PlatformType", "", "onDone"})
  static final class i
    implements m.b
  {
    i(List paramList, m.b paramb) {}
    
    public final void er(List<ah> paramList)
    {
      AppMethodBeat.i(251414);
      StringBuilder localStringBuilder1 = new StringBuilder("[getContact] completed! usernameList=").append(this.kPr).append(" result=");
      p.g(paramList, "result");
      Object localObject = (Iterable)paramList;
      Collection localCollection = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ah localah = (ah)((Iterator)localObject).next();
        StringBuilder localStringBuilder2 = new StringBuilder();
        p.g(localah, "it");
        localCollection.add(localah.getUsername() + '=' + localah.getNickname());
      }
      Log.i("Finder.ContactService", (List)localCollection);
      paramString.er(paramList);
      AppMethodBeat.o(251414);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
  static final class j
    extends q
    implements b<ah, x>
  {
    j(m.a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
  static final class k
    extends q
    implements b<ah, x>
  {
    k(m.a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
  static final class l
    extends q
    implements b<ah, x>
  {
    l(a parama, z.d paramd, String paramString, m.c paramc)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.a<ag>
  {
    public static final m vvL;
    
    static
    {
      AppMethodBeat.i(251419);
      vvL = new m();
      AppMethodBeat.o(251419);
    }
    
    m()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;", "invoke"})
  static final class n
    extends q
    implements kotlin.g.a.a<ab>
  {
    public static final n vvM;
    
    static
    {
      AppMethodBeat.i(251421);
      vvM = new n();
      AppMethodBeat.o(251421);
    }
    
    n()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.service.a
 * JD-Core Version:    0.7.0.1
 */