package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.y;

final class o$1
  extends m
{
  o$1(o paramo) {}
  
  protected final boolean WH()
  {
    boolean bool = true;
    if ((o.a(this.ffX) == null) || (o.a(this.ffX).csp())) {
      if (o.a(this.ffX) != null) {
        break label59;
      }
    }
    label59:
    for (Object localObject = "null";; localObject = Boolean.valueOf(o.a(this.ffX).csp()))
    {
      y.w("MicroMsg.GoogleContact.GoogleFriendUI", "shouldProcessEvent db is close :%s", new Object[] { localObject });
      bool = false;
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.o.1
 * JD-Core Version:    0.7.0.1
 */