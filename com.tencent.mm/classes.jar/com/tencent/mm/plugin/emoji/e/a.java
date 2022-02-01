package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.j;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory.Companion;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.gif.h;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public final class a
{
  static void amh(String paramString)
  {
    AppMethodBeat.i(108393);
    paramString = paramString.replace("delete", "").trim().split(",");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramString[i];
      ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().amm(str).hRy();
      i += 1;
    }
    AppMethodBeat.o(108393);
  }
  
  static void ami(String paramString)
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
      paramString = bj.gCJ().Oqb.auO().iterator();
      while (paramString.hasNext()) {
        ((EmojiInfo)paramString.next()).hRy();
      }
      AppMethodBeat.o(108394);
      return;
    }
    if (paramString[1].equals("customRandom"))
    {
      paramString = new Random();
      Iterator localIterator = bj.gCJ().Oqb.auO().iterator();
      while (localIterator.hasNext())
      {
        EmojiInfo localEmojiInfo = (EmojiInfo)localIterator.next();
        if (paramString.nextBoolean()) {
          localEmojiInfo.hRy();
        }
      }
    }
    AppMethodBeat.o(108394);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.a
 * JD-Core Version:    0.7.0.1
 */