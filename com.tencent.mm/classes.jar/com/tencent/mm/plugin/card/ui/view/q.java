package com.tencent.mm.plugin.card.ui.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.protocal.protobuf.aai;
import com.tencent.mm.protocal.protobuf.st;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class q
  extends g
{
  public String oQb = "";
  
  public final ab bZM()
  {
    AppMethodBeat.i(113704);
    s locals = new s(this, this.oDq);
    AppMethodBeat.o(113704);
    return locals;
  }
  
  public final ab bZN()
  {
    AppMethodBeat.i(113705);
    p localp = new p(this, this.oDq);
    AppMethodBeat.o(113705);
    return localp;
  }
  
  public final ab bZO()
  {
    AppMethodBeat.i(113706);
    r localr = new r(this, this.oDq);
    AppMethodBeat.o(113706);
    return localr;
  }
  
  public final String e(c paramc)
  {
    AppMethodBeat.i(113703);
    if (!bu.isNullOrNil(this.oDm.bVd().Gib))
    {
      paramc = this.oDm.bVd().Gib;
      AppMethodBeat.o(113703);
      return paramc;
    }
    if ((this.oDm.bUW()) && (!bu.isNullOrNil(this.oQb)))
    {
      paramc = this.oQb;
      AppMethodBeat.o(113703);
      return paramc;
    }
    paramc = this.oDm.bVd().code;
    AppMethodBeat.o(113703);
    return paramc;
  }
  
  public final boolean f(b paramb)
  {
    AppMethodBeat.i(113702);
    if (this.oDm == null)
    {
      ae.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain mCardInfo is null！");
      AppMethodBeat.o(113702);
      return true;
    }
    if (paramb == null)
    {
      ae.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain false  newCardInfo null！");
      AppMethodBeat.o(113702);
      return false;
    }
    Object localObject = this.oDm.bVd().code;
    String str = paramb.bVd().code;
    if ((!bu.isNullOrNil((String)localObject)) && (!bu.isNullOrNil(str)) && (!((String)localObject).equals(str)))
    {
      ae.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain   code  is diffrent！");
      AppMethodBeat.o(113702);
      return true;
    }
    localObject = this.oDm.bVc().GkB;
    paramb = paramb.bVc().GkB;
    if (((localObject == null) && (paramb != null)) || ((localObject != null) && (paramb == null)))
    {
      ae.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field  is diffrent！");
      AppMethodBeat.o(113702);
      return true;
    }
    if ((localObject != null) && (paramb != null) && (((aai)localObject).title != null) && (paramb.title != null) && (!((aai)localObject).title.equals(paramb.title)))
    {
      ae.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field title is diffrent！");
      AppMethodBeat.o(113702);
      return true;
    }
    if ((localObject != null) && (paramb != null) && (((aai)localObject).oEq != null) && (paramb.oEq != null) && (!((aai)localObject).oEq.equals(paramb.oEq)))
    {
      ae.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field aux_title  is diffrent！");
      AppMethodBeat.o(113702);
      return true;
    }
    if ((this.oDm.bUW()) && (!bu.isNullOrNil(this.oQb)))
    {
      ae.i("MicroMsg.CardCodeView", "dynamicCode updated！");
      AppMethodBeat.o(113702);
      return true;
    }
    AppMethodBeat.o(113702);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.q
 * JD-Core Version:    0.7.0.1
 */