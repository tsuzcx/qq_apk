package com.tencent.mm.plugin.card.ui;

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
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.base.d;
import com.tencent.mm.plugin.card.c.l;
import com.tencent.mm.plugin.card.c.r;
import com.tencent.mm.plugin.card.mgr.j;
import com.tencent.mm.plugin.card.model.ad;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.protocal.protobuf.wi;
import com.tencent.mm.protocal.protobuf.wv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
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
  private boolean wCA = false;
  private TextView wCB;
  private LinearLayout wCC;
  private i wCw;
  private f wCx;
  private f wCy;
  private boolean wCz = true;
  private com.tencent.mm.plugin.card.sharecard.a.b wxM;
  private boolean wxY = false;
  private boolean wya = true;
  private boolean wyc = false;
  private String wyd = "";
  private boolean wye = false;
  private boolean wyf = false;
  private long wyj = 0L;
  boolean wyk = false;
  
  private void a(wv paramwv)
  {
    AppMethodBeat.i(113440);
    this.wCC.removeAllViews();
    if ((paramwv != null) && (paramwv.ZeB != null) && (!paramwv.ZeB.isEmpty()))
    {
      paramwv = paramwv.ZeB.iterator();
      while (paramwv.hasNext())
      {
        wi localwi = (wi)paramwv.next();
        View localView = LayoutInflater.from(getContext()).inflate(a.e.wmI, this.wCC, false);
        new f(this, localView, 4, this.wxM, localwi).setOnClickListener(new CardHomePageUI.8(this, localwi));
        this.wCC.addView(localView);
      }
    }
    AppMethodBeat.o(113440);
  }
  
  private void dlG()
  {
    AppMethodBeat.i(113425);
    Log.d("MicroMsg.CardHomePageUI", "initLocation");
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(113413);
        CardHomePageUI.c(CardHomePageUI.this);
        CardHomePageUI.d(CardHomePageUI.this);
        CardHomePageUI.this.wyk = true;
        Log.d("MicroMsg.CardHomePageUI", "initLocation end");
        AppMethodBeat.o(113413);
      }
    });
    AppMethodBeat.o(113425);
  }
  
  private void dlM()
  {
    AppMethodBeat.i(113433);
    Log.d("MicroMsg.CardHomePageUI", "doGetLayout() >> doNetSceneGetCardsHomePageLayout()");
    dlN();
    if (l.doP()) {
      com.tencent.mm.plugin.card.mgr.a.djX();
    }
    for (;;)
    {
      am.dkP().R("", "", 4);
      AppMethodBeat.o(113433);
      return;
      Log.i("MicroMsg.CardHomePageUI", "the card entrance is not open, don't do doNetSceneGetCardsLayout!");
    }
  }
  
  private void dlN()
  {
    AppMethodBeat.i(113434);
    if (!this.wCz)
    {
      Log.i("MicroMsg.CardHomePageUI", "doNetSceneGetCardsHomePageLayout, shouldGetHomePage is false");
      AppMethodBeat.o(113434);
      return;
    }
    if (this.wyc)
    {
      Log.e("MicroMsg.CardHomePageUI", "doNetSceneGetCardsHomePageLayout, isDoingGetData is true");
      AppMethodBeat.o(113434);
      return;
    }
    if ((this.wya) && (!Util.isNullOrNil(this.wyd))) {
      this.wyd = "";
    }
    this.wyc = true;
    this.wCz = false;
    com.tencent.mm.plugin.card.sharecard.model.b localb = new com.tencent.mm.plugin.card.sharecard.model.b(am.dkP().lsz, am.dkP().lsA, this.wyd);
    com.tencent.mm.kernel.h.baD().mCm.a(localb, 0);
    AppMethodBeat.o(113434);
  }
  
  private void dlP()
  {
    AppMethodBeat.i(113441);
    int i = getIntent().getIntExtra("key_from_scene", 22);
    boolean bool1 = com.tencent.mm.aa.c.aYo().dV(262152, 266256);
    boolean bool2 = com.tencent.mm.aa.c.aYo().dW(262152, 266256);
    boolean bool3 = com.tencent.mm.aa.c.aYo().a(at.a.acJh, at.a.acJj);
    boolean bool4 = com.tencent.mm.aa.c.aYo().a(at.a.acJi, at.a.acJk);
    String str = Util.nullAsNil((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acJn, null));
    if (bool1)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(2), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113441);
      return;
    }
    if (bool2)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113441);
      return;
    }
    if ((bool3) && (!bool4))
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(3), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113441);
      return;
    }
    if ((bool3) && (bool4))
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(4), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113441);
      return;
    }
    if (bool4)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(5), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113441);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(i), "", Integer.valueOf(0), str });
    AppMethodBeat.o(113441);
  }
  
  private void dmR()
  {
    AppMethodBeat.i(113429);
    Log.i("MicroMsg.CardHomePageUI", "updateMemberCardItem()");
    Object localObject = (c)this.wqR;
    if (this.wCB == null)
    {
      this.wCB = ((TextView)findViewById(a.d.wkA));
      this.wCB.setOnClickListener(new CardHomePageUI.5(this));
    }
    if (((c)localObject).getCount() > 0)
    {
      this.wCB.setVisibility(0);
      this.wCB.setText(getString(a.g.wqm, new Object[] { Integer.valueOf(com.tencent.mm.plugin.card.sharecard.a.b.dlo()) }));
    }
    for (;;)
    {
      this.wCx.dmQ();
      AppMethodBeat.o(113429);
      return;
      this.wCB.setVisibility(0);
      this.wCB.setText(getString(a.g.wqm, new Object[] { Integer.valueOf(com.tencent.mm.plugin.card.sharecard.a.b.dlo()) }));
      localObject = (LinearLayout)findViewById(a.d.wgz);
      if (localObject != null)
      {
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
        localLayoutParams.topMargin = com.tencent.mm.cd.a.fromDPToPix(this, 29);
        localLayoutParams.bottomMargin = com.tencent.mm.cd.a.fromDPToPix(this, 29);
        ((LinearLayout)localObject).setLayoutParams(localLayoutParams);
      }
    }
  }
  
  private static wv dmS()
  {
    AppMethodBeat.i(113439);
    String str = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acJG, null);
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(113439);
      return null;
    }
    wv localwv = new wv();
    try
    {
      localwv.parseFrom(str.getBytes("ISO-8859-1"));
      AppMethodBeat.o(113439);
      return localwv;
    }
    catch (IOException localIOException)
    {
      Log.printErrStackTrace("MicroMsg.CardHomePageUI", localIOException, "", new Object[0]);
      AppMethodBeat.o(113439);
    }
    return null;
  }
  
  private void dmT()
  {
    AppMethodBeat.i(113443);
    Intent localIntent = new Intent();
    localIntent.addFlags(67108864);
    localIntent.putExtra("preferred_tab", 3);
    com.tencent.mm.br.c.g(this, "com.tencent.mm.ui.LauncherUI", localIntent);
    finish();
    AppMethodBeat.o(113443);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(113428);
    Log.i("MicroMsg.CardHomePageUI", "updateView()");
    this.wCw.dmX();
    dmR();
    this.wCy.updateView();
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
  
  public final void djU()
  {
    this.wxY = true;
  }
  
  public final void djb()
  {
    AppMethodBeat.i(113424);
    setMMTitle(a.g.woX);
    addTextOptionMenu(0, getString(a.g.wpF), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(113411);
        com.tencent.mm.plugin.card.c.b.a(CardHomePageUI.this, true);
        com.tencent.mm.plugin.report.service.h.OAn.b(11582, new Object[] { "CardListMsgMenu", Integer.valueOf(2), Integer.valueOf(0), "", "" });
        AppMethodBeat.o(113411);
        return true;
      }
    });
    this.wxM = new com.tencent.mm.plugin.card.sharecard.a.b(this);
    this.wxM.init();
    if (this.wCw == null)
    {
      this.wCw = new i(this, getContentView());
      localObject = this.wCw;
      ((i)localObject).wDx = View.inflate(((i)localObject).wry, a.e.wnt, null);
      ((i)localObject).wDx.setVisibility(8);
      ((i)localObject).wDy = ((TextView)((i)localObject).wDx.findViewById(a.d.wgM));
      ((i)localObject).wDz = ((ImageView)((i)localObject).wDx.findViewById(a.d.wgL));
      ((i)localObject).wDx.setOnClickListener(new i.1((i)localObject));
      ((i)localObject).dmX();
      if (((i)localObject).wDA == null)
      {
        ((i)localObject).wDA = ((ViewStub)((i)localObject).plc.findViewById(a.d.whh)).inflate();
        ((i)localObject).wDA.setVisibility(8);
        ((i)localObject).wDB = ((TextView)((i)localObject).wDA.findViewById(a.d.wgM));
        ((i)localObject).wDC = ((ImageView)((i)localObject).wDA.findViewById(a.d.wgL));
        ((i)localObject).wDA.setOnClickListener(new i.2((i)localObject));
      }
      this.wCw.wyq = true;
    }
    if (this.wCx == null) {
      this.wCx = new f(this, findViewById(a.d.whe), 1, this.wxM);
    }
    if (this.wCy == null) {
      this.wCy = new f(this, findViewById(a.d.whR), 3, this.wxM);
    }
    if (this.wCx != null) {
      this.wCx.setOnClickListener(new CardHomePageUI.6(this));
    }
    if (this.wCy != null) {
      this.wCy.setOnClickListener(new CardHomePageUI.7(this));
    }
    this.wCC = ((LinearLayout)findViewById(a.d.wfS));
    Object localObject = dmS();
    if (localObject != null) {
      a((wv)localObject);
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
  
  public final n.a djc()
  {
    return n.a.wuv;
  }
  
  public final boolean djd()
  {
    AppMethodBeat.i(113435);
    boolean bool = super.djd();
    AppMethodBeat.o(113435);
    return bool;
  }
  
  public final boolean dje()
  {
    return true;
  }
  
  public final void djj()
  {
    AppMethodBeat.i(113431);
    if (this.wye)
    {
      Log.e("MicroMsg.CardHomePageUI", "onLocationFinish, has do GetShareCardLayout,don't get again");
      if (this.wCA) {
        dji();
      }
      AppMethodBeat.o(113431);
      return;
    }
    Log.d("MicroMsg.CardHomePageUI", "onLocationFinish()");
    this.wye = true;
    dlM();
    dji();
    AppMethodBeat.o(113431);
  }
  
  public final void djk()
  {
    AppMethodBeat.i(113432);
    if ((this.wyf) || (this.wye))
    {
      dji();
      AppMethodBeat.o(113432);
      return;
    }
    this.wyf = true;
    Log.i("MicroMsg.CardHomePageUI", "onLocationFail()");
    dlM();
    AppMethodBeat.o(113432);
  }
  
  public final void djl()
  {
    AppMethodBeat.i(113426);
    Log.i("MicroMsg.CardHomePageUI", "onMPermissionGranted locationPermissionGranted " + this.wCA);
    if (!this.wCA)
    {
      this.wCA = true;
      dlG();
    }
    AppMethodBeat.o(113426);
  }
  
  public final void djm()
  {
    AppMethodBeat.i(113430);
    dmR();
    AppMethodBeat.o(113430);
  }
  
  public int getLayoutId()
  {
    return a.e.wmT;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113423);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 69, null);
    Log.i("MicroMsg.CardHomePageUI", "checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
    this.wCA = bool;
    if (this.wCA) {
      dlG();
    }
    for (;;)
    {
      super.initView();
      AppMethodBeat.o(113423);
      return;
      Log.e("MicroMsg.CardHomePageUI", "location permission is denied, doGetLayout");
      dlM();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113419);
    super.onCreate(paramBundle);
    this.fromScene = getIntent().getIntExtra("key_home_page_from_scene", 0);
    long l = System.currentTimeMillis();
    this.mStartTime = l;
    this.wyj = l;
    initView();
    paramBundle = this.wCw;
    am.dkN().a(paramBundle);
    com.tencent.mm.kernel.h.baD().mCm.a(1164, this);
    com.tencent.mm.kernel.h.baD().mCm.a(1054, this);
    am.dkQ().dln();
    am.dkI();
    com.tencent.mm.plugin.card.mgr.a.Ih(1);
    dlP();
    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(113418);
        if (CardHomePageUI.g(CardHomePageUI.this) != null)
        {
          CardHomePageUI.g(CardHomePageUI.this);
          if (com.tencent.mm.plugin.card.sharecard.a.b.dlw())
          {
            Log.i("MicroMsg.CardHomePageUI", "try2UpdateCardType");
            CardHomePageUI.h(CardHomePageUI.this);
          }
        }
        AppMethodBeat.o(113418);
        return false;
      }
    });
    am.dkQ().a(this);
    am.dkJ().add(this);
    ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.wallet.b.class)).jO(8, 2);
    AppMethodBeat.o(113419);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113420);
    if (this.wCA) {
      dji();
    }
    i locali = this.wCw;
    am.dkN().b(locali);
    this.wxM.wwk = null;
    com.tencent.mm.kernel.h.baD().mCm.b(1164, this);
    com.tencent.mm.kernel.h.baD().mCm.b(1054, this);
    am.dkQ().b(this);
    am.dkJ().remove(this);
    j.dky();
    com.tencent.mm.plugin.card.sharecard.a.b.dlt();
    long l1 = System.currentTimeMillis();
    long l2 = this.wyj;
    com.tencent.mm.plugin.report.service.h.OAn.b(13219, new Object[] { "CardHomePageUI", Integer.valueOf(this.fromScene), "", "", Long.valueOf(l1 - l2) });
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
      dmT();
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
    dlP();
    this.wxY = true;
    this.wCz = true;
    AppMethodBeat.o(113427);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    this.wxY = true;
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
    Log.i("MicroMsg.CardHomePageUI", "onResume locationPermissionGranted %s, hasInitLocation %s, shouldGetLayout %s", new Object[] { Boolean.valueOf(this.wCA), Boolean.valueOf(this.wyk), Boolean.valueOf(this.wxY) });
    if (this.wCA) {
      if ((this.wyk) && (this.wxY))
      {
        this.wyd = "";
        this.wye = false;
        djh();
      }
    }
    for (;;)
    {
      this.wxY = false;
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
        com.tencent.mm.plugin.report.service.h.OAn.b(localArrayList, true);
        this.mStartTime = 0L;
      }
      com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(113410);
          am.dkZ().a(r.wKF);
          AppMethodBeat.o(113410);
        }
      });
      super.onResume();
      AppMethodBeat.o(113421);
      return;
      if (this.wxY)
      {
        this.wyd = "";
        dlM();
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(113438);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramp);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramp instanceof ad))
      {
        dmR();
        this.wqX.onNotify();
        this.wCy.updateView();
        a(((ad)paramp).wuO);
        AppMethodBeat.o(113438);
        return;
      }
      if ((paramp instanceof com.tencent.mm.plugin.card.sharecard.model.b))
      {
        paramString = (com.tencent.mm.plugin.card.sharecard.model.b)paramp;
        this.wyc = false;
        this.wyd = paramString.wws;
        this.wxM.ba(paramString.wuy, this.wya);
        if ((!com.tencent.mm.plugin.card.sharecard.a.b.dlu()) || (!com.tencent.mm.plugin.card.sharecard.a.b.dlv())) {
          this.wya = false;
        }
        Log.i("MicroMsg.CardHomePageUI", "NetSceneGetShareCardsLayout() >> updateView()");
        updateView();
        AppMethodBeat.o(113438);
      }
    }
    else
    {
      if ((paramp instanceof com.tencent.mm.plugin.card.sharecard.model.b)) {
        this.wyc = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardHomePageUI
 * JD-Core Version:    0.7.0.1
 */