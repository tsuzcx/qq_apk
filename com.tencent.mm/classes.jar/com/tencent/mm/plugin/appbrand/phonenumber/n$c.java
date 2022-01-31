package com.tencent.mm.plugin.appbrand.phonenumber;

import a.l;
import android.content.Context;
import android.os.CountDownTimer;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$VertifyTimer;", "Landroid/os/CountDownTimer;", "millisInFuture", "", "countDownInterval", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog;JJ)V", "onFinish", "", "onTick", "millisUntilFinished", "plugin-appbrand-integration_release"})
public final class n$c
  extends CountDownTimer
{
  public n$c(long paramLong1, long paramLong2)
  {
    super(???, localObject);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(134897);
    n.c(this.iEE);
    AppMethodBeat.o(134897);
  }
  
  public final void onTick(long paramLong)
  {
    AppMethodBeat.i(134896);
    TextView localTextView = n.b(this.iEE);
    if (localTextView != null)
    {
      localTextView.setText((CharSequence)this.iEE.context.getString(2131296664, new Object[] { paramLong / 1000L }));
      AppMethodBeat.o(134896);
      return;
    }
    AppMethodBeat.o(134896);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.n.c
 * JD-Core Version:    0.7.0.1
 */