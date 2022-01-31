package com.tencent.mm.plugin.fts.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.b;
import com.tencent.mm.plugin.fts.ui.widget.a.c;
import java.util.ArrayList;
import java.util.List;

public class FTSConvMessageUI
  extends FTSBaseUI
{
  private int ibk;
  private String mSN;
  private g mXc;
  private String query;
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(61821);
    if (this.mXc == null) {
      this.mXc = new g(parame, this.mSN, this.ibk);
    }
    parame = this.mXc;
    AppMethodBeat.o(61821);
    return parame;
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(61823);
    super.a(paramString2, paramString2, paramList, paramb);
    AppMethodBeat.o(61823);
  }
  
  public final boolean aMm()
  {
    return false;
  }
  
  protected final void bCD()
  {
    AppMethodBeat.i(61818);
    super.bCD();
    this.mSN = getIntent().getStringExtra("key_conv");
    this.query = getIntent().getStringExtra("key_query");
    this.ibk = getIntent().getIntExtra("Search_Scene", 0);
    AppMethodBeat.o(61818);
  }
  
  public final String getHint()
  {
    AppMethodBeat.i(61822);
    String str = getString(2131303028);
    AppMethodBeat.o(61822);
    return str;
  }
  
  public int getLayoutId()
  {
    return 2130969655;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(61819);
    super.onCreate(paramBundle);
    paramBundle = new a((byte)0);
    a.a(paramBundle, com.tencent.mm.plugin.fts.a.d.NA(this.mSN));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramBundle);
    m(this.query, localArrayList);
    bCz();
    AppMethodBeat.o(61819);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(61820);
    this.mXc.finish();
    super.onDestroy();
    AppMethodBeat.o(61820);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    implements a.c
  {
    private String elx;
    
    private a() {}
    
    public final int compareTo(Object paramObject)
    {
      return 0;
    }
    
    public final String getTagName()
    {
      return this.elx;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSConvMessageUI
 * JD-Core Version:    0.7.0.1
 */