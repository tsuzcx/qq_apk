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
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.compatible.util.n;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.appbrand.ac;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSearchTabWebViewUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.WebSearchView;
import com.tencent.mm.ui.search.a.c;
import java.util.List;

public class AppBrandSearchUI
  extends FTSSearchTabWebViewUI
{
  private String nWA;
  private View nWy;
  private String nWz;
  private int scene;
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(163181);
    if ((!TextUtils.isEmpty(paramString2)) && (this.nWy != null)) {
      this.nWy.setVisibility(8);
    }
    if (this.mHh == null) {
      Log.i("MicroMsg.AppBrandSearchUI", "invoker is null");
    }
    for (;;)
    {
      super.a(paramString1, paramString2, paramList, paramb);
      AppMethodBeat.o(163181);
      return;
      try
      {
        this.mHh.j(10001, null);
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MicroMsg.AppBrandSearchUI", "refresh keyword id error : %s", new Object[] { localRemoteException });
      }
    }
  }
  
  public final boolean awE()
  {
    AppMethodBeat.i(21142);
    this.nWy.setVisibility(8);
    boolean bool = super.awE();
    AppMethodBeat.o(21142);
    return bool;
  }
  
  public final void bXg()
  {
    AppMethodBeat.i(21138);
    super.bXg();
    if ((this.JnL != null) && (!Util.isNullOrNil(this.query)))
    {
      this.JnL.getFtsEditText().O(this.query, null);
      this.JnL.getFtsEditText().vy.clearFocus();
      hideVKB();
    }
    AppMethodBeat.o(21138);
  }
  
  public final int bXh()
  {
    AppMethodBeat.i(21140);
    if ((Build.VERSION.SDK_INT >= 23) && ((!g.isMIUI()) || (!AppBrandNearbyWebViewUI.isMIUIV8())))
    {
      ao.d(getWindow(), true);
      AppMethodBeat.o(21140);
      return -855310;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      i = ac.kEM;
      AppMethodBeat.o(21140);
      return i;
    }
    int i = super.bXh();
    AppMethodBeat.o(21140);
    return i;
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(21144);
    super.dealContentView(paramView);
    this.nWz = getIntent().getStringExtra("key_nearby_url");
    getIntent().getStringExtra("key_nearby_list_id");
    this.nWy = getLayoutInflater().inflate(2131493092, (ViewGroup)paramView, false);
    View localView1 = this.nWy.findViewById(2131305236);
    localView1.setOnClickListener(new AppBrandSearchUI.1(this));
    if (TextUtils.isEmpty(this.nWz))
    {
      localView1.setVisibility(8);
      this.nWy.setVisibility(8);
    }
    while ((paramView instanceof FrameLayout))
    {
      ((FrameLayout)paramView).addView(this.nWy);
      AppMethodBeat.o(21144);
      return;
      localView1.setVisibility(0);
      this.nWy.setVisibility(0);
    }
    paramView = paramView.getLayoutParams();
    int k;
    Rect localRect;
    int i;
    if (getWindow().hasFeature(9))
    {
      localView1 = this.nWy;
      k = this.nWy.getPaddingLeft();
      localRect = new Rect();
      int j = getActionBarHeight();
      View localView2 = getWindow().getDecorView();
      localView2.getWindowVisibleDisplayFrame(localRect);
      int m = localView2.getHeight();
      int[] arrayOfInt = new int[2];
      localView2.getLocationOnScreen(arrayOfInt);
      i = j;
      if (m == 0) {
        i = j + n.D(getContext(), 0);
      }
      if ((m - localRect.height() < 0) || (arrayOfInt[1] <= 200)) {
        break label321;
      }
      i += m - localRect.height();
    }
    for (;;)
    {
      localView1.setPadding(k, i + this.nWy.getPaddingTop(), this.nWy.getPaddingRight(), this.nWy.getPaddingBottom());
      addContentView(this.nWy, paramView);
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
  
  public final void m(int paramInt, Bundle paramBundle)
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
      String str = paramBundle.getString("fts_key_json_data");
      paramInt = paramBundle.getInt("fts_key_is_cache_data", 0);
      int i = paramBundle.getInt("fts_key_is_expired", 1);
      int j = paramBundle.getInt("fts_key_is_preload", 0);
      this.handler.post(new AppBrandSearchUI.2(this, str, paramInt, i, j));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(21134);
    super.onCreate(paramBundle);
    ai.afu(ai.aft(3));
    this.nWA = getIntent().getStringExtra("key_session_id");
    this.scene = getIntent().getIntExtra("ftsbizscene", 0);
    Log.i("MicroMsg.AppBrandSearchUI", "onCreate oreh report weAppSearchClickStream(13929) statSessionId:%s", new Object[] { this.nWA });
    h.CyF.a(13929, new Object[] { this.nWA, "", Integer.valueOf(1), Integer.valueOf(this.scene) });
    paramBundle = new Intent();
    paramBundle.putExtra("key_session_id", this.nWA);
    paramBundle.putExtra("ftsbizscene", this.scene);
    setResult(-1, paramBundle);
    AppMethodBeat.o(21134);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21141);
    if ((this.scene == 3) || (this.scene == 16)) {
      h.CyF.a(13929, new Object[] { this.nWA, b.iIn, Integer.valueOf(2), Integer.valueOf(this.scene) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandSearchUI
 * JD-Core Version:    0.7.0.1
 */