package com.tencent.mm.plugin.fts.a;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public abstract class b
  implements k
{
  private boolean dfI;
  
  public b()
  {
    Log.i("MicroMsg.FTS.BaseFTS5SearchLogic", "Create %s", new Object[] { getName() });
  }
  
  public a a(j paramj)
  {
    return null;
  }
  
  public void a(String paramString, m paramm, int paramInt, HashMap<String, String> paramHashMap) {}
  
  protected abstract boolean aEt();
  
  public void addSOSHistory(String paramString1, String paramString2) {}
  
  public final void create()
  {
    try
    {
      Log.i("MicroMsg.FTS.BaseFTS5SearchLogic", "OnCreate %s | isCreated =%b", new Object[] { getName(), Boolean.valueOf(this.dfI) });
      if ((!this.dfI) && (onCreate()))
      {
        Log.i("MicroMsg.FTS.BaseFTS5SearchLogic", "SetCreated");
        this.dfI = true;
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
    Log.i("MicroMsg.FTS.BaseFTS5SearchLogic", "OnDestroy %s | isCreated %b", new Object[] { getName(), Boolean.valueOf(this.dfI) });
    if ((this.dfI) && (aEt()))
    {
      Log.i("MicroMsg.FTS.BaseFTS5SearchLogic", "SetDestroyed");
      this.dfI = false;
    }
  }
  
  public final boolean isCreated()
  {
    return this.dfI;
  }
  
  protected abstract boolean onCreate();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.b
 * JD-Core Version:    0.7.0.1
 */