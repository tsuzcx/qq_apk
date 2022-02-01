package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.ar;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.y;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;

public class GameCategoryUI
  extends MMActivity
  implements f
{
  private View fTl;
  private Dialog mKz;
  private int mType;
  private int udq;
  private int udv;
  private ListView ulG;
  private l ulH;
  private boolean ulI;
  private boolean ulJ;
  private int ulK;
  private String ulL;
  private m.a ulM;
  private AbsListView.OnScrollListener ulN;
  private k ulz;
  
  public GameCategoryUI()
  {
    AppMethodBeat.i(41918);
    this.ulI = false;
    this.udv = 0;
    this.ulJ = false;
    this.udq = 0;
    this.ulz = new k();
    this.ulM = new m.a()
    {
      public final void HT(int paramAnonymousInt)
      {
        AppMethodBeat.i(41914);
        int i = GameCategoryUI.b(GameCategoryUI.this).getFirstVisiblePosition();
        int j = GameCategoryUI.b(GameCategoryUI.this).getLastVisiblePosition();
        if ((paramAnonymousInt >= i) && (paramAnonymousInt <= j))
        {
          View localView = GameCategoryUI.b(GameCategoryUI.this).getChildAt(paramAnonymousInt - i);
          GameCategoryUI.c(GameCategoryUI.this).ah(localView, paramAnonymousInt);
        }
        AppMethodBeat.o(41914);
      }
    };
    this.ulN = new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(41915);
        if ((paramAnonymousInt == 0) && (paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1))
        {
          if ((!GameCategoryUI.d(GameCategoryUI.this)) || (GameCategoryUI.e(GameCategoryUI.this)))
          {
            AppMethodBeat.o(41915);
            return;
          }
          GameCategoryUI.f(GameCategoryUI.this).setVisibility(0);
          GameCategoryUI.g(GameCategoryUI.this);
        }
        AppMethodBeat.o(41915);
      }
    };
    AppMethodBeat.o(41918);
  }
  
  private void cZS()
  {
    AppMethodBeat.i(41921);
    ar localar = new ar(this.udv, this.mType, this.ulK);
    g.aiU().a(localar, 0);
    this.ulI = true;
    AppMethodBeat.o(41921);
  }
  
  public int getLayoutId()
  {
    return 2131494247;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(41923);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ad.i("MicroMsg.GameCategoryUI", "requestCode = %d, resultCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 != 1)
    {
      ad.e("MicroMsg.GameCategoryUI", "error request code");
      AppMethodBeat.o(41923);
      return;
    }
    String str = null;
    if (paramIntent != null) {
      str = paramIntent.getStringExtra("game_app_id");
    }
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(41923);
      return;
      if (bt.isNullOrNil(str))
      {
        AppMethodBeat.o(41923);
        return;
      }
      this.ulH.amk(str);
      AppMethodBeat.o(41923);
      return;
      if (bt.isNullOrNil(str))
      {
        AppMethodBeat.o(41923);
        return;
      }
      this.ulH.amj(str);
      this.ulH.aml(str);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41919);
    super.onCreate(paramBundle);
    this.mType = getIntent().getIntExtra("extra_type", 0);
    this.ulK = getIntent().getIntExtra("extra_category_id", 0);
    this.ulL = getIntent().getStringExtra("extra_category_name");
    this.udq = getIntent().getIntExtra("game_report_from_scene", 0);
    g.aiU().a(1220, this);
    setMMTitle(this.ulL);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(41912);
        GameCategoryUI.this.finish();
        AppMethodBeat.o(41912);
        return true;
      }
    });
    if (!bt.isNullOrNil(e.cYO())) {
      addIconOptionMenu(0, 2131764452, 2131689494, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(41913);
          Object localObject = new Intent(GameCategoryUI.this, GameSearchUI.class);
          switch (GameCategoryUI.a(GameCategoryUI.this))
          {
          }
          for (;;)
          {
            paramAnonymousMenuItem = GameCategoryUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/game/ui/GameCategoryUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/plugin/game/ui/GameCategoryUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(41913);
            return true;
            ((Intent)localObject).putExtra("game_report_from_scene", 1602);
            continue;
            ((Intent)localObject).putExtra("game_report_from_scene", 1502);
          }
        }
      });
    }
    this.ulG = ((ListView)findViewById(2131300355));
    this.ulG.setOnItemClickListener(this.ulz);
    this.ulz.setSourceScene(this.udq);
    this.ulG.setOnScrollListener(this.ulN);
    this.ulH = new l(this);
    this.ulH.setSourceScene(this.udq);
    this.ulH.a(this.ulM);
    this.fTl = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2131494337, this.ulG, false);
    this.fTl.setVisibility(8);
    this.ulG.addFooterView(this.fTl);
    this.ulG.setAdapter(this.ulH);
    this.mKz = c.fA(this);
    this.mKz.show();
    cZS();
    AppMethodBeat.o(41919);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41920);
    super.onDestroy();
    g.aiU().b(1220, this);
    this.ulH.clear();
    AppMethodBeat.o(41920);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(41922);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ad.e("MicroMsg.GameCategoryUI", "errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(41922);
      return;
    }
    paramString = ((ar)paramn).grW.hNL.hNQ;
    g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(41917);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(41916);
            GameCategoryUI localGameCategoryUI = GameCategoryUI.this;
            y localy = this.ulQ;
            if (GameCategoryUI.h(GameCategoryUI.this) != 0) {}
            for (boolean bool = true;; bool = false)
            {
              GameCategoryUI.a(localGameCategoryUI, localy, bool);
              GameCategoryUI.i(GameCategoryUI.this);
              GameCategoryUI.f(GameCategoryUI.this).setVisibility(8);
              GameCategoryUI.a(GameCategoryUI.this, GameCategoryUI.h(GameCategoryUI.this) + 15);
              if (GameCategoryUI.j(GameCategoryUI.this) != null) {
                GameCategoryUI.j(GameCategoryUI.this).dismiss();
              }
              AppMethodBeat.o(41916);
              return;
            }
          }
        });
        AppMethodBeat.o(41917);
      }
    });
    AppMethodBeat.o(41922);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCategoryUI
 * JD-Core Version:    0.7.0.1
 */