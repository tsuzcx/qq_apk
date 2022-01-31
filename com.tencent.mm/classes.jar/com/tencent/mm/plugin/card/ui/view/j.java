package com.tencent.mm.plugin.card.ui.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.sdk.platformtools.bo;

public final class j
  extends g
{
  public final ab bfw()
  {
    AppMethodBeat.i(88749);
    v localv = new v(this, this.jpX);
    AppMethodBeat.o(88749);
    return localv;
  }
  
  public final ab bfx()
  {
    AppMethodBeat.i(88750);
    f localf = new f(this, this.jpX);
    AppMethodBeat.o(88750);
    return localf;
  }
  
  public final ab bfy()
  {
    AppMethodBeat.i(88751);
    t localt = new t(this, this.jpX);
    AppMethodBeat.o(88751);
    return localt;
  }
  
  public final String e(c paramc)
  {
    AppMethodBeat.i(88748);
    paramc = this.klk.bbe().code;
    AppMethodBeat.o(88748);
    return paramc;
  }
  
  public final boolean f(b paramb)
  {
    AppMethodBeat.i(88747);
    if (this.klk == null)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain mCardInfo is null！");
      AppMethodBeat.o(88747);
      return true;
    }
    if (paramb == null)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain false  newCardInfo null！");
      AppMethodBeat.o(88747);
      return false;
    }
    String str = this.klk.bbe().code;
    paramb = paramb.bbe().code;
    if ((!bo.isNullOrNil(str)) && (!bo.isNullOrNil(paramb)) && (!str.equals(paramb)))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain   code  is diffrent！");
      AppMethodBeat.o(88747);
      return true;
    }
    AppMethodBeat.o(88747);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.j
 * JD-Core Version:    0.7.0.1
 */