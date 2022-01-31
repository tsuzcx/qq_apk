package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import com.tencent.mm.plugin.aa.a.c.b.a;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.f;
import com.tencent.mm.wallet_core.ui.g;

public class AAQueryListUI
  extends BaseAAPresenterActivity
{
  private Dialog eXA;
  private boolean eXB = false;
  private boolean eXC = false;
  private View eXD;
  private AAQueryListH5UrlFooterView eXE;
  private String eXF;
  private com.tencent.mm.plugin.aa.a.c.b eXx = (com.tencent.mm.plugin.aa.a.c.b)z(com.tencent.mm.plugin.aa.a.c.b.class);
  private ListView eXy;
  private b eXz;
  private int mode = 1;
  
  private void e(boolean paramBoolean, int paramInt)
  {
    if (this.eXB)
    {
      y.i("MicroMsg.AAQueryListUI", "getNextPage, loading");
      return;
    }
    if (paramBoolean)
    {
      this.eXC = false;
      this.eXy.removeFooterView(this.eXE);
    }
    this.eXB = true;
    b.a locala = this.eXx.eWQ;
    f.p(Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt)).c(locala).f(new AAQueryListUI.6(this, paramBoolean)).a(new AAQueryListUI.5(this));
  }
  
  protected final int getLayoutId()
  {
    return a.g.aa_query_list_ui;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      boolean bool = paramIntent.getBooleanExtra("close_aa", false);
      int i = paramIntent.getIntExtra("item_position", 0);
      int j = paramIntent.getIntExtra("item_offset", 0);
      if (bool)
      {
        this.eXy.setSelectionFromTop(i, j);
        e(true, this.mode);
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setBackBtn(new AAQueryListUI.1(this));
    setMMTitle(a.i.aa_record_list_launch_title);
    addIconOptionMenu(0, a.e.mm_title_btn_menu, new AAQueryListUI.4(this));
    this.eXy = ((ListView)findViewById(a.f.aa_query_listview));
    this.eXy.setOnScrollListener(new AAQueryListUI.2(this));
    this.eXy.setOnItemClickListener(new AAQueryListUI.3(this));
    this.eXD = new AAQueryListLoadingMoreView(this);
    this.eXE = new AAQueryListH5UrlFooterView(this);
    this.eXA = g.a(this, false, null);
    this.eXz = new b(this, this.mode);
    this.eXy.setAdapter(this.eXz);
    this.eXy.setVisibility(4);
    e(false, this.mode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AAQueryListUI
 * JD-Core Version:    0.7.0.1
 */