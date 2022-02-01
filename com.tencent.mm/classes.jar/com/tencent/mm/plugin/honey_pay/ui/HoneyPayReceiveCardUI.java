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
import com.tencent.mm.g.a.nf;
import com.tencent.mm.g.a.xq;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.honey_pay.a.m;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.ayf;
import com.tencent.mm.protocal.protobuf.bkd;
import com.tencent.mm.protocal.protobuf.cjo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;
import java.io.IOException;

public class HoneyPayReceiveCardUI
  extends HoneyPayBaseUI
{
  private int mScene;
  private String tCZ;
  private ImageView tEN;
  private TextView tEO;
  private TextView tEP;
  private TextView tEQ;
  private TextView tER;
  private TextView tES;
  private TextView tET;
  private TextView tEU;
  private TextView tEV;
  private TextView tEW;
  private LinearLayout tEX;
  private CdnImageView tEY;
  private com.tencent.mm.pluginsdk.ui.span.h tEZ;
  
  public HoneyPayReceiveCardUI()
  {
    AppMethodBeat.i(64831);
    this.tEZ = new HoneyPayReceiveCardUI.1(this);
    AppMethodBeat.o(64831);
  }
  
  private void a(final cjo paramcjo)
  {
    AppMethodBeat.i(64836);
    if (paramcjo.EPK == null)
    {
      AppMethodBeat.o(64836);
      return;
    }
    bkd localbkd = paramcjo.EPK;
    this.tES.setText(localbkd.EZI);
    this.tEU.setText(k.b(getContext(), localbkd.ugH, this.tEU.getTextSize()));
    Object localObject = new Bundle();
    ((Bundle)localObject).putBoolean("click_help", true);
    this.tEV.setText(k.a(getContext(), localbkd.wEV, (int)this.tEV.getTextSize(), localObject));
    this.tEV.setClickable(true);
    this.tEV.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
    if (!bs.isNullOrNil(paramcjo.FtL))
    {
      localObject = new q(new q.a()
      {
        public final void dK(View paramAnonymousView)
        {
          AppMethodBeat.i(64830);
          if (!bs.isNullOrNil(paramcjo.FtM)) {
            com.tencent.mm.wallet_core.ui.e.o(HoneyPayReceiveCardUI.this.getContext(), paramcjo.FtM, false);
          }
          com.tencent.mm.plugin.report.service.h.wUl.f(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          AppMethodBeat.o(64830);
        }
      });
      paramcjo = new SpannableString(paramcjo.FtL);
      paramcjo.setSpan(localObject, 0, paramcjo.length(), 18);
      this.tEQ.setText(paramcjo);
      this.tEQ.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
      this.tEQ.setClickable(true);
      this.tEP.setText(localbkd.nVJ);
      a.b.a(this.tEN, localbkd.DKT, 0.06F, false);
      com.tencent.mm.wallet_core.ui.e.f(this.tEO, localbkd.DKT);
      com.tencent.mm.wallet_core.ui.e.f(this.tEW, localbkd.DKT);
      if (localbkd.lRv != 1) {
        break label321;
      }
      this.tET.setText(2131760263);
    }
    for (;;)
    {
      if (bs.isNullOrNil(localbkd.oGN)) {
        break label370;
      }
      this.tEY.fE(localbkd.oGN, c.cSV());
      AppMethodBeat.o(64836);
      return;
      ac.d(this.TAG, "no help url");
      this.tEQ.setVisibility(8);
      break;
      label321:
      if (localbkd.lRv == 2) {
        this.tET.setText(2131760290);
      } else {
        this.tET.setText(k.b(this, com.tencent.mm.wallet_core.ui.e.gr(u.axy(), 16), this.tET.getTextSize()));
      }
    }
    label370:
    this.tEY.setImageResource(c.cSV());
    AppMethodBeat.o(64836);
  }
  
  private void cSY()
  {
    AppMethodBeat.i(64837);
    ac.i(this.TAG, "qry user detail");
    m localm = new m(this.tCZ);
    localm.r(this);
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
    this.tEN = ((ImageView)findViewById(2131300848));
    this.tEO = ((TextView)findViewById(2131300851));
    this.tET = ((TextView)findViewById(2131300858));
    this.tEP = ((TextView)findViewById(2131300852));
    this.tEW = ((TextView)findViewById(2131300855));
    this.tEQ = ((TextView)findViewById(2131300849));
    this.tER = ((TextView)findViewById(2131300856));
    this.tES = ((TextView)findViewById(2131300857));
    this.tEX = ((LinearLayout)findViewById(2131300853));
    this.tEU = ((TextView)findViewById(2131300859));
    this.tEV = ((TextView)findViewById(2131300850));
    this.tEY = ((CdnImageView)findViewById(2131300854));
    this.tER.setOnClickListener(new View.OnClickListener()
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
    this.tCS = 2131100493;
    super.onCreate(paramBundle);
    k.a(this.tEZ);
    addSceneEndListener(2613);
    addSceneEndListener(1983);
    this.tCZ = getIntent().getStringExtra("key_card_no");
    this.mScene = getIntent().getIntExtra("key_scene", 0);
    initView();
    if (this.mScene == 1)
    {
      paramBundle = new cjo();
      try
      {
        paramBundle.parseFrom(getIntent().getByteArrayExtra("key_qry_response"));
        a(paramBundle);
        if (paramBundle.EPK != null) {
          setMMTitle(paramBundle.EPK.nVJ);
        }
        AppMethodBeat.o(64832);
        return;
      }
      catch (IOException paramBundle)
      {
        ac.printErrStackTrace(this.TAG, paramBundle, "", new Object[0]);
        cSY();
        AppMethodBeat.o(64832);
        return;
      }
    }
    cSY();
    AppMethodBeat.o(64832);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64834);
    super.onDestroy();
    k.b(this.tEZ);
    removeSceneEndListener(2613);
    removeSceneEndListener(1983);
    AppMethodBeat.o(64834);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(64835);
    if ((paramn instanceof m))
    {
      paramString = (m)paramn;
      paramString.a(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
        {
          AppMethodBeat.i(64826);
          HoneyPayReceiveCardUI.a(HoneyPayReceiveCardUI.this, paramString.tCK);
          AppMethodBeat.o(64826);
        }
      }).b(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn) {}
      }).c(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn) {}
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
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
          {
            AppMethodBeat.i(64829);
            if (paramString.tCB.Epe != null)
            {
              ac.i(HoneyPayReceiveCardUI.this.TAG, "do real name");
              paramAnonymousString = new Bundle();
              paramAnonymousString.putString("realname_verify_process_jump_activity", ".ui.HoneyPayReceiveCardUI");
              c.a(HoneyPayReceiveCardUI.this, paramAnonymousString, paramString.tCB.Epe, false);
            }
            for (;;)
            {
              com.tencent.mm.plugin.report.service.h.wUl.n(875L, 4L, 1L);
              AppMethodBeat.o(64829);
              return;
              HoneyPayReceiveCardUI.b(HoneyPayReceiveCardUI.this);
              paramAnonymousString = HoneyPayReceiveCardUI.c(HoneyPayReceiveCardUI.this);
              paramAnonymousn = new xq();
              paramAnonymousn.dAt.scene = 8;
              com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousn);
              ac.i("MicroMsg.HoneyPayUtil", "trigger offline event");
              paramAnonymousn = new nf();
              paramAnonymousn.dpN.scene = 1;
              paramAnonymousn.dpN.dlU = "qmf";
              com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousn);
              if (!bs.isNullOrNil(paramAnonymousString)) {
                com.tencent.mm.plugin.offline.c.a.aoJ(paramAnonymousString);
              }
              HoneyPayReceiveCardUI.this.finish();
            }
          }
        }).b(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
          {
            AppMethodBeat.i(64828);
            if (paramString.tCB.Epe != null)
            {
              ac.i(HoneyPayReceiveCardUI.this.TAG, "do real name");
              paramAnonymousString = new Bundle();
              paramAnonymousString.putString("realname_verify_process_jump_activity", ".ui.HoneyPayReceiveCardUI");
              c.a(HoneyPayReceiveCardUI.this, paramAnonymousString, paramString.tCB.Epe, false);
            }
            com.tencent.mm.plugin.report.service.h.wUl.n(875L, 5L, 1L);
            AppMethodBeat.o(64828);
          }
        }).c(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
          {
            AppMethodBeat.i(64827);
            com.tencent.mm.plugin.report.service.h.wUl.n(875L, 5L, 1L);
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