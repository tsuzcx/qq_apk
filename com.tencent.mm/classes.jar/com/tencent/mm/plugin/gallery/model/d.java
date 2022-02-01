package com.tencent.mm.plugin.gallery.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f.b;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class d
{
  l<d.b, String> hPq;
  final byte[] lock;
  com.tencent.mm.b.f<String, a> tQO;
  f tQP;
  CopyOnWriteArrayList<String> tQQ;
  ConcurrentHashMap<String, d.b> tQR;
  
  public d()
  {
    AppMethodBeat.i(111254);
    this.hPq = new d.1(this);
    this.tQQ = new CopyOnWriteArrayList();
    this.tQR = new ConcurrentHashMap();
    this.lock = new byte[0];
    this.tQO = new b(200, new f.b() {}, getClass());
    f localf = new f();
    localf.tRk = ak.getContext().getSharedPreferences(ak.fow(), 0).getInt("com.tencent.mm.gallery.cache.suffix", 0);
    ae.d("MicroMsg.DiskCache", "pennqin debug disk cache current suffix: %s.", new Object[] { Integer.valueOf(localf.tRk) });
    localf.cXB();
    localf.HB(-1);
    this.tQP = localf;
    this.hPq.a(new d.3(this), null);
    AppMethodBeat.o(111254);
  }
  
  public final void a(String paramString, Bitmap paramBitmap, int paramInt1, s.e parame, boolean paramBoolean, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(179450);
    if (this.tQO == null)
    {
      ae.e("MicroMsg.GalleryCache", "cache is null");
      AppMethodBeat.o(179450);
      return;
    }
    this.tQO.q(com.tencent.mm.plugin.gallery.a.d.a(paramString, parame, paramLong), new a(paramBitmap, paramInt1));
    if (!paramBoolean)
    {
      this.hPq.dW(com.tencent.mm.plugin.gallery.a.d.a(paramString, parame, paramInt2));
      this.hPq.doNotify();
    }
    AppMethodBeat.o(179450);
  }
  
  /* Error */
  public final void a(String paramString1, String paramString2, Bitmap paramBitmap, s.e parame, long paramLong)
  {
    // Byte code:
    //   0: ldc 172
    //   2: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 57	com/tencent/mm/plugin/gallery/model/d:lock	[B
    //   9: astore 8
    //   11: aload 8
    //   13: monitorenter
    //   14: aload_3
    //   15: ifnull +10 -> 25
    //   18: aload_3
    //   19: invokevirtual 178	android/graphics/Bitmap:isRecycled	()Z
    //   22: ifeq +19 -> 41
    //   25: ldc 140
    //   27: ldc 180
    //   29: invokestatic 146	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload 8
    //   34: monitorexit
    //   35: ldc 172
    //   37: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: return
    //   41: aload_0
    //   42: getfield 124	com/tencent/mm/plugin/gallery/model/d:tQP	Lcom/tencent/mm/plugin/gallery/model/f;
    //   45: ifnonnull +12 -> 57
    //   48: aload 8
    //   50: monitorexit
    //   51: ldc 172
    //   53: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: return
    //   57: aload_1
    //   58: invokestatic 186	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   61: ifeq +35 -> 96
    //   64: aload_2
    //   65: aload 4
    //   67: lload 5
    //   69: invokestatic 151	com/tencent/mm/plugin/gallery/a/d:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/gallery/model/s$e;J)Ljava/lang/String;
    //   72: invokevirtual 192	java/lang/String:hashCode	()I
    //   75: istore 7
    //   77: aload_0
    //   78: getfield 124	com/tencent/mm/plugin/gallery/model/d:tQP	Lcom/tencent/mm/plugin/gallery/model/f;
    //   81: iload 7
    //   83: aload_3
    //   84: invokevirtual 195	com/tencent/mm/plugin/gallery/model/f:a	(ILandroid/graphics/Bitmap;)V
    //   87: aload 8
    //   89: monitorexit
    //   90: ldc 172
    //   92: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: return
    //   96: aload_1
    //   97: astore_2
    //   98: goto -34 -> 64
    //   101: astore_1
    //   102: aload 8
    //   104: monitorexit
    //   105: ldc 172
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
      if (this.tQP == null)
      {
        AppMethodBeat.o(179451);
        return null;
      }
      if (bu.isNullOrNil(paramString1))
      {
        paramString1 = com.tencent.mm.plugin.gallery.a.d.a(paramString2, parame, paramLong);
        int i = paramString1.hashCode();
        ae.d("MicroMsg.GalleryCache", "keyStr: %s keyInt: %s.", new Object[] { paramString1, Integer.valueOf(i) });
        paramString1 = this.tQP.HE(i);
        AppMethodBeat.o(179451);
        return paramString1;
      }
      paramString2 = paramString1;
    }
  }
  
  public final void cXm()
  {
    AppMethodBeat.i(111259);
    this.tQQ.clear();
    this.tQR.clear();
    AppMethodBeat.o(111259);
  }
  
  public final Bitmap getBitmap(String paramString)
  {
    AppMethodBeat.i(111255);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.GalleryCache", "null filepath");
      AppMethodBeat.o(111255);
      return null;
    }
    if (this.tQO == null)
    {
      ae.w("MicroMsg.GalleryCache", "want to get bitmap, but gallery cache is null");
      AppMethodBeat.o(111255);
      return null;
    }
    if (this.tQO.aM(paramString))
    {
      Object localObject = (a)this.tQO.aL(paramString);
      if (localObject == null)
      {
        ae.d("MicroMsg.GalleryCache", "weakreference is null! %s", new Object[] { paramString });
        this.tQO.remove(paramString);
        AppMethodBeat.o(111255);
        return null;
      }
      localObject = ((a)localObject).bitmap;
      if (localObject != null)
      {
        if (((Bitmap)localObject).isRecycled())
        {
          ae.i("MicroMsg.GalleryCache", "cache bitmap has recycled: %s", new Object[] { paramString });
          this.tQO.remove(paramString);
          AppMethodBeat.o(111255);
          return null;
        }
        ae.i("MicroMsg.GalleryCache", "get cached bitmap:".concat(String.valueOf(paramString)));
        AppMethodBeat.o(111255);
        return localObject;
      }
      this.tQO.remove(paramString);
      ae.i("MicroMsg.GalleryCache", "get bitmap is null! %s", new Object[] { paramString });
    }
    AppMethodBeat.o(111255);
    return null;
  }
  
  final class a
  {
    Bitmap bitmap;
    private int type;
    
    public a(Bitmap paramBitmap, int paramInt)
    {
      this.bitmap = paramBitmap;
      this.type = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.d
 * JD-Core Version:    0.7.0.1
 */