package com.tencent.mm.plugin.forcenotify.b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.v;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.forcenotify.a.b;
import com.tencent.mm.plugin.forcenotify.c.d;
import com.tencent.mm.plugin.messenger.foundation.a.ab;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import d.f;
import d.g.b.p;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService;", "Lcom/tencent/mm/plugin/forcenotify/api/IForceNotifyService;", "Lcom/tencent/mm/sdk/storage/MStorageEx$IOnStorageChange;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "executor", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getExecutor", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "executor$delegate", "Lkotlin/Lazy;", "lastCheckExpireForceNotifyTime", "", "mainExecutor", "manualAuthEventIListener", "com/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService$manualAuthEventIListener$1", "Lcom/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService$manualAuthEventIListener$1;", "notifyList", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "afterSyncDoCmd", "", "addMsg", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "beforeSyncDoCmd", "p0", "getNotifyShowList", "getXmlKey", "p", "isNeedCheckExpire", "", "modifyForceNotify", "info", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "isAdd", "onNewXmlReceived", "map", "", "p2", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "onNotifyChange", "event", "", "stg", "Lcom/tencent/mm/sdk/storage/MStorageEx;", "username", "", "onReceive", "userName", "isNeedNotify", "release", "start", "plugin-force-notify_release"})
public abstract class a
  implements b, n.b
{
  final String TAG = "MicroMsg.ForceNotifyService";
  private long tuv;
  private final f tuw = d.g.O((d.g.a.a)a.b.tuE);
  private final aq tux = new aq(Looper.getMainLooper());
  public final ConcurrentLinkedQueue<String> tuy = new ConcurrentLinkedQueue();
  private final a.c tuz = new a.c(this);
  
  private static String aky(String paramString)
  {
    return ".sysmsg".concat(String.valueOf(paramString));
  }
  
  private final aq cTe()
  {
    return (aq)this.tuw.getValue();
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    Object localObject;
    if (((paramObject instanceof String)) && ((paramInt == 5) || (paramInt == 4)))
    {
      paramn = (String)paramObject + "@wxcontact";
      localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).azF().BH(bu.bI((String)paramObject, ""));
      if (localObject != null) {
        break label86;
      }
    }
    label86:
    boolean bool;
    do
    {
      do
      {
        return;
      } while ((((an)localObject).ads()) && (!((an)localObject).adv()));
      com.tencent.mm.plugin.forcenotify.d.a locala = com.tencent.mm.plugin.forcenotify.d.a.tuN;
      bool = com.tencent.mm.plugin.forcenotify.d.a.akA(((an)localObject).getUsername() + "@wxcontact");
      ae.i(this.TAG, "[onNotifyChange] Delete contact[%s]  %s", new Object[] { paramObject, Boolean.valueOf(bool) });
    } while (!bool);
    if (((an)localObject).adv())
    {
      aM(paramn, 9);
      return;
    }
    aM(paramn, 7);
  }
  
  public abstract void a(d paramd, boolean paramBoolean);
  
  public abstract void bl(String paramString, boolean paramBoolean);
  
  public void onNewXmlReceived(String paramString, Map<String, String> paramMap, final e.a parama)
  {
    p.h(paramMap, "map");
    ae.i(this.TAG, "[onNewXmlReceived] type:%s map:%s", new Object[] { paramString, parama });
    int i;
    if ((p.i(paramString, "NewXmlDelForcePush")) || (p.i(paramString, "NewXmlAddForcePush")))
    {
      parama = new d();
      parama.field_ForcePushId = ((String)paramMap.get(aky(".forcePushId")));
      ae.i(this.TAG, "[onNewXmlReceived] forcePushId:%s", new Object[] { parama.field_ForcePushId });
      parama.field_CreateTime = (bu.aSC((String)paramMap.get(aky(".createTime"))) * 1000L);
      parama.field_ExpiredTime = (bu.aSC((String)paramMap.get(aky(".expiredTime"))) * 1000L);
      parama.field_UserIcon = ((String)paramMap.get(aky(".userIcon")));
      parama.field_UserName = ((String)paramMap.get(aky(".userName")));
      parama.field_Description = ((String)paramMap.get(aky(".description")));
      parama.field_ExtInfo = ((String)paramMap.get(aky(".extInfo")));
      if (ch.aDb() < parama.field_ExpiredTime) {
        break label285;
      }
      i = 1;
      if (i != 1) {
        break label291;
      }
      i = 0;
      label248:
      parama.field_Status = i;
      if (!p.i("NewXmlDelForcePush", paramString)) {
        break label297;
      }
      cTe().post((Runnable)new d(this, parama));
    }
    label285:
    label291:
    label297:
    while (!p.i("NewXmlAddForcePush", paramString))
    {
      return;
      i = 0;
      break;
      i = 1;
      break label248;
    }
    cTe().post((Runnable)new e(this, parama));
  }
  
  public void release()
  {
    this.tuz.dead();
    ab.a((y)this);
    Object localObject = com.tencent.mm.kernel.g.ad(s.class);
    p.g(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)localObject).getSysCmdMsgExtension().b("NewXmlAddForcePush", (q)this);
    localObject = com.tencent.mm.kernel.g.ad(s.class);
    p.g(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)localObject).getSysCmdMsgExtension().b("NewXmlDelForcePush", (q)this);
    localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).azF().b((n.b)this);
  }
  
  public void start()
  {
    ab.a(5, (y)this);
    Object localObject = com.tencent.mm.kernel.g.ad(s.class);
    p.g(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)localObject).getSysCmdMsgExtension().a("NewXmlAddForcePush", (q)this);
    localObject = com.tencent.mm.kernel.g.ad(s.class);
    p.g(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)localObject).getSysCmdMsgExtension().a("NewXmlDelForcePush", (q)this);
    this.tuz.alive();
    localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).azF().a((n.b)this);
    cTe().post((Runnable)f.tuG);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(a parama, cv paramcv) {}
    
    public final void run()
    {
      AppMethodBeat.i(149146);
      if (a.a(this.tuA))
      {
        localObject = com.tencent.mm.plugin.forcenotify.d.a.tuN;
        com.tencent.mm.plugin.forcenotify.d.a.cTk();
      }
      Object localObject = bx.M(this.tuB.FNL, "ForcePushId");
      if (localObject != null) {
        localObject = (String)((Map)localObject).get(".ForcePushId");
      }
      while (localObject != null)
      {
        ae.i(this.tuA.TAG, "received msg! MsgSource:%s FromUserName:%s source:%s", new Object[] { this.tuB.FNL, this.tuB.FNG, localObject });
        localObject = z.a(this.tuB.FNG);
        if (((p.i(v.aAC(), localObject) ^ true)) && (!a.b(this.tuA).contains(localObject)))
        {
          boolean bool = this.tuA.akx((String)localObject);
          if (bool)
          {
            ae.i(this.tuA.TAG, "fromUser=" + (String)localObject + " isNeedNotify=" + bool);
            a.b(this.tuA).add(localObject);
            a.c(this.tuA).post((Runnable)new Runnable()
            {
              public final void run()
              {
                boolean bool = true;
                AppMethodBeat.i(149145);
                a locala = this.tuC.tuA;
                String str = this.tuD;
                p.g(str, "fromUser");
                if (a.b(this.tuC.tuA).size() == 1) {}
                for (;;)
                {
                  locala.bl(str, bool);
                  AppMethodBeat.o(149145);
                  return;
                  bool = false;
                }
              }
            });
            AppMethodBeat.o(149146);
            return;
            localObject = null;
          }
          else
          {
            ae.w(this.tuA.TAG, "ERROR! no show!");
            AppMethodBeat.o(149146);
          }
        }
        else
        {
          ae.w(this.tuA.TAG, "ERROR! no show! notifyList=" + a.b(this.tuA));
        }
      }
      AppMethodBeat.o(149146);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(a parama, d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(149150);
      this.tuA.a(parama, false);
      AppMethodBeat.o(149150);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(a parama, d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(149151);
      this.tuA.a(parama, true);
      AppMethodBeat.o(149151);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    public static final f tuG;
    
    static
    {
      AppMethodBeat.i(149153);
      tuG = new f();
      AppMethodBeat.o(149153);
    }
    
    public final void run()
    {
      AppMethodBeat.i(149152);
      com.tencent.mm.plugin.forcenotify.d.a locala = com.tencent.mm.plugin.forcenotify.d.a.tuN;
      com.tencent.mm.plugin.forcenotify.d.a.cTk();
      AppMethodBeat.o(149152);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.b.a
 * JD-Core Version:    0.7.0.1
 */