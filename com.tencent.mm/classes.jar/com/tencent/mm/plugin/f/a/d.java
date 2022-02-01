package com.tencent.mm.plugin.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.i;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.List;

public final class d
  extends a
{
  protected final List<com.tencent.mm.plugin.f.b.a> ap(ca paramca)
  {
    AppMethodBeat.i(22730);
    if (paramca == null)
    {
      AppMethodBeat.o(22730);
      return null;
    }
    com.tencent.mm.av.g localg = q.bcR().U(paramca);
    if ((localg == null) || (localg.localId == 0L))
    {
      Log.w("MicroMsg.ImageMsgHandler", "%s can not get imgInfo", new Object[] { info() });
      AppMethodBeat.o(22730);
      return null;
    }
    String str2 = q.bcR().o(localg.iXm, "", "");
    long l7 = s.boW(str2);
    String str1 = q.bcR().o(localg.iXo, "", "");
    long l8 = s.boW(str1);
    Object localObject10 = q.bcR().o(localg.iXo, "", "") + "hd";
    long l9 = s.boW((String)localObject10);
    Object localObject9 = q.bcR().o(localg.iXn, "", "");
    long l10 = s.boW((String)localObject9);
    Object localObject8 = ((c)com.tencent.mm.kernel.g.af(c.class)).alX(str2);
    long l11 = s.boW((String)localObject8);
    Object localObject7 = ((c)com.tencent.mm.kernel.g.af(c.class)).alX((String)localObject9);
    long l12 = s.boW((String)localObject7);
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
    if (localg.bcv())
    {
      localg = q.bcR().tl(localg.iXx);
      l3 = l1;
      l4 = l2;
      l5 = l6;
      localObject1 = localObject6;
      localObject2 = localObject5;
      localObject3 = localObject4;
      if (localg != null)
      {
        localObject4 = q.bcR().o(localg.iXm, "", "");
        if (!Util.isEqual((String)localObject4, str2)) {
          l1 = s.boW((String)localObject4);
        }
        localObject5 = q.bcR().o(localg.iXo, "", "");
        if (!Util.isEqual((String)localObject5, str1)) {
          l2 = s.boW((String)localObject5);
        }
        localObject6 = q.bcR().o(localg.iXo, "", "") + "hd";
        l3 = l1;
        l4 = l2;
        l5 = l6;
        localObject1 = localObject6;
        localObject2 = localObject5;
        localObject3 = localObject4;
        if (!Util.isEqual((String)localObject6, (String)localObject10))
        {
          l5 = s.boW((String)localObject6);
          localObject3 = localObject4;
          localObject2 = localObject5;
          localObject1 = localObject6;
          l4 = l2;
          l3 = l1;
        }
      }
    }
    localObject4 = aq(paramca);
    ((com.tencent.mm.plugin.f.b.a)localObject4).field_msgSubType = 20;
    ((com.tencent.mm.plugin.f.b.a)localObject4).field_path = bxb(str2);
    ((com.tencent.mm.plugin.f.b.a)localObject4).field_size = l7;
    localObject5 = aq(paramca);
    ((com.tencent.mm.plugin.f.b.a)localObject5).field_msgSubType = 21;
    ((com.tencent.mm.plugin.f.b.a)localObject5).field_path = bxb(str1);
    ((com.tencent.mm.plugin.f.b.a)localObject5).field_size = l8;
    localObject6 = aq(paramca);
    ((com.tencent.mm.plugin.f.b.a)localObject6).field_msgSubType = 22;
    ((com.tencent.mm.plugin.f.b.a)localObject6).field_path = bxb((String)localObject10);
    ((com.tencent.mm.plugin.f.b.a)localObject6).field_size = l9;
    localObject10 = aq(paramca);
    ((com.tencent.mm.plugin.f.b.a)localObject10).field_msgSubType = 26;
    ((com.tencent.mm.plugin.f.b.a)localObject10).field_path = bxb((String)localObject9);
    ((com.tencent.mm.plugin.f.b.a)localObject10).field_size = l10;
    localObject9 = aq(paramca);
    ((com.tencent.mm.plugin.f.b.a)localObject9).field_msgSubType = 27;
    ((com.tencent.mm.plugin.f.b.a)localObject9).field_path = bxb((String)localObject8);
    ((com.tencent.mm.plugin.f.b.a)localObject9).field_size = l11;
    localObject8 = aq(paramca);
    ((com.tencent.mm.plugin.f.b.a)localObject8).field_msgSubType = 28;
    ((com.tencent.mm.plugin.f.b.a)localObject8).field_path = bxb((String)localObject7);
    ((com.tencent.mm.plugin.f.b.a)localObject8).field_size = l12;
    localObject7 = aq(paramca);
    ((com.tencent.mm.plugin.f.b.a)localObject7).field_msgSubType = 23;
    ((com.tencent.mm.plugin.f.b.a)localObject7).field_path = bxb((String)localObject3);
    ((com.tencent.mm.plugin.f.b.a)localObject7).field_size = l3;
    localObject3 = aq(paramca);
    ((com.tencent.mm.plugin.f.b.a)localObject3).field_msgSubType = 24;
    ((com.tencent.mm.plugin.f.b.a)localObject3).field_path = bxb(localObject2);
    ((com.tencent.mm.plugin.f.b.a)localObject3).field_size = l4;
    paramca = aq(paramca);
    paramca.field_msgSubType = 25;
    paramca.field_path = bxb((String)localObject1);
    paramca.field_size = l5;
    Log.i("MicroMsg.ImageMsgHandler", "%s create image wx file index bigItem[%s] thumb[%s][%s] hd[%s %s %s] mid[%s] hevc[%s %s]", new Object[] { info(), localObject4, localObject5, localObject6, localObject7, localObject3, paramca, localObject10, localObject9, localObject8 });
    localObject1 = new ArrayList();
    ((List)localObject1).add(localObject4);
    ((List)localObject1).add(localObject5);
    ((List)localObject1).add(localObject6);
    ((List)localObject1).add(localObject10);
    ((List)localObject1).add(localObject9);
    ((List)localObject1).add(localObject8);
    ((List)localObject1).add(localObject7);
    ((List)localObject1).add(localObject3);
    ((List)localObject1).add(paramca);
    if ((l10 > 0L) || (l11 > 0L) || (l12 > 0L))
    {
      paramca = MultiProcessMMKV.getMMKV("CleanCalcMMKV");
      if (l10 > 0L) {
        paramca.encode("CleanCalcMidImg", paramca.getLong("CleanCalcMidImg", 0L) + l10);
      }
      if ((l11 > 0L) || (l12 > 0L)) {
        paramca.encode("CleanCalcHevcImg", paramca.getLong("CleanCalcHevcImg", 0L) + l11 + l12);
      }
    }
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