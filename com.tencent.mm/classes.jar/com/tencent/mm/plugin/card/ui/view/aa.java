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
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.q;
import com.tencent.mm.plugin.card.d.j;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.ui.l.a;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class aa
  implements com.tencent.mm.plugin.card.base.c
{
  int kl;
  private Context mContext;
  private BaseAdapter oDI;
  private int oDM;
  protected LinkedList<CardTagTextView> oDQ;
  private int oJT;
  int oJU;
  
  public aa(Context paramContext, BaseAdapter paramBaseAdapter)
  {
    AppMethodBeat.i(113721);
    this.oDQ = new LinkedList();
    this.mContext = paramContext;
    this.oDI = paramBaseAdapter;
    this.oJT = this.mContext.getResources().getDimensionPixelSize(2131165575);
    this.oDM = this.mContext.getResources().getDimensionPixelSize(2131165500);
    this.oJU = this.mContext.getResources().getDimensionPixelOffset(2131165970);
    this.kl = this.mContext.getResources().getDimensionPixelOffset(2131165971);
    AppMethodBeat.o(113721);
  }
  
  public final void Z(View paramView, int paramInt)
  {
    AppMethodBeat.i(113724);
    ((l.a)paramView.getTag()).oJV.setImageResource(paramInt);
    AppMethodBeat.o(113724);
  }
  
  public final View a(int paramInt, View paramView, com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113723);
    Object localObject1;
    label107:
    Object localObject2;
    if (paramView == null) {
      switch (this.oDI.getItemViewType(paramInt))
      {
      default: 
        paramView = View.inflate(this.mContext, 2131493313, null);
        localObject1 = new a();
        if ((paramb.bTR().equals("PRIVATE_TICKET_TITLE")) || (paramb.bTR().equals("PRIVATE_INVOICE_TITLE")))
        {
          ((a)localObject1).oPm = ((TextView)paramView.findViewById(2131297843));
          paramView.setTag(localObject1);
          localObject2 = paramView;
          label116:
          if (((a)localObject1).oDX != null)
          {
            float f = this.mContext.getResources().getDimension(2131165199);
            ((a)localObject1).oDX.setTextSize(0, f);
          }
          if (!paramb.bTz()) {
            break label2015;
          }
          if (!paramb.bTR().equals("PRIVATE_TICKET_TITLE")) {
            break label782;
          }
          ((a)localObject1).oPm.setText(this.mContext.getString(2131757018));
        }
        break;
      }
    }
    label310:
    Object localObject3;
    label782:
    Object localObject4;
    for (;;)
    {
      if ((!paramb.bTR().equals("PRIVATE_TICKET_TITLE")) && (!paramb.bTR().equals("PRIVATE_INVOICE_TITLE")) && (!paramb.bTy()))
      {
        paramb.bTN();
        if ((paramInt != this.oDI.getCount() - 1) || (((a)localObject1).oDU == null)) {
          break label2155;
        }
        paramView = (LinearLayout.LayoutParams)((a)localObject1).oDU.getLayoutParams();
        if (paramView.bottomMargin != this.mContext.getResources().getDimensionPixelOffset(2131165490))
        {
          paramView.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131165490);
          ((a)localObject1).oDU.setLayoutParams(paramView);
        }
      }
      AppMethodBeat.o(113723);
      return localObject2;
      localObject1 = View.inflate(this.mContext, 2131493315, null);
      if (paramb.bTR().equals("PRIVATE_TICKET_TITLE"))
      {
        localObject2 = (TextView)((View)localObject1).findViewById(2131297843);
        paramView = (View)localObject1;
        if (localObject2 == null) {
          break;
        }
        ((TextView)localObject2).setText(this.mContext.getString(2131757018));
        paramView = (View)localObject1;
        break;
      }
      paramView = (View)localObject1;
      if (!paramb.bTR().equals("PRIVATE_INVOICE_TITLE")) {
        break;
      }
      localObject2 = (TextView)((View)localObject1).findViewById(2131297843);
      paramView = (View)localObject1;
      if (localObject2 == null) {
        break;
      }
      ((TextView)localObject2).setText(this.mContext.getString(2131756903));
      paramView = (View)localObject1;
      break;
      paramView = View.inflate(this.mContext, 2131493313, null);
      break;
      paramView = View.inflate(this.mContext, 2131493318, null);
      break;
      if (paramb.bTy())
      {
        ((a)localObject1).oPn = ((TextView)paramView.findViewById(2131297850));
        ((a)localObject1).oPo = ((TextView)paramView.findViewById(2131297846));
        ((a)localObject1).oPp = ((TextView)paramView.findViewById(2131297848));
        ((a)localObject1).oPq = ((TextView)paramView.findViewById(2131297849));
        break label107;
      }
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
      break label107;
      localObject1 = (a)paramView.getTag();
      if (((a)localObject1).oPm != null)
      {
        if (paramb.bTR().equals("PRIVATE_TICKET_TITLE"))
        {
          ((a)localObject1).oPm.setText(this.mContext.getString(2131757018));
          localObject2 = paramView;
          break label116;
        }
        ((a)localObject1).oPm.setText(this.mContext.getString(2131756903));
      }
      localObject2 = paramView;
      break label116;
      if (paramb.bTR().equals("PRIVATE_INVOICE_TITLE"))
      {
        ((a)localObject1).oPm.setText(this.mContext.getString(2131756903));
      }
      else if (paramb.bTy())
      {
        paramView = paramb.bTN().FRz;
        ((a)localObject1).oPn.setText(((aaf)paramView.get(0)).oxN);
        ((a)localObject1).oPp.setText(((aaf)paramView.get(1)).oxN);
        paramView = paramb.bTO().FPq;
        localObject3 = String.format(this.mContext.getString(2131756914), new Object[] { ((aaf)paramView.get(0)).oxN });
        ((a)localObject1).oPq.setText((CharSequence)localObject3);
        if (paramView.size() >= 2) {
          ((a)localObject1).oPo.setText(((aaf)paramView.get(1)).oxN);
        }
      }
      else
      {
        if ((this.oDI.getItem(paramInt) instanceof CardInfo))
        {
          localObject4 = (CardInfo)this.oDI.getItem(paramInt);
          if ((!((CardInfo)localObject4).field_card_id.equals("PRIVATE_TICKET_TITLE")) && (!((CardInfo)localObject4).field_card_id.equals("PRIVATE_INVOICE_TITLE"))) {
            break label1310;
          }
        }
        label1009:
        ((a)localObject1).oDU.setVisibility(0);
        ((a)localObject1).oDV.setVisibility(0);
        ((a)localObject1).oDX.setVisibility(0);
        ((a)localObject1).oEa.setVisibility(8);
        ((a)localObject1).oDW.setVisibility(0);
        ((a)localObject1).oDW.setText(paramb.bTN().oze);
        ((a)localObject1).oDX.setText(paramb.bTN().title);
        if (!paramb.bTw()) {
          break label1672;
        }
        ((a)localObject1).oJf.setVisibility(0);
        ((a)localObject1).oDV.setVisibility(4);
        paramView = ((a)localObject1).oJg;
        if (TextUtils.isEmpty(paramb.bTN().FRG)) {
          break label1650;
        }
        i = this.mContext.getResources().getDimensionPixelSize(2131165979);
        n.a(this.mContext, paramView, paramb.bTN().FRG, i, l.Zh(paramb.bTN().hAD));
        label1183:
        if (!paramb.bTu()) {
          break label1919;
        }
        if (!bt.isNullOrNil(paramb.bTO().FPA)) {
          break label1732;
        }
        paramView = l.eU(l.Zh(paramb.bTN().hAD), this.oJU);
        ((a)localObject1).oDU.setBackgroundDrawable(paramView);
        ((a)localObject1).oJX.setVisibility(8);
        ((a)localObject1).oJY.setVisibility(8);
        ((a)localObject1).oJZ.setVisibility(0);
        label1265:
        ((a)localObject1).oDW.setTextColor(this.mContext.getResources().getColor(2131101182));
        ((a)localObject1).oDX.setTextColor(this.mContext.getResources().getColor(2131101182));
      }
    }
    label1310:
    int i = 0;
    if (((CardInfo)localObject4).field_stickyIndex % 10 != 0)
    {
      if (((CardInfo)localObject4).field_stickyIndex <= 0) {
        break label2191;
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
          if (i < ((a)localObject1).oJW.getChildCount())
          {
            localObject3 = (CardTagTextView)((a)localObject1).oJW.getChildAt(i);
            this.oDQ.add(localObject3);
            i += 1;
            continue;
            if (bt.isNullOrNil(((CardInfo)localObject4).field_label_wording)) {
              break label2191;
            }
            i = 1;
            paramView = ((CardInfo)localObject4).field_label_wording;
            break;
          }
        }
        ((a)localObject1).oJW.removeAllViews();
        ((a)localObject1).oJW.setVisibility(0);
        if (this.oDQ.size() == 0)
        {
          localObject3 = new CardTagTextView(this.mContext);
          label1468:
          ((CardTagTextView)localObject3).setPadding(this.oDM, this.oJT, this.oDM, this.oJT);
          ((CardTagTextView)localObject3).setGravity(17);
          ((CardTagTextView)localObject3).setMinWidth(this.mContext.getResources().getDimensionPixelSize(2131165976));
          ((CardTagTextView)localObject3).setMinHeight(this.mContext.getResources().getDimensionPixelSize(2131165975));
          if (!((CardInfo)localObject4).bTu()) {
            break label1613;
          }
          ((CardTagTextView)localObject3).setTextColor(com.tencent.mm.cc.a.n(this.mContext, 2131101182));
          ((CardTagTextView)localObject3).setFillColor(com.tencent.mm.cc.a.n(this.mContext, 2131100107));
        }
        for (;;)
        {
          ((CardTagTextView)localObject3).setText(paramView);
          ((CardTagTextView)localObject3).setTextSize(1, 10.0F);
          ((a)localObject1).oJW.addView((View)localObject3);
          break;
          localObject3 = (CardTagTextView)this.oDQ.removeFirst();
          break label1468;
          label1613:
          ((CardTagTextView)localObject3).setTextColor(com.tencent.mm.cc.a.n(this.mContext, 2131100547));
          ((CardTagTextView)localObject3).setFillColor(0);
        }
      }
      ((a)localObject1).oJW.setVisibility(8);
      break label1009;
      label1650:
      n.b(paramView, 2131231506, l.Zh(paramb.bTN().hAD));
      break label1183;
      label1672:
      ((a)localObject1).oJf.setVisibility(8);
      ((a)localObject1).oDV.setVisibility(0);
      i = this.mContext.getResources().getDimensionPixelSize(2131165979);
      n.a(((a)localObject1).oDV, paramb.bTN().hzB, i, 2131233400, true);
      break label1183;
      label1732:
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
      break label1265;
      label1919:
      ((a)localObject1).oJZ.setVisibility(8);
      ((a)localObject1).oJX.setVisibility(8);
      ((a)localObject1).oJY.setVisibility(8);
      ((a)localObject1).oDU.setBackgroundDrawable(this.mContext.getResources().getDrawable(2131231461));
      ((a)localObject1).oDX.setTextColor(this.mContext.getResources().getColor(2131100085));
      ((a)localObject1).oDW.setTextColor(this.mContext.getResources().getColor(2131100085));
      break;
      label2015:
      if ((paramb.bTR().equals("PRIVATE_TICKET_TITLE")) || (paramb.bTR().equals("PRIVATE_INVOICE_TITLE")) || (paramb.bTy())) {
        break;
      }
      ((a)localObject1).oDV.setVisibility(8);
      ((a)localObject1).oDX.setVisibility(8);
      ((a)localObject1).oDW.setVisibility(8);
      ((a)localObject1).oJW.setVisibility(8);
      ((a)localObject1).oEa.setVisibility(0);
      paramView = l.eU(this.mContext.getResources().getColor(2131100106), this.oJU);
      ((a)localObject1).oDU.setBackgroundDrawable(paramView);
      ((a)localObject1).oEa.setText(this.mContext.getResources().getString(2131756947));
      break;
      label2155:
      paramView = (LinearLayout.LayoutParams)((a)localObject1).oDU.getLayoutParams();
      if (paramView.bottomMargin == 0) {
        break label310;
      }
      paramView.bottomMargin = 0;
      ((a)localObject1).oDU.setLayoutParams(paramView);
      break label310;
      label2191:
      paramView = null;
    }
  }
  
  public final void a(View paramView, int paramInt, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(113726);
    CardInfo localCardInfo = (CardInfo)this.oDI.getItem(paramInt);
    if ((localCardInfo.field_card_id.equals("PRIVATE_TICKET_TITLE")) || (localCardInfo.field_card_id.equals("PRIVATE_INVOICE_TITLE")))
    {
      AppMethodBeat.o(113726);
      return;
    }
    paramView = (a)paramView.getTag();
    paramView.oJV.setTag(Integer.valueOf(paramInt));
    paramView.oJV.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(113726);
  }
  
  public final void aa(View paramView, int paramInt)
  {
    AppMethodBeat.i(113725);
    ((l.a)paramView.getTag()).oJV.setVisibility(paramInt);
    AppMethodBeat.o(113725);
  }
  
  public final void release()
  {
    AppMethodBeat.i(113722);
    this.mContext = null;
    this.oDI = null;
    if (this.oDQ != null) {
      this.oDQ.clear();
    }
    AppMethodBeat.o(113722);
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
    public TextView oPm;
    public TextView oPn;
    public TextView oPo;
    public TextView oPp;
    public TextView oPq;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.aa
 * JD-Core Version:    0.7.0.1
 */