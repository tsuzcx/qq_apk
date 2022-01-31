package com.tencent.mm.plugin.fts.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.sdk.platformtools.y;

public class FTSDetailUI
  extends FTSBaseUI
{
  private i kBu;
  private int kxJ;
  private int kxU;
  
  protected final d a(e parame)
  {
    if (this.kBu == null) {
      this.kBu = new i(parame, this.kxU, this.kxJ);
    }
    return this.kBu;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.a.a parama) {}
  
  protected final void aWa()
  {
    this.kxU = getIntent().getIntExtra("detail_type", 0);
    this.kxJ = getIntent().getIntExtra("Search_Scene", 0);
  }
  
  public final String getHint()
  {
    String str2 = m.rF(this.kxU);
    String str1 = str2;
    if (str2 == null) {
      str1 = getString(n.g.app_search);
    }
    return str1;
  }
  
  protected final int getLayoutId()
  {
    return n.e.fts_detail_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ((n)g.t(n.class)).getFTSImageLoader().aVm();
    paramBundle = getIntent().getStringExtra("detail_query");
    this.bVk = paramBundle;
    this.kAW.getFtsEditText().n(paramBundle, null);
    y.i("MicroMsg.FTS.FTSDetailUI", "onCreate query=%s, searchType=%d, kvScene=%d", new Object[] { this.bVk, Integer.valueOf(this.kxU), Integer.valueOf(this.kxJ) });
    aVW();
  }
  
  protected void onDestroy()
  {
    this.kBu.finish();
    ((n)g.t(n.class)).getFTSImageLoader().aVj();
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSDetailUI
 * JD-Core Version:    0.7.0.1
 */