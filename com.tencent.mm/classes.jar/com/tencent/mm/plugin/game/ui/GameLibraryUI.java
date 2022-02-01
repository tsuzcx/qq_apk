package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
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
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.ae;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.LinkedList;

public class GameLibraryUI
  extends MMActivity
  implements com.tencent.mm.al.f
{
  private View fTl;
  private boolean gjj;
  private Dialog qdv;
  private boolean twO;
  private int udq;
  private int udv;
  private ListView ulG;
  private l ulH;
  private boolean ulI;
  private boolean ulJ;
  private m.a ulM;
  private AbsListView.OnScrollListener ulN;
  private k ulz;
  private GameBannerView uqh;
  private GameLibraryCategoriesView uqi;
  private View uqj;
  private TextView uqk;
  private View uql;
  private GameDropdownView uqm;
  private HashMap<Integer, String> uqn;
  private int uqo;
  private View uqp;
  private Button uqq;
  private boolean uqr;
  private int uqs;
  private int uqt;
  private View.OnClickListener uqu;
  private View.OnClickListener uqv;
  private GameDropdownView.a uqw;
  
  public GameLibraryUI()
  {
    AppMethodBeat.i(42230);
    this.uqo = 0;
    this.twO = false;
    this.ulI = false;
    this.udv = 0;
    this.ulJ = true;
    this.uqr = false;
    this.gjj = true;
    this.udq = 0;
    this.uqs = 990;
    this.uqt = 0;
    this.ulz = new k();
    this.ulM = new m.a()
    {
      public final void HT(int paramAnonymousInt)
      {
        AppMethodBeat.i(42221);
        int i = GameLibraryUI.b(GameLibraryUI.this).getFirstVisiblePosition() - GameLibraryUI.c(GameLibraryUI.this);
        int j = GameLibraryUI.b(GameLibraryUI.this).getLastVisiblePosition();
        int k = GameLibraryUI.c(GameLibraryUI.this);
        if ((paramAnonymousInt >= i) && (paramAnonymousInt <= j - k))
        {
          View localView = GameLibraryUI.b(GameLibraryUI.this).getChildAt(paramAnonymousInt - i);
          GameLibraryUI.d(GameLibraryUI.this).ah(localView, paramAnonymousInt);
        }
        AppMethodBeat.o(42221);
      }
    };
    this.uqu = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42224);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameLibraryUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        c.a(paramAnonymousView, GameLibraryUI.this);
        com.tencent.mm.game.report.f.a(GameLibraryUI.this, 11, 1110, 999, 7, GameLibraryUI.e(GameLibraryUI.this), null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameLibraryUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42224);
      }
    };
    this.uqv = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42225);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameLibraryUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        if ((paramAnonymousView.getTag() instanceof String)) {
          c.a(paramAnonymousView, GameLibraryUI.this);
        }
        for (int i = 7;; i = 6)
        {
          com.tencent.mm.game.report.f.a(GameLibraryUI.this, 11, 1113, 1, i, GameLibraryUI.e(GameLibraryUI.this), null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameLibraryUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(42225);
          return;
          localObject = new Intent(GameLibraryUI.this, GameCategoryUI.class);
          ((Intent)localObject).putExtra("extra_type", 2);
          ((Intent)localObject).putExtra("extra_category_name", GameLibraryUI.this.getString(2131759898));
          ((Intent)localObject).putExtra("game_report_from_scene", 1113);
          paramAnonymousView = GameLibraryUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/game/ui/GameLibraryUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/game/ui/GameLibraryUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
    };
    this.uqw = new GameDropdownView.a()
    {
      public final void HW(int paramAnonymousInt)
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
        ad.i("MicroMsg.GameLibraryUI", "Selected SortType: %d", new Object[] { Integer.valueOf(GameLibraryUI.g(GameLibraryUI.this)) });
        GameLibraryUI.b(GameLibraryUI.this, 0);
        GameLibraryUI.h(GameLibraryUI.this);
        com.tencent.mm.game.report.f.a(GameLibraryUI.this, 11, 1111, GameLibraryUI.g(GameLibraryUI.this) + GameLibraryUI.i(GameLibraryUI.this), 2, GameLibraryUI.e(GameLibraryUI.this), null);
        AppMethodBeat.o(42226);
      }
    };
    this.ulN = new AbsListView.OnScrollListener()
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
  
  private void cZV()
  {
    AppMethodBeat.i(42238);
    Object localObject = getIntent().getStringExtra("jump_game_center");
    if ((!bt.isNullOrNil((String)localObject)) && (((String)localObject).equals("jump_game_center")))
    {
      localObject = new Intent(this, GameCenterUI.class);
      ((Intent)localObject).putExtra("jump_find_more_friends", "jump_find_more_friends");
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/game/ui/GameLibraryUI", "backToGameCenterUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameLibraryUI", "backToGameCenterUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(42238);
  }
  
  private void daa()
  {
    AppMethodBeat.i(42239);
    Object localObject = e.cYA();
    int i = this.udv;
    int j = this.uqo;
    if (this.udv == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new com.tencent.mm.plugin.game.model.aq(i, (LinkedList)localObject, j, bool);
      g.aiU().a((n)localObject, 0);
      this.ulI = true;
      AppMethodBeat.o(42239);
      return;
    }
  }
  
  private void goBack()
  {
    AppMethodBeat.i(42237);
    cZV();
    finish();
    AppMethodBeat.o(42237);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494327;
  }
  
  public void initView()
  {
    AppMethodBeat.i(42236);
    setMMTitle(2131759895);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(42219);
        GameLibraryUI.a(GameLibraryUI.this);
        AppMethodBeat.o(42219);
        return true;
      }
    });
    if (!bt.isNullOrNil(e.cYO())) {
      addIconOptionMenu(0, 2131764452, 2131689494, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(42220);
          Object localObject = new Intent(GameLibraryUI.this, GameSearchUI.class);
          ((Intent)localObject).putExtra("game_report_from_scene", 1109);
          paramAnonymousMenuItem = GameLibraryUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/game/ui/GameLibraryUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/plugin/game/ui/GameLibraryUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(42220);
          return true;
        }
      });
    }
    this.ulG = ((ListView)findViewById(2131300492));
    this.ulG.setOnItemClickListener(this.ulz);
    this.ulz.setSourceScene(this.udq);
    this.ulG.setOnScrollListener(this.ulN);
    this.ulH = new l(this);
    this.ulH.setSourceScene(this.udq);
    this.ulH.a(this.ulM);
    LayoutInflater localLayoutInflater = (LayoutInflater)getContext().getSystemService("layout_inflater");
    Object localObject = localLayoutInflater.inflate(2131494335, this.ulG, false);
    this.uqh = ((GameBannerView)((View)localObject).findViewById(2131300496));
    this.uqh.setSourceScene(this.udq);
    this.ulG.addHeaderView((View)localObject);
    this.uqt += 1;
    this.uqi = ((GameLibraryCategoriesView)localLayoutInflater.inflate(2131494329, this.ulG, false));
    localObject = new LinearLayout(this);
    ((LinearLayout)localObject).addView(this.uqi);
    this.ulG.addHeaderView((View)localObject);
    this.uqt += 1;
    this.uqj = localLayoutInflater.inflate(2131494334, this.ulG, false);
    this.uqj.setOnClickListener(this.uqu);
    this.uqk = ((TextView)this.uqj.findViewById(2131300494));
    this.uql = localLayoutInflater.inflate(2131494328, this.ulG, false);
    this.uql.setOnClickListener(null);
    this.uqm = ((GameDropdownView)this.uql.findViewById(2131300486));
    this.uqm.setAnchorView(this.uql);
    this.uqm.setOnSelectionChangedListener(this.uqw);
    this.fTl = localLayoutInflater.inflate(2131494337, this.ulG, false);
    this.fTl.setVisibility(8);
    localObject = new LinearLayout(this);
    ((LinearLayout)localObject).addView(this.fTl);
    this.ulG.addFooterView((View)localObject);
    this.uqp = localLayoutInflater.inflate(2131494333, this.ulG, false);
    this.uqp.setVisibility(8);
    this.uqq = ((Button)this.uqp.findViewById(2131300493));
    this.uqq.setOnClickListener(this.uqv);
    this.ulG.addFooterView(this.uqp);
    this.ulG.setAdapter(this.ulH);
    AppMethodBeat.o(42236);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(42241);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ad.i("MicroMsg.GameLibraryUI", "requestCode = %d, resultCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 != 1)
    {
      ad.e("MicroMsg.GameLibraryUI", "error request code");
      AppMethodBeat.o(42241);
      return;
    }
    AppMethodBeat.o(42241);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(42231);
    super.onCreate(paramBundle);
    if (!g.ajx())
    {
      ad.e("MicroMsg.GameLibraryUI", "account not ready");
      finish();
      AppMethodBeat.o(42231);
      return;
    }
    this.udq = getIntent().getIntExtra("game_report_from_scene", 0);
    g.aiU().a(1218, this);
    initView();
    paramBundle = ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cWI().all("pb_library");
    if (paramBundle == null) {
      ad.i("MicroMsg.GameLibraryUI", "No cache found");
    }
    for (int i = 0;; i = 1)
    {
      if (i == 0)
      {
        this.qdv = c.fA(this);
        this.qdv.show();
      }
      daa();
      com.tencent.mm.game.report.f.a(this, 11, 1100, 0, 1, this.udq, null);
      AppMethodBeat.o(42231);
      return;
      g.ajF().ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(42223);
          com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42222);
              GameLibraryUI.a(GameLibraryUI.this, this.uqy, false);
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
    ad.i("MicroMsg.GameLibraryUI", "onDestroy");
    super.onDestroy();
    g.aiU().b(1218, this);
    this.ulH.clear();
    if (this.uqh != null) {
      this.uqh.ulh.stopTimer();
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
    if (this.uqh != null)
    {
      GameBannerView localGameBannerView = this.uqh;
      if (localGameBannerView.ulh != null)
      {
        localGameBannerView.ulh.stopTimer();
        ad.i("MicroMsg.GameBannerView", "Auto scroll stopped");
      }
    }
    AppMethodBeat.o(42233);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(42232);
    super.onResume();
    if (!g.ajx())
    {
      ad.e("MicroMsg.GameLibraryUI", "account not ready");
      AppMethodBeat.o(42232);
      return;
    }
    this.ulH.refresh();
    if ((!this.gjj) && (this.uqh != null))
    {
      GameBannerView localGameBannerView = this.uqh;
      if ((localGameBannerView.ulh != null) && (localGameBannerView.ulh.fkZ()) && (localGameBannerView.ulg.size() > 1))
      {
        localGameBannerView.ulh.az(5000L, 5000L);
        ad.i("MicroMsg.GameBannerView", "Auto scroll restarted");
      }
    }
    if (this.gjj) {
      this.gjj = false;
    }
    AppMethodBeat.o(42232);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(42240);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      switch (paramn.getType())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(42240);
        return;
        paramString = ((com.tencent.mm.plugin.game.model.aq)paramn).grW.hNL.hNQ;
        g.ajF().ay(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(42229);
            Object localObject = paramString;
            if ((GameLibraryUI.m(GameLibraryUI.this) == 0) && (!GameLibraryUI.n(GameLibraryUI.this))) {}
            for (boolean bool = true;; bool = false)
            {
              localObject = new ae((com.tencent.mm.bx.a)localObject, bool, GameLibraryUI.m(GameLibraryUI.this));
              GameLibraryUI.o(GameLibraryUI.this);
              com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(42228);
                  GameLibraryUI localGameLibraryUI = GameLibraryUI.this;
                  ae localae = this.uqy;
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
    if (!com.tencent.mm.plugin.game.a.a.iRH.a(this, paramInt1, paramInt2, paramString)) {
      Toast.makeText(this, getString(2131759916, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    if (this.qdv != null) {
      this.qdv.cancel();
    }
    AppMethodBeat.o(42240);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameLibraryUI
 * JD-Core Version:    0.7.0.1
 */