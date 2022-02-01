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
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.ae;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.LinkedList;

public class GameLibraryUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private boolean fLX;
  private View fwo;
  private Dialog oWF;
  private int rXI;
  private int rXN;
  private boolean rrt;
  private k sfi;
  private ListView sfp;
  private l sfq;
  private boolean sfr;
  private boolean sfs;
  private m.a sfv;
  private AbsListView.OnScrollListener sfw;
  private GameBannerView sjR;
  private GameLibraryCategoriesView sjS;
  private View sjT;
  private TextView sjU;
  private View sjV;
  private GameDropdownView sjW;
  private HashMap<Integer, String> sjX;
  private int sjY;
  private View sjZ;
  private Button ska;
  private boolean skb;
  private int skc;
  private int skd;
  private View.OnClickListener ske;
  private View.OnClickListener skf;
  private GameDropdownView.a skg;
  
  public GameLibraryUI()
  {
    AppMethodBeat.i(42230);
    this.sjY = 0;
    this.rrt = false;
    this.sfr = false;
    this.rXN = 0;
    this.sfs = true;
    this.skb = false;
    this.fLX = true;
    this.rXI = 0;
    this.skc = 990;
    this.skd = 0;
    this.sfi = new k();
    this.sfv = new m.a()
    {
      public final void EE(int paramAnonymousInt)
      {
        AppMethodBeat.i(42221);
        int i = GameLibraryUI.b(GameLibraryUI.this).getFirstVisiblePosition() - GameLibraryUI.c(GameLibraryUI.this);
        int j = GameLibraryUI.b(GameLibraryUI.this).getLastVisiblePosition();
        int k = GameLibraryUI.c(GameLibraryUI.this);
        if ((paramAnonymousInt >= i) && (paramAnonymousInt <= j - k))
        {
          View localView = GameLibraryUI.b(GameLibraryUI.this).getChildAt(paramAnonymousInt - i);
          GameLibraryUI.d(GameLibraryUI.this).af(localView, paramAnonymousInt);
        }
        AppMethodBeat.o(42221);
      }
    };
    this.ske = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42224);
        c.a(paramAnonymousView, GameLibraryUI.this);
        com.tencent.mm.game.report.e.a(GameLibraryUI.this, 11, 1110, 999, 7, GameLibraryUI.e(GameLibraryUI.this), null);
        AppMethodBeat.o(42224);
      }
    };
    this.skf = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42225);
        if ((paramAnonymousView.getTag() instanceof String)) {
          c.a(paramAnonymousView, GameLibraryUI.this);
        }
        for (int i = 7;; i = 6)
        {
          com.tencent.mm.game.report.e.a(GameLibraryUI.this, 11, 1113, 1, i, GameLibraryUI.e(GameLibraryUI.this), null);
          AppMethodBeat.o(42225);
          return;
          Object localObject = new Intent(GameLibraryUI.this, GameCategoryUI.class);
          ((Intent)localObject).putExtra("extra_type", 2);
          ((Intent)localObject).putExtra("extra_category_name", GameLibraryUI.this.getString(2131759898));
          ((Intent)localObject).putExtra("game_report_from_scene", 1113);
          paramAnonymousView = GameLibraryUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/game/ui/GameLibraryUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/game/ui/GameLibraryUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
    };
    this.skg = new GameDropdownView.a()
    {
      public final void EH(int paramAnonymousInt)
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
        com.tencent.mm.game.report.e.a(GameLibraryUI.this, 11, 1111, GameLibraryUI.g(GameLibraryUI.this) + GameLibraryUI.i(GameLibraryUI.this), 2, GameLibraryUI.e(GameLibraryUI.this), null);
        AppMethodBeat.o(42226);
      }
    };
    this.sfw = new AbsListView.OnScrollListener()
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
  
  private void cEg()
  {
    AppMethodBeat.i(42238);
    Object localObject = getIntent().getStringExtra("jump_game_center");
    if ((!bt.isNullOrNil((String)localObject)) && (((String)localObject).equals("jump_game_center")))
    {
      localObject = new Intent(this, GameCenterUI.class);
      ((Intent)localObject).putExtra("jump_find_more_friends", "jump_find_more_friends");
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/game/ui/GameLibraryUI", "backToGameCenterUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameLibraryUI", "backToGameCenterUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(42238);
  }
  
  private void cEl()
  {
    AppMethodBeat.i(42239);
    Object localObject = com.tencent.mm.plugin.game.model.e.cCL();
    int i = this.rXN;
    int j = this.sjY;
    if (this.rXN == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new com.tencent.mm.plugin.game.model.aq(i, (LinkedList)localObject, j, bool);
      com.tencent.mm.kernel.g.aeS().a((n)localObject, 0);
      this.sfr = true;
      AppMethodBeat.o(42239);
      return;
    }
  }
  
  private void goBack()
  {
    AppMethodBeat.i(42237);
    cEg();
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
    setBackBtn(new GameLibraryUI.1(this));
    if (!bt.isNullOrNil(com.tencent.mm.plugin.game.model.e.cCZ())) {
      addIconOptionMenu(0, 2131764452, 2131689494, new GameLibraryUI.2(this));
    }
    this.sfp = ((ListView)findViewById(2131300492));
    this.sfp.setOnItemClickListener(this.sfi);
    this.sfi.setSourceScene(this.rXI);
    this.sfp.setOnScrollListener(this.sfw);
    this.sfq = new l(this);
    this.sfq.setSourceScene(this.rXI);
    this.sfq.a(this.sfv);
    LayoutInflater localLayoutInflater = (LayoutInflater)getContext().getSystemService("layout_inflater");
    Object localObject = localLayoutInflater.inflate(2131494335, this.sfp, false);
    this.sjR = ((GameBannerView)((View)localObject).findViewById(2131300496));
    this.sjR.setSourceScene(this.rXI);
    this.sfp.addHeaderView((View)localObject);
    this.skd += 1;
    this.sjS = ((GameLibraryCategoriesView)localLayoutInflater.inflate(2131494329, this.sfp, false));
    localObject = new LinearLayout(this);
    ((LinearLayout)localObject).addView(this.sjS);
    this.sfp.addHeaderView((View)localObject);
    this.skd += 1;
    this.sjT = localLayoutInflater.inflate(2131494334, this.sfp, false);
    this.sjT.setOnClickListener(this.ske);
    this.sjU = ((TextView)this.sjT.findViewById(2131300494));
    this.sjV = localLayoutInflater.inflate(2131494328, this.sfp, false);
    this.sjV.setOnClickListener(null);
    this.sjW = ((GameDropdownView)this.sjV.findViewById(2131300486));
    this.sjW.setAnchorView(this.sjV);
    this.sjW.setOnSelectionChangedListener(this.skg);
    this.fwo = localLayoutInflater.inflate(2131494337, this.sfp, false);
    this.fwo.setVisibility(8);
    localObject = new LinearLayout(this);
    ((LinearLayout)localObject).addView(this.fwo);
    this.sfp.addFooterView((View)localObject);
    this.sjZ = localLayoutInflater.inflate(2131494333, this.sfp, false);
    this.sjZ.setVisibility(8);
    this.ska = ((Button)this.sjZ.findViewById(2131300493));
    this.ska.setOnClickListener(this.skf);
    this.sfp.addFooterView(this.sjZ);
    this.sfp.setAdapter(this.sfq);
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
    if (!com.tencent.mm.kernel.g.afw())
    {
      ad.e("MicroMsg.GameLibraryUI", "account not ready");
      finish();
      AppMethodBeat.o(42231);
      return;
    }
    this.rXI = getIntent().getIntExtra("game_report_from_scene", 0);
    com.tencent.mm.kernel.g.aeS().a(1218, this);
    initView();
    paramBundle = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBe().abW("pb_library");
    if (paramBundle == null) {
      ad.i("MicroMsg.GameLibraryUI", "No cache found");
    }
    for (int i = 0;; i = 1)
    {
      if (i == 0)
      {
        this.oWF = c.fi(this);
        this.oWF.show();
      }
      cEl();
      com.tencent.mm.game.report.e.a(this, 11, 1100, 0, 1, this.rXI, null);
      AppMethodBeat.o(42231);
      return;
      com.tencent.mm.kernel.g.afE().ax(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(42223);
          com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42222);
              GameLibraryUI.a(GameLibraryUI.this, this.ski, false);
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
    com.tencent.mm.kernel.g.aeS().b(1218, this);
    this.sfq.clear();
    if (this.sjR != null) {
      this.sjR.seP.stopTimer();
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
    if (this.sjR != null)
    {
      GameBannerView localGameBannerView = this.sjR;
      if (localGameBannerView.seP != null)
      {
        localGameBannerView.seP.stopTimer();
        ad.i("MicroMsg.GameBannerView", "Auto scroll stopped");
      }
    }
    AppMethodBeat.o(42233);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(42232);
    super.onResume();
    if (!com.tencent.mm.kernel.g.afw())
    {
      ad.e("MicroMsg.GameLibraryUI", "account not ready");
      AppMethodBeat.o(42232);
      return;
    }
    this.sfq.refresh();
    if ((!this.fLX) && (this.sjR != null))
    {
      GameBannerView localGameBannerView = this.sjR;
      if ((localGameBannerView.seP != null) && (localGameBannerView.seP.eFX()) && (localGameBannerView.seO.size() > 1))
      {
        localGameBannerView.seP.av(5000L, 5000L);
        ad.i("MicroMsg.GameBannerView", "Auto scroll restarted");
      }
    }
    if (this.fLX) {
      this.fLX = false;
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
        paramString = ((com.tencent.mm.plugin.game.model.aq)paramn).fUF.gUT.gUX;
        com.tencent.mm.kernel.g.afE().ax(new Runnable()
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
                  ae localae = this.ski;
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
    if (!com.tencent.mm.plugin.game.a.a.hYu.a(this, paramInt1, paramInt2, paramString)) {
      Toast.makeText(this, getString(2131759916, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    if (this.oWF != null) {
      this.oWF.cancel();
    }
    AppMethodBeat.o(42240);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameLibraryUI
 * JD-Core Version:    0.7.0.1
 */