package com.tencent.mm.plugin.freewifi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.b;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.sdk.platformtools.ae;

final class m$1
  implements m.a
{
  m$1(String paramString, FreeWifiFrontPageUI paramFreeWifiFrontPageUI, int paramInt) {}
  
  public final void g(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(24701);
    Object localObject2;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (!(paramn instanceof a))
      {
        AppMethodBeat.o(24701);
        return;
      }
      paramString = ((a)paramn).cUq();
      if (paramString != null)
      {
        ae.i(this.mTR, "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[] { paramString.FNs, paramString.nJO, paramString.nIJ, Integer.valueOf(paramString.FSK), paramString.FSL, paramString.jfY, paramString.FSM });
        paramn = this.twN;
        localObject1 = FreeWifiFrontPageUI.d.tAO;
        localObject2 = new FreeWifiFrontPageUI.b();
        ((FreeWifiFrontPageUI.b)localObject2).tAK = paramString;
        paramn.a((FreeWifiFrontPageUI.d)localObject1, localObject2);
        AppMethodBeat.o(24701);
        return;
      }
      ae.i(this.mTR, "backPageInfo is null");
      paramString = this.twN;
      paramn = FreeWifiFrontPageUI.d.tAN;
      localObject1 = new FreeWifiFrontPageUI.a();
      ((FreeWifiFrontPageUI.a)localObject1).tAm = m.a(this.twd, k.b.twm, 21);
      paramString.a(paramn, localObject1);
      AppMethodBeat.o(24701);
      return;
    }
    if ((m.gd(paramInt1, paramInt2)) && (!m.ef(paramString)))
    {
      paramn = this.twN;
      localObject1 = FreeWifiFrontPageUI.d.tAN;
      localObject2 = new FreeWifiFrontPageUI.a();
      ((FreeWifiFrontPageUI.a)localObject2).text = paramString;
      ((FreeWifiFrontPageUI.a)localObject2).tAm = m.a(this.twd, k.b.twm, paramInt2);
      paramn.a((FreeWifiFrontPageUI.d)localObject1, localObject2);
      AppMethodBeat.o(24701);
      return;
    }
    paramString = this.twN;
    paramn = FreeWifiFrontPageUI.d.tAN;
    Object localObject1 = new FreeWifiFrontPageUI.a();
    ((FreeWifiFrontPageUI.a)localObject1).tAm = m.a(this.twd, k.b.twm, paramInt2);
    paramString.a(paramn, localObject1);
    AppMethodBeat.o(24701);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.m.1
 * JD-Core Version:    0.7.0.1
 */