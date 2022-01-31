package com.tencent.mm.plugin.card.ui;

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
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class l
  implements com.tencent.mm.plugin.card.base.c
{
  int itemHeight;
  private BaseAdapter krV;
  private int krZ;
  protected LinkedList<CardTagTextView> ksd;
  private int kyg;
  int kyh;
  private Context mContext;
  
  public l(Context paramContext, BaseAdapter paramBaseAdapter)
  {
    AppMethodBeat.i(88665);
    this.ksd = new LinkedList();
    this.mContext = paramContext;
    this.krV = paramBaseAdapter;
    this.kyg = this.mContext.getResources().getDimensionPixelSize(2131427861);
    this.krZ = this.mContext.getResources().getDimensionPixelSize(2131427792);
    this.kyh = this.mContext.getResources().getDimensionPixelOffset(2131428171);
    this.itemHeight = this.mContext.getResources().getDimensionPixelOffset(2131428172);
    AppMethodBeat.o(88665);
  }
  
  public final void V(View paramView, int paramInt)
  {
    AppMethodBeat.i(88668);
    ((l.a)paramView.getTag()).kyi.setImageResource(paramInt);
    AppMethodBeat.o(88668);
  }
  
  public final void W(View paramView, int paramInt)
  {
    AppMethodBeat.i(88669);
    ((l.a)paramView.getTag()).kyi.setVisibility(paramInt);
    AppMethodBeat.o(88669);
  }
  
  public final View a(int paramInt, View paramView, b paramb)
  {
    AppMethodBeat.i(88667);
    Object localObject1;
    Object localObject2;
    label256:
    Object localObject4;
    int i;
    if (paramView == null) {
      if (paramb.bbh().equals("PRIVATE_TICKET_TITLE"))
      {
        localObject1 = View.inflate(this.mContext, 2130968964, null);
        localObject2 = (TextView)((View)localObject1).findViewById(2131822271);
        paramView = (View)localObject1;
        if (localObject2 != null)
        {
          ((TextView)localObject2).setText(this.mContext.getString(2131298076));
          paramView = (View)localObject1;
        }
        localObject1 = new l.a(this);
        ((l.a)localObject1).ksh = ((RelativeLayout)paramView.findViewById(2131821968));
        ((l.a)localObject1).ksi = ((ImageView)paramView.findViewById(2131821970));
        ((l.a)localObject1).kxs = paramView.findViewById(2131822267);
        ((l.a)localObject1).kxt = ((ImageView)paramView.findViewById(2131822268));
        ((l.a)localObject1).ksj = ((TextView)paramView.findViewById(2131821971));
        ((l.a)localObject1).ksk = ((TextView)paramView.findViewById(2131821973));
        ((l.a)localObject1).ksn = ((TextView)paramView.findViewById(2131821976));
        ((l.a)localObject1).kyi = ((ImageView)paramView.findViewById(2131822270));
        ((l.a)localObject1).kyk = ((ImageView)paramView.findViewById(2131822264));
        ((l.a)localObject1).kyl = ((ImageView)paramView.findViewById(2131822265));
        ((l.a)localObject1).kym = ((ImageView)paramView.findViewById(2131822266));
        ((l.a)localObject1).kyj = ((LinearLayout)paramView.findViewById(2131822269));
        paramView.setTag(localObject1);
        localObject2 = paramView;
        if (((l.a)localObject1).ksk != null)
        {
          float f = this.mContext.getResources().getDimension(2131427505);
          ((l.a)localObject1).ksk.setTextSize(0, f);
        }
        if (!(this.krV.getItem(paramInt) instanceof CardInfo)) {
          break label696;
        }
        localObject4 = (CardInfo)this.krV.getItem(paramInt);
        i = 0;
        if (((CardInfo)localObject4).field_stickyIndex % 10 == 0) {
          break label506;
        }
        if (((CardInfo)localObject4).field_stickyIndex <= 0) {
          break label1644;
        }
        i = 1;
        paramView = j.a(this.mContext, ((CardInfo)localObject4).field_stickyIndex, (CardInfo)localObject4);
      }
    }
    for (;;)
    {
      label356:
      Object localObject3;
      if (i != 0)
      {
        i = 0;
        for (;;)
        {
          if (i < ((l.a)localObject1).kyj.getChildCount())
          {
            localObject3 = (CardTagTextView)((l.a)localObject1).kyj.getChildAt(i);
            this.ksd.add(localObject3);
            i += 1;
            continue;
            if (paramb.bbh().equals("PRIVATE_INVOICE_TITLE"))
            {
              localObject1 = View.inflate(this.mContext, 2130968964, null);
              localObject2 = (TextView)((View)localObject1).findViewById(2131822271);
              paramView = (View)localObject1;
              if (localObject2 == null) {
                break;
              }
              ((TextView)localObject2).setText(this.mContext.getString(2131297961));
              paramView = (View)localObject1;
              break;
            }
            paramView = View.inflate(this.mContext, 2130968962, null);
            break;
            localObject1 = (l.a)paramView.getTag();
            localObject2 = paramView;
            break label256;
            label506:
            if (bo.isNullOrNil(((CardInfo)localObject4).field_label_wording)) {
              break label1644;
            }
            i = 1;
            paramView = ((CardInfo)localObject4).field_label_wording;
            break label356;
          }
        }
        ((l.a)localObject1).kyj.removeAllViews();
        ((l.a)localObject1).kyj.setVisibility(0);
        if (this.ksd.size() == 0)
        {
          localObject3 = new CardTagTextView(this.mContext);
          ((CardTagTextView)localObject3).setPadding(this.krZ, this.kyg, this.krZ, this.kyg);
          ((CardTagTextView)localObject3).setGravity(17);
          ((CardTagTextView)localObject3).setMinWidth(this.mContext.getResources().getDimensionPixelSize(2131428177));
          ((CardTagTextView)localObject3).setMinHeight(this.mContext.getResources().getDimensionPixelSize(2131428176));
          if (!((CardInfo)localObject4).baL()) {
            break label1103;
          }
          ((CardTagTextView)localObject3).setTextColor(com.tencent.mm.cb.a.m(this.mContext, 2131690709));
          ((CardTagTextView)localObject3).setFillColor(com.tencent.mm.cb.a.m(this.mContext, 2131689846));
          label671:
          ((CardTagTextView)localObject3).setText(paramView);
          ((CardTagTextView)localObject3).setTextSize(1, 10.0F);
          ((l.a)localObject1).kyj.addView((View)localObject3);
          label696:
          if (!paramb.baQ()) {
            break label1505;
          }
          ((l.a)localObject1).ksi.setVisibility(0);
          ((l.a)localObject1).ksk.setVisibility(0);
          ((l.a)localObject1).ksn.setVisibility(8);
          ((l.a)localObject1).ksj.setVisibility(0);
          ((l.a)localObject1).ksj.setText(paramb.bbd().knw);
          ((l.a)localObject1).ksk.setText(paramb.bbd().title);
          if (!paramb.baN()) {
            break label1162;
          }
          ((l.a)localObject1).kxs.setVisibility(0);
          ((l.a)localObject1).ksi.setVisibility(4);
          paramView = ((l.a)localObject1).kxt;
          if (TextUtils.isEmpty(paramb.bbd().wGh)) {
            break label1140;
          }
          i = this.mContext.getResources().getDimensionPixelSize(2131428180);
          com.tencent.mm.plugin.card.d.m.a(this.mContext, paramView, paramb.bbd().wGh, i, com.tencent.mm.plugin.card.d.l.IB(paramb.bbd().color));
          label870:
          if (!paramb.baL()) {
            break label1409;
          }
          if (!bo.isNullOrNil(paramb.bbe().wEe)) {
            break label1222;
          }
          paramView = com.tencent.mm.plugin.card.d.l.dR(com.tencent.mm.plugin.card.d.l.IB(paramb.bbd().color), this.kyh);
          ((l.a)localObject1).ksh.setBackgroundDrawable(paramView);
          ((l.a)localObject1).kyk.setVisibility(8);
          ((l.a)localObject1).kyl.setVisibility(8);
          ((l.a)localObject1).kym.setVisibility(0);
          label952:
          ((l.a)localObject1).ksj.setTextColor(this.mContext.getResources().getColor(2131690709));
          ((l.a)localObject1).ksk.setTextColor(this.mContext.getResources().getColor(2131690709));
          label994:
          paramb.bbd();
          if ((paramInt != this.krV.getCount() - 1) || (((l.a)localObject1).ksh == null)) {
            break label1608;
          }
          paramView = (LinearLayout.LayoutParams)((l.a)localObject1).ksh.getLayoutParams();
          if (paramView.bottomMargin != this.mContext.getResources().getDimensionPixelOffset(2131427782))
          {
            paramView.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131427782);
            ((l.a)localObject1).ksh.setLayoutParams(paramView);
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(88667);
        return localObject2;
        localObject3 = (CardTagTextView)this.ksd.removeFirst();
        break;
        label1103:
        ((CardTagTextView)localObject3).setTextColor(com.tencent.mm.cb.a.m(this.mContext, 2131690214));
        ((CardTagTextView)localObject3).setFillColor(0);
        break label671;
        ((l.a)localObject1).kyj.setVisibility(8);
        break label696;
        label1140:
        com.tencent.mm.plugin.card.d.m.a(paramView, 2130838175, com.tencent.mm.plugin.card.d.l.IB(paramb.bbd().color));
        break label870;
        label1162:
        ((l.a)localObject1).kxs.setVisibility(8);
        ((l.a)localObject1).ksi.setVisibility(0);
        i = this.mContext.getResources().getDimensionPixelSize(2131428180);
        com.tencent.mm.plugin.card.d.m.a(((l.a)localObject1).ksi, paramb.bbd().kmm, i, 2130839758, true);
        break label870;
        label1222:
        ((l.a)localObject1).ksh.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130838133));
        ((l.a)localObject1).kyk.setVisibility(0);
        ((l.a)localObject1).kyl.setVisibility(0);
        paramView = ((l.a)localObject1).kyk;
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
        ((l.a)localObject1).kym.setVisibility(8);
        break label952;
        label1409:
        ((l.a)localObject1).kym.setVisibility(8);
        ((l.a)localObject1).kyk.setVisibility(8);
        ((l.a)localObject1).kyl.setVisibility(8);
        ((l.a)localObject1).ksh.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130838133));
        ((l.a)localObject1).ksk.setTextColor(this.mContext.getResources().getColor(2131689825));
        ((l.a)localObject1).ksj.setTextColor(this.mContext.getResources().getColor(2131689825));
        break label994;
        label1505:
        ((l.a)localObject1).ksi.setVisibility(8);
        ((l.a)localObject1).ksk.setVisibility(8);
        ((l.a)localObject1).ksj.setVisibility(8);
        ((l.a)localObject1).kyj.setVisibility(8);
        ((l.a)localObject1).ksn.setVisibility(0);
        paramView = com.tencent.mm.plugin.card.d.l.dR(this.mContext.getResources().getColor(2131689845), this.kyh);
        ((l.a)localObject1).ksh.setBackgroundDrawable(paramView);
        ((l.a)localObject1).ksn.setText(this.mContext.getResources().getString(2131298005));
        break label994;
        label1608:
        paramView = (LinearLayout.LayoutParams)((l.a)localObject1).ksh.getLayoutParams();
        if (paramView.bottomMargin != 0)
        {
          paramView.bottomMargin = 0;
          ((l.a)localObject1).ksh.setLayoutParams(paramView);
        }
      }
      label1644:
      paramView = null;
    }
  }
  
  public final void a(View paramView, int paramInt, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(88670);
    paramView = (l.a)paramView.getTag();
    paramView.kyi.setTag(Integer.valueOf(paramInt));
    paramView.kyi.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(88670);
  }
  
  public final void release()
  {
    AppMethodBeat.i(88666);
    this.mContext = null;
    this.krV = null;
    if (this.ksd != null) {
      this.ksd.clear();
    }
    AppMethodBeat.o(88666);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.l
 * JD-Core Version:    0.7.0.1
 */