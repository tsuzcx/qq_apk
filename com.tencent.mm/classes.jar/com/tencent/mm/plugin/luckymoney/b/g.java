package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;
import java.util.Set;

public final class g
{
  private Set<String> lQs = new HashSet();
  private Object lock = new Object();
  
  public final boolean GL(String paramString)
  {
    synchronized (this.lock)
    {
      if (!this.lQs.contains(paramString))
      {
        boolean bool = this.lQs.add(paramString);
        return bool;
      }
      y.i("MicroMsg.LuckyMoneyMsg", "has contains msg, %s", new Object[] { paramString });
      return false;
    }
  }
  
  public final void GM(String paramString)
  {
    synchronized (this.lock)
    {
      this.lQs.remove(paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.b.g
 * JD-Core Version:    0.7.0.1
 */