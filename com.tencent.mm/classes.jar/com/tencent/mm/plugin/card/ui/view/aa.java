package com.tencent.mm.plugin.card.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.j;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.ui.l.a;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class aa
  implements com.tencent.mm.plugin.card.base.c
{
  int itemHeight;
  private BaseAdapter krV;
  private int krZ;
  protected LinkedList<CardTagTextView> ksd;
  private int kyg;
  int kyh;
  private Context mContext;
  
  public aa(Context paramContext, BaseAdapter paramBaseAdapter)
  {
    AppMethodBeat.i(88794);
    this.ksd = new LinkedList();
    this.mContext = paramContext;
    this.krV = paramBaseAdapter;
    this.kyg = this.mContext.getResources().getDimensionPixelSize(2131427861);
    this.krZ = this.mContext.getResources().getDimensionPixelSize(2131427792);
    this.kyh = this.mContext.getResources().getDimensionPixelOffset(2131428171);
    this.itemHeight = this.mContext.getResources().getDimensionPixelOffset(2131428172);
    AppMethodBeat.o(88794);
  }
  
  public final void V(View paramView, int paramInt)
  {
    AppMethodBeat.i(88797);
    ((l.a)paramView.getTag()).kyi.setImageResource(paramInt);
    AppMethodBeat.o(88797);
  }
  
  public final void W(View paramView, int paramInt)
  {
    AppMethodBeat.i(88798);
    ((l.a)paramView.getTag()).kyi.setVisibility(paramInt);
    AppMethodBeat.o(88798);
  }
  
  public final View a(int paramInt, View paramView, b paramb)
  {
    AppMethodBeat.i(88796);
    Object localObject1;
    label107:
    Object localObject2;
    if (paramView == null) {
      switch (this.krV.getItemViewType(paramInt))
      {
      default: 
        paramView = View.inflate(this.mContext, 2130968962, null);
        localObject1 = new aa.a(this);
        if ((paramb.bbh().equals("PRIVATE_TICKET_TITLE")) || (paramb.bbh().equals("PRIVATE_INVOICE_TITLE")))
        {
          ((aa.a)localObject1).kBS = ((TextView)paramView.findViewById(2131822271));
          paramView.setTag(localObject1);
          localObject2 = paramView;
          label116:
          if (((aa.a)localObject1).ksk != null)
          {
            float f = this.mContext.getResources().getDimension(2131427505);
            ((aa.a)localObject1).ksk.setTextSize(0, f);
          }
          if (!paramb.baQ()) {
            break label2016;
          }
          if (!paramb.bbh().equals("PRIVATE_TICKET_TITLE")) {
            break label783;
          }
          ((aa.a)localObject1).kBS.setText(this.mContext.getString(2131298076));
        }
        break;
      }
    }
    label310:
    Object localObject3;
    label783:
    Object localObject4;
    for (;;)
    {
      if ((!paramb.bbh().equals("PRIVATE_TICKET_TITLE")) && (!paramb.bbh().equals("PRIVATE_INVOICE_TITLE")) && (!paramb.baP()))
      {
        paramb.bbd();
        if ((paramInt != this.krV.getCount() - 1) || (((aa.a)localObject1).ksh == null)) {
          break label2156;
        }
        paramView = (LinearLayout.LayoutParams)((aa.a)localObject1).ksh.getLayoutParams();
        if (paramView.bottomMargin != this.mContext.getResources().getDimensionPixelOffset(2131427782))
        {
          paramView.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131427782);
          ((aa.a)localObject1).ksh.setLayoutParams(paramView);
        }
      }
      AppMethodBeat.o(88796);
      return localObject2;
      localObject1 = View.inflate(this.mContext, 2130968964, null);
      if (paramb.bbh().equals("PRIVATE_TICKET_TITLE"))
      {
        localObject2 = (TextView)((View)localObject1).findViewById(2131822271);
        paramView = (View)localObject1;
        if (localObject2 == null) {
          break;
        }
        ((TextView)localObject2).setText(this.mContext.getString(2131298076));
        paramView = (View)localObject1;
        break;
      }
      paramView = (View)localObject1;
      if (!paramb.bbh().equals("PRIVATE_INVOICE_TITLE")) {
        break;
      }
      localObject2 = (TextView)((View)localObject1).findViewById(2131822271);
      paramView = (View)localObject1;
      if (localObject2 == null) {
        break;
      }
      ((TextView)localObject2).setText(this.mContext.getString(2131297961));
      paramView = (View)localObject1;
      break;
      paramView = View.inflate(this.mContext, 2130968962, null);
      break;
      paramView = View.inflate(this.mContext, 2130968967, null);
      break;
      if (paramb.baP())
      {
        ((aa.a)localObject1).kBT = ((TextView)paramView.findViewById(2131822275));
        ((aa.a)localObject1).kBU = ((TextView)paramView.findViewById(2131822276));
        ((aa.a)localObject1).kBV = ((TextView)paramView.findViewById(2131822277));
        ((aa.a)localObject1).kBW = ((TextView)paramView.findViewById(2131822278));
        break label107;
      }
      ((aa.a)localObject1).ksh = ((RelativeLayout)paramView.findViewById(2131821968));
      ((aa.a)localObject1).ksi = ((ImageView)paramView.findViewById(2131821970));
      ((aa.a)localObject1).kxs = paramView.findViewById(2131822267);
      ((aa.a)localObject1).kxt = ((ImageView)paramView.findViewById(2131822268));
      ((aa.a)localObject1).ksj = ((TextView)paramView.findViewById(2131821971));
      ((aa.a)localObject1).ksk = ((TextView)paramView.findViewById(2131821973));
      ((aa.a)localObject1).ksn = ((TextView)paramView.findViewById(2131821976));
      ((aa.a)localObject1).kyi = ((ImageView)paramView.findViewById(2131822270));
      ((aa.a)localObject1).kyk = ((ImageView)paramView.findViewById(2131822264));
      ((aa.a)localObject1).kyl = ((ImageView)paramView.findViewById(2131822265));
      ((aa.a)localObject1).kym = ((ImageView)paramView.findViewById(2131822266));
      ((aa.a)localObject1).kyj = ((LinearLayout)paramView.findViewById(2131822269));
      break label107;
      localObject1 = (aa.a)paramView.getTag();
      if (((aa.a)localObject1).kBS != null)
      {
        if (paramb.bbh().equals("PRIVATE_TICKET_TITLE"))
        {
          ((aa.a)localObject1).kBS.setText(this.mContext.getString(2131298076));
          localObject2 = paramView;
          break label116;
        }
        ((aa.a)localObject1).kBS.setText(this.mContext.getString(2131297961));
      }
      localObject2 = paramView;
      break label116;
      if (paramb.bbh().equals("PRIVATE_INVOICE_TITLE"))
      {
        ((aa.a)localObject1).kBS.setText(this.mContext.getString(2131297961));
      }
      else if (paramb.baP())
      {
        paramView = paramb.bbd().wFZ;
        ((aa.a)localObject1).kBT.setText(((uo)paramView.get(0)).kmn);
        ((aa.a)localObject1).kBV.setText(((uo)paramView.get(1)).kmn);
        paramView = paramb.bbe().wDU;
        localObject3 = String.format(this.mContext.getString(2131297972), new Object[] { ((uo)paramView.get(0)).kmn });
        ((aa.a)localObject1).kBW.setText((CharSequence)localObject3);
        if (paramView.size() >= 2) {
          ((aa.a)localObject1).kBU.setText(((uo)paramView.get(1)).kmn);
        }
      }
      else
      {
        if ((this.krV.getItem(paramInt) instanceof CardInfo))
        {
          localObject4 = (CardInfo)this.krV.getItem(paramInt);
          if ((!((CardInfo)localObject4).field_card_id.equals("PRIVATE_TICKET_TITLE")) && (!((CardInfo)localObject4).field_card_id.equals("PRIVATE_INVOICE_TITLE"))) {
            break label1311;
          }
        }
        label1010:
        ((aa.a)localObject1).ksh.setVisibility(0);
        ((aa.a)localObject1).ksi.setVisibility(0);
        ((aa.a)localObject1).ksk.setVisibility(0);
        ((aa.a)localObject1).ksn.setVisibility(8);
        ((aa.a)localObject1).ksj.setVisibility(0);
        ((aa.a)localObject1).ksj.setText(paramb.bbd().knw);
        ((aa.a)localObject1).ksk.setText(paramb.bbd().title);
        if (!paramb.baN()) {
          break label1673;
        }
        ((aa.a)localObject1).kxs.setVisibility(0);
        ((aa.a)localObject1).ksi.setVisibility(4);
        paramView = ((aa.a)localObject1).kxt;
        if (TextUtils.isEmpty(paramb.bbd().wGh)) {
          break label1651;
        }
        i = this.mContext.getResources().getDimensionPixelSize(2131428180);
        com.tencent.mm.plugin.card.d.m.a(this.mContext, paramView, paramb.bbd().wGh, i, l.IB(paramb.bbd().color));
        label1184:
        if (!paramb.baL()) {
          break label1920;
        }
        if (!bo.isNullOrNil(paramb.bbe().wEe)) {
          break label1733;
        }
        paramView = l.dR(l.IB(paramb.bbd().color), this.kyh);
        ((aa.a)localObject1).ksh.setBackgroundDrawable(paramView);
        ((aa.a)localObject1).kyk.setVisibility(8);
        ((aa.a)localObject1).kyl.setVisibility(8);
        ((aa.a)localObject1).kym.setVisibility(0);
        label1266:
        ((aa.a)localObject1).ksj.setTextColor(this.mContext.getResources().getColor(2131690709));
        ((aa.a)localObject1).ksk.setTextColor(this.mContext.getResources().getColor(2131690709));
      }
    }
    label1311:
    int i = 0;
    if (((CardInfo)localObject4).field_stickyIndex % 10 != 0)
    {
      if (((CardInfo)localObject4).field_stickyIndex <= 0) {
        break label2192;
      }
      i = 1;
      paramView = j.a(this.mContext, ((CardInfo)localObject4).field_stickyIndex, (CardInfo)localObject4);
    }
    for (;;)
    {
      if (i != 0)
      {
        i = 0;
        for (;;)
        {
          if (i < ((aa.a)localObject1).kyj.getChildCount())
          {
            localObject3 = (CardTagTextView)((aa.a)localObject1).kyj.getChildAt(i);
            this.ksd.add(localObject3);
            i += 1;
            continue;
            if (bo.isNullOrNil(((CardInfo)localObject4).field_label_wording)) {
              break label2192;
            }
            i = 1;
            paramView = ((CardInfo)localObject4).field_label_wording;
            break;
          }
        }
        ((aa.a)localObject1).kyj.removeAllViews();
        ((aa.a)localObject1).kyj.setVisibility(0);
        if (this.ksd.size() == 0)
        {
          localObject3 = new CardTagTextView(this.mContext);
          label1469:
          ((CardTagTextView)localObject3).setPadding(this.krZ, this.kyg, this.krZ, this.kyg);
          ((CardTagTextView)localObject3).setGravity(17);
          ((CardTagTextView)localObject3).setMinWidth(this.mContext.getResources().getDimensionPixelSize(2131428177));
          ((CardTagTextView)localObject3).setMinHeight(this.mContext.getResources().getDimensionPixelSize(2131428176));
          if (!((CardInfo)localObject4).baL()) {
            break label1614;
          }
          ((CardTagTextView)localObject3).setTextColor(com.tencent.mm.cb.a.m(this.mContext, 2131690709));
          ((CardTagTextView)localObject3).setFillColor(com.tencent.mm.cb.a.m(this.mContext, 2131689846));
        }
        for (;;)
        {
          ((CardTagTextView)localObject3).setText(paramView);
          ((CardTagTextView)localObject3).setTextSize(1, 10.0F);
          ((aa.a)localObject1).kyj.addView((View)localObject3);
          break;
          localObject3 = (CardTagTextView)this.ksd.removeFirst();
          break label1469;
          label1614:
          ((CardTagTextView)localObject3).setTextColor(com.tencent.mm.cb.a.m(this.mContext, 2131690214));
          ((CardTagTextView)localObject3).setFillColor(0);
        }
      }
      ((aa.a)localObject1).kyj.setVisibility(8);
      break label1010;
      label1651:
      com.tencent.mm.plugin.card.d.m.a(paramView, 2130838175, l.IB(paramb.bbd().color));
      break label1184;
      label1673:
      ((aa.a)localObject1).kxs.setVisibility(8);
      ((aa.a)localObject1).ksi.setVisibility(0);
      i = this.mContext.getResources().getDimensionPixelSize(2131428180);
      com.tencent.mm.plugin.card.d.m.a(((aa.a)localObject1).ksi, paramb.bbd().kmm, i, 2130839758, true);
      break label1184;
      label1733:
      ((aa.a)localObject1).ksh.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130838133));
      ((aa.a)localObject1).kyk.setVisibility(0);
      ((aa.a)localObject1).kyl.setVisibility(0);
      paramView = ((aa.a)localObject1).kyk;
      localObject3 = paramb.bbe().wEe;
      localObject4 = new c.a();
      ((c.a)localObject4).eNP = e.eQz;
      o.ahH();
      ((c.a)localObject4).eOd = null;
      ((c.a)localObject4).eNO = com.tencent.mm.plugin.card.model.m.HO((String)localObject3);
      ((c.a)localObject4).eNM = true;
      ((c.a)localObject4).eOf = true;
      ((c.a)localObject4).eNK = true;
      ((c.a)localObject4).eNY = 2130838133;
      ((c.a)localObject4).eNT = com.tencent.mm.cb.a.ao(this.mContext, 2131428172);
      ((c.a)localObject4).eNS = com.tencent.mm.cb.a.gw(this.mContext);
      localObject4 = ((c.a)localObject4).ahY();
      o.ahG().a((String)localObject3, paramView, (com.tencent.mm.at.a.a.c)localObject4);
      paramView.setImageMatrix(new Matrix());
      ((aa.a)localObject1).kym.setVisibility(8);
      break label1266;
      label1920:
      ((aa.a)localObject1).kym.setVisibility(8);
      ((aa.a)localObject1).kyk.setVisibility(8);
      ((aa.a)localObject1).kyl.setVisibility(8);
      ((aa.a)localObject1).ksh.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130838133));
      ((aa.a)localObject1).ksk.setTextColor(this.mContext.getResources().getColor(2131689825));
      ((aa.a)localObject1).ksj.setTextColor(this.mContext.getResources().getColor(2131689825));
      break;
      label2016:
      if ((paramb.bbh().equals("PRIVATE_TICKET_TITLE")) || (paramb.bbh().equals("PRIVATE_INVOICE_TITLE")) || (paramb.baP())) {
        break;
      }
      ((aa.a)localObject1).ksi.setVisibility(8);
      ((aa.a)localObject1).ksk.setVisibility(8);
      ((aa.a)localObject1).ksj.setVisibility(8);
      ((aa.a)localObject1).kyj.setVisibility(8);
      ((aa.a)localObject1).ksn.setVisibility(0);
      paramView = l.dR(this.mContext.getResources().getColor(2131689845), this.kyh);
      ((aa.a)localObject1).ksh.setBackgroundDrawable(paramView);
      ((aa.a)localObject1).ksn.setText(this.mContext.getResources().getString(2131298005));
      break;
      label2156:
      paramView = (LinearLayout.LayoutParams)((aa.a)localObject1).ksh.getLayoutParams();
      if (paramView.bottomMargin == 0) {
        break label310;
      }
      paramView.bottomMargin = 0;
      ((aa.a)localObject1).ksh.setLayoutParams(paramView);
      break label310;
      label2192:
      paramView = null;
    }
  }
  
  public final void a(View paramView, int paramInt, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(88799);
    CardInfo localCardInfo = (CardInfo)this.krV.getItem(paramInt);
    if ((localCardInfo.field_card_id.equals("PRIVATE_TICKET_TITLE")) || (localCardInfo.field_card_id.equals("PRIVATE_INVOICE_TITLE")))
    {
      AppMethodBeat.o(88799);
      return;
    }
    paramView = (aa.a)paramView.getTag();
    paramView.kyi.setTag(Integer.valueOf(paramInt));
    paramView.kyi.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(88799);
  }
  
  public final void release()
  {
    AppMethodBeat.i(88795);
    this.mContext = null;
    this.krV = null;
    if (this.ksd != null) {
      this.ksd.clear();
    }
    AppMethodBeat.o(88795);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.aa
 * JD-Core Version:    0.7.0.1
 */