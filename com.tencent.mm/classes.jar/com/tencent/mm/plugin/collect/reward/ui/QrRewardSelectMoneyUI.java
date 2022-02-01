package com.tencent.mm.plugin.collect.reward.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.dus;
import com.tencent.mm.protocal.protobuf.yn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMGridView;
import com.tencent.mm.wallet_core.ui.WcPayBannerView;
import com.tencent.mm.wallet_core.ui.i;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(2)
public class QrRewardSelectMoneyUI
  extends QrRewardBaseUI
{
  private int channel;
  private dus pGr;
  private WcPayBannerView pLM;
  private String rDm;
  private String xaA;
  private String xap;
  private String xar;
  private String xat;
  private String xau;
  private String xav;
  private String xaw;
  private String xax;
  private int xay;
  private String xaz;
  private List<Integer> xbj;
  private CdnImageView xbk;
  private TextView xbl;
  private TextView xbm;
  private TextView xbn;
  private TextView xbo;
  private MMGridView xbp;
  private TextView xbq;
  private a xbr;
  private String xbs;
  private String xbt;
  
  public QrRewardSelectMoneyUI()
  {
    AppMethodBeat.i(64000);
    this.xbj = new ArrayList();
    AppMethodBeat.o(64000);
  }
  
  private void amj(String paramString)
  {
    AppMethodBeat.i(64006);
    if (Util.isNullOrNil(this.xaz)) {}
    for (paramString = i.getDisplayName(paramString);; paramString = this.xaz)
    {
      this.xbm.setText(com.tencent.mm.pluginsdk.ui.span.p.b(getContext(), paramString));
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
    this.xbk = ((CdnImageView)findViewById(a.f.qrsm_avatar_iv));
    this.xbl = ((TextView)findViewById(a.f.qrsm_reward_amt_tv));
    this.xbm = ((TextView)findViewById(a.f.qrsm_name_tv));
    this.xbn = ((TextView)findViewById(a.f.qrsm_desc_tv));
    this.xbo = ((TextView)findViewById(a.f.qrsm_reward_money_title_tv));
    this.xbp = ((MMGridView)findViewById(a.f.qrsm_money_layout));
    this.xbq = ((TextView)findViewById(a.f.qrsm_other_reward_money_tv));
    this.pLM = ((WcPayBannerView)findViewById(a.f.wc_pay_banner_layout));
    this.pLM.setBgColor(getResources().getColor(a.c.Orange));
    this.pLM.setTextColor(getResources().getColor(a.c.White));
    this.xbr = new a((byte)0);
    this.xbp.setAdapter(this.xbr);
    this.xbp.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(63990);
        b localb = new b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/collect/reward/ui/QrRewardSelectMoneyUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        paramAnonymousInt = ((Integer)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt)).intValue();
        QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this, paramAnonymousInt, 1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/reward/ui/QrRewardSelectMoneyUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(63990);
      }
    });
    this.xbq.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(293692);
        QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this, 0, 2);
        AppMethodBeat.o(293692);
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
    this.xbs = getIntent().getStringExtra("key_qrcode_url");
    this.channel = getIntent().getIntExtra("key_channel", 0);
    this.rDm = getIntent().getStringExtra("key_web_url");
    Log.i("MicroMsg.QrRewardSelectMoneyUI", "do scan code");
    doSceneProgress(new f(this.xbs, this.channel, this.rDm));
    initView();
    int i = getIntent().getIntExtra("key_scene", 0);
    Log.d("MicroMsg.QrRewardSelectMoneyUI", "scene: %s", new Object[] { Integer.valueOf(i) });
    h.OAn.b(14721, new Object[] { Integer.valueOf(2), Integer.valueOf(i) });
    AppMethodBeat.o(64001);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64004);
    super.onDestroy();
    removeSceneEndListener(1516);
    AppMethodBeat.o(64004);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(64003);
    if ((paramp instanceof f))
    {
      paramString = (f)paramp;
      paramString.a(new a.a()
      {
        public final void g(com.tencent.mm.am.p paramAnonymousp)
        {
          AppMethodBeat.i(63995);
          Log.d("MicroMsg.QrRewardSelectMoneyUI", "callback succ");
          QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this, paramString.wZX.ZgZ);
          QrRewardSelectMoneyUI.b(QrRewardSelectMoneyUI.this, paramString.wZX.OiN);
          QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this, paramString.wZX.ZgJ);
          QrRewardSelectMoneyUI.c(QrRewardSelectMoneyUI.this, paramString.wZX.ZgT);
          QrRewardSelectMoneyUI.d(QrRewardSelectMoneyUI.this, paramString.wZX.desc);
          QrRewardSelectMoneyUI.e(QrRewardSelectMoneyUI.this, paramString.wZX.Zhe);
          QrRewardSelectMoneyUI.f(QrRewardSelectMoneyUI.this, paramString.wZX.Zhf);
          QrRewardSelectMoneyUI.g(QrRewardSelectMoneyUI.this, paramString.wZX.Zhc);
          QrRewardSelectMoneyUI.h(QrRewardSelectMoneyUI.this, paramString.wZX.Zhi);
          QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this, paramString.wZX.ZgH);
          QrRewardSelectMoneyUI.i(QrRewardSelectMoneyUI.this, paramString.wZX.Zhj);
          QrRewardSelectMoneyUI.j(QrRewardSelectMoneyUI.this, paramString.wZX.Zhk);
          QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this, paramString.wZX.ign);
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
        public final void g(com.tencent.mm.am.p paramAnonymousp)
        {
          AppMethodBeat.i(63994);
          Log.e("MicroMsg.QrRewardSelectMoneyUI", "scan response error");
          if (!Util.isNullOrNil(paramString.wZX.wYI)) {
            Toast.makeText(QrRewardSelectMoneyUI.this, paramString.wZX.wYI, 1).show();
          }
          QrRewardSelectMoneyUI.this.finish();
          AppMethodBeat.o(63994);
        }
      }).c(new a.a()
      {
        public final void g(com.tencent.mm.am.p paramAnonymousp)
        {
          AppMethodBeat.i(63993);
          Log.e("MicroMsg.QrRewardSelectMoneyUI", "net error: %s", new Object[] { paramString });
          com.tencent.mm.ui.base.k.a(QrRewardSelectMoneyUI.this.getContext(), QrRewardSelectMoneyUI.this.getString(a.i.wallet_unknown_err), null, false, new DialogInterface.OnClickListener()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardSelectMoneyUI
 * JD-Core Version:    0.7.0.1
 */