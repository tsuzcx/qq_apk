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
  private int ljZ;
  private String query;
  private m tAu;
  private String tvd;
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(112033);
    if (this.tAu == null) {
      this.tAu = new m(this, this.tvd, this.ljZ);
    }
    parame = this.tAu;
    AppMethodBeat.o(112033);
    return parame;
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(168772);
    super.a(paramString2, paramString2, paramList, paramb);
    AppMethodBeat.o(168772);
  }
  
  protected final void cTt()
  {
    AppMethodBeat.i(112032);
    super.cTt();
    this.tvd = getIntent().getStringExtra("key_talker_query");
    this.query = getIntent().getStringExtra("key_query");
    this.ljZ = getIntent().getIntExtra("Search_Scene", 0);
    ad.i("MicroMsg.FTS.FTSTalkerMessageUI", "initSearchData query=%s talkerQuery=%s", new Object[] { this.query, this.tvd });
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
    ((n)g.ad(n.class)).getFTSImageLoader().cSz();
    paramBundle = new a((byte)0);
    a.a(paramBundle, this.tvd);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramBundle);
    t(this.query, localArrayList);
    cTo();
    AppMethodBeat.o(112031);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(112034);
    this.tAu.finish();
    ((n)g.ad(n.class)).getFTSImageLoader().cSx();
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
    private String fVj;
    
    private a() {}
    
    public final int compareTo(Object paramObject)
    {
      return 0;
    }
    
    public final String getTagName()
    {
      return this.fVj;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSTalkerMessageUI
 * JD-Core Version:    0.7.0.1
 */