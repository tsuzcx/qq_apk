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
import com.tencent.mm.g.a.no;
import com.tencent.mm.g.a.yq;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.honey_pay.a.e;
import com.tencent.mm.plugin.honey_pay.a.m;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.h;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.bpf;
import com.tencent.mm.protocal.protobuf.cpi;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;
import com.tencent.mm.wallet_core.ui.f;
import java.io.IOException;

public class HoneyPayReceiveCardUI
  extends HoneyPayBaseUI
{
  private int mScene;
  private String uRv;
  private ImageView uTj;
  private TextView uTk;
  private TextView uTl;
  private TextView uTm;
  private TextView uTn;
  private TextView uTo;
  private TextView uTp;
  private TextView uTq;
  private TextView uTr;
  private TextView uTs;
  private LinearLayout uTt;
  private CdnImageView uTu;
  private h uTv;
  
  public HoneyPayReceiveCardUI()
  {
    AppMethodBeat.i(64831);
    this.uTv = new HoneyPayReceiveCardUI.1(this);
    AppMethodBeat.o(64831);
  }
  
  private void a(final cpi paramcpi)
  {
    AppMethodBeat.i(64836);
    if (paramcpi.GSB == null)
    {
      AppMethodBeat.o(64836);
      return;
    }
    bpf localbpf = paramcpi.GSB;
    this.uTo.setText(localbpf.HcI);
    this.uTq.setText(k.b(getContext(), localbpf.vvw, this.uTq.getTextSize()));
    Object localObject = new Bundle();
    ((Bundle)localObject).putBoolean("click_help", true);
    this.uTr.setText(k.a(getContext(), localbpf.yiv, (int)this.uTr.getTextSize(), localObject));
    this.uTr.setClickable(true);
    this.uTr.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
    if (!bu.isNullOrNil(paramcpi.Hxq))
    {
      localObject = new q(new q.a()
      {
        public final void dN(View paramAnonymousView)
        {
          AppMethodBeat.i(64830);
          if (!bu.isNullOrNil(paramcpi.Hxr)) {
            f.p(HoneyPayReceiveCardUI.this.getContext(), paramcpi.Hxr, false);
          }
          g.yxI.f(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          AppMethodBeat.o(64830);
        }
      });
      paramcpi = new SpannableString(paramcpi.Hxq);
      paramcpi.setSpan(localObject, 0, paramcpi.length(), 18);
      this.uTm.setText(paramcpi);
      this.uTm.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
      this.uTm.setClickable(true);
      this.uTl.setText(localbpf.oFF);
      a.b.a(this.uTj, localbpf.FIx, 0.06F, false);
      f.g(this.uTk, localbpf.FIx);
      f.g(this.uTs, localbpf.FIx);
      if (localbpf.mwj != 1) {
        break label321;
      }
      this.uTp.setText(2131760263);
    }
    for (;;)
    {
      if (bu.isNullOrNil(localbpf.pqW)) {
        break label370;
      }
      this.uTu.gk(localbpf.pqW, c.deU());
      AppMethodBeat.o(64836);
      return;
      ae.d(this.TAG, "no help url");
      this.uTm.setVisibility(8);
      break;
      label321:
      if (localbpf.mwj == 2) {
        this.uTp.setText(2131760290);
      } else {
        this.uTp.setText(k.b(this, f.gX(v.aAE(), 16), this.uTp.getTextSize()));
      }
    }
    label370:
    this.uTu.setImageResource(c.deU());
    AppMethodBeat.o(64836);
  }
  
  private void deX()
  {
    AppMethodBeat.i(64837);
    ae.i(this.TAG, "qry user detail");
    m localm = new m(this.uRv);
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
    this.uTj = ((ImageView)findViewById(2131300848));
    this.uTk = ((TextView)findViewById(2131300851));
    this.uTp = ((TextView)findViewById(2131300858));
    this.uTl = ((TextView)findViewById(2131300852));
    this.uTs = ((TextView)findViewById(2131300855));
    this.uTm = ((TextView)findViewById(2131300849));
    this.uTn = ((TextView)findViewById(2131300856));
    this.uTo = ((TextView)findViewById(2131300857));
    this.uTt = ((LinearLayout)findViewById(2131300853));
    this.uTq = ((TextView)findViewById(2131300859));
    this.uTr = ((TextView)findViewById(2131300850));
    this.uTu = ((CdnImageView)findViewById(2131300854));
    this.uTn.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64825);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPayReceiveCardUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
    this.uRo = 2131100493;
    super.onCreate(paramBundle);
    k.a(this.uTv);
    addSceneEndListener(2613);
    addSceneEndListener(1983);
    this.uRv = getIntent().getStringExtra("key_card_no");
    this.mScene = getIntent().getIntExtra("key_scene", 0);
    initView();
    if (this.mScene == 1)
    {
      paramBundle = new cpi();
      try
      {
        paramBundle.parseFrom(getIntent().getByteArrayExtra("key_qry_response"));
        a(paramBundle);
        if (paramBundle.GSB != null) {
          setMMTitle(paramBundle.GSB.oFF);
        }
        AppMethodBeat.o(64832);
        return;
      }
      catch (IOException paramBundle)
      {
        ae.printErrStackTrace(this.TAG, paramBundle, "", new Object[0]);
        deX();
        AppMethodBeat.o(64832);
        return;
      }
    }
    deX();
    AppMethodBeat.o(64832);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64834);
    super.onDestroy();
    k.b(this.uTv);
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
          HoneyPayReceiveCardUI.a(HoneyPayReceiveCardUI.this, paramString.uRg);
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
      if ((paramn instanceof e))
      {
        paramString = (e)paramn;
        paramString.a(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
          {
            AppMethodBeat.i(64829);
            if (paramString.uQX.GoP != null)
            {
              ae.i(HoneyPayReceiveCardUI.this.TAG, "do real name");
              paramAnonymousString = new Bundle();
              paramAnonymousString.putString("realname_verify_process_jump_activity", ".ui.HoneyPayReceiveCardUI");
              c.a(HoneyPayReceiveCardUI.this, paramAnonymousString, paramString.uQX.GoP, false);
            }
            for (;;)
            {
              g.yxI.n(875L, 4L, 1L);
              AppMethodBeat.o(64829);
              return;
              HoneyPayReceiveCardUI.b(HoneyPayReceiveCardUI.this);
              paramAnonymousString = HoneyPayReceiveCardUI.c(HoneyPayReceiveCardUI.this);
              paramAnonymousn = new yq();
              paramAnonymousn.dNW.scene = 8;
              com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousn);
              ae.i("MicroMsg.HoneyPayUtil", "trigger offline event");
              paramAnonymousn = new no();
              paramAnonymousn.dCF.scene = 1;
              paramAnonymousn.dCF.dyN = "qmf";
              com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousn);
              if (!bu.isNullOrNil(paramAnonymousString)) {
                com.tencent.mm.plugin.offline.c.a.auY(paramAnonymousString);
              }
              HoneyPayReceiveCardUI.this.finish();
            }
          }
        }).b(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
          {
            AppMethodBeat.i(64828);
            if (paramString.uQX.GoP != null)
            {
              ae.i(HoneyPayReceiveCardUI.this.TAG, "do real name");
              paramAnonymousString = new Bundle();
              paramAnonymousString.putString("realname_verify_process_jump_activity", ".ui.HoneyPayReceiveCardUI");
              c.a(HoneyPayReceiveCardUI.this, paramAnonymousString, paramString.uQX.GoP, false);
            }
            g.yxI.n(875L, 5L, 1L);
            AppMethodBeat.o(64828);
          }
        }).c(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
          {
            AppMethodBeat.i(64827);
            g.yxI.n(875L, 5L, 1L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayReceiveCardUI
 * JD-Core Version:    0.7.0.1
 */