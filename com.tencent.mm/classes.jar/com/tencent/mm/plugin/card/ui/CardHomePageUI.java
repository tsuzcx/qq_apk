package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.d.r;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.sharecard.ui.ShareCardListUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.rc;
import com.tencent.mm.protocal.protobuf.re;
import com.tencent.mm.protocal.protobuf.rr;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
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
  private long mStartTime = 0L;
  private i nBr;
  private f nBs;
  private f nBt;
  private boolean nBu = true;
  private boolean nBv = false;
  private TextView nBw;
  private LinearLayout nBx;
  private com.tencent.mm.plugin.card.sharecard.a.b nwI;
  private boolean nwV = false;
  private boolean nwX = true;
  private boolean nwZ = false;
  private String nxa = "";
  private boolean nxb = false;
  private boolean nxc = false;
  private long nxg = 0L;
  boolean nxh = false;
  
  private void a(rr paramrr)
  {
    AppMethodBeat.i(113440);
    this.nBx.removeAllViews();
    if ((paramrr != null) && (paramrr.CSv != null) && (!paramrr.CSv.isEmpty()))
    {
      paramrr = paramrr.CSv.iterator();
      while (paramrr.hasNext())
      {
        final re localre = (re)paramrr.next();
        View localView = LayoutInflater.from(getContext()).inflate(2131493285, this.nBx, false);
        new f(this, localView, 4, this.nwI, localre).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(113417);
            if (localre.CRb == 1)
            {
              com.tencent.mm.plugin.card.d.b.a(CardHomePageUI.this, localre.CRc, 0);
              AppMethodBeat.o(113417);
              return;
            }
            if (localre.CRb == 2)
            {
              if (localre.CRd != null)
              {
                paramAnonymousView = new uj();
                paramAnonymousView.dzH.userName = localre.CRd.zHs;
                paramAnonymousView.dzH.dzJ = bt.by(localre.CRd.zHt, "");
                paramAnonymousView.dzH.scene = 1028;
                com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousView);
                AppMethodBeat.o(113417);
              }
            }
            else if (localre.CRb == 3)
            {
              if ("weixin://wccard/sharecarddetail".equals(localre.CRe))
              {
                com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.CardHomePageUI", "go to share card ui");
                Object localObject = new Intent(CardHomePageUI.this, ShareCardListUI.class);
                ((Intent)localObject).putExtra("key_layout_buff", CardHomePageUI.e(CardHomePageUI.this));
                CardHomePageUI.f(CardHomePageUI.this);
                paramAnonymousView = CardHomePageUI.this;
                localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/card/ui/CardHomePageUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/card/ui/CardHomePageUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                h.vKh.f(11324, new Object[] { "ClickShareCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) });
                AppMethodBeat.o(113417);
              }
            }
            else {
              com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.CardHomePageUI", "unknown op action: %s", new Object[] { Integer.valueOf(localre.CRb) });
            }
            AppMethodBeat.o(113417);
          }
        });
        this.nBx.addView(localView);
      }
    }
    AppMethodBeat.o(113440);
  }
  
  private void bJQ()
  {
    AppMethodBeat.i(113425);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.CardHomePageUI", "initLocation");
    com.tencent.mm.kernel.g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(113413);
        CardHomePageUI.c(CardHomePageUI.this);
        CardHomePageUI.d(CardHomePageUI.this);
        CardHomePageUI.this.nxh = true;
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.CardHomePageUI", "initLocation end");
        AppMethodBeat.o(113413);
      }
    });
    AppMethodBeat.o(113425);
  }
  
  private void bJW()
  {
    AppMethodBeat.i(113433);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.CardHomePageUI", "doGetLayout() >> doNetSceneGetCardsHomePageLayout()");
    bJX();
    if (com.tencent.mm.plugin.card.d.l.bML()) {
      com.tencent.mm.plugin.card.b.b.bIj();
    }
    for (;;)
    {
      am.bJb().F("", "", 4);
      AppMethodBeat.o(113433);
      return;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CardHomePageUI", "the card entrance is not open, don't do doNetSceneGetCardsLayout!");
    }
  }
  
  private void bJX()
  {
    AppMethodBeat.i(113434);
    if (!this.nBu)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CardHomePageUI", "doNetSceneGetCardsHomePageLayout, shouldGetHomePage is false");
      AppMethodBeat.o(113434);
      return;
    }
    if (this.nwZ)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.CardHomePageUI", "doNetSceneGetCardsHomePageLayout, isDoingGetData is true");
      AppMethodBeat.o(113434);
      return;
    }
    if ((this.nwX) && (!bt.isNullOrNil(this.nxa))) {
      this.nxa = "";
    }
    this.nwZ = true;
    this.nBu = false;
    com.tencent.mm.plugin.card.sharecard.model.b localb = new com.tencent.mm.plugin.card.sharecard.model.b(am.bJb().fjD, am.bJb().fjE, this.nxa);
    com.tencent.mm.kernel.g.afA().gcy.a(localb, 0);
    AppMethodBeat.o(113434);
  }
  
  private void bJZ()
  {
    AppMethodBeat.i(113441);
    int i = getIntent().getIntExtra("key_from_scene", 22);
    boolean bool1 = com.tencent.mm.z.c.adr().cI(262152, 266256);
    boolean bool2 = com.tencent.mm.z.c.adr().cJ(262152, 266256);
    boolean bool3 = com.tencent.mm.z.c.adr().a(ae.a.Fhi, ae.a.Fhk);
    boolean bool4 = com.tencent.mm.z.c.adr().a(ae.a.Fhj, ae.a.Fhl);
    String str = bt.nullAsNil((String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fho, null));
    if (bool1)
    {
      h.vKh.f(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(2), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113441);
      return;
    }
    if (bool2)
    {
      h.vKh.f(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113441);
      return;
    }
    if ((bool3) && (!bool4))
    {
      h.vKh.f(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(3), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113441);
      return;
    }
    if ((bool3) && (bool4))
    {
      h.vKh.f(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(4), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113441);
      return;
    }
    if (bool4)
    {
      h.vKh.f(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(5), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113441);
      return;
    }
    h.vKh.f(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(i), "", Integer.valueOf(0), str });
    AppMethodBeat.o(113441);
  }
  
  private void bLb()
  {
    AppMethodBeat.i(113429);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CardHomePageUI", "updateMemberCardItem()");
    Object localObject = (c)this.npL;
    if (this.nBw == null)
    {
      this.nBw = ((TextView)findViewById(2131302227));
      this.nBw.setOnClickListener(new CardHomePageUI.5(this));
    }
    if (((c)localObject).getCount() > 0)
    {
      this.nBw.setVisibility(0);
      this.nBw.setText(getString(2131756998, new Object[] { Integer.valueOf(com.tencent.mm.plugin.card.sharecard.a.b.bJx()) }));
    }
    for (;;)
    {
      this.nBs.bLa();
      AppMethodBeat.o(113429);
      return;
      this.nBw.setVisibility(0);
      this.nBw.setText(getString(2131756998, new Object[] { Integer.valueOf(com.tencent.mm.plugin.card.sharecard.a.b.bJx()) }));
      localObject = (LinearLayout)findViewById(2131297813);
      if (localObject != null)
      {
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
        localLayoutParams.topMargin = com.tencent.mm.cd.a.fromDPToPix(this, 29);
        localLayoutParams.bottomMargin = com.tencent.mm.cd.a.fromDPToPix(this, 29);
        ((LinearLayout)localObject).setLayoutParams(localLayoutParams);
      }
    }
  }
  
  private static rr bLc()
  {
    AppMethodBeat.i(113439);
    String str = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FhH, null);
    if (bt.isNullOrNil(str))
    {
      AppMethodBeat.o(113439);
      return null;
    }
    rr localrr = new rr();
    try
    {
      localrr.parseFrom(str.getBytes("ISO-8859-1"));
      AppMethodBeat.o(113439);
      return localrr;
    }
    catch (IOException localIOException)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.CardHomePageUI", localIOException, "", new Object[0]);
      AppMethodBeat.o(113439);
    }
    return null;
  }
  
  private void bLd()
  {
    AppMethodBeat.i(113443);
    Intent localIntent = new Intent();
    localIntent.addFlags(67108864);
    localIntent.putExtra("preferred_tab", 3);
    com.tencent.mm.bs.d.e(this, "com.tencent.mm.ui.LauncherUI", localIntent);
    finish();
    AppMethodBeat.o(113443);
  }
  
  private void cE()
  {
    AppMethodBeat.i(113428);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CardHomePageUI", "updateView()");
    this.nBr.bLi();
    bLb();
    this.nBt.cE();
    AppMethodBeat.o(113428);
  }
  
  public final void a(com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113437);
    super.a(paramb);
    AppMethodBeat.o(113437);
  }
  
  public final void a(String paramString, m paramm)
  {
    this.nwV = true;
  }
  
  public final void b(com.tencent.mm.plugin.card.base.b paramb, int paramInt)
  {
    AppMethodBeat.i(113436);
    super.b(paramb, paramInt);
    AppMethodBeat.o(113436);
  }
  
  public final void bHo()
  {
    AppMethodBeat.i(113424);
    setMMTitle(2131756891);
    addTextOptionMenu(0, getString(2131756941), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(113411);
        com.tencent.mm.plugin.card.d.b.a(CardHomePageUI.this, true);
        h.vKh.f(11582, new Object[] { "CardListMsgMenu", Integer.valueOf(2), Integer.valueOf(0), "", "" });
        AppMethodBeat.o(113411);
        return true;
      }
    });
    this.nwI = new com.tencent.mm.plugin.card.sharecard.a.b(this);
    this.nwI.init();
    if (this.nBr == null)
    {
      this.nBr = new i(this, getContentView());
      localObject = this.nBr;
      ((i)localObject).nCt = View.inflate(((i)localObject).nqt, 2131493324, null);
      ((i)localObject).nCt.setVisibility(8);
      ((i)localObject).nCu = ((TextView)((i)localObject).nCt.findViewById(2131297832));
      ((i)localObject).nCv = ((ImageView)((i)localObject).nCt.findViewById(2131297830));
      ((i)localObject).nCt.setOnClickListener(new i.1((i)localObject));
      ((i)localObject).bLi();
      if (((i)localObject).nCw == null)
      {
        ((i)localObject).nCw = ((ViewStub)((i)localObject).hIZ.findViewById(2131297861)).inflate();
        ((i)localObject).nCw.setVisibility(8);
        ((i)localObject).nCx = ((TextView)((i)localObject).nCw.findViewById(2131297832));
        ((i)localObject).nCy = ((ImageView)((i)localObject).nCw.findViewById(2131297830));
        ((i)localObject).nCw.setOnClickListener(new i.2((i)localObject));
      }
      this.nBr.nxn = true;
    }
    if (this.nBs == null) {
      this.nBs = new f(this, findViewById(2131297858), 1, this.nwI);
    }
    if (this.nBt == null) {
      this.nBt = new f(this, findViewById(2131297906), 3, this.nwI);
    }
    if (this.nBs != null) {
      this.nBs.setOnClickListener(new CardHomePageUI.6(this));
    }
    if (this.nBt != null) {
      this.nBt.setOnClickListener(new CardHomePageUI.7(this));
    }
    this.nBx = ((LinearLayout)findViewById(2131297768));
    Object localObject = bLc();
    if (localObject != null) {
      a((rr)localObject);
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(113412);
        if ((CardHomePageUI.a(CardHomePageUI.this) == 1) || (CardHomePageUI.a(CardHomePageUI.this) == 2)) {
          CardHomePageUI.b(CardHomePageUI.this);
        }
        for (;;)
        {
          AppMethodBeat.o(113412);
          return true;
          CardHomePageUI.this.finish();
        }
      }
    });
    AppMethodBeat.o(113424);
  }
  
  public final n.a bHp()
  {
    return n.a.ntt;
  }
  
  public final boolean bHq()
  {
    AppMethodBeat.i(113435);
    boolean bool = super.bHq();
    AppMethodBeat.o(113435);
    return bool;
  }
  
  public final boolean bHr()
  {
    return true;
  }
  
  public final void bHv()
  {
    AppMethodBeat.i(113431);
    if (this.nxb)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.CardHomePageUI", "onLocationFinish, has do GetShareCardLayout,don't get again");
      if (this.nBv) {
        bHu();
      }
      AppMethodBeat.o(113431);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.CardHomePageUI", "onLocationFinish()");
    this.nxb = true;
    bJW();
    bHu();
    AppMethodBeat.o(113431);
  }
  
  public final void bHw()
  {
    AppMethodBeat.i(113432);
    if ((this.nxc) || (this.nxb))
    {
      bHu();
      AppMethodBeat.o(113432);
      return;
    }
    this.nxc = true;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CardHomePageUI", "onLocationFail()");
    bJW();
    AppMethodBeat.o(113432);
  }
  
  public final void bHx()
  {
    AppMethodBeat.i(113426);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CardHomePageUI", "onMPermissionGranted locationPermissionGranted " + this.nBv);
    if (!this.nBv)
    {
      this.nBv = true;
      bJQ();
    }
    AppMethodBeat.o(113426);
  }
  
  public final void bHy()
  {
    AppMethodBeat.i(113430);
    bLb();
    AppMethodBeat.o(113430);
  }
  
  public final void bIg()
  {
    this.nwV = true;
  }
  
  public int getLayoutId()
  {
    return 2131493298;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113423);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CardHomePageUI", "checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
    this.nBv = bool;
    if (this.nBv) {
      bJQ();
    }
    for (;;)
    {
      super.initView();
      AppMethodBeat.o(113423);
      return;
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.CardHomePageUI", "location permission is denied, doGetLayout");
      bJW();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113419);
    super.onCreate(paramBundle);
    this.fromScene = getIntent().getIntExtra("key_home_page_from_scene", 0);
    long l = System.currentTimeMillis();
    this.mStartTime = l;
    this.nxg = l;
    initView();
    paramBundle = this.nBr;
    am.bIZ().a(paramBundle);
    com.tencent.mm.kernel.g.afA().gcy.a(1164, this);
    com.tencent.mm.kernel.g.afA().gcy.a(1054, this);
    am.bJc().bJw();
    am.bIU();
    com.tencent.mm.plugin.card.b.b.yP(1);
    bJZ();
    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(113418);
        if (CardHomePageUI.g(CardHomePageUI.this) != null)
        {
          CardHomePageUI.g(CardHomePageUI.this);
          if (com.tencent.mm.plugin.card.sharecard.a.b.bJF())
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CardHomePageUI", "try2UpdateCardType");
            CardHomePageUI.h(CardHomePageUI.this);
          }
        }
        AppMethodBeat.o(113418);
        return false;
      }
    });
    am.bJc().a(this);
    am.bIV().add(this);
    ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.b.class)).gf(8, 2);
    AppMethodBeat.o(113419);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113420);
    if (this.nBv) {
      bHu();
    }
    i locali = this.nBr;
    am.bIZ().b(locali);
    this.nwI.nvb = null;
    com.tencent.mm.kernel.g.afA().gcy.b(1164, this);
    com.tencent.mm.kernel.g.afA().gcy.b(1054, this);
    am.bJc().b(this);
    am.bIV().remove(this);
    k.bIK();
    com.tencent.mm.plugin.card.sharecard.a.b.bJC();
    long l1 = System.currentTimeMillis();
    long l2 = this.nxg;
    h.vKh.f(13219, new Object[] { "CardHomePageUI", Integer.valueOf(this.fromScene), "", "", Long.valueOf(l1 - l2) });
    super.onDestroy();
    AppMethodBeat.o(113420);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113442);
    if (paramInt == 4)
    {
      if ((this.fromScene != 1) && (this.fromScene != 2)) {
        break label46;
      }
      bLd();
    }
    for (;;)
    {
      boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
      AppMethodBeat.o(113442);
      return bool;
      label46:
      finish();
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(113427);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    bJZ();
    this.nwV = true;
    this.nBu = true;
    AppMethodBeat.o(113427);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(113422);
    super.onPause();
    AppMethodBeat.o(113422);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(113421);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CardHomePageUI", "onResume locationPermissionGranted %s, hasInitLocation %s, shouldGetLayout %s", new Object[] { Boolean.valueOf(this.nBv), Boolean.valueOf(this.nxh), Boolean.valueOf(this.nwV) });
    if (this.nBv) {
      if ((this.nxh) && (this.nwV))
      {
        this.nxa = "";
        this.nxb = false;
        bHt();
      }
    }
    for (;;)
    {
      this.nwV = false;
      cE();
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
        h.vKh.b(localArrayList, true);
        this.mStartTime = 0L;
      }
      com.tencent.mm.kernel.g.afE().ax(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(113410);
          am.bJl().a(r.nJr);
          AppMethodBeat.o(113410);
        }
      });
      super.onResume();
      AppMethodBeat.o(113421);
      return;
      if (this.nwV)
      {
        this.nxa = "";
        bJW();
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(113438);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof com.tencent.mm.plugin.card.model.ad))
      {
        bLb();
        this.npR.onNotify();
        this.nBt.cE();
        a(((com.tencent.mm.plugin.card.model.ad)paramn).ntM);
        AppMethodBeat.o(113438);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.b))
      {
        paramString = (com.tencent.mm.plugin.card.sharecard.model.b)paramn;
        this.nwZ = false;
        this.nxa = paramString.nvj;
        this.nwI.aE(paramString.ntw, this.nwX);
        if ((!com.tencent.mm.plugin.card.sharecard.a.b.bJD()) || (!com.tencent.mm.plugin.card.sharecard.a.b.bJE())) {
          this.nwX = false;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CardHomePageUI", "NetSceneGetShareCardsLayout() >> updateView()");
        cE();
        AppMethodBeat.o(113438);
      }
    }
    else
    {
      if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.b)) {
        this.nwZ = false;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CardHomePageUI", "share card list ui, onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    AppMethodBeat.o(113438);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardHomePageUI
 * JD-Core Version:    0.7.0.1
 */