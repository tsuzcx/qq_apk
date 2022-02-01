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
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
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
import com.tencent.mm.pluginsdk.j.f;
import com.tencent.mm.protocal.protobuf.ty;
import com.tencent.mm.protocal.protobuf.uq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.v.a;
import java.util.ArrayList;
import java.util.List;

public class CardNewMsgUI
  extends MMActivity
  implements k.a
{
  private View Xd;
  private ListView mListView;
  View.OnClickListener nmC;
  private a tzh;
  private View tzi;
  private View tzj;
  private boolean tzk;
  
  public CardNewMsgUI()
  {
    AppMethodBeat.i(113537);
    this.tzj = null;
    this.tzk = false;
    this.nmC = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113527);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/CardNewMsgUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        if (paramAnonymousView.getId() == a.d.tfE)
        {
          paramAnonymousView = (g)paramAnonymousView.getTag();
          if ((paramAnonymousView == null) || (paramAnonymousView.cHj() == null))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(113527);
            return;
          }
          com.tencent.mm.plugin.report.service.h.IzE.a(11941, new Object[] { Integer.valueOf(2), paramAnonymousView.field_card_id, paramAnonymousView.field_card_tp_id, paramAnonymousView.field_msg_id, "" });
          if (paramAnonymousView.cHj().tpK == 0)
          {
            Log.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_BUTTON_TYPE_URL");
            if (!TextUtils.isEmpty(paramAnonymousView.cHj().url)) {
              com.tencent.mm.plugin.card.d.b.a(CardNewMsgUI.this, paramAnonymousView.cHj().url, 2);
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
          if (paramAnonymousView.cHj().tpK == 1)
          {
            Log.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_BUTTON_TYPE_SHOP");
            Object localObject2 = new Intent();
            ((Intent)localObject2).putExtra("KEY_CARD_ID", paramAnonymousView.field_card_id);
            ((Intent)localObject2).putExtra("KEY_CARD_TP_ID", paramAnonymousView.field_card_tp_id);
            ((Intent)localObject2).setClass(CardNewMsgUI.this, CardShopUI.class);
            localObject1 = CardNewMsgUI.this;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
            com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/card/ui/CardNewMsgUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((CardNewMsgUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.report.service.h.IzE.a(11324, new Object[] { "UsedStoresView", Integer.valueOf(paramAnonymousView.field_card_type), paramAnonymousView.field_card_tp_id, paramAnonymousView.field_card_id, Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "" });
            continue;
            if (paramAnonymousView.getId() == a.d.tgn)
            {
              paramAnonymousView = (g)paramAnonymousView.getTag();
              if ((paramAnonymousView == null) || (paramAnonymousView.cHk() == null))
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(113527);
                return;
              }
              if (paramAnonymousView.cHk().type == 0)
              {
                Log.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_OPERATION_REGION_TYPE_TEXT");
                if (!TextUtils.isEmpty(paramAnonymousView.cHk().url)) {
                  com.tencent.mm.plugin.card.d.b.a(CardNewMsgUI.this, paramAnonymousView.cHk().url, 2);
                } else {
                  Log.e("MicroMsg.CardNewMsgUI", "card msg oper region url is empty");
                }
              }
              else if (paramAnonymousView.cHk().type == 1)
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
  
  private void aP(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(113542);
    Intent localIntent = new Intent(this, CardDetailUI.class);
    localIntent.putExtra("key_card_id", paramString);
    localIntent.putExtra("key_is_share_card", paramBoolean);
    localIntent.putExtra("key_from_scene", 4);
    paramString = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aFh(), "com/tencent/mm/plugin/card/ui/CardNewMsgUI", "gotoCardDetailUI", "(Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/card/ui/CardNewMsgUI", "gotoCardDetailUI", "(Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(113542);
  }
  
  private void cIg()
  {
    AppMethodBeat.i(113541);
    if (am.cHw().getCount() > 0)
    {
      this.mListView.setVisibility(0);
      this.Xd.setVisibility(8);
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.tzh.notifyDataSetChanged();
      AppMethodBeat.o(113541);
      return;
      this.mListView.setVisibility(8);
      this.Xd.setVisibility(0);
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
    cIg();
    this.tzh.onNotifyChange(null, null);
    AppMethodBeat.o(113543);
  }
  
  public int getLayoutId()
  {
    return a.e.tiX;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113540);
    setMMTitle(a.g.tlg);
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
    this.mListView = ((ListView)findViewById(a.d.tcU));
    this.tzh = new a();
    this.mListView.setAdapter(this.tzh);
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(113520);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/CardNewMsgUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
        if (paramAnonymousInt == CardNewMsgUI.a(CardNewMsgUI.this).getCount())
        {
          paramAnonymousInt = 1;
          if (am.cHu().cHo() > 0) {
            am.cHu().cHp();
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
              if ((!CardNewMsgUI.a(CardNewMsgUI.this).cJI()) && (CardNewMsgUI.e(CardNewMsgUI.this).getParent() == null) && (paramAnonymousInt > 0))
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
            paramAnonymousInt = CardNewMsgUI.a(CardNewMsgUI.this).cJJ();
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
          if (am.cHu().cHo() > 0) {
            am.cHu().cHp();
          }
          for (;;)
          {
            CardNewMsgUI.a(CardNewMsgUI.this).onNotifyChange(null, null);
            AppMethodBeat.o(113522);
            return;
            CardNewMsgUI.a(CardNewMsgUI.this).cJJ();
          }
        }
        AppMethodBeat.o(113522);
      }
    });
    this.tzh.a(new v.a()
    {
      public final void bxN()
      {
        AppMethodBeat.i(113523);
        CardNewMsgUI.g(CardNewMsgUI.this);
        if ((CardNewMsgUI.a(CardNewMsgUI.this).cJI()) && (am.cHu().cHo() == 0)) {
          CardNewMsgUI.c(CardNewMsgUI.this).setVisibility(8);
        }
        AppMethodBeat.o(113523);
      }
    });
    addTextOptionMenu(0, getString(a.g.card_clear), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(113524);
        com.tencent.mm.plugin.report.service.h.IzE.a(11582, new Object[] { "CardMsgClearMenu", Integer.valueOf(2), Integer.valueOf(0), "", "", "" });
        CardNewMsgUI.h(CardNewMsgUI.this);
        AppMethodBeat.o(113524);
        return true;
      }
    });
    this.Xd = findViewById(a.d.tfq);
    cIg();
    this.tzi = ad.kS(this).inflate(a.e.tiU, null);
    this.tzj = ad.kS(this).inflate(a.e.mm_footerview, null);
    int i = am.cHu().cHo();
    if (i > 0)
    {
      this.mListView.addFooterView(this.tzi);
      AppMethodBeat.o(113540);
      return;
    }
    if ((!this.tzh.cJI()) && (i == 0) && (am.cHu().getCount() > 0))
    {
      this.mListView.addFooterView(this.tzj);
      this.tzk = true;
      AppMethodBeat.o(113540);
      return;
    }
    if ((this.tzh.cJI()) && (i == 0)) {
      am.cHu().getCount();
    }
    AppMethodBeat.o(113540);
  }
  
  public final void onChange() {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113538);
    super.onCreate(paramBundle);
    initView();
    am.cHw().a(this);
    am.cHw().cHg();
    AppMethodBeat.o(113538);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113539);
    this.tzh.eKd();
    am.cHw().b(this);
    if (am.cHu().cHo() > 0) {
      am.cHu().cHp();
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
    extends v<g>
  {
    private int jlf;
    private int tzm;
    
    public a()
    {
      super(new g());
      AppMethodBeat.i(113530);
      this.tzm = 10;
      this.jlf = this.tzm;
      Fx(true);
      AppMethodBeat.o(113530);
    }
    
    private void a(List<g.a> paramList, List<g.b> paramList1, CardNewMsgUI.b paramb, final g paramg)
    {
      AppMethodBeat.i(113535);
      paramb.tzB.removeAllViews();
      if (((paramList == null) || (paramList.size() == 0)) && ((paramList1 == null) || (paramList1.size() == 0)))
      {
        paramb.tzC.setVisibility(8);
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
          localObject2 = View.inflate(CardNewMsgUI.this.getContext(), a.e.thH, null);
          if (i == 0) {
            ((View)localObject2).findViewById(a.d.taT).setVisibility(8);
          }
          ((TextView)((View)localObject2).findViewById(a.d.taV)).setText(((g.a)localObject1).title);
          ((TextView)((View)localObject2).findViewById(a.d.taU)).setText(((g.a)localObject1).rsw);
          Button localButton = (Button)((View)localObject2).findViewById(a.d.taS);
          localButton.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(113528);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
              paramAnonymousView = new Intent();
              if (this.tzn.tpK == 0)
              {
                paramAnonymousView.setClass(CardNewMsgUI.this.getContext(), CardDetailUI.class);
                paramAnonymousView.putExtra("key_card_id", this.tzn.cardId);
                paramAnonymousView.putExtra("key_card_ext", this.tzn.tpJ);
                paramAnonymousView.putExtra("key_from_scene", 17);
                localObject = CardNewMsgUI.this;
                paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aFh(), "com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((CardNewMsgUI)localObject).startActivity((Intent)paramAnonymousView.sf(0));
                com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
              for (;;)
              {
                com.tencent.mm.plugin.report.service.h.IzE.a(11941, new Object[] { Integer.valueOf(8), paramg.field_card_id, paramg.field_card_tp_id, paramg.field_msg_id, this.tzn.cardId });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(113528);
                return;
                if (this.tzn.tpK == 1)
                {
                  paramAnonymousView.setClass(CardNewMsgUI.this.getContext(), CardConsumeSuccessUI.class);
                  paramAnonymousView.putExtra("key_card_id", paramg.field_card_id);
                  paramAnonymousView.putExtra("key_from_scene", 2);
                  localObject = CardNewMsgUI.this;
                  paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aFh(), "com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  ((CardNewMsgUI)localObject).startActivity((Intent)paramAnonymousView.sf(0));
                  com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
              }
            }
          });
          if (((g.a)localObject1).tpK == 0) {
            localButton.setText(a.g.taV);
          }
          for (;;)
          {
            paramb.tzB.addView((View)localObject2);
            i += 1;
            break;
            if (((g.a)localObject1).tpK == 1) {
              localButton.setText(a.g.tju);
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
          localObject1 = View.inflate(CardNewMsgUI.this.getContext(), a.e.thH, null);
          if ((i == 0) && (Util.isNullOrNil(paramList))) {
            ((View)localObject1).findViewById(a.d.taT).setVisibility(8);
          }
          ((TextView)((View)localObject1).findViewById(a.d.taV)).setText(paramg.title);
          ((TextView)((View)localObject1).findViewById(a.d.taU)).setText(paramg.description);
          localObject2 = (Button)((View)localObject1).findViewById(a.d.taS);
          ((Button)localObject2).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(113529);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              if (!TextUtils.isEmpty(paramg.jump_url)) {
                com.tencent.mm.plugin.card.d.b.a(CardNewMsgUI.this, paramg.jump_url, 2);
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
          ((Button)localObject2).setText(paramg.tpM);
          paramb.tzB.addView((View)localObject1);
          i += 1;
        }
      }
      paramb.tzC.setVisibility(0);
      AppMethodBeat.o(113535);
    }
    
    public final void atr()
    {
      AppMethodBeat.i(113531);
      if (am.cHu().cHo() > 0) {
        v(am.cHu().db.rawQuery("select * from CardMsgInfo where read_state = ?  order by time desc", new String[] { "1" }));
      }
      for (;;)
      {
        notifyDataSetChanged();
        AppMethodBeat.o(113531);
        return;
        this.jlf = am.cHu().getCount();
        com.tencent.mm.plugin.card.model.h localh = am.cHu();
        String str = "select * from CardMsgInfo order by time desc LIMIT ".concat(String.valueOf(this.tzm));
        v(localh.db.rawQuery(str, null));
      }
    }
    
    public final void ats()
    {
      AppMethodBeat.i(113532);
      eKd();
      atr();
      AppMethodBeat.o(113532);
    }
    
    public final boolean cJI()
    {
      return this.tzm >= this.jlf;
    }
    
    public final int cJJ()
    {
      AppMethodBeat.i(113533);
      if (cJI())
      {
        if (CardNewMsgUI.e(CardNewMsgUI.this).getParent() != null) {
          CardNewMsgUI.d(CardNewMsgUI.this).removeFooterView(CardNewMsgUI.e(CardNewMsgUI.this));
        }
        AppMethodBeat.o(113533);
        return 0;
      }
      this.tzm += 10;
      if (this.tzm <= this.jlf)
      {
        AppMethodBeat.o(113533);
        return 10;
      }
      this.tzm = this.jlf;
      int i = this.jlf;
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
        paramView = View.inflate(CardNewMsgUI.this.getContext(), a.e.tiV, null);
        paramViewGroup = new CardNewMsgUI.b(CardNewMsgUI.this, (byte)0);
        paramViewGroup.tzr = ((ImageView)paramView.findViewById(a.d.logo));
        paramViewGroup.tzs = paramView.findViewById(a.d.tdI);
        paramViewGroup.tzt = ((ImageView)paramView.findViewById(a.d.tdH));
        paramViewGroup.tzu = ((TextView)paramView.findViewById(a.d.title_tv));
        paramViewGroup.tzv = ((TextView)paramView.findViewById(a.d.time_tv));
        paramViewGroup.tzw = ((TextView)paramView.findViewById(a.d.description_tv));
        paramViewGroup.tzx = ((TextView)paramView.findViewById(a.d.tfE));
        paramViewGroup.tzy = ((TextView)paramView.findViewById(a.d.split_line));
        paramViewGroup.tzz = paramView.findViewById(a.d.tgn);
        paramViewGroup.tzA = ((TextView)paramView.findViewById(a.d.tgo));
        paramViewGroup.tzB = ((LinearLayout)paramView.findViewById(a.d.taw));
        paramViewGroup.tzC = ((LinearLayout)paramView.findViewById(a.d.tax));
        paramView.setTag(paramViewGroup);
        paramViewGroup.tzu.setText(localg.field_title);
        long l = localg.field_time;
        paramViewGroup.tzv.setText(f.d(CardNewMsgUI.this, l * 1000L, true));
        paramViewGroup.tzw.setText(localg.field_description);
        i = CardNewMsgUI.this.getResources().getDimensionPixelSize(a.b.sZV);
        Log.d("MicroMsg.CardNewMsgUI", "CardNewMsgUI getView () position : " + paramInt + " logo_url :  " + localg.field_logo_url);
        if (!TextUtils.isEmpty(localg.field_logo_color)) {
          break label562;
        }
        paramViewGroup.tzs.setVisibility(8);
        paramViewGroup.tzr.setVisibility(0);
        paramViewGroup.tzr.setImageResource(a.c.my_card_package_defaultlogo);
        n.a(paramViewGroup.tzr, localg.field_logo_url, i, a.c.my_card_package_defaultlogo, true);
        label376:
        Object localObject = localg.cHj();
        if ((localObject == null) || (TextUtils.isEmpty(((ty)localObject).text))) {
          break label680;
        }
        paramViewGroup.tzx.setText(((ty)localObject).text);
        paramViewGroup.tzx.setTag(localg);
        paramViewGroup.tzx.setVisibility(0);
        paramViewGroup.tzx.setOnClickListener(CardNewMsgUI.this.nmC);
        label442:
        localObject = localg.cHk();
        if ((localObject == null) || (TextUtils.isEmpty(((uq)localObject).text))) {
          break label692;
        }
        paramViewGroup.tzA.setText(((uq)localObject).text);
        paramViewGroup.tzz.setVisibility(0);
        paramViewGroup.tzz.setOnClickListener(CardNewMsgUI.this.nmC);
        paramViewGroup.tzz.setTag(localg);
        paramViewGroup.tzy.setVisibility(0);
      }
      for (;;)
      {
        localg.cHl();
        localg.cHm();
        a(localg.tpD, localg.tpE, paramViewGroup, localg);
        AppMethodBeat.o(113534);
        return paramView;
        paramViewGroup = (CardNewMsgUI.b)paramView.getTag();
        break;
        label562:
        Log.d("MicroMsg.CardNewMsgUI", "CardNewMsgUI getView () position : " + paramInt + " field_logo_color :  " + localg.field_logo_color);
        paramViewGroup.tzs.setVisibility(0);
        paramViewGroup.tzr.setVisibility(8);
        if (!TextUtils.isEmpty(localg.field_logo_url))
        {
          n.a(CardNewMsgUI.this, paramViewGroup.tzt, localg.field_logo_url, i, a.c.tan, l.arR(localg.field_logo_color));
          break label376;
        }
        n.b(paramViewGroup.tzt, a.c.tan, l.arR(localg.field_logo_color));
        break label376;
        label680:
        paramViewGroup.tzx.setVisibility(8);
        break label442;
        label692:
        paramViewGroup.tzz.setVisibility(8);
        paramViewGroup.tzy.setVisibility(8);
      }
    }
  }
  
  final class b
  {
    TextView tzA;
    LinearLayout tzB;
    LinearLayout tzC;
    ImageView tzr;
    View tzs;
    ImageView tzt;
    TextView tzu;
    TextView tzv;
    TextView tzw;
    TextView tzx;
    TextView tzy;
    View tzz;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardNewMsgUI
 * JD-Core Version:    0.7.0.1
 */