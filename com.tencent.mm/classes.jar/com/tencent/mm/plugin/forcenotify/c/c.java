package com.tencent.mm.plugin.forcenotify.c;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.forcenotify.d.e;
import com.tencent.mm.plugin.forcenotify.d.f;
import com.tencent.mm.plugin.forcenotify.d.f.a;
import com.tencent.mm.plugin.forcenotify.d.f.c;
import com.tencent.mm.plugin.forcenotify.d.g;
import com.tencent.mm.plugin.forcenotify.ui.ForceNotifyShowUI;
import com.tencent.mm.plugin.forcenotify.ui.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.afx;
import com.tencent.mm.protocal.protobuf.da;
import com.tencent.mm.protocal.protobuf.dgv;
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
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/forcenotify/core/ForceNotifyService;", "Lcom/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService;", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/ILoadingOpLogService$IOplogResult;", "()V", "ForceNotifyLiveTag", "", "ForceNotifyMiniAppTag", "ForceNotifyMsgTag", "isSound", "", "()Z", "setSound", "(Z)V", "isTestError", "isVibrate", "setVibrate", "lastDeletePushId", "Lkotlin/Pair;", "", "delete", "", "forcePushId", "scene", "", "getCount", "getExpireTime", "username", "getForceNotifyInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "getForceNotifyStorage", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "hasError", "isMsgNeedNotify", "isNeedNotify", "isNeedShowBanner", "isNeedShowNotification", "isPhoneLocking", "isSilentMode", "context", "Landroid/content/Context;", "isVibrateMode", "modifyForceNotify", "info", "isAdd", "onOpLogResult", "ret", "oplogErrMsg", "Lcom/tencent/mm/protocal/protobuf/OplogErrMsg;", "option", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IOpLogStorage$Operation;", "onReceiveLiveForcePush", "item", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyLiveItem;", "onReceiveMsgForcePush", "notifyInfo", "parseForcePushId", "content", "release", "setCanSoundAndVibrate", "setForTest", "isTest", "setting", "showNotifyActivity", "force", "showNotifyWindow", "update", "start", "startForceNotifyShowUI", "intent", "Landroid/content/Intent;", "plugin-force-notify_release"})
public final class c
  extends a
  implements h.b
{
  private static boolean BDM;
  private static boolean BDN;
  private static boolean BDO;
  private static o<Long, String> BDP;
  public static final c BDQ;
  
  static
  {
    AppMethodBeat.i(149175);
    BDQ = new c();
    BDN = true;
    BDO = true;
    BDP = new o(Long.valueOf(0L), "");
    AppMethodBeat.o(149175);
  }
  
  public static ArrayList<com.tencent.mm.plugin.forcenotify.d.d> eqg()
  {
    AppMethodBeat.i(149163);
    Object localObject = com.tencent.mm.plugin.forcenotify.e.b.BEa;
    localObject = com.tencent.mm.plugin.forcenotify.e.b.eqm();
    AppMethodBeat.o(149163);
    return localObject;
  }
  
  private static void eqh()
  {
    AppMethodBeat.i(253460);
    b.a locala = com.tencent.mm.plugin.forcenotify.ui.b.BES;
    b.a.eqw().equ();
    AppMethodBeat.o(253460);
  }
  
  private static boolean eqi()
  {
    AppMethodBeat.i(253465);
    Object localObject = MMApplicationContext.getContext().getSystemService("keyguard");
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.app.KeyguardManager");
      AppMethodBeat.o(253465);
      throw ((Throwable)localObject);
    }
    boolean bool = ((KeyguardManager)localObject).inKeyguardRestrictedInputMode();
    AppMethodBeat.o(253465);
    return bool;
  }
  
  public final void a(int paramInt, dgv paramdgv, k.b paramb)
  {
    AppMethodBeat.i(253454);
    p.k(paramb, "option");
    Log.i(this.TAG, "[onOpLogResult] ret:%s %s", new Object[] { Integer.valueOf(paramInt), paramb });
    String str;
    if (paramb.getCmdId() == 213)
    {
      paramdgv = paramb.eSx();
      if (paramdgv == null)
      {
        paramdgv = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AddForcePush");
        AppMethodBeat.o(253454);
        throw paramdgv;
      }
      paramdgv = (da)paramdgv;
      Log.i(this.TAG, "[onOpLogResult] AddForcePush ForcePushId:%s", new Object[] { paramdgv.RIA });
      if ((paramInt == 0) && (!BDM))
      {
        paramb = com.tencent.mm.plugin.forcenotify.e.b.BEa;
        str = paramdgv.RIA;
        p.j(str, "oplog.ForcePushId");
        paramb.dw(str, 1);
        ((com.tencent.mm.plugin.forcenotify.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.forcenotify.a.a.class)).D(paramdgv.RIA, 1, cm.bfD() / 1000L);
        AppMethodBeat.o(253454);
        return;
      }
      paramb = com.tencent.mm.plugin.forcenotify.e.b.BEa;
      str = paramdgv.RIA;
      p.j(str, "oplog.ForcePushId");
      paramb.dw(str, -1);
      ((com.tencent.mm.plugin.forcenotify.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.forcenotify.a.a.class)).D(paramdgv.RIA, 6, cm.bfD() / 1000L);
      AppMethodBeat.o(253454);
      return;
    }
    if (paramb.getCmdId() == 214)
    {
      paramdgv = paramb.eSx();
      if (paramdgv == null)
      {
        paramdgv = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.DelForcePush");
        AppMethodBeat.o(253454);
        throw paramdgv;
      }
      paramdgv = (afx)paramdgv;
      int i = paramdgv.scene;
      boolean bool = false;
      if (paramInt == 0)
      {
        ((com.tencent.mm.plugin.forcenotify.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.forcenotify.a.a.class)).D(paramdgv.RIA, i, cm.bfD() / 1000L);
        paramb = com.tencent.mm.plugin.forcenotify.e.b.BEa;
        str = paramdgv.RIA;
        p.j(str, "oplog.ForcePushId");
        bool = paramb.ho(str);
      }
      Log.i(this.TAG, "[onOpLogResult] DelForcePush id:%s ret:%s isDeleteLocal:%s", new Object[] { paramdgv.RIA, Integer.valueOf(paramInt), Boolean.valueOf(bool) });
    }
    AppMethodBeat.o(253454);
  }
  
  public final void a(com.tencent.mm.plugin.forcenotify.d.d paramd)
  {
    AppMethodBeat.i(253456);
    p.k(paramd, "notifyInfo");
    Object localObject = f.BDU;
    localObject = f.a.eql();
    p.k(paramd, "info");
    if (((f)localObject).BDT.contains(paramd.field_ForcePushId)) {
      Log.i("ForceNotifyItemMgr", "add info failed, historyIdSet contains " + paramd.field_ForcePushId);
    }
    while (eqi())
    {
      rN(false);
      AppMethodBeat.o(253456);
      return;
      switch (paramd.field_Type)
      {
      default: 
        break;
      case 0: 
        com.tencent.mm.plugin.forcenotify.f.b localb = com.tencent.mm.plugin.forcenotify.f.b.BFh;
        com.tencent.mm.plugin.forcenotify.f.b.a(paramd, (kotlin.g.a.b)new f.c((f)localObject));
      }
    }
    eqh();
    AppMethodBeat.o(253456);
  }
  
  public final void a(com.tencent.mm.plugin.forcenotify.d.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(149169);
    p.k(paramd, "info");
    com.tencent.mm.plugin.forcenotify.e.b localb;
    Object localObject;
    boolean bool;
    if (paramBoolean)
    {
      localb = com.tencent.mm.plugin.forcenotify.e.b.BEa;
      p.k(paramd, "info");
      Log.i("MicroMsg.ForceNotifyStorage", "set(" + paramd.field_ForcePushId + ')');
      if (com.tencent.mm.plugin.forcenotify.e.b.lvy.replace("ForceNotifyData", "UserName", paramd.convertTo()) >= 0L)
      {
        localObject = (Map)com.tencent.mm.plugin.forcenotify.e.b.BDZ;
        String str = paramd.field_ForcePushId;
        p.j(str, "info.field_ForcePushId");
        ((Map)localObject).put(str, paramd);
        localb.doNotify();
        bool = true;
      }
    }
    for (;;)
    {
      Log.i(this.TAG, "[onNewXmlReceived] ret:%s isAdd:%s info:%s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), paramd });
      AppMethodBeat.o(149169);
      return;
      bool = false;
      continue;
      BDP = new o(Long.valueOf(cm.bfE()), paramd.field_ForcePushId);
      localb = com.tencent.mm.plugin.forcenotify.e.b.BEa;
      localObject = paramd.field_ForcePushId;
      p.j(localObject, "info.field_ForcePushId");
      bool = localb.ho((String)localObject);
    }
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(253457);
    p.k(paramg, "item");
    f.a locala = f.BDU;
    f.a.eql().a((e)paramg);
    ((ak)com.tencent.mm.kernel.h.ag(ak.class)).tryGetFinderObject(com.tencent.mm.ae.d.Nb(paramg.feedId), paramg.nonceId, 0);
    if (eqi())
    {
      rN(false);
      AppMethodBeat.o(253457);
      return;
    }
    eqh();
    AppMethodBeat.o(253457);
  }
  
  public final void aHn(String paramString)
  {
    AppMethodBeat.i(149165);
    if (paramString == null)
    {
      AppMethodBeat.o(149165);
      return;
    }
    if (!NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext()))
    {
      com.tencent.mm.plugin.forcenotify.e.b.BEa.doNotify();
      AppMethodBeat.o(149165);
      return;
    }
    Object localObject2 = new da();
    ((da)localObject2).RIA = (paramString + "@wxcontact");
    ((da)localObject2).RIB = 10800;
    Object localObject1 = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
    p.j(localObject1, "MMKernel.service<IMessen…engerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.n)localObject1).eRY().b((k.b)new k.a(213, (com.tencent.mm.cd.a)localObject2));
    localObject1 = com.tencent.mm.plugin.forcenotify.e.b.BEa;
    Object localObject3 = ((da)localObject2).RIA;
    p.j(localObject3, "opLog.ForcePushId");
    p.k(paramString, "userName");
    p.k(localObject3, "forcePushId");
    Log.i("MicroMsg.ForceNotifyStorage", "set(" + paramString + ", " + (String)localObject3 + ')');
    localObject2 = new com.tencent.mm.plugin.forcenotify.d.d();
    ((com.tencent.mm.plugin.forcenotify.d.d)localObject2).field_UserName = paramString;
    ((com.tencent.mm.plugin.forcenotify.d.d)localObject2).field_ForcePushId = ((String)localObject3);
    ((com.tencent.mm.plugin.forcenotify.d.d)localObject2).field_CreateTime = cm.bfD();
    ((com.tencent.mm.plugin.forcenotify.d.d)localObject2).field_ExpiredTime = (((com.tencent.mm.plugin.forcenotify.d.d)localObject2).field_CreateTime + 10800000L);
    ((com.tencent.mm.plugin.forcenotify.d.d)localObject2).field_Status = 1;
    if (com.tencent.mm.plugin.forcenotify.e.b.lvy.replace("ForceNotifyData", "UserName", ((com.tencent.mm.plugin.forcenotify.d.d)localObject2).convertTo()) >= 0L)
    {
      localObject3 = (Map)com.tencent.mm.plugin.forcenotify.e.b.BDZ;
      String str = ((com.tencent.mm.plugin.forcenotify.d.d)localObject2).field_ForcePushId;
      p.j(str, "info.field_ForcePushId");
      ((Map)localObject3).put(str, localObject2);
      ((com.tencent.mm.plugin.forcenotify.e.b)localObject1).doNotify();
    }
    for (boolean bool = true;; bool = false)
    {
      Log.i(this.TAG, "[setting] " + paramString + " ret:%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(149165);
      return;
    }
  }
  
  public final boolean aHo(String paramString)
  {
    AppMethodBeat.i(253462);
    p.k(paramString, "username");
    try
    {
      bool = aHs(paramString + "@wxcontact");
      AppMethodBeat.o(253462);
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
  
  public final boolean aHp(String paramString)
  {
    AppMethodBeat.i(253463);
    p.k(paramString, "username");
    paramString = paramString + "@wxcontact";
    if ((aHs(paramString)) || ((p.h((String)BDP.My, paramString)) && (((Number)BDP.Mx).longValue() > 0L) && (cm.bfE() - ((Number)BDP.Mx).longValue() <= 3000L))) {}
    for (int i = 1;; i = 0)
    {
      BDP = new o(Long.valueOf(0L), "");
      if (i != 0) {
        break;
      }
      AppMethodBeat.o(253463);
      return true;
    }
    AppMethodBeat.o(253463);
    return false;
  }
  
  public final String aHq(String paramString)
  {
    AppMethodBeat.i(253464);
    paramString = aHt(paramString);
    if (paramString != null)
    {
      String str = paramString.BDR;
      paramString = str;
      if (str != null) {}
    }
    else
    {
      paramString = "";
    }
    AppMethodBeat.o(253464);
    return paramString;
  }
  
  public final long aHr(String paramString)
  {
    AppMethodBeat.i(149164);
    p.k(paramString, "username");
    com.tencent.mm.plugin.forcenotify.e.b localb = com.tencent.mm.plugin.forcenotify.e.b.BEa;
    paramString = paramString + "@wxcontact";
    p.k(paramString, "forcePushId");
    Log.i("MicroMsg.ForceNotifyStorage", "getExpiredTime(" + paramString + ')');
    com.tencent.mm.plugin.forcenotify.d.d locald = new com.tencent.mm.plugin.forcenotify.d.d();
    locald.field_ForcePushId = paramString;
    if (localb.get((IAutoDBItem)locald, new String[0]))
    {
      long l = locald.field_ExpiredTime;
      AppMethodBeat.o(149164);
      return l;
    }
    AppMethodBeat.o(149164);
    return 0L;
  }
  
  public final boolean aHs(String paramString)
  {
    AppMethodBeat.i(149174);
    p.k(paramString, "forcePushId");
    com.tencent.mm.plugin.forcenotify.e.b localb = com.tencent.mm.plugin.forcenotify.e.b.BEa;
    boolean bool = com.tencent.mm.plugin.forcenotify.e.b.aHs(paramString);
    AppMethodBeat.o(149174);
    return bool;
  }
  
  public final void bk(String paramString, int paramInt)
  {
    AppMethodBeat.i(149166);
    if (paramString == null)
    {
      AppMethodBeat.o(149166);
      return;
    }
    if (!NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext()))
    {
      com.tencent.mm.plugin.forcenotify.e.b.BEa.doNotify();
      AppMethodBeat.o(149166);
      return;
    }
    afx localafx = new afx();
    localafx.RIA = paramString;
    localafx.scene = paramInt;
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
    p.j(locala, "MMKernel.service<IMessen…engerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.n)locala).eRY().b((k.b)new k.a(214, (com.tencent.mm.cd.a)localafx));
    Log.i(this.TAG, "[delete] ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(149166);
  }
  
  public final MAutoStorage<?> eqe()
  {
    return (MAutoStorage)com.tencent.mm.plugin.forcenotify.e.b.BEa;
  }
  
  public final boolean gk(Context paramContext)
  {
    AppMethodBeat.i(149159);
    p.k(paramContext, "context");
    paramContext = paramContext.getSystemService("audio");
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.media.AudioManager");
      AppMethodBeat.o(149159);
      throw paramContext;
    }
    paramContext = (AudioManager)paramContext;
    Log.i(this.TAG, "isSilentMode ringMode=" + paramContext.getRingerMode() + " RING_MODE_NORMAL=2");
    if (paramContext.getRingerMode() != 2)
    {
      AppMethodBeat.o(149159);
      return true;
    }
    AppMethodBeat.o(149159);
    return false;
  }
  
  public final boolean gl(Context paramContext)
  {
    AppMethodBeat.i(149160);
    p.k(paramContext, "context");
    paramContext = paramContext.getSystemService("audio");
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.media.AudioManager");
      AppMethodBeat.o(149160);
      throw paramContext;
    }
    paramContext = (AudioManager)paramContext;
    Log.i(this.TAG, "isVibrateMode ringMode=" + paramContext.getRingerMode() + " RINGER_MODE_SILENT=0");
    if (paramContext.getRingerMode() > 0)
    {
      AppMethodBeat.o(149160);
      return true;
    }
    AppMethodBeat.o(149160);
    return false;
  }
  
  public final void rM(boolean paramBoolean)
  {
    BDM = paramBoolean;
  }
  
  public final void rN(boolean paramBoolean)
  {
    AppMethodBeat.i(253461);
    Object localObject1 = Util.getTopActivityName2(MMApplicationContext.getContext());
    Object localObject2 = ForceNotifyShowUI.class.getSimpleName();
    p.j(localObject2, "ForceNotifyShowUI::class.java.simpleName");
    Log.i(this.TAG, "clazzName:" + (String)localObject2 + " topActivityName:" + (String)localObject1);
    if ((paramBoolean) || ((p.h(localObject2, localObject1) ^ true)))
    {
      Log.i(this.TAG, "showNotifyActivity first show");
      localObject2 = new Intent(MMApplicationContext.getContext(), ForceNotifyShowUI.class);
      ((Intent)localObject2).addFlags(268435456);
      Log.i(this.TAG, "[notifyShow]");
      localObject1 = MMApplicationContext.getContext();
      localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/forcenotify/core/ForceNotifyService", "showNotifyActivity", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/forcenotify/core/ForceNotifyService", "showNotifyActivity", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(253461);
      return;
    }
    Log.i(this.TAG, "showNotifyActivity add to pendingQueue");
    AppMethodBeat.o(253461);
  }
  
  public final void release()
  {
    AppMethodBeat.i(149162);
    super.release();
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
    p.j(locala, "MMKernel.service<IMessen…engerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.n)locala).eRY().b(213, (h.b)this);
    locala = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
    p.j(locala, "MMKernel.service<IMessen…engerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.n)locala).eRY().b(214, (h.b)this);
    AppMethodBeat.o(149162);
  }
  
  public final void start()
  {
    AppMethodBeat.i(149161);
    super.start();
    Object localObject1 = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
    p.j(localObject1, "MMKernel.service<IMessen…engerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.n)localObject1).eRY().a(213, (h.b)this);
    localObject1 = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
    p.j(localObject1, "MMKernel.service<IMessen…engerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.n)localObject1).eRY().a(214, (h.b)this);
    localObject1 = com.tencent.mm.plugin.forcenotify.e.b.BEa;
    Log.i("MicroMsg.ForceNotifyStorage", "deleteGameLife()");
    if (com.tencent.mm.plugin.forcenotify.e.b.lvy.delete("ForceNotifyData", "UserName like ? ", new String[] { "%@gamelifesess" }) >= 0)
    {
      Object localObject3 = (Map)com.tencent.mm.plugin.forcenotify.e.b.BDZ;
      Object localObject2 = (Map)new LinkedHashMap();
      localObject3 = ((Map)localObject3).entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
        String str = ((com.tencent.mm.plugin.forcenotify.d.d)localEntry.getValue()).field_UserName;
        p.j(str, "it.value.field_UserName");
        if (kotlin.n.n.pu(str, "@gamelifesess")) {
          ((Map)localObject2).put(localEntry.getKey(), localEntry.getValue());
        }
      }
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        com.tencent.mm.plugin.forcenotify.e.b.BDZ.remove(((com.tencent.mm.plugin.forcenotify.d.d)((Map.Entry)localObject3).getValue()).field_ForcePushId);
      }
      ((com.tencent.mm.plugin.forcenotify.e.b)localObject1).doNotify();
    }
    AppMethodBeat.o(149161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.c.c
 * JD-Core Version:    0.7.0.1
 */