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
import com.tencent.mm.protocal.protobuf.qw;
import com.tencent.mm.protocal.protobuf.rn;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  private View EP;
  View.OnClickListener jax;
  private ListView mListView;
  private a ofB;
  private View ofC;
  private View ofD;
  private boolean ofE;
  
  public CardNewMsgUI()
  {
    AppMethodBeat.i(113537);
    this.ofD = null;
    this.ofE = false;
    this.jax = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113527);
        if (paramAnonymousView.getId() == 2131299634)
        {
          paramAnonymousView = (g)paramAnonymousView.getTag();
          if ((paramAnonymousView == null) || (paramAnonymousView.bPZ() == null))
          {
            AppMethodBeat.o(113527);
            return;
          }
          com.tencent.mm.plugin.report.service.h.wUl.f(11941, new Object[] { Integer.valueOf(2), paramAnonymousView.field_card_id, paramAnonymousView.field_card_tp_id, paramAnonymousView.field_msg_id, "" });
          if (paramAnonymousView.bPZ().nWg == 0)
          {
            ac.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_BUTTON_TYPE_URL");
            if (!TextUtils.isEmpty(paramAnonymousView.bPZ().url))
            {
              b.a(CardNewMsgUI.this, paramAnonymousView.bPZ().url, 2);
              AppMethodBeat.o(113527);
              return;
            }
            ac.e("MicroMsg.CardNewMsgUI", "card msg button url is empty");
            AppMethodBeat.o(113527);
            return;
          }
          if (paramAnonymousView.bPZ().nWg == 1)
          {
            ac.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_BUTTON_TYPE_SHOP");
            Object localObject = new Intent();
            ((Intent)localObject).putExtra("KEY_CARD_ID", paramAnonymousView.field_card_id);
            ((Intent)localObject).putExtra("KEY_CARD_TP_ID", paramAnonymousView.field_card_tp_id);
            ((Intent)localObject).setClass(CardNewMsgUI.this, CardShopUI.class);
            CardNewMsgUI localCardNewMsgUI = CardNewMsgUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localCardNewMsgUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/card/ui/CardNewMsgUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localCardNewMsgUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(localCardNewMsgUI, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.report.service.h.wUl.f(11324, new Object[] { "UsedStoresView", Integer.valueOf(paramAnonymousView.field_card_type), paramAnonymousView.field_card_tp_id, paramAnonymousView.field_card_id, Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "" });
          }
          AppMethodBeat.o(113527);
          return;
        }
        if (paramAnonymousView.getId() == 2131303035)
        {
          paramAnonymousView = (g)paramAnonymousView.getTag();
          if ((paramAnonymousView == null) || (paramAnonymousView.bQa() == null))
          {
            AppMethodBeat.o(113527);
            return;
          }
          if (paramAnonymousView.bQa().type == 0)
          {
            ac.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_OPERATION_REGION_TYPE_TEXT");
            if (!TextUtils.isEmpty(paramAnonymousView.bQa().url))
            {
              b.a(CardNewMsgUI.this, paramAnonymousView.bQa().url, 2);
              AppMethodBeat.o(113527);
              return;
            }
            ac.e("MicroMsg.CardNewMsgUI", "card msg oper region url is empty");
            AppMethodBeat.o(113527);
            return;
          }
          if (paramAnonymousView.bQa().type == 1) {
            ac.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_OPERATION_REGION_TYPE_CARDS");
          }
        }
        AppMethodBeat.o(113527);
      }
    };
    AppMethodBeat.o(113537);
  }
  
  private void aG(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(113542);
    Intent localIntent = new Intent(this, CardDetailUI.class);
    localIntent.putExtra("key_card_id", paramString);
    localIntent.putExtra("key_is_share_card", paramBoolean);
    localIntent.putExtra("key_from_scene", 4);
    paramString = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramString.aeD(), "com/tencent/mm/plugin/card/ui/CardNewMsgUI", "gotoCardDetailUI", "(Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardNewMsgUI", "gotoCardDetailUI", "(Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(113542);
  }
  
  private void bQT()
  {
    AppMethodBeat.i(113541);
    if (am.bQm().getCount() > 0)
    {
      this.mListView.setVisibility(0);
      this.EP.setVisibility(8);
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.ofB.notifyDataSetChanged();
      AppMethodBeat.o(113541);
      return;
      this.mListView.setVisibility(8);
      this.EP.setVisibility(0);
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
    bQT();
    this.ofB.a(null, null);
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
    this.ofB = new a();
    this.mListView.setAdapter(this.ofB);
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(113520);
        if (paramAnonymousInt == CardNewMsgUI.a(CardNewMsgUI.this).getCount())
        {
          paramAnonymousInt = 1;
          if (am.bQk().bQe() > 0) {
            am.bQk().bQf();
          }
          for (;;)
          {
            CardNewMsgUI.a(CardNewMsgUI.this).a(null, null);
            if (!CardNewMsgUI.b(CardNewMsgUI.this))
            {
              if (CardNewMsgUI.c(CardNewMsgUI.this).getParent() != null)
              {
                ac.d("MicroMsg.CardNewMsgUI", "remove footer");
                CardNewMsgUI.d(CardNewMsgUI.this).removeFooterView(CardNewMsgUI.c(CardNewMsgUI.this));
              }
              if ((!CardNewMsgUI.a(CardNewMsgUI.this).bSw()) && (CardNewMsgUI.e(CardNewMsgUI.this).getParent() == null) && (paramAnonymousInt > 0))
              {
                CardNewMsgUI.d(CardNewMsgUI.this).addFooterView(CardNewMsgUI.e(CardNewMsgUI.this));
                ac.i("MicroMsg.CardNewMsgUI", "add mLoadingFooterView");
              }
            }
            CardNewMsgUI.f(CardNewMsgUI.this);
            CardNewMsgUI.c(CardNewMsgUI.this).setVisibility(8);
            AppMethodBeat.o(113520);
            return;
            paramAnonymousInt = CardNewMsgUI.a(CardNewMsgUI.this).bSx();
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
          if (am.bQk().bQe() > 0) {
            am.bQk().bQf();
          }
          for (;;)
          {
            CardNewMsgUI.a(CardNewMsgUI.this).a(null, null);
            AppMethodBeat.o(113522);
            return;
            CardNewMsgUI.a(CardNewMsgUI.this).bSx();
          }
        }
        AppMethodBeat.o(113522);
      }
    });
    this.ofB.a(new r.a()
    {
      public final void aPg()
      {
        AppMethodBeat.i(113523);
        CardNewMsgUI.g(CardNewMsgUI.this);
        if ((CardNewMsgUI.a(CardNewMsgUI.this).bSw()) && (am.bQk().bQe() == 0)) {
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
        com.tencent.mm.plugin.report.service.h.wUl.f(11582, new Object[] { "CardMsgClearMenu", Integer.valueOf(2), Integer.valueOf(0), "", "", "" });
        CardNewMsgUI.h(CardNewMsgUI.this);
        AppMethodBeat.o(113524);
        return true;
      }
    });
    this.EP = findViewById(2131298768);
    bQT();
    this.ofC = z.jD(this).inflate(2131493322, null);
    this.ofD = z.jD(this).inflate(2131494788, null);
    int i = am.bQk().bQe();
    if (i > 0)
    {
      this.mListView.addFooterView(this.ofC);
      AppMethodBeat.o(113540);
      return;
    }
    if ((!this.ofB.bSw()) && (i == 0) && (am.bQk().getCount() > 0))
    {
      this.mListView.addFooterView(this.ofD);
      this.ofE = true;
      AppMethodBeat.o(113540);
      return;
    }
    if ((this.ofB.bSw()) && (i == 0)) {
      am.bQk().getCount();
    }
    AppMethodBeat.o(113540);
  }
  
  public final void onChange() {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113538);
    super.onCreate(paramBundle);
    initView();
    am.bQm().a(this);
    am.bQm().bPW();
    AppMethodBeat.o(113538);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113539);
    this.ofB.cVi();
    am.bQm().b(this);
    if (am.bQk().bQe() > 0) {
      am.bQk().bQf();
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
    extends r<g>
  {
    private int fAw;
    private int ofG;
    
    public a()
    {
      super(new g());
      AppMethodBeat.i(113530);
      this.ofG = 10;
      this.fAw = this.ofG;
      wy(true);
      AppMethodBeat.o(113530);
    }
    
    private void a(List<g.a> paramList, List<g.b> paramList1, CardNewMsgUI.b paramb, final g paramg)
    {
      AppMethodBeat.i(113535);
      paramb.ofV.removeAllViews();
      if (((paramList == null) || (paramList.size() == 0)) && ((paramList1 == null) || (paramList1.size() == 0)))
      {
        paramb.ofW.setVisibility(8);
        AppMethodBeat.o(113535);
        return;
      }
      int i;
      Object localObject1;
      Object localObject2;
      if (!bs.gY(paramList))
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
          ((TextView)((View)localObject2).findViewById(2131297713)).setText(((g.a)localObject1).mBH);
          Button localButton = (Button)((View)localObject2).findViewById(2131297711);
          localButton.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(113528);
              paramAnonymousView = new Intent();
              CardNewMsgUI localCardNewMsgUI;
              if (this.ofH.nWg == 0)
              {
                paramAnonymousView.setClass(CardNewMsgUI.this.getContext(), CardDetailUI.class);
                paramAnonymousView.putExtra("key_card_id", this.ofH.cardId);
                paramAnonymousView.putExtra("key_card_ext", this.ofH.nWf);
                paramAnonymousView.putExtra("key_from_scene", 17);
                localCardNewMsgUI = CardNewMsgUI.this;
                paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.a(localCardNewMsgUI, paramAnonymousView.aeD(), "com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                localCardNewMsgUI.startActivity((Intent)paramAnonymousView.lR(0));
                com.tencent.mm.hellhoundlib.a.a.a(localCardNewMsgUI, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
              for (;;)
              {
                com.tencent.mm.plugin.report.service.h.wUl.f(11941, new Object[] { Integer.valueOf(8), paramg.field_card_id, paramg.field_card_tp_id, paramg.field_msg_id, this.ofH.cardId });
                AppMethodBeat.o(113528);
                return;
                if (this.ofH.nWg == 1)
                {
                  paramAnonymousView.setClass(CardNewMsgUI.this.getContext(), CardConsumeSuccessUI.class);
                  paramAnonymousView.putExtra("key_card_id", paramg.field_card_id);
                  paramAnonymousView.putExtra("key_from_scene", 2);
                  localCardNewMsgUI = CardNewMsgUI.this;
                  paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.a(localCardNewMsgUI, paramAnonymousView.aeD(), "com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  localCardNewMsgUI.startActivity((Intent)paramAnonymousView.lR(0));
                  com.tencent.mm.hellhoundlib.a.a.a(localCardNewMsgUI, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
              }
            }
          });
          if (((g.a)localObject1).nWg == 0) {
            localButton.setText(2131756784);
          }
          for (;;)
          {
            paramb.ofV.addView((View)localObject2);
            i += 1;
            break;
            if (((g.a)localObject1).nWg == 1) {
              localButton.setText(2131756785);
            }
          }
        }
      }
      if (!bs.gY(paramList1))
      {
        i = 0;
        while (i < paramList1.size())
        {
          paramg = (g.b)paramList1.get(i);
          localObject1 = View.inflate(CardNewMsgUI.this.getContext(), 2131493246, null);
          if ((i == 0) && (bs.gY(paramList))) {
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
              if (!TextUtils.isEmpty(paramg.nWj))
              {
                b.a(CardNewMsgUI.this, paramg.nWj, 2);
                AppMethodBeat.o(113529);
                return;
              }
              ac.e("MicroMsg.CardNewMsgUI", "card msg button url is empty");
              AppMethodBeat.o(113529);
            }
          });
          ((Button)localObject2).setText(paramg.nWi);
          paramb.ofV.addView((View)localObject1);
          i += 1;
        }
      }
      paramb.ofW.setVisibility(0);
      AppMethodBeat.o(113535);
    }
    
    public final void Xb()
    {
      AppMethodBeat.i(113531);
      if (am.bQk().bQe() > 0) {
        setCursor(am.bQk().db.rawQuery("select * from CardMsgInfo where read_state = ?  order by time desc", new String[] { "1" }));
      }
      for (;;)
      {
        notifyDataSetChanged();
        AppMethodBeat.o(113531);
        return;
        this.fAw = am.bQk().getCount();
        com.tencent.mm.plugin.card.model.h localh = am.bQk();
        String str = "select * from CardMsgInfo order by time desc LIMIT ".concat(String.valueOf(this.ofG));
        setCursor(localh.db.rawQuery(str, null));
      }
    }
    
    public final void Xc()
    {
      AppMethodBeat.i(113532);
      cVi();
      Xb();
      AppMethodBeat.o(113532);
    }
    
    public final boolean bSw()
    {
      return this.ofG >= this.fAw;
    }
    
    public final int bSx()
    {
      AppMethodBeat.i(113533);
      if (bSw())
      {
        if (CardNewMsgUI.e(CardNewMsgUI.this).getParent() != null) {
          CardNewMsgUI.d(CardNewMsgUI.this).removeFooterView(CardNewMsgUI.e(CardNewMsgUI.this));
        }
        AppMethodBeat.o(113533);
        return 0;
      }
      this.ofG += 10;
      if (this.ofG <= this.fAw)
      {
        AppMethodBeat.o(113533);
        return 10;
      }
      this.ofG = this.fAw;
      int i = this.fAw;
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
        paramViewGroup.ofL = ((ImageView)paramView.findViewById(2131301584));
        paramViewGroup.ofM = paramView.findViewById(2131297917);
        paramViewGroup.ofN = ((ImageView)paramView.findViewById(2131297916));
        paramViewGroup.ofO = ((TextView)paramView.findViewById(2131305948));
        paramViewGroup.ofP = ((TextView)paramView.findViewById(2131305822));
        paramViewGroup.ofQ = ((TextView)paramView.findViewById(2131299010));
        paramViewGroup.ofR = ((TextView)paramView.findViewById(2131299634));
        paramViewGroup.ofS = ((TextView)paramView.findViewById(2131305155));
        paramViewGroup.ofT = paramView.findViewById(2131303035);
        paramViewGroup.ofU = ((TextView)paramView.findViewById(2131303036));
        paramViewGroup.ofV = ((LinearLayout)paramView.findViewById(2131296315));
        paramViewGroup.ofW = ((LinearLayout)paramView.findViewById(2131296316));
        paramView.setTag(paramViewGroup);
        paramViewGroup.ofO.setText(localg.field_title);
        long l = localg.field_time;
        paramViewGroup.ofP.setText(com.tencent.mm.pluginsdk.g.h.c(CardNewMsgUI.this, l * 1000L, true));
        paramViewGroup.ofQ.setText(localg.field_description);
        i = CardNewMsgUI.this.getResources().getDimensionPixelSize(2131165991);
        ac.d("MicroMsg.CardNewMsgUI", "CardNewMsgUI getView () position : " + paramInt + " logo_url :  " + localg.field_logo_url);
        if (!TextUtils.isEmpty(localg.field_logo_color)) {
          break label558;
        }
        paramViewGroup.ofM.setVisibility(8);
        paramViewGroup.ofL.setVisibility(0);
        paramViewGroup.ofL.setImageResource(2131233400);
        n.a(paramViewGroup.ofL, localg.field_logo_url, i, 2131233400, true);
        label373:
        Object localObject = localg.bPZ();
        if ((localObject == null) || (TextUtils.isEmpty(((qw)localObject).text))) {
          break label673;
        }
        paramViewGroup.ofR.setText(((qw)localObject).text);
        paramViewGroup.ofR.setTag(localg);
        paramViewGroup.ofR.setVisibility(0);
        paramViewGroup.ofR.setOnClickListener(CardNewMsgUI.this.jax);
        label439:
        localObject = localg.bQa();
        if ((localObject == null) || (TextUtils.isEmpty(((rn)localObject).text))) {
          break label685;
        }
        paramViewGroup.ofU.setText(((rn)localObject).text);
        paramViewGroup.ofT.setVisibility(0);
        paramViewGroup.ofT.setOnClickListener(CardNewMsgUI.this.jax);
        paramViewGroup.ofT.setTag(localg);
        paramViewGroup.ofS.setVisibility(0);
      }
      for (;;)
      {
        localg.bQb();
        localg.bQc();
        a(localg.nVZ, localg.nWa, paramViewGroup, localg);
        AppMethodBeat.o(113534);
        return paramView;
        paramViewGroup = (CardNewMsgUI.b)paramView.getTag();
        break;
        label558:
        ac.d("MicroMsg.CardNewMsgUI", "CardNewMsgUI getView () position : " + paramInt + " field_logo_color :  " + localg.field_logo_color);
        paramViewGroup.ofM.setVisibility(0);
        paramViewGroup.ofL.setVisibility(8);
        if (!TextUtils.isEmpty(localg.field_logo_url))
        {
          n.a(CardNewMsgUI.this, paramViewGroup.ofN, localg.field_logo_url, i, l.Vy(localg.field_logo_color));
          break label373;
        }
        n.b(paramViewGroup.ofN, 2131231506, l.Vy(localg.field_logo_color));
        break label373;
        label673:
        paramViewGroup.ofR.setVisibility(8);
        break label439;
        label685:
        paramViewGroup.ofT.setVisibility(8);
        paramViewGroup.ofS.setVisibility(8);
      }
    }
  }
  
  final class b
  {
    ImageView ofL;
    View ofM;
    ImageView ofN;
    TextView ofO;
    TextView ofP;
    TextView ofQ;
    TextView ofR;
    TextView ofS;
    View ofT;
    TextView ofU;
    LinearLayout ofV;
    LinearLayout ofW;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardNewMsgUI
 * JD-Core Version:    0.7.0.1
 */