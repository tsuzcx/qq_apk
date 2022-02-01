package com.tencent.mm.plugin.calcwx.a;

import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.calcwx.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class a
{
  private static int a(List<com.tencent.mm.plugin.calcwx.b.a> paramList1, List<com.tencent.mm.plugin.calcwx.b.a> paramList2, List<com.tencent.mm.plugin.calcwx.b.a> paramList3, List<com.tencent.mm.plugin.calcwx.b.a> paramList4)
  {
    if ((paramList2 == null) || (paramList2.isEmpty())) {
      return -1;
    }
    if ((paramList1 == null) || (paramList1.isEmpty()))
    {
      paramList1 = paramList2.iterator();
      while (paramList1.hasNext()) {
        paramList3.add((com.tencent.mm.plugin.calcwx.b.a)paramList1.next());
      }
      return 0;
    }
    int k = paramList1.size();
    int m = paramList2.size();
    int i = 0;
    int j = 0;
    while (i < m)
    {
      com.tencent.mm.plugin.calcwx.b.a locala2 = (com.tencent.mm.plugin.calcwx.b.a)paramList2.get(i);
      if (locala2 == null) {
        break;
      }
      com.tencent.mm.plugin.calcwx.b.a locala1;
      if (j < k)
      {
        locala1 = (com.tencent.mm.plugin.calcwx.b.a)paramList1.get(j);
        label132:
        if (locala1 == null) {
          break;
        }
        if (locala2.field_msgSubType != locala1.field_msgSubType) {
          break label244;
        }
        if (Util.isEqual(locala2.field_path, locala1.field_path)) {
          break label206;
        }
        locala2.systemRowid = locala1.systemRowid;
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
        if (!Util.isEqual(locala2.field_size, locala1.field_size))
        {
          locala2.systemRowid = locala1.systemRowid;
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
  
  protected static com.tencent.mm.plugin.calcwx.b.a aH(cc paramcc)
  {
    com.tencent.mm.plugin.calcwx.b.a locala = new com.tencent.mm.plugin.calcwx.b.a();
    locala.field_msgId = paramcc.field_msgId;
    locala.field_msgType = paramcc.getType();
    locala.field_username = paramcc.field_talker;
    locala.field_msgtime = paramcc.getCreateTime();
    return locala;
  }
  
  public final void aF(cc paramcc)
  {
    int j = 0;
    if (paramcc == null) {
      return;
    }
    List localList = com.tencent.mm.plugin.calcwx.a.diz().diA().aI(paramcc);
    paramcc = aG(paramcc);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int k = a(localList, paramcc, localArrayList1, localArrayList2);
    String str = info();
    if (localList != null) {}
    for (int i = localList.size();; i = 0)
    {
      if (paramcc != null) {
        j = paramcc.size();
      }
      Log.i("MicroMsg.AbstractMsgHandler", "%s handle compare[%d] db[%d] create[%d] insert[%d] update[%d]", new Object[] { str, Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localArrayList1.size()), Integer.valueOf(localArrayList2.size()) });
      if (k < 0) {
        break;
      }
      if (!localArrayList1.isEmpty()) {
        com.tencent.mm.plugin.calcwx.a.diz().diA().eI(localArrayList1);
      }
      if (localArrayList2.isEmpty()) {
        break;
      }
      com.tencent.mm.plugin.calcwx.a.diz().diA().eJ(localArrayList2);
      return;
    }
  }
  
  protected abstract List<com.tencent.mm.plugin.calcwx.b.a> aG(cc paramcc);
  
  protected final String aja(String paramString)
  {
    if (Util.isNullOrNil(paramString)) {
      str1 = "";
    }
    String str2;
    int i;
    do
    {
      return str1;
      str2 = h.baE().mCI;
      i = paramString.indexOf(str2);
      str1 = paramString;
    } while (i < 0);
    String str1 = paramString.substring(i + str2.length());
    Log.d("MicroMsg.AbstractMsgHandler", "%s cut down result[%s] root[%s] path[%s]", new Object[] { info(), str1, str2, paramString });
    return str1;
  }
  
  protected abstract String info();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.calcwx.a.a
 * JD-Core Version:    0.7.0.1
 */