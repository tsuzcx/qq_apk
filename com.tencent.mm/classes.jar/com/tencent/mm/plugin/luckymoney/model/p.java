package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class p
{
  private Object lock;
  private Set<String> ooi;
  
  public p()
  {
    AppMethodBeat.i(42336);
    this.lock = new Object();
    this.ooi = new HashSet();
    Object localObject1 = (String)g.RL().Ru().get(ac.a.yEP, "");
    if (!bo.isNullOrNil((String)localObject1))
    {
      localObject1 = ((String)localObject1).split(",");
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        this.ooi.add(localObject2);
        i += 1;
      }
    }
    AppMethodBeat.o(42336);
  }
  
  public final boolean Sr(String paramString)
  {
    AppMethodBeat.i(42337);
    synchronized (this.lock)
    {
      if (!this.ooi.contains(paramString))
      {
        StringBuilder localStringBuilder = new StringBuilder((String)g.RL().Ru().get(ac.a.yEP, ""));
        if (this.ooi.size() <= 0)
        {
          localStringBuilder.append(paramString);
          g.RL().Ru().set(ac.a.yEP, localStringBuilder.toString());
          boolean bool = this.ooi.add(paramString);
          AppMethodBeat.o(42337);
          return bool;
        }
        localStringBuilder.append(",").append(paramString);
      }
    }
    ab.i("MicroMsg.LuckyMoneyMsg", "has contains msg, %s", new Object[] { paramString });
    AppMethodBeat.o(42337);
    return false;
  }
  
  public final void Ss(String paramString)
  {
    AppMethodBeat.i(42338);
    synchronized (this.lock)
    {
      this.ooi.remove(paramString);
      paramString = new StringBuilder();
      Iterator localIterator = this.ooi.iterator();
      if (localIterator.hasNext()) {
        paramString.append((String)localIterator.next()).append(",");
      }
    }
    if (paramString.length() == 0) {}
    for (paramString = paramString.toString();; paramString = paramString.substring(0, paramString.length() - 1))
    {
      g.RL().Ru().set(ac.a.yEP, paramString);
      AppMethodBeat.o(42338);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.p
 * JD-Core Version:    0.7.0.1
 */