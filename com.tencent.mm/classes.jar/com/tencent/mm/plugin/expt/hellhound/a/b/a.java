package com.tencent.mm.plugin.expt.hellhound.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.t;
import com.tencent.mm.protocal.protobuf.azc;
import com.tencent.mm.protocal.protobuf.bkf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.j.c;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  private static int Mt(String paramString)
  {
    AppMethodBeat.i(152317);
    if (paramString == null)
    {
      AppMethodBeat.o(152317);
      return -1;
    }
    int i;
    if (t.oy(paramString)) {
      i = 4;
    }
    for (;;)
    {
      ab.w("HellChattingType", "habbyge-mali, getChatType: " + paramString + ", " + i);
      AppMethodBeat.o(152317);
      return i;
      if ((t.oE(paramString)) || (t.nP(paramString))) {
        i = 5;
      } else if (paramString.startsWith("gh_")) {
        i = 2;
      } else if (t.lA(paramString)) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  static c<String, Integer> brW()
  {
    AppMethodBeat.i(152315);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.b.Mq("Chat_User");
    ab.d("HellChattingType", "HABBYGE-MALI, getParamsOfChattingUI, userName: ".concat(String.valueOf(localObject)));
    int i = Mt((String)localObject);
    ab.w("HellChattingType", "HABBYGE-MALI, getParamsOfChattingUI, chatType: ".concat(String.valueOf(i)));
    localObject = com.tencent.mm.vending.j.a.C(localObject, Integer.valueOf(i));
    AppMethodBeat.o(152315);
    return localObject;
  }
  
  static c<String, Integer> brX()
  {
    Object localObject3 = null;
    AppMethodBeat.i(152316);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.core.v2.a.b.brN();
    Object localObject2 = localObject3;
    if (localObject1 != null)
    {
      if (((bkf)localObject1).xyH.isEmpty()) {
        localObject2 = localObject3;
      }
    }
    else
    {
      ab.d("HellChattingType", "HABBYGE-MALI, getParamsOfChattingUIFragment, userName: ".concat(String.valueOf(localObject2)));
      int i = Mt((String)localObject2);
      ab.w("HellChattingType", "HABBYGE-MALI, getParamsOfChattingUIFragment, chatType: ".concat(String.valueOf(i)));
      localObject1 = com.tencent.mm.vending.j.a.C(localObject2, Integer.valueOf(i));
      AppMethodBeat.o(152316);
      return localObject1;
    }
    Iterator localIterator = ((bkf)localObject1).xyH.iterator();
    localObject1 = null;
    label89:
    if (localIterator.hasNext())
    {
      localObject2 = (azc)localIterator.next();
      if ((localObject2 == null) || (!"Chat_User".equals(((azc)localObject2).key))) {
        break label145;
      }
      localObject1 = localObject2;
    }
    label145:
    for (;;)
    {
      break label89;
      localObject2 = localObject3;
      if (localObject1 == null) {
        break;
      }
      localObject2 = ((azc)localObject1).value;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a
 * JD-Core Version:    0.7.0.1
 */