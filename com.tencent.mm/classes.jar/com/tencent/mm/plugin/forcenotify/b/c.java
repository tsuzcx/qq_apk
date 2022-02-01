package com.tencent.mm.plugin.forcenotify.b;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.forcenotify.ui.ForceNotifyListUI;
import com.tencent.mm.plugin.forcenotify.ui.ForceNotifyShowUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.adl;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import d.g.b.p;
import d.n.n;
import d.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/forcenotify/core/ForceNotifyService;", "Lcom/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService;", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/ILoadingOpLogService$IOplogResult;", "()V", "ForceNotifyMiniAppTag", "", "ForceNotifyTag", "isSound", "", "()Z", "setSound", "(Z)V", "isTestError", "isVibrate", "setVibrate", "delete", "", "forcePushId", "scene", "", "getCount", "getExpireTime", "", "username", "getForceNotifyInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "getForceNotifyStorage", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "hasError", "isNeedNotify", "userName", "isNeedShowBanner", "isSilentMode", "context", "Landroid/content/Context;", "isVibrateMode", "modifyForceNotify", "info", "isAdd", "notifyShow", "onOpLogResult", "ret", "oplogErrMsg", "Lcom/tencent/mm/protocal/protobuf/OplogErrMsg;", "option", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IOpLogStorage$Operation;", "onReceive", "isNeedShow", "release", "setCanSoundAndVibrate", "setForTest", "isTest", "setting", "start", "startForceNotifyShowUI", "intent", "Landroid/content/Intent;", "plugin-force-notify_release"})
public final class c
  extends a
  implements h.a
{
  private static boolean tuI;
  private static boolean tuJ;
  private static boolean tuK;
  public static final c tuL;
  
  static
  {
    AppMethodBeat.i(149175);
    tuL = new c();
    tuJ = true;
    tuK = true;
    AppMethodBeat.o(149175);
  }
  
  public static ArrayList<com.tencent.mm.plugin.forcenotify.c.d> cTf()
  {
    AppMethodBeat.i(149163);
    Object localObject = com.tencent.mm.plugin.forcenotify.d.a.tuN;
    localObject = com.tencent.mm.plugin.forcenotify.d.a.cTh();
    AppMethodBeat.o(149163);
    return localObject;
  }
  
  public static boolean fl(Context paramContext)
  {
    AppMethodBeat.i(149159);
    p.h(paramContext, "context");
    paramContext = paramContext.getSystemService("audio");
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.media.AudioManager");
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
  
  public static boolean fm(Context paramContext)
  {
    AppMethodBeat.i(149160);
    p.h(paramContext, "context");
    paramContext = paramContext.getSystemService("audio");
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.media.AudioManager");
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
  
  public final void a(int paramInt, che paramche, k.b paramb)
  {
    AppMethodBeat.i(209907);
    p.h(paramb, "option");
    ae.i(this.TAG, "[onOpLogResult] ret:%s %s", new Object[] { Integer.valueOf(paramInt), paramb });
    String str;
    if (paramb.getCmdId() == 213)
    {
      paramche = paramb.dpc();
      if (paramche == null)
      {
        paramche = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AddForcePush");
        AppMethodBeat.o(209907);
        throw paramche;
      }
      paramche = (cu)paramche;
      ae.i(this.TAG, "[onOpLogResult] AddForcePush ForcePushId:%s", new Object[] { paramche.FND });
      if ((paramInt == 0) && (!tuI))
      {
        paramb = com.tencent.mm.plugin.forcenotify.d.a.tuN;
        str = paramche.FND;
        p.g(str, "oplog.ForcePushId");
        paramb.cW(str, 1);
        ((com.tencent.mm.plugin.forcenotify.a.a)g.ab(com.tencent.mm.plugin.forcenotify.a.a.class)).D(paramche.FND, 1, ch.aDb() / 1000L);
        AppMethodBeat.o(209907);
        return;
      }
      paramb = com.tencent.mm.plugin.forcenotify.d.a.tuN;
      str = paramche.FND;
      p.g(str, "oplog.ForcePushId");
      paramb.cW(str, -1);
      ((com.tencent.mm.plugin.forcenotify.a.a)g.ab(com.tencent.mm.plugin.forcenotify.a.a.class)).D(paramche.FND, 6, ch.aDb() / 1000L);
      AppMethodBeat.o(209907);
      return;
    }
    if (paramb.getCmdId() == 214)
    {
      paramche = paramb.dpc();
      if (paramche == null)
      {
        paramche = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.DelForcePush");
        AppMethodBeat.o(209907);
        throw paramche;
      }
      paramche = (adl)paramche;
      int i = paramche.scene;
      boolean bool = false;
      if (paramInt == 0)
      {
        ((com.tencent.mm.plugin.forcenotify.a.a)g.ab(com.tencent.mm.plugin.forcenotify.a.a.class)).D(paramche.FND, i, ch.aDb() / 1000L);
        paramb = com.tencent.mm.plugin.forcenotify.d.a.tuN;
        str = paramche.FND;
        p.g(str, "oplog.ForcePushId");
        bool = paramb.Dc(str);
      }
      ae.i(this.TAG, "[onOpLogResult] DelForcePush id:%s ret:%s isDeleteLocal:%s", new Object[] { paramche.FND, Integer.valueOf(paramInt), Boolean.valueOf(bool) });
    }
    AppMethodBeat.o(209907);
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
      locala = com.tencent.mm.plugin.forcenotify.d.a.tuN;
      p.h(paramd, "info");
      if (com.tencent.mm.plugin.forcenotify.d.a.hKK.replace("ForceNotifyData", "UserName", paramd.convertTo()) >= 0L)
      {
        localObject = (Map)com.tencent.mm.plugin.forcenotify.d.a.tuM;
        String str = paramd.field_ForcePushId;
        p.g(str, "info.field_ForcePushId");
        ((Map)localObject).put(str, paramd);
        locala.doNotify();
        bool = true;
      }
    }
    for (;;)
    {
      ae.i(this.TAG, "[onNewXmlReceived] ret:%s isAdd:%s info:%s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), paramd });
      AppMethodBeat.o(149169);
      return;
      bool = false;
      continue;
      locala = com.tencent.mm.plugin.forcenotify.d.a.tuN;
      localObject = paramd.field_ForcePushId;
      p.g(localObject, "info.field_ForcePushId");
      bool = locala.Dc((String)localObject);
    }
  }
  
  public final void aM(String paramString, int paramInt)
  {
    AppMethodBeat.i(149166);
    if (paramString == null)
    {
      AppMethodBeat.o(149166);
      return;
    }
    if (!az.isNetworkConnected(ak.getContext()))
    {
      com.tencent.mm.plugin.forcenotify.d.a.tuN.doNotify();
      AppMethodBeat.o(149166);
      return;
    }
    adl localadl = new adl();
    localadl.FND = paramString;
    localadl.scene = paramInt;
    com.tencent.mm.kernel.c.a locala = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(locala, "MMKernel.service<IMessen…engerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)locala).doD().b((k.b)new k.a(214, (com.tencent.mm.bw.a)localadl));
    ae.i(this.TAG, "[delete] ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(149166);
  }
  
  public final void akv(String paramString)
  {
    AppMethodBeat.i(149165);
    if (paramString == null)
    {
      AppMethodBeat.o(149165);
      return;
    }
    if (!az.isNetworkConnected(ak.getContext()))
    {
      com.tencent.mm.plugin.forcenotify.d.a.tuN.doNotify();
      AppMethodBeat.o(149165);
      return;
    }
    Object localObject2 = new cu();
    ((cu)localObject2).FND = (paramString + "@wxcontact");
    ((cu)localObject2).FNE = 10800;
    Object localObject1 = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject1, "MMKernel.service<IMessen…engerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject1).doD().b((k.b)new k.a(213, (com.tencent.mm.bw.a)localObject2));
    localObject1 = com.tencent.mm.plugin.forcenotify.d.a.tuN;
    Object localObject3 = ((cu)localObject2).FND;
    p.g(localObject3, "opLog.ForcePushId");
    p.h(paramString, "userName");
    p.h(localObject3, "forcePushId");
    localObject2 = new com.tencent.mm.plugin.forcenotify.c.d();
    ((com.tencent.mm.plugin.forcenotify.c.d)localObject2).field_UserName = paramString;
    ((com.tencent.mm.plugin.forcenotify.c.d)localObject2).field_ForcePushId = ((String)localObject3);
    ((com.tencent.mm.plugin.forcenotify.c.d)localObject2).field_CreateTime = ch.aDb();
    ((com.tencent.mm.plugin.forcenotify.c.d)localObject2).field_ExpiredTime = (((com.tencent.mm.plugin.forcenotify.c.d)localObject2).field_CreateTime + 10800000L);
    ((com.tencent.mm.plugin.forcenotify.c.d)localObject2).field_Status = 1;
    if (com.tencent.mm.plugin.forcenotify.d.a.hKK.replace("ForceNotifyData", "UserName", ((com.tencent.mm.plugin.forcenotify.c.d)localObject2).convertTo()) >= 0L)
    {
      localObject3 = (Map)com.tencent.mm.plugin.forcenotify.d.a.tuM;
      String str = ((com.tencent.mm.plugin.forcenotify.c.d)localObject2).field_ForcePushId;
      p.g(str, "info.field_ForcePushId");
      ((Map)localObject3).put(str, localObject2);
      ((com.tencent.mm.plugin.forcenotify.d.a)localObject1).doNotify();
    }
    for (boolean bool = true;; bool = false)
    {
      ae.i(this.TAG, "[setting] " + paramString + " ret:%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(149165);
      return;
    }
  }
  
  public final long akw(String paramString)
  {
    AppMethodBeat.i(149164);
    p.h(paramString, "username");
    com.tencent.mm.plugin.forcenotify.d.a locala = com.tencent.mm.plugin.forcenotify.d.a.tuN;
    paramString = paramString + "@wxcontact";
    p.h(paramString, "forcePushId");
    com.tencent.mm.plugin.forcenotify.c.d locald = new com.tencent.mm.plugin.forcenotify.c.d();
    locald.field_ForcePushId = paramString;
    if (locala.get((com.tencent.mm.sdk.e.c)locald, new String[0]))
    {
      long l = locald.field_ExpiredTime;
      AppMethodBeat.o(149164);
      return l;
    }
    AppMethodBeat.o(149164);
    return 0L;
  }
  
  public final boolean akx(String paramString)
  {
    AppMethodBeat.i(149174);
    p.h(paramString, "userName");
    com.tencent.mm.plugin.forcenotify.d.a locala = com.tencent.mm.plugin.forcenotify.d.a.tuN;
    boolean bool = com.tencent.mm.plugin.forcenotify.d.a.akx(paramString + "@wxcontact");
    AppMethodBeat.o(149174);
    return bool;
  }
  
  public final void akz(String paramString)
  {
    AppMethodBeat.i(149171);
    p.h(paramString, "userName");
    Object localObject1 = new Intent(ak.getContext(), ForceNotifyShowUI.class);
    ((Intent)localObject1).addFlags(268435456);
    ((Intent)localObject1).putExtra("userName", paramString);
    if ((com.tencent.mm.compatible.util.d.lC(28)) || (p.i(Build.VERSION.CODENAME, "Q")))
    {
      ae.i(this.TAG, "[notifyShow] Q!");
      paramString = ak.getContext();
      p.g(paramString, "MMApplicationContext.getContext()");
      Object localObject2 = ak.getContext();
      p.g(localObject2, "MMApplicationContext.getContext()");
      localObject2 = ((Context)localObject2).getResources().getString(2131759602);
      p.g(localObject2, "MMApplicationContext.get…R.string.force_notify_wx)");
      String str1 = ForceNotifyShowUI.class.getCanonicalName();
      p.g(str1, "ForceNotifyShowUI::class.java.canonicalName");
      String str2 = com.tencent.mm.bq.a.abK();
      p.g(str2, "NotificationHelper.getMessageChannelIdUse()");
      com.tencent.mm.util.a.a(paramString, (Intent)localObject1, (String)localObject2, str1, str2);
      AppMethodBeat.o(149171);
      return;
    }
    ae.i(this.TAG, "[notifyShow]");
    paramString = ak.getContext();
    localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
    com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/forcenotify/core/ForceNotifyService", "notifyShow", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/forcenotify/core/ForceNotifyService", "notifyShow", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(149171);
  }
  
  public final void bl(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(149168);
    p.h(paramString, "userName");
    if (paramBoolean) {
      akz(paramString);
    }
    AppMethodBeat.o(149168);
  }
  
  public final boolean cTc()
  {
    AppMethodBeat.i(149172);
    com.tencent.mm.plugin.forcenotify.d.a locala = com.tencent.mm.plugin.forcenotify.d.a.tuN;
    if (com.tencent.mm.plugin.forcenotify.d.a.cTj() > 0)
    {
      AppMethodBeat.o(149172);
      return true;
    }
    AppMethodBeat.o(149172);
    return false;
  }
  
  public final j<?> cTd()
  {
    return (j)com.tencent.mm.plugin.forcenotify.d.a.tuN;
  }
  
  public final void fk(Context paramContext)
  {
    AppMethodBeat.i(149170);
    p.h(paramContext, "context");
    ae.i(this.TAG, "[startForceNotifyShowUI]");
    Object localObject = new Intent(paramContext, ForceNotifyListUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/forcenotify/core/ForceNotifyService", "startForceNotifyShowUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/forcenotify/core/ForceNotifyService", "startForceNotifyShowUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(149170);
  }
  
  public final boolean hasError()
  {
    AppMethodBeat.i(149173);
    com.tencent.mm.plugin.forcenotify.d.a locala = com.tencent.mm.plugin.forcenotify.d.a.tuN;
    if (com.tencent.mm.plugin.forcenotify.d.a.getErrorCount() > 0)
    {
      AppMethodBeat.o(149173);
      return true;
    }
    AppMethodBeat.o(149173);
    return false;
  }
  
  public final void mL(boolean paramBoolean)
  {
    tuI = paramBoolean;
  }
  
  public final void release()
  {
    AppMethodBeat.i(149162);
    super.release();
    com.tencent.mm.kernel.c.a locala = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(locala, "MMKernel.service<IMessen…engerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)locala).doD().b(213, (h.a)this);
    locala = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(locala, "MMKernel.service<IMessen…engerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)locala).doD().b(214, (h.a)this);
    AppMethodBeat.o(149162);
  }
  
  public final void start()
  {
    AppMethodBeat.i(149161);
    super.start();
    Object localObject1 = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject1, "MMKernel.service<IMessen…engerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject1).doD().a(213, (h.a)this);
    localObject1 = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject1, "MMKernel.service<IMessen…engerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject1).doD().a(214, (h.a)this);
    localObject1 = com.tencent.mm.plugin.forcenotify.d.a.tuN;
    if (com.tencent.mm.plugin.forcenotify.d.a.hKK.delete("ForceNotifyData", "UserName like ? ", new String[] { "%@gamelifesess" }) >= 0)
    {
      Object localObject3 = (Map)com.tencent.mm.plugin.forcenotify.d.a.tuM;
      Object localObject2 = (Map)new LinkedHashMap();
      localObject3 = ((Map)localObject3).entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
        String str = ((com.tencent.mm.plugin.forcenotify.c.d)localEntry.getValue()).field_UserName;
        p.g(str, "it.value.field_UserName");
        if (n.nG(str, "@gamelifesess")) {
          ((Map)localObject2).put(localEntry.getKey(), localEntry.getValue());
        }
      }
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        com.tencent.mm.plugin.forcenotify.d.a.tuM.remove(((com.tencent.mm.plugin.forcenotify.c.d)((Map.Entry)localObject3).getValue()).field_ForcePushId);
      }
      ((com.tencent.mm.plugin.forcenotify.d.a)localObject1).doNotify();
    }
    AppMethodBeat.o(149161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.b.c
 * JD-Core Version:    0.7.0.1
 */