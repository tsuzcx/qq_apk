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
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.e.a.a;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.ab;
import com.tencent.mm.plugin.game.model.ao;
import com.tencent.mm.plugin.game.model.b;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.plugin.game.protobuf.bf;
import com.tencent.mm.plugin.game.protobuf.bs;
import com.tencent.mm.plugin.game.protobuf.v;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public class GameDownloadGuidanceUI
  extends GameCenterBaseUI
  implements i
{
  private Dialog rAV;
  private LinearLayout tmh;
  private bs xHf;
  private TextView xRF;
  private TextView xRG;
  private TextView xRH;
  private boolean xRI;
  private String xRJ = "";
  
  public final void a(ab paramab, int paramInt)
  {
    AppMethodBeat.i(42060);
    if (isFinishing())
    {
      Log.w("MicroMsg.GameDownloadGuidanceUI", "GameDownloadGuidanceUI hasFinished");
      AppMethodBeat.o(42060);
      return;
    }
    if ((paramab == null) || (paramab.dVN() == null))
    {
      Log.e("MicroMsg.GameDownloadGuidanceUI", "Null data");
      AppMethodBeat.o(42060);
      return;
    }
    if ((paramab != null) && (paramab.dVO() != null))
    {
      this.xRJ = paramab.dVO().xIy;
      if (Util.isNullOrNil(this.xRJ)) {
        break label243;
      }
      if (!this.xRI)
      {
        addIconOptionMenu(0, 2131689513, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(42054);
            int i = c.aQ(GameDownloadGuidanceUI.this.getContext(), GameDownloadGuidanceUI.c(GameDownloadGuidanceUI.this));
            com.tencent.mm.game.report.f.a(GameDownloadGuidanceUI.this.getContext(), 10, 1008, 1, i, GameDownloadGuidanceUI.this.xGR, null);
            AppMethodBeat.o(42054);
            return true;
          }
        });
        this.xRI = true;
      }
      label108:
      this.tmh.setVisibility(0);
      paramab = paramab.dVN();
      if (Util.isNullOrNil(paramab.xJI)) {
        break label264;
      }
      this.xRF.setText(paramab.xJI);
      this.xRF.setVisibility(0);
      label150:
      if (Util.isNullOrNil(paramab.xJJ)) {
        break label276;
      }
      this.xRG.setText(paramab.xJJ);
      this.xRG.setVisibility(0);
      label179:
      if (Util.isNullOrNil(paramab.xJK)) {
        break label288;
      }
      this.xRH.setText(paramab.xJK);
      this.xRH.setVisibility(0);
    }
    for (;;)
    {
      if (paramInt == 2) {
        c.cyh().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(42053);
            ((com.tencent.mm.plugin.game.api.f)g.af(com.tencent.mm.plugin.game.api.f.class)).dSL().b("pb_over_sea", GameDownloadGuidanceUI.b(GameDownloadGuidanceUI.this));
            AppMethodBeat.o(42053);
          }
        });
      }
      AppMethodBeat.o(42060);
      return;
      this.xRJ = "";
      break;
      label243:
      if (!this.xRI) {
        break label108;
      }
      removeOptionMenu(0);
      this.xRI = false;
      break label108;
      label264:
      this.xRF.setVisibility(8);
      break label150;
      label276:
      this.xRG.setVisibility(8);
      break label179;
      label288:
      this.xRH.setVisibility(8);
    }
  }
  
  public int getLayoutId()
  {
    return 2131494879;
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
    setMMTitle(2131761376);
    this.tmh = ((LinearLayout)findViewById(2131299174));
    this.xRF = ((TextView)findViewById(2131304321));
    this.xRG = ((TextView)findViewById(2131307447));
    this.xRH = ((TextView)findViewById(2131307438));
    AppMethodBeat.o(42059);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42057);
    super.onCreate(paramBundle);
    g.azz().a(2586, this);
    initView();
    c.cyh().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(42052);
        Object localObject = ((com.tencent.mm.plugin.game.api.f)g.af(com.tencent.mm.plugin.game.api.f.class)).dSL().azn("pb_download_guidance");
        if (localObject == null) {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42050);
              if (GameDownloadGuidanceUI.this.isFinishing())
              {
                AppMethodBeat.o(42050);
                return;
              }
              GameDownloadGuidanceUI.a(GameDownloadGuidanceUI.this, c.gl(GameDownloadGuidanceUI.this));
              GameDownloadGuidanceUI.a(GameDownloadGuidanceUI.this).show();
              AppMethodBeat.o(42050);
            }
          });
        }
        for (;;)
        {
          localObject = new ao(LocaleUtil.getApplicationLanguage(), com.tencent.mm.plugin.game.model.e.dUR(), GameDownloadGuidanceUI.this.xPs, GameDownloadGuidanceUI.this.xPt, GameDownloadGuidanceUI.this.xPu, GameDownloadGuidanceUI.this.xPr);
          g.azz().a((q)localObject, 0);
          com.tencent.mm.plugin.game.model.e.dUW();
          a.a.dWO().dWM();
          AppMethodBeat.o(42052);
          return;
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42051);
              try
              {
                GameDownloadGuidanceUI.this.a(this.xRM, 1);
                AppMethodBeat.o(42051);
                return;
              }
              catch (Exception localException)
              {
                Log.e("MicroMsg.GameDownloadGuidanceUI", "GameDownloadGuidanceUI crash, %s", new Object[] { localException.getMessage() });
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
    Log.i("MicroMsg.GameDownloadGuidanceUI", "onDestroy");
    super.onDestroy();
    a.a.dWO().clearCache();
    g.azz().b(2586, this);
    ((com.tencent.mm.plugin.game.api.e)g.af(com.tencent.mm.plugin.game.api.e.class)).dSI().clearCache();
    AppMethodBeat.o(42058);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(42061);
    Log.i("MicroMsg.GameDownloadGuidanceUI", "errType: %d errCode: %d, scene: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramq.hashCode()) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      switch (paramq.getType())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(42061);
        return;
        final long l = System.currentTimeMillis();
        paramString = ((ao)paramq).hhm.iLL.iLR;
        c.cyh().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(42056);
            if (paramString == null) {
              GameDownloadGuidanceUI.a(GameDownloadGuidanceUI.this, new bs());
            }
            for (;;)
            {
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(42055);
                  try
                  {
                    GameDownloadGuidanceUI.this.a(this.xRM, 2);
                    if (GameDownloadGuidanceUI.a(GameDownloadGuidanceUI.this) != null) {
                      GameDownloadGuidanceUI.a(GameDownloadGuidanceUI.this).dismiss();
                    }
                    Log.i("MicroMsg.GameDownloadGuidanceUI", "Server data parsing time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - GameDownloadGuidanceUI.5.this.cBb) });
                    AppMethodBeat.o(42055);
                    return;
                  }
                  catch (Exception localException)
                  {
                    for (;;)
                    {
                      Log.e("MicroMsg.GameDownloadGuidanceUI", "GameDownloadGuidanceUI crash, %s", new Object[] { localException.getMessage() });
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
    if (!com.tencent.mm.plugin.game.a.a.jRu.a(this, paramInt1, paramInt2, paramString)) {
      Toast.makeText(this, getString(2131761264, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    if (this.rAV != null) {
      this.rAV.cancel();
    }
    AppMethodBeat.o(42061);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDownloadGuidanceUI
 * JD-Core Version:    0.7.0.1
 */