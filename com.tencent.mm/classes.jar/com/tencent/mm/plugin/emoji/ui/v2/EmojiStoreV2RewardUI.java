package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.at.a.a;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.ui.GridInScrollView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.EmotionPrice;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.mm.protocal.protobuf.fr;
import com.tencent.mm.protocal.protobuf.zr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.l;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.vfs.e;

public class EmojiStoreV2RewardUI
  extends MMActivity
  implements AdapterView.OnItemClickListener, f
{
  private ProgressDialog gsr;
  private String lhE;
  private int lhy;
  private String lig;
  private Button lmY;
  private GetEmotionRewardResponse lmz;
  private String lqA;
  private EmojiStoreV2RewardUI.a lqB;
  private boolean lqC;
  private View.OnClickListener lqD;
  private View.OnClickListener lqE;
  private TextWatcher lqF;
  private com.tencent.mm.plugin.emoji.model.g lqG;
  private AnimationDrawable lqm;
  private int lqp;
  private EmojiStoreV2RewardBannerView lqq;
  private GridInScrollView lqr;
  private View lqs;
  private View lqt;
  private MMFormInputView lqu;
  private TextView lqv;
  private TextView lqw;
  private EmojiStoreV2RewardUI.b lqx;
  private com.tencent.mm.plugin.emoji.f.b lqy;
  private String lqz;
  private ak mHandler;
  
  public EmojiStoreV2RewardUI()
  {
    AppMethodBeat.i(53712);
    this.lqB = EmojiStoreV2RewardUI.a.lqI;
    this.lqC = false;
    this.mHandler = new EmojiStoreV2RewardUI.1(this);
    this.lqD = new EmojiStoreV2RewardUI.2(this);
    this.lqE = new EmojiStoreV2RewardUI.3(this);
    this.lqF = new EmojiStoreV2RewardUI.4(this);
    this.lqG = new com.tencent.mm.plugin.emoji.model.g(new EmojiStoreV2RewardUI.5(this));
    AppMethodBeat.o(53712);
  }
  
  private void La(String paramString)
  {
    AppMethodBeat.i(53724);
    com.tencent.mm.ui.base.h.a(getContext(), paramString, null, getString(2131299178), new EmojiStoreV2RewardUI.9(this));
    AppMethodBeat.o(53724);
  }
  
  private void a(EmojiStoreV2RewardUI.a parama)
  {
    AppMethodBeat.i(53716);
    if (parama == EmojiStoreV2RewardUI.a.lqJ)
    {
      this.lqB = EmojiStoreV2RewardUI.a.lqJ;
      if (this.lqt != null)
      {
        this.lqt.setVisibility(0);
        this.lqt.startAnimation(AnimationUtils.loadAnimation(getContext(), 2131034217));
        this.lqu.getContentEditText().requestFocus();
        showVKB();
        this.lqs.setVisibility(8);
        AppMethodBeat.o(53716);
      }
    }
    else
    {
      hideVKB();
      this.mHandler.postDelayed(new EmojiStoreV2RewardUI.6(this), 300L);
    }
    AppMethodBeat.o(53716);
  }
  
  private void a(String paramString, EmotionPrice paramEmotionPrice)
  {
    AppMethodBeat.i(53722);
    apy();
    this.lqy = new com.tencent.mm.plugin.emoji.f.b(paramString, paramEmotionPrice);
    com.tencent.mm.kernel.g.RK().eHt.a(this.lqy, 0);
    AppMethodBeat.o(53722);
  }
  
  private void apy()
  {
    AppMethodBeat.i(53723);
    getString(2131297087);
    this.gsr = com.tencent.mm.ui.base.h.b(this, getString(2131297112), true, new EmojiStoreV2RewardUI.8(this));
    AppMethodBeat.o(53723);
  }
  
  private void bJ()
  {
    AppMethodBeat.i(53718);
    if (this.lmz != null)
    {
      this.lqv.setVisibility(0);
      this.lqw.setVisibility(0);
      if ((this.lmz.Reward != null) && (!bo.isNullOrNil(this.lmz.Reward.wQE)))
      {
        this.lqz = this.lmz.Reward.wQE;
        this.lqA = EmojiLogic.L(com.tencent.mm.plugin.emoji.h.b.YP(), this.lig, this.lqz);
        if (e.cN(this.lqA))
        {
          this.lqq.setImageFilePath(this.lqA);
          this.lqq.setScaleType(ImageView.ScaleType.FIT_XY);
          if ((this.lqm != null) && (this.lqm.isRunning())) {
            this.lqm.stop();
          }
        }
      }
    }
    while ((this.lmz != null) && (this.lmz.Price != null))
    {
      this.lqr.setVisibility(0);
      this.lqx.Q(this.lmz.Price);
      AppMethodBeat.o(53718);
      return;
      com.tencent.mm.at.o.ahG().a(this.lqz, this.lqq, com.tencent.mm.plugin.emoji.e.g.j(this.lig, this.lqz, new Object[0]), this.lqG);
      this.lqq.setBackgroundDrawable(getResources().getDrawable(2130840992));
      this.lqq.setImageDrawable(this.lqm);
      this.lqq.setScaleType(ImageView.ScaleType.CENTER);
      this.lqm.start();
      continue;
      this.lqq.setBackgroundDrawable(getResources().getDrawable(2130840992));
      this.lqq.setImageDrawable(this.lqm);
      this.lqq.setScaleType(ImageView.ScaleType.CENTER);
      this.lqm.start();
      continue;
      this.lqv.setVisibility(8);
      this.lqw.setVisibility(8);
    }
    this.lqr.setVisibility(8);
    AppMethodBeat.o(53718);
  }
  
  private void gP(boolean paramBoolean)
  {
    AppMethodBeat.i(53725);
    ab.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "doGetRewardScene");
    if (paramBoolean)
    {
      localo = new com.tencent.mm.plugin.emoji.f.o(this.lig, com.tencent.mm.plugin.emoji.f.o.liS);
      com.tencent.mm.kernel.g.RK().eHt.a(localo, 0);
      AppMethodBeat.o(53725);
      return;
    }
    com.tencent.mm.plugin.emoji.f.o localo = new com.tencent.mm.plugin.emoji.f.o(this.lig, com.tencent.mm.plugin.emoji.f.o.liT);
    com.tencent.mm.kernel.g.RK().eHt.a(localo, 0);
    apy();
    AppMethodBeat.o(53725);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130969410;
  }
  
  public void initView()
  {
    AppMethodBeat.i(53717);
    if (bo.isNullOrNil(this.lhE)) {
      setMMTitle(2131299226);
    }
    for (;;)
    {
      setMMSubTitle(2131305936);
      setBackBtn(new EmojiStoreV2RewardUI.7(this));
      this.lqs = findViewById(2131823695);
      this.lqt = findViewById(2131823699);
      this.lqu = ((MMFormInputView)findViewById(2131823700));
      this.lmY = ((Button)findViewById(2131823701));
      this.lmY.setOnClickListener(this.lqD);
      this.lmY.setEnabled(false);
      this.lqu.setInputType(8194);
      this.lqu.addTextChangedListener(this.lqF);
      this.lqu.getContentEditText().setFilters(new InputFilter[] { new InputFilter.LengthFilter(12) });
      this.lqv = ((TextView)findViewById(2131823698));
      this.lqv.setOnClickListener(this.lqE);
      this.lqw = ((TextView)findViewById(2131823697));
      this.lqq = ((EmojiStoreV2RewardBannerView)findViewById(2131823696));
      this.lqr = ((GridInScrollView)findViewById(16908298));
      this.lqx = new EmojiStoreV2RewardUI.b(this);
      this.lqr.setAdapter(this.lqx);
      this.lqr.setOnItemClickListener(this);
      this.lqm = ((AnimationDrawable)getResources().getDrawable(2130838608));
      AppMethodBeat.o(53717);
      return;
      setMMTitle(getString(2131299245, new Object[] { this.lhE }));
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(53720);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(53720);
      return;
      if (paramInt2 == -1)
      {
        paramIntent = new Intent();
        paramIntent.setClass(this, EmojiStoreV2RewardThanksUI.class);
        paramIntent.putExtra("extra_id", this.lig);
        startActivity(paramIntent);
        com.tencent.mm.plugin.report.service.h.qsU.e(12738, new Object[] { this.lig, Integer.valueOf(this.lqp), Integer.valueOf(this.lhy), Integer.valueOf(1) });
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(408L, 9L, 1L, false);
        gP(true);
        finish();
        AppMethodBeat.o(53720);
        return;
      }
      if (paramInt2 == 0)
      {
        com.tencent.mm.plugin.report.service.h.qsU.e(12738, new Object[] { this.lig, Integer.valueOf(this.lqp), Integer.valueOf(this.lhy), Integer.valueOf(3) });
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(408L, 3L, 1L, false);
        AppMethodBeat.o(53720);
        return;
      }
      if (!this.lqC)
      {
        this.lqC = true;
        com.tencent.mm.plugin.report.service.h.qsU.e(12738, new Object[] { this.lig, Integer.valueOf(this.lqp), Integer.valueOf(this.lhy), Integer.valueOf(2) });
      }
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(408L, 4L, 1L, false);
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(53715);
    ab.i("MicroMsg.emoji.EmojiStoreV2RewardUI", keyboardState());
    if (this.lqB == EmojiStoreV2RewardUI.a.lqI)
    {
      if (this.lqC) {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(408L, 2L, 1L, false);
      }
      for (;;)
      {
        super.onBackPressed();
        AppMethodBeat.o(53715);
        return;
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(408L, 1L, 1L, false);
        com.tencent.mm.plugin.report.service.h.qsU.e(12738, new Object[] { this.lig, Integer.valueOf(this.lqp), Integer.valueOf(this.lhy), Integer.valueOf(4) });
      }
    }
    a(EmojiStoreV2RewardUI.a.lqI);
    AppMethodBeat.o(53715);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(53713);
    super.onCreate(paramBundle);
    this.lig = getIntent().getStringExtra("extra_id");
    this.lhE = getIntent().getStringExtra("name");
    this.lhy = getIntent().getIntExtra("scene", 0);
    this.lqp = getIntent().getIntExtra("pageType", 0);
    initView();
    this.lmz = i.getEmojiStorageMgr().yNs.asX(this.lig);
    if ((this.lmz != null) && (this.lmz.Reward != null))
    {
      com.tencent.mm.at.o.ahG().a(this.lmz.Reward.wQF, null, com.tencent.mm.plugin.emoji.e.g.j(this.lig, this.lmz.Reward.wQF, new Object[0]));
      com.tencent.mm.at.o.ahG().a(this.lmz.Reward.wQG, null, com.tencent.mm.plugin.emoji.e.g.j(this.lig, this.lmz.Reward.wQG, new Object[0]));
    }
    for (;;)
    {
      bJ();
      com.tencent.mm.kernel.g.RK().eHt.a(830, this);
      com.tencent.mm.kernel.g.RK().eHt.a(822, this);
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(408L, 0L, 1L, false);
      AppMethodBeat.o(53713);
      return;
      gP(false);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(53714);
    com.tencent.mm.kernel.g.RK().eHt.b(830, this);
    com.tencent.mm.kernel.g.RK().eHt.b(822, this);
    if ((this.lqm != null) && (this.lqm.isRunning())) {
      this.lqm.stop();
    }
    com.tencent.mm.at.o.ahG().b(null, this.lqq);
    this.lqG.lhu = null;
    this.lqG = null;
    super.onDestroy();
    AppMethodBeat.o(53714);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(53719);
    if (this.lqx != null)
    {
      paramAdapterView = this.lqx.uw(paramInt);
      if (paramAdapterView != null)
      {
        ab.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "onItemClick position:%d", new Object[] { Integer.valueOf(paramInt) });
        a(this.lig, paramAdapterView);
      }
    }
    AppMethodBeat.o(53719);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(53721);
    if ((this.gsr != null) && (this.gsr.isShowing())) {
      this.gsr.dismiss();
    }
    int i = paramm.getType();
    switch (i)
    {
    default: 
      ab.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "unknown scene. type:%d", new Object[] { Integer.valueOf(i) });
    }
    do
    {
      AppMethodBeat.o(53721);
      return;
      Object localObject = (com.tencent.mm.plugin.emoji.f.b)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = new Bundle();
        paramString.putBoolean("extinfo_key_10", true);
        paramm = getContext();
        String str = ((com.tencent.mm.plugin.emoji.f.b)localObject).blz().wrH;
        localObject = ((com.tencent.mm.plugin.emoji.f.b)localObject).blz().npZ;
        if (!bo.isNullOrNil(str))
        {
          localObject = com.tencent.mm.pluginsdk.wallet.h.S(str, (String)localObject, 5);
          ((PayInfo)localObject).wgv = paramString;
          com.tencent.mm.pluginsdk.wallet.h.a(paramm, (PayInfo)localObject, 8001);
        }
        AppMethodBeat.o(53721);
        return;
      }
      if (paramInt1 == 4)
      {
        if (!this.lqC)
        {
          this.lqC = true;
          com.tencent.mm.plugin.report.service.h.qsU.e(12738, new Object[] { this.lig, Integer.valueOf(this.lqp), Integer.valueOf(this.lhy), Integer.valueOf(2) });
        }
        if (paramInt2 == com.tencent.mm.plugin.emoji.f.b.lid)
        {
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(408L, 6L, 1L, false);
          if (bo.isNullOrNil(paramString))
          {
            La(getString(2131299232));
            AppMethodBeat.o(53721);
            return;
          }
          La(paramString);
          AppMethodBeat.o(53721);
          return;
        }
        if (paramInt2 == com.tencent.mm.plugin.emoji.f.b.lie)
        {
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(408L, 7L, 1L, false);
          if (bo.isNullOrNil(paramString))
          {
            La(getString(2131299234));
            AppMethodBeat.o(53721);
            return;
          }
          La(paramString);
          AppMethodBeat.o(53721);
          return;
        }
        if (paramInt2 == com.tencent.mm.plugin.emoji.f.b.lif)
        {
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(408L, 5L, 1L, false);
          if (bo.isNullOrNil(paramString))
          {
            La(getString(2131299233));
            AppMethodBeat.o(53721);
            return;
          }
          La(paramString);
          AppMethodBeat.o(53721);
          return;
        }
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(408L, 8L, 1L, false);
        Toast.makeText(this, getString(2131299184), 0).show();
        AppMethodBeat.o(53721);
        return;
      }
      if (!this.lqC)
      {
        this.lqC = true;
        com.tencent.mm.plugin.report.service.h.qsU.e(12738, new Object[] { this.lig, Integer.valueOf(this.lqp), Integer.valueOf(this.lhy), Integer.valueOf(2) });
      }
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(408L, 8L, 1L, false);
      Toast.makeText(this, getString(2131299184), 0).show();
      AppMethodBeat.o(53721);
      return;
    } while (!(paramm instanceof com.tencent.mm.plugin.emoji.f.o));
    paramString = (com.tencent.mm.plugin.emoji.f.o)paramm;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ab.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "update emotion reward success.");
      this.lmz = paramString.blJ();
      com.tencent.mm.at.o.ahG().a(this.lmz.Reward.wQF, null, com.tencent.mm.plugin.emoji.e.g.j(this.lig, this.lmz.Reward.wQF, new Object[0]));
      this.mHandler.sendEmptyMessage(1002);
      AppMethodBeat.o(53721);
      return;
    }
    ab.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "update emotion reward failed.");
    AppMethodBeat.o(53721);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI
 * JD-Core Version:    0.7.0.1
 */