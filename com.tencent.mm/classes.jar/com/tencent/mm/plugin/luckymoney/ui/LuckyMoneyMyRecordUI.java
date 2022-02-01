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
import android.view.View.OnClickListener;
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
import com.tencent.mm.ak.n;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.luckymoney.model.ak;
import com.tencent.mm.plugin.luckymoney.model.al;
import com.tencent.mm.plugin.luckymoney.model.s;
import com.tencent.mm.plugin.luckymoney.model.t;
import com.tencent.mm.plugin.luckymoney.model.u;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.MMLoadMoreListView.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LuckyMoneyMyRecordUI
  extends LuckyMoneyBaseUI
{
  private int fq;
  private View jil;
  private boolean lpM;
  private int mType;
  private ImageView pjj;
  private TextView pko;
  public String vCz;
  private MMLoadMoreListView vHP;
  private e vHQ;
  private boolean vHj;
  private Map<String, Integer> vHp;
  public String vHr;
  private TextView vJA;
  private TextView vJB;
  private TextView vJC;
  private TextView vJD;
  private TextView vJE;
  private TextView vJF;
  private TextView vJG;
  private String vJH;
  private int vJI;
  public List<String> vJJ;
  private List<t> vvQ;
  private TextView vvW;
  
  public LuckyMoneyMyRecordUI()
  {
    AppMethodBeat.i(65648);
    this.fq = 0;
    this.vvQ = new LinkedList();
    this.vHp = new HashMap();
    this.vHj = true;
    this.lpM = false;
    this.vJI = -1;
    this.vJJ = new ArrayList();
    this.vHr = "";
    this.vCz = "";
    AppMethodBeat.o(65648);
  }
  
  private void dmh()
  {
    AppMethodBeat.i(65653);
    this.lpM = true;
    if (this.fq == 0) {
      this.vHr = "";
    }
    doSceneProgress(new ak(11, this.fq, this.mType, this.vJH, "v1.0", this.vHr));
    AppMethodBeat.o(65653);
  }
  
  private void dmr()
  {
    AppMethodBeat.i(65651);
    this.vJG.setVisibility(8);
    this.jil.findViewById(2131301845).setVisibility(8);
    String str;
    if (this.mType == 1)
    {
      setMMTitle(getString(2131760898));
      str = getString(2131760954, new Object[] { v.aAE() });
      z.a(getContext(), this.vJA, str);
      this.vJC.setText(2131760960);
      this.vHQ = new f(getContext());
      this.vJG.setVisibility(0);
    }
    for (;;)
    {
      this.vHP.setAdapter(this.vHQ);
      a.b.a(this.pjj, v.aAC(), 0.0F, false);
      this.vJF.setText(getString(2131760943, new Object[] { bu.nullAsNil(this.vJH) }));
      AppMethodBeat.o(65651);
      return;
      setMMTitle(getString(2131760896));
      str = getString(2131760941, new Object[] { v.aAE() });
      z.a(getContext(), this.vJA, str);
      this.vJC.setText(2131760942);
      this.vHQ = new d(getContext());
      this.jil.findViewById(2131301845).setVisibility(0);
    }
  }
  
  private int dms()
  {
    if (this.mType == 1) {
      return 8;
    }
    return 9;
  }
  
  public int getLayoutId()
  {
    return 2131494649;
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
    addIconOptionMenu(0, 2131689493, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(65636);
        paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(LuckyMoneyMyRecordUI.this.getContext(), 1, false);
        paramAnonymousMenuItem.LfS = new n.d()
        {
          public final void onCreateMMMenu(l paramAnonymous2l)
          {
            AppMethodBeat.i(65634);
            paramAnonymous2l.jM(1, 2131760896);
            paramAnonymous2l.jM(2, 2131760898);
            AppMethodBeat.o(65634);
          }
        };
        paramAnonymousMenuItem.LfT = new n.e()
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
        paramAnonymousMenuItem.cPF();
        AppMethodBeat.o(65636);
        return false;
      }
    });
    this.pko = ((TextView)findViewById(2131301851));
    this.vHP = ((MMLoadMoreListView)findViewById(2131301853));
    this.jil = LayoutInflater.from(this).inflate(2131494647, null);
    this.vHP.addHeaderView(this.jil);
    this.pjj = ((ImageView)this.jil.findViewById(2131301839));
    this.vJA = ((TextView)this.jil.findViewById(2131301842));
    this.vvW = ((TextView)this.jil.findViewById(2131301838));
    this.vJB = ((TextView)this.jil.findViewById(2131301843));
    this.vJC = ((TextView)this.jil.findViewById(2131301844));
    this.vJD = ((TextView)this.jil.findViewById(2131301840));
    this.vJE = ((TextView)this.jil.findViewById(2131301841));
    this.vJF = ((TextView)this.jil.findViewById(2131301847));
    this.vJG = ((TextView)this.jil.findViewById(2131301846));
    this.vHP.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(65637);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyMyRecordUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
        paramAnonymousInt = (int)paramAnonymousLong;
        g.yxI.f(11701, new Object[] { Integer.valueOf(LuckyMoneyMyRecordUI.e(LuckyMoneyMyRecordUI.this)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
        if ((paramAnonymousInt >= 0) && (paramAnonymousInt < LuckyMoneyMyRecordUI.f(LuckyMoneyMyRecordUI.this).getCount()))
        {
          paramAnonymousView = LuckyMoneyMyRecordUI.f(LuckyMoneyMyRecordUI.this).JR(paramAnonymousInt);
          if ((paramAnonymousView != null) && (!bu.isNullOrNil(paramAnonymousView.vwq)))
          {
            paramAnonymousAdapterView = new Intent();
            if (paramAnonymousView.vAB != 2) {
              break label310;
            }
            ae.d("MicroMsg.LuckyMoneyMyRecordUI", "onItemClick: go busi detail");
            paramAnonymousAdapterView.setClass(LuckyMoneyMyRecordUI.this.getContext(), LuckyMoneyBusiDetailUI.class);
            paramAnonymousAdapterView.putExtra("key_sendid", paramAnonymousView.vwq);
            if (LuckyMoneyMyRecordUI.a(LuckyMoneyMyRecordUI.this) != 1) {
              break label334;
            }
          }
        }
        label310:
        label334:
        for (paramAnonymousInt = 3;; paramAnonymousInt = 1)
        {
          paramAnonymousAdapterView.putExtra("key_jump_from", paramAnonymousInt);
          paramAnonymousView = LuckyMoneyMyRecordUI.this;
          paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousAdapterView);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousAdapterView.ahE(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyMyRecordUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyMyRecordUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyMyRecordUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(65637);
          return;
          ae.d("MicroMsg.LuckyMoneyMyRecordUI", "onItemClick: go normal detail");
          paramAnonymousAdapterView.setClass(LuckyMoneyMyRecordUI.this.getContext(), LuckyMoneyBeforeDetailUI.class);
          break;
        }
      }
    });
    this.vHP.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(65639);
        if ((paramAnonymousInt <= 0) || (paramAnonymousInt > LuckyMoneyMyRecordUI.f(LuckyMoneyMyRecordUI.this).getCount()))
        {
          AppMethodBeat.o(65639);
          return true;
        }
        h.a(LuckyMoneyMyRecordUI.this, LuckyMoneyMyRecordUI.this.getResources().getString(2131760889), null, LuckyMoneyMyRecordUI.this.getResources().getString(2131755707), new h.c()
        {
          public final void lh(int paramAnonymous2Int)
          {
            AppMethodBeat.i(65638);
            switch (paramAnonymous2Int)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(65638);
              return;
              t localt = LuckyMoneyMyRecordUI.f(LuckyMoneyMyRecordUI.this).JR(this.vJM);
              if (localt != null)
              {
                LuckyMoneyMyRecordUI.b(LuckyMoneyMyRecordUI.this, this.vJM);
                LuckyMoneyMyRecordUI.a(LuckyMoneyMyRecordUI.this, localt, this.vJM);
              }
            }
          }
        });
        AppMethodBeat.o(65639);
        return true;
      }
    });
    this.vHP.setOnLoadMoreListener(new MMLoadMoreListView.a()
    {
      public final void ZC()
      {
        AppMethodBeat.i(65640);
        if (!LuckyMoneyMyRecordUI.this.vGY.isProcessing()) {
          LuckyMoneyMyRecordUI.g(LuckyMoneyMyRecordUI.this);
        }
        if ((LuckyMoneyMyRecordUI.h(LuckyMoneyMyRecordUI.this)) && (!LuckyMoneyMyRecordUI.i(LuckyMoneyMyRecordUI.this))) {
          LuckyMoneyMyRecordUI.d(LuckyMoneyMyRecordUI.this);
        }
        AppMethodBeat.o(65640);
      }
    });
    this.pjj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65641);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyMyRecordUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (!bu.isNullOrNil(LuckyMoneyMyRecordUI.this.vCz)) {
          com.tencent.mm.wallet_core.ui.f.p(LuckyMoneyMyRecordUI.this, LuckyMoneyMyRecordUI.this.vCz, true);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyMyRecordUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(65641);
          return;
          ae.w("MicroMsg.LuckyMoneyMyRecordUI", "hy: no avatar jump h5");
        }
      }
    });
    dmr();
    AppMethodBeat.o(65650);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65649);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131100592));
    setActionbarElementColor(getResources().getColor(2131100576));
    this.mType = getIntent().getIntExtra("key_type", 2);
    initView();
    dmh();
    g.yxI.f(11701, new Object[] { Integer.valueOf(dms()), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    AppMethodBeat.o(65649);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(65652);
    if ((paramn instanceof ak))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ak)paramn;
        paramn = paramString.vCw.vAC;
        this.vHr = paramString.vCf;
        this.vCz = paramString.vCz;
        Object localObject2;
        if (this.fq == 0)
        {
          this.vJJ = paramString.vCx;
          this.vJH = paramString.vCy;
          localObject1 = findViewById(2131301849);
          localObject2 = (ImageView)findViewById(2131301848);
          if (this.vJJ.size() > 1)
          {
            ((ImageView)localObject2).setVisibility(0);
            ((View)localObject1).setOnClickListener(new LuckyMoneyMyRecordUI.7(this));
          }
          this.vJF.setText(getString(2131760943, new Object[] { this.vJH }));
        }
        Object localObject1 = paramString.vCw;
        if (localObject1 != null)
        {
          if (this.mType != 1) {
            break label387;
          }
          this.vvW.setText(com.tencent.mm.wallet_core.ui.f.C(((s)localObject1).vBp / 100.0D));
          localObject1 = ((s)localObject1).vBo;
          Object localObject3 = getString(2131760959, new Object[] { localObject1 });
          localObject2 = new ForegroundColorSpan(getResources().getColor(2131100574));
          paramInt1 = ((String)localObject3).indexOf((String)localObject1);
          localObject3 = new SpannableString((CharSequence)localObject3);
          ((SpannableString)localObject3).setSpan(localObject2, paramInt1, ((String)localObject1).length() + paramInt1, 33);
          this.vJG.setText((CharSequence)localObject3);
        }
        while (paramn != null)
        {
          paramInt1 = 0;
          for (;;)
          {
            if (paramInt1 < paramn.size())
            {
              localObject1 = (t)paramn.get(paramInt1);
              if (!this.vHp.containsKey(((t)localObject1).vwq))
              {
                this.vvQ.add(paramn.get(paramInt1));
                this.vHp.put(((t)localObject1).vwq, Integer.valueOf(1));
              }
              paramInt1 += 1;
              continue;
              label387:
              this.vvW.setText(com.tencent.mm.wallet_core.ui.f.C(((s)localObject1).vBn / 100.0D));
              this.vJB.setText(((s)localObject1).vBm);
              this.vJD.setText(((s)localObject1).vBq);
              break;
            }
          }
          this.fq += paramn.size();
          this.vHj = paramString.dlq();
          this.lpM = false;
          this.vHQ.ew(this.vvQ);
        }
        if ((this.vvQ == null) || (this.vvQ.size() == 0))
        {
          this.pko.setVisibility(0);
          if (!this.vHj) {
            break label561;
          }
          this.vHP.fCN();
        }
        for (;;)
        {
          AppMethodBeat.o(65652);
          return true;
          this.pko.setVisibility(8);
          break;
          label561:
          this.vHP.fCO();
        }
      }
      this.vCz = null;
    }
    int i;
    do
    {
      do
      {
        AppMethodBeat.o(65652);
        return false;
      } while (!(paramn instanceof al));
      i = this.vJI;
      this.vJI = -1;
    } while ((paramInt1 != 0) || (paramInt2 != 0));
    paramString = this.vHQ.JR(i);
    if (paramString != null)
    {
      Toast.makeText(this, 2131760890, 0).show();
      this.vHQ.a(paramString);
      this.vHQ.notifyDataSetChanged();
    }
    for (;;)
    {
      AppMethodBeat.o(65652);
      return true;
      ae.e("MicroMsg.LuckyMoneyMyRecordUI", "can't found local record");
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
    int bxN;
    List<String> vJJ;
    
    a() {}
    
    public final int getCount()
    {
      AppMethodBeat.i(65644);
      int i = this.vJJ.size();
      AppMethodBeat.o(65644);
      return i;
    }
    
    public final String getItem(int paramInt)
    {
      AppMethodBeat.i(65645);
      String str = (String)this.vJJ.get(paramInt);
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
      paramView = (CheckedTextView)LayoutInflater.from(LuckyMoneyMyRecordUI.this.getContext()).inflate(2131495971, paramViewGroup, false);
      paramView.setText(getItem(paramInt));
      if (paramInt == this.bxN) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI
 * JD-Core Version:    0.7.0.1
 */