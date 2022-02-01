package com.tencent.mm.plugin.brandservice.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.bc.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoiceaddr.ui.b.a;
import com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView;
import com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.tools.r;

@a(3)
public class BrandServiceLocalSearchUI
  extends MMActivity
  implements b.a, BrandServiceSortView.a
{
  private com.tencent.mm.modelvoiceaddr.ui.b mUp;
  private BrandServiceSortView mUq;
  
  public final boolean BX(String paramString)
  {
    AppMethodBeat.i(5670);
    hideVKB();
    AppMethodBeat.o(5670);
    return true;
  }
  
  public final void BY(String paramString)
  {
    AppMethodBeat.i(5669);
    ad.i("MicroMsg.BrandServiceLocalSearchUI", "search biz, key word : %s", new Object[] { paramString });
    this.mUq.aKo(paramString);
    AppMethodBeat.o(5669);
  }
  
  public final void a(boolean paramBoolean, String[] paramArrayOfString, long paramLong, int paramInt) {}
  
  public final void aEh()
  {
    AppMethodBeat.i(5671);
    hideVKB();
    AppMethodBeat.o(5671);
  }
  
  public final void aIj()
  {
    AppMethodBeat.i(5668);
    finish();
    AppMethodBeat.o(5668);
  }
  
  public final void aIk() {}
  
  public final void aIl() {}
  
  public final void aIm() {}
  
  public final boolean bCz()
  {
    AppMethodBeat.i(5676);
    hideVKB();
    AppMethodBeat.o(5676);
    return false;
  }
  
  public int getLayoutId()
  {
    return 2131493239;
  }
  
  public void initView()
  {
    AppMethodBeat.i(5667);
    this.mUq = ((BrandServiceSortView)findViewById(2131305113));
    this.mUq.setMode(1);
    this.mUq.setReturnResult(getIntent().getBooleanExtra("is_return_result", false));
    this.mUq.eTK();
    this.mUq.vU(false);
    this.mUq.setShowFooterView(false);
    this.mUq.setITransferToChildOnTouchListener(this);
    this.mUp = new com.tencent.mm.modelvoiceaddr.ui.b();
    this.mUp.wH(true);
    this.mUp.a(this);
    this.mUp.hFB = false;
    AppMethodBeat.o(5667);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(5666);
    super.onCreate(paramBundle);
    setActionbarColor(android.support.v4.content.b.n(getContext(), 2131100705));
    initView();
    paramBundle = new l(18);
    g.aeS().a(paramBundle, 0);
    AppMethodBeat.o(5666);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(5674);
    this.mUp.a(this, paramMenu);
    AppMethodBeat.o(5674);
    return true;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(5673);
    super.onDestroy();
    this.mUq.release();
    AppMethodBeat.o(5673);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(5672);
    super.onPause();
    this.mUp.cancel();
    this.mUp.clearFocus();
    AppMethodBeat.o(5672);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(5675);
    this.mUp.a(this, paramMenu);
    AppMethodBeat.o(5675);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.BrandServiceLocalSearchUI
 * JD-Core Version:    0.7.0.1
 */