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
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.af;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;

public class GameOverSeaCenterUI
  extends GameCenterBaseUI
  implements com.tencent.mm.ak.f
{
  private boolean glB;
  private Dialog qka;
  private View.OnClickListener uBR;
  private GameCenterListView uDq;
  private g uDr;
  private GameInfoViewForeign uDs;
  private GameMessageBubbleView uDt;
  private GameInstalledView uDu;
  private View uDv;
  private TextView uDw;
  private com.tencent.mm.plugin.game.d.bu upa;
  k uwW;
  private boolean uzJ;
  private String uzK;
  
  public GameOverSeaCenterUI()
  {
    AppMethodBeat.i(42333);
    this.uwW = new k();
    this.uzK = "";
    this.glB = true;
    this.uBR = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42329);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameOverSeaCenterUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        localObject = com.tencent.mm.plugin.game.model.a.dbf();
        int i;
        if (((com.tencent.mm.plugin.game.model.a.a)localObject).dEu == 2) {
          i = c.B(GameOverSeaCenterUI.this.getContext(), ((com.tencent.mm.plugin.game.model.a.a)localObject).url, "game_center_library");
        }
        for (;;)
        {
          com.tencent.mm.game.report.f.a(GameOverSeaCenterUI.this.getContext(), 10, 1005, 1, i, GameOverSeaCenterUI.this.uoy, null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameOverSeaCenterUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(42329);
          return;
          paramAnonymousView = paramAnonymousView.getTag();
          if ((paramAnonymousView != null) && ((paramAnonymousView instanceof String)) && (!com.tencent.mm.sdk.platformtools.bu.isNullOrNil((String)paramAnonymousView)))
          {
            paramAnonymousView = (String)paramAnonymousView;
            i = c.B(GameOverSeaCenterUI.this.getContext(), paramAnonymousView, "game_center_library");
          }
          else
          {
            localObject = new Intent(GameOverSeaCenterUI.this.getContext(), GameLibraryUI.class);
            ((Intent)localObject).putExtra("game_report_from_scene", 1005);
            paramAnonymousView = GameOverSeaCenterUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/game/ui/GameOverSeaCenterUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
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
    this.uDq = ((GameCenterListView)findViewById(2131300365));
    this.uDq.setOnItemClickListener(this.uwW);
    this.uwW.setSourceScene(this.uoy);
    this.uDr = new g(this);
    this.uDr.setSourceScene(this.uoy);
    Object localObject = (LayoutInflater)getContext().getSystemService("layout_inflater");
    View localView = ((LayoutInflater)localObject).inflate(2131494269, this.uDq, false);
    this.uDs = ((GameInfoViewForeign)localView.findViewById(2131300363));
    this.uDq.addHeaderView(localView);
    localView = ((LayoutInflater)localObject).inflate(2131494258, this.uDq, false);
    this.uDt = ((GameMessageBubbleView)localView.findViewById(2131300517));
    this.uDq.addHeaderView(localView);
    localView = ((LayoutInflater)localObject).inflate(2131494270, this.uDq, false);
    this.uDu = ((GameInstalledView)localView.findViewById(2131300472));
    this.uDq.addHeaderView(localView);
    localObject = ((LayoutInflater)localObject).inflate(2131494263, this.uDq, false);
    this.uDq.addFooterView((View)localObject);
    this.uDv = ((View)localObject).findViewById(2131300459);
    this.uDv.setOnClickListener(this.uBR);
    this.uDw = ((TextView)((View)localObject).findViewById(2131300460));
    this.uDq.setAdapter(this.uDr);
    AppMethodBeat.o(42337);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42334);
    super.onCreate(paramBundle);
    ae.i("MicroMsg.GameOverSeaCenterUI", "GameOverSeaCenterUI create");
    com.tencent.mm.kernel.g.ajj().a(2855, this);
    initView();
    c.caq().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(42327);
        Object localObject = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cZm().amj("pb_over_sea");
        if (localObject == null) {
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42324);
              if (GameOverSeaCenterUI.this.isFinishing())
              {
                AppMethodBeat.o(42324);
                return;
              }
              GameOverSeaCenterUI.a(GameOverSeaCenterUI.this, c.fF(GameOverSeaCenterUI.this));
              GameOverSeaCenterUI.a(GameOverSeaCenterUI.this).show();
              AppMethodBeat.o(42324);
            }
          });
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cZj().init(GameOverSeaCenterUI.this);
          c.aC(com.tencent.mm.plugin.game.model.e.dbk());
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42326);
              GameOverSeaCenterUI.b(GameOverSeaCenterUI.this).refresh(true);
              AppMethodBeat.o(42326);
            }
          });
          localObject = new ap(ad.fom(), com.tencent.mm.plugin.game.model.e.dbk(), GameOverSeaCenterUI.this.uxs, GameOverSeaCenterUI.this.uxt, GameOverSeaCenterUI.this.uxu, GameOverSeaCenterUI.this.uxr);
          com.tencent.mm.kernel.g.ajj().a((n)localObject, 0);
          com.tencent.mm.plugin.game.model.e.dbp();
          com.tencent.mm.plugin.game.f.a.a.dde().ddc();
          AppMethodBeat.o(42327);
          return;
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42325);
              try
              {
                GameOverSeaCenterUI.a(GameOverSeaCenterUI.this, this.uDz, 1);
                AppMethodBeat.o(42325);
                return;
              }
              catch (Exception localException)
              {
                ae.e("MicroMsg.GameOverSeaCenterUI", "GameOverSeaCenterUI crash, %s", new Object[] { localException.getMessage() });
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
    ae.i("MicroMsg.GameOverSeaCenterUI", "onDestroy");
    super.onDestroy();
    com.tencent.mm.plugin.game.f.a.a.dde().clearCache();
    com.tencent.mm.kernel.g.ajj().b(2855, this);
    ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cZj().clearCache();
    AppMethodBeat.o(42336);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(42335);
    super.onResume();
    if (!this.glB)
    {
      if (this.uxr) {
        this.uDt.dcQ();
      }
      this.uDs.dcJ();
    }
    this.glB = false;
    AppMethodBeat.o(42335);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(42338);
    ae.i("MicroMsg.GameOverSeaCenterUI", "errType: %d errCode: %d, scene: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramn.hashCode()) });
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
        paramString = ((ap)paramn).gux.hQE.hQJ;
        c.caq().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(42332);
            if (paramString == null) {
              GameOverSeaCenterUI.a(GameOverSeaCenterUI.this, new com.tencent.mm.plugin.game.d.bu());
            }
            for (;;)
            {
              ar.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(42331);
                  try
                  {
                    GameOverSeaCenterUI.a(GameOverSeaCenterUI.this, this.uDz, 2);
                    if (GameOverSeaCenterUI.a(GameOverSeaCenterUI.this) != null) {
                      GameOverSeaCenterUI.a(GameOverSeaCenterUI.this).dismiss();
                    }
                    ae.i("MicroMsg.GameOverSeaCenterUI", "Server data parsing time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - GameOverSeaCenterUI.6.this.coO) });
                    AppMethodBeat.o(42331);
                    return;
                  }
                  catch (Exception localException)
                  {
                    for (;;)
                    {
                      ae.e("MicroMsg.GameOverSeaCenterUI", "GameOverSeaCenterUI crash, %s", new Object[] { localException.getMessage() });
                      GameOverSeaCenterUI.this.finish();
                    }
                  }
                }
              });
              AppMethodBeat.o(42332);
              return;
              GameOverSeaCenterUI.a(GameOverSeaCenterUI.this, (com.tencent.mm.plugin.game.d.bu)paramString);
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
    AppMethodBeat.o(42338);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameOverSeaCenterUI
 * JD-Core Version:    0.7.0.1
 */