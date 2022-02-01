package com.tencent.mm.plugin.brandservice.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.ui.b;
import com.tencent.mm.modelvoiceaddr.ui.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.tools.r;

@a(3)
public class EnterpriseBizSearchUI
  extends MMActivity
  implements b.a, EnterpriseBizContactListView.d
{
  private b odO;
  private EnterpriseBizContactListView odT;
  private String oeQ;
  
  public final boolean JO(String paramString)
  {
    AppMethodBeat.i(5747);
    hideVKB();
    AppMethodBeat.o(5747);
    return true;
  }
  
  public final void JP(String paramString)
  {
    AppMethodBeat.i(5746);
    ae.i("MicroMsg.EnterpriseBizSearchUI", "search biz, key word : %s", new Object[] { paramString });
    this.odT.aXi(paramString);
    AppMethodBeat.o(5746);
  }
  
  public final void a(boolean paramBoolean, String[] paramArrayOfString, long paramLong, int paramInt) {}
  
  public final void aOF()
  {
    AppMethodBeat.i(5748);
    hideVKB();
    AppMethodBeat.o(5748);
  }
  
  public final void aSL()
  {
    AppMethodBeat.i(5745);
    finish();
    AppMethodBeat.o(5745);
  }
  
  public final void aSM() {}
  
  public final void aSN() {}
  
  public final void aSO() {}
  
  public final boolean bOS()
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
    if (bu.isNullOrNil(this.oeQ))
    {
      this.oeQ = getIntent().getStringExtra("enterprise_biz_name");
      if (bu.isNullOrNil(this.oeQ)) {
        finish();
      }
    }
    this.odT = ((EnterpriseBizContactListView)findViewById(2131305113));
    this.odT.setFatherBizName(this.oeQ);
    this.odT.setExcludeBizChat(true);
    this.odT.refresh();
    this.odT.setMode(1);
    this.odT.bOT();
    this.odT.fDO();
    this.odT.xQ(false);
    this.odT.setOnTouchListener(this);
    ((TextView)this.odT.getNoResultView()).setText(2131758448);
    this.odO = new b();
    this.odO.yP(true);
    this.odO.a(this);
    this.odO.iCq = false;
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
    this.odO.a(this, paramMenu);
    AppMethodBeat.o(5750);
    return true;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(5743);
    super.onDestroy();
    if (this.odT != null) {
      EnterpriseBizContactListView.release();
    }
    AppMethodBeat.o(5743);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(5749);
    super.onPause();
    this.odO.cancel();
    this.odO.clearFocus();
    AppMethodBeat.o(5749);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(5751);
    this.odO.a(this, paramMenu);
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