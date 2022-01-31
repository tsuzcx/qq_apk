package com.tencent.mm.plugin.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.g;
import com.tencent.mm.at.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.List;

public final class d
  extends a
{
  protected final List<com.tencent.mm.plugin.f.b.a> Q(bi parambi)
  {
    AppMethodBeat.i(18621);
    if (parambi == null)
    {
      AppMethodBeat.o(18621);
      return null;
    }
    com.tencent.mm.at.e locale = o.ahC().w(parambi);
    if ((locale == null) || (locale.fDL == 0L))
    {
      ab.w("MicroMsg.ImageMsgHandler", "%s can not get imgInfo", new Object[] { bau() });
      AppMethodBeat.o(18621);
      return null;
    }
    String str2 = o.ahC().q(locale.fDM, "", "");
    long l7 = com.tencent.mm.vfs.e.avI(str2);
    String str1 = o.ahC().q(locale.fDO, "", "");
    long l8 = com.tencent.mm.vfs.e.avI(str1);
    Object localObject7 = o.ahC().q(locale.fDO, "", "") + "hd";
    long l9 = com.tencent.mm.vfs.e.avI((String)localObject7);
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
    if (locale.ahh())
    {
      locale = o.ahC().lv(locale.fDW);
      l3 = l1;
      l4 = l2;
      l5 = l6;
      localObject1 = localObject6;
      localObject2 = localObject5;
      localObject3 = localObject4;
      if (locale != null)
      {
        localObject4 = o.ahC().q(locale.fDM, "", "");
        if (!bo.isEqual((String)localObject4, str2)) {
          l1 = com.tencent.mm.vfs.e.avI((String)localObject4);
        }
        localObject5 = o.ahC().q(locale.fDO, "", "");
        if (!bo.isEqual((String)localObject5, str1)) {
          l2 = com.tencent.mm.vfs.e.avI((String)localObject5);
        }
        localObject6 = o.ahC().q(locale.fDO, "", "") + "hd";
        l3 = l1;
        l4 = l2;
        l5 = l6;
        localObject1 = localObject6;
        localObject2 = localObject5;
        localObject3 = localObject4;
        if (!bo.isEqual((String)localObject6, (String)localObject7))
        {
          l5 = com.tencent.mm.vfs.e.avI((String)localObject6);
          localObject3 = localObject4;
          localObject2 = localObject5;
          localObject1 = localObject6;
          l4 = l2;
          l3 = l1;
        }
      }
    }
    localObject4 = R(parambi);
    ((com.tencent.mm.plugin.f.b.a)localObject4).field_msgSubType = 20;
    ((com.tencent.mm.plugin.f.b.a)localObject4).field_path = Hw(str2);
    ((com.tencent.mm.plugin.f.b.a)localObject4).field_size = l7;
    localObject5 = R(parambi);
    ((com.tencent.mm.plugin.f.b.a)localObject5).field_msgSubType = 21;
    ((com.tencent.mm.plugin.f.b.a)localObject5).field_path = Hw(str1);
    ((com.tencent.mm.plugin.f.b.a)localObject5).field_size = l8;
    localObject6 = R(parambi);
    ((com.tencent.mm.plugin.f.b.a)localObject6).field_msgSubType = 22;
    ((com.tencent.mm.plugin.f.b.a)localObject6).field_path = Hw((String)localObject7);
    ((com.tencent.mm.plugin.f.b.a)localObject6).field_size = l9;
    localObject7 = R(parambi);
    ((com.tencent.mm.plugin.f.b.a)localObject7).field_msgSubType = 23;
    ((com.tencent.mm.plugin.f.b.a)localObject7).field_path = Hw((String)localObject3);
    ((com.tencent.mm.plugin.f.b.a)localObject7).field_size = l3;
    localObject3 = R(parambi);
    ((com.tencent.mm.plugin.f.b.a)localObject3).field_msgSubType = 24;
    ((com.tencent.mm.plugin.f.b.a)localObject3).field_path = Hw(localObject2);
    ((com.tencent.mm.plugin.f.b.a)localObject3).field_size = l4;
    parambi = R(parambi);
    parambi.field_msgSubType = 25;
    parambi.field_path = Hw((String)localObject1);
    parambi.field_size = l5;
    ab.i("MicroMsg.ImageMsgHandler", "%s create image wx file index bigItem[%s] thumb[%s][%s] hd[%s %s %s]", new Object[] { bau(), localObject4, localObject5, localObject6, localObject7, localObject3, parambi });
    localObject1 = new ArrayList();
    ((List)localObject1).add(localObject4);
    ((List)localObject1).add(localObject5);
    ((List)localObject1).add(localObject6);
    ((List)localObject1).add(localObject7);
    ((List)localObject1).add(localObject3);
    ((List)localObject1).add(parambi);
    AppMethodBeat.o(18621);
    return localObject1;
  }
  
  protected final String bau()
  {
    AppMethodBeat.i(18622);
    String str = "image_" + hashCode();
    AppMethodBeat.o(18622);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.d
 * JD-Core Version:    0.7.0.1
 */