package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.luckymoney.model.ak;
import com.tencent.mm.plugin.luckymoney.model.s;
import com.tencent.mm.plugin.luckymoney.model.t;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.MMLoadMoreListView.a;
import java.util.LinkedList;
import java.util.List;

public class LuckyMoneyCanShareListUI
  extends LuckyMoneyBaseUI
{
  private int fq;
  private boolean lpM;
  private MMLoadMoreListView vHP;
  private e vHQ;
  private boolean vHj;
  private String vHr;
  private List<t> vvQ;
  
  public LuckyMoneyCanShareListUI()
  {
    AppMethodBeat.i(65508);
    this.fq = 0;
    this.vvQ = new LinkedList();
    this.vHj = true;
    this.lpM = false;
    this.vHr = "";
    AppMethodBeat.o(65508);
  }
  
  private void dmh()
  {
    AppMethodBeat.i(65512);
    this.lpM = true;
    if (this.fq == 0) {
      this.vHr = "";
    }
    doSceneProgress(new ak(10, this.fq, 3, "", "v1.0", this.vHr));
    AppMethodBeat.o(65512);
  }
  
  public int getLayoutId()
  {
    return 2131494649;
  }
  
  public void initView()
  {
    AppMethodBeat.i(65510);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(65505);
        LuckyMoneyCanShareListUI.this.finish();
        AppMethodBeat.o(65505);
        return true;
      }
    });
    this.vHP = ((MMLoadMoreListView)findViewById(2131301853));
    setMMTitle(getString(2131760886));
    this.vHQ = new f(getContext());
    this.vHP.setAdapter(this.vHQ);
    this.vHP.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(65506);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyCanShareListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
        paramAnonymousView = LuckyMoneyCanShareListUI.a(LuckyMoneyCanShareListUI.this).JR((int)paramAnonymousLong);
        if ((paramAnonymousView != null) && (!bu.isNullOrNil(paramAnonymousView.vwq)))
        {
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.setClass(LuckyMoneyCanShareListUI.this.getContext(), LuckyMoneyBeforeDetailUI.class);
          paramAnonymousAdapterView.putExtra("key_sendid", paramAnonymousView.vwq);
          paramAnonymousView = LuckyMoneyCanShareListUI.this;
          paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousAdapterView);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousAdapterView.ahE(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyCanShareListUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyCanShareListUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyCanShareListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(65506);
      }
    });
    this.vHP.setOnLoadMoreListener(new MMLoadMoreListView.a()
    {
      public final void ZC()
      {
        AppMethodBeat.i(65507);
        if ((LuckyMoneyCanShareListUI.b(LuckyMoneyCanShareListUI.this)) && (!LuckyMoneyCanShareListUI.c(LuckyMoneyCanShareListUI.this))) {
          LuckyMoneyCanShareListUI.d(LuckyMoneyCanShareListUI.this);
        }
        AppMethodBeat.o(65507);
      }
    });
    AppMethodBeat.o(65510);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65509);
    super.onCreate(paramBundle);
    initView();
    dmh();
    AppMethodBeat.o(65509);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(65511);
    if (((paramn instanceof ak)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (ak)paramn;
      paramn = paramString.vCw.vAC;
      this.vHr = paramString.vCf;
      if (paramn != null)
      {
        paramInt1 = 0;
        while (paramInt1 < paramn.size())
        {
          this.vvQ.add(paramn.get(paramInt1));
          paramInt1 += 1;
        }
        this.fq += paramn.size();
        this.vHj = paramString.dlq();
        this.lpM = false;
        this.vHQ.ew(this.vvQ);
      }
      if (this.vHj) {
        this.vHP.fCN();
      }
      for (;;)
      {
        AppMethodBeat.o(65511);
        return true;
        this.vHP.fCO();
      }
    }
    AppMethodBeat.o(65511);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyCanShareListUI
 * JD-Core Version:    0.7.0.1
 */