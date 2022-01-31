package com.tencent.mm.plugin.appbrand.widget.b;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.f;

public class g
  extends f
  implements k, k.a
{
  private View contentView;
  private DialogInterface.OnCancelListener gCt;
  private boolean gKc;
  private DialogInterface.OnShowListener jiT;
  private DialogInterface.OnDismissListener jiU;
  private boolean jiV;
  private l jiW;
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(102358);
    this.gKc = true;
    try
    {
      onCreate(null);
      AppMethodBeat.o(102358);
      return;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(102358);
    }
  }
  
  public final void a(l paraml)
  {
    AppMethodBeat.i(102359);
    if (this.jiT != null) {
      this.jiT.onShow(this);
    }
    this.jiW = paraml;
    AppMethodBeat.o(102359);
  }
  
  public final boolean aKF()
  {
    return this.jiV;
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(102364);
    if (this.jiW != null)
    {
      this.jiW.c(this);
      if (this.jiU != null) {
        this.jiU.onDismiss(this);
      }
    }
    AppMethodBeat.o(102364);
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
    return this.gKc;
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(102363);
    if (this.gCt != null) {
      this.gCt.onCancel(this);
    }
    AppMethodBeat.o(102363);
  }
  
  public final void pq(int paramInt) {}
  
  public void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(102367);
    super.setCancelable(paramBoolean);
    this.gKc = paramBoolean;
    AppMethodBeat.o(102367);
  }
  
  public void setCanceledOnTouchOutside(boolean paramBoolean)
  {
    AppMethodBeat.i(102366);
    super.setCanceledOnTouchOutside(paramBoolean);
    this.jiV = paramBoolean;
    AppMethodBeat.o(102366);
  }
  
  public void setContentView(int paramInt)
  {
    AppMethodBeat.i(102360);
    setContentView(LayoutInflater.from(getContext()).inflate(paramInt, null));
    AppMethodBeat.o(102360);
  }
  
  public void setContentView(View paramView)
  {
    this.contentView = paramView;
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(102361);
    if (paramLayoutParams != null) {
      paramView.setLayoutParams(paramLayoutParams);
    }
    setContentView(paramView);
    AppMethodBeat.o(102361);
  }
  
  public void setOnCancelListener(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(102368);
    super.setOnCancelListener(paramOnCancelListener);
    this.gCt = paramOnCancelListener;
    AppMethodBeat.o(102368);
  }
  
  public void setOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(102365);
    super.setOnDismissListener(paramOnDismissListener);
    this.jiU = paramOnDismissListener;
    AppMethodBeat.o(102365);
  }
  
  public void setOnShowListener(DialogInterface.OnShowListener paramOnShowListener)
  {
    AppMethodBeat.i(102362);
    super.setOnShowListener(paramOnShowListener);
    this.jiT = paramOnShowListener;
    AppMethodBeat.o(102362);
  }
  
  public void show() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.g
 * JD-Core Version:    0.7.0.1
 */