package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public final class b
{
  static void Ko(String paramString)
  {
    AppMethodBeat.i(52823);
    paramString = paramString.replace("delete", "").trim().split(",");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramString[i];
      ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Ku(str).dzo();
      i += 1;
    }
    AppMethodBeat.o(52823);
  }
  
  static void Kp(String paramString)
  {
    AppMethodBeat.i(52824);
    paramString = paramString.split(" ");
    if (paramString.length <= 1)
    {
      AppMethodBeat.o(52824);
      return;
    }
    if (paramString[1].equals("custom"))
    {
      paramString = at.dxt().yNz.OA().iterator();
      while (paramString.hasNext()) {
        ((EmojiInfo)paramString.next()).dzo();
      }
      AppMethodBeat.o(52824);
      return;
    }
    if (paramString[1].equals("customRandom"))
    {
      paramString = new Random();
      Iterator localIterator = at.dxt().yNz.OA().iterator();
      while (localIterator.hasNext())
      {
        EmojiInfo localEmojiInfo = (EmojiInfo)localIterator.next();
        if (paramString.nextBoolean()) {
          localEmojiInfo.dzo();
        }
      }
    }
    AppMethodBeat.o(52824);
  }
  
  static void Kq(String paramString)
  {
    AppMethodBeat.i(52825);
    paramString = paramString.replace("add", "").trim().split(",");
    ArrayList localArrayList = new ArrayList();
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(new com.tencent.mm.plugin.emoji.sync.a.a(paramString[i], "", "", "", "", "", "", "", "", ""));
      i += 1;
    }
    i.blq().lje.bp(localArrayList);
    i.blq().lje.blM();
    AppMethodBeat.o(52825);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.b
 * JD-Core Version:    0.7.0.1
 */