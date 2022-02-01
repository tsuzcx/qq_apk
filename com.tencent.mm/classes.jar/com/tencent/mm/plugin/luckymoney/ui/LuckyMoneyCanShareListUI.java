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
import com.tencent.mm.plugin.luckymoney.model.ak;
import com.tencent.mm.plugin.luckymoney.model.s;
import com.tencent.mm.plugin.luckymoney.model.t;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.MMLoadMoreListView.a;
import java.util.LinkedList;
import java.util.List;

public class LuckyMoneyCanShareListUI
  extends LuckyMoneyBaseUI
{
  private int MW;
  private boolean kOL;
  private List<t> uhb;
  private boolean usC;
  private String usK;
  private MMLoadMoreListView uti;
  private e utj;
  
  public LuckyMoneyCanShareListUI()
  {
    AppMethodBeat.i(65508);
    this.MW = 0;
    this.uhb = new LinkedList();
    this.usC = true;
    this.kOL = false;
    this.usK = "";
    AppMethodBeat.o(65508);
  }
  
  private void cZV()
  {
    AppMethodBeat.i(65512);
    this.kOL = true;
    if (this.MW == 0) {
      this.usK = "";
    }
    doSceneProgress(new ak(10, this.MW, 3, "", "v1.0", this.usK));
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
    this.uti = ((MMLoadMoreListView)findViewById(2131301853));
    setMMTitle(getString(2131760886));
    this.utj = new f(getContext());
    this.uti.setAdapter(this.utj);
    this.uti.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(65506);
        paramAnonymousView = LuckyMoneyCanShareListUI.a(LuckyMoneyCanShareListUI.this).HW((int)paramAnonymousLong);
        if ((paramAnonymousView != null) && (!bs.isNullOrNil(paramAnonymousView.uhB)))
        {
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.setClass(LuckyMoneyCanShareListUI.this.getContext(), LuckyMoneyBeforeDetailUI.class);
          paramAnonymousAdapterView.putExtra("key_sendid", paramAnonymousView.uhB);
          paramAnonymousView = LuckyMoneyCanShareListUI.this;
          paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousAdapterView);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousAdapterView.aeD(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyCanShareListUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyCanShareListUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(65506);
      }
    });
    this.uti.setOnLoadMoreListener(new MMLoadMoreListView.a()
    {
      public final void Xa()
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
    cZV();
    AppMethodBeat.o(65509);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(65511);
    if (((paramn instanceof ak)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (ak)paramn;
      paramn = paramString.unL.ulR;
      this.usK = paramString.unu;
      if (paramn != null)
      {
        paramInt1 = 0;
        while (paramInt1 < paramn.size())
        {
          this.uhb.add(paramn.get(paramInt1));
          paramInt1 += 1;
        }
        this.MW += paramn.size();
        this.usC = paramString.cZf();
        this.kOL = false;
        this.utj.ef(this.uhb);
      }
      if (this.usC) {
        this.uti.fiw();
      }
      for (;;)
      {
        AppMethodBeat.o(65511);
        return true;
        this.uti.fix();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyCanShareListUI
 * JD-Core Version:    0.7.0.1
 */