package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.e.a.a;
import com.tencent.mm.plugin.game.luggage.d;
import com.tencent.mm.plugin.webview.luggage.jsapi.aw.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.ax;
import com.tencent.mm.plugin.webview.ui.tools.game.c;
import com.tencent.mm.plugin.webview.ui.tools.game.c.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public class l
  extends ax<d>
{
  public final void a(Context paramContext, String paramString, aw.a parama) {}
  
  public final int aGj()
  {
    return 0;
  }
  
  public final void b(a.a parama)
  {
    Object localObject = parama.bih.bhk;
    String str1 = ((JSONObject)localObject).optString("reportId");
    boolean bool1;
    if (((JSONObject)localObject).optInt("reportInstantly", 0) == 1)
    {
      bool1 = true;
      if (((JSONObject)localObject).optInt("reportTimeBegin", 0) != 1) {
        break label92;
      }
    }
    String str2;
    label92:
    for (boolean bool2 = true;; bool2 = false)
    {
      str2 = ((JSONObject)localObject).optString("reportFormatData");
      localObject = ((JSONObject)localObject).optString("reportTabsFormatData");
      if (!bk.bl(str1)) {
        break label97;
      }
      y.e("MicroMsg.JsApiReportGamePageTime", "reportId is null or nil");
      parama.a("invalid_reportId", null);
      return;
      bool1 = false;
      break;
    }
    label97:
    if ((bk.bl(str2)) && (bk.bl((String)localObject)))
    {
      y.e("MicroMsg.JsApiReportGamePageTime", "reportFormatData && reportTabsFormatData is null or nil");
      parama.a("invalid_reportFormatData_reportTabsFormatData", null);
      return;
    }
    y.i("MicroMsg.JsApiReportGamePageTime", "reportGamePageTime, reportId:%s, reportInstantly:%b, reportTimeBegin:%b, reportFormatData:(%s), reportTabsFormatData(%s)", new Object[] { str1, Boolean.valueOf(bool1), Boolean.valueOf(bool2), str2, localObject });
    Bundle localBundle = new Bundle();
    localBundle.putString("game_page_report_id", str1);
    localBundle.putBoolean("game_page_report_instantly", bool1);
    localBundle.putBoolean("game_page_report_time_begin", bool2);
    localBundle.putString("game_page_report_format_data", str2);
    localBundle.putString("game_page_report_tabs_format_data", (String)localObject);
    ((d)parama.big).kMB.rwj.ae(localBundle);
    parama.a("", null);
  }
  
  public final String name()
  {
    return "reportGamePageTime";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.l
 * JD-Core Version:    0.7.0.1
 */