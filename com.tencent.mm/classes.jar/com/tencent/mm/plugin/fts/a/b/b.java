package com.tencent.mm.plugin.fts.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

public final class b
{
  private HashSet<String> HtZ;
  public c Hua;
  
  public b()
  {
    AppMethodBeat.i(131720);
    this.Hua = new c(' ');
    this.HtZ = new HashSet();
    AppMethodBeat.o(131720);
  }
  
  public final void aEs(String paramString)
  {
    AppMethodBeat.i(131721);
    if (!this.HtZ.add(paramString))
    {
      AppMethodBeat.o(131721);
      return;
    }
    c localc = this.Hua;
    char[] arrayOfChar = paramString.toLowerCase().toCharArray();
    int i = 0;
    paramString = localc;
    while (i < arrayOfChar.length)
    {
      int j = arrayOfChar[i] - 'a';
      if (paramString.Hub[j] == null) {
        paramString.Hub[j] = new c(arrayOfChar[i]);
      }
      paramString = paramString.Hub[j];
      i += 1;
    }
    paramString.HtY = true;
    AppMethodBeat.o(131721);
  }
  
  public final List<List<String>> aEt(String paramString)
  {
    AppMethodBeat.i(131722);
    ArrayDeque localArrayDeque = new ArrayDeque();
    localArrayDeque.offer(new a(0, 0, null));
    char[] arrayOfChar = paramString.toLowerCase().toCharArray();
    ArrayList localArrayList = new ArrayList();
    while (!localArrayDeque.isEmpty())
    {
      a locala = (a)localArrayDeque.poll();
      if (locala == null) {
        break;
      }
      int i = locala.end;
      Object localObject1 = this.Hua;
      Object localObject2;
      while (i < arrayOfChar.length)
      {
        int j = arrayOfChar[i] - 'a';
        if (localObject1.Hub[j] == null) {
          break;
        }
        localObject1 = localObject1.Hub[j];
        if ((((c)localObject1).HtY) || (i == arrayOfChar.length - 1))
        {
          if (locala.aAO == null) {
            locala.aAO = new ArrayList();
          }
          localObject2 = new a(locala.end, i + 1, locala);
          locala.aAO.add(localObject2);
          if (((a)localObject2).end == arrayOfChar.length) {
            ((a)localObject2).HtY = true;
          }
          localArrayDeque.offer(localObject2);
        }
        i += 1;
      }
      if (locala.HtY)
      {
        localObject2 = new ArrayList();
        for (localObject1 = locala; localObject1 != null; localObject1 = ((a)localObject1).HtX) {
          if (((a)localObject1).end > ((a)localObject1).start) {
            ((List)localObject2).add(paramString.substring(((a)localObject1).start, ((a)localObject1).end));
          }
        }
        Collections.reverse((List)localObject2);
        localArrayList.add(localObject2);
      }
    }
    AppMethodBeat.o(131722);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.b.b
 * JD-Core Version:    0.7.0.1
 */