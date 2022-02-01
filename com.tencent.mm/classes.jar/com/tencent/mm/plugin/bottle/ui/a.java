package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.model.az;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.pluginsdk.g.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bh.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.q.a;

final class a
  extends q<am>
  implements n.b
{
  private final MMActivity imP;
  protected MMSlideDelView.g mRk;
  protected MMSlideDelView.c mRl;
  protected MMSlideDelView.f mRm;
  protected MMSlideDelView.d mRn;
  
  public a(Context paramContext, q.a parama)
  {
    super(paramContext, new am());
    AppMethodBeat.i(22656);
    this.mRn = MMSlideDelView.getItemStatusCallBack();
    super.a(parama);
    this.imP = ((MMActivity)paramContext);
    AppMethodBeat.o(22656);
  }
  
  private static int OV(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(22661);
    int i = j;
    if (paramString != null)
    {
      i = j;
      if (paramString.length() <= 0) {}
    }
    try
    {
      i = Integer.valueOf(paramString).intValue();
      AppMethodBeat.o(22661);
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
  
  final String K(af paramaf)
  {
    AppMethodBeat.i(22660);
    paramaf = com.tencent.mm.plugin.bottle.a.c.a(this.imP, paramaf);
    AppMethodBeat.o(22660);
    return paramaf;
  }
  
  public final void Wd()
  {
    AppMethodBeat.i(22657);
    az.arV();
    setCursor(com.tencent.mm.model.c.apR().eLl());
    if (this.FNn != null) {
      this.FNn.aIp();
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(22657);
  }
  
  public final void We()
  {
    AppMethodBeat.i(22662);
    Wd();
    AppMethodBeat.o(22662);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.mRm = paramf;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(22659);
    am localam = (am)getItem(paramInt);
    Object localObject;
    label259:
    label478:
    label499:
    int i;
    int j;
    int k;
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = (MMSlideDelView)View.inflate(this.imP, 2131493169, null);
      localObject = View.inflate(this.imP, 2131495763, null);
      paramViewGroup.frr = ((ImageView)((View)localObject).findViewById(2131297008));
      paramViewGroup.frs = ((TextView)((View)localObject).findViewById(2131302867));
      paramViewGroup.mRp = ((TextView)((View)localObject).findViewById(2131306207));
      paramViewGroup.mRq = ((TextView)((View)localObject).findViewById(2131301311));
      paramViewGroup.lVB = ((ImageView)((View)localObject).findViewById(2131305187));
      paramViewGroup.mRr = ((TextView)((View)localObject).findViewById(2131305882));
      paramViewGroup.mRs = paramView.findViewById(2131304837);
      paramViewGroup.mRt = ((TextView)paramView.findViewById(2131304839));
      paramView.setView((View)localObject);
      paramView.setPerformItemClickListener(this.mRk);
      paramView.setGetViewPositionCallback(this.mRl);
      paramView.setItemStatusCallBack(this.mRn);
      paramView.setEnable(false);
      paramView.setTag(paramViewGroup);
      az.arV();
      localObject = com.tencent.mm.model.c.apM().aHY(localam.field_username);
      paramViewGroup.frs.setText(K((af)localObject));
      TextView localTextView = paramViewGroup.mRp;
      if (localam.field_status != 1) {
        break label623;
      }
      localObject = this.imP.getString(2131761075);
      localTextView.setText((CharSequence)localObject);
      a.b.c(paramViewGroup.frr, af.aHM(localam.field_username));
      az.arV();
      localObject = com.tencent.mm.model.c.apR().Lu().a(localam.field_isSend, localam.field_username, localam.field_content, OV(localam.field_msgType), this.imP);
      paramViewGroup.mRq.setText(k.b(this.imP, (CharSequence)localObject, paramViewGroup.mRq.getTextSize()));
      paramViewGroup.mRq.setTextColor(com.tencent.mm.cd.a.m(this.imP, 2131100642));
      if ((OV(localam.field_msgType) == 34) && (localam.field_isSend == 0) && (!bt.isNullOrNil(localam.field_content)) && (!new p(localam.field_content).hAc)) {
        paramViewGroup.mRq.setTextColor(com.tencent.mm.cd.a.m(this.imP, 2131100643));
      }
      switch (localam.field_status)
      {
      case 3: 
      case 4: 
      default: 
        paramInt = -1;
        if (paramInt != -1)
        {
          paramViewGroup.lVB.setBackgroundResource(paramInt);
          paramViewGroup.lVB.setVisibility(0);
          paramViewGroup.mRs.setTag(localam.field_username);
          paramViewGroup.mRs.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(22655);
              ad.v("MicroMsg.BottleConversationAdapter", "on delView clicked");
              a.this.mRn.cIh();
              if (a.this.mRm != null) {
                a.this.mRm.cO(paramAnonymousView.getTag());
              }
              AppMethodBeat.o(22655);
            }
          });
          paramInt = paramView.getPaddingBottom();
          i = paramView.getPaddingTop();
          j = paramView.getPaddingRight();
          k = paramView.getPaddingLeft();
          if (localam.field_unReadCount <= 100) {
            break label677;
          }
          paramViewGroup.mRr.setText("...");
          paramViewGroup.mRr.setVisibility(0);
          ad.v("MicroMsg.BottleConversationAdapter", "has unread 100");
        }
        break;
      }
    }
    for (;;)
    {
      paramView.setBackgroundResource(2131234801);
      paramView.setPadding(k, i, j, paramInt);
      AppMethodBeat.o(22659);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label623:
      localObject = h.c(this.imP, localam.field_conversationTime, true);
      break label259;
      paramInt = -1;
      break label478;
      paramInt = 2131690878;
      break label478;
      paramInt = -1;
      break label478;
      paramInt = 2131690877;
      break label478;
      paramViewGroup.lVB.setVisibility(8);
      break label499;
      label677:
      if (localam.field_unReadCount > 0)
      {
        paramViewGroup.mRr.setText(localam.field_unReadCount);
        paramViewGroup.mRr.setVisibility(0);
        ad.v("MicroMsg.BottleConversationAdapter", "has unread");
      }
      else
      {
        paramViewGroup.mRr.setVisibility(4);
        ad.v("MicroMsg.BottleConversationAdapter", "no unread");
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return 1;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(22658);
    if (this.mRn != null) {
      this.mRn.cIg();
    }
    AppMethodBeat.o(22658);
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.mRl = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.mRk = paramg;
  }
  
  public static final class a
  {
    public ImageView frr;
    public TextView frs;
    public ImageView lVB;
    public TextView mRp;
    public TextView mRq;
    public TextView mRr;
    public View mRs;
    public TextView mRt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.a
 * JD-Core Version:    0.7.0.1
 */