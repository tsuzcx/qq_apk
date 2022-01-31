package com.tencent.mm.plugin.card.ui.view;

import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.protocal.c.lv;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class j
  extends g
{
  public final ab aCZ()
  {
    return new v(this, this.hxN);
  }
  
  public final ab aDa()
  {
    return new f(this, this.hxN);
  }
  
  public final ab aDb()
  {
    return new t(this, this.hxN);
  }
  
  public final String e(c paramc)
  {
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
    String str = this.ikk.azy().code;
    paramb = paramb.azy().code;
    if ((!bk.bl(str)) && (!bk.bl(paramb)) && (!str.equals(paramb)))
    {
      y.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain   code  is diffrent！");
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.j
 * JD-Core Version:    0.7.0.1
 */