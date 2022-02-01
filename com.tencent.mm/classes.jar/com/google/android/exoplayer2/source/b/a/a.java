package com.google.android.exoplayer2.source.b.a;

import com.google.android.exoplayer2.Format;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class a
  extends c
{
  public final List<a> audios;
  public final Format bhZ;
  public final List<Format> bhd;
  public final List<a> bip;
  public final List<a> biq;
  
  public a(String paramString, List<String> paramList, List<a> paramList1, List<a> paramList2, List<a> paramList3, Format paramFormat, List<Format> paramList4)
  {
    super(paramString, paramList);
    AppMethodBeat.i(62886);
    this.bip = Collections.unmodifiableList(paramList1);
    this.audios = Collections.unmodifiableList(paramList2);
    this.biq = Collections.unmodifiableList(paramList3);
    this.bhZ = paramFormat;
    if (paramList4 != null) {}
    for (paramString = Collections.unmodifiableList(paramList4);; paramString = null)
    {
      this.bhd = paramString;
      AppMethodBeat.o(62886);
      return;
    }
  }
  
  public static final class a
  {
    public final Format aNg;
    public final String url;
    
    public a(String paramString, Format paramFormat)
    {
      this.url = paramString;
      this.aNg = paramFormat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.a.a
 * JD-Core Version:    0.7.0.1
 */