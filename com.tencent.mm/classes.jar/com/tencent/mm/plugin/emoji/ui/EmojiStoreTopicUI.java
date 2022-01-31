package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.emoji.a.f;
import com.tencent.mm.plugin.emoji.e.g;
import com.tencent.mm.plugin.emoji.e.l;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.e;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.emoji.StoreBannerEmojiView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;

public class EmojiStoreTopicUI
  extends BaseEmojiStoreUI
{
  private int lnD;
  private String lnE;
  private String lnF;
  private String lnG;
  private String lnH;
  private String lnI;
  private int mScene;
  
  protected final void KY(String paramString)
  {
    AppMethodBeat.i(53498);
    if ((this.ljR != null) && (this.ljS != null) && (!bo.isNullOrNil(paramString)))
    {
      com.tencent.mm.cb.a.getDensity(this);
      EmojiInfo localEmojiInfo = EmojiLogic.s("Toptic", 8, paramString);
      if (localEmojiInfo == null)
      {
        o.ahG().a(paramString, null, g.h("Toptic", paramString, new Object[] { "Toptic", "BANNER" }), new EmojiStoreTopicUI.2(this));
        AppMethodBeat.o(53498);
        return;
      }
      this.ljS.setImageFilePath(localEmojiInfo.dQB());
    }
    AppMethodBeat.o(53498);
  }
  
  protected final void a(e parame, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(53500);
    super.a(parame, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(53500);
  }
  
  protected final void a(boolean paramBoolean1, e parame, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(53502);
    super.a(paramBoolean1, parame, paramBoolean2, paramBoolean3);
    AppMethodBeat.o(53502);
  }
  
  protected final void blR()
  {
    AppMethodBeat.i(53495);
    super.blR();
    AppMethodBeat.o(53495);
  }
  
  protected final int blS()
  {
    return 11;
  }
  
  protected final int blT()
  {
    return 14;
  }
  
  protected final com.tencent.mm.plugin.emoji.a.a.a blU()
  {
    AppMethodBeat.i(53503);
    f localf = new f(getContext());
    AppMethodBeat.o(53503);
    return localf;
  }
  
  protected final boolean blY()
  {
    return false;
  }
  
  protected final boolean blZ()
  {
    AppMethodBeat.i(53504);
    if (bo.isNullOrNil(this.lnH))
    {
      AppMethodBeat.o(53504);
      return false;
    }
    AppMethodBeat.o(53504);
    return true;
  }
  
  protected final int bmb()
  {
    return 7;
  }
  
  public final int bmc()
  {
    return this.lnD;
  }
  
  protected final boolean bmi()
  {
    return false;
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(53497);
    this.lnD = getIntent().getIntExtra("topic_id", -1);
    this.lnE = getIntent().getStringExtra("topic_name");
    this.lnH = getIntent().getStringExtra("topic_ad_url");
    this.lnF = getIntent().getStringExtra("topic_icon_url");
    this.lnG = getIntent().getStringExtra("topic_desc");
    this.lnI = getIntent().getStringExtra("sns_object_data");
    this.mScene = getIntent().getIntExtra("extra_scence", 0);
    if (!bo.isNullOrNil(this.lnI))
    {
      this.lnD = EmojiLogic.KL(this.lnI);
      this.lnE = EmojiLogic.KM(this.lnI);
      this.lnF = EmojiLogic.KO(this.lnI);
      this.lnG = EmojiLogic.KN(this.lnI);
      this.lnH = EmojiLogic.KP(this.lnI);
    }
    setMMTitle(this.lnE);
    super.initView();
    addIconOptionMenu(0, 2131231823, new EmojiStoreTopicUI.1(this));
    showOptionMenu(0, false);
    KY(this.lnH);
    AppMethodBeat.o(53497);
  }
  
  public final void n(Message paramMessage)
  {
    AppMethodBeat.i(53505);
    super.n(paramMessage);
    if (paramMessage.what == 1009) {
      KY(this.lnH);
    }
    AppMethodBeat.o(53505);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(53501);
    bmh();
    if ((paramInt1 == 2002) && (paramInt2 == -1))
    {
      String str1 = paramIntent.getStringExtra("Select_Conv_User");
      if (!bo.isNullOrNil(str1))
      {
        ab.d("MicroMsg.emoji.EmojiStoreTopicUI", "..".concat(String.valueOf(str1)));
        int i = this.lnD;
        String str2 = this.lnE;
        String str3 = this.lnG;
        String str4 = this.lnF;
        String str5 = this.lnH;
        i.blp();
        l.a(this, str1, 26, i, str2, str3, str4, str5, 0, "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0");
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(53501);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(53496);
    super.onCreate(paramBundle);
    h.qsU.e(12740, new Object[] { Integer.valueOf(3), "", "", Integer.valueOf(this.lnD), Integer.valueOf(11), Integer.valueOf(11) });
    AppMethodBeat.o(53496);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(53499);
    super.onResume();
    AppMethodBeat.o(53499);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(53506);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramm);
    if (this.ljV)
    {
      showOptionMenu(0, false);
      AppMethodBeat.o(53506);
      return;
    }
    showOptionMenu(0, true);
    AppMethodBeat.o(53506);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreTopicUI
 * JD-Core Version:    0.7.0.1
 */