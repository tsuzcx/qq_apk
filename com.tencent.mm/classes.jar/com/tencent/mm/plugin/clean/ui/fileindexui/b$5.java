package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;

final class b$5
  extends ah
{
  b$5(b paramb) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if (!b.f(this.iCF)) {
      this.iCF.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.b.5
 * JD-Core Version:    0.7.0.1
 */