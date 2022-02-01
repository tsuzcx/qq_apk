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
import com.tencent.mm.al.n;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.luckymoney.model.ak;
import com.tencent.mm.plugin.luckymoney.model.al;
import com.tencent.mm.plugin.luckymoney.model.s;
import com.tencent.mm.plugin.luckymoney.model.t;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  private View jfs;
  private boolean llo;
  private int mType;
  private ImageView pcD;
  private TextView pdI;
  private List<t> vjL;
  private TextView vjR;
  public String vqu;
  private MMLoadMoreListView vvL;
  private e vvM;
  private boolean vvf;
  private Map<String, Integer> vvl;
  public String vvn;
  private TextView vxA;
  private TextView vxB;
  private TextView vxC;
  private String vxD;
  private int vxE;
  public List<String> vxF;
  private TextView vxw;
  private TextView vxx;
  private TextView vxy;
  private TextView vxz;
  
  public LuckyMoneyMyRecordUI()
  {
    AppMethodBeat.i(65648);
    this.fq = 0;
    this.vjL = new LinkedList();
    this.vvl = new HashMap();
    this.vvf = true;
    this.llo = false;
    this.vxE = -1;
    this.vxF = new ArrayList();
    this.vvn = "";
    this.vqu = "";
    AppMethodBeat.o(65648);
  }
  
  private void dji()
  {
    AppMethodBeat.i(65653);
    this.llo = true;
    if (this.fq == 0) {
      this.vvn = "";
    }
    doSceneProgress(new ak(11, this.fq, this.mType, this.vxD, "v1.0", this.vvn));
    AppMethodBeat.o(65653);
  }
  
  private void djs()
  {
    AppMethodBeat.i(65651);
    this.vxC.setVisibility(8);
    this.jfs.findViewById(2131301845).setVisibility(8);
    String str;
    if (this.mType == 1)
    {
      setMMTitle(getString(2131760898));
      str = getString(2131760954, new Object[] { com.tencent.mm.model.u.aAo() });
      z.a(getContext(), this.vxw, str);
      this.vxy.setText(2131760960);
      this.vvM = new f(getContext());
      this.vxC.setVisibility(0);
    }
    for (;;)
    {
      this.vvL.setAdapter(this.vvM);
      a.b.a(this.pcD, com.tencent.mm.model.u.aAm(), 0.0F, false);
      this.vxB.setText(getString(2131760943, new Object[] { bt.nullAsNil(this.vxD) }));
      AppMethodBeat.o(65651);
      return;
      setMMTitle(getString(2131760896));
      str = getString(2131760941, new Object[] { com.tencent.mm.model.u.aAo() });
      z.a(getContext(), this.vxw, str);
      this.vxy.setText(2131760942);
      this.vvM = new d(getContext());
      this.jfs.findViewById(2131301845).setVisibility(0);
    }
  }
  
  private int djt()
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
    setBackBtn(new LuckyMoneyMyRecordUI.1(this));
    addIconOptionMenu(0, 2131689493, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(65636);
        paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(LuckyMoneyMyRecordUI.this.getContext(), 1, false);
        paramAnonymousMenuItem.KJy = new n.d()
        {
          public final void onCreateMMMenu(l paramAnonymous2l)
          {
            AppMethodBeat.i(65634);
            paramAnonymous2l.jI(1, 2131760896);
            paramAnonymous2l.jI(2, 2131760898);
            AppMethodBeat.o(65634);
          }
        };
        paramAnonymousMenuItem.KJz = new n.e()
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
        paramAnonymousMenuItem.cMW();
        AppMethodBeat.o(65636);
        return false;
      }
    });
    this.pdI = ((TextView)findViewById(2131301851));
    this.vvL = ((MMLoadMoreListView)findViewById(2131301853));
    this.jfs = LayoutInflater.from(this).inflate(2131494647, null);
    this.vvL.addHeaderView(this.jfs);
    this.pcD = ((ImageView)this.jfs.findViewById(2131301839));
    this.vxw = ((TextView)this.jfs.findViewById(2131301842));
    this.vjR = ((TextView)this.jfs.findViewById(2131301838));
    this.vxx = ((TextView)this.jfs.findViewById(2131301843));
    this.vxy = ((TextView)this.jfs.findViewById(2131301844));
    this.vxz = ((TextView)this.jfs.findViewById(2131301840));
    this.vxA = ((TextView)this.jfs.findViewById(2131301841));
    this.vxB = ((TextView)this.jfs.findViewById(2131301847));
    this.vxC = ((TextView)this.jfs.findViewById(2131301846));
    this.vvL.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(65637);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyMyRecordUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        paramAnonymousInt = (int)paramAnonymousLong;
        g.yhR.f(11701, new Object[] { Integer.valueOf(LuckyMoneyMyRecordUI.e(LuckyMoneyMyRecordUI.this)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
        if ((paramAnonymousInt >= 0) && (paramAnonymousInt < LuckyMoneyMyRecordUI.f(LuckyMoneyMyRecordUI.this).getCount()))
        {
          paramAnonymousView = LuckyMoneyMyRecordUI.f(LuckyMoneyMyRecordUI.this).Js(paramAnonymousInt);
          if ((paramAnonymousView != null) && (!bt.isNullOrNil(paramAnonymousView.vkl)))
          {
            paramAnonymousAdapterView = new Intent();
            if (paramAnonymousView.vow != 2) {
              break label310;
            }
            ad.d("MicroMsg.LuckyMoneyMyRecordUI", "onItemClick: go busi detail");
            paramAnonymousAdapterView.setClass(LuckyMoneyMyRecordUI.this.getContext(), LuckyMoneyBusiDetailUI.class);
            paramAnonymousAdapterView.putExtra("key_sendid", paramAnonymousView.vkl);
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
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousAdapterView.ahp(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyMyRecordUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyMyRecordUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyMyRecordUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(65637);
          return;
          ad.d("MicroMsg.LuckyMoneyMyRecordUI", "onItemClick: go normal detail");
          paramAnonymousAdapterView.setClass(LuckyMoneyMyRecordUI.this.getContext(), LuckyMoneyBeforeDetailUI.class);
          break;
        }
      }
    });
    this.vvL.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
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
          public final void lf(int paramAnonymous2Int)
          {
            AppMethodBeat.i(65638);
            switch (paramAnonymous2Int)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(65638);
              return;
              t localt = LuckyMoneyMyRecordUI.f(LuckyMoneyMyRecordUI.this).Js(this.vxI);
              if (localt != null)
              {
                LuckyMoneyMyRecordUI.b(LuckyMoneyMyRecordUI.this, this.vxI);
                LuckyMoneyMyRecordUI.a(LuckyMoneyMyRecordUI.this, localt, this.vxI);
              }
            }
          }
        });
        AppMethodBeat.o(65639);
        return true;
      }
    });
    this.vvL.setOnLoadMoreListener(new MMLoadMoreListView.a()
    {
      public final void Zt()
      {
        AppMethodBeat.i(65640);
        if (!LuckyMoneyMyRecordUI.this.vuU.isProcessing()) {
          LuckyMoneyMyRecordUI.g(LuckyMoneyMyRecordUI.this);
        }
        if ((LuckyMoneyMyRecordUI.h(LuckyMoneyMyRecordUI.this)) && (!LuckyMoneyMyRecordUI.i(LuckyMoneyMyRecordUI.this))) {
          LuckyMoneyMyRecordUI.d(LuckyMoneyMyRecordUI.this);
        }
        AppMethodBeat.o(65640);
      }
    });
    this.pcD.setOnClickListener(new LuckyMoneyMyRecordUI.6(this));
    djs();
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
    dji();
    g.yhR.f(11701, new Object[] { Integer.valueOf(djt()), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
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
        paramn = paramString.vqr.vox;
        this.vvn = paramString.vqa;
        this.vqu = paramString.vqu;
        Object localObject2;
        if (this.fq == 0)
        {
          this.vxF = paramString.vqs;
          this.vxD = paramString.vqt;
          localObject1 = findViewById(2131301849);
          localObject2 = (ImageView)findViewById(2131301848);
          if (this.vxF.size() > 1)
          {
            ((ImageView)localObject2).setVisibility(0);
            ((View)localObject1).setOnClickListener(new LuckyMoneyMyRecordUI.7(this));
          }
          this.vxB.setText(getString(2131760943, new Object[] { this.vxD }));
        }
        Object localObject1 = paramString.vqr;
        if (localObject1 != null)
        {
          if (this.mType != 1) {
            break label387;
          }
          this.vjR.setText(com.tencent.mm.wallet_core.ui.e.C(((s)localObject1).vpk / 100.0D));
          localObject1 = ((s)localObject1).vpj;
          Object localObject3 = getString(2131760959, new Object[] { localObject1 });
          localObject2 = new ForegroundColorSpan(getResources().getColor(2131100574));
          paramInt1 = ((String)localObject3).indexOf((String)localObject1);
          localObject3 = new SpannableString((CharSequence)localObject3);
          ((SpannableString)localObject3).setSpan(localObject2, paramInt1, ((String)localObject1).length() + paramInt1, 33);
          this.vxC.setText((CharSequence)localObject3);
        }
        while (paramn != null)
        {
          paramInt1 = 0;
          for (;;)
          {
            if (paramInt1 < paramn.size())
            {
              localObject1 = (t)paramn.get(paramInt1);
              if (!this.vvl.containsKey(((t)localObject1).vkl))
              {
                this.vjL.add(paramn.get(paramInt1));
                this.vvl.put(((t)localObject1).vkl, Integer.valueOf(1));
              }
              paramInt1 += 1;
              continue;
              label387:
              this.vjR.setText(com.tencent.mm.wallet_core.ui.e.C(((s)localObject1).vpi / 100.0D));
              this.vxx.setText(((s)localObject1).vph);
              this.vxz.setText(((s)localObject1).vpl);
              break;
            }
          }
          this.fq += paramn.size();
          this.vvf = paramString.dir();
          this.llo = false;
          this.vvM.es(this.vjL);
        }
        if ((this.vjL == null) || (this.vjL.size() == 0))
        {
          this.pdI.setVisibility(0);
          if (!this.vvf) {
            break label561;
          }
          this.vvL.fyL();
        }
        for (;;)
        {
          AppMethodBeat.o(65652);
          return true;
          this.pdI.setVisibility(8);
          break;
          label561:
          this.vvL.fyM();
        }
      }
      this.vqu = null;
    }
    int i;
    do
    {
      do
      {
        AppMethodBeat.o(65652);
        return false;
      } while (!(paramn instanceof al));
      i = this.vxE;
      this.vxE = -1;
    } while ((paramInt1 != 0) || (paramInt2 != 0));
    paramString = this.vvM.Js(i);
    if (paramString != null)
    {
      Toast.makeText(this, 2131760890, 0).show();
      this.vvM.a(paramString);
      this.vvM.notifyDataSetChanged();
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
    int bxN;
    List<String> vxF;
    
    a() {}
    
    public final int getCount()
    {
      AppMethodBeat.i(65644);
      int i = this.vxF.size();
      AppMethodBeat.o(65644);
      return i;
    }
    
    public final String getItem(int paramInt)
    {
      AppMethodBeat.i(65645);
      String str = (String)this.vxF.get(paramInt);
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