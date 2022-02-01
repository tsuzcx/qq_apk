package com.tencent.mm.plugin.c;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.e;
import com.tencent.mm.kernel.b.c;
import com.tencent.mm.n.f;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
  implements com.tencent.mm.kernel.api.a, e, c
{
  private static final HashMap<Integer, h.b> baseDBFactories;
  private static a kxQ;
  private com.tencent.mm.storage.g kxR;
  
  static
  {
    AppMethodBeat.i(151424);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("AddContactAntispamTicket".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.storage.g.SQL_CREATE;
      }
    });
    AppMethodBeat.o(151424);
  }
  
  public static boolean D(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(151422);
    if ((Util.isNullOrNil(paramCharSequence)) || (!com.tencent.mm.kernel.g.aAf().hpY))
    {
      AppMethodBeat.o(151422);
      return false;
    }
    try
    {
      String str = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("ClipProtectPattern");
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
  
  public static a bqE()
  {
    try
    {
      AppMethodBeat.i(151420);
      if (kxQ == null) {
        kxQ = new a();
      }
      a locala = kxQ;
      AppMethodBeat.o(151420);
      return locala;
    }
    finally {}
  }
  
  public final com.tencent.mm.storage.g aTp()
  {
    AppMethodBeat.i(151421);
    com.tencent.mm.kernel.g.aAf().azk();
    com.tencent.mm.storage.g localg = this.kxR;
    AppMethodBeat.o(151421);
    return localg;
  }
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    return baseDBFactories;
  }
  
  public final void onDataBaseClosed(h paramh1, h paramh2) {}
  
  public final void onDataBaseOpened(h paramh1, h paramh2)
  {
    AppMethodBeat.i(151423);
    this.kxR = new com.tencent.mm.storage.g(paramh1);
    AppMethodBeat.o(151423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.c.a
 * JD-Core Version:    0.7.0.1
 */