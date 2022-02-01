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
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.game.api.d;
import com.tencent.mm.plugin.game.d.av;
import com.tencent.mm.plugin.game.d.bi;
import com.tencent.mm.plugin.game.d.r;
import com.tencent.mm.plugin.game.f.a.a;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.ab;
import com.tencent.mm.plugin.game.model.ao;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;

public class GameDownloadGuidanceUI
  extends GameCenterBaseUI
  implements com.tencent.mm.al.g
{
  private Dialog oWF;
  private LinearLayout qlu;
  private bi rXW;
  private TextView shT;
  private TextView shU;
  private TextView shV;
  private boolean shW;
  private String shX = "";
  
  public final void a(ab paramab, int paramInt)
  {
    AppMethodBeat.i(42060);
    if (isFinishing())
    {
      ad.w("MicroMsg.GameDownloadGuidanceUI", "GameDownloadGuidanceUI hasFinished");
      AppMethodBeat.o(42060);
      return;
    }
    if ((paramab == null) || (paramab.cDF() == null))
    {
      ad.e("MicroMsg.GameDownloadGuidanceUI", "Null data");
      AppMethodBeat.o(42060);
      return;
    }
    if ((paramab != null) && (paramab.cDG() != null))
    {
      this.shX = paramab.cDG().rZo;
      if (bt.isNullOrNil(this.shX)) {
        break label243;
      }
      if (!this.shW)
      {
        addIconOptionMenu(0, 2131689511, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(42054);
            int i = c.ax(GameDownloadGuidanceUI.this.getContext(), GameDownloadGuidanceUI.c(GameDownloadGuidanceUI.this));
            com.tencent.mm.game.report.e.a(GameDownloadGuidanceUI.this.getContext(), 10, 1008, 1, i, GameDownloadGuidanceUI.this.rXI, null);
            AppMethodBeat.o(42054);
            return true;
          }
        });
        this.shW = true;
      }
      label108:
      this.qlu.setVisibility(0);
      paramab = paramab.cDF();
      if (bt.isNullOrNil(paramab.sak)) {
        break label264;
      }
      this.shT.setText(paramab.sak);
      this.shT.setVisibility(0);
      label150:
      if (bt.isNullOrNil(paramab.sal)) {
        break label276;
      }
      this.shU.setText(paramab.sal);
      this.shU.setVisibility(0);
      label179:
      if (bt.isNullOrNil(paramab.sam)) {
        break label288;
      }
      this.shV.setText(paramab.sam);
      this.shV.setVisibility(0);
    }
    for (;;)
    {
      if (paramInt == 2) {
        c.bNl().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(42053);
            ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBe().b("pb_over_sea", GameDownloadGuidanceUI.b(GameDownloadGuidanceUI.this));
            AppMethodBeat.o(42053);
          }
        });
      }
      AppMethodBeat.o(42060);
      return;
      this.shX = "";
      break;
      label243:
      if (!this.shW) {
        break label108;
      }
      removeOptionMenu(0);
      this.shW = false;
      break label108;
      label264:
      this.shT.setVisibility(8);
      break label150;
      label276:
      this.shU.setVisibility(8);
      break label179;
      label288:
      this.shV.setVisibility(8);
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
    this.qlu = ((LinearLayout)findViewById(2131298736));
    this.shT = ((TextView)findViewById(2131301985));
    this.shU = ((TextView)findViewById(2131304469));
    this.shV = ((TextView)findViewById(2131304461));
    AppMethodBeat.o(42059);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42057);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.aeS().a(2586, this);
    initView();
    c.bNl().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(42052);
        Object localObject = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBe().abW("pb_download_guidance");
        if (localObject == null) {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42050);
              if (GameDownloadGuidanceUI.this.isFinishing())
              {
                AppMethodBeat.o(42050);
                return;
              }
              GameDownloadGuidanceUI.a(GameDownloadGuidanceUI.this, c.fi(GameDownloadGuidanceUI.this));
              GameDownloadGuidanceUI.a(GameDownloadGuidanceUI.this).show();
              AppMethodBeat.o(42050);
            }
          });
        }
        for (;;)
        {
          localObject = new ao(ac.eFu(), com.tencent.mm.plugin.game.model.e.cCL(), GameDownloadGuidanceUI.this.sfE, GameDownloadGuidanceUI.this.sfF, GameDownloadGuidanceUI.this.sfG, GameDownloadGuidanceUI.this.sfD);
          com.tencent.mm.kernel.g.aeS().a((n)localObject, 0);
          com.tencent.mm.plugin.game.model.e.cCQ();
          a.a.cEy().cEw();
          AppMethodBeat.o(42052);
          return;
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42051);
              try
              {
                GameDownloadGuidanceUI.this.a(this.sia, 1);
                AppMethodBeat.o(42051);
                return;
              }
              catch (Exception localException)
              {
                ad.e("MicroMsg.GameDownloadGuidanceUI", "GameDownloadGuidanceUI crash, %s", new Object[] { localException.getMessage() });
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
    ad.i("MicroMsg.GameDownloadGuidanceUI", "onDestroy");
    super.onDestroy();
    a.a.cEy().clearCache();
    com.tencent.mm.kernel.g.aeS().b(2586, this);
    ((d)com.tencent.mm.kernel.g.ab(d.class)).cBb().clearCache();
    AppMethodBeat.o(42058);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(42061);
    ad.i("MicroMsg.GameDownloadGuidanceUI", "errType: %d errCode: %d, scene: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramn.hashCode()) });
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
        paramString = ((ao)paramn).fUF.gUT.gUX;
        c.bNl().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(42056);
            if (paramString == null) {
              GameDownloadGuidanceUI.a(GameDownloadGuidanceUI.this, new bi());
            }
            for (;;)
            {
              aq.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(42055);
                  try
                  {
                    GameDownloadGuidanceUI.this.a(this.sia, 2);
                    if (GameDownloadGuidanceUI.a(GameDownloadGuidanceUI.this) != null) {
                      GameDownloadGuidanceUI.a(GameDownloadGuidanceUI.this).dismiss();
                    }
                    ad.i("MicroMsg.GameDownloadGuidanceUI", "Server data parsing time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - GameDownloadGuidanceUI.5.this.chA) });
                    AppMethodBeat.o(42055);
                    return;
                  }
                  catch (Exception localException)
                  {
                    for (;;)
                    {
                      ad.e("MicroMsg.GameDownloadGuidanceUI", "GameDownloadGuidanceUI crash, %s", new Object[] { localException.getMessage() });
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
    if (!com.tencent.mm.plugin.game.a.a.hYu.a(this, paramInt1, paramInt2, paramString)) {
      Toast.makeText(this, getString(2131759916, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    if (this.oWF != null) {
      this.oWF.cancel();
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