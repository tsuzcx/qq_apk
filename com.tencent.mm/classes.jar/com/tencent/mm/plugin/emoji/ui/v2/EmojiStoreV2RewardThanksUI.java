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
import com.tencent.mm.as.a.a;
import com.tencent.mm.as.o;
import com.tencent.mm.plugin.emoji.f.d;
import com.tencent.mm.plugin.emoji.f.e;
import com.tencent.mm.plugin.emoji.f.f;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.ui.widget.MMCopiableTextView;
import com.tencent.mm.protocal.c.afk;
import com.tencent.mm.protocal.c.vm;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.l;
import com.tencent.mm.ui.MMActivity;

public class EmojiStoreV2RewardThanksUI
  extends MMActivity
{
  private String iZs;
  private afk jdM;
  private EmojiStoreV2RewardBannerView jhn;
  private View jho;
  private MMCopiableTextView jhp;
  private TextView jhq;
  private TextView jhr;
  private AnimationDrawable jhs;
  private ah mHandler = new EmojiStoreV2RewardThanksUI.1(this);
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return f.f.emoji_store_v2_reward_thanks_ui;
  }
  
  protected final void initView()
  {
    setMMTitle(f.h.emoji_store_reward_thanks);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        EmojiStoreV2RewardThanksUI.this.finish();
        return false;
      }
    });
    this.jhn = ((EmojiStoreV2RewardBannerView)findViewById(f.e.thanks_pic));
    this.jhn.setScale(1.0F);
    this.jho = findViewById(f.e.magic_word_container);
    this.jhp = ((MMCopiableTextView)findViewById(f.e.magic_word_tip));
    this.jhq = ((TextView)findViewById(f.e.magic_expire));
    this.jhr = ((TextView)findViewById(f.e.magic_word_info));
    this.jhs = ((AnimationDrawable)getResources().getDrawable(f.d.emoji_doge_loading));
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.iZs = getIntent().getStringExtra("extra_id");
    initView();
    this.jdM = com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().uBg.acJ(this.iZs);
    final String str;
    if (this.jdM != null) {
      if ((this.jdM.tdo != null) && (!bk.bl(this.jdM.tdo.sSD)))
      {
        paramBundle = this.jdM.tdo.sSE;
        str = EmojiLogic.I(b.FL(), this.iZs, paramBundle);
        if (com.tencent.mm.vfs.e.bK(str))
        {
          this.jhn.setImageFilePath(str);
          this.jhn.setScaleType(ImageView.ScaleType.FIT_XY);
          if ((this.jhs != null) && (this.jhs.isRunning())) {
            this.jhs.stop();
          }
        }
      }
    }
    while ((this.jdM != null) && (this.jdM.tdo != null))
    {
      this.jho.setVisibility(0);
      bk.bl(this.jdM.tdo.sSG);
      this.jhp.setVisibility(0);
      this.jhp.setText(f.h.emoji_store_reward_thanks_msg);
      this.jhq.setVisibility(8);
      this.jhr.setVisibility(8);
      return;
      o.ON().a(paramBundle, this.jhn, com.tencent.mm.plugin.emoji.e.e.j(this.iZs, paramBundle, new Object[0]), new com.tencent.mm.as.a.c.i()
      {
        public final void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
        {
          if ((!bk.bl(paramAnonymousString)) && (paramAnonymousString.equalsIgnoreCase(paramBundle)))
          {
            paramAnonymousString = new Message();
            paramAnonymousString.what = 1001;
            paramAnonymousString.obj = str;
            EmojiStoreV2RewardThanksUI.c(EmojiStoreV2RewardThanksUI.this).sendMessage(paramAnonymousString);
          }
        }
      });
      this.jhn.setBackgroundDrawable(getResources().getDrawable(f.d.emotion_reward_banner_bg_color));
      this.jhn.setImageDrawable(this.jhs);
      this.jhn.setScaleType(ImageView.ScaleType.CENTER);
      this.jhs.start();
      continue;
      this.jhn.setBackgroundDrawable(getResources().getDrawable(f.d.emotion_reward_banner_bg_color));
      this.jhn.setImageDrawable(this.jhs);
      this.jhn.setScaleType(ImageView.ScaleType.CENTER);
      this.jhs.start();
      continue;
      this.jhn.setBackgroundDrawable(getResources().getDrawable(f.d.emotion_reward_banner_bg_color));
      this.jhn.setImageDrawable(this.jhs);
      this.jhn.setScaleType(ImageView.ScaleType.CENTER);
      this.jhs.start();
    }
    this.jho.setVisibility(8);
  }
  
  protected void onDestroy()
  {
    if ((this.jhs != null) && (this.jhs.isRunning())) {
      this.jhs.stop();
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardThanksUI
 * JD-Core Version:    0.7.0.1
 */