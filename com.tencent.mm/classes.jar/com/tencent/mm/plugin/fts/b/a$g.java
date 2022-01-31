package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.plugin.fts.a.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

final class a$g
  extends com.tencent.mm.plugin.fts.a.a.a
{
  private int kih = 0;
  private int[] kyK;
  private int kyL = 0;
  
  public a$g(a parama, int[] paramArrayOfInt)
  {
    this.kyK = paramArrayOfInt;
  }
  
  public final String afJ()
  {
    return String.format("{touched: %d users: %d}", new Object[] { Integer.valueOf(this.kih), Integer.valueOf(this.kyL) });
  }
  
  public final boolean execute()
  {
    Object localObject = a.a(this.kyt).f(this.kyK, 1);
    this.kih = ((List)localObject).size();
    HashMap localHashMap = new HashMap();
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      String str = localb.kwg;
      if (!a.b(this.kyt).containsKey(str))
      {
        List localList = (List)localHashMap.get(str);
        localObject = localList;
        if (localList == null)
        {
          localObject = new ArrayList(16);
          localHashMap.put(str, localObject);
        }
        ((List)localObject).add(Long.valueOf(localb.kwe));
      }
    }
    a.b(this.kyt).putAll(localHashMap);
    this.kyL = localHashMap.size();
    return true;
  }
  
  public final String getName()
  {
    return "MarkAllContactDirtyTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a.g
 * JD-Core Version:    0.7.0.1
 */