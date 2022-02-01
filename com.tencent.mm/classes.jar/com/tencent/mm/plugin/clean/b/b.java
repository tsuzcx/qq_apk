package com.tencent.mm.plugin.clean.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.o;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b
  implements Runnable
{
  private List<String> paD;
  private List<com.tencent.mm.plugin.clean.c.c> paE;
  private com.tencent.mm.plugin.clean.c.b paF;
  private long paG = 0L;
  
  public b(List<String> paramList, List<com.tencent.mm.plugin.clean.c.c> paramList1, com.tencent.mm.plugin.clean.c.b paramb)
  {
    this.paD = paramList;
    this.paE = paramList1;
    this.paF = paramb;
  }
  
  private String bpA()
  {
    AppMethodBeat.i(22771);
    String str = hashCode();
    AppMethodBeat.o(22771);
    return str;
  }
  
  private void cL(List<com.tencent.mm.plugin.f.b.a> paramList)
  {
    AppMethodBeat.i(22769);
    int j = paramList.size();
    HashSet localHashSet = new HashSet();
    bc.aCg();
    long l1 = com.tencent.mm.model.c.getDataDB().yi(Thread.currentThread().getId());
    int i = 0;
    while (i < j)
    {
      com.tencent.mm.plugin.f.b.a locala = (com.tencent.mm.plugin.f.b.a)paramList.get(i);
      long l2 = bu.HQ();
      if (!localHashSet.contains(Long.valueOf(locala.field_msgId)))
      {
        bc.aCg();
        bv localbv = com.tencent.mm.model.c.azI().ys(locala.field_msgId);
        if ((localbv.field_msgId != 0L) && (!localbv.fvU()))
        {
          com.tencent.mm.plugin.f.b localb = com.tencent.mm.plugin.f.b.bUj();
          long l3 = locala.field_msgId;
          localb.oCd = true;
          localb.oCc.add(Long.valueOf(l3));
          ae.d("MicroMsg.CalcWxService", "%d lock msg change [%d] [%s]", new Object[] { Integer.valueOf(localb.hashCode()), Long.valueOf(l3), bu.fpN() });
          localbv.fvV();
          bc.aCg();
          com.tencent.mm.model.c.azI().a(locala.field_msgId, localbv);
        }
        localHashSet.add(Long.valueOf(locala.field_msgId));
        ae.d("MicroMsg.DeleteFileByWxIndex", "%s deleteByIndex handle msg[%d]", new Object[] { bpA(), Long.valueOf(bu.aO(l2)) });
      }
      if ((locala != null) && (!com.tencent.mm.plugin.f.a.Av(locala.field_msgSubType)) && (locala.field_size > 0L))
      {
        this.paG += locala.field_size;
        o.deleteFile(g.ajR().gDS + locala.field_path);
        locala.field_path = "";
        locala.field_size = 0L;
        com.tencent.mm.plugin.f.b.bUj().bUk().update(locala.systemRowid, locala, false);
      }
      ae.d("MicroMsg.DeleteFileByWxIndex", "%s deleteByIndex[%d]", new Object[] { bpA(), Long.valueOf(bu.aO(l2)) });
      i += 1;
    }
    bc.aCg();
    com.tencent.mm.model.c.getDataDB().sW(l1);
    AppMethodBeat.o(22769);
  }
  
  public final void run()
  {
    AppMethodBeat.i(22770);
    int j;
    int i;
    long l1;
    if (this.paD != null)
    {
      long l5 = bu.HQ();
      j = this.paD.size();
      Iterator localIterator2 = this.paD.iterator();
      i = 0;
      while (localIterator2.hasNext())
      {
        String str1 = (String)localIterator2.next();
        if (!bu.isNullOrNil(str1))
        {
          long l6 = bu.HQ();
          PLong localPLong1 = new PLong();
          PLong localPLong2 = new PLong();
          Object localObject4 = com.tencent.mm.plugin.f.b.bUj().bUk();
          l1 = bu.HQ();
          String str2 = "select max(msgtime), min(msgtime) from WxFileIndex2 where username='" + str1 + "' and msgSubType in (1,20,23,30,32,34 ) and size > 0 ";
          Object localObject3 = null;
          Object localObject1 = null;
          try
          {
            localObject4 = ((com.tencent.mm.plugin.f.b.b)localObject4).db.rawQuery(str2, null);
            if (localObject4 != null)
            {
              localObject1 = localObject4;
              localObject3 = localObject4;
              if (((Cursor)localObject4).moveToFirst())
              {
                localObject1 = localObject4;
                localObject3 = localObject4;
                localPLong1.value = ((Cursor)localObject4).getLong(0);
                localObject1 = localObject4;
                localObject3 = localObject4;
                localPLong2.value = ((Cursor)localObject4).getLong(1);
              }
            }
            if (localObject4 != null) {
              ((Cursor)localObject4).close();
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              long l2;
              localObject3 = localObject1;
              ae.printErrStackTrace("MicroMsg.WxFileIndexStorage", localException, " sql [%s]", new Object[] { str2 });
              if (localObject1 != null) {
                ((Cursor)localObject1).close();
              }
            }
          }
          finally
          {
            if (localObject3 == null) {
              break label485;
            }
            localObject3.close();
            AppMethodBeat.o(22770);
          }
          ae.i("MicroMsg.WxFileIndexStorage", "getNoThumbMediaMsgTimeByUsername [%s] cost[%d]", new Object[] { str1, Long.valueOf(bu.aO(l1)) });
          localPLong2.value -= 1L;
          long l3 = localPLong1.value;
          l2 = Math.max(l3 - 2592000000L, localPLong2.value);
          l1 = l2;
          if (l2 == l3) {
            l1 = l2 - 1L;
          }
          localObject1 = com.tencent.mm.plugin.f.b.bUj().bUk().t(str1, l3, l1);
          l3 = ((List)localObject1).size() + 0L;
          cL((List)localObject1);
          for (l2 = l1; l2 > localPLong2.value; l2 = l1)
          {
            long l4 = Math.max(l2 - 2592000000L, localPLong2.value);
            l1 = l4;
            if (l4 == l2) {
              l1 = l4 - 1L;
            }
            localObject1 = com.tencent.mm.plugin.f.b.bUj().bUk().t(str1, l2, l1);
            l3 += ((List)localObject1).size();
            cL((List)localObject1);
          }
          label485:
          ae.i("MicroMsg.DeleteFileByWxIndex", "%s deleteByName [%s] [%d] [%d %d] cost[%d]", new Object[] { bpA(), str1, Long.valueOf(l3), Long.valueOf(localPLong2.value), Long.valueOf(localPLong1.value), Long.valueOf(bu.aO(l6)) });
        }
        i += 1;
        if (this.paF != null) {
          this.paF.fb(i, j);
        }
      }
      if (this.paF != null) {
        this.paF.tZ(this.paG);
      }
      com.tencent.mm.plugin.f.b.bUj().bUo();
      ae.i("MicroMsg.DeleteFileByWxIndex", "%s deleteByUsername cost[%d]", new Object[] { bpA(), Long.valueOf(bu.aO(l5)) });
      AppMethodBeat.o(22770);
      return;
    }
    if (this.paE != null)
    {
      l1 = bu.HQ();
      j = this.paE.size();
      Iterator localIterator1 = this.paE.iterator();
      i = 0;
      while (localIterator1.hasNext())
      {
        cL(((com.tencent.mm.plugin.clean.c.c)localIterator1.next()).paL);
        i += 1;
        if (this.paF != null) {
          this.paF.fb(i, j);
        }
      }
      if (this.paF != null) {
        this.paF.tZ(this.paG);
      }
      com.tencent.mm.plugin.f.b.bUj().bUo();
      ae.i("MicroMsg.DeleteFileByWxIndex", "%s deleteByNewAnalyseItem cost[%d]", new Object[] { bpA(), Long.valueOf(bu.aO(l1)) });
      AppMethodBeat.o(22770);
      return;
    }
    AppMethodBeat.o(22770);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.b.b
 * JD-Core Version:    0.7.0.1
 */