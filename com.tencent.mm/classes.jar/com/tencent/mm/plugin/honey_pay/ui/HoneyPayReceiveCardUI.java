package com.tencent.mm.plugin.honey_pay.ui;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.acz;
import com.tencent.mm.autogen.a.qp;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.honey_pay.a.e;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.offline.c.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.s.a;
import com.tencent.mm.plugin.wallet_core.utils.WcPayTextApppearanceSpan;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.protocal.protobuf.clb;
import com.tencent.mm.protocal.protobuf.dac;
import com.tencent.mm.protocal.protobuf.dah;
import com.tencent.mm.protocal.protobuf.ejx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.wallet_core.model.r;
import com.tencent.mm.wallet_core.model.r.a;
import com.tencent.mm.wallet_core.ui.WcPayBannerView;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.f.a;
import com.tencent.mm.wallet_core.ui.i;
import com.tencent.mm.wallet_core.ui.k;
import java.io.IOException;
import java.util.HashSet;

public class HoneyPayReceiveCardUI
  extends HoneyPayBaseUI
{
  private String JAW;
  private TextView JCD;
  private LinearLayout JCE;
  private CheckBox JCF;
  private String JCH;
  private ImageView JCW;
  private TextView JCX;
  private TextView JCY;
  private TextView JCZ;
  private Button JDa;
  private TextView JDb;
  private TextView JDc;
  private TextView JDd;
  private TextView JDe;
  private TextView JDf;
  private TextView JDg;
  private ImageView JDh;
  private LinearLayout JDi;
  private CdnImageView JDj;
  private com.tencent.mm.pluginsdk.ui.span.m JDk;
  private int mScene;
  private WcPayBannerView pLM;
  private boolean tSj;
  
  public HoneyPayReceiveCardUI()
  {
    AppMethodBeat.i(64831);
    this.JCH = "";
    this.tSj = false;
    this.JDk = new com.tencent.mm.pluginsdk.ui.span.m()
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
          paramAnonymousu = paramAnonymousu.cpt;
          if ((paramAnonymousu != null) && ((paramAnonymousu instanceof Bundle)) && (((Bundle)paramAnonymousu).getBoolean("click_help", false))) {
            h.OAn.b(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          }
        }
        AppMethodBeat.o(64824);
        return null;
      }
    };
    AppMethodBeat.o(64831);
  }
  
  private void a(final ejx paramejx)
  {
    AppMethodBeat.i(64836);
    if (paramejx.aatf == null)
    {
      AppMethodBeat.o(64836);
      return;
    }
    Object localObject1 = paramejx.aatf;
    this.JDb.setText(((dah)localObject1).aaFK);
    this.JDd.setText(com.tencent.mm.pluginsdk.ui.span.p.b(getContext(), ((dah)localObject1).Kmq, this.JDd.getTextSize()));
    this.JDd.setText(com.tencent.mm.pluginsdk.ui.span.p.b(getContext(), ((dah)localObject1).Kmq, this.JDd.getTextSize()));
    Object localObject2 = new SpannableString(getString(a.i.honey_pay_month_limit) + " " + i.X(((dah)localObject1).aaFI / 100L));
    Object localObject3 = new WcPayTextApppearanceSpan(-1, null);
    ((WcPayTextApppearanceSpan)localObject3).VYs = i.nS(this);
    ((SpannableString)localObject2).setSpan(localObject3, getString(a.i.honey_pay_month_limit).length(), ((SpannableString)localObject2).length(), 18);
    this.JDe.setText((CharSequence)localObject2);
    localObject2 = new Bundle();
    ((Bundle)localObject2).putBoolean("click_help", true);
    this.JDf.setText(com.tencent.mm.pluginsdk.ui.span.p.a(getContext(), ((dah)localObject1).OcO, (int)this.JDf.getTextSize(), localObject2));
    this.JDf.setClickable(true);
    this.JDf.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s(this));
    if (!Util.isNullOrNil(paramejx.abiA))
    {
      localObject2 = new com.tencent.mm.plugin.wallet_core.ui.s(7, new s.a()
      {
        public final void eS(View paramAnonymousView)
        {
          AppMethodBeat.i(64830);
          if (!Util.isNullOrNil(paramejx.abiB)) {
            i.p(HoneyPayReceiveCardUI.this.getContext(), paramejx.abiB, false);
          }
          h.OAn.b(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          AppMethodBeat.o(64830);
        }
      }, (byte)0);
      localObject3 = new SpannableString(paramejx.abiA);
      ((SpannableString)localObject3).setSpan(localObject2, 0, ((SpannableString)localObject3).length(), 18);
      i.Q(this.JCZ);
      this.JCZ.setText((CharSequence)localObject3);
      this.JCZ.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s(this));
      this.JCZ.setClickable(true);
      localObject2 = i.jp(((dah)localObject1).nQV, 10);
      localObject2 = getString(a.i.honey_pay_send_card_desc, new Object[] { localObject2, ((dah)localObject1).wtN });
      this.JCY.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this.JCY.getContext(), (CharSequence)localObject2, this.JCY.getTextSize()));
      a.b.a(this.JCW, ((dah)localObject1).nQV, 0.06F, false);
      i.j(this.JCX, ((dah)localObject1).nQV);
      i.j(this.JDg, ((dah)localObject1).nQV);
      if (((dah)localObject1).tNW != 1) {
        break label725;
      }
      this.JDc.setText(a.i.honey_pay_father_type);
      label469:
      if (Util.isNullOrNil(((dah)localObject1).icon_url)) {
        break label775;
      }
      this.JDj.iz(((dah)localObject1).icon_url, c.fPw());
    }
    for (;;)
    {
      if (!paramejx.aaFF) {
        break label788;
      }
      this.tSj = true;
      h.OAn.b(24522, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
      this.JCE.setVisibility(0);
      Log.d(this.TAG, "text:%s desc:%s url:%s", new Object[] { paramejx.aaFG.title, paramejx.aaFG.desc, paramejx.aaFG.Krl });
      if (Util.isNullOrNil(paramejx.aaFG.title)) {
        break label802;
      }
      this.JCH = paramejx.aaFG.desc;
      localObject1 = new StringBuilder(paramejx.aaFG.title);
      int i = ((StringBuilder)localObject1).length();
      ((StringBuilder)localObject1).append(paramejx.aaFG.desc);
      this.JCD.setText(((StringBuilder)localObject1).toString());
      if (!Util.isNullOrNil(paramejx.aaFG.desc)) {
        i.a(this.JCD, ((StringBuilder)localObject1).toString(), i, ((StringBuilder)localObject1).length(), new f(new f.a()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(267323);
            i.bC(HoneyPayReceiveCardUI.this, paramejx.aaFG.Krl);
            AppMethodBeat.o(267323);
          }
        }), this);
      }
      AppMethodBeat.o(64836);
      return;
      Log.d(this.TAG, "no help url");
      this.JCZ.setVisibility(8);
      break;
      label725:
      if (((dah)localObject1).tNW == 2)
      {
        this.JDc.setText(a.i.honey_pay_mother_type);
        break label469;
      }
      this.JDc.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, i.jo(z.bAO(), 16), this.JDc.getTextSize()));
      break label469;
      label775:
      this.JDj.setImageResource(c.fPw());
    }
    label788:
    this.tSj = false;
    this.JCE.setVisibility(8);
    label802:
    AppMethodBeat.o(64836);
  }
  
  private void fPz()
  {
    AppMethodBeat.i(64837);
    Log.i(this.TAG, "qry user detail");
    com.tencent.mm.plugin.honey_pay.a.m localm = new com.tencent.mm.plugin.honey_pay.a.m(this.JAW);
    localm.r(this);
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
    this.JCW = ((ImageView)findViewById(a.f.hprc_avatar_iv));
    this.JCX = ((TextView)findViewById(a.f.hprc_payer_name_tv));
    this.JDc = ((TextView)findViewById(a.f.hprc_user_name_tv));
    i.Q(this.JDc);
    this.JCY = ((TextView)findViewById(a.f.hprc_quota_desc_tv));
    this.JDg = ((TextView)findViewById(a.f.hprc_quota_username_tv));
    this.JCZ = ((TextView)findViewById(a.f.hprc_check_payway_tv));
    this.JDa = ((Button)findViewById(a.f.hprc_receive_btn));
    aw.a(this.JDa.getPaint(), 0.8F);
    this.JDb = ((TextView)findViewById(a.f.hprc_receive_tip_tv));
    this.JDi = ((LinearLayout)findViewById(a.f.hprc_quota_layout));
    this.JDd = ((TextView)findViewById(a.f.hprc_wishing_tv));
    this.JDe = ((TextView)findViewById(a.f.hprc_limit_tv));
    this.JDf = ((TextView)findViewById(a.f.hprc_explain_tv));
    this.JDj = ((CdnImageView)findViewById(a.f.hprc_quota_logo_1_iv));
    this.pLM = ((WcPayBannerView)findViewById(a.f.wc_pay_banner_layout));
    this.JCE = ((LinearLayout)findViewById(a.f.hprc_agreement_layout));
    this.JCF = ((CheckBox)findViewById(a.f.hprc_agreement_cb));
    this.JCD = ((TextView)findViewById(a.f.hprc_agreement_tv));
    this.JDh = ((ImageView)findViewById(a.f.hprc_logo_iv));
    this.JDa.setOnClickListener(new k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(267326);
        if ((HoneyPayReceiveCardUI.a(HoneyPayReceiveCardUI.this).getVisibility() == 0) && (!HoneyPayReceiveCardUI.b(HoneyPayReceiveCardUI.this).isChecked()))
        {
          int i = HoneyPayReceiveCardUI.this.getResources().getDimensionPixelOffset(a.d.Edge_A);
          paramAnonymousView = ObjectAnimator.ofFloat(HoneyPayReceiveCardUI.a(HoneyPayReceiveCardUI.this), "translationX", new float[] { 0.0F, -i, i, -i, 0.0F }).setDuration(300L);
          paramAnonymousView.setInterpolator(new LinearInterpolator());
          paramAnonymousView.start();
          HoneyPayReceiveCardUI.e(HoneyPayReceiveCardUI.this).announceForAccessibility(HoneyPayReceiveCardUI.this.getString(a.i.honey_pay_contract_unchecked, new Object[] { HoneyPayReceiveCardUI.d(HoneyPayReceiveCardUI.this) }));
          AppMethodBeat.o(267326);
          return;
        }
        HoneyPayReceiveCardUI.c(HoneyPayReceiveCardUI.this);
        AppMethodBeat.o(267326);
      }
    });
    if (aw.isDarkMode())
    {
      this.JDh.setImageResource(a.h.honey_pay_bank_logo_dm);
      this.JDa.setTextColor(getResources().getColor(a.c.BW_100_Alpha_0_8));
      this.JCF.setBackgroundResource(a.e.honey_agreement_checkbox_bg_dm);
      AppMethodBeat.o(64833);
      return;
    }
    this.JDh.setImageResource(a.h.honey_pay_bank_logo);
    this.JDa.setTextColor(getResources().getColor(a.c.Orange));
    this.JCF.setBackgroundResource(a.e.honey_agreement_checkbox_bg);
    AppMethodBeat.o(64833);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64832);
    this.GRg = a.c.white;
    super.onCreate(paramBundle);
    com.tencent.mm.pluginsdk.ui.span.p.a(this.JDk);
    addSceneEndListener(2613);
    addSceneEndListener(1983);
    this.JAW = getIntent().getStringExtra("key_card_no");
    this.mScene = getIntent().getIntExtra("key_scene", 0);
    initView();
    if (this.mScene == 1)
    {
      paramBundle = new ejx();
      try
      {
        paramBundle.parseFrom(getIntent().getByteArrayExtra("key_qry_response"));
        a(paramBundle);
        if (paramBundle.aatf != null) {
          setMMTitle(paramBundle.aatf.wtN);
        }
        paramBundle = paramBundle.ign;
        this.pLM.setBannerData(paramBundle);
        this.pLM.setBgColor(getResources().getColor(a.c.Orange));
        this.pLM.setTextColor(getResources().getColor(a.c.White));
        AppMethodBeat.o(64832);
        return;
      }
      catch (IOException paramBundle)
      {
        Log.printErrStackTrace(this.TAG, paramBundle, "", new Object[0]);
        fPz();
        AppMethodBeat.o(64832);
        return;
      }
    }
    fPz();
    AppMethodBeat.o(64832);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64834);
    super.onDestroy();
    com.tencent.mm.pluginsdk.ui.span.p.b(this.JDk);
    removeSceneEndListener(2613);
    removeSceneEndListener(1983);
    if (this.tSj) {
      h.OAn.b(24522, new Object[] { Integer.valueOf(2), Integer.valueOf(3) });
    }
    AppMethodBeat.o(64834);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(64835);
    if ((paramp instanceof com.tencent.mm.plugin.honey_pay.a.m))
    {
      paramString = (com.tencent.mm.plugin.honey_pay.a.m)paramp;
      paramString.a(new r.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
        {
          AppMethodBeat.i(64826);
          HoneyPayReceiveCardUI.a(HoneyPayReceiveCardUI.this, paramString.JAI);
          AppMethodBeat.o(64826);
        }
      }).b(new r.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp) {}
      }).c(new r.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp) {}
      });
    }
    for (;;)
    {
      AppMethodBeat.o(64835);
      return true;
      if ((paramp instanceof e))
      {
        paramString = (e)paramp;
        paramString.a(new r.a()
        {
          public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
          {
            AppMethodBeat.i(64829);
            if (paramString.JAz.Zjb != null)
            {
              Log.i(HoneyPayReceiveCardUI.this.TAG, "do real name");
              paramAnonymousString = new Bundle();
              paramAnonymousString.putString("realname_verify_process_jump_activity", ".ui.HoneyPayReceiveCardUI");
              c.a(HoneyPayReceiveCardUI.this, paramAnonymousString, paramString.JAz.Zjb, false);
            }
            for (;;)
            {
              h.OAn.p(875L, 4L, 1L);
              if (HoneyPayReceiveCardUI.h(HoneyPayReceiveCardUI.this))
              {
                HoneyPayReceiveCardUI.i(HoneyPayReceiveCardUI.this);
                h.OAn.b(24522, new Object[] { Integer.valueOf(2), Integer.valueOf(2) });
              }
              AppMethodBeat.o(64829);
              return;
              HoneyPayReceiveCardUI.f(HoneyPayReceiveCardUI.this);
              paramAnonymousString = HoneyPayReceiveCardUI.g(HoneyPayReceiveCardUI.this);
              paramAnonymousp = new acz();
              paramAnonymousp.igq.scene = 8;
              paramAnonymousp.publish();
              Log.i("MicroMsg.HoneyPayUtil", "trigger offline event");
              paramAnonymousp = new qp();
              paramAnonymousp.hTP.scene = 1;
              paramAnonymousp.hTP.hPg = "qmf";
              paramAnonymousp.publish();
              if (!Util.isNullOrNil(paramAnonymousString)) {
                d.aQL(paramAnonymousString);
              }
              HoneyPayReceiveCardUI.this.finish();
            }
          }
        }).b(new r.a()
        {
          public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
          {
            AppMethodBeat.i(64828);
            if (paramString.JAz.Zjb != null)
            {
              Log.i(HoneyPayReceiveCardUI.this.TAG, "do real name");
              paramAnonymousString = new Bundle();
              paramAnonymousString.putString("realname_verify_process_jump_activity", ".ui.HoneyPayReceiveCardUI");
              c.a(HoneyPayReceiveCardUI.this, paramAnonymousString, paramString.JAz.Zjb, false);
            }
            h.OAn.p(875L, 5L, 1L);
            AppMethodBeat.o(64828);
          }
        }).c(new r.a()
        {
          public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
          {
            AppMethodBeat.i(64827);
            h.OAn.p(875L, 5L, 1L);
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
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(267356);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(HoneyPayReceiveCardUI.a.class);
    AppMethodBeat.o(267356);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayReceiveCardUI
 * JD-Core Version:    0.7.0.1
 */