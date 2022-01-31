package com.tencent.mm.plugin.game.model;

import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

public final class x
  extends i<w>
{
  public static final String[] dXp = { i.a(w.buS, "GamePBCache") };
  
  public x(e parame)
  {
    super(parame, w.buS, "GamePBCache", null);
  }
  
  public final byte[] Ey(String paramString)
  {
    if (bk.bl(paramString)) {}
    w localw;
    do
    {
      do
      {
        return null;
      } while (!com.tencent.mm.sdk.platformtools.x.cqJ().equals(f.aYZ()));
      localw = new w();
      localw.field_key = paramString;
    } while (!super.b(localw, new String[0]));
    return localw.field_value;
  }
  
  public final boolean b(String paramString, a parama)
  {
    if ((bk.bl(paramString)) || (parama == null)) {
      return false;
    }
    try
    {
      parama = parama.toByteArray();
      return o(paramString, parama);
    }
    catch (IOException paramString)
    {
      y.e("MicroMsg.GamePBCacheStorage", "Saving Failed: %s", new Object[] { paramString.getMessage() });
    }
    return false;
  }
  
  public final boolean o(String paramString, byte[] paramArrayOfByte)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        bool2 = bool1;
      }
    }
    else {
      return bool2;
    }
    w localw = new w();
    localw.field_key = paramString;
    if (super.b(localw, new String[0])) {
      localw.field_value = paramArrayOfByte;
    }
    for (bool1 = super.c(localw, new String[0]);; bool1 = super.b(localw))
    {
      bool2 = bool1;
      if (bool1) {
        break;
      }
      y.e("MicroMsg.GamePBCacheStorage", "Saving cache failed (update or insert)");
      return bool1;
      localw.field_value = paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.x
 * JD-Core Version:    0.7.0.1
 */