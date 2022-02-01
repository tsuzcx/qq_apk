package com.tencent.mm.plugin.gamelife.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.c.d;
import com.tencent.mm.plugin.gamelife.c.e;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bq.a;
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

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContactService;", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContactService;", "()V", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContact;", "contactExtension", "com/tencent/mm/plugin/gamelife/contact/GameLifeContactService$contactExtension$1", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContactService$contactExtension$1;", "addOnStorageChange", "", "storageChange", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "checkContactExpired", "username", "deleteCache", "getContact", "callback", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContactService$ContactCallback;", "usernameList", "", "getContactExtension", "Lcom/tencent/mm/storage/IContactStorage$IContactExtension;", "getContactExtension$plugin_gamelife_release", "getContactFromLocal", "", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "result", "remain", "getContactFromServer", "isBlackListAssociateWithWAGame", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContactService$BlackListAssociateCallback;", "removeCacheInWX", "removeOnStorageChange", "setBlackListAssociateWithWAGame", "setBlack", "", "isAssociate", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContactService$BlackListSetCallback;", "updateCache", "contact", "Companion", "plugin-gamelife_release"})
public final class b
  implements com.tencent.mm.plugin.gamelife.a.b
{
  public static final a uJq;
  private final ConcurrentHashMap<String, a> cache;
  public final c uJp;
  
  static
  {
    AppMethodBeat.i(212081);
    uJq = new a((byte)0);
    AppMethodBeat.o(212081);
  }
  
  public b()
  {
    AppMethodBeat.i(212080);
    this.cache = new ConcurrentHashMap();
    this.uJp = new c(this);
    AppMethodBeat.o(212080);
  }
  
  private final void a(a parama)
  {
    AppMethodBeat.i(212078);
    String str = parama.getUsername();
    ((Map)this.cache).put(str, parama);
    anF(str);
    AppMethodBeat.o(212078);
  }
  
  private static void anF(String paramString)
  {
    AppMethodBeat.i(212079);
    com.tencent.mm.kernel.c.a locala = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(locala, "MMKernel.service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)locala).azF().alb(paramString);
    AppMethodBeat.o(212079);
  }
  
  private final void b(final List<String> paramList, final com.tencent.mm.plugin.gamelife.a.b.c paramc)
  {
    AppMethodBeat.i(212073);
    final HashMap localHashMap = new HashMap();
    new d(new LinkedList((Collection)paramList)).aET().j((com.tencent.mm.vending.c.a)new f(this, localHashMap, paramList, paramc));
    AppMethodBeat.o(212073);
  }
  
  private final void c(List<String> paramList, m<? super Map<String, a>, ? super List<String>, z> paramm)
  {
    AppMethodBeat.i(212071);
    Map localMap = ((PluginGameLife)g.ad(PluginGameLife.class)).getContactStorage().ek(paramList);
    Object localObject1 = ((Iterable)localMap.values()).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (a)((Iterator)localObject1).next();
      String str = ((a)localObject2).getUsername();
      ((Map)this.cache).put(str, localObject2);
      anF(str);
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
    AppMethodBeat.o(212071);
  }
  
  public final void a(String paramString, final com.tencent.mm.plugin.gamelife.a.b.a parama)
  {
    AppMethodBeat.i(212076);
    p.h(paramString, "username");
    p.h(parama, "callback");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        com.tencent.mm.sdk.platformtools.ae.e("GameLife.ContactService", "isBlackListAssociateWithWAGame username null!");
        parama.R(false, false);
      }
      com.tencent.mm.sdk.platformtools.ae.i("GameLife.ContactService", "isBlackListAssociateWithWAGame username:%s", new Object[] { paramString });
      new com.tencent.mm.plugin.gamelife.c.a(paramString).aET().j((com.tencent.mm.vending.c.a)new g(paramString, parama));
      AppMethodBeat.o(212076);
      return;
    }
  }
  
  public final void a(String paramString, com.tencent.mm.plugin.gamelife.a.b.c paramc)
  {
    AppMethodBeat.i(212068);
    p.h(paramString, "username");
    p.h(paramc, "callback");
    a(j.mutableListOf(new String[] { paramString }), paramc);
    AppMethodBeat.o(212068);
  }
  
  public final void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, com.tencent.mm.plugin.gamelife.a.b.b paramb)
  {
    AppMethodBeat.i(212077);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      com.tencent.mm.sdk.platformtools.ae.e("GameLife.ContactService", "setBlackListAssociateWithWAGame username null!");
      paramb.nd(false);
      AppMethodBeat.o(212077);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.i("GameLife.ContactService", "setBlackListAssociateWithWAGame username:%s,setBlack:%b,isAssociate:%b", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    new e(paramString, paramBoolean1, paramBoolean2).aET().j((com.tencent.mm.vending.c.a)new h(paramb));
    AppMethodBeat.o(212077);
  }
  
  public final void a(List<String> paramList, final com.tencent.mm.plugin.gamelife.a.b.c paramc)
  {
    AppMethodBeat.i(212067);
    p.h(paramc, "callback");
    Object localObject = (Collection)paramList;
    if ((localObject == null) || (((Collection)localObject).isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramc.ah(d.a.ae.emptyMap());
      AppMethodBeat.o(212067);
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
      paramc.ah((Map)localObject);
      AppMethodBeat.o(212067);
      return;
    }
    c((List)localLinkedList, (m)new d(this, (HashMap)localObject, paramc));
    AppMethodBeat.o(212067);
  }
  
  public final a anE(String paramString)
  {
    AppMethodBeat.i(212069);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(212069);
      return null;
    }
    localObject = (a)this.cache.get(paramString);
    if (localObject != null)
    {
      AppMethodBeat.o(212069);
      return localObject;
    }
    paramString = ((PluginGameLife)g.ad(PluginGameLife.class)).getContactStorage().anG(paramString);
    if (paramString != null)
    {
      a(paramString);
      AppMethodBeat.o(212069);
      return paramString;
    }
    AppMethodBeat.o(212069);
    return null;
  }
  
  public final void anz(String paramString)
  {
    AppMethodBeat.i(212072);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      com.tencent.mm.sdk.platformtools.ae.e("GameLife.ContactService", "checkContactExpired userName empty");
      AppMethodBeat.o(212072);
      return;
    }
    localObject = anE(paramString);
    if (localObject == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("GameLife.ContactService", "checkContactExpired contact null username:%s", new Object[] { paramString });
      AppMethodBeat.o(212072);
      return;
    }
    long l = ch.aDc() - ((a)localObject).field_updateTime;
    com.tencent.mm.sdk.platformtools.ae.d("GameLife.ContactService", "syncTime diff:%d,contact.field_updateTime:%d", new Object[] { Long.valueOf(l), Long.valueOf(((a)localObject).field_updateTime) });
    if (l >= 86400000L)
    {
      com.tencent.mm.sdk.platformtools.ae.i("GameLife.ContactService", "[checkContactExpired] diff:" + l + " limit:86400000 username:" + paramString);
      b(j.listOf(paramString), (com.tencent.mm.plugin.gamelife.a.b.c)b.uJr);
    }
    AppMethodBeat.o(212072);
  }
  
  public final void l(k.a parama)
  {
    AppMethodBeat.i(212075);
    if (parama != null)
    {
      ((PluginGameLife)g.ad(PluginGameLife.class)).getContactStorage().remove(parama);
      AppMethodBeat.o(212075);
      return;
    }
    AppMethodBeat.o(212075);
  }
  
  public final void m(k.a parama)
  {
    AppMethodBeat.i(212074);
    if (parama != null)
    {
      ((PluginGameLife)g.ad(PluginGameLife.class)).getContactStorage().add(parama);
      AppMethodBeat.o(212074);
      return;
    }
    AppMethodBeat.o(212074);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContactService$Companion;", "", "()V", "CONTACT_EXPIRE_TIME", "", "TAG", "", "plugin-gamelife_release"})
  public static final class a {}
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContact;", "", "onDone"})
  static final class b
    implements com.tencent.mm.plugin.gamelife.a.b.c
  {
    public static final b uJr;
    
    static
    {
      AppMethodBeat.i(212058);
      uJr = new b();
      AppMethodBeat.o(212058);
    }
    
    public final void ah(Map<String, com.tencent.mm.plugin.gamelife.a.a> paramMap) {}
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/gamelife/contact/GameLifeContactService$contactExtension$1", "Lcom/tencent/mm/storage/IContactStorage$IContactExtension;", "get", "Lcom/tencent/mm/storage/Contact;", "username", "", "onPreInsertContact", "", "stg", "Lcom/tencent/mm/storage/IContactStorage;", "contact", "replace", "", "isUpdate", "", "plugin-gamelife_release"})
  public static final class c
    implements bq.a
  {
    public final an BH(String paramString)
    {
      AppMethodBeat.i(212060);
      Object localObject = (CharSequence)paramString;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
      for (int i = 1; (i != 0) || (!an.aUv(paramString)); i = 0)
      {
        AppMethodBeat.o(212060);
        return null;
      }
      localObject = ((com.tencent.mm.plugin.gamelife.a.f)g.ab(com.tencent.mm.plugin.gamelife.a.f.class)).ajf(paramString);
      localObject = this.uJs.anE((String)localObject);
      if (localObject != null) {}
      for (localObject = ((a)localObject).ddm();; localObject = new an())
      {
        ((an)localObject).setUsername(paramString);
        AppMethodBeat.o(212060);
        return localObject;
      }
    }
    
    public final void a(bq parambq, an paraman) {}
    
    public final int b(an paraman, boolean paramBoolean)
    {
      AppMethodBeat.i(212059);
      if (paraman == null)
      {
        AppMethodBeat.o(212059);
        return -1;
      }
      if (!an.aUv(paraman.getUsername()))
      {
        AppMethodBeat.o(212059);
        return -1;
      }
      AppMethodBeat.o(212059);
      return 1;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "resultMap", "", "", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContact;", "remain", "", "invoke"})
  static final class d
    extends q
    implements m<Map<String, ? extends a>, List<? extends String>, z>
  {
    d(b paramb, HashMap paramHashMap, com.tencent.mm.plugin.gamelife.a.b.c paramc)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "result", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContact;", "", "onDone"})
  static final class e
    implements com.tencent.mm.plugin.gamelife.a.b.c
  {
    e(List paramList, com.tencent.mm.plugin.gamelife.a.b.c paramc) {}
    
    public final void ah(Map<String, com.tencent.mm.plugin.gamelife.a.a> paramMap)
    {
      AppMethodBeat.i(212063);
      StringBuilder localStringBuilder1 = new StringBuilder("[getContact] usernameList=").append(this.jNj).append(" result=");
      p.g(paramMap, "result");
      Collection localCollection = (Collection)new ArrayList(paramMap.size());
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        StringBuilder localStringBuilder2 = new StringBuilder().append((String)((Map.Entry)localObject).getKey()).append('=');
        localObject = ((Map.Entry)localObject).getValue();
        p.g(localObject, "it.value");
        localCollection.add(((com.tencent.mm.plugin.gamelife.a.a)localObject).VK());
      }
      com.tencent.mm.sdk.platformtools.ae.i("GameLife.ContactService", (List)localCollection);
      paramc.ah(paramMap);
      AppMethodBeat.o(212063);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/plugin/gamelife/autogen/GetChatUserInfoResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class f<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    f(b paramb, HashMap paramHashMap, List paramList, com.tencent.mm.plugin.gamelife.a.b.c paramc) {}
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/plugin/gamelife/autogen/GetBlackListResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class g<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    g(String paramString, com.tencent.mm.plugin.gamelife.a.b.a parama) {}
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/plugin/gamelife/autogen/SetBlackListResponse;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Lkotlin/Unit;"})
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