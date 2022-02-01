package com.tencent.mm.plugin.ipcall.model.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.em;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.util.ArrayList;

public final class c
  extends em
{
  public static IAutoDBItem.MAutoDBInfo info;
  public ArrayList<String> JJS;
  
  static
  {
    AppMethodBeat.i(25537);
    info = em.aJm();
    AppMethodBeat.o(25537);
  }
  
  public static boolean jH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(25536);
    if ((paramString1 == null) && (paramString2 != null))
    {
      AppMethodBeat.o(25536);
      return false;
    }
    if ((paramString1 != null) && (!paramString1.equals(paramString2)))
    {
      AppMethodBeat.o(25536);
      return false;
    }
    AppMethodBeat.o(25536);
    return true;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.h.c
 * JD-Core Version:    0.7.0.1
 */