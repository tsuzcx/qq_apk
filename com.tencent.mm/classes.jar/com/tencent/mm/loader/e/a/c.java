package com.tencent.mm.loader.e.a;

import a.f.b.j;
import a.l;
import a.y;
import android.graphics.Bitmap;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.loader.f;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.InputStream;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/loader/impr/imageproducer/InputStreamBitmapProducer;", "Lcom/tencent/mm/loader/impr/imageproducer/ImageBitmapProducer;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "asResource", "Lcom/tencent/mm/loader/model/Resource;", "Landroid/graphics/Bitmap;", "targetView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "input", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "libimageloader_release"})
public class c
  extends b
{
  private String TAG = "MicroMsg.Loader.InputStreamBitmapProducer";
  
  public com.tencent.mm.loader.h.e<Bitmap> a(g<?> paramg, f<?, Bitmap> paramf, com.tencent.mm.loader.h.b.a parama)
  {
    j.q(paramg, "targetView");
    j.q(paramf, "reaper");
    j.q(parama, "input");
    InputStream localInputStream = parama.Uh();
    boolean bool = paramf.eMG.TA();
    String str = paramf.eMG.TB();
    com.tencent.mm.ab.a locala = new com.tencent.mm.ab.a("InputStreamBitmapProducer");
    ab.d(this.TAG, "hy: should check md5:".concat(String.valueOf(bool)));
    if (localInputStream != null) {
      if (bool)
      {
        com.tencent.mm.loader.d.c localc = paramf.eMN;
        if ((localc == null) || (localc.b(str, localInputStream) != true)) {
          break label198;
        }
      }
    }
    label198:
    for (paramg = com.tencent.mm.loader.l.a.a(paramg, localInputStream, paramf.eMG.Tw(), paramf.eMG.Tx(), paramf.eMG.TE(), paramf.eMG.getAlpha(), paramf.eMG.Ty());; paramg = null)
    {
      paramf = y.BMg;
      locala.SS();
      ab.i(this.TAG, "InputStreamBitmapProducer decode bitmap done " + paramg + " from input " + parama);
      return new com.tencent.mm.loader.h.e(paramg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.e.a.c
 * JD-Core Version:    0.7.0.1
 */