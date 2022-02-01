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
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.aq;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.LinkedList;

public class GameLibraryUI
  extends MMActivity
  implements com.tencent.mm.ak.f
{
  private View fVr;
  private boolean glB;
  private Dialog qka;
  private boolean tHF;
  private GameBannerView uBD;
  private GameLibraryCategoriesView uBE;
  private View uBF;
  private TextView uBG;
  private View uBH;
  private GameDropdownView uBI;
  private HashMap<Integer, String> uBJ;
  private int uBK;
  private View uBL;
  private Button uBM;
  private boolean uBN;
  private int uBO;
  private int uBP;
  private View.OnClickListener uBQ;
  private View.OnClickListener uBR;
  private GameDropdownView.a uBS;
  private int uoD;
  private int uoy;
  private k uwW;
  private ListView uxd;
  private l uxe;
  private boolean uxf;
  private boolean uxg;
  private m.a uxj;
  private AbsListView.OnScrollListener uxk;
  
  public GameLibraryUI()
  {
    AppMethodBeat.i(42230);
    this.uBK = 0;
    this.tHF = false;
    this.uxf = false;
    this.uoD = 0;
    this.uxg = true;
    this.uBN = false;
    this.glB = true;
    this.uoy = 0;
    this.uBO = 990;
    this.uBP = 0;
    this.uwW = new k();
    this.uxj = new m.a()
    {
      public final void Ir(int paramAnonymousInt)
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
    this.uBQ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42224);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameLibraryUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        c.a(paramAnonymousView, GameLibraryUI.this);
        com.tencent.mm.game.report.f.a(GameLibraryUI.this, 11, 1110, 999, 7, GameLibraryUI.e(GameLibraryUI.this), null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameLibraryUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42224);
      }
    };
    this.uBR = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42225);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameLibraryUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
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
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/game/ui/GameLibraryUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/game/ui/GameLibraryUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
    };
    this.uBS = new GameDropdownView.a()
    {
      public final void Iu(int paramAnonymousInt)
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
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GameLibraryUI", "Selected SortType: %d", new Object[] { Integer.valueOf(GameLibraryUI.g(GameLibraryUI.this)) });
        GameLibraryUI.b(GameLibraryUI.this, 0);
        GameLibraryUI.h(GameLibraryUI.this);
        com.tencent.mm.game.report.f.a(GameLibraryUI.this, 11, 1111, GameLibraryUI.g(GameLibraryUI.this) + GameLibraryUI.i(GameLibraryUI.this), 2, GameLibraryUI.e(GameLibraryUI.this), null);
        AppMethodBeat.o(42226);
      }
    };
    this.uxk = new AbsListView.OnScrollListener()
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
  
  private void dcG()
  {
    AppMethodBeat.i(42238);
    Object localObject = getIntent().getStringExtra("jump_game_center");
    if ((!bu.isNullOrNil((String)localObject)) && (((String)localObject).equals("jump_game_center")))
    {
      localObject = new Intent(this, GameCenterUI.class);
      ((Intent)localObject).putExtra("jump_find_more_friends", "jump_find_more_friends");
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/game/ui/GameLibraryUI", "backToGameCenterUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameLibraryUI", "backToGameCenterUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(42238);
  }
  
  private void dcL()
  {
    AppMethodBeat.i(42239);
    Object localObject = e.dbk();
    int i = this.uoD;
    int j = this.uBK;
    if (this.uoD == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new aq(i, (LinkedList)localObject, j, bool);
      g.ajj().a((n)localObject, 0);
      this.uxf = true;
      AppMethodBeat.o(42239);
      return;
    }
  }
  
  private void goBack()
  {
    AppMethodBeat.i(42237);
    dcG();
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
    if (!bu.isNullOrNil(e.dby())) {
      addIconOptionMenu(0, 2131764452, 2131689494, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(42220);
          Object localObject = new Intent(GameLibraryUI.this, GameSearchUI.class);
          ((Intent)localObject).putExtra("game_report_from_scene", 1109);
          paramAnonymousMenuItem = GameLibraryUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/game/ui/GameLibraryUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/plugin/game/ui/GameLibraryUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(42220);
          return true;
        }
      });
    }
    this.uxd = ((ListView)findViewById(2131300492));
    this.uxd.setOnItemClickListener(this.uwW);
    this.uwW.setSourceScene(this.uoy);
    this.uxd.setOnScrollListener(this.uxk);
    this.uxe = new l(this);
    this.uxe.setSourceScene(this.uoy);
    this.uxe.a(this.uxj);
    LayoutInflater localLayoutInflater = (LayoutInflater)getContext().getSystemService("layout_inflater");
    Object localObject = localLayoutInflater.inflate(2131494335, this.uxd, false);
    this.uBD = ((GameBannerView)((View)localObject).findViewById(2131300496));
    this.uBD.setSourceScene(this.uoy);
    this.uxd.addHeaderView((View)localObject);
    this.uBP += 1;
    this.uBE = ((GameLibraryCategoriesView)localLayoutInflater.inflate(2131494329, this.uxd, false));
    localObject = new LinearLayout(this);
    ((LinearLayout)localObject).addView(this.uBE);
    this.uxd.addHeaderView((View)localObject);
    this.uBP += 1;
    this.uBF = localLayoutInflater.inflate(2131494334, this.uxd, false);
    this.uBF.setOnClickListener(this.uBQ);
    this.uBG = ((TextView)this.uBF.findViewById(2131300494));
    this.uBH = localLayoutInflater.inflate(2131494328, this.uxd, false);
    this.uBH.setOnClickListener(null);
    this.uBI = ((GameDropdownView)this.uBH.findViewById(2131300486));
    this.uBI.setAnchorView(this.uBH);
    this.uBI.setOnSelectionChangedListener(this.uBS);
    this.fVr = localLayoutInflater.inflate(2131494337, this.uxd, false);
    this.fVr.setVisibility(8);
    localObject = new LinearLayout(this);
    ((LinearLayout)localObject).addView(this.fVr);
    this.uxd.addFooterView((View)localObject);
    this.uBL = localLayoutInflater.inflate(2131494333, this.uxd, false);
    this.uBL.setVisibility(8);
    this.uBM = ((Button)this.uBL.findViewById(2131300493));
    this.uBM.setOnClickListener(this.uBR);
    this.uxd.addFooterView(this.uBL);
    this.uxd.setAdapter(this.uxe);
    AppMethodBeat.o(42236);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(42241);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GameLibraryUI", "requestCode = %d, resultCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 != 1)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.GameLibraryUI", "error request code");
      AppMethodBeat.o(42241);
      return;
    }
    AppMethodBeat.o(42241);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(42231);
    super.onCreate(paramBundle);
    if (!g.ajM())
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.GameLibraryUI", "account not ready");
      finish();
      AppMethodBeat.o(42231);
      return;
    }
    this.uoy = getIntent().getIntExtra("game_report_from_scene", 0);
    g.ajj().a(1218, this);
    initView();
    paramBundle = ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cZm().amj("pb_library");
    if (paramBundle == null) {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GameLibraryUI", "No cache found");
    }
    for (int i = 0;; i = 1)
    {
      if (i == 0)
      {
        this.qka = c.fF(this);
        this.qka.show();
      }
      dcL();
      com.tencent.mm.game.report.f.a(this, 11, 1100, 0, 1, this.uoy, null);
      AppMethodBeat.o(42231);
      return;
      g.ajU().aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(42223);
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42222);
              GameLibraryUI.a(GameLibraryUI.this, this.uBU, false);
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
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GameLibraryUI", "onDestroy");
    super.onDestroy();
    g.ajj().b(1218, this);
    this.uxe.clear();
    if (this.uBD != null) {
      this.uBD.uwE.stopTimer();
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
    if (this.uBD != null)
    {
      GameBannerView localGameBannerView = this.uBD;
      if (localGameBannerView.uwE != null)
      {
        localGameBannerView.uwE.stopTimer();
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GameBannerView", "Auto scroll stopped");
      }
    }
    AppMethodBeat.o(42233);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(42232);
    super.onResume();
    if (!g.ajM())
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.GameLibraryUI", "account not ready");
      AppMethodBeat.o(42232);
      return;
    }
    this.uxe.refresh();
    if ((!this.glB) && (this.uBD != null))
    {
      GameBannerView localGameBannerView = this.uBD;
      if ((localGameBannerView.uwE != null) && (localGameBannerView.uwE.foU()) && (localGameBannerView.uwD.size() > 1))
      {
        localGameBannerView.uwE.ay(5000L, 5000L);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GameBannerView", "Auto scroll restarted");
      }
    }
    if (this.glB) {
      this.glB = false;
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
        paramString = ((aq)paramn).gux.hQE.hQJ;
        g.ajU().aw(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(42229);
            Object localObject = paramString;
            if ((GameLibraryUI.m(GameLibraryUI.this) == 0) && (!GameLibraryUI.n(GameLibraryUI.this))) {}
            for (boolean bool = true;; bool = false)
            {
              localObject = new com.tencent.mm.plugin.game.model.ae((com.tencent.mm.bw.a)localObject, bool, GameLibraryUI.m(GameLibraryUI.this));
              GameLibraryUI.o(GameLibraryUI.this);
              ar.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(42228);
                  GameLibraryUI localGameLibraryUI = GameLibraryUI.this;
                  com.tencent.mm.plugin.game.model.ae localae = this.uBU;
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
    if (!com.tencent.mm.plugin.game.a.a.iUA.a(this, paramInt1, paramInt2, paramString)) {
      Toast.makeText(this, getString(2131759916, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    if (this.qka != null) {
      this.qka.cancel();
    }
    AppMethodBeat.o(42240);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameLibraryUI
 * JD-Core Version:    0.7.0.1
 */