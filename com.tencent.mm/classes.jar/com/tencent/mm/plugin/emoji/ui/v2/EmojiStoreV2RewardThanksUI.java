package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.emoji.e.g;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.ui.widget.MMCopiableTextView;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.mm.protocal.protobuf.zr;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.l;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.e;

public class EmojiStoreV2RewardThanksUI
  extends MMActivity
{
  private String lig;
  private GetEmotionRewardResponse lmz;
  private EmojiStoreV2RewardBannerView lqh;
  private View lqi;
  private MMCopiableTextView lqj;
  private TextView lqk;
  private TextView lql;
  private AnimationDrawable lqm;
  private ak mHandler;
  
  public EmojiStoreV2RewardThanksUI()
  {
    AppMethodBeat.i(53691);
    this.mHandler = new EmojiStoreV2RewardThanksUI.1(this);
    AppMethodBeat.o(53691);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130969409;
  }
  
  public void initView()
  {
    AppMethodBeat.i(53694);
    setMMTitle(2131299243);
    setBackBtn(new EmojiStoreV2RewardThanksUI.2(this));
    this.lqh = ((EmojiStoreV2RewardBannerView)findViewById(2131823690));
    this.lqh.setScale(1.0F);
    this.lqi = findViewById(2131823691);
    this.lqj = ((MMCopiableTextView)findViewById(2131823693));
    this.lqk = ((TextView)findViewById(2131823694));
    this.lql = ((TextView)findViewById(2131823692));
    this.lqm = ((AnimationDrawable)getResources().getDrawable(2130838608));
    AppMethodBeat.o(53694);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(53692);
    super.onCreate(paramBundle);
    this.lig = getIntent().getStringExtra("extra_id");
    initView();
    this.lmz = i.getEmojiStorageMgr().yNs.asX(this.lig);
    String str;
    if (this.lmz != null) {
      if ((this.lmz.Reward != null) && (!bo.isNullOrNil(this.lmz.Reward.wQE)))
      {
        paramBundle = this.lmz.Reward.wQF;
        str = EmojiLogic.L(b.YP(), this.lig, paramBundle);
        if (e.cN(str))
        {
          this.lqh.setImageFilePath(str);
          this.lqh.setScaleType(ImageView.ScaleType.FIT_XY);
          if ((this.lqm != null) && (this.lqm.isRunning())) {
            this.lqm.stop();
          }
        }
      }
    }
    while ((this.lmz != null) && (this.lmz.Reward != null))
    {
      this.lqi.setVisibility(0);
      bo.isNullOrNil(this.lmz.Reward.wQH);
      this.lqj.setVisibility(0);
      this.lqj.setText(2131299244);
      this.lqk.setVisibility(8);
      this.lql.setVisibility(8);
      AppMethodBeat.o(53692);
      return;
      o.ahG().a(paramBundle, this.lqh, g.j(this.lig, paramBundle, new Object[0]), new EmojiStoreV2RewardThanksUI.3(this, paramBundle, str));
      this.lqh.setBackgroundDrawable(getResources().getDrawable(2130840992));
      this.lqh.setImageDrawable(this.lqm);
      this.lqh.setScaleType(ImageView.ScaleType.CENTER);
      this.lqm.start();
      continue;
      this.lqh.setBackgroundDrawable(getResources().getDrawable(2130840992));
      this.lqh.setImageDrawable(this.lqm);
      this.lqh.setScaleType(ImageView.ScaleType.CENTER);
      this.lqm.start();
      continue;
      this.lqh.setBackgroundDrawable(getResources().getDrawable(2130840992));
      this.lqh.setImageDrawable(this.lqm);
      this.lqh.setScaleType(ImageView.ScaleType.CENTER);
      this.lqm.start();
    }
    this.lqi.setVisibility(8);
    AppMethodBeat.o(53692);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(53693);
    if ((this.lqm != null) && (this.lqm.isRunning())) {
      this.lqm.stop();
    }
    super.onDestroy();
    AppMethodBeat.o(53693);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardThanksUI
 * JD-Core Version:    0.7.0.1
 */