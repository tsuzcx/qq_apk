package com.tencent.mm.cache;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.y.d.a;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

public final class h
  implements e<com.tencent.mm.y.d>
{
  private SparseArray<String> ecA;
  private HashMap<String, Bitmap> ecB;
  private Stack<com.tencent.mm.y.d> ecq;
  private Stack<com.tencent.mm.y.d> ecr;
  public int ect;
  
  public final void CH()
  {
    this.ect += 1;
  }
  
  public final void Jd()
  {
    AppMethodBeat.i(116255);
    ab.i("MicroMsg.MosaicCache", "[onRestore] size:%s", new Object[] { Integer.valueOf(this.ecq.size()) });
    this.ecq.clear();
    if (this.ecr != null)
    {
      ab.i("MicroMsg.MosaicCache", "[onRestore] %s", new Object[] { Integer.valueOf(this.ecr.size()) });
      this.ecq.addAll(this.ecr);
    }
    AppMethodBeat.o(116255);
  }
  
  public final Bitmap Jl()
  {
    AppMethodBeat.i(116259);
    String str = (String)this.ecA.get(ad(true));
    if (bo.isNullOrNil(str))
    {
      ab.w("MicroMsg.MosaicCache", "[getCacheFromLocal] path is null");
      AppMethodBeat.o(116259);
      return null;
    }
    ab.i("MicroMsg.MosaicCache", "[getCacheFromLocal] path:%s size:%s", new Object[] { str, Integer.valueOf(ad(true)) });
    if (this.ecB.containsKey(str)) {}
    for (Bitmap localBitmap1 = (Bitmap)this.ecB.get(str);; localBitmap1 = null)
    {
      Bitmap localBitmap2;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (!localBitmap1.isRecycled()) {}
      }
      else
      {
        ab.i("MicroMsg.MosaicCache", "");
        localBitmap2 = com.tencent.mm.sdk.platformtools.d.aoV(str);
        ab.i("MicroMsg.MosaicCache", "[getCacheFromLocal] get from local!");
      }
      if (localBitmap2 == null)
      {
        ab.e("MicroMsg.MosaicCache", "[getCacheFromLocal] null == bitmap path:%s", new Object[] { str });
        AppMethodBeat.o(116259);
        return null;
      }
      localBitmap1 = localBitmap2.copy(Bitmap.Config.ARGB_8888, true);
      ab.i("MicroMsg.MosaicCache", "bitmap recycle %s", new Object[] { localBitmap2 });
      localBitmap2.recycle();
      AppMethodBeat.o(116259);
      return localBitmap1;
    }
  }
  
  public final void a(Canvas paramCanvas, boolean paramBoolean)
  {
    AppMethodBeat.i(116256);
    if (!paramBoolean) {
      if ((this.ecq == null) || (this.ecq.size() <= 0)) {
        break label62;
      }
    }
    label62:
    for (com.tencent.mm.y.d locald = (com.tencent.mm.y.d)this.ecq.peek();; locald = null)
    {
      if ((locald != null) && (locald.cek == d.a.eFI)) {
        locald.draw(paramCanvas);
      }
      AppMethodBeat.o(116256);
      return;
    }
  }
  
  public final void a(com.tencent.mm.y.d paramd)
  {
    AppMethodBeat.i(116260);
    if (this.ecq != null) {
      this.ecq.push(paramd);
    }
    AppMethodBeat.o(116260);
  }
  
  public final int ad(boolean paramBoolean)
  {
    AppMethodBeat.i(116261);
    int i;
    if (paramBoolean)
    {
      if (this.ecq != null)
      {
        i = this.ecq.size();
        AppMethodBeat.o(116261);
        return i;
      }
      AppMethodBeat.o(116261);
      return 0;
    }
    if (this.ecr != null)
    {
      i = this.ecr.size();
      AppMethodBeat.o(116261);
      return i;
    }
    AppMethodBeat.o(116261);
    return 0;
  }
  
  public final void bH(boolean paramBoolean)
  {
    AppMethodBeat.i(116254);
    ab.i("MicroMsg.MosaicCache", "[onSave] size:%s", new Object[] { Integer.valueOf(this.ecq.size()) });
    if (this.ecr != null) {
      this.ecr.clear();
    }
    this.ecr = ((Stack)this.ecq.clone());
    if (paramBoolean) {
      this.ecq.clear();
    }
    AppMethodBeat.o(116254);
  }
  
  public final void c(Canvas paramCanvas)
  {
    AppMethodBeat.i(116257);
    Bitmap localBitmap = Jl();
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, null);
    }
    AppMethodBeat.o(116257);
  }
  
  public final void m(final Bitmap paramBitmap)
  {
    AppMethodBeat.i(116258);
    paramBitmap = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
    final String str1 = com.tencent.mm.cl.a.avz(com.tencent.mm.e.a.ccN.toString());
    ab.i("MicroMsg.MosaicCache", "[saveCacheToLocal] path:%s size:%s", new Object[] { str1, Integer.valueOf(ad(true)) });
    String str2 = (String)this.ecA.get(ad(true));
    if (!bo.isNullOrNil(str2))
    {
      com.tencent.mm.vfs.e.deleteFile(str2);
      this.ecA.remove(ad(true));
    }
    this.ecA.put(ad(true), str1);
    this.ecB.put(str1, paramBitmap);
    com.tencent.mm.sdk.g.d.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(116251);
        try
        {
          com.tencent.mm.sdk.platformtools.d.a(paramBitmap, 50, Bitmap.CompressFormat.PNG, str1, true);
          AppMethodBeat.o(116251);
          return;
        }
        catch (IOException localIOException)
        {
          ab.printErrStackTrace("MicroMsg.MosaicCache", localIOException, "", new Object[0]);
          AppMethodBeat.o(116251);
        }
      }
    }, "[saveCacheToLocal] mosaic path:".concat(String.valueOf(str1)));
    AppMethodBeat.o(116258);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(116252);
    ab.i("MicroMsg.MosaicCache", "[onCreate]");
    this.ecq = new Stack();
    this.ecA = new SparseArray();
    this.ecB = new HashMap();
    AppMethodBeat.o(116252);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(116253);
    if (this.ecq != null)
    {
      localIterator = this.ecq.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.ecq.clear();
    }
    if (this.ecr != null)
    {
      localIterator = this.ecr.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.ecr.clear();
    }
    this.ecA.clear();
    Iterator localIterator = this.ecB.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Bitmap localBitmap = (Bitmap)((Map.Entry)localIterator.next()).getValue();
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        ab.i("MicroMsg.MosaicCache", "bitmap recycle %s", new Object[] { localBitmap.toString() });
        localBitmap.recycle();
      }
    }
    this.ecB.clear();
    AppMethodBeat.o(116253);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.cache.h
 * JD-Core Version:    0.7.0.1
 */