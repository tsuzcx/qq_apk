package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.luckymoney.b.a;
import com.tencent.mm.plugin.luckymoney.model.ai;
import com.tencent.mm.plugin.luckymoney.model.j;
import com.tencent.mm.plugin.luckymoney.model.k;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.r.b;

public class LuckyMoneyIndexUI
  extends LuckyMoneyBaseUI
{
  private int mChannel;
  private LinearLayout tmp;
  private LinearLayout tmq;
  private LinearLayout tmr;
  
  private void cMv()
  {
    AppMethodBeat.i(65606);
    a.cKP();
    j localj = a.cKQ().cLt();
    if (localj == null)
    {
      AppMethodBeat.o(65606);
      return;
    }
    ImageView localImageView = (ImageView)findViewById(2131301834);
    if ((localj.tdb & 0x1) == 1)
    {
      ad.i("MicroMsg.LuckyMoneyIndexUI", "initView: topBg use money bg");
      localImageView.setImageResource(2131233038);
      AppMethodBeat.o(65606);
      return;
    }
    localImageView.setImageResource(2131233039);
    AppMethodBeat.o(65606);
  }
  
  public int getLayoutId()
  {
    return 2131494645;
  }
  
  public void initView()
  {
    AppMethodBeat.i(65605);
    setMMTitle(2131760973);
    setBackBtn(new LuckyMoneyIndexUI.1(this));
    this.tmp = ((LinearLayout)findViewById(2131301833));
    this.tmq = ((LinearLayout)findViewById(2131301831));
    this.tmr = ((LinearLayout)findViewById(2131301828));
    ((Button)findViewById(2131301832)).setOnClickListener(new LuckyMoneyIndexUI.2(this));
    ((Button)findViewById(2131301830)).setOnClickListener(new LuckyMoneyIndexUI.3(this));
    addTextOptionMenu(0, getString(2131760892), new LuckyMoneyIndexUI.4(this), null, r.b.FOI);
    cMv();
    AppMethodBeat.o(65605);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65603);
    super.onCreate(paramBundle);
    ((b)g.ab(b.class)).a(this, null);
    initView();
    doSceneProgress(new ai("v1.0", ((Integer)g.afB().afk().get(ae.a.Fsj, Integer.valueOf(0))).intValue(), (byte)0), false);
    this.mChannel = getIntent().getIntExtra("pay_channel", -1);
    com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    AppMethodBeat.o(65603);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(65604);
    super.onResume();
    b localb = (b)g.ab(b.class);
    localb.a(this, localb.efN(), null);
    AppMethodBeat.o(65604);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(65607);
    if ((paramn instanceof ai))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ai)paramn;
        paramn = new h.c();
        paramn.textColor = getResources().getColor(2131100589);
        paramn.tov = 101;
        h.a(this, this.tmp, paramString.tdy, paramn, "Text");
        paramn = new h.c();
        paramn.textColor = getResources().getColor(2131100589);
        paramn.tov = 100;
        h.a(this, this.tmq, paramString.tfp, paramn, "Text");
        paramn = new h.c();
        paramn.tov = 102;
        h.a(this, this.tmr, paramString.tfn, paramn, "Pic");
        cMv();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyIndexUI
 * JD-Core Version:    0.7.0.1
 */