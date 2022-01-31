package com.tencent.mm.plugin.ipcall.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;

final class IPCallDynamicTextView$1
  extends ah
{
  IPCallDynamicTextView$1(IPCallDynamicTextView paramIPCallDynamicTextView) {}
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    if (((IPCallDynamicTextView.a(this.lvS) > 0.0D) && (IPCallDynamicTextView.b(this.lvS) < IPCallDynamicTextView.c(this.lvS))) || ((IPCallDynamicTextView.a(this.lvS) < 0.0D) && (IPCallDynamicTextView.b(this.lvS) > IPCallDynamicTextView.c(this.lvS))))
    {
      IPCallDynamicTextView.a(this.lvS, true);
      IPCallDynamicTextView.a(this.lvS, IPCallDynamicTextView.b(this.lvS));
      IPCallDynamicTextView.b(this.lvS, IPCallDynamicTextView.b(this.lvS) + IPCallDynamicTextView.a(this.lvS));
      IPCallDynamicTextView.e(this.lvS).sendEmptyMessageDelayed(1, IPCallDynamicTextView.d(this.lvS));
      return;
    }
    IPCallDynamicTextView.a(this.lvS, false);
    IPCallDynamicTextView.a(this.lvS, IPCallDynamicTextView.c(this.lvS));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallDynamicTextView.1
 * JD-Core Version:    0.7.0.1
 */