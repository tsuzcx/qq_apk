package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.pluginsdk.i.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.br.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.r.a;

final class a
  extends r<au>
  implements n.b
{
  private final MMActivity fNT;
  protected MMSlideDelView.g oac;
  protected MMSlideDelView.c oad;
  protected MMSlideDelView.f oae;
  protected MMSlideDelView.d oaf;
  
  public a(Context paramContext, r.a parama)
  {
    super(paramContext, new au());
    AppMethodBeat.i(22656);
    this.oaf = MMSlideDelView.getItemStatusCallBack();
    super.a(parama);
    this.fNT = ((MMActivity)paramContext);
    AppMethodBeat.o(22656);
  }
  
  private static int Xr(String paramString)
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
  
  final String S(an paraman)
  {
    AppMethodBeat.i(22660);
    paraman = com.tencent.mm.plugin.bottle.a.c.a(this.fNT, paraman);
    AppMethodBeat.o(22660);
    return paraman;
  }
  
  public final void ZD()
  {
    AppMethodBeat.i(22657);
    bc.aCg();
    setCursor(com.tencent.mm.model.c.azL().fuQ());
    if (this.Jvn != null) {
      this.Jvn.aSR();
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(22657);
  }
  
  public final void ZE()
  {
    AppMethodBeat.i(22662);
    ZD();
    AppMethodBeat.o(22662);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.oae = paramf;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(22659);
    au localau = (au)getItem(paramInt);
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
      paramView = (MMSlideDelView)View.inflate(this.fNT, 2131493169, null);
      localObject = View.inflate(this.fNT, 2131495763, null);
      paramViewGroup.fQl = ((ImageView)((View)localObject).findViewById(2131297008));
      paramViewGroup.fQm = ((TextView)((View)localObject).findViewById(2131302867));
      paramViewGroup.oah = ((TextView)((View)localObject).findViewById(2131306207));
      paramViewGroup.oai = ((TextView)((View)localObject).findViewById(2131301311));
      paramViewGroup.ndr = ((ImageView)((View)localObject).findViewById(2131305187));
      paramViewGroup.oaj = ((TextView)((View)localObject).findViewById(2131305882));
      paramViewGroup.oak = paramView.findViewById(2131304837);
      paramViewGroup.oal = ((TextView)paramView.findViewById(2131304839));
      paramView.setView((View)localObject);
      paramView.setPerformItemClickListener(this.oac);
      paramView.setGetViewPositionCallback(this.oad);
      paramView.setItemStatusCallBack(this.oaf);
      paramView.setEnable(false);
      paramView.setTag(paramViewGroup);
      bc.aCg();
      localObject = com.tencent.mm.model.c.azF().BH(localau.field_username);
      paramViewGroup.fQm.setText(S((an)localObject));
      TextView localTextView = paramViewGroup.oah;
      if (localau.field_status != 1) {
        break label623;
      }
      localObject = this.fNT.getString(2131761075);
      localTextView.setText((CharSequence)localObject);
      a.b.c(paramViewGroup.fQl, an.aUA(localau.field_username));
      bc.aCg();
      localObject = com.tencent.mm.model.c.azL().MV().a(localau.field_isSend, localau.field_username, localau.field_content, Xr(localau.field_msgType), this.fNT);
      paramViewGroup.oai.setText(k.b(this.fNT, (CharSequence)localObject, paramViewGroup.oai.getTextSize()));
      paramViewGroup.oai.setTextColor(com.tencent.mm.cb.a.m(this.fNT, 2131100642));
      if ((Xr(localau.field_msgType) == 34) && (localau.field_isSend == 0) && (!bu.isNullOrNil(localau.field_content)) && (!new p(localau.field_content).iwT)) {
        paramViewGroup.oai.setTextColor(com.tencent.mm.cb.a.m(this.fNT, 2131100643));
      }
      switch (localau.field_status)
      {
      case 3: 
      case 4: 
      default: 
        paramInt = -1;
        if (paramInt != -1)
        {
          paramViewGroup.ndr.setBackgroundResource(paramInt);
          paramViewGroup.ndr.setVisibility(0);
          paramViewGroup.oak.setTag(localau.field_username);
          paramViewGroup.oak.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(22655);
              b localb = new b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/bottle/ui/BottleConversationAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              ae.v("MicroMsg.BottleConversationAdapter", "on delView clicked");
              a.this.oaf.dhv();
              if (a.this.oae != null) {
                a.this.oae.cQ(paramAnonymousView.getTag());
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/bottle/ui/BottleConversationAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(22655);
            }
          });
          paramInt = paramView.getPaddingBottom();
          i = paramView.getPaddingTop();
          j = paramView.getPaddingRight();
          k = paramView.getPaddingLeft();
          if (localau.field_unReadCount <= 100) {
            break label677;
          }
          paramViewGroup.oaj.setText("...");
          paramViewGroup.oaj.setVisibility(0);
          ae.v("MicroMsg.BottleConversationAdapter", "has unread 100");
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
      localObject = i.c(this.fNT, localau.field_conversationTime, true);
      break label259;
      paramInt = -1;
      break label478;
      paramInt = 2131690878;
      break label478;
      paramInt = -1;
      break label478;
      paramInt = 2131690877;
      break label478;
      paramViewGroup.ndr.setVisibility(8);
      break label499;
      label677:
      if (localau.field_unReadCount > 0)
      {
        paramViewGroup.oaj.setText(localau.field_unReadCount);
        paramViewGroup.oaj.setVisibility(0);
        ae.v("MicroMsg.BottleConversationAdapter", "has unread");
      }
      else
      {
        paramViewGroup.oaj.setVisibility(4);
        ae.v("MicroMsg.BottleConversationAdapter", "no unread");
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
    if (this.oaf != null) {
      this.oaf.dhu();
    }
    AppMethodBeat.o(22658);
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.oad = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.oac = paramg;
  }
  
  public static final class a
  {
    public ImageView fQl;
    public TextView fQm;
    public ImageView ndr;
    public TextView oah;
    public TextView oai;
    public TextView oaj;
    public View oak;
    public TextView oal;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.a
 * JD-Core Version:    0.7.0.1
 */