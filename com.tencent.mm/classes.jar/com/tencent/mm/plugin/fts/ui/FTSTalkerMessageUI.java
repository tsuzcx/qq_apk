package com.tencent.mm.plugin.fts.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.search.FTSEditTextView.d;
import com.tencent.mm.ui.search.FTSSearchView.c;
import java.util.ArrayList;
import java.util.List;

public class FTSTalkerMessageUI
  extends FTSBaseUI
{
  private String Htw;
  private n Hzp;
  private String query;
  private int syO;
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(112033);
    if (this.Hzp == null) {
      this.Hzp = new n(this, this.Htw, this.syO);
    }
    parame = this.Hzp;
    AppMethodBeat.o(112033);
    return parame;
  }
  
  protected final void fyk()
  {
    AppMethodBeat.i(112032);
    super.fyk();
    this.Htw = getIntent().getStringExtra("key_talker_query");
    this.query = getIntent().getStringExtra("key_query");
    this.syO = getIntent().getIntExtra("Search_Scene", 0);
    Log.i("MicroMsg.FTS.FTSTalkerMessageUI", "initSearchData query=%s talkerQuery=%s", new Object[] { this.query, this.Htw });
    AppMethodBeat.o(112032);
  }
  
  protected final boolean fyz()
  {
    return false;
  }
  
  public int getLayoutId()
  {
    return p.e.fts_talker_message_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(112031);
    super.onCreate(paramBundle);
    ((com.tencent.mm.plugin.fts.a.n)h.az(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().fxg();
    paramBundle = new a((byte)0);
    a.a(paramBundle, this.Htw);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramBundle);
    B(this.query, localArrayList);
    fye();
    AppMethodBeat.o(112031);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(112034);
    this.Hzp.finish();
    ((com.tencent.mm.plugin.fts.a.n)h.az(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().fxe();
    super.onDestroy();
    AppMethodBeat.o(112034);
  }
  
  public void onEditTextChange(String paramString1, String paramString2, List<FTSSearchView.c> paramList, FTSEditTextView.d paramd)
  {
    AppMethodBeat.i(168772);
    super.onEditTextChange(paramString2, paramString2, paramList, paramd);
    AppMethodBeat.o(168772);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    implements FTSSearchView.c
  {
    private String displayName;
    
    private a() {}
    
    public final int compareTo(Object paramObject)
    {
      return 0;
    }
    
    public final String getTagName()
    {
      return this.displayName;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSTalkerMessageUI
 * JD-Core Version:    0.7.0.1
 */