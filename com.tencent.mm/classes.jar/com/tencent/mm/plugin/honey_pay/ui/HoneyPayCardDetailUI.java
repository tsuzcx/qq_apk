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
import com.tencent.mm.protocal.protobuf.bfa;
import com.tencent.mm.protocal.protobuf.bgl;
import com.tencent.mm.protocal.protobuf.cel;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;
import com.tencent.mm.wallet_core.ui.e;
import java.io.IOException;

public class HoneyPayCardDetailUI
  extends HoneyPayBaseUI
{
  private int mScene;
  private ImageView nVN;
  private String svk;
  private TextView svo;
  private TextView svp;
  private TextView svq;
  private TextView svr;
  private TextView svs;
  private TextView svt;
  private RelativeLayout svu;
  private CdnImageView svv;
  private TextView svw;
  private Button svx;
  private cel svy;
  private bfa svz;
  
  private void cFN()
  {
    AppMethodBeat.i(64675);
    if (this.svy.DuB == null)
    {
      AppMethodBeat.o(64675);
      return;
    }
    bgl localbgl = this.svy.DuB;
    setMMTitle(localbgl.nsJ);
    this.svo.setText(localbgl.DEr);
    int i = localbgl.state;
    if (i == 2)
    {
      this.nVN.setImageResource(2131690559);
      this.nVN.setColorFilter(getContext().getResources().getColor(2131099699), PorterDuff.Mode.SRC_ATOP);
      if (!bt.isNullOrNil(localbgl.DEn))
      {
        localbgl.DEn = c.Q(localbgl.DEn, this.svy.DuB.CsC, -1);
        this.svp.setText(k.a(this, localbgl.DEn, (int)this.svp.getTextSize(), null));
      }
      findViewById(2131300773).setVisibility(8);
      findViewById(2131300774).setVisibility(8);
      findViewById(2131300781).setVisibility(8);
      if (this.svz != null)
      {
        this.svu.setVisibility(0);
        this.svv.setUrl(this.svz.dub);
        this.svw.setText(this.svz.DCj);
        this.svx.setText(this.svz.DCi);
        this.svx.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(64670);
            ad.d(HoneyPayCardDetailUI.this.TAG, "click oper btn: %s", new Object[] { HoneyPayCardDetailUI.b(HoneyPayCardDetailUI.this).url });
            if (!bt.isNullOrNil(HoneyPayCardDetailUI.b(HoneyPayCardDetailUI.this).url)) {
              e.p(HoneyPayCardDetailUI.this.getContext(), HoneyPayCardDetailUI.b(HoneyPayCardDetailUI.this).url, false);
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
        this.nVN.setImageResource(2131691097);
        if (!bt.isNullOrNil(localbgl.DEn)) {
          this.svp.setText(localbgl.DEn);
        }
        this.svq.setText(2131760303);
        this.svr.setText(2131760305);
        this.svs.setText(c.qY(this.svy.DuB.CJd));
        this.svt.setText(c.qY(this.svy.DuB.nrh));
        AppMethodBeat.o(64675);
        return;
      }
      if (i == 4)
      {
        this.nVN.setImageResource(2131691097);
        if (!bt.isNullOrNil(localbgl.DEn)) {
          this.svp.setText(k.d(this, localbgl.DEn, (int)this.svp.getTextSize()));
        }
        this.svq.setText(2131760304);
        this.svs.setText(c.qY(this.svy.DuB.DEp));
        findViewById(2131300781).setVisibility(8);
      }
    }
    AppMethodBeat.o(64675);
  }
  
  private void cFO()
  {
    AppMethodBeat.i(64676);
    m localm = new m(this.svk);
    localm.q(this);
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
    this.nVN = ((ImageView)findViewById(2131300786));
    this.svo = ((TextView)findViewById(2131300785));
    this.svp = ((TextView)findViewById(2131300784));
    this.svs = ((TextView)findViewById(2131300776));
    this.svt = ((TextView)findViewById(2131300783));
    this.svq = ((TextView)findViewById(2131300775));
    this.svr = ((TextView)findViewById(2131300782));
    this.svu = ((RelativeLayout)findViewById(2131300780));
    this.svv = ((CdnImageView)findViewById(2131300779));
    this.svw = ((TextView)findViewById(2131300778));
    this.svx = ((Button)findViewById(2131300777));
    this.svp.setClickable(true);
    this.svp.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
    AppMethodBeat.o(64672);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64671);
    this.svd = 2131100493;
    super.onCreate(paramBundle);
    addSceneEndListener(2613);
    this.mScene = getIntent().getIntExtra("key_scene", 0);
    this.svk = getIntent().getStringExtra("key_card_no");
    initView();
    if (this.mScene == 0)
    {
      cFO();
      AppMethodBeat.o(64671);
      return;
    }
    paramBundle = getIntent().getByteArrayExtra("key_qry_response");
    try
    {
      this.svy = new cel();
      this.svy.parseFrom(paramBundle);
      cFN();
      AppMethodBeat.o(64671);
      return;
    }
    catch (IOException paramBundle)
    {
      ad.printErrStackTrace(this.TAG, paramBundle, "", new Object[0]);
      cFO();
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
          HoneyPayCardDetailUI.a(HoneyPayCardDetailUI.this, paramString.suV);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardDetailUI
 * JD-Core Version:    0.7.0.1
 */