package com.tencent.mm.plugin.honey_pay.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nn;
import com.tencent.mm.g.a.yk;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.honey_pay.a.m;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.h;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.protocal.protobuf.bon;
import com.tencent.mm.protocal.protobuf.coo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;
import java.io.IOException;

public class HoneyPayReceiveCardUI
  extends HoneyPayBaseUI
{
  private int mScene;
  private String uFI;
  private TextView uHA;
  private TextView uHB;
  private TextView uHC;
  private TextView uHD;
  private TextView uHE;
  private TextView uHF;
  private LinearLayout uHG;
  private CdnImageView uHH;
  private h uHI;
  private ImageView uHw;
  private TextView uHx;
  private TextView uHy;
  private TextView uHz;
  
  public HoneyPayReceiveCardUI()
  {
    AppMethodBeat.i(64831);
    this.uHI = new HoneyPayReceiveCardUI.1(this);
    AppMethodBeat.o(64831);
  }
  
  private void a(coo paramcoo)
  {
    AppMethodBeat.i(64836);
    if (paramcoo.Gzb == null)
    {
      AppMethodBeat.o(64836);
      return;
    }
    bon localbon = paramcoo.Gzb;
    this.uHB.setText(localbon.GJh);
    this.uHD.setText(k.b(getContext(), localbon.vjr, this.uHD.getTextSize()));
    Object localObject = new Bundle();
    ((Bundle)localObject).putBoolean("click_help", true);
    this.uHE.setText(k.a(getContext(), localbon.xSC, (int)this.uHE.getTextSize(), localObject));
    this.uHE.setClickable(true);
    this.uHE.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
    if (!bt.isNullOrNil(paramcoo.HdQ))
    {
      localObject = new q(new HoneyPayReceiveCardUI.9(this, paramcoo));
      paramcoo = new SpannableString(paramcoo.HdQ);
      paramcoo.setSpan(localObject, 0, paramcoo.length(), 18);
      this.uHz.setText(paramcoo);
      this.uHz.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
      this.uHz.setClickable(true);
      this.uHy.setText(localbon.ozd);
      a.b.a(this.uHw, localbon.FpZ, 0.06F, false);
      com.tencent.mm.wallet_core.ui.e.f(this.uHx, localbon.FpZ);
      com.tencent.mm.wallet_core.ui.e.f(this.uHF, localbon.FpZ);
      if (localbon.mrl != 1) {
        break label321;
      }
      this.uHC.setText(2131760263);
    }
    for (;;)
    {
      if (bt.isNullOrNil(localbon.pkr)) {
        break label370;
      }
      this.uHH.gb(localbon.pkr, c.dcc());
      AppMethodBeat.o(64836);
      return;
      ad.d(this.TAG, "no help url");
      this.uHz.setVisibility(8);
      break;
      label321:
      if (localbon.mrl == 2) {
        this.uHC.setText(2131760290);
      } else {
        this.uHC.setText(k.b(this, com.tencent.mm.wallet_core.ui.e.gO(u.aAo(), 16), this.uHC.getTextSize()));
      }
    }
    label370:
    this.uHH.setImageResource(c.dcc());
    AppMethodBeat.o(64836);
  }
  
  private void dcf()
  {
    AppMethodBeat.i(64837);
    ad.i(this.TAG, "qry user detail");
    m localm = new m(this.uFI);
    localm.t(this);
    doSceneProgress(localm, true);
    AppMethodBeat.o(64837);
  }
  
  public int getLayoutId()
  {
    return 2131494452;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64833);
    this.uHw = ((ImageView)findViewById(2131300848));
    this.uHx = ((TextView)findViewById(2131300851));
    this.uHC = ((TextView)findViewById(2131300858));
    this.uHy = ((TextView)findViewById(2131300852));
    this.uHF = ((TextView)findViewById(2131300855));
    this.uHz = ((TextView)findViewById(2131300849));
    this.uHA = ((TextView)findViewById(2131300856));
    this.uHB = ((TextView)findViewById(2131300857));
    this.uHG = ((LinearLayout)findViewById(2131300853));
    this.uHD = ((TextView)findViewById(2131300859));
    this.uHE = ((TextView)findViewById(2131300850));
    this.uHH = ((CdnImageView)findViewById(2131300854));
    this.uHA.setOnClickListener(new HoneyPayReceiveCardUI.2(this));
    AppMethodBeat.o(64833);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64832);
    this.uFB = 2131100493;
    super.onCreate(paramBundle);
    k.a(this.uHI);
    addSceneEndListener(2613);
    addSceneEndListener(1983);
    this.uFI = getIntent().getStringExtra("key_card_no");
    this.mScene = getIntent().getIntExtra("key_scene", 0);
    initView();
    if (this.mScene == 1)
    {
      paramBundle = new coo();
      try
      {
        paramBundle.parseFrom(getIntent().getByteArrayExtra("key_qry_response"));
        a(paramBundle);
        if (paramBundle.Gzb != null) {
          setMMTitle(paramBundle.Gzb.ozd);
        }
        AppMethodBeat.o(64832);
        return;
      }
      catch (IOException paramBundle)
      {
        ad.printErrStackTrace(this.TAG, paramBundle, "", new Object[0]);
        dcf();
        AppMethodBeat.o(64832);
        return;
      }
    }
    dcf();
    AppMethodBeat.o(64832);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64834);
    super.onDestroy();
    k.b(this.uHI);
    removeSceneEndListener(2613);
    removeSceneEndListener(1983);
    AppMethodBeat.o(64834);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(64835);
    if ((paramn instanceof m))
    {
      paramString = (m)paramn;
      paramString.a(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
        {
          AppMethodBeat.i(64826);
          HoneyPayReceiveCardUI.a(HoneyPayReceiveCardUI.this, paramString.uFt);
          AppMethodBeat.o(64826);
        }
      }).b(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn) {}
      }).c(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn) {}
      });
    }
    for (;;)
    {
      AppMethodBeat.o(64835);
      return true;
      if ((paramn instanceof com.tencent.mm.plugin.honey_pay.a.e))
      {
        paramString = (com.tencent.mm.plugin.honey_pay.a.e)paramn;
        paramString.a(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
          {
            AppMethodBeat.i(64829);
            if (paramString.uFk.FWq != null)
            {
              ad.i(HoneyPayReceiveCardUI.this.TAG, "do real name");
              paramAnonymousString = new Bundle();
              paramAnonymousString.putString("realname_verify_process_jump_activity", ".ui.HoneyPayReceiveCardUI");
              c.a(HoneyPayReceiveCardUI.this, paramAnonymousString, paramString.uFk.FWq, false);
            }
            for (;;)
            {
              g.yhR.n(875L, 4L, 1L);
              AppMethodBeat.o(64829);
              return;
              HoneyPayReceiveCardUI.b(HoneyPayReceiveCardUI.this);
              paramAnonymousString = HoneyPayReceiveCardUI.c(HoneyPayReceiveCardUI.this);
              paramAnonymousn = new yk();
              paramAnonymousn.dMG.scene = 8;
              com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousn);
              ad.i("MicroMsg.HoneyPayUtil", "trigger offline event");
              paramAnonymousn = new nn();
              paramAnonymousn.dBA.scene = 1;
              paramAnonymousn.dBA.dxI = "qmf";
              com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousn);
              if (!bt.isNullOrNil(paramAnonymousString)) {
                com.tencent.mm.plugin.offline.c.a.atJ(paramAnonymousString);
              }
              HoneyPayReceiveCardUI.this.finish();
            }
          }
        }).b(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
          {
            AppMethodBeat.i(64828);
            if (paramString.uFk.FWq != null)
            {
              ad.i(HoneyPayReceiveCardUI.this.TAG, "do real name");
              paramAnonymousString = new Bundle();
              paramAnonymousString.putString("realname_verify_process_jump_activity", ".ui.HoneyPayReceiveCardUI");
              c.a(HoneyPayReceiveCardUI.this, paramAnonymousString, paramString.uFk.FWq, false);
            }
            g.yhR.n(875L, 5L, 1L);
            AppMethodBeat.o(64828);
          }
        }).c(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
          {
            AppMethodBeat.i(64827);
            g.yhR.n(875L, 5L, 1L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayReceiveCardUI
 * JD-Core Version:    0.7.0.1
 */