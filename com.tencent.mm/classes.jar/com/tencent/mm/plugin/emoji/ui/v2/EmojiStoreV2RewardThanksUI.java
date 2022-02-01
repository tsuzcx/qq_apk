package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.a;
import com.tencent.mm.modelimage.loader.b.k;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.emoji.g.d;
import com.tencent.mm.plugin.emoji.h.d;
import com.tencent.mm.plugin.emoji.h.e;
import com.tencent.mm.plugin.emoji.h.f;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.plugin.emoji.mgr.e;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.s;
import com.tencent.mm.plugin.emoji.ui.widget.MMCopiableTextView;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.goi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.y;

public class EmojiStoreV2RewardThanksUI
  extends MMActivity
{
  private MMHandler mHandler;
  private String xNX;
  private goi xSZ;
  private EmojiStoreV2RewardBannerView xXb;
  private View xXc;
  private MMCopiableTextView xXd;
  private TextView xXe;
  private TextView xXf;
  private AnimationDrawable xXg;
  
  public EmojiStoreV2RewardThanksUI()
  {
    AppMethodBeat.i(109266);
    this.mHandler = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(109263);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(109263);
          return;
          paramAnonymousMessage = (String)paramAnonymousMessage.obj;
          if ((!Util.isNullOrNil(paramAnonymousMessage)) && (y.ZC(paramAnonymousMessage)))
          {
            EmojiStoreV2RewardThanksUI.a(EmojiStoreV2RewardThanksUI.this).setImageFilePath(paramAnonymousMessage);
            EmojiStoreV2RewardThanksUI.a(EmojiStoreV2RewardThanksUI.this).setScaleType(ImageView.ScaleType.FIT_XY);
            if ((EmojiStoreV2RewardThanksUI.b(EmojiStoreV2RewardThanksUI.this) != null) && (EmojiStoreV2RewardThanksUI.b(EmojiStoreV2RewardThanksUI.this).isRunning()))
            {
              EmojiStoreV2RewardThanksUI.b(EmojiStoreV2RewardThanksUI.this).stop();
              AppMethodBeat.o(109263);
            }
          }
          else
          {
            Log.i("MicroMsg.emoji.EmojiStoreV2RewardThanksUI", "path is null or file no exists");
          }
        }
      }
    };
    AppMethodBeat.o(109266);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return h.f.emoji_store_v2_reward_thanks_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109269);
    setMMTitle(h.h.emoji_store_reward_thanks);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(109264);
        EmojiStoreV2RewardThanksUI.this.finish();
        AppMethodBeat.o(109264);
        return false;
      }
    });
    this.xXb = ((EmojiStoreV2RewardBannerView)findViewById(h.e.thanks_pic));
    this.xXb.setScale(1.0F);
    this.xXc = findViewById(h.e.magic_word_container);
    this.xXd = ((MMCopiableTextView)findViewById(h.e.magic_word_tip));
    this.xXe = ((TextView)findViewById(h.e.magic_expire));
    this.xXf = ((TextView)findViewById(h.e.magic_word_info));
    this.xXg = ((AnimationDrawable)getResources().getDrawable(h.d.emoji_doge_loading));
    AppMethodBeat.o(109269);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(109267);
    super.onCreate(paramBundle);
    this.xNX = getIntent().getStringExtra("extra_id");
    initView();
    this.xSZ = s.getEmojiStorageMgr().adjA.bzk(this.xNX);
    final String str;
    if (this.xSZ != null) {
      if ((this.xSZ.aklh != null) && (!Util.isNullOrNil(this.xSZ.aklh.ZuT)))
      {
        paramBundle = this.xSZ.aklh.ZuU;
        str = EmojiLogic.o(d.bzQ(), this.xNX, paramBundle);
        if (y.ZC(str))
        {
          this.xXb.setImageFilePath(str);
          this.xXb.setScaleType(ImageView.ScaleType.FIT_XY);
          if ((this.xXg != null) && (this.xXg.isRunning())) {
            this.xXg.stop();
          }
        }
      }
    }
    while ((this.xSZ != null) && (this.xSZ.aklh != null))
    {
      this.xXc.setVisibility(0);
      Util.isNullOrNil(this.xSZ.aklh.ZuW);
      this.xXd.setVisibility(0);
      this.xXd.setText(h.h.emoji_store_reward_thanks_msg);
      this.xXe.setVisibility(8);
      this.xXf.setVisibility(8);
      AppMethodBeat.o(109267);
      return;
      r.bKe().a(paramBundle, this.xXb, e.m(this.xNX, paramBundle, new Object[0]), new k()
      {
        public final void onImageLoadComplete(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(109265);
          if ((!Util.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equalsIgnoreCase(paramBundle)))
          {
            paramAnonymousString = new Message();
            paramAnonymousString.what = 1001;
            paramAnonymousString.obj = str;
            EmojiStoreV2RewardThanksUI.c(EmojiStoreV2RewardThanksUI.this).sendMessage(paramAnonymousString);
          }
          AppMethodBeat.o(109265);
        }
      });
      this.xXb.setBackgroundDrawable(getResources().getDrawable(h.d.emotion_reward_banner_bg_color));
      this.xXb.setImageDrawable(this.xXg);
      this.xXb.setScaleType(ImageView.ScaleType.CENTER);
      this.xXg.start();
      continue;
      this.xXb.setBackgroundDrawable(getResources().getDrawable(h.d.emotion_reward_banner_bg_color));
      this.xXb.setImageDrawable(this.xXg);
      this.xXb.setScaleType(ImageView.ScaleType.CENTER);
      this.xXg.start();
      continue;
      this.xXb.setBackgroundDrawable(getResources().getDrawable(h.d.emotion_reward_banner_bg_color));
      this.xXb.setImageDrawable(this.xXg);
      this.xXb.setScaleType(ImageView.ScaleType.CENTER);
      this.xXg.start();
    }
    this.xXc.setVisibility(8);
    AppMethodBeat.o(109267);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109268);
    if ((this.xXg != null) && (this.xXg.isRunning())) {
      this.xXg.stop();
    }
    super.onDestroy();
    AppMethodBeat.o(109268);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardThanksUI
 * JD-Core Version:    0.7.0.1
 */