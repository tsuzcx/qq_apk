package com.tencent.mm.loader.e.a;

import android.graphics.Bitmap;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import d.y;
import java.io.InputStream;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/loader/impr/imageproducer/InputStreamBitmapProducer;", "Lcom/tencent/mm/loader/impr/imageproducer/ImageBitmapProducer;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "asResource", "Lcom/tencent/mm/loader/model/Resource;", "Landroid/graphics/Bitmap;", "targetView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "input", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "libimageloader_release"})
public class c
  extends b
{
  private String TAG = "MicroMsg.Loader.InputStreamBitmapProducer";
  
  public com.tencent.mm.loader.h.e<Bitmap> a(g<?> paramg, com.tencent.mm.loader.f<?, Bitmap> paramf, com.tencent.mm.loader.h.b.a parama)
  {
    k.h(paramg, "targetView");
    k.h(paramf, "reaper");
    k.h(parama, "input");
    InputStream localInputStream = parama.ahS();
    com.tencent.mm.ad.b localb = new com.tencent.mm.ad.b("InputStreamBitmapProducer");
    if (localInputStream != null) {}
    for (paramg = com.tencent.mm.loader.l.a.a(paramg, localInputStream, paramf.ghW.gjv, paramf.ghW.gjw);; paramg = null)
    {
      paramf = paramg;
      if (localInputStream != null)
      {
        localInputStream.reset();
        paramf = Exif.fromStream(localInputStream);
        k.g(paramf, "Exif.fromStream(inputStream)");
        int i = paramf.getOrientationInDegree();
        ad.i(this.TAG, "read exif rotate degree %d", new Object[] { Integer.valueOf(i) });
        paramf = com.tencent.mm.sdk.platformtools.f.a(paramg, i * 1.0F);
      }
      paramg = y.JfV;
      localb.agL();
      ad.i(this.TAG, "InputStreamBitmapProducer decode bitmap done " + paramf + " from input " + parama);
      return new com.tencent.mm.loader.h.e(paramf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.e.a.c
 * JD-Core Version:    0.7.0.1
 */