package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.modelimage.loader.b.k;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.emoji.h.a;
import com.tencent.mm.plugin.emoji.h.g;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.plugin.emoji.mgr.e;
import com.tencent.mm.plugin.emoji.mgr.j;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.emoji.StoreBannerEmojiView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;

public class EmojiStoreTopicUI
  extends BaseEmojiStoreUI
{
  private int mScene;
  private int xUj;
  private String xUk;
  private String xUl;
  private String xUm;
  private String xUn;
  private String xUo;
  
  protected final void a(m paramm, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(109060);
    super.a(paramm, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(109060);
  }
  
  protected final void a(boolean paramBoolean1, m paramm, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(109062);
    dBg();
    super.a(paramBoolean1, paramm, paramBoolean2, paramBoolean3);
    AppMethodBeat.o(109062);
  }
  
  protected final void aoO(String paramString)
  {
    AppMethodBeat.i(109058);
    if ((this.xPK != null) && (this.xPL != null) && (!Util.isNullOrNil(paramString)))
    {
      com.tencent.mm.cd.a.getDensity(this);
      EmojiInfo localEmojiInfo = EmojiLogic.K("Toptic", 8, paramString);
      if (localEmojiInfo == null)
      {
        r.bKe().a(paramString, null, e.l("Toptic", paramString, new Object[] { "Toptic", "BANNER" }), new k()
        {
          public final void onImageLoadComplete(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
          {
            AppMethodBeat.i(109052);
            paramAnonymousString = EmojiStoreTopicUI.this;
            if (paramAnonymousString.xRz != null) {
              paramAnonymousString.xRz.sendEmptyMessage(1009);
            }
            AppMethodBeat.o(109052);
          }
        });
        AppMethodBeat.o(109058);
        return;
      }
      this.xPL.setImageFilePath(localEmojiInfo.kMn());
    }
    AppMethodBeat.o(109058);
  }
  
  protected final void dAQ()
  {
    AppMethodBeat.i(109055);
    super.dAQ();
    AppMethodBeat.o(109055);
  }
  
  protected final int dAR()
  {
    return 11;
  }
  
  protected final int dAS()
  {
    return 14;
  }
  
  protected final com.tencent.mm.plugin.emoji.a.a.a dAT()
  {
    AppMethodBeat.i(109063);
    com.tencent.mm.plugin.emoji.a.f localf = new com.tencent.mm.plugin.emoji.a.f(getContext());
    AppMethodBeat.o(109063);
    return localf;
  }
  
  protected final boolean dAX()
  {
    return false;
  }
  
  protected final boolean dAY()
  {
    AppMethodBeat.i(109064);
    if (Util.isNullOrNil(this.xUn))
    {
      AppMethodBeat.o(109064);
      return false;
    }
    AppMethodBeat.o(109064);
    return true;
  }
  
  protected final int dBa()
  {
    return 7;
  }
  
  public final int dBb()
  {
    return this.xUj;
  }
  
  protected final boolean dBk()
  {
    return false;
  }
  
  protected final boolean dBl()
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
    this.xUj = getIntent().getIntExtra("topic_id", -1);
    this.xUk = getIntent().getStringExtra("topic_name");
    this.xUn = getIntent().getStringExtra("topic_ad_url");
    this.xUl = getIntent().getStringExtra("topic_icon_url");
    this.xUm = getIntent().getStringExtra("topic_desc");
    this.xUo = getIntent().getStringExtra("sns_object_data");
    this.mScene = getIntent().getIntExtra("extra_scence", 0);
    if (!Util.isNullOrNil(this.xUo))
    {
      this.xUj = EmojiLogic.aoB(this.xUo);
      this.xUk = EmojiLogic.aoC(this.xUo);
      this.xUl = EmojiLogic.aoE(this.xUo);
      this.xUm = EmojiLogic.aoD(this.xUo);
      this.xUn = EmojiLogic.aoF(this.xUo);
    }
    setMMTitle(this.xUk);
    super.initView();
    addIconOptionMenu(0, h.g.icons_outlined_share, new MenuItem.OnMenuItemClickListener()
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
    aoO(this.xUn);
    AppMethodBeat.o(109057);
  }
  
  public final void l(Message paramMessage)
  {
    AppMethodBeat.i(109065);
    super.l(paramMessage);
    if (paramMessage.what == 1009) {
      aoO(this.xUn);
    }
    AppMethodBeat.o(109065);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109061);
    dismissLoadingDialog();
    if ((paramInt1 == 2002) && (paramInt2 == -1))
    {
      String str1 = paramIntent.getStringExtra("Select_Conv_User");
      if (!Util.isNullOrNil(str1))
      {
        Log.d("MicroMsg.emoji.EmojiStoreTopicUI", "..".concat(String.valueOf(str1)));
        int i = this.xUj;
        String str2 = this.xUk;
        String str3 = this.xUm;
        String str4 = this.xUl;
        String str5 = this.xUn;
        com.tencent.mm.plugin.emoji.model.s.dAl();
        j.a(this, str1, 26, i, str2, str3, str4, str5, 0, com.tencent.mm.plugin.emoji.mgr.f.dzu());
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(109061);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109056);
    super.onCreate(paramBundle);
    h.OAn.b(12740, new Object[] { Integer.valueOf(3), "", "", Integer.valueOf(this.xUj), Integer.valueOf(11), Integer.valueOf(11) });
    AppMethodBeat.o(109056);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109059);
    super.onResume();
    AppMethodBeat.o(109059);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(109066);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramp);
    if (this.xPO)
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