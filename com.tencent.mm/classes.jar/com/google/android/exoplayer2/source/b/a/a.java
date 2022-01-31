package com.google.android.exoplayer2.source.b.a;

import com.google.android.exoplayer2.Format;
import java.util.Collections;
import java.util.List;

public final class a
  extends c
{
  public final List<Format> aJu;
  public final List<a.a> aKS;
  public final List<a.a> aKT;
  public final List<a.a> aKU;
  public final Format aKs;
  
  public a(String paramString, List<String> paramList, List<a.a> paramList1, List<a.a> paramList2, List<a.a> paramList3, Format paramFormat, List<Format> paramList4)
  {
    super(paramString, paramList);
    this.aKS = Collections.unmodifiableList(paramList1);
    this.aKT = Collections.unmodifiableList(paramList2);
    this.aKU = Collections.unmodifiableList(paramList3);
    this.aKs = paramFormat;
    if (paramList4 != null) {}
    for (paramString = Collections.unmodifiableList(paramList4);; paramString = null)
    {
      this.aJu = paramString;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.a.a
 * JD-Core Version:    0.7.0.1
 */