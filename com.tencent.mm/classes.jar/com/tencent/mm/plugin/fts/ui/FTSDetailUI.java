package com.tencent.mm.plugin.fts.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.sdk.platformtools.ab;

public class FTSDetailUI
  extends FTSBaseUI
{
  private int ibk;
  private int lox;
  private i mXm;
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(61847);
    if (this.mXm == null) {
      this.mXm = new i(parame, this.lox, this.ibk);
    }
    parame = this.mXm;
    AppMethodBeat.o(61847);
    return parame;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.a.a parama) {}
  
  protected final void bCD()
  {
    AppMethodBeat.i(61846);
    this.lox = getIntent().getIntExtra("detail_type", 0);
    this.ibk = getIntent().getIntExtra("Search_Scene", 0);
    AppMethodBeat.o(61846);
  }
  
  public final String getHint()
  {
    AppMethodBeat.i(61849);
    String str = m.wA(this.lox);
    if (str == null)
    {
      str = getString(2131297065);
      AppMethodBeat.o(61849);
      return str;
    }
    AppMethodBeat.o(61849);
    return str;
  }
  
  public int getLayoutId()
  {
    return 2130969655;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(61845);
    super.onCreate(paramBundle);
    ((n)g.G(n.class)).getFTSImageLoader().bBL();
    paramBundle = getIntent().getStringExtra("detail_query");
    this.query = paramBundle;
    this.mWO.getFtsEditText().o(paramBundle, null);
    ab.i("MicroMsg.FTS.FTSDetailUI", "onCreate query=%s, searchType=%d, kvScene=%d", new Object[] { this.query, Integer.valueOf(this.lox), Integer.valueOf(this.ibk) });
    bCz();
    this.mWO.getFtsEditText().bDh();
    AppMethodBeat.o(61845);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(61848);
    this.mXm.finish();
    ((n)g.G(n.class)).getFTSImageLoader().bBI();
    super.onDestroy();
    AppMethodBeat.o(61848);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSDetailUI
 * JD-Core Version:    0.7.0.1
 */