package com.tencent.mm.plugin.forcenotify.e;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.plugin.forcenotify.a.h;
import com.tencent.mm.plugin.forcenotify.ui.ForceNotifyAcceptUI;
import com.tencent.mm.plugin.forcenotify.ui.ForceNotifyAcceptUI.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/forcenotify/util/ForceNotifyPermissionUtil;", "", "()V", "TAG", "", "TYPE_CHAT", "", "TYPE_LIVE", "checkPermission", "", "context", "Landroid/content/Context;", "type", "dialogNewTask", "", "callback", "Lcom/tencent/mm/plugin/forcenotify/util/ForceNotifyPermissionUtil$IPermissionCallback;", "getWordingByType", "Lkotlin/Pair;", "isPermissionGranted", "IPermissionCallback", "plugin-force-notify_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a HpI;
  
  static
  {
    AppMethodBeat.i(274849);
    HpI = new a();
    AppMethodBeat.o(274849);
  }
  
  public static void a(final Context paramContext, int paramInt, a parama)
  {
    AppMethodBeat.i(274847);
    s.u(paramContext, "context");
    s.u(parama, "callback");
    if (b.dh(paramContext))
    {
      Log.w("MicroMsg.ForceNotifyPermissionUtil", "checkPermission already granted");
      parama.onResult(true);
      AppMethodBeat.o(274847);
      return;
    }
    Object localObject1 = null;
    if (paramInt == 2) {
      localObject1 = at.a.adho;
    }
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.forcenotify.d.a.Hoy;
      int i = com.tencent.mm.plugin.forcenotify.d.a.i((at.a)localObject1);
      if (i > 0)
      {
        parama.onResult(false);
        AppMethodBeat.o(274847);
        return;
      }
      localObject2 = com.tencent.mm.plugin.forcenotify.d.a.Hoy;
      com.tencent.mm.plugin.forcenotify.d.a.d((at.a)localObject1, i + 1);
    }
    localObject1 = new b(parama, paramContext);
    switch (paramInt)
    {
    default: 
      parama = v.Y(paramContext.getString(a.h.force_notify_window_permission_title_chat), paramContext.getString(a.h.force_notify_window_permission_content_chat));
    }
    for (;;)
    {
      localObject2 = (String)parama.bsC;
      parama = (String)parama.bsD;
      Object localObject3 = ForceNotifyAcceptUI.HoG;
      localObject3 = (ForceNotifyAcceptUI.b)localObject1;
      localObject1 = com.tencent.mm.bq.a.aQB();
      s.s(localObject1, "getMessageChannelIdUse()");
      s.u(paramContext, "context");
      s.u(localObject2, "title");
      s.u(parama, "warningContent");
      s.u(localObject3, "resultCallBack");
      s.u(localObject1, "channel");
      ForceNotifyAcceptUI.a((ForceNotifyAcceptUI.b)localObject3);
      localObject3 = new Intent(paramContext, ForceNotifyAcceptUI.class);
      ((Intent)localObject3).putExtra("title", (String)localObject2);
      ((Intent)localObject3).putExtra("warning_content", parama);
      localObject2 = ForceNotifyAcceptUI.class.getCanonicalName();
      s.checkNotNull(localObject2);
      com.tencent.mm.util.a.a(paramContext, (Intent)localObject3, parama, (String)localObject2, false, (String)localObject1);
      AppMethodBeat.o(274847);
      return;
      parama = v.Y(paramContext.getString(a.h.force_notify_window_permission_title_chat), paramContext.getString(a.h.force_notify_window_permission_content_chat));
      continue;
      parama = v.Y(paramContext.getString(a.h.force_notify_window_permission_title_live), paramContext.getString(a.h.force_notify_window_permission_content_live));
    }
  }
  
  public static boolean hE(Context paramContext)
  {
    AppMethodBeat.i(274842);
    s.u(paramContext, "context");
    boolean bool = b.dh(paramContext);
    AppMethodBeat.o(274842);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/forcenotify/util/ForceNotifyPermissionUtil$IPermissionCallback;", "", "onResult", "", "ok", "", "plugin-force-notify_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void onResult(boolean paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/forcenotify/util/ForceNotifyPermissionUtil$checkPermission$resultCallback$1", "Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyAcceptUI$OverlayPermissionResultCallBack;", "onResultAllow", "", "dialog", "Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyAcceptUI;", "onResultCancel", "onResultRefuse", "plugin-force-notify_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements ForceNotifyAcceptUI.b
  {
    b(a.a parama, Context paramContext) {}
    
    public final void c(ForceNotifyAcceptUI paramForceNotifyAcceptUI)
    {
      AppMethodBeat.i(274845);
      Log.w("MicroMsg.ForceNotifyPermissionUtil", "checkPermission permission granted");
      paramForceNotifyAcceptUI.finish();
      this.HpJ.onResult(true);
      AppMethodBeat.o(274845);
    }
    
    public final void d(ForceNotifyAcceptUI paramForceNotifyAcceptUI)
    {
      AppMethodBeat.i(274848);
      Log.w("MicroMsg.ForceNotifyPermissionUtil", "checkPermission permission refused");
      paramForceNotifyAcceptUI.finish();
      this.HpJ.onResult(false);
      AppMethodBeat.o(274848);
    }
    
    public final void e(ForceNotifyAcceptUI paramForceNotifyAcceptUI)
    {
      AppMethodBeat.i(274853);
      boolean bool = b.dh(paramContext);
      Log.w("MicroMsg.ForceNotifyPermissionUtil", s.X("checkPermission cancel, ok:", Boolean.valueOf(bool)));
      if (paramForceNotifyAcceptUI != null) {
        paramForceNotifyAcceptUI.finish();
      }
      this.HpJ.onResult(bool);
      AppMethodBeat.o(274853);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.e.a
 * JD-Core Version:    0.7.0.1
 */