package com.tencent.mm.plugin.game.ui;

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
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.game.report.g;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.plugin.game.h.i;
import com.tencent.mm.plugin.game.model.ak;
import com.tencent.mm.plugin.game.model.al;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.protocal.protobuf.cbc;
import com.tencent.mm.protocal.protobuf.cbe;
import com.tencent.mm.protocal.protobuf.cbg;
import com.tencent.mm.protocal.protobuf.cbh;
import com.tencent.mm.protocal.protobuf.cbi;
import com.tencent.mm.protocal.protobuf.cbj;
import com.tencent.mm.protocal.protobuf.cbk;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.s.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Pattern;

public class GameSearchUI
  extends MMActivity
  implements com.tencent.mm.am.h, s.c
{
  private static final Pattern IUS;
  private TextView BnA;
  private ViewGroup IUT;
  private ListView IUU;
  private ListView IUV;
  private r IUW;
  private s IUX;
  private String IUY;
  private String IUZ;
  private LinkedList<String> IVa;
  private String IVb;
  private LinkedList<p> IVc;
  private boolean IVd;
  private AdapterView.OnItemClickListener IVe;
  private AdapterView.OnItemClickListener IVf;
  private int fromScene;
  private com.tencent.mm.ui.tools.s lMw;
  private View lNf;
  private ProgressBar progressBar;
  
  static
  {
    AppMethodBeat.i(42410);
    IUS = Pattern.compile("\\s+");
    AppMethodBeat.o(42410);
  }
  
  public GameSearchUI()
  {
    AppMethodBeat.i(42392);
    this.IVc = new LinkedList();
    this.IVd = false;
    this.IVe = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(42390);
        b localb = new b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameSearchUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        paramAnonymousAdapterView = GameSearchUI.b(GameSearchUI.this);
        if ((paramAnonymousInt < 0) || (paramAnonymousInt >= paramAnonymousAdapterView.getCount())) {}
        for (paramAnonymousAdapterView = null; paramAnonymousAdapterView == null; paramAnonymousAdapterView = ((r.b)paramAnonymousAdapterView.getItem(paramAnonymousInt)).IUJ)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameSearchUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(42390);
          return;
        }
        if ((paramAnonymousAdapterView.actionType == 1) && (!Util.isNullOrNil(paramAnonymousAdapterView.appId)))
        {
          paramAnonymousView = new Bundle();
          paramAnonymousView.putCharSequence("game_app_id", paramAnonymousAdapterView.appId);
          paramAnonymousView.putInt("game_report_from_scene", paramAnonymousAdapterView.hYi);
          paramAnonymousInt = com.tencent.mm.plugin.game.d.c.b(GameSearchUI.this, paramAnonymousAdapterView.appId, null, paramAnonymousView);
          paramAnonymousView = new HashMap();
          paramAnonymousView.put("function_type", "search");
          paramAnonymousView.put("funtion_value", paramAnonymousAdapterView.IUK);
          paramAnonymousView.put("keyword", GameSearchUI.f(GameSearchUI.this));
          paramAnonymousView = com.tencent.mm.plugin.game.c.a.t(paramAnonymousView);
          g.a(GameSearchUI.this, 14, paramAnonymousAdapterView.hYi, paramAnonymousAdapterView.position, paramAnonymousInt, paramAnonymousAdapterView.appId, GameSearchUI.g(GameSearchUI.this), paramAnonymousView);
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
            paramAnonymousView.put("funtion_value", paramAnonymousAdapterView.IUK);
            paramAnonymousView.put("keyword", GameSearchUI.f(GameSearchUI.this));
            paramAnonymousView = com.tencent.mm.plugin.game.c.a.t(paramAnonymousView);
            g.a(GameSearchUI.this, 14, paramAnonymousAdapterView.hYi, paramAnonymousAdapterView.position, paramAnonymousInt, 0, paramAnonymousAdapterView.appId, GameSearchUI.g(GameSearchUI.this), paramAnonymousAdapterView.IUF, String.valueOf(paramAnonymousAdapterView.IUG), null, paramAnonymousView);
          }
        }
      }
    };
    this.IVf = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(42391);
        b localb = new b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameSearchUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        paramAnonymousAdapterView = ((s)paramAnonymousAdapterView.getAdapter()).XP(paramAnonymousInt);
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
            i = com.tencent.mm.plugin.game.d.c.I(GameSearchUI.this.getContext(), paramAnonymousAdapterView.IUL, "game_center_detail");
            g.a(GameSearchUI.this, 14, 1402, paramAnonymousInt, i, paramAnonymousAdapterView.appId, GameSearchUI.g(GameSearchUI.this), null);
          }
        }
      }
    };
    AppMethodBeat.o(42392);
  }
  
  private void Bt(int paramInt)
  {
    AppMethodBeat.i(42397);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(42397);
      return;
      this.IUT.setVisibility(8);
      this.BnA.setVisibility(8);
      this.IUU.setVisibility(8);
      this.IUV.setVisibility(8);
      this.progressBar.setVisibility(8);
      AppMethodBeat.o(42397);
      return;
      hideVKB();
      ListView localListView = this.IUU;
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localListView, locala.aYi(), "com/tencent/mm/plugin/game/ui/GameSearchUI", "updateUI", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
      localListView.smoothScrollToPosition(((Integer)locala.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localListView, "com/tencent/mm/plugin/game/ui/GameSearchUI", "updateUI", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
      this.lMw.clearFocus();
      this.IUT.setVisibility(8);
      this.BnA.setVisibility(8);
      this.IUU.setVisibility(8);
      this.IUV.setVisibility(8);
      this.progressBar.setVisibility(0);
      AppMethodBeat.o(42397);
      return;
      localListView = this.IUU;
      locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localListView, locala.aYi(), "com/tencent/mm/plugin/game/ui/GameSearchUI", "updateUI", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
      localListView.smoothScrollToPosition(((Integer)locala.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localListView, "com/tencent/mm/plugin/game/ui/GameSearchUI", "updateUI", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
      this.IUT.setVisibility(8);
      this.BnA.setVisibility(8);
      this.IUU.setVisibility(8);
      this.IUV.setVisibility(8);
      this.progressBar.setVisibility(0);
      AppMethodBeat.o(42397);
      return;
      this.IUT.setVisibility(8);
      if (this.IUW.getCount() > 0)
      {
        this.BnA.setVisibility(8);
        this.IUU.setVisibility(0);
      }
      for (;;)
      {
        this.IUV.setVisibility(8);
        this.progressBar.setVisibility(8);
        AppMethodBeat.o(42397);
        return;
        this.BnA.setVisibility(0);
        this.IUU.setVisibility(8);
      }
      this.IUT.setVisibility(0);
      this.BnA.setVisibility(8);
      this.IUU.setVisibility(8);
      this.IUV.setVisibility(8);
      this.progressBar.setVisibility(8);
      AppMethodBeat.o(42397);
      return;
      this.IUT.setVisibility(8);
      this.BnA.setVisibility(0);
      this.IUU.setVisibility(8);
      this.IUV.setVisibility(8);
      this.progressBar.setVisibility(8);
      AppMethodBeat.o(42397);
      return;
      this.IUT.setVisibility(8);
      this.BnA.setVisibility(8);
      this.IUU.setVisibility(8);
      this.IUV.setVisibility(0);
      this.progressBar.setVisibility(8);
    }
  }
  
  private void a(LinkedList<String> paramLinkedList, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(42399);
    while (!this.IVc.isEmpty())
    {
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a((p)this.IVc.pop());
    }
    if (paramBoolean) {
      this.IUW.reset();
    }
    this.IVa = paramLinkedList;
    ak localak = new ak(LocaleUtil.getApplicationLanguage(), paramLinkedList, e.fFU(), this.IUW.IFh);
    com.tencent.mm.kernel.h.aZW().a(localak, 0);
    this.IVc.add(localak);
    paramLinkedList = paramLinkedList.iterator();
    for (this.IUY = ""; paramLinkedList.hasNext(); this.IUY = (this.IUY + " " + (String)paramLinkedList.next())) {}
    this.IUY = this.IUY.trim();
    if ((paramInt == 1) || (paramInt == 2))
    {
      this.IVd = true;
      this.lMw.setSearchContent(this.IUY);
    }
    AppMethodBeat.o(42399);
  }
  
  private void bw(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(42398);
    a(paramLinkedList, 0, true);
    AppMethodBeat.o(42398);
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
    paramString = IUS.split(paramString.replace('*', ' '));
    int i = 0;
    while (i < paramString.length)
    {
      localLinkedList.add(paramString[i]);
      i += 1;
    }
    bw(localLinkedList);
    Bt(1);
    AppMethodBeat.o(42406);
    return true;
  }
  
  public final void SO(String paramString)
  {
    AppMethodBeat.i(42405);
    if (this.IVd)
    {
      this.IVd = false;
      AppMethodBeat.o(42405);
      return;
    }
    if ((this.IVb != null) && (this.IVb.equals(Util.nullAsNil(paramString))))
    {
      Log.d("MicroMsg.GameSearchUI", "repeat searchChange");
      AppMethodBeat.o(42405);
      return;
    }
    this.IVb = paramString;
    if (Util.isNullOrNil(paramString))
    {
      while (!this.IVc.isEmpty())
      {
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baD().mCm.a((p)this.IVc.pop());
      }
      paramString = new al(LocaleUtil.getApplicationLanguage(), paramString, e.fFU());
      com.tencent.mm.kernel.h.aZW().a(paramString, 0);
      this.IVc.add(paramString);
      AppMethodBeat.o(42405);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    paramString = IUS.split(paramString.replace('*', ' '));
    int i = 0;
    while (i < paramString.length)
    {
      localLinkedList.add(paramString[i]);
      i += 1;
    }
    bw(localLinkedList);
    Bt(6);
    AppMethodBeat.o(42405);
  }
  
  public final void bWw()
  {
    AppMethodBeat.i(42404);
    hideVKB();
    onBackPressed();
    AppMethodBeat.o(42404);
  }
  
  public final void bWx() {}
  
  public final void bWy() {}
  
  public final void bWz() {}
  
  public int getLayoutId()
  {
    return h.f.Iai;
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
    this.lMw = new com.tencent.mm.ui.tools.s();
    this.lMw.MY(true);
    this.lMw.afKz = this;
    this.IUT = ((ViewGroup)findViewById(h.e.gdj));
    this.progressBar = ((ProgressBar)findViewById(h.e.xqC));
    this.BnA = ((TextView)findViewById(h.e.no_result));
    this.IUU = ((ListView)findViewById(h.e.xqD));
    this.IUW = new r(this);
    this.IUU.setAdapter(this.IUW);
    this.IUU.setOnItemClickListener(this.IVe);
    this.IUU.setOnTouchListener(new View.OnTouchListener()
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
    this.IUU.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(42388);
        if ((paramAnonymousInt == 0) && (paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1) && (GameSearchUI.b(GameSearchUI.this).IUr))
        {
          if (GameSearchUI.c(GameSearchUI.this) != null) {
            GameSearchUI.c(GameSearchUI.this).setVisibility(0);
          }
          GameSearchUI.a(GameSearchUI.this, GameSearchUI.d(GameSearchUI.this));
        }
        AppMethodBeat.o(42388);
      }
    });
    this.lNf = getLayoutInflater().inflate(h.f.HZP, this.IUU, false);
    this.lNf.setVisibility(8);
    this.IUU.addFooterView(this.lNf);
    this.IUV = ((ListView)findViewById(h.e.HXE));
    this.IUX = new s(this);
    this.IUV.setAdapter(this.IUX);
    this.IUV.setOnItemClickListener(this.IVf);
    this.IUV.setOnTouchListener(new View.OnTouchListener()
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
    if (!com.tencent.mm.kernel.h.baz())
    {
      Log.e("MicroMsg.GameSearchUI", "account not ready");
      finish();
      AppMethodBeat.o(42393);
      return;
    }
    com.tencent.mm.kernel.h.aZW().a(1328, this);
    com.tencent.mm.kernel.h.aZW().a(1329, this);
    this.fromScene = getIntent().getIntExtra("game_report_from_scene", 0);
    initView();
    g.a(this, 14, 1401, 0, 2, this.fromScene, null);
    Log.i("MicroMsg.GameSearchUI", "[onCreate] time:" + (System.currentTimeMillis() - l));
    AppMethodBeat.o(42393);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(42395);
    this.lMw.a(this, paramMenu);
    this.lMw.setHint(e.fGi());
    AppMethodBeat.o(42395);
    return true;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(42403);
    Log.i("MicroMsg.GameSearchUI", "onDestroy");
    super.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(1328, this);
    com.tencent.mm.kernel.h.aZW().b(1329, this);
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
    this.lMw.a(this, paramMenu);
    AppMethodBeat.o(42396);
    return true;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(42400);
    if (paramp.isCanceled())
    {
      AppMethodBeat.o(42400);
      return;
    }
    if (this.IVc.contains(paramp)) {
      this.IVc.remove(paramp);
    }
    this.lNf.setVisibility(8);
    switch (paramp.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(42400);
      return;
      paramString = (cbg)c.b.b(((ak)paramp).mtC.otB);
      Log.d("MicroMsg.GameSearchUI", "keywords = %s, offset = %d", new Object[] { paramString.aakw, Integer.valueOf(paramString.aakx) });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (cbh)c.c.b(((ak)paramp).mtC.otC);
        label212:
        Object localObject3;
        label282:
        Object localObject4;
        if (paramString != null)
        {
          paramString = paramString.aaky;
          if (Util.isNullOrNil(paramString)) {
            break label1767;
          }
          this.IUZ = this.IUY;
          if (this.IUW.IFh != 0)
          {
            paramp = this.IUW;
            localObject1 = this.IUZ;
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
            localObject2 = (cbi)paramString.next();
            if ((((cbi)localObject2).type == 3) && (!Util.isNullOrNil(((cbi)localObject2).aakA)))
            {
              paramp.IFh = ((cbi)localObject2).aakE;
              paramp.IUr = ((cbi)localObject2).aakF;
              localObject2 = ((cbi)localObject2).aakA.iterator();
              if (((Iterator)localObject2).hasNext())
              {
                localObject3 = r.b.a((cbk)((Iterator)localObject2).next());
                ((r.b)localObject3).hAB = ((String)localObject1);
                ((r.b)localObject3).IUJ.appId = ((r.b)localObject3).appId;
                ((r.b)localObject3).IUJ.IUF = ((r.b)localObject3).IUF;
                ((r.b)localObject3).IUJ.IUG = ((r.b)localObject3).IUG;
                ((r.b)localObject3).IUJ.IUK = "2";
                localObject4 = ((r.b)localObject3).IUJ;
                paramInt1 = paramp.IUo;
                paramp.IUo = (paramInt1 + 1);
                ((r.c)localObject4).position = (paramInt1 + 301);
                localObject4 = ((r.b)localObject3).IUJ;
                if (!paramp.hAE) {
                  break label439;
                }
              }
              label439:
              for (paramInt1 = 1403;; paramInt1 = 1405)
              {
                ((r.c)localObject4).hYi = paramInt1;
                paramp.mfy.add(localObject3);
                break label282;
                break label212;
                paramString = null;
                break;
              }
            }
            paramp.IUr = false;
          }
        }
        paramp = this.IUW;
        localObject1 = this.IUZ;
        if (paramp.mfy == null) {
          paramp.mfy = new ArrayList();
        }
        paramp.IRT = 0;
        paramp.IUm = 0;
        paramp.IUn = 0;
        paramp.IUo = 0;
        paramp.IUp = 0;
        paramp.hAE = false;
        paramp.IUl = false;
        paramp.IUr = false;
        paramp.IFh = 0;
        paramp.mfy.clear();
        paramp.IUs = false;
        Object localObject2 = paramString.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          paramString = (cbi)((Iterator)localObject2).next();
          label601:
          label620:
          int i;
          if ((paramString.aakz == null) || (paramString.aakz.size() == 0))
          {
            paramInt1 = 1;
            if ((paramString.aakA != null) && (paramString.aakA.size() != 0)) {
              break label725;
            }
            paramInt2 = 1;
            if ((paramString.aakD != null) && (paramString.aakD.size() != 0)) {
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
          for (paramString = paramp.context.getString(h.i.IbQ, new Object[] { localObject1 });; paramString = paramp.context.getString(h.i.IbP))
          {
            paramp.mfy.add(r.b.cd(6, paramString));
            paramp.IUs = true;
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
          paramp.mfy.add(r.b.cd(0, paramString.hAP));
          if (!paramp.IUs)
          {
            ((r.b)paramp.mfy.get(paramp.mfy.size() - 1)).IUH = true;
            paramp.IUs = true;
          }
          Object localObject5;
          if ((paramString.type == 4) && (paramString.aakD != null))
          {
            localObject3 = paramString.aakD.iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject5 = (cbj)((Iterator)localObject3).next();
              localObject4 = new r.b();
              ((r.b)localObject4).type = 3;
              ((r.b)localObject4).appId = ((cbj)localObject5).aakG.oOI;
              ((r.b)localObject4).name = ((cbj)localObject5).aakG.IGU;
              ((r.b)localObject4).remark = ((cbj)localObject5).aakG.Zpa;
              ((r.b)localObject4).iconUrl = ((cbj)localObject5).aakG.IHo;
              ((r.b)localObject4).brief = ((cbj)localObject5).aakG.IGV;
              ((r.b)localObject4).IUC = ((cbj)localObject5).aakG.aakn;
              ((r.b)localObject4).actionType = ((cbj)localObject5).aakG.YVh;
              ((r.b)localObject4).IUD = ((cbj)localObject5).aakG.aako;
              ((r.b)localObject4).IUE = ((cbj)localObject5).aakH;
              ((r.b)localObject4).IUJ = new r.c(((cbj)localObject5).aakG.YVh, 4, ((cbj)localObject5).aakG.oOI, ((cbj)localObject5).aakG.aako);
              ((r.b)localObject4).hAB = ((String)localObject1);
              ((r.b)localObject4).IUJ.IUK = "3";
              localObject5 = ((r.b)localObject4).IUJ;
              paramInt1 = paramp.IUn;
              paramp.IUn = (paramInt1 + 1);
              ((r.c)localObject5).position = (paramInt1 + 601);
              paramp.mfy.add(localObject4);
            }
          }
          if (((paramString.type == 1) || (paramString.type == 2)) && (paramString.aakz != null))
          {
            localObject3 = paramString.aakz.iterator();
            if (((Iterator)localObject3).hasNext())
            {
              localObject5 = (cbc)((Iterator)localObject3).next();
              localObject4 = new r.b();
              ((r.b)localObject4).type = 1;
              ((r.b)localObject4).appId = ((cbc)localObject5).oOI;
              ((r.b)localObject4).name = ((cbc)localObject5).IGU;
              ((r.b)localObject4).remark = ((cbc)localObject5).Zpa;
              ((r.b)localObject4).iconUrl = ((cbc)localObject5).IHo;
              ((r.b)localObject4).brief = ((cbc)localObject5).IGV;
              ((r.b)localObject4).IUC = ((cbc)localObject5).aakn;
              ((r.b)localObject4).actionType = ((cbc)localObject5).YVh;
              ((r.b)localObject4).IUD = ((cbc)localObject5).aako;
              ((r.b)localObject4).IUJ = new r.c(((cbc)localObject5).YVh, 1, ((cbc)localObject5).oOI, ((cbc)localObject5).aako);
              ((r.b)localObject4).hAB = ((String)localObject1);
              if (paramString.type == 1)
              {
                paramp.hAE = true;
                localObject5 = ((r.b)localObject4).IUJ;
                paramInt1 = paramp.IRT;
                paramp.IRT = (paramInt1 + 1);
                ((r.c)localObject5).position = (paramInt1 + 1);
              }
              for (;;)
              {
                ((r.b)localObject4).IUJ.IUK = "1";
                paramp.mfy.add(localObject4);
                break;
                if (paramString.type == 2)
                {
                  paramp.IUl = true;
                  localObject5 = ((r.b)localObject4).IUJ;
                  paramInt1 = paramp.IUm;
                  paramp.IUm = (paramInt1 + 1);
                  ((r.c)localObject5).position = (paramInt1 + 1);
                }
              }
            }
          }
          else if ((paramString.type == 3) && (paramString.aakA != null))
          {
            paramp.IFh = paramString.aakE;
            paramp.IUr = paramString.aakF;
            localObject3 = paramString.aakA.iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = r.b.a((cbk)((Iterator)localObject3).next());
              ((r.b)localObject4).hAB = ((String)localObject1);
              ((r.b)localObject4).IUJ.appId = ((r.b)localObject4).appId;
              ((r.b)localObject4).IUJ.IUF = ((r.b)localObject4).IUF;
              ((r.b)localObject4).IUJ.IUG = ((r.b)localObject4).IUG;
              ((r.b)localObject4).IUJ.IUK = "2";
              localObject5 = ((r.b)localObject4).IUJ;
              paramInt1 = paramp.IUo;
              paramp.IUo = (paramInt1 + 1);
              ((r.c)localObject5).position = (paramInt1 + 301);
              paramp.mfy.add(localObject4);
            }
          }
          if ((!Util.isNullOrNil(paramString.aakB)) && (!Util.isNullOrNil(paramString.aakC)) && (paramString.type == 1))
          {
            localObject3 = paramString.aakB;
            paramString = paramString.aakC;
            localObject4 = new r.b();
            ((r.b)localObject4).type = 5;
            ((r.b)localObject4).name = ((String)localObject3);
            ((r.b)localObject4).IUJ = new r.c(paramString);
            ((r.b)localObject4).IUJ.appId = "wx62d9035fd4fd2059";
            ((r.b)localObject4).IUJ.IUK = "1";
            ((r.b)localObject4).IUJ.position = 300;
            paramp.mfy.add(localObject4);
          }
        }
        paramString = paramp.mfy.iterator();
        while (paramString.hasNext())
        {
          localObject1 = (r.b)paramString.next();
          if (paramp.hAE) {
            ((r.b)localObject1).IUJ.hYi = 1403;
          } else if (paramp.IUl) {
            ((r.b)localObject1).IUJ.hYi = 1404;
          } else {
            ((r.b)localObject1).IUJ.hYi = 1405;
          }
        }
        paramp.notifyDataSetChanged();
      }
      label1767:
      Bt(2);
      AppMethodBeat.o(42400);
      return;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(42400);
        return;
      }
      paramString = ((al)paramp).hAB;
      Object localObject1 = ((cbe)c.c.b(((al)paramp).mtC.otC)).hAP;
      paramp = ((cbe)c.c.b(((al)paramp).mtC.otC)).aaku;
      this.IUX.a(paramString, (String)localObject1, paramp);
      Bt(5);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameSearchUI
 * JD-Core Version:    0.7.0.1
 */