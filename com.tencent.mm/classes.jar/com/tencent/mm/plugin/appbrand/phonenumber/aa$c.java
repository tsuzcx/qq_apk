package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.os.CountDownTimer;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$VertifyTimer;", "Landroid/os/CountDownTimer;", "millisInFuture", "", "countDownInterval", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog;JJ)V", "onFinish", "", "onTick", "millisUntilFinished", "luggage-wechat-full-sdk_release"})
public final class aa$c
  extends CountDownTimer
{
  public aa$c(long paramLong1, long paramLong2)
  {
    super(???, localObject);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(148167);
    aa.c(this.mlJ);
    AppMethodBeat.o(148167);
  }
  
  public final void onTick(long paramLong)
  {
    AppMethodBeat.i(148166);
    TextView localTextView = aa.b(this.mlJ);
    if (localTextView != null)
    {
      localTextView.setText((CharSequence)this.mlJ.context.getString(2131755443, new Object[] { paramLong / 1000L }));
      AppMethodBeat.o(148166);
      return;
    }
    AppMethodBeat.o(148166);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.aa.c
 * JD-Core Version:    0.7.0.1
 */