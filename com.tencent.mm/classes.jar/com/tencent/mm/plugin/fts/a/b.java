package com.tencent.mm.plugin.fts.a;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;

public abstract class b
  implements k
{
  private boolean cLi;
  
  public b()
  {
    ae.i("MicroMsg.FTS.BaseFTS5SearchLogic", "Create %s", new Object[] { getName() });
  }
  
  public a a(j paramj)
  {
    return null;
  }
  
  public void a(String paramString, m paramm, int paramInt, HashMap<String, String> paramHashMap) {}
  
  public void addSOSHistory(String paramString1, String paramString2) {}
  
  protected abstract boolean agO();
  
  public final void create()
  {
    try
    {
      ae.i("MicroMsg.FTS.BaseFTS5SearchLogic", "OnCreate %s | isCreated =%b", new Object[] { getName(), Boolean.valueOf(this.cLi) });
      if ((!this.cLi) && (onCreate()))
      {
        ae.i("MicroMsg.FTS.BaseFTS5SearchLogic", "SetCreated");
        this.cLi = true;
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
    ae.i("MicroMsg.FTS.BaseFTS5SearchLogic", "OnDestroy %s | isCreated %b", new Object[] { getName(), Boolean.valueOf(this.cLi) });
    if ((this.cLi) && (agO()))
    {
      ae.i("MicroMsg.FTS.BaseFTS5SearchLogic", "SetDestroyed");
      this.cLi = false;
    }
  }
  
  public final boolean isCreated()
  {
    return this.cLi;
  }
  
  protected abstract boolean onCreate();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.b
 * JD-Core Version:    0.7.0.1
 */