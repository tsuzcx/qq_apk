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
import com.tencent.mm.msgsubscription.util.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class a$d
  implements View.OnClickListener
{
  a$d(a parama, SubscribeMsgTmpItem paramSubscribeMsgTmpItem) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(149728);
    paramView = b.ikN;
    paramView = b.a(a.b(this.ijw), this.ijx.igX, a.b(this.ijw).getResources().getDimensionPixelSize(2131165568));
    paramView = h.a(a.b(this.ijw), this.ijw.ihE, a.b(this.ijw).getString(2131755793), paramView, (DialogInterface.OnClickListener)a.ijy);
    paramView.Yl(Color.parseColor("#07C160"));
    paramView.setCancelable(false);
    paramView.setCanceledOnTouchOutside(false);
    AppMethodBeat.o(149728);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class a
    implements DialogInterface.OnClickListener
  {
    public static final a ijy;
    
    static
    {
      AppMethodBeat.i(149727);
      ijy = new a();
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