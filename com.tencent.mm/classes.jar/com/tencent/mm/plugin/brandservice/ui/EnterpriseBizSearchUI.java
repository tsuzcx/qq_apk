package com.tencent.mm.plugin.brandservice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import com.tencent.mm.modelvoiceaddr.ui.b;
import com.tencent.mm.modelvoiceaddr.ui.b.a;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.plugin.brandservice.b.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.tools.n;

@a(3)
public class EnterpriseBizSearchUI
  extends MMActivity
  implements b.a, EnterpriseBizContactListView.b
{
  private String idQ;
  private b idl;
  private EnterpriseBizContactListView idq;
  
  public final void TP()
  {
    XM();
  }
  
  public final void Wl()
  {
    finish();
  }
  
  public final void Wm() {}
  
  public final void Wn() {}
  
  public final void Wo() {}
  
  public final void a(boolean paramBoolean, String[] paramArrayOfString, long paramLong, int paramInt) {}
  
  public final boolean axC()
  {
    XM();
    return false;
  }
  
  protected final int getLayoutId()
  {
    return b.e.enterprise_biz_search;
  }
  
  protected final void initView()
  {
    if (bk.bl(this.idQ))
    {
      this.idQ = getIntent().getStringExtra("enterprise_biz_name");
      if (bk.bl(this.idQ)) {
        finish();
      }
    }
    this.idq = ((EnterpriseBizContactListView)findViewById(b.d.sort_and_search_view));
    this.idq.setFatherBizName(this.idQ);
    this.idq.setExcludeBizChat(true);
    this.idq.refresh();
    this.idq.setMode(1);
    this.idq.axD();
    this.idq.cBz();
    this.idq.ng(false);
    this.idq.setOnTouchListener(this);
    ((TextView)this.idq.getNoResultView()).setText(b.h.enterprise_search_no_result);
    this.idl = new b();
    this.idl.nK(true);
    this.idl.a(this);
    this.idl.eNe = false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    this.idl.a(this, paramMenu);
    return true;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.idq != null) {
      EnterpriseBizContactListView.release();
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    this.idl.cancel();
    this.idl.clearFocus();
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    this.idl.a(this, paramMenu);
    return true;
  }
  
  public final boolean pB(String paramString)
  {
    XM();
    return true;
  }
  
  public final void pC(String paramString)
  {
    y.i("MicroMsg.EnterpriseBizSearchUI", "search biz, key word : %s", new Object[] { paramString });
    this.idq.adg(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizSearchUI
 * JD-Core Version:    0.7.0.1
 */