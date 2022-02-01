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
  private static void Ko(String paramString)
  {
    AppMethodBeat.i(153094);
    Log.i("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast:%s", new Object[] { paramString });
    if (g.bDR().bDP())
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
  
  public static void Kp(String paramString)
  {
    AppMethodBeat.i(153097);
    Log.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] startAbTestCase: start abtest click stream");
    Ko("TestCaseID:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(153097);
  }
  
  public static void Kq(String paramString)
  {
    AppMethodBeat.i(153098);
    if (g.bDR().Km(paramString) != null)
    {
      Log.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] startAbTestPoint:%s", new Object[] { paramString });
      g.bDR().Km(paramString).ood = System.currentTimeMillis();
      g.bDR().Km(paramString).startTime = System.currentTimeMillis();
      g.bDR().Km(paramString).ooe = false;
      g.bDR().Km(paramString).result = "0";
      a(g.bDR().Km(paramString), true);
    }
    AppMethodBeat.o(153098);
  }
  
  public static void Kr(String paramString)
  {
    AppMethodBeat.i(153099);
    if ((g.bDR().Km(paramString) != null) && (!g.bDR().Km(paramString).ooe))
    {
      Log.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] endAbTestPoint:%s", new Object[] { paramString });
      g.bDR().Km(paramString).ood = System.currentTimeMillis();
      g.bDR().Km(paramString).endTime = System.currentTimeMillis();
      g.bDR().Km(paramString).ooe = true;
      a(g.bDR().Km(paramString));
      a(g.bDR().Km(paramString), false);
    }
    AppMethodBeat.o(153099);
  }
  
  public static void a(e parame)
  {
    AppMethodBeat.i(153096);
    if ((parame != null) && (g.bDR().bDP()))
    {
      String str1 = g.bDR().ooa.onX;
      String str2 = parame.id;
      String str3 = parame.id;
      String str4 = parame.endTime - parame.startTime;
      String str5 = parame.result;
      String str6 = parame.ooc;
      long l = parame.nAz;
      Log.i("MicroMsg.abtest.AbTestReportHelper", "TestCaseID:%s TestPointsID:%s TestReportID：%s TetsCheckID:%s TestDurationTime:%s TestActionResult:%s, TestActionScene:%d", new Object[] { str1, str2, str6, str3, str4, str5, Long.valueOf(l) });
      h.OAn.b(11394, new Object[] { str1, str2, str6, str3, str4, str5, Long.valueOf(l) });
    }
    AppMethodBeat.o(153096);
  }
  
  private static void a(e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(153095);
    if ((parame == null) || (!g.bDR().bDP()))
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
      localStringBuilder2.append(g.bDR().ooa.onX);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.id);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.ooc);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.ooc);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.ood);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.result);
      localStringBuilder2.append("_");
      localStringBuilder2.append(parame.nAz);
      Ko(localStringBuilder2.toString());
      AppMethodBeat.o(153095);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.a.f
 * JD-Core Version:    0.7.0.1
 */