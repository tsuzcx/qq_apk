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
  private HashSet<String> wXt;
  public c wXu;
  
  public b()
  {
    AppMethodBeat.i(131720);
    this.wXu = new c(' ');
    this.wXt = new HashSet();
    AppMethodBeat.o(131720);
  }
  
  public final List<List<String>> ayA(String paramString)
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
      Object localObject1 = this.wXu;
      Object localObject2;
      while (i < arrayOfChar.length)
      {
        int j = arrayOfChar[i] - 'a';
        if (localObject1.wXv[j] == null) {
          break;
        }
        localObject1 = localObject1.wXv[j];
        if ((((c)localObject1).wXs) || (i == arrayOfChar.length - 1))
        {
          if (locala.aQz == null) {
            locala.aQz = new ArrayList();
          }
          localObject2 = new a(locala.end, i + 1, locala);
          locala.aQz.add(localObject2);
          if (((a)localObject2).end == arrayOfChar.length) {
            ((a)localObject2).wXs = true;
          }
          localArrayDeque.offer(localObject2);
        }
        i += 1;
      }
      if (locala.wXs)
      {
        localObject2 = new ArrayList();
        for (localObject1 = locala; localObject1 != null; localObject1 = ((a)localObject1).wXr) {
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
  
  public final void ayz(String paramString)
  {
    AppMethodBeat.i(131721);
    if (!this.wXt.add(paramString))
    {
      AppMethodBeat.o(131721);
      return;
    }
    c localc = this.wXu;
    char[] arrayOfChar = paramString.toLowerCase().toCharArray();
    int i = 0;
    paramString = localc;
    while (i < arrayOfChar.length)
    {
      int j = arrayOfChar[i] - 'a';
      if (paramString.wXv[j] == null) {
        paramString.wXv[j] = new c(arrayOfChar[i]);
      }
      paramString = paramString.wXv[j];
      i += 1;
    }
    paramString.wXs = true;
    AppMethodBeat.o(131721);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.b.b
 * JD-Core Version:    0.7.0.1
 */