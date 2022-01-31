package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.as.a.a;
import com.tencent.mm.as.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.f.a;
import com.tencent.mm.plugin.emoji.f.d;
import com.tencent.mm.plugin.emoji.f.e;
import com.tencent.mm.plugin.emoji.f.f;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.plugin.emoji.f.c;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.ui.GridInScrollView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.afk;
import com.tencent.mm.protocal.c.eo;
import com.tencent.mm.protocal.c.vl;
import com.tencent.mm.protocal.c.vm;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.l;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.s;
import java.util.Collection;
import java.util.LinkedList;

public class EmojiStoreV2RewardUI
  extends MMActivity
  implements AdapterView.OnItemClickListener, f
{
  private ProgressDialog faz;
  private int iYt;
  private String iYz;
  private String iZs;
  private afk jdM;
  private Button jel;
  private MMFormInputView jhA;
  private TextView jhB;
  private TextView jhC;
  private EmojiStoreV2RewardUI.b jhD;
  private c jhE;
  private EmojiStoreV2RewardUI.a jhF = EmojiStoreV2RewardUI.a.jhM;
  private boolean jhG = false;
  private View.OnClickListener jhH = new EmojiStoreV2RewardUI.2(this);
  private View.OnClickListener jhI = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      if (EmojiStoreV2RewardUI.g(EmojiStoreV2RewardUI.this) == EmojiStoreV2RewardUI.a.jhM) {
        EmojiStoreV2RewardUI.a(EmojiStoreV2RewardUI.this, EmojiStoreV2RewardUI.a.jhN);
      }
    }
  };
  private TextWatcher jhJ = new EmojiStoreV2RewardUI.4(this);
  private AnimationDrawable jhs;
  private int jhv;
  private EmojiStoreV2RewardBannerView jhw;
  private GridInScrollView jhx;
  private View jhy;
  private View jhz;
  private ah mHandler = new EmojiStoreV2RewardUI.1(this);
  
  private void AY(String paramString)
  {
    com.tencent.mm.ui.base.h.a(this.mController.uMN, paramString, null, getString(f.h.emoji_sort_i_know), new EmojiStoreV2RewardUI.9(this));
  }
  
  private void VZ()
  {
    getString(f.h.app_tip);
    this.faz = com.tencent.mm.ui.base.h.b(this, getString(f.h.app_waiting), true, new EmojiStoreV2RewardUI.8(this));
  }
  
  private void a(EmojiStoreV2RewardUI.a parama)
  {
    if (parama == EmojiStoreV2RewardUI.a.jhN)
    {
      this.jhF = EmojiStoreV2RewardUI.a.jhN;
      if (this.jhz != null)
      {
        this.jhz.setVisibility(0);
        this.jhz.startAnimation(AnimationUtils.loadAnimation(this.mController.uMN, f.a.pop_in));
        this.jhA.getContentEditText().requestFocus();
        showVKB();
        this.jhy.setVisibility(8);
      }
      return;
    }
    XM();
    this.mHandler.postDelayed(new EmojiStoreV2RewardUI.5(this), 300L);
  }
  
  private void a(String paramString, vl paramvl)
  {
    VZ();
    this.jhE = new c(paramString, paramvl);
    g.DO().dJT.a(this.jhE, 0);
  }
  
  private void aZ()
  {
    Object localObject1;
    Object localObject2;
    if (this.jdM != null)
    {
      this.jhB.setVisibility(0);
      this.jhC.setVisibility(0);
      if ((this.jdM.tdo != null) && (!bk.bl(this.jdM.tdo.sSD)))
      {
        localObject1 = this.jdM.tdo.sSD;
        localObject2 = EmojiLogic.I(com.tencent.mm.plugin.emoji.h.b.FL(), this.iZs, (String)localObject1);
        if (com.tencent.mm.vfs.e.bK((String)localObject2))
        {
          this.jhw.setImageFilePath((String)localObject2);
          this.jhw.setScaleType(ImageView.ScaleType.FIT_XY);
          if ((this.jhs != null) && (this.jhs.isRunning())) {
            this.jhs.stop();
          }
        }
      }
    }
    while ((this.jdM != null) && (this.jdM.tdn != null))
    {
      this.jhx.setVisibility(0);
      localObject1 = this.jhD;
      localObject2 = this.jdM.tdn;
      if (((EmojiStoreV2RewardUI.b)localObject1).hkd == null) {
        ((EmojiStoreV2RewardUI.b)localObject1).hkd = new LinkedList();
      }
      ((EmojiStoreV2RewardUI.b)localObject1).hkd.clear();
      ((EmojiStoreV2RewardUI.b)localObject1).hkd.addAll((Collection)localObject2);
      ((EmojiStoreV2RewardUI.b)localObject1).notifyDataSetChanged();
      return;
      o.ON().a((String)localObject1, this.jhw, com.tencent.mm.plugin.emoji.e.e.j(this.iZs, (String)localObject1, new Object[0]), new EmojiStoreV2RewardUI.7(this, (String)localObject1, (String)localObject2));
      this.jhw.setBackgroundDrawable(getResources().getDrawable(f.d.emotion_reward_banner_bg_color));
      this.jhw.setImageDrawable(this.jhs);
      this.jhw.setScaleType(ImageView.ScaleType.CENTER);
      this.jhs.start();
      continue;
      this.jhw.setBackgroundDrawable(getResources().getDrawable(f.d.emotion_reward_banner_bg_color));
      this.jhw.setImageDrawable(this.jhs);
      this.jhw.setScaleType(ImageView.ScaleType.CENTER);
      this.jhs.start();
      continue;
      this.jhB.setVisibility(8);
      this.jhC.setVisibility(8);
    }
    this.jhx.setVisibility(8);
  }
  
  private void fn(boolean paramBoolean)
  {
    y.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "doGetRewardScene");
    if (paramBoolean)
    {
      localp = new com.tencent.mm.plugin.emoji.f.p(this.iZs, com.tencent.mm.plugin.emoji.f.p.jab);
      g.DO().dJT.a(localp, 0);
      return;
    }
    com.tencent.mm.plugin.emoji.f.p localp = new com.tencent.mm.plugin.emoji.f.p(this.iZs, com.tencent.mm.plugin.emoji.f.p.jac);
    g.DO().dJT.a(localp, 0);
    VZ();
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return f.f.emoji_store_v2_rewardl_ui;
  }
  
  protected final void initView()
  {
    if (bk.bl(this.iYz)) {
      setMMTitle(f.h.emoji_store_reward);
    }
    for (;;)
    {
      setMMSubTitle(f.h.wechat_authenticate_safely);
      setBackBtn(new EmojiStoreV2RewardUI.6(this));
      this.jhy = findViewById(f.e.reward_main);
      this.jhz = findViewById(f.e.reward_other);
      this.jhA = ((MMFormInputView)findViewById(f.e.reward_other_price_et));
      this.jel = ((Button)findViewById(f.e.reward_reward_btn));
      this.jel.setOnClickListener(this.jhH);
      this.jel.setEnabled(false);
      this.jhA.setInputType(8194);
      this.jhA.addTextChangedListener(this.jhJ);
      this.jhA.getContentEditText().setFilters(new InputFilter[] { new InputFilter.LengthFilter(12) });
      this.jhB = ((TextView)findViewById(f.e.reward_custom));
      this.jhB.setOnClickListener(this.jhI);
      this.jhC = ((TextView)findViewById(f.e.reward_choose_price));
      this.jhw = ((EmojiStoreV2RewardBannerView)findViewById(f.e.beg_pic));
      this.jhx = ((GridInScrollView)findViewById(16908298));
      this.jhD = new EmojiStoreV2RewardUI.b(this);
      this.jhx.setAdapter(this.jhD);
      this.jhx.setOnItemClickListener(this);
      this.jhs = ((AnimationDrawable)getResources().getDrawable(f.d.emoji_doge_loading));
      return;
      setMMTitle(getString(f.h.emoji_store_reward_to_designer, new Object[] { this.iYz }));
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default: 
      return;
    }
    if (paramInt2 == -1)
    {
      paramIntent = new Intent();
      paramIntent.setClass(this, EmojiStoreV2RewardThanksUI.class);
      paramIntent.putExtra("extra_id", this.iZs);
      startActivity(paramIntent);
      com.tencent.mm.plugin.report.service.h.nFQ.f(12738, new Object[] { this.iZs, Integer.valueOf(this.jhv), Integer.valueOf(this.iYt), Integer.valueOf(1) });
      com.tencent.mm.plugin.report.service.h.nFQ.a(408L, 9L, 1L, false);
      fn(true);
      finish();
      return;
    }
    if (paramInt2 == 0)
    {
      com.tencent.mm.plugin.report.service.h.nFQ.f(12738, new Object[] { this.iZs, Integer.valueOf(this.jhv), Integer.valueOf(this.iYt), Integer.valueOf(3) });
      com.tencent.mm.plugin.report.service.h.nFQ.a(408L, 3L, 1L, false);
      return;
    }
    if (!this.jhG)
    {
      this.jhG = true;
      com.tencent.mm.plugin.report.service.h.nFQ.f(12738, new Object[] { this.iZs, Integer.valueOf(this.jhv), Integer.valueOf(this.iYt), Integer.valueOf(2) });
    }
    com.tencent.mm.plugin.report.service.h.nFQ.a(408L, 4L, 1L, false);
  }
  
  public void onBackPressed()
  {
    y.i("MicroMsg.emoji.EmojiStoreV2RewardUI", this.mController.uNh);
    if (this.jhF == EmojiStoreV2RewardUI.a.jhM)
    {
      if (this.jhG) {
        com.tencent.mm.plugin.report.service.h.nFQ.a(408L, 2L, 1L, false);
      }
      for (;;)
      {
        super.onBackPressed();
        return;
        com.tencent.mm.plugin.report.service.h.nFQ.a(408L, 1L, 1L, false);
        com.tencent.mm.plugin.report.service.h.nFQ.f(12738, new Object[] { this.iZs, Integer.valueOf(this.jhv), Integer.valueOf(this.iYt), Integer.valueOf(4) });
      }
    }
    a(EmojiStoreV2RewardUI.a.jhM);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.iZs = getIntent().getStringExtra("extra_id");
    this.iYz = getIntent().getStringExtra("name");
    this.iYt = getIntent().getIntExtra("scene", 0);
    this.jhv = getIntent().getIntExtra("pageType", 0);
    initView();
    this.jdM = i.getEmojiStorageMgr().uBg.acJ(this.iZs);
    if ((this.jdM != null) && (this.jdM.tdo != null))
    {
      o.ON().a(this.jdM.tdo.sSE, null, com.tencent.mm.plugin.emoji.e.e.j(this.iZs, this.jdM.tdo.sSE, new Object[0]));
      o.ON().a(this.jdM.tdo.sSF, null, com.tencent.mm.plugin.emoji.e.e.j(this.iZs, this.jdM.tdo.sSF, new Object[0]));
    }
    for (;;)
    {
      aZ();
      g.DO().dJT.a(830, this);
      g.DO().dJT.a(822, this);
      com.tencent.mm.plugin.report.service.h.nFQ.a(408L, 0L, 1L, false);
      return;
      fn(false);
    }
  }
  
  protected void onDestroy()
  {
    g.DO().dJT.b(830, this);
    g.DO().dJT.b(822, this);
    if ((this.jhs != null) && (this.jhs.isRunning())) {
      this.jhs.stop();
    }
    super.onDestroy();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jhD != null)
    {
      paramAdapterView = this.jhD.qa(paramInt);
      if (paramAdapterView != null)
      {
        y.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "onItemClick position:%d", new Object[] { Integer.valueOf(paramInt) });
        a(this.iZs, paramAdapterView);
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((this.faz != null) && (this.faz.isShowing())) {
      this.faz.dismiss();
    }
    int i = paramm.getType();
    switch (i)
    {
    default: 
      y.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "unknown scene. type:%d", new Object[] { Integer.valueOf(i) });
    case 830: 
      String str;
      do
      {
        return;
        localObject = (c)paramm;
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break;
        }
        paramString = new Bundle();
        paramString.putBoolean("extinfo_key_10", true);
        paramm = this.mController.uMN;
        str = ((c)localObject).aIb().sye;
        localObject = ((c)localObject).aIb().kRX;
      } while (bk.bl(str));
      Object localObject = com.tencent.mm.pluginsdk.wallet.h.J(str, (String)localObject, 5);
      ((PayInfo)localObject).snX = paramString;
      com.tencent.mm.pluginsdk.wallet.h.a(paramm, (PayInfo)localObject, 8001);
      return;
      if (paramInt1 == 4)
      {
        if (!this.jhG)
        {
          this.jhG = true;
          com.tencent.mm.plugin.report.service.h.nFQ.f(12738, new Object[] { this.iZs, Integer.valueOf(this.jhv), Integer.valueOf(this.iYt), Integer.valueOf(2) });
        }
        if (paramInt2 == c.iZp)
        {
          com.tencent.mm.plugin.report.service.h.nFQ.a(408L, 6L, 1L, false);
          if (bk.bl(paramString))
          {
            AY(getString(f.h.emoji_store_reward_magic_pay_limite));
            return;
          }
          AY(paramString);
          return;
        }
        if (paramInt2 == c.iZq)
        {
          com.tencent.mm.plugin.report.service.h.nFQ.a(408L, 7L, 1L, false);
          if (bk.bl(paramString))
          {
            AY(getString(f.h.emoji_store_reward_magic_receive_limite));
            return;
          }
          AY(paramString);
          return;
        }
        if (paramInt2 == c.iZr)
        {
          com.tencent.mm.plugin.report.service.h.nFQ.a(408L, 5L, 1L, false);
          if (bk.bl(paramString))
          {
            AY(getString(f.h.emoji_store_reward_magic_pay_self));
            return;
          }
          AY(paramString);
          return;
        }
        com.tencent.mm.plugin.report.service.h.nFQ.a(408L, 8L, 1L, false);
        Toast.makeText(this, getString(f.h.emoji_store_ask_reward_failed), 0).show();
        return;
      }
      if (!this.jhG)
      {
        this.jhG = true;
        com.tencent.mm.plugin.report.service.h.nFQ.f(12738, new Object[] { this.iZs, Integer.valueOf(this.jhv), Integer.valueOf(this.iYt), Integer.valueOf(2) });
      }
      com.tencent.mm.plugin.report.service.h.nFQ.a(408L, 8L, 1L, false);
      Toast.makeText(this, getString(f.h.emoji_store_ask_reward_failed), 0).show();
      return;
    }
    paramString = (com.tencent.mm.plugin.emoji.f.p)paramm;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      y.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "update emotion reward success.");
      this.jdM = paramString.aIk();
      o.ON().a(this.jdM.tdo.sSE, null, com.tencent.mm.plugin.emoji.e.e.j(this.iZs, this.jdM.tdo.sSE, new Object[0]));
      this.mHandler.sendEmptyMessage(1002);
      return;
    }
    y.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "update emotion reward failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI
 * JD-Core Version:    0.7.0.1
 */