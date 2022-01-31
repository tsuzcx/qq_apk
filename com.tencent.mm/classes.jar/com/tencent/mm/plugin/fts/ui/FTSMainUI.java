package com.tencent.mm.plugin.fts.ui;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.h.a.sq;
import com.tencent.mm.h.a.ue;
import com.tencent.mm.h.b.a.ay;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.appbrand.r.g.a;
import com.tencent.mm.plugin.appbrand.r.g.c;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView;
import com.tencent.mm.plugin.fts.ui.widget.FTSMainUIEducationLayout;
import com.tencent.mm.plugin.fts.ui.widget.FTSSayFooter;
import com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.plugin.websearch.api.o;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.KeyboardLinearLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class FTSMainUI
  extends FTSBaseVoiceSearchUI
  implements a.a
{
  private int gHR;
  private int gHS;
  long gMG;
  private Dialog jwv;
  int kAH = -1;
  private FTSMainUIEducationLayout kBI;
  private LinearLayout kBJ;
  private LinearLayout kBK;
  private LinearLayout kBL;
  private View kBM;
  private View kBN;
  private FTSLocalPageRelevantView kBO;
  private TextView kBP;
  private TextView kBQ;
  private View kBR;
  private View kBS;
  private TextView kBT;
  private i kBU;
  private View kBV;
  private boolean kBW;
  private long kBX;
  private boolean kBY;
  private Runnable kBZ = new FTSMainUI.1(this);
  private String kCa;
  private volatile boolean kCb;
  private Map<String, Integer> kCc = new HashMap();
  private KeyboardLinearLayout kCd;
  private FTSSayFooter kCe;
  private j kCf;
  private j.b kCg = new FTSMainUI.21(this);
  private o kCh = new FTSMainUI.9(this);
  private com.tencent.mm.plugin.websearch.api.d kCi = new FTSMainUI.10(this);
  private com.tencent.mm.plugin.websearch.api.g kCj = new FTSMainUI.11(this);
  private View.OnClickListener kCk = new FTSMainUI.14(this);
  private com.tencent.mm.sdk.b.c<ue> kCl = new FTSMainUI.15(this);
  private int kxJ;
  
  private void aWm()
  {
    this.kBI.setVisibility(8);
  }
  
  private void aWn()
  {
    this.kCf.kBs = true;
    Object localObject = this.bVk;
    if ((localObject == null) || (bk.bl(((String)localObject).trim()))) {}
    while (System.currentTimeMillis() - this.gMG <= 1000L) {
      return;
    }
    this.gMG = System.currentTimeMillis();
    String str = com.tencent.mm.plugin.fts.a.e.kvx;
    ((com.tencent.mm.plugin.websearch.api.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.websearch.api.j.class)).a(this.mController.uMN, 3, (String)localObject, str);
    ao.BF(3);
    if (!bk.bl(this.bVk)) {
      ao.i(this.bVk, 2, 2, 3);
    }
    this.kBM.setEnabled(false);
    localObject = aWo();
    k.a(this.bVk, this.kCf.getCount(), this.kxJ, (com.tencent.mm.plugin.fts.ui.c.b)localObject, 18);
  }
  
  private com.tencent.mm.plugin.fts.ui.c.b aWo()
  {
    com.tencent.mm.plugin.fts.ui.c.b localb = this.kCf.kBw;
    if ((this.kBR != null) && (this.kBR.getVisibility() == 0))
    {
      localb.kEi = (this.kCf.getBlockCount() + 2);
      return localb;
    }
    localb.kEi = (this.kCf.getBlockCount() + 1);
    return localb;
  }
  
  private void aWp()
  {
    if ((this.kCb) && (!TextUtils.isEmpty(this.bVk)))
    {
      if ((this.kCf.getBlockCount() == 0) && (this.kBV.getVisibility() == 8) && (TextUtils.isEmpty(this.kBT.getText())))
      {
        aWn();
        localay = new ay();
        localay.cqF = 1L;
        localay.cfv = 1L;
        localay.cjD = this.bVk;
        localay.QX();
      }
    }
    else {
      return;
    }
    ay localay = new ay();
    localay.cqF = 1L;
    localay.cfv = 2L;
    localay.cjD = this.bVk;
    localay.QX();
  }
  
  public final void O(int paramInt, boolean paramBoolean)
  {
    super.O(paramInt, paramBoolean);
    this.kBO.setVisibility(8);
    this.kBU.hide();
    this.kBV.setVisibility(8);
    if ((!paramBoolean) && (paramInt == 0) && (this.kCf.kBE))
    {
      this.kBL.setVisibility(0);
      if (paramBoolean) {
        break label106;
      }
      ai.S(this.kBZ);
      this.kBM.setVisibility(8);
      this.kBR.setVisibility(8);
      this.kBY = false;
    }
    label297:
    label332:
    for (;;)
    {
      return;
      this.kBL.setVisibility(8);
      break;
      label106:
      this.kCb = true;
      paramBoolean = com.tencent.mm.plugin.fts.a.d.DT(this.bVk);
      boolean bool = com.tencent.mm.plugin.fts.a.d.DU(this.bVk);
      if (paramInt > 0)
      {
        if ((paramBoolean) || (bool)) {
          this.kBS.setVisibility(0);
        }
        this.kBN.setVisibility(0);
        if ((paramBoolean) || (bool)) {
          this.kBR.setVisibility(0);
        }
        this.kBY = true;
        if (this.kBW) {
          break label297;
        }
        this.kBM.setVisibility(0);
      }
      for (;;)
      {
        if ((this.bVk == null) || (this.bVk.length() <= 0)) {
          break label332;
        }
        ((com.tencent.mm.plugin.websearch.api.e)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.websearch.api.e.class)).a(this.bVk, this.kCi, this);
        ((p)com.tencent.mm.kernel.g.r(p.class)).a(this.bVk, com.tencent.mm.plugin.fts.a.e.kvx, this.kCh);
        return;
        this.kBS.setVisibility(8);
        if ((paramBoolean) || (bool))
        {
          this.kBN.setVisibility(0);
          break;
        }
        this.kBN.setVisibility(8);
        break;
        y.i("MicroMsg.FTS.FTSMainUI", "wait for search widget result , timeout %d", new Object[] { Long.valueOf(this.kBX) });
        ai.l(this.kBZ, this.kBX);
      }
    }
  }
  
  public final void XM()
  {
    if ((this.kAZ != null) && (!this.kAZ.cIK()) && (this.kCe != null)) {
      this.kCe.aWI();
    }
    super.XM();
  }
  
  protected final d a(e parame)
  {
    this.kCf = new j(parame, this.kxJ, this.kCg);
    this.kCf.rC(2);
    return this.kCf;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.a.a parama) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    y.i("MicroMsg.FTS.FTSMainUI", "onGetLocation %b %f|%f", new Object[] { Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    com.tencent.mm.modelgeo.c.Ob().c(this);
    return false;
  }
  
  public final View aBq()
  {
    if (this.kBJ == null)
    {
      this.kBJ = ((LinearLayout)getLayoutInflater().inflate(n.e.fts_loading_footer, null));
      this.kBP = ((TextView)this.kBJ.findViewById(n.d.search_network_tv));
      this.kBQ = ((TextView)this.kBJ.findViewById(n.d.fts_on_search_network_tv));
    }
    try
    {
      String str = ac.Ru("webSearchBar").optString("wording");
      y.i("MicroMsg.FTS.FTSMainUI", "set searchNetworkTips %s", new Object[] { str });
      this.kBQ.setText(str);
      label97:
      this.kBN = this.kBJ.findViewById(n.d.search_network_divider);
      this.kBM = this.kBJ.findViewById(n.d.search_network_layout);
      this.kBJ.findViewById(n.d.websearch_container).setOnClickListener(new FTSMainUI.3(this));
      this.kBV = this.kBJ.findViewById(n.d.service_widget_container);
      this.kBU = ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.websearch.api.h.class)).a((LinearLayout)this.kBV, com.tencent.mm.cb.a.ad(ae.getContext(), ae.getResources().getDisplayMetrics().widthPixels) - 26, this, this.kCj);
      this.kBO = new FTSLocalPageRelevantView(this);
      this.kBO.setOnRelevantClickListener(new FTSMainUI.4(this));
      int i = this.kBJ.indexOfChild(this.kBM);
      if ((i >= 0) && (i < this.kBJ.getChildCount())) {
        this.kBJ.addView(this.kBO, i + 1);
      }
      this.kBT = ((TextView)this.kBJ.findViewById(n.d.search_contact_tv));
      this.kBS = this.kBJ.findViewById(n.d.search_contact_divider);
      this.kBR = this.kBJ.findViewById(n.d.search_contact_layout);
      this.kBR.setOnClickListener(new FTSMainUI.5(this));
      this.kBK = ((LinearLayout)this.kBJ.findViewById(n.d.footer_layout));
      return this.kBJ;
    }
    catch (Exception localException)
    {
      break label97;
    }
  }
  
  protected final void aVW()
  {
    super.aVW();
    Object localObject = com.tencent.mm.pluginsdk.ui.d.j.b(this, f.a(getString(n.g.fts_on_search_network), "", com.tencent.mm.plugin.fts.a.a.d.b(this.bVk, this.bVk)).kwz, com.tencent.mm.cb.a.aa(this, n.b.NormalTextSize));
    this.kBP.setText((CharSequence)localObject);
    localObject = null;
    if (com.tencent.mm.plugin.fts.a.d.DT(this.bVk)) {
      localObject = f.a(getString(n.g.fts_find_phone_qq_tip_prefix), "", com.tencent.mm.plugin.fts.a.a.d.b(this.bVk, this.bVk)).kwz;
    }
    for (;;)
    {
      localObject = com.tencent.mm.pluginsdk.ui.d.j.b(this, (CharSequence)localObject, com.tencent.mm.cb.a.aa(this, n.b.NormalTextSize));
      this.kBT.setText((CharSequence)localObject);
      return;
      if (com.tencent.mm.plugin.fts.a.d.DU(this.bVk)) {
        localObject = f.a(getString(n.g.fts_find_wxid_tip_prefix), "", com.tencent.mm.plugin.fts.a.a.d.b(this.bVk, this.bVk)).kwz;
      }
    }
  }
  
  protected final void aWa()
  {
    switch (getIntent().getIntExtra("from_tab_index", -1))
    {
    default: 
      this.kxJ = 0;
      return;
    case 0: 
      this.kxJ = 1;
      return;
    case 1: 
      this.kxJ = 2;
      return;
    case 2: 
      this.kxJ = 3;
      return;
    }
    this.kxJ = 4;
  }
  
  protected final void aWc()
  {
    super.aWc();
    aWm();
    this.kBL.setVisibility(8);
  }
  
  protected final void aWd()
  {
    super.aWd();
    aWm();
    this.kBL.setVisibility(8);
    this.kAS.setVisibility(0);
    this.kAU.setVisibility(8);
  }
  
  protected final void aWe()
  {
    super.aWe();
    aWm();
    this.kBL.setVisibility(8);
  }
  
  protected final void aWf()
  {
    super.aWf();
    this.kBI.setVisibility(0);
    this.kBI.aZ();
    this.kBL.setVisibility(8);
  }
  
  protected final void aWg()
  {
    if (this.kBK != null) {
      this.kBK.setVisibility(0);
    }
  }
  
  protected final void aWh()
  {
    if (this.kBK != null) {
      this.kBK.setVisibility(8);
    }
  }
  
  public void finish()
  {
    int i = 100;
    if (!this.mController.hideVKB()) {
      i = 0;
    }
    ai.l(new FTSMainUI.2(this), i);
  }
  
  protected final int getLayoutId()
  {
    return n.e.fts_main_ui;
  }
  
  public void onBackPressed()
  {
    finish();
  }
  
  public void onClickWxApp(View paramView)
  {
    if (paramView.getTag().equals("more-click"))
    {
      ((com.tencent.mm.plugin.appbrand.r.g)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.r.g.class)).a(this, com.tencent.mm.plugin.fts.a.e.kvx, g.a.haK);
      return;
    }
    if (paramView.getTag().equals("more-swipe"))
    {
      ((com.tencent.mm.plugin.appbrand.r.g)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.r.g.class)).a(this, com.tencent.mm.plugin.fts.a.e.kvx, g.a.haL);
      return;
    }
    ((com.tencent.mm.plugin.appbrand.r.g)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.r.g.class)).a(this, (g.c)paramView.getTag(), com.tencent.mm.plugin.fts.a.e.kvx);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.gHR = ae.getResources().getDisplayMetrics().widthPixels;
    this.gHS = ae.getResources().getDisplayMetrics().heightPixels;
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = TransitionInflater.from(this).inflateTransition(17760258);
      TransitionInflater.from(this).inflateTransition(17760258);
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(n.d.action_bar_container), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    this.kCd = ((KeyboardLinearLayout)findViewById(n.d.root));
    this.kCd.setOnkbdStateListener(new FTSMainUI.12(this));
    this.kCe = ((FTSSayFooter)findViewById(n.d.say_footer));
    this.kCe.setEditText(new FTSMainUI.17(this));
    this.kCe.setVoiceStateListener(new FTSMainUI.18(this));
    this.kCe.setVisibility(8);
    this.kAZ.setHint(getString(n.g.app_search));
    this.kAZ.kFv = new FTSMainUI.19(this);
    czo();
    com.tencent.mm.plugin.fts.a.e.kvx = aa.Bm(3);
    paramBundle = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(this.kxJ), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), com.tencent.mm.plugin.fts.a.e.kvx, "" });
    y.d("MicroMsg.FTS.FTSReportLogic", "reportFTSEnterClick: %d, %s", new Object[] { Integer.valueOf(10991), paramBundle });
    com.tencent.mm.plugin.report.service.h.nFQ.aC(10991, paramBundle);
    this.kBI = ((FTSMainUIEducationLayout)findViewById(n.d.search_education_layout));
    this.kBL = ((LinearLayout)findViewById(n.d.search_loading_view));
    this.kBI.setOnCellClickListener(this.kCk);
    this.kBI.setOnHotwordClickListener(new FTSMainUI.20(this));
    this.kBI.setNeedHotWord(false);
    com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.widget.recentview.d.class);
    com.tencent.mm.modelgeo.c.Ob().a(this, true);
    if (((n)com.tencent.mm.kernel.g.t(n.class)).getFTSImageLoader() == null)
    {
      finish();
      return;
    }
    ((n)com.tencent.mm.kernel.g.t(n.class)).getFTSImageLoader().aVm();
    ac.BC(3);
    com.tencent.mm.sdk.b.a.udP.b(this.kCl);
    com.tencent.mm.sdk.f.e.post(new FTSMainUI.16(this), "init-widget-switch");
  }
  
  protected void onDestroy()
  {
    com.tencent.mm.modelgeo.c.Ob().c(this);
    if (((n)com.tencent.mm.kernel.g.t(n.class)).getFTSImageLoader() != null) {
      ((n)com.tencent.mm.kernel.g.t(n.class)).getFTSImageLoader().aVn();
    }
    com.tencent.mm.sdk.b.a.udP.d(this.kCl);
    if (this.kCe != null)
    {
      FTSSayFooter localFTSSayFooter = this.kCe;
      if (localFTSSayFooter.kEU != null) {
        localFTSSayFooter.kEU.TG();
      }
    }
    if (this.kBU != null) {
      this.kBU.onDestroy();
    }
    k.a(aWo());
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getKeyCode() == 4)
    {
      FTSSayFooter localFTSSayFooter = this.kCe;
      if ((localFTSSayFooter.aWH()) || (localFTSSayFooter.getVisibility() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        this.kCe.aWI();
        return true;
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onResume()
  {
    super.onResume();
    this.kCe.post(new FTSMainUI.22(this));
    sq localsq = new sq();
    localsq.cci.brn = 0L;
    com.tencent.mm.sdk.b.a.udP.m(localsq);
    com.tencent.mm.cl.b.afs("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
    if (this.kBM != null) {
      this.kBM.setEnabled(true);
    }
    if (!bk.bl(this.kCa))
    {
      this.bVk = this.kCa;
      this.kCa = null;
    }
    aa.bZu();
    if (this.kBU != null) {
      this.kBU.onResume();
    }
  }
  
  protected void onStop()
  {
    XM();
    super.onStop();
    if (this.kBU != null) {
      this.kBU.onPause();
    }
  }
  
  public final boolean pB(String paramString)
  {
    super.pB(paramString);
    aWp();
    return false;
  }
  
  public final void pC(String paramString)
  {
    super.pC(paramString);
    this.kCb = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI
 * JD-Core Version:    0.7.0.1
 */