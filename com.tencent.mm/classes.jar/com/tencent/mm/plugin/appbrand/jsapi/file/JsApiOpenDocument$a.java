package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.sdk.f.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.ui.MMActivity;
import com.tencent.xweb.d.a;
import java.io.File;

final class JsApiOpenDocument$a
  extends AppBrandProxyUIProcessTask
{
  private static final int hMc;
  
  static
  {
    AppMethodBeat.i(131067);
    hMc = a.class.hashCode() & 0xFFFF;
    AppMethodBeat.o(131067);
  }
  
  private void cg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(131061);
    paramString2 = c.aqq(paramString2);
    JsApiOpenDocument.OpenResult localOpenResult = new JsApiOpenDocument.OpenResult();
    try
    {
      Intent localIntent = new Intent();
      localIntent.setPackage(null);
      localIntent.setAction("android.intent.action.VIEW");
      localIntent.setDataAndType(Uri.fromFile(new File(paramString1)), paramString2);
      localIntent.addFlags(268435456);
      int i = Build.VERSION.SDK_INT;
      localIntent.addFlags(524288);
      aBf().startActivity(localIntent);
      localOpenResult.ret = 0;
      a(localOpenResult);
      AppMethodBeat.o(131061);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        ab.e("MicroMsg.AppBrand.JsApiOpenDocument", "start outer view with mime(%s), e = %s", new Object[] { paramString2, paramString1 });
        localOpenResult.ret = 2147483646;
        al.d(new JsApiOpenDocument.a.1(this));
      }
    }
  }
  
  public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(131062);
    String str1 = ((JsApiOpenDocument.OpenRequest)paramProcessRequest).filePath;
    String str2 = ((JsApiOpenDocument.OpenRequest)paramProcessRequest).elt;
    String str3 = Integer.toString(aBf().hashCode());
    if (g.dsn())
    {
      cg(str1, str2);
      AppMethodBeat.o(131062);
      return;
    }
    try
    {
      int j = str1.lastIndexOf('/') + 1;
      if (j < 0) {
        break label174;
      }
      i = j;
      if (j != str1.length()) {}
    }
    catch (Exception paramProcessRequest)
    {
      for (;;)
      {
        ab.e("MicroMsg.AppBrand.JsApiOpenDocument", "get file name error " + paramProcessRequest.getMessage());
        paramProcessRequest = "";
        continue;
        int i = 0;
      }
    }
    paramProcessRequest = str1.substring(i, str1.length());
    a.a(aBf(), str1, paramProcessRequest, str2, str3, d.a.BDa, new JsApiOpenDocument.a.2(this, str2, str1, paramProcessRequest), new JsApiOpenDocument.a.3(this, str1, str2));
    AppMethodBeat.o(131062);
  }
  
  public final void aBl()
  {
    AppMethodBeat.i(131063);
    super.aBl();
    aBf().getWindow().setBackgroundDrawableResource(2131690605);
    AppMethodBeat.o(131063);
  }
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(131064);
    if (hMc == paramInt1)
    {
      paramIntent = new JsApiOpenDocument.OpenResult();
      if (-1 == paramInt2) {}
      for (paramIntent.ret = 0;; paramIntent.ret = 2147483647)
      {
        a(paramIntent);
        AppMethodBeat.o(131064);
        return;
      }
    }
    a(null);
    AppMethodBeat.o(131064);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.JsApiOpenDocument.a
 * JD-Core Version:    0.7.0.1
 */