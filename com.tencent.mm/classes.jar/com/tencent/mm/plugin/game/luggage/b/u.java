package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.d.f;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bi;
import com.tencent.mm.plugin.webview.ui.tools.game.c;
import com.tencent.mm.plugin.webview.ui.tools.game.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public class u
  extends bi<f>
{
  public final void a(Context paramContext, String paramString, bh.a parama) {}
  
  public final void b(a.a parama)
  {
    AppMethodBeat.i(135885);
    Object localObject = parama.byF.bxK;
    String str1 = ((JSONObject)localObject).optString("reportId");
    boolean bool1;
    if (((JSONObject)localObject).optInt("reportInstantly", 0) == 1)
    {
      bool1 = true;
      if (((JSONObject)localObject).optInt("reportTimeBegin", 0) != 1) {
        break label102;
      }
    }
    String str2;
    label102:
    for (boolean bool2 = true;; bool2 = false)
    {
      str2 = ((JSONObject)localObject).optString("reportFormatData");
      localObject = ((JSONObject)localObject).optString("reportTabsFormatData");
      if (!bo.isNullOrNil(str1)) {
        break label107;
      }
      ab.e("MicroMsg.JsApiReportGamePageTime", "reportId is null or nil");
      parama.a("invalid_reportId", null);
      AppMethodBeat.o(135885);
      return;
      bool1 = false;
      break;
    }
    label107:
    if ((bo.isNullOrNil(str2)) && (bo.isNullOrNil((String)localObject)))
    {
      ab.e("MicroMsg.JsApiReportGamePageTime", "reportFormatData && reportTabsFormatData is null or nil");
      parama.a("invalid_reportFormatData_reportTabsFormatData", null);
      AppMethodBeat.o(135885);
      return;
    }
    ab.i("MicroMsg.JsApiReportGamePageTime", "reportGamePageTime, reportId:%s, reportInstantly:%b, reportTimeBegin:%b, reportFormatData:(%s), reportTabsFormatData(%s)", new Object[] { str1, Boolean.valueOf(bool1), Boolean.valueOf(bool2), str2, localObject });
    Bundle localBundle = new Bundle();
    localBundle.putString("game_page_report_id", str1);
    localBundle.putBoolean("game_page_report_instantly", bool1);
    localBundle.putBoolean("game_page_report_time_begin", bool2);
    localBundle.putString("game_page_report_format_data", str2);
    localBundle.putString("game_page_report_tabs_format_data", (String)localObject);
    ((f)parama.byE).nkG.vmB.ax(localBundle);
    parama.a("", null);
    AppMethodBeat.o(135885);
  }
  
  public final int bjL()
  {
    return 0;
  }
  
  public final String name()
  {
    return "reportGamePageTime";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.u
 * JD-Core Version:    0.7.0.1
 */