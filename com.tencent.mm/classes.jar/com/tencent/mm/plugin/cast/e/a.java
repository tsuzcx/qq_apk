package com.tencent.mm.plugin.cast.e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Paint;
import android.media.Image;
import android.media.Image.Plane;
import android.media.ImageReader;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/cast/render/ScreenCastImageReader;", "", "width", "", "height", "(II)V", "bmp", "Landroid/graphics/Bitmap;", "encodeSurface", "Landroid/view/Surface;", "getHeight", "()I", "setHeight", "(I)V", "imageReader", "Landroid/media/ImageReader;", "inputSurface", "getInputSurface", "()Landroid/view/Surface;", "setInputSurface", "(Landroid/view/Surface;)V", "lock", "paint", "Landroid/graphics/Paint;", "getWidth", "setWidth", "doSendData", "", "initScreenCastImageReader", "looper", "Landroid/os/Looper;", "setEncodeSurface", "surface", "stopRenderer", "Companion", "plugin-cast_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a.a wNi;
  private int height;
  public ImageReader imageReader;
  public Surface inputSurface;
  final Object lock;
  final Paint paint;
  public Surface wNj;
  Bitmap wNk;
  private int width;
  
  static
  {
    AppMethodBeat.i(274084);
    wNi = new a.a((byte)0);
    AppMethodBeat.o(274084);
  }
  
  public a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(274067);
    this.width = paramInt1;
    this.height = paramInt2;
    this.lock = new Object();
    this.paint = new Paint();
    AppMethodBeat.o(274067);
  }
  
  private static final void a(a parama, ImageReader paramImageReader)
  {
    int j = 1;
    AppMethodBeat.i(274079);
    s.u(parama, "this$0");
    paramImageReader = paramImageReader.acquireLatestImage();
    int i;
    if (paramImageReader != null)
    {
      ??? = paramImageReader.getPlanes();
      s.s(???, "planes");
      if (???.length != 0) {
        break label173;
      }
      i = 1;
    }
    for (;;)
    {
      ByteBuffer localByteBuffer;
      int k;
      if (i == 0)
      {
        i = j;
        if (i != 0)
        {
          localByteBuffer = ???[0].getBuffer();
          i = ???[0].getPixelStride();
          j = ???[0].getRowStride();
          k = parama.width;
        }
      }
      synchronized (parama.lock)
      {
        if (parama.wNk == null)
        {
          Log.i("MicroMsg.ScreenCastImageReader", "image reader render ");
          int m = parama.width;
          parama.wNk = Bitmap.createBitmap((j - k * i) / i + m, parama.height, Bitmap.Config.ARGB_8888);
        }
        parama = parama.wNk;
        if (parama != null)
        {
          parama.copyPixelsFromBuffer((Buffer)localByteBuffer);
          parama = ah.aiuX;
        }
        paramImageReader.close();
        AppMethodBeat.o(274079);
        return;
        label173:
        i = 0;
        continue;
        i = 0;
      }
    }
  }
  
  public final void i(Looper paramLooper)
  {
    AppMethodBeat.i(274096);
    s.u(paramLooper, "looper");
    this.imageReader = ImageReader.newInstance(this.width, this.height, 1, 1);
    ImageReader localImageReader = this.imageReader;
    if (localImageReader != null) {
      localImageReader.setOnImageAvailableListener(new a..ExternalSyntheticLambda0(this), new Handler(paramLooper));
    }
    paramLooper = this.imageReader;
    if (paramLooper == null) {}
    for (paramLooper = null;; paramLooper = paramLooper.getSurface())
    {
      this.inputSurface = paramLooper;
      AppMethodBeat.o(274096);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.e.a
 * JD-Core Version:    0.7.0.1
 */