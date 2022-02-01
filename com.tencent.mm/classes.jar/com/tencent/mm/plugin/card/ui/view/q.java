package com.tencent.mm.plugin.card.ui.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.protocal.protobuf.ty;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class q
  extends g
{
  public String qdP = "";
  
  public final ab cxB()
  {
    AppMethodBeat.i(113704);
    s locals = new s(this, this.pQZ);
    AppMethodBeat.o(113704);
    return locals;
  }
  
  public final ab cxC()
  {
    AppMethodBeat.i(113705);
    p localp = new p(this, this.pQZ);
    AppMethodBeat.o(113705);
    return localp;
  }
  
  public final ab cxD()
  {
    AppMethodBeat.i(113706);
    r localr = new r(this, this.pQZ);
    AppMethodBeat.o(113706);
    return localr;
  }
  
  public final String e(c paramc)
  {
    AppMethodBeat.i(113703);
    if (!Util.isNullOrNil(this.pQV.csR().LcE))
    {
      paramc = this.pQV.csR().LcE;
      AppMethodBeat.o(113703);
      return paramc;
    }
    if ((this.pQV.csK()) && (!Util.isNullOrNil(this.qdP)))
    {
      paramc = this.qdP;
      AppMethodBeat.o(113703);
      return paramc;
    }
    paramc = this.pQV.csR().code;
    AppMethodBeat.o(113703);
    return paramc;
  }
  
  public final boolean f(b paramb)
  {
    AppMethodBeat.i(113702);
    if (this.pQV == null)
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
    Object localObject = this.pQV.csR().code;
    String str = paramb.csR().code;
    if ((!Util.isNullOrNil((String)localObject)) && (!Util.isNullOrNil(str)) && (!((String)localObject).equals(str)))
    {
      Log.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain   code  is diffrent！");
      AppMethodBeat.o(113702);
      return true;
    }
    localObject = this.pQV.csQ().Lfe;
    paramb = paramb.csQ().Lfe;
    if (((localObject == null) && (paramb != null)) || ((localObject != null) && (paramb == null)))
    {
      Log.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field  is diffrent！");
      AppMethodBeat.o(113702);
      return true;
    }
    if ((localObject != null) && (paramb != null) && (((abz)localObject).title != null) && (paramb.title != null) && (!((abz)localObject).title.equals(paramb.title)))
    {
      Log.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field title is diffrent！");
      AppMethodBeat.o(113702);
      return true;
    }
    if ((localObject != null) && (paramb != null) && (((abz)localObject).pRZ != null) && (paramb.pRZ != null) && (!((abz)localObject).pRZ.equals(paramb.pRZ)))
    {
      Log.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field aux_title  is diffrent！");
      AppMethodBeat.o(113702);
      return true;
    }
    if ((this.pQV.csK()) && (!Util.isNullOrNil(this.qdP)))
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