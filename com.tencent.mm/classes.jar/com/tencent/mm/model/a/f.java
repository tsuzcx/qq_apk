package com.tencent.mm.model.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class f
{
  private static void BG(String paramString)
  {
    AppMethodBeat.i(153094);
    ad.i("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast:%s", new Object[] { paramString });
    if (g.aCR().aCP())
    {
      Intent localIntent = new Intent();
      localIntent.setAction("com.tencent.mm.ui.ACTION_ABTEST");
      localIntent.putExtra("content", paramString);
      aj.getContext().sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
      AppMethodBeat.o(153094);
      return;
    }
    ad.i("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast abtest faild. no test case.");
    AppMethodBeat.o(153094);
  }
  
  public static void BH(String paramString)
  {
    AppMethodBeat.i(153097);
    ad.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] startAbTestCase: start abtest click stream");
    BG("TestCaseID:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(153097);
  }
  
  public static void BI(String paramString)
  {
    AppMethodBeat.i(153098);
    if (g.aCR().BE(paramString) != null)
    {
      ad.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] startAbTestPoint:%s", new Object[] { paramString });
      g.aCR().BE(paramString).hIH = System.currentTimeMillis();
      g.aCR().BE(paramString).startTime = System.currentTimeMillis();
      g.aCR().BE(paramString).hII = false;
      g.aCR().BE(paramString).result = "0";
      a(g.aCR().BE(paramString), true);
    }
    AppMethodBeat.o(153098);
  }
  
  public static void BJ(String paramString)
  {
    AppMethodBeat.i(153099);
    if ((g.aCR().BE(paramString) != null) && (!g.aCR().BE(paramString).hII))
    {
      ad.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] endAbTestPoint:%s", new Object[] { paramString });
      g.aCR().BE(paramString).hIH = System.currentTimeMillis();
      g.aCR().BE(paramString).endTime = System.currentTimeMillis();
      g.aCR().BE(paramString).hII = true;
      a(g.aCR().BE(paramString));
      a(g.aCR().BE(paramString), false);
    }
    AppMethodBeat.o(153099);
  }
  
  public static void a(e parame)
  {
    AppMethodBeat.i(153096);
    if ((parame != null) && (g.aCR().aCP()))
    {
      String str1 = g.aCR().hIE.hIA;
      String str2 = parame.id;
      String str3 = parame.id;
      String str4 = parame.endTime - parame.startTime;
      String str5 = parame.result;
      String str6 = parame.hIG;
      long l = parame.hki;
      ad.i("MicroMsg.abtest.AbTestReportHelper", "TestCaseID:%s TestPointsID:%s TestReportID：%s TetsCheckID:%s TestDurationTime:%s TestActionResult:%s, TestActionScene:%d", new Object[] { str1, str2, str6, str3, str4, str5, Long.valueOf(l) });
      com.tencent.mm.plugin.report.service.g.yhR.f(11394, new Object[] { str1, str2, str6, str3, str4, str5, Long.valueOf(l) });
    }
    AppMethodBeat.o(153096);
  }
  
  private static void a(e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(153095);
    if ((parame == null) || (!g.aCR().aCP()))
    {
      ad.w("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast abtest faild. abTestPoint or testcase is null.");
      AppMethodBeat.o(153095);
      return;
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    if (paramBoolean) {}
    for (StringBuilder localStringBuilder1 = localStringBuilder2.append("TestPointStart:");; localStringBuilder1 = localStringBuilder2.append("TestPointEnd:"))
    {
      localStringBuilder2.append(localStringBuilder1);
      localStringBuilder2.append(g.aCR().hIE.hIA);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.id);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.hIG);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.hIG);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.hIH);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.result);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.hki);
      BG(localStringBuilder2.toString());
      AppMethodBeat.o(153095);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.a.f
 * JD-Core Version:    0.7.0.1
 */