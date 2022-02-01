package com.tencent.mm.model.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class f
{
  public static void a(e parame)
  {
    AppMethodBeat.i(153096);
    if ((parame != null) && (g.asX().asV()))
    {
      String str1 = g.asX().gPM.gPI;
      String str2 = parame.id;
      String str3 = parame.id;
      String str4 = parame.endTime - parame.startTime;
      String str5 = parame.result;
      String str6 = parame.gPO;
      long l = parame.gri;
      ad.i("MicroMsg.abtest.AbTestReportHelper", "TestCaseID:%s TestPointsID:%s TestReportID：%s TetsCheckID:%s TestDurationTime:%s TestActionResult:%s, TestActionScene:%d", new Object[] { str1, str2, str6, str3, str4, str5, Long.valueOf(l) });
      h.vKh.f(11394, new Object[] { str1, str2, str6, str3, str4, str5, Long.valueOf(l) });
    }
    AppMethodBeat.o(153096);
  }
  
  private static void a(e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(153095);
    if ((parame == null) || (!g.asX().asV()))
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
      localStringBuilder2.append(g.asX().gPM.gPI);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.id);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.gPO);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.gPO);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.gPP);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.result);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.gri);
      uB(localStringBuilder2.toString());
      AppMethodBeat.o(153095);
      return;
    }
  }
  
  private static void uB(String paramString)
  {
    AppMethodBeat.i(153094);
    ad.i("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast:%s", new Object[] { paramString });
    if (g.asX().asV())
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
  
  public static void uC(String paramString)
  {
    AppMethodBeat.i(153097);
    ad.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] startAbTestCase: start abtest click stream");
    uB("TestCaseID:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(153097);
  }
  
  public static void uD(String paramString)
  {
    AppMethodBeat.i(153098);
    if (g.asX().uz(paramString) != null)
    {
      ad.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] startAbTestPoint:%s", new Object[] { paramString });
      g.asX().uz(paramString).gPP = System.currentTimeMillis();
      g.asX().uz(paramString).startTime = System.currentTimeMillis();
      g.asX().uz(paramString).gPQ = false;
      g.asX().uz(paramString).result = "0";
      a(g.asX().uz(paramString), true);
    }
    AppMethodBeat.o(153098);
  }
  
  public static void uE(String paramString)
  {
    AppMethodBeat.i(153099);
    if ((g.asX().uz(paramString) != null) && (!g.asX().uz(paramString).gPQ))
    {
      ad.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] endAbTestPoint:%s", new Object[] { paramString });
      g.asX().uz(paramString).gPP = System.currentTimeMillis();
      g.asX().uz(paramString).endTime = System.currentTimeMillis();
      g.asX().uz(paramString).gPQ = true;
      a(g.asX().uz(paramString));
      a(g.asX().uz(paramString), false);
    }
    AppMethodBeat.o(153099);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.a.f
 * JD-Core Version:    0.7.0.1
 */