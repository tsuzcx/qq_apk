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
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.model.ak;
import com.tencent.mm.plugin.game.model.al;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.protocal.protobuf.auu;
import com.tencent.mm.protocal.protobuf.auw;
import com.tencent.mm.protocal.protobuf.auy;
import com.tencent.mm.protocal.protobuf.auz;
import com.tencent.mm.protocal.protobuf.ava;
import com.tencent.mm.protocal.protobuf.avb;
import com.tencent.mm.protocal.protobuf.avc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Pattern;

public class GameSearchUI
  extends MMActivity
  implements com.tencent.mm.ak.f, com.tencent.mm.ui.tools.r.b
{
  private static final Pattern uEx;
  private com.tencent.mm.ui.tools.r fUI;
  private View fVr;
  private int fromScene;
  private ProgressBar progressBar;
  private TextView sCU;
  private ListView uEA;
  private r uEB;
  private s uEC;
  private String uED;
  private String uEE;
  private LinkedList<String> uEF;
  private String uEG;
  private LinkedList<n> uEH;
  private boolean uEI;
  private AdapterView.OnItemClickListener uEJ;
  private AdapterView.OnItemClickListener uEK;
  private ViewGroup uEy;
  private ListView uEz;
  
  static
  {
    AppMethodBeat.i(42410);
    uEx = Pattern.compile("\\s+");
    AppMethodBeat.o(42410);
  }
  
  public GameSearchUI()
  {
    AppMethodBeat.i(42392);
    this.uEH = new LinkedList();
    this.uEI = false;
    this.uEJ = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(42390);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameSearchUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
        paramAnonymousAdapterView = GameSearchUI.b(GameSearchUI.this);
        if ((paramAnonymousInt < 0) || (paramAnonymousInt >= paramAnonymousAdapterView.getCount())) {}
        for (paramAnonymousAdapterView = null; paramAnonymousAdapterView == null; paramAnonymousAdapterView = ((r.b)paramAnonymousAdapterView.getItem(paramAnonymousInt)).uEn)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameSearchUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(42390);
          return;
        }
        if ((paramAnonymousAdapterView.actionType == 1) && (!bu.isNullOrNil(paramAnonymousAdapterView.appId)))
        {
          paramAnonymousView = new Bundle();
          paramAnonymousView.putCharSequence("game_app_id", paramAnonymousAdapterView.appId);
          paramAnonymousView.putInt("game_report_from_scene", paramAnonymousAdapterView.dGL);
          paramAnonymousInt = com.tencent.mm.plugin.game.f.c.a(GameSearchUI.this, paramAnonymousAdapterView.appId, null, paramAnonymousView);
          paramAnonymousView = new HashMap();
          paramAnonymousView.put("function_type", "search");
          paramAnonymousView.put("funtion_value", paramAnonymousAdapterView.uEp);
          paramAnonymousView.put("keyword", GameSearchUI.f(GameSearchUI.this));
          paramAnonymousView = com.tencent.mm.plugin.game.e.a.s(paramAnonymousView);
          com.tencent.mm.game.report.f.a(GameSearchUI.this, 14, paramAnonymousAdapterView.dGL, paramAnonymousAdapterView.position, paramAnonymousInt, paramAnonymousAdapterView.appId, GameSearchUI.g(GameSearchUI.this), paramAnonymousView);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameSearchUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(42390);
          return;
          if ((paramAnonymousAdapterView.actionType == 2) && (!bu.isNullOrNil(paramAnonymousAdapterView.uEo)))
          {
            paramAnonymousInt = com.tencent.mm.plugin.game.f.c.B(GameSearchUI.this, paramAnonymousAdapterView.uEo, "game_center_detail");
            paramAnonymousView = new HashMap();
            paramAnonymousView.put("function_type", "search");
            paramAnonymousView.put("funtion_value", paramAnonymousAdapterView.uEp);
            paramAnonymousView.put("keyword", GameSearchUI.f(GameSearchUI.this));
            paramAnonymousView = com.tencent.mm.plugin.game.e.a.s(paramAnonymousView);
            com.tencent.mm.game.report.f.a(GameSearchUI.this, 14, paramAnonymousAdapterView.dGL, paramAnonymousAdapterView.position, paramAnonymousInt, 0, paramAnonymousAdapterView.appId, GameSearchUI.g(GameSearchUI.this), paramAnonymousAdapterView.uEj, String.valueOf(paramAnonymousAdapterView.uEk), null, paramAnonymousView);
          }
        }
      }
    };
    this.uEK = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(42391);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameSearchUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
        paramAnonymousAdapterView = ((s)paramAnonymousAdapterView.getAdapter()).IA(paramAnonymousInt);
        if (bu.isNullOrNil(paramAnonymousAdapterView.text))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameSearchUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(42391);
          return;
        }
        if (bu.isNullOrNil(paramAnonymousAdapterView.appId))
        {
          paramAnonymousView = new LinkedList();
          paramAnonymousView.add(paramAnonymousAdapterView.text);
          GameSearchUI.b(GameSearchUI.this, paramAnonymousView);
          GameSearchUI.h(GameSearchUI.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameSearchUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(42391);
          return;
          int i;
          switch (paramAnonymousAdapterView.actionType)
          {
          default: 
            ae.e("MicroMsg.GameSearchUI", "unknowed actionType : " + paramAnonymousAdapterView.actionType);
            break;
          case 1: 
            paramAnonymousView = new Bundle();
            paramAnonymousView.putCharSequence("game_app_id", paramAnonymousAdapterView.appId);
            paramAnonymousView.putInt("game_report_from_scene", 1402);
            i = com.tencent.mm.plugin.game.f.c.a(GameSearchUI.this, paramAnonymousAdapterView.appId, null, paramAnonymousView);
            com.tencent.mm.game.report.f.a(GameSearchUI.this, 14, 1402, paramAnonymousInt, i, paramAnonymousAdapterView.appId, GameSearchUI.g(GameSearchUI.this), null);
            break;
          case 2: 
            i = com.tencent.mm.plugin.game.f.c.B(GameSearchUI.this.getContext(), paramAnonymousAdapterView.uEq, "game_center_detail");
            com.tencent.mm.game.report.f.a(GameSearchUI.this, 14, 1402, paramAnonymousInt, i, paramAnonymousAdapterView.appId, GameSearchUI.g(GameSearchUI.this), null);
          }
        }
      }
    };
    AppMethodBeat.o(42392);
  }
  
  private void a(LinkedList<String> paramLinkedList, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(42399);
    while (!this.uEH.isEmpty())
    {
      g.ajS();
      g.ajQ().gDv.a((n)this.uEH.pop());
    }
    if (paramBoolean) {
      this.uEB.reset();
    }
    this.uEF = paramLinkedList;
    ak localak = new ak(ad.fom(), paramLinkedList, e.dbk(), this.uEB.uoD);
    g.ajj().a(localak, 0);
    this.uEH.add(localak);
    paramLinkedList = paramLinkedList.iterator();
    for (this.uED = ""; paramLinkedList.hasNext(); this.uED = (this.uED + " " + (String)paramLinkedList.next())) {}
    this.uED = this.uED.trim();
    if ((paramInt == 1) || (paramInt == 2))
    {
      this.uEI = true;
      this.fUI.setSearchContent(this.uED);
    }
    AppMethodBeat.o(42399);
  }
  
  private void aB(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(42398);
    a(paramLinkedList, 0, true);
    AppMethodBeat.o(42398);
  }
  
  private void tK(int paramInt)
  {
    AppMethodBeat.i(42397);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(42397);
      return;
      this.uEy.setVisibility(8);
      this.sCU.setVisibility(8);
      this.uEz.setVisibility(8);
      this.uEA.setVisibility(8);
      this.progressBar.setVisibility(8);
      AppMethodBeat.o(42397);
      return;
      hideVKB();
      ListView localListView = this.uEz;
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localListView, locala.ahE(), "com/tencent/mm/plugin/game/ui/GameSearchUI", "updateUI", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
      localListView.smoothScrollToPosition(((Integer)locala.mt(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localListView, "com/tencent/mm/plugin/game/ui/GameSearchUI", "updateUI", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
      this.fUI.clearFocus();
      this.uEy.setVisibility(8);
      this.sCU.setVisibility(8);
      this.uEz.setVisibility(8);
      this.uEA.setVisibility(8);
      this.progressBar.setVisibility(0);
      AppMethodBeat.o(42397);
      return;
      localListView = this.uEz;
      locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localListView, locala.ahE(), "com/tencent/mm/plugin/game/ui/GameSearchUI", "updateUI", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
      localListView.smoothScrollToPosition(((Integer)locala.mt(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localListView, "com/tencent/mm/plugin/game/ui/GameSearchUI", "updateUI", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
      this.uEy.setVisibility(8);
      this.sCU.setVisibility(8);
      this.uEz.setVisibility(8);
      this.uEA.setVisibility(8);
      this.progressBar.setVisibility(0);
      AppMethodBeat.o(42397);
      return;
      this.uEy.setVisibility(8);
      if (this.uEB.getCount() > 0)
      {
        this.sCU.setVisibility(8);
        this.uEz.setVisibility(0);
      }
      for (;;)
      {
        this.uEA.setVisibility(8);
        this.progressBar.setVisibility(8);
        AppMethodBeat.o(42397);
        return;
        this.sCU.setVisibility(0);
        this.uEz.setVisibility(8);
      }
      this.uEy.setVisibility(0);
      this.sCU.setVisibility(8);
      this.uEz.setVisibility(8);
      this.uEA.setVisibility(8);
      this.progressBar.setVisibility(8);
      AppMethodBeat.o(42397);
      return;
      this.uEy.setVisibility(8);
      this.sCU.setVisibility(0);
      this.uEz.setVisibility(8);
      this.uEA.setVisibility(8);
      this.progressBar.setVisibility(8);
      AppMethodBeat.o(42397);
      return;
      this.uEy.setVisibility(8);
      this.sCU.setVisibility(8);
      this.uEz.setVisibility(8);
      this.uEA.setVisibility(0);
      this.progressBar.setVisibility(8);
    }
  }
  
  public final boolean JO(String paramString)
  {
    AppMethodBeat.i(42406);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(42406);
      return true;
    }
    LinkedList localLinkedList = new LinkedList();
    paramString = uEx.split(paramString.replace('*', ' '));
    int i = 0;
    while (i < paramString.length)
    {
      localLinkedList.add(paramString[i]);
      i += 1;
    }
    aB(localLinkedList);
    tK(1);
    AppMethodBeat.o(42406);
    return true;
  }
  
  public final void JP(String paramString)
  {
    AppMethodBeat.i(42405);
    if (this.uEI)
    {
      this.uEI = false;
      AppMethodBeat.o(42405);
      return;
    }
    if ((this.uEG != null) && (this.uEG.equals(bu.nullAsNil(paramString))))
    {
      ae.d("MicroMsg.GameSearchUI", "repeat searchChange");
      AppMethodBeat.o(42405);
      return;
    }
    this.uEG = paramString;
    if (bu.isNullOrNil(paramString))
    {
      while (!this.uEH.isEmpty())
      {
        g.ajS();
        g.ajQ().gDv.a((n)this.uEH.pop());
      }
      paramString = new al(ad.fom(), paramString, e.dbk());
      g.ajj().a(paramString, 0);
      this.uEH.add(paramString);
      AppMethodBeat.o(42405);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    paramString = uEx.split(paramString.replace('*', ' '));
    int i = 0;
    while (i < paramString.length)
    {
      localLinkedList.add(paramString[i]);
      i += 1;
    }
    aB(localLinkedList);
    tK(6);
    AppMethodBeat.o(42405);
  }
  
  public final void aSL()
  {
    AppMethodBeat.i(42404);
    hideVKB();
    onBackPressed();
    AppMethodBeat.o(42404);
  }
  
  public final void aSM() {}
  
  public final void aSN() {}
  
  public final void aSO() {}
  
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
    this.fUI = new com.tencent.mm.ui.tools.r();
    this.fUI.yP(true);
    this.fUI.Lhk = this;
    this.uEy = ((ViewGroup)findViewById(2131306550));
    this.progressBar = ((ProgressBar)findViewById(2131304439));
    this.sCU = ((TextView)findViewById(2131302883));
    this.uEz = ((ListView)findViewById(2131304442));
    this.uEB = new r(this);
    this.uEz.setAdapter(this.uEB);
    this.uEz.setOnItemClickListener(this.uEJ);
    this.uEz.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(42387);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameSearchUI$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        GameSearchUI.a(GameSearchUI.this).clearFocus();
        GameSearchUI.this.hideVKB();
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/game/ui/GameSearchUI$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(42387);
        return false;
      }
    });
    this.uEz.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(42388);
        if ((paramAnonymousInt == 0) && (paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1) && (GameSearchUI.b(GameSearchUI.this).uDS))
        {
          if (GameSearchUI.c(GameSearchUI.this) != null) {
            GameSearchUI.c(GameSearchUI.this).setVisibility(0);
          }
          GameSearchUI.a(GameSearchUI.this, GameSearchUI.d(GameSearchUI.this));
        }
        AppMethodBeat.o(42388);
      }
    });
    this.fVr = getLayoutInflater().inflate(2131494337, this.uEz, false);
    this.fVr.setVisibility(8);
    this.uEz.addFooterView(this.fVr);
    this.uEA = ((ListView)findViewById(2131304440));
    this.uEC = new s(this);
    this.uEA.setAdapter(this.uEC);
    this.uEA.setOnItemClickListener(this.uEK);
    this.uEA.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(42389);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameSearchUI$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        GameSearchUI.e(GameSearchUI.this).clearFocus();
        GameSearchUI.this.hideVKB();
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/game/ui/GameSearchUI$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
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
    if (!g.ajM())
    {
      ae.e("MicroMsg.GameSearchUI", "account not ready");
      finish();
      AppMethodBeat.o(42393);
      return;
    }
    g.ajj().a(1328, this);
    g.ajj().a(1329, this);
    this.fromScene = getIntent().getIntExtra("game_report_from_scene", 0);
    initView();
    com.tencent.mm.game.report.f.a(this, 14, 1401, 0, 2, this.fromScene, null);
    ae.i("MicroMsg.GameSearchUI", "[onCreate] time:" + (System.currentTimeMillis() - l));
    AppMethodBeat.o(42393);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(42395);
    this.fUI.a(this, paramMenu);
    this.fUI.setHint(e.dby());
    AppMethodBeat.o(42395);
    return true;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(42403);
    ae.i("MicroMsg.GameSearchUI", "onDestroy");
    super.onDestroy();
    g.ajj().b(1328, this);
    g.ajj().b(1329, this);
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
    this.fUI.a(this, paramMenu);
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
    if (this.uEH.contains(paramn)) {
      this.uEH.remove(paramn);
    }
    this.fVr.setVisibility(8);
    switch (paramn.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(42400);
      return;
      paramString = (auy)((ak)paramn).gux.hQD.hQJ;
      ae.d("MicroMsg.GameSearchUI", "keywords = %s, offset = %d", new Object[] { paramString.GLW, Integer.valueOf(paramString.GLX) });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (auz)((ak)paramn).gux.hQE.hQJ;
        label212:
        Object localObject3;
        label282:
        Object localObject4;
        if (paramString != null)
        {
          paramString = paramString.GLY;
          if (bu.ht(paramString)) {
            break label1767;
          }
          this.uEE = this.uED;
          if (this.uEB.uoD != 0)
          {
            paramn = this.uEB;
            localObject1 = this.uEE;
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
            localObject2 = (ava)paramString.next();
            if ((((ava)localObject2).type == 3) && (!bu.ht(((ava)localObject2).GMa)))
            {
              paramn.uoD = ((ava)localObject2).GMe;
              paramn.uDS = ((ava)localObject2).GMf;
              localObject2 = ((ava)localObject2).GMa.iterator();
              if (((Iterator)localObject2).hasNext())
              {
                localObject3 = r.b.a((avc)((Iterator)localObject2).next());
                ((r.b)localObject3).dmf = ((String)localObject1);
                ((r.b)localObject3).uEn.appId = ((r.b)localObject3).appId;
                ((r.b)localObject3).uEn.uEj = ((r.b)localObject3).uEj;
                ((r.b)localObject3).uEn.uEk = ((r.b)localObject3).uEk;
                ((r.b)localObject3).uEn.uEp = "2";
                localObject4 = ((r.b)localObject3).uEn;
                paramInt1 = paramn.uDP;
                paramn.uDP = (paramInt1 + 1);
                ((r.c)localObject4).position = (paramInt1 + 301);
                localObject4 = ((r.b)localObject3).uEn;
                if (!paramn.dmj) {
                  break label439;
                }
              }
              label439:
              for (paramInt1 = 1403;; paramInt1 = 1405)
              {
                ((r.c)localObject4).dGL = paramInt1;
                paramn.gqc.add(localObject3);
                break label282;
                break label212;
                paramString = null;
                break;
              }
            }
            paramn.uDS = false;
          }
        }
        paramn = this.uEB;
        localObject1 = this.uEE;
        if (paramn.gqc == null) {
          paramn.gqc = new ArrayList();
        }
        paramn.uBu = 0;
        paramn.uDN = 0;
        paramn.uDO = 0;
        paramn.uDP = 0;
        paramn.uDQ = 0;
        paramn.dmj = false;
        paramn.uDM = false;
        paramn.uDS = false;
        paramn.uoD = 0;
        paramn.gqc.clear();
        paramn.uDT = false;
        Object localObject2 = paramString.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          paramString = (ava)((Iterator)localObject2).next();
          label601:
          label620:
          int i;
          if ((paramString.GLZ == null) || (paramString.GLZ.size() == 0))
          {
            paramInt1 = 1;
            if ((paramString.GMa != null) && (paramString.GMa.size() != 0)) {
              break label725;
            }
            paramInt2 = 1;
            if ((paramString.GMd != null) && (paramString.GMd.size() != 0)) {
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
            if (bu.isNullOrNil((String)localObject1)) {
              break label741;
            }
          }
          label725:
          label730:
          label736:
          label741:
          for (paramString = paramn.context.getString(2131759974, new Object[] { localObject1 });; paramString = paramn.context.getString(2131759973))
          {
            paramn.gqc.add(r.b.bo(6, paramString));
            paramn.uDT = true;
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
          paramn.gqc.add(r.b.bo(0, paramString.Title));
          if (!paramn.uDT)
          {
            ((r.b)paramn.gqc.get(paramn.gqc.size() - 1)).uEl = true;
            paramn.uDT = true;
          }
          Object localObject5;
          if ((paramString.type == 4) && (paramString.GMd != null))
          {
            localObject3 = paramString.GMd.iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject5 = (avb)((Iterator)localObject3).next();
              localObject4 = new r.b();
              ((r.b)localObject4).type = 3;
              ((r.b)localObject4).appId = ((avb)localObject5).GMg.ikm;
              ((r.b)localObject4).name = ((avb)localObject5).GMg.Name;
              ((r.b)localObject4).iWF = ((avb)localObject5).GMg.Gtk;
              ((r.b)localObject4).iconUrl = ((avb)localObject5).GMg.IconUrl;
              ((r.b)localObject4).uEf = ((avb)localObject5).GMg.uqr;
              ((r.b)localObject4).uEg = ((avb)localObject5).GMg.GLN;
              ((r.b)localObject4).actionType = ((avb)localObject5).GMg.GbY;
              ((r.b)localObject4).uEh = ((avb)localObject5).GMg.GLO;
              ((r.b)localObject4).uEi = ((avb)localObject5).GMh;
              ((r.b)localObject4).uEn = new r.c(((avb)localObject5).GMg.GbY, 4, ((avb)localObject5).GMg.ikm, ((avb)localObject5).GMg.GLO);
              ((r.b)localObject4).dmf = ((String)localObject1);
              ((r.b)localObject4).uEn.uEp = "3";
              localObject5 = ((r.b)localObject4).uEn;
              paramInt1 = paramn.uDO;
              paramn.uDO = (paramInt1 + 1);
              ((r.c)localObject5).position = (paramInt1 + 601);
              paramn.gqc.add(localObject4);
            }
          }
          if (((paramString.type == 1) || (paramString.type == 2)) && (paramString.GLZ != null))
          {
            localObject3 = paramString.GLZ.iterator();
            if (((Iterator)localObject3).hasNext())
            {
              localObject5 = (auu)((Iterator)localObject3).next();
              localObject4 = new r.b();
              ((r.b)localObject4).type = 1;
              ((r.b)localObject4).appId = ((auu)localObject5).ikm;
              ((r.b)localObject4).name = ((auu)localObject5).Name;
              ((r.b)localObject4).iWF = ((auu)localObject5).Gtk;
              ((r.b)localObject4).iconUrl = ((auu)localObject5).IconUrl;
              ((r.b)localObject4).uEf = ((auu)localObject5).uqr;
              ((r.b)localObject4).uEg = ((auu)localObject5).GLN;
              ((r.b)localObject4).actionType = ((auu)localObject5).GbY;
              ((r.b)localObject4).uEh = ((auu)localObject5).GLO;
              ((r.b)localObject4).uEn = new r.c(((auu)localObject5).GbY, 1, ((auu)localObject5).ikm, ((auu)localObject5).GLO);
              ((r.b)localObject4).dmf = ((String)localObject1);
              if (paramString.type == 1)
              {
                paramn.dmj = true;
                localObject5 = ((r.b)localObject4).uEn;
                paramInt1 = paramn.uBu;
                paramn.uBu = (paramInt1 + 1);
                ((r.c)localObject5).position = (paramInt1 + 1);
              }
              for (;;)
              {
                ((r.b)localObject4).uEn.uEp = "1";
                paramn.gqc.add(localObject4);
                break;
                if (paramString.type == 2)
                {
                  paramn.uDM = true;
                  localObject5 = ((r.b)localObject4).uEn;
                  paramInt1 = paramn.uDN;
                  paramn.uDN = (paramInt1 + 1);
                  ((r.c)localObject5).position = (paramInt1 + 1);
                }
              }
            }
          }
          else if ((paramString.type == 3) && (paramString.GMa != null))
          {
            paramn.uoD = paramString.GMe;
            paramn.uDS = paramString.GMf;
            localObject3 = paramString.GMa.iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = r.b.a((avc)((Iterator)localObject3).next());
              ((r.b)localObject4).dmf = ((String)localObject1);
              ((r.b)localObject4).uEn.appId = ((r.b)localObject4).appId;
              ((r.b)localObject4).uEn.uEj = ((r.b)localObject4).uEj;
              ((r.b)localObject4).uEn.uEk = ((r.b)localObject4).uEk;
              ((r.b)localObject4).uEn.uEp = "2";
              localObject5 = ((r.b)localObject4).uEn;
              paramInt1 = paramn.uDP;
              paramn.uDP = (paramInt1 + 1);
              ((r.c)localObject5).position = (paramInt1 + 301);
              paramn.gqc.add(localObject4);
            }
          }
          if ((!bu.isNullOrNil(paramString.GMb)) && (!bu.isNullOrNil(paramString.GMc)) && (paramString.type == 1))
          {
            localObject3 = paramString.GMb;
            paramString = paramString.GMc;
            localObject4 = new r.b();
            ((r.b)localObject4).type = 5;
            ((r.b)localObject4).name = ((String)localObject3);
            ((r.b)localObject4).uEn = new r.c(paramString);
            ((r.b)localObject4).uEn.appId = "wx62d9035fd4fd2059";
            ((r.b)localObject4).uEn.uEp = "1";
            ((r.b)localObject4).uEn.position = 300;
            paramn.gqc.add(localObject4);
          }
        }
        paramString = paramn.gqc.iterator();
        while (paramString.hasNext())
        {
          localObject1 = (r.b)paramString.next();
          if (paramn.dmj) {
            ((r.b)localObject1).uEn.dGL = 1403;
          } else if (paramn.uDM) {
            ((r.b)localObject1).uEn.dGL = 1404;
          } else {
            ((r.b)localObject1).uEn.dGL = 1405;
          }
        }
        paramn.notifyDataSetChanged();
      }
      label1767:
      tK(2);
      AppMethodBeat.o(42400);
      return;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(42400);
        return;
      }
      paramString = ((al)paramn).dmf;
      Object localObject1 = ((auw)((al)paramn).gux.hQE.hQJ).Title;
      paramn = ((auw)((al)paramn).gux.hQE.hQJ).GLU;
      this.uEC.b(paramString, (String)localObject1, paramn);
      tK(5);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameSearchUI
 * JD-Core Version:    0.7.0.1
 */