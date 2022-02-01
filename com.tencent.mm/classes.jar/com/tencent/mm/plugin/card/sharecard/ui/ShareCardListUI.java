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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.plugin.card.ui.CardDetailUI;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.ArrayList;

public class ShareCardListUI
  extends CardBaseUI
  implements com.tencent.mm.plugin.card.base.d, k.a
{
  private long mStartTime = 0L;
  private long nAL = 0L;
  private final long nAM = 500L;
  private boolean nAN = false;
  private String nVh = null;
  private b.a nYb = null;
  private com.tencent.mm.plugin.card.sharecard.a.b nZI;
  private f nZR;
  private e nZS;
  private i nZT;
  private boolean nZU = false;
  private boolean nZV = true;
  private boolean nZW = false;
  private boolean nZX = true;
  private boolean nZY = true;
  private boolean nZZ = false;
  private String oaa = "";
  private boolean oab = false;
  private boolean oac = false;
  private boolean oad = false;
  private int oae = 0;
  private boolean oaf = false;
  private long oag = 0L;
  boolean oah = false;
  private boolean oai = false;
  
  private void bRd()
  {
    AppMethodBeat.i(113111);
    ac.d("MicroMsg.ShareCardListUI", "initLocation");
    com.tencent.e.h.JZN.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(113100);
        ShareCardListUI.a(ShareCardListUI.this);
        ShareCardListUI.b(ShareCardListUI.this);
        ShareCardListUI.this.oah = true;
        ac.d("MicroMsg.ShareCardListUI", "initLocation end");
        AppMethodBeat.o(113100);
      }
    }, "MicroMsg.ShareCardListUI");
    AppMethodBeat.o(113111);
  }
  
  private void bRe()
  {
    AppMethodBeat.i(113115);
    long l = System.currentTimeMillis() - this.nAL;
    if ((this.nAN) && (l < 1000L))
    {
      ac.d("MicroMsg.ShareCardListUI", "DoingUpdateView return");
      AppMethodBeat.o(113115);
      return;
    }
    ac.d("MicroMsg.ShareCardListUI", "try2UpdateView isDoingUpdateView %s,interval %s", new Object[] { Boolean.valueOf(this.nAN), Long.valueOf(l) });
    this.nAN = true;
    if (l < 500L)
    {
      ap.n(new Runnable()
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
          ac.w("MicroMsg.ShareCardListUI", "Activity is finished!!!");
          AppMethodBeat.o(113103);
        }
      }, 500L);
      AppMethodBeat.o(113115);
      return;
    }
    cL();
    this.nAL = System.currentTimeMillis();
    this.nAN = false;
    AppMethodBeat.o(113115);
  }
  
  private void bRf()
  {
    AppMethodBeat.i(113117);
    if (this.nSK.getEmptyView() != this.nSM)
    {
      this.nSK.setEmptyView(this.nSM);
      this.nSK.invalidate();
    }
    AppMethodBeat.o(113117);
  }
  
  private void bRg()
  {
    AppMethodBeat.i(113118);
    if ((!com.tencent.mm.plugin.card.sharecard.a.b.bQO()) && (!com.tencent.mm.plugin.card.sharecard.a.b.bQN()))
    {
      this.nZS.bQZ();
      this.nSK.setEmptyView(null);
      this.nSK.invalidate();
      this.oai = true;
    }
    AppMethodBeat.o(113118);
  }
  
  private void bRh()
  {
    AppMethodBeat.i(113119);
    if (this.nSK.getEmptyView() != null)
    {
      this.nSK.setEmptyView(null);
      this.nSK.invalidate();
    }
    AppMethodBeat.o(113119);
  }
  
  private void bRi()
  {
    AppMethodBeat.i(113120);
    if ((this.nSL instanceof c)) {
      ((c)this.nSL).zO(this.oae);
    }
    AppMethodBeat.o(113120);
  }
  
  private void bRj()
  {
    AppMethodBeat.i(113123);
    if ((com.tencent.mm.plugin.card.sharecard.a.b.bQQ()) && (com.tencent.mm.plugin.card.sharecard.a.b.bQR()))
    {
      ac.i("MicroMsg.ShareCardListUI", "doGetLayout() no data to load");
      this.nZY = true;
      AppMethodBeat.o(113123);
      return;
    }
    if ((!com.tencent.mm.plugin.card.sharecard.a.b.bQQ()) || (!com.tencent.mm.plugin.card.sharecard.a.b.bQR())) {
      this.nZX = false;
    }
    ac.i("MicroMsg.ShareCardListUI", "doGetLayout() >> doNetSceneGetCardsHomePageLayout()");
    bRk();
    am.bQo().G("", "", 4);
    AppMethodBeat.o(113123);
  }
  
  private void bRk()
  {
    AppMethodBeat.i(113124);
    if (this.nZZ)
    {
      ac.e("MicroMsg.ShareCardListUI", "doNetSceneGetCardsHomePageLayout, isDoingGetData is true");
      AppMethodBeat.o(113124);
      return;
    }
    if ((bs.isNullOrNil(this.oaa)) && (!com.tencent.mm.plugin.card.sharecard.a.b.bQO()) && (!com.tencent.mm.plugin.card.sharecard.a.b.bQN())) {
      bRg();
    }
    if ((this.nZX) && (!bs.isNullOrNil(this.oaa))) {
      this.oaa = "";
    }
    this.nZZ = true;
    com.tencent.mm.plugin.card.sharecard.model.b localb = new com.tencent.mm.plugin.card.sharecard.model.b(am.bQo().fmX, am.bQo().fmY, this.oaa);
    g.agQ().ghe.a(localb, 0);
    AppMethodBeat.o(113124);
  }
  
  private void bRl()
  {
    AppMethodBeat.i(113130);
    if ((this.oae == 0) || (this.oae == 4) || ((this.oae == 2) && ((!com.tencent.mm.plugin.card.sharecard.a.b.bQO()) || (!com.tencent.mm.plugin.card.sharecard.a.b.bQN()))) || ((this.oae == 1) && ((!com.tencent.mm.plugin.card.sharecard.a.b.bQO()) || (com.tencent.mm.plugin.card.sharecard.a.b.bQN()))) || ((this.oae == 3) && ((!com.tencent.mm.plugin.card.sharecard.a.b.bQN()) || (com.tencent.mm.plugin.card.sharecard.a.b.bQO())))) {
      this.oae = com.tencent.mm.plugin.card.sharecard.a.b.bQM();
    }
    am.bQn().putValue("key_share_card_show_type", Integer.valueOf(this.oae));
    AppMethodBeat.o(113130);
  }
  
  private void bRm()
  {
    AppMethodBeat.i(113133);
    int i = getIntent().getIntExtra("key_from_scene", 22);
    boolean bool1 = com.tencent.mm.y.c.aeH().cG(262152, 266256);
    boolean bool2 = com.tencent.mm.y.c.aeH().cH(262152, 266256);
    boolean bool3 = com.tencent.mm.y.c.aeH().a(ah.a.GEX, ah.a.GEZ);
    boolean bool4 = com.tencent.mm.y.c.aeH().a(ah.a.GEY, ah.a.GFa);
    String str = bs.nullAsNil((String)g.agR().agA().get(ah.a.GFd, null));
    if (bool1)
    {
      com.tencent.mm.plugin.report.service.h.wUl.f(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(2), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113133);
      return;
    }
    if (bool2)
    {
      com.tencent.mm.plugin.report.service.h.wUl.f(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113133);
      return;
    }
    if ((bool3) && (!bool4))
    {
      com.tencent.mm.plugin.report.service.h.wUl.f(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(3), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113133);
      return;
    }
    if ((bool3) && (bool4))
    {
      com.tencent.mm.plugin.report.service.h.wUl.f(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(4), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113133);
      return;
    }
    if (bool4)
    {
      com.tencent.mm.plugin.report.service.h.wUl.f(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(5), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113133);
      return;
    }
    com.tencent.mm.plugin.report.service.h.wUl.f(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(i), "", Integer.valueOf(0), str });
    AppMethodBeat.o(113133);
  }
  
  private void cL()
  {
    AppMethodBeat.i(113116);
    bRl();
    ac.i("MicroMsg.ShareCardListUI", "updateView() currentType is %s, canShowLocalCity %s, canShowOtherCity %s", new Object[] { Integer.valueOf(this.oae), Boolean.valueOf(com.tencent.mm.plugin.card.sharecard.a.b.bQO()), Boolean.valueOf(com.tencent.mm.plugin.card.sharecard.a.b.bQN()) });
    this.nZR.cL();
    if ((!com.tencent.mm.plugin.card.sharecard.a.b.bQO()) && (!com.tencent.mm.plugin.card.sharecard.a.b.bQN()))
    {
      this.nZS.bRc();
      this.nZT.bRn();
      bRf();
    }
    for (;;)
    {
      bRi();
      AppMethodBeat.o(113116);
      return;
      this.nZS.cL();
      this.nZT.cL();
      if (this.oae == 4) {
        bRh();
      }
    }
  }
  
  private void jj(boolean paramBoolean)
  {
    AppMethodBeat.i(113107);
    ac.i("MicroMsg.ShareCardListUI", "doRefreshData() >> updateView() shouldGetLayout %s fromOnresume %s", new Object[] { Boolean.valueOf(this.nZV), Boolean.valueOf(paramBoolean) });
    if (this.nZV)
    {
      this.nZV = false;
      this.oab = false;
      this.nZX = true;
      this.oaa = "";
      ac.d("MicroMsg.ShareCardListUI", "doRefreshData() >> doNetSceneGetCardsHomePageLayout()");
      if (!paramBoolean) {
        break label104;
      }
      if ((this.oaf) && (this.oah)) {
        bOG();
      }
    }
    for (;;)
    {
      bRe();
      AppMethodBeat.o(113107);
      return;
      label104:
      bRk();
    }
  }
  
  public final BaseAdapter WW()
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
    ac.i("MicroMsg.ShareCardListUI", "card tp id:" + paramb.bPn());
    ac.i("MicroMsg.ShareCardListUI", "card id:" + paramb.bPm());
    ((Intent)localObject).putExtra("key_card_id", am.bQq().UT(paramb.bPn()));
    ((Intent)localObject).putExtra("key_card_tp_id", paramb.bPn());
    ((Intent)localObject).putExtra("key_is_share_card", true);
    ((Intent)localObject).putExtra("key_from_scene", 3);
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/card/sharecard/ui/ShareCardListUI", "onGotoCardDetailUI", "(Lcom/tencent/mm/plugin/card/base/ICardInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/sharecard/ui/ShareCardListUI", "onGotoCardDetailUI", "(Lcom/tencent/mm/plugin/card/base/ICardInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.plugin.card.sharecard.a.b.UQ(paramb.bPn());
    AppMethodBeat.o(113128);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(113132);
    ac.d("MicroMsg.ShareCardListUI", "onNotifyChange");
    this.nZV = true;
    AppMethodBeat.o(113132);
  }
  
  public final void b(com.tencent.mm.plugin.card.base.b paramb, int paramInt)
  {
    AppMethodBeat.i(113126);
    if (paramb != null) {
      com.tencent.mm.plugin.card.sharecard.a.b.UL(paramb.bPn());
    }
    super.b(paramb, paramInt);
    AppMethodBeat.o(113126);
  }
  
  public final void bOB()
  {
    AppMethodBeat.i(113113);
    setMMTitle(2131756977);
    this.nZI = new com.tencent.mm.plugin.card.sharecard.a.b(this);
    this.nYb = new b.a() {};
    this.nZI.nYb = this.nYb;
    this.nZI.init();
    this.oae = com.tencent.mm.plugin.card.sharecard.a.b.bQM();
    Object localObject;
    if (this.nZT == null)
    {
      this.nZT = new i(this, getContentView());
      localObject = this.nZT;
      ((i)localObject).oak = View.inflate(((i)localObject).nTt, 2131493343, null);
      ((i)localObject).oal = ((TextView)((i)localObject).oak.findViewById(2131297834));
      ((i)localObject).oam = ((TextView)((i)localObject).oak.findViewById(2131297838));
      ((i)localObject).cL();
    }
    if (this.nZR == null)
    {
      this.nZR = new f(this, getContentView());
      localObject = this.nZR;
      ((f)localObject).nZM = ((ImageView)((f)localObject).ijA.findViewById(2131302870));
      ((f)localObject).nZO = ((TextView)((f)localObject).ijA.findViewById(2131302872));
      ((f)localObject).nZN = ((TextView)((f)localObject).ijA.findViewById(2131302873));
      this.nZR.nZI = this.nZI;
    }
    if (this.nZS == null)
    {
      getContentView();
      this.nZS = new e(this);
      this.nZS.nZI = this.nZI;
      this.nZS.bQX();
      localObject = this.nZS;
      View.OnClickListener local3 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113101);
          ShareCardListUI.c(ShareCardListUI.this);
          if (com.tencent.mm.plugin.card.sharecard.a.b.bQO())
          {
            ShareCardListUI.c(ShareCardListUI.this);
            if (com.tencent.mm.plugin.card.sharecard.a.b.bQN()) {
              ShareCardListUI.a(ShareCardListUI.this, 2);
            }
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.wUl.f(11582, new Object[] { "OperChangeOtherCity ", Integer.valueOf(0), Integer.valueOf(0), "", "", "" });
            am.bQn().putValue("key_share_card_show_type", Integer.valueOf(ShareCardListUI.d(ShareCardListUI.this)));
            ShareCardListUI.e(ShareCardListUI.this);
            ShareCardListUI.f(ShareCardListUI.this).cL();
            ShareCardListUI.c(ShareCardListUI.this);
            com.tencent.mm.plugin.card.sharecard.a.b.nYc = true;
            AppMethodBeat.o(113101);
            return;
            ShareCardListUI.c(ShareCardListUI.this);
            if (com.tencent.mm.plugin.card.sharecard.a.b.bQN()) {
              ShareCardListUI.a(ShareCardListUI.this, 3);
            }
          }
        }
      };
      if (((e)localObject).nZH != null) {
        ((e)localObject).nZH.setOnClickListener(local3);
      }
    }
    if (this.nSN != null) {
      this.nSN.addView(this.nZT.oak);
    }
    if (this.nSO != null) {
      this.nSO.addView(this.nZS.nZH);
    }
    this.nSK.setVisibility(0);
    this.nSK.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(113102);
        if ((paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1) && (!ShareCardListUI.g(ShareCardListUI.this)) && (ShareCardListUI.d(ShareCardListUI.this) != 4))
        {
          ac.d("MicroMsg.ShareCardListUI", "onScroll() >> doNetSceneGetCardsHomePageLayout()");
          ShareCardListUI.h(ShareCardListUI.this);
        }
        AppMethodBeat.o(113102);
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    if ((getIntent() != null) && (getIntent().getBooleanExtra("KEY_IS_SHOW_SHARE_CARD_ENTRANCE_TIPS", true)))
    {
      localObject = (Integer)g.agR().agA().get(ah.a.GFp, Integer.valueOf(0));
      if ((localObject == null) || (((Integer)localObject).intValue() != 1))
      {
        g.agR().agA().set(ah.a.GFp, Integer.valueOf(1));
        com.tencent.mm.plugin.card.d.d.c(this, 2131493350, 2131756987, "");
      }
    }
    for (;;)
    {
      this.nVh = getIntent().getStringExtra("KEY_CARD_TP_ID");
      this.oaa = getIntent().getStringExtra("key_layout_buff");
      if (!bs.isNullOrNil(this.oaa)) {
        this.nZV = false;
      }
      if (!bs.isNullOrNil(this.nVh))
      {
        this.nZU = true;
        this.nZW = true;
      }
      AppMethodBeat.o(113113);
      return;
      localObject = (Integer)g.agR().agA().get(ah.a.GFp, Integer.valueOf(0));
      if ((localObject != null) && (((Integer)localObject).intValue() != 1)) {
        g.agR().agA().set(ah.a.GFp, Integer.valueOf(1));
      }
    }
  }
  
  public final boolean bOD()
  {
    AppMethodBeat.i(113125);
    boolean bool = super.bOD();
    AppMethodBeat.o(113125);
    return bool;
  }
  
  public final boolean bOE()
  {
    return false;
  }
  
  public final void bOI()
  {
    AppMethodBeat.i(113121);
    this.oad = true;
    if (this.oab)
    {
      ac.e("MicroMsg.ShareCardListUI", "onLocationFinish, has do GetShareCardLayout,don't get again");
      if (this.oaf) {
        bOH();
      }
      AppMethodBeat.o(113121);
      return;
    }
    ac.d("MicroMsg.ShareCardListUI", "onLocationFinish()");
    this.oab = true;
    bRj();
    bOH();
    AppMethodBeat.o(113121);
  }
  
  public final void bOJ()
  {
    AppMethodBeat.i(113122);
    if ((this.oac) || (this.oab))
    {
      bOH();
      AppMethodBeat.o(113122);
      return;
    }
    this.oac = true;
    ac.i("MicroMsg.ShareCardListUI", "onLocationFail()");
    bRj();
    AppMethodBeat.o(113122);
  }
  
  public final void bOK()
  {
    AppMethodBeat.i(113112);
    ac.i("MicroMsg.ShareCardListUI", "onMPermissionGranted LocationPermissionGranted " + this.oaf);
    if (!this.oaf)
    {
      this.oaf = true;
      bRd();
    }
    AppMethodBeat.o(113112);
  }
  
  public final void bPt()
  {
    AppMethodBeat.i(113131);
    com.tencent.mm.plugin.card.sharecard.a.b.bQL();
    this.nZV = true;
    ac.i("MicroMsg.ShareCardListUI", "onDBchange() shouldRefreshDataOnDbChange %s  mIsActive %s hasLocationInfo %s", new Object[] { Boolean.valueOf(this.nZW), Boolean.valueOf(this.nSQ), Boolean.valueOf(this.oad) });
    if ((this.nZW) && (this.nSQ) && (this.oad)) {
      jj(false);
    }
    for (;;)
    {
      this.nZW = false;
      AppMethodBeat.o(113131);
      return;
      bRe();
    }
  }
  
  public void initView()
  {
    AppMethodBeat.i(113110);
    super.initView();
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null);
    ac.i("MicroMsg.ShareCardListUI", "checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
    this.oaf = bool;
    if (this.oaf)
    {
      bRd();
      AppMethodBeat.o(113110);
      return;
    }
    ac.e("MicroMsg.ShareCardListUI", "location permission is denied, doGetLayout");
    bRj();
    AppMethodBeat.o(113110);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113104);
    super.onCreate(paramBundle);
    long l = System.currentTimeMillis();
    this.mStartTime = l;
    this.oag = l;
    initView();
    g.agQ().ghe.a(1164, this);
    am.bQp().a(this);
    bRm();
    am.bQq().add(this);
    AppMethodBeat.o(113104);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113105);
    if (this.oaf) {
      bOH();
    }
    this.nZR.nZI = null;
    this.nZS.nZI = null;
    this.nZI.nYb = null;
    g.agQ().ghe.b(1164, this);
    am.bQp().b(this);
    com.tencent.mm.plugin.card.sharecard.a.b.bQP();
    am.bQq().remove(this);
    long l = System.currentTimeMillis() - this.oag;
    if (!TextUtils.isEmpty(this.nVh)) {
      com.tencent.mm.plugin.report.service.h.wUl.f(13219, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Long.valueOf(l) });
    }
    for (;;)
    {
      super.onDestroy();
      AppMethodBeat.o(113105);
      return;
      com.tencent.mm.plugin.report.service.h.wUl.f(13219, new Object[] { "ShareCardListUI", Integer.valueOf(1), "", "", Long.valueOf(l) });
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(113114);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    bRm();
    if (paramIntent != null)
    {
      this.nVh = paramIntent.getStringExtra("KEY_CARD_TP_ID");
      if (!bs.isNullOrNil(this.nVh))
      {
        this.nZU = true;
        this.nZW = true;
      }
    }
    AppMethodBeat.o(113114);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(113108);
    super.onPause();
    this.nZV = false;
    this.nZW = true;
    AppMethodBeat.o(113108);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(113106);
    jj(true);
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
      com.tencent.mm.plugin.report.service.h.wUl.b(localArrayList, true);
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
        this.nZZ = false;
        this.oaa = paramString.nYj;
        this.nZI.aF(paramString.nWw, this.nZX);
        if ((!com.tencent.mm.plugin.card.sharecard.a.b.bQQ()) || (!com.tencent.mm.plugin.card.sharecard.a.b.bQR())) {
          this.nZX = false;
        }
        if ((com.tencent.mm.plugin.card.sharecard.a.b.bQQ()) && (com.tencent.mm.plugin.card.sharecard.a.b.bQR())) {}
        for (;;)
        {
          this.nZY = bool;
          ac.i("MicroMsg.ShareCardListUI", "NetSceneGetShareCardsLayout() >> updateView()");
          bRe();
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
        if (this.oai)
        {
          this.oai = false;
          this.nZS.bRa();
          this.nSK.setEmptyView(this.nSM);
          this.nSK.invalidate();
        }
        this.nZZ = false;
        this.nZY = true;
      }
      ac.i("MicroMsg.ShareCardListUI", "share card list ui, onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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