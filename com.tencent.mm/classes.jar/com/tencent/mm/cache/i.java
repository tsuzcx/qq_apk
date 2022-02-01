package com.tencent.mm.cache;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.vfs.o;
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
  private Stack<e> fKi;
  private Stack<e> fKj;
  public int fKl;
  private SparseArray<String> fKv;
  private HashMap<String, Bitmap> fKw;
  
  public final void NO()
  {
    this.fKl += 1;
  }
  
  public final void XP()
  {
    AppMethodBeat.i(9231);
    ae.i("MicroMsg.MosaicCache", "[onRestore] size:%s", new Object[] { Integer.valueOf(this.fKi.size()) });
    this.fKi.clear();
    if (this.fKj != null)
    {
      ae.i("MicroMsg.MosaicCache", "[onRestore] %s", new Object[] { Integer.valueOf(this.fKj.size()) });
      this.fKi.addAll(this.fKj);
    }
    AppMethodBeat.o(9231);
  }
  
  public final Bitmap XX()
  {
    AppMethodBeat.i(9235);
    String str = (String)this.fKv.get(aj(true));
    if (bu.isNullOrNil(str))
    {
      ae.w("MicroMsg.MosaicCache", "[getCacheFromLocal] path is null");
      AppMethodBeat.o(9235);
      return null;
    }
    ae.i("MicroMsg.MosaicCache", "[getCacheFromLocal] path:%s size:%s", new Object[] { str, Integer.valueOf(aj(true)) });
    if (this.fKw.containsKey(str)) {}
    for (Bitmap localBitmap1 = (Bitmap)this.fKw.get(str);; localBitmap1 = null)
    {
      Bitmap localBitmap2;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (!localBitmap1.isRecycled()) {}
      }
      else
      {
        ae.i("MicroMsg.MosaicCache", "");
        localBitmap2 = h.aRC(str);
        ae.i("MicroMsg.MosaicCache", "[getCacheFromLocal] get from local!");
      }
      if (localBitmap2 == null)
      {
        ae.e("MicroMsg.MosaicCache", "[getCacheFromLocal] null == bitmap path:%s", new Object[] { str });
        AppMethodBeat.o(9235);
        return null;
      }
      localBitmap1 = localBitmap2.copy(Bitmap.Config.ARGB_8888, true);
      ae.i("MicroMsg.MosaicCache", "bitmap recycle %s", new Object[] { localBitmap2 });
      localBitmap2.recycle();
      AppMethodBeat.o(9235);
      return localBitmap1;
    }
  }
  
  public final void a(Canvas paramCanvas, boolean paramBoolean)
  {
    AppMethodBeat.i(9232);
    if (!paramBoolean) {
      if ((this.fKi == null) || (this.fKi.size() <= 0)) {
        break label64;
      }
    }
    label64:
    for (e locale = (e)this.fKi.peek();; locale = null)
    {
      if ((locale != null) && (locale.dcH == e.a.gBN)) {
        locale.draw(paramCanvas);
      }
      AppMethodBeat.o(9232);
      return;
    }
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(9236);
    if (this.fKi != null) {
      this.fKi.push(parame);
    }
    AppMethodBeat.o(9236);
  }
  
  public final int aj(boolean paramBoolean)
  {
    AppMethodBeat.i(9237);
    int i;
    if (paramBoolean)
    {
      if (this.fKi != null)
      {
        i = this.fKi.size();
        AppMethodBeat.o(9237);
        return i;
      }
      AppMethodBeat.o(9237);
      return 0;
    }
    if (this.fKj != null)
    {
      i = this.fKj.size();
      AppMethodBeat.o(9237);
      return i;
    }
    AppMethodBeat.o(9237);
    return 0;
  }
  
  public final void cC(boolean paramBoolean)
  {
    AppMethodBeat.i(9230);
    ae.i("MicroMsg.MosaicCache", "[onSave] size:%s", new Object[] { Integer.valueOf(this.fKi.size()) });
    if (this.fKj != null) {
      this.fKj.clear();
    }
    this.fKj = ((Stack)this.fKi.clone());
    if (paramBoolean) {
      this.fKi.clear();
    }
    AppMethodBeat.o(9230);
  }
  
  public final void e(Canvas paramCanvas)
  {
    AppMethodBeat.i(9233);
    Bitmap localBitmap = XX();
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, null);
    }
    AppMethodBeat.o(9233);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(9228);
    ae.i("MicroMsg.MosaicCache", "[onCreate]");
    this.fKi = new Stack();
    this.fKv = new SparseArray();
    this.fKw = new HashMap();
    AppMethodBeat.o(9228);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9229);
    if (this.fKi != null)
    {
      localIterator = this.fKi.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.fKi.clear();
    }
    if (this.fKj != null)
    {
      localIterator = this.fKj.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.fKj.clear();
    }
    this.fKv.clear();
    Iterator localIterator = this.fKw.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Bitmap localBitmap = (Bitmap)((Map.Entry)localIterator.next()).getValue();
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        ae.i("MicroMsg.MosaicCache", "bitmap recycle %s", new Object[] { localBitmap.toString() });
        localBitmap.recycle();
      }
    }
    this.fKw.clear();
    AppMethodBeat.o(9229);
  }
  
  public final void u(final Bitmap paramBitmap)
  {
    AppMethodBeat.i(9234);
    paramBitmap = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
    final String str1 = com.tencent.mm.cl.a.aZy(com.tencent.mm.e.a.dbg.toString());
    ae.i("MicroMsg.MosaicCache", "[saveCacheToLocal] path:%s size:%s", new Object[] { str1, Integer.valueOf(aj(true)) });
    String str2 = (String)this.fKv.get(aj(true));
    if (!bu.isNullOrNil(str2))
    {
      o.deleteFile(str2);
      this.fKv.remove(aj(true));
    }
    this.fKv.put(aj(true), str1);
    this.fKw.put(str1, paramBitmap);
    b.e(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9227);
        try
        {
          h.a(paramBitmap, 50, Bitmap.CompressFormat.PNG, str1, true);
          AppMethodBeat.o(9227);
          return;
        }
        catch (IOException localIOException)
        {
          ae.printErrStackTrace("MicroMsg.MosaicCache", localIOException, "", new Object[0]);
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