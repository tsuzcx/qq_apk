package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.game.api.d;
import com.tencent.mm.plugin.game.d.av;
import com.tencent.mm.plugin.game.d.bi;
import com.tencent.mm.plugin.game.d.r;
import com.tencent.mm.plugin.game.f.a.a;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;

public class GameDownloadGuidanceUI
  extends GameCenterBaseUI
  implements com.tencent.mm.ak.g
{
  private Dialog pzQ;
  private LinearLayout qTW;
  private bi tfO;
  private TextView tpN;
  private TextView tpO;
  private TextView tpP;
  private boolean tpQ;
  private String tpR = "";
  
  public final void a(com.tencent.mm.plugin.game.model.ab paramab, int paramInt)
  {
    AppMethodBeat.i(42060);
    if (isFinishing())
    {
      ac.w("MicroMsg.GameDownloadGuidanceUI", "GameDownloadGuidanceUI hasFinished");
      AppMethodBeat.o(42060);
      return;
    }
    if ((paramab == null) || (paramab.cQP() == null))
    {
      ac.e("MicroMsg.GameDownloadGuidanceUI", "Null data");
      AppMethodBeat.o(42060);
      return;
    }
    if ((paramab != null) && (paramab.cQQ() != null))
    {
      this.tpR = paramab.cQQ().thh;
      if (bs.isNullOrNil(this.tpR)) {
        break label243;
      }
      if (!this.tpQ)
      {
        addIconOptionMenu(0, 2131689511, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(42054);
            int i = c.ay(GameDownloadGuidanceUI.this.getContext(), GameDownloadGuidanceUI.c(GameDownloadGuidanceUI.this));
            com.tencent.mm.game.report.e.a(GameDownloadGuidanceUI.this.getContext(), 10, 1008, 1, i, GameDownloadGuidanceUI.this.tfA, null);
            AppMethodBeat.o(42054);
            return true;
          }
        });
        this.tpQ = true;
      }
      label108:
      this.qTW.setVisibility(0);
      paramab = paramab.cQP();
      if (bs.isNullOrNil(paramab.tie)) {
        break label264;
      }
      this.tpN.setText(paramab.tie);
      this.tpN.setVisibility(0);
      label150:
      if (bs.isNullOrNil(paramab.tif)) {
        break label276;
      }
      this.tpO.setText(paramab.tif);
      this.tpO.setVisibility(0);
      label179:
      if (bs.isNullOrNil(paramab.tig)) {
        break label288;
      }
      this.tpP.setText(paramab.tig);
      this.tpP.setVisibility(0);
    }
    for (;;)
    {
      if (paramInt == 2) {
        c.bUw().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(42053);
            ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOn().b("pb_over_sea", GameDownloadGuidanceUI.b(GameDownloadGuidanceUI.this));
            AppMethodBeat.o(42053);
          }
        });
      }
      AppMethodBeat.o(42060);
      return;
      this.tpR = "";
      break;
      label243:
      if (!this.tpQ) {
        break label108;
      }
      removeOptionMenu(0);
      this.tpQ = false;
      break label108;
      label264:
      this.tpN.setVisibility(8);
      break label150;
      label276:
      this.tpO.setVisibility(8);
      break label179;
      label288:
      this.tpP.setVisibility(8);
    }
  }
  
  public int getLayoutId()
  {
    return 2131494316;
  }
  
  public void initView()
  {
    AppMethodBeat.i(42059);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(42049);
        GameDownloadGuidanceUI.this.finish();
        AppMethodBeat.o(42049);
        return true;
      }
    });
    setMMTitle(2131760012);
    this.qTW = ((LinearLayout)findViewById(2131298736));
    this.tpN = ((TextView)findViewById(2131301985));
    this.tpO = ((TextView)findViewById(2131304469));
    this.tpP = ((TextView)findViewById(2131304461));
    AppMethodBeat.o(42059);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42057);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.agi().a(2586, this);
    initView();
    c.bUw().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(42052);
        Object localObject = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOn().agO("pb_download_guidance");
        if (localObject == null) {
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42050);
              if (GameDownloadGuidanceUI.this.isFinishing())
              {
                AppMethodBeat.o(42050);
                return;
              }
              GameDownloadGuidanceUI.a(GameDownloadGuidanceUI.this, c.fv(GameDownloadGuidanceUI.this));
              GameDownloadGuidanceUI.a(GameDownloadGuidanceUI.this).show();
              AppMethodBeat.o(42050);
            }
          });
        }
        for (;;)
        {
          localObject = new com.tencent.mm.plugin.game.model.ao(com.tencent.mm.sdk.platformtools.ab.eUO(), com.tencent.mm.plugin.game.model.e.cPV(), GameDownloadGuidanceUI.this.tnx, GameDownloadGuidanceUI.this.tny, GameDownloadGuidanceUI.this.tnz, GameDownloadGuidanceUI.this.tnw);
          com.tencent.mm.kernel.g.agi().a((n)localObject, 0);
          com.tencent.mm.plugin.game.model.e.cQa();
          a.a.cRI().cRG();
          AppMethodBeat.o(42052);
          return;
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42051);
              try
              {
                GameDownloadGuidanceUI.this.a(this.tpU, 1);
                AppMethodBeat.o(42051);
                return;
              }
              catch (Exception localException)
              {
                ac.e("MicroMsg.GameDownloadGuidanceUI", "GameDownloadGuidanceUI crash, %s", new Object[] { localException.getMessage() });
                GameDownloadGuidanceUI.this.finish();
                AppMethodBeat.o(42051);
              }
            }
          });
        }
      }
    });
    AppMethodBeat.o(42057);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(42058);
    ac.i("MicroMsg.GameDownloadGuidanceUI", "onDestroy");
    super.onDestroy();
    a.a.cRI().clearCache();
    com.tencent.mm.kernel.g.agi().b(2586, this);
    ((d)com.tencent.mm.kernel.g.ab(d.class)).cOk().clearCache();
    AppMethodBeat.o(42058);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(42061);
    ac.i("MicroMsg.GameDownloadGuidanceUI", "errType: %d errCode: %d, scene: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramn.hashCode()) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      switch (paramn.getType())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(42061);
        return;
        final long l = System.currentTimeMillis();
        paramString = ((com.tencent.mm.plugin.game.model.ao)paramn).fYA.hvs.hvw;
        c.bUw().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(42056);
            if (paramString == null) {
              GameDownloadGuidanceUI.a(GameDownloadGuidanceUI.this, new bi());
            }
            for (;;)
            {
              ap.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(42055);
                  try
                  {
                    GameDownloadGuidanceUI.this.a(this.tpU, 2);
                    if (GameDownloadGuidanceUI.a(GameDownloadGuidanceUI.this) != null) {
                      GameDownloadGuidanceUI.a(GameDownloadGuidanceUI.this).dismiss();
                    }
                    ac.i("MicroMsg.GameDownloadGuidanceUI", "Server data parsing time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - GameDownloadGuidanceUI.5.this.cev) });
                    AppMethodBeat.o(42055);
                    return;
                  }
                  catch (Exception localException)
                  {
                    for (;;)
                    {
                      ac.e("MicroMsg.GameDownloadGuidanceUI", "GameDownloadGuidanceUI crash, %s", new Object[] { localException.getMessage() });
                      GameDownloadGuidanceUI.this.finish();
                    }
                  }
                }
              });
              AppMethodBeat.o(42056);
              return;
              GameDownloadGuidanceUI.a(GameDownloadGuidanceUI.this, (bi)paramString);
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
    AppMethodBeat.o(42061);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDownloadGuidanceUI
 * JD-Core Version:    0.7.0.1
 */