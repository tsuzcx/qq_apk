package com.tencent.mm.plugin.fts.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.search.FTSEditTextView.c;
import com.tencent.mm.ui.search.a.c;
import java.util.ArrayList;
import java.util.List;

public class FTSTalkerMessageUI
  extends FTSBaseUI
{
  private String BIO;
  private m BOm;
  private int ptD;
  private String query;
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(112033);
    if (this.BOm == null) {
      this.BOm = new m(this, this.BIO, this.ptD);
    }
    parame = this.BOm;
    AppMethodBeat.o(112033);
    return parame;
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.c paramc)
  {
    AppMethodBeat.i(168772);
    super.a(paramString2, paramString2, paramList, paramc);
    AppMethodBeat.o(168772);
  }
  
  protected final void erD()
  {
    AppMethodBeat.i(112032);
    super.erD();
    this.BIO = getIntent().getStringExtra("key_talker_query");
    this.query = getIntent().getStringExtra("key_query");
    this.ptD = getIntent().getIntExtra("Search_Scene", 0);
    Log.i("MicroMsg.FTS.FTSTalkerMessageUI", "initSearchData query=%s talkerQuery=%s", new Object[] { this.query, this.BIO });
    AppMethodBeat.o(112032);
  }
  
  public int getLayoutId()
  {
    return o.e.fts_talker_message_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(112031);
    super.onCreate(paramBundle);
    ((n)h.ag(n.class)).getFTSImageLoader().eqB();
    paramBundle = new a((byte)0);
    a.a(paramBundle, this.BIO);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramBundle);
    w(this.query, localArrayList);
    erw();
    AppMethodBeat.o(112031);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(112034);
    this.BOm.finish();
    ((n)h.ag(n.class)).getFTSImageLoader().eqz();
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
    private String jmB;
    
    private a() {}
    
    public final int compareTo(Object paramObject)
    {
      return 0;
    }
    
    public final String getTagName()
    {
      return this.jmB;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSTalkerMessageUI
 * JD-Core Version:    0.7.0.1
 */