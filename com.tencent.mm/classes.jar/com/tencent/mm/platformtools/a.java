package com.tencent.mm.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.a.a.b;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashSet;

public final class a
{
  public static final HashSet<b> giS;
  private static final b giT;
  private static Thread thread;
  
  static
  {
    AppMethodBeat.i(124514);
    thread = null;
    giS = new HashSet();
    giT = new a.1();
    AppMethodBeat.o(124514);
  }
  
  public static boolean aof()
  {
    AppMethodBeat.i(124512);
    boolean bool = syncAddrBook(giT);
    AppMethodBeat.o(124512);
    return bool;
  }
  
  public static boolean aog()
  {
    return a.a.fBf;
  }
  
  public static boolean syncAddrBook(b paramb)
  {
    AppMethodBeat.i(124513);
    long l = Thread.currentThread().getId();
    boolean bool = l.aqt();
    if (!bool)
    {
      ab.e("MicroMsg.AddrBookSyncHelper", "canSync:%b, skip", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(124513);
      return false;
    }
    al.d(new a.2(l, paramb));
    AppMethodBeat.o(124513);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.platformtools.a
 * JD-Core Version:    0.7.0.1
 */