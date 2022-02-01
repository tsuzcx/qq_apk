package com.google.android.exoplayer2.e;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$a
{
  public final boolean cWw;
  public final String mimeType;
  
  public d$a(String paramString, boolean paramBoolean)
  {
    this.mimeType = paramString;
    this.cWw = paramBoolean;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(92362);
    if (this == paramObject)
    {
      AppMethodBeat.o(92362);
      return true;
    }
    if ((paramObject == null) || (paramObject.getClass() != a.class))
    {
      AppMethodBeat.o(92362);
      return false;
    }
    paramObject = (a)paramObject;
    if ((TextUtils.equals(this.mimeType, paramObject.mimeType)) && (this.cWw == paramObject.cWw))
    {
      AppMethodBeat.o(92362);
      return true;
    }
    AppMethodBeat.o(92362);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(92361);
    int i;
    if (this.mimeType == null)
    {
      i = 0;
      if (!this.cWw) {
        break label51;
      }
    }
    label51:
    for (int j = 1231;; j = 1237)
    {
      AppMethodBeat.o(92361);
      return j + (i + 31) * 31;
      i = this.mimeType.hashCode();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.e.d.a
 * JD-Core Version:    0.7.0.1
 */