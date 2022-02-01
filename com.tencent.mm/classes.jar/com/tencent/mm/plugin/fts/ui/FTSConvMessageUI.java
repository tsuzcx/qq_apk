package com.tencent.mm.plugin.fts.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.search.FTSEditTextView.c;
import com.tencent.mm.ui.search.a.c;
import java.util.ArrayList;
import java.util.List;

public class FTSConvMessageUI
  extends FTSBaseUI
{
  private String BIN;
  private h BNp;
  private int ptD;
  private String query;
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(111916);
    if (this.BNp == null) {
      this.BNp = new h(parame, this.BIN, this.ptD);
    }
    parame = this.BNp;
    AppMethodBeat.o(111916);
    return parame;
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.c paramc)
  {
    AppMethodBeat.i(168768);
    super.a(paramString2, paramString2, paramList, paramc);
    AppMethodBeat.o(168768);
  }
  
  public final boolean aDV()
  {
    return false;
  }
  
  protected final void erD()
  {
    AppMethodBeat.i(111913);
    super.erD();
    this.BIN = getIntent().getStringExtra("key_conv");
    this.query = getIntent().getStringExtra("key_query");
    this.ptD = getIntent().getIntExtra("Search_Scene", 0);
    AppMethodBeat.o(111913);
  }
  
  public final String getHint()
  {
    AppMethodBeat.i(111917);
    String str = getString(o.g.search_talker_page_hint);
    AppMethodBeat.o(111917);
    return str;
  }
  
  public int getLayoutId()
  {
    return o.e.fts_conv_detail_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111914);
    super.onCreate(paramBundle);
    paramBundle = new a((byte)0);
    a.a(paramBundle, com.tencent.mm.plugin.fts.a.d.azM(this.BIN));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramBundle);
    w(this.query, localArrayList);
    erw();
    AppMethodBeat.o(111914);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(111915);
    this.BNp.finish();
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
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSConvMessageUI
 * JD-Core Version:    0.7.0.1
 */