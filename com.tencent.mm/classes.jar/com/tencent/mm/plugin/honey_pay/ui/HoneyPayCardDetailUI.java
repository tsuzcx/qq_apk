package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.aoh;
import com.tencent.mm.protocal.c.aph;
import com.tencent.mm.protocal.c.bhi;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.io.IOException;

public class HoneyPayCardDetailUI
  extends HoneyPayBaseUI
{
  private int fzn;
  private ImageView iIS;
  private String lki;
  private TextView lkm;
  private TextView lkn;
  private TextView lko;
  private TextView lkp;
  private TextView lkq;
  private TextView lkr;
  private RelativeLayout lks;
  private CdnImageView lkt;
  private TextView lku;
  private Button lkv;
  private bhi lkw;
  private aoh lkx;
  
  private void baV()
  {
    if (this.lkw.tei == null) {}
    aph localaph;
    do
    {
      do
      {
        return;
        localaph = this.lkw.tei;
        setMMTitle(localaph.imz);
        this.lkm.setText(localaph.tlo);
        i = localaph.state;
        if (i != 2) {
          break;
        }
        this.iIS.setImageResource(a.e.wallet_success);
        if (!bk.bl(localaph.tlk))
        {
          localaph.tlk = c.dx(localaph.tlk, this.lkw.tei.srM);
          this.lkn.setText(j.a(this, localaph.tlk, (int)this.lkn.getTextSize(), null));
        }
        findViewById(a.f.hpcd_divider_view).setVisibility(8);
        findViewById(a.f.hpcd_first_date_layout).setVisibility(8);
        findViewById(a.f.hpcd_second_date_layout).setVisibility(8);
      } while (this.lkx == null);
      this.lks.setVisibility(0);
      this.lkt.setUrl(this.lkx.bVO);
      this.lku.setText(this.lkx.tka);
      this.lkv.setText(this.lkx.tjZ);
      this.lkv.setOnClickListener(new HoneyPayCardDetailUI.4(this));
      return;
      if (i == 3)
      {
        this.iIS.setImageResource(a.h.remittance_timed_out);
        if (!bk.bl(localaph.tlk)) {
          this.lkn.setText(localaph.tlk);
        }
        this.lko.setText(a.i.honey_pay_receive_date_title_text);
        this.lkp.setText(a.i.honey_pay_return_date_title_text);
        this.lkq.setText(c.eS(this.lkw.tei.create_time));
        this.lkr.setText(c.eS(this.lkw.tei.ild));
        return;
      }
    } while (i != 4);
    this.iIS.setImageResource(a.h.remittance_timed_out);
    int i = this.lkw.tei.tln;
    if (!bk.bl(localaph.tlk)) {
      this.lkn.setText(j.d(this, localaph.tlk, (int)this.lkn.getTextSize()));
    }
    this.lko.setText(a.i.honey_pay_release_date_title_text);
    this.lkq.setText(c.eS(this.lkw.tei.tlm));
    findViewById(a.f.hpcd_second_date_layout).setVisibility(8);
  }
  
  private void baW()
  {
    com.tencent.mm.plugin.honey_pay.a.m localm = new com.tencent.mm.plugin.honey_pay.a.m(this.lki);
    localm.m(this);
    a(localm, true, false);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if ((paramm instanceof com.tencent.mm.plugin.honey_pay.a.m))
    {
      paramString = (com.tencent.mm.plugin.honey_pay.a.m)paramm;
      paramString.a(new HoneyPayCardDetailUI.3(this, paramString)).b(new HoneyPayCardDetailUI.2(this)).c(new HoneyPayCardDetailUI.1(this));
    }
    return true;
  }
  
  protected final int getLayoutId()
  {
    return a.g.honey_pay_card_detail_ui;
  }
  
  protected final void initView()
  {
    this.iIS = ((ImageView)findViewById(a.f.hpcd_top_image_iv));
    this.lkm = ((TextView)findViewById(a.f.hpcd_state_tv));
    this.lkn = ((TextView)findViewById(a.f.hpcd_state_tip_tv));
    this.lkq = ((TextView)findViewById(a.f.hpcd_first_date_tv));
    this.lkr = ((TextView)findViewById(a.f.hpcd_second_date_tv));
    this.lko = ((TextView)findViewById(a.f.hpcd_first_date_title_tv));
    this.lkp = ((TextView)findViewById(a.f.hpcd_second_date_title_tv));
    this.lks = ((RelativeLayout)findViewById(a.f.hpcd_oper_layout));
    this.lkt = ((CdnImageView)findViewById(a.f.hpcd_oper_icon_iv));
    this.lku = ((TextView)findViewById(a.f.hpcd_oper_desc_tv));
    this.lkv = ((Button)findViewById(a.f.hpcd_oper_btn));
    this.lkn.setClickable(true);
    this.lkn.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.lkb = a.c.honey_pay_grey_bg_2;
    super.onCreate(paramBundle);
    kh(2613);
    this.fzn = getIntent().getIntExtra("key_scene", 0);
    this.lki = getIntent().getStringExtra("key_card_no");
    initView();
    if (this.fzn == 0)
    {
      baW();
      return;
    }
    paramBundle = getIntent().getByteArrayExtra("key_qry_response");
    try
    {
      this.lkw = new bhi();
      this.lkw.aH(paramBundle);
      baV();
      return;
    }
    catch (IOException paramBundle)
    {
      y.printErrStackTrace(this.TAG, paramBundle, "", new Object[0]);
      baW();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ki(2613);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardDetailUI
 * JD-Core Version:    0.7.0.1
 */