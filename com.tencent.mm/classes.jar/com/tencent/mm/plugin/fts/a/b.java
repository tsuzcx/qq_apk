package com.tencent.mm.plugin.fts.a;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public abstract class b
  implements k
{
  private boolean isCreated;
  public boolean kuC;
  
  public b()
  {
    y.i("MicroMsg.FTS.BaseFTS5SearchLogic", "Create %s", new Object[] { getName() });
  }
  
  public abstract boolean BB();
  
  public a a(i parami)
  {
    return null;
  }
  
  public void a(String paramString, l paraml, int paramInt, HashMap<String, String> paramHashMap) {}
  
  public final boolean aVv()
  {
    return this.isCreated;
  }
  
  public void addSOSHistory(String paramString) {}
  
  public final void create()
  {
    try
    {
      y.i("MicroMsg.FTS.BaseFTS5SearchLogic", "OnCreate %s | isCreated =%b", new Object[] { getName(), Boolean.valueOf(this.isCreated) });
      if ((!this.isCreated) && (onCreate()))
      {
        y.i("MicroMsg.FTS.BaseFTS5SearchLogic", "SetCreated");
        this.isCreated = true;
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
    y.i("MicroMsg.FTS.BaseFTS5SearchLogic", "OnDestroy %s | isDestroyed %b | isCreated %b", new Object[] { getName(), Boolean.valueOf(this.kuC), Boolean.valueOf(this.isCreated) });
    if ((!this.kuC) && (this.isCreated) && (BB()))
    {
      y.i("MicroMsg.FTS.BaseFTS5SearchLogic", "SetDestroyed");
      this.kuC = true;
    }
  }
  
  public abstract boolean onCreate();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.b
 * JD-Core Version:    0.7.0.1
 */