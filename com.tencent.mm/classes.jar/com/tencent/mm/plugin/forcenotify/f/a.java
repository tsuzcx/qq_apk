package com.tencent.mm.plugin.forcenotify.f;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.plugin.forcenotify.a.h;
import com.tencent.mm.plugin.forcenotify.ui.ForceNotifyAcceptUI;
import com.tencent.mm.plugin.forcenotify.ui.ForceNotifyAcceptUI.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.s;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/forcenotify/util/ForceNotifyPermissionUtil;", "", "()V", "TAG", "", "TYPE_CHAT", "", "TYPE_LIVE", "checkPermission", "", "context", "Landroid/content/Context;", "type", "dialogNewTask", "", "callback", "Lcom/tencent/mm/plugin/forcenotify/util/ForceNotifyPermissionUtil$IPermissionCallback;", "getWordingByType", "Lkotlin/Pair;", "isPermissionGranted", "IPermissionCallback", "plugin-force-notify_release"})
public final class a
{
  public static final a BFf;
  
  static
  {
    AppMethodBeat.i(253037);
    BFf = new a();
    AppMethodBeat.o(253037);
  }
  
  public static void a(final Context paramContext, int paramInt, a parama)
  {
    AppMethodBeat.i(253035);
    p.k(paramContext, "context");
    p.k(parama, "callback");
    if (b.ct(paramContext))
    {
      Log.w("MicroMsg.ForceNotifyPermissionUtil", "checkPermission already granted");
      parama.ep(true);
      AppMethodBeat.o(253035);
      return;
    }
    Object localObject1 = null;
    if (paramInt == 2) {
      localObject1 = ar.a.VEd;
    }
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.forcenotify.e.a.BDY;
      int i = com.tencent.mm.plugin.forcenotify.e.a.h((ar.a)localObject1);
      if (i > 0)
      {
        parama.ep(false);
        AppMethodBeat.o(253035);
        return;
      }
      localObject2 = com.tencent.mm.plugin.forcenotify.e.a.BDY;
      com.tencent.mm.plugin.forcenotify.e.a.d((ar.a)localObject1, i + 1);
    }
    localObject1 = new b(parama, paramContext);
    switch (paramInt)
    {
    default: 
      parama = s.M(paramContext.getString(a.h.force_notify_window_permission_title_chat), paramContext.getString(a.h.force_notify_window_permission_content_chat));
    }
    for (;;)
    {
      localObject2 = (String)parama.Mx;
      parama = (String)parama.My;
      Object localObject3 = ForceNotifyAcceptUI.BEf;
      localObject3 = (ForceNotifyAcceptUI.b)localObject1;
      localObject1 = com.tencent.mm.bx.a.awc();
      p.j(localObject1, "NotificationHelper.getMessageChannelIdUse()");
      p.k(paramContext, "context");
      p.k(localObject2, "title");
      p.k(parama, "warningContent");
      p.k(localObject3, "resultCallBack");
      p.k(localObject1, "channel");
      ForceNotifyAcceptUI.a((ForceNotifyAcceptUI.b)localObject3);
      localObject3 = new Intent(paramContext, ForceNotifyAcceptUI.class);
      ((Intent)localObject3).putExtra("title", (String)localObject2);
      ((Intent)localObject3).putExtra("warning_content", parama);
      localObject2 = ForceNotifyAcceptUI.class.getCanonicalName();
      if (localObject2 == null) {
        p.iCn();
      }
      p.j(localObject2, "ForceNotifyAcceptUI::class.java.canonicalName!!");
      com.tencent.mm.util.a.a(paramContext, (Intent)localObject3, parama, (String)localObject2, (String)localObject1);
      AppMethodBeat.o(253035);
      return;
      parama = s.M(paramContext.getString(a.h.force_notify_window_permission_title_chat), paramContext.getString(a.h.force_notify_window_permission_content_chat));
      continue;
      parama = s.M(paramContext.getString(a.h.force_notify_window_permission_title_live), paramContext.getString(a.h.force_notify_window_permission_content_live));
    }
  }
  
  public static boolean gm(Context paramContext)
  {
    AppMethodBeat.i(253032);
    p.k(paramContext, "context");
    boolean bool = b.ct(paramContext);
    AppMethodBeat.o(253032);
    return bool;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/forcenotify/util/ForceNotifyPermissionUtil$IPermissionCallback;", "", "onResult", "", "ok", "", "plugin-force-notify_release"})
  public static abstract interface a
  {
    public abstract void ep(boolean paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/forcenotify/util/ForceNotifyPermissionUtil$checkPermission$resultCallback$1", "Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyAcceptUI$OverlayPermissionResultCallBack;", "onResultAllow", "", "dialog", "Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyAcceptUI;", "onResultCancel", "onResultRefuse", "plugin-force-notify_release"})
  public static final class b
    implements ForceNotifyAcceptUI.b
  {
    b(a.a parama, Context paramContext) {}
    
    public final void b(ForceNotifyAcceptUI paramForceNotifyAcceptUI)
    {
      AppMethodBeat.i(253165);
      Log.w("MicroMsg.ForceNotifyPermissionUtil", "checkPermission permission granted");
      paramForceNotifyAcceptUI.finish();
      this.BFg.ep(true);
      AppMethodBeat.o(253165);
    }
    
    public final void c(ForceNotifyAcceptUI paramForceNotifyAcceptUI)
    {
      AppMethodBeat.i(253166);
      Log.w("MicroMsg.ForceNotifyPermissionUtil", "checkPermission permission refused");
      paramForceNotifyAcceptUI.finish();
      this.BFg.ep(false);
      AppMethodBeat.o(253166);
    }
    
    public final void d(ForceNotifyAcceptUI paramForceNotifyAcceptUI)
    {
      AppMethodBeat.i(253167);
      boolean bool = b.ct(paramContext);
      Log.w("MicroMsg.ForceNotifyPermissionUtil", "checkPermission cancel, ok:".concat(String.valueOf(bool)));
      if (paramForceNotifyAcceptUI != null) {
        paramForceNotifyAcceptUI.finish();
      }
      this.BFg.ep(bool);
      AppMethodBeat.o(253167);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.f.a
 * JD-Core Version:    0.7.0.1
 */