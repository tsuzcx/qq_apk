package com.google.android.exoplayer2.g;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$a
{
  public final int awU;
  public final String mimeType;
  public final int sampleRate;
  
  public c$a(int paramInt1, int paramInt2, String paramString)
  {
    this.awU = paramInt1;
    this.sampleRate = paramInt2;
    this.mimeType = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(95761);
    if (this == paramObject)
    {
      AppMethodBeat.o(95761);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(95761);
      return false;
    }
    paramObject = (a)paramObject;
    if ((this.awU == paramObject.awU) && (this.sampleRate == paramObject.sampleRate) && (TextUtils.equals(this.mimeType, paramObject.mimeType)))
    {
      AppMethodBeat.o(95761);
      return true;
    }
    AppMethodBeat.o(95761);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(95762);
    int j = this.awU;
    int k = this.sampleRate;
    if (this.mimeType != null) {}
    for (int i = this.mimeType.hashCode();; i = 0)
    {
      AppMethodBeat.o(95762);
      return i + (j * 31 + k) * 31;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.g.c.a
 * JD-Core Version:    0.7.0.1
 */