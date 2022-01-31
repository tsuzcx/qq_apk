package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.plugin.downloader_app.b.a;
import com.tencent.mm.plugin.downloader_app.b.b;
import com.tencent.mm.plugin.downloader_app.b.d;
import com.tencent.mm.plugin.downloader_app.b.e;
import com.tencent.mm.plugin.downloader_app.b.f;
import com.tencent.mm.plugin.downloader_app.b.g;
import com.tencent.mm.plugin.downloader_app.b.h;
import com.tencent.mm.plugin.downloader_app.b.f;
import com.tencent.mm.plugin.downloader_app.b.j;
import com.tencent.mm.plugin.downloader_app.b.k;
import com.tencent.mm.plugin.downloader_app.detail.d;
import com.tencent.mm.plugin.game.commlib.a.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class DownloadMainUI
  extends MMActivity
{
  private View drU;
  TaskListView iTl;
  private DeleteTaskFooterView iTm;
  private TaskManagerHeaderView iTn;
  private View iTo;
  boolean iTp;
  private boolean iTq;
  private f iTr;
  private boolean iTs = false;
  private String mAppId;
  
  private void a(f paramf, boolean paramBoolean)
  {
    if (paramf != null) {
      if (paramf.iSl.size() != 0) {
        break label32;
      }
    }
    label32:
    for (int i = 1; i != 0; i = 0)
    {
      if (paramBoolean) {
        eY(true);
      }
      return;
    }
    Object localObject1 = k.aGr();
    paramf.iSm.clear();
    localObject1 = ((LinkedList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = (j)paramf.iSl.get(localObject2);
      if (localObject2 != null) {
        paramf.iSm.add(localObject2);
      }
    }
    paramf = paramf.iSm;
    if (bk.dk(paramf))
    {
      eY(true);
      return;
    }
    eY(false);
    this.iTl.setData(paramf);
  }
  
  private void xK()
  {
    com.tencent.mm.kernel.g.DS().O(new Runnable()
    {
      public final void run()
      {
        DownloadMainUI.a(DownloadMainUI.this, com.tencent.mm.plugin.downloader_app.b.g.aGn());
        ai.d(new DownloadMainUI.4.1(this));
        if (DownloadMainUI.a(DownloadMainUI.this, DownloadMainUI.d(DownloadMainUI.this)))
        {
          DownloadMainUI.this.c(k.aGr(), null);
          return;
        }
        LinkedList localLinkedList = k.aGr();
        if (!localLinkedList.contains(DownloadMainUI.d(DownloadMainUI.this))) {
          localLinkedList.add(DownloadMainUI.d(DownloadMainUI.this));
        }
        DownloadMainUI.this.c(localLinkedList, DownloadMainUI.d(DownloadMainUI.this));
        l.m(new DownloadMainUI.4.2(this));
      }
    });
  }
  
  public final void c(LinkedList<String> paramLinkedList, String paramString)
  {
    com.tencent.mm.plugin.downloader_app.b.g.a(paramLinkedList, new DownloadMainUI.8(this, paramString));
  }
  
  public final void eX(boolean paramBoolean)
  {
    DeleteTaskFooterView localDeleteTaskFooterView = this.iTm;
    localDeleteTaskFooterView.iTi = paramBoolean;
    if (localDeleteTaskFooterView.iTi)
    {
      localDeleteTaskFooterView.iTe.setImageResource(b.d.check_box_selected);
      return;
    }
    localDeleteTaskFooterView.iTe.setImageResource(b.d.check_box_unselected);
  }
  
  final void eY(boolean paramBoolean)
  {
    if (paramBoolean) {
      if ((this.iTo instanceof ViewStub))
      {
        this.iTo = ((ViewStub)this.iTo).inflate();
        this.iTo.setVisibility(0);
      }
    }
    while ((this.iTo instanceof ViewStub)) {
      return;
    }
    this.iTo.setVisibility(8);
  }
  
  protected final int getLayoutId()
  {
    return b.f.download_index_layout;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.i("MicroMsg.DownloadMainUI", "onCreate: " + System.currentTimeMillis());
    this.iTq = true;
    ta(getResources().getColor(b.b.downloader_action_bar_color));
    czp();
    setMMTitle(b.h.wechat_download_plugin);
    setBackBtn(new DownloadMainUI.1(this));
    addIconOptionMenu(0, b.g.actionbar_icon_dark_search, new DownloadMainUI.2(this));
    this.iTl = ((TaskListView)findViewById(b.e.list));
    this.iTm = ((DeleteTaskFooterView)findViewById(b.e.delete_layout));
    this.iTl.iTX = new DownloadMainUI.a()
    {
      public final void eZ(boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          DownloadMainUI.a(DownloadMainUI.this).setVisibility(0);
          DownloadMainUI.a(DownloadMainUI.this).startAnimation(AnimationUtils.loadAnimation(DownloadMainUI.this, b.a.bottom_fade_in));
          DownloadMainUI.b(DownloadMainUI.this).setVisibility(0);
          DownloadMainUI.b(DownloadMainUI.this).startAnimation(AnimationUtils.loadAnimation(DownloadMainUI.this, b.a.up_fade_in));
          return;
        }
        DownloadMainUI.a(DownloadMainUI.this).setVisibility(8);
        DownloadMainUI.a(DownloadMainUI.this).startAnimation(AnimationUtils.loadAnimation(DownloadMainUI.this, b.a.bottom_fade_out));
        DownloadMainUI.b(DownloadMainUI.this).setVisibility(8);
        DownloadMainUI.b(DownloadMainUI.this).startAnimation(AnimationUtils.loadAnimation(DownloadMainUI.this, b.a.up_fade_out));
      }
    };
    this.iTn = ((TaskManagerHeaderView)findViewById(b.e.header_view));
    this.iTo = findViewById(b.e.no_task_layout);
    this.mAppId = getIntent().getStringExtra("appId");
    this.iTs = getIntent().getBooleanExtra("view_task", false);
    com.tencent.mm.pluginsdk.model.app.g.by(this.mAppId, true);
    xK();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    d.destroy();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    setIntent(paramIntent);
    this.mAppId = paramIntent.getStringExtra("appId");
    this.iTs = paramIntent.getBooleanExtra("view_task", false);
    com.tencent.mm.pluginsdk.model.app.g.by(this.mAppId, true);
    xK();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.iTr != null)
    {
      f localf = this.iTr;
      ((a)com.tencent.mm.kernel.g.r(a.class)).a("pb_appinfo", localf.iSk);
    }
    this.iTp = false;
  }
  
  public void onResume()
  {
    super.onResume();
    this.iTp = true;
    if (!this.iTq)
    {
      this.iTr = com.tencent.mm.plugin.downloader_app.b.g.aGn();
      a(this.iTr, true);
    }
    this.iTq = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI
 * JD-Core Version:    0.7.0.1
 */