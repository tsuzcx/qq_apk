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
import com.tencent.mm.protocal.protobuf.st;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

public final class l
  implements com.tencent.mm.plugin.card.base.c
{
  int kl;
  private Context mContext;
  private BaseAdapter oKk;
  private int oKo;
  protected LinkedList<CardTagTextView> oKs;
  private int oQv;
  int oQw;
  
  public l(Context paramContext, BaseAdapter paramBaseAdapter)
  {
    AppMethodBeat.i(113592);
    this.oKs = new LinkedList();
    this.mContext = paramContext;
    this.oKk = paramBaseAdapter;
    this.oQv = this.mContext.getResources().getDimensionPixelSize(2131165575);
    this.oKo = this.mContext.getResources().getDimensionPixelSize(2131165500);
    this.oQw = this.mContext.getResources().getDimensionPixelOffset(2131165970);
    this.kl = this.mContext.getResources().getDimensionPixelOffset(2131165971);
    AppMethodBeat.o(113592);
  }
  
  public final void Z(View paramView, int paramInt)
  {
    AppMethodBeat.i(113595);
    ((a)paramView.getTag()).oQx.setImageResource(paramInt);
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
      if (paramb.bVg().equals("PRIVATE_TICKET_TITLE"))
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
        ((a)localObject1).oKw = ((RelativeLayout)paramView.findViewById(2131297771));
        ((a)localObject1).oKx = ((ImageView)paramView.findViewById(2131297828));
        ((a)localObject1).oPH = paramView.findViewById(2131297917);
        ((a)localObject1).oPI = ((ImageView)paramView.findViewById(2131297916));
        ((a)localObject1).oKy = ((TextView)paramView.findViewById(2131297743));
        ((a)localObject1).oKz = ((TextView)paramView.findViewById(2131297863));
        ((a)localObject1).oKC = ((TextView)paramView.findViewById(2131297864));
        ((a)localObject1).oQx = ((ImageView)paramView.findViewById(2131297730));
        ((a)localObject1).oQz = ((ImageView)paramView.findViewById(2131297737));
        ((a)localObject1).oQA = ((ImageView)paramView.findViewById(2131297739));
        ((a)localObject1).oQB = ((ImageView)paramView.findViewById(2131297738));
        ((a)localObject1).oQy = ((LinearLayout)paramView.findViewById(2131297887));
        paramView.setTag(localObject1);
        localObject2 = paramView;
        if (((a)localObject1).oKz != null)
        {
          float f = this.mContext.getResources().getDimension(2131165199);
          ((a)localObject1).oKz.setTextSize(0, f);
        }
        if (!(this.oKk.getItem(paramInt) instanceof CardInfo)) {
          break label696;
        }
        localObject4 = (CardInfo)this.oKk.getItem(paramInt);
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
          if (i < ((a)localObject1).oQy.getChildCount())
          {
            localObject3 = (CardTagTextView)((a)localObject1).oQy.getChildAt(i);
            this.oKs.add(localObject3);
            i += 1;
            continue;
            if (paramb.bVg().equals("PRIVATE_INVOICE_TITLE"))
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
            if (bu.isNullOrNil(((CardInfo)localObject4).field_label_wording)) {
              break label1644;
            }
            i = 1;
            paramView = ((CardInfo)localObject4).field_label_wording;
            break label356;
          }
        }
        ((a)localObject1).oQy.removeAllViews();
        ((a)localObject1).oQy.setVisibility(0);
        if (this.oKs.size() == 0)
        {
          localObject3 = new CardTagTextView(this.mContext);
          ((CardTagTextView)localObject3).setPadding(this.oKo, this.oQv, this.oKo, this.oQv);
          ((CardTagTextView)localObject3).setGravity(17);
          ((CardTagTextView)localObject3).setMinWidth(this.mContext.getResources().getDimensionPixelSize(2131165976));
          ((CardTagTextView)localObject3).setMinHeight(this.mContext.getResources().getDimensionPixelSize(2131165975));
          if (!((CardInfo)localObject4).bUJ()) {
            break label1103;
          }
          ((CardTagTextView)localObject3).setTextColor(com.tencent.mm.cb.a.n(this.mContext, 2131101182));
          ((CardTagTextView)localObject3).setFillColor(com.tencent.mm.cb.a.n(this.mContext, 2131100107));
          label671:
          ((CardTagTextView)localObject3).setText(paramView);
          ((CardTagTextView)localObject3).setTextSize(1, 10.0F);
          ((a)localObject1).oQy.addView((View)localObject3);
          label696:
          if (!paramb.bUO()) {
            break label1505;
          }
          ((a)localObject1).oKx.setVisibility(0);
          ((a)localObject1).oKz.setVisibility(0);
          ((a)localObject1).oKC.setVisibility(8);
          ((a)localObject1).oKy.setVisibility(0);
          ((a)localObject1).oKy.setText(paramb.bVc().oFG);
          ((a)localObject1).oKz.setText(paramb.bVc().title);
          if (!paramb.bUL()) {
            break label1162;
          }
          ((a)localObject1).oPH.setVisibility(0);
          ((a)localObject1).oKx.setVisibility(4);
          paramView = ((a)localObject1).oPI;
          if (TextUtils.isEmpty(paramb.bVc().Gkf)) {
            break label1140;
          }
          i = this.mContext.getResources().getDimensionPixelSize(2131165979);
          n.a(this.mContext, paramView, paramb.bVc().Gkf, i, com.tencent.mm.plugin.card.d.l.ZY(paramb.bVc().hDr));
          label870:
          if (!paramb.bUJ()) {
            break label1409;
          }
          if (!bu.isNullOrNil(paramb.bVd().GhZ)) {
            break label1222;
          }
          paramView = com.tencent.mm.plugin.card.d.l.eV(com.tencent.mm.plugin.card.d.l.ZY(paramb.bVc().hDr), this.oQw);
          ((a)localObject1).oKw.setBackgroundDrawable(paramView);
          ((a)localObject1).oQz.setVisibility(8);
          ((a)localObject1).oQA.setVisibility(8);
          ((a)localObject1).oQB.setVisibility(0);
          label952:
          ((a)localObject1).oKy.setTextColor(this.mContext.getResources().getColor(2131101182));
          ((a)localObject1).oKz.setTextColor(this.mContext.getResources().getColor(2131101182));
          label994:
          paramb.bVc();
          if ((paramInt != this.oKk.getCount() - 1) || (((a)localObject1).oKw == null)) {
            break label1608;
          }
          paramView = (LinearLayout.LayoutParams)((a)localObject1).oKw.getLayoutParams();
          if (paramView.bottomMargin != this.mContext.getResources().getDimensionPixelOffset(2131165490))
          {
            paramView.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131165490);
            ((a)localObject1).oKw.setLayoutParams(paramView);
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(113594);
        return localObject2;
        localObject3 = (CardTagTextView)this.oKs.removeFirst();
        break;
        label1103:
        ((CardTagTextView)localObject3).setTextColor(com.tencent.mm.cb.a.n(this.mContext, 2131100547));
        ((CardTagTextView)localObject3).setFillColor(0);
        break label671;
        ((a)localObject1).oQy.setVisibility(8);
        break label696;
        label1140:
        n.b(paramView, 2131231506, com.tencent.mm.plugin.card.d.l.ZY(paramb.bVc().hDr));
        break label870;
        label1162:
        ((a)localObject1).oPH.setVisibility(8);
        ((a)localObject1).oKx.setVisibility(0);
        i = this.mContext.getResources().getDimensionPixelSize(2131165979);
        n.a(((a)localObject1).oKx, paramb.bVc().hCp, i, 2131233400, true);
        break label870;
        label1222:
        ((a)localObject1).oKw.setBackgroundDrawable(this.mContext.getResources().getDrawable(2131231461));
        ((a)localObject1).oQz.setVisibility(0);
        ((a)localObject1).oQA.setVisibility(0);
        paramView = ((a)localObject1).oQz;
        localObject3 = paramb.bVd().GhZ;
        localObject4 = new c.a();
        ((c.a)localObject4).prefixPath = com.tencent.mm.loader.j.b.asj();
        q.aJc();
        ((c.a)localObject4).igB = null;
        ((c.a)localObject4).hgD = m.Zk((String)localObject3);
        ((c.a)localObject4).igk = true;
        ((c.a)localObject4).igD = true;
        ((c.a)localObject4).igi = true;
        ((c.a)localObject4).igv = 2131231461;
        ((c.a)localObject4).hgG = com.tencent.mm.cb.a.ax(this.mContext, 2131165971);
        ((c.a)localObject4).hgF = com.tencent.mm.cb.a.iu(this.mContext);
        localObject4 = ((c.a)localObject4).aJu();
        q.aJb().a((String)localObject3, paramView, (com.tencent.mm.av.a.a.c)localObject4);
        paramView.setImageMatrix(new Matrix());
        ((a)localObject1).oQB.setVisibility(8);
        break label952;
        label1409:
        ((a)localObject1).oQB.setVisibility(8);
        ((a)localObject1).oQz.setVisibility(8);
        ((a)localObject1).oQA.setVisibility(8);
        ((a)localObject1).oKw.setBackgroundDrawable(this.mContext.getResources().getDrawable(2131231461));
        ((a)localObject1).oKz.setTextColor(this.mContext.getResources().getColor(2131100711));
        ((a)localObject1).oKy.setTextColor(this.mContext.getResources().getColor(2131100711));
        break label994;
        label1505:
        ((a)localObject1).oKx.setVisibility(8);
        ((a)localObject1).oKz.setVisibility(8);
        ((a)localObject1).oKy.setVisibility(8);
        ((a)localObject1).oQy.setVisibility(8);
        ((a)localObject1).oKC.setVisibility(0);
        paramView = com.tencent.mm.plugin.card.d.l.eV(this.mContext.getResources().getColor(2131100106), this.oQw);
        ((a)localObject1).oKw.setBackgroundDrawable(paramView);
        ((a)localObject1).oKC.setText(this.mContext.getResources().getString(2131756947));
        break label994;
        label1608:
        paramView = (LinearLayout.LayoutParams)((a)localObject1).oKw.getLayoutParams();
        if (paramView.bottomMargin != 0)
        {
          paramView.bottomMargin = 0;
          ((a)localObject1).oKw.setLayoutParams(paramView);
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
    paramView.oQx.setTag(Integer.valueOf(paramInt));
    paramView.oQx.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(113597);
  }
  
  public final void aa(View paramView, int paramInt)
  {
    AppMethodBeat.i(113596);
    ((a)paramView.getTag()).oQx.setVisibility(paramInt);
    AppMethodBeat.o(113596);
  }
  
  public final void release()
  {
    AppMethodBeat.i(113593);
    this.mContext = null;
    this.oKk = null;
    if (this.oKs != null) {
      this.oKs.clear();
    }
    AppMethodBeat.o(113593);
  }
  
  public final class a
  {
    public TextView oKC;
    public RelativeLayout oKw;
    public ImageView oKx;
    public TextView oKy;
    public TextView oKz;
    public View oPH;
    public ImageView oPI;
    public ImageView oQA;
    public ImageView oQB;
    public ImageView oQx;
    public LinearLayout oQy;
    public ImageView oQz;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.l
 * JD-Core Version:    0.7.0.1
 */