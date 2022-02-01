package com.tencent.mm.cache;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.s;
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
  public int gpA;
  private SparseArray<String> gpH;
  private HashMap<String, Bitmap> gpI;
  private Stack<e> gpx;
  private Stack<e> gpy;
  
  public final void Ya()
  {
    this.gpA += 1;
  }
  
  public final void a(Canvas paramCanvas, boolean paramBoolean)
  {
    AppMethodBeat.i(9232);
    if (!paramBoolean) {
      if ((this.gpx == null) || (this.gpx.size() <= 0)) {
        break label64;
      }
    }
    label64:
    for (e locale = (e)this.gpx.peek();; locale = null)
    {
      if ((locale != null) && (locale.dty == e.a.hoC)) {
        locale.draw(paramCanvas);
      }
      AppMethodBeat.o(9232);
      return;
    }
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(9236);
    if (this.gpx != null) {
      this.gpx.push(parame);
    }
    AppMethodBeat.o(9236);
  }
  
  public final int ai(boolean paramBoolean)
  {
    AppMethodBeat.i(9237);
    int i;
    if (paramBoolean)
    {
      if (this.gpx != null)
      {
        i = this.gpx.size();
        AppMethodBeat.o(9237);
        return i;
      }
      AppMethodBeat.o(9237);
      return 0;
    }
    if (this.gpy != null)
    {
      i = this.gpy.size();
      AppMethodBeat.o(9237);
      return i;
    }
    AppMethodBeat.o(9237);
    return 0;
  }
  
  public final void alC()
  {
    AppMethodBeat.i(9231);
    Log.i("MicroMsg.MosaicCache", "[onRestore] size:%s", new Object[] { Integer.valueOf(this.gpx.size()) });
    this.gpx.clear();
    if (this.gpy != null)
    {
      Log.i("MicroMsg.MosaicCache", "[onRestore] %s", new Object[] { Integer.valueOf(this.gpy.size()) });
      this.gpx.addAll(this.gpy);
    }
    AppMethodBeat.o(9231);
  }
  
  public final Bitmap alK()
  {
    AppMethodBeat.i(9235);
    String str = (String)this.gpH.get(ai(true));
    if (Util.isNullOrNil(str))
    {
      Log.w("MicroMsg.MosaicCache", "[getCacheFromLocal] path is null");
      AppMethodBeat.o(9235);
      return null;
    }
    Log.i("MicroMsg.MosaicCache", "[getCacheFromLocal] path:%s size:%s", new Object[] { str, Integer.valueOf(ai(true)) });
    if (this.gpI.containsKey(str)) {}
    for (Bitmap localBitmap1 = (Bitmap)this.gpI.get(str);; localBitmap1 = null)
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
    AppMethodBeat.i(204751);
    if (this.gpx != null) {
      this.gpx.clear();
    }
    AppMethodBeat.o(204751);
  }
  
  public final void dl(boolean paramBoolean)
  {
    AppMethodBeat.i(9230);
    Log.i("MicroMsg.MosaicCache", "[onSave] size:%s", new Object[] { Integer.valueOf(this.gpx.size()) });
    if (this.gpy != null) {
      this.gpy.clear();
    }
    this.gpy = ((Stack)this.gpx.clone());
    if (paramBoolean) {
      this.gpx.clear();
    }
    AppMethodBeat.o(9230);
  }
  
  public final void e(Canvas paramCanvas)
  {
    AppMethodBeat.i(9233);
    Bitmap localBitmap = alK();
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, null);
    }
    AppMethodBeat.o(9233);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(9228);
    Log.i("MicroMsg.MosaicCache", "[onCreate]");
    this.gpx = new Stack();
    this.gpH = new SparseArray();
    this.gpI = new HashMap();
    AppMethodBeat.o(9228);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9229);
    if (this.gpx != null)
    {
      localIterator = this.gpx.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.gpx.clear();
    }
    if (this.gpy != null)
    {
      localIterator = this.gpy.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.gpy.clear();
    }
    this.gpH.clear();
    Iterator localIterator = this.gpI.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Bitmap localBitmap = (Bitmap)((Map.Entry)localIterator.next()).getValue();
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        Log.i("MicroMsg.MosaicCache", "bitmap recycle %s", new Object[] { localBitmap.toString() });
        localBitmap.recycle();
      }
    }
    this.gpI.clear();
    AppMethodBeat.o(9229);
  }
  
  public final void u(final Bitmap paramBitmap)
  {
    AppMethodBeat.i(9234);
    paramBitmap = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
    final String str1 = com.tencent.mm.cl.a.boD(com.tencent.mm.e.a.drM.toString());
    Log.i("MicroMsg.MosaicCache", "[saveCacheToLocal] path:%s size:%s", new Object[] { str1, Integer.valueOf(ai(true)) });
    String str2 = (String)this.gpH.get(ai(true));
    if (!Util.isNullOrNil(str2))
    {
      s.deleteFile(str2);
      this.gpH.remove(ai(true));
    }
    this.gpH.put(ai(true), str1);
    this.gpI.put(str1, paramBitmap);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.cache.i
 * JD-Core Version:    0.7.0.1
 */