package com.tencent.mm.plugin.honey_pay.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.abc;
import com.tencent.mm.f.a.pd;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.honey_pay.a.e;
import com.tencent.mm.plugin.honey_pay.a.m;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.i;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.bwa;
import com.tencent.mm.protocal.protobuf.cka;
import com.tencent.mm.protocal.protobuf.drc;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.g;
import java.io.IOException;

public class HoneyPayReceiveCardUI
  extends HoneyPayBaseUI
{
  private String DKa;
  private ImageView DLM;
  private TextView DLN;
  private TextView DLO;
  private TextView DLP;
  private TextView DLQ;
  private TextView DLR;
  private TextView DLS;
  private TextView DLT;
  private TextView DLU;
  private TextView DLV;
  private LinearLayout DLW;
  private CdnImageView DLX;
  private i DLY;
  private int mScene;
  
  public HoneyPayReceiveCardUI()
  {
    AppMethodBeat.i(64831);
    this.DLY = new i()
    {
      public final Object a(u paramAnonymousu)
      {
        return null;
      }
      
      public final Object b(u paramAnonymousu)
      {
        AppMethodBeat.i(64824);
        if (paramAnonymousu.type == 1)
        {
          paramAnonymousu = paramAnonymousu.bnW;
          if ((paramAnonymousu != null) && ((paramAnonymousu instanceof Bundle)) && (((Bundle)paramAnonymousu).getBoolean("click_help", false))) {
            h.IzE.a(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          }
        }
        AppMethodBeat.o(64824);
        return null;
      }
    };
    AppMethodBeat.o(64831);
  }
  
  private void a(final drc paramdrc)
  {
    AppMethodBeat.i(64836);
    if (paramdrc.TfN == null)
    {
      AppMethodBeat.o(64836);
      return;
    }
    cka localcka = paramdrc.TfN;
    this.DLR.setText(localcka.Try);
    this.DLT.setText(l.b(getContext(), localcka.EtJ, this.DLT.getTextSize()));
    Object localObject = new Bundle();
    ((Bundle)localObject).putBoolean("click_help", true);
    this.DLU.setText(l.a(getContext(), localcka.Igp, (int)this.DLU.getTextSize(), localObject));
    this.DLU.setClickable(true);
    this.DLU.setOnTouchListener(new o(this));
    if (!Util.isNullOrNil(paramdrc.TSc))
    {
      localObject = new com.tencent.mm.plugin.wallet_core.ui.r(new com.tencent.mm.plugin.wallet_core.ui.r.a()
      {
        public final void ed(View paramAnonymousView)
        {
          AppMethodBeat.i(64830);
          if (!Util.isNullOrNil(paramdrc.TSd)) {
            g.p(HoneyPayReceiveCardUI.this.getContext(), paramdrc.TSd, false);
          }
          h.IzE.a(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          AppMethodBeat.o(64830);
        }
      });
      paramdrc = new SpannableString(paramdrc.TSc);
      paramdrc.setSpan(localObject, 0, paramdrc.length(), 18);
      this.DLP.setText(paramdrc);
      this.DLP.setOnTouchListener(new o(this));
      this.DLP.setClickable(true);
      this.DLO.setText(localcka.tpo);
      a.b.a(this.DLM, localcka.llP, 0.06F, false);
      g.j(this.DLN, localcka.llP);
      g.j(this.DLV, localcka.llP);
      if (localcka.qJt != 1) {
        break label322;
      }
      this.DLS.setText(a.i.honey_pay_father_type);
    }
    for (;;)
    {
      if (Util.isNullOrNil(localcka.ufC)) {
        break label372;
      }
      this.DLX.hr(localcka.ufC, c.eHL());
      AppMethodBeat.o(64836);
      return;
      Log.d(this.TAG, "no help url");
      this.DLP.setVisibility(8);
      break;
      label322:
      if (localcka.qJt == 2) {
        this.DLS.setText(a.i.honey_pay_mother_type);
      } else {
        this.DLS.setText(l.b(this, g.ic(z.bdb(), 16), this.DLS.getTextSize()));
      }
    }
    label372:
    this.DLX.setImageResource(c.eHL());
    AppMethodBeat.o(64836);
  }
  
  private void eHO()
  {
    AppMethodBeat.i(64837);
    Log.i(this.TAG, "qry user detail");
    m localm = new m(this.DKa);
    localm.u(this);
    doSceneProgress(localm, true);
    AppMethodBeat.o(64837);
  }
  
  public int getLayoutId()
  {
    return a.g.honey_pay_receive_card_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64833);
    this.DLM = ((ImageView)findViewById(a.f.hprc_avatar_iv));
    this.DLN = ((TextView)findViewById(a.f.hprc_payer_name_tv));
    this.DLS = ((TextView)findViewById(a.f.hprc_user_name_tv));
    this.DLO = ((TextView)findViewById(a.f.hprc_quota_desc_tv));
    this.DLV = ((TextView)findViewById(a.f.hprc_quota_username_tv));
    this.DLP = ((TextView)findViewById(a.f.hprc_check_payway_tv));
    this.DLQ = ((TextView)findViewById(a.f.hprc_receive_btn));
    this.DLR = ((TextView)findViewById(a.f.hprc_receive_tip_tv));
    this.DLW = ((LinearLayout)findViewById(a.f.hprc_quota_layout));
    this.DLT = ((TextView)findViewById(a.f.hprc_wishing_tv));
    this.DLU = ((TextView)findViewById(a.f.hprc_explain_tv));
    this.DLX = ((CdnImageView)findViewById(a.f.hprc_quota_logo_1_iv));
    this.DLQ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64825);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/honey_pay/ui/HoneyPayReceiveCardUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        HoneyPayReceiveCardUI.a(HoneyPayReceiveCardUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayReceiveCardUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(64825);
      }
    });
    AppMethodBeat.o(64833);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64832);
    this.BkW = a.c.honey_pay_grey_bg_2;
    super.onCreate(paramBundle);
    l.a(this.DLY);
    addSceneEndListener(2613);
    addSceneEndListener(1983);
    this.DKa = getIntent().getStringExtra("key_card_no");
    this.mScene = getIntent().getIntExtra("key_scene", 0);
    initView();
    if (this.mScene == 1)
    {
      paramBundle = new drc();
      try
      {
        paramBundle.parseFrom(getIntent().getByteArrayExtra("key_qry_response"));
        a(paramBundle);
        if (paramBundle.TfN != null) {
          setMMTitle(paramBundle.TfN.tpo);
        }
        AppMethodBeat.o(64832);
        return;
      }
      catch (IOException paramBundle)
      {
        Log.printErrStackTrace(this.TAG, paramBundle, "", new Object[0]);
        eHO();
        AppMethodBeat.o(64832);
        return;
      }
    }
    eHO();
    AppMethodBeat.o(64832);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64834);
    super.onDestroy();
    l.b(this.DLY);
    removeSceneEndListener(2613);
    removeSceneEndListener(1983);
    AppMethodBeat.o(64834);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(64835);
    if ((paramq instanceof m))
    {
      paramString = (m)paramq;
      paramString.a(new com.tencent.mm.wallet_core.c.r.a()
      {
        public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(64826);
          HoneyPayReceiveCardUI.a(HoneyPayReceiveCardUI.this, paramString.DJM);
          AppMethodBeat.o(64826);
        }
      }).b(new com.tencent.mm.wallet_core.c.r.a()
      {
        public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq) {}
      }).c(new com.tencent.mm.wallet_core.c.r.a()
      {
        public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq) {}
      });
    }
    for (;;)
    {
      AppMethodBeat.o(64835);
      return true;
      if ((paramq instanceof e))
      {
        paramString = (e)paramq;
        paramString.a(new com.tencent.mm.wallet_core.c.r.a()
        {
          public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
          {
            AppMethodBeat.i(64829);
            if (paramString.DJD.SkR != null)
            {
              Log.i(HoneyPayReceiveCardUI.this.TAG, "do real name");
              paramAnonymousString = new Bundle();
              paramAnonymousString.putString("realname_verify_process_jump_activity", ".ui.HoneyPayReceiveCardUI");
              c.a(HoneyPayReceiveCardUI.this, paramAnonymousString, paramString.DJD.SkR, false);
            }
            for (;;)
            {
              h.IzE.p(875L, 4L, 1L);
              AppMethodBeat.o(64829);
              return;
              HoneyPayReceiveCardUI.b(HoneyPayReceiveCardUI.this);
              paramAnonymousString = HoneyPayReceiveCardUI.c(HoneyPayReceiveCardUI.this);
              paramAnonymousq = new abc();
              paramAnonymousq.gah.scene = 8;
              EventCenter.instance.publish(paramAnonymousq);
              Log.i("MicroMsg.HoneyPayUtil", "trigger offline event");
              paramAnonymousq = new pd();
              paramAnonymousq.fNX.scene = 1;
              paramAnonymousq.fNX.fJD = "qmf";
              EventCenter.instance.publish(paramAnonymousq);
              if (!Util.isNullOrNil(paramAnonymousString)) {
                com.tencent.mm.plugin.offline.c.a.aTG(paramAnonymousString);
              }
              HoneyPayReceiveCardUI.this.finish();
            }
          }
        }).b(new com.tencent.mm.wallet_core.c.r.a()
        {
          public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
          {
            AppMethodBeat.i(64828);
            if (paramString.DJD.SkR != null)
            {
              Log.i(HoneyPayReceiveCardUI.this.TAG, "do real name");
              paramAnonymousString = new Bundle();
              paramAnonymousString.putString("realname_verify_process_jump_activity", ".ui.HoneyPayReceiveCardUI");
              c.a(HoneyPayReceiveCardUI.this, paramAnonymousString, paramString.DJD.SkR, false);
            }
            h.IzE.p(875L, 5L, 1L);
            AppMethodBeat.o(64828);
          }
        }).c(new com.tencent.mm.wallet_core.c.r.a()
        {
          public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
          {
            AppMethodBeat.i(64827);
            h.IzE.p(875L, 5L, 1L);
            AppMethodBeat.o(64827);
          }
        });
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayReceiveCardUI
 * JD-Core Version:    0.7.0.1
 */