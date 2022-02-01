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
import com.tencent.mm.an.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.honey_pay.a.i;
import com.tencent.mm.plugin.honey_pay.a.j;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ao;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.utils.k;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.cjz;
import com.tencent.mm.protocal.protobuf.czn;
import com.tencent.mm.protocal.protobuf.czw;
import com.tencent.mm.protocal.protobuf.dje;
import com.tencent.mm.protocal.protobuf.dkt;
import com.tencent.mm.protocal.protobuf.dra;
import com.tencent.mm.protocal.protobuf.esi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HoneyPayCardManagerUI
  extends HoneyPayBaseUI
{
  private ViewGroup DKA;
  private TextView DKB;
  private MMSwitchBtn DKC;
  private LinearLayout DKD;
  private TextView DKE;
  private TextView DKF;
  private TextView DKG;
  private View DKH;
  private View DKI;
  private TextView DKJ;
  private a DKK;
  private List<dje> DKL;
  private Bankcard DKM;
  private dkt DKN;
  private dkt DKO;
  private long DKP;
  private long DKQ;
  private boolean DKR;
  private String DKS;
  private String DKa;
  private esi DKb;
  private TextView DKe;
  private TextView DKg;
  private TextView DKh;
  private TextView DKi;
  private TextView DKj;
  private WalletTextView DKu;
  private ListView DKx;
  private ViewGroup DKy;
  private ViewGroup DKz;
  private int mScene;
  private ViewGroup tCV;
  private ImageView tXu;
  
  public HoneyPayCardManagerUI()
  {
    AppMethodBeat.i(64702);
    this.DKL = new ArrayList();
    AppMethodBeat.o(64702);
  }
  
  private void a(cjz paramcjz)
  {
    boolean bool = false;
    AppMethodBeat.i(64712);
    Object localObject = g.id(paramcjz.SkU, 6) + getString(a.i.honey_pay_max_quota_monthly);
    this.DKE.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, (CharSequence)localObject, this.DKE.getTextSize()));
    a.b.a(this.tXu, paramcjz.SkU, 0.06F, false);
    this.DKu.setText(c.Od(paramcjz.SqZ));
    localObject = this.DKC;
    if (paramcjz.Oxu != 0) {
      bool = true;
    }
    ((MMSwitchBtn)localObject).setCheck(bool);
    eHQ();
    AppMethodBeat.o(64712);
  }
  
  private void a(final czw paramczw)
  {
    AppMethodBeat.i(64710);
    this.DKz = ((ViewGroup)View.inflate(this, a.g.honey_pay_card_setting_footer_more_layout, null));
    ((TextView)this.DKz.findViewById(a.f.hpcm_title_tv)).setText(paramczw.title);
    this.DKz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64691);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/honey_pay/ui/HoneyPayCardManagerUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        g.p(HoneyPayCardManagerUI.this.getContext(), paramczw.url, false);
        a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayCardManagerUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(64691);
      }
    });
    AppMethodBeat.o(64710);
  }
  
  private void a(dra paramdra)
  {
    AppMethodBeat.i(64709);
    this.DKb = paramdra.TdE;
    this.DKL.clear();
    this.DKK.notifyDataSetChanged();
    int i;
    if (paramdra.Sra != null)
    {
      setMMTitle(paramdra.Sra.tpo);
      this.DKP = paramdra.SkW;
      this.DKQ = paramdra.SkV;
      if (paramdra.Sra.Trz != null)
      {
        this.DKM = aLL(paramdra.Sra.Trz.TRV);
        this.DKN = paramdra.Sra.Trz;
      }
      a(paramdra.Sra);
      i = paramdra.Sra.state;
      Log.i(this.TAG, "detail state: %s", new Object[] { Integer.valueOf(i) });
      Log.d(this.TAG, "state title: %s", new Object[] { paramdra.Sra.TrC });
      if (Util.isNullOrNil(paramdra.Sra.TrC)) {
        break label424;
      }
      this.DKe.setText(paramdra.Sra.TrC);
      this.DKe.setVisibility(0);
      if (Util.isNullOrNil(paramdra.Sra.Try)) {
        break label436;
      }
      this.DKG.setText(paramdra.Sra.Try);
      this.DKG.setVisibility(0);
      label233:
      if (i != 1) {
        break label448;
      }
      this.DKe.setTextColor(getResources().getColor(a.c.Orange));
      this.DKu.setTextColor(getResources().getColor(a.c.FG_1));
      findViewById(a.f.hpcs_date_layout).setVisibility(8);
      this.DKx.removeFooterView(this.DKy);
      this.DKy.setVisibility(8);
      this.DKH.setVisibility(8);
      if (this.DKR)
      {
        this.DKA = ((ViewGroup)LayoutInflater.from(this).inflate(a.g.honey_pay_card_setting_footer_finish_layout, null));
        ((Button)this.DKA.findViewById(a.f.hpcs_finish_btn)).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(64690);
            b localb = new b();
            localb.bn(paramAnonymousView);
            a.c("com/tencent/mm/plugin/honey_pay/ui/HoneyPayCardManagerUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            HoneyPayCardManagerUI.this.finish();
            a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayCardManagerUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(64690);
          }
        });
        this.DKx.addFooterView(this.DKA);
        showHomeBtn(false);
        enableBackMenu(false);
        setMMTitle("");
      }
    }
    for (;;)
    {
      this.DKI.setVisibility(8);
      c.a(this, paramdra.Trs, this.DKa, 2, this.DKb);
      AppMethodBeat.o(64709);
      return;
      label424:
      this.DKe.setVisibility(8);
      break;
      label436:
      this.DKG.setVisibility(8);
      break label233;
      label448:
      if (i == 2)
      {
        if ((paramdra.fbZ != null) && (!paramdra.fbZ.isEmpty()))
        {
          this.DKL = paramdra.fbZ;
          this.DKK.notifyDataSetChanged();
          this.DKx.removeFooterView(this.DKy);
          this.DKy.setVisibility(8);
          if (paramdra.TXz != null)
          {
            a(paramdra.TXz);
            this.DKx.addFooterView(this.DKz);
          }
          findViewById(a.f.hpcs_root_view).setBackgroundResource(a.c.honey_pay_grey_bg_1);
        }
        this.DKB.setVisibility(0);
        this.DKu.setVisibility(0);
        this.DKH.setVisibility(0);
        findViewById(a.f.hpcs_date_layout).setVisibility(8);
      }
      else if (i == 3)
      {
        findViewById(a.f.hpcs_date_layout).setVisibility(0);
        this.DKg.setText(a.i.honey_pay_create_date_title_text);
        this.DKh.setText(a.i.honey_pay_return_date_title_text);
        this.DKi.setText(c.Oe(paramdra.Sra.ChC));
        this.DKj.setText(c.Oe(paramdra.Sra.tnN));
        this.DKx.removeFooterView(this.DKy);
        this.DKy.setVisibility(8);
        this.DKH.setVisibility(8);
        findViewById(a.f.hpcs_setting_layout).setVisibility(8);
      }
      else if (i == 4)
      {
        this.DKB.setVisibility(8);
        findViewById(a.f.hpcs_date_layout).setVisibility(0);
        this.DKg.setText(a.i.honey_pay_release_date_title_text);
        this.DKi.setText(c.Oe(paramdra.Sra.TrA));
        findViewById(a.f.hpcs_second_date_layout).setVisibility(8);
        this.DKx.removeFooterView(this.DKy);
        this.DKy.setVisibility(8);
        this.DKH.setVisibility(8);
        findViewById(a.f.hpcs_setting_layout).setVisibility(8);
        findViewById(a.f.hpcs_root_view).setBackgroundResource(a.c.white);
      }
      else
      {
        Log.d(this.TAG, "unknown state: %s", new Object[] { Integer.valueOf(i) });
      }
    }
  }
  
  private static Bankcard aLL(String paramString)
  {
    AppMethodBeat.i(64711);
    Bankcard localBankcard1 = u.gJo().bgV(paramString);
    if (localBankcard1 == null)
    {
      Bankcard localBankcard2 = u.gJo().OUc;
      if ((localBankcard2 != null) && (localBankcard2.field_bindSerial.equals(paramString)))
      {
        AppMethodBeat.o(64711);
        return localBankcard2;
      }
    }
    AppMethodBeat.o(64711);
    return localBankcard1;
  }
  
  private void eHP()
  {
    AppMethodBeat.i(64708);
    Log.i(this.TAG, "do qry detail");
    com.tencent.mm.plugin.honey_pay.a.l locall = new com.tencent.mm.plugin.honey_pay.a.l(this.DKa);
    locall.u(this);
    doSceneProgress(locall, true);
    AppMethodBeat.o(64708);
  }
  
  private void eHQ()
  {
    AppMethodBeat.i(64713);
    if (this.DKN != null)
    {
      this.DKF.setText(this.DKN.TRU);
      if (!Util.isNullOrNil(this.DKN.word_color)) {
        this.DKF.setTextColor(k.cW(this.DKN.word_color, true));
      }
      while (!Util.isNullOrNil(this.DKN.TRY))
      {
        this.DKJ.setText(this.DKN.TRY);
        this.DKJ.setVisibility(0);
        AppMethodBeat.o(64713);
        return;
        this.DKF.setTextColor(getResources().getColor(a.c.normal_text_color));
      }
      this.DKJ.setVisibility(8);
      AppMethodBeat.o(64713);
      return;
    }
    Log.i(this.TAG, "reset payway view for null");
    this.DKF.setText("");
    this.DKF.setTextColor(getResources().getColor(a.c.normal_text_color));
    this.DKJ.setVisibility(8);
    AppMethodBeat.o(64713);
  }
  
  public int getLayoutId()
  {
    return a.g.honey_pay_card_setting_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64704);
    this.tCV = ((ViewGroup)LayoutInflater.from(this).inflate(a.g.honey_pay_card_setting_header_layout, null));
    this.DKC = ((MMSwitchBtn)this.tCV.findViewById(a.f.hpcs_notify_sb));
    this.DKD = ((LinearLayout)this.tCV.findViewById(a.f.hpcs_payway_layout));
    this.DKF = ((TextView)this.tCV.findViewById(a.f.hpcs_payway_tv));
    this.tXu = ((ImageView)this.tCV.findViewById(a.f.hpcs_avatar_iv));
    this.DKu = ((WalletTextView)this.tCV.findViewById(a.f.hpcs_quota_tv));
    this.DKE = ((TextView)this.tCV.findViewById(a.f.hpcs_user_name_tv));
    this.DKB = ((TextView)this.tCV.findViewById(a.f.hpcs_modify_quota_tv));
    this.DKe = ((TextView)this.tCV.findViewById(a.f.hpcs_state_tv));
    this.DKG = ((TextView)this.tCV.findViewById(a.f.hpcs_state_desc_tv));
    this.DKg = ((TextView)this.tCV.findViewById(a.f.hpcs_first_date_title_tv));
    this.DKi = ((TextView)this.tCV.findViewById(a.f.hpcs_first_date_tv));
    this.DKh = ((TextView)this.tCV.findViewById(a.f.hpcs_second_date_title_tv));
    this.DKj = ((TextView)this.tCV.findViewById(a.f.hpcs_second_date_tv));
    this.DKH = this.tCV.findViewById(a.f.hpcs_bottom_logo_iv);
    this.DKJ = ((TextView)this.tCV.findViewById(a.f.hpcs_payway_tips_tv));
    this.DKu.setPrefix(ah.ijb());
    this.DKC.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        int i = 1;
        AppMethodBeat.i(64686);
        Log.d(HoneyPayCardManagerUI.this.TAG, "check %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
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
    this.DKD.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64687);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/honey_pay/ui/HoneyPayCardManagerUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this) != null)
        {
          Log.d(HoneyPayCardManagerUI.this.TAG, "click pay way: %s", new Object[] { Boolean.valueOf(HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this).TRX) });
          if (!HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this).TRX) {
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
    String str = getString(a.i.honey_pay_max_quota_monthly);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(str);
    localSpannableStringBuilder.append(getString(a.i.honey_pay_max_quota_monthly_modify));
    localSpannableStringBuilder.setSpan(new com.tencent.mm.plugin.wallet_core.ui.r(1, new com.tencent.mm.plugin.wallet_core.ui.r.a()
    {
      public final void ed(View paramAnonymousView)
      {
        AppMethodBeat.i(64688);
        HoneyPayCardManagerUI.g(HoneyPayCardManagerUI.this);
        AppMethodBeat.o(64688);
      }
    }), str.length(), localSpannableStringBuilder.length(), 18);
    this.DKB.setClickable(true);
    this.DKB.setOnTouchListener(new o(this));
    this.DKB.setText(localSpannableStringBuilder);
    this.DKy = ((ViewGroup)LayoutInflater.from(this).inflate(a.g.honey_pay_card_setting_footer_layout, null));
    this.DKI = findViewById(a.f.hpcs_block_view);
    this.DKx = ((ListView)findViewById(a.f.hpcs_lv));
    this.DKx.addHeaderView(this.tCV);
    this.DKx.addFooterView(this.DKy, null, false);
    this.DKK = new a((byte)0);
    this.DKx.setAdapter(this.DKK);
    this.DKx.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(64684);
        b localb = new b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        a.c("com/tencent/mm/plugin/honey_pay/ui/HoneyPayCardManagerUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
        paramAnonymousAdapterView = (dje)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
        if ((paramAnonymousAdapterView != null) && (!Util.isNullOrNil(paramAnonymousAdapterView.url)))
        {
          Log.i(HoneyPayCardManagerUI.this.TAG, "click item: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), Long.valueOf(paramAnonymousAdapterView.TQG) });
          g.p(HoneyPayCardManagerUI.this.getContext(), paramAnonymousAdapterView.url, false);
          h.IzE.a(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) });
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
        this.DKu.setText(c.Od(l));
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
        eHP();
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
    this.DKa = getIntent().getStringExtra("key_card_no");
    this.mScene = getIntent().getIntExtra("key_scene", 0);
    this.DKR = getIntent().getBooleanExtra("key_is_create", false);
    this.DKS = getIntent().getStringExtra("key_card_type");
    initView();
    Log.d(this.TAG, "cardtype: %s", new Object[] { this.DKS });
    setMMTitle(a.i.honey_pay_main_title);
    if (this.mScene == 1)
    {
      paramBundle = new dra();
      try
      {
        paramBundle.parseFrom(getIntent().getByteArrayExtra("key_qry_response"));
        a(paramBundle);
        AppMethodBeat.o(64703);
        return;
      }
      catch (IOException paramBundle)
      {
        Log.printErrStackTrace(this.TAG, paramBundle, "", new Object[0]);
        eHP();
        AppMethodBeat.o(64703);
        return;
      }
    }
    eHP();
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(64706);
    if ((paramq instanceof com.tencent.mm.plugin.honey_pay.a.l))
    {
      paramString = (com.tencent.mm.plugin.honey_pay.a.l)paramq;
      paramString.a(new com.tencent.mm.wallet_core.c.r.a()
      {
        public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(64692);
          HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, paramString.DJL);
          AppMethodBeat.o(64692);
        }
      }).b(new com.tencent.mm.wallet_core.c.r.a()
      {
        public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq) {}
      }).c(new com.tencent.mm.wallet_core.c.r.a()
      {
        public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq) {}
      });
    }
    for (;;)
    {
      AppMethodBeat.o(64706);
      return true;
      if ((paramq instanceof i))
      {
        paramString = (i)paramq;
        paramString.a(new com.tencent.mm.wallet_core.c.r.a()
        {
          public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq) {}
        }).b(new com.tencent.mm.wallet_core.c.r.a()
        {
          public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
          {
            boolean bool = true;
            AppMethodBeat.i(64694);
            paramAnonymousString = HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this);
            if (paramString.cUP != 1) {}
            for (;;)
            {
              paramAnonymousString.setCheck(bool);
              AppMethodBeat.o(64694);
              return;
              bool = false;
            }
          }
        }).c(new com.tencent.mm.wallet_core.c.r.a()
        {
          public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
          {
            boolean bool = true;
            AppMethodBeat.i(64693);
            paramAnonymousString = HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this);
            if (paramString.cUP != 1) {}
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
      else if ((paramq instanceof j))
      {
        paramString = (j)paramq;
        paramString.a(new com.tencent.mm.wallet_core.c.r.a()
        {
          public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
          {
            AppMethodBeat.i(64685);
            HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, paramString.DJJ.THq);
            if (HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this) != null) {
              HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, HoneyPayCardManagerUI.aLM(HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this).TRV));
            }
            HoneyPayCardManagerUI.d(HoneyPayCardManagerUI.this);
            AppMethodBeat.o(64685);
          }
        }).b(new com.tencent.mm.wallet_core.c.r.a()
        {
          public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
          {
            AppMethodBeat.i(64696);
            HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, HoneyPayCardManagerUI.b(HoneyPayCardManagerUI.this));
            if (HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this) != null) {
              HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, HoneyPayCardManagerUI.aLM(HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this).TRV));
            }
            HoneyPayCardManagerUI.d(HoneyPayCardManagerUI.this);
            AppMethodBeat.o(64696);
          }
        }).c(new com.tencent.mm.wallet_core.c.r.a()
        {
          public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
          {
            AppMethodBeat.i(64695);
            HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, HoneyPayCardManagerUI.b(HoneyPayCardManagerUI.this));
            if (HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this) != null) {
              HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, HoneyPayCardManagerUI.aLM(HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this).TRV));
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
    
    private dje UV(int paramInt)
    {
      AppMethodBeat.i(64698);
      dje localdje = (dje)HoneyPayCardManagerUI.j(HoneyPayCardManagerUI.this).get(paramInt);
      AppMethodBeat.o(64698);
      return localdje;
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
        localView = LayoutInflater.from(HoneyPayCardManagerUI.this.getContext()).inflate(a.g.honey_pay_card_setting_item_layout, paramViewGroup, false);
        paramView = new HoneyPayCardManagerUI.b(HoneyPayCardManagerUI.this, (byte)0);
        paramView.tNP = ((TextView)localView.findViewById(a.f.hpci_date_tv));
        paramView.DKZ = ((WalletTextView)localView.findViewById(a.f.hpci_amt_tv));
        paramView.DKZ.setPrefix(ah.ijb());
        paramView.mND = localView.findViewById(a.f.hpci_amt_tv_divider);
        localView.setTag(paramView);
      }
      paramView = UV(paramInt);
      paramViewGroup = (HoneyPayCardManagerUI.b)localView.getTag();
      paramViewGroup.tNP.setText(paramView.Hma);
      paramViewGroup.DKZ.setText(c.Od(paramView.TQG));
      if (HoneyPayCardManagerUI.j(paramViewGroup.DKT).size() == 1) {
        paramViewGroup.mND.setVisibility(8);
      }
      for (;;)
      {
        AppMethodBeat.o(64700);
        return localView;
        paramViewGroup.mND.setVisibility(0);
      }
    }
    
    public final boolean isEnabled(int paramInt)
    {
      AppMethodBeat.i(64699);
      if (!Util.isNullOrNil(UV(paramInt).url))
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
    WalletTextView DKZ;
    View mND;
    TextView tNP;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI
 * JD-Core Version:    0.7.0.1
 */