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
import com.tencent.mm.ipcinvoker.p;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader_app.a.h.a;
import com.tencent.mm.plugin.downloader_app.a.j;
import com.tencent.mm.plugin.downloader_app.search.DownloadSearchUI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public class DownloadMainUI
  extends MMActivity
{
  private int fwc;
  private View fzV;
  private String mAppId;
  private com.tencent.mm.plugin.downloader.c.a.a.f oLw;
  TaskListView oMB;
  private DeleteTaskFooterView oMC;
  private TaskManagerHeaderView oMD;
  private View oME;
  private boolean oMF;
  private boolean oMG;
  private com.tencent.mm.plugin.downloader_app.a.g oMH;
  private boolean oMI = false;
  private com.tencent.mm.plugin.downloader_app.a.f oMJ;
  
  private void WJ()
  {
    AppMethodBeat.i(9007);
    this.mAppId = getIntent().getStringExtra("appId");
    this.oMI = getIntent().getBooleanExtra("view_task", false);
    ac.i("MicroMsg.DownloadMainUI", "initData, appId : %s, viewTask : %b", new Object[] { this.mAppId, Boolean.valueOf(this.oMI) });
    com.tencent.mm.pluginsdk.model.app.h.k(this.mAppId, true, false);
    bYB();
    com.tencent.e.h.JZN.aS(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(8993);
        DownloadMainUI.a(DownloadMainUI.this, com.tencent.mm.plugin.downloader_app.a.h.bYt());
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(8991);
            DownloadMainUI.a(DownloadMainUI.this, DownloadMainUI.e(DownloadMainUI.this), false);
            AppMethodBeat.o(8991);
          }
        });
        if (DownloadMainUI.a(DownloadMainUI.this, DownloadMainUI.f(DownloadMainUI.this)))
        {
          DownloadMainUI.this.d(j.bYx(), null);
          AppMethodBeat.o(8993);
          return;
        }
        LinkedList localLinkedList = j.bYx();
        if (!localLinkedList.contains(DownloadMainUI.f(DownloadMainUI.this))) {
          localLinkedList.add(DownloadMainUI.f(DownloadMainUI.this));
        }
        DownloadMainUI.this.d(localLinkedList, DownloadMainUI.f(DownloadMainUI.this));
        p.z(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(8992);
            DownloadMainUI.g(DownloadMainUI.this);
            AppMethodBeat.o(8992);
          }
        });
        AppMethodBeat.o(8993);
      }
    });
    AppMethodBeat.o(9007);
  }
  
  private void a(com.tencent.mm.plugin.downloader_app.a.g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(9010);
    if (paramg != null) {}
    for (com.tencent.mm.plugin.downloader.c.a.a.f localf = paramg.oLw;; localf = null)
    {
      this.oLw = localf;
      if ((paramg != null) && (!paramg.bYs())) {
        break;
      }
      if (paramBoolean) {
        jR(true);
      }
      AppMethodBeat.o(9010);
      return;
    }
    paramg = paramg.U(j.bYx());
    if (bs.gY(paramg))
    {
      jR(true);
      AppMethodBeat.o(9010);
      return;
    }
    jR(false);
    this.oMB.setData(paramg);
    AppMethodBeat.o(9010);
  }
  
  private void bYB()
  {
    AppMethodBeat.i(9008);
    if (this.fwc == 1)
    {
      com.tencent.mm.plugin.downloader.g.a locala = d.Ww(this.mAppId);
      if (locala != null)
      {
        com.tencent.mm.plugin.downloader.f.b localb = new com.tencent.mm.plugin.downloader.f.b();
        localb.k(locala);
        localb.lTa = 0L;
        com.tencent.mm.plugin.downloader.f.a.a(19, localb);
      }
    }
    AppMethodBeat.o(9008);
  }
  
  private String bYC()
  {
    AppMethodBeat.i(175277);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("source", this.fwc);
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
  
  private boolean bYD()
  {
    return this.fwc == 2;
  }
  
  public final void d(LinkedList<String> paramLinkedList, final String paramString)
  {
    AppMethodBeat.i(9009);
    com.tencent.mm.plugin.downloader_app.a.h.a(paramLinkedList, new h.a()
    {
      public final void jJ(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(9000);
        p.z(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(8997);
            DownloadMainUI.j(DownloadMainUI.this);
            AppMethodBeat.o(8997);
          }
        });
        if (paramAnonymousBoolean)
        {
          DownloadMainUI.a(DownloadMainUI.this, com.tencent.mm.plugin.downloader_app.a.h.bYt());
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(8999);
              if (!bs.isNullOrNil(DownloadMainUI.8.this.oMM))
              {
                final com.tencent.mm.plugin.downloader_app.a.i locali = DownloadMainUI.e(DownloadMainUI.this).WV(DownloadMainUI.8.this.oMM);
                if (locali == null) {
                  break label98;
                }
                j.WX(DownloadMainUI.8.this.oMM);
                p.postDelayed(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(8998);
                    com.tencent.mm.plugin.downloader_app.a.c.a(DownloadMainUI.this, locali, true);
                    AppMethodBeat.o(8998);
                  }
                }, 200L);
              }
              for (;;)
              {
                DownloadMainUI.a(DownloadMainUI.this, DownloadMainUI.e(DownloadMainUI.this), true);
                AppMethodBeat.o(8999);
                return;
                label98:
                com.tencent.mm.ui.base.h.c(DownloadMainUI.this, "", DownloadMainUI.this.getResources().getString(2131761618), true);
              }
            }
          });
          AppMethodBeat.o(9000);
          return;
        }
        if (!bs.isNullOrNil(paramString)) {
          com.tencent.mm.ui.base.h.c(DownloadMainUI.this, "", DownloadMainUI.this.getResources().getString(2131757033), true);
        }
        AppMethodBeat.o(9000);
      }
    });
    AppMethodBeat.o(9009);
  }
  
  public void finish()
  {
    AppMethodBeat.i(175276);
    super.finish();
    if (this.fwc == 3) {
      overridePendingTransition(2130772001, 2130772012);
    }
    AppMethodBeat.o(175276);
  }
  
  public int getLayoutId()
  {
    return 2131493722;
  }
  
  public final void jQ(boolean paramBoolean)
  {
    AppMethodBeat.i(9011);
    DeleteTaskFooterView localDeleteTaskFooterView = this.oMC;
    localDeleteTaskFooterView.oMy = paramBoolean;
    if (localDeleteTaskFooterView.oMy)
    {
      com.tencent.mm.plugin.downloader_app.b.e(localDeleteTaskFooterView.oMu, "checkbox_cell_on");
      AppMethodBeat.o(9011);
      return;
    }
    com.tencent.mm.plugin.downloader_app.b.e(localDeleteTaskFooterView.oMu, "checkbox_cell_off");
    AppMethodBeat.o(9011);
  }
  
  final void jR(boolean paramBoolean)
  {
    AppMethodBeat.i(9012);
    if (paramBoolean) {
      if ((this.oME instanceof ViewStub))
      {
        this.oME = ((ViewStub)this.oME).inflate();
        this.oME.setVisibility(0);
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        this.oME.setVisibility(0);
        ((NoTaskLayout)this.oME).setData(this.oLw);
      }
      AppMethodBeat.o(9012);
      return;
      if (!(this.oME instanceof ViewStub)) {
        this.oME.setVisibility(8);
      }
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(9006);
    if (this.oMB != null)
    {
      TaskListView localTaskListView = this.oMB;
      if (localTaskListView.oNC) {
        localTaskListView.bYI();
      }
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(9006);
        return;
      }
    }
    if ((bYD()) && (this.oMJ != null) && (this.oMJ.rT(2)))
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
    this.fwc = getIntent().getIntExtra("from_scene", 0);
    if (this.fwc == 3) {
      overridePendingTransition(2130772161, 2130772003);
    }
    ac.i("MicroMsg.DownloadMainUI", "onCreate: " + System.currentTimeMillis());
    this.oMG = true;
    setActionbarColor(getResources().getColor(2131100260));
    showActionbarLine();
    setMMTitle(2131766183);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(8988);
        if ((DownloadMainUI.a(DownloadMainUI.this)) && (DownloadMainUI.b(DownloadMainUI.this) != null) && (DownloadMainUI.b(DownloadMainUI.this).rT(1)))
        {
          AppMethodBeat.o(8988);
          return true;
        }
        DownloadMainUI.this.finish();
        AppMethodBeat.o(8988);
        return true;
      }
    });
    addIconOptionMenu(0, 2131689494, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(8989);
        paramAnonymousMenuItem = DownloadMainUI.this;
        Object localObject = new Intent(DownloadMainUI.this, DownloadSearchUI.class);
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/downloader_app/ui/DownloadMainUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/plugin/downloader_app/ui/DownloadMainUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.downloader_app.b.a.a(10, 1001, 1, 2, "", "", "");
        AppMethodBeat.o(8989);
        return true;
      }
    });
    this.oMB = ((TaskListView)findViewById(2131301443));
    this.oMC = ((DeleteTaskFooterView)findViewById(2131298989));
    this.oMB.oNB = new a()
    {
      public final void jS(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(8990);
        if (paramAnonymousBoolean)
        {
          DownloadMainUI.c(DownloadMainUI.this).setVisibility(0);
          DownloadMainUI.c(DownloadMainUI.this).startAnimation(AnimationUtils.loadAnimation(DownloadMainUI.this, 2130772010));
          DownloadMainUI.d(DownloadMainUI.this).setVisibility(0);
          DownloadMainUI.d(DownloadMainUI.this).startAnimation(AnimationUtils.loadAnimation(DownloadMainUI.this, 2130772165));
          AppMethodBeat.o(8990);
          return;
        }
        DownloadMainUI.c(DownloadMainUI.this).setVisibility(8);
        DownloadMainUI.c(DownloadMainUI.this).startAnimation(AnimationUtils.loadAnimation(DownloadMainUI.this, 2130772011));
        DownloadMainUI.d(DownloadMainUI.this).setVisibility(8);
        DownloadMainUI.d(DownloadMainUI.this).startAnimation(AnimationUtils.loadAnimation(DownloadMainUI.this, 2130772166));
        AppMethodBeat.o(8990);
      }
    };
    this.oMD = ((TaskManagerHeaderView)findViewById(2131300735));
    this.oME = findViewById(2131302888);
    WJ();
    com.tencent.mm.plugin.downloader_app.b.a.a(10, 0, 0, 1, "", "", bYC());
    this.oMJ = new com.tencent.mm.plugin.downloader_app.a.f(new com.tencent.mm.plugin.ball.a.e(this));
    this.oMJ.aa(16, "GameDownloadFloatBall");
    com.tencent.mm.plugin.downloader_app.a.e.bYo();
    com.tencent.mm.plugin.downloader_app.a.e.jO(false);
    AppMethodBeat.o(9001);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(9005);
    super.onDestroy();
    com.tencent.mm.plugin.downloader_app.a.h.oLy = null;
    if (this.oMJ != null) {
      this.oMJ.onDestroy();
    }
    AppMethodBeat.o(9005);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(9004);
    setIntent(paramIntent);
    this.oMB.bYI();
    WJ();
    AppMethodBeat.o(9004);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(9003);
    super.onPause();
    if (this.oMH != null)
    {
      com.tencent.mm.plugin.downloader_app.a.g localg = this.oMH;
      ((com.tencent.mm.plugin.game.commlib.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.commlib.a.a.class)).a("pb_appinfo", localg.oLt);
    }
    this.oMF = false;
    if (this.oMJ != null) {
      this.oMJ.bcY();
    }
    AppMethodBeat.o(9003);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(9002);
    super.onResume();
    this.oMF = true;
    if (!this.oMG)
    {
      this.oMH = com.tencent.mm.plugin.downloader_app.a.h.bYt();
      a(this.oMH, true);
    }
    this.oMG = false;
    if (this.oMJ != null) {
      this.oMJ.bcX();
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
    public abstract void jS(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI
 * JD-Core Version:    0.7.0.1
 */