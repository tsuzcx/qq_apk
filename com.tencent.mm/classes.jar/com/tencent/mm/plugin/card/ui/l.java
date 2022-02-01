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
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.c.j;
import com.tencent.mm.plugin.card.c.n;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.protocal.protobuf.vr;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class l
  implements com.tencent.mm.plugin.card.base.c
{
  int dpX;
  private Context mContext;
  private int wEC;
  int wED;
  private BaseAdapter wyr;
  private int wyu;
  protected LinkedList<CardTagTextView> wyy;
  
  public l(Context paramContext, BaseAdapter paramBaseAdapter)
  {
    AppMethodBeat.i(113592);
    this.wyy = new LinkedList();
    this.mContext = paramContext;
    this.wyr = paramBaseAdapter;
    this.wEC = this.mContext.getResources().getDimensionPixelSize(a.b.SmallestPadding);
    this.wyu = this.mContext.getResources().getDimensionPixelSize(a.b.MiddlePadding);
    this.wED = this.mContext.getResources().getDimensionPixelOffset(a.b.wdQ);
    this.dpX = this.mContext.getResources().getDimensionPixelOffset(a.b.wdR);
    AppMethodBeat.o(113592);
  }
  
  public final View a(int paramInt, View paramView, com.tencent.mm.plugin.card.base.b paramb)
  {
    Object localObject3 = null;
    AppMethodBeat.i(113594);
    Object localObject1;
    Object localObject2;
    label274:
    Object localObject4;
    int i;
    if (paramView == null) {
      if (paramb.djO().equals("PRIVATE_TICKET_TITLE"))
      {
        localObject1 = View.inflate(this.mContext, a.e.wnl, null);
        localObject2 = (TextView)((View)localObject1).findViewById(a.d.wgT);
        paramView = (View)localObject1;
        if (localObject2 != null)
        {
          ((TextView)localObject2).setText(this.mContext.getString(a.g.wqC));
          paramView = (View)localObject1;
        }
        localObject1 = new a();
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
        paramView.setTag(localObject1);
        localObject2 = paramView;
        if (((a)localObject1).wyF != null)
        {
          float f = this.mContext.getResources().getDimension(a.b.BiggerTextSize);
          ((a)localObject1).wyF.setTextSize(0, f);
        }
        if (!(this.wyr.getItem(paramInt) instanceof CardInfo)) {
          break label717;
        }
        localObject4 = (CardInfo)this.wyr.getItem(paramInt);
        if (((CardInfo)localObject4).field_stickyIndex % 10 == 0) {
          break label527;
        }
        if (((CardInfo)localObject4).field_stickyIndex <= 0) {
          break label1667;
        }
        paramView = j.a(this.mContext, ((CardInfo)localObject4).field_stickyIndex, (CardInfo)localObject4);
        i = 1;
      }
    }
    for (;;)
    {
      label372:
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
            if (paramb.djO().equals("PRIVATE_INVOICE_TITLE"))
            {
              localObject1 = View.inflate(this.mContext, a.e.wnl, null);
              localObject2 = (TextView)((View)localObject1).findViewById(a.d.wgT);
              paramView = (View)localObject1;
              if (localObject2 == null) {
                break;
              }
              ((TextView)localObject2).setText(this.mContext.getString(a.g.wpe));
              paramView = (View)localObject1;
              break;
            }
            paramView = View.inflate(this.mContext, a.e.wnj, null);
            break;
            localObject1 = (a)paramView.getTag();
            localObject2 = paramView;
            break label274;
            if (Util.isNullOrNil(((CardInfo)localObject4).field_label_wording)) {
              break label1667;
            }
            paramView = ((CardInfo)localObject4).field_label_wording;
            i = 1;
            break label372;
          }
        }
        ((a)localObject1).wEF.removeAllViews();
        ((a)localObject1).wEF.setVisibility(0);
        if (this.wyy.size() == 0)
        {
          localObject3 = new CardTagTextView(this.mContext);
          ((CardTagTextView)localObject3).setPadding(this.wyu, this.wEC, this.wyu, this.wEC);
          ((CardTagTextView)localObject3).setGravity(17);
          ((CardTagTextView)localObject3).setMinWidth(this.mContext.getResources().getDimensionPixelSize(a.b.wdT));
          ((CardTagTextView)localObject3).setMinHeight(this.mContext.getResources().getDimensionPixelSize(a.b.wdS));
          if (!((CardInfo)localObject4).djq()) {
            break label1127;
          }
          ((CardTagTextView)localObject3).setTextColor(com.tencent.mm.cd.a.w(this.mContext, a.a.white_text_color));
          ((CardTagTextView)localObject3).setFillColor(com.tencent.mm.cd.a.w(this.mContext, a.a.wdH));
          ((CardTagTextView)localObject3).setText(paramView);
          ((CardTagTextView)localObject3).setTextSize(1, 10.0F);
          ((a)localObject1).wEF.addView((View)localObject3);
          if (!paramb.djv()) {
            break label1528;
          }
          ((a)localObject1).wyD.setVisibility(0);
          ((a)localObject1).wyF.setVisibility(0);
          ((a)localObject1).wyI.setVisibility(8);
          ((a)localObject1).wyE.setVisibility(0);
          ((a)localObject1).wyE.setText(paramb.djK().mee);
          ((a)localObject1).wyF.setText(paramb.djK().title);
          if (!paramb.djs()) {
            break label1186;
          }
          ((a)localObject1).wDO.setVisibility(0);
          ((a)localObject1).wyD.setVisibility(4);
          paramView = ((a)localObject1).wDP;
          if (TextUtils.isEmpty(paramb.djK().ZdR)) {
            break label1164;
          }
          i = this.mContext.getResources().getDimensionPixelSize(a.b.wdU);
          n.a(this.mContext, paramView, paramb.djK().ZdR, i, a.c.wev, com.tencent.mm.plugin.card.c.l.alv(paramb.djK().nRQ));
          label894:
          if (!paramb.djq()) {
            break label1432;
          }
          if (!Util.isNullOrNil(paramb.djL().ZbJ)) {
            break label1246;
          }
          paramView = com.tencent.mm.plugin.card.c.l.gx(com.tencent.mm.plugin.card.c.l.alv(paramb.djK().nRQ), this.wED);
          ((a)localObject1).wyC.setBackgroundDrawable(paramView);
          ((a)localObject1).wEG.setVisibility(8);
          ((a)localObject1).wEH.setVisibility(8);
          ((a)localObject1).wEI.setVisibility(0);
          ((a)localObject1).wyE.setTextColor(this.mContext.getResources().getColor(a.a.white_text_color));
          ((a)localObject1).wyF.setTextColor(this.mContext.getResources().getColor(a.a.white_text_color));
          label1018:
          paramb.djK();
          if ((paramInt != this.wyr.getCount() - 1) || (((a)localObject1).wyC == null)) {
            break label1631;
          }
          paramView = (LinearLayout.LayoutParams)((a)localObject1).wyC.getLayoutParams();
          if (paramView.bottomMargin != this.mContext.getResources().getDimensionPixelOffset(a.b.LittlePadding))
          {
            paramView.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(a.b.LittlePadding);
            ((a)localObject1).wyC.setLayoutParams(paramView);
          }
        }
      }
      for (;;)
      {
        label527:
        label692:
        label717:
        label976:
        AppMethodBeat.o(113594);
        return localObject2;
        localObject3 = (CardTagTextView)this.wyy.removeFirst();
        break;
        label1127:
        ((CardTagTextView)localObject3).setTextColor(com.tencent.mm.cd.a.w(this.mContext, a.a.link_color));
        ((CardTagTextView)localObject3).setFillColor(0);
        break label692;
        ((a)localObject1).wEF.setVisibility(8);
        break label717;
        label1164:
        n.b(paramView, a.c.wev, com.tencent.mm.plugin.card.c.l.alv(paramb.djK().nRQ));
        break label894;
        label1186:
        ((a)localObject1).wDO.setVisibility(8);
        ((a)localObject1).wyD.setVisibility(0);
        i = this.mContext.getResources().getDimensionPixelSize(a.b.wdU);
        n.a(((a)localObject1).wyD, paramb.djK().nQG, i, a.c.my_card_package_defaultlogo, true);
        break label894;
        label1246:
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
        break label976;
        label1432:
        ((a)localObject1).wEI.setVisibility(8);
        ((a)localObject1).wEG.setVisibility(8);
        ((a)localObject1).wEH.setVisibility(8);
        ((a)localObject1).wyC.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.c.wep));
        ((a)localObject1).wyF.setTextColor(this.mContext.getResources().getColor(a.a.normal_text_color));
        ((a)localObject1).wyE.setTextColor(this.mContext.getResources().getColor(a.a.normal_text_color));
        break label1018;
        label1528:
        ((a)localObject1).wyD.setVisibility(8);
        ((a)localObject1).wyF.setVisibility(8);
        ((a)localObject1).wyE.setVisibility(8);
        ((a)localObject1).wEF.setVisibility(8);
        ((a)localObject1).wyI.setVisibility(0);
        paramView = com.tencent.mm.plugin.card.c.l.gx(this.mContext.getResources().getColor(a.a.wdG), this.wED);
        ((a)localObject1).wyC.setBackgroundDrawable(paramView);
        ((a)localObject1).wyI.setText(this.mContext.getResources().getString(a.g.card_not_support_card_type));
        break label1018;
        label1631:
        paramView = (LinearLayout.LayoutParams)((a)localObject1).wyC.getLayoutParams();
        if (paramView.bottomMargin != 0)
        {
          paramView.bottomMargin = 0;
          ((a)localObject1).wyC.setLayoutParams(paramView);
        }
      }
      label1667:
      i = 0;
      paramView = (View)localObject3;
    }
  }
  
  public final void a(View paramView, int paramInt, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(113597);
    paramView = (a)paramView.getTag();
    paramView.wEE.setTag(Integer.valueOf(paramInt));
    paramView.wEE.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(113597);
  }
  
  public final void af(View paramView, int paramInt)
  {
    AppMethodBeat.i(113595);
    ((a)paramView.getTag()).wEE.setImageResource(paramInt);
    AppMethodBeat.o(113595);
  }
  
  public final void ag(View paramView, int paramInt)
  {
    AppMethodBeat.i(113596);
    ((a)paramView.getTag()).wEE.setVisibility(paramInt);
    AppMethodBeat.o(113596);
  }
  
  public final void release()
  {
    AppMethodBeat.i(113593);
    this.mContext = null;
    this.wyr = null;
    if (this.wyy != null) {
      this.wyy.clear();
    }
    AppMethodBeat.o(113593);
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
    public RelativeLayout wyC;
    public ImageView wyD;
    public TextView wyE;
    public TextView wyF;
    public TextView wyI;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.l
 * JD-Core Version:    0.7.0.1
 */