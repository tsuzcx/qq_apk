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
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/image/BitmapDecoderMagicBrushExtension;", "Lcom/github/henryye/nativeiv/BitmapDecoder;", "()V", "TAG", "", "createBitmapWrapper", "Lcom/github/henryye/nativeiv/BitmapWrapper;", "mgr", "Lcom/github/henryye/nativeiv/BitmapDecoderFactoryMgr;", "decodeInfo", "Lcom/github/henryye/nativeiv/api/DecodeInfo;", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 16})
public final class a
  extends com.github.henryye.nativeiv.a
{
  private final String TAG = "MB.BitmapDecoderMagicBrushExtension";
  
  public final com.github.henryye.nativeiv.c a(final com.github.henryye.nativeiv.b paramb, final com.github.henryye.nativeiv.api.a parama)
  {
    AppMethodBeat.i(228797);
    s.t(paramb, "mgr");
    s.t(parama, "decodeInfo");
    paramb = (com.github.henryye.nativeiv.c)new a(this, paramb, parama, paramb, parama);
    AppMethodBeat.o(228797);
    return paramb;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/magicbrush/image/BitmapDecoderMagicBrushExtension$createBitmapWrapper$1", "Lcom/github/henryye/nativeiv/BitmapWrapper;", "getPreferredSizeByConfig", "Lkotlin/Pair;", "", "config", "Lcom/github/henryye/nativeiv/ImageDecodeConfig;", "providePictureInfo", "Lcom/github/henryye/nativeiv/bitmap/PictureInfo;", "ins", "Ljava/io/InputStream;", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 16})
  public static final class a
    extends com.github.henryye.nativeiv.c
  {
    a(com.github.henryye.nativeiv.b paramb1, com.github.henryye.nativeiv.api.a parama1, com.github.henryye.nativeiv.b paramb2, com.github.henryye.nativeiv.api.a parama2)
    {
      super(locala);
    }
    
    public final d q(final InputStream paramInputStream)
    {
      AppMethodBeat.i(228815);
      s.t(paramInputStream, "ins");
      locald = super.q(paramInputStream);
      if (locald.cEI == com.github.henryye.nativeiv.bitmap.c.cEG) {
        com.github.henryye.nativeiv.a.b.w(a.a(this.eKb), "hy: unknown type. judge svg", new Object[0]);
      }
      try
      {
        paramInputStream = h.m(paramInputStream);
        if (paramInputStream != null)
        {
          locald.cEI = com.github.henryye.nativeiv.bitmap.c.cEF;
          forceSetUseType(BitmapType.Legacy);
          a((com.github.henryye.nativeiv.bitmap.b)new a(this, paramInputStream));
        }
      }
      catch (k paramInputStream)
      {
        for (;;)
        {
          com.github.henryye.nativeiv.a.b.printStackTrace(a.a(this.eKb), (Throwable)paramInputStream, "hy: not svg image. return as failed", new Object[0]);
          locald.cEI = com.github.henryye.nativeiv.bitmap.c.cEG;
        }
      }
      s.r(locald, "info");
      AppMethodBeat.o(228815);
      return locald;
    }
    
    @Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/magicbrush/image/BitmapDecoderMagicBrushExtension$createBitmapWrapper$1$providePictureInfo$1", "Lcom/github/henryye/nativeiv/bitmap/IBitmapFactory;", "Landroid/graphics/Bitmap;", "accept", "", "is", "Ljava/io/InputStream;", "config", "Landroid/graphics/Bitmap$Config;", "format", "Lcom/github/henryye/nativeiv/bitmap/PictureFormat;", "acceptRegion", "destroy", "", "produceBitmap", "Lcom/github/henryye/nativeiv/bitmap/IBitmap;", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 16})
    public static final class a
      implements com.github.henryye.nativeiv.bitmap.b<Bitmap>
    {
      a(h paramh) {}
      
      public final IBitmap<Bitmap> Qg()
      {
        AppMethodBeat.i(228806);
        IBitmap localIBitmap = (IBitmap)new a(this);
        AppMethodBeat.o(228806);
        return localIBitmap;
      }
      
      public final boolean a(com.github.henryye.nativeiv.bitmap.c paramc)
      {
        return true;
      }
      
      public final void destroy() {}
      
      @Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/magicbrush/image/BitmapDecoderMagicBrushExtension$createBitmapWrapper$1$providePictureInfo$1$produceBitmap$1", "Lcom/github/henryye/nativeiv/LegacyBitmap;", "decodeInputStreamImp", "Landroid/graphics/Bitmap;", "ins", "Ljava/io/InputStream;", "config", "Lcom/github/henryye/nativeiv/ImageDecodeConfig;", "format", "Lcom/github/henryye/nativeiv/bitmap/PictureFormat;", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 16})
      public static final class a
        extends LegacyBitmap
      {
        public final Bitmap a(InputStream paramInputStream, ImageDecodeConfig paramImageDecodeConfig, com.github.henryye.nativeiv.bitmap.c paramc)
        {
          AppMethodBeat.i(228820);
          int j = (int)this.eKg.eKf.NQ();
          int i = (int)this.eKg.eKf.NR();
          if ((paramc == com.github.henryye.nativeiv.bitmap.c.cEF) && (j > 0) && (j > 0))
          {
            if (paramImageDecodeConfig == null) {
              break label195;
            }
            paramInputStream = a.a.a(this.eKg.eKe, paramImageDecodeConfig);
            if ((((Number)paramInputStream.bsC).intValue() <= 0) || (((Number)paramInputStream.bsD).intValue() <= 0)) {
              break label195;
            }
            j = ((Number)paramInputStream.bsC).intValue();
            i = ((Number)paramInputStream.bsD).intValue();
          }
          label195:
          for (;;)
          {
            paramInputStream = Bitmap.createBitmap(j, i, Bitmap.Config.ARGB_8888);
            new Canvas(paramInputStream).drawPicture(this.eKg.eKf.NP(), new RectF(0.0F, 0.0F, j, i));
            s.r(paramInputStream, "bitmap");
            AppMethodBeat.o(228820);
            return paramInputStream;
            paramInputStream = super.a(paramInputStream, paramImageDecodeConfig, paramc);
            s.r(paramInputStream, "super.decodeInputStreamImp(ins, config, format)");
            AppMethodBeat.o(228820);
            return paramInputStream;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.magicbrush.b.a
 * JD-Core Version:    0.7.0.1
 */