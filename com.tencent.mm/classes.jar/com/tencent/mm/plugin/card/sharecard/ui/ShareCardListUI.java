package com.tencent.mm.plugin.card.sharecard.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.plugin.card.ui.CardDetailUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.ArrayList;

public class ShareCardListUI
  extends CardBaseUI
  implements com.tencent.mm.plugin.card.base.d, k.a
{
  private long jXb = 0L;
  private final long jXc = 500L;
  private boolean jXd = false;
  private String knc = null;
  private b.a kpH = null;
  private i krA;
  private boolean krB = false;
  private boolean krC = true;
  private boolean krD = false;
  private boolean krE = true;
  private boolean krF = true;
  private boolean krG = false;
  private String krH = "";
  private boolean krI = false;
  private boolean krJ = false;
  private boolean krK = false;
  private int krL = 0;
  private boolean krM = false;
  private long krN = 0L;
  boolean krO = false;
  private boolean krP = false;
  private com.tencent.mm.plugin.card.sharecard.a.b krp;
  private f kry;
  private e krz;
  private long mStartTime = 0L;
  
  private void bJ()
  {
    AppMethodBeat.i(88182);
    bda();
    ab.i("MicroMsg.ShareCardListUI", "updateView() currentType is %s, canShowLocalCity %s, canShowOtherCity %s", new Object[] { Integer.valueOf(this.krL), Boolean.valueOf(com.tencent.mm.plugin.card.sharecard.a.b.bcD()), Boolean.valueOf(com.tencent.mm.plugin.card.sharecard.a.b.bcC()) });
    this.kry.bJ();
    if ((!com.tencent.mm.plugin.card.sharecard.a.b.bcD()) && (!com.tencent.mm.plugin.card.sharecard.a.b.bcC()))
    {
      this.krz.bcR();
      this.krA.bdc();
      bcU();
    }
    for (;;)
    {
      bcX();
      AppMethodBeat.o(88182);
      return;
      this.krz.bJ();
      this.krA.bJ();
      if (this.krL == 4) {
        bcW();
      }
    }
  }
  
  private void bcS()
  {
    AppMethodBeat.i(88177);
    ab.d("MicroMsg.ShareCardListUI", "initLocation");
    com.tencent.mm.sdk.g.d.ysn.a(new ShareCardListUI.1(this), "MicroMsg.ShareCardListUI");
    AppMethodBeat.o(88177);
  }
  
  private void bcT()
  {
    AppMethodBeat.i(88181);
    long l = System.currentTimeMillis() - this.jXb;
    if ((this.jXd) && (l < 1000L))
    {
      ab.d("MicroMsg.ShareCardListUI", "DoingUpdateView return");
      AppMethodBeat.o(88181);
      return;
    }
    ab.d("MicroMsg.ShareCardListUI", "try2UpdateView isDoingUpdateView %s,interval %s", new Object[] { Boolean.valueOf(this.jXd), Long.valueOf(l) });
    this.jXd = true;
    if (l < 500L)
    {
      al.p(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(88169);
          ShareCardListUI.i(ShareCardListUI.this);
          if (!ShareCardListUI.this.isFinishing())
          {
            ShareCardListUI.j(ShareCardListUI.this);
            AppMethodBeat.o(88169);
            return;
          }
          ab.w("MicroMsg.ShareCardListUI", "Activity is finished!!!");
          AppMethodBeat.o(88169);
        }
      }, 500L);
      AppMethodBeat.o(88181);
      return;
    }
    bJ();
    this.jXb = System.currentTimeMillis();
    this.jXd = false;
    AppMethodBeat.o(88181);
  }
  
  private void bcU()
  {
    AppMethodBeat.i(88183);
    if (this.kkF.getEmptyView() != this.kkH)
    {
      this.kkF.setEmptyView(this.kkH);
      this.kkF.invalidate();
    }
    AppMethodBeat.o(88183);
  }
  
  private void bcV()
  {
    AppMethodBeat.i(88184);
    if ((!com.tencent.mm.plugin.card.sharecard.a.b.bcD()) && (!com.tencent.mm.plugin.card.sharecard.a.b.bcC()))
    {
      this.krz.bcO();
      this.kkF.setEmptyView(null);
      this.kkF.invalidate();
      this.krP = true;
    }
    AppMethodBeat.o(88184);
  }
  
  private void bcW()
  {
    AppMethodBeat.i(88185);
    if (this.kkF.getEmptyView() != null)
    {
      this.kkF.setEmptyView(null);
      this.kkF.invalidate();
    }
    AppMethodBeat.o(88185);
  }
  
  private void bcX()
  {
    AppMethodBeat.i(88186);
    if ((this.kkG instanceof c)) {
      ((c)this.kkG).tf(this.krL);
    }
    AppMethodBeat.o(88186);
  }
  
  private void bcY()
  {
    AppMethodBeat.i(88189);
    if ((com.tencent.mm.plugin.card.sharecard.a.b.bcF()) && (com.tencent.mm.plugin.card.sharecard.a.b.bcG()))
    {
      ab.i("MicroMsg.ShareCardListUI", "doGetLayout() no data to load");
      this.krF = true;
      AppMethodBeat.o(88189);
      return;
    }
    if ((!com.tencent.mm.plugin.card.sharecard.a.b.bcF()) || (!com.tencent.mm.plugin.card.sharecard.a.b.bcG())) {
      this.krE = false;
    }
    ab.i("MicroMsg.ShareCardListUI", "doGetLayout() >> doNetSceneGetCardsHomePageLayout()");
    bcZ();
    am.bcj().w("", "", 4);
    AppMethodBeat.o(88189);
  }
  
  private void bcZ()
  {
    AppMethodBeat.i(88190);
    if (this.krG)
    {
      ab.e("MicroMsg.ShareCardListUI", "doNetSceneGetCardsHomePageLayout, isDoingGetData is true");
      AppMethodBeat.o(88190);
      return;
    }
    if ((bo.isNullOrNil(this.krH)) && (!com.tencent.mm.plugin.card.sharecard.a.b.bcD()) && (!com.tencent.mm.plugin.card.sharecard.a.b.bcC())) {
      bcV();
    }
    if ((this.krE) && (!bo.isNullOrNil(this.krH))) {
      this.krH = "";
    }
    this.krG = true;
    com.tencent.mm.plugin.card.sharecard.model.b localb = new com.tencent.mm.plugin.card.sharecard.model.b(am.bcj().dZu, am.bcj().dZv, this.krH);
    g.RK().eHt.a(localb, 0);
    AppMethodBeat.o(88190);
  }
  
  private void bda()
  {
    AppMethodBeat.i(88196);
    if ((this.krL == 0) || (this.krL == 4) || ((this.krL == 2) && ((!com.tencent.mm.plugin.card.sharecard.a.b.bcD()) || (!com.tencent.mm.plugin.card.sharecard.a.b.bcC()))) || ((this.krL == 1) && ((!com.tencent.mm.plugin.card.sharecard.a.b.bcD()) || (com.tencent.mm.plugin.card.sharecard.a.b.bcC()))) || ((this.krL == 3) && ((!com.tencent.mm.plugin.card.sharecard.a.b.bcC()) || (com.tencent.mm.plugin.card.sharecard.a.b.bcD())))) {
      this.krL = com.tencent.mm.plugin.card.sharecard.a.b.bcB();
    }
    am.bci().putValue("key_share_card_show_type", Integer.valueOf(this.krL));
    AppMethodBeat.o(88196);
  }
  
  private void bdb()
  {
    AppMethodBeat.i(88199);
    int i = getIntent().getIntExtra("key_from_scene", 22);
    boolean bool1 = com.tencent.mm.x.c.PJ().cc(262152, 266256);
    boolean bool2 = com.tencent.mm.x.c.PJ().cd(262152, 266256);
    boolean bool3 = com.tencent.mm.x.c.PJ().a(ac.a.yyN, ac.a.yyP);
    boolean bool4 = com.tencent.mm.x.c.PJ().a(ac.a.yyO, ac.a.yyQ);
    String str = bo.nullAsNil((String)g.RL().Ru().get(ac.a.yyT, null));
    if (bool1)
    {
      h.qsU.e(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(2), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(88199);
      return;
    }
    if (bool2)
    {
      h.qsU.e(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(88199);
      return;
    }
    if ((bool3) && (!bool4))
    {
      h.qsU.e(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(3), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(88199);
      return;
    }
    if ((bool3) && (bool4))
    {
      h.qsU.e(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(4), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(88199);
      return;
    }
    if (bool4)
    {
      h.qsU.e(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(5), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(88199);
      return;
    }
    h.qsU.e(11324, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(i), "", Integer.valueOf(0), str });
    AppMethodBeat.o(88199);
  }
  
  private void fX(boolean paramBoolean)
  {
    AppMethodBeat.i(88173);
    ab.i("MicroMsg.ShareCardListUI", "doRefreshData() >> updateView() shouldGetLayout %s fromOnresume %s", new Object[] { Boolean.valueOf(this.krC), Boolean.valueOf(paramBoolean) });
    if (this.krC)
    {
      this.krC = false;
      this.krI = false;
      this.krE = true;
      this.krH = "";
      ab.d("MicroMsg.ShareCardListUI", "doRefreshData() >> doNetSceneGetCardsHomePageLayout()");
      if (!paramBoolean) {
        break label104;
      }
      if ((this.krM) && (this.krO)) {
        baC();
      }
    }
    for (;;)
    {
      bcT();
      AppMethodBeat.o(88173);
      return;
      label104:
      bcZ();
    }
  }
  
  public final BaseAdapter Kp()
  {
    AppMethodBeat.i(88175);
    c localc = new c(getContext());
    AppMethodBeat.o(88175);
    return localc;
  }
  
  public final void a(com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(88193);
    super.a(paramb);
    AppMethodBeat.o(88193);
  }
  
  public final void a(com.tencent.mm.plugin.card.base.b paramb, int paramInt)
  {
    AppMethodBeat.i(88194);
    Intent localIntent = new Intent(this, CardDetailUI.class);
    ab.i("MicroMsg.ShareCardListUI", "card tp id:" + paramb.bbi());
    ab.i("MicroMsg.ShareCardListUI", "card id:" + paramb.bbh());
    localIntent.putExtra("key_card_id", am.bcl().HX(paramb.bbi()));
    localIntent.putExtra("key_card_tp_id", paramb.bbi());
    localIntent.putExtra("key_is_share_card", true);
    localIntent.putExtra("key_from_scene", 3);
    startActivity(localIntent);
    com.tencent.mm.plugin.card.sharecard.a.b.HU(paramb.bbi());
    AppMethodBeat.o(88194);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(88198);
    ab.d("MicroMsg.ShareCardListUI", "onNotifyChange");
    this.krC = true;
    AppMethodBeat.o(88198);
  }
  
  public final void b(com.tencent.mm.plugin.card.base.b paramb, int paramInt)
  {
    AppMethodBeat.i(88192);
    if (paramb != null) {
      com.tencent.mm.plugin.card.sharecard.a.b.HP(paramb.bbi());
    }
    super.b(paramb, paramInt);
    AppMethodBeat.o(88192);
  }
  
  public final boolean baA()
  {
    return false;
  }
  
  public final void baE()
  {
    AppMethodBeat.i(88187);
    this.krK = true;
    if (this.krI)
    {
      ab.e("MicroMsg.ShareCardListUI", "onLocationFinish, has do GetShareCardLayout,don't get again");
      if (this.krM) {
        baD();
      }
      AppMethodBeat.o(88187);
      return;
    }
    ab.d("MicroMsg.ShareCardListUI", "onLocationFinish()");
    this.krI = true;
    bcY();
    baD();
    AppMethodBeat.o(88187);
  }
  
  public final void baF()
  {
    AppMethodBeat.i(88188);
    if ((this.krJ) || (this.krI))
    {
      baD();
      AppMethodBeat.o(88188);
      return;
    }
    this.krJ = true;
    ab.i("MicroMsg.ShareCardListUI", "onLocationFail()");
    bcY();
    AppMethodBeat.o(88188);
  }
  
  public final void baG()
  {
    AppMethodBeat.i(88178);
    ab.i("MicroMsg.ShareCardListUI", "onMPermissionGranted LocationPermissionGranted " + this.krM);
    if (!this.krM)
    {
      this.krM = true;
      bcS();
    }
    AppMethodBeat.o(88178);
  }
  
  public final void bax()
  {
    AppMethodBeat.i(88179);
    setMMTitle(2131298035);
    this.krp = new com.tencent.mm.plugin.card.sharecard.a.b(this);
    this.kpH = new ShareCardListUI.2(this);
    this.krp.kpH = this.kpH;
    this.krp.init();
    this.krL = com.tencent.mm.plugin.card.sharecard.a.b.bcB();
    Object localObject;
    if (this.krA == null)
    {
      this.krA = new i(this, getContentView());
      localObject = this.krA;
      ((i)localObject).krR = View.inflate(((i)localObject).jpX, 2130968992, null);
      ((i)localObject).krS = ((TextView)((i)localObject).krR.findViewById(2131822354));
      ((i)localObject).krT = ((TextView)((i)localObject).krR.findViewById(2131822355));
      ((i)localObject).bJ();
    }
    if (this.kry == null)
    {
      this.kry = new f(this, getContentView());
      localObject = this.kry;
      ((f)localObject).krt = ((ImageView)((f)localObject).iCk.findViewById(2131822246));
      ((f)localObject).krv = ((TextView)((f)localObject).iCk.findViewById(2131821982));
      ((f)localObject).kru = ((TextView)((f)localObject).iCk.findViewById(2131822248));
      this.kry.krp = this.krp;
    }
    if (this.krz == null)
    {
      getContentView();
      this.krz = new e(this);
      this.krz.krp = this.krp;
      this.krz.bcM();
      localObject = this.krz;
      ShareCardListUI.3 local3 = new ShareCardListUI.3(this);
      if (((e)localObject).kro != null) {
        ((e)localObject).kro.setOnClickListener(local3);
      }
    }
    if (this.kkI != null) {
      this.kkI.addView(this.krA.krR);
    }
    if (this.kkJ != null) {
      this.kkJ.addView(this.krz.kro);
    }
    this.kkF.setVisibility(0);
    this.kkF.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(88168);
        if ((paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1) && (!ShareCardListUI.g(ShareCardListUI.this)) && (ShareCardListUI.d(ShareCardListUI.this) != 4))
        {
          ab.d("MicroMsg.ShareCardListUI", "onScroll() >> doNetSceneGetCardsHomePageLayout()");
          ShareCardListUI.h(ShareCardListUI.this);
        }
        AppMethodBeat.o(88168);
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    if ((getIntent() != null) && (getIntent().getBooleanExtra("KEY_IS_SHOW_SHARE_CARD_ENTRANCE_TIPS", true)))
    {
      localObject = (Integer)g.RL().Ru().get(ac.a.yzf, Integer.valueOf(0));
      if ((localObject == null) || (((Integer)localObject).intValue() != 1))
      {
        g.RL().Ru().set(ac.a.yzf, Integer.valueOf(1));
        com.tencent.mm.plugin.card.d.d.c(this, 2130968999, 2131298045, "");
      }
    }
    for (;;)
    {
      this.knc = getIntent().getStringExtra("KEY_CARD_TP_ID");
      this.krH = getIntent().getStringExtra("key_layout_buff");
      if (!bo.isNullOrNil(this.krH)) {
        this.krC = false;
      }
      if (!bo.isNullOrNil(this.knc))
      {
        this.krB = true;
        this.krD = true;
      }
      AppMethodBeat.o(88179);
      return;
      localObject = (Integer)g.RL().Ru().get(ac.a.yzf, Integer.valueOf(0));
      if ((localObject != null) && (((Integer)localObject).intValue() != 1)) {
        g.RL().Ru().set(ac.a.yzf, Integer.valueOf(1));
      }
    }
  }
  
  public final boolean baz()
  {
    AppMethodBeat.i(88191);
    boolean bool = super.baz();
    AppMethodBeat.o(88191);
    return bool;
  }
  
  public final void bbo()
  {
    AppMethodBeat.i(88197);
    com.tencent.mm.plugin.card.sharecard.a.b.bcA();
    this.krC = true;
    ab.i("MicroMsg.ShareCardListUI", "onDBchange() shouldRefreshDataOnDbChange %s  mIsActive %s hasLocationInfo %s", new Object[] { Boolean.valueOf(this.krD), Boolean.valueOf(this.kkL), Boolean.valueOf(this.krK) });
    if ((this.krD) && (this.kkL) && (this.krK)) {
      fX(false);
    }
    for (;;)
    {
      this.krD = false;
      AppMethodBeat.o(88197);
      return;
      bcT();
    }
  }
  
  public void initView()
  {
    AppMethodBeat.i(88176);
    super.initView();
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null);
    ab.i("MicroMsg.ShareCardListUI", "checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
    this.krM = bool;
    if (this.krM)
    {
      bcS();
      AppMethodBeat.o(88176);
      return;
    }
    ab.e("MicroMsg.ShareCardListUI", "location permission is denied, doGetLayout");
    bcY();
    AppMethodBeat.o(88176);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(88170);
    super.onCreate(paramBundle);
    long l = System.currentTimeMillis();
    this.mStartTime = l;
    this.krN = l;
    initView();
    g.RK().eHt.a(1164, this);
    am.bck().a(this);
    bdb();
    am.bcl().add(this);
    AppMethodBeat.o(88170);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(88171);
    if (this.krM) {
      baD();
    }
    this.kry.krp = null;
    this.krz.krp = null;
    this.krp.kpH = null;
    g.RK().eHt.b(1164, this);
    am.bck().b(this);
    com.tencent.mm.plugin.card.sharecard.a.b.bcE();
    am.bcl().remove(this);
    long l = System.currentTimeMillis() - this.krN;
    if (!TextUtils.isEmpty(this.knc)) {
      h.qsU.e(13219, new Object[] { "ShareCardListUI", Integer.valueOf(0), "", "", Long.valueOf(l) });
    }
    for (;;)
    {
      super.onDestroy();
      AppMethodBeat.o(88171);
      return;
      h.qsU.e(13219, new Object[] { "ShareCardListUI", Integer.valueOf(1), "", "", Long.valueOf(l) });
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(88180);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    bdb();
    if (paramIntent != null)
    {
      this.knc = paramIntent.getStringExtra("KEY_CARD_TP_ID");
      if (!bo.isNullOrNil(this.knc))
      {
        this.krB = true;
        this.krD = true;
      }
    }
    AppMethodBeat.o(88180);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(88174);
    super.onPause();
    this.krC = false;
    this.krD = true;
    AppMethodBeat.o(88174);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(88172);
    fX(true);
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
      h.qsU.b(localArrayList, true);
      this.mStartTime = 0L;
    }
    super.onResume();
    AppMethodBeat.o(88172);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    boolean bool = true;
    AppMethodBeat.i(88195);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramm);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof com.tencent.mm.plugin.card.sharecard.model.b))
      {
        paramString = (com.tencent.mm.plugin.card.sharecard.model.b)paramm;
        this.krG = false;
        this.krH = paramString.kpP;
        this.krp.ay(paramString.koi, this.krE);
        if ((!com.tencent.mm.plugin.card.sharecard.a.b.bcF()) || (!com.tencent.mm.plugin.card.sharecard.a.b.bcG())) {
          this.krE = false;
        }
        if ((com.tencent.mm.plugin.card.sharecard.a.b.bcF()) && (com.tencent.mm.plugin.card.sharecard.a.b.bcG())) {}
        for (;;)
        {
          this.krF = bool;
          ab.i("MicroMsg.ShareCardListUI", "NetSceneGetShareCardsLayout() >> updateView()");
          bcT();
          AppMethodBeat.o(88195);
          return;
          bool = false;
        }
      }
    }
    else
    {
      if ((paramm instanceof com.tencent.mm.plugin.card.sharecard.model.b))
      {
        if (this.krP)
        {
          this.krP = false;
          this.krz.bcP();
          this.kkF.setEmptyView(this.kkH);
          this.kkF.invalidate();
        }
        this.krG = false;
        this.krF = true;
      }
      ab.i("MicroMsg.ShareCardListUI", "share card list ui, onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    AppMethodBeat.o(88195);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.ShareCardListUI
 * JD-Core Version:    0.7.0.1
 */