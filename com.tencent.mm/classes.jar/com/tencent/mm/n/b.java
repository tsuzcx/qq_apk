package com.tencent.mm.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class b
{
  public static int acb()
  {
    AppMethodBeat.i(149991);
    int i = bt.getInt(g.acA().getValue("InputLimitSNSObjectText"), 2000);
    AppMethodBeat.o(149991);
    return i * 2;
  }
  
  public static int acc()
  {
    AppMethodBeat.i(149992);
    int i = bt.getInt(g.acA().getValue("SnsCommentMaxSize"), 1000);
    AppMethodBeat.o(149992);
    return i * 2;
  }
  
  public static int acd()
  {
    AppMethodBeat.i(149993);
    int i = bt.getInt(g.acA().getValue("InputLimitFavText"), 100000);
    AppMethodBeat.o(149993);
    return i * 2;
  }
  
  public static int ace()
  {
    AppMethodBeat.i(149994);
    int i = bt.getInt(g.acA().getValue("InputLimitSendEmotionBufSize"), 10485760);
    AppMethodBeat.o(149994);
    return i;
  }
  
  public static int acf()
  {
    AppMethodBeat.i(149995);
    try
    {
      int i = bt.getInt(g.acA().getValue("InputLimitSendEmotionWidth"), 1024);
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
  
  public static int acg()
  {
    AppMethodBeat.i(149996);
    try
    {
      int i = bt.getInt(g.acA().getValue("InputLimitSendAppMsgEmotionBufSize"), 5242880);
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
  
  public static int ach()
  {
    AppMethodBeat.i(149997);
    int i = bt.getInt(g.acA().getValue("InputLimitVideoSize"), 26214400);
    AppMethodBeat.o(149997);
    return i;
  }
  
  public static int aci()
  {
    AppMethodBeat.i(195194);
    String str = g.acA().getValue("InputLimitSendFileSize");
    ad.i("MicroMsg.BoundaryConfig", "MaxSendFileSize, svrLimit:%s, localLimit:%s", new Object[] { str, Integer.valueOf(104857600) });
    int i = bt.getInt(str, 104857600);
    AppMethodBeat.o(195194);
    return i;
  }
  
  public static String acj()
  {
    AppMethodBeat.i(149998);
    String str = g.acA().getValue("InputLimitForbiddenChar");
    AppMethodBeat.o(149998);
    return str;
  }
  
  public static long ack()
  {
    AppMethodBeat.i(177286);
    String str = g.acA().getValue("InputLimitGroupFileTotalSize");
    ad.d("MicroMsg.BoundaryConfig", "MaxMultipleFileTotalSize, svrLimit:%s, localLimit:%s", new Object[] { str, Long.valueOf(1073741824L) });
    long l = bt.getLong(str, 1073741824L);
    AppMethodBeat.o(177286);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.n.b
 * JD-Core Version:    0.7.0.1
 */