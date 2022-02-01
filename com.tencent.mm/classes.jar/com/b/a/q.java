package com.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
{
  public final String cBw;
  public final long length;
  public final String url;
  
  public q(String paramString1, long paramLong, String paramString2)
  {
    this.url = paramString1;
    this.length = paramLong;
    this.cBw = paramString2;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(183617);
    String str = "SourceInfo{url='" + this.url + '\'' + ", length=" + this.length + ", mime='" + this.cBw + '\'' + '}';
    AppMethodBeat.o(183617);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.b.a.q
 * JD-Core Version:    0.7.0.1
 */