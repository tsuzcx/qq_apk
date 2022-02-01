package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.ae;
import com.tencent.mm.plugin.game.model.aq;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.LinkedList;

public class GameLibraryUI
  extends MMActivity
  implements i
{
  private View gAy;
  private boolean gWt;
  private Dialog rAV;
  private boolean wYE;
  private int xGR;
  private int xGW;
  private k xOW;
  private ListView xPd;
  private l xPe;
  private boolean xPf;
  private boolean xPg;
  private m.a xPj;
  private AbsListView.OnScrollListener xPk;
  private GameBannerView xTB;
  private GameLibraryCategoriesView xTC;
  private View xTD;
  private TextView xTE;
  private View xTF;
  private GameDropdownView xTG;
  private HashMap<Integer, String> xTH;
  private int xTI;
  private View xTJ;
  private Button xTK;
  private boolean xTL;
  private int xTM;
  private int xTN;
  private View.OnClickListener xTO;
  private View.OnClickListener xTP;
  private GameDropdownView.a xTQ;
  
  public GameLibraryUI()
  {
    AppMethodBeat.i(42230);
    this.xTI = 0;
    this.wYE = false;
    this.xPf = false;
    this.xGW = 0;
    this.xPg = true;
    this.xTL = false;
    this.gWt = true;
    this.xGR = 0;
    this.xTM = 990;
    this.xTN = 0;
    this.xOW = new k();
    this.xPj = new m.a()
    {
      public final void Os(int paramAnonymousInt)
      {
        AppMethodBeat.i(42221);
        int i = GameLibraryUI.b(GameLibraryUI.this).getFirstVisiblePosition() - GameLibraryUI.c(GameLibraryUI.this);
        int j = GameLibraryUI.b(GameLibraryUI.this).getLastVisiblePosition();
        int k = GameLibraryUI.c(GameLibraryUI.this);
        if ((paramAnonymousInt >= i) && (paramAnonymousInt <= j - k))
        {
          View localView = GameLibraryUI.b(GameLibraryUI.this).getChildAt(paramAnonymousInt - i);
          GameLibraryUI.d(GameLibraryUI.this).aj(localView, paramAnonymousInt);
        }
        AppMethodBeat.o(42221);
      }
    };
    this.xTO = new GameLibraryUI.5(this);
    this.xTP = new GameLibraryUI.6(this);
    this.xTQ = new GameDropdownView.a()
    {
      public final void Ov(int paramAnonymousInt)
      {
        AppMethodBeat.i(42226);
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.addAll(GameLibraryUI.f(GameLibraryUI.this).keySet());
        if (paramAnonymousInt > localLinkedList.size() - 1)
        {
          AppMethodBeat.o(42226);
          return;
        }
        GameLibraryUI.a(GameLibraryUI.this, ((Integer)localLinkedList.get(paramAnonymousInt)).intValue());
        Log.i("MicroMsg.GameLibraryUI", "Selected SortType: %d", new Object[] { Integer.valueOf(GameLibraryUI.g(GameLibraryUI.this)) });
        GameLibraryUI.b(GameLibraryUI.this, 0);
        GameLibraryUI.h(GameLibraryUI.this);
        com.tencent.mm.game.report.f.a(GameLibraryUI.this, 11, 1111, GameLibraryUI.g(GameLibraryUI.this) + GameLibraryUI.i(GameLibraryUI.this), 2, GameLibraryUI.e(GameLibraryUI.this), null);
        AppMethodBeat.o(42226);
      }
    };
    this.xPk = new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(42227);
        if ((paramAnonymousInt == 0) && (paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1))
        {
          if ((!GameLibraryUI.j(GameLibraryUI.this)) || (GameLibraryUI.k(GameLibraryUI.this)))
          {
            AppMethodBeat.o(42227);
            return;
          }
          GameLibraryUI.l(GameLibraryUI.this).setVisibility(0);
          GameLibraryUI.h(GameLibraryUI.this);
        }
        AppMethodBeat.o(42227);
      }
    };
    AppMethodBeat.o(42230);
  }
  
  private void dWn()
  {
    AppMethodBeat.i(42238);
    Object localObject = getIntent().getStringExtra("jump_game_center");
    if ((!Util.isNullOrNil((String)localObject)) && (((String)localObject).equals("jump_game_center")))
    {
      localObject = new Intent(this, GameCenterUI.class);
      ((Intent)localObject).putExtra("jump_find_more_friends", "jump_find_more_friends");
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/game/ui/GameLibraryUI", "backToGameCenterUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameLibraryUI", "backToGameCenterUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(42238);
  }
  
  private void dWs()
  {
    AppMethodBeat.i(42239);
    Object localObject = e.dUR();
    int i = this.xGW;
    int j = this.xTI;
    if (this.xGW == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new aq(i, (LinkedList)localObject, j, bool);
      g.azz().a((q)localObject, 0);
      this.xPf = true;
      AppMethodBeat.o(42239);
      return;
    }
  }
  
  private void goBack()
  {
    AppMethodBeat.i(42237);
    dWn();
    finish();
    AppMethodBeat.o(42237);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494891;
  }
  
  public void initView()
  {
    AppMethodBeat.i(42236);
    setMMTitle(2131761233);
    setBackBtn(new GameLibraryUI.1(this));
    if (!Util.isNullOrNil(e.dVf())) {
      addIconOptionMenu(0, 2131766796, 2131689496, new GameLibraryUI.2(this));
    }
    this.xPd = ((ListView)findViewById(2131302015));
    this.xPd.setOnItemClickListener(this.xOW);
    this.xOW.setSourceScene(this.xGR);
    this.xPd.setOnScrollListener(this.xPk);
    this.xPe = new l(this);
    this.xPe.setSourceScene(this.xGR);
    this.xPe.a(this.xPj);
    LayoutInflater localLayoutInflater = (LayoutInflater)getContext().getSystemService("layout_inflater");
    Object localObject = localLayoutInflater.inflate(2131494899, this.xPd, false);
    this.xTB = ((GameBannerView)((View)localObject).findViewById(2131302019));
    this.xTB.setSourceScene(this.xGR);
    this.xPd.addHeaderView((View)localObject);
    this.xTN += 1;
    this.xTC = ((GameLibraryCategoriesView)localLayoutInflater.inflate(2131494893, this.xPd, false));
    localObject = new LinearLayout(this);
    ((LinearLayout)localObject).addView(this.xTC);
    this.xPd.addHeaderView((View)localObject);
    this.xTN += 1;
    this.xTD = localLayoutInflater.inflate(2131494898, this.xPd, false);
    this.xTD.setOnClickListener(this.xTO);
    this.xTE = ((TextView)this.xTD.findViewById(2131302017));
    this.xTF = localLayoutInflater.inflate(2131494892, this.xPd, false);
    this.xTF.setOnClickListener(null);
    this.xTG = ((GameDropdownView)this.xTF.findViewById(2131302009));
    this.xTG.setAnchorView(this.xTF);
    this.xTG.setOnSelectionChangedListener(this.xTQ);
    this.gAy = localLayoutInflater.inflate(2131494902, this.xPd, false);
    this.gAy.setVisibility(8);
    localObject = new LinearLayout(this);
    ((LinearLayout)localObject).addView(this.gAy);
    this.xPd.addFooterView((View)localObject);
    this.xTJ = localLayoutInflater.inflate(2131494897, this.xPd, false);
    this.xTJ.setVisibility(8);
    this.xTK = ((Button)this.xTJ.findViewById(2131302016));
    this.xTK.setOnClickListener(this.xTP);
    this.xPd.addFooterView(this.xTJ);
    this.xPd.setAdapter(this.xPe);
    AppMethodBeat.o(42236);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(42241);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i("MicroMsg.GameLibraryUI", "requestCode = %d, resultCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 != 1)
    {
      Log.e("MicroMsg.GameLibraryUI", "error request code");
      AppMethodBeat.o(42241);
      return;
    }
    AppMethodBeat.o(42241);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(42231);
    super.onCreate(paramBundle);
    if (!g.aAc())
    {
      Log.e("MicroMsg.GameLibraryUI", "account not ready");
      finish();
      AppMethodBeat.o(42231);
      return;
    }
    this.xGR = getIntent().getIntExtra("game_report_from_scene", 0);
    g.azz().a(1218, this);
    initView();
    paramBundle = ((com.tencent.mm.plugin.game.api.f)g.af(com.tencent.mm.plugin.game.api.f.class)).dSL().azn("pb_library");
    if (paramBundle == null) {
      Log.i("MicroMsg.GameLibraryUI", "No cache found");
    }
    for (int i = 0;; i = 1)
    {
      if (i == 0)
      {
        this.rAV = c.gl(this);
        this.rAV.show();
      }
      dWs();
      com.tencent.mm.game.report.f.a(this, 11, 1100, 0, 1, this.xGR, null);
      AppMethodBeat.o(42231);
      return;
      g.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(42223);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42222);
              GameLibraryUI.a(GameLibraryUI.this, this.xTS, false);
              AppMethodBeat.o(42222);
            }
          });
          AppMethodBeat.o(42223);
        }
      });
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(42234);
    Log.i("MicroMsg.GameLibraryUI", "onDestroy");
    super.onDestroy();
    g.azz().b(1218, this);
    this.xPe.clear();
    if (this.xTB != null) {
      this.xTB.xOF.stopTimer();
    }
    AppMethodBeat.o(42234);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(42235);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      AppMethodBeat.o(42235);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(42235);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(42233);
    super.onPause();
    if (this.xTB != null)
    {
      GameBannerView localGameBannerView = this.xTB;
      if (localGameBannerView.xOF != null)
      {
        localGameBannerView.xOF.stopTimer();
        Log.i("MicroMsg.GameBannerView", "Auto scroll stopped");
      }
    }
    AppMethodBeat.o(42233);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(42232);
    super.onResume();
    if (!g.aAc())
    {
      Log.e("MicroMsg.GameLibraryUI", "account not ready");
      AppMethodBeat.o(42232);
      return;
    }
    this.xPe.refresh();
    if ((!this.gWt) && (this.xTB != null))
    {
      GameBannerView localGameBannerView = this.xTB;
      if ((localGameBannerView.xOF != null) && (localGameBannerView.xOF.stopped()) && (localGameBannerView.xOE.size() > 1))
      {
        localGameBannerView.xOF.startTimer(5000L);
        Log.i("MicroMsg.GameBannerView", "Auto scroll restarted");
      }
    }
    if (this.gWt) {
      this.gWt = false;
    }
    AppMethodBeat.o(42232);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(42240);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      switch (paramq.getType())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(42240);
        return;
        paramString = ((aq)paramq).hhm.iLL.iLR;
        g.aAk().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(42229);
            Object localObject = paramString;
            if ((GameLibraryUI.m(GameLibraryUI.this) == 0) && (!GameLibraryUI.n(GameLibraryUI.this))) {}
            for (boolean bool = true;; bool = false)
            {
              localObject = new ae((com.tencent.mm.bw.a)localObject, bool, GameLibraryUI.m(GameLibraryUI.this));
              GameLibraryUI.o(GameLibraryUI.this);
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(42228);
                  GameLibraryUI localGameLibraryUI = GameLibraryUI.this;
                  ae localae = this.xTS;
                  if (GameLibraryUI.m(GameLibraryUI.this) != 0) {}
                  for (boolean bool = true;; bool = false)
                  {
                    GameLibraryUI.a(localGameLibraryUI, localae, bool);
                    GameLibraryUI.p(GameLibraryUI.this);
                    GameLibraryUI.l(GameLibraryUI.this).setVisibility(8);
                    GameLibraryUI.b(GameLibraryUI.this, GameLibraryUI.m(GameLibraryUI.this) + 15);
                    if (GameLibraryUI.q(GameLibraryUI.this) != null) {
                      GameLibraryUI.q(GameLibraryUI.this).dismiss();
                    }
                    AppMethodBeat.o(42228);
                    return;
                  }
                }
              });
              AppMethodBeat.o(42229);
              return;
            }
          }
        });
      }
    }
    if (!com.tencent.mm.plugin.game.a.a.jRu.a(this, paramInt1, paramInt2, paramString)) {
      Toast.makeText(this, getString(2131761264, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    if (this.rAV != null) {
      this.rAV.cancel();
    }
    AppMethodBeat.o(42240);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameLibraryUI
 * JD-Core Version:    0.7.0.1
 */