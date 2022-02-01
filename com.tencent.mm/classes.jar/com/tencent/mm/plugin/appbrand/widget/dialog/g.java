package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a.j;

public class g
  extends j
  implements k, k.a
{
  private View contentView;
  private m iDj;
  private DialogInterface.OnCancelListener jjc;
  private DialogInterface.OnDismissListener naV;
  private DialogInterface.OnShowListener ncc;
  private boolean ov;
  private boolean ow;
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(147741);
    this.ov = true;
    try
    {
      onCreate(null);
      AppMethodBeat.o(147741);
      return;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(147741);
    }
  }
  
  public final void a(m paramm)
  {
    AppMethodBeat.i(147742);
    if (this.ncc != null) {
      this.ncc.onShow(this);
    }
    this.iDj = paramm;
    AppMethodBeat.o(147742);
  }
  
  public final boolean aOv()
  {
    return false;
  }
  
  public final boolean aOw()
  {
    return this.ow;
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(147747);
    if (this.iDj != null)
    {
      this.iDj.c(this);
      if (this.naV != null) {
        this.naV.onDismiss(this);
      }
    }
    AppMethodBeat.o(147747);
  }
  
  public final View getContentView()
  {
    return this.contentView;
  }
  
  public final int getPosition()
  {
    return 1;
  }
  
  public final boolean isCancelable()
  {
    return this.ov;
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(147746);
    if (this.jjc != null) {
      this.jjc.onCancel(this);
    }
    AppMethodBeat.o(147746);
  }
  
  public final void qy(int paramInt) {}
  
  public void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(147750);
    super.setCancelable(paramBoolean);
    this.ov = paramBoolean;
    AppMethodBeat.o(147750);
  }
  
  public void setCanceledOnTouchOutside(boolean paramBoolean)
  {
    AppMethodBeat.i(147749);
    super.setCanceledOnTouchOutside(paramBoolean);
    this.ow = paramBoolean;
    AppMethodBeat.o(147749);
  }
  
  public void setContentView(int paramInt)
  {
    AppMethodBeat.i(147743);
    setContentView(LayoutInflater.from(getContext()).inflate(paramInt, null));
    AppMethodBeat.o(147743);
  }
  
  public void setContentView(View paramView)
  {
    this.contentView = paramView;
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(147744);
    if (paramLayoutParams != null) {
      paramView.setLayoutParams(paramLayoutParams);
    }
    setContentView(paramView);
    AppMethodBeat.o(147744);
  }
  
  public void setOnCancelListener(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(147751);
    super.setOnCancelListener(paramOnCancelListener);
    this.jjc = paramOnCancelListener;
    AppMethodBeat.o(147751);
  }
  
  public void setOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(147748);
    super.setOnDismissListener(paramOnDismissListener);
    this.naV = paramOnDismissListener;
    AppMethodBeat.o(147748);
  }
  
  public void setOnShowListener(DialogInterface.OnShowListener paramOnShowListener)
  {
    AppMethodBeat.i(147745);
    super.setOnShowListener(paramOnShowListener);
    this.ncc = paramOnShowListener;
    AppMethodBeat.o(147745);
  }
  
  public void show() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.g
 * JD-Core Version:    0.7.0.1
 */