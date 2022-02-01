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
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.game.api.d;
import com.tencent.mm.plugin.game.d.bk;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.af;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;

public class GameOverSeaCenterUI
  extends GameCenterBaseUI
  implements com.tencent.mm.ak.g
{
  private boolean fPJ;
  private Dialog pzQ;
  private bk tgc;
  k tnb;
  private boolean tpQ;
  private String tpR;
  private View.OnClickListener trY;
  private GameInfoViewForeign ttA;
  private GameMessageBubbleView ttB;
  private GameInstalledView ttC;
  private View ttD;
  private TextView ttE;
  private GameCenterListView tty;
  private g ttz;
  
  public GameOverSeaCenterUI()
  {
    AppMethodBeat.i(42333);
    this.tnb = new k();
    this.tpR = "";
    this.fPJ = true;
    this.trY = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42329);
        Object localObject = com.tencent.mm.plugin.game.model.a.cPQ();
        int i;
        if (((com.tencent.mm.plugin.game.model.a.a)localObject).drx == 2) {
          i = c.z(GameOverSeaCenterUI.this.getContext(), ((com.tencent.mm.plugin.game.model.a.a)localObject).url, "game_center_library");
        }
        for (;;)
        {
          com.tencent.mm.game.report.e.a(GameOverSeaCenterUI.this.getContext(), 10, 1005, 1, i, GameOverSeaCenterUI.this.tfA, null);
          AppMethodBeat.o(42329);
          return;
          paramAnonymousView = paramAnonymousView.getTag();
          if ((paramAnonymousView != null) && ((paramAnonymousView instanceof String)) && (!bs.isNullOrNil((String)paramAnonymousView)))
          {
            paramAnonymousView = (String)paramAnonymousView;
            i = c.z(GameOverSeaCenterUI.this.getContext(), paramAnonymousView, "game_center_library");
          }
          else
          {
            localObject = new Intent(GameOverSeaCenterUI.this.getContext(), GameLibraryUI.class);
            ((Intent)localObject).putExtra("game_report_from_scene", 1005);
            paramAnonymousView = GameOverSeaCenterUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/game/ui/GameOverSeaCenterUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/game/ui/GameOverSeaCenterUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            i = 6;
          }
        }
      }
    };
    AppMethodBeat.o(42333);
  }
  
  public int getLayoutId()
  {
    return 2131494261;
  }
  
  public void initView()
  {
    AppMethodBeat.i(42337);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(42323);
        GameOverSeaCenterUI.this.finish();
        AppMethodBeat.o(42323);
        return true;
      }
    });
    setMMTitle(2131760012);
    this.tty = ((GameCenterListView)findViewById(2131300365));
    this.tty.setOnItemClickListener(this.tnb);
    this.tnb.setSourceScene(this.tfA);
    this.ttz = new g(this);
    this.ttz.setSourceScene(this.tfA);
    Object localObject = (LayoutInflater)getContext().getSystemService("layout_inflater");
    View localView = ((LayoutInflater)localObject).inflate(2131494269, this.tty, false);
    this.ttA = ((GameInfoViewForeign)localView.findViewById(2131300363));
    this.tty.addHeaderView(localView);
    localView = ((LayoutInflater)localObject).inflate(2131494258, this.tty, false);
    this.ttB = ((GameMessageBubbleView)localView.findViewById(2131300517));
    this.tty.addHeaderView(localView);
    localView = ((LayoutInflater)localObject).inflate(2131494270, this.tty, false);
    this.ttC = ((GameInstalledView)localView.findViewById(2131300472));
    this.tty.addHeaderView(localView);
    localObject = ((LayoutInflater)localObject).inflate(2131494263, this.tty, false);
    this.tty.addFooterView((View)localObject);
    this.ttD = ((View)localObject).findViewById(2131300459);
    this.ttD.setOnClickListener(this.trY);
    this.ttE = ((TextView)((View)localObject).findViewById(2131300460));
    this.tty.setAdapter(this.ttz);
    AppMethodBeat.o(42337);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42334);
    super.onCreate(paramBundle);
    ac.i("MicroMsg.GameOverSeaCenterUI", "GameOverSeaCenterUI create");
    com.tencent.mm.kernel.g.agi().a(2855, this);
    initView();
    c.bUw().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(42327);
        Object localObject = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOn().agO("pb_over_sea");
        if (localObject == null) {
          com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42324);
              if (GameOverSeaCenterUI.this.isFinishing())
              {
                AppMethodBeat.o(42324);
                return;
              }
              GameOverSeaCenterUI.a(GameOverSeaCenterUI.this, c.fv(GameOverSeaCenterUI.this));
              GameOverSeaCenterUI.a(GameOverSeaCenterUI.this).show();
              AppMethodBeat.o(42324);
            }
          });
        }
        for (;;)
        {
          ((d)com.tencent.mm.kernel.g.ab(d.class)).cOk().init(GameOverSeaCenterUI.this);
          c.aA(com.tencent.mm.plugin.game.model.e.cPV());
          com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42326);
              GameOverSeaCenterUI.b(GameOverSeaCenterUI.this).refresh(true);
              AppMethodBeat.o(42326);
            }
          });
          localObject = new com.tencent.mm.plugin.game.model.ap(ab.eUO(), com.tencent.mm.plugin.game.model.e.cPV(), GameOverSeaCenterUI.this.tnx, GameOverSeaCenterUI.this.tny, GameOverSeaCenterUI.this.tnz, GameOverSeaCenterUI.this.tnw);
          com.tencent.mm.kernel.g.agi().a((n)localObject, 0);
          com.tencent.mm.plugin.game.model.e.cQa();
          com.tencent.mm.plugin.game.f.a.a.cRI().cRG();
          AppMethodBeat.o(42327);
          return;
          com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42325);
              try
              {
                GameOverSeaCenterUI.a(GameOverSeaCenterUI.this, this.ttH, 1);
                AppMethodBeat.o(42325);
                return;
              }
              catch (Exception localException)
              {
                ac.e("MicroMsg.GameOverSeaCenterUI", "GameOverSeaCenterUI crash, %s", new Object[] { localException.getMessage() });
                GameOverSeaCenterUI.this.finish();
                AppMethodBeat.o(42325);
              }
            }
          });
        }
      }
    });
    AppMethodBeat.o(42334);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(42336);
    ac.i("MicroMsg.GameOverSeaCenterUI", "onDestroy");
    super.onDestroy();
    com.tencent.mm.plugin.game.f.a.a.cRI().clearCache();
    com.tencent.mm.kernel.g.agi().b(2855, this);
    ((d)com.tencent.mm.kernel.g.ab(d.class)).cOk().clearCache();
    AppMethodBeat.o(42336);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(42335);
    super.onResume();
    if (!this.fPJ)
    {
      if (this.tnw) {
        this.ttB.cRA();
      }
      this.ttA.cRt();
    }
    this.fPJ = false;
    AppMethodBeat.o(42335);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(42338);
    ac.i("MicroMsg.GameOverSeaCenterUI", "errType: %d errCode: %d, scene: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramn.hashCode()) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      switch (paramn.getType())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(42338);
        return;
        final long l = System.currentTimeMillis();
        paramString = ((com.tencent.mm.plugin.game.model.ap)paramn).fYA.hvs.hvw;
        c.bUw().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(42332);
            if (paramString == null) {
              GameOverSeaCenterUI.a(GameOverSeaCenterUI.this, new bk());
            }
            for (;;)
            {
              com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(42331);
                  try
                  {
                    GameOverSeaCenterUI.a(GameOverSeaCenterUI.this, this.ttH, 2);
                    if (GameOverSeaCenterUI.a(GameOverSeaCenterUI.this) != null) {
                      GameOverSeaCenterUI.a(GameOverSeaCenterUI.this).dismiss();
                    }
                    ac.i("MicroMsg.GameOverSeaCenterUI", "Server data parsing time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - GameOverSeaCenterUI.6.this.cev) });
                    AppMethodBeat.o(42331);
                    return;
                  }
                  catch (Exception localException)
                  {
                    for (;;)
                    {
                      ac.e("MicroMsg.GameOverSeaCenterUI", "GameOverSeaCenterUI crash, %s", new Object[] { localException.getMessage() });
                      GameOverSeaCenterUI.this.finish();
                    }
                  }
                }
              });
              AppMethodBeat.o(42332);
              return;
              GameOverSeaCenterUI.a(GameOverSeaCenterUI.this, (bk)paramString);
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
    AppMethodBeat.o(42338);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameOverSeaCenterUI
 * JD-Core Version:    0.7.0.1
 */