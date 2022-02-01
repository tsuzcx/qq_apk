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
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.o;
import com.tencent.mm.plugin.card.d.j;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.protocal.protobuf.qy;
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;

public final class l
  implements com.tencent.mm.plugin.card.base.c
{
  int it;
  private Context mContext;
  private BaseAdapter oao;
  private int oas;
  protected LinkedList<CardTagTextView> oaw;
  private int ogA;
  int ogB;
  
  public l(Context paramContext, BaseAdapter paramBaseAdapter)
  {
    AppMethodBeat.i(113592);
    this.oaw = new LinkedList();
    this.mContext = paramContext;
    this.oao = paramBaseAdapter;
    this.ogA = this.mContext.getResources().getDimensionPixelSize(2131165575);
    this.oas = this.mContext.getResources().getDimensionPixelSize(2131165500);
    this.ogB = this.mContext.getResources().getDimensionPixelOffset(2131165970);
    this.it = this.mContext.getResources().getDimensionPixelOffset(2131165971);
    AppMethodBeat.o(113592);
  }
  
  public final void Y(View paramView, int paramInt)
  {
    AppMethodBeat.i(113595);
    ((a)paramView.getTag()).ogC.setImageResource(paramInt);
    AppMethodBeat.o(113595);
  }
  
  public final void Z(View paramView, int paramInt)
  {
    AppMethodBeat.i(113596);
    ((a)paramView.getTag()).ogC.setVisibility(paramInt);
    AppMethodBeat.o(113596);
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
      if (paramb.bPm().equals("PRIVATE_TICKET_TITLE"))
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
        paramView.setTag(localObject1);
        localObject2 = paramView;
        if (((a)localObject1).oaD != null)
        {
          float f = this.mContext.getResources().getDimension(2131165199);
          ((a)localObject1).oaD.setTextSize(0, f);
        }
        if (!(this.oao.getItem(paramInt) instanceof CardInfo)) {
          break label696;
        }
        localObject4 = (CardInfo)this.oao.getItem(paramInt);
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
          if (i < ((a)localObject1).ogD.getChildCount())
          {
            localObject3 = (CardTagTextView)((a)localObject1).ogD.getChildAt(i);
            this.oaw.add(localObject3);
            i += 1;
            continue;
            if (paramb.bPm().equals("PRIVATE_INVOICE_TITLE"))
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
            if (bs.isNullOrNil(((CardInfo)localObject4).field_label_wording)) {
              break label1644;
            }
            i = 1;
            paramView = ((CardInfo)localObject4).field_label_wording;
            break label356;
          }
        }
        ((a)localObject1).ogD.removeAllViews();
        ((a)localObject1).ogD.setVisibility(0);
        if (this.oaw.size() == 0)
        {
          localObject3 = new CardTagTextView(this.mContext);
          ((CardTagTextView)localObject3).setPadding(this.oas, this.ogA, this.oas, this.ogA);
          ((CardTagTextView)localObject3).setGravity(17);
          ((CardTagTextView)localObject3).setMinWidth(this.mContext.getResources().getDimensionPixelSize(2131165976));
          ((CardTagTextView)localObject3).setMinHeight(this.mContext.getResources().getDimensionPixelSize(2131165975));
          if (!((CardInfo)localObject4).bOP()) {
            break label1103;
          }
          ((CardTagTextView)localObject3).setTextColor(com.tencent.mm.cc.a.n(this.mContext, 2131101182));
          ((CardTagTextView)localObject3).setFillColor(com.tencent.mm.cc.a.n(this.mContext, 2131100107));
          label671:
          ((CardTagTextView)localObject3).setText(paramView);
          ((CardTagTextView)localObject3).setTextSize(1, 10.0F);
          ((a)localObject1).ogD.addView((View)localObject3);
          label696:
          if (!paramb.bOU()) {
            break label1505;
          }
          ((a)localObject1).oaB.setVisibility(0);
          ((a)localObject1).oaD.setVisibility(0);
          ((a)localObject1).oaG.setVisibility(8);
          ((a)localObject1).oaC.setVisibility(0);
          ((a)localObject1).oaC.setText(paramb.bPi().nVK);
          ((a)localObject1).oaD.setText(paramb.bPi().title);
          if (!paramb.bOR()) {
            break label1162;
          }
          ((a)localObject1).ofM.setVisibility(0);
          ((a)localObject1).oaB.setVisibility(4);
          paramView = ((a)localObject1).ofN;
          if (TextUtils.isEmpty(paramb.bPi().Ekx)) {
            break label1140;
          }
          i = this.mContext.getResources().getDimensionPixelSize(2131165979);
          n.a(this.mContext, paramView, paramb.bPi().Ekx, i, com.tencent.mm.plugin.card.d.l.Vy(paramb.bPi().hiu));
          label870:
          if (!paramb.bOP()) {
            break label1409;
          }
          if (!bs.isNullOrNil(paramb.bPj().Eiq)) {
            break label1222;
          }
          paramView = com.tencent.mm.plugin.card.d.l.eQ(com.tencent.mm.plugin.card.d.l.Vy(paramb.bPi().hiu), this.ogB);
          ((a)localObject1).oaA.setBackgroundDrawable(paramView);
          ((a)localObject1).ogE.setVisibility(8);
          ((a)localObject1).ogF.setVisibility(8);
          ((a)localObject1).ogG.setVisibility(0);
          label952:
          ((a)localObject1).oaC.setTextColor(this.mContext.getResources().getColor(2131101182));
          ((a)localObject1).oaD.setTextColor(this.mContext.getResources().getColor(2131101182));
          label994:
          paramb.bPi();
          if ((paramInt != this.oao.getCount() - 1) || (((a)localObject1).oaA == null)) {
            break label1608;
          }
          paramView = (LinearLayout.LayoutParams)((a)localObject1).oaA.getLayoutParams();
          if (paramView.bottomMargin != this.mContext.getResources().getDimensionPixelOffset(2131165490))
          {
            paramView.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131165490);
            ((a)localObject1).oaA.setLayoutParams(paramView);
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(113594);
        return localObject2;
        localObject3 = (CardTagTextView)this.oaw.removeFirst();
        break;
        label1103:
        ((CardTagTextView)localObject3).setTextColor(com.tencent.mm.cc.a.n(this.mContext, 2131100547));
        ((CardTagTextView)localObject3).setFillColor(0);
        break label671;
        ((a)localObject1).ogD.setVisibility(8);
        break label696;
        label1140:
        n.b(paramView, 2131231506, com.tencent.mm.plugin.card.d.l.Vy(paramb.bPi().hiu));
        break label870;
        label1162:
        ((a)localObject1).ofM.setVisibility(8);
        ((a)localObject1).oaB.setVisibility(0);
        i = this.mContext.getResources().getDimensionPixelSize(2131165979);
        n.a(((a)localObject1).oaB, paramb.bPi().hhs, i, 2131233400, true);
        break label870;
        label1222:
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
        break label952;
        label1409:
        ((a)localObject1).ogG.setVisibility(8);
        ((a)localObject1).ogE.setVisibility(8);
        ((a)localObject1).ogF.setVisibility(8);
        ((a)localObject1).oaA.setBackgroundDrawable(this.mContext.getResources().getDrawable(2131231461));
        ((a)localObject1).oaD.setTextColor(this.mContext.getResources().getColor(2131100711));
        ((a)localObject1).oaC.setTextColor(this.mContext.getResources().getColor(2131100711));
        break label994;
        label1505:
        ((a)localObject1).oaB.setVisibility(8);
        ((a)localObject1).oaD.setVisibility(8);
        ((a)localObject1).oaC.setVisibility(8);
        ((a)localObject1).ogD.setVisibility(8);
        ((a)localObject1).oaG.setVisibility(0);
        paramView = com.tencent.mm.plugin.card.d.l.eQ(this.mContext.getResources().getColor(2131100106), this.ogB);
        ((a)localObject1).oaA.setBackgroundDrawable(paramView);
        ((a)localObject1).oaG.setText(this.mContext.getResources().getString(2131756947));
        break label994;
        label1608:
        paramView = (LinearLayout.LayoutParams)((a)localObject1).oaA.getLayoutParams();
        if (paramView.bottomMargin != 0)
        {
          paramView.bottomMargin = 0;
          ((a)localObject1).oaA.setLayoutParams(paramView);
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
    paramView.ogC.setTag(Integer.valueOf(paramInt));
    paramView.ogC.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(113597);
  }
  
  public final void release()
  {
    AppMethodBeat.i(113593);
    this.mContext = null;
    this.oao = null;
    if (this.oaw != null) {
      this.oaw.clear();
    }
    AppMethodBeat.o(113593);
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
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.l
 * JD-Core Version:    0.7.0.1
 */