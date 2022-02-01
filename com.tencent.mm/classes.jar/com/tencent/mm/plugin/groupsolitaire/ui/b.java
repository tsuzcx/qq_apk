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
  private Button gUt;
  private Button gWI;
  private View kBS;
  private int lzC;
  private BottomSheetBehavior lzD;
  private Context mContext;
  android.support.design.widget.a uBI;
  CustomDatePicker uBM;
  a uBN;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(110423);
    this.mContext = paramContext;
    this.kBS = View.inflate(this.mContext, 2131494427, null);
    this.uBM = ((CustomDatePicker)this.kBS.findViewById(2131298931));
    this.gUt = ((Button)this.kBS.findViewById(2131302999));
    this.gUt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110419);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireDatePicker$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        b.a(b.this, true, b.a(b.this).getYear(), b.a(b.this).getMonth(), b.a(b.this).getDayOfMonth());
        b.this.hide();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireDatePicker$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(110419);
      }
    });
    this.gWI = ((Button)this.kBS.findViewById(2131297690));
    this.gWI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110420);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireDatePicker$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        b.a(b.this, false, 0, 0, 0);
        b.this.hide();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireDatePicker$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(110420);
      }
    });
    this.uBI = new android.support.design.widget.a(this.mContext);
    this.uBI.setContentView(this.kBS);
    this.uBI.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(110421);
        b.a(b.this, false, 0, 0, 0);
        b.this.hide();
        AppMethodBeat.o(110421);
      }
    });
    this.uBI.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(110422);
        b.b(b.this);
        AppMethodBeat.o(110422);
      }
    });
    paramContext = (FrameLayout.LayoutParams)this.kBS.getLayoutParams();
    paramContext.height = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 318);
    this.kBS.setLayoutParams(paramContext);
    this.lzC = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 350);
    this.lzD = BottomSheetBehavior.l((View)this.kBS.getParent());
    if (this.lzD != null)
    {
      this.lzD.J(this.lzC);
      this.lzD.nZ = false;
    }
    AppMethodBeat.o(110423);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(110424);
    if (this.uBI != null) {
      this.uBI.dismiss();
    }
    AppMethodBeat.o(110424);
  }
  
  public final void onGlobalLayout() {}
  
  public static abstract interface a<T>
  {
    public abstract void onResult(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.ui.b
 * JD-Core Version:    0.7.0.1
 */