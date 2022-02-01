package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a.e;

public class b
  extends e
  implements n
{
  private View contentView;
  private boolean dqR;
  private boolean dqS;
  private r plF;
  private DialogInterface.OnCancelListener qbI;
  private DialogInterface.OnShowListener uBL;
  private DialogInterface.OnDismissListener uBy;
  private boolean uCf;
  
  public b(Context paramContext)
  {
    super(paramContext, (byte)0);
    AppMethodBeat.i(135470);
    this.dqR = true;
    this.uCf = false;
    setContentView(super.getContentView());
    setCanceledOnTouchOutside(false);
    AppMethodBeat.o(135470);
  }
  
  public b(Context paramContext, byte paramByte)
  {
    super(paramContext, (byte)0);
    this.dqR = true;
    this.uCf = false;
  }
  
  public final void a(r paramr)
  {
    AppMethodBeat.i(135471);
    if (this.uBL != null) {
      this.uBL.onShow(this);
    }
    this.plF = paramr;
    AppMethodBeat.o(135471);
  }
  
  public final boolean bQg()
  {
    return false;
  }
  
  public final void bQh()
  {
    AppMethodBeat.i(324691);
    View localView = getContentView();
    if (localView != null) {
      com.tencent.mm.plugin.appbrand.widget.a.a.dQ(localView);
    }
    AppMethodBeat.o(324691);
  }
  
  public final boolean bQi()
  {
    return this.dqS;
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(135478);
    if (this.uCf)
    {
      AppMethodBeat.o(135478);
      return;
    }
    this.uCf = true;
    if (this.plF != null)
    {
      this.plF.c(this);
      if (this.uBy != null) {
        this.uBy.onDismiss(this);
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
    return this.dqR;
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(135477);
    if (this.qbI != null) {
      this.qbI.onCancel(this);
    }
    AppMethodBeat.o(135477);
  }
  
  public void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(135481);
    super.setCancelable(paramBoolean);
    this.dqR = paramBoolean;
    AppMethodBeat.o(135481);
  }
  
  public void setCanceledOnTouchOutside(boolean paramBoolean)
  {
    AppMethodBeat.i(135480);
    super.setCanceledOnTouchOutside(paramBoolean);
    this.dqS = paramBoolean;
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
    this.qbI = paramOnCancelListener;
    AppMethodBeat.o(135482);
  }
  
  public void setOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(135479);
    super.setOnDismissListener(paramOnDismissListener);
    this.uBy = paramOnDismissListener;
    AppMethodBeat.o(135479);
  }
  
  public void setOnShowListener(DialogInterface.OnShowListener paramOnShowListener)
  {
    AppMethodBeat.i(135476);
    super.setOnShowListener(paramOnShowListener);
    this.uBL = paramOnShowListener;
    AppMethodBeat.o(135476);
  }
  
  public void show() {}
  
  public final void xt(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.b
 * JD-Core Version:    0.7.0.1
 */