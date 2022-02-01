package com.tencent.mm.plugin.honey_pay.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.honey_pay.a.i;
import com.tencent.mm.plugin.honey_pay.a.j;
import com.tencent.mm.plugin.honey_pay.a.l;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wallet_core.utils.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.bom;
import com.tencent.mm.protocal.protobuf.cba;
import com.tencent.mm.protocal.protobuf.cbj;
import com.tencent.mm.protocal.protobuf.cio;
import com.tencent.mm.protocal.protobuf.ckd;
import com.tencent.mm.protocal.protobuf.com;
import com.tencent.mm.protocal.protobuf.dnn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HoneyPayCardManagerUI
  extends HoneyPayBaseUI
{
  private int mScene;
  private ViewGroup oMH;
  private ImageView pcD;
  private String uFI;
  private dnn uFJ;
  private TextView uFM;
  private TextView uFO;
  private TextView uFP;
  private TextView uFQ;
  private TextView uFR;
  private String uGA;
  private WalletTextView uGc;
  private ListView uGf;
  private ViewGroup uGg;
  private ViewGroup uGh;
  private ViewGroup uGi;
  private TextView uGj;
  private MMSwitchBtn uGk;
  private LinearLayout uGl;
  private TextView uGm;
  private TextView uGn;
  private TextView uGo;
  private View uGp;
  private View uGq;
  private TextView uGr;
  private HoneyPayCardManagerUI.a uGs;
  private List<cio> uGt;
  private Bankcard uGu;
  private ckd uGv;
  private ckd uGw;
  private long uGx;
  private long uGy;
  private boolean uGz;
  
  public HoneyPayCardManagerUI()
  {
    AppMethodBeat.i(64702);
    this.uGt = new ArrayList();
    AppMethodBeat.o(64702);
  }
  
  private void a(bom parambom)
  {
    boolean bool = false;
    AppMethodBeat.i(64712);
    Object localObject = e.gP(parambom.FWt, 6) + getString(2131760283);
    this.uGm.setText(k.b(this, (CharSequence)localObject, this.uGm.getTextSize()));
    a.b.a(this.pcD, parambom.FWt, 0.06F, false);
    this.uGc.setText(c.xK(parambom.Gbu));
    localObject = this.uGk;
    if (parambom.CIh != 0) {
      bool = true;
    }
    ((MMSwitchBtn)localObject).setCheck(bool);
    dch();
    AppMethodBeat.o(64712);
  }
  
  private void a(cbj paramcbj)
  {
    AppMethodBeat.i(64710);
    this.uGh = ((ViewGroup)View.inflate(this, 2131494442, null));
    ((TextView)this.uGh.findViewById(2131300797)).setText(paramcbj.title);
    this.uGh.setOnClickListener(new HoneyPayCardManagerUI.8(this, paramcbj));
    AppMethodBeat.o(64710);
  }
  
  private void a(com paramcom)
  {
    AppMethodBeat.i(64709);
    this.uFJ = paramcom.Gxg;
    this.uGt.clear();
    this.uGs.notifyDataSetChanged();
    int i;
    if (paramcom.Gbv != null)
    {
      setMMTitle(paramcom.Gbv.ozd);
      this.uGx = paramcom.FWv;
      this.uGy = paramcom.FWu;
      if (paramcom.Gbv.GJi != null)
      {
        this.uGu = anj(paramcom.Gbv.GJi.HdJ);
        this.uGv = paramcom.Gbv.GJi;
      }
      a(paramcom.Gbv);
      i = paramcom.Gbv.state;
      ad.i(this.TAG, "detail state: %s", new Object[] { Integer.valueOf(i) });
      ad.d(this.TAG, "state title: %s", new Object[] { paramcom.Gbv.GJl });
      if (bt.isNullOrNil(paramcom.Gbv.GJl)) {
        break label424;
      }
      this.uFM.setText(paramcom.Gbv.GJl);
      this.uFM.setVisibility(0);
      if (bt.isNullOrNil(paramcom.Gbv.GJh)) {
        break label436;
      }
      this.uGo.setText(paramcom.Gbv.GJh);
      this.uGo.setVisibility(0);
      label233:
      if (i != 1) {
        break label448;
      }
      this.uFM.setTextColor(getResources().getColor(2131099777));
      this.uGc.setTextColor(getResources().getColor(2131099734));
      findViewById(2131300801).setVisibility(8);
      this.uGf.removeFooterView(this.uGg);
      this.uGg.setVisibility(8);
      this.uGp.setVisibility(8);
      if (this.uGz)
      {
        this.uGi = ((ViewGroup)LayoutInflater.from(this).inflate(2131494440, null));
        ((Button)this.uGi.findViewById(2131300802)).setOnClickListener(new HoneyPayCardManagerUI.7(this));
        this.uGf.addFooterView(this.uGi);
        showHomeBtn(false);
        enableBackMenu(false);
        setMMTitle("");
      }
    }
    for (;;)
    {
      this.uGq.setVisibility(8);
      c.b(this, paramcom.GJb, this.uFI, 2, this.uFJ);
      AppMethodBeat.o(64709);
      return;
      label424:
      this.uFM.setVisibility(8);
      break;
      label436:
      this.uGo.setVisibility(8);
      break label233;
      label448:
      if (i == 2)
      {
        if ((paramcom.cTn != null) && (!paramcom.cTn.isEmpty()))
        {
          this.uGt = paramcom.cTn;
          this.uGs.notifyDataSetChanged();
          this.uGf.removeFooterView(this.uGg);
          this.uGg.setVisibility(8);
          if (paramcom.Hht != null)
          {
            a(paramcom.Hht);
            this.uGf.addFooterView(this.uGh);
          }
          findViewById(2131300813).setBackgroundResource(2131100492);
        }
        this.uGj.setVisibility(0);
        this.uGc.setVisibility(0);
        this.uGp.setVisibility(0);
        findViewById(2131300801).setVisibility(8);
      }
      else if (i == 3)
      {
        findViewById(2131300801).setVisibility(0);
        this.uFO.setText(2131760262);
        this.uFP.setText(2131760305);
        this.uFQ.setText(c.xL(paramcom.Gbv.FHr));
        this.uFR.setText(c.xL(paramcom.Gbv.oxC));
        this.uGf.removeFooterView(this.uGg);
        this.uGg.setVisibility(8);
        this.uGp.setVisibility(8);
        findViewById(2131300817).setVisibility(8);
      }
      else if (i == 4)
      {
        this.uGj.setVisibility(8);
        findViewById(2131300801).setVisibility(0);
        this.uFO.setText(2131760304);
        this.uFQ.setText(c.xL(paramcom.Gbv.GJj));
        findViewById(2131300814).setVisibility(8);
        this.uGf.removeFooterView(this.uGg);
        this.uGg.setVisibility(8);
        this.uGp.setVisibility(8);
        findViewById(2131300817).setVisibility(8);
        findViewById(2131300813).setBackgroundResource(2131101179);
      }
      else
      {
        ad.d(this.TAG, "unknown state: %s", new Object[] { Integer.valueOf(i) });
      }
    }
  }
  
  private static Bankcard anj(String paramString)
  {
    AppMethodBeat.i(64711);
    Bankcard localBankcard1 = t.eFy().aEt(paramString);
    if (localBankcard1 == null)
    {
      Bankcard localBankcard2 = t.eFy().Dba;
      if ((localBankcard2 != null) && (localBankcard2.field_bindSerial.equals(paramString)))
      {
        AppMethodBeat.o(64711);
        return localBankcard2;
      }
    }
    AppMethodBeat.o(64711);
    return localBankcard1;
  }
  
  private void dcg()
  {
    AppMethodBeat.i(64708);
    ad.i(this.TAG, "do qry detail");
    l locall = new l(this.uFI);
    locall.t(this);
    doSceneProgress(locall, true);
    AppMethodBeat.o(64708);
  }
  
  private void dch()
  {
    AppMethodBeat.i(64713);
    if (this.uGv != null)
    {
      this.uGn.setText(this.uGv.HdH);
      if (!bt.isNullOrNil(this.uGv.HdI)) {
        this.uGn.setTextColor(g.cl(this.uGv.HdI, true));
      }
      while (!bt.isNullOrNil(this.uGv.HdM))
      {
        this.uGr.setText(this.uGv.HdM);
        this.uGr.setVisibility(0);
        AppMethodBeat.o(64713);
        return;
        this.uGn.setTextColor(getResources().getColor(2131100711));
      }
      this.uGr.setVisibility(8);
      AppMethodBeat.o(64713);
      return;
    }
    ad.i(this.TAG, "reset payway view for null");
    this.uGn.setText("");
    this.uGn.setTextColor(getResources().getColor(2131100711));
    this.uGr.setVisibility(8);
    AppMethodBeat.o(64713);
  }
  
  public int getLayoutId()
  {
    return 2131494445;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64704);
    this.oMH = ((ViewGroup)LayoutInflater.from(this).inflate(2131494443, null));
    this.uGk = ((MMSwitchBtn)this.oMH.findViewById(2131300808));
    this.uGl = ((LinearLayout)this.oMH.findViewById(2131300809));
    this.uGn = ((TextView)this.oMH.findViewById(2131300811));
    this.pcD = ((ImageView)this.oMH.findViewById(2131300798));
    this.uGc = ((WalletTextView)this.oMH.findViewById(2131300812));
    this.uGm = ((TextView)this.oMH.findViewById(2131300820));
    this.uGj = ((TextView)this.oMH.findViewById(2131300807));
    this.uFM = ((TextView)this.oMH.findViewById(2131300819));
    this.uGo = ((TextView)this.oMH.findViewById(2131300818));
    this.uFO = ((TextView)this.oMH.findViewById(2131300804));
    this.uFQ = ((TextView)this.oMH.findViewById(2131300805));
    this.uFP = ((TextView)this.oMH.findViewById(2131300815));
    this.uFR = ((TextView)this.oMH.findViewById(2131300816));
    this.uGp = this.oMH.findViewById(2131300800);
    this.uGr = ((TextView)this.oMH.findViewById(2131300810));
    this.uGc.setPrefix(ah.fRG());
    this.uGk.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        int i = 1;
        AppMethodBeat.i(64686);
        ad.d(HoneyPayCardManagerUI.this.TAG, "check %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        HoneyPayCardManagerUI localHoneyPayCardManagerUI = HoneyPayCardManagerUI.this;
        if (paramAnonymousBoolean) {}
        for (;;)
        {
          HoneyPayCardManagerUI.a(localHoneyPayCardManagerUI, i);
          AppMethodBeat.o(64686);
          return;
          i = 0;
        }
      }
    });
    this.uGl.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64687);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPayCardManagerUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this) != null)
        {
          ad.d(HoneyPayCardManagerUI.this.TAG, "click pay way: %s", new Object[] { Boolean.valueOf(HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this).HdL) });
          if (!HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this).HdL) {
            break label114;
          }
          HoneyPayCardManagerUI.e(HoneyPayCardManagerUI.this);
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayCardManagerUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(64687);
          return;
          label114:
          HoneyPayCardManagerUI.f(HoneyPayCardManagerUI.this);
        }
      }
    });
    String str = getString(2131760283);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(str);
    localSpannableStringBuilder.append(getString(2131760285));
    localSpannableStringBuilder.setSpan(new q(1, new HoneyPayCardManagerUI.5(this)), str.length(), localSpannableStringBuilder.length(), 18);
    this.uGj.setClickable(true);
    this.uGj.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
    this.uGj.setText(localSpannableStringBuilder);
    this.uGg = ((ViewGroup)LayoutInflater.from(this).inflate(2131494441, null));
    this.uGq = findViewById(2131300799);
    this.uGf = ((ListView)findViewById(2131300806));
    this.uGf.addHeaderView(this.oMH);
    this.uGf.addFooterView(this.uGg, null, false);
    this.uGs = new HoneyPayCardManagerUI.a(this, (byte)0);
    this.uGf.setAdapter(this.uGs);
    this.uGf.setOnItemClickListener(new HoneyPayCardManagerUI.1(this));
    AppMethodBeat.o(64704);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(64707);
    if (paramInt1 == 1) {
      if ((paramInt2 == -1) && (paramIntent.getBooleanExtra("key_modify_create_line_succ", false)))
      {
        long l = paramIntent.getLongExtra("key_credit_line", 0L);
        this.uGc.setText(c.xK(l));
        setResult(-1);
      }
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(64707);
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
        dcg();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64703);
    super.onCreate(paramBundle);
    addSceneEndListener(2876);
    addSceneEndListener(2742);
    addSceneEndListener(2941);
    this.uFI = getIntent().getStringExtra("key_card_no");
    this.mScene = getIntent().getIntExtra("key_scene", 0);
    this.uGz = getIntent().getBooleanExtra("key_is_create", false);
    this.uGA = getIntent().getStringExtra("key_card_type");
    initView();
    ad.d(this.TAG, "cardtype: %s", new Object[] { this.uGA });
    setMMTitle(2131760277);
    if (this.mScene == 1)
    {
      paramBundle = new com();
      try
      {
        paramBundle.parseFrom(getIntent().getByteArrayExtra("key_qry_response"));
        a(paramBundle);
        AppMethodBeat.o(64703);
        return;
      }
      catch (IOException paramBundle)
      {
        ad.printErrStackTrace(this.TAG, paramBundle, "", new Object[0]);
        dcg();
        AppMethodBeat.o(64703);
        return;
      }
    }
    dcg();
    AppMethodBeat.o(64703);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64705);
    super.onDestroy();
    removeSceneEndListener(2876);
    removeSceneEndListener(2742);
    removeSceneEndListener(2941);
    AppMethodBeat.o(64705);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(64706);
    if ((paramn instanceof l))
    {
      paramString = (l)paramn;
      paramString.a(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
        {
          AppMethodBeat.i(64692);
          HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, paramString.uFs);
          AppMethodBeat.o(64692);
        }
      }).b(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn) {}
      }).c(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn) {}
      });
    }
    for (;;)
    {
      AppMethodBeat.o(64706);
      return true;
      if ((paramn instanceof i))
      {
        paramString = (i)paramn;
        paramString.a(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn) {}
        }).b(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
          {
            boolean bool = true;
            AppMethodBeat.i(64694);
            paramAnonymousString = HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this);
            if (paramString.dDp != 1) {}
            for (;;)
            {
              paramAnonymousString.setCheck(bool);
              AppMethodBeat.o(64694);
              return;
              bool = false;
            }
          }
        }).c(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
          {
            boolean bool = true;
            AppMethodBeat.i(64693);
            paramAnonymousString = HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this);
            if (paramString.dDp != 1) {}
            for (;;)
            {
              paramAnonymousString.setCheck(bool);
              AppMethodBeat.o(64693);
              return;
              bool = false;
            }
          }
        });
      }
      else if ((paramn instanceof j))
      {
        paramString = (j)paramn;
        paramString.a(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
          {
            AppMethodBeat.i(64685);
            HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, paramString.uFq.GVw);
            if (HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this) != null) {
              HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, HoneyPayCardManagerUI.ank(HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this).HdJ));
            }
            HoneyPayCardManagerUI.d(HoneyPayCardManagerUI.this);
            AppMethodBeat.o(64685);
          }
        }).b(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
          {
            AppMethodBeat.i(64696);
            HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, HoneyPayCardManagerUI.b(HoneyPayCardManagerUI.this));
            if (HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this) != null) {
              HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, HoneyPayCardManagerUI.ank(HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this).HdJ));
            }
            HoneyPayCardManagerUI.d(HoneyPayCardManagerUI.this);
            AppMethodBeat.o(64696);
          }
        }).c(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
          {
            AppMethodBeat.i(64695);
            HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, HoneyPayCardManagerUI.b(HoneyPayCardManagerUI.this));
            if (HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this) != null) {
              HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, HoneyPayCardManagerUI.ank(HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this).HdJ));
            }
            HoneyPayCardManagerUI.d(HoneyPayCardManagerUI.this);
            AppMethodBeat.o(64695);
          }
        });
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