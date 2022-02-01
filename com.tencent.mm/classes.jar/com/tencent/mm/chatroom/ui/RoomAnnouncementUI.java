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
import com.tencent.mm.sdk.platformtools.ad;
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
  private WebView fSD;
  private boolean fSE;
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
    this.fSD = MMWebView.a.s(this, 2131306909);
    this.fSD.getSettings().setJavaScriptEnabled(true);
    this.fSD.getSettings().gfD();
    this.fSD.getSettings().setBuiltInZoomControls(true);
    this.fSD.getSettings().setUseWideViewPort(true);
    this.fSD.getSettings().setLoadWithOverviewMode(true);
    this.fSD.getSettings().gfw();
    this.fSD.getSettings().gfv();
    this.fSD.getSettings().setGeolocationEnabled(false);
    this.fSD.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
    this.fSD.setWebChromeClient(new x()
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
    this.fSD.setWebViewClient(new ac()
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
    String str = getString(2131757103, new Object[] { ad.fom() });
    this.fSD.loadUrl(str);
    AppMethodBeat.o(12690);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12686);
    super.onCreate(paramBundle);
    this.fSE = getIntent().getBooleanExtra("need_bind_mobile", false);
    this.roomId = getIntent().getStringExtra("RoomInfo_Id");
    initView();
    AppMethodBeat.o(12686);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(12689);
    if (this.fSD != null)
    {
      this.fSD.setVisibility(8);
      ((ViewGroup)this.fSD.getParent()).removeView(this.fSD);
      this.fSD.removeAllViews();
      this.fSD.destroy();
      this.fSD = null;
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