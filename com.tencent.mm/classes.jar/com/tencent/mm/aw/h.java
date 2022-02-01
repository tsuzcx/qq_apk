package com.tencent.mm.aw;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.sdk.platformtools.Log;

public final class h
{
  public String musicId;
  public dtj oPb;
  public String oPc;
  
  public static h a(String paramString, dtj paramdtj)
  {
    AppMethodBeat.i(231023);
    h localh = new h();
    localh.musicId = paramString;
    if (paramdtj != null) {}
    try
    {
      paramString = new dtj();
      paramString.parseFrom(paramdtj.toByteArray());
      localh.oPb = paramString;
      localh.oPc = paramString.oPc;
      AppMethodBeat.o(231023);
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
  
  public static h a(String paramString1, dtj paramdtj, String paramString2)
  {
    AppMethodBeat.i(231021);
    h localh = new h();
    localh.musicId = paramString1;
    if (paramdtj != null) {}
    try
    {
      paramString1 = new dtj();
      paramString1.parseFrom(paramdtj.toByteArray());
      localh.oPb = paramString1;
      localh.oPc = paramString2;
      AppMethodBeat.o(231021);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.aw.h
 * JD-Core Version:    0.7.0.1
 */