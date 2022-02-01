package com.tencent.mm.plugin.downloader_app.detail;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.p;
import com.tencent.luggage.d.s;
import com.tencent.luggage.d.s.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.MMWebView;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends s
{
  private MMWebView hLV;
  boolean puK;
  private s.a puL;
  
  public c(com.tencent.luggage.d.j paramj, p paramp, Bundle paramBundle)
  {
    super(paramj, paramp, paramBundle);
    AppMethodBeat.i(8801);
    this.puK = false;
    this.puL = new s.a()
    {
      public final void a(s paramAnonymouss, String paramAnonymousString) {}
      
      public final void b(final s paramAnonymouss, String paramAnonymousString)
      {
        AppMethodBeat.i(8800);
        ae.i("MicroMsg.DownloadDetailWebPage", "onUrlLoadingFinished, preload = %b", new Object[] { Boolean.valueOf(c.this.puK) });
        paramAnonymouss = c.this.mParams.getString("rawUrl");
        if (bu.isNullOrNil(paramAnonymouss))
        {
          AppMethodBeat.o(8800);
          return;
        }
        paramAnonymouss = Uri.parse(paramAnonymouss).getQueryParameter("appid");
        c.this.chX.a(new com.tencent.luggage.d.d()
        {
          public final JSONObject BP()
          {
            AppMethodBeat.i(8799);
            JSONObject localJSONObject = new JSONObject();
            try
            {
              localJSONObject.put("appid", paramAnonymouss);
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
    if (paramp != null) {
      this.puK = true;
    }
    ae.i("MicroMsg.DownloadDetailWebPage", "preload = %b", new Object[] { Boolean.valueOf(this.puK) });
    a(this.puL);
    this.chX.chG = a.cic;
    com.tencent.mm.plugin.webview.luggage.j.b(this);
    AppMethodBeat.o(8801);
  }
  
  private void abj(final String paramString)
  {
    AppMethodBeat.i(8808);
    this.chX.a(new com.tencent.luggage.d.d()
    {
      public final JSONObject BP()
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
  
  public final View BR()
  {
    AppMethodBeat.i(8802);
    this.hLV = ((MMWebView)this.chX.Cp());
    View localView = super.BR();
    AppMethodBeat.o(8802);
    return localView;
  }
  
  public final String Cs()
  {
    AppMethodBeat.i(8807);
    String str = com.tencent.mm.plugin.appbrand.y.d.VE("luggage_mm_adapter.js");
    AppMethodBeat.o(8807);
    return str;
  }
  
  public final void g(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(8806);
    if (!this.puK) {
      this.chX.loadUrl(paramString);
    }
    AppMethodBeat.o(8806);
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(8804);
    ae.i("MicroMsg.DownloadDetailWebPage", "onBackground");
    abj("onPause");
    this.hLV.onPause();
    AppMethodBeat.o(8804);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(8805);
    ae.i("MicroMsg.DownloadDetailWebPage", "onDestroy");
    abj("onDestroy");
    com.tencent.mm.plugin.webview.luggage.j.c(this);
    AppMethodBeat.o(8805);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(8803);
    ae.i("MicroMsg.DownloadDetailWebPage", "onForeground");
    abj("onResume");
    this.hLV.onResume();
    AppMethodBeat.o(8803);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.detail.c
 * JD-Core Version:    0.7.0.1
 */