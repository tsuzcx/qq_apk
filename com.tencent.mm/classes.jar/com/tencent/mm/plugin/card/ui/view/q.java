package com.tencent.mm.plugin.card.ui.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.protocal.protobuf.acg;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class q
  extends g
{
  public String tzM = "";
  
  public final ab cLd()
  {
    AppMethodBeat.i(113704);
    s locals = new s(this, this.tmY);
    AppMethodBeat.o(113704);
    return locals;
  }
  
  public final ab cLe()
  {
    AppMethodBeat.i(113705);
    p localp = new p(this, this.tmY);
    AppMethodBeat.o(113705);
    return localp;
  }
  
  public final ab cLf()
  {
    AppMethodBeat.i(113706);
    r localr = new r(this, this.tmY);
    AppMethodBeat.o(113706);
    return localr;
  }
  
  public final String e(c paramc)
  {
    AppMethodBeat.i(113703);
    if (!Util.isNullOrNil(this.tmU.cGt().SdR))
    {
      paramc = this.tmU.cGt().SdR;
      AppMethodBeat.o(113703);
      return paramc;
    }
    if ((this.tmU.cGl()) && (!Util.isNullOrNil(this.tzM)))
    {
      paramc = this.tzM;
      AppMethodBeat.o(113703);
      return paramc;
    }
    paramc = this.tmU.cGt().code;
    AppMethodBeat.o(113703);
    return paramc;
  }
  
  public final boolean f(b paramb)
  {
    AppMethodBeat.i(113702);
    if (this.tmU == null)
    {
      Log.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain mCardInfo is null！");
      AppMethodBeat.o(113702);
      return true;
    }
    if (paramb == null)
    {
      Log.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain false  newCardInfo null！");
      AppMethodBeat.o(113702);
      return false;
    }
    Object localObject = this.tmU.cGt().code;
    String str = paramb.cGt().code;
    if ((!Util.isNullOrNil((String)localObject)) && (!Util.isNullOrNil(str)) && (!((String)localObject).equals(str)))
    {
      Log.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain   code  is diffrent！");
      AppMethodBeat.o(113702);
      return true;
    }
    localObject = this.tmU.cGs().Sgs;
    paramb = paramb.cGs().Sgs;
    if (((localObject == null) && (paramb != null)) || ((localObject != null) && (paramb == null)))
    {
      Log.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field  is diffrent！");
      AppMethodBeat.o(113702);
      return true;
    }
    if ((localObject != null) && (paramb != null) && (((acg)localObject).title != null) && (paramb.title != null) && (!((acg)localObject).title.equals(paramb.title)))
    {
      Log.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field title is diffrent！");
      AppMethodBeat.o(113702);
      return true;
    }
    if ((localObject != null) && (paramb != null) && (((acg)localObject).tnZ != null) && (paramb.tnZ != null) && (!((acg)localObject).tnZ.equals(paramb.tnZ)))
    {
      Log.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field aux_title  is diffrent！");
      AppMethodBeat.o(113702);
      return true;
    }
    if ((this.tmU.cGl()) && (!Util.isNullOrNil(this.tzM)))
    {
      Log.i("MicroMsg.CardCodeView", "dynamicCode updated！");
      AppMethodBeat.o(113702);
      return true;
    }
    AppMethodBeat.o(113702);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.q
 * JD-Core Version:    0.7.0.1
 */