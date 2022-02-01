package com.tencent.mm.model.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

public final class f
{
  private static void Ci(String paramString)
  {
    AppMethodBeat.i(153094);
    ae.i("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast:%s", new Object[] { paramString });
    if (g.aDh().aDf())
    {
      Intent localIntent = new Intent();
      localIntent.setAction("com.tencent.mm.ui.ACTION_ABTEST");
      localIntent.putExtra("content", paramString);
      ak.getContext().sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
      AppMethodBeat.o(153094);
      return;
    }
    ae.i("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast abtest faild. no test case.");
    AppMethodBeat.o(153094);
  }
  
  public static void Cj(String paramString)
  {
    AppMethodBeat.i(153097);
    ae.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] startAbTestCase: start abtest click stream");
    Ci("TestCaseID:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(153097);
  }
  
  public static void Ck(String paramString)
  {
    AppMethodBeat.i(153098);
    if (g.aDh().Cg(paramString) != null)
    {
      ae.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] startAbTestPoint:%s", new Object[] { paramString });
      g.aDh().Cg(paramString).hLA = System.currentTimeMillis();
      g.aDh().Cg(paramString).startTime = System.currentTimeMillis();
      g.aDh().Cg(paramString).hLB = false;
      g.aDh().Cg(paramString).result = "0";
      a(g.aDh().Cg(paramString), true);
    }
    AppMethodBeat.o(153098);
  }
  
  public static void Cl(String paramString)
  {
    AppMethodBeat.i(153099);
    if ((g.aDh().Cg(paramString) != null) && (!g.aDh().Cg(paramString).hLB))
    {
      ae.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] endAbTestPoint:%s", new Object[] { paramString });
      g.aDh().Cg(paramString).hLA = System.currentTimeMillis();
      g.aDh().Cg(paramString).endTime = System.currentTimeMillis();
      g.aDh().Cg(paramString).hLB = true;
      a(g.aDh().Cg(paramString));
      a(g.aDh().Cg(paramString), false);
    }
    AppMethodBeat.o(153099);
  }
  
  public static void a(e parame)
  {
    AppMethodBeat.i(153096);
    if ((parame != null) && (g.aDh().aDf()))
    {
      String str1 = g.aDh().hLx.hLt;
      String str2 = parame.id;
      String str3 = parame.id;
      String str4 = parame.endTime - parame.startTime;
      String str5 = parame.result;
      String str6 = parame.hLz;
      long l = parame.hmW;
      ae.i("MicroMsg.abtest.AbTestReportHelper", "TestCaseID:%s TestPointsID:%s TestReportID：%s TetsCheckID:%s TestDurationTime:%s TestActionResult:%s, TestActionScene:%d", new Object[] { str1, str2, str6, str3, str4, str5, Long.valueOf(l) });
      com.tencent.mm.plugin.report.service.g.yxI.f(11394, new Object[] { str1, str2, str6, str3, str4, str5, Long.valueOf(l) });
    }
    AppMethodBeat.o(153096);
  }
  
  private static void a(e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(153095);
    if ((parame == null) || (!g.aDh().aDf()))
    {
      ae.w("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast abtest faild. abTestPoint or testcase is null.");
      AppMethodBeat.o(153095);
      return;
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    if (paramBoolean) {}
    for (StringBuilder localStringBuilder1 = localStringBuilder2.append("TestPointStart:");; localStringBuilder1 = localStringBuilder2.append("TestPointEnd:"))
    {
      localStringBuilder2.append(localStringBuilder1);
      localStringBuilder2.append(g.aDh().hLx.hLt);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.id);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.hLz);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.hLz);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.hLA);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.result);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.hmW);
      Ci(localStringBuilder2.toString());
      AppMethodBeat.o(153095);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.a.f
 * JD-Core Version:    0.7.0.1
 */