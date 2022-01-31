package com.tencent.mm.cache;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.z.d.a;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

public final class g
  implements d<com.tencent.mm.z.d>
{
  private Stack<com.tencent.mm.z.d> dkW;
  private Stack<com.tencent.mm.z.d> dkX;
  public int dkZ;
  public SparseArray<String> dle;
  public HashMap<String, Bitmap> dlf;
  
  public final void a(Canvas paramCanvas, boolean paramBoolean)
  {
    if (!paramBoolean) {
      if ((this.dkW == null) || (this.dkW.size() <= 0)) {
        break label52;
      }
    }
    label52:
    for (com.tencent.mm.z.d locald = (com.tencent.mm.z.d)this.dkW.peek();; locald = null)
    {
      if ((locald != null) && (locald.bBn == d.a.dIe)) {
        locald.draw(paramCanvas);
      }
      return;
    }
  }
  
  public final void a(com.tencent.mm.z.d paramd)
  {
    if (this.dkW != null) {
      this.dkW.push(paramd);
    }
  }
  
  public final void bf(boolean paramBoolean)
  {
    y.i("MicroMsg.MosaicCache", "[onSave] size:%s", new Object[] { Integer.valueOf(this.dkW.size()) });
    if (this.dkX != null) {
      this.dkX.clear();
    }
    this.dkX = ((Stack)this.dkW.clone());
    if (paramBoolean) {
      this.dkW.clear();
    }
  }
  
  public final int bg(boolean paramBoolean)
  {
    int i = 0;
    if (paramBoolean) {
      if (this.dkW != null) {
        i = this.dkW.size();
      }
    }
    while (this.dkX == null) {
      return i;
    }
    return this.dkX.size();
  }
  
  public final void c(Canvas paramCanvas)
  {
    Bitmap localBitmap = wU();
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, null);
    }
  }
  
  public final void onCreate()
  {
    y.i("MicroMsg.MosaicCache", "[onCreate]");
    this.dkW = new Stack();
    this.dle = new SparseArray();
    this.dlf = new HashMap();
  }
  
  public final void onDestroy()
  {
    if (this.dkW != null)
    {
      localIterator = this.dkW.iterator();
      while (localIterator.hasNext())
      {
        localIterator.next();
        com.tencent.mm.z.d.clear();
      }
      this.dkW.clear();
    }
    if (this.dkX != null)
    {
      localIterator = this.dkX.iterator();
      while (localIterator.hasNext())
      {
        localIterator.next();
        com.tencent.mm.z.d.clear();
      }
      this.dkX.clear();
    }
    this.dle.clear();
    Iterator localIterator = this.dlf.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Bitmap localBitmap = (Bitmap)((Map.Entry)localIterator.next()).getValue();
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        localBitmap.recycle();
      }
    }
    this.dlf.clear();
  }
  
  public final void tP()
  {
    this.dkZ += 1;
  }
  
  public final void wN()
  {
    y.i("MicroMsg.MosaicCache", "[onRestore] size:%s", new Object[] { Integer.valueOf(this.dkW.size()) });
    this.dkW.clear();
    if (this.dkX != null)
    {
      y.i("MicroMsg.MosaicCache", "[onRestore] %s", new Object[] { Integer.valueOf(this.dkX.size()) });
      this.dkW.addAll(this.dkX);
    }
  }
  
  public final Bitmap wU()
  {
    String str = (String)this.dle.get(bg(true));
    if (bk.bl(str))
    {
      y.w("MicroMsg.MosaicCache", "[getCacheFromLocal] path is null");
      return null;
    }
    y.i("MicroMsg.MosaicCache", "[getCacheFromLocal] path:%s size:%s", new Object[] { str, Integer.valueOf(bg(true)) });
    if (this.dlf.containsKey(str)) {}
    for (Bitmap localBitmap1 = (Bitmap)this.dlf.get(str);; localBitmap1 = null)
    {
      Bitmap localBitmap2;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (!localBitmap1.isRecycled()) {}
      }
      else
      {
        y.i("MicroMsg.MosaicCache", "");
        localBitmap2 = c.YW(str);
        y.i("MicroMsg.MosaicCache", "[getCacheFromLocal] get from local!");
      }
      if (localBitmap2 == null)
      {
        y.e("MicroMsg.MosaicCache", "[getCacheFromLocal] null == bitmap path:%s", new Object[] { str });
        return null;
      }
      localBitmap1 = localBitmap2.copy(Bitmap.Config.ARGB_8888, true);
      localBitmap2.recycle();
      return localBitmap1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.cache.g
 * JD-Core Version:    0.7.0.1
 */