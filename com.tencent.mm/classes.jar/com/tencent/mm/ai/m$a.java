package com.tencent.mm.ai;

import android.graphics.Bitmap;
import com.tencent.mm.kernel.a;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class m$a
{
  public List<m.a.a> egE = new ArrayList();
  Map<String, Integer> egF = new HashMap();
  public Map<String, WeakReference<Bitmap>> egG = new HashMap();
  av egH = null;
  
  public static String ll(String paramString)
  {
    if (com.tencent.mm.kernel.g.DN().Dc()) {
      return ((o)com.tencent.mm.kernel.g.r(o.class)).FP() + "/brand_" + com.tencent.mm.a.g.o(paramString.getBytes());
    }
    return "";
  }
  
  public final void Ms()
  {
    this.egE.clear();
  }
  
  final void f(String paramString, Bitmap paramBitmap)
  {
    Bitmap localBitmap1;
    if (this.egG.containsKey(paramString)) {
      localBitmap1 = (Bitmap)((WeakReference)this.egG.get(paramString)).get();
    }
    for (;;)
    {
      Bitmap localBitmap3;
      if (localBitmap1 != null)
      {
        localBitmap3 = localBitmap1;
        if (!localBitmap1.isRecycled()) {
          break label105;
        }
      }
      try
      {
        localBitmap1 = Bitmap.createScaledBitmap(paramBitmap, 128, 128, true);
        localBitmap1 = c.a(localBitmap1, true, localBitmap1.getWidth() >> 1);
        this.egG.remove(paramString);
        this.egG.put(paramString, new WeakReference(localBitmap1));
        localBitmap3 = localBitmap1;
        label105:
        if (localBitmap3 == paramBitmap)
        {
          return;
          localBitmap1 = null;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          Bitmap localBitmap2 = paramBitmap;
        }
        y.i("MicroMsg.BrandLogic", "recycle bitmap:%s", new Object[] { paramBitmap.toString() });
        paramBitmap.recycle();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ai.m.a
 * JD-Core Version:    0.7.0.1
 */