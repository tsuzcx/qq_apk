package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.h.a.af;
import com.tencent.mm.h.a.af.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;

public final class c
  extends com.tencent.mm.sdk.b.c<af>
{
  public c()
  {
    this.udX = af.class.getName().hashCode();
  }
  
  private static boolean a(af paramaf)
  {
    if (paramaf.bGf.bGh == 0) {}
    try
    {
      int i = q.Gu() | 0x1000;
      g.DP().Dz().o(34, Integer.valueOf(i));
      ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fv().b(new com.tencent.mm.ay.j("", "", "", "", "", "", "", "", i, "", ""));
      y.d("MicroMsg.FriendBindQQ.EventListener", "doClearQQFriendHelper succ ");
      return false;
    }
    catch (Exception paramaf)
    {
      y.printErrStackTrace("MicroMsg.FriendBindQQ.EventListener", paramaf, "", new Object[0]);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.c
 * JD-Core Version:    0.7.0.1
 */