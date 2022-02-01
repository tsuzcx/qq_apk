package com.tencent.mm.cache;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.e.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

public final class i
  implements f<e>
{
  private Stack<e> iTF;
  private Stack<e> iTG;
  public int iTI;
  private SparseArray<String> iTP;
  private HashMap<String, Bitmap> iTQ;
  
  public final void a(Canvas paramCanvas, boolean paramBoolean)
  {
    AppMethodBeat.i(9232);
    if (!paramBoolean) {
      if ((this.iTF == null) || (this.iTF.size() <= 0)) {
        break label64;
      }
    }
    label64:
    for (e locale = (e)this.iTF.peek();; locale = null)
    {
      if ((locale != null) && (locale.fmg == e.a.kat)) {
        locale.draw(paramCanvas);
      }
      AppMethodBeat.o(9232);
      return;
    }
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(9236);
    if (this.iTF != null) {
      this.iTF.push(parame);
    }
    AppMethodBeat.o(9236);
  }
  
  public final void acG()
  {
    this.iTI += 1;
  }
  
  public final int ai(boolean paramBoolean)
  {
    AppMethodBeat.i(9237);
    int i;
    if (paramBoolean)
    {
      if (this.iTF != null)
      {
        i = this.iTF.size();
        AppMethodBeat.o(9237);
        return i;
      }
      AppMethodBeat.o(9237);
      return 0;
    }
    if (this.iTG != null)
    {
      i = this.iTG.size();
      AppMethodBeat.o(9237);
      return i;
    }
    AppMethodBeat.o(9237);
    return 0;
  }
  
  public final void arB()
  {
    AppMethodBeat.i(9231);
    Log.i("MicroMsg.MosaicCache", "[onRestore] size:%s", new Object[] { Integer.valueOf(this.iTF.size()) });
    this.iTF.clear();
    if (this.iTG != null)
    {
      Log.i("MicroMsg.MosaicCache", "[onRestore] %s", new Object[] { Integer.valueOf(this.iTG.size()) });
      this.iTF.addAll(this.iTG);
    }
    AppMethodBeat.o(9231);
  }
  
  public final Bitmap arJ()
  {
    AppMethodBeat.i(9235);
    String str = (String)this.iTP.get(ai(true));
    if (Util.isNullOrNil(str))
    {
      Log.w("MicroMsg.MosaicCache", "[getCacheFromLocal] path is null");
      AppMethodBeat.o(9235);
      return null;
    }
    Log.i("MicroMsg.MosaicCache", "[getCacheFromLocal] path:%s size:%s", new Object[] { str, Integer.valueOf(ai(true)) });
    if (this.iTQ.containsKey(str)) {}
    for (Bitmap localBitmap1 = (Bitmap)this.iTQ.get(str);; localBitmap1 = null)
    {
      Bitmap localBitmap2;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (!localBitmap1.isRecycled()) {}
      }
      else
      {
        Log.i("MicroMsg.MosaicCache", "");
        localBitmap2 = BitmapUtil.getBitmapNative(str);
        Log.i("MicroMsg.MosaicCache", "[getCacheFromLocal] get from local!");
      }
      if (localBitmap2 == null)
      {
        Log.e("MicroMsg.MosaicCache", "[getCacheFromLocal] null == bitmap path:%s", new Object[] { str });
        AppMethodBeat.o(9235);
        return null;
      }
      localBitmap1 = localBitmap2.copy(Bitmap.Config.ARGB_8888, true);
      Log.i("MicroMsg.MosaicCache", "bitmap recycle %s", new Object[] { localBitmap2 });
      localBitmap2.recycle();
      AppMethodBeat.o(9235);
      return localBitmap1;
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(259887);
    if (this.iTF != null) {
      this.iTF.clear();
    }
    AppMethodBeat.o(259887);
  }
  
  public final void dL(boolean paramBoolean)
  {
    AppMethodBeat.i(9230);
    Log.i("MicroMsg.MosaicCache", "[onSave] size:%s", new Object[] { Integer.valueOf(this.iTF.size()) });
    if (this.iTG != null) {
      this.iTG.clear();
    }
    this.iTG = ((Stack)this.iTF.clone());
    if (paramBoolean) {
      this.iTF.clear();
    }
    AppMethodBeat.o(9230);
  }
  
  public final void f(Canvas paramCanvas)
  {
    AppMethodBeat.i(9233);
    Bitmap localBitmap = arJ();
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, null);
    }
    AppMethodBeat.o(9233);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(9228);
    Log.i("MicroMsg.MosaicCache", "[onCreate]");
    this.iTF = new Stack();
    this.iTP = new SparseArray();
    this.iTQ = new HashMap();
    AppMethodBeat.o(9228);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9229);
    if (this.iTF != null)
    {
      localIterator = this.iTF.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.iTF.clear();
    }
    if (this.iTG != null)
    {
      localIterator = this.iTG.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.iTG.clear();
    }
    this.iTP.clear();
    Iterator localIterator = this.iTQ.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Bitmap localBitmap = (Bitmap)((Map.Entry)localIterator.next()).getValue();
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        Log.i("MicroMsg.MosaicCache", "bitmap recycle %s", new Object[] { localBitmap.toString() });
        localBitmap.recycle();
      }
    }
    this.iTQ.clear();
    AppMethodBeat.o(9229);
  }
  
  public final void p(final Bitmap paramBitmap)
  {
    AppMethodBeat.i(9234);
    paramBitmap = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
    final String str1 = com.tencent.mm.cs.a.bBs(com.tencent.mm.e.a.fky.toString());
    Log.i("MicroMsg.MosaicCache", "[saveCacheToLocal] path:%s size:%s", new Object[] { str1, Integer.valueOf(ai(true)) });
    String str2 = (String)this.iTP.get(ai(true));
    if (!Util.isNullOrNil(str2))
    {
      u.deleteFile(str2);
      this.iTP.remove(ai(true));
    }
    this.iTP.put(ai(true), str1);
    this.iTQ.put(str1, paramBitmap);
    ThreadPool.postAtFront(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9227);
        try
        {
          BitmapUtil.saveBitmapToImage(paramBitmap, 50, Bitmap.CompressFormat.PNG, str1, true);
          AppMethodBeat.o(9227);
          return;
        }
        catch (IOException localIOException)
        {
          Log.printErrStackTrace("MicroMsg.MosaicCache", localIOException, "", new Object[0]);
          AppMethodBeat.o(9227);
        }
      }
    }, "[saveCacheToLocal] mosaic path:".concat(String.valueOf(str1)));
    AppMethodBeat.o(9234);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.cache.i
 * JD-Core Version:    0.7.0.1
 */