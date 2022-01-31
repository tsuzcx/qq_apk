package com.tencent.mm.network;

import com.tencent.mars.BaseEvent;
import com.tencent.mars.mm.MMLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class t$10
  extends bj<Object>
{
  t$10(t paramt, Object paramObject, Map paramMap1, Map paramMap2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    super(3000L, paramObject, (byte)0);
  }
  
  public final Object run()
  {
    AppMethodBeat.i(58560);
    Iterator localIterator = this.gdS.entrySet().iterator();
    Map.Entry localEntry;
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      try
      {
        MMLogic.saveAuthLongIPs((String)localEntry.getKey(), (String[])((ArrayList)localEntry.getValue()).toArray(new String[0]));
      }
      catch (Throwable localThrowable)
      {
        MMLogic.saveAuthLongIPs((String)localEntry.getKey(), (String[])((ArrayList)localEntry.getValue()).toArray(new String[0]));
      }
    }
    localIterator = this.gdT.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      MMLogic.saveAuthShortIPs((String)localEntry.getKey(), (String[])((ArrayList)localEntry.getValue()).toArray(new String[0]));
    }
    MMLogic.saveAuthPorts(this.gdU, this.gdV);
    BaseEvent.onNetworkChange();
    AppMethodBeat.o(58560);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.network.t.10
 * JD-Core Version:    0.7.0.1
 */