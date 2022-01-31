package com.google.android.exoplayer2.source.b.a;

import com.google.android.exoplayer2.Format;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class a
  extends c
{
  public final Format aRW;
  public final List<Format> aRa;
  public final List<a.a> aSm;
  public final List<a.a> aSn;
  public final List<a.a> aSo;
  
  public a(String paramString, List<String> paramList, List<a.a> paramList1, List<a.a> paramList2, List<a.a> paramList3, Format paramFormat, List<Format> paramList4)
  {
    super(paramString, paramList);
    AppMethodBeat.i(125962);
    this.aSm = Collections.unmodifiableList(paramList1);
    this.aSn = Collections.unmodifiableList(paramList2);
    this.aSo = Collections.unmodifiableList(paramList3);
    this.aRW = paramFormat;
    if (paramList4 != null) {}
    for (paramString = Collections.unmodifiableList(paramList4);; paramString = null)
    {
      this.aRa = paramString;
      AppMethodBeat.o(125962);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.a.a
 * JD-Core Version:    0.7.0.1
 */