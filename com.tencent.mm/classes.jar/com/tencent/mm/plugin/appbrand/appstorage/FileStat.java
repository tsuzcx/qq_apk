package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.s;

public class FileStat
{
  public static int b(String paramString, FileStructStat paramFileStructStat)
  {
    AppMethodBeat.i(175567);
    int i = stat(s.k(paramString, false), paramFileStructStat);
    AppMethodBeat.o(175567);
    return i;
  }
  
  public static native int stat(String paramString, FileStructStat paramFileStructStat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.FileStat
 * JD-Core Version:    0.7.0.1
 */