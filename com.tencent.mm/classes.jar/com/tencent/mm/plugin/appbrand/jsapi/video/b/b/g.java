package com.tencent.mm.plugin.appbrand.jsapi.video.b.b;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.a;

public final class g
{
  public final long absoluteStreamPosition;
  public final int flags;
  public final String key;
  public final long length;
  public final long position;
  public final int priority;
  public final Uri uri;
  public final String uuid;
  
  public g(Uri paramUri, long paramLong)
  {
    this(paramUri, paramLong, paramLong, -1L, null, 0, null, -1);
    AppMethodBeat.i(328507);
    AppMethodBeat.o(328507);
  }
  
  public g(Uri paramUri, long paramLong1, long paramLong2, long paramLong3, String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(328515);
    boolean bool;
    if (paramLong1 >= 0L) {
      bool = true;
    }
    label149:
    for (;;)
    {
      try
      {
        a.checkArgument(bool);
        if (paramLong2 >= 0L)
        {
          bool = true;
          a.checkArgument(bool);
          if (paramLong3 > 0L) {
            break label149;
          }
          if (paramLong3 == -1L)
          {
            break label149;
            a.checkArgument(bool);
            this.uri = paramUri;
            this.absoluteStreamPosition = paramLong1;
            this.position = paramLong2;
            this.length = paramLong3;
            this.key = paramString1;
            this.flags = paramInt1;
            this.uuid = paramString2;
            this.priority = paramInt2;
            AppMethodBeat.o(328515);
            return;
            bool = false;
          }
        }
        else
        {
          bool = false;
          continue;
        }
        bool = false;
        continue;
        bool = true;
      }
      catch (IllegalArgumentException paramUri)
      {
        paramUri = new m(paramUri);
        AppMethodBeat.o(328515);
        throw paramUri;
      }
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(328524);
    String str = "DataSpec[uri=" + this.uri + ", absPos=" + this.absoluteStreamPosition + ", pos=" + this.position + ", len=" + this.length + ", key=" + this.key + ", flags=" + this.flags + ", uuid=" + this.uuid + "]";
    AppMethodBeat.o(328524);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.b.g
 * JD-Core Version:    0.7.0.1
 */