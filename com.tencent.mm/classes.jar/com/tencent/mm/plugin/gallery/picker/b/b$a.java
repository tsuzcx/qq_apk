package com.tencent.mm.plugin.gallery.picker.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import d.g.b.p;
import d.l;
import java.io.InputStream;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Companion;", "", "()V", "TAG", "", "decodeBitmap", "Landroid/graphics/Bitmap;", "inputStream", "Ljava/io/InputStream;", "limitW", "", "limitH", "isRotate", "", "isClose", "inputPath", "plugin-gallery_release"})
public final class b$a
{
  public static Bitmap a(InputStream paramInputStream, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(164869);
    p.h(paramInputStream, "inputStream");
    if (paramInt1 > paramInt2) {}
    for (;;)
    {
      BitmapFactory.Options localOptions = h.c(paramInputStream, false);
      float f1;
      float f2;
      Object localObject1;
      if (localOptions.outWidth <= localOptions.outHeight)
      {
        f1 = 1.0F * paramInt2 / localOptions.outWidth;
        f2 = 1.0F * paramInt1 / localOptions.outHeight;
        if (f1 > f2)
        {
          f1 = f2;
          f1 = Math.min(1.0F, f1);
          i = (int)(localOptions.outWidth * f1);
          int j = (int)(localOptions.outHeight * f1);
          paramInputStream.reset();
          Object localObject2 = h.a(paramInputStream, 0.0F, i, j);
          localObject1 = localObject2;
          if (paramBoolean1)
          {
            paramInputStream.reset();
            localObject1 = Exif.fromStream(paramInputStream);
            p.g(localObject1, "Exif.fromStream(inputStream)");
            i = ((Exif)localObject1).getOrientationInDegree();
            ae.i("MediaTailor", "read exif rotate degree %d", new Object[] { Integer.valueOf(i) });
            localObject1 = h.a((Bitmap)localObject2, i * 1.0F);
          }
          if (paramBoolean2) {
            paramInputStream.close();
          }
          localObject2 = new StringBuilder("[decodeBitmap] [").append(localOptions.outWidth).append(':').append(localOptions.outHeight).append("]->[");
          if (localObject1 == null) {
            break label423;
          }
          paramInputStream = Integer.valueOf(((Bitmap)localObject1).getWidth());
          label244:
          localObject2 = ((StringBuilder)localObject2).append(paramInputStream).append(':');
          if (localObject1 == null) {
            break label428;
          }
          paramInputStream = Integer.valueOf(((Bitmap)localObject1).getHeight());
          label271:
          ae.i("MediaTailor", paramInputStream + "] scale=" + f1 + " limit[" + paramInt2 + ':' + paramInt1 + "] decode bitmap done!");
          if (localObject1 != null) {
            break label433;
          }
          paramInputStream = h.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
          ae.e("MediaTailor", "bitmap is null. " + bu.fpN());
        }
      }
      for (;;)
      {
        p.g(paramInputStream, "bitmap");
        AppMethodBeat.o(164869);
        return paramInputStream;
        break;
        f1 = 1.0F * paramInt2 / localOptions.outHeight;
        f2 = 1.0F * paramInt1 / localOptions.outWidth;
        if (f1 > f2) {
          f1 = f2;
        }
        for (;;)
        {
          f1 = Math.min(1.0F, f1);
          break;
        }
        label423:
        paramInputStream = null;
        break label244;
        label428:
        paramInputStream = null;
        break label271;
        label433:
        paramInputStream = (InputStream)localObject1;
      }
      int i = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.b.b.a
 * JD-Core Version:    0.7.0.1
 */