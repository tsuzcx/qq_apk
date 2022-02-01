package com.tencent.mm.modelimage.loader.e;

import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class c
  implements Runnable
{
  private Bitmap bitmap;
  private String key;
  private b oKW;
  private com.tencent.mm.modelimage.loader.c oKY;
  private String url;
  
  public c(String paramString1, com.tencent.mm.modelimage.loader.c paramc, Bitmap paramBitmap, b paramb, String paramString2)
  {
    this.url = paramString1;
    this.oKY = paramc;
    this.bitmap = paramBitmap;
    this.oKW = paramb;
    this.key = paramString2;
  }
  
  public final void run()
  {
    AppMethodBeat.i(130441);
    if ((!Util.isNullOrNil(this.url)) && (this.oKY != null) && (this.bitmap != null) && (!this.bitmap.isRecycled()) && (this.oKW != null))
    {
      Object localObject1 = this.oKW;
      Object localObject2 = this.oKY;
      localObject1 = (String)((b)localObject1).oJV.get(Integer.valueOf(((com.tencent.mm.modelimage.loader.c)localObject2).nqQ));
      if (this.url.equals(localObject1))
      {
        localObject2 = this.oKY;
        localObject1 = this.bitmap;
        if ((Looper.myLooper() == Looper.getMainLooper()) && (((com.tencent.mm.modelimage.loader.c)localObject2).nqO != null))
        {
          localObject2 = (ImageView)((com.tencent.mm.modelimage.loader.c)localObject2).nqO.get();
          if (localObject2 != null) {
            ((ImageView)localObject2).setImageBitmap((Bitmap)localObject1);
          }
        }
        this.oKW.a(this.oKY);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelimage.loader.e.c
 * JD-Core Version:    0.7.0.1
 */