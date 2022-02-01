package com.tencent.mm.msgsubscription.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class a$d
  implements View.OnClickListener
{
  a$d(a parama, SubscribeMsgTmpItem paramSubscribeMsgTmpItem) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(149728);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter$fillInfoIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    paramView = com.tencent.mm.msgsubscription.util.b.jDg;
    paramView = com.tencent.mm.msgsubscription.util.b.a(a.b(this.jBJ), this.jBK.jyA, a.b(this.jBJ).getResources().getDimensionPixelSize(2131165586));
    paramView = h.a(a.b(this.jBJ), this.jBJ.jAi, a.b(this.jBJ).getString(2131755874), paramView, (DialogInterface.OnClickListener)a.jBL);
    paramView.ajL(Color.parseColor("#07C160"));
    paramView.setCancelable(false);
    paramView.setCanceledOnTouchOutside(false);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter$fillInfoIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(149728);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class a
    implements DialogInterface.OnClickListener
  {
    public static final a jBL;
    
    static
    {
      AppMethodBeat.i(149727);
      jBL = new a();
      AppMethodBeat.o(149727);
    }
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(149726);
      paramDialogInterface.dismiss();
      AppMethodBeat.o(149726);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.a.d
 * JD-Core Version:    0.7.0.1
 */