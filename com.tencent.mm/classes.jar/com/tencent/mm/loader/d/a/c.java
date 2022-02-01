package com.tencent.mm.loader.d.a;

import android.graphics.Bitmap;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.loader.d.b.g;
import com.tencent.mm.loader.f;
import com.tencent.mm.loader.g.b.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/impr/imageproducer/InputStreamBitmapProducer;", "Lcom/tencent/mm/loader/impr/imageproducer/ImageBitmapProducer;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "asResource", "Lcom/tencent/mm/loader/model/Resource;", "Landroid/graphics/Bitmap;", "targetView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "input", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
public class c
  extends b
{
  private String TAG = "MicroMsg.Loader.InputStreamBitmapProducer";
  
  public com.tencent.mm.loader.g.e<Bitmap> a(g<?> paramg, f<?, Bitmap> paramf, a parama)
  {
    s.u(paramg, "targetView");
    s.u(paramf, "reaper");
    s.u(parama, "input");
    InputStream localInputStream = parama.bmk();
    com.tencent.mm.ae.c localc = new com.tencent.mm.ae.c("InputStreamBitmapProducer");
    int i;
    int j;
    if (localInputStream != null)
    {
      i = paramf.nou.npU;
      j = paramf.nou.npV;
      if ((i <= 0) || (j <= 0)) {
        if ((paramg != null) && (paramg.width > 0) && (paramg.width > 0)) {
          paramg = BitmapUtil.getBitmapNative(localInputStream, paramg.width, paramg.height);
        }
      }
    }
    for (;;)
    {
      paramf = paramg;
      if (localInputStream != null)
      {
        localInputStream.reset();
        i = Exif.fromStream(localInputStream).getOrientationInDegree();
        Log.i(this.TAG, "read exif rotate degree %d", new Object[] { Integer.valueOf(i) });
        paramf = BitmapUtil.rotate(paramg, i * 1.0F);
      }
      paramg = ah.aiuX;
      localc.bbW();
      Log.i(this.TAG, "InputStreamBitmapProducer decode bitmap done " + paramf + " from input " + parama);
      return new com.tencent.mm.loader.g.e(paramf);
      paramg = BitmapUtil.getBitmapNative(localInputStream);
      continue;
      paramg = BitmapUtil.decodeStream(localInputStream, 0.0F, j, i);
      continue;
      paramg = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.d.a.c
 * JD-Core Version:    0.7.0.1
 */