package com.tencent.mm.plugin.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.e;
import com.tencent.mm.aw.g;
import com.tencent.mm.aw.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.List;

public final class d
  extends a
{
  protected final List<com.tencent.mm.plugin.f.b.a> ac(bl parambl)
  {
    AppMethodBeat.i(22730);
    if (parambl == null)
    {
      AppMethodBeat.o(22730);
      return null;
    }
    e locale = o.ayF().I(parambl);
    if ((locale == null) || (locale.deI == 0L))
    {
      ad.w("MicroMsg.ImageMsgHandler", "%s can not get imgInfo", new Object[] { info() });
      AppMethodBeat.o(22730);
      return null;
    }
    String str2 = o.ayF().p(locale.hgj, "", "");
    long l7 = i.aMN(str2);
    String str1 = o.ayF().p(locale.hgl, "", "");
    long l8 = i.aMN(str1);
    Object localObject7 = o.ayF().p(locale.hgl, "", "") + "hd";
    long l9 = i.aMN((String)localObject7);
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
    if (locale.ayi())
    {
      locale = o.ayF().od(locale.hgu);
      l3 = l1;
      l4 = l2;
      l5 = l6;
      localObject1 = localObject6;
      localObject2 = localObject5;
      localObject3 = localObject4;
      if (locale != null)
      {
        localObject4 = o.ayF().p(locale.hgj, "", "");
        if (!bt.kU((String)localObject4, str2)) {
          l1 = i.aMN((String)localObject4);
        }
        localObject5 = o.ayF().p(locale.hgl, "", "");
        if (!bt.kU((String)localObject5, str1)) {
          l2 = i.aMN((String)localObject5);
        }
        localObject6 = o.ayF().p(locale.hgl, "", "") + "hd";
        l3 = l1;
        l4 = l2;
        l5 = l6;
        localObject1 = localObject6;
        localObject2 = localObject5;
        localObject3 = localObject4;
        if (!bt.kU((String)localObject6, (String)localObject7))
        {
          l5 = i.aMN((String)localObject6);
          localObject3 = localObject4;
          localObject2 = localObject5;
          localObject1 = localObject6;
          l4 = l2;
          l3 = l1;
        }
      }
    }
    localObject4 = ad(parambl);
    ((com.tencent.mm.plugin.f.b.a)localObject4).field_msgSubType = 20;
    ((com.tencent.mm.plugin.f.b.a)localObject4).field_path = aUM(str2);
    ((com.tencent.mm.plugin.f.b.a)localObject4).field_size = l7;
    localObject5 = ad(parambl);
    ((com.tencent.mm.plugin.f.b.a)localObject5).field_msgSubType = 21;
    ((com.tencent.mm.plugin.f.b.a)localObject5).field_path = aUM(str1);
    ((com.tencent.mm.plugin.f.b.a)localObject5).field_size = l8;
    localObject6 = ad(parambl);
    ((com.tencent.mm.plugin.f.b.a)localObject6).field_msgSubType = 22;
    ((com.tencent.mm.plugin.f.b.a)localObject6).field_path = aUM((String)localObject7);
    ((com.tencent.mm.plugin.f.b.a)localObject6).field_size = l9;
    localObject7 = ad(parambl);
    ((com.tencent.mm.plugin.f.b.a)localObject7).field_msgSubType = 23;
    ((com.tencent.mm.plugin.f.b.a)localObject7).field_path = aUM((String)localObject3);
    ((com.tencent.mm.plugin.f.b.a)localObject7).field_size = l3;
    localObject3 = ad(parambl);
    ((com.tencent.mm.plugin.f.b.a)localObject3).field_msgSubType = 24;
    ((com.tencent.mm.plugin.f.b.a)localObject3).field_path = aUM(localObject2);
    ((com.tencent.mm.plugin.f.b.a)localObject3).field_size = l4;
    parambl = ad(parambl);
    parambl.field_msgSubType = 25;
    parambl.field_path = aUM((String)localObject1);
    parambl.field_size = l5;
    ad.i("MicroMsg.ImageMsgHandler", "%s create image wx file index bigItem[%s] thumb[%s][%s] hd[%s %s %s]", new Object[] { info(), localObject4, localObject5, localObject6, localObject7, localObject3, parambl });
    localObject1 = new ArrayList();
    ((List)localObject1).add(localObject4);
    ((List)localObject1).add(localObject5);
    ((List)localObject1).add(localObject6);
    ((List)localObject1).add(localObject7);
    ((List)localObject1).add(localObject3);
    ((List)localObject1).add(parambl);
    AppMethodBeat.o(22730);
    return localObject1;
  }
  
  protected final String info()
  {
    AppMethodBeat.i(22731);
    String str = "image_" + hashCode();
    AppMethodBeat.o(22731);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.d
 * JD-Core Version:    0.7.0.1
 */