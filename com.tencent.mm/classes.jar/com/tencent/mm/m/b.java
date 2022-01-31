package com.tencent.mm.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class b
{
  public static int MR()
  {
    AppMethodBeat.i(77655);
    int i = bo.getInt(g.Nq().getValue("InputLimitSNSObjectText"), 2000);
    AppMethodBeat.o(77655);
    return i * 2;
  }
  
  public static int MS()
  {
    AppMethodBeat.i(77656);
    int i = bo.getInt(g.Nq().getValue("SnsCommentMaxSize"), 1000);
    AppMethodBeat.o(77656);
    return i * 2;
  }
  
  public static int MT()
  {
    AppMethodBeat.i(77657);
    int i = bo.getInt(g.Nq().getValue("InputLimitFavText"), 100000);
    AppMethodBeat.o(77657);
    return i * 2;
  }
  
  public static int MU()
  {
    AppMethodBeat.i(77658);
    int i = bo.getInt(g.Nq().getValue("InputLimitSendEmotionBufSize"), 10485760);
    AppMethodBeat.o(77658);
    return i;
  }
  
  public static int MV()
  {
    AppMethodBeat.i(77659);
    try
    {
      int i = bo.getInt(g.Nq().getValue("InputLimitSendEmotionWidth"), 1024);
      AppMethodBeat.o(77659);
      return i;
    }
    catch (Exception localException)
    {
      ab.a("MicroMsg.BoundaryConfig", "getCustomEmojiMaxWidthAndHeight:%s", new Object[] { localException });
      AppMethodBeat.o(77659);
    }
    return 1024;
  }
  
  public static int MW()
  {
    AppMethodBeat.i(77660);
    try
    {
      int i = bo.getInt(g.Nq().getValue("InputLimitSendAppMsgEmotionBufSize"), 5242880);
      AppMethodBeat.o(77660);
      return i;
    }
    catch (Exception localException)
    {
      ab.a("MicroMsg.BoundaryConfig", "getAppEmojiMsgMaxSize:%s", new Object[] { localException });
      AppMethodBeat.o(77660);
    }
    return 5242880;
  }
  
  public static int MX()
  {
    AppMethodBeat.i(77661);
    if (!com.tencent.mm.kernel.g.RJ().QU())
    {
      AppMethodBeat.o(77661);
      return 26214400;
    }
    int i = bo.getInt(g.Nq().getValue("InputLimitFavImageSize"), 26214400);
    AppMethodBeat.o(77661);
    return i;
  }
  
  public static int MY()
  {
    AppMethodBeat.i(77662);
    int i = bo.getInt(g.Nq().getValue("InputLimitVideoSize"), 26214400);
    AppMethodBeat.o(77662);
    return i;
  }
  
  public static String MZ()
  {
    AppMethodBeat.i(77663);
    String str = g.Nq().getValue("InputLimitForbiddenChar");
    AppMethodBeat.o(77663);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.m.b
 * JD-Core Version:    0.7.0.1
 */