package com.tencent.mm.plugin.forcenotify.b;

import a.l;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.forcenotify.a.b;
import com.tencent.mm.plugin.forcenotify.c.d;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService;", "Lcom/tencent/mm/plugin/forcenotify/api/IForceNotifyService;", "Lcom/tencent/mm/sdk/storage/MStorageEx$IOnStorageChange;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "executor", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "lastCheckExpireForceNotifyTime", "", "mainExecutor", "manualAuthEventIListener", "com/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService$manualAuthEventIListener$1", "Lcom/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService$manualAuthEventIListener$1;", "notifyList", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "afterSyncDoCmd", "", "addMsg", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "beforeSyncDoCmd", "p0", "getNotifyShowList", "getXmlKey", "p", "isNeedCheckExpire", "", "modifyForceNotify", "info", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "isAdd", "onNewXmlReceived", "map", "", "p2", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "onNotifyChange", "event", "", "stg", "Lcom/tencent/mm/sdk/storage/MStorageEx;", "username", "", "onReceive", "userName", "isNeedNotify", "release", "start", "plugin-force-notify_release"})
public abstract class a
  implements b, n.b
{
  final String TAG = "MicroMsg.ForceNotifyService";
  private long mHe;
  private final ak mHf = new ak(this.TAG);
  private final ak mHg = new ak(Looper.getMainLooper());
  public final ConcurrentLinkedQueue<String> mHh = new ConcurrentLinkedQueue();
  private final a.b mHi = new a.b(this);
  
  private static String Oo(String paramString)
  {
    return ".sysmsg".concat(String.valueOf(paramString));
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    Object localObject;
    if (((paramObject instanceof String)) && ((paramInt == 5) || (paramInt == 4)))
    {
      paramn = (String)paramObject + "@wxcontact";
      localObject = g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class);
      a.f.b.j.p(localObject, "MMKernel.service(IMessengerStorage::class.java)");
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)localObject).YA().arw(bo.bf((String)paramObject, ""));
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
      } while ((((ad)localObject).NT()) && (!((ad)localObject).NW()));
      com.tencent.mm.plugin.forcenotify.d.a locala = com.tencent.mm.plugin.forcenotify.d.a.mHw;
      bool = com.tencent.mm.plugin.forcenotify.d.a.Op(((ad)localObject).getUsername() + "@wxcontact");
      ab.i(this.TAG, "[onNotifyChange] Delete contact[%s]  %s", new Object[] { paramObject, Boolean.valueOf(bool) });
    } while (!bool);
    if (((ad)localObject).NW())
    {
      an(paramn, 9);
      return;
    }
    an(paramn, 7);
  }
  
  public abstract void a(d paramd, boolean paramBoolean);
  
  public abstract void aP(String paramString, boolean paramBoolean);
  
  public void onNewXmlReceived(String paramString, Map<String, String> paramMap, final e.a parama)
  {
    a.f.b.j.q(paramMap, "map");
    ab.i(this.TAG, "[onNewXmlReceived] type:%s map:%s", new Object[] { paramString, parama });
    int i;
    if ((a.f.b.j.e(paramString, "NewXmlDelForcePush")) || (a.f.b.j.e(paramString, "NewXmlAddForcePush")))
    {
      parama = new d();
      parama.field_ForcePushId = ((String)paramMap.get(Oo(".forcePushId")));
      ab.i(this.TAG, "[onNewXmlReceived] forcePushId:%s", new Object[] { parama.field_ForcePushId });
      parama.field_CreateTime = (bo.apW((String)paramMap.get(Oo(".createTime"))) * 1000L);
      parama.field_ExpiredTime = (bo.apW((String)paramMap.get(Oo(".expiredTime"))) * 1000L);
      parama.field_UserIcon = ((String)paramMap.get(Oo(".userIcon")));
      parama.field_UserName = ((String)paramMap.get(Oo(".userName")));
      parama.field_Description = ((String)paramMap.get(Oo(".description")));
      parama.field_ExtInfo = ((String)paramMap.get(Oo(".extInfo")));
      if (cb.abq() < parama.field_ExpiredTime) {
        break label281;
      }
      i = 1;
      if (i != 1) {
        break label287;
      }
      i = 0;
      label245:
      parama.field_Status = i;
      if (!a.f.b.j.e("NewXmlDelForcePush", paramString)) {
        break label293;
      }
      this.mHf.post((Runnable)new c(this, parama));
    }
    label281:
    label287:
    label293:
    while (!a.f.b.j.e("NewXmlAddForcePush", paramString))
    {
      return;
      i = 0;
      break;
      i = 1;
      break label245;
    }
    this.mHf.post((Runnable)new a.d(this, parama));
  }
  
  public void release()
  {
    this.mHi.dead();
    v.a((s)this);
    Object localObject = g.G(p.class);
    a.f.b.j.p(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((p)localObject).getSysCmdMsgExtension().b("NewXmlAddForcePush", (o)this);
    localObject = g.G(p.class);
    a.f.b.j.p(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((p)localObject).getSysCmdMsgExtension().b("NewXmlDelForcePush", (o)this);
    localObject = g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class);
    a.f.b.j.p(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.j)localObject).YA().b((n.b)this);
  }
  
  public void start()
  {
    v.a(5, (s)this);
    Object localObject = g.G(p.class);
    a.f.b.j.p(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((p)localObject).getSysCmdMsgExtension().a("NewXmlAddForcePush", (o)this);
    localObject = g.G(p.class);
    a.f.b.j.p(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((p)localObject).getSysCmdMsgExtension().a("NewXmlDelForcePush", (o)this);
    this.mHi.alive();
    localObject = g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class);
    a.f.b.j.p(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.j)localObject).YA().a((n.b)this);
    this.mHf.post((Runnable)a.e.mHp);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(a parama, d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(140592);
      this.mHj.a(parama, false);
      AppMethodBeat.o(140592);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.b.a
 * JD-Core Version:    0.7.0.1
 */