package com.tencent.mm.plugin.fts.a.a;

import com.tencent.mm.plugin.fts.a.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g$c
{
  public List<g.b> kwO = new ArrayList();
  
  public final String aVz()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.kwO.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (g.b)((Iterator)localObject1).next();
      if (!localArrayList.contains(((g.b)localObject2).content)) {
        localArrayList.add(((g.b)localObject2).content);
      }
    }
    localObject1 = new StringBuilder();
    int i = 0;
    if (i < localArrayList.size())
    {
      localObject2 = (String)localArrayList.get(i);
      ((StringBuilder)localObject1).append("\"");
      ((StringBuilder)localObject1).append((String)localObject2);
      char c = ((String)localObject2).charAt(((String)localObject2).length() - 1);
      if ((g.h(c)) || (g.i(c))) {
        ((StringBuilder)localObject1).append("\"*");
      }
      for (;;)
      {
        if (i != localArrayList.size() - 1) {
          ((StringBuilder)localObject1).append(" OR ");
        }
        i += 1;
        break;
        ((StringBuilder)localObject1).append("\"");
      }
    }
    return ((StringBuilder)localObject1).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.g.c
 * JD-Core Version:    0.7.0.1
 */