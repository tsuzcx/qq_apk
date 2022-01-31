package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.ah.m;
import com.tencent.mm.as.o;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.e.j;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.emoji.StoreBannerEmojiView;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

public class EmojiStoreTopicUI
  extends BaseEmojiStoreUI
{
  private int fzn;
  private int jeN;
  private String jeO;
  private String jeP;
  private String jeQ;
  private String jeR;
  private String jeS;
  
  protected final void AW(String paramString)
  {
    EmojiInfo localEmojiInfo;
    if ((this.jbi != null) && (this.jbj != null) && (!bk.bl(paramString)))
    {
      com.tencent.mm.cb.a.getDensity(this);
      localEmojiInfo = EmojiLogic.t("Toptic", 8, paramString);
      if (localEmojiInfo == null) {
        o.ON().a(paramString, null, e.h("Toptic", paramString, new Object[] { "Toptic", "BANNER" }), new EmojiStoreTopicUI.2(this));
      }
    }
    else
    {
      return;
    }
    this.jbj.setImageFilePath(localEmojiInfo.cwL());
  }
  
  protected final void a(com.tencent.mm.plugin.emoji.model.f paramf, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramf, paramBoolean1, paramBoolean2);
  }
  
  protected final void a(boolean paramBoolean1, com.tencent.mm.plugin.emoji.model.f paramf, boolean paramBoolean2, boolean paramBoolean3)
  {
    super.a(paramBoolean1, paramf, paramBoolean2, paramBoolean3);
  }
  
  protected final boolean aIB()
  {
    return false;
  }
  
  protected final boolean aIC()
  {
    return !bk.bl(this.jeR);
  }
  
  protected final int aIE()
  {
    return 7;
  }
  
  public final int aIF()
  {
    return this.jeN;
  }
  
  protected final boolean aIK()
  {
    return false;
  }
  
  protected final void aIu()
  {
    super.aIu();
  }
  
  protected final int aIv()
  {
    return 11;
  }
  
  protected final int aIw()
  {
    return 14;
  }
  
  protected final com.tencent.mm.plugin.emoji.a.a.a aIx()
  {
    return new com.tencent.mm.plugin.emoji.a.f(this.mController.uMN);
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  public final void i(Message paramMessage)
  {
    super.i(paramMessage);
    if (paramMessage.what == 1009) {
      AW(this.jeR);
    }
  }
  
  protected final void initView()
  {
    this.jeN = getIntent().getIntExtra("topic_id", -1);
    this.jeO = getIntent().getStringExtra("topic_name");
    this.jeR = getIntent().getStringExtra("topic_ad_url");
    this.jeP = getIntent().getStringExtra("topic_icon_url");
    this.jeQ = getIntent().getStringExtra("topic_desc");
    this.jeS = getIntent().getStringExtra("sns_object_data");
    this.fzn = getIntent().getIntExtra("extra_scence", 0);
    if (!bk.bl(this.jeS))
    {
      this.jeN = EmojiLogic.AJ(this.jeS);
      this.jeO = EmojiLogic.AK(this.jeS);
      this.jeP = EmojiLogic.AM(this.jeS);
      this.jeQ = EmojiLogic.AL(this.jeS);
      this.jeR = EmojiLogic.AN(this.jeS);
    }
    setMMTitle(this.jeO);
    super.initView();
    addIconOptionMenu(0, f.g.ofm_send_icon, new EmojiStoreTopicUI.1(this));
    showOptionMenu(0, false);
    AW(this.jeR);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    aIJ();
    if ((paramInt1 == 2002) && (paramInt2 == -1))
    {
      String str1 = paramIntent.getStringExtra("Select_Conv_User");
      if (!bk.bl(str1))
      {
        y.d("MicroMsg.emoji.EmojiStoreTopicUI", ".." + str1);
        int i = this.jeN;
        String str2 = this.jeO;
        String str3 = this.jeQ;
        String str4 = this.jeP;
        String str5 = this.jeR;
        i.aHP();
        j.a(this, str1, 26, i, str2, str3, str4, str5, 0, "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0");
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    h.nFQ.f(12740, new Object[] { Integer.valueOf(3), "", "", Integer.valueOf(this.jeN), Integer.valueOf(11), Integer.valueOf(11) });
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramm);
    if (this.jbm)
    {
      showOptionMenu(0, false);
      return;
    }
    showOptionMenu(0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreTopicUI
 * JD-Core Version:    0.7.0.1
 */