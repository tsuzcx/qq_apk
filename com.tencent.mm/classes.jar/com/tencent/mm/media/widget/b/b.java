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
import com.tencent.mm.media.widget.d.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.l;
import d.y;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/widget/camera2/Camera2ImageSaver;", "Ljava/lang/Runnable;", "renderHelper", "Lcom/tencent/mm/media/widget/camera2/RenderScriptImageHelper;", "screenSize", "Landroid/graphics/Point;", "rotate", "", "image", "Landroid/media/Image;", "imageReadyCallback", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "", "(Lcom/tencent/mm/media/widget/camera2/RenderScriptImageHelper;Landroid/graphics/Point;ZLandroid/media/Image;Lkotlin/jvm/functions/Function1;)V", "convertBitmapUseRenderScript", "srcHeight", "", "srcWidth", "convertBitmapUseRenderScriptUsePacketYUV", "convertBitmapUseYuvImage", "stream", "Ljava/io/ByteArrayOutputStream;", "getDataFromImage", "", "imageToByteBuffer", "Ljava/nio/ByteBuffer;", "run", "Companion", "plugin-mediaeditor_release"})
public final class b
  implements Runnable
{
  private static final String TAG = "MicroMsg.Camera2ImageSaver";
  public static final b.a gxZ;
  private final f gxQ;
  private final Point gxV;
  private final boolean gxW;
  private final Image gxX;
  private final d.g.a.b<Bitmap, y> gxY;
  
  static
  {
    AppMethodBeat.i(94072);
    gxZ = new b.a((byte)0);
    TAG = "MicroMsg.Camera2ImageSaver";
    AppMethodBeat.o(94072);
  }
  
  public b(f paramf, Point paramPoint, boolean paramBoolean, Image paramImage, d.g.a.b<? super Bitmap, y> paramb)
  {
    AppMethodBeat.i(94071);
    this.gxQ = paramf;
    this.gxV = paramPoint;
    this.gxW = paramBoolean;
    this.gxX = paramImage;
    this.gxY = paramb;
    AppMethodBeat.o(94071);
  }
  
  private final Bitmap a(Image paramImage, int paramInt1, int paramInt2, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    AppMethodBeat.i(94069);
    paramImage = com.tencent.mm.plugin.mmsight.d.d(a(paramImage), paramInt1, paramInt2, 90);
    k.g(paramImage, "MMSightUtil.rotateNv21(y… srcHeight, srcWidth, 90)");
    if (this.gxW) {
      SightVideoJNI.mirrorCameraData(paramImage, paramInt2, paramInt1, true);
    }
    float f1 = paramInt1 * (this.gxV.x / this.gxV.y);
    float f2 = (paramInt2 - f1) / 2.0F;
    Rect localRect = new Rect((int)f2, 0, (int)(f1 + f2), paramInt1);
    new YuvImage(paramImage, 17, paramInt2, paramInt1, null).compressToJpeg(localRect, 100, (OutputStream)paramByteArrayOutputStream);
    paramImage = BitmapFactory.decodeByteArray(paramByteArrayOutputStream.toByteArray(), 0, paramByteArrayOutputStream.size());
    k.g(paramImage, "BitmapFactory.decodeByte…rray(), 0, stream.size())");
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
    byte[] arrayOfByte = new byte[ImageFormat.getBitsPerPixel(i) * (i5 * i6) / 8];
    Object localObject1 = paramImage[0];
    k.g(localObject1, "planes[0]");
    localObject1 = new byte[((Image.Plane)localObject1).getRowStride()];
    i = 0;
    int j = 1;
    k.g(paramImage, "planes");
    int i7 = paramImage.length;
    int m = 0;
    while (m < i7)
    {
      Object localObject2;
      int i8;
      int i9;
      switch (m)
      {
      default: 
        localObject2 = paramImage[m];
        k.g(localObject2, "planes[i]");
        localObject2 = ((Image.Plane)localObject2).getBuffer();
        Object localObject3 = paramImage[m];
        k.g(localObject3, "planes[i]");
        i8 = localObject3.getRowStride();
        localObject3 = paramImage[m];
        k.g(localObject3, "planes[i]");
        i9 = localObject3.getPixelStride();
        if (m != 0) {
          break;
        }
      }
      int i3;
      int i2;
      for (int k = 0;; k = 1)
      {
        i3 = i5 >> k;
        int i10 = i6 >> k;
        int n = localRect.top;
        ((ByteBuffer)localObject2).position((localRect.left >> k) * i9 + (n >> k) * i8);
        n = 0;
        for (;;)
        {
          if (n >= i10) {
            break label411;
          }
          if ((i9 != 1) || (j != 1)) {
            break;
          }
          ((ByteBuffer)localObject2).get(arrayOfByte, i, i3);
          i += i3;
          i2 = i3;
          if (n < i10 - 1) {
            ((ByteBuffer)localObject2).position(((ByteBuffer)localObject2).position() + i8 - i2);
          }
          n += 1;
        }
        i = 0;
        j = 1;
        break;
        i = i5 * i6 + 1;
        j = 2;
        break;
        i = i5 * i6;
        j = 2;
        break;
      }
      int i4 = (i3 - 1) * i9 + 1;
      ((ByteBuffer)localObject2).get((byte[])localObject1, 0, i4);
      int i1 = 0;
      k = i;
      for (;;)
      {
        i2 = i4;
        i = k;
        if (i1 >= i3) {
          break;
        }
        arrayOfByte[k] = localObject1[(i1 * i9)];
        k += j;
        i1 += 1;
      }
      label411:
      m += 1;
    }
    AppMethodBeat.o(94070);
    return arrayOfByte;
  }
  
  public final void run()
  {
    AppMethodBeat.i(94068);
    boolean bool = a.aoK();
    for (;;)
    {
      int j;
      int k;
      Object localObject3;
      try
      {
        j = this.gxX.getWidth();
        k = this.gxX.getHeight();
        if (!bool) {
          break label1123;
        }
        localObject3 = this.gxX;
        if (this.gxQ != null) {
          continue;
        }
        ad.e(TAG, "a error happened when use rs and does not init rs helper");
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
        ad.e(TAG, "take photo use image stream error", new Object[] { localException.getLocalizedMessage() });
        return;
        long l2 = bt.GC();
        Bitmap localBitmap1 = this.gxQ.e((Bitmap)localObject6, 270);
        ad.i(TAG, "op4 cost " + bt.aS(l2));
        long l1 = bt.aS(l1);
        ad.i(TAG, "newFunc cost ".concat(String.valueOf(l1)));
        continue;
      }
      finally
      {
        this.gxX.close();
        AppMethodBeat.o(94068);
      }
      this.gxY.aA(localObject1);
      this.gxX.close();
      AppMethodBeat.o(94068);
      return;
      l1 = bt.GC();
      i = ((Image)localObject3).getWidth();
      m = ((Image)localObject3).getHeight();
      f1 = i;
      f2 = this.gxV.x / this.gxV.y;
      f1 = (float)Math.ceil((m - f1 * f2) / 2.0F);
      localObject1 = ((Image)localObject3).getPlanes();
      localObject4 = new byte[3][];
      i = 0;
      if (i < 3)
      {
        localObject5 = localObject1[i];
        k.g(localObject5, "planes[it]");
        localObject5 = ((Image.Plane)localObject5).getBuffer();
        localObject6 = new byte[((ByteBuffer)localObject5).capacity()];
        ((ByteBuffer)localObject5).get((byte[])localObject6);
        localObject4[i] = localObject6;
        i += 1;
      }
      else
      {
        localObject6 = (byte[][])localObject4;
        l2 = bt.GC();
        localObject1 = this.gxQ;
        localObject3 = ((Image)localObject3).getPlanes();
        k.g(localObject3, "image.planes");
        i = (int)f1;
        k.h(localObject3, "planes");
        k.h(localObject6, "yuvBytes");
        m = localObject3[0].getRowStride();
        n = localObject3[1].getRowStride();
        i1 = localObject3[1].getPixelStride();
        localObject3 = new Type.Builder(((f)localObject1).gzh, Element.U8(((f)localObject1).gzh));
        ((Type.Builder)localObject3).setX(m).setY(localObject6[0].length / m);
        localObject3 = Allocation.createTyped(((f)localObject1).gzh, ((Type.Builder)localObject3).create());
        ((Allocation)localObject3).copyFrom(localObject6[0]);
        localObject4 = ((f)localObject1).gzg;
        if (localObject4 != null) {
          ((com.tencent.mm.d)localObject4).b((Allocation)localObject3);
        }
        localObject5 = new Type.Builder(((f)localObject1).gzh, Element.U8(((f)localObject1).gzh));
        ((Type.Builder)localObject5).setX(localObject6[1].length);
        localObject4 = Allocation.createTyped(((f)localObject1).gzh, ((Type.Builder)localObject5).create());
        ((Allocation)localObject4).copyFrom(localObject6[1]);
        localObject7 = ((f)localObject1).gzg;
        if (localObject7 != null) {
          ((com.tencent.mm.d)localObject7).c((Allocation)localObject4);
        }
        localObject5 = Allocation.createTyped(((f)localObject1).gzh, ((Type.Builder)localObject5).create());
        ((Allocation)localObject5).copyFrom(localObject6[2]);
        localObject6 = ((f)localObject1).gzg;
        if (localObject6 != null) {
          ((com.tencent.mm.d)localObject6).d((Allocation)localObject5);
        }
        localObject6 = ((f)localObject1).gzg;
        if (localObject6 != null) {
          ((com.tencent.mm.d)localObject6).IP();
        }
        localObject6 = ((f)localObject1).gzg;
        if (localObject6 != null) {
          ((com.tencent.mm.d)localObject6).ba(i);
        }
        localObject6 = ((f)localObject1).gzg;
        if (localObject6 != null) {
          ((com.tencent.mm.d)localObject6).bc(n);
        }
        localObject6 = ((f)localObject1).gzg;
        if (localObject6 != null) {
          ((com.tencent.mm.d)localObject6).bb(i1);
        }
        localObject6 = Bitmap.createBitmap(j + 0, k - i * 2, Bitmap.Config.ARGB_8888);
        localObject7 = Allocation.createFromBitmap(((f)localObject1).gzh, (Bitmap)localObject6, Allocation.MipmapControl.MIPMAP_NONE, 1);
        localObject1 = ((f)localObject1).gzg;
        if (localObject1 != null) {
          ((com.tencent.mm.d)localObject1).e((Allocation)localObject7);
        }
        ((Allocation)localObject7).copyTo((Bitmap)localObject6);
        ((Allocation)localObject3).destroy();
        ((Allocation)localObject4).destroy();
        ((Allocation)localObject5).destroy();
        ((Allocation)localObject7).destroy();
        k.g(localObject6, "bmp");
        ad.i(TAG, "op1 cost " + bt.aS(l2));
        if (this.gxW)
        {
          l2 = bt.GC();
          localObject1 = this.gxQ.e((Bitmap)localObject6, 90);
          ad.i(TAG, "op2 cost " + bt.aS(l2));
          l2 = bt.GC();
          localObject3 = this.gxQ;
          k.h(localObject1, "bitmap");
          localObject4 = ((f)localObject3).gzg;
          if (localObject4 != null) {
            ((com.tencent.mm.d)localObject4).hp(((Bitmap)localObject1).getWidth());
          }
          localObject4 = ((f)localObject3).gzg;
          if (localObject4 != null) {
            ((com.tencent.mm.d)localObject4).hq(((Bitmap)localObject1).getHeight());
          }
          localObject4 = Allocation.createFromBitmap(((f)localObject3).gzh, (Bitmap)localObject1, Allocation.MipmapControl.MIPMAP_NONE, 1);
          ((Bitmap)localObject1).recycle();
          localObject5 = ((f)localObject3).gzg;
          if (localObject5 != null) {
            ((com.tencent.mm.d)localObject5).a((Allocation)localObject4);
          }
          i = ((Bitmap)localObject1).getHeight();
          localObject1 = Bitmap.createBitmap(((Bitmap)localObject1).getWidth(), i, ((Bitmap)localObject1).getConfig());
          localObject5 = Allocation.createFromBitmap(((f)localObject3).gzh, (Bitmap)localObject1, Allocation.MipmapControl.MIPMAP_NONE, 1);
          localObject3 = ((f)localObject3).gzg;
          if (localObject3 != null) {
            ((com.tencent.mm.d)localObject3).c((Allocation)localObject5, (Allocation)localObject5);
          }
          ((Allocation)localObject5).copyTo((Bitmap)localObject1);
          ((Allocation)localObject5).destroy();
          ((Allocation)localObject4).destroy();
          k.g(localObject1, "target");
          ad.i(TAG, "op3 cost " + bt.aS(l2));
          l1 = bt.aS(l1);
          ad.i(TAG, "newFunc cost ".concat(String.valueOf(l1)));
        }
        else
        {
          label1123:
          localObject3 = new ByteArrayOutputStream();
          Bitmap localBitmap2 = a(this.gxX, j, k, (ByteArrayOutputStream)localObject3);
          ((ByteArrayOutputStream)localObject3).close();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.b
 * JD-Core Version:    0.7.0.1
 */