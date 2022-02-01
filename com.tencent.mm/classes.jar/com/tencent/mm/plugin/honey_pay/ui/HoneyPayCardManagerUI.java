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
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
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
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.bpe;
import com.tencent.mm.protocal.protobuf.cbu;
import com.tencent.mm.protocal.protobuf.ccd;
import com.tencent.mm.protocal.protobuf.cji;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.protocal.protobuf.cpg;
import com.tencent.mm.protocal.protobuf.dok;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HoneyPayCardManagerUI
  extends HoneyPayBaseUI
{
  private int mScene;
  private ViewGroup oTj;
  private ImageView pjj;
  private TextView uRB;
  private TextView uRC;
  private TextView uRD;
  private TextView uRE;
  private WalletTextView uRP;
  private ListView uRS;
  private ViewGroup uRT;
  private ViewGroup uRU;
  private ViewGroup uRV;
  private TextView uRW;
  private MMSwitchBtn uRX;
  private LinearLayout uRY;
  private TextView uRZ;
  private String uRv;
  private dok uRw;
  private TextView uRz;
  private TextView uSa;
  private TextView uSb;
  private View uSc;
  private View uSd;
  private TextView uSe;
  private a uSf;
  private List<cji> uSg;
  private Bankcard uSh;
  private ckx uSi;
  private ckx uSj;
  private long uSk;
  private long uSl;
  private boolean uSm;
  private String uSn;
  
  public HoneyPayCardManagerUI()
  {
    AppMethodBeat.i(64702);
    this.uSg = new ArrayList();
    AppMethodBeat.o(64702);
  }
  
  private void a(bpe parambpe)
  {
    boolean bool = false;
    AppMethodBeat.i(64712);
    Object localObject = f.gY(parambpe.GoS, 6) + getString(2131760283);
    this.uRZ.setText(k.b(this, (CharSequence)localObject, this.uRZ.getTextSize()));
    a.b.a(this.pjj, parambpe.GoS, 0.06F, false);
    this.uRP.setText(c.ye(parambpe.Gub));
    localObject = this.uRX;
    if (parambpe.CZN != 0) {
      bool = true;
    }
    ((MMSwitchBtn)localObject).setCheck(bool);
    deZ();
    AppMethodBeat.o(64712);
  }
  
  private void a(final ccd paramccd)
  {
    AppMethodBeat.i(64710);
    this.uRU = ((ViewGroup)View.inflate(this, 2131494442, null));
    ((TextView)this.uRU.findViewById(2131300797)).setText(paramccd.title);
    this.uRU.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64691);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPayCardManagerUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        f.p(HoneyPayCardManagerUI.this.getContext(), paramccd.url, false);
        a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayCardManagerUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(64691);
      }
    });
    AppMethodBeat.o(64710);
  }
  
  private void a(cpg paramcpg)
  {
    AppMethodBeat.i(64709);
    this.uRw = paramcpg.GQG;
    this.uSg.clear();
    this.uSf.notifyDataSetChanged();
    int i;
    if (paramcpg.Guc != null)
    {
      setMMTitle(paramcpg.Guc.oFF);
      this.uSk = paramcpg.GoU;
      this.uSl = paramcpg.GoT;
      if (paramcpg.Guc.HcJ != null)
      {
        this.uSh = aol(paramcpg.Guc.HcJ.Hxj);
        this.uSi = paramcpg.Guc.HcJ;
      }
      a(paramcpg.Guc);
      i = paramcpg.Guc.state;
      ae.i(this.TAG, "detail state: %s", new Object[] { Integer.valueOf(i) });
      ae.d(this.TAG, "state title: %s", new Object[] { paramcpg.Guc.HcM });
      if (bu.isNullOrNil(paramcpg.Guc.HcM)) {
        break label424;
      }
      this.uRz.setText(paramcpg.Guc.HcM);
      this.uRz.setVisibility(0);
      if (bu.isNullOrNil(paramcpg.Guc.HcI)) {
        break label436;
      }
      this.uSb.setText(paramcpg.Guc.HcI);
      this.uSb.setVisibility(0);
      label233:
      if (i != 1) {
        break label448;
      }
      this.uRz.setTextColor(getResources().getColor(2131099777));
      this.uRP.setTextColor(getResources().getColor(2131099734));
      findViewById(2131300801).setVisibility(8);
      this.uRS.removeFooterView(this.uRT);
      this.uRT.setVisibility(8);
      this.uSc.setVisibility(8);
      if (this.uSm)
      {
        this.uRV = ((ViewGroup)LayoutInflater.from(this).inflate(2131494440, null));
        ((Button)this.uRV.findViewById(2131300802)).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(64690);
            b localb = new b();
            localb.bd(paramAnonymousView);
            a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPayCardManagerUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            HoneyPayCardManagerUI.this.finish();
            a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayCardManagerUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(64690);
          }
        });
        this.uRS.addFooterView(this.uRV);
        showHomeBtn(false);
        enableBackMenu(false);
        setMMTitle("");
      }
    }
    for (;;)
    {
      this.uSd.setVisibility(8);
      c.b(this, paramcpg.HcC, this.uRv, 2, this.uRw);
      AppMethodBeat.o(64709);
      return;
      label424:
      this.uRz.setVisibility(8);
      break;
      label436:
      this.uSb.setVisibility(8);
      break label233;
      label448:
      if (i == 2)
      {
        if ((paramcpg.cTY != null) && (!paramcpg.cTY.isEmpty()))
        {
          this.uSg = paramcpg.cTY;
          this.uSf.notifyDataSetChanged();
          this.uRS.removeFooterView(this.uRT);
          this.uRT.setVisibility(8);
          if (paramcpg.HAT != null)
          {
            a(paramcpg.HAT);
            this.uRS.addFooterView(this.uRU);
          }
          findViewById(2131300813).setBackgroundResource(2131100492);
        }
        this.uRW.setVisibility(0);
        this.uRP.setVisibility(0);
        this.uSc.setVisibility(0);
        findViewById(2131300801).setVisibility(8);
      }
      else if (i == 3)
      {
        findViewById(2131300801).setVisibility(0);
        this.uRB.setText(2131760262);
        this.uRC.setText(2131760305);
        this.uRD.setText(c.yf(paramcpg.Guc.FZN));
        this.uRE.setText(c.yf(paramcpg.Guc.oEe));
        this.uRS.removeFooterView(this.uRT);
        this.uRT.setVisibility(8);
        this.uSc.setVisibility(8);
        findViewById(2131300817).setVisibility(8);
      }
      else if (i == 4)
      {
        this.uRW.setVisibility(8);
        findViewById(2131300801).setVisibility(0);
        this.uRB.setText(2131760304);
        this.uRD.setText(c.yf(paramcpg.Guc.HcK));
        findViewById(2131300814).setVisibility(8);
        this.uRS.removeFooterView(this.uRT);
        this.uRT.setVisibility(8);
        this.uSc.setVisibility(8);
        findViewById(2131300817).setVisibility(8);
        findViewById(2131300813).setBackgroundResource(2131101179);
      }
      else
      {
        ae.d(this.TAG, "unknown state: %s", new Object[] { Integer.valueOf(i) });
      }
    }
  }
  
  private static Bankcard aol(String paramString)
  {
    AppMethodBeat.i(64711);
    Bankcard localBankcard1 = t.eJf().aFN(paramString);
    if (localBankcard1 == null)
    {
      Bankcard localBankcard2 = t.eJf().DsE;
      if ((localBankcard2 != null) && (localBankcard2.field_bindSerial.equals(paramString)))
      {
        AppMethodBeat.o(64711);
        return localBankcard2;
      }
    }
    AppMethodBeat.o(64711);
    return localBankcard1;
  }
  
  private void deY()
  {
    AppMethodBeat.i(64708);
    ae.i(this.TAG, "do qry detail");
    l locall = new l(this.uRv);
    locall.t(this);
    doSceneProgress(locall, true);
    AppMethodBeat.o(64708);
  }
  
  private void deZ()
  {
    AppMethodBeat.i(64713);
    if (this.uSi != null)
    {
      this.uSa.setText(this.uSi.Hxh);
      if (!bu.isNullOrNil(this.uSi.Hxi)) {
        this.uSa.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cp(this.uSi.Hxi, true));
      }
      while (!bu.isNullOrNil(this.uSi.Hxm))
      {
        this.uSe.setText(this.uSi.Hxm);
        this.uSe.setVisibility(0);
        AppMethodBeat.o(64713);
        return;
        this.uSa.setTextColor(getResources().getColor(2131100711));
      }
      this.uSe.setVisibility(8);
      AppMethodBeat.o(64713);
      return;
    }
    ae.i(this.TAG, "reset payway view for null");
    this.uSa.setText("");
    this.uSa.setTextColor(getResources().getColor(2131100711));
    this.uSe.setVisibility(8);
    AppMethodBeat.o(64713);
  }
  
  public int getLayoutId()
  {
    return 2131494445;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64704);
    this.oTj = ((ViewGroup)LayoutInflater.from(this).inflate(2131494443, null));
    this.uRX = ((MMSwitchBtn)this.oTj.findViewById(2131300808));
    this.uRY = ((LinearLayout)this.oTj.findViewById(2131300809));
    this.uSa = ((TextView)this.oTj.findViewById(2131300811));
    this.pjj = ((ImageView)this.oTj.findViewById(2131300798));
    this.uRP = ((WalletTextView)this.oTj.findViewById(2131300812));
    this.uRZ = ((TextView)this.oTj.findViewById(2131300820));
    this.uRW = ((TextView)this.oTj.findViewById(2131300807));
    this.uRz = ((TextView)this.oTj.findViewById(2131300819));
    this.uSb = ((TextView)this.oTj.findViewById(2131300818));
    this.uRB = ((TextView)this.oTj.findViewById(2131300804));
    this.uRD = ((TextView)this.oTj.findViewById(2131300805));
    this.uRC = ((TextView)this.oTj.findViewById(2131300815));
    this.uRE = ((TextView)this.oTj.findViewById(2131300816));
    this.uSc = this.oTj.findViewById(2131300800);
    this.uSe = ((TextView)this.oTj.findViewById(2131300810));
    this.uRP.setPrefix(ah.fWc());
    this.uRX.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        int i = 1;
        AppMethodBeat.i(64686);
        ae.d(HoneyPayCardManagerUI.this.TAG, "check %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
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
    this.uRY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64687);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPayCardManagerUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this) != null)
        {
          ae.d(HoneyPayCardManagerUI.this.TAG, "click pay way: %s", new Object[] { Boolean.valueOf(HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this).Hxl) });
          if (!HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this).Hxl) {
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
    localSpannableStringBuilder.setSpan(new q(1, new q.a()
    {
      public final void dN(View paramAnonymousView)
      {
        AppMethodBeat.i(64688);
        HoneyPayCardManagerUI.g(HoneyPayCardManagerUI.this);
        AppMethodBeat.o(64688);
      }
    }), str.length(), localSpannableStringBuilder.length(), 18);
    this.uRW.setClickable(true);
    this.uRW.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
    this.uRW.setText(localSpannableStringBuilder);
    this.uRT = ((ViewGroup)LayoutInflater.from(this).inflate(2131494441, null));
    this.uSd = findViewById(2131300799);
    this.uRS = ((ListView)findViewById(2131300806));
    this.uRS.addHeaderView(this.oTj);
    this.uRS.addFooterView(this.uRT, null, false);
    this.uSf = new a((byte)0);
    this.uRS.setAdapter(this.uSf);
    this.uRS.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(64684);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPayCardManagerUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
        paramAnonymousAdapterView = (cji)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
        if ((paramAnonymousAdapterView != null) && (!bu.isNullOrNil(paramAnonymousAdapterView.url)))
        {
          ae.i(HoneyPayCardManagerUI.this.TAG, "click item: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), Long.valueOf(paramAnonymousAdapterView.HvV) });
          f.p(HoneyPayCardManagerUI.this.getContext(), paramAnonymousAdapterView.url, false);
          com.tencent.mm.plugin.report.service.g.yxI.f(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) });
        }
        a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayCardManagerUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(64684);
      }
    });
    AppMethodBeat.o(64704);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(64707);
    if (paramInt1 == 1) {
      if ((paramInt2 == -1) && (paramIntent.getBooleanExtra("key_modify_create_line_succ", false)))
      {
        long l = paramIntent.getLongExtra("key_credit_line", 0L);
        this.uRP.setText(c.ye(l));
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
        deY();
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
    this.uRv = getIntent().getStringExtra("key_card_no");
    this.mScene = getIntent().getIntExtra("key_scene", 0);
    this.uSm = getIntent().getBooleanExtra("key_is_create", false);
    this.uSn = getIntent().getStringExtra("key_card_type");
    initView();
    ae.d(this.TAG, "cardtype: %s", new Object[] { this.uSn });
    setMMTitle(2131760277);
    if (this.mScene == 1)
    {
      paramBundle = new cpg();
      try
      {
        paramBundle.parseFrom(getIntent().getByteArrayExtra("key_qry_response"));
        a(paramBundle);
        AppMethodBeat.o(64703);
        return;
      }
      catch (IOException paramBundle)
      {
        ae.printErrStackTrace(this.TAG, paramBundle, "", new Object[0]);
        deY();
        AppMethodBeat.o(64703);
        return;
      }
    }
    deY();
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(64706);
    if ((paramn instanceof l))
    {
      paramString = (l)paramn;
      paramString.a(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
        {
          AppMethodBeat.i(64692);
          HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, paramString.uRf);
          AppMethodBeat.o(64692);
        }
      }).b(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn) {}
      }).c(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn) {}
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
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn) {}
        }).b(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
          {
            boolean bool = true;
            AppMethodBeat.i(64694);
            paramAnonymousString = HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this);
            if (paramString.dEu != 1) {}
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
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
          {
            boolean bool = true;
            AppMethodBeat.i(64693);
            paramAnonymousString = HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this);
            if (paramString.dEu != 1) {}
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
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
          {
            AppMethodBeat.i(64685);
            HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, paramString.uRd.HoX);
            if (HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this) != null) {
              HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, HoneyPayCardManagerUI.aom(HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this).Hxj));
            }
            HoneyPayCardManagerUI.d(HoneyPayCardManagerUI.this);
            AppMethodBeat.o(64685);
          }
        }).b(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
          {
            AppMethodBeat.i(64696);
            HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, HoneyPayCardManagerUI.b(HoneyPayCardManagerUI.this));
            if (HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this) != null) {
              HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, HoneyPayCardManagerUI.aom(HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this).Hxj));
            }
            HoneyPayCardManagerUI.d(HoneyPayCardManagerUI.this);
            AppMethodBeat.o(64696);
          }
        }).c(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
          {
            AppMethodBeat.i(64695);
            HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, HoneyPayCardManagerUI.b(HoneyPayCardManagerUI.this));
            if (HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this) != null) {
              HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, HoneyPayCardManagerUI.aom(HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this).Hxj));
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
  
  final class a
    extends BaseAdapter
  {
    private a() {}
    
    private cji IK(int paramInt)
    {
      AppMethodBeat.i(64698);
      cji localcji = (cji)HoneyPayCardManagerUI.j(HoneyPayCardManagerUI.this).get(paramInt);
      AppMethodBeat.o(64698);
      return localcji;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(64697);
      int i = HoneyPayCardManagerUI.j(HoneyPayCardManagerUI.this).size();
      AppMethodBeat.o(64697);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(64700);
      View localView = paramView;
      if (paramView == null)
      {
        localView = LayoutInflater.from(HoneyPayCardManagerUI.this.getContext()).inflate(2131494444, paramViewGroup, false);
        paramView = new HoneyPayCardManagerUI.b(HoneyPayCardManagerUI.this, (byte)0);
        paramView.pah = ((TextView)localView.findViewById(2131300789));
        paramView.uSu = ((WalletTextView)localView.findViewById(2131300787));
        paramView.uSu.setPrefix(ah.fWc());
        paramView.iYM = localView.findViewById(2131300788);
        localView.setTag(paramView);
      }
      paramView = IK(paramInt);
      paramViewGroup = (HoneyPayCardManagerUI.b)localView.getTag();
      paramViewGroup.pah.setText(paramView.xrF);
      paramViewGroup.uSu.setText(c.ye(paramView.HvV));
      if (HoneyPayCardManagerUI.j(paramViewGroup.uSo).size() == 1) {
        paramViewGroup.iYM.setVisibility(8);
      }
      for (;;)
      {
        AppMethodBeat.o(64700);
        return localView;
        paramViewGroup.iYM.setVisibility(0);
      }
    }
    
    public final boolean isEnabled(int paramInt)
    {
      AppMethodBeat.i(64699);
      if (!bu.isNullOrNil(IK(paramInt).url))
      {
        AppMethodBeat.o(64699);
        return true;
      }
      AppMethodBeat.o(64699);
      return false;
    }
  }
  
  final class b
  {
    View iYM;
    TextView pah;
    WalletTextView uSu;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI
 * JD-Core Version:    0.7.0.1
 */