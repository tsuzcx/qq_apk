package com.tencent.mm.media.widget.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.media.Image;
import android.media.Image.Plane;
import android.renderscript.Allocation;
import android.renderscript.Allocation.MipmapControl;
import android.renderscript.Element;
import android.renderscript.Type.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.d.c;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camera2/Camera2ImageSaver;", "Ljava/lang/Runnable;", "renderHelper", "Lcom/tencent/mm/media/widget/camera2/RenderScriptImageHelper;", "screenSize", "Landroid/graphics/Point;", "rotate", "", "image", "Landroid/media/Image;", "imageReadyCallback", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "", "(Lcom/tencent/mm/media/widget/camera2/RenderScriptImageHelper;Landroid/graphics/Point;ZLandroid/media/Image;Lkotlin/jvm/functions/Function1;)V", "convertBitmapUseRenderScript", "srcHeight", "", "srcWidth", "convertBitmapUseRenderScriptUsePacketYUV", "convertBitmapUseYuvImage", "stream", "Ljava/io/ByteArrayOutputStream;", "getDataFromImage", "", "imageToByteBuffer", "Ljava/nio/ByteBuffer;", "run", "Companion", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements Runnable
{
  private static final String TAG;
  public static final a.a nGT;
  private final e nGL;
  private final Point nGU;
  private final boolean nGV;
  private final Image nGW;
  private final b<Bitmap, ah> nGX;
  
  static
  {
    AppMethodBeat.i(94072);
    nGT = new a.a((byte)0);
    TAG = "MicroMsg.Camera2ImageSaver";
    AppMethodBeat.o(94072);
  }
  
  public a(e parame, Point paramPoint, boolean paramBoolean, Image paramImage, b<? super Bitmap, ah> paramb)
  {
    AppMethodBeat.i(94071);
    this.nGL = parame;
    this.nGU = paramPoint;
    this.nGV = paramBoolean;
    this.nGW = paramImage;
    this.nGX = paramb;
    AppMethodBeat.o(94071);
  }
  
  private final Bitmap a(Image paramImage, int paramInt1, int paramInt2, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    AppMethodBeat.i(94069);
    paramImage = com.tencent.mm.plugin.mmsight.d.g(a(paramImage), paramInt1, paramInt2, 90);
    s.s(paramImage, "rotateNv21(yuvData, srcHeight, srcWidth, 90)");
    if (this.nGV) {
      SightVideoJNI.mirrorCameraData(paramImage, paramInt2, paramInt1, true);
    }
    float f1 = paramInt1 * (this.nGU.x / this.nGU.y);
    float f2 = (paramInt2 - f1) / 2.0F;
    Rect localRect = new Rect((int)f2, 0, (int)(f1 + f2), paramInt1);
    new YuvImage(paramImage, 17, paramInt2, paramInt1, null).compressToJpeg(localRect, 100, (OutputStream)paramByteArrayOutputStream);
    paramImage = BitmapFactory.decodeByteArray(paramByteArrayOutputStream.toByteArray(), 0, paramByteArrayOutputStream.size());
    s.s(paramImage, "decodeByteArray(stream.t…rray(), 0, stream.size())");
    AppMethodBeat.o(94069);
    return paramImage;
  }
  
  private static byte[] a(Image paramImage)
  {
    AppMethodBeat.i(94070);
    Rect localRect = paramImage.getCropRect();
    int i = paramImage.getFormat();
    int i5 = localRect.width();
    int i6 = localRect.height();
    paramImage = paramImage.getPlanes();
    byte[] arrayOfByte1 = new byte[ImageFormat.getBitsPerPixel(i) * (i5 * i6) / 8];
    byte[] arrayOfByte2 = new byte[paramImage[0].getRowStride()];
    i = 0;
    int j = 1;
    int k = 0;
    int i7 = paramImage.length - 1;
    int n;
    label112:
    ByteBuffer localByteBuffer;
    int i8;
    int i9;
    label142:
    int i1;
    int i10;
    int m;
    label194:
    int i2;
    if (i7 >= 0)
    {
      n = k + 1;
      switch (k)
      {
      default: 
        localByteBuffer = paramImage[k].getBuffer();
        i8 = paramImage[k].getRowStride();
        i9 = paramImage[k].getPixelStride();
        if (k == 0)
        {
          k = 0;
          i1 = i5 >> k;
          i10 = i6 >> k;
          m = localRect.top;
          localByteBuffer.position((localRect.left >> k) * i9 + (m >> k) * i8);
          k = i;
          if (i10 > 0)
          {
            k = 0;
            i2 = k + 1;
            if ((i9 != 1) || (j != 1)) {
              break label315;
            }
            localByteBuffer.get(arrayOfByte1, i, i1);
            i += i1;
            m = i1;
          }
        }
        break;
      }
    }
    for (;;)
    {
      label230:
      if (k < i10 - 1) {
        localByteBuffer.position(localByteBuffer.position() + i8 - m);
      }
      label315:
      int i3;
      int i4;
      if (i2 >= i10)
      {
        k = i;
        if (n > i7)
        {
          AppMethodBeat.o(94070);
          return arrayOfByte1;
          i = 0;
          j = 1;
          break label112;
          i = i5 * i6 + 1;
          j = 2;
          break label112;
          i = i5 * i6;
          j = 2;
          break label112;
          k = 1;
          break label142;
          i3 = (i1 - 1) * i9 + 1;
          localByteBuffer.get(arrayOfByte2, 0, i3);
          i4 = 0;
          if (i1 <= 0) {
            break label415;
          }
          m = i;
        }
      }
      for (i = i4;; i = i4)
      {
        i4 = i + 1;
        arrayOfByte1[m] = arrayOfByte2[(i * i9)];
        m += j;
        if (i4 >= i1)
        {
          i = m;
          m = i3;
          break label230;
          m = n;
          i = k;
          k = m;
          break;
          k = i2;
          break label194;
        }
      }
      label415:
      m = i3;
    }
  }
  
  public final void run()
  {
    AppMethodBeat.i(94068);
    boolean bool = c.bvv();
    for (;;)
    {
      int j;
      int k;
      Object localObject3;
      try
      {
        j = this.nGW.getWidth();
        k = this.nGW.getHeight();
        if (!bool) {
          break label1087;
        }
        localObject3 = this.nGW;
        if (this.nGL != null) {
          continue;
        }
        Log.e(TAG, "a error happened when use rs and does not init rs helper");
        localObject4 = new ByteArrayOutputStream();
        localObject1 = a((Image)localObject3, j, k, (ByteArrayOutputStream)localObject4);
        ((ByteArrayOutputStream)localObject4).close();
      }
      catch (Exception localException)
      {
        Object localObject4;
        Object localObject1;
        int i;
        int m;
        float f1;
        float f2;
        Object localObject5;
        Object localObject6;
        int n;
        int i1;
        Object localObject7;
        Log.e(TAG, "take photo use image stream error", new Object[] { localException.getLocalizedMessage() });
        return;
        long l2 = Util.currentTicks();
        Bitmap localBitmap1 = this.nGL.f((Bitmap)localObject5, 270);
        Log.i(TAG, s.X("op4 cost ", Long.valueOf(Util.ticksToNow(l2))));
        long l1 = Util.ticksToNow(l1);
        Log.i(TAG, s.X("newFunc cost ", Long.valueOf(l1)));
        continue;
      }
      finally
      {
        this.nGW.close();
        AppMethodBeat.o(94068);
      }
      this.nGX.invoke(localObject1);
      this.nGW.close();
      AppMethodBeat.o(94068);
      return;
      l1 = Util.currentTicks();
      i = ((Image)localObject3).getWidth();
      m = ((Image)localObject3).getHeight();
      f1 = i;
      f2 = this.nGU.x / this.nGU.y;
      f1 = (float)Math.ceil((m - f1 * f2) / 2.0F);
      localObject1 = ((Image)localObject3).getPlanes();
      i = 0;
      localObject5 = new byte[3][];
      if (i < 3)
      {
        localObject4 = localObject1[i].getBuffer();
        localObject6 = new byte[((ByteBuffer)localObject4).capacity()];
        ((ByteBuffer)localObject4).get((byte[])localObject6);
        localObject5[i] = localObject6;
        i += 1;
      }
      else
      {
        l2 = Util.currentTicks();
        localObject1 = this.nGL;
        localObject3 = ((Image)localObject3).getPlanes();
        s.s(localObject3, "image.planes");
        i = (int)f1;
        s.u(localObject3, "planes");
        s.u(localObject5, "yuvBytes");
        ((e)localObject1).btC();
        m = localObject3[0].getRowStride();
        n = localObject3[1].getRowStride();
        i1 = localObject3[1].getPixelStride();
        localObject3 = new Type.Builder(((e)localObject1).nHS, Element.U8(((e)localObject1).nHS));
        ((Type.Builder)localObject3).setX(m).setY(localObject5[0].length / m);
        localObject3 = Allocation.createTyped(((e)localObject1).nHS, ((Type.Builder)localObject3).create());
        ((Allocation)localObject3).copyFrom(localObject5[0]);
        localObject4 = ((e)localObject1).nHR;
        if (localObject4 != null) {
          ((com.tencent.mm.d)localObject4).b((Allocation)localObject3);
        }
        localObject6 = new Type.Builder(((e)localObject1).nHS, Element.U8(((e)localObject1).nHS));
        ((Type.Builder)localObject6).setX(localObject5[1].length);
        localObject4 = Allocation.createTyped(((e)localObject1).nHS, ((Type.Builder)localObject6).create());
        ((Allocation)localObject4).copyFrom(localObject5[1]);
        localObject7 = ((e)localObject1).nHR;
        if (localObject7 != null) {
          ((com.tencent.mm.d)localObject7).c((Allocation)localObject4);
        }
        localObject6 = Allocation.createTyped(((e)localObject1).nHS, ((Type.Builder)localObject6).create());
        ((Allocation)localObject6).copyFrom(localObject5[2]);
        localObject5 = ((e)localObject1).nHR;
        if (localObject5 != null) {
          ((com.tencent.mm.d)localObject5).d((Allocation)localObject6);
        }
        localObject5 = ((e)localObject1).nHR;
        if (localObject5 != null) {
          ((com.tencent.mm.d)localObject5).aAB();
        }
        localObject5 = ((e)localObject1).nHR;
        if (localObject5 != null) {
          ((com.tencent.mm.d)localObject5).dS(i);
        }
        localObject5 = ((e)localObject1).nHR;
        if (localObject5 != null) {
          ((com.tencent.mm.d)localObject5).dU(n);
        }
        localObject5 = ((e)localObject1).nHR;
        if (localObject5 != null) {
          ((com.tencent.mm.d)localObject5).dT(i1);
        }
        localObject5 = Bitmap.createBitmap(j + 0, k - i * 2, Bitmap.Config.ARGB_8888);
        localObject7 = Allocation.createFromBitmap(((e)localObject1).nHS, (Bitmap)localObject5, Allocation.MipmapControl.MIPMAP_NONE, 1);
        localObject1 = ((e)localObject1).nHR;
        if (localObject1 != null) {
          ((com.tencent.mm.d)localObject1).e((Allocation)localObject7);
        }
        ((Allocation)localObject7).copyTo((Bitmap)localObject5);
        ((Allocation)localObject3).destroy();
        ((Allocation)localObject4).destroy();
        ((Allocation)localObject6).destroy();
        ((Allocation)localObject7).destroy();
        s.s(localObject5, "bmp");
        Log.i(TAG, s.X("op1 cost ", Long.valueOf(Util.ticksToNow(l2))));
        if (this.nGV)
        {
          l2 = Util.currentTicks();
          localObject1 = this.nGL.f((Bitmap)localObject5, 90);
          Log.i(TAG, s.X("op2 cost ", Long.valueOf(Util.ticksToNow(l2))));
          l2 = Util.currentTicks();
          localObject3 = this.nGL;
          s.u(localObject1, "bitmap");
          ((e)localObject3).btC();
          localObject4 = ((e)localObject3).nHR;
          if (localObject4 != null) {
            ((com.tencent.mm.d)localObject4).nC(((Bitmap)localObject1).getWidth());
          }
          localObject4 = ((e)localObject3).nHR;
          if (localObject4 != null) {
            ((com.tencent.mm.d)localObject4).nD(((Bitmap)localObject1).getHeight());
          }
          localObject4 = Allocation.createFromBitmap(((e)localObject3).nHS, (Bitmap)localObject1, Allocation.MipmapControl.MIPMAP_NONE, 1);
          ((Bitmap)localObject1).recycle();
          localObject5 = ((e)localObject3).nHR;
          if (localObject5 != null) {
            ((com.tencent.mm.d)localObject5).a((Allocation)localObject4);
          }
          i = ((Bitmap)localObject1).getHeight();
          localObject1 = Bitmap.createBitmap(((Bitmap)localObject1).getWidth(), i, ((Bitmap)localObject1).getConfig());
          localObject5 = Allocation.createFromBitmap(((e)localObject3).nHS, (Bitmap)localObject1, Allocation.MipmapControl.MIPMAP_NONE, 1);
          localObject3 = ((e)localObject3).nHR;
          if (localObject3 != null) {
            ((com.tencent.mm.d)localObject3).c((Allocation)localObject5, (Allocation)localObject5);
          }
          ((Allocation)localObject5).copyTo((Bitmap)localObject1);
          ((Allocation)localObject5).destroy();
          ((Allocation)localObject4).destroy();
          s.s(localObject1, "target");
          Log.i(TAG, s.X("op3 cost ", Long.valueOf(Util.ticksToNow(l2))));
          l1 = Util.ticksToNow(l1);
          Log.i(TAG, s.X("newFunc cost ", Long.valueOf(l1)));
        }
        else
        {
          label1087:
          localObject3 = new ByteArrayOutputStream();
          Bitmap localBitmap2 = a(this.nGW, j, k, (ByteArrayOutputStream)localObject3);
          ((ByteArrayOutputStream)localObject3).close();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.a
 * JD-Core Version:    0.7.0.1
 */