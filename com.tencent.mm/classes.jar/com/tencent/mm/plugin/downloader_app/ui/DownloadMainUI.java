package com.tencent.mm.plugin.downloader_app.ui;

import android.app.Activity;
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
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public class DownloadMainUI
  extends MMActivity
{
  private int jaR;
  private View jkB;
  private String mAppId;
  private com.tencent.mm.plugin.downloader.c.a.a.f umn;
  private com.tencent.mm.plugin.downloader_app.a.f unA;
  TaskListView uns;
  private DeleteTaskFooterView unt;
  private TaskManagerHeaderView unu;
  private View unv;
  private boolean unw;
  private boolean unx;
  private g uny;
  private boolean unz = false;
  
  private void a(g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(9010);
    if (paramg != null) {}
    for (com.tencent.mm.plugin.downloader.c.a.a.f localf = paramg.umn;; localf = null)
    {
      this.umn = localf;
      if ((paramg != null) && (!paramg.cQF())) {
        break;
      }
      if (paramBoolean) {
        mq(true);
      }
      AppMethodBeat.o(9010);
      return;
    }
    paramg = paramg.V(j.cQK());
    if (Util.isNullOrNil(paramg))
    {
      mq(true);
      AppMethodBeat.o(9010);
      return;
    }
    mq(false);
    this.uns.setData(paramg);
    AppMethodBeat.o(9010);
  }
  
  private void ata()
  {
    AppMethodBeat.i(9007);
    this.mAppId = getIntent().getStringExtra("appId");
    this.unz = getIntent().getBooleanExtra("view_task", false);
    Log.i("MicroMsg.DownloadMainUI", "initData, appId : %s, viewTask : %b", new Object[] { this.mAppId, Boolean.valueOf(this.unz) });
    com.tencent.mm.pluginsdk.model.app.h.o(this.mAppId, true, false);
    cQO();
    com.tencent.e.h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(8994);
        DownloadMainUI.a(DownloadMainUI.this, com.tencent.mm.plugin.downloader_app.a.h.cQG());
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(243192);
            DownloadMainUI.a(DownloadMainUI.this, DownloadMainUI.e(DownloadMainUI.this), false);
            AppMethodBeat.o(243192);
          }
        });
        if (DownloadMainUI.a(DownloadMainUI.this, DownloadMainUI.f(DownloadMainUI.this)))
        {
          DownloadMainUI.this.e(j.cQK(), null);
          AppMethodBeat.o(8994);
          return;
        }
        LinkedList localLinkedList = j.cQK();
        if (!localLinkedList.contains(DownloadMainUI.f(DownloadMainUI.this))) {
          localLinkedList.add(DownloadMainUI.f(DownloadMainUI.this));
        }
        DownloadMainUI.this.e(localLinkedList, DownloadMainUI.f(DownloadMainUI.this));
        s.y(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(243133);
            DownloadMainUI.g(DownloadMainUI.this);
            AppMethodBeat.o(243133);
          }
        });
        AppMethodBeat.o(8994);
      }
    });
    AppMethodBeat.o(9007);
  }
  
  private void cQO()
  {
    AppMethodBeat.i(9008);
    if (this.jaR == 1)
    {
      com.tencent.mm.plugin.downloader.g.a locala = d.asU(this.mAppId);
      if (locala != null)
      {
        com.tencent.mm.plugin.downloader.f.b localb = new com.tencent.mm.plugin.downloader.f.b();
        localb.k(locala);
        localb.costTime = 0L;
        com.tencent.mm.plugin.downloader.f.a.a(19, localb);
      }
    }
    AppMethodBeat.o(9008);
  }
  
  private String cQP()
  {
    AppMethodBeat.i(175277);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("source", this.jaR);
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
  
  private boolean cQQ()
  {
    return this.jaR == 2;
  }
  
  public final void e(LinkedList<String> paramLinkedList, final String paramString)
  {
    AppMethodBeat.i(9009);
    com.tencent.mm.plugin.downloader_app.a.h.a(paramLinkedList, new h.a()
    {
      public final void mi(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(243121);
        s.y(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(243213);
            DownloadMainUI.j(DownloadMainUI.this);
            AppMethodBeat.o(243213);
          }
        });
        if (paramAnonymousBoolean)
        {
          DownloadMainUI.a(DownloadMainUI.this, com.tencent.mm.plugin.downloader_app.a.h.cQG());
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(243173);
              if (!Util.isNullOrNil(DownloadMainUI.9.this.unD))
              {
                final com.tencent.mm.plugin.downloader_app.a.i locali = DownloadMainUI.e(DownloadMainUI.this).ats(DownloadMainUI.9.this.unD);
                if (locali == null) {
                  break label96;
                }
                j.atu(DownloadMainUI.9.this.unD);
                s.postDelayed(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(243113);
                    com.tencent.mm.plugin.downloader_app.a.c.a(DownloadMainUI.this, locali, true);
                    AppMethodBeat.o(243113);
                  }
                }, 200L);
              }
              for (;;)
              {
                DownloadMainUI.a(DownloadMainUI.this, DownloadMainUI.e(DownloadMainUI.this), true);
                AppMethodBeat.o(243173);
                return;
                label96:
                com.tencent.mm.ui.base.h.c(DownloadMainUI.this, "", DownloadMainUI.this.getResources().getString(e.h.ulj), true);
              }
            }
          });
          AppMethodBeat.o(243121);
          return;
        }
        if (!Util.isNullOrNil(paramString)) {
          com.tencent.mm.ui.base.h.c(DownloadMainUI.this, "", DownloadMainUI.this.getResources().getString(e.h.ukL), true);
        }
        AppMethodBeat.o(243121);
      }
    });
    AppMethodBeat.o(9009);
  }
  
  public void finish()
  {
    AppMethodBeat.i(175276);
    super.finish();
    if (this.jaR == 3) {
      overridePendingTransition(e.a.appbrand_ui_push_close_enter, e.a.ujv);
    }
    AppMethodBeat.o(175276);
  }
  
  public int getLayoutId()
  {
    return e.f.ukA;
  }
  
  public final void mp(boolean paramBoolean)
  {
    AppMethodBeat.i(9011);
    DeleteTaskFooterView localDeleteTaskFooterView = this.unt;
    localDeleteTaskFooterView.unp = paramBoolean;
    if (localDeleteTaskFooterView.unp)
    {
      com.tencent.mm.plugin.downloader_app.b.e(localDeleteTaskFooterView.unl, "checkbox_cell_on");
      AppMethodBeat.o(9011);
      return;
    }
    com.tencent.mm.plugin.downloader_app.b.e(localDeleteTaskFooterView.unl, "checkbox_cell_off");
    AppMethodBeat.o(9011);
  }
  
  final void mq(boolean paramBoolean)
  {
    AppMethodBeat.i(9012);
    if (paramBoolean) {
      if ((this.unv instanceof ViewStub))
      {
        this.unv = ((ViewStub)this.unv).inflate();
        this.unv.setVisibility(0);
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        this.unv.setVisibility(0);
        ((NoTaskLayout)this.unv).setData(this.umn);
      }
      AppMethodBeat.o(9012);
      return;
      if (!(this.unv instanceof ViewStub)) {
        this.unv.setVisibility(8);
      }
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(9006);
    if (this.uns != null)
    {
      TaskListView localTaskListView = this.uns;
      if (localTaskListView.uou) {
        localTaskListView.cQW();
      }
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(9006);
        return;
      }
    }
    if ((cQQ()) && (this.unA != null) && (this.unA.zH(2)))
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
    this.jaR = getIntent().getIntExtra("from_scene", 0);
    if (this.jaR == 3) {
      overridePendingTransition(e.a.ujx, e.a.appbrand_ui_push_enter_exit);
    }
    Log.i("MicroMsg.DownloadMainUI", "onCreate: " + System.currentTimeMillis());
    this.unx = true;
    setActionbarColor(getResources().getColor(e.b.ujE));
    showActionbarLine();
    setMMTitle(e.h.uly);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(8988);
        if ((DownloadMainUI.a(DownloadMainUI.this)) && (DownloadMainUI.b(DownloadMainUI.this) != null) && (DownloadMainUI.b(DownloadMainUI.this).zH(1)))
        {
          AppMethodBeat.o(8988);
          return true;
        }
        DownloadMainUI.this.finish();
        AppMethodBeat.o(8988);
        return true;
      }
    });
    addIconOptionMenu(0, e.g.actionbar_icon_dark_search, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(8989);
        paramAnonymousMenuItem = DownloadMainUI.this;
        Object localObject = new Intent(DownloadMainUI.this, DownloadSearchUI.class);
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/downloader_app/ui/DownloadMainUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousMenuItem, "com/tencent/mm/plugin/downloader_app/ui/DownloadMainUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.downloader_app.b.a.a(10, 1001, 1, 2, "", "", "");
        AppMethodBeat.o(8989);
        return true;
      }
    });
    this.uns = ((TaskListView)findViewById(e.e.list));
    this.unt = ((DeleteTaskFooterView)findViewById(e.e.ujV));
    this.uns.uot = new a()
    {
      public final void mr(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(8990);
        if (paramAnonymousBoolean)
        {
          DownloadMainUI.c(DownloadMainUI.this).setVisibility(0);
          DownloadMainUI.c(DownloadMainUI.this).startAnimation(AnimationUtils.loadAnimation(DownloadMainUI.this, e.a.ujt));
          DownloadMainUI.d(DownloadMainUI.this).setVisibility(0);
          DownloadMainUI.d(DownloadMainUI.this).startAnimation(AnimationUtils.loadAnimation(DownloadMainUI.this, e.a.ujy));
          AppMethodBeat.o(8990);
          return;
        }
        DownloadMainUI.c(DownloadMainUI.this).setVisibility(8);
        DownloadMainUI.c(DownloadMainUI.this).startAnimation(AnimationUtils.loadAnimation(DownloadMainUI.this, e.a.uju));
        DownloadMainUI.d(DownloadMainUI.this).setVisibility(8);
        DownloadMainUI.d(DownloadMainUI.this).startAnimation(AnimationUtils.loadAnimation(DownloadMainUI.this, e.a.ujz));
        AppMethodBeat.o(8990);
      }
    };
    this.uns.setOnItemButtonClickListener(new TaskItemView.a()
    {
      public final boolean cQR()
      {
        AppMethodBeat.i(242811);
        boolean bool = com.tencent.mm.plugin.webview.luggage.c.a.gVm();
        Log.i("MicroMsg.DownloadMainUI", "onOnItemButtonClick isTeenMode: %s", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          com.tencent.mm.plugin.webview.luggage.c.a.ja(DownloadMainUI.this);
          AppMethodBeat.o(242811);
          return true;
        }
        AppMethodBeat.o(242811);
        return false;
      }
    });
    this.unu = ((TaskManagerHeaderView)findViewById(e.e.header_view));
    this.unv = findViewById(e.e.ukj);
    ata();
    com.tencent.mm.plugin.downloader_app.b.a.a(10, 0, 0, 1, "", "", cQP());
    this.unA = new com.tencent.mm.plugin.downloader_app.a.f(new com.tencent.mm.plugin.ball.a.e(this));
    this.unA.I(16, "GameDownloadFloatBall");
    com.tencent.mm.plugin.downloader_app.a.e.cQB();
    com.tencent.mm.plugin.downloader_app.a.e.mn(false);
    AppMethodBeat.o(9001);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(9005);
    super.onDestroy();
    com.tencent.mm.plugin.downloader_app.a.h.ump = null;
    if (this.unA != null) {
      this.unA.onDestroy();
    }
    AppMethodBeat.o(9005);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(9004);
    setIntent(paramIntent);
    this.uns.cQW();
    ata();
    AppMethodBeat.o(9004);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(9003);
    super.onPause();
    if (this.uny != null)
    {
      g localg = this.uny;
      ((com.tencent.mm.plugin.game.commlib.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.commlib.a.a.class)).a("pb_appinfo", localg.umk);
    }
    this.unw = false;
    if (this.unA != null) {
      this.unA.aOj();
    }
    AppMethodBeat.o(9003);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(9002);
    super.onResume();
    this.unw = true;
    if (!this.unx)
    {
      this.uny = com.tencent.mm.plugin.downloader_app.a.h.cQG();
      a(this.uny, true);
    }
    this.unx = false;
    if (this.unA != null) {
      this.unA.bNV();
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
    public abstract void mr(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI
 * JD-Core Version:    0.7.0.1
 */