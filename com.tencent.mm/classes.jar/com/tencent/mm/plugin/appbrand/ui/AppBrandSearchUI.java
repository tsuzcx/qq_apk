package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
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
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.appbrand.ab;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSearchTabWebViewUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.a;
import com.tencent.mm.ui.search.a.a;
import com.tencent.mm.ui.search.a.c;
import java.lang.reflect.Field;
import java.util.List;
import junit.framework.Assert;

public class AppBrandSearchUI
  extends FTSSearchTabWebViewUI
  implements a.a
{
  private View lCf;
  private String lCg;
  private String lCh;
  private int lCj;
  private int scene;
  
  private int box()
  {
    int i = 0;
    AppMethodBeat.i(21145);
    try
    {
      Class localClass = Class.forName("com.android.internal.R$dimen");
      Object localObject = localClass.newInstance();
      int j = bt.getInt(localClass.getField("status_bar_height").get(localObject).toString(), 0);
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
  
  private void boy()
  {
    AppMethodBeat.i(21138);
    if (this.rtD != null)
    {
      ImageButton localImageButton = this.rtD.getFtsEditText().getClearBtn();
      if (localImageButton != null) {
        localImageButton.getDrawable().setColorFilter(getResources().getColor(2131099732), PorterDuff.Mode.SRC_ATOP);
      }
      t.b(this);
      this.rtD.setImageSearchListener(this);
      if (!bt.isNullOrNil(this.query))
      {
        this.rtD.getFtsEditText().J(this.query, null);
        this.rtD.getFtsEditText().sz.clearFocus();
        hideVKB();
      }
    }
    AppMethodBeat.o(21138);
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    int i = 8;
    AppMethodBeat.i(163181);
    if ((!TextUtils.isEmpty(paramString2)) && (this.lCf != null)) {
      this.lCf.setVisibility(8);
    }
    Object localObject;
    boolean bool;
    if ((this.lCj == 1) && (this.rtD != null))
    {
      localObject = this.rtD;
      bool = TextUtils.isEmpty(paramString1);
      if (((a)localObject).Hlh == null) {
        ad.i("MicroMsg.FTS.FTSSearchView", "showImageSearchButton imageSearchBtn is null");
      }
    }
    else
    {
      if (this.kxf != null) {
        break label140;
      }
      if ((!isFinishing()) && (!isDestroyed())) {
        Assert.fail("invoker is NULL");
      }
    }
    for (;;)
    {
      super.a(paramString1, paramString2, paramList, paramb);
      AppMethodBeat.o(163181);
      return;
      localObject = ((a)localObject).Hlh;
      if (bool) {
        i = 0;
      }
      ((View)localObject).setVisibility(i);
      break;
      try
      {
        label140:
        this.kxf.j(10001, null);
      }
      catch (RemoteException localRemoteException)
      {
        ad.e("MicroMsg.AppBrandSearchUI", "refresh keyword id error : %s", new Object[] { localRemoteException });
      }
    }
  }
  
  public final void bol()
  {
    AppMethodBeat.i(21137);
    super.bol();
    boy();
    AppMethodBeat.o(21137);
  }
  
  public final int bom()
  {
    AppMethodBeat.i(21140);
    if ((Build.VERSION.SDK_INT >= 23) && ((!com.tencent.mm.compatible.util.g.XL()) || (!AppBrandNearbyWebViewUI.XM())))
    {
      ai.d(getWindow());
      AppMethodBeat.o(21140);
      return -855310;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      i = ab.iHI;
      AppMethodBeat.o(21140);
      return i;
    }
    int i = super.bom();
    AppMethodBeat.o(21140);
    return i;
  }
  
  public final boolean bow()
  {
    AppMethodBeat.i(21142);
    this.lCf.setVisibility(8);
    boolean bool = super.bow();
    AppMethodBeat.o(21142);
    return bool;
  }
  
  public final a dG(Context paramContext)
  {
    AppMethodBeat.i(163180);
    this.lCj = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.ppr, 0);
    this.lCj = 0;
    if (this.lCj == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramContext = new a(paramContext, bool);
      AppMethodBeat.o(163180);
      return paramContext;
    }
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(21144);
    super.dealContentView(paramView);
    this.lCg = getIntent().getStringExtra("key_nearby_url");
    getIntent().getStringExtra("key_nearby_list_id");
    this.lCf = getLayoutInflater().inflate(2131493053, (ViewGroup)paramView, false);
    View localView1 = this.lCf.findViewById(2131302682);
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
    if (TextUtils.isEmpty(this.lCg))
    {
      localView1.setVisibility(8);
      this.lCf.setVisibility(8);
    }
    while ((paramView instanceof FrameLayout))
    {
      ((FrameLayout)paramView).addView(this.lCf);
      AppMethodBeat.o(21144);
      return;
      localView1.setVisibility(0);
      this.lCf.setVisibility(0);
    }
    paramView = paramView.getLayoutParams();
    int k;
    Rect localRect;
    int i;
    if (getWindow().hasFeature(9))
    {
      localView1 = this.lCf;
      k = this.lCf.getPaddingLeft();
      localRect = new Rect();
      int j = getActionBarHeight();
      View localView2 = getWindow().getDecorView();
      localView2.getWindowVisibleDisplayFrame(localRect);
      int m = localView2.getHeight();
      int[] arrayOfInt = new int[2];
      localView2.getLocationOnScreen(arrayOfInt);
      i = j;
      if (m == 0) {
        i = j + box();
      }
      if ((m - localRect.height() < 0) || (arrayOfInt[1] <= 200)) {
        break label321;
      }
      i += m - localRect.height();
    }
    for (;;)
    {
      localView1.setPadding(k, i + this.lCf.getPaddingTop(), this.lCf.getPaddingRight(), this.lCf.getPaddingBottom());
      addContentView(this.lCf, paramView);
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
  
  public void initView()
  {
    AppMethodBeat.i(21136);
    super.initView();
    setActionbarColor(-855310);
    boy();
    AppMethodBeat.o(21136);
  }
  
  public final void m(final int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(21146);
    super.m(paramInt, paramBundle);
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
          if (AppBrandSearchUI.this.AQP != null) {
            AppBrandSearchUI.this.AQP.q(str, paramInt, i, j);
          }
          AppMethodBeat.o(21133);
        }
      });
    }
  }
  
  public void onClickSearchButton(View paramView)
  {
    AppMethodBeat.i(21148);
    ad.i("MicroMsg.AppBrandSearchUI", "onClickSearchButton");
    paramView = new AppBrandStatObject();
    paramView.scene = 1132;
    ((n)com.tencent.mm.kernel.g.ab(n.class)).a(getContext(), "gh_6a9e987117da@app", null, 0, 0, "Search/image/camera.html", paramView);
    AppMethodBeat.o(21148);
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
    aa.Sc(aa.Sb(3));
    this.lCh = getIntent().getStringExtra("key_session_id");
    this.scene = getIntent().getIntExtra("ftsbizscene", 0);
    ad.i("MicroMsg.AppBrandSearchUI", "onCreate oreh report weAppSearchClickStream(13929) statSessionId:%s", new Object[] { this.lCh });
    h.vKh.f(13929, new Object[] { this.lCh, "", Integer.valueOf(1), Integer.valueOf(this.scene) });
    paramBundle = new Intent();
    paramBundle.putExtra("key_session_id", this.lCh);
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
      h.vKh.f(13929, new Object[] { this.lCh, com.tencent.mm.modelappbrand.b.gRw, Integer.valueOf(2), Integer.valueOf(this.scene) });
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