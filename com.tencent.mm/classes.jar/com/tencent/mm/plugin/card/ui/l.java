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
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.card.d.j;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.protocal.protobuf.ty;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class l
  implements com.tencent.mm.plugin.card.base.c
{
  int kn;
  private Context mContext;
  private BaseAdapter pXY;
  private int pYc;
  protected LinkedList<CardTagTextView> pYg;
  private int qej;
  int qek;
  
  public l(Context paramContext, BaseAdapter paramBaseAdapter)
  {
    AppMethodBeat.i(113592);
    this.pYg = new LinkedList();
    this.mContext = paramContext;
    this.pXY = paramBaseAdapter;
    this.qej = this.mContext.getResources().getDimensionPixelSize(2131165593);
    this.pYc = this.mContext.getResources().getDimensionPixelSize(2131165518);
    this.qek = this.mContext.getResources().getDimensionPixelOffset(2131166002);
    this.kn = this.mContext.getResources().getDimensionPixelOffset(2131166003);
    AppMethodBeat.o(113592);
  }
  
  public final void Y(View paramView, int paramInt)
  {
    AppMethodBeat.i(113595);
    ((a)paramView.getTag()).qel.setImageResource(paramInt);
    AppMethodBeat.o(113595);
  }
  
  public final void Z(View paramView, int paramInt)
  {
    AppMethodBeat.i(113596);
    ((a)paramView.getTag()).qel.setVisibility(paramInt);
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
      if (paramb.csU().equals("PRIVATE_TICKET_TITLE"))
      {
        localObject1 = View.inflate(this.mContext, 2131493406, null);
        localObject2 = (TextView)((View)localObject1).findViewById(2131298159);
        paramView = (View)localObject1;
        if (localObject2 != null)
        {
          ((TextView)localObject2).setText(this.mContext.getString(2131757188));
          paramView = (View)localObject1;
        }
        localObject1 = new a();
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
        paramView.setTag(localObject1);
        localObject2 = paramView;
        if (((a)localObject1).pYn != null)
        {
          float f = this.mContext.getResources().getDimension(2131165202);
          ((a)localObject1).pYn.setTextSize(0, f);
        }
        if (!(this.pXY.getItem(paramInt) instanceof CardInfo)) {
          break label696;
        }
        localObject4 = (CardInfo)this.pXY.getItem(paramInt);
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
          if (i < ((a)localObject1).qem.getChildCount())
          {
            localObject3 = (CardTagTextView)((a)localObject1).qem.getChildAt(i);
            this.pYg.add(localObject3);
            i += 1;
            continue;
            if (paramb.csU().equals("PRIVATE_INVOICE_TITLE"))
            {
              localObject1 = View.inflate(this.mContext, 2131493406, null);
              localObject2 = (TextView)((View)localObject1).findViewById(2131298159);
              paramView = (View)localObject1;
              if (localObject2 == null) {
                break;
              }
              ((TextView)localObject2).setText(this.mContext.getString(2131757073));
              paramView = (View)localObject1;
              break;
            }
            paramView = View.inflate(this.mContext, 2131493404, null);
            break;
            localObject1 = (a)paramView.getTag();
            localObject2 = paramView;
            break label256;
            label506:
            if (Util.isNullOrNil(((CardInfo)localObject4).field_label_wording)) {
              break label1644;
            }
            i = 1;
            paramView = ((CardInfo)localObject4).field_label_wording;
            break label356;
          }
        }
        ((a)localObject1).qem.removeAllViews();
        ((a)localObject1).qem.setVisibility(0);
        if (this.pYg.size() == 0)
        {
          localObject3 = new CardTagTextView(this.mContext);
          ((CardTagTextView)localObject3).setPadding(this.pYc, this.qej, this.pYc, this.qej);
          ((CardTagTextView)localObject3).setGravity(17);
          ((CardTagTextView)localObject3).setMinWidth(this.mContext.getResources().getDimensionPixelSize(2131166008));
          ((CardTagTextView)localObject3).setMinHeight(this.mContext.getResources().getDimensionPixelSize(2131166007));
          if (!((CardInfo)localObject4).csx()) {
            break label1103;
          }
          ((CardTagTextView)localObject3).setTextColor(com.tencent.mm.cb.a.n(this.mContext, 2131101427));
          ((CardTagTextView)localObject3).setFillColor(com.tencent.mm.cb.a.n(this.mContext, 2131100138));
          label671:
          ((CardTagTextView)localObject3).setText(paramView);
          ((CardTagTextView)localObject3).setTextSize(1, 10.0F);
          ((a)localObject1).qem.addView((View)localObject3);
          label696:
          if (!paramb.csC()) {
            break label1505;
          }
          ((a)localObject1).pYl.setVisibility(0);
          ((a)localObject1).pYn.setVisibility(0);
          ((a)localObject1).pYq.setVisibility(8);
          ((a)localObject1).pYm.setVisibility(0);
          ((a)localObject1).pYm.setText(paramb.csQ().gTG);
          ((a)localObject1).pYn.setText(paramb.csQ().title);
          if (!paramb.csz()) {
            break label1162;
          }
          ((a)localObject1).qdv.setVisibility(0);
          ((a)localObject1).pYl.setVisibility(4);
          paramView = ((a)localObject1).qdw;
          if (TextUtils.isEmpty(paramb.csQ().LeI)) {
            break label1140;
          }
          i = this.mContext.getResources().getDimensionPixelSize(2131166011);
          n.a(this.mContext, paramView, paramb.csQ().LeI, i, com.tencent.mm.plugin.card.d.l.ake(paramb.csQ().ixw));
          label870:
          if (!paramb.csx()) {
            break label1409;
          }
          if (!Util.isNullOrNil(paramb.csR().LcC)) {
            break label1222;
          }
          paramView = com.tencent.mm.plugin.card.d.l.fi(com.tencent.mm.plugin.card.d.l.ake(paramb.csQ().ixw), this.qek);
          ((a)localObject1).pYk.setBackgroundDrawable(paramView);
          ((a)localObject1).qen.setVisibility(8);
          ((a)localObject1).qeo.setVisibility(8);
          ((a)localObject1).qep.setVisibility(0);
          label952:
          ((a)localObject1).pYm.setTextColor(this.mContext.getResources().getColor(2131101427));
          ((a)localObject1).pYn.setTextColor(this.mContext.getResources().getColor(2131101427));
          label994:
          paramb.csQ();
          if ((paramInt != this.pXY.getCount() - 1) || (((a)localObject1).pYk == null)) {
            break label1608;
          }
          paramView = (LinearLayout.LayoutParams)((a)localObject1).pYk.getLayoutParams();
          if (paramView.bottomMargin != this.mContext.getResources().getDimensionPixelOffset(2131165508))
          {
            paramView.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131165508);
            ((a)localObject1).pYk.setLayoutParams(paramView);
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(113594);
        return localObject2;
        localObject3 = (CardTagTextView)this.pYg.removeFirst();
        break;
        label1103:
        ((CardTagTextView)localObject3).setTextColor(com.tencent.mm.cb.a.n(this.mContext, 2131100685));
        ((CardTagTextView)localObject3).setFillColor(0);
        break label671;
        ((a)localObject1).qem.setVisibility(8);
        break label696;
        label1140:
        n.b(paramView, 2131231570, com.tencent.mm.plugin.card.d.l.ake(paramb.csQ().ixw));
        break label870;
        label1162:
        ((a)localObject1).qdv.setVisibility(8);
        ((a)localObject1).pYl.setVisibility(0);
        i = this.mContext.getResources().getDimensionPixelSize(2131166011);
        n.a(((a)localObject1).pYl, paramb.csQ().iwv, i, 2131234198, true);
        break label870;
        label1222:
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
        break label952;
        label1409:
        ((a)localObject1).qep.setVisibility(8);
        ((a)localObject1).qen.setVisibility(8);
        ((a)localObject1).qeo.setVisibility(8);
        ((a)localObject1).pYk.setBackgroundDrawable(this.mContext.getResources().getDrawable(2131231525));
        ((a)localObject1).pYn.setTextColor(this.mContext.getResources().getColor(2131100904));
        ((a)localObject1).pYm.setTextColor(this.mContext.getResources().getColor(2131100904));
        break label994;
        label1505:
        ((a)localObject1).pYl.setVisibility(8);
        ((a)localObject1).pYn.setVisibility(8);
        ((a)localObject1).pYm.setVisibility(8);
        ((a)localObject1).qem.setVisibility(8);
        ((a)localObject1).pYq.setVisibility(0);
        paramView = com.tencent.mm.plugin.card.d.l.fi(this.mContext.getResources().getColor(2131100137), this.qek);
        ((a)localObject1).pYk.setBackgroundDrawable(paramView);
        ((a)localObject1).pYq.setText(this.mContext.getResources().getString(2131757117));
        break label994;
        label1608:
        paramView = (LinearLayout.LayoutParams)((a)localObject1).pYk.getLayoutParams();
        if (paramView.bottomMargin != 0)
        {
          paramView.bottomMargin = 0;
          ((a)localObject1).pYk.setLayoutParams(paramView);
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
    paramView.qel.setTag(Integer.valueOf(paramInt));
    paramView.qel.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(113597);
  }
  
  public final void release()
  {
    AppMethodBeat.i(113593);
    this.mContext = null;
    this.pXY = null;
    if (this.pYg != null) {
      this.pYg.clear();
    }
    AppMethodBeat.o(113593);
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
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.l
 * JD-Core Version:    0.7.0.1
 */