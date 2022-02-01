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
import com.tencent.mm.al.n;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.luckymoney.model.ak;
import com.tencent.mm.plugin.luckymoney.model.s;
import com.tencent.mm.plugin.luckymoney.model.t;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.MMLoadMoreListView.a;
import java.util.LinkedList;
import java.util.List;

public class LuckyMoneyCanShareListUI
  extends LuckyMoneyBaseUI
{
  private int fq;
  private boolean llo;
  private List<t> vjL;
  private MMLoadMoreListView vvL;
  private e vvM;
  private boolean vvf;
  private String vvn;
  
  public LuckyMoneyCanShareListUI()
  {
    AppMethodBeat.i(65508);
    this.fq = 0;
    this.vjL = new LinkedList();
    this.vvf = true;
    this.llo = false;
    this.vvn = "";
    AppMethodBeat.o(65508);
  }
  
  private void dji()
  {
    AppMethodBeat.i(65512);
    this.llo = true;
    if (this.fq == 0) {
      this.vvn = "";
    }
    doSceneProgress(new ak(10, this.fq, 3, "", "v1.0", this.vvn));
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
    this.vvL = ((MMLoadMoreListView)findViewById(2131301853));
    setMMTitle(getString(2131760886));
    this.vvM = new f(getContext());
    this.vvL.setAdapter(this.vvM);
    this.vvL.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(65506);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyCanShareListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        paramAnonymousView = LuckyMoneyCanShareListUI.a(LuckyMoneyCanShareListUI.this).Js((int)paramAnonymousLong);
        if ((paramAnonymousView != null) && (!bt.isNullOrNil(paramAnonymousView.vkl)))
        {
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.setClass(LuckyMoneyCanShareListUI.this.getContext(), LuckyMoneyBeforeDetailUI.class);
          paramAnonymousAdapterView.putExtra("key_sendid", paramAnonymousView.vkl);
          paramAnonymousView = LuckyMoneyCanShareListUI.this;
          paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousAdapterView);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousAdapterView.ahp(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyCanShareListUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyCanShareListUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyCanShareListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(65506);
      }
    });
    this.vvL.setOnLoadMoreListener(new MMLoadMoreListView.a()
    {
      public final void Zt()
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
    dji();
    AppMethodBeat.o(65509);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(65511);
    if (((paramn instanceof ak)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (ak)paramn;
      paramn = paramString.vqr.vox;
      this.vvn = paramString.vqa;
      if (paramn != null)
      {
        paramInt1 = 0;
        while (paramInt1 < paramn.size())
        {
          this.vjL.add(paramn.get(paramInt1));
          paramInt1 += 1;
        }
        this.fq += paramn.size();
        this.vvf = paramString.dir();
        this.llo = false;
        this.vvM.es(this.vjL);
      }
      if (this.vvf) {
        this.vvL.fyL();
      }
      for (;;)
      {
        AppMethodBeat.o(65511);
        return true;
        this.vvL.fyM();
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