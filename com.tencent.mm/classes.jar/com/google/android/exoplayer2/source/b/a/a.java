package com.google.android.exoplayer2.source.b.a;

import com.google.android.exoplayer2.Format;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class a
  extends c
{
  public final List<a.a> audios;
  public final List<Format> bxB;
  public final List<a.a> byO;
  public final List<a.a> byP;
  public final Format byy;
  
  public a(String paramString, List<String> paramList, List<a.a> paramList1, List<a.a> paramList2, List<a.a> paramList3, Format paramFormat, List<Format> paramList4)
  {
    super(paramString, paramList);
    AppMethodBeat.i(62886);
    this.byO = Collections.unmodifiableList(paramList1);
    this.audios = Collections.unmodifiableList(paramList2);
    this.byP = Collections.unmodifiableList(paramList3);
    this.byy = paramFormat;
    if (paramList4 != null) {}
    for (paramString = Collections.unmodifiableList(paramList4);; paramString = null)
    {
      this.bxB = paramString;
      AppMethodBeat.o(62886);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.a.a
 * JD-Core Version:    0.7.0.1
 */