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
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.af;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.plugin.game.protobuf.bu;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public class GameOverSeaCenterUI
  extends GameCenterBaseUI
  implements i
{
  private boolean gWt;
  private Dialog rAV;
  private bu xHt;
  k xOW;
  private boolean xRI;
  private String xRJ;
  private View.OnClickListener xTP;
  private GameCenterListView xVo;
  private g xVp;
  private GameInfoViewForeign xVq;
  private GameMessageBubbleView xVr;
  private GameInstalledView xVs;
  private View xVt;
  private TextView xVu;
  
  public GameOverSeaCenterUI()
  {
    AppMethodBeat.i(42333);
    this.xOW = new k();
    this.xRJ = "";
    this.gWt = true;
    this.xTP = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42329);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameOverSeaCenterUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        localObject = com.tencent.mm.plugin.game.model.a.dUM();
        int i;
        if (((com.tencent.mm.plugin.game.model.a.a)localObject).cSx == 2) {
          i = c.D(GameOverSeaCenterUI.this.getContext(), ((com.tencent.mm.plugin.game.model.a.a)localObject).url, "game_center_library");
        }
        for (;;)
        {
          com.tencent.mm.game.report.f.a(GameOverSeaCenterUI.this.getContext(), 10, 1005, 1, i, GameOverSeaCenterUI.this.xGR, null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameOverSeaCenterUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(42329);
          return;
          paramAnonymousView = paramAnonymousView.getTag();
          if ((paramAnonymousView != null) && ((paramAnonymousView instanceof String)) && (!Util.isNullOrNil((String)paramAnonymousView)))
          {
            paramAnonymousView = (String)paramAnonymousView;
            i = c.D(GameOverSeaCenterUI.this.getContext(), paramAnonymousView, "game_center_library");
          }
          else
          {
            localObject = new Intent(GameOverSeaCenterUI.this.getContext(), GameLibraryUI.class);
            ((Intent)localObject).putExtra("game_report_from_scene", 1005);
            paramAnonymousView = GameOverSeaCenterUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/game/ui/GameOverSeaCenterUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
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
    return 2131494822;
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
    setMMTitle(2131761376);
    this.xVo = ((GameCenterListView)findViewById(2131301888));
    this.xVo.setOnItemClickListener(this.xOW);
    this.xOW.setSourceScene(this.xGR);
    this.xVp = new g(this);
    this.xVp.setSourceScene(this.xGR);
    Object localObject = (LayoutInflater)getContext().getSystemService("layout_inflater");
    View localView = ((LayoutInflater)localObject).inflate(2131494830, this.xVo, false);
    this.xVq = ((GameInfoViewForeign)localView.findViewById(2131301885));
    this.xVo.addHeaderView(localView);
    localView = ((LayoutInflater)localObject).inflate(2131494819, this.xVo, false);
    this.xVr = ((GameMessageBubbleView)localView.findViewById(2131302044));
    this.xVo.addHeaderView(localView);
    localView = ((LayoutInflater)localObject).inflate(2131494831, this.xVo, false);
    this.xVs = ((GameInstalledView)localView.findViewById(2131301995));
    this.xVo.addHeaderView(localView);
    localObject = ((LayoutInflater)localObject).inflate(2131494824, this.xVo, false);
    this.xVo.addFooterView((View)localObject);
    this.xVt = ((View)localObject).findViewById(2131301982);
    this.xVt.setOnClickListener(this.xTP);
    this.xVu = ((TextView)((View)localObject).findViewById(2131301983));
    this.xVo.setAdapter(this.xVp);
    AppMethodBeat.o(42337);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42334);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.GameOverSeaCenterUI", "GameOverSeaCenterUI create");
    com.tencent.mm.kernel.g.azz().a(2855, this);
    initView();
    c.cyh().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(42327);
        Object localObject = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class)).dSL().azn("pb_over_sea");
        if (localObject == null) {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42324);
              if (GameOverSeaCenterUI.this.isFinishing())
              {
                AppMethodBeat.o(42324);
                return;
              }
              GameOverSeaCenterUI.a(GameOverSeaCenterUI.this, c.gl(GameOverSeaCenterUI.this));
              GameOverSeaCenterUI.a(GameOverSeaCenterUI.this).show();
              AppMethodBeat.o(42324);
            }
          });
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.e.class)).dSI().init(GameOverSeaCenterUI.this);
          c.aX(com.tencent.mm.plugin.game.model.e.dUR());
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42326);
              GameOverSeaCenterUI.b(GameOverSeaCenterUI.this).refresh(true);
              AppMethodBeat.o(42326);
            }
          });
          localObject = new ap(LocaleUtil.getApplicationLanguage(), com.tencent.mm.plugin.game.model.e.dUR(), GameOverSeaCenterUI.this.xPs, GameOverSeaCenterUI.this.xPt, GameOverSeaCenterUI.this.xPu, GameOverSeaCenterUI.this.xPr);
          com.tencent.mm.kernel.g.azz().a((q)localObject, 0);
          com.tencent.mm.plugin.game.model.e.dUW();
          com.tencent.mm.plugin.game.e.a.a.dWO().dWM();
          AppMethodBeat.o(42327);
          return;
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42325);
              try
              {
                GameOverSeaCenterUI.a(GameOverSeaCenterUI.this, this.xVx, 1);
                AppMethodBeat.o(42325);
                return;
              }
              catch (Exception localException)
              {
                Log.e("MicroMsg.GameOverSeaCenterUI", "GameOverSeaCenterUI crash, %s", new Object[] { localException.getMessage() });
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
    Log.i("MicroMsg.GameOverSeaCenterUI", "onDestroy");
    super.onDestroy();
    com.tencent.mm.plugin.game.e.a.a.dWO().clearCache();
    com.tencent.mm.kernel.g.azz().b(2855, this);
    ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.e.class)).dSI().clearCache();
    AppMethodBeat.o(42336);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(42335);
    super.onResume();
    if (!this.gWt)
    {
      if (this.xPr) {
        this.xVr.dWx();
      }
      this.xVq.dWq();
    }
    this.gWt = false;
    AppMethodBeat.o(42335);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(42338);
    Log.i("MicroMsg.GameOverSeaCenterUI", "errType: %d errCode: %d, scene: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramq.hashCode()) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      switch (paramq.getType())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(42338);
        return;
        final long l = System.currentTimeMillis();
        paramString = ((ap)paramq).hhm.iLL.iLR;
        c.cyh().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(42332);
            if (paramString == null) {
              GameOverSeaCenterUI.a(GameOverSeaCenterUI.this, new bu());
            }
            for (;;)
            {
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(42331);
                  try
                  {
                    GameOverSeaCenterUI.a(GameOverSeaCenterUI.this, this.xVx, 2);
                    if (GameOverSeaCenterUI.a(GameOverSeaCenterUI.this) != null) {
                      GameOverSeaCenterUI.a(GameOverSeaCenterUI.this).dismiss();
                    }
                    Log.i("MicroMsg.GameOverSeaCenterUI", "Server data parsing time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - GameOverSeaCenterUI.6.this.cBb) });
                    AppMethodBeat.o(42331);
                    return;
                  }
                  catch (Exception localException)
                  {
                    for (;;)
                    {
                      Log.e("MicroMsg.GameOverSeaCenterUI", "GameOverSeaCenterUI crash, %s", new Object[] { localException.getMessage() });
                      GameOverSeaCenterUI.this.finish();
                    }
                  }
                }
              });
              AppMethodBeat.o(42332);
              return;
              GameOverSeaCenterUI.a(GameOverSeaCenterUI.this, (bu)paramString);
            }
          }
        });
      }
    }
    if (!com.tencent.mm.plugin.game.a.a.jRu.a(this, paramInt1, paramInt2, paramString)) {
      Toast.makeText(this, getString(2131761264, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    if (this.rAV != null) {
      this.rAV.cancel();
    }
    AppMethodBeat.o(42338);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameOverSeaCenterUI
 * JD-Core Version:    0.7.0.1
 */