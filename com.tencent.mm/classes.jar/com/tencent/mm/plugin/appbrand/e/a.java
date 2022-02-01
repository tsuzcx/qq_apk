package com.tencent.mm.plugin.appbrand.e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.webview.model.aw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.e;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/complaint/AppBrandComplaintHelper;", "", "()V", "TAG", "", "tryTakeScreenshot", "pageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "plugin-appbrand-integration_release"})
public final class a
{
  public static final a jBl;
  
  static
  {
    AppMethodBeat.i(187106);
    jBl = new a();
    AppMethodBeat.o(187106);
  }
  
  public static final String b(ae paramae)
  {
    AppMethodBeat.i(187105);
    k.h(paramae, "pageView");
    ac.i("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, pageView:".concat(String.valueOf(paramae)));
    Object localObject = ((c)g.ab(c.class)).getCacheDir();
    if (localObject == null)
    {
      ac.i("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, null image cache dir");
      AppMethodBeat.o(187105);
      return null;
    }
    localObject = new e((String)localObject + '/' + paramae.getAppId() + '_' + System.currentTimeMillis() + ".jpeg");
    paramae.CV();
    localObject = ((e)localObject).getAbsolutePath();
    k.g(localObject, "tempFile.absolutePath");
    h.JZN.aS((Runnable)new a(paramae, (String)localObject));
    paramae = aw.aBZ((String)localObject);
    ac.i("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, localId:" + paramae + ", imagePath:" + (String)localObject);
    AppMethodBeat.o(187105);
    return paramae;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(ae paramae, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(187104);
      Bitmap localBitmap = this.jBm.bqN();
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
          f.a((Bitmap)localObject4, 100, Bitmap.CompressFormat.JPEG, this.jBn, true);
          localObject2 = localObject4;
          localObject1 = localObject4;
          ac.i("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, save bitmap to file:" + this.jBn + ", cost:" + (System.currentTimeMillis() - l));
          localObject2 = localObject4;
          localObject1 = localObject4;
          ((c)g.ab(c.class)).JL(this.jBn);
        }
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          ac.d("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, recycle bitmap:".concat(String.valueOf(localBitmap)));
          localBitmap.recycle();
        }
        if ((localObject4 != null) && (!((Bitmap)localObject4).isRecycled()))
        {
          ac.d("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, recycle thumbnail:".concat(String.valueOf(localObject4)));
          ((Bitmap)localObject4).recycle();
        }
        AppMethodBeat.o(187104);
        return;
      }
      catch (Exception localException)
      {
        localObject1 = localObject2;
        ac.printErrStackTrace("MicroMsg.AppBrandComplaintHelper", (Throwable)localException, "tryTakeScreenshot, save bitmap to file fail", new Object[0]);
        return;
      }
      finally
      {
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          ac.d("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, recycle bitmap:".concat(String.valueOf(localBitmap)));
          localBitmap.recycle();
        }
        if ((localObject1 != null) && (!localObject1.isRecycled()))
        {
          ac.d("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, recycle thumbnail:".concat(String.valueOf(localObject1)));
          localObject1.recycle();
        }
        AppMethodBeat.o(187104);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.e.a
 * JD-Core Version:    0.7.0.1
 */