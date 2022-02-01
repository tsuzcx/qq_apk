package com.tencent.mm.cache;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.e;
import com.tencent.mm.aa.e.a;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.g;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

public final class i
  implements f<e>
{
  private Stack<e> fIe;
  private Stack<e> fIf;
  public int fIh;
  private SparseArray<String> fIr;
  private HashMap<String, Bitmap> fIs;
  
  public final void NQ()
  {
    this.fIh += 1;
  }
  
  public final void XF()
  {
    AppMethodBeat.i(9231);
    ad.i("MicroMsg.MosaicCache", "[onRestore] size:%s", new Object[] { Integer.valueOf(this.fIe.size()) });
    this.fIe.clear();
    if (this.fIf != null)
    {
      ad.i("MicroMsg.MosaicCache", "[onRestore] %s", new Object[] { Integer.valueOf(this.fIf.size()) });
      this.fIe.addAll(this.fIf);
    }
    AppMethodBeat.o(9231);
  }
  
  public final Bitmap XN()
  {
    AppMethodBeat.i(9235);
    String str = (String)this.fIr.get(aj(true));
    if (bt.isNullOrNil(str))
    {
      ad.w("MicroMsg.MosaicCache", "[getCacheFromLocal] path is null");
      AppMethodBeat.o(9235);
      return null;
    }
    ad.i("MicroMsg.MosaicCache", "[getCacheFromLocal] path:%s size:%s", new Object[] { str, Integer.valueOf(aj(true)) });
    if (this.fIs.containsKey(str)) {}
    for (Bitmap localBitmap1 = (Bitmap)this.fIs.get(str);; localBitmap1 = null)
    {
      Bitmap localBitmap2;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (!localBitmap1.isRecycled()) {}
      }
      else
      {
        ad.i("MicroMsg.MosaicCache", "");
        localBitmap2 = g.aQf(str);
        ad.i("MicroMsg.MosaicCache", "[getCacheFromLocal] get from local!");
      }
      if (localBitmap2 == null)
      {
        ad.e("MicroMsg.MosaicCache", "[getCacheFromLocal] null == bitmap path:%s", new Object[] { str });
        AppMethodBeat.o(9235);
        return null;
      }
      localBitmap1 = localBitmap2.copy(Bitmap.Config.ARGB_8888, true);
      ad.i("MicroMsg.MosaicCache", "bitmap recycle %s", new Object[] { localBitmap2 });
      localBitmap2.recycle();
      AppMethodBeat.o(9235);
      return localBitmap1;
    }
  }
  
  public final void a(Canvas paramCanvas, boolean paramBoolean)
  {
    AppMethodBeat.i(9232);
    if (!paramBoolean) {
      if ((this.fIe == null) || (this.fIe.size() <= 0)) {
        break label64;
      }
    }
    label64:
    for (e locale = (e)this.fIe.peek();; locale = null)
    {
      if ((locale != null) && (locale.dbF == e.a.gzg)) {
        locale.draw(paramCanvas);
      }
      AppMethodBeat.o(9232);
      return;
    }
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(9236);
    if (this.fIe != null) {
      this.fIe.push(parame);
    }
    AppMethodBeat.o(9236);
  }
  
  public final int aj(boolean paramBoolean)
  {
    AppMethodBeat.i(9237);
    int i;
    if (paramBoolean)
    {
      if (this.fIe != null)
      {
        i = this.fIe.size();
        AppMethodBeat.o(9237);
        return i;
      }
      AppMethodBeat.o(9237);
      return 0;
    }
    if (this.fIf != null)
    {
      i = this.fIf.size();
      AppMethodBeat.o(9237);
      return i;
    }
    AppMethodBeat.o(9237);
    return 0;
  }
  
  public final void cC(boolean paramBoolean)
  {
    AppMethodBeat.i(9230);
    ad.i("MicroMsg.MosaicCache", "[onSave] size:%s", new Object[] { Integer.valueOf(this.fIe.size()) });
    if (this.fIf != null) {
      this.fIf.clear();
    }
    this.fIf = ((Stack)this.fIe.clone());
    if (paramBoolean) {
      this.fIe.clear();
    }
    AppMethodBeat.o(9230);
  }
  
  public final void e(Canvas paramCanvas)
  {
    AppMethodBeat.i(9233);
    Bitmap localBitmap = XN();
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, null);
    }
    AppMethodBeat.o(9233);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(9228);
    ad.i("MicroMsg.MosaicCache", "[onCreate]");
    this.fIe = new Stack();
    this.fIr = new SparseArray();
    this.fIs = new HashMap();
    AppMethodBeat.o(9228);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9229);
    if (this.fIe != null)
    {
      localIterator = this.fIe.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.fIe.clear();
    }
    if (this.fIf != null)
    {
      localIterator = this.fIf.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.fIf.clear();
    }
    this.fIr.clear();
    Iterator localIterator = this.fIs.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Bitmap localBitmap = (Bitmap)((Map.Entry)localIterator.next()).getValue();
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        ad.i("MicroMsg.MosaicCache", "bitmap recycle %s", new Object[] { localBitmap.toString() });
        localBitmap.recycle();
      }
    }
    this.fIs.clear();
    AppMethodBeat.o(9229);
  }
  
  public final void t(final Bitmap paramBitmap)
  {
    AppMethodBeat.i(9234);
    paramBitmap = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
    final String str1 = com.tencent.mm.cm.a.aXW(com.tencent.mm.e.a.dae.toString());
    ad.i("MicroMsg.MosaicCache", "[saveCacheToLocal] path:%s size:%s", new Object[] { str1, Integer.valueOf(aj(true)) });
    String str2 = (String)this.fIr.get(aj(true));
    if (!bt.isNullOrNil(str2))
    {
      com.tencent.mm.vfs.i.deleteFile(str2);
      this.fIr.remove(aj(true));
    }
    this.fIr.put(aj(true), str1);
    this.fIs.put(str1, paramBitmap);
    b.e(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9227);
        try
        {
          g.a(paramBitmap, 50, Bitmap.CompressFormat.PNG, str1, true);
          AppMethodBeat.o(9227);
          return;
        }
        catch (IOException localIOException)
        {
          ad.printErrStackTrace("MicroMsg.MosaicCache", localIOException, "", new Object[0]);
          AppMethodBeat.o(9227);
        }
      }
    }, "[saveCacheToLocal] mosaic path:".concat(String.valueOf(str1)));
    AppMethodBeat.o(9234);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.cache.i
 * JD-Core Version:    0.7.0.1
 */