package com.tencent.mm.plugin.brandservice.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.bb.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoiceaddr.ui.b.a;
import com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView;
import com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.tools.r;

@a(3)
public class BrandServiceLocalSearchUI
  extends MMActivity
  implements b.a, BrandServiceSortView.a
{
  private com.tencent.mm.modelvoiceaddr.ui.b nwH;
  private BrandServiceSortView nwI;
  
  public final boolean Ga(String paramString)
  {
    AppMethodBeat.i(5670);
    hideVKB();
    AppMethodBeat.o(5670);
    return true;
  }
  
  public final void Gb(String paramString)
  {
    AppMethodBeat.i(5669);
    ac.i("MicroMsg.BrandServiceLocalSearchUI", "search biz, key word : %s", new Object[] { paramString });
    this.nwI.aPR(paramString);
    AppMethodBeat.o(5669);
  }
  
  public final void a(boolean paramBoolean, String[] paramArrayOfString, long paramLong, int paramInt) {}
  
  public final void aKY()
  {
    AppMethodBeat.i(5671);
    hideVKB();
    AppMethodBeat.o(5671);
  }
  
  public final void aPa()
  {
    AppMethodBeat.i(5668);
    finish();
    AppMethodBeat.o(5668);
  }
  
  public final void aPb() {}
  
  public final void aPc() {}
  
  public final void aPd() {}
  
  public final boolean bJC()
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
    this.nwI = ((BrandServiceSortView)findViewById(2131305113));
    this.nwI.setMode(1);
    this.nwI.setReturnResult(getIntent().getBooleanExtra("is_return_result", false));
    this.nwI.fjx();
    this.nwI.wY(false);
    this.nwI.setShowFooterView(false);
    this.nwI.setITransferToChildOnTouchListener(this);
    this.nwH = new com.tencent.mm.modelvoiceaddr.ui.b();
    this.nwH.xO(true);
    this.nwH.a(this);
    this.nwH.igd = false;
    AppMethodBeat.o(5667);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(5666);
    super.onCreate(paramBundle);
    setActionbarColor(android.support.v4.content.b.n(getContext(), 2131100705));
    initView();
    paramBundle = new l(18);
    g.agi().a(paramBundle, 0);
    AppMethodBeat.o(5666);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(5674);
    this.nwH.a(this, paramMenu);
    AppMethodBeat.o(5674);
    return true;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(5673);
    super.onDestroy();
    this.nwI.release();
    AppMethodBeat.o(5673);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(5672);
    super.onPause();
    this.nwH.cancel();
    this.nwH.clearFocus();
    AppMethodBeat.o(5672);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(5675);
    this.nwH.a(this, paramMenu);
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