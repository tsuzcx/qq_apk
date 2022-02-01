package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.luckymoney.b.a;
import com.tencent.mm.plugin.luckymoney.model.ai;
import com.tencent.mm.plugin.luckymoney.model.j;
import com.tencent.mm.plugin.luckymoney.model.k;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.s.b;

public class LuckyMoneyIndexUI
  extends LuckyMoneyBaseUI
{
  private int mChannel;
  private LinearLayout uuI;
  private LinearLayout uuJ;
  private LinearLayout uuK;
  
  private void dab()
  {
    AppMethodBeat.i(65606);
    a.cYv();
    j localj = a.cYw().cYZ();
    if (localj == null)
    {
      AppMethodBeat.o(65606);
      return;
    }
    ImageView localImageView = (ImageView)findViewById(2131301834);
    if ((localj.ulq & 0x1) == 1)
    {
      ac.i("MicroMsg.LuckyMoneyIndexUI", "initView: topBg use money bg");
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
    this.uuI = ((LinearLayout)findViewById(2131301833));
    this.uuJ = ((LinearLayout)findViewById(2131301831));
    this.uuK = ((LinearLayout)findViewById(2131301828));
    ((Button)findViewById(2131301832)).setOnClickListener(new LuckyMoneyIndexUI.2(this));
    ((Button)findViewById(2131301830)).setOnClickListener(new LuckyMoneyIndexUI.3(this));
    addTextOptionMenu(0, getString(2131760892), new LuckyMoneyIndexUI.4(this), null, s.b.Hot);
    dab();
    AppMethodBeat.o(65605);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65603);
    super.onCreate(paramBundle);
    ((b)g.ab(b.class)).a(this, null);
    initView();
    doSceneProgress(new ai("v1.0", ((Integer)g.agR().agA().get(ah.a.GQa, Integer.valueOf(0))).intValue(), (byte)0), false);
    this.mChannel = getIntent().getIntExtra("pay_channel", -1);
    com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    AppMethodBeat.o(65603);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(65604);
    super.onResume();
    b localb = (b)g.ab(b.class);
    localb.a(this, localb.evh(), null);
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
        paramn.uwN = 101;
        h.a(this, this.uuI, paramString.ulN, paramn, "Text");
        paramn = new h.c();
        paramn.textColor = getResources().getColor(2131100589);
        paramn.uwN = 100;
        h.a(this, this.uuJ, paramString.unE, paramn, "Text");
        paramn = new h.c();
        paramn.uwN = 102;
        h.a(this, this.uuK, paramString.unC, paramn, "Pic");
        dab();
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