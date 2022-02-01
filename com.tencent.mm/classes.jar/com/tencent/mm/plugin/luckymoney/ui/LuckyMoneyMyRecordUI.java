package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.luckymoney.hk.ui.LuckyMoneyHKBeforeDetailUI;
import com.tencent.mm.plugin.luckymoney.model.aa;
import com.tencent.mm.plugin.luckymoney.model.ag;
import com.tencent.mm.plugin.luckymoney.model.au;
import com.tencent.mm.plugin.luckymoney.model.av;
import com.tencent.mm.plugin.luckymoney.model.y;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.MMLoadMoreListView.a;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LuckyMoneyMyRecordUI
  extends LuckyMoneyBaseUI
{
  public String EBF;
  private boolean EGI;
  private Map<String, Integer> EGN;
  public String EGP;
  private MMLoadMoreListView EHn;
  private f EHo;
  private TextView EJJ;
  private TextView EJK;
  private TextView EJL;
  private TextView EJM;
  private TextView EJN;
  private TextView EJO;
  private TextView EJP;
  private String EJQ;
  private int EJR;
  public List<String> EJS;
  private List<com.tencent.mm.plugin.luckymoney.model.z> Eud;
  private TextView Euj;
  private int mType;
  private View mXN;
  private boolean puR;
  private ImageView tXu;
  private TextView tYz;
  private int zP;
  
  public LuckyMoneyMyRecordUI()
  {
    AppMethodBeat.i(65648);
    this.zP = 0;
    this.Eud = new LinkedList();
    this.EGN = new HashMap();
    this.EGI = true;
    this.puR = false;
    this.EJR = -1;
    this.EJS = new ArrayList();
    this.EGP = "";
    this.EBF = "";
    AppMethodBeat.o(65648);
  }
  
  private void ePD()
  {
    AppMethodBeat.i(65653);
    this.puR = true;
    if (this.zP == 0) {
      this.EGP = "";
    }
    doSceneProgress(new au(11, this.zP, this.mType, this.EJQ, "v1.0", this.EGP));
    AppMethodBeat.o(65653);
  }
  
  private void ePP()
  {
    AppMethodBeat.i(65651);
    this.EJJ.setVisibility(8);
    this.mXN.findViewById(a.f.lucky_money_my_detail_receive_desc).setVisibility(8);
    String str;
    if (this.mType == 1)
    {
      setMMTitle(getString(a.i.lucky_money_my_send));
      str = getString(a.i.lucky_money_send_amount_title, new Object[] { com.tencent.mm.model.z.bdb() });
      ag.a(getContext(), this.EJK, str);
      this.EJM.setText(a.i.lucky_money_send_num_title);
      this.EHo = new g(getContext());
      this.EJJ.setVisibility(0);
    }
    for (;;)
    {
      this.EHn.setAdapter(this.EHo);
      a.b.a(this.tXu, com.tencent.mm.model.z.bcZ(), 0.0F, false);
      this.EJP.setText(getString(a.i.lucky_money_record_year_title, new Object[] { Util.nullAsNil(this.EJQ) }));
      AppMethodBeat.o(65651);
      return;
      setMMTitle(getString(a.i.lucky_money_my_receive));
      str = getString(a.i.lucky_money_receive_amount_title, new Object[] { com.tencent.mm.model.z.bdb() });
      ag.a(getContext(), this.EJK, str);
      this.EJM.setText(a.i.lucky_money_receive_num_title);
      this.EHo = new e(getContext());
      this.mXN.findViewById(a.f.lucky_money_my_detail_receive_desc).setVisibility(0);
    }
  }
  
  private int ePQ()
  {
    if (this.mType == 1) {
      return 8;
    }
    return 9;
  }
  
  public int getLayoutId()
  {
    return a.g.lucky_money_my_record_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(65650);
    setBackBtn(new LuckyMoneyMyRecordUI.1(this));
    addIconOptionMenu(0, a.h.actionbar_icon_dark_more, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(65636);
        paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(LuckyMoneyMyRecordUI.this.getContext(), 1, false);
        paramAnonymousMenuItem.ODT = new q.f()
        {
          public final void onCreateMMMenu(o paramAnonymous2o)
          {
            AppMethodBeat.i(65634);
            paramAnonymous2o.mn(1, a.i.lucky_money_my_receive);
            paramAnonymous2o.mn(2, a.i.lucky_money_my_send);
            AppMethodBeat.o(65634);
          }
        };
        paramAnonymousMenuItem.ODU = new q.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(65635);
            switch (paramAnonymous2MenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(65635);
              return;
              if (LuckyMoneyMyRecordUI.a(LuckyMoneyMyRecordUI.this) != 2)
              {
                LuckyMoneyMyRecordUI.a(LuckyMoneyMyRecordUI.this, 2);
                LuckyMoneyMyRecordUI.b(LuckyMoneyMyRecordUI.this);
                LuckyMoneyMyRecordUI.c(LuckyMoneyMyRecordUI.this);
                LuckyMoneyMyRecordUI.d(LuckyMoneyMyRecordUI.this);
                AppMethodBeat.o(65635);
                return;
                if (LuckyMoneyMyRecordUI.a(LuckyMoneyMyRecordUI.this) != 1)
                {
                  LuckyMoneyMyRecordUI.a(LuckyMoneyMyRecordUI.this, 1);
                  LuckyMoneyMyRecordUI.b(LuckyMoneyMyRecordUI.this);
                  LuckyMoneyMyRecordUI.c(LuckyMoneyMyRecordUI.this);
                  LuckyMoneyMyRecordUI.d(LuckyMoneyMyRecordUI.this);
                }
              }
            }
          }
        };
        paramAnonymousMenuItem.eik();
        AppMethodBeat.o(65636);
        return false;
      }
    });
    this.tYz = ((TextView)findViewById(a.f.lucky_money_my_record_empty_tips));
    this.EHn = ((MMLoadMoreListView)findViewById(a.f.lucky_money_my_record_list));
    this.mXN = LayoutInflater.from(this).inflate(a.g.lucky_money_my_detail_header, null);
    this.EHn.addHeaderView(this.mXN);
    this.tXu = ((ImageView)this.mXN.findViewById(a.f.lucky_money_my_detail_avatar));
    this.EJK = ((TextView)this.mXN.findViewById(a.f.lucky_money_my_detail_nickname));
    this.Euj = ((TextView)this.mXN.findViewById(a.f.lucky_money_my_detail_amount));
    this.EJL = ((TextView)this.mXN.findViewById(a.f.lucky_money_my_detail_num));
    this.EJM = ((TextView)this.mXN.findViewById(a.f.lucky_money_my_detail_num_title));
    this.EJN = ((TextView)this.mXN.findViewById(a.f.lucky_money_my_detail_lucky_best_num));
    this.EJO = ((TextView)this.mXN.findViewById(a.f.lucky_money_my_detail_lucky_best_num_title));
    this.EJP = ((TextView)this.mXN.findViewById(a.f.lucky_money_my_detail_year));
    this.EJJ = ((TextView)this.mXN.findViewById(a.f.lucky_money_my_detail_send_desc));
    this.EHn.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(65637);
        b localb = new b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyMyRecordUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
        paramAnonymousInt = (int)paramAnonymousLong;
        com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(LuckyMoneyMyRecordUI.e(LuckyMoneyMyRecordUI.this)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
        if ((paramAnonymousInt >= 0) && (paramAnonymousInt < LuckyMoneyMyRecordUI.f(LuckyMoneyMyRecordUI.this).getCount()))
        {
          paramAnonymousView = LuckyMoneyMyRecordUI.f(LuckyMoneyMyRecordUI.this).Wf(paramAnonymousInt);
          if ((paramAnonymousView != null) && (!Util.isNullOrNil(paramAnonymousView.ybP)))
          {
            paramAnonymousAdapterView = new Intent();
            if (paramAnonymousView.Ezs != 2) {
              break label310;
            }
            Log.i("MicroMsg.LuckyMoneyMyRecordUI", "onItemClick: go busi detail");
            paramAnonymousAdapterView.setClass(LuckyMoneyMyRecordUI.this.getContext(), LuckyMoneyBusiDetailUI.class);
            paramAnonymousAdapterView.putExtra("key_sendid", paramAnonymousView.ybP);
            if (LuckyMoneyMyRecordUI.a(LuckyMoneyMyRecordUI.this) != 1) {
              break label459;
            }
          }
        }
        label310:
        label459:
        for (paramAnonymousInt = 3;; paramAnonymousInt = 1)
        {
          paramAnonymousAdapterView.putExtra("key_jump_from", paramAnonymousInt);
          paramAnonymousView = LuckyMoneyMyRecordUI.this;
          paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousAdapterView);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, paramAnonymousAdapterView.aFh(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyMyRecordUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyMyRecordUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyMyRecordUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(65637);
          return;
          if (paramAnonymousView.Ezs == 5)
          {
            Log.i("MicroMsg.LuckyMoneyMyRecordUI", "onItemClick: go union detail");
            paramAnonymousAdapterView.putExtra("key_hb_kind", paramAnonymousView.Ezs);
            paramAnonymousAdapterView.setClass(LuckyMoneyMyRecordUI.this.getContext(), LuckyMoneyBeforeDetailUI.class);
            break;
          }
          if (paramAnonymousView.Ezs == 6)
          {
            paramAnonymousAdapterView.putExtra("key_hb_kind", paramAnonymousView.Ezs);
            paramAnonymousAdapterView.putExtra("key_hk_scene", 2);
            paramAnonymousAdapterView.setClass(LuckyMoneyMyRecordUI.this.getContext(), LuckyMoneyHKBeforeDetailUI.class);
            break;
          }
          if (paramAnonymousView.Ezs == 7)
          {
            paramAnonymousAdapterView.putExtra("key_hb_kind", paramAnonymousView.Ezs);
            paramAnonymousAdapterView.setClass(LuckyMoneyMyRecordUI.this.getContext(), LuckyMoneyBeforeDetailUI.class);
            break;
          }
          Log.i("MicroMsg.LuckyMoneyMyRecordUI", "onItemClick: go normal detail");
          paramAnonymousAdapterView.setClass(LuckyMoneyMyRecordUI.this.getContext(), LuckyMoneyBeforeDetailUI.class);
          break;
        }
      }
    });
    this.EHn.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(65639);
        if ((paramAnonymousInt <= 0) || (paramAnonymousInt > LuckyMoneyMyRecordUI.f(LuckyMoneyMyRecordUI.this).getCount()))
        {
          AppMethodBeat.o(65639);
          return true;
        }
        com.tencent.mm.ui.base.h.a(LuckyMoneyMyRecordUI.this, LuckyMoneyMyRecordUI.this.getResources().getString(a.i.lucky_money_list_delete_record), null, LuckyMoneyMyRecordUI.this.getResources().getString(a.i.app_delete), new h.d()
        {
          public final void qy(int paramAnonymous2Int)
          {
            AppMethodBeat.i(65638);
            switch (paramAnonymous2Int)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(65638);
              return;
              com.tencent.mm.plugin.luckymoney.model.z localz = LuckyMoneyMyRecordUI.f(LuckyMoneyMyRecordUI.this).Wf(this.EJV);
              if (localz != null)
              {
                LuckyMoneyMyRecordUI.b(LuckyMoneyMyRecordUI.this, this.EJV);
                LuckyMoneyMyRecordUI.a(LuckyMoneyMyRecordUI.this, localz, this.EJV);
              }
            }
          }
        });
        AppMethodBeat.o(65639);
        return true;
      }
    });
    this.EHn.setOnLoadMoreListener(new MMLoadMoreListView.a()
    {
      public final void onLoadMore()
      {
        AppMethodBeat.i(65640);
        if (!LuckyMoneyMyRecordUI.this.EGu.isProcessing()) {
          LuckyMoneyMyRecordUI.g(LuckyMoneyMyRecordUI.this);
        }
        if ((LuckyMoneyMyRecordUI.h(LuckyMoneyMyRecordUI.this)) && (!LuckyMoneyMyRecordUI.i(LuckyMoneyMyRecordUI.this))) {
          LuckyMoneyMyRecordUI.d(LuckyMoneyMyRecordUI.this);
        }
        AppMethodBeat.o(65640);
      }
    });
    this.tXu.setOnClickListener(new LuckyMoneyMyRecordUI.6(this));
    ePP();
    AppMethodBeat.o(65650);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65649);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(a.c.lucky_money_new_actionbar_color));
    setActionbarElementColor(getResources().getColor(a.c.lucky_money_goldstyle_envelop_primary_text_color));
    this.mType = getIntent().getIntExtra("key_type", 2);
    initView();
    ePD();
    com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(ePQ()), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    AppMethodBeat.o(65649);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(65652);
    if ((paramq instanceof au))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (au)paramq;
        paramq = paramString.EBC.Ezu;
        this.EGP = paramString.EBl;
        this.EBF = paramString.EBF;
        Object localObject2;
        if (this.zP == 0)
        {
          this.EJS = paramString.EBD;
          this.EJQ = paramString.EBE;
          localObject1 = findViewById(a.f.lucky_money_my_detail_year_select);
          localObject2 = (ImageView)findViewById(a.f.lucky_money_my_detail_year_icon);
          if (this.EJS.size() > 1)
          {
            ((ImageView)localObject2).setVisibility(0);
            ((View)localObject1).setOnClickListener(new LuckyMoneyMyRecordUI.7(this));
          }
          this.EJP.setText(getString(a.i.lucky_money_record_year_title, new Object[] { this.EJQ }));
        }
        Object localObject1 = paramString.EBC;
        if (localObject1 != null)
        {
          if (this.mType != 1) {
            break label387;
          }
          this.Euj.setText(com.tencent.mm.wallet_core.ui.g.formatMoney2f(((y)localObject1).EAo / 100.0D));
          localObject1 = ((y)localObject1).EAn;
          Object localObject3 = getString(a.i.lucky_money_send_num_desc, new Object[] { localObject1 });
          localObject2 = new ForegroundColorSpan(getResources().getColor(a.c.lucky_money_goldstyle_detail_primary_text_color));
          paramInt1 = ((String)localObject3).indexOf((String)localObject1);
          localObject3 = new SpannableString((CharSequence)localObject3);
          ((SpannableString)localObject3).setSpan(localObject2, paramInt1, ((String)localObject1).length() + paramInt1, 33);
          this.EJJ.setText((CharSequence)localObject3);
        }
        while (paramq != null)
        {
          paramInt1 = 0;
          for (;;)
          {
            if (paramInt1 < paramq.size())
            {
              localObject1 = (com.tencent.mm.plugin.luckymoney.model.z)paramq.get(paramInt1);
              if (!this.EGN.containsKey(((com.tencent.mm.plugin.luckymoney.model.z)localObject1).ybP))
              {
                this.Eud.add(paramq.get(paramInt1));
                this.EGN.put(((com.tencent.mm.plugin.luckymoney.model.z)localObject1).ybP, Integer.valueOf(1));
              }
              paramInt1 += 1;
              continue;
              label387:
              this.Euj.setText(com.tencent.mm.wallet_core.ui.g.formatMoney2f(((y)localObject1).EAm / 100.0D));
              this.EJL.setText(((y)localObject1).EAl);
              this.EJN.setText(((y)localObject1).EAp);
              break;
            }
          }
          this.zP += paramq.size();
          this.EGI = paramString.eOJ();
          this.puR = false;
          this.EHo.fS(this.Eud);
        }
        if ((this.Eud == null) || (this.Eud.size() == 0))
        {
          this.tYz.setVisibility(0);
          if (!this.EGI) {
            break label561;
          }
          this.EHn.hJK();
        }
        for (;;)
        {
          AppMethodBeat.o(65652);
          return true;
          this.tYz.setVisibility(8);
          break;
          label561:
          this.EHn.hJL();
        }
      }
      this.EBF = null;
    }
    int i;
    do
    {
      do
      {
        AppMethodBeat.o(65652);
        return false;
      } while (!(paramq instanceof av));
      i = this.EJR;
      this.EJR = -1;
    } while ((paramInt1 != 0) || (paramInt2 != 0));
    paramString = this.EHo.Wf(i);
    if (paramString != null)
    {
      Toast.makeText(this, a.i.lucky_money_list_delete_record_succ, 0).show();
      this.EHo.a(paramString);
      this.EHo.notifyDataSetChanged();
    }
    for (;;)
    {
      AppMethodBeat.o(65652);
      return true;
      Log.e("MicroMsg.LuckyMoneyMyRecordUI", "can't found local record");
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
  {
    List<String> EJS;
    int bhr;
    
    a() {}
    
    public final int getCount()
    {
      AppMethodBeat.i(65644);
      int i = this.EJS.size();
      AppMethodBeat.o(65644);
      return i;
    }
    
    public final String getItem(int paramInt)
    {
      AppMethodBeat.i(65645);
      String str = (String)this.EJS.get(paramInt);
      AppMethodBeat.o(65645);
      return str;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(65646);
      paramView = (CheckedTextView)LayoutInflater.from(LuckyMoneyMyRecordUI.this.getContext()).inflate(a.g.wallet_list_dialog_item_singlechoice, paramViewGroup, false);
      paramView.setText(getItem(paramInt));
      if (paramInt == this.bhr) {
        paramView.setChecked(true);
      }
      for (;;)
      {
        AppMethodBeat.o(65646);
        return paramView;
        paramView.setChecked(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI
 * JD-Core Version:    0.7.0.1
 */