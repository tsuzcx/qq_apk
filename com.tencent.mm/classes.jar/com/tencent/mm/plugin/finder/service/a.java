package com.tencent.mm.plugin.finder.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.storage.w;
import com.tencent.mm.plugin.i.a.f.a;
import com.tencent.mm.plugin.i.a.f.b;
import com.tencent.mm.plugin.i.a.r;
import com.tencent.mm.protocal.protobuf.alz;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bp.a;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/service/FinderContactService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderContactService;", "()V", "contactExtension", "Lcom/tencent/mm/storage/IContactStorage$IContactExtension;", "getContactExtension", "()Lcom/tencent/mm/storage/IContactStorage$IContactExtension;", "finderContactFetcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderContactFetcher;", "getFinderContactFetcher", "()Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderContactFetcher;", "finderContactFetcher$delegate", "Lkotlin/Lazy;", "gettingContactSet", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "sessionInfoStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "getSessionInfoStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "sessionInfoStorage$delegate", "strangerContactStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;", "getStrangerContactStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;", "strangerContactStorage$delegate", "addOnStorageChange", "", "storageChange", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "checkContactExpired", "username", "isCheckAvatar", "", "getFinderContact", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderContactService$GetContactCallback;", "usernameList", "", "Lcom/tencent/mm/plugin/findersdk/api/IFinderContactService$GetContactListCallback;", "getFinderMsgStrangerContact", "commentId", "", "objectId", "sessionId", "getLocalFinderContact", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "getLocalFinderMsgStrangerContact", "isContactExpired", "contact", "isContactRetryLimited", "isSessionMute", "talker", "removeOnStorageChange", "simpleTalker", "Companion", "plugin-finder_release"})
public final class a
  implements com.tencent.mm.plugin.i.a.f
{
  public static final a stX;
  private final d.f rKp;
  private final d.f rLJ;
  private final d.f stU;
  public final bp.a stV;
  private final ConcurrentHashMap<String, Object> stW;
  
  static
  {
    AppMethodBeat.i(203500);
    stX = new a((byte)0);
    AppMethodBeat.o(203500);
  }
  
  public a()
  {
    AppMethodBeat.i(203499);
    this.rLJ = d.g.O((d.g.a.a)l.sud);
    this.rKp = d.g.O((d.g.a.a)m.sue);
    this.stU = d.g.O((d.g.a.a)e.stZ);
    this.stV = ((bp.a)new d(this));
    this.stW = new ConcurrentHashMap();
    AppMethodBeat.o(203499);
  }
  
  private static boolean a(r paramr)
  {
    AppMethodBeat.i(203497);
    long l;
    if (paramr != null)
    {
      l = paramr.cxM();
      if (System.currentTimeMillis() - l < 86400000L) {
        break label92;
      }
    }
    label92:
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        ad.i("Finder.ContactService", "[isContactExpired] current=" + bt.Dc(System.currentTimeMillis() / 1000L) + " time=" + bt.Dc(l / 1000L));
      }
      AppMethodBeat.o(203497);
      return bool;
      l = 0L;
      break;
    }
  }
  
  private static boolean b(r paramr)
  {
    AppMethodBeat.i(203498);
    if (paramr != null) {}
    for (int i = paramr.getRetryCount(); i >= 3; i = 0)
    {
      AppMethodBeat.o(203498);
      return true;
    }
    AppMethodBeat.o(203498);
    return false;
  }
  
  private final v cER()
  {
    AppMethodBeat.i(203486);
    v localv = (v)this.rKp.getValue();
    AppMethodBeat.o(203486);
    return localv;
  }
  
  private final com.tencent.mm.plugin.finder.cgi.fetcher.a cES()
  {
    AppMethodBeat.i(203487);
    com.tencent.mm.plugin.finder.cgi.fetcher.a locala = (com.tencent.mm.plugin.finder.cgi.fetcher.a)this.stU.getValue();
    AppMethodBeat.o(203487);
    return locala;
  }
  
  public final void a(final String paramString, f.a parama)
  {
    int j = 0;
    AppMethodBeat.i(203488);
    d.g.b.p.h(paramString, "username");
    d.g.b.p.h(parama, "callback");
    Object localObject = d.a.j.s((Collection)d.a.j.listOf(paramString));
    paramString = (f.b)new h(parama);
    d.g.b.p.h(localObject, "usernameList");
    d.g.b.p.h(paramString, "callback");
    ad.i("Finder.ContactService", "[getContact] begin... usernameList=".concat(String.valueOf(localObject)));
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
        ad.e("Finder.ContactService", "username is null.");
        localLinkedList2.add(new com.tencent.mm.plugin.finder.api.g());
        break;
      }
      label192:
      paramString = com.tencent.mm.plugin.finder.api.c.rHn;
      paramString = c.a.agW(str);
      if (paramString != null)
      {
        if (((CharSequence)paramString.VC()).length() == 0)
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
        ad.e("Finder.ContactService", paramString);
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
        ad.i("Finder.ContactService", bool + "]. username=" + str);
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
        cES().a((List)localObject, (b)new f(parama));
        AppMethodBeat.o(203488);
        return;
      }
      paramString = cES();
      localObject = localLinkedList1.getFirst();
      d.g.b.p.g(localObject, "reqList.first");
      paramString.j((String)localObject, (b)new g(parama));
      AppMethodBeat.o(203488);
      return;
    }
    parama.dH((List)localLinkedList2);
    AppMethodBeat.o(203488);
  }
  
  public final void a(String paramString1, String paramString2, f.a parama)
  {
    AppMethodBeat.i(203489);
    Object localObject1 = (CharSequence)paramString1;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      ad.e("Finder.ContactService", "username is null.");
      parama.c((r)new com.tencent.mm.plugin.finder.api.g());
      AppMethodBeat.o(203489);
      return;
    }
    localObject1 = (CharSequence)paramString2;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (i = 1; i != 0; i = 0)
    {
      ad.e("Finder.ContactService", "sessionId is null.");
      parama.c((r)new com.tencent.mm.plugin.finder.api.g());
      AppMethodBeat.o(203489);
      return;
    }
    localObject1 = cER().agW(paramString1);
    if (localObject1 != null)
    {
      if (((CharSequence)((com.tencent.mm.plugin.finder.api.g)localObject1).VC()).length() == 0)
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
      ad.e("Finder.ContactService", paramString2);
      if (localObject1 == null) {
        break label283;
      }
    }
    label278:
    label283:
    for (paramString1 = (r)localObject1;; paramString1 = (r)new com.tencent.mm.plugin.finder.api.g(paramString1))
    {
      parama.c(paramString1);
      AppMethodBeat.o(203489);
      return;
      i = 0;
      break;
      paramString2 = null;
      break label233;
    }
    label298:
    localObject1 = cES();
    Object localObject2 = new alz();
    ((alz)localObject2).GlG = paramString1;
    ((alz)localObject2).session_id = paramString2;
    ((com.tencent.mm.plugin.finder.cgi.fetcher.a)localObject1).a((alz)localObject2, (b)new j(parama));
    AppMethodBeat.o(203489);
    return;
    label350:
    ad.i("Finder.ContactService", "[getFinderMsgStrangerContact] local completed! result=" + ((com.tencent.mm.plugin.finder.api.g)localObject1).getUsername() + '=' + ((com.tencent.mm.plugin.finder.api.g)localObject1).VC());
    parama.c((r)localObject1);
    AppMethodBeat.o(203489);
  }
  
  public final r ahZ(String paramString)
  {
    AppMethodBeat.i(203491);
    if (paramString != null)
    {
      c.a locala = com.tencent.mm.plugin.finder.api.c.rHn;
      paramString = (r)c.a.agW(paramString);
      AppMethodBeat.o(203491);
      return paramString;
    }
    AppMethodBeat.o(203491);
    return null;
  }
  
  public final r aia(String paramString)
  {
    AppMethodBeat.i(203492);
    if (paramString != null)
    {
      com.tencent.mm.plugin.finder.api.g localg = cER().agW(paramString);
      if (localg != null) {
        ad.i("Finder.ContactService", "[getLocalFinderStrangerContact] " + localg.getUsername() + '=' + localg.VC());
      }
      for (;;)
      {
        paramString = (r)localg;
        AppMethodBeat.o(203492);
        return paramString;
        ad.i("Finder.ContactService", "[getLocalFinderStrangerContact] get contact return null. ".concat(String.valueOf(paramString)));
      }
    }
    AppMethodBeat.o(203492);
    return null;
  }
  
  public final boolean aib(String paramString)
  {
    AppMethodBeat.i(203494);
    if (((w)this.rLJ.getValue()).aiw(paramString).field_rejectMsg == 1)
    {
      AppMethodBeat.o(203494);
      return true;
    }
    AppMethodBeat.o(203494);
    return false;
  }
  
  public final void dx(final String paramString, boolean paramBoolean)
  {
    Object localObject3 = null;
    boolean bool = false;
    AppMethodBeat.i(221541);
    String str;
    if (am.ail(paramString))
    {
      paramString = ((com.tencent.mm.plugin.i.a.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.p.class)).aii(paramString);
      str = ((com.tencent.mm.plugin.i.a.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.p.class)).aij(paramString);
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
      AppMethodBeat.o(221541);
      return;
      break;
    }
    label94:
    Object localObject1 = (CharSequence)str;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(221541);
      return;
    }
    if (this.stW.containsKey(paramString))
    {
      AppMethodBeat.o(221541);
      return;
    }
    label200:
    label237:
    StringBuilder localStringBuilder;
    if (am.aSU(paramString))
    {
      localObject1 = ahZ(paramString);
      if (localObject1 != null)
      {
        localObject2 = (CharSequence)((r)localObject1).VC();
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          break label450;
        }
        i = 1;
        if (i == 0) {
          if (paramBoolean)
          {
            localObject2 = (CharSequence)((r)localObject1).cxL();
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
    for (Object localObject2 = ((r)localObject1).VC();; localObject2 = null)
    {
      localStringBuilder = localStringBuilder.append((String)localObject2).append(" avatar=");
      localObject2 = localObject3;
      if (localObject1 != null) {
        localObject2 = ((r)localObject1).cxL();
      }
      ad.i("Finder.ContactService", (String)localObject2);
      label364:
      if (!paramBoolean) {
        break label518;
      }
      ((Map)this.stW).put(paramString, this);
      if (!am.aSU(paramString)) {
        break label471;
      }
      cES().j(paramString, (b)new b(this, paramString));
      AppMethodBeat.o(221541);
      return;
      if (am.aST(paramString)) {}
      for (localObject1 = cER().agW(paramString);; localObject1 = null)
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
    localObject1 = cES();
    localObject2 = new alz();
    ((alz)localObject2).GlG = paramString;
    ((alz)localObject2).session_id = str;
    ((com.tencent.mm.plugin.finder.cgi.fetcher.a)localObject1).a((alz)localObject2, (b)new c(this, paramString));
    label518:
    AppMethodBeat.o(221541);
  }
  
  public final void l(k.a parama)
  {
    AppMethodBeat.i(203493);
    if (parama != null)
    {
      ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getContactStorage().remove(parama);
      ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getMsgStrangerContactStorage().remove(parama);
      AppMethodBeat.o(203493);
      return;
    }
    AppMethodBeat.o(203493);
  }
  
  public final void m(k.a parama)
  {
    AppMethodBeat.i(203495);
    if (parama != null)
    {
      ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getContactStorage().add(parama);
      ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getMsgStrangerContactStorage().add(parama);
      AppMethodBeat.o(203495);
      return;
    }
    AppMethodBeat.o(203495);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/service/FinderContactService$Companion;", "", "()V", "FINDER_CONTACT_EXPIRED_TIME", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
  static final class b
    extends q
    implements b<r, z>
  {
    b(a parama, String paramString)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
  static final class c
    extends q
    implements b<r, z>
  {
    c(a parama, String paramString)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/service/FinderContactService$contactExtension$1", "Lcom/tencent/mm/storage/IContactStorage$IContactExtension;", "get", "Lcom/tencent/mm/storage/Contact;", "username", "", "onPreInsertContact", "", "stg", "Lcom/tencent/mm/storage/IContactStorage;", "contact", "replace", "", "isUpdate", "", "plugin-finder_release"})
  public static final class d
    implements bp.a
  {
    public final am Bf(String paramString)
    {
      AppMethodBeat.i(203473);
      Object localObject1 = (CharSequence)paramString;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(203473);
        return null;
      }
      String str;
      if (am.ail(paramString))
      {
        str = ((com.tencent.mm.plugin.i.a.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.p.class)).aii(paramString);
        if ((!am.aST(str)) && (!am.aSU(str))) {
          break label99;
        }
      }
      label99:
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label104;
        }
        AppMethodBeat.o(203473);
        return null;
        str = paramString;
        break;
      }
      label104:
      if (am.aSU(str))
      {
        localObject1 = com.tencent.mm.plugin.finder.api.c.rHn;
        d.g.b.p.g(str, "talker");
        localObject1 = c.a.agW(str);
        if (localObject1 != null)
        {
          localObject1 = com.tencent.mm.plugin.finder.api.g.e((com.tencent.mm.plugin.finder.api.g)localObject1);
          if (localObject1 != null)
          {
            localObject2 = (CharSequence)((am)localObject1).VC();
            if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
              break label294;
            }
            i = 1;
            if (i == 0) {
              break label304;
            }
          }
          Object localObject2 = new StringBuilder("[get] contact is null or nickname is empty. nickname=");
          if (localObject1 == null) {
            break label299;
          }
          localObject1 = ((am)localObject1).VC();
          ad.e("Finder.ContactService", (String)localObject1 + " talker=" + a.aid(str));
          this.stY.dx(str, false);
          localObject1 = new am(paramString);
        }
      }
      label168:
      label299:
      label304:
      for (;;)
      {
        label192:
        ((am)localObject1).setUsername(paramString);
        AppMethodBeat.o(203473);
        return localObject1;
        localObject1 = null;
        break;
        localObject1 = a.b(this.stY);
        d.g.b.p.g(str, "talker");
        localObject1 = ((v)localObject1).agW(str);
        if (localObject1 != null)
        {
          localObject1 = com.tencent.mm.plugin.finder.api.g.e((com.tencent.mm.plugin.finder.api.g)localObject1);
          break;
        }
        localObject1 = null;
        break;
        i = 0;
        break label168;
        localObject1 = null;
        break label192;
      }
    }
    
    public final void a(bp parambp, am paramam) {}
    
    public final int b(am paramam, boolean paramBoolean)
    {
      AppMethodBeat.i(203472);
      if (paramam == null)
      {
        AppMethodBeat.o(203472);
        return -1;
      }
      String str = paramam.getUsername();
      Object localObject = (CharSequence)str;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(203472);
        return -1;
      }
      localObject = str;
      if (am.ail(str)) {
        localObject = ((com.tencent.mm.plugin.i.a.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.p.class)).aii(str);
      }
      if ((paramam.getFromType() == 2) || (am.aST((String)localObject)) || (am.aSU((String)localObject))) {}
      for (i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(203472);
        return -1;
      }
      AppMethodBeat.o(203472);
      return 1;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderContactFetcher;", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<com.tencent.mm.plugin.finder.cgi.fetcher.a>
  {
    public static final e stZ;
    
    static
    {
      AppMethodBeat.i(203475);
      stZ = new e();
      AppMethodBeat.o(203475);
    }
    
    e()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
  static final class f
    extends q
    implements b<List<? extends r>, z>
  {
    f(f.b paramb)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
  static final class g
    extends q
    implements b<r, z>
  {
    g(f.b paramb)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "contact", "", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "kotlin.jvm.PlatformType", "", "onDone"})
  static final class h
    implements f.b
  {
    h(f.a parama) {}
    
    public final void dH(List<r> paramList)
    {
      AppMethodBeat.i(203478);
      f.a locala = this.sub;
      d.g.b.p.g(paramList, "contact");
      locala.c((r)d.a.j.jd(paramList));
      AppMethodBeat.o(203478);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "result", "", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "kotlin.jvm.PlatformType", "", "onDone"})
  static final class i
    implements f.b
  {
    i(List paramList, f.b paramb) {}
    
    public final void dH(List<r> paramList)
    {
      AppMethodBeat.i(203479);
      StringBuilder localStringBuilder1 = new StringBuilder("[getContact] completed! usernameList=").append(this.kax).append(" result=");
      d.g.b.p.g(paramList, "result");
      Object localObject = (Iterable)paramList;
      Collection localCollection = (Collection)new ArrayList(d.a.j.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        r localr = (r)((Iterator)localObject).next();
        StringBuilder localStringBuilder2 = new StringBuilder();
        d.g.b.p.g(localr, "it");
        localCollection.add(localr.getUsername() + '=' + localr.VC());
      }
      ad.i("Finder.ContactService", (List)localCollection);
      paramString.dH(paramList);
      AppMethodBeat.o(203479);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
  static final class j
    extends q
    implements b<r, z>
  {
    j(f.a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
  static final class k
    extends q
    implements b<r, z>
  {
    k(f.a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "invoke"})
  static final class l
    extends q
    implements d.g.a.a<w>
  {
    public static final l sud;
    
    static
    {
      AppMethodBeat.i(203483);
      sud = new l();
      AppMethodBeat.o(203483);
    }
    
    l()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;", "invoke"})
  static final class m
    extends q
    implements d.g.a.a<v>
  {
    public static final m sue;
    
    static
    {
      AppMethodBeat.i(203485);
      sue = new m();
      AppMethodBeat.o(203485);
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