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
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.base.d;
import com.tencent.mm.plugin.card.d.r;
import com.tencent.mm.plugin.card.model.ad;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.up;
import com.tencent.mm.protocal.protobuf.vc;
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

@com.tencent.mm.kernel.i
public class CardHomePageUI
  extends CardBaseUI
  implements d, MStorage.IOnStorageChange
{
  private int fromScene = 0;
  private long mStartTime = 0L;
  private boolean pXF = false;
  private boolean pXH = true;
  private boolean pXJ = false;
  private String pXK = "";
  private boolean pXL = false;
  private boolean pXM = false;
  private long pXQ = 0L;
  boolean pXR = false;
  private com.tencent.mm.plugin.card.sharecard.a.b pXs;
  private i qcb;
  private f qcc;
  private f qcd;
  private boolean qce = true;
  private boolean qcf = false;
  private TextView qcg;
  private LinearLayout qch;
  
  private void a(vc paramvc)
  {
    AppMethodBeat.i(113440);
    this.qch.removeAllViews();
    if ((paramvc != null) && (paramvc.Lfp != null) && (!paramvc.Lfp.isEmpty()))
    {
      paramvc = paramvc.Lfp.iterator();
      while (paramvc.hasNext())
      {
        up localup = (up)paramvc.next();
        View localView = LayoutInflater.from(getContext()).inflate(2131493375, this.qch, false);
        new f(this, localView, 4, this.pXs, localup).setOnClickListener(new CardHomePageUI.8(this, localup));
        this.qch.addView(localView);
      }
    }
    AppMethodBeat.o(113440);
  }
  
  private void cuN()
  {
    AppMethodBeat.i(113425);
    Log.d("MicroMsg.CardHomePageUI", "initLocation");
    com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(113413);
        CardHomePageUI.c(CardHomePageUI.this);
        CardHomePageUI.d(CardHomePageUI.this);
        CardHomePageUI.this.pXR = true;
        Log.d("MicroMsg.CardHomePageUI", "initLocation end");
        AppMethodBeat.o(113413);
      }
    });
    AppMethodBeat.o(113425);
  }
  
  private void cuT()
  {
    AppMethodBeat.i(113433);
    Log.d("MicroMsg.CardHomePageUI", "doGetLayout() >> doNetSceneGetCardsHomePageLayout()");
    cuU();
    if (com.tencent.mm.plugin.card.d.l.cxF()) {
      com.tencent.mm.plugin.card.b.b.cte();
    }
    for (;;)
    {
      am.ctW().G("", "", 4);
      AppMethodBeat.o(113433);
      return;
      Log.i("MicroMsg.CardHomePageUI", "the card entrance is not open, don't do doNetSceneGetCardsLayout!");
    }
  }
  
  private void cuU()
  {
    AppMethodBeat.i(113434);
    if (!this.qce)
    {
      Log.i("MicroMsg.CardHomePageUI", "doNetSceneGetCardsHomePageLayout, shouldGetHomePage is false");
      AppMethodBeat.o(113434);
      return;
    }
    if (this.pXJ)
    {
      Log.e("MicroMsg.CardHomePageUI", "doNetSceneGetCardsHomePageLayout, isDoingGetData is true");
      AppMethodBeat.o(113434);
      return;
    }
    if ((this.pXH) && (!Util.isNullOrNil(this.pXK))) {
      this.pXK = "";
    }
    this.pXJ = true;
    this.qce = false;
    com.tencent.mm.plugin.card.sharecard.model.b localb = new com.tencent.mm.plugin.card.sharecard.model.b(am.ctW().gmu, am.ctW().gmv, this.pXK);
    com.tencent.mm.kernel.g.aAg().hqi.a(localb, 0);
    AppMethodBeat.o(113434);
  }
  
  private void cuW()
  {
    AppMethodBeat.i(113441);
    int i = getIntent().getIntExtra("key_from_scene", 22);
    boolean bool1 = com.tencent.mm.y.c.axV().cO(262152, 266256);
    boolean bool2 = com.tencent.mm.y.c.axV().cP(262152, 266256);
    boolean bool3 = com.tencent.mm.y.c.axV().a(ar.a.NTN, ar.a.NTP);
    boolean bool4 = com.tencent.mm.y.c.axV().a(ar.a.NTO, ar.a.NTQ);
    String str = Util.nullAsNil((String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NTT, null));
    if (bool1)
    {
      h.CyF.a(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(2), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113441);
      return;
    }
    if (bool2)
    {
      h.CyF.a(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113441);
      return;
    }
    if ((bool3) && (!bool4))
    {
      h.CyF.a(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(3), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113441);
      return;
    }
    if ((bool3) && (bool4))
    {
      h.CyF.a(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(4), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113441);
      return;
    }
    if (bool4)
    {
      h.CyF.a(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(5), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113441);
      return;
    }
    h.CyF.a(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(i), "", Integer.valueOf(0), str });
    AppMethodBeat.o(113441);
  }
  
  private void cvY()
  {
    AppMethodBeat.i(113429);
    Log.i("MicroMsg.CardHomePageUI", "updateMemberCardItem()");
    Object localObject = (c)this.pQr;
    if (this.qcg == null)
    {
      this.qcg = ((TextView)findViewById(2131304593));
      this.qcg.setOnClickListener(new CardHomePageUI.5(this));
    }
    if (((c)localObject).getCount() > 0)
    {
      this.qcg.setVisibility(0);
      this.qcg.setText(getString(2131757168, new Object[] { Integer.valueOf(com.tencent.mm.plugin.card.sharecard.a.b.cuv()) }));
    }
    for (;;)
    {
      this.qcc.cvX();
      AppMethodBeat.o(113429);
      return;
      this.qcg.setVisibility(0);
      this.qcg.setText(getString(2131757168, new Object[] { Integer.valueOf(com.tencent.mm.plugin.card.sharecard.a.b.cuv()) }));
      localObject = (LinearLayout)findViewById(2131298129);
      if (localObject != null)
      {
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
        localLayoutParams.topMargin = com.tencent.mm.cb.a.fromDPToPix(this, 29);
        localLayoutParams.bottomMargin = com.tencent.mm.cb.a.fromDPToPix(this, 29);
        ((LinearLayout)localObject).setLayoutParams(localLayoutParams);
      }
    }
  }
  
  private static vc cvZ()
  {
    AppMethodBeat.i(113439);
    String str = (String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NUm, null);
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(113439);
      return null;
    }
    vc localvc = new vc();
    try
    {
      localvc.parseFrom(str.getBytes("ISO-8859-1"));
      AppMethodBeat.o(113439);
      return localvc;
    }
    catch (IOException localIOException)
    {
      Log.printErrStackTrace("MicroMsg.CardHomePageUI", localIOException, "", new Object[0]);
      AppMethodBeat.o(113439);
    }
    return null;
  }
  
  private void cwa()
  {
    AppMethodBeat.i(113443);
    Intent localIntent = new Intent();
    localIntent.addFlags(67108864);
    localIntent.putExtra("preferred_tab", 3);
    com.tencent.mm.br.c.f(this, "com.tencent.mm.ui.LauncherUI", localIntent);
    finish();
    AppMethodBeat.o(113443);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(113428);
    Log.i("MicroMsg.CardHomePageUI", "updateView()");
    this.qcb.cwf();
    cvY();
    this.qcd.updateView();
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
  
  public final void csj()
  {
    AppMethodBeat.i(113424);
    setMMTitle(2131757061);
    addTextOptionMenu(0, getString(2131757111), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(113411);
        com.tencent.mm.plugin.card.d.b.a(CardHomePageUI.this, true);
        h.CyF.a(11582, new Object[] { "CardListMsgMenu", Integer.valueOf(2), Integer.valueOf(0), "", "" });
        AppMethodBeat.o(113411);
        return true;
      }
    });
    this.pXs = new com.tencent.mm.plugin.card.sharecard.a.b(this);
    this.pXs.init();
    if (this.qcb == null)
    {
      this.qcb = new i(this, getContentView());
      localObject = this.qcb;
      ((i)localObject).qdd = View.inflate(((i)localObject).pQZ, 2131493415, null);
      ((i)localObject).qdd.setVisibility(8);
      ((i)localObject).qde = ((TextView)((i)localObject).qdd.findViewById(2131298148));
      ((i)localObject).qdf = ((ImageView)((i)localObject).qdd.findViewById(2131298146));
      ((i)localObject).qdd.setOnClickListener(new i.1((i)localObject));
      ((i)localObject).cwf();
      if (((i)localObject).qdg == null)
      {
        ((i)localObject).qdg = ((ViewStub)((i)localObject).jBN.findViewById(2131298177)).inflate();
        ((i)localObject).qdg.setVisibility(8);
        ((i)localObject).qdh = ((TextView)((i)localObject).qdg.findViewById(2131298148));
        ((i)localObject).qdi = ((ImageView)((i)localObject).qdg.findViewById(2131298146));
        ((i)localObject).qdg.setOnClickListener(new i.2((i)localObject));
      }
      this.qcb.pXX = true;
    }
    if (this.qcc == null) {
      this.qcc = new f(this, findViewById(2131298174), 1, this.pXs);
    }
    if (this.qcd == null) {
      this.qcd = new f(this, findViewById(2131298224), 3, this.pXs);
    }
    if (this.qcc != null) {
      this.qcc.setOnClickListener(new CardHomePageUI.6(this));
    }
    if (this.qcd != null) {
      this.qcd.setOnClickListener(new CardHomePageUI.7(this));
    }
    this.qch = ((LinearLayout)findViewById(2131298082));
    Object localObject = cvZ();
    if (localObject != null) {
      a((vc)localObject);
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
  
  public final n.a csk()
  {
    return n.a.pTV;
  }
  
  public final boolean csl()
  {
    AppMethodBeat.i(113435);
    boolean bool = super.csl();
    AppMethodBeat.o(113435);
    return bool;
  }
  
  public final boolean csm()
  {
    return true;
  }
  
  public final void csq()
  {
    AppMethodBeat.i(113431);
    if (this.pXL)
    {
      Log.e("MicroMsg.CardHomePageUI", "onLocationFinish, has do GetShareCardLayout,don't get again");
      if (this.qcf) {
        csp();
      }
      AppMethodBeat.o(113431);
      return;
    }
    Log.d("MicroMsg.CardHomePageUI", "onLocationFinish()");
    this.pXL = true;
    cuT();
    csp();
    AppMethodBeat.o(113431);
  }
  
  public final void csr()
  {
    AppMethodBeat.i(113432);
    if ((this.pXM) || (this.pXL))
    {
      csp();
      AppMethodBeat.o(113432);
      return;
    }
    this.pXM = true;
    Log.i("MicroMsg.CardHomePageUI", "onLocationFail()");
    cuT();
    AppMethodBeat.o(113432);
  }
  
  public final void css()
  {
    AppMethodBeat.i(113426);
    Log.i("MicroMsg.CardHomePageUI", "onMPermissionGranted locationPermissionGranted " + this.qcf);
    if (!this.qcf)
    {
      this.qcf = true;
      cuN();
    }
    AppMethodBeat.o(113426);
  }
  
  public final void cst()
  {
    AppMethodBeat.i(113430);
    cvY();
    AppMethodBeat.o(113430);
  }
  
  public final void ctb()
  {
    this.pXF = true;
  }
  
  public int getLayoutId()
  {
    return 2131493388;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113423);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 69, null, null);
    Log.i("MicroMsg.CardHomePageUI", "checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
    this.qcf = bool;
    if (this.qcf) {
      cuN();
    }
    for (;;)
    {
      super.initView();
      AppMethodBeat.o(113423);
      return;
      Log.e("MicroMsg.CardHomePageUI", "location permission is denied, doGetLayout");
      cuT();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113419);
    super.onCreate(paramBundle);
    this.fromScene = getIntent().getIntExtra("key_home_page_from_scene", 0);
    long l = System.currentTimeMillis();
    this.mStartTime = l;
    this.pXQ = l;
    initView();
    paramBundle = this.qcb;
    am.ctU().a(paramBundle);
    com.tencent.mm.kernel.g.aAg().hqi.a(1164, this);
    com.tencent.mm.kernel.g.aAg().hqi.a(1054, this);
    am.ctX().cuu();
    am.ctP();
    com.tencent.mm.plugin.card.b.b.Ef(1);
    cuW();
    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(113418);
        if (CardHomePageUI.g(CardHomePageUI.this) != null)
        {
          CardHomePageUI.g(CardHomePageUI.this);
          if (com.tencent.mm.plugin.card.sharecard.a.b.cuD())
          {
            Log.i("MicroMsg.CardHomePageUI", "try2UpdateCardType");
            CardHomePageUI.h(CardHomePageUI.this);
          }
        }
        AppMethodBeat.o(113418);
        return false;
      }
    });
    am.ctX().a(this);
    am.ctQ().add(this);
    ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.b.class)).he(8, 2);
    AppMethodBeat.o(113419);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113420);
    if (this.qcf) {
      csp();
    }
    i locali = this.qcb;
    am.ctU().b(locali);
    this.pXs.pVL = null;
    com.tencent.mm.kernel.g.aAg().hqi.b(1164, this);
    com.tencent.mm.kernel.g.aAg().hqi.b(1054, this);
    am.ctX().b(this);
    am.ctQ().remove(this);
    k.ctF();
    com.tencent.mm.plugin.card.sharecard.a.b.cuA();
    long l1 = System.currentTimeMillis();
    long l2 = this.pXQ;
    h.CyF.a(13219, new Object[] { "CardHomePageUI", Integer.valueOf(this.fromScene), "", "", Long.valueOf(l1 - l2) });
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
      cwa();
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
    cuW();
    this.pXF = true;
    this.qce = true;
    AppMethodBeat.o(113427);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    this.pXF = true;
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
    Log.i("MicroMsg.CardHomePageUI", "onResume locationPermissionGranted %s, hasInitLocation %s, shouldGetLayout %s", new Object[] { Boolean.valueOf(this.qcf), Boolean.valueOf(this.pXR), Boolean.valueOf(this.pXF) });
    if (this.qcf) {
      if ((this.pXR) && (this.pXF))
      {
        this.pXK = "";
        this.pXL = false;
        cso();
      }
    }
    for (;;)
    {
      this.pXF = false;
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
        h.CyF.b(localArrayList, true);
        this.mStartTime = 0L;
      }
      com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(113410);
          am.cug().a(r.qli);
          AppMethodBeat.o(113410);
        }
      });
      super.onResume();
      AppMethodBeat.o(113421);
      return;
      if (this.pXF)
      {
        this.pXK = "";
        cuT();
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
        cvY();
        this.pQx.onNotify();
        this.qcd.updateView();
        a(((ad)paramq).pUo);
        AppMethodBeat.o(113438);
        return;
      }
      if ((paramq instanceof com.tencent.mm.plugin.card.sharecard.model.b))
      {
        paramString = (com.tencent.mm.plugin.card.sharecard.model.b)paramq;
        this.pXJ = false;
        this.pXK = paramString.pVT;
        this.pXs.aL(paramString.pTY, this.pXH);
        if ((!com.tencent.mm.plugin.card.sharecard.a.b.cuB()) || (!com.tencent.mm.plugin.card.sharecard.a.b.cuC())) {
          this.pXH = false;
        }
        Log.i("MicroMsg.CardHomePageUI", "NetSceneGetShareCardsLayout() >> updateView()");
        updateView();
        AppMethodBeat.o(113438);
      }
    }
    else
    {
      if ((paramq instanceof com.tencent.mm.plugin.card.sharecard.model.b)) {
        this.pXJ = false;
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