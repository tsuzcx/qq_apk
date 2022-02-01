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
import com.tencent.e.h;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.plugin.card.ui.CardDetailUI;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.ArrayList;

public class ShareCardListUI
  extends CardBaseUI
  implements com.tencent.mm.plugin.card.base.d, k.a
{
  private long mStartTime = 0L;
  private String oFe = null;
  private b.a oHX = null;
  private com.tencent.mm.plugin.card.sharecard.a.b oJE;
  private f oJN;
  private e oJO;
  private i oJP;
  private boolean oJQ = false;
  private boolean oJR = true;
  private boolean oJS = false;
  private boolean oJT = true;
  private boolean oJU = true;
  private boolean oJV = false;
  private String oJW = "";
  private boolean oJX = false;
  private boolean oJY = false;
  private boolean oJZ = false;
  private int oKa = 0;
  private boolean oKb = false;
  private long oKc = 0L;
  boolean oKd = false;
  private boolean oKe = false;
  private long ohI = 0L;
  private final long ohJ = 500L;
  private boolean ohK = false;
  
  private void bWX()
  {
    AppMethodBeat.i(113111);
    ae.d("MicroMsg.ShareCardListUI", "initLocation");
    h.MqF.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(113100);
        ShareCardListUI.a(ShareCardListUI.this);
        ShareCardListUI.b(ShareCardListUI.this);
        ShareCardListUI.this.oKd = true;
        ae.d("MicroMsg.ShareCardListUI", "initLocation end");
        AppMethodBeat.o(113100);
      }
    }, "MicroMsg.ShareCardListUI");
    AppMethodBeat.o(113111);
  }
  
  private void bWY()
  {
    AppMethodBeat.i(113115);
    long l = System.currentTimeMillis() - this.ohI;
    if ((this.ohK) && (l < 1000L))
    {
      ae.d("MicroMsg.ShareCardListUI", "DoingUpdateView return");
      AppMethodBeat.o(113115);
      return;
    }
    ae.d("MicroMsg.ShareCardListUI", "try2UpdateView isDoingUpdateView %s,interval %s", new Object[] { Boolean.valueOf(this.ohK), Long.valueOf(l) });
    this.ohK = true;
    if (l < 500L)
    {
      ar.o(new Runnable()
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
          ae.w("MicroMsg.ShareCardListUI", "Activity is finished!!!");
          AppMethodBeat.o(113103);
        }
      }, 500L);
      AppMethodBeat.o(113115);
      return;
    }
    updateView();
    this.ohI = System.currentTimeMillis();
    this.ohK = false;
    AppMethodBeat.o(113115);
  }
  
  private void bWZ()
  {
    AppMethodBeat.i(113117);
    if (this.oCH.getEmptyView() != this.oCJ)
    {
      this.oCH.setEmptyView(this.oCJ);
      this.oCH.invalidate();
    }
    AppMethodBeat.o(113117);
  }
  
  private void bXa()
  {
    AppMethodBeat.i(113118);
    if ((!com.tencent.mm.plugin.card.sharecard.a.b.bWI()) && (!com.tencent.mm.plugin.card.sharecard.a.b.bWH()))
    {
      this.oJO.bWT();
      this.oCH.setEmptyView(null);
      this.oCH.invalidate();
      this.oKe = true;
    }
    AppMethodBeat.o(113118);
  }
  
  private void bXb()
  {
    AppMethodBeat.i(113119);
    if (this.oCH.getEmptyView() != null)
    {
      this.oCH.setEmptyView(null);
      this.oCH.invalidate();
    }
    AppMethodBeat.o(113119);
  }
  
  private void bXc()
  {
    AppMethodBeat.i(113120);
    if ((this.oCI instanceof c)) {
      ((c)this.oCI).AJ(this.oKa);
    }
    AppMethodBeat.o(113120);
  }
  
  private void bXd()
  {
    AppMethodBeat.i(113123);
    if ((com.tencent.mm.plugin.card.sharecard.a.b.bWK()) && (com.tencent.mm.plugin.card.sharecard.a.b.bWL()))
    {
      ae.i("MicroMsg.ShareCardListUI", "doGetLayout() no data to load");
      this.oJU = true;
      AppMethodBeat.o(113123);
      return;
    }
    if ((!com.tencent.mm.plugin.card.sharecard.a.b.bWK()) || (!com.tencent.mm.plugin.card.sharecard.a.b.bWL())) {
      this.oJT = false;
    }
    ae.i("MicroMsg.ShareCardListUI", "doGetLayout() >> doNetSceneGetCardsHomePageLayout()");
    bXe();
    am.bWi().H("", "", 4);
    AppMethodBeat.o(113123);
  }
  
  private void bXe()
  {
    AppMethodBeat.i(113124);
    if (this.oJV)
    {
      ae.e("MicroMsg.ShareCardListUI", "doNetSceneGetCardsHomePageLayout, isDoingGetData is true");
      AppMethodBeat.o(113124);
      return;
    }
    if ((bu.isNullOrNil(this.oJW)) && (!com.tencent.mm.plugin.card.sharecard.a.b.bWI()) && (!com.tencent.mm.plugin.card.sharecard.a.b.bWH())) {
      bXa();
    }
    if ((this.oJT) && (!bu.isNullOrNil(this.oJW))) {
      this.oJW = "";
    }
    this.oJV = true;
    com.tencent.mm.plugin.card.sharecard.model.b localb = new com.tencent.mm.plugin.card.sharecard.model.b(am.bWi().fHj, am.bWi().fHk, this.oJW);
    com.tencent.mm.kernel.g.ajQ().gDv.a(localb, 0);
    AppMethodBeat.o(113124);
  }
  
  private void bXf()
  {
    AppMethodBeat.i(113130);
    if ((this.oKa == 0) || (this.oKa == 4) || ((this.oKa == 2) && ((!com.tencent.mm.plugin.card.sharecard.a.b.bWI()) || (!com.tencent.mm.plugin.card.sharecard.a.b.bWH()))) || ((this.oKa == 1) && ((!com.tencent.mm.plugin.card.sharecard.a.b.bWI()) || (com.tencent.mm.plugin.card.sharecard.a.b.bWH()))) || ((this.oKa == 3) && ((!com.tencent.mm.plugin.card.sharecard.a.b.bWH()) || (com.tencent.mm.plugin.card.sharecard.a.b.bWI())))) {
      this.oKa = com.tencent.mm.plugin.card.sharecard.a.b.bWG();
    }
    am.bWh().putValue("key_share_card_show_type", Integer.valueOf(this.oKa));
    AppMethodBeat.o(113130);
  }
  
  private void bXg()
  {
    AppMethodBeat.i(113133);
    int i = getIntent().getIntExtra("key_from_scene", 22);
    boolean bool1 = com.tencent.mm.y.c.ahI().cI(262152, 266256);
    boolean bool2 = com.tencent.mm.y.c.ahI().cJ(262152, 266256);
    boolean bool3 = com.tencent.mm.y.c.ahI().a(am.a.ILL, am.a.ILN);
    boolean bool4 = com.tencent.mm.y.c.ahI().a(am.a.ILM, am.a.ILO);
    String str = bu.nullAsNil((String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ILR, null));
    if (bool1)
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(2), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113133);
      return;
    }
    if (bool2)
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113133);
      return;
    }
    if ((bool3) && (!bool4))
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(3), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113133);
      return;
    }
    if ((bool3) && (bool4))
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(4), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113133);
      return;
    }
    if (bool4)
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(5), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113133);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yxI.f(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(i), "", Integer.valueOf(0), str });
    AppMethodBeat.o(113133);
  }
  
  private void jt(boolean paramBoolean)
  {
    AppMethodBeat.i(113107);
    ae.i("MicroMsg.ShareCardListUI", "doRefreshData() >> updateView() shouldGetLayout %s fromOnresume %s", new Object[] { Boolean.valueOf(this.oJR), Boolean.valueOf(paramBoolean) });
    if (this.oJR)
    {
      this.oJR = false;
      this.oJX = false;
      this.oJT = true;
      this.oJW = "";
      ae.d("MicroMsg.ShareCardListUI", "doRefreshData() >> doNetSceneGetCardsHomePageLayout()");
      if (!paramBoolean) {
        break label104;
      }
      if ((this.oKb) && (this.oKd)) {
        bUA();
      }
    }
    for (;;)
    {
      bWY();
      AppMethodBeat.o(113107);
      return;
      label104:
      bXe();
    }
  }
  
  private void updateView()
  {
    AppMethodBeat.i(113116);
    bXf();
    ae.i("MicroMsg.ShareCardListUI", "updateView() currentType is %s, canShowLocalCity %s, canShowOtherCity %s", new Object[] { Integer.valueOf(this.oKa), Boolean.valueOf(com.tencent.mm.plugin.card.sharecard.a.b.bWI()), Boolean.valueOf(com.tencent.mm.plugin.card.sharecard.a.b.bWH()) });
    this.oJN.updateView();
    if ((!com.tencent.mm.plugin.card.sharecard.a.b.bWI()) && (!com.tencent.mm.plugin.card.sharecard.a.b.bWH()))
    {
      this.oJO.bWW();
      this.oJP.bXh();
      bWZ();
    }
    for (;;)
    {
      bXc();
      AppMethodBeat.o(113116);
      return;
      this.oJO.updateView();
      this.oJP.updateView();
      if (this.oKa == 4) {
        bXb();
      }
    }
  }
  
  public final BaseAdapter Zy()
  {
    AppMethodBeat.i(113109);
    c localc = new c(getContext());
    AppMethodBeat.o(113109);
    return localc;
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
    ae.i("MicroMsg.ShareCardListUI", "card tp id:" + paramb.bVh());
    ae.i("MicroMsg.ShareCardListUI", "card id:" + paramb.bVg());
    ((Intent)localObject).putExtra("key_card_id", am.bWk().Zt(paramb.bVh()));
    ((Intent)localObject).putExtra("key_card_tp_id", paramb.bVh());
    ((Intent)localObject).putExtra("key_is_share_card", true);
    ((Intent)localObject).putExtra("key_from_scene", 3);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/card/sharecard/ui/ShareCardListUI", "onGotoCardDetailUI", "(Lcom/tencent/mm/plugin/card/base/ICardInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/sharecard/ui/ShareCardListUI", "onGotoCardDetailUI", "(Lcom/tencent/mm/plugin/card/base/ICardInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.plugin.card.sharecard.a.b.Zq(paramb.bVh());
    AppMethodBeat.o(113128);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(113132);
    ae.d("MicroMsg.ShareCardListUI", "onNotifyChange");
    this.oJR = true;
    AppMethodBeat.o(113132);
  }
  
  public final void b(com.tencent.mm.plugin.card.base.b paramb, int paramInt)
  {
    AppMethodBeat.i(113126);
    if (paramb != null) {
      com.tencent.mm.plugin.card.sharecard.a.b.Zl(paramb.bVh());
    }
    super.b(paramb, paramInt);
    AppMethodBeat.o(113126);
  }
  
  public final void bUC()
  {
    AppMethodBeat.i(113121);
    this.oJZ = true;
    if (this.oJX)
    {
      ae.e("MicroMsg.ShareCardListUI", "onLocationFinish, has do GetShareCardLayout,don't get again");
      if (this.oKb) {
        bUB();
      }
      AppMethodBeat.o(113121);
      return;
    }
    ae.d("MicroMsg.ShareCardListUI", "onLocationFinish()");
    this.oJX = true;
    bXd();
    bUB();
    AppMethodBeat.o(113121);
  }
  
  public final void bUD()
  {
    AppMethodBeat.i(113122);
    if ((this.oJY) || (this.oJX))
    {
      bUB();
      AppMethodBeat.o(113122);
      return;
    }
    this.oJY = true;
    ae.i("MicroMsg.ShareCardListUI", "onLocationFail()");
    bXd();
    AppMethodBeat.o(113122);
  }
  
  public final void bUE()
  {
    AppMethodBeat.i(113112);
    ae.i("MicroMsg.ShareCardListUI", "onMPermissionGranted LocationPermissionGranted " + this.oKb);
    if (!this.oKb)
    {
      this.oKb = true;
      bWX();
    }
    AppMethodBeat.o(113112);
  }
  
  public final void bUv()
  {
    AppMethodBeat.i(113113);
    setMMTitle(2131756977);
    this.oJE = new com.tencent.mm.plugin.card.sharecard.a.b(this);
    this.oHX = new b.a() {};
    this.oJE.oHX = this.oHX;
    this.oJE.init();
    this.oKa = com.tencent.mm.plugin.card.sharecard.a.b.bWG();
    Object localObject;
    if (this.oJP == null)
    {
      this.oJP = new i(this, getContentView());
      localObject = this.oJP;
      ((i)localObject).oKg = View.inflate(((i)localObject).oDq, 2131493343, null);
      ((i)localObject).oKh = ((TextView)((i)localObject).oKg.findViewById(2131297834));
      ((i)localObject).oKi = ((TextView)((i)localObject).oKg.findViewById(2131297838));
      ((i)localObject).updateView();
    }
    if (this.oJN == null)
    {
      this.oJN = new f(this, getContentView());
      localObject = this.oJN;
      ((f)localObject).oJI = ((ImageView)((f)localObject).iFK.findViewById(2131302870));
      ((f)localObject).oJK = ((TextView)((f)localObject).iFK.findViewById(2131302872));
      ((f)localObject).oJJ = ((TextView)((f)localObject).iFK.findViewById(2131302873));
      this.oJN.oJE = this.oJE;
    }
    if (this.oJO == null)
    {
      getContentView();
      this.oJO = new e(this);
      this.oJO.oJE = this.oJE;
      this.oJO.bWR();
      localObject = this.oJO;
      View.OnClickListener local3 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113101);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/sharecard/ui/ShareCardListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ShareCardListUI.c(ShareCardListUI.this);
          if (com.tencent.mm.plugin.card.sharecard.a.b.bWI())
          {
            ShareCardListUI.c(ShareCardListUI.this);
            if (com.tencent.mm.plugin.card.sharecard.a.b.bWH()) {
              ShareCardListUI.a(ShareCardListUI.this, 2);
            }
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.g.yxI.f(11582, new Object[] { "OperChangeOtherCity ", Integer.valueOf(0), Integer.valueOf(0), "", "", "" });
            am.bWh().putValue("key_share_card_show_type", Integer.valueOf(ShareCardListUI.d(ShareCardListUI.this)));
            ShareCardListUI.e(ShareCardListUI.this);
            ShareCardListUI.f(ShareCardListUI.this).updateView();
            ShareCardListUI.c(ShareCardListUI.this);
            com.tencent.mm.plugin.card.sharecard.a.b.oHY = true;
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/sharecard/ui/ShareCardListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(113101);
            return;
            ShareCardListUI.c(ShareCardListUI.this);
            if (com.tencent.mm.plugin.card.sharecard.a.b.bWH()) {
              ShareCardListUI.a(ShareCardListUI.this, 3);
            }
          }
        }
      };
      if (((e)localObject).oJD != null) {
        ((e)localObject).oJD.setOnClickListener(local3);
      }
    }
    if (this.oCK != null) {
      this.oCK.addView(this.oJP.oKg);
    }
    if (this.oCL != null) {
      this.oCL.addView(this.oJO.oJD);
    }
    this.oCH.setVisibility(0);
    this.oCH.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(113102);
        if ((paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1) && (!ShareCardListUI.g(ShareCardListUI.this)) && (ShareCardListUI.d(ShareCardListUI.this) != 4))
        {
          ae.d("MicroMsg.ShareCardListUI", "onScroll() >> doNetSceneGetCardsHomePageLayout()");
          ShareCardListUI.h(ShareCardListUI.this);
        }
        AppMethodBeat.o(113102);
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    if ((getIntent() != null) && (getIntent().getBooleanExtra("KEY_IS_SHOW_SHARE_CARD_ENTRANCE_TIPS", true)))
    {
      localObject = (Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IMd, Integer.valueOf(0));
      if ((localObject == null) || (((Integer)localObject).intValue() != 1))
      {
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IMd, Integer.valueOf(1));
        com.tencent.mm.plugin.card.d.d.c(this, 2131493350, 2131756987, "");
      }
    }
    for (;;)
    {
      this.oFe = getIntent().getStringExtra("KEY_CARD_TP_ID");
      this.oJW = getIntent().getStringExtra("key_layout_buff");
      if (!bu.isNullOrNil(this.oJW)) {
        this.oJR = false;
      }
      if (!bu.isNullOrNil(this.oFe))
      {
        this.oJQ = true;
        this.oJS = true;
      }
      AppMethodBeat.o(113113);
      return;
      localObject = (Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IMd, Integer.valueOf(0));
      if ((localObject != null) && (((Integer)localObject).intValue() != 1)) {
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IMd, Integer.valueOf(1));
      }
    }
  }
  
  public final boolean bUx()
  {
    AppMethodBeat.i(113125);
    boolean bool = super.bUx();
    AppMethodBeat.o(113125);
    return bool;
  }
  
  public final boolean bUy()
  {
    return false;
  }
  
  public final void bVn()
  {
    AppMethodBeat.i(113131);
    com.tencent.mm.plugin.card.sharecard.a.b.bWF();
    this.oJR = true;
    ae.i("MicroMsg.ShareCardListUI", "onDBchange() shouldRefreshDataOnDbChange %s  mIsActive %s hasLocationInfo %s", new Object[] { Boolean.valueOf(this.oJS), Boolean.valueOf(this.oCN), Boolean.valueOf(this.oJZ) });
    if ((this.oJS) && (this.oCN) && (this.oJZ)) {
      jt(false);
    }
    for (;;)
    {
      this.oJS = false;
      AppMethodBeat.o(113131);
      return;
      bWY();
    }
  }
  
  public void initView()
  {
    AppMethodBeat.i(113110);
    super.initView();
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null);
    ae.i("MicroMsg.ShareCardListUI", "checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
    this.oKb = bool;
    if (this.oKb)
    {
      bWX();
      AppMethodBeat.o(113110);
      return;
    }
    ae.e("MicroMsg.ShareCardListUI", "location permission is denied, doGetLayout");
    bXd();
    AppMethodBeat.o(113110);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113104);
    super.onCreate(paramBundle);
    long l = System.currentTimeMillis();
    this.mStartTime = l;
    this.oKc = l;
    initView();
    com.tencent.mm.kernel.g.ajQ().gDv.a(1164, this);
    am.bWj().a(this);
    bXg();
    am.bWk().add(this);
    AppMethodBeat.o(113104);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113105);
    if (this.oKb) {
      bUB();
    }
    this.oJN.oJE = null;
    this.oJO.oJE = null;
    this.oJE.oHX = null;
    com.tencent.mm.kernel.g.ajQ().gDv.b(1164, this);
    am.bWj().b(this);
    com.tencent.mm.plugin.card.sharecard.a.b.bWJ();
    am.bWk().remove(this);
    long l = System.currentTimeMillis() - this.oKc;
    if (!TextUtils.isEmpty(this.oFe)) {
      com.tencent.mm.plugin.report.service.g.yxI.f(13219, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Long.valueOf(l) });
    }
    for (;;)
    {
      super.onDestroy();
      AppMethodBeat.o(113105);
      return;
      com.tencent.mm.plugin.report.service.g.yxI.f(13219, new Object[] { "ShareCardListUI", Integer.valueOf(1), "", "", Long.valueOf(l) });
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(113114);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    bXg();
    if (paramIntent != null)
    {
      this.oFe = paramIntent.getStringExtra("KEY_CARD_TP_ID");
      if (!bu.isNullOrNil(this.oFe))
      {
        this.oJQ = true;
        this.oJS = true;
      }
    }
    AppMethodBeat.o(113114);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(113108);
    super.onPause();
    this.oJR = false;
    this.oJS = true;
    AppMethodBeat.o(113108);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(113106);
    jt(true);
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
      com.tencent.mm.plugin.report.service.g.yxI.b(localArrayList, true);
      this.mStartTime = 0L;
    }
    super.onResume();
    AppMethodBeat.o(113106);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    boolean bool = true;
    AppMethodBeat.i(113129);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.b))
      {
        paramString = (com.tencent.mm.plugin.card.sharecard.model.b)paramn;
        this.oJV = false;
        this.oJW = paramString.oIf;
        this.oJE.aJ(paramString.oGs, this.oJT);
        if ((!com.tencent.mm.plugin.card.sharecard.a.b.bWK()) || (!com.tencent.mm.plugin.card.sharecard.a.b.bWL())) {
          this.oJT = false;
        }
        if ((com.tencent.mm.plugin.card.sharecard.a.b.bWK()) && (com.tencent.mm.plugin.card.sharecard.a.b.bWL())) {}
        for (;;)
        {
          this.oJU = bool;
          ae.i("MicroMsg.ShareCardListUI", "NetSceneGetShareCardsLayout() >> updateView()");
          bWY();
          AppMethodBeat.o(113129);
          return;
          bool = false;
        }
      }
    }
    else
    {
      if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.b))
      {
        if (this.oKe)
        {
          this.oKe = false;
          this.oJO.bWU();
          this.oCH.setEmptyView(this.oCJ);
          this.oCH.invalidate();
        }
        this.oJV = false;
        this.oJU = true;
      }
      ae.i("MicroMsg.ShareCardListUI", "share card list ui, onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    AppMethodBeat.o(113129);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.ShareCardListUI
 * JD-Core Version:    0.7.0.1
 */