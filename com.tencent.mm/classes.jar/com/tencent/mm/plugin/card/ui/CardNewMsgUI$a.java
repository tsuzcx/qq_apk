package com.tencent.mm.plugin.card.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.plugin.card.model.g.a;
import com.tencent.mm.plugin.card.model.g.b;
import com.tencent.mm.protocal.protobuf.oh;
import com.tencent.mm.protocal.protobuf.ov;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.p;
import java.util.List;

final class CardNewMsgUI$a
  extends p<g>
{
  private int eke;
  private int kxm;
  
  public CardNewMsgUI$a(CardNewMsgUI paramCardNewMsgUI)
  {
    super(paramCardNewMsgUI, new g());
    AppMethodBeat.i(88603);
    this.kxm = 10;
    this.eke = this.kxm;
    qp(true);
    AppMethodBeat.o(88603);
  }
  
  private void a(List<g.a> paramList, List<g.b> paramList1, CardNewMsgUI.b paramb, g paramg)
  {
    AppMethodBeat.i(88608);
    paramb.kxB.removeAllViews();
    if (((paramList == null) || (paramList.size() == 0)) && ((paramList1 == null) || (paramList1.size() == 0)))
    {
      paramb.kxC.setVisibility(8);
      AppMethodBeat.o(88608);
      return;
    }
    int i;
    Object localObject1;
    Object localObject2;
    if (!bo.es(paramList))
    {
      i = 0;
      if (i < paramList.size())
      {
        localObject1 = (g.a)paramList.get(i);
        localObject2 = View.inflate(this.kxl.getContext(), 2130968904, null);
        if (i == 0) {
          ((View)localObject2).findViewById(2131821964).setVisibility(8);
        }
        ((TextView)((View)localObject2).findViewById(2131821965)).setText(((g.a)localObject1).title);
        ((TextView)((View)localObject2).findViewById(2131821966)).setText(((g.a)localObject1).jjP);
        Button localButton = (Button)((View)localObject2).findViewById(2131821967);
        localButton.setOnClickListener(new CardNewMsgUI.a.1(this, (g.a)localObject1, paramg));
        if (((g.a)localObject1).knS == 0) {
          localButton.setText(2131297852);
        }
        for (;;)
        {
          paramb.kxB.addView((View)localObject2);
          i += 1;
          break;
          if (((g.a)localObject1).knS == 1) {
            localButton.setText(2131297853);
          }
        }
      }
    }
    if (!bo.es(paramList1))
    {
      i = 0;
      while (i < paramList1.size())
      {
        paramg = (g.b)paramList1.get(i);
        localObject1 = View.inflate(this.kxl.getContext(), 2130968904, null);
        if ((i == 0) && (bo.es(paramList))) {
          ((View)localObject1).findViewById(2131821964).setVisibility(8);
        }
        ((TextView)((View)localObject1).findViewById(2131821965)).setText(paramg.title);
        ((TextView)((View)localObject1).findViewById(2131821966)).setText(paramg.description);
        localObject2 = (Button)((View)localObject1).findViewById(2131821967);
        ((Button)localObject2).setOnClickListener(new CardNewMsgUI.a.2(this, paramg));
        ((Button)localObject2).setText(paramg.knU);
        paramb.kxB.addView((View)localObject1);
        i += 1;
      }
    }
    paramb.kxC.setVisibility(0);
    AppMethodBeat.o(88608);
  }
  
  public final void Ku()
  {
    AppMethodBeat.i(88604);
    if (am.bcf().bbZ() > 0) {
      setCursor(am.bcf().db.rawQuery("select * from CardMsgInfo where read_state = ?  order by time desc", new String[] { "1" }));
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(88604);
      return;
      this.eke = am.bcf().getCount();
      com.tencent.mm.plugin.card.model.h localh = am.bcf();
      String str = "select * from CardMsgInfo order by time desc LIMIT ".concat(String.valueOf(this.kxm));
      setCursor(localh.db.rawQuery(str, null));
    }
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(88605);
    bKb();
    Ku();
    AppMethodBeat.o(88605);
  }
  
  public final boolean bem()
  {
    return this.kxm >= this.eke;
  }
  
  public final int ben()
  {
    AppMethodBeat.i(88606);
    if (bem())
    {
      if (CardNewMsgUI.e(this.kxl).getParent() != null) {
        CardNewMsgUI.d(this.kxl).removeFooterView(CardNewMsgUI.e(this.kxl));
      }
      AppMethodBeat.o(88606);
      return 0;
    }
    this.kxm += 10;
    if (this.kxm <= this.eke)
    {
      AppMethodBeat.o(88606);
      return 10;
    }
    this.kxm = this.eke;
    int i = this.eke;
    AppMethodBeat.o(88606);
    return i % 10;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(88607);
    g localg = (g)getItem(paramInt);
    int i;
    if (paramView == null)
    {
      paramView = View.inflate(this.kxl.getContext(), 2130968972, null);
      paramViewGroup = new CardNewMsgUI.b(this.kxl, (byte)0);
      paramViewGroup.kxr = ((ImageView)paramView.findViewById(2131822294));
      paramViewGroup.kxs = paramView.findViewById(2131822267);
      paramViewGroup.kxt = ((ImageView)paramView.findViewById(2131822268));
      paramViewGroup.kxu = ((TextView)paramView.findViewById(2131821212));
      paramViewGroup.kxv = ((TextView)paramView.findViewById(2131821004));
      paramViewGroup.kxw = ((TextView)paramView.findViewById(2131822295));
      paramViewGroup.kxx = ((TextView)paramView.findViewById(2131822296));
      paramViewGroup.kxy = ((TextView)paramView.findViewById(2131822299));
      paramViewGroup.kxz = paramView.findViewById(2131822300);
      paramViewGroup.kxA = ((TextView)paramView.findViewById(2131822301));
      paramViewGroup.kxB = ((LinearLayout)paramView.findViewById(2131822298));
      paramViewGroup.kxC = ((LinearLayout)paramView.findViewById(2131822297));
      paramView.setTag(paramViewGroup);
      paramViewGroup.kxu.setText(localg.field_title);
      long l = localg.field_time;
      paramViewGroup.kxv.setText(com.tencent.mm.pluginsdk.f.h.c(this.kxl, l * 1000L, true));
      paramViewGroup.kxw.setText(localg.field_description);
      i = this.kxl.getResources().getDimensionPixelSize(2131428192);
      ab.d("MicroMsg.CardNewMsgUI", "CardNewMsgUI getView () position : " + paramInt + " logo_url :  " + localg.field_logo_url);
      if (!TextUtils.isEmpty(localg.field_logo_color)) {
        break label558;
      }
      paramViewGroup.kxs.setVisibility(8);
      paramViewGroup.kxr.setVisibility(0);
      paramViewGroup.kxr.setImageResource(2130839758);
      m.a(paramViewGroup.kxr, localg.field_logo_url, i, 2130839758, true);
      label373:
      Object localObject = localg.bbU();
      if ((localObject == null) || (TextUtils.isEmpty(((oh)localObject).text))) {
        break label673;
      }
      paramViewGroup.kxx.setText(((oh)localObject).text);
      paramViewGroup.kxx.setTag(localg);
      paramViewGroup.kxx.setVisibility(0);
      paramViewGroup.kxx.setOnClickListener(this.kxl.gMO);
      label439:
      localObject = localg.bbV();
      if ((localObject == null) || (TextUtils.isEmpty(((ov)localObject).text))) {
        break label685;
      }
      paramViewGroup.kxA.setText(((ov)localObject).text);
      paramViewGroup.kxz.setVisibility(0);
      paramViewGroup.kxz.setOnClickListener(this.kxl.gMO);
      paramViewGroup.kxz.setTag(localg);
      paramViewGroup.kxy.setVisibility(0);
    }
    for (;;)
    {
      localg.bbW();
      localg.bbX();
      a(localg.knL, localg.knM, paramViewGroup, localg);
      AppMethodBeat.o(88607);
      return paramView;
      paramViewGroup = (CardNewMsgUI.b)paramView.getTag();
      break;
      label558:
      ab.d("MicroMsg.CardNewMsgUI", "CardNewMsgUI getView () position : " + paramInt + " field_logo_color :  " + localg.field_logo_color);
      paramViewGroup.kxs.setVisibility(0);
      paramViewGroup.kxr.setVisibility(8);
      if (!TextUtils.isEmpty(localg.field_logo_url))
      {
        m.a(this.kxl, paramViewGroup.kxt, localg.field_logo_url, i, l.IB(localg.field_logo_color));
        break label373;
      }
      m.a(paramViewGroup.kxt, 2130838175, l.IB(localg.field_logo_color));
      break label373;
      label673:
      paramViewGroup.kxx.setVisibility(8);
      break label439;
      label685:
      paramViewGroup.kxz.setVisibility(8);
      paramViewGroup.kxy.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardNewMsgUI.a
 * JD-Core Version:    0.7.0.1
 */