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
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.card.d.j;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.ui.l.a;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.protocal.protobuf.ty;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class aa
  implements com.tencent.mm.plugin.card.base.c
{
  int kn;
  private Context mContext;
  private BaseAdapter pXY;
  private int pYc;
  protected LinkedList<CardTagTextView> pYg;
  private int qej;
  int qek;
  
  public aa(Context paramContext, BaseAdapter paramBaseAdapter)
  {
    AppMethodBeat.i(113721);
    this.pYg = new LinkedList();
    this.mContext = paramContext;
    this.pXY = paramBaseAdapter;
    this.qej = this.mContext.getResources().getDimensionPixelSize(2131165593);
    this.pYc = this.mContext.getResources().getDimensionPixelSize(2131165518);
    this.qek = this.mContext.getResources().getDimensionPixelOffset(2131166002);
    this.kn = this.mContext.getResources().getDimensionPixelOffset(2131166003);
    AppMethodBeat.o(113721);
  }
  
  public final void Y(View paramView, int paramInt)
  {
    AppMethodBeat.i(113724);
    ((l.a)paramView.getTag()).qel.setImageResource(paramInt);
    AppMethodBeat.o(113724);
  }
  
  public final void Z(View paramView, int paramInt)
  {
    AppMethodBeat.i(113725);
    ((l.a)paramView.getTag()).qel.setVisibility(paramInt);
    AppMethodBeat.o(113725);
  }
  
  public final View a(int paramInt, View paramView, com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113723);
    Object localObject1;
    label107:
    Object localObject2;
    if (paramView == null) {
      switch (this.pXY.getItemViewType(paramInt))
      {
      default: 
        paramView = View.inflate(this.mContext, 2131493404, null);
        localObject1 = new a();
        if ((paramb.csU().equals("PRIVATE_TICKET_TITLE")) || (paramb.csU().equals("PRIVATE_INVOICE_TITLE")))
        {
          ((a)localObject1).qkI = ((TextView)paramView.findViewById(2131298159));
          paramView.setTag(localObject1);
          localObject2 = paramView;
          label116:
          if (((a)localObject1).pYn != null)
          {
            float f = this.mContext.getResources().getDimension(2131165202);
            ((a)localObject1).pYn.setTextSize(0, f);
          }
          if (!paramb.csC()) {
            break label2016;
          }
          if (!paramb.csU().equals("PRIVATE_TICKET_TITLE")) {
            break label783;
          }
          ((a)localObject1).qkI.setText(this.mContext.getString(2131757188));
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
      if ((!paramb.csU().equals("PRIVATE_TICKET_TITLE")) && (!paramb.csU().equals("PRIVATE_INVOICE_TITLE")) && (!paramb.csB()))
      {
        paramb.csQ();
        if ((paramInt != this.pXY.getCount() - 1) || (((a)localObject1).pYk == null)) {
          break label2156;
        }
        paramView = (LinearLayout.LayoutParams)((a)localObject1).pYk.getLayoutParams();
        if (paramView.bottomMargin != this.mContext.getResources().getDimensionPixelOffset(2131165508))
        {
          paramView.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131165508);
          ((a)localObject1).pYk.setLayoutParams(paramView);
        }
      }
      AppMethodBeat.o(113723);
      return localObject2;
      localObject1 = View.inflate(this.mContext, 2131493406, null);
      if (paramb.csU().equals("PRIVATE_TICKET_TITLE"))
      {
        localObject2 = (TextView)((View)localObject1).findViewById(2131298159);
        paramView = (View)localObject1;
        if (localObject2 == null) {
          break;
        }
        ((TextView)localObject2).setText(this.mContext.getString(2131757188));
        paramView = (View)localObject1;
        break;
      }
      paramView = (View)localObject1;
      if (!paramb.csU().equals("PRIVATE_INVOICE_TITLE")) {
        break;
      }
      localObject2 = (TextView)((View)localObject1).findViewById(2131298159);
      paramView = (View)localObject1;
      if (localObject2 == null) {
        break;
      }
      ((TextView)localObject2).setText(this.mContext.getString(2131757073));
      paramView = (View)localObject1;
      break;
      paramView = View.inflate(this.mContext, 2131493404, null);
      break;
      paramView = View.inflate(this.mContext, 2131493409, null);
      break;
      if (paramb.csB())
      {
        ((a)localObject1).qkJ = ((TextView)paramView.findViewById(2131298166));
        ((a)localObject1).qkK = ((TextView)paramView.findViewById(2131298162));
        ((a)localObject1).qkL = ((TextView)paramView.findViewById(2131298164));
        ((a)localObject1).qkM = ((TextView)paramView.findViewById(2131298165));
        break label107;
      }
      ((a)localObject1).pYk = ((RelativeLayout)paramView.findViewById(2131298086));
      ((a)localObject1).pYl = ((ImageView)paramView.findViewById(2131298144));
      ((a)localObject1).qdv = paramView.findViewById(2131298235);
      ((a)localObject1).qdw = ((ImageView)paramView.findViewById(2131298234));
      ((a)localObject1).pYm = ((TextView)paramView.findViewById(2131298056));
      ((a)localObject1).pYn = ((TextView)paramView.findViewById(2131298179));
      ((a)localObject1).pYq = ((TextView)paramView.findViewById(2131298180));
      ((a)localObject1).qel = ((ImageView)paramView.findViewById(2131298034));
      ((a)localObject1).qen = ((ImageView)paramView.findViewById(2131298049));
      ((a)localObject1).qeo = ((ImageView)paramView.findViewById(2131298051));
      ((a)localObject1).qep = ((ImageView)paramView.findViewById(2131298050));
      ((a)localObject1).qem = ((LinearLayout)paramView.findViewById(2131298204));
      break label107;
      localObject1 = (a)paramView.getTag();
      if (((a)localObject1).qkI != null)
      {
        if (paramb.csU().equals("PRIVATE_TICKET_TITLE"))
        {
          ((a)localObject1).qkI.setText(this.mContext.getString(2131757188));
          localObject2 = paramView;
          break label116;
        }
        ((a)localObject1).qkI.setText(this.mContext.getString(2131757073));
      }
      localObject2 = paramView;
      break label116;
      if (paramb.csU().equals("PRIVATE_INVOICE_TITLE"))
      {
        ((a)localObject1).qkI.setText(this.mContext.getString(2131757073));
      }
      else if (paramb.csB())
      {
        paramView = paramb.csQ().LeC;
        ((a)localObject1).qkJ.setText(((abz)paramView.get(0)).pRY);
        ((a)localObject1).qkL.setText(((abz)paramView.get(1)).pRY);
        paramView = paramb.csR().Lcs;
        localObject3 = String.format(this.mContext.getString(2131757084), new Object[] { ((abz)paramView.get(0)).pRY });
        ((a)localObject1).qkM.setText((CharSequence)localObject3);
        if (paramView.size() >= 2) {
          ((a)localObject1).qkK.setText(((abz)paramView.get(1)).pRY);
        }
      }
      else
      {
        if ((this.pXY.getItem(paramInt) instanceof CardInfo))
        {
          localObject4 = (CardInfo)this.pXY.getItem(paramInt);
          if ((!((CardInfo)localObject4).field_card_id.equals("PRIVATE_TICKET_TITLE")) && (!((CardInfo)localObject4).field_card_id.equals("PRIVATE_INVOICE_TITLE"))) {
            break label1311;
          }
        }
        label1010:
        ((a)localObject1).pYk.setVisibility(0);
        ((a)localObject1).pYl.setVisibility(0);
        ((a)localObject1).pYn.setVisibility(0);
        ((a)localObject1).pYq.setVisibility(8);
        ((a)localObject1).pYm.setVisibility(0);
        ((a)localObject1).pYm.setText(paramb.csQ().gTG);
        ((a)localObject1).pYn.setText(paramb.csQ().title);
        if (!paramb.csz()) {
          break label1673;
        }
        ((a)localObject1).qdv.setVisibility(0);
        ((a)localObject1).pYl.setVisibility(4);
        paramView = ((a)localObject1).qdw;
        if (TextUtils.isEmpty(paramb.csQ().LeI)) {
          break label1651;
        }
        i = this.mContext.getResources().getDimensionPixelSize(2131166011);
        n.a(this.mContext, paramView, paramb.csQ().LeI, i, l.ake(paramb.csQ().ixw));
        label1184:
        if (!paramb.csx()) {
          break label1920;
        }
        if (!Util.isNullOrNil(paramb.csR().LcC)) {
          break label1733;
        }
        paramView = l.fi(l.ake(paramb.csQ().ixw), this.qek);
        ((a)localObject1).pYk.setBackgroundDrawable(paramView);
        ((a)localObject1).qen.setVisibility(8);
        ((a)localObject1).qeo.setVisibility(8);
        ((a)localObject1).qep.setVisibility(0);
        label1266:
        ((a)localObject1).pYm.setTextColor(this.mContext.getResources().getColor(2131101427));
        ((a)localObject1).pYn.setTextColor(this.mContext.getResources().getColor(2131101427));
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
          if (i < ((a)localObject1).qem.getChildCount())
          {
            localObject3 = (CardTagTextView)((a)localObject1).qem.getChildAt(i);
            this.pYg.add(localObject3);
            i += 1;
            continue;
            if (Util.isNullOrNil(((CardInfo)localObject4).field_label_wording)) {
              break label2192;
            }
            i = 1;
            paramView = ((CardInfo)localObject4).field_label_wording;
            break;
          }
        }
        ((a)localObject1).qem.removeAllViews();
        ((a)localObject1).qem.setVisibility(0);
        if (this.pYg.size() == 0)
        {
          localObject3 = new CardTagTextView(this.mContext);
          label1469:
          ((CardTagTextView)localObject3).setPadding(this.pYc, this.qej, this.pYc, this.qej);
          ((CardTagTextView)localObject3).setGravity(17);
          ((CardTagTextView)localObject3).setMinWidth(this.mContext.getResources().getDimensionPixelSize(2131166008));
          ((CardTagTextView)localObject3).setMinHeight(this.mContext.getResources().getDimensionPixelSize(2131166007));
          if (!((CardInfo)localObject4).csx()) {
            break label1614;
          }
          ((CardTagTextView)localObject3).setTextColor(com.tencent.mm.cb.a.n(this.mContext, 2131101427));
          ((CardTagTextView)localObject3).setFillColor(com.tencent.mm.cb.a.n(this.mContext, 2131100138));
        }
        for (;;)
        {
          ((CardTagTextView)localObject3).setText(paramView);
          ((CardTagTextView)localObject3).setTextSize(1, 10.0F);
          ((a)localObject1).qem.addView((View)localObject3);
          break;
          localObject3 = (CardTagTextView)this.pYg.removeFirst();
          break label1469;
          label1614:
          ((CardTagTextView)localObject3).setTextColor(com.tencent.mm.cb.a.n(this.mContext, 2131100685));
          ((CardTagTextView)localObject3).setFillColor(0);
        }
      }
      ((a)localObject1).qem.setVisibility(8);
      break label1010;
      label1651:
      n.b(paramView, 2131231570, l.ake(paramb.csQ().ixw));
      break label1184;
      label1673:
      ((a)localObject1).qdv.setVisibility(8);
      ((a)localObject1).pYl.setVisibility(0);
      i = this.mContext.getResources().getDimensionPixelSize(2131166011);
      n.a(((a)localObject1).pYl, paramb.csQ().iwv, i, 2131234198, true);
      break label1184;
      label1733:
      ((a)localObject1).pYk.setBackgroundDrawable(this.mContext.getResources().getDrawable(2131231525));
      ((a)localObject1).qen.setVisibility(0);
      ((a)localObject1).qeo.setVisibility(0);
      paramView = ((a)localObject1).qen;
      localObject3 = paramb.csR().LcC;
      localObject4 = new c.a();
      ((c.a)localObject4).prefixPath = com.tencent.mm.loader.j.b.aKJ();
      q.bcW();
      ((c.a)localObject4).jbw = null;
      ((c.a)localObject4).fullPath = m.ajp((String)localObject3);
      ((c.a)localObject4).jbf = true;
      ((c.a)localObject4).jby = true;
      ((c.a)localObject4).jbd = true;
      ((c.a)localObject4).jbq = 2131231525;
      ((c.a)localObject4).hZA = com.tencent.mm.cb.a.aG(this.mContext, 2131166003);
      ((c.a)localObject4).hZz = com.tencent.mm.cb.a.jn(this.mContext);
      localObject4 = ((c.a)localObject4).bdv();
      q.bcV().a((String)localObject3, paramView, (com.tencent.mm.av.a.a.c)localObject4);
      paramView.setImageMatrix(new Matrix());
      ((a)localObject1).qep.setVisibility(8);
      break label1266;
      label1920:
      ((a)localObject1).qep.setVisibility(8);
      ((a)localObject1).qen.setVisibility(8);
      ((a)localObject1).qeo.setVisibility(8);
      ((a)localObject1).pYk.setBackgroundDrawable(this.mContext.getResources().getDrawable(2131231525));
      ((a)localObject1).pYn.setTextColor(this.mContext.getResources().getColor(2131100116));
      ((a)localObject1).pYm.setTextColor(this.mContext.getResources().getColor(2131100116));
      break;
      label2016:
      if ((paramb.csU().equals("PRIVATE_TICKET_TITLE")) || (paramb.csU().equals("PRIVATE_INVOICE_TITLE")) || (paramb.csB())) {
        break;
      }
      ((a)localObject1).pYl.setVisibility(8);
      ((a)localObject1).pYn.setVisibility(8);
      ((a)localObject1).pYm.setVisibility(8);
      ((a)localObject1).qem.setVisibility(8);
      ((a)localObject1).pYq.setVisibility(0);
      paramView = l.fi(this.mContext.getResources().getColor(2131100137), this.qek);
      ((a)localObject1).pYk.setBackgroundDrawable(paramView);
      ((a)localObject1).pYq.setText(this.mContext.getResources().getString(2131757117));
      break;
      label2156:
      paramView = (LinearLayout.LayoutParams)((a)localObject1).pYk.getLayoutParams();
      if (paramView.bottomMargin == 0) {
        break label310;
      }
      paramView.bottomMargin = 0;
      ((a)localObject1).pYk.setLayoutParams(paramView);
      break label310;
      label2192:
      paramView = null;
    }
  }
  
  public final void a(View paramView, int paramInt, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(113726);
    CardInfo localCardInfo = (CardInfo)this.pXY.getItem(paramInt);
    if ((localCardInfo.field_card_id.equals("PRIVATE_TICKET_TITLE")) || (localCardInfo.field_card_id.equals("PRIVATE_INVOICE_TITLE")))
    {
      AppMethodBeat.o(113726);
      return;
    }
    paramView = (a)paramView.getTag();
    paramView.qel.setTag(Integer.valueOf(paramInt));
    paramView.qel.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(113726);
  }
  
  public final void release()
  {
    AppMethodBeat.i(113722);
    this.mContext = null;
    this.pXY = null;
    if (this.pYg != null) {
      this.pYg.clear();
    }
    AppMethodBeat.o(113722);
  }
  
  public final class a
  {
    public RelativeLayout pYk;
    public ImageView pYl;
    public TextView pYm;
    public TextView pYn;
    public TextView pYq;
    public View qdv;
    public ImageView qdw;
    public ImageView qel;
    public LinearLayout qem;
    public ImageView qen;
    public ImageView qeo;
    public ImageView qep;
    public TextView qkI;
    public TextView qkJ;
    public TextView qkK;
    public TextView qkL;
    public TextView qkM;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.aa
 * JD-Core Version:    0.7.0.1
 */