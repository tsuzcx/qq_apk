package com.tencent.mm.plugin.c;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.e;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.b.c;
import com.tencent.mm.n.f;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.g;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
  implements com.tencent.mm.kernel.api.a, e, c
{
  private static final HashMap<Integer, h.b> baseDBFactories;
  private static a nqQ;
  private g nqR;
  
  static
  {
    AppMethodBeat.i(151424);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("AddContactAntispamTicket".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return g.SQL_CREATE;
      }
    });
    AppMethodBeat.o(151424);
  }
  
  public static boolean K(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(151422);
    if ((Util.isNullOrNil(paramCharSequence)) || (!com.tencent.mm.kernel.h.aHE().kbT))
    {
      AppMethodBeat.o(151422);
      return false;
    }
    try
    {
      String str = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getValue("ClipProtectPattern");
      if (!Util.isNullOrNil(str))
      {
        str = new String(Base64.decode(str, 0));
        if (!Util.isNullOrNil(str))
        {
          boolean bool = Pattern.compile(str).matcher(paramCharSequence).matches();
          if (bool)
          {
            AppMethodBeat.o(151422);
            return true;
          }
        }
      }
    }
    catch (Exception paramCharSequence)
    {
      AppMethodBeat.o(151422);
    }
    return false;
  }
  
  public static a bBt()
  {
    try
    {
      AppMethodBeat.i(151420);
      if (nqQ == null) {
        nqQ = new a();
      }
      a locala = nqQ;
      AppMethodBeat.o(151420);
      return locala;
    }
    finally {}
  }
  
  public final g bcn()
  {
    AppMethodBeat.i(151421);
    com.tencent.mm.kernel.h.aHE().aGH();
    g localg = this.nqR;
    AppMethodBeat.o(151421);
    return localg;
  }
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    return baseDBFactories;
  }
  
  public final void onDataBaseClosed(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2) {}
  
  public final void onDataBaseOpened(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
  {
    AppMethodBeat.i(151423);
    this.nqR = new g(paramh1);
    AppMethodBeat.o(151423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.c.a
 * JD-Core Version:    0.7.0.1
 */