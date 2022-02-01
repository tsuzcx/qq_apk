package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public final String bjo;
  public final String id;
  public final String value;
  
  public d(String paramString1, String paramString2, String paramString3)
  {
    this.bjo = paramString1;
    this.value = paramString2;
    this.id = paramString3;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(10551);
    if (this == paramObject)
    {
      AppMethodBeat.o(10551);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(10551);
      return false;
    }
    paramObject = (d)paramObject;
    if ((x.g(this.bjo, paramObject.bjo)) && (x.g(this.value, paramObject.value)) && (x.g(this.id, paramObject.id)))
    {
      AppMethodBeat.o(10551);
      return true;
    }
    AppMethodBeat.o(10551);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(10552);
    int i;
    if (this.bjo != null)
    {
      i = this.bjo.hashCode();
      if (this.value == null) {
        break label76;
      }
    }
    label76:
    for (int j = this.value.hashCode();; j = 0)
    {
      if (this.id != null) {
        k = this.id.hashCode();
      }
      AppMethodBeat.o(10552);
      return (j + i * 31) * 31 + k;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.dash.manifest.d
 * JD-Core Version:    0.7.0.1
 */