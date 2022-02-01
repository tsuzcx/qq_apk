package com.tencent.liteapp.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.tencent.liteapp.a.a;
import com.tencent.liteapp.a.b;
import com.tencent.liteapp.a.f;
import com.tencent.liteapp.d.b.c;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.mm.plugin.lite.LiteAppCenter.ILiteAppUICallback;
import com.tencent.mm.plugin.lite.LiteAppCenter.PageInfo;
import com.tencent.wxa.c;
import com.tencent.wxa.d;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public class WxaLiteAppUI
  extends WxaLiteAppBaseUI
  implements a, LiteAppCenter.ILiteAppUICallback
{
  public String appId;
  long appPtr;
  int cN;
  a cpA;
  private com.tencent.liteapp.d.b cpB;
  private final b.c cpC;
  boolean cpp;
  int cpq;
  int cpr;
  boolean cps;
  boolean cpt;
  long cpu;
  int cpv;
  int cpw;
  boolean cpx;
  boolean cpy;
  boolean cpz;
  FrameLayout mContentView;
  long pageId;
  boolean transparentTheme;
  
  public WxaLiteAppUI()
  {
    AppMethodBeat.i(258730);
    this.cpp = true;
    this.cN = -1;
    this.cpq = -1;
    this.cpr = -1;
    this.cps = false;
    this.cpt = false;
    this.appId = "";
    this.appPtr = -1L;
    this.pageId = -1L;
    this.cpu = -1L;
    this.cpv = -1;
    this.cpw = -1;
    this.cpx = false;
    this.cpy = true;
    this.transparentTheme = false;
    this.cpz = true;
    this.cpA = a.cpJ;
    this.cpC = new b.c()
    {
      private int cpD = 0;
      private boolean cpE = false;
      
      private static Map g(boolean paramAnonymousBoolean, int paramAnonymousInt)
      {
        AppMethodBeat.i(258705);
        HashMap localHashMap = new HashMap();
        localHashMap.put("shown", Boolean.valueOf(paramAnonymousBoolean));
        localHashMap.put("height", Integer.valueOf(paramAnonymousInt));
        AppMethodBeat.o(258705);
        return localHashMap;
      }
      
      public final void ca(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(258704);
        this.cpE = paramAnonymousBoolean;
        com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "keyboardStateChange shown=%b h=%d", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(this.cpD) });
        paramAnonymousBoolean = com.tencent.liteapp.d.e.av(WxaLiteAppUI.this.getContext());
        if (paramAnonymousBoolean != WxaLiteAppUI.this.cpy)
        {
          WxaLiteAppUI.this.cpy = paramAnonymousBoolean;
          int i = com.tencent.liteapp.d.e.aB(WxaLiteAppUI.this.getContext());
          LiteAppCenter.setSystemBarHeight(WxaLiteAppUI.this.appPtr, -1.0F, i, true);
          com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "onKeyboardStateChanged mShown=%b isShowNavigationBar=%b navigationBarHeight=%d", new Object[] { Boolean.valueOf(this.cpE), Boolean.valueOf(WxaLiteAppUI.this.cpy), Integer.valueOf(i) });
          AppMethodBeat.o(258704);
          return;
        }
        c.ivt().ZYM.G("notifyKeyboardChanged", g(this.cpE, this.cpD));
        AppMethodBeat.o(258704);
      }
      
      public final int getHeight()
      {
        return this.cpD;
      }
      
      public final void iF(int paramAnonymousInt)
      {
        boolean bool1 = false;
        AppMethodBeat.i(258703);
        int[] arrayOfInt = new int[2];
        WxaLiteAppUI.this.mContentView.getLocationInWindow(arrayOfInt);
        this.cpD = (arrayOfInt[1] + paramAnonymousInt);
        com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "keyboardStateChange h=%d mSavedKeyboardHeight=%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(this.cpD) });
        boolean bool3 = com.tencent.liteapp.d.e.av(WxaLiteAppUI.this.getContext());
        if (bool3 != WxaLiteAppUI.this.cpy)
        {
          WxaLiteAppUI.this.cpy = bool3;
          paramAnonymousInt = com.tencent.liteapp.d.e.aB(WxaLiteAppUI.this.getContext());
          LiteAppCenter.setSystemBarHeight(WxaLiteAppUI.this.appPtr, -1.0F, paramAnonymousInt, true);
          com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "refreshHeight isShowNavigationBar=%b navigationBarHeight=%d", new Object[] { Boolean.valueOf(WxaLiteAppUI.this.cpy), Integer.valueOf(paramAnonymousInt) });
          AppMethodBeat.o(258703);
          return;
        }
        boolean bool2;
        if (this.cpE == true)
        {
          bool2 = this.cpE;
          if (!bool3) {
            break label220;
          }
          paramAnonymousInt = com.tencent.liteapp.d.e.aB(WxaLiteAppUI.this.getContext());
          if (this.cpD != paramAnonymousInt) {
            break label220;
          }
        }
        for (;;)
        {
          c.ivt().ZYM.G("notifyKeyboardChanged", g(bool1, this.cpD));
          AppMethodBeat.o(258703);
          return;
          label220:
          bool1 = bool2;
        }
      }
    };
    AppMethodBeat.o(258730);
  }
  
  private void iE(int paramInt)
  {
    AppMethodBeat.i(258766);
    this.cN = paramInt;
    this.cps = false;
    com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "setWindowFlags mFlags=%d mWindowFlags=%d", new Object[] { Integer.valueOf(this.cN), Integer.valueOf(this.cpq) });
    if (this.cpq > 0)
    {
      getWindow().clearFlags(this.cpq);
      this.cpq = -1;
    }
    int i = 1792;
    if (paramInt == 5)
    {
      i = 5892;
      if (this.cpA != a.cpK) {
        break label148;
      }
    }
    label148:
    for (paramInt = i & 0xFFFFDFEF;; paramInt = i | 0x2010)
    {
      if ((getWindow() != null) && (getWindow().getDecorView() != null)) {
        getWindow().getDecorView().setSystemUiVisibility(paramInt);
      }
      AppMethodBeat.o(258766);
      return;
      if (paramInt != 7) {
        break;
      }
      i = 5894;
      break;
    }
  }
  
  public final String NE()
  {
    AppMethodBeat.i(258770);
    com.tencent.liteapp.b.b.d("WxaLiteApp.WxaLiteAppUI", "getFlutterViewId %s", new Object[] { Long.valueOf(this.cpu) });
    long l = this.cpu;
    AppMethodBeat.o(258770);
    return String.valueOf(l);
  }
  
  public final String NF()
  {
    AppMethodBeat.i(258772);
    long l = this.pageId;
    AppMethodBeat.o(258772);
    return String.valueOf(l);
  }
  
  public final Map NG()
  {
    AppMethodBeat.i(258775);
    if (this.cpn != null)
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("activityId", Long.valueOf(this.cpn.appUuid));
      ((HashMap)localObject).put("appId", this.cpn.appId);
      ((HashMap)localObject).put("appPtr", Long.valueOf(this.cpn.appPtr));
      ((HashMap)localObject).put("pageViewId", Long.valueOf(this.cpn.pageId));
      ((HashMap)localObject).put("basePath", this.cpn.basePath);
      ((HashMap)localObject).put("pageRenderPtr", Long.valueOf(this.cpn.renderId));
      ((HashMap)localObject).put("flags", Integer.valueOf(this.cpn.flags));
      ((HashMap)localObject).put("startTime", Long.valueOf(System.currentTimeMillis()));
      AppMethodBeat.o(258775);
      return localObject;
    }
    Object localObject = super.NG();
    AppMethodBeat.o(258775);
    return localObject;
  }
  
  protected final View NI()
  {
    AppMethodBeat.i(258742);
    com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "initView", new Object[0]);
    Object localObject = super.NI();
    this.mContentView = new com.tencent.liteapp.d.a(this, (View)localObject);
    this.mContentView.addView((View)localObject, 0, new ViewGroup.LayoutParams(-1, -1));
    localObject = this.mContentView;
    AppMethodBeat.o(258742);
    return localObject;
  }
  
  public final void Np()
  {
    AppMethodBeat.i(258768);
    iE(this.cpr);
    AppMethodBeat.o(258768);
  }
  
  public final void Nq()
  {
    AppMethodBeat.i(258767);
    this.cpr = this.cN;
    iE(7);
    AppMethodBeat.o(258767);
  }
  
  public final void Nr()
  {
    AppMethodBeat.i(258764);
    com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "openWebView", new Object[0]);
    AppMethodBeat.o(258764);
  }
  
  public void finish()
  {
    AppMethodBeat.i(258740);
    super.finish();
    if (this.cpw >= 0) {
      overridePendingTransition(a.a.anim_not_change, this.cpw);
    }
    AppMethodBeat.o(258740);
  }
  
  public boolean hasCutOut()
  {
    AppMethodBeat.i(258754);
    boolean bool = com.tencent.mm.ext.ui.e.aN(this);
    AppMethodBeat.o(258754);
    return bool;
  }
  
  public final void hideKeyboard()
  {
    AppMethodBeat.i(258762);
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mContentView.getWindowToken(), 0);
    AppMethodBeat.o(258762);
  }
  
  public final void iD(int paramInt)
  {
    AppMethodBeat.i(258760);
    com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "inputLocationChange %d", new Object[] { Integer.valueOf(paramInt) });
    this.mContentView.scrollTo(this.mContentView.getScrollX(), paramInt);
    AppMethodBeat.o(258760);
  }
  
  public boolean isDarkMode()
  {
    AppMethodBeat.i(258776);
    boolean bool = com.tencent.mm.ext.ui.e.f(getResources());
    AppMethodBeat.o(258776);
    return bool;
  }
  
  public void navigateBack(final boolean paramBoolean)
  {
    AppMethodBeat.i(258758);
    new Handler(getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(258714);
        WxaLiteAppUI.this.c(Boolean.valueOf(paramBoolean));
        AppMethodBeat.o(258714);
      }
    });
    AppMethodBeat.o(258758);
  }
  
  public void onCheckSumFail(String paramString, List<String> paramList) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(258732);
    super.onConfigurationChanged(paramConfiguration);
    boolean bool = isDarkMode();
    if (bool != this.cpt)
    {
      com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "DarkMode change %b", new Object[] { Boolean.valueOf(bool) });
      this.cpt = bool;
      LiteAppCenter.updateDarkMode(this.cpt);
    }
    int i;
    if ((paramConfiguration.orientation == 2) && (!this.cpx))
    {
      this.cpx = true;
      if ((this.cN != 5) && (this.cN != 7))
      {
        i = getWindow().getDecorView().getSystemUiVisibility();
        getWindow().getDecorView().setSystemUiVisibility(i | 0x1004);
        AppMethodBeat.o(258732);
      }
    }
    else if ((paramConfiguration.orientation == 1) && (this.cpx))
    {
      this.cpx = false;
      if ((this.cN != 5) && (this.cN != 7))
      {
        i = getWindow().getDecorView().getSystemUiVisibility();
        getWindow().getDecorView().setSystemUiVisibility(i & 0xFFFFEFFB);
      }
    }
    AppMethodBeat.o(258732);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int j = 0;
    AppMethodBeat.i(258738);
    this.cpy = com.tencent.liteapp.d.e.av(this);
    boolean bool;
    Object localObject;
    String str;
    if (getResources().getConfiguration().orientation == 2)
    {
      bool = true;
      this.cpx = bool;
      com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "onCreate isHorzontal=%b isShowNavigationBar=%b", new Object[] { Boolean.valueOf(this.cpx), Boolean.valueOf(this.cpy) });
      if (getIntent().hasExtra("bundle"))
      {
        localObject = getIntent().getBundleExtra("bundle");
        if ((localObject != null) && ((((Bundle)localObject).containsKey("nextAnimIn")) || (((Bundle)localObject).containsKey("currentAnimOut"))))
        {
          this.cpv = ((Bundle)localObject).getInt("nextAnimIn", 0);
          this.cpw = ((Bundle)localObject).getInt("currentAnimOut", 0);
          overridePendingTransition(this.cpv, a.a.anim_not_change);
        }
        if (((Bundle)localObject).containsKey("transparent"))
        {
          this.cpf = ((Bundle)localObject).getBoolean("transparent", false);
          if (this.cpf)
          {
            this.transparentTheme = true;
            setTheme(a.f.WxaLiteTransparent);
          }
        }
      }
      this.cpt = isDarkMode();
      LiteAppCenter.updateDarkMode(this.cpt);
      localObject = getIntent().getStringExtra("query");
      str = getIntent().getStringExtra("page");
      Nu();
      NJ();
      if (this.cpe != null)
      {
        this.appId = this.cpe.appId;
        com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "Use WxaLiteAppInfo", new Object[0]);
        com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "Use WxaLiteAppInfo start showIndexView", new Object[0]);
        long l = System.currentTimeMillis();
        if (!TextUtils.isEmpty(str)) {
          break label902;
        }
        this.cpn = LiteAppCenter.showIndexView(this.cpe.appId, this.cpe.path, this.cpe.coX, (String)localObject);
        label335:
        this.cpn.appId = this.cpe.appId;
        com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "Use WxaLiteAppInfo end showIndexView use %d", new Object[] { Long.valueOf(System.currentTimeMillis() - Long.valueOf(l).longValue()) });
      }
      if (this.cpn == null) {
        break label937;
      }
      this.appId = this.cpn.appId;
      this.appPtr = this.cpn.appPtr;
      this.pageId = this.cpn.pageId;
      this.cpu = this.cpn.appUuid;
      com.tencent.liteapp.b.b.d("WxaLiteApp.WxaLiteAppUI", "Use WxaLiteAppInfo pageInfo %s", new Object[] { this.cpn.toString() });
      label452:
      localObject = NG();
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
          this.cpu = Long.valueOf(((Map)localObject).get("activityId").toString()).longValue();
        }
      }
      super.onCreate(paramBundle);
      if ((localObject != null) && (!((Map)localObject).containsKey("flags"))) {
        break label953;
      }
    }
    for (;;)
    {
      label902:
      label937:
      try
      {
        i = Integer.parseInt(((Map)localObject).get("flags").toString());
        this.cN = i;
        getWindow().clearFlags(201326592);
        getWindow().addFlags(-2147483648);
        getWindow().setStatusBarColor(getResources().getColor(a.b.translucent));
        getWindow().setNavigationBarColor(getResources().getColor(a.b.translucent));
        getWindow().setFlags(16777216, 16777216);
        if (Build.VERSION.SDK_INT < 28) {
          break label958;
        }
        i = 1;
        if (i != 0) {
          getWindow().getAttributes().layoutInDisplayCutoutMode = 1;
        }
        if (this.mContentView != null) {
          this.mContentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
          {
            public final void onGlobalLayout()
            {
              AppMethodBeat.i(258707);
              WxaLiteAppUI localWxaLiteAppUI = WxaLiteAppUI.this;
              if (WxaLiteAppUI.this.getResources().getConfiguration().orientation == 2) {}
              for (boolean bool = true;; bool = false)
              {
                localWxaLiteAppUI.cpx = bool;
                com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "addOnGlobalLayoutListener activityId=%d size=%d,%d", new Object[] { Long.valueOf(WxaLiteAppUI.this.cpu), Integer.valueOf(WxaLiteAppUI.this.mContentView.getWidth()), Integer.valueOf(WxaLiteAppUI.this.mContentView.getHeight()) });
                WxaLiteAppUI.a(WxaLiteAppUI.this);
                AppMethodBeat.o(258707);
                return;
              }
            }
          });
        }
        if (this.mContentView != null)
        {
          this.cpB = com.tencent.liteapp.d.a.cp(this.mContentView);
          paramBundle = this.cpB;
          localObject = this.cpC;
          if ((localObject != null) && (!paramBundle.cqe.contains(localObject))) {
            paramBundle.cqe.add(localObject);
          }
        }
        setRequestedOrientation(1);
        initSwipeBack();
        if (this.mContentView != null)
        {
          if (!this.cpf) {
            break label963;
          }
          paramBundle = this.mContentView;
          i = j;
          paramBundle.setBackgroundColor(i);
        }
        AppMethodBeat.o(258738);
        return;
      }
      catch (Exception paramBundle) {}
      bool = false;
      break;
      this.cpn = LiteAppCenter.showView(this.cpe.appId, str, (String)localObject, this.cpe.path, this.cpe.coX);
      break label335;
      com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "Use WxaLiteAppInfo fail, pageInfo is null.", new Object[0]);
      break label452;
      label953:
      int i = -1;
      continue;
      label958:
      i = 0;
      continue;
      label963:
      paramBundle = this.mContentView;
      if (this.cpt) {
        i = -16777216;
      } else {
        i = -1;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(258751);
    if (this.cpB != null)
    {
      com.tencent.liteapp.d.b localb = this.cpB;
      b.c localc = this.cpC;
      if (localc != null) {
        localb.cqe.remove(localc);
      }
    }
    super.onDestroy();
    LiteAppCenter.unsetUICallback(this.appPtr, this);
    AppMethodBeat.o(258751);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(258749);
    super.onPause();
    AppMethodBeat.o(258749);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(258746);
    super.onResume();
    AppMethodBeat.o(258746);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(258745);
    super.onStart();
    LiteAppCenter.setUICallback(this.appPtr, this);
    AppMethodBeat.o(258745);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(258747);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      iE(this.cN);
    }
    AppMethodBeat.o(258747);
  }
  
  public void setFlags(final int paramInt)
  {
    AppMethodBeat.i(258753);
    com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "setFlags %d old=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.cN) });
    if (this.cN == paramInt)
    {
      AppMethodBeat.o(258753);
      return;
    }
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(258708);
        WxaLiteAppUI.a(WxaLiteAppUI.this, paramInt);
        AppMethodBeat.o(258708);
      }
    });
    AppMethodBeat.o(258753);
  }
  
  public void showPage(final LiteAppCenter.PageInfo paramPageInfo)
  {
    AppMethodBeat.i(258756);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(258710);
        WxaLiteAppUI.this.setFlags(paramPageInfo.flags);
        AppMethodBeat.o(258710);
      }
    });
    AppMethodBeat.o(258756);
  }
  
  public void vibrateLong(long paramLong)
  {
    AppMethodBeat.i(258778);
    Vibrator localVibrator = (Vibrator)getSystemService("vibrator");
    if (localVibrator == null)
    {
      AppMethodBeat.o(258778);
      return;
    }
    localVibrator.vibrate(paramLong);
    AppMethodBeat.o(258778);
  }
  
  public void vibrateShort(long paramLong, int paramInt)
  {
    AppMethodBeat.i(258779);
    Vibrator localVibrator = (Vibrator)getSystemService("vibrator");
    if (localVibrator == null)
    {
      AppMethodBeat.o(258779);
      return;
    }
    if ((Build.VERSION.SDK_INT >= 26) && (localVibrator.hasAmplitudeControl()))
    {
      localVibrator.vibrate(VibrationEffect.createOneShot(paramLong, paramInt));
      AppMethodBeat.o(258779);
      return;
    }
    localVibrator.vibrate(paramLong);
    AppMethodBeat.o(258779);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(258721);
      cpJ = new a("kStatusBarModeLight", 0);
      cpK = new a("kStatusBarModeDark", 1);
      cpL = new a[] { cpJ, cpK };
      AppMethodBeat.o(258721);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteapp.ui.WxaLiteAppUI
 * JD-Core Version:    0.7.0.1
 */