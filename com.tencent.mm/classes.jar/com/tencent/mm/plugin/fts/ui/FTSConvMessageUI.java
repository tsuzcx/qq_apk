package com.tencent.mm.plugin.fts.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.a.c;
import java.util.ArrayList;
import java.util.List;

public class FTSConvMessageUI
  extends FTSBaseUI
{
  private int mve;
  private String query;
  private String wWS;
  private h xbp;
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(111916);
    if (this.xbp == null) {
      this.xbp = new h(parame, this.wWS, this.mve);
    }
    parame = this.xbp;
    AppMethodBeat.o(111916);
    return parame;
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(168768);
    super.a(paramString2, paramString2, paramList, paramb);
    AppMethodBeat.o(168768);
  }
  
  public final boolean awE()
  {
    return false;
  }
  
  protected final void dPh()
  {
    AppMethodBeat.i(111913);
    super.dPh();
    this.wWS = getIntent().getStringExtra("key_conv");
    this.query = getIntent().getStringExtra("key_query");
    this.mve = getIntent().getIntExtra("Search_Scene", 0);
    AppMethodBeat.o(111913);
  }
  
  public final String getHint()
  {
    AppMethodBeat.i(111917);
    String str = getString(2131765107);
    AppMethodBeat.o(111917);
    return str;
  }
  
  public int getLayoutId()
  {
    return 2131494745;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111914);
    super.onCreate(paramBundle);
    paramBundle = new a((byte)0);
    a.a(paramBundle, com.tencent.mm.plugin.fts.a.d.arL(this.wWS));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramBundle);
    v(this.query, localArrayList);
    dPc();
    AppMethodBeat.o(111914);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(111915);
    this.xbp.finish();
    super.onDestroy();
    AppMethodBeat.o(111915);
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
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSConvMessageUI
 * JD-Core Version:    0.7.0.1
 */