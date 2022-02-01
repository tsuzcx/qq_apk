package com.tencent.mm.plugin.expt.hellhound.ext.session;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b;
import com.tencent.mm.protocal.protobuf.dfx;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  private static int asn(String paramString)
  {
    AppMethodBeat.i(122043);
    if (paramString == null)
    {
      AppMethodBeat.o(122043);
      return -1;
    }
    int i;
    if (au.bwu(paramString)) {
      i = 4;
    }
    for (;;)
    {
      Log.i("HABBYGE-MALI.HellChattingType", "getChatType: %s, %d", new Object[] { paramString, Integer.valueOf(i) });
      AppMethodBeat.o(122043);
      return i;
      if ((ab.IW(paramString)) || (au.bxe(paramString))) {
        i = 5;
      } else if (paramString.startsWith("gh_")) {
        i = 2;
      } else if (au.bwE(paramString)) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  static com.tencent.mm.vending.j.c<String, Integer> dLv()
  {
    AppMethodBeat.i(122041);
    Object localObject = b.aro("Chat_User");
    Log.d("HABBYGE-MALI.HellChattingType", "getParamsOfChattingUI, userName: %s", new Object[] { localObject });
    int i = asn((String)localObject);
    Log.i("HABBYGE-MALI.HellChattingType", "getParamsOfChattingUI, chatType: %d", new Object[] { Integer.valueOf(i) });
    localObject = com.tencent.mm.vending.j.a.U(localObject, Integer.valueOf(i));
    AppMethodBeat.o(122041);
    return localObject;
  }
  
  static com.tencent.mm.vending.j.c<String, Integer> dLw()
  {
    Object localObject3 = null;
    AppMethodBeat.i(122042);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.b.c.dJr();
    Object localObject2 = localObject3;
    if (localObject1 != null)
    {
      if (((eae)localObject1).abfm.isEmpty()) {
        localObject2 = localObject3;
      }
    }
    else
    {
      Log.d("HABBYGE-MALI.HellChattingType", "getParamsOfChattingUIFragment, userName: %s", new Object[] { localObject2 });
      int i = asn((String)localObject2);
      Log.i("HABBYGE-MALI.HellChattingType", "getParamsOfChattingUIFragment, chatType: %d", new Object[] { Integer.valueOf(i) });
      localObject1 = com.tencent.mm.vending.j.a.U(localObject2, Integer.valueOf(i));
      AppMethodBeat.o(122042);
      return localObject1;
    }
    Iterator localIterator = ((eae)localObject1).abfm.iterator();
    localObject1 = null;
    label94:
    if (localIterator.hasNext())
    {
      localObject2 = (dfx)localIterator.next();
      if ((localObject2 == null) || (!"Chat_User".equals(((dfx)localObject2).key))) {
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
      localObject2 = ((dfx)localObject1).value;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.session.a
 * JD-Core Version:    0.7.0.1
 */