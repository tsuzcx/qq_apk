package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dbr;
import com.tencent.mm.sdk.platformtools.Log;

public final class h
{
  public String fMd;
  public dbr lVY;
  public String lVZ;
  
  public static h a(String paramString, dbr paramdbr)
  {
    AppMethodBeat.i(248854);
    h localh = new h();
    localh.fMd = paramString;
    if (paramdbr != null) {}
    try
    {
      paramString = new dbr();
      paramString.parseFrom(paramdbr.toByteArray());
      localh.lVY = paramString;
      localh.lVZ = paramString.lVZ;
      AppMethodBeat.o(248854);
      return localh;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.MusicWrapperExtend", paramString, "alvinluo createMusicWrapperExtend exception", new Object[0]);
      }
    }
  }
  
  public static h a(String paramString1, dbr paramdbr, String paramString2)
  {
    AppMethodBeat.i(248853);
    h localh = new h();
    localh.fMd = paramString1;
    if (paramdbr != null) {}
    try
    {
      paramString1 = new dbr();
      paramString1.parseFrom(paramdbr.toByteArray());
      localh.lVY = paramString1;
      localh.lVZ = paramString2;
      AppMethodBeat.o(248853);
      return localh;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.MusicWrapperExtend", paramString1, "alvinluo createMusicWrapperExtend exception", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bb.h
 * JD-Core Version:    0.7.0.1
 */