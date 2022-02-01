package com.tencent.mm.plugin.forcenotify.core;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.forcenotify.c.i;
import com.tencent.mm.plugin.forcenotify.c.i.a;
import com.tencent.mm.plugin.forcenotify.c.i.c;
import com.tencent.mm.plugin.forcenotify.c.j;
import com.tencent.mm.plugin.forcenotify.ui.ForceNotifyShowUI;
import com.tencent.mm.plugin.forcenotify.ui.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.aik;
import com.tencent.mm.protocal.protobuf.dk;
import com.tencent.mm.protocal.protobuf.dzc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/forcenotify/core/ForceNotifyService;", "Lcom/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService;", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/ILoadingOpLogService$IOplogResult;", "()V", "ForceNotifyLiveTag", "", "ForceNotifyMiniAppTag", "ForceNotifyMsgTag", "isSound", "", "()Z", "setSound", "(Z)V", "isTestError", "isVibrate", "setVibrate", "lastDeletePushId", "Lkotlin/Pair;", "", "delete", "", "forcePushId", "scene", "", "getCount", "getExpireTime", "username", "getForceNotifyInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "getForceNotifyStorage", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "hasError", "isMsgNeedNotify", "isNeedNotify", "isNeedShowBanner", "isNeedShowNotification", "isPhoneLocking", "isSilentMode", "context", "Landroid/content/Context;", "isVibrateMode", "modifyForceNotify", "info", "isAdd", "onOpLogResult", "ret", "oplogErrMsg", "Lcom/tencent/mm/protocal/protobuf/OplogErrMsg;", "option", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IOpLogStorage$Operation;", "onReceiveCommonForcePush", "item", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyCommonItem;", "onReceiveLiveForcePush", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyLiveItem;", "onReceiveMsgForcePush", "notifyInfo", "parseForcePushId", "content", "release", "setCanSoundAndVibrate", "setForTest", "isTest", "setting", "showNotifyActivity", "force", "showNotifyWindow", "start", "startForceNotifyShowUI", "intent", "Landroid/content/Intent;", "plugin-force-notify_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends a
  implements h.b
{
  public static final c Hoc;
  private static boolean Hod;
  private static boolean Hoe;
  private static boolean Hof;
  private static r<Long, String> Hog;
  
  static
  {
    AppMethodBeat.i(149175);
    Hoc = new c();
    Hoe = true;
    Hof = true;
    Hog = new r(Long.valueOf(0L), "");
    AppMethodBeat.o(149175);
  }
  
  public static ArrayList<com.tencent.mm.plugin.forcenotify.c.h> fwB()
  {
    AppMethodBeat.i(149163);
    Object localObject = com.tencent.mm.plugin.forcenotify.d.b.Hoz;
    localObject = com.tencent.mm.plugin.forcenotify.d.b.fwO();
    AppMethodBeat.o(149163);
    return localObject;
  }
  
  public static void fwC()
  {
    AppMethodBeat.i(274926);
    Object localObject = i.Hos;
    localObject = i.a.fwN().fwM();
    if (localObject != null)
    {
      b.a locala = com.tencent.mm.plugin.forcenotify.ui.b.HoY;
      b.a.fwZ().c((com.tencent.mm.plugin.forcenotify.c.a)localObject);
      localObject = com.tencent.mm.plugin.forcenotify.ui.b.HoY;
      b.a.fwZ().show();
    }
    AppMethodBeat.o(274926);
  }
  
  public static boolean fwD()
  {
    AppMethodBeat.i(274930);
    Object localObject = MMApplicationContext.getContext().getSystemService("keyguard");
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.app.KeyguardManager");
      AppMethodBeat.o(274930);
      throw ((Throwable)localObject);
    }
    boolean bool = ((KeyguardManager)localObject).inKeyguardRestrictedInputMode();
    AppMethodBeat.o(274930);
    return bool;
  }
  
  public final void a(int paramInt, dzc paramdzc, k.b paramb)
  {
    AppMethodBeat.i(274987);
    s.u(paramb, "option");
    Log.i(this.TAG, "[onOpLogResult] ret:%s %s", new Object[] { Integer.valueOf(paramInt), paramb });
    String str;
    if (paramb.getCmdId() == 213)
    {
      paramdzc = paramb.KRu;
      if (paramdzc == null)
      {
        paramdzc = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AddForcePush");
        AppMethodBeat.o(274987);
        throw paramdzc;
      }
      paramdzc = (dk)paramdzc;
      Log.i(this.TAG, "[onOpLogResult] AddForcePush ForcePushId:%s", new Object[] { paramdzc.YFC });
      if ((paramInt == 0) && (!Hod))
      {
        paramb = com.tencent.mm.plugin.forcenotify.d.b.Hoz;
        str = paramdzc.YFC;
        s.s(str, "oplog.ForcePushId");
        paramb.dX(str, 1);
        ((com.tencent.mm.plugin.forcenotify.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.forcenotify.a.a.class)).E(paramdzc.YFC, 1, com.tencent.mm.model.cn.bDv() / 1000L);
        AppMethodBeat.o(274987);
        return;
      }
      paramb = com.tencent.mm.plugin.forcenotify.d.b.Hoz;
      str = paramdzc.YFC;
      s.s(str, "oplog.ForcePushId");
      paramb.dX(str, -1);
      ((com.tencent.mm.plugin.forcenotify.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.forcenotify.a.a.class)).E(paramdzc.YFC, 6, com.tencent.mm.model.cn.bDv() / 1000L);
      AppMethodBeat.o(274987);
      return;
    }
    if (paramb.getCmdId() == 214)
    {
      paramdzc = paramb.KRu;
      if (paramdzc == null)
      {
        paramdzc = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.DelForcePush");
        AppMethodBeat.o(274987);
        throw paramdzc;
      }
      paramdzc = (aik)paramdzc;
      int i = paramdzc.scene;
      boolean bool = false;
      if (paramInt == 0)
      {
        ((com.tencent.mm.plugin.forcenotify.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.forcenotify.a.a.class)).E(paramdzc.YFC, i, com.tencent.mm.model.cn.bDv() / 1000L);
        paramb = com.tencent.mm.plugin.forcenotify.d.b.Hoz;
        str = paramdzc.YFC;
        s.s(str, "oplog.ForcePushId");
        bool = paramb.iP(str);
      }
      Log.i(this.TAG, "[onOpLogResult] DelForcePush id:%s ret:%s isDeleteLocal:%s", new Object[] { paramdzc.YFC, Integer.valueOf(paramInt), Boolean.valueOf(bool) });
    }
    AppMethodBeat.o(274987);
  }
  
  public final void a(com.tencent.mm.plugin.forcenotify.c.h paramh)
  {
    AppMethodBeat.i(274994);
    s.u(paramh, "notifyInfo");
    Object localObject = i.Hos;
    localObject = i.a.fwN();
    s.u(paramh, "info");
    if (((i)localObject).Hou.contains(paramh.field_ForcePushId)) {
      Log.i("ForceNotifyItemMgr", s.X("add info failed, historyIdSet contains ", paramh.field_ForcePushId));
    }
    while (fwD())
    {
      vL(false);
      AppMethodBeat.o(274994);
      return;
      if (paramh.field_Type == 0)
      {
        com.tencent.mm.plugin.forcenotify.e.b localb = com.tencent.mm.plugin.forcenotify.e.b.HpK;
        com.tencent.mm.plugin.forcenotify.e.b.a(paramh, (kotlin.g.a.b)new i.c((i)localObject));
      }
    }
    fwC();
    AppMethodBeat.o(274994);
  }
  
  public final void a(com.tencent.mm.plugin.forcenotify.c.h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(149169);
    s.u(paramh, "info");
    com.tencent.mm.plugin.forcenotify.d.b localb;
    Object localObject;
    boolean bool;
    if (paramBoolean)
    {
      localb = com.tencent.mm.plugin.forcenotify.d.b.Hoz;
      s.u(paramh, "info");
      Log.i("MicroMsg.ForceNotifyStorage", "set(" + paramh.field_ForcePushId + ')');
      if (com.tencent.mm.plugin.forcenotify.d.b.omV.replace("ForceNotifyData", "UserName", paramh.convertTo()) >= 0L)
      {
        localObject = (Map)com.tencent.mm.plugin.forcenotify.d.b.HoA;
        String str = paramh.field_ForcePushId;
        s.s(str, "info.field_ForcePushId");
        ((Map)localObject).put(str, paramh);
        localb.doNotify();
        bool = true;
      }
    }
    for (;;)
    {
      Log.i(this.TAG, "[onNewXmlReceived] ret:%s isAdd:%s info:%s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), paramh });
      AppMethodBeat.o(149169);
      return;
      bool = false;
      continue;
      Hog = new r(Long.valueOf(com.tencent.mm.model.cn.bDw()), paramh.field_ForcePushId);
      localb = com.tencent.mm.plugin.forcenotify.d.b.Hoz;
      localObject = paramh.field_ForcePushId;
      s.s(localObject, "info.field_ForcePushId");
      bool = localb.iP((String)localObject);
    }
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(274999);
    s.u(paramj, "item");
    i.a locala = i.Hos;
    i.a.fwN().b((com.tencent.mm.plugin.forcenotify.c.a)paramj);
    ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).tryGetFinderObject(d.FK(paramj.feedId), paramj.nonceId, 0);
    if (fwD())
    {
      vL(false);
      AppMethodBeat.o(274999);
      return;
    }
    fwC();
    AppMethodBeat.o(274999);
  }
  
  public final void aDK(String paramString)
  {
    AppMethodBeat.i(149165);
    if (paramString == null)
    {
      AppMethodBeat.o(149165);
      return;
    }
    if (!NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext()))
    {
      com.tencent.mm.plugin.forcenotify.d.b.Hoz.doNotify();
      AppMethodBeat.o(149165);
      return;
    }
    Object localObject1 = new dk();
    ((dk)localObject1).YFC = s.X(paramString, "@wxcontact");
    ((dk)localObject1).YFD = 10800;
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaT().b((k.b)new k.a(213, (com.tencent.mm.bx.a)localObject1));
    com.tencent.mm.plugin.forcenotify.d.b localb = com.tencent.mm.plugin.forcenotify.d.b.Hoz;
    Object localObject2 = ((dk)localObject1).YFC;
    s.s(localObject2, "opLog.ForcePushId");
    s.u(paramString, "userName");
    s.u(localObject2, "forcePushId");
    Log.i("MicroMsg.ForceNotifyStorage", "set(" + paramString + ", " + (String)localObject2 + ')');
    localObject1 = new com.tencent.mm.plugin.forcenotify.c.h();
    ((com.tencent.mm.plugin.forcenotify.c.h)localObject1).field_UserName = paramString;
    ((com.tencent.mm.plugin.forcenotify.c.h)localObject1).field_ForcePushId = ((String)localObject2);
    ((com.tencent.mm.plugin.forcenotify.c.h)localObject1).field_CreateTime = com.tencent.mm.model.cn.bDv();
    ((com.tencent.mm.plugin.forcenotify.c.h)localObject1).field_ExpiredTime = (((com.tencent.mm.plugin.forcenotify.c.h)localObject1).field_CreateTime + 10800000L);
    ((com.tencent.mm.plugin.forcenotify.c.h)localObject1).field_Status = 1;
    if (com.tencent.mm.plugin.forcenotify.d.b.omV.replace("ForceNotifyData", "UserName", ((com.tencent.mm.plugin.forcenotify.c.h)localObject1).convertTo()) >= 0L)
    {
      localObject2 = (Map)com.tencent.mm.plugin.forcenotify.d.b.HoA;
      String str = ((com.tencent.mm.plugin.forcenotify.c.h)localObject1).field_ForcePushId;
      s.s(str, "info.field_ForcePushId");
      ((Map)localObject2).put(str, localObject1);
      localb.doNotify();
    }
    for (boolean bool = true;; bool = false)
    {
      Log.i(this.TAG, "[setting] " + paramString + " ret:%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(149165);
      return;
    }
  }
  
  public final boolean aDL(String paramString)
  {
    AppMethodBeat.i(275022);
    s.u(paramString, "username");
    try
    {
      bool = aDP(s.X(paramString, "@wxcontact"));
      AppMethodBeat.o(275022);
      return bool;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
  }
  
  public final boolean aDM(String paramString)
  {
    AppMethodBeat.i(275026);
    s.u(paramString, "username");
    paramString = s.X(paramString, "@wxcontact");
    if ((aDP(paramString)) || ((s.p(Hog.bsD, paramString)) && (((Number)Hog.bsC).longValue() > 0L) && (com.tencent.mm.model.cn.bDw() - ((Number)Hog.bsC).longValue() <= 3000L))) {}
    for (int i = 1;; i = 0)
    {
      Hog = new r(Long.valueOf(0L), "");
      if (i != 0) {
        break;
      }
      AppMethodBeat.o(275026);
      return true;
    }
    AppMethodBeat.o(275026);
    return false;
  }
  
  public final String aDN(String paramString)
  {
    AppMethodBeat.i(275032);
    paramString = aDQ(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(275032);
      return "";
    }
    paramString = paramString.id;
    if (paramString == null)
    {
      AppMethodBeat.o(275032);
      return "";
    }
    AppMethodBeat.o(275032);
    return paramString;
  }
  
  public final long aDO(String paramString)
  {
    AppMethodBeat.i(149164);
    s.u(paramString, "username");
    com.tencent.mm.plugin.forcenotify.d.b localb = com.tencent.mm.plugin.forcenotify.d.b.Hoz;
    paramString = s.X(paramString, "@wxcontact");
    s.u(paramString, "forcePushId");
    Log.i("MicroMsg.ForceNotifyStorage", "getExpiredTime(" + paramString + ')');
    com.tencent.mm.plugin.forcenotify.c.h localh = new com.tencent.mm.plugin.forcenotify.c.h();
    localh.field_ForcePushId = paramString;
    if (localb.get((IAutoDBItem)localh, new String[0]))
    {
      long l = localh.field_ExpiredTime;
      AppMethodBeat.o(149164);
      return l;
    }
    AppMethodBeat.o(149164);
    return 0L;
  }
  
  public final boolean aDP(String paramString)
  {
    AppMethodBeat.i(149174);
    s.u(paramString, "forcePushId");
    com.tencent.mm.plugin.forcenotify.d.b localb = com.tencent.mm.plugin.forcenotify.d.b.Hoz;
    boolean bool = com.tencent.mm.plugin.forcenotify.d.b.aDP(paramString);
    AppMethodBeat.o(149174);
    return bool;
  }
  
  public final void bB(String paramString, int paramInt)
  {
    AppMethodBeat.i(149166);
    if (paramString == null)
    {
      AppMethodBeat.o(149166);
      return;
    }
    if (!NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext()))
    {
      com.tencent.mm.plugin.forcenotify.d.b.Hoz.doNotify();
      AppMethodBeat.o(149166);
      return;
    }
    aik localaik = new aik();
    localaik.YFC = paramString;
    localaik.scene = paramInt;
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaT().b((k.b)new k.a(214, (com.tencent.mm.bx.a)localaik));
    Log.i(this.TAG, s.X("[delete] ", paramString));
    AppMethodBeat.o(149166);
  }
  
  public final MAutoStorage<?> fwy()
  {
    return (MAutoStorage)com.tencent.mm.plugin.forcenotify.d.b.Hoz;
  }
  
  public final void release()
  {
    AppMethodBeat.i(149162);
    super.release();
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaT().b(213, (h.b)this);
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaT().b(214, (h.b)this);
    AppMethodBeat.o(149162);
  }
  
  public final void start()
  {
    AppMethodBeat.i(149161);
    super.start();
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaT().a(213, (h.b)this);
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaT().a(214, (h.b)this);
    com.tencent.mm.plugin.forcenotify.d.b localb = com.tencent.mm.plugin.forcenotify.d.b.Hoz;
    Log.i("MicroMsg.ForceNotifyStorage", "deleteGameLife()");
    if (com.tencent.mm.plugin.forcenotify.d.b.omV.delete("ForceNotifyData", "UserName like ? ", new String[] { "%@gamelifesess" }) >= 0)
    {
      Object localObject2 = (Map)com.tencent.mm.plugin.forcenotify.d.b.HoA;
      Object localObject1 = (Map)new LinkedHashMap();
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
        String str = ((com.tencent.mm.plugin.forcenotify.c.h)localEntry.getValue()).field_UserName;
        s.s(str, "it.value.field_UserName");
        if (kotlin.n.n.rs(str, "@gamelifesess")) {
          ((Map)localObject1).put(localEntry.getKey(), localEntry.getValue());
        }
      }
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        com.tencent.mm.plugin.forcenotify.d.b.HoA.remove(((com.tencent.mm.plugin.forcenotify.c.h)((Map.Entry)localObject2).getValue()).field_ForcePushId);
      }
      localb.doNotify();
    }
    AppMethodBeat.o(149161);
  }
  
  public final void vK(boolean paramBoolean)
  {
    Hod = paramBoolean;
  }
  
  public final void vL(boolean paramBoolean)
  {
    AppMethodBeat.i(275015);
    Object localObject1 = Util.getTopActivityName2(MMApplicationContext.getContext());
    Object localObject2 = ForceNotifyShowUI.class.getSimpleName();
    Log.i(this.TAG, "clazzName:" + localObject2 + " topActivityName:" + localObject1);
    if ((paramBoolean) || (!s.p(localObject2, localObject1)))
    {
      Log.i(this.TAG, "showNotifyActivity first show");
      localObject2 = new Intent(MMApplicationContext.getContext(), ForceNotifyShowUI.class);
      ((Intent)localObject2).addFlags(268435456);
      Log.i(this.TAG, "[notifyShow]");
      localObject1 = MMApplicationContext.getContext();
      localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/forcenotify/core/ForceNotifyService", "showNotifyActivity", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/forcenotify/core/ForceNotifyService", "showNotifyActivity", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(275015);
      return;
    }
    Log.i(this.TAG, "showNotifyActivity add to pendingQueue");
    AppMethodBeat.o(275015);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.core.c
 * JD-Core Version:    0.7.0.1
 */