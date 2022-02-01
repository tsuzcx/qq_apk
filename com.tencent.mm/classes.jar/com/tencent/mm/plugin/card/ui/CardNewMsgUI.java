package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.b.k.a;
import com.tencent.mm.plugin.card.d.d.a;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.g.a;
import com.tencent.mm.plugin.card.model.g.b;
import com.tencent.mm.plugin.card.model.h;
import com.tencent.mm.plugin.card.sharecard.ui.CardConsumeSuccessUI;
import com.tencent.mm.pluginsdk.i.i;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.protocal.protobuf.tj;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.r.a;
import com.tencent.mm.ui.z;
import java.util.ArrayList;
import java.util.List;

public class CardNewMsgUI
  extends MMActivity
  implements k.a
{
  private View GG;
  View.OnClickListener jwB;
  private ListView mListView;
  private a oPw;
  private View oPx;
  private View oPy;
  private boolean oPz;
  
  public CardNewMsgUI()
  {
    AppMethodBeat.i(113537);
    this.oPy = null;
    this.oPz = false;
    this.jwB = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113527);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardNewMsgUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        if (paramAnonymousView.getId() == 2131299634)
        {
          paramAnonymousView = (com.tencent.mm.plugin.card.model.g)paramAnonymousView.getTag();
          if ((paramAnonymousView == null) || (paramAnonymousView.bVT() == null))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(113527);
            return;
          }
          com.tencent.mm.plugin.report.service.g.yxI.f(11941, new Object[] { Integer.valueOf(2), paramAnonymousView.field_card_id, paramAnonymousView.field_card_tp_id, paramAnonymousView.field_msg_id, "" });
          if (paramAnonymousView.bVT().oGc == 0)
          {
            ae.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_BUTTON_TYPE_URL");
            if (!TextUtils.isEmpty(paramAnonymousView.bVT().url)) {
              com.tencent.mm.plugin.card.d.b.a(CardNewMsgUI.this, paramAnonymousView.bVT().url, 2);
            }
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113527);
          return;
          ae.e("MicroMsg.CardNewMsgUI", "card msg button url is empty");
          continue;
          if (paramAnonymousView.bVT().oGc == 1)
          {
            ae.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_BUTTON_TYPE_SHOP");
            Object localObject2 = new Intent();
            ((Intent)localObject2).putExtra("KEY_CARD_ID", paramAnonymousView.field_card_id);
            ((Intent)localObject2).putExtra("KEY_CARD_TP_ID", paramAnonymousView.field_card_tp_id);
            ((Intent)localObject2).setClass(CardNewMsgUI.this, CardShopUI.class);
            localObject1 = CardNewMsgUI.this;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/card/ui/CardNewMsgUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((CardNewMsgUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.report.service.g.yxI.f(11324, new Object[] { "UsedStoresView", Integer.valueOf(paramAnonymousView.field_card_type), paramAnonymousView.field_card_tp_id, paramAnonymousView.field_card_id, Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "" });
            continue;
            if (paramAnonymousView.getId() == 2131303035)
            {
              paramAnonymousView = (com.tencent.mm.plugin.card.model.g)paramAnonymousView.getTag();
              if ((paramAnonymousView == null) || (paramAnonymousView.bVU() == null))
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(113527);
                return;
              }
              if (paramAnonymousView.bVU().type == 0)
              {
                ae.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_OPERATION_REGION_TYPE_TEXT");
                if (!TextUtils.isEmpty(paramAnonymousView.bVU().url)) {
                  com.tencent.mm.plugin.card.d.b.a(CardNewMsgUI.this, paramAnonymousView.bVU().url, 2);
                } else {
                  ae.e("MicroMsg.CardNewMsgUI", "card msg oper region url is empty");
                }
              }
              else if (paramAnonymousView.bVU().type == 1)
              {
                ae.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_OPERATION_REGION_TYPE_CARDS");
              }
            }
          }
        }
      }
    };
    AppMethodBeat.o(113537);
  }
  
  private void aK(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(113542);
    Intent localIntent = new Intent(this, CardDetailUI.class);
    localIntent.putExtra("key_card_id", paramString);
    localIntent.putExtra("key_is_share_card", paramBoolean);
    localIntent.putExtra("key_from_scene", 4);
    paramString = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahE(), "com/tencent/mm/plugin/card/ui/CardNewMsgUI", "gotoCardDetailUI", "(Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardNewMsgUI", "gotoCardDetailUI", "(Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(113542);
  }
  
  private void bWN()
  {
    AppMethodBeat.i(113541);
    if (am.bWg().getCount() > 0)
    {
      this.mListView.setVisibility(0);
      this.GG.setVisibility(8);
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.oPw.notifyDataSetChanged();
      AppMethodBeat.o(113541);
      return;
      this.mListView.setVisibility(8);
      this.GG.setVisibility(0);
      enableOptionMenu(false);
    }
  }
  
  public final void a(com.tencent.mm.plugin.card.model.g paramg)
  {
    AppMethodBeat.i(113543);
    if (((paramg.field_msg_type & 0x1) == 0) || ((paramg.field_msg_type & 0x3) == 0))
    {
      AppMethodBeat.o(113543);
      return;
    }
    bWN();
    this.oPw.a(null, null);
    AppMethodBeat.o(113543);
  }
  
  public int getLayoutId()
  {
    return 2131493325;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113540);
    setMMTitle(2131756941);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(113519);
        CardNewMsgUI.this.finish();
        AppMethodBeat.o(113519);
        return true;
      }
    });
    this.mListView = ((ListView)findViewById(2131297862));
    this.oPw = new a();
    this.mListView.setAdapter(this.oPw);
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(113520);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardNewMsgUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
        if (paramAnonymousInt == CardNewMsgUI.a(CardNewMsgUI.this).getCount())
        {
          paramAnonymousInt = 1;
          if (am.bWe().bVY() > 0) {
            am.bWe().bVZ();
          }
          for (;;)
          {
            CardNewMsgUI.a(CardNewMsgUI.this).a(null, null);
            if (!CardNewMsgUI.b(CardNewMsgUI.this))
            {
              if (CardNewMsgUI.c(CardNewMsgUI.this).getParent() != null)
              {
                ae.d("MicroMsg.CardNewMsgUI", "remove footer");
                CardNewMsgUI.d(CardNewMsgUI.this).removeFooterView(CardNewMsgUI.c(CardNewMsgUI.this));
              }
              if ((!CardNewMsgUI.a(CardNewMsgUI.this).bYq()) && (CardNewMsgUI.e(CardNewMsgUI.this).getParent() == null) && (paramAnonymousInt > 0))
              {
                CardNewMsgUI.d(CardNewMsgUI.this).addFooterView(CardNewMsgUI.e(CardNewMsgUI.this));
                ae.i("MicroMsg.CardNewMsgUI", "add mLoadingFooterView");
              }
            }
            CardNewMsgUI.f(CardNewMsgUI.this);
            CardNewMsgUI.c(CardNewMsgUI.this).setVisibility(8);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(113520);
            return;
            paramAnonymousInt = CardNewMsgUI.a(CardNewMsgUI.this).bYr();
          }
        }
        CardNewMsgUI.a(CardNewMsgUI.this, paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(113520);
      }
    });
    this.mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(113521);
        CardNewMsgUI.b(CardNewMsgUI.this, paramAnonymousInt);
        AppMethodBeat.o(113521);
        return true;
      }
    });
    this.mListView.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(113522);
        if (!CardNewMsgUI.b(CardNewMsgUI.this))
        {
          AppMethodBeat.o(113522);
          return;
        }
        if (paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1)
        {
          if (am.bWe().bVY() > 0) {
            am.bWe().bVZ();
          }
          for (;;)
          {
            CardNewMsgUI.a(CardNewMsgUI.this).a(null, null);
            AppMethodBeat.o(113522);
            return;
            CardNewMsgUI.a(CardNewMsgUI.this).bYr();
          }
        }
        AppMethodBeat.o(113522);
      }
    });
    this.oPw.a(new r.a()
    {
      public final void aSR()
      {
        AppMethodBeat.i(113523);
        CardNewMsgUI.g(CardNewMsgUI.this);
        if ((CardNewMsgUI.a(CardNewMsgUI.this).bYq()) && (am.bWe().bVY() == 0)) {
          CardNewMsgUI.c(CardNewMsgUI.this).setVisibility(8);
        }
        AppMethodBeat.o(113523);
      }
    });
    addTextOptionMenu(0, getString(2131756808), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(113524);
        com.tencent.mm.plugin.report.service.g.yxI.f(11582, new Object[] { "CardMsgClearMenu", Integer.valueOf(2), Integer.valueOf(0), "", "", "" });
        CardNewMsgUI.h(CardNewMsgUI.this);
        AppMethodBeat.o(113524);
        return true;
      }
    });
    this.GG = findViewById(2131298768);
    bWN();
    this.oPx = z.jV(this).inflate(2131493322, null);
    this.oPy = z.jV(this).inflate(2131494788, null);
    int i = am.bWe().bVY();
    if (i > 0)
    {
      this.mListView.addFooterView(this.oPx);
      AppMethodBeat.o(113540);
      return;
    }
    if ((!this.oPw.bYq()) && (i == 0) && (am.bWe().getCount() > 0))
    {
      this.mListView.addFooterView(this.oPy);
      this.oPz = true;
      AppMethodBeat.o(113540);
      return;
    }
    if ((this.oPw.bYq()) && (i == 0)) {
      am.bWe().getCount();
    }
    AppMethodBeat.o(113540);
  }
  
  public final void onChange() {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113538);
    super.onCreate(paramBundle);
    initView();
    am.bWg().a(this);
    am.bWg().bVQ();
    AppMethodBeat.o(113538);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113539);
    this.oPw.dhl();
    am.bWg().b(this);
    if (am.bWe().bVY() > 0) {
      am.bWe().bVZ();
    }
    super.onDestroy();
    AppMethodBeat.o(113539);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends r<com.tencent.mm.plugin.card.model.g>
  {
    private int fVS;
    private int oPB;
    
    public a()
    {
      super(new com.tencent.mm.plugin.card.model.g());
      AppMethodBeat.i(113530);
      this.oPB = 10;
      this.fVS = this.oPB;
      xs(true);
      AppMethodBeat.o(113530);
    }
    
    private void a(List<g.a> paramList, List<g.b> paramList1, CardNewMsgUI.b paramb, final com.tencent.mm.plugin.card.model.g paramg)
    {
      AppMethodBeat.i(113535);
      paramb.oPQ.removeAllViews();
      if (((paramList == null) || (paramList.size() == 0)) && ((paramList1 == null) || (paramList1.size() == 0)))
      {
        paramb.oPR.setVisibility(8);
        AppMethodBeat.o(113535);
        return;
      }
      int i;
      Object localObject1;
      Object localObject2;
      if (!bu.ht(paramList))
      {
        i = 0;
        if (i < paramList.size())
        {
          localObject1 = (g.a)paramList.get(i);
          localObject2 = View.inflate(CardNewMsgUI.this.getContext(), 2131493246, null);
          if (i == 0) {
            ((View)localObject2).findViewById(2131297712).setVisibility(8);
          }
          ((TextView)((View)localObject2).findViewById(2131297714)).setText(((g.a)localObject1).title);
          ((TextView)((View)localObject2).findViewById(2131297713)).setText(((g.a)localObject1).nhq);
          Button localButton = (Button)((View)localObject2).findViewById(2131297711);
          localButton.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(113528);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
              paramAnonymousView = new Intent();
              if (this.oPC.oGc == 0)
              {
                paramAnonymousView.setClass(CardNewMsgUI.this.getContext(), CardDetailUI.class);
                paramAnonymousView.putExtra("key_card_id", this.oPC.cardId);
                paramAnonymousView.putExtra("key_card_ext", this.oPC.oGb);
                paramAnonymousView.putExtra("key_from_scene", 17);
                localObject = CardNewMsgUI.this;
                paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahE(), "com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((CardNewMsgUI)localObject).startActivity((Intent)paramAnonymousView.mt(0));
                com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
              for (;;)
              {
                com.tencent.mm.plugin.report.service.g.yxI.f(11941, new Object[] { Integer.valueOf(8), paramg.field_card_id, paramg.field_card_tp_id, paramg.field_msg_id, this.oPC.cardId });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(113528);
                return;
                if (this.oPC.oGc == 1)
                {
                  paramAnonymousView.setClass(CardNewMsgUI.this.getContext(), CardConsumeSuccessUI.class);
                  paramAnonymousView.putExtra("key_card_id", paramg.field_card_id);
                  paramAnonymousView.putExtra("key_from_scene", 2);
                  localObject = CardNewMsgUI.this;
                  paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahE(), "com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  ((CardNewMsgUI)localObject).startActivity((Intent)paramAnonymousView.mt(0));
                  com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
              }
            }
          });
          if (((g.a)localObject1).oGc == 0) {
            localButton.setText(2131756784);
          }
          for (;;)
          {
            paramb.oPQ.addView((View)localObject2);
            i += 1;
            break;
            if (((g.a)localObject1).oGc == 1) {
              localButton.setText(2131756785);
            }
          }
        }
      }
      if (!bu.ht(paramList1))
      {
        i = 0;
        while (i < paramList1.size())
        {
          paramg = (g.b)paramList1.get(i);
          localObject1 = View.inflate(CardNewMsgUI.this.getContext(), 2131493246, null);
          if ((i == 0) && (bu.ht(paramList))) {
            ((View)localObject1).findViewById(2131297712).setVisibility(8);
          }
          ((TextView)((View)localObject1).findViewById(2131297714)).setText(paramg.title);
          ((TextView)((View)localObject1).findViewById(2131297713)).setText(paramg.description);
          localObject2 = (Button)((View)localObject1).findViewById(2131297711);
          ((Button)localObject2).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(113529);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              if (!TextUtils.isEmpty(paramg.oGf)) {
                com.tencent.mm.plugin.card.d.b.a(CardNewMsgUI.this, paramg.oGf, 2);
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(113529);
                return;
                ae.e("MicroMsg.CardNewMsgUI", "card msg button url is empty");
              }
            }
          });
          ((Button)localObject2).setText(paramg.oGe);
          paramb.oPQ.addView((View)localObject1);
          i += 1;
        }
      }
      paramb.oPR.setVisibility(0);
      AppMethodBeat.o(113535);
    }
    
    public final void ZD()
    {
      AppMethodBeat.i(113531);
      if (am.bWe().bVY() > 0) {
        setCursor(am.bWe().db.rawQuery("select * from CardMsgInfo where read_state = ?  order by time desc", new String[] { "1" }));
      }
      for (;;)
      {
        notifyDataSetChanged();
        AppMethodBeat.o(113531);
        return;
        this.fVS = am.bWe().getCount();
        h localh = am.bWe();
        String str = "select * from CardMsgInfo order by time desc LIMIT ".concat(String.valueOf(this.oPB));
        setCursor(localh.db.rawQuery(str, null));
      }
    }
    
    public final void ZE()
    {
      AppMethodBeat.i(113532);
      dhl();
      ZD();
      AppMethodBeat.o(113532);
    }
    
    public final boolean bYq()
    {
      return this.oPB >= this.fVS;
    }
    
    public final int bYr()
    {
      AppMethodBeat.i(113533);
      if (bYq())
      {
        if (CardNewMsgUI.e(CardNewMsgUI.this).getParent() != null) {
          CardNewMsgUI.d(CardNewMsgUI.this).removeFooterView(CardNewMsgUI.e(CardNewMsgUI.this));
        }
        AppMethodBeat.o(113533);
        return 0;
      }
      this.oPB += 10;
      if (this.oPB <= this.fVS)
      {
        AppMethodBeat.o(113533);
        return 10;
      }
      this.oPB = this.fVS;
      int i = this.fVS;
      AppMethodBeat.o(113533);
      return i % 10;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(113534);
      com.tencent.mm.plugin.card.model.g localg = (com.tencent.mm.plugin.card.model.g)getItem(paramInt);
      int i;
      if (paramView == null)
      {
        paramView = View.inflate(CardNewMsgUI.this.getContext(), 2131493323, null);
        paramViewGroup = new CardNewMsgUI.b(CardNewMsgUI.this, (byte)0);
        paramViewGroup.oPG = ((ImageView)paramView.findViewById(2131301584));
        paramViewGroup.oPH = paramView.findViewById(2131297917);
        paramViewGroup.oPI = ((ImageView)paramView.findViewById(2131297916));
        paramViewGroup.oPJ = ((TextView)paramView.findViewById(2131305948));
        paramViewGroup.oPK = ((TextView)paramView.findViewById(2131305822));
        paramViewGroup.oPL = ((TextView)paramView.findViewById(2131299010));
        paramViewGroup.oPM = ((TextView)paramView.findViewById(2131299634));
        paramViewGroup.oPN = ((TextView)paramView.findViewById(2131305155));
        paramViewGroup.oPO = paramView.findViewById(2131303035);
        paramViewGroup.oPP = ((TextView)paramView.findViewById(2131303036));
        paramViewGroup.oPQ = ((LinearLayout)paramView.findViewById(2131296315));
        paramViewGroup.oPR = ((LinearLayout)paramView.findViewById(2131296316));
        paramView.setTag(paramViewGroup);
        paramViewGroup.oPJ.setText(localg.field_title);
        long l = localg.field_time;
        paramViewGroup.oPK.setText(i.c(CardNewMsgUI.this, l * 1000L, true));
        paramViewGroup.oPL.setText(localg.field_description);
        i = CardNewMsgUI.this.getResources().getDimensionPixelSize(2131165991);
        ae.d("MicroMsg.CardNewMsgUI", "CardNewMsgUI getView () position : " + paramInt + " logo_url :  " + localg.field_logo_url);
        if (!TextUtils.isEmpty(localg.field_logo_color)) {
          break label558;
        }
        paramViewGroup.oPH.setVisibility(8);
        paramViewGroup.oPG.setVisibility(0);
        paramViewGroup.oPG.setImageResource(2131233400);
        n.a(paramViewGroup.oPG, localg.field_logo_url, i, 2131233400, true);
        label373:
        Object localObject = localg.bVT();
        if ((localObject == null) || (TextUtils.isEmpty(((sr)localObject).text))) {
          break label673;
        }
        paramViewGroup.oPM.setText(((sr)localObject).text);
        paramViewGroup.oPM.setTag(localg);
        paramViewGroup.oPM.setVisibility(0);
        paramViewGroup.oPM.setOnClickListener(CardNewMsgUI.this.jwB);
        label439:
        localObject = localg.bVU();
        if ((localObject == null) || (TextUtils.isEmpty(((tj)localObject).text))) {
          break label685;
        }
        paramViewGroup.oPP.setText(((tj)localObject).text);
        paramViewGroup.oPO.setVisibility(0);
        paramViewGroup.oPO.setOnClickListener(CardNewMsgUI.this.jwB);
        paramViewGroup.oPO.setTag(localg);
        paramViewGroup.oPN.setVisibility(0);
      }
      for (;;)
      {
        localg.bVV();
        localg.bVW();
        a(localg.oFV, localg.oFW, paramViewGroup, localg);
        AppMethodBeat.o(113534);
        return paramView;
        paramViewGroup = (CardNewMsgUI.b)paramView.getTag();
        break;
        label558:
        ae.d("MicroMsg.CardNewMsgUI", "CardNewMsgUI getView () position : " + paramInt + " field_logo_color :  " + localg.field_logo_color);
        paramViewGroup.oPH.setVisibility(0);
        paramViewGroup.oPG.setVisibility(8);
        if (!TextUtils.isEmpty(localg.field_logo_url))
        {
          n.a(CardNewMsgUI.this, paramViewGroup.oPI, localg.field_logo_url, i, l.ZY(localg.field_logo_color));
          break label373;
        }
        n.b(paramViewGroup.oPI, 2131231506, l.ZY(localg.field_logo_color));
        break label373;
        label673:
        paramViewGroup.oPM.setVisibility(8);
        break label439;
        label685:
        paramViewGroup.oPO.setVisibility(8);
        paramViewGroup.oPN.setVisibility(8);
      }
    }
  }
  
  final class b
  {
    ImageView oPG;
    View oPH;
    ImageView oPI;
    TextView oPJ;
    TextView oPK;
    TextView oPL;
    TextView oPM;
    TextView oPN;
    View oPO;
    TextView oPP;
    LinearLayout oPQ;
    LinearLayout oPR;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardNewMsgUI
 * JD-Core Version:    0.7.0.1
 */