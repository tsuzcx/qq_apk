package com.tencent.mm.plugin.honey_pay.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.honey_pay.a.m;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.bns;
import com.tencent.mm.protocal.protobuf.bpf;
import com.tencent.mm.protocal.protobuf.cpi;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;
import com.tencent.mm.wallet_core.ui.f;
import java.io.IOException;

public class HoneyPayCardDetailUI
  extends HoneyPayBaseUI
{
  private int mScene;
  private ImageView pjj;
  private TextView uRA;
  private TextView uRB;
  private TextView uRC;
  private TextView uRD;
  private TextView uRE;
  private RelativeLayout uRF;
  private CdnImageView uRG;
  private TextView uRH;
  private Button uRI;
  private cpi uRJ;
  private bns uRK;
  private String uRv;
  private TextView uRz;
  
  private void deW()
  {
    AppMethodBeat.i(64675);
    if (this.uRJ.GSB == null)
    {
      AppMethodBeat.o(64675);
      return;
    }
    bpf localbpf = this.uRJ.GSB;
    setMMTitle(localbpf.oFF);
    this.uRz.setText(localbpf.HcM);
    int i = localbpf.state;
    if (i == 2)
    {
      this.pjj.setImageResource(2131690559);
      this.pjj.setColorFilter(getContext().getResources().getColor(2131099699), PorterDuff.Mode.SRC_ATOP);
      if (!bu.isNullOrNil(localbpf.HcI))
      {
        localbpf.HcI = c.U(localbpf.HcI, this.uRJ.GSB.FIx, -1);
        this.uRA.setText(k.a(this, localbpf.HcI, (int)this.uRA.getTextSize(), null));
      }
      findViewById(2131300773).setVisibility(8);
      findViewById(2131300774).setVisibility(8);
      findViewById(2131300781).setVisibility(8);
      if (this.uRK != null)
      {
        this.uRF.setVisibility(0);
        this.uRG.setUrl(this.uRK.dEM);
        this.uRH.setText(this.uRK.HaD);
        this.uRI.setText(this.uRK.HaC);
        this.uRI.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(64670);
            b localb = new b();
            localb.bd(paramAnonymousView);
            a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPayCardDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            ae.d(HoneyPayCardDetailUI.this.TAG, "click oper btn: %s", new Object[] { HoneyPayCardDetailUI.b(HoneyPayCardDetailUI.this).url });
            if (!bu.isNullOrNil(HoneyPayCardDetailUI.b(HoneyPayCardDetailUI.this).url)) {
              f.p(HoneyPayCardDetailUI.this.getContext(), HoneyPayCardDetailUI.b(HoneyPayCardDetailUI.this).url, false);
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
        this.pjj.setImageResource(2131691097);
        if (!bu.isNullOrNil(localbpf.HcI)) {
          this.uRA.setText(localbpf.HcI);
        }
        this.uRB.setText(2131760303);
        this.uRC.setText(2131760305);
        this.uRD.setText(c.yf(this.uRJ.GSB.FZN));
        this.uRE.setText(c.yf(this.uRJ.GSB.oEe));
        AppMethodBeat.o(64675);
        return;
      }
      if (i == 4)
      {
        this.pjj.setImageResource(2131691097);
        if (!bu.isNullOrNil(localbpf.HcI)) {
          this.uRA.setText(k.d(this, localbpf.HcI, (int)this.uRA.getTextSize()));
        }
        this.uRB.setText(2131760304);
        this.uRD.setText(c.yf(this.uRJ.GSB.HcK));
        findViewById(2131300781).setVisibility(8);
      }
    }
    AppMethodBeat.o(64675);
  }
  
  private void deX()
  {
    AppMethodBeat.i(64676);
    m localm = new m(this.uRv);
    localm.t(this);
    doSceneProgress(localm, true);
    AppMethodBeat.o(64676);
  }
  
  public int getLayoutId()
  {
    return 2131494438;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64672);
    this.pjj = ((ImageView)findViewById(2131300786));
    this.uRz = ((TextView)findViewById(2131300785));
    this.uRA = ((TextView)findViewById(2131300784));
    this.uRD = ((TextView)findViewById(2131300776));
    this.uRE = ((TextView)findViewById(2131300783));
    this.uRB = ((TextView)findViewById(2131300775));
    this.uRC = ((TextView)findViewById(2131300782));
    this.uRF = ((RelativeLayout)findViewById(2131300780));
    this.uRG = ((CdnImageView)findViewById(2131300779));
    this.uRH = ((TextView)findViewById(2131300778));
    this.uRI = ((Button)findViewById(2131300777));
    this.uRA.setClickable(true);
    this.uRA.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
    AppMethodBeat.o(64672);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64671);
    this.uRo = 2131100493;
    super.onCreate(paramBundle);
    addSceneEndListener(2613);
    this.mScene = getIntent().getIntExtra("key_scene", 0);
    this.uRv = getIntent().getStringExtra("key_card_no");
    initView();
    if (this.mScene == 0)
    {
      deX();
      AppMethodBeat.o(64671);
      return;
    }
    paramBundle = getIntent().getByteArrayExtra("key_qry_response");
    try
    {
      this.uRJ = new cpi();
      this.uRJ.parseFrom(paramBundle);
      deW();
      AppMethodBeat.o(64671);
      return;
    }
    catch (IOException paramBundle)
    {
      ae.printErrStackTrace(this.TAG, paramBundle, "", new Object[0]);
      deX();
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(64674);
    if ((paramn instanceof m))
    {
      paramString = (m)paramn;
      paramString.a(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
        {
          AppMethodBeat.i(64669);
          HoneyPayCardDetailUI.a(HoneyPayCardDetailUI.this, paramString.uRg);
          HoneyPayCardDetailUI.a(HoneyPayCardDetailUI.this);
          AppMethodBeat.o(64669);
        }
      }).b(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn) {}
      }).c(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardDetailUI
 * JD-Core Version:    0.7.0.1
 */