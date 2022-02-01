package com.tencent.mm.plugin.editor.model.nativenote.spans;

import android.text.Spannable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public final class n
{
  final ArrayList<a> qTl;
  
  public n()
  {
    AppMethodBeat.i(181949);
    this.qTl = new ArrayList();
    AppMethodBeat.o(181949);
  }
  
  private void a(Object paramObject, l paraml)
  {
    AppMethodBeat.i(181951);
    if ((paramObject instanceof g)) {
      this.qTl.add(new a(paramObject, paraml, true));
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
    this.qTl.add(new a(paramObject, paraml, false));
    AppMethodBeat.o(181952);
  }
  
  public final void c(Spannable paramSpannable)
  {
    AppMethodBeat.i(181953);
    Iterator localIterator = this.qTl.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      g localg = locala.qTm;
      int m = locala.qTn.avh;
      int i;
      if (locala.qTo)
      {
        i = paramSpannable.getSpanStart(localg);
        if ((i >= 0) && (i < m)) {
          paramSpannable.setSpan(localg.cEu(), i, m, 34);
        }
        paramSpannable.removeSpan(localg);
      }
      else
      {
        l locall = locala.qTn;
        int k = locala.qTn.Pc;
        if ((locall.qTk) && (locall.isEmpty())) {
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
          if ((locall.qTk) && (locall.qTj)) {
            i = 18;
          } else if (locall.qTk) {
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
    final g qTm;
    final l qTn;
    final boolean qTo;
    
    a(Object paramObject, l paraml, boolean paramBoolean)
    {
      AppMethodBeat.i(181948);
      this.qTm = ((g)paramObject);
      this.qTn = paraml;
      this.qTo = paramBoolean;
      AppMethodBeat.o(181948);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.spans.n
 * JD-Core Version:    0.7.0.1
 */