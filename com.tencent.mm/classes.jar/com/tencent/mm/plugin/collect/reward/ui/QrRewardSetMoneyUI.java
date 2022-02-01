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
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.collect.reward.a.a;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.tq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
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
  private String kow;
  private TextView lfN;
  private List<Integer> oAa;
  private boolean oAb;
  private Runnable oAc;
  private TextWatcher oAd;
  private int oyU;
  private MMGridView ozT;
  private Button ozU;
  private MMEditText ozV;
  private TextView ozW;
  private TextView ozX;
  private SparseArray<WalletFormView> ozY;
  private List<Integer> ozZ;
  private ImageView ozi;
  
  public QrRewardSetMoneyUI()
  {
    AppMethodBeat.i(64019);
    this.oAb = false;
    this.oAc = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64014);
        QrRewardSetMoneyUI.a(QrRewardSetMoneyUI.this);
        AppMethodBeat.o(64014);
      }
    };
    this.oAd = new TextWatcher()
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
          ap.aB(QrRewardSetMoneyUI.d(QrRewardSetMoneyUI.this));
          ap.n(QrRewardSetMoneyUI.d(QrRewardSetMoneyUI.this), 50L);
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
  
  private boolean bWt()
  {
    AppMethodBeat.i(64024);
    int i = 0;
    while (i < this.ozZ.size())
    {
      if (!((Integer)this.ozZ.get(i)).equals(this.oAa.get(i)))
      {
        ac.i("MicroMsg.QrRewardSetMoneyUI", "modify money: %s, %s", new Object[] { this.ozZ.get(i), this.oAa.get(i) });
        AppMethodBeat.o(64024);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(64024);
    return false;
  }
  
  private void bWu()
  {
    AppMethodBeat.i(64025);
    int i = 0;
    if (i < this.oAa.size())
    {
      WalletFormView localWalletFormView = (WalletFormView)LayoutInflater.from(getContext()).inflate(2131495166, null);
      localWalletFormView.a(this.oAd);
      int j = ((Integer)this.oAa.get(i)).intValue();
      int k = j / 100;
      double d = j / 100.0D;
      if (d > k) {
        localWalletFormView.setText(String.format("%.2f", new Object[] { Double.valueOf(d) }));
      }
      for (;;)
      {
        setEditFocusListener(localWalletFormView, 2, false);
        this.ozY.put(i, localWalletFormView);
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
    this.ozT = ((MMGridView)findViewById(2131303668));
    this.ozU = ((Button)findViewById(2131303667));
    this.ozW = ((TextView)findViewById(2131303664));
    this.ozi = ((ImageView)findViewById(2131303665));
    this.ozV = ((MMEditText)findViewById(2131303669));
    this.lfN = ((TextView)findViewById(2131303670));
    this.ozX = ((TextView)findViewById(2131303666));
    String str = u.axy();
    Object localObject = str;
    if (bs.isNullOrNil(str)) {
      localObject = u.axz();
    }
    this.lfN.setText(k.c(getContext(), (CharSequence)localObject));
    a.b.a(this.ozi, u.axw(), 0.06F, false);
    localObject = new a((byte)0);
    this.ozT.setAdapter((ListAdapter)localObject);
    if (!bs.isNullOrNil(this.desc)) {
      this.ozV.setText(k.b(this, this.desc, this.ozV.getTextSize()));
    }
    this.ozW.setText(getString(2131762108, new Object[] { Math.round(this.oyU / 100.0F) }));
    if (this.oAb)
    {
      this.ozU.setText(2131762089);
      this.ozX.setVisibility(8);
    }
    this.ozU.setOnClickListener(new w()
    {
      public final void bWk()
      {
        AppMethodBeat.i(64010);
        if (!QrRewardSetMoneyUI.a(QrRewardSetMoneyUI.this)) {
          QrRewardSetMoneyUI.b(QrRewardSetMoneyUI.this);
        }
        for (;;)
        {
          h.wUl.f(14721, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
          AppMethodBeat.o(64010);
          return;
          ac.i("MicroMsg.QrRewardSetMoneyUI", "amt error!");
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
    paramBundle = bs.lp((String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GPd, ""), ",");
    this.ozZ = new ArrayList();
    if (paramBundle.isEmpty())
    {
      ac.i("MicroMsg.QrRewardSetMoneyUI", "use client hardcode amt list");
      this.ozZ = Arrays.asList(b.oyz);
    }
    for (;;)
    {
      this.oAa = new ArrayList(this.ozZ);
      this.oyU = ((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GPc, Integer.valueOf(20000))).intValue();
      this.oAb = getIntent().getBooleanExtra("key_first_flag", false);
      this.desc = getIntent().getStringExtra("key_desc_word");
      this.ozY = new SparseArray();
      bWu();
      initView();
      AppMethodBeat.o(64020);
      return;
      paramBundle = paramBundle.iterator();
      while (paramBundle.hasNext())
      {
        String str = (String)paramBundle.next();
        this.ozZ.add(Integer.valueOf(bs.getInt(str, 0)));
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64022);
    super.onDestroy();
    removeSceneEndListener(1562);
    ap.aB(this.oAc);
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
          QrRewardSetMoneyUI.a(QrRewardSetMoneyUI.this, paramString.oyu.wJR);
          QrRewardSetMoneyUI.b(QrRewardSetMoneyUI.this, paramString.oyu.desc);
          paramAnonymousn = new Intent();
          paramAnonymousn.putExtra("key_desc", paramString.oyu.desc);
          paramAnonymousn.putExtra("key_photo_url", paramString.oyu.wJR);
          paramAnonymousn.putExtra("key_photo_aeskey", paramString.oyu.EmZ);
          paramAnonymousn.putExtra("key_photo_width", paramString.oyu.Ene);
          paramAnonymousn.putExtra("key_icon_width", paramString.oyu.Ena);
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
          ac.e("MicroMsg.QrRewardSetMoneyUI", "set code error: %s, %s", new Object[] { Integer.valueOf(paramString.oyu.dae), paramString.oyu.oxf });
          if (!bs.isNullOrNil(paramString.oyu.oxf))
          {
            Toast.makeText(QrRewardSetMoneyUI.this, paramString.oyu.oxf, 1).show();
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
          ac.e("MicroMsg.QrRewardSetMoneyUI", "net error: %s", new Object[] { paramAnonymousn });
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