package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.b;
import com.tencent.mm.plugin.fts.ui.widget.a.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSMoreWebViewUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Field;
import java.util.List;

public class AppBrandSOSUI
  extends FTSSOSMoreWebViewUI
{
  private View iOB;
  private String iOC;
  private String iOD;
  private int scene;
  
  private int aMn()
  {
    int i = 0;
    AppMethodBeat.i(17079);
    try
    {
      Class localClass = Class.forName("com.android.internal.R$dimen");
      Object localObject = localClass.newInstance();
      int j = bo.getInt(localClass.getField("status_bar_height").get(localObject).toString(), 0);
      j = getResources().getDimensionPixelSize(j);
      i = j;
    }
    catch (Exception localException)
    {
      label50:
      break label50;
    }
    AppMethodBeat.o(17079);
    return i;
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(17077);
    if (!TextUtils.isEmpty(paramString2)) {
      this.iOB.setVisibility(8);
    }
    try
    {
      this.igU.i(10001, null);
      super.a(paramString1, paramString2, paramList, paramb);
      AppMethodBeat.o(17077);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ab.e("MicroMsg.AppBrandSOSUI", "refresh keyword id error : %s", new Object[] { localRemoteException });
      }
    }
  }
  
  public final boolean aMm()
  {
    AppMethodBeat.i(17076);
    this.iOB.setVisibility(8);
    boolean bool = super.aMm();
    AppMethodBeat.o(17076);
    return bool;
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(17078);
    super.dealContentView(paramView);
    this.iOC = getIntent().getStringExtra("key_nearby_url");
    getIntent().getStringExtra("key_nearby_list_id");
    this.iOB = getLayoutInflater().inflate(2130968734, (ViewGroup)paramView, false);
    View localView1 = this.iOB.findViewById(2131821400);
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(17073);
        if (TextUtils.isEmpty(AppBrandSOSUI.a(AppBrandSOSUI.this)))
        {
          AppMethodBeat.o(17073);
          return;
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("showShare", false);
        localIntent.putExtra("rawUrl", AppBrandSOSUI.a(AppBrandSOSUI.this));
        localIntent.putExtra("geta8key_scene", 41);
        localIntent.putExtra("show_long_click_popup_menu", false);
        com.tencent.mm.bq.d.b(paramAnonymousView.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
        AppMethodBeat.o(17073);
      }
    });
    if (TextUtils.isEmpty(this.iOC))
    {
      localView1.setVisibility(8);
      this.iOB.setVisibility(8);
    }
    while ((paramView instanceof FrameLayout))
    {
      ((FrameLayout)paramView).addView(this.iOB);
      AppMethodBeat.o(17078);
      return;
      localView1.setVisibility(0);
      this.iOB.setVisibility(0);
    }
    paramView = paramView.getLayoutParams();
    int k;
    Rect localRect;
    int i;
    if (getWindow().hasFeature(9))
    {
      localView1 = this.iOB;
      k = this.iOB.getPaddingLeft();
      localRect = new Rect();
      int j = getActionBarHeight();
      View localView2 = getWindow().getDecorView();
      localView2.getWindowVisibleDisplayFrame(localRect);
      int m = localView2.getHeight();
      int[] arrayOfInt = new int[2];
      localView2.getLocationOnScreen(arrayOfInt);
      i = j;
      if (m == 0) {
        i = j + aMn();
      }
      if ((m - localRect.height() < 0) || (arrayOfInt[1] <= 200)) {
        break label317;
      }
      i += m - localRect.height();
    }
    for (;;)
    {
      localView1.setPadding(k, i + this.iOB.getPaddingTop(), this.iOB.getPaddingRight(), this.iOB.getPaddingBottom());
      addContentView(this.iOB, paramView);
      AppMethodBeat.o(17078);
      return;
      label317:
      i += localRect.top;
    }
  }
  
  public final String getHint()
  {
    AppMethodBeat.i(17080);
    String str = getIntent().getStringExtra("key_search_place_holder");
    if ((str != null) && (str.length() > 0))
    {
      AppMethodBeat.o(17080);
      return str;
    }
    str = super.getHint();
    AppMethodBeat.o(17080);
    return str;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(17074);
    super.onCreate(paramBundle);
    overridePendingTransition(2131034217, 0);
    this.iOD = getIntent().getStringExtra("key_session_id");
    this.scene = getIntent().getIntExtra("ftsbizscene", 0);
    ab.i("MicroMsg.AppBrandSOSUI", "onCreate oreh report weAppSearchClickStream(13929) statSessionId:%s", new Object[] { this.iOD });
    h.qsU.e(13929, new Object[] { this.iOD, "", Integer.valueOf(1), Integer.valueOf(this.scene) });
    paramBundle = new Intent();
    paramBundle.putExtra("key_session_id", this.iOD);
    paramBundle.putExtra("ftsbizscene", this.scene);
    setResult(-1, paramBundle);
    AppMethodBeat.o(17074);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(17075);
    if ((this.scene == 3) || (this.scene == 16)) {
      h.qsU.e(13929, new Object[] { this.iOD, b.fpR, Integer.valueOf(2), Integer.valueOf(this.scene) });
    }
    super.onDestroy();
    AppMethodBeat.o(17075);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandSOSUI
 * JD-Core Version:    0.7.0.1
 */