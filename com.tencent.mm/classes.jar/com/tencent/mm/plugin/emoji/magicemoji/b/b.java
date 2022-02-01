package com.tencent.mm.plugin.emoji.magicemoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.crash.ICrashReporter.ICrashReportListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.o;
import java.io.IOException;

final class b
{
  private static final String qYF;
  boolean qYG;
  int qYH;
  ICrashReporter.ICrashReportListener qYI;
  
  static
  {
    AppMethodBeat.i(199714);
    qYF = com.tencent.mm.loader.j.b.aKA() + "cache/magic_emoji_crash";
    AppMethodBeat.o(199714);
  }
  
  b()
  {
    AppMethodBeat.i(199712);
    this.qYG = false;
    this.qYI = new ICrashReporter.ICrashReportListener()
    {
      public final void onCrashDumped(String paramAnonymousString)
      {
        AppMethodBeat.i(199711);
        if ((!paramAnonymousString.contains(") JSRuntimeME#")) && (!paramAnonymousString.contains(") ME.GLThread#")))
        {
          AppMethodBeat.o(199711);
          return;
        }
        paramAnonymousString = new o(b.qYF);
        if (!paramAnonymousString.exists()) {
          try
          {
            paramAnonymousString.createNewFile();
            AppMethodBeat.o(199711);
            return;
          }
          catch (IOException paramAnonymousString)
          {
            Log.printErrStackTrace("MicroMsg.MagicEmojiCrashMgr", paramAnonymousString, "dump magic emoji crash file failed", new Object[0]);
          }
        }
        AppMethodBeat.o(199711);
      }
    };
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleMMKV("MagicEmojiCrashCheck");
    int i = localMultiProcessMMKV.getInt("ClientVersion", -1);
    if ((i != -1) && (i != BuildInfo.CLIENT_VERSION_INT))
    {
      this.qYH = 0;
      localMultiProcessMMKV.putInt("ClientVersion", BuildInfo.CLIENT_VERSION_INT);
      localMultiProcessMMKV.putInt("CrashTimes", 0);
      Log.i("MicroMsg.MagicEmojiCrashMgr", "crash reset: client version %d to %d", new Object[] { Integer.valueOf(i), Integer.valueOf(BuildInfo.CLIENT_VERSION_INT) });
      AppMethodBeat.o(199712);
      return;
    }
    this.qYH = localMultiProcessMMKV.getInt("CrashTimes", 0);
    o localo = new o(qYF);
    if (localo.exists())
    {
      if (localo.delete())
      {
        this.qYH += 1;
        localMultiProcessMMKV.putInt("ClientVersion", BuildInfo.CLIENT_VERSION_INT);
        localMultiProcessMMKV.putInt("CrashTimes", this.qYH);
        h.CyF.dN(1622, 5);
        Log.i("MicroMsg.MagicEmojiCrashMgr", "crash found");
        AppMethodBeat.o(199712);
        return;
      }
      Log.i("MicroMsg.MagicEmojiCrashMgr", "crash found but delete failed: %s", new Object[] { qYF });
    }
    AppMethodBeat.o(199712);
  }
  
  final void cFA()
  {
    AppMethodBeat.i(199713);
    if (this.qYH > 0)
    {
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleMMKV("MagicEmojiCrashCheck");
      localMultiProcessMMKV.putInt("ClientVersion", BuildInfo.CLIENT_VERSION_INT);
      localMultiProcessMMKV.putInt("CrashTimes", 0);
      this.qYH = 0;
    }
    AppMethodBeat.o(199713);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.b.b
 * JD-Core Version:    0.7.0.1
 */