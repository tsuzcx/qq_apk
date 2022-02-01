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
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.game.report.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.d.a.a;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.g.h;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.plugin.game.model.ab;
import com.tencent.mm.plugin.game.model.ao;
import com.tencent.mm.plugin.game.model.b;
import com.tencent.mm.plugin.game.protobuf.bg;
import com.tencent.mm.plugin.game.protobuf.bt;
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
  private bt CLi;
  private TextView CVP;
  private TextView CVQ;
  private TextView CVR;
  private boolean CVS;
  private String CVT = "";
  private Dialog vgC;
  private LinearLayout wSF;
  
  public final void a(ab paramab, int paramInt)
  {
    AppMethodBeat.i(42060);
    if (isFinishing())
    {
      Log.w("MicroMsg.GameDownloadGuidanceUI", "GameDownloadGuidanceUI hasFinished");
      AppMethodBeat.o(42060);
      return;
    }
    if ((paramab == null) || (paramab.eyV() == null))
    {
      Log.e("MicroMsg.GameDownloadGuidanceUI", "Null data");
      AppMethodBeat.o(42060);
      return;
    }
    if ((paramab != null) && (paramab.eyW() != null))
    {
      this.CVT = paramab.eyW().CMD;
      if (Util.isNullOrNil(this.CVT)) {
        break label244;
      }
      if (!this.CVS)
      {
        addIconOptionMenu(0, g.h.actionbar_setting_icon, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(42054);
            int i = c.aY(GameDownloadGuidanceUI.this.getContext(), GameDownloadGuidanceUI.c(GameDownloadGuidanceUI.this));
            g.a(GameDownloadGuidanceUI.this.getContext(), 10, 1008, 1, i, GameDownloadGuidanceUI.this.CKU, null);
            AppMethodBeat.o(42054);
            return true;
          }
        });
        this.CVS = true;
      }
      label109:
      this.wSF.setVisibility(0);
      paramab = paramab.eyV();
      if (Util.isNullOrNil(paramab.CNQ)) {
        break label265;
      }
      this.CVP.setText(paramab.CNQ);
      this.CVP.setVisibility(0);
      label151:
      if (Util.isNullOrNil(paramab.CNR)) {
        break label277;
      }
      this.CVQ.setText(paramab.CNR);
      this.CVQ.setVisibility(0);
      label180:
      if (Util.isNullOrNil(paramab.CNS)) {
        break label289;
      }
      this.CVR.setText(paramab.CNS);
      this.CVR.setVisibility(0);
    }
    for (;;)
    {
      if (paramInt == 2) {
        c.cMC().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(42053);
            ((f)h.ae(f.class)).evp().b("pb_over_sea", GameDownloadGuidanceUI.b(GameDownloadGuidanceUI.this));
            AppMethodBeat.o(42053);
          }
        });
      }
      AppMethodBeat.o(42060);
      return;
      this.CVT = "";
      break;
      label244:
      if (!this.CVS) {
        break label109;
      }
      removeOptionMenu(0);
      this.CVS = false;
      break label109;
      label265:
      this.CVP.setVisibility(8);
      break label151;
      label277:
      this.CVQ.setVisibility(8);
      break label180;
      label289:
      this.CVR.setVisibility(8);
    }
  }
  
  public int getLayoutId()
  {
    return g.f.Cns;
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
    setMMTitle(g.i.Cqg);
    this.wSF = ((LinearLayout)findViewById(g.e.container));
    this.CVP = ((TextView)findViewById(g.e.main_content));
    this.CVQ = ((TextView)findViewById(g.e.ClA));
    this.CVR = ((TextView)findViewById(g.e.Clz));
    AppMethodBeat.o(42059);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42057);
    super.onCreate(paramBundle);
    h.aGY().a(2586, this);
    initView();
    c.cMC().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(42052);
        Object localObject = ((f)h.ae(f.class)).evp().aIX("pb_download_guidance");
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
              GameDownloadGuidanceUI.a(GameDownloadGuidanceUI.this, c.gF(GameDownloadGuidanceUI.this));
              GameDownloadGuidanceUI.a(GameDownloadGuidanceUI.this).show();
              AppMethodBeat.o(42050);
            }
          });
        }
        for (;;)
        {
          localObject = new ao(LocaleUtil.getApplicationLanguage(), com.tencent.mm.plugin.game.model.e.exY(), GameDownloadGuidanceUI.this.CTB, GameDownloadGuidanceUI.this.CTC, GameDownloadGuidanceUI.this.CTD, GameDownloadGuidanceUI.this.CTA);
          h.aGY().a((q)localObject, 0);
          com.tencent.mm.plugin.game.model.e.eyd();
          a.a.ezW().ezU();
          AppMethodBeat.o(42052);
          return;
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42051);
              try
              {
                GameDownloadGuidanceUI.this.a(this.CVX, 1);
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
    a.a.ezW().clearCache();
    h.aGY().b(2586, this);
    ((com.tencent.mm.plugin.game.api.e)h.ae(com.tencent.mm.plugin.game.api.e.class)).evm().clearCache();
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
        paramString = d.c.b(((ao)paramq).jTk.lBS);
        c.cMC().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(42056);
            if (paramString == null) {
              GameDownloadGuidanceUI.a(GameDownloadGuidanceUI.this, new bt());
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
                    GameDownloadGuidanceUI.this.a(this.CVX, 2);
                    if (GameDownloadGuidanceUI.a(GameDownloadGuidanceUI.this) != null) {
                      GameDownloadGuidanceUI.a(GameDownloadGuidanceUI.this).dismiss();
                    }
                    Log.i("MicroMsg.GameDownloadGuidanceUI", "Server data parsing time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - GameDownloadGuidanceUI.5.this.cAj) });
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
              GameDownloadGuidanceUI.a(GameDownloadGuidanceUI.this, (bt)paramString);
            }
          }
        });
      }
    }
    if (!com.tencent.mm.plugin.game.a.a.mIH.a(this, paramInt1, paramInt2, paramString)) {
      Toast.makeText(this, getString(g.i.Cpf, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    if (this.vgC != null) {
      this.vgC.cancel();
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