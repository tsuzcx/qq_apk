package com.tencent.mm.model.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public final class f
{
  public static void a(e parame)
  {
    AppMethodBeat.i(153096);
    if ((parame != null) && (g.azO().azM()))
    {
      String str1 = g.azO().hqm.hqi;
      String str2 = parame.id;
      String str3 = parame.id;
      String str4 = parame.endTime - parame.startTime;
      String str5 = parame.result;
      String str6 = parame.hqo;
      long l = parame.gRQ;
      ac.i("MicroMsg.abtest.AbTestReportHelper", "TestCaseID:%s TestPointsID:%s TestReportID：%s TetsCheckID:%s TestDurationTime:%s TestActionResult:%s, TestActionScene:%d", new Object[] { str1, str2, str6, str3, str4, str5, Long.valueOf(l) });
      h.wUl.f(11394, new Object[] { str1, str2, str6, str3, str4, str5, Long.valueOf(l) });
    }
    AppMethodBeat.o(153096);
  }
  
  private static void a(e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(153095);
    if ((parame == null) || (!g.azO().azM()))
    {
      ac.w("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast abtest faild. abTestPoint or testcase is null.");
      AppMethodBeat.o(153095);
      return;
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    if (paramBoolean) {}
    for (StringBuilder localStringBuilder1 = localStringBuilder2.append("TestPointStart:");; localStringBuilder1 = localStringBuilder2.append("TestPointEnd:"))
    {
      localStringBuilder2.append(localStringBuilder1);
      localStringBuilder2.append(g.azO().hqm.hqi);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.id);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.hqo);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.hqo);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.hqp);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.result);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.gRQ);
      yH(localStringBuilder2.toString());
      AppMethodBeat.o(153095);
      return;
    }
  }
  
  private static void yH(String paramString)
  {
    AppMethodBeat.i(153094);
    ac.i("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast:%s", new Object[] { paramString });
    if (g.azO().azM())
    {
      Intent localIntent = new Intent();
      localIntent.setAction("com.tencent.mm.ui.ACTION_ABTEST");
      localIntent.putExtra("content", paramString);
      ai.getContext().sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
      AppMethodBeat.o(153094);
      return;
    }
    ac.i("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast abtest faild. no test case.");
    AppMethodBeat.o(153094);
  }
  
  public static void yI(String paramString)
  {
    AppMethodBeat.i(153097);
    ac.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] startAbTestCase: start abtest click stream");
    yH("TestCaseID:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(153097);
  }
  
  public static void yJ(String paramString)
  {
    AppMethodBeat.i(153098);
    if (g.azO().yF(paramString) != null)
    {
      ac.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] startAbTestPoint:%s", new Object[] { paramString });
      g.azO().yF(paramString).hqp = System.currentTimeMillis();
      g.azO().yF(paramString).startTime = System.currentTimeMillis();
      g.azO().yF(paramString).hqq = false;
      g.azO().yF(paramString).result = "0";
      a(g.azO().yF(paramString), true);
    }
    AppMethodBeat.o(153098);
  }
  
  public static void yK(String paramString)
  {
    AppMethodBeat.i(153099);
    if ((g.azO().yF(paramString) != null) && (!g.azO().yF(paramString).hqq))
    {
      ac.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] endAbTestPoint:%s", new Object[] { paramString });
      g.azO().yF(paramString).hqp = System.currentTimeMillis();
      g.azO().yF(paramString).endTime = System.currentTimeMillis();
      g.azO().yF(paramString).hqq = true;
      a(g.azO().yF(paramString));
      a(g.azO().yF(paramString), false);
    }
    AppMethodBeat.o(153099);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.a.f
 * JD-Core Version:    0.7.0.1
 */