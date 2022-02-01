package com.tencent.mm.plugin.fts.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.a.c;
import java.util.ArrayList;
import java.util.List;

public class FTSTalkerMessageUI
  extends FTSBaseUI
{
  private int lox;
  private String query;
  private String tFU;
  private m tLl;
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(112033);
    if (this.tLl == null) {
      this.tLl = new m(this, this.tFU, this.lox);
    }
    parame = this.tLl;
    AppMethodBeat.o(112033);
    return parame;
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(168772);
    super.a(paramString2, paramString2, paramList, paramb);
    AppMethodBeat.o(168772);
  }
  
  protected final void cVY()
  {
    AppMethodBeat.i(112032);
    super.cVY();
    this.tFU = getIntent().getStringExtra("key_talker_query");
    this.query = getIntent().getStringExtra("key_query");
    this.lox = getIntent().getIntExtra("Search_Scene", 0);
    ae.i("MicroMsg.FTS.FTSTalkerMessageUI", "initSearchData query=%s talkerQuery=%s", new Object[] { this.query, this.tFU });
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
    ((n)g.ad(n.class)).getFTSImageLoader().cVe();
    paramBundle = new a((byte)0);
    a.a(paramBundle, this.tFU);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramBundle);
    u(this.query, localArrayList);
    cVT();
    AppMethodBeat.o(112031);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(112034);
    this.tLl.finish();
    ((n)g.ad(n.class)).getFTSImageLoader().cVc();
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
    private String fXp;
    
    private a() {}
    
    public final int compareTo(Object paramObject)
    {
      return 0;
    }
    
    public final String getTagName()
    {
      return this.fXp;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSTalkerMessageUI
 * JD-Core Version:    0.7.0.1
 */