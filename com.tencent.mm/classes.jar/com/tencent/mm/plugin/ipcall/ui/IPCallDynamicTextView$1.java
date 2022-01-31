package com.tencent.mm.plugin.ipcall.ui;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class IPCallDynamicTextView$1
  extends ak
{
  IPCallDynamicTextView$1(IPCallDynamicTextView paramIPCallDynamicTextView) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(22142);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(22142);
      return;
      if (((IPCallDynamicTextView.a(this.nTh) > 0.0D) && (IPCallDynamicTextView.b(this.nTh) < IPCallDynamicTextView.c(this.nTh))) || ((IPCallDynamicTextView.a(this.nTh) < 0.0D) && (IPCallDynamicTextView.b(this.nTh) > IPCallDynamicTextView.c(this.nTh))))
      {
        IPCallDynamicTextView.a(this.nTh, true);
        IPCallDynamicTextView.a(this.nTh, IPCallDynamicTextView.b(this.nTh));
        IPCallDynamicTextView.b(this.nTh, IPCallDynamicTextView.b(this.nTh) + IPCallDynamicTextView.a(this.nTh));
        IPCallDynamicTextView.e(this.nTh).sendEmptyMessageDelayed(1, IPCallDynamicTextView.d(this.nTh));
        AppMethodBeat.o(22142);
        return;
      }
      IPCallDynamicTextView.a(this.nTh, false);
      IPCallDynamicTextView.a(this.nTh, IPCallDynamicTextView.c(this.nTh));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallDynamicTextView.1
 * JD-Core Version:    0.7.0.1
 */