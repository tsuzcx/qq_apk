package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ab;

final class o$1
  extends n
{
  o$1(o paramo) {}
  
  public final boolean aqj()
  {
    AppMethodBeat.i(108387);
    if ((o.a(this.gxF) == null) || (o.a(this.gxF).dun()))
    {
      if (o.a(this.gxF) == null) {}
      for (Object localObject = "null";; localObject = Boolean.valueOf(o.a(this.gxF).dun()))
      {
        ab.w("MicroMsg.GoogleContact.GoogleFriendUI", "shouldProcessEvent db is close :%s", new Object[] { localObject });
        AppMethodBeat.o(108387);
        return false;
      }
    }
    AppMethodBeat.o(108387);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.o.1
 * JD-Core Version:    0.7.0.1
 */