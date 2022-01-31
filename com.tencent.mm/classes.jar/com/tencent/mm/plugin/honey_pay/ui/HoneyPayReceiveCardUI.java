package com.tencent.mm.plugin.honey_pay.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.plugin.wallet_core.ui.o.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.protobuf.avg;
import com.tencent.mm.protocal.protobuf.bps;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.p;
import java.io.IOException;

public class HoneyPayReceiveCardUI
  extends HoneyPayBaseUI
{
  private int mScene;
  private String nHE;
  private TextView nJA;
  private TextView nJB;
  private LinearLayout nJC;
  private CdnImageView nJD;
  private g nJE;
  private ImageView nJs;
  private TextView nJt;
  private TextView nJu;
  private TextView nJv;
  private TextView nJw;
  private TextView nJx;
  private TextView nJy;
  private TextView nJz;
  
  public HoneyPayReceiveCardUI()
  {
    AppMethodBeat.i(41942);
    this.nJE = new HoneyPayReceiveCardUI.1(this);
    AppMethodBeat.o(41942);
  }
  
  private void a(final bps parambps)
  {
    AppMethodBeat.i(41947);
    if (parambps.xci == null)
    {
      AppMethodBeat.o(41947);
      return;
    }
    avg localavg = parambps.xci;
    this.nJx.setText(localavg.xkD);
    this.nJz.setText(j.b(getContext(), localavg.oiG, this.nJz.getTextSize()));
    Object localObject = new Bundle();
    ((Bundle)localObject).putBoolean("click_help", true);
    this.nJA.setText(j.a(getContext(), localavg.qgx, (int)this.nJA.getTextSize(), localObject));
    this.nJA.setClickable(true);
    this.nJA.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m(this));
    if (!bo.isNullOrNil(parambps.xAJ))
    {
      localObject = new o(new o.a()
      {
        public final void dj(View paramAnonymousView)
        {
          AppMethodBeat.i(41941);
          if (!bo.isNullOrNil(parambps.xAK)) {
            com.tencent.mm.wallet_core.ui.e.m(HoneyPayReceiveCardUI.this.getContext(), parambps.xAK, false);
          }
          h.qsU.e(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          AppMethodBeat.o(41941);
        }
      });
      parambps = new SpannableString(parambps.xAJ);
      parambps.setSpan(localObject, 0, parambps.length(), 18);
      this.nJv.setText(parambps);
      this.nJv.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m(this));
      this.nJv.setClickable(true);
      this.nJu.setText(localavg.knv);
      a.b.a(this.nJs, localavg.wks, 0.06F, false);
      com.tencent.mm.wallet_core.ui.e.d(this.nJt, localavg.wks);
      com.tencent.mm.wallet_core.ui.e.d(this.nJB, localavg.wks);
      if (localavg.iFL != 1) {
        break label321;
      }
      this.nJy.setText(2131300666);
    }
    for (;;)
    {
      if (bo.isNullOrNil(localavg.kWy)) {
        break label370;
      }
      this.nJD.eq(localavg.kWy, c.bHU());
      AppMethodBeat.o(41947);
      return;
      ab.d(this.TAG, "no help url");
      this.nJv.setVisibility(8);
      break;
      label321:
      if (localavg.iFL == 2) {
        this.nJy.setText(2131300693);
      } else {
        this.nJy.setText(j.b(this, com.tencent.mm.wallet_core.ui.e.eZ(r.Zp(), 16), this.nJy.getTextSize()));
      }
    }
    label370:
    this.nJD.setImageResource(c.bHU());
    AppMethodBeat.o(41947);
  }
  
  private void bHX()
  {
    AppMethodBeat.i(41948);
    ab.i(this.TAG, "qry user detail");
    com.tencent.mm.plugin.honey_pay.a.m localm = new com.tencent.mm.plugin.honey_pay.a.m(this.nHE);
    localm.o(this);
    doSceneProgress(localm, true);
    AppMethodBeat.o(41948);
  }
  
  public int getLayoutId()
  {
    return 2130969875;
  }
  
  public void initView()
  {
    AppMethodBeat.i(41944);
    this.nJs = ((ImageView)findViewById(2131825067));
    this.nJt = ((TextView)findViewById(2131825066));
    this.nJy = ((TextView)findViewById(2131825062));
    this.nJu = ((TextView)findViewById(2131825070));
    this.nJB = ((TextView)findViewById(2131825071));
    this.nJv = ((TextView)findViewById(2131825065));
    this.nJw = ((TextView)findViewById(2131825072));
    this.nJx = ((TextView)findViewById(2131825073));
    this.nJC = ((LinearLayout)findViewById(2131825069));
    this.nJz = ((TextView)findViewById(2131825063));
    this.nJA = ((TextView)findViewById(2131825064));
    this.nJD = ((CdnImageView)findViewById(2131825068));
    this.nJw.setOnClickListener(new HoneyPayReceiveCardUI.2(this));
    AppMethodBeat.o(41944);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41943);
    this.nHx = 2131690171;
    super.onCreate(paramBundle);
    j.a(this.nJE);
    addSceneEndListener(2613);
    addSceneEndListener(1983);
    this.nHE = getIntent().getStringExtra("key_card_no");
    this.mScene = getIntent().getIntExtra("key_scene", 0);
    initView();
    if (this.mScene == 1)
    {
      paramBundle = new bps();
      try
      {
        paramBundle.parseFrom(getIntent().getByteArrayExtra("key_qry_response"));
        a(paramBundle);
        if (paramBundle.xci != null) {
          setMMTitle(paramBundle.xci.knv);
        }
        AppMethodBeat.o(41943);
        return;
      }
      catch (IOException paramBundle)
      {
        ab.printErrStackTrace(this.TAG, paramBundle, "", new Object[0]);
        bHX();
        AppMethodBeat.o(41943);
        return;
      }
    }
    bHX();
    AppMethodBeat.o(41943);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41945);
    super.onDestroy();
    j.b(this.nJE);
    removeSceneEndListener(2613);
    removeSceneEndListener(1983);
    AppMethodBeat.o(41945);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(41946);
    if ((paramm instanceof com.tencent.mm.plugin.honey_pay.a.m))
    {
      paramString = (com.tencent.mm.plugin.honey_pay.a.m)paramm;
      paramString.a(new HoneyPayReceiveCardUI.5(this, paramString)).b(new HoneyPayReceiveCardUI.4(this)).c(new HoneyPayReceiveCardUI.3(this));
    }
    for (;;)
    {
      AppMethodBeat.o(41946);
      return true;
      if ((paramm instanceof com.tencent.mm.plugin.honey_pay.a.e))
      {
        paramString = (com.tencent.mm.plugin.honey_pay.a.e)paramm;
        paramString.a(new HoneyPayReceiveCardUI.8(this, paramString)).b(new HoneyPayReceiveCardUI.7(this, paramString)).c(new HoneyPayReceiveCardUI.6(this));
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayReceiveCardUI
 * JD-Core Version:    0.7.0.1
 */