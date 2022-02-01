package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.model.d;
import com.tencent.mm.pluginsdk.model.c;
import com.tencent.mm.pluginsdk.ui.tools.aa;
import com.tencent.mm.protocal.protobuf.dvv;
import com.tencent.mm.protocal.protobuf.dvy;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.LinkedList;

public class h
{
  private static int vQc = 0;
  public HashMap<String, dvy> vQa;
  public LinkedList<dvv> vQb;
  public boolean vQd;
  
  public h()
  {
    AppMethodBeat.i(6137);
    this.vQa = new HashMap();
    this.vQb = new LinkedList();
    this.vQd = false;
    AppMethodBeat.o(6137);
  }
  
  static int g(e parame)
  {
    AppMethodBeat.i(302245);
    if (Util.isNullOrNil(parame.YSM))
    {
      AppMethodBeat.o(302245);
      return 0;
    }
    c localc = c.XPt;
    if (c.pa(parame.YIf, parame.YSM))
    {
      AppMethodBeat.o(302245);
      return 1;
    }
    AppMethodBeat.o(302245);
    return 2;
  }
  
  public final void a(e parame, boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(302260);
    if (parame == null)
    {
      AppMethodBeat.o(302260);
      return;
    }
    Object localObject1;
    Object localObject2;
    if (parame.type == 1)
    {
      localObject1 = parame.YIf + "-isFinderLive:" + paramBoolean;
      localObject2 = (dvy)this.vQa.get(localObject1);
      if (localObject2 == null)
      {
        localObject2 = new dvy();
        ((dvy)localObject2).ADE = parame.YIf;
        if (parame.vPQ)
        {
          i = 1;
          ((dvy)localObject2).abbv = i;
          ((dvy)localObject2).abbw = ((int)(System.currentTimeMillis() / 1000L));
          ((dvy)localObject2).Caf = (parame.position - 1);
          ((dvy)localObject2).wri = 1;
          ((dvy)localObject2).type = 0;
          if (!paramBoolean) {
            break label241;
          }
          i = 1;
          label148:
          ((dvy)localObject2).abbB = i;
          if (!paramBoolean) {
            break label246;
          }
          i = 1;
          label160:
          ((dvy)localObject2).ZVE = i;
          ((dvy)localObject2).abbC = parame.YSM;
          ((dvy)localObject2).mRN = parame.YSN;
          if (parame.vPV != 2) {
            break label254;
          }
        }
        label241:
        label246:
        label254:
        for (i = 1;; i = 0)
        {
          ((dvy)localObject2).abbF = i;
          this.vQa.put(localObject1, localObject2);
          if (paramBoolean) {
            break label259;
          }
          c.XPt.pc(parame.YIf, parame.YSM);
          AppMethodBeat.o(302260);
          return;
          i = 0;
          break;
          i = 0;
          break label148;
          i = g(parame);
          break label160;
        }
        label259:
        if (this.vQd)
        {
          i = 1;
          ((dvy)localObject2).abbD = i;
          if (!parame.nXh) {
            break label317;
          }
        }
        label317:
        for (i = j;; i = 0)
        {
          ((dvy)localObject2).abbE = i;
          localObject1 = c.XPt;
          c.pd(parame.YIf, parame.YSM);
          AppMethodBeat.o(302260);
          return;
          i = 0;
          break;
        }
      }
      ((dvy)localObject2).wri += 1;
      AppMethodBeat.o(302260);
      return;
    }
    long l;
    if (parame.type == 3)
    {
      localObject1 = new dvy();
      l = System.currentTimeMillis();
      ((dvy)localObject1).abbw = ((int)(l / 1000L));
      ((dvy)localObject1).Caf = (parame.position - 1);
      ((dvy)localObject1).wri = 1;
      localObject2 = d.vBI;
      if (!d.dcd()) {
        break label581;
      }
      i = 2;
      ((dvy)localObject1).type = i;
      localObject2 = d.vBI;
      ((dvy)localObject1).nQG = d.mN(false);
      if (!d.vBI.dca()) {
        break label586;
      }
      i = 1;
      label435:
      ((dvy)localObject1).abby = i;
      localObject2 = d.vBI;
      ((dvy)localObject1).abbx = d.dcb();
      localObject2 = d.vBI;
      if (!d.dbZ()) {
        break label591;
      }
      i = 1;
      label467:
      ((dvy)localObject1).abbz = i;
      i = vQc;
      vQc = i + 1;
      ((dvy)localObject1).abbJ = i;
      ((dvy)localObject1).abbA = l;
      this.vQa.put(parame.YIf, localObject1);
      parame = d.vBI;
      if (!d.dcd()) {
        break label596;
      }
    }
    label581:
    label586:
    label591:
    label596:
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(21258, new Object[] { Integer.valueOf(1), Long.valueOf(l), Integer.valueOf(0), aa.aUC(((dvy)localObject1).nQG), Integer.valueOf(i) });
      AppMethodBeat.o(302260);
      return;
      i = 1;
      break;
      i = 0;
      break label435;
      i = 0;
      break label467;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.h
 * JD-Core Version:    0.7.0.1
 */