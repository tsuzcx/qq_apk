package com.tencent.mm.plugin.fts.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.b;
import com.tencent.mm.plugin.fts.ui.widget.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

public class FTSConvTalkerMessageUI
  extends FTSBaseUI
{
  private int ibk;
  private String mSN;
  private String mSO;
  private h mXf;
  private String query;
  private int showType;
  private String talker;
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(61833);
    if (this.mXf == null) {
      this.mXf = new h(this, this.talker, this.mSO, this.mSN, this.ibk, this.showType);
    }
    parame = this.mXf;
    AppMethodBeat.o(61833);
    return parame;
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(61834);
    super.a(paramString2, paramString2, paramList, paramb);
    AppMethodBeat.o(61834);
  }
  
  protected final void bCD()
  {
    AppMethodBeat.i(61832);
    super.bCD();
    this.mSN = getIntent().getStringExtra("key_conv");
    this.talker = getIntent().getStringExtra("key_talker");
    this.query = getIntent().getStringExtra("key_query");
    this.mSO = getIntent().getStringExtra("key_talker_query");
    this.showType = getIntent().getIntExtra("detail_type", 1);
    this.ibk = getIntent().getIntExtra("Search_Scene", 0);
    ab.i("MicroMsg.FTS.FTSConvTalkerMessageUI", "initSearchData query=%s talker=%s conversation=%s showType=%d", new Object[] { this.query, this.talker, this.mSN, Integer.valueOf(this.showType) });
    AppMethodBeat.o(61832);
  }
  
  public int getLayoutId()
  {
    return 2130969676;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(61831);
    super.onCreate(paramBundle);
    ((n)g.G(n.class)).getFTSImageLoader().bBL();
    paramBundle = new FTSConvTalkerMessageUI.a(this, (byte)0);
    FTSConvTalkerMessageUI.a.a(paramBundle, this.mSO);
    FTSConvTalkerMessageUI.a locala1 = new FTSConvTalkerMessageUI.a(this, (byte)0);
    FTSConvTalkerMessageUI.a.a(locala1, ">");
    FTSConvTalkerMessageUI.a locala2 = new FTSConvTalkerMessageUI.a(this, (byte)0);
    FTSConvTalkerMessageUI.a.a(locala2, com.tencent.mm.plugin.fts.a.d.NA(this.mSN));
    ArrayList localArrayList = new ArrayList();
    if (this.showType == 2)
    {
      localArrayList.add(paramBundle);
      localArrayList.add(locala1);
      localArrayList.add(locala2);
    }
    for (;;)
    {
      m(this.query, localArrayList);
      bCz();
      AppMethodBeat.o(61831);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSConvTalkerMessageUI
 * JD-Core Version:    0.7.0.1
 */