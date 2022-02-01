package com.tencent.mm.plugin.forcenotify.b;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.forcenotify.ui.ForceNotifyListUI;
import com.tencent.mm.plugin.forcenotify.ui.ForceNotifyShowUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.aad;
import com.tencent.mm.protocal.protobuf.cr;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.storagebase.h;
import d.l;
import d.n.n;
import d.v;
import java.util.ArrayList;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/forcenotify/core/ForceNotifyService;", "Lcom/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService;", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/ILoadingOpLogService$IOplogResult;", "()V", "ForceNotifyMiniAppTag", "", "ForceNotifyMiniAppUserNameTag", "ForceNotifyTag", "isSound", "", "()Z", "setSound", "(Z)V", "isTestError", "isVibrate", "setVibrate", "delete", "", "forcePushId", "scene", "", "getCount", "getExpireTime", "", "username", "getForceNotifyInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "getForceNotifyStorage", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "hasError", "isNeedNotify", "userName", "isNeedShowBanner", "isSilentMode", "context", "Landroid/content/Context;", "isVibrateMode", "modifyForceNotify", "info", "isAdd", "notifyShow", "onOpLogResult", "ret", "title", "content", "option", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IOpLogStorage$Operation;", "onReceive", "isNeedShow", "release", "setCanSoundAndVibrate", "setForTest", "isTest", "setting", "start", "startForceNotifyShowUI", "intent", "Landroid/content/Intent;", "plugin-force-notify_release"})
public final class c
  extends a
  implements g.a
{
  private static boolean reu;
  private static boolean rev;
  private static boolean rew;
  public static final c rex;
  
  static
  {
    AppMethodBeat.i(149175);
    rex = new c();
    rev = true;
    rew = true;
    AppMethodBeat.o(149175);
  }
  
  public static ArrayList<com.tencent.mm.plugin.forcenotify.c.d> cuZ()
  {
    AppMethodBeat.i(149163);
    Object localObject = com.tencent.mm.plugin.forcenotify.d.a.rez;
    localObject = com.tencent.mm.plugin.forcenotify.d.a.cvb();
    AppMethodBeat.o(149163);
    return localObject;
  }
  
  public static boolean eR(Context paramContext)
  {
    AppMethodBeat.i(149159);
    d.g.b.k.h(paramContext, "context");
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
  
  public static boolean eS(Context paramContext)
  {
    AppMethodBeat.i(149160);
    d.g.b.k.h(paramContext, "context");
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
  
  public final void a(int paramInt, j.b paramb)
  {
    AppMethodBeat.i(149167);
    d.g.b.k.h(paramb, "option");
    ad.i(this.TAG, "[onOpLogResult] ret:%s %s", new Object[] { Integer.valueOf(paramInt), paramb });
    com.tencent.mm.plugin.forcenotify.d.a locala;
    String str;
    if (paramb.getCmdId() == 213)
    {
      paramb = paramb.cPa();
      if (paramb == null)
      {
        paramb = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AddForcePush");
        AppMethodBeat.o(149167);
        throw paramb;
      }
      paramb = (cr)paramb;
      ad.i(this.TAG, "[onOpLogResult] AddForcePush ForcePushId:%s", new Object[] { paramb.Cxu });
      if ((paramInt == 0) && (!reu))
      {
        locala = com.tencent.mm.plugin.forcenotify.d.a.rez;
        str = paramb.Cxu;
        d.g.b.k.g(str, "oplog.ForcePushId");
        locala.cK(str, 1);
        ((com.tencent.mm.plugin.forcenotify.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.forcenotify.a.a.class)).i(paramb.Cxu, 1, ce.asR() / 1000L);
        AppMethodBeat.o(149167);
        return;
      }
      locala = com.tencent.mm.plugin.forcenotify.d.a.rez;
      str = paramb.Cxu;
      d.g.b.k.g(str, "oplog.ForcePushId");
      locala.cK(str, -1);
      ((com.tencent.mm.plugin.forcenotify.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.forcenotify.a.a.class)).i(paramb.Cxu, 6, ce.asR() / 1000L);
      AppMethodBeat.o(149167);
      return;
    }
    if (paramb.getCmdId() == 214)
    {
      paramb = paramb.cPa();
      if (paramb == null)
      {
        paramb = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.DelForcePush");
        AppMethodBeat.o(149167);
        throw paramb;
      }
      paramb = (aad)paramb;
      int i = paramb.scene;
      if (paramInt != 0) {
        break label364;
      }
      ((com.tencent.mm.plugin.forcenotify.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.forcenotify.a.a.class)).i(paramb.Cxu, i, ce.asR() / 1000L);
      locala = com.tencent.mm.plugin.forcenotify.d.a.rez;
      str = paramb.Cxu;
      d.g.b.k.g(str, "oplog.ForcePushId");
    }
    label364:
    for (boolean bool = locala.vv(str);; bool = false)
    {
      ad.i(this.TAG, "[onOpLogResult] DelForcePush id:%s ret:%s isDeleteLocal:%s", new Object[] { paramb.Cxu, Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      AppMethodBeat.o(149167);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.forcenotify.c.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(149169);
    d.g.b.k.h(paramd, "info");
    com.tencent.mm.plugin.forcenotify.d.a locala;
    Object localObject;
    boolean bool;
    if (paramBoolean)
    {
      locala = com.tencent.mm.plugin.forcenotify.d.a.rez;
      d.g.b.k.h(paramd, "info");
      if (com.tencent.mm.plugin.forcenotify.d.a.gPa.replace("ForceNotifyData", "UserName", paramd.convertTo()) >= 0L)
      {
        localObject = (Map)com.tencent.mm.plugin.forcenotify.d.a.rey;
        String str = paramd.field_ForcePushId;
        d.g.b.k.g(str, "info.field_ForcePushId");
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
      locala = com.tencent.mm.plugin.forcenotify.d.a.rez;
      localObject = paramd.field_ForcePushId;
      d.g.b.k.g(localObject, "info.field_ForcePushId");
      bool = locala.vv((String)localObject);
    }
  }
  
  public final void aD(String paramString, int paramInt)
  {
    AppMethodBeat.i(149166);
    if (paramString == null)
    {
      AppMethodBeat.o(149166);
      return;
    }
    if (!ay.isNetworkConnected(aj.getContext()))
    {
      com.tencent.mm.plugin.forcenotify.d.a.rez.doNotify();
      AppMethodBeat.o(149166);
      return;
    }
    aad localaad = new aad();
    localaad.Cxu = paramString;
    localaad.scene = paramInt;
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
    d.g.b.k.g(locala, "MMKernel.service<IMessen…engerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.k)locala).cOC().a((j.b)new j.a(214, (com.tencent.mm.bx.a)localaad));
    ad.i(this.TAG, "[delete] ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(149166);
  }
  
  public final void aX(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(149168);
    d.g.b.k.h(paramString, "userName");
    if (paramBoolean) {
      aal(paramString);
    }
    AppMethodBeat.o(149168);
  }
  
  public final void aah(String paramString)
  {
    AppMethodBeat.i(149165);
    if (paramString == null)
    {
      AppMethodBeat.o(149165);
      return;
    }
    if (!ay.isNetworkConnected(aj.getContext()))
    {
      com.tencent.mm.plugin.forcenotify.d.a.rez.doNotify();
      AppMethodBeat.o(149165);
      return;
    }
    Object localObject2 = new cr();
    ((cr)localObject2).Cxu = (paramString + "@wxcontact");
    ((cr)localObject2).Cxv = 10800;
    Object localObject1 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
    d.g.b.k.g(localObject1, "MMKernel.service<IMessen…engerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject1).cOC().a((j.b)new j.a(213, (com.tencent.mm.bx.a)localObject2));
    localObject1 = com.tencent.mm.plugin.forcenotify.d.a.rez;
    Object localObject3 = ((cr)localObject2).Cxu;
    d.g.b.k.g(localObject3, "opLog.ForcePushId");
    d.g.b.k.h(paramString, "userName");
    d.g.b.k.h(localObject3, "forcePushId");
    localObject2 = new com.tencent.mm.plugin.forcenotify.c.d();
    ((com.tencent.mm.plugin.forcenotify.c.d)localObject2).field_UserName = paramString;
    ((com.tencent.mm.plugin.forcenotify.c.d)localObject2).field_ForcePushId = ((String)localObject3);
    ((com.tencent.mm.plugin.forcenotify.c.d)localObject2).field_CreateTime = ce.asR();
    ((com.tencent.mm.plugin.forcenotify.c.d)localObject2).field_ExpiredTime = (((com.tencent.mm.plugin.forcenotify.c.d)localObject2).field_CreateTime + 10800000L);
    ((com.tencent.mm.plugin.forcenotify.c.d)localObject2).field_Status = 1;
    if (com.tencent.mm.plugin.forcenotify.d.a.gPa.replace("ForceNotifyData", "UserName", ((com.tencent.mm.plugin.forcenotify.c.d)localObject2).convertTo()) >= 0L)
    {
      localObject3 = (Map)com.tencent.mm.plugin.forcenotify.d.a.rey;
      String str = ((com.tencent.mm.plugin.forcenotify.c.d)localObject2).field_ForcePushId;
      d.g.b.k.g(str, "info.field_ForcePushId");
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
  
  public final long aai(String paramString)
  {
    AppMethodBeat.i(149164);
    d.g.b.k.h(paramString, "username");
    com.tencent.mm.plugin.forcenotify.d.a locala = com.tencent.mm.plugin.forcenotify.d.a.rez;
    paramString = paramString + "@wxcontact";
    d.g.b.k.h(paramString, "forcePushId");
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
  
  public final boolean aaj(String paramString)
  {
    AppMethodBeat.i(149174);
    d.g.b.k.h(paramString, "userName");
    if (!n.mB(paramString, "@app"))
    {
      com.tencent.mm.plugin.forcenotify.d.a locala = com.tencent.mm.plugin.forcenotify.d.a.rez;
      if (!com.tencent.mm.plugin.forcenotify.d.a.aaj(paramString + "@wxcontact")) {}
    }
    else
    {
      AppMethodBeat.o(149174);
      return true;
    }
    AppMethodBeat.o(149174);
    return false;
  }
  
  public final void aal(String paramString)
  {
    AppMethodBeat.i(149171);
    d.g.b.k.h(paramString, "userName");
    Object localObject1 = new Intent(aj.getContext(), ForceNotifyShowUI.class);
    ((Intent)localObject1).addFlags(268435456);
    ((Intent)localObject1).putExtra("userName", paramString);
    if ((com.tencent.mm.compatible.util.d.lh(28)) || (d.g.b.k.g(Build.VERSION.CODENAME, "Q")))
    {
      ad.i(this.TAG, "[notifyShow] Q!");
      paramString = aj.getContext();
      d.g.b.k.g(paramString, "MMApplicationContext.getContext()");
      Object localObject2 = aj.getContext();
      d.g.b.k.g(localObject2, "MMApplicationContext.getContext()");
      localObject2 = ((Context)localObject2).getResources().getString(2131759602);
      d.g.b.k.g(localObject2, "MMApplicationContext.get…R.string.force_notify_wx)");
      String str1 = ForceNotifyShowUI.class.getCanonicalName();
      d.g.b.k.g(str1, "ForceNotifyShowUI::class.java.canonicalName");
      String str2 = com.tencent.mm.br.a.Ye();
      d.g.b.k.g(str2, "NotificationHelper.getMessageChannelIdUse()");
      com.tencent.mm.util.a.a(paramString, (Intent)localObject1, (String)localObject2, str1, str2);
      AppMethodBeat.o(149171);
      return;
    }
    ad.i(this.TAG, "[notifyShow]");
    paramString = aj.getContext();
    localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
    com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/plugin/forcenotify/core/ForceNotifyService", "notifyShow", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/forcenotify/core/ForceNotifyService", "notifyShow", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(149171);
  }
  
  public final boolean cuW()
  {
    AppMethodBeat.i(149172);
    com.tencent.mm.plugin.forcenotify.d.a locala = com.tencent.mm.plugin.forcenotify.d.a.rez;
    if (com.tencent.mm.plugin.forcenotify.d.a.cvd() > 0)
    {
      AppMethodBeat.o(149172);
      return true;
    }
    AppMethodBeat.o(149172);
    return false;
  }
  
  public final j<?> cuX()
  {
    return (j)com.tencent.mm.plugin.forcenotify.d.a.rez;
  }
  
  public final void eQ(Context paramContext)
  {
    AppMethodBeat.i(149170);
    d.g.b.k.h(paramContext, "context");
    ad.i(this.TAG, "[startForceNotifyShowUI]");
    Object localObject = new Intent(paramContext, ForceNotifyListUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/forcenotify/core/ForceNotifyService", "startForceNotifyShowUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/forcenotify/core/ForceNotifyService", "startForceNotifyShowUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(149170);
  }
  
  public final boolean hasError()
  {
    AppMethodBeat.i(149173);
    com.tencent.mm.plugin.forcenotify.d.a locala = com.tencent.mm.plugin.forcenotify.d.a.rez;
    if (com.tencent.mm.plugin.forcenotify.d.a.getErrorCount() > 0)
    {
      AppMethodBeat.o(149173);
      return true;
    }
    AppMethodBeat.o(149173);
    return false;
  }
  
  public final void ly(boolean paramBoolean)
  {
    reu = paramBoolean;
  }
  
  public final void release()
  {
    AppMethodBeat.i(149162);
    super.release();
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
    d.g.b.k.g(locala, "MMKernel.service<IMessen…engerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.k)locala).cOC().b(213, (g.a)this);
    locala = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
    d.g.b.k.g(locala, "MMKernel.service<IMessen…engerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.k)locala).cOC().b(214, (g.a)this);
    AppMethodBeat.o(149162);
  }
  
  public final void start()
  {
    AppMethodBeat.i(149161);
    super.start();
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
    d.g.b.k.g(locala, "MMKernel.service<IMessen…engerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.k)locala).cOC().a(213, (g.a)this);
    locala = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
    d.g.b.k.g(locala, "MMKernel.service<IMessen…engerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.k)locala).cOC().a(214, (g.a)this);
    AppMethodBeat.o(149161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.b.c
 * JD-Core Version:    0.7.0.1
 */