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
  private Button hJg;
  private Button hJh;
  private View jGG;
  private int kBk;
  private BottomSheetBehavior kBl;
  private Context mContext;
  android.support.design.widget.a sri;
  CustomDatePicker srm;
  b.a srn;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(110423);
    this.mContext = paramContext;
    this.jGG = View.inflate(this.mContext, 2131494427, null);
    this.srm = ((CustomDatePicker)this.jGG.findViewById(2131298931));
    this.hJh = ((Button)this.jGG.findViewById(2131302999));
    this.hJh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110419);
        b.a(b.this, true, b.a(b.this).getYear(), b.a(b.this).getMonth(), b.a(b.this).getDayOfMonth());
        b.this.hide();
        AppMethodBeat.o(110419);
      }
    });
    this.hJg = ((Button)this.jGG.findViewById(2131297690));
    this.hJg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110420);
        b.a(b.this, false, 0, 0, 0);
        b.this.hide();
        AppMethodBeat.o(110420);
      }
    });
    this.sri = new android.support.design.widget.a(this.mContext);
    this.sri.setContentView(this.jGG);
    this.sri.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(110421);
        b.a(b.this, false, 0, 0, 0);
        b.this.hide();
        AppMethodBeat.o(110421);
      }
    });
    this.sri.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(110422);
        b.b(b.this);
        AppMethodBeat.o(110422);
      }
    });
    paramContext = (FrameLayout.LayoutParams)this.jGG.getLayoutParams();
    paramContext.height = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 318);
    this.jGG.setLayoutParams(paramContext);
    this.kBk = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 350);
    this.kBl = BottomSheetBehavior.l((View)this.jGG.getParent());
    if (this.kBl != null)
    {
      this.kBl.J(this.kBk);
      this.kBl.lh = false;
    }
    AppMethodBeat.o(110423);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(110424);
    if (this.sri != null) {
      this.sri.dismiss();
    }
    AppMethodBeat.o(110424);
  }
  
  public final void onGlobalLayout() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.ui.b
 * JD-Core Version:    0.7.0.1
 */