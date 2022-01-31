package com.tencent.mm.plugin.ipcall.ui;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ak;

final class IPCallMsgUI$7
  implements k.a
{
  IPCallMsgUI$7(IPCallMsgUI paramIPCallMsgUI) {}
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(22193);
    new ak(Looper.getMainLooper()).post(new IPCallMsgUI.7.1(this));
    AppMethodBeat.o(22193);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI.7
 * JD-Core Version:    0.7.0.1
 */