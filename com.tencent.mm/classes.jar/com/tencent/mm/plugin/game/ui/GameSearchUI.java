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
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.game.report.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.model.ak;
import com.tencent.mm.plugin.game.model.al;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.protocal.protobuf.bgd;
import com.tencent.mm.protocal.protobuf.bgf;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.protocal.protobuf.bgi;
import com.tencent.mm.protocal.protobuf.bgj;
import com.tencent.mm.protocal.protobuf.bgk;
import com.tencent.mm.protocal.protobuf.bgl;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.s.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Pattern;

public class GameSearchUI
  extends MMActivity
  implements i, s.b
{
  private static final Pattern xWu;
  private int fromScene;
  private View gAy;
  private com.tencent.mm.ui.tools.s gzP;
  private ProgressBar progressBar;
  private TextView vtJ;
  private String xWA;
  private String xWB;
  private LinkedList<String> xWC;
  private String xWD;
  private LinkedList<q> xWE;
  private boolean xWF;
  private AdapterView.OnItemClickListener xWG;
  private AdapterView.OnItemClickListener xWH;
  private ViewGroup xWv;
  private ListView xWw;
  private ListView xWx;
  private r xWy;
  private s xWz;
  
  static
  {
    AppMethodBeat.i(42410);
    xWu = Pattern.compile("\\s+");
    AppMethodBeat.o(42410);
  }
  
  public GameSearchUI()
  {
    AppMethodBeat.i(42392);
    this.xWE = new LinkedList();
    this.xWF = false;
    this.xWG = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(42390);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameSearchUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        paramAnonymousAdapterView = GameSearchUI.b(GameSearchUI.this);
        if ((paramAnonymousInt < 0) || (paramAnonymousInt >= paramAnonymousAdapterView.getCount())) {}
        for (paramAnonymousAdapterView = null; paramAnonymousAdapterView == null; paramAnonymousAdapterView = ((r.b)paramAnonymousAdapterView.getItem(paramAnonymousInt)).xWl)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameSearchUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(42390);
          return;
        }
        if ((paramAnonymousAdapterView.actionType == 1) && (!Util.isNullOrNil(paramAnonymousAdapterView.appId)))
        {
          paramAnonymousView = new Bundle();
          paramAnonymousView.putCharSequence("game_app_id", paramAnonymousAdapterView.appId);
          paramAnonymousView.putInt("game_report_from_scene", paramAnonymousAdapterView.dYu);
          paramAnonymousInt = com.tencent.mm.plugin.game.e.c.b(GameSearchUI.this, paramAnonymousAdapterView.appId, null, paramAnonymousView);
          paramAnonymousView = new HashMap();
          paramAnonymousView.put("function_type", "search");
          paramAnonymousView.put("funtion_value", paramAnonymousAdapterView.xWm);
          paramAnonymousView.put("keyword", GameSearchUI.f(GameSearchUI.this));
          paramAnonymousView = com.tencent.mm.plugin.game.d.a.u(paramAnonymousView);
          f.a(GameSearchUI.this, 14, paramAnonymousAdapterView.dYu, paramAnonymousAdapterView.position, paramAnonymousInt, paramAnonymousAdapterView.appId, GameSearchUI.g(GameSearchUI.this), paramAnonymousView);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameSearchUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(42390);
          return;
          if ((paramAnonymousAdapterView.actionType == 2) && (!Util.isNullOrNil(paramAnonymousAdapterView.h5Url)))
          {
            paramAnonymousInt = com.tencent.mm.plugin.game.e.c.D(GameSearchUI.this, paramAnonymousAdapterView.h5Url, "game_center_detail");
            paramAnonymousView = new HashMap();
            paramAnonymousView.put("function_type", "search");
            paramAnonymousView.put("funtion_value", paramAnonymousAdapterView.xWm);
            paramAnonymousView.put("keyword", GameSearchUI.f(GameSearchUI.this));
            paramAnonymousView = com.tencent.mm.plugin.game.d.a.u(paramAnonymousView);
            f.a(GameSearchUI.this, 14, paramAnonymousAdapterView.dYu, paramAnonymousAdapterView.position, paramAnonymousInt, 0, paramAnonymousAdapterView.appId, GameSearchUI.g(GameSearchUI.this), paramAnonymousAdapterView.xWh, String.valueOf(paramAnonymousAdapterView.xWi), null, paramAnonymousView);
          }
        }
      }
    };
    this.xWH = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(42391);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameSearchUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        paramAnonymousAdapterView = ((s)paramAnonymousAdapterView.getAdapter()).OB(paramAnonymousInt);
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
            i = com.tencent.mm.plugin.game.e.c.b(GameSearchUI.this, paramAnonymousAdapterView.appId, null, paramAnonymousView);
            f.a(GameSearchUI.this, 14, 1402, paramAnonymousInt, i, paramAnonymousAdapterView.appId, GameSearchUI.g(GameSearchUI.this), null);
            break;
          case 2: 
            i = com.tencent.mm.plugin.game.e.c.D(GameSearchUI.this.getContext(), paramAnonymousAdapterView.xWn, "game_center_detail");
            f.a(GameSearchUI.this, 14, 1402, paramAnonymousInt, i, paramAnonymousAdapterView.appId, GameSearchUI.g(GameSearchUI.this), null);
          }
        }
      }
    };
    AppMethodBeat.o(42392);
  }
  
  private void a(LinkedList<String> paramLinkedList, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(42399);
    while (!this.xWE.isEmpty())
    {
      g.aAi();
      g.aAg().hqi.a((q)this.xWE.pop());
    }
    if (paramBoolean) {
      this.xWy.reset();
    }
    this.xWC = paramLinkedList;
    ak localak = new ak(LocaleUtil.getApplicationLanguage(), paramLinkedList, e.dUR(), this.xWy.xGW);
    g.azz().a(localak, 0);
    this.xWE.add(localak);
    paramLinkedList = paramLinkedList.iterator();
    for (this.xWA = ""; paramLinkedList.hasNext(); this.xWA = (this.xWA + " " + (String)paramLinkedList.next())) {}
    this.xWA = this.xWA.trim();
    if ((paramInt == 1) || (paramInt == 2))
    {
      this.xWF = true;
      this.gzP.setSearchContent(this.xWA);
    }
    AppMethodBeat.o(42399);
  }
  
  private void aW(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(42398);
    a(paramLinkedList, 0, true);
    AppMethodBeat.o(42398);
  }
  
  private void xI(int paramInt)
  {
    AppMethodBeat.i(42397);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(42397);
      return;
      this.xWv.setVisibility(8);
      this.vtJ.setVisibility(8);
      this.xWw.setVisibility(8);
      this.xWx.setVisibility(8);
      this.progressBar.setVisibility(8);
      AppMethodBeat.o(42397);
      return;
      hideVKB();
      ListView localListView = this.xWw;
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localListView, locala.axQ(), "com/tencent/mm/plugin/game/ui/GameSearchUI", "updateUI", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
      localListView.smoothScrollToPosition(((Integer)locala.pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localListView, "com/tencent/mm/plugin/game/ui/GameSearchUI", "updateUI", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
      this.gzP.clearFocus();
      this.xWv.setVisibility(8);
      this.vtJ.setVisibility(8);
      this.xWw.setVisibility(8);
      this.xWx.setVisibility(8);
      this.progressBar.setVisibility(0);
      AppMethodBeat.o(42397);
      return;
      localListView = this.xWw;
      locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localListView, locala.axQ(), "com/tencent/mm/plugin/game/ui/GameSearchUI", "updateUI", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
      localListView.smoothScrollToPosition(((Integer)locala.pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localListView, "com/tencent/mm/plugin/game/ui/GameSearchUI", "updateUI", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
      this.xWv.setVisibility(8);
      this.vtJ.setVisibility(8);
      this.xWw.setVisibility(8);
      this.xWx.setVisibility(8);
      this.progressBar.setVisibility(0);
      AppMethodBeat.o(42397);
      return;
      this.xWv.setVisibility(8);
      if (this.xWy.getCount() > 0)
      {
        this.vtJ.setVisibility(8);
        this.xWw.setVisibility(0);
      }
      for (;;)
      {
        this.xWx.setVisibility(8);
        this.progressBar.setVisibility(8);
        AppMethodBeat.o(42397);
        return;
        this.vtJ.setVisibility(0);
        this.xWw.setVisibility(8);
      }
      this.xWv.setVisibility(0);
      this.vtJ.setVisibility(8);
      this.xWw.setVisibility(8);
      this.xWx.setVisibility(8);
      this.progressBar.setVisibility(8);
      AppMethodBeat.o(42397);
      return;
      this.xWv.setVisibility(8);
      this.vtJ.setVisibility(0);
      this.xWw.setVisibility(8);
      this.xWx.setVisibility(8);
      this.progressBar.setVisibility(8);
      AppMethodBeat.o(42397);
      return;
      this.xWv.setVisibility(8);
      this.vtJ.setVisibility(8);
      this.xWw.setVisibility(8);
      this.xWx.setVisibility(0);
      this.progressBar.setVisibility(8);
    }
  }
  
  public final boolean SN(String paramString)
  {
    AppMethodBeat.i(42406);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(42406);
      return true;
    }
    LinkedList localLinkedList = new LinkedList();
    paramString = xWu.split(paramString.replace('*', ' '));
    int i = 0;
    while (i < paramString.length)
    {
      localLinkedList.add(paramString[i]);
      i += 1;
    }
    aW(localLinkedList);
    xI(1);
    AppMethodBeat.o(42406);
    return true;
  }
  
  public final void SO(String paramString)
  {
    AppMethodBeat.i(42405);
    if (this.xWF)
    {
      this.xWF = false;
      AppMethodBeat.o(42405);
      return;
    }
    if ((this.xWD != null) && (this.xWD.equals(Util.nullAsNil(paramString))))
    {
      Log.d("MicroMsg.GameSearchUI", "repeat searchChange");
      AppMethodBeat.o(42405);
      return;
    }
    this.xWD = paramString;
    if (Util.isNullOrNil(paramString))
    {
      while (!this.xWE.isEmpty())
      {
        g.aAi();
        g.aAg().hqi.a((q)this.xWE.pop());
      }
      paramString = new al(LocaleUtil.getApplicationLanguage(), paramString, e.dUR());
      g.azz().a(paramString, 0);
      this.xWE.add(paramString);
      AppMethodBeat.o(42405);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    paramString = xWu.split(paramString.replace('*', ' '));
    int i = 0;
    while (i < paramString.length)
    {
      localLinkedList.add(paramString[i]);
      i += 1;
    }
    aW(localLinkedList);
    xI(6);
    AppMethodBeat.o(42405);
  }
  
  public final void bnA() {}
  
  public final void bnB() {}
  
  public final void bny()
  {
    AppMethodBeat.i(42404);
    hideVKB();
    onBackPressed();
    AppMethodBeat.o(42404);
  }
  
  public final void bnz() {}
  
  public int getLayoutId()
  {
    return 2131494944;
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
    this.gzP = new com.tencent.mm.ui.tools.s();
    this.gzP.CK(true);
    this.gzP.Qwi = this;
    this.xWv = ((ViewGroup)findViewById(2131310010));
    this.progressBar = ((ProgressBar)findViewById(2131307415));
    this.vtJ = ((TextView)findViewById(2131305459));
    this.xWw = ((ListView)findViewById(2131307418));
    this.xWy = new r(this);
    this.xWw.setAdapter(this.xWy);
    this.xWw.setOnItemClickListener(this.xWG);
    this.xWw.setOnTouchListener(new View.OnTouchListener()
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
    this.xWw.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(42388);
        if ((paramAnonymousInt == 0) && (paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1) && (GameSearchUI.b(GameSearchUI.this).xVQ))
        {
          if (GameSearchUI.c(GameSearchUI.this) != null) {
            GameSearchUI.c(GameSearchUI.this).setVisibility(0);
          }
          GameSearchUI.a(GameSearchUI.this, GameSearchUI.d(GameSearchUI.this));
        }
        AppMethodBeat.o(42388);
      }
    });
    this.gAy = getLayoutInflater().inflate(2131494902, this.xWw, false);
    this.gAy.setVisibility(8);
    this.xWw.addFooterView(this.gAy);
    this.xWx = ((ListView)findViewById(2131307416));
    this.xWz = new s(this);
    this.xWx.setAdapter(this.xWz);
    this.xWx.setOnItemClickListener(this.xWH);
    this.xWx.setOnTouchListener(new View.OnTouchListener()
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
    if (!g.aAc())
    {
      Log.e("MicroMsg.GameSearchUI", "account not ready");
      finish();
      AppMethodBeat.o(42393);
      return;
    }
    g.azz().a(1328, this);
    g.azz().a(1329, this);
    this.fromScene = getIntent().getIntExtra("game_report_from_scene", 0);
    initView();
    f.a(this, 14, 1401, 0, 2, this.fromScene, null);
    Log.i("MicroMsg.GameSearchUI", "[onCreate] time:" + (System.currentTimeMillis() - l));
    AppMethodBeat.o(42393);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(42395);
    this.gzP.a(this, paramMenu);
    this.gzP.setHint(e.dVf());
    AppMethodBeat.o(42395);
    return true;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(42403);
    Log.i("MicroMsg.GameSearchUI", "onDestroy");
    super.onDestroy();
    g.azz().b(1328, this);
    g.azz().b(1329, this);
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
    this.gzP.a(this, paramMenu);
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
    if (this.xWE.contains(paramq)) {
      this.xWE.remove(paramq);
    }
    this.gAy.setVisibility(8);
    switch (paramq.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(42400);
      return;
      paramString = (bgh)((ak)paramq).hhm.iLK.iLR;
      Log.d("MicroMsg.GameSearchUI", "keywords = %s, offset = %d", new Object[] { paramString.LQa, Integer.valueOf(paramString.LQb) });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (bgi)((ak)paramq).hhm.iLL.iLR;
        label212:
        Object localObject3;
        label282:
        Object localObject4;
        if (paramString != null)
        {
          paramString = paramString.LQc;
          if (Util.isNullOrNil(paramString)) {
            break label1767;
          }
          this.xWB = this.xWA;
          if (this.xWy.xGW != 0)
          {
            paramq = this.xWy;
            localObject1 = this.xWB;
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
            localObject2 = (bgj)paramString.next();
            if ((((bgj)localObject2).type == 3) && (!Util.isNullOrNil(((bgj)localObject2).LQe)))
            {
              paramq.xGW = ((bgj)localObject2).LQi;
              paramq.xVQ = ((bgj)localObject2).LQj;
              localObject2 = ((bgj)localObject2).LQe.iterator();
              if (((Iterator)localObject2).hasNext())
              {
                localObject3 = r.b.a((bgl)((Iterator)localObject2).next());
                ((r.b)localObject3).dDv = ((String)localObject1);
                ((r.b)localObject3).xWl.appId = ((r.b)localObject3).appId;
                ((r.b)localObject3).xWl.xWh = ((r.b)localObject3).xWh;
                ((r.b)localObject3).xWl.xWi = ((r.b)localObject3).xWi;
                ((r.b)localObject3).xWl.xWm = "2";
                localObject4 = ((r.b)localObject3).xWl;
                paramInt1 = paramq.xVN;
                paramq.xVN = (paramInt1 + 1);
                ((r.c)localObject4).position = (paramInt1 + 301);
                localObject4 = ((r.b)localObject3).xWl;
                if (!paramq.dDz) {
                  break label439;
                }
              }
              label439:
              for (paramInt1 = 1403;; paramInt1 = 1405)
              {
                ((r.c)localObject4).dYu = paramInt1;
                paramq.gUV.add(localObject3);
                break label282;
                break label212;
                paramString = null;
                break;
              }
            }
            paramq.xVQ = false;
          }
        }
        paramq = this.xWy;
        localObject1 = this.xWB;
        if (paramq.gUV == null) {
          paramq.gUV = new ArrayList();
        }
        paramq.xTs = 0;
        paramq.xVL = 0;
        paramq.xVM = 0;
        paramq.xVN = 0;
        paramq.xVO = 0;
        paramq.dDz = false;
        paramq.xVK = false;
        paramq.xVQ = false;
        paramq.xGW = 0;
        paramq.gUV.clear();
        paramq.xVR = false;
        Object localObject2 = paramString.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          paramString = (bgj)((Iterator)localObject2).next();
          label601:
          label620:
          int i;
          if ((paramString.LQd == null) || (paramString.LQd.size() == 0))
          {
            paramInt1 = 1;
            if ((paramString.LQe != null) && (paramString.LQe.size() != 0)) {
              break label725;
            }
            paramInt2 = 1;
            if ((paramString.LQh != null) && (paramString.LQh.size() != 0)) {
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
          for (paramString = paramq.context.getString(2131761337, new Object[] { localObject1 });; paramString = paramq.context.getString(2131761336))
          {
            paramq.gUV.add(r.b.bA(6, paramString));
            paramq.xVR = true;
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
          paramq.gUV.add(r.b.bA(0, paramString.Title));
          if (!paramq.xVR)
          {
            ((r.b)paramq.gUV.get(paramq.gUV.size() - 1)).xWj = true;
            paramq.xVR = true;
          }
          Object localObject5;
          if ((paramString.type == 4) && (paramString.LQh != null))
          {
            localObject3 = paramString.LQh.iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject5 = (bgk)((Iterator)localObject3).next();
              localObject4 = new r.b();
              ((r.b)localObject4).type = 3;
              ((r.b)localObject4).appId = ((bgk)localObject5).LQk.jfi;
              ((r.b)localObject4).name = ((bgk)localObject5).LQk.Name;
              ((r.b)localObject4).remark = ((bgk)localObject5).LQk.LoI;
              ((r.b)localObject4).iconUrl = ((bgk)localObject5).LQk.IconUrl;
              ((r.b)localObject4).xWd = ((bgk)localObject5).LQk.xIK;
              ((r.b)localObject4).xWe = ((bgk)localObject5).LQk.LPR;
              ((r.b)localObject4).actionType = ((bgk)localObject5).LQk.KWb;
              ((r.b)localObject4).xWf = ((bgk)localObject5).LQk.LPS;
              ((r.b)localObject4).xWg = ((bgk)localObject5).LQl;
              ((r.b)localObject4).xWl = new r.c(((bgk)localObject5).LQk.KWb, 4, ((bgk)localObject5).LQk.jfi, ((bgk)localObject5).LQk.LPS);
              ((r.b)localObject4).dDv = ((String)localObject1);
              ((r.b)localObject4).xWl.xWm = "3";
              localObject5 = ((r.b)localObject4).xWl;
              paramInt1 = paramq.xVM;
              paramq.xVM = (paramInt1 + 1);
              ((r.c)localObject5).position = (paramInt1 + 601);
              paramq.gUV.add(localObject4);
            }
          }
          if (((paramString.type == 1) || (paramString.type == 2)) && (paramString.LQd != null))
          {
            localObject3 = paramString.LQd.iterator();
            if (((Iterator)localObject3).hasNext())
            {
              localObject5 = (bgd)((Iterator)localObject3).next();
              localObject4 = new r.b();
              ((r.b)localObject4).type = 1;
              ((r.b)localObject4).appId = ((bgd)localObject5).jfi;
              ((r.b)localObject4).name = ((bgd)localObject5).Name;
              ((r.b)localObject4).remark = ((bgd)localObject5).LoI;
              ((r.b)localObject4).iconUrl = ((bgd)localObject5).IconUrl;
              ((r.b)localObject4).xWd = ((bgd)localObject5).xIK;
              ((r.b)localObject4).xWe = ((bgd)localObject5).LPR;
              ((r.b)localObject4).actionType = ((bgd)localObject5).KWb;
              ((r.b)localObject4).xWf = ((bgd)localObject5).LPS;
              ((r.b)localObject4).xWl = new r.c(((bgd)localObject5).KWb, 1, ((bgd)localObject5).jfi, ((bgd)localObject5).LPS);
              ((r.b)localObject4).dDv = ((String)localObject1);
              if (paramString.type == 1)
              {
                paramq.dDz = true;
                localObject5 = ((r.b)localObject4).xWl;
                paramInt1 = paramq.xTs;
                paramq.xTs = (paramInt1 + 1);
                ((r.c)localObject5).position = (paramInt1 + 1);
              }
              for (;;)
              {
                ((r.b)localObject4).xWl.xWm = "1";
                paramq.gUV.add(localObject4);
                break;
                if (paramString.type == 2)
                {
                  paramq.xVK = true;
                  localObject5 = ((r.b)localObject4).xWl;
                  paramInt1 = paramq.xVL;
                  paramq.xVL = (paramInt1 + 1);
                  ((r.c)localObject5).position = (paramInt1 + 1);
                }
              }
            }
          }
          else if ((paramString.type == 3) && (paramString.LQe != null))
          {
            paramq.xGW = paramString.LQi;
            paramq.xVQ = paramString.LQj;
            localObject3 = paramString.LQe.iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = r.b.a((bgl)((Iterator)localObject3).next());
              ((r.b)localObject4).dDv = ((String)localObject1);
              ((r.b)localObject4).xWl.appId = ((r.b)localObject4).appId;
              ((r.b)localObject4).xWl.xWh = ((r.b)localObject4).xWh;
              ((r.b)localObject4).xWl.xWi = ((r.b)localObject4).xWi;
              ((r.b)localObject4).xWl.xWm = "2";
              localObject5 = ((r.b)localObject4).xWl;
              paramInt1 = paramq.xVN;
              paramq.xVN = (paramInt1 + 1);
              ((r.c)localObject5).position = (paramInt1 + 301);
              paramq.gUV.add(localObject4);
            }
          }
          if ((!Util.isNullOrNil(paramString.LQf)) && (!Util.isNullOrNil(paramString.LQg)) && (paramString.type == 1))
          {
            localObject3 = paramString.LQf;
            paramString = paramString.LQg;
            localObject4 = new r.b();
            ((r.b)localObject4).type = 5;
            ((r.b)localObject4).name = ((String)localObject3);
            ((r.b)localObject4).xWl = new r.c(paramString);
            ((r.b)localObject4).xWl.appId = "wx62d9035fd4fd2059";
            ((r.b)localObject4).xWl.xWm = "1";
            ((r.b)localObject4).xWl.position = 300;
            paramq.gUV.add(localObject4);
          }
        }
        paramString = paramq.gUV.iterator();
        while (paramString.hasNext())
        {
          localObject1 = (r.b)paramString.next();
          if (paramq.dDz) {
            ((r.b)localObject1).xWl.dYu = 1403;
          } else if (paramq.xVK) {
            ((r.b)localObject1).xWl.dYu = 1404;
          } else {
            ((r.b)localObject1).xWl.dYu = 1405;
          }
        }
        paramq.notifyDataSetChanged();
      }
      label1767:
      xI(2);
      AppMethodBeat.o(42400);
      return;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(42400);
        return;
      }
      paramString = ((al)paramq).dDv;
      Object localObject1 = ((bgf)((al)paramq).hhm.iLL.iLR).Title;
      paramq = ((bgf)((al)paramq).hhm.iLL.iLR).LPY;
      this.xWz.b(paramString, (String)localObject1, paramq);
      xI(5);
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