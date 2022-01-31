package com.google.android.exoplayer2.metadata;

import com.google.android.exoplayer2.Format;

final class c$1
  implements c
{
  public final boolean g(Format paramFormat)
  {
    paramFormat = paramFormat.aus;
    return ("application/id3".equals(paramFormat)) || ("application/x-emsg".equals(paramFormat)) || ("application/x-scte35".equals(paramFormat));
  }
  
  public final a h(Format paramFormat)
  {
    paramFormat = paramFormat.aus;
    int i = -1;
    switch (paramFormat.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
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
    return new com.google.android.exoplayer2.metadata.id3.a();
    return new com.google.android.exoplayer2.metadata.emsg.a();
    return new com.google.android.exoplayer2.metadata.scte35.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.c.1
 * JD-Core Version:    0.7.0.1
 */