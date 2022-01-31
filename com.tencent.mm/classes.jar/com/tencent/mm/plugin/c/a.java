package com.tencent.mm.plugin.c;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.b.c;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
  implements com.tencent.mm.kernel.api.a, com.tencent.mm.kernel.api.e, c
{
  private static final HashMap<Integer, h.d> baseDBFactories;
  private static a gNu;
  private com.tencent.mm.storage.g gNv;
  
  static
  {
    AppMethodBeat.i(79051);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("AddContactAntispamTicket".hashCode()), new a.1());
    AppMethodBeat.o(79051);
  }
  
  public static a asD()
  {
    try
    {
      AppMethodBeat.i(79047);
      if (gNu == null) {
        gNu = new a();
      }
      a locala = gNu;
      AppMethodBeat.o(79047);
      return locala;
    }
    finally {}
  }
  
  public static boolean v(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(79049);
    if ((bo.aa(paramCharSequence)) || (!com.tencent.mm.kernel.g.RJ().eHg))
    {
      AppMethodBeat.o(79049);
      return false;
    }
    try
    {
      String str = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("ClipProtectPattern");
      if (!bo.isNullOrNil(str))
      {
        str = new String(Base64.decode(str, 0));
        if (!bo.isNullOrNil(str))
        {
          boolean bool = Pattern.compile(str).matcher(paramCharSequence).matches();
          if (bool)
          {
            AppMethodBeat.o(79049);
            return true;
          }
        }
      }
    }
    catch (Exception paramCharSequence)
    {
      AppMethodBeat.o(79049);
    }
    return false;
  }
  
  public final com.tencent.mm.storage.g Zb()
  {
    AppMethodBeat.i(79048);
    com.tencent.mm.kernel.g.RJ().QQ();
    com.tencent.mm.storage.g localg = this.gNv;
    AppMethodBeat.o(79048);
    return localg;
  }
  
  public final HashMap<Integer, h.d> collectDatabaseFactory()
  {
    return baseDBFactories;
  }
  
  public final void onDataBaseClosed(h paramh1, h paramh2) {}
  
  public final void onDataBaseOpened(h paramh1, h paramh2)
  {
    AppMethodBeat.i(79050);
    this.gNv = new com.tencent.mm.storage.g(paramh1);
    AppMethodBeat.o(79050);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.c.a
 * JD-Core Version:    0.7.0.1
 */