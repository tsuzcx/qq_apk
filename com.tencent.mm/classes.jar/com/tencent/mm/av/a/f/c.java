package com.tencent.mm.av.a.f;

import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class c
  implements Runnable
{
  private Bitmap bitmap;
  private b igP;
  private com.tencent.mm.av.a.c igR;
  private String key;
  private String url;
  
  public c(String paramString1, com.tencent.mm.av.a.c paramc, Bitmap paramBitmap, b paramb, String paramString2)
  {
    this.url = paramString1;
    this.igR = paramc;
    this.bitmap = paramBitmap;
    this.igP = paramb;
    this.key = paramString2;
  }
  
  public final void run()
  {
    AppMethodBeat.i(130441);
    if ((!bu.isNullOrNil(this.url)) && (this.igR != null) && (this.bitmap != null) && (!this.bitmap.isRecycled()) && (this.igP != null))
    {
      Object localObject1 = this.igP;
      Object localObject2 = this.igR;
      localObject1 = (String)((b)localObject1).ifR.get(Integer.valueOf(((com.tencent.mm.av.a.c)localObject2).hhK));
      if (this.url.equals(localObject1))
      {
        localObject2 = this.igR;
        localObject1 = this.bitmap;
        if ((Looper.myLooper() == Looper.getMainLooper()) && (((com.tencent.mm.av.a.c)localObject2).hhI != null))
        {
          localObject2 = (ImageView)((com.tencent.mm.av.a.c)localObject2).hhI.get();
          if (localObject2 != null) {
            ((ImageView)localObject2).setImageBitmap((Bitmap)localObject1);
          }
        }
        this.igP.a(this.igR);
        AppMethodBeat.o(130441);
        return;
      }
      ae.w("MicroMsg.imageloader.ImageShowTask", "[cpan] url is not equals view url.");
      AppMethodBeat.o(130441);
      return;
    }
    ae.w("MicroMsg.imageloader.ImageShowTask", "[cpan] run something is null.");
    AppMethodBeat.o(130441);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.av.a.f.c
 * JD-Core Version:    0.7.0.1
 */