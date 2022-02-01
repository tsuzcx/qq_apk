package com.tencent.mm.plugin.luckymoney.ui;

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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.accessibility.type.ViewType;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.luckymoney.hk.ui.LuckyMoneyHKBeforeDetailUI;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.luckymoney.model.av;
import com.tencent.mm.plugin.luckymoney.model.aw;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.plugin.luckymoney.model.y;
import com.tencent.mm.plugin.report.service.h;
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
import com.tencent.mm.ui.base.k.d;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.wallet_core.ui.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LuckyMoneyMyRecordUI
  extends LuckyMoneyBaseUI
{
  private MMLoadMoreListView KAA;
  private f KAB;
  private TextView KDq;
  private TextView KDr;
  private TextView KDs;
  private TextView KDt;
  private TextView KDu;
  private TextView KDv;
  private TextView KDw;
  private String KDx;
  private int KDy;
  public List<String> KDz;
  private List<y> KmK;
  private TextView KmQ;
  public String KuF;
  private boolean KzR;
  private Map<String, Integer> KzW;
  public String KzY;
  private int Sc;
  private int mType;
  private View pUv;
  private boolean szX;
  private ImageView xaN;
  private TextView xbR;
  
  public LuckyMoneyMyRecordUI()
  {
    AppMethodBeat.i(65648);
    this.Sc = 0;
    this.KmK = new LinkedList();
    this.KzW = new HashMap();
    this.KzR = true;
    this.szX = false;
    this.KDy = -1;
    this.KDz = new ArrayList();
    this.KzY = "";
    this.KuF = "";
    AppMethodBeat.o(65648);
  }
  
  private void fYg()
  {
    AppMethodBeat.i(65653);
    this.szX = true;
    if (this.Sc == 0) {
      this.KzY = "";
    }
    doSceneProgress(new av(11, this.Sc, this.mType, this.KDx, "v1.0", this.KzY));
    AppMethodBeat.o(65653);
  }
  
  private void fYv()
  {
    AppMethodBeat.i(65651);
    this.KDq.setVisibility(8);
    this.pUv.findViewById(a.f.lucky_money_my_detail_receive_desc).setVisibility(8);
    String str;
    if (this.mType == 1)
    {
      setMMTitle(getString(a.i.lucky_money_my_send));
      str = getString(a.i.lucky_money_send_amount_title, new Object[] { com.tencent.mm.model.z.bAO() });
      ah.a(getContext(), this.KDr, str);
      this.KDt.setText(a.i.lucky_money_send_num_title);
      this.KAB = new g(getContext());
      this.KDq.setVisibility(0);
    }
    for (;;)
    {
      this.KAA.setAdapter(this.KAB);
      a.b.a(this.xaN, com.tencent.mm.model.z.bAM(), 0.0F, false);
      this.KDw.setText(getString(a.i.lucky_money_record_year_title, new Object[] { Util.nullAsNil(this.KDx) }));
      AppMethodBeat.o(65651);
      return;
      setMMTitle(getString(a.i.lucky_money_my_receive));
      str = getString(a.i.lucky_money_receive_amount_title, new Object[] { com.tencent.mm.model.z.bAO() });
      ah.a(getContext(), this.KDr, str);
      this.KDt.setText(a.i.lucky_money_receive_num_title);
      this.KAB = new e(getContext());
      this.pUv.findViewById(a.f.lucky_money_my_detail_receive_desc).setVisibility(0);
    }
  }
  
  private int fYw()
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
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(65633);
        LuckyMoneyMyRecordUI.this.finish();
        AppMethodBeat.o(65633);
        return true;
      }
    });
    addIconOptionMenu(0, a.h.actionbar_icon_dark_more, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(65636);
        paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.f(LuckyMoneyMyRecordUI.this.getContext(), 1, false);
        paramAnonymousMenuItem.Vtg = new u.g()
        {
          public final void onCreateMMMenu(s paramAnonymous2s)
          {
            AppMethodBeat.i(65634);
            paramAnonymous2s.oh(1, a.i.lucky_money_my_receive);
            paramAnonymous2s.oh(2, a.i.lucky_money_my_send);
            AppMethodBeat.o(65634);
          }
        };
        paramAnonymousMenuItem.GAC = new u.i()
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
        paramAnonymousMenuItem.dDn();
        AppMethodBeat.o(65636);
        return false;
      }
    });
    this.xbR = ((TextView)findViewById(a.f.lucky_money_my_record_empty_tips));
    this.KAA = ((MMLoadMoreListView)findViewById(a.f.lucky_money_my_record_list));
    this.pUv = LayoutInflater.from(this).inflate(a.g.lucky_money_my_detail_header, null);
    this.KAA.addHeaderView(this.pUv);
    this.xaN = ((ImageView)this.pUv.findViewById(a.f.lucky_money_my_detail_avatar));
    this.KDr = ((TextView)this.pUv.findViewById(a.f.lucky_money_my_detail_nickname));
    this.KmQ = ((TextView)this.pUv.findViewById(a.f.lucky_money_my_detail_amount));
    this.KDs = ((TextView)this.pUv.findViewById(a.f.lucky_money_my_detail_num));
    this.KDt = ((TextView)this.pUv.findViewById(a.f.lucky_money_my_detail_num_title));
    this.KDu = ((TextView)this.pUv.findViewById(a.f.lucky_money_my_detail_lucky_best_num));
    this.KDv = ((TextView)this.pUv.findViewById(a.f.lucky_money_my_detail_lucky_best_num_title));
    this.KDw = ((TextView)this.pUv.findViewById(a.f.lucky_money_my_detail_year));
    this.KDq = ((TextView)this.pUv.findViewById(a.f.lucky_money_my_detail_send_desc));
    this.KAA.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(65637);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyMyRecordUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        paramAnonymousInt = (int)paramAnonymousLong;
        h.OAn.b(11701, new Object[] { Integer.valueOf(LuckyMoneyMyRecordUI.e(LuckyMoneyMyRecordUI.this)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
        if ((paramAnonymousInt >= 0) && (paramAnonymousInt < LuckyMoneyMyRecordUI.f(LuckyMoneyMyRecordUI.this).getCount()))
        {
          paramAnonymousView = LuckyMoneyMyRecordUI.f(LuckyMoneyMyRecordUI.this).aab(paramAnonymousInt);
          if ((paramAnonymousView != null) && (!Util.isNullOrNil(paramAnonymousView.CAf)))
          {
            paramAnonymousAdapterView = new Intent();
            if (paramAnonymousView.Ksf != 2) {
              break label310;
            }
            Log.i("MicroMsg.LuckyMoneyMyRecordUI", "onItemClick: go busi detail");
            paramAnonymousAdapterView.setClass(LuckyMoneyMyRecordUI.this.getContext(), LuckyMoneyBusiDetailUI.class);
            paramAnonymousAdapterView.putExtra("key_sendid", paramAnonymousView.CAf);
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
          paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousAdapterView);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, paramAnonymousAdapterView.aYi(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyMyRecordUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyMyRecordUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyMyRecordUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(65637);
          return;
          if (paramAnonymousView.Ksf == 5)
          {
            Log.i("MicroMsg.LuckyMoneyMyRecordUI", "onItemClick: go union detail");
            paramAnonymousAdapterView.putExtra("key_hb_kind", paramAnonymousView.Ksf);
            paramAnonymousAdapterView.setClass(LuckyMoneyMyRecordUI.this.getContext(), LuckyMoneyBeforeDetailUI.class);
            break;
          }
          if (paramAnonymousView.Ksf == 6)
          {
            paramAnonymousAdapterView.putExtra("key_hb_kind", paramAnonymousView.Ksf);
            paramAnonymousAdapterView.putExtra("key_hk_scene", 2);
            paramAnonymousAdapterView.setClass(LuckyMoneyMyRecordUI.this.getContext(), LuckyMoneyHKBeforeDetailUI.class);
            break;
          }
          if (paramAnonymousView.Ksf == 7)
          {
            paramAnonymousAdapterView.putExtra("key_hb_kind", paramAnonymousView.Ksf);
            paramAnonymousAdapterView.setClass(LuckyMoneyMyRecordUI.this.getContext(), LuckyMoneyBeforeDetailUI.class);
            break;
          }
          Log.i("MicroMsg.LuckyMoneyMyRecordUI", "onItemClick: go normal detail");
          paramAnonymousAdapterView.setClass(LuckyMoneyMyRecordUI.this.getContext(), LuckyMoneyBeforeDetailUI.class);
          break;
        }
      }
    });
    this.KAA.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(65639);
        if ((paramAnonymousInt <= 0) || (paramAnonymousInt > LuckyMoneyMyRecordUI.f(LuckyMoneyMyRecordUI.this).getCount()))
        {
          AppMethodBeat.o(65639);
          return true;
        }
        com.tencent.mm.ui.base.k.a(LuckyMoneyMyRecordUI.this, LuckyMoneyMyRecordUI.this.getResources().getString(a.i.lucky_money_list_delete_record), null, LuckyMoneyMyRecordUI.this.getResources().getString(a.i.app_delete), new k.d()
        {
          public final void qz(int paramAnonymous2Int)
          {
            AppMethodBeat.i(65638);
            switch (paramAnonymous2Int)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(65638);
              return;
              y localy = LuckyMoneyMyRecordUI.f(LuckyMoneyMyRecordUI.this).aab(this.KDC);
              if (localy != null)
              {
                LuckyMoneyMyRecordUI.b(LuckyMoneyMyRecordUI.this, this.KDC);
                LuckyMoneyMyRecordUI.a(LuckyMoneyMyRecordUI.this, localy, this.KDC);
              }
            }
          }
        });
        AppMethodBeat.o(65639);
        return true;
      }
    });
    this.KAA.setOnLoadMoreListener(new MMLoadMoreListView.a()
    {
      public final void onLoadMore()
      {
        AppMethodBeat.i(65640);
        if (!LuckyMoneyMyRecordUI.this.KzD.isProcessing()) {
          LuckyMoneyMyRecordUI.g(LuckyMoneyMyRecordUI.this);
        }
        if ((LuckyMoneyMyRecordUI.h(LuckyMoneyMyRecordUI.this)) && (!LuckyMoneyMyRecordUI.i(LuckyMoneyMyRecordUI.this))) {
          LuckyMoneyMyRecordUI.d(LuckyMoneyMyRecordUI.this);
        }
        AppMethodBeat.o(65640);
      }
    });
    this.xaN.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(284128);
        if (!Util.isNullOrNil(LuckyMoneyMyRecordUI.this.KuF))
        {
          i.p(LuckyMoneyMyRecordUI.this, LuckyMoneyMyRecordUI.this.KuF, true);
          AppMethodBeat.o(284128);
          return;
        }
        Log.w("MicroMsg.LuckyMoneyMyRecordUI", "hy: no avatar jump h5");
        AppMethodBeat.o(284128);
      }
    });
    fYv();
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
    fYg();
    h.OAn.b(11701, new Object[] { Integer.valueOf(fYw()), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    AppMethodBeat.o(65649);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(65652);
    if ((paramp instanceof av))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (av)paramp;
        paramp = paramString.KuC.Ksg;
        this.KzY = paramString.Kuj;
        this.KuF = paramString.KuF;
        Object localObject2;
        if (this.Sc == 0)
        {
          this.KDz = paramString.KuD;
          this.KDx = paramString.KuE;
          localObject1 = findViewById(a.f.lucky_money_my_detail_year_select);
          localObject2 = (ImageView)findViewById(a.f.lucky_money_my_detail_year_icon);
          if (this.KDz.size() > 1)
          {
            ((ImageView)localObject2).setVisibility(0);
            ((View)localObject1).setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
            {
              public final void dr(View paramAnonymousView)
              {
                AppMethodBeat.i(284123);
                LuckyMoneyMyRecordUI.this.showDialog(1);
                AppMethodBeat.o(284123);
              }
            });
          }
          this.KDw.setText(getString(a.i.lucky_money_record_year_title, new Object[] { this.KDx }));
        }
        Object localObject1 = paramString.KuC;
        if (localObject1 != null)
        {
          if (this.mType != 1) {
            break label390;
          }
          this.KmQ.setText(i.formatMoney2f(((x)localObject1).Kte / 100.0D));
          localObject1 = ((x)localObject1).Ktd;
          Object localObject3 = getString(a.i.lucky_money_send_num_desc, new Object[] { localObject1 });
          localObject2 = new ForegroundColorSpan(getResources().getColor(a.c.lucky_money_goldstyle_detail_primary_text_color));
          paramInt1 = ((String)localObject3).indexOf((String)localObject1);
          localObject3 = new SpannableString((CharSequence)localObject3);
          ((SpannableString)localObject3).setSpan(localObject2, paramInt1, ((String)localObject1).length() + paramInt1, 33);
          this.KDq.setText((CharSequence)localObject3);
        }
        while (paramp != null)
        {
          paramInt1 = 0;
          for (;;)
          {
            if (paramInt1 < paramp.size())
            {
              localObject1 = (y)paramp.get(paramInt1);
              if (!this.KzW.containsKey(((y)localObject1).CAf))
              {
                this.KmK.add((y)paramp.get(paramInt1));
                this.KzW.put(((y)localObject1).CAf, Integer.valueOf(1));
              }
              paramInt1 += 1;
              continue;
              label390:
              this.KmQ.setText(i.formatMoney2f(((x)localObject1).Ktc / 100.0D));
              this.KDs.setText(((x)localObject1).Ktb);
              this.KDu.setText(((x)localObject1).Ktf);
              break;
            }
          }
          this.Sc += paramp.size();
          this.KzR = paramString.fXm();
          this.szX = false;
          this.KAB.iQ(this.KmK);
        }
        if ((this.KmK == null) || (this.KmK.size() == 0))
        {
          this.xbR.setVisibility(0);
          if (!this.KzR) {
            break label564;
          }
          this.KAA.jms();
        }
        for (;;)
        {
          AppMethodBeat.o(65652);
          return true;
          this.xbR.setVisibility(8);
          break;
          label564:
          this.KAA.jmt();
        }
      }
      this.KuF = null;
    }
    int i;
    do
    {
      do
      {
        AppMethodBeat.o(65652);
        return false;
      } while (!(paramp instanceof aw));
      i = this.KDy;
      this.KDy = -1;
    } while ((paramInt1 != 0) || (paramInt2 != 0));
    paramString = this.KAB.aab(i);
    if (paramString != null)
    {
      Toast.makeText(this, a.i.lucky_money_list_delete_record_succ, 0).show();
      this.KAB.a(paramString);
      this.KAB.notifyDataSetChanged();
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
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(284244);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(a.class);
    AppMethodBeat.o(284244);
  }
  
  public static class a
    extends MMBaseAccessibilityConfig
  {
    public a(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
    
    public void initConfig()
    {
      AppMethodBeat.i(284148);
      root(a.g.lucky_money_my_detail_header).view(a.f.lucky_money_detail_header_layout).type(ViewType.TextView);
      root(a.g.lucky_money_my_detail_header).view(a.f.lucky_money_my_detail_year_select).desc(a.f.lucky_money_my_detail_year).type(ViewType.Button);
      root(a.g.lucky_money_my_receive_record_item).view(a.f.lucky_money_my_record_item_layout).desc(new kotlin.g.a.b() {}).type(ViewType.Button);
      AppMethodBeat.o(284148);
    }
  }
  
  final class b
    extends BaseAdapter
  {
    List<String> KDz;
    int dbk;
    
    b() {}
    
    public final int getCount()
    {
      AppMethodBeat.i(65644);
      int i = this.KDz.size();
      AppMethodBeat.o(65644);
      return i;
    }
    
    public final String getItem(int paramInt)
    {
      AppMethodBeat.i(65645);
      String str = (String)this.KDz.get(paramInt);
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
      if (paramInt == this.dbk) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI
 * JD-Core Version:    0.7.0.1
 */