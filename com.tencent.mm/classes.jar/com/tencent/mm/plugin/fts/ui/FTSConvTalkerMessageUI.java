package com.tencent.mm.plugin.fts.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.a.c;
import java.util.ArrayList;
import java.util.List;

public class FTSConvTalkerMessageUI
  extends FTSBaseUI
{
  private int cZX;
  private int kNw;
  private String query;
  private h sCN;
  private String syB;
  private String syC;
  private String talker;
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(111928);
    if (this.sCN == null) {
      this.sCN = new h(this, this.talker, this.syC, this.syB, this.kNw, this.cZX);
    }
    parame = this.sCN;
    AppMethodBeat.o(111928);
    return parame;
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(168770);
    super.a(paramString2, paramString2, paramList, paramb);
    AppMethodBeat.o(168770);
  }
  
  protected final void cLd()
  {
    AppMethodBeat.i(111927);
    super.cLd();
    this.syB = getIntent().getStringExtra("key_conv");
    this.talker = getIntent().getStringExtra("key_talker");
    this.query = getIntent().getStringExtra("key_query");
    this.syC = getIntent().getStringExtra("key_talker_query");
    this.cZX = getIntent().getIntExtra("detail_type", 1);
    this.kNw = getIntent().getIntExtra("Search_Scene", 0);
    ac.i("MicroMsg.FTS.FTSConvTalkerMessageUI", "initSearchData query=%s talker=%s conversation=%s showType=%d", new Object[] { this.query, this.talker, this.syB, Integer.valueOf(this.cZX) });
    AppMethodBeat.o(111927);
  }
  
  public int getLayoutId()
  {
    return 2131494220;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111926);
    super.onCreate(paramBundle);
    ((n)g.ad(n.class)).getFTSImageLoader().cKk();
    paramBundle = new a((byte)0);
    a.a(paramBundle, this.syC);
    a locala1 = new a((byte)0);
    a.a(locala1, ">");
    a locala2 = new a((byte)0);
    a.a(locala2, com.tencent.mm.plugin.fts.a.d.acr(this.syB));
    ArrayList localArrayList = new ArrayList();
    if (this.cZX == 2)
    {
      localArrayList.add(paramBundle);
      localArrayList.add(locala1);
      localArrayList.add(locala2);
    }
    for (;;)
    {
      r(this.query, localArrayList);
      cKZ();
      AppMethodBeat.o(111926);
      return;
      localArrayList.add(locala2);
      localArrayList.add(locala1);
      localArrayList.add(paramBundle);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    implements a.c
  {
    private String fBV;
    
    private a() {}
    
    public final int compareTo(Object paramObject)
    {
      return 0;
    }
    
    public final String getTagName()
    {
      return this.fBV;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSConvTalkerMessageUI
 * JD-Core Version:    0.7.0.1
 */