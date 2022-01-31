package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.model.ad;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ow;
import com.tencent.mm.protocal.protobuf.pj;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

@com.tencent.mm.kernel.i
public class CardHomePageUI
  extends CardBaseUI
  implements com.tencent.mm.plugin.card.base.d, k.a
{
  private int fromScene = 0;
  private boolean krC = false;
  private boolean krE = true;
  private boolean krG = false;
  private String krH = "";
  private boolean krI = false;
  private boolean krJ = false;
  private long krN = 0L;
  boolean krO = false;
  private com.tencent.mm.plugin.card.sharecard.a.b krp;
  private i kvY;
  private f kvZ;
  private f kwa;
  private boolean kwb = true;
  private boolean kwc = false;
  private TextView kwd;
  private LinearLayout kwe;
  private long mStartTime = 0L;
  
  private void a(pj parampj)
  {
    AppMethodBeat.i(88513);
    this.kwe.removeAllViews();
    if ((parampj != null) && (parampj.wGQ != null) && (!parampj.wGQ.isEmpty()))
    {
      parampj = parampj.wGQ.iterator();
      while (parampj.hasNext())
      {
        ow localow = (ow)parampj.next();
        View localView = LayoutInflater.from(getContext()).inflate(2130968943, this.kwe, false);
        new f(this, localView, 4, this.krp, localow).setOnClickListener(new CardHomePageUI.8(this, localow));
        this.kwe.addView(localView);
      }
    }
    AppMethodBeat.o(88513);
  }
  
  private void bJ()
  {
    AppMethodBeat.i(88501);
    ab.i("MicroMsg.CardHomePageUI", "updateView()");
    this.kvY.bel();
    bee();
    this.kwa.bJ();
    AppMethodBeat.o(88501);
  }
  
  private void bcS()
  {
    AppMethodBeat.i(88498);
    ab.d("MicroMsg.CardHomePageUI", "initLocation");
    g.RO().ac(new CardHomePageUI.4(this));
    AppMethodBeat.o(88498);
  }
  
  private void bcY()
  {
    AppMethodBeat.i(88506);
    ab.d("MicroMsg.CardHomePageUI", "doGetLayout() >> doNetSceneGetCardsHomePageLayout()");
    bcZ();
    if (com.tencent.mm.plugin.card.d.l.bfA()) {
      com.tencent.mm.plugin.card.b.b.bbr();
    }
    for (;;)
    {
      am.bcj().w("", "", 4);
      AppMethodBeat.o(88506);
      return;
      ab.i("MicroMsg.CardHomePageUI", "the card entrance is not open, don't do doNetSceneGetCardsLayout!");
    }
  }
  
  private void bcZ()
  {
    AppMethodBeat.i(88507);
    if (!this.kwb)
    {
      ab.i("MicroMsg.CardHomePageUI", "doNetSceneGetCardsHomePageLayout, shouldGetHomePage is false");
      AppMethodBeat.o(88507);
      return;
    }
    if (this.krG)
    {
      ab.e("MicroMsg.CardHomePageUI", "doNetSceneGetCardsHomePageLayout, isDoingGetData is true");
      AppMethodBeat.o(88507);
      return;
    }
    if ((this.krE) && (!bo.isNullOrNil(this.krH))) {
      this.krH = "";
    }
    this.krG = true;
    this.kwb = false;
    com.tencent.mm.plugin.card.sharecard.model.b localb = new com.tencent.mm.plugin.card.sharecard.model.b(am.bcj().dZu, am.bcj().dZv, this.krH);
    g.RK().eHt.a(localb, 0);
    AppMethodBeat.o(88507);
  }
  
  private void bdb()
  {
    AppMethodBeat.i(88514);
    int i = getIntent().getIntExtra("key_from_scene", 22);
    boolean bool1 = com.tencent.mm.x.c.PJ().cc(262152, 266256);
    boolean bool2 = com.tencent.mm.x.c.PJ().cd(262152, 266256);
    boolean bool3 = com.tencent.mm.x.c.PJ().a(ac.a.yyN, ac.a.yyP);
    boolean bool4 = com.tencent.mm.x.c.PJ().a(ac.a.yyO, ac.a.yyQ);
    String str = bo.nullAsNil((String)g.RL().Ru().get(ac.a.yyT, null));
    if (bool1)
    {
      h.qsU.e(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(2), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(88514);
      return;
    }
    if (bool2)
    {
      h.qsU.e(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(88514);
      return;
    }
    if ((bool3) && (!bool4))
    {
      h.qsU.e(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(3), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(88514);
      return;
    }
    if ((bool3) && (bool4))
    {
      h.qsU.e(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(4), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(88514);
      return;
    }
    if (bool4)
    {
      h.qsU.e(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(5), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(88514);
      return;
    }
    h.qsU.e(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(i), "", Integer.valueOf(0), str });
    AppMethodBeat.o(88514);
  }
  
  private void bee()
  {
    AppMethodBeat.i(88502);
    ab.i("MicroMsg.CardHomePageUI", "updateMemberCardItem()");
    Object localObject = (c)this.kkG;
    if (this.kwd == null)
    {
      this.kwd = ((TextView)findViewById(2131822239));
      this.kwd.setOnClickListener(new CardHomePageUI.5(this));
    }
    if (((c)localObject).getCount() > 0)
    {
      this.kwd.setVisibility(0);
      this.kwd.setText(getString(2131298056, new Object[] { Integer.valueOf(com.tencent.mm.plugin.card.sharecard.a.b.bcz()) }));
    }
    for (;;)
    {
      this.kvZ.bed();
      AppMethodBeat.o(88502);
      return;
      this.kwd.setVisibility(0);
      this.kwd.setText(getString(2131298056, new Object[] { Integer.valueOf(com.tencent.mm.plugin.card.sharecard.a.b.bcz()) }));
      localObject = (LinearLayout)findViewById(2131822238);
      if (localObject != null)
      {
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
        localLayoutParams.topMargin = com.tencent.mm.cb.a.fromDPToPix(this, 29);
        localLayoutParams.bottomMargin = com.tencent.mm.cb.a.fromDPToPix(this, 29);
        ((LinearLayout)localObject).setLayoutParams(localLayoutParams);
      }
    }
  }
  
  private static pj bef()
  {
    AppMethodBeat.i(88512);
    String str = (String)g.RL().Ru().get(ac.a.yzm, null);
    if (bo.isNullOrNil(str))
    {
      AppMethodBeat.o(88512);
      return null;
    }
    pj localpj = new pj();
    try
    {
      localpj.parseFrom(str.getBytes("ISO-8859-1"));
      AppMethodBeat.o(88512);
      return localpj;
    }
    catch (IOException localIOException)
    {
      ab.printErrStackTrace("MicroMsg.CardHomePageUI", localIOException, "", new Object[0]);
      AppMethodBeat.o(88512);
    }
    return null;
  }
  
  private void beg()
  {
    AppMethodBeat.i(88516);
    Intent localIntent = new Intent();
    localIntent.addFlags(67108864);
    localIntent.putExtra("preferred_tab", 3);
    com.tencent.mm.bq.d.f(this, "com.tencent.mm.ui.LauncherUI", localIntent);
    finish();
    AppMethodBeat.o(88516);
  }
  
  public final void a(com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(88510);
    super.a(paramb);
    AppMethodBeat.o(88510);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    this.krC = true;
  }
  
  public final void b(com.tencent.mm.plugin.card.base.b paramb, int paramInt)
  {
    AppMethodBeat.i(88509);
    super.b(paramb, paramInt);
    AppMethodBeat.o(88509);
  }
  
  public final boolean baA()
  {
    return true;
  }
  
  public final void baE()
  {
    AppMethodBeat.i(88504);
    if (this.krI)
    {
      ab.e("MicroMsg.CardHomePageUI", "onLocationFinish, has do GetShareCardLayout,don't get again");
      if (this.kwc) {
        baD();
      }
      AppMethodBeat.o(88504);
      return;
    }
    ab.d("MicroMsg.CardHomePageUI", "onLocationFinish()");
    this.krI = true;
    bcY();
    baD();
    AppMethodBeat.o(88504);
  }
  
  public final void baF()
  {
    AppMethodBeat.i(88505);
    if ((this.krJ) || (this.krI))
    {
      baD();
      AppMethodBeat.o(88505);
      return;
    }
    this.krJ = true;
    ab.i("MicroMsg.CardHomePageUI", "onLocationFail()");
    bcY();
    AppMethodBeat.o(88505);
  }
  
  public final void baG()
  {
    AppMethodBeat.i(88499);
    ab.i("MicroMsg.CardHomePageUI", "onMPermissionGranted locationPermissionGranted " + this.kwc);
    if (!this.kwc)
    {
      this.kwc = true;
      bcS();
    }
    AppMethodBeat.o(88499);
  }
  
  public final void baH()
  {
    AppMethodBeat.i(88503);
    bee();
    AppMethodBeat.o(88503);
  }
  
  public final void bax()
  {
    AppMethodBeat.i(88497);
    setMMTitle(2131297950);
    addTextOptionMenu(0, getString(2131297999), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(88484);
        com.tencent.mm.plugin.card.d.b.a(CardHomePageUI.this, true);
        h.qsU.e(11582, new Object[] { "CardListMsgMenu", Integer.valueOf(2), Integer.valueOf(0), "", "" });
        AppMethodBeat.o(88484);
        return true;
      }
    });
    this.krp = new com.tencent.mm.plugin.card.sharecard.a.b(this);
    this.krp.init();
    if (this.kvY == null)
    {
      this.kvY = new i(this, getContentView());
      localObject = this.kvY;
      ((i)localObject).kxa = View.inflate(((i)localObject).jpX, 2130968973, null);
      ((i)localObject).kxa.setVisibility(8);
      ((i)localObject).kxb = ((TextView)((i)localObject).kxa.findViewById(2131822304));
      ((i)localObject).kxc = ((ImageView)((i)localObject).kxa.findViewById(2131822303));
      ((i)localObject).kxa.setOnClickListener(new i.1((i)localObject));
      ((i)localObject).bel();
      if (((i)localObject).kxd == null)
      {
        ((i)localObject).kxd = ((ViewStub)((i)localObject).iCk.findViewById(2131822236)).inflate();
        ((i)localObject).kxd.setVisibility(8);
        ((i)localObject).kxe = ((TextView)((i)localObject).kxd.findViewById(2131822304));
        ((i)localObject).kxf = ((ImageView)((i)localObject).kxd.findViewById(2131822303));
        ((i)localObject).kxd.setOnClickListener(new i.2((i)localObject));
      }
      this.kvY.krU = true;
    }
    if (this.kvZ == null) {
      this.kvZ = new f(this, findViewById(2131822240), 1, this.krp);
    }
    if (this.kwa == null) {
      this.kwa = new f(this, findViewById(2131822241), 3, this.krp);
    }
    if (this.kvZ != null) {
      this.kvZ.setOnClickListener(new CardHomePageUI.6(this));
    }
    if (this.kwa != null) {
      this.kwa.setOnClickListener(new CardHomePageUI.7(this));
    }
    this.kwe = ((LinearLayout)findViewById(2131822242));
    Object localObject = bef();
    if (localObject != null) {
      a((pj)localObject);
    }
    setBackBtn(new CardHomePageUI.3(this));
    AppMethodBeat.o(88497);
  }
  
  public final n.a bay()
  {
    return n.a.kof;
  }
  
  public final boolean baz()
  {
    AppMethodBeat.i(88508);
    boolean bool = super.baz();
    AppMethodBeat.o(88508);
    return bool;
  }
  
  public final void bbo()
  {
    this.krC = true;
  }
  
  public int getLayoutId()
  {
    return 2130968956;
  }
  
  public void initView()
  {
    AppMethodBeat.i(88496);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null);
    ab.i("MicroMsg.CardHomePageUI", "checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
    this.kwc = bool;
    if (this.kwc) {
      bcS();
    }
    for (;;)
    {
      super.initView();
      AppMethodBeat.o(88496);
      return;
      ab.e("MicroMsg.CardHomePageUI", "location permission is denied, doGetLayout");
      bcY();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(88492);
    super.onCreate(paramBundle);
    this.fromScene = getIntent().getIntExtra("key_home_page_from_scene", 0);
    long l = System.currentTimeMillis();
    this.mStartTime = l;
    this.krN = l;
    initView();
    paramBundle = this.kvY;
    am.bch().a(paramBundle);
    g.RK().eHt.a(1164, this);
    g.RK().eHt.a(984, this);
    am.bck().bcy();
    am.bcc();
    com.tencent.mm.plugin.card.b.b.sW(1);
    bdb();
    Looper.myQueue().addIdleHandler(new CardHomePageUI.9(this));
    am.bck().a(this);
    am.bcd().add(this);
    ((com.tencent.mm.pluginsdk.wallet.c)g.E(com.tencent.mm.pluginsdk.wallet.c.class)).eJ(8, 2);
    AppMethodBeat.o(88492);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(88493);
    if (this.kwc) {
      baD();
    }
    i locali = this.kvY;
    am.bch().b(locali);
    this.krp.kpH = null;
    g.RK().eHt.b(1164, this);
    g.RK().eHt.b(984, this);
    am.bck().b(this);
    am.bcd().remove(this);
    k.bbS();
    com.tencent.mm.plugin.card.sharecard.a.b.bcE();
    long l1 = System.currentTimeMillis();
    long l2 = this.krN;
    h.qsU.e(13219, new Object[] { "CardHomePageUI", Integer.valueOf(this.fromScene), "", "", Long.valueOf(l1 - l2) });
    super.onDestroy();
    AppMethodBeat.o(88493);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(88515);
    if (paramInt == 4)
    {
      if ((this.fromScene != 1) && (this.fromScene != 2)) {
        break label46;
      }
      beg();
    }
    for (;;)
    {
      boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
      AppMethodBeat.o(88515);
      return bool;
      label46:
      finish();
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(88500);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    bdb();
    this.krC = true;
    this.kwb = true;
    AppMethodBeat.o(88500);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(88495);
    super.onPause();
    AppMethodBeat.o(88495);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(88494);
    ab.i("MicroMsg.CardHomePageUI", "onResume locationPermissionGranted %s, hasInitLocation %s, shouldGetLayout %s", new Object[] { Boolean.valueOf(this.kwc), Boolean.valueOf(this.krO), Boolean.valueOf(this.krC) });
    if (this.kwc) {
      if ((this.krO) && (this.krC))
      {
        this.krH = "";
        this.krI = false;
        baC();
      }
    }
    for (;;)
    {
      this.krC = false;
      bJ();
      long l = System.currentTimeMillis();
      if (this.mStartTime != 0L)
      {
        int i = (int)(l - this.mStartTime);
        ArrayList localArrayList = new ArrayList();
        IDKey localIDKey1 = new IDKey();
        localIDKey1.SetID(281);
        localIDKey1.SetKey(0);
        localIDKey1.SetValue(1L);
        IDKey localIDKey2 = new IDKey();
        localIDKey2.SetID(281);
        localIDKey2.SetKey(1);
        localIDKey2.SetValue(i);
        localArrayList.add(localIDKey1);
        localArrayList.add(localIDKey2);
        h.qsU.b(localArrayList, true);
        this.mStartTime = 0L;
      }
      g.RO().ac(new CardHomePageUI.1(this));
      super.onResume();
      AppMethodBeat.o(88494);
      return;
      if (this.krC)
      {
        this.krH = "";
        bcY();
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(88511);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramm);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof ad))
      {
        bee();
        this.kkM.aaK();
        this.kwa.bJ();
        a(((ad)paramm).koz);
        AppMethodBeat.o(88511);
        return;
      }
      if ((paramm instanceof com.tencent.mm.plugin.card.sharecard.model.b))
      {
        paramString = (com.tencent.mm.plugin.card.sharecard.model.b)paramm;
        this.krG = false;
        this.krH = paramString.kpP;
        this.krp.ay(paramString.koi, this.krE);
        if ((!com.tencent.mm.plugin.card.sharecard.a.b.bcF()) || (!com.tencent.mm.plugin.card.sharecard.a.b.bcG())) {
          this.krE = false;
        }
        ab.i("MicroMsg.CardHomePageUI", "NetSceneGetShareCardsLayout() >> updateView()");
        bJ();
        AppMethodBeat.o(88511);
      }
    }
    else
    {
      if ((paramm instanceof com.tencent.mm.plugin.card.sharecard.model.b)) {
        this.krG = false;
      }
      ab.i("MicroMsg.CardHomePageUI", "share card list ui, onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    AppMethodBeat.o(88511);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardHomePageUI
 * JD-Core Version:    0.7.0.1
 */