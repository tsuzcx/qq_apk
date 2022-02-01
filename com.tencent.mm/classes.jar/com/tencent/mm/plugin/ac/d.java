package com.tencent.mm.plugin.ac;

import com.tencent.mm.model.cn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mvvmstorage/MvvmDB;", "Lcom/tencent/mm/plugin/mvvmstorage/BaseMvvmDB;", "()V", "db", "Lcom/tencent/mm/storagebase/SqliteDB;", "isCreated", "", "create", "dbPath", "", "getDB", "onCleared", "", "Companion", "plugin-mvvmstorage_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class d
  extends a
{
  public static final a MnN = new a((byte)0);
  private volatile boolean feX;
  public h omV;
  
  public final boolean aPK(String paramString)
  {
    s.u(paramString, "dbPath");
    if ((!this.feX) && (this.omV == null))
    {
      long l1 = cn.bDw();
      Object localObject1 = y.bEo(paramString);
      if (!y.ZC((String)localObject1)) {
        y.bDX((String)localObject1);
      }
      this.omV = new h();
      localObject1 = collectFinderDatabaseFactory();
      Object localObject2 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String[] arrayOfString = ((h.b)((Map.Entry)((Iterator)localObject2).next()).getValue()).getSQLs();
        if (arrayOfString != null)
        {
          int j = arrayOfString.length;
          int i = 0;
          while (i < j)
          {
            Log.i("MicroMsg.Mvvm.MvvmDB", s.X("run sql: ", arrayOfString[i]));
            i += 1;
          }
        }
      }
      localObject2 = this.omV;
      if (localObject2 == null) {}
      for (localObject1 = null;; localObject1 = Boolean.valueOf(((h)localObject2).a(paramString, (HashMap)localObject1, true)))
      {
        if (!s.p(localObject1, Boolean.TRUE))
        {
          Log.i("MicroMsg.Mvvm.MvvmDB", s.X("create db error, dbPath:", paramString));
          this.omV = null;
        }
        gsz();
        long l2 = cn.bDw();
        this.feX = true;
        Log.i("MicroMsg.Mvvm.MvvmDB", "initDB params %d %s %s", new Object[] { Long.valueOf(l2 - l1), Util.getSizeMB(y.bEl(paramString), 100.0D), paramString });
        if (localObject1 != null) {
          break;
        }
        return false;
      }
      return ((Boolean)localObject1).booleanValue();
    }
    return false;
  }
  
  public final h getDB()
  {
    return this.omV;
  }
  
  public void onCleared()
  {
    super.onCleared();
    this.omV = null;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mvvmstorage/MvvmDB$Companion;", "", "()V", "TAG", "", "plugin-mvvmstorage_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ac.d
 * JD-Core Version:    0.7.0.1
 */