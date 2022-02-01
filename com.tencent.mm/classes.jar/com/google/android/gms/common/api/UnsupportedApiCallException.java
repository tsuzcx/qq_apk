package com.google.android.gms.common.api;

import com.google.android.gms.common.Feature;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class UnsupportedApiCallException
  extends UnsupportedOperationException
{
  private final Feature zzdr;
  
  public UnsupportedApiCallException(Feature paramFeature)
  {
    this.zzdr = paramFeature;
  }
  
  public final String getMessage()
  {
    AppMethodBeat.i(4481);
    String str = String.valueOf(this.zzdr);
    str = String.valueOf(str).length() + 8 + "Missing " + str;
    AppMethodBeat.o(4481);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.UnsupportedApiCallException
 * JD-Core Version:    0.7.0.1
 */