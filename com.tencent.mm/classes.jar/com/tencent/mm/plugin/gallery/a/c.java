package com.tencent.mm.plugin.gallery.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
{
  public static String aIG(String paramString)
  {
    AppMethodBeat.i(111740);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        Log.e("MicroMsg.AlbumAdapter.MIMEUtils", "unsupport type: %s", new Object[] { paramString });
        AppMethodBeat.o(111740);
        return "";
        if (paramString.equals("avc1"))
        {
          i = 0;
          continue;
          if (paramString.equals("mp4v"))
          {
            i = 1;
            continue;
            if (paramString.equals("encv"))
            {
              i = 2;
              continue;
              if (paramString.equals("hev1"))
              {
                i = 3;
                continue;
                if (paramString.equals("hvc1"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("mp4a")) {
                    i = 5;
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    AppMethodBeat.o(111740);
    return "video/avc";
    AppMethodBeat.o(111740);
    return "video/hevc";
    AppMethodBeat.o(111740);
    return "audio/mp4a-latm";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.a.c
 * JD-Core Version:    0.7.0.1
 */