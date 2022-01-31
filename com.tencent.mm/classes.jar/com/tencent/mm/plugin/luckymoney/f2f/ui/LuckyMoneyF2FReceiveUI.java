package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.luckymoney.b.f;
import com.tencent.mm.plugin.luckymoney.f2f.a.c;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.bjg;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import java.io.IOException;

@a(3)
public class LuckyMoneyF2FReceiveUI
  extends LuckyMoneyBaseUI
{
  private int amount;
  private DisplayMetrics eRM;
  private String jxR;
  private String lMg;
  private ImageView lNO;
  private TextView lNP;
  private String lNn;
  private String lNs;
  private View lOP;
  private TextView lOQ;
  private ImageView lOR;
  private ValueAnimator lOS;
  private ValueAnimator lOT;
  private Intent lOU;
  private boolean lOV = false;
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("LuckyMoneyF2FReceiveUI", "errType: %d,errCode: %d,errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!(paramm instanceof c)) {
      return true;
    }
    Object localObject1 = (c)paramm;
    paramInt1 = ((c)localObject1).cec;
    paramInt2 = ((c)localObject1).lNm;
    this.amount = ((c)localObject1).amount;
    int i = ((c)localObject1).lNp;
    Object localObject2 = ((c)localObject1).lNq;
    String str = ((c)localObject1).lNr;
    y.i("LuckyMoneyF2FReceiveUI", "hbStatus: %d, recvStatus:%d, errorType:%d", new Object[] { Integer.valueOf(((c)localObject1).cec), Integer.valueOf(((c)localObject1).lNm), Integer.valueOf(((c)localObject1).bIC) });
    if (paramInt2 == 2)
    {
      if (paramInt1 == 5) {
        com.tencent.mm.ui.base.h.a(this, getString(a.i.lucky_money_f2f_has_expired), "", new LuckyMoneyF2FReceiveUI.5(this));
      }
      for (;;)
      {
        return true;
        this.lMg = ((c)localObject1).lMg;
        this.lNn = ((c)localObject1).lNn;
        this.lNs = ((c)localObject1).lNs;
        this.lOU = new Intent();
        if ((!bk.bl(this.lNn)) && (!com.tencent.mm.model.s.hk(this.lNn)))
        {
          paramString = new com.tencent.mm.ag.h();
          paramString.username = this.lNn;
          com.tencent.mm.ag.o.Kh().a(paramString);
        }
        com.tencent.mm.plugin.luckymoney.b.o.a(this.lNO, null, this.lNn);
        paramString = new f();
        paramString.ceq = this.amount;
        paramString.lMg = this.lMg;
        paramString.cec = paramInt1;
        paramString.ced = paramInt2;
        paramString.lNr = str;
        paramString.lNp = i;
        paramString.lQp = this.lNn;
        paramString.lNq = ((String)localObject2);
        paramString.lPU = com.tencent.mm.plugin.luckymoney.b.o.gU(this.lNn);
        paramString.lNs = this.lNs;
        paramString.lPR = 2;
        y.i("LuckyMoneyF2FReceiveUI", "is most lucky %d", new Object[] { Integer.valueOf(((c)localObject1).lNt) });
        if (((c)localObject1).lNt > 0) {
          paramString.lPT = getString(a.i.lucky_money_lucky_best);
        }
        paramString.lPV = com.tencent.mm.plugin.luckymoney.b.o.GN(this.lNn);
        try
        {
          this.lOU.putExtra("key_detail_info", paramString.toByteArray());
          paramString = ((c)localObject1).lNo;
          if (paramString != null)
          {
            localObject1 = new RealnameGuideHelper();
            ((RealnameGuideHelper)localObject1).a(String.valueOf(paramString.ssk), paramString.lRD, paramString.lRE, paramString.lRF, paramString.lRG, paramm.getType());
            this.lOU.putExtra("key_realname_guide_helper", (Parcelable)localObject1);
          }
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            y.e("LuckyMoneyF2FReceiveUI", "lucky detail toBytes error: " + paramString.getMessage());
          }
        }
        if (!bk.H(new String[] { this.lMg, this.lNn }))
        {
          com.tencent.mm.plugin.luckymoney.b.o.a(this, this.lNP, com.tencent.mm.plugin.luckymoney.b.o.gU(this.lNn));
          com.tencent.mm.plugin.luckymoney.b.o.a(this, this.lOQ, this.lNs);
          this.lOS.start();
          this.mController.contentView.setVisibility(0);
        }
      }
    }
    if (((c)localObject1).lNo != null)
    {
      y.i("LuckyMoneyF2FReceiveUI", "need real name verify");
      localObject2 = ((c)localObject1).lNo;
      localObject1 = new RealnameGuideHelper();
      ((RealnameGuideHelper)localObject1).a(String.valueOf(((bjg)localObject2).ssk), ((bjg)localObject2).lRD, ((bjg)localObject2).lRE, ((bjg)localObject2).lRF, ((bjg)localObject2).lRG, paramm.getType());
      paramm = new Bundle();
      paramm.putString("realname_verify_process_jump_activity", ".f2f.ui.LuckyMoneyF2FReceiveUI");
      paramm.putString("realname_verify_process_jump_plugin", "luckymoney");
      if (((RealnameGuideHelper)localObject1).a(this, paramm, new LuckyMoneyF2FReceiveUI.6(this), new LuckyMoneyF2FReceiveUI.7(this), false))
      {
        this.lOV = true;
        return true;
      }
    }
    paramm = paramString;
    if (bk.bl(paramString)) {
      paramm = getString(a.i.lucky_money_f2f_receive_fail);
    }
    com.tencent.mm.ui.base.h.a(this, paramm, "", new LuckyMoneyF2FReceiveUI.8(this));
    return true;
  }
  
  protected final int getLayoutId()
  {
    return a.g.lucky_money_f2f_receive_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.lOP = findViewById(a.f.lucky_money_receive_ll);
    this.lNO = ((ImageView)findViewById(a.f.lucky_money_receive_sender_avatar));
    this.lNP = ((TextView)findViewById(a.f.lucky_money_receive_sender_nickname));
    this.lOQ = ((TextView)findViewById(a.f.lucky_money_receive_tips));
    this.lOR = ((ImageView)findViewById(a.f.lucky_money_recieve_close_btn));
    this.lOR.setOnClickListener(new LuckyMoneyF2FReceiveUI.1(this));
    this.mController.contentView.setVisibility(8);
    this.jxR = getIntent().getStringExtra("key_share_url");
    com.tencent.mm.plugin.wallet_core.model.i.AN(6);
    b(new c(this.jxR), true);
    this.eRM = getResources().getDisplayMetrics();
    this.lOS = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F }).setDuration(300L);
    this.lOT = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(300L);
    this.lOT.setStartDelay(1000L);
    this.lOS.addUpdateListener(new LuckyMoneyF2FReceiveUI.2(this));
    this.lOS.addListener(new LuckyMoneyF2FReceiveUI.3(this));
    this.lOT.addListener(new LuckyMoneyF2FReceiveUI.4(this));
  }
  
  protected void onResume()
  {
    super.onResume();
    kh(1997);
    if (this.lOV) {
      finish();
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    ki(1997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FReceiveUI
 * JD-Core Version:    0.7.0.1
 */