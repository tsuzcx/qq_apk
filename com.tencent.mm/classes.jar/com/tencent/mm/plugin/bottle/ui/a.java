package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.as;
import com.tencent.mm.model.au;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.r.a;

final class a
  extends r<ak>
  implements m.b
{
  private final MMActivity bER;
  protected MMSlideDelView.g hZd;
  protected MMSlideDelView.c hZe;
  protected MMSlideDelView.f hZf;
  protected MMSlideDelView.d hZg = MMSlideDelView.getItemStatusCallBack();
  
  public a(Context paramContext, r.a parama)
  {
    super(paramContext, new ak());
    this.uMi = parama;
    this.bER = ((MMActivity)paramContext);
  }
  
  private static int xP(String paramString)
  {
    int j = 1;
    int i = j;
    if (paramString != null)
    {
      i = j;
      if (paramString.length() <= 0) {}
    }
    try
    {
      i = Integer.valueOf(paramString).intValue();
      return i;
    }
    catch (NumberFormatException paramString) {}
    return 1;
  }
  
  final String D(ad paramad)
  {
    return com.tencent.mm.plugin.bottle.a.c.a(this.bER, paramad);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.hZf = paramf;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ak localak = (ak)getItem(paramInt);
    Object localObject;
    label264:
    label486:
    label507:
    int i;
    int j;
    int k;
    if (paramView == null)
    {
      paramViewGroup = new a.a();
      paramView = (MMSlideDelView)View.inflate(this.bER, R.i.base_slide_del_view, null);
      localObject = View.inflate(this.bER, R.i.tmessage_item, null);
      paramViewGroup.doU = ((ImageView)((View)localObject).findViewById(R.h.avatar_iv));
      paramViewGroup.doV = ((TextView)((View)localObject).findViewById(R.h.nickname_tv));
      paramViewGroup.hZi = ((TextView)((View)localObject).findViewById(R.h.update_time_tv));
      paramViewGroup.hZj = ((TextView)((View)localObject).findViewById(R.h.last_msg_tv));
      paramViewGroup.hqD = ((ImageView)((View)localObject).findViewById(R.h.state_iv));
      paramViewGroup.hZk = ((TextView)((View)localObject).findViewById(R.h.tipcnt_tv));
      paramViewGroup.hZl = paramView.findViewById(R.h.slide_del_del_view);
      paramViewGroup.hZm = ((TextView)paramView.findViewById(R.h.slide_del_view_del_word));
      paramView.setView((View)localObject);
      paramView.setPerformItemClickListener(this.hZd);
      paramView.setGetViewPositionCallback(this.hZe);
      paramView.setItemStatusCallBack(this.hZg);
      paramView.setEnable(false);
      paramView.setTag(paramViewGroup);
      au.Hx();
      localObject = com.tencent.mm.model.c.Fw().abl(localak.field_username);
      paramViewGroup.doV.setText(D((ad)localObject));
      TextView localTextView = paramViewGroup.hZi;
      if (localak.field_status != 1) {
        break label625;
      }
      localObject = this.bER.getString(R.l.main_sending);
      localTextView.setText((CharSequence)localObject);
      a.b.a(paramViewGroup.doU, ad.aaZ(localak.field_username));
      au.Hx();
      localObject = com.tencent.mm.model.c.FB().tt().a(localak.field_isSend, localak.field_username, localak.field_content, xP(localak.field_msgType), this.bER);
      paramViewGroup.hZj.setText(j.a(this.bER, (CharSequence)localObject, paramViewGroup.hZj.getTextSize()));
      paramViewGroup.hZj.setTextColor(com.tencent.mm.cb.a.h(this.bER, R.e.mm_list_textcolor_two));
      if ((xP(localak.field_msgType) == 34) && (localak.field_isSend == 0) && (!bk.bl(localak.field_content)) && (!new n(localak.field_content).eHB)) {
        paramViewGroup.hZj.setTextColor(com.tencent.mm.cb.a.h(this.bER, R.e.mm_list_textcolor_unread));
      }
      switch (localak.field_status)
      {
      case 3: 
      case 4: 
      default: 
        paramInt = -1;
        if (paramInt != -1)
        {
          paramViewGroup.hqD.setBackgroundResource(paramInt);
          paramViewGroup.hqD.setVisibility(0);
          paramViewGroup.hZl.setTag(localak.field_username);
          paramViewGroup.hZl.setOnClickListener(new a.1(this));
          paramInt = paramView.getPaddingBottom();
          i = paramView.getPaddingTop();
          j = paramView.getPaddingRight();
          k = paramView.getPaddingLeft();
          if (localak.field_unReadCount <= 100) {
            break label679;
          }
          paramViewGroup.hZk.setText("...");
          paramViewGroup.hZk.setVisibility(0);
          y.v("MicroMsg.BottleConversationAdapter", "has unread 100");
        }
        break;
      }
    }
    for (;;)
    {
      paramView.setBackgroundResource(R.g.mm_listitem);
      paramView.setPadding(k, i, j, paramInt);
      return paramView;
      paramViewGroup = (a.a)paramView.getTag();
      break;
      label625:
      localObject = h.c(this.bER, localak.field_conversationTime, true);
      break label264;
      paramInt = -1;
      break label486;
      paramInt = R.k.msg_state_sending;
      break label486;
      paramInt = -1;
      break label486;
      paramInt = R.k.msg_state_failed;
      break label486;
      paramViewGroup.hqD.setVisibility(8);
      break label507;
      label679:
      if (localak.field_unReadCount > 0)
      {
        paramViewGroup.hZk.setText(localak.field_unReadCount);
        paramViewGroup.hZk.setVisibility(0);
        y.v("MicroMsg.BottleConversationAdapter", "has unread");
      }
      else
      {
        paramViewGroup.hZk.setVisibility(4);
        y.v("MicroMsg.BottleConversationAdapter", "no unread");
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return 1;
  }
  
  public final void onPause()
  {
    if (this.hZg != null) {
      this.hZg.bdb();
    }
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.hZe = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.hZd = paramg;
  }
  
  public final void yc()
  {
    au.Hx();
    setCursor(com.tencent.mm.model.c.FB().cuJ());
    if (this.uMi != null) {
      this.uMi.Wp();
    }
    super.notifyDataSetChanged();
  }
  
  protected final void yd()
  {
    yc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.a
 * JD-Core Version:    0.7.0.1
 */