package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.pluginsdk.j.f;
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
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.v.a;

final class a
  extends v<az>
  implements MStorageEx.IOnStorageChange
{
  private final MMActivity iXq;
  protected MMSlideDelView.g snh;
  protected MMSlideDelView.c sni;
  protected MMSlideDelView.f snj;
  protected MMSlideDelView.d snk;
  
  public a(Context paramContext, v.a parama)
  {
    super(paramContext, new az());
    AppMethodBeat.i(22656);
    this.snk = MMSlideDelView.getItemStatusCallBack();
    super.a(parama);
    this.iXq = ((MMActivity)paramContext);
    AppMethodBeat.o(22656);
  }
  
  private static int aoT(String paramString)
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
  
  final String Z(as paramas)
  {
    AppMethodBeat.i(22660);
    paramas = com.tencent.mm.plugin.bottle.a.c.a(this.iXq, paramas);
    AppMethodBeat.o(22660);
    return paramas;
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.snj = paramf;
  }
  
  public final void atr()
  {
    AppMethodBeat.i(22657);
    bh.beI();
    v(com.tencent.mm.model.c.bbR().hyK());
    if (this.VZc != null) {
      this.VZc.bxN();
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(22657);
  }
  
  public final void ats()
  {
    AppMethodBeat.i(22662);
    atr();
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
    label270:
    label490:
    label511:
    int i;
    int j;
    int k;
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = (MMSlideDelView)View.inflate(this.iXq, R.i.base_slide_del_view, null);
      localObject = View.inflate(this.iXq, R.i.tmessage_item, null);
      paramViewGroup.iZG = ((ImageView)((View)localObject).findViewById(R.h.avatar_iv));
      paramViewGroup.iZH = ((TextView)((View)localObject).findViewById(R.h.nickname_tv));
      paramViewGroup.snm = ((TextView)((View)localObject).findViewById(R.h.update_time_tv));
      paramViewGroup.snn = ((TextView)((View)localObject).findViewById(R.h.last_msg_tv));
      paramViewGroup.rql = ((ImageView)((View)localObject).findViewById(R.h.state_iv));
      paramViewGroup.sno = ((TextView)((View)localObject).findViewById(R.h.tipcnt_tv));
      paramViewGroup.snp = paramView.findViewById(R.h.slide_del_del_view);
      paramViewGroup.snq = ((TextView)paramView.findViewById(R.h.slide_del_view_del_word));
      paramView.setView((View)localObject);
      paramView.setPerformItemClickListener(this.snh);
      paramView.setGetViewPositionCallback(this.sni);
      paramView.setItemStatusCallBack(this.snk);
      paramView.setEnable(false);
      paramView.setTag(paramViewGroup);
      bh.beI();
      localObject = com.tencent.mm.model.c.bbL().RG(localaz.field_username);
      paramViewGroup.iZH.setText(Z((as)localObject));
      TextView localTextView = paramViewGroup.snm;
      if (localaz.field_status != 1) {
        break label635;
      }
      localObject = this.iXq.getString(R.l.eLv);
      localTextView.setText((CharSequence)localObject);
      a.b.c(paramViewGroup.iZG, as.bvW(localaz.field_username));
      bh.beI();
      localObject = com.tencent.mm.model.c.bbR().abK().a(localaz.field_isSend, localaz.field_username, localaz.field_content, aoT(localaz.field_msgType), this.iXq);
      paramViewGroup.snn.setText(l.b(this.iXq, (CharSequence)localObject, paramViewGroup.snn.getTextSize()));
      paramViewGroup.snn.setTextColor(com.tencent.mm.ci.a.l(this.iXq, R.e.mm_list_textcolor_two));
      if ((aoT(localaz.field_msgType) == 34) && (localaz.field_isSend == 0) && (!Util.isNullOrNil(localaz.field_content)) && (!new p(localaz.field_content).mhL)) {
        paramViewGroup.snn.setTextColor(com.tencent.mm.ci.a.l(this.iXq, R.e.mm_list_textcolor_unread));
      }
      switch (localaz.field_status)
      {
      case 3: 
      case 4: 
      default: 
        paramInt = -1;
        if (paramInt != -1)
        {
          paramViewGroup.rql.setBackgroundResource(paramInt);
          paramViewGroup.rql.setVisibility(0);
          paramViewGroup.snp.setTag(localaz.field_username);
          paramViewGroup.snp.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(22655);
              b localb = new b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/bottle/ui/BottleConversationAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              Log.v("MicroMsg.BottleConversationAdapter", "on delView clicked");
              a.this.snk.eKn();
              if (a.this.snj != null) {
                a.this.snj.cW(paramAnonymousView.getTag());
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/bottle/ui/BottleConversationAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(22655);
            }
          });
          paramInt = paramView.getPaddingBottom();
          i = paramView.getPaddingTop();
          j = paramView.getPaddingRight();
          k = paramView.getPaddingLeft();
          if (localaz.field_unReadCount <= 100) {
            break label689;
          }
          paramViewGroup.sno.setText("...");
          paramViewGroup.sno.setVisibility(0);
          Log.v("MicroMsg.BottleConversationAdapter", "has unread 100");
        }
        break;
      }
    }
    for (;;)
    {
      paramView.setBackgroundResource(R.g.white_list_item_selector);
      paramView.setPadding(k, i, j, paramInt);
      AppMethodBeat.o(22659);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label635:
      localObject = f.d(this.iXq, localaz.field_conversationTime, true);
      break label270;
      paramInt = -1;
      break label490;
      paramInt = R.k.msg_state_sending;
      break label490;
      paramInt = -1;
      break label490;
      paramInt = R.k.msg_state_failed;
      break label490;
      paramViewGroup.rql.setVisibility(8);
      break label511;
      label689:
      if (localaz.field_unReadCount > 0)
      {
        paramViewGroup.sno.setText(localaz.field_unReadCount);
        paramViewGroup.sno.setVisibility(0);
        Log.v("MicroMsg.BottleConversationAdapter", "has unread");
      }
      else
      {
        paramViewGroup.sno.setVisibility(4);
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
    if (this.snk != null) {
      this.snk.eKm();
    }
    AppMethodBeat.o(22658);
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.sni = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.snh = paramg;
  }
  
  public static final class a
  {
    public ImageView iZG;
    public TextView iZH;
    public ImageView rql;
    public TextView snm;
    public TextView snn;
    public TextView sno;
    public View snp;
    public TextView snq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.a
 * JD-Core Version:    0.7.0.1
 */