package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.Window;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.b;
import com.tencent.mm.plugin.appbrand.y.d;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import java.io.File;

final class JsApiOpenDocument$a
  extends AppBrandProxyUIProcessTask
{
  private static final int gqQ = a.class.hashCode() & 0xFFFF;
  
  private void bz(String paramString1, String paramString2)
  {
    paramString2 = s.wJ(paramString2);
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
      ahy().startActivity(localIntent);
      localOpenResult.ret = 0;
      a(localOpenResult);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        y.e("MicroMsg.AppBrand.JsApiOpenDocument", "start outer view with mime(%s), e = %s", new Object[] { paramString2, paramString1 });
        localOpenResult.ret = 2147483646;
        ai.d(new JsApiOpenDocument.a.1(this));
      }
    }
  }
  
  protected final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    String str1 = ((JsApiOpenDocument.OpenRequest)paramProcessRequest).filePath;
    paramProcessRequest = ((JsApiOpenDocument.OpenRequest)paramProcessRequest).fGv;
    String str2 = Integer.toString(ahy().hashCode());
    if (e.cqq()) {
      bz(str1, paramProcessRequest);
    }
    do
    {
      return;
      int i = p.a(ahy(), str1, paramProcessRequest, str2, new JsApiOpenDocument.a.2(this));
      y.i("MicroMsg.AppBrand.JsApiOpenDocument", "QB openReadFile, ret = %d", new Object[] { Integer.valueOf(i) });
      if (i == -102) {
        try
        {
          bz(str1, paramProcessRequest);
          return;
        }
        catch (Exception paramProcessRequest)
        {
          y.printErrStackTrace("MicroMsg.AppBrand.JsApiOpenDocument", paramProcessRequest, " openOuterAppDirectly exp = %s ", new Object[] { paramProcessRequest });
        }
      }
      paramProcessRequest = new JsApiOpenDocument.OpenResult();
      paramProcessRequest.ret = i;
      if (paramProcessRequest.ret != 0)
      {
        a(paramProcessRequest);
        return;
      }
    } while (this.ger == null);
    this.ger.b(paramProcessRequest);
  }
  
  protected final void ahE()
  {
    super.ahE();
    ahy().getWindow().setBackgroundDrawableResource(y.d.transparent);
  }
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (gqQ == paramInt1)
    {
      paramIntent = new JsApiOpenDocument.OpenResult();
      if (-1 == paramInt2) {}
      for (paramIntent.ret = 0;; paramIntent.ret = 2147483647)
      {
        a(paramIntent);
        return;
      }
    }
    a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.JsApiOpenDocument.a
 * JD-Core Version:    0.7.0.1
 */