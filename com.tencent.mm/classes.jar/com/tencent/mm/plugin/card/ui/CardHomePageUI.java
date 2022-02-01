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
import com.tencent.mm.g.a.vm;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.d.r;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.sharecard.ui.ShareCardListUI;
import com.tencent.mm.protocal.protobuf.tg;
import com.tencent.mm.protocal.protobuf.ti;
import com.tencent.mm.protocal.protobuf.tv;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
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
  private long oDA = 0L;
  boolean oDB = false;
  private com.tencent.mm.plugin.card.sharecard.a.b oDc;
  private boolean oDp = false;
  private boolean oDr = true;
  private boolean oDt = false;
  private String oDu = "";
  private boolean oDv = false;
  private boolean oDw = false;
  private i oHL;
  private f oHM;
  private f oHN;
  private boolean oHO = true;
  private boolean oHP = false;
  private TextView oHQ;
  private LinearLayout oHR;
  
  private void a(tv paramtv)
  {
    AppMethodBeat.i(113440);
    this.oHR.removeAllViews();
    if ((paramtv != null) && (paramtv.FSo != null) && (!paramtv.FSo.isEmpty()))
    {
      paramtv = paramtv.FSo.iterator();
      while (paramtv.hasNext())
      {
        final ti localti = (ti)paramtv.next();
        View localView = LayoutInflater.from(getContext()).inflate(2131493285, this.oHR, false);
        new f(this, localView, 4, this.oDc, localti).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(113417);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardHomePageUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
            if (localti.FQV == 1) {
              com.tencent.mm.plugin.card.d.b.a(CardHomePageUI.this, localti.FQW, 0);
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardHomePageUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(113417);
              return;
              if (localti.FQV == 2)
              {
                if (localti.FQX != null)
                {
                  paramAnonymousView = new vm();
                  paramAnonymousView.dJF.userName = localti.FQX.CzQ;
                  paramAnonymousView.dJF.dJH = bt.bI(localti.FQX.CzR, "");
                  paramAnonymousView.dJF.scene = 1028;
                  com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousView);
                }
              }
              else if (localti.FQV == 3)
              {
                if ("weixin://wccard/sharecarddetail".equals(localti.FQY))
                {
                  com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.CardHomePageUI", "go to share card ui");
                  localObject = new Intent(CardHomePageUI.this, ShareCardListUI.class);
                  ((Intent)localObject).putExtra("key_layout_buff", CardHomePageUI.e(CardHomePageUI.this));
                  CardHomePageUI.f(CardHomePageUI.this);
                  paramAnonymousView = CardHomePageUI.this;
                  localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/card/ui/CardHomePageUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/card/ui/CardHomePageUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  com.tencent.mm.plugin.report.service.g.yhR.f(11324, new Object[] { "ClickShareCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) });
                }
              }
              else {
                com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.CardHomePageUI", "unknown op action: %s", new Object[] { Integer.valueOf(localti.FQV) });
              }
            }
          }
        });
        this.oHR.addView(localView);
      }
    }
    AppMethodBeat.o(113440);
  }
  
  private void bVI()
  {
    AppMethodBeat.i(113425);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.CardHomePageUI", "initLocation");
    com.tencent.mm.kernel.g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(113413);
        CardHomePageUI.c(CardHomePageUI.this);
        CardHomePageUI.d(CardHomePageUI.this);
        CardHomePageUI.this.oDB = true;
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.CardHomePageUI", "initLocation end");
        AppMethodBeat.o(113413);
      }
    });
    AppMethodBeat.o(113425);
  }
  
  private void bVO()
  {
    AppMethodBeat.i(113433);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.CardHomePageUI", "doGetLayout() >> doNetSceneGetCardsHomePageLayout()");
    bVP();
    if (com.tencent.mm.plugin.card.d.l.bYB()) {
      com.tencent.mm.plugin.card.b.b.bUb();
    }
    for (;;)
    {
      am.bUT().H("", "", 4);
      AppMethodBeat.o(113433);
      return;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CardHomePageUI", "the card entrance is not open, don't do doNetSceneGetCardsLayout!");
    }
  }
  
  private void bVP()
  {
    AppMethodBeat.i(113434);
    if (!this.oHO)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CardHomePageUI", "doNetSceneGetCardsHomePageLayout, shouldGetHomePage is false");
      AppMethodBeat.o(113434);
      return;
    }
    if (this.oDt)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.CardHomePageUI", "doNetSceneGetCardsHomePageLayout, isDoingGetData is true");
      AppMethodBeat.o(113434);
      return;
    }
    if ((this.oDr) && (!bt.isNullOrNil(this.oDu))) {
      this.oDu = "";
    }
    this.oDt = true;
    this.oHO = false;
    com.tencent.mm.plugin.card.sharecard.model.b localb = new com.tencent.mm.plugin.card.sharecard.model.b(am.bUT().fFf, am.bUT().fFg, this.oDu);
    com.tencent.mm.kernel.g.ajB().gAO.a(localb, 0);
    AppMethodBeat.o(113434);
  }
  
  private void bVR()
  {
    AppMethodBeat.i(113441);
    int i = getIntent().getIntExtra("key_from_scene", 22);
    boolean bool1 = com.tencent.mm.z.c.aht().cI(262152, 266256);
    boolean bool2 = com.tencent.mm.z.c.aht().cJ(262152, 266256);
    boolean bool3 = com.tencent.mm.z.c.aht().a(al.a.Irp, al.a.Irr);
    boolean bool4 = com.tencent.mm.z.c.aht().a(al.a.Irq, al.a.Irs);
    String str = bt.nullAsNil((String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Irv, null));
    if (bool1)
    {
      com.tencent.mm.plugin.report.service.g.yhR.f(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(2), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113441);
      return;
    }
    if (bool2)
    {
      com.tencent.mm.plugin.report.service.g.yhR.f(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113441);
      return;
    }
    if ((bool3) && (!bool4))
    {
      com.tencent.mm.plugin.report.service.g.yhR.f(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(3), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113441);
      return;
    }
    if ((bool3) && (bool4))
    {
      com.tencent.mm.plugin.report.service.g.yhR.f(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(4), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113441);
      return;
    }
    if (bool4)
    {
      com.tencent.mm.plugin.report.service.g.yhR.f(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(5), Integer.valueOf(i), "", Integer.valueOf(0), str });
      AppMethodBeat.o(113441);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yhR.f(11324, new Object[] { "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(i), "", Integer.valueOf(0), str });
    AppMethodBeat.o(113441);
  }
  
  private void bWT()
  {
    AppMethodBeat.i(113429);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CardHomePageUI", "updateMemberCardItem()");
    Object localObject = (c)this.owg;
    if (this.oHQ == null)
    {
      this.oHQ = ((TextView)findViewById(2131302227));
      this.oHQ.setOnClickListener(new CardHomePageUI.5(this));
    }
    if (((c)localObject).getCount() > 0)
    {
      this.oHQ.setVisibility(0);
      this.oHQ.setText(getString(2131756998, new Object[] { Integer.valueOf(com.tencent.mm.plugin.card.sharecard.a.b.bVp()) }));
    }
    for (;;)
    {
      this.oHM.bWS();
      AppMethodBeat.o(113429);
      return;
      this.oHQ.setVisibility(0);
      this.oHQ.setText(getString(2131756998, new Object[] { Integer.valueOf(com.tencent.mm.plugin.card.sharecard.a.b.bVp()) }));
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
  
  private static tv bWU()
  {
    AppMethodBeat.i(113439);
    String str = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IrO, null);
    if (bt.isNullOrNil(str))
    {
      AppMethodBeat.o(113439);
      return null;
    }
    tv localtv = new tv();
    try
    {
      localtv.parseFrom(str.getBytes("ISO-8859-1"));
      AppMethodBeat.o(113439);
      return localtv;
    }
    catch (IOException localIOException)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.CardHomePageUI", localIOException, "", new Object[0]);
      AppMethodBeat.o(113439);
    }
    return null;
  }
  
  private void bWV()
  {
    AppMethodBeat.i(113443);
    Intent localIntent = new Intent();
    localIntent.addFlags(67108864);
    localIntent.putExtra("preferred_tab", 3);
    com.tencent.mm.bs.d.f(this, "com.tencent.mm.ui.LauncherUI", localIntent);
    finish();
    AppMethodBeat.o(113443);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(113428);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CardHomePageUI", "updateView()");
    this.oHL.bXa();
    bWT();
    this.oHN.updateView();
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
    this.oDp = true;
  }
  
  public final void b(com.tencent.mm.plugin.card.base.b paramb, int paramInt)
  {
    AppMethodBeat.i(113436);
    super.b(paramb, paramInt);
    AppMethodBeat.o(113436);
  }
  
  public final void bTY()
  {
    this.oDp = true;
  }
  
  public final void bTg()
  {
    AppMethodBeat.i(113424);
    setMMTitle(2131756891);
    addTextOptionMenu(0, getString(2131756941), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(113411);
        com.tencent.mm.plugin.card.d.b.a(CardHomePageUI.this, true);
        com.tencent.mm.plugin.report.service.g.yhR.f(11582, new Object[] { "CardListMsgMenu", Integer.valueOf(2), Integer.valueOf(0), "", "" });
        AppMethodBeat.o(113411);
        return true;
      }
    });
    this.oDc = new com.tencent.mm.plugin.card.sharecard.a.b(this);
    this.oDc.init();
    if (this.oHL == null)
    {
      this.oHL = new i(this, getContentView());
      localObject = this.oHL;
      ((i)localObject).oIN = View.inflate(((i)localObject).owO, 2131493324, null);
      ((i)localObject).oIN.setVisibility(8);
      ((i)localObject).oIO = ((TextView)((i)localObject).oIN.findViewById(2131297832));
      ((i)localObject).oIP = ((ImageView)((i)localObject).oIN.findViewById(2131297830));
      ((i)localObject).oIN.setOnClickListener(new i.1((i)localObject));
      ((i)localObject).bXa();
      if (((i)localObject).oIQ == null)
      {
        ((i)localObject).oIQ = ((ViewStub)((i)localObject).iCR.findViewById(2131297861)).inflate();
        ((i)localObject).oIQ.setVisibility(8);
        ((i)localObject).oIR = ((TextView)((i)localObject).oIQ.findViewById(2131297832));
        ((i)localObject).oIS = ((ImageView)((i)localObject).oIQ.findViewById(2131297830));
        ((i)localObject).oIQ.setOnClickListener(new i.2((i)localObject));
      }
      this.oHL.oDH = true;
    }
    if (this.oHM == null) {
      this.oHM = new f(this, findViewById(2131297858), 1, this.oDc);
    }
    if (this.oHN == null) {
      this.oHN = new f(this, findViewById(2131297906), 3, this.oDc);
    }
    if (this.oHM != null) {
      this.oHM.setOnClickListener(new CardHomePageUI.6(this));
    }
    if (this.oHN != null) {
      this.oHN.setOnClickListener(new CardHomePageUI.7(this));
    }
    this.oHR = ((LinearLayout)findViewById(2131297768));
    Object localObject = bWU();
    if (localObject != null) {
      a((tv)localObject);
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
  
  public final n.a bTh()
  {
    return n.a.ozN;
  }
  
  public final boolean bTi()
  {
    AppMethodBeat.i(113435);
    boolean bool = super.bTi();
    AppMethodBeat.o(113435);
    return bool;
  }
  
  public final boolean bTj()
  {
    return true;
  }
  
  public final void bTn()
  {
    AppMethodBeat.i(113431);
    if (this.oDv)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.CardHomePageUI", "onLocationFinish, has do GetShareCardLayout,don't get again");
      if (this.oHP) {
        bTm();
      }
      AppMethodBeat.o(113431);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.CardHomePageUI", "onLocationFinish()");
    this.oDv = true;
    bVO();
    bTm();
    AppMethodBeat.o(113431);
  }
  
  public final void bTo()
  {
    AppMethodBeat.i(113432);
    if ((this.oDw) || (this.oDv))
    {
      bTm();
      AppMethodBeat.o(113432);
      return;
    }
    this.oDw = true;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CardHomePageUI", "onLocationFail()");
    bVO();
    AppMethodBeat.o(113432);
  }
  
  public final void bTp()
  {
    AppMethodBeat.i(113426);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CardHomePageUI", "onMPermissionGranted locationPermissionGranted " + this.oHP);
    if (!this.oHP)
    {
      this.oHP = true;
      bVI();
    }
    AppMethodBeat.o(113426);
  }
  
  public final void bTq()
  {
    AppMethodBeat.i(113430);
    bWT();
    AppMethodBeat.o(113430);
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
    this.oHP = bool;
    if (this.oHP) {
      bVI();
    }
    for (;;)
    {
      super.initView();
      AppMethodBeat.o(113423);
      return;
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.CardHomePageUI", "location permission is denied, doGetLayout");
      bVO();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113419);
    super.onCreate(paramBundle);
    this.fromScene = getIntent().getIntExtra("key_home_page_from_scene", 0);
    long l = System.currentTimeMillis();
    this.mStartTime = l;
    this.oDA = l;
    initView();
    paramBundle = this.oHL;
    am.bUR().a(paramBundle);
    com.tencent.mm.kernel.g.ajB().gAO.a(1164, this);
    com.tencent.mm.kernel.g.ajB().gAO.a(1054, this);
    am.bUU().bVo();
    am.bUM();
    com.tencent.mm.plugin.card.b.b.Ao(1);
    bVR();
    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(113418);
        if (CardHomePageUI.g(CardHomePageUI.this) != null)
        {
          CardHomePageUI.g(CardHomePageUI.this);
          if (com.tencent.mm.plugin.card.sharecard.a.b.bVx())
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CardHomePageUI", "try2UpdateCardType");
            CardHomePageUI.h(CardHomePageUI.this);
          }
        }
        AppMethodBeat.o(113418);
        return false;
      }
    });
    am.bUU().a(this);
    am.bUN().add(this);
    ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.b.class)).gD(8, 2);
    AppMethodBeat.o(113419);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113420);
    if (this.oHP) {
      bTm();
    }
    i locali = this.oHL;
    am.bUR().b(locali);
    this.oDc.oBv = null;
    com.tencent.mm.kernel.g.ajB().gAO.b(1164, this);
    com.tencent.mm.kernel.g.ajB().gAO.b(1054, this);
    am.bUU().b(this);
    am.bUN().remove(this);
    k.bUC();
    com.tencent.mm.plugin.card.sharecard.a.b.bVu();
    long l1 = System.currentTimeMillis();
    long l2 = this.oDA;
    com.tencent.mm.plugin.report.service.g.yhR.f(13219, new Object[] { "CardHomePageUI", Integer.valueOf(this.fromScene), "", "", Long.valueOf(l1 - l2) });
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
      bWV();
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
    bVR();
    this.oDp = true;
    this.oHO = true;
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CardHomePageUI", "onResume locationPermissionGranted %s, hasInitLocation %s, shouldGetLayout %s", new Object[] { Boolean.valueOf(this.oHP), Boolean.valueOf(this.oDB), Boolean.valueOf(this.oDp) });
    if (this.oHP) {
      if ((this.oDB) && (this.oDp))
      {
        this.oDu = "";
        this.oDv = false;
        bTl();
      }
    }
    for (;;)
    {
      this.oDp = false;
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
        com.tencent.mm.plugin.report.service.g.yhR.b(localArrayList, true);
        this.mStartTime = 0L;
      }
      com.tencent.mm.kernel.g.ajF().ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(113410);
          am.bVd().a(r.oPM);
          AppMethodBeat.o(113410);
        }
      });
      super.onResume();
      AppMethodBeat.o(113421);
      return;
      if (this.oDp)
      {
        this.oDu = "";
        bVO();
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
        bWT();
        this.owm.onNotify();
        this.oHN.updateView();
        a(((com.tencent.mm.plugin.card.model.ad)paramn).oAg);
        AppMethodBeat.o(113438);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.b))
      {
        paramString = (com.tencent.mm.plugin.card.sharecard.model.b)paramn;
        this.oDt = false;
        this.oDu = paramString.oBD;
        this.oDc.aH(paramString.ozQ, this.oDr);
        if ((!com.tencent.mm.plugin.card.sharecard.a.b.bVv()) || (!com.tencent.mm.plugin.card.sharecard.a.b.bVw())) {
          this.oDr = false;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CardHomePageUI", "NetSceneGetShareCardsLayout() >> updateView()");
        updateView();
        AppMethodBeat.o(113438);
      }
    }
    else
    {
      if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.b)) {
        this.oDt = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardHomePageUI
 * JD-Core Version:    0.7.0.1
 */