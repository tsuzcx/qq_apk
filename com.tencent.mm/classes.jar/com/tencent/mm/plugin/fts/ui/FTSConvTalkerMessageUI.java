package com.tencent.mm.plugin.fts.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.a.c;
import java.util.ArrayList;
import java.util.List;

public class FTSConvTalkerMessageUI
  extends FTSBaseUI
{
  private int dmr;
  private int lox;
  private String query;
  private String tFT;
  private String tFU;
  private i tKt;
  private String talker;
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(111928);
    if (this.tKt == null) {
      this.tKt = new i(this, this.talker, this.tFU, this.tFT, this.lox, this.dmr);
    }
    parame = this.tKt;
    AppMethodBeat.o(111928);
    return parame;
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(168770);
    super.a(paramString2, paramString2, paramList, paramb);
    AppMethodBeat.o(168770);
  }
  
  protected final void cVY()
  {
    AppMethodBeat.i(111927);
    super.cVY();
    this.tFT = getIntent().getStringExtra("key_conv");
    this.talker = getIntent().getStringExtra("key_talker");
    this.query = getIntent().getStringExtra("key_query");
    this.tFU = getIntent().getStringExtra("key_talker_query");
    this.dmr = getIntent().getIntExtra("detail_type", 1);
    this.lox = getIntent().getIntExtra("Search_Scene", 0);
    ae.i("MicroMsg.FTS.FTSConvTalkerMessageUI", "initSearchData query=%s talker=%s conversation=%s showType=%d", new Object[] { this.query, this.talker, this.tFT, Integer.valueOf(this.dmr) });
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
    ((n)g.ad(n.class)).getFTSImageLoader().cVe();
    paramBundle = new a((byte)0);
    a.a(paramBundle, this.tFU);
    a locala1 = new a((byte)0);
    a.a(locala1, ">");
    a locala2 = new a((byte)0);
    a.a(locala2, com.tencent.mm.plugin.fts.a.d.ahd(this.tFT));
    ArrayList localArrayList = new ArrayList();
    if (this.dmr == 2)
    {
      localArrayList.add(paramBundle);
      localArrayList.add(locala1);
      localArrayList.add(locala2);
    }
    for (;;)
    {
      u(this.query, localArrayList);
      cVT();
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
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSConvTalkerMessageUI
 * JD-Core Version:    0.7.0.1
 */