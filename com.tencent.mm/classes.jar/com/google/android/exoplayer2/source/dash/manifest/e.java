package com.google.android.exoplayer2.source.dash.manifest;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class e
{
  public final List<a> bnb;
  public final long bof;
  public final String id;
  
  public e(String paramString, long paramLong, List<a> paramList)
  {
    AppMethodBeat.i(10553);
    this.id = paramString;
    this.bof = paramLong;
    this.bnb = Collections.unmodifiableList(paramList);
    AppMethodBeat.o(10553);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.dash.manifest.e
 * JD-Core Version:    0.7.0.1
 */