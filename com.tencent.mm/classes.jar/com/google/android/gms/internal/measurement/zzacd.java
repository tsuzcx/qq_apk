package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class zzacd
  extends IOException
{
  public zzacd(String paramString)
  {
    super(paramString);
  }
  
  static zzacd zzvh()
  {
    AppMethodBeat.i(40302);
    zzacd localzzacd = new zzacd("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    AppMethodBeat.o(40302);
    return localzzacd;
  }
  
  static zzacd zzvi()
  {
    AppMethodBeat.i(40303);
    zzacd localzzacd = new zzacd("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    AppMethodBeat.o(40303);
    return localzzacd;
  }
  
  static zzacd zzvj()
  {
    AppMethodBeat.i(40304);
    zzacd localzzacd = new zzacd("CodedInputStream encountered a malformed varint.");
    AppMethodBeat.o(40304);
    return localzzacd;
  }
  
  static zzacd zzvk()
  {
    AppMethodBeat.i(40305);
    zzacd localzzacd = new zzacd("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    AppMethodBeat.o(40305);
    return localzzacd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzacd
 * JD-Core Version:    0.7.0.1
 */