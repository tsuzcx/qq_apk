package com.tencent.mm.plugin.forcenotify.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.cp.f;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.forcenotify.a.e;
import com.tencent.mm.plugin.forcenotify.a.f;
import com.tencent.mm.plugin.forcenotify.a.h;
import com.tencent.mm.plugin.forcenotify.c.c;
import com.tencent.mm.plugin.forcenotify.c.h;
import com.tencent.mm.protocal.protobuf.bzt;
import com.tencent.mm.protocal.protobuf.etv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@com.tencent.mm.ui.base.a(3)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyAcceptUIOld;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "executor", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getLayoutId", "", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-force-notify_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ForceNotifyAcceptUIOld
  extends MMActivity
{
  private final MMHandler HoJ;
  private final String TAG;
  private w rYw;
  
  public ForceNotifyAcceptUIOld()
  {
    AppMethodBeat.i(274909);
    this.TAG = "MicroMsg.ForceNotifyAcceptUI";
    this.HoJ = new MMHandler(this.TAG);
    AppMethodBeat.o(274909);
  }
  
  private static final ah a(ForceNotifyAcceptUIOld paramForceNotifyAcceptUIOld, b.a parama)
  {
    AppMethodBeat.i(274923);
    s.u(paramForceNotifyAcceptUIOld, "this$0");
    int i;
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      Log.i(paramForceNotifyAcceptUIOld.TAG, "get accept info successfully");
      parama = ((etv)parama.ott).abwZ;
      h localh = new h();
      localh.field_UserName = parama.UserName;
      localh.field_ExpiredTime = (parama.aaiS * 1000L);
      localh.field_CreateTime = (parama.CreateTime * 1000L);
      if (cn.bDv() >= localh.field_ExpiredTime)
      {
        i = 1;
        if (i != 1) {
          break label205;
        }
        i = 0;
        label107:
        localh.field_Status = i;
        localh.field_ExtInfo = parama.IMu;
        localh.field_Description = parama.crB;
        localh.field_UserIcon = parama.aaiT;
        localh.field_ForcePushId = parama.YFC;
        Log.i(paramForceNotifyAcceptUIOld.TAG, " item:%s", new Object[] { localh });
        ((TextView)paramForceNotifyAcceptUIOld.findViewById(a.e.desc)).setText((CharSequence)Util.nullAsNil(localh.field_Description));
      }
    }
    for (;;)
    {
      paramForceNotifyAcceptUIOld = paramForceNotifyAcceptUIOld.rYw;
      if (paramForceNotifyAcceptUIOld != null) {
        break label235;
      }
      AppMethodBeat.o(274923);
      return null;
      i = 0;
      break;
      label205:
      i = 1;
      break label107;
      Toast.makeText((Context)paramForceNotifyAcceptUIOld, (CharSequence)parama.errMsg, 0).show();
      paramForceNotifyAcceptUIOld.finish();
    }
    label235:
    paramForceNotifyAcceptUIOld.dismiss();
    paramForceNotifyAcceptUIOld = ah.aiuX;
    AppMethodBeat.o(274923);
    return paramForceNotifyAcceptUIOld;
  }
  
  private static final void a(ForceNotifyAcceptUIOld paramForceNotifyAcceptUIOld, View paramView)
  {
    AppMethodBeat.i(274950);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramForceNotifyAcceptUIOld);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/forcenotify/ui/ForceNotifyAcceptUIOld", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramForceNotifyAcceptUIOld, "this$0");
    Log.i(paramForceNotifyAcceptUIOld.TAG, "Cancel!");
    paramForceNotifyAcceptUIOld.finish();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyAcceptUIOld", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(274950);
  }
  
  private static final void a(ForceNotifyAcceptUIOld paramForceNotifyAcceptUIOld, String paramString, View paramView)
  {
    AppMethodBeat.i(274943);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramForceNotifyAcceptUIOld);
    localb.cH(paramString);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/forcenotify/ui/ForceNotifyAcceptUIOld", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramForceNotifyAcceptUIOld, "this$0");
    paramView = (Context)paramForceNotifyAcceptUIOld;
    paramForceNotifyAcceptUIOld.getString(a.h.app_tip);
    paramForceNotifyAcceptUIOld.rYw = k.a(paramView, paramForceNotifyAcceptUIOld.getString(a.h.app_waiting), false, ForceNotifyAcceptUIOld..ExternalSyntheticLambda0.INSTANCE);
    paramView = paramForceNotifyAcceptUIOld.rYw;
    if (paramView != null) {
      paramView.show();
    }
    new com.tencent.mm.plugin.forcenotify.c.b(paramString).bFJ().b(new ForceNotifyAcceptUIOld..ExternalSyntheticLambda5(paramForceNotifyAcceptUIOld));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyAcceptUIOld", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(274943);
  }
  
  private static final void a(String paramString, ForceNotifyAcceptUIOld paramForceNotifyAcceptUIOld)
  {
    AppMethodBeat.i(274929);
    s.u(paramForceNotifyAcceptUIOld, "this$0");
    new c(paramString).bFJ().b(new ForceNotifyAcceptUIOld..ExternalSyntheticLambda6(paramForceNotifyAcceptUIOld));
    AppMethodBeat.o(274929);
  }
  
  private static final boolean a(ForceNotifyAcceptUIOld paramForceNotifyAcceptUIOld, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(274914);
    s.u(paramForceNotifyAcceptUIOld, "this$0");
    paramForceNotifyAcceptUIOld.onBackPressed();
    AppMethodBeat.o(274914);
    return true;
  }
  
  private static final Object b(ForceNotifyAcceptUIOld paramForceNotifyAcceptUIOld, b.a parama)
  {
    AppMethodBeat.i(274936);
    s.u(paramForceNotifyAcceptUIOld, "this$0");
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      Log.i(paramForceNotifyAcceptUIOld.TAG, "accept successfully");
      parama = paramForceNotifyAcceptUIOld.rYw;
      if (parama != null) {
        parama.dismiss();
      }
      Toast.makeText((Context)paramForceNotifyAcceptUIOld, (CharSequence)paramForceNotifyAcceptUIOld.getResources().getString(a.h.force_notify_accepted_tip), 0).show();
      paramForceNotifyAcceptUIOld.finish();
      paramForceNotifyAcceptUIOld = ah.aiuX;
      AppMethodBeat.o(274936);
      return paramForceNotifyAcceptUIOld;
    }
    Object localObject = paramForceNotifyAcceptUIOld.rYw;
    if (localObject != null) {
      ((w)localObject).dismiss();
    }
    if (parama.errMsg != null)
    {
      localObject = parama.errMsg;
      s.s(localObject, "it.errMsg");
      if (((CharSequence)localObject).length() != 0) {
        break label184;
      }
    }
    label184:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        parama.errMsg = paramForceNotifyAcceptUIOld.getResources().getString(a.h.force_notify_accept_error_tip);
      }
      paramForceNotifyAcceptUIOld = k.c((Context)paramForceNotifyAcceptUIOld, parama.errMsg, paramForceNotifyAcceptUIOld.getResources().getString(a.h.app_tip), true);
      AppMethodBeat.o(274936);
      return paramForceNotifyAcceptUIOld;
    }
  }
  
  private static final void w(DialogInterface paramDialogInterface) {}
  
  private static final void x(DialogInterface paramDialogInterface) {}
  
  public final int getLayoutId()
  {
    return a.f.force_notify_accept_ui;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(275007);
    super.onBackPressed();
    finish();
    AppMethodBeat.o(275007);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(275003);
    getWindow().addFlags(6815872);
    super.onCreate(paramBundle);
    fullScreenNoTitleBar(true);
    setBackBtn(new ForceNotifyAcceptUIOld..ExternalSyntheticLambda2(this));
    paramBundle = (Context)this;
    getString(a.h.app_tip);
    this.rYw = k.a(paramBundle, getString(a.h.app_waiting), false, ForceNotifyAcceptUIOld..ExternalSyntheticLambda1.INSTANCE);
    paramBundle = this.rYw;
    if (paramBundle != null) {
      paramBundle.show();
    }
    paramBundle = getIntent().getExtras();
    if (paramBundle == null) {}
    for (paramBundle = null;; paramBundle = paramBundle.getString("data"))
    {
      Log.d(this.TAG, "data:%s", new Object[] { paramBundle });
      if (paramBundle != null) {
        break;
      }
      finish();
      Log.d(this.TAG, "data is null");
      AppMethodBeat.o(275003);
      return;
    }
    this.HoJ.post(new ForceNotifyAcceptUIOld..ExternalSyntheticLambda7(paramBundle, this));
    ((Button)findViewById(a.e.accept)).setOnClickListener(new ForceNotifyAcceptUIOld..ExternalSyntheticLambda4(this, paramBundle));
    ((Button)findViewById(a.e.cancel)).setOnClickListener(new ForceNotifyAcceptUIOld..ExternalSyntheticLambda3(this));
    AppMethodBeat.o(275003);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(275013);
    super.onDestroy();
    w localw = this.rYw;
    if (localw != null) {
      localw.dismiss();
    }
    AppMethodBeat.o(275013);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.ForceNotifyAcceptUIOld
 * JD-Core Version:    0.7.0.1
 */