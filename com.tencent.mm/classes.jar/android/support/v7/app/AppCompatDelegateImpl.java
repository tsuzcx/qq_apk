package android.support.v7.app;

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
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.q;
import android.support.v4.view.ab;
import android.support.v4.view.e.a;
import android.support.v4.view.x;
import android.support.v4.view.z;
import android.support.v4.widget.n;
import android.support.v7.c.a.a;
import android.support.v7.view.b;
import android.support.v7.view.b.a;
import android.support.v7.view.f.a;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.h.a;
import android.support.v7.view.menu.o.a;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.ContentFrameLayout.a;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ViewStubCompat;
import android.support.v7.widget.aa;
import android.support.v7.widget.aa.a;
import android.support.v7.widget.az;
import android.support.v7.widget.be;
import android.support.v7.widget.bh;
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
import java.lang.reflect.Constructor;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

final class AppCompatDelegateImpl
  extends d
  implements h.a, LayoutInflater.Factory2
{
  private static final boolean Yj;
  private static final int[] Yk;
  private static boolean Yl;
  private CharSequence Hd;
  final Window WM;
  private TextView Xl;
  private ViewGroup YA;
  private View YB;
  private boolean YC;
  private boolean YD;
  boolean YE;
  boolean YF;
  boolean YG;
  boolean YH;
  boolean YI;
  private boolean YJ;
  private PanelFeatureState[] YK;
  private PanelFeatureState YL;
  private boolean YM;
  private int YN = -100;
  private boolean YO;
  private e YP;
  boolean YQ;
  int YR;
  private final Runnable YS = new Runnable()
  {
    public final void run()
    {
      if ((AppCompatDelegateImpl.this.YR & 0x1) != 0) {
        AppCompatDelegateImpl.this.bj(0);
      }
      if ((AppCompatDelegateImpl.this.YR & 0x1000) != 0) {
        AppCompatDelegateImpl.this.bj(108);
      }
      AppCompatDelegateImpl.this.YQ = false;
      AppCompatDelegateImpl.this.YR = 0;
    }
  };
  private boolean YT;
  private Rect YU;
  private Rect YV;
  private AppCompatViewInflater YW;
  final Window.Callback Ym;
  final Window.Callback Yn;
  final c Yo;
  MenuInflater Yp;
  private android.support.v7.widget.t Yq;
  private b Yr;
  private g Ys;
  b Yt;
  ActionBarContextView Yu;
  PopupWindow Yv;
  Runnable Yw;
  x Yx = null;
  boolean Yy = true;
  private boolean Yz;
  ActionBar mActionBar;
  final Context mContext;
  boolean mIsDestroyed;
  
  static
  {
    if (Build.VERSION.SDK_INT < 21) {}
    for (boolean bool = true;; bool = false)
    {
      Yj = bool;
      Yk = new int[] { 16842836 };
      if ((Yj) && (!Yl))
      {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
        {
          public final void uncaughtException(Thread paramAnonymousThread, Throwable paramAnonymousThrowable)
          {
            int j = 0;
            int i = j;
            Object localObject;
            if ((paramAnonymousThrowable instanceof Resources.NotFoundException))
            {
              localObject = paramAnonymousThrowable.getMessage();
              i = j;
              if (localObject != null) {
                if (!((String)localObject).contains("drawable"))
                {
                  i = j;
                  if (!((String)localObject).contains("Drawable")) {}
                }
                else
                {
                  i = 1;
                }
              }
            }
            if (i != 0)
            {
              localObject = new Resources.NotFoundException(paramAnonymousThrowable.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
              ((Throwable)localObject).initCause(paramAnonymousThrowable.getCause());
              ((Throwable)localObject).setStackTrace(paramAnonymousThrowable.getStackTrace());
              this.YX.uncaughtException(paramAnonymousThread, (Throwable)localObject);
              return;
            }
            this.YX.uncaughtException(paramAnonymousThread, paramAnonymousThrowable);
          }
        });
        Yl = true;
      }
      return;
    }
  }
  
  AppCompatDelegateImpl(Context paramContext, Window paramWindow, c paramc)
  {
    this.mContext = paramContext;
    this.WM = paramWindow;
    this.Yo = paramc;
    this.Ym = this.WM.getCallback();
    if ((this.Ym instanceof d)) {
      throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }
    this.Yn = new d(this.Ym);
    this.WM.setCallback(this.Yn);
    paramContext = az.a(paramContext, null, Yk);
    paramWindow = paramContext.da(0);
    if (paramWindow != null) {
      this.WM.setBackgroundDrawable(paramWindow);
    }
    paramContext.ayA.recycle();
  }
  
  private View a(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    String str;
    boolean bool;
    if (this.YW == null)
    {
      str = this.mContext.obtainStyledAttributes(android.support.v7.a.a.a.AppCompatTheme).getString(110);
      if ((str == null) || (AppCompatViewInflater.class.getName().equals(str))) {
        this.YW = new AppCompatViewInflater();
      }
    }
    else
    {
      if (!Yj) {
        break label192;
      }
      if (!(paramAttributeSet instanceof XmlPullParser)) {
        break label179;
      }
      if (((XmlPullParser)paramAttributeSet).getDepth() <= 1) {
        break label173;
      }
      bool = true;
    }
    for (;;)
    {
      for (;;)
      {
        return this.YW.createView(paramView, paramString, paramContext, paramAttributeSet, bool, Yj, true, be.ni());
        try
        {
          this.YW = ((AppCompatViewInflater)Class.forName(str).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        catch (Throwable localThrowable)
        {
          new StringBuilder("Failed to instantiate custom view inflater ").append(str).append(". Falling back to default.");
          this.YW = new AppCompatViewInflater();
        }
      }
      break;
      label173:
      bool = false;
      continue;
      label179:
      bool = a((ViewParent)paramView);
      continue;
      label192:
      bool = false;
    }
  }
  
  private void a(PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    int j = -1;
    if ((paramPanelFeatureState.Vp) || (this.mIsDestroyed)) {}
    int i;
    Object localObject;
    label90:
    label95:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (paramPanelFeatureState.Zh == 0) {
            if ((this.mContext.getResources().getConfiguration().screenLayout & 0xF) != 4) {
              break label90;
            }
          }
          for (i = 1; i == 0; i = 0)
          {
            localObject = this.WM.getCallback();
            if ((localObject == null) || (((Window.Callback)localObject).onMenuOpened(paramPanelFeatureState.Zh, paramPanelFeatureState.kC))) {
              break label95;
            }
            a(paramPanelFeatureState, true);
            return;
          }
        }
        localObject = (WindowManager)this.mContext.getSystemService("window");
      } while ((localObject == null) || (!b(paramPanelFeatureState, paramKeyEvent)));
      if ((paramPanelFeatureState.Zi != null) && (!paramPanelFeatureState.Zq)) {
        break label370;
      }
      if (paramPanelFeatureState.Zi != null) {
        break;
      }
      a(paramPanelFeatureState);
    } while (paramPanelFeatureState.Zi == null);
    label158:
    if ((c(paramPanelFeatureState)) && (paramPanelFeatureState.gJ()))
    {
      paramKeyEvent = paramPanelFeatureState.Zj.getLayoutParams();
      if (paramKeyEvent != null) {
        break label406;
      }
      paramKeyEvent = new ViewGroup.LayoutParams(-2, -2);
    }
    label406:
    for (;;)
    {
      i = paramPanelFeatureState.background;
      paramPanelFeatureState.Zi.setBackgroundResource(i);
      ViewParent localViewParent = paramPanelFeatureState.Zj.getParent();
      if ((localViewParent != null) && ((localViewParent instanceof ViewGroup))) {
        ((ViewGroup)localViewParent).removeView(paramPanelFeatureState.Zj);
      }
      paramPanelFeatureState.Zi.addView(paramPanelFeatureState.Zj, paramKeyEvent);
      if (!paramPanelFeatureState.Zj.hasFocus()) {
        paramPanelFeatureState.Zj.requestFocus();
      }
      i = -2;
      for (;;)
      {
        paramPanelFeatureState.Zo = false;
        paramKeyEvent = new WindowManager.LayoutParams(i, -2, paramPanelFeatureState.x, paramPanelFeatureState.y, 1002, 8519680, -3);
        paramKeyEvent.gravity = paramPanelFeatureState.gravity;
        paramKeyEvent.windowAnimations = paramPanelFeatureState.windowAnimations;
        ((WindowManager)localObject).addView(paramPanelFeatureState.Zi, paramKeyEvent);
        paramPanelFeatureState.Vp = true;
        return;
        if ((!paramPanelFeatureState.Zq) || (paramPanelFeatureState.Zi.getChildCount() <= 0)) {
          break label158;
        }
        paramPanelFeatureState.Zi.removeAllViews();
        break label158;
        break;
        label370:
        if (paramPanelFeatureState.Zk != null)
        {
          paramKeyEvent = paramPanelFeatureState.Zk.getLayoutParams();
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
  
  private boolean a(PanelFeatureState paramPanelFeatureState)
  {
    paramPanelFeatureState.X(gx());
    paramPanelFeatureState.Zi = new f(paramPanelFeatureState.Zm);
    paramPanelFeatureState.gravity = 81;
    return true;
  }
  
  private boolean a(PanelFeatureState paramPanelFeatureState, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.isSystem()) {}
    while (((!paramPanelFeatureState.Zn) && (!b(paramPanelFeatureState, paramKeyEvent))) || (paramPanelFeatureState.kC == null)) {
      return false;
    }
    return paramPanelFeatureState.kC.performShortcut(paramInt, paramKeyEvent, 1);
  }
  
  private boolean a(ViewParent paramViewParent)
  {
    if (paramViewParent == null) {
      return false;
    }
    View localView = this.WM.getDecorView();
    for (;;)
    {
      if (paramViewParent == null) {
        return true;
      }
      if ((paramViewParent == localView) || (!(paramViewParent instanceof View)) || (android.support.v4.view.t.aC((View)paramViewParent))) {
        return false;
      }
      paramViewParent = paramViewParent.getParent();
    }
  }
  
  private b b(b.a parama)
  {
    gC();
    if (this.Yt != null) {
      this.Yt.finish();
    }
    if ((this.Yo != null) && (!this.mIsDestroyed)) {}
    for (;;)
    {
      try
      {
        b localb = this.Yo.onWindowStartingSupportActionMode(parama);
        if (localb == null) {
          break label95;
        }
        this.Yt = localb;
        if ((this.Yt != null) && (this.Yo != null)) {
          this.Yo.onSupportActionModeStarted(this.Yt);
        }
        return this.Yt;
      }
      catch (AbstractMethodError localAbstractMethodError) {}
      Object localObject1 = null;
      continue;
      label95:
      Object localObject2;
      label201:
      boolean bool;
      if (this.Yu == null)
      {
        if (!this.YH) {
          break label492;
        }
        localObject2 = new TypedValue();
        localObject1 = this.mContext.getTheme();
        ((Resources.Theme)localObject1).resolveAttribute(2130968606, (TypedValue)localObject2, true);
        if (((TypedValue)localObject2).resourceId != 0)
        {
          Resources.Theme localTheme = this.mContext.getResources().newTheme();
          localTheme.setTo((Resources.Theme)localObject1);
          localTheme.applyStyle(((TypedValue)localObject2).resourceId, true);
          localObject1 = new android.support.v7.view.d(this.mContext, 0);
          ((Context)localObject1).getTheme().setTo(localTheme);
          this.Yu = new ActionBarContextView((Context)localObject1);
          this.Yv = new PopupWindow((Context)localObject1, null, 2130968620);
          n.a(this.Yv, 2);
          this.Yv.setContentView(this.Yu);
          this.Yv.setWidth(-1);
          ((Context)localObject1).getTheme().resolveAttribute(2130968600, (TypedValue)localObject2, true);
          int i = TypedValue.complexToDimensionPixelSize(((TypedValue)localObject2).data, ((Context)localObject1).getResources().getDisplayMetrics());
          this.Yu.setContentHeight(i);
          this.Yv.setHeight(-2);
          this.Yw = new Runnable()
          {
            public final void run()
            {
              AppCompatDelegateImpl.this.Yv.showAtLocation(AppCompatDelegateImpl.this.Yu, 55, 0, 0);
              AppCompatDelegateImpl.this.gC();
              if (AppCompatDelegateImpl.this.gB())
              {
                AppCompatDelegateImpl.this.Yu.setAlpha(0.0F);
                AppCompatDelegateImpl.this.Yx = android.support.v4.view.t.ag(AppCompatDelegateImpl.this.Yu).y(1.0F);
                AppCompatDelegateImpl.this.Yx.a(new z()
                {
                  public final void aH(View paramAnonymous2View)
                  {
                    AppCompatDelegateImpl.this.Yu.setVisibility(0);
                  }
                  
                  public final void aI(View paramAnonymous2View)
                  {
                    AppCompatDelegateImpl.this.Yu.setAlpha(1.0F);
                    AppCompatDelegateImpl.this.Yx.a(null);
                    AppCompatDelegateImpl.this.Yx = null;
                  }
                });
                return;
              }
              AppCompatDelegateImpl.this.Yu.setAlpha(1.0F);
              AppCompatDelegateImpl.this.Yu.setVisibility(0);
            }
          };
        }
      }
      else
      {
        label319:
        if (this.Yu == null) {
          break label537;
        }
        gC();
        this.Yu.ip();
        localObject1 = this.Yu.getContext();
        localObject2 = this.Yu;
        if (this.Yv != null) {
          break label539;
        }
        bool = true;
        label361:
        localObject1 = new android.support.v7.view.e((Context)localObject1, (ActionBarContextView)localObject2, parama, bool);
        if (!parama.a((b)localObject1, ((b)localObject1).getMenu())) {
          break label598;
        }
        ((b)localObject1).invalidate();
        this.Yu.c((b)localObject1);
        this.Yt = ((b)localObject1);
        if (!gB()) {
          break label544;
        }
        this.Yu.setAlpha(0.0F);
        this.Yx = android.support.v4.view.t.ag(this.Yu).y(1.0F);
        this.Yx.a(new z()
        {
          public final void aH(View paramAnonymousView)
          {
            AppCompatDelegateImpl.this.Yu.setVisibility(0);
            AppCompatDelegateImpl.this.Yu.sendAccessibilityEvent(32);
            if ((AppCompatDelegateImpl.this.Yu.getParent() instanceof View)) {
              android.support.v4.view.t.ap((View)AppCompatDelegateImpl.this.Yu.getParent());
            }
          }
          
          public final void aI(View paramAnonymousView)
          {
            AppCompatDelegateImpl.this.Yu.setAlpha(1.0F);
            AppCompatDelegateImpl.this.Yx.a(null);
            AppCompatDelegateImpl.this.Yx = null;
          }
        });
      }
      for (;;)
      {
        if (this.Yv == null) {
          break label596;
        }
        this.WM.getDecorView().post(this.Yw);
        break;
        localObject1 = this.mContext;
        break label201;
        label492:
        localObject1 = (ViewStubCompat)this.YA.findViewById(2131296372);
        if (localObject1 == null) {
          break label319;
        }
        ((ViewStubCompat)localObject1).setLayoutInflater(LayoutInflater.from(gx()));
        this.Yu = ((ActionBarContextView)((ViewStubCompat)localObject1).inflate());
        break label319;
        label537:
        break;
        label539:
        bool = false;
        break label361;
        label544:
        this.Yu.setAlpha(1.0F);
        this.Yu.setVisibility(0);
        this.Yu.sendAccessibilityEvent(32);
        if ((this.Yu.getParent() instanceof View)) {
          android.support.v4.view.t.ap((View)this.Yu.getParent());
        }
      }
      label596:
      continue;
      label598:
      this.Yt = null;
    }
  }
  
  private boolean b(PanelFeatureState paramPanelFeatureState)
  {
    Context localContext = this.mContext;
    TypedValue localTypedValue;
    Resources.Theme localTheme;
    Object localObject1;
    if (((paramPanelFeatureState.Zh == 0) || (paramPanelFeatureState.Zh == 108)) && (this.Yq != null))
    {
      localTypedValue = new TypedValue();
      localTheme = localContext.getTheme();
      localTheme.resolveAttribute(2130968606, localTypedValue, true);
      localObject1 = null;
      if (localTypedValue.resourceId != 0)
      {
        localObject1 = localContext.getResources().newTheme();
        ((Resources.Theme)localObject1).setTo(localTheme);
        ((Resources.Theme)localObject1).applyStyle(localTypedValue.resourceId, true);
        ((Resources.Theme)localObject1).resolveAttribute(2130968607, localTypedValue, true);
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
          break label203;
        }
        localObject1 = new android.support.v7.view.d(localContext, 0);
        ((Context)localObject1).getTheme().setTo((Resources.Theme)localObject2);
      }
    }
    for (;;)
    {
      localObject1 = new h((Context)localObject1);
      ((h)localObject1).a(this);
      paramPanelFeatureState.e((h)localObject1);
      return true;
      localTheme.resolveAttribute(2130968607, localTypedValue, true);
      break;
      label203:
      localObject1 = localContext;
    }
  }
  
  private boolean b(PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    if (this.mIsDestroyed) {
      return false;
    }
    if (paramPanelFeatureState.Zn) {
      return true;
    }
    if ((this.YL != null) && (this.YL != paramPanelFeatureState)) {
      a(this.YL, false);
    }
    Window.Callback localCallback = this.WM.getCallback();
    if (localCallback != null) {
      paramPanelFeatureState.Zk = localCallback.onCreatePanelView(paramPanelFeatureState.Zh);
    }
    if ((paramPanelFeatureState.Zh == 0) || (paramPanelFeatureState.Zh == 108)) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (this.Yq != null)) {
        this.Yq.iu();
      }
      if ((paramPanelFeatureState.Zk != null) || ((i != 0) && ((this.mActionBar instanceof g)))) {
        break label408;
      }
      if ((paramPanelFeatureState.kC != null) && (!paramPanelFeatureState.Zr)) {
        break label278;
      }
      if (paramPanelFeatureState.kC == null)
      {
        b(paramPanelFeatureState);
        if (paramPanelFeatureState.kC == null) {
          break;
        }
      }
      if ((i != 0) && (this.Yq != null))
      {
        if (this.Yr == null) {
          this.Yr = new b();
        }
        this.Yq.a(paramPanelFeatureState.kC, this.Yr);
      }
      paramPanelFeatureState.kC.hR();
      if (localCallback.onCreatePanelMenu(paramPanelFeatureState.Zh, paramPanelFeatureState.kC)) {
        break label273;
      }
      paramPanelFeatureState.e(null);
      if ((i == 0) || (this.Yq == null)) {
        break;
      }
      this.Yq.a(null, this.Yr);
      return false;
    }
    label273:
    paramPanelFeatureState.Zr = false;
    label278:
    paramPanelFeatureState.kC.hR();
    if (paramPanelFeatureState.Zs != null)
    {
      paramPanelFeatureState.kC.g(paramPanelFeatureState.Zs);
      paramPanelFeatureState.Zs = null;
    }
    if (!localCallback.onPreparePanel(0, paramPanelFeatureState.Zk, paramPanelFeatureState.kC))
    {
      if ((i != 0) && (this.Yq != null)) {
        this.Yq.a(null, this.Yr);
      }
      paramPanelFeatureState.kC.hS();
      return false;
    }
    if (paramKeyEvent != null)
    {
      i = paramKeyEvent.getDeviceId();
      if (KeyCharacterMap.load(i).getKeyboardType() == 1) {
        break label430;
      }
    }
    label408:
    label430:
    for (boolean bool = true;; bool = false)
    {
      paramPanelFeatureState.Zp = bool;
      paramPanelFeatureState.kC.setQwertyMode(paramPanelFeatureState.Zp);
      paramPanelFeatureState.kC.hS();
      paramPanelFeatureState.Zn = true;
      paramPanelFeatureState.Zo = false;
      this.YL = paramPanelFeatureState;
      return true;
      i = -1;
      break;
    }
  }
  
  private static int bl(int paramInt)
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
  
  private int bm(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    case 0: 
      if ((Build.VERSION.SDK_INT >= 23) && (((UiModeManager)this.mContext.getSystemService(UiModeManager.class)).getNightMode() == 0)) {
        return -1;
      }
      gG();
      return this.YP.gI();
    }
    return -1;
  }
  
  private boolean bn(int paramInt)
  {
    Resources localResources = this.mContext.getResources();
    Configuration localConfiguration = localResources.getConfiguration();
    int i = localConfiguration.uiMode;
    if (paramInt == 2)
    {
      paramInt = 32;
      if ((i & 0x30) == paramInt) {
        break label116;
      }
      if (!gH()) {
        break label61;
      }
      ((Activity)this.mContext).recreate();
    }
    for (;;)
    {
      return true;
      paramInt = 16;
      break;
      label61:
      localConfiguration = new Configuration(localConfiguration);
      DisplayMetrics localDisplayMetrics = localResources.getDisplayMetrics();
      localConfiguration.uiMode = (paramInt | localConfiguration.uiMode & 0xFFFFFFCF);
      localResources.updateConfiguration(localConfiguration, localDisplayMetrics);
      if (Build.VERSION.SDK_INT < 26) {
        f.a(localResources);
      }
    }
    label116:
    return false;
  }
  
  private boolean c(PanelFeatureState paramPanelFeatureState)
  {
    if (paramPanelFeatureState.Zk != null)
    {
      paramPanelFeatureState.Zj = paramPanelFeatureState.Zk;
      return true;
    }
    if (paramPanelFeatureState.kC == null) {
      return false;
    }
    if (this.Ys == null) {
      this.Ys = new g();
    }
    paramPanelFeatureState.Zj = ((View)paramPanelFeatureState.b(this.Ys));
    return paramPanelFeatureState.Zj != null;
  }
  
  private void gA()
  {
    ContentFrameLayout localContentFrameLayout = (ContentFrameLayout)this.YA.findViewById(16908290);
    Object localObject = this.WM.getDecorView();
    localContentFrameLayout.j(((View)localObject).getPaddingLeft(), ((View)localObject).getPaddingTop(), ((View)localObject).getPaddingRight(), ((View)localObject).getPaddingBottom());
    localObject = this.mContext.obtainStyledAttributes(android.support.v7.a.a.a.AppCompatTheme);
    ((TypedArray)localObject).getValue(118, localContentFrameLayout.getMinWidthMajor());
    ((TypedArray)localObject).getValue(119, localContentFrameLayout.getMinWidthMinor());
    if (((TypedArray)localObject).hasValue(116)) {
      ((TypedArray)localObject).getValue(116, localContentFrameLayout.getFixedWidthMajor());
    }
    if (((TypedArray)localObject).hasValue(117)) {
      ((TypedArray)localObject).getValue(117, localContentFrameLayout.getFixedWidthMinor());
    }
    if (((TypedArray)localObject).hasValue(114)) {
      ((TypedArray)localObject).getValue(114, localContentFrameLayout.getFixedHeightMajor());
    }
    if (((TypedArray)localObject).hasValue(115)) {
      ((TypedArray)localObject).getValue(115, localContentFrameLayout.getFixedHeightMinor());
    }
    ((TypedArray)localObject).recycle();
    localContentFrameLayout.requestLayout();
  }
  
  private void gE()
  {
    if (this.Yz) {
      throw new AndroidRuntimeException("Window feature must be requested before adding content");
    }
  }
  
  private void gG()
  {
    if (this.YP == null) {
      this.YP = new e(i.Y(this.mContext));
    }
  }
  
  private boolean gH()
  {
    PackageManager localPackageManager;
    if ((this.YO) && ((this.mContext instanceof Activity))) {
      localPackageManager = this.mContext.getPackageManager();
    }
    try
    {
      int i = localPackageManager.getActivityInfo(new ComponentName(this.mContext, this.mContext.getClass()), 0).configChanges;
      return (i & 0x200) == 0;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return false;
    return true;
  }
  
  private int getNightMode()
  {
    if (this.YN != -100) {
      return this.YN;
    }
    return d.Yi;
  }
  
  private CharSequence getTitle()
  {
    if ((this.Ym instanceof Activity)) {
      return ((Activity)this.Ym).getTitle();
    }
    return this.Hd;
  }
  
  private void gw()
  {
    gy();
    if ((!this.YE) || (this.mActionBar != null)) {}
    for (;;)
    {
      return;
      if ((this.Ym instanceof Activity)) {
        this.mActionBar = new j((Activity)this.Ym, this.YF);
      }
      while (this.mActionBar != null)
      {
        this.mActionBar.Q(this.YT);
        return;
        if ((this.Ym instanceof Dialog)) {
          this.mActionBar = new j((Dialog)this.Ym);
        }
      }
    }
  }
  
  private Context gx()
  {
    Context localContext = null;
    Object localObject = getSupportActionBar();
    if (localObject != null) {
      localContext = ((ActionBar)localObject).getThemedContext();
    }
    localObject = localContext;
    if (localContext == null) {
      localObject = this.mContext;
    }
    return localObject;
  }
  
  private void gy()
  {
    Object localObject;
    if (!this.Yz)
    {
      this.YA = gz();
      localObject = getTitle();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (this.Yq == null) {
          break label84;
        }
        this.Yq.setWindowTitle((CharSequence)localObject);
      }
    }
    for (;;)
    {
      gA();
      this.Yz = true;
      localObject = bi(0);
      if ((!this.mIsDestroyed) && ((localObject == null) || (((PanelFeatureState)localObject).kC == null))) {
        invalidatePanelMenu(108);
      }
      return;
      label84:
      if (this.mActionBar != null) {
        this.mActionBar.setWindowTitle((CharSequence)localObject);
      } else if (this.Xl != null) {
        this.Xl.setText((CharSequence)localObject);
      }
    }
  }
  
  private ViewGroup gz()
  {
    Object localObject = this.mContext.obtainStyledAttributes(android.support.v7.a.a.a.AppCompatTheme);
    if (!((TypedArray)localObject).hasValue(111))
    {
      ((TypedArray)localObject).recycle();
      throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }
    if (((TypedArray)localObject).getBoolean(120, false))
    {
      requestWindowFeature(1);
      if (((TypedArray)localObject).getBoolean(112, false)) {
        requestWindowFeature(109);
      }
      if (((TypedArray)localObject).getBoolean(113, false)) {
        requestWindowFeature(10);
      }
      this.YH = ((TypedArray)localObject).getBoolean(0, false);
      ((TypedArray)localObject).recycle();
      this.WM.getDecorView();
      localObject = LayoutInflater.from(this.mContext);
      if (this.YI) {
        break label423;
      }
      if (!this.YH) {
        break label261;
      }
      localObject = (ViewGroup)((LayoutInflater)localObject).inflate(2131492903, null);
      this.YF = false;
      this.YE = false;
    }
    for (;;)
    {
      if (localObject == null)
      {
        throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.YE + ", windowActionBarOverlay: " + this.YF + ", android:windowIsFloating: " + this.YH + ", windowActionModeOverlay: " + this.YG + ", windowNoTitle: " + this.YI + " }");
        if (!((TypedArray)localObject).getBoolean(111, false)) {
          break;
        }
        requestWindowFeature(108);
        break;
        label261:
        if (!this.YE) {
          break label631;
        }
        localObject = new TypedValue();
        this.mContext.getTheme().resolveAttribute(2130968606, (TypedValue)localObject, true);
        if (((TypedValue)localObject).resourceId != 0) {}
        for (localObject = new android.support.v7.view.d(this.mContext, ((TypedValue)localObject).resourceId);; localObject = this.mContext)
        {
          localObject = (ViewGroup)LayoutInflater.from((Context)localObject).inflate(2131492914, null);
          this.Yq = ((android.support.v7.widget.t)((ViewGroup)localObject).findViewById(2131298945));
          this.Yq.setWindowCallback(this.WM.getCallback());
          if (this.YF) {
            this.Yq.bv(109);
          }
          if (this.YC) {
            this.Yq.bv(2);
          }
          if (this.YD) {
            this.Yq.bv(5);
          }
          break;
        }
        label423:
        if (this.YG) {}
        for (localObject = (ViewGroup)((LayoutInflater)localObject).inflate(2131492913, null);; localObject = (ViewGroup)((LayoutInflater)localObject).inflate(2131492912, null))
        {
          if (Build.VERSION.SDK_INT < 21) {
            break label480;
          }
          android.support.v4.view.t.a((View)localObject, new android.support.v4.view.p()
          {
            public final ab a(View paramAnonymousView, ab paramAnonymousab)
            {
              int i = paramAnonymousab.getSystemWindowInsetTop();
              int j = AppCompatDelegateImpl.this.bk(i);
              ab localab = paramAnonymousab;
              if (i != j) {
                localab = paramAnonymousab.f(paramAnonymousab.getSystemWindowInsetLeft(), j, paramAnonymousab.getSystemWindowInsetRight(), paramAnonymousab.getSystemWindowInsetBottom());
              }
              return android.support.v4.view.t.a(paramAnonymousView, localab);
            }
          });
          break;
        }
        label480:
        ((aa)localObject).setOnFitSystemWindowsListener(new aa.a()
        {
          public final void f(Rect paramAnonymousRect)
          {
            paramAnonymousRect.top = AppCompatDelegateImpl.this.bk(paramAnonymousRect.top);
          }
        });
        continue;
      }
      if (this.Yq == null) {
        this.Xl = ((TextView)((ViewGroup)localObject).findViewById(2131305902));
      }
      bh.cg((View)localObject);
      ContentFrameLayout localContentFrameLayout = (ContentFrameLayout)((ViewGroup)localObject).findViewById(2131296344);
      ViewGroup localViewGroup = (ViewGroup)this.WM.findViewById(16908290);
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
      this.WM.setContentView((View)localObject);
      localContentFrameLayout.setAttachListener(new ContentFrameLayout.a()
      {
        public final void onDetachedFromWindow()
        {
          AppCompatDelegateImpl.this.gF();
        }
      });
      return localObject;
      label631:
      localObject = null;
    }
  }
  
  private void invalidatePanelMenu(int paramInt)
  {
    this.YR |= 1 << paramInt;
    if (!this.YQ)
    {
      android.support.v4.view.t.b(this.WM.getDecorView(), this.YS);
      this.YQ = true;
    }
  }
  
  final PanelFeatureState a(Menu paramMenu)
  {
    PanelFeatureState[] arrayOfPanelFeatureState = this.YK;
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
      if ((localPanelFeatureState != null) && (localPanelFeatureState.kC == paramMenu))
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
          if (paramInt < this.YK.length) {
            localPanelFeatureState = this.YK[paramInt];
          }
        }
      }
      localObject1 = localPanelFeatureState;
      localObject2 = paramMenu;
      if (localPanelFeatureState != null)
      {
        localObject2 = localPanelFeatureState.kC;
        localObject1 = localPanelFeatureState;
      }
    }
    if ((localObject1 != null) && (!((PanelFeatureState)localObject1).Vp)) {}
    while (this.mIsDestroyed) {
      return;
    }
    this.Ym.onPanelClosed(paramInt, (Menu)localObject2);
  }
  
  final void a(PanelFeatureState paramPanelFeatureState, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramPanelFeatureState.Zh == 0) && (this.Yq != null) && (this.Yq.isOverflowMenuShowing())) {
      c(paramPanelFeatureState.kC);
    }
    do
    {
      return;
      WindowManager localWindowManager = (WindowManager)this.mContext.getSystemService("window");
      if ((localWindowManager != null) && (paramPanelFeatureState.Vp) && (paramPanelFeatureState.Zi != null))
      {
        localWindowManager.removeView(paramPanelFeatureState.Zi);
        if (paramBoolean) {
          a(paramPanelFeatureState.Zh, paramPanelFeatureState, null);
        }
      }
      paramPanelFeatureState.Zn = false;
      paramPanelFeatureState.Zo = false;
      paramPanelFeatureState.Vp = false;
      paramPanelFeatureState.Zj = null;
      paramPanelFeatureState.Zq = true;
    } while (this.YL != paramPanelFeatureState);
    this.YL = null;
  }
  
  public final boolean a(h paramh, MenuItem paramMenuItem)
  {
    Window.Callback localCallback = this.WM.getCallback();
    if ((localCallback != null) && (!this.mIsDestroyed))
    {
      paramh = a(paramh.hY());
      if (paramh != null) {
        return localCallback.onMenuItemSelected(paramh.Zh, paramMenuItem);
      }
    }
    return false;
  }
  
  public final void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    gy();
    ((ViewGroup)this.YA.findViewById(16908290)).addView(paramView, paramLayoutParams);
    this.Ym.onContentChanged();
  }
  
  public final void b(h paramh)
  {
    if ((this.Yq != null) && (this.Yq.is()) && ((!ViewConfiguration.get(this.mContext).hasPermanentMenuKey()) || (this.Yq.it())))
    {
      paramh = this.WM.getCallback();
      if (!this.Yq.isOverflowMenuShowing()) {
        if ((paramh != null) && (!this.mIsDestroyed))
        {
          if ((this.YQ) && ((this.YR & 0x1) != 0))
          {
            this.WM.getDecorView().removeCallbacks(this.YS);
            this.YS.run();
          }
          PanelFeatureState localPanelFeatureState = bi(0);
          if ((localPanelFeatureState.kC != null) && (!localPanelFeatureState.Zr) && (paramh.onPreparePanel(0, localPanelFeatureState.Zk, localPanelFeatureState.kC)))
          {
            paramh.onMenuOpened(108, localPanelFeatureState.kC);
            this.Yq.showOverflowMenu();
          }
        }
      }
      do
      {
        return;
        this.Yq.hideOverflowMenu();
      } while (this.mIsDestroyed);
      paramh.onPanelClosed(108, bi(0).kC);
      return;
    }
    paramh = bi(0);
    paramh.Zq = true;
    a(paramh, false);
    a(paramh, null);
  }
  
  final void bh(int paramInt)
  {
    Object localObject;
    if (paramInt == 108)
    {
      localObject = getSupportActionBar();
      if (localObject != null) {
        ((ActionBar)localObject).S(false);
      }
    }
    do
    {
      do
      {
        return;
      } while (paramInt != 0);
      localObject = bi(paramInt);
    } while (!((PanelFeatureState)localObject).Vp);
    a((PanelFeatureState)localObject, false);
  }
  
  protected final PanelFeatureState bi(int paramInt)
  {
    Object localObject2 = this.YK;
    Object localObject1;
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
      this.YK = ((PanelFeatureState[])localObject1);
    }
    localObject2 = localObject1[paramInt];
    if (localObject2 == null)
    {
      localObject2 = new PanelFeatureState(paramInt);
      localObject1[paramInt] = localObject2;
      return localObject2;
    }
    return localObject2;
  }
  
  final void bj(int paramInt)
  {
    PanelFeatureState localPanelFeatureState = bi(paramInt);
    if (localPanelFeatureState.kC != null)
    {
      Bundle localBundle = new Bundle();
      localPanelFeatureState.kC.f(localBundle);
      if (localBundle.size() > 0) {
        localPanelFeatureState.Zs = localBundle;
      }
      localPanelFeatureState.kC.hR();
      localPanelFeatureState.kC.clear();
    }
    localPanelFeatureState.Zr = true;
    localPanelFeatureState.Zq = true;
    if (((paramInt == 108) || (paramInt == 0)) && (this.Yq != null))
    {
      localPanelFeatureState = bi(0);
      if (localPanelFeatureState != null)
      {
        localPanelFeatureState.Zn = false;
        b(localPanelFeatureState, null);
      }
    }
  }
  
  final int bk(int paramInt)
  {
    int j = 1;
    int m = 0;
    Object localObject1;
    Object localObject2;
    int i;
    if ((this.Yu != null) && ((this.Yu.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      localObject1 = (ViewGroup.MarginLayoutParams)this.Yu.getLayoutParams();
      if (this.Yu.isShown())
      {
        if (this.YU == null)
        {
          this.YU = new Rect();
          this.YV = new Rect();
        }
        localObject2 = this.YU;
        Rect localRect = this.YV;
        ((Rect)localObject2).set(0, paramInt, 0, 0);
        bh.a(this.YA, (Rect)localObject2, localRect);
        if (localRect.top == 0)
        {
          i = paramInt;
          if (((ViewGroup.MarginLayoutParams)localObject1).topMargin == i) {
            break label351;
          }
          ((ViewGroup.MarginLayoutParams)localObject1).topMargin = paramInt;
          if (this.YB != null) {
            break label274;
          }
          this.YB = new View(this.mContext);
          this.YB.setBackgroundColor(this.mContext.getResources().getColor(2131099852));
          this.YA.addView(this.YB, -1, new ViewGroup.LayoutParams(-1, paramInt));
          i = 1;
          label198:
          if (this.YB == null) {
            break label312;
          }
          label205:
          int k = paramInt;
          if (!this.YG)
          {
            k = paramInt;
            if (j != 0) {
              k = 0;
            }
          }
          paramInt = k;
          label228:
          if (i != 0) {
            this.Yu.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
        }
      }
    }
    for (;;)
    {
      if (this.YB != null)
      {
        localObject1 = this.YB;
        if (j == 0) {
          break label338;
        }
      }
      label274:
      label312:
      label338:
      for (i = m;; i = 8)
      {
        ((View)localObject1).setVisibility(i);
        return paramInt;
        i = 0;
        break;
        localObject2 = this.YB.getLayoutParams();
        if (((ViewGroup.LayoutParams)localObject2).height != paramInt)
        {
          ((ViewGroup.LayoutParams)localObject2).height = paramInt;
          this.YB.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        i = 1;
        break label198;
        j = 0;
        break label205;
        if (((ViewGroup.MarginLayoutParams)localObject1).topMargin == 0) {
          break label344;
        }
        ((ViewGroup.MarginLayoutParams)localObject1).topMargin = 0;
        i = 1;
        j = 0;
        break label228;
      }
      label344:
      i = 0;
      j = 0;
      break label228;
      label351:
      i = 0;
      break label198;
      j = 0;
    }
  }
  
  final void c(h paramh)
  {
    if (this.YJ) {
      return;
    }
    this.YJ = true;
    this.Yq.gF();
    Window.Callback localCallback = this.WM.getCallback();
    if ((localCallback != null) && (!this.mIsDestroyed)) {
      localCallback.onPanelClosed(108, paramh);
    }
    this.YJ = false;
  }
  
  final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (((this.Ym instanceof e.a)) || ((this.Ym instanceof e)))
    {
      localObject = this.WM.getDecorView();
      if ((localObject == null) || (!android.support.v4.view.e.a((View)localObject, paramKeyEvent))) {}
    }
    int i;
    label208:
    do
    {
      int j;
      do
      {
        do
        {
          do
          {
            return true;
          } while ((paramKeyEvent.getKeyCode() == 82) && (this.Ym.dispatchKeyEvent(paramKeyEvent)));
          j = paramKeyEvent.getKeyCode();
          if (paramKeyEvent.getAction() == 0) {}
          for (i = 1; i != 0; i = 0) {
            switch (j)
            {
            default: 
              return false;
            }
          }
        } while (paramKeyEvent.getRepeatCount() != 0);
        localObject = bi(0);
      } while (((PanelFeatureState)localObject).Vp);
      b((PanelFeatureState)localObject, paramKeyEvent);
      return true;
      if ((paramKeyEvent.getFlags() & 0x80) != 0) {}
      for (bool = true;; bool = false)
      {
        this.YM = bool;
        break;
      }
      switch (j)
      {
      default: 
        return false;
      }
    } while (this.Yt != null);
    Object localObject = bi(0);
    if ((this.Yq != null) && (this.Yq.is()) && (!ViewConfiguration.get(this.mContext).hasPermanentMenuKey())) {
      if (!this.Yq.isOverflowMenuShowing())
      {
        if ((this.mIsDestroyed) || (!b((PanelFeatureState)localObject, paramKeyEvent))) {
          break label511;
        }
        bool = this.Yq.showOverflowMenu();
      }
    }
    label296:
    while (bool)
    {
      paramKeyEvent = (AudioManager)this.mContext.getSystemService("audio");
      if (paramKeyEvent == null) {
        break;
      }
      paramKeyEvent.playSoundEffect(0);
      return true;
      bool = this.Yq.hideOverflowMenu();
      continue;
      if ((!((PanelFeatureState)localObject).Vp) && (!((PanelFeatureState)localObject).Zo)) {
        break label373;
      }
      bool = ((PanelFeatureState)localObject).Vp;
      a((PanelFeatureState)localObject, true);
    }
    label373:
    if (((PanelFeatureState)localObject).Zn)
    {
      if (!((PanelFeatureState)localObject).Zr) {
        break label517;
      }
      ((PanelFeatureState)localObject).Zn = false;
    }
    label517:
    for (boolean bool = b((PanelFeatureState)localObject, paramKeyEvent);; bool = true)
    {
      if (bool)
      {
        a((PanelFeatureState)localObject, paramKeyEvent);
        bool = true;
        break label296;
        bool = this.YM;
        this.YM = false;
        paramKeyEvent = bi(0);
        if ((paramKeyEvent != null) && (paramKeyEvent.Vp))
        {
          if (bool) {
            break;
          }
          a(paramKeyEvent, true);
          return true;
        }
        if (this.Yt != null)
        {
          this.Yt.finish();
          i = 1;
        }
        while (i != 0)
        {
          return true;
          paramKeyEvent = getSupportActionBar();
          if ((paramKeyEvent != null) && (paramKeyEvent.collapseActionView())) {
            i = 1;
          } else {
            i = 0;
          }
        }
        break label208;
      }
      label511:
      bool = false;
      break label296;
    }
  }
  
  public final <T extends View> T findViewById(int paramInt)
  {
    gy();
    return this.WM.findViewById(paramInt);
  }
  
  final boolean gB()
  {
    return (this.Yz) && (this.YA != null) && (android.support.v4.view.t.ay(this.YA));
  }
  
  final void gC()
  {
    if (this.Yx != null) {
      this.Yx.cancel();
    }
  }
  
  final void gD()
  {
    a(bi(0), true);
  }
  
  final void gF()
  {
    if (this.Yq != null) {
      this.Yq.gF();
    }
    if (this.Yv != null)
    {
      this.WM.getDecorView().removeCallbacks(this.Yw);
      if (!this.Yv.isShowing()) {}
    }
    try
    {
      this.Yv.dismiss();
      label55:
      this.Yv = null;
      gC();
      PanelFeatureState localPanelFeatureState = bi(0);
      if ((localPanelFeatureState != null) && (localPanelFeatureState.kC != null)) {
        localPanelFeatureState.kC.close();
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label55;
    }
  }
  
  public final a.a getDrawerToggleDelegate()
  {
    return new a();
  }
  
  public final MenuInflater getMenuInflater()
  {
    if (this.Yp == null)
    {
      gw();
      if (this.mActionBar == null) {
        break label43;
      }
    }
    label43:
    for (Context localContext = this.mActionBar.getThemedContext();; localContext = this.mContext)
    {
      this.Yp = new android.support.v7.view.g(localContext);
      return this.Yp;
    }
  }
  
  public final ActionBar getSupportActionBar()
  {
    gw();
    return this.mActionBar;
  }
  
  public final void gt()
  {
    gy();
  }
  
  public final void gu()
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.mContext);
    if (localLayoutInflater.getFactory() == null)
    {
      android.support.v4.view.f.b(localLayoutInflater, this);
      return;
    }
    localLayoutInflater.getFactory2();
  }
  
  public final boolean gv()
  {
    boolean bool = false;
    int i = getNightMode();
    int j = bm(i);
    if (j != -1) {
      bool = bn(j);
    }
    if (i == 0)
    {
      gG();
      this.YP.setup();
    }
    this.YO = true;
    return bool;
  }
  
  public final void invalidateOptionsMenu()
  {
    ActionBar localActionBar = getSupportActionBar();
    if ((localActionBar != null) && (localActionBar.gr())) {
      return;
    }
    invalidatePanelMenu(0);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    if ((this.YE) && (this.Yz))
    {
      ActionBar localActionBar = getSupportActionBar();
      if (localActionBar != null) {
        localActionBar.onConfigurationChanged(paramConfiguration);
      }
    }
    android.support.v7.widget.g.jb().aa(this.mContext);
    gv();
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    if ((this.Ym instanceof Activity)) {}
    try
    {
      Object localObject1 = q.i((Activity)this.Ym);
      if (localObject1 != null)
      {
        localObject1 = this.mActionBar;
        if (localObject1 == null) {
          this.YT = true;
        }
      }
      else
      {
        if ((paramBundle != null) && (this.YN == -100)) {
          this.YN = paramBundle.getInt("appcompat:local_night_mode", -100);
        }
        return;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Object localObject2 = null;
        continue;
        localObject2.Q(true);
      }
    }
  }
  
  public final View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return a(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  public final View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return onCreateView(null, paramString, paramContext, paramAttributeSet);
  }
  
  public final void onDestroy()
  {
    if (this.YQ) {
      this.WM.getDecorView().removeCallbacks(this.YS);
    }
    this.mIsDestroyed = true;
    if (this.mActionBar != null) {
      this.mActionBar.onDestroy();
    }
    if (this.YP != null) {
      this.YP.cleanup();
    }
  }
  
  final boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    Object localObject = getSupportActionBar();
    if ((localObject != null) && (((ActionBar)localObject).onKeyShortcut(paramInt, paramKeyEvent))) {}
    boolean bool;
    do
    {
      do
      {
        return true;
        if ((this.YL == null) || (!a(this.YL, paramKeyEvent.getKeyCode(), paramKeyEvent))) {
          break;
        }
      } while (this.YL == null);
      this.YL.Zo = true;
      return true;
      if (this.YL != null) {
        break;
      }
      localObject = bi(0);
      b((PanelFeatureState)localObject, paramKeyEvent);
      bool = a((PanelFeatureState)localObject, paramKeyEvent.getKeyCode(), paramKeyEvent);
      ((PanelFeatureState)localObject).Zn = false;
    } while (bool);
    return false;
  }
  
  public final void onPostResume()
  {
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null) {
      localActionBar.R(true);
    }
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    if (this.YN != -100) {
      paramBundle.putInt("appcompat:local_night_mode", this.YN);
    }
  }
  
  public final void onStart()
  {
    gv();
  }
  
  public final void onStop()
  {
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null) {
      localActionBar.R(false);
    }
    if (this.YP != null) {
      this.YP.cleanup();
    }
  }
  
  public final boolean requestWindowFeature(int paramInt)
  {
    paramInt = bl(paramInt);
    if ((this.YI) && (paramInt == 108)) {
      return false;
    }
    if ((this.YE) && (paramInt == 1)) {
      this.YE = false;
    }
    switch (paramInt)
    {
    default: 
      return this.WM.requestFeature(paramInt);
    case 108: 
      gE();
      this.YE = true;
      return true;
    case 109: 
      gE();
      this.YF = true;
      return true;
    case 10: 
      gE();
      this.YG = true;
      return true;
    case 2: 
      gE();
      this.YC = true;
      return true;
    case 5: 
      gE();
      this.YD = true;
      return true;
    }
    gE();
    this.YI = true;
    return true;
  }
  
  public final void setContentView(int paramInt)
  {
    gy();
    ViewGroup localViewGroup = (ViewGroup)this.YA.findViewById(16908290);
    localViewGroup.removeAllViews();
    LayoutInflater.from(this.mContext).inflate(paramInt, localViewGroup);
    this.Ym.onContentChanged();
  }
  
  public final void setContentView(View paramView)
  {
    gy();
    ViewGroup localViewGroup = (ViewGroup)this.YA.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView);
    this.Ym.onContentChanged();
  }
  
  public final void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    gy();
    ViewGroup localViewGroup = (ViewGroup)this.YA.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView, paramLayoutParams);
    this.Ym.onContentChanged();
  }
  
  public final void setSupportActionBar(Toolbar paramToolbar)
  {
    if (!(this.Ym instanceof Activity)) {
      return;
    }
    ActionBar localActionBar = getSupportActionBar();
    if ((localActionBar instanceof j)) {
      throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
    }
    this.Yp = null;
    if (localActionBar != null) {
      localActionBar.onDestroy();
    }
    if (paramToolbar != null)
    {
      paramToolbar = new g(paramToolbar, ((Activity)this.Ym).getTitle(), this.Yn);
      this.mActionBar = paramToolbar;
      this.WM.setCallback(paramToolbar.ZJ);
    }
    for (;;)
    {
      invalidateOptionsMenu();
      return;
      this.mActionBar = null;
      this.WM.setCallback(this.Yn);
    }
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    this.Hd = paramCharSequence;
    if (this.Yq != null) {
      this.Yq.setWindowTitle(paramCharSequence);
    }
    do
    {
      return;
      if (this.mActionBar != null)
      {
        this.mActionBar.setWindowTitle(paramCharSequence);
        return;
      }
    } while (this.Xl == null);
    this.Xl.setText(paramCharSequence);
  }
  
  public final b startSupportActionMode(b.a parama)
  {
    if (parama == null) {
      throw new IllegalArgumentException("ActionMode callback can not be null.");
    }
    if (this.Yt != null) {
      this.Yt.finish();
    }
    parama = new c(parama);
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null)
    {
      this.Yt = localActionBar.a(parama);
      if ((this.Yt != null) && (this.Yo != null)) {
        this.Yo.onSupportActionModeStarted(this.Yt);
      }
    }
    if (this.Yt == null) {
      this.Yt = b(parama);
    }
    return this.Yt;
  }
  
  protected static final class PanelFeatureState
  {
    boolean Vp;
    int Zh;
    ViewGroup Zi;
    View Zj;
    View Zk;
    android.support.v7.view.menu.f Zl;
    Context Zm;
    boolean Zn;
    boolean Zo;
    public boolean Zp;
    boolean Zq;
    boolean Zr;
    Bundle Zs;
    int background;
    int gravity;
    h kC;
    int windowAnimations;
    int x;
    int y;
    
    PanelFeatureState(int paramInt)
    {
      this.Zh = paramInt;
      this.Zq = false;
    }
    
    final void X(Context paramContext)
    {
      TypedValue localTypedValue = new TypedValue();
      Resources.Theme localTheme = paramContext.getResources().newTheme();
      localTheme.setTo(paramContext.getTheme());
      localTheme.resolveAttribute(2130968599, localTypedValue, true);
      if (localTypedValue.resourceId != 0) {
        localTheme.applyStyle(localTypedValue.resourceId, true);
      }
      localTheme.resolveAttribute(2130969365, localTypedValue, true);
      if (localTypedValue.resourceId != 0) {
        localTheme.applyStyle(localTypedValue.resourceId, true);
      }
      for (;;)
      {
        paramContext = new android.support.v7.view.d(paramContext, 0);
        paramContext.getTheme().setTo(localTheme);
        this.Zm = paramContext;
        paramContext = paramContext.obtainStyledAttributes(android.support.v7.a.a.a.AppCompatTheme);
        this.background = paramContext.getResourceId(80, 0);
        this.windowAnimations = paramContext.getResourceId(1, 0);
        paramContext.recycle();
        return;
        localTheme.applyStyle(2131821414, true);
      }
    }
    
    final android.support.v7.view.menu.p b(o.a parama)
    {
      if (this.kC == null) {
        return null;
      }
      if (this.Zl == null)
      {
        this.Zl = new android.support.v7.view.menu.f(this.Zm);
        this.Zl.aeT = parama;
        this.kC.a(this.Zl);
      }
      return this.Zl.c(this.Zi);
    }
    
    final void e(h paramh)
    {
      if (paramh == this.kC) {}
      do
      {
        return;
        if (this.kC != null) {
          this.kC.b(this.Zl);
        }
        this.kC = paramh;
      } while ((paramh == null) || (this.Zl == null));
      paramh.a(this.Zl);
    }
    
    public final boolean gJ()
    {
      if (this.Zj == null) {}
      do
      {
        return false;
        if (this.Zk != null) {
          return true;
        }
      } while (this.Zl.getAdapter().getCount() <= 0);
      return true;
    }
  }
  
  final class a
    implements a.a
  {
    a() {}
    
    public final void bg(int paramInt)
    {
      ActionBar localActionBar = AppCompatDelegateImpl.this.getSupportActionBar();
      if (localActionBar != null) {
        localActionBar.setHomeActionContentDescription(paramInt);
      }
    }
  }
  
  final class b
    implements o.a
  {
    b() {}
    
    public final void a(h paramh, boolean paramBoolean)
    {
      AppCompatDelegateImpl.this.c(paramh);
    }
    
    public final boolean d(h paramh)
    {
      Window.Callback localCallback = AppCompatDelegateImpl.this.WM.getCallback();
      if (localCallback != null) {
        localCallback.onMenuOpened(108, paramh);
      }
      return true;
    }
  }
  
  final class c
    implements b.a
  {
    private b.a Za;
    
    public c(b.a parama)
    {
      this.Za = parama;
    }
    
    public final void a(b paramb)
    {
      this.Za.a(paramb);
      if (AppCompatDelegateImpl.this.Yv != null) {
        AppCompatDelegateImpl.this.WM.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.Yw);
      }
      if (AppCompatDelegateImpl.this.Yu != null)
      {
        AppCompatDelegateImpl.this.gC();
        AppCompatDelegateImpl.this.Yx = android.support.v4.view.t.ag(AppCompatDelegateImpl.this.Yu).y(0.0F);
        AppCompatDelegateImpl.this.Yx.a(new z()
        {
          public final void aI(View paramAnonymousView)
          {
            AppCompatDelegateImpl.this.Yu.setVisibility(8);
            if (AppCompatDelegateImpl.this.Yv != null) {
              AppCompatDelegateImpl.this.Yv.dismiss();
            }
            for (;;)
            {
              AppCompatDelegateImpl.this.Yu.removeAllViews();
              AppCompatDelegateImpl.this.Yx.a(null);
              AppCompatDelegateImpl.this.Yx = null;
              return;
              if ((AppCompatDelegateImpl.this.Yu.getParent() instanceof View)) {
                android.support.v4.view.t.ap((View)AppCompatDelegateImpl.this.Yu.getParent());
              }
            }
          }
        });
      }
      if (AppCompatDelegateImpl.this.Yo != null) {
        AppCompatDelegateImpl.this.Yo.onSupportActionModeFinished(AppCompatDelegateImpl.this.Yt);
      }
      AppCompatDelegateImpl.this.Yt = null;
    }
    
    public final boolean a(b paramb, Menu paramMenu)
    {
      return this.Za.a(paramb, paramMenu);
    }
    
    public final boolean a(b paramb, MenuItem paramMenuItem)
    {
      return this.Za.a(paramb, paramMenuItem);
    }
    
    public final boolean b(b paramb, Menu paramMenu)
    {
      return this.Za.b(paramb, paramMenu);
    }
  }
  
  final class d
    extends android.support.v7.view.i
  {
    d(Window.Callback paramCallback)
    {
      super();
    }
    
    private ActionMode a(ActionMode.Callback paramCallback)
    {
      paramCallback = new f.a(AppCompatDelegateImpl.this.mContext, paramCallback);
      b localb = AppCompatDelegateImpl.this.startSupportActionMode(paramCallback);
      if (localb != null) {
        return paramCallback.b(localb);
      }
      return null;
    }
    
    public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
    {
      return (AppCompatDelegateImpl.this.dispatchKeyEvent(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent));
    }
    
    public final boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
    {
      return (super.dispatchKeyShortcutEvent(paramKeyEvent)) || (AppCompatDelegateImpl.this.onKeyShortcut(paramKeyEvent.getKeyCode(), paramKeyEvent));
    }
    
    public final void onContentChanged() {}
    
    public final boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
    {
      if ((paramInt == 0) && (!(paramMenu instanceof h))) {
        return false;
      }
      return super.onCreatePanelMenu(paramInt, paramMenu);
    }
    
    public final boolean onMenuOpened(int paramInt, Menu paramMenu)
    {
      super.onMenuOpened(paramInt, paramMenu);
      paramMenu = AppCompatDelegateImpl.this;
      if (paramInt == 108)
      {
        paramMenu = paramMenu.getSupportActionBar();
        if (paramMenu != null) {
          paramMenu.S(true);
        }
      }
      return true;
    }
    
    public final void onPanelClosed(int paramInt, Menu paramMenu)
    {
      super.onPanelClosed(paramInt, paramMenu);
      AppCompatDelegateImpl.this.bh(paramInt);
    }
    
    public final boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
    {
      h localh;
      boolean bool1;
      if ((paramMenu instanceof h))
      {
        localh = (h)paramMenu;
        if ((paramInt != 0) || (localh != null)) {
          break label34;
        }
        bool1 = false;
      }
      label34:
      boolean bool2;
      do
      {
        return bool1;
        localh = null;
        break;
        if (localh != null) {
          localh.agx = true;
        }
        bool2 = super.onPreparePanel(paramInt, paramView, paramMenu);
        bool1 = bool2;
      } while (localh == null);
      localh.agx = false;
      return bool2;
    }
    
    public final void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> paramList, Menu paramMenu, int paramInt)
    {
      AppCompatDelegateImpl.PanelFeatureState localPanelFeatureState = AppCompatDelegateImpl.this.bi(0);
      if ((localPanelFeatureState != null) && (localPanelFeatureState.kC != null))
      {
        super.onProvideKeyboardShortcuts(paramList, localPanelFeatureState.kC, paramInt);
        return;
      }
      super.onProvideKeyboardShortcuts(paramList, paramMenu, paramInt);
    }
    
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
    {
      if (Build.VERSION.SDK_INT >= 23) {
        return null;
      }
      if (AppCompatDelegateImpl.this.Yy) {
        return a(paramCallback);
      }
      return super.onWindowStartingActionMode(paramCallback);
    }
    
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback, int paramInt)
    {
      if (AppCompatDelegateImpl.this.Yy) {}
      switch (paramInt)
      {
      default: 
        return super.onWindowStartingActionMode(paramCallback, paramInt);
      }
      return a(paramCallback);
    }
  }
  
  final class e
  {
    i Zc;
    boolean Zd;
    private BroadcastReceiver Ze;
    private IntentFilter Zf;
    
    e(i parami)
    {
      this.Zc = parami;
      this.Zd = parami.gM();
    }
    
    final void cleanup()
    {
      if (this.Ze != null)
      {
        AppCompatDelegateImpl.this.mContext.unregisterReceiver(this.Ze);
        this.Ze = null;
      }
    }
    
    final int gI()
    {
      this.Zd = this.Zc.gM();
      if (this.Zd) {
        return 2;
      }
      return 1;
    }
    
    final void setup()
    {
      cleanup();
      if (this.Ze == null) {
        this.Ze = new BroadcastReceiver()
        {
          public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
          {
            paramAnonymousContext = AppCompatDelegateImpl.e.this;
            boolean bool = paramAnonymousContext.Zc.gM();
            if (bool != paramAnonymousContext.Zd)
            {
              paramAnonymousContext.Zd = bool;
              paramAnonymousContext.YY.gv();
            }
          }
        };
      }
      if (this.Zf == null)
      {
        this.Zf = new IntentFilter();
        this.Zf.addAction("android.intent.action.TIME_SET");
        this.Zf.addAction("android.intent.action.TIMEZONE_CHANGED");
        this.Zf.addAction("android.intent.action.TIME_TICK");
      }
      AppCompatDelegateImpl.this.mContext.registerReceiver(this.Ze, this.Zf);
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
      return (AppCompatDelegateImpl.this.dispatchKeyEvent(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent));
    }
    
    public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      if (paramMotionEvent.getAction() == 0)
      {
        int i = (int)paramMotionEvent.getX();
        int j = (int)paramMotionEvent.getY();
        if ((i < -5) || (j < -5) || (i > getWidth() + 5) || (j > getHeight() + 5)) {}
        for (i = 1; i != 0; i = 0)
        {
          AppCompatDelegateImpl.this.gD();
          return true;
        }
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    
    public final void setBackgroundResource(int paramInt)
    {
      setBackgroundDrawable(a.l(getContext(), paramInt));
    }
  }
  
  final class g
    implements o.a
  {
    g() {}
    
    public final void a(h paramh, boolean paramBoolean)
    {
      h localh = paramh.hY();
      if (localh != paramh) {}
      for (int i = 1;; i = 0)
      {
        AppCompatDelegateImpl localAppCompatDelegateImpl = AppCompatDelegateImpl.this;
        if (i != 0) {
          paramh = localh;
        }
        paramh = localAppCompatDelegateImpl.a(paramh);
        if (paramh != null)
        {
          if (i == 0) {
            break;
          }
          AppCompatDelegateImpl.this.a(paramh.Zh, paramh, localh);
          AppCompatDelegateImpl.this.a(paramh, true);
        }
        return;
      }
      AppCompatDelegateImpl.this.a(paramh, paramBoolean);
    }
    
    public final boolean d(h paramh)
    {
      if ((paramh == null) && (AppCompatDelegateImpl.this.YE))
      {
        Window.Callback localCallback = AppCompatDelegateImpl.this.WM.getCallback();
        if ((localCallback != null) && (!AppCompatDelegateImpl.this.mIsDestroyed)) {
          localCallback.onMenuOpened(108, paramh);
        }
      }
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.app.AppCompatDelegateImpl
 * JD-Core Version:    0.7.0.1
 */