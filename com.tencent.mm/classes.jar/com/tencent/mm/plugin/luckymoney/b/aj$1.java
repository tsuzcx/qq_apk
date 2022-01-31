package com.tencent.mm.plugin.luckymoney.b;

import android.net.Uri;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.tz;
import com.tencent.mm.h.a.tz.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.bi;

final class aj$1
  extends c<tz>
{
  aj$1(aj paramaj)
  {
    this.udX = tz.class.getName().hashCode();
  }
  
  private boolean a(tz paramtz)
  {
    if ((paramtz instanceof tz)) {
      switch (paramtz.cen.action)
      {
      }
    }
    for (;;)
    {
      return false;
      aj localaj = this.lRU;
      long l = paramtz.cen.bHR;
      if (!localaj.lRP)
      {
        localaj.lRP = true;
        bi localbi = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(l);
        paramtz = localbi.field_content;
        if (paramtz != null) {}
        for (paramtz = g.a.M(paramtz, localbi.field_reserved); paramtz != null; paramtz = null)
        {
          paramtz = bk.pm(paramtz.dSi);
          Uri localUri = Uri.parse(paramtz);
          String str = localUri.getQueryParameter("sendid");
          int i = bk.getInt(localUri.getQueryParameter("channelid"), 1);
          if (localaj.lRQ != null)
          {
            com.tencent.mm.kernel.g.DQ();
            com.tencent.mm.kernel.g.DO().dJT.c(localaj.lRQ);
            localaj.lRQ = null;
          }
          com.tencent.mm.kernel.g.DQ();
          com.tencent.mm.kernel.g.DO().dJT.a(1581, localaj);
          localaj.lRQ = new ag(i, str, paramtz, 3, "v1.0");
          localaj.lRQ.talker = localbi.field_talker;
          localaj.lRQ.bIt = l;
          com.tencent.mm.kernel.g.DQ();
          com.tencent.mm.kernel.g.DO().dJT.a(localaj.lRQ, 0);
          return false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.b.aj.1
 * JD-Core Version:    0.7.0.1
 */