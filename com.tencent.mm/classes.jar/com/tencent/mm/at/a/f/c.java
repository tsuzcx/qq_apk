package com.tencent.mm.at.a.f;

import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class c
  implements Runnable
{
  private Bitmap bitmap;
  private b fHE;
  private com.tencent.mm.at.a.c fHG;
  private String key;
  private String url;
  
  public c(String paramString1, com.tencent.mm.at.a.c paramc, Bitmap paramBitmap, b paramb, String paramString2)
  {
    this.url = paramString1;
    this.fHG = paramc;
    this.bitmap = paramBitmap;
    this.fHE = paramb;
    this.key = paramString2;
  }
  
  public final void run()
  {
    AppMethodBeat.i(116112);
    if ((!bo.isNullOrNil(this.url)) && (this.fHG != null) && (this.bitmap != null) && (!this.bitmap.isRecycled()) && (this.fHE != null))
    {
      Object localObject1 = this.fHE;
      Object localObject2 = this.fHG;
      localObject1 = (String)((b)localObject1).fHc.get(Integer.valueOf(((com.tencent.mm.at.a.c)localObject2).eOR));
      if (this.url.equals(localObject1))
      {
        localObject2 = this.fHG;
        localObject1 = this.bitmap;
        if ((Looper.myLooper() == Looper.getMainLooper()) && (((com.tencent.mm.at.a.c)localObject2).eOP != null))
        {
          localObject2 = (ImageView)((com.tencent.mm.at.a.c)localObject2).eOP.get();
          if (localObject2 != null) {
            ((ImageView)localObject2).setImageBitmap((Bitmap)localObject1);
          }
        }
        this.fHE.a(this.fHG);
        AppMethodBeat.o(116112);
        return;
      }
      ab.w("MicroMsg.imageloader.ImageShowTask", "[cpan] url is not equals view url.");
      AppMethodBeat.o(116112);
      return;
    }
    ab.w("MicroMsg.imageloader.ImageShowTask", "[cpan] run something is null.");
    AppMethodBeat.o(116112);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.at.a.f.c
 * JD-Core Version:    0.7.0.1
 */