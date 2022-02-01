package com.tencent.mm.plugin.fts.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.a.c;
import java.util.ArrayList;
import java.util.List;

public class FTSTalkerMessageUI
  extends FTSBaseUI
{
  private int kme;
  private String query;
  private String rpI;
  private l ruN;
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(112033);
    if (this.ruN == null) {
      this.ruN = new l(this, this.rpI, this.kme);
    }
    parame = this.ruN;
    AppMethodBeat.o(112033);
    return parame;
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(168772);
    super.a(paramString2, paramString2, paramList, paramb);
    AppMethodBeat.o(168772);
  }
  
  protected final void cxR()
  {
    AppMethodBeat.i(112032);
    super.cxR();
    this.rpI = getIntent().getStringExtra("key_talker_query");
    this.query = getIntent().getStringExtra("key_query");
    this.kme = getIntent().getIntExtra("Search_Scene", 0);
    ad.i("MicroMsg.FTS.FTSTalkerMessageUI", "initSearchData query=%s talkerQuery=%s", new Object[] { this.query, this.rpI });
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
    ((n)g.ad(n.class)).getFTSImageLoader().cwY();
    paramBundle = new a((byte)0);
    a.a(paramBundle, this.rpI);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramBundle);
    t(this.query, localArrayList);
    cxN();
    AppMethodBeat.o(112031);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(112034);
    this.ruN.finish();
    ((n)g.ad(n.class)).getFTSImageLoader().cwW();
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
    private String fyo;
    
    private a() {}
    
    public final int compareTo(Object paramObject)
    {
      return 0;
    }
    
    public final String getTagName()
    {
      return this.fyo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSTalkerMessageUI
 * JD-Core Version:    0.7.0.1
 */