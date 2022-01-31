package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.aph;
import com.tencent.mm.protocal.c.bhi;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.c.n.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.io.IOException;

public class HoneyPayReceiveCardUI
  extends HoneyPayBaseUI
{
  private int fzn;
  private String lki;
  private ImageView llW;
  private TextView llX;
  private TextView llY;
  private TextView llZ;
  private TextView lma;
  private TextView lmb;
  private TextView lmc;
  private TextView lmd;
  private TextView lme;
  private TextView lmf;
  private LinearLayout lmg;
  private CdnImageView lmh;
  private g lmi = new HoneyPayReceiveCardUI.1(this);
  
  private void a(bhi parambhi)
  {
    if (parambhi.tei == null) {
      return;
    }
    aph localaph = parambhi.tei;
    this.lmb.setText(localaph.tlk);
    this.lmd.setText(j.a(this.mController.uMN, localaph.lLm, this.lmd.getTextSize()));
    Object localObject = new Bundle();
    ((Bundle)localObject).putBoolean("click_help", true);
    this.lme.setText(j.a(this.mController.uMN, localaph.nvB, (int)this.lme.getTextSize(), localObject));
    this.lme.setClickable(true);
    this.lme.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m(this));
    if (!bk.bl(parambhi.tzw))
    {
      localObject = new com.tencent.mm.plugin.wallet_core.ui.m(new HoneyPayReceiveCardUI.9(this, parambhi));
      parambhi = new SpannableString(parambhi.tzw);
      parambhi.setSpan(localObject, 0, parambhi.length(), 18);
      this.llZ.setText(parambhi);
      this.llZ.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m(this));
      this.llZ.setClickable(true);
      this.llY.setText(localaph.imz);
      a.b.a(this.llW, localaph.srM, 0.06F, false);
      com.tencent.mm.wallet_core.ui.e.f(this.llX, localaph.srM);
      com.tencent.mm.wallet_core.ui.e.f(this.lmf, localaph.srM);
      if (localaph.ilo != 1) {
        break label329;
      }
      this.lmc.setText(a.i.honey_pay_father_type);
    }
    for (;;)
    {
      if (bk.bl(localaph.iQn)) {
        break label379;
      }
      parambhi = this.lmh;
      localObject = localaph.iQn;
      i = localaph.ilo;
      parambhi.dl((String)localObject, c.baT());
      return;
      y.d(this.TAG, "no help url");
      this.llZ.setVisibility(8);
      break;
      label329:
      if (localaph.ilo == 2) {
        this.lmc.setText(a.i.honey_pay_mother_type);
      } else {
        this.lmc.setText(j.a(this, com.tencent.mm.wallet_core.ui.e.dP(q.Gl(), 16), this.lmc.getTextSize()));
      }
    }
    label379:
    parambhi = this.lmh;
    int i = localaph.ilo;
    parambhi.setImageResource(c.baT());
  }
  
  private void baW()
  {
    y.i(this.TAG, "qry user detail");
    com.tencent.mm.plugin.honey_pay.a.m localm = new com.tencent.mm.plugin.honey_pay.a.m(this.lki);
    localm.m(this);
    a(localm, true, false);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if ((paramm instanceof com.tencent.mm.plugin.honey_pay.a.m))
    {
      paramString = (com.tencent.mm.plugin.honey_pay.a.m)paramm;
      paramString.a(new HoneyPayReceiveCardUI.5(this, paramString)).b(new HoneyPayReceiveCardUI.4(this)).c(new n.a()
      {
        public final void f(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ah.m paramAnonymousm) {}
      });
    }
    for (;;)
    {
      return true;
      if ((paramm instanceof com.tencent.mm.plugin.honey_pay.a.e))
      {
        paramString = (com.tencent.mm.plugin.honey_pay.a.e)paramm;
        paramString.a(new HoneyPayReceiveCardUI.8(this, paramString)).b(new HoneyPayReceiveCardUI.7(this, paramString)).c(new HoneyPayReceiveCardUI.6(this));
      }
    }
  }
  
  protected final int getLayoutId()
  {
    return a.g.honey_pay_receive_card_ui;
  }
  
  protected final void initView()
  {
    this.llW = ((ImageView)findViewById(a.f.hprc_avatar_iv));
    this.llX = ((TextView)findViewById(a.f.hprc_payer_name_tv));
    this.lmc = ((TextView)findViewById(a.f.hprc_user_name_tv));
    this.llY = ((TextView)findViewById(a.f.hprc_quota_desc_tv));
    this.lmf = ((TextView)findViewById(a.f.hprc_quota_username_tv));
    this.llZ = ((TextView)findViewById(a.f.hprc_check_payway_tv));
    this.lma = ((TextView)findViewById(a.f.hprc_receive_btn));
    this.lmb = ((TextView)findViewById(a.f.hprc_receive_tip_tv));
    this.lmg = ((LinearLayout)findViewById(a.f.hprc_quota_layout));
    this.lmd = ((TextView)findViewById(a.f.hprc_wishing_tv));
    this.lme = ((TextView)findViewById(a.f.hprc_explain_tv));
    this.lmh = ((CdnImageView)findViewById(a.f.hprc_quota_logo_1_iv));
    this.lma.setOnClickListener(new HoneyPayReceiveCardUI.2(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.lkb = a.c.honey_pay_grey_bg_2;
    super.onCreate(paramBundle);
    j.a(this.lmi);
    kh(2613);
    kh(1983);
    this.lki = getIntent().getStringExtra("key_card_no");
    this.fzn = getIntent().getIntExtra("key_scene", 0);
    initView();
    if (this.fzn == 1)
    {
      paramBundle = new bhi();
      try
      {
        paramBundle.aH(getIntent().getByteArrayExtra("key_qry_response"));
        a(paramBundle);
        if (paramBundle.tei != null) {
          setMMTitle(paramBundle.tei.imz);
        }
        return;
      }
      catch (IOException paramBundle)
      {
        y.printErrStackTrace(this.TAG, paramBundle, "", new Object[0]);
        baW();
        return;
      }
    }
    baW();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    j.b(this.lmi);
    ki(2613);
    ki(1983);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayReceiveCardUI
 * JD-Core Version:    0.7.0.1
 */