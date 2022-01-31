package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.luckymoney.b.a;
import com.tencent.mm.plugin.luckymoney.model.ag;
import com.tencent.mm.plugin.luckymoney.model.i;
import com.tencent.mm.plugin.luckymoney.model.j;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.q.b;

public class LuckyMoneyIndexUI
  extends LuckyMoneyBaseUI
{
  private int mChannel;
  private LinearLayout otF;
  private LinearLayout otG;
  private LinearLayout otH;
  
  private void bNX()
  {
    AppMethodBeat.i(42729);
    a.bMG();
    i locali = a.bMH().bNk();
    if (locali == null)
    {
      AppMethodBeat.o(42729);
      return;
    }
    ImageView localImageView = (ImageView)findViewById(2131825691);
    if ((locali.onl & 0x1) == 1)
    {
      ab.i("MicroMsg.LuckyMoneyIndexUI", "initView: topBg use money bg");
      localImageView.setImageResource(2130839425);
      AppMethodBeat.o(42729);
      return;
    }
    localImageView.setImageResource(2130839426);
    AppMethodBeat.o(42729);
  }
  
  public int getLayoutId()
  {
    return 2130970031;
  }
  
  public void initView()
  {
    AppMethodBeat.i(42728);
    setMMTitle(2131301328);
    setBackBtn(new LuckyMoneyIndexUI.1(this));
    this.otF = ((LinearLayout)findViewById(2131825696));
    this.otG = ((LinearLayout)findViewById(2131825695));
    this.otH = ((LinearLayout)findViewById(2131825697));
    ((Button)findViewById(2131825694)).setOnClickListener(new LuckyMoneyIndexUI.2(this));
    ((Button)findViewById(2131825693)).setOnClickListener(new LuckyMoneyIndexUI.3(this));
    addTextOptionMenu(0, getString(2131301250), new LuckyMoneyIndexUI.4(this), null, q.b.zbF);
    bNX();
    AppMethodBeat.o(42728);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42726);
    super.onCreate(paramBundle);
    ((b)g.E(b.class)).a(this, null);
    initView();
    doSceneProgress(new ag("v1.0", ((Integer)g.RL().Ru().get(ac.a.yJl, Integer.valueOf(0))).intValue(), (byte)0), false);
    this.mChannel = getIntent().getIntExtra("pay_channel", -1);
    com.tencent.mm.plugin.report.service.h.qsU.e(11701, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    AppMethodBeat.o(42726);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(42727);
    super.onResume();
    b localb = (b)g.E(b.class);
    localb.a(this, localb.cXt(), null);
    AppMethodBeat.o(42727);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(42730);
    if ((paramm instanceof ag))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ag)paramm;
        paramm = new h.c();
        paramm.textColor = getResources().getColor(2131690250);
        paramm.ovK = 101;
        h.a(this, this.otF, paramString.onH, paramm, "Text");
        paramm = new h.c();
        paramm.textColor = getResources().getColor(2131690250);
        paramm.ovK = 100;
        h.a(this, this.otG, paramString.opk, paramm, "Text");
        paramm = new h.c();
        paramm.ovK = 102;
        h.a(this, this.otH, paramString.opi, paramm, "Pic");
        bNX();
      }
      AppMethodBeat.o(42730);
      return true;
    }
    AppMethodBeat.o(42730);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyIndexUI
 * JD-Core Version:    0.7.0.1
 */