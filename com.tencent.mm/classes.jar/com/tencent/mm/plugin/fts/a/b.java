package com.tencent.mm.plugin.fts.a;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;

public abstract class b
  implements k
{
  private boolean czD;
  
  public b()
  {
    ac.i("MicroMsg.FTS.BaseFTS5SearchLogic", "Create %s", new Object[] { getName() });
  }
  
  public a a(j paramj)
  {
    return null;
  }
  
  public void a(String paramString, m paramm, int paramInt, HashMap<String, String> paramHashMap) {}
  
  protected abstract boolean adU();
  
  public void addSOSHistory(String paramString1, String paramString2) {}
  
  public final void create()
  {
    try
    {
      ac.i("MicroMsg.FTS.BaseFTS5SearchLogic", "OnCreate %s | isCreated =%b", new Object[] { getName(), Boolean.valueOf(this.czD) });
      if ((!this.czD) && (onCreate()))
      {
        ac.i("MicroMsg.FTS.BaseFTS5SearchLogic", "SetCreated");
        this.czD = true;
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
    ac.i("MicroMsg.FTS.BaseFTS5SearchLogic", "OnDestroy %s | isCreated %b", new Object[] { getName(), Boolean.valueOf(this.czD) });
    if ((this.czD) && (adU()))
    {
      ac.i("MicroMsg.FTS.BaseFTS5SearchLogic", "SetDestroyed");
      this.czD = false;
    }
  }
  
  public final boolean isCreated()
  {
    return this.czD;
  }
  
  protected abstract boolean onCreate();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.b
 * JD-Core Version:    0.7.0.1
 */