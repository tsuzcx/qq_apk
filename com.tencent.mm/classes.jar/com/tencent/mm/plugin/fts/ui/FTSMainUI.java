package com.tencent.mm.plugin.fts.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.g.a.wa;
import com.tencent.mm.g.b.a.dg;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.appbrand.service.n.a;
import com.tencent.mm.plugin.appbrand.service.n.c;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.c.b;
import com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView;
import com.tencent.mm.plugin.fts.ui.widget.FTSMainUIEducationLayout;
import com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl;
import com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.plugin.websearch.api.o;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.KeyboardLinearLayout;
import com.tencent.mm.ui.q;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class FTSMainUI
  extends FTSBaseVoiceSearchUI
  implements b.a
{
  private int ibk;
  private int iiW;
  private int iiX;
  long iod;
  private Dialog lFU;
  int mWz;
  private FTSMainUIEducationLayout mXD;
  private LinearLayout mXE;
  private LinearLayout mXF;
  private com.tencent.mm.plugin.fts.ui.widget.c mXG;
  private boolean mXH;
  private LinearLayout mXI;
  private View mXJ;
  private View mXK;
  private FTSLocalPageRelevantView mXL;
  private TextView mXM;
  private TextView mXN;
  private View mXO;
  private View mXP;
  private TextView mXQ;
  private i mXR;
  private View mXS;
  private boolean mXT;
  private long mXU;
  private boolean mXV;
  private Runnable mXW;
  private String mXX;
  private volatile boolean mXY;
  private Map<String, Integer> mXZ;
  private KeyboardLinearLayout mYa;
  private j mYb;
  private j.b mYc;
  private o mYd;
  private com.tencent.mm.plugin.websearch.api.d mYe;
  private com.tencent.mm.plugin.websearch.api.g mYf;
  private View.OnClickListener mYg;
  private com.tencent.mm.sdk.b.c<wa> mYh;
  
  public FTSMainUI()
  {
    AppMethodBeat.i(61897);
    this.mXH = false;
    this.mXW = new FTSMainUI.1(this);
    this.mXZ = new HashMap();
    this.mYc = new FTSMainUI.19(this);
    this.mWz = -1;
    this.mYd = new FTSMainUI.8(this);
    this.mYe = new FTSMainUI.9(this);
    this.mYf = new FTSMainUI.10(this);
    this.mYg = new FTSMainUI.13(this);
    this.mYh = new FTSMainUI.14(this);
    AppMethodBeat.o(61897);
  }
  
  private void bCP()
  {
    AppMethodBeat.i(61908);
    this.mXD.setVisibility(0);
    this.mXD.bJ();
    AppMethodBeat.o(61908);
  }
  
  private void bCQ()
  {
    AppMethodBeat.i(61909);
    this.mXD.setVisibility(8);
    AppMethodBeat.o(61909);
  }
  
  private void bCR()
  {
    AppMethodBeat.i(61915);
    this.mYb.mXk = true;
    Object localObject = this.query;
    if ((localObject == null) || (bo.isNullOrNil(((String)localObject).trim())))
    {
      AppMethodBeat.o(61915);
      return;
    }
    if (System.currentTimeMillis() - this.iod <= 1000L)
    {
      AppMethodBeat.o(61915);
      return;
    }
    this.iod = System.currentTimeMillis();
    long l = com.tencent.mm.plugin.fts.a.e.mRk;
    HashMap localHashMap = new HashMap();
    localHashMap.put("sceneActionType", "1");
    localHashMap.put("clickType", "17");
    ((com.tencent.mm.plugin.websearch.api.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.websearch.api.j.class)).a(getContext(), 3, (String)localObject, String.valueOf(l), localHashMap);
    an.Jv(3);
    if (!bo.isNullOrNil(this.query)) {
      an.m(this.query, 2, 2, 3);
    }
    this.mXJ.setEnabled(false);
    localObject = bCS();
    ((b)localObject).wB(18);
    k.a(this.query, this.mYb.getCount(), this.ibk, (b)localObject, 18);
    AppMethodBeat.o(61915);
  }
  
  private b bCS()
  {
    AppMethodBeat.i(61916);
    b localb = this.mYb.mXp;
    if ((this.mXO != null) && (this.mXO.getVisibility() == 0)) {}
    for (localb.nat = (this.mYb.getBlockCount() + 2);; localb.nat = (this.mYb.getBlockCount() + 1))
    {
      AppMethodBeat.o(61916);
      return localb;
    }
  }
  
  private void bCT()
  {
    AppMethodBeat.i(61918);
    if ((this.mXY) && (!TextUtils.isEmpty(this.query)))
    {
      if ((this.mYb.getBlockCount() == 0) && (this.mXS.getVisibility() == 8) && (TextUtils.isEmpty(this.mXQ.getText())))
      {
        bCR();
        localdg = new dg();
        localdg.dfb = 1L;
        localdg.cOc = 1L;
        localdg.iB(this.query).ake();
        AppMethodBeat.o(61918);
        return;
      }
      dg localdg = new dg();
      localdg.dfb = 1L;
      localdg.cOc = 2L;
      localdg.iB(this.query).ake();
    }
    AppMethodBeat.o(61918);
  }
  
  public final void W(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(61921);
    super.W(paramInt, paramBoolean);
    this.mXL.setVisibility(8);
    this.mXR.hide();
    this.mXS.setVisibility(8);
    if ((!paramBoolean) && (paramInt == 0) && (this.mYb.mXz)) {
      this.mXI.setVisibility(0);
    }
    while (!paramBoolean)
    {
      al.ae(this.mXW);
      this.mXJ.setVisibility(8);
      this.mXO.setVisibility(8);
      this.mXV = false;
      AppMethodBeat.o(61921);
      return;
      this.mXI.setVisibility(8);
    }
    this.mXY = true;
    paramBoolean = com.tencent.mm.plugin.fts.a.d.Pc(this.query);
    boolean bool = com.tencent.mm.plugin.fts.a.d.Pd(this.query);
    if (paramInt > 0)
    {
      if ((paramBoolean) || (bool)) {
        this.mXP.setVisibility(0);
      }
      this.mXK.setVisibility(0);
      if ((paramBoolean) || (bool)) {
        this.mXO.setVisibility(0);
      }
      this.mXV = true;
      if (this.mXT) {
        break label318;
      }
      this.mXJ.setVisibility(0);
    }
    for (;;)
    {
      if ((this.query != null) && (this.query.length() > 0))
      {
        ((com.tencent.mm.plugin.websearch.api.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.websearch.api.e.class)).a(this.query, this.mYe, this);
        ((p)com.tencent.mm.kernel.g.E(p.class)).a(this.query, String.valueOf(com.tencent.mm.plugin.fts.a.e.mRk), this.mYd);
      }
      AppMethodBeat.o(61921);
      return;
      this.mXP.setVisibility(8);
      if ((paramBoolean) || (bool))
      {
        this.mXK.setVisibility(0);
        break;
      }
      this.mXK.setVisibility(8);
      break;
      label318:
      ab.i("MicroMsg.FTS.FTSMainUI", "wait for search widget result , timeout %d", new Object[] { Long.valueOf(this.mXU) });
      al.p(this.mXW, this.mXU);
    }
  }
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(61903);
    this.mYb = new j(parame, this.ibk, this.mYc);
    this.mYb.wy(2);
    parame = this.mYb;
    AppMethodBeat.o(61903);
    return parame;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.a.a parama) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    AppMethodBeat.i(61907);
    ab.i("MicroMsg.FTS.FTSMainUI", "onGetLocation %b %f|%f", new Object[] { Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    com.tencent.mm.modelgeo.d.agQ().c(this);
    AppMethodBeat.o(61907);
    return false;
  }
  
  protected final void bCD()
  {
    AppMethodBeat.i(61902);
    switch (getIntent().getIntExtra("from_tab_index", -1))
    {
    default: 
      this.ibk = 0;
      AppMethodBeat.o(61902);
      return;
    case 0: 
      this.ibk = 1;
      AppMethodBeat.o(61902);
      return;
    case 1: 
      this.ibk = 2;
      AppMethodBeat.o(61902);
      return;
    case 2: 
      this.ibk = 3;
      AppMethodBeat.o(61902);
      return;
    }
    this.ibk = 4;
    AppMethodBeat.o(61902);
  }
  
  protected final void bCF()
  {
    AppMethodBeat.i(61913);
    super.bCF();
    bCQ();
    this.mXI.setVisibility(8);
    if ((this.mXG != null) && (!this.mXG.nbM)) {
      this.mXG.bDp();
    }
    AppMethodBeat.o(61913);
  }
  
  protected final void bCG()
  {
    AppMethodBeat.i(61912);
    super.bCG();
    bCQ();
    this.mXI.setVisibility(8);
    this.mWK.setVisibility(0);
    this.mWM.setVisibility(8);
    if ((this.mXG != null) && (!this.mXG.nbM)) {
      this.mXG.bDp();
    }
    AppMethodBeat.o(61912);
  }
  
  protected final void bCH()
  {
    AppMethodBeat.i(61911);
    super.bCH();
    bCQ();
    this.mXI.setVisibility(8);
    if ((this.mXG != null) && (!this.mXG.nbM)) {
      this.mXG.bDp();
    }
    AppMethodBeat.o(61911);
  }
  
  protected final void bCI()
  {
    AppMethodBeat.i(61910);
    super.bCI();
    bCP();
    this.mXI.setVisibility(8);
    if ((this.mXH) && (this.mXG != null)) {
      this.mXG.show();
    }
    AppMethodBeat.o(61910);
  }
  
  protected final void bCJ()
  {
    AppMethodBeat.i(61919);
    if (this.mXF != null) {
      this.mXF.setVisibility(0);
    }
    AppMethodBeat.o(61919);
  }
  
  protected final void bCK()
  {
    AppMethodBeat.i(61920);
    if (this.mXF != null) {
      this.mXF.setVisibility(8);
    }
    AppMethodBeat.o(61920);
  }
  
  protected final void bCz()
  {
    AppMethodBeat.i(61923);
    super.bCz();
    Object localObject = com.tencent.mm.pluginsdk.ui.d.j.b(this, f.a(getString(2131300234), "", com.tencent.mm.plugin.fts.a.a.d.b(this.query, this.query)).mSp, com.tencent.mm.cb.a.ao(this, 2131427809));
    this.mXM.setText((CharSequence)localObject);
    localObject = null;
    if (com.tencent.mm.plugin.fts.a.d.Pc(this.query)) {
      localObject = f.a(getString(2131300204), "", com.tencent.mm.plugin.fts.a.a.d.b(this.query, this.query)).mSp;
    }
    for (;;)
    {
      localObject = com.tencent.mm.pluginsdk.ui.d.j.b(this, (CharSequence)localObject, com.tencent.mm.cb.a.ao(this, 2131427809));
      this.mXQ.setText((CharSequence)localObject);
      AppMethodBeat.o(61923);
      return;
      if (com.tencent.mm.plugin.fts.a.d.Pd(this.query)) {
        localObject = f.a(getString(2131300205), "", com.tencent.mm.plugin.fts.a.a.d.b(this.query, this.query)).mSp;
      }
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(61906);
    int i = 100;
    if (!getController().hideVKB()) {
      i = 0;
    }
    al.p(new FTSMainUI.21(this), i);
    AppMethodBeat.o(61906);
  }
  
  public final View getFooterView()
  {
    AppMethodBeat.i(61914);
    if (this.mXE == null)
    {
      this.mXE = ((LinearLayout)getLayoutInflater().inflate(2130969663, null));
      this.mXM = ((TextView)this.mXE.findViewById(2131824361));
      this.mXN = ((TextView)this.mXE.findViewById(2131824362));
    }
    try
    {
      Object localObject = ac.agv("webSearchBar").optString("wording");
      ab.i("MicroMsg.FTS.FTSMainUI", "set searchNetworkTips %s", new Object[] { localObject });
      this.mXN.setText((CharSequence)localObject);
      label103:
      this.mXK = this.mXE.findViewById(2131824358);
      this.mXJ = this.mXE.findViewById(2131824357);
      this.mXE.findViewById(2131824360).setOnClickListener(new FTSMainUI.2(this));
      this.mXS = this.mXE.findViewById(2131824359);
      this.mXR = ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.websearch.api.h.class)).a((LinearLayout)this.mXS, com.tencent.mm.cb.a.ar(ah.getContext(), ah.getResources().getDisplayMetrics().widthPixels) - 26, this, this.mYf);
      this.mXL = new FTSLocalPageRelevantView(this);
      this.mXL.setOnRelevantClickListener(new FTSMainUI.3(this));
      int i = this.mXE.indexOfChild(this.mXJ);
      if ((i >= 0) && (i < this.mXE.getChildCount())) {
        this.mXE.addView(this.mXL, i + 1);
      }
      this.mXQ = ((TextView)this.mXE.findViewById(2131824356));
      this.mXP = this.mXE.findViewById(2131824354);
      this.mXO = this.mXE.findViewById(2131824355);
      this.mXO.setOnClickListener(new FTSMainUI.4(this));
      this.mXF = ((LinearLayout)this.mXE.findViewById(2131824363));
      localObject = this.mXE;
      AppMethodBeat.o(61914);
      return localObject;
    }
    catch (Exception localException)
    {
      break label103;
    }
  }
  
  public int getLayoutId()
  {
    return 2130969666;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(61900);
    finish();
    AppMethodBeat.o(61900);
  }
  
  public void onClickWxApp(View paramView)
  {
    AppMethodBeat.i(61924);
    if (paramView.getTag().equals("more-click"))
    {
      ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.service.n.class)).a(this, String.valueOf(com.tencent.mm.plugin.fts.a.e.mRk), n.a.iJs);
      AppMethodBeat.o(61924);
      return;
    }
    if (paramView.getTag().equals("more-swipe"))
    {
      ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.service.n.class)).a(this, String.valueOf(com.tencent.mm.plugin.fts.a.e.mRk), n.a.iJt);
      AppMethodBeat.o(61924);
      return;
    }
    ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.service.n.class)).a(this, (n.c)paramView.getTag(), String.valueOf(com.tencent.mm.plugin.fts.a.e.mRk));
    AppMethodBeat.o(61924);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(61898);
    super.onCreate(paramBundle);
    this.iiW = ah.getResources().getDisplayMetrics().widthPixels;
    this.iiX = ah.getResources().getDisplayMetrics().heightPixels;
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = TransitionInflater.from(this).inflateTransition(17760258);
      TransitionInflater.from(this).inflateTransition(17760258);
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(2131820956), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    this.mYa = ((KeyboardLinearLayout)findViewById(2131821003));
    this.mYa.setOnkbdStateListener(new FTSMainUI.12(this));
    this.mWR.setHint(getString(2131297065));
    com.tencent.mm.plugin.fts.a.e.mRk = com.tencent.mm.plugin.fts.a.d.wp(3);
    paramBundle = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(this.ibk), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(com.tencent.mm.plugin.fts.a.e.mRk), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", Integer.valueOf(1), Integer.valueOf(0), "0,0,0,0,0,0", "", "", "", "", "", "", "", "", "", Long.valueOf(com.tencent.mm.plugin.fts.a.e.mRk), Integer.valueOf(0) });
    ab.d("MicroMsg.FTS.FTSReportLogic", "reportFTSEnterClick: %d, %s", new Object[] { Integer.valueOf(10991), paramBundle });
    com.tencent.mm.plugin.report.service.h.qsU.kvStat(10991, paramBundle);
    this.mXD = ((FTSMainUIEducationLayout)findViewById(2131824367));
    this.mXI = ((LinearLayout)findViewById(2131824326));
    this.mXD.setOnCellClickListener(this.mYg);
    this.mXD.setOnHotwordClickListener(new FTSMainUI.16(this));
    this.mXD.setNeedHotWord(false);
    com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.widget.recentview.d.class);
    com.tencent.mm.sdk.g.d.ysm.b(new FTSMainUI.18(this), "FTSMainUI.GetLocation");
    if (((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader() == null)
    {
      finish();
      AppMethodBeat.o(61898);
      return;
    }
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().bBL();
    ac.Jq(3);
    com.tencent.mm.sdk.b.a.ymk.b(this.mYh);
    com.tencent.mm.sdk.g.d.post(new FTSMainUI.15(this), "init-widget-switch");
    AppMethodBeat.o(61898);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    boolean bool3 = true;
    AppMethodBeat.i(61899);
    boolean bool4 = super.onCreateOptionsMenu(paramMenu);
    if ((com.tencent.mm.sdk.platformtools.aa.dsC()) || (com.tencent.mm.sdk.platformtools.aa.dsG().equals("en"))) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(61899);
      return bool4;
    }
    paramMenu = (FTSVoiceInputLayoutImpl)findViewById(2131824369);
    TextView localTextView = (TextView)findViewById(2131824365);
    ProgressBar localProgressBar = (ProgressBar)findViewById(2131824366);
    if ((paramMenu == null) || (localTextView == null) || (localProgressBar == null))
    {
      boolean bool1;
      boolean bool2;
      if (paramMenu == null)
      {
        bool1 = true;
        if (localTextView != null) {
          break label172;
        }
        bool2 = true;
        label117:
        if (localProgressBar != null) {
          break label178;
        }
      }
      for (;;)
      {
        ab.w("MicroMsg.FTS.FTSMainUI", "voicePanel == null || sayTv == null || loadingIv == null, %s, %s, %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        AppMethodBeat.o(61899);
        return bool4;
        bool1 = false;
        break;
        label172:
        bool2 = false;
        break label117;
        label178:
        bool3 = false;
      }
    }
    this.mXG = new com.tencent.mm.plugin.fts.ui.widget.c(this, paramMenu, localTextView, localProgressBar);
    this.mXG.nbL = new FTSMainUI.17(this);
    AppMethodBeat.o(61899);
    return bool4;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(61904);
    com.tencent.mm.sdk.g.d.ysm.remove("FTSMainUI.GetLocation");
    com.tencent.mm.modelgeo.d.agQ().c(this);
    if (((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader() != null) {
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().bBM();
    }
    com.tencent.mm.sdk.b.a.ymk.d(this.mYh);
    if (this.mXG != null)
    {
      Object localObject = this.mXG;
      if (((com.tencent.mm.plugin.fts.ui.widget.c)localObject).nbN != null)
      {
        ((com.tencent.mm.plugin.fts.ui.widget.c)localObject).nbN.amT();
        localObject = ((com.tencent.mm.plugin.fts.ui.widget.c)localObject).nbN;
        if (((VoiceInputLayout)localObject).ipC != null) {
          ((VoiceInputLayout)localObject).ipC.removeCallbacksAndMessages(null);
        }
        if (((VoiceInputLayout)localObject).ncp != null) {
          ((VoiceInputLayout)localObject).ncp.removeCallbacksAndMessages(null);
        }
        if (((VoiceInputLayout)localObject).gcG != null) {
          ((VoiceInputLayout)localObject).gcG.stopTimer();
        }
      }
    }
    if (this.mXR != null) {
      this.mXR.onDestroy();
    }
    super.onDestroy();
    AppMethodBeat.o(61904);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(61905);
    super.onResume();
    runOnUiThread(new FTSMainUI.20(this));
    uj localuj = new uj();
    localuj.cKS.cps = 0L;
    com.tencent.mm.sdk.b.a.ymk.l(localuj);
    com.tencent.mm.cn.d.aNX();
    if (this.mXJ != null) {
      this.mXJ.setEnabled(true);
    }
    if (!bo.isNullOrNil(this.mXX))
    {
      this.query = this.mXX;
      this.mXX = null;
    }
    com.tencent.mm.plugin.websearch.api.aa.cZq();
    if (this.mXR != null) {
      this.mXR.onResume();
    }
    AppMethodBeat.o(61905);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(61901);
    hideVKB();
    super.onStop();
    if (this.mXR != null) {
      this.mXR.onPause();
    }
    AppMethodBeat.o(61901);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final boolean wR(String paramString)
  {
    AppMethodBeat.i(61917);
    super.wR(paramString);
    bCT();
    AppMethodBeat.o(61917);
    return false;
  }
  
  public final void wS(String paramString)
  {
    AppMethodBeat.i(61922);
    if ((this.mXG == null) || (!this.mXG.nbM)) {
      super.wS(paramString);
    }
    this.mXY = false;
    AppMethodBeat.o(61922);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI
 * JD-Core Version:    0.7.0.1
 */