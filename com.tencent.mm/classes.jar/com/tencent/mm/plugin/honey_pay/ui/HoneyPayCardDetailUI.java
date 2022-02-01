package com.tencent.mm.plugin.honey_pay.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.honey_pay.a.m;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.cik;
import com.tencent.mm.protocal.protobuf.cka;
import com.tencent.mm.protocal.protobuf.drc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;
import com.tencent.mm.wallet_core.ui.g;
import java.io.IOException;

public class HoneyPayCardDetailUI
  extends HoneyPayBaseUI
{
  private String DKa;
  private TextView DKe;
  private TextView DKf;
  private TextView DKg;
  private TextView DKh;
  private TextView DKi;
  private TextView DKj;
  private RelativeLayout DKk;
  private CdnImageView DKl;
  private TextView DKm;
  private Button DKn;
  private drc DKo;
  private cik DKp;
  private int mScene;
  private ImageView tXu;
  
  private void eHN()
  {
    AppMethodBeat.i(64675);
    if (this.DKo.TfN == null)
    {
      AppMethodBeat.o(64675);
      return;
    }
    cka localcka = this.DKo.TfN;
    setMMTitle(localcka.tpo);
    this.DKe.setText(localcka.TrC);
    int i = localcka.state;
    if (i == 2)
    {
      this.tXu.setImageResource(a.h.icons_outlined_done2);
      this.tXu.setColorFilter(getContext().getResources().getColor(a.c.Brand), PorterDuff.Mode.SRC_ATOP);
      if (!Util.isNullOrNil(localcka.Try))
      {
        localcka.Try = c.aa(localcka.Try, this.DKo.TfN.llP, -1);
        this.DKf.setText(l.a(this, localcka.Try, (int)this.DKf.getTextSize(), null));
      }
      findViewById(a.f.hpcd_divider_view).setVisibility(8);
      findViewById(a.f.hpcd_first_date_layout).setVisibility(8);
      findViewById(a.f.hpcd_second_date_layout).setVisibility(8);
      if (this.DKp != null)
      {
        this.DKk.setVisibility(0);
        this.DKl.setUrl(this.DKp.icon);
        this.DKm.setText(this.DKp.Tpp);
        this.DKn.setText(this.DKp.Tpo);
        this.DKn.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(64670);
            b localb = new b();
            localb.bn(paramAnonymousView);
            a.c("com/tencent/mm/plugin/honey_pay/ui/HoneyPayCardDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            Log.d(HoneyPayCardDetailUI.this.TAG, "click oper btn: %s", new Object[] { HoneyPayCardDetailUI.b(HoneyPayCardDetailUI.this).url });
            if (!Util.isNullOrNil(HoneyPayCardDetailUI.b(HoneyPayCardDetailUI.this).url)) {
              g.p(HoneyPayCardDetailUI.this.getContext(), HoneyPayCardDetailUI.b(HoneyPayCardDetailUI.this).url, false);
            }
            a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayCardDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(64670);
          }
        });
        AppMethodBeat.o(64675);
      }
    }
    else
    {
      if (i == 3)
      {
        this.tXu.setImageResource(a.h.remittance_timed_out);
        if (!Util.isNullOrNil(localcka.Try)) {
          this.DKf.setText(localcka.Try);
        }
        this.DKg.setText(a.i.honey_pay_receive_date_title_text);
        this.DKh.setText(a.i.honey_pay_return_date_title_text);
        this.DKi.setText(c.Oe(this.DKo.TfN.ChC));
        this.DKj.setText(c.Oe(this.DKo.TfN.tnN));
        AppMethodBeat.o(64675);
        return;
      }
      if (i == 4)
      {
        this.tXu.setImageResource(a.h.remittance_timed_out);
        if (!Util.isNullOrNil(localcka.Try)) {
          this.DKf.setText(l.g(this, localcka.Try, (int)this.DKf.getTextSize()));
        }
        this.DKg.setText(a.i.honey_pay_release_date_title_text);
        this.DKi.setText(c.Oe(this.DKo.TfN.TrA));
        findViewById(a.f.hpcd_second_date_layout).setVisibility(8);
      }
    }
    AppMethodBeat.o(64675);
  }
  
  private void eHO()
  {
    AppMethodBeat.i(64676);
    m localm = new m(this.DKa);
    localm.u(this);
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
    this.tXu = ((ImageView)findViewById(a.f.hpcd_top_image_iv));
    this.DKe = ((TextView)findViewById(a.f.hpcd_state_tv));
    this.DKf = ((TextView)findViewById(a.f.hpcd_state_tip_tv));
    this.DKi = ((TextView)findViewById(a.f.hpcd_first_date_tv));
    this.DKj = ((TextView)findViewById(a.f.hpcd_second_date_tv));
    this.DKg = ((TextView)findViewById(a.f.hpcd_first_date_title_tv));
    this.DKh = ((TextView)findViewById(a.f.hpcd_second_date_title_tv));
    this.DKk = ((RelativeLayout)findViewById(a.f.hpcd_oper_layout));
    this.DKl = ((CdnImageView)findViewById(a.f.hpcd_oper_icon_iv));
    this.DKm = ((TextView)findViewById(a.f.hpcd_oper_desc_tv));
    this.DKn = ((Button)findViewById(a.f.hpcd_oper_btn));
    this.DKf.setClickable(true);
    this.DKf.setOnTouchListener(new o(this));
    AppMethodBeat.o(64672);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64671);
    this.BkW = a.c.honey_pay_grey_bg_2;
    super.onCreate(paramBundle);
    addSceneEndListener(2613);
    this.mScene = getIntent().getIntExtra("key_scene", 0);
    this.DKa = getIntent().getStringExtra("key_card_no");
    initView();
    if (this.mScene == 0)
    {
      eHO();
      AppMethodBeat.o(64671);
      return;
    }
    paramBundle = getIntent().getByteArrayExtra("key_qry_response");
    try
    {
      this.DKo = new drc();
      this.DKo.parseFrom(paramBundle);
      eHN();
      AppMethodBeat.o(64671);
      return;
    }
    catch (IOException paramBundle)
    {
      Log.printErrStackTrace(this.TAG, paramBundle, "", new Object[0]);
      eHO();
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(64674);
    if ((paramq instanceof m))
    {
      paramString = (m)paramq;
      paramString.a(new r.a()
      {
        public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(64669);
          HoneyPayCardDetailUI.a(HoneyPayCardDetailUI.this, paramString.DJM);
          HoneyPayCardDetailUI.a(HoneyPayCardDetailUI.this);
          AppMethodBeat.o(64669);
        }
      }).b(new r.a()
      {
        public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq) {}
      }).c(new r.a()
      {
        public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardDetailUI
 * JD-Core Version:    0.7.0.1
 */