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
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.collect.reward.a.a;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.wv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.MMGridView;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.x;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class QrRewardSetMoneyUI
  extends QrRewardBaseUI
{
  private String desc;
  private String lRD;
  private TextView mPa;
  private int qyg;
  private ImageView qyu;
  private MMGridView qzf;
  private Button qzg;
  private MMEditText qzh;
  private TextView qzi;
  private TextView qzj;
  private SparseArray<WalletFormView> qzk;
  private List<Integer> qzl;
  private List<Integer> qzm;
  private boolean qzn;
  private Runnable qzo;
  private TextWatcher qzp;
  
  public QrRewardSetMoneyUI()
  {
    AppMethodBeat.i(64019);
    this.qzn = false;
    this.qzo = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64014);
        QrRewardSetMoneyUI.a(QrRewardSetMoneyUI.this);
        AppMethodBeat.o(64014);
      }
    };
    this.qzp = new TextWatcher()
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
          MMHandlerThread.removeRunnable(QrRewardSetMoneyUI.d(QrRewardSetMoneyUI.this));
          MMHandlerThread.postToMainThreadDelayed(QrRewardSetMoneyUI.d(QrRewardSetMoneyUI.this), 50L);
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
  
  private boolean cAf()
  {
    AppMethodBeat.i(64024);
    int i = 0;
    while (i < this.qzl.size())
    {
      if (!((Integer)this.qzl.get(i)).equals(this.qzm.get(i)))
      {
        Log.i("MicroMsg.QrRewardSetMoneyUI", "modify money: %s, %s", new Object[] { this.qzl.get(i), this.qzm.get(i) });
        AppMethodBeat.o(64024);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(64024);
    return false;
  }
  
  private void cAg()
  {
    AppMethodBeat.i(64025);
    int i = 0;
    if (i < this.qzm.size())
    {
      WalletFormView localWalletFormView = (WalletFormView)LayoutInflater.from(getContext()).inflate(2131496009, null);
      localWalletFormView.a(this.qzp);
      int j = ((Integer)this.qzm.get(i)).intValue();
      int k = j / 100;
      double d = j / 100.0D;
      if (d > k) {
        localWalletFormView.setText(String.format("%.2f", new Object[] { Double.valueOf(d) }));
      }
      for (;;)
      {
        setEditFocusListener(localWalletFormView, 2, false);
        this.qzk.put(i, localWalletFormView);
        i += 1;
        break;
        localWalletFormView.setText(String.format("%d", new Object[] { Integer.valueOf(k) }));
      }
    }
    AppMethodBeat.o(64025);
  }
  
  public int getLayoutId()
  {
    return 2131496011;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64021);
    this.qzf = ((MMGridView)findViewById(2131306447));
    this.qzg = ((Button)findViewById(2131306446));
    this.qzi = ((TextView)findViewById(2131306443));
    this.qyu = ((ImageView)findViewById(2131306444));
    this.qzh = ((MMEditText)findViewById(2131306448));
    this.mPa = ((TextView)findViewById(2131306449));
    this.qzj = ((TextView)findViewById(2131306445));
    String str = z.aUa();
    Object localObject = str;
    if (Util.isNullOrNil(str)) {
      localObject = z.aUb();
    }
    this.mPa.setText(l.c(getContext(), (CharSequence)localObject));
    a.b.a(this.qyu, z.aTY(), 0.06F, false);
    localObject = new a((byte)0);
    this.qzf.setAdapter((ListAdapter)localObject);
    if (!Util.isNullOrNil(this.desc)) {
      this.qzh.setText(l.b(this, this.desc, this.qzh.getTextSize()));
    }
    this.qzi.setText(getString(2131764129, new Object[] { Math.round(this.qyg / 100.0F) }));
    if (this.qzn)
    {
      this.qzg.setText(2131764110);
      this.qzj.setVisibility(8);
    }
    this.qzg.setOnClickListener(new x()
    {
      public final void czW()
      {
        AppMethodBeat.i(64010);
        if (!QrRewardSetMoneyUI.a(QrRewardSetMoneyUI.this)) {
          QrRewardSetMoneyUI.b(QrRewardSetMoneyUI.this);
        }
        for (;;)
        {
          h.CyF.a(14721, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
          AppMethodBeat.o(64010);
          return;
          Log.i("MicroMsg.QrRewardSetMoneyUI", "amt error!");
        }
      }
    });
    AppMethodBeat.o(64021);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64020);
    super.onCreate(paramBundle);
    setMMTitle(2131764132);
    addSceneEndListener(1562);
    paramBundle = Util.stringToList((String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Oep, ""), ",");
    this.qzl = new ArrayList();
    if (paramBundle.isEmpty())
    {
      Log.i("MicroMsg.QrRewardSetMoneyUI", "use client hardcode amt list");
      this.qzl = Arrays.asList(b.qxL);
    }
    for (;;)
    {
      this.qzm = new ArrayList(this.qzl);
      this.qyg = ((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Oeo, Integer.valueOf(20000))).intValue();
      this.qzn = getIntent().getBooleanExtra("key_first_flag", false);
      this.desc = getIntent().getStringExtra("key_desc_word");
      this.qzk = new SparseArray();
      cAg();
      initView();
      AppMethodBeat.o(64020);
      return;
      paramBundle = paramBundle.iterator();
      while (paramBundle.hasNext())
      {
        String str = (String)paramBundle.next();
        this.qzl.add(Integer.valueOf(Util.getInt(str, 0)));
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64022);
    super.onDestroy();
    removeSceneEndListener(1562);
    MMHandlerThread.removeRunnable(this.qzo);
    AppMethodBeat.o(64022);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(64023);
    if ((paramq instanceof com.tencent.mm.plugin.collect.reward.a.g))
    {
      paramString = (com.tencent.mm.plugin.collect.reward.a.g)paramq;
      paramString.a(new a.a()
      {
        public final void g(q paramAnonymousq)
        {
          AppMethodBeat.i(64013);
          QrRewardSetMoneyUI.a(QrRewardSetMoneyUI.this, paramString.qxG.Cog);
          QrRewardSetMoneyUI.b(QrRewardSetMoneyUI.this, paramString.qxG.desc);
          paramAnonymousq = new Intent();
          paramAnonymousq.putExtra("key_desc", paramString.qxG.desc);
          paramAnonymousq.putExtra("key_photo_url", paramString.qxG.Cog);
          paramAnonymousq.putExtra("key_photo_aeskey", paramString.qxG.Lhl);
          paramAnonymousq.putExtra("key_photo_width", paramString.qxG.Lhq);
          paramAnonymousq.putExtra("key_icon_width", paramString.qxG.Lhm);
          paramAnonymousq.putExtra("key_return_from_first", QrRewardSetMoneyUI.c(QrRewardSetMoneyUI.this));
          QrRewardSetMoneyUI.this.setResult(-1, paramAnonymousq);
          QrRewardSetMoneyUI.this.finish();
          AppMethodBeat.o(64013);
        }
      }).b(new a.a()
      {
        public final void g(q paramAnonymousq)
        {
          AppMethodBeat.i(64012);
          Log.e("MicroMsg.QrRewardSetMoneyUI", "set code error: %s, %s", new Object[] { Integer.valueOf(paramString.qxG.dDN), paramString.qxG.qwn });
          if (!Util.isNullOrNil(paramString.qxG.qwn))
          {
            Toast.makeText(QrRewardSetMoneyUI.this, paramString.qxG.qwn, 1).show();
            AppMethodBeat.o(64012);
            return;
          }
          Toast.makeText(QrRewardSetMoneyUI.this, 2131764127, 1).show();
          AppMethodBeat.o(64012);
        }
      }).c(new a.a()
      {
        public final void g(q paramAnonymousq)
        {
          AppMethodBeat.i(64011);
          Log.e("MicroMsg.QrRewardSetMoneyUI", "net error: %s", new Object[] { paramAnonymousq });
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