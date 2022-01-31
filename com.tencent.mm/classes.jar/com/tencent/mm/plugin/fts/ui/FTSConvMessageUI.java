package com.tencent.mm.plugin.fts.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.b;
import com.tencent.mm.plugin.fts.ui.widget.a.b;
import java.util.ArrayList;
import java.util.List;

public class FTSConvMessageUI
  extends FTSBaseUI
{
  private String bVk;
  private g kBk;
  private String kwY;
  private int kxJ;
  
  protected final d a(e parame)
  {
    if (this.kBk == null) {
      this.kBk = new g(parame, this.kwY, this.kxJ);
    }
    return this.kBk;
  }
  
  public final void a(String paramString1, String paramString2, List<a.b> paramList, FTSEditTextView.b paramb)
  {
    super.a(paramString2, paramString2, paramList, paramb);
  }
  
  protected final void aWa()
  {
    super.aWa();
    this.kwY = getIntent().getStringExtra("key_conv");
    this.bVk = getIntent().getStringExtra("key_query");
    this.kxJ = getIntent().getIntExtra("Search_Scene", 0);
  }
  
  public final boolean apb()
  {
    return false;
  }
  
  public final String getHint()
  {
    return getString(n.g.search_talker_page_hint);
  }
  
  protected final int getLayoutId()
  {
    return n.e.fts_detail_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = new FTSConvMessageUI.a(this, (byte)0);
    FTSConvMessageUI.a.a(paramBundle, com.tencent.mm.plugin.fts.a.d.Cy(this.kwY));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramBundle);
    l(this.bVk, localArrayList);
    aVW();
  }
  
  protected void onDestroy()
  {
    this.kBk.finish();
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSConvMessageUI
 * JD-Core Version:    0.7.0.1
 */