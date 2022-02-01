package com.tencent.mm.plugin.gallery.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.b.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class c
{
  private i<b> HGA;
  i<b> HGB;
  public d HGv;
  int HGw;
  public i<String> HGx;
  public HashMap<String, c> HGy;
  int HGz;
  
  public c()
  {
    AppMethodBeat.i(111240);
    this.HGv = new d();
    this.HGw = g.HHl;
    this.HGx = new i();
    this.HGy = new HashMap();
    this.HGz = (g.HHl / 2);
    this.HGA = new i();
    this.HGB = new i();
    AppMethodBeat.o(111240);
  }
  
  public final Bitmap a(String paramString1, int paramInt, String paramString2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(179444);
    paramString1 = a(paramString1, paramInt, paramString2, paramLong1, null, -1, paramLong2);
    AppMethodBeat.o(179444);
    return paramString1;
  }
  
  public final Bitmap a(String paramString1, int paramInt1, String paramString2, long paramLong1, t.e parame, int paramInt2, long paramLong2)
  {
    AppMethodBeat.i(179445);
    if (Util.isNullOrNil(paramString1))
    {
      Log.w("MicroMsg.CacheService", "file path is invalid.");
      AppMethodBeat.o(179445);
      return null;
    }
    String str = h.a(paramString1, parame, paramInt2);
    Object localObject = h.a(paramString1, parame, paramLong2);
    localObject = this.HGv.Cr((String)localObject);
    if (localObject != null)
    {
      Log.v("MicroMsg.CacheService", "get bitmap from cache: %s.", new Object[] { paramString1 });
      AppMethodBeat.o(179445);
      return localObject;
    }
    Log.d("MicroMsg.CacheService", "waitingDecodeTask size is : [%d].", new Object[] { Integer.valueOf(this.HGy.size()) });
    if (this.HGy.containsKey(str))
    {
      Log.w("MicroMsg.CacheService", "%s has already getting bitmap from file, %s.", new Object[] { str, paramString1 });
      AppMethodBeat.o(179445);
      return null;
    }
    this.HGx.add(str);
    paramString1 = new c(paramString1, paramInt1, paramString2, paramLong1, parame, paramInt2, paramLong2);
    this.HGy.put(str, paramString1);
    Log.d("MicroMsg.CacheService", "add task: %s.", new Object[] { str });
    Log.d("MicroMsg.CacheService", "filePathInService size: %s, waitingDecodeTask size: %s.", new Object[] { Integer.valueOf(this.HGx.size()), Integer.valueOf(this.HGy.size()) });
    fAb();
    AppMethodBeat.o(179445);
    return null;
  }
  
  public final Bitmap a(String paramString1, String paramString2, t.e parame, long paramLong)
  {
    AppMethodBeat.i(179446);
    if (Util.isNullOrNil(paramString1)) {}
    while (Util.isNullOrNil(paramString2))
    {
      Log.w("MicroMsg.CacheService", "file path is null or nil.");
      AppMethodBeat.o(179446);
      return null;
      paramString2 = paramString1;
    }
    paramString1 = this.HGv.Cr(h.a(paramString2, parame, paramLong));
    if (paramString1 != null)
    {
      Log.v("MicroMsg.CacheService", "get bitmap from cache: %s.", new Object[] { paramString2 });
      AppMethodBeat.o(179446);
      return paramString1;
    }
    AppMethodBeat.o(179446);
    return null;
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(111245);
    d locald = this.HGv;
    Log.d("MicroMsg.GalleryCache", "try add listener[%s].", new Object[] { paramb });
    if (locald.HGL.size() > 256)
    {
      Log.d("MicroMsg.GalleryCache", "start clear logic: %s.", new Object[] { Integer.valueOf(locald.HGL.size()) });
      int i = 0;
      while (i < 128)
      {
        String str = (String)locald.HGL.get(i);
        if (!Util.isNullOrNil(str)) {
          locald.HGM.remove(str);
        }
        i += 1;
      }
      locald.HGL.subList(0, 128).clear();
      Log.d("MicroMsg.GalleryCache", "finish clear logic: %s.", new Object[] { Integer.valueOf(locald.HGL.size()) });
    }
    if (Util.isNullOrNil(paramb.fAj()))
    {
      Log.e("MicroMsg.GalleryCache", "error! fileKey is invalid!!!");
      AppMethodBeat.o(111245);
      return;
    }
    if (locald.HGM.containsKey(paramb.fAj()))
    {
      Log.d("MicroMsg.GalleryCache", "listener already exist!!! %s, update!!!.", new Object[] { paramb });
      locald.HGL.remove(paramb.fAj());
      locald.HGL.add(paramb.fAj());
      locald.HGM.put(paramb.fAj(), paramb);
      AppMethodBeat.o(111245);
      return;
    }
    Log.d("MicroMsg.GalleryCache", "add listener[%s] ok.", new Object[] { paramb });
    locald.HGL.add(paramb.fAj());
    locald.HGM.put(paramb.fAj(), paramb);
    AppMethodBeat.o(111245);
  }
  
  public final void b(d.b paramb)
  {
    AppMethodBeat.i(111246);
    d locald = this.HGv;
    if (paramb == null)
    {
      locald.fAi();
      locald.ose.removeAll();
      AppMethodBeat.o(111246);
      return;
    }
    String str = paramb.fAj();
    if (locald.HGM.containsKey(paramb.fAj()))
    {
      locald.HGM.remove(str);
      locald.HGL.remove(str);
    }
    AppMethodBeat.o(111246);
  }
  
  public final void b(String paramString1, int paramInt, String paramString2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(179447);
    if (Util.isNullOrNil(paramString1))
    {
      Log.w("MicroMsg.CacheService", "trySubmitPreDecodeTask, file path is invalid.");
      AppMethodBeat.o(179447);
      return;
    }
    String str = h.a(paramString1, null, -1);
    Object localObject = h.a(paramString1, null, paramLong2);
    localObject = this.HGv.Cr((String)localObject);
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      Log.v("MicroMsg.CacheService", "trySubmitPreDecodeTask, no need decode.");
      AppMethodBeat.o(179447);
      return;
    }
    Log.d("MicroMsg.CacheService", "pre decode info: %s %s stack %s.", new Object[] { str, paramString1, Util.getStack() });
    if (this.HGA.size() > 82) {
      Log.d("MicroMsg.CacheService", "remove task: %s.", new Object[] { b.a((b)this.HGA.fAN()) });
    }
    paramString1 = new b(paramString1, paramInt, paramString2, paramLong1, paramLong2);
    this.HGA.add(paramString1);
    fAg();
    AppMethodBeat.o(179447);
  }
  
  final void fAb()
  {
    AppMethodBeat.i(111244);
    e.fAo().a(this.HGx, this.HGy);
    AppMethodBeat.o(111244);
  }
  
  final boolean fAc()
  {
    return this.HGw > 0;
  }
  
  final void fAd()
  {
    this.HGw -= 1;
  }
  
  final boolean fAe()
  {
    return this.HGz > 0;
  }
  
  final void fAf()
  {
    this.HGz -= 1;
  }
  
  public final void fAg()
  {
    AppMethodBeat.i(111249);
    Log.d("MicroMsg.CacheService", "tryStartPreDecode: %s %s.", new Object[] { Integer.valueOf(this.HGA.size()), Integer.valueOf(this.HGB.size()) });
    e.fAo().a(this.HGA, this.HGB);
    AppMethodBeat.o(111249);
  }
  
  public final void fAh()
  {
    AppMethodBeat.i(111250);
    Iterator localIterator = this.HGB.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb != null) {
        localb.mCancel = true;
      }
    }
    this.HGB.clear();
    this.HGA.clear();
    AppMethodBeat.o(111250);
  }
  
  public final void hZ(List<String> paramList)
  {
    AppMethodBeat.i(111247);
    if ((this.HGy != null) && (!this.HGy.isEmpty()))
    {
      Object localObject = new ArrayList();
      Iterator localIterator = this.HGy.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (!paramList.contains(localEntry.getKey()))
        {
          c localc = (c)localEntry.getValue();
          if (localc != null) {
            localc.mCancel = true;
          }
          Log.d("MicroMsg.CacheService", "cancelTask, success : %s.", new Object[] { localEntry.getKey() });
          ((ArrayList)localObject).add((String)localEntry.getKey());
        }
      }
      Log.d("MicroMsg.CacheService", "cancelTask, counter: %s.", new Object[] { Integer.valueOf(((ArrayList)localObject).size()) });
      paramList = ((ArrayList)localObject).iterator();
      while (paramList.hasNext())
      {
        localObject = (String)paramList.next();
        this.HGx.fK(localObject);
        this.HGy.remove(localObject);
      }
    }
    AppMethodBeat.o(111247);
  }
  
  public abstract class a
    implements QueueWorkerThread.ThreadObject
  {
    public a() {}
    
    public boolean onPostExecute()
    {
      return false;
    }
  }
  
  public final class b
    extends c.a
  {
    private String HGD;
    private long HGE;
    int HGF;
    long HGG;
    Bitmap bitmap;
    volatile boolean mCancel;
    String mFilePath;
    private int mediaType;
    
    public b(String paramString1, int paramInt, String paramString2, long paramLong1, long paramLong2)
    {
      super();
      this.mFilePath = paramString1;
      this.mediaType = paramInt;
      this.HGD = paramString2;
      this.HGE = paramLong1;
      this.HGF = 12288;
      this.HGG = paramLong2;
    }
    
    public final boolean doInBackground()
    {
      AppMethodBeat.i(111235);
      Log.d("MicroMsg.PreDecodeFile", "start doInBackground.");
      if (this.mCancel)
      {
        AppMethodBeat.o(111235);
        return false;
      }
      this.bitmap = c.this.HGv.b(this.mFilePath, this.HGD, null, this.HGG);
      if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
      {
        Log.d("MicroMsg.PreDecodeFile", "get bmp from disk cache ok, filePath[%s].", new Object[] { this.mFilePath });
        AppMethodBeat.o(111235);
        return true;
      }
      if (this.mCancel)
      {
        AppMethodBeat.o(111235);
        return false;
      }
      this.bitmap = p.a(this.HGE, this.mediaType, this.mFilePath, this.HGD);
      if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
      {
        Log.d("MicroMsg.PreDecodeFile", "get bmp from file ok, filePath[%s].", new Object[] { this.mFilePath });
        c.this.HGv.a(this.mFilePath, this.HGD, this.bitmap, null, this.HGG);
        AppMethodBeat.o(111235);
        return true;
      }
      AppMethodBeat.o(111235);
      return false;
    }
  }
  
  public final class c
    extends c.a
  {
    private String HGD;
    private long HGE;
    int HGF;
    long HGG;
    t.e HGH;
    String HGI;
    Bitmap bitmap;
    public volatile boolean mCancel;
    String mFilePath;
    int mPosition;
    private int mediaType;
    
    c(String paramString1, int paramInt1, String paramString2, long paramLong1, t.e parame, int paramInt2, long paramLong2)
    {
      this(paramString1, paramInt1, paramString2, paramLong1, parame, paramInt2, paramLong2, (byte)0);
    }
    
    private c(String paramString1, int paramInt1, String paramString2, long paramLong1, t.e parame, int paramInt2, long paramLong2, byte paramByte)
    {
      super();
      AppMethodBeat.i(179443);
      this.mFilePath = paramString1;
      this.mediaType = paramInt1;
      this.HGD = paramString2;
      this.HGE = paramLong1;
      this.HGF = 12288;
      this.HGH = parame;
      this.mPosition = paramInt2;
      this.HGG = paramLong2;
      this.HGI = h.a(paramString1, parame, paramInt2);
      AppMethodBeat.o(179443);
    }
    
    public final boolean doInBackground()
    {
      AppMethodBeat.i(111237);
      Log.d("MicroMsg.CacheService", "task execute, mDecodeTaskKey: %s, filePath: %s, isCancel: %s.", new Object[] { this.HGI, this.mFilePath, Boolean.valueOf(this.mCancel) });
      if (this.mCancel)
      {
        AppMethodBeat.o(111237);
        return false;
      }
      this.bitmap = c.this.HGv.b(this.mFilePath, this.HGD, this.HGH, this.HGG);
      if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
      {
        Log.d("MicroMsg.CacheService", "get bmp from disk cache ok, mDecodeTaskKey[%s] filePath[%s].", new Object[] { this.HGI, this.mFilePath });
        AppMethodBeat.o(111237);
        return true;
      }
      if (this.mCancel)
      {
        AppMethodBeat.o(111237);
        return false;
      }
      if (this.HGH != null)
      {
        this.bitmap = p.a(this.mFilePath, this.HGH);
        if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
        {
          Log.d("MicroMsg.CacheService", "getPortraitBitmap ok, mDecodeTaskKey[%s] filePath[%s].", new Object[] { this.HGI, this.mFilePath });
          AppMethodBeat.o(111237);
          return true;
        }
        Log.d("MicroMsg.CacheService", "getPortraitBitmap err, mDecodeTaskKey[%s] filePath[%s].", new Object[] { this.HGI, this.mFilePath });
      }
      if (this.mCancel)
      {
        AppMethodBeat.o(111237);
        return false;
      }
      this.bitmap = p.a(this.HGE, this.mediaType, this.mFilePath, this.HGD);
      if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
      {
        c.this.HGv.a(this.mFilePath, this.HGD, this.bitmap, this.HGH, this.HGG);
        AppMethodBeat.o(111237);
        return true;
      }
      AppMethodBeat.o(111237);
      return false;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(111238);
      if (paramObject == null)
      {
        AppMethodBeat.o(111238);
        return false;
      }
      if (this == paramObject)
      {
        AppMethodBeat.o(111238);
        return true;
      }
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        boolean bool = Util.nullAs(this.mFilePath, "").equals(paramObject.mFilePath);
        AppMethodBeat.o(111238);
        return bool;
      }
      AppMethodBeat.o(111238);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(111239);
      int i = Util.nullAs(this.mFilePath, "").hashCode();
      AppMethodBeat.o(111239);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.c
 * JD-Core Version:    0.7.0.1
 */