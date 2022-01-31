package com.tencent.mm.plugin.h.a;

import com.tencent.mm.h.c.cs;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class a
{
  protected static com.tencent.mm.plugin.h.b.a N(bi parambi)
  {
    com.tencent.mm.plugin.h.b.a locala = new com.tencent.mm.plugin.h.b.a();
    locala.field_msgId = parambi.field_msgId;
    locala.field_msgType = parambi.getType();
    locala.field_username = parambi.field_talker;
    locala.field_msgtime = parambi.field_createTime;
    return locala;
  }
  
  private static int a(List<com.tencent.mm.plugin.h.b.a> paramList1, List<com.tencent.mm.plugin.h.b.a> paramList2, List<com.tencent.mm.plugin.h.b.a> paramList3, List<com.tencent.mm.plugin.h.b.a> paramList4)
  {
    if ((paramList2 == null) || (paramList2.isEmpty())) {
      return -1;
    }
    if ((paramList1 == null) || (paramList1.isEmpty()))
    {
      paramList1 = paramList2.iterator();
      while (paramList1.hasNext()) {
        paramList3.add((com.tencent.mm.plugin.h.b.a)paramList1.next());
      }
      return 0;
    }
    int k = paramList1.size();
    int m = paramList2.size();
    int i = 0;
    int j = 0;
    while (i < m)
    {
      com.tencent.mm.plugin.h.b.a locala2 = (com.tencent.mm.plugin.h.b.a)paramList2.get(i);
      if (locala2 == null) {
        break;
      }
      com.tencent.mm.plugin.h.b.a locala1;
      if (j < k)
      {
        locala1 = (com.tencent.mm.plugin.h.b.a)paramList1.get(j);
        label132:
        if (locala1 == null) {
          break;
        }
        if (locala2.field_msgSubType != locala1.field_msgSubType) {
          break label244;
        }
        if (bk.isEqual(locala2.field_path, locala1.field_path)) {
          break label206;
        }
        locala2.ujK = locala1.ujK;
        paramList4.add(locala2);
      }
      for (;;)
      {
        i += 1;
        j += 1;
        break;
        locala1 = null;
        break label132;
        label206:
        if (!bk.T(locala2.field_size, locala1.field_size))
        {
          locala2.ujK = locala1.ujK;
          paramList4.add(locala2);
        }
      }
      label244:
      if (locala2.field_msgSubType >= locala1.field_msgSubType) {
        break;
      }
      paramList3.add(locala2);
      i += 1;
    }
    return 1;
  }
  
  public final void L(bi parambi)
  {
    int j = 0;
    if (parambi == null) {
      return;
    }
    List localList = com.tencent.mm.plugin.h.b.ayE().ayF().O(parambi);
    parambi = M(parambi);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int k = a(localList, parambi, localArrayList1, localArrayList2);
    String str = ayN();
    if (localList != null) {}
    for (int i = localList.size();; i = 0)
    {
      if (parambi != null) {
        j = parambi.size();
      }
      y.i("MicroMsg.AbstractMsgHandler", "%s handle compare[%d] db[%d] create[%d] insert[%d] update[%d]", new Object[] { str, Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localArrayList1.size()), Integer.valueOf(localArrayList2.size()) });
      if (k < 0) {
        break;
      }
      if (!localArrayList1.isEmpty()) {
        com.tencent.mm.plugin.h.b.ayE().ayF().aN(localArrayList1);
      }
      if (localArrayList2.isEmpty()) {
        break;
      }
      com.tencent.mm.plugin.h.b.ayE().ayF().aO(localArrayList2);
      return;
    }
  }
  
  protected abstract List<com.tencent.mm.plugin.h.b.a> M(bi parambi);
  
  protected abstract String ayN();
  
  protected final String xV(String paramString)
  {
    if (bk.bl(paramString)) {
      str1 = "";
    }
    String str2;
    int i;
    do
    {
      return str1;
      str2 = g.DP().dKs;
      i = paramString.indexOf(str2);
      str1 = paramString;
    } while (i < 0);
    String str1 = paramString.substring(i + str2.length());
    y.d("MicroMsg.AbstractMsgHandler", "%s cut down result[%s] root[%s] path[%s]", new Object[] { ayN(), str1, str2, paramString });
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.h.a.a
 * JD-Core Version:    0.7.0.1
 */