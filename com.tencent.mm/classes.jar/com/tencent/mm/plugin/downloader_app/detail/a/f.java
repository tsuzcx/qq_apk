package com.tencent.mm.plugin.downloader_app.detail.a;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader_app.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh.a;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public class f
  extends bh
{
  public final void a(Context paramContext, String paramString, bh.a parama) {}
  
  public final void b(a.a parama)
  {
    AppMethodBeat.i(136078);
    Object localObject = parama.byF.bxK;
    if (localObject == null)
    {
      parama.a("invalid_data", null);
      AppMethodBeat.o(136078);
      return;
    }
    int i = ((JSONObject)localObject).optInt("logId");
    String str = ((JSONObject)localObject).optString("values");
    if ((i <= 0) || (bo.isNullOrNil(str)))
    {
      parama.a("invalid_data", null);
      AppMethodBeat.o(136078);
      return;
    }
    localObject = str;
    if (i == 16099) {
      localObject = a.azn() + "," + str;
    }
    h.qsU.kvStat(i, (String)localObject);
    parama.a("", null);
    AppMethodBeat.o(136078);
  }
  
  public final int bjL()
  {
    return 0;
  }
  
  public final String name()
  {
    return "reportDownloaderAppKvState";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.detail.a.f
 * JD-Core Version:    0.7.0.1
 */