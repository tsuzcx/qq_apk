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
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.e.j;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.emoji.StoreBannerEmojiView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;

public class EmojiStoreTopicUI
  extends BaseEmojiStoreUI
{
  private int mScene;
  private int riA;
  private String riB;
  private String riC;
  private String riD;
  private String riE;
  private String riF;
  
  protected final void a(g paramg, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(109060);
    super.a(paramg, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(109060);
  }
  
  protected final void a(boolean paramBoolean1, g paramg, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(109062);
    super.a(paramBoolean1, paramg, paramBoolean2, paramBoolean3);
    AppMethodBeat.o(109062);
  }
  
  protected final void amV(String paramString)
  {
    AppMethodBeat.i(109058);
    if ((this.rdZ != null) && (this.rea != null) && (!Util.isNullOrNil(paramString)))
    {
      com.tencent.mm.cb.a.getDensity(this);
      EmojiInfo localEmojiInfo = EmojiLogic.H("Toptic", 8, paramString);
      if (localEmojiInfo == null)
      {
        com.tencent.mm.av.q.bcV().a(paramString, null, e.j("Toptic", paramString, new Object[] { "Toptic", "BANNER" }), new com.tencent.mm.av.a.c.k()
        {
          public final void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
          {
            AppMethodBeat.i(109052);
            paramAnonymousString = EmojiStoreTopicUI.this;
            if (paramAnonymousString.rfA != null) {
              paramAnonymousString.rfA.sendEmptyMessage(1009);
            }
            AppMethodBeat.o(109052);
          }
        });
        AppMethodBeat.o(109058);
        return;
      }
      this.rea.setImageFilePath(localEmojiInfo.hRM());
    }
    AppMethodBeat.o(109058);
  }
  
  protected final void cGG()
  {
    AppMethodBeat.i(109055);
    super.cGG();
    AppMethodBeat.o(109055);
  }
  
  protected final int cGH()
  {
    return 11;
  }
  
  protected final int cGI()
  {
    return 14;
  }
  
  protected final com.tencent.mm.plugin.emoji.a.a.a cGJ()
  {
    AppMethodBeat.i(109063);
    com.tencent.mm.plugin.emoji.a.f localf = new com.tencent.mm.plugin.emoji.a.f(getContext());
    AppMethodBeat.o(109063);
    return localf;
  }
  
  protected final boolean cGN()
  {
    return false;
  }
  
  protected final boolean cGO()
  {
    AppMethodBeat.i(109064);
    if (Util.isNullOrNil(this.riE))
    {
      AppMethodBeat.o(109064);
      return false;
    }
    AppMethodBeat.o(109064);
    return true;
  }
  
  protected final int cGQ()
  {
    return 7;
  }
  
  public final int cGR()
  {
    return this.riA;
  }
  
  protected final boolean cGX()
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
    this.riA = getIntent().getIntExtra("topic_id", -1);
    this.riB = getIntent().getStringExtra("topic_name");
    this.riE = getIntent().getStringExtra("topic_ad_url");
    this.riC = getIntent().getStringExtra("topic_icon_url");
    this.riD = getIntent().getStringExtra("topic_desc");
    this.riF = getIntent().getStringExtra("sns_object_data");
    this.mScene = getIntent().getIntExtra("extra_scence", 0);
    if (!Util.isNullOrNil(this.riF))
    {
      this.riA = EmojiLogic.amI(this.riF);
      this.riB = EmojiLogic.amJ(this.riF);
      this.riC = EmojiLogic.amL(this.riF);
      this.riD = EmojiLogic.amK(this.riF);
      this.riE = EmojiLogic.amM(this.riF);
    }
    setMMTitle(this.riB);
    super.initView();
    addIconOptionMenu(0, 2131690907, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(109051);
        Log.d("MicroMsg.emoji.EmojiStoreTopicUI", "on shard click.");
        if ((!Util.isNullOrNil(EmojiStoreTopicUI.a(EmojiStoreTopicUI.this))) && (!Util.isNullOrNil(EmojiStoreTopicUI.b(EmojiStoreTopicUI.this)))) {
          EmojiStoreTopicUI.c(EmojiStoreTopicUI.this);
        }
        for (;;)
        {
          AppMethodBeat.o(109051);
          return true;
          Log.i("MicroMsg.emoji.EmojiStoreTopicUI", "name or url is null.");
        }
      }
    });
    showOptionMenu(0, false);
    amV(this.riE);
    AppMethodBeat.o(109057);
  }
  
  public final void k(Message paramMessage)
  {
    AppMethodBeat.i(109065);
    super.k(paramMessage);
    if (paramMessage.what == 1009) {
      amV(this.riE);
    }
    AppMethodBeat.o(109065);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109061);
    cGW();
    if ((paramInt1 == 2002) && (paramInt2 == -1))
    {
      String str1 = paramIntent.getStringExtra("Select_Conv_User");
      if (!Util.isNullOrNil(str1))
      {
        Log.d("MicroMsg.emoji.EmojiStoreTopicUI", "..".concat(String.valueOf(str1)));
        int i = this.riA;
        String str2 = this.riB;
        String str3 = this.riD;
        String str4 = this.riC;
        String str5 = this.riE;
        com.tencent.mm.plugin.emoji.model.k.cGf();
        j.a(this, str1, 26, i, str2, str3, str4, str5, 0, com.tencent.mm.plugin.emoji.e.f.cFI());
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(109061);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109056);
    super.onCreate(paramBundle);
    h.CyF.a(12740, new Object[] { Integer.valueOf(3), "", "", Integer.valueOf(this.riA), Integer.valueOf(11), Integer.valueOf(11) });
    AppMethodBeat.o(109056);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109059);
    super.onResume();
    AppMethodBeat.o(109059);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(109066);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
    if (this.red)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreTopicUI
 * JD-Core Version:    0.7.0.1
 */