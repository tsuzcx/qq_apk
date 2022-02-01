package com.tencent.mm.plugin.gallery.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f.a;
import com.tencent.mm.b.f.b;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.plugin.gallery.a.e;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEvent;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class d
{
  com.tencent.mm.b.f<String, a> BUo;
  f BUp;
  CopyOnWriteArrayList<String> BUq;
  ConcurrentHashMap<String, b> BUr;
  MStorageEvent<b, String> lAD;
  final byte[] lock;
  
  public d()
  {
    AppMethodBeat.i(111254);
    this.lAD = new MStorageEvent() {};
    this.BUq = new CopyOnWriteArrayList();
    this.BUr = new ConcurrentHashMap();
    this.lock = new byte[0];
    this.BUo = new b(200, new f.b() {}, getClass());
    f localf = new f();
    localf.BUL = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getInt("com.tencent.mm.gallery.cache.suffix", 0);
    Log.d("MicroMsg.DiskCache", "pennqin debug disk cache current suffix: %s.", new Object[] { Integer.valueOf(localf.BUL) });
    localf.etv();
    localf.SP(-1);
    this.BUp = localf;
    this.lAD.add(new b()
    {
      public final void aIr(String paramAnonymousString)
      {
        AppMethodBeat.i(179449);
        Log.d("MicroMsg.GalleryCache", "now listener size : " + d.this.BUr.size());
        Object localObject;
        if (BuildInfo.DEBUG)
        {
          localObject = d.this.BUr.entrySet().iterator();
          while (((Iterator)localObject).hasNext()) {
            Log.d("MicroMsg.GalleryCache", "decodeTaskKey: %s.", new Object[] { ((Map.Entry)((Iterator)localObject).next()).getKey() });
          }
        }
        Log.d("MicroMsg.GalleryCache", "will hit??? decodeTaskKey: %s.", new Object[] { paramAnonymousString });
        if (d.this.BUr.containsKey(paramAnonymousString))
        {
          Log.d("MicroMsg.GalleryCache", "hit!!!");
          localObject = (d.b)d.this.BUr.get(paramAnonymousString);
          if (localObject != null) {
            ((d.b)localObject).aIr(paramAnonymousString);
          }
          AppMethodBeat.o(179449);
          return;
        }
        Log.w("MicroMsg.GalleryCache", "not hit!!!");
        AppMethodBeat.o(179449);
      }
      
      public final String eth()
      {
        return "";
      }
    }, null);
    AppMethodBeat.o(111254);
  }
  
  public final Bitmap JL(String paramString)
  {
    AppMethodBeat.i(111255);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.GalleryCache", "null filepath");
      AppMethodBeat.o(111255);
      return null;
    }
    if (this.BUo == null)
    {
      Log.w("MicroMsg.GalleryCache", "want to get bitmap, but gallery cache is null");
      AppMethodBeat.o(111255);
      return null;
    }
    if (this.BUo.check(paramString))
    {
      Object localObject = (a)this.BUo.aX(paramString);
      if (localObject == null)
      {
        Log.d("MicroMsg.GalleryCache", "weakreference is null! %s", new Object[] { paramString });
        this.BUo.remove(paramString);
        AppMethodBeat.o(111255);
        return null;
      }
      localObject = ((a)localObject).bitmap;
      if (localObject != null)
      {
        if (((Bitmap)localObject).isRecycled())
        {
          Log.i("MicroMsg.GalleryCache", "cache bitmap has recycled: %s", new Object[] { paramString });
          this.BUo.remove(paramString);
          AppMethodBeat.o(111255);
          return null;
        }
        Log.i("MicroMsg.GalleryCache", "get cached bitmap:".concat(String.valueOf(paramString)));
        AppMethodBeat.o(111255);
        return localObject;
      }
      this.BUo.remove(paramString);
      Log.i("MicroMsg.GalleryCache", "get bitmap is null! %s", new Object[] { paramString });
    }
    AppMethodBeat.o(111255);
    return null;
  }
  
  public final void a(String paramString, Bitmap paramBitmap, int paramInt1, s.e parame, boolean paramBoolean, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(179450);
    if (this.BUo == null)
    {
      Log.e("MicroMsg.GalleryCache", "cache is null");
      AppMethodBeat.o(179450);
      return;
    }
    this.BUo.q(e.a(paramString, parame, paramLong), new a(BitmapUtil.checkImgInsideCanvasMaxBitmapSize(paramBitmap), paramInt1));
    if (!paramBoolean)
    {
      this.lAD.event(e.a(paramString, parame, paramInt2));
      this.lAD.doNotify();
    }
    AppMethodBeat.o(179450);
  }
  
  /* Error */
  public final void a(String paramString1, String paramString2, Bitmap paramBitmap, s.e parame, long paramLong)
  {
    // Byte code:
    //   0: ldc 239
    //   2: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 62	com/tencent/mm/plugin/gallery/model/d:lock	[B
    //   9: astore 8
    //   11: aload 8
    //   13: monitorenter
    //   14: aload_3
    //   15: ifnull +10 -> 25
    //   18: aload_3
    //   19: invokevirtual 187	android/graphics/Bitmap:isRecycled	()Z
    //   22: ifeq +19 -> 41
    //   25: ldc 151
    //   27: ldc 241
    //   29: invokestatic 157	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload 8
    //   34: monitorexit
    //   35: ldc 239
    //   37: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: return
    //   41: aload_0
    //   42: getfield 129	com/tencent/mm/plugin/gallery/model/d:BUp	Lcom/tencent/mm/plugin/gallery/model/f;
    //   45: ifnonnull +12 -> 57
    //   48: aload 8
    //   50: monitorexit
    //   51: ldc 239
    //   53: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: return
    //   57: aload_1
    //   58: invokestatic 149	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   61: ifeq +38 -> 99
    //   64: aload_2
    //   65: aload 4
    //   67: lload 5
    //   69: invokestatic 215	com/tencent/mm/plugin/gallery/a/e:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/gallery/model/s$e;J)Ljava/lang/String;
    //   72: invokevirtual 245	java/lang/String:hashCode	()I
    //   75: istore 7
    //   77: aload_0
    //   78: getfield 129	com/tencent/mm/plugin/gallery/model/d:BUp	Lcom/tencent/mm/plugin/gallery/model/f;
    //   81: iload 7
    //   83: aload_3
    //   84: invokestatic 221	com/tencent/mm/sdk/platformtools/BitmapUtil:checkImgInsideCanvasMaxBitmapSize	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   87: invokevirtual 248	com/tencent/mm/plugin/gallery/model/f:b	(ILandroid/graphics/Bitmap;)V
    //   90: aload 8
    //   92: monitorexit
    //   93: ldc 239
    //   95: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: return
    //   99: aload_1
    //   100: astore_2
    //   101: goto -37 -> 64
    //   104: astore_1
    //   105: aload 8
    //   107: monitorexit
    //   108: ldc 239
    //   110: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: aload_1
    //   114: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	this	d
    //   0	115	1	paramString1	String
    //   0	115	2	paramString2	String
    //   0	115	3	paramBitmap	Bitmap
    //   0	115	4	parame	s.e
    //   0	115	5	paramLong	long
    //   75	7	7	i	int
    //   9	97	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   18	25	104	finally
    //   25	35	104	finally
    //   41	51	104	finally
    //   57	64	104	finally
    //   64	93	104	finally
  }
  
  public final Bitmap b(String paramString1, String paramString2, s.e parame, long paramLong)
  {
    AppMethodBeat.i(179451);
    synchronized (this.lock)
    {
      if (this.BUp == null)
      {
        AppMethodBeat.o(179451);
        return null;
      }
      if (Util.isNullOrNil(paramString1))
      {
        paramString1 = e.a(paramString2, parame, paramLong);
        int i = paramString1.hashCode();
        Log.d("MicroMsg.GalleryCache", "keyStr: %s keyInt: %s.", new Object[] { paramString1, Integer.valueOf(i) });
        paramString1 = this.BUp.SS(i);
        AppMethodBeat.o(179451);
        return paramString1;
      }
      paramString2 = paramString1;
    }
  }
  
  public final void etg()
  {
    AppMethodBeat.i(111259);
    this.BUq.clear();
    this.BUr.clear();
    AppMethodBeat.o(111259);
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
  
  public static abstract interface b
  {
    public abstract void aIr(String paramString);
    
    public abstract String eth();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.d
 * JD-Core Version:    0.7.0.1
 */