package com.tencent.mm.plugin.expt.hellhound.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b;
import com.tencent.mm.protocal.protobuf.bss;
import com.tencent.mm.protocal.protobuf.chh;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  private static int aeB(String paramString)
  {
    AppMethodBeat.i(122043);
    if (paramString == null)
    {
      AppMethodBeat.o(122043);
      return -1;
    }
    int i;
    if (w.Ai(paramString)) {
      i = 4;
    }
    for (;;)
    {
      ad.i("HABBYGE-MALI.HellChattingType", "getChatType: %s, %d", new Object[] { paramString, Integer.valueOf(i) });
      AppMethodBeat.o(122043);
      return i;
      if ((w.Aq(paramString)) || (w.zv(paramString))) {
        i = 5;
      } else if (paramString.startsWith("gh_")) {
        i = 2;
      } else if (w.vF(paramString)) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  static com.tencent.mm.vending.j.c<String, Integer> cpC()
  {
    AppMethodBeat.i(122041);
    Object localObject = b.aea("Chat_User");
    ad.d("HABBYGE-MALI.HellChattingType", "getParamsOfChattingUI, userName: %s", new Object[] { localObject });
    int i = aeB((String)localObject);
    ad.i("HABBYGE-MALI.HellChattingType", "getParamsOfChattingUI, chatType: %d", new Object[] { Integer.valueOf(i) });
    localObject = com.tencent.mm.vending.j.a.N(localObject, Integer.valueOf(i));
    AppMethodBeat.o(122041);
    return localObject;
  }
  
  static com.tencent.mm.vending.j.c<String, Integer> cpD()
  {
    Object localObject3 = null;
    AppMethodBeat.i(122042);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.b.c.coc();
    Object localObject2 = localObject3;
    if (localObject1 != null)
    {
      if (((chh)localObject1).HaJ.isEmpty()) {
        localObject2 = localObject3;
      }
    }
    else
    {
      ad.d("HABBYGE-MALI.HellChattingType", "getParamsOfChattingUIFragment, userName: %s", new Object[] { localObject2 });
      int i = aeB((String)localObject2);
      ad.i("HABBYGE-MALI.HellChattingType", "getParamsOfChattingUIFragment, chatType: %d", new Object[] { Integer.valueOf(i) });
      localObject1 = com.tencent.mm.vending.j.a.N(localObject2, Integer.valueOf(i));
      AppMethodBeat.o(122042);
      return localObject1;
    }
    Iterator localIterator = ((chh)localObject1).HaJ.iterator();
    localObject1 = null;
    label94:
    if (localIterator.hasNext())
    {
      localObject2 = (bss)localIterator.next();
      if ((localObject2 == null) || (!"Chat_User".equals(((bss)localObject2).key))) {
        break label150;
      }
      localObject1 = localObject2;
    }
    label150:
    for (;;)
    {
      break label94;
      localObject2 = localObject3;
      if (localObject1 == null) {
        break;
      }
      localObject2 = ((bss)localObject1).value;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.a
 * JD-Core Version:    0.7.0.1
 */