package com.tencent.mm.plugin.brandservice.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.ui.b;
import com.tencent.mm.modelvoiceaddr.ui.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.tools.r;

@a(3)
public class EnterpriseBizSearchUI
  extends MMActivity
  implements b.a, EnterpriseBizContactListView.c
{
  private b mUp;
  private EnterpriseBizContactListView mUu;
  private String mVj;
  
  public final boolean BX(String paramString)
  {
    AppMethodBeat.i(5747);
    hideVKB();
    AppMethodBeat.o(5747);
    return true;
  }
  
  public final void BY(String paramString)
  {
    AppMethodBeat.i(5746);
    ad.i("MicroMsg.EnterpriseBizSearchUI", "search biz, key word : %s", new Object[] { paramString });
    this.mUu.aKo(paramString);
    AppMethodBeat.o(5746);
  }
  
  public final void a(boolean paramBoolean, String[] paramArrayOfString, long paramLong, int paramInt) {}
  
  public final void aEh()
  {
    AppMethodBeat.i(5748);
    hideVKB();
    AppMethodBeat.o(5748);
  }
  
  public final void aIj()
  {
    AppMethodBeat.i(5745);
    finish();
    AppMethodBeat.o(5745);
  }
  
  public final void aIk() {}
  
  public final void aIl() {}
  
  public final void aIm() {}
  
  public final boolean bCz()
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
    if (bt.isNullOrNil(this.mVj))
    {
      this.mVj = getIntent().getStringExtra("enterprise_biz_name");
      if (bt.isNullOrNil(this.mVj)) {
        finish();
      }
    }
    this.mUu = ((EnterpriseBizContactListView)findViewById(2131305113));
    this.mUu.setFatherBizName(this.mVj);
    this.mUu.setExcludeBizChat(true);
    this.mUu.refresh();
    this.mUu.setMode(1);
    this.mUu.bCA();
    this.mUu.eTK();
    this.mUu.vU(false);
    this.mUu.setOnTouchListener(this);
    ((TextView)this.mUu.getNoResultView()).setText(2131758448);
    this.mUp = new b();
    this.mUp.wH(true);
    this.mUp.a(this);
    this.mUp.hFB = false;
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
    this.mUp.a(this, paramMenu);
    AppMethodBeat.o(5750);
    return true;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(5743);
    super.onDestroy();
    if (this.mUu != null) {
      EnterpriseBizContactListView.release();
    }
    AppMethodBeat.o(5743);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(5749);
    super.onPause();
    this.mUp.cancel();
    this.mUp.clearFocus();
    AppMethodBeat.o(5749);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(5751);
    this.mUp.a(this, paramMenu);
    AppMethodBeat.o(5751);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizSearchUI
 * JD-Core Version:    0.7.0.1
 */