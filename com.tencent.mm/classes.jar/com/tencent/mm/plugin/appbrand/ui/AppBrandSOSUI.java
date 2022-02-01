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
import com.tencent.mm.br.d;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSMoreWebViewUI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.a.c;
import java.lang.reflect.Field;
import java.util.List;

public class AppBrandSOSUI
  extends FTSSOSMoreWebViewUI
{
  private View meb;
  private String mec;
  private String med;
  private int scene;
  
  private int bvt()
  {
    int i = 0;
    AppMethodBeat.i(21130);
    try
    {
      Class localClass = Class.forName("com.android.internal.R$dimen");
      Object localObject = localClass.newInstance();
      int j = bs.getInt(localClass.getField("status_bar_height").get(localObject).toString(), 0);
      j = getResources().getDimensionPixelSize(j);
      i = j;
    }
    catch (Exception localException)
    {
      label50:
      break label50;
    }
    AppMethodBeat.o(21130);
    return i;
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(163179);
    if (!TextUtils.isEmpty(paramString2)) {
      this.meb.setVisibility(8);
    }
    try
    {
      this.kYt.k(10001, null);
      super.a(paramString1, paramString2, paramList, paramb);
      AppMethodBeat.o(163179);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ac.e("MicroMsg.AppBrandSOSUI", "refresh keyword id error : %s", new Object[] { localRemoteException });
      }
    }
  }
  
  public final boolean bvs()
  {
    AppMethodBeat.i(21127);
    this.meb.setVisibility(8);
    boolean bool = super.bvs();
    AppMethodBeat.o(21127);
    return bool;
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(21129);
    super.dealContentView(paramView);
    this.mec = getIntent().getStringExtra("key_nearby_url");
    getIntent().getStringExtra("key_nearby_list_id");
    this.meb = getLayoutInflater().inflate(2131493053, (ViewGroup)paramView, false);
    View localView1 = this.meb.findViewById(2131302682);
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(21124);
        if (TextUtils.isEmpty(AppBrandSOSUI.a(AppBrandSOSUI.this)))
        {
          AppMethodBeat.o(21124);
          return;
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("showShare", false);
        localIntent.putExtra("rawUrl", AppBrandSOSUI.a(AppBrandSOSUI.this));
        localIntent.putExtra("geta8key_scene", 41);
        localIntent.putExtra("show_long_click_popup_menu", false);
        d.b(paramAnonymousView.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
        AppMethodBeat.o(21124);
      }
    });
    if (TextUtils.isEmpty(this.mec))
    {
      localView1.setVisibility(8);
      this.meb.setVisibility(8);
    }
    while ((paramView instanceof FrameLayout))
    {
      ((FrameLayout)paramView).addView(this.meb);
      AppMethodBeat.o(21129);
      return;
      localView1.setVisibility(0);
      this.meb.setVisibility(0);
    }
    paramView = paramView.getLayoutParams();
    int k;
    Rect localRect;
    int i;
    if (getWindow().hasFeature(9))
    {
      localView1 = this.meb;
      k = this.meb.getPaddingLeft();
      localRect = new Rect();
      int j = getActionBarHeight();
      View localView2 = getWindow().getDecorView();
      localView2.getWindowVisibleDisplayFrame(localRect);
      int m = localView2.getHeight();
      int[] arrayOfInt = new int[2];
      localView2.getLocationOnScreen(arrayOfInt);
      i = j;
      if (m == 0) {
        i = j + bvt();
      }
      if ((m - localRect.height() < 0) || (arrayOfInt[1] <= 200)) {
        break label317;
      }
      i += m - localRect.height();
    }
    for (;;)
    {
      localView1.setPadding(k, i + this.meb.getPaddingTop(), this.meb.getPaddingRight(), this.meb.getPaddingBottom());
      addContentView(this.meb, paramView);
      AppMethodBeat.o(21129);
      return;
      label317:
      i += localRect.top;
    }
  }
  
  public final String getHint()
  {
    AppMethodBeat.i(21131);
    String str = getIntent().getStringExtra("key_search_place_holder");
    if ((str != null) && (str.length() > 0))
    {
      AppMethodBeat.o(21131);
      return str;
    }
    str = super.getHint();
    AppMethodBeat.o(21131);
    return str;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(21125);
    super.onCreate(paramBundle);
    overridePendingTransition(2130772095, 0);
    this.med = getIntent().getStringExtra("key_session_id");
    this.scene = getIntent().getIntExtra("ftsbizscene", 0);
    ac.i("MicroMsg.AppBrandSOSUI", "onCreate oreh report weAppSearchClickStream(13929) statSessionId:%s", new Object[] { this.med });
    h.wUl.f(13929, new Object[] { this.med, "", Integer.valueOf(1), Integer.valueOf(this.scene) });
    paramBundle = new Intent();
    paramBundle.putExtra("key_session_id", this.med);
    paramBundle.putExtra("ftsbizscene", this.scene);
    setResult(-1, paramBundle);
    AppMethodBeat.o(21125);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21126);
    if ((this.scene == 3) || (this.scene == 16)) {
      h.wUl.f(13929, new Object[] { this.med, b.hrW, Integer.valueOf(2), Integer.valueOf(this.scene) });
    }
    super.onDestroy();
    AppMethodBeat.o(21126);
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