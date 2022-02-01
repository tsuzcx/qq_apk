package com.tencent.mm.plugin.card.ui.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class j
  extends g
{
  public final ab bYx()
  {
    AppMethodBeat.i(113676);
    v localv = new v(this, this.owO);
    AppMethodBeat.o(113676);
    return localv;
  }
  
  public final ab bYy()
  {
    AppMethodBeat.i(113677);
    f localf = new f(this, this.owO);
    AppMethodBeat.o(113677);
    return localf;
  }
  
  public final ab bYz()
  {
    AppMethodBeat.i(113678);
    t localt = new t(this, this.owO);
    AppMethodBeat.o(113678);
    return localt;
  }
  
  public final String e(c paramc)
  {
    AppMethodBeat.i(113675);
    paramc = this.owK.bTO().code;
    AppMethodBeat.o(113675);
    return paramc;
  }
  
  public final boolean f(b paramb)
  {
    AppMethodBeat.i(113674);
    if (this.owK == null)
    {
      ad.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain mCardInfo is null！");
      AppMethodBeat.o(113674);
      return true;
    }
    if (paramb == null)
    {
      ad.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain false  newCardInfo null！");
      AppMethodBeat.o(113674);
      return false;
    }
    String str = this.owK.bTO().code;
    paramb = paramb.bTO().code;
    if ((!bt.isNullOrNil(str)) && (!bt.isNullOrNil(paramb)) && (!str.equals(paramb)))
    {
      ad.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain   code  is diffrent！");
      AppMethodBeat.o(113674);
      return true;
    }
    AppMethodBeat.o(113674);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.j
 * JD-Core Version:    0.7.0.1
 */