package com.tencent.mm.model.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class f
{
  public static void a(e parame)
  {
    AppMethodBeat.i(118147);
    if ((parame != null) && (g.abw().abu()))
    {
      String str1 = g.abw().foj.fof;
      String str2 = parame.id;
      String str3 = parame.id;
      String str4 = parame.endTime - parame.startTime;
      String str5 = parame.result;
      String str6 = parame.fol;
      long l = parame.foo;
      ab.i("MicroMsg.abtest.AbTestReportHelper", "TestCaseID:%s TestPointsID:%s TestReportID：%s TetsCheckID:%s TestDurationTime:%s TestActionResult:%s, TestActionScene:%d", new Object[] { str1, str2, str6, str3, str4, str5, Long.valueOf(l) });
      h.qsU.e(11394, new Object[] { str1, str2, str6, str3, str4, str5, Long.valueOf(l) });
    }
    AppMethodBeat.o(118147);
  }
  
  private static void a(e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(118146);
    if ((parame == null) || (!g.abw().abu()))
    {
      ab.w("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast abtest faild. abTestPoint or testcase is null.");
      AppMethodBeat.o(118146);
      return;
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    if (paramBoolean) {}
    for (StringBuilder localStringBuilder1 = localStringBuilder2.append("TestPointStart:");; localStringBuilder1 = localStringBuilder2.append("TestPointEnd:"))
    {
      localStringBuilder2.append(localStringBuilder1);
      localStringBuilder2.append(g.abw().foj.fof);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.id);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.fol);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.fol);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.fom);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.result);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.foo);
      pN(localStringBuilder2.toString());
      AppMethodBeat.o(118146);
      return;
    }
  }
  
  private static void pN(String paramString)
  {
    AppMethodBeat.i(118145);
    ab.i("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast:%s", new Object[] { paramString });
    if (g.abw().abu())
    {
      Intent localIntent = new Intent();
      localIntent.setAction("com.tencent.mm.ui.ACTION_ABTEST");
      localIntent.putExtra("content", paramString);
      ah.getContext().sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
      AppMethodBeat.o(118145);
      return;
    }
    ab.i("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast abtest faild. no test case.");
    AppMethodBeat.o(118145);
  }
  
  public static void pO(String paramString)
  {
    AppMethodBeat.i(118148);
    ab.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] startAbTestCase: start abtest click stream");
    pN("TestCaseID:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(118148);
  }
  
  public static void pP(String paramString)
  {
    AppMethodBeat.i(118149);
    if (g.abw().pL(paramString) != null)
    {
      ab.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] startAbTestPoint:%s", new Object[] { paramString });
      g.abw().pL(paramString).fom = System.currentTimeMillis();
      g.abw().pL(paramString).startTime = System.currentTimeMillis();
      g.abw().pL(paramString).fon = false;
      g.abw().pL(paramString).result = "0";
      a(g.abw().pL(paramString), true);
    }
    AppMethodBeat.o(118149);
  }
  
  public static void pQ(String paramString)
  {
    AppMethodBeat.i(118150);
    if ((g.abw().pL(paramString) != null) && (!g.abw().pL(paramString).fon))
    {
      ab.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] endAbTestPoint:%s", new Object[] { paramString });
      g.abw().pL(paramString).fom = System.currentTimeMillis();
      g.abw().pL(paramString).endTime = System.currentTimeMillis();
      g.abw().pL(paramString).fon = true;
      a(g.abw().pL(paramString));
      a(g.abw().pL(paramString), false);
    }
    AppMethodBeat.o(118150);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.a.f
 * JD-Core Version:    0.7.0.1
 */