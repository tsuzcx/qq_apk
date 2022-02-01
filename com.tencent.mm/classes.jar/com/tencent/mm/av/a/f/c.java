package com.tencent.mm.av.a.f;

import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class c
  implements Runnable
{
  private Bitmap bitmap;
  private b jbK;
  private com.tencent.mm.av.a.c jbM;
  private String key;
  private String url;
  
  public c(String paramString1, com.tencent.mm.av.a.c paramc, Bitmap paramBitmap, b paramb, String paramString2)
  {
    this.url = paramString1;
    this.jbM = paramc;
    this.bitmap = paramBitmap;
    this.jbK = paramb;
    this.key = paramString2;
  }
  
  public final void run()
  {
    AppMethodBeat.i(130441);
    if ((!Util.isNullOrNil(this.url)) && (this.jbM != null) && (this.bitmap != null) && (!this.bitmap.isRecycled()) && (this.jbK != null))
    {
      Object localObject1 = this.jbK;
      Object localObject2 = this.jbM;
      localObject1 = (String)((b)localObject1).jaM.get(Integer.valueOf(((com.tencent.mm.av.a.c)localObject2).iaH));
      if (this.url.equals(localObject1))
      {
        localObject2 = this.jbM;
        localObject1 = this.bitmap;
        if ((Looper.myLooper() == Looper.getMainLooper()) && (((com.tencent.mm.av.a.c)localObject2).iaF != null))
        {
          localObject2 = (ImageView)((com.tencent.mm.av.a.c)localObject2).iaF.get();
          if (localObject2 != null) {
            ((ImageView)localObject2).setImageBitmap((Bitmap)localObject1);
          }
        }
        this.jbK.a(this.jbM);
        AppMethodBeat.o(130441);
        return;
      }
      Log.w("MicroMsg.imageloader.ImageShowTask", "[cpan] url is not equals view url.");
      AppMethodBeat.o(130441);
      return;
    }
    Log.w("MicroMsg.imageloader.ImageShowTask", "[cpan] run something is null.");
    AppMethodBeat.o(130441);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.av.a.f.c
 * JD-Core Version:    0.7.0.1
 */