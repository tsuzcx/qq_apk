package com.google.android.exoplayer2.e;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$a
{
  public final boolean aMF;
  public final String mimeType;
  
  public d$a(String paramString, boolean paramBoolean)
  {
    this.mimeType = paramString;
    this.aMF = paramBoolean;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(95240);
    if (this == paramObject)
    {
      AppMethodBeat.o(95240);
      return true;
    }
    if ((paramObject == null) || (paramObject.getClass() != a.class))
    {
      AppMethodBeat.o(95240);
      return false;
    }
    paramObject = (a)paramObject;
    if ((TextUtils.equals(this.mimeType, paramObject.mimeType)) && (this.aMF == paramObject.aMF))
    {
      AppMethodBeat.o(95240);
      return true;
    }
    AppMethodBeat.o(95240);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(95239);
    int i;
    if (this.mimeType == null)
    {
      i = 0;
      if (!this.aMF) {
        break label51;
      }
    }
    label51:
    for (int j = 1231;; j = 1237)
    {
      AppMethodBeat.o(95239);
      return j + (i + 31) * 31;
      i = this.mimeType.hashCode();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.e.d.a
 * JD-Core Version:    0.7.0.1
 */