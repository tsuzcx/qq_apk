package com.tencent.mm.aj;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class m$a
{
  List<Object> fwI;
  Map<String, Integer> fwJ;
  Map<String, WeakReference<Bitmap>> fwK;
  az fwL;
  
  public m$a()
  {
    AppMethodBeat.i(11421);
    this.fwI = new ArrayList();
    this.fwJ = new HashMap();
    this.fwK = new HashMap();
    this.fwL = null;
    AppMethodBeat.o(11421);
  }
  
  public static String sh(String paramString)
  {
    AppMethodBeat.i(11424);
    if (com.tencent.mm.kernel.g.RJ().QU())
    {
      paramString = ((o)com.tencent.mm.kernel.g.E(o.class)).YT() + "/brand_" + com.tencent.mm.a.g.w(paramString.getBytes());
      AppMethodBeat.o(11424);
      return paramString;
    }
    AppMethodBeat.o(11424);
    return "";
  }
  
  public final void afc()
  {
    AppMethodBeat.i(11422);
    this.fwI.clear();
    AppMethodBeat.o(11422);
  }
  
  final void g(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(11425);
    Bitmap localBitmap1;
    if (this.fwK.containsKey(paramString)) {
      localBitmap1 = (Bitmap)((WeakReference)this.fwK.get(paramString)).get();
    }
    for (;;)
    {
      Bitmap localBitmap3;
      if (localBitmap1 != null)
      {
        localBitmap3 = localBitmap1;
        if (!localBitmap1.isRecycled()) {
          break label111;
        }
      }
      try
      {
        localBitmap1 = Bitmap.createScaledBitmap(paramBitmap, 128, 128, true);
        localBitmap1 = d.a(localBitmap1, true, localBitmap1.getWidth() >> 1);
        this.fwK.remove(paramString);
        this.fwK.put(paramString, new WeakReference(localBitmap1));
        localBitmap3 = localBitmap1;
        label111:
        if (localBitmap3 == paramBitmap)
        {
          AppMethodBeat.o(11425);
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
        ab.i("MicroMsg.BrandLogic", "recycle bitmap:%s", new Object[] { paramBitmap.toString() });
        paramBitmap.recycle();
        AppMethodBeat.o(11425);
      }
    }
  }
  
  final Bitmap sg(String paramString)
  {
    AppMethodBeat.i(11423);
    String str = String.format("%s%f", new Object[] { paramString, Float.valueOf(1.5F) });
    Bitmap localBitmap1;
    if (this.fwK.containsKey(str))
    {
      Bitmap localBitmap2 = (Bitmap)((WeakReference)this.fwK.get(str)).get();
      if (localBitmap2 != null)
      {
        localBitmap1 = localBitmap2;
        if (!localBitmap2.isRecycled()) {}
      }
      else
      {
        localBitmap1 = BackwardSupportUtil.b.k(paramString, 1.5F);
        this.fwK.remove(str);
        this.fwK.put(str, new WeakReference(localBitmap1));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(11423);
      return localBitmap1;
      localBitmap1 = BackwardSupportUtil.b.k(paramString, 1.5F);
      this.fwK.put(str, new WeakReference(localBitmap1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.aj.m.a
 * JD-Core Version:    0.7.0.1
 */