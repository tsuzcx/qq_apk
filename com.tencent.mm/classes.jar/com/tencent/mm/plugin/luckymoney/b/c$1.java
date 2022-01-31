package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.j.d;
import com.tencent.mm.sdk.platformtools.y;

final class c$1
  implements k.a
{
  c$1(c paramc) {}
  
  public final void a(d paramd, String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      y.i("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "the download image data is success! filePath:" + paramString);
      return;
    }
    y.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "download image fail!  filePath:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.b.c.1
 * JD-Core Version:    0.7.0.1
 */