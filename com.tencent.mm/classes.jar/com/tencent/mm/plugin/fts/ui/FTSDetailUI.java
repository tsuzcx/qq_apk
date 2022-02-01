package com.tencent.mm.plugin.fts.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.search.FTSEditTextView;

public class FTSDetailUI
  extends FTSBaseUI
{
  private j BNA;
  private int ptD;
  private int uMD;
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(111942);
    if (this.BNA == null) {
      this.BNA = new j(parame, this.uMD, this.ptD);
    }
    parame = this.BNA;
    AppMethodBeat.o(111942);
    return parame;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean) {}
  
  protected final void erD()
  {
    AppMethodBeat.i(111941);
    this.uMD = getIntent().getIntExtra("detail_type", 0);
    this.ptD = getIntent().getIntExtra("Search_Scene", 0);
    AppMethodBeat.o(111941);
  }
  
  public final String getHint()
  {
    AppMethodBeat.i(111944);
    String str = n.SI(this.uMD);
    if (str == null)
    {
      str = getString(o.g.app_search);
      AppMethodBeat.o(111944);
      return str;
    }
    AppMethodBeat.o(111944);
    return str;
  }
  
  public int getLayoutId()
  {
    return o.e.fts_detail_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111940);
    super.onCreate(paramBundle);
    ((com.tencent.mm.plugin.fts.a.n)h.ag(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().eqB();
    aIh(getIntent().getStringExtra("detail_query"));
    Log.i("MicroMsg.FTS.FTSDetailUI", "onCreate query=%s, searchType=%d, kvScene=%d", new Object[] { this.query, Integer.valueOf(this.uMD), Integer.valueOf(this.ptD) });
    erw();
    this.BMN.getFtsEditText().hXB();
    AppMethodBeat.o(111940);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(111943);
    this.BNA.finish();
    ((com.tencent.mm.plugin.fts.a.n)h.ag(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().eqy();
    super.onDestroy();
    AppMethodBeat.o(111943);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSDetailUI
 * JD-Core Version:    0.7.0.1
 */