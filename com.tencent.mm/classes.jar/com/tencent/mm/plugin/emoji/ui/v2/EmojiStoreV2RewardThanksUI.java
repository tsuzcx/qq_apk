package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.ui.widget.MMCopiableTextView;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.mm.protocal.protobuf.aee;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.i;

public class EmojiStoreV2RewardThanksUI
  extends MMActivity
{
  private ao mHandler;
  private String pbJ;
  private GetEmotionRewardResponse pgo;
  private EmojiStoreV2RewardBannerView pkb;
  private View pkc;
  private MMCopiableTextView pkd;
  private TextView pke;
  private TextView pkf;
  private AnimationDrawable pkg;
  
  public EmojiStoreV2RewardThanksUI()
  {
    AppMethodBeat.i(109266);
    this.mHandler = new ao()
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
          if ((!bs.isNullOrNil(paramAnonymousMessage)) && (i.eA(paramAnonymousMessage)))
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
            ac.i("MicroMsg.emoji.EmojiStoreV2RewardThanksUI", "path is null or file no exists");
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
    return 2131493821;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109269);
    setMMTitle(2131758369);
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
    this.pkb = ((EmojiStoreV2RewardBannerView)findViewById(2131305764));
    this.pkb.setScale(1.0F);
    this.pkc = findViewById(2131301970);
    this.pkd = ((MMCopiableTextView)findViewById(2131301972));
    this.pke = ((TextView)findViewById(2131301969));
    this.pkf = ((TextView)findViewById(2131301971));
    this.pkg = ((AnimationDrawable)getResources().getDrawable(2131232019));
    AppMethodBeat.o(109269);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109267);
    super.onCreate(paramBundle);
    this.pbJ = getIntent().getStringExtra("extra_id");
    initView();
    this.pgo = k.getEmojiStorageMgr().GYe.aPd(this.pbJ);
    Object localObject;
    if (this.pgo != null) {
      if ((this.pgo.Reward != null) && (!bs.isNullOrNil(this.pgo.Reward.EwU)))
      {
        paramBundle = this.pgo.Reward.EwV;
        localObject = com.tencent.mm.emoji.d.a.fWM;
        localObject = EmojiLogic.j(com.tencent.mm.emoji.d.a.adJ(), this.pbJ, paramBundle);
        if (i.eA((String)localObject))
        {
          this.pkb.setImageFilePath((String)localObject);
          this.pkb.setScaleType(ImageView.ScaleType.FIT_XY);
          if ((this.pkg != null) && (this.pkg.isRunning())) {
            this.pkg.stop();
          }
        }
      }
    }
    while ((this.pgo != null) && (this.pgo.Reward != null))
    {
      this.pkc.setVisibility(0);
      bs.isNullOrNil(this.pgo.Reward.EwX);
      this.pkd.setVisibility(0);
      this.pkd.setText(2131758370);
      this.pke.setVisibility(8);
      this.pkf.setVisibility(8);
      AppMethodBeat.o(109267);
      return;
      com.tencent.mm.av.o.aFB().a(paramBundle, this.pkb, e.j(this.pbJ, paramBundle, new Object[0]), new EmojiStoreV2RewardThanksUI.3(this, paramBundle, (String)localObject));
      this.pkb.setBackgroundDrawable(getResources().getDrawable(2131232083));
      this.pkb.setImageDrawable(this.pkg);
      this.pkb.setScaleType(ImageView.ScaleType.CENTER);
      this.pkg.start();
      continue;
      this.pkb.setBackgroundDrawable(getResources().getDrawable(2131232083));
      this.pkb.setImageDrawable(this.pkg);
      this.pkb.setScaleType(ImageView.ScaleType.CENTER);
      this.pkg.start();
      continue;
      this.pkb.setBackgroundDrawable(getResources().getDrawable(2131232083));
      this.pkb.setImageDrawable(this.pkg);
      this.pkb.setScaleType(ImageView.ScaleType.CENTER);
      this.pkg.start();
    }
    this.pkc.setVisibility(8);
    AppMethodBeat.o(109267);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109268);
    if ((this.pkg != null) && (this.pkg.isRunning())) {
      this.pkg.stop();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardThanksUI
 * JD-Core Version:    0.7.0.1
 */