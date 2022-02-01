package com.tencent.mm.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class b
{
  public static int YE()
  {
    AppMethodBeat.i(149991);
    int i = bt.getInt(g.Zd().getValue("InputLimitSNSObjectText"), 2000);
    AppMethodBeat.o(149991);
    return i * 2;
  }
  
  public static int YF()
  {
    AppMethodBeat.i(149992);
    int i = bt.getInt(g.Zd().getValue("SnsCommentMaxSize"), 1000);
    AppMethodBeat.o(149992);
    return i * 2;
  }
  
  public static int YG()
  {
    AppMethodBeat.i(149993);
    int i = bt.getInt(g.Zd().getValue("InputLimitFavText"), 100000);
    AppMethodBeat.o(149993);
    return i * 2;
  }
  
  public static int YH()
  {
    AppMethodBeat.i(149994);
    int i = bt.getInt(g.Zd().getValue("InputLimitSendEmotionBufSize"), 10485760);
    AppMethodBeat.o(149994);
    return i;
  }
  
  public static int YI()
  {
    AppMethodBeat.i(149995);
    try
    {
      int i = bt.getInt(g.Zd().getValue("InputLimitSendEmotionWidth"), 1024);
      AppMethodBeat.o(149995);
      return i;
    }
    catch (Exception localException)
    {
      ad.l("MicroMsg.BoundaryConfig", "getCustomEmojiMaxWidthAndHeight:%s", new Object[] { localException });
      AppMethodBeat.o(149995);
    }
    return 1024;
  }
  
  public static int YJ()
  {
    AppMethodBeat.i(149996);
    try
    {
      int i = bt.getInt(g.Zd().getValue("InputLimitSendAppMsgEmotionBufSize"), 5242880);
      AppMethodBeat.o(149996);
      return i;
    }
    catch (Exception localException)
    {
      ad.l("MicroMsg.BoundaryConfig", "getAppEmojiMsgMaxSize:%s", new Object[] { localException });
      AppMethodBeat.o(149996);
    }
    return 5242880;
  }
  
  public static int YK()
  {
    AppMethodBeat.i(149997);
    int i = bt.getInt(g.Zd().getValue("InputLimitVideoSize"), 26214400);
    AppMethodBeat.o(149997);
    return i;
  }
  
  public static String YL()
  {
    AppMethodBeat.i(149998);
    String str = g.Zd().getValue("InputLimitForbiddenChar");
    AppMethodBeat.o(149998);
    return str;
  }
  
  public static long YM()
  {
    AppMethodBeat.i(177286);
    String str = g.Zd().getValue("InputLimitGroupFileTotalSize");
    ad.d("MicroMsg.BoundaryConfig", "MaxMultipleFileTotalSize, svrLimit:%s, localLimit:%s", new Object[] { str, Long.valueOf(107374182400L) });
    long l = bt.getLong(str, 107374182400L);
    AppMethodBeat.o(177286);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.m.b
 * JD-Core Version:    0.7.0.1
 */