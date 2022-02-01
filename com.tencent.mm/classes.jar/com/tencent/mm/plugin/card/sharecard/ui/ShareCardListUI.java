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
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
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
  private long mStartTime = 0L;
  private long sCB = 0L;
  private final long sCC = 500L;
  private boolean sCD = false;
  private String toN = null;
  private b.a trM = null;
  private boolean ttA = false;
  private boolean ttB = true;
  private boolean ttC = false;
  private boolean ttD = true;
  private boolean ttE = true;
  private boolean ttF = false;
  private String ttG = "";
  private boolean ttH = false;
  private boolean ttI = false;
  private boolean ttJ = false;
  private int ttK = 0;
  private boolean ttL = false;
  private long ttM = 0L;
  boolean ttN = false;
  private boolean ttO = false;
  private com.tencent.mm.plugin.card.sharecard.a.b ttp;
  private f ttx;
  private e tty;
  private i ttz;
  
  private void cIp()
  {
    AppMethodBeat.i(113111);
    Log.d("MicroMsg.ShareCardListUI", "initLocation");
    com.tencent.e.h.ZvG.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(113100);
        ShareCardListUI.a(ShareCardListUI.this);
        ShareCardListUI.b(ShareCardListUI.this);
        ShareCardListUI.this.ttN = true;
        Log.d("MicroMsg.ShareCardListUI", "initLocation end");
        AppMethodBeat.o(113100);
      }
    }, "MicroMsg.ShareCardListUI");
    AppMethodBeat.o(113111);
  }
  
  private void cIq()
  {
    AppMethodBeat.i(113115);
    long l = System.currentTimeMillis() - this.sCB;
    if ((this.sCD) && (l < 1000L))
    {
      Log.d("MicroMsg.ShareCardListUI", "DoingUpdateView return");
      AppMethodBeat.o(113115);
      return;
    }
    Log.d("MicroMsg.ShareCardListUI", "try2UpdateView isDoingUpdateView %s,interval %s", new Object[] { Boolean.valueOf(this.sCD), Long.valueOf(l) });
    this.sCD = true;
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
    this.sCB = System.currentTimeMillis();
    this.sCD = false;
    AppMethodBeat.o(113115);
  }
  
  private void cIr()
  {
    AppMethodBeat.i(113117);
    if (this.tmq.getEmptyView() != this.tms)
    {
      this.tmq.setEmptyView(this.tms);
      this.tmq.invalidate();
    }
    AppMethodBeat.o(113117);
  }
  
  private void cIs()
  {
    AppMethodBeat.i(113118);
    if ((!com.tencent.mm.plugin.card.sharecard.a.b.cIb()) && (!com.tencent.mm.plugin.card.sharecard.a.b.cIa()))
    {
      this.tty.cIm();
      this.tmq.setEmptyView(null);
      this.tmq.invalidate();
      this.ttO = true;
    }
    AppMethodBeat.o(113118);
  }
  
  private void cIt()
  {
    AppMethodBeat.i(113119);
    if (this.tmq.getEmptyView() != null)
    {
      this.tmq.setEmptyView(null);
      this.tmq.invalidate();
    }
    AppMethodBeat.o(113119);
  }
  
  private void cIu()
  {
    AppMethodBeat.i(113120);
    if ((this.tmr instanceof c)) {
      ((c)this.tmr).HP(this.ttK);
    }
    AppMethodBeat.o(113120);
  }
  
  private void cIv()
  {
    AppMethodBeat.i(113123);
    if ((com.tencent.mm.plugin.card.sharecard.a.b.cId()) && (com.tencent.mm.plugin.card.sharecard.a.b.cIe()))
    {
      Log.i("MicroMsg.ShareCardListUI", "doGetLayout() no data to load");
      this.ttE = true;
      AppMethodBeat.o(113123);
      return;
    }
    if ((!com.tencent.mm.plugin.card.sharecard.a.b.cId()) || (!com.tencent.mm.plugin.card.sharecard.a.b.cIe())) {
      this.ttD = false;
    }
    Log.i("MicroMsg.ShareCardListUI", "doGetLayout() >> doNetSceneGetCardsHomePageLayout()");
    cIw();
    am.cHy().K("", "", 4);
    AppMethodBeat.o(113123);
  }
  
  private void cIw()
  {
    AppMethodBeat.i(113124);
    if (this.ttF)
    {
      Log.e("MicroMsg.ShareCardListUI", "doNetSceneGetCardsHomePageLayout, isDoingGetData is true");
      AppMethodBeat.o(113124);
      return;
    }
    if ((Util.isNullOrNil(this.ttG)) && (!com.tencent.mm.plugin.card.sharecard.a.b.cIb()) && (!com.tencent.mm.plugin.card.sharecard.a.b.cIa())) {
      cIs();
    }
    if ((this.ttD) && (!Util.isNullOrNil(this.ttG))) {
      this.ttG = "";
    }
    this.ttF = true;
    com.tencent.mm.plugin.card.sharecard.model.b localb = new com.tencent.mm.plugin.card.sharecard.model.b(am.cHy().iQD, am.cHy().iQE, this.ttG);
    com.tencent.mm.kernel.h.aHF().kcd.a(localb, 0);
    AppMethodBeat.o(113124);
  }
  
  private void cIx()
  {
    AppMethodBeat.i(113130);
    if ((this.ttK == 0) || (this.ttK == 4) || ((this.ttK == 2) && ((!com.tencent.mm.plugin.card.sharecard.a.b.cIb()) || (!com.tencent.mm.plugin.card.sharecard.a.b.cIa()))) || ((this.ttK == 1) && ((!com.tencent.mm.plugin.card.sharecard.a.b.cIb()) || (com.tencent.mm.plugin.card.sharecard.a.b.cIa()))) || ((this.ttK == 3) && ((!com.tencent.mm.plugin.card.sharecard.a.b.cIa()) || (com.tencent.mm.plugin.card.sharecard.a.b.cIb())))) {
      this.ttK = com.tencent.mm.plugin.card.sharecard.a.b.cHZ();
    }
    am.cHx().r("key_share_card_show_type", Integer.valueOf(this.ttK));
    AppMethodBeat.o(113130);
  }
  
  private void cIy()
  {
    AppMethodBeat.i(113133);
    int i = getIntent().getIntExtra("key_from_scene", 22);
    boolean bool1 = com.tencent.mm.aa.c.aFn().dj(262152, 266256);
    boolean bool2 = com.tencent.mm.aa.c.aFn().dk(262152, 266256);
    boolean bool3 = com.tencent.mm.aa.c.aFn().a(ar.a.VhN, ar.a.VhP);
    boolean bool4 = com.tencent.mm.aa.c.aFn().a(ar.a.VhO, ar.a.VhQ);
    String str = Util.nullAsNil((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VhT, null));
    if (bool1)
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(2), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113133);
      return;
    }
    if (bool2)
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113133);
      return;
    }
    if ((bool3) && (!bool4))
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(3), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113133);
      return;
    }
    if ((bool3) && (bool4))
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(4), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113133);
      return;
    }
    if (bool4)
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(5), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113133);
      return;
    }
    com.tencent.mm.plugin.report.service.h.IzE.a(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(i), "", Integer.valueOf(0), str });
    AppMethodBeat.o(113133);
  }
  
  private void lH(boolean paramBoolean)
  {
    AppMethodBeat.i(113107);
    Log.i("MicroMsg.ShareCardListUI", "doRefreshData() >> updateView() shouldGetLayout %s fromOnresume %s", new Object[] { Boolean.valueOf(this.ttB), Boolean.valueOf(paramBoolean) });
    if (this.ttB)
    {
      this.ttB = false;
      this.ttH = false;
      this.ttD = true;
      this.ttG = "";
      Log.d("MicroMsg.ShareCardListUI", "doRefreshData() >> doNetSceneGetCardsHomePageLayout()");
      if (!paramBoolean) {
        break label104;
      }
      if ((this.ttL) && (this.ttN)) {
        cFP();
      }
    }
    for (;;)
    {
      cIq();
      AppMethodBeat.o(113107);
      return;
      label104:
      cIw();
    }
  }
  
  private void updateView()
  {
    AppMethodBeat.i(113116);
    cIx();
    Log.i("MicroMsg.ShareCardListUI", "updateView() currentType is %s, canShowLocalCity %s, canShowOtherCity %s", new Object[] { Integer.valueOf(this.ttK), Boolean.valueOf(com.tencent.mm.plugin.card.sharecard.a.b.cIb()), Boolean.valueOf(com.tencent.mm.plugin.card.sharecard.a.b.cIa()) });
    this.ttx.updateView();
    if ((!com.tencent.mm.plugin.card.sharecard.a.b.cIb()) && (!com.tencent.mm.plugin.card.sharecard.a.b.cIa()))
    {
      this.tty.cAT();
      this.ttz.cIz();
      cIr();
    }
    for (;;)
    {
      cIu();
      AppMethodBeat.o(113116);
      return;
      this.tty.updateView();
      this.ttz.updateView();
      if (this.ttK == 4) {
        cIt();
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
    Log.i("MicroMsg.ShareCardListUI", "card tp id:" + paramb.cGx());
    Log.i("MicroMsg.ShareCardListUI", "card id:" + paramb.cGw());
    ((Intent)localObject).putExtra("key_card_id", am.cHA().arl(paramb.cGx()));
    ((Intent)localObject).putExtra("key_card_tp_id", paramb.cGx());
    ((Intent)localObject).putExtra("key_is_share_card", true);
    ((Intent)localObject).putExtra("key_from_scene", 3);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/card/sharecard/ui/ShareCardListUI", "onGotoCardDetailUI", "(Lcom/tencent/mm/plugin/card/base/ICardInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/card/sharecard/ui/ShareCardListUI", "onGotoCardDetailUI", "(Lcom/tencent/mm/plugin/card/base/ICardInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.plugin.card.sharecard.a.b.ari(paramb.cGx());
    AppMethodBeat.o(113128);
  }
  
  public final BaseAdapter atn()
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
      com.tencent.mm.plugin.card.sharecard.a.b.ard(paramb.cGx());
    }
    super.b(paramb, paramInt);
    AppMethodBeat.o(113126);
  }
  
  public final void cFJ()
  {
    AppMethodBeat.i(113113);
    setMMTitle(a.g.tly);
    this.ttp = new com.tencent.mm.plugin.card.sharecard.a.b(this);
    this.trM = new b.a() {};
    this.ttp.trM = this.trM;
    this.ttp.init();
    this.ttK = com.tencent.mm.plugin.card.sharecard.a.b.cHZ();
    Object localObject;
    if (this.ttz == null)
    {
      this.ttz = new i(this, getContentView());
      localObject = this.ttz;
      ((i)localObject).ttQ = View.inflate(((i)localObject).tmY, a.e.tjf, null);
      ((i)localObject).ttR = ((TextView)((i)localObject).ttQ.findViewById(a.d.tcA));
      ((i)localObject).ttS = ((TextView)((i)localObject).ttQ.findViewById(a.d.tcB));
      ((i)localObject).updateView();
    }
    if (this.ttx == null)
    {
      this.ttx = new f(this, getContentView());
      localObject = this.ttx;
      ((f)localObject).ttt = ((ImageView)((f)localObject).mrI.findViewById(a.d.tgi));
      ((f)localObject).ttv = ((TextView)((f)localObject).mrI.findViewById(a.d.tgk));
      ((f)localObject).ttu = ((TextView)((f)localObject).mrI.findViewById(a.d.tgl));
      this.ttx.ttp = this.ttp;
    }
    if (this.tty == null)
    {
      getContentView();
      this.tty = new e(this);
      this.tty.ttp = this.ttp;
      this.tty.cIk();
      localObject = this.tty;
      View.OnClickListener local3 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113101);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/sharecard/ui/ShareCardListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          ShareCardListUI.c(ShareCardListUI.this);
          if (com.tencent.mm.plugin.card.sharecard.a.b.cIb())
          {
            ShareCardListUI.c(ShareCardListUI.this);
            if (com.tencent.mm.plugin.card.sharecard.a.b.cIa()) {
              ShareCardListUI.a(ShareCardListUI.this, 2);
            }
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.IzE.a(11582, new Object[] { "OperChangeOtherCity ", Integer.valueOf(0), Integer.valueOf(0), "", "", "" });
            am.cHx().r("key_share_card_show_type", Integer.valueOf(ShareCardListUI.d(ShareCardListUI.this)));
            ShareCardListUI.e(ShareCardListUI.this);
            ShareCardListUI.f(ShareCardListUI.this).updateView();
            ShareCardListUI.c(ShareCardListUI.this);
            com.tencent.mm.plugin.card.sharecard.a.b.trN = true;
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/sharecard/ui/ShareCardListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(113101);
            return;
            ShareCardListUI.c(ShareCardListUI.this);
            if (com.tencent.mm.plugin.card.sharecard.a.b.cIa()) {
              ShareCardListUI.a(ShareCardListUI.this, 3);
            }
          }
        }
      };
      if (((e)localObject).tto != null) {
        ((e)localObject).tto.setOnClickListener(local3);
      }
    }
    if (this.tmt != null) {
      this.tmt.addView(this.ttz.ttQ);
    }
    if (this.tmu != null) {
      this.tmu.addView(this.tty.tto);
    }
    this.tmq.setVisibility(0);
    this.tmq.setOnScrollListener(new AbsListView.OnScrollListener()
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
      localObject = (Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vif, Integer.valueOf(0));
      if ((localObject == null) || (((Integer)localObject).intValue() != 1))
      {
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vif, Integer.valueOf(1));
        com.tencent.mm.plugin.card.d.d.c(this, a.e.tjk, a.g.tlF, "");
      }
    }
    for (;;)
    {
      this.toN = getIntent().getStringExtra("KEY_CARD_TP_ID");
      this.ttG = getIntent().getStringExtra("key_layout_buff");
      if (!Util.isNullOrNil(this.ttG)) {
        this.ttB = false;
      }
      if (!Util.isNullOrNil(this.toN))
      {
        this.ttA = true;
        this.ttC = true;
      }
      AppMethodBeat.o(113113);
      return;
      localObject = (Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vif, Integer.valueOf(0));
      if ((localObject != null) && (((Integer)localObject).intValue() != 1)) {
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vif, Integer.valueOf(1));
      }
    }
  }
  
  public final boolean cFL()
  {
    AppMethodBeat.i(113125);
    boolean bool = super.cFL();
    AppMethodBeat.o(113125);
    return bool;
  }
  
  public final boolean cFM()
  {
    return false;
  }
  
  public final void cFR()
  {
    AppMethodBeat.i(113121);
    this.ttJ = true;
    if (this.ttH)
    {
      Log.e("MicroMsg.ShareCardListUI", "onLocationFinish, has do GetShareCardLayout,don't get again");
      if (this.ttL) {
        cFQ();
      }
      AppMethodBeat.o(113121);
      return;
    }
    Log.d("MicroMsg.ShareCardListUI", "onLocationFinish()");
    this.ttH = true;
    cIv();
    cFQ();
    AppMethodBeat.o(113121);
  }
  
  public final void cFS()
  {
    AppMethodBeat.i(113122);
    if ((this.ttI) || (this.ttH))
    {
      cFQ();
      AppMethodBeat.o(113122);
      return;
    }
    this.ttI = true;
    Log.i("MicroMsg.ShareCardListUI", "onLocationFail()");
    cIv();
    AppMethodBeat.o(113122);
  }
  
  public final void cFT()
  {
    AppMethodBeat.i(113112);
    Log.i("MicroMsg.ShareCardListUI", "onMPermissionGranted LocationPermissionGranted " + this.ttL);
    if (!this.ttL)
    {
      this.ttL = true;
      cIp();
    }
    AppMethodBeat.o(113112);
  }
  
  public final void cGD()
  {
    AppMethodBeat.i(113131);
    com.tencent.mm.plugin.card.sharecard.a.b.cHY();
    this.ttB = true;
    Log.i("MicroMsg.ShareCardListUI", "onDBchange() shouldRefreshDataOnDbChange %s  mIsActive %s hasLocationInfo %s", new Object[] { Boolean.valueOf(this.ttC), Boolean.valueOf(this.tmw), Boolean.valueOf(this.ttJ) });
    if ((this.ttC) && (this.tmw) && (this.ttJ)) {
      lH(false);
    }
    for (;;)
    {
      this.ttC = false;
      AppMethodBeat.o(113131);
      return;
      cIq();
    }
  }
  
  public void initView()
  {
    AppMethodBeat.i(113110);
    super.initView();
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 69, null, null);
    Log.i("MicroMsg.ShareCardListUI", "checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
    this.ttL = bool;
    if (this.ttL)
    {
      cIp();
      AppMethodBeat.o(113110);
      return;
    }
    Log.e("MicroMsg.ShareCardListUI", "location permission is denied, doGetLayout");
    cIv();
    AppMethodBeat.o(113110);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113104);
    super.onCreate(paramBundle);
    long l = System.currentTimeMillis();
    this.mStartTime = l;
    this.ttM = l;
    initView();
    com.tencent.mm.kernel.h.aHF().kcd.a(1164, this);
    am.cHz().a(this);
    cIy();
    am.cHA().add(this);
    AppMethodBeat.o(113104);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113105);
    if (this.ttL) {
      cFQ();
    }
    this.ttx.ttp = null;
    this.tty.ttp = null;
    this.ttp.trM = null;
    com.tencent.mm.kernel.h.aHF().kcd.b(1164, this);
    am.cHz().b(this);
    com.tencent.mm.plugin.card.sharecard.a.b.cIc();
    am.cHA().remove(this);
    long l = System.currentTimeMillis() - this.ttM;
    if (!TextUtils.isEmpty(this.toN)) {
      com.tencent.mm.plugin.report.service.h.IzE.a(13219, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Long.valueOf(l) });
    }
    for (;;)
    {
      super.onDestroy();
      AppMethodBeat.o(113105);
      return;
      com.tencent.mm.plugin.report.service.h.IzE.a(13219, new Object[] { "ShareCardListUI", Integer.valueOf(1), "", "", Long.valueOf(l) });
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(113114);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    cIy();
    if (paramIntent != null)
    {
      this.toN = paramIntent.getStringExtra("KEY_CARD_TP_ID");
      if (!Util.isNullOrNil(this.toN))
      {
        this.ttA = true;
        this.ttC = true;
      }
    }
    AppMethodBeat.o(113114);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(113132);
    Log.d("MicroMsg.ShareCardListUI", "onNotifyChange");
    this.ttB = true;
    AppMethodBeat.o(113132);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(113108);
    super.onPause();
    this.ttB = false;
    this.ttC = true;
    AppMethodBeat.o(113108);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(113106);
    lH(true);
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
      com.tencent.mm.plugin.report.service.h.IzE.b(localArrayList, true);
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
        this.ttF = false;
        this.ttG = paramString.trU;
        this.ttp.aO(paramString.tpZ, this.ttD);
        if ((!com.tencent.mm.plugin.card.sharecard.a.b.cId()) || (!com.tencent.mm.plugin.card.sharecard.a.b.cIe())) {
          this.ttD = false;
        }
        if ((com.tencent.mm.plugin.card.sharecard.a.b.cId()) && (com.tencent.mm.plugin.card.sharecard.a.b.cIe())) {}
        for (;;)
        {
          this.ttE = bool;
          Log.i("MicroMsg.ShareCardListUI", "NetSceneGetShareCardsLayout() >> updateView()");
          cIq();
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
        if (this.ttO)
        {
          this.ttO = false;
          this.tty.cIn();
          this.tmq.setEmptyView(this.tms);
          this.tmq.invalidate();
        }
        this.ttF = false;
        this.ttE = true;
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