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
import com.tencent.mm.plugin.luckymoney.model.ak;
import com.tencent.mm.plugin.luckymoney.model.al;
import com.tencent.mm.plugin.luckymoney.model.s;
import com.tencent.mm.plugin.luckymoney.model.t;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  private int MW;
  private View iMi;
  private boolean kOL;
  private int mType;
  private TextView oAn;
  private ImageView ozi;
  private List<t> uhb;
  private TextView uhh;
  public String unO;
  private boolean usC;
  private Map<String, Integer> usI;
  public String usK;
  private MMLoadMoreListView uti;
  private e utj;
  private TextView uuT;
  private TextView uuU;
  private TextView uuV;
  private TextView uuW;
  private TextView uuX;
  private TextView uuY;
  private TextView uuZ;
  private String uva;
  private int uvb;
  public List<String> uvc;
  
  public LuckyMoneyMyRecordUI()
  {
    AppMethodBeat.i(65648);
    this.MW = 0;
    this.uhb = new LinkedList();
    this.usI = new HashMap();
    this.usC = true;
    this.kOL = false;
    this.uvb = -1;
    this.uvc = new ArrayList();
    this.usK = "";
    this.unO = "";
    AppMethodBeat.o(65648);
  }
  
  private void cZV()
  {
    AppMethodBeat.i(65653);
    this.kOL = true;
    if (this.MW == 0) {
      this.usK = "";
    }
    doSceneProgress(new ak(11, this.MW, this.mType, this.uva, "v1.0", this.usK));
    AppMethodBeat.o(65653);
  }
  
  private void daf()
  {
    AppMethodBeat.i(65651);
    this.uuZ.setVisibility(8);
    this.iMi.findViewById(2131301845).setVisibility(8);
    String str;
    if (this.mType == 1)
    {
      setMMTitle(getString(2131760898));
      str = getString(2131760954, new Object[] { com.tencent.mm.model.u.axy() });
      z.a(getContext(), this.uuT, str);
      this.uuV.setText(2131760960);
      this.utj = new f(getContext());
      this.uuZ.setVisibility(0);
    }
    for (;;)
    {
      this.uti.setAdapter(this.utj);
      a.b.a(this.ozi, com.tencent.mm.model.u.axw(), 0.0F, false);
      this.uuY.setText(getString(2131760943, new Object[] { bs.nullAsNil(this.uva) }));
      AppMethodBeat.o(65651);
      return;
      setMMTitle(getString(2131760896));
      str = getString(2131760941, new Object[] { com.tencent.mm.model.u.axy() });
      z.a(getContext(), this.uuT, str);
      this.uuV.setText(2131760942);
      this.utj = new d(getContext());
      this.iMi.findViewById(2131301845).setVisibility(0);
    }
  }
  
  private int dag()
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
        paramAnonymousMenuItem.ISu = new n.c()
        {
          public final void onCreateMMMenu(l paramAnonymous2l)
          {
            AppMethodBeat.i(65634);
            paramAnonymous2l.jw(1, 2131760896);
            paramAnonymous2l.jw(2, 2131760898);
            AppMethodBeat.o(65634);
          }
        };
        paramAnonymousMenuItem.ISv = new n.d()
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
        paramAnonymousMenuItem.cED();
        AppMethodBeat.o(65636);
        return false;
      }
    });
    this.oAn = ((TextView)findViewById(2131301851));
    this.uti = ((MMLoadMoreListView)findViewById(2131301853));
    this.iMi = LayoutInflater.from(this).inflate(2131494647, null);
    this.uti.addHeaderView(this.iMi);
    this.ozi = ((ImageView)this.iMi.findViewById(2131301839));
    this.uuT = ((TextView)this.iMi.findViewById(2131301842));
    this.uhh = ((TextView)this.iMi.findViewById(2131301838));
    this.uuU = ((TextView)this.iMi.findViewById(2131301843));
    this.uuV = ((TextView)this.iMi.findViewById(2131301844));
    this.uuW = ((TextView)this.iMi.findViewById(2131301840));
    this.uuX = ((TextView)this.iMi.findViewById(2131301841));
    this.uuY = ((TextView)this.iMi.findViewById(2131301847));
    this.uuZ = ((TextView)this.iMi.findViewById(2131301846));
    this.uti.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(65637);
        paramAnonymousInt = (int)paramAnonymousLong;
        com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(LuckyMoneyMyRecordUI.e(LuckyMoneyMyRecordUI.this)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
        if ((paramAnonymousInt >= 0) && (paramAnonymousInt < LuckyMoneyMyRecordUI.f(LuckyMoneyMyRecordUI.this).getCount()))
        {
          paramAnonymousView = LuckyMoneyMyRecordUI.f(LuckyMoneyMyRecordUI.this).HW(paramAnonymousInt);
          if ((paramAnonymousView != null) && (!bs.isNullOrNil(paramAnonymousView.uhB)))
          {
            paramAnonymousAdapterView = new Intent();
            if (paramAnonymousView.ulQ != 2) {
              break label247;
            }
            ac.d("MicroMsg.LuckyMoneyMyRecordUI", "onItemClick: go busi detail");
            paramAnonymousAdapterView.setClass(LuckyMoneyMyRecordUI.this.getContext(), LuckyMoneyBusiDetailUI.class);
            paramAnonymousAdapterView.putExtra("key_sendid", paramAnonymousView.uhB);
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
          paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousAdapterView);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousAdapterView.aeD(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyMyRecordUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyMyRecordUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(65637);
          return;
          label247:
          ac.d("MicroMsg.LuckyMoneyMyRecordUI", "onItemClick: go normal detail");
          paramAnonymousAdapterView.setClass(LuckyMoneyMyRecordUI.this.getContext(), LuckyMoneyBeforeDetailUI.class);
          break;
        }
      }
    });
    this.uti.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
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
          public final void kG(int paramAnonymous2Int)
          {
            AppMethodBeat.i(65638);
            switch (paramAnonymous2Int)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(65638);
              return;
              t localt = LuckyMoneyMyRecordUI.f(LuckyMoneyMyRecordUI.this).HW(this.uvf);
              if (localt != null)
              {
                LuckyMoneyMyRecordUI.b(LuckyMoneyMyRecordUI.this, this.uvf);
                LuckyMoneyMyRecordUI.a(LuckyMoneyMyRecordUI.this, localt, this.uvf);
              }
            }
          }
        });
        AppMethodBeat.o(65639);
        return true;
      }
    });
    this.uti.setOnLoadMoreListener(new MMLoadMoreListView.a()
    {
      public final void Xa()
      {
        AppMethodBeat.i(65640);
        if (!LuckyMoneyMyRecordUI.this.usr.isProcessing()) {
          LuckyMoneyMyRecordUI.g(LuckyMoneyMyRecordUI.this);
        }
        if ((LuckyMoneyMyRecordUI.h(LuckyMoneyMyRecordUI.this)) && (!LuckyMoneyMyRecordUI.i(LuckyMoneyMyRecordUI.this))) {
          LuckyMoneyMyRecordUI.d(LuckyMoneyMyRecordUI.this);
        }
        AppMethodBeat.o(65640);
      }
    });
    this.ozi.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65641);
        if (!bs.isNullOrNil(LuckyMoneyMyRecordUI.this.unO))
        {
          com.tencent.mm.wallet_core.ui.e.o(LuckyMoneyMyRecordUI.this, LuckyMoneyMyRecordUI.this.unO, true);
          AppMethodBeat.o(65641);
          return;
        }
        ac.w("MicroMsg.LuckyMoneyMyRecordUI", "hy: no avatar jump h5");
        AppMethodBeat.o(65641);
      }
    });
    daf();
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
    cZV();
    com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(dag()), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
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
        paramn = paramString.unL.ulR;
        this.usK = paramString.unu;
        this.unO = paramString.unO;
        Object localObject2;
        if (this.MW == 0)
        {
          this.uvc = paramString.unM;
          this.uva = paramString.unN;
          localObject1 = findViewById(2131301849);
          localObject2 = (ImageView)findViewById(2131301848);
          if (this.uvc.size() > 1)
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
          this.uuY.setText(getString(2131760943, new Object[] { this.uva }));
        }
        Object localObject1 = paramString.unL;
        if (localObject1 != null)
        {
          if (this.mType != 1) {
            break label387;
          }
          this.uhh.setText(com.tencent.mm.wallet_core.ui.e.C(((s)localObject1).umE / 100.0D));
          localObject1 = ((s)localObject1).umD;
          Object localObject3 = getString(2131760959, new Object[] { localObject1 });
          localObject2 = new ForegroundColorSpan(getResources().getColor(2131100574));
          paramInt1 = ((String)localObject3).indexOf((String)localObject1);
          localObject3 = new SpannableString((CharSequence)localObject3);
          ((SpannableString)localObject3).setSpan(localObject2, paramInt1, ((String)localObject1).length() + paramInt1, 33);
          this.uuZ.setText((CharSequence)localObject3);
        }
        while (paramn != null)
        {
          paramInt1 = 0;
          for (;;)
          {
            if (paramInt1 < paramn.size())
            {
              localObject1 = (t)paramn.get(paramInt1);
              if (!this.usI.containsKey(((t)localObject1).uhB))
              {
                this.uhb.add(paramn.get(paramInt1));
                this.usI.put(((t)localObject1).uhB, Integer.valueOf(1));
              }
              paramInt1 += 1;
              continue;
              label387:
              this.uhh.setText(com.tencent.mm.wallet_core.ui.e.C(((s)localObject1).umC / 100.0D));
              this.uuU.setText(((s)localObject1).umB);
              this.uuW.setText(((s)localObject1).umF);
              break;
            }
          }
          this.MW += paramn.size();
          this.usC = paramString.cZf();
          this.kOL = false;
          this.utj.ef(this.uhb);
        }
        if ((this.uhb == null) || (this.uhb.size() == 0))
        {
          this.oAn.setVisibility(0);
          if (!this.usC) {
            break label561;
          }
          this.uti.fiw();
        }
        for (;;)
        {
          AppMethodBeat.o(65652);
          return true;
          this.oAn.setVisibility(8);
          break;
          label561:
          this.uti.fix();
        }
      }
      this.unO = null;
    }
    int i;
    do
    {
      do
      {
        AppMethodBeat.o(65652);
        return false;
      } while (!(paramn instanceof al));
      i = this.uvb;
      this.uvb = -1;
    } while ((paramInt1 != 0) || (paramInt2 != 0));
    paramString = this.utj.HW(i);
    if (paramString != null)
    {
      Toast.makeText(this, 2131760890, 0).show();
      this.utj.a(paramString);
      this.utj.notifyDataSetChanged();
    }
    for (;;)
    {
      AppMethodBeat.o(65652);
      return true;
      ac.e("MicroMsg.LuckyMoneyMyRecordUI", "can't found local record");
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
    int bns;
    List<String> uvc;
    
    a() {}
    
    public final int getCount()
    {
      AppMethodBeat.i(65644);
      int i = this.uvc.size();
      AppMethodBeat.o(65644);
      return i;
    }
    
    public final String getItem(int paramInt)
    {
      AppMethodBeat.i(65645);
      String str = (String)this.uvc.get(paramInt);
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
      if (paramInt == this.bns) {
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