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

public class FTSConvTalkerMessageUI
  extends FTSBaseUI
{
  private String bVk;
  private h kBn;
  private String kwY;
  private String kwZ;
  private int kxJ;
  private int showType;
  private String talker;
  
  protected final d a(e parame)
  {
    if (this.kBn == null) {
      this.kBn = new h(this, this.talker, this.kwZ, this.kwY, this.kxJ, this.showType);
    }
    return this.kBn;
  }
  
  public final void a(String paramString1, String paramString2, List<a.b> paramList, FTSEditTextView.b paramb)
  {
    super.a(paramString2, paramString2, paramList, paramb);
  }
  
  protected final void aWa()
  {
    super.aWa();
    this.kwY = getIntent().getStringExtra("key_conv");
    this.talker = getIntent().getStringExtra("key_talker");
    this.bVk = getIntent().getStringExtra("key_query");
    this.kwZ = getIntent().getStringExtra("key_talker_query");
    this.showType = getIntent().getIntExtra("detail_type", 1);
    this.kxJ = getIntent().getIntExtra("Search_Scene", 0);
    y.i("MicroMsg.FTS.FTSConvTalkerMessageUI", "initSearchData query=%s talker=%s conversation=%s showType=%d", new Object[] { this.bVk, this.talker, this.kwY, Integer.valueOf(this.showType) });
  }
  
  protected final int getLayoutId()
  {
    return n.e.fts_talker_message_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ((n)g.t(n.class)).getFTSImageLoader().aVm();
    paramBundle = new a((byte)0);
    a.a(paramBundle, this.kwZ);
    a locala1 = new a((byte)0);
    a.a(locala1, ">");
    a locala2 = new a((byte)0);
    a.a(locala2, com.tencent.mm.plugin.fts.a.d.Cy(this.kwY));
    ArrayList localArrayList = new ArrayList();
    if (this.showType == 2)
    {
      localArrayList.add(paramBundle);
      localArrayList.add(locala1);
      localArrayList.add(locala2);
    }
    for (;;)
    {
      l(this.bVk, localArrayList);
      aVW();
      return;
      localArrayList.add(locala2);
      localArrayList.add(locala1);
      localArrayList.add(paramBundle);
    }
  }
  
  private final class a
    implements a.b
  {
    private String dtK;
    
    private a() {}
    
    public final int compareTo(Object paramObject)
    {
      return 0;
    }
    
    public final String getTagName()
    {
      return this.dtK;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSConvTalkerMessageUI
 * JD-Core Version:    0.7.0.1
 */