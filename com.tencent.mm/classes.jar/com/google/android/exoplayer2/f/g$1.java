package com.google.android.exoplayer2.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.f.a.c;
import com.google.android.exoplayer2.f.g.b;

final class g$1
  implements g
{
  public final boolean g(Format paramFormat)
  {
    paramFormat = paramFormat.aus;
    return ("text/vtt".equals(paramFormat)) || ("text/x-ssa".equals(paramFormat)) || ("application/ttml+xml".equals(paramFormat)) || ("application/x-mp4-vtt".equals(paramFormat)) || ("application/x-subrip".equals(paramFormat)) || ("application/x-quicktime-tx3g".equals(paramFormat)) || ("application/cea-608".equals(paramFormat)) || ("application/x-mp4-cea-608".equals(paramFormat)) || ("application/cea-708".equals(paramFormat)) || ("application/dvbsubs".equals(paramFormat));
  }
  
  public final e k(Format paramFormat)
  {
    String str = paramFormat.aus;
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
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
    return new com.google.android.exoplayer2.f.g.g();
    return new com.google.android.exoplayer2.f.c.a(paramFormat.auu);
    return new b();
    return new com.google.android.exoplayer2.f.e.a();
    return new com.google.android.exoplayer2.f.d.a();
    return new com.google.android.exoplayer2.f.f.a(paramFormat.auu);
    return new com.google.android.exoplayer2.f.a.a(paramFormat.aus, paramFormat.auJ);
    return new c(paramFormat.auJ);
    return new com.google.android.exoplayer2.f.b.a(paramFormat.auu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.f.g.1
 * JD-Core Version:    0.7.0.1
 */