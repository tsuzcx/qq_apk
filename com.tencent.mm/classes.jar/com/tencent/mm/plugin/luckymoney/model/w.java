package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class w
{
  private Object lock;
  private Set<String> yWh;
  
  public w()
  {
    AppMethodBeat.i(65225);
    this.lock = new Object();
    this.yWh = new HashSet();
    Object localObject1 = (String)g.aAh().azQ().get(ar.a.Oac, "");
    if (!Util.isNullOrNil((String)localObject1))
    {
      localObject1 = ((String)localObject1).split(",");
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        this.yWh.add(localObject2);
        i += 1;
      }
    }
    AppMethodBeat.o(65225);
  }
  
  public final boolean aDu(String paramString)
  {
    AppMethodBeat.i(65226);
    synchronized (this.lock)
    {
      if (!this.yWh.contains(paramString))
      {
        StringBuilder localStringBuilder = new StringBuilder((String)g.aAh().azQ().get(ar.a.Oac, ""));
        if (this.yWh.size() <= 0)
        {
          localStringBuilder.append(paramString);
          g.aAh().azQ().set(ar.a.Oac, localStringBuilder.toString());
          boolean bool = this.yWh.add(paramString);
          AppMethodBeat.o(65226);
          return bool;
        }
        localStringBuilder.append(",").append(paramString);
      }
    }
    Log.i("MicroMsg.LuckyMoneyMsg", "has contains msg, %s", new Object[] { paramString });
    AppMethodBeat.o(65226);
    return false;
  }
  
  public final void aDv(String paramString)
  {
    AppMethodBeat.i(65227);
    synchronized (this.lock)
    {
      this.yWh.remove(paramString);
      paramString = new StringBuilder();
      Iterator localIterator = this.yWh.iterator();
      if (localIterator.hasNext()) {
        paramString.append((String)localIterator.next()).append(",");
      }
    }
    if (paramString.length() == 0) {}
    for (paramString = paramString.toString();; paramString = paramString.substring(0, paramString.length() - 1))
    {
      g.aAh().azQ().set(ar.a.Oac, paramString);
      AppMethodBeat.o(65227);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.w
 * JD-Core Version:    0.7.0.1
 */