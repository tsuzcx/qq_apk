package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.br.d;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.luckymoney.b.ah;
import com.tencent.mm.plugin.luckymoney.b.f;
import com.tencent.mm.plugin.luckymoney.b.j;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.luckymoney.b.t;
import com.tencent.mm.plugin.luckymoney.b.u;
import com.tencent.mm.plugin.luckymoney.b.w;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import java.io.IOException;

@com.tencent.mm.ui.base.a(3)
public class LuckyMoneyBusiReceiveUI
  extends LuckyMoneyBaseUI
{
  private TextView lLM;
  private ImageView lLV;
  private TextView lMM;
  private Button lMN;
  private View lMR;
  private ImageView lOR;
  private String lUA = null;
  private int lUC = 0;
  private TextView lUK;
  private TextView lUL;
  private View lUM;
  private ImageView lUN;
  private TextView lUO;
  private View lUP;
  private TextView lUQ;
  private Button lUR;
  private TextView lUS;
  private CheckBox lUT;
  private int lUU;
  private String lUV = null;
  private int lUW = 0;
  private u lUX;
  private RealnameGuideHelper lUY;
  private String lUy = null;
  private com.tencent.mm.ui.base.p tipDialog = null;
  
  private void at(int paramInt, String paramString)
  {
    y.i("MicroMsg.LuckyMoneyBusiReceiveUI", "markResult resultCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    Intent localIntent = new Intent();
    localIntent.putExtra("key_result_errmsg", paramString);
    setResult(paramInt, localIntent);
  }
  
  private void init()
  {
    this.tipDialog = com.tencent.mm.ui.base.h.b(this.mController.uMN, getString(a.i.loading_tips), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        if ((LuckyMoneyBusiReceiveUI.a(LuckyMoneyBusiReceiveUI.this) != null) && (LuckyMoneyBusiReceiveUI.a(LuckyMoneyBusiReceiveUI.this).isShowing())) {
          LuckyMoneyBusiReceiveUI.a(LuckyMoneyBusiReceiveUI.this).dismiss();
        }
        LuckyMoneyBusiReceiveUI.this.lUq.bfH();
        if ((LuckyMoneyBusiReceiveUI.b(LuckyMoneyBusiReceiveUI.this).getVisibility() == 8) || (LuckyMoneyBusiReceiveUI.c(LuckyMoneyBusiReceiveUI.this).getVisibility() == 4))
        {
          y.i("MicroMsg.LuckyMoneyBusiReceiveUI", "user cancel & finish");
          LuckyMoneyBusiReceiveUI.this.finish();
        }
      }
    });
    if (this.lUU == 3) {
      b(new com.tencent.mm.plugin.luckymoney.b.s(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url")), false);
    }
    for (;;)
    {
      at(0, "");
      return;
      if (this.lUU == 4)
      {
        b(new com.tencent.mm.plugin.luckymoney.b.s(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("key_wxapi_sign"), getIntent().getStringExtra("key_wxapi_package_name")), false);
        continue;
      }
      try
      {
        this.lUy = Uri.parse(bk.pm(this.lUA)).getQueryParameter("sendid");
        label235:
        if (!bk.bl(this.lUy))
        {
          b(new u(this.lUy, this.lUA, this.lUU, getIntent().getStringExtra("packageExt")), false);
          continue;
        }
        finish();
        y.w("MicroMsg.LuckyMoneyBusiReceiveUI", "sendid null & finish");
      }
      catch (Exception localException)
      {
        break label235;
      }
    }
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof u))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.lUX = ((u)paramm);
        this.lUy = this.lUX.lMg;
        this.lUW = this.lUX.lPR;
        com.tencent.mm.plugin.report.service.h.nFQ.f(13050, new Object[] { Integer.valueOf(this.lUC), Integer.valueOf(1), this.lUX.lQX });
        if (this.lUX.ced == 2)
        {
          at(-1, "");
          b(new w(this.lUy, 11, 0, this.lUA, "v1.0"), false);
          return true;
        }
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.hide();
        }
        o.i(this.lLV, this.lUX.lRb);
        o.a(this.mController.uMN, this.lMM, this.lUX.lQR);
        o.g(this.lUN, this.lUX.lQk);
        if ((this.lUX.ced != 1) && (this.lUX.cec != 4) && (this.lUX.cec != 5) && (this.lUX.cec != 1)) {
          if (!bk.bl(this.lUX.lQX))
          {
            this.lUV = this.lUX.lQX;
            if (this.lUX.lQY == 1) {
              this.lUT.setVisibility(8);
            }
          }
          else
          {
            this.lMN.setOnClickListener(new LuckyMoneyBusiReceiveUI.4(this));
            if (bk.bl(this.lUX.lPS)) {
              break label460;
            }
            this.lUK.setText(this.lUX.lPS);
            label336:
            if (bk.bl(this.lUX.lRc)) {
              break label472;
            }
            this.lUL.setText(this.lUX.lRc);
          }
        }
        for (;;)
        {
          o.a(this.lMR, null);
          this.mController.contentView.setVisibility(0);
          break;
          y.i("MicroMsg.LuckyMoneyBusiReceiveUI", "show checkbox for " + this.lUX.lQX);
          if (this.lUX.lQV == 1) {
            this.lUT.setChecked(true);
          }
          for (;;)
          {
            this.lUT.setText(this.lUX.lQW);
            break;
            this.lUT.setChecked(false);
          }
          label460:
          this.lUK.setVisibility(8);
          break label336;
          label472:
          this.lUL.setVisibility(8);
          continue;
          com.tencent.mm.plugin.report.service.h.nFQ.f(11701, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
          this.lUK.setVisibility(4);
          this.lUL.setText(this.lUX.lPS);
          this.lMN.setVisibility(8);
          if (this.lUW == 1)
          {
            this.lUO.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                com.tencent.mm.plugin.report.service.h.nFQ.f(11701, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4) });
                paramAnonymousView = new Intent();
                paramAnonymousView.setClass(LuckyMoneyBusiReceiveUI.this.mController.uMN, LuckyMoneyBusiDetailUI.class);
                paramAnonymousView.putExtra("key_native_url", LuckyMoneyBusiReceiveUI.j(LuckyMoneyBusiReceiveUI.this));
                paramAnonymousView.putExtra("key_sendid", LuckyMoneyBusiReceiveUI.h(LuckyMoneyBusiReceiveUI.this).lMg);
                paramAnonymousView.putExtra("key_static_from_scene", LuckyMoneyBusiReceiveUI.g(LuckyMoneyBusiReceiveUI.this));
                LuckyMoneyBusiReceiveUI.this.startActivity(paramAnonymousView);
                LuckyMoneyBusiReceiveUI.this.finish();
              }
            });
            this.lUO.setVisibility(0);
          }
          else
          {
            this.lUO.setVisibility(8);
          }
        }
      }
    }
    else if ((paramm instanceof t))
    {
      o.d(this.lMN);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        at(-1, "");
        paramm = (t)paramm;
        if (paramm.ced == 2)
        {
          if ((paramm.iHi <= 1) || ((paramm.lQh != null) && (paramm.lQh.dwF != 1)))
          {
            y.i("MicroMsg.LuckyMoneyBusiReceiveUI", "can not atomic go detail");
            paramString = new Intent();
            paramString.putExtra("key_sendid", paramm.lMg);
            paramString.putExtra("key_static_from_scene", this.lUC);
            if (paramm.lMW != null) {
              paramString.putExtra("key_realname_guide_helper", paramm.lMW);
            }
            try
            {
              paramString.putExtra("key_detail_info", paramm.lQZ.toByteArray());
              paramString.putExtra("key_jump_from", 2);
              if (g.AA().getInt("PlayCoinSound", 0) > 0) {
                paramString.putExtra("play_sound", true);
              }
              d.b(this.mController.uMN, "luckymoney", ".ui.LuckyMoneyBusiDetailUI", paramString);
              finish();
              return true;
            }
            catch (IOException paramm)
            {
              for (;;)
              {
                y.w("MicroMsg.LuckyMoneyBusiReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + paramm.getLocalizedMessage());
              }
            }
          }
          paramString = findViewById(a.f.lucky_money_busi_receive_top_ll);
          TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -paramString.getHeight());
          localTranslateAnimation.setDuration(400L);
          localTranslateAnimation.setFillAfter(true);
          localTranslateAnimation.setAnimationListener(new LuckyMoneyBusiReceiveUI.6(this, paramString));
          paramString.startAnimation(localTranslateAnimation);
          this.lLM.setText(com.tencent.mm.wallet_core.ui.e.A(paramm.ceq / 100.0D));
          this.lMM.setText(paramm.lQR);
          this.lUK.setVisibility(8);
          this.lUL.setVisibility(8);
          this.lUM.setVisibility(0);
          this.lMN.setVisibility(8);
          if (!bk.bl(paramm.lQU))
          {
            paramString = paramm.lQU;
            this.lUR.setText(paramString);
            this.lUS.setVisibility(0);
            com.tencent.mm.plugin.report.service.h.nFQ.f(11701, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
            y.i("MicroMsg.LuckyMoneyBusiReceiveUI", "totalNum:" + paramm.iHi);
            if ((paramm.iHi <= 1) && ((paramm.lQh == null) || (paramm.lQh.dwF != 1))) {
              break label1167;
            }
            y.i("MicroMsg.LuckyMoneyBusiReceiveUI", "can atomic");
            this.lUY = paramm.lMW;
            this.lUR.setOnClickListener(new LuckyMoneyBusiReceiveUI.7(this, paramm));
            label1146:
            this.lUR.setVisibility(0);
          }
        }
        for (;;)
        {
          return true;
          paramString = getString(a.i.lucky_money_share);
          break;
          label1167:
          this.lUR.setOnClickListener(new LuckyMoneyBusiReceiveUI.8(this));
          break label1146;
          this.lUK.setVisibility(4);
          this.lUL.setText(paramm.lPS);
          this.lMN.setVisibility(8);
          if (this.lUW == 1)
          {
            this.lUO.setOnClickListener(new LuckyMoneyBusiReceiveUI.9(this, paramm));
            this.lUO.setVisibility(0);
          }
          else
          {
            this.lUO.setVisibility(8);
          }
        }
      }
      if (paramInt2 == 416)
      {
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.hide();
        }
        paramString = new Bundle();
        paramString.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyBusiReceiveUI");
        paramString.putString("realname_verify_process_jump_plugin", "luckymoney");
        this.lMN.setBackgroundResource(a.e.festival_lucky_money_open_btn);
        new LuckyMoneyBusiReceiveUI.10(this);
        return o.a(this, paramInt2, paramm, paramString, false, new LuckyMoneyBusiReceiveUI.2(this), 1005);
      }
    }
    else
    {
      if ((paramm instanceof ah))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          com.tencent.mm.ui.base.h.bC(this, getString(a.i.has_send));
          com.tencent.mm.plugin.report.service.h.nFQ.f(11701, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4) });
          finish();
          return true;
        }
        com.tencent.mm.ui.base.h.bC(this, paramString);
        return true;
      }
      if ((paramm instanceof com.tencent.mm.plugin.luckymoney.b.s))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          l(new u(this.lUy, this.lUA, this.lUU, getIntent().getStringExtra("packageExt")));
          return true;
        }
      }
      else
      {
        if ((paramm instanceof com.tencent.mm.plugin.luckymoney.b.p)) {
          return true;
        }
        if ((paramm instanceof w))
        {
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.hide();
          }
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            paramm = (w)paramm;
            paramString = new Intent();
            paramString.setClass(this.mController.uMN, LuckyMoneyBusiDetailUI.class);
            try
            {
              paramString.putExtra("key_detail_info", paramm.lQZ.toByteArray());
              paramString.putExtra("key_jump_from", 2);
              paramString.putExtra("key_native_url", this.lUA);
              paramString.putExtra("key_sendid", this.lUy);
              paramString.putExtra("key_static_from_scene", this.lUC);
              startActivity(paramString);
              finish();
              return true;
            }
            catch (IOException paramm)
            {
              for (;;)
              {
                y.w("MicroMsg.LuckyMoneyBusiReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + paramm.getLocalizedMessage());
              }
            }
          }
        }
      }
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      at(2, paramString);
    }
    return false;
  }
  
  protected final int getLayoutId()
  {
    return a.g.lucky_money_busi_receive_ui;
  }
  
  protected final void initView()
  {
    this.lMR = findViewById(a.f.lucky_money_busi_receive_ll);
    this.lLV = ((ImageView)findViewById(a.f.lucky_money_busi_receive_sender_avatar));
    this.lMM = ((TextView)findViewById(a.f.lucky_money_busi_receive_sender_nickname));
    this.lUL = ((TextView)findViewById(a.f.lucky_money_busi_receive_maindesc));
    this.lUK = ((TextView)findViewById(a.f.lucky_money_busi_receive_subdesc));
    this.lMN = ((Button)findViewById(a.f.lucky_money_busi_receive_open));
    this.lOR = ((ImageView)findViewById(a.f.lucky_money_busi_recieve_close_btn));
    this.lUM = findViewById(a.f.lucky_money_busi_amount_area);
    this.lLM = ((TextView)findViewById(a.f.lucky_money_busi_amount));
    this.lUN = ((ImageView)findViewById(a.f.lucky_money_busi_recieve_watermask));
    this.lUO = ((TextView)findViewById(a.f.lucky_money_busi_recieve_check_detail));
    this.lUP = findViewById(a.f.lucky_money_busi_receive_share_area);
    this.lUQ = ((TextView)findViewById(a.f.lucky_money_busi_receive_share_hintmess));
    this.lUR = ((Button)findViewById(a.f.lucky_money_busi_share_btn));
    this.lUS = ((TextView)findViewById(a.f.lucky_money_busi_receive_savetips));
    this.lUT = ((CheckBox)findViewById(a.f.lucky_money_busi_subcribe));
    this.lOR.setOnClickListener(new LuckyMoneyBusiReceiveUI.3(this));
    vN(8);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        String str = paramIntent.getStringExtra("Select_Conv_User");
        com.tencent.mm.plugin.report.service.h.nFQ.f(11701, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3), str });
        if (!bk.bl(str)) {
          l(new ah(str, this.lUy, "v1.0"));
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.lUA = getIntent().getStringExtra("key_native_url");
    this.lUU = getIntent().getIntExtra("key_way", 5);
    this.lUC = getIntent().getIntExtra("key_static_from_scene", 0);
    y.i("MicroMsg.LuckyMoneyBusiReceiveUI", "nativeurl=" + bk.pm(this.lUA) + ", mWay=" + this.lUU);
    init();
    com.tencent.mm.plugin.report.service.h.nFQ.f(11701, new Object[] { Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    initView();
    kh(980);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    ki(980);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.hasExtra("key_is_realname_verify_process")))
    {
      if (paramIntent.getIntExtra("realname_verify_process_ret", 0) == -1)
      {
        y.i("MicroMsg.LuckyMoneyBusiReceiveUI", "new intent from realname verify process succ");
        init();
      }
    }
    else {
      return;
    }
    y.i("MicroMsg.LuckyMoneyBusiReceiveUI", "new intent from realname verify process cancel");
    at(-1, "");
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiReceiveUI
 * JD-Core Version:    0.7.0.1
 */