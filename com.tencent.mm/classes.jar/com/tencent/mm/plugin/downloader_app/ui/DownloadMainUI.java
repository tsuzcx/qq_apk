package com.tencent.mm.plugin.downloader_app.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.plugin.downloader_app.b.j;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import java.util.LinkedList;

public class DownloadMainUI
  extends MMActivity
{
  private View ejC;
  private int ejF;
  private com.tencent.mm.plugin.downloader.c.a.a.f laU;
  TaskListView lca;
  private DeleteTaskFooterView lcb;
  private TaskManagerHeaderView lcc;
  private View lcd;
  private boolean lce;
  private boolean lcf;
  private com.tencent.mm.plugin.downloader_app.b.f lcg;
  private boolean lch = false;
  private String mAppId;
  
  private void Kc()
  {
    AppMethodBeat.i(136243);
    bjY();
    com.tencent.mm.sdk.g.d.ysm.execute(new DownloadMainUI.4(this));
    AppMethodBeat.o(136243);
  }
  
  private void a(com.tencent.mm.plugin.downloader_app.b.f paramf, boolean paramBoolean)
  {
    AppMethodBeat.i(136245);
    if (paramf != null) {}
    for (com.tencent.mm.plugin.downloader.c.a.a.f localf = paramf.laU;; localf = null)
    {
      this.laU = localf;
      if ((paramf != null) && (!paramf.bjQ())) {
        break;
      }
      if (paramBoolean) {
        gB(true);
      }
      AppMethodBeat.o(136245);
      return;
    }
    paramf = paramf.O(j.bjU());
    if (bo.es(paramf))
    {
      gB(true);
      AppMethodBeat.o(136245);
      return;
    }
    gB(false);
    this.lca.setData(paramf);
    AppMethodBeat.o(136245);
  }
  
  private void bjY()
  {
    AppMethodBeat.i(146988);
    this.ejF = getIntent().getIntExtra("from_scene", 0);
    if (this.ejF == 1)
    {
      com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.JD(this.mAppId);
      if (locala != null)
      {
        b localb = new b();
        localb.i(locala);
        localb.iHc = 0L;
        com.tencent.mm.plugin.downloader.f.a.a(19, localb);
      }
    }
    AppMethodBeat.o(146988);
  }
  
  public final void c(LinkedList<String> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(136244);
    com.tencent.mm.plugin.downloader_app.b.g.a(paramLinkedList, new DownloadMainUI.8(this, paramString));
    AppMethodBeat.o(136244);
  }
  
  public final void gA(boolean paramBoolean)
  {
    AppMethodBeat.i(136246);
    DeleteTaskFooterView localDeleteTaskFooterView = this.lcb;
    localDeleteTaskFooterView.lbX = paramBoolean;
    if (localDeleteTaskFooterView.lbX)
    {
      localDeleteTaskFooterView.lbT.setImageResource(2130838378);
      AppMethodBeat.o(136246);
      return;
    }
    localDeleteTaskFooterView.lbT.setImageResource(2130838379);
    AppMethodBeat.o(136246);
  }
  
  final void gB(boolean paramBoolean)
  {
    AppMethodBeat.i(136247);
    if (paramBoolean) {
      if ((this.lcd instanceof ViewStub))
      {
        this.lcd = ((ViewStub)this.lcd).inflate();
        this.lcd.setVisibility(0);
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        this.lcd.setVisibility(0);
        ((NoTaskLayout)this.lcd).setData(this.laU);
      }
      AppMethodBeat.o(136247);
      return;
      if (!(this.lcd instanceof ViewStub)) {
        this.lcd.setVisibility(8);
      }
    }
  }
  
  public int getLayoutId()
  {
    return 2130969333;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(136242);
    if (this.lca != null)
    {
      TaskListView localTaskListView = this.lca;
      if (localTaskListView.lcZ) {
        localTaskListView.bka();
      }
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(136242);
        return;
      }
    }
    super.onBackPressed();
    AppMethodBeat.o(136242);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(136237);
    super.onCreate(paramBundle);
    overridePendingTransition(MMFragmentActivity.a.zcb, MMFragmentActivity.a.zcc);
    ab.i("MicroMsg.DownloadMainUI", "onCreate: " + System.currentTimeMillis());
    this.lcf = true;
    setActionbarColor(getResources().getColor(2131689974));
    showActionbarLine();
    setMMTitle(2131305937);
    setBackBtn(new DownloadMainUI.1(this));
    addIconOptionMenu(0, 2131230741, new DownloadMainUI.2(this));
    this.lca = ((TaskListView)findViewById(2131821002));
    this.lcb = ((DeleteTaskFooterView)findViewById(2131823430));
    this.lca.lcY = new DownloadMainUI.3(this);
    this.lcc = ((TaskManagerHeaderView)findViewById(2131822075));
    this.lcd = findViewById(2131823431);
    this.mAppId = getIntent().getStringExtra("appId");
    this.lch = getIntent().getBooleanExtra("view_task", false);
    com.tencent.mm.pluginsdk.model.app.g.ca(this.mAppId, true);
    Kc();
    com.tencent.mm.plugin.downloader_app.c.a.a(10, 0, 0, 1, "", "", "");
    AppMethodBeat.o(136237);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(136241);
    super.onDestroy();
    com.tencent.mm.plugin.downloader_app.b.g.laW = null;
    AppMethodBeat.o(136241);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(136240);
    setIntent(paramIntent);
    this.lca.bka();
    this.mAppId = paramIntent.getStringExtra("appId");
    this.lch = paramIntent.getBooleanExtra("view_task", false);
    com.tencent.mm.pluginsdk.model.app.g.ca(this.mAppId, true);
    Kc();
    AppMethodBeat.o(136240);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(136239);
    super.onPause();
    if (this.lcg != null)
    {
      com.tencent.mm.plugin.downloader_app.b.f localf = this.lcg;
      ((com.tencent.mm.plugin.game.commlib.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.commlib.a.a.class)).a("pb_appinfo", localf.laR);
    }
    this.lce = false;
    AppMethodBeat.o(136239);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(136238);
    super.onResume();
    this.lce = true;
    if (!this.lcf)
    {
      this.lcg = com.tencent.mm.plugin.downloader_app.b.g.bjR();
      a(this.lcg, true);
    }
    this.lcf = false;
    AppMethodBeat.o(136238);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI
 * JD-Core Version:    0.7.0.1
 */