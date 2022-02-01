package com.tencent.mm.chatroom.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebView;
import com.tencent.xweb.x;
import com.tencent.xweb.z;

@Deprecated
@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.JSEXECUTECHECK})
public class RoomAnnouncementUI
  extends MMActivity
{
  private WebView gxL;
  private boolean gxM;
  private String roomId;
  
  public int getLayoutId()
  {
    return 2131493463;
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  public void initView()
  {
    AppMethodBeat.i(12690);
    setMMTitle(2131764808);
    this.gxL = MMWebView.a.r(this, 2131310382);
    this.gxL.getSettings().setJavaScriptEnabled(true);
    this.gxL.getSettings().hsU();
    this.gxL.getSettings().setBuiltInZoomControls(true);
    this.gxL.getSettings().setUseWideViewPort(true);
    this.gxL.getSettings().setLoadWithOverviewMode(true);
    this.gxL.getSettings().hsN();
    this.gxL.getSettings().hsM();
    this.gxL.getSettings().setGeolocationEnabled(false);
    this.gxL.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
    this.gxL.setWebChromeClient(new x()
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
    this.gxL.setWebViewClient(new RoomAnnouncementUI.2(this));
    setBackBtn(new RoomAnnouncementUI.3(this));
    String str = getString(2131757304, new Object[] { LocaleUtil.getApplicationLanguage() });
    this.gxL.loadUrl(str);
    AppMethodBeat.o(12690);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12686);
    super.onCreate(paramBundle);
    this.gxM = getIntent().getBooleanExtra("need_bind_mobile", false);
    this.roomId = getIntent().getStringExtra("RoomInfo_Id");
    initView();
    AppMethodBeat.o(12686);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(12689);
    if (this.gxL != null)
    {
      this.gxL.setVisibility(8);
      ((ViewGroup)this.gxL.getParent()).removeView(this.gxL);
      this.gxL.removeAllViews();
      this.gxL.destroy();
      this.gxL = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomAnnouncementUI
 * JD-Core Version:    0.7.0.1
 */