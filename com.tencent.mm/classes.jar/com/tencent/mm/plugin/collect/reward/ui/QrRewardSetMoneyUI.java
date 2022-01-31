package com.tencent.mm.plugin.collect.reward.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.collect.reward.a.a;
import com.tencent.mm.plugin.collect.reward.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.MMGridView;
import com.tencent.mm.ui.t;
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
  private String hJS;
  private TextView iJG;
  private int kPm;
  private ImageView kPy;
  private MMGridView kQj;
  private Button kQk;
  private MMEditText kQl;
  private TextView kQm;
  private TextView kQn;
  private SparseArray<WalletFormView> kQo;
  private List<Integer> kQp;
  private List<Integer> kQq;
  private boolean kQr;
  private Runnable kQs;
  private TextWatcher kQt;
  
  public QrRewardSetMoneyUI()
  {
    AppMethodBeat.i(41158);
    this.kQr = false;
    this.kQs = new QrRewardSetMoneyUI.5(this);
    this.kQt = new QrRewardSetMoneyUI.6(this);
    AppMethodBeat.o(41158);
  }
  
  private boolean big()
  {
    AppMethodBeat.i(41163);
    int i = 0;
    while (i < this.kQp.size())
    {
      if (!((Integer)this.kQp.get(i)).equals(this.kQq.get(i)))
      {
        ab.i("MicroMsg.QrRewardSetMoneyUI", "modify money: %s, %s", new Object[] { this.kQp.get(i), this.kQq.get(i) });
        AppMethodBeat.o(41163);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(41163);
    return false;
  }
  
  private void bih()
  {
    AppMethodBeat.i(41164);
    int i = 0;
    if (i < this.kQq.size())
    {
      WalletFormView localWalletFormView = (WalletFormView)LayoutInflater.from(getContext()).inflate(2130970493, null);
      localWalletFormView.a(this.kQt);
      int j = ((Integer)this.kQq.get(i)).intValue();
      int k = j / 100;
      double d = j / 100.0D;
      if (d > k) {
        localWalletFormView.setText(String.format("%.2f", new Object[] { Double.valueOf(d) }));
      }
      for (;;)
      {
        setEditFocusListener(localWalletFormView, 2, false);
        this.kQo.put(i, localWalletFormView);
        i += 1;
        break;
        localWalletFormView.setText(String.format("%d", new Object[] { Integer.valueOf(k) }));
      }
    }
    AppMethodBeat.o(41164);
  }
  
  public int getLayoutId()
  {
    return 2130970495;
  }
  
  public void initView()
  {
    AppMethodBeat.i(41160);
    this.kQj = ((MMGridView)findViewById(2131826972));
    this.kQk = ((Button)findViewById(2131826973));
    this.kQm = ((TextView)findViewById(2131826975));
    this.kPy = ((ImageView)findViewById(2131826969));
    this.kQl = ((MMEditText)findViewById(2131826971));
    this.iJG = ((TextView)findViewById(2131826970));
    this.kQn = ((TextView)findViewById(2131826974));
    String str = r.Zp();
    Object localObject = str;
    if (bo.isNullOrNil(str)) {
      localObject = r.Zq();
    }
    this.iJG.setText(j.b(getContext(), (CharSequence)localObject));
    a.b.a(this.kPy, r.Zn(), 0.06F, false);
    localObject = new QrRewardSetMoneyUI.a(this, (byte)0);
    this.kQj.setAdapter((ListAdapter)localObject);
    if (!bo.isNullOrNil(this.desc)) {
      this.kQl.setText(j.b(this, this.desc, this.kQl.getTextSize()));
    }
    this.kQm.setText(getString(2131302229, new Object[] { Math.round(this.kPm / 100.0F) }));
    if (this.kQr)
    {
      this.kQk.setText(2131302210);
      this.kQn.setVisibility(8);
    }
    this.kQk.setOnClickListener(new t()
    {
      public final void bhX()
      {
        AppMethodBeat.i(41149);
        if (!QrRewardSetMoneyUI.a(QrRewardSetMoneyUI.this)) {
          QrRewardSetMoneyUI.b(QrRewardSetMoneyUI.this);
        }
        for (;;)
        {
          h.qsU.e(14721, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
          AppMethodBeat.o(41149);
          return;
          ab.i("MicroMsg.QrRewardSetMoneyUI", "amt error!");
        }
      }
    });
    AppMethodBeat.o(41160);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41159);
    super.onCreate(paramBundle);
    setMMTitle(2131302232);
    addSceneEndListener(1562);
    paramBundle = bo.ih((String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yIr, ""), ",");
    this.kQp = new ArrayList();
    if (paramBundle.isEmpty())
    {
      ab.i("MicroMsg.QrRewardSetMoneyUI", "use client hardcode amt list");
      this.kQp = Arrays.asList(b.kOR);
    }
    for (;;)
    {
      this.kQq = new ArrayList(this.kQp);
      this.kPm = ((Integer)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yIq, Integer.valueOf(20000))).intValue();
      this.kQr = getIntent().getBooleanExtra("key_first_flag", false);
      this.desc = getIntent().getStringExtra("key_desc_word");
      this.kQo = new SparseArray();
      bih();
      initView();
      AppMethodBeat.o(41159);
      return;
      paramBundle = paramBundle.iterator();
      while (paramBundle.hasNext())
      {
        String str = (String)paramBundle.next();
        this.kQp.add(Integer.valueOf(bo.getInt(str, 0)));
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41161);
    super.onDestroy();
    removeSceneEndListener(1562);
    al.ae(this.kQs);
    AppMethodBeat.o(41161);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(41162);
    if ((paramm instanceof com.tencent.mm.plugin.collect.reward.a.g))
    {
      paramString = (com.tencent.mm.plugin.collect.reward.a.g)paramm;
      paramString.a(new QrRewardSetMoneyUI.4(this, paramString)).b(new QrRewardSetMoneyUI.3(this, paramString)).c(new QrRewardSetMoneyUI.2(this));
    }
    AppMethodBeat.o(41162);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardSetMoneyUI
 * JD-Core Version:    0.7.0.1
 */