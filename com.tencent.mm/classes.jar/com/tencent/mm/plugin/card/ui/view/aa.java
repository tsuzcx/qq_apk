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
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.c.j;
import com.tencent.mm.plugin.card.c.l;
import com.tencent.mm.plugin.card.c.n;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.ui.l.a;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.protocal.protobuf.vr;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class aa
  implements com.tencent.mm.plugin.card.base.c
{
  int dpX;
  private Context mContext;
  private int wEC;
  int wED;
  private BaseAdapter wyr;
  private int wyu;
  protected LinkedList<CardTagTextView> wyy;
  
  public aa(Context paramContext, BaseAdapter paramBaseAdapter)
  {
    AppMethodBeat.i(113721);
    this.wyy = new LinkedList();
    this.mContext = paramContext;
    this.wyr = paramBaseAdapter;
    this.wEC = this.mContext.getResources().getDimensionPixelSize(a.b.SmallestPadding);
    this.wyu = this.mContext.getResources().getDimensionPixelSize(a.b.MiddlePadding);
    this.wED = this.mContext.getResources().getDimensionPixelOffset(a.b.wdQ);
    this.dpX = this.mContext.getResources().getDimensionPixelOffset(a.b.wdR);
    AppMethodBeat.o(113721);
  }
  
  public final View a(int paramInt, View paramView, com.tencent.mm.plugin.card.base.b paramb)
  {
    Object localObject3 = null;
    AppMethodBeat.i(113723);
    Object localObject1;
    label113:
    Object localObject2;
    if (paramView == null) {
      switch (this.wyr.getItemViewType(paramInt))
      {
      default: 
        paramView = View.inflate(this.mContext, a.e.wnj, null);
        localObject1 = new a();
        if ((paramb.djO().equals("PRIVATE_TICKET_TITLE")) || (paramb.djO().equals("PRIVATE_INVOICE_TITLE")))
        {
          ((a)localObject1).wKd = ((TextView)paramView.findViewById(a.d.wgT));
          paramView.setTag(localObject1);
          localObject2 = paramView;
          label122:
          if (((a)localObject1).wyF != null)
          {
            float f = this.mContext.getResources().getDimension(a.b.BiggerTextSize);
            ((a)localObject1).wyF.setTextSize(0, f);
          }
          if (!paramb.djv()) {
            break label2050;
          }
          if (!paramb.djO().equals("PRIVATE_TICKET_TITLE")) {
            break label817;
          }
          ((a)localObject1).wKd.setText(this.mContext.getString(a.g.wqC));
        }
        break;
      }
    }
    label320:
    Object localObject4;
    label817:
    int i;
    for (;;)
    {
      if ((!paramb.djO().equals("PRIVATE_TICKET_TITLE")) && (!paramb.djO().equals("PRIVATE_INVOICE_TITLE")) && (!paramb.dju()))
      {
        paramb.djK();
        if ((paramInt != this.wyr.getCount() - 1) || (((a)localObject1).wyC == null)) {
          break label2190;
        }
        paramView = (LinearLayout.LayoutParams)((a)localObject1).wyC.getLayoutParams();
        if (paramView.bottomMargin != this.mContext.getResources().getDimensionPixelOffset(a.b.LittlePadding))
        {
          paramView.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(a.b.LittlePadding);
          ((a)localObject1).wyC.setLayoutParams(paramView);
        }
      }
      AppMethodBeat.o(113723);
      return localObject2;
      localObject1 = View.inflate(this.mContext, a.e.wnl, null);
      if (paramb.djO().equals("PRIVATE_TICKET_TITLE"))
      {
        localObject2 = (TextView)((View)localObject1).findViewById(a.d.wgT);
        paramView = (View)localObject1;
        if (localObject2 == null) {
          break;
        }
        ((TextView)localObject2).setText(this.mContext.getString(a.g.wqC));
        paramView = (View)localObject1;
        break;
      }
      paramView = (View)localObject1;
      if (!paramb.djO().equals("PRIVATE_INVOICE_TITLE")) {
        break;
      }
      localObject2 = (TextView)((View)localObject1).findViewById(a.d.wgT);
      paramView = (View)localObject1;
      if (localObject2 == null) {
        break;
      }
      ((TextView)localObject2).setText(this.mContext.getString(a.g.wpe));
      paramView = (View)localObject1;
      break;
      paramView = View.inflate(this.mContext, a.e.wnj, null);
      break;
      paramView = View.inflate(this.mContext, a.e.wno, null);
      break;
      if (paramb.dju())
      {
        ((a)localObject1).wKe = ((TextView)paramView.findViewById(a.d.wgY));
        ((a)localObject1).wKf = ((TextView)paramView.findViewById(a.d.wgV));
        ((a)localObject1).wKg = ((TextView)paramView.findViewById(a.d.wgW));
        ((a)localObject1).wKh = ((TextView)paramView.findViewById(a.d.wgX));
        break label113;
      }
      ((a)localObject1).wyC = ((RelativeLayout)paramView.findViewById(a.d.wfV));
      ((a)localObject1).wyD = ((ImageView)paramView.findViewById(a.d.wgJ));
      ((a)localObject1).wDO = paramView.findViewById(a.d.whW);
      ((a)localObject1).wDP = ((ImageView)paramView.findViewById(a.d.whV));
      ((a)localObject1).wyE = ((TextView)paramView.findViewById(a.d.fvq));
      ((a)localObject1).wyF = ((TextView)paramView.findViewById(a.d.whj));
      ((a)localObject1).wyI = ((TextView)paramView.findViewById(a.d.whk));
      ((a)localObject1).wEE = ((ImageView)paramView.findViewById(a.d.wfo));
      ((a)localObject1).wEG = ((ImageView)paramView.findViewById(a.d.wfu));
      ((a)localObject1).wEH = ((ImageView)paramView.findViewById(a.d.wfw));
      ((a)localObject1).wEI = ((ImageView)paramView.findViewById(a.d.wfv));
      ((a)localObject1).wEF = ((LinearLayout)paramView.findViewById(a.d.whA));
      break label113;
      localObject1 = (a)paramView.getTag();
      if (((a)localObject1).wKd != null)
      {
        if (paramb.djO().equals("PRIVATE_TICKET_TITLE"))
        {
          ((a)localObject1).wKd.setText(this.mContext.getString(a.g.wqC));
          localObject2 = paramView;
          break label122;
        }
        ((a)localObject1).wKd.setText(this.mContext.getString(a.g.wpe));
      }
      localObject2 = paramView;
      break label122;
      if (paramb.djO().equals("PRIVATE_INVOICE_TITLE"))
      {
        ((a)localObject1).wKd.setText(this.mContext.getString(a.g.wpe));
      }
      else if (paramb.dju())
      {
        paramView = paramb.djK().ZdK;
        ((a)localObject1).wKe.setText(((aek)paramView.get(0)).wsz);
        ((a)localObject1).wKg.setText(((aek)paramView.get(1)).wsz);
        paramView = paramb.djL().Zbz;
        localObject3 = String.format(this.mContext.getString(a.g.wgX), new Object[] { ((aek)paramView.get(0)).wsz });
        ((a)localObject1).wKh.setText((CharSequence)localObject3);
        if (paramView.size() >= 2) {
          ((a)localObject1).wKf.setText(((aek)paramView.get(1)).wsz);
        }
      }
      else
      {
        if ((this.wyr.getItem(paramInt) instanceof CardInfo))
        {
          localObject4 = (CardInfo)this.wyr.getItem(paramInt);
          if ((!((CardInfo)localObject4).field_card_id.equals("PRIVATE_TICKET_TITLE")) && (!((CardInfo)localObject4).field_card_id.equals("PRIVATE_INVOICE_TITLE"))) {
            break label1349;
          }
        }
        label1045:
        ((a)localObject1).wyC.setVisibility(0);
        ((a)localObject1).wyD.setVisibility(0);
        ((a)localObject1).wyF.setVisibility(0);
        ((a)localObject1).wyI.setVisibility(8);
        ((a)localObject1).wyE.setVisibility(0);
        ((a)localObject1).wyE.setText(paramb.djK().mee);
        ((a)localObject1).wyF.setText(paramb.djK().title);
        if (!paramb.djs()) {
          break label1708;
        }
        ((a)localObject1).wDO.setVisibility(0);
        ((a)localObject1).wyD.setVisibility(4);
        paramView = ((a)localObject1).wDP;
        if (TextUtils.isEmpty(paramb.djK().ZdR)) {
          break label1686;
        }
        i = this.mContext.getResources().getDimensionPixelSize(a.b.wdU);
        n.a(this.mContext, paramView, paramb.djK().ZdR, i, a.c.wev, l.alv(paramb.djK().nRQ));
        label1222:
        if (!paramb.djq()) {
          break label1954;
        }
        if (!Util.isNullOrNil(paramb.djL().ZbJ)) {
          break label1768;
        }
        paramView = l.gx(l.alv(paramb.djK().nRQ), this.wED);
        ((a)localObject1).wyC.setBackgroundDrawable(paramView);
        ((a)localObject1).wEG.setVisibility(8);
        ((a)localObject1).wEH.setVisibility(8);
        ((a)localObject1).wEI.setVisibility(0);
        label1304:
        ((a)localObject1).wyE.setTextColor(this.mContext.getResources().getColor(a.a.white_text_color));
        ((a)localObject1).wyF.setTextColor(this.mContext.getResources().getColor(a.a.white_text_color));
      }
    }
    label1349:
    if (((CardInfo)localObject4).field_stickyIndex % 10 != 0)
    {
      if (((CardInfo)localObject4).field_stickyIndex <= 0) {
        break label2226;
      }
      paramView = j.a(this.mContext, ((CardInfo)localObject4).field_stickyIndex, (CardInfo)localObject4);
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        i = 0;
        for (;;)
        {
          if (i < ((a)localObject1).wEF.getChildCount())
          {
            localObject3 = (CardTagTextView)((a)localObject1).wEF.getChildAt(i);
            this.wyy.add(localObject3);
            i += 1;
            continue;
            if (Util.isNullOrNil(((CardInfo)localObject4).field_label_wording)) {
              break label2226;
            }
            paramView = ((CardInfo)localObject4).field_label_wording;
            i = 1;
            break;
          }
        }
        ((a)localObject1).wEF.removeAllViews();
        ((a)localObject1).wEF.setVisibility(0);
        if (this.wyy.size() == 0)
        {
          localObject3 = new CardTagTextView(this.mContext);
          label1504:
          ((CardTagTextView)localObject3).setPadding(this.wyu, this.wEC, this.wyu, this.wEC);
          ((CardTagTextView)localObject3).setGravity(17);
          ((CardTagTextView)localObject3).setMinWidth(this.mContext.getResources().getDimensionPixelSize(a.b.wdT));
          ((CardTagTextView)localObject3).setMinHeight(this.mContext.getResources().getDimensionPixelSize(a.b.wdS));
          if (!((CardInfo)localObject4).djq()) {
            break label1649;
          }
          ((CardTagTextView)localObject3).setTextColor(com.tencent.mm.cd.a.w(this.mContext, a.a.white_text_color));
          ((CardTagTextView)localObject3).setFillColor(com.tencent.mm.cd.a.w(this.mContext, a.a.wdH));
        }
        for (;;)
        {
          ((CardTagTextView)localObject3).setText(paramView);
          ((CardTagTextView)localObject3).setTextSize(1, 10.0F);
          ((a)localObject1).wEF.addView((View)localObject3);
          break;
          localObject3 = (CardTagTextView)this.wyy.removeFirst();
          break label1504;
          label1649:
          ((CardTagTextView)localObject3).setTextColor(com.tencent.mm.cd.a.w(this.mContext, a.a.link_color));
          ((CardTagTextView)localObject3).setFillColor(0);
        }
      }
      ((a)localObject1).wEF.setVisibility(8);
      break label1045;
      label1686:
      n.b(paramView, a.c.wev, l.alv(paramb.djK().nRQ));
      break label1222;
      label1708:
      ((a)localObject1).wDO.setVisibility(8);
      ((a)localObject1).wyD.setVisibility(0);
      i = this.mContext.getResources().getDimensionPixelSize(a.b.wdU);
      n.a(((a)localObject1).wyD, paramb.djK().nQG, i, a.c.my_card_package_defaultlogo, true);
      break label1222;
      label1768:
      ((a)localObject1).wyC.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.c.wep));
      ((a)localObject1).wEG.setVisibility(0);
      ((a)localObject1).wEH.setVisibility(0);
      paramView = ((a)localObject1).wEG;
      localObject3 = paramb.djL().ZbJ;
      localObject4 = new c.a();
      ((c.a)localObject4).prefixPath = com.tencent.mm.loader.i.b.bmz();
      ((c.a)localObject4).oKH = r.bKf();
      ((c.a)localObject4).fullPath = m.akH((String)localObject3);
      ((c.a)localObject4).oKp = true;
      ((c.a)localObject4).oKJ = true;
      ((c.a)localObject4).oKn = true;
      ((c.a)localObject4).oKB = a.c.wep;
      ((c.a)localObject4).npV = com.tencent.mm.cd.a.br(this.mContext, a.b.wdR);
      ((c.a)localObject4).npU = com.tencent.mm.cd.a.ms(this.mContext);
      localObject4 = ((c.a)localObject4).bKx();
      r.bKe().a((String)localObject3, paramView, (com.tencent.mm.modelimage.loader.a.c)localObject4);
      paramView.setImageMatrix(new Matrix());
      ((a)localObject1).wEI.setVisibility(8);
      break label1304;
      label1954:
      ((a)localObject1).wEI.setVisibility(8);
      ((a)localObject1).wEG.setVisibility(8);
      ((a)localObject1).wEH.setVisibility(8);
      ((a)localObject1).wyC.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.c.wep));
      ((a)localObject1).wyF.setTextColor(this.mContext.getResources().getColor(a.a.wdC));
      ((a)localObject1).wyE.setTextColor(this.mContext.getResources().getColor(a.a.wdC));
      break;
      label2050:
      if ((paramb.djO().equals("PRIVATE_TICKET_TITLE")) || (paramb.djO().equals("PRIVATE_INVOICE_TITLE")) || (paramb.dju())) {
        break;
      }
      ((a)localObject1).wyD.setVisibility(8);
      ((a)localObject1).wyF.setVisibility(8);
      ((a)localObject1).wyE.setVisibility(8);
      ((a)localObject1).wEF.setVisibility(8);
      ((a)localObject1).wyI.setVisibility(0);
      paramView = l.gx(this.mContext.getResources().getColor(a.a.wdG), this.wED);
      ((a)localObject1).wyC.setBackgroundDrawable(paramView);
      ((a)localObject1).wyI.setText(this.mContext.getResources().getString(a.g.card_not_support_card_type));
      break;
      label2190:
      paramView = (LinearLayout.LayoutParams)((a)localObject1).wyC.getLayoutParams();
      if (paramView.bottomMargin == 0) {
        break label320;
      }
      paramView.bottomMargin = 0;
      ((a)localObject1).wyC.setLayoutParams(paramView);
      break label320;
      label2226:
      i = 0;
      paramView = (View)localObject3;
    }
  }
  
  public final void a(View paramView, int paramInt, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(113726);
    CardInfo localCardInfo = (CardInfo)this.wyr.getItem(paramInt);
    if ((localCardInfo.field_card_id.equals("PRIVATE_TICKET_TITLE")) || (localCardInfo.field_card_id.equals("PRIVATE_INVOICE_TITLE")))
    {
      AppMethodBeat.o(113726);
      return;
    }
    paramView = (a)paramView.getTag();
    paramView.wEE.setTag(Integer.valueOf(paramInt));
    paramView.wEE.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(113726);
  }
  
  public final void af(View paramView, int paramInt)
  {
    AppMethodBeat.i(113724);
    ((l.a)paramView.getTag()).wEE.setImageResource(paramInt);
    AppMethodBeat.o(113724);
  }
  
  public final void ag(View paramView, int paramInt)
  {
    AppMethodBeat.i(113725);
    ((l.a)paramView.getTag()).wEE.setVisibility(paramInt);
    AppMethodBeat.o(113725);
  }
  
  public final void release()
  {
    AppMethodBeat.i(113722);
    this.mContext = null;
    this.wyr = null;
    if (this.wyy != null) {
      this.wyy.clear();
    }
    AppMethodBeat.o(113722);
  }
  
  public final class a
  {
    public View wDO;
    public ImageView wDP;
    public ImageView wEE;
    public LinearLayout wEF;
    public ImageView wEG;
    public ImageView wEH;
    public ImageView wEI;
    public TextView wKd;
    public TextView wKe;
    public TextView wKf;
    public TextView wKg;
    public TextView wKh;
    public RelativeLayout wyC;
    public ImageView wyD;
    public TextView wyE;
    public TextView wyF;
    public TextView wyI;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.aa
 * JD-Core Version:    0.7.0.1
 */