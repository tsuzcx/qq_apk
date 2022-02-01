package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a.d;

public class b
  extends d
  implements k
{
  private View contentView;
  private m iGc;
  private DialogInterface.OnCancelListener jlV;
  private DialogInterface.OnDismissListener ngd;
  private DialogInterface.OnShowListener ngl;
  private boolean ngm;
  private boolean ov;
  private boolean ow;
  
  public b(Context paramContext)
  {
    super(paramContext, (byte)0);
    AppMethodBeat.i(135470);
    this.ov = true;
    this.ngm = false;
    setContentView(super.getContentView());
    setCanceledOnTouchOutside(false);
    AppMethodBeat.o(135470);
  }
  
  public b(Context paramContext, byte paramByte)
  {
    super(paramContext, (byte)0);
    this.ov = true;
    this.ngm = false;
  }
  
  public final void a(m paramm)
  {
    AppMethodBeat.i(135471);
    if (this.ngl != null) {
      this.ngl.onShow(this);
    }
    this.iGc = paramm;
    AppMethodBeat.o(135471);
  }
  
  public final boolean aOS()
  {
    return false;
  }
  
  public final boolean aOT()
  {
    return this.ow;
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(135478);
    if (this.ngm)
    {
      AppMethodBeat.o(135478);
      return;
    }
    this.ngm = true;
    if (this.iGc != null)
    {
      this.iGc.c(this);
      if (this.ngd != null) {
        this.ngd.onDismiss(this);
      }
    }
    AppMethodBeat.o(135478);
  }
  
  public final View getContentView()
  {
    AppMethodBeat.i(135472);
    if (this.contentView != null)
    {
      localView = this.contentView;
      AppMethodBeat.o(135472);
      return localView;
    }
    View localView = super.getContentView();
    AppMethodBeat.o(135472);
    return localView;
  }
  
  public int getPosition()
  {
    return 1;
  }
  
  public final boolean isCancelable()
  {
    return this.ov;
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(135477);
    if (this.jlV != null) {
      this.jlV.onCancel(this);
    }
    AppMethodBeat.o(135477);
  }
  
  public final void qB(int paramInt) {}
  
  public void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(135481);
    super.setCancelable(paramBoolean);
    this.ov = paramBoolean;
    AppMethodBeat.o(135481);
  }
  
  public void setCanceledOnTouchOutside(boolean paramBoolean)
  {
    AppMethodBeat.i(135480);
    super.setCanceledOnTouchOutside(paramBoolean);
    this.ow = paramBoolean;
    AppMethodBeat.o(135480);
  }
  
  public void setContentView(int paramInt)
  {
    AppMethodBeat.i(135473);
    setContentView(LayoutInflater.from(getContext()).inflate(paramInt, null));
    AppMethodBeat.o(135473);
  }
  
  public void setContentView(View paramView)
  {
    AppMethodBeat.i(135474);
    Object localObject = paramView;
    if (!(paramView instanceof a)) {
      localObject = new a(paramView.getContext(), paramView);
    }
    this.contentView = ((View)localObject);
    AppMethodBeat.o(135474);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(135475);
    if (paramLayoutParams != null) {
      paramView.setLayoutParams(paramLayoutParams);
    }
    setContentView(paramView);
    AppMethodBeat.o(135475);
  }
  
  public void setOnCancelListener(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(135482);
    super.setOnCancelListener(paramOnCancelListener);
    this.jlV = paramOnCancelListener;
    AppMethodBeat.o(135482);
  }
  
  public void setOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(135479);
    super.setOnDismissListener(paramOnDismissListener);
    this.ngd = paramOnDismissListener;
    AppMethodBeat.o(135479);
  }
  
  public void setOnShowListener(DialogInterface.OnShowListener paramOnShowListener)
  {
    AppMethodBeat.i(135476);
    super.setOnShowListener(paramOnShowListener);
    this.ngl = paramOnShowListener;
    AppMethodBeat.o(135476);
  }
  
  public void show() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.b
 * JD-Core Version:    0.7.0.1
 */