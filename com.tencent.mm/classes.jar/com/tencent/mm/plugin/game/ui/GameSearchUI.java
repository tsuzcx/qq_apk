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
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.game.report.g;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.plugin.game.model.ak;
import com.tencent.mm.plugin.game.model.al;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.protocal.protobuf.bnf;
import com.tencent.mm.protocal.protobuf.bnh;
import com.tencent.mm.protocal.protobuf.bnj;
import com.tencent.mm.protocal.protobuf.bnk;
import com.tencent.mm.protocal.protobuf.bnl;
import com.tencent.mm.protocal.protobuf.bnm;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.t.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Pattern;

public class GameSearchUI
  extends MMActivity
  implements i, t.b
{
  private static final Pattern DaE;
  private ViewGroup DaF;
  private ListView DaG;
  private ListView DaH;
  private r DaI;
  private s DaJ;
  private String DaK;
  private String DaL;
  private LinkedList<String> DaM;
  private String DaN;
  private LinkedList<q> DaO;
  private boolean DaP;
  private AdapterView.OnItemClickListener DaQ;
  private AdapterView.OnItemClickListener DaR;
  private int fromScene;
  private com.tencent.mm.ui.tools.t jjS;
  private View jkB;
  private ProgressBar progressBar;
  private TextView xND;
  
  static
  {
    AppMethodBeat.i(42410);
    DaE = Pattern.compile("\\s+");
    AppMethodBeat.o(42410);
  }
  
  public GameSearchUI()
  {
    AppMethodBeat.i(42392);
    this.DaO = new LinkedList();
    this.DaP = false;
    this.DaQ = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(42390);
        b localb = new b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameSearchUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
        paramAnonymousAdapterView = GameSearchUI.b(GameSearchUI.this);
        if ((paramAnonymousInt < 0) || (paramAnonymousInt >= paramAnonymousAdapterView.getCount())) {}
        for (paramAnonymousAdapterView = null; paramAnonymousAdapterView == null; paramAnonymousAdapterView = ((r.b)paramAnonymousAdapterView.getItem(paramAnonymousInt)).Dav)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameSearchUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(42390);
          return;
        }
        if ((paramAnonymousAdapterView.actionType == 1) && (!Util.isNullOrNil(paramAnonymousAdapterView.appId)))
        {
          paramAnonymousView = new Bundle();
          paramAnonymousView.putCharSequence("game_app_id", paramAnonymousAdapterView.appId);
          paramAnonymousView.putInt("game_report_from_scene", paramAnonymousAdapterView.fSl);
          paramAnonymousInt = com.tencent.mm.plugin.game.d.c.b(GameSearchUI.this, paramAnonymousAdapterView.appId, null, paramAnonymousView);
          paramAnonymousView = new HashMap();
          paramAnonymousView.put("function_type", "search");
          paramAnonymousView.put("funtion_value", paramAnonymousAdapterView.Daw);
          paramAnonymousView.put("keyword", GameSearchUI.f(GameSearchUI.this));
          paramAnonymousView = com.tencent.mm.plugin.game.c.a.m(paramAnonymousView);
          g.a(GameSearchUI.this, 14, paramAnonymousAdapterView.fSl, paramAnonymousAdapterView.position, paramAnonymousInt, paramAnonymousAdapterView.appId, GameSearchUI.g(GameSearchUI.this), paramAnonymousView);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameSearchUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(42390);
          return;
          if ((paramAnonymousAdapterView.actionType == 2) && (!Util.isNullOrNil(paramAnonymousAdapterView.h5Url)))
          {
            paramAnonymousInt = com.tencent.mm.plugin.game.d.c.I(GameSearchUI.this, paramAnonymousAdapterView.h5Url, "game_center_detail");
            paramAnonymousView = new HashMap();
            paramAnonymousView.put("function_type", "search");
            paramAnonymousView.put("funtion_value", paramAnonymousAdapterView.Daw);
            paramAnonymousView.put("keyword", GameSearchUI.f(GameSearchUI.this));
            paramAnonymousView = com.tencent.mm.plugin.game.c.a.m(paramAnonymousView);
            g.a(GameSearchUI.this, 14, paramAnonymousAdapterView.fSl, paramAnonymousAdapterView.position, paramAnonymousInt, 0, paramAnonymousAdapterView.appId, GameSearchUI.g(GameSearchUI.this), paramAnonymousAdapterView.Dar, String.valueOf(paramAnonymousAdapterView.Das), null, paramAnonymousView);
          }
        }
      }
    };
    this.DaR = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(42391);
        b localb = new b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameSearchUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
        paramAnonymousAdapterView = ((s)paramAnonymousAdapterView.getAdapter()).TV(paramAnonymousInt);
        if (Util.isNullOrNil(paramAnonymousAdapterView.text))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameSearchUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(42391);
          return;
        }
        if (Util.isNullOrNil(paramAnonymousAdapterView.appId))
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
            Log.e("MicroMsg.GameSearchUI", "unknowed actionType : " + paramAnonymousAdapterView.actionType);
            break;
          case 1: 
            paramAnonymousView = new Bundle();
            paramAnonymousView.putCharSequence("game_app_id", paramAnonymousAdapterView.appId);
            paramAnonymousView.putInt("game_report_from_scene", 1402);
            i = com.tencent.mm.plugin.game.d.c.b(GameSearchUI.this, paramAnonymousAdapterView.appId, null, paramAnonymousView);
            g.a(GameSearchUI.this, 14, 1402, paramAnonymousInt, i, paramAnonymousAdapterView.appId, GameSearchUI.g(GameSearchUI.this), null);
            break;
          case 2: 
            i = com.tencent.mm.plugin.game.d.c.I(GameSearchUI.this.getContext(), paramAnonymousAdapterView.Dax, "game_center_detail");
            g.a(GameSearchUI.this, 14, 1402, paramAnonymousInt, i, paramAnonymousAdapterView.appId, GameSearchUI.g(GameSearchUI.this), null);
          }
        }
      }
    };
    AppMethodBeat.o(42392);
  }
  
  private void Bg(int paramInt)
  {
    AppMethodBeat.i(42397);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(42397);
      return;
      this.DaF.setVisibility(8);
      this.xND.setVisibility(8);
      this.DaG.setVisibility(8);
      this.DaH.setVisibility(8);
      this.progressBar.setVisibility(8);
      AppMethodBeat.o(42397);
      return;
      hideVKB();
      ListView localListView = this.DaG;
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localListView, locala.aFh(), "com/tencent/mm/plugin/game/ui/GameSearchUI", "updateUI", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
      localListView.smoothScrollToPosition(((Integer)locala.sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localListView, "com/tencent/mm/plugin/game/ui/GameSearchUI", "updateUI", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
      this.jjS.clearFocus();
      this.DaF.setVisibility(8);
      this.xND.setVisibility(8);
      this.DaG.setVisibility(8);
      this.DaH.setVisibility(8);
      this.progressBar.setVisibility(0);
      AppMethodBeat.o(42397);
      return;
      localListView = this.DaG;
      locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localListView, locala.aFh(), "com/tencent/mm/plugin/game/ui/GameSearchUI", "updateUI", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
      localListView.smoothScrollToPosition(((Integer)locala.sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localListView, "com/tencent/mm/plugin/game/ui/GameSearchUI", "updateUI", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
      this.DaF.setVisibility(8);
      this.xND.setVisibility(8);
      this.DaG.setVisibility(8);
      this.DaH.setVisibility(8);
      this.progressBar.setVisibility(0);
      AppMethodBeat.o(42397);
      return;
      this.DaF.setVisibility(8);
      if (this.DaI.getCount() > 0)
      {
        this.xND.setVisibility(8);
        this.DaG.setVisibility(0);
      }
      for (;;)
      {
        this.DaH.setVisibility(8);
        this.progressBar.setVisibility(8);
        AppMethodBeat.o(42397);
        return;
        this.xND.setVisibility(0);
        this.DaG.setVisibility(8);
      }
      this.DaF.setVisibility(0);
      this.xND.setVisibility(8);
      this.DaG.setVisibility(8);
      this.DaH.setVisibility(8);
      this.progressBar.setVisibility(8);
      AppMethodBeat.o(42397);
      return;
      this.DaF.setVisibility(8);
      this.xND.setVisibility(0);
      this.DaG.setVisibility(8);
      this.DaH.setVisibility(8);
      this.progressBar.setVisibility(8);
      AppMethodBeat.o(42397);
      return;
      this.DaF.setVisibility(8);
      this.xND.setVisibility(8);
      this.DaG.setVisibility(8);
      this.DaH.setVisibility(0);
      this.progressBar.setVisibility(8);
    }
  }
  
  private void a(LinkedList<String> paramLinkedList, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(42399);
    while (!this.DaO.isEmpty())
    {
      h.aHH();
      h.aHF().kcd.a((q)this.DaO.pop());
    }
    if (paramBoolean) {
      this.DaI.reset();
    }
    this.DaM = paramLinkedList;
    ak localak = new ak(LocaleUtil.getApplicationLanguage(), paramLinkedList, e.exY(), this.DaI.CKZ);
    h.aGY().a(localak, 0);
    this.DaO.add(localak);
    paramLinkedList = paramLinkedList.iterator();
    for (this.DaK = ""; paramLinkedList.hasNext(); this.DaK = (this.DaK + " " + (String)paramLinkedList.next())) {}
    this.DaK = this.DaK.trim();
    if ((paramInt == 1) || (paramInt == 2))
    {
      this.DaP = true;
      this.jjS.setSearchContent(this.DaK);
    }
    AppMethodBeat.o(42399);
  }
  
  private void bp(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(42398);
    a(paramLinkedList, 0, true);
    AppMethodBeat.o(42398);
  }
  
  public final boolean aat(String paramString)
  {
    AppMethodBeat.i(42406);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(42406);
      return true;
    }
    LinkedList localLinkedList = new LinkedList();
    paramString = DaE.split(paramString.replace('*', ' '));
    int i = 0;
    while (i < paramString.length)
    {
      localLinkedList.add(paramString[i]);
      i += 1;
    }
    bp(localLinkedList);
    Bg(1);
    AppMethodBeat.o(42406);
    return true;
  }
  
  public final void aau(String paramString)
  {
    AppMethodBeat.i(42405);
    if (this.DaP)
    {
      this.DaP = false;
      AppMethodBeat.o(42405);
      return;
    }
    if ((this.DaN != null) && (this.DaN.equals(Util.nullAsNil(paramString))))
    {
      Log.d("MicroMsg.GameSearchUI", "repeat searchChange");
      AppMethodBeat.o(42405);
      return;
    }
    this.DaN = paramString;
    if (Util.isNullOrNil(paramString))
    {
      while (!this.DaO.isEmpty())
      {
        h.aHH();
        h.aHF().kcd.a((q)this.DaO.pop());
      }
      paramString = new al(LocaleUtil.getApplicationLanguage(), paramString, e.exY());
      h.aGY().a(paramString, 0);
      this.DaO.add(paramString);
      AppMethodBeat.o(42405);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    paramString = DaE.split(paramString.replace('*', ' '));
    int i = 0;
    while (i < paramString.length)
    {
      localLinkedList.add(paramString[i]);
      i += 1;
    }
    bp(localLinkedList);
    Bg(6);
    AppMethodBeat.o(42405);
  }
  
  public final void bxH()
  {
    AppMethodBeat.i(42404);
    hideVKB();
    onBackPressed();
    AppMethodBeat.o(42404);
  }
  
  public final void bxI() {}
  
  public final void bxJ() {}
  
  public final void bxK() {}
  
  public int getLayoutId()
  {
    return g.f.Coa;
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
    this.jjS = new com.tencent.mm.ui.tools.t();
    this.jjS.He(true);
    this.jjS.XUl = this;
    this.DaF = ((ViewGroup)findViewById(g.e.eat));
    this.progressBar = ((ProgressBar)findViewById(g.e.ukq));
    this.xND = ((TextView)findViewById(g.e.no_result));
    this.DaG = ((ListView)findViewById(g.e.ukr));
    this.DaI = new r(this);
    this.DaG.setAdapter(this.DaI);
    this.DaG.setOnItemClickListener(this.DaQ);
    this.DaG.setOnTouchListener(new View.OnTouchListener()
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
    this.DaG.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(42388);
        if ((paramAnonymousInt == 0) && (paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1) && (GameSearchUI.b(GameSearchUI.this).Dab))
        {
          if (GameSearchUI.c(GameSearchUI.this) != null) {
            GameSearchUI.c(GameSearchUI.this).setVisibility(0);
          }
          GameSearchUI.a(GameSearchUI.this, GameSearchUI.d(GameSearchUI.this));
        }
        AppMethodBeat.o(42388);
      }
    });
    this.jkB = getLayoutInflater().inflate(g.f.CnH, this.DaG, false);
    this.jkB.setVisibility(8);
    this.DaG.addFooterView(this.jkB);
    this.DaH = ((ListView)findViewById(g.e.Clw));
    this.DaJ = new s(this);
    this.DaH.setAdapter(this.DaJ);
    this.DaH.setOnItemClickListener(this.DaR);
    this.DaH.setOnTouchListener(new View.OnTouchListener()
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
    if (!h.aHB())
    {
      Log.e("MicroMsg.GameSearchUI", "account not ready");
      finish();
      AppMethodBeat.o(42393);
      return;
    }
    h.aGY().a(1328, this);
    h.aGY().a(1329, this);
    this.fromScene = getIntent().getIntExtra("game_report_from_scene", 0);
    initView();
    g.a(this, 14, 1401, 0, 2, this.fromScene, null);
    Log.i("MicroMsg.GameSearchUI", "[onCreate] time:" + (System.currentTimeMillis() - l));
    AppMethodBeat.o(42393);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(42395);
    this.jjS.a(this, paramMenu);
    this.jjS.setHint(e.eym());
    AppMethodBeat.o(42395);
    return true;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(42403);
    Log.i("MicroMsg.GameSearchUI", "onDestroy");
    super.onDestroy();
    h.aGY().b(1328, this);
    h.aGY().b(1329, this);
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
    this.jjS.a(this, paramMenu);
    AppMethodBeat.o(42396);
    return true;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(42400);
    if (paramq.isCanceled())
    {
      AppMethodBeat.o(42400);
      return;
    }
    if (this.DaO.contains(paramq)) {
      this.DaO.remove(paramq);
    }
    this.jkB.setVisibility(8);
    switch (paramq.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(42400);
      return;
      paramString = (bnj)d.b.b(((ak)paramq).jTk.lBR);
      Log.d("MicroMsg.GameSearchUI", "keywords = %s, offset = %d", new Object[] { paramString.SYu, Integer.valueOf(paramString.SYv) });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (bnk)d.c.b(((ak)paramq).jTk.lBS);
        label212:
        Object localObject3;
        label282:
        Object localObject4;
        if (paramString != null)
        {
          paramString = paramString.SYw;
          if (Util.isNullOrNil(paramString)) {
            break label1767;
          }
          this.DaL = this.DaK;
          if (this.DaI.CKZ != 0)
          {
            paramq = this.DaI;
            localObject1 = this.DaL;
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
            localObject2 = (bnl)paramString.next();
            if ((((bnl)localObject2).type == 3) && (!Util.isNullOrNil(((bnl)localObject2).SYy)))
            {
              paramq.CKZ = ((bnl)localObject2).SYC;
              paramq.Dab = ((bnl)localObject2).SYD;
              localObject2 = ((bnl)localObject2).SYy.iterator();
              if (((Iterator)localObject2).hasNext())
              {
                localObject3 = r.b.a((bnn)((Iterator)localObject2).next());
                ((r.b)localObject3).fwe = ((String)localObject1);
                ((r.b)localObject3).Dav.appId = ((r.b)localObject3).appId;
                ((r.b)localObject3).Dav.Dar = ((r.b)localObject3).Dar;
                ((r.b)localObject3).Dav.Das = ((r.b)localObject3).Das;
                ((r.b)localObject3).Dav.Daw = "2";
                localObject4 = ((r.b)localObject3).Dav;
                paramInt1 = paramq.CZY;
                paramq.CZY = (paramInt1 + 1);
                ((r.c)localObject4).position = (paramInt1 + 301);
                localObject4 = ((r.b)localObject3).Dav;
                if (!paramq.fwi) {
                  break label439;
                }
              }
              label439:
              for (paramInt1 = 1403;; paramInt1 = 1405)
              {
                ((r.c)localObject4).fSl = paramInt1;
                paramq.jFL.add(localObject3);
                break label282;
                break label212;
                paramString = null;
                break;
              }
            }
            paramq.Dab = false;
          }
        }
        paramq = this.DaI;
        localObject1 = this.DaL;
        if (paramq.jFL == null) {
          paramq.jFL = new ArrayList();
        }
        paramq.CXD = 0;
        paramq.CZW = 0;
        paramq.CZX = 0;
        paramq.CZY = 0;
        paramq.CZZ = 0;
        paramq.fwi = false;
        paramq.CZV = false;
        paramq.Dab = false;
        paramq.CKZ = 0;
        paramq.jFL.clear();
        paramq.Dac = false;
        Object localObject2 = paramString.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          paramString = (bnl)((Iterator)localObject2).next();
          label601:
          label620:
          int i;
          if ((paramString.SYx == null) || (paramString.SYx.size() == 0))
          {
            paramInt1 = 1;
            if ((paramString.SYy != null) && (paramString.SYy.size() != 0)) {
              break label725;
            }
            paramInt2 = 1;
            if ((paramString.SYB != null) && (paramString.SYB.size() != 0)) {
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
            if (Util.isNullOrNil((String)localObject1)) {
              break label741;
            }
          }
          label725:
          label730:
          label736:
          label741:
          for (paramString = paramq.context.getString(g.i.CpI, new Object[] { localObject1 });; paramString = paramq.context.getString(g.i.CpH))
          {
            paramq.jFL.add(r.b.bx(6, paramString));
            paramq.Dac = true;
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
          paramq.jFL.add(r.b.bx(0, paramString.fwr));
          if (!paramq.Dac)
          {
            ((r.b)paramq.jFL.get(paramq.jFL.size() - 1)).Dat = true;
            paramq.Dac = true;
          }
          Object localObject5;
          if ((paramString.type == 4) && (paramString.SYB != null))
          {
            localObject3 = paramString.SYB.iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject5 = (bnm)((Iterator)localObject3).next();
              localObject4 = new r.b();
              ((r.b)localObject4).type = 3;
              ((r.b)localObject4).appId = ((bnm)localObject5).SYE.lVG;
              ((r.b)localObject4).name = ((bnm)localObject5).SYE.CMP;
              ((r.b)localObject4).remark = ((bnm)localObject5).SYE.Sqe;
              ((r.b)localObject4).iconUrl = ((bnm)localObject5).SYE.CNj;
              ((r.b)localObject4).Dan = ((bnm)localObject5).SYE.CMQ;
              ((r.b)localObject4).Dao = ((bnm)localObject5).SYE.SYl;
              ((r.b)localObject4).actionType = ((bnm)localObject5).SYE.RXp;
              ((r.b)localObject4).Dap = ((bnm)localObject5).SYE.SYm;
              ((r.b)localObject4).Daq = ((bnm)localObject5).SYF;
              ((r.b)localObject4).Dav = new r.c(((bnm)localObject5).SYE.RXp, 4, ((bnm)localObject5).SYE.lVG, ((bnm)localObject5).SYE.SYm);
              ((r.b)localObject4).fwe = ((String)localObject1);
              ((r.b)localObject4).Dav.Daw = "3";
              localObject5 = ((r.b)localObject4).Dav;
              paramInt1 = paramq.CZX;
              paramq.CZX = (paramInt1 + 1);
              ((r.c)localObject5).position = (paramInt1 + 601);
              paramq.jFL.add(localObject4);
            }
          }
          if (((paramString.type == 1) || (paramString.type == 2)) && (paramString.SYx != null))
          {
            localObject3 = paramString.SYx.iterator();
            if (((Iterator)localObject3).hasNext())
            {
              localObject5 = (bnf)((Iterator)localObject3).next();
              localObject4 = new r.b();
              ((r.b)localObject4).type = 1;
              ((r.b)localObject4).appId = ((bnf)localObject5).lVG;
              ((r.b)localObject4).name = ((bnf)localObject5).CMP;
              ((r.b)localObject4).remark = ((bnf)localObject5).Sqe;
              ((r.b)localObject4).iconUrl = ((bnf)localObject5).CNj;
              ((r.b)localObject4).Dan = ((bnf)localObject5).CMQ;
              ((r.b)localObject4).Dao = ((bnf)localObject5).SYl;
              ((r.b)localObject4).actionType = ((bnf)localObject5).RXp;
              ((r.b)localObject4).Dap = ((bnf)localObject5).SYm;
              ((r.b)localObject4).Dav = new r.c(((bnf)localObject5).RXp, 1, ((bnf)localObject5).lVG, ((bnf)localObject5).SYm);
              ((r.b)localObject4).fwe = ((String)localObject1);
              if (paramString.type == 1)
              {
                paramq.fwi = true;
                localObject5 = ((r.b)localObject4).Dav;
                paramInt1 = paramq.CXD;
                paramq.CXD = (paramInt1 + 1);
                ((r.c)localObject5).position = (paramInt1 + 1);
              }
              for (;;)
              {
                ((r.b)localObject4).Dav.Daw = "1";
                paramq.jFL.add(localObject4);
                break;
                if (paramString.type == 2)
                {
                  paramq.CZV = true;
                  localObject5 = ((r.b)localObject4).Dav;
                  paramInt1 = paramq.CZW;
                  paramq.CZW = (paramInt1 + 1);
                  ((r.c)localObject5).position = (paramInt1 + 1);
                }
              }
            }
          }
          else if ((paramString.type == 3) && (paramString.SYy != null))
          {
            paramq.CKZ = paramString.SYC;
            paramq.Dab = paramString.SYD;
            localObject3 = paramString.SYy.iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = r.b.a((bnn)((Iterator)localObject3).next());
              ((r.b)localObject4).fwe = ((String)localObject1);
              ((r.b)localObject4).Dav.appId = ((r.b)localObject4).appId;
              ((r.b)localObject4).Dav.Dar = ((r.b)localObject4).Dar;
              ((r.b)localObject4).Dav.Das = ((r.b)localObject4).Das;
              ((r.b)localObject4).Dav.Daw = "2";
              localObject5 = ((r.b)localObject4).Dav;
              paramInt1 = paramq.CZY;
              paramq.CZY = (paramInt1 + 1);
              ((r.c)localObject5).position = (paramInt1 + 301);
              paramq.jFL.add(localObject4);
            }
          }
          if ((!Util.isNullOrNil(paramString.SYz)) && (!Util.isNullOrNil(paramString.SYA)) && (paramString.type == 1))
          {
            localObject3 = paramString.SYz;
            paramString = paramString.SYA;
            localObject4 = new r.b();
            ((r.b)localObject4).type = 5;
            ((r.b)localObject4).name = ((String)localObject3);
            ((r.b)localObject4).Dav = new r.c(paramString);
            ((r.b)localObject4).Dav.appId = "wx62d9035fd4fd2059";
            ((r.b)localObject4).Dav.Daw = "1";
            ((r.b)localObject4).Dav.position = 300;
            paramq.jFL.add(localObject4);
          }
        }
        paramString = paramq.jFL.iterator();
        while (paramString.hasNext())
        {
          localObject1 = (r.b)paramString.next();
          if (paramq.fwi) {
            ((r.b)localObject1).Dav.fSl = 1403;
          } else if (paramq.CZV) {
            ((r.b)localObject1).Dav.fSl = 1404;
          } else {
            ((r.b)localObject1).Dav.fSl = 1405;
          }
        }
        paramq.notifyDataSetChanged();
      }
      label1767:
      Bg(2);
      AppMethodBeat.o(42400);
      return;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(42400);
        return;
      }
      paramString = ((al)paramq).fwe;
      Object localObject1 = ((bnh)d.c.b(((al)paramq).jTk.lBS)).fwr;
      paramq = ((bnh)d.c.b(((al)paramq).jTk.lBS)).SYs;
      this.DaJ.a(paramString, (String)localObject1, paramq);
      Bg(5);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameSearchUI
 * JD-Core Version:    0.7.0.1
 */