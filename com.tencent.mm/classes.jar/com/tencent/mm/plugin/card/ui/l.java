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
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.q;
import com.tencent.mm.plugin.card.d.j;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class l
  implements com.tencent.mm.plugin.card.base.c
{
  int kl;
  private Context mContext;
  private BaseAdapter oDI;
  private int oDM;
  protected LinkedList<CardTagTextView> oDQ;
  private int oJT;
  int oJU;
  
  public l(Context paramContext, BaseAdapter paramBaseAdapter)
  {
    AppMethodBeat.i(113592);
    this.oDQ = new LinkedList();
    this.mContext = paramContext;
    this.oDI = paramBaseAdapter;
    this.oJT = this.mContext.getResources().getDimensionPixelSize(2131165575);
    this.oDM = this.mContext.getResources().getDimensionPixelSize(2131165500);
    this.oJU = this.mContext.getResources().getDimensionPixelOffset(2131165970);
    this.kl = this.mContext.getResources().getDimensionPixelOffset(2131165971);
    AppMethodBeat.o(113592);
  }
  
  public final void Z(View paramView, int paramInt)
  {
    AppMethodBeat.i(113595);
    ((a)paramView.getTag()).oJV.setImageResource(paramInt);
    AppMethodBeat.o(113595);
  }
  
  public final View a(int paramInt, View paramView, com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113594);
    Object localObject1;
    Object localObject2;
    label256:
    Object localObject4;
    int i;
    if (paramView == null) {
      if (paramb.bTR().equals("PRIVATE_TICKET_TITLE"))
      {
        localObject1 = View.inflate(this.mContext, 2131493315, null);
        localObject2 = (TextView)((View)localObject1).findViewById(2131297843);
        paramView = (View)localObject1;
        if (localObject2 != null)
        {
          ((TextView)localObject2).setText(this.mContext.getString(2131757018));
          paramView = (View)localObject1;
        }
        localObject1 = new a();
        ((a)localObject1).oDU = ((RelativeLayout)paramView.findViewById(2131297771));
        ((a)localObject1).oDV = ((ImageView)paramView.findViewById(2131297828));
        ((a)localObject1).oJf = paramView.findViewById(2131297917);
        ((a)localObject1).oJg = ((ImageView)paramView.findViewById(2131297916));
        ((a)localObject1).oDW = ((TextView)paramView.findViewById(2131297743));
        ((a)localObject1).oDX = ((TextView)paramView.findViewById(2131297863));
        ((a)localObject1).oEa = ((TextView)paramView.findViewById(2131297864));
        ((a)localObject1).oJV = ((ImageView)paramView.findViewById(2131297730));
        ((a)localObject1).oJX = ((ImageView)paramView.findViewById(2131297737));
        ((a)localObject1).oJY = ((ImageView)paramView.findViewById(2131297739));
        ((a)localObject1).oJZ = ((ImageView)paramView.findViewById(2131297738));
        ((a)localObject1).oJW = ((LinearLayout)paramView.findViewById(2131297887));
        paramView.setTag(localObject1);
        localObject2 = paramView;
        if (((a)localObject1).oDX != null)
        {
          float f = this.mContext.getResources().getDimension(2131165199);
          ((a)localObject1).oDX.setTextSize(0, f);
        }
        if (!(this.oDI.getItem(paramInt) instanceof CardInfo)) {
          break label696;
        }
        localObject4 = (CardInfo)this.oDI.getItem(paramInt);
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
          if (i < ((a)localObject1).oJW.getChildCount())
          {
            localObject3 = (CardTagTextView)((a)localObject1).oJW.getChildAt(i);
            this.oDQ.add(localObject3);
            i += 1;
            continue;
            if (paramb.bTR().equals("PRIVATE_INVOICE_TITLE"))
            {
              localObject1 = View.inflate(this.mContext, 2131493315, null);
              localObject2 = (TextView)((View)localObject1).findViewById(2131297843);
              paramView = (View)localObject1;
              if (localObject2 == null) {
                break;
              }
              ((TextView)localObject2).setText(this.mContext.getString(2131756903));
              paramView = (View)localObject1;
              break;
            }
            paramView = View.inflate(this.mContext, 2131493313, null);
            break;
            localObject1 = (a)paramView.getTag();
            localObject2 = paramView;
            break label256;
            label506:
            if (bt.isNullOrNil(((CardInfo)localObject4).field_label_wording)) {
              break label1644;
            }
            i = 1;
            paramView = ((CardInfo)localObject4).field_label_wording;
            break label356;
          }
        }
        ((a)localObject1).oJW.removeAllViews();
        ((a)localObject1).oJW.setVisibility(0);
        if (this.oDQ.size() == 0)
        {
          localObject3 = new CardTagTextView(this.mContext);
          ((CardTagTextView)localObject3).setPadding(this.oDM, this.oJT, this.oDM, this.oJT);
          ((CardTagTextView)localObject3).setGravity(17);
          ((CardTagTextView)localObject3).setMinWidth(this.mContext.getResources().getDimensionPixelSize(2131165976));
          ((CardTagTextView)localObject3).setMinHeight(this.mContext.getResources().getDimensionPixelSize(2131165975));
          if (!((CardInfo)localObject4).bTu()) {
            break label1103;
          }
          ((CardTagTextView)localObject3).setTextColor(com.tencent.mm.cc.a.n(this.mContext, 2131101182));
          ((CardTagTextView)localObject3).setFillColor(com.tencent.mm.cc.a.n(this.mContext, 2131100107));
          label671:
          ((CardTagTextView)localObject3).setText(paramView);
          ((CardTagTextView)localObject3).setTextSize(1, 10.0F);
          ((a)localObject1).oJW.addView((View)localObject3);
          label696:
          if (!paramb.bTz()) {
            break label1505;
          }
          ((a)localObject1).oDV.setVisibility(0);
          ((a)localObject1).oDX.setVisibility(0);
          ((a)localObject1).oEa.setVisibility(8);
          ((a)localObject1).oDW.setVisibility(0);
          ((a)localObject1).oDW.setText(paramb.bTN().oze);
          ((a)localObject1).oDX.setText(paramb.bTN().title);
          if (!paramb.bTw()) {
            break label1162;
          }
          ((a)localObject1).oJf.setVisibility(0);
          ((a)localObject1).oDV.setVisibility(4);
          paramView = ((a)localObject1).oJg;
          if (TextUtils.isEmpty(paramb.bTN().FRG)) {
            break label1140;
          }
          i = this.mContext.getResources().getDimensionPixelSize(2131165979);
          n.a(this.mContext, paramView, paramb.bTN().FRG, i, com.tencent.mm.plugin.card.d.l.Zh(paramb.bTN().hAD));
          label870:
          if (!paramb.bTu()) {
            break label1409;
          }
          if (!bt.isNullOrNil(paramb.bTO().FPA)) {
            break label1222;
          }
          paramView = com.tencent.mm.plugin.card.d.l.eU(com.tencent.mm.plugin.card.d.l.Zh(paramb.bTN().hAD), this.oJU);
          ((a)localObject1).oDU.setBackgroundDrawable(paramView);
          ((a)localObject1).oJX.setVisibility(8);
          ((a)localObject1).oJY.setVisibility(8);
          ((a)localObject1).oJZ.setVisibility(0);
          label952:
          ((a)localObject1).oDW.setTextColor(this.mContext.getResources().getColor(2131101182));
          ((a)localObject1).oDX.setTextColor(this.mContext.getResources().getColor(2131101182));
          label994:
          paramb.bTN();
          if ((paramInt != this.oDI.getCount() - 1) || (((a)localObject1).oDU == null)) {
            break label1608;
          }
          paramView = (LinearLayout.LayoutParams)((a)localObject1).oDU.getLayoutParams();
          if (paramView.bottomMargin != this.mContext.getResources().getDimensionPixelOffset(2131165490))
          {
            paramView.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131165490);
            ((a)localObject1).oDU.setLayoutParams(paramView);
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(113594);
        return localObject2;
        localObject3 = (CardTagTextView)this.oDQ.removeFirst();
        break;
        label1103:
        ((CardTagTextView)localObject3).setTextColor(com.tencent.mm.cc.a.n(this.mContext, 2131100547));
        ((CardTagTextView)localObject3).setFillColor(0);
        break label671;
        ((a)localObject1).oJW.setVisibility(8);
        break label696;
        label1140:
        n.b(paramView, 2131231506, com.tencent.mm.plugin.card.d.l.Zh(paramb.bTN().hAD));
        break label870;
        label1162:
        ((a)localObject1).oJf.setVisibility(8);
        ((a)localObject1).oDV.setVisibility(0);
        i = this.mContext.getResources().getDimensionPixelSize(2131165979);
        n.a(((a)localObject1).oDV, paramb.bTN().hzB, i, 2131233400, true);
        break label870;
        label1222:
        ((a)localObject1).oDU.setBackgroundDrawable(this.mContext.getResources().getDrawable(2131231461));
        ((a)localObject1).oJX.setVisibility(0);
        ((a)localObject1).oJY.setVisibility(0);
        paramView = ((a)localObject1).oJX;
        localObject3 = paramb.bTO().FPA;
        localObject4 = new c.a();
        ((c.a)localObject4).prefixPath = com.tencent.mm.loader.j.b.arU();
        q.aIK();
        ((c.a)localObject4).idJ = null;
        ((c.a)localObject4).hdP = m.Yt((String)localObject3);
        ((c.a)localObject4).idr = true;
        ((c.a)localObject4).idL = true;
        ((c.a)localObject4).idp = true;
        ((c.a)localObject4).idD = 2131231461;
        ((c.a)localObject4).hdS = com.tencent.mm.cc.a.ax(this.mContext, 2131165971);
        ((c.a)localObject4).hdR = com.tencent.mm.cc.a.ip(this.mContext);
        localObject4 = ((c.a)localObject4).aJc();
        q.aIJ().a((String)localObject3, paramView, (com.tencent.mm.aw.a.a.c)localObject4);
        paramView.setImageMatrix(new Matrix());
        ((a)localObject1).oJZ.setVisibility(8);
        break label952;
        label1409:
        ((a)localObject1).oJZ.setVisibility(8);
        ((a)localObject1).oJX.setVisibility(8);
        ((a)localObject1).oJY.setVisibility(8);
        ((a)localObject1).oDU.setBackgroundDrawable(this.mContext.getResources().getDrawable(2131231461));
        ((a)localObject1).oDX.setTextColor(this.mContext.getResources().getColor(2131100711));
        ((a)localObject1).oDW.setTextColor(this.mContext.getResources().getColor(2131100711));
        break label994;
        label1505:
        ((a)localObject1).oDV.setVisibility(8);
        ((a)localObject1).oDX.setVisibility(8);
        ((a)localObject1).oDW.setVisibility(8);
        ((a)localObject1).oJW.setVisibility(8);
        ((a)localObject1).oEa.setVisibility(0);
        paramView = com.tencent.mm.plugin.card.d.l.eU(this.mContext.getResources().getColor(2131100106), this.oJU);
        ((a)localObject1).oDU.setBackgroundDrawable(paramView);
        ((a)localObject1).oEa.setText(this.mContext.getResources().getString(2131756947));
        break label994;
        label1608:
        paramView = (LinearLayout.LayoutParams)((a)localObject1).oDU.getLayoutParams();
        if (paramView.bottomMargin != 0)
        {
          paramView.bottomMargin = 0;
          ((a)localObject1).oDU.setLayoutParams(paramView);
        }
      }
      label1644:
      paramView = null;
    }
  }
  
  public final void a(View paramView, int paramInt, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(113597);
    paramView = (a)paramView.getTag();
    paramView.oJV.setTag(Integer.valueOf(paramInt));
    paramView.oJV.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(113597);
  }
  
  public final void aa(View paramView, int paramInt)
  {
    AppMethodBeat.i(113596);
    ((a)paramView.getTag()).oJV.setVisibility(paramInt);
    AppMethodBeat.o(113596);
  }
  
  public final void release()
  {
    AppMethodBeat.i(113593);
    this.mContext = null;
    this.oDI = null;
    if (this.oDQ != null) {
      this.oDQ.clear();
    }
    AppMethodBeat.o(113593);
  }
  
  public final class a
  {
    public RelativeLayout oDU;
    public ImageView oDV;
    public TextView oDW;
    public TextView oDX;
    public TextView oEa;
    public ImageView oJV;
    public LinearLayout oJW;
    public ImageView oJX;
    public ImageView oJY;
    public ImageView oJZ;
    public View oJf;
    public ImageView oJg;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.l
 * JD-Core Version:    0.7.0.1
 */