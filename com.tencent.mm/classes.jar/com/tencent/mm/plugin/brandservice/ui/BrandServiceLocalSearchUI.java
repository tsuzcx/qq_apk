package com.tencent.mm.plugin.brandservice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import com.tencent.mm.ah.p;
import com.tencent.mm.az.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView;
import com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.n;

@a(3)
public class BrandServiceLocalSearchUI
  extends MMActivity
  implements com.tencent.mm.modelvoiceaddr.ui.b.a, BrandServiceSortView.a
{
  private com.tencent.mm.modelvoiceaddr.ui.b idl;
  private BrandServiceSortView idm;
  
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
    return b.e.brand_service_local_search;
  }
  
  protected final void initView()
  {
    this.idm = ((BrandServiceSortView)findViewById(b.d.sort_and_search_view));
    this.idm.setMode(1);
    this.idm.setReturnResult(getIntent().getBooleanExtra("is_return_result", false));
    this.idm.cBz();
    this.idm.ng(false);
    this.idm.setShowFooterView(false);
    this.idm.setITransferToChildOnTouchListener(this);
    this.idl = new com.tencent.mm.modelvoiceaddr.ui.b();
    this.idl.nK(true);
    this.idl.a(this);
    this.idl.eNe = false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ta(android.support.v4.content.b.i(this.mController.uMN, com.tencent.mm.plugin.brandservice.b.a.normal_actionbar_color));
    initView();
    paramBundle = new k(18);
    g.Dk().a(paramBundle, 0);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    this.idl.a(this, paramMenu);
    return true;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.idm.release();
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
    y.i("MicroMsg.BrandServiceLocalSearchUI", "search biz, key word : %s", new Object[] { paramString });
    this.idm.adg(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.BrandServiceLocalSearchUI
 * JD-Core Version:    0.7.0.1
 */