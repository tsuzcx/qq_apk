package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.s;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader_app.a.g;
import com.tencent.mm.plugin.downloader_app.a.h.a;
import com.tencent.mm.plugin.downloader_app.a.j;
import com.tencent.mm.plugin.downloader_app.e.a;
import com.tencent.mm.plugin.downloader_app.e.b;
import com.tencent.mm.plugin.downloader_app.e.e;
import com.tencent.mm.plugin.downloader_app.e.f;
import com.tencent.mm.plugin.downloader_app.e.g;
import com.tencent.mm.plugin.downloader_app.e.h;
import com.tencent.mm.plugin.downloader_app.search.DownloadSearchUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public class DownloadMainUI
  extends MMActivity
{
  private int lCR;
  private View lNf;
  private String mAppId;
  private com.tencent.mm.plugin.downloader.b.a.a.f xsz;
  TaskListView xtO;
  private DeleteTaskFooterView xtP;
  private TaskManagerHeaderView xtQ;
  private View xtR;
  private boolean xtS;
  private boolean xtT;
  private g xtU;
  private boolean xtV = false;
  private com.tencent.mm.plugin.downloader_app.a.f xtW;
  
  private void a(g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(9010);
    if (paramg != null) {}
    for (com.tencent.mm.plugin.downloader.b.a.a.f localf = paramg.xsz;; localf = null)
    {
      this.xsz = localf;
      if ((paramg != null) && (!paramg.duY())) {
        break;
      }
      if (paramBoolean) {
        nM(true);
      }
      AppMethodBeat.o(9010);
      return;
    }
    paramg = paramg.X(j.dvd());
    if (Util.isNullOrNil(paramg))
    {
      nM(true);
      AppMethodBeat.o(9010);
      return;
    }
    nM(false);
    this.xtO.setData(paramg);
    AppMethodBeat.o(9010);
  }
  
  private void aNi()
  {
    AppMethodBeat.i(9007);
    this.mAppId = getIntent().getStringExtra("appId");
    this.xtV = getIntent().getBooleanExtra("view_task", false);
    Log.i("MicroMsg.DownloadMainUI", "initData, appId : %s, viewTask : %b", new Object[] { this.mAppId, Boolean.valueOf(this.xtV) });
    com.tencent.mm.pluginsdk.model.app.h.s(this.mAppId, true, false);
    dvh();
    com.tencent.threadpool.h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(8994);
        DownloadMainUI.a(DownloadMainUI.this, com.tencent.mm.plugin.downloader_app.a.h.duZ());
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(269717);
            DownloadMainUI.a(DownloadMainUI.this, DownloadMainUI.e(DownloadMainUI.this), false);
            AppMethodBeat.o(269717);
          }
        });
        if (DownloadMainUI.a(DownloadMainUI.this, DownloadMainUI.f(DownloadMainUI.this)))
        {
          DownloadMainUI.this.e(j.dvd(), null);
          AppMethodBeat.o(8994);
          return;
        }
        LinkedList localLinkedList = j.dvd();
        if (!localLinkedList.contains(DownloadMainUI.f(DownloadMainUI.this))) {
          localLinkedList.add(DownloadMainUI.f(DownloadMainUI.this));
        }
        DownloadMainUI.this.e(localLinkedList, DownloadMainUI.f(DownloadMainUI.this));
        s.D(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(269718);
            DownloadMainUI.g(DownloadMainUI.this);
            AppMethodBeat.o(269718);
          }
        });
        AppMethodBeat.o(8994);
      }
    });
    AppMethodBeat.o(9007);
  }
  
  private void dvh()
  {
    AppMethodBeat.i(9008);
    if (this.lCR == 1)
    {
      com.tencent.mm.plugin.downloader.f.a locala = d.amJ(this.mAppId);
      if (locala != null)
      {
        com.tencent.mm.plugin.downloader.e.b localb = new com.tencent.mm.plugin.downloader.e.b();
        localb.k(locala);
        localb.costTime = 0L;
        com.tencent.mm.plugin.downloader.e.a.a(19, localb);
      }
    }
    AppMethodBeat.o(9008);
  }
  
  private String dvi()
  {
    AppMethodBeat.i(175277);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("source", this.lCR);
      try
      {
        label26:
        localObject = URLEncoder.encode(((JSONObject)localObject).toString(), "UTF-8");
        AppMethodBeat.o(175277);
        return localObject;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        AppMethodBeat.o(175277);
        return "";
      }
    }
    catch (JSONException localJSONException)
    {
      break label26;
    }
  }
  
  private boolean dvj()
  {
    return this.lCR == 2;
  }
  
  public final void e(LinkedList<String> paramLinkedList, final String paramString)
  {
    AppMethodBeat.i(9009);
    com.tencent.mm.plugin.downloader_app.a.h.a(paramLinkedList, new h.a()
    {
      public final void nE(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(269721);
        s.D(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(269728);
            DownloadMainUI.j(DownloadMainUI.this);
            AppMethodBeat.o(269728);
          }
        });
        if (paramAnonymousBoolean)
        {
          DownloadMainUI.a(DownloadMainUI.this, com.tencent.mm.plugin.downloader_app.a.h.duZ());
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(269727);
              if (!Util.isNullOrNil(DownloadMainUI.9.this.xtZ))
              {
                final com.tencent.mm.plugin.downloader_app.a.i locali = DownloadMainUI.e(DownloadMainUI.this).anh(DownloadMainUI.9.this.xtZ);
                if (locali == null) {
                  break label96;
                }
                j.anj(DownloadMainUI.9.this.xtZ);
                s.postDelayed(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(269729);
                    com.tencent.mm.plugin.downloader_app.a.c.a(DownloadMainUI.this, locali, true);
                    AppMethodBeat.o(269729);
                  }
                }, 200L);
              }
              for (;;)
              {
                DownloadMainUI.a(DownloadMainUI.this, DownloadMainUI.e(DownloadMainUI.this), true);
                AppMethodBeat.o(269727);
                return;
                label96:
                k.c(DownloadMainUI.this, "", DownloadMainUI.this.getResources().getString(e.h.xrv), true);
              }
            }
          });
          AppMethodBeat.o(269721);
          return;
        }
        if (!Util.isNullOrNil(paramString)) {
          k.c(DownloadMainUI.this, "", DownloadMainUI.this.getResources().getString(e.h.xqX), true);
        }
        AppMethodBeat.o(269721);
      }
    });
    AppMethodBeat.o(9009);
  }
  
  public void finish()
  {
    AppMethodBeat.i(175276);
    super.finish();
    if (this.lCR == 3) {
      overridePendingTransition(e.a.appbrand_ui_push_close_enter, e.a.xpy);
    }
    AppMethodBeat.o(175276);
  }
  
  public int getLayoutId()
  {
    return e.f.xqM;
  }
  
  public final void nL(boolean paramBoolean)
  {
    AppMethodBeat.i(9011);
    DeleteTaskFooterView localDeleteTaskFooterView = this.xtP;
    localDeleteTaskFooterView.xtL = paramBoolean;
    if (localDeleteTaskFooterView.xtL)
    {
      com.tencent.mm.plugin.downloader_app.b.i(localDeleteTaskFooterView.xtH, "checkbox_cell_on");
      AppMethodBeat.o(9011);
      return;
    }
    com.tencent.mm.plugin.downloader_app.b.i(localDeleteTaskFooterView.xtH, "checkbox_cell_off");
    AppMethodBeat.o(9011);
  }
  
  final void nM(boolean paramBoolean)
  {
    AppMethodBeat.i(9012);
    if (paramBoolean) {
      if ((this.xtR instanceof ViewStub))
      {
        this.xtR = ((ViewStub)this.xtR).inflate();
        this.xtR.setVisibility(0);
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        this.xtR.setVisibility(0);
        ((NoTaskLayout)this.xtR).setData(this.xsz);
      }
      AppMethodBeat.o(9012);
      return;
      if (!(this.xtR instanceof ViewStub)) {
        this.xtR.setVisibility(8);
      }
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(9006);
    if (this.xtO != null)
    {
      TaskListView localTaskListView = this.xtO;
      if (localTaskListView.xuR) {
        localTaskListView.dvp();
      }
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(9006);
        return;
      }
    }
    if ((dvj()) && (this.xtW != null) && (this.xtW.zX(2)))
    {
      AppMethodBeat.o(9006);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(9006);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(9001);
    super.onCreate(paramBundle);
    this.lCR = getIntent().getIntExtra("from_scene", 0);
    if (this.lCR == 3) {
      overridePendingTransition(e.a.xpA, e.a.appbrand_ui_push_open_exit);
    }
    Log.i("MicroMsg.DownloadMainUI", "onCreate: " + System.currentTimeMillis());
    this.xtT = true;
    setActionbarColor(getResources().getColor(e.b.xpH));
    showActionbarLine();
    setMMTitle(e.h.xrK);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(8988);
        if ((DownloadMainUI.a(DownloadMainUI.this)) && (DownloadMainUI.b(DownloadMainUI.this) != null) && (DownloadMainUI.b(DownloadMainUI.this).zX(1)))
        {
          AppMethodBeat.o(8988);
          return true;
        }
        DownloadMainUI.this.finish();
        AppMethodBeat.o(8988);
        return true;
      }
    });
    addIconOptionMenu(0, e.h.app_search, e.g.actionbar_icon_dark_search, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(8989);
        paramAnonymousMenuItem = DownloadMainUI.this;
        Object localObject = new Intent(DownloadMainUI.this, DownloadSearchUI.class);
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/downloader_app/ui/DownloadMainUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousMenuItem, "com/tencent/mm/plugin/downloader_app/ui/DownloadMainUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.downloader_app.b.a.a(10, 1001, 1, 2, "", "", "");
        AppMethodBeat.o(8989);
        return true;
      }
    });
    this.xtO = ((TaskListView)findViewById(e.e.list));
    this.xtP = ((DeleteTaskFooterView)findViewById(e.e.xqb));
    this.xtO.xuQ = new a()
    {
      public final void nN(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(8990);
        if (paramAnonymousBoolean)
        {
          DownloadMainUI.c(DownloadMainUI.this).setVisibility(0);
          DownloadMainUI.c(DownloadMainUI.this).startAnimation(AnimationUtils.loadAnimation(DownloadMainUI.this, e.a.xpw));
          DownloadMainUI.d(DownloadMainUI.this).setVisibility(0);
          DownloadMainUI.d(DownloadMainUI.this).startAnimation(AnimationUtils.loadAnimation(DownloadMainUI.this, e.a.xpB));
          AppMethodBeat.o(8990);
          return;
        }
        DownloadMainUI.c(DownloadMainUI.this).setVisibility(8);
        DownloadMainUI.c(DownloadMainUI.this).startAnimation(AnimationUtils.loadAnimation(DownloadMainUI.this, e.a.xpx));
        DownloadMainUI.d(DownloadMainUI.this).setVisibility(8);
        DownloadMainUI.d(DownloadMainUI.this).startAnimation(AnimationUtils.loadAnimation(DownloadMainUI.this, e.a.xpC));
        AppMethodBeat.o(8990);
      }
    };
    this.xtO.setOnItemButtonClickListener(new TaskItemView.a()
    {
      public final boolean dvk()
      {
        AppMethodBeat.i(269724);
        boolean bool = com.tencent.mm.plugin.webview.luggage.c.a.iuX();
        Log.i("MicroMsg.DownloadMainUI", "onOnItemButtonClick isTeenMode: %s", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          com.tencent.mm.plugin.webview.luggage.c.a.kQ(DownloadMainUI.this);
          AppMethodBeat.o(269724);
          return true;
        }
        AppMethodBeat.o(269724);
        return false;
      }
    });
    this.xtQ = ((TaskManagerHeaderView)findViewById(e.e.header_view));
    this.xtR = findViewById(e.e.xqt);
    aNi();
    com.tencent.mm.plugin.downloader_app.b.a.a(10, 0, 0, 1, "", "", dvi());
    this.xtW = new com.tencent.mm.plugin.downloader_app.a.f(new com.tencent.mm.plugin.ball.a.e(this));
    this.xtW.J(16, "GameDownloadFloatBall");
    com.tencent.mm.plugin.downloader_app.a.e.duU();
    com.tencent.mm.plugin.downloader_app.a.e.nJ(false);
    AppMethodBeat.o(9001);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(9005);
    super.onDestroy();
    com.tencent.mm.plugin.downloader_app.a.h.xsB = null;
    if (this.xtW != null) {
      this.xtW.onDestroy();
    }
    AppMethodBeat.o(9005);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(9004);
    setIntent(paramIntent);
    this.xtO.dvp();
    aNi();
    AppMethodBeat.o(9004);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(9003);
    super.onPause();
    if (this.xtU != null)
    {
      g localg = this.xtU;
      ((com.tencent.mm.plugin.game.commlib.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.commlib.a.a.class)).a("pb_appinfo", localg.xsw);
    }
    this.xtS = false;
    if (this.xtW != null) {
      this.xtW.bhW();
    }
    AppMethodBeat.o(9003);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(9002);
    super.onResume();
    this.xtS = true;
    if (!this.xtT)
    {
      this.xtU = com.tencent.mm.plugin.downloader_app.a.h.duZ();
      a(this.xtU, true);
    }
    this.xtT = false;
    if (this.xtW != null) {
      this.xtW.coi();
    }
    AppMethodBeat.o(9002);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static abstract interface a
  {
    public abstract void nN(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI
 * JD-Core Version:    0.7.0.1
 */