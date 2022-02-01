package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a.i;

public class g
  extends i
  implements k, k.a
{
  private DialogInterface.OnShowListener KCx;
  private View contentView;
  private m hJu;
  private DialogInterface.OnCancelListener ipN;
  private boolean lA;
  private boolean lB;
  private DialogInterface.OnDismissListener lYl;
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(147741);
    this.lA = true;
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
    if (this.KCx != null) {
      this.KCx.onShow(this);
    }
    this.hJu = paramm;
    AppMethodBeat.o(147742);
  }
  
  public final boolean aEu()
  {
    return false;
  }
  
  public final boolean aEv()
  {
    return this.lB;
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(147747);
    if (this.hJu != null)
    {
      this.hJu.c(this);
      if (this.lYl != null) {
        this.lYl.onDismiss(this);
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
    return this.lA;
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(147746);
    if (this.ipN != null) {
      this.ipN.onCancel(this);
    }
    AppMethodBeat.o(147746);
  }
  
  public final void pi(int paramInt) {}
  
  public void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(147750);
    super.setCancelable(paramBoolean);
    this.lA = paramBoolean;
    AppMethodBeat.o(147750);
  }
  
  public void setCanceledOnTouchOutside(boolean paramBoolean)
  {
    AppMethodBeat.i(147749);
    super.setCanceledOnTouchOutside(paramBoolean);
    this.lB = paramBoolean;
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
    this.ipN = paramOnCancelListener;
    AppMethodBeat.o(147751);
  }
  
  public void setOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(147748);
    super.setOnDismissListener(paramOnDismissListener);
    this.lYl = paramOnDismissListener;
    AppMethodBeat.o(147748);
  }
  
  public void setOnShowListener(DialogInterface.OnShowListener paramOnShowListener)
  {
    AppMethodBeat.i(147745);
    super.setOnShowListener(paramOnShowListener);
    this.KCx = paramOnShowListener;
    AppMethodBeat.o(147745);
  }
  
  public void show() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.g
 * JD-Core Version:    0.7.0.1
 */