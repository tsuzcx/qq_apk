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
import com.tencent.mm.br.d;
import com.tencent.mm.compatible.util.n;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.appbrand.ab;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.f.57;
import com.tencent.mm.plugin.webview.c.l.a;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSearchTabWebViewUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
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
  private String mJA;
  private String mJB;
  private View mJz;
  private int scene;
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(163181);
    if ((!TextUtils.isEmpty(paramString2)) && (this.mJz != null)) {
      this.mJz.setVisibility(8);
    }
    if (this.lzT == null) {
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
        this.lzT.k(10001, null);
      }
      catch (RemoteException localRemoteException)
      {
        ae.e("MicroMsg.AppBrandSearchUI", "refresh keyword id error : %s", new Object[] { localRemoteException });
      }
    }
  }
  
  public final void bAi()
  {
    AppMethodBeat.i(21138);
    super.bAi();
    if ((this.EyL != null) && (!bu.isNullOrNil(this.query)))
    {
      this.EyL.getFtsEditText().I(this.query, null);
      this.EyL.getFtsEditText().vr.clearFocus();
      hideVKB();
    }
    AppMethodBeat.o(21138);
  }
  
  public final int bAj()
  {
    AppMethodBeat.i(21140);
    if ((Build.VERSION.SDK_INT >= 23) && ((!com.tencent.mm.compatible.util.g.abt()) || (!AppBrandNearbyWebViewUI.abu())))
    {
      al.d(getWindow());
      AppMethodBeat.o(21140);
      return -855310;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      i = ab.jDE;
      AppMethodBeat.o(21140);
      return i;
    }
    int i = super.bAj();
    AppMethodBeat.o(21140);
    return i;
  }
  
  public final boolean bAu()
  {
    AppMethodBeat.i(21142);
    this.mJz.setVisibility(8);
    boolean bool = super.bAu();
    AppMethodBeat.o(21142);
    return bool;
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(21144);
    super.dealContentView(paramView);
    this.mJA = getIntent().getStringExtra("key_nearby_url");
    getIntent().getStringExtra("key_nearby_list_id");
    this.mJz = getLayoutInflater().inflate(2131493053, (ViewGroup)paramView, false);
    View localView1 = this.mJz.findViewById(2131302682);
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(21132);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandSearchUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
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
    if (TextUtils.isEmpty(this.mJA))
    {
      localView1.setVisibility(8);
      this.mJz.setVisibility(8);
    }
    while ((paramView instanceof FrameLayout))
    {
      ((FrameLayout)paramView).addView(this.mJz);
      AppMethodBeat.o(21144);
      return;
      localView1.setVisibility(0);
      this.mJz.setVisibility(0);
    }
    paramView = paramView.getLayoutParams();
    int k;
    Rect localRect;
    int i;
    if (getWindow().hasFeature(9))
    {
      localView1 = this.mJz;
      k = this.mJz.getPaddingLeft();
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
      localView1.setPadding(k, i + this.mJz.getPaddingTop(), this.mJz.getPaddingRight(), this.mJz.getPaddingBottom());
      addContentView(this.mJz, paramView);
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
          if (AppBrandSearchUI.this.DRx != null)
          {
            f localf = AppBrandSearchUI.this.DRx;
            String str = str;
            int i = paramInt;
            int j = i;
            int k = j;
            if (!localf.BZx)
            {
              ae.e("MicroMsg.JsApiHandler", "onSearchGuideDataReady fail, not ready");
              AppMethodBeat.o(21133);
              return;
            }
            ae.i("MicroMsg.JsApiHandler", "onSearchGuideDataReady success, ready");
            HashMap localHashMap = new HashMap();
            localHashMap.put("json", str);
            localHashMap.put("isCacheData", Integer.valueOf(i));
            localHashMap.put("isExpired", Integer.valueOf(j));
            localHashMap.put("isPreload", Integer.valueOf(k));
            ar.f(new f.57(localf, l.a.b("onSearchGuideDataReady", localHashMap, localf.EeC, localf.vVT)));
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
    ad.WM(ad.WL(3));
    this.mJB = getIntent().getStringExtra("key_session_id");
    this.scene = getIntent().getIntExtra("ftsbizscene", 0);
    ae.i("MicroMsg.AppBrandSearchUI", "onCreate oreh report weAppSearchClickStream(13929) statSessionId:%s", new Object[] { this.mJB });
    com.tencent.mm.plugin.report.service.g.yxI.f(13929, new Object[] { this.mJB, "", Integer.valueOf(1), Integer.valueOf(this.scene) });
    paramBundle = new Intent();
    paramBundle.putExtra("key_session_id", this.mJB);
    paramBundle.putExtra("ftsbizscene", this.scene);
    setResult(-1, paramBundle);
    AppMethodBeat.o(21134);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21141);
    if ((this.scene == 3) || (this.scene == 16)) {
      com.tencent.mm.plugin.report.service.g.yxI.f(13929, new Object[] { this.mJB, com.tencent.mm.modelappbrand.b.hNh, Integer.valueOf(2), Integer.valueOf(this.scene) });
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