package com.tencent.mm.plugin.fts.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.search.FTSEditTextView.c;
import com.tencent.mm.ui.search.a.c;
import java.util.ArrayList;
import java.util.List;

public class FTSConvTalkerMessageUI
  extends FTSBaseUI
{
  private String BIN;
  private String BIO;
  private i BNs;
  private int fwp;
  private int ptD;
  private String query;
  private String talker;
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(111928);
    if (this.BNs == null) {
      this.BNs = new i(this, this.talker, this.BIO, this.BIN, this.ptD, this.fwp);
    }
    parame = this.BNs;
    AppMethodBeat.o(111928);
    return parame;
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.c paramc)
  {
    AppMethodBeat.i(168770);
    super.a(paramString2, paramString2, paramList, paramc);
    AppMethodBeat.o(168770);
  }
  
  protected final void erD()
  {
    AppMethodBeat.i(111927);
    super.erD();
    this.BIN = getIntent().getStringExtra("key_conv");
    this.talker = getIntent().getStringExtra("key_talker");
    this.query = getIntent().getStringExtra("key_query");
    this.BIO = getIntent().getStringExtra("key_talker_query");
    this.fwp = getIntent().getIntExtra("detail_type", 1);
    this.ptD = getIntent().getIntExtra("Search_Scene", 0);
    Log.i("MicroMsg.FTS.FTSConvTalkerMessageUI", "initSearchData query=%s talker=%s conversation=%s showType=%d", new Object[] { this.query, this.talker, this.BIN, Integer.valueOf(this.fwp) });
    AppMethodBeat.o(111927);
  }
  
  public int getLayoutId()
  {
    return o.e.fts_talker_message_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111926);
    super.onCreate(paramBundle);
    ((n)h.ag(n.class)).getFTSImageLoader().eqB();
    paramBundle = new a((byte)0);
    a.a(paramBundle, this.BIO);
    a locala1 = new a((byte)0);
    a.a(locala1, ">");
    a locala2 = new a((byte)0);
    a.a(locala2, com.tencent.mm.plugin.fts.a.d.azM(this.BIN));
    ArrayList localArrayList = new ArrayList();
    if (this.fwp == 2)
    {
      localArrayList.add(paramBundle);
      localArrayList.add(locala1);
      localArrayList.add(locala2);
    }
    for (;;)
    {
      w(this.query, localArrayList);
      erw();
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
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSConvTalkerMessageUI
 * JD-Core Version:    0.7.0.1
 */