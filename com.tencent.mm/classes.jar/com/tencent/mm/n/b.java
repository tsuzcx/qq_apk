package com.tencent.mm.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class b
{
  public static int ack()
  {
    AppMethodBeat.i(149991);
    int i = bu.getInt(g.acL().getValue("InputLimitSNSObjectText"), 2000);
    AppMethodBeat.o(149991);
    return i * 2;
  }
  
  public static int acl()
  {
    AppMethodBeat.i(149992);
    int i = bu.getInt(g.acL().getValue("SnsCommentMaxSize"), 1000);
    AppMethodBeat.o(149992);
    return i * 2;
  }
  
  public static int acm()
  {
    AppMethodBeat.i(149993);
    int i = bu.getInt(g.acL().getValue("InputLimitFavText"), 100000);
    AppMethodBeat.o(149993);
    return i * 2;
  }
  
  public static int acn()
  {
    AppMethodBeat.i(218642);
    int i = bu.getInt(g.acL().getValue("InputLimitSendEmotionBufSize"), 10485760);
    AppMethodBeat.o(218642);
    return i;
  }
  
  public static int aco()
  {
    AppMethodBeat.i(149994);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qDL, 1);
    ae.i("MicroMsg.BoundaryConfig", "getCustomEmojiMaxSize: %s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(149994);
    return i * 1048576;
  }
  
  public static int acp()
  {
    AppMethodBeat.i(149995);
    try
    {
      int i = bu.getInt(g.acL().getValue("InputLimitSendEmotionWidth"), 1024);
      AppMethodBeat.o(149995);
      return i;
    }
    catch (Exception localException)
    {
      ae.l("MicroMsg.BoundaryConfig", "getCustomEmojiMaxWidthAndHeight:%s", new Object[] { localException });
      AppMethodBeat.o(149995);
    }
    return 1024;
  }
  
  public static int acq()
  {
    AppMethodBeat.i(149996);
    try
    {
      int i = bu.getInt(g.acL().getValue("InputLimitSendAppMsgEmotionBufSize"), 5242880);
      AppMethodBeat.o(149996);
      return i;
    }
    catch (Exception localException)
    {
      ae.l("MicroMsg.BoundaryConfig", "getAppEmojiMsgMaxSize:%s", new Object[] { localException });
      AppMethodBeat.o(149996);
    }
    return 5242880;
  }
  
  public static int acr()
  {
    AppMethodBeat.i(149997);
    int i = bu.getInt(g.acL().getValue("InputLimitVideoSize"), 26214400);
    AppMethodBeat.o(149997);
    return i;
  }
  
  public static int acs()
  {
    AppMethodBeat.i(218643);
    String str = g.acL().getValue("InputLimitSendFileSize");
    ae.i("MicroMsg.BoundaryConfig", "MaxSendFileSize, svrLimit:%s, localLimit:%s", new Object[] { str, Integer.valueOf(104857600) });
    int i = bu.getInt(str, 104857600);
    AppMethodBeat.o(218643);
    return i;
  }
  
  public static int act()
  {
    AppMethodBeat.i(218644);
    try
    {
      String str = ((a)com.tencent.mm.kernel.g.ab(a.class)).acL().getValue("InputLimitFavFileSize");
      if (bu.isNullOrNil(str)) {
        ae.i("MicroMsg.BoundaryConfig", "getFileSizeLimit nullOrNil");
      }
      for (;;)
      {
        int i = bu.getInt(str, 104857600);
        AppMethodBeat.o(218644);
        return i;
        ae.i("MicroMsg.BoundaryConfig", "getFileSizeLimit ".concat(String.valueOf(str)));
      }
      return 104857600;
    }
    catch (Throwable localThrowable)
    {
      ae.printErrStackTrace("MicroMsg.BoundaryConfig", localThrowable, "getMaxFavFileSize", new Object[0]);
      AppMethodBeat.o(218644);
    }
  }
  
  public static String acu()
  {
    AppMethodBeat.i(149998);
    String str = g.acL().getValue("InputLimitForbiddenChar");
    AppMethodBeat.o(149998);
    return str;
  }
  
  public static long acv()
  {
    AppMethodBeat.i(177286);
    String str = g.acL().getValue("InputLimitGroupFileTotalSize");
    ae.d("MicroMsg.BoundaryConfig", "MaxMultipleFileTotalSize, svrLimit:%s, localLimit:%s", new Object[] { str, Long.valueOf(1073741824L) });
    long l = bu.getLong(str, 1073741824L);
    AppMethodBeat.o(177286);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.n.b
 * JD-Core Version:    0.7.0.1
 */