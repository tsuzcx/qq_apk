package com.tencent.mm.plugin.downloader_app.detail;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.g;
import com.tencent.luggage.d.k;
import com.tencent.luggage.d.n;
import com.tencent.luggage.d.n.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.z.d;
import com.tencent.mm.plugin.webview.luggage.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.MMWebView;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends n
{
  private MMWebView hqK;
  boolean oKw;
  private n.a oKx;
  
  public c(g paramg, k paramk, Bundle paramBundle)
  {
    super(paramg, paramk, paramBundle);
    AppMethodBeat.i(8801);
    this.oKw = false;
    this.oKx = new n.a()
    {
      public final void a(n paramAnonymousn, String paramAnonymousString) {}
      
      public final void b(final n paramAnonymousn, String paramAnonymousString)
      {
        AppMethodBeat.i(8800);
        ac.i("MicroMsg.DownloadDetailWebPage", "onUrlLoadingFinished, preload = %b", new Object[] { Boolean.valueOf(c.this.oKw) });
        paramAnonymousn = c.this.mParams.getString("rawUrl");
        if (bs.isNullOrNil(paramAnonymousn))
        {
          AppMethodBeat.o(8800);
          return;
        }
        paramAnonymousn = Uri.parse(paramAnonymousn).getQueryParameter("appid");
        c.this.bXF.a(new com.tencent.luggage.d.c()
        {
          public final JSONObject Aq()
          {
            AppMethodBeat.i(8799);
            JSONObject localJSONObject = new JSONObject();
            try
            {
              localJSONObject.put("appid", paramAnonymousn);
              label25:
              AppMethodBeat.o(8799);
              return localJSONObject;
            }
            catch (JSONException localJSONException)
            {
              break label25;
            }
          }
          
          public final String name()
          {
            return "onDataEnvReady";
          }
        });
        AppMethodBeat.o(8800);
      }
    };
    if (paramk != null) {
      this.oKw = true;
    }
    ac.i("MicroMsg.DownloadDetailWebPage", "preload = %b", new Object[] { Boolean.valueOf(this.oKw) });
    a(this.oKx);
    this.bXF.bXu = a.bXK;
    i.b(this);
    AppMethodBeat.o(8801);
  }
  
  private void WL(final String paramString)
  {
    AppMethodBeat.i(8808);
    this.bXF.a(new com.tencent.luggage.d.c()
    {
      public final JSONObject Aq()
      {
        AppMethodBeat.i(8798);
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("state", paramString);
          label25:
          AppMethodBeat.o(8798);
          return localJSONObject;
        }
        catch (Exception localException)
        {
          break label25;
        }
      }
      
      public final String name()
      {
        return "activity:state_change";
      }
    });
    AppMethodBeat.o(8808);
  }
  
  public final String AQ()
  {
    AppMethodBeat.i(8807);
    String str = d.Rn("luggage_mm_adapter.js");
    AppMethodBeat.o(8807);
    return str;
  }
  
  public final View Ar()
  {
    AppMethodBeat.i(8802);
    this.hqK = ((MMWebView)this.bXF.AN());
    View localView = super.Ar();
    AppMethodBeat.o(8802);
    return localView;
  }
  
  public final void g(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(8806);
    if (!this.oKw) {
      this.bXF.loadUrl(paramString);
    }
    AppMethodBeat.o(8806);
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(8804);
    ac.i("MicroMsg.DownloadDetailWebPage", "onBackground");
    WL("onPause");
    this.hqK.onPause();
    AppMethodBeat.o(8804);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(8805);
    ac.i("MicroMsg.DownloadDetailWebPage", "onDestroy");
    WL("onDestroy");
    i.c(this);
    AppMethodBeat.o(8805);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(8803);
    ac.i("MicroMsg.DownloadDetailWebPage", "onForeground");
    WL("onResume");
    this.hqK.onResume();
    AppMethodBeat.o(8803);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.detail.c
 * JD-Core Version:    0.7.0.1
 */