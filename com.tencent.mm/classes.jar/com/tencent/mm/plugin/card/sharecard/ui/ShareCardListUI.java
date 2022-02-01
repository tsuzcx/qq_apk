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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.plugin.card.ui.CardDetailUI;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.ArrayList;

public class ShareCardListUI
  extends CardBaseUI
  implements com.tencent.mm.plugin.card.base.d, k.a
{
  private long mStartTime = 0L;
  private long mYm = 0L;
  private final long mYn = 500L;
  private boolean mYo = false;
  private String nsh = null;
  private b.a nvb = null;
  private com.tencent.mm.plugin.card.sharecard.a.b nwI;
  private f nwR;
  private e nwS;
  private i nwT;
  private boolean nwU = false;
  private boolean nwV = true;
  private boolean nwW = false;
  private boolean nwX = true;
  private boolean nwY = true;
  private boolean nwZ = false;
  private String nxa = "";
  private boolean nxb = false;
  private boolean nxc = false;
  private boolean nxd = false;
  private int nxe = 0;
  private boolean nxf = false;
  private long nxg = 0L;
  boolean nxh = false;
  private boolean nxi = false;
  
  private void bJQ()
  {
    AppMethodBeat.i(113111);
    ad.d("MicroMsg.ShareCardListUI", "initLocation");
    com.tencent.e.h.Iye.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(113100);
        ShareCardListUI.a(ShareCardListUI.this);
        ShareCardListUI.b(ShareCardListUI.this);
        ShareCardListUI.this.nxh = true;
        ad.d("MicroMsg.ShareCardListUI", "initLocation end");
        AppMethodBeat.o(113100);
      }
    }, "MicroMsg.ShareCardListUI");
    AppMethodBeat.o(113111);
  }
  
  private void bJR()
  {
    AppMethodBeat.i(113115);
    long l = System.currentTimeMillis() - this.mYm;
    if ((this.mYo) && (l < 1000L))
    {
      ad.d("MicroMsg.ShareCardListUI", "DoingUpdateView return");
      AppMethodBeat.o(113115);
      return;
    }
    ad.d("MicroMsg.ShareCardListUI", "try2UpdateView isDoingUpdateView %s,interval %s", new Object[] { Boolean.valueOf(this.mYo), Long.valueOf(l) });
    this.mYo = true;
    if (l < 500L)
    {
      aq.n(new Runnable()
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
          ad.w("MicroMsg.ShareCardListUI", "Activity is finished!!!");
          AppMethodBeat.o(113103);
        }
      }, 500L);
      AppMethodBeat.o(113115);
      return;
    }
    cE();
    this.mYm = System.currentTimeMillis();
    this.mYo = false;
    AppMethodBeat.o(113115);
  }
  
  private void bJS()
  {
    AppMethodBeat.i(113117);
    if (this.npK.getEmptyView() != this.npM)
    {
      this.npK.setEmptyView(this.npM);
      this.npK.invalidate();
    }
    AppMethodBeat.o(113117);
  }
  
  private void bJT()
  {
    AppMethodBeat.i(113118);
    if ((!com.tencent.mm.plugin.card.sharecard.a.b.bJB()) && (!com.tencent.mm.plugin.card.sharecard.a.b.bJA()))
    {
      this.nwS.bJM();
      this.npK.setEmptyView(null);
      this.npK.invalidate();
      this.nxi = true;
    }
    AppMethodBeat.o(113118);
  }
  
  private void bJU()
  {
    AppMethodBeat.i(113119);
    if (this.npK.getEmptyView() != null)
    {
      this.npK.setEmptyView(null);
      this.npK.invalidate();
    }
    AppMethodBeat.o(113119);
  }
  
  private void bJV()
  {
    AppMethodBeat.i(113120);
    if ((this.npL instanceof c)) {
      ((c)this.npL).yY(this.nxe);
    }
    AppMethodBeat.o(113120);
  }
  
  private void bJW()
  {
    AppMethodBeat.i(113123);
    if ((com.tencent.mm.plugin.card.sharecard.a.b.bJD()) && (com.tencent.mm.plugin.card.sharecard.a.b.bJE()))
    {
      ad.i("MicroMsg.ShareCardListUI", "doGetLayout() no data to load");
      this.nwY = true;
      AppMethodBeat.o(113123);
      return;
    }
    if ((!com.tencent.mm.plugin.card.sharecard.a.b.bJD()) || (!com.tencent.mm.plugin.card.sharecard.a.b.bJE())) {
      this.nwX = false;
    }
    ad.i("MicroMsg.ShareCardListUI", "doGetLayout() >> doNetSceneGetCardsHomePageLayout()");
    bJX();
    am.bJb().F("", "", 4);
    AppMethodBeat.o(113123);
  }
  
  private void bJX()
  {
    AppMethodBeat.i(113124);
    if (this.nwZ)
    {
      ad.e("MicroMsg.ShareCardListUI", "doNetSceneGetCardsHomePageLayout, isDoingGetData is true");
      AppMethodBeat.o(113124);
      return;
    }
    if ((bt.isNullOrNil(this.nxa)) && (!com.tencent.mm.plugin.card.sharecard.a.b.bJB()) && (!com.tencent.mm.plugin.card.sharecard.a.b.bJA())) {
      bJT();
    }
    if ((this.nwX) && (!bt.isNullOrNil(this.nxa))) {
      this.nxa = "";
    }
    this.nwZ = true;
    com.tencent.mm.plugin.card.sharecard.model.b localb = new com.tencent.mm.plugin.card.sharecard.model.b(am.bJb().fjD, am.bJb().fjE, this.nxa);
    g.afA().gcy.a(localb, 0);
    AppMethodBeat.o(113124);
  }
  
  private void bJY()
  {
    AppMethodBeat.i(113130);
    if ((this.nxe == 0) || (this.nxe == 4) || ((this.nxe == 2) && ((!com.tencent.mm.plugin.card.sharecard.a.b.bJB()) || (!com.tencent.mm.plugin.card.sharecard.a.b.bJA()))) || ((this.nxe == 1) && ((!com.tencent.mm.plugin.card.sharecard.a.b.bJB()) || (com.tencent.mm.plugin.card.sharecard.a.b.bJA()))) || ((this.nxe == 3) && ((!com.tencent.mm.plugin.card.sharecard.a.b.bJA()) || (com.tencent.mm.plugin.card.sharecard.a.b.bJB())))) {
      this.nxe = com.tencent.mm.plugin.card.sharecard.a.b.bJz();
    }
    am.bJa().putValue("key_share_card_show_type", Integer.valueOf(this.nxe));
    AppMethodBeat.o(113130);
  }
  
  private void bJZ()
  {
    AppMethodBeat.i(113133);
    int i = getIntent().getIntExtra("key_from_scene", 22);
    boolean bool1 = com.tencent.mm.z.c.adr().cI(262152, 266256);
    boolean bool2 = com.tencent.mm.z.c.adr().cJ(262152, 266256);
    boolean bool3 = com.tencent.mm.z.c.adr().a(ae.a.Fhi, ae.a.Fhk);
    boolean bool4 = com.tencent.mm.z.c.adr().a(ae.a.Fhj, ae.a.Fhl);
    String str = bt.nullAsNil((String)g.afB().afk().get(ae.a.Fho, null));
    if (bool1)
    {
      com.tencent.mm.plugin.report.service.h.vKh.f(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(2), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113133);
      return;
    }
    if (bool2)
    {
      com.tencent.mm.plugin.report.service.h.vKh.f(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113133);
      return;
    }
    if ((bool3) && (!bool4))
    {
      com.tencent.mm.plugin.report.service.h.vKh.f(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(3), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113133);
      return;
    }
    if ((bool3) && (bool4))
    {
      com.tencent.mm.plugin.report.service.h.vKh.f(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(4), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113133);
      return;
    }
    if (bool4)
    {
      com.tencent.mm.plugin.report.service.h.vKh.f(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(5), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113133);
      return;
    }
    com.tencent.mm.plugin.report.service.h.vKh.f(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(i), "", Integer.valueOf(0), str });
    AppMethodBeat.o(113133);
  }
  
  private void cE()
  {
    AppMethodBeat.i(113116);
    bJY();
    ad.i("MicroMsg.ShareCardListUI", "updateView() currentType is %s, canShowLocalCity %s, canShowOtherCity %s", new Object[] { Integer.valueOf(this.nxe), Boolean.valueOf(com.tencent.mm.plugin.card.sharecard.a.b.bJB()), Boolean.valueOf(com.tencent.mm.plugin.card.sharecard.a.b.bJA()) });
    this.nwR.cE();
    if ((!com.tencent.mm.plugin.card.sharecard.a.b.bJB()) && (!com.tencent.mm.plugin.card.sharecard.a.b.bJA()))
    {
      this.nwS.bJP();
      this.nwT.bKa();
      bJS();
    }
    for (;;)
    {
      bJV();
      AppMethodBeat.o(113116);
      return;
      this.nwS.cE();
      this.nwT.cE();
      if (this.nxe == 4) {
        bJU();
      }
    }
  }
  
  private void iG(boolean paramBoolean)
  {
    AppMethodBeat.i(113107);
    ad.i("MicroMsg.ShareCardListUI", "doRefreshData() >> updateView() shouldGetLayout %s fromOnresume %s", new Object[] { Boolean.valueOf(this.nwV), Boolean.valueOf(paramBoolean) });
    if (this.nwV)
    {
      this.nwV = false;
      this.nxb = false;
      this.nwX = true;
      this.nxa = "";
      ad.d("MicroMsg.ShareCardListUI", "doRefreshData() >> doNetSceneGetCardsHomePageLayout()");
      if (!paramBoolean) {
        break label104;
      }
      if ((this.nxf) && (this.nxh)) {
        bHt();
      }
    }
    for (;;)
    {
      bJR();
      AppMethodBeat.o(113107);
      return;
      label104:
      bJX();
    }
  }
  
  public final BaseAdapter VY()
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
    ad.i("MicroMsg.ShareCardListUI", "card tp id:" + paramb.bIa());
    ad.i("MicroMsg.ShareCardListUI", "card id:" + paramb.bHZ());
    ((Intent)localObject).putExtra("key_card_id", am.bJd().QH(paramb.bIa()));
    ((Intent)localObject).putExtra("key_card_tp_id", paramb.bIa());
    ((Intent)localObject).putExtra("key_is_share_card", true);
    ((Intent)localObject).putExtra("key_from_scene", 3);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/card/sharecard/ui/ShareCardListUI", "onGotoCardDetailUI", "(Lcom/tencent/mm/plugin/card/base/ICardInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/sharecard/ui/ShareCardListUI", "onGotoCardDetailUI", "(Lcom/tencent/mm/plugin/card/base/ICardInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.plugin.card.sharecard.a.b.QE(paramb.bIa());
    AppMethodBeat.o(113128);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(113132);
    ad.d("MicroMsg.ShareCardListUI", "onNotifyChange");
    this.nwV = true;
    AppMethodBeat.o(113132);
  }
  
  public final void b(com.tencent.mm.plugin.card.base.b paramb, int paramInt)
  {
    AppMethodBeat.i(113126);
    if (paramb != null) {
      com.tencent.mm.plugin.card.sharecard.a.b.Qz(paramb.bIa());
    }
    super.b(paramb, paramInt);
    AppMethodBeat.o(113126);
  }
  
  public final void bHo()
  {
    AppMethodBeat.i(113113);
    setMMTitle(2131756977);
    this.nwI = new com.tencent.mm.plugin.card.sharecard.a.b(this);
    this.nvb = new b.a() {};
    this.nwI.nvb = this.nvb;
    this.nwI.init();
    this.nxe = com.tencent.mm.plugin.card.sharecard.a.b.bJz();
    Object localObject;
    if (this.nwT == null)
    {
      this.nwT = new i(this, getContentView());
      localObject = this.nwT;
      ((i)localObject).nxk = View.inflate(((i)localObject).nqt, 2131493343, null);
      ((i)localObject).nxl = ((TextView)((i)localObject).nxk.findViewById(2131297834));
      ((i)localObject).nxm = ((TextView)((i)localObject).nxk.findViewById(2131297838));
      ((i)localObject).cE();
    }
    if (this.nwR == null)
    {
      this.nwR = new f(this, getContentView());
      localObject = this.nwR;
      ((f)localObject).nwM = ((ImageView)((f)localObject).hIZ.findViewById(2131302870));
      ((f)localObject).nwO = ((TextView)((f)localObject).hIZ.findViewById(2131302872));
      ((f)localObject).nwN = ((TextView)((f)localObject).hIZ.findViewById(2131302873));
      this.nwR.nwI = this.nwI;
    }
    if (this.nwS == null)
    {
      getContentView();
      this.nwS = new e(this);
      this.nwS.nwI = this.nwI;
      this.nwS.bJK();
      localObject = this.nwS;
      View.OnClickListener local3 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113101);
          ShareCardListUI.c(ShareCardListUI.this);
          if (com.tencent.mm.plugin.card.sharecard.a.b.bJB())
          {
            ShareCardListUI.c(ShareCardListUI.this);
            if (com.tencent.mm.plugin.card.sharecard.a.b.bJA()) {
              ShareCardListUI.a(ShareCardListUI.this, 2);
            }
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.vKh.f(11582, new Object[] { "OperChangeOtherCity ", Integer.valueOf(0), Integer.valueOf(0), "", "", "" });
            am.bJa().putValue("key_share_card_show_type", Integer.valueOf(ShareCardListUI.d(ShareCardListUI.this)));
            ShareCardListUI.e(ShareCardListUI.this);
            ShareCardListUI.f(ShareCardListUI.this).cE();
            ShareCardListUI.c(ShareCardListUI.this);
            com.tencent.mm.plugin.card.sharecard.a.b.nvc = true;
            AppMethodBeat.o(113101);
            return;
            ShareCardListUI.c(ShareCardListUI.this);
            if (com.tencent.mm.plugin.card.sharecard.a.b.bJA()) {
              ShareCardListUI.a(ShareCardListUI.this, 3);
            }
          }
        }
      };
      if (((e)localObject).nwH != null) {
        ((e)localObject).nwH.setOnClickListener(local3);
      }
    }
    if (this.npN != null) {
      this.npN.addView(this.nwT.nxk);
    }
    if (this.npO != null) {
      this.npO.addView(this.nwS.nwH);
    }
    this.npK.setVisibility(0);
    this.npK.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(113102);
        if ((paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1) && (!ShareCardListUI.g(ShareCardListUI.this)) && (ShareCardListUI.d(ShareCardListUI.this) != 4))
        {
          ad.d("MicroMsg.ShareCardListUI", "onScroll() >> doNetSceneGetCardsHomePageLayout()");
          ShareCardListUI.h(ShareCardListUI.this);
        }
        AppMethodBeat.o(113102);
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    if ((getIntent() != null) && (getIntent().getBooleanExtra("KEY_IS_SHOW_SHARE_CARD_ENTRANCE_TIPS", true)))
    {
      localObject = (Integer)g.afB().afk().get(ae.a.FhA, Integer.valueOf(0));
      if ((localObject == null) || (((Integer)localObject).intValue() != 1))
      {
        g.afB().afk().set(ae.a.FhA, Integer.valueOf(1));
        com.tencent.mm.plugin.card.d.d.c(this, 2131493350, 2131756987, "");
      }
    }
    for (;;)
    {
      this.nsh = getIntent().getStringExtra("KEY_CARD_TP_ID");
      this.nxa = getIntent().getStringExtra("key_layout_buff");
      if (!bt.isNullOrNil(this.nxa)) {
        this.nwV = false;
      }
      if (!bt.isNullOrNil(this.nsh))
      {
        this.nwU = true;
        this.nwW = true;
      }
      AppMethodBeat.o(113113);
      return;
      localObject = (Integer)g.afB().afk().get(ae.a.FhA, Integer.valueOf(0));
      if ((localObject != null) && (((Integer)localObject).intValue() != 1)) {
        g.afB().afk().set(ae.a.FhA, Integer.valueOf(1));
      }
    }
  }
  
  public final boolean bHq()
  {
    AppMethodBeat.i(113125);
    boolean bool = super.bHq();
    AppMethodBeat.o(113125);
    return bool;
  }
  
  public final boolean bHr()
  {
    return false;
  }
  
  public final void bHv()
  {
    AppMethodBeat.i(113121);
    this.nxd = true;
    if (this.nxb)
    {
      ad.e("MicroMsg.ShareCardListUI", "onLocationFinish, has do GetShareCardLayout,don't get again");
      if (this.nxf) {
        bHu();
      }
      AppMethodBeat.o(113121);
      return;
    }
    ad.d("MicroMsg.ShareCardListUI", "onLocationFinish()");
    this.nxb = true;
    bJW();
    bHu();
    AppMethodBeat.o(113121);
  }
  
  public final void bHw()
  {
    AppMethodBeat.i(113122);
    if ((this.nxc) || (this.nxb))
    {
      bHu();
      AppMethodBeat.o(113122);
      return;
    }
    this.nxc = true;
    ad.i("MicroMsg.ShareCardListUI", "onLocationFail()");
    bJW();
    AppMethodBeat.o(113122);
  }
  
  public final void bHx()
  {
    AppMethodBeat.i(113112);
    ad.i("MicroMsg.ShareCardListUI", "onMPermissionGranted LocationPermissionGranted " + this.nxf);
    if (!this.nxf)
    {
      this.nxf = true;
      bJQ();
    }
    AppMethodBeat.o(113112);
  }
  
  public final void bIg()
  {
    AppMethodBeat.i(113131);
    com.tencent.mm.plugin.card.sharecard.a.b.bJy();
    this.nwV = true;
    ad.i("MicroMsg.ShareCardListUI", "onDBchange() shouldRefreshDataOnDbChange %s  mIsActive %s hasLocationInfo %s", new Object[] { Boolean.valueOf(this.nwW), Boolean.valueOf(this.npQ), Boolean.valueOf(this.nxd) });
    if ((this.nwW) && (this.npQ) && (this.nxd)) {
      iG(false);
    }
    for (;;)
    {
      this.nwW = false;
      AppMethodBeat.o(113131);
      return;
      bJR();
    }
  }
  
  public void initView()
  {
    AppMethodBeat.i(113110);
    super.initView();
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null);
    ad.i("MicroMsg.ShareCardListUI", "checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
    this.nxf = bool;
    if (this.nxf)
    {
      bJQ();
      AppMethodBeat.o(113110);
      return;
    }
    ad.e("MicroMsg.ShareCardListUI", "location permission is denied, doGetLayout");
    bJW();
    AppMethodBeat.o(113110);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113104);
    super.onCreate(paramBundle);
    long l = System.currentTimeMillis();
    this.mStartTime = l;
    this.nxg = l;
    initView();
    g.afA().gcy.a(1164, this);
    am.bJc().a(this);
    bJZ();
    am.bJd().add(this);
    AppMethodBeat.o(113104);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113105);
    if (this.nxf) {
      bHu();
    }
    this.nwR.nwI = null;
    this.nwS.nwI = null;
    this.nwI.nvb = null;
    g.afA().gcy.b(1164, this);
    am.bJc().b(this);
    com.tencent.mm.plugin.card.sharecard.a.b.bJC();
    am.bJd().remove(this);
    long l = System.currentTimeMillis() - this.nxg;
    if (!TextUtils.isEmpty(this.nsh)) {
      com.tencent.mm.plugin.report.service.h.vKh.f(13219, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Long.valueOf(l) });
    }
    for (;;)
    {
      super.onDestroy();
      AppMethodBeat.o(113105);
      return;
      com.tencent.mm.plugin.report.service.h.vKh.f(13219, new Object[] { "ShareCardListUI", Integer.valueOf(1), "", "", Long.valueOf(l) });
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(113114);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    bJZ();
    if (paramIntent != null)
    {
      this.nsh = paramIntent.getStringExtra("KEY_CARD_TP_ID");
      if (!bt.isNullOrNil(this.nsh))
      {
        this.nwU = true;
        this.nwW = true;
      }
    }
    AppMethodBeat.o(113114);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(113108);
    super.onPause();
    this.nwV = false;
    this.nwW = true;
    AppMethodBeat.o(113108);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(113106);
    iG(true);
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
      com.tencent.mm.plugin.report.service.h.vKh.b(localArrayList, true);
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
        this.nwZ = false;
        this.nxa = paramString.nvj;
        this.nwI.aE(paramString.ntw, this.nwX);
        if ((!com.tencent.mm.plugin.card.sharecard.a.b.bJD()) || (!com.tencent.mm.plugin.card.sharecard.a.b.bJE())) {
          this.nwX = false;
        }
        if ((com.tencent.mm.plugin.card.sharecard.a.b.bJD()) && (com.tencent.mm.plugin.card.sharecard.a.b.bJE())) {}
        for (;;)
        {
          this.nwY = bool;
          ad.i("MicroMsg.ShareCardListUI", "NetSceneGetShareCardsLayout() >> updateView()");
          bJR();
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
        if (this.nxi)
        {
          this.nxi = false;
          this.nwS.bJN();
          this.npK.setEmptyView(this.npM);
          this.npK.invalidate();
        }
        this.nwZ = false;
        this.nwY = true;
      }
      ad.i("MicroMsg.ShareCardListUI", "share card list ui, onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    AppMethodBeat.o(113129);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.ShareCardListUI
 * JD-Core Version:    0.7.0.1
 */