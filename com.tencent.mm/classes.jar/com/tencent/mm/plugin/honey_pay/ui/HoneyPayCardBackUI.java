package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.honey_pay.a.k;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.bhe;
import com.tencent.mm.protocal.c.bya;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.c.n.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.WalletTextView;

public class HoneyPayCardBackUI
  extends HoneyPayBaseUI
{
  private CdnImageView lkd;
  private WalletTextView lke;
  private TextView lkf;
  private TextView lkg;
  private TextView lkh;
  private String lki;
  private bya lkj;
  
  public final boolean c(int paramInt1, int paramInt2, final String paramString, m paramm)
  {
    if ((paramm instanceof k))
    {
      paramString = (k)paramm;
      paramString.a(new n.a()
      {
        public final void f(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
        {
          HoneyPayCardBackUI.a(HoneyPayCardBackUI.this, paramString.ljQ.tcF);
          HoneyPayCardBackUI.a(HoneyPayCardBackUI.this, paramString.ljQ);
        }
      }).b(new HoneyPayCardBackUI.3(this)).c(new HoneyPayCardBackUI.2(this));
    }
    return true;
  }
  
  protected final int getLayoutId()
  {
    return a.g.honey_pay_card_back_ui;
  }
  
  protected final void initView()
  {
    this.lkd = ((CdnImageView)findViewById(a.f.hpcb_avatar_iv));
    this.lke = ((WalletTextView)findViewById(a.f.hpcb_quota_remained_tv));
    this.lkf = ((TextView)findViewById(a.f.hpcb_quota_tv));
    this.lkg = ((TextView)findViewById(a.f.hpcb_card_type_name_tv));
    this.lkh = ((TextView)findViewById(a.f.hpcb_desc_tv));
    this.lke.setPrefix(ab.cML());
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      y.i(this.TAG, "unbind success");
      finish();
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.lkb = a.c.honey_pay_orange;
    this.uMp = true;
    super.onCreate(paramBundle);
    setMMTitle("");
    setBackBtn(new HoneyPayCardBackUI.1(this));
    kh(2851);
    this.lki = getIntent().getStringExtra("key_card_no");
    initView();
    y.i(this.TAG, "do qry card detail: %s", new Object[] { this.lki });
    paramBundle = new k(this.lki);
    paramBundle.m(this);
    a(paramBundle, true, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ki(2851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardBackUI
 * JD-Core Version:    0.7.0.1
 */