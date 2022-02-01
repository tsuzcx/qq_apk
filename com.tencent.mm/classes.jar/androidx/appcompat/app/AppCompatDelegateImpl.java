package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.a.c;
import androidx.appcompat.a.f;
import androidx.appcompat.a.g;
import androidx.appcompat.a.i;
import androidx.appcompat.a.j;
import androidx.appcompat.a.a.a;
import androidx.appcompat.view.b;
import androidx.appcompat.view.b.a;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.h.a;
import androidx.appcompat.view.menu.o.a;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.ContentFrameLayout.a;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.ah;
import androidx.appcompat.widget.ai;
import androidx.appcompat.widget.m;
import androidx.appcompat.widget.q;
import androidx.appcompat.widget.q.a;
import androidx.core.g.aa;
import androidx.core.g.ae;
import androidx.core.g.ae.e;
import androidx.core.g.s;
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

final class AppCompatDelegateImpl
  extends d
  implements LayoutInflater.Factory2, h.a
{
  private static final boolean fR;
  private static final int[] fS;
  private static boolean fT;
  private CharSequence cZ;
  private TextView eM;
  final Window em;
  final Window.Callback fU;
  final Window.Callback fV;
  final c fW;
  MenuInflater fX;
  private m fY;
  private b fZ;
  private final Runnable gA;
  private boolean gB;
  private Rect gC;
  private Rect gD;
  private AppCompatViewInflater gE;
  private g ga;
  b gb;
  ActionBarContextView gc;
  PopupWindow gd;
  Runnable ge;
  aa gf;
  boolean gg;
  private boolean gh;
  private ViewGroup gi;
  private View gj;
  private boolean gk;
  private boolean gl;
  boolean gm;
  boolean gn;
  boolean go;
  boolean gp;
  boolean gq;
  private boolean gr;
  private PanelFeatureState[] gs;
  private PanelFeatureState gt;
  private boolean gu;
  private int gv;
  private boolean gw;
  private e gx;
  boolean gy;
  int gz;
  ActionBar mActionBar;
  final Context mContext;
  boolean mIsDestroyed;
  
  static
  {
    AppMethodBeat.i(238340);
    if (Build.VERSION.SDK_INT < 21) {}
    for (boolean bool = true;; bool = false)
    {
      fR = bool;
      fS = new int[] { 16842836 };
      if ((fR) && (!fT))
      {
        Thread.setDefaultUncaughtExceptionHandler(new AppCompatDelegateImpl.1(Thread.getDefaultUncaughtExceptionHandler()));
        fT = true;
      }
      AppMethodBeat.o(238340);
      return;
    }
  }
  
  AppCompatDelegateImpl(Context paramContext, Window paramWindow, c paramc)
  {
    AppMethodBeat.i(238209);
    this.gf = null;
    this.gg = true;
    this.gv = -100;
    this.gA = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(238088);
        if ((AppCompatDelegateImpl.this.gz & 0x1) != 0) {
          AppCompatDelegateImpl.this.T(0);
        }
        if ((AppCompatDelegateImpl.this.gz & 0x1000) != 0) {
          AppCompatDelegateImpl.this.T(108);
        }
        AppCompatDelegateImpl.this.gy = false;
        AppCompatDelegateImpl.this.gz = 0;
        AppMethodBeat.o(238088);
      }
    };
    this.mContext = paramContext;
    this.em = paramWindow;
    this.fW = paramc;
    this.fU = this.em.getCallback();
    if ((this.fU instanceof d))
    {
      paramContext = new IllegalStateException("AppCompat has already installed itself into the Window");
      AppMethodBeat.o(238209);
      throw paramContext;
    }
    this.fV = new d(this.fU);
    this.em.setCallback(this.fV);
    paramContext = androidx.appcompat.widget.ac.a(paramContext, null, fS);
    paramWindow = paramContext.aA(0);
    if (paramWindow != null) {
      this.em.setBackgroundDrawable(paramWindow);
    }
    paramContext.wA.recycle();
    AppMethodBeat.o(238209);
  }
  
  private void S(int paramInt)
  {
    AppMethodBeat.i(238304);
    this.gz |= 1 << paramInt;
    if (!this.gy)
    {
      w.a(this.em.getDecorView(), this.gA);
      this.gy = true;
    }
    AppMethodBeat.o(238304);
  }
  
  private static int V(int paramInt)
  {
    int i;
    if (paramInt == 8) {
      i = 108;
    }
    do
    {
      return i;
      i = paramInt;
    } while (paramInt != 9);
    return 109;
  }
  
  private int W(int paramInt)
  {
    AppMethodBeat.i(238323);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(238323);
      return paramInt;
    case 0: 
      if ((Build.VERSION.SDK_INT >= 23) && (((UiModeManager)this.mContext.getSystemService(UiModeManager.class)).getNightMode() == 0))
      {
        AppMethodBeat.o(238323);
        return -1;
      }
      aX();
      paramInt = this.gx.aZ();
      AppMethodBeat.o(238323);
      return paramInt;
    }
    AppMethodBeat.o(238323);
    return -1;
  }
  
  private boolean X(int paramInt)
  {
    AppMethodBeat.i(238330);
    Resources localResources = this.mContext.getResources();
    Configuration localConfiguration = localResources.getConfiguration();
    int i = localConfiguration.uiMode;
    if (paramInt == 2)
    {
      paramInt = 32;
      if ((i & 0x30) == paramInt) {
        break label128;
      }
      if (!aY()) {
        break label73;
      }
      ((Activity)this.mContext).recreate();
    }
    for (;;)
    {
      AppMethodBeat.o(238330);
      return true;
      paramInt = 16;
      break;
      label73:
      localConfiguration = new Configuration(localConfiguration);
      DisplayMetrics localDisplayMetrics = localResources.getDisplayMetrics();
      localConfiguration.uiMode = (paramInt | localConfiguration.uiMode & 0xFFFFFFCF);
      localResources.updateConfiguration(localConfiguration, localDisplayMetrics);
      if (Build.VERSION.SDK_INT < 26) {
        f.a(localResources);
      }
    }
    label128:
    AppMethodBeat.o(238330);
    return false;
  }
  
  private View a(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(238284);
    String str;
    boolean bool;
    if (this.gE == null)
    {
      str = this.mContext.obtainStyledAttributes(a.j.AppCompatTheme).getString(a.j.AppCompatTheme_viewInflaterClass);
      if ((str == null) || (AppCompatViewInflater.class.getName().equals(str))) {
        this.gE = new AppCompatViewInflater();
      }
    }
    else
    {
      if (!fR) {
        break label208;
      }
      if (!(paramAttributeSet instanceof XmlPullParser)) {
        break label195;
      }
      if (((XmlPullParser)paramAttributeSet).getDepth() <= 1) {
        break label189;
      }
      bool = true;
    }
    for (;;)
    {
      for (;;)
      {
        paramView = this.gE.createView(paramView, paramString, paramContext, paramAttributeSet, bool, fR, true, ah.eH());
        AppMethodBeat.o(238284);
        return paramView;
        try
        {
          this.gE = ((AppCompatViewInflater)Class.forName(str).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        catch (Throwable localThrowable)
        {
          new StringBuilder("Failed to instantiate custom view inflater ").append(str).append(". Falling back to default.");
          this.gE = new AppCompatViewInflater();
        }
      }
      break;
      label189:
      bool = false;
      continue;
      label195:
      bool = a((ViewParent)paramView);
      continue;
      label208:
      bool = false;
    }
  }
  
  private void a(PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    int j = -1;
    AppMethodBeat.i(238293);
    if ((paramPanelFeatureState.gZ) || (this.mIsDestroyed))
    {
      AppMethodBeat.o(238293);
      return;
    }
    int i;
    if (paramPanelFeatureState.gP == 0)
    {
      if ((this.mContext.getResources().getConfiguration().screenLayout & 0xF) == 4) {}
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(238293);
        return;
      }
    }
    Object localObject = this.em.getCallback();
    if ((localObject != null) && (!((Window.Callback)localObject).onMenuOpened(paramPanelFeatureState.gP, paramPanelFeatureState.gU)))
    {
      a(paramPanelFeatureState, true);
      AppMethodBeat.o(238293);
      return;
    }
    localObject = (WindowManager)this.mContext.getSystemService("window");
    if (localObject == null)
    {
      AppMethodBeat.o(238293);
      return;
    }
    if (!b(paramPanelFeatureState, paramKeyEvent))
    {
      AppMethodBeat.o(238293);
      return;
    }
    if ((paramPanelFeatureState.gR == null) || (paramPanelFeatureState.hb))
    {
      if (paramPanelFeatureState.gR == null)
      {
        a(paramPanelFeatureState);
        if (paramPanelFeatureState.gR == null) {
          AppMethodBeat.o(238293);
        }
      }
      else if ((paramPanelFeatureState.hb) && (paramPanelFeatureState.gR.getChildCount() > 0))
      {
        paramPanelFeatureState.gR.removeAllViews();
      }
      if ((!c(paramPanelFeatureState)) || (!paramPanelFeatureState.ba()))
      {
        AppMethodBeat.o(238293);
        return;
      }
      paramKeyEvent = paramPanelFeatureState.gS.getLayoutParams();
      if (paramKeyEvent != null) {
        break label462;
      }
      paramKeyEvent = new ViewGroup.LayoutParams(-2, -2);
    }
    label462:
    for (;;)
    {
      i = paramPanelFeatureState.background;
      paramPanelFeatureState.gR.setBackgroundResource(i);
      ViewParent localViewParent = paramPanelFeatureState.gS.getParent();
      if ((localViewParent != null) && ((localViewParent instanceof ViewGroup))) {
        ((ViewGroup)localViewParent).removeView(paramPanelFeatureState.gS);
      }
      paramPanelFeatureState.gR.addView(paramPanelFeatureState.gS, paramKeyEvent);
      if (!paramPanelFeatureState.gS.hasFocus()) {
        paramPanelFeatureState.gS.requestFocus();
      }
      i = -2;
      for (;;)
      {
        paramPanelFeatureState.gY = false;
        paramKeyEvent = new WindowManager.LayoutParams(i, -2, paramPanelFeatureState.x, paramPanelFeatureState.y, 1002, 8519680, -3);
        paramKeyEvent.gravity = paramPanelFeatureState.ek;
        paramKeyEvent.windowAnimations = paramPanelFeatureState.gQ;
        ((WindowManager)localObject).addView(paramPanelFeatureState.gR, paramKeyEvent);
        paramPanelFeatureState.gZ = true;
        AppMethodBeat.o(238293);
        return;
        if (paramPanelFeatureState.gT != null)
        {
          paramKeyEvent = paramPanelFeatureState.gT.getLayoutParams();
          if (paramKeyEvent != null)
          {
            i = j;
            if (paramKeyEvent.width == -1) {
              continue;
            }
          }
        }
        i = -2;
      }
    }
  }
  
  private boolean a(ViewParent paramViewParent)
  {
    AppMethodBeat.i(238287);
    if (paramViewParent == null)
    {
      AppMethodBeat.o(238287);
      return false;
    }
    View localView = this.em.getDecorView();
    for (;;)
    {
      if (paramViewParent == null)
      {
        AppMethodBeat.o(238287);
        return true;
      }
      if ((paramViewParent == localView) || (!(paramViewParent instanceof View)) || (w.al((View)paramViewParent)))
      {
        AppMethodBeat.o(238287);
        return false;
      }
      paramViewParent = paramViewParent.getParent();
    }
  }
  
  private boolean a(PanelFeatureState paramPanelFeatureState)
  {
    AppMethodBeat.i(238294);
    paramPanelFeatureState.G(aN());
    paramPanelFeatureState.gR = new f(paramPanelFeatureState.gW);
    paramPanelFeatureState.ek = 81;
    AppMethodBeat.o(238294);
    return true;
  }
  
  private boolean a(PanelFeatureState paramPanelFeatureState, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(238303);
    if (paramKeyEvent.isSystem())
    {
      AppMethodBeat.o(238303);
      return false;
    }
    boolean bool1;
    if (!paramPanelFeatureState.gX)
    {
      bool1 = bool2;
      if (!b(paramPanelFeatureState, paramKeyEvent)) {}
    }
    else
    {
      bool1 = bool2;
      if (paramPanelFeatureState.gU != null) {
        bool1 = paramPanelFeatureState.gU.performShortcut(paramInt, paramKeyEvent, 1);
      }
    }
    AppMethodBeat.o(238303);
    return bool1;
  }
  
  private void aM()
  {
    AppMethodBeat.i(238214);
    aO();
    if ((!this.gm) || (this.mActionBar != null))
    {
      AppMethodBeat.o(238214);
      return;
    }
    if ((this.fU instanceof Activity)) {
      this.mActionBar = new j((Activity)this.fU, this.gn);
    }
    for (;;)
    {
      if (this.mActionBar != null) {
        this.mActionBar.v(this.gB);
      }
      AppMethodBeat.o(238214);
      return;
      if ((this.fU instanceof Dialog)) {
        this.mActionBar = new j((Dialog)this.fU);
      }
    }
  }
  
  private Context aN()
  {
    AppMethodBeat.i(238217);
    Context localContext = null;
    Object localObject = getSupportActionBar();
    if (localObject != null) {
      localContext = ((ActionBar)localObject).aD();
    }
    localObject = localContext;
    if (localContext == null) {
      localObject = this.mContext;
    }
    AppMethodBeat.o(238217);
    return localObject;
  }
  
  private void aO()
  {
    AppMethodBeat.i(238242);
    Object localObject;
    if (!this.gh)
    {
      this.gi = aP();
      localObject = getTitle();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (this.fY == null) {
          break label96;
        }
        this.fY.setWindowTitle((CharSequence)localObject);
      }
    }
    for (;;)
    {
      aQ();
      this.gh = true;
      localObject = R(0);
      if ((!this.mIsDestroyed) && ((localObject == null) || (((PanelFeatureState)localObject).gU == null))) {
        S(108);
      }
      AppMethodBeat.o(238242);
      return;
      label96:
      if (this.mActionBar != null) {
        this.mActionBar.setWindowTitle((CharSequence)localObject);
      } else if (this.eM != null) {
        this.eM.setText((CharSequence)localObject);
      }
    }
  }
  
  private ViewGroup aP()
  {
    AppMethodBeat.i(238247);
    Object localObject = this.mContext.obtainStyledAttributes(a.j.AppCompatTheme);
    if (!((TypedArray)localObject).hasValue(a.j.AppCompatTheme_windowActionBar))
    {
      ((TypedArray)localObject).recycle();
      localObject = new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
      AppMethodBeat.o(238247);
      throw ((Throwable)localObject);
    }
    if (((TypedArray)localObject).getBoolean(a.j.AppCompatTheme_windowNoTitle, false))
    {
      P(1);
      if (((TypedArray)localObject).getBoolean(a.j.AppCompatTheme_windowActionBarOverlay, false)) {
        P(109);
      }
      if (((TypedArray)localObject).getBoolean(a.j.AppCompatTheme_windowActionModeOverlay, false)) {
        P(10);
      }
      this.gp = ((TypedArray)localObject).getBoolean(a.j.AppCompatTheme_android_windowIsFloating, false);
      ((TypedArray)localObject).recycle();
      this.em.getDecorView();
      localObject = LayoutInflater.from(this.mContext);
      if (this.gq) {
        break label452;
      }
      if (!this.gp) {
        break label290;
      }
      localObject = (ViewGroup)((LayoutInflater)localObject).inflate(a.g.abc_dialog_title_material, null);
      this.gn = false;
      this.gm = false;
    }
    for (;;)
    {
      if (localObject == null)
      {
        localObject = new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.gm + ", windowActionBarOverlay: " + this.gn + ", android:windowIsFloating: " + this.gp + ", windowActionModeOverlay: " + this.go + ", windowNoTitle: " + this.gq + " }");
        AppMethodBeat.o(238247);
        throw ((Throwable)localObject);
        if (!((TypedArray)localObject).getBoolean(a.j.AppCompatTheme_windowActionBar, false)) {
          break;
        }
        P(108);
        break;
        label290:
        if (!this.gm) {
          break label666;
        }
        localObject = new TypedValue();
        this.mContext.getTheme().resolveAttribute(androidx.appcompat.a.a.actionBarTheme, (TypedValue)localObject, true);
        if (((TypedValue)localObject).resourceId != 0) {}
        for (localObject = new androidx.appcompat.view.d(this.mContext, ((TypedValue)localObject).resourceId);; localObject = this.mContext)
        {
          localObject = (ViewGroup)LayoutInflater.from((Context)localObject).inflate(a.g.abc_screen_toolbar, null);
          this.fY = ((m)((ViewGroup)localObject).findViewById(a.f.decor_content_parent));
          this.fY.setWindowCallback(this.em.getCallback());
          if (this.gn) {
            this.fY.al(109);
          }
          if (this.gk) {
            this.fY.al(2);
          }
          if (this.gl) {
            this.fY.al(5);
          }
          break;
        }
        label452:
        if (this.go) {}
        for (localObject = (ViewGroup)((LayoutInflater)localObject).inflate(a.g.abc_screen_simple_overlay_action_mode, null);; localObject = (ViewGroup)((LayoutInflater)localObject).inflate(a.g.abc_screen_simple, null))
        {
          if (Build.VERSION.SDK_INT < 21) {
            break label509;
          }
          w.a((View)localObject, new s()
          {
            public final ae a(View paramAnonymousView, ae paramAnonymousae)
            {
              AppMethodBeat.i(238098);
              int i = paramAnonymousae.Oa.hp().top;
              int j = AppCompatDelegateImpl.this.U(i);
              ae localae = paramAnonymousae;
              if (i != j) {
                localae = paramAnonymousae.f(paramAnonymousae.Oa.hp().left, j, paramAnonymousae.Oa.hp().right, paramAnonymousae.Oa.hp().bottom);
              }
              paramAnonymousView = w.a(paramAnonymousView, localae);
              AppMethodBeat.o(238098);
              return paramAnonymousView;
            }
          });
          break;
        }
        label509:
        ((q)localObject).setOnFitSystemWindowsListener(new q.a()
        {
          public final void a(Rect paramAnonymousRect)
          {
            AppMethodBeat.i(238100);
            paramAnonymousRect.top = AppCompatDelegateImpl.this.U(paramAnonymousRect.top);
            AppMethodBeat.o(238100);
          }
        });
        continue;
      }
      if (this.fY == null) {
        this.eM = ((TextView)((ViewGroup)localObject).findViewById(a.f.title));
      }
      ai.t((View)localObject);
      ContentFrameLayout localContentFrameLayout = (ContentFrameLayout)((ViewGroup)localObject).findViewById(a.f.action_bar_activity_content);
      ViewGroup localViewGroup = (ViewGroup)this.em.findViewById(16908290);
      if (localViewGroup != null)
      {
        while (localViewGroup.getChildCount() > 0)
        {
          View localView = localViewGroup.getChildAt(0);
          localViewGroup.removeViewAt(0);
          localContentFrameLayout.addView(localView);
        }
        localViewGroup.setId(-1);
        localContentFrameLayout.setId(16908290);
        if ((localViewGroup instanceof FrameLayout)) {
          ((FrameLayout)localViewGroup).setForeground(null);
        }
      }
      this.em.setContentView((View)localObject);
      localContentFrameLayout.setAttachListener(new ContentFrameLayout.a()
      {
        public final void onDetachedFromWindow()
        {
          AppMethodBeat.i(238105);
          AppCompatDelegateImpl.this.aV();
          AppMethodBeat.o(238105);
        }
      });
      AppMethodBeat.o(238247);
      return localObject;
      label666:
      localObject = null;
    }
  }
  
  private void aQ()
  {
    AppMethodBeat.i(238249);
    ContentFrameLayout localContentFrameLayout = (ContentFrameLayout)this.gi.findViewById(16908290);
    Object localObject = this.em.getDecorView();
    localContentFrameLayout.b(((View)localObject).getPaddingLeft(), ((View)localObject).getPaddingTop(), ((View)localObject).getPaddingRight(), ((View)localObject).getPaddingBottom());
    localObject = this.mContext.obtainStyledAttributes(a.j.AppCompatTheme);
    ((TypedArray)localObject).getValue(a.j.AppCompatTheme_windowMinWidthMajor, localContentFrameLayout.getMinWidthMajor());
    ((TypedArray)localObject).getValue(a.j.AppCompatTheme_windowMinWidthMinor, localContentFrameLayout.getMinWidthMinor());
    if (((TypedArray)localObject).hasValue(a.j.AppCompatTheme_windowFixedWidthMajor)) {
      ((TypedArray)localObject).getValue(a.j.AppCompatTheme_windowFixedWidthMajor, localContentFrameLayout.getFixedWidthMajor());
    }
    if (((TypedArray)localObject).hasValue(a.j.AppCompatTheme_windowFixedWidthMinor)) {
      ((TypedArray)localObject).getValue(a.j.AppCompatTheme_windowFixedWidthMinor, localContentFrameLayout.getFixedWidthMinor());
    }
    if (((TypedArray)localObject).hasValue(a.j.AppCompatTheme_windowFixedHeightMajor)) {
      ((TypedArray)localObject).getValue(a.j.AppCompatTheme_windowFixedHeightMajor, localContentFrameLayout.getFixedHeightMajor());
    }
    if (((TypedArray)localObject).hasValue(a.j.AppCompatTheme_windowFixedHeightMinor)) {
      ((TypedArray)localObject).getValue(a.j.AppCompatTheme_windowFixedHeightMinor, localContentFrameLayout.getFixedHeightMinor());
    }
    ((TypedArray)localObject).recycle();
    localContentFrameLayout.requestLayout();
    AppMethodBeat.o(238249);
  }
  
  private void aU()
  {
    AppMethodBeat.i(238310);
    if (this.gh)
    {
      AndroidRuntimeException localAndroidRuntimeException = new AndroidRuntimeException("Window feature must be requested before adding content");
      AppMethodBeat.o(238310);
      throw localAndroidRuntimeException;
    }
    AppMethodBeat.o(238310);
  }
  
  private int aW()
  {
    AppMethodBeat.i(238326);
    if (this.gv != -100)
    {
      i = this.gv;
      AppMethodBeat.o(238326);
      return i;
    }
    int i = aL();
    AppMethodBeat.o(238326);
    return i;
  }
  
  private void aX()
  {
    AppMethodBeat.i(238334);
    if (this.gx == null) {
      this.gx = new e(i.H(this.mContext));
    }
    AppMethodBeat.o(238334);
  }
  
  private boolean aY()
  {
    AppMethodBeat.i(238336);
    if ((this.gw) && ((this.mContext instanceof Activity)))
    {
      PackageManager localPackageManager = this.mContext.getPackageManager();
      try
      {
        if ((localPackageManager.getActivityInfo(new ComponentName(this.mContext, this.mContext.getClass()), 0).configChanges & 0x200) == 0)
        {
          AppMethodBeat.o(238336);
          return true;
        }
        AppMethodBeat.o(238336);
        return false;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(238336);
        return true;
      }
    }
    AppMethodBeat.o(238336);
    return false;
  }
  
  private b b(b.a parama)
  {
    AppMethodBeat.i(238270);
    aS();
    if (this.gb != null) {
      this.gb.finish();
    }
    if ((this.fW != null) && (!this.mIsDestroyed)) {}
    for (;;)
    {
      try
      {
        b localb = this.fW.onWindowStartingSupportActionMode(parama);
        if (localb == null) {
          break label109;
        }
        this.gb = localb;
        if ((this.gb != null) && (this.fW != null)) {
          this.fW.onSupportActionModeStarted(this.gb);
        }
        parama = this.gb;
        AppMethodBeat.o(238270);
        return parama;
      }
      catch (AbstractMethodError localAbstractMethodError) {}
      Object localObject1 = null;
      continue;
      label109:
      Object localObject2;
      label215:
      boolean bool;
      if (this.gc == null)
      {
        if (!this.gp) {
          break label506;
        }
        localObject2 = new TypedValue();
        localObject1 = this.mContext.getTheme();
        ((Resources.Theme)localObject1).resolveAttribute(androidx.appcompat.a.a.actionBarTheme, (TypedValue)localObject2, true);
        if (((TypedValue)localObject2).resourceId != 0)
        {
          Resources.Theme localTheme = this.mContext.getResources().newTheme();
          localTheme.setTo((Resources.Theme)localObject1);
          localTheme.applyStyle(((TypedValue)localObject2).resourceId, true);
          localObject1 = new androidx.appcompat.view.d(this.mContext, 0);
          ((Context)localObject1).getTheme().setTo(localTheme);
          this.gc = new ActionBarContextView((Context)localObject1);
          this.gd = new PopupWindow((Context)localObject1, null, androidx.appcompat.a.a.actionModePopupWindowStyle);
          androidx.core.widget.g.a(this.gd, 2);
          this.gd.setContentView(this.gc);
          this.gd.setWidth(-1);
          ((Context)localObject1).getTheme().resolveAttribute(androidx.appcompat.a.a.actionBarSize, (TypedValue)localObject2, true);
          int i = TypedValue.complexToDimensionPixelSize(((TypedValue)localObject2).data, ((Context)localObject1).getResources().getDisplayMetrics());
          this.gc.setContentHeight(i);
          this.gd.setHeight(-2);
          this.ge = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(238110);
              AppCompatDelegateImpl.this.gd.showAtLocation(AppCompatDelegateImpl.this.gc, 55, 0, 0);
              AppCompatDelegateImpl.this.aS();
              if (AppCompatDelegateImpl.this.aR())
              {
                AppCompatDelegateImpl.this.gc.setAlpha(0.0F);
                AppCompatDelegateImpl.this.gf = w.Q(AppCompatDelegateImpl.this.gc).i(1.0F);
                AppCompatDelegateImpl.this.gf.b(new androidx.core.g.ac()
                {
                  public final void e(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(238106);
                    AppCompatDelegateImpl.this.gc.setVisibility(0);
                    AppMethodBeat.o(238106);
                  }
                  
                  public final void f(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(238107);
                    AppCompatDelegateImpl.this.gc.setAlpha(1.0F);
                    AppCompatDelegateImpl.this.gf.b(null);
                    AppCompatDelegateImpl.this.gf = null;
                    AppMethodBeat.o(238107);
                  }
                });
                AppMethodBeat.o(238110);
                return;
              }
              AppCompatDelegateImpl.this.gc.setAlpha(1.0F);
              AppCompatDelegateImpl.this.gc.setVisibility(0);
              AppMethodBeat.o(238110);
            }
          };
        }
      }
      else
      {
        label333:
        if (this.gc == null) {
          break label551;
        }
        aS();
        this.gc.cF();
        localObject1 = this.gc.getContext();
        localObject2 = this.gc;
        if (this.gd != null) {
          break label553;
        }
        bool = true;
        label375:
        localObject1 = new androidx.appcompat.view.e((Context)localObject1, (ActionBarContextView)localObject2, parama, bool);
        if (!parama.a((b)localObject1, ((b)localObject1).getMenu())) {
          break label612;
        }
        ((b)localObject1).invalidate();
        this.gc.c((b)localObject1);
        this.gb = ((b)localObject1);
        if (!aR()) {
          break label558;
        }
        this.gc.setAlpha(0.0F);
        this.gf = w.Q(this.gc).i(1.0F);
        this.gf.b(new androidx.core.g.ac()
        {
          public final void e(View paramAnonymousView)
          {
            AppMethodBeat.i(238111);
            AppCompatDelegateImpl.this.gc.setVisibility(0);
            AppCompatDelegateImpl.this.gc.sendAccessibilityEvent(32);
            if ((AppCompatDelegateImpl.this.gc.getParent() instanceof View)) {
              w.Y((View)AppCompatDelegateImpl.this.gc.getParent());
            }
            AppMethodBeat.o(238111);
          }
          
          public final void f(View paramAnonymousView)
          {
            AppMethodBeat.i(238114);
            AppCompatDelegateImpl.this.gc.setAlpha(1.0F);
            AppCompatDelegateImpl.this.gf.b(null);
            AppCompatDelegateImpl.this.gf = null;
            AppMethodBeat.o(238114);
          }
        });
      }
      for (;;)
      {
        if (this.gd == null) {
          break label610;
        }
        this.em.getDecorView().post(this.ge);
        break;
        localObject1 = this.mContext;
        break label215;
        label506:
        localObject1 = (ViewStubCompat)this.gi.findViewById(a.f.action_mode_bar_stub);
        if (localObject1 == null) {
          break label333;
        }
        ((ViewStubCompat)localObject1).setLayoutInflater(LayoutInflater.from(aN()));
        this.gc = ((ActionBarContextView)((ViewStubCompat)localObject1).eI());
        break label333;
        label551:
        break;
        label553:
        bool = false;
        break label375;
        label558:
        this.gc.setAlpha(1.0F);
        this.gc.setVisibility(0);
        this.gc.sendAccessibilityEvent(32);
        if ((this.gc.getParent() instanceof View)) {
          w.Y((View)this.gc.getParent());
        }
      }
      label610:
      continue;
      label612:
      this.gb = null;
    }
  }
  
  private boolean b(PanelFeatureState paramPanelFeatureState)
  {
    AppMethodBeat.i(238295);
    Context localContext = this.mContext;
    TypedValue localTypedValue;
    Resources.Theme localTheme;
    Object localObject1;
    if (((paramPanelFeatureState.gP == 0) || (paramPanelFeatureState.gP == 108)) && (this.fY != null))
    {
      localTypedValue = new TypedValue();
      localTheme = localContext.getTheme();
      localTheme.resolveAttribute(androidx.appcompat.a.a.actionBarTheme, localTypedValue, true);
      localObject1 = null;
      if (localTypedValue.resourceId != 0)
      {
        localObject1 = localContext.getResources().newTheme();
        ((Resources.Theme)localObject1).setTo(localTheme);
        ((Resources.Theme)localObject1).applyStyle(localTypedValue.resourceId, true);
        ((Resources.Theme)localObject1).resolveAttribute(androidx.appcompat.a.a.actionBarWidgetTheme, localTypedValue, true);
        Object localObject2 = localObject1;
        if (localTypedValue.resourceId != 0)
        {
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = localContext.getResources().newTheme();
            ((Resources.Theme)localObject2).setTo(localTheme);
          }
          ((Resources.Theme)localObject2).applyStyle(localTypedValue.resourceId, true);
        }
        if (localObject2 == null) {
          break label215;
        }
        localObject1 = new androidx.appcompat.view.d(localContext, 0);
        ((Context)localObject1).getTheme().setTo((Resources.Theme)localObject2);
      }
    }
    for (;;)
    {
      localObject1 = new h((Context)localObject1);
      ((h)localObject1).a(this);
      paramPanelFeatureState.d((h)localObject1);
      AppMethodBeat.o(238295);
      return true;
      localTheme.resolveAttribute(androidx.appcompat.a.a.actionBarWidgetTheme, localTypedValue, true);
      break;
      label215:
      localObject1 = localContext;
    }
  }
  
  private boolean b(PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(238297);
    if (this.mIsDestroyed)
    {
      AppMethodBeat.o(238297);
      return false;
    }
    if (paramPanelFeatureState.gX)
    {
      AppMethodBeat.o(238297);
      return true;
    }
    if ((this.gt != null) && (this.gt != paramPanelFeatureState)) {
      a(this.gt, false);
    }
    Window.Callback localCallback = this.em.getCallback();
    if (localCallback != null) {
      paramPanelFeatureState.gT = localCallback.onCreatePanelView(paramPanelFeatureState.gP);
    }
    if ((paramPanelFeatureState.gP == 0) || (paramPanelFeatureState.gP == 108)) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (this.fY != null)) {
        this.fY.cM();
      }
      if ((paramPanelFeatureState.gT != null) || ((i != 0) && ((this.mActionBar instanceof g)))) {
        break label446;
      }
      if ((paramPanelFeatureState.gU != null) && (!paramPanelFeatureState.hc)) {
        break label310;
      }
      if (paramPanelFeatureState.gU != null) {
        break;
      }
      b(paramPanelFeatureState);
      if (paramPanelFeatureState.gU != null) {
        break;
      }
      AppMethodBeat.o(238297);
      return false;
    }
    if ((i != 0) && (this.fY != null))
    {
      if (this.fZ == null) {
        this.fZ = new b();
      }
      this.fY.a(paramPanelFeatureState.gU, this.fZ);
    }
    paramPanelFeatureState.gU.ce();
    if (!localCallback.onCreatePanelMenu(paramPanelFeatureState.gP, paramPanelFeatureState.gU))
    {
      paramPanelFeatureState.d(null);
      if ((i != 0) && (this.fY != null)) {
        this.fY.a(null, this.fZ);
      }
      AppMethodBeat.o(238297);
      return false;
    }
    paramPanelFeatureState.hc = false;
    label310:
    paramPanelFeatureState.gU.ce();
    if (paramPanelFeatureState.hd != null)
    {
      paramPanelFeatureState.gU.h(paramPanelFeatureState.hd);
      paramPanelFeatureState.hd = null;
    }
    if (!localCallback.onPreparePanel(0, paramPanelFeatureState.gT, paramPanelFeatureState.gU))
    {
      if ((i != 0) && (this.fY != null)) {
        this.fY.a(null, this.fZ);
      }
      paramPanelFeatureState.gU.cf();
      AppMethodBeat.o(238297);
      return false;
    }
    if (paramKeyEvent != null)
    {
      i = paramKeyEvent.getDeviceId();
      if (KeyCharacterMap.load(i).getKeyboardType() == 1) {
        break label474;
      }
    }
    label446:
    label474:
    for (boolean bool = true;; bool = false)
    {
      paramPanelFeatureState.ha = bool;
      paramPanelFeatureState.gU.setQwertyMode(paramPanelFeatureState.ha);
      paramPanelFeatureState.gU.cf();
      paramPanelFeatureState.gX = true;
      paramPanelFeatureState.gY = false;
      this.gt = paramPanelFeatureState;
      AppMethodBeat.o(238297);
      return true;
      i = -1;
      break;
    }
  }
  
  private boolean c(PanelFeatureState paramPanelFeatureState)
  {
    AppMethodBeat.i(238296);
    if (paramPanelFeatureState.gT != null)
    {
      paramPanelFeatureState.gS = paramPanelFeatureState.gT;
      AppMethodBeat.o(238296);
      return true;
    }
    if (paramPanelFeatureState.gU == null)
    {
      AppMethodBeat.o(238296);
      return false;
    }
    if (this.ga == null) {
      this.ga = new g();
    }
    paramPanelFeatureState.gS = ((View)paramPanelFeatureState.a(this.ga));
    if (paramPanelFeatureState.gS != null)
    {
      AppMethodBeat.o(238296);
      return true;
    }
    AppMethodBeat.o(238296);
    return false;
  }
  
  private CharSequence getTitle()
  {
    AppMethodBeat.i(238256);
    if ((this.fU instanceof Activity))
    {
      localCharSequence = ((Activity)this.fU).getTitle();
      AppMethodBeat.o(238256);
      return localCharSequence;
    }
    CharSequence localCharSequence = this.cZ;
    AppMethodBeat.o(238256);
    return localCharSequence;
  }
  
  public final boolean P(int paramInt)
  {
    AppMethodBeat.i(238252);
    paramInt = V(paramInt);
    if ((this.gq) && (paramInt == 108))
    {
      AppMethodBeat.o(238252);
      return false;
    }
    if ((this.gm) && (paramInt == 1)) {
      this.gm = false;
    }
    switch (paramInt)
    {
    default: 
      boolean bool = this.em.requestFeature(paramInt);
      AppMethodBeat.o(238252);
      return bool;
    case 108: 
      aU();
      this.gm = true;
      AppMethodBeat.o(238252);
      return true;
    case 109: 
      aU();
      this.gn = true;
      AppMethodBeat.o(238252);
      return true;
    case 10: 
      aU();
      this.go = true;
      AppMethodBeat.o(238252);
      return true;
    case 2: 
      aU();
      this.gk = true;
      AppMethodBeat.o(238252);
      return true;
    case 5: 
      aU();
      this.gl = true;
      AppMethodBeat.o(238252);
      return true;
    }
    aU();
    this.gq = true;
    AppMethodBeat.o(238252);
    return true;
  }
  
  final void Q(int paramInt)
  {
    AppMethodBeat.i(238257);
    Object localObject;
    if (paramInt == 108)
    {
      localObject = getSupportActionBar();
      if (localObject != null) {
        ((ActionBar)localObject).x(false);
      }
      AppMethodBeat.o(238257);
      return;
    }
    if (paramInt == 0)
    {
      localObject = R(paramInt);
      if (((PanelFeatureState)localObject).gZ) {
        a((PanelFeatureState)localObject, false);
      }
    }
    AppMethodBeat.o(238257);
  }
  
  protected final PanelFeatureState R(int paramInt)
  {
    AppMethodBeat.i(238302);
    Object localObject2 = this.gs;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length > paramInt) {}
    }
    else
    {
      localObject1 = new PanelFeatureState[paramInt + 1];
      if (localObject2 != null) {
        System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
      }
      this.gs = ((PanelFeatureState[])localObject1);
    }
    localObject2 = localObject1[paramInt];
    if (localObject2 == null)
    {
      localObject2 = new PanelFeatureState(paramInt);
      localObject1[paramInt] = localObject2;
    }
    for (Object localObject1 = localObject2;; localObject1 = localObject2)
    {
      AppMethodBeat.o(238302);
      return localObject1;
    }
  }
  
  final void T(int paramInt)
  {
    AppMethodBeat.i(238305);
    PanelFeatureState localPanelFeatureState = R(paramInt);
    if (localPanelFeatureState.gU != null)
    {
      Bundle localBundle = new Bundle();
      localPanelFeatureState.gU.g(localBundle);
      if (localBundle.size() > 0) {
        localPanelFeatureState.hd = localBundle;
      }
      localPanelFeatureState.gU.ce();
      localPanelFeatureState.gU.clear();
    }
    localPanelFeatureState.hc = true;
    localPanelFeatureState.hb = true;
    if (((paramInt == 108) || (paramInt == 0)) && (this.fY != null))
    {
      localPanelFeatureState = R(0);
      if (localPanelFeatureState != null)
      {
        localPanelFeatureState.gX = false;
        b(localPanelFeatureState, null);
      }
    }
    AppMethodBeat.o(238305);
  }
  
  final int U(int paramInt)
  {
    int j = 1;
    int m = 0;
    AppMethodBeat.i(238307);
    Object localObject1;
    Object localObject2;
    int i;
    if ((this.gc != null) && ((this.gc.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      localObject1 = (ViewGroup.MarginLayoutParams)this.gc.getLayoutParams();
      if (this.gc.isShown())
      {
        if (this.gC == null)
        {
          this.gC = new Rect();
          this.gD = new Rect();
        }
        localObject2 = this.gC;
        Rect localRect = this.gD;
        ((Rect)localObject2).set(0, paramInt, 0, 0);
        ai.a(this.gi, (Rect)localObject2, localRect);
        if (localRect.top == 0)
        {
          i = paramInt;
          if (((ViewGroup.MarginLayoutParams)localObject1).topMargin == i) {
            break label363;
          }
          ((ViewGroup.MarginLayoutParams)localObject1).topMargin = paramInt;
          if (this.gj != null) {
            break label286;
          }
          this.gj = new View(this.mContext);
          this.gj.setBackgroundColor(this.mContext.getResources().getColor(a.c.abc_input_method_navigation_guard));
          this.gi.addView(this.gj, -1, new ViewGroup.LayoutParams(-1, paramInt));
          i = 1;
          label204:
          if (this.gj == null) {
            break label324;
          }
          label211:
          int k = paramInt;
          if (!this.go)
          {
            k = paramInt;
            if (j != 0) {
              k = 0;
            }
          }
          paramInt = k;
          label234:
          if (i != 0) {
            this.gc.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
        }
      }
    }
    for (;;)
    {
      if (this.gj != null)
      {
        localObject1 = this.gj;
        if (j == 0) {
          break label350;
        }
      }
      label286:
      label324:
      label350:
      for (i = m;; i = 8)
      {
        ((View)localObject1).setVisibility(i);
        AppMethodBeat.o(238307);
        return paramInt;
        i = 0;
        break;
        localObject2 = this.gj.getLayoutParams();
        if (((ViewGroup.LayoutParams)localObject2).height != paramInt)
        {
          ((ViewGroup.LayoutParams)localObject2).height = paramInt;
          this.gj.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        i = 1;
        break label204;
        j = 0;
        break label211;
        if (((ViewGroup.MarginLayoutParams)localObject1).topMargin == 0) {
          break label356;
        }
        ((ViewGroup.MarginLayoutParams)localObject1).topMargin = 0;
        i = 1;
        j = 0;
        break label234;
      }
      label356:
      i = 0;
      j = 0;
      break label234;
      label363:
      i = 0;
      break label204;
      j = 0;
    }
  }
  
  final PanelFeatureState a(Menu paramMenu)
  {
    PanelFeatureState[] arrayOfPanelFeatureState = this.gs;
    int i;
    int j;
    if (arrayOfPanelFeatureState != null)
    {
      i = arrayOfPanelFeatureState.length;
      j = 0;
    }
    for (;;)
    {
      if (j >= i) {
        break label57;
      }
      PanelFeatureState localPanelFeatureState = arrayOfPanelFeatureState[j];
      if ((localPanelFeatureState != null) && (localPanelFeatureState.gU == paramMenu))
      {
        return localPanelFeatureState;
        i = 0;
        break;
      }
      j += 1;
    }
    label57:
    return null;
  }
  
  final void a(int paramInt, PanelFeatureState paramPanelFeatureState, Menu paramMenu)
  {
    AppMethodBeat.i(238301);
    Object localObject1 = paramPanelFeatureState;
    Object localObject2 = paramMenu;
    if (paramMenu == null)
    {
      PanelFeatureState localPanelFeatureState = paramPanelFeatureState;
      if (paramPanelFeatureState == null)
      {
        localPanelFeatureState = paramPanelFeatureState;
        if (paramInt >= 0)
        {
          localPanelFeatureState = paramPanelFeatureState;
          if (paramInt < this.gs.length) {
            localPanelFeatureState = this.gs[paramInt];
          }
        }
      }
      localObject1 = localPanelFeatureState;
      localObject2 = paramMenu;
      if (localPanelFeatureState != null)
      {
        localObject2 = localPanelFeatureState.gU;
        localObject1 = localPanelFeatureState;
      }
    }
    if ((localObject1 != null) && (!((PanelFeatureState)localObject1).gZ))
    {
      AppMethodBeat.o(238301);
      return;
    }
    if (!this.mIsDestroyed) {
      this.fU.onPanelClosed(paramInt, (Menu)localObject2);
    }
    AppMethodBeat.o(238301);
  }
  
  final void a(PanelFeatureState paramPanelFeatureState, boolean paramBoolean)
  {
    AppMethodBeat.i(238300);
    if ((paramBoolean) && (paramPanelFeatureState.gP == 0) && (this.fY != null) && (this.fY.cJ()))
    {
      b(paramPanelFeatureState.gU);
      AppMethodBeat.o(238300);
      return;
    }
    WindowManager localWindowManager = (WindowManager)this.mContext.getSystemService("window");
    if ((localWindowManager != null) && (paramPanelFeatureState.gZ) && (paramPanelFeatureState.gR != null))
    {
      localWindowManager.removeView(paramPanelFeatureState.gR);
      if (paramBoolean) {
        a(paramPanelFeatureState.gP, paramPanelFeatureState, null);
      }
    }
    paramPanelFeatureState.gX = false;
    paramPanelFeatureState.gY = false;
    paramPanelFeatureState.gZ = false;
    paramPanelFeatureState.gS = null;
    paramPanelFeatureState.hb = true;
    if (this.gt == paramPanelFeatureState) {
      this.gt = null;
    }
    AppMethodBeat.o(238300);
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(238261);
    if ((this.fY != null) && (this.fY.cI()) && ((!ViewConfiguration.get(this.mContext).hasPermanentMenuKey()) || (this.fY.cK())))
    {
      paramh = this.em.getCallback();
      if (!this.fY.cJ())
      {
        if ((paramh != null) && (!this.mIsDestroyed))
        {
          if ((this.gy) && ((this.gz & 0x1) != 0))
          {
            this.em.getDecorView().removeCallbacks(this.gA);
            this.gA.run();
          }
          PanelFeatureState localPanelFeatureState = R(0);
          if ((localPanelFeatureState.gU != null) && (!localPanelFeatureState.hc) && (paramh.onPreparePanel(0, localPanelFeatureState.gT, localPanelFeatureState.gU)))
          {
            paramh.onMenuOpened(108, localPanelFeatureState.gU);
            this.fY.cC();
          }
          AppMethodBeat.o(238261);
        }
      }
      else
      {
        this.fY.cL();
        if (!this.mIsDestroyed) {
          paramh.onPanelClosed(108, R(0).gU);
        }
      }
      AppMethodBeat.o(238261);
      return;
    }
    paramh = R(0);
    paramh.hb = true;
    a(paramh, false);
    a(paramh, null);
    AppMethodBeat.o(238261);
  }
  
  public final boolean a(h paramh, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(238259);
    Window.Callback localCallback = this.em.getCallback();
    if ((localCallback != null) && (!this.mIsDestroyed))
    {
      paramh = a(paramh.cl());
      if (paramh != null)
      {
        boolean bool = localCallback.onMenuItemSelected(paramh.gP, paramMenuItem);
        AppMethodBeat.o(238259);
        return bool;
      }
    }
    AppMethodBeat.o(238259);
    return false;
  }
  
  public final void aI()
  {
    AppMethodBeat.i(238212);
    aO();
    AppMethodBeat.o(238212);
  }
  
  public final void aJ()
  {
    AppMethodBeat.i(238289);
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.mContext);
    if (localLayoutInflater.getFactory() == null)
    {
      androidx.core.g.g.b(localLayoutInflater, this);
      AppMethodBeat.o(238289);
      return;
    }
    localLayoutInflater.getFactory2();
    AppMethodBeat.o(238289);
  }
  
  public final boolean aK()
  {
    AppMethodBeat.i(238318);
    boolean bool = false;
    int i = aW();
    int j = W(i);
    if (j != -1) {
      bool = X(j);
    }
    if (i == 0)
    {
      aX();
      this.gx.setup();
    }
    this.gw = true;
    AppMethodBeat.o(238318);
    return bool;
  }
  
  final boolean aR()
  {
    AppMethodBeat.i(238272);
    if ((this.gh) && (this.gi != null) && (w.ah(this.gi)))
    {
      AppMethodBeat.o(238272);
      return true;
    }
    AppMethodBeat.o(238272);
    return false;
  }
  
  final void aS()
  {
    AppMethodBeat.i(238274);
    if (this.gf != null) {
      this.gf.cancel();
    }
    AppMethodBeat.o(238274);
  }
  
  final void aT()
  {
    AppMethodBeat.i(238299);
    a(R(0), true);
    AppMethodBeat.o(238299);
  }
  
  final void aV()
  {
    AppMethodBeat.i(238313);
    if (this.fY != null) {
      this.fY.aV();
    }
    if (this.gd != null)
    {
      this.em.getDecorView().removeCallbacks(this.ge);
      if (!this.gd.isShowing()) {}
    }
    try
    {
      this.gd.dismiss();
      label61:
      this.gd = null;
      aS();
      PanelFeatureState localPanelFeatureState = R(0);
      if ((localPanelFeatureState != null) && (localPanelFeatureState.gU != null)) {
        localPanelFeatureState.gU.close();
      }
      AppMethodBeat.o(238313);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label61;
    }
  }
  
  public final void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(238236);
    aO();
    ((ViewGroup)this.gi.findViewById(16908290)).addView(paramView, paramLayoutParams);
    this.fU.onContentChanged();
    AppMethodBeat.o(238236);
  }
  
  final void b(h paramh)
  {
    AppMethodBeat.i(238298);
    if (this.gr)
    {
      AppMethodBeat.o(238298);
      return;
    }
    this.gr = true;
    this.fY.aV();
    Window.Callback localCallback = this.em.getCallback();
    if ((localCallback != null) && (!this.mIsDestroyed)) {
      localCallback.onPanelClosed(108, paramh);
    }
    this.gr = false;
    AppMethodBeat.o(238298);
  }
  
  final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(238282);
    Object localObject;
    if (((this.fU instanceof androidx.core.g.f.a)) || ((this.fU instanceof e)))
    {
      localObject = this.em.getDecorView();
      if ((localObject != null) && (androidx.core.g.f.a((View)localObject, paramKeyEvent)))
      {
        AppMethodBeat.o(238282);
        return true;
      }
    }
    if ((paramKeyEvent.getKeyCode() == 82) && (this.fU.dispatchKeyEvent(paramKeyEvent)))
    {
      AppMethodBeat.o(238282);
      return true;
    }
    int j = paramKeyEvent.getKeyCode();
    int i;
    if (paramKeyEvent.getAction() == 0) {
      i = 1;
    }
    while (i != 0) {
      switch (j)
      {
      default: 
        AppMethodBeat.o(238282);
        return false;
        i = 0;
        break;
      case 82: 
        if (paramKeyEvent.getRepeatCount() == 0)
        {
          localObject = R(0);
          if (!((PanelFeatureState)localObject).gZ) {
            b((PanelFeatureState)localObject, paramKeyEvent);
          }
        }
        AppMethodBeat.o(238282);
        return true;
      case 4: 
        if ((paramKeyEvent.getFlags() & 0x80) != 0) {}
        for (bool = true;; bool = false)
        {
          this.gu = bool;
          break;
        }
      }
    }
    switch (j)
    {
    default: 
      AppMethodBeat.o(238282);
      return false;
    case 82: 
      if (this.gb == null)
      {
        localObject = R(0);
        if ((this.fY == null) || (!this.fY.cI()) || (ViewConfiguration.get(this.mContext).hasPermanentMenuKey())) {
          break label384;
        }
        if (this.fY.cJ()) {
          break label370;
        }
        if ((this.mIsDestroyed) || (!b((PanelFeatureState)localObject, paramKeyEvent))) {
          break;
        }
        bool = this.fY.cC();
      }
      for (;;)
      {
        label334:
        if (bool)
        {
          paramKeyEvent = (AudioManager)this.mContext.getSystemService("audio");
          if (paramKeyEvent != null) {
            paramKeyEvent.playSoundEffect(0);
          }
        }
        AppMethodBeat.o(238282);
        return true;
        label370:
        bool = this.fY.cL();
        continue;
        label384:
        if ((!((PanelFeatureState)localObject).gZ) && (!((PanelFeatureState)localObject).gY)) {
          break;
        }
        bool = ((PanelFeatureState)localObject).gZ;
        a((PanelFeatureState)localObject, true);
      }
      if (((PanelFeatureState)localObject).gX)
      {
        if (!((PanelFeatureState)localObject).hc) {
          break label573;
        }
        ((PanelFeatureState)localObject).gX = false;
      }
      break;
    }
    label573:
    for (boolean bool = b((PanelFeatureState)localObject, paramKeyEvent);; bool = true)
    {
      if (bool)
      {
        a((PanelFeatureState)localObject, paramKeyEvent);
        bool = true;
        break label334;
        bool = this.gu;
        this.gu = false;
        paramKeyEvent = R(0);
        if ((paramKeyEvent != null) && (paramKeyEvent.gZ))
        {
          if (!bool) {
            a(paramKeyEvent, true);
          }
          AppMethodBeat.o(238282);
          return true;
        }
        if (this.gb != null)
        {
          this.gb.finish();
          i = 1;
        }
        while (i != 0)
        {
          AppMethodBeat.o(238282);
          return true;
          paramKeyEvent = getSupportActionBar();
          if ((paramKeyEvent != null) && (paramKeyEvent.collapseActionView())) {
            i = 1;
          } else {
            i = 0;
          }
        }
        break;
      }
      bool = false;
      break label334;
    }
  }
  
  public final <T extends View> T findViewById(int paramInt)
  {
    AppMethodBeat.i(238220);
    aO();
    View localView = this.em.findViewById(paramInt);
    AppMethodBeat.o(238220);
    return localView;
  }
  
  public final a.a getDrawerToggleDelegate()
  {
    AppMethodBeat.i(238338);
    a locala = new a();
    AppMethodBeat.o(238338);
    return locala;
  }
  
  public final MenuInflater getMenuInflater()
  {
    AppMethodBeat.i(238219);
    if (this.fX == null)
    {
      aM();
      if (this.mActionBar == null) {
        break label57;
      }
    }
    label57:
    for (Object localObject = this.mActionBar.aD();; localObject = this.mContext)
    {
      this.fX = new androidx.appcompat.view.g((Context)localObject);
      localObject = this.fX;
      AppMethodBeat.o(238219);
      return localObject;
    }
  }
  
  public final ActionBar getSupportActionBar()
  {
    AppMethodBeat.i(238213);
    aM();
    ActionBar localActionBar = this.mActionBar;
    AppMethodBeat.o(238213);
    return localActionBar;
  }
  
  public final void invalidateOptionsMenu()
  {
    AppMethodBeat.i(238265);
    ActionBar localActionBar = getSupportActionBar();
    if ((localActionBar != null) && (localActionBar.aG()))
    {
      AppMethodBeat.o(238265);
      return;
    }
    S(0);
    AppMethodBeat.o(238265);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(238222);
    if ((this.gm) && (this.gh))
    {
      ActionBar localActionBar = getSupportActionBar();
      if (localActionBar != null) {
        localActionBar.onConfigurationChanged(paramConfiguration);
      }
    }
    androidx.appcompat.widget.f.dq().J(this.mContext);
    aK();
    AppMethodBeat.o(238222);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(238211);
    if ((this.fU instanceof Activity)) {}
    try
    {
      Object localObject1 = androidx.core.app.c.g((Activity)this.fU);
      if (localObject1 != null)
      {
        localObject1 = this.mActionBar;
        if (localObject1 == null) {
          this.gB = true;
        }
      }
      else
      {
        if ((paramBundle != null) && (this.gv == -100)) {
          this.gv = paramBundle.getInt("appcompat:local_night_mode", -100);
        }
        AppMethodBeat.o(238211);
        return;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Object localObject2 = null;
        continue;
        localObject2.v(true);
      }
    }
  }
  
  public final View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(238291);
    paramView = a(paramView, paramString, paramContext, paramAttributeSet);
    AppMethodBeat.o(238291);
    return paramView;
  }
  
  public final View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(238292);
    paramString = onCreateView(null, paramString, paramContext, paramAttributeSet);
    AppMethodBeat.o(238292);
    return paramString;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(238240);
    if (this.gy) {
      this.em.getDecorView().removeCallbacks(this.gA);
    }
    this.mIsDestroyed = true;
    if (this.mActionBar != null) {
      this.mActionBar.onDestroy();
    }
    if (this.gx != null) {
      this.gx.cleanup();
    }
    AppMethodBeat.o(238240);
  }
  
  final boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(238276);
    Object localObject = getSupportActionBar();
    if ((localObject != null) && (((ActionBar)localObject).onKeyShortcut(paramInt, paramKeyEvent)))
    {
      AppMethodBeat.o(238276);
      return true;
    }
    if ((this.gt != null) && (a(this.gt, paramKeyEvent.getKeyCode(), paramKeyEvent)))
    {
      if (this.gt != null) {
        this.gt.gY = true;
      }
      AppMethodBeat.o(238276);
      return true;
    }
    if (this.gt == null)
    {
      localObject = R(0);
      b((PanelFeatureState)localObject, paramKeyEvent);
      boolean bool = a((PanelFeatureState)localObject, paramKeyEvent.getKeyCode(), paramKeyEvent);
      ((PanelFeatureState)localObject).gX = false;
      if (bool)
      {
        AppMethodBeat.o(238276);
        return true;
      }
    }
    AppMethodBeat.o(238276);
    return false;
  }
  
  public final void onPostResume()
  {
    AppMethodBeat.i(238228);
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null) {
      localActionBar.w(true);
    }
    AppMethodBeat.o(238228);
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(238238);
    if (this.gv != -100) {
      paramBundle.putInt("appcompat:local_night_mode", this.gv);
    }
    AppMethodBeat.o(238238);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(238224);
    aK();
    AppMethodBeat.o(238224);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(238226);
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null) {
      localActionBar.w(false);
    }
    if (this.gx != null) {
      this.gx.cleanup();
    }
    AppMethodBeat.o(238226);
  }
  
  public final void setContentView(int paramInt)
  {
    AppMethodBeat.i(238232);
    aO();
    ViewGroup localViewGroup = (ViewGroup)this.gi.findViewById(16908290);
    localViewGroup.removeAllViews();
    LayoutInflater.from(this.mContext).inflate(paramInt, localViewGroup);
    this.fU.onContentChanged();
    AppMethodBeat.o(238232);
  }
  
  public final void setContentView(View paramView)
  {
    AppMethodBeat.i(238229);
    aO();
    ViewGroup localViewGroup = (ViewGroup)this.gi.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView);
    this.fU.onContentChanged();
    AppMethodBeat.o(238229);
  }
  
  public final void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(238234);
    aO();
    ViewGroup localViewGroup = (ViewGroup)this.gi.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView, paramLayoutParams);
    this.fU.onContentChanged();
    AppMethodBeat.o(238234);
  }
  
  public final void setSupportActionBar(Toolbar paramToolbar)
  {
    AppMethodBeat.i(238215);
    if (!(this.fU instanceof Activity))
    {
      AppMethodBeat.o(238215);
      return;
    }
    ActionBar localActionBar = getSupportActionBar();
    if ((localActionBar instanceof j))
    {
      paramToolbar = new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
      AppMethodBeat.o(238215);
      throw paramToolbar;
    }
    this.fX = null;
    if (localActionBar != null) {
      localActionBar.onDestroy();
    }
    if (paramToolbar != null)
    {
      paramToolbar = new g(paramToolbar, ((Activity)this.fU).getTitle(), this.fV);
      this.mActionBar = paramToolbar;
      this.em.setCallback(paramToolbar.hv);
    }
    for (;;)
    {
      invalidateOptionsMenu();
      AppMethodBeat.o(238215);
      return;
      this.mActionBar = null;
      this.em.setCallback(this.fV);
    }
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(238254);
    this.cZ = paramCharSequence;
    if (this.fY != null)
    {
      this.fY.setWindowTitle(paramCharSequence);
      AppMethodBeat.o(238254);
      return;
    }
    if (this.mActionBar != null)
    {
      this.mActionBar.setWindowTitle(paramCharSequence);
      AppMethodBeat.o(238254);
      return;
    }
    if (this.eM != null) {
      this.eM.setText(paramCharSequence);
    }
    AppMethodBeat.o(238254);
  }
  
  public final b startSupportActionMode(b.a parama)
  {
    AppMethodBeat.i(238263);
    if (parama == null)
    {
      parama = new IllegalArgumentException("ActionMode callback can not be null.");
      AppMethodBeat.o(238263);
      throw parama;
    }
    if (this.gb != null) {
      this.gb.finish();
    }
    parama = new c(parama);
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null)
    {
      this.gb = localActionBar.a(parama);
      if ((this.gb != null) && (this.fW != null)) {
        this.fW.onSupportActionModeStarted(this.gb);
      }
    }
    if (this.gb == null) {
      this.gb = b(parama);
    }
    parama = this.gb;
    AppMethodBeat.o(238263);
    return parama;
  }
  
  protected static final class PanelFeatureState
  {
    int background;
    int ek;
    int gP;
    int gQ;
    ViewGroup gR;
    View gS;
    View gT;
    h gU;
    androidx.appcompat.view.menu.f gV;
    Context gW;
    boolean gX;
    boolean gY;
    boolean gZ;
    public boolean ha;
    boolean hb;
    boolean hc;
    Bundle hd;
    int x;
    int y;
    
    PanelFeatureState(int paramInt)
    {
      this.gP = paramInt;
      this.hb = false;
    }
    
    final void G(Context paramContext)
    {
      AppMethodBeat.i(238183);
      TypedValue localTypedValue = new TypedValue();
      Resources.Theme localTheme = paramContext.getResources().newTheme();
      localTheme.setTo(paramContext.getTheme());
      localTheme.resolveAttribute(androidx.appcompat.a.a.actionBarPopupTheme, localTypedValue, true);
      if (localTypedValue.resourceId != 0) {
        localTheme.applyStyle(localTypedValue.resourceId, true);
      }
      localTheme.resolveAttribute(androidx.appcompat.a.a.panelMenuListTheme, localTypedValue, true);
      if (localTypedValue.resourceId != 0) {
        localTheme.applyStyle(localTypedValue.resourceId, true);
      }
      for (;;)
      {
        paramContext = new androidx.appcompat.view.d(paramContext, 0);
        paramContext.getTheme().setTo(localTheme);
        this.gW = paramContext;
        paramContext = paramContext.obtainStyledAttributes(a.j.AppCompatTheme);
        this.background = paramContext.getResourceId(a.j.AppCompatTheme_panelBackground, 0);
        this.gQ = paramContext.getResourceId(a.j.AppCompatTheme_android_windowAnimationStyle, 0);
        paramContext.recycle();
        AppMethodBeat.o(238183);
        return;
        localTheme.applyStyle(a.i.Theme_AppCompat_CompactMenu, true);
      }
    }
    
    final p a(o.a parama)
    {
      AppMethodBeat.i(238185);
      if (this.gU == null)
      {
        AppMethodBeat.o(238185);
        return null;
      }
      if (this.gV == null)
      {
        this.gV = new androidx.appcompat.view.menu.f(this.gW, a.g.abc_list_menu_item_layout);
        this.gV.lp = parama;
        this.gU.a(this.gV);
      }
      parama = this.gV.a(this.gR);
      AppMethodBeat.o(238185);
      return parama;
    }
    
    public final boolean ba()
    {
      AppMethodBeat.i(238180);
      if (this.gS == null)
      {
        AppMethodBeat.o(238180);
        return false;
      }
      if (this.gT != null)
      {
        AppMethodBeat.o(238180);
        return true;
      }
      if (this.gV.getAdapter().getCount() > 0)
      {
        AppMethodBeat.o(238180);
        return true;
      }
      AppMethodBeat.o(238180);
      return false;
    }
    
    final void d(h paramh)
    {
      AppMethodBeat.i(238184);
      if (paramh == this.gU)
      {
        AppMethodBeat.o(238184);
        return;
      }
      if (this.gU != null) {
        this.gU.b(this.gV);
      }
      this.gU = paramh;
      if ((paramh != null) && (this.gV != null)) {
        paramh.a(this.gV);
      }
      AppMethodBeat.o(238184);
    }
  }
  
  final class a
    implements a.a
  {
    a() {}
  }
  
  final class b
    implements o.a
  {
    b() {}
    
    public final void a(h paramh, boolean paramBoolean)
    {
      AppMethodBeat.i(238123);
      AppCompatDelegateImpl.this.b(paramh);
      AppMethodBeat.o(238123);
    }
    
    public final boolean c(h paramh)
    {
      AppMethodBeat.i(238122);
      Window.Callback localCallback = AppCompatDelegateImpl.this.em.getCallback();
      if (localCallback != null) {
        localCallback.onMenuOpened(108, paramh);
      }
      AppMethodBeat.o(238122);
      return true;
    }
  }
  
  final class c
    implements b.a
  {
    private b.a gI;
    
    public c(b.a parama)
    {
      this.gI = parama;
    }
    
    public final void a(b paramb)
    {
      AppMethodBeat.i(238133);
      this.gI.a(paramb);
      if (AppCompatDelegateImpl.this.gd != null) {
        AppCompatDelegateImpl.this.em.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.ge);
      }
      if (AppCompatDelegateImpl.this.gc != null)
      {
        AppCompatDelegateImpl.this.aS();
        AppCompatDelegateImpl.this.gf = w.Q(AppCompatDelegateImpl.this.gc).i(0.0F);
        AppCompatDelegateImpl.this.gf.b(new androidx.core.g.ac()
        {
          public final void f(View paramAnonymousView)
          {
            AppMethodBeat.i(238126);
            AppCompatDelegateImpl.this.gc.setVisibility(8);
            if (AppCompatDelegateImpl.this.gd != null) {
              AppCompatDelegateImpl.this.gd.dismiss();
            }
            for (;;)
            {
              AppCompatDelegateImpl.this.gc.removeAllViews();
              AppCompatDelegateImpl.this.gf.b(null);
              AppCompatDelegateImpl.this.gf = null;
              AppMethodBeat.o(238126);
              return;
              if ((AppCompatDelegateImpl.this.gc.getParent() instanceof View)) {
                w.Y((View)AppCompatDelegateImpl.this.gc.getParent());
              }
            }
          }
        });
      }
      if (AppCompatDelegateImpl.this.fW != null) {
        AppCompatDelegateImpl.this.fW.onSupportActionModeFinished(AppCompatDelegateImpl.this.gb);
      }
      AppCompatDelegateImpl.this.gb = null;
      AppMethodBeat.o(238133);
    }
    
    public final boolean a(b paramb, Menu paramMenu)
    {
      AppMethodBeat.i(238130);
      boolean bool = this.gI.a(paramb, paramMenu);
      AppMethodBeat.o(238130);
      return bool;
    }
    
    public final boolean a(b paramb, MenuItem paramMenuItem)
    {
      AppMethodBeat.i(238132);
      boolean bool = this.gI.a(paramb, paramMenuItem);
      AppMethodBeat.o(238132);
      return bool;
    }
    
    public final boolean b(b paramb, Menu paramMenu)
    {
      AppMethodBeat.i(238131);
      boolean bool = this.gI.b(paramb, paramMenu);
      AppMethodBeat.o(238131);
      return bool;
    }
  }
  
  final class d
    extends androidx.appcompat.view.i
  {
    d(Window.Callback paramCallback)
    {
      super();
    }
    
    private ActionMode a(ActionMode.Callback paramCallback)
    {
      AppMethodBeat.i(238155);
      paramCallback = new androidx.appcompat.view.f.a(AppCompatDelegateImpl.this.mContext, paramCallback);
      b localb = AppCompatDelegateImpl.this.startSupportActionMode(paramCallback);
      if (localb != null)
      {
        paramCallback = paramCallback.b(localb);
        AppMethodBeat.o(238155);
        return paramCallback;
      }
      AppMethodBeat.o(238155);
      return null;
    }
    
    public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(238139);
      if ((AppCompatDelegateImpl.this.dispatchKeyEvent(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent)))
      {
        AppMethodBeat.o(238139);
        return true;
      }
      AppMethodBeat.o(238139);
      return false;
    }
    
    public final boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(238142);
      if ((super.dispatchKeyShortcutEvent(paramKeyEvent)) || (AppCompatDelegateImpl.this.onKeyShortcut(paramKeyEvent.getKeyCode(), paramKeyEvent)))
      {
        AppMethodBeat.o(238142);
        return true;
      }
      AppMethodBeat.o(238142);
      return false;
    }
    
    public final void onContentChanged() {}
    
    public final boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
    {
      AppMethodBeat.i(238145);
      if ((paramInt == 0) && (!(paramMenu instanceof h)))
      {
        AppMethodBeat.o(238145);
        return false;
      }
      boolean bool = super.onCreatePanelMenu(paramInt, paramMenu);
      AppMethodBeat.o(238145);
      return bool;
    }
    
    public final boolean onMenuOpened(int paramInt, Menu paramMenu)
    {
      AppMethodBeat.i(238150);
      super.onMenuOpened(paramInt, paramMenu);
      paramMenu = AppCompatDelegateImpl.this;
      if (paramInt == 108)
      {
        paramMenu = paramMenu.getSupportActionBar();
        if (paramMenu != null) {
          paramMenu.x(true);
        }
      }
      AppMethodBeat.o(238150);
      return true;
    }
    
    public final void onPanelClosed(int paramInt, Menu paramMenu)
    {
      AppMethodBeat.i(238152);
      super.onPanelClosed(paramInt, paramMenu);
      AppCompatDelegateImpl.this.Q(paramInt);
      AppMethodBeat.o(238152);
    }
    
    public final boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
    {
      AppMethodBeat.i(238148);
      if ((paramMenu instanceof h)) {}
      for (h localh = (h)paramMenu; (paramInt == 0) && (localh == null); localh = null)
      {
        AppMethodBeat.o(238148);
        return false;
      }
      if (localh != null) {
        localh.mV = true;
      }
      boolean bool = super.onPreparePanel(paramInt, paramView, paramMenu);
      if (localh != null) {
        localh.mV = false;
      }
      AppMethodBeat.o(238148);
      return bool;
    }
    
    public final void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> paramList, Menu paramMenu, int paramInt)
    {
      AppMethodBeat.i(238158);
      AppCompatDelegateImpl.PanelFeatureState localPanelFeatureState = AppCompatDelegateImpl.this.R(0);
      if ((localPanelFeatureState != null) && (localPanelFeatureState.gU != null))
      {
        super.onProvideKeyboardShortcuts(paramList, localPanelFeatureState.gU, paramInt);
        AppMethodBeat.o(238158);
        return;
      }
      super.onProvideKeyboardShortcuts(paramList, paramMenu, paramInt);
      AppMethodBeat.o(238158);
    }
    
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
    {
      AppMethodBeat.i(238154);
      if (Build.VERSION.SDK_INT >= 23)
      {
        AppMethodBeat.o(238154);
        return null;
      }
      if (AppCompatDelegateImpl.this.gg)
      {
        paramCallback = a(paramCallback);
        AppMethodBeat.o(238154);
        return paramCallback;
      }
      paramCallback = super.onWindowStartingActionMode(paramCallback);
      AppMethodBeat.o(238154);
      return paramCallback;
    }
    
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback, int paramInt)
    {
      AppMethodBeat.i(238157);
      if (AppCompatDelegateImpl.this.gg) {}
      switch (paramInt)
      {
      default: 
        paramCallback = super.onWindowStartingActionMode(paramCallback, paramInt);
        AppMethodBeat.o(238157);
        return paramCallback;
      }
      paramCallback = a(paramCallback);
      AppMethodBeat.o(238157);
      return paramCallback;
    }
  }
  
  final class e
  {
    i gK;
    boolean gL;
    private BroadcastReceiver gM;
    private IntentFilter gN;
    
    e(i parami)
    {
      AppMethodBeat.i(238163);
      this.gK = parami;
      this.gL = parami.bd();
      AppMethodBeat.o(238163);
    }
    
    final int aZ()
    {
      AppMethodBeat.i(238165);
      this.gL = this.gK.bd();
      if (this.gL)
      {
        AppMethodBeat.o(238165);
        return 2;
      }
      AppMethodBeat.o(238165);
      return 1;
    }
    
    final void cleanup()
    {
      AppMethodBeat.i(238168);
      if (this.gM != null)
      {
        AppCompatDelegateImpl.this.mContext.unregisterReceiver(this.gM);
        this.gM = null;
      }
      AppMethodBeat.o(238168);
    }
    
    final void setup()
    {
      AppMethodBeat.i(238166);
      cleanup();
      if (this.gM == null) {
        this.gM = new BroadcastReceiver()
        {
          public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(238160);
            paramAnonymousContext = AppCompatDelegateImpl.e.this;
            boolean bool = paramAnonymousContext.gK.bd();
            if (bool != paramAnonymousContext.gL)
            {
              paramAnonymousContext.gL = bool;
              paramAnonymousContext.gG.aK();
            }
            AppMethodBeat.o(238160);
          }
        };
      }
      if (this.gN == null)
      {
        this.gN = new IntentFilter();
        this.gN.addAction("android.intent.action.TIME_SET");
        this.gN.addAction("android.intent.action.TIMEZONE_CHANGED");
        this.gN.addAction("android.intent.action.TIME_TICK");
      }
      AppCompatDelegateImpl.this.mContext.registerReceiver(this.gM, this.gN);
      AppMethodBeat.o(238166);
    }
  }
  
  final class f
    extends ContentFrameLayout
  {
    public f(Context paramContext)
    {
      super();
    }
    
    public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(238169);
      if ((AppCompatDelegateImpl.this.dispatchKeyEvent(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent)))
      {
        AppMethodBeat.o(238169);
        return true;
      }
      AppMethodBeat.o(238169);
      return false;
    }
    
    public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(238170);
      if (paramMotionEvent.getAction() == 0)
      {
        int i = (int)paramMotionEvent.getX();
        int j = (int)paramMotionEvent.getY();
        if ((i < -5) || (j < -5) || (i > getWidth() + 5) || (j > getHeight() + 5)) {}
        for (i = 1; i != 0; i = 0)
        {
          AppCompatDelegateImpl.this.aT();
          AppMethodBeat.o(238170);
          return true;
        }
      }
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(238170);
      return bool;
    }
    
    public final void setBackgroundResource(int paramInt)
    {
      AppMethodBeat.i(238171);
      setBackgroundDrawable(a.m(getContext(), paramInt));
      AppMethodBeat.o(238171);
    }
  }
  
  final class g
    implements o.a
  {
    g() {}
    
    public final void a(h paramh, boolean paramBoolean)
    {
      AppMethodBeat.i(238187);
      h localh = paramh.cl();
      if (localh != paramh) {}
      for (int i = 1;; i = 0)
      {
        AppCompatDelegateImpl localAppCompatDelegateImpl = AppCompatDelegateImpl.this;
        if (i != 0) {
          paramh = localh;
        }
        paramh = localAppCompatDelegateImpl.a(paramh);
        if (paramh == null) {
          break label90;
        }
        if (i == 0) {
          break;
        }
        AppCompatDelegateImpl.this.a(paramh.gP, paramh, localh);
        AppCompatDelegateImpl.this.a(paramh, true);
        AppMethodBeat.o(238187);
        return;
      }
      AppCompatDelegateImpl.this.a(paramh, paramBoolean);
      label90:
      AppMethodBeat.o(238187);
    }
    
    public final boolean c(h paramh)
    {
      AppMethodBeat.i(238188);
      if ((paramh == null) && (AppCompatDelegateImpl.this.gm))
      {
        Window.Callback localCallback = AppCompatDelegateImpl.this.em.getCallback();
        if ((localCallback != null) && (!AppCompatDelegateImpl.this.mIsDestroyed)) {
          localCallback.onMenuOpened(108, paramh);
        }
      }
      AppMethodBeat.o(238188);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.app.AppCompatDelegateImpl
 * JD-Core Version:    0.7.0.1
 */