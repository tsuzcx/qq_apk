package com.tencent.mm.plugin.card.ui.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.sdk.platformtools.bo;

public final class q
  extends g
{
  public String kxM = "";
  
  public final ab bfw()
  {
    AppMethodBeat.i(88777);
    s locals = new s(this, this.jpX);
    AppMethodBeat.o(88777);
    return locals;
  }
  
  public final ab bfx()
  {
    AppMethodBeat.i(88778);
    p localp = new p(this, this.jpX);
    AppMethodBeat.o(88778);
    return localp;
  }
  
  public final ab bfy()
  {
    AppMethodBeat.i(88779);
    r localr = new r(this, this.jpX);
    AppMethodBeat.o(88779);
    return localr;
  }
  
  public final String e(c paramc)
  {
    AppMethodBeat.i(88776);
    if (!bo.isNullOrNil(this.klk.bbe().wEg))
    {
      paramc = this.klk.bbe().wEg;
      AppMethodBeat.o(88776);
      return paramc;
    }
    if ((this.klk.baY()) && (!bo.isNullOrNil(this.kxM)))
    {
      paramc = this.kxM;
      AppMethodBeat.o(88776);
      return paramc;
    }
    paramc = this.klk.bbe().code;
    AppMethodBeat.o(88776);
    return paramc;
  }
  
  public final boolean f(b paramb)
  {
    AppMethodBeat.i(88775);
    if (this.klk == null)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain mCardInfo is null！");
      AppMethodBeat.o(88775);
      return true;
    }
    if (paramb == null)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain false  newCardInfo null！");
      AppMethodBeat.o(88775);
      return false;
    }
    Object localObject = this.klk.bbe().code;
    String str = paramb.bbe().code;
    if ((!bo.isNullOrNil((String)localObject)) && (!bo.isNullOrNil(str)) && (!((String)localObject).equals(str)))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain   code  is diffrent！");
      AppMethodBeat.o(88775);
      return true;
    }
    localObject = this.klk.bbd().wGD;
    paramb = paramb.bbd().wGD;
    if (((localObject == null) && (paramb != null)) || ((localObject != null) && (paramb == null)))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field  is diffrent！");
      AppMethodBeat.o(88775);
      return true;
    }
    if ((localObject != null) && (paramb != null) && (((uo)localObject).title != null) && (paramb.title != null) && (!((uo)localObject).title.equals(paramb.title)))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field title is diffrent！");
      AppMethodBeat.o(88775);
      return true;
    }
    if ((localObject != null) && (paramb != null) && (((uo)localObject).kmo != null) && (paramb.kmo != null) && (!((uo)localObject).kmo.equals(paramb.kmo)))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field aux_title  is diffrent！");
      AppMethodBeat.o(88775);
      return true;
    }
    if ((this.klk.baY()) && (!bo.isNullOrNil(this.kxM)))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CardCodeView", "dynamicCode updated！");
      AppMethodBeat.o(88775);
      return true;
    }
    AppMethodBeat.o(88775);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.q
 * JD-Core Version:    0.7.0.1
 */