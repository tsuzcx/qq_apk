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
  private int lox;
  private String query;
  private String tFT;
  private h tKq;
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(111916);
    if (this.tKq == null) {
      this.tKq = new h(parame, this.tFT, this.lox);
    }
    parame = this.tKq;
    AppMethodBeat.o(111916);
    return parame;
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(168768);
    super.a(paramString2, paramString2, paramList, paramb);
    AppMethodBeat.o(168768);
  }
  
  public final boolean bAu()
  {
    return false;
  }
  
  protected final void cVY()
  {
    AppMethodBeat.i(111913);
    super.cVY();
    this.tFT = getIntent().getStringExtra("key_conv");
    this.query = getIntent().getStringExtra("key_query");
    this.lox = getIntent().getIntExtra("Search_Scene", 0);
    AppMethodBeat.o(111913);
  }
  
  public final String getHint()
  {
    AppMethodBeat.i(111917);
    String str = getString(2131762970);
    AppMethodBeat.o(111917);
    return str;
  }
  
  public int getLayoutId()
  {
    return 2131496402;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111914);
    super.onCreate(paramBundle);
    paramBundle = new a((byte)0);
    a.a(paramBundle, com.tencent.mm.plugin.fts.a.d.ahd(this.tFT));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramBundle);
    u(this.query, localArrayList);
    cVT();
    AppMethodBeat.o(111914);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(111915);
    this.tKq.finish();
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
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSConvMessageUI
 * JD-Core Version:    0.7.0.1
 */