package com.tencent.mm.msgsubscription.ui;

import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import com.tencent.luggage.l.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.msgsubscription.a.c;
import com.tencent.mm.msgsubscription.a.d;
import com.tencent.mm.msgsubscription.a.e;
import com.tencent.mm.plugin.appbrand.widget.dialog.n;
import com.tencent.mm.plugin.appbrand.widget.dialog.o;
import com.tencent.mm.plugin.appbrand.widget.dialog.r;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgForceNotifyGuideBottomDialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mDialogHelper", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "mRootView", "Landroid/view/View;", "onDismissListener", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgForceNotifyGuideBottomDialog$OnDismissListener;", "cancel", "", "dismiss", "getContentView", "getPosition", "", "isCancelable", "", "isCanceledOnTouchOutside", "onBackPressedEvent", "onCancel", "onDismiss", "onScreenOrientationChanged", "rotation", "onShow", "dialogHelper", "onShown", "setOnDismissListener", "OnDismissListener", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements n
{
  private final Context context;
  private View plc;
  private r pld;
  public a ple;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(236555);
    this.context = paramContext;
    paramContext = LayoutInflater.from(this.context).inflate(a.e.subscribe_msg_force_notify_guide, null);
    s.s(paramContext, "from(context).inflate(R.…force_notify_guide, null)");
    this.plc = paramContext;
    this.plc.findViewById(a.d.ok_btn).setOnClickListener(new d..ExternalSyntheticLambda0(this));
    paramContext = (ImageView)this.plc.findViewById(a.d.bg_sample);
    if (k.exm.isDarkMode()) {}
    for (int i = a.c.subscribe_msg_dialog_force_guide_bg_dark;; i = a.c.subscribe_msg_dialog_force_guide_bg_light)
    {
      paramContext.setBackgroundResource(i);
      AppMethodBeat.o(236555);
      return;
    }
  }
  
  private static final void a(d paramd, View paramView)
  {
    AppMethodBeat.i(236567);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramView);
    a.c("com/tencent/mm/msgsubscription/ui/SubscribeMsgForceNotifyGuideBottomDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "this$0");
    paramd.dismiss();
    a.a(new Object(), "com/tencent/mm/msgsubscription/ui/SubscribeMsgForceNotifyGuideBottomDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(236567);
  }
  
  public final void a(r paramr)
  {
    AppMethodBeat.i(236611);
    this.pld = paramr;
    paramr = b.pkZ;
    paramr = this.context.getSystemService("window");
    if (paramr == null)
    {
      paramr = new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
      AppMethodBeat.o(236611);
      throw paramr;
    }
    b.a.d(((WindowManager)paramr).getDefaultDisplay().getRotation(), this.plc);
    AppMethodBeat.o(236611);
  }
  
  public final boolean bQg()
  {
    return false;
  }
  
  public final void bQh() {}
  
  public final boolean bQi()
  {
    return false;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(236605);
    r localr = this.pld;
    if (localr != null) {
      localr.c((n)this);
    }
    AppMethodBeat.o(236605);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(236588);
    r localr = this.pld;
    if (localr != null) {
      localr.a((o)new b(this));
    }
    localr = this.pld;
    if (localr != null) {
      localr.c((n)this);
    }
    AppMethodBeat.o(236588);
  }
  
  public final View getContentView()
  {
    return this.plc;
  }
  
  public final int getPosition()
  {
    return 2;
  }
  
  public final boolean isCancelable()
  {
    return true;
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(236636);
    r localr = this.pld;
    if (localr != null) {
      localr.c((n)this);
    }
    AppMethodBeat.o(236636);
  }
  
  public final void xt(int paramInt)
  {
    AppMethodBeat.i(236622);
    b.a locala = b.pkZ;
    b.a.d(paramInt, this.plc);
    AppMethodBeat.o(236622);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgForceNotifyGuideBottomDialog$OnDismissListener;", "", "onDismiss", "", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void onDismiss();
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/msgsubscription/ui/SubscribeMsgForceNotifyGuideBottomDialog$dismiss$1", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialogDismissStateListener;", "onDismiss", "", "dialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements o
  {
    b(d paramd) {}
    
    public final void a(n paramn)
    {
      AppMethodBeat.i(236607);
      paramn = d.a(this.plf);
      if (paramn != null) {
        paramn.b((o)this);
      }
      paramn = this.plf.ple;
      if (paramn != null) {
        paramn.onDismiss();
      }
      AppMethodBeat.o(236607);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.d
 * JD-Core Version:    0.7.0.1
 */