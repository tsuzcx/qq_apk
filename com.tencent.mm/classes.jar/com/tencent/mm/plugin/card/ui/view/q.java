package com.tencent.mm.plugin.card.ui.view;

import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.protocal.c.lv;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.protocal.c.ra;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class q
  extends g
{
  public String iwI = "";
  
  public final ab aCZ()
  {
    return new s(this, this.hxN);
  }
  
  public final ab aDa()
  {
    return new p(this, this.hxN);
  }
  
  public final ab aDb()
  {
    return new r(this, this.hxN);
  }
  
  public final String e(c paramc)
  {
    if (!bk.bl(this.ikk.azy().sHK)) {
      return this.ikk.azy().sHK;
    }
    if ((this.ikk.azs()) && (!bk.bl(this.iwI))) {
      return this.iwI;
    }
    return this.ikk.azy().code;
  }
  
  public final boolean f(b paramb)
  {
    if (this.ikk == null)
    {
      y.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain mCardInfo is null！");
      return true;
    }
    if (paramb == null)
    {
      y.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain false  newCardInfo null！");
      return false;
    }
    Object localObject = this.ikk.azy().code;
    String str = paramb.azy().code;
    if ((!bk.bl((String)localObject)) && (!bk.bl(str)) && (!((String)localObject).equals(str)))
    {
      y.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain   code  is diffrent！");
      return true;
    }
    localObject = this.ikk.azx().sIU;
    paramb = paramb.azx().sIU;
    if (((localObject == null) && (paramb != null)) || ((localObject != null) && (paramb == null)))
    {
      y.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field  is diffrent！");
      return true;
    }
    if ((localObject != null) && (paramb != null) && (((ra)localObject).title != null) && (paramb.title != null) && (!((ra)localObject).title.equals(paramb.title)))
    {
      y.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field title is diffrent！");
      return true;
    }
    if ((localObject != null) && (paramb != null) && (((ra)localObject).ilr != null) && (paramb.ilr != null) && (!((ra)localObject).ilr.equals(paramb.ilr)))
    {
      y.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field aux_title  is diffrent！");
      return true;
    }
    if ((this.ikk.azs()) && (!bk.bl(this.iwI)))
    {
      y.i("MicroMsg.CardCodeView", "dynamicCode updated！");
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.q
 * JD-Core Version:    0.7.0.1
 */