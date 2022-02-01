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
import com.tencent.mm.aw.o;
import com.tencent.mm.plugin.card.d.j;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.protocal.protobuf.qo;
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class l
  implements com.tencent.mm.plugin.card.base.c
{
  int hr;
  private Context mContext;
  int nDA;
  private int nDz;
  private BaseAdapter nxo;
  private int nxs;
  protected LinkedList<CardTagTextView> nxw;
  
  public l(Context paramContext, BaseAdapter paramBaseAdapter)
  {
    AppMethodBeat.i(113592);
    this.nxw = new LinkedList();
    this.mContext = paramContext;
    this.nxo = paramBaseAdapter;
    this.nDz = this.mContext.getResources().getDimensionPixelSize(2131165575);
    this.nxs = this.mContext.getResources().getDimensionPixelSize(2131165500);
    this.nDA = this.mContext.getResources().getDimensionPixelOffset(2131165970);
    this.hr = this.mContext.getResources().getDimensionPixelOffset(2131165971);
    AppMethodBeat.o(113592);
  }
  
  public final void X(View paramView, int paramInt)
  {
    AppMethodBeat.i(113595);
    ((a)paramView.getTag()).nDB.setImageResource(paramInt);
    AppMethodBeat.o(113595);
  }
  
  public final void Y(View paramView, int paramInt)
  {
    AppMethodBeat.i(113596);
    ((a)paramView.getTag()).nDB.setVisibility(paramInt);
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
      if (paramb.bHZ().equals("PRIVATE_TICKET_TITLE"))
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
        ((a)localObject1).nxA = ((RelativeLayout)paramView.findViewById(2131297771));
        ((a)localObject1).nxB = ((ImageView)paramView.findViewById(2131297828));
        ((a)localObject1).nCL = paramView.findViewById(2131297917);
        ((a)localObject1).nCM = ((ImageView)paramView.findViewById(2131297916));
        ((a)localObject1).nxC = ((TextView)paramView.findViewById(2131297743));
        ((a)localObject1).nxD = ((TextView)paramView.findViewById(2131297863));
        ((a)localObject1).nxG = ((TextView)paramView.findViewById(2131297864));
        ((a)localObject1).nDB = ((ImageView)paramView.findViewById(2131297730));
        ((a)localObject1).nDD = ((ImageView)paramView.findViewById(2131297737));
        ((a)localObject1).nDE = ((ImageView)paramView.findViewById(2131297739));
        ((a)localObject1).nDF = ((ImageView)paramView.findViewById(2131297738));
        ((a)localObject1).nDC = ((LinearLayout)paramView.findViewById(2131297887));
        paramView.setTag(localObject1);
        localObject2 = paramView;
        if (((a)localObject1).nxD != null)
        {
          float f = this.mContext.getResources().getDimension(2131165199);
          ((a)localObject1).nxD.setTextSize(0, f);
        }
        if (!(this.nxo.getItem(paramInt) instanceof CardInfo)) {
          break label696;
        }
        localObject4 = (CardInfo)this.nxo.getItem(paramInt);
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
          if (i < ((a)localObject1).nDC.getChildCount())
          {
            localObject3 = (CardTagTextView)((a)localObject1).nDC.getChildAt(i);
            this.nxw.add(localObject3);
            i += 1;
            continue;
            if (paramb.bHZ().equals("PRIVATE_INVOICE_TITLE"))
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
        ((a)localObject1).nDC.removeAllViews();
        ((a)localObject1).nDC.setVisibility(0);
        if (this.nxw.size() == 0)
        {
          localObject3 = new CardTagTextView(this.mContext);
          ((CardTagTextView)localObject3).setPadding(this.nxs, this.nDz, this.nxs, this.nDz);
          ((CardTagTextView)localObject3).setGravity(17);
          ((CardTagTextView)localObject3).setMinWidth(this.mContext.getResources().getDimensionPixelSize(2131165976));
          ((CardTagTextView)localObject3).setMinHeight(this.mContext.getResources().getDimensionPixelSize(2131165975));
          if (!((CardInfo)localObject4).bHC()) {
            break label1103;
          }
          ((CardTagTextView)localObject3).setTextColor(com.tencent.mm.cd.a.n(this.mContext, 2131101182));
          ((CardTagTextView)localObject3).setFillColor(com.tencent.mm.cd.a.n(this.mContext, 2131100107));
          label671:
          ((CardTagTextView)localObject3).setText(paramView);
          ((CardTagTextView)localObject3).setTextSize(1, 10.0F);
          ((a)localObject1).nDC.addView((View)localObject3);
          label696:
          if (!paramb.bHH()) {
            break label1505;
          }
          ((a)localObject1).nxB.setVisibility(0);
          ((a)localObject1).nxD.setVisibility(0);
          ((a)localObject1).nxG.setVisibility(8);
          ((a)localObject1).nxC.setVisibility(0);
          ((a)localObject1).nxC.setText(paramb.bHV().nsK);
          ((a)localObject1).nxD.setText(paramb.bHV().title);
          if (!paramb.bHE()) {
            break label1162;
          }
          ((a)localObject1).nCL.setVisibility(0);
          ((a)localObject1).nxB.setVisibility(4);
          paramView = ((a)localObject1).nCM;
          if (TextUtils.isEmpty(paramb.bHV().CRM)) {
            break label1140;
          }
          i = this.mContext.getResources().getDimensionPixelSize(2131165979);
          n.a(this.mContext, paramView, paramb.bHV().CRM, i, com.tencent.mm.plugin.card.d.l.Rm(paramb.bHV().gHT));
          label870:
          if (!paramb.bHC()) {
            break label1409;
          }
          if (!bt.isNullOrNil(paramb.bHW().CPF)) {
            break label1222;
          }
          paramView = com.tencent.mm.plugin.card.d.l.eN(com.tencent.mm.plugin.card.d.l.Rm(paramb.bHV().gHT), this.nDA);
          ((a)localObject1).nxA.setBackgroundDrawable(paramView);
          ((a)localObject1).nDD.setVisibility(8);
          ((a)localObject1).nDE.setVisibility(8);
          ((a)localObject1).nDF.setVisibility(0);
          label952:
          ((a)localObject1).nxC.setTextColor(this.mContext.getResources().getColor(2131101182));
          ((a)localObject1).nxD.setTextColor(this.mContext.getResources().getColor(2131101182));
          label994:
          paramb.bHV();
          if ((paramInt != this.nxo.getCount() - 1) || (((a)localObject1).nxA == null)) {
            break label1608;
          }
          paramView = (LinearLayout.LayoutParams)((a)localObject1).nxA.getLayoutParams();
          if (paramView.bottomMargin != this.mContext.getResources().getDimensionPixelOffset(2131165490))
          {
            paramView.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131165490);
            ((a)localObject1).nxA.setLayoutParams(paramView);
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(113594);
        return localObject2;
        localObject3 = (CardTagTextView)this.nxw.removeFirst();
        break;
        label1103:
        ((CardTagTextView)localObject3).setTextColor(com.tencent.mm.cd.a.n(this.mContext, 2131100547));
        ((CardTagTextView)localObject3).setFillColor(0);
        break label671;
        ((a)localObject1).nDC.setVisibility(8);
        break label696;
        label1140:
        n.b(paramView, 2131231506, com.tencent.mm.plugin.card.d.l.Rm(paramb.bHV().gHT));
        break label870;
        label1162:
        ((a)localObject1).nCL.setVisibility(8);
        ((a)localObject1).nxB.setVisibility(0);
        i = this.mContext.getResources().getDimensionPixelSize(2131165979);
        n.a(((a)localObject1).nxB, paramb.bHV().gGR, i, 2131233400, true);
        break label870;
        label1222:
        ((a)localObject1).nxA.setBackgroundDrawable(this.mContext.getResources().getDrawable(2131231461));
        ((a)localObject1).nDD.setVisibility(0);
        ((a)localObject1).nDE.setVisibility(0);
        paramView = ((a)localObject1).nDD;
        localObject3 = paramb.bHW().CPF;
        localObject4 = new c.a();
        ((c.a)localObject4).prefixPath = com.tencent.mm.loader.j.b.aih();
        o.ayK();
        ((c.a)localObject4).hkl = null;
        ((c.a)localObject4).gjt = m.Qy((String)localObject3);
        ((c.a)localObject4).hjU = true;
        ((c.a)localObject4).hkn = true;
        ((c.a)localObject4).hjS = true;
        ((c.a)localObject4).hkf = 2131231461;
        ((c.a)localObject4).gjw = com.tencent.mm.cd.a.ao(this.mContext, 2131165971);
        ((c.a)localObject4).gjv = com.tencent.mm.cd.a.hV(this.mContext);
        localObject4 = ((c.a)localObject4).azc();
        o.ayJ().a((String)localObject3, paramView, (com.tencent.mm.aw.a.a.c)localObject4);
        paramView.setImageMatrix(new Matrix());
        ((a)localObject1).nDF.setVisibility(8);
        break label952;
        label1409:
        ((a)localObject1).nDF.setVisibility(8);
        ((a)localObject1).nDD.setVisibility(8);
        ((a)localObject1).nDE.setVisibility(8);
        ((a)localObject1).nxA.setBackgroundDrawable(this.mContext.getResources().getDrawable(2131231461));
        ((a)localObject1).nxD.setTextColor(this.mContext.getResources().getColor(2131100711));
        ((a)localObject1).nxC.setTextColor(this.mContext.getResources().getColor(2131100711));
        break label994;
        label1505:
        ((a)localObject1).nxB.setVisibility(8);
        ((a)localObject1).nxD.setVisibility(8);
        ((a)localObject1).nxC.setVisibility(8);
        ((a)localObject1).nDC.setVisibility(8);
        ((a)localObject1).nxG.setVisibility(0);
        paramView = com.tencent.mm.plugin.card.d.l.eN(this.mContext.getResources().getColor(2131100106), this.nDA);
        ((a)localObject1).nxA.setBackgroundDrawable(paramView);
        ((a)localObject1).nxG.setText(this.mContext.getResources().getString(2131756947));
        break label994;
        label1608:
        paramView = (LinearLayout.LayoutParams)((a)localObject1).nxA.getLayoutParams();
        if (paramView.bottomMargin != 0)
        {
          paramView.bottomMargin = 0;
          ((a)localObject1).nxA.setLayoutParams(paramView);
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
    paramView.nDB.setTag(Integer.valueOf(paramInt));
    paramView.nDB.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(113597);
  }
  
  public final void release()
  {
    AppMethodBeat.i(113593);
    this.mContext = null;
    this.nxo = null;
    if (this.nxw != null) {
      this.nxw.clear();
    }
    AppMethodBeat.o(113593);
  }
  
  public final class a
  {
    public View nCL;
    public ImageView nCM;
    public ImageView nDB;
    public LinearLayout nDC;
    public ImageView nDD;
    public ImageView nDE;
    public ImageView nDF;
    public RelativeLayout nxA;
    public ImageView nxB;
    public TextView nxC;
    public TextView nxD;
    public TextView nxG;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.l
 * JD-Core Version:    0.7.0.1
 */