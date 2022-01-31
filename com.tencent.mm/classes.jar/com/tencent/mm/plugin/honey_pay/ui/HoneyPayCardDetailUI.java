package com.tencent.mm.plugin.honey_pay.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.avg;
import com.tencent.mm.protocal.protobuf.bps;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.p;
import java.io.IOException;

public class HoneyPayCardDetailUI
  extends HoneyPayBaseUI
{
  private ImageView kPy;
  private int mScene;
  private String nHE;
  private TextView nHI;
  private TextView nHJ;
  private TextView nHK;
  private TextView nHL;
  private TextView nHM;
  private TextView nHN;
  private RelativeLayout nHO;
  private CdnImageView nHP;
  private TextView nHQ;
  private Button nHR;
  private bps nHS;
  private atz nHT;
  
  private void bHW()
  {
    AppMethodBeat.i(41785);
    if (this.nHS.xci == null)
    {
      AppMethodBeat.o(41785);
      return;
    }
    avg localavg = this.nHS.xci;
    setMMTitle(localavg.knv);
    this.nHI.setText(localavg.xkH);
    int i = localavg.state;
    if (i == 2)
    {
      this.kPy.setImageResource(2130840887);
      if (!bo.isNullOrNil(localavg.xkD))
      {
        localavg.xkD = c.eN(localavg.xkD, this.nHS.xci.wks);
        this.nHJ.setText(j.a(this, localavg.xkD, (int)this.nHJ.getTextSize(), null));
      }
      findViewById(2131824987).setVisibility(8);
      findViewById(2131824992).setVisibility(8);
      findViewById(2131824995).setVisibility(8);
      if (this.nHT != null)
      {
        this.nHO.setVisibility(0);
        this.nHP.setUrl(this.nHT.cDz);
        this.nHQ.setText(this.nHT.xiR);
        this.nHR.setText(this.nHT.xiQ);
        this.nHR.setOnClickListener(new HoneyPayCardDetailUI.4(this));
        AppMethodBeat.o(41785);
      }
    }
    else
    {
      if (i == 3)
      {
        this.kPy.setImageResource(2131231925);
        if (!bo.isNullOrNil(localavg.xkD)) {
          this.nHJ.setText(localavg.xkD);
        }
        this.nHK.setText(2131300706);
        this.nHL.setText(2131300708);
        this.nHM.setText(c.ko(this.nHS.xci.wyt));
        this.nHN.setText(c.ko(this.nHS.xci.kmb));
        AppMethodBeat.o(41785);
        return;
      }
      if (i == 4)
      {
        this.kPy.setImageResource(2131231925);
        if (!bo.isNullOrNil(localavg.xkD)) {
          this.nHJ.setText(j.e(this, localavg.xkD, (int)this.nHJ.getTextSize()));
        }
        this.nHK.setText(2131300707);
        this.nHM.setText(c.ko(this.nHS.xci.xkF));
        findViewById(2131824995).setVisibility(8);
      }
    }
    AppMethodBeat.o(41785);
  }
  
  private void bHX()
  {
    AppMethodBeat.i(41786);
    com.tencent.mm.plugin.honey_pay.a.m localm = new com.tencent.mm.plugin.honey_pay.a.m(this.nHE);
    localm.o(this);
    doSceneProgress(localm, true);
    AppMethodBeat.o(41786);
  }
  
  public int getLayoutId()
  {
    return 2130969861;
  }
  
  public void initView()
  {
    AppMethodBeat.i(41782);
    this.kPy = ((ImageView)findViewById(2131824984));
    this.nHI = ((TextView)findViewById(2131824985));
    this.nHJ = ((TextView)findViewById(2131824986));
    this.nHM = ((TextView)findViewById(2131824994));
    this.nHN = ((TextView)findViewById(2131824997));
    this.nHK = ((TextView)findViewById(2131824993));
    this.nHL = ((TextView)findViewById(2131824996));
    this.nHO = ((RelativeLayout)findViewById(2131824988));
    this.nHP = ((CdnImageView)findViewById(2131824989));
    this.nHQ = ((TextView)findViewById(2131824990));
    this.nHR = ((Button)findViewById(2131824991));
    this.nHJ.setClickable(true);
    this.nHJ.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m(this));
    AppMethodBeat.o(41782);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41781);
    this.nHx = 2131690171;
    super.onCreate(paramBundle);
    addSceneEndListener(2613);
    this.mScene = getIntent().getIntExtra("key_scene", 0);
    this.nHE = getIntent().getStringExtra("key_card_no");
    initView();
    if (this.mScene == 0)
    {
      bHX();
      AppMethodBeat.o(41781);
      return;
    }
    paramBundle = getIntent().getByteArrayExtra("key_qry_response");
    try
    {
      this.nHS = new bps();
      this.nHS.parseFrom(paramBundle);
      bHW();
      AppMethodBeat.o(41781);
      return;
    }
    catch (IOException paramBundle)
    {
      ab.printErrStackTrace(this.TAG, paramBundle, "", new Object[0]);
      bHX();
      AppMethodBeat.o(41781);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41783);
    super.onDestroy();
    removeSceneEndListener(2613);
    AppMethodBeat.o(41783);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(41784);
    if ((paramm instanceof com.tencent.mm.plugin.honey_pay.a.m))
    {
      paramString = (com.tencent.mm.plugin.honey_pay.a.m)paramm;
      paramString.a(new HoneyPayCardDetailUI.3(this, paramString)).b(new HoneyPayCardDetailUI.2(this)).c(new HoneyPayCardDetailUI.1(this));
    }
    AppMethodBeat.o(41784);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardDetailUI
 * JD-Core Version:    0.7.0.1
 */