package com.tencent.mm.plugin.collect.ui;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.h.b;

final class CollectCreateQRCodeUI$4$1
  implements h.b
{
  CollectCreateQRCodeUI$4$1(CollectCreateQRCodeUI.4 param4) {}
  
  public final boolean m(CharSequence paramCharSequence)
  {
    if (!bk.bl(paramCharSequence.toString()))
    {
      CollectCreateQRCodeUI.a(this.iKJ.iKI, paramCharSequence.toString());
      CollectCreateQRCodeUI.c(this.iKJ.iKI);
    }
    for (;;)
    {
      return true;
      CollectCreateQRCodeUI.a(this.iKJ.iKI, "");
      CollectCreateQRCodeUI.c(this.iKJ.iKI);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeUI.4.1
 * JD-Core Version:    0.7.0.1
 */