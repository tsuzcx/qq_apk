package com.tencent.mm.plugin.appbrand.appcache.b;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.f;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.service.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.c.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl;", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPreDownloadServiceExport;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "()V", "TAG", "", "onRegister", "", "onUnregister", "triggerPreDownload", "username", "plugin-appbrand-integration_release"})
public final class c
  implements com.tencent.mm.kernel.c.b, m
{
  private final String TAG = "MicroMsg.AppBrand.PreDownloadServiceExportImpl";
  
  public final void xM() {}
  
  public final void xN() {}
  
  public final void yN(String paramString)
  {
    AppMethodBeat.i(134473);
    String[] arrayOfString = AppBrandGlobalSystemConfig.ayt().hia;
    if (arrayOfString == null) {
      arrayOfString = new String[0];
    }
    for (;;)
    {
      int k = arrayOfString.length;
      int i = 0;
      while (i < k)
      {
        String str = arrayOfString[i];
        CharSequence localCharSequence = (CharSequence)str;
        if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
        for (int j = 1; (j == 0) && (str.equals(paramString)); j = 0)
        {
          ab.i(this.TAG, "username[" + paramString + "] blacklist, just return");
          AppMethodBeat.o(134473);
          return;
        }
        i += 1;
      }
      ab.i(this.TAG, "do cgi with username[" + paramString + ']');
      new b(paramString).adl().h((a)new c.a(this)).dQo();
      AppMethodBeat.o(134473);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.c
 * JD-Core Version:    0.7.0.1
 */