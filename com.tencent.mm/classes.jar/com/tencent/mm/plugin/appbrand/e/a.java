package com.tencent.mm.plugin.appbrand.e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.webview.model.aw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.e;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/complaint/AppBrandComplaintHelper;", "", "()V", "TAG", "", "tryTakeScreenshot", "pageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "plugin-appbrand-integration_release"})
public final class a
{
  public static final a jaY;
  
  static
  {
    AppMethodBeat.i(196241);
    jaY = new a();
    AppMethodBeat.o(196241);
  }
  
  public static final String b(ae paramae)
  {
    AppMethodBeat.i(196240);
    k.h(paramae, "pageView");
    ad.i("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, pageView:".concat(String.valueOf(paramae)));
    Object localObject = ((c)g.ab(c.class)).aTh();
    if (localObject == null)
    {
      ad.i("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, null image cache dir");
      AppMethodBeat.o(196240);
      return null;
    }
    localObject = new e((String)localObject + '/' + paramae.getAppId() + '_' + System.currentTimeMillis() + ".jpeg");
    paramae.Ds();
    localObject = ((e)localObject).getAbsolutePath();
    k.g(localObject, "tempFile.absolutePath");
    h.Iye.aP((Runnable)new a(paramae, (String)localObject));
    paramae = aw.awH((String)localObject);
    ad.i("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, localId:" + paramae + ", imagePath:" + (String)localObject);
    AppMethodBeat.o(196240);
    return paramae;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(ae paramae, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(196239);
      Bitmap localBitmap = this.jaZ.bjW();
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
          localObject4 = f.a(localBitmap, 640, 640, false, true);
          localObject2 = localObject4;
          localObject1 = localObject4;
          f.a((Bitmap)localObject4, 100, Bitmap.CompressFormat.JPEG, this.jba, true);
          localObject2 = localObject4;
          localObject1 = localObject4;
          ad.i("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, save bitmap to file:" + this.jba + ", cost:" + (System.currentTimeMillis() - l));
          localObject2 = localObject4;
          localObject1 = localObject4;
          ((c)g.ab(c.class)).FH(this.jba);
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
        AppMethodBeat.o(196239);
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
        AppMethodBeat.o(196239);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.e.a
 * JD-Core Version:    0.7.0.1
 */