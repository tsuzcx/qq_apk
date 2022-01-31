package com.tencent.mm.plugin.collect.reward.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.collect.reward.a.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMGridView;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(2)
public class QrRewardSelectMoneyUI
  extends QrRewardBaseUI
{
  private int cCy;
  private String hBM;
  private List<Integer> kPU;
  private ImageView kPV;
  private TextView kPW;
  private TextView kPX;
  private TextView kPY;
  private TextView kPZ;
  private String kPd;
  private String kPf;
  private String kPh;
  private String kPi;
  private String kPj;
  private String kPk;
  private String kPl;
  private int kPm;
  private MMGridView kQa;
  private TextView kQb;
  private QrRewardSelectMoneyUI.a kQc;
  private String kQd;
  private String kQe;
  
  public QrRewardSelectMoneyUI()
  {
    AppMethodBeat.i(41141);
    this.kPU = new ArrayList();
    AppMethodBeat.o(41141);
  }
  
  public boolean convertActivityFromTranslucent()
  {
    return false;
  }
  
  public int getLayoutId()
  {
    return 2130970492;
  }
  
  public void initView()
  {
    AppMethodBeat.i(41143);
    this.kPV = ((ImageView)findViewById(2131826962));
    this.kPW = ((TextView)findViewById(2131826968));
    this.kPX = ((TextView)findViewById(2131826963));
    this.kPY = ((TextView)findViewById(2131826964));
    this.kPZ = ((TextView)findViewById(2131826965));
    this.kQa = ((MMGridView)findViewById(2131826966));
    this.kQb = ((TextView)findViewById(2131826967));
    this.kQc = new QrRewardSelectMoneyUI.a(this, (byte)0);
    this.kQa.setAdapter(this.kQc);
    this.kQa.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(41131);
        paramAnonymousInt = ((Integer)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt)).intValue();
        QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this, paramAnonymousInt, 1);
        AppMethodBeat.o(41131);
      }
    });
    this.kQb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(41132);
        QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this, 0, 2);
        AppMethodBeat.o(41132);
      }
    });
    AppMethodBeat.o(41143);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(41146);
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        ab.i("MicroMsg.QrRewardSelectMoneyUI", "pay succ");
        finish();
        AppMethodBeat.o(41146);
      }
    }
    else {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(41146);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41142);
    super.onCreate(paramBundle);
    addSceneEndListener(1516);
    setMMTitle(2131302217);
    setContentViewVisibility(4);
    this.kQd = getIntent().getStringExtra("key_qrcode_url");
    this.cCy = getIntent().getIntExtra("key_channel", 0);
    this.hBM = getIntent().getStringExtra("key_web_url");
    ab.i("MicroMsg.QrRewardSelectMoneyUI", "do scan code");
    doSceneProgress(new f(this.kQd, this.cCy, this.hBM));
    initView();
    int i = getIntent().getIntExtra("key_scene", 0);
    ab.d("MicroMsg.QrRewardSelectMoneyUI", "scene: %s", new Object[] { Integer.valueOf(i) });
    h.qsU.e(14721, new Object[] { Integer.valueOf(2), Integer.valueOf(i) });
    AppMethodBeat.o(41142);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41145);
    super.onDestroy();
    removeSceneEndListener(1516);
    AppMethodBeat.o(41145);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(41144);
    if ((paramm instanceof f))
    {
      paramString = (f)paramm;
      paramString.a(new QrRewardSelectMoneyUI.5(this, paramString)).b(new QrRewardSelectMoneyUI.4(this, paramString)).c(new QrRewardSelectMoneyUI.3(this, paramString));
      setContentViewVisibility(0);
    }
    AppMethodBeat.o(41144);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardSelectMoneyUI
 * JD-Core Version:    0.7.0.1
 */