package com.tencent.mm.plugin.emoji.ui;

import android.graphics.Bitmap;
import com.tencent.mm.as.a.c.l;
import com.tencent.mm.plugin.gif.i;
import com.tencent.mm.vfs.e;

final class EmojiCustomUI$17
  implements l
{
  public final Bitmap E(byte[] paramArrayOfByte)
  {
    return i.az(paramArrayOfByte);
  }
  
  public final Bitmap mw(String paramString)
  {
    return i.az(e.c(paramString, 0, -1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.17
 * JD-Core Version:    0.7.0.1
 */