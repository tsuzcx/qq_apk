package com.tencent.mm.plugin.gamelife.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.c.d;
import com.tencent.mm.plugin.gamelife.c.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bv.a;
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
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContactService;", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContactService;", "()V", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContact;", "contactExtension", "com/tencent/mm/plugin/gamelife/contact/GameLifeContactService$contactExtension$1", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContactService$contactExtension$1;", "addOnStorageChange", "", "storageChange", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "checkContactExpired", "username", "deleteCache", "getContact", "callback", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContactService$ContactCallback;", "usernameList", "", "getContactExtension", "Lcom/tencent/mm/storage/IContactStorage$IContactExtension;", "getContactExtension$plugin_gamelife_release", "getContactFromLocal", "", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "result", "remain", "getContactFromServer", "isBlackListAssociateWithWAGame", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContactService$BlackListAssociateCallback;", "removeCacheInWX", "removeOnStorageChange", "setBlackListAssociateWithWAGame", "setBlack", "", "isAssociate", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContactService$BlackListSetCallback;", "updateCache", "contact", "Companion", "plugin-gamelife_release"})
public final class b
  implements com.tencent.mm.plugin.gamelife.a.b
{
  public static final b.a ybH;
  private final ConcurrentHashMap<String, a> cache;
  public final c ybG;
  
  static
  {
    AppMethodBeat.i(241321);
    ybH = new b.a((byte)0);
    AppMethodBeat.o(241321);
  }
  
  public b()
  {
    AppMethodBeat.i(241320);
    this.cache = new ConcurrentHashMap();
    this.ybG = new c(this);
    AppMethodBeat.o(241320);
  }
  
  private final void a(a parama)
  {
    AppMethodBeat.i(241318);
    String str = parama.getUsername();
    ((Map)this.cache).put(str, parama);
    aAY(str);
    AppMethodBeat.o(241318);
  }
  
  private static void aAY(String paramString)
  {
    AppMethodBeat.i(241319);
    com.tencent.mm.kernel.c.a locala = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(locala, "MMKernel.service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)locala).aSN().ayf(paramString);
    AppMethodBeat.o(241319);
  }
  
  private final void b(final List<String> paramList, final com.tencent.mm.plugin.gamelife.a.b.c paramc)
  {
    AppMethodBeat.i(241313);
    final HashMap localHashMap = new HashMap();
    new d(new LinkedList((Collection)paramList)).aYI().j((com.tencent.mm.vending.c.a)new f(this, localHashMap, paramList, paramc));
    AppMethodBeat.o(241313);
  }
  
  private final void c(List<String> paramList, m<? super Map<String, a>, ? super List<String>, x> paramm)
  {
    AppMethodBeat.i(241311);
    Map localMap = ((PluginGameLife)g.ah(PluginGameLife.class)).getContactStorage().fd(paramList);
    Object localObject1 = ((Iterable)localMap.values()).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (a)((Iterator)localObject1).next();
      String str = ((a)localObject2).getUsername();
      ((Map)this.cache).put(str, localObject2);
      aAY(str);
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
    paramm.invoke(localMap, (List)paramList);
    AppMethodBeat.o(241311);
  }
  
  public final void a(String paramString, com.tencent.mm.plugin.gamelife.a.b.a parama)
  {
    AppMethodBeat.i(241316);
    p.h(paramString, "username");
    p.h(parama, "callback");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Log.e("GameLife.ContactService", "isBlackListAssociateWithWAGame username null!");
        parama.U(false, false);
      }
      Log.i("GameLife.ContactService", "isBlackListAssociateWithWAGame username:%s", new Object[] { paramString });
      new com.tencent.mm.plugin.gamelife.c.a(paramString).aYI().j((com.tencent.mm.vending.c.a)new b.g(paramString, parama));
      AppMethodBeat.o(241316);
      return;
    }
  }
  
  public final void a(String paramString, com.tencent.mm.plugin.gamelife.a.b.c paramc)
  {
    AppMethodBeat.i(241308);
    p.h(paramString, "username");
    p.h(paramc, "callback");
    a(j.mutableListOf(new String[] { paramString }), paramc);
    AppMethodBeat.o(241308);
  }
  
  public final void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, com.tencent.mm.plugin.gamelife.a.b.b paramb)
  {
    AppMethodBeat.i(241317);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("GameLife.ContactService", "setBlackListAssociateWithWAGame username null!");
      paramb.mM(false);
      AppMethodBeat.o(241317);
      return;
    }
    Log.i("GameLife.ContactService", "setBlackListAssociateWithWAGame username:%s,setBlack:%b,isAssociate:%b", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    new e(paramString, paramBoolean1, paramBoolean2).aYI().j((com.tencent.mm.vending.c.a)new h(paramb));
    AppMethodBeat.o(241317);
  }
  
  public final void a(List<String> paramList, final com.tencent.mm.plugin.gamelife.a.b.c paramc)
  {
    AppMethodBeat.i(241307);
    p.h(paramc, "callback");
    Object localObject = (Collection)paramList;
    if ((localObject == null) || (((Collection)localObject).isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramc.aj(ae.emptyMap());
      AppMethodBeat.o(241307);
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
      paramc.aj((Map)localObject);
      AppMethodBeat.o(241307);
      return;
    }
    c((List)localLinkedList, (m)new d(this, (HashMap)localObject, paramc));
    AppMethodBeat.o(241307);
  }
  
  public final void aAS(String paramString)
  {
    AppMethodBeat.i(241312);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("GameLife.ContactService", "checkContactExpired userName empty");
      AppMethodBeat.o(241312);
      return;
    }
    localObject = aAX(paramString);
    if (localObject == null)
    {
      Log.e("GameLife.ContactService", "checkContactExpired contact null username:%s", new Object[] { paramString });
      AppMethodBeat.o(241312);
      return;
    }
    long l = cl.aWA() - ((a)localObject).field_updateTime;
    Log.d("GameLife.ContactService", "syncTime diff:%d,contact.field_updateTime:%d", new Object[] { Long.valueOf(l), Long.valueOf(((a)localObject).field_updateTime) });
    if (l >= 86400000L)
    {
      Log.i("GameLife.ContactService", "[checkContactExpired] diff:" + l + " limit:86400000 username:" + paramString);
      b(j.listOf(paramString), (com.tencent.mm.plugin.gamelife.a.b.c)b.ybI);
    }
    AppMethodBeat.o(241312);
  }
  
  public final a aAX(String paramString)
  {
    AppMethodBeat.i(241309);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(241309);
      return null;
    }
    localObject = (a)this.cache.get(paramString);
    if (localObject != null)
    {
      AppMethodBeat.o(241309);
      return localObject;
    }
    paramString = ((PluginGameLife)g.ah(PluginGameLife.class)).getContactStorage().aAZ(paramString);
    if (paramString != null)
    {
      a(paramString);
      AppMethodBeat.o(241309);
      return paramString;
    }
    AppMethodBeat.o(241309);
    return null;
  }
  
  public final void l(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(241315);
    if (paramIOnStorageChange != null)
    {
      ((PluginGameLife)g.ah(PluginGameLife.class)).getContactStorage().remove(paramIOnStorageChange);
      AppMethodBeat.o(241315);
      return;
    }
    AppMethodBeat.o(241315);
  }
  
  public final void m(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(241314);
    if (paramIOnStorageChange != null)
    {
      ((PluginGameLife)g.ah(PluginGameLife.class)).getContactStorage().add(paramIOnStorageChange);
      AppMethodBeat.o(241314);
      return;
    }
    AppMethodBeat.o(241314);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContact;", "", "onDone"})
  static final class b
    implements com.tencent.mm.plugin.gamelife.a.b.c
  {
    public static final b ybI;
    
    static
    {
      AppMethodBeat.i(241298);
      ybI = new b();
      AppMethodBeat.o(241298);
    }
    
    public final void aj(Map<String, com.tencent.mm.plugin.gamelife.a.a> paramMap) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/gamelife/contact/GameLifeContactService$contactExtension$1", "Lcom/tencent/mm/storage/IContactStorage$IContactExtension;", "get", "Lcom/tencent/mm/storage/Contact;", "username", "", "onPreInsertContact", "", "stg", "Lcom/tencent/mm/storage/IContactStorage;", "contact", "replace", "", "isUpdate", "", "plugin-gamelife_release"})
  public static final class c
    implements bv.a
  {
    public final as Kn(String paramString)
    {
      AppMethodBeat.i(241300);
      Object localObject = (CharSequence)paramString;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
      for (int i = 1; (i != 0) || (!as.bju(paramString)); i = 0)
      {
        AppMethodBeat.o(241300);
        return null;
      }
      localObject = ((com.tencent.mm.plugin.gamelife.a.f)g.af(com.tencent.mm.plugin.gamelife.a.f.class)).avi(paramString);
      localObject = this.ybJ.aAX((String)localObject);
      if (localObject != null) {}
      for (localObject = ((a)localObject).dWW();; localObject = new as())
      {
        ((as)localObject).setUsername(paramString);
        AppMethodBeat.o(241300);
        return localObject;
      }
    }
    
    public final void a(bv parambv, as paramas) {}
    
    public final int b(as paramas, boolean paramBoolean)
    {
      AppMethodBeat.i(241299);
      if (paramas == null)
      {
        AppMethodBeat.o(241299);
        return -1;
      }
      if (!as.bju(paramas.getUsername()))
      {
        AppMethodBeat.o(241299);
        return -1;
      }
      AppMethodBeat.o(241299);
      return 1;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "resultMap", "", "", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContact;", "remain", "", "invoke"})
  static final class d
    extends q
    implements m<Map<String, ? extends a>, List<? extends String>, x>
  {
    d(b paramb, HashMap paramHashMap, com.tencent.mm.plugin.gamelife.a.b.c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContact;", "", "onDone"})
  static final class e
    implements com.tencent.mm.plugin.gamelife.a.b.c
  {
    e(List paramList, com.tencent.mm.plugin.gamelife.a.b.c paramc) {}
    
    public final void aj(Map<String, com.tencent.mm.plugin.gamelife.a.a> paramMap)
    {
      AppMethodBeat.i(241303);
      StringBuilder localStringBuilder1 = new StringBuilder("[getContact] usernameList=").append(this.kPr).append(" result=");
      p.g(paramMap, "result");
      Collection localCollection = (Collection)new ArrayList(paramMap.size());
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        StringBuilder localStringBuilder2 = new StringBuilder().append((String)((Map.Entry)localObject).getKey()).append('=');
        localObject = ((Map.Entry)localObject).getValue();
        p.g(localObject, "it.value");
        localCollection.add(((com.tencent.mm.plugin.gamelife.a.a)localObject).getNickname());
      }
      Log.i("GameLife.ContactService", (List)localCollection);
      paramc.aj(paramMap);
      AppMethodBeat.o(241303);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/plugin/gamelife/autogen/GetChatUserInfoResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class f<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    f(b paramb, HashMap paramHashMap, List paramList, com.tencent.mm.plugin.gamelife.a.b.c paramc) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/plugin/gamelife/autogen/SetBlackListResponse;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Lkotlin/Unit;"})
  static final class h<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    h(com.tencent.mm.plugin.gamelife.a.b.b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.d.b
 * JD-Core Version:    0.7.0.1
 */