package com.tencent.mm.plugin.card.ui.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.c.c;
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.protocal.protobuf.vr;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class q
  extends g
{
  public String wEh = "";
  
  public final ab doJ()
  {
    AppMethodBeat.i(113704);
    s locals = new s(this, this.wry);
    AppMethodBeat.o(113704);
    return locals;
  }
  
  public final ab doK()
  {
    AppMethodBeat.i(113705);
    p localp = new p(this, this.wry);
    AppMethodBeat.o(113705);
    return localp;
  }
  
  public final ab doL()
  {
    AppMethodBeat.i(113706);
    r localr = new r(this, this.wry);
    AppMethodBeat.o(113706);
    return localr;
  }
  
  public final String e(c paramc)
  {
    AppMethodBeat.i(113703);
    if (!Util.isNullOrNil(this.wru.djL().ZbL))
    {
      paramc = this.wru.djL().ZbL;
      AppMethodBeat.o(113703);
      return paramc;
    }
    if ((this.wru.djD()) && (!Util.isNullOrNil(this.wEh)))
    {
      paramc = this.wEh;
      AppMethodBeat.o(113703);
      return paramc;
    }
    paramc = this.wru.djL().code;
    AppMethodBeat.o(113703);
    return paramc;
  }
  
  public final boolean f(b paramb)
  {
    AppMethodBeat.i(113702);
    if (this.wru == null)
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
    Object localObject = this.wru.djL().code;
    String str = paramb.djL().code;
    if ((!Util.isNullOrNil((String)localObject)) && (!Util.isNullOrNil(str)) && (!((String)localObject).equals(str)))
    {
      Log.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain   code  is diffrent！");
      AppMethodBeat.o(113702);
      return true;
    }
    localObject = this.wru.djK().Zen;
    paramb = paramb.djK().Zen;
    if (((localObject == null) && (paramb != null)) || ((localObject != null) && (paramb == null)))
    {
      Log.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field  is diffrent！");
      AppMethodBeat.o(113702);
      return true;
    }
    if ((localObject != null) && (paramb != null) && (((aek)localObject).title != null) && (paramb.title != null) && (!((aek)localObject).title.equals(paramb.title)))
    {
      Log.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field title is diffrent！");
      AppMethodBeat.o(113702);
      return true;
    }
    if ((localObject != null) && (paramb != null) && (((aek)localObject).wsA != null) && (paramb.wsA != null) && (!((aek)localObject).wsA.equals(paramb.wsA)))
    {
      Log.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field aux_title  is diffrent！");
      AppMethodBeat.o(113702);
      return true;
    }
    if ((this.wru.djD()) && (!Util.isNullOrNil(this.wEh)))
    {
      Log.i("MicroMsg.CardCodeView", "dynamicCode updated！");
      AppMethodBeat.o(113702);
      return true;
    }
    AppMethodBeat.o(113702);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.q
 * JD-Core Version:    0.7.0.1
 */