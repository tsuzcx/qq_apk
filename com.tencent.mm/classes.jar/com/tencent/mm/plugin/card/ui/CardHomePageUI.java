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
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.d.r;
import com.tencent.mm.plugin.card.model.ad;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.protocal.protobuf.tk;
import com.tencent.mm.protocal.protobuf.tx;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
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
  private com.tencent.mm.plugin.card.sharecard.a.b oJE;
  private boolean oJR = false;
  private boolean oJT = true;
  private boolean oJV = false;
  private String oJW = "";
  private boolean oJX = false;
  private boolean oJY = false;
  private long oKc = 0L;
  boolean oKd = false;
  private i oOn;
  private f oOo;
  private f oOp;
  private boolean oOq = true;
  private boolean oOr = false;
  private TextView oOs;
  private LinearLayout oOt;
  
  private void a(tx paramtx)
  {
    AppMethodBeat.i(113440);
    this.oOt.removeAllViews();
    if ((paramtx != null) && (paramtx.GkN != null) && (!paramtx.GkN.isEmpty()))
    {
      paramtx = paramtx.GkN.iterator();
      while (paramtx.hasNext())
      {
        tk localtk = (tk)paramtx.next();
        View localView = LayoutInflater.from(getContext()).inflate(2131493285, this.oOt, false);
        new f(this, localView, 4, this.oJE, localtk).setOnClickListener(new CardHomePageUI.8(this, localtk));
        this.oOt.addView(localView);
      }
    }
    AppMethodBeat.o(113440);
  }
  
  private void bWX()
  {
    AppMethodBeat.i(113425);
    ae.d("MicroMsg.CardHomePageUI", "initLocation");
    com.tencent.mm.kernel.g.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(113413);
        CardHomePageUI.c(CardHomePageUI.this);
        CardHomePageUI.d(CardHomePageUI.this);
        CardHomePageUI.this.oKd = true;
        ae.d("MicroMsg.CardHomePageUI", "initLocation end");
        AppMethodBeat.o(113413);
      }
    });
    AppMethodBeat.o(113425);
  }
  
  private void bXd()
  {
    AppMethodBeat.i(113433);
    ae.d("MicroMsg.CardHomePageUI", "doGetLayout() >> doNetSceneGetCardsHomePageLayout()");
    bXe();
    if (com.tencent.mm.plugin.card.d.l.bZQ()) {
      com.tencent.mm.plugin.card.b.b.bVq();
    }
    for (;;)
    {
      am.bWi().H("", "", 4);
      AppMethodBeat.o(113433);
      return;
      ae.i("MicroMsg.CardHomePageUI", "the card entrance is not open, don't do doNetSceneGetCardsLayout!");
    }
  }
  
  private void bXe()
  {
    AppMethodBeat.i(113434);
    if (!this.oOq)
    {
      ae.i("MicroMsg.CardHomePageUI", "doNetSceneGetCardsHomePageLayout, shouldGetHomePage is false");
      AppMethodBeat.o(113434);
      return;
    }
    if (this.oJV)
    {
      ae.e("MicroMsg.CardHomePageUI", "doNetSceneGetCardsHomePageLayout, isDoingGetData is true");
      AppMethodBeat.o(113434);
      return;
    }
    if ((this.oJT) && (!bu.isNullOrNil(this.oJW))) {
      this.oJW = "";
    }
    this.oJV = true;
    this.oOq = false;
    com.tencent.mm.plugin.card.sharecard.model.b localb = new com.tencent.mm.plugin.card.sharecard.model.b(am.bWi().fHj, am.bWi().fHk, this.oJW);
    com.tencent.mm.kernel.g.ajQ().gDv.a(localb, 0);
    AppMethodBeat.o(113434);
  }
  
  private void bXg()
  {
    AppMethodBeat.i(113441);
    int i = getIntent().getIntExtra("key_from_scene", 22);
    boolean bool1 = com.tencent.mm.y.c.ahI().cI(262152, 266256);
    boolean bool2 = com.tencent.mm.y.c.ahI().cJ(262152, 266256);
    boolean bool3 = com.tencent.mm.y.c.ahI().a(am.a.ILL, am.a.ILN);
    boolean bool4 = com.tencent.mm.y.c.ahI().a(am.a.ILM, am.a.ILO);
    String str = bu.nullAsNil((String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ILR, null));
    if (bool1)
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(2), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113441);
      return;
    }
    if (bool2)
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113441);
      return;
    }
    if ((bool3) && (!bool4))
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(3), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113441);
      return;
    }
    if ((bool3) && (bool4))
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(4), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113441);
      return;
    }
    if (bool4)
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(5), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113441);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yxI.f(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(i), "", Integer.valueOf(0), str });
    AppMethodBeat.o(113441);
  }
  
  private void bYi()
  {
    AppMethodBeat.i(113429);
    ae.i("MicroMsg.CardHomePageUI", "updateMemberCardItem()");
    Object localObject = (c)this.oCI;
    if (this.oOs == null)
    {
      this.oOs = ((TextView)findViewById(2131302227));
      this.oOs.setOnClickListener(new CardHomePageUI.5(this));
    }
    if (((c)localObject).getCount() > 0)
    {
      this.oOs.setVisibility(0);
      this.oOs.setText(getString(2131756998, new Object[] { Integer.valueOf(com.tencent.mm.plugin.card.sharecard.a.b.bWE()) }));
    }
    for (;;)
    {
      this.oOo.bYh();
      AppMethodBeat.o(113429);
      return;
      this.oOs.setVisibility(0);
      this.oOs.setText(getString(2131756998, new Object[] { Integer.valueOf(com.tencent.mm.plugin.card.sharecard.a.b.bWE()) }));
      localObject = (LinearLayout)findViewById(2131297813);
      if (localObject != null)
      {
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
        localLayoutParams.topMargin = com.tencent.mm.cb.a.fromDPToPix(this, 29);
        localLayoutParams.bottomMargin = com.tencent.mm.cb.a.fromDPToPix(this, 29);
        ((LinearLayout)localObject).setLayoutParams(localLayoutParams);
      }
    }
  }
  
  private static tx bYj()
  {
    AppMethodBeat.i(113439);
    String str = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IMk, null);
    if (bu.isNullOrNil(str))
    {
      AppMethodBeat.o(113439);
      return null;
    }
    tx localtx = new tx();
    try
    {
      localtx.parseFrom(str.getBytes("ISO-8859-1"));
      AppMethodBeat.o(113439);
      return localtx;
    }
    catch (IOException localIOException)
    {
      ae.printErrStackTrace("MicroMsg.CardHomePageUI", localIOException, "", new Object[0]);
      AppMethodBeat.o(113439);
    }
    return null;
  }
  
  private void bYk()
  {
    AppMethodBeat.i(113443);
    Intent localIntent = new Intent();
    localIntent.addFlags(67108864);
    localIntent.putExtra("preferred_tab", 3);
    com.tencent.mm.br.d.f(this, "com.tencent.mm.ui.LauncherUI", localIntent);
    finish();
    AppMethodBeat.o(113443);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(113428);
    ae.i("MicroMsg.CardHomePageUI", "updateView()");
    this.oOn.bYp();
    bYi();
    this.oOp.updateView();
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
    this.oJR = true;
  }
  
  public final void b(com.tencent.mm.plugin.card.base.b paramb, int paramInt)
  {
    AppMethodBeat.i(113436);
    super.b(paramb, paramInt);
    AppMethodBeat.o(113436);
  }
  
  public final void bUC()
  {
    AppMethodBeat.i(113431);
    if (this.oJX)
    {
      ae.e("MicroMsg.CardHomePageUI", "onLocationFinish, has do GetShareCardLayout,don't get again");
      if (this.oOr) {
        bUB();
      }
      AppMethodBeat.o(113431);
      return;
    }
    ae.d("MicroMsg.CardHomePageUI", "onLocationFinish()");
    this.oJX = true;
    bXd();
    bUB();
    AppMethodBeat.o(113431);
  }
  
  public final void bUD()
  {
    AppMethodBeat.i(113432);
    if ((this.oJY) || (this.oJX))
    {
      bUB();
      AppMethodBeat.o(113432);
      return;
    }
    this.oJY = true;
    ae.i("MicroMsg.CardHomePageUI", "onLocationFail()");
    bXd();
    AppMethodBeat.o(113432);
  }
  
  public final void bUE()
  {
    AppMethodBeat.i(113426);
    ae.i("MicroMsg.CardHomePageUI", "onMPermissionGranted locationPermissionGranted " + this.oOr);
    if (!this.oOr)
    {
      this.oOr = true;
      bWX();
    }
    AppMethodBeat.o(113426);
  }
  
  public final void bUF()
  {
    AppMethodBeat.i(113430);
    bYi();
    AppMethodBeat.o(113430);
  }
  
  public final void bUv()
  {
    AppMethodBeat.i(113424);
    setMMTitle(2131756891);
    addTextOptionMenu(0, getString(2131756941), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(113411);
        com.tencent.mm.plugin.card.d.b.a(CardHomePageUI.this, true);
        com.tencent.mm.plugin.report.service.g.yxI.f(11582, new Object[] { "CardListMsgMenu", Integer.valueOf(2), Integer.valueOf(0), "", "" });
        AppMethodBeat.o(113411);
        return true;
      }
    });
    this.oJE = new com.tencent.mm.plugin.card.sharecard.a.b(this);
    this.oJE.init();
    if (this.oOn == null)
    {
      this.oOn = new i(this, getContentView());
      localObject = this.oOn;
      ((i)localObject).oPp = View.inflate(((i)localObject).oDq, 2131493324, null);
      ((i)localObject).oPp.setVisibility(8);
      ((i)localObject).oPq = ((TextView)((i)localObject).oPp.findViewById(2131297832));
      ((i)localObject).oPr = ((ImageView)((i)localObject).oPp.findViewById(2131297830));
      ((i)localObject).oPp.setOnClickListener(new i.1((i)localObject));
      ((i)localObject).bYp();
      if (((i)localObject).oPs == null)
      {
        ((i)localObject).oPs = ((ViewStub)((i)localObject).iFK.findViewById(2131297861)).inflate();
        ((i)localObject).oPs.setVisibility(8);
        ((i)localObject).oPt = ((TextView)((i)localObject).oPs.findViewById(2131297832));
        ((i)localObject).oPu = ((ImageView)((i)localObject).oPs.findViewById(2131297830));
        ((i)localObject).oPs.setOnClickListener(new i.2((i)localObject));
      }
      this.oOn.oKj = true;
    }
    if (this.oOo == null) {
      this.oOo = new f(this, findViewById(2131297858), 1, this.oJE);
    }
    if (this.oOp == null) {
      this.oOp = new f(this, findViewById(2131297906), 3, this.oJE);
    }
    if (this.oOo != null) {
      this.oOo.setOnClickListener(new CardHomePageUI.6(this));
    }
    if (this.oOp != null) {
      this.oOp.setOnClickListener(new CardHomePageUI.7(this));
    }
    this.oOt = ((LinearLayout)findViewById(2131297768));
    Object localObject = bYj();
    if (localObject != null) {
      a((tx)localObject);
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
  
  public final n.a bUw()
  {
    return n.a.oGp;
  }
  
  public final boolean bUx()
  {
    AppMethodBeat.i(113435);
    boolean bool = super.bUx();
    AppMethodBeat.o(113435);
    return bool;
  }
  
  public final boolean bUy()
  {
    return true;
  }
  
  public final void bVn()
  {
    this.oJR = true;
  }
  
  public int getLayoutId()
  {
    return 2131493298;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113423);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null);
    ae.i("MicroMsg.CardHomePageUI", "checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
    this.oOr = bool;
    if (this.oOr) {
      bWX();
    }
    for (;;)
    {
      super.initView();
      AppMethodBeat.o(113423);
      return;
      ae.e("MicroMsg.CardHomePageUI", "location permission is denied, doGetLayout");
      bXd();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113419);
    super.onCreate(paramBundle);
    this.fromScene = getIntent().getIntExtra("key_home_page_from_scene", 0);
    long l = System.currentTimeMillis();
    this.mStartTime = l;
    this.oKc = l;
    initView();
    paramBundle = this.oOn;
    am.bWg().a(paramBundle);
    com.tencent.mm.kernel.g.ajQ().gDv.a(1164, this);
    com.tencent.mm.kernel.g.ajQ().gDv.a(1054, this);
    am.bWj().bWD();
    am.bWb();
    com.tencent.mm.plugin.card.b.b.AA(1);
    bXg();
    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(113418);
        if (CardHomePageUI.g(CardHomePageUI.this) != null)
        {
          CardHomePageUI.g(CardHomePageUI.this);
          if (com.tencent.mm.plugin.card.sharecard.a.b.bWM())
          {
            ae.i("MicroMsg.CardHomePageUI", "try2UpdateCardType");
            CardHomePageUI.h(CardHomePageUI.this);
          }
        }
        AppMethodBeat.o(113418);
        return false;
      }
    });
    am.bWj().a(this);
    am.bWc().add(this);
    ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.b.class)).gD(8, 2);
    AppMethodBeat.o(113419);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113420);
    if (this.oOr) {
      bUB();
    }
    i locali = this.oOn;
    am.bWg().b(locali);
    this.oJE.oHX = null;
    com.tencent.mm.kernel.g.ajQ().gDv.b(1164, this);
    com.tencent.mm.kernel.g.ajQ().gDv.b(1054, this);
    am.bWj().b(this);
    am.bWc().remove(this);
    k.bVR();
    com.tencent.mm.plugin.card.sharecard.a.b.bWJ();
    long l1 = System.currentTimeMillis();
    long l2 = this.oKc;
    com.tencent.mm.plugin.report.service.g.yxI.f(13219, new Object[] { "CardHomePageUI", Integer.valueOf(this.fromScene), "", "", Long.valueOf(l1 - l2) });
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
      bYk();
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
    bXg();
    this.oJR = true;
    this.oOq = true;
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
    ae.i("MicroMsg.CardHomePageUI", "onResume locationPermissionGranted %s, hasInitLocation %s, shouldGetLayout %s", new Object[] { Boolean.valueOf(this.oOr), Boolean.valueOf(this.oKd), Boolean.valueOf(this.oJR) });
    if (this.oOr) {
      if ((this.oKd) && (this.oJR))
      {
        this.oJW = "";
        this.oJX = false;
        bUA();
      }
    }
    for (;;)
    {
      this.oJR = false;
      updateView();
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
        com.tencent.mm.plugin.report.service.g.yxI.b(localArrayList, true);
        this.mStartTime = 0L;
      }
      com.tencent.mm.kernel.g.ajU().aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(113410);
          am.bWs().a(r.oWo);
          AppMethodBeat.o(113410);
        }
      });
      super.onResume();
      AppMethodBeat.o(113421);
      return;
      if (this.oJR)
      {
        this.oJW = "";
        bXd();
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
        bYi();
        this.oCO.onNotify();
        this.oOp.updateView();
        a(((ad)paramn).oGI);
        AppMethodBeat.o(113438);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.b))
      {
        paramString = (com.tencent.mm.plugin.card.sharecard.model.b)paramn;
        this.oJV = false;
        this.oJW = paramString.oIf;
        this.oJE.aJ(paramString.oGs, this.oJT);
        if ((!com.tencent.mm.plugin.card.sharecard.a.b.bWK()) || (!com.tencent.mm.plugin.card.sharecard.a.b.bWL())) {
          this.oJT = false;
        }
        ae.i("MicroMsg.CardHomePageUI", "NetSceneGetShareCardsLayout() >> updateView()");
        updateView();
        AppMethodBeat.o(113438);
      }
    }
    else
    {
      if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.b)) {
        this.oJV = false;
      }
      ae.i("MicroMsg.CardHomePageUI", "share card list ui, onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    AppMethodBeat.o(113438);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardHomePageUI
 * JD-Core Version:    0.7.0.1
 */