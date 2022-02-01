package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ad;
import com.tencent.xweb.ag;
import com.tencent.xweb.z;

@Deprecated
public class RoomAnnouncementUI
  extends MMActivity
{
  private WebView lKd;
  private boolean lKe;
  private String roomId;
  
  public int getLayoutId()
  {
    return a.f.lFY;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12690);
    setMMTitle(a.i.lJl);
    this.lKd = MMWebView.a.u(this, a.e.webview);
    this.lKd.getSettings().setJavaScriptEnabled(true);
    this.lKd.getSettings().kfS();
    this.lKd.getSettings().setBuiltInZoomControls(true);
    this.lKd.getSettings().setUseWideViewPort(true);
    this.lKd.getSettings().setLoadWithOverviewMode(true);
    this.lKd.getSettings().kfN();
    this.lKd.getSettings().kfM();
    this.lKd.getSettings().setGeolocationEnabled(false);
    this.lKd.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
    this.lKd.setWebChromeClient(new z()
    {
      public final boolean a(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, JsResult paramAnonymousJsResult)
      {
        AppMethodBeat.i(12683);
        k.d(RoomAnnouncementUI.this, paramAnonymousString2, null, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(12682);
            RoomAnnouncementUI.a(RoomAnnouncementUI.this).requestFocus();
            AppMethodBeat.o(12682);
          }
        });
        paramAnonymousJsResult.cancel();
        AppMethodBeat.o(12683);
        return true;
      }
    });
    this.lKd.setWebViewClient(new ag()
    {
      public final boolean a(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(12684);
        if (paramAnonymousString.equals("weixin://chatroom/upgradeagree"))
        {
          d.a(RoomAnnouncementUI.this, RoomAnnouncementUI.b(RoomAnnouncementUI.this), RoomAnnouncementUI.c(RoomAnnouncementUI.this));
          AppMethodBeat.o(12684);
          return true;
        }
        AppMethodBeat.o(12684);
        return false;
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(12685);
        RoomAnnouncementUI.this.setResult(0);
        RoomAnnouncementUI.this.finish();
        AppMethodBeat.o(12685);
        return true;
      }
    });
    String str = getString(a.i.chatroom_owner_responsibility, new Object[] { LocaleUtil.getApplicationLanguage() });
    this.lKd.loadUrl(str);
    AppMethodBeat.o(12690);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12686);
    super.onCreate(paramBundle);
    this.lKe = getIntent().getBooleanExtra("need_bind_mobile", false);
    this.roomId = getIntent().getStringExtra("RoomInfo_Id");
    initView();
    AppMethodBeat.o(12686);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(12689);
    if (this.lKd != null)
    {
      this.lKd.setVisibility(8);
      ((ViewGroup)this.lKd.getParent()).removeView(this.lKd);
      this.lKd.removeAllViews();
      this.lKd.destroy();
      this.lKd = null;
      System.gc();
    }
    super.onDestroy();
    AppMethodBeat.o(12689);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(12688);
    super.onPause();
    AppMethodBeat.o(12688);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(12687);
    super.onResume();
    AppMethodBeat.o(12687);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomAnnouncementUI
 * JD-Core Version:    0.7.0.1
 */