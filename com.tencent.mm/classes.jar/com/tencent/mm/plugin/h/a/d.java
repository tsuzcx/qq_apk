package com.tencent.mm.plugin.h.a;

import com.tencent.mm.as.g;
import com.tencent.mm.as.o;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.List;

public final class d
  extends a
{
  protected final List<com.tencent.mm.plugin.h.b.a> M(bi parambi)
  {
    if (parambi == null) {
      return null;
    }
    com.tencent.mm.as.e locale = o.OJ().q(parambi);
    if ((locale == null) || (locale.enp == 0L))
    {
      y.w("MicroMsg.ImageMsgHandler", "%s can not get imgInfo", new Object[] { ayN() });
      return null;
    }
    String str2 = o.OJ().o(locale.enq, "", "");
    long l7 = com.tencent.mm.vfs.e.aeQ(str2);
    String str1 = o.OJ().o(locale.ens, "", "");
    long l8 = com.tencent.mm.vfs.e.aeQ(str1);
    Object localObject7 = o.OJ().o(locale.ens, "", "") + "hd";
    long l9 = com.tencent.mm.vfs.e.aeQ((String)localObject7);
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject6 = null;
    long l1 = 0L;
    long l2 = 0L;
    long l6 = 0L;
    long l3 = l1;
    long l4 = l2;
    long l5 = l6;
    Object localObject1 = localObject6;
    Object localObject2 = localObject5;
    Object localObject3 = localObject4;
    if (locale.Or())
    {
      locale = o.OJ().iH(locale.enz);
      l3 = l1;
      l4 = l2;
      l5 = l6;
      localObject1 = localObject6;
      localObject2 = localObject5;
      localObject3 = localObject4;
      if (locale != null)
      {
        localObject4 = o.OJ().o(locale.enq, "", "");
        if (!bk.isEqual((String)localObject4, str2)) {
          l1 = com.tencent.mm.vfs.e.aeQ((String)localObject4);
        }
        localObject5 = o.OJ().o(locale.ens, "", "");
        if (!bk.isEqual((String)localObject5, str1)) {
          l2 = com.tencent.mm.vfs.e.aeQ((String)localObject5);
        }
        localObject6 = o.OJ().o(locale.ens, "", "") + "hd";
        l3 = l1;
        l4 = l2;
        l5 = l6;
        localObject1 = localObject6;
        localObject2 = localObject5;
        localObject3 = localObject4;
        if (!bk.isEqual((String)localObject6, (String)localObject7))
        {
          l5 = com.tencent.mm.vfs.e.aeQ((String)localObject6);
          localObject3 = localObject4;
          localObject2 = localObject5;
          localObject1 = localObject6;
          l4 = l2;
          l3 = l1;
        }
      }
    }
    localObject4 = N(parambi);
    ((com.tencent.mm.plugin.h.b.a)localObject4).field_msgSubType = 20;
    ((com.tencent.mm.plugin.h.b.a)localObject4).field_path = xV(str2);
    ((com.tencent.mm.plugin.h.b.a)localObject4).field_size = l7;
    localObject5 = N(parambi);
    ((com.tencent.mm.plugin.h.b.a)localObject5).field_msgSubType = 21;
    ((com.tencent.mm.plugin.h.b.a)localObject5).field_path = xV(str1);
    ((com.tencent.mm.plugin.h.b.a)localObject5).field_size = l8;
    localObject6 = N(parambi);
    ((com.tencent.mm.plugin.h.b.a)localObject6).field_msgSubType = 22;
    ((com.tencent.mm.plugin.h.b.a)localObject6).field_path = xV((String)localObject7);
    ((com.tencent.mm.plugin.h.b.a)localObject6).field_size = l9;
    localObject7 = N(parambi);
    ((com.tencent.mm.plugin.h.b.a)localObject7).field_msgSubType = 23;
    ((com.tencent.mm.plugin.h.b.a)localObject7).field_path = xV((String)localObject3);
    ((com.tencent.mm.plugin.h.b.a)localObject7).field_size = l3;
    localObject3 = N(parambi);
    ((com.tencent.mm.plugin.h.b.a)localObject3).field_msgSubType = 24;
    ((com.tencent.mm.plugin.h.b.a)localObject3).field_path = xV(localObject2);
    ((com.tencent.mm.plugin.h.b.a)localObject3).field_size = l4;
    parambi = N(parambi);
    parambi.field_msgSubType = 25;
    parambi.field_path = xV((String)localObject1);
    parambi.field_size = l5;
    y.i("MicroMsg.ImageMsgHandler", "%s create image wx file index bigItem[%s] thumb[%s][%s] hd[%s %s %s]", new Object[] { ayN(), localObject4, localObject5, localObject6, localObject7, localObject3, parambi });
    localObject1 = new ArrayList();
    ((List)localObject1).add(localObject4);
    ((List)localObject1).add(localObject5);
    ((List)localObject1).add(localObject6);
    ((List)localObject1).add(localObject7);
    ((List)localObject1).add(localObject3);
    ((List)localObject1).add(parambi);
    return localObject1;
  }
  
  protected final String ayN()
  {
    return "image_" + hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.h.a.d
 * JD-Core Version:    0.7.0.1
 */