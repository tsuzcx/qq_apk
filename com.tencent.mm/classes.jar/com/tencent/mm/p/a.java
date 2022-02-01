package com.tencent.mm.p;

import android.net.Uri;
import android.provider.BaseColumns;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static final class a
    implements BaseColumns
  {
    public static final Uri CONTENT_URI;
    
    static
    {
      AppMethodBeat.i(89138);
      CONTENT_URI = Uri.parse("content://com.tencent.mm.coolassist.debugprovider/config");
      AppMethodBeat.o(89138);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.p.a
 * JD-Core Version:    0.7.0.1
 */