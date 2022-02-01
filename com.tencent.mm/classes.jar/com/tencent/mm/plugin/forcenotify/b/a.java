package com.tencent.mm.plugin.forcenotify.b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.g.a.li;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.forcenotify.a.b;
import com.tencent.mm.plugin.forcenotify.c.d;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import d.f;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService;", "Lcom/tencent/mm/plugin/forcenotify/api/IForceNotifyService;", "Lcom/tencent/mm/sdk/storage/MStorageEx$IOnStorageChange;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "executor", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getExecutor", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "executor$delegate", "Lkotlin/Lazy;", "lastCheckExpireForceNotifyTime", "", "mainExecutor", "manualAuthEventIListener", "com/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService$manualAuthEventIListener$1", "Lcom/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService$manualAuthEventIListener$1;", "notifyList", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "afterSyncDoCmd", "", "addMsg", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "beforeSyncDoCmd", "p0", "getNotifyShowList", "getXmlKey", "p", "isNeedCheckExpire", "", "modifyForceNotify", "info", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "isAdd", "onNewXmlReceived", "map", "", "p2", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "onNotifyChange", "event", "", "stg", "Lcom/tencent/mm/sdk/storage/MStorageEx;", "username", "", "onReceive", "userName", "isNeedNotify", "release", "start", "plugin-force-notify_release"})
public abstract class a
  implements b, n.b
{
  final String TAG = "MicroMsg.ForceNotifyService";
  private long smZ;
  private final f sna = d.g.K((d.g.a.a)b.sni);
  private final ao snb = new ao(Looper.getMainLooper());
  public final ConcurrentLinkedQueue<String> snc = new ConcurrentLinkedQueue();
  private final c snd = new c(this);
  
  private static String afc(String paramString)
  {
    return ".sysmsg".concat(String.valueOf(paramString));
  }
  
  private final ao cIk()
  {
    return (ao)this.sna.getValue();
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    Object localObject;
    if (((paramObject instanceof String)) && ((paramInt == 5) || (paramInt == 4)))
    {
      paramn = (String)paramObject + "@wxcontact";
      localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
      d.g.b.k.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject).awB().aNt(bs.bG((String)paramObject, ""));
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
      } while ((((ai)localObject).aaE()) && (!((ai)localObject).aaH()));
      com.tencent.mm.plugin.forcenotify.d.a locala = com.tencent.mm.plugin.forcenotify.d.a.snr;
      bool = com.tencent.mm.plugin.forcenotify.d.a.afe(((ai)localObject).getUsername() + "@wxcontact");
      ac.i(this.TAG, "[onNotifyChange] Delete contact[%s]  %s", new Object[] { paramObject, Boolean.valueOf(bool) });
    } while (!bool);
    if (((ai)localObject).aaH())
    {
      aH(paramn, 9);
      return;
    }
    aH(paramn, 7);
  }
  
  public abstract void a(d paramd, boolean paramBoolean);
  
  public abstract void bd(String paramString, boolean paramBoolean);
  
  public void onNewXmlReceived(String paramString, Map<String, String> paramMap, final f.a parama)
  {
    d.g.b.k.h(paramMap, "map");
    ac.i(this.TAG, "[onNewXmlReceived] type:%s map:%s", new Object[] { paramString, parama });
    int i;
    if ((d.g.b.k.g(paramString, "NewXmlDelForcePush")) || (d.g.b.k.g(paramString, "NewXmlAddForcePush")))
    {
      parama = new d();
      parama.field_ForcePushId = ((String)paramMap.get(afc(".forcePushId")));
      ac.i(this.TAG, "[onNewXmlReceived] forcePushId:%s", new Object[] { parama.field_ForcePushId });
      parama.field_CreateTime = (bs.aLz((String)paramMap.get(afc(".createTime"))) * 1000L);
      parama.field_ExpiredTime = (bs.aLz((String)paramMap.get(afc(".expiredTime"))) * 1000L);
      parama.field_UserIcon = ((String)paramMap.get(afc(".userIcon")));
      parama.field_UserName = ((String)paramMap.get(afc(".userName")));
      parama.field_Description = ((String)paramMap.get(afc(".description")));
      parama.field_ExtInfo = ((String)paramMap.get(afc(".extInfo")));
      if (ce.azI() < parama.field_ExpiredTime) {
        break label285;
      }
      i = 1;
      if (i != 1) {
        break label291;
      }
      i = 0;
      label248:
      parama.field_Status = i;
      if (!d.g.b.k.g("NewXmlDelForcePush", paramString)) {
        break label297;
      }
      cIk().post((Runnable)new d(this, parama));
    }
    label285:
    label291:
    label297:
    while (!d.g.b.k.g("NewXmlAddForcePush", paramString))
    {
      return;
      i = 0;
      break;
      i = 1;
      break label248;
    }
    cIk().post((Runnable)new e(this, parama));
  }
  
  public void release()
  {
    this.snd.dead();
    y.a((v)this);
    Object localObject = com.tencent.mm.kernel.g.ad(q.class);
    d.g.b.k.g(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((q)localObject).getSysCmdMsgExtension().b("NewXmlAddForcePush", (p)this);
    localObject = com.tencent.mm.kernel.g.ad(q.class);
    d.g.b.k.g(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((q)localObject).getSysCmdMsgExtension().b("NewXmlDelForcePush", (p)this);
    localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
    d.g.b.k.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject).awB().b((n.b)this);
  }
  
  public void start()
  {
    y.a(5, (v)this);
    Object localObject = com.tencent.mm.kernel.g.ad(q.class);
    d.g.b.k.g(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((q)localObject).getSysCmdMsgExtension().a("NewXmlAddForcePush", (p)this);
    localObject = com.tencent.mm.kernel.g.ad(q.class);
    d.g.b.k.g(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((q)localObject).getSysCmdMsgExtension().a("NewXmlDelForcePush", (p)this);
    this.snd.alive();
    localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
    d.g.b.k.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject).awB().a((n.b)this);
    cIk().post((Runnable)f.snk);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(a parama, cu paramcu) {}
    
    public final void run()
    {
      AppMethodBeat.i(149146);
      if (a.a(this.sne))
      {
        localObject = com.tencent.mm.plugin.forcenotify.d.a.snr;
        com.tencent.mm.plugin.forcenotify.d.a.cIq();
      }
      Object localObject = bv.L(this.snf.DPY, "ForcePushId");
      if (localObject != null) {
        localObject = (String)((Map)localObject).get(".ForcePushId");
      }
      while (localObject != null)
      {
        ac.i(this.sne.TAG, "received msg! MsgSource:%s FromUserName:%s source:%s", new Object[] { this.snf.DPY, this.snf.DPT, localObject });
        localObject = z.a(this.snf.DPT);
        if (((d.g.b.k.g(u.axw(), localObject) ^ true)) && (!a.b(this.sne).contains(localObject)))
        {
          boolean bool = this.sne.afb((String)localObject);
          if (bool)
          {
            ac.i(this.sne.TAG, "fromUser=" + (String)localObject + " isNeedNotify=" + bool);
            a.b(this.sne).add(localObject);
            a.c(this.sne).post((Runnable)new Runnable()
            {
              public final void run()
              {
                boolean bool = true;
                AppMethodBeat.i(149145);
                a locala = this.sng.sne;
                String str = this.snh;
                d.g.b.k.g(str, "fromUser");
                if (a.b(this.sng.sne).size() == 1) {}
                for (;;)
                {
                  locala.bd(str, bool);
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
            ac.w(this.sne.TAG, "ERROR! no show!");
            AppMethodBeat.o(149146);
          }
        }
        else
        {
          ac.w(this.sne.TAG, "ERROR! no show! notifyList=" + a.b(this.sne));
        }
      }
      AppMethodBeat.o(149146);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<ao>
  {
    public static final b sni;
    
    static
    {
      AppMethodBeat.i(185651);
      sni = new b();
      AppMethodBeat.o(185651);
    }
    
    b()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService$manualAuthEventIListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ManualAuthEvent;", "callback", "", "event", "plugin-force-notify_release"})
  public static final class c
    extends c<li>
  {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(a parama, d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(149150);
      this.sne.a(parama, false);
      AppMethodBeat.o(149150);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(a parama, d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(149151);
      this.sne.a(parama, true);
      AppMethodBeat.o(149151);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    public static final f snk;
    
    static
    {
      AppMethodBeat.i(149153);
      snk = new f();
      AppMethodBeat.o(149153);
    }
    
    public final void run()
    {
      AppMethodBeat.i(149152);
      com.tencent.mm.plugin.forcenotify.d.a locala = com.tencent.mm.plugin.forcenotify.d.a.snr;
      com.tencent.mm.plugin.forcenotify.d.a.cIq();
      AppMethodBeat.o(149152);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.b.a
 * JD-Core Version:    0.7.0.1
 */