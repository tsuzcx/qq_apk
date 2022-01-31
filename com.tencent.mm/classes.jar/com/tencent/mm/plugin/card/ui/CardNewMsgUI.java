package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.b.k.a;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.plugin.card.model.g.a;
import com.tencent.mm.plugin.card.model.g.b;
import com.tencent.mm.protocal.c.lt;
import com.tencent.mm.protocal.c.ly;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.s;
import java.util.List;

public class CardNewMsgUI
  extends MMActivity
  implements k.a
{
  private ListView Nn;
  View.OnClickListener fvj = new CardNewMsgUI.9(this);
  private View hrf;
  private a iwd;
  private View iwe;
  private View iwf = null;
  private boolean iwg = false;
  
  private void aAW()
  {
    k localk = am.aAw();
    int i;
    if ((localk.ilf == null) || (localk.ilf.isEmpty()))
    {
      i = 0;
      if (i <= 0) {
        break label72;
      }
      this.Nn.setVisibility(0);
      this.hrf.setVisibility(8);
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.iwd.notifyDataSetChanged();
      return;
      i = localk.ilf.size();
      break;
      label72:
      this.Nn.setVisibility(8);
      this.hrf.setVisibility(0);
      enableOptionMenu(false);
    }
  }
  
  private void am(String paramString, boolean paramBoolean)
  {
    Intent localIntent = new Intent(this, CardDetailUI.class);
    localIntent.putExtra("key_card_id", paramString);
    localIntent.putExtra("key_is_share_card", paramBoolean);
    localIntent.putExtra("key_from_scene", 4);
    startActivity(localIntent);
  }
  
  public final void a(g paramg)
  {
    if (((paramg.field_msg_type & 0x1) == 0) || ((paramg.field_msg_type & 0x3) == 0)) {
      return;
    }
    aAW();
    this.iwd.a(null, null);
  }
  
  public final void axs() {}
  
  protected final int getLayoutId()
  {
    return a.e.card_msg_ui;
  }
  
  protected final void initView()
  {
    setMMTitle(a.g.card_msg_center);
    setBackBtn(new CardNewMsgUI.1(this));
    this.Nn = ((ListView)findViewById(a.d.card_msg_list));
    this.iwd = new a();
    this.Nn.setAdapter(this.iwd);
    this.Nn.setOnItemClickListener(new CardNewMsgUI.2(this));
    this.Nn.setOnItemLongClickListener(new CardNewMsgUI.3(this));
    this.Nn.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        if (!CardNewMsgUI.b(CardNewMsgUI.this)) {}
        while (paramAnonymousAbsListView.getLastVisiblePosition() != paramAnonymousAbsListView.getCount() - 1) {
          return;
        }
        if (am.aAu().aAo() > 0) {
          am.aAu().aAp();
        }
        for (;;)
        {
          CardNewMsgUI.a(CardNewMsgUI.this).a(null, null);
          return;
          CardNewMsgUI.a(CardNewMsgUI.this).aCd();
        }
      }
    });
    this.iwd.uMi = new CardNewMsgUI.5(this);
    addTextOptionMenu(0, getString(a.g.card_clear), new CardNewMsgUI.6(this));
    this.hrf = findViewById(a.d.content_no_data);
    aAW();
    this.iwe = com.tencent.mm.ui.y.gt(this).inflate(a.e.card_msg_footer, null);
    this.iwf = com.tencent.mm.ui.y.gt(this).inflate(a.e.mm_footerview, null);
    int i = am.aAu().aAo();
    if (i > 0) {
      this.Nn.addFooterView(this.iwe);
    }
    do
    {
      return;
      if ((!this.iwd.aCc()) && (i == 0) && (am.aAu().getCount() > 0))
      {
        this.Nn.addFooterView(this.iwf);
        this.iwg = true;
        return;
      }
    } while ((!this.iwd.aCc()) || (i != 0));
    am.aAu().getCount();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
    am.aAw().a(this);
    am.aAw().aAf();
  }
  
  protected void onDestroy()
  {
    this.iwd.bcS();
    am.aAw().b(this);
    if (am.aAu().aAo() > 0) {
      am.aAu().aAp();
    }
    super.onDestroy();
  }
  
  final class a
    extends r<g>
  {
    private int dsw = this.iwi;
    private int iwi = 10;
    
    public a()
    {
      super(new g());
      mR(true);
    }
    
    private void a(List<g.a> paramList, List<g.b> paramList1, CardNewMsgUI.b paramb, g paramg)
    {
      paramb.iwx.removeAllViews();
      if (((paramList == null) || (paramList.size() == 0)) && ((paramList1 == null) || (paramList1.size() == 0)))
      {
        paramb.iwy.setVisibility(8);
        return;
      }
      int i;
      Object localObject1;
      Object localObject2;
      if (!bk.dk(paramList))
      {
        i = 0;
        if (i < paramList.size())
        {
          localObject1 = (g.a)paramList.get(i);
          localObject2 = View.inflate(CardNewMsgUI.this.mController.uMN, a.e.card_accept_button_item, null);
          if (i == 0) {
            ((View)localObject2).findViewById(a.d.card_accept_button_divider).setVisibility(8);
          }
          ((TextView)((View)localObject2).findViewById(a.d.card_accept_button_title)).setText(((g.a)localObject1).title);
          ((TextView)((View)localObject2).findViewById(a.d.card_accept_button_subtitle)).setText(((g.a)localObject1).imV);
          Button localButton = (Button)((View)localObject2).findViewById(a.d.card_accept_button);
          localButton.setOnClickListener(new CardNewMsgUI.a.1(this, (g.a)localObject1, paramg));
          if (((g.a)localObject1).imX == 0) {
            localButton.setText(a.g.card_accept_button_title);
          }
          for (;;)
          {
            paramb.iwx.addView((View)localObject2);
            i += 1;
            break;
            if (((g.a)localObject1).imX == 1) {
              localButton.setText(a.g.card_accept_button_title_for_consumed);
            }
          }
        }
      }
      if (!bk.dk(paramList1))
      {
        i = 0;
        while (i < paramList1.size())
        {
          paramg = (g.b)paramList1.get(i);
          localObject1 = View.inflate(CardNewMsgUI.this.mController.uMN, a.e.card_accept_button_item, null);
          if ((i == 0) && (bk.dk(paramList))) {
            ((View)localObject1).findViewById(a.d.card_accept_button_divider).setVisibility(8);
          }
          ((TextView)((View)localObject1).findViewById(a.d.card_accept_button_title)).setText(paramg.title);
          ((TextView)((View)localObject1).findViewById(a.d.card_accept_button_subtitle)).setText(paramg.description);
          localObject2 = (Button)((View)localObject1).findViewById(a.d.card_accept_button);
          ((Button)localObject2).setOnClickListener(new CardNewMsgUI.a.2(this, paramg));
          ((Button)localObject2).setText(paramg.imZ);
          paramb.iwx.addView((View)localObject1);
          i += 1;
        }
      }
      paramb.iwy.setVisibility(0);
    }
    
    public final boolean aCc()
    {
      return this.iwi >= this.dsw;
    }
    
    public final int aCd()
    {
      if (aCc())
      {
        if (CardNewMsgUI.e(CardNewMsgUI.this).getParent() != null) {
          CardNewMsgUI.d(CardNewMsgUI.this).removeFooterView(CardNewMsgUI.e(CardNewMsgUI.this));
        }
        return 0;
      }
      this.iwi += 10;
      if (this.iwi <= this.dsw) {
        return 10;
      }
      this.iwi = this.dsw;
      return this.dsw % 10;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      g localg = (g)getItem(paramInt);
      int i;
      if (paramView == null)
      {
        paramView = View.inflate(CardNewMsgUI.this.mController.uMN, a.e.card_msg_item, null);
        paramViewGroup = new CardNewMsgUI.b(CardNewMsgUI.this, (byte)0);
        paramViewGroup.iwn = ((ImageView)paramView.findViewById(a.d.logo));
        paramViewGroup.iwo = paramView.findViewById(a.d.card_type_img_layout);
        paramViewGroup.iwp = ((ImageView)paramView.findViewById(a.d.card_type_img));
        paramViewGroup.iwq = ((TextView)paramView.findViewById(a.d.title_tv));
        paramViewGroup.iwr = ((TextView)paramView.findViewById(a.d.time_tv));
        paramViewGroup.iws = ((TextView)paramView.findViewById(a.d.description_tv));
        paramViewGroup.iwt = ((TextView)paramView.findViewById(a.d.extent_tv));
        paramViewGroup.iwu = ((TextView)paramView.findViewById(a.d.split_line));
        paramViewGroup.iwv = paramView.findViewById(a.d.oper_layout);
        paramViewGroup.iww = ((TextView)paramView.findViewById(a.d.oper_text));
        paramViewGroup.iwx = ((LinearLayout)paramView.findViewById(a.d.accept_buttons));
        paramViewGroup.iwy = ((LinearLayout)paramView.findViewById(a.d.accept_buttons_area));
        paramView.setTag(paramViewGroup);
        paramViewGroup.iwq.setText(localg.field_title);
        long l = localg.field_time;
        paramViewGroup.iwr.setText(com.tencent.mm.pluginsdk.f.h.c(CardNewMsgUI.this, l * 1000L, true));
        paramViewGroup.iws.setText(localg.field_description);
        i = CardNewMsgUI.this.getResources().getDimensionPixelSize(a.b.card_newmsg_list_logo_height);
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.CardNewMsgUI", "CardNewMsgUI getView () position : " + paramInt + " logo_url :  " + localg.field_logo_url);
        if (!TextUtils.isEmpty(localg.field_logo_color)) {
          break label553;
        }
        paramViewGroup.iwo.setVisibility(8);
        paramViewGroup.iwn.setVisibility(0);
        paramViewGroup.iwn.setImageResource(a.c.my_card_package_defaultlogo);
        m.a(paramViewGroup.iwn, localg.field_logo_url, i, a.c.my_card_package_defaultlogo, true);
        label373:
        Object localObject = localg.aAi();
        if ((localObject == null) || (TextUtils.isEmpty(((lt)localObject).text))) {
          break label671;
        }
        paramViewGroup.iwt.setText(((lt)localObject).text);
        paramViewGroup.iwt.setTag(localg);
        paramViewGroup.iwt.setVisibility(0);
        paramViewGroup.iwt.setOnClickListener(CardNewMsgUI.this.fvj);
        label439:
        localObject = localg.aAj();
        if ((localObject == null) || (TextUtils.isEmpty(((ly)localObject).text))) {
          break label683;
        }
        paramViewGroup.iww.setText(((ly)localObject).text);
        paramViewGroup.iwv.setVisibility(0);
        paramViewGroup.iwv.setOnClickListener(CardNewMsgUI.this.fvj);
        paramViewGroup.iwv.setTag(localg);
        paramViewGroup.iwu.setVisibility(0);
      }
      for (;;)
      {
        localg.aAk();
        localg.aAl();
        a(localg.imP, localg.imQ, paramViewGroup, localg);
        return paramView;
        paramViewGroup = (CardNewMsgUI.b)paramView.getTag();
        break;
        label553:
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.CardNewMsgUI", "CardNewMsgUI getView () position : " + paramInt + " field_logo_color :  " + localg.field_logo_color);
        paramViewGroup.iwo.setVisibility(0);
        paramViewGroup.iwn.setVisibility(8);
        if (!TextUtils.isEmpty(localg.field_logo_url))
        {
          m.a(CardNewMsgUI.this, paramViewGroup.iwp, localg.field_logo_url, i, a.c.card_ticket_normal_icon, l.yR(localg.field_logo_color));
          break label373;
        }
        m.a(paramViewGroup.iwp, a.c.card_ticket_normal_icon, l.yR(localg.field_logo_color));
        break label373;
        label671:
        paramViewGroup.iwt.setVisibility(8);
        break label439;
        label683:
        paramViewGroup.iwv.setVisibility(8);
        paramViewGroup.iwu.setVisibility(8);
      }
    }
    
    public final void yc()
    {
      if (am.aAu().aAo() > 0) {
        setCursor(am.aAu().dXw.rawQuery("select * from CardMsgInfo where read_state = ?  order by time desc", new String[] { "1" }));
      }
      for (;;)
      {
        notifyDataSetChanged();
        return;
        this.dsw = am.aAu().getCount();
        com.tencent.mm.plugin.card.model.h localh = am.aAu();
        int i = this.iwi;
        String str = "select * from CardMsgInfo order by time desc LIMIT " + i;
        setCursor(localh.dXw.rawQuery(str, null));
      }
    }
    
    protected final void yd()
    {
      bcS();
      yc();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardNewMsgUI
 * JD-Core Version:    0.7.0.1
 */