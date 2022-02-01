package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.i;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory.Companion;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.gif.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.vfs.o;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public final class a
{
  static void ace(String paramString)
  {
    AppMethodBeat.i(108393);
    paramString = paramString.replace("delete", "").trim().split(",");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramString[i];
      ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().acj(str).fxo();
      i += 1;
    }
    AppMethodBeat.o(108393);
  }
  
  static void acf(String paramString)
  {
    AppMethodBeat.i(108394);
    paramString = paramString.split(" ");
    if (paramString.length <= 1)
    {
      AppMethodBeat.o(108394);
      return;
    }
    if (paramString[1].equals("custom"))
    {
      paramString = be.fvc().Jgi.afa().iterator();
      while (paramString.hasNext()) {
        ((EmojiInfo)paramString.next()).fxo();
      }
      AppMethodBeat.o(108394);
      return;
    }
    if (paramString[1].equals("customRandom"))
    {
      paramString = new Random();
      Iterator localIterator = be.fvc().Jgi.afa().iterator();
      while (localIterator.hasNext())
      {
        EmojiInfo localEmojiInfo = (EmojiInfo)localIterator.next();
        if (paramString.nextBoolean()) {
          localEmojiInfo.fxo();
        }
      }
    }
    AppMethodBeat.o(108394);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.a
 * JD-Core Version:    0.7.0.1
 */