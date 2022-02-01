package com.tencent.liteapp.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.tencent.liteapp.d.b.c;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ext.ui.SwipeBackActivity;
import com.tencent.mm.ext.ui.SwipeBackLayout;
import com.tencent.mm.ext.ui.e;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.mm.plugin.lite.LiteAppCenter.ILiteAppUICallback;
import com.tencent.mm.plugin.lite.LiteAppCenter.PageInfo;
import com.tencent.wxa.c;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public class WxaLiteAppUI
  extends WxaLiteAppBaseUI
  implements a, LiteAppCenter.ILiteAppUICallback
{
  int FV;
  public String appId;
  long appPtr;
  private com.tencent.liteapp.d.b crA;
  private final b.c crB;
  boolean crr;
  int crs;
  int crt;
  boolean cru;
  boolean crv;
  long crw;
  int crx;
  int cry;
  LiteAppCenter.PageInfo crz;
  FrameLayout mContentView;
  long pageId;
  
  public WxaLiteAppUI()
  {
    AppMethodBeat.i(197757);
    this.crr = true;
    this.FV = -1;
    this.crs = -1;
    this.crt = -1;
    this.cru = false;
    this.crv = false;
    this.appId = "";
    this.appPtr = -1L;
    this.pageId = -1L;
    this.crw = -1L;
    this.crx = -1;
    this.cry = -1;
    this.crB = new WxaLiteAppUI.1(this);
    AppMethodBeat.o(197757);
  }
  
  private void hE(int paramInt)
  {
    AppMethodBeat.i(197773);
    this.FV = paramInt;
    this.cru = false;
    if (this.crs > 0)
    {
      getWindow().clearFlags(this.crs);
      this.crs = -1;
    }
    int i = 1792;
    if (paramInt == 5)
    {
      i = 5892;
      if (!this.crv) {
        break label111;
      }
    }
    label111:
    for (paramInt = i & 0xFFFFDFEF;; paramInt = i | 0x2010)
    {
      if ((getWindow() != null) && (getWindow().getDecorView() != null)) {
        getWindow().getDecorView().setSystemUiVisibility(paramInt);
      }
      AppMethodBeat.o(197773);
      return;
      if (paramInt != 7) {
        break;
      }
      i = 5894;
      break;
    }
  }
  
  public final void KC()
  {
    AppMethodBeat.i(197775);
    hE(this.crt);
    AppMethodBeat.o(197775);
  }
  
  public final void KD()
  {
    AppMethodBeat.i(197774);
    this.crt = this.FV;
    hE(7);
    AppMethodBeat.o(197774);
  }
  
  protected final View KE()
  {
    AppMethodBeat.i(197761);
    com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "initView", new Object[0]);
    Object localObject = super.KE();
    this.mContentView = new com.tencent.liteapp.d.a(this, (View)localObject);
    this.mContentView.addView((View)localObject, 0, new ViewGroup.LayoutParams(-1, -1));
    localObject = this.mContentView;
    AppMethodBeat.o(197761);
    return localObject;
  }
  
  public final String KQ()
  {
    AppMethodBeat.i(197776);
    com.tencent.liteapp.b.b.d("WxaLiteApp.WxaLiteAppUI", "getFlutterViewId %s", new Object[] { Long.valueOf(this.crw) });
    long l = this.crw;
    AppMethodBeat.o(197776);
    return String.valueOf(l);
  }
  
  public final String KR()
  {
    AppMethodBeat.i(197777);
    long l = this.pageId;
    AppMethodBeat.o(197777);
    return String.valueOf(l);
  }
  
  public final Map KS()
  {
    AppMethodBeat.i(197778);
    if (this.crz != null)
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("activityId", Long.valueOf(this.crz.appUuid));
      ((HashMap)localObject).put("appId", this.cro.appId);
      ((HashMap)localObject).put("appPtr", Long.valueOf(this.crz.appPtr));
      ((HashMap)localObject).put("pageViewId", Long.valueOf(this.crz.pageId));
      ((HashMap)localObject).put("basePath", this.crz.basePath);
      ((HashMap)localObject).put("pageRenderPtr", Long.valueOf(this.crz.renderId));
      ((HashMap)localObject).put("flags", Integer.valueOf(this.crz.flags));
      ((HashMap)localObject).put("startTime", Long.valueOf(System.currentTimeMillis()));
      AppMethodBeat.o(197778);
      return localObject;
    }
    Object localObject = super.KS();
    AppMethodBeat.o(197778);
    return localObject;
  }
  
  public void finish()
  {
    AppMethodBeat.i(197760);
    super.finish();
    if (this.cry >= 0) {
      overridePendingTransition(2130771986, this.cry);
    }
    AppMethodBeat.o(197760);
  }
  
  public final void hD(int paramInt)
  {
    AppMethodBeat.i(197771);
    com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "inputLocationChange %d", new Object[] { Integer.valueOf(paramInt) });
    this.mContentView.scrollTo(this.mContentView.getScrollX(), paramInt);
    AppMethodBeat.o(197771);
  }
  
  public boolean hasCutOut()
  {
    AppMethodBeat.i(197768);
    boolean bool = e.aQ(this);
    AppMethodBeat.o(197768);
    return bool;
  }
  
  public final void hideKeyboard()
  {
    AppMethodBeat.i(197772);
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mContentView.getWindowToken(), 0);
    AppMethodBeat.o(197772);
  }
  
  public boolean isDarkMode()
  {
    AppMethodBeat.i(197779);
    boolean bool = e.f(getResources());
    AppMethodBeat.o(197779);
    return bool;
  }
  
  public void navigateBack()
  {
    AppMethodBeat.i(197770);
    new Handler(getMainLooper()).post(new WxaLiteAppUI.5(this));
    AppMethodBeat.o(197770);
  }
  
  public void onCheckSumFail(String paramString, List<String> paramList) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(197758);
    super.onConfigurationChanged(paramConfiguration);
    boolean bool = isDarkMode();
    if (bool != this.crv)
    {
      com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "DarkMode change %b", new Object[] { Boolean.valueOf(bool) });
      this.crv = bool;
      LiteAppCenter.updateDarkMode(this.crv);
    }
    AppMethodBeat.o(197758);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(197759);
    if (getIntent().hasExtra("bundle"))
    {
      localObject = getIntent().getBundleExtra("bundle");
      if ((localObject != null) && ((((Bundle)localObject).containsKey("nextAnimIn")) || (((Bundle)localObject).containsKey("currentAnimOut"))))
      {
        this.crx = ((Bundle)localObject).getInt("nextAnimIn", 0);
        this.cry = ((Bundle)localObject).getInt("currentAnimOut", 0);
        overridePendingTransition(this.crx, 2130771986);
      }
      if (((Bundle)localObject).containsKey("transparent")) {
        this.crp = ((Bundle)localObject).getBoolean("transparent", false);
      }
    }
    c.hrH().init();
    this.crv = isDarkMode();
    LiteAppCenter.updateDarkMode(this.crv);
    Object localObject = getIntent().getStringExtra("query");
    String str = getIntent().getStringExtra("page");
    KT();
    long l;
    if (this.cro != null)
    {
      this.appId = this.cro.appId;
      com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "Use WxaLiteAppInfo", new Object[0]);
      com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "Use WxaLiteAppInfo start showIndexView", new Object[0]);
      l = System.currentTimeMillis();
      if (!TextUtils.isEmpty(str)) {
        break label877;
      }
      this.crz = LiteAppCenter.showIndexView(this.cro.appId, this.cro.path, this.cro.crh, (String)localObject);
    }
    for (;;)
    {
      com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "Use WxaLiteAppInfo end showIndexView use %d", new Object[] { Long.valueOf(System.currentTimeMillis() - Long.valueOf(l).longValue()) });
      label345:
      int j;
      int i;
      if (this.crz != null)
      {
        this.appPtr = this.crz.appPtr;
        this.pageId = this.crz.pageId;
        this.crw = this.crz.appUuid;
        com.tencent.liteapp.b.b.d("WxaLiteApp.WxaLiteAppUI", "Use WxaLiteAppInfo pageInfo %s", new Object[] { this.crz.toString() });
        localObject = KS();
        if (localObject != null)
        {
          if (((Map)localObject).containsKey("startTime"))
          {
            Long.valueOf(((Map)localObject).get("startTime").toString()).longValue();
            System.currentTimeMillis();
          }
          if (((Map)localObject).containsKey("appId")) {
            this.appId = String.valueOf(((Map)localObject).get("appId"));
          }
          if (((Map)localObject).containsKey("appPtr")) {
            this.appPtr = Long.valueOf(((Map)localObject).get("appPtr").toString()).longValue();
          }
          if (((Map)localObject).containsKey("pageViewId")) {
            this.pageId = Long.valueOf(((Map)localObject).get("pageViewId").toString()).longValue();
          }
          if (((Map)localObject).containsKey("activityId")) {
            this.crw = Long.valueOf(((Map)localObject).get("activityId").toString()).longValue();
          }
        }
        super.onCreate(paramBundle);
        if (localObject != null)
        {
          j = -1;
          i = j;
          if (!((Map)localObject).containsKey("flags")) {}
        }
      }
      try
      {
        i = Integer.parseInt(((Map)localObject).get("flags").toString());
        this.FV = i;
        getWindow().clearFlags(67108864);
        getWindow().addFlags(-2147483648);
        getWindow().setStatusBarColor(getResources().getColor(2131101286));
        getWindow().clearFlags(201326592);
        getWindow().setNavigationBarColor(getResources().getColor(2131101286));
        getWindow().setFlags(16777216, 16777216);
        if (Build.VERSION.SDK_INT > 28) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            getWindow().getAttributes().layoutInDisplayCutoutMode = 1;
          }
          this.mContentView.getViewTreeObserver().addOnGlobalLayoutListener(new WxaLiteAppUI.2(this));
          this.crA = com.tencent.liteapp.d.a.bX(this.mContentView);
          paramBundle = this.crA;
          localObject = this.crB;
          if ((localObject != null) && (!paramBundle.crY.contains(localObject))) {
            paramBundle.crY.add(localObject);
          }
          setRequestedOrientation(1);
          paramBundle = (ViewGroup)getWindow().getDecorView();
          this.hfl = ((SwipeBackLayout)LayoutInflater.from(this).inflate(2131497118, paramBundle, false));
          this.hfl.init();
          getWindow().setBackgroundDrawable(new ColorDrawable(0));
          getWindow().getDecorView().setBackgroundDrawable(null);
          localObject = paramBundle.getChildAt(0);
          ((View)localObject).setBackgroundResource(17170445);
          paramBundle.removeView((View)localObject);
          this.hfl.addView((View)localObject);
          this.hfl.setContentView((View)localObject);
          paramBundle.addView(this.hfl);
          this.hfl.setSwipeGestureDelegate(this);
          AppMethodBeat.o(197759);
          return;
          label877:
          this.crz = LiteAppCenter.showView(this.cro.appId, str, (String)localObject, this.cro.path, this.cro.crh);
          break;
          com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "Use WxaLiteAppInfo fail, pageInfo is null.", new Object[0]);
          break label345;
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          i = j;
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(197766);
    if (this.crA != null)
    {
      com.tencent.liteapp.d.b localb = this.crA;
      b.c localc = this.crB;
      if (localc != null) {
        localb.crY.remove(localc);
      }
    }
    super.onDestroy();
    LiteAppCenter.unsetUICallback(this.appPtr, this);
    AppMethodBeat.o(197766);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(197765);
    super.onPause();
    AppMethodBeat.o(197765);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(197763);
    super.onResume();
    AppMethodBeat.o(197763);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(197762);
    super.onStart();
    LiteAppCenter.setUICallback(this.appPtr, this);
    AppMethodBeat.o(197762);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(197764);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      hE(this.FV);
    }
    AppMethodBeat.o(197764);
  }
  
  public void setFlags(final int paramInt)
  {
    AppMethodBeat.i(197767);
    com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "setFlags %d old=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.FV) });
    if (this.FV == paramInt)
    {
      AppMethodBeat.o(197767);
      return;
    }
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(197754);
        WxaLiteAppUI.a(WxaLiteAppUI.this, paramInt);
        AppMethodBeat.o(197754);
      }
    });
    AppMethodBeat.o(197767);
  }
  
  public void showPage(final LiteAppCenter.PageInfo paramPageInfo)
  {
    AppMethodBeat.i(197769);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(197755);
        WxaLiteAppUI.this.setFlags(paramPageInfo.flags);
        AppMethodBeat.o(197755);
      }
    });
    AppMethodBeat.o(197769);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.liteapp.ui.WxaLiteAppUI
 * JD-Core Version:    0.7.0.1
 */