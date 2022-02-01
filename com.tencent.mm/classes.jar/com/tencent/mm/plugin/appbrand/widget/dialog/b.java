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
  private m jCf;
  private DialogInterface.OnCancelListener kke;
  private DialogInterface.OnDismissListener opQ;
  private boolean ox;
  private boolean oy;
  private boolean zZh;
  private DialogInterface.OnShowListener zpS;
  
  public b(Context paramContext)
  {
    super(paramContext, (byte)0);
    AppMethodBeat.i(135470);
    this.ox = true;
    this.zZh = false;
    setContentView(super.getContentView());
    setCanceledOnTouchOutside(false);
    AppMethodBeat.o(135470);
  }
  
  public b(Context paramContext, byte paramByte)
  {
    super(paramContext, (byte)0);
    this.ox = true;
    this.zZh = false;
  }
  
  public final void a(m paramm)
  {
    AppMethodBeat.i(135471);
    if (this.zpS != null) {
      this.zpS.onShow(this);
    }
    this.jCf = paramm;
    AppMethodBeat.o(135471);
  }
  
  public final boolean bjb()
  {
    return false;
  }
  
  public final boolean bjc()
  {
    return this.oy;
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(135478);
    if (this.zZh)
    {
      AppMethodBeat.o(135478);
      return;
    }
    this.zZh = true;
    if (this.jCf != null)
    {
      this.jCf.c(this);
      if (this.opQ != null) {
        this.opQ.onDismiss(this);
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
    return this.ox;
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(135477);
    if (this.kke != null) {
      this.kke.onCancel(this);
    }
    AppMethodBeat.o(135477);
  }
  
  public void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(135481);
    super.setCancelable(paramBoolean);
    this.ox = paramBoolean;
    AppMethodBeat.o(135481);
  }
  
  public void setCanceledOnTouchOutside(boolean paramBoolean)
  {
    AppMethodBeat.i(135480);
    super.setCanceledOnTouchOutside(paramBoolean);
    this.oy = paramBoolean;
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
    this.kke = paramOnCancelListener;
    AppMethodBeat.o(135482);
  }
  
  public void setOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(135479);
    super.setOnDismissListener(paramOnDismissListener);
    this.opQ = paramOnDismissListener;
    AppMethodBeat.o(135479);
  }
  
  public void setOnShowListener(DialogInterface.OnShowListener paramOnShowListener)
  {
    AppMethodBeat.i(135476);
    super.setOnShowListener(paramOnShowListener);
    this.zpS = paramOnShowListener;
    AppMethodBeat.o(135476);
  }
  
  public void show() {}
  
  public final void ut(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.b
 * JD-Core Version:    0.7.0.1
 */