package com.danikula.videocache;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class SourceInfo
{
  public final long length;
  public final String mime;
  public final String url;
  
  public SourceInfo(String paramString1, long paramLong, String paramString2)
  {
    this.url = paramString1;
    this.length = paramLong;
    this.mime = paramString2;
  }
  
  public String toString()
  {
    AppMethodBeat.i(183617);
    String str = "SourceInfo{url='" + this.url + '\'' + ", length=" + this.length + ", mime='" + this.mime + '\'' + '}';
    AppMethodBeat.o(183617);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.danikula.videocache.SourceInfo
 * JD-Core Version:    0.7.0.1
 */