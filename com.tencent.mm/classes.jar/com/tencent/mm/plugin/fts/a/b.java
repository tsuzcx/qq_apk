package com.tencent.mm.plugin.fts.a;

import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public abstract class b
  implements k
{
  public boolean feX;
  
  public b()
  {
    Log.i("MicroMsg.FTS.BaseFTS5SearchLogic", "Create %s", new Object[] { getName() });
  }
  
  public c a(l paraml)
  {
    return null;
  }
  
  public void a(String paramString, o paramo, int paramInt, HashMap<String, String> paramHashMap) {}
  
  protected abstract boolean aXx();
  
  public void addSOSHistory(String paramString1, String paramString2) {}
  
  public final void create()
  {
    try
    {
      Log.i("MicroMsg.FTS.BaseFTS5SearchLogic", "OnCreate %s | isCreated =%b", new Object[] { getName(), Boolean.valueOf(this.feX) });
      if ((!this.feX) && (onCreate()))
      {
        Log.i("MicroMsg.FTS.BaseFTS5SearchLogic", "SetCreated");
        this.feX = true;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void deleteSOSHistory() {}
  
  public void deleteSOSHistory(String paramString) {}
  
  public final void destroy()
  {
    Log.i("MicroMsg.FTS.BaseFTS5SearchLogic", "OnDestroy %s | isCreated %b", new Object[] { getName(), Boolean.valueOf(this.feX) });
    if ((this.feX) && (aXx()))
    {
      Log.i("MicroMsg.FTS.BaseFTS5SearchLogic", "SetDestroyed");
      this.feX = false;
    }
  }
  
  public final boolean isCreated()
  {
    return this.feX;
  }
  
  protected abstract boolean onCreate();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.b
 * JD-Core Version:    0.7.0.1
 */