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
  private com.tencent.mm.modelvoiceaddr.ui.b nYf;
  private BrandServiceSortView nYg;
  
  public final boolean Jp(String paramString)
  {
    AppMethodBeat.i(5670);
    hideVKB();
    AppMethodBeat.o(5670);
    return true;
  }
  
  public final void Jq(String paramString)
  {
    AppMethodBeat.i(5669);
    ad.i("MicroMsg.BrandServiceLocalSearchUI", "search biz, key word : %s", new Object[] { paramString });
    this.nYg.aVH(paramString);
    AppMethodBeat.o(5669);
  }
  
  public final void a(boolean paramBoolean, String[] paramArrayOfString, long paramLong, int paramInt) {}
  
  public final void aOh()
  {
    AppMethodBeat.i(5671);
    hideVKB();
    AppMethodBeat.o(5671);
  }
  
  public final void aSm()
  {
    AppMethodBeat.i(5668);
    finish();
    AppMethodBeat.o(5668);
  }
  
  public final void aSn() {}
  
  public final void aSo() {}
  
  public final void aSp() {}
  
  public final boolean bNV()
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
    this.nYg = ((BrandServiceSortView)findViewById(2131305113));
    this.nYg.setMode(1);
    this.nYg.setReturnResult(getIntent().getBooleanExtra("is_return_result", false));
    this.nYg.fzM();
    this.nYg.xJ(false);
    this.nYg.setShowFooterView(false);
    this.nYg.setITransferToChildOnTouchListener(this);
    this.nYf = new com.tencent.mm.modelvoiceaddr.ui.b();
    this.nYf.yC(true);
    this.nYf.a(this);
    this.nYf.izx = false;
    AppMethodBeat.o(5667);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(5666);
    super.onCreate(paramBundle);
    setActionbarColor(android.support.v4.content.b.n(getContext(), 2131100705));
    initView();
    paramBundle = new l(18);
    g.aiU().a(paramBundle, 0);
    AppMethodBeat.o(5666);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(5674);
    this.nYf.a(this, paramMenu);
    AppMethodBeat.o(5674);
    return true;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(5673);
    super.onDestroy();
    this.nYg.release();
    AppMethodBeat.o(5673);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(5672);
    super.onPause();
    this.nYf.cancel();
    this.nYf.clearFocus();
    AppMethodBeat.o(5672);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(5675);
    this.nYf.a(this, paramMenu);
    AppMethodBeat.o(5675);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.BrandServiceLocalSearchUI
 * JD-Core Version:    0.7.0.1
 */