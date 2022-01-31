package com.tencent.mm.plugin.fts.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.b;
import com.tencent.mm.plugin.fts.ui.widget.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

public class FTSTalkerMessageUI
  extends FTSBaseUI
{
  private int ibk;
  private String mSO;
  private l mYm;
  private String query;
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(61952);
    if (this.mYm == null) {
      this.mYm = new l(this, this.mSO, this.ibk);
    }
    parame = this.mYm;
    AppMethodBeat.o(61952);
    return parame;
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(61954);
    super.a(paramString2, paramString2, paramList, paramb);
    AppMethodBeat.o(61954);
  }
  
  protected final void bCD()
  {
    AppMethodBeat.i(61951);
    super.bCD();
    this.mSO = getIntent().getStringExtra("key_talker_query");
    this.query = getIntent().getStringExtra("key_query");
    this.ibk = getIntent().getIntExtra("Search_Scene", 0);
    ab.i("MicroMsg.FTS.FTSTalkerMessageUI", "initSearchData query=%s talkerQuery=%s", new Object[] { this.query, this.mSO });
    AppMethodBeat.o(61951);
  }
  
  public int getLayoutId()
  {
    return 2130969676;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(61950);
    super.onCreate(paramBundle);
    ((n)g.G(n.class)).getFTSImageLoader().bBL();
    paramBundle = new FTSTalkerMessageUI.a(this, (byte)0);
    FTSTalkerMessageUI.a.a(paramBundle, this.mSO);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramBundle);
    m(this.query, localArrayList);
    bCz();
    AppMethodBeat.o(61950);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(61953);
    this.mYm.finish();
    ((n)g.G(n.class)).getFTSImageLoader().bBJ();
    super.onDestroy();
    AppMethodBeat.o(61953);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSTalkerMessageUI
 * JD-Core Version:    0.7.0.1
 */