package com.tencent.mm.plugin.brandservice.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.bb.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoiceaddr.ui.b.a;
import com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView;
import com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.tools.s;

@a(3)
public class BrandServiceLocalSearchUI
  extends MMActivity
  implements b.a, BrandServiceSortView.a
{
  private com.tencent.mm.modelvoiceaddr.ui.b poM;
  private BrandServiceSortView poN;
  
  public final boolean SN(String paramString)
  {
    AppMethodBeat.i(5670);
    hideVKB();
    AppMethodBeat.o(5670);
    return true;
  }
  
  public final void SO(String paramString)
  {
    AppMethodBeat.i(5669);
    Log.i("MicroMsg.BrandServiceLocalSearchUI", "search biz, key word : %s", new Object[] { paramString });
    this.poN.bmm(paramString);
    AppMethodBeat.o(5669);
  }
  
  public final void a(boolean paramBoolean, String[] paramArrayOfString, long paramLong, int paramInt) {}
  
  public final void biM()
  {
    AppMethodBeat.i(5671);
    hideVKB();
    AppMethodBeat.o(5671);
  }
  
  public final void bnA() {}
  
  public final void bnB() {}
  
  public final void bny()
  {
    AppMethodBeat.i(5668);
    finish();
    AppMethodBeat.o(5668);
  }
  
  public final void bnz() {}
  
  public final boolean clY()
  {
    AppMethodBeat.i(5676);
    hideVKB();
    AppMethodBeat.o(5676);
    return false;
  }
  
  public int getLayoutId()
  {
    return 2131493321;
  }
  
  public void initView()
  {
    AppMethodBeat.i(5667);
    this.poN = ((BrandServiceSortView)findViewById(2131308290));
    this.poN.setMode(1);
    this.poN.setReturnResult(getIntent().getBooleanExtra("is_return_result", false));
    this.poN.gLV();
    this.poN.BF(false);
    this.poN.setShowFooterView(false);
    this.poN.setITransferToChildOnTouchListener(this);
    this.poM = new com.tencent.mm.modelvoiceaddr.ui.b();
    this.poM.CK(true);
    this.poM.a(this);
    this.poM.jxF = false;
    AppMethodBeat.o(5667);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(5666);
    super.onCreate(paramBundle);
    setActionbarColor(android.support.v4.content.b.n(getContext(), 2131100898));
    initView();
    paramBundle = new n(18);
    g.azz().a(paramBundle, 0);
    AppMethodBeat.o(5666);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(5674);
    this.poM.a(this, paramMenu);
    AppMethodBeat.o(5674);
    return true;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(5673);
    super.onDestroy();
    this.poN.release();
    AppMethodBeat.o(5673);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(5672);
    super.onPause();
    this.poM.cancel();
    this.poM.clearFocus();
    AppMethodBeat.o(5672);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(5675);
    this.poM.a(this, paramMenu);
    AppMethodBeat.o(5675);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.BrandServiceLocalSearchUI
 * JD-Core Version:    0.7.0.1
 */