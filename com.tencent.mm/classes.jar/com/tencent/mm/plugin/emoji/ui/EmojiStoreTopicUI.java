package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.c.k;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.e.j;
import com.tencent.mm.plugin.emoji.i.a;
import com.tencent.mm.plugin.emoji.i.g;
import com.tencent.mm.plugin.emoji.i.h;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.l;
import com.tencent.mm.plugin.emoji.model.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.emoji.StoreBannerEmojiView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;

public class EmojiStoreTopicUI
  extends BaseEmojiStoreUI
{
  private int mScene;
  private int uLI;
  private String uLJ;
  private String uLK;
  private String uLL;
  private String uLM;
  private String uLN;
  
  protected final void a(l paraml, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(109060);
    super.a(paraml, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(109060);
  }
  
  protected final void a(boolean paramBoolean1, l paraml, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(109062);
    cVH();
    super.a(paramBoolean1, paraml, paramBoolean2, paramBoolean3);
    AppMethodBeat.o(109062);
  }
  
  protected final void auP(String paramString)
  {
    AppMethodBeat.i(109058);
    if ((this.uHe != null) && (this.uHf != null) && (!Util.isNullOrNil(paramString)))
    {
      com.tencent.mm.ci.a.getDensity(this);
      EmojiInfo localEmojiInfo = EmojiLogic.I("Toptic", 8, paramString);
      if (localEmojiInfo == null)
      {
        com.tencent.mm.ay.q.bml().a(paramString, null, e.k("Toptic", paramString, new Object[] { "Toptic", "BANNER" }), new k()
        {
          public final void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
          {
            AppMethodBeat.i(109052);
            paramAnonymousString = EmojiStoreTopicUI.this;
            if (paramAnonymousString.uIJ != null) {
              paramAnonymousString.uIJ.sendEmptyMessage(1009);
            }
            AppMethodBeat.o(109052);
          }
        });
        AppMethodBeat.o(109058);
        return;
      }
      this.uHf.setImageFilePath(localEmojiInfo.ifh());
    }
    AppMethodBeat.o(109058);
  }
  
  protected final int cVA()
  {
    return 7;
  }
  
  public final int cVB()
  {
    return this.uLI;
  }
  
  protected final boolean cVJ()
  {
    return false;
  }
  
  protected final void cVq()
  {
    AppMethodBeat.i(109055);
    super.cVq();
    AppMethodBeat.o(109055);
  }
  
  protected final int cVr()
  {
    return 11;
  }
  
  protected final int cVs()
  {
    return 14;
  }
  
  protected final com.tencent.mm.plugin.emoji.a.a.a cVt()
  {
    AppMethodBeat.i(109063);
    com.tencent.mm.plugin.emoji.a.f localf = new com.tencent.mm.plugin.emoji.a.f(getContext());
    AppMethodBeat.o(109063);
    return localf;
  }
  
  protected final boolean cVx()
  {
    return false;
  }
  
  protected final boolean cVy()
  {
    AppMethodBeat.i(109064);
    if (Util.isNullOrNil(this.uLM))
    {
      AppMethodBeat.o(109064);
      return false;
    }
    AppMethodBeat.o(109064);
    return true;
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109057);
    this.uLI = getIntent().getIntExtra("topic_id", -1);
    this.uLJ = getIntent().getStringExtra("topic_name");
    this.uLM = getIntent().getStringExtra("topic_ad_url");
    this.uLK = getIntent().getStringExtra("topic_icon_url");
    this.uLL = getIntent().getStringExtra("topic_desc");
    this.uLN = getIntent().getStringExtra("sns_object_data");
    this.mScene = getIntent().getIntExtra("extra_scence", 0);
    if (!Util.isNullOrNil(this.uLN))
    {
      this.uLI = EmojiLogic.auC(this.uLN);
      this.uLJ = EmojiLogic.auD(this.uLN);
      this.uLK = EmojiLogic.auF(this.uLN);
      this.uLL = EmojiLogic.auE(this.uLN);
      this.uLM = EmojiLogic.auG(this.uLN);
    }
    setMMTitle(this.uLJ);
    super.initView();
    addIconOptionMenu(0, i.g.icons_outlined_share, new MenuItem.OnMenuItemClickListener()
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
    auP(this.uLM);
    AppMethodBeat.o(109057);
  }
  
  public final void k(Message paramMessage)
  {
    AppMethodBeat.i(109065);
    super.k(paramMessage);
    if (paramMessage.what == 1009) {
      auP(this.uLM);
    }
    AppMethodBeat.o(109065);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109061);
    cVG();
    if ((paramInt1 == 2002) && (paramInt2 == -1))
    {
      String str1 = paramIntent.getStringExtra("Select_Conv_User");
      if (!Util.isNullOrNil(str1))
      {
        Log.d("MicroMsg.emoji.EmojiStoreTopicUI", "..".concat(String.valueOf(str1)));
        int i = this.uLI;
        String str2 = this.uLJ;
        String str3 = this.uLL;
        String str4 = this.uLK;
        String str5 = this.uLM;
        p.cUO();
        j.a(this, str1, 26, i, str2, str3, str4, str5, 0, com.tencent.mm.plugin.emoji.e.f.cUn());
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(109061);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109056);
    super.onCreate(paramBundle);
    h.IzE.a(12740, new Object[] { Integer.valueOf(3), "", "", Integer.valueOf(this.uLI), Integer.valueOf(11), Integer.valueOf(11) });
    AppMethodBeat.o(109056);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109059);
    super.onResume();
    AppMethodBeat.o(109059);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(109066);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
    if (this.uHi)
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