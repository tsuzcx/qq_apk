package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.game.report.g;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.d.a.a;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.plugin.game.h.h;
import com.tencent.mm.plugin.game.h.i;
import com.tencent.mm.plugin.game.model.ab;
import com.tencent.mm.plugin.game.model.ao;
import com.tencent.mm.plugin.game.model.b;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.plugin.game.protobuf.bh;
import com.tencent.mm.plugin.game.protobuf.bu;
import com.tencent.mm.plugin.game.protobuf.x;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public class GameDownloadGuidanceUI
  extends GameCenterBaseUI
  implements com.tencent.mm.am.h
{
  private LinearLayout Api;
  private bu IFp;
  private TextView IQh;
  private TextView IQi;
  private TextView IQj;
  private boolean IQk;
  private String IQl = "";
  private Dialog ysC;
  
  public final void a(ab paramab, int paramInt)
  {
    AppMethodBeat.i(42060);
    if (isFinishing())
    {
      Log.w("MicroMsg.GameDownloadGuidanceUI", "GameDownloadGuidanceUI hasFinished");
      AppMethodBeat.o(42060);
      return;
    }
    if ((paramab == null) || (paramab.fGR() == null))
    {
      Log.e("MicroMsg.GameDownloadGuidanceUI", "Null data");
      AppMethodBeat.o(42060);
      return;
    }
    if ((paramab != null) && (paramab.fGS() != null))
    {
      this.IQl = paramab.fGS().IGI;
      if (Util.isNullOrNil(this.IQl)) {
        break label244;
      }
      if (!this.IQk)
      {
        addIconOptionMenu(0, h.h.actionbar_setting_icon, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(42054);
            int i = com.tencent.mm.plugin.game.d.c.ba(GameDownloadGuidanceUI.this.getContext(), GameDownloadGuidanceUI.c(GameDownloadGuidanceUI.this));
            g.a(GameDownloadGuidanceUI.this.getContext(), 10, 1008, 1, i, GameDownloadGuidanceUI.this.IFc, null);
            AppMethodBeat.o(42054);
            return true;
          }
        });
        this.IQk = true;
      }
      label109:
      this.Api.setVisibility(0);
      paramab = paramab.fGR();
      if (Util.isNullOrNil(paramab.IIa)) {
        break label265;
      }
      this.IQh.setText(paramab.IIa);
      this.IQh.setVisibility(0);
      label151:
      if (Util.isNullOrNil(paramab.IIb)) {
        break label277;
      }
      this.IQi.setText(paramab.IIb);
      this.IQi.setVisibility(0);
      label180:
      if (Util.isNullOrNil(paramab.IIc)) {
        break label289;
      }
      this.IQj.setText(paramab.IIc);
      this.IQj.setVisibility(0);
    }
    for (;;)
    {
      if (paramInt == 2) {
        com.tencent.mm.plugin.game.d.c.dqg().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(42053);
            ((f)com.tencent.mm.kernel.h.ax(f.class)).fCi().b("pb_over_sea", GameDownloadGuidanceUI.b(GameDownloadGuidanceUI.this));
            AppMethodBeat.o(42053);
          }
        });
      }
      AppMethodBeat.o(42060);
      return;
      this.IQl = "";
      break;
      label244:
      if (!this.IQk) {
        break label109;
      }
      removeOptionMenu(0);
      this.IQk = false;
      break label109;
      label265:
      this.IQh.setVisibility(8);
      break label151;
      label277:
      this.IQi.setVisibility(8);
      break label180;
      label289:
      this.IQj.setVisibility(8);
    }
  }
  
  public int getLayoutId()
  {
    return h.f.HZA;
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
    setMMTitle(h.i.Icp);
    this.Api = ((LinearLayout)findViewById(h.e.container));
    this.IQh = ((TextView)findViewById(h.e.main_content));
    this.IQi = ((TextView)findViewById(h.e.HXI));
    this.IQj = ((TextView)findViewById(h.e.HXH));
    AppMethodBeat.o(42059);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42057);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aZW().a(2586, this);
    initView();
    com.tencent.mm.plugin.game.d.c.dqg().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(42052);
        Object localObject = ((f)com.tencent.mm.kernel.h.ax(f.class)).fCi().aFI("pb_download_guidance");
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
              GameDownloadGuidanceUI.a(GameDownloadGuidanceUI.this, com.tencent.mm.plugin.game.d.c.hY(GameDownloadGuidanceUI.this));
              GameDownloadGuidanceUI.a(GameDownloadGuidanceUI.this).show();
              AppMethodBeat.o(42050);
            }
          });
        }
        for (;;)
        {
          localObject = new ao(LocaleUtil.getApplicationLanguage(), com.tencent.mm.plugin.game.model.e.fFU(), GameDownloadGuidanceUI.this.INR, GameDownloadGuidanceUI.this.INS, GameDownloadGuidanceUI.this.INU, GameDownloadGuidanceUI.this.INQ);
          com.tencent.mm.kernel.h.aZW().a((p)localObject, 0);
          com.tencent.mm.plugin.game.model.e.fFZ();
          a.a.fHX().fHV();
          AppMethodBeat.o(42052);
          return;
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42051);
              try
              {
                GameDownloadGuidanceUI.this.a(this.IQo, 1);
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
    a.a.fHX().clearCache();
    com.tencent.mm.kernel.h.aZW().b(2586, this);
    ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.e.class)).fCf().clearCache();
    AppMethodBeat.o(42058);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, p paramp)
  {
    AppMethodBeat.i(42061);
    Log.i("MicroMsg.GameDownloadGuidanceUI", "errType: %d errCode: %d, scene: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramp.hashCode()) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      switch (paramp.getType())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(42061);
        return;
        final long l = System.currentTimeMillis();
        paramString = c.c.b(((ao)paramp).mtC.otC);
        com.tencent.mm.plugin.game.d.c.dqg().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(42056);
            if (paramString == null) {
              GameDownloadGuidanceUI.a(GameDownloadGuidanceUI.this, new bu());
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
                    GameDownloadGuidanceUI.this.a(this.IQo, 2);
                    if (GameDownloadGuidanceUI.a(GameDownloadGuidanceUI.this) != null) {
                      GameDownloadGuidanceUI.a(GameDownloadGuidanceUI.this).dismiss();
                    }
                    Log.i("MicroMsg.GameDownloadGuidanceUI", "Server data parsing time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - GameDownloadGuidanceUI.5.this.esF) });
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
              GameDownloadGuidanceUI.a(GameDownloadGuidanceUI.this, (bu)paramString);
            }
          }
        });
      }
    }
    if (!com.tencent.mm.plugin.game.a.a.pFo.a(this, paramInt1, paramInt2, paramString)) {
      Toast.makeText(this, getString(h.i.Ibn, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    if (this.ysC != null) {
      this.ysC.cancel();
    }
    AppMethodBeat.o(42061);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDownloadGuidanceUI
 * JD-Core Version:    0.7.0.1
 */