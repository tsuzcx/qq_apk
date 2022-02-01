package com.tencent.mm.plugin.appbrand.openmaterial.a;

import android.os.Looper;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.openmaterial.k;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialDetailModel;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialModel;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/openmaterial/data/FakeOpenMaterialDataSource;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/data/IOpenMaterialDataSource;", "()V", "fakeFetchOpenMaterialsByCGI", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "materialModel", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/MaterialModel;", "fetchOpenMaterials", "", "fetchOpenMaterialsCallback", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IFetchOpenMaterialsCallback;", "fetchOpenMaterialsInner", "fetchOpenMaterialsQuickly", "prefetchOpenMaterialsOnLaunchAppBrand", "plugin-appbrand-integration_release"})
public final class a
  implements b
{
  public static final a qmX;
  
  static
  {
    AppMethodBeat.i(271317);
    qmX = new a();
    AppMethodBeat.o(271317);
  }
  
  private static AppBrandOpenMaterialCollection d(MaterialModel paramMaterialModel)
  {
    AppMethodBeat.i(271315);
    Log.d("MicroMsg.AppBrand.FakeOpenMaterialDataSource", "fetchOpenMaterialsInner");
    paramMaterialModel = e(paramMaterialModel);
    AppMethodBeat.o(271315);
    return paramMaterialModel;
  }
  
  private static AppBrandOpenMaterialCollection e(MaterialModel paramMaterialModel)
  {
    AppMethodBeat.i(271316);
    Log.d("MicroMsg.AppBrand.FakeOpenMaterialDataSource", "fakeFetchOpenMaterialsByCGI");
    AppBrandOpenMaterialDetailModel localAppBrandOpenMaterialDetailModel1 = new AppBrandOpenMaterialDetailModel("wxda97763422d9a0ca", 1, "/pages/index/index.html", "http://mmbiz.qpic.cn/mmbiz_png/4XQzbXAGErjY4jReHjaVey8nFTn79HfdFDpiaUK6CywZ5HMaCUcqDufIJ2LkaQTvdPcoMHCSOy5oEeWCOg4CKzg/640?wx_fmt=png&wxfrom=200", "用有BUG啦打开", j.listOf("测试"), 0.0F, "无敌的小程序");
    localAppBrandOpenMaterialDetailModel1.appName = "有BUG啦";
    AppBrandOpenMaterialDetailModel localAppBrandOpenMaterialDetailModel2 = new AppBrandOpenMaterialDetailModel("wxd45c635d754dbf59", 0, "/pages/importFile/importFile.html", "http://wx.qlogo.cn/mmhead/Q3auHgzwzM6cPEzjibMPv4KFl21AkI9SBl4ODic7Kb1mkGl4T9aL3Img/96", "用腾讯文档打开", j.listOf("笔记"), 4.6F, "多人协作在线文档");
    localAppBrandOpenMaterialDetailModel2.appName = "腾讯文档";
    AppBrandOpenMaterialDetailModel localAppBrandOpenMaterialDetailModel3 = new AppBrandOpenMaterialDetailModel("wx5b97b0686831c076", 0, "", "http://wx.qlogo.cn/mmhead/Q3auHgzwzM5SKdZHeibnv7SAvE0d7lLW0jjeQAlCA5QhUrvAibneU49w/96", "用金山文档编辑", j.listOf("办公、笔记"), 4.6F, "多人实时协作的在线Office");
    localAppBrandOpenMaterialDetailModel3.appName = "金山文档";
    AppBrandOpenMaterialDetailModel localAppBrandOpenMaterialDetailModel4 = new AppBrandOpenMaterialDetailModel("wx75425a38a3ed6402", 0, "", "http://wx.qlogo.cn/mmhead/Q3auHgzwzM5qedyLib8wW0GzEAZOBs6xRFMBHoa2M0kFlmiaxrxTr85g/96", "用印象笔记记录", j.listOf("办公、笔记"), 4.6F, "随时记录, 支持分享");
    localAppBrandOpenMaterialDetailModel4.appName = "印象笔记";
    AppBrandOpenMaterialModel localAppBrandOpenMaterialModel1 = new AppBrandOpenMaterialModel("wxa9cee04ddf631e72", 0, "", "http://wx.qlogo.cn/mmhead/Q3auHgzwzM6pjqW5bhHPuXibzcoJsAZOmvJXp0CaRAdicXiclUaBWfnaw/96", "用石墨文档档档档档档打开");
    localAppBrandOpenMaterialModel1.appName = "石墨文档档档档档档";
    AppBrandOpenMaterialModel localAppBrandOpenMaterialModel2 = new AppBrandOpenMaterialModel("wxd574de764a7b7c7f", 0, "", "http://wx.qlogo.cn/mmhead/Q3auHgzwzM43gt1wQekxSo9icCPWoOtnMe2okSubKHrefmwCNa5W77Q/96", "保存到微云");
    localAppBrandOpenMaterialModel2.appName = "微云";
    AppBrandOpenMaterialDetailModel localAppBrandOpenMaterialDetailModel5 = new AppBrandOpenMaterialDetailModel("wx5b3bd5898fba8574", 0, "", "http://wx.qlogo.cn/mmhead/Q3auHgzwzM4TsQdnFQxcSwfgMqtpMDjTmdgF2gCzsrSBUWr5wkeXUg/96", "用文章截图打开", j.listOf("图片"), 4.7F, "截长图小程序");
    localAppBrandOpenMaterialDetailModel5.appName = "文章截图";
    AppBrandOpenMaterialModel localAppBrandOpenMaterialModel3 = new AppBrandOpenMaterialModel("wxb315b84b1622f225", 0, "", "http://wx.qlogo.cn/mmhead/Q3auHgzwzM6fqS4upaNjFwXDYHDhRRZibsn13dINnbVUrYg9rAS4l9w/96", "用文件打印打开");
    localAppBrandOpenMaterialModel3.appName = "文件打印";
    paramMaterialModel = new AppBrandOpenMaterialCollection(paramMaterialModel, j.listOf(new AppBrandOpenMaterialModel[] { (AppBrandOpenMaterialModel)localAppBrandOpenMaterialDetailModel1, localAppBrandOpenMaterialModel1, localAppBrandOpenMaterialModel2, localAppBrandOpenMaterialModel3 }), j.listOf(new AppBrandOpenMaterialDetailModel[] { localAppBrandOpenMaterialDetailModel1, localAppBrandOpenMaterialDetailModel2, localAppBrandOpenMaterialDetailModel3, localAppBrandOpenMaterialDetailModel4, localAppBrandOpenMaterialDetailModel5 }));
    AppMethodBeat.o(271316);
    return paramMaterialModel;
  }
  
  public final AppBrandOpenMaterialCollection a(MaterialModel paramMaterialModel)
  {
    AppMethodBeat.i(271314);
    p.k(paramMaterialModel, "materialModel");
    paramMaterialModel = d(paramMaterialModel);
    AppMethodBeat.o(271314);
    return paramMaterialModel;
  }
  
  public final void a(final MaterialModel paramMaterialModel, k paramk)
  {
    AppMethodBeat.i(271313);
    p.k(paramMaterialModel, "materialModel");
    p.k(paramk, "fetchOpenMaterialsCallback");
    if (p.h(Looper.getMainLooper(), Looper.myLooper()))
    {
      paramk.a(true, d(paramMaterialModel));
      AppMethodBeat.o(271313);
      return;
    }
    h.ZvG.bc((Runnable)new a(paramk, paramMaterialModel));
    AppMethodBeat.o(271313);
  }
  
  public final void c(MaterialModel paramMaterialModel)
  {
    AppMethodBeat.i(271312);
    p.k(paramMaterialModel, "materialModel");
    AppMethodBeat.o(271312);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(k paramk, MaterialModel paramMaterialModel) {}
    
    public final void run()
    {
      AppMethodBeat.i(268979);
      k localk = this.qmY;
      a locala = a.qmX;
      localk.a(true, a.f(paramMaterialModel));
      AppMethodBeat.o(268979);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.a.a
 * JD-Core Version:    0.7.0.1
 */