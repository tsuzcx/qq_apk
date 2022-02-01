package com.tencent.mm.plugin.fts.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.search.FTSEditTextView;

public class FTSDetailUI
  extends FTSBaseUI
{
  private int kNw;
  private int pil;
  private i sCU;
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(111942);
    if (this.sCU == null) {
      this.sCU = new i(parame, this.pil, this.kNw);
    }
    parame = this.sCU;
    AppMethodBeat.o(111942);
    return parame;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean) {}
  
  protected final void cLd()
  {
    AppMethodBeat.i(111941);
    this.pil = getIntent().getIntExtra("detail_type", 0);
    this.kNw = getIntent().getIntExtra("Search_Scene", 0);
    AppMethodBeat.o(111941);
  }
  
  public final String getHint()
  {
    AppMethodBeat.i(111944);
    String str = m.FI(this.pil);
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
    ((n)g.ad(n.class)).getFTSImageLoader().cKk();
    paramBundle = getIntent().getStringExtra("detail_query");
    this.query = paramBundle;
    this.sCw.getFtsEditText().F(paramBundle, null);
    ac.i("MicroMsg.FTS.FTSDetailUI", "onCreate query=%s, searchType=%d, kvScene=%d", new Object[] { this.query, Integer.valueOf(this.pil), Integer.valueOf(this.kNw) });
    cKZ();
    this.sCw.getFtsEditText().ftb();
    AppMethodBeat.o(111940);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(111943);
    this.sCU.finish();
    ((n)g.ad(n.class)).getFTSImageLoader().cKh();
    super.onDestroy();
    AppMethodBeat.o(111943);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSDetailUI
 * JD-Core Version:    0.7.0.1
 */