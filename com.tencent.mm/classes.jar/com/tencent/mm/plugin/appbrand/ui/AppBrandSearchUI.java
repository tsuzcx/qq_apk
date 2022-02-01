package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.compatible.util.n;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.appbrand.ab;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.f.57;
import com.tencent.mm.plugin.webview.c.l.a;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSearchTabWebViewUI;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.WebSearchView;
import com.tencent.mm.ui.search.a.c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public class AppBrandSearchUI
  extends FTSSearchTabWebViewUI
{
  private View mEu;
  private String mEv;
  private String mEw;
  private int scene;
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(163181);
    if ((!TextUtils.isEmpty(paramString2)) && (this.mEu != null)) {
      this.mEu.setVisibility(8);
    }
    if (this.lvv == null) {
      if ((!isFinishing()) && (!isDestroyed())) {
        Assert.fail("invoker is NULL");
      }
    }
    for (;;)
    {
      super.a(paramString1, paramString2, paramList, paramb);
      AppMethodBeat.o(163181);
      return;
      try
      {
        this.lvv.k(10001, null);
      }
      catch (RemoteException localRemoteException)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppBrandSearchUI", "refresh keyword id error : %s", new Object[] { localRemoteException });
      }
    }
  }
  
  public final void bzn()
  {
    AppMethodBeat.i(21138);
    super.bzn();
    if ((this.EgI != null) && (!bt.isNullOrNil(this.query)))
    {
      this.EgI.getFtsEditText().H(this.query, null);
      this.EgI.getFtsEditText().vr.clearFocus();
      hideVKB();
    }
    AppMethodBeat.o(21138);
  }
  
  public final int bzo()
  {
    AppMethodBeat.i(21140);
    if ((Build.VERSION.SDK_INT >= 23) && ((!com.tencent.mm.compatible.util.g.abk()) || (!AppBrandNearbyWebViewUI.abl())))
    {
      al.d(getWindow());
      AppMethodBeat.o(21140);
      return -855310;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      i = ab.jAT;
      AppMethodBeat.o(21140);
      return i;
    }
    int i = super.bzo();
    AppMethodBeat.o(21140);
    return i;
  }
  
  public final boolean bzz()
  {
    AppMethodBeat.i(21142);
    this.mEu.setVisibility(8);
    boolean bool = super.bzz();
    AppMethodBeat.o(21142);
    return bool;
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(21144);
    super.dealContentView(paramView);
    this.mEv = getIntent().getStringExtra("key_nearby_url");
    getIntent().getStringExtra("key_nearby_list_id");
    this.mEu = getLayoutInflater().inflate(2131493053, (ViewGroup)paramView, false);
    View localView1 = this.mEu.findViewById(2131302682);
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(21132);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandSearchUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        if (TextUtils.isEmpty(AppBrandSearchUI.a(AppBrandSearchUI.this)))
        {
          a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandSearchUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(21132);
          return;
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("showShare", false);
        ((Intent)localObject).putExtra("rawUrl", AppBrandSearchUI.a(AppBrandSearchUI.this));
        ((Intent)localObject).putExtra("geta8key_scene", 41);
        ((Intent)localObject).putExtra("show_long_click_popup_menu", false);
        d.b(paramAnonymousView.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
        a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandSearchUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(21132);
      }
    });
    if (TextUtils.isEmpty(this.mEv))
    {
      localView1.setVisibility(8);
      this.mEu.setVisibility(8);
    }
    while ((paramView instanceof FrameLayout))
    {
      ((FrameLayout)paramView).addView(this.mEu);
      AppMethodBeat.o(21144);
      return;
      localView1.setVisibility(0);
      this.mEu.setVisibility(0);
    }
    paramView = paramView.getLayoutParams();
    int k;
    Rect localRect;
    int i;
    if (getWindow().hasFeature(9))
    {
      localView1 = this.mEu;
      k = this.mEu.getPaddingLeft();
      localRect = new Rect();
      int j = getActionBarHeight();
      View localView2 = getWindow().getDecorView();
      localView2.getWindowVisibleDisplayFrame(localRect);
      int m = localView2.getHeight();
      int[] arrayOfInt = new int[2];
      localView2.getLocationOnScreen(arrayOfInt);
      i = j;
      if (m == 0) {
        i = j + n.B(getContext(), 0);
      }
      if ((m - localRect.height() < 0) || (arrayOfInt[1] <= 200)) {
        break label321;
      }
      i += m - localRect.height();
    }
    for (;;)
    {
      localView1.setPadding(k, i + this.mEu.getPaddingTop(), this.mEu.getPaddingRight(), this.mEu.getPaddingBottom());
      addContentView(this.mEu, paramView);
      AppMethodBeat.o(21144);
      return;
      label321:
      i += localRect.top;
    }
  }
  
  public final String getHint()
  {
    AppMethodBeat.i(21147);
    String str = getIntent().getStringExtra("key_search_place_holder");
    if ((str != null) && (str.length() > 0))
    {
      AppMethodBeat.o(21147);
      return str;
    }
    str = super.getHint();
    AppMethodBeat.o(21147);
    return str;
  }
  
  public final void n(final int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(21146);
    super.n(paramInt, paramBundle);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(21146);
      return;
      final String str = paramBundle.getString("fts_key_json_data");
      paramInt = paramBundle.getInt("fts_key_is_cache_data", 0);
      final int i = paramBundle.getInt("fts_key_is_expired", 1);
      final int j = paramBundle.getInt("fts_key_is_preload", 0);
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(21133);
          if (AppBrandSearchUI.this.DzP != null)
          {
            f localf = AppBrandSearchUI.this.DzP;
            String str = str;
            int i = paramInt;
            int j = i;
            int k = j;
            if (!localf.BHY)
            {
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.JsApiHandler", "onSearchGuideDataReady fail, not ready");
              AppMethodBeat.o(21133);
              return;
            }
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.JsApiHandler", "onSearchGuideDataReady success, ready");
            HashMap localHashMap = new HashMap();
            localHashMap.put("json", str);
            localHashMap.put("isCacheData", Integer.valueOf(i));
            localHashMap.put("isExpired", Integer.valueOf(j));
            localHashMap.put("isPreload", Integer.valueOf(k));
            aq.f(new f.57(localf, l.a.b("onSearchGuideDataReady", localHashMap, localf.DMD, localf.vJP)));
          }
          AppMethodBeat.o(21133);
        }
      });
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(21134);
    super.onCreate(paramBundle);
    if (getIntent() == null)
    {
      finish();
      AppMethodBeat.o(21134);
      return;
    }
    com.tencent.mm.plugin.websearch.api.ad.Wf(com.tencent.mm.plugin.websearch.api.ad.We(3));
    this.mEw = getIntent().getStringExtra("key_session_id");
    this.scene = getIntent().getIntExtra("ftsbizscene", 0);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandSearchUI", "onCreate oreh report weAppSearchClickStream(13929) statSessionId:%s", new Object[] { this.mEw });
    com.tencent.mm.plugin.report.service.g.yhR.f(13929, new Object[] { this.mEw, "", Integer.valueOf(1), Integer.valueOf(this.scene) });
    paramBundle = new Intent();
    paramBundle.putExtra("key_session_id", this.mEw);
    paramBundle.putExtra("ftsbizscene", this.scene);
    setResult(-1, paramBundle);
    if (getIntent().getBooleanExtra("key_alpha_in", false)) {
      overridePendingTransition(2130771981, 2130771986);
    }
    AppMethodBeat.o(21134);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21141);
    if ((this.scene == 3) || (this.scene == 16)) {
      com.tencent.mm.plugin.report.service.g.yhR.f(13929, new Object[] { this.mEw, com.tencent.mm.modelappbrand.b.hKo, Integer.valueOf(2), Integer.valueOf(this.scene) });
    }
    super.onDestroy();
    AppMethodBeat.o(21141);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandSearchUI
 * JD-Core Version:    0.7.0.1
 */