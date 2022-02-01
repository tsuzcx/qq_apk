package com.tencent.mm.plugin.expt.hellhound.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.w;
import com.tencent.mm.protocal.protobuf.bkl;
import com.tencent.mm.protocal.protobuf.bxu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vending.j.c;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  private static int Wq(String paramString)
  {
    AppMethodBeat.i(122043);
    if (paramString == null)
    {
      AppMethodBeat.o(122043);
      return -1;
    }
    int i;
    if (w.ti(paramString)) {
      i = 4;
    }
    for (;;)
    {
      ad.i("HellChattingType", "HABBYGE-MALI, getChatType: %s, %d", new Object[] { paramString, Integer.valueOf(i) });
      AppMethodBeat.o(122043);
      return i;
      if ((w.tp(paramString)) || (w.sw(paramString))) {
        i = 5;
      } else if (paramString.startsWith("gh_")) {
        i = 2;
      } else if (w.pF(paramString)) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  static c<String, Integer> ccF()
  {
    AppMethodBeat.i(122041);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.VY("Chat_User");
    ad.d("HellChattingType", "HABBYGE-MALI, getParamsOfChattingUI, userName: %s", new Object[] { localObject });
    int i = Wq((String)localObject);
    ad.i("HellChattingType", "HABBYGE-MALI, getParamsOfChattingUI, chatType: %d", new Object[] { Integer.valueOf(i) });
    localObject = com.tencent.mm.vending.j.a.L(localObject, Integer.valueOf(i));
    AppMethodBeat.o(122041);
    return localObject;
  }
  
  static c<String, Integer> ccG()
  {
    Object localObject3 = null;
    AppMethodBeat.i(122042);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.b.b.cbR();
    Object localObject2 = localObject3;
    if (localObject1 != null)
    {
      if (((bxu)localObject1).DUn.isEmpty()) {
        localObject2 = localObject3;
      }
    }
    else
    {
      ad.d("HellChattingType", "HABBYGE-MALI, getParamsOfChattingUIFragment, userName: %s", new Object[] { localObject2 });
      int i = Wq((String)localObject2);
      ad.i("HellChattingType", "HABBYGE-MALI, getParamsOfChattingUIFragment, chatType: %d", new Object[] { Integer.valueOf(i) });
      localObject1 = com.tencent.mm.vending.j.a.L(localObject2, Integer.valueOf(i));
      AppMethodBeat.o(122042);
      return localObject1;
    }
    Iterator localIterator = ((bxu)localObject1).DUn.iterator();
    localObject1 = null;
    label94:
    if (localIterator.hasNext())
    {
      localObject2 = (bkl)localIterator.next();
      if ((localObject2 == null) || (!"Chat_User".equals(((bkl)localObject2).key))) {
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
      localObject2 = ((bkl)localObject1).value;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.a
 * JD-Core Version:    0.7.0.1
 */