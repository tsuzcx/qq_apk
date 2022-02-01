package com.google.android.exoplayer2.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.f.a.c;
import com.google.android.exoplayer2.f.g.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface g
{
  public static final g bpM = new g()
  {
    public final boolean g(Format paramAnonymousFormat)
    {
      AppMethodBeat.i(92822);
      paramAnonymousFormat = paramAnonymousFormat.aSY;
      if (("text/vtt".equals(paramAnonymousFormat)) || ("text/x-ssa".equals(paramAnonymousFormat)) || ("application/ttml+xml".equals(paramAnonymousFormat)) || ("application/x-mp4-vtt".equals(paramAnonymousFormat)) || ("application/x-subrip".equals(paramAnonymousFormat)) || ("application/x-quicktime-tx3g".equals(paramAnonymousFormat)) || ("application/cea-608".equals(paramAnonymousFormat)) || ("application/x-mp4-cea-608".equals(paramAnonymousFormat)) || ("application/cea-708".equals(paramAnonymousFormat)) || ("application/dvbsubs".equals(paramAnonymousFormat)))
      {
        AppMethodBeat.o(92822);
        return true;
      }
      AppMethodBeat.o(92822);
      return false;
    }
    
    public final e k(Format paramAnonymousFormat)
    {
      AppMethodBeat.i(92823);
      String str = paramAnonymousFormat.aSY;
      int i = -1;
      switch (str.hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          paramAnonymousFormat = new IllegalArgumentException("Attempted to create decoder for unsupported format");
          AppMethodBeat.o(92823);
          throw paramAnonymousFormat;
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
      paramAnonymousFormat = new com.google.android.exoplayer2.f.g.g();
      AppMethodBeat.o(92823);
      return paramAnonymousFormat;
      paramAnonymousFormat = new com.google.android.exoplayer2.f.c.a(paramAnonymousFormat.aTa);
      AppMethodBeat.o(92823);
      return paramAnonymousFormat;
      paramAnonymousFormat = new b();
      AppMethodBeat.o(92823);
      return paramAnonymousFormat;
      paramAnonymousFormat = new com.google.android.exoplayer2.f.e.a();
      AppMethodBeat.o(92823);
      return paramAnonymousFormat;
      paramAnonymousFormat = new com.google.android.exoplayer2.f.d.a();
      AppMethodBeat.o(92823);
      return paramAnonymousFormat;
      paramAnonymousFormat = new com.google.android.exoplayer2.f.f.a(paramAnonymousFormat.aTa);
      AppMethodBeat.o(92823);
      return paramAnonymousFormat;
      paramAnonymousFormat = new com.google.android.exoplayer2.f.a.a(paramAnonymousFormat.aSY, paramAnonymousFormat.aTn);
      AppMethodBeat.o(92823);
      return paramAnonymousFormat;
      paramAnonymousFormat = new c(paramAnonymousFormat.aTn);
      AppMethodBeat.o(92823);
      return paramAnonymousFormat;
      paramAnonymousFormat = new com.google.android.exoplayer2.f.b.a(paramAnonymousFormat.aTa);
      AppMethodBeat.o(92823);
      return paramAnonymousFormat;
    }
  };
  
  public abstract boolean g(Format paramFormat);
  
  public abstract e k(Format paramFormat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.f.g
 * JD-Core Version:    0.7.0.1
 */