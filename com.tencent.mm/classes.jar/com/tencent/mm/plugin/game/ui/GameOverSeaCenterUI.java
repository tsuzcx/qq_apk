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
import com.tencent.mm.plugin.game.d.bn;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.af;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;

public class GameOverSeaCenterUI
  extends GameCenterBaseUI
  implements com.tencent.mm.al.f
{
  private boolean gjj;
  private Dialog qdv;
  private bn udS;
  k ulz;
  private boolean uon;
  private String uoo;
  private View.OnClickListener uqv;
  private GameCenterListView urX;
  private g urY;
  private GameInfoViewForeign urZ;
  private GameMessageBubbleView usa;
  private GameInstalledView usb;
  private View usc;
  private TextView usd;
  
  public GameOverSeaCenterUI()
  {
    AppMethodBeat.i(42333);
    this.ulz = new k();
    this.uoo = "";
    this.gjj = true;
    this.uqv = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42329);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameOverSeaCenterUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        localObject = com.tencent.mm.plugin.game.model.a.cYv();
        int i;
        if (((com.tencent.mm.plugin.game.model.a.a)localObject).dDp == 2) {
          i = c.B(GameOverSeaCenterUI.this.getContext(), ((com.tencent.mm.plugin.game.model.a.a)localObject).url, "game_center_library");
        }
        for (;;)
        {
          com.tencent.mm.game.report.f.a(GameOverSeaCenterUI.this.getContext(), 10, 1005, 1, i, GameOverSeaCenterUI.this.udq, null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameOverSeaCenterUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(42329);
          return;
          paramAnonymousView = paramAnonymousView.getTag();
          if ((paramAnonymousView != null) && ((paramAnonymousView instanceof String)) && (!bt.isNullOrNil((String)paramAnonymousView)))
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
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/game/ui/GameOverSeaCenterUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
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
    this.urX = ((GameCenterListView)findViewById(2131300365));
    this.urX.setOnItemClickListener(this.ulz);
    this.ulz.setSourceScene(this.udq);
    this.urY = new g(this);
    this.urY.setSourceScene(this.udq);
    Object localObject = (LayoutInflater)getContext().getSystemService("layout_inflater");
    View localView = ((LayoutInflater)localObject).inflate(2131494269, this.urX, false);
    this.urZ = ((GameInfoViewForeign)localView.findViewById(2131300363));
    this.urX.addHeaderView(localView);
    localView = ((LayoutInflater)localObject).inflate(2131494258, this.urX, false);
    this.usa = ((GameMessageBubbleView)localView.findViewById(2131300517));
    this.urX.addHeaderView(localView);
    localView = ((LayoutInflater)localObject).inflate(2131494270, this.urX, false);
    this.usb = ((GameInstalledView)localView.findViewById(2131300472));
    this.urX.addHeaderView(localView);
    localObject = ((LayoutInflater)localObject).inflate(2131494263, this.urX, false);
    this.urX.addFooterView((View)localObject);
    this.usc = ((View)localObject).findViewById(2131300459);
    this.usc.setOnClickListener(this.uqv);
    this.usd = ((TextView)((View)localObject).findViewById(2131300460));
    this.urX.setAdapter(this.urY);
    AppMethodBeat.o(42337);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42334);
    super.onCreate(paramBundle);
    ad.i("MicroMsg.GameOverSeaCenterUI", "GameOverSeaCenterUI create");
    com.tencent.mm.kernel.g.aiU().a(2855, this);
    initView();
    c.bZb().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(42327);
        Object localObject = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cWI().all("pb_over_sea");
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
              GameOverSeaCenterUI.a(GameOverSeaCenterUI.this, c.fA(GameOverSeaCenterUI.this));
              GameOverSeaCenterUI.a(GameOverSeaCenterUI.this).show();
              AppMethodBeat.o(42324);
            }
          });
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cWF().init(GameOverSeaCenterUI.this);
          c.aC(com.tencent.mm.plugin.game.model.e.cYA());
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42326);
              GameOverSeaCenterUI.b(GameOverSeaCenterUI.this).refresh(true);
              AppMethodBeat.o(42326);
            }
          });
          localObject = new com.tencent.mm.plugin.game.model.ap(ac.fks(), com.tencent.mm.plugin.game.model.e.cYA(), GameOverSeaCenterUI.this.ulV, GameOverSeaCenterUI.this.ulW, GameOverSeaCenterUI.this.ulX, GameOverSeaCenterUI.this.ulU);
          com.tencent.mm.kernel.g.aiU().a((n)localObject, 0);
          com.tencent.mm.plugin.game.model.e.cYF();
          com.tencent.mm.plugin.game.f.a.a.das().daq();
          AppMethodBeat.o(42327);
          return;
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42325);
              try
              {
                GameOverSeaCenterUI.a(GameOverSeaCenterUI.this, this.usg, 1);
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
    com.tencent.mm.plugin.game.f.a.a.das().clearCache();
    com.tencent.mm.kernel.g.aiU().b(2855, this);
    ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cWF().clearCache();
    AppMethodBeat.o(42336);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(42335);
    super.onResume();
    if (!this.gjj)
    {
      if (this.ulU) {
        this.usa.daf();
      }
      this.urZ.cZY();
    }
    this.gjj = false;
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
        paramString = ((com.tencent.mm.plugin.game.model.ap)paramn).grW.hNL.hNQ;
        c.bZb().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(42332);
            if (paramString == null) {
              GameOverSeaCenterUI.a(GameOverSeaCenterUI.this, new bn());
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
                    GameOverSeaCenterUI.a(GameOverSeaCenterUI.this, this.usg, 2);
                    if (GameOverSeaCenterUI.a(GameOverSeaCenterUI.this) != null) {
                      GameOverSeaCenterUI.a(GameOverSeaCenterUI.this).dismiss();
                    }
                    ad.i("MicroMsg.GameOverSeaCenterUI", "Server data parsing time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - GameOverSeaCenterUI.6.this.coM) });
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
              GameOverSeaCenterUI.a(GameOverSeaCenterUI.this, (bn)paramString);
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
    AppMethodBeat.o(42338);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameOverSeaCenterUI
 * JD-Core Version:    0.7.0.1
 */