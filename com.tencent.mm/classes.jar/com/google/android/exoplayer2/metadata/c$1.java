package com.google.android.exoplayer2.metadata;

import com.google.android.exoplayer2.Format;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$1
  implements c
{
  public final boolean g(Format paramFormat)
  {
    AppMethodBeat.i(95347);
    paramFormat = paramFormat.awK;
    if (("application/id3".equals(paramFormat)) || ("application/x-emsg".equals(paramFormat)) || ("application/x-scte35".equals(paramFormat)))
    {
      AppMethodBeat.o(95347);
      return true;
    }
    AppMethodBeat.o(95347);
    return false;
  }
  
  public final a h(Format paramFormat)
  {
    AppMethodBeat.i(95348);
    paramFormat = paramFormat.awK;
    int i = -1;
    switch (paramFormat.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        paramFormat = new IllegalArgumentException("Attempted to create decoder for unsupported format");
        AppMethodBeat.o(95348);
        throw paramFormat;
        if (paramFormat.equals("application/id3"))
        {
          i = 0;
          continue;
          if (paramFormat.equals("application/x-emsg"))
          {
            i = 1;
            continue;
            if (paramFormat.equals("application/x-scte35")) {
              i = 2;
            }
          }
        }
        break;
      }
    }
    paramFormat = new com.google.android.exoplayer2.metadata.id3.a();
    AppMethodBeat.o(95348);
    return paramFormat;
    paramFormat = new com.google.android.exoplayer2.metadata.emsg.a();
    AppMethodBeat.o(95348);
    return paramFormat;
    paramFormat = new com.google.android.exoplayer2.metadata.scte35.a();
    AppMethodBeat.o(95348);
    return paramFormat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.c.1
 * JD-Core Version:    0.7.0.1
 */