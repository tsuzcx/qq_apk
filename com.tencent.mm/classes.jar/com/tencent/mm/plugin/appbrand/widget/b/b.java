package com.tencent.mm.plugin.appbrand.widget.b;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.c;

public class b
  extends c
  implements k
{
  private View contentView;
  private DialogInterface.OnCancelListener gCt;
  private boolean gKc;
  private DialogInterface.OnShowListener jiT;
  private DialogInterface.OnDismissListener jiU;
  private boolean jiV;
  private l jiW;
  private boolean jiX;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(87509);
    this.gKc = true;
    this.jiX = false;
    setContentView(super.getContentView());
    setCanceledOnTouchOutside(false);
    AppMethodBeat.o(87509);
  }
  
  public b(Context paramContext, byte paramByte)
  {
    super(paramContext);
    this.gKc = true;
    this.jiX = false;
  }
  
  public final void a(l paraml)
  {
    AppMethodBeat.i(87510);
    if (this.jiT != null) {
      this.jiT.onShow(this);
    }
    this.jiW = paraml;
    AppMethodBeat.o(87510);
  }
  
  public final boolean aKF()
  {
    return this.jiV;
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(87517);
    if (this.jiX)
    {
      AppMethodBeat.o(87517);
      return;
    }
    this.jiX = true;
    if (this.jiW != null)
    {
      this.jiW.c(this);
      if (this.jiU != null) {
        this.jiU.onDismiss(this);
      }
    }
    AppMethodBeat.o(87517);
  }
  
  public final View getContentView()
  {
    AppMethodBeat.i(87511);
    if (this.contentView != null)
    {
      localView = this.contentView;
      AppMethodBeat.o(87511);
      return localView;
    }
    View localView = super.getContentView();
    AppMethodBeat.o(87511);
    return localView;
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
    AppMethodBeat.i(87516);
    if (this.gCt != null) {
      this.gCt.onCancel(this);
    }
    AppMethodBeat.o(87516);
  }
  
  public final void pq(int paramInt) {}
  
  public void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(87520);
    super.setCancelable(paramBoolean);
    this.gKc = paramBoolean;
    AppMethodBeat.o(87520);
  }
  
  public void setCanceledOnTouchOutside(boolean paramBoolean)
  {
    AppMethodBeat.i(87519);
    super.setCanceledOnTouchOutside(paramBoolean);
    this.jiV = paramBoolean;
    AppMethodBeat.o(87519);
  }
  
  public void setContentView(int paramInt)
  {
    AppMethodBeat.i(87512);
    setContentView(LayoutInflater.from(getContext()).inflate(paramInt, null));
    AppMethodBeat.o(87512);
  }
  
  public void setContentView(View paramView)
  {
    AppMethodBeat.i(87513);
    Object localObject = paramView;
    if (!(paramView instanceof a)) {
      localObject = new a(paramView.getContext(), paramView);
    }
    this.contentView = ((View)localObject);
    AppMethodBeat.o(87513);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(87514);
    if (paramLayoutParams != null) {
      paramView.setLayoutParams(paramLayoutParams);
    }
    setContentView(paramView);
    AppMethodBeat.o(87514);
  }
  
  public void setOnCancelListener(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(87521);
    super.setOnCancelListener(paramOnCancelListener);
    this.gCt = paramOnCancelListener;
    AppMethodBeat.o(87521);
  }
  
  public void setOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(87518);
    super.setOnDismissListener(paramOnDismissListener);
    this.jiU = paramOnDismissListener;
    AppMethodBeat.o(87518);
  }
  
  public void setOnShowListener(DialogInterface.OnShowListener paramOnShowListener)
  {
    AppMethodBeat.i(87515);
    super.setOnShowListener(paramOnShowListener);
    this.jiT = paramOnShowListener;
    AppMethodBeat.o(87515);
  }
  
  public void show() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.b
 * JD-Core Version:    0.7.0.1
 */