package com.tencent.mm.plugin.fts.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.b;
import com.tencent.mm.plugin.fts.ui.widget.a.b;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;

public class FTSTalkerMessageUI
  extends FTSBaseUI
{
  private String bVk;
  private l kCp;
  private String kwZ;
  private int kxJ;
  
  protected final d a(e parame)
  {
    if (this.kCp == null) {
      this.kCp = new l(this, this.kwZ, this.kxJ);
    }
    return this.kCp;
  }
  
  public final void a(String paramString1, String paramString2, List<a.b> paramList, FTSEditTextView.b paramb)
  {
    super.a(paramString2, paramString2, paramList, paramb);
  }
  
  protected final void aWa()
  {
    super.aWa();
    this.kwZ = getIntent().getStringExtra("key_talker_query");
    this.bVk = getIntent().getStringExtra("key_query");
    this.kxJ = getIntent().getIntExtra("Search_Scene", 0);
    y.i("MicroMsg.FTS.FTSTalkerMessageUI", "initSearchData query=%s talkerQuery=%s", new Object[] { this.bVk, this.kwZ });
  }
  
  protected final int getLayoutId()
  {
    return n.e.fts_talker_message_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ((n)g.t(n.class)).getFTSImageLoader().aVm();
    paramBundle = new FTSTalkerMessageUI.a(this, (byte)0);
    FTSTalkerMessageUI.a.a(paramBundle, this.kwZ);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramBundle);
    l(this.bVk, localArrayList);
    aVW();
  }
  
  protected void onDestroy()
  {
    this.kCp.finish();
    ((n)g.t(n.class)).getFTSImageLoader().aVk();
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSTalkerMessageUI
 * JD-Core Version:    0.7.0.1
 */