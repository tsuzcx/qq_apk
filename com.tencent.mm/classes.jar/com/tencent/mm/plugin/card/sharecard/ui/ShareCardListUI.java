package com.tencent.mm.plugin.card.sharecard.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.plugin.card.ui.CardDetailUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;

public class ShareCardListUI
  extends CardBaseUI
  implements com.tencent.mm.plugin.card.base.d, MStorage.IOnStorageChange
{
  private String cardTpId = null;
  private long mStartTime = 0L;
  private b.a pVL = null;
  private f pXB;
  private e pXC;
  private i pXD;
  private boolean pXE = false;
  private boolean pXF = true;
  private boolean pXG = false;
  private boolean pXH = true;
  private boolean pXI = true;
  private boolean pXJ = false;
  private String pXK = "";
  private boolean pXL = false;
  private boolean pXM = false;
  private boolean pXN = false;
  private int pXO = 0;
  private boolean pXP = false;
  private long pXQ = 0L;
  boolean pXR = false;
  private boolean pXS = false;
  private com.tencent.mm.plugin.card.sharecard.a.b pXs;
  private long ptl = 0L;
  private final long ptm = 500L;
  private boolean ptn = false;
  
  private void cuN()
  {
    AppMethodBeat.i(113111);
    Log.d("MicroMsg.ShareCardListUI", "initLocation");
    com.tencent.f.h.RTc.b(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(113100);
        ShareCardListUI.a(ShareCardListUI.this);
        ShareCardListUI.b(ShareCardListUI.this);
        ShareCardListUI.this.pXR = true;
        Log.d("MicroMsg.ShareCardListUI", "initLocation end");
        AppMethodBeat.o(113100);
      }
    }, "MicroMsg.ShareCardListUI");
    AppMethodBeat.o(113111);
  }
  
  private void cuO()
  {
    AppMethodBeat.i(113115);
    long l = System.currentTimeMillis() - this.ptl;
    if ((this.ptn) && (l < 1000L))
    {
      Log.d("MicroMsg.ShareCardListUI", "DoingUpdateView return");
      AppMethodBeat.o(113115);
      return;
    }
    Log.d("MicroMsg.ShareCardListUI", "try2UpdateView isDoingUpdateView %s,interval %s", new Object[] { Boolean.valueOf(this.ptn), Long.valueOf(l) });
    this.ptn = true;
    if (l < 500L)
    {
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(113103);
          ShareCardListUI.i(ShareCardListUI.this);
          if (!ShareCardListUI.this.isFinishing())
          {
            ShareCardListUI.j(ShareCardListUI.this);
            AppMethodBeat.o(113103);
            return;
          }
          Log.w("MicroMsg.ShareCardListUI", "Activity is finished!!!");
          AppMethodBeat.o(113103);
        }
      }, 500L);
      AppMethodBeat.o(113115);
      return;
    }
    updateView();
    this.ptl = System.currentTimeMillis();
    this.ptn = false;
    AppMethodBeat.o(113115);
  }
  
  private void cuP()
  {
    AppMethodBeat.i(113117);
    if (this.pQq.getEmptyView() != this.pQs)
    {
      this.pQq.setEmptyView(this.pQs);
      this.pQq.invalidate();
    }
    AppMethodBeat.o(113117);
  }
  
  private void cuQ()
  {
    AppMethodBeat.i(113118);
    if ((!com.tencent.mm.plugin.card.sharecard.a.b.cuz()) && (!com.tencent.mm.plugin.card.sharecard.a.b.cuy()))
    {
      this.pXC.cuK();
      this.pQq.setEmptyView(null);
      this.pQq.invalidate();
      this.pXS = true;
    }
    AppMethodBeat.o(113118);
  }
  
  private void cuR()
  {
    AppMethodBeat.i(113119);
    if (this.pQq.getEmptyView() != null)
    {
      this.pQq.setEmptyView(null);
      this.pQq.invalidate();
    }
    AppMethodBeat.o(113119);
  }
  
  private void cuS()
  {
    AppMethodBeat.i(113120);
    if ((this.pQr instanceof c)) {
      ((c)this.pQr).Eo(this.pXO);
    }
    AppMethodBeat.o(113120);
  }
  
  private void cuT()
  {
    AppMethodBeat.i(113123);
    if ((com.tencent.mm.plugin.card.sharecard.a.b.cuB()) && (com.tencent.mm.plugin.card.sharecard.a.b.cuC()))
    {
      Log.i("MicroMsg.ShareCardListUI", "doGetLayout() no data to load");
      this.pXI = true;
      AppMethodBeat.o(113123);
      return;
    }
    if ((!com.tencent.mm.plugin.card.sharecard.a.b.cuB()) || (!com.tencent.mm.plugin.card.sharecard.a.b.cuC())) {
      this.pXH = false;
    }
    Log.i("MicroMsg.ShareCardListUI", "doGetLayout() >> doNetSceneGetCardsHomePageLayout()");
    cuU();
    am.ctW().G("", "", 4);
    AppMethodBeat.o(113123);
  }
  
  private void cuU()
  {
    AppMethodBeat.i(113124);
    if (this.pXJ)
    {
      Log.e("MicroMsg.ShareCardListUI", "doNetSceneGetCardsHomePageLayout, isDoingGetData is true");
      AppMethodBeat.o(113124);
      return;
    }
    if ((Util.isNullOrNil(this.pXK)) && (!com.tencent.mm.plugin.card.sharecard.a.b.cuz()) && (!com.tencent.mm.plugin.card.sharecard.a.b.cuy())) {
      cuQ();
    }
    if ((this.pXH) && (!Util.isNullOrNil(this.pXK))) {
      this.pXK = "";
    }
    this.pXJ = true;
    com.tencent.mm.plugin.card.sharecard.model.b localb = new com.tencent.mm.plugin.card.sharecard.model.b(am.ctW().gmu, am.ctW().gmv, this.pXK);
    g.aAg().hqi.a(localb, 0);
    AppMethodBeat.o(113124);
  }
  
  private void cuV()
  {
    AppMethodBeat.i(113130);
    if ((this.pXO == 0) || (this.pXO == 4) || ((this.pXO == 2) && ((!com.tencent.mm.plugin.card.sharecard.a.b.cuz()) || (!com.tencent.mm.plugin.card.sharecard.a.b.cuy()))) || ((this.pXO == 1) && ((!com.tencent.mm.plugin.card.sharecard.a.b.cuz()) || (com.tencent.mm.plugin.card.sharecard.a.b.cuy()))) || ((this.pXO == 3) && ((!com.tencent.mm.plugin.card.sharecard.a.b.cuy()) || (com.tencent.mm.plugin.card.sharecard.a.b.cuz())))) {
      this.pXO = com.tencent.mm.plugin.card.sharecard.a.b.cux();
    }
    am.ctV().putValue("key_share_card_show_type", Integer.valueOf(this.pXO));
    AppMethodBeat.o(113130);
  }
  
  private void cuW()
  {
    AppMethodBeat.i(113133);
    int i = getIntent().getIntExtra("key_from_scene", 22);
    boolean bool1 = com.tencent.mm.y.c.axV().cO(262152, 266256);
    boolean bool2 = com.tencent.mm.y.c.axV().cP(262152, 266256);
    boolean bool3 = com.tencent.mm.y.c.axV().a(ar.a.NTN, ar.a.NTP);
    boolean bool4 = com.tencent.mm.y.c.axV().a(ar.a.NTO, ar.a.NTQ);
    String str = Util.nullAsNil((String)g.aAh().azQ().get(ar.a.NTT, null));
    if (bool1)
    {
      com.tencent.mm.plugin.report.service.h.CyF.a(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(2), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113133);
      return;
    }
    if (bool2)
    {
      com.tencent.mm.plugin.report.service.h.CyF.a(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113133);
      return;
    }
    if ((bool3) && (!bool4))
    {
      com.tencent.mm.plugin.report.service.h.CyF.a(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(3), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113133);
      return;
    }
    if ((bool3) && (bool4))
    {
      com.tencent.mm.plugin.report.service.h.CyF.a(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(4), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113133);
      return;
    }
    if (bool4)
    {
      com.tencent.mm.plugin.report.service.h.CyF.a(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(5), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113133);
      return;
    }
    com.tencent.mm.plugin.report.service.h.CyF.a(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(i), "", Integer.valueOf(0), str });
    AppMethodBeat.o(113133);
  }
  
  private void kv(boolean paramBoolean)
  {
    AppMethodBeat.i(113107);
    Log.i("MicroMsg.ShareCardListUI", "doRefreshData() >> updateView() shouldGetLayout %s fromOnresume %s", new Object[] { Boolean.valueOf(this.pXF), Boolean.valueOf(paramBoolean) });
    if (this.pXF)
    {
      this.pXF = false;
      this.pXL = false;
      this.pXH = true;
      this.pXK = "";
      Log.d("MicroMsg.ShareCardListUI", "doRefreshData() >> doNetSceneGetCardsHomePageLayout()");
      if (!paramBoolean) {
        break label104;
      }
      if ((this.pXP) && (this.pXR)) {
        cso();
      }
    }
    for (;;)
    {
      cuO();
      AppMethodBeat.o(113107);
      return;
      label104:
      cuU();
    }
  }
  
  private void updateView()
  {
    AppMethodBeat.i(113116);
    cuV();
    Log.i("MicroMsg.ShareCardListUI", "updateView() currentType is %s, canShowLocalCity %s, canShowOtherCity %s", new Object[] { Integer.valueOf(this.pXO), Boolean.valueOf(com.tencent.mm.plugin.card.sharecard.a.b.cuz()), Boolean.valueOf(com.tencent.mm.plugin.card.sharecard.a.b.cuy()) });
    this.pXB.updateView();
    if ((!com.tencent.mm.plugin.card.sharecard.a.b.cuz()) && (!com.tencent.mm.plugin.card.sharecard.a.b.cuy()))
    {
      this.pXC.cnh();
      this.pXD.cuX();
      cuP();
    }
    for (;;)
    {
      cuS();
      AppMethodBeat.o(113116);
      return;
      this.pXC.updateView();
      this.pXD.updateView();
      if (this.pXO == 4) {
        cuR();
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113127);
    super.a(paramb);
    AppMethodBeat.o(113127);
  }
  
  public final void a(com.tencent.mm.plugin.card.base.b paramb, int paramInt)
  {
    AppMethodBeat.i(113128);
    Object localObject = new Intent(this, CardDetailUI.class);
    Log.i("MicroMsg.ShareCardListUI", "card tp id:" + paramb.csV());
    Log.i("MicroMsg.ShareCardListUI", "card id:" + paramb.csU());
    ((Intent)localObject).putExtra("key_card_id", am.ctY().ajy(paramb.csV()));
    ((Intent)localObject).putExtra("key_card_tp_id", paramb.csV());
    ((Intent)localObject).putExtra("key_is_share_card", true);
    ((Intent)localObject).putExtra("key_from_scene", 3);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/card/sharecard/ui/ShareCardListUI", "onGotoCardDetailUI", "(Lcom/tencent/mm/plugin/card/base/ICardInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/sharecard/ui/ShareCardListUI", "onGotoCardDetailUI", "(Lcom/tencent/mm/plugin/card/base/ICardInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.plugin.card.sharecard.a.b.ajv(paramb.csV());
    AppMethodBeat.o(113128);
  }
  
  public final BaseAdapter anl()
  {
    AppMethodBeat.i(113109);
    c localc = new c(getContext());
    AppMethodBeat.o(113109);
    return localc;
  }
  
  public final void b(com.tencent.mm.plugin.card.base.b paramb, int paramInt)
  {
    AppMethodBeat.i(113126);
    if (paramb != null) {
      com.tencent.mm.plugin.card.sharecard.a.b.ajq(paramb.csV());
    }
    super.b(paramb, paramInt);
    AppMethodBeat.o(113126);
  }
  
  public final void csj()
  {
    AppMethodBeat.i(113113);
    setMMTitle(2131757147);
    this.pXs = new com.tencent.mm.plugin.card.sharecard.a.b(this);
    this.pVL = new b.a() {};
    this.pXs.pVL = this.pVL;
    this.pXs.init();
    this.pXO = com.tencent.mm.plugin.card.sharecard.a.b.cux();
    Object localObject;
    if (this.pXD == null)
    {
      this.pXD = new i(this, getContentView());
      localObject = this.pXD;
      ((i)localObject).pXU = View.inflate(((i)localObject).pQZ, 2131493434, null);
      ((i)localObject).pXV = ((TextView)((i)localObject).pXU.findViewById(2131298150));
      ((i)localObject).pXW = ((TextView)((i)localObject).pXU.findViewById(2131298154));
      ((i)localObject).updateView();
    }
    if (this.pXB == null)
    {
      this.pXB = new f(this, getContentView());
      localObject = this.pXB;
      ((f)localObject).pXw = ((ImageView)((f)localObject).jBN.findViewById(2131305443));
      ((f)localObject).pXy = ((TextView)((f)localObject).jBN.findViewById(2131305445));
      ((f)localObject).pXx = ((TextView)((f)localObject).jBN.findViewById(2131305446));
      this.pXB.pXs = this.pXs;
    }
    if (this.pXC == null)
    {
      getContentView();
      this.pXC = new e(this);
      this.pXC.pXs = this.pXs;
      this.pXC.cuI();
      localObject = this.pXC;
      View.OnClickListener local3 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113101);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/sharecard/ui/ShareCardListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          ShareCardListUI.c(ShareCardListUI.this);
          if (com.tencent.mm.plugin.card.sharecard.a.b.cuz())
          {
            ShareCardListUI.c(ShareCardListUI.this);
            if (com.tencent.mm.plugin.card.sharecard.a.b.cuy()) {
              ShareCardListUI.a(ShareCardListUI.this, 2);
            }
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.CyF.a(11582, new Object[] { "OperChangeOtherCity ", Integer.valueOf(0), Integer.valueOf(0), "", "", "" });
            am.ctV().putValue("key_share_card_show_type", Integer.valueOf(ShareCardListUI.d(ShareCardListUI.this)));
            ShareCardListUI.e(ShareCardListUI.this);
            ShareCardListUI.f(ShareCardListUI.this).updateView();
            ShareCardListUI.c(ShareCardListUI.this);
            com.tencent.mm.plugin.card.sharecard.a.b.pVM = true;
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/sharecard/ui/ShareCardListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(113101);
            return;
            ShareCardListUI.c(ShareCardListUI.this);
            if (com.tencent.mm.plugin.card.sharecard.a.b.cuy()) {
              ShareCardListUI.a(ShareCardListUI.this, 3);
            }
          }
        }
      };
      if (((e)localObject).pXr != null) {
        ((e)localObject).pXr.setOnClickListener(local3);
      }
    }
    if (this.pQt != null) {
      this.pQt.addView(this.pXD.pXU);
    }
    if (this.pQu != null) {
      this.pQu.addView(this.pXC.pXr);
    }
    this.pQq.setVisibility(0);
    this.pQq.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(113102);
        if ((paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1) && (!ShareCardListUI.g(ShareCardListUI.this)) && (ShareCardListUI.d(ShareCardListUI.this) != 4))
        {
          Log.d("MicroMsg.ShareCardListUI", "onScroll() >> doNetSceneGetCardsHomePageLayout()");
          ShareCardListUI.h(ShareCardListUI.this);
        }
        AppMethodBeat.o(113102);
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    if ((getIntent() != null) && (getIntent().getBooleanExtra("KEY_IS_SHOW_SHARE_CARD_ENTRANCE_TIPS", true)))
    {
      localObject = (Integer)g.aAh().azQ().get(ar.a.NUf, Integer.valueOf(0));
      if ((localObject == null) || (((Integer)localObject).intValue() != 1))
      {
        g.aAh().azQ().set(ar.a.NUf, Integer.valueOf(1));
        com.tencent.mm.plugin.card.d.d.c(this, 2131493441, 2131757157, "");
      }
    }
    for (;;)
    {
      this.cardTpId = getIntent().getStringExtra("KEY_CARD_TP_ID");
      this.pXK = getIntent().getStringExtra("key_layout_buff");
      if (!Util.isNullOrNil(this.pXK)) {
        this.pXF = false;
      }
      if (!Util.isNullOrNil(this.cardTpId))
      {
        this.pXE = true;
        this.pXG = true;
      }
      AppMethodBeat.o(113113);
      return;
      localObject = (Integer)g.aAh().azQ().get(ar.a.NUf, Integer.valueOf(0));
      if ((localObject != null) && (((Integer)localObject).intValue() != 1)) {
        g.aAh().azQ().set(ar.a.NUf, Integer.valueOf(1));
      }
    }
  }
  
  public final boolean csl()
  {
    AppMethodBeat.i(113125);
    boolean bool = super.csl();
    AppMethodBeat.o(113125);
    return bool;
  }
  
  public final boolean csm()
  {
    return false;
  }
  
  public final void csq()
  {
    AppMethodBeat.i(113121);
    this.pXN = true;
    if (this.pXL)
    {
      Log.e("MicroMsg.ShareCardListUI", "onLocationFinish, has do GetShareCardLayout,don't get again");
      if (this.pXP) {
        csp();
      }
      AppMethodBeat.o(113121);
      return;
    }
    Log.d("MicroMsg.ShareCardListUI", "onLocationFinish()");
    this.pXL = true;
    cuT();
    csp();
    AppMethodBeat.o(113121);
  }
  
  public final void csr()
  {
    AppMethodBeat.i(113122);
    if ((this.pXM) || (this.pXL))
    {
      csp();
      AppMethodBeat.o(113122);
      return;
    }
    this.pXM = true;
    Log.i("MicroMsg.ShareCardListUI", "onLocationFail()");
    cuT();
    AppMethodBeat.o(113122);
  }
  
  public final void css()
  {
    AppMethodBeat.i(113112);
    Log.i("MicroMsg.ShareCardListUI", "onMPermissionGranted LocationPermissionGranted " + this.pXP);
    if (!this.pXP)
    {
      this.pXP = true;
      cuN();
    }
    AppMethodBeat.o(113112);
  }
  
  public final void ctb()
  {
    AppMethodBeat.i(113131);
    com.tencent.mm.plugin.card.sharecard.a.b.cuw();
    this.pXF = true;
    Log.i("MicroMsg.ShareCardListUI", "onDBchange() shouldRefreshDataOnDbChange %s  mIsActive %s hasLocationInfo %s", new Object[] { Boolean.valueOf(this.pXG), Boolean.valueOf(this.pQw), Boolean.valueOf(this.pXN) });
    if ((this.pXG) && (this.pQw) && (this.pXN)) {
      kv(false);
    }
    for (;;)
    {
      this.pXG = false;
      AppMethodBeat.o(113131);
      return;
      cuO();
    }
  }
  
  public void initView()
  {
    AppMethodBeat.i(113110);
    super.initView();
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 69, null, null);
    Log.i("MicroMsg.ShareCardListUI", "checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
    this.pXP = bool;
    if (this.pXP)
    {
      cuN();
      AppMethodBeat.o(113110);
      return;
    }
    Log.e("MicroMsg.ShareCardListUI", "location permission is denied, doGetLayout");
    cuT();
    AppMethodBeat.o(113110);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113104);
    super.onCreate(paramBundle);
    long l = System.currentTimeMillis();
    this.mStartTime = l;
    this.pXQ = l;
    initView();
    g.aAg().hqi.a(1164, this);
    am.ctX().a(this);
    cuW();
    am.ctY().add(this);
    AppMethodBeat.o(113104);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113105);
    if (this.pXP) {
      csp();
    }
    this.pXB.pXs = null;
    this.pXC.pXs = null;
    this.pXs.pVL = null;
    g.aAg().hqi.b(1164, this);
    am.ctX().b(this);
    com.tencent.mm.plugin.card.sharecard.a.b.cuA();
    am.ctY().remove(this);
    long l = System.currentTimeMillis() - this.pXQ;
    if (!TextUtils.isEmpty(this.cardTpId)) {
      com.tencent.mm.plugin.report.service.h.CyF.a(13219, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Long.valueOf(l) });
    }
    for (;;)
    {
      super.onDestroy();
      AppMethodBeat.o(113105);
      return;
      com.tencent.mm.plugin.report.service.h.CyF.a(13219, new Object[] { "ShareCardListUI", Integer.valueOf(1), "", "", Long.valueOf(l) });
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(113114);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    cuW();
    if (paramIntent != null)
    {
      this.cardTpId = paramIntent.getStringExtra("KEY_CARD_TP_ID");
      if (!Util.isNullOrNil(this.cardTpId))
      {
        this.pXE = true;
        this.pXG = true;
      }
    }
    AppMethodBeat.o(113114);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(113132);
    Log.d("MicroMsg.ShareCardListUI", "onNotifyChange");
    this.pXF = true;
    AppMethodBeat.o(113132);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(113108);
    super.onPause();
    this.pXF = false;
    this.pXG = true;
    AppMethodBeat.o(113108);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(113106);
    kv(true);
    long l = System.currentTimeMillis();
    if (this.mStartTime != 0L)
    {
      int i = (int)(l - this.mStartTime);
      ArrayList localArrayList = new ArrayList();
      IDKey localIDKey1 = new IDKey();
      localIDKey1.SetID(281);
      localIDKey1.SetKey(56);
      localIDKey1.SetValue(1L);
      IDKey localIDKey2 = new IDKey();
      localIDKey2.SetID(281);
      localIDKey2.SetKey(57);
      localIDKey2.SetValue(i);
      localArrayList.add(localIDKey1);
      localArrayList.add(localIDKey2);
      com.tencent.mm.plugin.report.service.h.CyF.b(localArrayList, true);
      this.mStartTime = 0L;
    }
    super.onResume();
    AppMethodBeat.o(113106);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    boolean bool = true;
    AppMethodBeat.i(113129);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof com.tencent.mm.plugin.card.sharecard.model.b))
      {
        paramString = (com.tencent.mm.plugin.card.sharecard.model.b)paramq;
        this.pXJ = false;
        this.pXK = paramString.pVT;
        this.pXs.aL(paramString.pTY, this.pXH);
        if ((!com.tencent.mm.plugin.card.sharecard.a.b.cuB()) || (!com.tencent.mm.plugin.card.sharecard.a.b.cuC())) {
          this.pXH = false;
        }
        if ((com.tencent.mm.plugin.card.sharecard.a.b.cuB()) && (com.tencent.mm.plugin.card.sharecard.a.b.cuC())) {}
        for (;;)
        {
          this.pXI = bool;
          Log.i("MicroMsg.ShareCardListUI", "NetSceneGetShareCardsLayout() >> updateView()");
          cuO();
          AppMethodBeat.o(113129);
          return;
          bool = false;
        }
      }
    }
    else
    {
      if ((paramq instanceof com.tencent.mm.plugin.card.sharecard.model.b))
      {
        if (this.pXS)
        {
          this.pXS = false;
          this.pXC.cuL();
          this.pQq.setEmptyView(this.pQs);
          this.pQq.invalidate();
        }
        this.pXJ = false;
        this.pXI = true;
      }
      Log.i("MicroMsg.ShareCardListUI", "share card list ui, onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    AppMethodBeat.o(113129);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.ShareCardListUI
 * JD-Core Version:    0.7.0.1
 */