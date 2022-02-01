package com.tencent.mm.plugin.gamelife.e;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.b.k;
import com.tencent.mm.plugin.gamelife.c.d;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.bx.a;
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
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContactService;", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContactService;", "()V", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContact;", "contactExtension", "com/tencent/mm/plugin/gamelife/contact/GameLifeContactService$contactExtension$1", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContactService$contactExtension$1;", "addOnStorageChange", "", "storageChange", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "checkContactExpired", "username", "deleteCache", "getContact", "callback", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContactService$ContactCallback;", "usernameList", "", "getContactExtension", "Lcom/tencent/mm/storage/IContactStorage$IContactExtension;", "getContactFromLocal", "", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "result", "remain", "getContactFromServer", "isBlackListAssociateWithWAGame", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContactService$BlackListAssociateCallback;", "removeCacheInWX", "removeOnStorageChange", "setBlackListAssociateWithWAGame", "setBlack", "", "isAssociate", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContactService$BlackListSetCallback;", "updateCache", "contact", "Companion", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements com.tencent.mm.plugin.gamelife.a.b
{
  public static final b.a Jbj;
  private final ConcurrentHashMap<String, a> BvD;
  private final b Jbk;
  
  static
  {
    AppMethodBeat.i(268128);
    Jbj = new b.a((byte)0);
    AppMethodBeat.o(268128);
  }
  
  public b()
  {
    AppMethodBeat.i(268025);
    this.BvD = new ConcurrentHashMap();
    this.Jbk = new b(this);
    AppMethodBeat.o(268025);
  }
  
  private static final ah a(com.tencent.mm.plugin.gamelife.a.b.b paramb, com.tencent.mm.am.b.a parama)
  {
    AppMethodBeat.i(268116);
    if ((parama.errCode == 0) && (parama.errType == 0))
    {
      if (paramb == null)
      {
        AppMethodBeat.o(268116);
        return null;
      }
      paramb.onDone(true);
      paramb = ah.aiuX;
      AppMethodBeat.o(268116);
      return paramb;
    }
    Log.e("GameLife.ContactService", "setBlackListAssociateWithWAGame errCode:%d,errType:%d", new Object[] { Integer.valueOf(parama.errCode), Integer.valueOf(parama.errType) });
    if (paramb == null)
    {
      AppMethodBeat.o(268116);
      return null;
    }
    paramb.onDone(false);
    paramb = ah.aiuX;
    AppMethodBeat.o(268116);
    return paramb;
  }
  
  private static final ah a(String paramString, com.tencent.mm.plugin.gamelife.a.b.a parama, com.tencent.mm.am.b.a parama1)
  {
    AppMethodBeat.i(268106);
    s.u(paramString, "$username");
    s.u(parama, "$callback");
    boolean bool2;
    if ((parama1.errCode == 0) && (parama1.errType == 0))
    {
      bool2 = ((com.tencent.mm.plugin.gamelife.b.e)parama1.ott).JaH;
      if (!s.p(paramString, ((com.tencent.mm.plugin.gamelife.b.e)parama1.ott).JaG.username)) {
        break label139;
      }
    }
    label139:
    for (boolean bool1 = ((com.tencent.mm.plugin.gamelife.b.e)parama1.ott).JaG.JaA;; bool1 = false)
    {
      parama.au(bool2, bool1);
      for (;;)
      {
        paramString = ah.aiuX;
        AppMethodBeat.o(268106);
        return paramString;
        Log.e("GameLife.ContactService", "isBlackListAssociateWithWAGame errCode:%d,errType:%d", new Object[] { Integer.valueOf(parama1.errCode), Integer.valueOf(parama1.errType) });
        parama.au(false, false);
      }
    }
  }
  
  private static final ah a(List paramList, com.tencent.mm.plugin.gamelife.a.b.c paramc, HashMap paramHashMap, b paramb, com.tencent.mm.am.b.a parama)
  {
    AppMethodBeat.i(268098);
    s.u(paramList, "$usernameList");
    s.u(paramc, "$callback");
    s.u(paramHashMap, "$resultList");
    s.u(paramb, "this$0");
    Object localObject1;
    if ((parama.errType == 0) && (parama.errCode == 0) && (((k)parama.ott).JaM != null))
    {
      Log.i("GameLife.ContactService", "get contact from server success, count %d", new Object[] { Integer.valueOf(((k)parama.ott).JaM.size()) });
      parama = ((k)parama.ott).JaM;
      s.s(parama, "result.resp.chat_user_info_list");
      localObject1 = (Iterable)parama;
      parama = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      Object localObject2;
      Object localObject3;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.gamelife.b.b)((Iterator)localObject1).next();
        s.s(localObject2, "it");
        localObject3 = new a();
        s.u(localObject2, "<this>");
        s.u(localObject3, "contact");
        ((a)localObject3).field_username = ((com.tencent.mm.plugin.gamelife.b.b)localObject2).username;
        ((a)localObject3).field_nickname = ((com.tencent.mm.plugin.gamelife.b.b)localObject2).nickname;
        ((a)localObject3).field_avatarURL = ((com.tencent.mm.plugin.gamelife.b.b)localObject2).avatar;
        ((a)localObject3).field_sex = ((com.tencent.mm.plugin.gamelife.b.b)localObject2).sex;
        ((a)localObject3).field_tag = ((com.tencent.mm.plugin.gamelife.b.b)localObject2).tag;
        ((a)localObject3).field_jumpInfo = ((com.tencent.mm.plugin.gamelife.b.b)localObject2).JaB;
        ((a)localObject3).field_accountType = ((com.tencent.mm.plugin.gamelife.b.b)localObject2).JaC;
        parama.add(localObject3);
      }
      parama = ((Iterable)parama).iterator();
      if (parama.hasNext())
      {
        localObject1 = (a)parama.next();
        Log.d("GameLife.ContactService", "gamelife username:%s nickname:%s,avatarUrl:%s", new Object[] { ((a)localObject1).print(), ((a)localObject1).field_nickname, ((a)localObject1).field_avatarURL });
        paramb.a((a)localObject1);
        localObject2 = ((PluginGameLife)h.az(PluginGameLife.class)).getContactStorage();
        s.u(localObject1, "contact");
        ((a)localObject1).field_updateTime = cn.bDw();
        localObject3 = ((a)localObject1).field_username;
        s.s(localObject3, "contact.field_username");
        int i;
        if (((c)localObject2).aHC((String)localObject3) == null)
        {
          s.u(localObject1, "contact");
          localObject3 = ((a)localObject1).convertTo();
          i = (int)((c)localObject2).psb.insert("GameLifeContact", "username", (ContentValues)localObject3);
          Log.i("GameLife.ContactStorage", "insertContact[" + i + "] " + ((a)localObject1).print());
        }
        for (;;)
        {
          if (i > 0) {
            ((c)localObject2).doNotify("GameLifeContact", 3, ((a)localObject1).getUsername());
          }
          ((Map)paramHashMap).put(((a)localObject1).getUsername(), localObject1);
          break;
          s.u(localObject1, "contact");
          localObject3 = ((a)localObject1).convertTo();
          ((ContentValues)localObject3).remove("rowid");
          i = ((c)localObject2).psb.update("GameLifeContact", (ContentValues)localObject3, "username=?", new String[] { ((a)localObject1).field_username });
          Log.i("GameLife.ContactStorage", "updateContact[" + i + "] " + ((a)localObject1).print());
        }
      }
    }
    else
    {
      Log.e("GameLife.ContactService", "get contact from server failed " + parama.errType + ' ' + parama.errCode + ' ' + parama.errMsg);
    }
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      paramb = (String)paramList.next();
      if (!paramHashMap.containsKey(paramb))
      {
        parama = (Map)paramHashMap;
        localObject1 = new a();
        ((a)localObject1).field_username = paramb;
        ((a)localObject1).clZ = false;
        parama.put(paramb, localObject1);
      }
    }
    paramc.onDone((Map)paramHashMap);
    paramList = ah.aiuX;
    AppMethodBeat.o(268098);
    return paramList;
  }
  
  private final void a(a parama)
  {
    AppMethodBeat.i(268051);
    String str = parama.getUsername();
    ((Map)this.BvD).put(str, parama);
    aHB(str);
    AppMethodBeat.o(268051);
  }
  
  private static final void a(List paramList, com.tencent.mm.plugin.gamelife.a.b.c paramc, Map paramMap)
  {
    AppMethodBeat.i(268067);
    s.u(paramc, "$callback");
    paramList = new StringBuilder("[getContact] usernameList=").append(paramList).append(" result=");
    s.s(paramMap, "result");
    Collection localCollection = (Collection)new ArrayList(paramMap.size());
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localCollection.add(localEntry.getKey() + '=' + ((com.tencent.mm.plugin.gamelife.a.a)localEntry.getValue()).getNickname());
    }
    Log.i("GameLife.ContactService", (List)localCollection);
    paramc.onDone(paramMap);
    AppMethodBeat.o(268067);
  }
  
  private static void aHB(String paramString)
  {
    AppMethodBeat.i(268059);
    ((n)h.ax(n.class)).bzA().aDW(paramString);
    AppMethodBeat.o(268059);
  }
  
  private static final void av(Map paramMap) {}
  
  private final void b(List<String> paramList, com.tencent.mm.plugin.gamelife.a.b.c paramc)
  {
    AppMethodBeat.i(268044);
    HashMap localHashMap = new HashMap();
    new d(new LinkedList((Collection)paramList)).bFJ().j(new b..ExternalSyntheticLambda4(paramList, paramc, localHashMap, this));
    AppMethodBeat.o(268044);
  }
  
  private final void c(List<String> paramList, m<? super Map<String, a>, ? super List<String>, ah> paramm)
  {
    AppMethodBeat.i(268038);
    Map localMap = ((PluginGameLife)h.az(PluginGameLife.class)).getContactStorage().ij(paramList);
    Object localObject1 = ((Iterable)localMap.values()).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (a)((Iterator)localObject1).next();
      String str = ((a)localObject2).getUsername();
      ((Map)this.BvD).put(str, localObject2);
      aHB(str);
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
    AppMethodBeat.o(268038);
  }
  
  public final void a(String paramString, com.tencent.mm.plugin.gamelife.a.b.a parama)
  {
    AppMethodBeat.i(268246);
    s.u(paramString, "username");
    s.u(parama, "callback");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Log.e("GameLife.ContactService", "isBlackListAssociateWithWAGame username null!");
        parama.au(false, false);
      }
      Log.i("GameLife.ContactService", "isBlackListAssociateWithWAGame username:%s", new Object[] { paramString });
      new com.tencent.mm.plugin.gamelife.c.a(paramString).bFJ().j(new b..ExternalSyntheticLambda3(paramString, parama));
      AppMethodBeat.o(268246);
      return;
    }
  }
  
  public final void a(String paramString, com.tencent.mm.plugin.gamelife.a.b.c paramc)
  {
    AppMethodBeat.i(268195);
    s.u(paramString, "username");
    s.u(paramc, "callback");
    a(p.mutableListOf(new String[] { paramString }), paramc);
    AppMethodBeat.o(268195);
  }
  
  public final void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, com.tencent.mm.plugin.gamelife.a.b.b paramb)
  {
    AppMethodBeat.i(268268);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("GameLife.ContactService", "setBlackListAssociateWithWAGame username null!");
      if (paramb != null) {
        paramb.onDone(false);
      }
      AppMethodBeat.o(268268);
      return;
    }
    Log.i("GameLife.ContactService", "setBlackListAssociateWithWAGame username:%s,setBlack:%b,isAssociate:%b", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    new com.tencent.mm.plugin.gamelife.c.e(paramString, paramBoolean1, paramBoolean2).bFJ().j(new b..ExternalSyntheticLambda2(paramb));
    AppMethodBeat.o(268268);
  }
  
  public final void a(List<String> paramList, final com.tencent.mm.plugin.gamelife.a.b.c paramc)
  {
    AppMethodBeat.i(268185);
    s.u(paramc, "callback");
    Object localObject = (Collection)paramList;
    if ((localObject == null) || (((Collection)localObject).isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramc.onDone(ak.kkZ());
      AppMethodBeat.o(268185);
      return;
    }
    paramc = new b..ExternalSyntheticLambda0(paramList, paramc);
    localObject = new HashMap();
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = ((Iterable)paramList).iterator();
    label170:
    label223:
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (((CharSequence)str).length() == 0) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label170;
        }
        ((Map)localObject).put("", new a());
        break;
      }
      paramList = (a)this.BvD.get(str);
      if (paramList == null) {}
      for (paramList = null;; paramList = ah.aiuX)
      {
        if (paramList != null) {
          break label223;
        }
        localLinkedList.add(str);
        break;
        ((Map)localObject).put(str, paramList);
      }
    }
    if (localLinkedList.isEmpty())
    {
      paramc.onDone((Map)localObject);
      AppMethodBeat.o(268185);
      return;
    }
    c((List)localLinkedList, (m)new c((HashMap)localObject, this, paramc));
    AppMethodBeat.o(268185);
  }
  
  public final a aHA(String paramString)
  {
    AppMethodBeat.i(268205);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(268205);
      return null;
    }
    localObject = (a)this.BvD.get(paramString);
    if (localObject != null)
    {
      AppMethodBeat.o(268205);
      return localObject;
    }
    paramString = ((PluginGameLife)h.az(PluginGameLife.class)).getContactStorage().aHC(paramString);
    if (paramString != null)
    {
      a(paramString);
      AppMethodBeat.o(268205);
      return paramString;
    }
    AppMethodBeat.o(268205);
    return null;
  }
  
  public final void aHv(String paramString)
  {
    AppMethodBeat.i(268233);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("GameLife.ContactService", "checkContactExpired userName empty");
      AppMethodBeat.o(268233);
      return;
    }
    localObject = aHA(paramString);
    if (localObject == null)
    {
      Log.e("GameLife.ContactService", "checkContactExpired contact null username:%s", new Object[] { paramString });
      AppMethodBeat.o(268233);
      return;
    }
    long l = cn.bDw() - ((a)localObject).field_updateTime;
    Log.d("GameLife.ContactService", "syncTime diff:%d,contact.field_updateTime:%d", new Object[] { Long.valueOf(l), Long.valueOf(((a)localObject).field_updateTime) });
    if (l >= 86400000L)
    {
      Log.i("GameLife.ContactService", "[checkContactExpired] diff:" + l + " limit:86400000 username:" + paramString);
      b(p.listOf(paramString), b..ExternalSyntheticLambda1.INSTANCE);
    }
    AppMethodBeat.o(268233);
  }
  
  public final bx.a diu()
  {
    return (bx.a)this.Jbk;
  }
  
  public final void l(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(268242);
    if (paramIOnStorageChange != null) {
      ((PluginGameLife)h.az(PluginGameLife.class)).getContactStorage().remove(paramIOnStorageChange);
    }
    AppMethodBeat.o(268242);
  }
  
  public final void m(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(268237);
    if (paramIOnStorageChange != null) {
      ((PluginGameLife)h.az(PluginGameLife.class)).getContactStorage().add(paramIOnStorageChange);
    }
    AppMethodBeat.o(268237);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/gamelife/contact/GameLifeContactService$contactExtension$1", "Lcom/tencent/mm/storage/IContactStorage$IContactExtension;", "get", "Lcom/tencent/mm/storage/Contact;", "username", "", "onPreInsertContact", "", "stg", "Lcom/tencent/mm/storage/IContactStorage;", "contact", "replace", "", "isUpdate", "", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements bx.a
  {
    b(b paramb) {}
    
    public final au JE(String paramString)
    {
      AppMethodBeat.i(268089);
      Object localObject1 = (CharSequence)paramString;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; (i != 0) || (!au.bwW(paramString)); i = 0)
      {
        AppMethodBeat.o(268089);
        return null;
      }
      localObject1 = ((com.tencent.mm.plugin.gamelife.a.f)h.ax(com.tencent.mm.plugin.gamelife.a.f.class)).aAw(paramString);
      localObject1 = this.Jbl.aHA((String)localObject1);
      if (localObject1 == null) {}
      for (localObject1 = null;; localObject1 = ((a)localObject1).bSb())
      {
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new au();
        }
        ((au)localObject2).setUsername(paramString);
        AppMethodBeat.o(268089);
        return localObject2;
      }
    }
    
    public final void a(bx parambx, au paramau) {}
    
    public final int b(au paramau, boolean paramBoolean)
    {
      AppMethodBeat.i(268077);
      if (paramau == null)
      {
        AppMethodBeat.o(268077);
        return -1;
      }
      if (!au.bwW(paramau.field_username))
      {
        AppMethodBeat.o(268077);
        return -1;
      }
      AppMethodBeat.o(268077);
      return 1;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "resultMap", "", "", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContact;", "remain", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements m<Map<String, ? extends a>, List<? extends String>, ah>
  {
    c(HashMap<String, com.tencent.mm.plugin.gamelife.a.a> paramHashMap, b paramb, com.tencent.mm.plugin.gamelife.a.b.c paramc)
    {
      super();
    }
    
    private static final void a(HashMap paramHashMap, com.tencent.mm.plugin.gamelife.a.b.c paramc, Map paramMap)
    {
      AppMethodBeat.i(268071);
      s.u(paramHashMap, "$result");
      s.u(paramc, "$wrappedCallback");
      paramHashMap.putAll(paramMap);
      paramc.onDone((Map)paramHashMap);
      AppMethodBeat.o(268071);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.e.b
 * JD-Core Version:    0.7.0.1
 */