package com.tencent.mm.opensdk.utils;

import android.net.Uri;
import android.provider.BaseColumns;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c$b
  implements BaseColumns
{
  public static final Uri CONTENT_URI;
  
  static
  {
    AppMethodBeat.i(128064);
    CONTENT_URI = Uri.parse("content://com.tencent.mm.sdk.plugin.provider/sharedpref");
    AppMethodBeat.o(128064);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.opensdk.utils.c.b
 * JD-Core Version:    0.7.0.1
 */