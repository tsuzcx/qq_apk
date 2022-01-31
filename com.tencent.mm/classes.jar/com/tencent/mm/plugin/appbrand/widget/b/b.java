package com.tencent.mm.plugin.appbrand.widget.b;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.ui.widget.a.c;

public class b
  extends c
  implements h
{
  private View contentView;
  private DialogInterface.OnCancelListener fld;
  private boolean fsA = true;
  private DialogInterface.OnShowListener hsm;
  private DialogInterface.OnDismissListener hsn;
  private boolean hso;
  private i hsp;
  
  public b(Context paramContext)
  {
    super(paramContext);
    setContentView(super.getContentView());
    setCanceledOnTouchOutside(false);
  }
  
  public b(Context paramContext, byte paramByte)
  {
    super(paramContext);
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
  
  public void dismiss()
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
    if (this.contentView != null) {
      return this.contentView;
    }
    return super.getContentView();
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
  
  public void setCancelable(boolean paramBoolean)
  {
    super.setCancelable(paramBoolean);
    this.fsA = paramBoolean;
  }
  
  public void setCanceledOnTouchOutside(boolean paramBoolean)
  {
    super.setCanceledOnTouchOutside(paramBoolean);
    this.hso = paramBoolean;
  }
  
  public void setContentView(int paramInt)
  {
    setContentView(LayoutInflater.from(getContext()).inflate(paramInt, null));
  }
  
  public void setContentView(View paramView)
  {
    Object localObject = paramView;
    if (!(paramView instanceof a)) {
      localObject = new a(paramView.getContext(), paramView);
    }
    this.contentView = ((View)localObject);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams != null) {
      paramView.setLayoutParams(paramLayoutParams);
    }
    setContentView(paramView);
  }
  
  public void setOnCancelListener(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    super.setOnCancelListener(paramOnCancelListener);
    this.fld = paramOnCancelListener;
  }
  
  public void setOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    super.setOnDismissListener(paramOnDismissListener);
    this.hsn = paramOnDismissListener;
  }
  
  public void setOnShowListener(DialogInterface.OnShowListener paramOnShowListener)
  {
    super.setOnShowListener(paramOnShowListener);
    this.hsm = paramOnShowListener;
  }
  
  public void show() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.b
 * JD-Core Version:    0.7.0.1
 */