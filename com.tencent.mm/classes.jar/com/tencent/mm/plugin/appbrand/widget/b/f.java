package com.tencent.mm.plugin.appbrand.widget.b;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.plugin.appbrand.k.a.b;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.y;

public final class f
  extends p
  implements h
{
  private View contentView;
  private DialogInterface.OnCancelListener fld;
  private boolean fsA = true;
  private DialogInterface.OnShowListener hsm;
  private DialogInterface.OnDismissListener hsn;
  private boolean hso;
  private i hsp;
  
  public f(Context paramContext)
  {
    super(paramContext, a.b.mmalertdialog, 0);
    try
    {
      onCreate(null);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public final void a(i parami)
  {
    if (this.hsm != null) {
      this.hsm.onShow(this);
    }
    this.hsp = parami;
  }
  
  public final boolean arC()
  {
    return this.hso;
  }
  
  public final void dismiss()
  {
    if (this.hsp != null)
    {
      this.hsp.c(this);
      if (this.hsn != null) {
        this.hsn.onDismiss(this);
      }
    }
  }
  
  public final View getContentView()
  {
    return this.contentView;
  }
  
  public final boolean isCancelable()
  {
    return this.fsA;
  }
  
  public final void onCancel()
  {
    if (this.fld != null) {
      this.fld.onCancel(this);
    }
  }
  
  public final void setCancelable(boolean paramBoolean)
  {
    super.setCancelable(paramBoolean);
    this.fsA = paramBoolean;
  }
  
  public final void setCanceledOnTouchOutside(boolean paramBoolean)
  {
    super.setCanceledOnTouchOutside(paramBoolean);
    this.hso = paramBoolean;
  }
  
  public final void setContentView(int paramInt)
  {
    setContentView(y.gt(getContext()).inflate(paramInt, null));
  }
  
  public final void setContentView(View paramView)
  {
    this.contentView = paramView;
  }
  
  public final void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams != null) {
      paramView.setLayoutParams(paramLayoutParams);
    }
    setContentView(paramView);
  }
  
  public final void setOnCancelListener(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    super.setOnCancelListener(paramOnCancelListener);
    this.fld = paramOnCancelListener;
  }
  
  public final void setOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    super.setOnDismissListener(paramOnDismissListener);
    this.hsn = paramOnDismissListener;
  }
  
  public final void setOnShowListener(DialogInterface.OnShowListener paramOnShowListener)
  {
    super.setOnShowListener(paramOnShowListener);
    this.hsm = paramOnShowListener;
  }
  
  public final void show() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.f
 * JD-Core Version:    0.7.0.1
 */