package com.tencent.liteapp.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.tencent.liteapp.a.a;
import com.tencent.liteapp.a.b;
import com.tencent.liteapp.a.d;
import com.tencent.liteapp.a.e;
import com.tencent.liteapp.a.f;
import com.tencent.liteapp.d.b.b;
import com.tencent.liteapp.d.f;
import com.tencent.liteapp.report.WxaLiteAppStartReport;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ext.ui.e;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.mm.plugin.lite.LiteAppCenter.ILiteAppUICallback;
import com.tencent.mm.plugin.lite.LiteAppCenter.IWxaLiteAppCallback;
import com.tencent.mm.plugin.lite.LiteAppCenter.PageInfo;
import com.tencent.wxa.c;
import com.tencent.wxa.d.b.a;
import io.flutter.embedding.engine.FlutterEngine;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class WxaLiteAppUI
  extends WxaLiteAppBaseUI
  implements a, LiteAppCenter.ILiteAppUICallback
{
  public String appId;
  long appPtr;
  int cN;
  boolean egZ;
  int eha;
  int ehb;
  boolean ehc;
  boolean ehd;
  long ehe;
  long ehf;
  int ehg;
  int ehh;
  boolean ehi;
  boolean ehj;
  boolean ehk;
  boolean ehl;
  WxaLiteAppUI.a ehm;
  private WxaLiteAppStartReport ehn;
  private boolean eho;
  private com.tencent.liteapp.d.b ehp;
  private final b.b ehq;
  float fontScale;
  FrameLayout mContentView;
  long pageId;
  long renderId;
  boolean transparentTheme;
  
  public WxaLiteAppUI()
  {
    AppMethodBeat.i(219134);
    this.egZ = true;
    this.cN = -1;
    this.eha = -1;
    this.ehb = -1;
    this.ehc = false;
    this.ehd = false;
    this.appId = "";
    this.appPtr = -1L;
    this.pageId = -1L;
    this.ehe = -1L;
    this.renderId = -1L;
    this.ehf = 0L;
    this.fontScale = 1.0F;
    this.ehg = -1;
    this.ehh = -1;
    this.ehi = false;
    this.ehj = true;
    this.transparentTheme = false;
    this.ehk = true;
    this.ehl = false;
    this.ehm = WxaLiteAppUI.a.ehA;
    this.eho = false;
    this.ehq = new b.b()
    {
      private int ehr = 0;
      private boolean ehs = false;
      
      public final void e(boolean paramAnonymousBoolean, int paramAnonymousInt)
      {
        AppMethodBeat.i(219150);
        Object localObject = new int[2];
        WxaLiteAppUI.this.mContentView.getLocationInWindow((int[])localObject);
        this.ehr = (localObject[1] + paramAnonymousInt);
        this.ehs = paramAnonymousBoolean;
        com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "keyboardStateChange shown=%b h=%d", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(this.ehr) });
        paramAnonymousBoolean = f.bg(WxaLiteAppUI.this.getContext());
        if ((f.ehZ) && (paramAnonymousBoolean != WxaLiteAppUI.this.ehj))
        {
          WxaLiteAppUI.this.ehj = paramAnonymousBoolean;
          paramAnonymousInt = f.bk(WxaLiteAppUI.this.getContext());
          LiteAppCenter.setSystemBarHeight(WxaLiteAppUI.this.appPtr, -1.0F, paramAnonymousInt, true);
          com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "onKeyboardStateChanged mShown=%b isShowNavigationBar=%b navigationBarHeight=%d", new Object[] { Boolean.valueOf(this.ehs), Boolean.valueOf(WxaLiteAppUI.this.ehj), Integer.valueOf(paramAnonymousInt) });
        }
        c.keQ();
        localObject = WxaLiteAppUI.this.getFlutterEngine();
        paramAnonymousBoolean = this.ehs;
        paramAnonymousInt = this.ehr;
        HashMap localHashMap = new HashMap();
        localHashMap.put("shown", Boolean.valueOf(paramAnonymousBoolean));
        localHashMap.put("height", Integer.valueOf(paramAnonymousInt));
        c.a((FlutterEngine)localObject, "notifyKeyboardChanged", localHashMap);
        AppMethodBeat.o(219150);
      }
    };
    AppMethodBeat.o(219134);
  }
  
  private void a(WxaLiteAppStartReport paramWxaLiteAppStartReport)
  {
    AppMethodBeat.i(219163);
    if (!this.eho)
    {
      this.eho = true;
      try
      {
        com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "reportStartLiteApp %s", new Object[] { paramWxaLiteAppStartReport.toJsonString() });
        LiteAppCenter.mCallback.dataReporting("startLiteAppTimeLine", paramWxaLiteAppStartReport.toJsonString());
        AppMethodBeat.o(219163);
        return;
      }
      catch (Exception paramWxaLiteAppStartReport)
      {
        com.tencent.liteapp.b.b.e("WxaLiteApp.WxaLiteAppUI", paramWxaLiteAppStartReport.toString(), new Object[0]);
      }
    }
    AppMethodBeat.o(219163);
  }
  
  private void eu(String paramString)
  {
    AppMethodBeat.i(219157);
    try
    {
      String str1 = getIntent().getStringExtra("query");
      String str2 = getIntent().getStringExtra("page");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("appId", this.appId);
      localJSONObject.put("path", str2);
      localJSONObject.put("query", str1);
      LiteAppCenter.mCallback.dataReporting(paramString, localJSONObject.toString());
      AppMethodBeat.o(219157);
      return;
    }
    catch (JSONException paramString)
    {
      com.tencent.liteapp.b.b.e("WxaLiteApp.WxaLiteAppUI", paramString.toString(), new Object[0]);
      AppMethodBeat.o(219157);
    }
  }
  
  private void mj(int paramInt)
  {
    AppMethodBeat.i(219147);
    this.cN = paramInt;
    this.ehc = false;
    com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "setWindowFlags mFlags=%d mWindowFlags=%d", new Object[] { Integer.valueOf(this.cN), Integer.valueOf(this.eha) });
    if (this.eha > 0)
    {
      getWindow().clearFlags(this.eha);
      this.eha = -1;
    }
    int j = getWindow().getDecorView().getSystemUiVisibility() | 0x400 | 0x100 | 0x200;
    int i;
    if (paramInt == 5) {
      i = j | 0x1004;
    }
    for (;;)
    {
      if ((getWindow() != null) && (getWindow().getDecorView() != null)) {
        getWindow().getDecorView().setSystemUiVisibility(i);
      }
      AppMethodBeat.o(219147);
      return;
      i = j;
      if (paramInt == 7) {
        i = j | 0x1006;
      }
    }
  }
  
  public final void anI()
  {
    AppMethodBeat.i(219238);
    mj(this.ehb);
    AppMethodBeat.o(219238);
  }
  
  public final void anJ()
  {
    AppMethodBeat.i(219235);
    this.ehb = this.cN;
    mj(7);
    AppMethodBeat.o(219235);
  }
  
  public final void anK()
  {
    AppMethodBeat.i(219230);
    com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "openWebView", new Object[0]);
    AppMethodBeat.o(219230);
  }
  
  public final String anP()
  {
    AppMethodBeat.i(219240);
    com.tencent.liteapp.b.b.d("WxaLiteApp.WxaLiteAppUI", "getFlutterViewId %s", new Object[] { Long.valueOf(this.ehe) });
    long l = this.ehe;
    AppMethodBeat.o(219240);
    return String.valueOf(l);
  }
  
  public final String anQ()
  {
    AppMethodBeat.i(219242);
    long l = this.pageId;
    AppMethodBeat.o(219242);
    return String.valueOf(l);
  }
  
  public final Map anR()
  {
    AppMethodBeat.i(219247);
    if (this.egW != null)
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("activityId", Long.valueOf(this.egW.appUuid));
      ((HashMap)localObject).put("appId", this.egW.appId);
      ((HashMap)localObject).put("appPtr", Long.valueOf(this.egW.appPtr));
      ((HashMap)localObject).put("pageViewId", Long.valueOf(this.egW.pageId));
      ((HashMap)localObject).put("basePath", this.egW.basePath);
      ((HashMap)localObject).put("pageRenderPtr", Long.valueOf(this.egW.renderId));
      ((HashMap)localObject).put("flags", Integer.valueOf(this.egW.flags));
      ((HashMap)localObject).put("success", Integer.valueOf(this.egW.success));
      ((HashMap)localObject).put("startTime", Long.valueOf(System.currentTimeMillis()));
      AppMethodBeat.o(219247);
      return localObject;
    }
    Object localObject = super.anR();
    AppMethodBeat.o(219247);
    return localObject;
  }
  
  protected final View anT()
  {
    AppMethodBeat.i(219201);
    com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "initView", new Object[0]);
    Object localObject = super.anT();
    this.mContentView = new com.tencent.liteapp.d.a(this, (View)localObject);
    this.mContentView.addView((View)localObject, 0, new ViewGroup.LayoutParams(-1, -1));
    localObject = this.mContentView;
    AppMethodBeat.o(219201);
    return localObject;
  }
  
  public void closeWindow(final Intent paramIntent)
  {
    AppMethodBeat.i(219253);
    new Handler(getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219144);
        WxaLiteAppUI.this.setResult(-1, paramIntent);
        WxaLiteAppUI.this.finish();
        AppMethodBeat.o(219144);
      }
    });
    AppMethodBeat.o(219253);
  }
  
  public void finish()
  {
    AppMethodBeat.i(219199);
    super.finish();
    if (this.ehh >= 0) {
      overridePendingTransition(a.a.anim_not_change, this.ehh);
    }
    AppMethodBeat.o(219199);
  }
  
  public boolean hasCutOut()
  {
    AppMethodBeat.i(219222);
    boolean bool = e.bx(this);
    AppMethodBeat.o(219222);
    return bool;
  }
  
  public final void hideKeyboard()
  {
    AppMethodBeat.i(219228);
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mContentView.getWindowToken(), 0);
    AppMethodBeat.o(219228);
  }
  
  public boolean isDarkMode()
  {
    AppMethodBeat.i(219249);
    boolean bool = e.f(getResources());
    AppMethodBeat.o(219249);
    return bool;
  }
  
  public void navigateBack(final boolean paramBoolean)
  {
    AppMethodBeat.i(219225);
    new Handler(getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219127);
        WxaLiteAppUI.this.f(Boolean.valueOf(paramBoolean));
        AppMethodBeat.o(219127);
      }
    });
    AppMethodBeat.o(219225);
  }
  
  public void onCheckSumFail(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(219233);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      com.tencent.liteapp.b.b.e("WxaLiteApp.WxaLiteAppUI", "Check Sum Fail, appId: %s, path: %s", new Object[] { paramString, (String)paramList.next() });
    }
    new Handler(getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219128);
        WxaLiteAppUI.this.finish();
        AppMethodBeat.o(219128);
      }
    });
    AppMethodBeat.o(219233);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(219186);
    super.onConfigurationChanged(paramConfiguration);
    boolean bool = isDarkMode();
    if (bool != this.ehd)
    {
      com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "DarkMode change %b", new Object[] { Boolean.valueOf(bool) });
      this.ehd = bool;
      LiteAppCenter.updateDarkMode(this.ehd);
    }
    int i;
    if ((paramConfiguration.orientation == 2) && (!this.ehi))
    {
      this.ehi = true;
      if ((this.cN != 5) && (this.cN != 7))
      {
        i = getWindow().getDecorView().getSystemUiVisibility();
        getWindow().getDecorView().setSystemUiVisibility(i | 0x1004);
        AppMethodBeat.o(219186);
      }
    }
    else if ((paramConfiguration.orientation == 1) && (this.ehi))
    {
      this.ehi = false;
      if ((this.cN != 5) && (this.cN != 7))
      {
        i = getWindow().getDecorView().getSystemUiVisibility();
        getWindow().getDecorView().setSystemUiVisibility(i & 0xFFFFEFFB);
        AppMethodBeat.o(219186);
      }
    }
    else if ((paramConfiguration.fontScale != this.fontScale) && (LiteAppCenter.fontScaleFollowSystem))
    {
      com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "fontScale change %b", new Object[] { Float.valueOf(paramConfiguration.fontScale) });
      this.fontScale = paramConfiguration.fontScale;
      LiteAppCenter.updateFontScale(this.fontScale);
    }
    AppMethodBeat.o(219186);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(219195);
    if (c.keQ().aidn != null) {}
    for (int i = 1; i == 0; i = 0)
    {
      com.tencent.liteapp.b.b.e("WxaLiteApp.WxaLiteAppUI", "wxa router has no init.", new Object[0]);
      finish();
      AppMethodBeat.o(219195);
      return;
    }
    LiteAppCenter.setLocale(Locale.getDefault().getLanguage(), Locale.getDefault().getCountry());
    this.ehj = f.bg(this);
    boolean bool;
    if (getResources().getConfiguration().orientation == 2) {
      bool = true;
    }
    for (;;)
    {
      this.ehi = bool;
      com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "onCreate isHorzontal=%b isShowNavigationBar=%b", new Object[] { Boolean.valueOf(this.ehi), Boolean.valueOf(this.ehj) });
      this.ehn = new WxaLiteAppStartReport();
      if (getIntent().hasExtra("report")) {
        this.ehn = ((WxaLiteAppStartReport)getIntent().getParcelableExtra("report"));
      }
      Object localObject;
      if (getIntent().hasExtra("bundle"))
      {
        localObject = getIntent().getBundleExtra("bundle");
        if ((localObject != null) && ((((Bundle)localObject).containsKey("nextAnimIn")) || (((Bundle)localObject).containsKey("currentAnimOut"))))
        {
          this.ehg = ((Bundle)localObject).getInt("nextAnimIn", 0);
          this.ehh = ((Bundle)localObject).getInt("currentAnimOut", 0);
          overridePendingTransition(this.ehg, a.a.anim_not_change);
        }
        if (((Bundle)localObject).containsKey("transparent"))
        {
          this.egT = ((Bundle)localObject).getBoolean("transparent", false);
          if (this.egT)
          {
            this.transparentTheme = true;
            setTheme(a.f.WxaLiteTransparent);
          }
        }
        if (((Bundle)localObject).containsKey("openWithNewTab")) {
          this.egU = ((Bundle)localObject).getBoolean("openWithNewTab", false);
        }
      }
      this.ehd = isDarkMode();
      LiteAppCenter.updateDarkMode(this.ehd);
      float f;
      label356:
      String str;
      label503:
      int j;
      if (LiteAppCenter.fontScaleFollowSystem)
      {
        f = getResources().getConfiguration().fontScale;
        this.fontScale = f;
        LiteAppCenter.updateFontScale(this.fontScale);
        localObject = getIntent().getStringExtra("query");
        str = getIntent().getStringExtra("page");
        anL();
        anU();
        if (this.egS != null)
        {
          this.appId = this.egS.appId;
          com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "Use WxaLiteAppInfo", new Object[0]);
          com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "Use WxaLiteAppInfo start showIndexView", new Object[0]);
          long l = System.currentTimeMillis();
          i = c.keQ().d(c.keQ().OM(this.egU));
          if (!TextUtils.isEmpty(str)) {
            break label1285;
          }
          this.egW = LiteAppCenter.showIndexView(this.egS.appId, this.egS.path, this.egS.egI, (String)localObject, i);
          this.egW.appId = this.egS.appId;
          com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "Use WxaLiteAppInfo end showIndexView use %d", new Object[] { Long.valueOf(System.currentTimeMillis() - Long.valueOf(l).longValue()) });
        }
        if (this.egW == null) {
          break label1321;
        }
        this.appId = this.egW.appId;
        this.appPtr = this.egW.appPtr;
        this.pageId = this.egW.pageId;
        this.ehe = this.egW.appUuid;
        this.renderId = this.egW.renderId;
        this.ehf = this.egW.success;
        setPageOrientation(this.egW.pageOrientation);
        com.tencent.liteapp.b.b.d("WxaLiteApp.WxaLiteAppUI", "Use WxaLiteAppInfo pageInfo %s", new Object[] { this.egW.toString() });
        label654:
        localObject = anR();
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
            this.ehe = Long.valueOf(((Map)localObject).get("activityId").toString()).longValue();
          }
          if (((Map)localObject).containsKey("pageRenderPtr")) {
            this.renderId = Long.valueOf(((Map)localObject).get("pageRenderPtr").toString()).longValue();
          }
          if (((Map)localObject).containsKey("success")) {
            this.ehf = Long.valueOf(((Map)localObject).get("success").toString()).longValue();
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
        this.cN = i;
        getWindow().clearFlags(201326592);
        getWindow().addFlags(-2147483648);
        getWindow().setStatusBarColor(getResources().getColor(a.b.translucent));
        getWindow().setNavigationBarColor(getResources().getColor(a.b.translucent));
        getWindow().setFlags(16777216, 16777216);
        if (Build.VERSION.SDK_INT >= 28)
        {
          i = 1;
          label1038:
          if (i != 0) {
            getWindow().getAttributes().layoutInDisplayCutoutMode = 1;
          }
          if (this.mContentView != null) {
            this.mContentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
            {
              public final void onGlobalLayout()
              {
                AppMethodBeat.i(219149);
                WxaLiteAppUI localWxaLiteAppUI = WxaLiteAppUI.this;
                if (WxaLiteAppUI.this.getResources().getConfiguration().orientation == 2) {}
                for (boolean bool = true;; bool = false)
                {
                  localWxaLiteAppUI.ehi = bool;
                  com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "addOnGlobalLayoutListener activityId=%d size=%d,%d", new Object[] { Long.valueOf(WxaLiteAppUI.this.ehe), Integer.valueOf(WxaLiteAppUI.this.mContentView.getWidth()), Integer.valueOf(WxaLiteAppUI.this.mContentView.getHeight()) });
                  WxaLiteAppUI.a(WxaLiteAppUI.this);
                  AppMethodBeat.o(219149);
                  return;
                }
              }
            });
          }
          if (this.mContentView != null)
          {
            this.ehp = com.tencent.liteapp.d.a.cL(this.mContentView);
            paramBundle = this.ehp;
            localObject = this.ehq;
            if ((localObject != null) && (!paramBundle.ehU.contains(localObject))) {
              paramBundle.ehU.add(localObject);
            }
          }
          initSwipeBack();
          if (this.mContentView != null)
          {
            paramBundle = this.mContentView;
            if (!this.ehd) {
              break label1341;
            }
          }
        }
        label1285:
        label1321:
        label1341:
        for (i = -16777216;; i = -1)
        {
          paramBundle.setBackgroundColor(i);
          this.ehn.egF = (System.currentTimeMillis() - this.ehn.startTime);
          if (this.ehn.egG != 0L) {
            a(this.ehn);
          }
          if (((this.ehf <= 0L) || (this.ehf == 513L)) && (this.renderId <= 0L))
          {
            eu("openLiteAppANR");
            setContentView(a.e.empty_view);
            findViewById(a.d.root).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(219148);
                WxaLiteAppUI.a(WxaLiteAppUI.this, "openFailUserTap");
                WxaLiteAppUI.this.finish();
                AppMethodBeat.o(219148);
              }
            });
          }
          AppMethodBeat.o(219195);
          return;
          bool = false;
          break;
          f = LiteAppCenter.fontScale;
          break label356;
          this.egW = LiteAppCenter.showView(this.egS.appId, str, (String)localObject, this.egS.path, this.egS.egI, i);
          break label503;
          com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "Use WxaLiteAppInfo fail, pageInfo is null.", new Object[0]);
          break label654;
          i = 0;
          break label1038;
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
    AppMethodBeat.i(219215);
    if (this.ehp != null)
    {
      com.tencent.liteapp.d.b localb = this.ehp;
      b.b localb1 = this.ehq;
      if (localb1 != null) {
        localb.ehU.remove(localb1);
      }
    }
    super.onDestroy();
    LiteAppCenter.unsetUICallback(this.appPtr, this);
    AppMethodBeat.o(219215);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(219211);
    super.onPause();
    if (this.ehl) {
      getWindow().clearFlags(128);
    }
    AppMethodBeat.o(219211);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(219204);
    String str = this.appId;
    b.a locala = com.tencent.wxa.d.b.aiee;
    com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "TimeRecord startLiteApp %s %d", new Object[] { str, Long.valueOf(b.a.bHc("startLiteApp" + this.appId)) });
    super.onResume();
    if (this.ehl) {
      getWindow().addFlags(128);
    }
    AppMethodBeat.o(219204);
  }
  
  public void onShowPageTimeStamp(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(219254);
    if (this.ehn != null)
    {
      this.ehn.egG = (System.currentTimeMillis() - this.ehn.startTime);
      if (this.ehn.egF != 0L)
      {
        a(this.ehn);
        AppMethodBeat.o(219254);
      }
    }
    else
    {
      com.tencent.liteapp.b.b.w("WxaLiteApp.WxaLiteAppUI", "onShowPageTimeStamp reportStartLiteApp fail. report is null.", new Object[0]);
    }
    AppMethodBeat.o(219254);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(219202);
    super.onStart();
    LiteAppCenter.setUICallback(this.appPtr, this);
    AppMethodBeat.o(219202);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(219207);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      mj(this.cN);
    }
    AppMethodBeat.o(219207);
  }
  
  public void setFlags(final int paramInt)
  {
    AppMethodBeat.i(219218);
    com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "setFlags %d old=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.cN) });
    if (this.cN == paramInt)
    {
      AppMethodBeat.o(219218);
      return;
    }
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219151);
        WxaLiteAppUI.a(WxaLiteAppUI.this, paramInt);
        AppMethodBeat.o(219151);
      }
    });
    AppMethodBeat.o(219218);
  }
  
  public void setKeepScreenOn(final boolean paramBoolean)
  {
    AppMethodBeat.i(219252);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219139);
        WxaLiteAppUI.this.ehl = paramBoolean;
        if (paramBoolean)
        {
          WxaLiteAppUI.this.getWindow().addFlags(128);
          AppMethodBeat.o(219139);
          return;
        }
        WxaLiteAppUI.this.getWindow().clearFlags(128);
        AppMethodBeat.o(219139);
      }
    });
    AppMethodBeat.o(219252);
  }
  
  public void setPageOrientation(final int paramInt)
  {
    AppMethodBeat.i(219220);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219158);
        WxaLiteAppUI.b(WxaLiteAppUI.this, paramInt);
        AppMethodBeat.o(219158);
      }
    });
    AppMethodBeat.o(219220);
  }
  
  public void showPage(final LiteAppCenter.PageInfo paramPageInfo)
  {
    AppMethodBeat.i(219223);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219154);
        WxaLiteAppUI.this.setFlags(paramPageInfo.flags);
        WxaLiteAppUI.this.setPageOrientation(paramPageInfo.pageOrientation);
        AppMethodBeat.o(219154);
      }
    });
    AppMethodBeat.o(219223);
  }
  
  public void vibrateLong(long paramLong)
  {
    AppMethodBeat.i(219250);
    runOnUiThread(new WxaLiteAppUI.12(this, paramLong));
    AppMethodBeat.o(219250);
  }
  
  public void vibrateShort(long paramLong, int paramInt)
  {
    AppMethodBeat.i(219251);
    runOnUiThread(new WxaLiteAppUI.2(this, paramLong, paramInt));
    AppMethodBeat.o(219251);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.liteapp.ui.WxaLiteAppUI
 * JD-Core Version:    0.7.0.1
 */