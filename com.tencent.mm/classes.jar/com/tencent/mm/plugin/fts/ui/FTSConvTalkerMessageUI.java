package com.tencent.mm.plugin.fts.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.search.FTSEditTextView.d;
import com.tencent.mm.ui.search.FTSSearchView.c;
import java.util.ArrayList;
import java.util.List;

public class FTSConvTalkerMessageUI
  extends FTSBaseUI
{
  private String Htv;
  private String Htw;
  private i HyL;
  private int hAN;
  private String query;
  private int syO;
  private String talker;
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(111928);
    if (this.HyL == null) {
      this.HyL = new i(this, this.talker, this.Htw, this.Htv, this.syO, this.hAN);
    }
    parame = this.HyL;
    AppMethodBeat.o(111928);
    return parame;
  }
  
  protected final void fyk()
  {
    AppMethodBeat.i(111927);
    super.fyk();
    this.Htv = getIntent().getStringExtra("key_conv");
    this.talker = getIntent().getStringExtra("key_talker");
    this.query = getIntent().getStringExtra("key_query");
    this.Htw = getIntent().getStringExtra("key_talker_query");
    this.hAN = getIntent().getIntExtra("detail_type", 1);
    this.syO = getIntent().getIntExtra("Search_Scene", 0);
    Log.i("MicroMsg.FTS.FTSConvTalkerMessageUI", "initSearchData query=%s talker=%s conversation=%s showType=%d", new Object[] { this.query, this.talker, this.Htv, Integer.valueOf(this.hAN) });
    AppMethodBeat.o(111927);
  }
  
  protected final boolean fyz()
  {
    return false;
  }
  
  public int getLayoutId()
  {
    return p.e.fts_talker_message_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111926);
    super.onCreate(paramBundle);
    ((n)h.az(n.class)).getFTSImageLoader().fxg();
    paramBundle = new a((byte)0);
    a.a(paramBundle, this.Htw);
    a locala1 = new a((byte)0);
    a.a(locala1, ">");
    a locala2 = new a((byte)0);
    a.a(locala2, com.tencent.mm.plugin.fts.a.d.atS(this.Htv));
    ArrayList localArrayList = new ArrayList();
    if (this.hAN == 2)
    {
      localArrayList.add(paramBundle);
      localArrayList.add(locala1);
      localArrayList.add(locala2);
    }
    for (;;)
    {
      B(this.query, localArrayList);
      fye();
      AppMethodBeat.o(111926);
      return;
      localArrayList.add(locala2);
      localArrayList.add(locala1);
      localArrayList.add(paramBundle);
    }
  }
  
  public void onEditTextChange(String paramString1, String paramString2, List<FTSSearchView.c> paramList, FTSEditTextView.d paramd)
  {
    AppMethodBeat.i(168770);
    super.onEditTextChange(paramString2, paramString2, paramList, paramd);
    AppMethodBeat.o(168770);
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
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSConvTalkerMessageUI
 * JD-Core Version:    0.7.0.1
 */