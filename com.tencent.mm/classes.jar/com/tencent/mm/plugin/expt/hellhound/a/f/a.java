package com.tencent.mm.plugin.expt.hellhound.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.w;
import com.tencent.mm.protocal.protobuf.bof;
import com.tencent.mm.protocal.protobuf.ccp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vending.j.c;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  private static int aaN(String paramString)
  {
    AppMethodBeat.i(122043);
    if (paramString == null)
    {
      AppMethodBeat.o(122043);
      return -1;
    }
    int i;
    if (w.xl(paramString)) {
      i = 4;
    }
    for (;;)
    {
      ac.i("HellChattingType", "HABBYGE-MALI, getChatType: %s, %d", new Object[] { paramString, Integer.valueOf(i) });
      AppMethodBeat.o(122043);
      return i;
      if ((w.xs(paramString)) || (w.wz(paramString))) {
        i = 5;
      } else if (paramString.startsWith("gh_")) {
        i = 2;
      } else if (w.sQ(paramString)) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  static c<String, Integer> ckn()
  {
    AppMethodBeat.i(122041);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.aan("Chat_User");
    ac.d("HellChattingType", "HABBYGE-MALI, getParamsOfChattingUI, userName: %s", new Object[] { localObject });
    int i = aaN((String)localObject);
    ac.i("HellChattingType", "HABBYGE-MALI, getParamsOfChattingUI, chatType: %d", new Object[] { Integer.valueOf(i) });
    localObject = com.tencent.mm.vending.j.a.L(localObject, Integer.valueOf(i));
    AppMethodBeat.o(122041);
    return localObject;
  }
  
  static c<String, Integer> cko()
  {
    Object localObject3 = null;
    AppMethodBeat.i(122042);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.b.b.cjc();
    Object localObject2 = localObject3;
    if (localObject1 != null)
    {
      if (((ccp)localObject1).Fra.isEmpty()) {
        localObject2 = localObject3;
      }
    }
    else
    {
      ac.d("HellChattingType", "HABBYGE-MALI, getParamsOfChattingUIFragment, userName: %s", new Object[] { localObject2 });
      int i = aaN((String)localObject2);
      ac.i("HellChattingType", "HABBYGE-MALI, getParamsOfChattingUIFragment, chatType: %d", new Object[] { Integer.valueOf(i) });
      localObject1 = com.tencent.mm.vending.j.a.L(localObject2, Integer.valueOf(i));
      AppMethodBeat.o(122042);
      return localObject1;
    }
    Iterator localIterator = ((ccp)localObject1).Fra.iterator();
    localObject1 = null;
    label94:
    if (localIterator.hasNext())
    {
      localObject2 = (bof)localIterator.next();
      if ((localObject2 == null) || (!"Chat_User".equals(((bof)localObject2).key))) {
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
      localObject2 = ((bof)localObject1).value;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.a
 * JD-Core Version:    0.7.0.1
 */