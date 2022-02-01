package com.tencent.mm.plugin.honey_pay.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.honey_pay.a.m;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.bna;
import com.tencent.mm.protocal.protobuf.bon;
import com.tencent.mm.protocal.protobuf.coo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;
import java.io.IOException;

public class HoneyPayCardDetailUI
  extends HoneyPayBaseUI
{
  private int mScene;
  private ImageView pcD;
  private String uFI;
  private TextView uFM;
  private TextView uFN;
  private TextView uFO;
  private TextView uFP;
  private TextView uFQ;
  private TextView uFR;
  private RelativeLayout uFS;
  private CdnImageView uFT;
  private TextView uFU;
  private Button uFV;
  private coo uFW;
  private bna uFX;
  
  private void dce()
  {
    AppMethodBeat.i(64675);
    if (this.uFW.Gzb == null)
    {
      AppMethodBeat.o(64675);
      return;
    }
    bon localbon = this.uFW.Gzb;
    setMMTitle(localbon.ozd);
    this.uFM.setText(localbon.GJl);
    int i = localbon.state;
    if (i == 2)
    {
      this.pcD.setImageResource(2131690559);
      this.pcD.setColorFilter(getContext().getResources().getColor(2131099699), PorterDuff.Mode.SRC_ATOP);
      if (!bt.isNullOrNil(localbon.GJh))
      {
        localbon.GJh = c.U(localbon.GJh, this.uFW.Gzb.FpZ, -1);
        this.uFN.setText(k.a(this, localbon.GJh, (int)this.uFN.getTextSize(), null));
      }
      findViewById(2131300773).setVisibility(8);
      findViewById(2131300774).setVisibility(8);
      findViewById(2131300781).setVisibility(8);
      if (this.uFX != null)
      {
        this.uFS.setVisibility(0);
        this.uFT.setUrl(this.uFX.dDH);
        this.uFU.setText(this.uFX.GHb);
        this.uFV.setText(this.uFX.GHa);
        this.uFV.setOnClickListener(new HoneyPayCardDetailUI.4(this));
        AppMethodBeat.o(64675);
      }
    }
    else
    {
      if (i == 3)
      {
        this.pcD.setImageResource(2131691097);
        if (!bt.isNullOrNil(localbon.GJh)) {
          this.uFN.setText(localbon.GJh);
        }
        this.uFO.setText(2131760303);
        this.uFP.setText(2131760305);
        this.uFQ.setText(c.xL(this.uFW.Gzb.FHr));
        this.uFR.setText(c.xL(this.uFW.Gzb.oxC));
        AppMethodBeat.o(64675);
        return;
      }
      if (i == 4)
      {
        this.pcD.setImageResource(2131691097);
        if (!bt.isNullOrNil(localbon.GJh)) {
          this.uFN.setText(k.d(this, localbon.GJh, (int)this.uFN.getTextSize()));
        }
        this.uFO.setText(2131760304);
        this.uFQ.setText(c.xL(this.uFW.Gzb.GJj));
        findViewById(2131300781).setVisibility(8);
      }
    }
    AppMethodBeat.o(64675);
  }
  
  private void dcf()
  {
    AppMethodBeat.i(64676);
    m localm = new m(this.uFI);
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
    this.pcD = ((ImageView)findViewById(2131300786));
    this.uFM = ((TextView)findViewById(2131300785));
    this.uFN = ((TextView)findViewById(2131300784));
    this.uFQ = ((TextView)findViewById(2131300776));
    this.uFR = ((TextView)findViewById(2131300783));
    this.uFO = ((TextView)findViewById(2131300775));
    this.uFP = ((TextView)findViewById(2131300782));
    this.uFS = ((RelativeLayout)findViewById(2131300780));
    this.uFT = ((CdnImageView)findViewById(2131300779));
    this.uFU = ((TextView)findViewById(2131300778));
    this.uFV = ((Button)findViewById(2131300777));
    this.uFN.setClickable(true);
    this.uFN.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
    AppMethodBeat.o(64672);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64671);
    this.uFB = 2131100493;
    super.onCreate(paramBundle);
    addSceneEndListener(2613);
    this.mScene = getIntent().getIntExtra("key_scene", 0);
    this.uFI = getIntent().getStringExtra("key_card_no");
    initView();
    if (this.mScene == 0)
    {
      dcf();
      AppMethodBeat.o(64671);
      return;
    }
    paramBundle = getIntent().getByteArrayExtra("key_qry_response");
    try
    {
      this.uFW = new coo();
      this.uFW.parseFrom(paramBundle);
      dce();
      AppMethodBeat.o(64671);
      return;
    }
    catch (IOException paramBundle)
    {
      ad.printErrStackTrace(this.TAG, paramBundle, "", new Object[0]);
      dcf();
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(64674);
    if ((paramn instanceof m))
    {
      paramString = (m)paramn;
      paramString.a(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
        {
          AppMethodBeat.i(64669);
          HoneyPayCardDetailUI.a(HoneyPayCardDetailUI.this, paramString.uFt);
          HoneyPayCardDetailUI.a(HoneyPayCardDetailUI.this);
          AppMethodBeat.o(64669);
        }
      }).b(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn) {}
      }).c(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardDetailUI
 * JD-Core Version:    0.7.0.1
 */