package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.ui.widget.a.f;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderBottomDialogHelper$Companion;", "", "()V", "TAG", "", "showConfirmDialog", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "context", "Landroid/content/Context;", "title", "msg", "lok", "Landroid/content/DialogInterface$OnClickListener;", "lcancel", "ldismiss", "Landroid/content/DialogInterface$OnDismissListener;", "ok", "cancel", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$a
{
  public static f a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(344508);
    kotlin.g.b.s.u(paramContext, "context");
    f localf = new f(paramContext, 1, false);
    Object localObject = View.inflate(paramContext, e.f.finder_bottom_confirm, null);
    if (localObject == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.widget.RoundedCornerFrameLayout");
      AppMethodBeat.o(344508);
      throw paramContext;
    }
    localObject = (RoundedCornerFrameLayout)localObject;
    ((TextView)((RoundedCornerFrameLayout)localObject).findViewById(e.e.finder_msg)).setText((CharSequence)Util.nullAsNil(paramString2));
    paramString2 = (TextView)((RoundedCornerFrameLayout)localObject).findViewById(e.e.finder_title);
    if (!Util.isNullOrNil(paramString1)) {
      paramString2.setText((CharSequence)paramString1);
    }
    paramString1 = (Button)((RoundedCornerFrameLayout)localObject).findViewById(e.e.ok_btn);
    if (!Util.isNullOrNil(paramString3)) {
      paramString1.setText((CharSequence)paramString3);
    }
    paramString2 = (Button)((RoundedCornerFrameLayout)localObject).findViewById(e.e.cancel_btn);
    if (!Util.isNullOrNil(paramString4)) {
      paramString2.setText((CharSequence)paramString4);
    }
    ((RoundedCornerFrameLayout)localObject).A(bd.fromDPToPix(paramContext, 12), bd.fromDPToPix(paramContext, 12), 0.0F, 0.0F);
    paramString1.setOnClickListener(new c.a..ExternalSyntheticLambda1(localf, paramOnClickListener1));
    paramString2.setOnClickListener(new c.a..ExternalSyntheticLambda0(localf, paramOnClickListener2));
    localf.aeLi = new c.a..ExternalSyntheticLambda3(paramOnDismissListener);
    localf.Vtg = new c.a..ExternalSyntheticLambda2(localf, (RoundedCornerFrameLayout)localObject);
    localf.uR(true);
    localf.dDn();
    AppMethodBeat.o(344508);
    return localf;
  }
  
  private static final void a(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(344523);
    if (paramOnDismissListener != null) {
      paramOnDismissListener.onDismiss(null);
    }
    AppMethodBeat.o(344523);
  }
  
  private static final void a(f paramf, DialogInterface.OnClickListener paramOnClickListener, View paramView)
  {
    AppMethodBeat.i(344512);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramf);
    localb.cH(paramOnClickListener);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/view/FinderBottomDialogHelper$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramf, "$dialog");
    paramf.cyW();
    if (paramOnClickListener != null) {
      paramOnClickListener.onClick(null, -1);
    }
    a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderBottomDialogHelper$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(344512);
  }
  
  private static final void a(f paramf, RoundedCornerFrameLayout paramRoundedCornerFrameLayout, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(344527);
    kotlin.g.b.s.u(paramf, "$dialog");
    kotlin.g.b.s.u(paramRoundedCornerFrameLayout, "$contentView");
    params.clear();
    paramf.setFooterView(null);
    paramf.setFooterView((View)paramRoundedCornerFrameLayout);
    AppMethodBeat.o(344527);
  }
  
  private static final void b(f paramf, DialogInterface.OnClickListener paramOnClickListener, View paramView)
  {
    AppMethodBeat.i(344518);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramf);
    localb.cH(paramOnClickListener);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/view/FinderBottomDialogHelper$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramf, "$dialog");
    paramf.cyW();
    if (paramOnClickListener != null) {
      paramOnClickListener.onClick(null, -2);
    }
    a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderBottomDialogHelper$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(344518);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.c.a
 * JD-Core Version:    0.7.0.1
 */