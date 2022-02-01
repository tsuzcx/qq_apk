package com.tencent.mm.cache;

import android.graphics.Bitmap;
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
import com.tencent.mm.vfs.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

public final class i
  implements f<e>
{
  private Stack<e> lvL;
  private Stack<e> lvM;
  public int lvO;
  private SparseArray<String> lvU;
  private HashMap<String, Bitmap> lvV;
  
  public final void B(Bitmap paramBitmap)
  {
    AppMethodBeat.i(9234);
    paramBitmap = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
    String str1 = com.tencent.mm.cl.a.bDM(com.tencent.mm.e.a.hoL.toString());
    Log.i("MicroMsg.MosaicCache", "[saveCacheToLocal] path:%s size:%s", new Object[] { str1, Integer.valueOf(aR(true)) });
    String str2 = (String)this.lvU.get(aR(true));
    if (!Util.isNullOrNil(str2))
    {
      y.deleteFile(str2);
      this.lvU.remove(aR(true));
    }
    this.lvU.put(aR(true), str1);
    this.lvV.put(str1, paramBitmap);
    ThreadPool.postAtFront(new i.1(this, paramBitmap, str1), "[saveCacheToLocal] mosaic path:".concat(String.valueOf(str1)));
    AppMethodBeat.o(9234);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(9236);
    if (this.lvL != null) {
      this.lvL.push(parame);
    }
    AppMethodBeat.o(9236);
  }
  
  public final void aEG()
  {
    this.lvO += 1;
  }
  
  public final Bitmap aLF()
  {
    AppMethodBeat.i(9235);
    String str = (String)this.lvU.get(aR(true));
    if (Util.isNullOrNil(str))
    {
      Log.w("MicroMsg.MosaicCache", "[getCacheFromLocal] path is null");
      AppMethodBeat.o(9235);
      return null;
    }
    Log.i("MicroMsg.MosaicCache", "[getCacheFromLocal] path:%s size:%s", new Object[] { str, Integer.valueOf(aR(true)) });
    if (this.lvV.containsKey(str)) {}
    for (Bitmap localBitmap1 = (Bitmap)this.lvV.get(str);; localBitmap1 = null)
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
  
  public final void aLx()
  {
    AppMethodBeat.i(9231);
    Log.i("MicroMsg.MosaicCache", "[onRestore] size:%s", new Object[] { Integer.valueOf(this.lvL.size()) });
    this.lvL.clear();
    if (this.lvM != null)
    {
      Log.i("MicroMsg.MosaicCache", "[onRestore] %s", new Object[] { Integer.valueOf(this.lvM.size()) });
      this.lvL.addAll(this.lvM);
    }
    AppMethodBeat.o(9231);
  }
  
  public final int aR(boolean paramBoolean)
  {
    AppMethodBeat.i(9237);
    int i;
    if (paramBoolean)
    {
      if (this.lvL != null)
      {
        i = this.lvL.size();
        AppMethodBeat.o(9237);
        return i;
      }
      AppMethodBeat.o(9237);
      return 0;
    }
    if (this.lvM != null)
    {
      i = this.lvM.size();
      AppMethodBeat.o(9237);
      return i;
    }
    AppMethodBeat.o(9237);
    return 0;
  }
  
  public final void b(Canvas paramCanvas, boolean paramBoolean)
  {
    AppMethodBeat.i(9232);
    if (!paramBoolean) {
      if ((this.lvL == null) || (this.lvL.size() <= 0)) {
        break label64;
      }
    }
    label64:
    for (e locale = (e)this.lvL.peek();; locale = null)
    {
      if ((locale != null) && (locale.hqt == e.a.mAw)) {
        locale.draw(paramCanvas);
      }
      AppMethodBeat.o(9232);
      return;
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(232085);
    if (this.lvL != null) {
      this.lvL.clear();
    }
    AppMethodBeat.o(232085);
  }
  
  public final void ex(boolean paramBoolean)
  {
    AppMethodBeat.i(9230);
    Log.i("MicroMsg.MosaicCache", "[onSave] size:%s", new Object[] { Integer.valueOf(this.lvL.size()) });
    if (this.lvM != null) {
      this.lvM.clear();
    }
    this.lvM = ((Stack)this.lvL.clone());
    if (paramBoolean) {
      this.lvL.clear();
    }
    AppMethodBeat.o(9230);
  }
  
  public final void i(Canvas paramCanvas)
  {
    AppMethodBeat.i(9233);
    Bitmap localBitmap = aLF();
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, null);
    }
    AppMethodBeat.o(9233);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(9228);
    Log.i("MicroMsg.MosaicCache", "[onCreate]");
    this.lvL = new Stack();
    this.lvU = new SparseArray();
    this.lvV = new HashMap();
    AppMethodBeat.o(9228);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9229);
    if (this.lvL != null)
    {
      localIterator = this.lvL.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.lvL.clear();
    }
    if (this.lvM != null)
    {
      localIterator = this.lvM.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.lvM.clear();
    }
    this.lvU.clear();
    Iterator localIterator = this.lvV.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Bitmap localBitmap = (Bitmap)((Map.Entry)localIterator.next()).getValue();
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        Log.i("MicroMsg.MosaicCache", "bitmap recycle %s", new Object[] { localBitmap.toString() });
        localBitmap.recycle();
      }
    }
    this.lvV.clear();
    AppMethodBeat.o(9229);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.cache.i
 * JD-Core Version:    0.7.0.1
 */