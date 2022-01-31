package com.tencent.mm.plugin.aa.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.aa.a.c.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.wallet_core.ui.g;

public class AAQueryListUI
  extends BaseAAPresenterActivity
{
  private View gpA;
  private AAQueryListH5UrlFooterView gpB;
  private String gpC;
  private com.tencent.mm.plugin.aa.a.c.b gpu;
  private ListView gpv;
  private b gpw;
  private Dialog gpx;
  private boolean gpy;
  private boolean gpz;
  private int mode;
  
  public AAQueryListUI()
  {
    AppMethodBeat.i(40737);
    this.gpu = ((com.tencent.mm.plugin.aa.a.c.b)P(com.tencent.mm.plugin.aa.a.c.b.class));
    this.gpy = false;
    this.gpz = false;
    this.mode = 1;
    AppMethodBeat.o(40737);
  }
  
  private void j(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(40739);
    if (this.gpy)
    {
      ab.i("MicroMsg.AAQueryListUI", "getNextPage, loading");
      AppMethodBeat.o(40739);
      return;
    }
    if (paramBoolean)
    {
      this.gpz = false;
      this.gpv.removeFooterView(this.gpB);
    }
    this.gpy = true;
    this.gpu.goO.i(paramBoolean, paramInt).f(new AAQueryListUI.6(this, paramBoolean)).a(new AAQueryListUI.5(this));
    AppMethodBeat.o(40739);
  }
  
  public int getLayoutId()
  {
    return 2130968579;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(40740);
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      boolean bool = paramIntent.getBooleanExtra("close_aa", false);
      int i = paramIntent.getIntExtra("item_position", 0);
      int j = paramIntent.getIntExtra("item_offset", 0);
      if (bool)
      {
        this.gpv.setSelectionFromTop(i, j);
        j(true, this.mode);
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(40740);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(40738);
    super.onCreate(paramBundle);
    setBackBtn(new AAQueryListUI.1(this));
    setMMTitle(2131296378);
    addIconOptionMenu(0, 2130839668, new AAQueryListUI.4(this));
    this.gpv = ((ListView)findViewById(2131820908));
    this.gpv.setOnScrollListener(new AAQueryListUI.2(this));
    this.gpv.setOnItemClickListener(new AAQueryListUI.3(this));
    this.gpA = new AAQueryListLoadingMoreView(this);
    this.gpB = new AAQueryListH5UrlFooterView(this);
    this.gpx = g.a(this, false, null);
    this.gpw = new b(this, this.mode);
    this.gpv.setAdapter(this.gpw);
    this.gpv.setVisibility(4);
    j(false, this.mode);
    AppMethodBeat.o(40738);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AAQueryListUI
 * JD-Core Version:    0.7.0.1
 */