package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.bw.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.s.a;

final class a
  extends s<az>
  implements MStorageEx.IOnStorageChange
{
  private final MMActivity gte;
  protected MMSlideDelView.g pkY;
  protected MMSlideDelView.c pkZ;
  protected MMSlideDelView.f pla;
  protected MMSlideDelView.d plb;
  
  public a(Context paramContext, s.a parama)
  {
    super(paramContext, new az());
    AppMethodBeat.i(22656);
    this.plb = MMSlideDelView.getItemStatusCallBack();
    super.a(parama);
    this.gte = ((MMActivity)paramContext);
    AppMethodBeat.o(22656);
  }
  
  private static int ahn(String paramString)
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
  
  final String S(as paramas)
  {
    AppMethodBeat.i(22660);
    paramas = com.tencent.mm.plugin.bottle.a.c.a(this.gte, paramas);
    AppMethodBeat.o(22660);
    return paramas;
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.pla = paramf;
  }
  
  public final void anp()
  {
    AppMethodBeat.i(22657);
    bg.aVF();
    setCursor(com.tencent.mm.model.c.aST().gCx());
    if (this.OFI != null) {
      this.OFI.bnE();
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(22657);
  }
  
  public final void anq()
  {
    AppMethodBeat.i(22662);
    anp();
    AppMethodBeat.o(22662);
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(22659);
    az localaz = (az)getItem(paramInt);
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
      paramView = (MMSlideDelView)View.inflate(this.gte, 2131493215, null);
      localObject = View.inflate(this.gte, 2131496721, null);
      paramViewGroup.gvv = ((ImageView)((View)localObject).findViewById(2131297134));
      paramViewGroup.gvw = ((TextView)((View)localObject).findViewById(2131305440));
      paramViewGroup.pld = ((TextView)((View)localObject).findViewById(2131309606));
      paramViewGroup.ple = ((TextView)((View)localObject).findViewById(2131303011));
      paramViewGroup.ooE = ((ImageView)((View)localObject).findViewById(2131308378));
      paramViewGroup.plf = ((TextView)((View)localObject).findViewById(2131309165));
      paramViewGroup.plg = paramView.findViewById(2131307923);
      paramViewGroup.plh = ((TextView)paramView.findViewById(2131307925));
      paramView.setView((View)localObject);
      paramView.setPerformItemClickListener(this.pkY);
      paramView.setGetViewPositionCallback(this.pkZ);
      paramView.setItemStatusCallBack(this.plb);
      paramView.setEnable(false);
      paramView.setTag(paramViewGroup);
      bg.aVF();
      localObject = com.tencent.mm.model.c.aSN().Kn(localaz.field_username);
      paramViewGroup.gvw.setText(S((as)localObject));
      TextView localTextView = paramViewGroup.pld;
      if (localaz.field_status != 1) {
        break label623;
      }
      localObject = this.gte.getString(2131762861);
      localTextView.setText((CharSequence)localObject);
      a.b.c(paramViewGroup.gvv, as.bjz(localaz.field_username));
      bg.aVF();
      localObject = com.tencent.mm.model.c.aST().Xh().a(localaz.field_isSend, localaz.field_username, localaz.field_content, ahn(localaz.field_msgType), this.gte);
      paramViewGroup.ple.setText(l.b(this.gte, (CharSequence)localObject, paramViewGroup.ple.getTextSize()));
      paramViewGroup.ple.setTextColor(com.tencent.mm.cb.a.m(this.gte, 2131100812));
      if ((ahn(localaz.field_msgType) == 34) && (localaz.field_isSend == 0) && (!Util.isNullOrNil(localaz.field_content)) && (!new p(localaz.field_content).jsi)) {
        paramViewGroup.ple.setTextColor(com.tencent.mm.cb.a.m(this.gte, 2131100813));
      }
      switch (localaz.field_status)
      {
      case 3: 
      case 4: 
      default: 
        paramInt = -1;
        if (paramInt != -1)
        {
          paramViewGroup.ooE.setBackgroundResource(paramInt);
          paramViewGroup.ooE.setVisibility(0);
          paramViewGroup.plg.setTag(localaz.field_username);
          paramViewGroup.plg.setOnClickListener(new a.1(this));
          paramInt = paramView.getPaddingBottom();
          i = paramView.getPaddingTop();
          j = paramView.getPaddingRight();
          k = paramView.getPaddingLeft();
          if (localaz.field_unReadCount <= 100) {
            break label677;
          }
          paramViewGroup.plf.setText("...");
          paramViewGroup.plf.setVisibility(0);
          Log.v("MicroMsg.BottleConversationAdapter", "has unread 100");
        }
        break;
      }
    }
    for (;;)
    {
      paramView.setBackgroundResource(2131235784);
      paramView.setPadding(k, i, j, paramInt);
      AppMethodBeat.o(22659);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label623:
      localObject = f.c(this.gte, localaz.field_conversationTime, true);
      break label259;
      paramInt = -1;
      break label478;
      paramInt = 2131691165;
      break label478;
      paramInt = -1;
      break label478;
      paramInt = 2131691164;
      break label478;
      paramViewGroup.ooE.setVisibility(8);
      break label499;
      label677:
      if (localaz.field_unReadCount > 0)
      {
        paramViewGroup.plf.setText(localaz.field_unReadCount);
        paramViewGroup.plf.setVisibility(0);
        Log.v("MicroMsg.BottleConversationAdapter", "has unread");
      }
      else
      {
        paramViewGroup.plf.setVisibility(4);
        Log.v("MicroMsg.BottleConversationAdapter", "no unread");
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
    if (this.plb != null) {
      this.plb.ebo();
    }
    AppMethodBeat.o(22658);
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.pkZ = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.pkY = paramg;
  }
  
  public static final class a
  {
    public ImageView gvv;
    public TextView gvw;
    public ImageView ooE;
    public TextView pld;
    public TextView ple;
    public TextView plf;
    public View plg;
    public TextView plh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.a
 * JD-Core Version:    0.7.0.1
 */