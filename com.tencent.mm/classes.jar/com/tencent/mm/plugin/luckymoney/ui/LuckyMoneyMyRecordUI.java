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
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.luckymoney.model.ak;
import com.tencent.mm.plugin.luckymoney.model.al;
import com.tencent.mm.plugin.luckymoney.model.s;
import com.tencent.mm.plugin.luckymoney.model.t;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.MMLoadMoreListView.a;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LuckyMoneyMyRecordUI
  extends LuckyMoneyBaseUI
{
  private int LZ;
  private View imc;
  private boolean knt;
  private int mType;
  private ImageView nVN;
  private TextView nWS;
  private List<t> sYN;
  private TextView sYT;
  public String tfz;
  private MMLoadMoreListView tkP;
  private e tkQ;
  private boolean tkj;
  private Map<String, Integer> tkp;
  public String tkr;
  private TextView tmA;
  private TextView tmB;
  private TextView tmC;
  private TextView tmD;
  private TextView tmE;
  private TextView tmF;
  private TextView tmG;
  private String tmH;
  private int tmI;
  public List<String> tmJ;
  
  public LuckyMoneyMyRecordUI()
  {
    AppMethodBeat.i(65648);
    this.LZ = 0;
    this.sYN = new LinkedList();
    this.tkp = new HashMap();
    this.tkj = true;
    this.knt = false;
    this.tmI = -1;
    this.tmJ = new ArrayList();
    this.tkr = "";
    this.tfz = "";
    AppMethodBeat.o(65648);
  }
  
  private int cMA()
  {
    if (this.mType == 1) {
      return 8;
    }
    return 9;
  }
  
  private void cMp()
  {
    AppMethodBeat.i(65653);
    this.knt = true;
    if (this.LZ == 0) {
      this.tkr = "";
    }
    doSceneProgress(new ak(11, this.LZ, this.mType, this.tmH, "v1.0", this.tkr));
    AppMethodBeat.o(65653);
  }
  
  private void cMz()
  {
    AppMethodBeat.i(65651);
    this.tmG.setVisibility(8);
    this.imc.findViewById(2131301845).setVisibility(8);
    String str;
    if (this.mType == 1)
    {
      setMMTitle(getString(2131760898));
      str = getString(2131760954, new Object[] { com.tencent.mm.model.u.aqI() });
      z.a(getContext(), this.tmA, str);
      this.tmC.setText(2131760960);
      this.tkQ = new f(getContext());
      this.tmG.setVisibility(0);
    }
    for (;;)
    {
      this.tkP.setAdapter(this.tkQ);
      a.b.a(this.nVN, com.tencent.mm.model.u.aqG(), 0.0F, false);
      this.tmF.setText(getString(2131760943, new Object[] { bt.nullAsNil(this.tmH) }));
      AppMethodBeat.o(65651);
      return;
      setMMTitle(getString(2131760896));
      str = getString(2131760941, new Object[] { com.tencent.mm.model.u.aqI() });
      z.a(getContext(), this.tmA, str);
      this.tmC.setText(2131760942);
      this.tkQ = new d(getContext());
      this.imc.findViewById(2131301845).setVisibility(0);
    }
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
        paramAnonymousMenuItem.HrX = new n.c()
        {
          public final void onCreateMMMenu(l paramAnonymous2l)
          {
            AppMethodBeat.i(65634);
            paramAnonymous2l.jj(1, 2131760896);
            paramAnonymous2l.jj(2, 2131760898);
            AppMethodBeat.o(65634);
          }
        };
        paramAnonymousMenuItem.HrY = new n.d()
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
        paramAnonymousMenuItem.csG();
        AppMethodBeat.o(65636);
        return false;
      }
    });
    this.nWS = ((TextView)findViewById(2131301851));
    this.tkP = ((MMLoadMoreListView)findViewById(2131301853));
    this.imc = LayoutInflater.from(this).inflate(2131494647, null);
    this.tkP.addHeaderView(this.imc);
    this.nVN = ((ImageView)this.imc.findViewById(2131301839));
    this.tmA = ((TextView)this.imc.findViewById(2131301842));
    this.sYT = ((TextView)this.imc.findViewById(2131301838));
    this.tmB = ((TextView)this.imc.findViewById(2131301843));
    this.tmC = ((TextView)this.imc.findViewById(2131301844));
    this.tmD = ((TextView)this.imc.findViewById(2131301840));
    this.tmE = ((TextView)this.imc.findViewById(2131301841));
    this.tmF = ((TextView)this.imc.findViewById(2131301847));
    this.tmG = ((TextView)this.imc.findViewById(2131301846));
    this.tkP.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(65637);
        paramAnonymousInt = (int)paramAnonymousLong;
        com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(LuckyMoneyMyRecordUI.e(LuckyMoneyMyRecordUI.this)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
        if ((paramAnonymousInt >= 0) && (paramAnonymousInt < LuckyMoneyMyRecordUI.f(LuckyMoneyMyRecordUI.this).getCount()))
        {
          paramAnonymousView = LuckyMoneyMyRecordUI.f(LuckyMoneyMyRecordUI.this).Gb(paramAnonymousInt);
          if ((paramAnonymousView != null) && (!bt.isNullOrNil(paramAnonymousView.sZn)))
          {
            paramAnonymousAdapterView = new Intent();
            if (paramAnonymousView.tdB != 2) {
              break label247;
            }
            ad.d("MicroMsg.LuckyMoneyMyRecordUI", "onItemClick: go busi detail");
            paramAnonymousAdapterView.setClass(LuckyMoneyMyRecordUI.this.getContext(), LuckyMoneyBusiDetailUI.class);
            paramAnonymousAdapterView.putExtra("key_sendid", paramAnonymousView.sZn);
            if (LuckyMoneyMyRecordUI.a(LuckyMoneyMyRecordUI.this) != 1) {
              break label271;
            }
          }
        }
        label271:
        for (paramAnonymousInt = 3;; paramAnonymousInt = 1)
        {
          paramAnonymousAdapterView.putExtra("key_jump_from", paramAnonymousInt);
          paramAnonymousView = LuckyMoneyMyRecordUI.this;
          paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousAdapterView);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousAdapterView.adn(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyMyRecordUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyMyRecordUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(65637);
          return;
          label247:
          ad.d("MicroMsg.LuckyMoneyMyRecordUI", "onItemClick: go normal detail");
          paramAnonymousAdapterView.setClass(LuckyMoneyMyRecordUI.this.getContext(), LuckyMoneyBeforeDetailUI.class);
          break;
        }
      }
    });
    this.tkP.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(65639);
        if ((paramAnonymousInt <= 0) || (paramAnonymousInt > LuckyMoneyMyRecordUI.f(LuckyMoneyMyRecordUI.this).getCount()))
        {
          AppMethodBeat.o(65639);
          return true;
        }
        com.tencent.mm.ui.base.h.a(LuckyMoneyMyRecordUI.this, LuckyMoneyMyRecordUI.this.getResources().getString(2131760889), null, LuckyMoneyMyRecordUI.this.getResources().getString(2131755707), new h.c()
        {
          public final void kM(int paramAnonymous2Int)
          {
            AppMethodBeat.i(65638);
            switch (paramAnonymous2Int)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(65638);
              return;
              t localt = LuckyMoneyMyRecordUI.f(LuckyMoneyMyRecordUI.this).Gb(this.tmM);
              if (localt != null)
              {
                LuckyMoneyMyRecordUI.b(LuckyMoneyMyRecordUI.this, this.tmM);
                LuckyMoneyMyRecordUI.a(LuckyMoneyMyRecordUI.this, localt, this.tmM);
              }
            }
          }
        });
        AppMethodBeat.o(65639);
        return true;
      }
    });
    this.tkP.setOnLoadMoreListener(new MMLoadMoreListView.a()
    {
      public final void Wc()
      {
        AppMethodBeat.i(65640);
        if (!LuckyMoneyMyRecordUI.this.tjY.isProcessing()) {
          LuckyMoneyMyRecordUI.g(LuckyMoneyMyRecordUI.this);
        }
        if ((LuckyMoneyMyRecordUI.h(LuckyMoneyMyRecordUI.this)) && (!LuckyMoneyMyRecordUI.i(LuckyMoneyMyRecordUI.this))) {
          LuckyMoneyMyRecordUI.d(LuckyMoneyMyRecordUI.this);
        }
        AppMethodBeat.o(65640);
      }
    });
    this.nVN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65641);
        if (!bt.isNullOrNil(LuckyMoneyMyRecordUI.this.tfz))
        {
          com.tencent.mm.wallet_core.ui.e.p(LuckyMoneyMyRecordUI.this, LuckyMoneyMyRecordUI.this.tfz, true);
          AppMethodBeat.o(65641);
          return;
        }
        ad.w("MicroMsg.LuckyMoneyMyRecordUI", "hy: no avatar jump h5");
        AppMethodBeat.o(65641);
      }
    });
    cMz();
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
    cMp();
    com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(cMA()), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
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
        paramn = paramString.tfw.tdC;
        this.tkr = paramString.tff;
        this.tfz = paramString.tfz;
        Object localObject2;
        if (this.LZ == 0)
        {
          this.tmJ = paramString.tfx;
          this.tmH = paramString.tfy;
          localObject1 = findViewById(2131301849);
          localObject2 = (ImageView)findViewById(2131301848);
          if (this.tmJ.size() > 1)
          {
            ((ImageView)localObject2).setVisibility(0);
            ((View)localObject1).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(65642);
                LuckyMoneyMyRecordUI.this.showDialog(1);
                AppMethodBeat.o(65642);
              }
            });
          }
          this.tmF.setText(getString(2131760943, new Object[] { this.tmH }));
        }
        Object localObject1 = paramString.tfw;
        if (localObject1 != null)
        {
          if (this.mType != 1) {
            break label387;
          }
          this.sYT.setText(com.tencent.mm.wallet_core.ui.e.D(((s)localObject1).tep / 100.0D));
          localObject1 = ((s)localObject1).teo;
          Object localObject3 = getString(2131760959, new Object[] { localObject1 });
          localObject2 = new ForegroundColorSpan(getResources().getColor(2131100574));
          paramInt1 = ((String)localObject3).indexOf((String)localObject1);
          localObject3 = new SpannableString((CharSequence)localObject3);
          ((SpannableString)localObject3).setSpan(localObject2, paramInt1, ((String)localObject1).length() + paramInt1, 33);
          this.tmG.setText((CharSequence)localObject3);
        }
        while (paramn != null)
        {
          paramInt1 = 0;
          for (;;)
          {
            if (paramInt1 < paramn.size())
            {
              localObject1 = (t)paramn.get(paramInt1);
              if (!this.tkp.containsKey(((t)localObject1).sZn))
              {
                this.sYN.add(paramn.get(paramInt1));
                this.tkp.put(((t)localObject1).sZn, Integer.valueOf(1));
              }
              paramInt1 += 1;
              continue;
              label387:
              this.sYT.setText(com.tencent.mm.wallet_core.ui.e.D(((s)localObject1).ten / 100.0D));
              this.tmB.setText(((s)localObject1).tem);
              this.tmD.setText(((s)localObject1).teq);
              break;
            }
          }
          this.LZ += paramn.size();
          this.tkj = paramString.cLz();
          this.knt = false;
          this.tkQ.eb(this.sYN);
        }
        if ((this.sYN == null) || (this.sYN.size() == 0))
        {
          this.nWS.setVisibility(0);
          if (!this.tkj) {
            break label561;
          }
          this.tkP.eSM();
        }
        for (;;)
        {
          AppMethodBeat.o(65652);
          return true;
          this.nWS.setVisibility(8);
          break;
          label561:
          this.tkP.eSN();
        }
      }
      this.tfz = null;
    }
    int i;
    do
    {
      do
      {
        AppMethodBeat.o(65652);
        return false;
      } while (!(paramn instanceof al));
      i = this.tmI;
      this.tmI = -1;
    } while ((paramInt1 != 0) || (paramInt2 != 0));
    paramString = this.tkQ.Gb(i);
    if (paramString != null)
    {
      Toast.makeText(this, 2131760890, 0).show();
      this.tkQ.a(paramString);
      this.tkQ.notifyDataSetChanged();
    }
    for (;;)
    {
      AppMethodBeat.o(65652);
      return true;
      ad.e("MicroMsg.LuckyMoneyMyRecordUI", "can't found local record");
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
    int boX;
    List<String> tmJ;
    
    a() {}
    
    public final int getCount()
    {
      AppMethodBeat.i(65644);
      int i = this.tmJ.size();
      AppMethodBeat.o(65644);
      return i;
    }
    
    public final String getItem(int paramInt)
    {
      AppMethodBeat.i(65645);
      String str = (String)this.tmJ.get(paramInt);
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
      if (paramInt == this.boX) {
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