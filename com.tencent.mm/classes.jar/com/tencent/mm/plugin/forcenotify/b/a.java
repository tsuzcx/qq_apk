package com.tencent.mm.plugin.forcenotify.b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.g.a.mi;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.forcenotify.a.b;
import com.tencent.mm.plugin.forcenotify.c.d;
import com.tencent.mm.plugin.messenger.foundation.a.ab;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
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

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService;", "Lcom/tencent/mm/plugin/forcenotify/api/IForceNotifyService;", "Lcom/tencent/mm/sdk/storage/MStorageEx$IOnStorageChange;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "executor", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getExecutor", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "executor$delegate", "Lkotlin/Lazy;", "lastCheckExpireForceNotifyTime", "", "mainExecutor", "manualAuthEventIListener", "com/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService$manualAuthEventIListener$1", "Lcom/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService$manualAuthEventIListener$1;", "notifyList", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "afterSyncDoCmd", "", "addMsg", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "beforeSyncDoCmd", "p0", "getNotifyShowList", "getXmlKey", "p", "isNeedCheckExpire", "", "modifyForceNotify", "info", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "isAdd", "onNewXmlReceived", "map", "", "p2", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "onNotifyChange", "event", "", "stg", "Lcom/tencent/mm/sdk/storage/MStorageEx;", "username", "", "onReceive", "userName", "isNeedNotify", "release", "start", "plugin-force-notify_release"})
public abstract class a
  implements b, MStorageEx.IOnStorageChange
{
  final String TAG = "MicroMsg.ForceNotifyService";
  private long wLC;
  private final f wLD = kotlin.g.ah((kotlin.g.a.a)a.b.wLL);
  private final MMHandler wLE = new MMHandler(Looper.getMainLooper());
  public final ConcurrentLinkedQueue<String> wLF = new ConcurrentLinkedQueue();
  private final c wLG = new c(this);
  
  private static String axD(String paramString)
  {
    return ".sysmsg".concat(String.valueOf(paramString));
  }
  
  private final MMHandler dMn()
  {
    return (MMHandler)this.wLD.getValue();
  }
  
  public abstract void a(d paramd, boolean paramBoolean);
  
  public abstract void bz(String paramString, boolean paramBoolean);
  
  public void onNewXmlReceived(String paramString, Map<String, String> paramMap, final h.a parama)
  {
    p.h(paramMap, "map");
    Log.i(this.TAG, "[onNewXmlReceived] type:%s map:%s", new Object[] { paramString, parama });
    int i;
    if ((p.j(paramString, "NewXmlDelForcePush")) || (p.j(paramString, "NewXmlAddForcePush")))
    {
      parama = new d();
      parama.field_ForcePushId = ((String)paramMap.get(axD(".forcePushId")));
      Log.i(this.TAG, "[onNewXmlReceived] forcePushId:%s", new Object[] { parama.field_ForcePushId });
      parama.field_CreateTime = (Util.safeParseLong((String)paramMap.get(axD(".createTime"))) * 1000L);
      parama.field_ExpiredTime = (Util.safeParseLong((String)paramMap.get(axD(".expiredTime"))) * 1000L);
      parama.field_UserIcon = ((String)paramMap.get(axD(".userIcon")));
      parama.field_UserName = ((String)paramMap.get(axD(".userName")));
      parama.field_Description = ((String)paramMap.get(axD(".description")));
      parama.field_ExtInfo = ((String)paramMap.get(axD(".extInfo")));
      if (cl.aWz() < parama.field_ExpiredTime) {
        break label274;
      }
      i = 1;
      if (i != 1) {
        break label280;
      }
      i = 0;
      label238:
      parama.field_Status = i;
      if (!p.j("NewXmlDelForcePush", paramString)) {
        break label286;
      }
      dMn().post((Runnable)new d(this, parama));
    }
    label274:
    label280:
    label286:
    while (!p.j("NewXmlAddForcePush", paramString))
    {
      return;
      i = 0;
      break;
      i = 1;
      break label238;
    }
    dMn().post((Runnable)new e(this, parama));
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    Object localObject;
    if (((paramObject instanceof String)) && ((paramInt == 5) || (paramInt == 4)))
    {
      paramMStorageEx = (String)paramObject + "@wxcontact";
      localObject = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).aSN().Kn(Util.nullAs((String)paramObject, ""));
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
      } while ((((as)localObject).arv()) && (!((as)localObject).ary()));
      com.tencent.mm.plugin.forcenotify.d.a locala = com.tencent.mm.plugin.forcenotify.d.a.wLU;
      bool = com.tencent.mm.plugin.forcenotify.d.a.axF(((as)localObject).getUsername() + "@wxcontact");
      Log.i(this.TAG, "[onNotifyChange] Delete contact[%s]  %s", new Object[] { paramObject, Boolean.valueOf(bool) });
    } while (!bool);
    if (((as)localObject).ary())
    {
      aS(paramMStorageEx, 9);
      return;
    }
    aS(paramMStorageEx, 7);
  }
  
  public void release()
  {
    this.wLG.dead();
    ab.a((y)this);
    Object localObject = com.tencent.mm.kernel.g.ah(s.class);
    p.g(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)localObject).getSysCmdMsgExtension().b("NewXmlAddForcePush", (q)this);
    localObject = com.tencent.mm.kernel.g.ah(s.class);
    p.g(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)localObject).getSysCmdMsgExtension().b("NewXmlDelForcePush", (q)this);
    localObject = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).aSN().remove((MStorageEx.IOnStorageChange)this);
  }
  
  public void start()
  {
    ab.a(5, (y)this);
    Object localObject = com.tencent.mm.kernel.g.ah(s.class);
    p.g(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)localObject).getSysCmdMsgExtension().a("NewXmlAddForcePush", (q)this);
    localObject = com.tencent.mm.kernel.g.ah(s.class);
    p.g(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)localObject).getSysCmdMsgExtension().a("NewXmlDelForcePush", (q)this);
    this.wLG.alive();
    localObject = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).aSN().add((MStorageEx.IOnStorageChange)this);
    dMn().post((Runnable)f.wLN);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(a parama, de paramde) {}
    
    public final void run()
    {
      final String str = null;
      AppMethodBeat.i(149146);
      if (a.a(this.wLH))
      {
        localObject = com.tencent.mm.plugin.forcenotify.d.a.wLU;
        com.tencent.mm.plugin.forcenotify.d.a.dMt();
      }
      Object localObject = XmlParser.parseXml(this.wLI.KHq, "ForcePushId", null);
      if (localObject != null) {
        str = (String)((Map)localObject).get(".ForcePushId");
      }
      if (str != null)
      {
        Log.i(this.wLH.TAG, "received msg! MsgSource:%s FromUserName:%s source:%s", new Object[] { this.wLI.KHq, this.wLI.KHl, str });
        str = com.tencent.mm.platformtools.z.a(this.wLI.KHl);
        if (((p.j(com.tencent.mm.model.z.aTY(), str) ^ true)) && (!a.b(this.wLH).contains(str)))
        {
          boolean bool = this.wLH.axC(str);
          if (bool)
          {
            Log.i(this.wLH.TAG, "fromUser=" + str + " isNeedNotify=" + bool);
            a.b(this.wLH).add(str);
            a.c(this.wLH).post((Runnable)new Runnable()
            {
              public final void run()
              {
                boolean bool = true;
                AppMethodBeat.i(149145);
                a locala = this.wLJ.wLH;
                String str = str;
                p.g(str, "fromUser");
                if (a.b(this.wLJ.wLH).size() == 1) {}
                for (;;)
                {
                  locala.bz(str, bool);
                  AppMethodBeat.o(149145);
                  return;
                  bool = false;
                }
              }
            });
            AppMethodBeat.o(149146);
            return;
          }
          Log.w(this.wLH.TAG, "ERROR! no show!");
          AppMethodBeat.o(149146);
          return;
        }
        Log.w(this.wLH.TAG, "ERROR! no show! notifyList=" + a.b(this.wLH));
      }
      AppMethodBeat.o(149146);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService$manualAuthEventIListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ManualAuthEvent;", "callback", "", "event", "plugin-force-notify_release"})
  public static final class c
    extends IListener<mi>
  {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(a parama, d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(149150);
      this.wLH.a(parama, false);
      AppMethodBeat.o(149150);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(a parama, d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(149151);
      this.wLH.a(parama, true);
      AppMethodBeat.o(149151);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    public static final f wLN;
    
    static
    {
      AppMethodBeat.i(149153);
      wLN = new f();
      AppMethodBeat.o(149153);
    }
    
    public final void run()
    {
      AppMethodBeat.i(149152);
      com.tencent.mm.plugin.forcenotify.d.a locala = com.tencent.mm.plugin.forcenotify.d.a.wLU;
      com.tencent.mm.plugin.forcenotify.d.a.dMt();
      AppMethodBeat.o(149152);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.b.a
 * JD-Core Version:    0.7.0.1
 */