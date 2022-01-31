package com.tencent.mm.plugin.ipcall.ui;

import android.os.Looper;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ah;

final class IPCallMsgUI$7
  implements j.a
{
  IPCallMsgUI$7(IPCallMsgUI paramIPCallMsgUI) {}
  
  public final void a(String paramString, l paraml)
  {
    new ah(Looper.getMainLooper()).post(new IPCallMsgUI.7.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI.7
 * JD-Core Version:    0.7.0.1
 */