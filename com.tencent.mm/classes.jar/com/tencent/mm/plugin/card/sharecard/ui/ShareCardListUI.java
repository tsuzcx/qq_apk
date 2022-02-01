package com.tencent.mm.plugin.card.sharecard.ui;

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
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.ui.CardDetailUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.ArrayList;

public class ShareCardListUI
  extends CardBaseUI
  implements com.tencent.mm.plugin.card.base.d, MStorage.IOnStorageChange
{
  private long mStartTime = 0L;
  private long vIv = 0L;
  private final long vIw = 500L;
  private boolean vIx = false;
  private String wtm = null;
  private b.a wwk = null;
  private com.tencent.mm.plugin.card.sharecard.a.b wxM;
  private f wxU;
  private e wxV;
  private i wxW;
  private boolean wxX = false;
  private boolean wxY = true;
  private boolean wxZ = false;
  private boolean wya = true;
  private boolean wyb = true;
  private boolean wyc = false;
  private String wyd = "";
  private boolean wye = false;
  private boolean wyf = false;
  private boolean wyg = false;
  private int wyh = 0;
  private boolean wyi = false;
  private long wyj = 0L;
  boolean wyk = false;
  private boolean wyl = false;
  
  private void dlG()
  {
    AppMethodBeat.i(113111);
    Log.d("MicroMsg.ShareCardListUI", "initLocation");
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(113100);
        ShareCardListUI.a(ShareCardListUI.this);
        ShareCardListUI.b(ShareCardListUI.this);
        ShareCardListUI.this.wyk = true;
        Log.d("MicroMsg.ShareCardListUI", "initLocation end");
        AppMethodBeat.o(113100);
      }
    }, "MicroMsg.ShareCardListUI");
    AppMethodBeat.o(113111);
  }
  
  private void dlH()
  {
    AppMethodBeat.i(113115);
    long l = System.currentTimeMillis() - this.vIv;
    if ((this.vIx) && (l < 1000L))
    {
      Log.d("MicroMsg.ShareCardListUI", "DoingUpdateView return");
      AppMethodBeat.o(113115);
      return;
    }
    Log.d("MicroMsg.ShareCardListUI", "try2UpdateView isDoingUpdateView %s,interval %s", new Object[] { Boolean.valueOf(this.vIx), Long.valueOf(l) });
    this.vIx = true;
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
    this.vIv = System.currentTimeMillis();
    this.vIx = false;
    AppMethodBeat.o(113115);
  }
  
  private void dlI()
  {
    AppMethodBeat.i(113117);
    if (this.wqQ.getEmptyView() != this.wqS)
    {
      this.wqQ.setEmptyView(this.wqS);
      this.wqQ.invalidate();
    }
    AppMethodBeat.o(113117);
  }
  
  private void dlJ()
  {
    AppMethodBeat.i(113118);
    if ((!com.tencent.mm.plugin.card.sharecard.a.b.dls()) && (!com.tencent.mm.plugin.card.sharecard.a.b.dlr()))
    {
      this.wxV.dlD();
      this.wqQ.setEmptyView(null);
      this.wqQ.invalidate();
      this.wyl = true;
    }
    AppMethodBeat.o(113118);
  }
  
  private void dlK()
  {
    AppMethodBeat.i(113119);
    if (this.wqQ.getEmptyView() != null)
    {
      this.wqQ.setEmptyView(null);
      this.wqQ.invalidate();
    }
    AppMethodBeat.o(113119);
  }
  
  private void dlL()
  {
    AppMethodBeat.i(113120);
    if ((this.wqR instanceof c)) {
      ((c)this.wqR).Iq(this.wyh);
    }
    AppMethodBeat.o(113120);
  }
  
  private void dlM()
  {
    AppMethodBeat.i(113123);
    if ((com.tencent.mm.plugin.card.sharecard.a.b.dlu()) && (com.tencent.mm.plugin.card.sharecard.a.b.dlv()))
    {
      Log.i("MicroMsg.ShareCardListUI", "doGetLayout() no data to load");
      this.wyb = true;
      AppMethodBeat.o(113123);
      return;
    }
    if ((!com.tencent.mm.plugin.card.sharecard.a.b.dlu()) || (!com.tencent.mm.plugin.card.sharecard.a.b.dlv())) {
      this.wya = false;
    }
    Log.i("MicroMsg.ShareCardListUI", "doGetLayout() >> doNetSceneGetCardsHomePageLayout()");
    dlN();
    am.dkP().R("", "", 4);
    AppMethodBeat.o(113123);
  }
  
  private void dlN()
  {
    AppMethodBeat.i(113124);
    if (this.wyc)
    {
      Log.e("MicroMsg.ShareCardListUI", "doNetSceneGetCardsHomePageLayout, isDoingGetData is true");
      AppMethodBeat.o(113124);
      return;
    }
    if ((Util.isNullOrNil(this.wyd)) && (!com.tencent.mm.plugin.card.sharecard.a.b.dls()) && (!com.tencent.mm.plugin.card.sharecard.a.b.dlr())) {
      dlJ();
    }
    if ((this.wya) && (!Util.isNullOrNil(this.wyd))) {
      this.wyd = "";
    }
    this.wyc = true;
    com.tencent.mm.plugin.card.sharecard.model.b localb = new com.tencent.mm.plugin.card.sharecard.model.b(am.dkP().lsz, am.dkP().lsA, this.wyd);
    com.tencent.mm.kernel.h.baD().mCm.a(localb, 0);
    AppMethodBeat.o(113124);
  }
  
  private void dlO()
  {
    AppMethodBeat.i(113130);
    if ((this.wyh == 0) || (this.wyh == 4) || ((this.wyh == 2) && ((!com.tencent.mm.plugin.card.sharecard.a.b.dls()) || (!com.tencent.mm.plugin.card.sharecard.a.b.dlr()))) || ((this.wyh == 1) && ((!com.tencent.mm.plugin.card.sharecard.a.b.dls()) || (com.tencent.mm.plugin.card.sharecard.a.b.dlr()))) || ((this.wyh == 3) && ((!com.tencent.mm.plugin.card.sharecard.a.b.dlr()) || (com.tencent.mm.plugin.card.sharecard.a.b.dls())))) {
      this.wyh = com.tencent.mm.plugin.card.sharecard.a.b.dlq();
    }
    am.dkO().z("key_share_card_show_type", Integer.valueOf(this.wyh));
    AppMethodBeat.o(113130);
  }
  
  private void dlP()
  {
    AppMethodBeat.i(113133);
    int i = getIntent().getIntExtra("key_from_scene", 22);
    boolean bool1 = com.tencent.mm.aa.c.aYo().dV(262152, 266256);
    boolean bool2 = com.tencent.mm.aa.c.aYo().dW(262152, 266256);
    boolean bool3 = com.tencent.mm.aa.c.aYo().a(at.a.acJh, at.a.acJj);
    boolean bool4 = com.tencent.mm.aa.c.aYo().a(at.a.acJi, at.a.acJk);
    String str = Util.nullAsNil((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acJn, null));
    if (bool1)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(2), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113133);
      return;
    }
    if (bool2)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113133);
      return;
    }
    if ((bool3) && (!bool4))
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(3), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113133);
      return;
    }
    if ((bool3) && (bool4))
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(4), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113133);
      return;
    }
    if (bool4)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(5), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113133);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(i), "", Integer.valueOf(0), str });
    AppMethodBeat.o(113133);
  }
  
  private void nb(boolean paramBoolean)
  {
    AppMethodBeat.i(113107);
    Log.i("MicroMsg.ShareCardListUI", "doRefreshData() >> updateView() shouldGetLayout %s fromOnresume %s", new Object[] { Boolean.valueOf(this.wxY), Boolean.valueOf(paramBoolean) });
    if (this.wxY)
    {
      this.wxY = false;
      this.wye = false;
      this.wya = true;
      this.wyd = "";
      Log.d("MicroMsg.ShareCardListUI", "doRefreshData() >> doNetSceneGetCardsHomePageLayout()");
      if (!paramBoolean) {
        break label104;
      }
      if ((this.wyi) && (this.wyk)) {
        djh();
      }
    }
    for (;;)
    {
      dlH();
      AppMethodBeat.o(113107);
      return;
      label104:
      dlN();
    }
  }
  
  private void updateView()
  {
    AppMethodBeat.i(113116);
    dlO();
    Log.i("MicroMsg.ShareCardListUI", "updateView() currentType is %s, canShowLocalCity %s, canShowOtherCity %s", new Object[] { Integer.valueOf(this.wyh), Boolean.valueOf(com.tencent.mm.plugin.card.sharecard.a.b.dls()), Boolean.valueOf(com.tencent.mm.plugin.card.sharecard.a.b.dlr()) });
    this.wxU.updateView();
    if ((!com.tencent.mm.plugin.card.sharecard.a.b.dls()) && (!com.tencent.mm.plugin.card.sharecard.a.b.dlr()))
    {
      this.wxV.ddX();
      this.wxW.dlQ();
      dlI();
    }
    for (;;)
    {
      dlL();
      AppMethodBeat.o(113116);
      return;
      this.wxV.updateView();
      this.wxW.updateView();
      if (this.wyh == 4) {
        dlK();
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
    Log.i("MicroMsg.ShareCardListUI", "card tp id:" + paramb.djP());
    Log.i("MicroMsg.ShareCardListUI", "card id:" + paramb.djO());
    ((Intent)localObject).putExtra("key_card_id", am.dkR().akQ(paramb.djP()));
    ((Intent)localObject).putExtra("key_card_tp_id", paramb.djP());
    ((Intent)localObject).putExtra("key_is_share_card", true);
    ((Intent)localObject).putExtra("key_from_scene", 3);
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/card/sharecard/ui/ShareCardListUI", "onGotoCardDetailUI", "(Lcom/tencent/mm/plugin/card/base/ICardInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/card/sharecard/ui/ShareCardListUI", "onGotoCardDetailUI", "(Lcom/tencent/mm/plugin/card/base/ICardInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.plugin.card.sharecard.a.b.akN(paramb.djP());
    AppMethodBeat.o(113128);
  }
  
  public final BaseAdapter aNu()
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
      com.tencent.mm.plugin.card.sharecard.a.b.akI(paramb.djP());
    }
    super.b(paramb, paramInt);
    AppMethodBeat.o(113126);
  }
  
  public final void djU()
  {
    AppMethodBeat.i(113131);
    com.tencent.mm.plugin.card.sharecard.a.b.dlp();
    this.wxY = true;
    Log.i("MicroMsg.ShareCardListUI", "onDBchange() shouldRefreshDataOnDbChange %s  mIsActive %s hasLocationInfo %s", new Object[] { Boolean.valueOf(this.wxZ), Boolean.valueOf(this.wqW), Boolean.valueOf(this.wyg) });
    if ((this.wxZ) && (this.wqW) && (this.wyg)) {
      nb(false);
    }
    for (;;)
    {
      this.wxZ = false;
      AppMethodBeat.o(113131);
      return;
      dlH();
    }
  }
  
  public final void djb()
  {
    AppMethodBeat.i(113113);
    setMMTitle(a.g.wpX);
    this.wxM = new com.tencent.mm.plugin.card.sharecard.a.b(this);
    this.wwk = new b.a() {};
    this.wxM.wwk = this.wwk;
    this.wxM.init();
    this.wyh = com.tencent.mm.plugin.card.sharecard.a.b.dlq();
    Object localObject;
    if (this.wxW == null)
    {
      this.wxW = new i(this, getContentView());
      localObject = this.wxW;
      ((i)localObject).wyn = View.inflate(((i)localObject).wry, a.e.wnC, null);
      ((i)localObject).wyo = ((TextView)((i)localObject).wyn.findViewById(a.d.wgN));
      ((i)localObject).wyp = ((TextView)((i)localObject).wyn.findViewById(a.d.wgP));
      ((i)localObject).updateView();
    }
    if (this.wxU == null)
    {
      this.wxU = new f(this, getContentView());
      localObject = this.wxU;
      ((f)localObject).wxQ = ((ImageView)((f)localObject).plc.findViewById(a.d.wkE));
      ((f)localObject).wxS = ((TextView)((f)localObject).plc.findViewById(a.d.wkG));
      ((f)localObject).wxR = ((TextView)((f)localObject).plc.findViewById(a.d.wkH));
      this.wxU.wxM = this.wxM;
    }
    if (this.wxV == null)
    {
      getContentView();
      this.wxV = new e(this);
      this.wxV.wxM = this.wxM;
      this.wxV.dlB();
      localObject = this.wxV;
      View.OnClickListener local3 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113101);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/sharecard/ui/ShareCardListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          ShareCardListUI.c(ShareCardListUI.this);
          if (com.tencent.mm.plugin.card.sharecard.a.b.dls())
          {
            ShareCardListUI.c(ShareCardListUI.this);
            if (com.tencent.mm.plugin.card.sharecard.a.b.dlr()) {
              ShareCardListUI.a(ShareCardListUI.this, 2);
            }
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.OAn.b(11582, new Object[] { "OperChangeOtherCity ", Integer.valueOf(0), Integer.valueOf(0), "", "", "" });
            am.dkO().z("key_share_card_show_type", Integer.valueOf(ShareCardListUI.d(ShareCardListUI.this)));
            ShareCardListUI.e(ShareCardListUI.this);
            ShareCardListUI.f(ShareCardListUI.this).updateView();
            ShareCardListUI.c(ShareCardListUI.this);
            com.tencent.mm.plugin.card.sharecard.a.b.wwl = true;
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/sharecard/ui/ShareCardListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(113101);
            return;
            ShareCardListUI.c(ShareCardListUI.this);
            if (com.tencent.mm.plugin.card.sharecard.a.b.dlr()) {
              ShareCardListUI.a(ShareCardListUI.this, 3);
            }
          }
        }
      };
      if (((e)localObject).wxL != null) {
        ((e)localObject).wxL.setOnClickListener(local3);
      }
    }
    if (this.wqT != null) {
      this.wqT.addView(this.wxW.wyn);
    }
    if (this.wqU != null) {
      this.wqU.addView(this.wxV.wxL);
    }
    this.wqQ.setVisibility(0);
    this.wqQ.setOnScrollListener(new AbsListView.OnScrollListener()
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
      localObject = (Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acJz, Integer.valueOf(0));
      if ((localObject == null) || (((Integer)localObject).intValue() != 1))
      {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acJz, Integer.valueOf(1));
        com.tencent.mm.plugin.card.c.d.c(this, a.e.wnH, a.g.wqe, "");
      }
    }
    for (;;)
    {
      this.wtm = getIntent().getStringExtra("KEY_CARD_TP_ID");
      this.wyd = getIntent().getStringExtra("key_layout_buff");
      if (!Util.isNullOrNil(this.wyd)) {
        this.wxY = false;
      }
      if (!Util.isNullOrNil(this.wtm))
      {
        this.wxX = true;
        this.wxZ = true;
      }
      AppMethodBeat.o(113113);
      return;
      localObject = (Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acJz, Integer.valueOf(0));
      if ((localObject != null) && (((Integer)localObject).intValue() != 1)) {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acJz, Integer.valueOf(1));
      }
    }
  }
  
  public final boolean djd()
  {
    AppMethodBeat.i(113125);
    boolean bool = super.djd();
    AppMethodBeat.o(113125);
    return bool;
  }
  
  public final boolean dje()
  {
    return false;
  }
  
  public final void djj()
  {
    AppMethodBeat.i(113121);
    this.wyg = true;
    if (this.wye)
    {
      Log.e("MicroMsg.ShareCardListUI", "onLocationFinish, has do GetShareCardLayout,don't get again");
      if (this.wyi) {
        dji();
      }
      AppMethodBeat.o(113121);
      return;
    }
    Log.d("MicroMsg.ShareCardListUI", "onLocationFinish()");
    this.wye = true;
    dlM();
    dji();
    AppMethodBeat.o(113121);
  }
  
  public final void djk()
  {
    AppMethodBeat.i(113122);
    if ((this.wyf) || (this.wye))
    {
      dji();
      AppMethodBeat.o(113122);
      return;
    }
    this.wyf = true;
    Log.i("MicroMsg.ShareCardListUI", "onLocationFail()");
    dlM();
    AppMethodBeat.o(113122);
  }
  
  public final void djl()
  {
    AppMethodBeat.i(113112);
    Log.i("MicroMsg.ShareCardListUI", "onMPermissionGranted LocationPermissionGranted " + this.wyi);
    if (!this.wyi)
    {
      this.wyi = true;
      dlG();
    }
    AppMethodBeat.o(113112);
  }
  
  public void initView()
  {
    AppMethodBeat.i(113110);
    super.initView();
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 69, null);
    Log.i("MicroMsg.ShareCardListUI", "checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
    this.wyi = bool;
    if (this.wyi)
    {
      dlG();
      AppMethodBeat.o(113110);
      return;
    }
    Log.e("MicroMsg.ShareCardListUI", "location permission is denied, doGetLayout");
    dlM();
    AppMethodBeat.o(113110);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113104);
    super.onCreate(paramBundle);
    long l = System.currentTimeMillis();
    this.mStartTime = l;
    this.wyj = l;
    initView();
    com.tencent.mm.kernel.h.baD().mCm.a(1164, this);
    am.dkQ().a(this);
    dlP();
    am.dkR().add(this);
    AppMethodBeat.o(113104);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113105);
    if (this.wyi) {
      dji();
    }
    this.wxU.wxM = null;
    this.wxV.wxM = null;
    this.wxM.wwk = null;
    com.tencent.mm.kernel.h.baD().mCm.b(1164, this);
    am.dkQ().b(this);
    com.tencent.mm.plugin.card.sharecard.a.b.dlt();
    am.dkR().remove(this);
    long l = System.currentTimeMillis() - this.wyj;
    if (!TextUtils.isEmpty(this.wtm)) {
      com.tencent.mm.plugin.report.service.h.OAn.b(13219, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Long.valueOf(l) });
    }
    for (;;)
    {
      super.onDestroy();
      AppMethodBeat.o(113105);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.b(13219, new Object[] { "ShareCardListUI", Integer.valueOf(1), "", "", Long.valueOf(l) });
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(113114);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    dlP();
    if (paramIntent != null)
    {
      this.wtm = paramIntent.getStringExtra("KEY_CARD_TP_ID");
      if (!Util.isNullOrNil(this.wtm))
      {
        this.wxX = true;
        this.wxZ = true;
      }
    }
    AppMethodBeat.o(113114);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(113132);
    Log.d("MicroMsg.ShareCardListUI", "onNotifyChange");
    this.wxY = true;
    AppMethodBeat.o(113132);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(113108);
    super.onPause();
    this.wxY = false;
    this.wxZ = true;
    AppMethodBeat.o(113108);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(113106);
    nb(true);
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
      com.tencent.mm.plugin.report.service.h.OAn.b(localArrayList, true);
      this.mStartTime = 0L;
    }
    super.onResume();
    AppMethodBeat.o(113106);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    boolean bool = true;
    AppMethodBeat.i(113129);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramp);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramp instanceof com.tencent.mm.plugin.card.sharecard.model.b))
      {
        paramString = (com.tencent.mm.plugin.card.sharecard.model.b)paramp;
        this.wyc = false;
        this.wyd = paramString.wws;
        this.wxM.ba(paramString.wuy, this.wya);
        if ((!com.tencent.mm.plugin.card.sharecard.a.b.dlu()) || (!com.tencent.mm.plugin.card.sharecard.a.b.dlv())) {
          this.wya = false;
        }
        if ((com.tencent.mm.plugin.card.sharecard.a.b.dlu()) && (com.tencent.mm.plugin.card.sharecard.a.b.dlv())) {}
        for (;;)
        {
          this.wyb = bool;
          Log.i("MicroMsg.ShareCardListUI", "NetSceneGetShareCardsLayout() >> updateView()");
          dlH();
          AppMethodBeat.o(113129);
          return;
          bool = false;
        }
      }
    }
    else
    {
      if ((paramp instanceof com.tencent.mm.plugin.card.sharecard.model.b))
      {
        if (this.wyl)
        {
          this.wyl = false;
          this.wxV.dlE();
          this.wqQ.setEmptyView(this.wqS);
          this.wqQ.invalidate();
        }
        this.wyc = false;
        this.wyb = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.ShareCardListUI
 * JD-Core Version:    0.7.0.1
 */