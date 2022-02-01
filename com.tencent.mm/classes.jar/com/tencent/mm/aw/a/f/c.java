package com.tencent.mm.aw.a.f;

import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class c
  implements Runnable
{
  private Bitmap bitmap;
  private b idX;
  private com.tencent.mm.aw.a.c idZ;
  private String key;
  private String url;
  
  public c(String paramString1, com.tencent.mm.aw.a.c paramc, Bitmap paramBitmap, b paramb, String paramString2)
  {
    this.url = paramString1;
    this.idZ = paramc;
    this.bitmap = paramBitmap;
    this.idX = paramb;
    this.key = paramString2;
  }
  
  public final void run()
  {
    AppMethodBeat.i(130441);
    if ((!bt.isNullOrNil(this.url)) && (this.idZ != null) && (this.bitmap != null) && (!this.bitmap.isRecycled()) && (this.idX != null))
    {
      Object localObject1 = this.idX;
      Object localObject2 = this.idZ;
      localObject1 = (String)((b)localObject1).icY.get(Integer.valueOf(((com.tencent.mm.aw.a.c)localObject2).heW));
      if (this.url.equals(localObject1))
      {
        localObject2 = this.idZ;
        localObject1 = this.bitmap;
        if ((Looper.myLooper() == Looper.getMainLooper()) && (((com.tencent.mm.aw.a.c)localObject2).heU != null))
        {
          localObject2 = (ImageView)((com.tencent.mm.aw.a.c)localObject2).heU.get();
          if (localObject2 != null) {
            ((ImageView)localObject2).setImageBitmap((Bitmap)localObject1);
          }
        }
        this.idX.a(this.idZ);
        AppMethodBeat.o(130441);
        return;
      }
      ad.w("MicroMsg.imageloader.ImageShowTask", "[cpan] url is not equals view url.");
      AppMethodBeat.o(130441);
      return;
    }
    ad.w("MicroMsg.imageloader.ImageShowTask", "[cpan] run something is null.");
    AppMethodBeat.o(130441);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.aw.a.f.c
 * JD-Core Version:    0.7.0.1
 */