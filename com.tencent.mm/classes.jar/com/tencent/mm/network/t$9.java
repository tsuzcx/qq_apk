package com.tencent.mm.network;

import com.tencent.mars.BaseEvent;
import com.tencent.mars.mm.MMLogic;
import com.tencent.mm.sdk.platformtools.bf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class t$9
  extends bf<Object>
{
  t$9(t paramt, Object paramObject, Map paramMap1, Map paramMap2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    super(3000L, paramObject, (byte)0);
  }
  
  public final Object run()
  {
    Iterator localIterator = this.eOe.entrySet().iterator();
    Map.Entry localEntry;
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      MMLogic.saveAuthLongIPs((String)localEntry.getKey(), (String[])((ArrayList)localEntry.getValue()).toArray(new String[0]));
    }
    localIterator = this.eOf.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      MMLogic.saveAuthShortIPs((String)localEntry.getKey(), (String[])((ArrayList)localEntry.getValue()).toArray(new String[0]));
    }
    MMLogic.saveAuthPorts(this.eOg, this.eOh);
    BaseEvent.onNetworkChange();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.network.t.9
 * JD-Core Version:    0.7.0.1
 */