package com.tencent.mm.plugin.appbrand.jsapi.u;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.j;
import com.tencent.mm.g.a.j.a;
import com.tencent.mm.g.a.j.b;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.plugin.webview.modeltools.NFCIPCHelper;
import com.tencent.mm.plugin.webview.modeltools.NFCIPCHelper.NFCEventTransfer;
import com.tencent.mm.plugin.webview.modeltools.NFCIPCHelper.a;
import com.tencent.mm.plugin.webview.modeltools.h;
import com.tencent.mm.plugin.webview.ui.tools.widget.m;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

final class e$1
  extends m
{
  e$1(e parame) {}
  
  public final void e(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(17027);
    ab.d("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "result: ".concat(String.valueOf(paramString2)));
    if ((this.ihi.iha == null) || (paramString1 == null) || (!paramString1.equals(this.ihi.iha.uYi)))
    {
      AppMethodBeat.o(17027);
      return;
    }
    if (paramInt1 != 22)
    {
      AppMethodBeat.o(17027);
      return;
    }
    if (this.ihi.iha != null) {
      this.ihi.iha.dcJ();
    }
    this.ihi.igY = paramInt1;
    this.ihi.igZ = paramInt2;
    if ((paramString2 == null) || (e.h(this.ihi) == null))
    {
      AppMethodBeat.o(17027);
      return;
    }
    e.b(this.ihi).runOnUiThread(new e.1.1(this, paramString2));
    AppMethodBeat.o(17027);
  }
  
  public final Bundle i(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(17026);
    Bundle localBundle = new Bundle();
    localBundle.putString("key_webview_container_env", "miniProgram");
    switch (paramInt)
    {
    default: 
    case 139: 
    case 101: 
    case 140: 
    case 145: 
      for (;;)
      {
        AppMethodBeat.o(17026);
        return localBundle;
        paramBundle = paramBundle.getString("info");
        try
        {
          paramBundle = new JSONObject(paramBundle);
          e.b(this.ihi).I(paramBundle);
        }
        catch (Exception paramBundle) {}
        continue;
        paramBundle.setClassLoader(e.class.getClassLoader());
        d.b(e.g(this.ihi), paramBundle.getString("open_ui_with_webview_ui_plugin_name"), paramBundle.getString("open_ui_with_webview_ui_plugin_entry"), new Intent().putExtras(paramBundle.getBundle("open_ui_with_webview_ui_extras")));
        continue;
        localBundle.putInt("key_webview_preverify_info_scene", 1);
        localBundle.putString("key_webview_preverify_info_source_appid", e.b(this.ihi).getAppId());
        continue;
        localBundle.putStringArray("key_webview_apbrand_jsapi_report_args", e.b(this.ihi).getJsApiReportArgs());
      }
    }
    j localj = new j();
    localj.cmo.context = e.g(this.ihi);
    localj.cmo.actionCode = paramInt;
    if (4003 == paramInt)
    {
      paramBundle = paramBundle.getString("apdu");
      localj.cmo.cmq = paramBundle;
      label319:
      ab.i("MicroMsg.NFCIPCHelper", "alvinluo nfcInvokeAsResult actionCode: %d", new Object[] { Integer.valueOf(localj.cmo.actionCode) });
    }
    for (;;)
    {
      try
      {
        paramBundle = (NFCIPCHelper.NFCEventTransfer)XIPCInvoker.a("com.tencent.mm:tools", new NFCIPCHelper.NFCEventTransfer(localj), NFCIPCHelper.a.class);
        if ((paramBundle == null) || (paramBundle.cmt == null)) {
          continue;
        }
        localj.cmp.cmt = paramBundle.cmt;
      }
      catch (Exception paramBundle)
      {
        String str;
        boolean bool1;
        boolean bool2;
        ab.printErrStackTrace("MicroMsg.NFCIPCHelper", paramBundle, "alvinluo nfcInvokeAsResult exception", new Object[0]);
        NFCIPCHelper.dcx();
        continue;
      }
      if (localj.cmp.cmt == null) {
        break;
      }
      localBundle.putAll(localj.cmp.cmt);
      break;
      if (4004 != paramInt) {
        break label319;
      }
      str = paramBundle.getString("apdus");
      bool1 = paramBundle.getBoolean("breakIfFail", true);
      bool2 = paramBundle.getBoolean("breakIfTrue", false);
      localj.cmo.cmq = str;
      localj.cmo.cmr = bool1;
      localj.cmo.cms = bool2;
      break label319;
      NFCIPCHelper.dcx();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.e.1
 * JD-Core Version:    0.7.0.1
 */