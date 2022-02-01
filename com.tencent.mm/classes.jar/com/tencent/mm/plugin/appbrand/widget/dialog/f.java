package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.l.a.d;
import com.tencent.luggage.l.a.e;
import com.tencent.luggage.l.a.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.widget.a.j;
import com.tencent.mm.ui.widget.loading.MMProgressLoading;

public final class f
  extends j
  implements j.a
{
  private boolean bxO;
  private boolean bxP;
  private View contentView;
  private l msa;
  private DialogInterface.OnCancelListener nbU;
  private DialogInterface.OnShowListener rrR;
  private DialogInterface.OnDismissListener rrn;
  private TextView rus;
  private MMProgressLoading rut;
  
  public f(Context paramContext)
  {
    super(paramContext, a.h.mmalertdialog);
    AppMethodBeat.i(147741);
    this.bxO = true;
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
  
  public final void a(l paraml)
  {
    AppMethodBeat.i(147742);
    if (this.rrR != null) {
      this.rrR.onShow(this);
    }
    this.msa = paraml;
    AppMethodBeat.o(147742);
  }
  
  public final boolean bsB()
  {
    return false;
  }
  
  public final boolean bsC()
  {
    return this.bxP;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(147747);
    if (this.msa != null)
    {
      this.msa.b(this);
      if (this.rrn != null) {
        this.rrn.onDismiss(this);
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
    return this.bxO;
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(147746);
    if (this.nbU != null) {
      this.nbU.onCancel(this);
    }
    AppMethodBeat.o(147746);
  }
  
  public final void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(147750);
    super.setCancelable(paramBoolean);
    this.bxO = paramBoolean;
    AppMethodBeat.o(147750);
  }
  
  public final void setCanceledOnTouchOutside(boolean paramBoolean)
  {
    AppMethodBeat.i(147749);
    super.setCanceledOnTouchOutside(paramBoolean);
    this.bxP = paramBoolean;
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
    AppMethodBeat.i(248476);
    this.contentView = paramView;
    this.rus = ((TextView)this.contentView.findViewById(a.d.wxa_progress_dialog_msg));
    AppMethodBeat.o(248476);
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
    AppMethodBeat.i(248481);
    this.rus.setText(paramCharSequence);
    AppMethodBeat.o(248481);
  }
  
  public final void setOnCancelListener(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(147751);
    super.setOnCancelListener(paramOnCancelListener);
    this.nbU = paramOnCancelListener;
    AppMethodBeat.o(147751);
  }
  
  public final void setOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(147748);
    super.setOnDismissListener(paramOnDismissListener);
    this.rrn = paramOnDismissListener;
    AppMethodBeat.o(147748);
  }
  
  public final void setOnShowListener(DialogInterface.OnShowListener paramOnShowListener)
  {
    AppMethodBeat.i(147745);
    super.setOnShowListener(paramOnShowListener);
    this.rrR = paramOnShowListener;
    AppMethodBeat.o(147745);
  }
  
  public final void setProgress(final int paramInt)
  {
    AppMethodBeat.i(248483);
    if (!MMHandlerThread.isMainThread())
    {
      this.contentView.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(238646);
          f.this.setProgress(paramInt);
          AppMethodBeat.o(238646);
        }
      });
      AppMethodBeat.o(248483);
      return;
    }
    if (this.rut == null)
    {
      this.rut = ((MMProgressLoading)this.contentView.findViewById(a.d.wxa_progress_dialog_progress_loading));
      this.rut.setVisibility(0);
      this.contentView.findViewById(a.d.wxa_progress_dialog_indeterminate_loading).setVisibility(8);
    }
    this.rut.setProgress(paramInt);
    AppMethodBeat.o(248483);
  }
  
  public final void show() {}
  
  public final void xu(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.f
 * JD-Core Version:    0.7.0.1
 */