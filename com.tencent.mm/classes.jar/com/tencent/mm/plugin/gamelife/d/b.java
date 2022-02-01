package com.tencent.mm.plugin.gamelife.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.c.d;
import com.tencent.mm.plugin.gamelife.c.e;
import com.tencent.mm.plugin.messenger.foundation.a.n;
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
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContactService;", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContactService;", "()V", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContact;", "contactExtension", "com/tencent/mm/plugin/gamelife/contact/GameLifeContactService$contactExtension$1", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContactService$contactExtension$1;", "addOnStorageChange", "", "storageChange", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "checkContactExpired", "username", "deleteCache", "getContact", "callback", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContactService$ContactCallback;", "usernameList", "", "getContactExtension", "Lcom/tencent/mm/storage/IContactStorage$IContactExtension;", "getContactExtension$plugin_gamelife_release", "getContactFromLocal", "", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "result", "remain", "getContactFromServer", "isBlackListAssociateWithWAGame", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContactService$BlackListAssociateCallback;", "removeCacheInWX", "removeOnStorageChange", "setBlackListAssociateWithWAGame", "setBlack", "", "isAssociate", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContactService$BlackListSetCallback;", "updateCache", "contact", "Companion", "plugin-gamelife_release"})
public final class b
  implements com.tencent.mm.plugin.gamelife.a.b
{
  public static final a Dhm;
  public final c Dhl;
  private final ConcurrentHashMap<String, a> cache;
  
  static
  {
    AppMethodBeat.i(202802);
    Dhm = new a((byte)0);
    AppMethodBeat.o(202802);
  }
  
  public b()
  {
    AppMethodBeat.i(202800);
    this.cache = new ConcurrentHashMap();
    this.Dhl = new c(this);
    AppMethodBeat.o(202800);
  }
  
  private final void a(a parama)
  {
    AppMethodBeat.i(202798);
    String str = parama.getUsername();
    ((Map)this.cache).put(str, parama);
    aKL(str);
    AppMethodBeat.o(202798);
  }
  
  private static void aKL(String paramString)
  {
    AppMethodBeat.i(202799);
    com.tencent.mm.kernel.c.a locala = h.ae(n.class);
    p.j(locala, "MMKernel.service(IMessengerStorage::class.java)");
    ((n)locala).bbL().aHy(paramString);
    AppMethodBeat.o(202799);
  }
  
  private final void b(final List<String> paramList, final com.tencent.mm.plugin.gamelife.a.b.c paramc)
  {
    AppMethodBeat.i(202789);
    final HashMap localHashMap = new HashMap();
    new d(new LinkedList((Collection)paramList)).bhW().j((com.tencent.mm.vending.c.a)new f(this, localHashMap, paramList, paramc));
    AppMethodBeat.o(202789);
  }
  
  private final void c(List<String> paramList, m<? super Map<String, a>, ? super List<String>, x> paramm)
  {
    AppMethodBeat.i(202784);
    Map localMap = ((PluginGameLife)h.ag(PluginGameLife.class)).getContactStorage().fr(paramList);
    Object localObject1 = ((Iterable)localMap.values()).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (a)((Iterator)localObject1).next();
      String str = ((a)localObject2).getUsername();
      ((Map)this.cache).put(str, localObject2);
      aKL(str);
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
    AppMethodBeat.o(202784);
  }
  
  public final void a(String paramString, final com.tencent.mm.plugin.gamelife.a.b.a parama)
  {
    AppMethodBeat.i(202794);
    p.k(paramString, "username");
    p.k(parama, "callback");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Log.e("GameLife.ContactService", "isBlackListAssociateWithWAGame username null!");
        parama.ac(false, false);
      }
      Log.i("GameLife.ContactService", "isBlackListAssociateWithWAGame username:%s", new Object[] { paramString });
      new com.tencent.mm.plugin.gamelife.c.a(paramString).bhW().j((com.tencent.mm.vending.c.a)new g(paramString, parama));
      AppMethodBeat.o(202794);
      return;
    }
  }
  
  public final void a(String paramString, com.tencent.mm.plugin.gamelife.a.b.c paramc)
  {
    AppMethodBeat.i(202778);
    p.k(paramString, "username");
    p.k(paramc, "callback");
    a(j.mutableListOf(new String[] { paramString }), paramc);
    AppMethodBeat.o(202778);
  }
  
  public final void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, com.tencent.mm.plugin.gamelife.a.b.b paramb)
  {
    AppMethodBeat.i(202797);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("GameLife.ContactService", "setBlackListAssociateWithWAGame username null!");
      paramb.oa(false);
      AppMethodBeat.o(202797);
      return;
    }
    Log.i("GameLife.ContactService", "setBlackListAssociateWithWAGame username:%s,setBlack:%b,isAssociate:%b", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    new e(paramString, paramBoolean1, paramBoolean2).bhW().j((com.tencent.mm.vending.c.a)new h(paramb));
    AppMethodBeat.o(202797);
  }
  
  public final void a(List<String> paramList, final com.tencent.mm.plugin.gamelife.a.b.c paramc)
  {
    AppMethodBeat.i(202775);
    p.k(paramc, "callback");
    Object localObject = (Collection)paramList;
    if ((localObject == null) || (((Collection)localObject).isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramc.ac(ae.iBR());
      AppMethodBeat.o(202775);
      return;
    }
    paramc = (com.tencent.mm.plugin.gamelife.a.b.c)new b.e(paramList, paramc);
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
        p.j(locala, "it");
        localMap.put(str, locala);
      }
      else
      {
        localLinkedList.add(str);
      }
    }
    if (localLinkedList.isEmpty())
    {
      paramc.ac((Map)localObject);
      AppMethodBeat.o(202775);
      return;
    }
    c((List)localLinkedList, (m)new d(this, (HashMap)localObject, paramc));
    AppMethodBeat.o(202775);
  }
  
  public final void aKF(String paramString)
  {
    AppMethodBeat.i(202787);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("GameLife.ContactService", "checkContactExpired userName empty");
      AppMethodBeat.o(202787);
      return;
    }
    localObject = aKK(paramString);
    if (localObject == null)
    {
      Log.e("GameLife.ContactService", "checkContactExpired contact null username:%s", new Object[] { paramString });
      AppMethodBeat.o(202787);
      return;
    }
    long l = cm.bfE() - ((a)localObject).field_updateTime;
    Log.d("GameLife.ContactService", "syncTime diff:%d,contact.field_updateTime:%d", new Object[] { Long.valueOf(l), Long.valueOf(((a)localObject).field_updateTime) });
    if (l >= 86400000L)
    {
      Log.i("GameLife.ContactService", "[checkContactExpired] diff:" + l + " limit:86400000 username:" + paramString);
      b(j.listOf(paramString), (com.tencent.mm.plugin.gamelife.a.b.c)b.Dhn);
    }
    AppMethodBeat.o(202787);
  }
  
  public final a aKK(String paramString)
  {
    AppMethodBeat.i(202780);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(202780);
      return null;
    }
    localObject = (a)this.cache.get(paramString);
    if (localObject != null)
    {
      AppMethodBeat.o(202780);
      return localObject;
    }
    paramString = ((PluginGameLife)h.ag(PluginGameLife.class)).getContactStorage().aKM(paramString);
    if (paramString != null)
    {
      a(paramString);
      AppMethodBeat.o(202780);
      return paramString;
    }
    AppMethodBeat.o(202780);
    return null;
  }
  
  public final void l(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(202792);
    if (paramIOnStorageChange != null)
    {
      ((PluginGameLife)h.ag(PluginGameLife.class)).getContactStorage().remove(paramIOnStorageChange);
      AppMethodBeat.o(202792);
      return;
    }
    AppMethodBeat.o(202792);
  }
  
  public final void m(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(202790);
    if (paramIOnStorageChange != null)
    {
      ((PluginGameLife)h.ag(PluginGameLife.class)).getContactStorage().add(paramIOnStorageChange);
      AppMethodBeat.o(202790);
      return;
    }
    AppMethodBeat.o(202790);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContactService$Companion;", "", "()V", "CONTACT_EXPIRE_TIME", "", "TAG", "", "plugin-gamelife_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContact;", "", "onDone"})
  static final class b
    implements com.tencent.mm.plugin.gamelife.a.b.c
  {
    public static final b Dhn;
    
    static
    {
      AppMethodBeat.i(203629);
      Dhn = new b();
      AppMethodBeat.o(203629);
    }
    
    public final void ac(Map<String, com.tencent.mm.plugin.gamelife.a.a> paramMap) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/gamelife/contact/GameLifeContactService$contactExtension$1", "Lcom/tencent/mm/storage/IContactStorage$IContactExtension;", "get", "Lcom/tencent/mm/storage/Contact;", "username", "", "onPreInsertContact", "", "stg", "Lcom/tencent/mm/storage/IContactStorage;", "contact", "replace", "", "isUpdate", "", "plugin-gamelife_release"})
  public static final class c
    implements bv.a
  {
    public final as RG(String paramString)
    {
      AppMethodBeat.i(204362);
      Object localObject = (CharSequence)paramString;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
      for (int i = 1; (i != 0) || (!as.bvQ(paramString)); i = 0)
      {
        AppMethodBeat.o(204362);
        return null;
      }
      localObject = ((com.tencent.mm.plugin.gamelife.a.f)h.ae(com.tencent.mm.plugin.gamelife.a.f.class)).aED(paramString);
      localObject = this.Dho.aKK((String)localObject);
      if (localObject != null) {}
      for (localObject = ((a)localObject).eAf();; localObject = new as())
      {
        ((as)localObject).setUsername(paramString);
        AppMethodBeat.o(204362);
        return localObject;
      }
    }
    
    public final void a(bv parambv, as paramas) {}
    
    public final int b(as paramas, boolean paramBoolean)
    {
      AppMethodBeat.i(204360);
      if (paramas == null)
      {
        AppMethodBeat.o(204360);
        return -1;
      }
      if (!as.bvQ(paramas.getUsername()))
      {
        AppMethodBeat.o(204360);
        return -1;
      }
      AppMethodBeat.o(204360);
      return 1;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "resultMap", "", "", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContact;", "remain", "", "invoke"})
  static final class d
    extends q
    implements m<Map<String, ? extends a>, List<? extends String>, x>
  {
    d(b paramb, HashMap paramHashMap, com.tencent.mm.plugin.gamelife.a.b.c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/plugin/gamelife/autogen/GetChatUserInfoResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class f<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    f(b paramb, HashMap paramHashMap, List paramList, com.tencent.mm.plugin.gamelife.a.b.c paramc) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/plugin/gamelife/autogen/GetBlackListResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class g<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    g(String paramString, com.tencent.mm.plugin.gamelife.a.b.a parama) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/plugin/gamelife/autogen/SetBlackListResponse;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Lkotlin/Unit;"})
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