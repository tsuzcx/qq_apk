package com.tencent.mm.plugin.h.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.g;
import com.tencent.mm.ay.i;
import com.tencent.mm.ay.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.List;

public final class d
  extends a
{
  protected final List<com.tencent.mm.plugin.h.b.a> ax(ca paramca)
  {
    AppMethodBeat.i(22730);
    if (paramca == null)
    {
      AppMethodBeat.o(22730);
      return null;
    }
    g localg = q.bmh().aa(paramca);
    if ((localg == null) || (localg.localId == 0L))
    {
      Log.w("MicroMsg.ImageMsgHandler", "%s can not get imgInfo", new Object[] { info() });
      AppMethodBeat.o(22730);
      return null;
    }
    String str2 = q.bmh().r(localg.lNH, "", "");
    long l7 = u.bBQ(str2);
    String str1 = q.bmh().r(localg.lNJ, "", "");
    long l8 = u.bBQ(str1);
    Object localObject10 = q.bmh().r(localg.lNJ, "", "") + "hd";
    long l9 = u.bBQ((String)localObject10);
    Object localObject9 = q.bmh().r(localg.lNI, "", "");
    long l10 = u.bBQ((String)localObject9);
    Object localObject8 = ((c)h.ae(c.class)).atR(str2);
    long l11 = u.bBQ((String)localObject8);
    Object localObject7 = ((c)h.ae(c.class)).atR((String)localObject9);
    long l12 = u.bBQ((String)localObject7);
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
    if (localg.blK())
    {
      localg = q.bmh().wl(localg.lNR);
      l3 = l1;
      l4 = l2;
      l5 = l6;
      localObject1 = localObject6;
      localObject2 = localObject5;
      localObject3 = localObject4;
      if (localg != null)
      {
        localObject4 = q.bmh().r(localg.lNH, "", "");
        if (!Util.isEqual((String)localObject4, str2)) {
          l1 = u.bBQ((String)localObject4);
        }
        localObject5 = q.bmh().r(localg.lNJ, "", "");
        if (!Util.isEqual((String)localObject5, str1)) {
          l2 = u.bBQ((String)localObject5);
        }
        localObject6 = q.bmh().r(localg.lNJ, "", "") + "hd";
        l3 = l1;
        l4 = l2;
        l5 = l6;
        localObject1 = localObject6;
        localObject2 = localObject5;
        localObject3 = localObject4;
        if (!Util.isEqual((String)localObject6, (String)localObject10))
        {
          l5 = u.bBQ((String)localObject6);
          localObject3 = localObject4;
          localObject2 = localObject5;
          localObject1 = localObject6;
          l4 = l2;
          l3 = l1;
        }
      }
    }
    localObject4 = ay(paramca);
    ((com.tencent.mm.plugin.h.b.a)localObject4).field_msgSubType = 20;
    ((com.tencent.mm.plugin.h.b.a)localObject4).field_path = bAT(str2);
    ((com.tencent.mm.plugin.h.b.a)localObject4).field_size = l7;
    localObject5 = ay(paramca);
    ((com.tencent.mm.plugin.h.b.a)localObject5).field_msgSubType = 21;
    ((com.tencent.mm.plugin.h.b.a)localObject5).field_path = bAT(str1);
    ((com.tencent.mm.plugin.h.b.a)localObject5).field_size = l8;
    localObject6 = ay(paramca);
    ((com.tencent.mm.plugin.h.b.a)localObject6).field_msgSubType = 22;
    ((com.tencent.mm.plugin.h.b.a)localObject6).field_path = bAT((String)localObject10);
    ((com.tencent.mm.plugin.h.b.a)localObject6).field_size = l9;
    localObject10 = ay(paramca);
    ((com.tencent.mm.plugin.h.b.a)localObject10).field_msgSubType = 26;
    ((com.tencent.mm.plugin.h.b.a)localObject10).field_path = bAT((String)localObject9);
    ((com.tencent.mm.plugin.h.b.a)localObject10).field_size = l10;
    localObject9 = ay(paramca);
    ((com.tencent.mm.plugin.h.b.a)localObject9).field_msgSubType = 27;
    ((com.tencent.mm.plugin.h.b.a)localObject9).field_path = bAT((String)localObject8);
    ((com.tencent.mm.plugin.h.b.a)localObject9).field_size = l11;
    localObject8 = ay(paramca);
    ((com.tencent.mm.plugin.h.b.a)localObject8).field_msgSubType = 28;
    ((com.tencent.mm.plugin.h.b.a)localObject8).field_path = bAT((String)localObject7);
    ((com.tencent.mm.plugin.h.b.a)localObject8).field_size = l12;
    localObject7 = ay(paramca);
    ((com.tencent.mm.plugin.h.b.a)localObject7).field_msgSubType = 23;
    ((com.tencent.mm.plugin.h.b.a)localObject7).field_path = bAT((String)localObject3);
    ((com.tencent.mm.plugin.h.b.a)localObject7).field_size = l3;
    localObject3 = ay(paramca);
    ((com.tencent.mm.plugin.h.b.a)localObject3).field_msgSubType = 24;
    ((com.tencent.mm.plugin.h.b.a)localObject3).field_path = bAT(localObject2);
    ((com.tencent.mm.plugin.h.b.a)localObject3).field_size = l4;
    paramca = ay(paramca);
    paramca.field_msgSubType = 25;
    paramca.field_path = bAT((String)localObject1);
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
 * Qualified Name:     com.tencent.mm.plugin.h.a.d
 * JD-Core Version:    0.7.0.1
 */