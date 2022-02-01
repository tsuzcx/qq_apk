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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.collect.reward.a.a;
import com.tencent.mm.plugin.collect.reward.b.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
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
  private String kML;
  private TextView lHk;
  private int piV;
  private MMGridView pjU;
  private Button pjV;
  private MMEditText pjW;
  private TextView pjX;
  private TextView pjY;
  private SparseArray<WalletFormView> pjZ;
  private ImageView pjj;
  private List<Integer> pka;
  private List<Integer> pkb;
  private boolean pkc;
  private Runnable pkd;
  private TextWatcher pke;
  
  public QrRewardSetMoneyUI()
  {
    AppMethodBeat.i(64019);
    this.pkc = false;
    this.pkd = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64014);
        QrRewardSetMoneyUI.a(QrRewardSetMoneyUI.this);
        AppMethodBeat.o(64014);
      }
    };
    this.pke = new TextWatcher()
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
          ar.ay(QrRewardSetMoneyUI.d(QrRewardSetMoneyUI.this));
          ar.o(QrRewardSetMoneyUI.d(QrRewardSetMoneyUI.this), 50L);
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
  
  private boolean ccl()
  {
    AppMethodBeat.i(64024);
    int i = 0;
    while (i < this.pka.size())
    {
      if (!((Integer)this.pka.get(i)).equals(this.pkb.get(i)))
      {
        ae.i("MicroMsg.QrRewardSetMoneyUI", "modify money: %s, %s", new Object[] { this.pka.get(i), this.pkb.get(i) });
        AppMethodBeat.o(64024);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(64024);
    return false;
  }
  
  private void ccm()
  {
    AppMethodBeat.i(64025);
    int i = 0;
    if (i < this.pkb.size())
    {
      WalletFormView localWalletFormView = (WalletFormView)LayoutInflater.from(getContext()).inflate(2131495166, null);
      localWalletFormView.a(this.pke);
      int j = ((Integer)this.pkb.get(i)).intValue();
      int k = j / 100;
      double d = j / 100.0D;
      if (d > k) {
        localWalletFormView.setText(String.format("%.2f", new Object[] { Double.valueOf(d) }));
      }
      for (;;)
      {
        setEditFocusListener(localWalletFormView, 2, false);
        this.pjZ.put(i, localWalletFormView);
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
    this.pjU = ((MMGridView)findViewById(2131303668));
    this.pjV = ((Button)findViewById(2131303667));
    this.pjX = ((TextView)findViewById(2131303664));
    this.pjj = ((ImageView)findViewById(2131303665));
    this.pjW = ((MMEditText)findViewById(2131303669));
    this.lHk = ((TextView)findViewById(2131303670));
    this.pjY = ((TextView)findViewById(2131303666));
    String str = v.aAE();
    Object localObject = str;
    if (bu.isNullOrNil(str)) {
      localObject = v.aAF();
    }
    this.lHk.setText(k.c(getContext(), (CharSequence)localObject));
    a.b.a(this.pjj, v.aAC(), 0.06F, false);
    localObject = new a((byte)0);
    this.pjU.setAdapter((ListAdapter)localObject);
    if (!bu.isNullOrNil(this.desc)) {
      this.pjW.setText(k.b(this, this.desc, this.pjW.getTextSize()));
    }
    this.pjX.setText(getString(2131762108, new Object[] { Math.round(this.piV / 100.0F) }));
    if (this.pkc)
    {
      this.pjV.setText(2131762089);
      this.pjY.setVisibility(8);
    }
    this.pjV.setOnClickListener(new w()
    {
      public final void ccc()
      {
        AppMethodBeat.i(64010);
        if (!QrRewardSetMoneyUI.a(QrRewardSetMoneyUI.this)) {
          QrRewardSetMoneyUI.b(QrRewardSetMoneyUI.this);
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.g.yxI.f(14721, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
          AppMethodBeat.o(64010);
          return;
          ae.i("MicroMsg.QrRewardSetMoneyUI", "amt error!");
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
    paramBundle = bu.lV((String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IVX, ""), ",");
    this.pka = new ArrayList();
    if (paramBundle.isEmpty())
    {
      ae.i("MicroMsg.QrRewardSetMoneyUI", "use client hardcode amt list");
      this.pka = Arrays.asList(b.piA);
    }
    for (;;)
    {
      this.pkb = new ArrayList(this.pka);
      this.piV = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IVW, Integer.valueOf(20000))).intValue();
      this.pkc = getIntent().getBooleanExtra("key_first_flag", false);
      this.desc = getIntent().getStringExtra("key_desc_word");
      this.pjZ = new SparseArray();
      ccm();
      initView();
      AppMethodBeat.o(64020);
      return;
      paramBundle = paramBundle.iterator();
      while (paramBundle.hasNext())
      {
        String str = (String)paramBundle.next();
        this.pka.add(Integer.valueOf(bu.getInt(str, 0)));
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64022);
    super.onDestroy();
    removeSceneEndListener(1562);
    ar.ay(this.pkd);
    AppMethodBeat.o(64022);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(64023);
    if ((paramn instanceof com.tencent.mm.plugin.collect.reward.a.g))
    {
      paramString = (com.tencent.mm.plugin.collect.reward.a.g)paramn;
      paramString.a(new QrRewardSetMoneyUI.4(this, paramString)).b(new QrRewardSetMoneyUI.3(this, paramString)).c(new QrRewardSetMoneyUI.2(this));
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