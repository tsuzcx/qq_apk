package com.tencent.mm.plugin.appbrand.d;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.webview.model.ay;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/complaint/AppBrandComplaintHelper;", "", "()V", "TAG", "", "tryTakeScreenshot", "pageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "plugin-appbrand-integration_release"})
public final class a
{
  public static final a lbv;
  
  static
  {
    AppMethodBeat.i(228152);
    lbv = new a();
    AppMethodBeat.o(228152);
  }
  
  public static final String b(ag paramag)
  {
    AppMethodBeat.i(228151);
    p.h(paramag, "pageView");
    Log.i("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, pageView:".concat(String.valueOf(paramag)));
    Object localObject = ((c)g.af(c.class)).getCacheDir();
    if (localObject == null)
    {
      Log.i("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, null image cache dir");
      AppMethodBeat.o(228151);
      return null;
    }
    localObject = new o((String)localObject + '/' + paramag.getAppId() + '_' + System.currentTimeMillis() + ".jpeg");
    paramag.NV();
    localObject = ((o)localObject).getAbsolutePath();
    p.g(localObject, "tempFile.absolutePath");
    h.RTc.aX((Runnable)new a(paramag, (String)localObject));
    paramag = ay.aYY((String)localObject);
    Log.i("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, localId:" + paramag + ", imagePath:" + (String)localObject);
    AppMethodBeat.o(228151);
    return paramag;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(ag paramag, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(228150);
      Bitmap localBitmap = this.lbw.bRB();
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
          localObject4 = BitmapUtil.extractThumbNail(localBitmap, 640, 640, false, true);
          localObject2 = localObject4;
          localObject1 = localObject4;
          BitmapUtil.saveBitmapToImage((Bitmap)localObject4, 100, Bitmap.CompressFormat.JPEG, this.lbx, true);
          localObject2 = localObject4;
          localObject1 = localObject4;
          Log.i("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, save bitmap to file:" + this.lbx + ", cost:" + (System.currentTimeMillis() - l));
          localObject2 = localObject4;
          localObject1 = localObject4;
          ((c)g.af(c.class)).WT(this.lbx);
        }
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          Log.d("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, recycle bitmap:".concat(String.valueOf(localBitmap)));
          localBitmap.recycle();
        }
        if ((localObject4 != null) && (!((Bitmap)localObject4).isRecycled()))
        {
          Log.d("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, recycle thumbnail:".concat(String.valueOf(localObject4)));
          ((Bitmap)localObject4).recycle();
        }
        AppMethodBeat.o(228150);
        return;
      }
      catch (Exception localException)
      {
        localObject1 = localObject2;
        Log.printErrStackTrace("MicroMsg.AppBrandComplaintHelper", (Throwable)localException, "tryTakeScreenshot, save bitmap to file fail", new Object[0]);
        return;
      }
      finally
      {
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          Log.d("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, recycle bitmap:".concat(String.valueOf(localBitmap)));
          localBitmap.recycle();
        }
        if ((localObject1 != null) && (!localObject1.isRecycled()))
        {
          Log.d("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, recycle thumbnail:".concat(String.valueOf(localObject1)));
          localObject1.recycle();
        }
        AppMethodBeat.o(228150);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.d.a
 * JD-Core Version:    0.7.0.1
 */