package com.tencent.mm.plugin.expt.hellhound.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b;
import com.tencent.mm.protocal.protobuf.cgh;
import com.tencent.mm.protocal.protobuf.cyi;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  private static int aqi(String paramString)
  {
    AppMethodBeat.i(122043);
    if (paramString == null)
    {
      AppMethodBeat.o(122043);
      return -1;
    }
    int i;
    if (ab.Jx(paramString)) {
      i = 4;
    }
    for (;;)
    {
      Log.i("HABBYGE-MALI.HellChattingType", "getChatType: %s, %d", new Object[] { paramString, Integer.valueOf(i) });
      AppMethodBeat.o(122043);
      return i;
      if ((ab.JF(paramString)) || (ab.IJ(paramString))) {
        i = 5;
      } else if (paramString.startsWith("gh_")) {
        i = 2;
      } else if (ab.Eq(paramString)) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  static com.tencent.mm.vending.j.c<String, Integer> cPM()
  {
    AppMethodBeat.i(122041);
    Object localObject = b.apk("Chat_User");
    Log.d("HABBYGE-MALI.HellChattingType", "getParamsOfChattingUI, userName: %s", new Object[] { localObject });
    int i = aqi((String)localObject);
    Log.i("HABBYGE-MALI.HellChattingType", "getParamsOfChattingUI, chatType: %d", new Object[] { Integer.valueOf(i) });
    localObject = com.tencent.mm.vending.j.a.Q(localObject, Integer.valueOf(i));
    AppMethodBeat.o(122041);
    return localObject;
  }
  
  static com.tencent.mm.vending.j.c<String, Integer> cPN()
  {
    Object localObject3 = null;
    AppMethodBeat.i(122042);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.b.c.cNX();
    Object localObject2 = localObject3;
    if (localObject1 != null)
    {
      if (((cyi)localObject1).MDh.isEmpty()) {
        localObject2 = localObject3;
      }
    }
    else
    {
      Log.d("HABBYGE-MALI.HellChattingType", "getParamsOfChattingUIFragment, userName: %s", new Object[] { localObject2 });
      int i = aqi((String)localObject2);
      Log.i("HABBYGE-MALI.HellChattingType", "getParamsOfChattingUIFragment, chatType: %d", new Object[] { Integer.valueOf(i) });
      localObject1 = com.tencent.mm.vending.j.a.Q(localObject2, Integer.valueOf(i));
      AppMethodBeat.o(122042);
      return localObject1;
    }
    Iterator localIterator = ((cyi)localObject1).MDh.iterator();
    localObject1 = null;
    label94:
    if (localIterator.hasNext())
    {
      localObject2 = (cgh)localIterator.next();
      if ((localObject2 == null) || (!"Chat_User".equals(((cgh)localObject2).key))) {
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
      localObject2 = ((cgh)localObject1).value;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.a
 * JD-Core Version:    0.7.0.1
 */