package com.tencent.mm.plugin.finder.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.storage.w;
import com.tencent.mm.plugin.i.a.f.a;
import com.tencent.mm.plugin.i.a.f.b;
import com.tencent.mm.plugin.i.a.r;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bq.a;
import d.g.a.b;
import d.g.b.q;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/service/FinderContactService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderContactService;", "()V", "contactExtension", "Lcom/tencent/mm/storage/IContactStorage$IContactExtension;", "getContactExtension", "()Lcom/tencent/mm/storage/IContactStorage$IContactExtension;", "finderContactFetcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderContactFetcher;", "getFinderContactFetcher", "()Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderContactFetcher;", "finderContactFetcher$delegate", "Lkotlin/Lazy;", "gettingContactSet", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "sessionInfoStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "getSessionInfoStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "sessionInfoStorage$delegate", "strangerContactStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;", "getStrangerContactStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;", "strangerContactStorage$delegate", "addOnStorageChange", "", "storageChange", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "checkContactExpired", "username", "isCheckAvatar", "", "getFinderContact", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderContactService$GetContactCallback;", "usernameList", "", "Lcom/tencent/mm/plugin/findersdk/api/IFinderContactService$GetContactListCallback;", "getFinderMsgStrangerContact", "commentId", "", "objectId", "sessionId", "getLocalFinderContact", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "getLocalFinderMsgStrangerContact", "isContactExpired", "contact", "isContactRetryLimited", "isSessionMute", "talker", "removeOnStorageChange", "simpleTalker", "Companion", "plugin-finder_release"})
public final class a
  implements com.tencent.mm.plugin.i.a.f
{
  public static final a sEi;
  private final d.f rSB;
  private final d.f rTW;
  private final d.f sEf;
  public final bq.a sEg;
  private final ConcurrentHashMap<String, Object> sEh;
  
  static
  {
    AppMethodBeat.i(204060);
    sEi = new a((byte)0);
    AppMethodBeat.o(204060);
  }
  
  public a()
  {
    AppMethodBeat.i(204059);
    this.rTW = d.g.O((d.g.a.a)l.sEo);
    this.rSB = d.g.O((d.g.a.a)m.sEp);
    this.sEf = d.g.O((d.g.a.a)e.sEk);
    this.sEg = ((bq.a)new d(this));
    this.sEh = new ConcurrentHashMap();
    AppMethodBeat.o(204059);
  }
  
  private static boolean a(r paramr)
  {
    AppMethodBeat.i(204057);
    long l;
    if (paramr != null)
    {
      l = paramr.czn();
      if (System.currentTimeMillis() - l < 86400000L) {
        break label92;
      }
    }
    label92:
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        ae.i("Finder.ContactService", "[isContactExpired] current=" + bu.DA(System.currentTimeMillis() / 1000L) + " time=" + bu.DA(l / 1000L));
      }
      AppMethodBeat.o(204057);
      return bool;
      l = 0L;
      break;
    }
  }
  
  private static boolean b(r paramr)
  {
    AppMethodBeat.i(204058);
    if (paramr != null) {}
    for (int i = paramr.getRetryCount(); i >= 3; i = 0)
    {
      AppMethodBeat.o(204058);
      return true;
    }
    AppMethodBeat.o(204058);
    return false;
  }
  
  private final v cGN()
  {
    AppMethodBeat.i(204045);
    v localv = (v)this.rSB.getValue();
    AppMethodBeat.o(204045);
    return localv;
  }
  
  private final com.tencent.mm.plugin.finder.cgi.fetcher.a cGO()
  {
    AppMethodBeat.i(204046);
    com.tencent.mm.plugin.finder.cgi.fetcher.a locala = (com.tencent.mm.plugin.finder.cgi.fetcher.a)this.sEf.getValue();
    AppMethodBeat.o(204046);
    return locala;
  }
  
  public final void a(final String paramString, f.a parama)
  {
    int j = 0;
    AppMethodBeat.i(204047);
    d.g.b.p.h(paramString, "username");
    d.g.b.p.h(parama, "callback");
    Object localObject = d.a.j.s((Collection)d.a.j.listOf(paramString));
    paramString = (f.b)new h(parama);
    d.g.b.p.h(localObject, "usernameList");
    d.g.b.p.h(paramString, "callback");
    ae.i("Finder.ContactService", "[getContact] begin... usernameList=".concat(String.valueOf(localObject)));
    parama = (f.b)new i((List)localObject, paramString);
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
        ae.e("Finder.ContactService", "username is null.");
        localLinkedList2.add(new com.tencent.mm.plugin.finder.api.g());
        break;
      }
      label192:
      paramString = com.tencent.mm.plugin.finder.api.c.rPy;
      paramString = c.a.ahT(str);
      if (paramString != null)
      {
        if (((CharSequence)paramString.VK()).length() == 0)
        {
          i = 1;
          label223:
          if ((i == 0) && (!a((r)paramString))) {
            break label382;
          }
        }
      }
      else
      {
        if ((!b((r)paramString)) || (a((r)paramString))) {
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
        ae.e("Finder.ContactService", paramString);
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
        ae.i("Finder.ContactService", bool + "]. username=" + str);
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
        cGO().b((List)localObject, (b)new f(parama));
        AppMethodBeat.o(204047);
        return;
      }
      paramString = cGO();
      localObject = localLinkedList1.getFirst();
      d.g.b.p.g(localObject, "reqList.first");
      paramString.g((String)localObject, (b)new g(parama));
      AppMethodBeat.o(204047);
      return;
    }
    parama.dK((List)localLinkedList2);
    AppMethodBeat.o(204047);
  }
  
  public final void a(String paramString1, String paramString2, f.a parama)
  {
    AppMethodBeat.i(204048);
    Object localObject1 = (CharSequence)paramString1;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      ae.e("Finder.ContactService", "username is null.");
      parama.c((r)new com.tencent.mm.plugin.finder.api.g());
      AppMethodBeat.o(204048);
      return;
    }
    localObject1 = (CharSequence)paramString2;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (i = 1; i != 0; i = 0)
    {
      ae.e("Finder.ContactService", "sessionId is null.");
      parama.c((r)new com.tencent.mm.plugin.finder.api.g());
      AppMethodBeat.o(204048);
      return;
    }
    localObject1 = cGN().ahT(paramString1);
    if (localObject1 != null)
    {
      if (((CharSequence)((com.tencent.mm.plugin.finder.api.g)localObject1).VK()).length() == 0)
      {
        i = 1;
        if ((i == 0) && (!a((r)localObject1))) {
          break label350;
        }
      }
    }
    else
    {
      if ((!b((r)localObject1)) || (a((r)localObject1))) {
        break label298;
      }
      localObject2 = new StringBuilder("[getFinderContact] isContactRetryLimited contact=");
      if (localObject1 == null) {
        break label278;
      }
      paramString2 = ((com.tencent.mm.plugin.finder.api.g)localObject1).getUsername();
      label233:
      ae.e("Finder.ContactService", paramString2);
      if (localObject1 == null) {
        break label283;
      }
    }
    label278:
    label283:
    for (paramString1 = (r)localObject1;; paramString1 = (r)new com.tencent.mm.plugin.finder.api.g(paramString1))
    {
      parama.c(paramString1);
      AppMethodBeat.o(204048);
      return;
      i = 0;
      break;
      paramString2 = null;
      break label233;
    }
    label298:
    localObject1 = cGO();
    Object localObject2 = new aml();
    ((aml)localObject2).GEI = paramString1;
    ((aml)localObject2).session_id = paramString2;
    ((com.tencent.mm.plugin.finder.cgi.fetcher.a)localObject1).a((aml)localObject2, (b)new j(parama));
    AppMethodBeat.o(204048);
    return;
    label350:
    ae.i("Finder.ContactService", "[getFinderMsgStrangerContact] local completed! result=" + ((com.tencent.mm.plugin.finder.api.g)localObject1).getUsername() + '=' + ((com.tencent.mm.plugin.finder.api.g)localObject1).VK());
    parama.c((r)localObject1);
    AppMethodBeat.o(204048);
  }
  
  public final r aiX(String paramString)
  {
    AppMethodBeat.i(204050);
    if (paramString != null)
    {
      c.a locala = com.tencent.mm.plugin.finder.api.c.rPy;
      paramString = (r)c.a.ahT(paramString);
      AppMethodBeat.o(204050);
      return paramString;
    }
    AppMethodBeat.o(204050);
    return null;
  }
  
  public final r aiY(String paramString)
  {
    AppMethodBeat.i(204051);
    if (paramString != null)
    {
      com.tencent.mm.plugin.finder.api.g localg = cGN().ahT(paramString);
      if (localg != null) {
        ae.i("Finder.ContactService", "[getLocalFinderStrangerContact] " + localg.getUsername() + '=' + localg.VK());
      }
      for (;;)
      {
        paramString = (r)localg;
        AppMethodBeat.o(204051);
        return paramString;
        ae.i("Finder.ContactService", "[getLocalFinderStrangerContact] get contact return null. ".concat(String.valueOf(paramString)));
      }
    }
    AppMethodBeat.o(204051);
    return null;
  }
  
  public final boolean aiZ(String paramString)
  {
    AppMethodBeat.i(204053);
    if (((w)this.rTW.getValue()).ajt(paramString).field_rejectMsg == 1)
    {
      AppMethodBeat.o(204053);
      return true;
    }
    AppMethodBeat.o(204053);
    return false;
  }
  
  public final void bg(final String paramString, boolean paramBoolean)
  {
    Object localObject3 = null;
    boolean bool = false;
    AppMethodBeat.i(204055);
    String str;
    if (an.aji(paramString))
    {
      paramString = ((com.tencent.mm.plugin.i.a.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.p.class)).ajf(paramString);
      str = ((com.tencent.mm.plugin.i.a.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.p.class)).ajg(paramString);
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
      AppMethodBeat.o(204055);
      return;
      break;
    }
    label94:
    Object localObject1 = (CharSequence)str;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(204055);
      return;
    }
    if (this.sEh.containsKey(paramString))
    {
      AppMethodBeat.o(204055);
      return;
    }
    label200:
    label237:
    StringBuilder localStringBuilder;
    if (an.aUu(paramString))
    {
      localObject1 = aiX(paramString);
      if (localObject1 != null)
      {
        localObject2 = (CharSequence)((r)localObject1).VK();
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          break label450;
        }
        i = 1;
        if (i == 0) {
          if (paramBoolean)
          {
            localObject2 = (CharSequence)((r)localObject1).czm();
            if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
              break label455;
            }
            i = 1;
            if (i != 0) {}
          }
          else
          {
            paramBoolean = bool;
            if (!a((r)localObject1)) {
              break label364;
            }
          }
        }
      }
      if ((b((r)localObject1)) && (!a((r)localObject1))) {
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
    for (Object localObject2 = ((r)localObject1).VK();; localObject2 = null)
    {
      localStringBuilder = localStringBuilder.append((String)localObject2).append(" avatar=");
      localObject2 = localObject3;
      if (localObject1 != null) {
        localObject2 = ((r)localObject1).czm();
      }
      ae.i("Finder.ContactService", (String)localObject2);
      label364:
      if (!paramBoolean) {
        break label518;
      }
      ((Map)this.sEh).put(paramString, this);
      if (!an.aUu(paramString)) {
        break label471;
      }
      cGO().g(paramString, (b)new b(this, paramString));
      AppMethodBeat.o(204055);
      return;
      if (an.aUt(paramString)) {}
      for (localObject1 = cGN().ahT(paramString);; localObject1 = null)
      {
        localObject1 = (r)localObject1;
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
    localObject1 = cGO();
    localObject2 = new aml();
    ((aml)localObject2).GEI = paramString;
    ((aml)localObject2).session_id = str;
    ((com.tencent.mm.plugin.finder.cgi.fetcher.a)localObject1).a((aml)localObject2, (b)new c(this, paramString));
    label518:
    AppMethodBeat.o(204055);
  }
  
  public final void l(k.a parama)
  {
    AppMethodBeat.i(204052);
    if (parama != null)
    {
      ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getContactStorage().remove(parama);
      ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getMsgStrangerContactStorage().remove(parama);
      AppMethodBeat.o(204052);
      return;
    }
    AppMethodBeat.o(204052);
  }
  
  public final void m(k.a parama)
  {
    AppMethodBeat.i(204054);
    if (parama != null)
    {
      ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getContactStorage().add(parama);
      ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getMsgStrangerContactStorage().add(parama);
      AppMethodBeat.o(204054);
      return;
    }
    AppMethodBeat.o(204054);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/service/FinderContactService$Companion;", "", "()V", "FINDER_CONTACT_EXPIRED_TIME", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
  static final class b
    extends q
    implements b<r, z>
  {
    b(a parama, String paramString)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
  static final class c
    extends q
    implements b<r, z>
  {
    c(a parama, String paramString)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/service/FinderContactService$contactExtension$1", "Lcom/tencent/mm/storage/IContactStorage$IContactExtension;", "get", "Lcom/tencent/mm/storage/Contact;", "username", "", "onPreInsertContact", "", "stg", "Lcom/tencent/mm/storage/IContactStorage;", "contact", "replace", "", "isUpdate", "", "plugin-finder_release"})
  public static final class d
    implements bq.a
  {
    public final an BH(String paramString)
    {
      AppMethodBeat.i(204032);
      Object localObject1 = (CharSequence)paramString;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(204032);
        return null;
      }
      String str;
      if (an.aji(paramString))
      {
        str = ((com.tencent.mm.plugin.i.a.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.p.class)).ajf(paramString);
        if ((!an.aUt(str)) && (!an.aUu(str))) {
          break label99;
        }
      }
      label99:
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label104;
        }
        AppMethodBeat.o(204032);
        return null;
        str = paramString;
        break;
      }
      label104:
      if (an.aUu(str))
      {
        localObject1 = com.tencent.mm.plugin.finder.api.c.rPy;
        localObject1 = c.a.ahT(str);
        if (localObject1 != null)
        {
          localObject1 = com.tencent.mm.plugin.finder.api.g.e((com.tencent.mm.plugin.finder.api.g)localObject1);
          if (localObject1 != null)
          {
            localObject2 = (CharSequence)((an)localObject1).VK();
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
          localObject1 = ((an)localObject1).VK();
          localObject1 = ((StringBuilder)localObject2).append((String)localObject1).append(" talker=");
          d.g.b.p.g(str, "talker");
          ae.e("Finder.ContactService", a.aja(str));
          this.sEj.bg(str, false);
          localObject1 = new an(paramString);
        }
      }
      label161:
      label296:
      label301:
      label306:
      for (;;)
      {
        label185:
        ((an)localObject1).setUsername(paramString);
        AppMethodBeat.o(204032);
        return localObject1;
        localObject1 = null;
        break;
        localObject1 = a.b(this.sEj);
        d.g.b.p.g(str, "talker");
        localObject1 = ((v)localObject1).ahT(str);
        if (localObject1 != null)
        {
          localObject1 = com.tencent.mm.plugin.finder.api.g.e((com.tencent.mm.plugin.finder.api.g)localObject1);
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
    
    public final void a(bq parambq, an paraman) {}
    
    public final int b(an paraman, boolean paramBoolean)
    {
      AppMethodBeat.i(204031);
      if (paraman == null)
      {
        AppMethodBeat.o(204031);
        return -1;
      }
      String str = paraman.getUsername();
      Object localObject = (CharSequence)str;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(204031);
        return -1;
      }
      localObject = str;
      if (an.aji(str)) {
        localObject = ((com.tencent.mm.plugin.i.a.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.p.class)).ajf(str);
      }
      if ((paraman.getFromType() == 2) || (an.aUt((String)localObject)) || (an.aUu((String)localObject))) {}
      for (i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(204031);
        return -1;
      }
      AppMethodBeat.o(204031);
      return 1;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderContactFetcher;", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<com.tencent.mm.plugin.finder.cgi.fetcher.a>
  {
    public static final e sEk;
    
    static
    {
      AppMethodBeat.i(204034);
      sEk = new e();
      AppMethodBeat.o(204034);
    }
    
    e()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
  static final class f
    extends q
    implements b<List<? extends r>, z>
  {
    f(f.b paramb)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
  static final class g
    extends q
    implements b<r, z>
  {
    g(f.b paramb)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "contact", "", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "kotlin.jvm.PlatformType", "", "onDone"})
  static final class h
    implements f.b
  {
    h(f.a parama) {}
    
    public final void dK(List<r> paramList)
    {
      AppMethodBeat.i(204037);
      f.a locala = this.sEm;
      d.g.b.p.g(paramList, "contact");
      locala.c((r)d.a.j.jm(paramList));
      AppMethodBeat.o(204037);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "result", "", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "kotlin.jvm.PlatformType", "", "onDone"})
  static final class i
    implements f.b
  {
    i(List paramList, f.b paramb) {}
    
    public final void dK(List<r> paramList)
    {
      AppMethodBeat.i(204038);
      StringBuilder localStringBuilder1 = new StringBuilder("[getContact] completed! usernameList=").append(this.jNj).append(" result=");
      d.g.b.p.g(paramList, "result");
      Object localObject = (Iterable)paramList;
      Collection localCollection = (Collection)new ArrayList(d.a.j.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        r localr = (r)((Iterator)localObject).next();
        StringBuilder localStringBuilder2 = new StringBuilder();
        d.g.b.p.g(localr, "it");
        localCollection.add(localr.getUsername() + '=' + localr.VK());
      }
      ae.i("Finder.ContactService", (List)localCollection);
      paramString.dK(paramList);
      AppMethodBeat.o(204038);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
  static final class j
    extends q
    implements b<r, z>
  {
    j(f.a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
  static final class k
    extends q
    implements b<r, z>
  {
    k(f.a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "invoke"})
  static final class l
    extends q
    implements d.g.a.a<w>
  {
    public static final l sEo;
    
    static
    {
      AppMethodBeat.i(204042);
      sEo = new l();
      AppMethodBeat.o(204042);
    }
    
    l()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;", "invoke"})
  static final class m
    extends q
    implements d.g.a.a<v>
  {
    public static final m sEp;
    
    static
    {
      AppMethodBeat.i(204044);
      sEp = new m();
      AppMethodBeat.o(204044);
    }
    
    m()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.service.a
 * JD-Core Version:    0.7.0.1
 */