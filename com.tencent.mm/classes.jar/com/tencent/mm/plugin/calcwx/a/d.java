package com.tencent.mm.plugin.calcwx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.emoji.c.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.List;

public final class d
  extends a
{
  protected final List<com.tencent.mm.plugin.calcwx.b.a> aG(cc paramcc)
  {
    AppMethodBeat.i(22730);
    if (paramcc == null)
    {
      AppMethodBeat.o(22730);
      return null;
    }
    com.tencent.mm.modelimage.h localh = r.bKa().af(paramcc);
    if ((localh == null) || (localh.localId == 0L))
    {
      Log.w("MicroMsg.ImageMsgHandler", "%s can not get imgInfo", new Object[] { info() });
      AppMethodBeat.o(22730);
      return null;
    }
    String str2 = r.bKa().v(localh.oGr, "", "");
    long l7 = y.bEl(str2);
    String str1 = r.bKa().v(localh.oGt, "", "");
    long l8 = y.bEl(str1);
    Object localObject10 = r.bKa().v(localh.oGt, "", "") + "hd";
    long l9 = y.bEl((String)localObject10);
    Object localObject9 = r.bKa().v(localh.oGs, "", "");
    long l10 = y.bEl((String)localObject9);
    Object localObject8 = ((c)com.tencent.mm.kernel.h.ax(c.class)).anI(str2);
    long l11 = y.bEl((String)localObject8);
    Object localObject7 = ((c)com.tencent.mm.kernel.h.ax(c.class)).anI((String)localObject9);
    long l12 = y.bEl((String)localObject7);
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
    if (localh.bJE())
    {
      localh = r.bKa().wq(localh.oGB);
      l3 = l1;
      l4 = l2;
      l5 = l6;
      localObject1 = localObject6;
      localObject2 = localObject5;
      localObject3 = localObject4;
      if (localh != null)
      {
        localObject4 = r.bKa().v(localh.oGr, "", "");
        if (!Util.isEqual((String)localObject4, str2)) {
          l1 = y.bEl((String)localObject4);
        }
        localObject5 = r.bKa().v(localh.oGt, "", "");
        if (!Util.isEqual((String)localObject5, str1)) {
          l2 = y.bEl((String)localObject5);
        }
        localObject6 = r.bKa().v(localh.oGt, "", "") + "hd";
        l3 = l1;
        l4 = l2;
        l5 = l6;
        localObject1 = localObject6;
        localObject2 = localObject5;
        localObject3 = localObject4;
        if (!Util.isEqual((String)localObject6, (String)localObject10))
        {
          l5 = y.bEl((String)localObject6);
          localObject3 = localObject4;
          localObject2 = localObject5;
          localObject1 = localObject6;
          l4 = l2;
          l3 = l1;
        }
      }
    }
    localObject4 = aH(paramcc);
    ((com.tencent.mm.plugin.calcwx.b.a)localObject4).field_msgSubType = 20;
    ((com.tencent.mm.plugin.calcwx.b.a)localObject4).field_path = aja(str2);
    ((com.tencent.mm.plugin.calcwx.b.a)localObject4).field_size = l7;
    localObject5 = aH(paramcc);
    ((com.tencent.mm.plugin.calcwx.b.a)localObject5).field_msgSubType = 21;
    ((com.tencent.mm.plugin.calcwx.b.a)localObject5).field_path = aja(str1);
    ((com.tencent.mm.plugin.calcwx.b.a)localObject5).field_size = l8;
    localObject6 = aH(paramcc);
    ((com.tencent.mm.plugin.calcwx.b.a)localObject6).field_msgSubType = 22;
    ((com.tencent.mm.plugin.calcwx.b.a)localObject6).field_path = aja((String)localObject10);
    ((com.tencent.mm.plugin.calcwx.b.a)localObject6).field_size = l9;
    localObject10 = aH(paramcc);
    ((com.tencent.mm.plugin.calcwx.b.a)localObject10).field_msgSubType = 26;
    ((com.tencent.mm.plugin.calcwx.b.a)localObject10).field_path = aja((String)localObject9);
    ((com.tencent.mm.plugin.calcwx.b.a)localObject10).field_size = l10;
    localObject9 = aH(paramcc);
    ((com.tencent.mm.plugin.calcwx.b.a)localObject9).field_msgSubType = 27;
    ((com.tencent.mm.plugin.calcwx.b.a)localObject9).field_path = aja((String)localObject8);
    ((com.tencent.mm.plugin.calcwx.b.a)localObject9).field_size = l11;
    localObject8 = aH(paramcc);
    ((com.tencent.mm.plugin.calcwx.b.a)localObject8).field_msgSubType = 28;
    ((com.tencent.mm.plugin.calcwx.b.a)localObject8).field_path = aja((String)localObject7);
    ((com.tencent.mm.plugin.calcwx.b.a)localObject8).field_size = l12;
    localObject7 = aH(paramcc);
    ((com.tencent.mm.plugin.calcwx.b.a)localObject7).field_msgSubType = 23;
    ((com.tencent.mm.plugin.calcwx.b.a)localObject7).field_path = aja((String)localObject3);
    ((com.tencent.mm.plugin.calcwx.b.a)localObject7).field_size = l3;
    localObject3 = aH(paramcc);
    ((com.tencent.mm.plugin.calcwx.b.a)localObject3).field_msgSubType = 24;
    ((com.tencent.mm.plugin.calcwx.b.a)localObject3).field_path = aja(localObject2);
    ((com.tencent.mm.plugin.calcwx.b.a)localObject3).field_size = l4;
    paramcc = aH(paramcc);
    paramcc.field_msgSubType = 25;
    paramcc.field_path = aja((String)localObject1);
    paramcc.field_size = l5;
    Log.i("MicroMsg.ImageMsgHandler", "%s create image wx file index bigItem[%s] thumb[%s][%s] hd[%s %s %s] mid[%s] hevc[%s %s]", new Object[] { info(), localObject4, localObject5, localObject6, localObject7, localObject3, paramcc, localObject10, localObject9, localObject8 });
    localObject1 = new ArrayList();
    ((List)localObject1).add(localObject4);
    ((List)localObject1).add(localObject5);
    ((List)localObject1).add(localObject6);
    ((List)localObject1).add(localObject10);
    ((List)localObject1).add(localObject9);
    ((List)localObject1).add(localObject8);
    ((List)localObject1).add(localObject7);
    ((List)localObject1).add(localObject3);
    ((List)localObject1).add(paramcc);
    if ((l10 > 0L) || (l11 > 0L) || (l12 > 0L))
    {
      paramcc = MultiProcessMMKV.getMMKV("CleanCalcMMKV");
      if (l10 > 0L) {
        paramcc.encode("CleanCalcMidImg", paramcc.getLong("CleanCalcMidImg", 0L) + l10);
      }
      if ((l11 > 0L) || (l12 > 0L)) {
        paramcc.encode("CleanCalcHevcImg", paramcc.getLong("CleanCalcHevcImg", 0L) + l11 + l12);
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
 * Qualified Name:     com.tencent.mm.plugin.calcwx.a.d
 * JD-Core Version:    0.7.0.1
 */