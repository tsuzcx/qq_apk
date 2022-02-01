package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.pluginsdk.i.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bq.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.r.a;

final class a
  extends r<at>
  implements n.b
{
  private final MMActivity fLP;
  protected MMSlideDelView.g nUw;
  protected MMSlideDelView.c nUx;
  protected MMSlideDelView.f nUy;
  protected MMSlideDelView.d nUz;
  
  public a(Context paramContext, r.a parama)
  {
    super(paramContext, new at());
    AppMethodBeat.i(22656);
    this.nUz = MMSlideDelView.getItemStatusCallBack();
    super.a(parama);
    this.fLP = ((MMActivity)paramContext);
    AppMethodBeat.o(22656);
  }
  
  private static int WF(String paramString)
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
  
  final String L(am paramam)
  {
    AppMethodBeat.i(22660);
    paramam = com.tencent.mm.plugin.bottle.a.c.a(this.fLP, paramam);
    AppMethodBeat.o(22660);
    return paramam;
  }
  
  public final void Zu()
  {
    AppMethodBeat.i(22657);
    com.tencent.mm.model.ba.aBQ();
    setCursor(com.tencent.mm.model.c.azv().fqQ());
    if (this.JaF != null) {
      this.JaF.aSs();
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(22657);
  }
  
  public final void Zv()
  {
    AppMethodBeat.i(22662);
    Zu();
    AppMethodBeat.o(22662);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.nUy = paramf;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(22659);
    at localat = (at)getItem(paramInt);
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
      paramView = (MMSlideDelView)View.inflate(this.fLP, 2131493169, null);
      localObject = View.inflate(this.fLP, 2131495763, null);
      paramViewGroup.fOf = ((ImageView)((View)localObject).findViewById(2131297008));
      paramViewGroup.fOg = ((TextView)((View)localObject).findViewById(2131302867));
      paramViewGroup.nUB = ((TextView)((View)localObject).findViewById(2131306207));
      paramViewGroup.nUC = ((TextView)((View)localObject).findViewById(2131301311));
      paramViewGroup.mYk = ((ImageView)((View)localObject).findViewById(2131305187));
      paramViewGroup.nUD = ((TextView)((View)localObject).findViewById(2131305882));
      paramViewGroup.nUE = paramView.findViewById(2131304837);
      paramViewGroup.nUF = ((TextView)paramView.findViewById(2131304839));
      paramView.setView((View)localObject);
      paramView.setPerformItemClickListener(this.nUw);
      paramView.setGetViewPositionCallback(this.nUx);
      paramView.setItemStatusCallBack(this.nUz);
      paramView.setEnable(false);
      paramView.setTag(paramViewGroup);
      com.tencent.mm.model.ba.aBQ();
      localObject = com.tencent.mm.model.c.azp().Bf(localat.field_username);
      paramViewGroup.fOg.setText(L((am)localObject));
      TextView localTextView = paramViewGroup.nUB;
      if (localat.field_status != 1) {
        break label623;
      }
      localObject = this.fLP.getString(2131761075);
      localTextView.setText((CharSequence)localObject);
      a.b.c(paramViewGroup.fOf, am.aSZ(localat.field_username));
      com.tencent.mm.model.ba.aBQ();
      localObject = com.tencent.mm.model.c.azv().Na().a(localat.field_isSend, localat.field_username, localat.field_content, WF(localat.field_msgType), this.fLP);
      paramViewGroup.nUC.setText(k.b(this.fLP, (CharSequence)localObject, paramViewGroup.nUC.getTextSize()));
      paramViewGroup.nUC.setTextColor(com.tencent.mm.cc.a.m(this.fLP, 2131100642));
      if ((WF(localat.field_msgType) == 34) && (localat.field_isSend == 0) && (!bt.isNullOrNil(localat.field_content)) && (!new p(localat.field_content).itZ)) {
        paramViewGroup.nUC.setTextColor(com.tencent.mm.cc.a.m(this.fLP, 2131100643));
      }
      switch (localat.field_status)
      {
      case 3: 
      case 4: 
      default: 
        paramInt = -1;
        if (paramInt != -1)
        {
          paramViewGroup.mYk.setBackgroundResource(paramInt);
          paramViewGroup.mYk.setVisibility(0);
          paramViewGroup.nUE.setTag(localat.field_username);
          paramViewGroup.nUE.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(22655);
              b localb = new b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/bottle/ui/BottleConversationAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              ad.v("MicroMsg.BottleConversationAdapter", "on delView clicked");
              a.this.nUz.deD();
              if (a.this.nUy != null) {
                a.this.nUy.cP(paramAnonymousView.getTag());
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/bottle/ui/BottleConversationAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(22655);
            }
          });
          paramInt = paramView.getPaddingBottom();
          i = paramView.getPaddingTop();
          j = paramView.getPaddingRight();
          k = paramView.getPaddingLeft();
          if (localat.field_unReadCount <= 100) {
            break label677;
          }
          paramViewGroup.nUD.setText("...");
          paramViewGroup.nUD.setVisibility(0);
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
      localObject = i.c(this.fLP, localat.field_conversationTime, true);
      break label259;
      paramInt = -1;
      break label478;
      paramInt = 2131690878;
      break label478;
      paramInt = -1;
      break label478;
      paramInt = 2131690877;
      break label478;
      paramViewGroup.mYk.setVisibility(8);
      break label499;
      label677:
      if (localat.field_unReadCount > 0)
      {
        paramViewGroup.nUD.setText(localat.field_unReadCount);
        paramViewGroup.nUD.setVisibility(0);
        ad.v("MicroMsg.BottleConversationAdapter", "has unread");
      }
      else
      {
        paramViewGroup.nUD.setVisibility(4);
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
    if (this.nUz != null) {
      this.nUz.deC();
    }
    AppMethodBeat.o(22658);
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.nUx = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.nUw = paramg;
  }
  
  public static final class a
  {
    public ImageView fOf;
    public TextView fOg;
    public ImageView mYk;
    public TextView nUB;
    public TextView nUC;
    public TextView nUD;
    public View nUE;
    public TextView nUF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.a
 * JD-Core Version:    0.7.0.1
 */