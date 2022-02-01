package com.tencent.mm.plugin.gallery.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f.b;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.h;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class d
{
  l<d.b, String> huf;
  final byte[] lock;
  com.tencent.mm.b.f<String, d.a> sJm;
  f sJn;
  CopyOnWriteArrayList<String> sJo;
  ConcurrentHashMap<String, d.b> sJp;
  
  public d()
  {
    AppMethodBeat.i(111254);
    this.huf = new d.1(this);
    this.sJo = new CopyOnWriteArrayList();
    this.sJp = new ConcurrentHashMap();
    this.lock = new byte[0];
    this.sJm = new b(200, new f.b() {}, getClass());
    f localf = new f();
    localf.sJI = ai.getContext().getSharedPreferences(ai.eUX(), 0).getInt("com.tencent.mm.gallery.cache.suffix", 0);
    ac.d("MicroMsg.DiskCache", "pennqin debug disk cache current suffix: %s.", new Object[] { Integer.valueOf(localf.sJI) });
    localf.cMD();
    localf.FP(-1);
    this.sJn = localf;
    this.huf.a(new d.b()
    {
      public final void agr(String paramAnonymousString)
      {
        AppMethodBeat.i(179449);
        ac.d("MicroMsg.GalleryCache", "now listener size : " + d.this.sJp.size());
        Object localObject;
        if (h.DEBUG)
        {
          localObject = d.this.sJp.entrySet().iterator();
          while (((Iterator)localObject).hasNext()) {
            ac.d("MicroMsg.GalleryCache", "decodeTaskKey: %s.", new Object[] { ((Map.Entry)((Iterator)localObject).next()).getKey() });
          }
        }
        ac.d("MicroMsg.GalleryCache", "will hit??? decodeTaskKey: %s.", new Object[] { paramAnonymousString });
        if (d.this.sJp.containsKey(paramAnonymousString))
        {
          ac.d("MicroMsg.GalleryCache", "hit!!!");
          localObject = (d.b)d.this.sJp.get(paramAnonymousString);
          if (localObject != null) {
            ((d.b)localObject).agr(paramAnonymousString);
          }
          AppMethodBeat.o(179449);
          return;
        }
        ac.w("MicroMsg.GalleryCache", "not hit!!!");
        AppMethodBeat.o(179449);
      }
      
      public final String cMp()
      {
        return "";
      }
    }, null);
    AppMethodBeat.o(111254);
  }
  
  public final void a(String paramString, Bitmap paramBitmap, int paramInt1, s.e parame, boolean paramBoolean, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(179450);
    if (this.sJm == null)
    {
      ac.e("MicroMsg.GalleryCache", "cache is null");
      AppMethodBeat.o(179450);
      return;
    }
    this.sJm.o(com.tencent.mm.plugin.gallery.a.d.a(paramString, parame, paramLong), new d.a(this, paramBitmap, paramInt1));
    if (!paramBoolean)
    {
      this.huf.dS(com.tencent.mm.plugin.gallery.a.d.a(paramString, parame, paramInt2));
      this.huf.doNotify();
    }
    AppMethodBeat.o(179450);
  }
  
  /* Error */
  public final void a(String paramString1, String paramString2, Bitmap paramBitmap, s.e parame, long paramLong)
  {
    // Byte code:
    //   0: ldc 171
    //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 58	com/tencent/mm/plugin/gallery/model/d:lock	[B
    //   9: astore 8
    //   11: aload 8
    //   13: monitorenter
    //   14: aload_3
    //   15: ifnull +10 -> 25
    //   18: aload_3
    //   19: invokevirtual 177	android/graphics/Bitmap:isRecycled	()Z
    //   22: ifeq +19 -> 41
    //   25: ldc 140
    //   27: ldc 179
    //   29: invokestatic 146	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload 8
    //   34: monitorexit
    //   35: ldc 171
    //   37: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: return
    //   41: aload_0
    //   42: getfield 125	com/tencent/mm/plugin/gallery/model/d:sJn	Lcom/tencent/mm/plugin/gallery/model/f;
    //   45: ifnonnull +12 -> 57
    //   48: aload 8
    //   50: monitorexit
    //   51: ldc 171
    //   53: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: return
    //   57: aload_1
    //   58: invokestatic 185	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   61: ifeq +35 -> 96
    //   64: aload_2
    //   65: aload 4
    //   67: lload 5
    //   69: invokestatic 151	com/tencent/mm/plugin/gallery/a/d:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/gallery/model/s$e;J)Ljava/lang/String;
    //   72: invokevirtual 191	java/lang/String:hashCode	()I
    //   75: istore 7
    //   77: aload_0
    //   78: getfield 125	com/tencent/mm/plugin/gallery/model/d:sJn	Lcom/tencent/mm/plugin/gallery/model/f;
    //   81: iload 7
    //   83: aload_3
    //   84: invokevirtual 194	com/tencent/mm/plugin/gallery/model/f:a	(ILandroid/graphics/Bitmap;)V
    //   87: aload 8
    //   89: monitorexit
    //   90: ldc 171
    //   92: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: return
    //   96: aload_1
    //   97: astore_2
    //   98: goto -34 -> 64
    //   101: astore_1
    //   102: aload 8
    //   104: monitorexit
    //   105: ldc 171
    //   107: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: aload_1
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	d
    //   0	112	1	paramString1	String
    //   0	112	2	paramString2	String
    //   0	112	3	paramBitmap	Bitmap
    //   0	112	4	parame	s.e
    //   0	112	5	paramLong	long
    //   75	7	7	i	int
    //   9	94	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   18	25	101	finally
    //   25	35	101	finally
    //   41	51	101	finally
    //   57	64	101	finally
    //   64	90	101	finally
    //   102	105	101	finally
  }
  
  public final Bitmap b(String paramString1, String paramString2, s.e parame, long paramLong)
  {
    AppMethodBeat.i(179451);
    synchronized (this.lock)
    {
      if (this.sJn == null)
      {
        AppMethodBeat.o(179451);
        return null;
      }
      if (bs.isNullOrNil(paramString1))
      {
        paramString1 = com.tencent.mm.plugin.gallery.a.d.a(paramString2, parame, paramLong);
        int i = paramString1.hashCode();
        ac.d("MicroMsg.GalleryCache", "keyStr: %s keyInt: %s.", new Object[] { paramString1, Integer.valueOf(i) });
        paramString1 = this.sJn.FS(i);
        AppMethodBeat.o(179451);
        return paramString1;
      }
      paramString2 = paramString1;
    }
  }
  
  public final void cMo()
  {
    AppMethodBeat.i(111259);
    this.sJo.clear();
    this.sJp.clear();
    AppMethodBeat.o(111259);
  }
  
  public final Bitmap getBitmap(String paramString)
  {
    AppMethodBeat.i(111255);
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.GalleryCache", "null filepath");
      AppMethodBeat.o(111255);
      return null;
    }
    if (this.sJm == null)
    {
      ac.w("MicroMsg.GalleryCache", "want to get bitmap, but gallery cache is null");
      AppMethodBeat.o(111255);
      return null;
    }
    if (this.sJm.aK(paramString))
    {
      Object localObject = (d.a)this.sJm.aJ(paramString);
      if (localObject == null)
      {
        ac.d("MicroMsg.GalleryCache", "weakreference is null! %s", new Object[] { paramString });
        this.sJm.remove(paramString);
        AppMethodBeat.o(111255);
        return null;
      }
      localObject = ((d.a)localObject).bitmap;
      if (localObject != null)
      {
        if (((Bitmap)localObject).isRecycled())
        {
          ac.i("MicroMsg.GalleryCache", "cache bitmap has recycled: %s", new Object[] { paramString });
          this.sJm.remove(paramString);
          AppMethodBeat.o(111255);
          return null;
        }
        ac.i("MicroMsg.GalleryCache", "get cached bitmap:".concat(String.valueOf(paramString)));
        AppMethodBeat.o(111255);
        return localObject;
      }
      this.sJm.remove(paramString);
      ac.i("MicroMsg.GalleryCache", "get bitmap is null! %s", new Object[] { paramString });
    }
    AppMethodBeat.o(111255);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.d
 * JD-Core Version:    0.7.0.1
 */