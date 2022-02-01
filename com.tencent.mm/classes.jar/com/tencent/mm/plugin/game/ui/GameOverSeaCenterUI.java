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
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.game.api.d;
import com.tencent.mm.plugin.game.d.bk;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.af;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;

public class GameOverSeaCenterUI
  extends GameCenterBaseUI
  implements com.tencent.mm.al.g
{
  private boolean fLX;
  private Dialog oWF;
  private bk rYk;
  k sfi;
  private boolean shW;
  private String shX;
  private View.OnClickListener skf;
  private GameCenterListView slF;
  private g slG;
  private GameInfoViewForeign slH;
  private GameMessageBubbleView slI;
  private GameInstalledView slJ;
  private View slK;
  private TextView slL;
  
  public GameOverSeaCenterUI()
  {
    AppMethodBeat.i(42333);
    this.sfi = new k();
    this.shX = "";
    this.fLX = true;
    this.skf = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42329);
        Object localObject = com.tencent.mm.plugin.game.model.a.cCG();
        int i;
        if (((com.tencent.mm.plugin.game.model.a.a)localObject).dtM == 2) {
          i = c.A(GameOverSeaCenterUI.this.getContext(), ((com.tencent.mm.plugin.game.model.a.a)localObject).url, "game_center_library");
        }
        for (;;)
        {
          com.tencent.mm.game.report.e.a(GameOverSeaCenterUI.this.getContext(), 10, 1005, 1, i, GameOverSeaCenterUI.this.rXI, null);
          AppMethodBeat.o(42329);
          return;
          paramAnonymousView = paramAnonymousView.getTag();
          if ((paramAnonymousView != null) && ((paramAnonymousView instanceof String)) && (!bt.isNullOrNil((String)paramAnonymousView)))
          {
            paramAnonymousView = (String)paramAnonymousView;
            i = c.A(GameOverSeaCenterUI.this.getContext(), paramAnonymousView, "game_center_library");
          }
          else
          {
            localObject = new Intent(GameOverSeaCenterUI.this.getContext(), GameLibraryUI.class);
            ((Intent)localObject).putExtra("game_report_from_scene", 1005);
            paramAnonymousView = GameOverSeaCenterUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/game/ui/GameOverSeaCenterUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
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
    this.slF = ((GameCenterListView)findViewById(2131300365));
    this.slF.setOnItemClickListener(this.sfi);
    this.sfi.setSourceScene(this.rXI);
    this.slG = new g(this);
    this.slG.setSourceScene(this.rXI);
    Object localObject = (LayoutInflater)getContext().getSystemService("layout_inflater");
    View localView = ((LayoutInflater)localObject).inflate(2131494269, this.slF, false);
    this.slH = ((GameInfoViewForeign)localView.findViewById(2131300363));
    this.slF.addHeaderView(localView);
    localView = ((LayoutInflater)localObject).inflate(2131494258, this.slF, false);
    this.slI = ((GameMessageBubbleView)localView.findViewById(2131300517));
    this.slF.addHeaderView(localView);
    localView = ((LayoutInflater)localObject).inflate(2131494270, this.slF, false);
    this.slJ = ((GameInstalledView)localView.findViewById(2131300472));
    this.slF.addHeaderView(localView);
    localObject = ((LayoutInflater)localObject).inflate(2131494263, this.slF, false);
    this.slF.addFooterView((View)localObject);
    this.slK = ((View)localObject).findViewById(2131300459);
    this.slK.setOnClickListener(this.skf);
    this.slL = ((TextView)((View)localObject).findViewById(2131300460));
    this.slF.setAdapter(this.slG);
    AppMethodBeat.o(42337);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42334);
    super.onCreate(paramBundle);
    ad.i("MicroMsg.GameOverSeaCenterUI", "GameOverSeaCenterUI create");
    com.tencent.mm.kernel.g.aeS().a(2855, this);
    initView();
    c.bNl().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(42327);
        Object localObject = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBe().abW("pb_over_sea");
        if (localObject == null) {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42324);
              if (GameOverSeaCenterUI.this.isFinishing())
              {
                AppMethodBeat.o(42324);
                return;
              }
              GameOverSeaCenterUI.a(GameOverSeaCenterUI.this, c.fi(GameOverSeaCenterUI.this));
              GameOverSeaCenterUI.a(GameOverSeaCenterUI.this).show();
              AppMethodBeat.o(42324);
            }
          });
        }
        for (;;)
        {
          ((d)com.tencent.mm.kernel.g.ab(d.class)).cBb().init(GameOverSeaCenterUI.this);
          c.at(com.tencent.mm.plugin.game.model.e.cCL());
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42326);
              GameOverSeaCenterUI.b(GameOverSeaCenterUI.this).refresh(true);
              AppMethodBeat.o(42326);
            }
          });
          localObject = new com.tencent.mm.plugin.game.model.ap(ac.eFu(), com.tencent.mm.plugin.game.model.e.cCL(), GameOverSeaCenterUI.this.sfE, GameOverSeaCenterUI.this.sfF, GameOverSeaCenterUI.this.sfG, GameOverSeaCenterUI.this.sfD);
          com.tencent.mm.kernel.g.aeS().a((n)localObject, 0);
          com.tencent.mm.plugin.game.model.e.cCQ();
          com.tencent.mm.plugin.game.f.a.a.cEy().cEw();
          AppMethodBeat.o(42327);
          return;
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42325);
              try
              {
                GameOverSeaCenterUI.a(GameOverSeaCenterUI.this, this.slO, 1);
                AppMethodBeat.o(42325);
                return;
              }
              catch (Exception localException)
              {
                ad.e("MicroMsg.GameOverSeaCenterUI", "GameOverSeaCenterUI crash, %s", new Object[] { localException.getMessage() });
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
    ad.i("MicroMsg.GameOverSeaCenterUI", "onDestroy");
    super.onDestroy();
    com.tencent.mm.plugin.game.f.a.a.cEy().clearCache();
    com.tencent.mm.kernel.g.aeS().b(2855, this);
    ((d)com.tencent.mm.kernel.g.ab(d.class)).cBb().clearCache();
    AppMethodBeat.o(42336);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(42335);
    super.onResume();
    if (!this.fLX)
    {
      if (this.sfD) {
        this.slI.cEq();
      }
      this.slH.cEj();
    }
    this.fLX = false;
    AppMethodBeat.o(42335);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(42338);
    ad.i("MicroMsg.GameOverSeaCenterUI", "errType: %d errCode: %d, scene: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramn.hashCode()) });
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
        paramString = ((com.tencent.mm.plugin.game.model.ap)paramn).fUF.gUT.gUX;
        c.bNl().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(42332);
            if (paramString == null) {
              GameOverSeaCenterUI.a(GameOverSeaCenterUI.this, new bk());
            }
            for (;;)
            {
              aq.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(42331);
                  try
                  {
                    GameOverSeaCenterUI.a(GameOverSeaCenterUI.this, this.slO, 2);
                    if (GameOverSeaCenterUI.a(GameOverSeaCenterUI.this) != null) {
                      GameOverSeaCenterUI.a(GameOverSeaCenterUI.this).dismiss();
                    }
                    ad.i("MicroMsg.GameOverSeaCenterUI", "Server data parsing time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - GameOverSeaCenterUI.6.this.chA) });
                    AppMethodBeat.o(42331);
                    return;
                  }
                  catch (Exception localException)
                  {
                    for (;;)
                    {
                      ad.e("MicroMsg.GameOverSeaCenterUI", "GameOverSeaCenterUI crash, %s", new Object[] { localException.getMessage() });
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
    if (!com.tencent.mm.plugin.game.a.a.hYu.a(this, paramInt1, paramInt2, paramString)) {
      Toast.makeText(this, getString(2131759916, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    if (this.oWF != null) {
      this.oWF.cancel();
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