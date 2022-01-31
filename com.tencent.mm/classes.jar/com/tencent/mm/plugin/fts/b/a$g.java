package com.tencent.mm.plugin.fts.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

final class a$g
  extends com.tencent.mm.plugin.fts.a.a.a
{
  private int mCN = 0;
  private int[] mUy;
  private int mUz = 0;
  
  public a$g(a parama, int[] paramArrayOfInt)
  {
    this.mUy = paramArrayOfInt;
  }
  
  public final String aAn()
  {
    AppMethodBeat.i(136677);
    String str = String.format("{touched: %d users: %d}", new Object[] { Integer.valueOf(this.mCN), Integer.valueOf(this.mUz) });
    AppMethodBeat.o(136677);
    return str;
  }
  
  public final boolean execute()
  {
    AppMethodBeat.i(136676);
    Object localObject = a.a(this.mUg).g(this.mUy, 1);
    this.mCN = ((List)localObject).size();
    HashMap localHashMap = new HashMap();
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      String str = localb.mRV;
      if (!a.b(this.mUg).containsKey(str))
      {
        List localList = (List)localHashMap.get(str);
        localObject = localList;
        if (localList == null)
        {
          localObject = new ArrayList(16);
          localHashMap.put(str, localObject);
        }
        ((List)localObject).add(Long.valueOf(localb.mRT));
      }
    }
    a.b(this.mUg).putAll(localHashMap);
    this.mUz = localHashMap.size();
    AppMethodBeat.o(136676);
    return true;
  }
  
  public final String getName()
  {
    return "MarkAllContactDirtyTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a.g
 * JD-Core Version:    0.7.0.1
 */