package com.tencent.mm.plugin.finder.nearby.report;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.v;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/report/NearbyPersonReporter;", "", "()V", "TAG", "", "sessionId", "onConfirmClearAndExitClick", "", "onFilterActionSelect", "filterType", "", "onFilterButtonClick", "onUserClick", "userName", "district", "country", "city", "ifSns", "", "onUserExpose", "report", "distance", "", "action", "plugin-finder_release"})
public final class b
{
  private static String sessionId;
  public static final b uSZ;
  
  static
  {
    AppMethodBeat.i(249336);
    uSZ = new b();
    sessionId = "";
    AppMethodBeat.o(249336);
  }
  
  public static void JE(int paramInt)
  {
    AppMethodBeat.i(249333);
    long l;
    switch (paramInt)
    {
    default: 
      l = 3L;
    }
    for (;;)
    {
      a("", 0L, "", "", "", 0L, 3L, l);
      AppMethodBeat.o(249333);
      return;
      l = 1L;
      continue;
      l = 2L;
      continue;
      l = 3L;
      continue;
      l = 4L;
      continue;
      l = 5L;
      continue;
      l = 6L;
    }
  }
  
  public static void a(String paramString1, long paramLong1, String paramString2, String paramString3, String paramString4, long paramLong2, long paramLong3, long paramLong4)
  {
    AppMethodBeat.i(249335);
    v localv = new v();
    if (TextUtils.isEmpty((CharSequence)sessionId))
    {
      String str = ((c)g.af(c.class)).cMD();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      sessionId = (String)localObject;
    }
    localv.hU(sessionId);
    Object localObject = d.uTq;
    localv.hV(d.acj());
    localObject = d.uTq;
    localv.hW(d.dlz());
    localv.aca();
    localv.hY(paramString1);
    localv.ia(paramString2);
    localv.hZ(paramString3);
    localv.bR(paramLong1);
    localv.hX(paramString4);
    localv.bS(paramLong2);
    localv.bT(paramLong3);
    localv.bU(cl.aWA());
    localv.bV(paramLong4);
    localv.bfK();
    Log.d("NearbyPersonReporter", "report " + localv.abW());
    AppMethodBeat.o(249335);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(249334);
    String str3 = "";
    String str1 = str3;
    str2 = str3;
    for (;;)
    {
      try
      {
        if (n.a((CharSequence)paramString2, (CharSequence)" - ", false))
        {
          str2 = str3;
          str1 = paramString2.subSequence(n.a((CharSequence)paramString2, " - ", 0, false, 6) + 3, paramString2.length()).toString();
        }
        str2 = str1;
        if (!n.a((CharSequence)paramString2, (CharSequence)"公里", false)) {
          continue;
        }
        str2 = str1;
        l1 = Long.parseLong(paramString2.subSequence(0, n.a((CharSequence)paramString2, "公里", 0, false, 6)).toString());
        l1 *= 1000L;
        paramString2 = str1;
      }
      catch (Throwable paramString2)
      {
        Log.e("NearbyPersonReporter", paramString2.toString());
        paramString2 = str2;
        long l1 = 0L;
        continue;
        long l2 = 0L;
        continue;
        l1 = 0L;
        continue;
      }
      if (!paramBoolean) {
        continue;
      }
      l2 = 1L;
      a(paramString1, l1, paramString3, paramString4, paramString2, l2, paramLong, 3L);
      AppMethodBeat.o(249334);
      return;
      str2 = str1;
      if (!n.a((CharSequence)paramString2, (CharSequence)"米", false)) {
        continue;
      }
      str2 = str1;
      l1 = Long.parseLong(paramString2.subSequence(0, n.a((CharSequence)paramString2, "米", 0, false, 6)).toString());
      paramString2 = str1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.report.b
 * JD-Core Version:    0.7.0.1
 */