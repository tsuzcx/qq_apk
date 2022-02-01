package com.tencent.mm.plugin.appbrand.e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.page.ch;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.webview.model.az;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/complaint/AppBrandComplaintHelper;", "", "()V", "TAG", "", "handleBitmap", "", "bitmap", "Landroid/graphics/Bitmap;", "imagePath", "tryTakeScreenshot", "pageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a qVo;
  
  static
  {
    AppMethodBeat.i(316997);
    qVo = new a();
    AppMethodBeat.o(316997);
  }
  
  public static final String b(com.tencent.mm.plugin.appbrand.page.ah paramah)
  {
    Bitmap localBitmap = null;
    AppMethodBeat.i(316983);
    s.u(paramah, "pageView");
    Log.i("MicroMsg.AppBrandComplaintHelper", s.X("tryTakeScreenshot, pageView:", paramah));
    Object localObject1 = ((c)h.ax(c.class)).getCacheDir();
    if (localObject1 == null)
    {
      Log.i("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, null image cache dir");
      AppMethodBeat.o(316983);
      return null;
    }
    localObject1 = new com.tencent.mm.vfs.u(localObject1 + '/' + paramah.getAppId() + '_' + System.currentTimeMillis() + ".jpeg");
    paramah.arf();
    localObject1 = com.tencent.mm.vfs.ah.v(((com.tencent.mm.vfs.u)localObject1).jKT());
    s.s(localObject1, "tempFile.absolutePath");
    kotlin.g.a.a locala = (kotlin.g.a.a)new a(paramah, (String)localObject1);
    Object localObject2 = com.tencent.mm.plugin.appbrand.k.a.a.ruh;
    localObject2 = paramah.getRuntime();
    s.s(localObject2, "pageView.runtime");
    if (!com.tencent.mm.plugin.appbrand.k.a.a.a.F((w)localObject2))
    {
      localObject2 = com.tencent.mm.plugin.appbrand.k.a.a.ruh;
      localObject2 = paramah.getRuntime();
      s.s(localObject2, "pageView.runtime");
      if (!com.tencent.mm.plugin.appbrand.k.a.a.a.I((w)localObject2)) {}
    }
    else
    {
      localObject2 = paramah.getRuntime();
      if (((AppBrandRuntime)localObject2).qsp != null)
      {
        ((AppBrandRuntime)localObject2).qsp.cGj();
        ((AppBrandRuntime)localObject2).qsp.cGl();
      }
      paramah = ((AppBrandRuntime)localObject2).qsk.getRootView().findViewById(ba.f.app_brand_activity_container_view);
      if (paramah == null)
      {
        paramah = localBitmap;
        if (paramah == null) {
          break label319;
        }
        b(paramah, (String)localObject1);
      }
    }
    for (;;)
    {
      paramah = az.bkB((String)localObject1);
      Log.i("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, localId:" + paramah + ", imagePath:" + (String)localObject1);
      AppMethodBeat.o(316983);
      return paramah;
      localBitmap = ch.dD(paramah);
      paramah = localBitmap;
      if (((AppBrandRuntime)localObject2).qsp == null) {
        break;
      }
      ((AppBrandRuntime)localObject2).qsp.cGk();
      paramah = localBitmap;
      break;
      label319:
      locala.invoke();
      continue;
      locala.invoke();
    }
  }
  
  private static void b(Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(316988);
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject1 = null;
    Object localObject3 = localObject1;
    Object localObject2;
    if (paramBitmap != null)
    {
      localObject3 = localObject1;
      localObject2 = localObject4;
      localObject1 = localObject5;
    }
    try
    {
      if (!paramBitmap.isRecycled())
      {
        localObject2 = localObject4;
        localObject1 = localObject5;
        long l = System.currentTimeMillis();
        localObject2 = localObject4;
        localObject1 = localObject5;
        localObject3 = BitmapUtil.extractThumbNail(paramBitmap, 640, 640, false, true);
        localObject2 = localObject3;
        localObject1 = localObject3;
        BitmapUtil.saveBitmapToImage((Bitmap)localObject3, 100, Bitmap.CompressFormat.JPEG, paramString, true);
        localObject2 = localObject3;
        localObject1 = localObject3;
        Log.i("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, save bitmap to file:" + paramString + ", cost:" + (System.currentTimeMillis() - l));
        localObject2 = localObject3;
        localObject1 = localObject3;
        ((c)h.ax(c.class)).Xj(paramString);
      }
      if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
      {
        Log.d("MicroMsg.AppBrandComplaintHelper", s.X("tryTakeScreenshot, recycle bitmap:", paramBitmap));
        paramBitmap.recycle();
      }
      if ((localObject3 != null) && (!((Bitmap)localObject3).isRecycled()))
      {
        Log.d("MicroMsg.AppBrandComplaintHelper", s.X("tryTakeScreenshot, recycle thumbnail:", localObject3));
        ((Bitmap)localObject3).recycle();
      }
      AppMethodBeat.o(316988);
      return;
    }
    catch (Exception paramString)
    {
      localObject1 = localObject2;
      Log.printErrStackTrace("MicroMsg.AppBrandComplaintHelper", (Throwable)paramString, "tryTakeScreenshot, save bitmap to file fail", new Object[0]);
      return;
    }
    finally
    {
      if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
      {
        Log.d("MicroMsg.AppBrandComplaintHelper", s.X("tryTakeScreenshot, recycle bitmap:", paramBitmap));
        paramBitmap.recycle();
      }
      if ((localObject1 != null) && (!localObject1.isRecycled()))
      {
        Log.d("MicroMsg.AppBrandComplaintHelper", s.X("tryTakeScreenshot, recycle thumbnail:", localObject1));
        localObject1.recycle();
      }
      AppMethodBeat.o(316988);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    a(com.tencent.mm.plugin.appbrand.page.ah paramah, String paramString)
    {
      super();
    }
    
    private static final void a(com.tencent.mm.plugin.appbrand.page.ah paramah, String paramString)
    {
      AppMethodBeat.i(316977);
      s.u(paramah, "$pageView");
      s.u(paramString, "$imagePath");
      paramah = paramah.cEW();
      a locala = a.qVo;
      a.c(paramah, paramString);
      AppMethodBeat.o(316977);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.e.a
 * JD-Core Version:    0.7.0.1
 */