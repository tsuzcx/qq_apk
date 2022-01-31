package com.tencent.mm.plugin.emoji.ui.v2;

import android.os.Bundle;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.f;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

public class EmojiStoreV2RankUI
  extends BaseEmojiStoreUI
{
  protected final int aIE()
  {
    return 10;
  }
  
  protected final int aIv()
  {
    return 5;
  }
  
  protected final int aIw()
  {
    return 105;
  }
  
  protected final a aIx()
  {
    return new f(this.mController.uMN);
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final void initView()
  {
    super.initView();
    setMMTitle(f.h.emoji_store_new_suggest);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    h.nFQ.f(12740, new Object[] { Integer.valueOf(4), "", "", "", Integer.valueOf(5), Integer.valueOf(5) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RankUI
 * JD-Core Version:    0.7.0.1
 */