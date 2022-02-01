package com.tencent.mm.plugin.emoji.magicemoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.crash.ICrashReporter.ICrashReportListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.q;
import java.io.IOException;

final class b
{
  private static final String uBB;
  boolean uBC;
  int uBD;
  ICrashReporter.ICrashReportListener uBE;
  
  static
  {
    AppMethodBeat.i(245290);
    uBB = com.tencent.mm.loader.j.b.aSC() + "cache/magic_emoji_crash";
    AppMethodBeat.o(245290);
  }
  
  b()
  {
    AppMethodBeat.i(245284);
    this.uBC = false;
    this.uBE = new ICrashReporter.ICrashReportListener()
    {
      public final void onCrashDumped(String paramAnonymousString)
      {
        AppMethodBeat.i(245400);
        if ((!paramAnonymousString.contains(") JSRuntimeME#")) && (!paramAnonymousString.contains(") ME.GLThread#")))
        {
          AppMethodBeat.o(245400);
          return;
        }
        paramAnonymousString = new q(b.uBB);
        if (!paramAnonymousString.ifE()) {
          try
          {
            paramAnonymousString.ifM();
            AppMethodBeat.o(245400);
            return;
          }
          catch (IOException paramAnonymousString)
          {
            Log.printErrStackTrace("MicroMsg.MagicEmojiCrashMgr", paramAnonymousString, "dump magic emoji crash file failed", new Object[0]);
          }
        }
        AppMethodBeat.o(245400);
      }
    };
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleMMKV("MagicEmojiCrashCheck");
    int i = localMultiProcessMMKV.getInt("ClientVersion", -1);
    if ((i != -1) && (i != BuildInfo.CLIENT_VERSION_INT))
    {
      this.uBD = 0;
      localMultiProcessMMKV.putInt("ClientVersion", BuildInfo.CLIENT_VERSION_INT);
      localMultiProcessMMKV.putInt("CrashTimes", 0);
      Log.i("MicroMsg.MagicEmojiCrashMgr", "crash reset: client version %d to %d", new Object[] { Integer.valueOf(i), Integer.valueOf(BuildInfo.CLIENT_VERSION_INT) });
      AppMethodBeat.o(245284);
      return;
    }
    this.uBD = localMultiProcessMMKV.getInt("CrashTimes", 0);
    q localq = new q(uBB);
    if (localq.ifE())
    {
      if (localq.cFq())
      {
        this.uBD += 1;
        localMultiProcessMMKV.putInt("ClientVersion", BuildInfo.CLIENT_VERSION_INT);
        localMultiProcessMMKV.putInt("CrashTimes", this.uBD);
        h.IzE.el(1622, 5);
        Log.i("MicroMsg.MagicEmojiCrashMgr", "crash found");
        AppMethodBeat.o(245284);
        return;
      }
      Log.i("MicroMsg.MagicEmojiCrashMgr", "crash found but delete failed: %s", new Object[] { uBB });
    }
    AppMethodBeat.o(245284);
  }
  
  final void cUe()
  {
    AppMethodBeat.i(245286);
    if (this.uBD > 0)
    {
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleMMKV("MagicEmojiCrashCheck");
      localMultiProcessMMKV.putInt("ClientVersion", BuildInfo.CLIENT_VERSION_INT);
      localMultiProcessMMKV.putInt("CrashTimes", 0);
      this.uBD = 0;
    }
    AppMethodBeat.o(245286);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.b.b
 * JD-Core Version:    0.7.0.1
 */