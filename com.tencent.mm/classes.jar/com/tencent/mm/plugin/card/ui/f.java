package com.tencent.mm.plugin.card.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.f;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.b.e;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.plugin.card.sharecard.model.l;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.lz;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public final class f
{
  private MMActivity hxN;
  private View ipf;
  private b iqh;
  private int iuM;
  private View iuN;
  private TextView iuO;
  private TextView iuP;
  private CdnImageView iuQ;
  private ImageView[] iuR = new ImageView[3];
  private ImageView iuS;
  private lz iuT;
  
  public f(MMActivity paramMMActivity, View paramView, int paramInt, b paramb)
  {
    this(paramMMActivity, paramView, paramInt, paramb, null);
  }
  
  public f(MMActivity paramMMActivity, View paramView, int paramInt, b paramb, lz paramlz)
  {
    this.hxN = paramMMActivity;
    this.ipf = paramView;
    this.iuM = paramInt;
    this.iqh = paramb;
    this.iuT = paramlz;
    this.iuN = this.ipf.findViewById(a.d.card_home_page_item_layout);
    this.iuO = ((TextView)this.ipf.findViewById(a.d.card_home_page_item_title));
    this.iuP = ((TextView)this.ipf.findViewById(a.d.card_home_page_item_tips));
    this.iuQ = ((CdnImageView)this.ipf.findViewById(a.d.card_home_page_item_type_icon));
    this.iuR[0] = ((ImageView)this.ipf.findViewById(a.d.card_home_page_item_icon_1));
    this.iuR[1] = ((ImageView)this.ipf.findViewById(a.d.card_home_page_item_icon_2));
    this.iuR[2] = ((ImageView)this.ipf.findViewById(a.d.card_home_page_item_icon_3));
    this.iuS = ((ImageView)this.ipf.findViewById(a.d.card_red_dot_img));
    if (this.iuM == 1)
    {
      this.iuO.setText(this.hxN.getString(a.g.card_member_card_count_title, new Object[] { Integer.valueOf(0) }));
      this.iuQ.setImageResource(a.f.card_home_member_card_icon);
    }
    do
    {
      return;
      if (this.iuM == 2)
      {
        this.iuO.setText(a.g.card_share_card_title);
        this.iuQ.setImageResource(a.f.card_home_friend_ticket_icon);
        return;
      }
      if (this.iuM == 3)
      {
        this.iuO.setText(a.g.card_ticket_title);
        this.iuQ.setImageResource(a.f.card_home_my_ticket_icon);
        return;
      }
    } while (this.iuM != 4);
    if (this.iuT == null)
    {
      y.w("MicroMsg.CardHomePageItemController", "cell element is null");
      aBU();
    }
    this.ipf.findViewById(a.d.card_home_page_item_extra_relative).setVisibility(8);
    this.iuO.setText(this.iuT.sHQ);
    this.iuQ.setUseSdcardCache(true);
    this.iuQ.setUrl(this.iuT.sHR);
    if (!bk.bl(this.iuT.sHS))
    {
      this.iuP.setText(this.iuT.sHS);
      this.iuP.setVisibility(0);
      return;
    }
    this.iuP.setVisibility(8);
  }
  
  public final void aBU()
  {
    this.ipf.setVisibility(8);
  }
  
  public final void aZ()
  {
    if (this.iuM == 2)
    {
      localObject = (l)am.aAx().getValue("key_share_card_layout_data");
      if (localObject == null) {
        y.w("MicroMsg.CardHomePageItemController", "updateShareCardView data is null");
      }
    }
    while (this.iuM != 3)
    {
      return;
      if (bk.bl(((l)localObject).ioU)) {
        this.iuP.setVisibility(8);
      }
      while (bk.dk(((l)localObject).ioT))
      {
        i = 0;
        while (i < 3)
        {
          this.iuR[i].setVisibility(8);
          i += 1;
        }
        this.iuP.setVisibility(0);
        this.iuP.setText(((l)localObject).ioU);
      }
      int i = 0;
      if (i < 3)
      {
        if (i < ((l)localObject).ioT.size())
        {
          this.iuR[i].setVisibility(0);
          int j = this.hxN.getResources().getDimensionPixelSize(a.b.LargerPadding);
          m.a(this.iuR[i], (String)((l)localObject).ioT.get(i), j, a.c.my_card_package_defaultlogo, false);
        }
        for (;;)
        {
          i += 1;
          break;
          this.iuR[i].setVisibility(8);
        }
      }
      if ((!bk.dk(((l)localObject).ioT)) && (((l)localObject).ioT.size() == 1) && (((l)localObject).bZl) && (!((l)localObject).bZm))
      {
        this.iuS.setVisibility(0);
        return;
      }
      this.iuS.setVisibility(8);
      return;
    }
    this.iuO.setText(a.g.card_ticket_title);
    this.ipf.findViewById(a.d.card_home_page_item_extra_relative).setVisibility(8);
    Object localObject = (String)am.aAx().getValue("key_card_entrance_tips");
    if (!bk.bl((String)localObject))
    {
      this.iuP.setText((CharSequence)localObject);
      this.iuP.setVisibility(0);
      return;
    }
    this.iuP.setVisibility(8);
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.iuN.setOnClickListener(paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.f
 * JD-Core Version:    0.7.0.1
 */