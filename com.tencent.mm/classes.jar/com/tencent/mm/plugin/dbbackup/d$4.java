package com.tencent.mm.plugin.dbbackup;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.be;
import java.util.Arrays;
import java.util.List;

final class d$4
  implements Runnable
{
  d$4(d paramd, com.tencent.mm.vfs.b paramb, String paramString, b paramb1) {}
  
  public final void run()
  {
    try
    {
      Thread.sleep(200L);
      label6:
      au.Hx();
      Object localObject2 = c.FT();
      Object localObject1 = (String)localObject2 + this.iNs.getName().replace(".db", "temp.db");
      y.i("MicroMsg.SubCoreDBBackup", "temp db path is %s", new Object[] { localObject1 });
      this.iNs.n(new com.tencent.mm.vfs.b((String)localObject1));
      String str = (String)localObject2 + "sqlTemp.sql";
      List localList = Arrays.asList(new String[] { "getcontactinfo", "contact", "contact_ext", "ContactCmdBuf", "rcontact", "img_flag", "userinfo" });
      localObject2 = new int[1];
      long l = System.currentTimeMillis();
      au.Hx();
      boolean bool = c.Dv().a((String)localObject1, this.doz, str, localList, new d.4.1(this, (int[])localObject2));
      if (bool)
      {
        au.Hx();
        c.Fy().bhW();
        au.Hx();
        c.FB().cuF();
        au.Hx();
        c.Fy().bhY();
        au.Hx();
        c.Fy().bhX();
        i = 12;
        com.tencent.mm.plugin.report.service.h.nFQ.a(181L, i, 1L, true);
        l = System.currentTimeMillis() - l;
        y.i("MicroMsg.SubCoreDBBackup", "execute %d sql and last %d", new Object[] { Integer.valueOf(localObject2[0]), Long.valueOf(l) });
        localObject1 = com.tencent.mm.plugin.report.service.h.nFQ;
        if (!bool) {
          break label378;
        }
        i = 1;
        label306:
        ((com.tencent.mm.plugin.report.service.h)localObject1).f(11224, new Object[] { Integer.valueOf(i), localObject2, Long.valueOf(l) });
        au.DS().cre();
        if (this.iNb != null)
        {
          localObject1 = this.iNb;
          if (!bool) {
            break label383;
          }
        }
      }
      label378:
      label383:
      for (int i = 0;; i = -1)
      {
        ((b)localObject1).pC(i);
        return;
        i = 15;
        break;
        i = 0;
        break label306;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      break label6;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.d.4
 * JD-Core Version:    0.7.0.1
 */