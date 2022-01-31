package com.google.android.exoplayer2.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.f.a.c;
import com.google.android.exoplayer2.f.g.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class g$1
  implements g
{
  public final boolean g(Format paramFormat)
  {
    AppMethodBeat.i(95654);
    paramFormat = paramFormat.awK;
    if (("text/vtt".equals(paramFormat)) || ("text/x-ssa".equals(paramFormat)) || ("application/ttml+xml".equals(paramFormat)) || ("application/x-mp4-vtt".equals(paramFormat)) || ("application/x-subrip".equals(paramFormat)) || ("application/x-quicktime-tx3g".equals(paramFormat)) || ("application/cea-608".equals(paramFormat)) || ("application/x-mp4-cea-608".equals(paramFormat)) || ("application/cea-708".equals(paramFormat)) || ("application/dvbsubs".equals(paramFormat)))
    {
      AppMethodBeat.o(95654);
      return true;
    }
    AppMethodBeat.o(95654);
    return false;
  }
  
  public final e k(Format paramFormat)
  {
    AppMethodBeat.i(95655);
    String str = paramFormat.awK;
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        paramFormat = new IllegalArgumentException("Attempted to create decoder for unsupported format");
        AppMethodBeat.o(95655);
        throw paramFormat;
        if (str.equals("text/vtt"))
        {
          i = 0;
          continue;
          if (str.equals("text/x-ssa"))
          {
            i = 1;
            continue;
            if (str.equals("application/x-mp4-vtt"))
            {
              i = 2;
              continue;
              if (str.equals("application/ttml+xml"))
              {
                i = 3;
                continue;
                if (str.equals("application/x-subrip"))
                {
                  i = 4;
                  continue;
                  if (str.equals("application/x-quicktime-tx3g"))
                  {
                    i = 5;
                    continue;
                    if (str.equals("application/cea-608"))
                    {
                      i = 6;
                      continue;
                      if (str.equals("application/x-mp4-cea-608"))
                      {
                        i = 7;
                        continue;
                        if (str.equals("application/cea-708"))
                        {
                          i = 8;
                          continue;
                          if (str.equals("application/dvbsubs")) {
                            i = 9;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    paramFormat = new com.google.android.exoplayer2.f.g.g();
    AppMethodBeat.o(95655);
    return paramFormat;
    paramFormat = new com.google.android.exoplayer2.f.c.a(paramFormat.awM);
    AppMethodBeat.o(95655);
    return paramFormat;
    paramFormat = new b();
    AppMethodBeat.o(95655);
    return paramFormat;
    paramFormat = new com.google.android.exoplayer2.f.e.a();
    AppMethodBeat.o(95655);
    return paramFormat;
    paramFormat = new com.google.android.exoplayer2.f.d.a();
    AppMethodBeat.o(95655);
    return paramFormat;
    paramFormat = new com.google.android.exoplayer2.f.f.a(paramFormat.awM);
    AppMethodBeat.o(95655);
    return paramFormat;
    paramFormat = new com.google.android.exoplayer2.f.a.a(paramFormat.awK, paramFormat.axb);
    AppMethodBeat.o(95655);
    return paramFormat;
    paramFormat = new c(paramFormat.axb);
    AppMethodBeat.o(95655);
    return paramFormat;
    paramFormat = new com.google.android.exoplayer2.f.b.a(paramFormat.awM);
    AppMethodBeat.o(95655);
    return paramFormat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.f.g.1
 * JD-Core Version:    0.7.0.1
 */