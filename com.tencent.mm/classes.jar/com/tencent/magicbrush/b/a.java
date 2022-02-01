package com.tencent.magicbrush.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.RectF;
import com.a.a.h;
import com.a.a.k;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.LegacyBitmap;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/magicbrush/image/BitmapDecoderMagicBrushExtension;", "Lcom/github/henryye/nativeiv/BitmapDecoder;", "()V", "TAG", "", "createBitmapWrapper", "Lcom/github/henryye/nativeiv/BitmapWrapper;", "mgr", "Lcom/github/henryye/nativeiv/BitmapDecoderFactoryMgr;", "decodeInfo", "Lcom/github/henryye/nativeiv/api/DecodeInfo;", "lib-magicbrush-nano_release"})
public final class a
  extends com.github.henryye.nativeiv.a
{
  private final String TAG = "MB.BitmapDecoderMagicBrushExtension";
  
  public final com.github.henryye.nativeiv.c a(final com.github.henryye.nativeiv.b paramb, final com.github.henryye.nativeiv.api.a parama)
  {
    AppMethodBeat.i(204689);
    p.k(paramb, "mgr");
    p.k(parama, "decodeInfo");
    paramb = (com.github.henryye.nativeiv.c)new a(this, paramb, parama, paramb, parama);
    AppMethodBeat.o(204689);
    return paramb;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/magicbrush/image/BitmapDecoderMagicBrushExtension$createBitmapWrapper$1", "Lcom/github/henryye/nativeiv/BitmapWrapper;", "getPreferredSizeByConfig", "Lkotlin/Pair;", "", "config", "Lcom/github/henryye/nativeiv/ImageDecodeConfig;", "providePictureInfo", "Lcom/github/henryye/nativeiv/bitmap/PictureInfo;", "ins", "Ljava/io/InputStream;", "lib-magicbrush-nano_release"})
  public static final class a
    extends com.github.henryye.nativeiv.c
  {
    a(com.github.henryye.nativeiv.b paramb1, com.github.henryye.nativeiv.api.a parama1, com.github.henryye.nativeiv.b paramb2, com.github.henryye.nativeiv.api.a parama2)
    {
      super(locala);
    }
    
    public final d g(final InputStream paramInputStream)
    {
      AppMethodBeat.i(204665);
      p.k(paramInputStream, "ins");
      locald = super.g(paramInputStream);
      if (locald.aKM == com.github.henryye.nativeiv.bitmap.c.aKK) {
        com.github.henryye.nativeiv.a.b.w(a.a(this.cOW), "hy: unknown type. judge svg", new Object[0]);
      }
      try
      {
        paramInputStream = h.c(paramInputStream);
        if (paramInputStream != null)
        {
          locald.aKM = com.github.henryye.nativeiv.bitmap.c.aKJ;
          forceSetUseType(BitmapType.Legacy);
          a((com.github.henryye.nativeiv.bitmap.b)new a(this, paramInputStream));
        }
      }
      catch (k paramInputStream)
      {
        for (;;)
        {
          com.github.henryye.nativeiv.a.b.printStackTrace(a.a(this.cOW), (Throwable)paramInputStream, "hy: not svg image. return as failed", new Object[0]);
          locald.aKM = com.github.henryye.nativeiv.bitmap.c.aKK;
        }
      }
      p.j(locald, "info");
      AppMethodBeat.o(204665);
      return locald;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/magicbrush/image/BitmapDecoderMagicBrushExtension$createBitmapWrapper$1$providePictureInfo$1", "Lcom/github/henryye/nativeiv/bitmap/IBitmapFactory;", "Landroid/graphics/Bitmap;", "accept", "", "is", "Ljava/io/InputStream;", "config", "Landroid/graphics/Bitmap$Config;", "format", "Lcom/github/henryye/nativeiv/bitmap/PictureFormat;", "acceptRegion", "destroy", "", "produceBitmap", "Lcom/github/henryye/nativeiv/bitmap/IBitmap;", "lib-magicbrush-nano_release"})
    public static final class a
      implements com.github.henryye.nativeiv.bitmap.b<Bitmap>
    {
      a(h paramh) {}
      
      public final boolean a(com.github.henryye.nativeiv.bitmap.c paramc)
      {
        return true;
      }
      
      public final void destroy() {}
      
      public final IBitmap<Bitmap> qD()
      {
        AppMethodBeat.i(204653);
        IBitmap localIBitmap = (IBitmap)new a(this);
        AppMethodBeat.o(204653);
        return localIBitmap;
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/magicbrush/image/BitmapDecoderMagicBrushExtension$createBitmapWrapper$1$providePictureInfo$1$produceBitmap$1", "Lcom/github/henryye/nativeiv/LegacyBitmap;", "decodeInputStreamImp", "Landroid/graphics/Bitmap;", "ins", "Ljava/io/InputStream;", "config", "Lcom/github/henryye/nativeiv/ImageDecodeConfig;", "format", "Lcom/github/henryye/nativeiv/bitmap/PictureFormat;", "lib-magicbrush-nano_release"})
      public static final class a
        extends LegacyBitmap
      {
        public final Bitmap a(InputStream paramInputStream, ImageDecodeConfig paramImageDecodeConfig, com.github.henryye.nativeiv.bitmap.c paramc)
        {
          AppMethodBeat.i(204633);
          int j = (int)this.cPb.cPa.oh();
          int i = (int)this.cPb.cPa.oi();
          if ((paramc == com.github.henryye.nativeiv.bitmap.c.aKJ) && (j > 0) && (j > 0))
          {
            if (paramImageDecodeConfig == null) {
              break label195;
            }
            paramInputStream = a.a.a(this.cPb.cOZ, paramImageDecodeConfig);
            if ((((Number)paramInputStream.Mx).intValue() <= 0) || (((Number)paramInputStream.My).intValue() <= 0)) {
              break label195;
            }
            j = ((Number)paramInputStream.Mx).intValue();
            i = ((Number)paramInputStream.My).intValue();
          }
          label195:
          for (;;)
          {
            paramInputStream = Bitmap.createBitmap(j, i, Bitmap.Config.ARGB_8888);
            new Canvas(paramInputStream).drawPicture(this.cPb.cPa.og(), new RectF(0.0F, 0.0F, j, i));
            p.j(paramInputStream, "bitmap");
            AppMethodBeat.o(204633);
            return paramInputStream;
            paramInputStream = super.a(paramInputStream, paramImageDecodeConfig, paramc);
            p.j(paramInputStream, "super.decodeInputStreamImp(ins, config, format)");
            AppMethodBeat.o(204633);
            return paramInputStream;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.magicbrush.b.a
 * JD-Core Version:    0.7.0.1
 */