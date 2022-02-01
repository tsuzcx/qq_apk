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
import com.tencent.mm.protocal.protobuf.bkc;
import com.tencent.mm.protocal.protobuf.bwk;
import com.tencent.mm.protocal.protobuf.bwt;
import com.tencent.mm.protocal.protobuf.cdp;
import com.tencent.mm.protocal.protobuf.cfe;
import com.tencent.mm.protocal.protobuf.cjm;
import com.tencent.mm.protocal.protobuf.dhy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  private ViewGroup ojl;
  private ImageView ozi;
  private String tCZ;
  private TextView tDA;
  private MMSwitchBtn tDB;
  private LinearLayout tDC;
  private TextView tDD;
  private TextView tDE;
  private TextView tDF;
  private View tDG;
  private View tDH;
  private TextView tDI;
  private a tDJ;
  private List<cdp> tDK;
  private Bankcard tDL;
  private cfe tDM;
  private cfe tDN;
  private long tDO;
  private long tDP;
  private boolean tDQ;
  private String tDR;
  private dhy tDa;
  private TextView tDd;
  private TextView tDf;
  private TextView tDg;
  private TextView tDh;
  private TextView tDi;
  private WalletTextView tDt;
  private ListView tDw;
  private ViewGroup tDx;
  private ViewGroup tDy;
  private ViewGroup tDz;
  
  public HoneyPayCardManagerUI()
  {
    AppMethodBeat.i(64702);
    this.tDK = new ArrayList();
    AppMethodBeat.o(64702);
  }
  
  private void a(bkc parambkc)
  {
    boolean bool = false;
    AppMethodBeat.i(64712);
    Object localObject = e.gs(parambkc.Eph, 6) + getString(2131760283);
    this.tDD.setText(k.b(this, (CharSequence)localObject, this.tDD.getTextSize()));
    a.b.a(this.ozi, parambkc.Eph, 0.06F, false);
    this.tDt.setText(c.vA(parambkc.Eub));
    localObject = this.tDB;
    if (parambkc.BhT != 0) {
      bool = true;
    }
    ((MMSwitchBtn)localObject).setCheck(bool);
    cTa();
    AppMethodBeat.o(64712);
  }
  
  private void a(final bwt parambwt)
  {
    AppMethodBeat.i(64710);
    this.tDy = ((ViewGroup)View.inflate(this, 2131494442, null));
    ((TextView)this.tDy.findViewById(2131300797)).setText(parambwt.title);
    this.tDy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64691);
        e.o(HoneyPayCardManagerUI.this.getContext(), parambwt.url, false);
        AppMethodBeat.o(64691);
      }
    });
    AppMethodBeat.o(64710);
  }
  
  private void a(cjm paramcjm)
  {
    AppMethodBeat.i(64709);
    this.tDa = paramcjm.EOc;
    this.tDK.clear();
    this.tDJ.notifyDataSetChanged();
    int i;
    if (paramcjm.Euc != null)
    {
      setMMTitle(paramcjm.Euc.nVJ);
      this.tDO = paramcjm.Epj;
      this.tDP = paramcjm.Epi;
      if (paramcjm.Euc.EZJ != null)
      {
        this.tDL = aiw(paramcjm.Euc.EZJ.FtD);
        this.tDM = paramcjm.Euc.EZJ;
      }
      a(paramcjm.Euc);
      i = paramcjm.Euc.state;
      ac.i(this.TAG, "detail state: %s", new Object[] { Integer.valueOf(i) });
      ac.d(this.TAG, "state title: %s", new Object[] { paramcjm.Euc.EZM });
      if (bs.isNullOrNil(paramcjm.Euc.EZM)) {
        break label424;
      }
      this.tDd.setText(paramcjm.Euc.EZM);
      this.tDd.setVisibility(0);
      if (bs.isNullOrNil(paramcjm.Euc.EZI)) {
        break label436;
      }
      this.tDF.setText(paramcjm.Euc.EZI);
      this.tDF.setVisibility(0);
      label233:
      if (i != 1) {
        break label448;
      }
      this.tDd.setTextColor(getResources().getColor(2131099777));
      this.tDt.setTextColor(getResources().getColor(2131099734));
      findViewById(2131300801).setVisibility(8);
      this.tDw.removeFooterView(this.tDx);
      this.tDx.setVisibility(8);
      this.tDG.setVisibility(8);
      if (this.tDQ)
      {
        this.tDz = ((ViewGroup)LayoutInflater.from(this).inflate(2131494440, null));
        ((Button)this.tDz.findViewById(2131300802)).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(64690);
            HoneyPayCardManagerUI.this.finish();
            AppMethodBeat.o(64690);
          }
        });
        this.tDw.addFooterView(this.tDz);
        showHomeBtn(false);
        enableBackMenu(false);
        setMMTitle("");
      }
    }
    for (;;)
    {
      this.tDH.setVisibility(8);
      c.b(this, paramcjm.EZC, this.tCZ, 2, this.tDa);
      AppMethodBeat.o(64709);
      return;
      label424:
      this.tDd.setVisibility(8);
      break;
      label436:
      this.tDF.setVisibility(8);
      break label233;
      label448:
      if (i == 2)
      {
        if ((paramcjm.DLp != null) && (!paramcjm.DLp.isEmpty()))
        {
          this.tDK = paramcjm.DLp;
          this.tDJ.notifyDataSetChanged();
          this.tDw.removeFooterView(this.tDx);
          this.tDx.setVisibility(8);
          if (paramcjm.Fxo != null)
          {
            a(paramcjm.Fxo);
            this.tDw.addFooterView(this.tDy);
          }
          findViewById(2131300813).setBackgroundResource(2131100492);
        }
        this.tDA.setVisibility(0);
        this.tDt.setVisibility(0);
        this.tDG.setVisibility(0);
        findViewById(2131300801).setVisibility(8);
      }
      else if (i == 3)
      {
        findViewById(2131300801).setVisibility(0);
        this.tDf.setText(2131760262);
        this.tDg.setText(2131760305);
        this.tDh.setText(c.vB(paramcjm.Euc.EbF));
        this.tDi.setText(c.vB(paramcjm.Euc.nUh));
        this.tDw.removeFooterView(this.tDx);
        this.tDx.setVisibility(8);
        this.tDG.setVisibility(8);
        findViewById(2131300817).setVisibility(8);
      }
      else if (i == 4)
      {
        this.tDA.setVisibility(8);
        findViewById(2131300801).setVisibility(0);
        this.tDf.setText(2131760304);
        this.tDh.setText(c.vB(paramcjm.Euc.EZK));
        findViewById(2131300814).setVisibility(8);
        this.tDw.removeFooterView(this.tDx);
        this.tDx.setVisibility(8);
        this.tDG.setVisibility(8);
        findViewById(2131300817).setVisibility(8);
        findViewById(2131300813).setBackgroundResource(2131101179);
      }
      else
      {
        ac.d(this.TAG, "unknown state: %s", new Object[] { Integer.valueOf(i) });
      }
    }
  }
  
  private static Bankcard aiw(String paramString)
  {
    AppMethodBeat.i(64711);
    Bankcard localBankcard1 = s.ery().azl(paramString);
    if (localBankcard1 == null)
    {
      Bankcard localBankcard2 = s.ery().BAI;
      if ((localBankcard2 != null) && (localBankcard2.field_bindSerial.equals(paramString)))
      {
        AppMethodBeat.o(64711);
        return localBankcard2;
      }
    }
    AppMethodBeat.o(64711);
    return localBankcard1;
  }
  
  private void cSZ()
  {
    AppMethodBeat.i(64708);
    ac.i(this.TAG, "do qry detail");
    l locall = new l(this.tCZ);
    locall.r(this);
    doSceneProgress(locall, true);
    AppMethodBeat.o(64708);
  }
  
  private void cTa()
  {
    AppMethodBeat.i(64713);
    if (this.tDM != null)
    {
      this.tDE.setText(this.tDM.FtB);
      if (!bs.isNullOrNil(this.tDM.FtC)) {
        this.tDE.setTextColor(g.cd(this.tDM.FtC, true));
      }
      while (!bs.isNullOrNil(this.tDM.FtG))
      {
        this.tDI.setText(this.tDM.FtG);
        this.tDI.setVisibility(0);
        AppMethodBeat.o(64713);
        return;
        this.tDE.setTextColor(getResources().getColor(2131100711));
      }
      this.tDI.setVisibility(8);
      AppMethodBeat.o(64713);
      return;
    }
    ac.i(this.TAG, "reset payway view for null");
    this.tDE.setText("");
    this.tDE.setTextColor(getResources().getColor(2131100711));
    this.tDI.setVisibility(8);
    AppMethodBeat.o(64713);
  }
  
  public int getLayoutId()
  {
    return 2131494445;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64704);
    this.ojl = ((ViewGroup)LayoutInflater.from(this).inflate(2131494443, null));
    this.tDB = ((MMSwitchBtn)this.ojl.findViewById(2131300808));
    this.tDC = ((LinearLayout)this.ojl.findViewById(2131300809));
    this.tDE = ((TextView)this.ojl.findViewById(2131300811));
    this.ozi = ((ImageView)this.ojl.findViewById(2131300798));
    this.tDt = ((WalletTextView)this.ojl.findViewById(2131300812));
    this.tDD = ((TextView)this.ojl.findViewById(2131300820));
    this.tDA = ((TextView)this.ojl.findViewById(2131300807));
    this.tDd = ((TextView)this.ojl.findViewById(2131300819));
    this.tDF = ((TextView)this.ojl.findViewById(2131300818));
    this.tDf = ((TextView)this.ojl.findViewById(2131300804));
    this.tDh = ((TextView)this.ojl.findViewById(2131300805));
    this.tDg = ((TextView)this.ojl.findViewById(2131300815));
    this.tDi = ((TextView)this.ojl.findViewById(2131300816));
    this.tDG = this.ojl.findViewById(2131300800);
    this.tDI = ((TextView)this.ojl.findViewById(2131300810));
    this.tDt.setPrefix(ah.fAw());
    this.tDB.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        int i = 1;
        AppMethodBeat.i(64686);
        ac.d(HoneyPayCardManagerUI.this.TAG, "check %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
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
    this.tDC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64687);
        if (HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this) != null)
        {
          ac.d(HoneyPayCardManagerUI.this.TAG, "click pay way: %s", new Object[] { Boolean.valueOf(HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this).FtF) });
          if (HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this).FtF)
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
      public final void dK(View paramAnonymousView)
      {
        AppMethodBeat.i(64688);
        HoneyPayCardManagerUI.g(HoneyPayCardManagerUI.this);
        AppMethodBeat.o(64688);
      }
    }), str.length(), localSpannableStringBuilder.length(), 18);
    this.tDA.setClickable(true);
    this.tDA.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
    this.tDA.setText(localSpannableStringBuilder);
    this.tDx = ((ViewGroup)LayoutInflater.from(this).inflate(2131494441, null));
    this.tDH = findViewById(2131300799);
    this.tDw = ((ListView)findViewById(2131300806));
    this.tDw.addHeaderView(this.ojl);
    this.tDw.addFooterView(this.tDx, null, false);
    this.tDJ = new a((byte)0);
    this.tDw.setAdapter(this.tDJ);
    this.tDw.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(64684);
        paramAnonymousAdapterView = (cdp)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
        if ((paramAnonymousAdapterView != null) && (!bs.isNullOrNil(paramAnonymousAdapterView.url)))
        {
          ac.i(HoneyPayCardManagerUI.this.TAG, "click item: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), Long.valueOf(paramAnonymousAdapterView.Fsp) });
          e.o(HoneyPayCardManagerUI.this.getContext(), paramAnonymousAdapterView.url, false);
          h.wUl.f(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) });
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
        this.tDt.setText(c.vA(l));
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
        cSZ();
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
    this.tCZ = getIntent().getStringExtra("key_card_no");
    this.mScene = getIntent().getIntExtra("key_scene", 0);
    this.tDQ = getIntent().getBooleanExtra("key_is_create", false);
    this.tDR = getIntent().getStringExtra("key_card_type");
    initView();
    ac.d(this.TAG, "cardtype: %s", new Object[] { this.tDR });
    setMMTitle(2131760277);
    if (this.mScene == 1)
    {
      paramBundle = new cjm();
      try
      {
        paramBundle.parseFrom(getIntent().getByteArrayExtra("key_qry_response"));
        a(paramBundle);
        AppMethodBeat.o(64703);
        return;
      }
      catch (IOException paramBundle)
      {
        ac.printErrStackTrace(this.TAG, paramBundle, "", new Object[0]);
        cSZ();
        AppMethodBeat.o(64703);
        return;
      }
    }
    cSZ();
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
          HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, paramString.tCJ);
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
            if (paramString.drx != 1) {}
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
            if (paramString.drx != 1) {}
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
            HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, paramString.tCH.FlN);
            if (HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this) != null) {
              HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, HoneyPayCardManagerUI.aix(HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this).FtD));
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
              HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, HoneyPayCardManagerUI.aix(HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this).FtD));
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
              HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, HoneyPayCardManagerUI.aix(HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this).FtD));
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
    
    private cdp GQ(int paramInt)
    {
      AppMethodBeat.i(64698);
      cdp localcdp = (cdp)HoneyPayCardManagerUI.j(HoneyPayCardManagerUI.this).get(paramInt);
      AppMethodBeat.o(64698);
      return localcdp;
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
        paramView.oqk = ((TextView)localView.findViewById(2131300789));
        paramView.tDY = ((WalletTextView)localView.findViewById(2131300787));
        paramView.tDY.setPrefix(ah.fAw());
        paramView.iCJ = localView.findViewById(2131300788);
        localView.setTag(paramView);
      }
      paramView = GQ(paramInt);
      paramViewGroup = (HoneyPayCardManagerUI.b)localView.getTag();
      paramViewGroup.oqk.setText(paramView.xpb);
      paramViewGroup.tDY.setText(c.vA(paramView.Fsp));
      if (HoneyPayCardManagerUI.j(paramViewGroup.tDS).size() == 1) {
        paramViewGroup.iCJ.setVisibility(8);
      }
      for (;;)
      {
        AppMethodBeat.o(64700);
        return localView;
        paramViewGroup.iCJ.setVisibility(0);
      }
    }
    
    public final boolean isEnabled(int paramInt)
    {
      AppMethodBeat.i(64699);
      if (!bs.isNullOrNil(GQ(paramInt).url))
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
    View iCJ;
    TextView oqk;
    WalletTextView tDY;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI
 * JD-Core Version:    0.7.0.1
 */