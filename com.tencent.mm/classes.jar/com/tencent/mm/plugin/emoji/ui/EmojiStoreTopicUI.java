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
import com.tencent.mm.al.n;
import com.tencent.mm.aw.o;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.e.j;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.emoji.StoreBannerEmojiView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;

public class EmojiStoreTopicUI
  extends BaseEmojiStoreUI
{
  private int mScene;
  private int oDT;
  private String oDU;
  private String oDV;
  private String oDW;
  private String oDX;
  private String oDY;
  
  protected final void Uf(String paramString)
  {
    AppMethodBeat.i(109058);
    if ((this.ozZ != null) && (this.oAa != null) && (!bt.isNullOrNil(paramString)))
    {
      com.tencent.mm.cd.a.getDensity(this);
      EmojiInfo localEmojiInfo = EmojiLogic.x("Toptic", 8, paramString);
      if (localEmojiInfo == null)
      {
        o.ayJ().a(paramString, null, e.h("Toptic", paramString, new Object[] { "Toptic", "BANNER" }), new com.tencent.mm.aw.a.c.k()
        {
          public final void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
          {
            AppMethodBeat.i(109052);
            paramAnonymousString = EmojiStoreTopicUI.this;
            if (paramAnonymousString.oBv != null) {
              paramAnonymousString.oBv.sendEmptyMessage(1009);
            }
            AppMethodBeat.o(109052);
          }
        });
        AppMethodBeat.o(109058);
        return;
      }
      this.oAa.setImageFilePath(localEmojiInfo.gaa());
    }
    AppMethodBeat.o(109058);
  }
  
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
  
  protected final void bVC()
  {
    AppMethodBeat.i(109055);
    super.bVC();
    AppMethodBeat.o(109055);
  }
  
  protected final int bVD()
  {
    return 11;
  }
  
  protected final int bVE()
  {
    return 14;
  }
  
  protected final com.tencent.mm.plugin.emoji.a.a.a bVF()
  {
    AppMethodBeat.i(109063);
    com.tencent.mm.plugin.emoji.a.f localf = new com.tencent.mm.plugin.emoji.a.f(getContext());
    AppMethodBeat.o(109063);
    return localf;
  }
  
  protected final boolean bVJ()
  {
    return false;
  }
  
  protected final boolean bVK()
  {
    AppMethodBeat.i(109064);
    if (bt.isNullOrNil(this.oDX))
    {
      AppMethodBeat.o(109064);
      return false;
    }
    AppMethodBeat.o(109064);
    return true;
  }
  
  protected final int bVM()
  {
    return 7;
  }
  
  public final int bVN()
  {
    return this.oDT;
  }
  
  protected final boolean bVT()
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
    this.oDT = getIntent().getIntExtra("topic_id", -1);
    this.oDU = getIntent().getStringExtra("topic_name");
    this.oDX = getIntent().getStringExtra("topic_ad_url");
    this.oDV = getIntent().getStringExtra("topic_icon_url");
    this.oDW = getIntent().getStringExtra("topic_desc");
    this.oDY = getIntent().getStringExtra("sns_object_data");
    this.mScene = getIntent().getIntExtra("extra_scence", 0);
    if (!bt.isNullOrNil(this.oDY))
    {
      this.oDT = EmojiLogic.TS(this.oDY);
      this.oDU = EmojiLogic.TT(this.oDY);
      this.oDV = EmojiLogic.TV(this.oDY);
      this.oDW = EmojiLogic.TU(this.oDY);
      this.oDX = EmojiLogic.TW(this.oDY);
    }
    setMMTitle(this.oDU);
    super.initView();
    addIconOptionMenu(0, 2131690655, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(109051);
        ad.d("MicroMsg.emoji.EmojiStoreTopicUI", "on shard click.");
        if ((!bt.isNullOrNil(EmojiStoreTopicUI.a(EmojiStoreTopicUI.this))) && (!bt.isNullOrNil(EmojiStoreTopicUI.b(EmojiStoreTopicUI.this)))) {
          EmojiStoreTopicUI.c(EmojiStoreTopicUI.this);
        }
        for (;;)
        {
          AppMethodBeat.o(109051);
          return true;
          ad.i("MicroMsg.emoji.EmojiStoreTopicUI", "name or url is null.");
        }
      }
    });
    showOptionMenu(0, false);
    Uf(this.oDX);
    AppMethodBeat.o(109057);
  }
  
  public final void m(Message paramMessage)
  {
    AppMethodBeat.i(109065);
    super.m(paramMessage);
    if (paramMessage.what == 1009) {
      Uf(this.oDX);
    }
    AppMethodBeat.o(109065);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109061);
    bVS();
    if ((paramInt1 == 2002) && (paramInt2 == -1))
    {
      String str1 = paramIntent.getStringExtra("Select_Conv_User");
      if (!bt.isNullOrNil(str1))
      {
        ad.d("MicroMsg.emoji.EmojiStoreTopicUI", "..".concat(String.valueOf(str1)));
        int i = this.oDT;
        String str2 = this.oDU;
        String str3 = this.oDW;
        String str4 = this.oDV;
        String str5 = this.oDX;
        com.tencent.mm.plugin.emoji.model.k.bUZ();
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
    h.vKh.f(12740, new Object[] { Integer.valueOf(3), "", "", Integer.valueOf(this.oDT), Integer.valueOf(11), Integer.valueOf(11) });
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
    if (this.oAd)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreTopicUI
 * JD-Core Version:    0.7.0.1
 */