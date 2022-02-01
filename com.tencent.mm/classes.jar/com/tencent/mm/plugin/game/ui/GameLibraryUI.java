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
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.ae;
import com.tencent.mm.plugin.game.model.aq;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.LinkedList;

public class GameLibraryUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private boolean fPJ;
  private View fzV;
  private Dialog pzQ;
  private boolean sAn;
  private int tfA;
  private int tfF;
  private k tnb;
  private ListView tni;
  private l tnj;
  private boolean tnk;
  private boolean tnl;
  private m.a tno;
  private AbsListView.OnScrollListener tnp;
  private GameBannerView trK;
  private GameLibraryCategoriesView trL;
  private View trM;
  private TextView trN;
  private View trO;
  private GameDropdownView trP;
  private HashMap<Integer, String> trQ;
  private int trR;
  private View trS;
  private Button trT;
  private boolean trU;
  private int trV;
  private int trW;
  private View.OnClickListener trX;
  private View.OnClickListener trY;
  private GameDropdownView.a trZ;
  
  public GameLibraryUI()
  {
    AppMethodBeat.i(42230);
    this.trR = 0;
    this.sAn = false;
    this.tnk = false;
    this.tfF = 0;
    this.tnl = true;
    this.trU = false;
    this.fPJ = true;
    this.tfA = 0;
    this.trV = 990;
    this.trW = 0;
    this.tnb = new k();
    this.tno = new m.a()
    {
      public final void GA(int paramAnonymousInt)
      {
        AppMethodBeat.i(42221);
        int i = GameLibraryUI.b(GameLibraryUI.this).getFirstVisiblePosition() - GameLibraryUI.c(GameLibraryUI.this);
        int j = GameLibraryUI.b(GameLibraryUI.this).getLastVisiblePosition();
        int k = GameLibraryUI.c(GameLibraryUI.this);
        if ((paramAnonymousInt >= i) && (paramAnonymousInt <= j - k))
        {
          View localView = GameLibraryUI.b(GameLibraryUI.this).getChildAt(paramAnonymousInt - i);
          GameLibraryUI.d(GameLibraryUI.this).ag(localView, paramAnonymousInt);
        }
        AppMethodBeat.o(42221);
      }
    };
    this.trX = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42224);
        c.a(paramAnonymousView, GameLibraryUI.this);
        com.tencent.mm.game.report.e.a(GameLibraryUI.this, 11, 1110, 999, 7, GameLibraryUI.e(GameLibraryUI.this), null);
        AppMethodBeat.o(42224);
      }
    };
    this.trY = new View.OnClickListener()
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
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/game/ui/GameLibraryUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/game/ui/GameLibraryUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
    };
    this.trZ = new GameDropdownView.a()
    {
      public final void GD(int paramAnonymousInt)
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
        ac.i("MicroMsg.GameLibraryUI", "Selected SortType: %d", new Object[] { Integer.valueOf(GameLibraryUI.g(GameLibraryUI.this)) });
        GameLibraryUI.b(GameLibraryUI.this, 0);
        GameLibraryUI.h(GameLibraryUI.this);
        com.tencent.mm.game.report.e.a(GameLibraryUI.this, 11, 1111, GameLibraryUI.g(GameLibraryUI.this) + GameLibraryUI.i(GameLibraryUI.this), 2, GameLibraryUI.e(GameLibraryUI.this), null);
        AppMethodBeat.o(42226);
      }
    };
    this.tnp = new AbsListView.OnScrollListener()
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
  
  private void cRq()
  {
    AppMethodBeat.i(42238);
    Object localObject = getIntent().getStringExtra("jump_game_center");
    if ((!bs.isNullOrNil((String)localObject)) && (((String)localObject).equals("jump_game_center")))
    {
      localObject = new Intent(this, GameCenterUI.class);
      ((Intent)localObject).putExtra("jump_find_more_friends", "jump_find_more_friends");
      localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/game/ui/GameLibraryUI", "backToGameCenterUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameLibraryUI", "backToGameCenterUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(42238);
  }
  
  private void cRv()
  {
    AppMethodBeat.i(42239);
    Object localObject = com.tencent.mm.plugin.game.model.e.cPV();
    int i = this.tfF;
    int j = this.trR;
    if (this.tfF == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new aq(i, (LinkedList)localObject, j, bool);
      com.tencent.mm.kernel.g.agi().a((n)localObject, 0);
      this.tnk = true;
      AppMethodBeat.o(42239);
      return;
    }
  }
  
  private void goBack()
  {
    AppMethodBeat.i(42237);
    cRq();
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
    if (!bs.isNullOrNil(com.tencent.mm.plugin.game.model.e.cQj())) {
      addIconOptionMenu(0, 2131764452, 2131689494, new GameLibraryUI.2(this));
    }
    this.tni = ((ListView)findViewById(2131300492));
    this.tni.setOnItemClickListener(this.tnb);
    this.tnb.setSourceScene(this.tfA);
    this.tni.setOnScrollListener(this.tnp);
    this.tnj = new l(this);
    this.tnj.setSourceScene(this.tfA);
    this.tnj.a(this.tno);
    LayoutInflater localLayoutInflater = (LayoutInflater)getContext().getSystemService("layout_inflater");
    Object localObject = localLayoutInflater.inflate(2131494335, this.tni, false);
    this.trK = ((GameBannerView)((View)localObject).findViewById(2131300496));
    this.trK.setSourceScene(this.tfA);
    this.tni.addHeaderView((View)localObject);
    this.trW += 1;
    this.trL = ((GameLibraryCategoriesView)localLayoutInflater.inflate(2131494329, this.tni, false));
    localObject = new LinearLayout(this);
    ((LinearLayout)localObject).addView(this.trL);
    this.tni.addHeaderView((View)localObject);
    this.trW += 1;
    this.trM = localLayoutInflater.inflate(2131494334, this.tni, false);
    this.trM.setOnClickListener(this.trX);
    this.trN = ((TextView)this.trM.findViewById(2131300494));
    this.trO = localLayoutInflater.inflate(2131494328, this.tni, false);
    this.trO.setOnClickListener(null);
    this.trP = ((GameDropdownView)this.trO.findViewById(2131300486));
    this.trP.setAnchorView(this.trO);
    this.trP.setOnSelectionChangedListener(this.trZ);
    this.fzV = localLayoutInflater.inflate(2131494337, this.tni, false);
    this.fzV.setVisibility(8);
    localObject = new LinearLayout(this);
    ((LinearLayout)localObject).addView(this.fzV);
    this.tni.addFooterView((View)localObject);
    this.trS = localLayoutInflater.inflate(2131494333, this.tni, false);
    this.trS.setVisibility(8);
    this.trT = ((Button)this.trS.findViewById(2131300493));
    this.trT.setOnClickListener(this.trY);
    this.tni.addFooterView(this.trS);
    this.tni.setAdapter(this.tnj);
    AppMethodBeat.o(42236);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(42241);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ac.i("MicroMsg.GameLibraryUI", "requestCode = %d, resultCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 != 1)
    {
      ac.e("MicroMsg.GameLibraryUI", "error request code");
      AppMethodBeat.o(42241);
      return;
    }
    AppMethodBeat.o(42241);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(42231);
    super.onCreate(paramBundle);
    if (!com.tencent.mm.kernel.g.agM())
    {
      ac.e("MicroMsg.GameLibraryUI", "account not ready");
      finish();
      AppMethodBeat.o(42231);
      return;
    }
    this.tfA = getIntent().getIntExtra("game_report_from_scene", 0);
    com.tencent.mm.kernel.g.agi().a(1218, this);
    initView();
    paramBundle = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOn().agO("pb_library");
    if (paramBundle == null) {
      ac.i("MicroMsg.GameLibraryUI", "No cache found");
    }
    for (int i = 0;; i = 1)
    {
      if (i == 0)
      {
        this.pzQ = c.fv(this);
        this.pzQ.show();
      }
      cRv();
      com.tencent.mm.game.report.e.a(this, 11, 1100, 0, 1, this.tfA, null);
      AppMethodBeat.o(42231);
      return;
      com.tencent.mm.kernel.g.agU().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(42223);
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42222);
              GameLibraryUI.a(GameLibraryUI.this, this.tsb, false);
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
    ac.i("MicroMsg.GameLibraryUI", "onDestroy");
    super.onDestroy();
    com.tencent.mm.kernel.g.agi().b(1218, this);
    this.tnj.clear();
    if (this.trK != null) {
      this.trK.tmI.stopTimer();
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
    if (this.trK != null)
    {
      GameBannerView localGameBannerView = this.trK;
      if (localGameBannerView.tmI != null)
      {
        localGameBannerView.tmI.stopTimer();
        ac.i("MicroMsg.GameBannerView", "Auto scroll stopped");
      }
    }
    AppMethodBeat.o(42233);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(42232);
    super.onResume();
    if (!com.tencent.mm.kernel.g.agM())
    {
      ac.e("MicroMsg.GameLibraryUI", "account not ready");
      AppMethodBeat.o(42232);
      return;
    }
    this.tnj.refresh();
    if ((!this.fPJ) && (this.trK != null))
    {
      GameBannerView localGameBannerView = this.trK;
      if ((localGameBannerView.tmI != null) && (localGameBannerView.tmI.eVs()) && (localGameBannerView.tmH.size() > 1))
      {
        localGameBannerView.tmI.au(5000L, 5000L);
        ac.i("MicroMsg.GameBannerView", "Auto scroll restarted");
      }
    }
    if (this.fPJ) {
      this.fPJ = false;
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
        paramString = ((aq)paramn).fYA.hvs.hvw;
        com.tencent.mm.kernel.g.agU().az(new Runnable()
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
              ap.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(42228);
                  GameLibraryUI localGameLibraryUI = GameLibraryUI.this;
                  ae localae = this.tsb;
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
    if (!com.tencent.mm.plugin.game.a.a.iyy.a(this, paramInt1, paramInt2, paramString)) {
      Toast.makeText(this, getString(2131759916, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    if (this.pzQ != null) {
      this.pzQ.cancel();
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