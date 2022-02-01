package com.tencent.mm.plugin.fts.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.a.c;
import java.util.ArrayList;
import java.util.List;

public class FTSTalkerMessageUI
  extends FTSBaseUI
{
  private int kNw;
  private String query;
  private l sDF;
  private String syC;
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(112033);
    if (this.sDF == null) {
      this.sDF = new l(this, this.syC, this.kNw);
    }
    parame = this.sDF;
    AppMethodBeat.o(112033);
    return parame;
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(168772);
    super.a(paramString2, paramString2, paramList, paramb);
    AppMethodBeat.o(168772);
  }
  
  protected final void cLd()
  {
    AppMethodBeat.i(112032);
    super.cLd();
    this.syC = getIntent().getStringExtra("key_talker_query");
    this.query = getIntent().getStringExtra("key_query");
    this.kNw = getIntent().getIntExtra("Search_Scene", 0);
    ac.i("MicroMsg.FTS.FTSTalkerMessageUI", "initSearchData query=%s talkerQuery=%s", new Object[] { this.query, this.syC });
    AppMethodBeat.o(112032);
  }
  
  public int getLayoutId()
  {
    return 2131494220;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(112031);
    super.onCreate(paramBundle);
    ((n)g.ad(n.class)).getFTSImageLoader().cKk();
    paramBundle = new a((byte)0);
    a.a(paramBundle, this.syC);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramBundle);
    r(this.query, localArrayList);
    cKZ();
    AppMethodBeat.o(112031);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(112034);
    this.sDF.finish();
    ((n)g.ad(n.class)).getFTSImageLoader().cKi();
    super.onDestroy();
    AppMethodBeat.o(112034);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    implements a.c
  {
    private String fBV;
    
    private a() {}
    
    public final int compareTo(Object paramObject)
    {
      return 0;
    }
    
    public final String getTagName()
    {
      return this.fBV;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSTalkerMessageUI
 * JD-Core Version:    0.7.0.1
 */