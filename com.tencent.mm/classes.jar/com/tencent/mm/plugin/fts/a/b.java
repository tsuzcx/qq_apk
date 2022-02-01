package com.tencent.mm.plugin.fts.a;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;

public abstract class b
  implements k
{
  private boolean cKz;
  
  public b()
  {
    ad.i("MicroMsg.FTS.BaseFTS5SearchLogic", "Create %s", new Object[] { getName() });
  }
  
  public a a(j paramj)
  {
    return null;
  }
  
  public void a(String paramString, m paramm, int paramInt, HashMap<String, String> paramHashMap) {}
  
  public void addSOSHistory(String paramString1, String paramString2) {}
  
  protected abstract boolean agA();
  
  public final void create()
  {
    try
    {
      ad.i("MicroMsg.FTS.BaseFTS5SearchLogic", "OnCreate %s | isCreated =%b", new Object[] { getName(), Boolean.valueOf(this.cKz) });
      if ((!this.cKz) && (onCreate()))
      {
        ad.i("MicroMsg.FTS.BaseFTS5SearchLogic", "SetCreated");
        this.cKz = true;
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
    ad.i("MicroMsg.FTS.BaseFTS5SearchLogic", "OnDestroy %s | isCreated %b", new Object[] { getName(), Boolean.valueOf(this.cKz) });
    if ((this.cKz) && (agA()))
    {
      ad.i("MicroMsg.FTS.BaseFTS5SearchLogic", "SetDestroyed");
      this.cKz = false;
    }
  }
  
  public final boolean isCreated()
  {
    return this.cKz;
  }
  
  protected abstract boolean onCreate();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.b
 * JD-Core Version:    0.7.0.1
 */