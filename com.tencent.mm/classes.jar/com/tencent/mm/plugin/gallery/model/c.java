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
  public d BUa;
  int BUb;
  public h<String> BUc;
  public HashMap<String, c> BUd;
  int BUe;
  private h<b> BUf;
  h<b> BUg;
  
  public c()
  {
    AppMethodBeat.i(111240);
    this.BUa = new d();
    this.BUb = g.DEFAULT_CORE_POOL_SIZE;
    this.BUc = new h();
    this.BUd = new HashMap();
    this.BUe = (g.DEFAULT_CORE_POOL_SIZE / 2);
    this.BUf = new h();
    this.BUg = new h();
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
    String str = com.tencent.mm.plugin.gallery.a.e.a(paramString1, parame, paramInt2);
    Object localObject = com.tencent.mm.plugin.gallery.a.e.a(paramString1, parame, paramLong2);
    localObject = this.BUa.JL((String)localObject);
    if (localObject != null)
    {
      Log.v("MicroMsg.CacheService", "get bitmap from cache: %s.", new Object[] { paramString1 });
      AppMethodBeat.o(179445);
      return localObject;
    }
    Log.d("MicroMsg.CacheService", "waitingDecodeTask size is : [%d].", new Object[] { Integer.valueOf(this.BUd.size()) });
    if (this.BUd.containsKey(str))
    {
      Log.w("MicroMsg.CacheService", "%s has already getting bitmap from file, %s.", new Object[] { str, paramString1 });
      AppMethodBeat.o(179445);
      return null;
    }
    this.BUc.add(str);
    paramString1 = new c(paramString1, paramInt1, paramString2, paramLong1, parame, paramInt2, paramLong2);
    this.BUd.put(str, paramString1);
    Log.d("MicroMsg.CacheService", "add task: %s.", new Object[] { str });
    Log.d("MicroMsg.CacheService", "filePathInService size: %s, waitingDecodeTask size: %s.", new Object[] { Integer.valueOf(this.BUc.size()), Integer.valueOf(this.BUd.size()) });
    esZ();
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
    paramString1 = this.BUa.JL(com.tencent.mm.plugin.gallery.a.e.a(paramString2, parame, paramLong));
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
    d locald = this.BUa;
    Log.d("MicroMsg.GalleryCache", "try add listener[%s].", new Object[] { paramb });
    if (locald.BUq.size() > 256)
    {
      Log.d("MicroMsg.GalleryCache", "start clear logic: %s.", new Object[] { Integer.valueOf(locald.BUq.size()) });
      int i = 0;
      while (i < 128)
      {
        String str = (String)locald.BUq.get(i);
        if (!Util.isNullOrNil(str)) {
          locald.BUr.remove(str);
        }
        i += 1;
      }
      locald.BUq.subList(0, 128).clear();
      Log.d("MicroMsg.GalleryCache", "finish clear logic: %s.", new Object[] { Integer.valueOf(locald.BUq.size()) });
    }
    if (Util.isNullOrNil(paramb.eth()))
    {
      Log.e("MicroMsg.GalleryCache", "error! fileKey is invalid!!!");
      AppMethodBeat.o(111245);
      return;
    }
    if (locald.BUr.containsKey(paramb.eth()))
    {
      Log.d("MicroMsg.GalleryCache", "listener already exist!!! %s, update!!!.", new Object[] { paramb });
      locald.BUq.remove(paramb.eth());
      locald.BUq.add(paramb.eth());
      locald.BUr.put(paramb.eth(), paramb);
      AppMethodBeat.o(111245);
      return;
    }
    Log.d("MicroMsg.GalleryCache", "add listener[%s] ok.", new Object[] { paramb });
    locald.BUq.add(paramb.eth());
    locald.BUr.put(paramb.eth(), paramb);
    AppMethodBeat.o(111245);
  }
  
  public final void b(d.b paramb)
  {
    AppMethodBeat.i(111246);
    d locald = this.BUa;
    if (paramb == null)
    {
      locald.etg();
      locald.lAD.removeAll();
      AppMethodBeat.o(111246);
      return;
    }
    String str = paramb.eth();
    if (locald.BUr.containsKey(paramb.eth()))
    {
      locald.BUr.remove(str);
      locald.BUq.remove(str);
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
    String str = com.tencent.mm.plugin.gallery.a.e.a(paramString1, null, -1);
    Object localObject = com.tencent.mm.plugin.gallery.a.e.a(paramString1, null, paramLong2);
    localObject = this.BUa.JL((String)localObject);
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      Log.v("MicroMsg.CacheService", "trySubmitPreDecodeTask, no need decode.");
      AppMethodBeat.o(179447);
      return;
    }
    Log.d("MicroMsg.CacheService", "pre decode info: %s %s stack %s.", new Object[] { str, paramString1, Util.getStack() });
    if (this.BUf.size() > 82) {
      Log.d("MicroMsg.CacheService", "remove task: %s.", new Object[] { b.a((b)this.BUf.etN()) });
    }
    paramString1 = new b(paramString1, paramInt, paramString2, paramLong1, paramLong2);
    this.BUf.add(paramString1);
    ete();
    AppMethodBeat.o(179447);
  }
  
  final void esZ()
  {
    AppMethodBeat.i(111244);
    e.etm().a(this.BUc, this.BUd);
    AppMethodBeat.o(111244);
  }
  
  final boolean eta()
  {
    return this.BUb > 0;
  }
  
  final void etb()
  {
    this.BUb -= 1;
  }
  
  final boolean etc()
  {
    return this.BUe > 0;
  }
  
  final void etd()
  {
    this.BUe -= 1;
  }
  
  public final void ete()
  {
    AppMethodBeat.i(111249);
    Log.d("MicroMsg.CacheService", "tryStartPreDecode: %s %s.", new Object[] { Integer.valueOf(this.BUf.size()), Integer.valueOf(this.BUg.size()) });
    e.etm().a(this.BUf, this.BUg);
    AppMethodBeat.o(111249);
  }
  
  public final void etf()
  {
    AppMethodBeat.i(111250);
    Iterator localIterator = this.BUg.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb != null) {
        localb.mCancel = true;
      }
    }
    this.BUg.clear();
    this.BUf.clear();
    AppMethodBeat.o(111250);
  }
  
  public final void fj(List<String> paramList)
  {
    AppMethodBeat.i(111247);
    if ((this.BUd != null) && (!this.BUd.isEmpty()))
    {
      Object localObject = new ArrayList();
      Iterator localIterator = this.BUd.entrySet().iterator();
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
        this.BUc.dv(localObject);
        this.BUd.remove(localObject);
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
    private String BUi;
    private long BUj;
    int BUk;
    long BUl;
    Bitmap bitmap;
    volatile boolean mCancel;
    String mFilePath;
    private int mediaType;
    
    public b(String paramString1, int paramInt, String paramString2, long paramLong1, long paramLong2)
    {
      super();
      this.mFilePath = paramString1;
      this.mediaType = paramInt;
      this.BUi = paramString2;
      this.BUj = paramLong1;
      this.BUk = 12288;
      this.BUl = paramLong2;
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
      this.bitmap = c.this.BUa.b(this.mFilePath, this.BUi, null, this.BUl);
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
      this.bitmap = n.a(this.BUj, this.mediaType, this.mFilePath, this.BUi);
      if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
      {
        Log.d("MicroMsg.PreDecodeFile", "get bmp from file ok, filePath[%s].", new Object[] { this.mFilePath });
        c.this.BUa.a(this.mFilePath, this.BUi, this.bitmap, null, this.BUl);
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
    private String BUi;
    private long BUj;
    int BUk;
    long BUl;
    s.e BUm;
    String BUn;
    Bitmap bitmap;
    public volatile boolean mCancel;
    String mFilePath;
    int mPosition;
    private int mediaType;
    
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
      this.BUi = paramString2;
      this.BUj = paramLong1;
      this.BUk = 12288;
      this.BUm = parame;
      this.mPosition = paramInt2;
      this.BUl = paramLong2;
      this.BUn = com.tencent.mm.plugin.gallery.a.e.a(paramString1, parame, paramInt2);
      AppMethodBeat.o(179443);
    }
    
    public final boolean doInBackground()
    {
      AppMethodBeat.i(111237);
      Log.d("MicroMsg.CacheService", "task execute, mDecodeTaskKey: %s, filePath: %s, isCancel: %s.", new Object[] { this.BUn, this.mFilePath, Boolean.valueOf(this.mCancel) });
      if (this.mCancel)
      {
        AppMethodBeat.o(111237);
        return false;
      }
      this.bitmap = c.this.BUa.b(this.mFilePath, this.BUi, this.BUm, this.BUl);
      if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
      {
        Log.d("MicroMsg.CacheService", "get bmp from disk cache ok, mDecodeTaskKey[%s] filePath[%s].", new Object[] { this.BUn, this.mFilePath });
        AppMethodBeat.o(111237);
        return true;
      }
      if (this.mCancel)
      {
        AppMethodBeat.o(111237);
        return false;
      }
      if (this.BUm != null)
      {
        this.bitmap = n.a(this.mFilePath, this.BUm);
        if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
        {
          Log.d("MicroMsg.CacheService", "getPortraitBitmap ok, mDecodeTaskKey[%s] filePath[%s].", new Object[] { this.BUn, this.mFilePath });
          AppMethodBeat.o(111237);
          return true;
        }
        Log.d("MicroMsg.CacheService", "getPortraitBitmap err, mDecodeTaskKey[%s] filePath[%s].", new Object[] { this.BUn, this.mFilePath });
      }
      if (this.mCancel)
      {
        AppMethodBeat.o(111237);
        return false;
      }
      this.bitmap = n.a(this.BUj, this.mediaType, this.mFilePath, this.BUi);
      if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
      {
        c.this.BUa.a(this.mFilePath, this.BUi, this.bitmap, this.BUm, this.BUl);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.c
 * JD-Core Version:    0.7.0.1
 */