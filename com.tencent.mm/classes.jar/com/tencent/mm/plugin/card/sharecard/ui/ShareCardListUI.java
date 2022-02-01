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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
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
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.ArrayList;

public class ShareCardListUI
  extends CardBaseUI
  implements com.tencent.mm.plugin.card.base.d, k.a
{
  private long mStartTime = 0L;
  private b.a oBv = null;
  private long oDA = 0L;
  boolean oDB = false;
  private boolean oDC = false;
  private com.tencent.mm.plugin.card.sharecard.a.b oDc;
  private f oDl;
  private e oDm;
  private i oDn;
  private boolean oDo = false;
  private boolean oDp = true;
  private boolean oDq = false;
  private boolean oDr = true;
  private boolean oDs = true;
  private boolean oDt = false;
  private String oDu = "";
  private boolean oDv = false;
  private boolean oDw = false;
  private boolean oDx = false;
  private int oDy = 0;
  private boolean oDz = false;
  private long obU = 0L;
  private final long obV = 500L;
  private boolean obW = false;
  private String oyC = null;
  
  private void bVI()
  {
    AppMethodBeat.i(113111);
    ad.d("MicroMsg.ShareCardListUI", "initLocation");
    h.LTJ.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(113100);
        ShareCardListUI.a(ShareCardListUI.this);
        ShareCardListUI.b(ShareCardListUI.this);
        ShareCardListUI.this.oDB = true;
        ad.d("MicroMsg.ShareCardListUI", "initLocation end");
        AppMethodBeat.o(113100);
      }
    }, "MicroMsg.ShareCardListUI");
    AppMethodBeat.o(113111);
  }
  
  private void bVJ()
  {
    AppMethodBeat.i(113115);
    long l = System.currentTimeMillis() - this.obU;
    if ((this.obW) && (l < 1000L))
    {
      ad.d("MicroMsg.ShareCardListUI", "DoingUpdateView return");
      AppMethodBeat.o(113115);
      return;
    }
    ad.d("MicroMsg.ShareCardListUI", "try2UpdateView isDoingUpdateView %s,interval %s", new Object[] { Boolean.valueOf(this.obW), Long.valueOf(l) });
    this.obW = true;
    if (l < 500L)
    {
      aq.o(new Runnable()
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
    updateView();
    this.obU = System.currentTimeMillis();
    this.obW = false;
    AppMethodBeat.o(113115);
  }
  
  private void bVK()
  {
    AppMethodBeat.i(113117);
    if (this.owf.getEmptyView() != this.owh)
    {
      this.owf.setEmptyView(this.owh);
      this.owf.invalidate();
    }
    AppMethodBeat.o(113117);
  }
  
  private void bVL()
  {
    AppMethodBeat.i(113118);
    if ((!com.tencent.mm.plugin.card.sharecard.a.b.bVt()) && (!com.tencent.mm.plugin.card.sharecard.a.b.bVs()))
    {
      this.oDm.bVE();
      this.owf.setEmptyView(null);
      this.owf.invalidate();
      this.oDC = true;
    }
    AppMethodBeat.o(113118);
  }
  
  private void bVM()
  {
    AppMethodBeat.i(113119);
    if (this.owf.getEmptyView() != null)
    {
      this.owf.setEmptyView(null);
      this.owf.invalidate();
    }
    AppMethodBeat.o(113119);
  }
  
  private void bVN()
  {
    AppMethodBeat.i(113120);
    if ((this.owg instanceof c)) {
      ((c)this.owg).Ax(this.oDy);
    }
    AppMethodBeat.o(113120);
  }
  
  private void bVO()
  {
    AppMethodBeat.i(113123);
    if ((com.tencent.mm.plugin.card.sharecard.a.b.bVv()) && (com.tencent.mm.plugin.card.sharecard.a.b.bVw()))
    {
      ad.i("MicroMsg.ShareCardListUI", "doGetLayout() no data to load");
      this.oDs = true;
      AppMethodBeat.o(113123);
      return;
    }
    if ((!com.tencent.mm.plugin.card.sharecard.a.b.bVv()) || (!com.tencent.mm.plugin.card.sharecard.a.b.bVw())) {
      this.oDr = false;
    }
    ad.i("MicroMsg.ShareCardListUI", "doGetLayout() >> doNetSceneGetCardsHomePageLayout()");
    bVP();
    am.bUT().H("", "", 4);
    AppMethodBeat.o(113123);
  }
  
  private void bVP()
  {
    AppMethodBeat.i(113124);
    if (this.oDt)
    {
      ad.e("MicroMsg.ShareCardListUI", "doNetSceneGetCardsHomePageLayout, isDoingGetData is true");
      AppMethodBeat.o(113124);
      return;
    }
    if ((bt.isNullOrNil(this.oDu)) && (!com.tencent.mm.plugin.card.sharecard.a.b.bVt()) && (!com.tencent.mm.plugin.card.sharecard.a.b.bVs())) {
      bVL();
    }
    if ((this.oDr) && (!bt.isNullOrNil(this.oDu))) {
      this.oDu = "";
    }
    this.oDt = true;
    com.tencent.mm.plugin.card.sharecard.model.b localb = new com.tencent.mm.plugin.card.sharecard.model.b(am.bUT().fFf, am.bUT().fFg, this.oDu);
    com.tencent.mm.kernel.g.ajB().gAO.a(localb, 0);
    AppMethodBeat.o(113124);
  }
  
  private void bVQ()
  {
    AppMethodBeat.i(113130);
    if ((this.oDy == 0) || (this.oDy == 4) || ((this.oDy == 2) && ((!com.tencent.mm.plugin.card.sharecard.a.b.bVt()) || (!com.tencent.mm.plugin.card.sharecard.a.b.bVs()))) || ((this.oDy == 1) && ((!com.tencent.mm.plugin.card.sharecard.a.b.bVt()) || (com.tencent.mm.plugin.card.sharecard.a.b.bVs()))) || ((this.oDy == 3) && ((!com.tencent.mm.plugin.card.sharecard.a.b.bVs()) || (com.tencent.mm.plugin.card.sharecard.a.b.bVt())))) {
      this.oDy = com.tencent.mm.plugin.card.sharecard.a.b.bVr();
    }
    am.bUS().putValue("key_share_card_show_type", Integer.valueOf(this.oDy));
    AppMethodBeat.o(113130);
  }
  
  private void bVR()
  {
    AppMethodBeat.i(113133);
    int i = getIntent().getIntExtra("key_from_scene", 22);
    boolean bool1 = com.tencent.mm.z.c.aht().cI(262152, 266256);
    boolean bool2 = com.tencent.mm.z.c.aht().cJ(262152, 266256);
    boolean bool3 = com.tencent.mm.z.c.aht().a(al.a.Irp, al.a.Irr);
    boolean bool4 = com.tencent.mm.z.c.aht().a(al.a.Irq, al.a.Irs);
    String str = bt.nullAsNil((String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Irv, null));
    if (bool1)
    {
      com.tencent.mm.plugin.report.service.g.yhR.f(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(2), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113133);
      return;
    }
    if (bool2)
    {
      com.tencent.mm.plugin.report.service.g.yhR.f(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113133);
      return;
    }
    if ((bool3) && (!bool4))
    {
      com.tencent.mm.plugin.report.service.g.yhR.f(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(3), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113133);
      return;
    }
    if ((bool3) && (bool4))
    {
      com.tencent.mm.plugin.report.service.g.yhR.f(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(4), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113133);
      return;
    }
    if (bool4)
    {
      com.tencent.mm.plugin.report.service.g.yhR.f(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(5), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113133);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yhR.f(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(i), "", Integer.valueOf(0), str });
    AppMethodBeat.o(113133);
  }
  
  private void ju(boolean paramBoolean)
  {
    AppMethodBeat.i(113107);
    ad.i("MicroMsg.ShareCardListUI", "doRefreshData() >> updateView() shouldGetLayout %s fromOnresume %s", new Object[] { Boolean.valueOf(this.oDp), Boolean.valueOf(paramBoolean) });
    if (this.oDp)
    {
      this.oDp = false;
      this.oDv = false;
      this.oDr = true;
      this.oDu = "";
      ad.d("MicroMsg.ShareCardListUI", "doRefreshData() >> doNetSceneGetCardsHomePageLayout()");
      if (!paramBoolean) {
        break label104;
      }
      if ((this.oDz) && (this.oDB)) {
        bTl();
      }
    }
    for (;;)
    {
      bVJ();
      AppMethodBeat.o(113107);
      return;
      label104:
      bVP();
    }
  }
  
  private void updateView()
  {
    AppMethodBeat.i(113116);
    bVQ();
    ad.i("MicroMsg.ShareCardListUI", "updateView() currentType is %s, canShowLocalCity %s, canShowOtherCity %s", new Object[] { Integer.valueOf(this.oDy), Boolean.valueOf(com.tencent.mm.plugin.card.sharecard.a.b.bVt()), Boolean.valueOf(com.tencent.mm.plugin.card.sharecard.a.b.bVs()) });
    this.oDl.updateView();
    if ((!com.tencent.mm.plugin.card.sharecard.a.b.bVt()) && (!com.tencent.mm.plugin.card.sharecard.a.b.bVs()))
    {
      this.oDm.bVH();
      this.oDn.bVS();
      bVK();
    }
    for (;;)
    {
      bVN();
      AppMethodBeat.o(113116);
      return;
      this.oDm.updateView();
      this.oDn.updateView();
      if (this.oDy == 4) {
        bVM();
      }
    }
  }
  
  public final BaseAdapter Zp()
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
    ad.i("MicroMsg.ShareCardListUI", "card tp id:" + paramb.bTS());
    ad.i("MicroMsg.ShareCardListUI", "card id:" + paramb.bTR());
    ((Intent)localObject).putExtra("key_card_id", am.bUV().YC(paramb.bTS()));
    ((Intent)localObject).putExtra("key_card_tp_id", paramb.bTS());
    ((Intent)localObject).putExtra("key_is_share_card", true);
    ((Intent)localObject).putExtra("key_from_scene", 3);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/card/sharecard/ui/ShareCardListUI", "onGotoCardDetailUI", "(Lcom/tencent/mm/plugin/card/base/ICardInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/sharecard/ui/ShareCardListUI", "onGotoCardDetailUI", "(Lcom/tencent/mm/plugin/card/base/ICardInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.plugin.card.sharecard.a.b.Yz(paramb.bTS());
    AppMethodBeat.o(113128);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(113132);
    ad.d("MicroMsg.ShareCardListUI", "onNotifyChange");
    this.oDp = true;
    AppMethodBeat.o(113132);
  }
  
  public final void b(com.tencent.mm.plugin.card.base.b paramb, int paramInt)
  {
    AppMethodBeat.i(113126);
    if (paramb != null) {
      com.tencent.mm.plugin.card.sharecard.a.b.Yu(paramb.bTS());
    }
    super.b(paramb, paramInt);
    AppMethodBeat.o(113126);
  }
  
  public final void bTY()
  {
    AppMethodBeat.i(113131);
    com.tencent.mm.plugin.card.sharecard.a.b.bVq();
    this.oDp = true;
    ad.i("MicroMsg.ShareCardListUI", "onDBchange() shouldRefreshDataOnDbChange %s  mIsActive %s hasLocationInfo %s", new Object[] { Boolean.valueOf(this.oDq), Boolean.valueOf(this.owl), Boolean.valueOf(this.oDx) });
    if ((this.oDq) && (this.owl) && (this.oDx)) {
      ju(false);
    }
    for (;;)
    {
      this.oDq = false;
      AppMethodBeat.o(113131);
      return;
      bVJ();
    }
  }
  
  public final void bTg()
  {
    AppMethodBeat.i(113113);
    setMMTitle(2131756977);
    this.oDc = new com.tencent.mm.plugin.card.sharecard.a.b(this);
    this.oBv = new b.a() {};
    this.oDc.oBv = this.oBv;
    this.oDc.init();
    this.oDy = com.tencent.mm.plugin.card.sharecard.a.b.bVr();
    Object localObject;
    if (this.oDn == null)
    {
      this.oDn = new i(this, getContentView());
      localObject = this.oDn;
      ((i)localObject).oDE = View.inflate(((i)localObject).owO, 2131493343, null);
      ((i)localObject).oDF = ((TextView)((i)localObject).oDE.findViewById(2131297834));
      ((i)localObject).oDG = ((TextView)((i)localObject).oDE.findViewById(2131297838));
      ((i)localObject).updateView();
    }
    if (this.oDl == null)
    {
      this.oDl = new f(this, getContentView());
      localObject = this.oDl;
      ((f)localObject).oDg = ((ImageView)((f)localObject).iCR.findViewById(2131302870));
      ((f)localObject).oDi = ((TextView)((f)localObject).iCR.findViewById(2131302872));
      ((f)localObject).oDh = ((TextView)((f)localObject).iCR.findViewById(2131302873));
      this.oDl.oDc = this.oDc;
    }
    if (this.oDm == null)
    {
      getContentView();
      this.oDm = new e(this);
      this.oDm.oDc = this.oDc;
      this.oDm.bVC();
      localObject = this.oDm;
      View.OnClickListener local3 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113101);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/sharecard/ui/ShareCardListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          ShareCardListUI.c(ShareCardListUI.this);
          if (com.tencent.mm.plugin.card.sharecard.a.b.bVt())
          {
            ShareCardListUI.c(ShareCardListUI.this);
            if (com.tencent.mm.plugin.card.sharecard.a.b.bVs()) {
              ShareCardListUI.a(ShareCardListUI.this, 2);
            }
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.g.yhR.f(11582, new Object[] { "OperChangeOtherCity ", Integer.valueOf(0), Integer.valueOf(0), "", "", "" });
            am.bUS().putValue("key_share_card_show_type", Integer.valueOf(ShareCardListUI.d(ShareCardListUI.this)));
            ShareCardListUI.e(ShareCardListUI.this);
            ShareCardListUI.f(ShareCardListUI.this).updateView();
            ShareCardListUI.c(ShareCardListUI.this);
            com.tencent.mm.plugin.card.sharecard.a.b.oBw = true;
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/sharecard/ui/ShareCardListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(113101);
            return;
            ShareCardListUI.c(ShareCardListUI.this);
            if (com.tencent.mm.plugin.card.sharecard.a.b.bVs()) {
              ShareCardListUI.a(ShareCardListUI.this, 3);
            }
          }
        }
      };
      if (((e)localObject).oDb != null) {
        ((e)localObject).oDb.setOnClickListener(local3);
      }
    }
    if (this.owi != null) {
      this.owi.addView(this.oDn.oDE);
    }
    if (this.owj != null) {
      this.owj.addView(this.oDm.oDb);
    }
    this.owf.setVisibility(0);
    this.owf.setOnScrollListener(new AbsListView.OnScrollListener()
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
      localObject = (Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IrH, Integer.valueOf(0));
      if ((localObject == null) || (((Integer)localObject).intValue() != 1))
      {
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IrH, Integer.valueOf(1));
        com.tencent.mm.plugin.card.d.d.c(this, 2131493350, 2131756987, "");
      }
    }
    for (;;)
    {
      this.oyC = getIntent().getStringExtra("KEY_CARD_TP_ID");
      this.oDu = getIntent().getStringExtra("key_layout_buff");
      if (!bt.isNullOrNil(this.oDu)) {
        this.oDp = false;
      }
      if (!bt.isNullOrNil(this.oyC))
      {
        this.oDo = true;
        this.oDq = true;
      }
      AppMethodBeat.o(113113);
      return;
      localObject = (Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IrH, Integer.valueOf(0));
      if ((localObject != null) && (((Integer)localObject).intValue() != 1)) {
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IrH, Integer.valueOf(1));
      }
    }
  }
  
  public final boolean bTi()
  {
    AppMethodBeat.i(113125);
    boolean bool = super.bTi();
    AppMethodBeat.o(113125);
    return bool;
  }
  
  public final boolean bTj()
  {
    return false;
  }
  
  public final void bTn()
  {
    AppMethodBeat.i(113121);
    this.oDx = true;
    if (this.oDv)
    {
      ad.e("MicroMsg.ShareCardListUI", "onLocationFinish, has do GetShareCardLayout,don't get again");
      if (this.oDz) {
        bTm();
      }
      AppMethodBeat.o(113121);
      return;
    }
    ad.d("MicroMsg.ShareCardListUI", "onLocationFinish()");
    this.oDv = true;
    bVO();
    bTm();
    AppMethodBeat.o(113121);
  }
  
  public final void bTo()
  {
    AppMethodBeat.i(113122);
    if ((this.oDw) || (this.oDv))
    {
      bTm();
      AppMethodBeat.o(113122);
      return;
    }
    this.oDw = true;
    ad.i("MicroMsg.ShareCardListUI", "onLocationFail()");
    bVO();
    AppMethodBeat.o(113122);
  }
  
  public final void bTp()
  {
    AppMethodBeat.i(113112);
    ad.i("MicroMsg.ShareCardListUI", "onMPermissionGranted LocationPermissionGranted " + this.oDz);
    if (!this.oDz)
    {
      this.oDz = true;
      bVI();
    }
    AppMethodBeat.o(113112);
  }
  
  public void initView()
  {
    AppMethodBeat.i(113110);
    super.initView();
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null);
    ad.i("MicroMsg.ShareCardListUI", "checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
    this.oDz = bool;
    if (this.oDz)
    {
      bVI();
      AppMethodBeat.o(113110);
      return;
    }
    ad.e("MicroMsg.ShareCardListUI", "location permission is denied, doGetLayout");
    bVO();
    AppMethodBeat.o(113110);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113104);
    super.onCreate(paramBundle);
    long l = System.currentTimeMillis();
    this.mStartTime = l;
    this.oDA = l;
    initView();
    com.tencent.mm.kernel.g.ajB().gAO.a(1164, this);
    am.bUU().a(this);
    bVR();
    am.bUV().add(this);
    AppMethodBeat.o(113104);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113105);
    if (this.oDz) {
      bTm();
    }
    this.oDl.oDc = null;
    this.oDm.oDc = null;
    this.oDc.oBv = null;
    com.tencent.mm.kernel.g.ajB().gAO.b(1164, this);
    am.bUU().b(this);
    com.tencent.mm.plugin.card.sharecard.a.b.bVu();
    am.bUV().remove(this);
    long l = System.currentTimeMillis() - this.oDA;
    if (!TextUtils.isEmpty(this.oyC)) {
      com.tencent.mm.plugin.report.service.g.yhR.f(13219, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Long.valueOf(l) });
    }
    for (;;)
    {
      super.onDestroy();
      AppMethodBeat.o(113105);
      return;
      com.tencent.mm.plugin.report.service.g.yhR.f(13219, new Object[] { "ShareCardListUI", Integer.valueOf(1), "", "", Long.valueOf(l) });
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(113114);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    bVR();
    if (paramIntent != null)
    {
      this.oyC = paramIntent.getStringExtra("KEY_CARD_TP_ID");
      if (!bt.isNullOrNil(this.oyC))
      {
        this.oDo = true;
        this.oDq = true;
      }
    }
    AppMethodBeat.o(113114);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(113108);
    super.onPause();
    this.oDp = false;
    this.oDq = true;
    AppMethodBeat.o(113108);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(113106);
    ju(true);
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
      com.tencent.mm.plugin.report.service.g.yhR.b(localArrayList, true);
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
        this.oDt = false;
        this.oDu = paramString.oBD;
        this.oDc.aH(paramString.ozQ, this.oDr);
        if ((!com.tencent.mm.plugin.card.sharecard.a.b.bVv()) || (!com.tencent.mm.plugin.card.sharecard.a.b.bVw())) {
          this.oDr = false;
        }
        if ((com.tencent.mm.plugin.card.sharecard.a.b.bVv()) && (com.tencent.mm.plugin.card.sharecard.a.b.bVw())) {}
        for (;;)
        {
          this.oDs = bool;
          ad.i("MicroMsg.ShareCardListUI", "NetSceneGetShareCardsLayout() >> updateView()");
          bVJ();
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
        if (this.oDC)
        {
          this.oDC = false;
          this.oDm.bVF();
          this.owf.setEmptyView(this.owh);
          this.owf.invalidate();
        }
        this.oDt = false;
        this.oDs = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.ShareCardListUI
 * JD-Core Version:    0.7.0.1
 */