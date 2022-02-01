package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.e.j;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.emoji.StoreBannerEmojiView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;

public class EmojiStoreTopicUI
  extends BaseEmojiStoreUI
{
  private int mScene;
  private int pRA;
  private String pRB;
  private String pRC;
  private String pRD;
  private String pRE;
  private String pRF;
  
  protected final void a(com.tencent.mm.plugin.emoji.model.f paramf, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(109060);
    super.a(paramf, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(109060);
  }
  
  protected final void a(boolean paramBoolean1, com.tencent.mm.plugin.emoji.model.f paramf, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(109062);
    super.a(paramBoolean1, paramf, paramBoolean2, paramBoolean3);
    AppMethodBeat.o(109062);
  }
  
  protected final void acO(String paramString)
  {
    AppMethodBeat.i(109058);
    if ((this.pNF != null) && (this.pNG != null) && (!bu.isNullOrNil(paramString)))
    {
      com.tencent.mm.cb.a.getDensity(this);
      EmojiInfo localEmojiInfo = EmojiLogic.A("Toptic", 8, paramString);
      if (localEmojiInfo == null)
      {
        q.aJb().a(paramString, null, e.h("Toptic", paramString, new Object[] { "Toptic", "BANNER" }), new com.tencent.mm.av.a.c.k()
        {
          public final void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
          {
            AppMethodBeat.i(109052);
            paramAnonymousString = EmojiStoreTopicUI.this;
            if (paramAnonymousString.pPc != null) {
              paramAnonymousString.pPc.sendEmptyMessage(1009);
            }
            AppMethodBeat.o(109052);
          }
        });
        AppMethodBeat.o(109058);
        return;
      }
      this.pNG.setImageFilePath(localEmojiInfo.fSQ());
    }
    AppMethodBeat.o(109058);
  }
  
  protected final void ciI()
  {
    AppMethodBeat.i(109055);
    super.ciI();
    AppMethodBeat.o(109055);
  }
  
  protected final int ciJ()
  {
    return 11;
  }
  
  protected final int ciK()
  {
    return 14;
  }
  
  protected final com.tencent.mm.plugin.emoji.a.a.a ciL()
  {
    AppMethodBeat.i(109063);
    com.tencent.mm.plugin.emoji.a.f localf = new com.tencent.mm.plugin.emoji.a.f(getContext());
    AppMethodBeat.o(109063);
    return localf;
  }
  
  protected final boolean ciP()
  {
    return false;
  }
  
  protected final boolean ciQ()
  {
    AppMethodBeat.i(109064);
    if (bu.isNullOrNil(this.pRE))
    {
      AppMethodBeat.o(109064);
      return false;
    }
    AppMethodBeat.o(109064);
    return true;
  }
  
  protected final int ciS()
  {
    return 7;
  }
  
  public final int ciT()
  {
    return this.pRA;
  }
  
  protected final boolean ciZ()
  {
    return false;
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109057);
    this.pRA = getIntent().getIntExtra("topic_id", -1);
    this.pRB = getIntent().getStringExtra("topic_name");
    this.pRE = getIntent().getStringExtra("topic_ad_url");
    this.pRC = getIntent().getStringExtra("topic_icon_url");
    this.pRD = getIntent().getStringExtra("topic_desc");
    this.pRF = getIntent().getStringExtra("sns_object_data");
    this.mScene = getIntent().getIntExtra("extra_scence", 0);
    if (!bu.isNullOrNil(this.pRF))
    {
      this.pRA = EmojiLogic.acB(this.pRF);
      this.pRB = EmojiLogic.acC(this.pRF);
      this.pRC = EmojiLogic.acE(this.pRF);
      this.pRD = EmojiLogic.acD(this.pRF);
      this.pRE = EmojiLogic.acF(this.pRF);
    }
    setMMTitle(this.pRB);
    super.initView();
    addIconOptionMenu(0, 2131690655, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(109051);
        ae.d("MicroMsg.emoji.EmojiStoreTopicUI", "on shard click.");
        if ((!bu.isNullOrNil(EmojiStoreTopicUI.a(EmojiStoreTopicUI.this))) && (!bu.isNullOrNil(EmojiStoreTopicUI.b(EmojiStoreTopicUI.this)))) {
          EmojiStoreTopicUI.c(EmojiStoreTopicUI.this);
        }
        for (;;)
        {
          AppMethodBeat.o(109051);
          return true;
          ae.i("MicroMsg.emoji.EmojiStoreTopicUI", "name or url is null.");
        }
      }
    });
    showOptionMenu(0, false);
    acO(this.pRE);
    AppMethodBeat.o(109057);
  }
  
  public final void m(Message paramMessage)
  {
    AppMethodBeat.i(109065);
    super.m(paramMessage);
    if (paramMessage.what == 1009) {
      acO(this.pRE);
    }
    AppMethodBeat.o(109065);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109061);
    ciY();
    if ((paramInt1 == 2002) && (paramInt2 == -1))
    {
      String str1 = paramIntent.getStringExtra("Select_Conv_User");
      if (!bu.isNullOrNil(str1))
      {
        ae.d("MicroMsg.emoji.EmojiStoreTopicUI", "..".concat(String.valueOf(str1)));
        int i = this.pRA;
        String str2 = this.pRB;
        String str3 = this.pRD;
        String str4 = this.pRC;
        String str5 = this.pRE;
        com.tencent.mm.plugin.emoji.model.k.cig();
        j.a(this, str1, 26, i, str2, str3, str4, str5, 0, "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0");
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(109061);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109056);
    super.onCreate(paramBundle);
    g.yxI.f(12740, new Object[] { Integer.valueOf(3), "", "", Integer.valueOf(this.pRA), Integer.valueOf(11), Integer.valueOf(11) });
    AppMethodBeat.o(109056);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109059);
    super.onResume();
    AppMethodBeat.o(109059);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(109066);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
    if (this.pNJ)
    {
      showOptionMenu(0, false);
      AppMethodBeat.o(109066);
      return;
    }
    showOptionMenu(0, true);
    AppMethodBeat.o(109066);
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