package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.pluginsdk.g.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bk.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.r.a;

final class a
  extends r<ap>
  implements n.b
{
  private final MMActivity iMV;
  protected MMSlideDelView.g ntA;
  protected MMSlideDelView.c ntB;
  protected MMSlideDelView.f ntC;
  protected MMSlideDelView.d ntD;
  
  public a(Context paramContext, r.a parama)
  {
    super(paramContext, new ap());
    AppMethodBeat.i(22656);
    this.ntD = MMSlideDelView.getItemStatusCallBack();
    super.a(parama);
    this.iMV = ((MMActivity)paramContext);
    AppMethodBeat.o(22656);
  }
  
  private static int Tf(String paramString)
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
  
  final String L(ai paramai)
  {
    AppMethodBeat.i(22660);
    paramai = com.tencent.mm.plugin.bottle.a.c.a(this.iMV, paramai);
    AppMethodBeat.o(22660);
    return paramai;
  }
  
  public final void Xb()
  {
    AppMethodBeat.i(22657);
    com.tencent.mm.model.az.ayM();
    setCursor(com.tencent.mm.model.c.awG().faN());
    if (this.HmY != null) {
      this.HmY.aPg();
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(22657);
  }
  
  public final void Xc()
  {
    AppMethodBeat.i(22662);
    Xb();
    AppMethodBeat.o(22662);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.ntC = paramf;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(22659);
    ap localap = (ap)getItem(paramInt);
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
      paramView = (MMSlideDelView)View.inflate(this.iMV, 2131493169, null);
      localObject = View.inflate(this.iMV, 2131495763, null);
      paramViewGroup.fuY = ((ImageView)((View)localObject).findViewById(2131297008));
      paramViewGroup.fuZ = ((TextView)((View)localObject).findViewById(2131302867));
      paramViewGroup.ntF = ((TextView)((View)localObject).findViewById(2131306207));
      paramViewGroup.ntG = ((TextView)((View)localObject).findViewById(2131301311));
      paramViewGroup.mxD = ((ImageView)((View)localObject).findViewById(2131305187));
      paramViewGroup.ntH = ((TextView)((View)localObject).findViewById(2131305882));
      paramViewGroup.ntI = paramView.findViewById(2131304837);
      paramViewGroup.ntJ = ((TextView)paramView.findViewById(2131304839));
      paramView.setView((View)localObject);
      paramView.setPerformItemClickListener(this.ntA);
      paramView.setGetViewPositionCallback(this.ntB);
      paramView.setItemStatusCallBack(this.ntD);
      paramView.setEnable(false);
      paramView.setTag(paramViewGroup);
      com.tencent.mm.model.az.ayM();
      localObject = com.tencent.mm.model.c.awB().aNt(localap.field_username);
      paramViewGroup.fuZ.setText(L((ai)localObject));
      TextView localTextView = paramViewGroup.ntF;
      if (localap.field_status != 1) {
        break label623;
      }
      localObject = this.iMV.getString(2131761075);
      localTextView.setText((CharSequence)localObject);
      a.b.c(paramViewGroup.fuY, ai.aNh(localap.field_username));
      com.tencent.mm.model.az.ayM();
      localObject = com.tencent.mm.model.c.awG().Ls().a(localap.field_isSend, localap.field_username, localap.field_content, Tf(localap.field_msgType), this.iMV);
      paramViewGroup.ntG.setText(k.b(this.iMV, (CharSequence)localObject, paramViewGroup.ntG.getTextSize()));
      paramViewGroup.ntG.setTextColor(com.tencent.mm.cc.a.m(this.iMV, 2131100642));
      if ((Tf(localap.field_msgType) == 34) && (localap.field_isSend == 0) && (!bs.isNullOrNil(localap.field_content)) && (!new p(localap.field_content).iaD)) {
        paramViewGroup.ntG.setTextColor(com.tencent.mm.cc.a.m(this.iMV, 2131100643));
      }
      switch (localap.field_status)
      {
      case 3: 
      case 4: 
      default: 
        paramInt = -1;
        if (paramInt != -1)
        {
          paramViewGroup.mxD.setBackgroundResource(paramInt);
          paramViewGroup.mxD.setVisibility(0);
          paramViewGroup.ntI.setTag(localap.field_username);
          paramViewGroup.ntI.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(22655);
              ac.v("MicroMsg.BottleConversationAdapter", "on delView clicked");
              a.this.ntD.cVs();
              if (a.this.ntC != null) {
                a.this.ntC.cN(paramAnonymousView.getTag());
              }
              AppMethodBeat.o(22655);
            }
          });
          paramInt = paramView.getPaddingBottom();
          i = paramView.getPaddingTop();
          j = paramView.getPaddingRight();
          k = paramView.getPaddingLeft();
          if (localap.field_unReadCount <= 100) {
            break label677;
          }
          paramViewGroup.ntH.setText("...");
          paramViewGroup.ntH.setVisibility(0);
          ac.v("MicroMsg.BottleConversationAdapter", "has unread 100");
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
      localObject = h.c(this.iMV, localap.field_conversationTime, true);
      break label259;
      paramInt = -1;
      break label478;
      paramInt = 2131690878;
      break label478;
      paramInt = -1;
      break label478;
      paramInt = 2131690877;
      break label478;
      paramViewGroup.mxD.setVisibility(8);
      break label499;
      label677:
      if (localap.field_unReadCount > 0)
      {
        paramViewGroup.ntH.setText(localap.field_unReadCount);
        paramViewGroup.ntH.setVisibility(0);
        ac.v("MicroMsg.BottleConversationAdapter", "has unread");
      }
      else
      {
        paramViewGroup.ntH.setVisibility(4);
        ac.v("MicroMsg.BottleConversationAdapter", "no unread");
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
    if (this.ntD != null) {
      this.ntD.cVr();
    }
    AppMethodBeat.o(22658);
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.ntB = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.ntA = paramg;
  }
  
  public static final class a
  {
    public ImageView fuY;
    public TextView fuZ;
    public ImageView mxD;
    public TextView ntF;
    public TextView ntG;
    public TextView ntH;
    public View ntI;
    public TextView ntJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.a
 * JD-Core Version:    0.7.0.1
 */