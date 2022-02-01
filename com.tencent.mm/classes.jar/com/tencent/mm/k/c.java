package com.tencent.mm.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
{
  public static int aRc()
  {
    AppMethodBeat.i(149991);
    int i = Util.getInt(i.aRC().getValue("InputLimitSNSObjectText"), 2000);
    AppMethodBeat.o(149991);
    return i * 2;
  }
  
  public static int aRd()
  {
    AppMethodBeat.i(149992);
    int i = Util.getInt(i.aRC().getValue("SnsCommentMaxSize"), 1000);
    AppMethodBeat.o(149992);
    return i * 2;
  }
  
  public static int aRe()
  {
    AppMethodBeat.i(149993);
    int i = Util.getInt(i.aRC().getValue("InputLimitFavText"), 100000);
    AppMethodBeat.o(149993);
    return i * 2;
  }
  
  public static int aRf()
  {
    AppMethodBeat.i(231785);
    int i = Util.getInt(i.aRC().getValue("InputLimitSendEmotionBufSize"), 10485760);
    AppMethodBeat.o(231785);
    return i;
  }
  
  public static int aRg()
  {
    AppMethodBeat.i(149994);
    int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yRG, 1);
    Log.i("MicroMsg.BoundaryConfig", "getCustomEmojiMaxSize: %s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(149994);
    return i * 1048576;
  }
  
  public static int aRh()
  {
    AppMethodBeat.i(149995);
    try
    {
      int i = Util.getInt(i.aRC().getValue("InputLimitSendEmotionWidth"), 1024);
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
  
  public static int aRi()
  {
    AppMethodBeat.i(149996);
    try
    {
      int i = Util.getInt(i.aRC().getValue("InputLimitSendAppMsgEmotionBufSize"), 5242880);
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
  
  public static long aRj()
  {
    AppMethodBeat.i(231791);
    long l = Util.getLong(i.aRC().getValue("InputLimitVideoSize"), 26214400L);
    AppMethodBeat.o(231791);
    return l;
  }
  
  public static long aRk()
  {
    AppMethodBeat.i(231794);
    String str = i.aRC().getValue("InputLimitSendFileSize");
    Log.i("MicroMsg.BoundaryConfig", "MaxSendFileSize, svrLimit:%s, localLimit:%s", new Object[] { str, Long.valueOf(104857600L) });
    long l = Util.getLong(str, 104857600L);
    AppMethodBeat.o(231794);
    return l;
  }
  
  public static long aRl()
  {
    AppMethodBeat.i(231796);
    try
    {
      String str = ((a)h.ax(a.class)).aRC().getValue("InputLimitFavFileSize");
      if (Util.isNullOrNil(str)) {
        Log.i("MicroMsg.BoundaryConfig", "getFileSizeLimit nullOrNil");
      }
      for (;;)
      {
        long l = Util.getLong(str, 104857600L);
        AppMethodBeat.o(231796);
        return l;
        Log.i("MicroMsg.BoundaryConfig", "getFileSizeLimit ".concat(String.valueOf(str)));
      }
      return 104857600L;
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.BoundaryConfig", localThrowable, "getMaxFavFileSize", new Object[0]);
      AppMethodBeat.o(231796);
    }
  }
  
  public static String aRm()
  {
    AppMethodBeat.i(149998);
    String str = i.aRC().getValue("InputLimitForbiddenChar");
    AppMethodBeat.o(149998);
    return str;
  }
  
  public static long aRn()
  {
    AppMethodBeat.i(177286);
    String str = i.aRC().getValue("InputLimitGroupFileTotalSize");
    Log.d("MicroMsg.BoundaryConfig", "MaxMultipleFileTotalSize, svrLimit:%s, localLimit:%s", new Object[] { str, Long.valueOf(1073741824L) });
    long l = Util.getLong(str, 1073741824L);
    AppMethodBeat.o(177286);
    return l;
  }
  
  public static long aRo()
  {
    AppMethodBeat.i(231801);
    String str = i.aRC().getValue("InputLimitFavNotesSize");
    Log.d("MicroMsg.BoundaryConfig", "getMaxFavNoteSize, svrLimit:%s, localLimit:%s", new Object[] { str, Long.valueOf(1073741824L) });
    long l = Util.getLong(str, 1073741824L);
    AppMethodBeat.o(231801);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.k.c
 * JD-Core Version:    0.7.0.1
 */