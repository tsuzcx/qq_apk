package com.tencent.mm.plugin.clean.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ba;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storagebase.h;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b
  implements Runnable
{
  private List<String> oUa;
  private List<com.tencent.mm.plugin.clean.c.c> oUb;
  private com.tencent.mm.plugin.clean.c.b oUc;
  private long oUd = 0L;
  
  public b(List<String> paramList, List<com.tencent.mm.plugin.clean.c.c> paramList1, com.tencent.mm.plugin.clean.c.b paramb)
  {
    this.oUa = paramList;
    this.oUb = paramList1;
    this.oUc = paramb;
  }
  
  private String boQ()
  {
    AppMethodBeat.i(22771);
    String str = hashCode();
    AppMethodBeat.o(22771);
    return str;
  }
  
  private void cI(List<com.tencent.mm.plugin.f.b.a> paramList)
  {
    AppMethodBeat.i(22769);
    int j = paramList.size();
    HashSet localHashSet = new HashSet();
    ba.aBQ();
    long l1 = com.tencent.mm.model.c.getDataDB().xO(Thread.currentThread().getId());
    int i = 0;
    while (i < j)
    {
      com.tencent.mm.plugin.f.b.a locala = (com.tencent.mm.plugin.f.b.a)paramList.get(i);
      long l2 = bt.HI();
      if (!localHashSet.contains(Long.valueOf(locala.field_msgId)))
      {
        ba.aBQ();
        bu localbu = com.tencent.mm.model.c.azs().xY(locala.field_msgId);
        if ((localbu.field_msgId != 0L) && (!localbu.frT()))
        {
          com.tencent.mm.plugin.f.b localb = com.tencent.mm.plugin.f.b.bSU();
          long l3 = locala.field_msgId;
          localb.ovC = true;
          localb.ovB.add(Long.valueOf(l3));
          ad.d("MicroMsg.CalcWxService", "%d lock msg change [%d] [%s]", new Object[] { Integer.valueOf(localb.hashCode()), Long.valueOf(l3), bt.flS() });
          localbu.frU();
          ba.aBQ();
          com.tencent.mm.model.c.azs().a(locala.field_msgId, localbu);
        }
        localHashSet.add(Long.valueOf(locala.field_msgId));
        ad.d("MicroMsg.DeleteFileByWxIndex", "%s deleteByIndex handle msg[%d]", new Object[] { boQ(), Long.valueOf(bt.aO(l2)) });
      }
      if ((locala != null) && (!com.tencent.mm.plugin.f.a.Aj(locala.field_msgSubType)) && (locala.field_size > 0L))
      {
        this.oUd += locala.field_size;
        com.tencent.mm.vfs.i.deleteFile(g.ajC().gBl + locala.field_path);
        locala.field_path = "";
        locala.field_size = 0L;
        com.tencent.mm.plugin.f.b.bSU().bSV().update(locala.systemRowid, locala, false);
      }
      ad.d("MicroMsg.DeleteFileByWxIndex", "%s deleteByIndex[%d]", new Object[] { boQ(), Long.valueOf(bt.aO(l2)) });
      i += 1;
    }
    ba.aBQ();
    com.tencent.mm.model.c.getDataDB().sJ(l1);
    AppMethodBeat.o(22769);
  }
  
  public final void run()
  {
    AppMethodBeat.i(22770);
    int j;
    int i;
    long l1;
    if (this.oUa != null)
    {
      long l5 = bt.HI();
      j = this.oUa.size();
      Iterator localIterator2 = this.oUa.iterator();
      i = 0;
      while (localIterator2.hasNext())
      {
        String str1 = (String)localIterator2.next();
        if (!bt.isNullOrNil(str1))
        {
          long l6 = bt.HI();
          PLong localPLong1 = new PLong();
          PLong localPLong2 = new PLong();
          Object localObject4 = com.tencent.mm.plugin.f.b.bSU().bSV();
          l1 = bt.HI();
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
              ad.printErrStackTrace("MicroMsg.WxFileIndexStorage", localException, " sql [%s]", new Object[] { str2 });
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
          ad.i("MicroMsg.WxFileIndexStorage", "getNoThumbMediaMsgTimeByUsername [%s] cost[%d]", new Object[] { str1, Long.valueOf(bt.aO(l1)) });
          localPLong2.value -= 1L;
          long l3 = localPLong1.value;
          l2 = Math.max(l3 - 2592000000L, localPLong2.value);
          l1 = l2;
          if (l2 == l3) {
            l1 = l2 - 1L;
          }
          localObject1 = com.tencent.mm.plugin.f.b.bSU().bSV().t(str1, l3, l1);
          l3 = ((List)localObject1).size() + 0L;
          cI((List)localObject1);
          for (l2 = l1; l2 > localPLong2.value; l2 = l1)
          {
            long l4 = Math.max(l2 - 2592000000L, localPLong2.value);
            l1 = l4;
            if (l4 == l2) {
              l1 = l4 - 1L;
            }
            localObject1 = com.tencent.mm.plugin.f.b.bSU().bSV().t(str1, l2, l1);
            l3 += ((List)localObject1).size();
            cI((List)localObject1);
          }
          label485:
          ad.i("MicroMsg.DeleteFileByWxIndex", "%s deleteByName [%s] [%d] [%d %d] cost[%d]", new Object[] { boQ(), str1, Long.valueOf(l3), Long.valueOf(localPLong2.value), Long.valueOf(localPLong1.value), Long.valueOf(bt.aO(l6)) });
        }
        i += 1;
        if (this.oUc != null) {
          this.oUc.fa(i, j);
        }
      }
      if (this.oUc != null) {
        this.oUc.tI(this.oUd);
      }
      com.tencent.mm.plugin.f.b.bSU().bSZ();
      ad.i("MicroMsg.DeleteFileByWxIndex", "%s deleteByUsername cost[%d]", new Object[] { boQ(), Long.valueOf(bt.aO(l5)) });
      AppMethodBeat.o(22770);
      return;
    }
    if (this.oUb != null)
    {
      l1 = bt.HI();
      j = this.oUb.size();
      Iterator localIterator1 = this.oUb.iterator();
      i = 0;
      while (localIterator1.hasNext())
      {
        cI(((com.tencent.mm.plugin.clean.c.c)localIterator1.next()).oUi);
        i += 1;
        if (this.oUc != null) {
          this.oUc.fa(i, j);
        }
      }
      if (this.oUc != null) {
        this.oUc.tI(this.oUd);
      }
      com.tencent.mm.plugin.f.b.bSU().bSZ();
      ad.i("MicroMsg.DeleteFileByWxIndex", "%s deleteByNewAnalyseItem cost[%d]", new Object[] { boQ(), Long.valueOf(bt.aO(l1)) });
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