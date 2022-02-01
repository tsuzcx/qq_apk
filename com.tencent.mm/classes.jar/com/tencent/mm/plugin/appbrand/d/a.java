package com.tencent.mm.plugin.appbrand.d;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.webview.model.az;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.q;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/complaint/AppBrandComplaintHelper;", "", "()V", "TAG", "", "tryTakeScreenshot", "pageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "plugin-appbrand-integration_release"})
public final class a
{
  public static final a nVE;
  
  static
  {
    AppMethodBeat.i(283915);
    nVE = new a();
    AppMethodBeat.o(283915);
  }
  
  public static final String b(ah paramah)
  {
    AppMethodBeat.i(283914);
    p.k(paramah, "pageView");
    Log.i("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, pageView:".concat(String.valueOf(paramah)));
    Object localObject = ((c)com.tencent.mm.kernel.h.ae(c.class)).getCacheDir();
    if (localObject == null)
    {
      Log.i("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, null image cache dir");
      AppMethodBeat.o(283914);
      return null;
    }
    localObject = new q((String)localObject + '/' + paramah.getAppId() + '_' + System.currentTimeMillis() + ".jpeg");
    paramah.QS();
    localObject = ((q)localObject).bOF();
    p.j(localObject, "tempFile.absolutePath");
    com.tencent.e.h.ZvG.be((Runnable)new a(paramah, (String)localObject));
    paramah = az.bkS((String)localObject);
    Log.i("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, localId:" + paramah + ", imagePath:" + (String)localObject);
    AppMethodBeat.o(283914);
    return paramah;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(ah paramah, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(277955);
      Bitmap localBitmap = this.nyu.ces();
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
          BitmapUtil.saveBitmapToImage((Bitmap)localObject4, 100, Bitmap.CompressFormat.JPEG, this.nVF, true);
          localObject2 = localObject4;
          localObject1 = localObject4;
          Log.i("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, save bitmap to file:" + this.nVF + ", cost:" + (System.currentTimeMillis() - l));
          localObject2 = localObject4;
          localObject1 = localObject4;
          ((c)com.tencent.mm.kernel.h.ae(c.class)).aeG(this.nVF);
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
        AppMethodBeat.o(277955);
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
        AppMethodBeat.o(277955);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.d.a
 * JD-Core Version:    0.7.0.1
 */