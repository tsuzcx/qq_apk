package com.tencent.mm.plugin.card.ui.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.protocal.protobuf.qo;
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.protocal.protobuf.xo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class q
  extends g
{
  public String nDf = "";
  
  public final ab bMH()
  {
    AppMethodBeat.i(113704);
    s locals = new s(this, this.nqt);
    AppMethodBeat.o(113704);
    return locals;
  }
  
  public final ab bMI()
  {
    AppMethodBeat.i(113705);
    p localp = new p(this, this.nqt);
    AppMethodBeat.o(113705);
    return localp;
  }
  
  public final ab bMJ()
  {
    AppMethodBeat.i(113706);
    r localr = new r(this, this.nqt);
    AppMethodBeat.o(113706);
    return localr;
  }
  
  public final String e(c paramc)
  {
    AppMethodBeat.i(113703);
    if (!bt.isNullOrNil(this.nqp.bHW().CPH))
    {
      paramc = this.nqp.bHW().CPH;
      AppMethodBeat.o(113703);
      return paramc;
    }
    if ((this.nqp.bHP()) && (!bt.isNullOrNil(this.nDf)))
    {
      paramc = this.nDf;
      AppMethodBeat.o(113703);
      return paramc;
    }
    paramc = this.nqp.bHW().code;
    AppMethodBeat.o(113703);
    return paramc;
  }
  
  public final boolean f(b paramb)
  {
    AppMethodBeat.i(113702);
    if (this.nqp == null)
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
    Object localObject = this.nqp.bHW().code;
    String str = paramb.bHW().code;
    if ((!bt.isNullOrNil((String)localObject)) && (!bt.isNullOrNil(str)) && (!((String)localObject).equals(str)))
    {
      ad.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain   code  is diffrent！");
      AppMethodBeat.o(113702);
      return true;
    }
    localObject = this.nqp.bHV().CSi;
    paramb = paramb.bHV().CSi;
    if (((localObject == null) && (paramb != null)) || ((localObject != null) && (paramb == null)))
    {
      ad.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field  is diffrent！");
      AppMethodBeat.o(113702);
      return true;
    }
    if ((localObject != null) && (paramb != null) && (((xo)localObject).title != null) && (paramb.title != null) && (!((xo)localObject).title.equals(paramb.title)))
    {
      ad.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field title is diffrent！");
      AppMethodBeat.o(113702);
      return true;
    }
    if ((localObject != null) && (paramb != null) && (((xo)localObject).nrt != null) && (paramb.nrt != null) && (!((xo)localObject).nrt.equals(paramb.nrt)))
    {
      ad.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field aux_title  is diffrent！");
      AppMethodBeat.o(113702);
      return true;
    }
    if ((this.nqp.bHP()) && (!bt.isNullOrNil(this.nDf)))
    {
      ad.i("MicroMsg.CardCodeView", "dynamicCode updated！");
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