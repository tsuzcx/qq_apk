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
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.plugin.card.model.g.a;
import com.tencent.mm.plugin.card.model.g.b;
import com.tencent.mm.plugin.card.sharecard.ui.CardConsumeSuccessUI;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.protocal.protobuf.tw;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.s.a;
import java.util.ArrayList;
import java.util.List;

public class CardNewMsgUI
  extends MMActivity
  implements k.a
{
  private View GQ;
  View.OnClickListener kuO;
  private ListView mListView;
  private a qdk;
  private View qdl;
  private View qdm;
  private boolean qdn;
  
  public CardNewMsgUI()
  {
    AppMethodBeat.i(113537);
    this.qdm = null;
    this.qdn = false;
    this.kuO = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113527);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardNewMsgUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        if (paramAnonymousView.getId() == 2131300268)
        {
          paramAnonymousView = (g)paramAnonymousView.getTag();
          if ((paramAnonymousView == null) || (paramAnonymousView.ctH() == null))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(113527);
            return;
          }
          com.tencent.mm.plugin.report.service.h.CyF.a(11941, new Object[] { Integer.valueOf(2), paramAnonymousView.field_card_id, paramAnonymousView.field_card_tp_id, paramAnonymousView.field_msg_id, "" });
          if (paramAnonymousView.ctH().pTI == 0)
          {
            Log.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_BUTTON_TYPE_URL");
            if (!TextUtils.isEmpty(paramAnonymousView.ctH().url)) {
              com.tencent.mm.plugin.card.d.b.a(CardNewMsgUI.this, paramAnonymousView.ctH().url, 2);
            }
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113527);
          return;
          Log.e("MicroMsg.CardNewMsgUI", "card msg button url is empty");
          continue;
          if (paramAnonymousView.ctH().pTI == 1)
          {
            Log.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_BUTTON_TYPE_SHOP");
            Object localObject2 = new Intent();
            ((Intent)localObject2).putExtra("KEY_CARD_ID", paramAnonymousView.field_card_id);
            ((Intent)localObject2).putExtra("KEY_CARD_TP_ID", paramAnonymousView.field_card_tp_id);
            ((Intent)localObject2).setClass(CardNewMsgUI.this, CardShopUI.class);
            localObject1 = CardNewMsgUI.this;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/card/ui/CardNewMsgUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((CardNewMsgUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.report.service.h.CyF.a(11324, new Object[] { "UsedStoresView", Integer.valueOf(paramAnonymousView.field_card_type), paramAnonymousView.field_card_tp_id, paramAnonymousView.field_card_id, Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "" });
            continue;
            if (paramAnonymousView.getId() == 2131305638)
            {
              paramAnonymousView = (g)paramAnonymousView.getTag();
              if ((paramAnonymousView == null) || (paramAnonymousView.ctI() == null))
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(113527);
                return;
              }
              if (paramAnonymousView.ctI().type == 0)
              {
                Log.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_OPERATION_REGION_TYPE_TEXT");
                if (!TextUtils.isEmpty(paramAnonymousView.ctI().url)) {
                  com.tencent.mm.plugin.card.d.b.a(CardNewMsgUI.this, paramAnonymousView.ctI().url, 2);
                } else {
                  Log.e("MicroMsg.CardNewMsgUI", "card msg oper region url is empty");
                }
              }
              else if (paramAnonymousView.ctI().type == 1)
              {
                Log.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_OPERATION_REGION_TYPE_CARDS");
              }
            }
          }
        }
      }
    };
    AppMethodBeat.o(113537);
  }
  
  private void aM(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(113542);
    Intent localIntent = new Intent(this, CardDetailUI.class);
    localIntent.putExtra("key_card_id", paramString);
    localIntent.putExtra("key_is_share_card", paramBoolean);
    localIntent.putExtra("key_from_scene", 4);
    paramString = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramString.axQ(), "com/tencent/mm/plugin/card/ui/CardNewMsgUI", "gotoCardDetailUI", "(Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardNewMsgUI", "gotoCardDetailUI", "(Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(113542);
  }
  
  private void cuE()
  {
    AppMethodBeat.i(113541);
    if (am.ctU().getCount() > 0)
    {
      this.mListView.setVisibility(0);
      this.GQ.setVisibility(8);
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.qdk.notifyDataSetChanged();
      AppMethodBeat.o(113541);
      return;
      this.mListView.setVisibility(8);
      this.GQ.setVisibility(0);
      enableOptionMenu(false);
    }
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(113543);
    if (((paramg.field_msg_type & 0x1) == 0) || ((paramg.field_msg_type & 0x3) == 0))
    {
      AppMethodBeat.o(113543);
      return;
    }
    cuE();
    this.qdk.onNotifyChange(null, null);
    AppMethodBeat.o(113543);
  }
  
  public int getLayoutId()
  {
    return 2131493416;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113540);
    setMMTitle(2131757111);
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
    this.mListView = ((ListView)findViewById(2131298178));
    this.qdk = new a();
    this.mListView.setAdapter(this.qdk);
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(113520);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardNewMsgUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        if (paramAnonymousInt == CardNewMsgUI.a(CardNewMsgUI.this).getCount())
        {
          paramAnonymousInt = 1;
          if (am.ctS().ctM() > 0) {
            am.ctS().ctN();
          }
          for (;;)
          {
            CardNewMsgUI.a(CardNewMsgUI.this).onNotifyChange(null, null);
            if (!CardNewMsgUI.b(CardNewMsgUI.this))
            {
              if (CardNewMsgUI.c(CardNewMsgUI.this).getParent() != null)
              {
                Log.d("MicroMsg.CardNewMsgUI", "remove footer");
                CardNewMsgUI.d(CardNewMsgUI.this).removeFooterView(CardNewMsgUI.c(CardNewMsgUI.this));
              }
              if ((!CardNewMsgUI.a(CardNewMsgUI.this).cwg()) && (CardNewMsgUI.e(CardNewMsgUI.this).getParent() == null) && (paramAnonymousInt > 0))
              {
                CardNewMsgUI.d(CardNewMsgUI.this).addFooterView(CardNewMsgUI.e(CardNewMsgUI.this));
                Log.i("MicroMsg.CardNewMsgUI", "add mLoadingFooterView");
              }
            }
            CardNewMsgUI.f(CardNewMsgUI.this);
            CardNewMsgUI.c(CardNewMsgUI.this).setVisibility(8);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(113520);
            return;
            paramAnonymousInt = CardNewMsgUI.a(CardNewMsgUI.this).cwh();
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
          if (am.ctS().ctM() > 0) {
            am.ctS().ctN();
          }
          for (;;)
          {
            CardNewMsgUI.a(CardNewMsgUI.this).onNotifyChange(null, null);
            AppMethodBeat.o(113522);
            return;
            CardNewMsgUI.a(CardNewMsgUI.this).cwh();
          }
        }
        AppMethodBeat.o(113522);
      }
    });
    this.qdk.a(new s.a()
    {
      public final void bnE()
      {
        AppMethodBeat.i(113523);
        CardNewMsgUI.g(CardNewMsgUI.this);
        if ((CardNewMsgUI.a(CardNewMsgUI.this).cwg()) && (am.ctS().ctM() == 0)) {
          CardNewMsgUI.c(CardNewMsgUI.this).setVisibility(8);
        }
        AppMethodBeat.o(113523);
      }
    });
    addTextOptionMenu(0, getString(2131756973), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(113524);
        com.tencent.mm.plugin.report.service.h.CyF.a(11582, new Object[] { "CardMsgClearMenu", Integer.valueOf(2), Integer.valueOf(0), "", "", "" });
        CardNewMsgUI.h(CardNewMsgUI.this);
        AppMethodBeat.o(113524);
        return true;
      }
    });
    this.GQ = findViewById(2131299212);
    cuE();
    this.qdl = aa.jQ(this).inflate(2131493413, null);
    this.qdm = aa.jQ(this).inflate(2131495522, null);
    int i = am.ctS().ctM();
    if (i > 0)
    {
      this.mListView.addFooterView(this.qdl);
      AppMethodBeat.o(113540);
      return;
    }
    if ((!this.qdk.cwg()) && (i == 0) && (am.ctS().getCount() > 0))
    {
      this.mListView.addFooterView(this.qdm);
      this.qdn = true;
      AppMethodBeat.o(113540);
      return;
    }
    if ((this.qdk.cwg()) && (i == 0)) {
      am.ctS().getCount();
    }
    AppMethodBeat.o(113540);
  }
  
  public final void onChange() {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113538);
    super.onCreate(paramBundle);
    initView();
    am.ctU().a(this);
    am.ctU().ctE();
    AppMethodBeat.o(113538);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113539);
    this.qdk.ebf();
    am.ctU().b(this);
    if (am.ctS().ctM() > 0) {
      am.ctS().ctN();
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
    extends s<g>
  {
    private int gAZ;
    private int qdp;
    
    public a()
    {
      super(new g());
      AppMethodBeat.i(113530);
      this.qdp = 10;
      this.gAZ = this.qdp;
      Bh(true);
      AppMethodBeat.o(113530);
    }
    
    private void a(List<g.a> paramList, List<g.b> paramList1, CardNewMsgUI.b paramb, final g paramg)
    {
      AppMethodBeat.i(113535);
      paramb.qdE.removeAllViews();
      if (((paramList == null) || (paramList.size() == 0)) && ((paramList1 == null) || (paramList1.size() == 0)))
      {
        paramb.qdF.setVisibility(8);
        AppMethodBeat.o(113535);
        return;
      }
      int i;
      Object localObject1;
      Object localObject2;
      if (!Util.isNullOrNil(paramList))
      {
        i = 0;
        if (i < paramList.size())
        {
          localObject1 = (g.a)paramList.get(i);
          localObject2 = View.inflate(CardNewMsgUI.this.getContext(), 2131493333, null);
          if (i == 0) {
            ((View)localObject2).findViewById(2131298016).setVisibility(8);
          }
          ((TextView)((View)localObject2).findViewById(2131298018)).setText(((g.a)localObject1).title);
          ((TextView)((View)localObject2).findViewById(2131298017)).setText(((g.a)localObject1).oqZ);
          Button localButton = (Button)((View)localObject2).findViewById(2131298015);
          localButton.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(113528);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
              paramAnonymousView = new Intent();
              if (this.qdq.pTI == 0)
              {
                paramAnonymousView.setClass(CardNewMsgUI.this.getContext(), CardDetailUI.class);
                paramAnonymousView.putExtra("key_card_id", this.qdq.cardId);
                paramAnonymousView.putExtra("key_card_ext", this.qdq.cardExt);
                paramAnonymousView.putExtra("key_from_scene", 17);
                localObject = CardNewMsgUI.this;
                paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.axQ(), "com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((CardNewMsgUI)localObject).startActivity((Intent)paramAnonymousView.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
              for (;;)
              {
                com.tencent.mm.plugin.report.service.h.CyF.a(11941, new Object[] { Integer.valueOf(8), paramg.field_card_id, paramg.field_card_tp_id, paramg.field_msg_id, this.qdq.cardId });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(113528);
                return;
                if (this.qdq.pTI == 1)
                {
                  paramAnonymousView.setClass(CardNewMsgUI.this.getContext(), CardConsumeSuccessUI.class);
                  paramAnonymousView.putExtra("key_card_id", paramg.field_card_id);
                  paramAnonymousView.putExtra("key_from_scene", 2);
                  localObject = CardNewMsgUI.this;
                  paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.axQ(), "com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  ((CardNewMsgUI)localObject).startActivity((Intent)paramAnonymousView.pG(0));
                  com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
              }
            }
          });
          if (((g.a)localObject1).pTI == 0) {
            localButton.setText(2131756949);
          }
          for (;;)
          {
            paramb.qdE.addView((View)localObject2);
            i += 1;
            break;
            if (((g.a)localObject1).pTI == 1) {
              localButton.setText(2131756950);
            }
          }
        }
      }
      if (!Util.isNullOrNil(paramList1))
      {
        i = 0;
        while (i < paramList1.size())
        {
          paramg = (g.b)paramList1.get(i);
          localObject1 = View.inflate(CardNewMsgUI.this.getContext(), 2131493333, null);
          if ((i == 0) && (Util.isNullOrNil(paramList))) {
            ((View)localObject1).findViewById(2131298016).setVisibility(8);
          }
          ((TextView)((View)localObject1).findViewById(2131298018)).setText(paramg.title);
          ((TextView)((View)localObject1).findViewById(2131298017)).setText(paramg.description);
          localObject2 = (Button)((View)localObject1).findViewById(2131298015);
          ((Button)localObject2).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(113529);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              if (!TextUtils.isEmpty(paramg.pTL)) {
                com.tencent.mm.plugin.card.d.b.a(CardNewMsgUI.this, paramg.pTL, 2);
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(113529);
                return;
                Log.e("MicroMsg.CardNewMsgUI", "card msg button url is empty");
              }
            }
          });
          ((Button)localObject2).setText(paramg.pTK);
          paramb.qdE.addView((View)localObject1);
          i += 1;
        }
      }
      paramb.qdF.setVisibility(0);
      AppMethodBeat.o(113535);
    }
    
    public final void anp()
    {
      AppMethodBeat.i(113531);
      if (am.ctS().ctM() > 0) {
        setCursor(am.ctS().db.rawQuery("select * from CardMsgInfo where read_state = ?  order by time desc", new String[] { "1" }));
      }
      for (;;)
      {
        notifyDataSetChanged();
        AppMethodBeat.o(113531);
        return;
        this.gAZ = am.ctS().getCount();
        com.tencent.mm.plugin.card.model.h localh = am.ctS();
        String str = "select * from CardMsgInfo order by time desc LIMIT ".concat(String.valueOf(this.qdp));
        setCursor(localh.db.rawQuery(str, null));
      }
    }
    
    public final void anq()
    {
      AppMethodBeat.i(113532);
      ebf();
      anp();
      AppMethodBeat.o(113532);
    }
    
    public final boolean cwg()
    {
      return this.qdp >= this.gAZ;
    }
    
    public final int cwh()
    {
      AppMethodBeat.i(113533);
      if (cwg())
      {
        if (CardNewMsgUI.e(CardNewMsgUI.this).getParent() != null) {
          CardNewMsgUI.d(CardNewMsgUI.this).removeFooterView(CardNewMsgUI.e(CardNewMsgUI.this));
        }
        AppMethodBeat.o(113533);
        return 0;
      }
      this.qdp += 10;
      if (this.qdp <= this.gAZ)
      {
        AppMethodBeat.o(113533);
        return 10;
      }
      this.qdp = this.gAZ;
      int i = this.gAZ;
      AppMethodBeat.o(113533);
      return i % 10;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(113534);
      g localg = (g)getItem(paramInt);
      int i;
      if (paramView == null)
      {
        paramView = View.inflate(CardNewMsgUI.this.getContext(), 2131493414, null);
        paramViewGroup = new CardNewMsgUI.b(CardNewMsgUI.this, (byte)0);
        paramViewGroup.qdu = ((ImageView)paramView.findViewById(2131303814));
        paramViewGroup.qdv = paramView.findViewById(2131298235);
        paramViewGroup.qdw = ((ImageView)paramView.findViewById(2131298234));
        paramViewGroup.qdx = ((TextView)paramView.findViewById(2131309249));
        paramViewGroup.qdy = ((TextView)paramView.findViewById(2131309101));
        paramViewGroup.qdz = ((TextView)paramView.findViewById(2131299513));
        paramViewGroup.qdA = ((TextView)paramView.findViewById(2131300268));
        paramViewGroup.qdB = ((TextView)paramView.findViewById(2131308339));
        paramViewGroup.qdC = paramView.findViewById(2131305638);
        paramViewGroup.qdD = ((TextView)paramView.findViewById(2131305639));
        paramViewGroup.qdE = ((LinearLayout)paramView.findViewById(2131296328));
        paramViewGroup.qdF = ((LinearLayout)paramView.findViewById(2131296329));
        paramView.setTag(paramViewGroup);
        paramViewGroup.qdx.setText(localg.field_title);
        long l = localg.field_time;
        paramViewGroup.qdy.setText(f.c(CardNewMsgUI.this, l * 1000L, true));
        paramViewGroup.qdz.setText(localg.field_description);
        i = CardNewMsgUI.this.getResources().getDimensionPixelSize(2131166023);
        Log.d("MicroMsg.CardNewMsgUI", "CardNewMsgUI getView () position : " + paramInt + " logo_url :  " + localg.field_logo_url);
        if (!TextUtils.isEmpty(localg.field_logo_color)) {
          break label558;
        }
        paramViewGroup.qdv.setVisibility(8);
        paramViewGroup.qdu.setVisibility(0);
        paramViewGroup.qdu.setImageResource(2131234198);
        n.a(paramViewGroup.qdu, localg.field_logo_url, i, 2131234198, true);
        label373:
        Object localObject = localg.ctH();
        if ((localObject == null) || (TextUtils.isEmpty(((tw)localObject).text))) {
          break label673;
        }
        paramViewGroup.qdA.setText(((tw)localObject).text);
        paramViewGroup.qdA.setTag(localg);
        paramViewGroup.qdA.setVisibility(0);
        paramViewGroup.qdA.setOnClickListener(CardNewMsgUI.this.kuO);
        label439:
        localObject = localg.ctI();
        if ((localObject == null) || (TextUtils.isEmpty(((uo)localObject).text))) {
          break label685;
        }
        paramViewGroup.qdD.setText(((uo)localObject).text);
        paramViewGroup.qdC.setVisibility(0);
        paramViewGroup.qdC.setOnClickListener(CardNewMsgUI.this.kuO);
        paramViewGroup.qdC.setTag(localg);
        paramViewGroup.qdB.setVisibility(0);
      }
      for (;;)
      {
        localg.ctJ();
        localg.ctK();
        a(localg.pTC, localg.pTD, paramViewGroup, localg);
        AppMethodBeat.o(113534);
        return paramView;
        paramViewGroup = (CardNewMsgUI.b)paramView.getTag();
        break;
        label558:
        Log.d("MicroMsg.CardNewMsgUI", "CardNewMsgUI getView () position : " + paramInt + " field_logo_color :  " + localg.field_logo_color);
        paramViewGroup.qdv.setVisibility(0);
        paramViewGroup.qdu.setVisibility(8);
        if (!TextUtils.isEmpty(localg.field_logo_url))
        {
          n.a(CardNewMsgUI.this, paramViewGroup.qdw, localg.field_logo_url, i, l.ake(localg.field_logo_color));
          break label373;
        }
        n.b(paramViewGroup.qdw, 2131231570, l.ake(localg.field_logo_color));
        break label373;
        label673:
        paramViewGroup.qdA.setVisibility(8);
        break label439;
        label685:
        paramViewGroup.qdC.setVisibility(8);
        paramViewGroup.qdB.setVisibility(8);
      }
    }
  }
  
  final class b
  {
    TextView qdA;
    TextView qdB;
    View qdC;
    TextView qdD;
    LinearLayout qdE;
    LinearLayout qdF;
    ImageView qdu;
    View qdv;
    ImageView qdw;
    TextView qdx;
    TextView qdy;
    TextView qdz;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardNewMsgUI
 * JD-Core Version:    0.7.0.1
 */