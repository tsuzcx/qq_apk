package com.tencent.mm.plugin.clean.b;

import android.database.Cursor;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.clean.c.i;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b
  implements Runnable
{
  private long iBn = 0L;
  private List<String> iBr;
  private List<i> iBs;
  private com.tencent.mm.plugin.clean.c.h iBt;
  
  public b(List<String> paramList, List<i> paramList1, com.tencent.mm.plugin.clean.c.h paramh)
  {
    this.iBr = paramList;
    this.iBs = paramList1;
    this.iBt = paramh;
  }
  
  private void aU(List<com.tencent.mm.plugin.h.b.a> paramList)
  {
    int j = paramList.size();
    HashSet localHashSet = new HashSet();
    au.Hx();
    long l1 = c.Dv().eV(Thread.currentThread().getId());
    int i = 0;
    while (i < j)
    {
      com.tencent.mm.plugin.h.b.a locala = (com.tencent.mm.plugin.h.b.a)paramList.get(i);
      long l2 = bk.UZ();
      if (!localHashSet.contains(Long.valueOf(locala.field_msgId)))
      {
        au.Hx();
        bi localbi = c.Fy().fd(locala.field_msgId);
        if ((localbi.field_msgId != 0L) && (!localbi.cvx()))
        {
          com.tencent.mm.plugin.h.b localb = com.tencent.mm.plugin.h.b.ayE();
          long l3 = locala.field_msgId;
          localb.ije = true;
          localb.ijd.add(Long.valueOf(l3));
          y.d("MicroMsg.CalcWxService", "%d lock msg change [%d] [%s]", new Object[] { Integer.valueOf(localb.hashCode()), Long.valueOf(l3), bk.csb() });
          localbi.cvy();
          au.Hx();
          c.Fy().a(locala.field_msgId, localbi);
        }
        localHashSet.add(Long.valueOf(locala.field_msgId));
        y.d("MicroMsg.DeleteFileByWxIndex", "%s deleteByIndex handle msg[%d]", new Object[] { ayL(), Long.valueOf(bk.cp(l2)) });
      }
      if ((locala != null) && (!com.tencent.mm.plugin.h.a.oH(locala.field_msgSubType)) && (locala.field_size > 0L))
      {
        this.iBn += locala.field_size;
        com.tencent.mm.vfs.e.deleteFile(com.tencent.mm.kernel.g.DP().dKs + locala.field_path);
        locala.field_path = "";
        locala.field_size = 0L;
        com.tencent.mm.plugin.h.b.ayE().ayF().a(locala.ujK, locala, false);
      }
      y.d("MicroMsg.DeleteFileByWxIndex", "%s deleteByIndex[%d]", new Object[] { ayL(), Long.valueOf(bk.cp(l2)) });
      i += 1;
    }
    au.Hx();
    c.Dv().hI(l1);
  }
  
  private String ayL()
  {
    return hashCode();
  }
  
  public final void run()
  {
    if (this.iBr != null)
    {
      l5 = bk.UZ();
      j = this.iBr.size();
      localIterator2 = this.iBr.iterator();
      i = 0;
      while (localIterator2.hasNext())
      {
        str1 = (String)localIterator2.next();
        if (!bk.bl(str1))
        {
          l6 = bk.UZ();
          localPLong1 = new PLong();
          localPLong2 = new PLong();
          localObject4 = com.tencent.mm.plugin.h.b.ayE().ayF();
          l1 = bk.UZ();
          str2 = "select max(msgtime), min(msgtime) from WxFileIndex2 where username='" + str1 + "' and msgSubType in (1,20,23,30,32,34 ) and size > 0 ";
          localObject3 = null;
          localObject1 = null;
          try
          {
            localObject4 = ((com.tencent.mm.plugin.h.b.b)localObject4).dXw.rawQuery(str2, null);
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
              localObject3 = localObject1;
              y.printErrStackTrace("MicroMsg.WxFileIndexStorage", localException, " sql [%s]", new Object[] { str2 });
              if (localObject1 != null) {
                ((Cursor)localObject1).close();
              }
            }
          }
          finally
          {
            if (localObject3 == null) {
              break label479;
            }
            localObject3.close();
          }
          y.i("MicroMsg.WxFileIndexStorage", "getNoThumbMediaMsgTimeByUsername [%s] cost[%d]", new Object[] { str1, Long.valueOf(bk.cp(l1)) });
          localPLong2.value -= 1L;
          l3 = localPLong1.value;
          l2 = Math.max(l3 - 2592000000L, localPLong2.value);
          l1 = l2;
          if (l2 == l3) {
            l1 = l2 - 1L;
          }
          localObject1 = com.tencent.mm.plugin.h.b.ayE().ayF().j(str1, l3, l1);
          l3 = ((List)localObject1).size() + 0L;
          aU((List)localObject1);
          for (l2 = l1; l2 > localPLong2.value; l2 = l1)
          {
            l4 = Math.max(l2 - 2592000000L, localPLong2.value);
            l1 = l4;
            if (l4 == l2) {
              l1 = l4 - 1L;
            }
            localObject1 = com.tencent.mm.plugin.h.b.ayE().ayF().j(str1, l2, l1);
            l3 += ((List)localObject1).size();
            aU((List)localObject1);
          }
          label479:
          y.i("MicroMsg.DeleteFileByWxIndex", "%s deleteByName [%s] [%d] [%d %d] cost[%d]", new Object[] { ayL(), str1, Long.valueOf(l3), Long.valueOf(localPLong2.value), Long.valueOf(localPLong1.value), Long.valueOf(bk.cp(l6)) });
        }
        i += 1;
        if (this.iBt != null) {
          this.iBt.cA(i, j);
        }
      }
      if (this.iBt != null) {
        this.iBt.cZ(this.iBn);
      }
      com.tencent.mm.plugin.h.b.ayE().ayI();
      y.i("MicroMsg.DeleteFileByWxIndex", "%s deleteByUsername cost[%d]", new Object[] { ayL(), Long.valueOf(bk.cp(l5)) });
    }
    while (this.iBs == null)
    {
      long l5;
      Iterator localIterator2;
      String str1;
      long l6;
      PLong localPLong1;
      PLong localPLong2;
      Object localObject4;
      String str2;
      Object localObject3;
      Object localObject1;
      long l3;
      long l2;
      long l4;
      return;
    }
    long l1 = bk.UZ();
    int j = this.iBs.size();
    Iterator localIterator1 = this.iBs.iterator();
    int i = 0;
    while (localIterator1.hasNext())
    {
      aU(((i)localIterator1.next()).iBW);
      i += 1;
      if (this.iBt != null) {
        this.iBt.cA(i, j);
      }
    }
    if (this.iBt != null) {
      this.iBt.cZ(this.iBn);
    }
    com.tencent.mm.plugin.h.b.ayE().ayI();
    y.i("MicroMsg.DeleteFileByWxIndex", "%s deleteByNewAnalyseItem cost[%d]", new Object[] { ayL(), Long.valueOf(bk.cp(l1)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.b.b
 * JD-Core Version:    0.7.0.1
 */