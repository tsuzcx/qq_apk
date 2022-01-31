package com.tencent.mm.bp;

import android.content.Context;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bk;

public final class a
{
  public static boolean cki()
  {
    String str2 = ((com.tencent.mm.plugin.zero.b.a)g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("EnableStrangerChat");
    String str1 = str2;
    if (bk.bl(str2)) {
      str1 = "0";
    }
    return "1".equals(str1);
  }
  
  public static void eF(Context paramContext)
  {
    if (!cki())
    {
      g.DN().CX();
      if (((j)g.r(j.class)).bhL().aAo() > 0)
      {
        d.x(paramContext, "nearby", ".ui.NearbyFriendShowSayHiUI");
        return;
      }
    }
    d.x(paramContext, "nearby", ".ui.NearbyFriendsUI");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.bp.a
 * JD-Core Version:    0.7.0.1
 */