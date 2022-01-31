package com.tencent.mm.plugin.brandservice.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.ui.b;
import com.tencent.mm.modelvoiceaddr.ui.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.tools.q;

@a(3)
public class EnterpriseBizSearchUI
  extends MMActivity
  implements b.a, EnterpriseBizContactListView.b
{
  private b jTZ;
  private String jUE;
  private EnterpriseBizContactListView jUe;
  
  public final void a(boolean paramBoolean, String[] paramArrayOfString, long paramLong, int paramInt) {}
  
  public final boolean aWA()
  {
    AppMethodBeat.i(14014);
    hideVKB();
    AppMethodBeat.o(14014);
    return false;
  }
  
  public final void anc()
  {
    AppMethodBeat.i(14010);
    hideVKB();
    AppMethodBeat.o(14010);
  }
  
  public final void apN()
  {
    AppMethodBeat.i(14007);
    finish();
    AppMethodBeat.o(14007);
  }
  
  public final void apO() {}
  
  public final void apP() {}
  
  public final void apQ() {}
  
  public int getLayoutId()
  {
    return 2130969432;
  }
  
  public void initView()
  {
    AppMethodBeat.i(14006);
    if (bo.isNullOrNil(this.jUE))
    {
      this.jUE = getIntent().getStringExtra("enterprise_biz_name");
      if (bo.isNullOrNil(this.jUE)) {
        finish();
      }
    }
    this.jUe = ((EnterpriseBizContactListView)findViewById(2131821952));
    this.jUe.setFatherBizName(this.jUE);
    this.jUe.setExcludeBizChat(true);
    this.jUe.refresh();
    this.jUe.setMode(1);
    this.jUe.aWB();
    this.jUe.dES();
    this.jUe.qM(false);
    this.jUe.setOnTouchListener(this);
    ((TextView)this.jUe.getNoResultView()).setText(2131299321);
    this.jTZ = new b();
    this.jTZ.ru(true);
    this.jTZ.a(this);
    this.jTZ.gcJ = false;
    AppMethodBeat.o(14006);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(14003);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(14003);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(14012);
    this.jTZ.a(this, paramMenu);
    AppMethodBeat.o(14012);
    return true;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(14004);
    super.onDestroy();
    if (this.jUe != null) {
      EnterpriseBizContactListView.release();
    }
    AppMethodBeat.o(14004);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(14011);
    super.onPause();
    this.jTZ.cancel();
    this.jTZ.clearFocus();
    AppMethodBeat.o(14011);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(14013);
    this.jTZ.a(this, paramMenu);
    AppMethodBeat.o(14013);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final boolean wR(String paramString)
  {
    AppMethodBeat.i(14009);
    hideVKB();
    AppMethodBeat.o(14009);
    return true;
  }
  
  public final void wS(String paramString)
  {
    AppMethodBeat.i(14008);
    ab.i("MicroMsg.EnterpriseBizSearchUI", "search biz, key word : %s", new Object[] { paramString });
    this.jUe.atB(paramString);
    AppMethodBeat.o(14008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizSearchUI
 * JD-Core Version:    0.7.0.1
 */