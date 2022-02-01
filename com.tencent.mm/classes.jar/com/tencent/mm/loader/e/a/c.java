package com.tencent.mm.loader.e.a;

import android.graphics.Bitmap;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.loader.f;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.InputStream;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/loader/impr/imageproducer/InputStreamBitmapProducer;", "Lcom/tencent/mm/loader/impr/imageproducer/ImageBitmapProducer;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "asResource", "Lcom/tencent/mm/loader/model/Resource;", "Landroid/graphics/Bitmap;", "targetView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "input", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "libimageloader_release"})
public class c
  extends b
{
  private String TAG = "MicroMsg.Loader.InputStreamBitmapProducer";
  
  public com.tencent.mm.loader.h.e<Bitmap> a(g<?> paramg, f<?, Bitmap> paramf, com.tencent.mm.loader.h.b.a parama)
  {
    p.h(paramg, "targetView");
    p.h(paramf, "reaper");
    p.h(parama, "input");
    InputStream localInputStream = parama.aKu();
    com.tencent.mm.ac.c localc = new com.tencent.mm.ac.c("InputStreamBitmapProducer");
    if (localInputStream != null) {}
    for (paramg = com.tencent.mm.loader.l.a.a(paramg, localInputStream, paramf.hXX.hZz, paramf.hXX.hZA);; paramg = null)
    {
      paramf = paramg;
      if (localInputStream != null)
      {
        localInputStream.reset();
        paramf = Exif.fromStream(localInputStream);
        p.g(paramf, "Exif.fromStream(inputStream)");
        int i = paramf.getOrientationInDegree();
        Log.i(this.TAG, "read exif rotate degree %d", new Object[] { Integer.valueOf(i) });
        paramf = BitmapUtil.rotate(paramg, i * 1.0F);
      }
      paramg = x.SXb;
      localc.aBw();
      Log.i(this.TAG, "InputStreamBitmapProducer decode bitmap done " + paramf + " from input " + parama);
      return new com.tencent.mm.loader.h.e(paramf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.e.a.c
 * JD-Core Version:    0.7.0.1
 */