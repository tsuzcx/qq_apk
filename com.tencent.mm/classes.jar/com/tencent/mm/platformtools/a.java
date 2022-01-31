package com.tencent.mm.platformtools;

import com.tencent.mm.plugin.account.a.a.b;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;

public final class a
{
  public static final HashSet<b> eQX = new HashSet();
  private static final b eQY = new a.1();
  private static Thread thread = null;
  
  public static boolean UG()
  {
    return syncAddrBook(eQY);
  }
  
  public static boolean UH()
  {
    return a.a.ekO;
  }
  
  public static boolean syncAddrBook(b paramb)
  {
    long l = Thread.currentThread().getId();
    boolean bool = l.WS();
    if (!bool)
    {
      y.e("MicroMsg.AddrBookSyncHelper", "canSync:%b, skip", new Object[] { Boolean.valueOf(bool) });
      return false;
    }
    ai.d(new a.2(l, paramb));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.platformtools.a
 * JD-Core Version:    0.7.0.1
 */