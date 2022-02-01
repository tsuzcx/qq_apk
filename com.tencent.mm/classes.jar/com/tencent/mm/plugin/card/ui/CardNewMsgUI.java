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
import com.tencent.mm.protocal.protobuf.sp;
import com.tencent.mm.protocal.protobuf.th;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  View.OnClickListener jtG;
  private ListView mListView;
  private a oIU;
  private View oIV;
  private View oIW;
  private boolean oIX;
  
  public CardNewMsgUI()
  {
    AppMethodBeat.i(113537);
    this.oIW = null;
    this.oIX = false;
    this.jtG = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113527);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardNewMsgUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        if (paramAnonymousView.getId() == 2131299634)
        {
          paramAnonymousView = (com.tencent.mm.plugin.card.model.g)paramAnonymousView.getTag();
          if ((paramAnonymousView == null) || (paramAnonymousView.bUE() == null))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(113527);
            return;
          }
          com.tencent.mm.plugin.report.service.g.yhR.f(11941, new Object[] { Integer.valueOf(2), paramAnonymousView.field_card_id, paramAnonymousView.field_card_tp_id, paramAnonymousView.field_msg_id, "" });
          if (paramAnonymousView.bUE().ozA == 0)
          {
            ad.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_BUTTON_TYPE_URL");
            if (!TextUtils.isEmpty(paramAnonymousView.bUE().url)) {
              com.tencent.mm.plugin.card.d.b.a(CardNewMsgUI.this, paramAnonymousView.bUE().url, 2);
            }
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113527);
          return;
          ad.e("MicroMsg.CardNewMsgUI", "card msg button url is empty");
          continue;
          if (paramAnonymousView.bUE().ozA == 1)
          {
            ad.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_BUTTON_TYPE_SHOP");
            Object localObject2 = new Intent();
            ((Intent)localObject2).putExtra("KEY_CARD_ID", paramAnonymousView.field_card_id);
            ((Intent)localObject2).putExtra("KEY_CARD_TP_ID", paramAnonymousView.field_card_tp_id);
            ((Intent)localObject2).setClass(CardNewMsgUI.this, CardShopUI.class);
            localObject1 = CardNewMsgUI.this;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/card/ui/CardNewMsgUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((CardNewMsgUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.report.service.g.yhR.f(11324, new Object[] { "UsedStoresView", Integer.valueOf(paramAnonymousView.field_card_type), paramAnonymousView.field_card_tp_id, paramAnonymousView.field_card_id, Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "" });
            continue;
            if (paramAnonymousView.getId() == 2131303035)
            {
              paramAnonymousView = (com.tencent.mm.plugin.card.model.g)paramAnonymousView.getTag();
              if ((paramAnonymousView == null) || (paramAnonymousView.bUF() == null))
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(113527);
                return;
              }
              if (paramAnonymousView.bUF().type == 0)
              {
                ad.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_OPERATION_REGION_TYPE_TEXT");
                if (!TextUtils.isEmpty(paramAnonymousView.bUF().url)) {
                  com.tencent.mm.plugin.card.d.b.a(CardNewMsgUI.this, paramAnonymousView.bUF().url, 2);
                } else {
                  ad.e("MicroMsg.CardNewMsgUI", "card msg oper region url is empty");
                }
              }
              else if (paramAnonymousView.bUF().type == 1)
              {
                ad.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_OPERATION_REGION_TYPE_CARDS");
              }
            }
          }
        }
      }
    };
    AppMethodBeat.o(113537);
  }
  
  private void aI(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(113542);
    Intent localIntent = new Intent(this, CardDetailUI.class);
    localIntent.putExtra("key_card_id", paramString);
    localIntent.putExtra("key_is_share_card", paramBoolean);
    localIntent.putExtra("key_from_scene", 4);
    paramString = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahp(), "com/tencent/mm/plugin/card/ui/CardNewMsgUI", "gotoCardDetailUI", "(Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardNewMsgUI", "gotoCardDetailUI", "(Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(113542);
  }
  
  private void bVy()
  {
    AppMethodBeat.i(113541);
    if (am.bUR().getCount() > 0)
    {
      this.mListView.setVisibility(0);
      this.GG.setVisibility(8);
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.oIU.notifyDataSetChanged();
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
    bVy();
    this.oIU.a(null, null);
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
    this.oIU = new a();
    this.mListView.setAdapter(this.oIU);
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(113520);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardNewMsgUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        if (paramAnonymousInt == CardNewMsgUI.a(CardNewMsgUI.this).getCount())
        {
          paramAnonymousInt = 1;
          if (am.bUP().bUJ() > 0) {
            am.bUP().bUK();
          }
          for (;;)
          {
            CardNewMsgUI.a(CardNewMsgUI.this).a(null, null);
            if (!CardNewMsgUI.b(CardNewMsgUI.this))
            {
              if (CardNewMsgUI.c(CardNewMsgUI.this).getParent() != null)
              {
                ad.d("MicroMsg.CardNewMsgUI", "remove footer");
                CardNewMsgUI.d(CardNewMsgUI.this).removeFooterView(CardNewMsgUI.c(CardNewMsgUI.this));
              }
              if ((!CardNewMsgUI.a(CardNewMsgUI.this).bXb()) && (CardNewMsgUI.e(CardNewMsgUI.this).getParent() == null) && (paramAnonymousInt > 0))
              {
                CardNewMsgUI.d(CardNewMsgUI.this).addFooterView(CardNewMsgUI.e(CardNewMsgUI.this));
                ad.i("MicroMsg.CardNewMsgUI", "add mLoadingFooterView");
              }
            }
            CardNewMsgUI.f(CardNewMsgUI.this);
            CardNewMsgUI.c(CardNewMsgUI.this).setVisibility(8);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(113520);
            return;
            paramAnonymousInt = CardNewMsgUI.a(CardNewMsgUI.this).bXc();
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
          if (am.bUP().bUJ() > 0) {
            am.bUP().bUK();
          }
          for (;;)
          {
            CardNewMsgUI.a(CardNewMsgUI.this).a(null, null);
            AppMethodBeat.o(113522);
            return;
            CardNewMsgUI.a(CardNewMsgUI.this).bXc();
          }
        }
        AppMethodBeat.o(113522);
      }
    });
    this.oIU.a(new r.a()
    {
      public final void aSs()
      {
        AppMethodBeat.i(113523);
        CardNewMsgUI.g(CardNewMsgUI.this);
        if ((CardNewMsgUI.a(CardNewMsgUI.this).bXb()) && (am.bUP().bUJ() == 0)) {
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
        com.tencent.mm.plugin.report.service.g.yhR.f(11582, new Object[] { "CardMsgClearMenu", Integer.valueOf(2), Integer.valueOf(0), "", "", "" });
        CardNewMsgUI.h(CardNewMsgUI.this);
        AppMethodBeat.o(113524);
        return true;
      }
    });
    this.GG = findViewById(2131298768);
    bVy();
    this.oIV = z.jO(this).inflate(2131493322, null);
    this.oIW = z.jO(this).inflate(2131494788, null);
    int i = am.bUP().bUJ();
    if (i > 0)
    {
      this.mListView.addFooterView(this.oIV);
      AppMethodBeat.o(113540);
      return;
    }
    if ((!this.oIU.bXb()) && (i == 0) && (am.bUP().getCount() > 0))
    {
      this.mListView.addFooterView(this.oIW);
      this.oIX = true;
      AppMethodBeat.o(113540);
      return;
    }
    if ((this.oIU.bXb()) && (i == 0)) {
      am.bUP().getCount();
    }
    AppMethodBeat.o(113540);
  }
  
  public final void onChange() {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113538);
    super.onCreate(paramBundle);
    initView();
    am.bUR().a(this);
    am.bUR().bUB();
    AppMethodBeat.o(113538);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113539);
    this.oIU.det();
    am.bUR().b(this);
    if (am.bUP().bUJ() > 0) {
      am.bUP().bUK();
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
    private int fTM;
    private int oIZ;
    
    public a()
    {
      super(new com.tencent.mm.plugin.card.model.g());
      AppMethodBeat.i(113530);
      this.oIZ = 10;
      this.fTM = this.oIZ;
      xk(true);
      AppMethodBeat.o(113530);
    }
    
    private void a(List<g.a> paramList, List<g.b> paramList1, CardNewMsgUI.b paramb, final com.tencent.mm.plugin.card.model.g paramg)
    {
      AppMethodBeat.i(113535);
      paramb.oJo.removeAllViews();
      if (((paramList == null) || (paramList.size() == 0)) && ((paramList1 == null) || (paramList1.size() == 0)))
      {
        paramb.oJp.setVisibility(8);
        AppMethodBeat.o(113535);
        return;
      }
      int i;
      Object localObject1;
      Object localObject2;
      if (!bt.hj(paramList))
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
          ((TextView)((View)localObject2).findViewById(2131297713)).setText(((g.a)localObject1).nch);
          Button localButton = (Button)((View)localObject2).findViewById(2131297711);
          localButton.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(113528);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
              paramAnonymousView = new Intent();
              if (this.oJa.ozA == 0)
              {
                paramAnonymousView.setClass(CardNewMsgUI.this.getContext(), CardDetailUI.class);
                paramAnonymousView.putExtra("key_card_id", this.oJa.cardId);
                paramAnonymousView.putExtra("key_card_ext", this.oJa.ozz);
                paramAnonymousView.putExtra("key_from_scene", 17);
                localObject = CardNewMsgUI.this;
                paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahp(), "com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((CardNewMsgUI)localObject).startActivity((Intent)paramAnonymousView.mq(0));
                com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
              for (;;)
              {
                com.tencent.mm.plugin.report.service.g.yhR.f(11941, new Object[] { Integer.valueOf(8), paramg.field_card_id, paramg.field_card_tp_id, paramg.field_msg_id, this.oJa.cardId });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(113528);
                return;
                if (this.oJa.ozA == 1)
                {
                  paramAnonymousView.setClass(CardNewMsgUI.this.getContext(), CardConsumeSuccessUI.class);
                  paramAnonymousView.putExtra("key_card_id", paramg.field_card_id);
                  paramAnonymousView.putExtra("key_from_scene", 2);
                  localObject = CardNewMsgUI.this;
                  paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahp(), "com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  ((CardNewMsgUI)localObject).startActivity((Intent)paramAnonymousView.mq(0));
                  com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
              }
            }
          });
          if (((g.a)localObject1).ozA == 0) {
            localButton.setText(2131756784);
          }
          for (;;)
          {
            paramb.oJo.addView((View)localObject2);
            i += 1;
            break;
            if (((g.a)localObject1).ozA == 1) {
              localButton.setText(2131756785);
            }
          }
        }
      }
      if (!bt.hj(paramList1))
      {
        i = 0;
        while (i < paramList1.size())
        {
          paramg = (g.b)paramList1.get(i);
          localObject1 = View.inflate(CardNewMsgUI.this.getContext(), 2131493246, null);
          if ((i == 0) && (bt.hj(paramList))) {
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
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              if (!TextUtils.isEmpty(paramg.ozD)) {
                com.tencent.mm.plugin.card.d.b.a(CardNewMsgUI.this, paramg.ozD, 2);
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(113529);
                return;
                ad.e("MicroMsg.CardNewMsgUI", "card msg button url is empty");
              }
            }
          });
          ((Button)localObject2).setText(paramg.ozC);
          paramb.oJo.addView((View)localObject1);
          i += 1;
        }
      }
      paramb.oJp.setVisibility(0);
      AppMethodBeat.o(113535);
    }
    
    public final void Zu()
    {
      AppMethodBeat.i(113531);
      if (am.bUP().bUJ() > 0) {
        setCursor(am.bUP().db.rawQuery("select * from CardMsgInfo where read_state = ?  order by time desc", new String[] { "1" }));
      }
      for (;;)
      {
        notifyDataSetChanged();
        AppMethodBeat.o(113531);
        return;
        this.fTM = am.bUP().getCount();
        h localh = am.bUP();
        String str = "select * from CardMsgInfo order by time desc LIMIT ".concat(String.valueOf(this.oIZ));
        setCursor(localh.db.rawQuery(str, null));
      }
    }
    
    public final void Zv()
    {
      AppMethodBeat.i(113532);
      det();
      Zu();
      AppMethodBeat.o(113532);
    }
    
    public final boolean bXb()
    {
      return this.oIZ >= this.fTM;
    }
    
    public final int bXc()
    {
      AppMethodBeat.i(113533);
      if (bXb())
      {
        if (CardNewMsgUI.e(CardNewMsgUI.this).getParent() != null) {
          CardNewMsgUI.d(CardNewMsgUI.this).removeFooterView(CardNewMsgUI.e(CardNewMsgUI.this));
        }
        AppMethodBeat.o(113533);
        return 0;
      }
      this.oIZ += 10;
      if (this.oIZ <= this.fTM)
      {
        AppMethodBeat.o(113533);
        return 10;
      }
      this.oIZ = this.fTM;
      int i = this.fTM;
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
        paramViewGroup.oJe = ((ImageView)paramView.findViewById(2131301584));
        paramViewGroup.oJf = paramView.findViewById(2131297917);
        paramViewGroup.oJg = ((ImageView)paramView.findViewById(2131297916));
        paramViewGroup.oJh = ((TextView)paramView.findViewById(2131305948));
        paramViewGroup.oJi = ((TextView)paramView.findViewById(2131305822));
        paramViewGroup.oJj = ((TextView)paramView.findViewById(2131299010));
        paramViewGroup.oJk = ((TextView)paramView.findViewById(2131299634));
        paramViewGroup.oJl = ((TextView)paramView.findViewById(2131305155));
        paramViewGroup.oJm = paramView.findViewById(2131303035);
        paramViewGroup.oJn = ((TextView)paramView.findViewById(2131303036));
        paramViewGroup.oJo = ((LinearLayout)paramView.findViewById(2131296315));
        paramViewGroup.oJp = ((LinearLayout)paramView.findViewById(2131296316));
        paramView.setTag(paramViewGroup);
        paramViewGroup.oJh.setText(localg.field_title);
        long l = localg.field_time;
        paramViewGroup.oJi.setText(i.c(CardNewMsgUI.this, l * 1000L, true));
        paramViewGroup.oJj.setText(localg.field_description);
        i = CardNewMsgUI.this.getResources().getDimensionPixelSize(2131165991);
        ad.d("MicroMsg.CardNewMsgUI", "CardNewMsgUI getView () position : " + paramInt + " logo_url :  " + localg.field_logo_url);
        if (!TextUtils.isEmpty(localg.field_logo_color)) {
          break label558;
        }
        paramViewGroup.oJf.setVisibility(8);
        paramViewGroup.oJe.setVisibility(0);
        paramViewGroup.oJe.setImageResource(2131233400);
        n.a(paramViewGroup.oJe, localg.field_logo_url, i, 2131233400, true);
        label373:
        Object localObject = localg.bUE();
        if ((localObject == null) || (TextUtils.isEmpty(((sp)localObject).text))) {
          break label673;
        }
        paramViewGroup.oJk.setText(((sp)localObject).text);
        paramViewGroup.oJk.setTag(localg);
        paramViewGroup.oJk.setVisibility(0);
        paramViewGroup.oJk.setOnClickListener(CardNewMsgUI.this.jtG);
        label439:
        localObject = localg.bUF();
        if ((localObject == null) || (TextUtils.isEmpty(((th)localObject).text))) {
          break label685;
        }
        paramViewGroup.oJn.setText(((th)localObject).text);
        paramViewGroup.oJm.setVisibility(0);
        paramViewGroup.oJm.setOnClickListener(CardNewMsgUI.this.jtG);
        paramViewGroup.oJm.setTag(localg);
        paramViewGroup.oJl.setVisibility(0);
      }
      for (;;)
      {
        localg.bUG();
        localg.bUH();
        a(localg.ozt, localg.ozu, paramViewGroup, localg);
        AppMethodBeat.o(113534);
        return paramView;
        paramViewGroup = (CardNewMsgUI.b)paramView.getTag();
        break;
        label558:
        ad.d("MicroMsg.CardNewMsgUI", "CardNewMsgUI getView () position : " + paramInt + " field_logo_color :  " + localg.field_logo_color);
        paramViewGroup.oJf.setVisibility(0);
        paramViewGroup.oJe.setVisibility(8);
        if (!TextUtils.isEmpty(localg.field_logo_url))
        {
          n.a(CardNewMsgUI.this, paramViewGroup.oJg, localg.field_logo_url, i, l.Zh(localg.field_logo_color));
          break label373;
        }
        n.b(paramViewGroup.oJg, 2131231506, l.Zh(localg.field_logo_color));
        break label373;
        label673:
        paramViewGroup.oJk.setVisibility(8);
        break label439;
        label685:
        paramViewGroup.oJm.setVisibility(8);
        paramViewGroup.oJl.setVisibility(8);
      }
    }
  }
  
  final class b
  {
    ImageView oJe;
    View oJf;
    ImageView oJg;
    TextView oJh;
    TextView oJi;
    TextView oJj;
    TextView oJk;
    TextView oJl;
    View oJm;
    TextView oJn;
    LinearLayout oJo;
    LinearLayout oJp;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardNewMsgUI
 * JD-Core Version:    0.7.0.1
 */