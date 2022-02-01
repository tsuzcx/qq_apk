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
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.luckymoney.model.at;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.plugin.luckymoney.model.y;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.MMLoadMoreListView.a;
import java.util.LinkedList;
import java.util.List;

public class LuckyMoneyCanShareListUI
  extends LuckyMoneyBaseUI
{
  private int fs;
  private boolean mwr;
  private List<y> yQe;
  private MMLoadMoreListView zcN;
  private f zcO;
  private boolean zci;
  private String zcp;
  
  public LuckyMoneyCanShareListUI()
  {
    AppMethodBeat.i(65508);
    this.fs = 0;
    this.yQe = new LinkedList();
    this.zci = true;
    this.mwr = false;
    this.zcp = "";
    AppMethodBeat.o(65508);
  }
  
  private void egc()
  {
    AppMethodBeat.i(65512);
    this.mwr = true;
    if (this.fs == 0) {
      this.zcp = "";
    }
    doSceneProgress(new at(10, this.fs, 3, "", "v1.0", this.zcp));
    AppMethodBeat.o(65512);
  }
  
  public int getLayoutId()
  {
    return 2131495372;
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
    this.zcN = ((MMLoadMoreListView)findViewById(2131304172));
    setMMTitle(getString(2131762655));
    this.zcO = new g(getContext());
    this.zcN.setAdapter(this.zcO);
    this.zcN.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(65506);
        b localb = new b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyCanShareListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        paramAnonymousView = LuckyMoneyCanShareListUI.a(LuckyMoneyCanShareListUI.this).PT((int)paramAnonymousLong);
        if ((paramAnonymousView != null) && (!Util.isNullOrNil(paramAnonymousView.yQE)))
        {
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.setClass(LuckyMoneyCanShareListUI.this.getContext(), LuckyMoneyBeforeDetailUI.class);
          paramAnonymousAdapterView.putExtra("key_sendid", paramAnonymousView.yQE);
          paramAnonymousView = LuckyMoneyCanShareListUI.this;
          paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousAdapterView);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousAdapterView.axQ(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyCanShareListUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyCanShareListUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyCanShareListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(65506);
      }
    });
    this.zcN.setOnLoadMoreListener(new MMLoadMoreListView.a()
    {
      public final void onLoadMore()
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
    egc();
    AppMethodBeat.o(65509);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(65511);
    if (((paramq instanceof at)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (at)paramq;
      paramq = paramString.yXx.yVw;
      this.zcp = paramString.yXg;
      if (paramq != null)
      {
        paramInt1 = 0;
        while (paramInt1 < paramq.size())
        {
          this.yQe.add(paramq.get(paramInt1));
          paramInt1 += 1;
        }
        this.fs += paramq.size();
        this.zci = paramString.efl();
        this.mwr = false;
        this.zcO.fq(this.yQe);
      }
      if (this.zci) {
        this.zcN.gKM();
      }
      for (;;)
      {
        AppMethodBeat.o(65511);
        return true;
        this.zcN.gKN();
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