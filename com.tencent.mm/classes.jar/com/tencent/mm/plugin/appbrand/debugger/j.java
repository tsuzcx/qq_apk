package com.tencent.mm.plugin.appbrand.debugger;

import android.widget.Toast;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.bj;
import com.tencent.mm.plugin.appbrand.appcache.bj.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/debugger/MonkeyTestExportApiImpl;", "Lcom/tencent/mm/plugin/appbrand/debugger/IAppBrandMonkeyTestExportApi;", "()V", "handleReceiverAction", "", "context", "Landroid/content/Context;", "xml", "", "plugin-appbrand-integration_release"})
public final class j
  implements f
{
  public final void afE(String paramString)
  {
    AppMethodBeat.i(283147);
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(283147);
      return;
    }
    try
    {
      Map localMap1 = XmlParser.parseXml(paramString, "sysmsg", null);
      if (localMap1 == null)
      {
        h.ZvG.bc((Runnable)new a(paramString));
        AppMethodBeat.o(283147);
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
        AppMethodBeat.o(283147);
        return;
      }
      localObject = (bj.c)bj.nHv.get(localObject);
      if (localObject != null)
      {
        ((bj.c)localObject).k(paramString, localMap2);
        AppMethodBeat.o(283147);
        return;
      }
      AppMethodBeat.o(283147);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/debugger/MonkeyTestExportApiImpl$handleReceiverAction$1$1"})
  static final class a
    implements Runnable
  {
    a(String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(283762);
      Toast.makeText(MMApplicationContext.getContext(), (CharSequence)("小程序monkey test: xml 解析出错，请检查内容及格式是否正确\n\n" + this.ocw), 1).show();
      AppMethodBeat.o(283762);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.j
 * JD-Core Version:    0.7.0.1
 */