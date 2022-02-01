package com.tencent.mm.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
{
  public static int aqj()
  {
    AppMethodBeat.i(149991);
    int i = Util.getInt(h.aqJ().getValue("InputLimitSNSObjectText"), 2000);
    AppMethodBeat.o(149991);
    return i * 2;
  }
  
  public static int aqk()
  {
    AppMethodBeat.i(149992);
    int i = Util.getInt(h.aqJ().getValue("SnsCommentMaxSize"), 1000);
    AppMethodBeat.o(149992);
    return i * 2;
  }
  
  public static int aql()
  {
    AppMethodBeat.i(149993);
    int i = Util.getInt(h.aqJ().getValue("InputLimitFavText"), 100000);
    AppMethodBeat.o(149993);
    return i * 2;
  }
  
  public static int aqm()
  {
    AppMethodBeat.i(223497);
    int i = Util.getInt(h.aqJ().getValue("InputLimitSendEmotionBufSize"), 10485760);
    AppMethodBeat.o(223497);
    return i;
  }
  
  public static int aqn()
  {
    AppMethodBeat.i(149994);
    int i = ((b)g.af(b.class)).a(b.a.rWF, 1);
    Log.i("MicroMsg.BoundaryConfig", "getCustomEmojiMaxSize: %s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(149994);
    return i * 1048576;
  }
  
  public static int aqo()
  {
    AppMethodBeat.i(149995);
    try
    {
      int i = Util.getInt(h.aqJ().getValue("InputLimitSendEmotionWidth"), 1024);
      AppMethodBeat.o(149995);
      return i;
    }
    catch (Exception localException)
    {
      Log.printDebugStack("MicroMsg.BoundaryConfig", "getCustomEmojiMaxWidthAndHeight:%s", new Object[] { localException });
      AppMethodBeat.o(149995);
    }
    return 1024;
  }
  
  public static int aqp()
  {
    AppMethodBeat.i(149996);
    try
    {
      int i = Util.getInt(h.aqJ().getValue("InputLimitSendAppMsgEmotionBufSize"), 5242880);
      AppMethodBeat.o(149996);
      return i;
    }
    catch (Exception localException)
    {
      Log.printDebugStack("MicroMsg.BoundaryConfig", "getAppEmojiMsgMaxSize:%s", new Object[] { localException });
      AppMethodBeat.o(149996);
    }
    return 5242880;
  }
  
  public static int aqq()
  {
    AppMethodBeat.i(149997);
    int i = Util.getInt(h.aqJ().getValue("InputLimitVideoSize"), 26214400);
    AppMethodBeat.o(149997);
    return i;
  }
  
  public static int aqr()
  {
    AppMethodBeat.i(223498);
    String str = h.aqJ().getValue("InputLimitSendFileSize");
    Log.i("MicroMsg.BoundaryConfig", "MaxSendFileSize, svrLimit:%s, localLimit:%s", new Object[] { str, Integer.valueOf(104857600) });
    int i = Util.getInt(str, 104857600);
    AppMethodBeat.o(223498);
    return i;
  }
  
  public static int aqs()
  {
    AppMethodBeat.i(223499);
    try
    {
      String str = ((a)g.af(a.class)).aqJ().getValue("InputLimitFavFileSize");
      if (Util.isNullOrNil(str)) {
        Log.i("MicroMsg.BoundaryConfig", "getFileSizeLimit nullOrNil");
      }
      for (;;)
      {
        int i = Util.getInt(str, 104857600);
        AppMethodBeat.o(223499);
        return i;
        Log.i("MicroMsg.BoundaryConfig", "getFileSizeLimit ".concat(String.valueOf(str)));
      }
      return 104857600;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("MicroMsg.BoundaryConfig", localThrowable, "getMaxFavFileSize", new Object[0]);
      AppMethodBeat.o(223499);
    }
  }
  
  public static String aqt()
  {
    AppMethodBeat.i(149998);
    String str = h.aqJ().getValue("InputLimitForbiddenChar");
    AppMethodBeat.o(149998);
    return str;
  }
  
  public static long aqu()
  {
    AppMethodBeat.i(177286);
    String str = h.aqJ().getValue("InputLimitGroupFileTotalSize");
    Log.d("MicroMsg.BoundaryConfig", "MaxMultipleFileTotalSize, svrLimit:%s, localLimit:%s", new Object[] { str, Long.valueOf(1073741824L) });
    long l = Util.getLong(str, 1073741824L);
    AppMethodBeat.o(177286);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.n.c
 * JD-Core Version:    0.7.0.1
 */