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
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.luckymoney.hk.ui.LuckyMoneyHKBeforeDetailUI;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.at;
import com.tencent.mm.plugin.luckymoney.model.au;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.plugin.luckymoney.model.y;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.MMLoadMoreListView.a;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LuckyMoneyMyRecordUI
  extends LuckyMoneyBaseUI
{
  private int fs;
  private View kgo;
  private int mType;
  private boolean mwr;
  private ImageView qyu;
  private TextView qzz;
  private List<y> yQe;
  private TextView yQk;
  public String yXA;
  private MMLoadMoreListView zcN;
  private f zcO;
  private boolean zci;
  private Map<String, Integer> zcn;
  public String zcp;
  private TextView zeG;
  private TextView zeH;
  private TextView zeI;
  private TextView zeJ;
  private TextView zeK;
  private TextView zeL;
  private TextView zeM;
  private String zeN;
  private int zeO;
  public List<String> zeP;
  
  public LuckyMoneyMyRecordUI()
  {
    AppMethodBeat.i(65648);
    this.fs = 0;
    this.yQe = new LinkedList();
    this.zcn = new HashMap();
    this.zci = true;
    this.mwr = false;
    this.zeO = -1;
    this.zeP = new ArrayList();
    this.zcp = "";
    this.yXA = "";
    AppMethodBeat.o(65648);
  }
  
  private void egc()
  {
    AppMethodBeat.i(65653);
    this.mwr = true;
    if (this.fs == 0) {
      this.zcp = "";
    }
    doSceneProgress(new at(11, this.fs, this.mType, this.zeN, "v1.0", this.zcp));
    AppMethodBeat.o(65653);
  }
  
  private void egm()
  {
    AppMethodBeat.i(65651);
    this.zeG.setVisibility(8);
    this.kgo.findViewById(2131304163).setVisibility(8);
    String str;
    if (this.mType == 1)
    {
      setMMTitle(getString(2131762672));
      str = getString(2131762728, new Object[] { com.tencent.mm.model.z.aUa() });
      af.a(getContext(), this.zeH, str);
      this.zeJ.setText(2131762734);
      this.zcO = new g(getContext());
      this.zeG.setVisibility(0);
    }
    for (;;)
    {
      this.zcN.setAdapter(this.zcO);
      a.b.a(this.qyu, com.tencent.mm.model.z.aTY(), 0.0F, false);
      this.zeM.setText(getString(2131762717, new Object[] { Util.nullAsNil(this.zeN) }));
      AppMethodBeat.o(65651);
      return;
      setMMTitle(getString(2131762670));
      str = getString(2131762715, new Object[] { com.tencent.mm.model.z.aUa() });
      af.a(getContext(), this.zeH, str);
      this.zeJ.setText(2131762716);
      this.zcO = new e(getContext());
      this.kgo.findViewById(2131304163).setVisibility(0);
    }
  }
  
  private int egn()
  {
    if (this.mType == 1) {
      return 8;
    }
    return 9;
  }
  
  public int getLayoutId()
  {
    return 2131495372;
  }
  
  public void initView()
  {
    AppMethodBeat.i(65650);
    setBackBtn(new LuckyMoneyMyRecordUI.1(this));
    addIconOptionMenu(0, 2131689495, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(65636);
        paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(LuckyMoneyMyRecordUI.this.getContext(), 1, false);
        paramAnonymousMenuItem.HLX = new o.f()
        {
          public final void onCreateMMMenu(m paramAnonymous2m)
          {
            AppMethodBeat.i(65634);
            paramAnonymous2m.kV(1, 2131762670);
            paramAnonymous2m.kV(2, 2131762672);
            AppMethodBeat.o(65634);
          }
        };
        paramAnonymousMenuItem.HLY = new o.g()
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
        paramAnonymousMenuItem.dGm();
        AppMethodBeat.o(65636);
        return false;
      }
    });
    this.qzz = ((TextView)findViewById(2131304170));
    this.zcN = ((MMLoadMoreListView)findViewById(2131304172));
    this.kgo = LayoutInflater.from(this).inflate(2131495370, null);
    this.zcN.addHeaderView(this.kgo);
    this.qyu = ((ImageView)this.kgo.findViewById(2131304157));
    this.zeH = ((TextView)this.kgo.findViewById(2131304160));
    this.yQk = ((TextView)this.kgo.findViewById(2131304156));
    this.zeI = ((TextView)this.kgo.findViewById(2131304161));
    this.zeJ = ((TextView)this.kgo.findViewById(2131304162));
    this.zeK = ((TextView)this.kgo.findViewById(2131304158));
    this.zeL = ((TextView)this.kgo.findViewById(2131304159));
    this.zeM = ((TextView)this.kgo.findViewById(2131304165));
    this.zeG = ((TextView)this.kgo.findViewById(2131304164));
    this.zcN.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(65637);
        b localb = new b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyMyRecordUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        paramAnonymousInt = (int)paramAnonymousLong;
        com.tencent.mm.plugin.report.service.h.CyF.a(11701, new Object[] { Integer.valueOf(LuckyMoneyMyRecordUI.e(LuckyMoneyMyRecordUI.this)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
        if ((paramAnonymousInt >= 0) && (paramAnonymousInt < LuckyMoneyMyRecordUI.f(LuckyMoneyMyRecordUI.this).getCount()))
        {
          paramAnonymousView = LuckyMoneyMyRecordUI.f(LuckyMoneyMyRecordUI.this).PT(paramAnonymousInt);
          if ((paramAnonymousView != null) && (!Util.isNullOrNil(paramAnonymousView.yQE)))
          {
            paramAnonymousAdapterView = new Intent();
            if (paramAnonymousView.yVv != 2) {
              break label310;
            }
            Log.i("MicroMsg.LuckyMoneyMyRecordUI", "onItemClick: go busi detail");
            paramAnonymousAdapterView.setClass(LuckyMoneyMyRecordUI.this.getContext(), LuckyMoneyBusiDetailUI.class);
            paramAnonymousAdapterView.putExtra("key_sendid", paramAnonymousView.yQE);
            if (LuckyMoneyMyRecordUI.a(LuckyMoneyMyRecordUI.this) != 1) {
              break label422;
            }
          }
        }
        label422:
        for (paramAnonymousInt = 3;; paramAnonymousInt = 1)
        {
          paramAnonymousAdapterView.putExtra("key_jump_from", paramAnonymousInt);
          paramAnonymousView = LuckyMoneyMyRecordUI.this;
          paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousAdapterView);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousAdapterView.axQ(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyMyRecordUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyMyRecordUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyMyRecordUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(65637);
          return;
          label310:
          if (paramAnonymousView.yVv == 5)
          {
            Log.i("MicroMsg.LuckyMoneyMyRecordUI", "onItemClick: go union detail");
            paramAnonymousAdapterView.putExtra("key_hb_kind", paramAnonymousView.yVv);
            paramAnonymousAdapterView.setClass(LuckyMoneyMyRecordUI.this.getContext(), LuckyMoneyBeforeDetailUI.class);
            break;
          }
          if (paramAnonymousView.yVv == 6)
          {
            paramAnonymousAdapterView.putExtra("key_hb_kind", paramAnonymousView.yVv);
            paramAnonymousAdapterView.putExtra("key_hk_scene", 2);
            paramAnonymousAdapterView.setClass(LuckyMoneyMyRecordUI.this.getContext(), LuckyMoneyHKBeforeDetailUI.class);
            break;
          }
          Log.i("MicroMsg.LuckyMoneyMyRecordUI", "onItemClick: go normal detail");
          paramAnonymousAdapterView.setClass(LuckyMoneyMyRecordUI.this.getContext(), LuckyMoneyBeforeDetailUI.class);
          break;
        }
      }
    });
    this.zcN.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(65639);
        if ((paramAnonymousInt <= 0) || (paramAnonymousInt > LuckyMoneyMyRecordUI.f(LuckyMoneyMyRecordUI.this).getCount()))
        {
          AppMethodBeat.o(65639);
          return true;
        }
        com.tencent.mm.ui.base.h.a(LuckyMoneyMyRecordUI.this, LuckyMoneyMyRecordUI.this.getResources().getString(2131762658), null, LuckyMoneyMyRecordUI.this.getResources().getString(2131755778), new h.d()
        {
          public final void oj(int paramAnonymous2Int)
          {
            AppMethodBeat.i(65638);
            switch (paramAnonymous2Int)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(65638);
              return;
              y localy = LuckyMoneyMyRecordUI.f(LuckyMoneyMyRecordUI.this).PT(this.zeS);
              if (localy != null)
              {
                LuckyMoneyMyRecordUI.b(LuckyMoneyMyRecordUI.this, this.zeS);
                LuckyMoneyMyRecordUI.a(LuckyMoneyMyRecordUI.this, localy, this.zeS);
              }
            }
          }
        });
        AppMethodBeat.o(65639);
        return true;
      }
    });
    this.zcN.setOnLoadMoreListener(new MMLoadMoreListView.a()
    {
      public final void onLoadMore()
      {
        AppMethodBeat.i(65640);
        if (!LuckyMoneyMyRecordUI.this.zbX.isProcessing()) {
          LuckyMoneyMyRecordUI.g(LuckyMoneyMyRecordUI.this);
        }
        if ((LuckyMoneyMyRecordUI.h(LuckyMoneyMyRecordUI.this)) && (!LuckyMoneyMyRecordUI.i(LuckyMoneyMyRecordUI.this))) {
          LuckyMoneyMyRecordUI.d(LuckyMoneyMyRecordUI.this);
        }
        AppMethodBeat.o(65640);
      }
    });
    this.qyu.setOnClickListener(new LuckyMoneyMyRecordUI.6(this));
    egm();
    AppMethodBeat.o(65650);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65649);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131100760));
    setActionbarElementColor(getResources().getColor(2131100744));
    this.mType = getIntent().getIntExtra("key_type", 2);
    initView();
    egc();
    com.tencent.mm.plugin.report.service.h.CyF.a(11701, new Object[] { Integer.valueOf(egn()), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    AppMethodBeat.o(65649);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(65652);
    if ((paramq instanceof at))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (at)paramq;
        paramq = paramString.yXx.yVw;
        this.zcp = paramString.yXg;
        this.yXA = paramString.yXA;
        Object localObject2;
        if (this.fs == 0)
        {
          this.zeP = paramString.yXy;
          this.zeN = paramString.yXz;
          localObject1 = findViewById(2131304167);
          localObject2 = (ImageView)findViewById(2131304166);
          if (this.zeP.size() > 1)
          {
            ((ImageView)localObject2).setVisibility(0);
            ((View)localObject1).setOnClickListener(new LuckyMoneyMyRecordUI.7(this));
          }
          this.zeM.setText(getString(2131762717, new Object[] { this.zeN }));
        }
        Object localObject1 = paramString.yXx;
        if (localObject1 != null)
        {
          if (this.mType != 1) {
            break label387;
          }
          this.yQk.setText(com.tencent.mm.wallet_core.ui.f.formatMoney2f(((x)localObject1).yWl / 100.0D));
          localObject1 = ((x)localObject1).yWk;
          Object localObject3 = getString(2131762733, new Object[] { localObject1 });
          localObject2 = new ForegroundColorSpan(getResources().getColor(2131100742));
          paramInt1 = ((String)localObject3).indexOf((String)localObject1);
          localObject3 = new SpannableString((CharSequence)localObject3);
          ((SpannableString)localObject3).setSpan(localObject2, paramInt1, ((String)localObject1).length() + paramInt1, 33);
          this.zeG.setText((CharSequence)localObject3);
        }
        while (paramq != null)
        {
          paramInt1 = 0;
          for (;;)
          {
            if (paramInt1 < paramq.size())
            {
              localObject1 = (y)paramq.get(paramInt1);
              if (!this.zcn.containsKey(((y)localObject1).yQE))
              {
                this.yQe.add(paramq.get(paramInt1));
                this.zcn.put(((y)localObject1).yQE, Integer.valueOf(1));
              }
              paramInt1 += 1;
              continue;
              label387:
              this.yQk.setText(com.tencent.mm.wallet_core.ui.f.formatMoney2f(((x)localObject1).yWj / 100.0D));
              this.zeI.setText(((x)localObject1).yWi);
              this.zeK.setText(((x)localObject1).yWm);
              break;
            }
          }
          this.fs += paramq.size();
          this.zci = paramString.efl();
          this.mwr = false;
          this.zcO.fq(this.yQe);
        }
        if ((this.yQe == null) || (this.yQe.size() == 0))
        {
          this.qzz.setVisibility(0);
          if (!this.zci) {
            break label561;
          }
          this.zcN.gKM();
        }
        for (;;)
        {
          AppMethodBeat.o(65652);
          return true;
          this.qzz.setVisibility(8);
          break;
          label561:
          this.zcN.gKN();
        }
      }
      this.yXA = null;
    }
    int i;
    do
    {
      do
      {
        AppMethodBeat.o(65652);
        return false;
      } while (!(paramq instanceof au));
      i = this.zeO;
      this.zeO = -1;
    } while ((paramInt1 != 0) || (paramInt2 != 0));
    paramString = this.zcO.PT(i);
    if (paramString != null)
    {
      Toast.makeText(this, 2131762659, 0).show();
      this.zcO.a(paramString);
      this.zcO.notifyDataSetChanged();
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
    int bxP;
    List<String> zeP;
    
    a() {}
    
    public final int getCount()
    {
      AppMethodBeat.i(65644);
      int i = this.zeP.size();
      AppMethodBeat.o(65644);
      return i;
    }
    
    public final String getItem(int paramInt)
    {
      AppMethodBeat.i(65645);
      String str = (String)this.zeP.get(paramInt);
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
      paramView = (CheckedTextView)LayoutInflater.from(LuckyMoneyMyRecordUI.this.getContext()).inflate(2131496951, paramViewGroup, false);
      paramView.setText(getItem(paramInt));
      if (paramInt == this.bxP) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI
 * JD-Core Version:    0.7.0.1
 */