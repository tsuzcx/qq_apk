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
import com.tencent.mm.plugin.game.model.ak;
import com.tencent.mm.plugin.game.model.al;
import com.tencent.mm.protocal.protobuf.aqi;
import com.tencent.mm.protocal.protobuf.aqk;
import com.tencent.mm.protocal.protobuf.aqm;
import com.tencent.mm.protocal.protobuf.aqn;
import com.tencent.mm.protocal.protobuf.aqo;
import com.tencent.mm.protocal.protobuf.aqp;
import com.tencent.mm.protocal.protobuf.aqq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Pattern;

public class GameSearchUI
  extends MMActivity
  implements com.tencent.mm.ak.g, com.tencent.mm.ui.tools.r.b
{
  private static final Pattern tuF;
  private int fromScene;
  private View fzV;
  private com.tencent.mm.ui.tools.r fzp;
  private ProgressBar progressBar;
  private TextView rAz;
  private ViewGroup tuG;
  private ListView tuH;
  private ListView tuI;
  private r tuJ;
  private s tuK;
  private String tuL;
  private String tuM;
  private LinkedList<String> tuN;
  private String tuO;
  private LinkedList<n> tuP;
  private boolean tuQ;
  private AdapterView.OnItemClickListener tuR;
  private AdapterView.OnItemClickListener tuS;
  
  static
  {
    AppMethodBeat.i(42410);
    tuF = Pattern.compile("\\s+");
    AppMethodBeat.o(42410);
  }
  
  public GameSearchUI()
  {
    AppMethodBeat.i(42392);
    this.tuP = new LinkedList();
    this.tuQ = false;
    this.tuR = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(42390);
        paramAnonymousAdapterView = GameSearchUI.b(GameSearchUI.this);
        if ((paramAnonymousInt < 0) || (paramAnonymousInt >= paramAnonymousAdapterView.getCount())) {}
        for (paramAnonymousAdapterView = null; paramAnonymousAdapterView == null; paramAnonymousAdapterView = ((r.b)paramAnonymousAdapterView.getItem(paramAnonymousInt)).tuv)
        {
          AppMethodBeat.o(42390);
          return;
        }
        if ((paramAnonymousAdapterView.actionType == 1) && (!bs.isNullOrNil(paramAnonymousAdapterView.appId)))
        {
          paramAnonymousView = new Bundle();
          paramAnonymousView.putCharSequence("game_app_id", paramAnonymousAdapterView.appId);
          paramAnonymousView.putInt("game_report_from_scene", paramAnonymousAdapterView.dtF);
          paramAnonymousInt = com.tencent.mm.plugin.game.f.c.a(GameSearchUI.this, paramAnonymousAdapterView.appId, null, paramAnonymousView);
          paramAnonymousView = new HashMap();
          paramAnonymousView.put("function_type", "search");
          paramAnonymousView.put("funtion_value", paramAnonymousAdapterView.tux);
          paramAnonymousView.put("keyword", GameSearchUI.f(GameSearchUI.this));
          paramAnonymousView = com.tencent.mm.plugin.game.e.a.l(paramAnonymousView);
          com.tencent.mm.game.report.e.a(GameSearchUI.this, 14, paramAnonymousAdapterView.dtF, paramAnonymousAdapterView.position, paramAnonymousInt, paramAnonymousAdapterView.appId, GameSearchUI.g(GameSearchUI.this), paramAnonymousView);
          AppMethodBeat.o(42390);
          return;
        }
        if ((paramAnonymousAdapterView.actionType == 2) && (!bs.isNullOrNil(paramAnonymousAdapterView.tuw)))
        {
          paramAnonymousInt = com.tencent.mm.plugin.game.f.c.z(GameSearchUI.this, paramAnonymousAdapterView.tuw, "game_center_detail");
          paramAnonymousView = new HashMap();
          paramAnonymousView.put("function_type", "search");
          paramAnonymousView.put("funtion_value", paramAnonymousAdapterView.tux);
          paramAnonymousView.put("keyword", GameSearchUI.f(GameSearchUI.this));
          paramAnonymousView = com.tencent.mm.plugin.game.e.a.l(paramAnonymousView);
          com.tencent.mm.game.report.e.a(GameSearchUI.this, 14, paramAnonymousAdapterView.dtF, paramAnonymousAdapterView.position, paramAnonymousInt, 0, paramAnonymousAdapterView.appId, GameSearchUI.g(GameSearchUI.this), paramAnonymousAdapterView.tur, String.valueOf(paramAnonymousAdapterView.tus), null, paramAnonymousView);
        }
        AppMethodBeat.o(42390);
      }
    };
    this.tuS = new GameSearchUI.6(this);
    AppMethodBeat.o(42392);
  }
  
  private void a(LinkedList<String> paramLinkedList, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(42399);
    while (!this.tuP.isEmpty())
    {
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a((n)this.tuP.pop());
    }
    if (paramBoolean) {
      this.tuJ.reset();
    }
    this.tuN = paramLinkedList;
    ak localak = new ak(ab.eUO(), paramLinkedList, com.tencent.mm.plugin.game.model.e.cPV(), this.tuJ.tfF);
    com.tencent.mm.kernel.g.agi().a(localak, 0);
    this.tuP.add(localak);
    paramLinkedList = paramLinkedList.iterator();
    for (this.tuL = ""; paramLinkedList.hasNext(); this.tuL = (this.tuL + " " + (String)paramLinkedList.next())) {}
    this.tuL = this.tuL.trim();
    if ((paramInt == 1) || (paramInt == 2))
    {
      this.tuQ = true;
      this.fzp.setSearchContent(this.tuL);
    }
    AppMethodBeat.o(42399);
  }
  
  private void az(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(42398);
    a(paramLinkedList, 0, true);
    AppMethodBeat.o(42398);
  }
  
  private void tc(int paramInt)
  {
    AppMethodBeat.i(42397);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(42397);
      return;
      this.tuG.setVisibility(8);
      this.rAz.setVisibility(8);
      this.tuH.setVisibility(8);
      this.tuI.setVisibility(8);
      this.progressBar.setVisibility(8);
      AppMethodBeat.o(42397);
      return;
      hideVKB();
      ListView localListView = this.tuH;
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localListView, locala.aeD(), "com/tencent/mm/plugin/game/ui/GameSearchUI", "updateUI", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
      localListView.smoothScrollToPosition(((Integer)locala.lR(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localListView, "com/tencent/mm/plugin/game/ui/GameSearchUI", "updateUI", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
      this.fzp.clearFocus();
      this.tuG.setVisibility(8);
      this.rAz.setVisibility(8);
      this.tuH.setVisibility(8);
      this.tuI.setVisibility(8);
      this.progressBar.setVisibility(0);
      AppMethodBeat.o(42397);
      return;
      localListView = this.tuH;
      locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localListView, locala.aeD(), "com/tencent/mm/plugin/game/ui/GameSearchUI", "updateUI", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
      localListView.smoothScrollToPosition(((Integer)locala.lR(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localListView, "com/tencent/mm/plugin/game/ui/GameSearchUI", "updateUI", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
      this.tuG.setVisibility(8);
      this.rAz.setVisibility(8);
      this.tuH.setVisibility(8);
      this.tuI.setVisibility(8);
      this.progressBar.setVisibility(0);
      AppMethodBeat.o(42397);
      return;
      this.tuG.setVisibility(8);
      if (this.tuJ.getCount() > 0)
      {
        this.rAz.setVisibility(8);
        this.tuH.setVisibility(0);
      }
      for (;;)
      {
        this.tuI.setVisibility(8);
        this.progressBar.setVisibility(8);
        AppMethodBeat.o(42397);
        return;
        this.rAz.setVisibility(0);
        this.tuH.setVisibility(8);
      }
      this.tuG.setVisibility(0);
      this.rAz.setVisibility(8);
      this.tuH.setVisibility(8);
      this.tuI.setVisibility(8);
      this.progressBar.setVisibility(8);
      AppMethodBeat.o(42397);
      return;
      this.tuG.setVisibility(8);
      this.rAz.setVisibility(0);
      this.tuH.setVisibility(8);
      this.tuI.setVisibility(8);
      this.progressBar.setVisibility(8);
      AppMethodBeat.o(42397);
      return;
      this.tuG.setVisibility(8);
      this.rAz.setVisibility(8);
      this.tuH.setVisibility(8);
      this.tuI.setVisibility(0);
      this.progressBar.setVisibility(8);
    }
  }
  
  public final boolean Ga(String paramString)
  {
    AppMethodBeat.i(42406);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(42406);
      return true;
    }
    LinkedList localLinkedList = new LinkedList();
    paramString = tuF.split(paramString.replace('*', ' '));
    int i = 0;
    while (i < paramString.length)
    {
      localLinkedList.add(paramString[i]);
      i += 1;
    }
    az(localLinkedList);
    tc(1);
    AppMethodBeat.o(42406);
    return true;
  }
  
  public final void Gb(String paramString)
  {
    AppMethodBeat.i(42405);
    if (this.tuQ)
    {
      this.tuQ = false;
      AppMethodBeat.o(42405);
      return;
    }
    if ((this.tuO != null) && (this.tuO.equals(bs.nullAsNil(paramString))))
    {
      ac.d("MicroMsg.GameSearchUI", "repeat searchChange");
      AppMethodBeat.o(42405);
      return;
    }
    this.tuO = paramString;
    if (bs.isNullOrNil(paramString))
    {
      while (!this.tuP.isEmpty())
      {
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agQ().ghe.a((n)this.tuP.pop());
      }
      paramString = new al(ab.eUO(), paramString, com.tencent.mm.plugin.game.model.e.cPV());
      com.tencent.mm.kernel.g.agi().a(paramString, 0);
      this.tuP.add(paramString);
      AppMethodBeat.o(42405);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    paramString = tuF.split(paramString.replace('*', ' '));
    int i = 0;
    while (i < paramString.length)
    {
      localLinkedList.add(paramString[i]);
      i += 1;
    }
    az(localLinkedList);
    tc(6);
    AppMethodBeat.o(42405);
  }
  
  public final void aPa()
  {
    AppMethodBeat.i(42404);
    hideVKB();
    onBackPressed();
    AppMethodBeat.o(42404);
  }
  
  public final void aPb() {}
  
  public final void aPc() {}
  
  public final void aPd() {}
  
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
    this.fzp = new com.tencent.mm.ui.tools.r();
    this.fzp.xO(true);
    this.fzp.ITM = this;
    this.tuG = ((ViewGroup)findViewById(2131306550));
    this.progressBar = ((ProgressBar)findViewById(2131304439));
    this.rAz = ((TextView)findViewById(2131302883));
    this.tuH = ((ListView)findViewById(2131304442));
    this.tuJ = new r(this);
    this.tuH.setAdapter(this.tuJ);
    this.tuH.setOnItemClickListener(this.tuR);
    this.tuH.setOnTouchListener(new View.OnTouchListener()
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
    this.tuH.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(42388);
        if ((paramAnonymousInt == 0) && (paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1) && (GameSearchUI.b(GameSearchUI.this).tua))
        {
          if (GameSearchUI.c(GameSearchUI.this) != null) {
            GameSearchUI.c(GameSearchUI.this).setVisibility(0);
          }
          GameSearchUI.a(GameSearchUI.this, GameSearchUI.d(GameSearchUI.this));
        }
        AppMethodBeat.o(42388);
      }
    });
    this.fzV = getLayoutInflater().inflate(2131494337, this.tuH, false);
    this.fzV.setVisibility(8);
    this.tuH.addFooterView(this.fzV);
    this.tuI = ((ListView)findViewById(2131304440));
    this.tuK = new s(this);
    this.tuI.setAdapter(this.tuK);
    this.tuI.setOnItemClickListener(this.tuS);
    this.tuI.setOnTouchListener(new View.OnTouchListener()
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
    if (!com.tencent.mm.kernel.g.agM())
    {
      ac.e("MicroMsg.GameSearchUI", "account not ready");
      finish();
      AppMethodBeat.o(42393);
      return;
    }
    com.tencent.mm.kernel.g.agi().a(1328, this);
    com.tencent.mm.kernel.g.agi().a(1329, this);
    this.fromScene = getIntent().getIntExtra("game_report_from_scene", 0);
    initView();
    com.tencent.mm.game.report.e.a(this, 14, 1401, 0, 2, this.fromScene, null);
    ac.i("MicroMsg.GameSearchUI", "[onCreate] time:" + (System.currentTimeMillis() - l));
    AppMethodBeat.o(42393);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(42395);
    this.fzp.a(this, paramMenu);
    this.fzp.setHint(com.tencent.mm.plugin.game.model.e.cQj());
    AppMethodBeat.o(42395);
    return true;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(42403);
    ac.i("MicroMsg.GameSearchUI", "onDestroy");
    super.onDestroy();
    com.tencent.mm.kernel.g.agi().b(1328, this);
    com.tencent.mm.kernel.g.agi().b(1329, this);
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
    this.fzp.a(this, paramMenu);
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
    if (this.tuP.contains(paramn)) {
      this.tuP.remove(paramn);
    }
    this.fzV.setVisibility(8);
    switch (paramn.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(42400);
      return;
      paramString = (aqm)((ak)paramn).fYA.hvr.hvw;
      ac.d("MicroMsg.GameSearchUI", "keywords = %s, offset = %d", new Object[] { paramString.EJw, Integer.valueOf(paramString.EJx) });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (aqn)((ak)paramn).fYA.hvs.hvw;
        label212:
        Object localObject3;
        label282:
        Object localObject4;
        if (paramString != null)
        {
          paramString = paramString.EJy;
          if (bs.gY(paramString)) {
            break label1767;
          }
          this.tuM = this.tuL;
          if (this.tuJ.tfF != 0)
          {
            paramn = this.tuJ;
            localObject1 = this.tuM;
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
            localObject2 = (aqo)paramString.next();
            if ((((aqo)localObject2).type == 3) && (!bs.gY(((aqo)localObject2).EJA)))
            {
              paramn.tfF = ((aqo)localObject2).EJE;
              paramn.tua = ((aqo)localObject2).EJF;
              localObject2 = ((aqo)localObject2).EJA.iterator();
              if (((Iterator)localObject2).hasNext())
              {
                localObject3 = r.b.a((aqq)((Iterator)localObject2).next());
                ((r.b)localObject3).cZL = ((String)localObject1);
                ((r.b)localObject3).tuv.appId = ((r.b)localObject3).appId;
                ((r.b)localObject3).tuv.tur = ((r.b)localObject3).tur;
                ((r.b)localObject3).tuv.tus = ((r.b)localObject3).tus;
                ((r.b)localObject3).tuv.tux = "2";
                localObject4 = ((r.b)localObject3).tuv;
                paramInt1 = paramn.ttX;
                paramn.ttX = (paramInt1 + 1);
                ((r.c)localObject4).position = (paramInt1 + 301);
                localObject4 = ((r.b)localObject3).tuv;
                if (!paramn.cZP) {
                  break label439;
                }
              }
              label439:
              for (paramInt1 = 1403;; paramInt1 = 1405)
              {
                ((r.c)localObject4).dtF = paramInt1;
                paramn.fUc.add(localObject3);
                break label282;
                break label212;
                paramString = null;
                break;
              }
            }
            paramn.tua = false;
          }
        }
        paramn = this.tuJ;
        localObject1 = this.tuM;
        if (paramn.fUc == null) {
          paramn.fUc = new ArrayList();
        }
        paramn.trB = 0;
        paramn.ttV = 0;
        paramn.ttW = 0;
        paramn.ttX = 0;
        paramn.ttY = 0;
        paramn.cZP = false;
        paramn.ttU = false;
        paramn.tua = false;
        paramn.tfF = 0;
        paramn.fUc.clear();
        paramn.tub = false;
        Object localObject2 = paramString.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          paramString = (aqo)((Iterator)localObject2).next();
          label601:
          label620:
          int i;
          if ((paramString.EJz == null) || (paramString.EJz.size() == 0))
          {
            paramInt1 = 1;
            if ((paramString.EJA != null) && (paramString.EJA.size() != 0)) {
              break label725;
            }
            paramInt2 = 1;
            if ((paramString.EJD != null) && (paramString.EJD.size() != 0)) {
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
            if (bs.isNullOrNil((String)localObject1)) {
              break label741;
            }
          }
          label725:
          label730:
          label736:
          label741:
          for (paramString = paramn.context.getString(2131759974, new Object[] { localObject1 });; paramString = paramn.context.getString(2131759973))
          {
            paramn.fUc.add(r.b.bm(6, paramString));
            paramn.tub = true;
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
          paramn.fUc.add(r.b.bm(0, paramString.Title));
          if (!paramn.tub)
          {
            ((r.b)paramn.fUc.get(paramn.fUc.size() - 1)).tut = true;
            paramn.tub = true;
          }
          Object localObject5;
          if ((paramString.type == 4) && (paramString.EJD != null))
          {
            localObject3 = paramString.EJD.iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject5 = (aqp)((Iterator)localObject3).next();
              localObject4 = new r.b();
              ((r.b)localObject4).type = 3;
              ((r.b)localObject4).appId = ((aqp)localObject5).EJG.hOf;
              ((r.b)localObject4).name = ((aqp)localObject5).EJG.Name;
              ((r.b)localObject4).iAC = ((aqp)localObject5).EJG.Etm;
              ((r.b)localObject4).iconUrl = ((aqp)localObject5).EJG.IconUrl;
              ((r.b)localObject4).tun = ((aqp)localObject5).EJG.thq;
              ((r.b)localObject4).tuo = ((aqp)localObject5).EJG.EJn;
              ((r.b)localObject4).actionType = ((aqp)localObject5).EJG.Edq;
              ((r.b)localObject4).tup = ((aqp)localObject5).EJG.EJo;
              ((r.b)localObject4).tuq = ((aqp)localObject5).EJH;
              ((r.b)localObject4).tuv = new r.c(((aqp)localObject5).EJG.Edq, 4, ((aqp)localObject5).EJG.hOf, ((aqp)localObject5).EJG.EJo);
              ((r.b)localObject4).cZL = ((String)localObject1);
              ((r.b)localObject4).tuv.tux = "3";
              localObject5 = ((r.b)localObject4).tuv;
              paramInt1 = paramn.ttW;
              paramn.ttW = (paramInt1 + 1);
              ((r.c)localObject5).position = (paramInt1 + 601);
              paramn.fUc.add(localObject4);
            }
          }
          if (((paramString.type == 1) || (paramString.type == 2)) && (paramString.EJz != null))
          {
            localObject3 = paramString.EJz.iterator();
            if (((Iterator)localObject3).hasNext())
            {
              localObject5 = (aqi)((Iterator)localObject3).next();
              localObject4 = new r.b();
              ((r.b)localObject4).type = 1;
              ((r.b)localObject4).appId = ((aqi)localObject5).hOf;
              ((r.b)localObject4).name = ((aqi)localObject5).Name;
              ((r.b)localObject4).iAC = ((aqi)localObject5).Etm;
              ((r.b)localObject4).iconUrl = ((aqi)localObject5).IconUrl;
              ((r.b)localObject4).tun = ((aqi)localObject5).thq;
              ((r.b)localObject4).tuo = ((aqi)localObject5).EJn;
              ((r.b)localObject4).actionType = ((aqi)localObject5).Edq;
              ((r.b)localObject4).tup = ((aqi)localObject5).EJo;
              ((r.b)localObject4).tuv = new r.c(((aqi)localObject5).Edq, 1, ((aqi)localObject5).hOf, ((aqi)localObject5).EJo);
              ((r.b)localObject4).cZL = ((String)localObject1);
              if (paramString.type == 1)
              {
                paramn.cZP = true;
                localObject5 = ((r.b)localObject4).tuv;
                paramInt1 = paramn.trB;
                paramn.trB = (paramInt1 + 1);
                ((r.c)localObject5).position = (paramInt1 + 1);
              }
              for (;;)
              {
                ((r.b)localObject4).tuv.tux = "1";
                paramn.fUc.add(localObject4);
                break;
                if (paramString.type == 2)
                {
                  paramn.ttU = true;
                  localObject5 = ((r.b)localObject4).tuv;
                  paramInt1 = paramn.ttV;
                  paramn.ttV = (paramInt1 + 1);
                  ((r.c)localObject5).position = (paramInt1 + 1);
                }
              }
            }
          }
          else if ((paramString.type == 3) && (paramString.EJA != null))
          {
            paramn.tfF = paramString.EJE;
            paramn.tua = paramString.EJF;
            localObject3 = paramString.EJA.iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = r.b.a((aqq)((Iterator)localObject3).next());
              ((r.b)localObject4).cZL = ((String)localObject1);
              ((r.b)localObject4).tuv.appId = ((r.b)localObject4).appId;
              ((r.b)localObject4).tuv.tur = ((r.b)localObject4).tur;
              ((r.b)localObject4).tuv.tus = ((r.b)localObject4).tus;
              ((r.b)localObject4).tuv.tux = "2";
              localObject5 = ((r.b)localObject4).tuv;
              paramInt1 = paramn.ttX;
              paramn.ttX = (paramInt1 + 1);
              ((r.c)localObject5).position = (paramInt1 + 301);
              paramn.fUc.add(localObject4);
            }
          }
          if ((!bs.isNullOrNil(paramString.EJB)) && (!bs.isNullOrNil(paramString.EJC)) && (paramString.type == 1))
          {
            localObject3 = paramString.EJB;
            paramString = paramString.EJC;
            localObject4 = new r.b();
            ((r.b)localObject4).type = 5;
            ((r.b)localObject4).name = ((String)localObject3);
            ((r.b)localObject4).tuv = new r.c(paramString);
            ((r.b)localObject4).tuv.appId = "wx62d9035fd4fd2059";
            ((r.b)localObject4).tuv.tux = "1";
            ((r.b)localObject4).tuv.position = 300;
            paramn.fUc.add(localObject4);
          }
        }
        paramString = paramn.fUc.iterator();
        while (paramString.hasNext())
        {
          localObject1 = (r.b)paramString.next();
          if (paramn.cZP) {
            ((r.b)localObject1).tuv.dtF = 1403;
          } else if (paramn.ttU) {
            ((r.b)localObject1).tuv.dtF = 1404;
          } else {
            ((r.b)localObject1).tuv.dtF = 1405;
          }
        }
        paramn.notifyDataSetChanged();
      }
      label1767:
      tc(2);
      AppMethodBeat.o(42400);
      return;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(42400);
        return;
      }
      paramString = ((al)paramn).cZL;
      Object localObject1 = ((aqk)((al)paramn).fYA.hvs.hvw).Title;
      paramn = ((aqk)((al)paramn).fYA.hvs.hvw).EJu;
      this.tuK.b(paramString, (String)localObject1, paramn);
      tc(5);
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