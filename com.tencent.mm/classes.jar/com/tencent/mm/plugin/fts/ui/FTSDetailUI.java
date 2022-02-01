package com.tencent.mm.plugin.fts.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.abp;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSSearchView;

public class FTSDetailUI
  extends FTSBaseUI
{
  private IListener<abp> HxN;
  private j HyS;
  private int syO;
  private int xVf;
  
  public FTSDetailUI()
  {
    AppMethodBeat.i(265684);
    this.HxN = new FTSDetailUI.1(this, f.hfK);
    AppMethodBeat.o(265684);
  }
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(111942);
    if (this.HyS == null) {
      this.HyS = new j(parame, this.xVf, this.syO);
    }
    parame = this.HyS;
    AppMethodBeat.o(111942);
    return parame;
  }
  
  public final void a(a parama, boolean paramBoolean) {}
  
  protected final void fyk()
  {
    AppMethodBeat.i(111941);
    this.xVf = getIntent().getIntExtra("detail_type", 0);
    this.syO = getIntent().getIntExtra("Search_Scene", 0);
    AppMethodBeat.o(111941);
  }
  
  public final String getHint()
  {
    AppMethodBeat.i(111944);
    String str = o.Wp(this.xVf);
    if (str == null)
    {
      str = getString(p.g.app_search);
      AppMethodBeat.o(111944);
      return str;
    }
    AppMethodBeat.o(111944);
    return str;
  }
  
  public int getLayoutId()
  {
    return p.e.fts_detail_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111940);
    super.onCreate(paramBundle);
    ((n)h.az(n.class)).getFTSImageLoader().fxg();
    aEI(getIntent().getStringExtra("detail_query"));
    Log.i("MicroMsg.FTS.FTSDetailUI", "onCreate query=%s, searchType=%d, kvScene=%d", new Object[] { this.query, Integer.valueOf(this.xVf), Integer.valueOf(this.syO) });
    fye();
    this.Hye.getFtsEditText().jBL();
    this.HxN.alive();
    AppMethodBeat.o(111940);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(111943);
    this.HyS.finish();
    this.HxN.dead();
    ((n)h.az(n.class)).getFTSImageLoader().fxd();
    super.onDestroy();
    AppMethodBeat.o(111943);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(265692);
    super.onResume();
    AppMethodBeat.o(265692);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSDetailUI
 * JD-Core Version:    0.7.0.1
 */