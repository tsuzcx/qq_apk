package com.tencent.mm.opensdk.utils;

import android.net.Uri;
import android.provider.BaseColumns;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  implements BaseColumns
{
  public static final Uri a;
  
  static
  {
    AppMethodBeat.i(255152);
    a = Uri.parse("content://com.tencent.mm.sdk.plugin.provider/sharedpref");
    AppMethodBeat.o(255152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.utils.a
 * JD-Core Version:    0.7.0.1
 */