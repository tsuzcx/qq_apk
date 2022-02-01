package com.tencent.mm.plugin.gallery.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  public d xhN;
  int xhO;
  public h<String> xhP;
  public HashMap<String, c> xhQ;
  int xhR;
  private h<b> xhS;
  h<b> xhT;
  
  public c()
  {
    AppMethodBeat.i(111240);
    this.xhN = new d();
    this.xhO = g.DEFAULT_CORE_POOL_SIZE;
    this.xhP = new h();
    this.xhQ = new HashMap();
    this.xhR = (g.DEFAULT_CORE_POOL_SIZE / 2);
    this.xhS = new h();
    this.xhT = new h();
    AppMethodBeat.o(111240);
  }
  
  public final Bitmap a(String paramString1, int paramInt, String paramString2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(179444);
    paramString1 = a(paramString1, paramInt, paramString2, paramLong1, null, -1, paramLong2);
    AppMethodBeat.o(179444);
    return paramString1;
  }
  
  public final Bitmap a(String paramString1, int paramInt1, String paramString2, long paramLong1, s.e parame, int paramInt2, long paramLong2)
  {
    AppMethodBeat.i(179445);
    if (Util.isNullOrNil(paramString1))
    {
      Log.w("MicroMsg.CacheService", "file path is invalid.");
      AppMethodBeat.o(179445);
      return null;
    }
    String str = com.tencent.mm.plugin.gallery.a.d.a(paramString1, parame, paramInt2);
    Object localObject = com.tencent.mm.plugin.gallery.a.d.a(paramString1, parame, paramLong2);
    localObject = this.xhN.getBitmap((String)localObject);
    if (localObject != null)
    {
      Log.v("MicroMsg.CacheService", "get bitmap from cache: %s.", new Object[] { paramString1 });
      AppMethodBeat.o(179445);
      return localObject;
    }
    Log.d("MicroMsg.CacheService", "waitingDecodeTask size is : [%d].", new Object[] { Integer.valueOf(this.xhQ.size()) });
    if (this.xhQ.containsKey(str))
    {
      Log.w("MicroMsg.CacheService", "%s has already getting bitmap from file, %s.", new Object[] { str, paramString1 });
      AppMethodBeat.o(179445);
      return null;
    }
    this.xhP.add(str);
    paramString1 = new c(paramString1, paramInt1, paramString2, paramLong1, parame, paramInt2, paramLong2);
    this.xhQ.put(str, paramString1);
    Log.d("MicroMsg.CacheService", "add task: %s.", new Object[] { str });
    Log.d("MicroMsg.CacheService", "filePathInService size: %s, waitingDecodeTask size: %s.", new Object[] { Integer.valueOf(this.xhP.size()), Integer.valueOf(this.xhQ.size()) });
    dQy();
    AppMethodBeat.o(179445);
    return null;
  }
  
  public final Bitmap a(String paramString1, String paramString2, s.e parame, long paramLong)
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
    paramString1 = this.xhN.getBitmap(com.tencent.mm.plugin.gallery.a.d.a(paramString2, parame, paramLong));
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
    d locald = this.xhN;
    Log.d("MicroMsg.GalleryCache", "try add listener[%s].", new Object[] { paramb });
    if (locald.xid.size() > 256)
    {
      Log.d("MicroMsg.GalleryCache", "start clear logic: %s.", new Object[] { Integer.valueOf(locald.xid.size()) });
      int i = 0;
      while (i < 128)
      {
        String str = (String)locald.xid.get(i);
        if (!Util.isNullOrNil(str)) {
          locald.xie.remove(str);
        }
        i += 1;
      }
      locald.xid.subList(0, 128).clear();
      Log.d("MicroMsg.GalleryCache", "finish clear logic: %s.", new Object[] { Integer.valueOf(locald.xid.size()) });
    }
    if (Util.isNullOrNil(paramb.dQG()))
    {
      Log.e("MicroMsg.GalleryCache", "error! fileKey is invalid!!!");
      AppMethodBeat.o(111245);
      return;
    }
    if (locald.xie.containsKey(paramb.dQG()))
    {
      Log.d("MicroMsg.GalleryCache", "listener already exist!!! %s, update!!!.", new Object[] { paramb });
      locald.xid.remove(paramb.dQG());
      locald.xid.add(paramb.dQG());
      locald.xie.put(paramb.dQG(), paramb);
      AppMethodBeat.o(111245);
      return;
    }
    Log.d("MicroMsg.GalleryCache", "add listener[%s] ok.", new Object[] { paramb });
    locald.xid.add(paramb.dQG());
    locald.xie.put(paramb.dQG(), paramb);
    AppMethodBeat.o(111245);
  }
  
  public final void b(d.b paramb)
  {
    AppMethodBeat.i(111246);
    d locald = this.xhN;
    if (paramb == null)
    {
      locald.dQF();
      locald.iKx.removeAll();
      AppMethodBeat.o(111246);
      return;
    }
    String str = paramb.dQG();
    if (locald.xie.containsKey(paramb.dQG()))
    {
      locald.xie.remove(str);
      locald.xid.remove(str);
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
    String str = com.tencent.mm.plugin.gallery.a.d.a(paramString1, null, -1);
    Object localObject = com.tencent.mm.plugin.gallery.a.d.a(paramString1, null, paramLong2);
    localObject = this.xhN.getBitmap((String)localObject);
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      Log.v("MicroMsg.CacheService", "trySubmitPreDecodeTask, no need decode.");
      AppMethodBeat.o(179447);
      return;
    }
    Log.d("MicroMsg.CacheService", "pre decode info: %s %s stack %s.", new Object[] { str, paramString1, Util.getStack() });
    if (this.xhS.size() > 82) {
      Log.d("MicroMsg.CacheService", "remove task: %s.", new Object[] { b.a((b)this.xhS.dRl()) });
    }
    paramString1 = new b(paramString1, paramInt, paramString2, paramLong1, paramLong2);
    this.xhS.add(paramString1);
    dQD();
    AppMethodBeat.o(179447);
  }
  
  final void dQA()
  {
    this.xhO -= 1;
  }
  
  final boolean dQB()
  {
    return this.xhR > 0;
  }
  
  final void dQC()
  {
    this.xhR -= 1;
  }
  
  public final void dQD()
  {
    AppMethodBeat.i(111249);
    Log.d("MicroMsg.CacheService", "tryStartPreDecode: %s %s.", new Object[] { Integer.valueOf(this.xhS.size()), Integer.valueOf(this.xhT.size()) });
    e.dQL().a(this.xhS, this.xhT);
    AppMethodBeat.o(111249);
  }
  
  public final void dQE()
  {
    AppMethodBeat.i(111250);
    Iterator localIterator = this.xhT.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb != null) {
        localb.mCancel = true;
      }
    }
    this.xhT.clear();
    this.xhS.clear();
    AppMethodBeat.o(111250);
  }
  
  final void dQy()
  {
    AppMethodBeat.i(111244);
    e.dQL().a(this.xhP, this.xhQ);
    AppMethodBeat.o(111244);
  }
  
  final boolean dQz()
  {
    return this.xhO > 0;
  }
  
  public final void eT(List<String> paramList)
  {
    AppMethodBeat.i(111247);
    if ((this.xhQ != null) && (!this.xhQ.isEmpty()))
    {
      Object localObject = new ArrayList();
      Iterator localIterator = this.xhQ.entrySet().iterator();
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
          ((ArrayList)localObject).add(localEntry.getKey());
        }
      }
      Log.d("MicroMsg.CacheService", "cancelTask, counter: %s.", new Object[] { Integer.valueOf(((ArrayList)localObject).size()) });
      paramList = ((ArrayList)localObject).iterator();
      while (paramList.hasNext())
      {
        localObject = (String)paramList.next();
        this.xhP.dr(localObject);
        this.xhQ.remove(localObject);
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
    Bitmap bitmap;
    volatile boolean mCancel;
    String mFilePath;
    private int mediaType;
    private String xhV;
    private long xhW;
    int xhX;
    long xhY;
    
    public b(String paramString1, int paramInt, String paramString2, long paramLong1, long paramLong2)
    {
      super();
      this.mFilePath = paramString1;
      this.mediaType = paramInt;
      this.xhV = paramString2;
      this.xhW = paramLong1;
      this.xhX = 12288;
      this.xhY = paramLong2;
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
      this.bitmap = c.this.xhN.b(this.mFilePath, this.xhV, null, this.xhY);
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
      this.bitmap = n.a(this.xhW, this.mediaType, this.mFilePath, this.xhV);
      if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
      {
        Log.d("MicroMsg.PreDecodeFile", "get bmp from file ok, filePath[%s].", new Object[] { this.mFilePath });
        c.this.xhN.a(this.mFilePath, this.xhV, this.bitmap, null, this.xhY);
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
    Bitmap bitmap;
    public volatile boolean mCancel;
    String mFilePath;
    int mPosition;
    private int mediaType;
    private String xhV;
    private long xhW;
    int xhX;
    long xhY;
    s.e xhZ;
    String xia;
    
    c(String paramString1, int paramInt1, String paramString2, long paramLong1, s.e parame, int paramInt2, long paramLong2)
    {
      this(paramString1, paramInt1, paramString2, paramLong1, parame, paramInt2, paramLong2, (byte)0);
    }
    
    private c(String paramString1, int paramInt1, String paramString2, long paramLong1, s.e parame, int paramInt2, long paramLong2, byte paramByte)
    {
      super();
      AppMethodBeat.i(179443);
      this.mFilePath = paramString1;
      this.mediaType = paramInt1;
      this.xhV = paramString2;
      this.xhW = paramLong1;
      this.xhX = 12288;
      this.xhZ = parame;
      this.mPosition = paramInt2;
      this.xhY = paramLong2;
      this.xia = com.tencent.mm.plugin.gallery.a.d.a(paramString1, parame, paramInt2);
      AppMethodBeat.o(179443);
    }
    
    public final boolean doInBackground()
    {
      AppMethodBeat.i(111237);
      Log.d("MicroMsg.CacheService", "task execute, mDecodeTaskKey: %s, filePath: %s, isCancel: %s.", new Object[] { this.xia, this.mFilePath, Boolean.valueOf(this.mCancel) });
      if (this.mCancel)
      {
        AppMethodBeat.o(111237);
        return false;
      }
      this.bitmap = c.this.xhN.b(this.mFilePath, this.xhV, this.xhZ, this.xhY);
      if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
      {
        Log.d("MicroMsg.CacheService", "get bmp from disk cache ok, mDecodeTaskKey[%s] filePath[%s].", new Object[] { this.xia, this.mFilePath });
        AppMethodBeat.o(111237);
        return true;
      }
      if (this.mCancel)
      {
        AppMethodBeat.o(111237);
        return false;
      }
      if (this.xhZ != null)
      {
        this.bitmap = n.a(this.mFilePath, this.xhZ);
        if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
        {
          Log.d("MicroMsg.CacheService", "getPortraitBitmap ok, mDecodeTaskKey[%s] filePath[%s].", new Object[] { this.xia, this.mFilePath });
          AppMethodBeat.o(111237);
          return true;
        }
        Log.d("MicroMsg.CacheService", "getPortraitBitmap err, mDecodeTaskKey[%s] filePath[%s].", new Object[] { this.xia, this.mFilePath });
      }
      if (this.mCancel)
      {
        AppMethodBeat.o(111237);
        return false;
      }
      this.bitmap = n.a(this.xhW, this.mediaType, this.mFilePath, this.xhV);
      if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
      {
        c.this.xhN.a(this.mFilePath, this.xhV, this.bitmap, this.xhZ, this.xhY);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.c
 * JD-Core Version:    0.7.0.1
 */