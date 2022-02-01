package com.tencent.mm.plugin.luckymoney.story;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public final class b
{
  public static String openId;
  public static String sessionId;
  public static long startTime;
  public static String viH;
  public static int vua;
  public static Set<String> vub;
  public static int vuc;
  public static int vud;
  public static int vue;
  public static int vuf;
  public static int vug;
  public static int vuh;
  public static int vui;
  public static int vuj;
  
  static
  {
    AppMethodBeat.i(163682);
    vub = new HashSet();
    AppMethodBeat.o(163682);
  }
  
  public static void k(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(163680);
    openId = paramString1;
    viH = paramString2;
    vue = paramInt1;
    vuf = paramInt2;
    sessionId = UUID.randomUUID().toString();
    startTime = SystemClock.elapsedRealtime() / 1000L;
    AppMethodBeat.o(163680);
  }
  
  public static void tQ(int paramInt)
  {
    AppMethodBeat.i(163681);
    if ((!bt.isNullOrNil(openId)) && (!bt.isNullOrNil(sessionId)))
    {
      long l1 = SystemClock.elapsedRealtime() / 1000L;
      long l2 = startTime;
      g.yhR.f(18994, new Object[] { Integer.valueOf(paramInt), viH, Integer.valueOf(0), Integer.valueOf(vua), Integer.valueOf(vub.size()), Integer.valueOf(vuc), Integer.valueOf(vud), Integer.valueOf(vue), Integer.valueOf(vuf), sessionId, openId, Long.valueOf(l1 - l2), Integer.valueOf(vug), Integer.valueOf(vuh), Integer.valueOf(vui), Integer.valueOf(vuj) });
      viH = null;
      vua = 0;
      vub.clear();
      vuc = 0;
      vud = 0;
      vue = 0;
      vuf = 0;
      openId = null;
      startTime = 0L;
      vug = 0;
      vuh = 0;
      vui = 0;
      vuj = 0;
      sessionId = null;
    }
    AppMethodBeat.o(163681);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.b
 * JD-Core Version:    0.7.0.1
 */