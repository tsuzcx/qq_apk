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
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.b.g;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.base.d;
import com.tencent.mm.plugin.card.d.r;
import com.tencent.mm.plugin.card.model.ad;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.protocal.protobuf.ur;
import com.tencent.mm.protocal.protobuf.ve;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

@com.tencent.mm.kernel.k
public class CardHomePageUI
  extends CardBaseUI
  implements d, MStorage.IOnStorageChange
{
  private int fromScene = 0;
  private long mStartTime = 0L;
  private boolean ttB = false;
  private boolean ttD = true;
  private boolean ttF = false;
  private String ttG = "";
  private boolean ttH = false;
  private boolean ttI = false;
  private long ttM = 0L;
  boolean ttN = false;
  private com.tencent.mm.plugin.card.sharecard.a.b ttp;
  private i txZ;
  private f tya;
  private f tyb;
  private boolean tyc = true;
  private boolean tyd = false;
  private TextView tye;
  private LinearLayout tyf;
  
  private void a(ve paramve)
  {
    AppMethodBeat.i(113440);
    this.tyf.removeAllViews();
    if ((paramve != null) && (paramve.SgD != null) && (!paramve.SgD.isEmpty()))
    {
      paramve = paramve.SgD.iterator();
      while (paramve.hasNext())
      {
        ur localur = (ur)paramve.next();
        View localView = LayoutInflater.from(getContext()).inflate(a.e.tik, this.tyf, false);
        new f(this, localView, 4, this.ttp, localur).setOnClickListener(new CardHomePageUI.8(this, localur));
        this.tyf.addView(localView);
      }
    }
    AppMethodBeat.o(113440);
  }
  
  private void cIp()
  {
    AppMethodBeat.i(113425);
    Log.d("MicroMsg.CardHomePageUI", "initLocation");
    com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(113413);
        CardHomePageUI.c(CardHomePageUI.this);
        CardHomePageUI.d(CardHomePageUI.this);
        CardHomePageUI.this.ttN = true;
        Log.d("MicroMsg.CardHomePageUI", "initLocation end");
        AppMethodBeat.o(113413);
      }
    });
    AppMethodBeat.o(113425);
  }
  
  private void cIv()
  {
    AppMethodBeat.i(113433);
    Log.d("MicroMsg.CardHomePageUI", "doGetLayout() >> doNetSceneGetCardsHomePageLayout()");
    cIw();
    if (com.tencent.mm.plugin.card.d.l.cLh()) {
      com.tencent.mm.plugin.card.b.b.cGG();
    }
    for (;;)
    {
      am.cHy().K("", "", 4);
      AppMethodBeat.o(113433);
      return;
      Log.i("MicroMsg.CardHomePageUI", "the card entrance is not open, don't do doNetSceneGetCardsLayout!");
    }
  }
  
  private void cIw()
  {
    AppMethodBeat.i(113434);
    if (!this.tyc)
    {
      Log.i("MicroMsg.CardHomePageUI", "doNetSceneGetCardsHomePageLayout, shouldGetHomePage is false");
      AppMethodBeat.o(113434);
      return;
    }
    if (this.ttF)
    {
      Log.e("MicroMsg.CardHomePageUI", "doNetSceneGetCardsHomePageLayout, isDoingGetData is true");
      AppMethodBeat.o(113434);
      return;
    }
    if ((this.ttD) && (!Util.isNullOrNil(this.ttG))) {
      this.ttG = "";
    }
    this.ttF = true;
    this.tyc = false;
    com.tencent.mm.plugin.card.sharecard.model.b localb = new com.tencent.mm.plugin.card.sharecard.model.b(am.cHy().iQD, am.cHy().iQE, this.ttG);
    com.tencent.mm.kernel.h.aHF().kcd.a(localb, 0);
    AppMethodBeat.o(113434);
  }
  
  private void cIy()
  {
    AppMethodBeat.i(113441);
    int i = getIntent().getIntExtra("key_from_scene", 22);
    boolean bool1 = com.tencent.mm.aa.c.aFn().dj(262152, 266256);
    boolean bool2 = com.tencent.mm.aa.c.aFn().dk(262152, 266256);
    boolean bool3 = com.tencent.mm.aa.c.aFn().a(ar.a.VhN, ar.a.VhP);
    boolean bool4 = com.tencent.mm.aa.c.aFn().a(ar.a.VhO, ar.a.VhQ);
    String str = Util.nullAsNil((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VhT, null));
    if (bool1)
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(2), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113441);
      return;
    }
    if (bool2)
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113441);
      return;
    }
    if ((bool3) && (!bool4))
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(3), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113441);
      return;
    }
    if ((bool3) && (bool4))
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(4), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113441);
      return;
    }
    if (bool4)
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(5), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113441);
      return;
    }
    com.tencent.mm.plugin.report.service.h.IzE.a(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(i), "", Integer.valueOf(0), str });
    AppMethodBeat.o(113441);
  }
  
  private void cJA()
  {
    AppMethodBeat.i(113429);
    Log.i("MicroMsg.CardHomePageUI", "updateMemberCardItem()");
    Object localObject = (c)this.tmr;
    if (this.tye == null)
    {
      this.tye = ((TextView)findViewById(a.d.tge));
      this.tye.setOnClickListener(new CardHomePageUI.5(this));
    }
    if (((c)localObject).getCount() > 0)
    {
      this.tye.setVisibility(0);
      this.tye.setText(getString(a.g.tlN, new Object[] { Integer.valueOf(com.tencent.mm.plugin.card.sharecard.a.b.cHX()) }));
    }
    for (;;)
    {
      this.tya.cJz();
      AppMethodBeat.o(113429);
      return;
      this.tye.setVisibility(0);
      this.tye.setText(getString(a.g.tlN, new Object[] { Integer.valueOf(com.tencent.mm.plugin.card.sharecard.a.b.cHX()) }));
      localObject = (LinearLayout)findViewById(a.d.tcm);
      if (localObject != null)
      {
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
        localLayoutParams.topMargin = com.tencent.mm.ci.a.fromDPToPix(this, 29);
        localLayoutParams.bottomMargin = com.tencent.mm.ci.a.fromDPToPix(this, 29);
        ((LinearLayout)localObject).setLayoutParams(localLayoutParams);
      }
    }
  }
  
  private static ve cJB()
  {
    AppMethodBeat.i(113439);
    String str = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vim, null);
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(113439);
      return null;
    }
    ve localve = new ve();
    try
    {
      localve.parseFrom(str.getBytes("ISO-8859-1"));
      AppMethodBeat.o(113439);
      return localve;
    }
    catch (IOException localIOException)
    {
      Log.printErrStackTrace("MicroMsg.CardHomePageUI", localIOException, "", new Object[0]);
      AppMethodBeat.o(113439);
    }
    return null;
  }
  
  private void cJC()
  {
    AppMethodBeat.i(113443);
    Intent localIntent = new Intent();
    localIntent.addFlags(67108864);
    localIntent.putExtra("preferred_tab", 3);
    com.tencent.mm.by.c.f(this, "com.tencent.mm.ui.LauncherUI", localIntent);
    finish();
    AppMethodBeat.o(113443);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(113428);
    Log.i("MicroMsg.CardHomePageUI", "updateView()");
    this.txZ.cJH();
    cJA();
    this.tyb.updateView();
    AppMethodBeat.o(113428);
  }
  
  public final void a(com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113437);
    super.a(paramb);
    AppMethodBeat.o(113437);
  }
  
  public final void b(com.tencent.mm.plugin.card.base.b paramb, int paramInt)
  {
    AppMethodBeat.i(113436);
    super.b(paramb, paramInt);
    AppMethodBeat.o(113436);
  }
  
  public final void cFJ()
  {
    AppMethodBeat.i(113424);
    setMMTitle(a.g.tkz);
    addTextOptionMenu(0, getString(a.g.tlg), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(113411);
        com.tencent.mm.plugin.card.d.b.a(CardHomePageUI.this, true);
        com.tencent.mm.plugin.report.service.h.IzE.a(11582, new Object[] { "CardListMsgMenu", Integer.valueOf(2), Integer.valueOf(0), "", "" });
        AppMethodBeat.o(113411);
        return true;
      }
    });
    this.ttp = new com.tencent.mm.plugin.card.sharecard.a.b(this);
    this.ttp.init();
    if (this.txZ == null)
    {
      this.txZ = new i(this, getContentView());
      localObject = this.txZ;
      ((i)localObject).tza = View.inflate(((i)localObject).tmY, a.e.tiW, null);
      ((i)localObject).tza.setVisibility(8);
      ((i)localObject).tzb = ((TextView)((i)localObject).tza.findViewById(a.d.tcz));
      ((i)localObject).tzc = ((ImageView)((i)localObject).tza.findViewById(a.d.tcy));
      ((i)localObject).tza.setOnClickListener(new i.1((i)localObject));
      ((i)localObject).cJH();
      if (((i)localObject).tzd == null)
      {
        ((i)localObject).tzd = ((ViewStub)((i)localObject).mrI.findViewById(a.d.tcT)).inflate();
        ((i)localObject).tzd.setVisibility(8);
        ((i)localObject).tze = ((TextView)((i)localObject).tzd.findViewById(a.d.tcz));
        ((i)localObject).tzf = ((ImageView)((i)localObject).tzd.findViewById(a.d.tcy));
        ((i)localObject).tzd.setOnClickListener(new i.2((i)localObject));
      }
      this.txZ.ttT = true;
    }
    if (this.tya == null) {
      this.tya = new f(this, findViewById(a.d.tcQ), 1, this.ttp);
    }
    if (this.tyb == null) {
      this.tyb = new f(this, findViewById(a.d.tdD), 3, this.ttp);
    }
    if (this.tya != null) {
      this.tya.setOnClickListener(new CardHomePageUI.6(this));
    }
    if (this.tyb != null) {
      this.tyb.setOnClickListener(new CardHomePageUI.7(this));
    }
    this.tyf = ((LinearLayout)findViewById(a.d.tbF));
    Object localObject = cJB();
    if (localObject != null) {
      a((ve)localObject);
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
  
  public final n.a cFK()
  {
    return n.a.tpW;
  }
  
  public final boolean cFL()
  {
    AppMethodBeat.i(113435);
    boolean bool = super.cFL();
    AppMethodBeat.o(113435);
    return bool;
  }
  
  public final boolean cFM()
  {
    return true;
  }
  
  public final void cFR()
  {
    AppMethodBeat.i(113431);
    if (this.ttH)
    {
      Log.e("MicroMsg.CardHomePageUI", "onLocationFinish, has do GetShareCardLayout,don't get again");
      if (this.tyd) {
        cFQ();
      }
      AppMethodBeat.o(113431);
      return;
    }
    Log.d("MicroMsg.CardHomePageUI", "onLocationFinish()");
    this.ttH = true;
    cIv();
    cFQ();
    AppMethodBeat.o(113431);
  }
  
  public final void cFS()
  {
    AppMethodBeat.i(113432);
    if ((this.ttI) || (this.ttH))
    {
      cFQ();
      AppMethodBeat.o(113432);
      return;
    }
    this.ttI = true;
    Log.i("MicroMsg.CardHomePageUI", "onLocationFail()");
    cIv();
    AppMethodBeat.o(113432);
  }
  
  public final void cFT()
  {
    AppMethodBeat.i(113426);
    Log.i("MicroMsg.CardHomePageUI", "onMPermissionGranted locationPermissionGranted " + this.tyd);
    if (!this.tyd)
    {
      this.tyd = true;
      cIp();
    }
    AppMethodBeat.o(113426);
  }
  
  public final void cFU()
  {
    AppMethodBeat.i(113430);
    cJA();
    AppMethodBeat.o(113430);
  }
  
  public final void cGD()
  {
    this.ttB = true;
  }
  
  public int getLayoutId()
  {
    return a.e.tiw;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113423);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 69, null, null);
    Log.i("MicroMsg.CardHomePageUI", "checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
    this.tyd = bool;
    if (this.tyd) {
      cIp();
    }
    for (;;)
    {
      super.initView();
      AppMethodBeat.o(113423);
      return;
      Log.e("MicroMsg.CardHomePageUI", "location permission is denied, doGetLayout");
      cIv();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113419);
    super.onCreate(paramBundle);
    this.fromScene = getIntent().getIntExtra("key_home_page_from_scene", 0);
    long l = System.currentTimeMillis();
    this.mStartTime = l;
    this.ttM = l;
    initView();
    paramBundle = this.txZ;
    am.cHw().a(paramBundle);
    com.tencent.mm.kernel.h.aHF().kcd.a(1164, this);
    com.tencent.mm.kernel.h.aHF().kcd.a(1054, this);
    am.cHz().cHW();
    am.cHr();
    com.tencent.mm.plugin.card.b.b.HG(1);
    cIy();
    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(113418);
        if (CardHomePageUI.g(CardHomePageUI.this) != null)
        {
          CardHomePageUI.g(CardHomePageUI.this);
          if (com.tencent.mm.plugin.card.sharecard.a.b.cIf())
          {
            Log.i("MicroMsg.CardHomePageUI", "try2UpdateCardType");
            CardHomePageUI.h(CardHomePageUI.this);
          }
        }
        AppMethodBeat.o(113418);
        return false;
      }
    });
    am.cHz().a(this);
    am.cHs().add(this);
    ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.wallet.b.class)).ij(8, 2);
    AppMethodBeat.o(113419);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113420);
    if (this.tyd) {
      cFQ();
    }
    i locali = this.txZ;
    am.cHw().b(locali);
    this.ttp.trM = null;
    com.tencent.mm.kernel.h.aHF().kcd.b(1164, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(1054, this);
    am.cHz().b(this);
    am.cHs().remove(this);
    com.tencent.mm.plugin.card.b.k.cHh();
    com.tencent.mm.plugin.card.sharecard.a.b.cIc();
    long l1 = System.currentTimeMillis();
    long l2 = this.ttM;
    com.tencent.mm.plugin.report.service.h.IzE.a(13219, new Object[] { "CardHomePageUI", Integer.valueOf(this.fromScene), "", "", Long.valueOf(l1 - l2) });
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
      cJC();
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
    cIy();
    this.ttB = true;
    this.tyc = true;
    AppMethodBeat.o(113427);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    this.ttB = true;
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
    Log.i("MicroMsg.CardHomePageUI", "onResume locationPermissionGranted %s, hasInitLocation %s, shouldGetLayout %s", new Object[] { Boolean.valueOf(this.tyd), Boolean.valueOf(this.ttN), Boolean.valueOf(this.ttB) });
    if (this.tyd) {
      if ((this.ttN) && (this.ttB))
      {
        this.ttG = "";
        this.ttH = false;
        cFP();
      }
    }
    for (;;)
    {
      this.ttB = false;
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
        com.tencent.mm.plugin.report.service.h.IzE.b(localArrayList, true);
        this.mStartTime = 0L;
      }
      com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(113410);
          am.cHI().a(r.tHe);
          AppMethodBeat.o(113410);
        }
      });
      super.onResume();
      AppMethodBeat.o(113421);
      return;
      if (this.ttB)
      {
        this.ttG = "";
        cIv();
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(113438);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof ad))
      {
        cJA();
        this.tmx.onNotify();
        this.tyb.updateView();
        a(((ad)paramq).tqp);
        AppMethodBeat.o(113438);
        return;
      }
      if ((paramq instanceof com.tencent.mm.plugin.card.sharecard.model.b))
      {
        paramString = (com.tencent.mm.plugin.card.sharecard.model.b)paramq;
        this.ttF = false;
        this.ttG = paramString.trU;
        this.ttp.aO(paramString.tpZ, this.ttD);
        if ((!com.tencent.mm.plugin.card.sharecard.a.b.cId()) || (!com.tencent.mm.plugin.card.sharecard.a.b.cIe())) {
          this.ttD = false;
        }
        Log.i("MicroMsg.CardHomePageUI", "NetSceneGetShareCardsLayout() >> updateView()");
        updateView();
        AppMethodBeat.o(113438);
      }
    }
    else
    {
      if ((paramq instanceof com.tencent.mm.plugin.card.sharecard.model.b)) {
        this.ttF = false;
      }
      Log.i("MicroMsg.CardHomePageUI", "share card list ui, onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    AppMethodBeat.o(113438);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardHomePageUI
 * JD-Core Version:    0.7.0.1
 */