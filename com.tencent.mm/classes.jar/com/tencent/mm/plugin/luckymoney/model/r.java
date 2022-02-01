package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class r
{
  private Object lock;
  private Set<String> vpg;
  
  public r()
  {
    AppMethodBeat.i(65225);
    this.lock = new Object();
    this.vpg = new HashSet();
    Object localObject1 = (String)g.ajC().ajl().get(al.a.IxC, "");
    if (!bt.isNullOrNil((String)localObject1))
    {
      localObject1 = ((String)localObject1).split(",");
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        this.vpg.add(localObject2);
        i += 1;
      }
    }
    AppMethodBeat.o(65225);
  }
  
  public final boolean aoT(String paramString)
  {
    AppMethodBeat.i(65226);
    synchronized (this.lock)
    {
      if (!this.vpg.contains(paramString))
      {
        StringBuilder localStringBuilder = new StringBuilder((String)g.ajC().ajl().get(al.a.IxC, ""));
        if (this.vpg.size() <= 0)
        {
          localStringBuilder.append(paramString);
          g.ajC().ajl().set(al.a.IxC, localStringBuilder.toString());
          boolean bool = this.vpg.add(paramString);
          AppMethodBeat.o(65226);
          return bool;
        }
        localStringBuilder.append(",").append(paramString);
      }
    }
    ad.i("MicroMsg.LuckyMoneyMsg", "has contains msg, %s", new Object[] { paramString });
    AppMethodBeat.o(65226);
    return false;
  }
  
  public final void aoU(String paramString)
  {
    AppMethodBeat.i(65227);
    synchronized (this.lock)
    {
      this.vpg.remove(paramString);
      paramString = new StringBuilder();
      Iterator localIterator = this.vpg.iterator();
      if (localIterator.hasNext()) {
        paramString.append((String)localIterator.next()).append(",");
      }
    }
    if (paramString.length() == 0) {}
    for (paramString = paramString.toString();; paramString = paramString.substring(0, paramString.length() - 1))
    {
      g.ajC().ajl().set(al.a.IxC, paramString);
      AppMethodBeat.o(65227);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.r
 * JD-Core Version:    0.7.0.1
 */