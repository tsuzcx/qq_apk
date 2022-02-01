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
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.MMActivity;

public class EmojiStoreV2RewardThanksUI
  extends MMActivity
{
  private aq mHandler;
  private String pLX;
  private GetEmotionRewardResponse pQv;
  private EmojiStoreV2RewardBannerView pUg;
  private View pUh;
  private MMCopiableTextView pUi;
  private TextView pUj;
  private TextView pUk;
  private AnimationDrawable pUl;
  
  public EmojiStoreV2RewardThanksUI()
  {
    AppMethodBeat.i(109266);
    this.mHandler = new aq()
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
          if ((!bu.isNullOrNil(paramAnonymousMessage)) && (com.tencent.mm.vfs.o.fB(paramAnonymousMessage)))
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
            ae.i("MicroMsg.emoji.EmojiStoreV2RewardThanksUI", "path is null or file no exists");
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
    this.pUg = ((EmojiStoreV2RewardBannerView)findViewById(2131305764));
    this.pUg.setScale(1.0F);
    this.pUh = findViewById(2131301970);
    this.pUi = ((MMCopiableTextView)findViewById(2131301972));
    this.pUj = ((TextView)findViewById(2131301969));
    this.pUk = ((TextView)findViewById(2131301971));
    this.pUl = ((AnimationDrawable)getResources().getDrawable(2131232019));
    AppMethodBeat.o(109269);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(109267);
    super.onCreate(paramBundle);
    this.pLX = getIntent().getStringExtra("extra_id");
    initView();
    this.pQv = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().JfZ.aWv(this.pLX);
    Object localObject;
    if (this.pQv != null) {
      if ((this.pQv.Reward != null) && (!bu.isNullOrNil(this.pQv.Reward.Gxf)))
      {
        paramBundle = this.pQv.Reward.Gxg;
        localObject = com.tencent.mm.emoji.d.a.gsI;
        localObject = EmojiLogic.j(com.tencent.mm.emoji.d.a.agD(), this.pLX, paramBundle);
        if (com.tencent.mm.vfs.o.fB((String)localObject))
        {
          this.pUg.setImageFilePath((String)localObject);
          this.pUg.setScaleType(ImageView.ScaleType.FIT_XY);
          if ((this.pUl != null) && (this.pUl.isRunning())) {
            this.pUl.stop();
          }
        }
      }
    }
    while ((this.pQv != null) && (this.pQv.Reward != null))
    {
      this.pUh.setVisibility(0);
      bu.isNullOrNil(this.pQv.Reward.Gxi);
      this.pUi.setVisibility(0);
      this.pUi.setText(2131758370);
      this.pUj.setVisibility(8);
      this.pUk.setVisibility(8);
      AppMethodBeat.o(109267);
      return;
      q.aJb().a(paramBundle, this.pUg, e.j(this.pLX, paramBundle, new Object[0]), new com.tencent.mm.av.a.c.k()
      {
        public final void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(109265);
          if ((!bu.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equalsIgnoreCase(paramBundle)))
          {
            paramAnonymousString = new Message();
            paramAnonymousString.what = 1001;
            paramAnonymousString.obj = this.val$path;
            EmojiStoreV2RewardThanksUI.c(EmojiStoreV2RewardThanksUI.this).sendMessage(paramAnonymousString);
          }
          AppMethodBeat.o(109265);
        }
      });
      this.pUg.setBackgroundDrawable(getResources().getDrawable(2131232083));
      this.pUg.setImageDrawable(this.pUl);
      this.pUg.setScaleType(ImageView.ScaleType.CENTER);
      this.pUl.start();
      continue;
      this.pUg.setBackgroundDrawable(getResources().getDrawable(2131232083));
      this.pUg.setImageDrawable(this.pUl);
      this.pUg.setScaleType(ImageView.ScaleType.CENTER);
      this.pUl.start();
      continue;
      this.pUg.setBackgroundDrawable(getResources().getDrawable(2131232083));
      this.pUg.setImageDrawable(this.pUl);
      this.pUg.setScaleType(ImageView.ScaleType.CENTER);
      this.pUl.start();
    }
    this.pUh.setVisibility(8);
    AppMethodBeat.o(109267);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109268);
    if ((this.pUl != null) && (this.pUl.isRunning())) {
      this.pUl.stop();
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