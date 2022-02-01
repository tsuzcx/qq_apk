package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class LuckyMoneyC2CNYPredownloadImgListener$1
  implements ab.a
{
  LuckyMoneyC2CNYPredownloadImgListener$1(LuckyMoneyC2CNYPredownloadImgListener paramLuckyMoneyC2CNYPredownloadImgListener) {}
  
  public final void cp(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(65176);
    if (paramBoolean)
    {
      Log.i("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "the download image data is success! filePath:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(65176);
      return;
    }
    Log.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "download image fail!  filePath:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(65176);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.LuckyMoneyC2CNYPredownloadImgListener.1
 * JD-Core Version:    0.7.0.1
 */