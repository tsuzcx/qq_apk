package com.tencent.mm.plugin.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.e;
import com.tencent.mm.av.g;
import com.tencent.mm.av.o;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.List;

public final class d
  extends a
{
  protected final List<com.tencent.mm.plugin.f.b.a> ac(bo parambo)
  {
    AppMethodBeat.i(22730);
    if (parambo == null)
    {
      AppMethodBeat.o(22730);
      return null;
    }
    e locale = o.aFx().I(parambo);
    if ((locale == null) || (locale.dcd == 0L))
    {
      ac.w("MicroMsg.ImageMsgHandler", "%s can not get imgInfo", new Object[] { info() });
      AppMethodBeat.o(22730);
      return null;
    }
    String str2 = o.aFx().p(locale.hGM, "", "");
    long l7 = i.aSp(str2);
    String str1 = o.aFx().p(locale.hGO, "", "");
    long l8 = i.aSp(str1);
    Object localObject7 = o.aFx().p(locale.hGO, "", "") + "hd";
    long l9 = i.aSp((String)localObject7);
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
    if (locale.aFa())
    {
      locale = o.aFx().oR(locale.hGX);
      l3 = l1;
      l4 = l2;
      l5 = l6;
      localObject1 = localObject6;
      localObject2 = localObject5;
      localObject3 = localObject4;
      if (locale != null)
      {
        localObject4 = o.aFx().p(locale.hGM, "", "");
        if (!bs.lr((String)localObject4, str2)) {
          l1 = i.aSp((String)localObject4);
        }
        localObject5 = o.aFx().p(locale.hGO, "", "");
        if (!bs.lr((String)localObject5, str1)) {
          l2 = i.aSp((String)localObject5);
        }
        localObject6 = o.aFx().p(locale.hGO, "", "") + "hd";
        l3 = l1;
        l4 = l2;
        l5 = l6;
        localObject1 = localObject6;
        localObject2 = localObject5;
        localObject3 = localObject4;
        if (!bs.lr((String)localObject6, (String)localObject7))
        {
          l5 = i.aSp((String)localObject6);
          localObject3 = localObject4;
          localObject2 = localObject5;
          localObject1 = localObject6;
          l4 = l2;
          l3 = l1;
        }
      }
    }
    localObject4 = ad(parambo);
    ((com.tencent.mm.plugin.f.b.a)localObject4).field_msgSubType = 20;
    ((com.tencent.mm.plugin.f.b.a)localObject4).field_path = aBR(str2);
    ((com.tencent.mm.plugin.f.b.a)localObject4).field_size = l7;
    localObject5 = ad(parambo);
    ((com.tencent.mm.plugin.f.b.a)localObject5).field_msgSubType = 21;
    ((com.tencent.mm.plugin.f.b.a)localObject5).field_path = aBR(str1);
    ((com.tencent.mm.plugin.f.b.a)localObject5).field_size = l8;
    localObject6 = ad(parambo);
    ((com.tencent.mm.plugin.f.b.a)localObject6).field_msgSubType = 22;
    ((com.tencent.mm.plugin.f.b.a)localObject6).field_path = aBR((String)localObject7);
    ((com.tencent.mm.plugin.f.b.a)localObject6).field_size = l9;
    localObject7 = ad(parambo);
    ((com.tencent.mm.plugin.f.b.a)localObject7).field_msgSubType = 23;
    ((com.tencent.mm.plugin.f.b.a)localObject7).field_path = aBR((String)localObject3);
    ((com.tencent.mm.plugin.f.b.a)localObject7).field_size = l3;
    localObject3 = ad(parambo);
    ((com.tencent.mm.plugin.f.b.a)localObject3).field_msgSubType = 24;
    ((com.tencent.mm.plugin.f.b.a)localObject3).field_path = aBR(localObject2);
    ((com.tencent.mm.plugin.f.b.a)localObject3).field_size = l4;
    parambo = ad(parambo);
    parambo.field_msgSubType = 25;
    parambo.field_path = aBR((String)localObject1);
    parambo.field_size = l5;
    ac.i("MicroMsg.ImageMsgHandler", "%s create image wx file index bigItem[%s] thumb[%s][%s] hd[%s %s %s]", new Object[] { info(), localObject4, localObject5, localObject6, localObject7, localObject3, parambo });
    localObject1 = new ArrayList();
    ((List)localObject1).add(localObject4);
    ((List)localObject1).add(localObject5);
    ((List)localObject1).add(localObject6);
    ((List)localObject1).add(localObject7);
    ((List)localObject1).add(localObject3);
    ((List)localObject1).add(parambo);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.d
 * JD-Core Version:    0.7.0.1
 */