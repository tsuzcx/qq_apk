package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.i.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  private int aFj;
  private final String bog;
  public final long length;
  public final long start;
  
  public f(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(10554);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.bog = str;
    this.start = paramLong1;
    this.length = paramLong2;
    AppMethodBeat.o(10554);
  }
  
  private String aq(String paramString)
  {
    AppMethodBeat.i(10556);
    paramString = w.m(paramString, this.bog);
    AppMethodBeat.o(10556);
    return paramString;
  }
  
  public final f a(f paramf, String paramString)
  {
    long l1 = -1L;
    AppMethodBeat.i(10557);
    String str = aq(paramString);
    if ((paramf == null) || (!str.equals(paramf.aq(paramString))))
    {
      AppMethodBeat.o(10557);
      return null;
    }
    long l2;
    if ((this.length != -1L) && (this.start + this.length == paramf.start))
    {
      l2 = this.start;
      if (paramf.length == -1L) {}
      for (;;)
      {
        paramf = new f(str, l2, l1);
        AppMethodBeat.o(10557);
        return paramf;
        l1 = this.length + paramf.length;
      }
    }
    if ((paramf.length != -1L) && (paramf.start + paramf.length == this.start))
    {
      l2 = paramf.start;
      if (this.length == -1L) {}
      for (;;)
      {
        paramf = new f(str, l2, l1);
        AppMethodBeat.o(10557);
        return paramf;
        l1 = paramf.length + this.length;
      }
    }
    AppMethodBeat.o(10557);
    return null;
  }
  
  public final Uri ap(String paramString)
  {
    AppMethodBeat.i(10555);
    paramString = w.l(paramString, this.bog);
    AppMethodBeat.o(10555);
    return paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(10559);
    if (this == paramObject)
    {
      AppMethodBeat.o(10559);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(10559);
      return false;
    }
    paramObject = (f)paramObject;
    if ((this.start == paramObject.start) && (this.length == paramObject.length) && (this.bog.equals(paramObject.bog)))
    {
      AppMethodBeat.o(10559);
      return true;
    }
    AppMethodBeat.o(10559);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(10558);
    if (this.aFj == 0) {
      this.aFj = ((((int)this.start + 527) * 31 + (int)this.length) * 31 + this.bog.hashCode());
    }
    int i = this.aFj;
    AppMethodBeat.o(10558);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.dash.manifest.f
 * JD-Core Version:    0.7.0.1
 */