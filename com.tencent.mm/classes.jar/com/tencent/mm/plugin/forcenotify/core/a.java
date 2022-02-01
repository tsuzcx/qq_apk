package com.tencent.mm.plugin.forcenotify.core;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.forcenotify.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.ac;
import com.tencent.mm.plugin.messenger.foundation.a.af;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService;", "Lcom/tencent/mm/plugin/forcenotify/api/IForceNotifyService;", "Lcom/tencent/mm/sdk/storage/MStorageEx$IOnStorageChange;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "executor", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getExecutor", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "executor$delegate", "Lkotlin/Lazy;", "lastCheckExpireForceNotifyTime", "", "mainExecutor", "manualAuthEventIListener", "com/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService$manualAuthEventIListener$1", "Lcom/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService$manualAuthEventIListener$1;", "notifyList", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "afterSyncDoCmd", "", "addMsg", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "beforeSyncDoCmd", "p0", "dealWithLiveForcePush", "dealWithMsgForcePush", "getNotifyShowList", "getXmlKey", "p", "isNeedCheckExpire", "", "modifyForceNotify", "info", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "isAdd", "onNewXmlReceived", "map", "", "p2", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "onNotifyChange", "event", "", "stg", "Lcom/tencent/mm/sdk/storage/MStorageEx;", "username", "", "onReceiveCommonForcePush", "item", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyCommonItem;", "onReceiveLiveForcePush", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyLiveItem;", "onReceiveMsgForcePush", "notifyInfo", "parseLiveForcePushItem", "xml", "release", "start", "plugin-force-notify_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
  implements com.tencent.mm.plugin.forcenotify.a.b, MStorageEx.IOnStorageChange
{
  private long HnU;
  private final kotlin.j HnV = k.cm((kotlin.g.a.a)a.HnZ);
  private final MMHandler HnW = new MMHandler(Looper.getMainLooper());
  private final ConcurrentLinkedQueue<String> HnX = new ConcurrentLinkedQueue();
  private final BaseForceNotifyService.manualAuthEventIListener.1 HnY = new BaseForceNotifyService.manualAuthEventIListener.1(this, f.hfK);
  final String TAG = "MicroMsg.ForceNotifyService";
  
  private static final void a(a parama, com.tencent.mm.plugin.forcenotify.c.h paramh)
  {
    s.u(parama, "this$0");
    s.u(paramh, "$it");
    parama.a(paramh);
  }
  
  private static final void a(a parama, com.tencent.mm.plugin.forcenotify.c.j paramj)
  {
    s.u(parama, "this$0");
    s.u(paramj, "$it");
    parama.a(paramj);
  }
  
  private static final void a(a parama, dl paramdl)
  {
    s.u(parama, "this$0");
    s.u(paramdl, "$addMsg");
    int i;
    Object localObject1;
    if (cn.bDv() - parama.HnU > 1800000L)
    {
      i = 1;
      if (i != 0) {
        parama.HnU = cn.bDv();
      }
      if (i != 0)
      {
        localObject1 = com.tencent.mm.plugin.forcenotify.d.b.Hoz;
        com.tencent.mm.plugin.forcenotify.d.b.fwQ();
      }
      localObject1 = XmlParser.parseXml(paramdl.YFJ, "ForcePushId", null);
      if (localObject1 != null) {
        break label241;
      }
      localObject1 = null;
      label68:
      if (localObject1 != null)
      {
        Log.i(parama.TAG, "received msg! MsgSource:%s FromUserName:%s source:%s", new Object[] { paramdl.YFJ, paramdl.YFE, localObject1 });
        Object localObject2 = w.a(paramdl.YFE);
        if ((s.p(z.bAM(), localObject2)) || (parama.HnX.contains(localObject2))) {
          break label270;
        }
        if (!parama.aDP((String)localObject1)) {
          break label257;
        }
        Log.i(parama.TAG, "fromUser=" + localObject2 + " isNeedNotify=true");
        localObject2 = com.tencent.mm.plugin.forcenotify.d.b.Hoz;
        localObject1 = com.tencent.mm.plugin.forcenotify.d.b.aDT((String)localObject1);
        if (localObject1 != null) {
          parama.HnW.post(new a..ExternalSyntheticLambda1(parama, (com.tencent.mm.plugin.forcenotify.c.h)localObject1));
        }
      }
      label204:
      paramdl = aDQ(w.a(paramdl.YFG));
      if (paramdl != null) {
        break label290;
      }
      paramdl = null;
    }
    for (;;)
    {
      if (paramdl == null) {
        Log.w(parama.TAG, "ERROR! no show!");
      }
      return;
      i = 0;
      break;
      label241:
      localObject1 = (String)((Map)localObject1).get(".ForcePushId");
      break label68;
      label257:
      Log.w(parama.TAG, "ERROR! no show!");
      break label204;
      label270:
      Log.w(parama.TAG, s.X("ERROR! no show! notifyList=", parama.HnX));
      break label204;
      label290:
      localObject1 = paramdl.id;
      Log.i(parama.TAG, "receive msg! livePushId:%s", new Object[] { localObject1 });
      if (parama.aDP((String)localObject1))
      {
        paramdl = Boolean.valueOf(parama.HnW.post(new a..ExternalSyntheticLambda3(parama, paramdl)));
      }
      else
      {
        Log.w(parama.TAG, "ERROR! no show!");
        paramdl = ah.aiuX;
      }
    }
  }
  
  public static com.tencent.mm.plugin.forcenotify.c.j aDQ(String paramString)
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
          s.s(paramString, "json");
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
        s.s(localObject, "extInfo");
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
      s.s(str4, "forcePushId");
      s.s(str5, "userIcon");
      s.s(str7, "nickname");
      localObject = MMApplicationContext.getContext().getString(a.h.force_notify_start_finder_live);
      s.s(localObject, "getContext().getString(R…notify_start_finder_live)");
      s.s(str1, "feedId");
      s.s(str3, "liveId");
      s.s(str2, "nonceId");
      paramString = new com.tencent.mm.plugin.forcenotify.c.j(str4, str5, str7, (String)localObject, str1, str3, str2, str6, paramString);
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
  
  private static final void b(a parama, com.tencent.mm.plugin.forcenotify.c.h paramh)
  {
    s.u(parama, "this$0");
    s.u(paramh, "$info");
    parama.a(paramh, false);
  }
  
  private static final void c(a parama, com.tencent.mm.plugin.forcenotify.c.h paramh)
  {
    s.u(parama, "this$0");
    s.u(paramh, "$info");
    parama.a(paramh, true);
  }
  
  private static final void fwA()
  {
    com.tencent.mm.plugin.forcenotify.d.b localb = com.tencent.mm.plugin.forcenotify.d.b.Hoz;
    com.tencent.mm.plugin.forcenotify.d.b.fwQ();
  }
  
  private final MMHandler fwz()
  {
    return (MMHandler)this.HnV.getValue();
  }
  
  public abstract void a(com.tencent.mm.plugin.forcenotify.c.h paramh);
  
  public abstract void a(com.tencent.mm.plugin.forcenotify.c.h paramh, boolean paramBoolean);
  
  public abstract void a(com.tencent.mm.plugin.forcenotify.c.j paramj);
  
  public void onNewXmlReceived(String paramString, Map<String, String> paramMap, g.a parama)
  {
    int j = 1;
    s.u(paramMap, "map");
    Log.i(this.TAG, "[onNewXmlReceived] type:%s map:%s", new Object[] { paramString, parama });
    int i;
    if ((s.p(paramString, "NewXmlDelForcePush")) || (s.p(paramString, "NewXmlAddForcePush")))
    {
      parama = new com.tencent.mm.plugin.forcenotify.c.h();
      parama.field_ForcePushId = ((String)paramMap.get(s.X(".sysmsg", ".forcePushId")));
      Log.i(this.TAG, "[onNewXmlReceived] forcePushId:%s", new Object[] { parama.field_ForcePushId });
      parama.field_CreateTime = (Util.safeParseLong((String)paramMap.get(s.X(".sysmsg", ".createTime"))) * 1000L);
      parama.field_ExpiredTime = (Util.safeParseLong((String)paramMap.get(s.X(".sysmsg", ".expiredTime"))) * 1000L);
      parama.field_UserIcon = ((String)paramMap.get(s.X(".sysmsg", ".userIcon")));
      parama.field_UserName = ((String)paramMap.get(s.X(".sysmsg", ".userName")));
      parama.field_Description = ((String)paramMap.get(s.X(".sysmsg", ".description")));
      parama.field_ExtInfo = ((String)paramMap.get(s.X(".sysmsg", ".extInfo")));
      if (cn.bDv() < parama.field_ExpiredTime) {
        break label382;
      }
      i = 1;
      if (i != 1) {
        break label388;
      }
      i = 0;
      label272:
      parama.field_Status = i;
      paramMap = parama.field_ForcePushId;
      s.s(paramMap, "info.field_ForcePushId");
      if (kotlin.n.n.rs(paramMap, "@wxcontact")) {
        break label394;
      }
      paramMap = parama.field_ForcePushId;
      s.s(paramMap, "info.field_ForcePushId");
      if (kotlin.n.n.rs(paramMap, "@miniapp")) {
        break label394;
      }
      paramMap = parama.field_ForcePushId;
      s.s(paramMap, "info.field_ForcePushId");
      if (!kotlin.n.n.rs(paramMap, "@finderlive")) {
        break label394;
      }
      i = j;
      label348:
      parama.field_Type = i;
      if (!s.p("NewXmlDelForcePush", paramString)) {
        break label400;
      }
      fwz().post(new a..ExternalSyntheticLambda2(this, parama));
    }
    label382:
    while (!s.p("NewXmlAddForcePush", paramString))
    {
      return;
      i = 0;
      break;
      i = 1;
      break label272;
      i = 0;
      break label348;
    }
    label388:
    label394:
    label400:
    fwz().post(new a..ExternalSyntheticLambda0(this, parama));
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    au localau;
    if (((paramObject instanceof String)) && ((paramInt == 5) || (paramInt == 4)))
    {
      paramMStorageEx = s.X((String)paramObject, "@wxcontact");
      localau = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(Util.nullAs((String)paramObject, ""));
      if (localau != null) {
        break label65;
      }
    }
    label65:
    boolean bool;
    do
    {
      do
      {
        return;
      } while ((d.rs(localau.field_type)) && (!localau.aSF()));
      com.tencent.mm.plugin.forcenotify.d.b localb = com.tencent.mm.plugin.forcenotify.d.b.Hoz;
      bool = com.tencent.mm.plugin.forcenotify.d.b.aDS(s.X(localau.field_username, "@wxcontact"));
      Log.i(this.TAG, "[onNotifyChange] Delete contact[%s]  %s", new Object[] { paramObject, Boolean.valueOf(bool) });
    } while (!bool);
    if (localau.aSF())
    {
      bB(paramMStorageEx, 9);
      return;
    }
    bB(paramMStorageEx, 7);
  }
  
  public void release()
  {
    this.HnY.dead();
    af.a((ac)this);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("NewXmlAddForcePush", (t)this);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("NewXmlDelForcePush", (t)this);
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().remove((MStorageEx.IOnStorageChange)this);
  }
  
  public void start()
  {
    af.a(5, (ac)this);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("NewXmlAddForcePush", (t)this);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("NewXmlDelForcePush", (t)this);
    this.HnY.alive();
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().add((MStorageEx.IOnStorageChange)this);
    fwz().post(a..ExternalSyntheticLambda5.INSTANCE);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMHandler;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<MMHandler>
  {
    public static final a HnZ;
    
    static
    {
      AppMethodBeat.i(185651);
      HnZ = new a();
      AppMethodBeat.o(185651);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.core.a
 * JD-Core Version:    0.7.0.1
 */