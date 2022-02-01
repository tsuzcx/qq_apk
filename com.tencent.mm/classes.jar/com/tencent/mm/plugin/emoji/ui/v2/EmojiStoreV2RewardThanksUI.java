package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
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
import com.tencent.mm.ay.a.a;
import com.tencent.mm.ay.a.c.k;
import com.tencent.mm.ay.q;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.i.d;
import com.tencent.mm.plugin.emoji.i.e;
import com.tencent.mm.plugin.emoji.i.f;
import com.tencent.mm.plugin.emoji.i.h;
import com.tencent.mm.plugin.emoji.i.b;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.p;
import com.tencent.mm.plugin.emoji.ui.widget.MMCopiableTextView;
import com.tencent.mm.protocal.protobuf.akg;
import com.tencent.mm.protocal.protobuf.buj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.u;

public class EmojiStoreV2RewardThanksUI
  extends MMActivity
{
  private MMHandler mHandler;
  private String uFv;
  private buj uKD;
  private EmojiStoreV2RewardBannerView uOr;
  private View uOs;
  private MMCopiableTextView uOt;
  private TextView uOu;
  private TextView uOv;
  private AnimationDrawable uOw;
  
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
          if ((!Util.isNullOrNil(paramAnonymousMessage)) && (u.agG(paramAnonymousMessage)))
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
    return i.f.emoji_store_v2_reward_thanks_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109269);
    setMMTitle(i.h.emoji_store_reward_thanks);
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
    this.uOr = ((EmojiStoreV2RewardBannerView)findViewById(i.e.thanks_pic));
    this.uOr.setScale(1.0F);
    this.uOs = findViewById(i.e.magic_word_container);
    this.uOt = ((MMCopiableTextView)findViewById(i.e.magic_word_tip));
    this.uOu = ((TextView)findViewById(i.e.magic_expire));
    this.uOv = ((TextView)findViewById(i.e.magic_word_info));
    this.uOw = ((AnimationDrawable)getResources().getDrawable(i.d.emoji_doge_loading));
    AppMethodBeat.o(109269);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(109267);
    super.onCreate(paramBundle);
    this.uFv = getIntent().getStringExtra("extra_id");
    initView();
    this.uKD = p.getEmojiStorageMgr().VFM.bxU(this.uFv);
    final String str;
    if (this.uKD != null) {
      if ((this.uKD.VIh != null) && (!Util.isNullOrNil(this.uKD.VIh.Svb)))
      {
        paramBundle = this.uKD.VIh.Svc;
        str = EmojiLogic.j(b.bcb(), this.uFv, paramBundle);
        if (u.agG(str))
        {
          this.uOr.setImageFilePath(str);
          this.uOr.setScaleType(ImageView.ScaleType.FIT_XY);
          if ((this.uOw != null) && (this.uOw.isRunning())) {
            this.uOw.stop();
          }
        }
      }
    }
    while ((this.uKD != null) && (this.uKD.VIh != null))
    {
      this.uOs.setVisibility(0);
      Util.isNullOrNil(this.uKD.VIh.Sve);
      this.uOt.setVisibility(0);
      this.uOt.setText(i.h.emoji_store_reward_thanks_msg);
      this.uOu.setVisibility(8);
      this.uOv.setVisibility(8);
      AppMethodBeat.o(109267);
      return;
      q.bml().a(paramBundle, this.uOr, e.l(this.uFv, paramBundle, new Object[0]), new k()
      {
        public final void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
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
      this.uOr.setBackgroundDrawable(getResources().getDrawable(i.d.emotion_reward_banner_bg_color));
      this.uOr.setImageDrawable(this.uOw);
      this.uOr.setScaleType(ImageView.ScaleType.CENTER);
      this.uOw.start();
      continue;
      this.uOr.setBackgroundDrawable(getResources().getDrawable(i.d.emotion_reward_banner_bg_color));
      this.uOr.setImageDrawable(this.uOw);
      this.uOr.setScaleType(ImageView.ScaleType.CENTER);
      this.uOw.start();
      continue;
      this.uOr.setBackgroundDrawable(getResources().getDrawable(i.d.emotion_reward_banner_bg_color));
      this.uOr.setImageDrawable(this.uOw);
      this.uOr.setScaleType(ImageView.ScaleType.CENTER);
      this.uOw.start();
    }
    this.uOs.setVisibility(8);
    AppMethodBeat.o(109267);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109268);
    if ((this.uOw != null) && (this.uOw.isRunning())) {
      this.uOw.stop();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardThanksUI
 * JD-Core Version:    0.7.0.1
 */