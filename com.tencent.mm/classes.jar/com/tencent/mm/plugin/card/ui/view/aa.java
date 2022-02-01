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
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ay.q;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.d.j;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.ui.l.a;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.protocal.protobuf.acg;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class aa
  implements com.tencent.mm.plugin.card.base.c
{
  int bwU;
  private Context mContext;
  private int tAg;
  int tAh;
  private BaseAdapter ttU;
  private int ttX;
  protected LinkedList<CardTagTextView> tub;
  
  public aa(Context paramContext, BaseAdapter paramBaseAdapter)
  {
    AppMethodBeat.i(113721);
    this.tub = new LinkedList();
    this.mContext = paramContext;
    this.ttU = paramBaseAdapter;
    this.tAg = this.mContext.getResources().getDimensionPixelSize(a.b.SmallestPadding);
    this.ttX = this.mContext.getResources().getDimensionPixelSize(a.b.MiddlePadding);
    this.tAh = this.mContext.getResources().getDimensionPixelOffset(a.b.sZJ);
    this.bwU = this.mContext.getResources().getDimensionPixelOffset(a.b.sZK);
    AppMethodBeat.o(113721);
  }
  
  public final View a(int paramInt, View paramView, com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113723);
    Object localObject1;
    label109:
    Object localObject2;
    if (paramView == null) {
      switch (this.ttU.getItemViewType(paramInt))
      {
      default: 
        paramView = View.inflate(this.mContext, a.e.tiM, null);
        localObject1 = new a();
        if ((paramb.cGw().equals("PRIVATE_TICKET_TITLE")) || (paramb.cGw().equals("PRIVATE_INVOICE_TITLE")))
        {
          ((a)localObject1).tGE = ((TextView)paramView.findViewById(a.d.tcF));
          paramView.setTag(localObject1);
          localObject2 = paramView;
          label118:
          if (((a)localObject1).tui != null)
          {
            float f = this.mContext.getResources().getDimension(a.b.BiggerTextSize);
            ((a)localObject1).tui.setTextSize(0, f);
          }
          if (!paramb.cGd()) {
            break label2051;
          }
          if (!paramb.cGw().equals("PRIVATE_TICKET_TITLE")) {
            break label813;
          }
          ((a)localObject1).tGE.setText(this.mContext.getString(a.g.tmd));
        }
        break;
      }
    }
    label316:
    Object localObject3;
    label813:
    Object localObject4;
    for (;;)
    {
      if ((!paramb.cGw().equals("PRIVATE_TICKET_TITLE")) && (!paramb.cGw().equals("PRIVATE_INVOICE_TITLE")) && (!paramb.cGc()))
      {
        paramb.cGs();
        if ((paramInt != this.ttU.getCount() - 1) || (((a)localObject1).tuf == null)) {
          break label2191;
        }
        paramView = (LinearLayout.LayoutParams)((a)localObject1).tuf.getLayoutParams();
        if (paramView.bottomMargin != this.mContext.getResources().getDimensionPixelOffset(a.b.LittlePadding))
        {
          paramView.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(a.b.LittlePadding);
          ((a)localObject1).tuf.setLayoutParams(paramView);
        }
      }
      AppMethodBeat.o(113723);
      return localObject2;
      localObject1 = View.inflate(this.mContext, a.e.tiO, null);
      if (paramb.cGw().equals("PRIVATE_TICKET_TITLE"))
      {
        localObject2 = (TextView)((View)localObject1).findViewById(a.d.tcF);
        paramView = (View)localObject1;
        if (localObject2 == null) {
          break;
        }
        ((TextView)localObject2).setText(this.mContext.getString(a.g.tmd));
        paramView = (View)localObject1;
        break;
      }
      paramView = (View)localObject1;
      if (!paramb.cGw().equals("PRIVATE_INVOICE_TITLE")) {
        break;
      }
      localObject2 = (TextView)((View)localObject1).findViewById(a.d.tcF);
      paramView = (View)localObject1;
      if (localObject2 == null) {
        break;
      }
      ((TextView)localObject2).setText(this.mContext.getString(a.g.tkG));
      paramView = (View)localObject1;
      break;
      paramView = View.inflate(this.mContext, a.e.tiM, null);
      break;
      paramView = View.inflate(this.mContext, a.e.tiR, null);
      break;
      if (paramb.cGc())
      {
        ((a)localObject1).tGF = ((TextView)paramView.findViewById(a.d.tcK));
        ((a)localObject1).tGG = ((TextView)paramView.findViewById(a.d.tcH));
        ((a)localObject1).tGH = ((TextView)paramView.findViewById(a.d.tcI));
        ((a)localObject1).tGI = ((TextView)paramView.findViewById(a.d.tcJ));
        break label109;
      }
      ((a)localObject1).tuf = ((RelativeLayout)paramView.findViewById(a.d.tbI));
      ((a)localObject1).tug = ((ImageView)paramView.findViewById(a.d.tcw));
      ((a)localObject1).tzs = paramView.findViewById(a.d.tdI);
      ((a)localObject1).tzt = ((ImageView)paramView.findViewById(a.d.tdH));
      ((a)localObject1).tuh = ((TextView)paramView.findViewById(a.d.duY));
      ((a)localObject1).tui = ((TextView)paramView.findViewById(a.d.tcV));
      ((a)localObject1).tul = ((TextView)paramView.findViewById(a.d.tcW));
      ((a)localObject1).tAi = ((ImageView)paramView.findViewById(a.d.tbe));
      ((a)localObject1).tAk = ((ImageView)paramView.findViewById(a.d.tbk));
      ((a)localObject1).tAl = ((ImageView)paramView.findViewById(a.d.tbm));
      ((a)localObject1).tAm = ((ImageView)paramView.findViewById(a.d.tbl));
      ((a)localObject1).tAj = ((LinearLayout)paramView.findViewById(a.d.tdm));
      break label109;
      localObject1 = (a)paramView.getTag();
      if (((a)localObject1).tGE != null)
      {
        if (paramb.cGw().equals("PRIVATE_TICKET_TITLE"))
        {
          ((a)localObject1).tGE.setText(this.mContext.getString(a.g.tmd));
          localObject2 = paramView;
          break label118;
        }
        ((a)localObject1).tGE.setText(this.mContext.getString(a.g.tkG));
      }
      localObject2 = paramView;
      break label118;
      if (paramb.cGw().equals("PRIVATE_INVOICE_TITLE"))
      {
        ((a)localObject1).tGE.setText(this.mContext.getString(a.g.tkG));
      }
      else if (paramb.cGc())
      {
        paramView = paramb.cGs().SfP;
        ((a)localObject1).tGF.setText(((acg)paramView.get(0)).tnY);
        ((a)localObject1).tGH.setText(((acg)paramView.get(1)).tnY);
        paramView = paramb.cGt().SdF;
        localObject3 = String.format(this.mContext.getString(a.g.tcJ), new Object[] { ((acg)paramView.get(0)).tnY });
        ((a)localObject1).tGI.setText((CharSequence)localObject3);
        if (paramView.size() >= 2) {
          ((a)localObject1).tGG.setText(((acg)paramView.get(1)).tnY);
        }
      }
      else
      {
        if ((this.ttU.getItem(paramInt) instanceof CardInfo))
        {
          localObject4 = (CardInfo)this.ttU.getItem(paramInt);
          if ((!((CardInfo)localObject4).field_card_id.equals("PRIVATE_TICKET_TITLE")) && (!((CardInfo)localObject4).field_card_id.equals("PRIVATE_INVOICE_TITLE"))) {
            break label1345;
          }
        }
        label1041:
        ((a)localObject1).tuf.setVisibility(0);
        ((a)localObject1).tug.setVisibility(0);
        ((a)localObject1).tui.setVisibility(0);
        ((a)localObject1).tul.setVisibility(8);
        ((a)localObject1).tuh.setVisibility(0);
        ((a)localObject1).tuh.setText(paramb.cGs().jEi);
        ((a)localObject1).tui.setText(paramb.cGs().title);
        if (!paramb.cGa()) {
          break label1707;
        }
        ((a)localObject1).tzs.setVisibility(0);
        ((a)localObject1).tug.setVisibility(4);
        paramView = ((a)localObject1).tzt;
        if (TextUtils.isEmpty(paramb.cGs().SfW)) {
          break label1685;
        }
        i = this.mContext.getResources().getDimensionPixelSize(a.b.sZN);
        n.a(this.mContext, paramView, paramb.cGs().SfW, i, a.c.tan, l.arR(paramb.cGs().lmL));
        label1218:
        if (!paramb.cFY()) {
          break label1955;
        }
        if (!Util.isNullOrNil(paramb.cGt().SdP)) {
          break label1767;
        }
        paramView = l.fF(l.arR(paramb.cGs().lmL), this.tAh);
        ((a)localObject1).tuf.setBackgroundDrawable(paramView);
        ((a)localObject1).tAk.setVisibility(8);
        ((a)localObject1).tAl.setVisibility(8);
        ((a)localObject1).tAm.setVisibility(0);
        label1300:
        ((a)localObject1).tuh.setTextColor(this.mContext.getResources().getColor(a.a.white_text_color));
        ((a)localObject1).tui.setTextColor(this.mContext.getResources().getColor(a.a.white_text_color));
      }
    }
    label1345:
    int i = 0;
    if (((CardInfo)localObject4).field_stickyIndex % 10 != 0)
    {
      if (((CardInfo)localObject4).field_stickyIndex <= 0) {
        break label2227;
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
          if (i < ((a)localObject1).tAj.getChildCount())
          {
            localObject3 = (CardTagTextView)((a)localObject1).tAj.getChildAt(i);
            this.tub.add(localObject3);
            i += 1;
            continue;
            if (Util.isNullOrNil(((CardInfo)localObject4).field_label_wording)) {
              break label2227;
            }
            i = 1;
            paramView = ((CardInfo)localObject4).field_label_wording;
            break;
          }
        }
        ((a)localObject1).tAj.removeAllViews();
        ((a)localObject1).tAj.setVisibility(0);
        if (this.tub.size() == 0)
        {
          localObject3 = new CardTagTextView(this.mContext);
          label1503:
          ((CardTagTextView)localObject3).setPadding(this.ttX, this.tAg, this.ttX, this.tAg);
          ((CardTagTextView)localObject3).setGravity(17);
          ((CardTagTextView)localObject3).setMinWidth(this.mContext.getResources().getDimensionPixelSize(a.b.sZM));
          ((CardTagTextView)localObject3).setMinHeight(this.mContext.getResources().getDimensionPixelSize(a.b.sZL));
          if (!((CardInfo)localObject4).cFY()) {
            break label1648;
          }
          ((CardTagTextView)localObject3).setTextColor(com.tencent.mm.ci.a.w(this.mContext, a.a.white_text_color));
          ((CardTagTextView)localObject3).setFillColor(com.tencent.mm.ci.a.w(this.mContext, a.a.sZy));
        }
        for (;;)
        {
          ((CardTagTextView)localObject3).setText(paramView);
          ((CardTagTextView)localObject3).setTextSize(1, 10.0F);
          ((a)localObject1).tAj.addView((View)localObject3);
          break;
          localObject3 = (CardTagTextView)this.tub.removeFirst();
          break label1503;
          label1648:
          ((CardTagTextView)localObject3).setTextColor(com.tencent.mm.ci.a.w(this.mContext, a.a.link_color));
          ((CardTagTextView)localObject3).setFillColor(0);
        }
      }
      ((a)localObject1).tAj.setVisibility(8);
      break label1041;
      label1685:
      n.b(paramView, a.c.tan, l.arR(paramb.cGs().lmL));
      break label1218;
      label1707:
      ((a)localObject1).tzs.setVisibility(8);
      ((a)localObject1).tug.setVisibility(0);
      i = this.mContext.getResources().getDimensionPixelSize(a.b.sZN);
      n.a(((a)localObject1).tug, paramb.cGs().llI, i, a.c.my_card_package_defaultlogo, true);
      break label1218;
      label1767:
      ((a)localObject1).tuf.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.c.tai));
      ((a)localObject1).tAk.setVisibility(0);
      ((a)localObject1).tAl.setVisibility(0);
      paramView = ((a)localObject1).tAk;
      localObject3 = paramb.cGt().SdP;
      localObject4 = new c.a();
      ((c.a)localObject4).prefixPath = com.tencent.mm.loader.j.b.aSL();
      q.bmm();
      ((c.a)localObject4).lRV = null;
      ((c.a)localObject4).fullPath = m.arc((String)localObject3);
      ((c.a)localObject4).lRD = true;
      ((c.a)localObject4).lRX = true;
      ((c.a)localObject4).lRB = true;
      ((c.a)localObject4).lRP = a.c.tai;
      ((c.a)localObject4).kOg = com.tencent.mm.ci.a.aY(this.mContext, a.b.sZK);
      ((c.a)localObject4).kOf = com.tencent.mm.ci.a.kr(this.mContext);
      localObject4 = ((c.a)localObject4).bmL();
      q.bml().a((String)localObject3, paramView, (com.tencent.mm.ay.a.a.c)localObject4);
      paramView.setImageMatrix(new Matrix());
      ((a)localObject1).tAm.setVisibility(8);
      break label1300;
      label1955:
      ((a)localObject1).tAm.setVisibility(8);
      ((a)localObject1).tAk.setVisibility(8);
      ((a)localObject1).tAl.setVisibility(8);
      ((a)localObject1).tuf.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.c.tai));
      ((a)localObject1).tui.setTextColor(this.mContext.getResources().getColor(a.a.sZt));
      ((a)localObject1).tuh.setTextColor(this.mContext.getResources().getColor(a.a.sZt));
      break;
      label2051:
      if ((paramb.cGw().equals("PRIVATE_TICKET_TITLE")) || (paramb.cGw().equals("PRIVATE_INVOICE_TITLE")) || (paramb.cGc())) {
        break;
      }
      ((a)localObject1).tug.setVisibility(8);
      ((a)localObject1).tui.setVisibility(8);
      ((a)localObject1).tuh.setVisibility(8);
      ((a)localObject1).tAj.setVisibility(8);
      ((a)localObject1).tul.setVisibility(0);
      paramView = l.fF(this.mContext.getResources().getColor(a.a.sZx), this.tAh);
      ((a)localObject1).tuf.setBackgroundDrawable(paramView);
      ((a)localObject1).tul.setText(this.mContext.getResources().getString(a.g.card_not_support_card_type));
      break;
      label2191:
      paramView = (LinearLayout.LayoutParams)((a)localObject1).tuf.getLayoutParams();
      if (paramView.bottomMargin == 0) {
        break label316;
      }
      paramView.bottomMargin = 0;
      ((a)localObject1).tuf.setLayoutParams(paramView);
      break label316;
      label2227:
      paramView = null;
    }
  }
  
  public final void a(View paramView, int paramInt, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(113726);
    CardInfo localCardInfo = (CardInfo)this.ttU.getItem(paramInt);
    if ((localCardInfo.field_card_id.equals("PRIVATE_TICKET_TITLE")) || (localCardInfo.field_card_id.equals("PRIVATE_INVOICE_TITLE")))
    {
      AppMethodBeat.o(113726);
      return;
    }
    paramView = (a)paramView.getTag();
    paramView.tAi.setTag(Integer.valueOf(paramInt));
    paramView.tAi.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(113726);
  }
  
  public final void aa(View paramView, int paramInt)
  {
    AppMethodBeat.i(113724);
    ((l.a)paramView.getTag()).tAi.setImageResource(paramInt);
    AppMethodBeat.o(113724);
  }
  
  public final void ab(View paramView, int paramInt)
  {
    AppMethodBeat.i(113725);
    ((l.a)paramView.getTag()).tAi.setVisibility(paramInt);
    AppMethodBeat.o(113725);
  }
  
  public final void release()
  {
    AppMethodBeat.i(113722);
    this.mContext = null;
    this.ttU = null;
    if (this.tub != null) {
      this.tub.clear();
    }
    AppMethodBeat.o(113722);
  }
  
  public final class a
  {
    public ImageView tAi;
    public LinearLayout tAj;
    public ImageView tAk;
    public ImageView tAl;
    public ImageView tAm;
    public TextView tGE;
    public TextView tGF;
    public TextView tGG;
    public TextView tGH;
    public TextView tGI;
    public RelativeLayout tuf;
    public ImageView tug;
    public TextView tuh;
    public TextView tui;
    public TextView tul;
    public View tzs;
    public ImageView tzt;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.aa
 * JD-Core Version:    0.7.0.1
 */