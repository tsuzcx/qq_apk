package com.tencent.mm.plugin.bottle.a;

import com.tencent.mm.h.c.as;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.be.a;

final class i$2
  implements be.a
{
  i$2(i parami) {}
  
  public final void a(ak paramak, be parambe)
  {
    if (paramak == null) {}
    do
    {
      return;
      if ("_USER_FOR_THROWBOTTLE_".equals(paramak.field_username))
      {
        paramak.setUsername("");
        return;
      }
    } while ((1 == paramak.field_isSend) || (!ad.hd(paramak.field_username)) || (parambe.DL(paramak.field_username)));
    c.xO(paramak.field_username);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.a.i.2
 * JD-Core Version:    0.7.0.1
 */