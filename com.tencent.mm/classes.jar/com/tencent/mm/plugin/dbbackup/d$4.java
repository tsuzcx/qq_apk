package com.tencent.mm.plugin.dbbackup;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.by;
import com.tencent.mm.vfs.u;
import com.tencent.wcdb.repair.DBDumpUtil.ExecuteSqlCallback;
import java.util.Arrays;
import java.util.List;

final class d$4
  implements Runnable
{
  d$4(d paramd, u paramu, String paramString, b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(23082);
    try
    {
      Thread.sleep(200L);
      label12:
      bh.bCz();
      Object localObject2 = c.baj();
      Object localObject1 = (String)localObject2 + this.xjl.getName().replace(".db", "temp.db");
      Log.i("MicroMsg.SubCoreDBBackup", "temp db path is %s", new Object[] { localObject1 });
      this.xjl.am(new u((String)localObject1));
      String str = (String)localObject2 + "sqlTemp.sql";
      List localList = Arrays.asList(new String[] { "getcontactinfo", "contact", "contact_ext", "ContactCmdBuf", "rcontact", "img_flag", "userinfo" });
      localObject2 = new int[1];
      long l = System.currentTimeMillis();
      bh.bCz();
      boolean bool = c.getDataDB().a((String)localObject1, this.val$key, str, localList, new DBDumpUtil.ExecuteSqlCallback()
      {
        public final String preExecute(String paramAnonymousString)
        {
          paramAnonymousString = this.xjm;
          paramAnonymousString[0] += 1;
          return null;
        }
      });
      if (bool)
      {
        bh.bCz();
        c.bzD().gbi();
        bh.bCz();
        c.bzG().jaM();
        bh.bCz();
        c.bzD().gbk();
        bh.bCz();
        c.bzD().gbj();
        i = 12;
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(181L, i, 1L, true);
        l = System.currentTimeMillis() - l;
        Log.i("MicroMsg.SubCoreDBBackup", "execute %d sql and last %d", new Object[] { Integer.valueOf(localObject2[0]), Long.valueOf(l) });
        localObject1 = com.tencent.mm.plugin.report.service.h.OAn;
        if (!bool) {
          break label390;
        }
        i = 1;
        label312:
        ((com.tencent.mm.plugin.report.service.h)localObject1).b(11224, new Object[] { Integer.valueOf(i), localObject2, Long.valueOf(l) });
        bh.baH().setLowPriority();
        if (this.xiV != null)
        {
          localObject1 = this.xiV;
          if (!bool) {
            break label395;
          }
        }
      }
      label390:
      label395:
      for (int i = 0;; i = -1)
      {
        ((b)localObject1).onResult(i);
        AppMethodBeat.o(23082);
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