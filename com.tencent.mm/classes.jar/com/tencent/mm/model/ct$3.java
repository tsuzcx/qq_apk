package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.WeChatBrands.IReplaceApply;

final class ct$3
  implements WeChatBrands.IReplaceApply<String, String>
{
  WeChatBrands.IReplaceApply<String, String> onJ;
  
  ct$3()
  {
    AppMethodBeat.i(241994);
    this.onJ = ct.a.bDI();
    AppMethodBeat.o(241994);
  }
  
  public final void reload()
  {
    AppMethodBeat.i(241998);
    this.onJ.reload();
    AppMethodBeat.o(241998);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.ct.3
 * JD-Core Version:    0.7.0.1
 */