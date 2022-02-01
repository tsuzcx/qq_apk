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
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.o;
import com.tencent.mm.plugin.card.d.j;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.ui.l.a;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.protocal.protobuf.qy;
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.protocal.protobuf.yg;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;

public final class aa
  implements com.tencent.mm.plugin.card.base.c
{
  int it;
  private Context mContext;
  private BaseAdapter oao;
  private int oas;
  protected LinkedList<CardTagTextView> oaw;
  private int ogA;
  int ogB;
  
  public aa(Context paramContext, BaseAdapter paramBaseAdapter)
  {
    AppMethodBeat.i(113721);
    this.oaw = new LinkedList();
    this.mContext = paramContext;
    this.oao = paramBaseAdapter;
    this.ogA = this.mContext.getResources().getDimensionPixelSize(2131165575);
    this.oas = this.mContext.getResources().getDimensionPixelSize(2131165500);
    this.ogB = this.mContext.getResources().getDimensionPixelOffset(2131165970);
    this.it = this.mContext.getResources().getDimensionPixelOffset(2131165971);
    AppMethodBeat.o(113721);
  }
  
  public final void Y(View paramView, int paramInt)
  {
    AppMethodBeat.i(113724);
    ((l.a)paramView.getTag()).ogC.setImageResource(paramInt);
    AppMethodBeat.o(113724);
  }
  
  public final void Z(View paramView, int paramInt)
  {
    AppMethodBeat.i(113725);
    ((l.a)paramView.getTag()).ogC.setVisibility(paramInt);
    AppMethodBeat.o(113725);
  }
  
  public final View a(int paramInt, View paramView, com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113723);
    Object localObject1;
    label107:
    Object localObject2;
    if (paramView == null) {
      switch (this.oao.getItemViewType(paramInt))
      {
      default: 
        paramView = View.inflate(this.mContext, 2131493313, null);
        localObject1 = new a();
        if ((paramb.bPm().equals("PRIVATE_TICKET_TITLE")) || (paramb.bPm().equals("PRIVATE_INVOICE_TITLE")))
        {
          ((a)localObject1).olR = ((TextView)paramView.findViewById(2131297843));
          paramView.setTag(localObject1);
          localObject2 = paramView;
          label116:
          if (((a)localObject1).oaD != null)
          {
            float f = this.mContext.getResources().getDimension(2131165199);
            ((a)localObject1).oaD.setTextSize(0, f);
          }
          if (!paramb.bOU()) {
            break label2016;
          }
          if (!paramb.bPm().equals("PRIVATE_TICKET_TITLE")) {
            break label783;
          }
          ((a)localObject1).olR.setText(this.mContext.getString(2131757018));
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
      if ((!paramb.bPm().equals("PRIVATE_TICKET_TITLE")) && (!paramb.bPm().equals("PRIVATE_INVOICE_TITLE")) && (!paramb.bOT()))
      {
        paramb.bPi();
        if ((paramInt != this.oao.getCount() - 1) || (((a)localObject1).oaA == null)) {
          break label2156;
        }
        paramView = (LinearLayout.LayoutParams)((a)localObject1).oaA.getLayoutParams();
        if (paramView.bottomMargin != this.mContext.getResources().getDimensionPixelOffset(2131165490))
        {
          paramView.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131165490);
          ((a)localObject1).oaA.setLayoutParams(paramView);
        }
      }
      AppMethodBeat.o(113723);
      return localObject2;
      localObject1 = View.inflate(this.mContext, 2131493315, null);
      if (paramb.bPm().equals("PRIVATE_TICKET_TITLE"))
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
      if (!paramb.bPm().equals("PRIVATE_INVOICE_TITLE")) {
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
      if (paramb.bOT())
      {
        ((a)localObject1).olS = ((TextView)paramView.findViewById(2131297850));
        ((a)localObject1).olT = ((TextView)paramView.findViewById(2131297846));
        ((a)localObject1).olU = ((TextView)paramView.findViewById(2131297848));
        ((a)localObject1).olV = ((TextView)paramView.findViewById(2131297849));
        break label107;
      }
      ((a)localObject1).oaA = ((RelativeLayout)paramView.findViewById(2131297771));
      ((a)localObject1).oaB = ((ImageView)paramView.findViewById(2131297828));
      ((a)localObject1).ofM = paramView.findViewById(2131297917);
      ((a)localObject1).ofN = ((ImageView)paramView.findViewById(2131297916));
      ((a)localObject1).oaC = ((TextView)paramView.findViewById(2131297743));
      ((a)localObject1).oaD = ((TextView)paramView.findViewById(2131297863));
      ((a)localObject1).oaG = ((TextView)paramView.findViewById(2131297864));
      ((a)localObject1).ogC = ((ImageView)paramView.findViewById(2131297730));
      ((a)localObject1).ogE = ((ImageView)paramView.findViewById(2131297737));
      ((a)localObject1).ogF = ((ImageView)paramView.findViewById(2131297739));
      ((a)localObject1).ogG = ((ImageView)paramView.findViewById(2131297738));
      ((a)localObject1).ogD = ((LinearLayout)paramView.findViewById(2131297887));
      break label107;
      localObject1 = (a)paramView.getTag();
      if (((a)localObject1).olR != null)
      {
        if (paramb.bPm().equals("PRIVATE_TICKET_TITLE"))
        {
          ((a)localObject1).olR.setText(this.mContext.getString(2131757018));
          localObject2 = paramView;
          break label116;
        }
        ((a)localObject1).olR.setText(this.mContext.getString(2131756903));
      }
      localObject2 = paramView;
      break label116;
      if (paramb.bPm().equals("PRIVATE_INVOICE_TITLE"))
      {
        ((a)localObject1).olR.setText(this.mContext.getString(2131756903));
      }
      else if (paramb.bOT())
      {
        paramView = paramb.bPi().Ekq;
        ((a)localObject1).olS.setText(((yg)paramView.get(0)).nUs);
        ((a)localObject1).olU.setText(((yg)paramView.get(1)).nUs);
        paramView = paramb.bPj().Eig;
        localObject3 = String.format(this.mContext.getString(2131756914), new Object[] { ((yg)paramView.get(0)).nUs });
        ((a)localObject1).olV.setText((CharSequence)localObject3);
        if (paramView.size() >= 2) {
          ((a)localObject1).olT.setText(((yg)paramView.get(1)).nUs);
        }
      }
      else
      {
        if ((this.oao.getItem(paramInt) instanceof CardInfo))
        {
          localObject4 = (CardInfo)this.oao.getItem(paramInt);
          if ((!((CardInfo)localObject4).field_card_id.equals("PRIVATE_TICKET_TITLE")) && (!((CardInfo)localObject4).field_card_id.equals("PRIVATE_INVOICE_TITLE"))) {
            break label1311;
          }
        }
        label1010:
        ((a)localObject1).oaA.setVisibility(0);
        ((a)localObject1).oaB.setVisibility(0);
        ((a)localObject1).oaD.setVisibility(0);
        ((a)localObject1).oaG.setVisibility(8);
        ((a)localObject1).oaC.setVisibility(0);
        ((a)localObject1).oaC.setText(paramb.bPi().nVK);
        ((a)localObject1).oaD.setText(paramb.bPi().title);
        if (!paramb.bOR()) {
          break label1673;
        }
        ((a)localObject1).ofM.setVisibility(0);
        ((a)localObject1).oaB.setVisibility(4);
        paramView = ((a)localObject1).ofN;
        if (TextUtils.isEmpty(paramb.bPi().Ekx)) {
          break label1651;
        }
        i = this.mContext.getResources().getDimensionPixelSize(2131165979);
        n.a(this.mContext, paramView, paramb.bPi().Ekx, i, l.Vy(paramb.bPi().hiu));
        label1184:
        if (!paramb.bOP()) {
          break label1920;
        }
        if (!bs.isNullOrNil(paramb.bPj().Eiq)) {
          break label1733;
        }
        paramView = l.eQ(l.Vy(paramb.bPi().hiu), this.ogB);
        ((a)localObject1).oaA.setBackgroundDrawable(paramView);
        ((a)localObject1).ogE.setVisibility(8);
        ((a)localObject1).ogF.setVisibility(8);
        ((a)localObject1).ogG.setVisibility(0);
        label1266:
        ((a)localObject1).oaC.setTextColor(this.mContext.getResources().getColor(2131101182));
        ((a)localObject1).oaD.setTextColor(this.mContext.getResources().getColor(2131101182));
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
          if (i < ((a)localObject1).ogD.getChildCount())
          {
            localObject3 = (CardTagTextView)((a)localObject1).ogD.getChildAt(i);
            this.oaw.add(localObject3);
            i += 1;
            continue;
            if (bs.isNullOrNil(((CardInfo)localObject4).field_label_wording)) {
              break label2192;
            }
            i = 1;
            paramView = ((CardInfo)localObject4).field_label_wording;
            break;
          }
        }
        ((a)localObject1).ogD.removeAllViews();
        ((a)localObject1).ogD.setVisibility(0);
        if (this.oaw.size() == 0)
        {
          localObject3 = new CardTagTextView(this.mContext);
          label1469:
          ((CardTagTextView)localObject3).setPadding(this.oas, this.ogA, this.oas, this.ogA);
          ((CardTagTextView)localObject3).setGravity(17);
          ((CardTagTextView)localObject3).setMinWidth(this.mContext.getResources().getDimensionPixelSize(2131165976));
          ((CardTagTextView)localObject3).setMinHeight(this.mContext.getResources().getDimensionPixelSize(2131165975));
          if (!((CardInfo)localObject4).bOP()) {
            break label1614;
          }
          ((CardTagTextView)localObject3).setTextColor(com.tencent.mm.cc.a.n(this.mContext, 2131101182));
          ((CardTagTextView)localObject3).setFillColor(com.tencent.mm.cc.a.n(this.mContext, 2131100107));
        }
        for (;;)
        {
          ((CardTagTextView)localObject3).setText(paramView);
          ((CardTagTextView)localObject3).setTextSize(1, 10.0F);
          ((a)localObject1).ogD.addView((View)localObject3);
          break;
          localObject3 = (CardTagTextView)this.oaw.removeFirst();
          break label1469;
          label1614:
          ((CardTagTextView)localObject3).setTextColor(com.tencent.mm.cc.a.n(this.mContext, 2131100547));
          ((CardTagTextView)localObject3).setFillColor(0);
        }
      }
      ((a)localObject1).ogD.setVisibility(8);
      break label1010;
      label1651:
      n.b(paramView, 2131231506, l.Vy(paramb.bPi().hiu));
      break label1184;
      label1673:
      ((a)localObject1).ofM.setVisibility(8);
      ((a)localObject1).oaB.setVisibility(0);
      i = this.mContext.getResources().getDimensionPixelSize(2131165979);
      n.a(((a)localObject1).oaB, paramb.bPi().hhs, i, 2131233400, true);
      break label1184;
      label1733:
      ((a)localObject1).oaA.setBackgroundDrawable(this.mContext.getResources().getDrawable(2131231461));
      ((a)localObject1).ogE.setVisibility(0);
      ((a)localObject1).ogF.setVisibility(0);
      paramView = ((a)localObject1).ogE;
      localObject3 = paramb.bPj().Eiq;
      localObject4 = new c.a();
      ((c.a)localObject4).prefixPath = com.tencent.mm.loader.j.b.aph();
      o.aFC();
      ((c.a)localObject4).hKO = null;
      ((c.a)localObject4).gKe = m.UK((String)localObject3);
      ((c.a)localObject4).hKx = true;
      ((c.a)localObject4).hKQ = true;
      ((c.a)localObject4).hKv = true;
      ((c.a)localObject4).hKI = 2131231461;
      ((c.a)localObject4).gKh = com.tencent.mm.cc.a.au(this.mContext, 2131165971);
      ((c.a)localObject4).gKg = com.tencent.mm.cc.a.ig(this.mContext);
      localObject4 = ((c.a)localObject4).aFT();
      o.aFB().a((String)localObject3, paramView, (com.tencent.mm.av.a.a.c)localObject4);
      paramView.setImageMatrix(new Matrix());
      ((a)localObject1).ogG.setVisibility(8);
      break label1266;
      label1920:
      ((a)localObject1).ogG.setVisibility(8);
      ((a)localObject1).ogE.setVisibility(8);
      ((a)localObject1).ogF.setVisibility(8);
      ((a)localObject1).oaA.setBackgroundDrawable(this.mContext.getResources().getDrawable(2131231461));
      ((a)localObject1).oaD.setTextColor(this.mContext.getResources().getColor(2131100085));
      ((a)localObject1).oaC.setTextColor(this.mContext.getResources().getColor(2131100085));
      break;
      label2016:
      if ((paramb.bPm().equals("PRIVATE_TICKET_TITLE")) || (paramb.bPm().equals("PRIVATE_INVOICE_TITLE")) || (paramb.bOT())) {
        break;
      }
      ((a)localObject1).oaB.setVisibility(8);
      ((a)localObject1).oaD.setVisibility(8);
      ((a)localObject1).oaC.setVisibility(8);
      ((a)localObject1).ogD.setVisibility(8);
      ((a)localObject1).oaG.setVisibility(0);
      paramView = l.eQ(this.mContext.getResources().getColor(2131100106), this.ogB);
      ((a)localObject1).oaA.setBackgroundDrawable(paramView);
      ((a)localObject1).oaG.setText(this.mContext.getResources().getString(2131756947));
      break;
      label2156:
      paramView = (LinearLayout.LayoutParams)((a)localObject1).oaA.getLayoutParams();
      if (paramView.bottomMargin == 0) {
        break label310;
      }
      paramView.bottomMargin = 0;
      ((a)localObject1).oaA.setLayoutParams(paramView);
      break label310;
      label2192:
      paramView = null;
    }
  }
  
  public final void a(View paramView, int paramInt, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(113726);
    CardInfo localCardInfo = (CardInfo)this.oao.getItem(paramInt);
    if ((localCardInfo.field_card_id.equals("PRIVATE_TICKET_TITLE")) || (localCardInfo.field_card_id.equals("PRIVATE_INVOICE_TITLE")))
    {
      AppMethodBeat.o(113726);
      return;
    }
    paramView = (a)paramView.getTag();
    paramView.ogC.setTag(Integer.valueOf(paramInt));
    paramView.ogC.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(113726);
  }
  
  public final void release()
  {
    AppMethodBeat.i(113722);
    this.mContext = null;
    this.oao = null;
    if (this.oaw != null) {
      this.oaw.clear();
    }
    AppMethodBeat.o(113722);
  }
  
  public final class a
  {
    public RelativeLayout oaA;
    public ImageView oaB;
    public TextView oaC;
    public TextView oaD;
    public TextView oaG;
    public View ofM;
    public ImageView ofN;
    public ImageView ogC;
    public LinearLayout ogD;
    public ImageView ogE;
    public ImageView ogF;
    public ImageView ogG;
    public TextView olR;
    public TextView olS;
    public TextView olT;
    public TextView olU;
    public TextView olV;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.aa
 * JD-Core Version:    0.7.0.1
 */