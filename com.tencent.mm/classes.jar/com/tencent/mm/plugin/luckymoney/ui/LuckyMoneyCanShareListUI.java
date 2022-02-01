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
  private int LZ;
  private boolean knt;
  private List<t> sYN;
  private MMLoadMoreListView tkP;
  private e tkQ;
  private boolean tkj;
  private String tkr;
  
  public LuckyMoneyCanShareListUI()
  {
    AppMethodBeat.i(65508);
    this.LZ = 0;
    this.sYN = new LinkedList();
    this.tkj = true;
    this.knt = false;
    this.tkr = "";
    AppMethodBeat.o(65508);
  }
  
  private void cMp()
  {
    AppMethodBeat.i(65512);
    this.knt = true;
    if (this.LZ == 0) {
      this.tkr = "";
    }
    doSceneProgress(new ak(10, this.LZ, 3, "", "v1.0", this.tkr));
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
    this.tkP = ((MMLoadMoreListView)findViewById(2131301853));
    setMMTitle(getString(2131760886));
    this.tkQ = new f(getContext());
    this.tkP.setAdapter(this.tkQ);
    this.tkP.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(65506);
        paramAnonymousView = LuckyMoneyCanShareListUI.a(LuckyMoneyCanShareListUI.this).Gb((int)paramAnonymousLong);
        if ((paramAnonymousView != null) && (!bt.isNullOrNil(paramAnonymousView.sZn)))
        {
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.setClass(LuckyMoneyCanShareListUI.this.getContext(), LuckyMoneyBeforeDetailUI.class);
          paramAnonymousAdapterView.putExtra("key_sendid", paramAnonymousView.sZn);
          paramAnonymousView = LuckyMoneyCanShareListUI.this;
          paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousAdapterView);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousAdapterView.adn(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyCanShareListUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyCanShareListUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(65506);
      }
    });
    this.tkP.setOnLoadMoreListener(new MMLoadMoreListView.a()
    {
      public final void Wc()
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
    cMp();
    AppMethodBeat.o(65509);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(65511);
    if (((paramn instanceof ak)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (ak)paramn;
      paramn = paramString.tfw.tdC;
      this.tkr = paramString.tff;
      if (paramn != null)
      {
        paramInt1 = 0;
        while (paramInt1 < paramn.size())
        {
          this.sYN.add(paramn.get(paramInt1));
          paramInt1 += 1;
        }
        this.LZ += paramn.size();
        this.tkj = paramString.cLz();
        this.knt = false;
        this.tkQ.eb(this.sYN);
      }
      if (this.tkj) {
        this.tkP.eSM();
      }
      for (;;)
      {
        AppMethodBeat.o(65511);
        return true;
        this.tkP.eSN();
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