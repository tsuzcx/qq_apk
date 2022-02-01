package com.tencent.mm.plugin.cast.f;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Paint;
import android.media.Image;
import android.media.Image.Plane;
import android.media.ImageReader;
import android.media.ImageReader.OnImageAvailableListener;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.Buffer;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/cast/render/ScreenCastImageReader;", "", "width", "", "height", "(II)V", "bmp", "Landroid/graphics/Bitmap;", "encodeSurface", "Landroid/view/Surface;", "getHeight", "()I", "setHeight", "(I)V", "imageReader", "Landroid/media/ImageReader;", "inputSurface", "getInputSurface", "()Landroid/view/Surface;", "setInputSurface", "(Landroid/view/Surface;)V", "lock", "paint", "Landroid/graphics/Paint;", "getWidth", "setWidth", "doSendData", "", "initScreenCastImageReader", "looper", "Landroid/os/Looper;", "setEncodeSurface", "surface", "stopRenderer", "Companion", "plugin-cast_release"})
public final class a
{
  public static final a.a tJO;
  int height;
  Surface inputSurface;
  ImageReader jUA;
  final Object lock;
  final Paint paint;
  public Surface tJM;
  Bitmap tJN;
  int width;
  
  static
  {
    AppMethodBeat.i(190335);
    tJO = new a.a((byte)0);
    AppMethodBeat.o(190335);
  }
  
  public a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190333);
    this.width = paramInt1;
    this.height = paramInt2;
    this.lock = new Object();
    this.paint = new Paint();
    AppMethodBeat.o(190333);
  }
  
  public final void cLC()
  {
    AppMethodBeat.i(190331);
    Object localObject = this.tJM;
    if (localObject != null) {
      ((Surface)localObject).release();
    }
    localObject = this.inputSurface;
    if (localObject != null) {
      ((Surface)localObject).release();
    }
    this.inputSurface = null;
    localObject = this.jUA;
    if (localObject != null) {
      ((ImageReader)localObject).close();
    }
    this.jUA = null;
    AppMethodBeat.o(190331);
  }
  
  public final void h(Looper paramLooper)
  {
    AppMethodBeat.i(190326);
    p.k(paramLooper, "looper");
    this.jUA = ImageReader.newInstance(this.width, this.height, 1, 1);
    ImageReader localImageReader = this.jUA;
    if (localImageReader != null) {
      localImageReader.setOnImageAvailableListener((ImageReader.OnImageAvailableListener)new b(this), new Handler(paramLooper));
    }
    paramLooper = this.jUA;
    if (paramLooper != null) {}
    for (paramLooper = paramLooper.getSurface();; paramLooper = null)
    {
      this.inputSurface = paramLooper;
      AppMethodBeat.o(190326);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "reader", "Landroid/media/ImageReader;", "kotlin.jvm.PlatformType", "onImageAvailable"})
  static final class b
    implements ImageReader.OnImageAvailableListener
  {
    b(a parama) {}
    
    public final void onImageAvailable(ImageReader paramImageReader)
    {
      int j = 1;
      AppMethodBeat.i(189613);
      paramImageReader = paramImageReader.acquireLatestImage();
      int i;
      if (paramImageReader != null)
      {
        ??? = paramImageReader.getPlanes();
        p.j(???, "planes");
        if (???.length != 0) {
          break label229;
        }
        i = 1;
      }
      for (;;)
      {
        Object localObject1;
        Object localObject3;
        int k;
        if (i == 0)
        {
          i = j;
          if (i != 0)
          {
            localObject1 = ???[0];
            p.j(localObject1, "planes[0]");
            localObject1 = ((Image.Plane)localObject1).getBuffer();
            localObject3 = ???[0];
            p.j(localObject3, "planes[0]");
            i = ((Image.Plane)localObject3).getPixelStride();
            ??? = ???[0];
            p.j(???, "planes[0]");
            j = ((Image.Plane)???).getRowStride();
            k = this.tJP.width;
          }
        }
        synchronized (a.a(this.tJP))
        {
          if (a.b(this.tJP) == null)
          {
            Log.i("MicroMsg.ScreenCastImageReader", "image reader render ");
            localObject3 = this.tJP;
            int m = this.tJP.width;
            a.a((a)localObject3, Bitmap.createBitmap((j - k * i) / i + m, this.tJP.height, Bitmap.Config.ARGB_8888));
          }
          localObject3 = a.b(this.tJP);
          if (localObject3 != null)
          {
            ((Bitmap)localObject3).copyPixelsFromBuffer((Buffer)localObject1);
            localObject1 = x.aazN;
          }
          paramImageReader.close();
          AppMethodBeat.o(189613);
          return;
          label229:
          i = 0;
          continue;
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.f.a
 * JD-Core Version:    0.7.0.1
 */