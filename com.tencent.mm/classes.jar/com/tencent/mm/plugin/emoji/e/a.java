package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory.Companion;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.plugin.gif.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public final class a
{
  static void XG(String paramString)
  {
    AppMethodBeat.i(108393);
    paramString = paramString.replace("delete", "").trim().split(",");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramString[i];
      ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XM(str).fdq();
      i += 1;
    }
    AppMethodBeat.o(108393);
  }
  
  static void XH(String paramString)
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
      paramString = az.faZ().GYn.aci().iterator();
      while (paramString.hasNext()) {
        ((EmojiInfo)paramString.next()).fdq();
      }
      AppMethodBeat.o(108394);
      return;
    }
    if (paramString[1].equals("customRandom"))
    {
      paramString = new Random();
      Iterator localIterator = az.faZ().GYn.aci().iterator();
      while (localIterator.hasNext())
      {
        EmojiInfo localEmojiInfo = (EmojiInfo)localIterator.next();
        if (paramString.nextBoolean()) {
          localEmojiInfo.fdq();
        }
      }
    }
    AppMethodBeat.o(108394);
  }
  
  static void XI(String paramString)
  {
    AppMethodBeat.i(108395);
    paramString = paramString.replace("add", "").trim().split(",");
    ArrayList localArrayList = new ArrayList();
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(new com.tencent.mm.plugin.emoji.sync.a.a(paramString[i], "", "", "", "", "", "", "", "", ""));
      i += 1;
    }
    k.ccn().pcK.cO(localArrayList);
    k.ccn().pcK.ccK();
    AppMethodBeat.o(108395);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.a
 * JD-Core Version:    0.7.0.1
 */