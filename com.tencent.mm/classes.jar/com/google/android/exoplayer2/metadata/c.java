package com.google.android.exoplayer2.metadata;

import com.google.android.exoplayer2.Format;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface c
{
  public static final c btY = new c()
  {
    public final boolean g(Format paramAnonymousFormat)
    {
      AppMethodBeat.i(92469);
      paramAnonymousFormat = paramAnonymousFormat.bdq;
      if (("application/id3".equals(paramAnonymousFormat)) || ("application/x-emsg".equals(paramAnonymousFormat)) || ("application/x-scte35".equals(paramAnonymousFormat)))
      {
        AppMethodBeat.o(92469);
        return true;
      }
      AppMethodBeat.o(92469);
      return false;
    }
    
    public final a h(Format paramAnonymousFormat)
    {
      AppMethodBeat.i(92470);
      paramAnonymousFormat = paramAnonymousFormat.bdq;
      int i = -1;
      switch (paramAnonymousFormat.hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          paramAnonymousFormat = new IllegalArgumentException("Attempted to create decoder for unsupported format");
          AppMethodBeat.o(92470);
          throw paramAnonymousFormat;
          if (paramAnonymousFormat.equals("application/id3"))
          {
            i = 0;
            continue;
            if (paramAnonymousFormat.equals("application/x-emsg"))
            {
              i = 1;
              continue;
              if (paramAnonymousFormat.equals("application/x-scte35")) {
                i = 2;
              }
            }
          }
          break;
        }
      }
      paramAnonymousFormat = new com.google.android.exoplayer2.metadata.id3.a();
      AppMethodBeat.o(92470);
      return paramAnonymousFormat;
      paramAnonymousFormat = new com.google.android.exoplayer2.metadata.emsg.a();
      AppMethodBeat.o(92470);
      return paramAnonymousFormat;
      paramAnonymousFormat = new com.google.android.exoplayer2.metadata.scte35.a();
      AppMethodBeat.o(92470);
      return paramAnonymousFormat;
    }
  };
  
  public abstract boolean g(Format paramFormat);
  
  public abstract a h(Format paramFormat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.c
 * JD-Core Version:    0.7.0.1
 */