package com.tencent.mm.plugin.emoji.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.c.l;
import com.tencent.mm.plugin.gif.i;
import com.tencent.mm.vfs.e;

final class EmojiCustomUI$17
  implements l
{
  public final Bitmap U(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(53316);
    paramArrayOfByte = i.aX(paramArrayOfByte);
    AppMethodBeat.o(53316);
    return paramArrayOfByte;
  }
  
  public final Bitmap tG(String paramString)
  {
    AppMethodBeat.i(53317);
    paramString = i.aX(e.i(paramString, 0, -1));
    AppMethodBeat.o(53317);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.17
 * JD-Core Version:    0.7.0.1
 */