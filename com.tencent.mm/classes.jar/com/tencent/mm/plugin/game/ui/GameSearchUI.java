package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.game.model.ak;
import com.tencent.mm.plugin.game.model.al;
import com.tencent.mm.protocal.protobuf.ane;
import com.tencent.mm.protocal.protobuf.ang;
import com.tencent.mm.protocal.protobuf.ani;
import com.tencent.mm.protocal.protobuf.anj;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.anl;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Pattern;

public class GameSearchUI
  extends MMActivity
  implements com.tencent.mm.al.g, com.tencent.mm.ui.tools.r.b
{
  private static final Pattern smM;
  private int fromScene;
  private com.tencent.mm.ui.tools.r fvI;
  private View fwo;
  private ProgressBar progressBar;
  private TextView qHD;
  private ViewGroup smN;
  private ListView smO;
  private ListView smP;
  private r smQ;
  private s smR;
  private String smS;
  private String smT;
  private LinkedList<String> smU;
  private String smV;
  private LinkedList<n> smW;
  private boolean smX;
  private AdapterView.OnItemClickListener smY;
  private AdapterView.OnItemClickListener smZ;
  
  static
  {
    AppMethodBeat.i(42410);
    smM = Pattern.compile("\\s+");
    AppMethodBeat.o(42410);
  }
  
  public GameSearchUI()
  {
    AppMethodBeat.i(42392);
    this.smW = new LinkedList();
    this.smX = false;
    this.smY = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(42390);
        paramAnonymousAdapterView = GameSearchUI.b(GameSearchUI.this);
        if ((paramAnonymousInt < 0) || (paramAnonymousInt >= paramAnonymousAdapterView.getCount())) {}
        for (paramAnonymousAdapterView = null; paramAnonymousAdapterView == null; paramAnonymousAdapterView = ((r.b)paramAnonymousAdapterView.getItem(paramAnonymousInt)).smC)
        {
          AppMethodBeat.o(42390);
          return;
        }
        if ((paramAnonymousAdapterView.actionType == 1) && (!bt.isNullOrNil(paramAnonymousAdapterView.appId)))
        {
          paramAnonymousView = new Bundle();
          paramAnonymousView.putCharSequence("game_app_id", paramAnonymousAdapterView.appId);
          paramAnonymousView.putInt("game_report_from_scene", paramAnonymousAdapterView.dvS);
          paramAnonymousInt = com.tencent.mm.plugin.game.f.c.a(GameSearchUI.this, paramAnonymousAdapterView.appId, null, paramAnonymousView);
          paramAnonymousView = new HashMap();
          paramAnonymousView.put("function_type", "search");
          paramAnonymousView.put("funtion_value", paramAnonymousAdapterView.smE);
          paramAnonymousView.put("keyword", GameSearchUI.f(GameSearchUI.this));
          paramAnonymousView = com.tencent.mm.plugin.game.e.a.m(paramAnonymousView);
          com.tencent.mm.game.report.e.a(GameSearchUI.this, 14, paramAnonymousAdapterView.dvS, paramAnonymousAdapterView.position, paramAnonymousInt, paramAnonymousAdapterView.appId, GameSearchUI.g(GameSearchUI.this), paramAnonymousView);
          AppMethodBeat.o(42390);
          return;
        }
        if ((paramAnonymousAdapterView.actionType == 2) && (!bt.isNullOrNil(paramAnonymousAdapterView.smD)))
        {
          paramAnonymousInt = com.tencent.mm.plugin.game.f.c.A(GameSearchUI.this, paramAnonymousAdapterView.smD, "game_center_detail");
          paramAnonymousView = new HashMap();
          paramAnonymousView.put("function_type", "search");
          paramAnonymousView.put("funtion_value", paramAnonymousAdapterView.smE);
          paramAnonymousView.put("keyword", GameSearchUI.f(GameSearchUI.this));
          paramAnonymousView = com.tencent.mm.plugin.game.e.a.m(paramAnonymousView);
          com.tencent.mm.game.report.e.a(GameSearchUI.this, 14, paramAnonymousAdapterView.dvS, paramAnonymousAdapterView.position, paramAnonymousInt, 0, paramAnonymousAdapterView.appId, GameSearchUI.g(GameSearchUI.this), paramAnonymousAdapterView.smy, String.valueOf(paramAnonymousAdapterView.smz), null, paramAnonymousView);
        }
        AppMethodBeat.o(42390);
      }
    };
    this.smZ = new GameSearchUI.6(this);
    AppMethodBeat.o(42392);
  }
  
  private void a(LinkedList<String> paramLinkedList, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(42399);
    while (!this.smW.isEmpty())
    {
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.a((n)this.smW.pop());
    }
    if (paramBoolean) {
      this.smQ.reset();
    }
    this.smU = paramLinkedList;
    ak localak = new ak(ac.eFu(), paramLinkedList, com.tencent.mm.plugin.game.model.e.cCL(), this.smQ.rXN);
    com.tencent.mm.kernel.g.aeS().a(localak, 0);
    this.smW.add(localak);
    paramLinkedList = paramLinkedList.iterator();
    for (this.smS = ""; paramLinkedList.hasNext(); this.smS = (this.smS + " " + (String)paramLinkedList.next())) {}
    this.smS = this.smS.trim();
    if ((paramInt == 1) || (paramInt == 2))
    {
      this.smX = true;
      this.fvI.setSearchContent(this.smS);
    }
    AppMethodBeat.o(42399);
  }
  
  private void as(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(42398);
    a(paramLinkedList, 0, true);
    AppMethodBeat.o(42398);
  }
  
  private void sm(int paramInt)
  {
    AppMethodBeat.i(42397);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(42397);
      return;
      this.smN.setVisibility(8);
      this.qHD.setVisibility(8);
      this.smO.setVisibility(8);
      this.smP.setVisibility(8);
      this.progressBar.setVisibility(8);
      AppMethodBeat.o(42397);
      return;
      hideVKB();
      ListView localListView = this.smO;
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localListView, locala.adn(), "com/tencent/mm/plugin/game/ui/GameSearchUI", "updateUI", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
      localListView.smoothScrollToPosition(((Integer)locala.lS(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localListView, "com/tencent/mm/plugin/game/ui/GameSearchUI", "updateUI", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
      this.fvI.clearFocus();
      this.smN.setVisibility(8);
      this.qHD.setVisibility(8);
      this.smO.setVisibility(8);
      this.smP.setVisibility(8);
      this.progressBar.setVisibility(0);
      AppMethodBeat.o(42397);
      return;
      localListView = this.smO;
      locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localListView, locala.adn(), "com/tencent/mm/plugin/game/ui/GameSearchUI", "updateUI", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
      localListView.smoothScrollToPosition(((Integer)locala.lS(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localListView, "com/tencent/mm/plugin/game/ui/GameSearchUI", "updateUI", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
      this.smN.setVisibility(8);
      this.qHD.setVisibility(8);
      this.smO.setVisibility(8);
      this.smP.setVisibility(8);
      this.progressBar.setVisibility(0);
      AppMethodBeat.o(42397);
      return;
      this.smN.setVisibility(8);
      if (this.smQ.getCount() > 0)
      {
        this.qHD.setVisibility(8);
        this.smO.setVisibility(0);
      }
      for (;;)
      {
        this.smP.setVisibility(8);
        this.progressBar.setVisibility(8);
        AppMethodBeat.o(42397);
        return;
        this.qHD.setVisibility(0);
        this.smO.setVisibility(8);
      }
      this.smN.setVisibility(0);
      this.qHD.setVisibility(8);
      this.smO.setVisibility(8);
      this.smP.setVisibility(8);
      this.progressBar.setVisibility(8);
      AppMethodBeat.o(42397);
      return;
      this.smN.setVisibility(8);
      this.qHD.setVisibility(0);
      this.smO.setVisibility(8);
      this.smP.setVisibility(8);
      this.progressBar.setVisibility(8);
      AppMethodBeat.o(42397);
      return;
      this.smN.setVisibility(8);
      this.qHD.setVisibility(8);
      this.smO.setVisibility(8);
      this.smP.setVisibility(0);
      this.progressBar.setVisibility(8);
    }
  }
  
  public final boolean BX(String paramString)
  {
    AppMethodBeat.i(42406);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(42406);
      return true;
    }
    LinkedList localLinkedList = new LinkedList();
    paramString = smM.split(paramString.replace('*', ' '));
    int i = 0;
    while (i < paramString.length)
    {
      localLinkedList.add(paramString[i]);
      i += 1;
    }
    as(localLinkedList);
    sm(1);
    AppMethodBeat.o(42406);
    return true;
  }
  
  public final void BY(String paramString)
  {
    AppMethodBeat.i(42405);
    if (this.smX)
    {
      this.smX = false;
      AppMethodBeat.o(42405);
      return;
    }
    if ((this.smV != null) && (this.smV.equals(bt.nullAsNil(paramString))))
    {
      ad.d("MicroMsg.GameSearchUI", "repeat searchChange");
      AppMethodBeat.o(42405);
      return;
    }
    this.smV = paramString;
    if (bt.isNullOrNil(paramString))
    {
      while (!this.smW.isEmpty())
      {
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afA().gcy.a((n)this.smW.pop());
      }
      paramString = new al(ac.eFu(), paramString, com.tencent.mm.plugin.game.model.e.cCL());
      com.tencent.mm.kernel.g.aeS().a(paramString, 0);
      this.smW.add(paramString);
      AppMethodBeat.o(42405);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    paramString = smM.split(paramString.replace('*', ' '));
    int i = 0;
    while (i < paramString.length)
    {
      localLinkedList.add(paramString[i]);
      i += 1;
    }
    as(localLinkedList);
    sm(6);
    AppMethodBeat.o(42405);
  }
  
  public final void aIj()
  {
    AppMethodBeat.i(42404);
    hideVKB();
    onBackPressed();
    AppMethodBeat.o(42404);
  }
  
  public final void aIk() {}
  
  public final void aIl() {}
  
  public final void aIm() {}
  
  public int getLayoutId()
  {
    return 2131494378;
  }
  
  public void initView()
  {
    AppMethodBeat.i(42394);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(42386);
        GameSearchUI.this.onBackPressed();
        AppMethodBeat.o(42386);
        return true;
      }
    });
    this.fvI = new com.tencent.mm.ui.tools.r();
    this.fvI.wH(true);
    this.fvI.Htp = this;
    this.smN = ((ViewGroup)findViewById(2131306550));
    this.progressBar = ((ProgressBar)findViewById(2131304439));
    this.qHD = ((TextView)findViewById(2131302883));
    this.smO = ((ListView)findViewById(2131304442));
    this.smQ = new r(this);
    this.smO.setAdapter(this.smQ);
    this.smO.setOnItemClickListener(this.smY);
    this.smO.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(42387);
        GameSearchUI.a(GameSearchUI.this).clearFocus();
        GameSearchUI.this.hideVKB();
        AppMethodBeat.o(42387);
        return false;
      }
    });
    this.smO.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(42388);
        if ((paramAnonymousInt == 0) && (paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1) && (GameSearchUI.b(GameSearchUI.this).smh))
        {
          if (GameSearchUI.c(GameSearchUI.this) != null) {
            GameSearchUI.c(GameSearchUI.this).setVisibility(0);
          }
          GameSearchUI.a(GameSearchUI.this, GameSearchUI.d(GameSearchUI.this));
        }
        AppMethodBeat.o(42388);
      }
    });
    this.fwo = getLayoutInflater().inflate(2131494337, this.smO, false);
    this.fwo.setVisibility(8);
    this.smO.addFooterView(this.fwo);
    this.smP = ((ListView)findViewById(2131304440));
    this.smR = new s(this);
    this.smP.setAdapter(this.smR);
    this.smP.setOnItemClickListener(this.smZ);
    this.smP.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(42389);
        GameSearchUI.e(GameSearchUI.this).clearFocus();
        GameSearchUI.this.hideVKB();
        AppMethodBeat.o(42389);
        return false;
      }
    });
    AppMethodBeat.o(42394);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(42402);
    super.onBackPressed();
    AppMethodBeat.o(42402);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42393);
    long l = System.currentTimeMillis();
    super.onCreate(paramBundle);
    if (!com.tencent.mm.kernel.g.afw())
    {
      ad.e("MicroMsg.GameSearchUI", "account not ready");
      finish();
      AppMethodBeat.o(42393);
      return;
    }
    com.tencent.mm.kernel.g.aeS().a(1328, this);
    com.tencent.mm.kernel.g.aeS().a(1329, this);
    this.fromScene = getIntent().getIntExtra("game_report_from_scene", 0);
    initView();
    com.tencent.mm.game.report.e.a(this, 14, 1401, 0, 2, this.fromScene, null);
    ad.i("MicroMsg.GameSearchUI", "[onCreate] time:" + (System.currentTimeMillis() - l));
    AppMethodBeat.o(42393);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(42395);
    this.fvI.a(this, paramMenu);
    this.fvI.setHint(com.tencent.mm.plugin.game.model.e.cCZ());
    AppMethodBeat.o(42395);
    return true;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(42403);
    ad.i("MicroMsg.GameSearchUI", "onDestroy");
    super.onDestroy();
    com.tencent.mm.kernel.g.aeS().b(1328, this);
    com.tencent.mm.kernel.g.aeS().b(1329, this);
    AppMethodBeat.o(42403);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(42401);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      onBackPressed();
      AppMethodBeat.o(42401);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(42401);
    return bool;
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(42396);
    this.fvI.a(this, paramMenu);
    AppMethodBeat.o(42396);
    return true;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(42400);
    if (paramn.isCanceled())
    {
      AppMethodBeat.o(42400);
      return;
    }
    if (this.smW.contains(paramn)) {
      this.smW.remove(paramn);
    }
    this.fwo.setVisibility(8);
    switch (paramn.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(42400);
      return;
      paramString = (ani)((ak)paramn).fUF.gUS.gUX;
      ad.d("MicroMsg.GameSearchUI", "keywords = %s, offset = %d", new Object[] { paramString.Dow, Integer.valueOf(paramString.Dox) });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (anj)((ak)paramn).fUF.gUT.gUX;
        label212:
        Object localObject3;
        label282:
        Object localObject4;
        if (paramString != null)
        {
          paramString = paramString.Doy;
          if (bt.gL(paramString)) {
            break label1767;
          }
          this.smT = this.smS;
          if (this.smQ.rXN != 0)
          {
            paramn = this.smQ;
            localObject1 = this.smT;
            paramString = paramString.iterator();
          }
        }
        else
        {
          for (;;)
          {
            if (!paramString.hasNext()) {
              break label1767;
            }
            localObject2 = (ank)paramString.next();
            if ((((ank)localObject2).type == 3) && (!bt.gL(((ank)localObject2).DoA)))
            {
              paramn.rXN = ((ank)localObject2).DoE;
              paramn.smh = ((ank)localObject2).DoF;
              localObject2 = ((ank)localObject2).DoA.iterator();
              if (((Iterator)localObject2).hasNext())
              {
                localObject3 = r.b.a((anm)((Iterator)localObject2).next());
                ((r.b)localObject3).dcm = ((String)localObject1);
                ((r.b)localObject3).smC.appId = ((r.b)localObject3).appId;
                ((r.b)localObject3).smC.smy = ((r.b)localObject3).smy;
                ((r.b)localObject3).smC.smz = ((r.b)localObject3).smz;
                ((r.b)localObject3).smC.smE = "2";
                localObject4 = ((r.b)localObject3).smC;
                paramInt1 = paramn.sme;
                paramn.sme = (paramInt1 + 1);
                ((r.c)localObject4).position = (paramInt1 + 301);
                localObject4 = ((r.b)localObject3).smC;
                if (!paramn.dcq) {
                  break label439;
                }
              }
              label439:
              for (paramInt1 = 1403;; paramInt1 = 1405)
              {
                ((r.c)localObject4).dvS = paramInt1;
                paramn.fQh.add(localObject3);
                break label282;
                break label212;
                paramString = null;
                break;
              }
            }
            paramn.smh = false;
          }
        }
        paramn = this.smQ;
        localObject1 = this.smT;
        if (paramn.fQh == null) {
          paramn.fQh = new ArrayList();
        }
        paramn.sjI = 0;
        paramn.smc = 0;
        paramn.smd = 0;
        paramn.sme = 0;
        paramn.smf = 0;
        paramn.dcq = false;
        paramn.smb = false;
        paramn.smh = false;
        paramn.rXN = 0;
        paramn.fQh.clear();
        paramn.smi = false;
        Object localObject2 = paramString.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          paramString = (ank)((Iterator)localObject2).next();
          label601:
          label620:
          int i;
          if ((paramString.Doz == null) || (paramString.Doz.size() == 0))
          {
            paramInt1 = 1;
            if ((paramString.DoA != null) && (paramString.DoA.size() != 0)) {
              break label725;
            }
            paramInt2 = 1;
            if ((paramString.DoD != null) && (paramString.DoD.size() != 0)) {
              break label730;
            }
            i = 1;
            label640:
            if ((paramInt1 == 0) || (paramInt2 == 0) || (i == 0)) {
              break label736;
            }
            paramInt1 = 1;
            label655:
            if (paramInt1 == 0) {
              break label756;
            }
            if (paramString.type != 1) {
              continue;
            }
            if (bt.isNullOrNil((String)localObject1)) {
              break label741;
            }
          }
          label725:
          label730:
          label736:
          label741:
          for (paramString = paramn.context.getString(2131759974, new Object[] { localObject1 });; paramString = paramn.context.getString(2131759973))
          {
            paramn.fQh.add(r.b.bh(6, paramString));
            paramn.smi = true;
            break;
            paramInt1 = 0;
            break label601;
            paramInt2 = 0;
            break label620;
            i = 0;
            break label640;
            paramInt1 = 0;
            break label655;
          }
          label756:
          paramn.fQh.add(r.b.bh(0, paramString.Title));
          if (!paramn.smi)
          {
            ((r.b)paramn.fQh.get(paramn.fQh.size() - 1)).smA = true;
            paramn.smi = true;
          }
          Object localObject5;
          if ((paramString.type == 4) && (paramString.DoD != null))
          {
            localObject3 = paramString.DoD.iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject5 = (anl)((Iterator)localObject3).next();
              localObject4 = new r.b();
              ((r.b)localObject4).type = 3;
              ((r.b)localObject4).appId = ((anl)localObject5).DoG.hnC;
              ((r.b)localObject4).name = ((anl)localObject5).DoG.Name;
              ((r.b)localObject4).iaz = ((anl)localObject5).DoG.Dap;
              ((r.b)localObject4).iconUrl = ((anl)localObject5).DoG.IconUrl;
              ((r.b)localObject4).smu = ((anl)localObject5).DoG.rZx;
              ((r.b)localObject4).smv = ((anl)localObject5).DoG.Don;
              ((r.b)localObject4).actionType = ((anl)localObject5).DoG.CKO;
              ((r.b)localObject4).smw = ((anl)localObject5).DoG.Doo;
              ((r.b)localObject4).smx = ((anl)localObject5).DoH;
              ((r.b)localObject4).smC = new r.c(((anl)localObject5).DoG.CKO, 4, ((anl)localObject5).DoG.hnC, ((anl)localObject5).DoG.Doo);
              ((r.b)localObject4).dcm = ((String)localObject1);
              ((r.b)localObject4).smC.smE = "3";
              localObject5 = ((r.b)localObject4).smC;
              paramInt1 = paramn.smd;
              paramn.smd = (paramInt1 + 1);
              ((r.c)localObject5).position = (paramInt1 + 601);
              paramn.fQh.add(localObject4);
            }
          }
          if (((paramString.type == 1) || (paramString.type == 2)) && (paramString.Doz != null))
          {
            localObject3 = paramString.Doz.iterator();
            if (((Iterator)localObject3).hasNext())
            {
              localObject5 = (ane)((Iterator)localObject3).next();
              localObject4 = new r.b();
              ((r.b)localObject4).type = 1;
              ((r.b)localObject4).appId = ((ane)localObject5).hnC;
              ((r.b)localObject4).name = ((ane)localObject5).Name;
              ((r.b)localObject4).iaz = ((ane)localObject5).Dap;
              ((r.b)localObject4).iconUrl = ((ane)localObject5).IconUrl;
              ((r.b)localObject4).smu = ((ane)localObject5).rZx;
              ((r.b)localObject4).smv = ((ane)localObject5).Don;
              ((r.b)localObject4).actionType = ((ane)localObject5).CKO;
              ((r.b)localObject4).smw = ((ane)localObject5).Doo;
              ((r.b)localObject4).smC = new r.c(((ane)localObject5).CKO, 1, ((ane)localObject5).hnC, ((ane)localObject5).Doo);
              ((r.b)localObject4).dcm = ((String)localObject1);
              if (paramString.type == 1)
              {
                paramn.dcq = true;
                localObject5 = ((r.b)localObject4).smC;
                paramInt1 = paramn.sjI;
                paramn.sjI = (paramInt1 + 1);
                ((r.c)localObject5).position = (paramInt1 + 1);
              }
              for (;;)
              {
                ((r.b)localObject4).smC.smE = "1";
                paramn.fQh.add(localObject4);
                break;
                if (paramString.type == 2)
                {
                  paramn.smb = true;
                  localObject5 = ((r.b)localObject4).smC;
                  paramInt1 = paramn.smc;
                  paramn.smc = (paramInt1 + 1);
                  ((r.c)localObject5).position = (paramInt1 + 1);
                }
              }
            }
          }
          else if ((paramString.type == 3) && (paramString.DoA != null))
          {
            paramn.rXN = paramString.DoE;
            paramn.smh = paramString.DoF;
            localObject3 = paramString.DoA.iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = r.b.a((anm)((Iterator)localObject3).next());
              ((r.b)localObject4).dcm = ((String)localObject1);
              ((r.b)localObject4).smC.appId = ((r.b)localObject4).appId;
              ((r.b)localObject4).smC.smy = ((r.b)localObject4).smy;
              ((r.b)localObject4).smC.smz = ((r.b)localObject4).smz;
              ((r.b)localObject4).smC.smE = "2";
              localObject5 = ((r.b)localObject4).smC;
              paramInt1 = paramn.sme;
              paramn.sme = (paramInt1 + 1);
              ((r.c)localObject5).position = (paramInt1 + 301);
              paramn.fQh.add(localObject4);
            }
          }
          if ((!bt.isNullOrNil(paramString.DoB)) && (!bt.isNullOrNil(paramString.DoC)) && (paramString.type == 1))
          {
            localObject3 = paramString.DoB;
            paramString = paramString.DoC;
            localObject4 = new r.b();
            ((r.b)localObject4).type = 5;
            ((r.b)localObject4).name = ((String)localObject3);
            ((r.b)localObject4).smC = new r.c(paramString);
            ((r.b)localObject4).smC.appId = "wx62d9035fd4fd2059";
            ((r.b)localObject4).smC.smE = "1";
            ((r.b)localObject4).smC.position = 300;
            paramn.fQh.add(localObject4);
          }
        }
        paramString = paramn.fQh.iterator();
        while (paramString.hasNext())
        {
          localObject1 = (r.b)paramString.next();
          if (paramn.dcq) {
            ((r.b)localObject1).smC.dvS = 1403;
          } else if (paramn.smb) {
            ((r.b)localObject1).smC.dvS = 1404;
          } else {
            ((r.b)localObject1).smC.dvS = 1405;
          }
        }
        paramn.notifyDataSetChanged();
      }
      label1767:
      sm(2);
      AppMethodBeat.o(42400);
      return;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(42400);
        return;
      }
      paramString = ((al)paramn).dcm;
      Object localObject1 = ((ang)((al)paramn).fUF.gUT.gUX).Title;
      paramn = ((ang)((al)paramn).fUF.gUT.gUX).Dou;
      this.smR.b(paramString, (String)localObject1, paramn);
      sm(5);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameSearchUI
 * JD-Core Version:    0.7.0.1
 */