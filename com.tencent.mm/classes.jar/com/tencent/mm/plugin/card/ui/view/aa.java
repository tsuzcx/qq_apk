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
import com.tencent.mm.protocal.protobuf.aai;
import com.tencent.mm.protocal.protobuf.st;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

public final class aa
  implements com.tencent.mm.plugin.card.base.c
{
  int kl;
  private Context mContext;
  private BaseAdapter oKk;
  private int oKo;
  protected LinkedList<CardTagTextView> oKs;
  private int oQv;
  int oQw;
  
  public aa(Context paramContext, BaseAdapter paramBaseAdapter)
  {
    AppMethodBeat.i(113721);
    this.oKs = new LinkedList();
    this.mContext = paramContext;
    this.oKk = paramBaseAdapter;
    this.oQv = this.mContext.getResources().getDimensionPixelSize(2131165575);
    this.oKo = this.mContext.getResources().getDimensionPixelSize(2131165500);
    this.oQw = this.mContext.getResources().getDimensionPixelOffset(2131165970);
    this.kl = this.mContext.getResources().getDimensionPixelOffset(2131165971);
    AppMethodBeat.o(113721);
  }
  
  public final void Z(View paramView, int paramInt)
  {
    AppMethodBeat.i(113724);
    ((l.a)paramView.getTag()).oQx.setImageResource(paramInt);
    AppMethodBeat.o(113724);
  }
  
  public final View a(int paramInt, View paramView, com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113723);
    Object localObject1;
    label107:
    Object localObject2;
    if (paramView == null) {
      switch (this.oKk.getItemViewType(paramInt))
      {
      default: 
        paramView = View.inflate(this.mContext, 2131493313, null);
        localObject1 = new a();
        if ((paramb.bVg().equals("PRIVATE_TICKET_TITLE")) || (paramb.bVg().equals("PRIVATE_INVOICE_TITLE")))
        {
          ((a)localObject1).oVO = ((TextView)paramView.findViewById(2131297843));
          paramView.setTag(localObject1);
          localObject2 = paramView;
          label116:
          if (((a)localObject1).oKz != null)
          {
            float f = this.mContext.getResources().getDimension(2131165199);
            ((a)localObject1).oKz.setTextSize(0, f);
          }
          if (!paramb.bUO()) {
            break label2015;
          }
          if (!paramb.bVg().equals("PRIVATE_TICKET_TITLE")) {
            break label782;
          }
          ((a)localObject1).oVO.setText(this.mContext.getString(2131757018));
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
      if ((!paramb.bVg().equals("PRIVATE_TICKET_TITLE")) && (!paramb.bVg().equals("PRIVATE_INVOICE_TITLE")) && (!paramb.bUN()))
      {
        paramb.bVc();
        if ((paramInt != this.oKk.getCount() - 1) || (((a)localObject1).oKw == null)) {
          break label2155;
        }
        paramView = (LinearLayout.LayoutParams)((a)localObject1).oKw.getLayoutParams();
        if (paramView.bottomMargin != this.mContext.getResources().getDimensionPixelOffset(2131165490))
        {
          paramView.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131165490);
          ((a)localObject1).oKw.setLayoutParams(paramView);
        }
      }
      AppMethodBeat.o(113723);
      return localObject2;
      localObject1 = View.inflate(this.mContext, 2131493315, null);
      if (paramb.bVg().equals("PRIVATE_TICKET_TITLE"))
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
      if (!paramb.bVg().equals("PRIVATE_INVOICE_TITLE")) {
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
      if (paramb.bUN())
      {
        ((a)localObject1).oVP = ((TextView)paramView.findViewById(2131297850));
        ((a)localObject1).oVQ = ((TextView)paramView.findViewById(2131297846));
        ((a)localObject1).oVR = ((TextView)paramView.findViewById(2131297848));
        ((a)localObject1).oVS = ((TextView)paramView.findViewById(2131297849));
        break label107;
      }
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
      break label107;
      localObject1 = (a)paramView.getTag();
      if (((a)localObject1).oVO != null)
      {
        if (paramb.bVg().equals("PRIVATE_TICKET_TITLE"))
        {
          ((a)localObject1).oVO.setText(this.mContext.getString(2131757018));
          localObject2 = paramView;
          break label116;
        }
        ((a)localObject1).oVO.setText(this.mContext.getString(2131756903));
      }
      localObject2 = paramView;
      break label116;
      if (paramb.bVg().equals("PRIVATE_INVOICE_TITLE"))
      {
        ((a)localObject1).oVO.setText(this.mContext.getString(2131756903));
      }
      else if (paramb.bUN())
      {
        paramView = paramb.bVc().GjY;
        ((a)localObject1).oVP.setText(((aai)paramView.get(0)).oEp);
        ((a)localObject1).oVR.setText(((aai)paramView.get(1)).oEp);
        paramView = paramb.bVd().GhP;
        localObject3 = String.format(this.mContext.getString(2131756914), new Object[] { ((aai)paramView.get(0)).oEp });
        ((a)localObject1).oVS.setText((CharSequence)localObject3);
        if (paramView.size() >= 2) {
          ((a)localObject1).oVQ.setText(((aai)paramView.get(1)).oEp);
        }
      }
      else
      {
        if ((this.oKk.getItem(paramInt) instanceof CardInfo))
        {
          localObject4 = (CardInfo)this.oKk.getItem(paramInt);
          if ((!((CardInfo)localObject4).field_card_id.equals("PRIVATE_TICKET_TITLE")) && (!((CardInfo)localObject4).field_card_id.equals("PRIVATE_INVOICE_TITLE"))) {
            break label1310;
          }
        }
        label1009:
        ((a)localObject1).oKw.setVisibility(0);
        ((a)localObject1).oKx.setVisibility(0);
        ((a)localObject1).oKz.setVisibility(0);
        ((a)localObject1).oKC.setVisibility(8);
        ((a)localObject1).oKy.setVisibility(0);
        ((a)localObject1).oKy.setText(paramb.bVc().oFG);
        ((a)localObject1).oKz.setText(paramb.bVc().title);
        if (!paramb.bUL()) {
          break label1672;
        }
        ((a)localObject1).oPH.setVisibility(0);
        ((a)localObject1).oKx.setVisibility(4);
        paramView = ((a)localObject1).oPI;
        if (TextUtils.isEmpty(paramb.bVc().Gkf)) {
          break label1650;
        }
        i = this.mContext.getResources().getDimensionPixelSize(2131165979);
        n.a(this.mContext, paramView, paramb.bVc().Gkf, i, l.ZY(paramb.bVc().hDr));
        label1183:
        if (!paramb.bUJ()) {
          break label1919;
        }
        if (!bu.isNullOrNil(paramb.bVd().GhZ)) {
          break label1732;
        }
        paramView = l.eV(l.ZY(paramb.bVc().hDr), this.oQw);
        ((a)localObject1).oKw.setBackgroundDrawable(paramView);
        ((a)localObject1).oQz.setVisibility(8);
        ((a)localObject1).oQA.setVisibility(8);
        ((a)localObject1).oQB.setVisibility(0);
        label1265:
        ((a)localObject1).oKy.setTextColor(this.mContext.getResources().getColor(2131101182));
        ((a)localObject1).oKz.setTextColor(this.mContext.getResources().getColor(2131101182));
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
          if (i < ((a)localObject1).oQy.getChildCount())
          {
            localObject3 = (CardTagTextView)((a)localObject1).oQy.getChildAt(i);
            this.oKs.add(localObject3);
            i += 1;
            continue;
            if (bu.isNullOrNil(((CardInfo)localObject4).field_label_wording)) {
              break label2191;
            }
            i = 1;
            paramView = ((CardInfo)localObject4).field_label_wording;
            break;
          }
        }
        ((a)localObject1).oQy.removeAllViews();
        ((a)localObject1).oQy.setVisibility(0);
        if (this.oKs.size() == 0)
        {
          localObject3 = new CardTagTextView(this.mContext);
          label1468:
          ((CardTagTextView)localObject3).setPadding(this.oKo, this.oQv, this.oKo, this.oQv);
          ((CardTagTextView)localObject3).setGravity(17);
          ((CardTagTextView)localObject3).setMinWidth(this.mContext.getResources().getDimensionPixelSize(2131165976));
          ((CardTagTextView)localObject3).setMinHeight(this.mContext.getResources().getDimensionPixelSize(2131165975));
          if (!((CardInfo)localObject4).bUJ()) {
            break label1613;
          }
          ((CardTagTextView)localObject3).setTextColor(com.tencent.mm.cb.a.n(this.mContext, 2131101182));
          ((CardTagTextView)localObject3).setFillColor(com.tencent.mm.cb.a.n(this.mContext, 2131100107));
        }
        for (;;)
        {
          ((CardTagTextView)localObject3).setText(paramView);
          ((CardTagTextView)localObject3).setTextSize(1, 10.0F);
          ((a)localObject1).oQy.addView((View)localObject3);
          break;
          localObject3 = (CardTagTextView)this.oKs.removeFirst();
          break label1468;
          label1613:
          ((CardTagTextView)localObject3).setTextColor(com.tencent.mm.cb.a.n(this.mContext, 2131100547));
          ((CardTagTextView)localObject3).setFillColor(0);
        }
      }
      ((a)localObject1).oQy.setVisibility(8);
      break label1009;
      label1650:
      n.b(paramView, 2131231506, l.ZY(paramb.bVc().hDr));
      break label1183;
      label1672:
      ((a)localObject1).oPH.setVisibility(8);
      ((a)localObject1).oKx.setVisibility(0);
      i = this.mContext.getResources().getDimensionPixelSize(2131165979);
      n.a(((a)localObject1).oKx, paramb.bVc().hCp, i, 2131233400, true);
      break label1183;
      label1732:
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
      break label1265;
      label1919:
      ((a)localObject1).oQB.setVisibility(8);
      ((a)localObject1).oQz.setVisibility(8);
      ((a)localObject1).oQA.setVisibility(8);
      ((a)localObject1).oKw.setBackgroundDrawable(this.mContext.getResources().getDrawable(2131231461));
      ((a)localObject1).oKz.setTextColor(this.mContext.getResources().getColor(2131100085));
      ((a)localObject1).oKy.setTextColor(this.mContext.getResources().getColor(2131100085));
      break;
      label2015:
      if ((paramb.bVg().equals("PRIVATE_TICKET_TITLE")) || (paramb.bVg().equals("PRIVATE_INVOICE_TITLE")) || (paramb.bUN())) {
        break;
      }
      ((a)localObject1).oKx.setVisibility(8);
      ((a)localObject1).oKz.setVisibility(8);
      ((a)localObject1).oKy.setVisibility(8);
      ((a)localObject1).oQy.setVisibility(8);
      ((a)localObject1).oKC.setVisibility(0);
      paramView = l.eV(this.mContext.getResources().getColor(2131100106), this.oQw);
      ((a)localObject1).oKw.setBackgroundDrawable(paramView);
      ((a)localObject1).oKC.setText(this.mContext.getResources().getString(2131756947));
      break;
      label2155:
      paramView = (LinearLayout.LayoutParams)((a)localObject1).oKw.getLayoutParams();
      if (paramView.bottomMargin == 0) {
        break label310;
      }
      paramView.bottomMargin = 0;
      ((a)localObject1).oKw.setLayoutParams(paramView);
      break label310;
      label2191:
      paramView = null;
    }
  }
  
  public final void a(View paramView, int paramInt, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(113726);
    CardInfo localCardInfo = (CardInfo)this.oKk.getItem(paramInt);
    if ((localCardInfo.field_card_id.equals("PRIVATE_TICKET_TITLE")) || (localCardInfo.field_card_id.equals("PRIVATE_INVOICE_TITLE")))
    {
      AppMethodBeat.o(113726);
      return;
    }
    paramView = (a)paramView.getTag();
    paramView.oQx.setTag(Integer.valueOf(paramInt));
    paramView.oQx.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(113726);
  }
  
  public final void aa(View paramView, int paramInt)
  {
    AppMethodBeat.i(113725);
    ((l.a)paramView.getTag()).oQx.setVisibility(paramInt);
    AppMethodBeat.o(113725);
  }
  
  public final void release()
  {
    AppMethodBeat.i(113722);
    this.mContext = null;
    this.oKk = null;
    if (this.oKs != null) {
      this.oKs.clear();
    }
    AppMethodBeat.o(113722);
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
    public TextView oVO;
    public TextView oVP;
    public TextView oVQ;
    public TextView oVR;
    public TextView oVS;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.aa
 * JD-Core Version:    0.7.0.1
 */