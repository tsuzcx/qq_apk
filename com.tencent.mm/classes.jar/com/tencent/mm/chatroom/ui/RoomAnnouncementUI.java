package com.tencent.mm.chatroom.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.ViewGroup;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;
import com.tencent.xweb.x;
import com.tencent.xweb.z;

@Deprecated
@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.JSEXECUTECHECK})
public class RoomAnnouncementUI
  extends MMActivity
{
  private WebView fxk;
  private boolean fxl;
  private String roomId;
  
  public int getLayoutId()
  {
    return 2131493372;
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  public void initView()
  {
    AppMethodBeat.i(12690);
    setMMTitle(2131762725);
    this.fxk = MMWebView.a.s(this, 2131306909);
    this.fxk.getSettings().setJavaScriptEnabled(true);
    this.fxk.getSettings().fJH();
    this.fxk.getSettings().setBuiltInZoomControls(true);
    this.fxk.getSettings().setUseWideViewPort(true);
    this.fxk.getSettings().setLoadWithOverviewMode(true);
    this.fxk.getSettings().fJA();
    this.fxk.getSettings().fJz();
    this.fxk.getSettings().setGeolocationEnabled(false);
    this.fxk.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
    this.fxk.setWebChromeClient(new x()
    {
      public final boolean a(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, JsResult paramAnonymousJsResult)
      {
        AppMethodBeat.i(12683);
        h.d(RoomAnnouncementUI.this, paramAnonymousString2, null, new DialogInterface.OnClickListener()
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
    this.fxk.setWebViewClient(new ac()
    {
      public final boolean a(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(12684);
        if (paramAnonymousString.equals("weixin://chatroom/upgradeagree"))
        {
          b.a(RoomAnnouncementUI.this, RoomAnnouncementUI.b(RoomAnnouncementUI.this), RoomAnnouncementUI.c(RoomAnnouncementUI.this));
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
    String str = getString(2131757103, new Object[] { ab.eUO() });
    this.fxk.loadUrl(str);
    AppMethodBeat.o(12690);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12686);
    super.onCreate(paramBundle);
    this.fxl = getIntent().getBooleanExtra("need_bind_mobile", false);
    this.roomId = getIntent().getStringExtra("RoomInfo_Id");
    initView();
    AppMethodBeat.o(12686);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(12689);
    if (this.fxk != null)
    {
      this.fxk.setVisibility(8);
      ((ViewGroup)this.fxk.getParent()).removeView(this.fxk);
      this.fxk.removeAllViews();
      this.fxk.destroy();
      this.fxk = null;
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