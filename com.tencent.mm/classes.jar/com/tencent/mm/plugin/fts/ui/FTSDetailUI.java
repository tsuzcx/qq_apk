package com.tencent.mm.plugin.fts.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.search.FTSEditTextView;

public class FTSDetailUI
  extends FTSBaseUI
{
  private int ljZ;
  private int pLM;
  private j tzJ;
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(111942);
    if (this.tzJ == null) {
      this.tzJ = new j(parame, this.pLM, this.ljZ);
    }
    parame = this.tzJ;
    AppMethodBeat.o(111942);
    return parame;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean) {}
  
  protected final void cTt()
  {
    AppMethodBeat.i(111941);
    this.pLM = getIntent().getIntExtra("detail_type", 0);
    this.ljZ = getIntent().getIntExtra("Search_Scene", 0);
    AppMethodBeat.o(111941);
  }
  
  public final String getHint()
  {
    AppMethodBeat.i(111944);
    String str = n.GX(this.pLM);
    if (str == null)
    {
      str = getString(2131755882);
      AppMethodBeat.o(111944);
      return str;
    }
    AppMethodBeat.o(111944);
    return str;
  }
  
  public int getLayoutId()
  {
    return 2131494197;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111940);
    super.onCreate(paramBundle);
    ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().cSz();
    paramBundle = getIntent().getStringExtra("detail_query");
    this.query = paramBundle;
    this.tyX.getFtsEditText().H(paramBundle, null);
    ad.i("MicroMsg.FTS.FTSDetailUI", "onCreate query=%s, searchType=%d, kvScene=%d", new Object[] { this.query, Integer.valueOf(this.pLM), Integer.valueOf(this.ljZ) });
    cTo();
    this.tyX.getFtsEditText().fJP();
    AppMethodBeat.o(111940);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(111943);
    this.tzJ.finish();
    ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().cSw();
    super.onDestroy();
    AppMethodBeat.o(111943);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSDetailUI
 * JD-Core Version:    0.7.0.1
 */