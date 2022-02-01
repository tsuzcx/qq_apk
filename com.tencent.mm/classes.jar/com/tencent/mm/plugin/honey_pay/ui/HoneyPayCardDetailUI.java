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
import com.tencent.mm.plugin.honey_pay.a.m;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.bis;
import com.tencent.mm.protocal.protobuf.bkd;
import com.tencent.mm.protocal.protobuf.cjo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;
import com.tencent.mm.wallet_core.ui.e;
import java.io.IOException;

public class HoneyPayCardDetailUI
  extends HoneyPayBaseUI
{
  private int mScene;
  private ImageView ozi;
  private String tCZ;
  private TextView tDd;
  private TextView tDe;
  private TextView tDf;
  private TextView tDg;
  private TextView tDh;
  private TextView tDi;
  private RelativeLayout tDj;
  private CdnImageView tDk;
  private TextView tDl;
  private Button tDm;
  private cjo tDn;
  private bis tDo;
  
  private void cSX()
  {
    AppMethodBeat.i(64675);
    if (this.tDn.EPK == null)
    {
      AppMethodBeat.o(64675);
      return;
    }
    bkd localbkd = this.tDn.EPK;
    setMMTitle(localbkd.nVJ);
    this.tDd.setText(localbkd.EZM);
    int i = localbkd.state;
    if (i == 2)
    {
      this.ozi.setImageResource(2131690559);
      this.ozi.setColorFilter(getContext().getResources().getColor(2131099699), PorterDuff.Mode.SRC_ATOP);
      if (!bs.isNullOrNil(localbkd.EZI))
      {
        localbkd.EZI = c.R(localbkd.EZI, this.tDn.EPK.DKT, -1);
        this.tDe.setText(k.a(this, localbkd.EZI, (int)this.tDe.getTextSize(), null));
      }
      findViewById(2131300773).setVisibility(8);
      findViewById(2131300774).setVisibility(8);
      findViewById(2131300781).setVisibility(8);
      if (this.tDo != null)
      {
        this.tDj.setVisibility(0);
        this.tDk.setUrl(this.tDo.drM);
        this.tDl.setText(this.tDo.EXF);
        this.tDm.setText(this.tDo.EXE);
        this.tDm.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(64670);
            ac.d(HoneyPayCardDetailUI.this.TAG, "click oper btn: %s", new Object[] { HoneyPayCardDetailUI.b(HoneyPayCardDetailUI.this).url });
            if (!bs.isNullOrNil(HoneyPayCardDetailUI.b(HoneyPayCardDetailUI.this).url)) {
              e.o(HoneyPayCardDetailUI.this.getContext(), HoneyPayCardDetailUI.b(HoneyPayCardDetailUI.this).url, false);
            }
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
        this.ozi.setImageResource(2131691097);
        if (!bs.isNullOrNil(localbkd.EZI)) {
          this.tDe.setText(localbkd.EZI);
        }
        this.tDf.setText(2131760303);
        this.tDg.setText(2131760305);
        this.tDh.setText(c.vB(this.tDn.EPK.EbF));
        this.tDi.setText(c.vB(this.tDn.EPK.nUh));
        AppMethodBeat.o(64675);
        return;
      }
      if (i == 4)
      {
        this.ozi.setImageResource(2131691097);
        if (!bs.isNullOrNil(localbkd.EZI)) {
          this.tDe.setText(k.d(this, localbkd.EZI, (int)this.tDe.getTextSize()));
        }
        this.tDf.setText(2131760304);
        this.tDh.setText(c.vB(this.tDn.EPK.EZK));
        findViewById(2131300781).setVisibility(8);
      }
    }
    AppMethodBeat.o(64675);
  }
  
  private void cSY()
  {
    AppMethodBeat.i(64676);
    m localm = new m(this.tCZ);
    localm.r(this);
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
    this.ozi = ((ImageView)findViewById(2131300786));
    this.tDd = ((TextView)findViewById(2131300785));
    this.tDe = ((TextView)findViewById(2131300784));
    this.tDh = ((TextView)findViewById(2131300776));
    this.tDi = ((TextView)findViewById(2131300783));
    this.tDf = ((TextView)findViewById(2131300775));
    this.tDg = ((TextView)findViewById(2131300782));
    this.tDj = ((RelativeLayout)findViewById(2131300780));
    this.tDk = ((CdnImageView)findViewById(2131300779));
    this.tDl = ((TextView)findViewById(2131300778));
    this.tDm = ((Button)findViewById(2131300777));
    this.tDe.setClickable(true);
    this.tDe.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
    AppMethodBeat.o(64672);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64671);
    this.tCS = 2131100493;
    super.onCreate(paramBundle);
    addSceneEndListener(2613);
    this.mScene = getIntent().getIntExtra("key_scene", 0);
    this.tCZ = getIntent().getStringExtra("key_card_no");
    initView();
    if (this.mScene == 0)
    {
      cSY();
      AppMethodBeat.o(64671);
      return;
    }
    paramBundle = getIntent().getByteArrayExtra("key_qry_response");
    try
    {
      this.tDn = new cjo();
      this.tDn.parseFrom(paramBundle);
      cSX();
      AppMethodBeat.o(64671);
      return;
    }
    catch (IOException paramBundle)
    {
      ac.printErrStackTrace(this.TAG, paramBundle, "", new Object[0]);
      cSY();
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
          HoneyPayCardDetailUI.a(HoneyPayCardDetailUI.this, paramString.tCK);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardDetailUI
 * JD-Core Version:    0.7.0.1
 */