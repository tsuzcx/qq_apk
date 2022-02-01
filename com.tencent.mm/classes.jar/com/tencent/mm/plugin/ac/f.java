package com.tencent.mm.plugin.ac;

import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.b;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mvvmstorage/MvvmMainDBExt;", "Lcom/tencent/mm/plugin/mvvmstorage/BaseMvvmDB;", "()V", "db", "Lcom/tencent/mm/storagebase/SqliteDB;", "isCreated", "", "create", "", "mainDB", "getDB", "onCleared", "Companion", "plugin-mvvmstorage_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class f
  extends a
{
  public static final a MnO = new a((byte)0);
  private volatile boolean feX;
  private h omV;
  
  public final void g(h paramh)
  {
    s.u(paramh, "mainDB");
    if ((!this.feX) && (this.omV == null))
    {
      this.omV = paramh;
      paramh = ((Map)collectFinderDatabaseFactory()).entrySet().iterator();
      while (paramh.hasNext())
      {
        String[] arrayOfString = ((h.b)((Map.Entry)paramh.next()).getValue()).getSQLs();
        if (arrayOfString != null)
        {
          int j = arrayOfString.length;
          int i = 0;
          while (i < j)
          {
            String str = arrayOfString[i];
            Log.i("MicroMsg.Mvvm.MvvmMainDBExt", s.X("run sql: ", str));
            h localh = this.omV;
            if (localh != null) {
              localh.execSQL("", str);
            }
            i += 1;
          }
        }
      }
      gsz();
      this.feX = true;
    }
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
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mvvmstorage/MvvmMainDBExt$Companion;", "", "()V", "TAG", "", "plugin-mvvmstorage_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ac.f
 * JD-Core Version:    0.7.0.1
 */