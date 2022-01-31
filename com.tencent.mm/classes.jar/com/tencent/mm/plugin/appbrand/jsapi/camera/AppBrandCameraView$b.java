package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.vfs.e;
import java.io.File;

final class AppBrandCameraView$b
  implements AppBrandCameraView.a
{
  private AppBrandCameraView$b(AppBrandCameraView paramAppBrandCameraView) {}
  
  private void R(int paramInt, String paramString)
  {
    AppMethodBeat.i(130921);
    if (AppBrandCameraView.q(this.hIQ) != null) {
      AppBrandCameraView.q(this.hIQ).R(paramInt, paramString);
    }
    AppMethodBeat.o(130921);
  }
  
  private void d(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(130923);
    if (AppBrandCameraView.q(this.hIQ) != null) {
      AppBrandCameraView.q(this.hIQ).d(paramInt, paramString1, g(AppBrandCameraView.b(this.hIQ), paramString2), g(AppBrandCameraView.b(this.hIQ), paramString3));
    }
    AppBrandCameraView.p(this.hIQ);
    AppMethodBeat.o(130923);
  }
  
  static String g(com.tencent.mm.plugin.appbrand.jsapi.c paramc, String paramString)
  {
    AppMethodBeat.i(130925);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(130925);
      return paramString;
    }
    com.tencent.mm.plugin.appbrand.s.j localj = new com.tencent.mm.plugin.appbrand.s.j();
    if (paramc.wX().a(new File(paramString), "", true, localj) == com.tencent.mm.plugin.appbrand.appstorage.j.gZA)
    {
      paramc = (String)localj.value;
      AppMethodBeat.o(130925);
      return paramc;
    }
    AppMethodBeat.o(130925);
    return null;
  }
  
  final boolean a(Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(130919);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
      try
      {
        AppBrandCameraView.b(this.hIQ, paramBitmap.getWidth());
        AppBrandCameraView.c(this.hIQ, paramBitmap.getHeight());
        int i = 90;
        if ("normal".equals(AppBrandCameraView.n(this.hIQ))) {
          i = 44;
        }
        for (;;)
        {
          d.a(paramBitmap, i, Bitmap.CompressFormat.JPEG, paramString, true);
          ab.i("MicroMsg.AppBrandCameraView", "bitmap filelen %s", new Object[] { Long.valueOf(e.avI(paramString)) });
          AppMethodBeat.o(130919);
          return true;
          boolean bool = "low".equals(AppBrandCameraView.n(this.hIQ));
          if (bool) {
            i = 25;
          }
        }
        AppMethodBeat.o(130919);
      }
      catch (Exception paramBitmap)
      {
        ab.e("MicroMsg.AppBrandCameraView", "error for saveBitmapToImage %s", new Object[] { paramBitmap.getMessage() });
      }
    }
    return false;
  }
  
  public final void aCA()
  {
    AppMethodBeat.i(130918);
    ab.i("MicroMsg.AppBrandCameraView", "takePicture.");
    if (AppBrandCameraView.f(this.hIQ) == null)
    {
      ab.i("MicroMsg.AppBrandCameraView", "recordView is null");
      AppMethodBeat.o(130918);
      return;
    }
    if (AppBrandCameraView.g(this.hIQ) == 2)
    {
      ab.w("MicroMsg.AppBrandCameraView", "takePicture is recording!!");
      AppMethodBeat.o(130918);
      return;
    }
    if ((AppBrandCameraView.h(this.hIQ)) || (bo.av(AppBrandCameraView.i(this.hIQ)) < 300L))
    {
      ab.i("MicroMsg.AppBrandCameraView", "not the right time to take picture.");
      AppMethodBeat.o(130918);
      return;
    }
    if (!AppBrandCameraView.j(this.hIQ))
    {
      ab.w("MicroMsg.AppBrandCameraView", "takePicture err, isn't init done");
      AppBrandCameraView.a(this.hIQ, -1, null, "camera has not been initialized");
      AppMethodBeat.o(130918);
      return;
    }
    AppBrandCameraView.a(this.hIQ, bo.yB());
    AppBrandCameraView.k(this.hIQ);
    AppBrandCameraView.a(this.hIQ, 3);
    AppBrandCameraView.f(this.hIQ).a(new AppBrandCameraView.b.1(this), "on".equals(AppBrandCameraView.m(this.hIQ)));
    AppMethodBeat.o(130918);
  }
  
  public final void aCJ()
  {
    AppMethodBeat.i(130920);
    ab.i("MicroMsg.AppBrandCameraView", "startRecord.");
    a locala = a.a.aCy();
    if ((!locala.hIk) || (!locala.hIl)) {
      ab.i("MicroMsg.AppBrandCameraMrg", "no all permission");
    }
    if ((locala.hIk) && (locala.hIl)) {}
    for (int i = 1; i == 0; i = 0)
    {
      Toast.makeText(AppBrandCameraView.o(this.hIQ), 2131301569, 1).show();
      ab.w("MicroMsg.AppBrandCameraView", "no micro phone permission");
      R(-1, "permission");
      AppMethodBeat.o(130920);
      return;
    }
    if (AppBrandCameraView.g(this.hIQ) == 2)
    {
      ab.w("MicroMsg.AppBrandCameraView", "startRecord is recording!!");
      R(-1, "is recording");
      AppMethodBeat.o(130920);
      return;
    }
    if (!AppBrandCameraView.j(this.hIQ))
    {
      ab.w("MicroMsg.AppBrandCameraView", "startRecord err, isn't init done");
      R(-1, "camera has not been initialized");
      AppMethodBeat.o(130920);
      return;
    }
    if (AppBrandCameraView.f(this.hIQ).oGg.EC())
    {
      AppBrandCameraView.b(this.hIQ, bo.yB());
      AppBrandCameraView.a(this.hIQ, 2);
      R(0, "");
      AppBrandCameraView.p(this.hIQ);
      AppMethodBeat.o(130920);
      return;
    }
    ab.w("MicroMsg.AppBrandCameraView", "startRecord fail !!");
    R(-1, "startRecord fail");
    AppMethodBeat.o(130920);
  }
  
  public final void aCK()
  {
    AppMethodBeat.i(130924);
    long l = bo.av(AppBrandCameraView.x(this.hIQ));
    if (l < 1500L)
    {
      ab.i("MicroMsg.AppBrandCameraView", "stopRecord in %d ms later", new Object[] { Long.valueOf(1500L - l) });
      al.p(new AppBrandCameraView.b.4(this), 1500L - l);
      AppMethodBeat.o(130924);
      return;
    }
    stopRecord();
    AppMethodBeat.o(130924);
  }
  
  final void aCN()
  {
    AppMethodBeat.i(143397);
    AppBrandCameraView.w(this.hIQ);
    AppBrandCameraView.a(this.hIQ, false);
    AppMethodBeat.o(143397);
  }
  
  public final void init() {}
  
  public final void q(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(130917);
    if (!AppBrandCameraView.e(this.hIQ))
    {
      AppMethodBeat.o(130917);
      return;
    }
    AppMethodBeat.o(130917);
  }
  
  public final void release() {}
  
  public final void stopRecord()
  {
    AppMethodBeat.i(130922);
    ab.i("MicroMsg.AppBrandCameraView", "stopRecord");
    if (AppBrandCameraView.f(this.hIQ) == null)
    {
      ab.i("MicroMsg.AppBrandCameraView", "recordView is null");
      d(-1, "camera is null", null, null);
      AppMethodBeat.o(130922);
      return;
    }
    if (AppBrandCameraView.g(this.hIQ) != 2)
    {
      ab.w("MicroMsg.AppBrandCameraView", "stopRecord is not recording!!");
      d(-1, "is not recording", null, null);
      AppMethodBeat.o(130922);
      return;
    }
    if (AppBrandCameraView.r(this.hIQ))
    {
      ab.i("MicroMsg.AppBrandCameraView", "recordView is IsStopping");
      d(-1, "is stopping", null, null);
      AppMethodBeat.o(130922);
      return;
    }
    AppBrandCameraView.a(this.hIQ, true);
    AppBrandCameraView.f(this.hIQ).a(new AppBrandCameraView.b.2(this));
    AppMethodBeat.o(130922);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.b
 * JD-Core Version:    0.7.0.1
 */