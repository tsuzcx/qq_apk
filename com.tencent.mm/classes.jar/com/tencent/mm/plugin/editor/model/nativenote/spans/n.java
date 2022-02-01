package com.tencent.mm.plugin.editor.model.nativenote.spans;

import android.text.Spannable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public final class n
{
  final ArrayList<a> oTG;
  
  public n()
  {
    AppMethodBeat.i(181949);
    this.oTG = new ArrayList();
    AppMethodBeat.o(181949);
  }
  
  private void a(Object paramObject, l paraml)
  {
    AppMethodBeat.i(181951);
    if ((paramObject instanceof g)) {
      this.oTG.add(new a(paramObject, paraml, true));
    }
    AppMethodBeat.o(181951);
  }
  
  public final void a(ArrayList<Object> paramArrayList, l paraml)
  {
    AppMethodBeat.i(181950);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      a(paramArrayList.next(), paraml);
    }
    AppMethodBeat.o(181950);
  }
  
  public final void b(Object paramObject, l paraml)
  {
    AppMethodBeat.i(181952);
    this.oTG.add(new a(paramObject, paraml, false));
    AppMethodBeat.o(181952);
  }
  
  public final void c(Spannable paramSpannable)
  {
    AppMethodBeat.i(181953);
    Iterator localIterator = this.oTG.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      g localg = locala.oTH;
      int m = locala.oTI.atr;
      int i;
      if (locala.oTJ)
      {
        i = paramSpannable.getSpanStart(localg);
        if ((i >= 0) && (i < m)) {
          paramSpannable.setSpan(localg.caM(), i, m, 34);
        }
        paramSpannable.removeSpan(localg);
      }
      else
      {
        l locall = locala.oTI;
        int k = locala.oTI.MZ;
        if ((locall.oTF) && (locall.isEmpty())) {
          i = 34;
        }
        for (;;)
        {
          int j = k;
          if (k > paramSpannable.length()) {
            j = paramSpannable.length();
          }
          paramSpannable.setSpan(localg, m, j, i);
          break;
          if ((locall.oTF) && (locall.oTE)) {
            i = 18;
          } else if (locall.oTF) {
            i = 34;
          } else {
            i = 33;
          }
        }
      }
    }
    AppMethodBeat.o(181953);
  }
  
  static final class a
  {
    final g oTH;
    final l oTI;
    final boolean oTJ;
    
    a(Object paramObject, l paraml, boolean paramBoolean)
    {
      AppMethodBeat.i(181948);
      this.oTH = ((g)paramObject);
      this.oTI = paraml;
      this.oTJ = paramBoolean;
      AppMethodBeat.o(181948);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.spans.n
 * JD-Core Version:    0.7.0.1
 */