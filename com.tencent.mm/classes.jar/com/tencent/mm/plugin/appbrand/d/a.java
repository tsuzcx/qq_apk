package com.tencent.mm.plugin.appbrand.d;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.webview.model.ax;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.k;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/complaint/AppBrandComplaintHelper;", "", "()V", "TAG", "", "tryTakeScreenshot", "pageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "plugin-appbrand-integration_release"})
public final class a
{
  public static final a jYx;
  
  static
  {
    AppMethodBeat.i(223254);
    jYx = new a();
    AppMethodBeat.o(223254);
  }
  
  public static final String b(ad paramad)
  {
    AppMethodBeat.i(223253);
    p.h(paramad, "pageView");
    ae.i("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, pageView:".concat(String.valueOf(paramad)));
    Object localObject = ((c)g.ab(c.class)).getCacheDir();
    if (localObject == null)
    {
      ae.i("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, null image cache dir");
      AppMethodBeat.o(223253);
      return null;
    }
    localObject = new k((String)localObject + '/' + paramad.getAppId() + '_' + System.currentTimeMillis() + ".jpeg");
    paramad.Ew();
    localObject = ((k)localObject).getAbsolutePath();
    p.g(localObject, "tempFile.absolutePath");
    com.tencent.e.h.MqF.aO((Runnable)new a(paramad, (String)localObject));
    paramad = ax.aIT((String)localObject);
    ae.i("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, localId:" + paramad + ", imagePath:" + (String)localObject);
    AppMethodBeat.o(223253);
    return paramad;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(ad paramad, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(223252);
      Bitmap localBitmap = this.jYy.bvz();
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
          localObject4 = com.tencent.mm.sdk.platformtools.h.a(localBitmap, 640, 640, false, true);
          localObject2 = localObject4;
          localObject1 = localObject4;
          com.tencent.mm.sdk.platformtools.h.a((Bitmap)localObject4, 100, Bitmap.CompressFormat.JPEG, this.jYz, true);
          localObject2 = localObject4;
          localObject1 = localObject4;
          ae.i("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, save bitmap to file:" + this.jYz + ", cost:" + (System.currentTimeMillis() - l));
          localObject2 = localObject4;
          localObject1 = localObject4;
          ((c)g.ab(c.class)).NL(this.jYz);
        }
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          ae.d("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, recycle bitmap:".concat(String.valueOf(localBitmap)));
          localBitmap.recycle();
        }
        if ((localObject4 != null) && (!((Bitmap)localObject4).isRecycled()))
        {
          ae.d("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, recycle thumbnail:".concat(String.valueOf(localObject4)));
          ((Bitmap)localObject4).recycle();
        }
        AppMethodBeat.o(223252);
        return;
      }
      catch (Exception localException)
      {
        localObject1 = localObject2;
        ae.printErrStackTrace("MicroMsg.AppBrandComplaintHelper", (Throwable)localException, "tryTakeScreenshot, save bitmap to file fail", new Object[0]);
        return;
      }
      finally
      {
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          ae.d("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, recycle bitmap:".concat(String.valueOf(localBitmap)));
          localBitmap.recycle();
        }
        if ((localObject1 != null) && (!localObject1.isRecycled()))
        {
          ae.d("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, recycle thumbnail:".concat(String.valueOf(localObject1)));
          localObject1.recycle();
        }
        AppMethodBeat.o(223252);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.d.a
 * JD-Core Version:    0.7.0.1
 */