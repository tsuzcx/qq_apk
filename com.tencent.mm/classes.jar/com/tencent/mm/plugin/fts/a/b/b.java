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
  private HashSet<String> mTo;
  public c mTp;
  
  public b()
  {
    AppMethodBeat.i(114284);
    this.mTp = new c(' ');
    this.mTo = new HashSet();
    AppMethodBeat.o(114284);
  }
  
  public final void Pi(String paramString)
  {
    AppMethodBeat.i(114285);
    if (!this.mTo.add(paramString))
    {
      AppMethodBeat.o(114285);
      return;
    }
    c localc = this.mTp;
    char[] arrayOfChar = paramString.toLowerCase().toCharArray();
    int i = 0;
    paramString = localc;
    while (i < arrayOfChar.length)
    {
      int j = arrayOfChar[i] - 'a';
      if (paramString.mTq[j] == null) {
        paramString.mTq[j] = new c(arrayOfChar[i]);
      }
      paramString = paramString.mTq[j];
      i += 1;
    }
    paramString.mTn = true;
    AppMethodBeat.o(114285);
  }
  
  public final List<List<String>> Pj(String paramString)
  {
    AppMethodBeat.i(114286);
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
      Object localObject1 = this.mTp;
      Object localObject2;
      while (i < arrayOfChar.length)
      {
        int j = arrayOfChar[i] - 'a';
        if (localObject1.mTq[j] == null) {
          break;
        }
        localObject1 = localObject1.mTq[j];
        if ((((c)localObject1).mTn) || (i == arrayOfChar.length - 1))
        {
          if (locala.aWy == null) {
            locala.aWy = new ArrayList();
          }
          localObject2 = new a(locala.end, i + 1, locala);
          locala.aWy.add(localObject2);
          if (((a)localObject2).end == arrayOfChar.length) {
            ((a)localObject2).mTn = true;
          }
          localArrayDeque.offer(localObject2);
        }
        i += 1;
      }
      if (locala.mTn)
      {
        localObject2 = new ArrayList();
        for (localObject1 = locala; localObject1 != null; localObject1 = ((a)localObject1).mTm) {
          if (((a)localObject1).end > ((a)localObject1).start) {
            ((List)localObject2).add(paramString.substring(((a)localObject1).start, ((a)localObject1).end));
          }
        }
        Collections.reverse((List)localObject2);
        localArrayList.add(localObject2);
      }
    }
    AppMethodBeat.o(114286);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.b.b
 * JD-Core Version:    0.7.0.1
 */