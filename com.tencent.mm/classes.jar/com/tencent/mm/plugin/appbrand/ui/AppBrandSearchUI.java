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
import com.tencent.mm.by.c;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.compatible.util.n;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.appbrand.ag;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.webview.d.h.63;
import com.tencent.mm.plugin.webview.d.n.a;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSearchTabWebViewUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.c;
import com.tencent.mm.ui.search.WebSearchView;
import com.tencent.mm.ui.search.a.c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppBrandSearchUI
  extends FTSSearchTabWebViewUI
{
  private View qYa;
  private String qYb;
  private String qYc;
  private int scene;
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.c paramc)
  {
    AppMethodBeat.i(163181);
    if ((!TextUtils.isEmpty(paramString2)) && (this.qYa != null)) {
      this.qYa.setVisibility(8);
    }
    if (this.pGC == null) {
      Log.i("MicroMsg.AppBrandSearchUI", "invoker is null");
    }
    for (;;)
    {
      super.a(paramString1, paramString2, paramList, paramc);
      AppMethodBeat.o(163181);
      return;
      try
      {
        this.pGC.l(10001, null);
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MicroMsg.AppBrandSearchUI", "refresh keyword id error : %s", new Object[] { localRemoteException });
      }
    }
  }
  
  public final boolean aDV()
  {
    AppMethodBeat.i(21142);
    this.qYa.setVisibility(8);
    boolean bool = super.aDV();
    AppMethodBeat.o(21142);
    return bool;
  }
  
  public final void cjK()
  {
    AppMethodBeat.i(21138);
    super.cjK();
    if ((hak() != null) && (!Util.isNullOrNil(this.query)))
    {
      hak().getFtsEditText().O(this.query, null);
      hak().getFtsEditText().bGw.clearFocus();
      hideVKB();
    }
    AppMethodBeat.o(21138);
  }
  
  public final int cjL()
  {
    AppMethodBeat.i(21140);
    if ((Build.VERSION.SDK_INT >= 23) && ((!g.isMIUI()) || (!AppBrandNearbyWebViewUI.isMIUIV8())))
    {
      ar.d(getWindow(), true);
      AppMethodBeat.o(21140);
      return -855310;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      i = ag.nym;
      AppMethodBeat.o(21140);
      return i;
    }
    int i = super.cjL();
    AppMethodBeat.o(21140);
    return i;
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(21144);
    super.dealContentView(paramView);
    this.qYb = getIntent().getStringExtra("key_nearby_url");
    getIntent().getStringExtra("key_nearby_list_id");
    this.qYa = getLayoutInflater().inflate(au.g.app_brand_search_ui_recommend_page, (ViewGroup)paramView, false);
    View localView1 = this.qYa.findViewById(au.f.nearbyV);
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(21132);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/appbrand/ui/AppBrandSearchUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
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
        c.b(paramAnonymousView.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
        a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandSearchUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(21132);
      }
    });
    if (TextUtils.isEmpty(this.qYb))
    {
      localView1.setVisibility(8);
      this.qYa.setVisibility(8);
    }
    while ((paramView instanceof FrameLayout))
    {
      ((FrameLayout)paramView).addView(this.qYa);
      AppMethodBeat.o(21144);
      return;
      localView1.setVisibility(0);
      this.qYa.setVisibility(0);
    }
    paramView = paramView.getLayoutParams();
    int k;
    Rect localRect;
    int i;
    if (getWindow().hasFeature(9))
    {
      localView1 = this.qYa;
      k = this.qYa.getPaddingLeft();
      localRect = new Rect();
      int j = getActionBarHeight();
      View localView2 = getWindow().getDecorView();
      localView2.getWindowVisibleDisplayFrame(localRect);
      int m = localView2.getHeight();
      int[] arrayOfInt = new int[2];
      localView2.getLocationOnScreen(arrayOfInt);
      i = j;
      if (m == 0) {
        i = j + n.F(getContext(), 0);
      }
      if ((m - localRect.height() < 0) || (arrayOfInt[1] <= 200)) {
        break label323;
      }
      i += m - localRect.height();
    }
    for (;;)
    {
      localView1.setPadding(k, i + this.qYa.getPaddingTop(), this.qYa.getPaddingRight(), this.qYa.getPaddingBottom());
      addContentView(this.qYa, paramView);
      AppMethodBeat.o(21144);
      return;
      label323:
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
  
  public final void o(final int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(21146);
    super.o(paramInt, paramBundle);
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
      btS().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(21133);
          if (AppBrandSearchUI.this.PvJ != null)
          {
            com.tencent.mm.plugin.webview.d.h localh = AppBrandSearchUI.this.PvJ;
            String str = str;
            int i = paramInt;
            int j = i;
            int k = j;
            if (!localh.NoX)
            {
              Log.e("MicroMsg.JsApiHandler", "onSearchGuideDataReady fail, not ready");
              AppMethodBeat.o(21133);
              return;
            }
            Log.i("MicroMsg.JsApiHandler", "onSearchGuideDataReady success, ready");
            HashMap localHashMap = new HashMap();
            localHashMap.put("json", str);
            localHashMap.put("isCacheData", Integer.valueOf(i));
            localHashMap.put("isExpired", Integer.valueOf(j));
            localHashMap.put("isPreload", Integer.valueOf(k));
            MMHandlerThread.postToMainThread(new h.63(localh, n.a.b("onSearchGuideDataReady", localHashMap, localh.PNx, localh.EVx)));
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
    ai.ani(ai.anh(3));
    this.qYc = getIntent().getStringExtra("key_session_id");
    this.scene = getIntent().getIntExtra("ftsbizscene", 0);
    Log.i("MicroMsg.AppBrandSearchUI", "onCreate oreh report weAppSearchClickStream(13929) statSessionId:%s", new Object[] { this.qYc });
    com.tencent.mm.plugin.report.service.h.IzE.a(13929, new Object[] { this.qYc, "", Integer.valueOf(1), Integer.valueOf(this.scene) });
    paramBundle = new Intent();
    paramBundle.putExtra("key_session_id", this.qYc);
    paramBundle.putExtra("ftsbizscene", this.scene);
    setResult(-1, paramBundle);
    AppMethodBeat.o(21134);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21141);
    if ((this.scene == 3) || (this.scene == 16)) {
      com.tencent.mm.plugin.report.service.h.IzE.a(13929, new Object[] { this.qYc, com.tencent.mm.modelappbrand.b.lyp, Integer.valueOf(2), Integer.valueOf(this.scene) });
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