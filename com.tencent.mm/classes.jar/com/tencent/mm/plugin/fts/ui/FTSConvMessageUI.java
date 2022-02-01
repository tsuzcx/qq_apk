package com.tencent.mm.plugin.fts.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.search.FTSEditTextView.d;
import com.tencent.mm.ui.search.FTSSearchView.c;
import java.util.ArrayList;
import java.util.List;

public class FTSConvMessageUI
  extends FTSBaseUI
{
  private String Htv;
  private h HyI;
  private String query;
  private int syO;
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(111916);
    if (this.HyI == null) {
      this.HyI = new h(parame, this.Htv, this.syO);
    }
    parame = this.HyI;
    AppMethodBeat.o(111916);
    return parame;
  }
  
  public final boolean aWU()
  {
    return false;
  }
  
  protected final void fyk()
  {
    AppMethodBeat.i(111913);
    super.fyk();
    this.Htv = getIntent().getStringExtra("key_conv");
    this.query = getIntent().getStringExtra("key_query");
    this.syO = getIntent().getIntExtra("Search_Scene", 0);
    AppMethodBeat.o(111913);
  }
  
  protected final boolean fyz()
  {
    return false;
  }
  
  public final String getHint()
  {
    AppMethodBeat.i(111917);
    String str = getString(p.g.search_talker_page_hint);
    AppMethodBeat.o(111917);
    return str;
  }
  
  public int getLayoutId()
  {
    return p.e.fts_conv_detail_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111914);
    super.onCreate(paramBundle);
    paramBundle = new a((byte)0);
    a.a(paramBundle, com.tencent.mm.plugin.fts.a.d.atS(this.Htv));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramBundle);
    B(this.query, localArrayList);
    fye();
    AppMethodBeat.o(111914);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(111915);
    this.HyI.finish();
    super.onDestroy();
    AppMethodBeat.o(111915);
  }
  
  public void onEditTextChange(String paramString1, String paramString2, List<FTSSearchView.c> paramList, FTSEditTextView.d paramd)
  {
    AppMethodBeat.i(168768);
    super.onEditTextChange(paramString2, paramString2, paramList, paramd);
    AppMethodBeat.o(168768);
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
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSConvMessageUI
 * JD-Core Version:    0.7.0.1
 */