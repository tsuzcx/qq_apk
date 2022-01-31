package com.tencent.mm.plugin.honey_pay.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.honey_pay.a.i;
import com.tencent.mm.plugin.honey_pay.a.l;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.plugin.wallet_core.ui.o.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.avf;
import com.tencent.mm.protocal.protobuf.bfa;
import com.tencent.mm.protocal.protobuf.bfg;
import com.tencent.mm.protocal.protobuf.bkt;
import com.tencent.mm.protocal.protobuf.bme;
import com.tencent.mm.protocal.protobuf.bpq;
import com.tencent.mm.protocal.protobuf.ckm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.c.p.a;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HoneyPayCardManagerUI
  extends HoneyPayBaseUI
{
  private ImageView kPy;
  private ViewGroup kyN;
  private ViewGroup lmd;
  private int mScene;
  private String nHE;
  private ckm nHF;
  private TextView nHI;
  private TextView nHK;
  private TextView nHL;
  private TextView nHM;
  private TextView nHN;
  private WalletTextView nHY;
  private ListView nIb;
  private ViewGroup nIc;
  private ViewGroup nId;
  private TextView nIe;
  private MMSwitchBtn nIf;
  private LinearLayout nIg;
  private TextView nIh;
  private TextView nIi;
  private TextView nIj;
  private View nIk;
  private View nIl;
  private TextView nIm;
  private HoneyPayCardManagerUI.a nIn;
  private List<bkt> nIo;
  private Bankcard nIp;
  private bme nIq;
  private bme nIr;
  private long nIs;
  private long nIt;
  private boolean nIu;
  private String nIv;
  
  public HoneyPayCardManagerUI()
  {
    AppMethodBeat.i(41811);
    this.nIo = new ArrayList();
    AppMethodBeat.o(41811);
  }
  
  private static Bankcard QM(String paramString)
  {
    AppMethodBeat.i(41822);
    Bankcard localBankcard1 = t.cTN().i(paramString, false, false);
    if (localBankcard1 == null)
    {
      Bankcard localBankcard2 = t.cTN().ulT;
      if ((localBankcard2 != null) && (localBankcard2.field_bindSerial.equals(paramString)))
      {
        AppMethodBeat.o(41822);
        return localBankcard2;
      }
    }
    AppMethodBeat.o(41822);
    return localBankcard1;
  }
  
  private void a(avf paramavf)
  {
    boolean bool = false;
    AppMethodBeat.i(41823);
    Object localObject = e.fa(paramavf.wKl, 6) + getString(2131300686);
    this.nIh.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this, (CharSequence)localObject, this.nIh.getTextSize()));
    a.b.a(this.kPy, paramavf.wKl, 0.06F, false);
    this.nHY.setText(c.kn(paramavf.wOy));
    localObject = this.nIf;
    if (paramavf.tVm != 0) {
      bool = true;
    }
    ((MMSwitchBtn)localObject).setCheck(bool);
    bHZ();
    AppMethodBeat.o(41823);
  }
  
  private void a(bfg parambfg)
  {
    AppMethodBeat.i(41821);
    this.nIc = ((ViewGroup)View.inflate(this, 2130969865, null));
    ((TextView)this.nIc.findViewById(2131825006)).setText(parambfg.title);
    this.nIc.setOnClickListener(new HoneyPayCardManagerUI.8(this, parambfg));
    AppMethodBeat.o(41821);
  }
  
  private void a(bpq parambpq)
  {
    AppMethodBeat.i(41820);
    this.nHF = parambpq.xaX;
    this.nIo.clear();
    this.nIn.notifyDataSetChanged();
    int i;
    if (parambpq.wOz != null)
    {
      setMMTitle(parambpq.wOz.knv);
      this.nIs = parambpq.wKn;
      this.nIt = parambpq.wKm;
      if (parambpq.wOz.xkE != null)
      {
        this.nIp = QM(parambpq.wOz.xkE.xAC);
        this.nIq = parambpq.wOz.xkE;
      }
      a(parambpq.wOz);
      i = parambpq.wOz.state;
      ab.i(this.TAG, "detail state: %s", new Object[] { Integer.valueOf(i) });
      ab.d(this.TAG, "state title: %s", new Object[] { parambpq.wOz.xkH });
      if (bo.isNullOrNil(parambpq.wOz.xkH)) {
        break label416;
      }
      this.nHI.setText(parambpq.wOz.xkH);
      this.nHI.setVisibility(0);
      if (bo.isNullOrNil(parambpq.wOz.xkD)) {
        break label428;
      }
      this.nIj.setText(parambpq.wOz.xkD);
      this.nIj.setVisibility(0);
      label233:
      if (i != 1) {
        break label440;
      }
      this.nHI.setTextColor(Color.parseColor("#FA9D3B"));
      this.nHY.setTextColor(Color.parseColor("#B2B2B2"));
      findViewById(2131825013).setVisibility(8);
      this.nIb.removeFooterView(this.kyN);
      this.kyN.setVisibility(8);
      this.nIk.setVisibility(8);
      if (this.nIu)
      {
        this.nId = ((ViewGroup)LayoutInflater.from(this).inflate(2130969863, null));
        ((Button)this.nId.findViewById(2131825005)).setOnClickListener(new HoneyPayCardManagerUI.7(this));
        this.nIb.addFooterView(this.nId);
        showHomeBtn(false);
        enableBackMenu(false);
        setMMTitle("");
      }
    }
    for (;;)
    {
      this.nIl.setVisibility(8);
      c.b(this, parambpq.xkx, this.nHE, 2, this.nHF);
      AppMethodBeat.o(41820);
      return;
      label416:
      this.nHI.setVisibility(8);
      break;
      label428:
      this.nIj.setVisibility(8);
      break label233;
      label440:
      if (i == 2)
      {
        if ((parambpq.wkO != null) && (!parambpq.wkO.isEmpty()))
        {
          this.nIo = parambpq.wkO;
          this.nIn.notifyDataSetChanged();
          this.nIb.removeFooterView(this.kyN);
          this.kyN.setVisibility(8);
          if (parambpq.xDF != null)
          {
            a(parambpq.xDF);
            this.nIb.addFooterView(this.nIc);
          }
          findViewById(2131825028).setBackgroundResource(2131690170);
        }
        this.nIe.setVisibility(0);
        this.nHY.setVisibility(0);
        this.nIk.setVisibility(0);
        findViewById(2131825013).setVisibility(8);
      }
      else if (i == 3)
      {
        findViewById(2131825013).setVisibility(0);
        this.nHK.setText(2131300665);
        this.nHL.setText(2131300708);
        this.nHM.setText(c.ko(parambpq.wOz.wyt));
        this.nHN.setText(c.ko(parambpq.wOz.kmb));
        this.nIb.removeFooterView(this.kyN);
        this.kyN.setVisibility(8);
        this.nIk.setVisibility(8);
        findViewById(2131825020).setVisibility(8);
      }
      else if (i == 4)
      {
        this.nIe.setVisibility(8);
        findViewById(2131825013).setVisibility(0);
        this.nHK.setText(2131300707);
        this.nHM.setText(c.ko(parambpq.wOz.xkF));
        findViewById(2131825017).setVisibility(8);
        this.nIb.removeFooterView(this.kyN);
        this.kyN.setVisibility(8);
        this.nIk.setVisibility(8);
        findViewById(2131825020).setVisibility(8);
        findViewById(2131825028).setBackgroundResource(2131690709);
      }
      else
      {
        ab.d(this.TAG, "unknown state: %s", new Object[] { Integer.valueOf(i) });
      }
    }
  }
  
  private void bHY()
  {
    AppMethodBeat.i(41819);
    ab.i(this.TAG, "do qry detail");
    l locall = new l(this.nHE);
    locall.o(this);
    doSceneProgress(locall, true);
    AppMethodBeat.o(41819);
  }
  
  private void bHZ()
  {
    AppMethodBeat.i(41824);
    if (this.nIq != null)
    {
      this.nIi.setText(this.nIq.xAA);
      if (!bo.isNullOrNil(this.nIq.xAB)) {
        this.nIi.setTextColor(Color.parseColor(this.nIq.xAB));
      }
      while (!bo.isNullOrNil(this.nIq.xAF))
      {
        this.nIm.setText(this.nIq.xAF);
        this.nIm.setVisibility(0);
        AppMethodBeat.o(41824);
        return;
        this.nIi.setTextColor(getResources().getColor(2131690322));
      }
      this.nIm.setVisibility(8);
      AppMethodBeat.o(41824);
      return;
    }
    ab.i(this.TAG, "reset payway view for null");
    this.nIi.setText("");
    this.nIi.setTextColor(getResources().getColor(2131690322));
    this.nIm.setVisibility(8);
    AppMethodBeat.o(41824);
  }
  
  public int getLayoutId()
  {
    return 2130969868;
  }
  
  public void initView()
  {
    AppMethodBeat.i(41818);
    this.lmd = ((ViewGroup)LayoutInflater.from(this).inflate(2130969866, null));
    this.nIf = ((MMSwitchBtn)this.lmd.findViewById(2131825021));
    this.nIg = ((LinearLayout)this.lmd.findViewById(2131825022));
    this.nIi = ((TextView)this.lmd.findViewById(2131825023));
    this.kPy = ((ImageView)this.lmd.findViewById(2131825007));
    this.nHY = ((WalletTextView)this.lmd.findViewById(2131825009));
    this.nIh = ((TextView)this.lmd.findViewById(2131825008));
    this.nIe = ((TextView)this.lmd.findViewById(2131825012));
    this.nHI = ((TextView)this.lmd.findViewById(2131825010));
    this.nIj = ((TextView)this.lmd.findViewById(2131825011));
    this.nHK = ((TextView)this.lmd.findViewById(2131825015));
    this.nHM = ((TextView)this.lmd.findViewById(2131825016));
    this.nHL = ((TextView)this.lmd.findViewById(2131825018));
    this.nHN = ((TextView)this.lmd.findViewById(2131825019));
    this.nIk = this.lmd.findViewById(2131825025);
    this.nIm = ((TextView)this.lmd.findViewById(2131825024));
    this.nHY.setPrefix(ae.dSz());
    this.nIf.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        int i = 1;
        AppMethodBeat.i(41795);
        ab.d(HoneyPayCardManagerUI.this.TAG, "check %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        HoneyPayCardManagerUI localHoneyPayCardManagerUI = HoneyPayCardManagerUI.this;
        if (paramAnonymousBoolean) {}
        for (;;)
        {
          HoneyPayCardManagerUI.a(localHoneyPayCardManagerUI, i);
          AppMethodBeat.o(41795);
          return;
          i = 0;
        }
      }
    });
    this.nIg.setOnClickListener(new HoneyPayCardManagerUI.4(this));
    String str = getString(2131300686);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(str);
    localSpannableStringBuilder.append(getString(2131300688));
    localSpannableStringBuilder.setSpan(new o(new o.a()
    {
      public final void dj(View paramAnonymousView)
      {
        AppMethodBeat.i(41797);
        HoneyPayCardManagerUI.g(HoneyPayCardManagerUI.this);
        AppMethodBeat.o(41797);
      }
    }), str.length(), localSpannableStringBuilder.length(), 18);
    this.nIe.setClickable(true);
    this.nIe.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m(this));
    this.nIe.setText(localSpannableStringBuilder);
    this.kyN = ((ViewGroup)LayoutInflater.from(this).inflate(2130969864, null));
    this.nIl = findViewById(2131825030);
    this.nIb = ((ListView)findViewById(2131825029));
    this.nIb.addHeaderView(this.lmd);
    this.nIb.addFooterView(this.kyN, null, false);
    this.nIn = new HoneyPayCardManagerUI.a(this, (byte)0);
    this.nIb.setAdapter(this.nIn);
    this.nIb.setOnItemClickListener(new HoneyPayCardManagerUI.1(this));
    AppMethodBeat.o(41818);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(41816);
    if (paramInt1 == 1) {
      if ((paramInt2 == -1) && (paramIntent.getBooleanExtra("key_modify_create_line_succ", false)))
      {
        long l = paramIntent.getLongExtra("key_credit_line", 0L);
        this.nHY.setText(c.kn(l));
        setResult(-1);
      }
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(41816);
      return;
      if (paramInt1 == 2)
      {
        if (paramInt2 == -1)
        {
          removeAllOptionMenu();
          setResult(-1);
          finish();
        }
      }
      else if ((paramInt1 == 3) && (paramInt2 == -1)) {
        bHY();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41812);
    super.onCreate(paramBundle);
    addSceneEndListener(2876);
    addSceneEndListener(2742);
    addSceneEndListener(2941);
    this.nHE = getIntent().getStringExtra("key_card_no");
    this.mScene = getIntent().getIntExtra("key_scene", 0);
    this.nIu = getIntent().getBooleanExtra("key_is_create", false);
    this.nIv = getIntent().getStringExtra("key_card_type");
    initView();
    ab.d(this.TAG, "cardtype: %s", new Object[] { this.nIv });
    setMMTitle(2131300680);
    if (this.mScene == 1)
    {
      paramBundle = new bpq();
      try
      {
        paramBundle.parseFrom(getIntent().getByteArrayExtra("key_qry_response"));
        a(paramBundle);
        AppMethodBeat.o(41812);
        return;
      }
      catch (IOException paramBundle)
      {
        ab.printErrStackTrace(this.TAG, paramBundle, "", new Object[0]);
        bHY();
        AppMethodBeat.o(41812);
        return;
      }
    }
    bHY();
    AppMethodBeat.o(41812);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41814);
    super.onDestroy();
    removeSceneEndListener(2876);
    removeSceneEndListener(2742);
    removeSceneEndListener(2941);
    AppMethodBeat.o(41814);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(41815);
    if ((paramm instanceof l))
    {
      paramString = (l)paramm;
      paramString.a(new HoneyPayCardManagerUI.11(this, paramString)).b(new HoneyPayCardManagerUI.10(this)).c(new HoneyPayCardManagerUI.9(this));
    }
    for (;;)
    {
      AppMethodBeat.o(41815);
      return true;
      if ((paramm instanceof i))
      {
        paramString = (i)paramm;
        paramString.a(new HoneyPayCardManagerUI.14(this)).b(new HoneyPayCardManagerUI.13(this, paramString)).c(new HoneyPayCardManagerUI.12(this, paramString));
      }
      else if ((paramm instanceof com.tencent.mm.plugin.honey_pay.a.j))
      {
        paramString = (com.tencent.mm.plugin.honey_pay.a.j)paramm;
        paramString.a(new p.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ai.m paramAnonymousm)
          {
            AppMethodBeat.i(41794);
            HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, paramString.nHl.xut);
            if (HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this) != null) {
              HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, HoneyPayCardManagerUI.QN(HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this).xAC));
            }
            HoneyPayCardManagerUI.d(HoneyPayCardManagerUI.this);
            AppMethodBeat.o(41794);
          }
        }).b(new HoneyPayCardManagerUI.16(this)).c(new HoneyPayCardManagerUI.15(this));
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI
 * JD-Core Version:    0.7.0.1
 */