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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.d.r;
import com.tencent.mm.plugin.card.model.ad;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.sharecard.ui.ShareCardListUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.rm;
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.protocal.protobuf.sb;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
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
  private com.tencent.mm.plugin.card.sharecard.a.b nZI;
  private boolean nZV = false;
  private boolean nZX = true;
  private boolean nZZ = false;
  private String oaa = "";
  private boolean oab = false;
  private boolean oac = false;
  private long oag = 0L;
  boolean oah = false;
  private i oer;
  private f oes;
  private f oet;
  private boolean oeu = true;
  private boolean oev = false;
  private TextView oew;
  private LinearLayout oex;
  
  private void a(sb paramsb)
  {
    AppMethodBeat.i(113440);
    this.oex.removeAllViews();
    if ((paramsb != null) && (paramsb.Elg != null) && (!paramsb.Elg.isEmpty()))
    {
      paramsb = paramsb.Elg.iterator();
      while (paramsb.hasNext())
      {
        final ro localro = (ro)paramsb.next();
        View localView = LayoutInflater.from(getContext()).inflate(2131493285, this.oex, false);
        new f(this, localView, 4, this.nZI, localro).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(113417);
            if (localro.EjM == 1)
            {
              com.tencent.mm.plugin.card.d.b.a(CardHomePageUI.this, localro.EjN, 0);
              AppMethodBeat.o(113417);
              return;
            }
            if (localro.EjM == 2)
            {
              if (localro.EjO != null)
              {
                paramAnonymousView = new ut();
                paramAnonymousView.dxt.userName = localro.EjO.AZE;
                paramAnonymousView.dxt.dxv = bs.bG(localro.EjO.AZF, "");
                paramAnonymousView.dxt.scene = 1028;
                com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousView);
                AppMethodBeat.o(113417);
              }
            }
            else if (localro.EjM == 3)
            {
              if ("weixin://wccard/sharecarddetail".equals(localro.EjP))
              {
                ac.d("MicroMsg.CardHomePageUI", "go to share card ui");
                Object localObject = new Intent(CardHomePageUI.this, ShareCardListUI.class);
                ((Intent)localObject).putExtra("key_layout_buff", CardHomePageUI.e(CardHomePageUI.this));
                CardHomePageUI.f(CardHomePageUI.this);
                paramAnonymousView = CardHomePageUI.this;
                localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/card/ui/CardHomePageUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/card/ui/CardHomePageUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                h.wUl.f(11324, new Object[] { "ClickShareCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) });
                AppMethodBeat.o(113417);
              }
            }
            else {
              ac.w("MicroMsg.CardHomePageUI", "unknown op action: %s", new Object[] { Integer.valueOf(localro.EjM) });
            }
            AppMethodBeat.o(113417);
          }
        });
        this.oex.addView(localView);
      }
    }
    AppMethodBeat.o(113440);
  }
  
  private void bRd()
  {
    AppMethodBeat.i(113425);
    ac.d("MicroMsg.CardHomePageUI", "initLocation");
    com.tencent.mm.kernel.g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(113413);
        CardHomePageUI.c(CardHomePageUI.this);
        CardHomePageUI.d(CardHomePageUI.this);
        CardHomePageUI.this.oah = true;
        ac.d("MicroMsg.CardHomePageUI", "initLocation end");
        AppMethodBeat.o(113413);
      }
    });
    AppMethodBeat.o(113425);
  }
  
  private void bRj()
  {
    AppMethodBeat.i(113433);
    ac.d("MicroMsg.CardHomePageUI", "doGetLayout() >> doNetSceneGetCardsHomePageLayout()");
    bRk();
    if (com.tencent.mm.plugin.card.d.l.bTW()) {
      com.tencent.mm.plugin.card.b.b.bPw();
    }
    for (;;)
    {
      am.bQo().G("", "", 4);
      AppMethodBeat.o(113433);
      return;
      ac.i("MicroMsg.CardHomePageUI", "the card entrance is not open, don't do doNetSceneGetCardsLayout!");
    }
  }
  
  private void bRk()
  {
    AppMethodBeat.i(113434);
    if (!this.oeu)
    {
      ac.i("MicroMsg.CardHomePageUI", "doNetSceneGetCardsHomePageLayout, shouldGetHomePage is false");
      AppMethodBeat.o(113434);
      return;
    }
    if (this.nZZ)
    {
      ac.e("MicroMsg.CardHomePageUI", "doNetSceneGetCardsHomePageLayout, isDoingGetData is true");
      AppMethodBeat.o(113434);
      return;
    }
    if ((this.nZX) && (!bs.isNullOrNil(this.oaa))) {
      this.oaa = "";
    }
    this.nZZ = true;
    this.oeu = false;
    com.tencent.mm.plugin.card.sharecard.model.b localb = new com.tencent.mm.plugin.card.sharecard.model.b(am.bQo().fmX, am.bQo().fmY, this.oaa);
    com.tencent.mm.kernel.g.agQ().ghe.a(localb, 0);
    AppMethodBeat.o(113434);
  }
  
  private void bRm()
  {
    AppMethodBeat.i(113441);
    int i = getIntent().getIntExtra("key_from_scene", 22);
    boolean bool1 = com.tencent.mm.y.c.aeH().cG(262152, 266256);
    boolean bool2 = com.tencent.mm.y.c.aeH().cH(262152, 266256);
    boolean bool3 = com.tencent.mm.y.c.aeH().a(ah.a.GEX, ah.a.GEZ);
    boolean bool4 = com.tencent.mm.y.c.aeH().a(ah.a.GEY, ah.a.GFa);
    String str = bs.nullAsNil((String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GFd, null));
    if (bool1)
    {
      h.wUl.f(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(2), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113441);
      return;
    }
    if (bool2)
    {
      h.wUl.f(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113441);
      return;
    }
    if ((bool3) && (!bool4))
    {
      h.wUl.f(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(3), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113441);
      return;
    }
    if ((bool3) && (bool4))
    {
      h.wUl.f(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(4), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113441);
      return;
    }
    if (bool4)
    {
      h.wUl.f(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(5), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113441);
      return;
    }
    h.wUl.f(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(i), "", Integer.valueOf(0), str });
    AppMethodBeat.o(113441);
  }
  
  private void bSo()
  {
    AppMethodBeat.i(113429);
    ac.i("MicroMsg.CardHomePageUI", "updateMemberCardItem()");
    Object localObject = (c)this.nSL;
    if (this.oew == null)
    {
      this.oew = ((TextView)findViewById(2131302227));
      this.oew.setOnClickListener(new CardHomePageUI.5(this));
    }
    if (((c)localObject).getCount() > 0)
    {
      this.oew.setVisibility(0);
      this.oew.setText(getString(2131756998, new Object[] { Integer.valueOf(com.tencent.mm.plugin.card.sharecard.a.b.bQK()) }));
    }
    for (;;)
    {
      this.oes.bSn();
      AppMethodBeat.o(113429);
      return;
      this.oew.setVisibility(0);
      this.oew.setText(getString(2131756998, new Object[] { Integer.valueOf(com.tencent.mm.plugin.card.sharecard.a.b.bQK()) }));
      localObject = (LinearLayout)findViewById(2131297813);
      if (localObject != null)
      {
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
        localLayoutParams.topMargin = com.tencent.mm.cc.a.fromDPToPix(this, 29);
        localLayoutParams.bottomMargin = com.tencent.mm.cc.a.fromDPToPix(this, 29);
        ((LinearLayout)localObject).setLayoutParams(localLayoutParams);
      }
    }
  }
  
  private static sb bSp()
  {
    AppMethodBeat.i(113439);
    String str = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GFw, null);
    if (bs.isNullOrNil(str))
    {
      AppMethodBeat.o(113439);
      return null;
    }
    sb localsb = new sb();
    try
    {
      localsb.parseFrom(str.getBytes("ISO-8859-1"));
      AppMethodBeat.o(113439);
      return localsb;
    }
    catch (IOException localIOException)
    {
      ac.printErrStackTrace("MicroMsg.CardHomePageUI", localIOException, "", new Object[0]);
      AppMethodBeat.o(113439);
    }
    return null;
  }
  
  private void bSq()
  {
    AppMethodBeat.i(113443);
    Intent localIntent = new Intent();
    localIntent.addFlags(67108864);
    localIntent.putExtra("preferred_tab", 3);
    com.tencent.mm.br.d.e(this, "com.tencent.mm.ui.LauncherUI", localIntent);
    finish();
    AppMethodBeat.o(113443);
  }
  
  private void cL()
  {
    AppMethodBeat.i(113428);
    ac.i("MicroMsg.CardHomePageUI", "updateView()");
    this.oer.bSv();
    bSo();
    this.oet.cL();
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
    this.nZV = true;
  }
  
  public final void b(com.tencent.mm.plugin.card.base.b paramb, int paramInt)
  {
    AppMethodBeat.i(113436);
    super.b(paramb, paramInt);
    AppMethodBeat.o(113436);
  }
  
  public final void bOB()
  {
    AppMethodBeat.i(113424);
    setMMTitle(2131756891);
    addTextOptionMenu(0, getString(2131756941), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(113411);
        com.tencent.mm.plugin.card.d.b.a(CardHomePageUI.this, true);
        h.wUl.f(11582, new Object[] { "CardListMsgMenu", Integer.valueOf(2), Integer.valueOf(0), "", "" });
        AppMethodBeat.o(113411);
        return true;
      }
    });
    this.nZI = new com.tencent.mm.plugin.card.sharecard.a.b(this);
    this.nZI.init();
    if (this.oer == null)
    {
      this.oer = new i(this, getContentView());
      localObject = this.oer;
      ((i)localObject).ofu = View.inflate(((i)localObject).nTt, 2131493324, null);
      ((i)localObject).ofu.setVisibility(8);
      ((i)localObject).ofv = ((TextView)((i)localObject).ofu.findViewById(2131297832));
      ((i)localObject).ofw = ((ImageView)((i)localObject).ofu.findViewById(2131297830));
      ((i)localObject).ofu.setOnClickListener(new i.1((i)localObject));
      ((i)localObject).bSv();
      if (((i)localObject).ofx == null)
      {
        ((i)localObject).ofx = ((ViewStub)((i)localObject).ijA.findViewById(2131297861)).inflate();
        ((i)localObject).ofx.setVisibility(8);
        ((i)localObject).ofy = ((TextView)((i)localObject).ofx.findViewById(2131297832));
        ((i)localObject).ofz = ((ImageView)((i)localObject).ofx.findViewById(2131297830));
        ((i)localObject).ofx.setOnClickListener(new i.2((i)localObject));
      }
      this.oer.oan = true;
    }
    if (this.oes == null) {
      this.oes = new f(this, findViewById(2131297858), 1, this.nZI);
    }
    if (this.oet == null) {
      this.oet = new f(this, findViewById(2131297906), 3, this.nZI);
    }
    if (this.oes != null) {
      this.oes.setOnClickListener(new CardHomePageUI.6(this));
    }
    if (this.oet != null) {
      this.oet.setOnClickListener(new CardHomePageUI.7(this));
    }
    this.oex = ((LinearLayout)findViewById(2131297768));
    Object localObject = bSp();
    if (localObject != null) {
      a((sb)localObject);
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
  
  public final n.a bOC()
  {
    return n.a.nWt;
  }
  
  public final boolean bOD()
  {
    AppMethodBeat.i(113435);
    boolean bool = super.bOD();
    AppMethodBeat.o(113435);
    return bool;
  }
  
  public final boolean bOE()
  {
    return true;
  }
  
  public final void bOI()
  {
    AppMethodBeat.i(113431);
    if (this.oab)
    {
      ac.e("MicroMsg.CardHomePageUI", "onLocationFinish, has do GetShareCardLayout,don't get again");
      if (this.oev) {
        bOH();
      }
      AppMethodBeat.o(113431);
      return;
    }
    ac.d("MicroMsg.CardHomePageUI", "onLocationFinish()");
    this.oab = true;
    bRj();
    bOH();
    AppMethodBeat.o(113431);
  }
  
  public final void bOJ()
  {
    AppMethodBeat.i(113432);
    if ((this.oac) || (this.oab))
    {
      bOH();
      AppMethodBeat.o(113432);
      return;
    }
    this.oac = true;
    ac.i("MicroMsg.CardHomePageUI", "onLocationFail()");
    bRj();
    AppMethodBeat.o(113432);
  }
  
  public final void bOK()
  {
    AppMethodBeat.i(113426);
    ac.i("MicroMsg.CardHomePageUI", "onMPermissionGranted locationPermissionGranted " + this.oev);
    if (!this.oev)
    {
      this.oev = true;
      bRd();
    }
    AppMethodBeat.o(113426);
  }
  
  public final void bOL()
  {
    AppMethodBeat.i(113430);
    bSo();
    AppMethodBeat.o(113430);
  }
  
  public final void bPt()
  {
    this.nZV = true;
  }
  
  public int getLayoutId()
  {
    return 2131493298;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113423);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null);
    ac.i("MicroMsg.CardHomePageUI", "checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
    this.oev = bool;
    if (this.oev) {
      bRd();
    }
    for (;;)
    {
      super.initView();
      AppMethodBeat.o(113423);
      return;
      ac.e("MicroMsg.CardHomePageUI", "location permission is denied, doGetLayout");
      bRj();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113419);
    super.onCreate(paramBundle);
    this.fromScene = getIntent().getIntExtra("key_home_page_from_scene", 0);
    long l = System.currentTimeMillis();
    this.mStartTime = l;
    this.oag = l;
    initView();
    paramBundle = this.oer;
    am.bQm().a(paramBundle);
    com.tencent.mm.kernel.g.agQ().ghe.a(1164, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(1054, this);
    am.bQp().bQJ();
    am.bQh();
    com.tencent.mm.plugin.card.b.b.zF(1);
    bRm();
    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(113418);
        if (CardHomePageUI.g(CardHomePageUI.this) != null)
        {
          CardHomePageUI.g(CardHomePageUI.this);
          if (com.tencent.mm.plugin.card.sharecard.a.b.bQS())
          {
            ac.i("MicroMsg.CardHomePageUI", "try2UpdateCardType");
            CardHomePageUI.h(CardHomePageUI.this);
          }
        }
        AppMethodBeat.o(113418);
        return false;
      }
    });
    am.bQp().a(this);
    am.bQi().add(this);
    ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.b.class)).gm(8, 2);
    AppMethodBeat.o(113419);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113420);
    if (this.oev) {
      bOH();
    }
    i locali = this.oer;
    am.bQm().b(locali);
    this.nZI.nYb = null;
    com.tencent.mm.kernel.g.agQ().ghe.b(1164, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(1054, this);
    am.bQp().b(this);
    am.bQi().remove(this);
    k.bPX();
    com.tencent.mm.plugin.card.sharecard.a.b.bQP();
    long l1 = System.currentTimeMillis();
    long l2 = this.oag;
    h.wUl.f(13219, new Object[] { "CardHomePageUI", Integer.valueOf(this.fromScene), "", "", Long.valueOf(l1 - l2) });
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
      bSq();
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
    bRm();
    this.nZV = true;
    this.oeu = true;
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
    ac.i("MicroMsg.CardHomePageUI", "onResume locationPermissionGranted %s, hasInitLocation %s, shouldGetLayout %s", new Object[] { Boolean.valueOf(this.oev), Boolean.valueOf(this.oah), Boolean.valueOf(this.nZV) });
    if (this.oev) {
      if ((this.oah) && (this.nZV))
      {
        this.oaa = "";
        this.oab = false;
        bOG();
      }
    }
    for (;;)
    {
      this.nZV = false;
      cL();
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
        h.wUl.b(localArrayList, true);
        this.mStartTime = 0L;
      }
      com.tencent.mm.kernel.g.agU().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(113410);
          am.bQy().a(r.omr);
          AppMethodBeat.o(113410);
        }
      });
      super.onResume();
      AppMethodBeat.o(113421);
      return;
      if (this.nZV)
      {
        this.oaa = "";
        bRj();
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(113438);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof ad))
      {
        bSo();
        this.nSR.onNotify();
        this.oet.cL();
        a(((ad)paramn).nWM);
        AppMethodBeat.o(113438);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.b))
      {
        paramString = (com.tencent.mm.plugin.card.sharecard.model.b)paramn;
        this.nZZ = false;
        this.oaa = paramString.nYj;
        this.nZI.aF(paramString.nWw, this.nZX);
        if ((!com.tencent.mm.plugin.card.sharecard.a.b.bQQ()) || (!com.tencent.mm.plugin.card.sharecard.a.b.bQR())) {
          this.nZX = false;
        }
        ac.i("MicroMsg.CardHomePageUI", "NetSceneGetShareCardsLayout() >> updateView()");
        cL();
        AppMethodBeat.o(113438);
      }
    }
    else
    {
      if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.b)) {
        this.nZZ = false;
      }
      ac.i("MicroMsg.CardHomePageUI", "share card list ui, onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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