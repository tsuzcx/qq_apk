package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.j;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.plugin.luckymoney.b.ad;
import com.tencent.mm.plugin.luckymoney.b.ag;
import com.tencent.mm.plugin.luckymoney.b.f;
import com.tencent.mm.plugin.luckymoney.b.w;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.io.IOException;

@j
@com.tencent.mm.ui.base.a(3)
public class LuckyMoneyReceiveUI
  extends LuckyMoneyBaseUI
{
  private TextView iKV;
  private long iaq = 0L;
  private String kPX;
  private ImageView lLV;
  private TextView lMM;
  Button lMN;
  private View lMO;
  private ImageView lMP;
  private TextView lMQ;
  private View lMR;
  private ImageView lOR;
  ag lRQ;
  private String lUA;
  private String lUy;
  private com.tencent.mm.plugin.wallet_core.model.y lXz = null;
  private TextView lly;
  private int maxSize = 0;
  private int textSize = 0;
  private p tipDialog = null;
  
  private void a(ad paramad)
  {
    f localf = paramad.lQZ;
    Object localObject;
    if (localf.ced == 2)
    {
      localObject = new Intent();
      ((Intent)localObject).setClass(this.mController.uMN, LuckyMoneyDetailUI.class);
      try
      {
        ((Intent)localObject).putExtra("key_detail_info", paramad.lQZ.toByteArray());
        ((Intent)localObject).putExtra("key_jump_from", 2);
        ((Intent)localObject).putExtra("key_native_url", paramad.ceb);
        ((Intent)localObject).putExtra("key_sendid", paramad.lMg);
        if (com.tencent.mm.m.g.AA().getInt("PlayCoinSound", 0) > 0) {
          ((Intent)localObject).putExtra("play_sound", true);
        }
        if (paramad.lMW != null) {
          ((Intent)localObject).putExtra("key_realname_guide_helper", paramad.lMW);
        }
        startActivity((Intent)localObject);
        paramad = new com.tencent.mm.plugin.wallet_core.model.y();
        paramad.field_mNativeUrl = this.lUA;
        paramad.field_hbType = localf.lPR;
        paramad.field_receiveAmount = localf.ceq;
        paramad.field_receiveTime = System.currentTimeMillis();
        paramad.field_hbStatus = localf.cec;
        paramad.field_receiveStatus = localf.ced;
        if (paramad.field_receiveAmount > 0L) {
          com.tencent.mm.plugin.wallet_core.model.o.bVp().a(paramad);
        }
        finish();
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.y.w("MicroMsg.LuckyMoneyReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + localIOException.getLocalizedMessage());
        }
      }
    }
    this.lMN.setBackgroundResource(a.e.lucky_money_receive_open_disabled_btn);
    this.lMN.setText(a.i.lucky_money_open);
    this.lMN.setOnClickListener(null);
    this.lMN.setVisibility(8);
    if (!bk.bl(localf.lNs))
    {
      this.iKV.setText(localf.lNs);
      this.iKV.setVisibility(0);
    }
    for (;;)
    {
      this.lly.setText(localf.lPS);
      localObject = (RelativeLayout.LayoutParams)this.lMO.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = BackwardSupportUtil.b.b(this.mController.uMN, 30.0F);
      this.lMO.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if ((!com.tencent.mm.model.q.Gj().equals(this.kPX)) && (localf.lPR != 1)) {
        break;
      }
      this.lMO.setVisibility(0);
      this.lMO.setOnClickListener(new LuckyMoneyReceiveUI.8(this, paramad));
      this.lMP.setVisibility(8);
      return;
      this.iKV.setVisibility(8);
    }
    this.lMO.setVisibility(8);
    this.lMP.setVisibility(0);
  }
  
  private void bfv()
  {
    if (this.lMN == null) {}
    String str;
    do
    {
      return;
      b.mGK.vs(this.lMN.getId());
      str = x.d(ae.getContext().getSharedPreferences(ae.cqR(), 0));
    } while ((str != null) && (str.length() > 0) && ((str.equals("zh_CN")) || (str.equals("zh_TW")) || (str.equals("zh_HK"))));
    this.lMN.setBackgroundResource(a.e.lucky_money_send_btn);
    this.lMN.setText(a.i.lucky_money_open_title);
  }
  
  private int bgr()
  {
    if (com.tencent.mm.model.q.Gj().equals(this.kPX)) {
      return 1;
    }
    return 0;
  }
  
  private static int tu(int paramInt)
  {
    if (paramInt == 1) {
      return 1;
    }
    if (paramInt == 0) {
      return 2;
    }
    return 0;
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int i = 0;
    if ((paramm instanceof ag)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.lRQ = ((ag)paramm);
        com.tencent.mm.plugin.report.service.h.nFQ.f(11701, new Object[] { Integer.valueOf(5), Integer.valueOf(tu(this.lRQ.lPR)), Integer.valueOf(bgr()), Integer.valueOf(0), Integer.valueOf(1) });
        paramString = new com.tencent.mm.plugin.wallet_core.model.y();
        paramString.field_mNativeUrl = this.lUA;
        paramString.field_hbType = this.lRQ.lPR;
        paramString.field_hbStatus = this.lRQ.cec;
        paramString.field_receiveStatus = this.lRQ.ced;
        com.tencent.mm.plugin.wallet_core.model.o.bVp().a(paramString);
        if (this.lRQ.ced == 2) {
          b(new w(this.lUy, 11, 0, this.lUA, "v1.0"), false);
        }
      }
    }
    for (;;)
    {
      return true;
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.hide();
      }
      com.tencent.mm.plugin.luckymoney.b.o.a(this.lLV, this.lRQ.lPV, this.lRQ.lQp);
      com.tencent.mm.plugin.luckymoney.b.o.a(this.mController.uMN, this.lMM, this.lRQ.lRI);
      boolean bool;
      if ((this.lRQ.ced != 1) && (this.lRQ.cec != 4) && (this.lRQ.cec != 5) && (this.lRQ.cec != 1))
      {
        if (!bk.bl(this.lRQ.lPS))
        {
          this.iKV.setText(this.lRQ.lPS);
          this.iKV.setVisibility(0);
        }
        if (!bk.bl(this.lRQ.lLm))
        {
          com.tencent.mm.plugin.luckymoney.b.o.a(this.mController.uMN, this.lly, this.lRQ.lLm);
          this.lly.setVisibility(0);
        }
        this.lMN.setOnClickListener(new LuckyMoneyReceiveUI.3(this));
        bool = false;
        if ((!com.tencent.mm.model.q.Gj().equals(this.kPX)) && ((this.lRQ.lPR != 1) || (!bool))) {
          break label752;
        }
        if (this.lRQ.lPR == 1) {
          this.lMQ.setText(a.i.lucky_money_detail_luck);
        }
        this.lMO.setVisibility(0);
        this.lMO.setOnClickListener(new LuckyMoneyReceiveUI.4(this, bool));
        this.lMP.setVisibility(8);
      }
      for (;;)
      {
        com.tencent.mm.plugin.luckymoney.b.o.a(this.lMR, null);
        this.mController.contentView.setVisibility(0);
        if ((this.lRQ.cec != 5) || (paramString.field_receiveAmount <= 0L)) {
          break;
        }
        this.lMP.setVisibility(8);
        this.lMO.setVisibility(0);
        this.iKV.setVisibility(0);
        this.iKV.setText(a.i.lucky_money_send_for_you);
        this.lly.setVisibility(8);
        findViewById(a.f.lucky_money_receive_money).setVisibility(0);
        ((WalletTextView)findViewById(a.f.lucky_money_detail_amount)).setText(com.tencent.mm.wallet_core.ui.e.A(paramString.field_receiveAmount / 100.0D));
        this.lMO.setOnClickListener(new LuckyMoneyReceiveUI.5(this));
        return true;
        this.lMN.setBackgroundResource(a.e.lucky_money_receive_open_disabled_btn);
        this.lMN.setText(a.i.lucky_money_open);
        this.lMN.setOnClickListener(null);
        this.lMN.setVisibility(8);
        if (!bk.bl(this.lRQ.lNs))
        {
          this.iKV.setText(this.lRQ.lNs);
          this.iKV.setVisibility(0);
        }
        for (;;)
        {
          this.lly.setText(this.lRQ.lPS);
          paramm = (RelativeLayout.LayoutParams)this.lMO.getLayoutParams();
          paramm.bottomMargin = BackwardSupportUtil.b.b(this.mController.uMN, 30.0F);
          this.lMO.setLayoutParams(paramm);
          bool = true;
          break;
          this.iKV.setVisibility(8);
        }
        label752:
        this.lMO.setVisibility(8);
        this.lMP.setVisibility(0);
      }
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.hide();
      }
      return false;
      if (!(paramm instanceof ad)) {
        break label969;
      }
      com.tencent.mm.plugin.luckymoney.b.o.d(this.lMN);
      bfv();
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break;
      }
      paramString = (ad)paramm;
      if (paramString.lQQ == null) {}
      for (paramInt1 = i; (paramInt1 == 0) || (!paramString.lQQ.a(this, new LuckyMoneyReceiveUI.6(this, paramString))); paramInt1 = 1)
      {
        a(paramString);
        return true;
      }
    }
    if (paramInt2 == 416)
    {
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.hide();
      }
      paramString = new Bundle();
      paramString.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyReceiveUI");
      paramString.putString("realname_verify_process_jump_plugin", "luckymoney");
      this.lMN.setBackgroundResource(a.e.festival_lucky_money_open_btn);
      new LuckyMoneyReceiveUI.7(this);
      return com.tencent.mm.plugin.luckymoney.b.o.a(this, paramInt2, paramm, paramString, false, null, 1003);
      label969:
      if ((paramm instanceof w))
      {
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.hide();
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramm = (w)paramm;
          paramString = new Intent();
          paramString.setClass(this.mController.uMN, LuckyMoneyDetailUI.class);
          try
          {
            paramString.putExtra("key_detail_info", paramm.lQZ.toByteArray());
            paramString.putExtra("key_jump_from", 2);
            paramString.putExtra("key_native_url", this.lUA);
            paramString.putExtra("key_sendid", this.lUy);
            startActivity(paramString);
            finish();
            return true;
          }
          catch (IOException paramm)
          {
            for (;;)
            {
              com.tencent.mm.sdk.platformtools.y.w("MicroMsg.LuckyMoneyReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + paramm.getLocalizedMessage());
            }
          }
        }
        com.tencent.mm.ui.base.h.bC(this, paramString);
        finish();
        return true;
      }
    }
    return false;
  }
  
  protected final int getLayoutId()
  {
    return a.g.lucky_money_receive_ui;
  }
  
  protected final void initView()
  {
    this.lMR = findViewById(a.f.lucky_money_receive_ll);
    this.lLV = ((ImageView)findViewById(a.f.lucky_money_receive_sender_avatar));
    this.lMM = ((TextView)findViewById(a.f.lucky_money_receive_sender_nickname));
    this.iKV = ((TextView)findViewById(a.f.lucky_money_receive_tips));
    this.lly = ((TextView)findViewById(a.f.lucky_money_receive_wishing));
    this.lMN = ((Button)findViewById(a.f.lucky_money_recieve_open));
    this.lMQ = ((TextView)findViewById(a.f.lucky_money_recieve_check_detail));
    this.lMO = findViewById(a.f.lucky_money_recieve_check_detail_ll);
    this.lMP = ((ImageView)findViewById(a.f.lucky_money_bottom_decoration));
    this.lOR = ((ImageView)findViewById(a.f.lucky_money_recieve_close_btn));
    this.lOR.setOnClickListener(new LuckyMoneyReceiveUI.1(this));
    this.maxSize = ((int)(com.tencent.mm.cb.a.ab(this.mController.uMN, a.d.lucky_money_goldstyle_envelop_wishing_textsize) * 1.375F));
    this.textSize = com.tencent.mm.cb.a.aa(this.mController.uMN, a.d.lucky_money_goldstyle_envelop_wishing_textsize);
    if (this.textSize > this.maxSize) {}
    for (int i = this.maxSize;; i = this.textSize)
    {
      this.textSize = i;
      this.lly.setTextSize(0, this.textSize);
      this.mController.contentView.setVisibility(8);
      this.tipDialog = com.tencent.mm.ui.base.h.b(this.mController.uMN, getString(a.i.loading_tips), true, new LuckyMoneyReceiveUI.2(this));
      bfv();
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.lUA = getIntent().getStringExtra("key_native_url");
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LuckyMoneyReceiveUI", "nativeUrl= " + bk.pm(this.lUA));
    initView();
    paramBundle = Uri.parse(bk.pm(this.lUA));
    try
    {
      this.lUy = paramBundle.getQueryParameter("sendid");
      label72:
      this.lXz = com.tencent.mm.plugin.wallet_core.model.o.bVp().QC(this.lUA);
      if ((this.lXz != null) && (this.lXz.field_receiveAmount > 0L) && (bk.co(this.lXz.field_receiveTime) < 86400000L))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LuckyMoneyReceiveUI", "use cache this item %s %s", new Object[] { Long.valueOf(this.lXz.field_receiveTime), bk.pm(this.lUA) });
        paramBundle = new Intent();
        paramBundle.setClass(this.mController.uMN, LuckyMoneyDetailUI.class);
        paramBundle.putExtra("key_native_url", this.lXz.field_mNativeUrl);
        paramBundle.putExtra("key_sendid", this.lUy);
        startActivity(paramBundle);
        finish();
      }
      do
      {
        return;
        if (bk.bl(this.lUy)) {
          break;
        }
        int i = bk.getInt(paramBundle.getQueryParameter("channelid"), 1);
        this.kPX = paramBundle.getQueryParameter("sendusername");
        b(new ag(i, this.lUy, this.lUA, getIntent().getIntExtra("key_way", 0), "v1.0"), false);
      } while (this.tipDialog == null);
      this.tipDialog.show();
      return;
      finish();
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.LuckyMoneyReceiveUI", "sendid null & finish");
      return;
    }
    catch (Exception localException)
    {
      break label72;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    d.h("LuckyMoneyReceiveUI", this.iaq, bk.UX());
  }
  
  protected void onResume()
  {
    super.onResume();
    this.iaq = bk.UX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyReceiveUI
 * JD-Core Version:    0.7.0.1
 */