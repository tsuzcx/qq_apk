package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.c.mb;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.protocal.c.zi;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.List;

public final class f
{
  public int drX = 3;
  public MMActivity hxN;
  public com.tencent.mm.plugin.card.base.b ikk;
  public List<com.tencent.mm.plugin.card.model.b> iko = new ArrayList();
  public com.tencent.mm.plugin.card.model.b ikp;
  public ArrayList<mb> ikq;
  
  public f(MMActivity paramMMActivity)
  {
    this.hxN = paramMMActivity;
  }
  
  public final com.tencent.mm.plugin.card.model.b azW()
  {
    com.tencent.mm.plugin.card.model.b localb = new com.tencent.mm.plugin.card.model.b();
    localb.ilz = 1;
    boolean bool;
    if ((l.pe(this.drX)) || (l.pf(this.drX)) || (this.drX == 23))
    {
      if ((!this.ikk.isAcceptable()) || (this.ikk.azx().sIK == null) || (TextUtils.isEmpty(this.ikk.azx().sIK.text)) || (TextUtils.isEmpty(this.ikk.azx().sIn))) {
        break label310;
      }
      bool = true;
      localb.ilB = bool;
      if ((!localb.ilB) && (!TextUtils.isEmpty(this.ikk.azx().sID))) {
        break label376;
      }
      if (!s.hk(this.ikk.azx().sIn)) {
        break label315;
      }
      localb.title = getString(a.g.card_menu_find_app_service);
      localb.ilB = false;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.ikk.azx().sIF)) {
        localb.ilq = this.ikk.azx().sIF;
      }
      localb.ioU = "";
      localb.url = "card://jump_service";
      this.ikp = localb;
      return this.ikp;
      if ((this.drX == 6) && (this.ikk.azu()) && (this.ikk.azx().sIK != null) && (!TextUtils.isEmpty(this.ikk.azx().sIK.text)) && (!TextUtils.isEmpty(this.ikk.azx().sIn)))
      {
        bool = true;
        break;
      }
      label310:
      bool = false;
      break;
      label315:
      localb.title = getString(a.g.card_menu_attention_app_service);
      if ((this.ikk.azx().sIK != null) && (this.ikk.azx().sIK.sYH == 1))
      {
        localb.ilC = true;
      }
      else
      {
        localb.ilC = false;
        continue;
        label376:
        localb.title = this.ikk.azx().sID;
      }
    }
  }
  
  public final String getString(int paramInt)
  {
    return this.hxN.getString(paramInt);
  }
  
  public final String getTitle()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(this.ikk.azx().imz)) {
      localStringBuilder.append(this.ikk.azx().imz);
    }
    for (;;)
    {
      return localStringBuilder.toString();
      if (this.ikk.azf()) {
        localStringBuilder.append(getString(a.g.card_membership));
      } else if (this.ikk.azg()) {
        localStringBuilder.append(getString(a.g.card_coupon));
      } else if (this.ikk.azh()) {
        localStringBuilder.append(getString(a.g.card_boarding_pass));
      } else if (this.ikk.azi()) {
        localStringBuilder.append(getString(a.g.card_enterprise_cash));
      } else if (this.ikk.azj()) {
        localStringBuilder.append(getString(a.g.card_invoice));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.f
 * JD-Core Version:    0.7.0.1
 */