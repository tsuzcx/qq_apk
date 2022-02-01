package com.tencent.mm.cache;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.z.e;
import com.tencent.mm.z.e.a;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

public final class i
  implements f<e>
{
  private Stack<e> fpX;
  private Stack<e> fpY;
  public int fqa;
  private SparseArray<String> fqk;
  private HashMap<String, Bitmap> fql;
  
  public final void Mh()
  {
    this.fqa += 1;
  }
  
  public final void Vo()
  {
    AppMethodBeat.i(9231);
    ac.i("MicroMsg.MosaicCache", "[onRestore] size:%s", new Object[] { Integer.valueOf(this.fpX.size()) });
    this.fpX.clear();
    if (this.fpY != null)
    {
      ac.i("MicroMsg.MosaicCache", "[onRestore] %s", new Object[] { Integer.valueOf(this.fpY.size()) });
      this.fpX.addAll(this.fpY);
    }
    AppMethodBeat.o(9231);
  }
  
  public final Bitmap Vw()
  {
    AppMethodBeat.i(9235);
    String str = (String)this.fqk.get(aj(true));
    if (bs.isNullOrNil(str))
    {
      ac.w("MicroMsg.MosaicCache", "[getCacheFromLocal] path is null");
      AppMethodBeat.o(9235);
      return null;
    }
    ac.i("MicroMsg.MosaicCache", "[getCacheFromLocal] path:%s size:%s", new Object[] { str, Integer.valueOf(aj(true)) });
    if (this.fql.containsKey(str)) {}
    for (Bitmap localBitmap1 = (Bitmap)this.fql.get(str);; localBitmap1 = null)
    {
      Bitmap localBitmap2;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (!localBitmap1.isRecycled()) {}
      }
      else
      {
        ac.i("MicroMsg.MosaicCache", "");
        localBitmap2 = com.tencent.mm.sdk.platformtools.f.aKz(str);
        ac.i("MicroMsg.MosaicCache", "[getCacheFromLocal] get from local!");
      }
      if (localBitmap2 == null)
      {
        ac.e("MicroMsg.MosaicCache", "[getCacheFromLocal] null == bitmap path:%s", new Object[] { str });
        AppMethodBeat.o(9235);
        return null;
      }
      localBitmap1 = localBitmap2.copy(Bitmap.Config.ARGB_8888, true);
      ac.i("MicroMsg.MosaicCache", "bitmap recycle %s", new Object[] { localBitmap2 });
      localBitmap2.recycle();
      AppMethodBeat.o(9235);
      return localBitmap1;
    }
  }
  
  public final void a(Canvas paramCanvas, boolean paramBoolean)
  {
    AppMethodBeat.i(9232);
    if (!paramBoolean) {
      if ((this.fpX == null) || (this.fpX.size() <= 0)) {
        break label64;
      }
    }
    label64:
    for (e locale = (e)this.fpX.peek();; locale = null)
    {
      if ((locale != null) && (locale.cQp == e.a.gfw)) {
        locale.draw(paramCanvas);
      }
      AppMethodBeat.o(9232);
      return;
    }
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(9236);
    if (this.fpX != null) {
      this.fpX.push(parame);
    }
    AppMethodBeat.o(9236);
  }
  
  public final int aj(boolean paramBoolean)
  {
    AppMethodBeat.i(9237);
    int i;
    if (paramBoolean)
    {
      if (this.fpX != null)
      {
        i = this.fpX.size();
        AppMethodBeat.o(9237);
        return i;
      }
      AppMethodBeat.o(9237);
      return 0;
    }
    if (this.fpY != null)
    {
      i = this.fpY.size();
      AppMethodBeat.o(9237);
      return i;
    }
    AppMethodBeat.o(9237);
    return 0;
  }
  
  public final void cA(boolean paramBoolean)
  {
    AppMethodBeat.i(9230);
    ac.i("MicroMsg.MosaicCache", "[onSave] size:%s", new Object[] { Integer.valueOf(this.fpX.size()) });
    if (this.fpY != null) {
      this.fpY.clear();
    }
    this.fpY = ((Stack)this.fpX.clone());
    if (paramBoolean) {
      this.fpX.clear();
    }
    AppMethodBeat.o(9230);
  }
  
  public final void e(Canvas paramCanvas)
  {
    AppMethodBeat.i(9233);
    Bitmap localBitmap = Vw();
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, null);
    }
    AppMethodBeat.o(9233);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(9228);
    ac.i("MicroMsg.MosaicCache", "[onCreate]");
    this.fpX = new Stack();
    this.fqk = new SparseArray();
    this.fql = new HashMap();
    AppMethodBeat.o(9228);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9229);
    if (this.fpX != null)
    {
      localIterator = this.fpX.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.fpX.clear();
    }
    if (this.fpY != null)
    {
      localIterator = this.fpY.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.fpY.clear();
    }
    this.fqk.clear();
    Iterator localIterator = this.fql.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Bitmap localBitmap = (Bitmap)((Map.Entry)localIterator.next()).getValue();
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        ac.i("MicroMsg.MosaicCache", "bitmap recycle %s", new Object[] { localBitmap.toString() });
        localBitmap.recycle();
      }
    }
    this.fql.clear();
    AppMethodBeat.o(9229);
  }
  
  public final void t(final Bitmap paramBitmap)
  {
    AppMethodBeat.i(9234);
    paramBitmap = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
    final String str1 = com.tencent.mm.cm.a.aRX(com.tencent.mm.e.a.cOO.toString());
    ac.i("MicroMsg.MosaicCache", "[saveCacheToLocal] path:%s size:%s", new Object[] { str1, Integer.valueOf(aj(true)) });
    String str2 = (String)this.fqk.get(aj(true));
    if (!bs.isNullOrNil(str2))
    {
      com.tencent.mm.vfs.i.deleteFile(str2);
      this.fqk.remove(aj(true));
    }
    this.fqk.put(aj(true), str1);
    this.fql.put(str1, paramBitmap);
    b.e(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9227);
        try
        {
          com.tencent.mm.sdk.platformtools.f.a(paramBitmap, 50, Bitmap.CompressFormat.PNG, str1, true);
          AppMethodBeat.o(9227);
          return;
        }
        catch (IOException localIOException)
        {
          ac.printErrStackTrace("MicroMsg.MosaicCache", localIOException, "", new Object[0]);
          AppMethodBeat.o(9227);
        }
      }
    }, "[saveCacheToLocal] mosaic path:".concat(String.valueOf(str1)));
    AppMethodBeat.o(9234);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cache.i
 * JD-Core Version:    0.7.0.1
 */