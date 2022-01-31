package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.protocal.c.lv;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.protocal.c.ra;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class d
  extends a
{
  private View izJ;
  private TextView izK;
  private TextView izL;
  private View izM;
  private TextView izN;
  private TextView izO;
  private View izP;
  private View izQ;
  private View izR;
  
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void aDk()
  {
    this.izJ = this.izw.findViewById(a.d.payer_layout);
    this.izK = ((TextView)this.izw.findViewById(a.d.payer_title));
    this.izL = ((TextView)this.izw.findViewById(a.d.payer_sub_title));
    this.izM = this.izw.findViewById(a.d.billto_layout);
    this.izN = ((TextView)this.izw.findViewById(a.d.billto_title));
    this.izO = ((TextView)this.izw.findViewById(a.d.billto_sub_title));
    this.izQ = this.izw.findViewById(a.d.card_widget_status_layout);
    this.izR = this.izw.findViewById(a.d.card_bottom_dash_divider_2);
  }
  
  protected final void aDl()
  {
    Object localObject3;
    Object localObject2;
    Object localObject1;
    if ((this.ikk.azx().sIq != null) && (this.ikk.azx().sIq.size() > 0))
    {
      localObject3 = this.ikk.azx().sIq;
      localObject2 = null;
      if (((LinkedList)localObject3).size() == 1)
      {
        localObject1 = (ra)((LinkedList)localObject3).get(0);
        if (localObject1 != null)
        {
          this.izJ.setVisibility(0);
          this.izK.setText(((ra)localObject1).title);
          this.izL.setText(((ra)localObject1).ilq);
          if (!TextUtils.isEmpty(((ra)localObject1).sJr)) {
            this.izK.setTextColor(l.yR(((ra)localObject1).sJr));
          }
          if (!TextUtils.isEmpty(((ra)localObject1).sJs)) {
            this.izL.setTextColor(l.yR(((ra)localObject1).sJs));
          }
        }
        if (localObject2 != null)
        {
          this.izM.setVisibility(0);
          this.izN.setText(((ra)localObject2).title);
          this.izO.setText(((ra)localObject2).ilq);
          if (!TextUtils.isEmpty(((ra)localObject2).sJr)) {
            this.izN.setTextColor(l.yR(((ra)localObject2).sJr));
          }
          if (!TextUtils.isEmpty(((ra)localObject2).sJs)) {
            this.izO.setTextColor(l.yR(((ra)localObject2).sJs));
          }
        }
        label229:
        if ((!this.ikk.azd()) || (this.ikk.azj())) {
          break label348;
        }
        y.i("MicroMsg.CardWidgetInvoice", "is not invoice, don't updateCardSecondaryFieldListView");
        label260:
        if (!this.ikk.isNormal()) {
          break label876;
        }
        this.izQ.setVisibility(8);
      }
    }
    for (;;)
    {
      if ((this.ikk.azy().sHH != null) || (!this.ikk.isNormal())) {
        break label954;
      }
      this.izR.setVisibility(0);
      return;
      localObject1 = (ra)((LinkedList)localObject3).get(0);
      localObject2 = (ra)((LinkedList)localObject3).get(1);
      break;
      y.i("MicroMsg.CardWidgetInvoice", "primary_fields is null");
      break label229;
      label348:
      if ((this.ikk.azy().sHy != null) && (this.ikk.azy().sHy.size() > 0))
      {
        if (this.izP == null) {
          this.izP = ((ViewStub)this.izw.findViewById(a.d.card_secondary_field_list_stub)).inflate();
        }
        this.izw.findViewById(a.d.card_bottom_dash_divider_2).setVisibility(8);
        localObject1 = this.izP;
        localObject3 = this.ikk;
        localObject2 = this.fvj;
        localObject3 = ((b)localObject3).azy().sHy;
        if (((LinkedList)localObject3).size() == 1)
        {
          ((View)localObject1).findViewById(a.d.card_secondary_field_view_1).setVisibility(0);
          localObject3 = (ra)((LinkedList)localObject3).get(0);
          ((TextView)((View)localObject1).findViewById(a.d.secondary_field_title_1)).setText(((ra)localObject3).title);
          ((TextView)((View)localObject1).findViewById(a.d.secondary_field_subtitle_1)).setText(((ra)localObject3).ilq);
          ((View)localObject1).findViewById(a.d.card_secondary_field_view_1).setOnClickListener((View.OnClickListener)localObject2);
          if (!TextUtils.isEmpty(((ra)localObject3).sJr)) {
            ((TextView)((View)localObject1).findViewById(a.d.secondary_field_title_1)).setTextColor(l.yR(((ra)localObject3).sJr));
          }
          if (!TextUtils.isEmpty(((ra)localObject3).sJs)) {
            ((TextView)((View)localObject1).findViewById(a.d.secondary_field_subtitle_1)).setTextColor(l.yR(((ra)localObject3).sJs));
          }
          ((View)localObject1).findViewById(a.d.card_secondary_field_view_2).setVisibility(8);
          break label260;
        }
        if (((LinkedList)localObject3).size() < 2) {
          break label260;
        }
        ra localra = (ra)((LinkedList)localObject3).get(0);
        ((TextView)((View)localObject1).findViewById(a.d.secondary_field_title_1)).setText(localra.title);
        ((TextView)((View)localObject1).findViewById(a.d.secondary_field_subtitle_1)).setText(localra.ilq);
        if (!TextUtils.isEmpty(localra.sJr)) {
          ((TextView)((View)localObject1).findViewById(a.d.secondary_field_title_1)).setTextColor(l.yR(localra.sJr));
        }
        if (!TextUtils.isEmpty(localra.sJs)) {
          ((TextView)((View)localObject1).findViewById(a.d.secondary_field_subtitle_1)).setTextColor(l.yR(localra.sJs));
        }
        localObject3 = (ra)((LinkedList)localObject3).get(1);
        ((TextView)((View)localObject1).findViewById(a.d.secondary_field_title_2)).setText(((ra)localObject3).title);
        ((TextView)((View)localObject1).findViewById(a.d.secondary_field_subtitle_2)).setText(((ra)localObject3).ilq);
        if (!TextUtils.isEmpty(((ra)localObject3).sJr)) {
          ((TextView)((View)localObject1).findViewById(a.d.secondary_field_title_2)).setTextColor(l.yR(((ra)localObject3).sJr));
        }
        if (!TextUtils.isEmpty(((ra)localObject3).sJs)) {
          ((TextView)((View)localObject1).findViewById(a.d.secondary_field_subtitle_2)).setTextColor(l.yR(((ra)localObject3).sJs));
        }
        ((View)localObject1).findViewById(a.d.card_secondary_field_view_1).setOnClickListener((View.OnClickListener)localObject2);
        ((View)localObject1).findViewById(a.d.card_secondary_field_view_2).setOnClickListener((View.OnClickListener)localObject2);
        break label260;
      }
      if (this.izP != null) {
        this.izP.setVisibility(8);
      }
      this.izw.findViewById(a.d.card_bottom_dash_divider_2).setVisibility(8);
      break label260;
      label876:
      this.izQ.setVisibility(0);
      localObject1 = (TextView)this.izQ.findViewById(a.d.card_status_tv);
      if (!TextUtils.isEmpty(this.ikk.azx().sIO)) {
        ((TextView)localObject1).setText(this.ikk.azx().sIO);
      } else {
        m.c((TextView)localObject1, this.ikk.azy().status);
      }
    }
    label954:
    this.izR.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.d
 * JD-Core Version:    0.7.0.1
 */