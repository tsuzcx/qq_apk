package com.tencent.mm.plugin.dbbackup;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.be;
import java.util.Arrays;
import java.util.List;

final class d$4
  implements Runnable
{
  d$4(d paramd, com.tencent.mm.vfs.b paramb, String paramString, b paramb1) {}
  
  public final void run()
  {
    AppMethodBeat.i(18973);
    try
    {
      Thread.sleep(200L);
      label12:
      aw.aaz();
      Object localObject2 = c.Rp();
      Object localObject1 = (String)localObject2 + this.kUs.getName().replace(".db", "temp.db");
      ab.i("MicroMsg.SubCoreDBBackup", "temp db path is %s", new Object[] { localObject1 });
      this.kUs.p(new com.tencent.mm.vfs.b((String)localObject1));
      String str = (String)localObject2 + "sqlTemp.sql";
      List localList = Arrays.asList(new String[] { "getcontactinfo", "contact", "contact_ext", "ContactCmdBuf", "rcontact", "img_flag", "userinfo" });
      localObject2 = new int[1];
      long l = System.currentTimeMillis();
      aw.aaz();
      boolean bool = c.Rq().a((String)localObject1, this.val$key, str, localList, new d.4.1(this, (int[])localObject2));
      if (bool)
      {
        aw.aaz();
        c.YC().bPY();
        aw.aaz();
        c.YF().dxf();
        aw.aaz();
        c.YC().bQa();
        aw.aaz();
        c.YC().bPZ();
        i = 12;
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(181L, i, 1L, true);
        l = System.currentTimeMillis() - l;
        ab.i("MicroMsg.SubCoreDBBackup", "execute %d sql and last %d", new Object[] { Integer.valueOf(localObject2[0]), Long.valueOf(l) });
        localObject1 = com.tencent.mm.plugin.report.service.h.qsU;
        if (!bool) {
          break label390;
        }
        i = 1;
        label312:
        ((com.tencent.mm.plugin.report.service.h)localObject1).e(11224, new Object[] { Integer.valueOf(i), localObject2, Long.valueOf(l) });
        aw.RO().dtd();
        if (this.kUb != null)
        {
          localObject1 = this.kUb;
          if (!bool) {
            break label395;
          }
        }
      }
      label390:
      label395:
      for (int i = 0;; i = -1)
      {
        ((b)localObject1).tT(i);
        AppMethodBeat.o(18973);
        return;
        i = 15;
        break;
        i = 0;
        break label312;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      break label12;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.d.4
 * JD-Core Version:    0.7.0.1
 */