package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory.Companion;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.gif.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public final class a
{
  static void abn(String paramString)
  {
    AppMethodBeat.i(108393);
    paramString = paramString.replace("delete", "").trim().split(",");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramString[i];
      ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abs(str).fOv();
      i += 1;
    }
    AppMethodBeat.o(108393);
  }
  
  static void abo(String paramString)
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
      paramString = bd.frc().ILB.aeM().iterator();
      while (paramString.hasNext()) {
        ((EmojiInfo)paramString.next()).fOv();
      }
      AppMethodBeat.o(108394);
      return;
    }
    if (paramString[1].equals("customRandom"))
    {
      paramString = new Random();
      Iterator localIterator = bd.frc().ILB.aeM().iterator();
      while (localIterator.hasNext())
      {
        EmojiInfo localEmojiInfo = (EmojiInfo)localIterator.next();
        if (paramString.nextBoolean()) {
          localEmojiInfo.fOv();
        }
      }
    }
    AppMethodBeat.o(108394);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.a
 * JD-Core Version:    0.7.0.1
 */