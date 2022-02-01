package com.tencent.mm.plugin.collect.reward.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
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
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.vl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.base.MMGridView;
import com.tencent.mm.ui.w;
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
  private String kJw;
  private TextView lCL;
  private ImageView pcD;
  private int pcp;
  private MMGridView pdo;
  private Button pdp;
  private MMEditText pdq;
  private TextView pdr;
  private TextView pds;
  private SparseArray<WalletFormView> pdt;
  private List<Integer> pdu;
  private List<Integer> pdv;
  private boolean pdw;
  private Runnable pdx;
  private TextWatcher pdy;
  
  public QrRewardSetMoneyUI()
  {
    AppMethodBeat.i(64019);
    this.pdw = false;
    this.pdx = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64014);
        QrRewardSetMoneyUI.a(QrRewardSetMoneyUI.this);
        AppMethodBeat.o(64014);
      }
    };
    this.pdy = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(64015);
        if (paramAnonymousEditable.toString().startsWith(".")) {
          paramAnonymousEditable.insert(0, "0");
        }
        String str = paramAnonymousEditable.toString();
        int i = str.indexOf(".");
        int j = str.length();
        if ((i >= 0) && (j - i > 3)) {
          paramAnonymousEditable.delete(i + 3, j);
        }
        for (;;)
        {
          aq.aA(QrRewardSetMoneyUI.d(QrRewardSetMoneyUI.this));
          aq.o(QrRewardSetMoneyUI.d(QrRewardSetMoneyUI.this), 50L);
          AppMethodBeat.o(64015);
          return;
          if (i > 6) {
            paramAnonymousEditable.delete(6, i);
          } else if ((i == -1) && (j > 6)) {
            paramAnonymousEditable.delete(6, j);
          }
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    AppMethodBeat.o(64019);
  }
  
  private boolean caW()
  {
    AppMethodBeat.i(64024);
    int i = 0;
    while (i < this.pdu.size())
    {
      if (!((Integer)this.pdu.get(i)).equals(this.pdv.get(i)))
      {
        ad.i("MicroMsg.QrRewardSetMoneyUI", "modify money: %s, %s", new Object[] { this.pdu.get(i), this.pdv.get(i) });
        AppMethodBeat.o(64024);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(64024);
    return false;
  }
  
  private void caX()
  {
    AppMethodBeat.i(64025);
    int i = 0;
    if (i < this.pdv.size())
    {
      WalletFormView localWalletFormView = (WalletFormView)LayoutInflater.from(getContext()).inflate(2131495166, null);
      localWalletFormView.a(this.pdy);
      int j = ((Integer)this.pdv.get(i)).intValue();
      int k = j / 100;
      double d = j / 100.0D;
      if (d > k) {
        localWalletFormView.setText(String.format("%.2f", new Object[] { Double.valueOf(d) }));
      }
      for (;;)
      {
        setEditFocusListener(localWalletFormView, 2, false);
        this.pdt.put(i, localWalletFormView);
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
    this.pdo = ((MMGridView)findViewById(2131303668));
    this.pdp = ((Button)findViewById(2131303667));
    this.pdr = ((TextView)findViewById(2131303664));
    this.pcD = ((ImageView)findViewById(2131303665));
    this.pdq = ((MMEditText)findViewById(2131303669));
    this.lCL = ((TextView)findViewById(2131303670));
    this.pds = ((TextView)findViewById(2131303666));
    String str = u.aAo();
    Object localObject = str;
    if (bt.isNullOrNil(str)) {
      localObject = u.aAp();
    }
    this.lCL.setText(k.c(getContext(), (CharSequence)localObject));
    a.b.a(this.pcD, u.aAm(), 0.06F, false);
    localObject = new a((byte)0);
    this.pdo.setAdapter((ListAdapter)localObject);
    if (!bt.isNullOrNil(this.desc)) {
      this.pdq.setText(k.b(this, this.desc, this.pdq.getTextSize()));
    }
    this.pdr.setText(getString(2131762108, new Object[] { Math.round(this.pcp / 100.0F) }));
    if (this.pdw)
    {
      this.pdp.setText(2131762089);
      this.pds.setVisibility(8);
    }
    this.pdp.setOnClickListener(new w()
    {
      public final void caN()
      {
        AppMethodBeat.i(64010);
        if (!QrRewardSetMoneyUI.a(QrRewardSetMoneyUI.this)) {
          QrRewardSetMoneyUI.b(QrRewardSetMoneyUI.this);
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.g.yhR.f(14721, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
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
    paramBundle = bt.lO((String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IBy, ""), ",");
    this.pdu = new ArrayList();
    if (paramBundle.isEmpty())
    {
      ad.i("MicroMsg.QrRewardSetMoneyUI", "use client hardcode amt list");
      this.pdu = Arrays.asList(b.pbU);
    }
    for (;;)
    {
      this.pdv = new ArrayList(this.pdu);
      this.pcp = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IBx, Integer.valueOf(20000))).intValue();
      this.pdw = getIntent().getBooleanExtra("key_first_flag", false);
      this.desc = getIntent().getStringExtra("key_desc_word");
      this.pdt = new SparseArray();
      caX();
      initView();
      AppMethodBeat.o(64020);
      return;
      paramBundle = paramBundle.iterator();
      while (paramBundle.hasNext())
      {
        String str = (String)paramBundle.next();
        this.pdu.add(Integer.valueOf(bt.getInt(str, 0)));
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64022);
    super.onDestroy();
    removeSceneEndListener(1562);
    aq.aA(this.pdx);
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
        public final void g(n paramAnonymousn)
        {
          AppMethodBeat.i(64013);
          QrRewardSetMoneyUI.a(QrRewardSetMoneyUI.this, paramString.pbP.xXy);
          QrRewardSetMoneyUI.b(QrRewardSetMoneyUI.this, paramString.pbP.desc);
          paramAnonymousn = new Intent();
          paramAnonymousn.putExtra("key_desc", paramString.pbP.desc);
          paramAnonymousn.putExtra("key_photo_url", paramString.pbP.xXy);
          paramAnonymousn.putExtra("key_photo_aeskey", paramString.pbP.FUi);
          paramAnonymousn.putExtra("key_photo_width", paramString.pbP.FUn);
          paramAnonymousn.putExtra("key_icon_width", paramString.pbP.FUj);
          paramAnonymousn.putExtra("key_return_from_first", QrRewardSetMoneyUI.c(QrRewardSetMoneyUI.this));
          QrRewardSetMoneyUI.this.setResult(-1, paramAnonymousn);
          QrRewardSetMoneyUI.this.finish();
          AppMethodBeat.o(64013);
        }
      }).b(new a.a()
      {
        public final void g(n paramAnonymousn)
        {
          AppMethodBeat.i(64012);
          ad.e("MicroMsg.QrRewardSetMoneyUI", "set code error: %s, %s", new Object[] { Integer.valueOf(paramString.pbP.dlw), paramString.pbP.paA });
          if (!bt.isNullOrNil(paramString.pbP.paA))
          {
            Toast.makeText(QrRewardSetMoneyUI.this, paramString.pbP.paA, 1).show();
            AppMethodBeat.o(64012);
            return;
          }
          Toast.makeText(QrRewardSetMoneyUI.this, 2131762106, 1).show();
          AppMethodBeat.o(64012);
        }
      }).c(new a.a()
      {
        public final void g(n paramAnonymousn)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardSetMoneyUI
 * JD-Core Version:    0.7.0.1
 */