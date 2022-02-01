package com.tencent.mm.plugin.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.g;
import com.tencent.mm.aw.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import java.util.ArrayList;
import java.util.List;

public final class d
  extends a
{
  protected final List<com.tencent.mm.plugin.f.b.a> af(bu parambu)
  {
    AppMethodBeat.i(22730);
    if (parambu == null)
    {
      AppMethodBeat.o(22730);
      return null;
    }
    g localg = q.aIF().L(parambu);
    if ((localg == null) || (localg.dnz == 0L))
    {
      ad.w("MicroMsg.ImageMsgHandler", "%s can not get imgInfo", new Object[] { info() });
      AppMethodBeat.o(22730);
      return null;
    }
    String str2 = q.aIF().o(localg.hZw, "", "");
    long l7 = com.tencent.mm.vfs.i.aYo(str2);
    String str1 = q.aIF().o(localg.hZy, "", "");
    long l8 = com.tencent.mm.vfs.i.aYo(str1);
    Object localObject7 = q.aIF().o(localg.hZy, "", "") + "hd";
    long l9 = com.tencent.mm.vfs.i.aYo((String)localObject7);
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
    if (localg.aIj())
    {
      localg = q.aIF().pt(localg.hZH);
      l3 = l1;
      l4 = l2;
      l5 = l6;
      localObject1 = localObject6;
      localObject2 = localObject5;
      localObject3 = localObject4;
      if (localg != null)
      {
        localObject4 = q.aIF().o(localg.hZw, "", "");
        if (!bt.lQ((String)localObject4, str2)) {
          l1 = com.tencent.mm.vfs.i.aYo((String)localObject4);
        }
        localObject5 = q.aIF().o(localg.hZy, "", "");
        if (!bt.lQ((String)localObject5, str1)) {
          l2 = com.tencent.mm.vfs.i.aYo((String)localObject5);
        }
        localObject6 = q.aIF().o(localg.hZy, "", "") + "hd";
        l3 = l1;
        l4 = l2;
        l5 = l6;
        localObject1 = localObject6;
        localObject2 = localObject5;
        localObject3 = localObject4;
        if (!bt.lQ((String)localObject6, (String)localObject7))
        {
          l5 = com.tencent.mm.vfs.i.aYo((String)localObject6);
          localObject3 = localObject4;
          localObject2 = localObject5;
          localObject1 = localObject6;
          l4 = l2;
          l3 = l1;
        }
      }
    }
    localObject4 = ag(parambu);
    ((com.tencent.mm.plugin.f.b.a)localObject4).field_msgSubType = 20;
    ((com.tencent.mm.plugin.f.b.a)localObject4).field_path = ahL(str2);
    ((com.tencent.mm.plugin.f.b.a)localObject4).field_size = l7;
    localObject5 = ag(parambu);
    ((com.tencent.mm.plugin.f.b.a)localObject5).field_msgSubType = 21;
    ((com.tencent.mm.plugin.f.b.a)localObject5).field_path = ahL(str1);
    ((com.tencent.mm.plugin.f.b.a)localObject5).field_size = l8;
    localObject6 = ag(parambu);
    ((com.tencent.mm.plugin.f.b.a)localObject6).field_msgSubType = 22;
    ((com.tencent.mm.plugin.f.b.a)localObject6).field_path = ahL((String)localObject7);
    ((com.tencent.mm.plugin.f.b.a)localObject6).field_size = l9;
    localObject7 = ag(parambu);
    ((com.tencent.mm.plugin.f.b.a)localObject7).field_msgSubType = 23;
    ((com.tencent.mm.plugin.f.b.a)localObject7).field_path = ahL((String)localObject3);
    ((com.tencent.mm.plugin.f.b.a)localObject7).field_size = l3;
    localObject3 = ag(parambu);
    ((com.tencent.mm.plugin.f.b.a)localObject3).field_msgSubType = 24;
    ((com.tencent.mm.plugin.f.b.a)localObject3).field_path = ahL(localObject2);
    ((com.tencent.mm.plugin.f.b.a)localObject3).field_size = l4;
    parambu = ag(parambu);
    parambu.field_msgSubType = 25;
    parambu.field_path = ahL((String)localObject1);
    parambu.field_size = l5;
    ad.i("MicroMsg.ImageMsgHandler", "%s create image wx file index bigItem[%s] thumb[%s][%s] hd[%s %s %s]", new Object[] { info(), localObject4, localObject5, localObject6, localObject7, localObject3, parambu });
    localObject1 = new ArrayList();
    ((List)localObject1).add(localObject4);
    ((List)localObject1).add(localObject5);
    ((List)localObject1).add(localObject6);
    ((List)localObject1).add(localObject7);
    ((List)localObject1).add(localObject3);
    ((List)localObject1).add(parambu);
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