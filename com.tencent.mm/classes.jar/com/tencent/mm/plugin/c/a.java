package com.tencent.mm.plugin.c;

import com.tencent.mm.cf.h;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.api.e;
import com.tencent.mm.kernel.b.c;
import java.util.HashMap;

public final class a
  implements com.tencent.mm.kernel.api.a, e, c
{
  private static final HashMap<Integer, h.d> dgp;
  private static a fvO;
  private com.tencent.mm.storage.g fvP;
  
  static
  {
    HashMap localHashMap = new HashMap();
    dgp = localHashMap;
    localHashMap.put(Integer.valueOf("AddContactAntispamTicket".hashCode()), new h.d()
    {
      public final String[] rK()
      {
        return com.tencent.mm.storage.g.dXp;
      }
    });
  }
  
  public static a YT()
  {
    try
    {
      if (fvO == null) {
        fvO = new a();
      }
      a locala = fvO;
      return locala;
    }
    finally {}
  }
  
  public final com.tencent.mm.storage.g Ga()
  {
    com.tencent.mm.kernel.g.DN().CX();
    return this.fvP;
  }
  
  public final HashMap<Integer, h.d> collectDatabaseFactory()
  {
    return dgp;
  }
  
  public final void onDataBaseClosed(h paramh1, h paramh2) {}
  
  public final void onDataBaseOpened(h paramh1, h paramh2)
  {
    this.fvP = new com.tencent.mm.storage.g(paramh1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.c.a
 * JD-Core Version:    0.7.0.1
 */