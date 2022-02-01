package com.tencent.mm.plugin.collect.reward.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.wr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMGridView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(2)
public class QrRewardSelectMoneyUI
  extends QrRewardBaseUI
{
  private int channel;
  private String lDS;
  private String qxX;
  private String qxZ;
  private List<Integer> qyQ;
  private CdnImageView qyR;
  private TextView qyS;
  private TextView qyT;
  private TextView qyU;
  private TextView qyV;
  private MMGridView qyW;
  private TextView qyX;
  private QrRewardSelectMoneyUI.a qyY;
  private String qyZ;
  private String qyb;
  private String qyc;
  private String qyd;
  private String qye;
  private String qyf;
  private int qyg;
  private String qyh;
  private String qyi;
  private String qza;
  
  public QrRewardSelectMoneyUI()
  {
    AppMethodBeat.i(64000);
    this.qyQ = new ArrayList();
    AppMethodBeat.o(64000);
  }
  
  private void akO(String paramString)
  {
    AppMethodBeat.i(64006);
    if (Util.isNullOrNil(this.qyh)) {}
    for (paramString = com.tencent.mm.wallet_core.ui.f.getDisplayName(paramString);; paramString = this.qyh)
    {
      this.qyT.setText(l.c(getContext(), paramString));
      AppMethodBeat.o(64006);
      return;
    }
  }
  
  public boolean convertActivityFromTranslucent()
  {
    return false;
  }
  
  public int getLayoutId()
  {
    return 2131496008;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64002);
    this.qyR = ((CdnImageView)findViewById(2131306436));
    this.qyS = ((TextView)findViewById(2131306441));
    this.qyT = ((TextView)findViewById(2131306439));
    this.qyU = ((TextView)findViewById(2131306437));
    this.qyV = ((TextView)findViewById(2131306442));
    this.qyW = ((MMGridView)findViewById(2131306438));
    this.qyX = ((TextView)findViewById(2131306440));
    this.qyY = new QrRewardSelectMoneyUI.a(this, (byte)0);
    this.qyW.setAdapter(this.qyY);
    this.qyW.setOnItemClickListener(new QrRewardSelectMoneyUI.1(this));
    this.qyX.setOnClickListener(new QrRewardSelectMoneyUI.2(this));
    AppMethodBeat.o(64002);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(64005);
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        Log.i("MicroMsg.QrRewardSelectMoneyUI", "pay succ");
        finish();
        AppMethodBeat.o(64005);
      }
    }
    else {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(64005);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64001);
    super.onCreate(paramBundle);
    addSceneEndListener(1516);
    setMMTitle(2131764117);
    setContentViewVisibility(4);
    this.qyZ = getIntent().getStringExtra("key_qrcode_url");
    this.channel = getIntent().getIntExtra("key_channel", 0);
    this.lDS = getIntent().getStringExtra("key_web_url");
    Log.i("MicroMsg.QrRewardSelectMoneyUI", "do scan code");
    doSceneProgress(new com.tencent.mm.plugin.collect.reward.a.f(this.qyZ, this.channel, this.lDS));
    initView();
    int i = getIntent().getIntExtra("key_scene", 0);
    Log.d("MicroMsg.QrRewardSelectMoneyUI", "scene: %s", new Object[] { Integer.valueOf(i) });
    com.tencent.mm.plugin.report.service.h.CyF.a(14721, new Object[] { Integer.valueOf(2), Integer.valueOf(i) });
    AppMethodBeat.o(64001);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64004);
    super.onDestroy();
    removeSceneEndListener(1516);
    AppMethodBeat.o(64004);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(64003);
    if ((paramq instanceof com.tencent.mm.plugin.collect.reward.a.f))
    {
      paramString = (com.tencent.mm.plugin.collect.reward.a.f)paramq;
      paramString.a(new a.a()
      {
        public final void g(q paramAnonymousq)
        {
          AppMethodBeat.i(63995);
          Log.d("MicroMsg.QrRewardSelectMoneyUI", "callback succ");
          QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this, paramString.qxF.LhF);
          QrRewardSelectMoneyUI.b(QrRewardSelectMoneyUI.this, paramString.qxF.Cpg);
          QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this, paramString.qxF.Lhp);
          QrRewardSelectMoneyUI.c(QrRewardSelectMoneyUI.this, paramString.qxF.Lhz);
          QrRewardSelectMoneyUI.d(QrRewardSelectMoneyUI.this, paramString.qxF.desc);
          QrRewardSelectMoneyUI.e(QrRewardSelectMoneyUI.this, paramString.qxF.LhK);
          QrRewardSelectMoneyUI.f(QrRewardSelectMoneyUI.this, paramString.qxF.LhL);
          QrRewardSelectMoneyUI.g(QrRewardSelectMoneyUI.this, paramString.qxF.LhI);
          QrRewardSelectMoneyUI.h(QrRewardSelectMoneyUI.this, paramString.qxF.LhO);
          QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this, paramString.qxF.Lhn);
          QrRewardSelectMoneyUI.i(QrRewardSelectMoneyUI.this, paramString.qxF.LhP);
          QrRewardSelectMoneyUI.j(QrRewardSelectMoneyUI.this, paramString.qxF.LhQ);
          if (QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this) == null)
          {
            Log.i("MicroMsg.QrRewardSelectMoneyUI", "amt_list is null");
            QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this, new LinkedList());
          }
          QrRewardSelectMoneyUI.b(QrRewardSelectMoneyUI.this);
          AppMethodBeat.o(63995);
        }
      }).b(new a.a()
      {
        public final void g(q paramAnonymousq)
        {
          AppMethodBeat.i(63994);
          Log.e("MicroMsg.QrRewardSelectMoneyUI", "scan response error");
          if (!Util.isNullOrNil(paramString.qxF.qwn)) {
            Toast.makeText(QrRewardSelectMoneyUI.this, paramString.qxF.qwn, 1).show();
          }
          QrRewardSelectMoneyUI.this.finish();
          AppMethodBeat.o(63994);
        }
      }).c(new a.a()
      {
        public final void g(q paramAnonymousq)
        {
          AppMethodBeat.i(63993);
          Log.e("MicroMsg.QrRewardSelectMoneyUI", "net error: %s", new Object[] { paramString });
          com.tencent.mm.ui.base.h.a(QrRewardSelectMoneyUI.this.getContext(), QrRewardSelectMoneyUI.this.getString(2131768354), null, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(63992);
              QrRewardSelectMoneyUI.this.finish();
              AppMethodBeat.o(63992);
            }
          });
          AppMethodBeat.o(63993);
        }
      });
      setContentViewVisibility(0);
    }
    AppMethodBeat.o(64003);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardSelectMoneyUI
 * JD-Core Version:    0.7.0.1
 */