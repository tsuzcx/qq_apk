package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class zzzt
  extends IOException
{
  private zzaal zzbst = null;
  
  public zzzt(String paramString)
  {
    super(paramString);
  }
  
  static zzzt zztm()
  {
    AppMethodBeat.i(40378);
    zzzt localzzzt = new zzzt("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    AppMethodBeat.o(40378);
    return localzzzt;
  }
  
  static zzzt zztn()
  {
    AppMethodBeat.i(40379);
    zzzt localzzzt = new zzzt("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    AppMethodBeat.o(40379);
    return localzzzt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzzt
 * JD-Core Version:    0.7.0.1
 */