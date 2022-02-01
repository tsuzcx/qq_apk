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
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.collect.reward.a.a;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.g;
import com.tencent.mm.plugin.collect.reward.b.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.wz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.MMGridView;
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
  private String oOi;
  private TextView pPT;
  private int tXg;
  private ImageView tXu;
  private MMGridView tYf;
  private Button tYg;
  private MMEditText tYh;
  private TextView tYi;
  private TextView tYj;
  private SparseArray<WalletFormView> tYk;
  private List<Integer> tYl;
  private List<Integer> tYm;
  private boolean tYn;
  private Runnable tYo;
  private TextWatcher tYp;
  
  public QrRewardSetMoneyUI()
  {
    AppMethodBeat.i(64019);
    this.tYn = false;
    this.tYo = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64014);
        QrRewardSetMoneyUI.a(QrRewardSetMoneyUI.this);
        AppMethodBeat.o(64014);
      }
    };
    this.tYp = new TextWatcher()
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
  
  private boolean cOF()
  {
    AppMethodBeat.i(64024);
    int i = 0;
    while (i < this.tYl.size())
    {
      if (!((Integer)this.tYl.get(i)).equals(this.tYm.get(i)))
      {
        Log.i("MicroMsg.QrRewardSetMoneyUI", "modify money: %s, %s", new Object[] { this.tYl.get(i), this.tYm.get(i) });
        AppMethodBeat.o(64024);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(64024);
    return false;
  }
  
  private void cOG()
  {
    AppMethodBeat.i(64025);
    int i = 0;
    if (i < this.tYm.size())
    {
      WalletFormView localWalletFormView = (WalletFormView)LayoutInflater.from(getContext()).inflate(a.g.qr_reward_setting_item, null);
      localWalletFormView.a(this.tYp);
      int j = ((Integer)this.tYm.get(i)).intValue();
      int k = j / 100;
      double d = j / 100.0D;
      if (d > k) {
        localWalletFormView.setText(String.format("%.2f", new Object[] { Double.valueOf(d) }));
      }
      for (;;)
      {
        setEditFocusListener(localWalletFormView, 2, false);
        this.tYk.put(i, localWalletFormView);
        i += 1;
        break;
        localWalletFormView.setText(String.format("%d", new Object[] { Integer.valueOf(k) }));
      }
    }
    AppMethodBeat.o(64025);
  }
  
  public int getLayoutId()
  {
    return a.g.qr_reward_setting_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64021);
    this.tYf = ((MMGridView)findViewById(a.f.qrsu_money_layout_new));
    this.tYg = ((Button)findViewById(a.f.qrsu_gen_btn));
    this.tYi = ((TextView)findViewById(a.f.qrsu_alert_tv));
    this.tXu = ((ImageView)findViewById(a.f.qrsu_avatar_iv));
    this.tYh = ((MMEditText)findViewById(a.f.qrsu_reward_et));
    this.pPT = ((TextView)findViewById(a.f.qrsu_title_tv));
    this.tYj = ((TextView)findViewById(a.f.qrsu_bottom_tips_tv));
    String str = z.bdb();
    Object localObject = str;
    if (Util.isNullOrNil(str)) {
      localObject = z.bdc();
    }
    this.pPT.setText(l.c(getContext(), (CharSequence)localObject));
    a.b.a(this.tXu, z.bcZ(), 0.06F, false);
    localObject = new a((byte)0);
    this.tYf.setAdapter((ListAdapter)localObject);
    if (!Util.isNullOrNil(this.desc)) {
      this.tYh.setText(l.b(this, this.desc, this.tYh.getTextSize()));
    }
    this.tYi.setText(getString(a.i.qr_reward_set_money_exceed_text, new Object[] { Math.round(this.tXg / 100.0F) }));
    if (this.tYn)
    {
      this.tYg.setText(a.i.qr_reward_first_set_money_btn_text);
      this.tYj.setVisibility(8);
    }
    this.tYg.setOnClickListener(new aa()
    {
      public final void cOw()
      {
        AppMethodBeat.i(64010);
        if (!QrRewardSetMoneyUI.a(QrRewardSetMoneyUI.this)) {
          QrRewardSetMoneyUI.b(QrRewardSetMoneyUI.this);
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.IzE.a(14721, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
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
    setMMTitle(a.i.qr_reward_set_money_title);
    addSceneEndListener(1562);
    paramBundle = Util.stringToList((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VsA, ""), ",");
    this.tYl = new ArrayList();
    if (paramBundle.isEmpty())
    {
      Log.i("MicroMsg.QrRewardSetMoneyUI", "use client hardcode amt list");
      this.tYl = Arrays.asList(b.tWL);
    }
    for (;;)
    {
      this.tYm = new ArrayList(this.tYl);
      this.tXg = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vsz, Integer.valueOf(20000))).intValue();
      this.tYn = getIntent().getBooleanExtra("key_first_flag", false);
      this.desc = getIntent().getStringExtra("key_desc_word");
      this.tYk = new SparseArray();
      cOG();
      initView();
      AppMethodBeat.o(64020);
      return;
      paramBundle = paramBundle.iterator();
      while (paramBundle.hasNext())
      {
        String str = (String)paramBundle.next();
        this.tYl.add(Integer.valueOf(Util.getInt(str, 0)));
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64022);
    super.onDestroy();
    removeSceneEndListener(1562);
    MMHandlerThread.removeRunnable(this.tYo);
    AppMethodBeat.o(64022);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(64023);
    if ((paramq instanceof g))
    {
      paramString = (g)paramq;
      paramString.a(new a.a()
      {
        public final void g(q paramAnonymousq)
        {
          AppMethodBeat.i(64013);
          QrRewardSetMoneyUI.a(QrRewardSetMoneyUI.this, paramString.tWG.IkZ);
          QrRewardSetMoneyUI.b(QrRewardSetMoneyUI.this, paramString.tWG.desc);
          paramAnonymousq = new Intent();
          paramAnonymousq.putExtra("key_desc", paramString.tWG.desc);
          paramAnonymousq.putExtra("key_photo_url", paramString.tWG.IkZ);
          paramAnonymousq.putExtra("key_photo_aeskey", paramString.tWG.Siz);
          paramAnonymousq.putExtra("key_photo_width", paramString.tWG.SiE);
          paramAnonymousq.putExtra("key_icon_width", paramString.tWG.SiA);
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
          Log.e("MicroMsg.QrRewardSetMoneyUI", "set code error: %s, %s", new Object[] { Integer.valueOf(paramString.tWG.fwx), paramString.tWG.tVo });
          if (!Util.isNullOrNil(paramString.tWG.tVo))
          {
            Toast.makeText(QrRewardSetMoneyUI.this, paramString.tWG.tVo, 1).show();
            AppMethodBeat.o(64012);
            return;
          }
          Toast.makeText(QrRewardSetMoneyUI.this, a.i.qr_reward_set_code_failure_text, 1).show();
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