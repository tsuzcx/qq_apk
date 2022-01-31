package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.luckymoney.a.a;
import com.tencent.mm.plugin.luckymoney.b.d;
import com.tencent.mm.plugin.luckymoney.b.e;
import com.tencent.mm.plugin.luckymoney.b.x;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.s.b;

public class LuckyMoneyIndexUI
  extends LuckyMoneyBaseUI
{
  private int lTG;
  private LinearLayout lVA;
  private LinearLayout lVB;
  private LinearLayout lVC;
  
  private void bgh()
  {
    a.bfg();
    d locald = a.bfh().bfG();
    if (locald == null) {
      return;
    }
    ImageView localImageView = (ImageView)findViewById(a.f.lucky_money_index_top_decoration);
    if ((locald.lPO & 0x1) == 1)
    {
      y.i("MicroMsg.LuckyMoneyIndexUI", "initView: topBg use money bg");
      localImageView.setImageResource(a.e.lucky_money_index_top_decoration);
      return;
    }
    localImageView.setImageResource(a.e.lucky_money_index_topbg_temporary);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof x))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (x)paramm;
        paramm = new g.c();
        paramm.textColor = getResources().getColor(a.c.lucky_money_index_operation_text_color);
        paramm.lWW = 101;
        g.a(this, this.lVA, paramString.lQj, paramm, "Text");
        paramm = new g.c();
        paramm.textColor = getResources().getColor(a.c.lucky_money_index_operation_text_color);
        paramm.lWW = 100;
        g.a(this, this.lVB, paramString.lRs, paramm, "Text");
        paramm = new g.c();
        paramm.lWW = 102;
        g.a(this, this.lVC, paramString.lRq, paramm, "Pic");
        bgh();
      }
      return true;
    }
    return false;
  }
  
  protected final int getLayoutId()
  {
    return a.g.lucky_money_index_ui;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.lucky_money_title);
    setBackBtn(new LuckyMoneyIndexUI.1(this));
    this.lVA = ((LinearLayout)findViewById(a.f.lucky_money_index_tail_opertaion));
    this.lVB = ((LinearLayout)findViewById(a.f.lucky_money_index_middle_opertaion));
    this.lVC = ((LinearLayout)findViewById(a.f.lucky_money_index_banner_opertaion));
    ((Button)findViewById(a.f.lucky_money_index_normal)).setOnClickListener(new LuckyMoneyIndexUI.2(this));
    ((Button)findViewById(a.f.lucky_money_index_group)).setOnClickListener(new LuckyMoneyIndexUI.3(this));
    a(0, getString(a.i.lucky_money_mine_title), new LuckyMoneyIndexUI.4(this), s.b.uNE);
    bgh();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ((b)com.tencent.mm.kernel.g.r(b.class)).a(this, null);
    initView();
    b(new x("v1.0", (byte)0), false);
    this.lTG = getIntent().getIntExtra("pay_channel", -1);
    h.nFQ.f(11701, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
  }
  
  protected void onResume()
  {
    super.onResume();
    b localb = (b)com.tencent.mm.kernel.g.r(b.class);
    localb.a(this, localb.bXL(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyIndexUI
 * JD-Core Version:    0.7.0.1
 */