package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
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
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.appbrand.ab;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.f.55;
import com.tencent.mm.plugin.webview.c.l.a;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSearchTabWebViewUI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.WebSearchView;
import com.tencent.mm.ui.search.a.c;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public class AppBrandSearchUI
  extends FTSSearchTabWebViewUI
{
  private View meb;
  private String mec;
  private String med;
  private int scene;
  
  private int bvt()
  {
    int i = 0;
    AppMethodBeat.i(21145);
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
    AppMethodBeat.o(21145);
    return i;
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(163181);
    if ((!TextUtils.isEmpty(paramString2)) && (this.meb != null)) {
      this.meb.setVisibility(8);
    }
    if (this.kYt == null) {
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
        this.kYt.k(10001, null);
      }
      catch (RemoteException localRemoteException)
      {
        ac.e("MicroMsg.AppBrandSearchUI", "refresh keyword id error : %s", new Object[] { localRemoteException });
      }
    }
  }
  
  public final void bvh()
  {
    AppMethodBeat.i(21138);
    super.bvh();
    if ((this.CCZ != null) && (!bs.isNullOrNil(this.query)))
    {
      this.CCZ.getFtsEditText().F(this.query, null);
      this.CCZ.getFtsEditText().ty.clearFocus();
      hideVKB();
    }
    AppMethodBeat.o(21138);
  }
  
  public final int bvi()
  {
    AppMethodBeat.i(21140);
    if ((Build.VERSION.SDK_INT >= 23) && ((!g.YI()) || (!AppBrandNearbyWebViewUI.YJ())))
    {
      aj.d(getWindow());
      AppMethodBeat.o(21140);
      return -855310;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      i = ab.jhK;
      AppMethodBeat.o(21140);
      return i;
    }
    int i = super.bvi();
    AppMethodBeat.o(21140);
    return i;
  }
  
  public final boolean bvs()
  {
    AppMethodBeat.i(21142);
    this.meb.setVisibility(8);
    boolean bool = super.bvs();
    AppMethodBeat.o(21142);
    return bool;
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(21144);
    super.dealContentView(paramView);
    this.mec = getIntent().getStringExtra("key_nearby_url");
    getIntent().getStringExtra("key_nearby_list_id");
    this.meb = getLayoutInflater().inflate(2131493053, (ViewGroup)paramView, false);
    View localView1 = this.meb.findViewById(2131302682);
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(21132);
        if (TextUtils.isEmpty(AppBrandSearchUI.a(AppBrandSearchUI.this)))
        {
          AppMethodBeat.o(21132);
          return;
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("showShare", false);
        localIntent.putExtra("rawUrl", AppBrandSearchUI.a(AppBrandSearchUI.this));
        localIntent.putExtra("geta8key_scene", 41);
        localIntent.putExtra("show_long_click_popup_menu", false);
        d.b(paramAnonymousView.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
        AppMethodBeat.o(21132);
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
      AppMethodBeat.o(21144);
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
      AppMethodBeat.o(21144);
      return;
      label317:
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
          if (AppBrandSearchUI.this.Cjc != null)
          {
            f localf = AppBrandSearchUI.this.Cjc;
            String str = str;
            int i = paramInt;
            int j = i;
            int k = j;
            if (!localf.Apr)
            {
              ac.e("MicroMsg.JsApiHandler", "onSearchGuideDataReady fail, not ready");
              AppMethodBeat.o(21133);
              return;
            }
            ac.i("MicroMsg.JsApiHandler", "onSearchGuideDataReady success, ready");
            HashMap localHashMap = new HashMap();
            localHashMap.put("json", str);
            localHashMap.put("isCacheData", Integer.valueOf(i));
            localHashMap.put("isExpired", Integer.valueOf(j));
            localHashMap.put("isPreload", Integer.valueOf(k));
            ap.f(new f.55(localf, l.a.b("onSearchGuideDataReady", localHashMap, localf.Cjz, localf.CjA)));
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
    z.Um(z.Ul(3));
    this.med = getIntent().getStringExtra("key_session_id");
    this.scene = getIntent().getIntExtra("ftsbizscene", 0);
    ac.i("MicroMsg.AppBrandSearchUI", "onCreate oreh report weAppSearchClickStream(13929) statSessionId:%s", new Object[] { this.med });
    h.wUl.f(13929, new Object[] { this.med, "", Integer.valueOf(1), Integer.valueOf(this.scene) });
    paramBundle = new Intent();
    paramBundle.putExtra("key_session_id", this.med);
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
      h.wUl.f(13929, new Object[] { this.med, b.hrW, Integer.valueOf(2), Integer.valueOf(this.scene) });
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