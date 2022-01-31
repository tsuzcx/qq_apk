package com.tencent.mm.plugin.gallery.model;

import android.graphics.Bitmap;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Vector;

public final class a
{
  private static final int kGh;
  private volatile boolean isDecoding = false;
  public b kGi = new b();
  private a.a kGj = new a.a(this, (byte)0);
  private f<String> kGk = new f();
  private f<a.b> kGl = new f();
  
  static
  {
    if (d.gG(14)) {}
    for (int i = 20;; i = 30)
    {
      kGh = i;
      return;
    }
  }
  
  private void aWY()
  {
    if (this.isDecoding) {
      y.w("MircoMsg.CacheService", "is decoding now, wait a minute");
    }
    do
    {
      return;
      if ((this.kGl != null) && (this.kGl.size() > 0))
      {
        this.isDecoding = true;
        Object localObject2 = (a.b)this.kGl.aXu();
        if (localObject2 == null)
        {
          y.e("MircoMsg.CacheService", "obj is null");
          this.isDecoding = false;
          break;
        }
        a.a locala = this.kGj;
        if (c.aXc() == null)
        {
          y.w("MircoMsg.CacheService", "add thread object, but worker thread is null");
          return;
        }
        Object localObject1 = c.aXc();
        localObject2 = new a.a.1(locala, (av.a)localObject2);
        localObject1 = ((e)localObject1).aXo();
        if (localObject1 == null)
        {
          y.e("MicroMsg.GalleryHandlerThread", "post at front of queue, but decode handler is null");
          return;
        }
        y.i("MicroMsg.GalleryHandlerThread", "postAtFrontOfQueue:[%b]", new Object[] { Boolean.valueOf(((ah)localObject1).postAtFrontOfQueueV2((Runnable)localObject2)) });
        return;
      }
      y.i("MircoMsg.CacheService", "all job empty");
    } while (c.aXc() == null);
    c.aXc().K(new a.1(this));
  }
  
  public final Bitmap En(String paramString)
  {
    if (bk.bl(paramString)) {
      y.w("MircoMsg.CacheService", "file path is null");
    }
    Bitmap localBitmap;
    do
    {
      return null;
      localBitmap = this.kGi.getBitmap(paramString);
    } while (localBitmap == null);
    y.v("MircoMsg.CacheService", "get bitmap from cache: %s", new Object[] { paramString });
    return localBitmap;
  }
  
  public final void a(b.b paramb)
  {
    b localb = this.kGi;
    if (localb.ebv.size() > 64) {
      y.i("MicroMsg.GalleryCache", "has exceed the max listener size[%d], remove some listeners[%s]", new Object[] { Integer.valueOf(64), (b.b)localb.ebv.remove(0) });
    }
    y.v("MicroMsg.GalleryCache", "try add listener[%s]", new Object[] { paramb });
    if (!localb.ebv.contains(paramb))
    {
      y.d("MicroMsg.GalleryCache", "add listener[%s] ok", new Object[] { paramb });
      localb.ebv.add(paramb);
    }
  }
  
  public final Bitmap b(String paramString1, int paramInt, String paramString2, long paramLong)
  {
    if (bk.bl(paramString1))
    {
      y.w("MircoMsg.CacheService", "file path is null");
      return null;
    }
    Object localObject = this.kGi.getBitmap(paramString1);
    if (localObject != null)
    {
      y.v("MircoMsg.CacheService", "get bitmap from cache: %s", new Object[] { paramString1 });
      return localObject;
    }
    y.v("MircoMsg.CacheService", "filePathInService size is : [%d]", new Object[] { Integer.valueOf(this.kGk.size()) });
    if (this.kGk.aC(paramString1))
    {
      y.w("MircoMsg.CacheService", "has already getting bitmap from file, %s", new Object[] { paramString1 });
      aWY();
      return null;
    }
    if (this.kGk.size() > kGh)
    {
      y.w("MircoMsg.CacheService", "the running task has exceed 40, remove the first one");
      y.w("MircoMsg.CacheService", "filePathInService size: [%d], waitingDecodeTask size:[%d]", new Object[] { Integer.valueOf(this.kGk.size()), Integer.valueOf(this.kGl.size()) });
      if (!this.kGl.isEmpty())
      {
        localObject = (a.b)this.kGl.aXu();
        if (localObject != null)
        {
          localObject = ((a.b)localObject).mFilePath;
          this.kGk.bn(localObject);
        }
      }
    }
    this.kGk.add(paramString1);
    this.kGl.add(new a.b(this, paramString1, paramInt, paramString2, paramLong));
    aWY();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.a
 * JD-Core Version:    0.7.0.1
 */