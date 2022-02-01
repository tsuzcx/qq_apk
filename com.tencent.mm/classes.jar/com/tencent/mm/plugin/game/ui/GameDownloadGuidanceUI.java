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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.d.be;
import com.tencent.mm.plugin.game.d.bs;
import com.tencent.mm.plugin.game.d.v;
import com.tencent.mm.plugin.game.f.a.a;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.ab;
import com.tencent.mm.plugin.game.model.ao;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;

public class GameDownloadGuidanceUI
  extends GameCenterBaseUI
  implements com.tencent.mm.ak.f
{
  private Dialog qka;
  private LinearLayout rMv;
  private bs uoM;
  private TextView uzG;
  private TextView uzH;
  private TextView uzI;
  private boolean uzJ;
  private String uzK = "";
  
  public final void a(ab paramab, int paramInt)
  {
    AppMethodBeat.i(42060);
    if (isFinishing())
    {
      ae.w("MicroMsg.GameDownloadGuidanceUI", "GameDownloadGuidanceUI hasFinished");
      AppMethodBeat.o(42060);
      return;
    }
    if ((paramab == null) || (paramab.dcg() == null))
    {
      ae.e("MicroMsg.GameDownloadGuidanceUI", "Null data");
      AppMethodBeat.o(42060);
      return;
    }
    if ((paramab != null) && (paramab.dch() != null))
    {
      this.uzK = paramab.dch().uqf;
      if (bu.isNullOrNil(this.uzK)) {
        break label243;
      }
      if (!this.uzJ)
      {
        addIconOptionMenu(0, 2131689511, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(42054);
            int i = c.aD(GameDownloadGuidanceUI.this.getContext(), GameDownloadGuidanceUI.c(GameDownloadGuidanceUI.this));
            com.tencent.mm.game.report.f.a(GameDownloadGuidanceUI.this.getContext(), 10, 1008, 1, i, GameDownloadGuidanceUI.this.uoy, null);
            AppMethodBeat.o(42054);
            return true;
          }
        });
        this.uzJ = true;
      }
      label108:
      this.rMv.setVisibility(0);
      paramab = paramab.dcg();
      if (bu.isNullOrNil(paramab.urr)) {
        break label264;
      }
      this.uzG.setText(paramab.urr);
      this.uzG.setVisibility(0);
      label150:
      if (bu.isNullOrNil(paramab.urs)) {
        break label276;
      }
      this.uzH.setText(paramab.urs);
      this.uzH.setVisibility(0);
      label179:
      if (bu.isNullOrNil(paramab.urt)) {
        break label288;
      }
      this.uzI.setText(paramab.urt);
      this.uzI.setVisibility(0);
    }
    for (;;)
    {
      if (paramInt == 2) {
        c.caq().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(42053);
            ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cZm().b("pb_over_sea", GameDownloadGuidanceUI.b(GameDownloadGuidanceUI.this));
            AppMethodBeat.o(42053);
          }
        });
      }
      AppMethodBeat.o(42060);
      return;
      this.uzK = "";
      break;
      label243:
      if (!this.uzJ) {
        break label108;
      }
      removeOptionMenu(0);
      this.uzJ = false;
      break label108;
      label264:
      this.uzG.setVisibility(8);
      break label150;
      label276:
      this.uzH.setVisibility(8);
      break label179;
      label288:
      this.uzI.setVisibility(8);
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
    this.rMv = ((LinearLayout)findViewById(2131298736));
    this.uzG = ((TextView)findViewById(2131301985));
    this.uzH = ((TextView)findViewById(2131304469));
    this.uzI = ((TextView)findViewById(2131304461));
    AppMethodBeat.o(42059);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42057);
    super.onCreate(paramBundle);
    g.ajj().a(2586, this);
    initView();
    c.caq().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(42052);
        Object localObject = ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cZm().amj("pb_download_guidance");
        if (localObject == null) {
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42050);
              if (GameDownloadGuidanceUI.this.isFinishing())
              {
                AppMethodBeat.o(42050);
                return;
              }
              GameDownloadGuidanceUI.a(GameDownloadGuidanceUI.this, c.fF(GameDownloadGuidanceUI.this));
              GameDownloadGuidanceUI.a(GameDownloadGuidanceUI.this).show();
              AppMethodBeat.o(42050);
            }
          });
        }
        for (;;)
        {
          localObject = new ao(ad.fom(), com.tencent.mm.plugin.game.model.e.dbk(), GameDownloadGuidanceUI.this.uxs, GameDownloadGuidanceUI.this.uxt, GameDownloadGuidanceUI.this.uxu, GameDownloadGuidanceUI.this.uxr);
          g.ajj().a((n)localObject, 0);
          com.tencent.mm.plugin.game.model.e.dbp();
          a.a.dde().ddc();
          AppMethodBeat.o(42052);
          return;
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42051);
              try
              {
                GameDownloadGuidanceUI.this.a(this.uzN, 1);
                AppMethodBeat.o(42051);
                return;
              }
              catch (Exception localException)
              {
                ae.e("MicroMsg.GameDownloadGuidanceUI", "GameDownloadGuidanceUI crash, %s", new Object[] { localException.getMessage() });
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
    ae.i("MicroMsg.GameDownloadGuidanceUI", "onDestroy");
    super.onDestroy();
    a.a.dde().clearCache();
    g.ajj().b(2586, this);
    ((com.tencent.mm.plugin.game.api.e)g.ab(com.tencent.mm.plugin.game.api.e.class)).cZj().clearCache();
    AppMethodBeat.o(42058);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(42061);
    ae.i("MicroMsg.GameDownloadGuidanceUI", "errType: %d errCode: %d, scene: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramn.hashCode()) });
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
        paramString = ((ao)paramn).gux.hQE.hQJ;
        c.caq().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(42056);
            if (paramString == null) {
              GameDownloadGuidanceUI.a(GameDownloadGuidanceUI.this, new bs());
            }
            for (;;)
            {
              ar.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(42055);
                  try
                  {
                    GameDownloadGuidanceUI.this.a(this.uzN, 2);
                    if (GameDownloadGuidanceUI.a(GameDownloadGuidanceUI.this) != null) {
                      GameDownloadGuidanceUI.a(GameDownloadGuidanceUI.this).dismiss();
                    }
                    ae.i("MicroMsg.GameDownloadGuidanceUI", "Server data parsing time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - GameDownloadGuidanceUI.5.this.coO) });
                    AppMethodBeat.o(42055);
                    return;
                  }
                  catch (Exception localException)
                  {
                    for (;;)
                    {
                      ae.e("MicroMsg.GameDownloadGuidanceUI", "GameDownloadGuidanceUI crash, %s", new Object[] { localException.getMessage() });
                      GameDownloadGuidanceUI.this.finish();
                    }
                  }
                }
              });
              AppMethodBeat.o(42056);
              return;
              GameDownloadGuidanceUI.a(GameDownloadGuidanceUI.this, (bs)paramString);
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
    AppMethodBeat.o(42061);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDownloadGuidanceUI
 * JD-Core Version:    0.7.0.1
 */