package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.webview.luggage.jsapi.br.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bs;
import com.tencent.mm.plugin.webview.ui.tools.game.d;
import com.tencent.mm.plugin.webview.ui.tools.game.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class ag
  extends bs<i>
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(b.a parama)
  {
    AppMethodBeat.i(83087);
    Object localObject = parama.crh.cqn;
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
      if (!Util.isNullOrNil(str1)) {
        break label107;
      }
      Log.e("MicroMsg.JsApiReportGamePageTime", "reportId is null or nil");
      parama.a("invalid_reportId", null);
      AppMethodBeat.o(83087);
      return;
      bool1 = false;
      break;
    }
    label107:
    if ((Util.isNullOrNil(str2)) && (Util.isNullOrNil((String)localObject)))
    {
      Log.e("MicroMsg.JsApiReportGamePageTime", "reportFormatData && reportTabsFormatData is null or nil");
      parama.a("invalid_reportFormatData_reportTabsFormatData", null);
      AppMethodBeat.o(83087);
      return;
    }
    Log.i("MicroMsg.JsApiReportGamePageTime", "reportGamePageTime, reportId:%s, reportInstantly:%b, reportTimeBegin:%b, reportFormatData:(%s), reportTabsFormatData(%s)", new Object[] { str1, Boolean.valueOf(bool1), Boolean.valueOf(bool2), str2, localObject });
    Bundle localBundle = new Bundle();
    localBundle.putString("game_page_report_id", str1);
    localBundle.putBoolean("game_page_report_instantly", bool1);
    localBundle.putBoolean("game_page_report_time_begin", bool2);
    localBundle.putString("game_page_report_format_data", str2);
    localBundle.putString("game_page_report_tabs_format_data", (String)localObject);
    ((i)parama.crg).CCS.QnE.bk(localBundle);
    parama.a("", null);
    AppMethodBeat.o(83087);
  }
  
  public final int cDj()
  {
    return 0;
  }
  
  public final String name()
  {
    return "reportGamePageTime";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.ag
 * JD-Core Version:    0.7.0.1
 */