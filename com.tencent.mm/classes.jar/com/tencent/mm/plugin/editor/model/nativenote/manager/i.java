package com.tencent.mm.plugin.editor.model.nativenote.manager;

import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.model.nativenote.spans.l;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class i
  implements Serializable
{
  private static final Pattern pCp;
  int pCq;
  public final ArrayList<l> pCr;
  
  static
  {
    AppMethodBeat.i(181829);
    pCp = Pattern.compile("\\r\\n|\\r|\\n");
    AppMethodBeat.o(181829);
  }
  
  public i(Spanned paramSpanned)
  {
    AppMethodBeat.i(181826);
    this.pCq = 0;
    this.pCr = new ArrayList();
    if (paramSpanned != null)
    {
      paramSpanned = paramSpanned.toString();
      this.pCq = 1;
      Matcher localMatcher = pCp.matcher(paramSpanned);
      int i = 0;
      int j;
      boolean bool1;
      if (localMatcher.find())
      {
        j = localMatcher.end();
        if (this.pCq == 1) {}
        for (bool1 = true;; bool1 = false)
        {
          l locall = new l(i, j, bool1, false);
          this.pCr.add(locall);
          i = localMatcher.end();
          this.pCq += 1;
          break;
        }
      }
      if (this.pCr.size() < this.pCq)
      {
        j = paramSpanned.length();
        bool1 = bool2;
        if (this.pCq == 1) {
          bool1 = true;
        }
        paramSpanned = new l(i, j, bool1, true);
        this.pCr.add(paramSpanned);
      }
    }
    AppMethodBeat.o(181826);
  }
  
  public final int getLineForOffset(int paramInt)
  {
    AppMethodBeat.i(181827);
    int i = 0;
    while ((i < this.pCq) && (paramInt >= ((l)this.pCr.get(i)).OQ)) {
      i += 1;
    }
    paramInt = Math.min(Math.max(0, i), this.pCr.size() - 1);
    AppMethodBeat.o(181827);
    return paramInt;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(181828);
    StringBuilder localStringBuilder1 = new StringBuilder();
    Iterator localIterator = this.pCr.iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      localObject = (l)localIterator.next();
      StringBuilder localStringBuilder2 = localStringBuilder1.append(i).append(": ").append(((g)localObject).avj).append("-").append(((g)localObject).OQ);
      if (((l)localObject).pDT) {}
      for (localObject = "";; localObject = ", ")
      {
        localStringBuilder2.append((String)localObject);
        i += 1;
        break;
      }
    }
    Object localObject = localStringBuilder1.toString();
    AppMethodBeat.o(181828);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.manager.i
 * JD-Core Version:    0.7.0.1
 */