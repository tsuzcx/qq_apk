package com.tencent.mm.plugin.appbrand.d;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.webview.model.ax;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.e;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/complaint/AppBrandComplaintHelper;", "", "()V", "TAG", "", "tryTakeScreenshot", "pageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "plugin-appbrand-integration_release"})
public final class a
{
  public static final a jVg;
  
  static
  {
    AppMethodBeat.i(188995);
    jVg = new a();
    AppMethodBeat.o(188995);
  }
  
  public static final String b(ae paramae)
  {
    AppMethodBeat.i(188994);
    p.h(paramae, "pageView");
    ad.i("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, pageView:".concat(String.valueOf(paramae)));
    Object localObject = ((c)com.tencent.mm.kernel.g.ab(c.class)).getCacheDir();
    if (localObject == null)
    {
      ad.i("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, null image cache dir");
      AppMethodBeat.o(188994);
      return null;
    }
    localObject = new e((String)localObject + '/' + paramae.getAppId() + '_' + System.currentTimeMillis() + ".jpeg");
    paramae.Eu();
    localObject = ((e)localObject).getAbsolutePath();
    p.g(localObject, "tempFile.absolutePath");
    h.LTJ.aR((Runnable)new a(paramae, (String)localObject));
    paramae = ax.aHA((String)localObject);
    ad.i("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, localId:" + paramae + ", imagePath:" + (String)localObject);
    AppMethodBeat.o(188994);
    return paramae;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(ae paramae, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(188993);
      Bitmap localBitmap = this.jVh.buN();
      Object localObject5 = null;
      Object localObject6 = null;
      Object localObject1 = null;
      Object localObject4 = localObject1;
      Object localObject2;
      if (localBitmap != null)
      {
        localObject4 = localObject1;
        localObject2 = localObject5;
        localObject1 = localObject6;
      }
      try
      {
        if (!localBitmap.isRecycled())
        {
          localObject2 = localObject5;
          localObject1 = localObject6;
          long l = System.currentTimeMillis();
          localObject2 = localObject5;
          localObject1 = localObject6;
          localObject4 = com.tencent.mm.sdk.platformtools.g.a(localBitmap, 640, 640, false, true);
          localObject2 = localObject4;
          localObject1 = localObject4;
          com.tencent.mm.sdk.platformtools.g.a((Bitmap)localObject4, 100, Bitmap.CompressFormat.JPEG, this.jVi, true);
          localObject2 = localObject4;
          localObject1 = localObject4;
          ad.i("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, save bitmap to file:" + this.jVi + ", cost:" + (System.currentTimeMillis() - l));
          localObject2 = localObject4;
          localObject1 = localObject4;
          ((c)com.tencent.mm.kernel.g.ab(c.class)).Ne(this.jVi);
        }
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          ad.d("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, recycle bitmap:".concat(String.valueOf(localBitmap)));
          localBitmap.recycle();
        }
        if ((localObject4 != null) && (!((Bitmap)localObject4).isRecycled()))
        {
          ad.d("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, recycle thumbnail:".concat(String.valueOf(localObject4)));
          ((Bitmap)localObject4).recycle();
        }
        AppMethodBeat.o(188993);
        return;
      }
      catch (Exception localException)
      {
        localObject1 = localObject2;
        ad.printErrStackTrace("MicroMsg.AppBrandComplaintHelper", (Throwable)localException, "tryTakeScreenshot, save bitmap to file fail", new Object[0]);
        return;
      }
      finally
      {
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          ad.d("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, recycle bitmap:".concat(String.valueOf(localBitmap)));
          localBitmap.recycle();
        }
        if ((localObject1 != null) && (!localObject1.isRecycled()))
        {
          ad.d("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, recycle thumbnail:".concat(String.valueOf(localObject1)));
          localObject1.recycle();
        }
        AppMethodBeat.o(188993);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.d.a
 * JD-Core Version:    0.7.0.1
 */