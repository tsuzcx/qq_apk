package com.tencent.mm.plugin.brandservice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.ui.b;
import com.tencent.mm.modelvoiceaddr.ui.b.a;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.d.i;
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
  private b vDu;
  private EnterpriseBizContactListView vDz;
  private String vEu;
  
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
    this.vDz.bAo(paramString);
    AppMethodBeat.o(5746);
  }
  
  public final void a(boolean paramBoolean, String[] paramArrayOfString, long paramLong, int paramInt) {}
  
  public final void bPQ()
  {
    AppMethodBeat.i(5748);
    hideVKB();
    AppMethodBeat.o(5748);
  }
  
  public final void bWw()
  {
    AppMethodBeat.i(5745);
    finish();
    AppMethodBeat.o(5745);
  }
  
  public final void bWx() {}
  
  public final void bWy() {}
  
  public final void bWz() {}
  
  public final boolean dcu()
  {
    AppMethodBeat.i(5752);
    hideVKB();
    AppMethodBeat.o(5752);
    return false;
  }
  
  public int getLayoutId()
  {
    return d.f.enterprise_biz_search;
  }
  
  public void initView()
  {
    AppMethodBeat.i(5744);
    if (Util.isNullOrNil(this.vEu))
    {
      this.vEu = getIntent().getStringExtra("enterprise_biz_name");
      if (Util.isNullOrNil(this.vEu)) {
        finish();
      }
    }
    this.vDz = ((EnterpriseBizContactListView)findViewById(d.e.sort_and_search_view));
    this.vDz.setFatherBizName(this.vEu);
    this.vDz.setExcludeBizChat(true);
    this.vDz.bDL();
    this.vDz.setMode(1);
    this.vDz.dcv();
    this.vDz.jnG();
    this.vDz.LL(false);
    this.vDz.setOnTouchListener(this);
    ((TextView)this.vDz.getNoResultView()).setText(d.i.enterprise_search_no_result);
    this.vDu = new b();
    this.vDu.MY(true);
    this.vDu.a(this);
    this.vDu.pgU = false;
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
    this.vDu.a(this, paramMenu);
    AppMethodBeat.o(5750);
    return true;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(5743);
    super.onDestroy();
    if (this.vDz != null) {
      EnterpriseBizContactListView.release();
    }
    AppMethodBeat.o(5743);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(5749);
    super.onPause();
    this.vDu.cancel();
    this.vDu.clearFocus();
    AppMethodBeat.o(5749);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(5751);
    this.vDu.a(this, paramMenu);
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