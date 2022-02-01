package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.luckymoney.app.a;
import com.tencent.mm.plugin.luckymoney.model.ag;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.luckymoney.model.as;
import com.tencent.mm.plugin.luckymoney.model.at;
import com.tencent.mm.plugin.luckymoney.model.o;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.y.b;

public class LuckyMoneyIndexUI
  extends LuckyMoneyBaseUI
{
  private LinearLayout KDd;
  private LinearLayout KDe;
  private LinearLayout KDf;
  private int mChannel;
  
  private void fYq()
  {
    AppMethodBeat.i(65606);
    if (ah.IH(getIntent().getStringExtra("key_username"))) {
      a.fWk();
    }
    for (o localo = a.fWm().fWW(); localo == null; localo = a.fWl().fWW())
    {
      AppMethodBeat.o(65606);
      return;
      a.fWk();
    }
    ImageView localImageView = (ImageView)findViewById(a.f.lucky_money_index_top_decoration);
    if ((localo.KrD & 0x1) == 1)
    {
      Log.i("MicroMsg.LuckyMoneyIndexUI", "initView: topBg use money bg");
      localImageView.setImageResource(a.e.lucky_money_index_top_decoration);
      AppMethodBeat.o(65606);
      return;
    }
    localImageView.setImageResource(a.e.lucky_money_index_topbg_temporary);
    AppMethodBeat.o(65606);
  }
  
  public int getLayoutId()
  {
    return a.g.lucky_money_index_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(65605);
    setMMTitle(a.i.lucky_money_title);
    setBackBtn(new LuckyMoneyIndexUI.1(this));
    this.KDd = ((LinearLayout)findViewById(a.f.lucky_money_index_tail_opertaion));
    this.KDe = ((LinearLayout)findViewById(a.f.lucky_money_index_middle_opertaion));
    this.KDf = ((LinearLayout)findViewById(a.f.lucky_money_index_banner_opertaion));
    ((Button)findViewById(a.f.lucky_money_index_normal)).setOnClickListener(new LuckyMoneyIndexUI.2(this));
    ((Button)findViewById(a.f.lucky_money_index_group)).setOnClickListener(new LuckyMoneyIndexUI.3(this));
    addTextOptionMenu(0, getString(a.i.lucky_money_mine_title), new LuckyMoneyIndexUI.4(this), null, y.b.adEQ);
    fYq();
    AppMethodBeat.o(65605);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65603);
    super.onCreate(paramBundle);
    ((b)com.tencent.mm.kernel.h.ax(b.class)).a(this, null);
    initView();
    if (ah.IH(getIntent().getStringExtra("key_username"))) {
      doSceneProgress(new at("v1.0", ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acVd, Integer.valueOf(0))).intValue()), false);
    }
    for (;;)
    {
      this.mChannel = getIntent().getIntExtra("pay_channel", -1);
      com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      AppMethodBeat.o(65603);
      return;
      doSceneProgress(new as("v1.0", ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acVd, Integer.valueOf(0))).intValue()), false);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(65604);
    super.onResume();
    b localb = (b)com.tencent.mm.kernel.h.ax(b.class);
    localb.a(this, localb.imz(), null);
    AppMethodBeat.o(65604);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(65607);
    if ((paramp instanceof as))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (as)paramp;
        paramp = new i.c();
        paramp.textColor = getResources().getColor(a.c.lucky_money_index_operation_text_color);
        paramp.KFX = 101;
        i.a(this, this.KDd, paramString.Ksc, paramp, "Text");
        paramp = new i.c();
        paramp.textColor = getResources().getColor(a.c.lucky_money_index_operation_text_color);
        paramp.KFX = 100;
        i.a(this, this.KDe, paramString.Kut, paramp, "Text");
        paramp = new i.c();
        paramp.KFX = 102;
        i.a(this, this.KDf, paramString.Kur, paramp, "Pic");
        fYq();
      }
      AppMethodBeat.o(65607);
      return true;
    }
    AppMethodBeat.o(65607);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyIndexUI
 * JD-Core Version:    0.7.0.1
 */