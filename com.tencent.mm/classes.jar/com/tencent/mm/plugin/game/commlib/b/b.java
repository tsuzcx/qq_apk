package com.tencent.mm.plugin.game.commlib.b;

import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

public final class b
  extends i<a>
{
  public static final String[] dXp = { i.a(a.buS, "PBCache") };
  
  public b(e parame)
  {
    super(parame, a.buS, "PBCache", null);
  }
  
  public final byte[] Ey(String paramString)
  {
    if (bk.bl(paramString)) {}
    a locala;
    do
    {
      return null;
      locala = new a();
      locala.field_key = paramString;
    } while (!super.b(locala, new String[0]));
    return locala.field_value;
  }
  
  public final void Ez(String paramString)
  {
    a locala = new a();
    locala.field_key = paramString;
    super.a(locala, new String[0]);
  }
  
  public final boolean b(String paramString, com.tencent.mm.bv.a parama)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (!bk.bl(paramString))
    {
      if (parama == null) {
        bool2 = bool1;
      }
    }
    else {
      return bool2;
    }
    for (;;)
    {
      a locala;
      try
      {
        parama = parama.toByteArray();
        bool2 = bool1;
        if (parama == null) {
          break;
        }
        bool2 = bool1;
        if (parama.length == 0) {
          break;
        }
        locala = new a();
        locala.field_key = paramString;
        if (super.b(locala, new String[0]))
        {
          locala.field_value = parama;
          bool1 = super.c(locala, new String[0]);
          bool2 = bool1;
          if (bool1) {
            break;
          }
          y.e("MicroMsg.PBCacheStorage", "Saving cache failed (update or insert)");
          return bool1;
        }
      }
      catch (IOException paramString)
      {
        y.e("MicroMsg.PBCacheStorage", "Saving Failed: %s", new Object[] { paramString.getMessage() });
        return false;
      }
      locala.field_value = parama;
      bool1 = super.b(locala);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.b.b
 * JD-Core Version:    0.7.0.1
 */