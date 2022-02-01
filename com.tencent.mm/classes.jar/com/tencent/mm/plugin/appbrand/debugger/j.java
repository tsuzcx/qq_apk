package com.tencent.mm.plugin.appbrand.debugger;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.bj;
import com.tencent.mm.plugin.appbrand.appcache.bj.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/debugger/MonkeyTestExportApiImpl;", "Lcom/tencent/mm/plugin/appbrand/debugger/IAppBrandMonkeyTestExportApi;", "()V", "handleReceiverAction", "", "context", "Landroid/content/Context;", "xml", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  implements f
{
  private static final void Yd(String paramString)
  {
    AppMethodBeat.i(319686);
    Toast.makeText(MMApplicationContext.getContext(), (CharSequence)s.X("小程序monkey test: xml 解析出错，请检查内容及格式是否正确\n\n", paramString), 1).show();
    AppMethodBeat.o(319686);
  }
  
  public final void Yc(String paramString)
  {
    AppMethodBeat.i(319691);
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(319691);
      return;
    }
    try
    {
      Map localMap1 = XmlParser.parseXml(paramString, "sysmsg", null);
      if (localMap1 == null)
      {
        h.ahAA.bk(new j..ExternalSyntheticLambda0(paramString));
        AppMethodBeat.o(319691);
        return;
      }
    }
    catch (Exception localException)
    {
      Map localMap2;
      for (;;)
      {
        localMap2 = null;
      }
      Object localObject = (String)localMap2.get(".sysmsg.$type");
      CharSequence localCharSequence = (CharSequence)localObject;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(319691);
        return;
      }
      localObject = (bj.c)bj.qHi.get(localObject);
      if (localObject != null) {
        ((bj.c)localObject).k(paramString, localMap2);
      }
      AppMethodBeat.o(319691);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.j
 * JD-Core Version:    0.7.0.1
 */