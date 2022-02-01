package com.tencent.mm.plugin.lite.ui;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
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
import com.tencent.mm.plugin.lite.d.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  private u cvB;
  private final u.c cvD;
  boolean isDarkMode;
  FrameLayout mContentView;
  String uZe;
  int uZf;
  int uZg;
  int uZh;
  int uZi;
  boolean uZj;
  boolean uZk;
  
  public WxaLiteAppUI()
  {
    AppMethodBeat.i(217206);
    this.uZf = -16777216;
    this.uZg = -1;
    this.uZh = -1;
    this.uZi = -16777216;
    this.uZj = true;
    this.FL = -1;
    this.uZk = false;
    this.isDarkMode = false;
    this.cvD = new u.c()
    {
      private int cod = 0;
      private boolean uZl = false;
      
      private static Map I(boolean paramAnonymousBoolean, int paramAnonymousInt)
      {
        AppMethodBeat.i(217201);
        HashMap localHashMap = new HashMap();
        localHashMap.put("shown", Boolean.valueOf(paramAnonymousBoolean));
        localHashMap.put("height", Integer.valueOf(paramAnonymousInt));
        AppMethodBeat.o(217201);
        return localHashMap;
      }
      
      public final void bu(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(217200);
        this.uZl = paramAnonymousBoolean;
        ad.i("MicroMsg.LiteApp.WxaLiteAppUI", "keyboardStateChange shown=%b h=%d", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(this.cod) });
        e.fYT().A("notifyKeyboardChanged", I(paramAnonymousBoolean, this.cod));
        AppMethodBeat.o(217200);
      }
      
      public final void gB(int paramAnonymousInt)
      {
        AppMethodBeat.i(217199);
        int[] arrayOfInt = new int[2];
        WxaLiteAppUI.this.mContentView.getLocationInWindow(arrayOfInt);
        this.cod = (arrayOfInt[1] + paramAnonymousInt);
        ad.i("MicroMsg.LiteApp.WxaLiteAppUI", "keyboardStateChange h=%d mSavedKeyboardHeight=%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(this.cod) });
        if (this.uZl == true) {
          e.fYT().A("notifyKeyboardChanged", I(true, this.cod));
        }
        AppMethodBeat.o(217199);
      }
      
      public final int getHeight()
      {
        return this.cod;
      }
    };
    AppMethodBeat.o(217206);
  }
  
  public final void IV(int paramInt)
  {
    AppMethodBeat.i(217217);
    ad.i("MicroMsg.LiteApp.WxaLiteAppUI", "inputLocationChange %d", new Object[] { Integer.valueOf(paramInt) });
    this.mContentView.scrollTo(this.mContentView.getScrollX(), paramInt);
    AppMethodBeat.o(217217);
  }
  
  public final void bnj()
  {
    AppMethodBeat.i(217219);
    if (com.tencent.mm.compatible.util.d.ly(19))
    {
      getWindow().setFlags(201327616, 201327616);
      View localView = getWindow().getDecorView();
      localView.setSystemUiVisibility(localView.getSystemUiVisibility() | 0x1002);
    }
    for (;;)
    {
      hideTitleView();
      AppMethodBeat.o(217219);
      return;
      getWindow().setFlags(1024, 1024);
    }
  }
  
  public final void dfI()
  {
    AppMethodBeat.i(217220);
    if (com.tencent.mm.compatible.util.d.ly(19))
    {
      int i = 201327616;
      int j = i;
      if (this.FL > 0)
      {
        j = i;
        if ((this.FL & 0x1) != 0) {
          j = 134218752;
        }
        i = j;
        if ((this.FL & 0x2) != 0) {
          i = j & 0xF7FFFFFF;
        }
        j = i;
        if ((this.FL & 0x4) != 0) {
          j = i & 0xFFFFFBFF;
        }
      }
      if (j != 0) {
        getWindow().clearFlags(j);
      }
      if (!this.uZk)
      {
        View localView = getWindow().getDecorView();
        localView.setSystemUiVisibility(localView.getSystemUiVisibility() & 0xFFFFFFFD & 0xFFFFEFFF);
      }
    }
    for (;;)
    {
      if (!bt.isNullOrNil(this.uZe)) {
        showTitleView();
      }
      AppMethodBeat.o(217220);
      return;
      getWindow().clearFlags(1024);
    }
  }
  
  public final void dfJ()
  {
    AppMethodBeat.i(217218);
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mContentView.getWindowToken(), 0);
    AppMethodBeat.o(217218);
  }
  
  protected final View dfK()
  {
    AppMethodBeat.i(217209);
    ad.i("MicroMsg.LiteApp.WxaLiteAppUI", "initView");
    Object localObject = super.dfK();
    this.mContentView = new n(this, (View)localObject);
    this.mContentView.addView((View)localObject, 0, new ViewGroup.LayoutParams(-1, -1));
    localObject = this.mContentView;
    AppMethodBeat.o(217209);
    return localObject;
  }
  
  public void navigateBack()
  {
    AppMethodBeat.i(217216);
    h.LTJ.aP(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(217205);
        WxaLiteAppUI.this.onBackPressed();
        AppMethodBeat.o(217205);
      }
    });
    AppMethodBeat.o(217216);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(217207);
    super.onConfigurationChanged(paramConfiguration);
    boolean bool = al.isDarkMode();
    if (bool != this.isDarkMode)
    {
      ad.i("MicroMsg.LiteApp.WxaLiteAppUI", "DarkMode change %b", new Object[] { Boolean.valueOf(bool) });
      this.isDarkMode = bool;
      LiteAppCenter.setDarkMode(this.isDarkMode);
      if (!bt.isNullOrNil(this.uZe))
      {
        if (!this.isDarkMode) {
          break label119;
        }
        i = this.uZg;
        setMMTitleColor(i);
      }
      if (!this.isDarkMode) {
        break label127;
      }
      i = this.uZi;
      label91:
      setActionbarColor(i);
      if (!this.isDarkMode) {
        break label135;
      }
    }
    label135:
    for (int i = this.uZi;; i = this.uZh)
    {
      setNavigationbarColor(i);
      AppMethodBeat.o(217207);
      return;
      label119:
      i = this.uZf;
      break;
      label127:
      i = this.uZh;
      break label91;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(217208);
    this.isDarkMode = al.isDarkMode();
    LiteAppCenter.setDarkMode(this.isDarkMode);
    customfixStatusbar(true);
    d.a locala = com.tencent.mm.plugin.lite.d.uYh;
    d.a.IU(4);
    super.onCreate(paramBundle);
    paramBundle = dfW();
    if ((paramBundle != null) && (paramBundle.containsKey("startTime")))
    {
      g.yhR.n(1293L, 1L, 1L);
      long l1 = Long.valueOf(paramBundle.get("startTime").toString()).longValue();
      long l2 = System.currentTimeMillis();
      if ((l2 >= l1) && (l1 > 0L)) {
        g.yhR.n(1293L, 2L, l2 - l1);
      }
    }
    this.uZe = "";
    int i;
    if (paramBundle != null)
    {
      if (paramBundle.containsKey("title")) {
        this.uZe = paramBundle.get("title").toString();
      }
      i = -1;
      if (!paramBundle.containsKey("titleColor")) {}
    }
    try
    {
      this.uZf = Color.parseColor(paramBundle.get("titleColor").toString());
      if (paramBundle.containsKey("darkTitleColor")) {}
      try
      {
        this.uZg = Color.parseColor(paramBundle.get("darkTitleColor").toString());
        label231:
        if (paramBundle.containsKey("titleBackgroundColor")) {}
        try
        {
          this.uZh = Color.parseColor(paramBundle.get("titleBackgroundColor").toString());
          label262:
          if (paramBundle.containsKey("darkTitleBackgroundColor")) {}
          try
          {
            this.uZi = Color.parseColor(paramBundle.get("darkTitleBackgroundColor").toString());
            label293:
            int k = i;
            if (paramBundle.containsKey("flags")) {}
            try
            {
              k = Integer.parseInt(paramBundle.get("flags").toString());
              setBackBtn(new MenuItem.OnMenuItemClickListener()
              {
                public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
                {
                  AppMethodBeat.i(217202);
                  WxaLiteAppUI.this.onBackPressed();
                  AppMethodBeat.o(217202);
                  return false;
                }
              });
              if (!bt.isNullOrNil(this.uZe))
              {
                setMMTitle(this.uZe);
                showTitleView();
                if (this.isDarkMode)
                {
                  i = this.uZg;
                  setMMTitleColor(i);
                  label376:
                  ad.i("MicroMsg.LiteApp.WxaLiteAppUI", "topcolor=%d dark=%d, textcolor=%d dark=%d", new Object[] { Integer.valueOf(this.uZh), Integer.valueOf(this.uZi), Integer.valueOf(this.uZf), Integer.valueOf(this.uZg) });
                  if (!this.isDarkMode) {
                    break label645;
                  }
                  i = this.uZi;
                  label440:
                  setActionbarColor(i);
                  if (!this.isDarkMode) {
                    break label653;
                  }
                  i = this.uZi;
                  label457:
                  setNavigationbarColor(i);
                  this.FL = k;
                  if (k > 0)
                  {
                    this.uZk = false;
                    if (!com.tencent.mm.compatible.util.d.ly(19)) {
                      break label661;
                    }
                    i = 0;
                    if ((k & 0x1) != 0) {
                      i = 67108864;
                    }
                    j = i;
                    if ((k & 0x2) != 0) {
                      j = i | 0x8000000;
                    }
                    if ((k & 0x4) == 0) {
                      break label704;
                    }
                    i = j | 0x400;
                    if (i != 0) {
                      getWindow().setFlags(i, i);
                    }
                    paramBundle = getWindow().getDecorView();
                    if (i == 201327616)
                    {
                      this.uZk = true;
                      paramBundle.setSystemUiVisibility(4098);
                    }
                  }
                }
              }
              for (;;)
              {
                getWindow().setFlags(16777216, 16777216);
                this.mContentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
                {
                  public final void onGlobalLayout()
                  {
                    AppMethodBeat.i(217203);
                    Point localPoint = al.ci(WxaLiteAppUI.this.getContext());
                    WxaLiteAppUI.this.mContentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    if (WxaLiteAppUI.this.uZj) {}
                    for (int i = 0;; i = ar.dT(WxaLiteAppUI.this.getContext()))
                    {
                      DisplayMetrics localDisplayMetrics = WxaLiteAppUI.this.getContext().getResources().getDisplayMetrics();
                      int j = WxaLiteAppUI.this.mContentView.getWidth();
                      int k = WxaLiteAppUI.this.mContentView.getHeight() - i;
                      float f = localDisplayMetrics.density;
                      LiteAppCenter.setDisplayParams(j / f, k / f, localPoint.x / f, localPoint.y / f, localDisplayMetrics.densityDpi, f);
                      ad.i("MicroMsg.LiteApp.WxaLiteAppUI", "SetDisplayParams w=%d h=%d screen=%d,%d actionBar=%d densityDpi=%d density=%f", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(localPoint.x), Integer.valueOf(localPoint.y), Integer.valueOf(i), Integer.valueOf(localDisplayMetrics.densityDpi), Float.valueOf(localDisplayMetrics.density) });
                      AppMethodBeat.o(217203);
                      return;
                    }
                  }
                });
                this.cvB = n.df(this.mContentView);
                this.cvB.a(this.cvD);
                setRequestedOrientation(1);
                AppMethodBeat.o(217208);
                return;
                i = this.uZf;
                break;
                hideTitleView();
                break label376;
                label645:
                i = this.uZh;
                break label440;
                label653:
                i = this.uZh;
                break label457;
                label661:
                getWindow().setFlags(1024, 1024);
              }
            }
            catch (Exception paramBundle)
            {
              for (;;)
              {
                k = i;
              }
            }
          }
          catch (Exception localException1)
          {
            break label293;
          }
        }
        catch (Exception localException2)
        {
          break label262;
        }
      }
      catch (Exception localException3)
      {
        break label231;
      }
    }
    catch (Exception localException4)
    {
      for (;;)
      {
        int j;
        continue;
        label704:
        i = j;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(217213);
    if (this.cvB != null) {
      this.cvB.b(this.cvD);
    }
    super.onDestroy();
    LiteAppCenter.unsetUICallback(this);
    AppMethodBeat.o(217213);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(217212);
    super.onPause();
    AppMethodBeat.o(217212);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(217211);
    super.onResume();
    AppMethodBeat.o(217211);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(217210);
    super.onStart();
    LiteAppCenter.setUICallback(this);
    AppMethodBeat.o(217210);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setTitle(final String paramString)
  {
    AppMethodBeat.i(217214);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(217204);
        if (!bt.isNullOrNil(paramString))
        {
          WxaLiteAppUI.this.setMMTitle(paramString);
          WxaLiteAppUI.this.showTitleView();
          AppMethodBeat.o(217204);
          return;
        }
        WxaLiteAppUI.this.hideTitleView();
        AppMethodBeat.o(217204);
      }
    });
    AppMethodBeat.o(217214);
  }
  
  public void setTitleAlpha(int paramInt)
  {
    AppMethodBeat.i(217215);
    runOnUiThread(new Runnable()
    {
      public final void run() {}
    });
    AppMethodBeat.o(217215);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.ui.WxaLiteAppUI
 * JD-Core Version:    0.7.0.1
 */