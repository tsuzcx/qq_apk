package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.game.report.g;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.plugin.game.h.h;
import com.tencent.mm.plugin.game.h.i;
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
  implements com.tencent.mm.am.h
{
  private boolean Hvv;
  private int IFc;
  private int IFh;
  private ListView INC;
  private l IND;
  private boolean INE;
  private boolean INF;
  private m.a INI;
  private AbsListView.OnScrollListener INJ;
  private k INv;
  private GameBannerView ISc;
  private GameLibraryCategoriesView ISd;
  private View ISe;
  private TextView ISf;
  private View ISg;
  private GameDropdownView ISh;
  private HashMap<Integer, String> ISi;
  private int ISj;
  private View ISk;
  private Button ISl;
  private boolean ISm;
  private int ISn;
  private int ISo;
  private View.OnClickListener ISp;
  private View.OnClickListener ISq;
  private GameDropdownView.a ISr;
  private View lNf;
  private boolean mgS;
  private Dialog ysC;
  
  public GameLibraryUI()
  {
    AppMethodBeat.i(42230);
    this.ISj = 0;
    this.Hvv = false;
    this.INE = false;
    this.IFh = 0;
    this.INF = true;
    this.ISm = false;
    this.mgS = true;
    this.IFc = 0;
    this.ISn = 990;
    this.ISo = 0;
    this.INv = new k();
    this.INI = new m.a()
    {
      public final void XG(int paramAnonymousInt)
      {
        AppMethodBeat.i(42221);
        int i = GameLibraryUI.b(GameLibraryUI.this).getFirstVisiblePosition() - GameLibraryUI.c(GameLibraryUI.this);
        int j = GameLibraryUI.b(GameLibraryUI.this).getLastVisiblePosition();
        int k = GameLibraryUI.c(GameLibraryUI.this);
        if ((paramAnonymousInt >= i) && (paramAnonymousInt <= j - k))
        {
          View localView = GameLibraryUI.b(GameLibraryUI.this).getChildAt(paramAnonymousInt - i);
          GameLibraryUI.d(GameLibraryUI.this).aA(localView, paramAnonymousInt);
        }
        AppMethodBeat.o(42221);
      }
    };
    this.ISp = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42224);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameLibraryUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        com.tencent.mm.plugin.game.d.c.b(paramAnonymousView, GameLibraryUI.this);
        g.a(GameLibraryUI.this, 11, 1110, 999, 7, GameLibraryUI.e(GameLibraryUI.this), null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameLibraryUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42224);
      }
    };
    this.ISq = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42225);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameLibraryUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
        if ((paramAnonymousView.getTag() instanceof String)) {
          com.tencent.mm.plugin.game.d.c.b(paramAnonymousView, GameLibraryUI.this);
        }
        for (int i = 7;; i = 6)
        {
          g.a(GameLibraryUI.this, 11, 1113, 1, i, GameLibraryUI.e(GameLibraryUI.this), null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameLibraryUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(42225);
          return;
          localObject = new Intent(GameLibraryUI.this, GameCategoryUI.class);
          ((Intent)localObject).putExtra("extra_type", 2);
          ((Intent)localObject).putExtra("extra_category_name", GameLibraryUI.this.getString(h.i.Ibg));
          ((Intent)localObject).putExtra("game_report_from_scene", 1113);
          paramAnonymousView = GameLibraryUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/game/ui/GameLibraryUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/game/ui/GameLibraryUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
    };
    this.ISr = new GameDropdownView.a()
    {
      public final void XJ(int paramAnonymousInt)
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
        GameLibraryUI.h(GameLibraryUI.this);
        GameLibraryUI.i(GameLibraryUI.this);
        g.a(GameLibraryUI.this, 11, 1111, GameLibraryUI.g(GameLibraryUI.this) + GameLibraryUI.j(GameLibraryUI.this), 2, GameLibraryUI.e(GameLibraryUI.this), null);
        AppMethodBeat.o(42226);
      }
    };
    this.INJ = new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(42227);
        if ((paramAnonymousInt == 0) && (paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1))
        {
          if ((!GameLibraryUI.k(GameLibraryUI.this)) || (GameLibraryUI.l(GameLibraryUI.this)))
          {
            AppMethodBeat.o(42227);
            return;
          }
          GameLibraryUI.m(GameLibraryUI.this).setVisibility(0);
          GameLibraryUI.i(GameLibraryUI.this);
        }
        AppMethodBeat.o(42227);
      }
    };
    AppMethodBeat.o(42230);
  }
  
  private void fHt()
  {
    AppMethodBeat.i(42238);
    Object localObject = getIntent().getStringExtra("jump_game_center");
    if ((!Util.isNullOrNil((String)localObject)) && (((String)localObject).equals("jump_game_center")))
    {
      localObject = new Intent(this, GameCenterUI.class);
      ((Intent)localObject).putExtra("jump_find_more_friends", "jump_find_more_friends");
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/game/ui/GameLibraryUI", "backToGameCenterUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/game/ui/GameLibraryUI", "backToGameCenterUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(42238);
  }
  
  private void fHw()
  {
    AppMethodBeat.i(42239);
    Object localObject = e.fFU();
    int i = this.IFh;
    int j = this.ISj;
    if (this.IFh == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new aq(i, (LinkedList)localObject, j, bool);
      com.tencent.mm.kernel.h.aZW().a((p)localObject, 0);
      this.INE = true;
      AppMethodBeat.o(42239);
      return;
    }
  }
  
  private void goBack()
  {
    AppMethodBeat.i(42237);
    fHt();
    finish();
    AppMethodBeat.o(42237);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return h.f.HZH;
  }
  
  public void initView()
  {
    AppMethodBeat.i(42236);
    setMMTitle(h.i.HZH);
    setBackBtn(new GameLibraryUI.1(this));
    if (!Util.isNullOrNil(e.fGi())) {
      addIconOptionMenu(0, h.i.top_item_desc_search, h.h.actionbar_icon_dark_search, new GameLibraryUI.2(this));
    }
    this.INC = ((ListView)findViewById(h.e.HVS));
    this.INC.setOnItemClickListener(this.INv);
    this.INv.setSourceScene(this.IFc);
    this.INC.setOnScrollListener(this.INJ);
    this.IND = new l(this);
    this.IND.setSourceScene(this.IFc);
    this.IND.a(this.INI);
    LayoutInflater localLayoutInflater = (LayoutInflater)getContext().getSystemService("layout_inflater");
    Object localObject = localLayoutInflater.inflate(h.f.HVV, this.INC, false);
    this.ISc = ((GameBannerView)((View)localObject).findViewById(h.e.HVV));
    this.ISc.setSourceScene(this.IFc);
    this.INC.addHeaderView((View)localObject);
    this.ISo += 1;
    this.ISd = ((GameLibraryCategoriesView)localLayoutInflater.inflate(h.f.HZJ, this.INC, false));
    localObject = new LinearLayout(this);
    ((LinearLayout)localObject).addView(this.ISd);
    this.INC.addHeaderView((View)localObject);
    this.ISo += 1;
    this.ISe = localLayoutInflater.inflate(h.f.HZN, this.INC, false);
    this.ISe.setOnClickListener(this.ISp);
    this.ISf = ((TextView)this.ISe.findViewById(h.e.HVU));
    this.ISg = localLayoutInflater.inflate(h.f.HZI, this.INC, false);
    this.ISg.setOnClickListener(null);
    this.ISh = ((GameDropdownView)this.ISg.findViewById(h.e.HVQ));
    this.ISh.setAnchorView(this.ISg);
    this.ISh.setOnSelectionChangedListener(this.ISr);
    this.lNf = localLayoutInflater.inflate(h.f.HZP, this.INC, false);
    this.lNf.setVisibility(8);
    localObject = new LinearLayout(this);
    ((LinearLayout)localObject).addView(this.lNf);
    this.INC.addFooterView((View)localObject);
    this.ISk = localLayoutInflater.inflate(h.f.HZM, this.INC, false);
    this.ISk.setVisibility(8);
    this.ISl = ((Button)this.ISk.findViewById(h.e.HVT));
    this.ISl.setOnClickListener(this.ISq);
    this.INC.addFooterView(this.ISk);
    this.INC.setAdapter(this.IND);
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
    if (!com.tencent.mm.kernel.h.baz())
    {
      Log.e("MicroMsg.GameLibraryUI", "account not ready");
      finish();
      AppMethodBeat.o(42231);
      return;
    }
    this.IFc = getIntent().getIntExtra("game_report_from_scene", 0);
    com.tencent.mm.kernel.h.aZW().a(1218, this);
    initView();
    paramBundle = ((f)com.tencent.mm.kernel.h.ax(f.class)).fCi().aFI("pb_library");
    if (paramBundle == null) {
      Log.i("MicroMsg.GameLibraryUI", "No cache found");
    }
    for (int i = 0;; i = 1)
    {
      if (i == 0)
      {
        this.ysC = com.tencent.mm.plugin.game.d.c.hY(this);
        this.ysC.show();
      }
      fHw();
      g.a(this, 11, 1100, 0, 1, this.IFc, null);
      AppMethodBeat.o(42231);
      return;
      com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(42223);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42222);
              GameLibraryUI.a(GameLibraryUI.this, this.ISt, false);
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
    com.tencent.mm.kernel.h.aZW().b(1218, this);
    this.IND.clear();
    if (this.ISc != null) {
      this.ISc.INf.stopTimer();
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
    if (this.ISc != null)
    {
      GameBannerView localGameBannerView = this.ISc;
      if (localGameBannerView.INf != null)
      {
        localGameBannerView.INf.stopTimer();
        Log.i("MicroMsg.GameBannerView", "Auto scroll stopped");
      }
    }
    AppMethodBeat.o(42233);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(42232);
    super.onResume();
    if (!com.tencent.mm.kernel.h.baz())
    {
      Log.e("MicroMsg.GameLibraryUI", "account not ready");
      AppMethodBeat.o(42232);
      return;
    }
    this.IND.bDL();
    if ((!this.mgS) && (this.ISc != null))
    {
      GameBannerView localGameBannerView = this.ISc;
      if ((localGameBannerView.INf != null) && (localGameBannerView.INf.stopped()) && (localGameBannerView.INe.size() > 1))
      {
        localGameBannerView.INf.startTimer(5000L);
        Log.i("MicroMsg.GameBannerView", "Auto scroll restarted");
      }
    }
    if (this.mgS) {
      this.mgS = false;
    }
    AppMethodBeat.o(42232);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, p paramp)
  {
    AppMethodBeat.i(42240);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      switch (paramp.getType())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(42240);
        return;
        paramString = c.c.b(((aq)paramp).mtC.otC);
        com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(42229);
            Object localObject = paramString;
            if ((GameLibraryUI.n(GameLibraryUI.this) == 0) && (!GameLibraryUI.o(GameLibraryUI.this))) {}
            for (boolean bool = true;; bool = false)
            {
              localObject = new ae((com.tencent.mm.bx.a)localObject, bool, GameLibraryUI.n(GameLibraryUI.this));
              GameLibraryUI.p(GameLibraryUI.this);
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(42228);
                  GameLibraryUI localGameLibraryUI = GameLibraryUI.this;
                  ae localae = this.ISt;
                  if (GameLibraryUI.n(GameLibraryUI.this) != 0) {}
                  for (boolean bool = true;; bool = false)
                  {
                    GameLibraryUI.a(localGameLibraryUI, localae, bool);
                    GameLibraryUI.q(GameLibraryUI.this);
                    GameLibraryUI.m(GameLibraryUI.this).setVisibility(8);
                    GameLibraryUI.r(GameLibraryUI.this);
                    if (GameLibraryUI.s(GameLibraryUI.this) != null) {
                      GameLibraryUI.s(GameLibraryUI.this).dismiss();
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
    if (!com.tencent.mm.plugin.game.a.a.pFo.a(this, paramInt1, paramInt2, paramString)) {
      Toast.makeText(this, getString(h.i.Ibn, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    if (this.ysC != null) {
      this.ysC.cancel();
    }
    AppMethodBeat.o(42240);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameLibraryUI
 * JD-Core Version:    0.7.0.1
 */