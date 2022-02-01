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
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.tm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.MMGridView;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(2)
public class QrRewardSelectMoneyUI
  extends QrRewardBaseUI
{
  private int channel;
  private String kbL;
  private String oyL;
  private String oyN;
  private String oyP;
  private String oyQ;
  private String oyR;
  private String oyS;
  private String oyT;
  private int oyU;
  private String oyV;
  private String oyW;
  private List<Integer> ozE;
  private CdnImageView ozF;
  private TextView ozG;
  private TextView ozH;
  private TextView ozI;
  private TextView ozJ;
  private MMGridView ozK;
  private TextView ozL;
  private a ozM;
  private String ozN;
  private String ozO;
  
  public QrRewardSelectMoneyUI()
  {
    AppMethodBeat.i(64000);
    this.ozE = new ArrayList();
    AppMethodBeat.o(64000);
  }
  
  private void Wk(String paramString)
  {
    AppMethodBeat.i(64006);
    if (bs.isNullOrNil(this.oyV)) {}
    for (paramString = e.wk(paramString);; paramString = this.oyV)
    {
      this.ozH.setText(k.c(getContext(), paramString));
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
    this.ozF = ((CdnImageView)findViewById(2131303657));
    this.ozG = ((TextView)findViewById(2131303662));
    this.ozH = ((TextView)findViewById(2131303660));
    this.ozI = ((TextView)findViewById(2131303658));
    this.ozJ = ((TextView)findViewById(2131303663));
    this.ozK = ((MMGridView)findViewById(2131303659));
    this.ozL = ((TextView)findViewById(2131303661));
    this.ozM = new a((byte)0);
    this.ozK.setAdapter(this.ozM);
    this.ozK.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(63990);
        paramAnonymousInt = ((Integer)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt)).intValue();
        QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this, paramAnonymousInt, 1);
        AppMethodBeat.o(63990);
      }
    });
    this.ozL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(63991);
        QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this, 0, 2);
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
        ac.i("MicroMsg.QrRewardSelectMoneyUI", "pay succ");
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
    this.ozN = getIntent().getStringExtra("key_qrcode_url");
    this.channel = getIntent().getIntExtra("key_channel", 0);
    this.kbL = getIntent().getStringExtra("key_web_url");
    ac.i("MicroMsg.QrRewardSelectMoneyUI", "do scan code");
    doSceneProgress(new f(this.ozN, this.channel, this.kbL));
    initView();
    int i = getIntent().getIntExtra("key_scene", 0);
    ac.d("MicroMsg.QrRewardSelectMoneyUI", "scene: %s", new Object[] { Integer.valueOf(i) });
    com.tencent.mm.plugin.report.service.h.wUl.f(14721, new Object[] { Integer.valueOf(2), Integer.valueOf(i) });
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
          ac.d("MicroMsg.QrRewardSelectMoneyUI", "callback succ");
          QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this, paramString.oyt.Ent);
          QrRewardSelectMoneyUI.b(QrRewardSelectMoneyUI.this, paramString.oyt.wKR);
          QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this, paramString.oyt.End);
          QrRewardSelectMoneyUI.c(QrRewardSelectMoneyUI.this, paramString.oyt.Enn);
          QrRewardSelectMoneyUI.d(QrRewardSelectMoneyUI.this, paramString.oyt.desc);
          QrRewardSelectMoneyUI.e(QrRewardSelectMoneyUI.this, paramString.oyt.Eny);
          QrRewardSelectMoneyUI.f(QrRewardSelectMoneyUI.this, paramString.oyt.Enz);
          QrRewardSelectMoneyUI.g(QrRewardSelectMoneyUI.this, paramString.oyt.Enw);
          QrRewardSelectMoneyUI.h(QrRewardSelectMoneyUI.this, paramString.oyt.EnC);
          QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this, paramString.oyt.Enb);
          QrRewardSelectMoneyUI.i(QrRewardSelectMoneyUI.this, paramString.oyt.EnD);
          QrRewardSelectMoneyUI.j(QrRewardSelectMoneyUI.this, paramString.oyt.EnE);
          if (QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this) == null)
          {
            ac.i("MicroMsg.QrRewardSelectMoneyUI", "amt_list is null");
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
          ac.e("MicroMsg.QrRewardSelectMoneyUI", "scan response error");
          if (!bs.isNullOrNil(paramString.oyt.oxf)) {
            Toast.makeText(QrRewardSelectMoneyUI.this, paramString.oyt.oxf, 1).show();
          }
          QrRewardSelectMoneyUI.this.finish();
          AppMethodBeat.o(63994);
        }
      }).c(new a.a()
      {
        public final void g(n paramAnonymousn)
        {
          AppMethodBeat.i(63993);
          ac.e("MicroMsg.QrRewardSelectMoneyUI", "net error: %s", new Object[] { paramString });
          com.tencent.mm.ui.base.h.a(QrRewardSelectMoneyUI.this.getContext(), QrRewardSelectMoneyUI.this.getString(2131765901), null, false, new DialogInterface.OnClickListener()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardSelectMoneyUI
 * JD-Core Version:    0.7.0.1
 */