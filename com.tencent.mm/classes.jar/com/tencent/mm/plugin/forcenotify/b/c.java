package com.tencent.mm.plugin.forcenotify.b;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.forcenotify.ui.ForceNotifyListUI;
import com.tencent.mm.plugin.forcenotify.ui.ForceNotifyShowUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.adc;
import com.tencent.mm.protocal.protobuf.cgk;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import d.g.b.p;
import d.v;
import java.util.ArrayList;
import java.util.Map;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/forcenotify/core/ForceNotifyService;", "Lcom/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService;", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/ILoadingOpLogService$IOplogResult;", "()V", "ForceNotifyMiniAppTag", "", "ForceNotifyTag", "isSound", "", "()Z", "setSound", "(Z)V", "isTestError", "isVibrate", "setVibrate", "delete", "", "forcePushId", "scene", "", "getCount", "getExpireTime", "", "username", "getForceNotifyInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "getForceNotifyStorage", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "hasError", "isNeedNotify", "userName", "isNeedShowBanner", "isSilentMode", "context", "Landroid/content/Context;", "isVibrateMode", "modifyForceNotify", "info", "isAdd", "notifyShow", "onOpLogResult", "ret", "oplogErrMsg", "Lcom/tencent/mm/protocal/protobuf/OplogErrMsg;", "option", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IOpLogStorage$Operation;", "onReceive", "isNeedShow", "release", "setCanSoundAndVibrate", "setForTest", "isTest", "setting", "start", "startForceNotifyShowUI", "intent", "Landroid/content/Intent;", "plugin-force-notify_release"})
public final class c
  extends a
  implements h.a
{
  private static boolean tjQ;
  private static boolean tjR;
  private static boolean tjS;
  public static final c tjT;
  
  static
  {
    AppMethodBeat.i(149175);
    tjT = new c();
    tjR = true;
    tjS = true;
    AppMethodBeat.o(149175);
  }
  
  public static ArrayList<com.tencent.mm.plugin.forcenotify.c.d> cQA()
  {
    AppMethodBeat.i(149163);
    Object localObject = com.tencent.mm.plugin.forcenotify.d.a.tjV;
    localObject = com.tencent.mm.plugin.forcenotify.d.a.cQC();
    AppMethodBeat.o(149163);
    return localObject;
  }
  
  public static boolean fh(Context paramContext)
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
  
  public static boolean fi(Context paramContext)
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
  
  public final void a(int paramInt, cgk paramcgk, k.b paramb)
  {
    AppMethodBeat.i(216652);
    p.h(paramb, "option");
    ad.i(this.TAG, "[onOpLogResult] ret:%s %s", new Object[] { Integer.valueOf(paramInt), paramb });
    String str;
    if (paramb.getCmdId() == 213)
    {
      paramcgk = paramb.dmd();
      if (paramcgk == null)
      {
        paramcgk = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AddForcePush");
        AppMethodBeat.o(216652);
        throw paramcgk;
      }
      paramcgk = (cu)paramcgk;
      ad.i(this.TAG, "[onOpLogResult] AddForcePush ForcePushId:%s", new Object[] { paramcgk.Fvf });
      if ((paramInt == 0) && (!tjQ))
      {
        paramb = com.tencent.mm.plugin.forcenotify.d.a.tjV;
        str = paramcgk.Fvf;
        p.g(str, "oplog.ForcePushId");
        paramb.cS(str, 1);
        ((com.tencent.mm.plugin.forcenotify.a.a)g.ab(com.tencent.mm.plugin.forcenotify.a.a.class)).E(paramcgk.Fvf, 1, cf.aCL() / 1000L);
        AppMethodBeat.o(216652);
        return;
      }
      paramb = com.tencent.mm.plugin.forcenotify.d.a.tjV;
      str = paramcgk.Fvf;
      p.g(str, "oplog.ForcePushId");
      paramb.cS(str, -1);
      ((com.tencent.mm.plugin.forcenotify.a.a)g.ab(com.tencent.mm.plugin.forcenotify.a.a.class)).E(paramcgk.Fvf, 6, cf.aCL() / 1000L);
      AppMethodBeat.o(216652);
      return;
    }
    if (paramb.getCmdId() == 214)
    {
      paramcgk = paramb.dmd();
      if (paramcgk == null)
      {
        paramcgk = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.DelForcePush");
        AppMethodBeat.o(216652);
        throw paramcgk;
      }
      paramcgk = (adc)paramcgk;
      int i = paramcgk.scene;
      boolean bool = false;
      if (paramInt == 0)
      {
        ((com.tencent.mm.plugin.forcenotify.a.a)g.ab(com.tencent.mm.plugin.forcenotify.a.a.class)).E(paramcgk.Fvf, i, cf.aCL() / 1000L);
        paramb = com.tencent.mm.plugin.forcenotify.d.a.tjV;
        str = paramcgk.Fvf;
        p.g(str, "oplog.ForcePushId");
        bool = paramb.CA(str);
      }
      ad.i(this.TAG, "[onOpLogResult] DelForcePush id:%s ret:%s isDeleteLocal:%s", new Object[] { paramcgk.Fvf, Integer.valueOf(paramInt), Boolean.valueOf(bool) });
    }
    AppMethodBeat.o(216652);
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
      locala = com.tencent.mm.plugin.forcenotify.d.a.tjV;
      p.h(paramd, "info");
      if (com.tencent.mm.plugin.forcenotify.d.a.hHS.replace("ForceNotifyData", "UserName", paramd.convertTo()) >= 0L)
      {
        localObject = (Map)com.tencent.mm.plugin.forcenotify.d.a.tjU;
        String str = paramd.field_ForcePushId;
        p.g(str, "info.field_ForcePushId");
        ((Map)localObject).put(str, paramd);
        locala.doNotify();
        bool = true;
      }
    }
    for (;;)
    {
      ad.i(this.TAG, "[onNewXmlReceived] ret:%s isAdd:%s info:%s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), paramd });
      AppMethodBeat.o(149169);
      return;
      bool = false;
      continue;
      locala = com.tencent.mm.plugin.forcenotify.d.a.tjV;
      localObject = paramd.field_ForcePushId;
      p.g(localObject, "info.field_ForcePushId");
      bool = locala.CA((String)localObject);
    }
  }
  
  public final void aJ(String paramString, int paramInt)
  {
    AppMethodBeat.i(149166);
    if (paramString == null)
    {
      AppMethodBeat.o(149166);
      return;
    }
    if (!ay.isNetworkConnected(aj.getContext()))
    {
      com.tencent.mm.plugin.forcenotify.d.a.tjV.doNotify();
      AppMethodBeat.o(149166);
      return;
    }
    adc localadc = new adc();
    localadc.Fvf = paramString;
    localadc.scene = paramInt;
    com.tencent.mm.kernel.c.a locala = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(locala, "MMKernel.service<IMessen…engerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)locala).dlE().a((k.b)new k.a(214, (com.tencent.mm.bx.a)localadc));
    ad.i(this.TAG, "[delete] ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(149166);
  }
  
  public final void ajB(String paramString)
  {
    AppMethodBeat.i(149171);
    p.h(paramString, "userName");
    Object localObject1 = new Intent(aj.getContext(), ForceNotifyShowUI.class);
    ((Intent)localObject1).addFlags(268435456);
    ((Intent)localObject1).putExtra("userName", paramString);
    if ((com.tencent.mm.compatible.util.d.lA(28)) || (p.i(Build.VERSION.CODENAME, "Q")))
    {
      ad.i(this.TAG, "[notifyShow] Q!");
      paramString = aj.getContext();
      p.g(paramString, "MMApplicationContext.getContext()");
      Object localObject2 = aj.getContext();
      p.g(localObject2, "MMApplicationContext.getContext()");
      localObject2 = ((Context)localObject2).getResources().getString(2131759602);
      p.g(localObject2, "MMApplicationContext.get…R.string.force_notify_wx)");
      String str1 = ForceNotifyShowUI.class.getCanonicalName();
      p.g(str1, "ForceNotifyShowUI::class.java.canonicalName");
      String str2 = com.tencent.mm.br.a.abB();
      p.g(str2, "NotificationHelper.getMessageChannelIdUse()");
      com.tencent.mm.util.a.a(paramString, (Intent)localObject1, (String)localObject2, str1, str2);
      AppMethodBeat.o(149171);
      return;
    }
    ad.i(this.TAG, "[notifyShow]");
    paramString = aj.getContext();
    localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
    com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/plugin/forcenotify/core/ForceNotifyService", "notifyShow", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/forcenotify/core/ForceNotifyService", "notifyShow", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(149171);
  }
  
  public final void ajx(String paramString)
  {
    AppMethodBeat.i(149165);
    if (paramString == null)
    {
      AppMethodBeat.o(149165);
      return;
    }
    if (!ay.isNetworkConnected(aj.getContext()))
    {
      com.tencent.mm.plugin.forcenotify.d.a.tjV.doNotify();
      AppMethodBeat.o(149165);
      return;
    }
    Object localObject2 = new cu();
    ((cu)localObject2).Fvf = (paramString + "@wxcontact");
    ((cu)localObject2).Fvg = 10800;
    Object localObject1 = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject1, "MMKernel.service<IMessen…engerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject1).dlE().a((k.b)new k.a(213, (com.tencent.mm.bx.a)localObject2));
    localObject1 = com.tencent.mm.plugin.forcenotify.d.a.tjV;
    Object localObject3 = ((cu)localObject2).Fvf;
    p.g(localObject3, "opLog.ForcePushId");
    p.h(paramString, "userName");
    p.h(localObject3, "forcePushId");
    localObject2 = new com.tencent.mm.plugin.forcenotify.c.d();
    ((com.tencent.mm.plugin.forcenotify.c.d)localObject2).field_UserName = paramString;
    ((com.tencent.mm.plugin.forcenotify.c.d)localObject2).field_ForcePushId = ((String)localObject3);
    ((com.tencent.mm.plugin.forcenotify.c.d)localObject2).field_CreateTime = cf.aCL();
    ((com.tencent.mm.plugin.forcenotify.c.d)localObject2).field_ExpiredTime = (((com.tencent.mm.plugin.forcenotify.c.d)localObject2).field_CreateTime + 10800000L);
    ((com.tencent.mm.plugin.forcenotify.c.d)localObject2).field_Status = 1;
    if (com.tencent.mm.plugin.forcenotify.d.a.hHS.replace("ForceNotifyData", "UserName", ((com.tencent.mm.plugin.forcenotify.c.d)localObject2).convertTo()) >= 0L)
    {
      localObject3 = (Map)com.tencent.mm.plugin.forcenotify.d.a.tjU;
      String str = ((com.tencent.mm.plugin.forcenotify.c.d)localObject2).field_ForcePushId;
      p.g(str, "info.field_ForcePushId");
      ((Map)localObject3).put(str, localObject2);
      ((com.tencent.mm.plugin.forcenotify.d.a)localObject1).doNotify();
    }
    for (boolean bool = true;; bool = false)
    {
      ad.i(this.TAG, "[setting] " + paramString + " ret:%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(149165);
      return;
    }
  }
  
  public final long ajy(String paramString)
  {
    AppMethodBeat.i(149164);
    p.h(paramString, "username");
    com.tencent.mm.plugin.forcenotify.d.a locala = com.tencent.mm.plugin.forcenotify.d.a.tjV;
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
  
  public final boolean ajz(String paramString)
  {
    AppMethodBeat.i(149174);
    p.h(paramString, "userName");
    com.tencent.mm.plugin.forcenotify.d.a locala = com.tencent.mm.plugin.forcenotify.d.a.tjV;
    boolean bool = com.tencent.mm.plugin.forcenotify.d.a.ajz(paramString + "@wxcontact");
    AppMethodBeat.o(149174);
    return bool;
  }
  
  public final void bi(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(149168);
    p.h(paramString, "userName");
    if (paramBoolean) {
      ajB(paramString);
    }
    AppMethodBeat.o(149168);
  }
  
  public final boolean cQx()
  {
    AppMethodBeat.i(149172);
    com.tencent.mm.plugin.forcenotify.d.a locala = com.tencent.mm.plugin.forcenotify.d.a.tjV;
    if (com.tencent.mm.plugin.forcenotify.d.a.cQE() > 0)
    {
      AppMethodBeat.o(149172);
      return true;
    }
    AppMethodBeat.o(149172);
    return false;
  }
  
  public final j<?> cQy()
  {
    return (j)com.tencent.mm.plugin.forcenotify.d.a.tjV;
  }
  
  public final void fg(Context paramContext)
  {
    AppMethodBeat.i(149170);
    p.h(paramContext, "context");
    ad.i(this.TAG, "[startForceNotifyShowUI]");
    Object localObject = new Intent(paramContext, ForceNotifyListUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/forcenotify/core/ForceNotifyService", "startForceNotifyShowUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/forcenotify/core/ForceNotifyService", "startForceNotifyShowUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(149170);
  }
  
  public final boolean hasError()
  {
    AppMethodBeat.i(149173);
    com.tencent.mm.plugin.forcenotify.d.a locala = com.tencent.mm.plugin.forcenotify.d.a.tjV;
    if (com.tencent.mm.plugin.forcenotify.d.a.getErrorCount() > 0)
    {
      AppMethodBeat.o(149173);
      return true;
    }
    AppMethodBeat.o(149173);
    return false;
  }
  
  public final void mH(boolean paramBoolean)
  {
    tjQ = paramBoolean;
  }
  
  public final void release()
  {
    AppMethodBeat.i(149162);
    super.release();
    com.tencent.mm.kernel.c.a locala = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(locala, "MMKernel.service<IMessen…engerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)locala).dlE().b(213, (h.a)this);
    locala = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(locala, "MMKernel.service<IMessen…engerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)locala).dlE().b(214, (h.a)this);
    AppMethodBeat.o(149162);
  }
  
  public final void start()
  {
    AppMethodBeat.i(149161);
    super.start();
    com.tencent.mm.kernel.c.a locala = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(locala, "MMKernel.service<IMessen…engerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)locala).dlE().a(213, (h.a)this);
    locala = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(locala, "MMKernel.service<IMessen…engerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)locala).dlE().a(214, (h.a)this);
    AppMethodBeat.o(149161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.b.c
 * JD-Core Version:    0.7.0.1
 */