package com.tencent.mm.ay.a.f;

import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class c
  implements Runnable
{
  private Bitmap bitmap;
  private String key;
  private b lSk;
  private com.tencent.mm.ay.a.c lSm;
  private String url;
  
  public c(String paramString1, com.tencent.mm.ay.a.c paramc, Bitmap paramBitmap, b paramb, String paramString2)
  {
    this.url = paramString1;
    this.lSm = paramc;
    this.bitmap = paramBitmap;
    this.lSk = paramb;
    this.key = paramString2;
  }
  
  public final void run()
  {
    AppMethodBeat.i(130441);
    if ((!Util.isNullOrNil(this.url)) && (this.lSm != null) && (this.bitmap != null) && (!this.bitmap.isRecycled()) && (this.lSk != null))
    {
      Object localObject1 = this.lSk;
      Object localObject2 = this.lSm;
      localObject1 = (String)((b)localObject1).lRj.get(Integer.valueOf(((com.tencent.mm.ay.a.c)localObject2).kPn));
      if (this.url.equals(localObject1))
      {
        localObject2 = this.lSm;
        localObject1 = this.bitmap;
        if ((Looper.myLooper() == Looper.getMainLooper()) && (((com.tencent.mm.ay.a.c)localObject2).kPl != null))
        {
          localObject2 = (ImageView)((com.tencent.mm.ay.a.c)localObject2).kPl.get();
          if (localObject2 != null) {
            ((ImageView)localObject2).setImageBitmap((Bitmap)localObject1);
          }
        }
        this.lSk.a(this.lSm);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ay.a.f.c
 * JD-Core Version:    0.7.0.1
 */