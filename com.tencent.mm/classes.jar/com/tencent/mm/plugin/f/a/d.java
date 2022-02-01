package com.tencent.mm.plugin.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.g;
import com.tencent.mm.av.i;
import com.tencent.mm.av.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.List;

public final class d
  extends a
{
  protected final List<com.tencent.mm.plugin.f.b.a> ae(bv parambv)
  {
    AppMethodBeat.i(22730);
    if (parambv == null)
    {
      AppMethodBeat.o(22730);
      return null;
    }
    g localg = q.aIX().L(parambv);
    if ((localg == null) || (localg.doE == 0L))
    {
      ae.w("MicroMsg.ImageMsgHandler", "%s can not get imgInfo", new Object[] { info() });
      AppMethodBeat.o(22730);
      return null;
    }
    String str2 = q.aIX().o(localg.ico, "", "");
    long l7 = o.aZR(str2);
    String str1 = q.aIX().o(localg.icq, "", "");
    long l8 = o.aZR(str1);
    Object localObject7 = q.aIX().o(localg.icq, "", "") + "hd";
    long l9 = o.aZR((String)localObject7);
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
    if (localg.aIB())
    {
      localg = q.aIX().pw(localg.icz);
      l3 = l1;
      l4 = l2;
      l5 = l6;
      localObject1 = localObject6;
      localObject2 = localObject5;
      localObject3 = localObject4;
      if (localg != null)
      {
        localObject4 = q.aIX().o(localg.ico, "", "");
        if (!bu.lX((String)localObject4, str2)) {
          l1 = o.aZR((String)localObject4);
        }
        localObject5 = q.aIX().o(localg.icq, "", "");
        if (!bu.lX((String)localObject5, str1)) {
          l2 = o.aZR((String)localObject5);
        }
        localObject6 = q.aIX().o(localg.icq, "", "") + "hd";
        l3 = l1;
        l4 = l2;
        l5 = l6;
        localObject1 = localObject6;
        localObject2 = localObject5;
        localObject3 = localObject4;
        if (!bu.lX((String)localObject6, (String)localObject7))
        {
          l5 = o.aZR((String)localObject6);
          localObject3 = localObject4;
          localObject2 = localObject5;
          localObject1 = localObject6;
          l4 = l2;
          l3 = l1;
        }
      }
    }
    localObject4 = af(parambv);
    ((com.tencent.mm.plugin.f.b.a)localObject4).field_msgSubType = 20;
    ((com.tencent.mm.plugin.f.b.a)localObject4).field_path = aJh(str2);
    ((com.tencent.mm.plugin.f.b.a)localObject4).field_size = l7;
    localObject5 = af(parambv);
    ((com.tencent.mm.plugin.f.b.a)localObject5).field_msgSubType = 21;
    ((com.tencent.mm.plugin.f.b.a)localObject5).field_path = aJh(str1);
    ((com.tencent.mm.plugin.f.b.a)localObject5).field_size = l8;
    localObject6 = af(parambv);
    ((com.tencent.mm.plugin.f.b.a)localObject6).field_msgSubType = 22;
    ((com.tencent.mm.plugin.f.b.a)localObject6).field_path = aJh((String)localObject7);
    ((com.tencent.mm.plugin.f.b.a)localObject6).field_size = l9;
    localObject7 = af(parambv);
    ((com.tencent.mm.plugin.f.b.a)localObject7).field_msgSubType = 23;
    ((com.tencent.mm.plugin.f.b.a)localObject7).field_path = aJh((String)localObject3);
    ((com.tencent.mm.plugin.f.b.a)localObject7).field_size = l3;
    localObject3 = af(parambv);
    ((com.tencent.mm.plugin.f.b.a)localObject3).field_msgSubType = 24;
    ((com.tencent.mm.plugin.f.b.a)localObject3).field_path = aJh(localObject2);
    ((com.tencent.mm.plugin.f.b.a)localObject3).field_size = l4;
    parambv = af(parambv);
    parambv.field_msgSubType = 25;
    parambv.field_path = aJh((String)localObject1);
    parambv.field_size = l5;
    ae.i("MicroMsg.ImageMsgHandler", "%s create image wx file index bigItem[%s] thumb[%s][%s] hd[%s %s %s]", new Object[] { info(), localObject4, localObject5, localObject6, localObject7, localObject3, parambv });
    localObject1 = new ArrayList();
    ((List)localObject1).add(localObject4);
    ((List)localObject1).add(localObject5);
    ((List)localObject1).add(localObject6);
    ((List)localObject1).add(localObject7);
    ((List)localObject1).add(localObject3);
    ((List)localObject1).add(parambv);
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