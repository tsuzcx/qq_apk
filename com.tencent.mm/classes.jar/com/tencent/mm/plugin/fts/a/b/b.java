package com.tencent.mm.plugin.fts.a.b;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

public final class b
{
  public c kxA = new c(' ');
  private HashSet<String> kxz = new HashSet();
  
  public final void DY(String paramString)
  {
    if (!this.kxz.add(paramString)) {
      return;
    }
    c localc = this.kxA;
    char[] arrayOfChar = paramString.toLowerCase().toCharArray();
    int i = 0;
    paramString = localc;
    while (i < arrayOfChar.length)
    {
      int j = arrayOfChar[i] - 'a';
      if (paramString.kxB[j] == null) {
        paramString.kxB[j] = new c(arrayOfChar[i]);
      }
      paramString = paramString.kxB[j];
      i += 1;
    }
    paramString.kxy = true;
  }
  
  public final List<List<String>> DZ(String paramString)
  {
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
      Object localObject1 = this.kxA;
      Object localObject2;
      while (i < arrayOfChar.length)
      {
        int j = arrayOfChar[i] - 'a';
        if (localObject1.kxB[j] == null) {
          break;
        }
        localObject1 = localObject1.kxB[j];
        if ((((c)localObject1).kxy) || (i == arrayOfChar.length - 1))
        {
          if (locala.aPf == null) {
            locala.aPf = new ArrayList();
          }
          localObject2 = new a(locala.end, i + 1, locala);
          locala.aPf.add(localObject2);
          if (((a)localObject2).end == arrayOfChar.length) {
            ((a)localObject2).kxy = true;
          }
          localArrayDeque.offer(localObject2);
        }
        i += 1;
      }
      if (locala.kxy)
      {
        localObject2 = new ArrayList();
        for (localObject1 = locala; localObject1 != null; localObject1 = ((a)localObject1).kxx) {
          if (((a)localObject1).end > ((a)localObject1).start) {
            ((List)localObject2).add(paramString.substring(((a)localObject1).start, ((a)localObject1).end));
          }
        }
        Collections.reverse((List)localObject2);
        localArrayList.add(localObject2);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.b.b
 * JD-Core Version:    0.7.0.1
 */