package com.tencent.mm.plugin.expt.hellhound.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b;
import com.tencent.mm.protocal.protobuf.cpd;
import com.tencent.mm.protocal.protobuf.dhu;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  private static int ayi(String paramString)
  {
    AppMethodBeat.i(122043);
    if (paramString == null)
    {
      AppMethodBeat.o(122043);
      return -1;
    }
    int i;
    if (ab.QQ(paramString)) {
      i = 4;
    }
    for (;;)
    {
      Log.i("HABBYGE-MALI.HellChattingType", "getChatType: %s, %d", new Object[] { paramString, Integer.valueOf(i) });
      AppMethodBeat.o(122043);
      return i;
      if ((ab.QY(paramString)) || (ab.Qb(paramString))) {
        i = 5;
      } else if (paramString.startsWith("gh_")) {
        i = 2;
      } else if (ab.Lj(paramString)) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  static com.tencent.mm.vending.j.c<String, Integer> deG()
  {
    AppMethodBeat.i(122041);
    Object localObject = b.axk("Chat_User");
    Log.d("HABBYGE-MALI.HellChattingType", "getParamsOfChattingUI, userName: %s", new Object[] { localObject });
    int i = ayi((String)localObject);
    Log.i("HABBYGE-MALI.HellChattingType", "getParamsOfChattingUI, chatType: %d", new Object[] { Integer.valueOf(i) });
    localObject = com.tencent.mm.vending.j.a.J(localObject, Integer.valueOf(i));
    AppMethodBeat.o(122041);
    return localObject;
  }
  
  static com.tencent.mm.vending.j.c<String, Integer> deH()
  {
    Object localObject3 = null;
    AppMethodBeat.i(122042);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.b.c.dcP();
    Object localObject2 = localObject3;
    if (localObject1 != null)
    {
      if (((dhu)localObject1).TOQ.isEmpty()) {
        localObject2 = localObject3;
      }
    }
    else
    {
      Log.d("HABBYGE-MALI.HellChattingType", "getParamsOfChattingUIFragment, userName: %s", new Object[] { localObject2 });
      int i = ayi((String)localObject2);
      Log.i("HABBYGE-MALI.HellChattingType", "getParamsOfChattingUIFragment, chatType: %d", new Object[] { Integer.valueOf(i) });
      localObject1 = com.tencent.mm.vending.j.a.J(localObject2, Integer.valueOf(i));
      AppMethodBeat.o(122042);
      return localObject1;
    }
    Iterator localIterator = ((dhu)localObject1).TOQ.iterator();
    localObject1 = null;
    label94:
    if (localIterator.hasNext())
    {
      localObject2 = (cpd)localIterator.next();
      if ((localObject2 == null) || (!"Chat_User".equals(((cpd)localObject2).key))) {
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
      localObject2 = ((cpd)localObject1).value;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.a
 * JD-Core Version:    0.7.0.1
 */