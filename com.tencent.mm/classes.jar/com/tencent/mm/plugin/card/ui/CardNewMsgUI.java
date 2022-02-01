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
import com.tencent.mm.plugin.card.d.b;
import com.tencent.mm.plugin.card.d.d.a;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.plugin.card.model.g.a;
import com.tencent.mm.plugin.card.model.g.b;
import com.tencent.mm.plugin.card.sharecard.ui.CardConsumeSuccessUI;
import com.tencent.mm.protocal.protobuf.qm;
import com.tencent.mm.protocal.protobuf.rd;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.q.a;
import com.tencent.mm.ui.y;
import java.util.ArrayList;
import java.util.List;

public class CardNewMsgUI
  extends MMActivity
  implements k.a
{
  private View DR;
  View.OnClickListener iAw;
  private ListView mListView;
  private a nCA;
  private View nCB;
  private View nCC;
  private boolean nCD;
  
  public CardNewMsgUI()
  {
    AppMethodBeat.i(113537);
    this.nCC = null;
    this.nCD = false;
    this.iAw = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113527);
        if (paramAnonymousView.getId() == 2131299634)
        {
          paramAnonymousView = (g)paramAnonymousView.getTag();
          if ((paramAnonymousView == null) || (paramAnonymousView.bIM() == null))
          {
            AppMethodBeat.o(113527);
            return;
          }
          com.tencent.mm.plugin.report.service.h.vKh.f(11941, new Object[] { Integer.valueOf(2), paramAnonymousView.field_card_id, paramAnonymousView.field_card_tp_id, paramAnonymousView.field_msg_id, "" });
          if (paramAnonymousView.bIM().ntg == 0)
          {
            ad.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_BUTTON_TYPE_URL");
            if (!TextUtils.isEmpty(paramAnonymousView.bIM().url))
            {
              b.a(CardNewMsgUI.this, paramAnonymousView.bIM().url, 2);
              AppMethodBeat.o(113527);
              return;
            }
            ad.e("MicroMsg.CardNewMsgUI", "card msg button url is empty");
            AppMethodBeat.o(113527);
            return;
          }
          if (paramAnonymousView.bIM().ntg == 1)
          {
            ad.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_BUTTON_TYPE_SHOP");
            Object localObject = new Intent();
            ((Intent)localObject).putExtra("KEY_CARD_ID", paramAnonymousView.field_card_id);
            ((Intent)localObject).putExtra("KEY_CARD_TP_ID", paramAnonymousView.field_card_tp_id);
            ((Intent)localObject).setClass(CardNewMsgUI.this, CardShopUI.class);
            CardNewMsgUI localCardNewMsgUI = CardNewMsgUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localCardNewMsgUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/card/ui/CardNewMsgUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localCardNewMsgUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(localCardNewMsgUI, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.report.service.h.vKh.f(11324, new Object[] { "UsedStoresView", Integer.valueOf(paramAnonymousView.field_card_type), paramAnonymousView.field_card_tp_id, paramAnonymousView.field_card_id, Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "" });
          }
          AppMethodBeat.o(113527);
          return;
        }
        if (paramAnonymousView.getId() == 2131303035)
        {
          paramAnonymousView = (g)paramAnonymousView.getTag();
          if ((paramAnonymousView == null) || (paramAnonymousView.bIN() == null))
          {
            AppMethodBeat.o(113527);
            return;
          }
          if (paramAnonymousView.bIN().type == 0)
          {
            ad.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_OPERATION_REGION_TYPE_TEXT");
            if (!TextUtils.isEmpty(paramAnonymousView.bIN().url))
            {
              b.a(CardNewMsgUI.this, paramAnonymousView.bIN().url, 2);
              AppMethodBeat.o(113527);
              return;
            }
            ad.e("MicroMsg.CardNewMsgUI", "card msg oper region url is empty");
            AppMethodBeat.o(113527);
            return;
          }
          if (paramAnonymousView.bIN().type == 1) {
            ad.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_OPERATION_REGION_TYPE_CARDS");
          }
        }
        AppMethodBeat.o(113527);
      }
    };
    AppMethodBeat.o(113537);
  }
  
  private void aF(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(113542);
    Intent localIntent = new Intent(this, CardDetailUI.class);
    localIntent.putExtra("key_card_id", paramString);
    localIntent.putExtra("key_is_share_card", paramBoolean);
    localIntent.putExtra("key_from_scene", 4);
    paramString = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramString.adn(), "com/tencent/mm/plugin/card/ui/CardNewMsgUI", "gotoCardDetailUI", "(Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardNewMsgUI", "gotoCardDetailUI", "(Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(113542);
  }
  
  private void bJG()
  {
    AppMethodBeat.i(113541);
    if (am.bIZ().getCount() > 0)
    {
      this.mListView.setVisibility(0);
      this.DR.setVisibility(8);
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.nCA.notifyDataSetChanged();
      AppMethodBeat.o(113541);
      return;
      this.mListView.setVisibility(8);
      this.DR.setVisibility(0);
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
    bJG();
    this.nCA.a(null, null);
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
    this.nCA = new a();
    this.mListView.setAdapter(this.nCA);
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(113520);
        if (paramAnonymousInt == CardNewMsgUI.a(CardNewMsgUI.this).getCount())
        {
          paramAnonymousInt = 1;
          if (am.bIX().bIR() > 0) {
            am.bIX().bIS();
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
              if ((!CardNewMsgUI.a(CardNewMsgUI.this).bLj()) && (CardNewMsgUI.e(CardNewMsgUI.this).getParent() == null) && (paramAnonymousInt > 0))
              {
                CardNewMsgUI.d(CardNewMsgUI.this).addFooterView(CardNewMsgUI.e(CardNewMsgUI.this));
                ad.i("MicroMsg.CardNewMsgUI", "add mLoadingFooterView");
              }
            }
            CardNewMsgUI.f(CardNewMsgUI.this);
            CardNewMsgUI.c(CardNewMsgUI.this).setVisibility(8);
            AppMethodBeat.o(113520);
            return;
            paramAnonymousInt = CardNewMsgUI.a(CardNewMsgUI.this).bLk();
          }
        }
        CardNewMsgUI.a(CardNewMsgUI.this, paramAnonymousInt);
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
          if (am.bIX().bIR() > 0) {
            am.bIX().bIS();
          }
          for (;;)
          {
            CardNewMsgUI.a(CardNewMsgUI.this).a(null, null);
            AppMethodBeat.o(113522);
            return;
            CardNewMsgUI.a(CardNewMsgUI.this).bLk();
          }
        }
        AppMethodBeat.o(113522);
      }
    });
    this.nCA.a(new q.a()
    {
      public final void aIp()
      {
        AppMethodBeat.i(113523);
        CardNewMsgUI.g(CardNewMsgUI.this);
        if ((CardNewMsgUI.a(CardNewMsgUI.this).bLj()) && (am.bIX().bIR() == 0)) {
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
        com.tencent.mm.plugin.report.service.h.vKh.f(11582, new Object[] { "CardMsgClearMenu", Integer.valueOf(2), Integer.valueOf(0), "", "", "" });
        CardNewMsgUI.h(CardNewMsgUI.this);
        AppMethodBeat.o(113524);
        return true;
      }
    });
    this.DR = findViewById(2131298768);
    bJG();
    this.nCB = y.js(this).inflate(2131493322, null);
    this.nCC = y.js(this).inflate(2131494788, null);
    int i = am.bIX().bIR();
    if (i > 0)
    {
      this.mListView.addFooterView(this.nCB);
      AppMethodBeat.o(113540);
      return;
    }
    if ((!this.nCA.bLj()) && (i == 0) && (am.bIX().getCount() > 0))
    {
      this.mListView.addFooterView(this.nCC);
      this.nCD = true;
      AppMethodBeat.o(113540);
      return;
    }
    if ((this.nCA.bLj()) && (i == 0)) {
      am.bIX().getCount();
    }
    AppMethodBeat.o(113540);
  }
  
  public final void onChange() {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113538);
    super.onCreate(paramBundle);
    initView();
    am.bIZ().a(this);
    am.bIZ().bIJ();
    AppMethodBeat.o(113538);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113539);
    this.nCA.cHX();
    am.bIZ().b(this);
    if (am.bIX().bIR() > 0) {
      am.bIX().bIS();
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
    extends q<g>
  {
    private int fwP;
    private int nCF;
    
    public a()
    {
      super(new g());
      AppMethodBeat.i(113530);
      this.nCF = 10;
      this.fwP = this.nCF;
      vw(true);
      AppMethodBeat.o(113530);
    }
    
    private void a(List<g.a> paramList, List<g.b> paramList1, CardNewMsgUI.b paramb, final g paramg)
    {
      AppMethodBeat.i(113535);
      paramb.nCU.removeAllViews();
      if (((paramList == null) || (paramList.size() == 0)) && ((paramList1 == null) || (paramList1.size() == 0)))
      {
        paramb.nCV.setVisibility(8);
        AppMethodBeat.o(113535);
        return;
      }
      int i;
      Object localObject1;
      Object localObject2;
      if (!bt.gL(paramList))
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
          ((TextView)((View)localObject2).findViewById(2131297713)).setText(((g.a)localObject1).lZG);
          Button localButton = (Button)((View)localObject2).findViewById(2131297711);
          localButton.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(113528);
              paramAnonymousView = new Intent();
              CardNewMsgUI localCardNewMsgUI;
              if (this.nCG.ntg == 0)
              {
                paramAnonymousView.setClass(CardNewMsgUI.this.getContext(), CardDetailUI.class);
                paramAnonymousView.putExtra("key_card_id", this.nCG.cardId);
                paramAnonymousView.putExtra("key_card_ext", this.nCG.ntf);
                paramAnonymousView.putExtra("key_from_scene", 17);
                localCardNewMsgUI = CardNewMsgUI.this;
                paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.a(localCardNewMsgUI, paramAnonymousView.adn(), "com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                localCardNewMsgUI.startActivity((Intent)paramAnonymousView.lS(0));
                com.tencent.mm.hellhoundlib.a.a.a(localCardNewMsgUI, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
              for (;;)
              {
                com.tencent.mm.plugin.report.service.h.vKh.f(11941, new Object[] { Integer.valueOf(8), paramg.field_card_id, paramg.field_card_tp_id, paramg.field_msg_id, this.nCG.cardId });
                AppMethodBeat.o(113528);
                return;
                if (this.nCG.ntg == 1)
                {
                  paramAnonymousView.setClass(CardNewMsgUI.this.getContext(), CardConsumeSuccessUI.class);
                  paramAnonymousView.putExtra("key_card_id", paramg.field_card_id);
                  paramAnonymousView.putExtra("key_from_scene", 2);
                  localCardNewMsgUI = CardNewMsgUI.this;
                  paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.a(localCardNewMsgUI, paramAnonymousView.adn(), "com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  localCardNewMsgUI.startActivity((Intent)paramAnonymousView.lS(0));
                  com.tencent.mm.hellhoundlib.a.a.a(localCardNewMsgUI, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
              }
            }
          });
          if (((g.a)localObject1).ntg == 0) {
            localButton.setText(2131756784);
          }
          for (;;)
          {
            paramb.nCU.addView((View)localObject2);
            i += 1;
            break;
            if (((g.a)localObject1).ntg == 1) {
              localButton.setText(2131756785);
            }
          }
        }
      }
      if (!bt.gL(paramList1))
      {
        i = 0;
        while (i < paramList1.size())
        {
          paramg = (g.b)paramList1.get(i);
          localObject1 = View.inflate(CardNewMsgUI.this.getContext(), 2131493246, null);
          if ((i == 0) && (bt.gL(paramList))) {
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
              if (!TextUtils.isEmpty(paramg.ntj))
              {
                b.a(CardNewMsgUI.this, paramg.ntj, 2);
                AppMethodBeat.o(113529);
                return;
              }
              ad.e("MicroMsg.CardNewMsgUI", "card msg button url is empty");
              AppMethodBeat.o(113529);
            }
          });
          ((Button)localObject2).setText(paramg.nti);
          paramb.nCU.addView((View)localObject1);
          i += 1;
        }
      }
      paramb.nCV.setVisibility(0);
      AppMethodBeat.o(113535);
    }
    
    public final void Wd()
    {
      AppMethodBeat.i(113531);
      if (am.bIX().bIR() > 0) {
        setCursor(am.bIX().db.rawQuery("select * from CardMsgInfo where read_state = ?  order by time desc", new String[] { "1" }));
      }
      for (;;)
      {
        notifyDataSetChanged();
        AppMethodBeat.o(113531);
        return;
        this.fwP = am.bIX().getCount();
        com.tencent.mm.plugin.card.model.h localh = am.bIX();
        String str = "select * from CardMsgInfo order by time desc LIMIT ".concat(String.valueOf(this.nCF));
        setCursor(localh.db.rawQuery(str, null));
      }
    }
    
    public final void We()
    {
      AppMethodBeat.i(113532);
      cHX();
      Wd();
      AppMethodBeat.o(113532);
    }
    
    public final boolean bLj()
    {
      return this.nCF >= this.fwP;
    }
    
    public final int bLk()
    {
      AppMethodBeat.i(113533);
      if (bLj())
      {
        if (CardNewMsgUI.e(CardNewMsgUI.this).getParent() != null) {
          CardNewMsgUI.d(CardNewMsgUI.this).removeFooterView(CardNewMsgUI.e(CardNewMsgUI.this));
        }
        AppMethodBeat.o(113533);
        return 0;
      }
      this.nCF += 10;
      if (this.nCF <= this.fwP)
      {
        AppMethodBeat.o(113533);
        return 10;
      }
      this.nCF = this.fwP;
      int i = this.fwP;
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
        paramView = View.inflate(CardNewMsgUI.this.getContext(), 2131493323, null);
        paramViewGroup = new CardNewMsgUI.b(CardNewMsgUI.this, (byte)0);
        paramViewGroup.nCK = ((ImageView)paramView.findViewById(2131301584));
        paramViewGroup.nCL = paramView.findViewById(2131297917);
        paramViewGroup.nCM = ((ImageView)paramView.findViewById(2131297916));
        paramViewGroup.nCN = ((TextView)paramView.findViewById(2131305948));
        paramViewGroup.nCO = ((TextView)paramView.findViewById(2131305822));
        paramViewGroup.nCP = ((TextView)paramView.findViewById(2131299010));
        paramViewGroup.nCQ = ((TextView)paramView.findViewById(2131299634));
        paramViewGroup.nCR = ((TextView)paramView.findViewById(2131305155));
        paramViewGroup.nCS = paramView.findViewById(2131303035);
        paramViewGroup.nCT = ((TextView)paramView.findViewById(2131303036));
        paramViewGroup.nCU = ((LinearLayout)paramView.findViewById(2131296315));
        paramViewGroup.nCV = ((LinearLayout)paramView.findViewById(2131296316));
        paramView.setTag(paramViewGroup);
        paramViewGroup.nCN.setText(localg.field_title);
        long l = localg.field_time;
        paramViewGroup.nCO.setText(com.tencent.mm.pluginsdk.g.h.c(CardNewMsgUI.this, l * 1000L, true));
        paramViewGroup.nCP.setText(localg.field_description);
        i = CardNewMsgUI.this.getResources().getDimensionPixelSize(2131165991);
        ad.d("MicroMsg.CardNewMsgUI", "CardNewMsgUI getView () position : " + paramInt + " logo_url :  " + localg.field_logo_url);
        if (!TextUtils.isEmpty(localg.field_logo_color)) {
          break label558;
        }
        paramViewGroup.nCL.setVisibility(8);
        paramViewGroup.nCK.setVisibility(0);
        paramViewGroup.nCK.setImageResource(2131233400);
        n.a(paramViewGroup.nCK, localg.field_logo_url, i, 2131233400, true);
        label373:
        Object localObject = localg.bIM();
        if ((localObject == null) || (TextUtils.isEmpty(((qm)localObject).text))) {
          break label673;
        }
        paramViewGroup.nCQ.setText(((qm)localObject).text);
        paramViewGroup.nCQ.setTag(localg);
        paramViewGroup.nCQ.setVisibility(0);
        paramViewGroup.nCQ.setOnClickListener(CardNewMsgUI.this.iAw);
        label439:
        localObject = localg.bIN();
        if ((localObject == null) || (TextUtils.isEmpty(((rd)localObject).text))) {
          break label685;
        }
        paramViewGroup.nCT.setText(((rd)localObject).text);
        paramViewGroup.nCS.setVisibility(0);
        paramViewGroup.nCS.setOnClickListener(CardNewMsgUI.this.iAw);
        paramViewGroup.nCS.setTag(localg);
        paramViewGroup.nCR.setVisibility(0);
      }
      for (;;)
      {
        localg.bIO();
        localg.bIP();
        a(localg.nsZ, localg.nta, paramViewGroup, localg);
        AppMethodBeat.o(113534);
        return paramView;
        paramViewGroup = (CardNewMsgUI.b)paramView.getTag();
        break;
        label558:
        ad.d("MicroMsg.CardNewMsgUI", "CardNewMsgUI getView () position : " + paramInt + " field_logo_color :  " + localg.field_logo_color);
        paramViewGroup.nCL.setVisibility(0);
        paramViewGroup.nCK.setVisibility(8);
        if (!TextUtils.isEmpty(localg.field_logo_url))
        {
          n.a(CardNewMsgUI.this, paramViewGroup.nCM, localg.field_logo_url, i, l.Rm(localg.field_logo_color));
          break label373;
        }
        n.b(paramViewGroup.nCM, 2131231506, l.Rm(localg.field_logo_color));
        break label373;
        label673:
        paramViewGroup.nCQ.setVisibility(8);
        break label439;
        label685:
        paramViewGroup.nCS.setVisibility(8);
        paramViewGroup.nCR.setVisibility(8);
      }
    }
  }
  
  final class b
  {
    ImageView nCK;
    View nCL;
    ImageView nCM;
    TextView nCN;
    TextView nCO;
    TextView nCP;
    TextView nCQ;
    TextView nCR;
    View nCS;
    TextView nCT;
    LinearLayout nCU;
    LinearLayout nCV;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardNewMsgUI
 * JD-Core Version:    0.7.0.1
 */