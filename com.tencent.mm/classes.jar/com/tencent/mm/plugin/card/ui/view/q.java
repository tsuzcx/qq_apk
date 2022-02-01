package com.tencent.mm.plugin.card.ui.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.protocal.protobuf.qy;
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.protocal.protobuf.yg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class q
  extends g
{
  public String ogg = "";
  
  public final ab bTS()
  {
    AppMethodBeat.i(113704);
    s locals = new s(this, this.nTt);
    AppMethodBeat.o(113704);
    return locals;
  }
  
  public final ab bTT()
  {
    AppMethodBeat.i(113705);
    p localp = new p(this, this.nTt);
    AppMethodBeat.o(113705);
    return localp;
  }
  
  public final ab bTU()
  {
    AppMethodBeat.i(113706);
    r localr = new r(this, this.nTt);
    AppMethodBeat.o(113706);
    return localr;
  }
  
  public final String e(c paramc)
  {
    AppMethodBeat.i(113703);
    if (!bs.isNullOrNil(this.nTp.bPj().Eis))
    {
      paramc = this.nTp.bPj().Eis;
      AppMethodBeat.o(113703);
      return paramc;
    }
    if ((this.nTp.bPc()) && (!bs.isNullOrNil(this.ogg)))
    {
      paramc = this.ogg;
      AppMethodBeat.o(113703);
      return paramc;
    }
    paramc = this.nTp.bPj().code;
    AppMethodBeat.o(113703);
    return paramc;
  }
  
  public final boolean f(b paramb)
  {
    AppMethodBeat.i(113702);
    if (this.nTp == null)
    {
      ac.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain mCardInfo is null！");
      AppMethodBeat.o(113702);
      return true;
    }
    if (paramb == null)
    {
      ac.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain false  newCardInfo null！");
      AppMethodBeat.o(113702);
      return false;
    }
    Object localObject = this.nTp.bPj().code;
    String str = paramb.bPj().code;
    if ((!bs.isNullOrNil((String)localObject)) && (!bs.isNullOrNil(str)) && (!((String)localObject).equals(str)))
    {
      ac.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain   code  is diffrent！");
      AppMethodBeat.o(113702);
      return true;
    }
    localObject = this.nTp.bPi().EkT;
    paramb = paramb.bPi().EkT;
    if (((localObject == null) && (paramb != null)) || ((localObject != null) && (paramb == null)))
    {
      ac.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field  is diffrent！");
      AppMethodBeat.o(113702);
      return true;
    }
    if ((localObject != null) && (paramb != null) && (((yg)localObject).title != null) && (paramb.title != null) && (!((yg)localObject).title.equals(paramb.title)))
    {
      ac.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field title is diffrent！");
      AppMethodBeat.o(113702);
      return true;
    }
    if ((localObject != null) && (paramb != null) && (((yg)localObject).nUt != null) && (paramb.nUt != null) && (!((yg)localObject).nUt.equals(paramb.nUt)))
    {
      ac.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field aux_title  is diffrent！");
      AppMethodBeat.o(113702);
      return true;
    }
    if ((this.nTp.bPc()) && (!bs.isNullOrNil(this.ogg)))
    {
      ac.i("MicroMsg.CardCodeView", "dynamicCode updated！");
      AppMethodBeat.o(113702);
      return true;
    }
    AppMethodBeat.o(113702);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.q
 * JD-Core Version:    0.7.0.1
 */