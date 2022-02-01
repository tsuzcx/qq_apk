package com.tencent.mm.model.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatPermissions;

public final class f
{
  private static void KT(String paramString)
  {
    AppMethodBeat.i(153094);
    Log.i("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast:%s", new Object[] { paramString });
    if (g.aWT().aWR())
    {
      Intent localIntent = new Intent();
      localIntent.setAction("com.tencent.mm.ui.ACTION_ABTEST");
      localIntent.putExtra("content", paramString);
      MMApplicationContext.getContext().sendBroadcast(localIntent, WeChatPermissions.PERMISSION_MM_MESSAGE());
      AppMethodBeat.o(153094);
      return;
    }
    Log.i("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast abtest faild. no test case.");
    AppMethodBeat.o(153094);
  }
  
  public static void KU(String paramString)
  {
    AppMethodBeat.i(153097);
    Log.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] startAbTestCase: start abtest click stream");
    KT("TestCaseID:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(153097);
  }
  
  public static void KV(String paramString)
  {
    AppMethodBeat.i(153098);
    if (g.aWT().KR(paramString) != null)
    {
      Log.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] startAbTestPoint:%s", new Object[] { paramString });
      g.aWT().KR(paramString).iGC = System.currentTimeMillis();
      g.aWT().KR(paramString).startTime = System.currentTimeMillis();
      g.aWT().KR(paramString).iGD = false;
      g.aWT().KR(paramString).result = "0";
      a(g.aWT().KR(paramString), true);
    }
    AppMethodBeat.o(153098);
  }
  
  public static void KW(String paramString)
  {
    AppMethodBeat.i(153099);
    if ((g.aWT().KR(paramString) != null) && (!g.aWT().KR(paramString).iGD))
    {
      Log.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] endAbTestPoint:%s", new Object[] { paramString });
      g.aWT().KR(paramString).iGC = System.currentTimeMillis();
      g.aWT().KR(paramString).endTime = System.currentTimeMillis();
      g.aWT().KR(paramString).iGD = true;
      a(g.aWT().KR(paramString));
      a(g.aWT().KR(paramString), false);
    }
    AppMethodBeat.o(153099);
  }
  
  public static void a(e parame)
  {
    AppMethodBeat.i(153096);
    if ((parame != null) && (g.aWT().aWR()))
    {
      String str1 = g.aWT().iGz.iGw;
      String str2 = parame.id;
      String str3 = parame.id;
      String str4 = parame.endTime - parame.startTime;
      String str5 = parame.result;
      String str6 = parame.iGB;
      long l = parame.igp;
      Log.i("MicroMsg.abtest.AbTestReportHelper", "TestCaseID:%s TestPointsID:%s TestReportID：%s TetsCheckID:%s TestDurationTime:%s TestActionResult:%s, TestActionScene:%d", new Object[] { str1, str2, str6, str3, str4, str5, Long.valueOf(l) });
      h.CyF.a(11394, new Object[] { str1, str2, str6, str3, str4, str5, Long.valueOf(l) });
    }
    AppMethodBeat.o(153096);
  }
  
  private static void a(e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(153095);
    if ((parame == null) || (!g.aWT().aWR()))
    {
      Log.w("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast abtest faild. abTestPoint or testcase is null.");
      AppMethodBeat.o(153095);
      return;
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    if (paramBoolean) {}
    for (StringBuilder localStringBuilder1 = localStringBuilder2.append("TestPointStart:");; localStringBuilder1 = localStringBuilder2.append("TestPointEnd:"))
    {
      localStringBuilder2.append(localStringBuilder1);
      localStringBuilder2.append(g.aWT().iGz.iGw);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.id);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.iGB);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.iGB);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.iGC);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.result);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.igp);
      KT(localStringBuilder2.toString());
      AppMethodBeat.o(153095);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.a.f
 * JD-Core Version:    0.7.0.1
 */