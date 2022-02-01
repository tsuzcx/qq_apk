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
  private static void Sm(String paramString)
  {
    AppMethodBeat.i(153094);
    Log.i("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast:%s", new Object[] { paramString });
    if (g.bga().bfY())
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
  
  public static void Sn(String paramString)
  {
    AppMethodBeat.i(153097);
    Log.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] startAbTestCase: start abtest click stream");
    Sm("TestCaseID:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(153097);
  }
  
  public static void So(String paramString)
  {
    AppMethodBeat.i(153098);
    if (g.bga().Sk(paramString) != null)
    {
      Log.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] startAbTestPoint:%s", new Object[] { paramString });
      g.bga().Sk(paramString).lwE = System.currentTimeMillis();
      g.bga().Sk(paramString).startTime = System.currentTimeMillis();
      g.bga().Sk(paramString).lwF = false;
      g.bga().Sk(paramString).result = "0";
      a(g.bga().Sk(paramString), true);
    }
    AppMethodBeat.o(153098);
  }
  
  public static void Sp(String paramString)
  {
    AppMethodBeat.i(153099);
    if ((g.bga().Sk(paramString) != null) && (!g.bga().Sk(paramString).lwF))
    {
      Log.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] endAbTestPoint:%s", new Object[] { paramString });
      g.bga().Sk(paramString).lwE = System.currentTimeMillis();
      g.bga().Sk(paramString).endTime = System.currentTimeMillis();
      g.bga().Sk(paramString).lwF = true;
      a(g.bga().Sk(paramString));
      a(g.bga().Sk(paramString), false);
    }
    AppMethodBeat.o(153099);
  }
  
  public static void a(e parame)
  {
    AppMethodBeat.i(153096);
    if ((parame != null) && (g.bga().bfY()))
    {
      String str1 = g.bga().lwB.lwy;
      String str2 = parame.id;
      String str3 = parame.id;
      String str4 = parame.endTime - parame.startTime;
      String str5 = parame.result;
      String str6 = parame.lwD;
      long l = parame.kVd;
      Log.i("MicroMsg.abtest.AbTestReportHelper", "TestCaseID:%s TestPointsID:%s TestReportID：%s TetsCheckID:%s TestDurationTime:%s TestActionResult:%s, TestActionScene:%d", new Object[] { str1, str2, str6, str3, str4, str5, Long.valueOf(l) });
      h.IzE.a(11394, new Object[] { str1, str2, str6, str3, str4, str5, Long.valueOf(l) });
    }
    AppMethodBeat.o(153096);
  }
  
  private static void a(e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(153095);
    if ((parame == null) || (!g.bga().bfY()))
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
      localStringBuilder2.append(g.bga().lwB.lwy);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.id);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.lwD);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.lwD);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.lwE);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.result);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.kVd);
      Sm(localStringBuilder2.toString());
      AppMethodBeat.o(153095);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.a.f
 * JD-Core Version:    0.7.0.1
 */