package com.tencent.mm.plugin.collect.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.a;

public class CollectCreateQRCodeUI
  extends WalletBaseUI
{
  private String dkv = "";
  private WalletFormView iKG;
  private TextView iKH;
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramm instanceof com.tencent.mm.plugin.collect.b.s))
    {
      bool1 = bool2;
      if (paramInt1 == 0)
      {
        bool1 = bool2;
        if (paramInt2 == 0)
        {
          paramString = (com.tencent.mm.plugin.collect.b.s)paramm;
          paramm = new Intent();
          paramm.putExtra("ftf_pay_url", paramString.iHO);
          paramm.putExtra("ftf_fixed_fee", paramString.iHP);
          paramm.putExtra("ftf_fixed_fee_type", paramString.bHY);
          paramm.putExtra("ftf_fixed_desc", paramString.desc);
          setResult(-1, paramm);
          finish();
          bool1 = true;
        }
      }
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!(paramm instanceof com.tencent.mm.plugin.collect.b.m));
      paramString = (com.tencent.mm.plugin.collect.b.m)paramm;
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break;
      }
      if (paramString.iHq == 0)
      {
        paramm = new Intent();
        paramm.putExtra("ftf_pay_url", paramString.iHs);
        paramm.putExtra("ftf_fixed_fee", paramString.ceq / 100.0D);
        paramm.putExtra("ftf_fixed_desc", paramString.desc);
        paramm.putExtra("key_currency_unit", paramString.iHB);
        setResult(-1, paramm);
        finish();
        return true;
      }
      if (paramString.iHt == 0)
      {
        h.b(this.mController.uMN, paramString.iHr, paramString.iHu, false);
        return true;
      }
      bool1 = bool2;
    } while (paramString.iHt != 1);
    if ((!bk.bl(paramString.iHv)) && (!bk.bl(paramString.iHw))) {
      h.a(this.mController.uMN, paramString.iHr, paramString.iHu, paramString.iHw, paramString.iHv, new CollectCreateQRCodeUI.5(this, paramString), new CollectCreateQRCodeUI.6(this));
    }
    return true;
    y.e("MicroMsg.CollectCreateQRCodeUI", "net error: %s", new Object[] { paramString });
    return false;
  }
  
  protected final int getLayoutId()
  {
    return a.g.collect_create_qrcode;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.collect_create_qrcode_title);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        CollectCreateQRCodeUI.this.setResult(0);
        CollectCreateQRCodeUI.this.finish();
        return true;
      }
    });
    this.iKG = ((WalletFormView)findViewById(a.f.money_ev));
    a.f(this.iKG);
    String str = getIntent().getStringExtra("key_currency_unit");
    if (!bk.bl(str)) {
      this.iKG.getTitleTv().setText(str);
    }
    for (;;)
    {
      this.iKG.a(new CollectCreateQRCodeUI.2(this));
      e(this.iKG, 2, false);
      ((Button)findViewById(a.f.next_btn)).setOnClickListener(new CollectCreateQRCodeUI.3(this));
      this.iKH = ((TextView)findViewById(a.f.collect_main_add_desc));
      this.iKH.setOnClickListener(new CollectCreateQRCodeUI.4(this));
      return;
      this.iKG.getTitleTv().setText(ab.cML());
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    kh(1335);
    initView();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ki(1335);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeUI
 * JD-Core Version:    0.7.0.1
 */