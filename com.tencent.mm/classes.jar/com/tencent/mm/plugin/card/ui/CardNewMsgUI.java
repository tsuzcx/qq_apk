package com.tencent.mm.plugin.card.ui;

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
import com.tencent.mm.plugin.card.c.d.a;
import com.tencent.mm.plugin.card.c.l;
import com.tencent.mm.plugin.card.c.n;
import com.tencent.mm.plugin.card.mgr.j;
import com.tencent.mm.plugin.card.mgr.j.a;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.plugin.card.model.g.a;
import com.tencent.mm.plugin.card.model.g.b;
import com.tencent.mm.plugin.card.sharecard.ui.CardConsumeSuccessUI;
import com.tencent.mm.pluginsdk.platformtools.f;
import com.tencent.mm.protocal.protobuf.vp;
import com.tencent.mm.protocal.protobuf.wh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.k.d;
import com.tencent.mm.ui.x;
import com.tencent.mm.ui.x.a;
import java.util.ArrayList;
import java.util.List;

public class CardNewMsgUI
  extends MMActivity
  implements j.a
{
  private View bEx;
  private ListView mListView;
  View.OnClickListener qjL;
  private View uiF;
  private a wDE;
  private View wDF;
  private boolean wDG;
  
  public CardNewMsgUI()
  {
    AppMethodBeat.i(113537);
    this.wDF = null;
    this.wDG = false;
    this.qjL = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113527);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/CardNewMsgUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
        if (paramAnonymousView.getId() == a.d.wka)
        {
          paramAnonymousView = (g)paramAnonymousView.getTag();
          if ((paramAnonymousView == null) || (paramAnonymousView.dkA() == null))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(113527);
            return;
          }
          com.tencent.mm.plugin.report.service.h.OAn.b(11941, new Object[] { Integer.valueOf(2), paramAnonymousView.field_card_id, paramAnonymousView.field_card_tp_id, paramAnonymousView.field_msg_id, "" });
          if (paramAnonymousView.dkA().wuj == 0)
          {
            Log.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_BUTTON_TYPE_URL");
            if (!TextUtils.isEmpty(paramAnonymousView.dkA().url)) {
              com.tencent.mm.plugin.card.c.b.a(CardNewMsgUI.this, paramAnonymousView.dkA().url, 2);
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
          if (paramAnonymousView.dkA().wuj == 1)
          {
            Log.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_BUTTON_TYPE_SHOP");
            Object localObject2 = new Intent();
            ((Intent)localObject2).putExtra("KEY_CARD_ID", paramAnonymousView.field_card_id);
            ((Intent)localObject2).putExtra("KEY_CARD_TP_ID", paramAnonymousView.field_card_tp_id);
            ((Intent)localObject2).setClass(CardNewMsgUI.this, CardShopUI.class);
            localObject1 = CardNewMsgUI.this;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
            com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/card/ui/CardNewMsgUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((CardNewMsgUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.report.service.h.OAn.b(11324, new Object[] { "UsedStoresView", Integer.valueOf(paramAnonymousView.field_card_type), paramAnonymousView.field_card_tp_id, paramAnonymousView.field_card_id, Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "" });
            continue;
            if (paramAnonymousView.getId() == a.d.wkJ)
            {
              paramAnonymousView = (g)paramAnonymousView.getTag();
              if ((paramAnonymousView == null) || (paramAnonymousView.dkB() == null))
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(113527);
                return;
              }
              if (paramAnonymousView.dkB().type == 0)
              {
                Log.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_OPERATION_REGION_TYPE_TEXT");
                if (!TextUtils.isEmpty(paramAnonymousView.dkB().url)) {
                  com.tencent.mm.plugin.card.c.b.a(CardNewMsgUI.this, paramAnonymousView.dkB().url, 2);
                } else {
                  Log.e("MicroMsg.CardNewMsgUI", "card msg oper region url is empty");
                }
              }
              else if (paramAnonymousView.dkB().type == 1)
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
  
  private void bb(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(113542);
    Intent localIntent = new Intent(this, CardDetailUI.class);
    localIntent.putExtra("key_card_id", paramString);
    localIntent.putExtra("key_is_share_card", paramBoolean);
    localIntent.putExtra("key_from_scene", 4);
    paramString = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aYi(), "com/tencent/mm/plugin/card/ui/CardNewMsgUI", "gotoCardDetailUI", "(Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/card/ui/CardNewMsgUI", "gotoCardDetailUI", "(Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(113542);
  }
  
  private void dlx()
  {
    AppMethodBeat.i(113541);
    if (am.dkN().getCount() > 0)
    {
      this.mListView.setVisibility(0);
      this.bEx.setVisibility(8);
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.wDE.notifyDataSetChanged();
      AppMethodBeat.o(113541);
      return;
      this.mListView.setVisibility(8);
      this.bEx.setVisibility(0);
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
    dlx();
    this.wDE.onNotifyChange(null, null);
    AppMethodBeat.o(113543);
  }
  
  public int getLayoutId()
  {
    return a.e.wnu;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113540);
    setMMTitle(a.g.wpF);
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
    this.mListView = ((ListView)findViewById(a.d.whi));
    this.wDE = new a();
    this.mListView.setAdapter(this.wDE);
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(113520);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/CardNewMsgUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        if (paramAnonymousInt == CardNewMsgUI.a(CardNewMsgUI.this).getCount())
        {
          paramAnonymousInt = 1;
          if (am.dkL().dkF() > 0) {
            am.dkL().dkG();
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
              if ((!CardNewMsgUI.a(CardNewMsgUI.this).dmY()) && (CardNewMsgUI.e(CardNewMsgUI.this).getParent() == null) && (paramAnonymousInt > 0))
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
            paramAnonymousInt = CardNewMsgUI.a(CardNewMsgUI.this).dmZ();
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
          if (am.dkL().dkF() > 0) {
            am.dkL().dkG();
          }
          for (;;)
          {
            CardNewMsgUI.a(CardNewMsgUI.this).onNotifyChange(null, null);
            AppMethodBeat.o(113522);
            return;
            CardNewMsgUI.a(CardNewMsgUI.this).dmZ();
          }
        }
        AppMethodBeat.o(113522);
      }
    });
    this.wDE.a(new x.a()
    {
      public final void bWC()
      {
        AppMethodBeat.i(113523);
        CardNewMsgUI.g(CardNewMsgUI.this);
        if ((CardNewMsgUI.a(CardNewMsgUI.this).dmY()) && (am.dkL().dkF() == 0)) {
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
        com.tencent.mm.plugin.report.service.h.OAn.b(11582, new Object[] { "CardMsgClearMenu", Integer.valueOf(2), Integer.valueOf(0), "", "", "" });
        CardNewMsgUI.h(CardNewMsgUI.this);
        AppMethodBeat.o(113524);
        return true;
      }
    });
    this.bEx = findViewById(a.d.wjH);
    dlx();
    this.uiF = af.mU(this).inflate(a.e.wnr, null);
    this.wDF = af.mU(this).inflate(a.e.mm_footerview, null);
    int i = am.dkL().dkF();
    if (i > 0)
    {
      this.mListView.addFooterView(this.uiF);
      AppMethodBeat.o(113540);
      return;
    }
    if ((!this.wDE.dmY()) && (i == 0) && (am.dkL().getCount() > 0))
    {
      this.mListView.addFooterView(this.wDF);
      this.wDG = true;
      AppMethodBeat.o(113540);
      return;
    }
    if ((this.wDE.dmY()) && (i == 0)) {
      am.dkL().getCount();
    }
    AppMethodBeat.o(113540);
  }
  
  public final void onChange() {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113538);
    super.onCreate(paramBundle);
    initView();
    am.dkN().a(this);
    am.dkN().dkx();
    AppMethodBeat.o(113538);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113539);
    this.wDE.fSd();
    am.dkN().b(this);
    if (am.dkL().dkF() > 0) {
      am.dkL().dkG();
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
    extends x<g>
  {
    private int lNX;
    private int wDI;
    
    public a()
    {
      super(new g());
      AppMethodBeat.i(113530);
      this.wDI = 10;
      this.lNX = this.wDI;
      Lh(true);
      AppMethodBeat.o(113530);
    }
    
    private void a(List<g.a> paramList, List<g.b> paramList1, CardNewMsgUI.b paramb, final g paramg)
    {
      AppMethodBeat.i(113535);
      paramb.wDX.removeAllViews();
      if (((paramList == null) || (paramList.size() == 0)) && ((paramList1 == null) || (paramList1.size() == 0)))
      {
        paramb.wDY.setVisibility(8);
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
          localObject2 = View.inflate(CardNewMsgUI.this.getContext(), a.e.wmg, null);
          if (i == 0) {
            ((View)localObject2).findViewById(a.d.wfd).setVisibility(8);
          }
          ((TextView)((View)localObject2).findViewById(a.d.wff)).setText(((g.a)localObject1).title);
          ((TextView)((View)localObject2).findViewById(a.d.wfe)).setText(((g.a)localObject1).uCW);
          Button localButton = (Button)((View)localObject2).findViewById(a.d.wfc);
          localButton.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(113528);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
              paramAnonymousView = new Intent();
              if (this.wDJ.wuj == 0)
              {
                paramAnonymousView.setClass(CardNewMsgUI.this.getContext(), CardDetailUI.class);
                paramAnonymousView.putExtra("key_card_id", this.wDJ.cardId);
                paramAnonymousView.putExtra("key_card_ext", this.wDJ.wui);
                paramAnonymousView.putExtra("key_from_scene", 17);
                localObject = CardNewMsgUI.this;
                paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aYi(), "com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((CardNewMsgUI)localObject).startActivity((Intent)paramAnonymousView.sb(0));
                com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
              for (;;)
              {
                com.tencent.mm.plugin.report.service.h.OAn.b(11941, new Object[] { Integer.valueOf(8), paramg.field_card_id, paramg.field_card_tp_id, paramg.field_msg_id, this.wDJ.cardId });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(113528);
                return;
                if (this.wDJ.wuj == 1)
                {
                  paramAnonymousView.setClass(CardNewMsgUI.this.getContext(), CardConsumeSuccessUI.class);
                  paramAnonymousView.putExtra("key_card_id", paramg.field_card_id);
                  paramAnonymousView.putExtra("key_from_scene", 2);
                  localObject = CardNewMsgUI.this;
                  paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aYi(), "com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  ((CardNewMsgUI)localObject).startActivity((Intent)paramAnonymousView.sb(0));
                  com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
              }
            }
          });
          if (((g.a)localObject1).wuj == 0) {
            localButton.setText(a.g.wff);
          }
          for (;;)
          {
            paramb.wDX.addView((View)localObject2);
            i += 1;
            break;
            if (((g.a)localObject1).wuj == 1) {
              localButton.setText(a.g.wnR);
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
          localObject1 = View.inflate(CardNewMsgUI.this.getContext(), a.e.wmg, null);
          if ((i == 0) && (Util.isNullOrNil(paramList))) {
            ((View)localObject1).findViewById(a.d.wfd).setVisibility(8);
          }
          ((TextView)((View)localObject1).findViewById(a.d.wff)).setText(paramg.title);
          ((TextView)((View)localObject1).findViewById(a.d.wfe)).setText(paramg.description);
          localObject2 = (Button)((View)localObject1).findViewById(a.d.wfc);
          ((Button)localObject2).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(113529);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              if (!TextUtils.isEmpty(paramg.jump_url)) {
                com.tencent.mm.plugin.card.c.b.a(CardNewMsgUI.this, paramg.jump_url, 2);
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
          ((Button)localObject2).setText(paramg.wul);
          paramb.wDX.addView((View)localObject1);
          i += 1;
        }
      }
      paramb.wDY.setVisibility(0);
      AppMethodBeat.o(113535);
    }
    
    public final void aNy()
    {
      AppMethodBeat.i(113531);
      if (am.dkL().dkF() > 0) {
        w(am.dkL().db.rawQuery("select * from CardMsgInfo where read_state = ?  order by time desc", new String[] { "1" }));
      }
      for (;;)
      {
        notifyDataSetChanged();
        AppMethodBeat.o(113531);
        return;
        this.lNX = am.dkL().getCount();
        com.tencent.mm.plugin.card.model.h localh = am.dkL();
        String str = "select * from CardMsgInfo order by time desc LIMIT ".concat(String.valueOf(this.wDI));
        w(localh.db.rawQuery(str, null));
      }
    }
    
    public final void aNz()
    {
      AppMethodBeat.i(113532);
      fSd();
      aNy();
      AppMethodBeat.o(113532);
    }
    
    public final boolean dmY()
    {
      return this.wDI >= this.lNX;
    }
    
    public final int dmZ()
    {
      AppMethodBeat.i(113533);
      if (dmY())
      {
        if (CardNewMsgUI.e(CardNewMsgUI.this).getParent() != null) {
          CardNewMsgUI.d(CardNewMsgUI.this).removeFooterView(CardNewMsgUI.e(CardNewMsgUI.this));
        }
        AppMethodBeat.o(113533);
        return 0;
      }
      this.wDI += 10;
      if (this.wDI <= this.lNX)
      {
        AppMethodBeat.o(113533);
        return 10;
      }
      this.wDI = this.lNX;
      int i = this.lNX;
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
        paramView = View.inflate(CardNewMsgUI.this.getContext(), a.e.wns, null);
        paramViewGroup = new CardNewMsgUI.b(CardNewMsgUI.this, (byte)0);
        paramViewGroup.wDN = ((ImageView)paramView.findViewById(a.d.logo));
        paramViewGroup.wDO = paramView.findViewById(a.d.whW);
        paramViewGroup.wDP = ((ImageView)paramView.findViewById(a.d.whV));
        paramViewGroup.wDQ = ((TextView)paramView.findViewById(a.d.title_tv));
        paramViewGroup.wDR = ((TextView)paramView.findViewById(a.d.time_tv));
        paramViewGroup.wDS = ((TextView)paramView.findViewById(a.d.description_tv));
        paramViewGroup.wDT = ((TextView)paramView.findViewById(a.d.wka));
        paramViewGroup.wDU = ((TextView)paramView.findViewById(a.d.split_line));
        paramViewGroup.wDV = paramView.findViewById(a.d.wkJ);
        paramViewGroup.wDW = ((TextView)paramView.findViewById(a.d.wkK));
        paramViewGroup.wDX = ((LinearLayout)paramView.findViewById(a.d.weF));
        paramViewGroup.wDY = ((LinearLayout)paramView.findViewById(a.d.weG));
        paramView.setTag(paramViewGroup);
        paramViewGroup.wDQ.setText(localg.field_title);
        long l = localg.field_time;
        paramViewGroup.wDR.setText(f.d(CardNewMsgUI.this, l * 1000L, true));
        paramViewGroup.wDS.setText(localg.field_description);
        i = CardNewMsgUI.this.getResources().getDimensionPixelSize(a.b.wec);
        Log.d("MicroMsg.CardNewMsgUI", "CardNewMsgUI getView () position : " + paramInt + " logo_url :  " + localg.field_logo_url);
        if (!TextUtils.isEmpty(localg.field_logo_color)) {
          break label562;
        }
        paramViewGroup.wDO.setVisibility(8);
        paramViewGroup.wDN.setVisibility(0);
        paramViewGroup.wDN.setImageResource(a.c.my_card_package_defaultlogo);
        n.a(paramViewGroup.wDN, localg.field_logo_url, i, a.c.my_card_package_defaultlogo, true);
        label376:
        Object localObject = localg.dkA();
        if ((localObject == null) || (TextUtils.isEmpty(((vp)localObject).text))) {
          break label680;
        }
        paramViewGroup.wDT.setText(((vp)localObject).text);
        paramViewGroup.wDT.setTag(localg);
        paramViewGroup.wDT.setVisibility(0);
        paramViewGroup.wDT.setOnClickListener(CardNewMsgUI.this.qjL);
        label442:
        localObject = localg.dkB();
        if ((localObject == null) || (TextUtils.isEmpty(((wh)localObject).text))) {
          break label692;
        }
        paramViewGroup.wDW.setText(((wh)localObject).text);
        paramViewGroup.wDV.setVisibility(0);
        paramViewGroup.wDV.setOnClickListener(CardNewMsgUI.this.qjL);
        paramViewGroup.wDV.setTag(localg);
        paramViewGroup.wDU.setVisibility(0);
      }
      for (;;)
      {
        localg.dkC();
        localg.dkD();
        a(localg.wuc, localg.wud, paramViewGroup, localg);
        AppMethodBeat.o(113534);
        return paramView;
        paramViewGroup = (CardNewMsgUI.b)paramView.getTag();
        break;
        label562:
        Log.d("MicroMsg.CardNewMsgUI", "CardNewMsgUI getView () position : " + paramInt + " field_logo_color :  " + localg.field_logo_color);
        paramViewGroup.wDO.setVisibility(0);
        paramViewGroup.wDN.setVisibility(8);
        if (!TextUtils.isEmpty(localg.field_logo_url))
        {
          n.a(CardNewMsgUI.this, paramViewGroup.wDP, localg.field_logo_url, i, a.c.wev, l.alv(localg.field_logo_color));
          break label376;
        }
        n.b(paramViewGroup.wDP, a.c.wev, l.alv(localg.field_logo_color));
        break label376;
        label680:
        paramViewGroup.wDT.setVisibility(8);
        break label442;
        label692:
        paramViewGroup.wDV.setVisibility(8);
        paramViewGroup.wDU.setVisibility(8);
      }
    }
  }
  
  final class b
  {
    ImageView wDN;
    View wDO;
    ImageView wDP;
    TextView wDQ;
    TextView wDR;
    TextView wDS;
    TextView wDT;
    TextView wDU;
    View wDV;
    TextView wDW;
    LinearLayout wDX;
    LinearLayout wDY;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardNewMsgUI
 * JD-Core Version:    0.7.0.1
 */