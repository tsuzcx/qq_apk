package com.tencent.mm.plugin.lite.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.plugin.appbrand.widget.input.u;
import com.tencent.mm.plugin.appbrand.widget.input.u.c;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.mm.plugin.lite.LiteAppCenter.ILiteAppUICallback;
import com.tencent.mm.plugin.lite.LiteAppCenter.PageInfo;
import com.tencent.mm.plugin.lite.d.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ar;
import com.tencent.wax.e;
import java.util.HashMap;
import java.util.Map;

public class WxaLiteAppUI
  extends WxaLiteAppBaseUI
  implements LiteAppCenter.ILiteAppUICallback, a
{
  int FL;
  int ahF;
  long appPtr;
  private u cwf;
  private final u.c cwh;
  boolean gtO;
  FrameLayout mContentView;
  int mKJ;
  long pageId;
  String vli;
  int vlj;
  int vlk;
  int vll;
  int vlm;
  int vln;
  boolean vlo;
  boolean vlp;
  boolean vlq;
  long vlr;
  int vls;
  int vlt;
  int vlu;
  
  public WxaLiteAppUI()
  {
    AppMethodBeat.i(217840);
    this.vlj = 255;
    this.vlk = -16777216;
    this.vll = -1;
    this.vlm = -1;
    this.vln = -16777216;
    this.vlo = false;
    this.vlp = true;
    this.FL = -1;
    this.vlq = false;
    this.gtO = false;
    this.appPtr = -1L;
    this.pageId = -1L;
    this.vlr = -1L;
    this.vls = 0;
    this.mKJ = 0;
    this.ahF = 0;
    this.vlt = -1;
    this.vlu = -1;
    this.cwh = new u.c()
    {
      private int cof = 0;
      private boolean vlv = false;
      
      private static Map K(boolean paramAnonymousBoolean, int paramAnonymousInt)
      {
        AppMethodBeat.i(217832);
        HashMap localHashMap = new HashMap();
        localHashMap.put("shown", Boolean.valueOf(paramAnonymousBoolean));
        localHashMap.put("height", Integer.valueOf(paramAnonymousInt));
        AppMethodBeat.o(217832);
        return localHashMap;
      }
      
      public final void bu(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(217831);
        this.vlv = paramAnonymousBoolean;
        ae.i("MicroMsg.LiteApp.WxaLiteAppUI", "keyboardStateChange shown=%b h=%d", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(this.cof) });
        e.gdt().A("notifyKeyboardChanged", K(paramAnonymousBoolean, this.cof));
        AppMethodBeat.o(217831);
      }
      
      public final void gB(int paramAnonymousInt)
      {
        AppMethodBeat.i(217830);
        int[] arrayOfInt = new int[2];
        WxaLiteAppUI.this.mContentView.getLocationInWindow(arrayOfInt);
        this.cof = (arrayOfInt[1] + paramAnonymousInt);
        ae.i("MicroMsg.LiteApp.WxaLiteAppUI", "keyboardStateChange h=%d mSavedKeyboardHeight=%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(this.cof) });
        if (this.vlv == true) {
          e.gdt().A("notifyKeyboardChanged", K(true, this.cof));
        }
        AppMethodBeat.o(217830);
      }
      
      public final int getHeight()
      {
        return this.cof;
      }
    };
    AppMethodBeat.o(217840);
  }
  
  private static int ee(String paramString, int paramInt)
  {
    AppMethodBeat.i(217850);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(217850);
      return paramInt;
    }
    try
    {
      int i = Color.parseColor(paramString);
      AppMethodBeat.o(217850);
      return i;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(217850);
    }
    return paramInt;
  }
  
  public final void Jt(int paramInt)
  {
    AppMethodBeat.i(217858);
    ae.i("MicroMsg.LiteApp.WxaLiteAppUI", "inputLocationChange %d", new Object[] { Integer.valueOf(paramInt) });
    this.mContentView.scrollTo(this.mContentView.getScrollX(), paramInt);
    AppMethodBeat.o(217858);
  }
  
  public final void bnT()
  {
    AppMethodBeat.i(217860);
    if (com.tencent.mm.compatible.util.d.lA(19))
    {
      getWindow().setFlags(201327616, 201327616);
      View localView = getWindow().getDecorView();
      localView.setSystemUiVisibility(localView.getSystemUiVisibility() | 0x1002);
    }
    for (;;)
    {
      hideTitleView();
      AppMethodBeat.o(217860);
      return;
      getWindow().setFlags(1024, 1024);
    }
  }
  
  public final void diF()
  {
    AppMethodBeat.i(217861);
    if (com.tencent.mm.compatible.util.d.lA(19))
    {
      int k = this.FL;
      if (k > 0)
      {
        int i = 201327616;
        int j = i;
        if (k > 0)
        {
          j = i;
          if ((k & 0x1) != 0) {
            j = 134218752;
          }
          i = j;
          if ((k & 0x2) != 0) {
            i = j & 0xF7FFFFFF;
          }
          j = i;
          if ((k & 0x4) != 0) {
            j = i & 0xFFFFFBFF;
          }
        }
        if (j != 0) {
          getWindow().clearFlags(j);
        }
      }
      if (!this.vlq)
      {
        View localView = getWindow().getDecorView();
        localView.setSystemUiVisibility(localView.getSystemUiVisibility() & 0xFFFFFFFD & 0xFFFFEFFF);
      }
    }
    for (;;)
    {
      if (!bu.isNullOrNil(this.vli)) {
        showTitleView();
      }
      AppMethodBeat.o(217861);
      return;
      getWindow().clearFlags(1024);
    }
  }
  
  public final void diG()
  {
    AppMethodBeat.i(217859);
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mContentView.getWindowToken(), 0);
    AppMethodBeat.o(217859);
  }
  
  public final String diR()
  {
    AppMethodBeat.i(217862);
    ae.d("MicroMsg.LiteApp.WxaLiteAppUI", "getFlutterViewId %s", new Object[] { Long.valueOf(this.vlr) });
    long l = this.vlr;
    AppMethodBeat.o(217862);
    return String.valueOf(l);
  }
  
  protected final View diV()
  {
    AppMethodBeat.i(217844);
    ae.i("MicroMsg.LiteApp.WxaLiteAppUI", "initView");
    Object localObject = super.diV();
    this.mContentView = new n(this, (View)localObject);
    this.mContentView.addView((View)localObject, 0, new ViewGroup.LayoutParams(-1, -1));
    localObject = this.mContentView;
    AppMethodBeat.o(217844);
    return localObject;
  }
  
  public void finish()
  {
    AppMethodBeat.i(217843);
    super.finish();
    if (this.vlu >= 0) {
      overridePendingTransition(2130771986, this.vlu);
    }
    AppMethodBeat.o(217843);
  }
  
  public boolean hasCutOut()
  {
    AppMethodBeat.i(217855);
    boolean bool = al.aH(this);
    AppMethodBeat.o(217855);
    return bool;
  }
  
  public void navigateBack()
  {
    AppMethodBeat.i(217857);
    h.MqF.aM(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(217839);
        WxaLiteAppUI.this.onBackPressed();
        AppMethodBeat.o(217839);
      }
    });
    AppMethodBeat.o(217857);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(217841);
    super.onConfigurationChanged(paramConfiguration);
    boolean bool = al.isDarkMode();
    if (bool != this.gtO)
    {
      ae.i("MicroMsg.LiteApp.WxaLiteAppUI", "DarkMode change %b", new Object[] { Boolean.valueOf(bool) });
      this.gtO = bool;
      LiteAppCenter.updateDarkMode(this.gtO);
      if (!bu.isNullOrNil(this.vli))
      {
        if (!this.gtO) {
          break label122;
        }
        i = this.vll;
        setMMTitleColor(i);
      }
      if (!this.gtO) {
        break label130;
      }
      i = this.vln;
      label93:
      setActionbarColor(i);
      if (!this.gtO) {
        break label138;
      }
    }
    label130:
    label138:
    for (int i = this.vln;; i = this.vlm)
    {
      setNavigationbarColor(i);
      AppMethodBeat.o(217841);
      return;
      label122:
      i = this.vlk;
      break;
      i = this.vlm;
      break label93;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(217842);
    if (getIntent().hasExtra("bundle"))
    {
      localObject = getIntent().getBundleExtra("bundle");
      if ((localObject != null) && ((((Bundle)localObject).containsKey("nextAnimIn")) || (((Bundle)localObject).containsKey("currentAnimOut"))))
      {
        this.vlt = ((Bundle)localObject).getInt("nextAnimIn", 0);
        this.vlu = ((Bundle)localObject).getInt("currentAnimOut", 0);
        overridePendingTransition(this.vlt, 2130771986);
      }
    }
    this.gtO = al.isDarkMode();
    LiteAppCenter.updateDarkMode(this.gtO);
    customfixStatusbar(true);
    Object localObject = com.tencent.mm.plugin.lite.d.vjW;
    d.a.Js(4);
    localObject = diT();
    if (localObject != null)
    {
      if (((Map)localObject).containsKey("startTime"))
      {
        g.yxI.n(1293L, 1L, 1L);
        long l1 = Long.valueOf(((Map)localObject).get("startTime").toString()).longValue();
        long l2 = System.currentTimeMillis();
        if ((l2 >= l1) && (l1 > 0L)) {
          g.yxI.n(1293L, 2L, l2 - l1);
        }
      }
      if (((Map)localObject).containsKey("appPtr")) {
        this.appPtr = Long.valueOf(((Map)localObject).get("appPtr").toString()).longValue();
      }
      if (((Map)localObject).containsKey("pageViewId")) {
        this.pageId = Long.valueOf(((Map)localObject).get("pageViewId").toString()).longValue();
      }
      if (((Map)localObject).containsKey("activityId")) {
        this.vlr = Long.valueOf(((Map)localObject).get("activityId").toString()).longValue();
      }
    }
    super.onCreate(paramBundle);
    this.vls = ar.en(this);
    this.mKJ = ar.kd(this);
    this.ahF = ar.dX(this);
    this.vli = "";
    int j;
    int i;
    if (localObject != null)
    {
      if (((Map)localObject).containsKey("title")) {
        this.vli = ((Map)localObject).get("title").toString();
      }
      j = -1;
      if (((Map)localObject).containsKey("titleColor")) {
        this.vlk = ee(((Map)localObject).get("titleColor").toString(), -16777216);
      }
      if (((Map)localObject).containsKey("darkTitleColor")) {
        this.vll = ee(((Map)localObject).get("darkTitleColor").toString(), -1);
      }
      if (((Map)localObject).containsKey("titleBackgroundColor")) {
        this.vlm = ee(((Map)localObject).get("titleBackgroundColor").toString(), -1);
      }
      if (((Map)localObject).containsKey("darkTitleBackgroundColor")) {
        this.vln = ee(((Map)localObject).get("darkTitleBackgroundColor").toString(), -16777216);
      }
      i = j;
      if (!((Map)localObject).containsKey("flags")) {}
    }
    try
    {
      i = Integer.parseInt(((Map)localObject).get("flags").toString());
      if (((Map)localObject).containsKey("showMenu")) {}
      try
      {
        if (Integer.parseInt(((Map)localObject).get("showMenu").toString()) != 1) {
          break label874;
        }
        bool = true;
        this.vlo = bool;
      }
      catch (Exception paramBundle)
      {
        boolean bool;
        label609:
        break label609;
      }
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(217833);
          WxaLiteAppUI.this.onBackPressed();
          AppMethodBeat.o(217833);
          return false;
        }
      });
      if (this.vlo) {
        addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(217834);
            LiteAppCenter.publishGlobalEvent(WxaLiteAppUI.this.appPtr, WxaLiteAppUI.this.pageId, "[\"app.showMenu\", {}]");
            AppMethodBeat.o(217834);
            return false;
          }
        });
      }
      if (!bu.isNullOrNil(this.vli))
      {
        setMMTitle(this.vli);
        showTitleView();
        if (this.gtO)
        {
          j = this.vll;
          label678:
          setMMTitleColor(j);
          label683:
          ae.i("MicroMsg.LiteApp.WxaLiteAppUI", "topcolor=%d dark=%d, textcolor=%d dark=%d", new Object[] { Integer.valueOf(this.vlm), Integer.valueOf(this.vln), Integer.valueOf(this.vlk), Integer.valueOf(this.vll) });
          if (!this.gtO) {
            break label895;
          }
          j = this.vln;
          label747:
          setActionbarColor(j);
          if (!this.gtO) {
            break label903;
          }
        }
      }
      label903:
      for (j = this.vln;; j = this.vlm)
      {
        setNavigationbarColor(j);
        this.FL = i;
        if (((i == 7) || (i == 3) || (i == 5) || (i == 1)) && (getSupportActionBar() != null)) {
          getSupportActionBar().hide();
        }
        getWindow().setFlags(16777216, 16777216);
        this.mContentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
          public final void onGlobalLayout()
          {
            AppMethodBeat.i(217835);
            Point localPoint = al.ck(WxaLiteAppUI.this.getContext());
            WxaLiteAppUI.this.mContentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            int j = ar.dX(WxaLiteAppUI.this.getContext());
            DisplayMetrics localDisplayMetrics = WxaLiteAppUI.this.getContext().getResources().getDisplayMetrics();
            int k = WxaLiteAppUI.this.mContentView.getWidth();
            int i = WxaLiteAppUI.this.mContentView.getHeight();
            if ((WxaLiteAppUI.this.FL == 3) || (WxaLiteAppUI.this.FL == 7)) {
              i += WxaLiteAppUI.this.mKJ + WxaLiteAppUI.this.vls;
            }
            for (;;)
            {
              float f = localDisplayMetrics.density;
              LiteAppCenter.setDisplayParams(k / f, i / f, localPoint.x / f, localPoint.y / f, localDisplayMetrics.densityDpi, f);
              ae.i("MicroMsg.LiteApp.WxaLiteAppUI", "updateLvCppDisplayParams SetDisplayParams w=%d h=%d screen=%d,%d actionBar=%d densityDpi=%d density=%f", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(localPoint.x), Integer.valueOf(localPoint.y), Integer.valueOf(j), Integer.valueOf(localDisplayMetrics.densityDpi), Float.valueOf(localDisplayMetrics.density) });
              AppMethodBeat.o(217835);
              return;
              if ((WxaLiteAppUI.this.FL == 1) || (WxaLiteAppUI.this.FL == 5)) {
                i += WxaLiteAppUI.this.mKJ;
              }
            }
          }
        });
        this.cwf = n.df(this.mContentView);
        this.cwf.a(this.cwh);
        setRequestedOrientation(1);
        AppMethodBeat.o(217842);
        return;
        label874:
        bool = false;
        break;
        j = this.vlk;
        break label678;
        hideTitleView();
        break label683;
        label895:
        j = this.vlm;
        break label747;
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
  
  public void onDestroy()
  {
    AppMethodBeat.i(217849);
    if (this.cwf != null) {
      this.cwf.b(this.cwh);
    }
    super.onDestroy();
    LiteAppCenter.unsetUICallback(this.appPtr, this);
    AppMethodBeat.o(217849);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(217848);
    super.onPause();
    AppMethodBeat.o(217848);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(217846);
    super.onResume();
    AppMethodBeat.o(217846);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(217845);
    super.onStart();
    LiteAppCenter.setUICallback(this.appPtr, this);
    AppMethodBeat.o(217845);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(217847);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      int i = this.FL;
      this.FL = i;
      this.vlq = false;
      if (i == 1)
      {
        if ((getWindow() != null) && (getWindow().getDecorView() != null))
        {
          getWindow().getDecorView().setSystemUiVisibility(5376);
          getWindow().addFlags(67108864);
        }
        AppMethodBeat.o(217847);
        return;
      }
      if (i == 3)
      {
        if ((getWindow() != null) && (getWindow().getDecorView() != null))
        {
          getWindow().getDecorView().setSystemUiVisibility(1280);
          getWindow().addFlags(67108864);
          getWindow().addFlags(134217728);
        }
        AppMethodBeat.o(217847);
        return;
      }
      if (i == 5)
      {
        if ((getWindow() != null) && (getWindow().getDecorView() != null)) {
          getWindow().getDecorView().setSystemUiVisibility(5380);
        }
        AppMethodBeat.o(217847);
        return;
      }
      if ((i == 7) && (getWindow() != null) && (getWindow().getDecorView() != null)) {
        getWindow().getDecorView().setSystemUiVisibility(5894);
      }
    }
    AppMethodBeat.o(217847);
  }
  
  public void setFlags(int paramInt)
  {
    AppMethodBeat.i(217854);
    ae.i("MicroMsg.LiteApp.WxaLiteAppUI", "setFlags %d old=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.FL) });
    if (this.FL == paramInt)
    {
      AppMethodBeat.o(217854);
      return;
    }
    runOnUiThread(new Runnable()
    {
      public final void run() {}
    });
    AppMethodBeat.o(217854);
  }
  
  public void setTitle(final String paramString)
  {
    AppMethodBeat.i(217851);
    if (this.vli.equals(paramString))
    {
      AppMethodBeat.o(217851);
      return;
    }
    ae.i("MicroMsg.LiteApp.WxaLiteAppUI", "setTitle %s", new Object[] { paramString });
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(217836);
        WxaLiteAppUI.this.vli = paramString;
        if (!bu.isNullOrNil(paramString))
        {
          WxaLiteAppUI.this.setMMTitle(paramString);
          WxaLiteAppUI.this.showTitleView();
          AppMethodBeat.o(217836);
          return;
        }
        WxaLiteAppUI.this.hideTitleView();
        AppMethodBeat.o(217836);
      }
    });
    AppMethodBeat.o(217851);
  }
  
  public void setTitleAlpha(final int paramInt)
  {
    AppMethodBeat.i(217852);
    if (this.vlj == paramInt)
    {
      AppMethodBeat.o(217852);
      return;
    }
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        int i = 255;
        AppMethodBeat.i(217837);
        WxaLiteAppUI.this.vlj = paramInt;
        int j = paramInt;
        if (j > 255) {}
        for (;;)
        {
          WxaLiteAppUI.this.setTitleAlpha(i / 255.0F);
          AppMethodBeat.o(217837);
          return;
          if (j < 0) {
            i = 0;
          } else {
            i = j;
          }
        }
      }
    });
    AppMethodBeat.o(217852);
  }
  
  public void showMenuBtn(final boolean paramBoolean)
  {
    AppMethodBeat.i(217853);
    if (this.vlo == paramBoolean)
    {
      AppMethodBeat.o(217853);
      return;
    }
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(217838);
        WxaLiteAppUI.this.vlo = paramBoolean;
        WxaLiteAppUI.this.showOptionMenu(paramBoolean);
        AppMethodBeat.o(217838);
      }
    });
    AppMethodBeat.o(217853);
  }
  
  public void showPage(LiteAppCenter.PageInfo paramPageInfo)
  {
    AppMethodBeat.i(217856);
    setTitle(paramPageInfo.title);
    showMenuBtn(paramPageInfo.showMenu);
    setFlags(paramPageInfo.flags);
    String str1 = paramPageInfo.titleColor;
    String str2 = paramPageInfo.darkTitleColor;
    String str3 = paramPageInfo.titleBackgroundColor;
    paramPageInfo = paramPageInfo.darkTitleBackgroundColor;
    int i = ee(str1, -16777216);
    if (i != this.vlk)
    {
      this.vlk = i;
      if (!this.gtO) {
        setMMTitleColor(this.vlk);
      }
    }
    i = ee(str2, -1);
    if (i != this.vll)
    {
      this.vll = i;
      if (this.gtO) {
        setMMTitleColor(this.vlk);
      }
    }
    i = ee(str3, -1);
    if (i != this.vlm)
    {
      this.vlm = i;
      if (!this.gtO) {
        setActionbarColor(this.vlm);
      }
    }
    i = ee(paramPageInfo, -16777216);
    if (i != this.vln)
    {
      this.vln = i;
      if (this.gtO) {
        setActionbarColor(this.vln);
      }
    }
    AppMethodBeat.o(217856);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.ui.WxaLiteAppUI
 * JD-Core Version:    0.7.0.1
 */