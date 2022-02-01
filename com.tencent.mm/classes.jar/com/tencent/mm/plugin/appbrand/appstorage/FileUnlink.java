package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.o;

public final class FileUnlink
{
  public static int MX(String paramString)
  {
    AppMethodBeat.i(175574);
    int i = unlink(o.k(paramString, true));
    AppMethodBeat.o(175574);
    return i;
  }
  
  public static native int unlink(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.FileUnlink
 * JD-Core Version:    0.7.0.1
 */