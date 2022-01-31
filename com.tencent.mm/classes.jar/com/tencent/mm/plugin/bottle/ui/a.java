package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.be.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.p.a;

final class a
  extends com.tencent.mm.ui.p<ak>
  implements n.b
{
  private final MMActivity cmc;
  protected MMSlideDelView.g jSb;
  protected MMSlideDelView.c jSc;
  protected MMSlideDelView.f jSd;
  protected MMSlideDelView.d jSe;
  
  public a(Context paramContext, p.a parama)
  {
    super(paramContext, new ak());
    AppMethodBeat.i(18545);
    this.jSe = MMSlideDelView.getItemStatusCallBack();
    super.a(parama);
    this.cmc = ((MMActivity)paramContext);
    AppMethodBeat.o(18545);
  }
  
  private static int GH(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(18550);
    int i = j;
    if (paramString != null)
    {
      i = j;
      if (paramString.length() <= 0) {}
    }
    try
    {
      i = Integer.valueOf(paramString).intValue();
      AppMethodBeat.o(18550);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  final String E(ad paramad)
  {
    AppMethodBeat.i(18549);
    paramad = com.tencent.mm.plugin.bottle.a.c.a(this.cmc, paramad);
    AppMethodBeat.o(18549);
    return paramad;
  }
  
  public final void Ku()
  {
    AppMethodBeat.i(18546);
    aw.aaz();
    setCursor(com.tencent.mm.model.c.YF().dxj());
    if (this.zaq != null) {
      this.zaq.apT();
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(18546);
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(18551);
    Ku();
    AppMethodBeat.o(18551);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.jSd = paramf;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(18548);
    ak localak = (ak)getItem(paramInt);
    Object localObject;
    label259:
    label478:
    label499:
    int i;
    int j;
    int k;
    if (paramView == null)
    {
      paramViewGroup = new a.a();
      paramView = (MMSlideDelView)View.inflate(this.cmc, 2130968837, null);
      localObject = View.inflate(this.cmc, 2130971001, null);
      paramViewGroup.egq = ((ImageView)((View)localObject).findViewById(2131821210));
      paramViewGroup.egr = ((TextView)((View)localObject).findViewById(2131823254));
      paramViewGroup.jSg = ((TextView)((View)localObject).findViewById(2131823255));
      paramViewGroup.jSh = ((TextView)((View)localObject).findViewById(2131823256));
      paramViewGroup.jfv = ((ImageView)((View)localObject).findViewById(2131828503));
      paramViewGroup.jSi = ((TextView)((View)localObject).findViewById(2131821087));
      paramViewGroup.jSj = paramView.findViewById(2131821742);
      paramViewGroup.jSk = ((TextView)paramView.findViewById(2131821102));
      paramView.setView((View)localObject);
      paramView.setPerformItemClickListener(this.jSb);
      paramView.setGetViewPositionCallback(this.jSc);
      paramView.setItemStatusCallBack(this.jSe);
      paramView.setEnable(false);
      paramView.setTag(paramViewGroup);
      aw.aaz();
      localObject = com.tencent.mm.model.c.YA().arw(localak.field_username);
      paramViewGroup.egr.setText(E((ad)localObject));
      TextView localTextView = paramViewGroup.jSg;
      if (localak.field_status != 1) {
        break label623;
      }
      localObject = this.cmc.getString(2131301428);
      localTextView.setText((CharSequence)localObject);
      a.b.c(paramViewGroup.egq, ad.ark(localak.field_username));
      aw.aaz();
      localObject = com.tencent.mm.model.c.YF().BX().a(localak.field_isSend, localak.field_username, localak.field_content, GH(localak.field_msgType), this.cmc);
      paramViewGroup.jSh.setText(j.b(this.cmc, (CharSequence)localObject, paramViewGroup.jSh.getTextSize()));
      paramViewGroup.jSh.setTextColor(com.tencent.mm.cb.a.l(this.cmc, 2131690772));
      if ((GH(localak.field_msgType) == 34) && (localak.field_isSend == 0) && (!bo.isNullOrNil(localak.field_content)) && (!new com.tencent.mm.modelvoice.p(localak.field_content).fXr)) {
        paramViewGroup.jSh.setTextColor(com.tencent.mm.cb.a.l(this.cmc, 2131690773));
      }
      switch (localak.field_status)
      {
      case 3: 
      case 4: 
      default: 
        paramInt = -1;
        if (paramInt != -1)
        {
          paramViewGroup.jfv.setBackgroundResource(paramInt);
          paramViewGroup.jfv.setVisibility(0);
          paramViewGroup.jSj.setTag(localak.field_username);
          paramViewGroup.jSj.setOnClickListener(new a.1(this));
          paramInt = paramView.getPaddingBottom();
          i = paramView.getPaddingTop();
          j = paramView.getPaddingRight();
          k = paramView.getPaddingLeft();
          if (localak.field_unReadCount <= 100) {
            break label677;
          }
          paramViewGroup.jSi.setText("...");
          paramViewGroup.jSi.setVisibility(0);
          ab.v("MicroMsg.BottleConversationAdapter", "has unread 100");
        }
        break;
      }
    }
    for (;;)
    {
      paramView.setBackgroundResource(2130840969);
      paramView.setPadding(k, i, j, paramInt);
      AppMethodBeat.o(18548);
      return paramView;
      paramViewGroup = (a.a)paramView.getTag();
      break;
      label623:
      localObject = h.c(this.cmc, localak.field_conversationTime, true);
      break label259;
      paramInt = -1;
      break label478;
      paramInt = 2131231716;
      break label478;
      paramInt = -1;
      break label478;
      paramInt = 2131231715;
      break label478;
      paramViewGroup.jfv.setVisibility(8);
      break label499;
      label677:
      if (localak.field_unReadCount > 0)
      {
        paramViewGroup.jSi.setText(localak.field_unReadCount);
        paramViewGroup.jSi.setVisibility(0);
        ab.v("MicroMsg.BottleConversationAdapter", "has unread");
      }
      else
      {
        paramViewGroup.jSi.setVisibility(4);
        ab.v("MicroMsg.BottleConversationAdapter", "no unread");
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return 1;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(18547);
    if (this.jSe != null) {
      this.jSe.bKk();
    }
    AppMethodBeat.o(18547);
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.jSc = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.jSb = paramg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.a
 * JD-Core Version:    0.7.0.1
 */