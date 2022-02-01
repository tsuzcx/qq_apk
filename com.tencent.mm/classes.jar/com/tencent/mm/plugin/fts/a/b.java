package com.tencent.mm.plugin.fts.a;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public abstract class b
  implements k
{
  private boolean dbG;
  
  public b()
  {
    Log.i("MicroMsg.FTS.BaseFTS5SearchLogic", "Create %s", new Object[] { getName() });
  }
  
  public a a(j paramj)
  {
    return null;
  }
  
  public void a(String paramString, m paramm, int paramInt, HashMap<String, String> paramHashMap) {}
  
  public void addSOSHistory(String paramString1, String paramString2) {}
  
  protected abstract boolean axa();
  
  public final void create()
  {
    try
    {
      Log.i("MicroMsg.FTS.BaseFTS5SearchLogic", "OnCreate %s | isCreated =%b", new Object[] { getName(), Boolean.valueOf(this.dbG) });
      if ((!this.dbG) && (onCreate()))
      {
        Log.i("MicroMsg.FTS.BaseFTS5SearchLogic", "SetCreated");
        this.dbG = true;
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
    Log.i("MicroMsg.FTS.BaseFTS5SearchLogic", "OnDestroy %s | isCreated %b", new Object[] { getName(), Boolean.valueOf(this.dbG) });
    if ((this.dbG) && (axa()))
    {
      Log.i("MicroMsg.FTS.BaseFTS5SearchLogic", "SetDestroyed");
      this.dbG = false;
    }
  }
  
  public final boolean isCreated()
  {
    return this.dbG;
  }
  
  protected abstract boolean onCreate();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.b
 * JD-Core Version:    0.7.0.1
 */