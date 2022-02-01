package com.tencent.mm.plugin.collect.reward.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.collect.reward.a.a;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.tg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.base.MMGridView;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class QrRewardSetMoneyUI
  extends QrRewardBaseUI
{
  private String desc;
  private String jNV;
  private TextView kEu;
  private ImageView nVN;
  private int nVz;
  private MMEditText nWA;
  private TextView nWB;
  private TextView nWC;
  private SparseArray<WalletFormView> nWD;
  private List<Integer> nWE;
  private List<Integer> nWF;
  private boolean nWG;
  private Runnable nWH;
  private TextWatcher nWI;
  private MMGridView nWy;
  private Button nWz;
  
  public QrRewardSetMoneyUI()
  {
    AppMethodBeat.i(64019);
    this.nWG = false;
    this.nWH = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64014);
        QrRewardSetMoneyUI.a(QrRewardSetMoneyUI.this);
        AppMethodBeat.o(64014);
      }
    };
    this.nWI = new QrRewardSetMoneyUI.6(this);
    AppMethodBeat.o(64019);
  }
  
  private boolean bPd()
  {
    AppMethodBeat.i(64024);
    int i = 0;
    while (i < this.nWE.size())
    {
      if (!((Integer)this.nWE.get(i)).equals(this.nWF.get(i)))
      {
        ad.i("MicroMsg.QrRewardSetMoneyUI", "modify money: %s, %s", new Object[] { this.nWE.get(i), this.nWF.get(i) });
        AppMethodBeat.o(64024);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(64024);
    return false;
  }
  
  private void bPe()
  {
    AppMethodBeat.i(64025);
    int i = 0;
    if (i < this.nWF.size())
    {
      WalletFormView localWalletFormView = (WalletFormView)LayoutInflater.from(getContext()).inflate(2131495166, null);
      localWalletFormView.a(this.nWI);
      int j = ((Integer)this.nWF.get(i)).intValue();
      int k = j / 100;
      double d = j / 100.0D;
      if (d > k) {
        localWalletFormView.setText(String.format("%.2f", new Object[] { Double.valueOf(d) }));
      }
      for (;;)
      {
        setEditFocusListener(localWalletFormView, 2, false);
        this.nWD.put(i, localWalletFormView);
        i += 1;
        break;
        localWalletFormView.setText(String.format("%d", new Object[] { Integer.valueOf(k) }));
      }
    }
    AppMethodBeat.o(64025);
  }
  
  public int getLayoutId()
  {
    return 2131495168;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64021);
    this.nWy = ((MMGridView)findViewById(2131303668));
    this.nWz = ((Button)findViewById(2131303667));
    this.nWB = ((TextView)findViewById(2131303664));
    this.nVN = ((ImageView)findViewById(2131303665));
    this.nWA = ((MMEditText)findViewById(2131303669));
    this.kEu = ((TextView)findViewById(2131303670));
    this.nWC = ((TextView)findViewById(2131303666));
    String str = u.aqI();
    Object localObject = str;
    if (bt.isNullOrNil(str)) {
      localObject = u.aqJ();
    }
    this.kEu.setText(k.c(getContext(), (CharSequence)localObject));
    a.b.a(this.nVN, u.aqG(), 0.06F, false);
    localObject = new a((byte)0);
    this.nWy.setAdapter((ListAdapter)localObject);
    if (!bt.isNullOrNil(this.desc)) {
      this.nWA.setText(k.b(this, this.desc, this.nWA.getTextSize()));
    }
    this.nWB.setText(getString(2131762108, new Object[] { Math.round(this.nVz / 100.0F) }));
    if (this.nWG)
    {
      this.nWz.setText(2131762089);
      this.nWC.setVisibility(8);
    }
    this.nWz.setOnClickListener(new v()
    {
      public final void bOU()
      {
        AppMethodBeat.i(64010);
        if (!QrRewardSetMoneyUI.a(QrRewardSetMoneyUI.this)) {
          QrRewardSetMoneyUI.b(QrRewardSetMoneyUI.this);
        }
        for (;;)
        {
          h.vKh.f(14721, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
          AppMethodBeat.o(64010);
          return;
          ad.i("MicroMsg.QrRewardSetMoneyUI", "amt error!");
        }
      }
    });
    AppMethodBeat.o(64021);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64020);
    super.onCreate(paramBundle);
    setMMTitle(2131762111);
    addSceneEndListener(1562);
    paramBundle = bt.kS((String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Frn, ""), ",");
    this.nWE = new ArrayList();
    if (paramBundle.isEmpty())
    {
      ad.i("MicroMsg.QrRewardSetMoneyUI", "use client hardcode amt list");
      this.nWE = Arrays.asList(b.nVe);
    }
    for (;;)
    {
      this.nWF = new ArrayList(this.nWE);
      this.nVz = ((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Frm, Integer.valueOf(20000))).intValue();
      this.nWG = getIntent().getBooleanExtra("key_first_flag", false);
      this.desc = getIntent().getStringExtra("key_desc_word");
      this.nWD = new SparseArray();
      bPe();
      initView();
      AppMethodBeat.o(64020);
      return;
      paramBundle = paramBundle.iterator();
      while (paramBundle.hasNext())
      {
        String str = (String)paramBundle.next();
        this.nWE.add(Integer.valueOf(bt.getInt(str, 0)));
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64022);
    super.onDestroy();
    removeSceneEndListener(1562);
    aq.az(this.nWH);
    AppMethodBeat.o(64022);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(64023);
    if ((paramn instanceof com.tencent.mm.plugin.collect.reward.a.g))
    {
      paramString = (com.tencent.mm.plugin.collect.reward.a.g)paramn;
      paramString.a(new a.a()
      {
        public final void h(n paramAnonymousn)
        {
          AppMethodBeat.i(64013);
          QrRewardSetMoneyUI.a(QrRewardSetMoneyUI.this, paramString.nUZ.vzM);
          QrRewardSetMoneyUI.b(QrRewardSetMoneyUI.this, paramString.nUZ.desc);
          paramAnonymousn = new Intent();
          paramAnonymousn.putExtra("key_desc", paramString.nUZ.desc);
          paramAnonymousn.putExtra("key_photo_url", paramString.nUZ.vzM);
          paramAnonymousn.putExtra("key_photo_aeskey", paramString.nUZ.CUp);
          paramAnonymousn.putExtra("key_photo_width", paramString.nUZ.CUu);
          paramAnonymousn.putExtra("key_icon_width", paramString.nUZ.CUq);
          paramAnonymousn.putExtra("key_return_from_first", QrRewardSetMoneyUI.c(QrRewardSetMoneyUI.this));
          QrRewardSetMoneyUI.this.setResult(-1, paramAnonymousn);
          QrRewardSetMoneyUI.this.finish();
          AppMethodBeat.o(64013);
        }
      }).b(new a.a()
      {
        public final void h(n paramAnonymousn)
        {
          AppMethodBeat.i(64012);
          ad.e("MicroMsg.QrRewardSetMoneyUI", "set code error: %s, %s", new Object[] { Integer.valueOf(paramString.nUZ.dcG), paramString.nUZ.nTK });
          if (!bt.isNullOrNil(paramString.nUZ.nTK))
          {
            Toast.makeText(QrRewardSetMoneyUI.this, paramString.nUZ.nTK, 1).show();
            AppMethodBeat.o(64012);
            return;
          }
          Toast.makeText(QrRewardSetMoneyUI.this, 2131762106, 1).show();
          AppMethodBeat.o(64012);
        }
      }).c(new a.a()
      {
        public final void h(n paramAnonymousn)
        {
          AppMethodBeat.i(64011);
          ad.e("MicroMsg.QrRewardSetMoneyUI", "net error: %s", new Object[] { paramAnonymousn });
          AppMethodBeat.o(64011);
        }
      });
    }
    AppMethodBeat.o(64023);
    return false;
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
      AppMethodBeat.i(64016);
      int i = QrRewardSetMoneyUI.e(QrRewardSetMoneyUI.this).size();
      AppMethodBeat.o(64016);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(64017);
      Object localObject = QrRewardSetMoneyUI.e(QrRewardSetMoneyUI.this).get(paramInt);
      AppMethodBeat.o(64017);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(64018);
      if (paramView == null) {
        paramView = (View)QrRewardSetMoneyUI.f(QrRewardSetMoneyUI.this).get(paramInt);
      }
      for (;;)
      {
        AppMethodBeat.o(64018);
        return paramView;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardSetMoneyUI
 * JD-Core Version:    0.7.0.1
 */