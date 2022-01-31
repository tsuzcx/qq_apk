package com.tencent.mm.plugin.brandservice.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.ba.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoiceaddr.ui.b.a;
import com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView;
import com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.tools.q;

@a(3)
public class BrandServiceLocalSearchUI
  extends MMActivity
  implements b.a, BrandServiceSortView.a
{
  private com.tencent.mm.modelvoiceaddr.ui.b jTZ;
  private BrandServiceSortView jUa;
  
  public final void a(boolean paramBoolean, String[] paramArrayOfString, long paramLong, int paramInt) {}
  
  public final boolean aWA()
  {
    AppMethodBeat.i(13936);
    hideVKB();
    AppMethodBeat.o(13936);
    return false;
  }
  
  public final void anc()
  {
    AppMethodBeat.i(13931);
    hideVKB();
    AppMethodBeat.o(13931);
  }
  
  public final void apN()
  {
    AppMethodBeat.i(13928);
    finish();
    AppMethodBeat.o(13928);
  }
  
  public final void apO() {}
  
  public final void apP() {}
  
  public final void apQ() {}
  
  public int getLayoutId()
  {
    return 2130968899;
  }
  
  public void initView()
  {
    AppMethodBeat.i(13927);
    this.jUa = ((BrandServiceSortView)findViewById(2131821952));
    this.jUa.setMode(1);
    this.jUa.setReturnResult(getIntent().getBooleanExtra("is_return_result", false));
    this.jUa.dES();
    this.jUa.qM(false);
    this.jUa.setShowFooterView(false);
    this.jUa.setITransferToChildOnTouchListener(this);
    this.jTZ = new com.tencent.mm.modelvoiceaddr.ui.b();
    this.jTZ.ru(true);
    this.jTZ.a(this);
    this.jTZ.gcJ = false;
    AppMethodBeat.o(13927);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(13926);
    super.onCreate(paramBundle);
    setActionbarColor(android.support.v4.content.b.m(getContext(), 2131690316));
    initView();
    paramBundle = new k(18);
    g.Rc().a(paramBundle, 0);
    AppMethodBeat.o(13926);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(13934);
    this.jTZ.a(this, paramMenu);
    AppMethodBeat.o(13934);
    return true;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(13933);
    super.onDestroy();
    this.jUa.release();
    AppMethodBeat.o(13933);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(13932);
    super.onPause();
    this.jTZ.cancel();
    this.jTZ.clearFocus();
    AppMethodBeat.o(13932);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(13935);
    this.jTZ.a(this, paramMenu);
    AppMethodBeat.o(13935);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final boolean wR(String paramString)
  {
    AppMethodBeat.i(13930);
    hideVKB();
    AppMethodBeat.o(13930);
    return true;
  }
  
  public final void wS(String paramString)
  {
    AppMethodBeat.i(13929);
    ab.i("MicroMsg.BrandServiceLocalSearchUI", "search biz, key word : %s", new Object[] { paramString });
    this.jUa.atB(paramString);
    AppMethodBeat.o(13929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.BrandServiceLocalSearchUI
 * JD-Core Version:    0.7.0.1
 */