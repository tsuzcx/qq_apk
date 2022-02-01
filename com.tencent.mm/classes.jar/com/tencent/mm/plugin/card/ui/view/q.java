package com.tencent.mm.plugin.card.ui.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class q
  extends g
{
  public String oJz = "";
  
  public final ab bYx()
  {
    AppMethodBeat.i(113704);
    s locals = new s(this, this.owO);
    AppMethodBeat.o(113704);
    return locals;
  }
  
  public final ab bYy()
  {
    AppMethodBeat.i(113705);
    p localp = new p(this, this.owO);
    AppMethodBeat.o(113705);
    return localp;
  }
  
  public final ab bYz()
  {
    AppMethodBeat.i(113706);
    r localr = new r(this, this.owO);
    AppMethodBeat.o(113706);
    return localr;
  }
  
  public final String e(c paramc)
  {
    AppMethodBeat.i(113703);
    if (!bt.isNullOrNil(this.owK.bTO().FPC))
    {
      paramc = this.owK.bTO().FPC;
      AppMethodBeat.o(113703);
      return paramc;
    }
    if ((this.owK.bTH()) && (!bt.isNullOrNil(this.oJz)))
    {
      paramc = this.oJz;
      AppMethodBeat.o(113703);
      return paramc;
    }
    paramc = this.owK.bTO().code;
    AppMethodBeat.o(113703);
    return paramc;
  }
  
  public final boolean f(b paramb)
  {
    AppMethodBeat.i(113702);
    if (this.owK == null)
    {
      ad.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain mCardInfo is null！");
      AppMethodBeat.o(113702);
      return true;
    }
    if (paramb == null)
    {
      ad.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain false  newCardInfo null！");
      AppMethodBeat.o(113702);
      return false;
    }
    Object localObject = this.owK.bTO().code;
    String str = paramb.bTO().code;
    if ((!bt.isNullOrNil((String)localObject)) && (!bt.isNullOrNil(str)) && (!((String)localObject).equals(str)))
    {
      ad.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain   code  is diffrent！");
      AppMethodBeat.o(113702);
      return true;
    }
    localObject = this.owK.bTN().FSc;
    paramb = paramb.bTN().FSc;
    if (((localObject == null) && (paramb != null)) || ((localObject != null) && (paramb == null)))
    {
      ad.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field  is diffrent！");
      AppMethodBeat.o(113702);
      return true;
    }
    if ((localObject != null) && (paramb != null) && (((aaf)localObject).title != null) && (paramb.title != null) && (!((aaf)localObject).title.equals(paramb.title)))
    {
      ad.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field title is diffrent！");
      AppMethodBeat.o(113702);
      return true;
    }
    if ((localObject != null) && (paramb != null) && (((aaf)localObject).oxO != null) && (paramb.oxO != null) && (!((aaf)localObject).oxO.equals(paramb.oxO)))
    {
      ad.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field aux_title  is diffrent！");
      AppMethodBeat.o(113702);
      return true;
    }
    if ((this.owK.bTH()) && (!bt.isNullOrNil(this.oJz)))
    {
      ad.i("MicroMsg.CardCodeView", "dynamicCode updated！");
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