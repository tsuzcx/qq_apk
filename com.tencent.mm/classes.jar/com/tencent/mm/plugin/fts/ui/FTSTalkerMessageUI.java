package com.tencent.mm.plugin.fts.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.a.c;
import java.util.ArrayList;
import java.util.List;

public class FTSTalkerMessageUI
  extends FTSBaseUI
{
  private int mve;
  private String query;
  private String wWT;
  private m xcm;
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(112033);
    if (this.xcm == null) {
      this.xcm = new m(this, this.wWT, this.mve);
    }
    parame = this.xcm;
    AppMethodBeat.o(112033);
    return parame;
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(168772);
    super.a(paramString2, paramString2, paramList, paramb);
    AppMethodBeat.o(168772);
  }
  
  protected final void dPh()
  {
    AppMethodBeat.i(112032);
    super.dPh();
    this.wWT = getIntent().getStringExtra("key_talker_query");
    this.query = getIntent().getStringExtra("key_query");
    this.mve = getIntent().getIntExtra("Search_Scene", 0);
    Log.i("MicroMsg.FTS.FTSTalkerMessageUI", "initSearchData query=%s talkerQuery=%s", new Object[] { this.query, this.wWT });
    AppMethodBeat.o(112032);
  }
  
  public int getLayoutId()
  {
    return 2131494776;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(112031);
    super.onCreate(paramBundle);
    ((n)g.ah(n.class)).getFTSImageLoader().dOn();
    paramBundle = new a((byte)0);
    a.a(paramBundle, this.wWT);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramBundle);
    v(this.query, localArrayList);
    dPc();
    AppMethodBeat.o(112031);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(112034);
    this.xcm.finish();
    ((n)g.ah(n.class)).getFTSImageLoader().dOl();
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
    private String gCv;
    
    private a() {}
    
    public final int compareTo(Object paramObject)
    {
      return 0;
    }
    
    public final String getTagName()
    {
      return this.gCv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSTalkerMessageUI
 * JD-Core Version:    0.7.0.1
 */