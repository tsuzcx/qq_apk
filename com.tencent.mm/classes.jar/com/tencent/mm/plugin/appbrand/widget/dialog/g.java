package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.widget.a.j;
import com.tencent.mm.ui.widget.loading.MMProgressLoading;

public final class g
  extends j
  implements k, k.a
{
  private TextView JRT;
  private MMProgressLoading JRU;
  private View contentView;
  private m jCf;
  private DialogInterface.OnCancelListener kke;
  private DialogInterface.OnDismissListener opQ;
  private boolean ox;
  private boolean oy;
  private DialogInterface.OnShowListener zpS;
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(147741);
    this.ox = true;
    try
    {
      onCreate(null);
      label20:
      setContentView(2131497116);
      AppMethodBeat.o(147741);
      return;
    }
    catch (Exception paramContext)
    {
      break label20;
    }
  }
  
  public final void a(m paramm)
  {
    AppMethodBeat.i(147742);
    if (this.zpS != null) {
      this.zpS.onShow(this);
    }
    this.jCf = paramm;
    AppMethodBeat.o(147742);
  }
  
  public final boolean bjb()
  {
    return false;
  }
  
  public final boolean bjc()
  {
    return this.oy;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(147747);
    if (this.jCf != null)
    {
      this.jCf.c(this);
      if (this.opQ != null) {
        this.opQ.onDismiss(this);
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
    return this.ox;
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(147746);
    if (this.kke != null) {
      this.kke.onCancel(this);
    }
    AppMethodBeat.o(147746);
  }
  
  public final void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(147750);
    super.setCancelable(paramBoolean);
    this.ox = paramBoolean;
    AppMethodBeat.o(147750);
  }
  
  public final void setCanceledOnTouchOutside(boolean paramBoolean)
  {
    AppMethodBeat.i(147749);
    super.setCanceledOnTouchOutside(paramBoolean);
    this.oy = paramBoolean;
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
    AppMethodBeat.i(230014);
    this.contentView = paramView;
    this.JRT = ((TextView)this.contentView.findViewById(2131310641));
    AppMethodBeat.o(230014);
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
    AppMethodBeat.i(230015);
    this.JRT.setText(paramCharSequence);
    AppMethodBeat.o(230015);
  }
  
  public final void setOnCancelListener(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(147751);
    super.setOnCancelListener(paramOnCancelListener);
    this.kke = paramOnCancelListener;
    AppMethodBeat.o(147751);
  }
  
  public final void setOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(147748);
    super.setOnDismissListener(paramOnDismissListener);
    this.opQ = paramOnDismissListener;
    AppMethodBeat.o(147748);
  }
  
  public final void setOnShowListener(DialogInterface.OnShowListener paramOnShowListener)
  {
    AppMethodBeat.i(147745);
    super.setOnShowListener(paramOnShowListener);
    this.zpS = paramOnShowListener;
    AppMethodBeat.o(147745);
  }
  
  public final void setProgress(final int paramInt)
  {
    AppMethodBeat.i(230016);
    if (!MMHandlerThread.isMainThread())
    {
      this.contentView.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(230013);
          g.this.setProgress(paramInt);
          AppMethodBeat.o(230013);
        }
      });
      AppMethodBeat.o(230016);
      return;
    }
    if (this.JRU == null)
    {
      this.JRU = ((MMProgressLoading)this.contentView.findViewById(2131310642));
      this.JRU.setVisibility(0);
      this.contentView.findViewById(2131310640).setVisibility(8);
    }
    this.JRU.setProgress(paramInt);
    AppMethodBeat.o(230016);
  }
  
  public final void show() {}
  
  public final void ut(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.g
 * JD-Core Version:    0.7.0.1
 */