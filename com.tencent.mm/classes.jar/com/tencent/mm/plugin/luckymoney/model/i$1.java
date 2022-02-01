package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

final class i$1
  implements v.a
{
  i$1(i parami) {}
  
  public final void bo(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(65176);
    if (paramBoolean)
    {
      ac.i("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "the download image data is success! filePath:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(65176);
      return;
    }
    ac.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "download image fail!  filePath:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(65176);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.i.1
 * JD-Core Version:    0.7.0.1
 */