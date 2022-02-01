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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.model.ak;
import com.tencent.mm.plugin.game.model.al;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.protocal.protobuf.aue;
import com.tencent.mm.protocal.protobuf.aug;
import com.tencent.mm.protocal.protobuf.aui;
import com.tencent.mm.protocal.protobuf.auj;
import com.tencent.mm.protocal.protobuf.auk;
import com.tencent.mm.protocal.protobuf.aul;
import com.tencent.mm.protocal.protobuf.aum;
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
  implements com.tencent.mm.al.f, com.tencent.mm.ui.tools.r.b
{
  private static final Pattern ute;
  private com.tencent.mm.ui.tools.r fSC;
  private View fTl;
  private int fromScene;
  private ProgressBar progressBar;
  private TextView ssK;
  private ViewGroup utf;
  private ListView utg;
  private ListView uth;
  private r uti;
  private s utj;
  private String utk;
  private String utl;
  private LinkedList<String> utm;
  private String utn;
  private LinkedList<n> uto;
  private boolean utp;
  private AdapterView.OnItemClickListener utq;
  private AdapterView.OnItemClickListener utr;
  
  static
  {
    AppMethodBeat.i(42410);
    ute = Pattern.compile("\\s+");
    AppMethodBeat.o(42410);
  }
  
  public GameSearchUI()
  {
    AppMethodBeat.i(42392);
    this.uto = new LinkedList();
    this.utp = false;
    this.utq = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(42390);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameSearchUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        paramAnonymousAdapterView = GameSearchUI.b(GameSearchUI.this);
        if ((paramAnonymousInt < 0) || (paramAnonymousInt >= paramAnonymousAdapterView.getCount())) {}
        for (paramAnonymousAdapterView = null; paramAnonymousAdapterView == null; paramAnonymousAdapterView = ((r.b)paramAnonymousAdapterView.getItem(paramAnonymousInt)).usU)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameSearchUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(42390);
          return;
        }
        if ((paramAnonymousAdapterView.actionType == 1) && (!bt.isNullOrNil(paramAnonymousAdapterView.appId)))
        {
          paramAnonymousView = new Bundle();
          paramAnonymousView.putCharSequence("game_app_id", paramAnonymousAdapterView.appId);
          paramAnonymousView.putInt("game_report_from_scene", paramAnonymousAdapterView.dFG);
          paramAnonymousInt = com.tencent.mm.plugin.game.f.c.a(GameSearchUI.this, paramAnonymousAdapterView.appId, null, paramAnonymousView);
          paramAnonymousView = new HashMap();
          paramAnonymousView.put("function_type", "search");
          paramAnonymousView.put("funtion_value", paramAnonymousAdapterView.usW);
          paramAnonymousView.put("keyword", GameSearchUI.f(GameSearchUI.this));
          paramAnonymousView = com.tencent.mm.plugin.game.e.a.l(paramAnonymousView);
          com.tencent.mm.game.report.f.a(GameSearchUI.this, 14, paramAnonymousAdapterView.dFG, paramAnonymousAdapterView.position, paramAnonymousInt, paramAnonymousAdapterView.appId, GameSearchUI.g(GameSearchUI.this), paramAnonymousView);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameSearchUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(42390);
          return;
          if ((paramAnonymousAdapterView.actionType == 2) && (!bt.isNullOrNil(paramAnonymousAdapterView.usV)))
          {
            paramAnonymousInt = com.tencent.mm.plugin.game.f.c.B(GameSearchUI.this, paramAnonymousAdapterView.usV, "game_center_detail");
            paramAnonymousView = new HashMap();
            paramAnonymousView.put("function_type", "search");
            paramAnonymousView.put("funtion_value", paramAnonymousAdapterView.usW);
            paramAnonymousView.put("keyword", GameSearchUI.f(GameSearchUI.this));
            paramAnonymousView = com.tencent.mm.plugin.game.e.a.l(paramAnonymousView);
            com.tencent.mm.game.report.f.a(GameSearchUI.this, 14, paramAnonymousAdapterView.dFG, paramAnonymousAdapterView.position, paramAnonymousInt, 0, paramAnonymousAdapterView.appId, GameSearchUI.g(GameSearchUI.this), paramAnonymousAdapterView.usQ, String.valueOf(paramAnonymousAdapterView.usR), null, paramAnonymousView);
          }
        }
      }
    };
    this.utr = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(42391);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameSearchUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        paramAnonymousAdapterView = ((s)paramAnonymousAdapterView.getAdapter()).Ic(paramAnonymousInt);
        if (bt.isNullOrNil(paramAnonymousAdapterView.text))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameSearchUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(42391);
          return;
        }
        if (bt.isNullOrNil(paramAnonymousAdapterView.appId))
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
            ad.e("MicroMsg.GameSearchUI", "unknowed actionType : " + paramAnonymousAdapterView.actionType);
            break;
          case 1: 
            paramAnonymousView = new Bundle();
            paramAnonymousView.putCharSequence("game_app_id", paramAnonymousAdapterView.appId);
            paramAnonymousView.putInt("game_report_from_scene", 1402);
            i = com.tencent.mm.plugin.game.f.c.a(GameSearchUI.this, paramAnonymousAdapterView.appId, null, paramAnonymousView);
            com.tencent.mm.game.report.f.a(GameSearchUI.this, 14, 1402, paramAnonymousInt, i, paramAnonymousAdapterView.appId, GameSearchUI.g(GameSearchUI.this), null);
            break;
          case 2: 
            i = com.tencent.mm.plugin.game.f.c.B(GameSearchUI.this.getContext(), paramAnonymousAdapterView.usX, "game_center_detail");
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
    while (!this.uto.isEmpty())
    {
      g.ajD();
      g.ajB().gAO.a((n)this.uto.pop());
    }
    if (paramBoolean) {
      this.uti.reset();
    }
    this.utm = paramLinkedList;
    ak localak = new ak(ac.fks(), paramLinkedList, e.cYA(), this.uti.udv);
    g.aiU().a(localak, 0);
    this.uto.add(localak);
    paramLinkedList = paramLinkedList.iterator();
    for (this.utk = ""; paramLinkedList.hasNext(); this.utk = (this.utk + " " + (String)paramLinkedList.next())) {}
    this.utk = this.utk.trim();
    if ((paramInt == 1) || (paramInt == 2))
    {
      this.utp = true;
      this.fSC.setSearchContent(this.utk);
    }
    AppMethodBeat.o(42399);
  }
  
  private void aB(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(42398);
    a(paramLinkedList, 0, true);
    AppMethodBeat.o(42398);
  }
  
  private void tF(int paramInt)
  {
    AppMethodBeat.i(42397);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(42397);
      return;
      this.utf.setVisibility(8);
      this.ssK.setVisibility(8);
      this.utg.setVisibility(8);
      this.uth.setVisibility(8);
      this.progressBar.setVisibility(8);
      AppMethodBeat.o(42397);
      return;
      hideVKB();
      ListView localListView = this.utg;
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localListView, locala.ahp(), "com/tencent/mm/plugin/game/ui/GameSearchUI", "updateUI", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
      localListView.smoothScrollToPosition(((Integer)locala.mq(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localListView, "com/tencent/mm/plugin/game/ui/GameSearchUI", "updateUI", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
      this.fSC.clearFocus();
      this.utf.setVisibility(8);
      this.ssK.setVisibility(8);
      this.utg.setVisibility(8);
      this.uth.setVisibility(8);
      this.progressBar.setVisibility(0);
      AppMethodBeat.o(42397);
      return;
      localListView = this.utg;
      locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localListView, locala.ahp(), "com/tencent/mm/plugin/game/ui/GameSearchUI", "updateUI", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
      localListView.smoothScrollToPosition(((Integer)locala.mq(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localListView, "com/tencent/mm/plugin/game/ui/GameSearchUI", "updateUI", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
      this.utf.setVisibility(8);
      this.ssK.setVisibility(8);
      this.utg.setVisibility(8);
      this.uth.setVisibility(8);
      this.progressBar.setVisibility(0);
      AppMethodBeat.o(42397);
      return;
      this.utf.setVisibility(8);
      if (this.uti.getCount() > 0)
      {
        this.ssK.setVisibility(8);
        this.utg.setVisibility(0);
      }
      for (;;)
      {
        this.uth.setVisibility(8);
        this.progressBar.setVisibility(8);
        AppMethodBeat.o(42397);
        return;
        this.ssK.setVisibility(0);
        this.utg.setVisibility(8);
      }
      this.utf.setVisibility(0);
      this.ssK.setVisibility(8);
      this.utg.setVisibility(8);
      this.uth.setVisibility(8);
      this.progressBar.setVisibility(8);
      AppMethodBeat.o(42397);
      return;
      this.utf.setVisibility(8);
      this.ssK.setVisibility(0);
      this.utg.setVisibility(8);
      this.uth.setVisibility(8);
      this.progressBar.setVisibility(8);
      AppMethodBeat.o(42397);
      return;
      this.utf.setVisibility(8);
      this.ssK.setVisibility(8);
      this.utg.setVisibility(8);
      this.uth.setVisibility(0);
      this.progressBar.setVisibility(8);
    }
  }
  
  public final boolean Jp(String paramString)
  {
    AppMethodBeat.i(42406);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(42406);
      return true;
    }
    LinkedList localLinkedList = new LinkedList();
    paramString = ute.split(paramString.replace('*', ' '));
    int i = 0;
    while (i < paramString.length)
    {
      localLinkedList.add(paramString[i]);
      i += 1;
    }
    aB(localLinkedList);
    tF(1);
    AppMethodBeat.o(42406);
    return true;
  }
  
  public final void Jq(String paramString)
  {
    AppMethodBeat.i(42405);
    if (this.utp)
    {
      this.utp = false;
      AppMethodBeat.o(42405);
      return;
    }
    if ((this.utn != null) && (this.utn.equals(bt.nullAsNil(paramString))))
    {
      ad.d("MicroMsg.GameSearchUI", "repeat searchChange");
      AppMethodBeat.o(42405);
      return;
    }
    this.utn = paramString;
    if (bt.isNullOrNil(paramString))
    {
      while (!this.uto.isEmpty())
      {
        g.ajD();
        g.ajB().gAO.a((n)this.uto.pop());
      }
      paramString = new al(ac.fks(), paramString, e.cYA());
      g.aiU().a(paramString, 0);
      this.uto.add(paramString);
      AppMethodBeat.o(42405);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    paramString = ute.split(paramString.replace('*', ' '));
    int i = 0;
    while (i < paramString.length)
    {
      localLinkedList.add(paramString[i]);
      i += 1;
    }
    aB(localLinkedList);
    tF(6);
    AppMethodBeat.o(42405);
  }
  
  public final void aSm()
  {
    AppMethodBeat.i(42404);
    hideVKB();
    onBackPressed();
    AppMethodBeat.o(42404);
  }
  
  public final void aSn() {}
  
  public final void aSo() {}
  
  public final void aSp() {}
  
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
    this.fSC = new com.tencent.mm.ui.tools.r();
    this.fSC.yC(true);
    this.fSC.KKQ = this;
    this.utf = ((ViewGroup)findViewById(2131306550));
    this.progressBar = ((ProgressBar)findViewById(2131304439));
    this.ssK = ((TextView)findViewById(2131302883));
    this.utg = ((ListView)findViewById(2131304442));
    this.uti = new r(this);
    this.utg.setAdapter(this.uti);
    this.utg.setOnItemClickListener(this.utq);
    this.utg.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(42387);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameSearchUI$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        GameSearchUI.a(GameSearchUI.this).clearFocus();
        GameSearchUI.this.hideVKB();
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/game/ui/GameSearchUI$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(42387);
        return false;
      }
    });
    this.utg.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(42388);
        if ((paramAnonymousInt == 0) && (paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1) && (GameSearchUI.b(GameSearchUI.this).usz))
        {
          if (GameSearchUI.c(GameSearchUI.this) != null) {
            GameSearchUI.c(GameSearchUI.this).setVisibility(0);
          }
          GameSearchUI.a(GameSearchUI.this, GameSearchUI.d(GameSearchUI.this));
        }
        AppMethodBeat.o(42388);
      }
    });
    this.fTl = getLayoutInflater().inflate(2131494337, this.utg, false);
    this.fTl.setVisibility(8);
    this.utg.addFooterView(this.fTl);
    this.uth = ((ListView)findViewById(2131304440));
    this.utj = new s(this);
    this.uth.setAdapter(this.utj);
    this.uth.setOnItemClickListener(this.utr);
    this.uth.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(42389);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameSearchUI$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
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
    if (!g.ajx())
    {
      ad.e("MicroMsg.GameSearchUI", "account not ready");
      finish();
      AppMethodBeat.o(42393);
      return;
    }
    g.aiU().a(1328, this);
    g.aiU().a(1329, this);
    this.fromScene = getIntent().getIntExtra("game_report_from_scene", 0);
    initView();
    com.tencent.mm.game.report.f.a(this, 14, 1401, 0, 2, this.fromScene, null);
    ad.i("MicroMsg.GameSearchUI", "[onCreate] time:" + (System.currentTimeMillis() - l));
    AppMethodBeat.o(42393);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(42395);
    this.fSC.a(this, paramMenu);
    this.fSC.setHint(e.cYO());
    AppMethodBeat.o(42395);
    return true;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(42403);
    ad.i("MicroMsg.GameSearchUI", "onDestroy");
    super.onDestroy();
    g.aiU().b(1328, this);
    g.aiU().b(1329, this);
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
    this.fSC.a(this, paramMenu);
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
    if (this.uto.contains(paramn)) {
      this.uto.remove(paramn);
    }
    this.fTl.setVisibility(8);
    switch (paramn.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(42400);
      return;
      paramString = (aui)((ak)paramn).grW.hNK.hNQ;
      ad.d("MicroMsg.GameSearchUI", "keywords = %s, offset = %d", new Object[] { paramString.Gsy, Integer.valueOf(paramString.Gsz) });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (auj)((ak)paramn).grW.hNL.hNQ;
        label212:
        Object localObject3;
        label282:
        Object localObject4;
        if (paramString != null)
        {
          paramString = paramString.GsA;
          if (bt.hj(paramString)) {
            break label1767;
          }
          this.utl = this.utk;
          if (this.uti.udv != 0)
          {
            paramn = this.uti;
            localObject1 = this.utl;
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
            localObject2 = (auk)paramString.next();
            if ((((auk)localObject2).type == 3) && (!bt.hj(((auk)localObject2).GsC)))
            {
              paramn.udv = ((auk)localObject2).GsG;
              paramn.usz = ((auk)localObject2).GsH;
              localObject2 = ((auk)localObject2).GsC.iterator();
              if (((Iterator)localObject2).hasNext())
              {
                localObject3 = r.b.a((aum)((Iterator)localObject2).next());
                ((r.b)localObject3).dld = ((String)localObject1);
                ((r.b)localObject3).usU.appId = ((r.b)localObject3).appId;
                ((r.b)localObject3).usU.usQ = ((r.b)localObject3).usQ;
                ((r.b)localObject3).usU.usR = ((r.b)localObject3).usR;
                ((r.b)localObject3).usU.usW = "2";
                localObject4 = ((r.b)localObject3).usU;
                paramInt1 = paramn.usw;
                paramn.usw = (paramInt1 + 1);
                ((r.c)localObject4).position = (paramInt1 + 301);
                localObject4 = ((r.b)localObject3).usU;
                if (!paramn.dlh) {
                  break label439;
                }
              }
              label439:
              for (paramInt1 = 1403;; paramInt1 = 1405)
              {
                ((r.c)localObject4).dFG = paramInt1;
                paramn.gnG.add(localObject3);
                break label282;
                break label212;
                paramString = null;
                break;
              }
            }
            paramn.usz = false;
          }
        }
        paramn = this.uti;
        localObject1 = this.utl;
        if (paramn.gnG == null) {
          paramn.gnG = new ArrayList();
        }
        paramn.upY = 0;
        paramn.usu = 0;
        paramn.usv = 0;
        paramn.usw = 0;
        paramn.usx = 0;
        paramn.dlh = false;
        paramn.ust = false;
        paramn.usz = false;
        paramn.udv = 0;
        paramn.gnG.clear();
        paramn.usA = false;
        Object localObject2 = paramString.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          paramString = (auk)((Iterator)localObject2).next();
          label601:
          label620:
          int i;
          if ((paramString.GsB == null) || (paramString.GsB.size() == 0))
          {
            paramInt1 = 1;
            if ((paramString.GsC != null) && (paramString.GsC.size() != 0)) {
              break label725;
            }
            paramInt2 = 1;
            if ((paramString.GsF != null) && (paramString.GsF.size() != 0)) {
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
            paramn.gnG.add(r.b.bp(6, paramString));
            paramn.usA = true;
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
          paramn.gnG.add(r.b.bp(0, paramString.Title));
          if (!paramn.usA)
          {
            ((r.b)paramn.gnG.get(paramn.gnG.size() - 1)).usS = true;
            paramn.usA = true;
          }
          Object localObject5;
          if ((paramString.type == 4) && (paramString.GsF != null))
          {
            localObject3 = paramString.GsF.iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject5 = (aul)((Iterator)localObject3).next();
              localObject4 = new r.b();
              ((r.b)localObject4).type = 3;
              ((r.b)localObject4).appId = ((aul)localObject5).GsI.iht;
              ((r.b)localObject4).name = ((aul)localObject5).GsI.Name;
              ((r.b)localObject4).iTM = ((aul)localObject5).GsI.GaD;
              ((r.b)localObject4).iconUrl = ((aul)localObject5).GsI.IconUrl;
              ((r.b)localObject4).usM = ((aul)localObject5).GsI.ufh;
              ((r.b)localObject4).usN = ((aul)localObject5).GsI.Gsp;
              ((r.b)localObject4).actionType = ((aul)localObject5).GsI.FJz;
              ((r.b)localObject4).usO = ((aul)localObject5).GsI.Gsq;
              ((r.b)localObject4).usP = ((aul)localObject5).GsJ;
              ((r.b)localObject4).usU = new r.c(((aul)localObject5).GsI.FJz, 4, ((aul)localObject5).GsI.iht, ((aul)localObject5).GsI.Gsq);
              ((r.b)localObject4).dld = ((String)localObject1);
              ((r.b)localObject4).usU.usW = "3";
              localObject5 = ((r.b)localObject4).usU;
              paramInt1 = paramn.usv;
              paramn.usv = (paramInt1 + 1);
              ((r.c)localObject5).position = (paramInt1 + 601);
              paramn.gnG.add(localObject4);
            }
          }
          if (((paramString.type == 1) || (paramString.type == 2)) && (paramString.GsB != null))
          {
            localObject3 = paramString.GsB.iterator();
            if (((Iterator)localObject3).hasNext())
            {
              localObject5 = (aue)((Iterator)localObject3).next();
              localObject4 = new r.b();
              ((r.b)localObject4).type = 1;
              ((r.b)localObject4).appId = ((aue)localObject5).iht;
              ((r.b)localObject4).name = ((aue)localObject5).Name;
              ((r.b)localObject4).iTM = ((aue)localObject5).GaD;
              ((r.b)localObject4).iconUrl = ((aue)localObject5).IconUrl;
              ((r.b)localObject4).usM = ((aue)localObject5).ufh;
              ((r.b)localObject4).usN = ((aue)localObject5).Gsp;
              ((r.b)localObject4).actionType = ((aue)localObject5).FJz;
              ((r.b)localObject4).usO = ((aue)localObject5).Gsq;
              ((r.b)localObject4).usU = new r.c(((aue)localObject5).FJz, 1, ((aue)localObject5).iht, ((aue)localObject5).Gsq);
              ((r.b)localObject4).dld = ((String)localObject1);
              if (paramString.type == 1)
              {
                paramn.dlh = true;
                localObject5 = ((r.b)localObject4).usU;
                paramInt1 = paramn.upY;
                paramn.upY = (paramInt1 + 1);
                ((r.c)localObject5).position = (paramInt1 + 1);
              }
              for (;;)
              {
                ((r.b)localObject4).usU.usW = "1";
                paramn.gnG.add(localObject4);
                break;
                if (paramString.type == 2)
                {
                  paramn.ust = true;
                  localObject5 = ((r.b)localObject4).usU;
                  paramInt1 = paramn.usu;
                  paramn.usu = (paramInt1 + 1);
                  ((r.c)localObject5).position = (paramInt1 + 1);
                }
              }
            }
          }
          else if ((paramString.type == 3) && (paramString.GsC != null))
          {
            paramn.udv = paramString.GsG;
            paramn.usz = paramString.GsH;
            localObject3 = paramString.GsC.iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = r.b.a((aum)((Iterator)localObject3).next());
              ((r.b)localObject4).dld = ((String)localObject1);
              ((r.b)localObject4).usU.appId = ((r.b)localObject4).appId;
              ((r.b)localObject4).usU.usQ = ((r.b)localObject4).usQ;
              ((r.b)localObject4).usU.usR = ((r.b)localObject4).usR;
              ((r.b)localObject4).usU.usW = "2";
              localObject5 = ((r.b)localObject4).usU;
              paramInt1 = paramn.usw;
              paramn.usw = (paramInt1 + 1);
              ((r.c)localObject5).position = (paramInt1 + 301);
              paramn.gnG.add(localObject4);
            }
          }
          if ((!bt.isNullOrNil(paramString.GsD)) && (!bt.isNullOrNil(paramString.GsE)) && (paramString.type == 1))
          {
            localObject3 = paramString.GsD;
            paramString = paramString.GsE;
            localObject4 = new r.b();
            ((r.b)localObject4).type = 5;
            ((r.b)localObject4).name = ((String)localObject3);
            ((r.b)localObject4).usU = new r.c(paramString);
            ((r.b)localObject4).usU.appId = "wx62d9035fd4fd2059";
            ((r.b)localObject4).usU.usW = "1";
            ((r.b)localObject4).usU.position = 300;
            paramn.gnG.add(localObject4);
          }
        }
        paramString = paramn.gnG.iterator();
        while (paramString.hasNext())
        {
          localObject1 = (r.b)paramString.next();
          if (paramn.dlh) {
            ((r.b)localObject1).usU.dFG = 1403;
          } else if (paramn.ust) {
            ((r.b)localObject1).usU.dFG = 1404;
          } else {
            ((r.b)localObject1).usU.dFG = 1405;
          }
        }
        paramn.notifyDataSetChanged();
      }
      label1767:
      tF(2);
      AppMethodBeat.o(42400);
      return;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(42400);
        return;
      }
      paramString = ((al)paramn).dld;
      Object localObject1 = ((aug)((al)paramn).grW.hNL.hNQ).Title;
      paramn = ((aug)((al)paramn).grW.hNL.hNQ).Gsw;
      this.utj.b(paramString, (String)localObject1, paramn);
      tF(5);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameSearchUI
 * JD-Core Version:    0.7.0.1
 */