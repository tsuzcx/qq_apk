package com.tencent.mm.plugin.expt.hellhound.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b;
import com.tencent.mm.protocal.protobuf.btm;
import com.tencent.mm.protocal.protobuf.cib;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  private static int afx(String paramString)
  {
    AppMethodBeat.i(122043);
    if (paramString == null)
    {
      AppMethodBeat.o(122043);
      return -1;
    }
    int i;
    if (x.AS(paramString)) {
      i = 4;
    }
    for (;;)
    {
      ae.i("HABBYGE-MALI.HellChattingType", "getChatType: %s, %d", new Object[] { paramString, Integer.valueOf(i) });
      AppMethodBeat.o(122043);
      return i;
      if ((x.Ba(paramString)) || (x.Af(paramString))) {
        i = 5;
      } else if (paramString.startsWith("gh_")) {
        i = 2;
      } else if (x.wb(paramString)) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  static com.tencent.mm.vending.j.c<String, Integer> cre()
  {
    AppMethodBeat.i(122041);
    Object localObject = b.aeU("Chat_User");
    ae.d("HABBYGE-MALI.HellChattingType", "getParamsOfChattingUI, userName: %s", new Object[] { localObject });
    int i = afx((String)localObject);
    ae.i("HABBYGE-MALI.HellChattingType", "getParamsOfChattingUI, chatType: %d", new Object[] { Integer.valueOf(i) });
    localObject = com.tencent.mm.vending.j.a.N(localObject, Integer.valueOf(i));
    AppMethodBeat.o(122041);
    return localObject;
  }
  
  static com.tencent.mm.vending.j.c<String, Integer> crf()
  {
    Object localObject3 = null;
    AppMethodBeat.i(122042);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.b.c.cpE();
    Object localObject2 = localObject3;
    if (localObject1 != null)
    {
      if (((cib)localObject1).Huj.isEmpty()) {
        localObject2 = localObject3;
      }
    }
    else
    {
      ae.d("HABBYGE-MALI.HellChattingType", "getParamsOfChattingUIFragment, userName: %s", new Object[] { localObject2 });
      int i = afx((String)localObject2);
      ae.i("HABBYGE-MALI.HellChattingType", "getParamsOfChattingUIFragment, chatType: %d", new Object[] { Integer.valueOf(i) });
      localObject1 = com.tencent.mm.vending.j.a.N(localObject2, Integer.valueOf(i));
      AppMethodBeat.o(122042);
      return localObject1;
    }
    Iterator localIterator = ((cib)localObject1).Huj.iterator();
    localObject1 = null;
    label94:
    if (localIterator.hasNext())
    {
      localObject2 = (btm)localIterator.next();
      if ((localObject2 == null) || (!"Chat_User".equals(((btm)localObject2).key))) {
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
      localObject2 = ((btm)localObject1).value;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.a
 * JD-Core Version:    0.7.0.1
 */