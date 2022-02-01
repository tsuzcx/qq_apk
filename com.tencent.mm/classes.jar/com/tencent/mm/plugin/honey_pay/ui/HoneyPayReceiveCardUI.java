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
import com.tencent.mm.g.a.mw;
import com.tencent.mm.g.a.xf;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.honey_pay.a.m;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.auz;
import com.tencent.mm.protocal.protobuf.bgl;
import com.tencent.mm.protocal.protobuf.cel;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;
import java.io.IOException;

public class HoneyPayReceiveCardUI
  extends HoneyPayBaseUI
{
  private int mScene;
  private String svk;
  private ImageView swY;
  private TextView swZ;
  private TextView sxa;
  private TextView sxb;
  private TextView sxc;
  private TextView sxd;
  private TextView sxe;
  private TextView sxf;
  private TextView sxg;
  private TextView sxh;
  private LinearLayout sxi;
  private CdnImageView sxj;
  private com.tencent.mm.pluginsdk.ui.span.h sxk;
  
  public HoneyPayReceiveCardUI()
  {
    AppMethodBeat.i(64831);
    this.sxk = new HoneyPayReceiveCardUI.1(this);
    AppMethodBeat.o(64831);
  }
  
  private void a(final cel paramcel)
  {
    AppMethodBeat.i(64836);
    if (paramcel.DuB == null)
    {
      AppMethodBeat.o(64836);
      return;
    }
    bgl localbgl = paramcel.DuB;
    this.sxd.setText(localbgl.DEn);
    this.sxf.setText(k.b(getContext(), localbgl.sYt, this.sxf.getTextSize()));
    Object localObject = new Bundle();
    ((Bundle)localObject).putBoolean("click_help", true);
    this.sxg.setText(k.a(getContext(), localbgl.vuQ, (int)this.sxg.getTextSize(), localObject));
    this.sxg.setClickable(true);
    this.sxg.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
    if (!bt.isNullOrNil(paramcel.DWS))
    {
      localObject = new q(new q.a()
      {
        public final void dI(View paramAnonymousView)
        {
          AppMethodBeat.i(64830);
          if (!bt.isNullOrNil(paramcel.DWT)) {
            com.tencent.mm.wallet_core.ui.e.p(HoneyPayReceiveCardUI.this.getContext(), paramcel.DWT, false);
          }
          com.tencent.mm.plugin.report.service.h.vKh.f(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          AppMethodBeat.o(64830);
        }
      });
      paramcel = new SpannableString(paramcel.DWS);
      paramcel.setSpan(localObject, 0, paramcel.length(), 18);
      this.sxb.setText(paramcel);
      this.sxb.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
      this.sxb.setClickable(true);
      this.sxa.setText(localbgl.nsJ);
      a.b.a(this.swY, localbgl.CsC, 0.06F, false);
      com.tencent.mm.wallet_core.ui.e.f(this.swZ, localbgl.CsC);
      com.tencent.mm.wallet_core.ui.e.f(this.sxh, localbgl.CsC);
      if (localbgl.lpz != 1) {
        break label321;
      }
      this.sxe.setText(2131760263);
    }
    for (;;)
    {
      if (bt.isNullOrNil(localbgl.odo)) {
        break label370;
      }
      this.sxj.fz(localbgl.odo, c.cFL());
      AppMethodBeat.o(64836);
      return;
      ad.d(this.TAG, "no help url");
      this.sxb.setVisibility(8);
      break;
      label321:
      if (localbgl.lpz == 2) {
        this.sxe.setText(2131760290);
      } else {
        this.sxe.setText(k.b(this, com.tencent.mm.wallet_core.ui.e.gn(u.aqI(), 16), this.sxe.getTextSize()));
      }
    }
    label370:
    this.sxj.setImageResource(c.cFL());
    AppMethodBeat.o(64836);
  }
  
  private void cFO()
  {
    AppMethodBeat.i(64837);
    ad.i(this.TAG, "qry user detail");
    m localm = new m(this.svk);
    localm.q(this);
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
    this.swY = ((ImageView)findViewById(2131300848));
    this.swZ = ((TextView)findViewById(2131300851));
    this.sxe = ((TextView)findViewById(2131300858));
    this.sxa = ((TextView)findViewById(2131300852));
    this.sxh = ((TextView)findViewById(2131300855));
    this.sxb = ((TextView)findViewById(2131300849));
    this.sxc = ((TextView)findViewById(2131300856));
    this.sxd = ((TextView)findViewById(2131300857));
    this.sxi = ((LinearLayout)findViewById(2131300853));
    this.sxf = ((TextView)findViewById(2131300859));
    this.sxg = ((TextView)findViewById(2131300850));
    this.sxj = ((CdnImageView)findViewById(2131300854));
    this.sxc.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64825);
        HoneyPayReceiveCardUI.a(HoneyPayReceiveCardUI.this);
        AppMethodBeat.o(64825);
      }
    });
    AppMethodBeat.o(64833);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64832);
    this.svd = 2131100493;
    super.onCreate(paramBundle);
    k.a(this.sxk);
    addSceneEndListener(2613);
    addSceneEndListener(1983);
    this.svk = getIntent().getStringExtra("key_card_no");
    this.mScene = getIntent().getIntExtra("key_scene", 0);
    initView();
    if (this.mScene == 1)
    {
      paramBundle = new cel();
      try
      {
        paramBundle.parseFrom(getIntent().getByteArrayExtra("key_qry_response"));
        a(paramBundle);
        if (paramBundle.DuB != null) {
          setMMTitle(paramBundle.DuB.nsJ);
        }
        AppMethodBeat.o(64832);
        return;
      }
      catch (IOException paramBundle)
      {
        ad.printErrStackTrace(this.TAG, paramBundle, "", new Object[0]);
        cFO();
        AppMethodBeat.o(64832);
        return;
      }
    }
    cFO();
    AppMethodBeat.o(64832);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64834);
    super.onDestroy();
    k.b(this.sxk);
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
          HoneyPayReceiveCardUI.a(HoneyPayReceiveCardUI.this, paramString.suV);
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
            if (paramString.suM.CWv != null)
            {
              ad.i(HoneyPayReceiveCardUI.this.TAG, "do real name");
              paramAnonymousString = new Bundle();
              paramAnonymousString.putString("realname_verify_process_jump_activity", ".ui.HoneyPayReceiveCardUI");
              c.a(HoneyPayReceiveCardUI.this, paramAnonymousString, paramString.suM.CWv, false);
            }
            for (;;)
            {
              com.tencent.mm.plugin.report.service.h.vKh.m(875L, 4L, 1L);
              AppMethodBeat.o(64829);
              return;
              HoneyPayReceiveCardUI.b(HoneyPayReceiveCardUI.this);
              paramAnonymousString = HoneyPayReceiveCardUI.c(HoneyPayReceiveCardUI.this);
              paramAnonymousn = new xf();
              paramAnonymousn.dCH.scene = 8;
              com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousn);
              ad.i("MicroMsg.HoneyPayUtil", "trigger offline event");
              paramAnonymousn = new mw();
              paramAnonymousn.dsc.scene = 1;
              paramAnonymousn.dsc.dol = "qmf";
              com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousn);
              if (!bt.isNullOrNil(paramAnonymousString)) {
                com.tencent.mm.plugin.offline.c.a.ajL(paramAnonymousString);
              }
              HoneyPayReceiveCardUI.this.finish();
            }
          }
        }).b(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
          {
            AppMethodBeat.i(64828);
            if (paramString.suM.CWv != null)
            {
              ad.i(HoneyPayReceiveCardUI.this.TAG, "do real name");
              paramAnonymousString = new Bundle();
              paramAnonymousString.putString("realname_verify_process_jump_activity", ".ui.HoneyPayReceiveCardUI");
              c.a(HoneyPayReceiveCardUI.this, paramAnonymousString, paramString.suM.CWv, false);
            }
            com.tencent.mm.plugin.report.service.h.vKh.m(875L, 5L, 1L);
            AppMethodBeat.o(64828);
          }
        }).c(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
          {
            AppMethodBeat.i(64827);
            com.tencent.mm.plugin.report.service.h.vKh.m(875L, 5L, 1L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayReceiveCardUI
 * JD-Core Version:    0.7.0.1
 */