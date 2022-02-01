package com.tencent.mm.plugin.gamelife.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.c.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bp.a;
import d.a.ae;
import d.a.j;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContactService;", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContactService;", "()V", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContact;", "contactExtension", "com/tencent/mm/plugin/gamelife/contact/GameLifeContactService$contactExtension$1", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContactService$contactExtension$1;", "checkContactExpired", "", "username", "deleteCache", "getContact", "callback", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContactService$ContactCallback;", "usernameList", "", "getContactExtension", "Lcom/tencent/mm/storage/IContactStorage$IContactExtension;", "getContactExtension$plugin_gamelife_release", "getContactFromLocal", "", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "result", "remain", "getContactFromServer", "isBlackListAssociateWithWAGame", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContactService$BlackListAssociateCallback;", "removeCacheInWX", "setBlackListAssociateWithWAGame", "setBlack", "", "isAssociate", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContactService$BlackListSetCallback;", "updateCache", "contact", "Companion", "plugin-gamelife_release"})
public final class b
  implements com.tencent.mm.plugin.gamelife.a.b
{
  public static final a uxN;
  private final ConcurrentHashMap<String, a> cache;
  public final c uxM;
  
  static
  {
    AppMethodBeat.i(211312);
    uxN = new a((byte)0);
    AppMethodBeat.o(211312);
  }
  
  public b()
  {
    AppMethodBeat.i(211311);
    this.cache = new ConcurrentHashMap();
    this.uxM = new c(this);
    AppMethodBeat.o(211311);
  }
  
  private final void a(a parama)
  {
    AppMethodBeat.i(211309);
    String str = parama.getUsername();
    ((Map)this.cache).put(str, parama);
    amE(str);
    AppMethodBeat.o(211309);
  }
  
  private static void amE(String paramString)
  {
    AppMethodBeat.i(211310);
    com.tencent.mm.kernel.c.a locala = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(locala, "MMKernel.service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)locala).azp().akd(paramString);
    AppMethodBeat.o(211310);
  }
  
  private final void b(final List<String> paramList, final com.tencent.mm.plugin.gamelife.a.b.c paramc)
  {
    AppMethodBeat.i(211306);
    final HashMap localHashMap = new HashMap();
    new d(new LinkedList((Collection)paramList)).aED().j((com.tencent.mm.vending.c.a)new f(this, localHashMap, paramList, paramc));
    AppMethodBeat.o(211306);
  }
  
  private final void c(List<String> paramList, m<? super Map<String, a>, ? super List<String>, z> paramm)
  {
    AppMethodBeat.i(211304);
    Map localMap = ((PluginGameLife)g.ad(PluginGameLife.class)).getContactStorage().eg(paramList);
    Object localObject1 = ((Iterable)localMap.values()).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (a)((Iterator)localObject1).next();
      String str = ((a)localObject2).getUsername();
      ((Map)this.cache).put(str, localObject2);
      amE(str);
    }
    localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if (!localMap.containsKey((String)localObject2)) {
        paramList.add(localObject2);
      }
    }
    paramm.p(localMap, (List)paramList);
    AppMethodBeat.o(211304);
  }
  
  public final void a(String paramString, final com.tencent.mm.plugin.gamelife.a.b.a parama)
  {
    AppMethodBeat.i(211307);
    p.h(paramString, "username");
    p.h(parama, "callback");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ad.e("GameLife.ContactService", "isBlackListAssociateWithWAGame username null!");
        parama.S(false, false);
      }
      ad.i("GameLife.ContactService", "isBlackListAssociateWithWAGame username:%s", new Object[] { paramString });
      new com.tencent.mm.plugin.gamelife.c.a(paramString).aED().j((com.tencent.mm.vending.c.a)new g(paramString, parama));
      AppMethodBeat.o(211307);
      return;
    }
  }
  
  public final void a(String paramString, com.tencent.mm.plugin.gamelife.a.b.c paramc)
  {
    AppMethodBeat.i(211301);
    p.h(paramString, "username");
    p.h(paramc, "callback");
    a(j.mutableListOf(new String[] { paramString }), paramc);
    AppMethodBeat.o(211301);
  }
  
  public final void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, com.tencent.mm.plugin.gamelife.a.b.b paramb)
  {
    AppMethodBeat.i(211308);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      ad.e("GameLife.ContactService", "setBlackListAssociateWithWAGame username null!");
      paramb.mZ(false);
      AppMethodBeat.o(211308);
      return;
    }
    ad.i("GameLife.ContactService", "setBlackListAssociateWithWAGame username:%s,setBlack:%b,isAssociate:%b", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    new com.tencent.mm.plugin.gamelife.c.e(paramString, paramBoolean1, paramBoolean2).aED().j((com.tencent.mm.vending.c.a)new h(paramb));
    AppMethodBeat.o(211308);
  }
  
  public final void a(List<String> paramList, final com.tencent.mm.plugin.gamelife.a.b.c paramc)
  {
    AppMethodBeat.i(211300);
    p.h(paramc, "callback");
    Object localObject = (Collection)paramList;
    if ((localObject == null) || (((Collection)localObject).isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramc.ab(ae.emptyMap());
      AppMethodBeat.o(211300);
      return;
    }
    paramc = (com.tencent.mm.plugin.gamelife.a.b.c)new e(paramList, paramc);
    localObject = new HashMap();
    LinkedList localLinkedList = new LinkedList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (((CharSequence)str).length() == 0) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label170;
        }
        ((Map)localObject).put("", new a());
        break;
      }
      label170:
      a locala = (a)this.cache.get(str);
      if (locala != null)
      {
        Map localMap = (Map)localObject;
        p.g(locala, "it");
        localMap.put(str, locala);
      }
      else
      {
        localLinkedList.add(str);
      }
    }
    if (localLinkedList.isEmpty())
    {
      paramc.ab((Map)localObject);
      AppMethodBeat.o(211300);
      return;
    }
    c((List)localLinkedList, (m)new d(this, (HashMap)localObject, paramc));
    AppMethodBeat.o(211300);
  }
  
  public final void aic(String paramString)
  {
    AppMethodBeat.i(211305);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(211305);
      return;
    }
    localObject = amD(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(211305);
      return;
    }
    long l = cf.aCM() - ((a)localObject).field_updateTime;
    if (l >= 86400000L)
    {
      ad.i("GameLife.ContactService", "[checkContactExpired] diff:" + l + " limit:86400000 username:" + paramString);
      b(j.listOf(paramString), (com.tencent.mm.plugin.gamelife.a.b.c)b.uxO);
    }
    AppMethodBeat.o(211305);
  }
  
  public final a amD(String paramString)
  {
    AppMethodBeat.i(211302);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(211302);
      return null;
    }
    localObject = (a)this.cache.get(paramString);
    if (localObject != null)
    {
      AppMethodBeat.o(211302);
      return localObject;
    }
    paramString = ((PluginGameLife)g.ad(PluginGameLife.class)).getContactStorage().amF(paramString);
    if (paramString != null)
    {
      a(paramString);
      AppMethodBeat.o(211302);
      return paramString;
    }
    AppMethodBeat.o(211302);
    return null;
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContactService$Companion;", "", "()V", "CONTACT_EXPIRE_TIME", "", "TAG", "", "plugin-gamelife_release"})
  public static final class a {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContact;", "", "onDone"})
  static final class b
    implements com.tencent.mm.plugin.gamelife.a.b.c
  {
    public static final b uxO;
    
    static
    {
      AppMethodBeat.i(211291);
      uxO = new b();
      AppMethodBeat.o(211291);
    }
    
    public final void ab(Map<String, com.tencent.mm.plugin.gamelife.a.a> paramMap) {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/gamelife/contact/GameLifeContactService$contactExtension$1", "Lcom/tencent/mm/storage/IContactStorage$IContactExtension;", "get", "Lcom/tencent/mm/storage/Contact;", "username", "", "onPreInsertContact", "", "stg", "Lcom/tencent/mm/storage/IContactStorage;", "contact", "replace", "", "isUpdate", "", "plugin-gamelife_release"})
  public static final class c
    implements bp.a
  {
    public final am Bf(String paramString)
    {
      AppMethodBeat.i(211293);
      Object localObject = (CharSequence)paramString;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
      for (int i = 1; (i != 0) || (!am.aSV(paramString)); i = 0)
      {
        AppMethodBeat.o(211293);
        return null;
      }
      localObject = ((com.tencent.mm.plugin.gamelife.a.e)g.ab(com.tencent.mm.plugin.gamelife.a.e.class)).aii(paramString);
      localObject = this.uxP.amD((String)localObject);
      if (localObject != null) {}
      for (localObject = ((a)localObject).daA();; localObject = new am())
      {
        ((am)localObject).setUsername(paramString);
        AppMethodBeat.o(211293);
        return localObject;
      }
    }
    
    public final void a(bp parambp, am paramam) {}
    
    public final int b(am paramam, boolean paramBoolean)
    {
      AppMethodBeat.i(211292);
      if (paramam == null)
      {
        AppMethodBeat.o(211292);
        return -1;
      }
      if (!am.aSV(paramam.getUsername()))
      {
        AppMethodBeat.o(211292);
        return -1;
      }
      AppMethodBeat.o(211292);
      return 1;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "resultMap", "", "", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContact;", "remain", "", "invoke"})
  static final class d
    extends q
    implements m<Map<String, ? extends a>, List<? extends String>, z>
  {
    d(b paramb, HashMap paramHashMap, com.tencent.mm.plugin.gamelife.a.b.c paramc)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "result", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContact;", "", "onDone"})
  static final class e
    implements com.tencent.mm.plugin.gamelife.a.b.c
  {
    e(List paramList, com.tencent.mm.plugin.gamelife.a.b.c paramc) {}
    
    public final void ab(Map<String, com.tencent.mm.plugin.gamelife.a.a> paramMap)
    {
      AppMethodBeat.i(211296);
      StringBuilder localStringBuilder1 = new StringBuilder("[getContact] usernameList=").append(this.kax).append(" result=");
      p.g(paramMap, "result");
      Collection localCollection = (Collection)new ArrayList(paramMap.size());
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        StringBuilder localStringBuilder2 = new StringBuilder().append((String)((Map.Entry)localObject).getKey()).append('=');
        localObject = ((Map.Entry)localObject).getValue();
        p.g(localObject, "it.value");
        localCollection.add(((com.tencent.mm.plugin.gamelife.a.a)localObject).VC());
      }
      ad.i("GameLife.ContactService", (List)localCollection);
      paramc.ab(paramMap);
      AppMethodBeat.o(211296);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/plugin/gamelife/autogen/GetChatUserInfoResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class f<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    f(b paramb, HashMap paramHashMap, List paramList, com.tencent.mm.plugin.gamelife.a.b.c paramc) {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/plugin/gamelife/autogen/GetBlackListResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class g<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    g(String paramString, com.tencent.mm.plugin.gamelife.a.b.a parama) {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/plugin/gamelife/autogen/SetBlackListResponse;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Lkotlin/Unit;"})
  static final class h<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    h(com.tencent.mm.plugin.gamelife.a.b.b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.d.b
 * JD-Core Version:    0.7.0.1
 */