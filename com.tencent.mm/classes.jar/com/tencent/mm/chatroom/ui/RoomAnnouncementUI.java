package com.tencent.mm.chatroom.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import com.jg.JgClassChecked;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.WebView;
import com.tencent.xweb.n;

@Deprecated
@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.JSEXECUTECHECK})
public class RoomAnnouncementUI
  extends MMActivity
{
  private String dmT;
  private WebView dpt;
  private boolean dpu;
  
  public final int getLayoutId()
  {
    return a.f.chatroom_announcement;
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  protected final void initView()
  {
    setMMTitle(a.i.room_upgrade_responsibility_title);
    this.dpt = MMWebView.a.m(this, a.e.webview);
    this.dpt.getSettings().setJavaScriptEnabled(true);
    this.dpt.getSettings().cSs();
    this.dpt.getSettings().setBuiltInZoomControls(true);
    this.dpt.getSettings().setUseWideViewPort(true);
    this.dpt.getSettings().setLoadWithOverviewMode(true);
    this.dpt.getSettings().cSn();
    this.dpt.getSettings().cSm();
    this.dpt.getSettings().setGeolocationEnabled(false);
    this.dpt.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
    this.dpt.setWebChromeClient(new RoomAnnouncementUI.1(this));
    this.dpt.setWebViewClient(new RoomAnnouncementUI.2(this));
    setBackBtn(new RoomAnnouncementUI.3(this));
    String str = getString(a.i.chatroom_owner_responsibility, new Object[] { x.cqJ() });
    this.dpt.loadUrl(str);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.dpu = getIntent().getBooleanExtra("need_bind_mobile", false);
    this.dmT = getIntent().getStringExtra("RoomInfo_Id");
    initView();
  }
  
  protected void onDestroy()
  {
    if (this.dpt != null)
    {
      this.dpt.setVisibility(8);
      ((ViewGroup)this.dpt.getParent()).removeView(this.dpt);
      this.dpt.removeAllViews();
      this.dpt.destroy();
      this.dpt = null;
      System.gc();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomAnnouncementUI
 * JD-Core Version:    0.7.0.1
 */