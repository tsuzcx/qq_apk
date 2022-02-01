package com.tencent.mm.plugin.editor.model.nativenote.manager;

import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.model.nativenote.spans.l;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class i
  implements Serializable
{
  private static final Pattern xAk;
  int xAl;
  public final ArrayList<l> xAm;
  
  static
  {
    AppMethodBeat.i(181829);
    xAk = Pattern.compile("\\r\\n|\\r|\\n");
    AppMethodBeat.o(181829);
  }
  
  public i(Spanned paramSpanned)
  {
    AppMethodBeat.i(181826);
    this.xAl = 0;
    this.xAm = new ArrayList();
    if (paramSpanned != null)
    {
      paramSpanned = paramSpanned.toString();
      this.xAl = 1;
      Matcher localMatcher = xAk.matcher(paramSpanned);
      int i = 0;
      int j;
      boolean bool1;
      if (localMatcher.find())
      {
        j = localMatcher.end();
        if (this.xAl == 1) {}
        for (bool1 = true;; bool1 = false)
        {
          l locall = new l(i, j, bool1, false);
          this.xAm.add(locall);
          i = localMatcher.end();
          this.xAl += 1;
          break;
        }
      }
      if (this.xAm.size() < this.xAl)
      {
        j = paramSpanned.length();
        bool1 = bool2;
        if (this.xAl == 1) {
          bool1 = true;
        }
        paramSpanned = new l(i, j, bool1, true);
        this.xAm.add(paramSpanned);
      }
    }
    AppMethodBeat.o(181826);
  }
  
  public final int di(int paramInt)
  {
    AppMethodBeat.i(181827);
    int i = 0;
    while ((i < this.xAl) && (paramInt >= ((l)this.xAm.get(i)).uH)) {
      i += 1;
    }
    paramInt = Math.min(Math.max(0, i), this.xAm.size() - 1);
    AppMethodBeat.o(181827);
    return paramInt;
  }
  
  public String toString()
  {
    AppMethodBeat.i(181828);
    StringBuilder localStringBuilder1 = new StringBuilder();
    Iterator localIterator = this.xAm.iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      localObject = (l)localIterator.next();
      StringBuilder localStringBuilder2 = localStringBuilder1.append(i).append(": ").append(((g)localObject).uG).append("-").append(((g)localObject).uH);
      if (((l)localObject).xBO) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.manager.i
 * JD-Core Version:    0.7.0.1
 */