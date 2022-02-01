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
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.pluginsdk.platformtools.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.by.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.x;
import com.tencent.mm.ui.x.a;

final class a
  extends x<bb>
  implements MStorageEx.IOnStorageChange
{
  private final MMActivity lzt;
  protected MMSlideDelView.g vzf;
  protected MMSlideDelView.c vzg;
  protected MMSlideDelView.f vzh;
  protected MMSlideDelView.d vzi;
  
  public a(Context paramContext, x.a parama)
  {
    super(paramContext, new bb());
    AppMethodBeat.i(22656);
    this.vzi = MMSlideDelView.getItemStatusCallBack();
    super.a(parama);
    this.lzt = ((MMActivity)paramContext);
    AppMethodBeat.o(22656);
  }
  
  private static int aip(String paramString)
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
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.vzh = paramf;
  }
  
  public final void aNy()
  {
    AppMethodBeat.i(22657);
    bh.bCz();
    w(com.tencent.mm.model.c.bzG().jaP());
    if (this.adDx != null) {
      this.adDx.bWC();
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(22657);
  }
  
  public final void aNz()
  {
    AppMethodBeat.i(22662);
    aNy();
    AppMethodBeat.o(22662);
  }
  
  final String ac(au paramau)
  {
    AppMethodBeat.i(22660);
    paramau = com.tencent.mm.plugin.bottle.a.c.a(this.lzt, paramau);
    AppMethodBeat.o(22660);
    return paramau;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(22659);
    bb localbb = (bb)getItem(paramInt);
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
      paramView = (MMSlideDelView)View.inflate(this.lzt, R.i.base_slide_del_view, null);
      localObject = View.inflate(this.lzt, R.i.tmessage_item, null);
      paramViewGroup.lBC = ((ImageView)((View)localObject).findViewById(R.h.avatar_iv));
      paramViewGroup.lBD = ((TextView)((View)localObject).findViewById(R.h.nickname_tv));
      paramViewGroup.vzk = ((TextView)((View)localObject).findViewById(R.h.update_time_tv));
      paramViewGroup.vzl = ((TextView)((View)localObject).findViewById(R.h.last_msg_tv));
      paramViewGroup.uAw = ((ImageView)((View)localObject).findViewById(R.h.state_iv));
      paramViewGroup.vzm = ((TextView)((View)localObject).findViewById(R.h.tipcnt_tv));
      paramViewGroup.vzn = paramView.findViewById(R.h.slide_del_del_view);
      paramViewGroup.vzo = ((TextView)paramView.findViewById(R.h.slide_del_view_del_word));
      paramView.setView((View)localObject);
      paramView.setPerformItemClickListener(this.vzf);
      paramView.setGetViewPositionCallback(this.vzg);
      paramView.setItemStatusCallBack(this.vzi);
      paramView.setEnable(false);
      paramView.setTag(paramViewGroup);
      bh.bCz();
      localObject = com.tencent.mm.model.c.bzA().JE(localbb.field_username);
      paramViewGroup.lBD.setText(ac((au)localObject));
      TextView localTextView = paramViewGroup.vzk;
      if (localbb.field_status != 1) {
        break label635;
      }
      localObject = this.lzt.getString(R.l.gNp);
      localTextView.setText((CharSequence)localObject);
      a.b.g(paramViewGroup.lBC, au.bxd(localbb.field_username));
      bh.bCz();
      localObject = com.tencent.mm.model.c.bzG().aDH().a(localbb.field_isSend, localbb.field_username, localbb.field_content, aip(localbb.field_msgType), this.lzt);
      paramViewGroup.vzl.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this.lzt, (CharSequence)localObject, paramViewGroup.vzl.getTextSize()));
      paramViewGroup.vzl.setTextColor(com.tencent.mm.cd.a.l(this.lzt, R.e.mm_list_textcolor_two));
      if ((aip(localbb.field_msgType) == 34) && (localbb.field_isSend == 0) && (!Util.isNullOrNil(localbb.field_content)) && (!new com.tencent.mm.modelvoice.p(localbb.field_content).paW)) {
        paramViewGroup.vzl.setTextColor(com.tencent.mm.cd.a.l(this.lzt, R.e.mm_list_textcolor_unread));
      }
      switch (localbb.field_status)
      {
      case 3: 
      case 4: 
      default: 
        paramInt = -1;
        if (paramInt != -1)
        {
          paramViewGroup.uAw.setBackgroundResource(paramInt);
          paramViewGroup.uAw.setVisibility(0);
          paramViewGroup.vzn.setTag(localbb.field_username);
          paramViewGroup.vzn.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(22655);
              b localb = new b();
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/bottle/ui/BottleConversationAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              Log.v("MicroMsg.BottleConversationAdapter", "on delView clicked");
              a.this.vzi.fSn();
              if (a.this.vzh != null) {
                a.this.vzh.es(paramAnonymousView.getTag());
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/bottle/ui/BottleConversationAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(22655);
            }
          });
          paramInt = paramView.getPaddingBottom();
          i = paramView.getPaddingTop();
          j = paramView.getPaddingRight();
          k = paramView.getPaddingLeft();
          if (localbb.field_unReadCount <= 100) {
            break label689;
          }
          paramViewGroup.vzm.setText("...");
          paramViewGroup.vzm.setVisibility(0);
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
      localObject = f.d(this.lzt, localbb.field_conversationTime, true);
      break label270;
      paramInt = -1;
      break label490;
      paramInt = R.k.msg_state_sending;
      break label490;
      paramInt = -1;
      break label490;
      paramInt = R.k.msg_state_failed;
      break label490;
      paramViewGroup.uAw.setVisibility(8);
      break label511;
      label689:
      if (localbb.field_unReadCount > 0)
      {
        paramViewGroup.vzm.setText(localbb.field_unReadCount);
        paramViewGroup.vzm.setVisibility(0);
        Log.v("MicroMsg.BottleConversationAdapter", "has unread");
      }
      else
      {
        paramViewGroup.vzm.setVisibility(4);
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
    if (this.vzi != null) {
      this.vzi.fSm();
    }
    AppMethodBeat.o(22658);
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.vzg = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.vzf = paramg;
  }
  
  public static final class a
  {
    public ImageView lBC;
    public TextView lBD;
    public ImageView uAw;
    public TextView vzk;
    public TextView vzl;
    public TextView vzm;
    public View vzn;
    public TextView vzo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.a
 * JD-Core Version:    0.7.0.1
 */