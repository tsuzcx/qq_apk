package com.tencent.mm.plugin.brandservice.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.ui.b;
import com.tencent.mm.modelvoiceaddr.ui.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.tools.r;

@a(3)
public class EnterpriseBizSearchUI
  extends MMActivity
  implements b.a, EnterpriseBizContactListView.d
{
  private b nYf;
  private EnterpriseBizContactListView nYk;
  private String nZh;
  
  public final boolean Jp(String paramString)
  {
    AppMethodBeat.i(5747);
    hideVKB();
    AppMethodBeat.o(5747);
    return true;
  }
  
  public final void Jq(String paramString)
  {
    AppMethodBeat.i(5746);
    ad.i("MicroMsg.EnterpriseBizSearchUI", "search biz, key word : %s", new Object[] { paramString });
    this.nYk.aVH(paramString);
    AppMethodBeat.o(5746);
  }
  
  public final void a(boolean paramBoolean, String[] paramArrayOfString, long paramLong, int paramInt) {}
  
  public final void aOh()
  {
    AppMethodBeat.i(5748);
    hideVKB();
    AppMethodBeat.o(5748);
  }
  
  public final void aSm()
  {
    AppMethodBeat.i(5745);
    finish();
    AppMethodBeat.o(5745);
  }
  
  public final void aSn() {}
  
  public final void aSo() {}
  
  public final void aSp() {}
  
  public final boolean bNV()
  {
    AppMethodBeat.i(5752);
    hideVKB();
    AppMethodBeat.o(5752);
    return false;
  }
  
  public int getLayoutId()
  {
    return 2131493844;
  }
  
  public void initView()
  {
    AppMethodBeat.i(5744);
    if (bt.isNullOrNil(this.nZh))
    {
      this.nZh = getIntent().getStringExtra("enterprise_biz_name");
      if (bt.isNullOrNil(this.nZh)) {
        finish();
      }
    }
    this.nYk = ((EnterpriseBizContactListView)findViewById(2131305113));
    this.nYk.setFatherBizName(this.nZh);
    this.nYk.setExcludeBizChat(true);
    this.nYk.refresh();
    this.nYk.setMode(1);
    this.nYk.bNW();
    this.nYk.fzM();
    this.nYk.xJ(false);
    this.nYk.setOnTouchListener(this);
    ((TextView)this.nYk.getNoResultView()).setText(2131758448);
    this.nYf = new b();
    this.nYf.yC(true);
    this.nYf.a(this);
    this.nYf.izx = false;
    AppMethodBeat.o(5744);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(5742);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(5742);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(5750);
    this.nYf.a(this, paramMenu);
    AppMethodBeat.o(5750);
    return true;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(5743);
    super.onDestroy();
    if (this.nYk != null) {
      EnterpriseBizContactListView.release();
    }
    AppMethodBeat.o(5743);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(5749);
    super.onPause();
    this.nYf.cancel();
    this.nYf.clearFocus();
    AppMethodBeat.o(5749);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(5751);
    this.nYf.a(this, paramMenu);
    AppMethodBeat.o(5751);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizSearchUI
 * JD-Core Version:    0.7.0.1
 */