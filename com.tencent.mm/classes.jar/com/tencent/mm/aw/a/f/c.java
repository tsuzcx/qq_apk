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
  private com.tencent.mm.aw.a.c hkB;
  private b hkz;
  private String key;
  private String url;
  
  public c(String paramString1, com.tencent.mm.aw.a.c paramc, Bitmap paramBitmap, b paramb, String paramString2)
  {
    this.url = paramString1;
    this.hkB = paramc;
    this.bitmap = paramBitmap;
    this.hkz = paramb;
    this.key = paramString2;
  }
  
  public final void run()
  {
    AppMethodBeat.i(130441);
    if ((!bt.isNullOrNil(this.url)) && (this.hkB != null) && (this.bitmap != null) && (!this.bitmap.isRecycled()) && (this.hkz != null))
    {
      Object localObject1 = this.hkz;
      Object localObject2 = this.hkB;
      localObject1 = (String)((b)localObject1).hjB.get(Integer.valueOf(((com.tencent.mm.aw.a.c)localObject2).gku));
      if (this.url.equals(localObject1))
      {
        localObject2 = this.hkB;
        localObject1 = this.bitmap;
        if ((Looper.myLooper() == Looper.getMainLooper()) && (((com.tencent.mm.aw.a.c)localObject2).gks != null))
        {
          localObject2 = (ImageView)((com.tencent.mm.aw.a.c)localObject2).gks.get();
          if (localObject2 != null) {
            ((ImageView)localObject2).setImageBitmap((Bitmap)localObject1);
          }
        }
        this.hkz.a(this.hkB);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.aw.a.f.c
 * JD-Core Version:    0.7.0.1
 */