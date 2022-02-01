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
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.n;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.as.b.a;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.vh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.MMGridView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(2)
public class QrRewardSelectMoneyUI
  extends QrRewardBaseUI
{
  private int channel;
  private String kwk;
  private List<Integer> pcZ;
  private String pcg;
  private String pci;
  private String pck;
  private String pcl;
  private String pcm;
  private String pcn;
  private String pco;
  private int pcp;
  private String pcq;
  private String pcr;
  private CdnImageView pda;
  private TextView pdb;
  private TextView pdc;
  private TextView pdd;
  private TextView pde;
  private MMGridView pdf;
  private TextView pdg;
  private a pdh;
  private String pdi;
  private String pdj;
  
  public QrRewardSelectMoneyUI()
  {
    AppMethodBeat.i(64000);
    this.pcZ = new ArrayList();
    AppMethodBeat.o(64000);
  }
  
  private void ZR(String paramString)
  {
    AppMethodBeat.i(64006);
    if (bt.isNullOrNil(this.pcq)) {}
    for (paramString = e.zf(paramString);; paramString = this.pcq)
    {
      this.pdc.setText(k.c(getContext(), paramString));
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
    this.pda = ((CdnImageView)findViewById(2131303657));
    this.pdb = ((TextView)findViewById(2131303662));
    this.pdc = ((TextView)findViewById(2131303660));
    this.pdd = ((TextView)findViewById(2131303658));
    this.pde = ((TextView)findViewById(2131303663));
    this.pdf = ((MMGridView)findViewById(2131303659));
    this.pdg = ((TextView)findViewById(2131303661));
    this.pdh = new a((byte)0);
    this.pdf.setAdapter(this.pdh);
    this.pdf.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(63990);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/reward/ui/QrRewardSelectMoneyUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        paramAnonymousInt = ((Integer)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt)).intValue();
        QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this, paramAnonymousInt, 1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/reward/ui/QrRewardSelectMoneyUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(63990);
      }
    });
    this.pdg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(63991);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/reward/ui/QrRewardSelectMoneyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
        ad.i("MicroMsg.QrRewardSelectMoneyUI", "pay succ");
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
    this.pdi = getIntent().getStringExtra("key_qrcode_url");
    this.channel = getIntent().getIntExtra("key_channel", 0);
    this.kwk = getIntent().getStringExtra("key_web_url");
    ad.i("MicroMsg.QrRewardSelectMoneyUI", "do scan code");
    doSceneProgress(new f(this.pdi, this.channel, this.kwk));
    initView();
    int i = getIntent().getIntExtra("key_scene", 0);
    ad.d("MicroMsg.QrRewardSelectMoneyUI", "scene: %s", new Object[] { Integer.valueOf(i) });
    g.yhR.f(14721, new Object[] { Integer.valueOf(2), Integer.valueOf(i) });
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
    if ((paramn instanceof f))
    {
      paramString = (f)paramn;
      paramString.a(new a.a()
      {
        public final void g(n paramAnonymousn)
        {
          AppMethodBeat.i(63995);
          ad.d("MicroMsg.QrRewardSelectMoneyUI", "callback succ");
          QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this, paramString.pbO.FUC);
          QrRewardSelectMoneyUI.b(QrRewardSelectMoneyUI.this, paramString.pbO.xYy);
          QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this, paramString.pbO.FUm);
          QrRewardSelectMoneyUI.c(QrRewardSelectMoneyUI.this, paramString.pbO.FUw);
          QrRewardSelectMoneyUI.d(QrRewardSelectMoneyUI.this, paramString.pbO.desc);
          QrRewardSelectMoneyUI.e(QrRewardSelectMoneyUI.this, paramString.pbO.FUH);
          QrRewardSelectMoneyUI.f(QrRewardSelectMoneyUI.this, paramString.pbO.FUI);
          QrRewardSelectMoneyUI.g(QrRewardSelectMoneyUI.this, paramString.pbO.FUF);
          QrRewardSelectMoneyUI.h(QrRewardSelectMoneyUI.this, paramString.pbO.FUL);
          QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this, paramString.pbO.FUk);
          QrRewardSelectMoneyUI.i(QrRewardSelectMoneyUI.this, paramString.pbO.FUM);
          QrRewardSelectMoneyUI.j(QrRewardSelectMoneyUI.this, paramString.pbO.FUN);
          if (QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this) == null)
          {
            ad.i("MicroMsg.QrRewardSelectMoneyUI", "amt_list is null");
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
          ad.e("MicroMsg.QrRewardSelectMoneyUI", "scan response error");
          if (!bt.isNullOrNil(paramString.pbO.paA)) {
            Toast.makeText(QrRewardSelectMoneyUI.this, paramString.pbO.paA, 1).show();
          }
          QrRewardSelectMoneyUI.this.finish();
          AppMethodBeat.o(63994);
        }
      }).c(new a.a()
      {
        public final void g(n paramAnonymousn)
        {
          AppMethodBeat.i(63993);
          ad.e("MicroMsg.QrRewardSelectMoneyUI", "net error: %s", new Object[] { paramString });
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
        localView = LayoutInflater.from(QrRewardSelectMoneyUI.this.getContext()).inflate(2131495164, paramViewGroup, false);
      }
      paramInt = ((Integer)getItem(paramInt)).intValue();
      paramView = (TextView)localView.findViewById(2131303656);
      int i = paramInt / 100;
      double d = paramInt / 100.0D;
      if (d > i) {
        paramView.setText(String.format("%.2f", new Object[] { Double.valueOf(d) }) + QrRewardSelectMoneyUI.this.getString(2131762115));
      }
      for (;;)
      {
        AppMethodBeat.o(63999);
        return localView;
        paramView.setText(String.format("%d", new Object[] { Integer.valueOf(i) }) + QrRewardSelectMoneyUI.this.getString(2131762115));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardSelectMoneyUI
 * JD-Core Version:    0.7.0.1
 */