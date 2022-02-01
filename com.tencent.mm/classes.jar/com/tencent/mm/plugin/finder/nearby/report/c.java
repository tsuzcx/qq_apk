package com.tencent.mm.plugin.finder.nearby.report;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.ab;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/report/NearbyPersonReporter;", "", "()V", "TAG", "", "sessionId", "onConfirmClearAndExitClick", "", "onFilterActionSelect", "filterType", "", "onFilterButtonClick", "onUserClick", "userName", "district", "country", "city", "ifSns", "", "onUserExpose", "report", "distance", "", "action", "plugin-finder-nearby_release"})
public final class c
{
  private static String sessionId;
  public static final c zJb;
  
  static
  {
    AppMethodBeat.i(199721);
    zJb = new c();
    sessionId = "";
    AppMethodBeat.o(199721);
  }
  
  public static void OE(int paramInt)
  {
    AppMethodBeat.i(199713);
    long l;
    switch (paramInt)
    {
    default: 
      l = 3L;
    }
    for (;;)
    {
      a("", 0L, "", "", "", 0L, 3L, l);
      AppMethodBeat.o(199713);
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
    AppMethodBeat.i(199720);
    ab localab = new ab();
    if (TextUtils.isEmpty((CharSequence)sessionId))
    {
      String str = ((com.tencent.mm.plugin.expt.b.c)h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      sessionId = (String)localObject;
    }
    localab.iO(sessionId);
    localab.iP(e.zJs.agX());
    Object localObject = e.zJs;
    localab.iQ(e.dMy());
    localab.agN();
    localab.iS(paramString1);
    localab.iU(paramString2);
    localab.iT(paramString3);
    localab.cl(paramLong1);
    localab.iR(paramString4);
    localab.cm(paramLong2);
    localab.cn(paramLong3);
    localab.co(cm.bfE());
    localab.cp(paramLong4);
    localab.bpa();
    Log.d("NearbyPersonReporter", "report " + localab.agI());
    AppMethodBeat.o(199720);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(199716);
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
      AppMethodBeat.o(199716);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.report.c
 * JD-Core Version:    0.7.0.1
 */