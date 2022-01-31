package com.tencent.mm.as.a.f;

import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.mm.as.a.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class c
  implements Runnable
{
  private Bitmap bitmap;
  private b erP;
  private com.tencent.mm.as.a.c erR;
  private String key;
  private String url;
  
  public c(String paramString1, com.tencent.mm.as.a.c paramc, Bitmap paramBitmap, b paramb, String paramString2)
  {
    this.url = paramString1;
    this.erR = paramc;
    this.bitmap = paramBitmap;
    this.erP = paramb;
    this.key = paramString2;
  }
  
  public final void run()
  {
    if ((!bk.bl(this.url)) && (this.erR != null) && (this.bitmap != null) && (!this.bitmap.isRecycled()) && (this.erP != null))
    {
      Object localObject1 = this.erP;
      Object localObject2 = this.erR;
      localObject1 = (String)((b)localObject1).eqB.get(Integer.valueOf(((com.tencent.mm.as.a.c)localObject2).eqE));
      if (this.url.equals(localObject1))
      {
        localObject2 = this.erR;
        localObject1 = this.bitmap;
        if ((Looper.myLooper() == Looper.getMainLooper()) && (((com.tencent.mm.as.a.c)localObject2).eqD != null))
        {
          localObject2 = (ImageView)((com.tencent.mm.as.a.c)localObject2).eqD.get();
          if (localObject2 != null) {
            ((ImageView)localObject2).setImageBitmap((Bitmap)localObject1);
          }
        }
        this.erP.a(this.erR);
        return;
      }
      y.w("MicroMsg.imageloader.ImageShowTask", "[cpan] url is not equals view url.");
      return;
    }
    y.w("MicroMsg.imageloader.ImageShowTask", "[cpan] run something is null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.as.a.f.c
 * JD-Core Version:    0.7.0.1
 */