package com.tencent.mm.plugin.downloader_app.detail.a;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader_app.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn.a;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public class f
  extends bn
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(a.a parama)
  {
    AppMethodBeat.i(8833);
    Object localObject = parama.bZV.bZb;
    if (localObject == null)
    {
      parama.a("invalid_data", null);
      AppMethodBeat.o(8833);
      return;
    }
    int i = ((JSONObject)localObject).optInt("logId");
    String str = ((JSONObject)localObject).optString("values");
    if ((i <= 0) || (bt.isNullOrNil(str)))
    {
      parama.a("invalid_data", null);
      AppMethodBeat.o(8833);
      return;
    }
    localObject = str;
    if (i == 16099) {
      localObject = a.aUu() + "," + str;
    }
    h.vKh.kvStat(i, (String)localObject);
    parama.a("", null);
    AppMethodBeat.o(8833);
  }
  
  public final int bQV()
  {
    return 0;
  }
  
  public final String name()
  {
    return "reportDownloaderAppKvState";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.detail.a.f
 * JD-Core Version:    0.7.0.1
 */