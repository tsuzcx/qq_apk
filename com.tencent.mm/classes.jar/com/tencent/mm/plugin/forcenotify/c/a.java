package com.tencent.mm.plugin.forcenotify.c;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ck;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.forcenotify.d.d;
import com.tencent.mm.plugin.messenger.foundation.a.ac;
import com.tencent.mm.plugin.messenger.foundation.a.af;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService;", "Lcom/tencent/mm/plugin/forcenotify/api/IForceNotifyService;", "Lcom/tencent/mm/sdk/storage/MStorageEx$IOnStorageChange;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "executor", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getExecutor", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "executor$delegate", "Lkotlin/Lazy;", "lastCheckExpireForceNotifyTime", "", "mainExecutor", "manualAuthEventIListener", "com/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService$manualAuthEventIListener$1", "Lcom/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService$manualAuthEventIListener$1;", "notifyList", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "afterSyncDoCmd", "", "addMsg", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "beforeSyncDoCmd", "p0", "dealWithLiveForcePush", "dealWithMsgForcePush", "getNotifyShowList", "getXmlKey", "p", "isNeedCheckExpire", "", "modifyForceNotify", "info", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "isAdd", "onNewXmlReceived", "map", "", "p2", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "onNotifyChange", "event", "", "stg", "Lcom/tencent/mm/sdk/storage/MStorageEx;", "username", "", "onReceiveLiveForcePush", "item", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyLiveItem;", "onReceiveMsgForcePush", "notifyInfo", "parseLiveForcePushItem", "xml", "release", "start", "plugin-force-notify_release"})
public abstract class a
  implements com.tencent.mm.plugin.forcenotify.a.b, MStorageEx.IOnStorageChange
{
  private final MMHandler BDA = new MMHandler(Looper.getMainLooper());
  private final ConcurrentLinkedQueue<String> BDB = new ConcurrentLinkedQueue();
  private final a.e BDC = new a.e(this);
  private long BDy;
  private final f BDz = kotlin.g.ar((kotlin.g.a.a)a.d.BDI);
  final String TAG = "MicroMsg.ForceNotifyService";
  
  public static com.tencent.mm.plugin.forcenotify.d.g aHt(String paramString)
  {
    paramString = XmlParser.parseXml(paramString, "general_string", null);
    int i;
    if (paramString != null)
    {
      paramString = (String)paramString.get(".general_string");
      if (paramString != null)
      {
        try
        {
          paramString = new JSONObject(paramString);
          str1 = paramString.optString("feed_id");
          str2 = paramString.optString("nonce_id");
          str3 = paramString.optString("live_id");
          paramString = paramString.optString("force_push_info");
          p.j(paramString, "json");
          if (((CharSequence)paramString).length() != 0) {
            break label307;
          }
          i = 1;
        }
        catch (Exception paramString)
        {
          String str1;
          String str2;
          String str3;
          String str4;
          String str5;
          Object localObject;
          return null;
        }
        paramString = new JSONObject(paramString);
        str4 = paramString.optString("forcePushId");
        str5 = paramString.optString("userIcon");
        localObject = paramString.optString("extinfo");
        p.j(localObject, "extInfo");
        if (((CharSequence)localObject).length() != 0) {
          break label318;
        }
        i = 1;
        break label312;
      }
    }
    for (;;)
    {
      localObject = new JSONObject((String)localObject);
      String str6 = ((JSONObject)localObject).optString("auth_icon_url", "");
      String str7 = ((JSONObject)localObject).optString("nickname", "");
      localObject = paramString.optString("subject");
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = "";
      }
      p.j(str4, "forcePushId");
      p.j(str5, "userIcon");
      p.j(str7, "nickname");
      localObject = MMApplicationContext.getContext().getString(com.tencent.mm.plugin.forcenotify.a.h.force_notify_start_finder_live);
      p.j(localObject, "MMApplicationContext.get…notify_start_finder_live)");
      p.j(str1, "feedId");
      p.j(str3, "liveId");
      p.j(str2, "nonceId");
      paramString = new com.tencent.mm.plugin.forcenotify.d.g(str4, str5, str7, (String)localObject, str1, str3, str2, str6, paramString);
      return paramString;
      return null;
      while (i != 0)
      {
        return null;
        label307:
        i = 0;
      }
      break;
      label312:
      while (i != 0)
      {
        return null;
        label318:
        i = 0;
      }
    }
  }
  
  private static String aHu(String paramString)
  {
    return ".sysmsg".concat(String.valueOf(paramString));
  }
  
  private final MMHandler eqf()
  {
    return (MMHandler)this.BDz.getValue();
  }
  
  public abstract void a(d paramd);
  
  public abstract void a(d paramd, boolean paramBoolean);
  
  public abstract void a(com.tencent.mm.plugin.forcenotify.d.g paramg);
  
  public void onNewXmlReceived(String paramString, Map<String, String> paramMap, final h.a parama)
  {
    int j = 1;
    p.k(paramMap, "map");
    Log.i(this.TAG, "[onNewXmlReceived] type:%s map:%s", new Object[] { paramString, parama });
    int i;
    if ((p.h(paramString, "NewXmlDelForcePush")) || (p.h(paramString, "NewXmlAddForcePush")))
    {
      parama = new d();
      parama.field_ForcePushId = ((String)paramMap.get(aHu(".forcePushId")));
      Log.i(this.TAG, "[onNewXmlReceived] forcePushId:%s", new Object[] { parama.field_ForcePushId });
      parama.field_CreateTime = (Util.safeParseLong((String)paramMap.get(aHu(".createTime"))) * 1000L);
      parama.field_ExpiredTime = (Util.safeParseLong((String)paramMap.get(aHu(".expiredTime"))) * 1000L);
      parama.field_UserIcon = ((String)paramMap.get(aHu(".userIcon")));
      parama.field_UserName = ((String)paramMap.get(aHu(".userName")));
      parama.field_Description = ((String)paramMap.get(aHu(".description")));
      parama.field_ExtInfo = ((String)paramMap.get(aHu(".extInfo")));
      if (cm.bfD() < parama.field_ExpiredTime) {
        break label364;
      }
      i = 1;
      if (i != 1) {
        break label370;
      }
      i = 0;
      label251:
      parama.field_Status = i;
      paramMap = parama.field_ForcePushId;
      p.j(paramMap, "info.field_ForcePushId");
      if (kotlin.n.n.pu(paramMap, "@wxcontact")) {
        break label376;
      }
      paramMap = parama.field_ForcePushId;
      p.j(paramMap, "info.field_ForcePushId");
      if (kotlin.n.n.pu(paramMap, "@miniapp")) {
        break label376;
      }
      paramMap = parama.field_ForcePushId;
      p.j(paramMap, "info.field_ForcePushId");
      if (!kotlin.n.n.pu(paramMap, "@finderlive")) {
        break label376;
      }
      i = j;
      label327:
      parama.field_Type = i;
      if (!p.h("NewXmlDelForcePush", paramString)) {
        break label382;
      }
      eqf().post((Runnable)new f(this, parama));
    }
    label364:
    label370:
    label376:
    label382:
    while (!p.h("NewXmlAddForcePush", paramString))
    {
      return;
      i = 0;
      break;
      i = 1;
      break label251;
      i = 0;
      break label327;
    }
    eqf().post((Runnable)new g(this, parama));
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    Object localObject;
    if (((paramObject instanceof String)) && ((paramInt == 5) || (paramInt == 4)))
    {
      paramMStorageEx = (String)paramObject + "@wxcontact";
      localObject = h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
      p.j(localObject, "MMKernel.service(IMessengerStorage::class.java)");
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)localObject).bbL().RG(Util.nullAs((String)paramObject, ""));
      if (localObject != null) {
        break label90;
      }
    }
    label90:
    boolean bool;
    do
    {
      do
      {
        return;
      } while ((((as)localObject).axZ()) && (!((as)localObject).ayc()));
      com.tencent.mm.plugin.forcenotify.e.b localb = com.tencent.mm.plugin.forcenotify.e.b.BEa;
      bool = com.tencent.mm.plugin.forcenotify.e.b.aHw(((as)localObject).getUsername() + "@wxcontact");
      Log.i(this.TAG, "[onNotifyChange] Delete contact[%s]  %s", new Object[] { paramObject, Boolean.valueOf(bool) });
    } while (!bool);
    if (((as)localObject).ayc())
    {
      bk(paramMStorageEx, 9);
      return;
    }
    bk(paramMStorageEx, 7);
  }
  
  public void release()
  {
    this.BDC.dead();
    af.a((ac)this);
    Object localObject = h.ag(v.class);
    p.j(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((v)localObject).getSysCmdMsgExtension().b("NewXmlAddForcePush", (t)this);
    localObject = h.ag(v.class);
    p.j(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((v)localObject).getSysCmdMsgExtension().b("NewXmlDelForcePush", (t)this);
    localObject = h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
    p.j(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.n)localObject).bbL().remove((MStorageEx.IOnStorageChange)this);
  }
  
  public void start()
  {
    af.a(5, (ac)this);
    Object localObject = h.ag(v.class);
    p.j(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((v)localObject).getSysCmdMsgExtension().a("NewXmlAddForcePush", (t)this);
    localObject = h.ag(v.class);
    p.j(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((v)localObject).getSysCmdMsgExtension().a("NewXmlDelForcePush", (t)this);
    this.BDC.alive();
    localObject = h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
    p.j(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.n)localObject).bbL().add((MStorageEx.IOnStorageChange)this);
    eqf().post((Runnable)h.BDK);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(a parama, db paramdb) {}
    
    public final void run()
    {
      AppMethodBeat.i(149146);
      if (a.a(this.BDD))
      {
        com.tencent.mm.plugin.forcenotify.e.b localb = com.tencent.mm.plugin.forcenotify.e.b.BEa;
        com.tencent.mm.plugin.forcenotify.e.b.eqo();
      }
      a.a(this.BDD, this.BDE);
      a.b(this.BDD, this.BDE);
      AppMethodBeat.o(149146);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService$dealWithLiveForcePush$1$1"})
  static final class b
    implements Runnable
  {
    b(com.tencent.mm.plugin.forcenotify.d.g paramg1, a parama, com.tencent.mm.plugin.forcenotify.d.g paramg2) {}
    
    public final void run()
    {
      AppMethodBeat.i(252624);
      this.BDD.a(this.BDF);
      AppMethodBeat.o(252624);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService$dealWithMsgForcePush$1$1"})
  static final class c
    implements Runnable
  {
    c(d paramd, a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(253216);
      this.BDD.a(this.BDH);
      AppMethodBeat.o(253216);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(a parama, d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(149150);
      this.BDD.a(parama, false);
      AppMethodBeat.o(149150);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(a parama, d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(149151);
      this.BDD.a(parama, true);
      AppMethodBeat.o(149151);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    public static final h BDK;
    
    static
    {
      AppMethodBeat.i(149153);
      BDK = new h();
      AppMethodBeat.o(149153);
    }
    
    public final void run()
    {
      AppMethodBeat.i(149152);
      com.tencent.mm.plugin.forcenotify.e.b localb = com.tencent.mm.plugin.forcenotify.e.b.BEa;
      com.tencent.mm.plugin.forcenotify.e.b.eqo();
      AppMethodBeat.o(149152);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.c.a
 * JD-Core Version:    0.7.0.1
 */