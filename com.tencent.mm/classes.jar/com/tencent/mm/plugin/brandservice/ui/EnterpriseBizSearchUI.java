package com.tencent.mm.plugin.brandservice.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.ui.b;
import com.tencent.mm.modelvoiceaddr.ui.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.tools.s;

@a(3)
public class EnterpriseBizSearchUI
  extends MMActivity
  implements b.a, EnterpriseBizContactListView.d
{
  private b poM;
  private EnterpriseBizContactListView poR;
  private String ppO;
  
  public final boolean SN(String paramString)
  {
    AppMethodBeat.i(5747);
    hideVKB();
    AppMethodBeat.o(5747);
    return true;
  }
  
  public final void SO(String paramString)
  {
    AppMethodBeat.i(5746);
    Log.i("MicroMsg.EnterpriseBizSearchUI", "search biz, key word : %s", new Object[] { paramString });
    this.poR.bmm(paramString);
    AppMethodBeat.o(5746);
  }
  
  public final void a(boolean paramBoolean, String[] paramArrayOfString, long paramLong, int paramInt) {}
  
  public final void biM()
  {
    AppMethodBeat.i(5748);
    hideVKB();
    AppMethodBeat.o(5748);
  }
  
  public final void bnA() {}
  
  public final void bnB() {}
  
  public final void bny()
  {
    AppMethodBeat.i(5745);
    finish();
    AppMethodBeat.o(5745);
  }
  
  public final void bnz() {}
  
  public final boolean clY()
  {
    AppMethodBeat.i(5752);
    hideVKB();
    AppMethodBeat.o(5752);
    return false;
  }
  
  public int getLayoutId()
  {
    return 2131493999;
  }
  
  public void initView()
  {
    AppMethodBeat.i(5744);
    if (Util.isNullOrNil(this.ppO))
    {
      this.ppO = getIntent().getStringExtra("enterprise_biz_name");
      if (Util.isNullOrNil(this.ppO)) {
        finish();
      }
    }
    this.poR = ((EnterpriseBizContactListView)findViewById(2131308290));
    this.poR.setFatherBizName(this.ppO);
    this.poR.setExcludeBizChat(true);
    this.poR.refresh();
    this.poR.setMode(1);
    this.poR.clZ();
    this.poR.gLV();
    this.poR.BF(false);
    this.poR.setOnTouchListener(this);
    ((TextView)this.poR.getNoResultView()).setText(2131758746);
    this.poM = new b();
    this.poM.CK(true);
    this.poM.a(this);
    this.poM.jxF = false;
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
    this.poM.a(this, paramMenu);
    AppMethodBeat.o(5750);
    return true;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(5743);
    super.onDestroy();
    if (this.poR != null) {
      EnterpriseBizContactListView.release();
    }
    AppMethodBeat.o(5743);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(5749);
    super.onPause();
    this.poM.cancel();
    this.poM.clearFocus();
    AppMethodBeat.o(5749);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(5751);
    this.poM.a(this, paramMenu);
    AppMethodBeat.o(5751);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizSearchUI
 * JD-Core Version:    0.7.0.1
 */