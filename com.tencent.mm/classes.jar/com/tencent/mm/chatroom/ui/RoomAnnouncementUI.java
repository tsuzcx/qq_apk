package com.tencent.mm.chatroom.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.WebView;
import com.tencent.xweb.t;

@Deprecated
@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.JSEXECUTECHECK})
public class RoomAnnouncementUI
  extends MMActivity
{
  private String eeu;
  private WebView egP;
  private boolean egQ;
  
  public int getLayoutId()
  {
    return 2130969022;
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  public void initView()
  {
    AppMethodBeat.i(104144);
    setMMTitle(2131302813);
    this.egP = MMWebView.a.p(this, 2131822422);
    this.egP.getSettings().setJavaScriptEnabled(true);
    this.egP.getSettings().dYx();
    this.egP.getSettings().setBuiltInZoomControls(true);
    this.egP.getSettings().setUseWideViewPort(true);
    this.egP.getSettings().setLoadWithOverviewMode(true);
    this.egP.getSettings().dYs();
    this.egP.getSettings().dYr();
    this.egP.getSettings().setGeolocationEnabled(false);
    this.egP.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
    this.egP.setWebChromeClient(new RoomAnnouncementUI.1(this));
    this.egP.setWebViewClient(new RoomAnnouncementUI.2(this));
    setBackBtn(new RoomAnnouncementUI.3(this));
    String str = getString(2131298137, new Object[] { aa.dsG() });
    this.egP.loadUrl(str);
    AppMethodBeat.o(104144);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(104140);
    super.onCreate(paramBundle);
    this.egQ = getIntent().getBooleanExtra("need_bind_mobile", false);
    this.eeu = getIntent().getStringExtra("RoomInfo_Id");
    initView();
    AppMethodBeat.o(104140);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(104143);
    if (this.egP != null)
    {
      this.egP.setVisibility(8);
      ((ViewGroup)this.egP.getParent()).removeView(this.egP);
      this.egP.removeAllViews();
      this.egP.destroy();
      this.egP = null;
      System.gc();
    }
    super.onDestroy();
    AppMethodBeat.o(104143);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(104142);
    super.onPause();
    AppMethodBeat.o(104142);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(104141);
    super.onResume();
    AppMethodBeat.o(104141);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomAnnouncementUI
 * JD-Core Version:    0.7.0.1
 */