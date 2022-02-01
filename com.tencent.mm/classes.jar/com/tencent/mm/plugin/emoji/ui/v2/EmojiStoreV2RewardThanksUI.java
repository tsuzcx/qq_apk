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
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.ui.widget.MMCopiableTextView;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.mm.protocal.protobuf.ajg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.s;

public class EmojiStoreV2RewardThanksUI
  extends MMActivity
{
  private MMHandler mHandler;
  private String rcq;
  private GetEmotionRewardResponse rhu;
  private EmojiStoreV2RewardBannerView rlf;
  private View rlg;
  private MMCopiableTextView rlh;
  private TextView rli;
  private TextView rlj;
  private AnimationDrawable rlk;
  
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
          if ((!Util.isNullOrNil(paramAnonymousMessage)) && (s.YS(paramAnonymousMessage)))
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
    return 2131493975;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109269);
    setMMTitle(2131758663);
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
    this.rlf = ((EmojiStoreV2RewardBannerView)findViewById(2131309035));
    this.rlf.setScale(1.0F);
    this.rlg = findViewById(2131304305);
    this.rlh = ((MMCopiableTextView)findViewById(2131304307));
    this.rli = ((TextView)findViewById(2131304304));
    this.rlj = ((TextView)findViewById(2131304306));
    this.rlk = ((AnimationDrawable)getResources().getDrawable(2131232110));
    AppMethodBeat.o(109269);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(109267);
    super.onCreate(paramBundle);
    this.rcq = getIntent().getStringExtra("extra_id");
    initView();
    this.rhu = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpS.blu(this.rcq);
    Object localObject;
    if (this.rhu != null) {
      if ((this.rhu.Reward != null) && (!Util.isNullOrNil(this.rhu.Reward.LsL)))
      {
        paramBundle = this.rhu.Reward.LsM;
        localObject = com.tencent.mm.emoji.e.a.hdT;
        localObject = EmojiLogic.j(com.tencent.mm.emoji.e.a.awt(), this.rcq, paramBundle);
        if (s.YS((String)localObject))
        {
          this.rlf.setImageFilePath((String)localObject);
          this.rlf.setScaleType(ImageView.ScaleType.FIT_XY);
          if ((this.rlk != null) && (this.rlk.isRunning())) {
            this.rlk.stop();
          }
        }
      }
    }
    while ((this.rhu != null) && (this.rhu.Reward != null))
    {
      this.rlg.setVisibility(0);
      Util.isNullOrNil(this.rhu.Reward.LsO);
      this.rlh.setVisibility(0);
      this.rlh.setText(2131758664);
      this.rli.setVisibility(8);
      this.rlj.setVisibility(8);
      AppMethodBeat.o(109267);
      return;
      q.bcV().a(paramBundle, this.rlf, e.k(this.rcq, paramBundle, new Object[0]), new com.tencent.mm.av.a.c.k()
      {
        public final void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(109265);
          if ((!Util.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equalsIgnoreCase(paramBundle)))
          {
            paramAnonymousString = new Message();
            paramAnonymousString.what = 1001;
            paramAnonymousString.obj = this.val$path;
            EmojiStoreV2RewardThanksUI.c(EmojiStoreV2RewardThanksUI.this).sendMessage(paramAnonymousString);
          }
          AppMethodBeat.o(109265);
        }
      });
      this.rlf.setBackgroundDrawable(getResources().getDrawable(2131232175));
      this.rlf.setImageDrawable(this.rlk);
      this.rlf.setScaleType(ImageView.ScaleType.CENTER);
      this.rlk.start();
      continue;
      this.rlf.setBackgroundDrawable(getResources().getDrawable(2131232175));
      this.rlf.setImageDrawable(this.rlk);
      this.rlf.setScaleType(ImageView.ScaleType.CENTER);
      this.rlk.start();
      continue;
      this.rlf.setBackgroundDrawable(getResources().getDrawable(2131232175));
      this.rlf.setImageDrawable(this.rlk);
      this.rlf.setScaleType(ImageView.ScaleType.CENTER);
      this.rlk.start();
    }
    this.rlg.setVisibility(8);
    AppMethodBeat.o(109267);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109268);
    if ((this.rlk != null) && (this.rlk.isRunning())) {
      this.rlk.stop();
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