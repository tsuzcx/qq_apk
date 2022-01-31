package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.honey_pay.a.c;
import com.tencent.mm.plugin.honey_pay.a.d;
import com.tencent.mm.plugin.honey_pay.a.g;
import com.tencent.mm.plugin.wallet_core.c.w;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.ahk;
import com.tencent.mm.protocal.c.bya;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.c.n.a;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.a;
import java.io.IOException;

public class HoneyPayCheckPwdUI
  extends HoneyPayBaseUI
{
  private int fzn;
  private TextView haW;
  private String hcm;
  private TextView iIV;
  private String lki;
  private bya lkj;
  private EditHintPasswdView llh;
  private String lli;
  private String llj;
  private long llk;
  private int lll;
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.d("MicroMsg.HoneyPayCheckPwdUI", "scene end. errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramm instanceof w))
    {
      paramm = (w)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (this.fzn == 1)
        {
          paramString = paramm.qrc;
          y.i("MicroMsg.HoneyPayCheckPwdUI", "do give card");
          cNm();
          paramString = new c(paramString, this.llk, this.hcm, this.lli, this.lll, this.llj);
          paramString.m(this);
          a(paramString, false, false);
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return true;
          if (this.fzn == 2)
          {
            paramString = paramm.qrc;
            y.i("MicroMsg.HoneyPayCheckPwdUI", "do modify quota");
            cNm();
            paramString = new com.tencent.mm.plugin.honey_pay.a.h(this.llk, paramString, this.lki);
            paramString.m(this);
            a(paramString, false, false);
            return true;
          }
        } while (this.fzn != 3);
        paramString = paramm.qrc;
        y.i("MicroMsg.HoneyPayCheckPwdUI", "do unbind: %s", new Object[] { this.lki });
        cNm();
        paramString = new com.tencent.mm.plugin.honey_pay.a.n(this.lki, paramString);
        paramString.m(this);
        a(paramString, false, false);
        return true;
        if (this.llh != null) {
          this.llh.bvr();
        }
        bka();
      } while ((paramm.wAH) || (bk.bl(paramString)));
      y.i("MicroMsg.HoneyPayCheckPwdUI", "show normal error msg");
      com.tencent.mm.ui.base.h.a(this.mController.uMN, paramString, null, false, new HoneyPayCheckPwdUI.10(this));
      return true;
      if ((paramm instanceof c))
      {
        paramString = (c)paramm;
        bka();
        paramString.a(new HoneyPayCheckPwdUI.13(this, paramString)).b(new HoneyPayCheckPwdUI.12(this)).c(new HoneyPayCheckPwdUI.11(this));
        return true;
      }
      if ((paramm instanceof com.tencent.mm.plugin.honey_pay.a.h))
      {
        bka();
        paramString = (com.tencent.mm.plugin.honey_pay.a.h)paramm;
        paramString.a(new HoneyPayCheckPwdUI.16(this, paramString)).b(new n.a()
        {
          public final void f(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
          {
            if (HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this) != null) {
              HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this).bvr();
            }
            com.tencent.mm.plugin.report.service.h.nFQ.h(875L, 9L, 1L);
          }
        }).c(new HoneyPayCheckPwdUI.14(this));
        return true;
      }
      if ((paramm instanceof d))
      {
        paramString = (d)paramm;
        paramString.a(new HoneyPayCheckPwdUI.3(this, paramString)).b(new HoneyPayCheckPwdUI.2(this, paramString)).c(new n.a()
        {
          public final void f(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
          {
            if (HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this) != null) {
              HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this).bvr();
            }
            HoneyPayCheckPwdUI.this.bka();
          }
        });
        return true;
      }
      if ((paramm instanceof g))
      {
        paramString = (g)paramm;
        this.lkj = paramString.ljL.tcF;
        paramString.a(new HoneyPayCheckPwdUI.6(this)).b(new HoneyPayCheckPwdUI.5(this)).c(new HoneyPayCheckPwdUI.4(this));
        return true;
      }
    } while (!(paramm instanceof com.tencent.mm.plugin.honey_pay.a.n));
    bka();
    ((com.tencent.mm.plugin.honey_pay.a.n)paramm).a(new HoneyPayCheckPwdUI.9(this)).b(new HoneyPayCheckPwdUI.8(this)).c(new n.a()
    {
      public final void f(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
      {
        if (HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this) != null) {
          HoneyPayCheckPwdUI.e(HoneyPayCheckPwdUI.this).bvr();
        }
        com.tencent.mm.plugin.report.service.h.nFQ.h(875L, 7L, 1L);
      }
    });
    return true;
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return a.g.honey_pay_check_pwd_ui;
  }
  
  protected final void initView()
  {
    this.llh = ((EditHintPasswdView)findViewById(a.f.input_et));
    a.a(this.llh);
    this.llh.setOnInputValidListener(new HoneyPayCheckPwdUI.1(this));
    e(this.llh, 0, false);
    this.haW = ((TextView)findViewById(a.f.wallet_pwd_title));
    this.iIV = ((TextView)findViewById(a.f.wallet_pwd_content_1));
    if (this.fzn == 1) {
      this.haW.setText(a.i.honey_pay_check_pwd_create_desc_text);
    }
    for (;;)
    {
      this.iIV.setText(a.i.honey_pay_check_pwd_title_text);
      return;
      if (this.fzn == 2) {
        this.haW.setText(a.i.honey_pay_check_pwd_modify_desc_text);
      } else {
        this.haW.setText(a.i.honey_pay_check_pwd_unbind_desc_text);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.hcm = getIntent().getStringExtra("key_username");
    this.lli = getIntent().getStringExtra("key_take_message");
    this.llk = getIntent().getLongExtra("key_credit_line", 0L);
    this.fzn = getIntent().getIntExtra("key_scene", 0);
    this.lki = getIntent().getStringExtra("key_card_no");
    this.llj = getIntent().getStringExtra("key_wishing");
    if (this.fzn == 1)
    {
      this.lll = getIntent().getIntExtra("key_cardtype", 0);
      if (this.lll == 0)
      {
        y.w("MicroMsg.HoneyPayCheckPwdUI", "error card type: %s", new Object[] { Integer.valueOf(this.lll) });
        finish();
      }
    }
    if (this.fzn == 3) {
      paramBundle = new bya();
    }
    try
    {
      byte[] arrayOfByte = getIntent().getByteArrayExtra("key_toke_mess");
      if ((arrayOfByte == null) || (arrayOfByte.length == 0))
      {
        y.w("MicroMsg.HoneyPayCheckPwdUI", "toke mess is null when unbind !!!");
        finish();
      }
      paramBundle.aH(arrayOfByte);
      this.lkj = paramBundle;
    }
    catch (IOException paramBundle)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.HoneyPayCheckPwdUI", paramBundle, "", new Object[0]);
        finish();
      }
    }
    setMMTitle("");
    kh(2662);
    kh(2865);
    kh(2630);
    kh(2815);
    kh(2659);
    initView();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ki(2662);
    ki(2865);
    ki(2630);
    ki(2815);
    ki(2659);
  }
  
  public final void st(int paramInt)
  {
    super.st(paramInt);
    if (this.llh != null) {
      this.llh.bvr();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI
 * JD-Core Version:    0.7.0.1
 */