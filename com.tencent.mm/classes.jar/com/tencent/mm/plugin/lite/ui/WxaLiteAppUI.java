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
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.plugin.appbrand.widget.input.u;
import com.tencent.mm.plugin.appbrand.widget.input.u.c;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.mm.plugin.lite.LiteAppCenter.ILiteAppUICallback;
import com.tencent.mm.plugin.lite.d.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.ap;
import com.tencent.wax.e;
import java.util.HashMap;
import java.util.Map;

public class WxaLiteAppUI
  extends WxaLiteAppBaseUI
  implements LiteAppCenter.ILiteAppUICallback, a
{
  int DU;
  private u ckZ;
  private final u.c clb;
  boolean fXS;
  FrameLayout mContentView;
  boolean tWA;
  boolean tWB;
  String tWv;
  int tWw;
  int tWx;
  int tWy;
  int tWz;
  
  public WxaLiteAppUI()
  {
    AppMethodBeat.i(205727);
    this.tWw = -16777216;
    this.tWx = -1;
    this.tWy = -1;
    this.tWz = -16777216;
    this.tWA = true;
    this.DU = -1;
    this.tWB = false;
    this.fXS = false;
    this.clb = new u.c()
    {
      private int cdN = 0;
      private boolean tWC = false;
      
      private static Map I(boolean paramAnonymousBoolean, int paramAnonymousInt)
      {
        AppMethodBeat.i(205722);
        HashMap localHashMap = new HashMap();
        localHashMap.put("shown", Boolean.valueOf(paramAnonymousBoolean));
        localHashMap.put("height", Integer.valueOf(paramAnonymousInt));
        AppMethodBeat.o(205722);
        return localHashMap;
      }
      
      public final void bt(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(205721);
        this.tWC = paramAnonymousBoolean;
        ac.i("MicroMsg.LiteApp.WxaLiteAppUI", "keyboardStateChange shown=%b h=%d", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(this.cdN) });
        e.fHC().C("notifyKeyboardChanged", I(paramAnonymousBoolean, this.cdN));
        AppMethodBeat.o(205721);
      }
      
      public final int getHeight()
      {
        return this.cdN;
      }
      
      public final void gw(int paramAnonymousInt)
      {
        AppMethodBeat.i(205720);
        int[] arrayOfInt = new int[2];
        WxaLiteAppUI.this.mContentView.getLocationInWindow(arrayOfInt);
        this.cdN = (arrayOfInt[1] + paramAnonymousInt);
        ac.i("MicroMsg.LiteApp.WxaLiteAppUI", "keyboardStateChange h=%d mSavedKeyboardHeight=%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(this.cdN) });
        if (this.tWC == true) {
          e.fHC().C("notifyKeyboardChanged", I(true, this.cdN));
        }
        AppMethodBeat.o(205720);
      }
    };
    AppMethodBeat.o(205727);
  }
  
  public final void Hz(int paramInt)
  {
    AppMethodBeat.i(205738);
    ac.i("MicroMsg.LiteApp.WxaLiteAppUI", "inputLocationChange %d", new Object[] { Integer.valueOf(paramInt) });
    this.mContentView.scrollTo(this.mContentView.getScrollX(), paramInt);
    AppMethodBeat.o(205738);
  }
  
  public final void bjx()
  {
    AppMethodBeat.i(205740);
    if (com.tencent.mm.compatible.util.d.kZ(19))
    {
      getWindow().setFlags(201327616, 201327616);
      View localView = getWindow().getDecorView();
      localView.setSystemUiVisibility(localView.getSystemUiVisibility() | 0x1002);
    }
    for (;;)
    {
      hideTitleView();
      AppMethodBeat.o(205740);
      return;
      getWindow().setFlags(1024, 1024);
    }
  }
  
  public final void cWw()
  {
    AppMethodBeat.i(205741);
    if (com.tencent.mm.compatible.util.d.kZ(19))
    {
      int i = 201327616;
      int j = i;
      if (this.DU > 0)
      {
        j = i;
        if ((this.DU & 0x1) != 0) {
          j = 134218752;
        }
        i = j;
        if ((this.DU & 0x2) != 0) {
          i = j & 0xF7FFFFFF;
        }
        j = i;
        if ((this.DU & 0x4) != 0) {
          j = i & 0xFFFFFBFF;
        }
      }
      if (j != 0) {
        getWindow().clearFlags(j);
      }
      if (!this.tWB)
      {
        View localView = getWindow().getDecorView();
        localView.setSystemUiVisibility(localView.getSystemUiVisibility() & 0xFFFFFFFD & 0xFFFFEFFF);
      }
    }
    for (;;)
    {
      if (!bs.isNullOrNil(this.tWv)) {
        showTitleView();
      }
      AppMethodBeat.o(205741);
      return;
      getWindow().clearFlags(1024);
    }
  }
  
  public final void cWx()
  {
    AppMethodBeat.i(205739);
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mContentView.getWindowToken(), 0);
    AppMethodBeat.o(205739);
  }
  
  protected final View cWy()
  {
    AppMethodBeat.i(205730);
    ac.i("MicroMsg.LiteApp.WxaLiteAppUI", "initView");
    Object localObject = super.cWy();
    this.mContentView = new n(this, (View)localObject);
    this.mContentView.addView((View)localObject, 0, new ViewGroup.LayoutParams(-1, -1));
    localObject = this.mContentView;
    AppMethodBeat.o(205730);
    return localObject;
  }
  
  public void navigateBack()
  {
    AppMethodBeat.i(205737);
    com.tencent.e.h.JZN.aQ(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205726);
        WxaLiteAppUI.this.onBackPressed();
        AppMethodBeat.o(205726);
      }
    });
    AppMethodBeat.o(205737);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(205728);
    super.onConfigurationChanged(paramConfiguration);
    boolean bool = aj.DT();
    if (bool != this.fXS)
    {
      ac.i("MicroMsg.LiteApp.WxaLiteAppUI", "DarkMode change %b", new Object[] { Boolean.valueOf(bool) });
      this.fXS = bool;
      LiteAppCenter.setDarkMode(this.fXS);
      if (!bs.isNullOrNil(this.tWv))
      {
        if (!this.fXS) {
          break label119;
        }
        i = this.tWx;
        setMMTitleColor(i);
      }
      if (!this.fXS) {
        break label127;
      }
      i = this.tWz;
      label91:
      setActionbarColor(i);
      if (!this.fXS) {
        break label135;
      }
    }
    label135:
    for (int i = this.tWz;; i = this.tWy)
    {
      setNavigationbarColor(i);
      AppMethodBeat.o(205728);
      return;
      label119:
      i = this.tWw;
      break;
      label127:
      i = this.tWy;
      break label91;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(205729);
    this.fXS = aj.DT();
    LiteAppCenter.setDarkMode(this.fXS);
    customfixStatusbar(true);
    d.a locala = com.tencent.mm.plugin.lite.d.tVF;
    d.a.Hy(4);
    super.onCreate(paramBundle);
    paramBundle = cWK();
    if ((paramBundle != null) && (paramBundle.containsKey("startTime")))
    {
      com.tencent.mm.plugin.report.service.h.wUl.n(1293L, 1L, 1L);
      long l1 = Long.valueOf(paramBundle.get("startTime").toString()).longValue();
      long l2 = System.currentTimeMillis();
      if ((l2 >= l1) && (l1 > 0L)) {
        com.tencent.mm.plugin.report.service.h.wUl.n(1293L, 2L, l2 - l1);
      }
    }
    this.tWv = "";
    int i;
    if (paramBundle != null)
    {
      if (paramBundle.containsKey("title")) {
        this.tWv = paramBundle.get("title").toString();
      }
      i = -1;
      if (!paramBundle.containsKey("titleColor")) {}
    }
    try
    {
      this.tWw = Color.parseColor(paramBundle.get("titleColor").toString());
      if (paramBundle.containsKey("darkTitleColor")) {}
      try
      {
        this.tWx = Color.parseColor(paramBundle.get("darkTitleColor").toString());
        label232:
        if (paramBundle.containsKey("titleBackgroundColor")) {}
        try
        {
          this.tWy = Color.parseColor(paramBundle.get("titleBackgroundColor").toString());
          label263:
          if (paramBundle.containsKey("darkTitleBackgroundColor")) {}
          try
          {
            this.tWz = Color.parseColor(paramBundle.get("darkTitleBackgroundColor").toString());
            label294:
            int k = i;
            if (paramBundle.containsKey("flags")) {}
            try
            {
              k = Integer.parseInt(paramBundle.get("flags").toString());
              setBackBtn(new MenuItem.OnMenuItemClickListener()
              {
                public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
                {
                  AppMethodBeat.i(205723);
                  WxaLiteAppUI.this.onBackPressed();
                  AppMethodBeat.o(205723);
                  return false;
                }
              });
              if (!bs.isNullOrNil(this.tWv))
              {
                setMMTitle(this.tWv);
                showTitleView();
                if (this.fXS)
                {
                  i = this.tWx;
                  setMMTitleColor(i);
                  label377:
                  ac.i("MicroMsg.LiteApp.WxaLiteAppUI", "topcolor=%d dark=%d, textcolor=%d dark=%d", new Object[] { Integer.valueOf(this.tWy), Integer.valueOf(this.tWz), Integer.valueOf(this.tWw), Integer.valueOf(this.tWx) });
                  if (!this.fXS) {
                    break label647;
                  }
                  i = this.tWz;
                  label441:
                  setActionbarColor(i);
                  if (!this.fXS) {
                    break label655;
                  }
                  i = this.tWz;
                  label458:
                  setNavigationbarColor(i);
                  this.DU = k;
                  if (k > 0)
                  {
                    this.tWB = false;
                    if (!com.tencent.mm.compatible.util.d.kZ(19)) {
                      break label663;
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
                      break label706;
                    }
                    i = j | 0x400;
                    if (i != 0) {
                      getWindow().setFlags(i, i);
                    }
                    paramBundle = getWindow().getDecorView();
                    if (i == 201327616)
                    {
                      this.tWB = true;
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
                    AppMethodBeat.i(205724);
                    Point localPoint = aj.cl(WxaLiteAppUI.this.getContext());
                    WxaLiteAppUI.this.mContentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    if (WxaLiteAppUI.this.tWA) {}
                    for (int i = 0;; i = ap.dT(WxaLiteAppUI.this.getContext()))
                    {
                      DisplayMetrics localDisplayMetrics = WxaLiteAppUI.this.getContext().getResources().getDisplayMetrics();
                      int j = WxaLiteAppUI.this.mContentView.getWidth();
                      int k = WxaLiteAppUI.this.mContentView.getHeight() - i;
                      float f = localDisplayMetrics.density;
                      LiteAppCenter.setDisplayParams(j / f, k / f, localPoint.x / f, localPoint.y / f, localDisplayMetrics.densityDpi, f);
                      ac.i("MicroMsg.LiteApp.WxaLiteAppUI", "SetDisplayParams w=%d h=%d screen=%d,%d actionBar=%d densityDpi=%d density=%f", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(localPoint.x), Integer.valueOf(localPoint.y), Integer.valueOf(i), Integer.valueOf(localDisplayMetrics.densityDpi), Float.valueOf(localDisplayMetrics.density) });
                      AppMethodBeat.o(205724);
                      return;
                    }
                  }
                });
                this.ckZ = n.dd(this.mContentView);
                this.ckZ.a(this.clb);
                setRequestedOrientation(1);
                AppMethodBeat.o(205729);
                return;
                i = this.tWw;
                break;
                hideTitleView();
                break label377;
                label647:
                i = this.tWy;
                break label441;
                label655:
                i = this.tWy;
                break label458;
                label663:
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
            break label294;
          }
        }
        catch (Exception localException2)
        {
          break label263;
        }
      }
      catch (Exception localException3)
      {
        break label232;
      }
    }
    catch (Exception localException4)
    {
      for (;;)
      {
        int j;
        continue;
        label706:
        i = j;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(205734);
    if (this.ckZ != null) {
      this.ckZ.b(this.clb);
    }
    super.onDestroy();
    LiteAppCenter.unsetUICallback(this);
    AppMethodBeat.o(205734);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(205733);
    super.onPause();
    AppMethodBeat.o(205733);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(205732);
    super.onResume();
    AppMethodBeat.o(205732);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(205731);
    super.onStart();
    LiteAppCenter.setUICallback(this);
    AppMethodBeat.o(205731);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setTitle(final String paramString)
  {
    AppMethodBeat.i(205735);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205725);
        if (!bs.isNullOrNil(paramString))
        {
          WxaLiteAppUI.this.setMMTitle(paramString);
          WxaLiteAppUI.this.showTitleView();
          AppMethodBeat.o(205725);
          return;
        }
        WxaLiteAppUI.this.hideTitleView();
        AppMethodBeat.o(205725);
      }
    });
    AppMethodBeat.o(205735);
  }
  
  public void setTitleAlpha(int paramInt)
  {
    AppMethodBeat.i(205736);
    runOnUiThread(new Runnable()
    {
      public final void run() {}
    });
    AppMethodBeat.o(205736);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.ui.WxaLiteAppUI
 * JD-Core Version:    0.7.0.1
 */