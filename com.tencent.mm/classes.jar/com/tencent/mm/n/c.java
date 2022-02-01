package com.tencent.mm.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
{
  public static int awC()
  {
    AppMethodBeat.i(149991);
    int i = Util.getInt(h.axc().getValue("InputLimitSNSObjectText"), 2000);
    AppMethodBeat.o(149991);
    return i * 2;
  }
  
  public static int awD()
  {
    AppMethodBeat.i(149992);
    int i = Util.getInt(h.axc().getValue("SnsCommentMaxSize"), 1000);
    AppMethodBeat.o(149992);
    return i * 2;
  }
  
  public static int awE()
  {
    AppMethodBeat.i(149993);
    int i = Util.getInt(h.axc().getValue("InputLimitFavText"), 100000);
    AppMethodBeat.o(149993);
    return i * 2;
  }
  
  public static int awF()
  {
    AppMethodBeat.i(213603);
    int i = Util.getInt(h.axc().getValue("InputLimitSendEmotionBufSize"), 10485760);
    AppMethodBeat.o(213603);
    return i;
  }
  
  public static int awG()
  {
    AppMethodBeat.i(149994);
    int i = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vDk, 1);
    Log.i("MicroMsg.BoundaryConfig", "getCustomEmojiMaxSize: %s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(149994);
    return i * 1048576;
  }
  
  public static int awH()
  {
    AppMethodBeat.i(149995);
    try
    {
      int i = Util.getInt(h.axc().getValue("InputLimitSendEmotionWidth"), 1024);
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
  
  public static int awI()
  {
    AppMethodBeat.i(149996);
    try
    {
      int i = Util.getInt(h.axc().getValue("InputLimitSendAppMsgEmotionBufSize"), 5242880);
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
  
  public static long awJ()
  {
    AppMethodBeat.i(213612);
    long l = Util.getLong(h.axc().getValue("InputLimitVideoSize"), 26214400L);
    AppMethodBeat.o(213612);
    return l;
  }
  
  public static long awK()
  {
    AppMethodBeat.i(213616);
    String str = h.axc().getValue("InputLimitSendFileSize");
    Log.i("MicroMsg.BoundaryConfig", "MaxSendFileSize, svrLimit:%s, localLimit:%s", new Object[] { str, Long.valueOf(104857600L) });
    long l = Util.getLong(str, 104857600L);
    AppMethodBeat.o(213616);
    return l;
  }
  
  public static long awL()
  {
    AppMethodBeat.i(213618);
    try
    {
      String str = ((a)com.tencent.mm.kernel.h.ae(a.class)).axc().getValue("InputLimitFavFileSize");
      if (Util.isNullOrNil(str)) {
        Log.i("MicroMsg.BoundaryConfig", "getFileSizeLimit nullOrNil");
      }
      for (;;)
      {
        long l = Util.getLong(str, 104857600L);
        AppMethodBeat.o(213618);
        return l;
        Log.i("MicroMsg.BoundaryConfig", "getFileSizeLimit ".concat(String.valueOf(str)));
      }
      return 104857600L;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("MicroMsg.BoundaryConfig", localThrowable, "getMaxFavFileSize", new Object[0]);
      AppMethodBeat.o(213618);
    }
  }
  
  public static String awM()
  {
    AppMethodBeat.i(149998);
    String str = h.axc().getValue("InputLimitForbiddenChar");
    AppMethodBeat.o(149998);
    return str;
  }
  
  public static long awN()
  {
    AppMethodBeat.i(177286);
    String str = h.axc().getValue("InputLimitGroupFileTotalSize");
    Log.d("MicroMsg.BoundaryConfig", "MaxMultipleFileTotalSize, svrLimit:%s, localLimit:%s", new Object[] { str, Long.valueOf(1073741824L) });
    long l = Util.getLong(str, 1073741824L);
    AppMethodBeat.o(177286);
    return l;
  }
  
  public static long awO()
  {
    AppMethodBeat.i(213621);
    String str = h.axc().getValue("InputLimitFavNotesSize");
    Log.d("MicroMsg.BoundaryConfig", "getMaxFavNoteSize, svrLimit:%s, localLimit:%s", new Object[] { str, Long.valueOf(1073741824L) });
    long l = Util.getLong(str, 1073741824L);
    AppMethodBeat.o(213621);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.n.c
 * JD-Core Version:    0.7.0.1
 */