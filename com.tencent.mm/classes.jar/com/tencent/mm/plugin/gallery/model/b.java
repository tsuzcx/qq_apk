package com.tencent.mm.plugin.gallery.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import com.tencent.mm.a.f;
import com.tencent.mm.a.f.b;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.Vector;

public final class b
{
  k<b.b, String> ebu = new k() {};
  public Vector<b.b> ebv = new Vector();
  f<String, b.a> kGs = new f(100, new f.b() {});
  d kGt;
  private final b.b kGu = new b.b()
  {
    public final void Eo(String paramAnonymousString)
    {
      y.i("MicroMsg.GalleryCache", "now listener size : " + b.this.ebv.size());
      int i = b.this.ebv.size() - 1;
      for (;;)
      {
        if (i >= 0) {
          try
          {
            b.b localb = (b.b)b.this.ebv.get(i);
            if (localb == null)
            {
              y.d("MicroMsg.GalleryCache", "get listener is null");
              i -= 1;
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              y.e("MicroMsg.GalleryCache", "get wathcer failed:[%s]", new Object[] { localException.toString() });
              Object localObject = null;
              continue;
              localObject.Eo(paramAnonymousString);
            }
          }
        }
      }
    }
  };
  
  public b()
  {
    d locald = new d(new File(e.bkH + "/diskcache"));
    locald.kGM = ae.getContext().getSharedPreferences(ae.cqR(), 0).getInt("com.tencent.mm.gallery.cache.suffix", 0);
    locald.aXj();
    locald.rJ(-1);
    this.kGt = locald;
    this.ebu.a(this.kGu, null);
  }
  
  public final Bitmap getBitmap(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.GalleryCache", "null filepath");
      return null;
    }
    if (this.kGs == null)
    {
      y.w("MicroMsg.GalleryCache", "want to get bitmap, but gallery cache is null");
      return null;
    }
    if (this.kGs.aC(paramString))
    {
      Object localObject = (b.a)this.kGs.get(paramString);
      if (localObject == null)
      {
        y.d("MicroMsg.GalleryCache", "weakreference is null");
        this.kGs.remove(paramString);
        return null;
      }
      localObject = ((b.a)localObject).bitmap;
      if (localObject != null)
      {
        if (((Bitmap)localObject).isRecycled())
        {
          y.i("MicroMsg.GalleryCache", "cahce bitmap has recycled");
          this.kGs.remove(paramString);
          return null;
        }
        y.i("MicroMsg.GalleryCache", "get cached bitmap:" + paramString);
        return localObject;
      }
      this.kGs.remove(paramString);
      y.i("MicroMsg.GalleryCache", "get bitmap is null");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.b
 * JD-Core Version:    0.7.0.1
 */