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
import com.tencent.mm.aw.q;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.ui.widget.MMCopiableTextView;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.mm.protocal.protobuf.agn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.i;

public class EmojiStoreV2RewardThanksUI
  extends MMActivity
{
  private ap mHandler;
  private String pFt;
  private GetEmotionRewardResponse pJQ;
  private EmojiStoreV2RewardBannerView pNB;
  private View pNC;
  private MMCopiableTextView pND;
  private TextView pNE;
  private TextView pNF;
  private AnimationDrawable pNG;
  
  public EmojiStoreV2RewardThanksUI()
  {
    AppMethodBeat.i(109266);
    this.mHandler = new ap()
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
          if ((!bt.isNullOrNil(paramAnonymousMessage)) && (i.fv(paramAnonymousMessage)))
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
            ad.i("MicroMsg.emoji.EmojiStoreV2RewardThanksUI", "path is null or file no exists");
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
    this.pNB = ((EmojiStoreV2RewardBannerView)findViewById(2131305764));
    this.pNB.setScale(1.0F);
    this.pNC = findViewById(2131301970);
    this.pND = ((MMCopiableTextView)findViewById(2131301972));
    this.pNE = ((TextView)findViewById(2131301969));
    this.pNF = ((TextView)findViewById(2131301971));
    this.pNG = ((AnimationDrawable)getResources().getDrawable(2131232019));
    AppMethodBeat.o(109269);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(109267);
    super.onCreate(paramBundle);
    this.pFt = getIntent().getStringExtra("extra_id");
    initView();
    this.pJQ = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().ILs.aUU(this.pFt);
    Object localObject;
    if (this.pJQ != null) {
      if ((this.pJQ.Reward != null) && (!bt.isNullOrNil(this.pJQ.Reward.Gex)))
      {
        paramBundle = this.pJQ.Reward.Gey;
        localObject = com.tencent.mm.emoji.d.a.gqn;
        localObject = EmojiLogic.j(com.tencent.mm.emoji.d.a.agp(), this.pFt, paramBundle);
        if (i.fv((String)localObject))
        {
          this.pNB.setImageFilePath((String)localObject);
          this.pNB.setScaleType(ImageView.ScaleType.FIT_XY);
          if ((this.pNG != null) && (this.pNG.isRunning())) {
            this.pNG.stop();
          }
        }
      }
    }
    while ((this.pJQ != null) && (this.pJQ.Reward != null))
    {
      this.pNC.setVisibility(0);
      bt.isNullOrNil(this.pJQ.Reward.GeA);
      this.pND.setVisibility(0);
      this.pND.setText(2131758370);
      this.pNE.setVisibility(8);
      this.pNF.setVisibility(8);
      AppMethodBeat.o(109267);
      return;
      q.aIJ().a(paramBundle, this.pNB, e.j(this.pFt, paramBundle, new Object[0]), new com.tencent.mm.aw.a.c.k()
      {
        public final void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(109265);
          if ((!bt.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equalsIgnoreCase(paramBundle)))
          {
            paramAnonymousString = new Message();
            paramAnonymousString.what = 1001;
            paramAnonymousString.obj = this.val$path;
            EmojiStoreV2RewardThanksUI.c(EmojiStoreV2RewardThanksUI.this).sendMessage(paramAnonymousString);
          }
          AppMethodBeat.o(109265);
        }
      });
      this.pNB.setBackgroundDrawable(getResources().getDrawable(2131232083));
      this.pNB.setImageDrawable(this.pNG);
      this.pNB.setScaleType(ImageView.ScaleType.CENTER);
      this.pNG.start();
      continue;
      this.pNB.setBackgroundDrawable(getResources().getDrawable(2131232083));
      this.pNB.setImageDrawable(this.pNG);
      this.pNB.setScaleType(ImageView.ScaleType.CENTER);
      this.pNG.start();
      continue;
      this.pNB.setBackgroundDrawable(getResources().getDrawable(2131232083));
      this.pNB.setImageDrawable(this.pNG);
      this.pNB.setScaleType(ImageView.ScaleType.CENTER);
      this.pNG.start();
    }
    this.pNC.setVisibility(8);
    AppMethodBeat.o(109267);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109268);
    if ((this.pNG != null) && (this.pNG.isRunning())) {
      this.pNG.stop();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardThanksUI
 * JD-Core Version:    0.7.0.1
 */