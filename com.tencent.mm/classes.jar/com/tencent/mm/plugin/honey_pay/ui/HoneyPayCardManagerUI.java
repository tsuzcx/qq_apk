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
import com.tencent.mm.plugin.honey_pay.a.i;
import com.tencent.mm.plugin.honey_pay.a.j;
import com.tencent.mm.plugin.honey_pay.a.l;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.plugin.wallet_core.utils.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.bgk;
import com.tencent.mm.protocal.protobuf.brt;
import com.tencent.mm.protocal.protobuf.bsc;
import com.tencent.mm.protocal.protobuf.byt;
import com.tencent.mm.protocal.protobuf.cag;
import com.tencent.mm.protocal.protobuf.cej;
import com.tencent.mm.protocal.protobuf.dcl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.n.d;
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
  private ViewGroup nGk;
  private ImageView nVN;
  private WalletTextView svE;
  private ListView svH;
  private ViewGroup svI;
  private ViewGroup svJ;
  private ViewGroup svK;
  private TextView svL;
  private MMSwitchBtn svM;
  private LinearLayout svN;
  private TextView svO;
  private TextView svP;
  private TextView svQ;
  private View svR;
  private View svS;
  private TextView svT;
  private a svU;
  private List<byt> svV;
  private Bankcard svW;
  private cag svX;
  private cag svY;
  private long svZ;
  private String svk;
  private dcl svl;
  private TextView svo;
  private TextView svq;
  private TextView svr;
  private TextView svs;
  private TextView svt;
  private long swa;
  private boolean swb;
  private String swc;
  
  public HoneyPayCardManagerUI()
  {
    AppMethodBeat.i(64702);
    this.svV = new ArrayList();
    AppMethodBeat.o(64702);
  }
  
  private void a(bgk parambgk)
  {
    boolean bool = false;
    AppMethodBeat.i(64712);
    Object localObject = e.go(parambgk.CWy, 6) + getString(2131760283);
    this.svO.setText(k.b(this, (CharSequence)localObject, this.svO.getTextSize()));
    a.b.a(this.nVN, parambgk.CWy, 0.06F, false);
    this.svE.setText(c.qX(parambgk.Dbe));
    localObject = this.svM;
    if (parambgk.zPz != 0) {
      bool = true;
    }
    ((MMSwitchBtn)localObject).setCheck(bool);
    cFQ();
    AppMethodBeat.o(64712);
  }
  
  private void a(final bsc parambsc)
  {
    AppMethodBeat.i(64710);
    this.svJ = ((ViewGroup)View.inflate(this, 2131494442, null));
    ((TextView)this.svJ.findViewById(2131300797)).setText(parambsc.title);
    this.svJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64691);
        e.p(HoneyPayCardManagerUI.this.getContext(), parambsc.url, false);
        AppMethodBeat.o(64691);
      }
    });
    AppMethodBeat.o(64710);
  }
  
  private void a(cej paramcej)
  {
    AppMethodBeat.i(64709);
    this.svl = paramcej.DsY;
    this.svV.clear();
    this.svU.notifyDataSetChanged();
    int i;
    if (paramcej.Dbf != null)
    {
      setMMTitle(paramcej.Dbf.nsJ);
      this.svZ = paramcej.CWA;
      this.swa = paramcej.CWz;
      if (paramcej.Dbf.DEo != null)
      {
        this.svW = adE(paramcej.Dbf.DEo.DWL);
        this.svX = paramcej.Dbf.DEo;
      }
      a(paramcej.Dbf);
      i = paramcej.Dbf.state;
      ad.i(this.TAG, "detail state: %s", new Object[] { Integer.valueOf(i) });
      ad.d(this.TAG, "state title: %s", new Object[] { paramcej.Dbf.DEr });
      if (bt.isNullOrNil(paramcej.Dbf.DEr)) {
        break label424;
      }
      this.svo.setText(paramcej.Dbf.DEr);
      this.svo.setVisibility(0);
      if (bt.isNullOrNil(paramcej.Dbf.DEn)) {
        break label436;
      }
      this.svQ.setText(paramcej.Dbf.DEn);
      this.svQ.setVisibility(0);
      label233:
      if (i != 1) {
        break label448;
      }
      this.svo.setTextColor(getResources().getColor(2131099777));
      this.svE.setTextColor(getResources().getColor(2131099734));
      findViewById(2131300801).setVisibility(8);
      this.svH.removeFooterView(this.svI);
      this.svI.setVisibility(8);
      this.svR.setVisibility(8);
      if (this.swb)
      {
        this.svK = ((ViewGroup)LayoutInflater.from(this).inflate(2131494440, null));
        ((Button)this.svK.findViewById(2131300802)).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(64690);
            HoneyPayCardManagerUI.this.finish();
            AppMethodBeat.o(64690);
          }
        });
        this.svH.addFooterView(this.svK);
        showHomeBtn(false);
        enableBackMenu(false);
        setMMTitle("");
      }
    }
    for (;;)
    {
      this.svS.setVisibility(8);
      c.b(this, paramcej.DEh, this.svk, 2, this.svl);
      AppMethodBeat.o(64709);
      return;
      label424:
      this.svo.setVisibility(8);
      break;
      label436:
      this.svQ.setVisibility(8);
      break label233;
      label448:
      if (i == 2)
      {
        if ((paramcej.CsY != null) && (!paramcej.CsY.isEmpty()))
        {
          this.svV = paramcej.CsY;
          this.svU.notifyDataSetChanged();
          this.svH.removeFooterView(this.svI);
          this.svI.setVisibility(8);
          if (paramcej.Eat != null)
          {
            a(paramcej.Eat);
            this.svH.addFooterView(this.svJ);
          }
          findViewById(2131300813).setBackgroundResource(2131100492);
        }
        this.svL.setVisibility(0);
        this.svE.setVisibility(0);
        this.svR.setVisibility(0);
        findViewById(2131300801).setVisibility(8);
      }
      else if (i == 3)
      {
        findViewById(2131300801).setVisibility(0);
        this.svq.setText(2131760262);
        this.svr.setText(2131760305);
        this.svs.setText(c.qY(paramcej.Dbf.CJd));
        this.svt.setText(c.qY(paramcej.Dbf.nrh));
        this.svH.removeFooterView(this.svI);
        this.svI.setVisibility(8);
        this.svR.setVisibility(8);
        findViewById(2131300817).setVisibility(8);
      }
      else if (i == 4)
      {
        this.svL.setVisibility(8);
        findViewById(2131300801).setVisibility(0);
        this.svq.setText(2131760304);
        this.svs.setText(c.qY(paramcej.Dbf.DEp));
        findViewById(2131300814).setVisibility(8);
        this.svH.removeFooterView(this.svI);
        this.svI.setVisibility(8);
        this.svR.setVisibility(8);
        findViewById(2131300817).setVisibility(8);
        findViewById(2131300813).setBackgroundResource(2131101179);
      }
      else
      {
        ad.d(this.TAG, "unknown state: %s", new Object[] { Integer.valueOf(i) });
      }
    }
  }
  
  private static Bankcard adE(String paramString)
  {
    AppMethodBeat.i(64711);
    Bankcard localBankcard1 = s.ecc().atT(paramString);
    if (localBankcard1 == null)
    {
      Bankcard localBankcard2 = s.ecc().Ain;
      if ((localBankcard2 != null) && (localBankcard2.field_bindSerial.equals(paramString)))
      {
        AppMethodBeat.o(64711);
        return localBankcard2;
      }
    }
    AppMethodBeat.o(64711);
    return localBankcard1;
  }
  
  private void cFP()
  {
    AppMethodBeat.i(64708);
    ad.i(this.TAG, "do qry detail");
    l locall = new l(this.svk);
    locall.q(this);
    doSceneProgress(locall, true);
    AppMethodBeat.o(64708);
  }
  
  private void cFQ()
  {
    AppMethodBeat.i(64713);
    if (this.svX != null)
    {
      this.svP.setText(this.svX.DWJ);
      if (!bt.isNullOrNil(this.svX.DWK)) {
        this.svP.setTextColor(g.bW(this.svX.DWK, true));
      }
      while (!bt.isNullOrNil(this.svX.DWO))
      {
        this.svT.setText(this.svX.DWO);
        this.svT.setVisibility(0);
        AppMethodBeat.o(64713);
        return;
        this.svP.setTextColor(getResources().getColor(2131100711));
      }
      this.svT.setVisibility(8);
      AppMethodBeat.o(64713);
      return;
    }
    ad.i(this.TAG, "reset payway view for null");
    this.svP.setText("");
    this.svP.setTextColor(getResources().getColor(2131100711));
    this.svT.setVisibility(8);
    AppMethodBeat.o(64713);
  }
  
  public int getLayoutId()
  {
    return 2131494445;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64704);
    this.nGk = ((ViewGroup)LayoutInflater.from(this).inflate(2131494443, null));
    this.svM = ((MMSwitchBtn)this.nGk.findViewById(2131300808));
    this.svN = ((LinearLayout)this.nGk.findViewById(2131300809));
    this.svP = ((TextView)this.nGk.findViewById(2131300811));
    this.nVN = ((ImageView)this.nGk.findViewById(2131300798));
    this.svE = ((WalletTextView)this.nGk.findViewById(2131300812));
    this.svO = ((TextView)this.nGk.findViewById(2131300820));
    this.svL = ((TextView)this.nGk.findViewById(2131300807));
    this.svo = ((TextView)this.nGk.findViewById(2131300819));
    this.svQ = ((TextView)this.nGk.findViewById(2131300818));
    this.svq = ((TextView)this.nGk.findViewById(2131300804));
    this.svs = ((TextView)this.nGk.findViewById(2131300805));
    this.svr = ((TextView)this.nGk.findViewById(2131300815));
    this.svt = ((TextView)this.nGk.findViewById(2131300816));
    this.svR = this.nGk.findViewById(2131300800);
    this.svT = ((TextView)this.nGk.findViewById(2131300810));
    this.svE.setPrefix(ah.fkg());
    this.svM.setSwitchListener(new MMSwitchBtn.a()
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
    this.svN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64687);
        if (HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this) != null)
        {
          ad.d(HoneyPayCardManagerUI.this.TAG, "click pay way: %s", new Object[] { Boolean.valueOf(HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this).DWN) });
          if (HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this).DWN)
          {
            HoneyPayCardManagerUI.e(HoneyPayCardManagerUI.this);
            AppMethodBeat.o(64687);
            return;
          }
          HoneyPayCardManagerUI.f(HoneyPayCardManagerUI.this);
        }
        AppMethodBeat.o(64687);
      }
    });
    String str = getString(2131760283);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(str);
    localSpannableStringBuilder.append(getString(2131760285));
    localSpannableStringBuilder.setSpan(new q(1, new q.a()
    {
      public final void dI(View paramAnonymousView)
      {
        AppMethodBeat.i(64688);
        HoneyPayCardManagerUI.g(HoneyPayCardManagerUI.this);
        AppMethodBeat.o(64688);
      }
    }), str.length(), localSpannableStringBuilder.length(), 18);
    this.svL.setClickable(true);
    this.svL.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
    this.svL.setText(localSpannableStringBuilder);
    this.svI = ((ViewGroup)LayoutInflater.from(this).inflate(2131494441, null));
    this.svS = findViewById(2131300799);
    this.svH = ((ListView)findViewById(2131300806));
    this.svH.addHeaderView(this.nGk);
    this.svH.addFooterView(this.svI, null, false);
    this.svU = new a((byte)0);
    this.svH.setAdapter(this.svU);
    this.svH.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(64684);
        paramAnonymousAdapterView = (byt)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
        if ((paramAnonymousAdapterView != null) && (!bt.isNullOrNil(paramAnonymousAdapterView.url)))
        {
          ad.i(HoneyPayCardManagerUI.this.TAG, "click item: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), Long.valueOf(paramAnonymousAdapterView.DVB) });
          e.p(HoneyPayCardManagerUI.this.getContext(), paramAnonymousAdapterView.url, false);
          h.vKh.f(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) });
        }
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
        this.svE.setText(c.qX(l));
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
        cFP();
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
    this.svk = getIntent().getStringExtra("key_card_no");
    this.mScene = getIntent().getIntExtra("key_scene", 0);
    this.swb = getIntent().getBooleanExtra("key_is_create", false);
    this.swc = getIntent().getStringExtra("key_card_type");
    initView();
    ad.d(this.TAG, "cardtype: %s", new Object[] { this.swc });
    setMMTitle(2131760277);
    if (this.mScene == 1)
    {
      paramBundle = new cej();
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
        cFP();
        AppMethodBeat.o(64703);
        return;
      }
    }
    cFP();
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
          HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, paramString.suU);
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
            if (paramString.dtM != 1) {}
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
            if (paramString.dtM != 1) {}
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
            HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, paramString.suS.DPw);
            if (HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this) != null) {
              HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, HoneyPayCardManagerUI.adF(HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this).DWL));
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
              HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, HoneyPayCardManagerUI.adF(HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this).DWL));
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
              HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, HoneyPayCardManagerUI.adF(HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this).DWL));
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
    
    private byt EU(int paramInt)
    {
      AppMethodBeat.i(64698);
      byt localbyt = (byt)HoneyPayCardManagerUI.j(HoneyPayCardManagerUI.this).get(paramInt);
      AppMethodBeat.o(64698);
      return localbyt;
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
        paramView.nNi = ((TextView)localView.findViewById(2131300789));
        paramView.swj = ((WalletTextView)localView.findViewById(2131300787));
        paramView.swj.setPrefix(ah.fkg());
        paramView.icB = localView.findViewById(2131300788);
        localView.setTag(paramView);
      }
      paramView = EU(paramInt);
      paramViewGroup = (HoneyPayCardManagerUI.b)localView.getTag();
      paramViewGroup.nNi.setText(paramView.wdN);
      paramViewGroup.swj.setText(c.qX(paramView.DVB));
      if (HoneyPayCardManagerUI.j(paramViewGroup.swd).size() == 1) {
        paramViewGroup.icB.setVisibility(8);
      }
      for (;;)
      {
        AppMethodBeat.o(64700);
        return localView;
        paramViewGroup.icB.setVisibility(0);
      }
    }
    
    public final boolean isEnabled(int paramInt)
    {
      AppMethodBeat.i(64699);
      if (!bt.isNullOrNil(EU(paramInt).url))
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
    View icB;
    TextView nNi;
    WalletTextView swj;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI
 * JD-Core Version:    0.7.0.1
 */