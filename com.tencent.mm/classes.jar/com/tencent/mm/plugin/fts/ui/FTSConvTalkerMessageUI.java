package com.tencent.mm.plugin.fts.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.a.c;
import java.util.ArrayList;
import java.util.List;

public class FTSConvTalkerMessageUI
  extends FTSBaseUI
{
  private int dlp;
  private int ljZ;
  private String query;
  private String talker;
  private String tvc;
  private String tvd;
  private i tzC;
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(111928);
    if (this.tzC == null) {
      this.tzC = new i(this, this.talker, this.tvd, this.tvc, this.ljZ, this.dlp);
    }
    parame = this.tzC;
    AppMethodBeat.o(111928);
    return parame;
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(168770);
    super.a(paramString2, paramString2, paramList, paramb);
    AppMethodBeat.o(168770);
  }
  
  protected final void cTt()
  {
    AppMethodBeat.i(111927);
    super.cTt();
    this.tvc = getIntent().getStringExtra("key_conv");
    this.talker = getIntent().getStringExtra("key_talker");
    this.query = getIntent().getStringExtra("key_query");
    this.tvd = getIntent().getStringExtra("key_talker_query");
    this.dlp = getIntent().getIntExtra("detail_type", 1);
    this.ljZ = getIntent().getIntExtra("Search_Scene", 0);
    ad.i("MicroMsg.FTS.FTSConvTalkerMessageUI", "initSearchData query=%s talker=%s conversation=%s showType=%d", new Object[] { this.query, this.talker, this.tvc, Integer.valueOf(this.dlp) });
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
    ((n)g.ad(n.class)).getFTSImageLoader().cSz();
    paramBundle = new a((byte)0);
    a.a(paramBundle, this.tvd);
    a locala1 = new a((byte)0);
    a.a(locala1, ">");
    a locala2 = new a((byte)0);
    a.a(locala2, com.tencent.mm.plugin.fts.a.d.agg(this.tvc));
    ArrayList localArrayList = new ArrayList();
    if (this.dlp == 2)
    {
      localArrayList.add(paramBundle);
      localArrayList.add(locala1);
      localArrayList.add(locala2);
    }
    for (;;)
    {
      t(this.query, localArrayList);
      cTo();
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
    private String fVj;
    
    private a() {}
    
    public final int compareTo(Object paramObject)
    {
      return 0;
    }
    
    public final String getTagName()
    {
      return this.fVj;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSConvTalkerMessageUI
 * JD-Core Version:    0.7.0.1
 */