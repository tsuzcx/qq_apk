package com.google.android.exoplayer2.c.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class v$b
{
  public final List<v.a> cWh;
  public final byte[] cWi;
  public final String language;
  public final int streamType;
  
  public v$b(int paramInt, String paramString, List<v.a> paramList, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(92300);
    this.streamType = paramInt;
    this.language = paramString;
    if (paramList == null) {}
    for (paramString = Collections.emptyList();; paramString = Collections.unmodifiableList(paramList))
    {
      this.cWh = paramString;
      this.cWi = paramArrayOfByte;
      AppMethodBeat.o(92300);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.v.b
 * JD-Core Version:    0.7.0.1
 */