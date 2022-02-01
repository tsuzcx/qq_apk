package com.tencent.mm.plugin.appbrand.ui;

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
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.compatible.util.o;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.ak;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.webview.jsapi.j;
import com.tencent.mm.plugin.webview.jsapi.j.64;
import com.tencent.mm.plugin.webview.jsapi.p.a;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSearchTabWebViewUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.d;
import com.tencent.mm.ui.search.FTSSearchView.c;
import com.tencent.mm.ui.search.WebSearchView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppBrandSearchUI
  extends FTSSearchTabWebViewUI
{
  private int scene;
  private View uec;
  private String ued;
  private String uee;
  
  public final boolean aWU()
  {
    AppMethodBeat.i(21142);
    this.uec.setVisibility(8);
    boolean bool = super.aWU();
    AppMethodBeat.o(21142);
    return bool;
  }
  
  public final void cKX()
  {
    AppMethodBeat.i(21138);
    super.cKX();
    if ((iAq() != null) && (!Util.isNullOrNil(this.query)))
    {
      iAq().getFtsEditText().V(this.query, null);
      iAq().getFtsEditText().dzv.clearFocus();
      hideVKB();
    }
    AppMethodBeat.o(21138);
  }
  
  public final int cKY()
  {
    AppMethodBeat.i(21140);
    if ((Build.VERSION.SDK_INT >= 23) && ((!g.isMIUI()) || (!AppBrandNearbyWebViewUI.isMIUIV8())))
    {
      aw.c(getWindow(), true);
      AppMethodBeat.o(21140);
      return -855310;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      i = ak.qxA;
      AppMethodBeat.o(21140);
      return i;
    }
    int i = super.cKY();
    AppMethodBeat.o(21140);
    return i;
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(21144);
    super.dealContentView(paramView);
    this.ued = getIntent().getStringExtra("key_nearby_url");
    getIntent().getStringExtra("key_nearby_list_id");
    this.uec = getLayoutInflater().inflate(ba.g.app_brand_search_ui_recommend_page, (ViewGroup)paramView, false);
    View localView1 = this.uec.findViewById(ba.f.nearbyV);
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(21132);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/appbrand/ui/AppBrandSearchUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
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
        com.tencent.mm.br.c.b(paramAnonymousView.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
        a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandSearchUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(21132);
      }
    });
    if (TextUtils.isEmpty(this.ued))
    {
      localView1.setVisibility(8);
      this.uec.setVisibility(8);
    }
    while ((paramView instanceof FrameLayout))
    {
      ((FrameLayout)paramView).addView(this.uec);
      AppMethodBeat.o(21144);
      return;
      localView1.setVisibility(0);
      this.uec.setVisibility(0);
    }
    paramView = paramView.getLayoutParams();
    int k;
    Rect localRect;
    int i;
    if (getWindow().hasFeature(9))
    {
      localView1 = this.uec;
      k = this.uec.getPaddingLeft();
      localRect = new Rect();
      int j = getActionBarHeight();
      View localView2 = getWindow().getDecorView();
      localView2.getWindowVisibleDisplayFrame(localRect);
      int m = localView2.getHeight();
      int[] arrayOfInt = new int[2];
      localView2.getLocationOnScreen(arrayOfInt);
      i = j;
      if (m == 0) {
        i = j + o.I(getContext(), 0);
      }
      if ((m - localRect.height() < 0) || (arrayOfInt[1] <= 200)) {
        break label323;
      }
      i += m - localRect.height();
    }
    for (;;)
    {
      localView1.setPadding(k, i + this.uec.getPaddingTop(), this.uec.getPaddingRight(), this.uec.getPaddingBottom());
      addContentView(this.uec, paramView);
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
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(21134);
    super.onCreate(paramBundle);
    aj.asZ(aj.asY(3));
    this.uee = getIntent().getStringExtra("key_session_id");
    this.scene = getIntent().getIntExtra("ftsbizscene", 0);
    Log.i("MicroMsg.AppBrandSearchUI", "onCreate oreh report weAppSearchClickStream(13929) statSessionId:%s", new Object[] { this.uee });
    h.OAn.b(13929, new Object[] { this.uee, "", Integer.valueOf(1), Integer.valueOf(this.scene) });
    paramBundle = new Intent();
    paramBundle.putExtra("key_session_id", this.uee);
    paramBundle.putExtra("ftsbizscene", this.scene);
    setResult(-1, paramBundle);
    AppMethodBeat.o(21134);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21141);
    if ((this.scene == 3) || (this.scene == 16)) {
      h.OAn.b(13929, new Object[] { this.uee, com.tencent.mm.modelappbrand.c.opQ, Integer.valueOf(2), Integer.valueOf(this.scene) });
    }
    super.onDestroy();
    AppMethodBeat.o(21141);
  }
  
  public void onEditTextChange(String paramString1, String paramString2, List<FTSSearchView.c> paramList, FTSEditTextView.d paramd)
  {
    AppMethodBeat.i(163181);
    if ((!TextUtils.isEmpty(paramString2)) && (this.uec != null)) {
      this.uec.setVisibility(8);
    }
    if (this.sLC == null) {
      Log.i("MicroMsg.AppBrandSearchUI", "invoker is null");
    }
    for (;;)
    {
      super.onEditTextChange(paramString1, paramString2, paramList, paramd);
      AppMethodBeat.o(163181);
      return;
      try
      {
        this.sLC.m(10001, null);
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MicroMsg.AppBrandSearchUI", "refresh keyword id error : %s", new Object[] { localRemoteException });
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void q(final int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(21146);
    super.q(paramInt, paramBundle);
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
      getHandler().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(21133);
          if (AppBrandSearchUI.this.WlX != null)
          {
            j localj = AppBrandSearchUI.this.WlX;
            String str = str;
            int i = paramInt;
            int j = i;
            int k = j;
            if (!localj.UcS)
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
            MMHandlerThread.postToMainThread(new j.64(localj, p.a.b("onSearchGuideDataReady", localHashMap, localj.WDI, localj.KQY)));
          }
          AppMethodBeat.o(21133);
        }
      });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandSearchUI
 * JD-Core Version:    0.7.0.1
 */