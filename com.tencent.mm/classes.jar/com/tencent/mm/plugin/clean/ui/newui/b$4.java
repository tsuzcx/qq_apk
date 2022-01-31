package com.tencent.mm.plugin.clean.ui.newui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;

final class b$4
  extends ah
{
  b$4(b paramb) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if (!b.b(this.iDX)) {
      this.iDX.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.newui.b.4
 * JD-Core Version:    0.7.0.1
 */