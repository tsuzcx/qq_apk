package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
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
import com.tencent.mm.plugin.honey_pay.a.j;
import com.tencent.mm.plugin.honey_pay.a.l;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.an.a;
import com.tencent.mm.plugin.wallet_core.model.an.b;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.ui.s.a;
import com.tencent.mm.plugin.wallet_core.utils.n;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.dag;
import com.tencent.mm.protocal.protobuf.dqu;
import com.tencent.mm.protocal.protobuf.drd;
import com.tencent.mm.protocal.protobuf.ebo;
import com.tencent.mm.protocal.protobuf.edd;
import com.tencent.mm.protocal.protobuf.ejv;
import com.tencent.mm.protocal.protobuf.fnr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.wallet_core.model.ai;
import com.tencent.mm.wallet_core.model.r;
import com.tencent.mm.wallet_core.model.r.a;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.WcPayBannerView;
import com.tencent.mm.wallet_core.ui.k;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import kotlin.ah;
import org.json.JSONObject;

public class HoneyPayCardManagerUI
  extends HoneyPayBaseUI
{
  private String JAW;
  private fnr JAX;
  private TextView JBA;
  private TextView JBB;
  private TextView JBC;
  private View JBD;
  private View JBE;
  private TextView JBF;
  private b JBG;
  private List<ebo> JBH;
  private Bankcard JBI;
  private edd JBJ;
  private edd JBK;
  private String JBL;
  private String JBM;
  private long JBN;
  private long JBO;
  private boolean JBP;
  private String JBQ;
  private an.a JBR;
  private TextView JBa;
  private TextView JBc;
  private TextView JBd;
  private TextView JBe;
  private TextView JBf;
  private WalletTextView JBq;
  private ListView JBt;
  private ViewGroup JBu;
  private ViewGroup JBv;
  private ViewGroup JBw;
  private TextView JBx;
  private MMSwitchBtn JBy;
  private LinearLayout JBz;
  private int mScene;
  private WcPayBannerView pLM;
  private ViewGroup wGY;
  private ImageView xaN;
  
  public HoneyPayCardManagerUI()
  {
    AppMethodBeat.i(64702);
    this.JBH = new ArrayList();
    this.JBL = "";
    this.JBM = "";
    AppMethodBeat.o(64702);
  }
  
  private void a(dag paramdag)
  {
    boolean bool = false;
    AppMethodBeat.i(64712);
    Object localObject = com.tencent.mm.wallet_core.ui.i.jp(paramdag.Zje, 6) + getString(a.i.honey_pay_max_quota_monthly);
    this.JBA.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, (CharSequence)localObject, this.JBA.getTextSize()));
    a.b.a(this.xaN, paramdag.Zje, 0.06F, false);
    this.JBq.setText(c.rY(paramdag.Zqa));
    localObject = this.JBy;
    if (paramdag.VmF != 0) {
      bool = true;
    }
    ((MMSwitchBtn)localObject).setCheck(bool);
    fPB();
    AppMethodBeat.o(64712);
  }
  
  private void a(final drd paramdrd)
  {
    AppMethodBeat.i(64710);
    this.JBv = ((ViewGroup)View.inflate(this, a.g.honey_pay_card_setting_footer_more_layout, null));
    ((TextView)this.JBv.findViewById(a.f.hpcm_title_tv)).setText(paramdrd.title);
    this.JBv.setOnClickListener(new k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(267328);
        com.tencent.mm.wallet_core.ui.i.p(HoneyPayCardManagerUI.this.getContext(), paramdrd.url, false);
        AppMethodBeat.o(267328);
      }
    });
    AppMethodBeat.o(64710);
  }
  
  private void a(ejv paramejv)
  {
    AppMethodBeat.i(64709);
    this.JBL = paramejv.abor;
    this.JBM = paramejv.aaWY;
    this.JAX = paramejv.aaqT;
    this.JBH.clear();
    this.JBG.notifyDataSetChanged();
    int i;
    if (paramejv.Zqc != null)
    {
      setMMTitle(paramejv.Zqc.wtN);
      this.JBN = paramejv.Zjg;
      this.JBO = paramejv.Zjf;
      if (paramejv.Zqc.aaFL != null)
      {
        this.JBI = aIF(paramejv.Zqc.aaFL.abit);
        this.JBJ = paramejv.Zqc.aaFL;
      }
      a(paramejv.Zqc);
      this.pLM.setBannerData(paramejv.ign);
      i = paramejv.Zqc.state;
      Log.i(this.TAG, "detail state: %s", new Object[] { Integer.valueOf(i) });
      Log.d(this.TAG, "state title: %s", new Object[] { paramejv.Zqc.aaFO });
      if (Util.isNullOrNil(paramejv.Zqc.aaFO)) {
        break label462;
      }
      this.JBa.setText(paramejv.Zqc.aaFO);
      this.JBa.setVisibility(0);
      if (Util.isNullOrNil(paramejv.Zqc.aaFK)) {
        break label474;
      }
      this.JBC.setText(paramejv.Zqc.aaFK);
      this.JBC.setVisibility(0);
      label260:
      if (i != 1) {
        break label486;
      }
      this.JBa.setTextColor(getResources().getColor(a.c.Orange));
      this.JBq.setTextColor(getResources().getColor(a.c.FG_1));
      findViewById(a.f.hpcs_date_layout).setVisibility(8);
      this.JBt.removeFooterView(this.JBu);
      this.JBu.setVisibility(8);
      this.JBD.setVisibility(8);
      if (this.JBP)
      {
        this.JBw = ((ViewGroup)LayoutInflater.from(this).inflate(a.g.honey_pay_card_setting_footer_finish_layout, null));
        ((Button)this.JBw.findViewById(a.f.hpcs_finish_btn)).setOnClickListener(new k()
        {
          public final void dr(View paramAnonymousView)
          {
            AppMethodBeat.i(267359);
            HoneyPayCardManagerUI.this.finish();
            AppMethodBeat.o(267359);
          }
        });
        this.JBt.addFooterView(this.JBw);
        showHomeBtn(false);
        enableBackMenu(false);
        setMMTitle("");
      }
    }
    for (;;)
    {
      this.JBE.setVisibility(8);
      c.a(this, paramejv.aaFC, this.JAW, 2, this.JAX);
      ((HoneyPayCardManagerUI.a)component(HoneyPayCardManagerUI.a.class)).fPC();
      AppMethodBeat.o(64709);
      return;
      label462:
      this.JBa.setVisibility(8);
      break;
      label474:
      this.JBC.setVisibility(8);
      break label260;
      label486:
      if (i == 2)
      {
        if ((paramejv.hfF != null) && (!paramejv.hfF.isEmpty()))
        {
          this.JBH = paramejv.hfF;
          this.JBG.notifyDataSetChanged();
          this.JBt.removeFooterView(this.JBu);
          this.JBu.setVisibility(8);
          if (paramejv.aboq != null)
          {
            a(paramejv.aboq);
            this.JBt.addFooterView(this.JBv);
          }
          findViewById(a.f.hpcs_root_view).setBackgroundResource(a.c.honey_pay_grey_bg_1);
        }
        this.JBx.setVisibility(0);
        this.JBq.setVisibility(0);
        this.JBD.setVisibility(0);
        findViewById(a.f.hpcs_date_layout).setVisibility(8);
      }
      else if (i == 3)
      {
        findViewById(a.f.hpcs_date_layout).setVisibility(0);
        this.JBc.setText(a.i.honey_pay_create_date_title_text);
        this.JBd.setText(a.i.honey_pay_return_date_title_text);
        this.JBe.setText(c.rZ(paramejv.Zqc.HTK));
        this.JBf.setText(c.rZ(paramejv.Zqc.wso));
        this.JBt.removeFooterView(this.JBu);
        this.JBu.setVisibility(8);
        this.JBD.setVisibility(8);
        findViewById(a.f.hpcs_setting_layout).setVisibility(8);
      }
      else if (i == 4)
      {
        this.JBx.setVisibility(8);
        findViewById(a.f.hpcs_date_layout).setVisibility(0);
        this.JBc.setText(a.i.honey_pay_release_date_title_text);
        this.JBe.setText(c.rZ(paramejv.Zqc.aaFM));
        findViewById(a.f.hpcs_second_date_layout).setVisibility(8);
        this.JBt.removeFooterView(this.JBu);
        this.JBu.setVisibility(8);
        this.JBD.setVisibility(8);
        findViewById(a.f.hpcs_setting_layout).setVisibility(8);
        findViewById(a.f.hpcs_root_view).setBackgroundResource(a.c.white);
      }
      else
      {
        Log.d(this.TAG, "unknown state: %s", new Object[] { Integer.valueOf(i) });
      }
    }
  }
  
  private static Bankcard aIF(String paramString)
  {
    AppMethodBeat.i(64711);
    Bankcard localBankcard1 = u.iiC().bgD(paramString);
    if (localBankcard1 == null)
    {
      Bankcard localBankcard2 = u.iiC().VKi;
      if ((localBankcard2 != null) && (localBankcard2.field_bindSerial.equals(paramString)))
      {
        AppMethodBeat.o(64711);
        return localBankcard2;
      }
    }
    AppMethodBeat.o(64711);
    return localBankcard1;
  }
  
  private void fPA()
  {
    AppMethodBeat.i(64708);
    Log.i(this.TAG, "do qry detail");
    l locall = new l(this.JAW);
    locall.r(this);
    doSceneProgress(locall, true);
    AppMethodBeat.o(64708);
  }
  
  private void fPB()
  {
    AppMethodBeat.i(64713);
    if (this.JBJ != null)
    {
      this.JBB.setText(this.JBJ.ZZR);
      if (!Util.isNullOrNil(this.JBJ.word_color)) {
        this.JBB.setTextColor(n.dE(this.JBJ.word_color, true));
      }
      while (!Util.isNullOrNil(this.JBJ.abiw))
      {
        this.JBF.setText(this.JBJ.abiw);
        this.JBF.setVisibility(0);
        AppMethodBeat.o(64713);
        return;
        this.JBB.setTextColor(getResources().getColor(a.c.normal_text_color));
      }
      this.JBF.setVisibility(8);
      AppMethodBeat.o(64713);
      return;
    }
    Log.i(this.TAG, "reset payway view for null");
    this.JBB.setText("");
    this.JBB.setTextColor(getResources().getColor(a.c.normal_text_color));
    this.JBF.setVisibility(8);
    AppMethodBeat.o(64713);
  }
  
  public int getLayoutId()
  {
    return a.g.honey_pay_card_setting_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64704);
    this.wGY = ((ViewGroup)LayoutInflater.from(this).inflate(a.g.honey_pay_card_setting_header_layout, null));
    this.JBy = ((MMSwitchBtn)this.wGY.findViewById(a.f.hpcs_notify_sb));
    this.JBz = ((LinearLayout)this.wGY.findViewById(a.f.hpcs_payway_layout));
    this.JBB = ((TextView)this.wGY.findViewById(a.f.hpcs_payway_tv));
    this.xaN = ((ImageView)this.wGY.findViewById(a.f.hpcs_avatar_iv));
    this.JBq = ((WalletTextView)this.wGY.findViewById(a.f.hpcs_quota_tv));
    this.JBA = ((TextView)this.wGY.findViewById(a.f.hpcs_user_name_tv));
    this.JBx = ((TextView)this.wGY.findViewById(a.f.hpcs_modify_quota_tv));
    this.JBa = ((TextView)this.wGY.findViewById(a.f.hpcs_state_tv));
    this.JBC = ((TextView)this.wGY.findViewById(a.f.hpcs_state_desc_tv));
    this.JBc = ((TextView)this.wGY.findViewById(a.f.hpcs_first_date_title_tv));
    this.JBe = ((TextView)this.wGY.findViewById(a.f.hpcs_first_date_tv));
    this.JBd = ((TextView)this.wGY.findViewById(a.f.hpcs_second_date_title_tv));
    this.JBf = ((TextView)this.wGY.findViewById(a.f.hpcs_second_date_tv));
    this.JBD = this.wGY.findViewById(a.f.hpcs_bottom_logo_iv);
    this.JBF = ((TextView)this.wGY.findViewById(a.f.hpcs_payway_tips_tv));
    this.pLM = ((WcPayBannerView)this.wGY.findViewById(a.f.wc_pay_banner_layout));
    this.pLM.jPz();
    this.JBq.setPrefix(ai.jOX());
    this.JBy.setSwitchListener(new MMSwitchBtn.a()
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
    this.JBz.setOnClickListener(new k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(267354);
        if (HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this) != null)
        {
          Log.d(HoneyPayCardManagerUI.this.TAG, "click pay way: %s", new Object[] { Boolean.valueOf(HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this).abiv) });
          if (Util.isNullOrNil(HoneyPayCardManagerUI.e(HoneyPayCardManagerUI.this)))
          {
            HoneyPayCardManagerUI.f(HoneyPayCardManagerUI.this);
            AppMethodBeat.o(267354);
            return;
          }
          HoneyPayCardManagerUI.g(HoneyPayCardManagerUI.this);
        }
        AppMethodBeat.o(267354);
      }
    });
    String str = getString(a.i.honey_pay_max_quota_monthly);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(str);
    localSpannableStringBuilder.append(getString(a.i.honey_pay_max_quota_monthly_modify));
    localSpannableStringBuilder.setSpan(new com.tencent.mm.plugin.wallet_core.ui.s(1, new s.a()
    {
      public final void eS(View paramAnonymousView)
      {
        AppMethodBeat.i(64688);
        HoneyPayCardManagerUI.h(HoneyPayCardManagerUI.this);
        AppMethodBeat.o(64688);
      }
    }), str.length(), localSpannableStringBuilder.length(), 18);
    this.JBx.setClickable(true);
    this.JBx.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s(this));
    this.JBx.setText(localSpannableStringBuilder);
    this.JBu = ((ViewGroup)LayoutInflater.from(this).inflate(a.g.honey_pay_card_setting_footer_layout, null));
    this.JBE = findViewById(a.f.hpcs_block_view);
    this.JBt = ((ListView)findViewById(a.f.hpcs_lv));
    this.JBt.addHeaderView(this.wGY);
    this.JBt.addFooterView(this.JBu, null, false);
    this.JBG = new b((byte)0);
    this.JBt.setAdapter(this.JBG);
    this.JBt.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(64684);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        a.c("com/tencent/mm/plugin/honey_pay/ui/HoneyPayCardManagerUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        paramAnonymousAdapterView = (ebo)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
        if ((paramAnonymousAdapterView != null) && (!Util.isNullOrNil(paramAnonymousAdapterView.url)))
        {
          Log.i(HoneyPayCardManagerUI.this.TAG, "click item: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), Long.valueOf(paramAnonymousAdapterView.abhf) });
          com.tencent.mm.wallet_core.ui.i.p(HoneyPayCardManagerUI.this.getContext(), paramAnonymousAdapterView.url, false);
          h.OAn.b(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) });
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
        this.JBq.setText(c.rY(l));
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
        fPA();
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
    this.JAW = getIntent().getStringExtra("key_card_no");
    this.mScene = getIntent().getIntExtra("key_scene", 0);
    this.JBP = getIntent().getBooleanExtra("key_is_create", false);
    this.JBQ = getIntent().getStringExtra("key_card_type");
    initView();
    Log.d(this.TAG, "cardtype: %s", new Object[] { this.JBQ });
    setMMTitle(a.i.honey_pay_main_title);
    if (this.mScene == 1)
    {
      paramBundle = new ejv();
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
        fPA();
        AppMethodBeat.o(64703);
        return;
      }
    }
    fPA();
    AppMethodBeat.o(64703);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64705);
    super.onDestroy();
    removeSceneEndListener(2876);
    removeSceneEndListener(2742);
    removeSceneEndListener(2941);
    if (this.JBR != null) {
      an.VKs.a(this.JBR);
    }
    AppMethodBeat.o(64705);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(64706);
    if ((paramp instanceof l))
    {
      paramString = (l)paramp;
      paramString.a(new r.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
        {
          AppMethodBeat.i(64692);
          HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, paramString.JAH);
          AppMethodBeat.o(64692);
        }
      }).b(new r.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp) {}
      }).c(new r.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp) {}
      });
    }
    for (;;)
    {
      AppMethodBeat.o(64706);
      return true;
      if ((paramp instanceof com.tencent.mm.plugin.honey_pay.a.i))
      {
        paramString = (com.tencent.mm.plugin.honey_pay.a.i)paramp;
        paramString.a(new r.a()
        {
          public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp) {}
        }).b(new r.a()
        {
          public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
          {
            boolean bool = true;
            AppMethodBeat.i(64694);
            paramAnonymousString = HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this);
            if (paramString.eQp != 1) {}
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
          public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
          {
            boolean bool = true;
            AppMethodBeat.i(64693);
            paramAnonymousString = HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this);
            if (paramString.eQp != 1) {}
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
      else if ((paramp instanceof j))
      {
        paramString = (j)paramp;
        paramString.a(new r.a()
        {
          public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
          {
            AppMethodBeat.i(64685);
            HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, paramString.JAF.aaWZ);
            if (HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this) != null) {
              HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, HoneyPayCardManagerUI.aIG(HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this).abit));
            }
            HoneyPayCardManagerUI.d(HoneyPayCardManagerUI.this);
            AppMethodBeat.o(64685);
          }
        }).b(new r.a()
        {
          public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
          {
            AppMethodBeat.i(64696);
            HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, HoneyPayCardManagerUI.b(HoneyPayCardManagerUI.this));
            if (HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this) != null) {
              HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, HoneyPayCardManagerUI.aIG(HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this).abit));
            }
            HoneyPayCardManagerUI.d(HoneyPayCardManagerUI.this);
            AppMethodBeat.o(64696);
          }
        }).c(new r.a()
        {
          public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
          {
            AppMethodBeat.i(64695);
            HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, HoneyPayCardManagerUI.b(HoneyPayCardManagerUI.this));
            if (HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this) != null) {
              HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, HoneyPayCardManagerUI.aIG(HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this).abit));
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
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(267556);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(HoneyPayCardManagerUI.a.class);
    AppMethodBeat.o(267556);
  }
  
  final class b
    extends BaseAdapter
  {
    private b() {}
    
    private ebo YQ(int paramInt)
    {
      AppMethodBeat.i(64698);
      ebo localebo = (ebo)HoneyPayCardManagerUI.l(HoneyPayCardManagerUI.this).get(paramInt);
      AppMethodBeat.o(64698);
      return localebo;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(64697);
      int i = HoneyPayCardManagerUI.l(HoneyPayCardManagerUI.this).size();
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
        paramView = new HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this, (byte)0);
        paramView.wRf = ((TextView)localView.findViewById(a.f.hpci_date_tv));
        paramView.JCb = ((WalletTextView)localView.findViewById(a.f.hpci_amt_tv));
        paramView.JCb.setPrefix(ai.jOX());
        paramView.pKl = localView.findViewById(a.f.hpci_amt_tv_divider);
        localView.setTag(paramView);
      }
      paramView = YQ(paramInt);
      paramViewGroup = (HoneyPayCardManagerUI.c)localView.getTag();
      paramViewGroup.wRf.setText(paramView.NjO);
      paramViewGroup.JCb.setText(c.rY(paramView.abhf));
      if (HoneyPayCardManagerUI.l(paramViewGroup.JBS).size() == 1) {
        paramViewGroup.pKl.setVisibility(8);
      }
      for (;;)
      {
        AppMethodBeat.o(64700);
        return localView;
        paramViewGroup.pKl.setVisibility(0);
      }
    }
    
    public final boolean isEnabled(int paramInt)
    {
      AppMethodBeat.i(64699);
      if (!Util.isNullOrNil(YQ(paramInt).url))
      {
        AppMethodBeat.o(64699);
        return true;
      }
      AppMethodBeat.o(64699);
      return false;
    }
  }
  
  final class c
  {
    WalletTextView JCb;
    View pKl;
    TextView wRf;
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI
 * JD-Core Version:    0.7.0.1
 */