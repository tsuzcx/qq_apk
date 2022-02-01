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
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.plugin.wallet_core.utils.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.cbw;
import com.tencent.mm.protocal.protobuf.cqw;
import com.tencent.mm.protocal.protobuf.crf;
import com.tencent.mm.protocal.protobuf.czq;
import com.tencent.mm.protocal.protobuf.dbf;
import com.tencent.mm.protocal.protobuf.dhf;
import com.tencent.mm.protocal.protobuf.eig;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.o.g;
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
  private ViewGroup qgZ;
  private ImageView qyu;
  private String yjY;
  private eig yjZ;
  private MMSwitchBtn ykA;
  private LinearLayout ykB;
  private TextView ykC;
  private TextView ykD;
  private TextView ykE;
  private View ykF;
  private View ykG;
  private TextView ykH;
  private HoneyPayCardManagerUI.a ykI;
  private List<czq> ykJ;
  private Bankcard ykK;
  private dbf ykL;
  private dbf ykM;
  private long ykN;
  private long ykO;
  private boolean ykP;
  private String ykQ;
  private TextView ykc;
  private TextView yke;
  private TextView ykf;
  private TextView ykg;
  private TextView ykh;
  private WalletTextView yks;
  private ListView ykv;
  private ViewGroup ykw;
  private ViewGroup ykx;
  private ViewGroup yky;
  private TextView ykz;
  
  public HoneyPayCardManagerUI()
  {
    AppMethodBeat.i(64702);
    this.ykJ = new ArrayList();
    AppMethodBeat.o(64702);
  }
  
  private void a(cbw paramcbw)
  {
    boolean bool = false;
    AppMethodBeat.i(64712);
    Object localObject = f.ht(paramcbw.LjD, 6) + getString(2131761669);
    this.ykC.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, (CharSequence)localObject, this.ykC.getTextSize()));
    a.b.a(this.qyu, paramcbw.LjD, 0.06F, false);
    this.yks.setText(c.GO(paramcbw.LpD));
    localObject = this.ykA;
    if (paramcbw.HFB != 0) {
      bool = true;
    }
    ((MMSwitchBtn)localObject).setCheck(bool);
    dYT();
    AppMethodBeat.o(64712);
  }
  
  private void a(crf paramcrf)
  {
    AppMethodBeat.i(64710);
    this.ykx = ((ViewGroup)View.inflate(this, 2131495020, null));
    ((TextView)this.ykx.findViewById(2131302391)).setText(paramcrf.title);
    this.ykx.setOnClickListener(new HoneyPayCardManagerUI.8(this, paramcrf));
    AppMethodBeat.o(64710);
  }
  
  private void a(dhf paramdhf)
  {
    AppMethodBeat.i(64709);
    this.yjZ = paramdhf.LUW;
    this.ykJ.clear();
    this.ykI.notifyDataSetChanged();
    int i;
    if (paramdhf.LpE != null)
    {
      setMMTitle(paramdhf.LpE.pTn);
      this.ykN = paramdhf.LjF;
      this.ykO = paramdhf.LjE;
      if (paramdhf.LpE.MhM != null)
      {
        this.ykK = aBE(paramdhf.LpE.MhM.MGj);
        this.ykL = paramdhf.LpE.MhM;
      }
      a(paramdhf.LpE);
      i = paramdhf.LpE.state;
      Log.i(this.TAG, "detail state: %s", new Object[] { Integer.valueOf(i) });
      Log.d(this.TAG, "state title: %s", new Object[] { paramdhf.LpE.MhP });
      if (Util.isNullOrNil(paramdhf.LpE.MhP)) {
        break label424;
      }
      this.ykc.setText(paramdhf.LpE.MhP);
      this.ykc.setVisibility(0);
      if (Util.isNullOrNil(paramdhf.LpE.MhL)) {
        break label436;
      }
      this.ykE.setText(paramdhf.LpE.MhL);
      this.ykE.setVisibility(0);
      label233:
      if (i != 1) {
        break label448;
      }
      this.ykc.setTextColor(getResources().getColor(2131099792));
      this.yks.setTextColor(getResources().getColor(2131099748));
      findViewById(2131302395).setVisibility(8);
      this.ykv.removeFooterView(this.ykw);
      this.ykw.setVisibility(8);
      this.ykF.setVisibility(8);
      if (this.ykP)
      {
        this.yky = ((ViewGroup)LayoutInflater.from(this).inflate(2131495018, null));
        ((Button)this.yky.findViewById(2131302396)).setOnClickListener(new HoneyPayCardManagerUI.7(this));
        this.ykv.addFooterView(this.yky);
        showHomeBtn(false);
        enableBackMenu(false);
        setMMTitle("");
      }
    }
    for (;;)
    {
      this.ykG.setVisibility(8);
      c.b(this, paramdhf.MhF, this.yjY, 2, this.yjZ);
      AppMethodBeat.o(64709);
      return;
      label424:
      this.ykc.setVisibility(8);
      break;
      label436:
      this.ykE.setVisibility(8);
      break label233;
      label448:
      if (i == 2)
      {
        if ((paramdhf.dkr != null) && (!paramdhf.dkr.isEmpty()))
        {
          this.ykJ = paramdhf.dkr;
          this.ykI.notifyDataSetChanged();
          this.ykv.removeFooterView(this.ykw);
          this.ykw.setVisibility(8);
          if (paramdhf.MLE != null)
          {
            a(paramdhf.MLE);
            this.ykv.addFooterView(this.ykx);
          }
          findViewById(2131302407).setBackgroundResource(2131100596);
        }
        this.ykz.setVisibility(0);
        this.yks.setVisibility(0);
        this.ykF.setVisibility(0);
        findViewById(2131302395).setVisibility(8);
      }
      else if (i == 3)
      {
        findViewById(2131302395).setVisibility(0);
        this.yke.setText(2131761648);
        this.ykf.setText(2131761691);
        this.ykg.setText(c.GP(paramdhf.LpE.Gaz));
        this.ykh.setText(c.GP(paramdhf.LpE.pRN));
        this.ykv.removeFooterView(this.ykw);
        this.ykw.setVisibility(8);
        this.ykF.setVisibility(8);
        findViewById(2131302411).setVisibility(8);
      }
      else if (i == 4)
      {
        this.ykz.setVisibility(8);
        findViewById(2131302395).setVisibility(0);
        this.yke.setText(2131761690);
        this.ykg.setText(c.GP(paramdhf.LpE.MhN));
        findViewById(2131302408).setVisibility(8);
        this.ykv.removeFooterView(this.ykw);
        this.ykw.setVisibility(8);
        this.ykF.setVisibility(8);
        findViewById(2131302411).setVisibility(8);
        findViewById(2131302407).setBackgroundResource(2131101424);
      }
      else
      {
        Log.d(this.TAG, "unknown state: %s", new Object[] { Integer.valueOf(i) });
      }
    }
  }
  
  private static Bankcard aBE(String paramString)
  {
    AppMethodBeat.i(64711);
    Bankcard localBankcard1 = t.fQI().aVm(paramString);
    if (localBankcard1 == null)
    {
      Bankcard localBankcard2 = t.fQI().IbQ;
      if ((localBankcard2 != null) && (localBankcard2.field_bindSerial.equals(paramString)))
      {
        AppMethodBeat.o(64711);
        return localBankcard2;
      }
    }
    AppMethodBeat.o(64711);
    return localBankcard1;
  }
  
  private void dYS()
  {
    AppMethodBeat.i(64708);
    Log.i(this.TAG, "do qry detail");
    com.tencent.mm.plugin.honey_pay.a.l locall = new com.tencent.mm.plugin.honey_pay.a.l(this.yjY);
    locall.t(this);
    doSceneProgress(locall, true);
    AppMethodBeat.o(64708);
  }
  
  private void dYT()
  {
    AppMethodBeat.i(64713);
    if (this.ykL != null)
    {
      this.ykD.setText(this.ykL.MGh);
      if (!Util.isNullOrNil(this.ykL.MGi)) {
        this.ykD.setTextColor(g.cI(this.ykL.MGi, true));
      }
      while (!Util.isNullOrNil(this.ykL.MGm))
      {
        this.ykH.setText(this.ykL.MGm);
        this.ykH.setVisibility(0);
        AppMethodBeat.o(64713);
        return;
        this.ykD.setTextColor(getResources().getColor(2131100904));
      }
      this.ykH.setVisibility(8);
      AppMethodBeat.o(64713);
      return;
    }
    Log.i(this.TAG, "reset payway view for null");
    this.ykD.setText("");
    this.ykD.setTextColor(getResources().getColor(2131100904));
    this.ykH.setVisibility(8);
    AppMethodBeat.o(64713);
  }
  
  public int getLayoutId()
  {
    return 2131495023;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64704);
    this.qgZ = ((ViewGroup)LayoutInflater.from(this).inflate(2131495021, null));
    this.ykA = ((MMSwitchBtn)this.qgZ.findViewById(2131302402));
    this.ykB = ((LinearLayout)this.qgZ.findViewById(2131302403));
    this.ykD = ((TextView)this.qgZ.findViewById(2131302405));
    this.qyu = ((ImageView)this.qgZ.findViewById(2131302392));
    this.yks = ((WalletTextView)this.qgZ.findViewById(2131302406));
    this.ykC = ((TextView)this.qgZ.findViewById(2131302414));
    this.ykz = ((TextView)this.qgZ.findViewById(2131302401));
    this.ykc = ((TextView)this.qgZ.findViewById(2131302413));
    this.ykE = ((TextView)this.qgZ.findViewById(2131302412));
    this.yke = ((TextView)this.qgZ.findViewById(2131302398));
    this.ykg = ((TextView)this.qgZ.findViewById(2131302399));
    this.ykf = ((TextView)this.qgZ.findViewById(2131302409));
    this.ykh = ((TextView)this.qgZ.findViewById(2131302410));
    this.ykF = this.qgZ.findViewById(2131302394);
    this.ykH = ((TextView)this.qgZ.findViewById(2131302404));
    this.yks.setPrefix(ah.hhz());
    this.ykA.setSwitchListener(new MMSwitchBtn.a()
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
    this.ykB.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64687);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPayCardManagerUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this) != null)
        {
          Log.d(HoneyPayCardManagerUI.this.TAG, "click pay way: %s", new Object[] { Boolean.valueOf(HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this).MGl) });
          if (!HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this).MGl) {
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
    String str = getString(2131761669);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(str);
    localSpannableStringBuilder.append(getString(2131761671));
    localSpannableStringBuilder.setSpan(new com.tencent.mm.plugin.wallet_core.ui.q(1, new q.a()
    {
      public final void dF(View paramAnonymousView)
      {
        AppMethodBeat.i(64688);
        HoneyPayCardManagerUI.g(HoneyPayCardManagerUI.this);
        AppMethodBeat.o(64688);
      }
    }), str.length(), localSpannableStringBuilder.length(), 18);
    this.ykz.setClickable(true);
    this.ykz.setOnTouchListener(new o(this));
    this.ykz.setText(localSpannableStringBuilder);
    this.ykw = ((ViewGroup)LayoutInflater.from(this).inflate(2131495019, null));
    this.ykG = findViewById(2131302393);
    this.ykv = ((ListView)findViewById(2131302400));
    this.ykv.addHeaderView(this.qgZ);
    this.ykv.addFooterView(this.ykw, null, false);
    this.ykI = new HoneyPayCardManagerUI.a(this, (byte)0);
    this.ykv.setAdapter(this.ykI);
    this.ykv.setOnItemClickListener(new HoneyPayCardManagerUI.1(this));
    AppMethodBeat.o(64704);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(64707);
    if (paramInt1 == 1) {
      if ((paramInt2 == -1) && (paramIntent.getBooleanExtra("key_modify_create_line_succ", false)))
      {
        long l = paramIntent.getLongExtra("key_credit_line", 0L);
        this.yks.setText(c.GO(l));
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
        dYS();
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
    this.yjY = getIntent().getStringExtra("key_card_no");
    this.mScene = getIntent().getIntExtra("key_scene", 0);
    this.ykP = getIntent().getBooleanExtra("key_is_create", false);
    this.ykQ = getIntent().getStringExtra("key_card_type");
    initView();
    Log.d(this.TAG, "cardtype: %s", new Object[] { this.ykQ });
    setMMTitle(2131761663);
    if (this.mScene == 1)
    {
      paramBundle = new dhf();
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
        dYS();
        AppMethodBeat.o(64703);
        return;
      }
    }
    dYS();
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(64706);
    if ((paramq instanceof com.tencent.mm.plugin.honey_pay.a.l))
    {
      paramString = (com.tencent.mm.plugin.honey_pay.a.l)paramq;
      paramString.a(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq)
        {
          AppMethodBeat.i(64692);
          HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, paramString.yjJ);
          AppMethodBeat.o(64692);
        }
      }).b(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq) {}
      }).c(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq) {}
      });
    }
    for (;;)
    {
      AppMethodBeat.o(64706);
      return true;
      if ((paramq instanceof i))
      {
        paramString = (i)paramq;
        paramString.a(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq) {}
        }).b(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq)
          {
            boolean bool = true;
            AppMethodBeat.i(64694);
            paramAnonymousString = HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this);
            if (paramString.cSx != 1) {}
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
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq)
          {
            boolean bool = true;
            AppMethodBeat.i(64693);
            paramAnonymousString = HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this);
            if (paramString.cSx != 1) {}
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
        paramString.a(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq)
          {
            AppMethodBeat.i(64685);
            HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, paramString.yjH.Mws);
            if (HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this) != null) {
              HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, HoneyPayCardManagerUI.aBF(HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this).MGj));
            }
            HoneyPayCardManagerUI.d(HoneyPayCardManagerUI.this);
            AppMethodBeat.o(64685);
          }
        }).b(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq)
          {
            AppMethodBeat.i(64696);
            HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, HoneyPayCardManagerUI.b(HoneyPayCardManagerUI.this));
            if (HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this) != null) {
              HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, HoneyPayCardManagerUI.aBF(HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this).MGj));
            }
            HoneyPayCardManagerUI.d(HoneyPayCardManagerUI.this);
            AppMethodBeat.o(64696);
          }
        }).c(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq)
          {
            AppMethodBeat.i(64695);
            HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, HoneyPayCardManagerUI.b(HoneyPayCardManagerUI.this));
            if (HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this) != null) {
              HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, HoneyPayCardManagerUI.aBF(HoneyPayCardManagerUI.c(HoneyPayCardManagerUI.this).MGj));
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