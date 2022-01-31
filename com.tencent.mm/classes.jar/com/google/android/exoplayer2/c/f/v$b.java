package com.google.android.exoplayer2.c.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class v$b
{
  public final List<v.a> aMq;
  public final byte[] aMr;
  public final String axa;
  public final int streamType;
  
  public v$b(int paramInt, String paramString, List<v.a> paramList, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95178);
    this.streamType = paramInt;
    this.axa = paramString;
    if (paramList == null) {}
    for (paramString = Collections.emptyList();; paramString = Collections.unmodifiableList(paramList))
    {
      this.aMq = paramString;
      this.aMr = paramArrayOfByte;
      AppMethodBeat.o(95178);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.v.b
 * JD-Core Version:    0.7.0.1
 */