package com.tencent.mm.model.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public final class f
{
  public static void a(e parame)
  {
    if ((parame != null) && (g.Iy().Iw()))
    {
      String str1 = g.Iy().dYf.dYb;
      String str2 = parame.id;
      String str3 = parame.id;
      String str4 = parame.endTime - parame.startTime;
      String str5 = parame.result;
      String str6 = parame.dYh;
      long l = parame.dYk;
      y.i("MicroMsg.abtest.AbTestReportHelper", "TestCaseID:%s TestPointsID:%s TestReportID：%s TetsCheckID:%s TestDurationTime:%s TestActionResult:%s, TestActionScene:%d", new Object[] { str1, str2, str6, str3, str4, str5, Long.valueOf(l) });
      h.nFQ.f(11394, new Object[] { str1, str2, str6, str3, str4, str5, Long.valueOf(l) });
    }
  }
  
  private static void a(e parame, boolean paramBoolean)
  {
    if ((parame == null) || (!g.Iy().Iw()))
    {
      y.w("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast abtest faild. abTestPoint or testcase is null.");
      return;
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    if (paramBoolean) {}
    for (StringBuilder localStringBuilder1 = localStringBuilder2.append("TestPointStart:");; localStringBuilder1 = localStringBuilder2.append("TestPointEnd:"))
    {
      localStringBuilder2.append(localStringBuilder1);
      localStringBuilder2.append(g.Iy().dYf.dYb);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.id);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.dYh);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.dYh);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.dYi);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.result);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.dYk);
      iZ(localStringBuilder2.toString());
      return;
    }
  }
  
  private static void iZ(String paramString)
  {
    y.i("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast:%s", new Object[] { paramString });
    if (g.Iy().Iw())
    {
      Intent localIntent = new Intent();
      localIntent.setAction("com.tencent.mm.ui.ACTION_ABTEST");
      localIntent.putExtra("content", paramString);
      ae.getContext().sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
      return;
    }
    y.i("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast abtest faild. no test case.");
  }
  
  public static void ja(String paramString)
  {
    y.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] startAbTestCase: start abtest click stream");
    iZ("TestCaseID:" + paramString);
  }
  
  public static void jb(String paramString)
  {
    if (g.Iy().iX(paramString) != null)
    {
      y.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] startAbTestPoint:%s", new Object[] { paramString });
      g.Iy().iX(paramString).dYi = System.currentTimeMillis();
      g.Iy().iX(paramString).startTime = System.currentTimeMillis();
      g.Iy().iX(paramString).dYj = false;
      g.Iy().iX(paramString).result = "0";
      a(g.Iy().iX(paramString), true);
    }
  }
  
  public static void jc(String paramString)
  {
    if ((g.Iy().iX(paramString) != null) && (!g.Iy().iX(paramString).dYj))
    {
      y.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] endAbTestPoint:%s", new Object[] { paramString });
      g.Iy().iX(paramString).dYi = System.currentTimeMillis();
      g.Iy().iX(paramString).endTime = System.currentTimeMillis();
      g.Iy().iX(paramString).dYj = true;
      a(g.Iy().iX(paramString));
      a(g.Iy().iX(paramString), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.a.f
 * JD-Core Version:    0.7.0.1
 */