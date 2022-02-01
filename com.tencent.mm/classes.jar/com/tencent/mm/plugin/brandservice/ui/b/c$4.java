package com.tencent.mm.plugin.brandservice.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.ao.af;
import com.tencent.mm.cw.f;
import com.tencent.mm.cw.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.eqb;
import com.tencent.mm.protocal.protobuf.eqc;
import com.tencent.mm.protocal.protobuf.eqd;
import com.tencent.mm.protocal.protobuf.eqe;
import com.tencent.mm.protocal.protobuf.eqf;
import com.tencent.mm.protocal.protobuf.pk;
import com.tencent.mm.protocal.protobuf.pl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.aa.7;
import com.tencent.mm.storage.aa.8;
import java.util.Iterator;
import java.util.LinkedList;

final class c$4
  implements aa.a
{
  c$4(LinkedList paramLinkedList, pk parampk) {}
  
  public final int a(int paramInt1, int paramInt2, String arg3, d paramd, q paramq)
  {
    AppMethodBeat.i(6242);
    Log.i("MicroMsg.ConversationAdapter", "[TRACE_BIZRECCARD] doUpdateRecommendCard check result errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), ??? });
    synchronized (c.cEr())
    {
      c.cEr().removeAll(this.sTs);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(6242);
        return 0;
      }
    }
    paramd = (pl)d.c.b(paramd.lBS);
    if (paramd == null)
    {
      AppMethodBeat.o(6242);
      return 0;
    }
    MultiProcessMMKV.getSingleMMKV("brandService").encode("BizRecommendCardRefreshIntervalSec", Math.min(300, paramd.RTQ));
    if (paramd.RXR == null)
    {
      Log.i("MicroMsg.ConversationAdapter", "response.RecCard is null");
      AppMethodBeat.o(6242);
      return 0;
    }
    ??? = new LinkedList();
    paramq = paramd.RXR.iterator();
    while (paramq.hasNext())
    {
      eqb localeqb = (eqb)paramq.next();
      Iterator localIterator = this.sTt.RXR.iterator();
      while (localIterator.hasNext())
      {
        eqe localeqe = (eqe)localIterator.next();
        if (Util.isEqual(localeqe.RXN, localeqb.RXN)) {
          if (localeqb.Usy == null)
          {
            Log.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard BizInfo is null");
          }
          else if ((localeqb.Usy.RIs & 0x1) != 0)
          {
            af.bjB().UI(localeqb.RXN);
            h.IzE.idkeyStat(1149L, 5L, 1L, false);
            Log.w("MicroMsg.ConversationAdapter", "doUpdateRecommendCard delete card by flag %d, msgId %d", new Object[] { Integer.valueOf(localeqb.Usy.RIs), Long.valueOf(localeqb.RXN) });
          }
          else if (Util.isNullOrNil(localeqb.Usy.UserName))
          {
            Log.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard UserName is null");
          }
          else if ((Util.isNullOrNil(localeqb.RXM)) || (localeqb.RXM.get(0) == null) || (Util.isNullOrNil(((eqc)localeqb.RXM.get(0)).RTk)))
          {
            Log.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard ContentUrl is null");
          }
          else if (!Util.isEqual(localeqb.SwF, localeqe.SwF))
          {
            ???.add(localeqb);
          }
          else
          {
            Log.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard VersionInfo isEqual");
            if ((localeqb.Usz != null) && (!Util.isEqual(localeqb.Usz.SwF, localeqe.UsB)))
            {
              ???.add(localeqb);
              Log.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard UserVersionInfo update");
            }
          }
        }
      }
    }
    Log.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard updateList size %d, RecCard.size %d", new Object[] { Integer.valueOf(???.size()), Integer.valueOf(paramd.RXR.size()) });
    if (!Util.isNullOrNil(???))
    {
      paramd = af.bjB();
      if (!Util.isNullOrNil(???))
      {
        paramq = new LinkedList();
        g.ijP().h(new aa.8(paramd, ???, paramq)).b(new aa.7(paramd, paramq));
      }
    }
    AppMethodBeat.o(6242);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.b.c.4
 * JD-Core Version:    0.7.0.1
 */