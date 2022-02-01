package com.tencent.mm.plugin.groupsolitaire.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.support.design.widget.BottomSheetBehavior;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.CustomDatePicker;

public final class b
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private Button hPX;
  private Button hSq;
  private View lJI;
  private Context mContext;
  private int mLJ;
  private BottomSheetBehavior mLK;
  android.support.design.widget.a yfL;
  CustomDatePicker yfP;
  a yfQ;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(110423);
    this.mContext = paramContext;
    this.lJI = View.inflate(this.mContext, 2131495001, null);
    this.yfP = ((CustomDatePicker)this.lJI.findViewById(2131299415));
    this.hPX = ((Button)this.lJI.findViewById(2131305592));
    this.hPX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110419);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireDatePicker$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        b.a(b.this, true, b.a(b.this).getYear(), b.a(b.this).getMonth(), b.a(b.this).getDayOfMonth());
        b.this.hide();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireDatePicker$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(110419);
      }
    });
    this.hSq = ((Button)this.lJI.findViewById(2131297963));
    this.hSq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110420);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireDatePicker$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        b.a(b.this, false, 0, 0, 0);
        b.this.hide();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireDatePicker$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(110420);
      }
    });
    this.yfL = new android.support.design.widget.a(this.mContext);
    this.yfL.setContentView(this.lJI);
    this.yfL.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(110421);
        b.a(b.this, false, 0, 0, 0);
        b.this.hide();
        AppMethodBeat.o(110421);
      }
    });
    this.yfL.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(110422);
        b.b(b.this);
        AppMethodBeat.o(110422);
      }
    });
    paramContext = (FrameLayout.LayoutParams)this.lJI.getLayoutParams();
    paramContext.height = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 318);
    this.lJI.setLayoutParams(paramContext);
    this.mLJ = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 350);
    this.mLK = BottomSheetBehavior.l((View)this.lJI.getParent());
    if (this.mLK != null)
    {
      this.mLK.J(this.mLJ);
      this.mLK.ob = false;
    }
    AppMethodBeat.o(110423);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(110424);
    if (this.yfL != null) {
      this.yfL.dismiss();
    }
    AppMethodBeat.o(110424);
  }
  
  public final void onGlobalLayout() {}
  
  public static abstract interface a<T>
  {
    public abstract void onResult(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.ui.b
 * JD-Core Version:    0.7.0.1
 */