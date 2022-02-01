package com.tencent.mm.plugin.emoji.magicemoji.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.ArrayList;
import java.util.List;

public final class a
{
  public static boolean xJU;
  private static final a.a xJV;
  private static final a.a xJW;
  private static final a.a xJX;
  public static final List<a.a> xJY;
  public static a.a xJZ;
  public static int xKa;
  
  static
  {
    AppMethodBeat.i(269986);
    xJU = false;
    xJV = new a.a("wx2690c73c8ea361df", "gh_487599f74952@app", 2);
    xJW = new a.a("wxee05a56a82581763", "gh_d01293fea884@app", 2);
    xJX = new a.a("wx9d5f7f0bf2dc950c", "gh_2ae1569f5edf@app", 0);
    ArrayList localArrayList = new ArrayList(2);
    xJY = localArrayList;
    localArrayList.add(xJW);
    xJY.add(xJX);
    dzh();
    xKa = 1763;
    AppMethodBeat.o(269986);
  }
  
  public static void Km(int paramInt)
  {
    xJZ.euz = paramInt;
  }
  
  public static boolean a(c paramc)
  {
    return (paramc == c.xKf) || (paramc == c.xKg) || (paramc == c.xKh);
  }
  
  public static void dzh()
  {
    AppMethodBeat.i(269970);
    boolean bool1 = WeChatEnvironment.hasDebugger();
    boolean bool2 = BuildInfo.DEBUG;
    Log.i("MicroMsg.ConstantsMagicEmoji", "hy: magic emoji has debugger %b isDebugPackage %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((bool1) || (bool2))
    {
      bool1 = MultiProcessMMKV.getDefault().decodeBool("magic_emoji_enable_debug", false);
      Log.i("MicroMsg.ConstantsMagicEmoji", "hy: magic emoji enable debug: %b", new Object[] { Boolean.valueOf(bool1) });
      xJU = bool1;
      if (!xJU) {
        break label163;
      }
      int i = MultiProcessMMKV.getSingleMMKV("__magic_emoji__").decodeInt("version_type", -1);
      xJZ = xJW;
      if (i > 0)
      {
        xJZ.euz = i;
        Log.i("MicroMsg.ConstantsMagicEmoji", "hy: updateDebugStatus: change versionType to ".concat(String.valueOf(i)));
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.ConstantsMagicEmoji", "hy: updateDebugStatus: in debug mode = " + xJU);
      AppMethodBeat.o(269970);
      return;
      xJU = false;
      break;
      label163:
      xJZ = xJX;
    }
  }
  
  public static enum c
  {
    static
    {
      AppMethodBeat.i(270026);
      xKc = new c("Ok", 0);
      xKd = new c("NoPkg", 1);
      xKe = new c("DownloadFailed", 2);
      xKf = new c("CrashTooMuch", 3);
      xKg = new c("DisabledByServer", 4);
      xKh = new c("MemoryWarningTooMuch", 5);
      xKi = new c("DownloadSucc", 6);
      xKj = new c("Unknown", 7);
      xKk = new c("DownloadFailedTooMuch", 8);
      xKl = new c("DownloadExpansionsFailed", 9);
      xKm = new c[] { xKc, xKd, xKe, xKf, xKg, xKh, xKi, xKj, xKk, xKl };
      AppMethodBeat.o(270026);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.d.a
 * JD-Core Version:    0.7.0.1
 */