package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.m.a.d;
import com.tencent.luggage.m.a.e;
import com.tencent.luggage.m.a.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.widget.a.m;
import com.tencent.mm.ui.widget.loading.MMProgressLoading;

public final class j
  extends m
  implements n.a
{
  private View contentView;
  private boolean dqR;
  private boolean dqS;
  private r plF;
  private DialogInterface.OnCancelListener qbI;
  private DialogInterface.OnShowListener uBL;
  private DialogInterface.OnDismissListener uBy;
  private TextView uEX;
  private MMProgressLoading uEY;
  
  public j(Context paramContext)
  {
    super(paramContext, a.h.mmalertdialog);
    AppMethodBeat.i(147741);
    this.dqR = true;
    try
    {
      onCreate(null);
      label23:
      setContentView(a.e.wxa_progress_dialog);
      AppMethodBeat.o(147741);
      return;
    }
    catch (Exception paramContext)
    {
      break label23;
    }
  }
  
  public final void a(r paramr)
  {
    AppMethodBeat.i(147742);
    if (this.uBL != null) {
      this.uBL.onShow(this);
    }
    this.plF = paramr;
    AppMethodBeat.o(147742);
  }
  
  public final boolean bQg()
  {
    return false;
  }
  
  public final void bQh() {}
  
  public final boolean bQi()
  {
    return this.dqS;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(147747);
    if (this.plF != null)
    {
      this.plF.c(this);
      if (this.uBy != null) {
        this.uBy.onDismiss(this);
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
    return this.dqR;
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(147746);
    if (this.qbI != null) {
      this.qbI.onCancel(this);
    }
    AppMethodBeat.o(147746);
  }
  
  public final void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(147750);
    super.setCancelable(paramBoolean);
    this.dqR = paramBoolean;
    AppMethodBeat.o(147750);
  }
  
  public final void setCanceledOnTouchOutside(boolean paramBoolean)
  {
    AppMethodBeat.i(147749);
    super.setCanceledOnTouchOutside(paramBoolean);
    this.dqS = paramBoolean;
    AppMethodBeat.o(147749);
  }
  
  public final void setContentView(int paramInt)
  {
    AppMethodBeat.i(147743);
    setContentView(LayoutInflater.from(getContext()).inflate(paramInt, null));
    AppMethodBeat.o(147743);
  }
  
  public final void setContentView(View paramView)
  {
    AppMethodBeat.i(324745);
    this.contentView = paramView;
    this.uEX = ((TextView)this.contentView.findViewById(a.d.wxa_progress_dialog_msg));
    AppMethodBeat.o(324745);
  }
  
  public final void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(147744);
    if (paramLayoutParams != null) {
      paramView.setLayoutParams(paramLayoutParams);
    }
    setContentView(paramView);
    AppMethodBeat.o(147744);
  }
  
  public final void setMessage(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(324772);
    this.uEX.setText(paramCharSequence);
    AppMethodBeat.o(324772);
  }
  
  public final void setOnCancelListener(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(147751);
    super.setOnCancelListener(paramOnCancelListener);
    this.qbI = paramOnCancelListener;
    AppMethodBeat.o(147751);
  }
  
  public final void setOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(147748);
    super.setOnDismissListener(paramOnDismissListener);
    this.uBy = paramOnDismissListener;
    AppMethodBeat.o(147748);
  }
  
  public final void setOnShowListener(DialogInterface.OnShowListener paramOnShowListener)
  {
    AppMethodBeat.i(147745);
    super.setOnShowListener(paramOnShowListener);
    this.uBL = paramOnShowListener;
    AppMethodBeat.o(147745);
  }
  
  public final void setProgress(final int paramInt)
  {
    AppMethodBeat.i(324774);
    if (!MMHandlerThread.isMainThread())
    {
      this.contentView.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(324710);
          j.this.setProgress(paramInt);
          AppMethodBeat.o(324710);
        }
      });
      AppMethodBeat.o(324774);
      return;
    }
    if (this.uEY == null)
    {
      this.uEY = ((MMProgressLoading)this.contentView.findViewById(a.d.wxa_progress_dialog_progress_loading));
      this.uEY.setVisibility(0);
      this.contentView.findViewById(a.d.wxa_progress_dialog_indeterminate_loading).setVisibility(8);
    }
    this.uEY.setProgress(paramInt);
    AppMethodBeat.o(324774);
  }
  
  public final void show() {}
  
  public final void xt(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.j
 * JD-Core Version:    0.7.0.1
 */