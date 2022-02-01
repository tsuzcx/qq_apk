package com.tencent.mm.plugin.emoji.magicemoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.ArrayList;
import java.util.List;

public final class a
{
  public static boolean uBl;
  private static final a uBm;
  private static final a uBn;
  private static final a uBo;
  public static final List<a> uBp;
  public static a uBq;
  
  static
  {
    AppMethodBeat.i(245312);
    uBl = false;
    uBm = new a("wx2690c73c8ea361df", "gh_487599f74952@app", 2);
    uBn = new a("wxee05a56a82581763", "gh_d01293fea884@app", 0);
    uBo = new a("wx9d5f7f0bf2dc950c", "gh_2ae1569f5edf@app", 0);
    ArrayList localArrayList = new ArrayList(2);
    uBp = localArrayList;
    localArrayList.add(uBn);
    uBp.add(uBo);
    cUd();
    AppMethodBeat.o(245312);
  }
  
  public static boolean a(b paramb)
  {
    return (paramb == b.uBu) || (paramb == b.uBv) || (paramb == b.uBw);
  }
  
  public static void cUd()
  {
    AppMethodBeat.i(245310);
    boolean bool1 = WeChatEnvironment.hasDebugger();
    boolean bool2 = BuildInfo.DEBUG;
    Log.i("MicroMsg.ConstantsMagicEmoji", "hy: magic emoji has debugger %b isDebugPackage %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((bool1) || (bool2))
    {
      bool1 = MultiProcessMMKV.getDefault().decodeBool("magic_emoji_enable_debug", false);
      Log.i("MicroMsg.ConstantsMagicEmoji", "hy: magic emoji enable debug: %b", new Object[] { Boolean.valueOf(bool1) });
    }
    for (uBl = bool1; uBl; uBl = false)
    {
      uBq = uBn;
      AppMethodBeat.o(245310);
      return;
    }
    uBq = uBo;
    AppMethodBeat.o(245310);
  }
  
  public static final class a
  {
    public String appId;
    public int cBU;
    public String userName;
    
    public a(String paramString1, String paramString2, int paramInt)
    {
      this.appId = paramString1;
      this.userName = paramString2;
      this.cBU = paramInt;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(245032);
      String str = "AppIdBundle{appId='" + this.appId + '\'' + ", userName='" + this.userName + '\'' + ", versionType=" + this.cBU + '}';
      AppMethodBeat.o(245032);
      return str;
    }
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(245073);
      uBr = new b("Ok", 0);
      uBs = new b("NoPkg", 1);
      uBt = new b("DownloadFailed", 2);
      uBu = new b("CrashTooMuch", 3);
      uBv = new b("DisabledByServer", 4);
      uBw = new b("MemoryWarningTooMuch", 5);
      uBx = new b("DownloadSucc", 6);
      uBy = new b("Unknown", 7);
      uBz = new b("DownloadFailedTooMuch", 8);
      uBA = new b[] { uBr, uBs, uBt, uBu, uBv, uBw, uBx, uBy, uBz };
      AppMethodBeat.o(245073);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.b.a
 * JD-Core Version:    0.7.0.1
 */