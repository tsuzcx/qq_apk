package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class w
{
  private Set<String> Kta;
  private Object lock;
  
  public w()
  {
    AppMethodBeat.i(65225);
    this.lock = new Object();
    this.Kta = new HashSet();
    Object localObject1 = (String)h.baE().ban().get(at.a.acPA, "");
    if (!Util.isNullOrNil((String)localObject1))
    {
      localObject1 = ((String)localObject1).split(",");
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        this.Kta.add(localObject2);
        i += 1;
      }
    }
    AppMethodBeat.o(65225);
  }
  
  public final void aKA(String paramString)
  {
    AppMethodBeat.i(65227);
    synchronized (this.lock)
    {
      this.Kta.remove(paramString);
      paramString = new StringBuilder();
      Iterator localIterator = this.Kta.iterator();
      if (localIterator.hasNext()) {
        paramString.append((String)localIterator.next()).append(",");
      }
    }
    if (paramString.length() == 0) {}
    for (paramString = paramString.toString();; paramString = paramString.substring(0, paramString.length() - 1))
    {
      h.baE().ban().set(at.a.acPA, paramString);
      AppMethodBeat.o(65227);
      return;
    }
  }
  
  public final boolean aKz(String paramString)
  {
    AppMethodBeat.i(65226);
    synchronized (this.lock)
    {
      if (!this.Kta.contains(paramString))
      {
        StringBuilder localStringBuilder = new StringBuilder((String)h.baE().ban().get(at.a.acPA, ""));
        if (this.Kta.size() <= 0)
        {
          localStringBuilder.append(paramString);
          h.baE().ban().set(at.a.acPA, localStringBuilder.toString());
          boolean bool = this.Kta.add(paramString);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.w
 * JD-Core Version:    0.7.0.1
 */