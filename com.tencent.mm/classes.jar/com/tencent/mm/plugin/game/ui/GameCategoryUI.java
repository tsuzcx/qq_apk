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
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.y;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;

public class GameCategoryUI
  extends MMActivity
  implements f
{
  private View fVr;
  private Dialog mPB;
  private int mType;
  private int uoD;
  private int uoy;
  private k uwW;
  private ListView uxd;
  private l uxe;
  private boolean uxf;
  private boolean uxg;
  private int uxh;
  private String uxi;
  private m.a uxj;
  private AbsListView.OnScrollListener uxk;
  
  public GameCategoryUI()
  {
    AppMethodBeat.i(41918);
    this.uxf = false;
    this.uoD = 0;
    this.uxg = false;
    this.uoy = 0;
    this.uwW = new k();
    this.uxj = new m.a()
    {
      public final void Ir(int paramAnonymousInt)
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
    this.uxk = new AbsListView.OnScrollListener()
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
  
  private void dcD()
  {
    AppMethodBeat.i(41921);
    com.tencent.mm.plugin.game.model.ar localar = new com.tencent.mm.plugin.game.model.ar(this.uoD, this.mType, this.uxh);
    g.ajj().a(localar, 0);
    this.uxf = true;
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
    ae.i("MicroMsg.GameCategoryUI", "requestCode = %d, resultCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 != 1)
    {
      ae.e("MicroMsg.GameCategoryUI", "error request code");
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
      if (bu.isNullOrNil(str))
      {
        AppMethodBeat.o(41923);
        return;
      }
      this.uxe.ank(str);
      AppMethodBeat.o(41923);
      return;
      if (bu.isNullOrNil(str))
      {
        AppMethodBeat.o(41923);
        return;
      }
      this.uxe.anj(str);
      this.uxe.anl(str);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41919);
    super.onCreate(paramBundle);
    this.mType = getIntent().getIntExtra("extra_type", 0);
    this.uxh = getIntent().getIntExtra("extra_category_id", 0);
    this.uxi = getIntent().getStringExtra("extra_category_name");
    this.uoy = getIntent().getIntExtra("game_report_from_scene", 0);
    g.ajj().a(1220, this);
    setMMTitle(this.uxi);
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
    if (!bu.isNullOrNil(e.dby())) {
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
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/game/ui/GameCategoryUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
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
    this.uxd = ((ListView)findViewById(2131300355));
    this.uxd.setOnItemClickListener(this.uwW);
    this.uwW.setSourceScene(this.uoy);
    this.uxd.setOnScrollListener(this.uxk);
    this.uxe = new l(this);
    this.uxe.setSourceScene(this.uoy);
    this.uxe.a(this.uxj);
    this.fVr = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2131494337, this.uxd, false);
    this.fVr.setVisibility(8);
    this.uxd.addFooterView(this.fVr);
    this.uxd.setAdapter(this.uxe);
    this.mPB = c.fF(this);
    this.mPB.show();
    dcD();
    AppMethodBeat.o(41919);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41920);
    super.onDestroy();
    g.ajj().b(1220, this);
    this.uxe.clear();
    AppMethodBeat.o(41920);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(41922);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ae.e("MicroMsg.GameCategoryUI", "errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(41922);
      return;
    }
    paramString = ((com.tencent.mm.plugin.game.model.ar)paramn).gux.hQE.hQJ;
    g.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(41917);
        com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(41916);
            GameCategoryUI localGameCategoryUI = GameCategoryUI.this;
            y localy = this.uxn;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCategoryUI
 * JD-Core Version:    0.7.0.1
 */