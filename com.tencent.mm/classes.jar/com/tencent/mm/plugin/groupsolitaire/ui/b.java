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
  private Button gAJ;
  private Button gCY;
  private View khe;
  private int lcC;
  private BottomSheetBehavior lcD;
  private Context mContext;
  android.support.design.widget.a tyZ;
  CustomDatePicker tzd;
  a tze;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(110423);
    this.mContext = paramContext;
    this.khe = View.inflate(this.mContext, 2131494427, null);
    this.tzd = ((CustomDatePicker)this.khe.findViewById(2131298931));
    this.gAJ = ((Button)this.khe.findViewById(2131302999));
    this.gAJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110419);
        b.a(b.this, true, b.a(b.this).getYear(), b.a(b.this).getMonth(), b.a(b.this).getDayOfMonth());
        b.this.hide();
        AppMethodBeat.o(110419);
      }
    });
    this.gCY = ((Button)this.khe.findViewById(2131297690));
    this.gCY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110420);
        b.a(b.this, false, 0, 0, 0);
        b.this.hide();
        AppMethodBeat.o(110420);
      }
    });
    this.tyZ = new android.support.design.widget.a(this.mContext);
    this.tyZ.setContentView(this.khe);
    this.tyZ.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(110421);
        b.a(b.this, false, 0, 0, 0);
        b.this.hide();
        AppMethodBeat.o(110421);
      }
    });
    this.tyZ.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(110422);
        b.b(b.this);
        AppMethodBeat.o(110422);
      }
    });
    paramContext = (FrameLayout.LayoutParams)this.khe.getLayoutParams();
    paramContext.height = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 318);
    this.khe.setLayoutParams(paramContext);
    this.lcC = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 350);
    this.lcD = BottomSheetBehavior.l((View)this.khe.getParent());
    if (this.lcD != null)
    {
      this.lcD.J(this.lcC);
      this.lcD.mg = false;
    }
    AppMethodBeat.o(110423);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(110424);
    if (this.tyZ != null) {
      this.tyZ.dismiss();
    }
    AppMethodBeat.o(110424);
  }
  
  public final void onGlobalLayout() {}
  
  public static abstract interface a<T>
  {
    public abstract void onResult(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.ui.b
 * JD-Core Version:    0.7.0.1
 */