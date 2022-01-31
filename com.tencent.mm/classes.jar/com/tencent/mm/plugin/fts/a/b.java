package com.tencent.mm.plugin.fts.a;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public abstract class b
  implements k
{
  public boolean bRJ;
  
  public b()
  {
    ab.i("MicroMsg.FTS.BaseFTS5SearchLogic", "Create %s", new Object[] { getName() });
  }
  
  protected abstract boolean Pp();
  
  public a a(i parami)
  {
    return null;
  }
  
  public void a(String paramString, l paraml, int paramInt, HashMap<String, String> paramHashMap) {}
  
  public void addSOSHistory(String paramString) {}
  
  public final void create()
  {
    try
    {
      ab.i("MicroMsg.FTS.BaseFTS5SearchLogic", "OnCreate %s | isCreated =%b", new Object[] { getName(), Boolean.valueOf(this.bRJ) });
      if ((!this.bRJ) && (onCreate()))
      {
        ab.i("MicroMsg.FTS.BaseFTS5SearchLogic", "SetCreated");
        this.bRJ = true;
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
    ab.i("MicroMsg.FTS.BaseFTS5SearchLogic", "OnDestroy %s | isCreated %b", new Object[] { getName(), Boolean.valueOf(this.bRJ) });
    if ((this.bRJ) && (Pp()))
    {
      ab.i("MicroMsg.FTS.BaseFTS5SearchLogic", "SetDestroyed");
      this.bRJ = false;
    }
  }
  
  public final boolean isCreated()
  {
    return this.bRJ;
  }
  
  protected abstract boolean onCreate();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.b
 * JD-Core Version:    0.7.0.1
 */