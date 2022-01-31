package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class h$1
  implements t.a
{
  h$1(h paramh) {}
  
  public final void aY(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(42286);
    if (paramBoolean)
    {
      ab.i("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "the download image data is success! filePath:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(42286);
      return;
    }
    ab.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "download image fail!  filePath:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(42286);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.h.1
 * JD-Core Version:    0.7.0.1
 */