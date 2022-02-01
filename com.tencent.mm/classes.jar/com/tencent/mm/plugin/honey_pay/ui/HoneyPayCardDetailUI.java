package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.honey_pay.a.m;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.s;
import com.tencent.mm.protocal.protobuf.cyn;
import com.tencent.mm.protocal.protobuf.dah;
import com.tencent.mm.protocal.protobuf.ejx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.model.r;
import com.tencent.mm.wallet_core.model.r.a;
import com.tencent.mm.wallet_core.ui.WcPayBannerView;
import com.tencent.mm.wallet_core.ui.i;
import com.tencent.mm.wallet_core.ui.k;
import java.io.IOException;

public class HoneyPayCardDetailUI
  extends HoneyPayBaseUI
{
  private String JAW;
  private TextView JBa;
  private TextView JBb;
  private TextView JBc;
  private TextView JBd;
  private TextView JBe;
  private TextView JBf;
  private RelativeLayout JBg;
  private CdnImageView JBh;
  private TextView JBi;
  private Button JBj;
  private ejx JBk;
  private cyn JBl;
  private int mScene;
  private WcPayBannerView pLM;
  private ImageView xaN;
  
  private void fPy()
  {
    AppMethodBeat.i(64675);
    if (this.JBk.aatf == null)
    {
      AppMethodBeat.o(64675);
      return;
    }
    dah localdah = this.JBk.aatf;
    setMMTitle(localdah.wtN);
    this.JBa.setText(localdah.aaFO);
    int i = localdah.state;
    if (i == 2)
    {
      this.xaN.setImageResource(a.h.icons_outlined_done2);
      this.xaN.setColorFilter(getContext().getResources().getColor(a.c.Brand), PorterDuff.Mode.SRC_ATOP);
      if (!Util.isNullOrNil(localdah.aaFK))
      {
        localdah.aaFK = c.ah(localdah.aaFK, this.JBk.aatf.nQV, -1);
        this.JBb.setText(com.tencent.mm.pluginsdk.ui.span.p.a(this, localdah.aaFK, (int)this.JBb.getTextSize(), null));
      }
      findViewById(a.f.hpcd_divider_view).setVisibility(8);
      findViewById(a.f.hpcd_first_date_layout).setVisibility(8);
      findViewById(a.f.hpcd_second_date_layout).setVisibility(8);
      if (this.JBl != null)
      {
        this.JBg.setVisibility(0);
        this.JBh.setUrl(this.JBl.icon);
        this.JBi.setText(this.JBl.aaDr);
        this.JBj.setText(this.JBl.aaDq);
        this.JBj.setOnClickListener(new k()
        {
          public final void dr(View paramAnonymousView)
          {
            AppMethodBeat.i(267322);
            Log.d(HoneyPayCardDetailUI.this.TAG, "click oper btn: %s", new Object[] { HoneyPayCardDetailUI.b(HoneyPayCardDetailUI.this).url });
            if (!Util.isNullOrNil(HoneyPayCardDetailUI.b(HoneyPayCardDetailUI.this).url)) {
              i.p(HoneyPayCardDetailUI.this.getContext(), HoneyPayCardDetailUI.b(HoneyPayCardDetailUI.this).url, false);
            }
            AppMethodBeat.o(267322);
          }
        });
      }
    }
    for (;;)
    {
      this.pLM.setBannerData(this.JBk.ign);
      AppMethodBeat.o(64675);
      return;
      if (i == 3)
      {
        this.xaN.setImageResource(a.h.remittance_timed_out);
        if (!Util.isNullOrNil(localdah.aaFK)) {
          this.JBb.setText(localdah.aaFK);
        }
        this.JBc.setText(a.i.honey_pay_receive_date_title_text);
        this.JBd.setText(a.i.honey_pay_return_date_title_text);
        this.JBe.setText(c.rZ(this.JBk.aatf.HTK));
        this.JBf.setText(c.rZ(this.JBk.aatf.wso));
      }
      else if (i == 4)
      {
        this.xaN.setImageResource(a.h.remittance_timed_out);
        if (!Util.isNullOrNil(localdah.aaFK)) {
          this.JBb.setText(com.tencent.mm.pluginsdk.ui.span.p.f(this, localdah.aaFK, (int)this.JBb.getTextSize()));
        }
        this.JBc.setText(a.i.honey_pay_release_date_title_text);
        this.JBe.setText(c.rZ(this.JBk.aatf.aaFM));
        findViewById(a.f.hpcd_second_date_layout).setVisibility(8);
      }
    }
  }
  
  private void fPz()
  {
    AppMethodBeat.i(64676);
    m localm = new m(this.JAW);
    localm.r(this);
    doSceneProgress(localm, true);
    AppMethodBeat.o(64676);
  }
  
  public int getLayoutId()
  {
    return a.g.honey_pay_card_detail_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64672);
    this.xaN = ((ImageView)findViewById(a.f.hpcd_top_image_iv));
    this.JBa = ((TextView)findViewById(a.f.hpcd_state_tv));
    this.JBb = ((TextView)findViewById(a.f.hpcd_state_tip_tv));
    this.JBe = ((TextView)findViewById(a.f.hpcd_first_date_tv));
    this.JBf = ((TextView)findViewById(a.f.hpcd_second_date_tv));
    this.JBc = ((TextView)findViewById(a.f.hpcd_first_date_title_tv));
    this.JBd = ((TextView)findViewById(a.f.hpcd_second_date_title_tv));
    this.JBg = ((RelativeLayout)findViewById(a.f.hpcd_oper_layout));
    this.JBh = ((CdnImageView)findViewById(a.f.hpcd_oper_icon_iv));
    this.JBi = ((TextView)findViewById(a.f.hpcd_oper_desc_tv));
    this.JBj = ((Button)findViewById(a.f.hpcd_oper_btn));
    this.pLM = ((WcPayBannerView)findViewById(a.f.wc_pay_banner_layout));
    this.pLM.jPz();
    this.JBb.setClickable(true);
    this.JBb.setOnTouchListener(new s(this));
    AppMethodBeat.o(64672);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64671);
    this.GRg = a.c.honey_pay_grey_bg_2;
    super.onCreate(paramBundle);
    addSceneEndListener(2613);
    this.mScene = getIntent().getIntExtra("key_scene", 0);
    this.JAW = getIntent().getStringExtra("key_card_no");
    initView();
    if (this.mScene == 0)
    {
      fPz();
      AppMethodBeat.o(64671);
      return;
    }
    paramBundle = getIntent().getByteArrayExtra("key_qry_response");
    try
    {
      this.JBk = new ejx();
      this.JBk.parseFrom(paramBundle);
      fPy();
      AppMethodBeat.o(64671);
      return;
    }
    catch (IOException paramBundle)
    {
      Log.printErrStackTrace(this.TAG, paramBundle, "", new Object[0]);
      fPz();
      AppMethodBeat.o(64671);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64673);
    super.onDestroy();
    removeSceneEndListener(2613);
    AppMethodBeat.o(64673);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(64674);
    if ((paramp instanceof m))
    {
      paramString = (m)paramp;
      paramString.a(new r.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
        {
          AppMethodBeat.i(64669);
          HoneyPayCardDetailUI.a(HoneyPayCardDetailUI.this, paramString.JAI);
          HoneyPayCardDetailUI.a(HoneyPayCardDetailUI.this);
          AppMethodBeat.o(64669);
        }
      }).b(new r.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp) {}
      }).c(new r.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp) {}
      });
    }
    AppMethodBeat.o(64674);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardDetailUI
 * JD-Core Version:    0.7.0.1
 */