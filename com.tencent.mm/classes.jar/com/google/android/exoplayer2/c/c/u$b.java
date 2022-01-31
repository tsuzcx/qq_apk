package com.google.android.exoplayer2.c.c;

import java.util.Collections;
import java.util.List;

public final class u$b
{
  public final List<u.a> aFC;
  public final byte[] aFD;
  public final String auI;
  public final int streamType;
  
  public u$b(int paramInt, String paramString, List<u.a> paramList, byte[] paramArrayOfByte)
  {
    this.streamType = paramInt;
    this.auI = paramString;
    if (paramList == null) {}
    for (paramString = Collections.emptyList();; paramString = Collections.unmodifiableList(paramList))
    {
      this.aFC = paramString;
      this.aFD = paramArrayOfByte;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.c.u.b
 * JD-Core Version:    0.7.0.1
 */