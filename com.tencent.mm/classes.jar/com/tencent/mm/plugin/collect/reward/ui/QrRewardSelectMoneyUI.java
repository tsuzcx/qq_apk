package com.tencent.mm.plugin.collect.reward.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.d;
import com.tencent.mm.am.e;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.f;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.wv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMGridView;
import com.tencent.mm.wallet_core.ui.g;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(2)
public class QrRewardSelectMoneyUI
  extends QrRewardBaseUI
{
  private int channel;
  private String ozt;
  private String tWX;
  private String tWZ;
  private List<Integer> tXQ;
  private CdnImageView tXR;
  private TextView tXS;
  private TextView tXT;
  private TextView tXU;
  private TextView tXV;
  private MMGridView tXW;
  private TextView tXX;
  private a tXY;
  private String tXZ;
  private String tXb;
  private String tXc;
  private String tXd;
  private String tXe;
  private String tXf;
  private int tXg;
  private String tXh;
  private String tXi;
  private String tYa;
  
  public QrRewardSelectMoneyUI()
  {
    AppMethodBeat.i(64000);
    this.tXQ = new ArrayList();
    AppMethodBeat.o(64000);
  }
  
  private void asE(String paramString)
  {
    AppMethodBeat.i(64006);
    if (Util.isNullOrNil(this.tXh)) {}
    for (paramString = g.PJ(paramString);; paramString = this.tXh)
    {
      this.tXT.setText(l.c(getContext(), paramString));
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
    return a.g.qr_reward_select_money_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64002);
    this.tXR = ((CdnImageView)findViewById(a.f.qrsm_avatar_iv));
    this.tXS = ((TextView)findViewById(a.f.qrsm_reward_amt_tv));
    this.tXT = ((TextView)findViewById(a.f.qrsm_name_tv));
    this.tXU = ((TextView)findViewById(a.f.qrsm_desc_tv));
    this.tXV = ((TextView)findViewById(a.f.qrsm_reward_money_title_tv));
    this.tXW = ((MMGridView)findViewById(a.f.qrsm_money_layout));
    this.tXX = ((TextView)findViewById(a.f.qrsm_other_reward_money_tv));
    this.tXY = new a((byte)0);
    this.tXW.setAdapter(this.tXY);
    this.tXW.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(63990);
        b localb = new b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/collect/reward/ui/QrRewardSelectMoneyUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
        paramAnonymousInt = ((Integer)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt)).intValue();
        QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this, paramAnonymousInt, 1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/reward/ui/QrRewardSelectMoneyUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(63990);
      }
    });
    this.tXX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(63991);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/collect/reward/ui/QrRewardSelectMoneyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this, 0, 2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/reward/ui/QrRewardSelectMoneyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(63991);
      }
    });
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
    setMMTitle(a.i.qr_reward_main_title);
    setContentViewVisibility(4);
    this.tXZ = getIntent().getStringExtra("key_qrcode_url");
    this.channel = getIntent().getIntExtra("key_channel", 0);
    this.ozt = getIntent().getStringExtra("key_web_url");
    Log.i("MicroMsg.QrRewardSelectMoneyUI", "do scan code");
    doSceneProgress(new f(this.tXZ, this.channel, this.ozt));
    initView();
    int i = getIntent().getIntExtra("key_scene", 0);
    Log.d("MicroMsg.QrRewardSelectMoneyUI", "scene: %s", new Object[] { Integer.valueOf(i) });
    com.tencent.mm.plugin.report.service.h.IzE.a(14721, new Object[] { Integer.valueOf(2), Integer.valueOf(i) });
    AppMethodBeat.o(64001);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64004);
    super.onDestroy();
    removeSceneEndListener(1516);
    AppMethodBeat.o(64004);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(64003);
    if ((paramq instanceof f))
    {
      paramString = (f)paramq;
      paramString.a(new a.a()
      {
        public final void g(com.tencent.mm.an.q paramAnonymousq)
        {
          AppMethodBeat.i(63995);
          Log.d("MicroMsg.QrRewardSelectMoneyUI", "callback succ");
          QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this, paramString.tWF.SiT);
          QrRewardSelectMoneyUI.b(QrRewardSelectMoneyUI.this, paramString.tWF.Imv);
          QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this, paramString.tWF.SiD);
          QrRewardSelectMoneyUI.c(QrRewardSelectMoneyUI.this, paramString.tWF.SiN);
          QrRewardSelectMoneyUI.d(QrRewardSelectMoneyUI.this, paramString.tWF.desc);
          QrRewardSelectMoneyUI.e(QrRewardSelectMoneyUI.this, paramString.tWF.SiY);
          QrRewardSelectMoneyUI.f(QrRewardSelectMoneyUI.this, paramString.tWF.SiZ);
          QrRewardSelectMoneyUI.g(QrRewardSelectMoneyUI.this, paramString.tWF.SiW);
          QrRewardSelectMoneyUI.h(QrRewardSelectMoneyUI.this, paramString.tWF.Sjc);
          QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this, paramString.tWF.SiB);
          QrRewardSelectMoneyUI.i(QrRewardSelectMoneyUI.this, paramString.tWF.Sjd);
          QrRewardSelectMoneyUI.j(QrRewardSelectMoneyUI.this, paramString.tWF.Sje);
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
        public final void g(com.tencent.mm.an.q paramAnonymousq)
        {
          AppMethodBeat.i(63994);
          Log.e("MicroMsg.QrRewardSelectMoneyUI", "scan response error");
          if (!Util.isNullOrNil(paramString.tWF.tVo)) {
            Toast.makeText(QrRewardSelectMoneyUI.this, paramString.tWF.tVo, 1).show();
          }
          QrRewardSelectMoneyUI.this.finish();
          AppMethodBeat.o(63994);
        }
      }).c(new a.a()
      {
        public final void g(com.tencent.mm.an.q paramAnonymousq)
        {
          AppMethodBeat.i(63993);
          Log.e("MicroMsg.QrRewardSelectMoneyUI", "net error: %s", new Object[] { paramString });
          com.tencent.mm.ui.base.h.a(QrRewardSelectMoneyUI.this.getContext(), QrRewardSelectMoneyUI.this.getString(a.i.wallet_unknown_err), null, false, new DialogInterface.OnClickListener()
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
  
  final class a
    extends BaseAdapter
  {
    private a() {}
    
    public final int getCount()
    {
      AppMethodBeat.i(63997);
      int i = QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this).size();
      AppMethodBeat.o(63997);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(63998);
      Object localObject = QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this).get(paramInt);
      AppMethodBeat.o(63998);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(63999);
      View localView = paramView;
      if (paramView == null) {
        localView = LayoutInflater.from(QrRewardSelectMoneyUI.this.getContext()).inflate(a.g.qr_reward_select_money_item, paramViewGroup, false);
      }
      paramInt = ((Integer)getItem(paramInt)).intValue();
      paramView = (TextView)localView.findViewById(a.f.qrsi_money_tv);
      int i = paramInt / 100;
      double d = paramInt / 100.0D;
      if (d > i) {
        paramView.setText(String.format("%.2f", new Object[] { Double.valueOf(d) }) + QrRewardSelectMoneyUI.this.getString(a.i.qr_reward_yuan));
      }
      for (;;)
      {
        AppMethodBeat.o(63999);
        return localView;
        paramView.setText(String.format("%d", new Object[] { Integer.valueOf(i) }) + QrRewardSelectMoneyUI.this.getString(a.i.qr_reward_yuan));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardSelectMoneyUI
 * JD-Core Version:    0.7.0.1
 */