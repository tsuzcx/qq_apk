package com.tencent.mm.plugin.collect.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h.b;

final class CollectCreateQRCodeUI$4$1
  implements h.b
{
  CollectCreateQRCodeUI$4$1(CollectCreateQRCodeUI.4 param4) {}
  
  public final boolean onFinish(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(41233);
    if (!bo.isNullOrNil(paramCharSequence.toString()))
    {
      CollectCreateQRCodeUI.a(this.kRo.kRn, paramCharSequence.toString());
      CollectCreateQRCodeUI.c(this.kRo.kRn);
    }
    for (;;)
    {
      AppMethodBeat.o(41233);
      return true;
      CollectCreateQRCodeUI.a(this.kRo.kRn, "");
      CollectCreateQRCodeUI.c(this.kRo.kRn);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeUI.4.1
 * JD-Core Version:    0.7.0.1
 */