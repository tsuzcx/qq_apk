package com.tencent.mm.plugin.forcenotify.b;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.forcenotify.ui.ForceNotifyListUI;
import com.tencent.mm.plugin.forcenotify.ui.ForceNotifyShowUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.afo;
import com.tencent.mm.protocal.protobuf.cxl;
import com.tencent.mm.protocal.protobuf.dd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/forcenotify/core/ForceNotifyService;", "Lcom/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService;", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/ILoadingOpLogService$IOplogResult;", "()V", "ForceNotifyMiniAppTag", "", "ForceNotifyTag", "isSound", "", "()Z", "setSound", "(Z)V", "isTestError", "isVibrate", "setVibrate", "delete", "", "forcePushId", "scene", "", "getCount", "getExpireTime", "", "username", "getForceNotifyInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "getForceNotifyStorage", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "hasError", "isNeedNotify", "userName", "isNeedShowBanner", "isSilentMode", "context", "Landroid/content/Context;", "isVibrateMode", "modifyForceNotify", "info", "isAdd", "notifyShow", "onOpLogResult", "ret", "oplogErrMsg", "Lcom/tencent/mm/protocal/protobuf/OplogErrMsg;", "option", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IOpLogStorage$Operation;", "onReceive", "isNeedShow", "release", "setCanSoundAndVibrate", "setForTest", "isTest", "setting", "start", "startForceNotifyShowUI", "intent", "Landroid/content/Intent;", "plugin-force-notify_release"})
public final class c
  extends a
  implements h.a
{
  private static boolean wLP;
  private static boolean wLQ;
  private static boolean wLR;
  public static final c wLS;
  
  static
  {
    AppMethodBeat.i(149175);
    wLS = new c();
    wLQ = true;
    wLR = true;
    AppMethodBeat.o(149175);
  }
  
  public static ArrayList<com.tencent.mm.plugin.forcenotify.c.d> dMo()
  {
    AppMethodBeat.i(149163);
    Object localObject = com.tencent.mm.plugin.forcenotify.d.a.wLU;
    localObject = com.tencent.mm.plugin.forcenotify.d.a.dMq();
    AppMethodBeat.o(149163);
    return localObject;
  }
  
  public static boolean fR(Context paramContext)
  {
    AppMethodBeat.i(149159);
    p.h(paramContext, "context");
    paramContext = paramContext.getSystemService("audio");
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.media.AudioManager");
      AppMethodBeat.o(149159);
      throw paramContext;
    }
    if (((AudioManager)paramContext).getRingerMode() != 2)
    {
      AppMethodBeat.o(149159);
      return true;
    }
    AppMethodBeat.o(149159);
    return false;
  }
  
  public static boolean fS(Context paramContext)
  {
    AppMethodBeat.i(149160);
    p.h(paramContext, "context");
    paramContext = paramContext.getSystemService("audio");
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.media.AudioManager");
      AppMethodBeat.o(149160);
      throw paramContext;
    }
    if (((AudioManager)paramContext).getRingerMode() > 0)
    {
      AppMethodBeat.o(149160);
      return true;
    }
    AppMethodBeat.o(149160);
    return false;
  }
  
  public final void a(int paramInt, cxl paramcxl, k.b paramb)
  {
    AppMethodBeat.i(199475);
    p.h(paramb, "option");
    Log.i(this.TAG, "[onOpLogResult] ret:%s %s", new Object[] { Integer.valueOf(paramInt), paramb });
    String str;
    if (paramb.getCmdId() == 213)
    {
      paramcxl = paramb.eiR();
      if (paramcxl == null)
      {
        paramcxl = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AddForcePush");
        AppMethodBeat.o(199475);
        throw paramcxl;
      }
      paramcxl = (dd)paramcxl;
      Log.i(this.TAG, "[onOpLogResult] AddForcePush ForcePushId:%s", new Object[] { paramcxl.KHi });
      if ((paramInt == 0) && (!wLP))
      {
        paramb = com.tencent.mm.plugin.forcenotify.d.a.wLU;
        str = paramcxl.KHi;
        p.g(str, "oplog.ForcePushId");
        paramb.dc(str, 1);
        ((com.tencent.mm.plugin.forcenotify.a.a)g.af(com.tencent.mm.plugin.forcenotify.a.a.class)).C(paramcxl.KHi, 1, cl.aWz() / 1000L);
        AppMethodBeat.o(199475);
        return;
      }
      paramb = com.tencent.mm.plugin.forcenotify.d.a.wLU;
      str = paramcxl.KHi;
      p.g(str, "oplog.ForcePushId");
      paramb.dc(str, -1);
      ((com.tencent.mm.plugin.forcenotify.a.a)g.af(com.tencent.mm.plugin.forcenotify.a.a.class)).C(paramcxl.KHi, 6, cl.aWz() / 1000L);
      AppMethodBeat.o(199475);
      return;
    }
    if (paramb.getCmdId() == 214)
    {
      paramcxl = paramb.eiR();
      if (paramcxl == null)
      {
        paramcxl = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.DelForcePush");
        AppMethodBeat.o(199475);
        throw paramcxl;
      }
      paramcxl = (afo)paramcxl;
      int i = paramcxl.scene;
      boolean bool = false;
      if (paramInt == 0)
      {
        ((com.tencent.mm.plugin.forcenotify.a.a)g.af(com.tencent.mm.plugin.forcenotify.a.a.class)).C(paramcxl.KHi, i, cl.aWz() / 1000L);
        paramb = com.tencent.mm.plugin.forcenotify.d.a.wLU;
        str = paramcxl.KHi;
        p.g(str, "oplog.ForcePushId");
        bool = paramb.gC(str);
      }
      Log.i(this.TAG, "[onOpLogResult] DelForcePush id:%s ret:%s isDeleteLocal:%s", new Object[] { paramcxl.KHi, Integer.valueOf(paramInt), Boolean.valueOf(bool) });
    }
    AppMethodBeat.o(199475);
  }
  
  public final void a(com.tencent.mm.plugin.forcenotify.c.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(149169);
    p.h(paramd, "info");
    com.tencent.mm.plugin.forcenotify.d.a locala;
    Object localObject;
    boolean bool;
    if (paramBoolean)
    {
      locala = com.tencent.mm.plugin.forcenotify.d.a.wLU;
      p.h(paramd, "info");
      if (com.tencent.mm.plugin.forcenotify.d.a.iFy.replace("ForceNotifyData", "UserName", paramd.convertTo()) >= 0L)
      {
        localObject = (Map)com.tencent.mm.plugin.forcenotify.d.a.wLT;
        String str = paramd.field_ForcePushId;
        p.g(str, "info.field_ForcePushId");
        ((Map)localObject).put(str, paramd);
        locala.doNotify();
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
      locala = com.tencent.mm.plugin.forcenotify.d.a.wLU;
      localObject = paramd.field_ForcePushId;
      p.g(localObject, "info.field_ForcePushId");
      bool = locala.gC((String)localObject);
    }
  }
  
  public final void aS(String paramString, int paramInt)
  {
    AppMethodBeat.i(149166);
    if (paramString == null)
    {
      AppMethodBeat.o(149166);
      return;
    }
    if (!NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext()))
    {
      com.tencent.mm.plugin.forcenotify.d.a.wLU.doNotify();
      AppMethodBeat.o(149166);
      return;
    }
    afo localafo = new afo();
    localafo.KHi = paramString;
    localafo.scene = paramInt;
    com.tencent.mm.kernel.c.a locala = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(locala, "MMKernel.service<IMessen…engerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)locala).eis().b((k.b)new k.a(214, (com.tencent.mm.bw.a)localafo));
    Log.i(this.TAG, "[delete] ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(149166);
  }
  
  public final void axA(String paramString)
  {
    AppMethodBeat.i(149165);
    if (paramString == null)
    {
      AppMethodBeat.o(149165);
      return;
    }
    if (!NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext()))
    {
      com.tencent.mm.plugin.forcenotify.d.a.wLU.doNotify();
      AppMethodBeat.o(149165);
      return;
    }
    Object localObject2 = new dd();
    ((dd)localObject2).KHi = (paramString + "@wxcontact");
    ((dd)localObject2).KHj = 10800;
    Object localObject1 = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject1, "MMKernel.service<IMessen…engerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject1).eis().b((k.b)new k.a(213, (com.tencent.mm.bw.a)localObject2));
    localObject1 = com.tencent.mm.plugin.forcenotify.d.a.wLU;
    Object localObject3 = ((dd)localObject2).KHi;
    p.g(localObject3, "opLog.ForcePushId");
    p.h(paramString, "userName");
    p.h(localObject3, "forcePushId");
    localObject2 = new com.tencent.mm.plugin.forcenotify.c.d();
    ((com.tencent.mm.plugin.forcenotify.c.d)localObject2).field_UserName = paramString;
    ((com.tencent.mm.plugin.forcenotify.c.d)localObject2).field_ForcePushId = ((String)localObject3);
    ((com.tencent.mm.plugin.forcenotify.c.d)localObject2).field_CreateTime = cl.aWz();
    ((com.tencent.mm.plugin.forcenotify.c.d)localObject2).field_ExpiredTime = (((com.tencent.mm.plugin.forcenotify.c.d)localObject2).field_CreateTime + 10800000L);
    ((com.tencent.mm.plugin.forcenotify.c.d)localObject2).field_Status = 1;
    if (com.tencent.mm.plugin.forcenotify.d.a.iFy.replace("ForceNotifyData", "UserName", ((com.tencent.mm.plugin.forcenotify.c.d)localObject2).convertTo()) >= 0L)
    {
      localObject3 = (Map)com.tencent.mm.plugin.forcenotify.d.a.wLT;
      String str = ((com.tencent.mm.plugin.forcenotify.c.d)localObject2).field_ForcePushId;
      p.g(str, "info.field_ForcePushId");
      ((Map)localObject3).put(str, localObject2);
      ((com.tencent.mm.plugin.forcenotify.d.a)localObject1).doNotify();
    }
    for (boolean bool = true;; bool = false)
    {
      Log.i(this.TAG, "[setting] " + paramString + " ret:%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(149165);
      return;
    }
  }
  
  public final long axB(String paramString)
  {
    AppMethodBeat.i(149164);
    p.h(paramString, "username");
    com.tencent.mm.plugin.forcenotify.d.a locala = com.tencent.mm.plugin.forcenotify.d.a.wLU;
    paramString = paramString + "@wxcontact";
    p.h(paramString, "forcePushId");
    com.tencent.mm.plugin.forcenotify.c.d locald = new com.tencent.mm.plugin.forcenotify.c.d();
    locald.field_ForcePushId = paramString;
    if (locala.get((IAutoDBItem)locald, new String[0]))
    {
      long l = locald.field_ExpiredTime;
      AppMethodBeat.o(149164);
      return l;
    }
    AppMethodBeat.o(149164);
    return 0L;
  }
  
  public final boolean axC(String paramString)
  {
    AppMethodBeat.i(149174);
    p.h(paramString, "userName");
    com.tencent.mm.plugin.forcenotify.d.a locala = com.tencent.mm.plugin.forcenotify.d.a.wLU;
    boolean bool = com.tencent.mm.plugin.forcenotify.d.a.axC(paramString + "@wxcontact");
    AppMethodBeat.o(149174);
    return bool;
  }
  
  public final void axE(String paramString)
  {
    AppMethodBeat.i(149171);
    p.h(paramString, "userName");
    Object localObject1 = new Intent(MMApplicationContext.getContext(), ForceNotifyShowUI.class);
    ((Intent)localObject1).addFlags(268435456);
    ((Intent)localObject1).putExtra("userName", paramString);
    if ((com.tencent.mm.compatible.util.d.oF(28)) || (p.j(Build.VERSION.CODENAME, "Q")))
    {
      Log.i(this.TAG, "[notifyShow] Q!");
      paramString = MMApplicationContext.getContext();
      p.g(paramString, "MMApplicationContext.getContext()");
      Object localObject2 = MMApplicationContext.getContext();
      p.g(localObject2, "MMApplicationContext.getContext()");
      localObject2 = ((Context)localObject2).getResources().getString(2131760923);
      p.g(localObject2, "MMApplicationContext.get…R.string.force_notify_wx)");
      String str1 = ForceNotifyShowUI.class.getCanonicalName();
      if (str1 == null) {
        p.hyc();
      }
      p.g(str1, "ForceNotifyShowUI::class.java.canonicalName!!");
      String str2 = com.tencent.mm.bq.a.apJ();
      p.g(str2, "NotificationHelper.getMessageChannelIdUse()");
      com.tencent.mm.util.a.a(paramString, (Intent)localObject1, (String)localObject2, str1, str2);
      AppMethodBeat.o(149171);
      return;
    }
    Log.i(this.TAG, "[notifyShow]");
    paramString = MMApplicationContext.getContext();
    localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
    com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/forcenotify/core/ForceNotifyService", "notifyShow", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/forcenotify/core/ForceNotifyService", "notifyShow", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(149171);
  }
  
  public final void bz(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(149168);
    p.h(paramString, "userName");
    if (paramBoolean) {
      axE(paramString);
    }
    AppMethodBeat.o(149168);
  }
  
  public final boolean dMl()
  {
    AppMethodBeat.i(149172);
    com.tencent.mm.plugin.forcenotify.d.a locala = com.tencent.mm.plugin.forcenotify.d.a.wLU;
    if (com.tencent.mm.plugin.forcenotify.d.a.dMs() > 0)
    {
      AppMethodBeat.o(149172);
      return true;
    }
    AppMethodBeat.o(149172);
    return false;
  }
  
  public final MAutoStorage<?> dMm()
  {
    return (MAutoStorage)com.tencent.mm.plugin.forcenotify.d.a.wLU;
  }
  
  public final void fQ(Context paramContext)
  {
    AppMethodBeat.i(149170);
    p.h(paramContext, "context");
    Log.i(this.TAG, "[startForceNotifyShowUI]");
    Object localObject = new Intent(paramContext, ForceNotifyListUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/forcenotify/core/ForceNotifyService", "startForceNotifyShowUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/forcenotify/core/ForceNotifyService", "startForceNotifyShowUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(149170);
  }
  
  public final boolean hasError()
  {
    AppMethodBeat.i(149173);
    com.tencent.mm.plugin.forcenotify.d.a locala = com.tencent.mm.plugin.forcenotify.d.a.wLU;
    if (com.tencent.mm.plugin.forcenotify.d.a.getErrorCount() > 0)
    {
      AppMethodBeat.o(149173);
      return true;
    }
    AppMethodBeat.o(149173);
    return false;
  }
  
  public final void ps(boolean paramBoolean)
  {
    wLP = paramBoolean;
  }
  
  public final void release()
  {
    AppMethodBeat.i(149162);
    super.release();
    com.tencent.mm.kernel.c.a locala = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(locala, "MMKernel.service<IMessen…engerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)locala).eis().b(213, (h.a)this);
    locala = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(locala, "MMKernel.service<IMessen…engerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)locala).eis().b(214, (h.a)this);
    AppMethodBeat.o(149162);
  }
  
  public final void start()
  {
    AppMethodBeat.i(149161);
    super.start();
    Object localObject1 = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject1, "MMKernel.service<IMessen…engerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject1).eis().a(213, (h.a)this);
    localObject1 = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject1, "MMKernel.service<IMessen…engerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject1).eis().a(214, (h.a)this);
    localObject1 = com.tencent.mm.plugin.forcenotify.d.a.wLU;
    if (com.tencent.mm.plugin.forcenotify.d.a.iFy.delete("ForceNotifyData", "UserName like ? ", new String[] { "%@gamelifesess" }) >= 0)
    {
      Object localObject3 = (Map)com.tencent.mm.plugin.forcenotify.d.a.wLT;
      Object localObject2 = (Map)new LinkedHashMap();
      localObject3 = ((Map)localObject3).entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
        String str = ((com.tencent.mm.plugin.forcenotify.c.d)localEntry.getValue()).field_UserName;
        p.g(str, "it.value.field_UserName");
        if (n.K(str, "@gamelifesess", false)) {
          ((Map)localObject2).put(localEntry.getKey(), localEntry.getValue());
        }
      }
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        com.tencent.mm.plugin.forcenotify.d.a.wLT.remove(((com.tencent.mm.plugin.forcenotify.c.d)((Map.Entry)localObject3).getValue()).field_ForcePushId);
      }
      ((com.tencent.mm.plugin.forcenotify.d.a)localObject1).doNotify();
    }
    AppMethodBeat.o(149161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.b.c
 * JD-Core Version:    0.7.0.1
 */