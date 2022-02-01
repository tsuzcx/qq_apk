package com.tencent.mm.plugin.collect.reward.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.vj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.MMGridView;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(2)
public class QrRewardSelectMoneyUI
  extends QrRewardBaseUI
{
  private int channel;
  private String kzz;
  private String piM;
  private String piO;
  private String piQ;
  private String piR;
  private String piS;
  private String piT;
  private String piU;
  private int piV;
  private String piW;
  private String piX;
  private List<Integer> pjF;
  private CdnImageView pjG;
  private TextView pjH;
  private TextView pjI;
  private TextView pjJ;
  private TextView pjK;
  private MMGridView pjL;
  private TextView pjM;
  private QrRewardSelectMoneyUI.a pjN;
  private String pjO;
  private String pjP;
  
  public QrRewardSelectMoneyUI()
  {
    AppMethodBeat.i(64000);
    this.pjF = new ArrayList();
    AppMethodBeat.o(64000);
  }
  
  private void aaI(String paramString)
  {
    AppMethodBeat.i(64006);
    if (bu.isNullOrNil(this.piW)) {}
    for (paramString = com.tencent.mm.wallet_core.ui.f.zP(paramString);; paramString = this.piW)
    {
      this.pjI.setText(k.c(getContext(), paramString));
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
    return 2131495165;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64002);
    this.pjG = ((CdnImageView)findViewById(2131303657));
    this.pjH = ((TextView)findViewById(2131303662));
    this.pjI = ((TextView)findViewById(2131303660));
    this.pjJ = ((TextView)findViewById(2131303658));
    this.pjK = ((TextView)findViewById(2131303663));
    this.pjL = ((MMGridView)findViewById(2131303659));
    this.pjM = ((TextView)findViewById(2131303661));
    this.pjN = new QrRewardSelectMoneyUI.a(this, (byte)0);
    this.pjL.setAdapter(this.pjN);
    this.pjL.setOnItemClickListener(new QrRewardSelectMoneyUI.1(this));
    this.pjM.setOnClickListener(new QrRewardSelectMoneyUI.2(this));
    AppMethodBeat.o(64002);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(64005);
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        ae.i("MicroMsg.QrRewardSelectMoneyUI", "pay succ");
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
    setMMTitle(2131762096);
    setContentViewVisibility(4);
    this.pjO = getIntent().getStringExtra("key_qrcode_url");
    this.channel = getIntent().getIntExtra("key_channel", 0);
    this.kzz = getIntent().getStringExtra("key_web_url");
    ae.i("MicroMsg.QrRewardSelectMoneyUI", "do scan code");
    doSceneProgress(new com.tencent.mm.plugin.collect.reward.a.f(this.pjO, this.channel, this.kzz));
    initView();
    int i = getIntent().getIntExtra("key_scene", 0);
    ae.d("MicroMsg.QrRewardSelectMoneyUI", "scene: %s", new Object[] { Integer.valueOf(i) });
    g.yxI.f(14721, new Object[] { Integer.valueOf(2), Integer.valueOf(i) });
    AppMethodBeat.o(64001);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64004);
    super.onDestroy();
    removeSceneEndListener(1516);
    AppMethodBeat.o(64004);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(64003);
    if ((paramn instanceof com.tencent.mm.plugin.collect.reward.a.f))
    {
      paramString = (com.tencent.mm.plugin.collect.reward.a.f)paramn;
      paramString.a(new a.a()
      {
        public final void g(n paramAnonymousn)
        {
          AppMethodBeat.i(63995);
          ae.d("MicroMsg.QrRewardSelectMoneyUI", "callback succ");
          QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this, paramString.piu.Gnb);
          QrRewardSelectMoneyUI.b(QrRewardSelectMoneyUI.this, paramString.piu.yoq);
          QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this, paramString.piu.GmL);
          QrRewardSelectMoneyUI.c(QrRewardSelectMoneyUI.this, paramString.piu.GmV);
          QrRewardSelectMoneyUI.d(QrRewardSelectMoneyUI.this, paramString.piu.desc);
          QrRewardSelectMoneyUI.e(QrRewardSelectMoneyUI.this, paramString.piu.Gng);
          QrRewardSelectMoneyUI.f(QrRewardSelectMoneyUI.this, paramString.piu.Gnh);
          QrRewardSelectMoneyUI.g(QrRewardSelectMoneyUI.this, paramString.piu.Gne);
          QrRewardSelectMoneyUI.h(QrRewardSelectMoneyUI.this, paramString.piu.Gnk);
          QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this, paramString.piu.GmJ);
          QrRewardSelectMoneyUI.i(QrRewardSelectMoneyUI.this, paramString.piu.Gnl);
          QrRewardSelectMoneyUI.j(QrRewardSelectMoneyUI.this, paramString.piu.Gnm);
          if (QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this) == null)
          {
            ae.i("MicroMsg.QrRewardSelectMoneyUI", "amt_list is null");
            QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this, new LinkedList());
          }
          QrRewardSelectMoneyUI.b(QrRewardSelectMoneyUI.this);
          AppMethodBeat.o(63995);
        }
      }).b(new a.a()
      {
        public final void g(n paramAnonymousn)
        {
          AppMethodBeat.i(63994);
          ae.e("MicroMsg.QrRewardSelectMoneyUI", "scan response error");
          if (!bu.isNullOrNil(paramString.piu.phe)) {
            Toast.makeText(QrRewardSelectMoneyUI.this, paramString.piu.phe, 1).show();
          }
          QrRewardSelectMoneyUI.this.finish();
          AppMethodBeat.o(63994);
        }
      }).c(new a.a()
      {
        public final void g(n paramAnonymousn)
        {
          AppMethodBeat.i(63993);
          ae.e("MicroMsg.QrRewardSelectMoneyUI", "net error: %s", new Object[] { paramString });
          h.a(QrRewardSelectMoneyUI.this.getContext(), QrRewardSelectMoneyUI.this.getString(2131765901), null, false, new DialogInterface.OnClickListener()
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