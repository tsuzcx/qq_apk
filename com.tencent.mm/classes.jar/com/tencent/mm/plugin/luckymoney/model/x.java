package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class x
{
  private Set<String> EAk;
  private Object lock;
  
  public x()
  {
    AppMethodBeat.i(65225);
    this.lock = new Object();
    this.EAk = new HashSet();
    Object localObject1 = (String)h.aHG().aHp().get(ar.a.Voe, "");
    if (!Util.isNullOrNil((String)localObject1))
    {
      localObject1 = ((String)localObject1).split(",");
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        this.EAk.add(localObject2);
        i += 1;
      }
    }
    AppMethodBeat.o(65225);
  }
  
  public final boolean aND(String paramString)
  {
    AppMethodBeat.i(65226);
    synchronized (this.lock)
    {
      if (!this.EAk.contains(paramString))
      {
        StringBuilder localStringBuilder = new StringBuilder((String)h.aHG().aHp().get(ar.a.Voe, ""));
        if (this.EAk.size() <= 0)
        {
          localStringBuilder.append(paramString);
          h.aHG().aHp().set(ar.a.Voe, localStringBuilder.toString());
          boolean bool = this.EAk.add(paramString);
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
  
  public final void aNE(String paramString)
  {
    AppMethodBeat.i(65227);
    synchronized (this.lock)
    {
      this.EAk.remove(paramString);
      paramString = new StringBuilder();
      Iterator localIterator = this.EAk.iterator();
      if (localIterator.hasNext()) {
        paramString.append((String)localIterator.next()).append(",");
      }
    }
    if (paramString.length() == 0) {}
    for (paramString = paramString.toString();; paramString = paramString.substring(0, paramString.length() - 1))
    {
      h.aHG().aHp().set(ar.a.Voe, paramString);
      AppMethodBeat.o(65227);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.x
 * JD-Core Version:    0.7.0.1
 */