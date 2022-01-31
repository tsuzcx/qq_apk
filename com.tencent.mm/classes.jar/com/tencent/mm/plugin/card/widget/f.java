package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.protocal.c.mb;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.protocal.c.ra;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.LinkedList;

public final class f
  extends a
{
  protected TextView eXO;
  private View iAa;
  private ImageView iAb;
  private TextView iAc;
  private TextView iAd;
  private View iAe;
  private TextView iAf;
  private TextView iAg;
  private ImageView iAh;
  private TextView iAi;
  public ArrayList<mb> ikq;
  
  public f(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void aDk()
  {
    this.eXO = ((TextView)aDj().findViewById(a.d.card_title));
    this.iAa = aDj().findViewById(a.d.card_bottom_dash_divider);
    this.iAb = ((ImageView)aDj().findViewById(a.d.ticket_icon));
    this.iAc = ((TextView)aDj().findViewById(a.d.ticket_content_title));
    this.iAd = ((TextView)aDj().findViewById(a.d.ticket_content_sub_title));
    this.iAe = aDj().findViewById(a.d.ticket_shop_layout);
    this.iAf = ((TextView)aDj().findViewById(a.d.ticket_shop_title));
    this.iAg = ((TextView)aDj().findViewById(a.d.ticket_shop_sub_title));
    this.iAh = ((ImageView)aDj().findViewById(a.d.ticket_place_icon));
    this.iAi = ((TextView)aDj().findViewById(a.d.ticket_check_more_adapted_stores));
  }
  
  protected final void aDl()
  {
    label124:
    StringBuilder localStringBuilder;
    label205:
    ra localra1;
    if ((this.ikk.azx().sIS != null) && (!TextUtils.isEmpty(this.ikk.azx().sIS.title)))
    {
      this.izy.setText(this.ikk.azx().sIS.title);
      if ((this.ikk.azx().sIS == null) || (TextUtils.isEmpty(this.ikk.azx().sIS.ilq))) {
        break label599;
      }
      this.eXO.setText(this.ikk.azx().sIS.ilq);
      this.eXO.setVisibility(0);
      y.i("MicroMsg.CardWidgetTicket", "updateContentView()");
      if (bk.bl(this.ikk.azx().sIy)) {
        break label621;
      }
      int i = this.mContext.getResources().getDimensionPixelSize(a.b.card_ticket_widget_logo_size);
      m.a(this.mContext, this.iAb, this.ikk.azx().sIy, i, a.c.card_ticket_normal_icon, l.yR(this.ikk.azx().color));
      localObject = new StringBuilder();
      localStringBuilder = new StringBuilder();
      if ((this.ikk.azx().sIq == null) || (this.ikk.azx().sIq.size() < 2)) {
        break label649;
      }
      y.i("MicroMsg.CardWidgetTicket", "primary_fields length is >= 2");
      localra1 = (ra)this.ikk.azx().sIq.get(0);
      ra localra2 = (ra)this.ikk.azx().sIq.get(1);
      ((StringBuilder)localObject).append(localra1.title).append(" - ").append(localra2.title);
      if ((!TextUtils.isEmpty(localra1.ilr)) && (!TextUtils.isEmpty(localra2.ilr)))
      {
        localStringBuilder.append(localra1.ilr).append(" ").append(localra1.ilq);
        localStringBuilder.append(" - ");
        localStringBuilder.append(localra2.ilr).append(" ").append(localra2.ilq);
      }
      label402:
      if (TextUtils.isEmpty(((StringBuilder)localObject).toString())) {
        break label735;
      }
      this.iAc.setText(((StringBuilder)localObject).toString());
      label423:
      if (TextUtils.isEmpty(localStringBuilder.toString())) {
        break label748;
      }
      y.i("MicroMsg.CardWidgetTicket", "sub_title_builder is not empty!");
      this.iAd.setText(localStringBuilder.toString());
      this.iAd.setVisibility(0);
    }
    for (;;)
    {
      y.e("MicroMsg.CardWidgetTicket", "updateShopView(), shop_count:" + this.ikk.azx().sIu);
      if (this.ikk.azx().sIu > 0) {
        break label816;
      }
      this.iAe.setVisibility(8);
      this.iAi.setVisibility(8);
      if (!this.ikk.azw()) {
        break label1192;
      }
      this.iAa.setVisibility(8);
      return;
      if (!TextUtils.isEmpty(this.ikk.azx().imA))
      {
        this.izy.setText(this.ikk.azx().imA);
        break;
      }
      this.izy.setText("");
      break;
      label599:
      this.eXO.setText("");
      this.eXO.setVisibility(8);
      break label124;
      label621:
      m.a(this.iAb, a.c.card_ticket_normal_icon, l.yR(this.ikk.azx().color));
      break label205;
      label649:
      if ((this.ikk.azx().sIq == null) || (this.ikk.azx().sIq.size() != 1)) {
        break label402;
      }
      y.i("MicroMsg.CardWidgetTicket", "primary_fields length is == 1");
      localra1 = (ra)this.ikk.azx().sIq.get(0);
      ((StringBuilder)localObject).append(localra1.title);
      localStringBuilder.append(localra1.ilq);
      break label402;
      label735:
      this.iAc.setText("");
      break label423;
      label748:
      if (!TextUtils.isEmpty(this.ikk.azx().sIG))
      {
        y.i("MicroMsg.CardWidgetTicket", "primary_sub_title is not empty!");
        this.iAd.setText(this.ikk.azx().sIG);
        this.iAd.setVisibility(0);
      }
      else
      {
        this.iAd.setVisibility(8);
      }
    }
    label816:
    this.iAe.setVisibility(0);
    this.iAe.setOnClickListener(this.fvj);
    m.a(this.iAh, a.c.card_ticket_place_icon, l.yR(this.ikk.azx().color));
    if ((this.ikq != null) && (this.ikq.size() > 0)) {}
    for (Object localObject = (mb)this.ikq.get(0);; localObject = null)
    {
      if ((this.ikk.azx().sIu == 1) && (localObject != null))
      {
        this.iAf.setText(((mb)localObject).name);
        this.iAg.setText(this.mContext.getString(a.g.card_shop_distance_address, new Object[] { l.f(this.mContext, ((mb)localObject).sIe), ((mb)localObject).ekZ }));
        this.iAi.setVisibility(8);
        this.iAe.setTag(((mb)localObject).name);
        break;
      }
      if ((this.ikk.azx().sIu > 1) && (localObject != null))
      {
        this.iAf.setText(((mb)localObject).name);
        this.iAg.setText(this.mContext.getString(a.g.card_shop_distance_address, new Object[] { l.f(this.mContext, ((mb)localObject).sIe), ((mb)localObject).ekZ }));
        this.iAi.setVisibility(0);
        this.iAi.setOnClickListener(this.fvj);
        this.iAe.setTag(((mb)localObject).name);
        break;
      }
      if (this.ikk.azx().sIu <= 0) {
        break;
      }
      this.iAf.setText(a.g.card_check_all_adapted_stores);
      this.iAg.setText(this.mContext.getString(a.g.card_total_adapted_stores, new Object[] { Integer.valueOf(this.ikk.azx().sIu) }));
      this.iAi.setVisibility(8);
      this.iAi.setOnClickListener(null);
      this.iAe.setTag(this.mContext.getString(a.g.card_check_all_adapted_stores));
      break;
      label1192:
      this.iAa.setVisibility(0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.f
 * JD-Core Version:    0.7.0.1
 */